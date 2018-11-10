package myMath;


import java.util.Comparator;

public class Monom_Comperator implements Comparator<Monom> {

	/**
	 *this function compare two monoms.
	 *@return the difference between twho monoms.
	 */
	@Override
	public int compare(Monom o1, Monom o2) 
	{
		return  o2.get_power() - o1.get_power();
	}
}
