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

package com.android.tools.lint.psi;

import com.android.annotations.NonNull;
import com.android.annotations.Nullable;
import com.intellij.psi.JavaElementVisitor;
import com.intellij.psi.PsiBinaryExpression;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.PsiExpression;
import com.intellij.psi.PsiJavaToken;
import com.intellij.psi.tree.IElementType;

import org.eclipse.jdt.internal.compiler.ast.Expression;

class EcjPsiBinaryExpression extends EcjPsiExpression implements PsiBinaryExpression {

    private PsiExpression mLeftOperand;

    private PsiExpression mRightOperand;

    private IElementType mOperationType;

    EcjPsiBinaryExpression(@NonNull EcjPsiManager manager,
            @NonNull Expression expression) {
        super(manager, expression);
    }

    void setLeftOperand(PsiExpression leftOperand) {
        mLeftOperand = leftOperand;
    }

    void setRightOperand(PsiExpression rightOperand) {
        mRightOperand = rightOperand;
    }

    void setOperationType(IElementType operationType) {
        mOperationType = operationType;
    }

    @Override
    public void accept(@NonNull PsiElementVisitor visitor) {
        if (visitor instanceof JavaElementVisitor) {
            ((JavaElementVisitor) visitor).visitBinaryExpression(this);
        } else {
            visitor.visitElement(this);
        }
    }

    @NonNull
    @Override
    public PsiExpression getLOperand() {
        return mLeftOperand;
    }

    @Nullable
    @Override
    public PsiExpression getROperand() {
        return mRightOperand;
    }

    @NonNull
    @Override
    public PsiExpression[] getOperands() {
        if (mRightOperand != null) {
            return new PsiExpression[] { mLeftOperand, mRightOperand };
        } else {
            return new PsiExpression[] { mLeftOperand };
        }
    }

    @NonNull
    @Override
    public IElementType getOperationTokenType() {
        return mOperationType;
    }

    @NonNull
    @Override
    public PsiJavaToken getOperationSign() {
        throw new UnimplementedLintPsiApiException();
    }
}
