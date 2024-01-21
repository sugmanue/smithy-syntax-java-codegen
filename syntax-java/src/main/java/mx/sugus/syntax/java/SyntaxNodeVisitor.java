package mx.sugus.syntax.java;

public interface SyntaxNodeVisitor<T> {
    T visitTryStatement(TryStatement node);

    T visitExpressionFormatter(ExpressionFormatter node);

    T visitFinallyClause(FinallyClause node);

    T visitParameter(Parameter node);

    T visitInterfaceSyntax(InterfaceSyntax node);

    T visitIfStatement(IfStatement node);

    T visitSyntaxFormatter(SyntaxFormatter node);

    T visitEnumConstant(EnumConstant node);

    T visitCaseClause(CaseClause node);

    T visitClassSyntax(ClassSyntax node);

    T visitMethodSyntax(MethodSyntax node);

    T visitStatementFormatter(StatementFormatter node);

    T visitFieldSyntax(FieldSyntax node);

    T visitSwitchStatement(SwitchStatement node);

    T visitAnnotation(Annotation node);

    T visitEnumSyntax(EnumSyntax node);

    T visitForStatement(ForStatement node);

    T visitCatchClause(CatchClause node);

    T visitBlock(Block node);

    abstract class Default<T> implements SyntaxNodeVisitor<T> {
        public abstract T getDefault(SyntaxNode node);

        @Override
        public T visitTryStatement(TryStatement node) {
            return getDefault(node);
        }

        @Override
        public T visitExpressionFormatter(ExpressionFormatter node) {
            return getDefault(node);
        }

        @Override
        public T visitFinallyClause(FinallyClause node) {
            return getDefault(node);
        }

        @Override
        public T visitParameter(Parameter node) {
            return getDefault(node);
        }

        @Override
        public T visitInterfaceSyntax(InterfaceSyntax node) {
            return getDefault(node);
        }

        @Override
        public T visitIfStatement(IfStatement node) {
            return getDefault(node);
        }

        @Override
        public T visitSyntaxFormatter(SyntaxFormatter node) {
            return getDefault(node);
        }

        @Override
        public T visitEnumConstant(EnumConstant node) {
            return getDefault(node);
        }

        @Override
        public T visitCaseClause(CaseClause node) {
            return getDefault(node);
        }

        @Override
        public T visitClassSyntax(ClassSyntax node) {
            return getDefault(node);
        }

        @Override
        public T visitMethodSyntax(MethodSyntax node) {
            return getDefault(node);
        }

        @Override
        public T visitStatementFormatter(StatementFormatter node) {
            return getDefault(node);
        }

        @Override
        public T visitFieldSyntax(FieldSyntax node) {
            return getDefault(node);
        }

        @Override
        public T visitSwitchStatement(SwitchStatement node) {
            return getDefault(node);
        }

        @Override
        public T visitAnnotation(Annotation node) {
            return getDefault(node);
        }

        @Override
        public T visitEnumSyntax(EnumSyntax node) {
            return getDefault(node);
        }

        @Override
        public T visitForStatement(ForStatement node) {
            return getDefault(node);
        }

        @Override
        public T visitCatchClause(CatchClause node) {
            return getDefault(node);
        }

        @Override
        public T visitBlock(Block node) {
            return getDefault(node);
        }
    }
}
