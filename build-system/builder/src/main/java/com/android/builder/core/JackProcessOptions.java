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

package com.android.builder.core;

import com.android.annotations.NonNull;
import com.android.annotations.Nullable;
import com.android.repository.Revision;
import com.google.common.base.Objects;
import com.google.common.collect.ImmutableList;

import java.io.File;
import java.util.Collection;
import java.util.List;

/**
 * Options for configuring Jack compilation.
 */
public class JackProcessOptions {

    static final Revision JACK_MIN_REV = new Revision(24, 0, 0);

    private boolean mDebugLog = false;
    private boolean mVerbose = false;
    @NonNull
    private List<File> mClasspaths = ImmutableList.of();
    @Nullable
    private File mDexOutputDirectory = null;
    @Nullable
    private File mOutputFile = null;
    @NonNull
    private List<File> mImportFiles = ImmutableList.of();
    @NonNull
    private List<File> mProguardFiles = ImmutableList.of();
    @Nullable
    private String mJavaMaxHeapSize = null;
    @Nullable
    private File mMappingFile = null;
    private boolean mMultiDex;
    private int mMinSdkVersion;
    @NonNull
    private List<File> mResourceDirectories = ImmutableList.of();
    @NonNull
    private List<File> mInputFiles = ImmutableList.of();
    @Nullable
    private File mEcjOptionFile = null;
    @NonNull
    private List<File> mJarJarRuleFiles = ImmutableList.of();
    @Nullable
    private String mSourceCompatibility = null;
    @Nullable
    private File mIncrementalDir = null;

    public boolean isDebugLog() {
        return mDebugLog;
    }

    public void setDebugLog(boolean debugLog) {
        mDebugLog = debugLog;
    }

    public boolean isVerbose() {
        return mVerbose;
    }

    public void setVerbose(boolean verbose) {
        mVerbose = verbose;
    }

    @NonNull
    public List<File> getClasspaths() {
        return mClasspaths;
    }

    public void setClasspaths(@NonNull Collection<File> classpaths) {
        mClasspaths = ImmutableList.copyOf(classpaths);
    }

    @Nullable
    public File getDexOutputDirectory() {
        return mDexOutputDirectory;
    }

    public void setDexOutputDirectory(@Nullable File dexOutputDirectory) {
        mDexOutputDirectory = dexOutputDirectory;
    }

    @Nullable
    public File getOutputFile() {
        return mOutputFile;
    }

    public void setOutputFile(@Nullable File outputFile) {
        mOutputFile = outputFile;
    }

    @NonNull
    public List<File> getImportFiles() {
        return mImportFiles;
    }

    public void setImportFiles(@NonNull Collection<File> importFiles) {
        mImportFiles = ImmutableList.copyOf(importFiles);
    }

    @NonNull
    public List<File> getProguardFiles() {
        return mProguardFiles;
    }

    public void setProguardFiles(@NonNull Collection<File> proguardFiles) {
        mProguardFiles = ImmutableList.copyOf(proguardFiles);
    }

    @Nullable
    public String getJavaMaxHeapSize() {
        return mJavaMaxHeapSize;
    }

    public void setJavaMaxHeapSize(@Nullable String javaMaxHeapSize) {
        mJavaMaxHeapSize = javaMaxHeapSize;
    }

    @Nullable
    public File getMappingFile() {
        return mMappingFile;
    }

    public void setMappingFile(@Nullable File mappingFile) {
        mMappingFile = mappingFile;
    }

    public boolean isMultiDex() {
        return mMultiDex;
    }

    public void setMultiDex(boolean multiDex) {
        mMultiDex = multiDex;
    }

    public int getMinSdkVersion() {
        return mMinSdkVersion;
    }

    public void setMinSdkVersion(int minSdkVersion) {
        mMinSdkVersion = minSdkVersion;
    }

    @NonNull
    public List<File> getResourceDirectories() {
        return mResourceDirectories;
    }

    public void setResourceDirectories(@NonNull Collection<File> resourceDirectories) {
        mResourceDirectories = ImmutableList.copyOf(resourceDirectories);
    }

    @NonNull
    public List<File> getInputFiles() {
        return mInputFiles;
    }

    public void setInputFiles(@NonNull Collection<File> inputFiles) {
        mInputFiles = ImmutableList.copyOf(inputFiles);
    }

    @Nullable
    public File getEcjOptionFile() {
        return mEcjOptionFile;
    }

    public void setEcjOptionFile(@Nullable File ecjOptionFile) {
        mEcjOptionFile = ecjOptionFile;
    }

    @NonNull
    public List<File> getJarJarRuleFiles() {
        return mJarJarRuleFiles;
    }

    public void setJarJarRuleFiles(@NonNull Collection<File> jarJarRuleFiles) {
        mJarJarRuleFiles = ImmutableList.copyOf(jarJarRuleFiles);
    }

    @Nullable
    public String getSourceCompatibility() {
        return mSourceCompatibility;
    }

    public void setSourceCompatibility(@Nullable String sourceCompatibility) {
        mSourceCompatibility = sourceCompatibility;
    }

    @Nullable
    public File getIncrementalDir() {
        return mIncrementalDir;
    }

    public void setIncrementalDir(@Nullable File incrementalDir) {
        mIncrementalDir = incrementalDir;
    }
}