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
