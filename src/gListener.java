// Generated from D:/DLSU/TERM 2 2018-2019/CMPILER/Mini Project/antlr\g.g4 by ANTLR 4.7.2
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link gParser}.
 */
public interface gListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link gParser#prule}.
	 * @param ctx the parse tree
	 */
	void enterPrule(gParser.PruleContext ctx);
	/**
	 * Exit a parse tree produced by {@link gParser#prule}.
	 * @param ctx the parse tree
	 */
	void exitPrule(gParser.PruleContext ctx);
	/**
	 * Enter a parse tree produced by {@link gParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(gParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link gParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(gParser.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link gParser#term}.
	 * @param ctx the parse tree
	 */
	void enterTerm(gParser.TermContext ctx);
	/**
	 * Exit a parse tree produced by {@link gParser#term}.
	 * @param ctx the parse tree
	 */
	void exitTerm(gParser.TermContext ctx);
	/**
	 * Enter a parse tree produced by {@link gParser#factor}.
	 * @param ctx the parse tree
	 */
	void enterFactor(gParser.FactorContext ctx);
	/**
	 * Exit a parse tree produced by {@link gParser#factor}.
	 * @param ctx the parse tree
	 */
	void exitFactor(gParser.FactorContext ctx);
}