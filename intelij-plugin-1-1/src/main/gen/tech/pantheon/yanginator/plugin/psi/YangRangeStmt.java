// This is a generated file. Not intended for manual editing.
package tech.pantheon.yanginator.plugin.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface YangRangeStmt extends YangNamedElement {

  @NotNull
  YangOptsep getOptsep();

  @NotNull
  YangRangeArgStr getRangeArgStr();

  @NotNull
  YangRangeKeyword getRangeKeyword();

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
