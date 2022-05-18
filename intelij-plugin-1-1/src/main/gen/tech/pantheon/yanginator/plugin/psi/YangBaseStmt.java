// This is a generated file. Not intended for manual editing.
package tech.pantheon.yanginator.plugin.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface YangBaseStmt extends YangNamedElement {

  @NotNull
  YangBaseKeyword getBaseKeyword();

  @NotNull
  YangIdentifierRefArgStr getIdentifierRefArgStr();

  @NotNull
  YangSep getSep();

  @NotNull
  YangStmtend getStmtend();

}
