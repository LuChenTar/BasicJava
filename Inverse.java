/**
 * Created by luchen on 26/04/15.
 */
public class Inverse extends Expression {
    double num;

    public Inverse(double num) {
        super();
        this.num = num;
    }

    @Override
    public String show() {
        return String.valueOf(num);
    }

    @Override
    public double evaluate() {
        return num;
    }
}