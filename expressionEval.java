import java.util.*;

class expressionEval {
	

public static int compute(String operator, int num1, int num2){
	//System.out.println(operator);
	//System.out.println(operator == "/");
	if(operator.equals("*")){
		return num1*num2;
	}
	else if(operator.equals("-")){
		return num1-num2;
	}
	else if(operator.equals("/")){
		return num1/num2;
	}
	else{
		return num1+num2;
	}

}

public static void printArray(String[] array){
	int i = 0;
	while(i < array.length){
		System.out.print(array[i]);
		i++;
	}
	System.out.println();

}

public static String solveExpression(String expression){
	Set<String> operators = new HashSet<String>(Arrays.asList("+","/","*","-"));
	String expressionElements[] = expression.split(" ");
	int size = expressionElements.length;
	int i;
	int j;
	int leftNumber;
	int rightNumber;
	int value;
	//printArray(expressionElements);
	while(size > 1){
		i = 0;
		j = 0;
		while(i<size - 2){
			//System.out.println(operators.contains(expressionElements[i]));
			if(operators.contains(expressionElements[i]) && !operators.contains(expressionElements[i+1])&&!operators.contains(expressionElements[i+2])){
					leftNumber = Integer.parseInt(expressionElements[i+1]);
					rightNumber = Integer.parseInt(expressionElements[i+2]);
					value = compute(expressionElements[i],leftNumber,rightNumber);
					expressionElements[j] = Integer.toString(value);
					//System.out.println(j+" "+value);
					j++;
					i+=3;
				
			}
			else{
				expressionElements[j] = expressionElements[i];
				i++;
				j++;
			}
		}
		size = j+1;
		//printArray(expressionElements);
	}
	return expressionElements[0];
	
}

public static void runTest(){
	//Base cases
	String exp1 = "1";
	String exp2 = "+ 1 2";

	//Connected expressions
	String exp3 = "+ + 1 2 + 3 4";
	String exp4 = "/ + 4 2 + 1 2";

	//All operators in one expression
	String exp5 = "/ * + 3 0 + 1 2 - 4 1";

	// lopsided expression
	String exp6 = "+ 1 + 2 + 3 + 4 5";

	// negative
	String exp7 = "+ -1 2";
	if(solveExpression(exp1).equals("1")){
		System.out.println("Test 1 passed(base): 1 = 1");
	}
	if(solveExpression(exp2).equals("3")){
		System.out.println("Test 2 passed(base): + 1 2 = 3");
	}
	if(solveExpression(exp3).equals("10")){
		System.out.println("Test 3 passed(connected): + 1 2 + 3 4 = 10");
	}
	if(solveExpression(exp4).equals("2")){
		System.out.println("Test 4 passed(connected): / + 4 2 + 1 2 = 2");
	}
	if(solveExpression(exp5).equals("3")){
		System.out.println("Test 5 passed(all operators): / * + 3 0 + 1 2 - 4 1 = 3 * 3 / 3 = 3");
	}
	if(solveExpression(exp6).equals("15")){
		System.out.println("Test 6 passed(lopsided): + 1 + 2 + 3 + 4 5 = 15");
	}
	if(solveExpression(exp7).equals("1")){
		System.out.println("Test 7 passed(Negative): + -1 2 = 1");
	}

}

public static void main(String[] args)
{
	runTest();
	System.out.println("Enter custom expression: ");
 	Scanner scan = new Scanner(System.in);
	String expression = scan.nextLine();
	System.out.println(solveExpression(expression));


}
}


