package operation.research;

import java.util.ArrayList;
import java.util.StringTokenizer;
import javax.swing.JOptionPane;

public class Mathe {

    public static ArrayList<Equations> listofequations = new ArrayList<>();
    public static ArrayList<Matrix> listofmatrix = new ArrayList<>();

    public Mathe() {

        ArrayList<String> list = new ArrayList<>();
        ArrayList<String> list2 = new ArrayList<>();

        if (Data.equations.size() == 2 || Data.equations.size() == 3) {
            getvalueofz();
        }

        for (int i = 0; i < Data.equations.size(); i++) {

            String equation = Data.equations.get(i);

            double a = 0;
            double b = 0;
            double c;

            double eq1 = 0;
            double eq2 = 0;

            StringTokenizer tokenizer = new StringTokenizer(equation, "<=", false);
            while (tokenizer.hasMoreTokens()) {
                list.add(tokenizer.nextToken());
            }

            c = Integer.parseInt(list.get(list.size() - 1));

            StringTokenizer tokenizer1 = new StringTokenizer(list.get(0), " ", false);
            while (tokenizer1.hasMoreTokens()) {
                list2.add(tokenizer1.nextToken());
            }

            if (list2.get(0).charAt(list2.get(0).length() - 1) == 'x') {
                String m = list2.get(0).substring(0, list2.get(0).length() - 1);
                a = Integer.parseInt(m);
            }

            if (list2.get(1).charAt(list2.get(1).length() - 1) == 'y') {
                String m = list2.get(1).substring(0, list2.get(1).length() - 1);
                b = Integer.parseInt(m);
            }

            listofmatrix.add(new Matrix(a, b, c));

            if (a == 0) {
                eq1 = 0;
            } else {
                eq1 = c / a;
            }
            if (b == 0) {
                eq2 = 0;
            } else {

                eq2 = c / b;
            }

            listofequations.add(new Equations(eq1, eq2));

            Data.listequations = listofequations;

            a = 0;
            b = 0;
            eq1 = 0;
            eq2 = 0;
            list.clear();
            list2.clear();
        }

        Data.matrixes = listofmatrix;

        Data.size = listofequations.size();

        if (Data.size == 2 || Data.size == 3) {
            Solveit it = new Solveit();
        }

    }

    public void getvalueofz() {
        for (int i = 0; i < Data.valueofz.size(); i++) {

            ArrayList<String> list2 = new ArrayList<>();

            String text = Data.valueofz.get(i);

            double a = 0.0, b = 0.0;

            StringTokenizer tokenizer = new StringTokenizer(text, " ", false);

            while (tokenizer.hasMoreTokens()) {

                list2.add(tokenizer.nextToken());
            }

            if (list2.get(0).charAt(list2.get(0).length() - 1) == 'x') {
                String m = list2.get(0).substring(0, list2.get(0).length() - 1);
                a = Double.parseDouble(m);
            }

            if (list2.get(1).charAt(list2.get(1).length() - 1) == 'y') {
                String m = list2.get(1).substring(0, list2.get(1).length() - 1);
                b = Double.parseDouble(m);
            }

            Data.gotz.add(new Matrix(a, b));
        }
    }
}