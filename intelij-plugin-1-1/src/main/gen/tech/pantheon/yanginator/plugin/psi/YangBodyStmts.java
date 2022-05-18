// This is a generated file. Not intended for manual editing.
package tech.pantheon.yanginator.plugin.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface YangBodyStmts extends YangNamedElement {

  @NotNull
  List<YangAugmentStmt> getAugmentStmtList();

  @NotNull
  List<YangDataDefStmt> getDataDefStmtList();

  @NotNull
  List<YangDeviationStmt> getDeviationStmtList();

  @NotNull
  List<YangExtensionStmt> getExtensionStmtList();

  @NotNull
  List<YangFeatureStmt> getFeatureStmtList();

  @NotNull
  List<YangGroupingStmt> getGroupingStmtList();

  @NotNull
  List<YangIdentityStmt> getIdentityStmtList();

  @NotNull
  List<YangNotificationStmt> getNotificationStmtList();

  @NotNull
  List<YangRpcStmt> getRpcStmtList();

  @NotNull
  List<YangTypedefStmt> getTypedefStmtList();

}
