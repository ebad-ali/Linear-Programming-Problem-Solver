/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package operation.research;

import java.util.ArrayList;

public class NorthwestProblem {

    public static Problem temp[][] = new Problem[Data.row][Data.column];
    public static String eq = "";

    public NorthwestProblem() {

        ArrayList<Problem> demands = new ArrayList<>();
        ArrayList<Problem> supplys = new ArrayList<>();

        demands = Data.demand;
        supplys = Data.supply;

        Problem arrays[][] = new Problem[Data.row][Data.column];

        if (Data.row == 3 && Data.column == 4) {
            arrays = NorthGUI.array;
        } else if (Data.row == 4 && Data.column == 4) {
            arrays = NorthGUI2.array;
        }
        else if(Data.row==4&&Data.column==3)
        {
            arrays = NorthGUI3.array;
        } else if(Data.row==3&&Data.column==3)
        {
            arrays = NorthGUI4.array;
        }

        for (int i = 0; i < Data.row; i++) {
            for (int j = 0; j < Data.column; j++) {
                if (!arrays[i][j].isCheck() && !arrays[i][j].isCheck2()) {

                    arrays[i][j].setCheck2(true);

                    if (demands.get(j).getDemand_value() <= supplys.get(i).getDemand_value()) {

                        arrays[i][j].setAssvalue(demands.get(j).getDemand_value());
                        supplys.get(i).setDemand_value(supplys.get(i).getDemand_value() - demands.get(j).getDemand_value());
                        demands.get(j).setDemand_value(0);

                        if (i == Data.row - 1) {
                            for (int k = i - 1; k >= 0; k--) {
                                if (!arrays[k][j].isCheck() && !arrays[k][j].isCheck2()) {
                                    arrays[k][j].setCheck(true);
                                    arrays[k][j].setCheck2(true);
                                }

                            }
                        } else if (i == 0) {
                            for (int k = i + 1; k < Data.row; k++) {
                                if (!arrays[k][j].isCheck() && !arrays[k][j].isCheck2()) {
                                    arrays[k][j].setCheck(true);
                                    arrays[k][j].setCheck2(true);
                                }
                            }
                        } else {
                            for (int k = i - 1; k >= 0; k--) {
                                if (!arrays[k][j].isCheck() && !arrays[k][j].isCheck2()) {
                                    arrays[k][j].setCheck(true);
                                    arrays[k][j].setCheck2(true);
                                }
                            }

                            for (int k = i + 1; k < Data.row; k++) {
                                if (!arrays[k][j].isCheck() && !arrays[k][j].isCheck2()) {
                                    arrays[k][j].setCheck(true);
                                    arrays[k][j].setCheck2(true);
                                }
                            }
                        }

                    } else if (supplys.get(i).getDemand_value() <= demands.get(j).getDemand_value()) {

                        arrays[i][j].setAssvalue(supplys.get(i).getDemand_value());
                        demands.get(j).setDemand_value(demands.get(j).getDemand_value() - supplys.get(i).getDemand_value());
                        supplys.get(i).setDemand_value(0);

                        /*for (int k = j + 1; k < Data.column; k++) {
                            arrays[i][k].setCheck(true);
                        }*/
                        if (j == 0) {

                            for (int k = j + 1; k < Data.column; k++) {

                                if (!arrays[i][k].isCheck() && !arrays[i][k].isCheck2()) {
                                    arrays[i][k].setCheck(true);
                                    arrays[i][k].setCheck2(true);
                                }
                            }
                        } else if (j == Data.column - 1) {

                            for (int k = j - 1; k >= 0; k--) {
                                //System.out.println(array[i][k].getValue());
                                if (!arrays[i][k].isCheck() && !arrays[i][k].isCheck2()) {
                                    arrays[i][k].setCheck(true);
                                    arrays[i][k].setCheck2(true);
                                }
                            }
                        } else {

                            for (int k = j + 1; k < Data.column; k++) {
                                //System.out.println(array[i][k].getValue());

                                if (!arrays[i][k].isCheck() && !arrays[i][k].isCheck2()) {
                                    arrays[i][k].setCheck(true);
                                    arrays[i][k].setCheck2(true);
                                }
                            }
                            for (int k = j - 1; k >= 0; k--) {

                                if (!arrays[i][k].isCheck() && !arrays[i][k].isCheck2()) {
                                    arrays[i][k].setCheck(true);
                                    arrays[i][k].setCheck2(true);
                                }
                            }

                        }

                    }
                }
            }
        }

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

        demands.clear();
        supplys.clear();

    }

}
