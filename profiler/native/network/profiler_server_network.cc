/*
 * Copyright (C) 2016 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
#include "profiler_server_network.h"

#include "network/connection_data_collector.h"
#include "network/traffic_data_collector.h"
#include "proto/profiler.pb.h"
#include "utils/stopwatch.h"

#include <unistd.h>

using profiler::utils::Stopwatch;

namespace profiler {
namespace network {

ProfilerServerNetwork::~ProfilerServerNetwork() {
  if (is_running_) {
    StopProfile();
  }
}

void ProfilerServerNetwork::StartProfile() {
  if (collectors_.empty()) {
    CreateCollectors();
  }
  if (!is_running_.exchange(true)) {
    profiler_thread_ = std::thread(Profile, this);
  }
}

void ProfilerServerNetwork::StopProfile() {
  if (is_running_.exchange(false)) {
    profiler_thread_.join();
  }
}

void ProfilerServerNetwork::Profile(ProfilerServerNetwork *profiler) {
  Stopwatch stopwatch;
  while (profiler->is_running_.load()) {
    for (const auto &collector : profiler->collectors_) {
      profiler::proto::ProfilerData response;
      collector->GetData(response.mutable_network_data());
      response.set_end_timestamp(stopwatch.GetElapsed());
      profiler->service_->save(response);
    }
    usleep(kSleepMicroseconds);
  }
}

void ProfilerServerNetwork::CreateCollectors() {
  std::string uid;
  bool has_uid = NetworkDataCollector::GetUidString(
      NetworkFiles::GetPidStatusFilePath(pid_), &uid);
  if (has_uid) {
    collectors_.emplace_back(
        new TrafficDataCollector(uid, NetworkFiles::GetTrafficBytesFilePath()));
    collectors_.emplace_back(new ConnectionDataCollector(
        uid, NetworkFiles::GetConnectionFilePaths()));
  }
}

} // network
} // profiler
