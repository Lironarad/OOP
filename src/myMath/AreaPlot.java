package myMath;
/*
 * GRAL: GRAphing Library for Java(R)
 *
 * (C) Copyright 2009-2018 Erich Seifert <dev[at]erichseifert.de>,
 * Michael Seifert <mseifert[at]error-reports.org>
 *
 * This file is part of GRAL.
 *
 * GRAL is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * GRAL is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with GRAL.  If not, see <http://www.gnu.org/licenses/>.
 */


import java.awt.Color;
import java.util.Random;

import de.erichseifert.gral.data.DataSeries;
import de.erichseifert.gral.data.DataSource;
import de.erichseifert.gral.data.DataTable;
import de.erichseifert.gral.examples.ExamplePanel;
import de.erichseifert.gral.plots.XYPlot;
import de.erichseifert.gral.plots.areas.AreaRenderer;
import de.erichseifert.gral.plots.areas.DefaultAreaRenderer2D;
import de.erichseifert.gral.plots.areas.LineAreaRenderer2D;
import de.erichseifert.gral.plots.lines.DefaultLineRenderer2D;
import de.erichseifert.gral.plots.lines.LineRenderer;
import de.erichseifert.gral.plots.points.DefaultPointRenderer2D;
import de.erichseifert.gral.plots.points.PointRenderer;
import de.erichseifert.gral.plots.points.SizeablePointRenderer;
import de.erichseifert.gral.ui.InteractivePanel;
import de.erichseifert.gral.util.GraphicsUtils;
import de.erichseifert.gral.graphics.Insets2D;

public class AreaPlot extends ExamplePanel {
	/** Version id for serialization. */
	private static final long serialVersionUID = 3287044991898775949L;

	/** Instance to generate random data values. */
	private static final Random random = new Random();

	@SuppressWarnings("unchecked")
	public AreaPlot(Polynom p) {
		//data of p = f(x) = 0.2x^4-1.5x^3+3.0x^2-x-5
		DataTable data1 = new DataTable(Double.class, Double.class);
		//data of area above function and under the x-axis
		DataTable data2 = new DataTable(Double.class, Double.class);
		//data of critical points
		DataTable data3 = new DataTable(Double.class, Double.class);

		for (double x = -2.0; x <= 6; x+=0.01) {
			double y = p.f(x);
			if(y>=0) {
			data1.add(x,y);
			}
		}
		
		double x0 = p.root(-1, 0, 0.01);
		double x1 = p.root(4,5, 0.01);
		for (double x = x0; x < x1; x+=0.01) {
			double y = p.f(x);
			data2.add(x,y);
		}
		
		data3.add(0.19389,p.f(0.19389));
		data3.add(1.75260,p.f(1.75260));
		data3.add(3.67851,p.f(3.67851));
		
		// Create data series
		DataSeries lineSeries = new DataSeries("f(x)", data1, 0, 1);
		DataSeries areaSeries = new DataSeries("area", data2, 0, 1);
		DataSeries criticalPoints = new DataSeries("critical points", data3, 0, 1);

		// Create new xy-plot
		XYPlot plot = new XYPlot(areaSeries,lineSeries,criticalPoints);
		plot.setLegendVisible(true);
		plot.setInsets(new Insets2D.Double(20.0, 40.0, 20.0, 20.0));
		
		formatFilledArea(plot, areaSeries, Color.BLUE);
		
		// Display the third data series as a points
		PointRenderer sizeablePointRenderer = new SizeablePointRenderer();
		sizeablePointRenderer.setColor(GraphicsUtils.deriveDarker(Color.RED));
		plot.setPointRenderers(criticalPoints, sizeablePointRenderer);


		// Add plot to Swing component
		add(new InteractivePanel(plot));
	}

	private static void formatFilledArea(XYPlot plot, DataSource data, Color color) {
		PointRenderer point = new DefaultPointRenderer2D();
		point.setColor(color);
		plot.setPointRenderers(data, point);
		LineRenderer line = new DefaultLineRenderer2D();
		line.setColor(color);
		line.setGap(3.0);
		line.setGapRounded(true);
		plot.setLineRenderers(data, line);
		AreaRenderer area = new DefaultAreaRenderer2D();
		area.setColor(GraphicsUtils.deriveWithAlpha(color, 64));
		plot.setAreaRenderers(data, area);
	}

	private static void formatLineArea(XYPlot plot, DataSource data, Color color) {
		PointRenderer point = new DefaultPointRenderer2D();
		point.setColor(color);
		plot.setPointRenderers(data, point);
		plot.setLineRenderers(data, null);
		AreaRenderer area = new LineAreaRenderer2D();
		area.setGap(3.0);
		area.setColor(color);
		plot.setAreaRenderers(data, area);
	}

	@Override
	public String getTitle() {
		return "Area plot";
	}

	@Override
	public String getDescription() {
		return "Area plot of three series with different styling";
	}

	public static void main(String[] args) {
		Polynom p = new Polynom("[0.2x^4-1.5x^3+3.0x^2-x-5.0]");
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
		System.out.println("critical points: \n" +"(" + 0.19389 +"," + p.f(0.19389)+ ")\n" + "(" + 1.75260 +"," + p.f(1.75260)+ ")\n" + "(" + 3.67851 +"," + p.f(3.67851)+ ")\n");
		System.out.println("roots: \n" + p.root(-1, 0, 0.01) + "\n" + p.root(4,5, 0.01));
		
		new AreaPlot(p).showInFrame();
	}
}
