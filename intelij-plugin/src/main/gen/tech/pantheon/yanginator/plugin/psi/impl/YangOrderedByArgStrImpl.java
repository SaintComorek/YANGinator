// This is a generated file. Not intended for manual editing.
package tech.pantheon.yanginator.plugin.psi.impl;

import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElementVisitor;
import org.jetbrains.annotations.NotNull;
import tech.pantheon.yanginator.plugin.psi.YangOrderedByArg;
import tech.pantheon.yanginator.plugin.psi.YangOrderedByArgStr;
import tech.pantheon.yanginator.plugin.psi.YangVisitor;

public class YangOrderedByArgStrImpl extends YangNamedElementImpl implements YangOrderedByArgStr {

  public YangOrderedByArgStrImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull YangVisitor visitor) {
    visitor.visitOrderedByArgStr(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof YangVisitor) accept((YangVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public YangOrderedByArg getOrderedByArg() {
    return findNotNullChildByClass(YangOrderedByArg.class);
  }

}
