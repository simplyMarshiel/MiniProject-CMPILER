import java.util.BitSet;

import org.antlr.v4.runtime.ANTLRErrorListener;
import org.antlr.v4.runtime.Parser;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Recognizer;
import org.antlr.v4.runtime.atn.ATNConfigSet;
import org.antlr.v4.runtime.dfa.DFA;

public class AntlrErrorListener implements ANTLRErrorListener{
	public static AntlrErrorListener INSTANCE = new AntlrErrorListener();
	
	//When the value is false, the syntaxError method returns without displaying errors.
	private static final boolean REPORT_SYNTAX_ERRORS = true;
	
	private String errorMsg = "";
	
	@Override
	public void syntaxError(Recognizer<?, ?> recognizer, 
	                        Object offendingSymbol, 
	                        int line, 
	                        int charPositionInLine, 
	                        String msg, 
	                        RecognitionException re) {

	    if (!REPORT_SYNTAX_ERRORS) {
	        return;
	    }

	    String sourceName = recognizer.getInputStream().getSourceName();
	    if (!sourceName.isEmpty()) {
	        sourceName = String.format("%s:%d:%d: ", sourceName, line, charPositionInLine);
	    }

	    // System.err.println(sourceName+"on line SSSS "+line+":"+charPositionInLine+" "+msg);
		if(msg.contains("extraneous")) {
			String[] err = msg.split(" ");
			msg = "too many " + err[2];
		}

		else if(msg.contains("token recognition")){
			String[] err = msg.split(" ");
			msg = err[err.length - 1] + " token is not allowed.";
		}

		System.err.println("ERROR: at line " + line + ":"+charPositionInLine+" "+msg);
	    errorMsg = errorMsg + "\n" + sourceName+"line "+line+":"+charPositionInLine+" "+msg;
	}

	@Override
	public String toString() {
	    return errorMsg;
	}

	@Override
	public void reportAmbiguity(Parser arg0, DFA arg1, int arg2, int arg3, boolean arg4, BitSet arg5,
			ATNConfigSet arg6) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void reportAttemptingFullContext(Parser arg0, DFA arg1, int arg2, int arg3, BitSet arg4, ATNConfigSet arg5) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void reportContextSensitivity(Parser arg0, DFA arg1, int arg2, int arg3, int arg4, ATNConfigSet arg5) {
		// TODO Auto-generated method stub
		
	}   
}
