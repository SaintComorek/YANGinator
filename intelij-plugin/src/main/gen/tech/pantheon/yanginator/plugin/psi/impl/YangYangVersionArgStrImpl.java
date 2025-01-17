// This is a generated file. Not intended for manual editing.
package tech.pantheon.yanginator.plugin.psi.impl;

import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElementVisitor;
import org.jetbrains.annotations.NotNull;
import tech.pantheon.yanginator.plugin.psi.YangVisitor;
import tech.pantheon.yanginator.plugin.psi.YangYangVersionArg;
import tech.pantheon.yanginator.plugin.psi.YangYangVersionArgStr;

public class YangYangVersionArgStrImpl extends YangNamedElementImpl implements YangYangVersionArgStr {

  public YangYangVersionArgStrImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull YangVisitor visitor) {
    visitor.visitYangVersionArgStr(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof YangVisitor) accept((YangVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public YangYangVersionArg getYangVersionArg() {
    return findNotNullChildByClass(YangYangVersionArg.class);
  }

}
