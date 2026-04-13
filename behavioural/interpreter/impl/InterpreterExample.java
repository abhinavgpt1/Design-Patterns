// Amazing article and example by gfg - https://www.geeksforgeeks.org/system-design/interpreter-design-pattern/
class Context {
    // Any global information needed for interpretation
}

interface Expression { // Abstract Expression
    int interpret(Context context);
}

class NumberExpression implements Expression { // Terminal Expression
    private int number;

    public NumberExpression(int number) {
        this.number = number;
    }

    @Override
    public int interpret(Context context) {
        return number;
    }
}

class AdditionExpression implements Expression { // Non-Terminal Expression
    private Expression left;
    private Expression right;

    public AdditionExpression(Expression left, Expression right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public int interpret(Context context) {
        return left.interpret(context) + right.interpret(context);
    }
}

class MultiplicationExpression implements Expression { // Non-Terminal Expression
    private Expression left;
    private Expression right;

    public MultiplicationExpression(Expression left, Expression right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public int interpret(Context context) {
        return left.interpret(context) * right.interpret(context);
    }
}

class Interpreter {
    private Context context;

    public Interpreter(Context context) {
        this.context = context;
    }

    public int interpret(String expression) {
        // Parse expression and create expression tree
        Expression expressionTree = buildExpressionTree(expression);
        
        // Interpret expression tree
        return expressionTree.interpret(context);
    }

    private Expression buildExpressionTree(String expression) {
        // Logic to parse expression and create expression tree
        // For simplicity, assume the expression is already parsed
        // and represented as an expression tree
        return new AdditionExpression(
            new NumberExpression(2),
            new MultiplicationExpression(
                new NumberExpression(3),
                new NumberExpression(4)
            )
        );
    }
}

public class InterpreterExample { // Client
    public static void main(String[] args) {
        // Input expression
        String expression = "2 + 3 * 4";
        
        // Create interpreter
        Context context = new Context();
        Interpreter interpreter = new Interpreter(context);
        
        // Interpret expression
        int result = interpreter.interpret(expression);
        System.out.println("Result: " + result);
    }
}

// the example in Pluralsight was less meaningful. It build a grammar based on some words like -> "bears" and ("bears" or ("bears" and "tiger"))
// It interpreted expressions like
// "tigers"         -> F
// "bears"          -> T
// "lions tigers"   -> F
// "lions bears"    -> T
// "tigers bears"   -> T

/**
 * Output:
 * -------
 * Result: 14
 */