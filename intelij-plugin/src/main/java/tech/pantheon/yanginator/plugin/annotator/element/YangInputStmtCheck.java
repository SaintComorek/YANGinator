package tech.pantheon.yanginator.plugin.annotator.element;

import com.intellij.lang.annotation.AnnotationHolder;
import com.intellij.psi.PsiElement;
import org.jetbrains.annotations.NotNull;
import tech.pantheon.yanginator.plugin.annotator.check.ElementCheckUtils;
import tech.pantheon.yanginator.plugin.psi.YangInputStmt;

public class YangInputStmtCheck extends AbstractYangStmtCheck {
    @Override
    public boolean isApplicable(@NotNull final PsiElement element) {
        return element instanceof YangInputStmt;
    }

    @Override
    public void performCheck(@NotNull final PsiElement element, @NotNull final AnnotationHolder holder) {
        minOne.checkMany(element, holder, ElementCheckUtils.getDataDefStatements());
    }
}