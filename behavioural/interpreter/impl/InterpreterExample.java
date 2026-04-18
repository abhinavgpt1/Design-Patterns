// Amazing article and example by gfg 
// - https://www.geeksforgeeks.org/system-design/interpreter-design-pattern/

class Context {
    // Context => Any information needed for expression interpretation
}

interface AbstractExpression {
    int interpret(Context context);
}

// Terminal Expression
class NumberExpression implements AbstractExpression {
    private int number;

    public NumberExpression(int number) {
        this.number = number;
    }

    @Override
    public int interpret(Context context) {
        return number;
    }
}

// Non-Terminal Expression
class AdditionExpression implements AbstractExpression {
    private AbstractExpression left;
    private AbstractExpression right;

    public AdditionExpression(AbstractExpression left, AbstractExpression right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public int interpret(Context context) {
        return left.interpret(context) + right.interpret(context);
    }
}

// Non-Terminal Expression
class MultiplicationExpression implements AbstractExpression {
    private AbstractExpression left;
    private AbstractExpression right;

    public MultiplicationExpression(AbstractExpression left, AbstractExpression right) {
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

    public int evaluateExpression(String expression) {
        // Parse, create and evaulate expression tree
        AbstractExpression expressionTree = buildExpressionTree(expression);
        return expressionTree.interpret(context);
    }

    private AbstractExpression buildExpressionTree(String expression) {
        // Logic to parse expression and create expression tree
        // For simplicity, I'm not parsing expression and hardcoding.
        return new AdditionExpression(
                new NumberExpression(2),
                new MultiplicationExpression(
                        new NumberExpression(3),
                        new NumberExpression(4)));
    }
}

public class InterpreterExample { // Client
    public static void main(String[] args) {
        String expression = "2+3*4";

        // Create interpreter. Here the context is doing anything,
        // but it could be any additional/shared info required during interpretation.
        Context context = new Context();
        Interpreter interpreter = new Interpreter(context);

        int result = interpreter.evaluateExpression(expression);
        System.out.println("Result: " + result);

        /**
         * The example in Pluralsight was less meaningful.
         * It build a grammar like this: "bears" and ("bears" or ("bears" and "tiger"))
         * It interpreted expressions like
         * "tigers" -> F
         * "bears" -> T
         * "lions tigers" -> F
         * "lions bears" -> T
         * "tigers bears" -> T
         */
    }
}

/**
 * Output:
 * -------
 * Result: 14
 */