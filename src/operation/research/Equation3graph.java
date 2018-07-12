package operation.research;

import java.awt.Color;
import java.awt.BasicStroke;
import java.awt.event.WindowEvent;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;

public class Equation3graph extends ApplicationFrame {

    public Equation3graph(String applicationTitle, String chartTitle) {
        super(applicationTitle);
        JFreeChart xylineChart = ChartFactory.createXYLineChart(
                chartTitle,
                "X",
                "Y",
                createDataset(),
                PlotOrientation.VERTICAL,
                true, true, false);

        ChartPanel chartPanel = new ChartPanel(xylineChart);
        chartPanel.setPreferredSize(new java.awt.Dimension(560, 367));
        final XYPlot plot = xylineChart.getXYPlot();
        XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer();
        renderer.setSeriesPaint(0, Color.RED);
        renderer.setSeriesPaint(1, Color.GREEN);
        renderer.setSeriesPaint(2, Color.BLUE);
        renderer.setSeriesStroke(0, new BasicStroke(4.0f));
        renderer.setSeriesStroke(1, new BasicStroke(3.0f));
        renderer.setSeriesStroke(2, new BasicStroke(2.0f));
        plot.setRenderer(renderer);
        setContentPane(chartPanel);
    }

    public XYDataset createDataset() {

        final XYSeries firefox = new XYSeries("Equation 1");

        if (Data.listequations.get(0).getEquation_1() != 0 && 0 != Data.listequations.get(0).getEquation_2()) {
            firefox.add(Data.listequations.get(0).getEquation_1(), 0);
            firefox.add(0, Data.listequations.get(0).getEquation_2());
        } else if (Data.listequations.get(0).getEquation_1() == 0 & 0 != Data.listequations.get(0).getEquation_2()) {
            for (int i = 0; i < Data.listequations.get(0).getEquation_2(); i++) {
                firefox.add(i, Data.listequations.get(0).getEquation_2());
            }
        } else if (Data.listequations.get(0).getEquation_1() != 0 && Data.listequations.get(0).getEquation_2() == 0) {
            for (int i = 0; i < Data.listequations.get(0).getEquation_1(); i++) {
                firefox.add(Data.listequations.get(0).getEquation_1(), i);
            }
        } else {
            firefox.add(0, 0);
        }

        final XYSeries chrome = new XYSeries("2nd Equation");

        if (Data.listequations.get(1).getEquation_1() != 0 && 0 != Data.listequations.get(1).getEquation_2()) {
            chrome.add(Data.listequations.get(1).getEquation_1(), 0);
            chrome.add(0, Data.listequations.get(1).getEquation_2());
        } else if (Data.listequations.get(1).getEquation_1() == 0 & 0 != Data.listequations.get(1).getEquation_2()) {
            for (int i = 0; i < Data.listequations.get(1).getEquation_2(); i++) {
                chrome.add(i, Data.listequations.get(1).getEquation_2());
            }
        } else if (Data.listequations.get(1).getEquation_1() != 0 && Data.listequations.get(1).getEquation_2() == 0) {
            for (int i = 0; i < Data.listequations.get(1).getEquation_1(); i++) {
                chrome.add(Data.listequations.get(1).getEquation_1(), i);
            }
        } else {
            chrome.add(0, 0);
        }

        final XYSeries IExplorer = new XYSeries("3rd Equation");

        if (Data.listequations.get(2).getEquation_1() != 0 && 0 != Data.listequations.get(2).getEquation_2()) {
            IExplorer.add(Data.listequations.get(2).getEquation_1(), 0);
            IExplorer.add(0, Data.listequations.get(2).getEquation_2());
        } else if (Data.listequations.get(2).getEquation_1() == 0 & 0 != Data.listequations.get(2).getEquation_2()) {
            for (int i = 0; i < Data.listequations.get(2).getEquation_2(); i++) {
                IExplorer.add(i, Data.listequations.get(2).getEquation_2());
            }
        } else if (Data.listequations.get(2).getEquation_1() != 0 && Data.listequations.get(2).getEquation_2() == 0) {
            for (int i = 0; i < Data.listequations.get(2).getEquation_1(); i++) {
                IExplorer.add(Data.listequations.get(2).getEquation_1(), i);
            }
        } else {
            IExplorer.add(0, 0);
        }

        final XYSeriesCollection dataset = new XYSeriesCollection();
        dataset.addSeries(firefox);
        dataset.addSeries(chrome);
        dataset.addSeries(IExplorer);
        return dataset;
    }

    public void start() {
        Equation3graph chart = new Equation3graph("", "Operation Research");
        chart.pack();
        RefineryUtilities.centerFrameOnScreen(chart);
        //chart.setDefaultCloseOperation();
        chart.setVisible(true);
    }

    public void windowClosing(final WindowEvent evt) {
        if (evt.getWindow() == this) {
            dispose();

        }
    }

}
