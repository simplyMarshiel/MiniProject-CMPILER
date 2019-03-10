import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import java.io.IOException;
import java.io.File;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.Scanner;
import static org.antlr.v4.runtime.CharStreams.fromFileName;

public class Launch {

    public static void main(String[] args)
    {
        try{
            File source = new File("input.txt");
            Scanner sc = new Scanner(source);
            while(sc.hasNextLine()) {
                String input = sc.nextLine();
                BufferedWriter writer = new BufferedWriter(new FileWriter("line.txt"));
                writer.write(input);
                writer.close();

                CharStream cs = fromFileName("line.txt");
                gLexer lexer = new gLexer(cs);

                lexer.removeErrorListeners();
                lexer.addErrorListener(AntlrErrorListener.INSTANCE);

                CommonTokenStream token = new CommonTokenStream(lexer);

                gParser parser = new gParser(token);

                parser.removeErrorListeners();
                parser.addErrorListener(AntlrErrorListener.INSTANCE);

                ParseTree tree = parser.prule();

                MyVisitor visitor = new MyVisitor();
                visitor.visit(tree);

                //if an Error occured e.g. divisiong by 0, prog will return
                // -2147483648, and not print the answer.
                int result = Evaluator.evaluate(input);
                if(result != -999)
                    System.out.println(result);
            }
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
