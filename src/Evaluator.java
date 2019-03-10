import java.util.*;
import java.math.*;
public class Evaluator{
	public static int evaluate(String ss){
		try{
			String[] input = ss.split(" ");
			boolean debug = false;
			Stack<Integer> ans = new Stack<>();
			Stack<Character> operator = new Stack<>();
			Stack<String> operand = new Stack<>();
			HashMap<Character, Integer> val = new HashMap<>();
			int operator_count = 0;
			val.put('(',0);
			val.put(')',0);
			val.put('+',1);
			val.put('-',1);
			val.put('*',2);
			val.put('/',2);
			val.put('%',2);
			for(int i = 0 ; i < input.length ; i++){
				if(debug)System.out.println(input[i]+"<<input");
				if(input[i].matches("[\\+\\-*/%\\(\\)]")){
					//if next is an operator
					char c = input[i].charAt(0);
					if(c=='('){
						if(debug)System.out.println(c+"<<");
						operator.push(c);
					}else if(c==')'){
						if(debug)System.out.println(c+"<<");
						while(operator.peek()!='('){
							operand.push(operator.pop()+"");
						}
						operator.pop();
					}else{
						if(!operator.isEmpty()){
							if(val.get(operator.peek()) > val.get(c)){
								//if current stack top is + - and u try to insert */ or %
								while(!operator.isEmpty() && val.get(operator.peek()) > val.get(c)){
									//push to operand the thingy
									operand.push(operator.pop()+"");
								}
							}
						}
						operator.push(c);
						operator_count++;
					}
				}else{
					//if item is operand
					operand.push(input[i]);
				}
			}
			while(!operator.isEmpty()) operand.push(operator.pop()+"");
			Stack<String> op2 = new Stack<>();
			while(!operand.isEmpty()) op2.push(operand.pop());
			while(operator_count!=0){
				String s = op2.pop();
				if(debug)System.out.println(s);
				if(s.matches("[\\+\\-*/%]")){
					int y = ans.pop();
					int x = ans.pop();
					int tans = 0;
					try{
						switch(s.charAt(0)){
							case '+':tans = Math.addExact(x,y);break;
							case '-':tans = Math.subtractExact(x,y);break;
							case '/':
								if(x != 0)
									tans = y/x;
								else{
									System.out.println("Cannot divide by 0.");
									return -999;
								}
							break;
							case '*':tans = Math.multiplyExact(x,y);break;
							case '%':
								if(x != 0)
									tans = y%x;

								else{
									System.out.println("Cannot modulo by 0.");
									return -999;
								}
							break;
						}
					}catch(ArithmeticException e){
						e.printStackTrace();
						return Integer.MIN_VALUE;
					}
					operator_count--;
					ans.push(tans);
				}else{
					ans.push(Integer.parseInt(s));
				}
			}
			return ans.pop();
		} catch(Exception e){
			System.out.println("Cannot evaluate the expression. ");
			return -999;
		}
	}
}