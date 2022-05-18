// This is a generated file. Not intended for manual editing.
package tech.pantheon.yanginator.plugin.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static tech.pantheon.yanginator.plugin.psi.YangTypes.*;
import tech.pantheon.yanginator.plugin.psi.*;

public class YangYinElementStmtImpl extends YangNamedElementImpl implements YangYinElementStmt {

  public YangYinElementStmtImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull YangVisitor visitor) {
    visitor.visitYinElementStmt(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof YangVisitor) accept((YangVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public YangSep getSep() {
    return findNotNullChildByClass(YangSep.class);
  }

  @Override
  @NotNull
  public YangStmtend getStmtend() {
    return findNotNullChildByClass(YangStmtend.class);
  }

  @Override
  @NotNull
  public YangYinElementArgStr getYinElementArgStr() {
    return findNotNullChildByClass(YangYinElementArgStr.class);
  }

  @Override
  @NotNull
  public YangYinElementKeyword getYinElementKeyword() {
    return findNotNullChildByClass(YangYinElementKeyword.class);
  }

}
