/**
 * Created by luchen on 26/04/15.
 */
public class Addition extends Expression {
    double numa;
    double numb;

    public Addition(double numa, double numb) {
        super();
        this.numa = numa;
        this.numb = numb;
    }

    @Override
    public String show() {
        return " ( " + String.valueOf(numa)+ " + " + String.valueOf(numb) + " ) ";
    }

    @Override
    public double evaluate() {
        return numa + numb;
    }
}
