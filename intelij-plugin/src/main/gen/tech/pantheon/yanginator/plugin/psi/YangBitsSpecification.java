// This is a generated file. Not intended for manual editing.
package tech.pantheon.yanginator.plugin.psi;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public interface YangBitsSpecification extends YangNamedElement {

  @NotNull
  List<YangLineComment> getLineCommentList();

  @NotNull
  List<YangBitStmt> getBitStmtList();

  @NotNull
  List<YangComment> getCommentList();

  @NotNull
  List<YangUnknownStatement> getUnknownStatementList();

}
