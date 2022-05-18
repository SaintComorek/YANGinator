// This is a generated file. Not intended for manual editing.
package tech.pantheon.yanginator.plugin.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface YangMustStmt extends YangNamedElement {

  @NotNull
  YangMustKeyword getMustKeyword();

  @NotNull
  YangOptsep getOptsep();

  @NotNull
  YangSep getSep();

  @NotNull
  List<YangStmtsep> getStmtsepList();

  @NotNull
  YangString getString();

  @Nullable
  PsiElement getLeftBrace();

  @Nullable
  PsiElement getRightBrace();

  @Nullable
  PsiElement getSemicolon();

}
