/*
 * Copyright (c) 2021 PANTHEON.tech, s.r.o. All rights reserved.
 *
 *   This program and the accompanying materials are made available
 *   under the
 *   terms of the Eclipse Public License v1.0 which accompanies this
 *   distribution,  and is available at http://www.eclipse.org/legal/epl-v1.html
 */

// This is a generated file. Not intended for manual editing.
package tech.pantheon.yanginator.plugin.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface YangUnknownStatement extends YangNamedElement {

  @NotNull
  YangIdentifier getIdentifier();

  @NotNull
  List<YangOptsep> getOptsepList();

  @NotNull
  YangPrefix getPrefix();

  @Nullable
  YangSep getSep();

  @NotNull
  YangStmtsep getStmtsep();

  @Nullable
  YangString getString();

  @NotNull
  List<YangUnknownStatement> getUnknownStatementList();

  @NotNull
  List<YangYangStmt> getYangStmtList();

  @NotNull
  PsiElement getColon();

  @Nullable
  PsiElement getLeftBrace();

  @Nullable
  PsiElement getRightBrace();

  @Nullable
  PsiElement getSemicolon();

}