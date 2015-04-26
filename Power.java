/**
 * Created by luchen on 26/04/15.
 */
public class Power extends Expression {
    double base;
    double log;

    public Power(double log, double base) {
        super();
        this.log = log;
        this.base = base;
    }

    @Override
    public String show() {
        return " ( " + String.valueOf(base)+ " ** " + String.valueOf(log) + " ) ";
    }

    @Override
    public double evaluate() {
        return Math.log(log)/Math.log(base);
    }
}
