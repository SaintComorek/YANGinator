// This is a generated file. Not intended for manual editing.
package tech.pantheon.yanginator.plugin.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface YangDeviateReplaceStmt extends YangNamedElement {

  @NotNull
  YangDeviateKeyword getDeviateKeyword();

  @NotNull
  YangOptsep getOptsep();

  @NotNull
  YangReplaceKeywordStr getReplaceKeywordStr();

  @NotNull
  YangSep getSep();

  @NotNull
  List<YangStmtsep> getStmtsepList();

  @Nullable
  PsiElement getLeftBrace();

  @Nullable
  PsiElement getRightBrace();

  @Nullable
  PsiElement getSemicolon();

}
