/**
 * Created by luchen on 26/04/15.
 */
public abstract class Expression {
    public abstract String show(); // this should show the expression as a string (which can be parsed back into a expression).
    public abstract double evaluate();  // this should evaluate the expression

    static public Expression parse(String str) {
        // code that will parse the string creating the expression for that string
        return null; // this is just a place holder so you can get show and evaluate working first
    }
}