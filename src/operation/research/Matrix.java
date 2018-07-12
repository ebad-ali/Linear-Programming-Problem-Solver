/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package operation.research;

public class Matrix {

    private double v1, v2, v3, v4, e1, e2;

    public Matrix(double v1, double v2, double v3, double v4, double e1, double e2) {
        this.v1 = v1;
        this.v2 = v2;
        this.v3 = v3;
        this.v4 = v4;
        this.e1 = e1;
        this.e2 = e2;
    }

    public Matrix(double v1, double v2, double v3, double v4) {
        this.v1 = v1;
        this.v2 = v2;
        this.v3 = v3;
        this.v4 = v4;
    }

    public Matrix(double v1, double v2, double e1) {
        this.v1 = v1;
        this.v2 = v2;
        this.e1 = e1;
    }

    public Matrix(double e1, double e2) {
        this.e1 = e1;
        this.e2 = e2;
    }

    public double getV1() {
        return v1;
    }

    public double getV2() {
        return v2;
    }

    public double getV3() {
        return v3;
    }

    public double getV4() {
        return v4;
    }

    public double getE1() {
        return e1;
    }

    public double getE2() {
        return e2;
    }
}
