package View;

import java.awt.Color;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.xy.XYDataItem;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import Database.JDBCUtil;

public class BieuDoHinhDuong extends JPanel {

    private Connection con;

    public BieuDoHinhDuong() {
        con = JDBCUtil.getConnection();
    }

    public void VeBieuDo() throws SQLException {
        ResultSet rs = con.createStatement().executeQuery("SELECT WEEK(NgayMua) AS Thang, SUM(TongGia) AS DoanhThu FROM HoaDon GROUP BY WEEK(NgayMua)");

        XYSeriesCollection dataset = new XYSeriesCollection();

        while (rs.next()) {
            XYSeries series = new XYSeries(rs.getString("Thang"));
            series.add(rs.getInt("Thang"), rs.getDouble("DoanhThu"));
            dataset.addSeries(series);
        }

        JFreeChart chart = ChartFactory.createXYLineChart(
            "Doanh thu hằng tuần",
            "Tuần",
            "Doanh thu ($)",
            dataset,
            PlotOrientation.VERTICAL,
            true,
            true,
            false
        );

        XYPlot plot = (XYPlot) chart.getPlot();
        for (int i = 0; i < dataset.getSeriesCount(); i++) {
            XYSeries series = dataset.getSeries(i);
            XYDataItem firstItem = series.getDataItem(0);
            XYDataItem lastItem = series.getDataItem(series.getItemCount() - 1);
            if (firstItem.getXValue() > lastItem.getXValue()) {
                plot.getRenderer().setSeriesPaint(i, Color.GREEN);
            } else {
                plot.getRenderer().setSeriesPaint(i, Color.RED);
            }
        }

        add(new ChartPanel(chart));
        validate();
    }
}