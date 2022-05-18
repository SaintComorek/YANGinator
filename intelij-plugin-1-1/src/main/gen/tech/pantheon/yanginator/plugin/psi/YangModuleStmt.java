// This is a generated file. Not intended for manual editing.
package tech.pantheon.yanginator.plugin.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface YangModuleStmt extends YangNamedElement {

  @NotNull
  YangBodyStmts getBodyStmts();

  @NotNull
  YangIdentifierArgStr getIdentifierArgStr();

  @NotNull
  YangLinkageStmts getLinkageStmts();

  @NotNull
  YangMetaStmts getMetaStmts();

  @NotNull
  YangModuleHeaderStmts getModuleHeaderStmts();

  @NotNull
  YangModuleKeyword getModuleKeyword();

  @NotNull
  List<YangOptsep> getOptsepList();

  @NotNull
  YangRevisionStmts getRevisionStmts();

  @NotNull
  YangSep getSep();

  @NotNull
  YangStmtsep getStmtsep();

  @NotNull
  PsiElement getLeftBrace();

  @NotNull
  PsiElement getRightBrace();

}
