/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package operation.research;

import java.util.ArrayList;
import java.util.Collections;

public class LeastMethod {

    public static Problem temp[][] = new Problem[Data.row][Data.column];
    public static String eq = "";

    public LeastMethod() {

        ArrayList<Problem> demand = new ArrayList<>();
        ArrayList<Problem> supply = new ArrayList<>();
        ArrayList<Double> list = new ArrayList<>();

        Problem arrays[][] = new Problem[Data.row][Data.column];

        demand = Data.demand;
        supply = Data.supply;

        if (Data.row == 3 && Data.column == 4) {
            arrays = LeastGUI.array;
        } else if (Data.row == 4 && Data.column == 4) {
            arrays = LeastGUI2.array;
        } else if (Data.row == 4 && Data.column == 3) {
            arrays = LeastGUI3.array;
        } else if (Data.row == 3 && Data.column == 3) {
            arrays = LeastGUI4.array;
        }

        int indexi = 0;
        int indexj = 0;

        double minimum = arrays[0][0].getValue();
        for (int i = 0; i < Data.row; i++) {

            for (int j = 0; j < Data.column; j++) {
                if (minimum > arrays[i][j].getValue()) {
                    minimum = arrays[i][j].getValue();
                    indexi = i;
                    indexj = j;
                }
            }
        }

        for (int i = 0; i < Data.row; i++) {
            for (int j = 0; j < Data.column; j++) {
                list.add(arrays[i][j].getValue());
            }
        }

        Collections.sort(list);

        double demands;
        double supplys;

        int index = 1;
        boolean check;

        do {

            demands = 0.0;
            supplys = 0.0;

            if (!arrays[indexi][indexj].isCheck() && !arrays[indexi][indexj].isCheck2()) {

                arrays[indexi][indexj].setCheck2(true);
                if (demand.get(indexj).getDemand_value() <= supply.get(indexi).getDemand_value()) {
                    arrays[indexi][indexj].setAssvalue(demand.get(indexj).getDemand_value());
                    supply.get(indexi).setDemand_value(supply.get(indexi).getDemand_value() - demand.get(indexj).getDemand_value());
                    demand.get(indexj).setDemand_value(0);

                    if (indexi == Data.row - 1) {
                        for (int k = indexi - 1; k >= 0; k--) {
                            if (!arrays[k][indexj].isCheck() && !arrays[k][indexj].isCheck2()) {
                                arrays[k][indexj].setCheck(true);
                                arrays[k][indexj].setCheck2(true);
                            }

                        }
                    } else if (indexi == 0) {
                        for (int k = indexi + 1; k < Data.row; k++) {
                            if (!arrays[k][indexj].isCheck() && !arrays[k][indexj].isCheck2()) {
                                arrays[k][indexj].setCheck(true);
                                arrays[k][indexj].setCheck2(true);
                            }
                        }
                    } else {
                        for (int k = indexi - 1; k >= 0; k--) {
                            if (!arrays[k][indexj].isCheck() && !arrays[k][indexj].isCheck2()) {
                                arrays[k][indexj].setCheck(true);
                                arrays[k][indexj].setCheck2(true);
                            }
                        }

                        for (int k = indexi + 1; k < Data.row; k++) {
                            if (!arrays[k][indexj].isCheck() && !arrays[k][indexj].isCheck2()) {
                                arrays[k][indexj].setCheck(true);
                                arrays[k][indexj].setCheck2(true);
                            }
                        }
                    }

                } else if (supply.get(indexi).getDemand_value() <= demand.get(indexj).getDemand_value()) {
                    arrays[indexi][indexj].setAssvalue(supply.get(indexi).getDemand_value());
                    demand.get(indexj).setDemand_value(demand.get(indexj).getDemand_value() - supply.get(indexi).getDemand_value());
                    supply.get(indexi).setDemand_value(0);

                    if (indexj == 0) {

                        for (int k = indexj + 1; k < Data.column; k++) {

                            if (!arrays[indexi][k].isCheck() && !arrays[indexi][k].isCheck2()) {
                                arrays[indexi][k].setCheck(true);
                                arrays[indexi][k].setCheck2(true);
                            }
                        }
                    } else if (indexj == Data.column - 1) {

                        for (int k = indexj - 1; k >= 0; k--) {
                            if (!arrays[indexi][k].isCheck() && !arrays[indexi][k].isCheck2()) {
                                arrays[indexi][k].setCheck(true);
                                arrays[indexi][k].setCheck2(true);
                            }
                        }
                    } else {

                        for (int k = indexj + 1; k < Data.column; k++) {
                            if (!arrays[indexi][k].isCheck() && !arrays[indexi][k].isCheck2()) {
                                arrays[indexi][k].setCheck(true);
                                arrays[indexi][k].setCheck2(true);
                            }
                        }
                        for (int k = indexj - 1; k >= 0; k--) {
                            if (!arrays[indexi][k].isCheck() && !arrays[indexi][k].isCheck2()) {
                                arrays[indexi][k].setCheck(true);
                                arrays[indexi][k].setCheck2(true);
                            }
                        }
                    }
                }
            }

            check = false;

            if (index < list.size()) {
                for (int m = 0; m < Data.row; m++) {
                    for (int k = 0; k < Data.column; k++) {
                        if (list.get(index) == arrays[m][k].getValue() && !arrays[m][k].isCheck() && !arrays[m][k].isCheck2() && !check) {
                            indexi = m;
                            indexj = k;
                            check = true;
                        }
                    }
                }
            }

            for (Problem aDemand : demand) {
                demands += aDemand.getDemand_value();
            }

            for (Problem aSupply : supply) {
                supplys += aSupply.getDemand_value();
            }
            index++;

        } while (demands != 0.0 || supplys != 0.0);

        temp = arrays;

        double answer = 0.0;

        for (int i = 0; i < Data.row; i++) {
            for (int j = 0; j < Data.column; j++) {
                if (!arrays[i][j].isCheck() && arrays[i][j].isCheck2()) {
                    answer += arrays[i][j].getValue() * arrays[i][j].getAssvalue();
                    eq += arrays[i][j].getValue() + " X " + arrays[i][j].getAssvalue() + " + ";
                }
            }
        }

        eq = eq.substring(0, eq.length() - 3);
        Data.answerss = answer;

        demand.clear();
        supply.clear();

    }
}
