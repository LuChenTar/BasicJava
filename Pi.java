/**
 * Created by luchen on 26/04/15.
 */
public class Pi extends Expression {
    @Override
    public String show() {
        return "pi";
    }

    @Override
    public double evaluate() {
        return 3.14159;
    }
}
