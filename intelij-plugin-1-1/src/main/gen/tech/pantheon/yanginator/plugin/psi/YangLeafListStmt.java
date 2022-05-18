// This is a generated file. Not intended for manual editing.
package tech.pantheon.yanginator.plugin.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface YangLeafListStmt extends YangNamedElement {

  @NotNull
  YangIdentifierArgStr getIdentifierArgStr();

  @NotNull
  YangLeafListKeyword getLeafListKeyword();

  @NotNull
  YangOptsep getOptsep();

  @NotNull
  YangSep getSep();

  @NotNull
  List<YangStmtsep> getStmtsepList();

  @NotNull
  PsiElement getLeftBrace();

  @NotNull
  PsiElement getRightBrace();

}
