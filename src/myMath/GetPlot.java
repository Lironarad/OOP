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
import java.util.ArrayList;
import java.util.Iterator;
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

public class GetPlot extends ExamplePanel {
	/** Version id for serialization. */
	private static final long serialVersionUID = 3287044991898775949L;

	/** Instance to generate random data values. */
	private static final Random random = new Random();

	/**
	 * contractor for the getPlot class that present a grapic view of functions.
	 * @param p Polynom
	 * @param a the start value of the interval that we view
	 * @param b	the end value of the interval that we view
	 */
	@SuppressWarnings("unchecked")
	public GetPlot(Polynom p, double a, double b) {
		//data of p = f(x)
		
		DataTable func = new DataTable(Double.class, Double.class);
		//data of critical points
		DataTable  points = p.criticalPoints(a, b, 0.001);

		for (double x = a; x <= b; x+=0.001) {
			double y = p.f(x);
			//if(y>=0) 
				func.add(x,y);
		}
		
		// Create data series
		DataSeries lineSeries = new DataSeries("f(x)", func, 0, 1);

		DataSeries criticalPoints = new DataSeries("critical points", points, 0, 1);

		// Create new xy-plot
		XYPlot plot = new XYPlot(lineSeries,criticalPoints);
		plot.setLegendVisible(true);
		plot.setInsets(new Insets2D.Double(20.0, 40.0, 20.0, 20.0));

		// Display the third data series as a points
		PointRenderer sizeablePointRenderer = new SizeablePointRenderer();
		sizeablePointRenderer.setColor(GraphicsUtils.deriveDarker(Color.RED));
		plot.setPointRenderers(criticalPoints, sizeablePointRenderer);


		// Add plot to Swing component
		add(new InteractivePanel(plot));
	}

	/**
	 * function to show the data of Polynom as a line over the plot
	 * @param plot the plot that will represenr the Polynom
	 * @param data the data of the Polynom
	 * @param color color of the line
	 */
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
	/**
	 * the title of the view window
	 */
	public String getTitle() {
		return "Area plot";
	}

	@Override
	/**
	 * Description of the plot.
	 */
	public String getDescription() {
		return "2D graph plot for polynoms";
	}


	public static void main(String[] args) {
		
		Polynom p = new Polynom("[0.2x^4-1.5x^3+3.0x^2-x-5]");
		System.out.println(p);
		System.out.println("area above function and under the x-axis: " +Math.abs(p.areaUnderX(-2, 6, 0.001)));
		new GetPlot(p,-2,6).showInFrame();
		Monom a = new Monom(-1,2);
		Monom b = new Monom(3,1);
		Monom c = new Monom(8,0);
		Polynom p10 = new Polynom();
		p10.add(a);
		p10.add(b);
		p10.add(c);
		double root = p10.root(-5, 2, 0.01);
	}
}
