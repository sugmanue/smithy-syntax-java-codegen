package mx.sugus.codegen.jv.spec3.syntax;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import org.junit.jupiter.api.Test;

class IfStatementTest {

    @Test
    public void testNoBlocksNoElse() {
        var stmt = IfStatement.builder(LiteralExpression.create("value == null"))
                              .statement(LiteralStatement.create("return value"))
                              .build();
        assertThat(stmt.toString(), equalTo(""" 
                                                if (value == null) return value;
                                                 """));
    }

    @Test
    public void testNoBlocksWithElse() {
        var stmt = IfStatement.builder(LiteralExpression.create("value == null"))
                              .statement(LiteralStatement.create("return value"))
                              .elseStatement(LiteralStatement.create("return null"))
                              .build();
        assertThat(stmt.toString(), equalTo(""" 
                                                if (value == null) return value; else return null;
                                                 """));
    }

    @Test
    public void testEmptyBlocksNoElse() {
        var stmt = IfStatement.builder(LiteralExpression.create("value == null"))
                              .statement(BlockStatement.builder().build())
                              .build();
        assertThat(stmt.toString(), equalTo(""" 
                                                if (value == null) {
                                                }
                                                 """));
    }

    @Test
    public void testEmptyBlocksElseEmptyBlock() {
        var stmt = IfStatement.builder(LiteralExpression.create("value == null"))
                              .statement(BlockStatement.builder().build())
                              .elseStatement(BlockStatement.builder().build())
                              .build();

        assertThat(stmt.toString(), equalTo(""" 
                                                if (value == null) {
                                                } else {
                                                }
                                                 """));
    }

    @Test
    public void testNonEmptyBlocksNoElse() {
        var stmt = IfStatement.builder(LiteralExpression.create("value == null"))
                              .statement(BlockStatement.builder()
                                                             .addStatement(LiteralStatement.create("return null"))
                                                             .build())
                              .build();
        assertThat(stmt.toString(), equalTo(""" 
                                                if (value == null) {
                                                    return null;
                                                }
                                                 """));
    }

    @Test
    public void testNonEmptyBlockElseNoBlock() {
        var stmt = IfStatement.builder(LiteralExpression.create("value == null"))
                              .statement(BlockStatement.builder()
                                                             .addStatement(LiteralStatement.create("return null"))
                                                             .build())
                              .elseStatement(LiteralStatement.create("return value"))
                              .build();
        assertThat(stmt.toString(), equalTo(""" 
                                                if (value == null) {
                                                    return null;
                                                } else return value;
                                                 """));
    }

    @Test
    public void testNonEmptyBlockElseNonEmptyBlock() {
        var stmt = IfStatement.builder(LiteralExpression.create("value == null"))
                              .statement(BlockStatement.builder()
                                                             .addStatement(LiteralStatement.create("return value"))
                                                             .build())
                              .elseStatement(BlockStatement.builder()
                                                                 .addStatement(LiteralStatement.create("return null"))
                                                                 .build())
                              .build();
        assertThat(stmt.toString(), equalTo(""" 
                                                if (value == null) {
                                                    return value;
                                                } else {
                                                    return null;
                                                }
                                                 """));
    }
}