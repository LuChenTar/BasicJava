/**
 * Created by luchen on 26/04/15.
 */
public class Exp extends Expression {
    @Override
    public String show() {
        return "e";
    }

    @Override
    public double evaluate() {
        return 2.71828;
    }
}
