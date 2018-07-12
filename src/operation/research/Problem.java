package operation.research;

public class Problem {

    double value, assvalue;
    boolean check, check2;

    double demand_value;

    public Problem(double value, double assvalue, boolean check) {
        this.value = value;
        this.assvalue = assvalue;
        this.check = check;
    }

    public Problem(double value, double assvalue, boolean check, boolean check2) {
        this.value = value;
        this.assvalue = assvalue;
        this.check = check;
        this.check2 = check2;
    }

    public boolean isCheck2() {
        return check2;
    }

    public void setCheck2(boolean check2) {
        this.check2 = check2;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public void setAssvalue(double assvalue) {
        this.assvalue = assvalue;
    }

    public void setCheck(boolean check) {
        this.check = check;
    }

    public void setDemand_value(double demand_value) {
        this.demand_value = demand_value;
    }

    public double getValue() {
        return value;
    }

    public double getAssvalue() {
        return assvalue;
    }

    public boolean isCheck() {
        return check;
    }

    public double getDemand_value() {
        return demand_value;
    }

    public Problem(double demand_value) {

        this.demand_value = demand_value;
    }
}
