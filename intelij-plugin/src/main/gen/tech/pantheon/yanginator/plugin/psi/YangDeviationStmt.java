// This is a generated file. Not intended for manual editing.
package tech.pantheon.yanginator.plugin.psi;

import com.intellij.psi.PsiElement;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public interface YangDeviationStmt extends YangStatement {

  @NotNull
  List<YangLineComment> getLineCommentList();

  @NotNull
  List<YangComment> getCommentList();

  @NotNull
  YangDeviationArgStr getDeviationArgStr();

  @NotNull
  List<YangDeviationStmtBody> getDeviationStmtBodyList();

  @NotNull
  List<YangUnknownStatement> getUnknownStatementList();

  @NotNull
  PsiElement getDeviationKeyword();

  @Nullable
  PsiElement getLeftBrace();

  @Nullable
  PsiElement getRightBrace();

}
