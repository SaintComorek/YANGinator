// This is a generated file. Not intended for manual editing.
package tech.pantheon.yanginator.plugin.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface YangIfFeatureFactor extends YangNamedElement {

  @Nullable
  YangIdentifierRefArg getIdentifierRefArg();

  @Nullable
  YangIfFeatureExpr getIfFeatureExpr();

  @Nullable
  YangIfFeatureFactor getIfFeatureFactor();

  @Nullable
  YangNotKeyword getNotKeyword();

  @NotNull
  List<YangOptsep> getOptsepList();

  @Nullable
  YangSep getSep();

  @Nullable
  PsiElement getLeftParenthesis();

  @Nullable
  PsiElement getRightParenthesis();

}
