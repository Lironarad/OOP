package myMath;


import java.util.ArrayList;
import java.util.Iterator;

import de.erichseifert.gral.data.DataTable;
import myMath.Monom;
/**
 * This class represents a Polynom with add, multiply functionality, it also should support the following:
 * 1. Riemann's Integral: https://en.wikipedia.org/wiki/Riemann_integral
 * 2. Finding a numerical value between two values (currently support root only f(x)=0).
 * 3. Derivative
 * 
 * @author Boaz
 *
 */
public class Polynom implements Polynom_able{

	// ********** add your code below ***********
	ArrayList<Monom> polynom;
	Monom_Comperator cmp = new Monom_Comperator();

	/**
	 * Polynom-
	 * polynom create new ArrayList of Monoms
	 */
	public Polynom() 
	{
		polynom = new ArrayList<Monom>();
	}


	/**
	 * polynom-
	 * get another polynom and copy him, this function will help us for the multiply two polynoms functions
	 * @param p1 will be a polynom that we copy
	 */
	public Polynom(Polynom p1) 
	{
		polynom = ((Polynom) p1.copy()).polynom;
	}

	/**
	 * Polynom - 
	 * this function get polynom as a string and seperate him to Monoms by add function and other 
	 * functions inside Polynom
	 * @Parm po the string that present polynom
	 */
	public Polynom(String po)
	{
		polynom = new ArrayList<Monom>();
		int numOfMOnoms=0;
		int start=0;
		int end=0;
		int k=0;
		int b;
		char x='x';
		double a;
		String X="x";
		String temp;
		String err="-+";
		String power="x^";




		if(po.contains(err)==true)
		{
			throw new IllegalArgumentException();
		}
		if(po.charAt(0)!='[' || po.charAt(po.length()-1)!=']')
		{
			throw new IllegalArgumentException();

		}

		if(po.charAt(1)!='-')
		{
			numOfMOnoms++;
		}

		for(int i=0; i<po.length(); i++)
		{
			if(po.charAt(i)=='+' && po.charAt(i+1)=='-')
				i++;
			if(po.charAt(i)=='-' && po.charAt(i+1)=='-')
				i++;
			if(po.charAt(i)=='-' && po.charAt(i+1)=='+')
				i++;
			if(po.charAt(i)=='+' || po.charAt(i)=='-')
			{
				numOfMOnoms++;
			}
		}

		String arr[]=new String[numOfMOnoms];

		for(int i=0; i<po.length(); i++)
		{
			if(po.charAt(i)=='+' && po.charAt(i+1)!='-')
			{
				end=i;
				arr[k]=po.substring(start, end);
				k++;
				end++;
				start=end;
			}

			if(po.charAt(i)=='+' && po.charAt(i+1)=='-')
			{
				end=i;
				arr[k]=po.substring(start, end);
				k++;
				end++;
				start=end;
			}

			if(po.charAt(i)=='-' && po.charAt(i+1)!='+' && po.charAt(i-1)!='+' && i!=1 && po.charAt(i-1)!='-')
			{
				end=i;
				arr[k]=po.substring(start, end);
				k++;
				start=end;
			}
			if(po.charAt(i)=='-' && po.charAt(i+1)=='-')
			{

				start+=2;
				end+=2;
			}

			if(po.charAt(i)==']')
			{
				k=arr.length-1;
				arr[k]=po.substring(end, po.length());	
			}
		}

		start=0;
		end=0;
		k=0;
		for(int i=0; i<arr.length;i++)
		{
			temp=arr[i];
			if(i==0) start++;
			if(temp.contains(power)==true)
			{

				while(temp.charAt(k)!='x')
				{
					end++;
					k++;
					if(temp.charAt(k)=='x')
					{
						if(temp.charAt(k-1)=='[' || temp.charAt(k-1)=='-' || temp.charAt(k-1)=='+')
						{
							if(temp.charAt(k-1)=='+') 
							{
								a = 1;
								b = Integer.parseInt(temp.substring(end+2, temp.length()));
								Monom e = new Monom(a,b);
								add(e);
								k=0;
								start=0;
								end=0;
								break;
							}
							if(temp.charAt(k-1)=='-')
							{
								a = -1;
								b = Integer.parseInt(temp.substring(end+2, temp.length()));
								Monom e = new Monom(a,b);
								add(e);
								k=0;
								start=0;
								end=0;
								break;
							}
						}
						if(temp.charAt(k-1) == '[')
							a = 1;
						else
						a = Double.parseDouble(temp.substring(start, end));
						if(temp.charAt(end+2)!=']' && temp.charAt(temp.length()-1)==']')
						{
							b = Integer.parseInt(temp.substring(end+2, temp.length()-1));
							Monom d = new Monom(a,b);
							add(d);
							k=0;
							start=0;
							end=0;
							break;
						}
						b = Integer.parseInt(temp.substring(end+2, temp.length()));
						Monom e = new Monom(a,b);
						add(e);
						k=0;
						start=0;
						end=0;
						break;
					}
				}
			}

			if(temp.contains(X)==true && temp.contains(power)==false)
			{
				if(temp.charAt(k)==x)
				{
					Monom e = new Monom(1,1);
					add(e);
					k=0;
					start=0;
					end=0;
				}
				else {
					while(temp.charAt(k)!=x)
					{
						end++;
						k++;
						if(temp.charAt(k)==x)
						{
							if(temp.charAt(k-1)=='[' || temp.charAt(k-1)=='-' || temp.charAt(k-1)=='+')
							{
								if(temp.charAt(k-1)=='+') 
								{
									a = 1;
									if(temp.length() == 2) {
										b = 1;
										Monom e = new Monom(a,b);
										add(e);
										k=0;
										start=0;
										end=0;
										break;
									}
									b = Integer.parseInt(temp.substring(end+2, temp.length()));
									Monom e = new Monom(a,b);
									add(e);
									k=0;
									start=0;
									end=0;
									break;
								}
								if(temp.charAt(k-1)=='-')
								{
									a = -1;
									if(temp.length() == 2) {
										b = 1;
										Monom e = new Monom(a,b);
										add(e);
										k=0;
										start=0;
										end=0;
										break;
									}
									b = Integer.parseInt(temp.substring(end+2, temp.length()));
									Monom e = new Monom(a,b);
									add(e);
									k=0;
									start=0;
									end=0;
									break;
								}
							}
							a = Double.parseDouble(temp.substring(start, end));
							Monom f = new Monom(a,1);
							add(f);
							k=0;
							start=0;
							end=0;
							break;
						}
					}
				}
			}

			if(temp.contains(X)==false && temp.contains(power)==false)
			{
				a = Double.parseDouble(temp.substring(start, temp.length()-1));
				Monom h = new Monom(a,0);
				add(h);
			}


		}
	}

	/**
	 * add - 
	 * the add function get Monom and add him to the polynom arraylist
	 * and make sure that the array of monoms will be sorted
	 * @param m1- will be a Monom that will be added to polynom arrayList
	 */
	public void add(Monom m1)
	{
		Iterator<Monom> it = iteretor();
		while(it.hasNext())
		{
			Monom m = it.next();
			if(m1.get_coefficient() == 0)
				return;
			if(m1.get_power() == m.get_power())
			{
				m.add(m1);
				sortByPower();
				return;
			}
		}
		polynom.add(m1);
		sortByPower();
	}
	/**
	 * sort -
	 * the funtion will take the arrayList and sort him by power, because power is the imported value to sort
	 * this function will help us when we print the arrayList
	 */
	private void sortByPower()
	{
		this.polynom.sort(cmp);
	}

	@Override
	/**
	 * f - 
	 * the function like the first one in Monom will get a real number x and will return the value of the all ! the arrayList of Monoms
	 * @param x - a real number that we will put inside each monom
	 * @return the value of the arrayList of Monoms after we put the x value
	 */
	public double f(double x)
	{
		double sum = 0;
		Iterator<Monom> it = polynom.iterator();
		while(it.hasNext()) {
			sum = sum + it.next().f(x);
		}
		return sum;
	}

	@Override
	/**
	 * add-
	 * the function will add polynom to polynom , and we make sure that the terms of polynom will stay in the new polynom that we get 
	 * the add function will take care to that
	 * @param p1- polynom that will be added to other polynom
	 */
	public void add(Polynom_able p1)
	{
		Iterator<Monom> it_p1 = p1.iteretor();
		while(it_p1.hasNext())
		{
			Monom m = new Monom(it_p1.next());
			add(m);
		}
	}

	@Override
	/**
	 * substract-
	 * this function will subtract  two polynoms and make sure (by add function) that the terms of polynom will stay
	 * @param p1- the polynom that we subtract 
	 */
	public void substract(Polynom_able p1) 
	{
		Polynom_able copyP1 = p1.copy();
		Iterator<Monom> it_copyP1 = copyP1.iteretor();
		while(it_copyP1.hasNext())
		{

			Monom m = it_copyP1.next();
			m.multByConstant(-1);
		}
		add(copyP1);
	}

	/**
	 * Multiply this polynom by another.
	 * @param p1 another polynom to multiply with this one.
	 */
	@Override
	public void multiply(Polynom_able p1)
	{
		//create copies of the two polynoms to multiply.
		Polynom_able copyPolynom = copy();
		Polynom_able copyP1 = p1.copy();

		//remove current monoms from this polynom.
		remove();

		Iterator<Monom> itCopyP1 = copyP1.iteretor();
		Iterator<Monom> itCopyPolynom = copyPolynom.iteretor();
		Monom m;
		Monom m1;

		//multiply the copy polynoms, add the result to the original polynom.
		while(itCopyPolynom.hasNext()) {
			if(itCopyP1.hasNext()) {
				m1 = itCopyP1.next();
				while( itCopyPolynom.hasNext()) {
					m = new Monom (itCopyPolynom.next());
					Monom m2 = new Monom(m.multByOtherMonom(m1));
					add(m2);
				}

				// remove the monoms that already multiply.
				if(itCopyP1.hasNext()) {
					itCopyPolynom = copyPolynom.iteretor();
					itCopyP1.remove();
				}
			}
		}
	}

	@Override
	/**
	 * chack if two polynoms are equal.
	 * @Parm p1 another polynom to compare.
	 */
	public boolean equals(Polynom_able p1) 
	{
		Polynom_able copyPolynom = copy();
		copyPolynom.substract(p1);
		return copyPolynom.isZero();
	}

	@Override
	/**
	 * isZero - 
	 * check if monom equal to zero
	 */
	public boolean isZero() 
	{
		Iterator<Monom> it = iteretor();
		while(it.hasNext())
		{
			Monom m = it.next();
			if(m.get_coefficient() != 0)
				return false;
		}
		return true;
	}

	@Override
	/**
	 * Find the closest value x' in the X-axis, when f(x') = 0, between two values x1,x0.
	 * x0  <=x' <= x1 , x'<eps.
	 * @Parm x0 starting point.
	 * @Parm x1 end point.
	 * @param eps step value.
	 * return f(x) = 0.
	 */
	public double root(double x0, double x1, double eps)
	{
		double mid = (x1+x0)/2;
		while(Math.abs(x1-x0)>eps)
		{

			if(f(mid)*f(x1)<0) {
				x0 = mid;
				mid = (x1+x0)/2;
			}
			else if(f(mid)*f(x1)>0) {
				x1 = mid;
				mid = (x1+x0)/2;
			}
			else
				return mid;
		}
		return mid;
	}

	@Override
	/**
	 * Create new polynom, copy this polynom to the new one.
	 * @return copy of this polynom.
	 */
	public Polynom_able copy() 
	{
		Polynom copyPolynom = new Polynom();
		Iterator<Monom> it = iteretor();

		while(it.hasNext())
		{
			Monom m =new Monom(it.next());
			copyPolynom.add(m);
		}

		return  copyPolynom ;
	}

	@Override
	/**
	 * derivative - 
	 * make a derivative on the polynom
	 * return derivative of this polynom.
	 */
	public Polynom_able derivative() 
	{
		Polynom_able derivative = copy();

		Iterator<Monom> it = derivative.iteretor();
		while(it.hasNext())
		{
			Monom m = it.next();
			m.derivative();

		}

		return derivative;
	}

	private void remove()
	{
		Iterator<Monom> it = iteretor();

		while(it.hasNext())
		{
			it.next();
			it.remove();
		}
	}

	@Override
	/**
	 * Compute the area above the X axis and under this polynom between two point [x0,x1]. 
	 * @param x0 starting point
	 * @param x1 end point
	 * @param eps positive step value
	 * @return the approximated area above the X axis and under this polynom between two point [x0,x1].
	 */
	public double area(double x0, double x1, double eps) {
		double area = 0;
		for (double i = x0; i < x1; i+=eps) {
			area = area + eps * f(i);
		}

		return area;
	}

	@Override
	/**
	 * fuction to itrate over the monom of this polynom
	 * @return iterator.
	 */
	public Iterator<Monom> iteretor() {
		return polynom.iterator();
	}


	public ArrayList<Double> CuttingPoints(double a, double b) {

		ArrayList<Double> criticalPoints = new ArrayList<>();
		double x0 = a;
		double x1 = a+1;
		double x;
		while(x1<=b+1) {
			if(this.f(x0) * this.f(x1)<0) {
				x = root(x0, x1, 0.0001);
				criticalPoints.add(x);
			}
			x0 += 0.5;
			if(x0>=x1)
				x1+=0.5;
		}

		return criticalPoints;
	}
	/**
	 * toString function to print the polynom
	 * @return String of this polynom.
	 */
	@Override
	public String toString() {
		String s = "[";
		if((isZero()))
			return "0";

		Iterator<Monom> it = iteretor();
		Monom m = it.next();
		s = s + m.toString();
		while(it.hasNext())
		{
			m = it.next();
			if(m.get_coefficient() != 0) {
				if(m.get_coefficient() > 0 )
					s = s + "+" + m.toString();
				else
					s = s + m.toString();
			}
		}
		return s + "]";
	}

}


