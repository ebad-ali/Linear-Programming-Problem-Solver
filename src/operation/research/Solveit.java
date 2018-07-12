package operation.research;

import java.util.ArrayList;

public class Solveit {

    ArrayList<Matrix> matrixes = new ArrayList<>();
    ArrayList<Matrix> matrices = new ArrayList<>();
    ArrayList<Matrix> matrixArrayList = new ArrayList<>();
    ArrayList<Matrix> CPF_Point = new ArrayList<>();
    ArrayList<Matrix> tcpf_point = new ArrayList<>();
    ArrayList<Double> listofz = new ArrayList<>();

    public Solveit() {

        matrixes = Data.matrixes;

        CPF_Point.add(new Matrix(0, 0));
        getcpf();

        if (matrixes.size() == 2) {
            matrices.add(new Matrix(matrixes.get(0).getV1(), matrixes.get(0).getV2(), matrixes.get(1).getV1(), matrixes.get(1).getV2(), matrixes.get(0).getE1(), matrixes.get(1).getE1()));

        } else if (matrixes.size() == 3) {
            matrices.add(new Matrix(matrixes.get(0).getV1(), matrixes.get(0).getV2(), matrixes.get(1).getV1(), matrixes.get(1).getV2(), matrixes.get(0).getE1(), matrixes.get(1).getE1()));
            matrices.add(new Matrix(matrixes.get(0).getV1(), matrixes.get(0).getV2(), matrixes.get(2).getV1(), matrixes.get(2).getV2(), matrixes.get(0).getE1(), matrixes.get(2).getE1()));
            matrices.add(new Matrix(matrixes.get(1).getV1(), matrixes.get(1).getV2(), matrixes.get(2).getV1(), matrixes.get(2).getV2(), matrixes.get(1).getE1(), matrixes.get(2).getE1()));
        }

        for (int i = 0; i < matrices.size(); i++) {

            double ans;

            double x, y;

            matrixArrayList.add(new Matrix(matrices.get(i).getV4(), -1 * matrices.get(i).getV2(), -1 * matrices.get(i).getV3(), matrices.get(i).getV1()));

            ans = matrixArrayList.get(i).getV1() * matrixArrayList.get(i).getV4() - (matrixArrayList.get(i).getV2() * matrixArrayList.get(i).getV3());

            x = matrixArrayList.get(i).getV1() * matrices.get(i).getE1() + (matrixArrayList.get(i).getV2() * matrices.get(i).getE2());
            y = matrixArrayList.get(i).getV3() * matrices.get(i).getE1() + (matrixArrayList.get(i).getV4() * matrices.get(i).getE2());

            x = x / ans;
            y = y / ans;

            CPF_Point.add(new Matrix(x, y));

            ans = 0;
            x = 0;
            y = 0;

        }

        getmaximumcpf();
        getmaximumz();

        matrixes.clear();
        matrices.clear();
        matrixArrayList.clear();
        CPF_Point.clear();
        tcpf_point.clear();
        listofz.clear();

    }

    public static void main(String[] args) {

    }

    public void getcpf() {
        double xaxis = Data.listequations.get(0).getEquation_1();
        double yaxis = Data.listequations.get(0).getEquation_2();

        for (int q = 0; q < Data.listequations.size(); q++) {

            if (xaxis > Data.listequations.get(q).getEquation_1() && Data.listequations.get(q).getEquation_1() != 0) {
                xaxis = Data.listequations.get(q).getEquation_1();
            } else if (xaxis == 0 && xaxis < Data.listequations.get(q).getEquation_1()) {
                xaxis = Data.listequations.get(q).getEquation_1();
            }
        }

        for (int x = 0; x < Data.listequations.size(); x++) {
            if (yaxis > Data.listequations.get(x).getEquation_2() && Data.listequations.get(x).getEquation_2() != 0) {
                yaxis = Data.listequations.get(x).getEquation_2();
            } else if (yaxis == 0 && yaxis < Data.listequations.get(x).getEquation_2()) {
                yaxis = Data.listequations.get(x).getEquation_2();
            }
        }

        CPF_Point.add(new Matrix(xaxis, 0));
        CPF_Point.add(new Matrix(0, yaxis));

    }

    public void getmaximumcpf() {
        double ax;
        boolean check = true;

        for (int i = 0; i < CPF_Point.size(); i++) {
            check = true;
            for (int j = 0; j < Data.matrixes.size(); j++) {
                ax = CPF_Point.get(i).getE1() * Data.matrixes.get(j).getV1() + (CPF_Point.get(i).getE2() * Data.matrixes.get(j).getV2());
                if (ax > Data.matrixes.get(j).getE1()) {
                    check = false;
                }

                ax = 0;
            }
            if (check) {
                tcpf_point.add(new Matrix(CPF_Point.get(i).getE1(), CPF_Point.get(i).getE2()));
            }
        }

    }

    public void getmaximumz() {
        double z = 0.0;

        for (int i = 0; i < tcpf_point.size(); i++) {
            z = tcpf_point.get(i).getE1() * Data.gotz.get(0).getE1() + (tcpf_point.get(i).getE2() * Data.gotz.get(0).getE2());
            listofz.add(z);
            z = 0.0;
        }

        for (int i = 0; i < listofz.size(); i++) {
            Data.thecpfpoint.add(new CPFPOINTS("( " + tcpf_point.get(i).getE1() + " , " + tcpf_point.get(i).getE2() + " )", listofz.get(i)));
        }

        double maximum = listofz.get(0);
        int index = 0;

        for (int i = 0; i < listofz.size(); i++) {
            if (maximum < listofz.get(i)) {
                maximum = listofz.get(i);
                index = i;
            }
        }

        String temps = "( " + tcpf_point.get(index).getE1() + " , " + tcpf_point.get(index).getE2() + " )";

        Data.points.add(new CPFPOINTS(temps, maximum));
    }

}
