// This is a generated file. Not intended for manual editing.
package tech.pantheon.yanginator.plugin.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface YangKeyStmt extends YangNamedElement {

  @NotNull
  YangKeyArgStr getKeyArgStr();

  @NotNull
  YangKeyKeyword getKeyKeyword();

  @NotNull
  YangSep getSep();

  @NotNull
  YangStmtend getStmtend();

}
