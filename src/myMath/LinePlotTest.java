package myMath;

import java.awt.Color;
import javax.swing.JFrame;

import de.erichseifert.gral.data.DataSeries;
import de.erichseifert.gral.data.DataTable;
import de.erichseifert.gral.plots.BarPlot;
import de.erichseifert.gral.plots.XYPlot;
import de.erichseifert.gral.plots.lines.DefaultLineRenderer2D;
import de.erichseifert.gral.plots.lines.LineRenderer;
import de.erichseifert.gral.plots.points.PointRenderer;
import de.erichseifert.gral.plots.points.SizeablePointRenderer;
import de.erichseifert.gral.ui.InteractivePanel;
import de.erichseifert.gral.util.GraphicsUtils;
import myMath.Monom;
import myMath.Polynom;

public class LinePlotTest extends JFrame {
	public LinePlotTest() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(900, 400);
		Polynom p = new Polynom();
		Monom m1 = new Monom(0.2, 4);
		Monom m2 = new Monom(-1.5, 3);
		Monom m3 = new Monom(3, 2);
		Monom m4 = new Monom(-1, 1);
		Monom m5 = new Monom(-5, 0);
		p.add(m1);
		p.add(m2);
		p.add(m3);
		p.add(m4);
		p.add(m5);
		System.out.println(p);
		System.out.println("area above function and under the x-axis: " +Math.abs(p.area(p.root(-1, 0, 0.001), p.root(4, 5, 0.001), 0.001)));
		System.out.println("critical points: \n" + 0.19389 + " \n" + 1.75260 + " \n" + 3.67851);

		//data of f(x) = 0.2x^4-1.5x^3+3.0x^2-x-5
		DataTable data1 = new DataTable(Double.class, Double.class);
		//data of area area above function and under the x-axis
		DataTable data2 = new DataTable(Double.class, Double.class);
		//data of critical points
		DataTable data3 = new DataTable(Double.class, Double.class);

		for (double x = -2.0; x <= 6; x+=0.001) {
			double y = p.f(x);
			data2.add(x,y);
		}
		
		double x0 = p.root(-1, 0, 0.00001);
		double x1 = p.root(4,5, 0.00001);
		for (double x = x0; x <= x1; x+=0.001) {
			double y = p.f(x);
			data1.add(x,y);
		}
		
		data3.add(0.19389,p.f(0.19389));
		data3.add(1.75260,p.f(1.75260));
		data3.add(3.67851,p.f(3.67851));
		
		
		DataSeries barSeries = new DataSeries(data1, 0, 1);
		DataSeries lineSeries = new DataSeries(data2, 0, 1);
		DataSeries criticalPoints = new DataSeries(data3, 0, 1);
		
		//build the plot
		BarPlot plot = new BarPlot(barSeries,lineSeries,criticalPoints);
		getContentPane().add(new InteractivePanel(plot));
		
		// Change the color of all bars
		PointRenderer barRenderer = plot.getPointRenderers(barSeries).get(0);
		barRenderer.setColor(Color.LIGHT_GRAY);

		// Display the second data series as a line plot
		LineRenderer lineRenderer = new DefaultLineRenderer2D();
		lineRenderer.setColor(Color.RED);
		plot.setLineRenderers(lineSeries, lineRenderer);
		// The default point renderer (BarRenderer) needs to be deactivated (or changed)
		plot.setPointRenderers(lineSeries, null);
		
		// Display the third data series as a points
		PointRenderer sizeablePointRenderer = new SizeablePointRenderer();
		sizeablePointRenderer.setColor(GraphicsUtils.deriveDarker(Color.BLUE));
		plot.setPointRenderers(criticalPoints, sizeablePointRenderer);


	}

	public static void main(String[] args) {
		LinePlotTest frame = new LinePlotTest();
		frame.setVisible(true);
	}
}

