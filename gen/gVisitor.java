// Generated from D:/DLSU/TERM 2 2018-2019/CMPILER/Mini Project/antlr\g.g4 by ANTLR 4.7.2
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link gParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface gVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link gParser#pareser}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPareser(gParser.PareserContext ctx);
}