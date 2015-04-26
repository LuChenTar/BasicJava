/**
 * Created by luchen on 26/04/15.
 */
public class Number extends Expression {
    double num;

    public Number(double num) {
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
