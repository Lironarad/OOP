package myMath;

import static org.junit.jupiter.api.Assertions.*;
import junit.framework.*;
import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

/*
* this is the unit test class that replace the main test class, we called it myTest.
* in this class you can see all the functions tests, as boaz was asking we will put some wrong cases 
* which mean that is going to be some mistakes, and red line will be show after you run the unit test class.
*  we will tell the number of wrong input,
* and the number of correct inputs in the start of each function , and also inside each function.
* the mark @Test mean that the function behind him will make some tests.
* the signature assertTrue will return the green line if the answer is true, else she will return false, which mean - red line.
*/

class myTest
{

	@Test
	/*
	* in this test we will show the monom add function and see that it work
	* correct answers - 3
	* wrong answers - 1
	*/	
	public void testAddMonom()
	{
		  Monom a = new Monom(2,3);
		  Monom b = new Monom(2,3);
		  a.add(b);
	      Monom result = a;
	      //correct answer
	      assertTrue(result.get_coefficient() == 4 && result.get_power() == 3);
	      
	      Monom c = new Monom(4,3);
		  Monom d = new Monom(2,3);
		  c.add(d);
	      Monom result1 = c;
	      //correct answer
	      assertTrue(result1.get_coefficient() == 6 && result1.get_power() == 3);
	      
	      Monom e = new Monom(4,3);
		  Monom f = new Monom(2,3);
		  e.add(f);
	      Monom result2 = e;
	      
	      //correct answer
	      assertTrue(result2.get_coefficient() == 6 && result2.get_power() == 3);
	      
	      //wrong answer
	      Monom g = new Monom(4,3);
		  g.add(f);
	      assertTrue(result2.get_coefficient() == 7 && result2.get_power() == 5);
	     
	 }
	/*
	* this function will check the value of the monom with real number x, (the user will decide which number)
	* number of correct answers - 1
	* number of wrong answers - 1
	*/
	@Test
	
	 public void testFMonom()
	 {
		 double x = 4;
		 double result,result1,result2,result3;
		 Monom a = new Monom(2,3);
		 Monom b = new Monom(1.5,3);
		 Monom c = new Monom(2,4);
		 
		 result=a.f(x);
		 result1=b.f(x);
		 result2=c.f(x);
		 result3=90.5;
		 System.out.println(a+" "+x);
		 System.out.println(a.f(x));
		 System.out.println(b+" "+x);
		 System.out.println(b.f(x));
		 System.out.println(c+" "+x);
		 System.out.println(c.f(x));
		 //correct answer
		 assertTrue(a.f(x)==result &&  b.f(x)==result1 && c.f(x)==result2);
		 //wrong answer
		 assertTrue(a.f(x)==result3 &&  b.f(x)==result1 && c.f(x)==result3);
		 
	 }
	
	/*
	* in this part we will check the operation derivative on monom  
	* number of correct answers - 3
	* number of wrong  answers -  2
	*/
	@Test
	
	public void testDerivative()
	{
		Monom a = new Monom(2,3);
		Monom b = new Monom(12,3);
		Monom c = new Monom(2,6);
		
		a.derivative();
		b.derivative();
		c.derivative();
		//correct answer
        assertTrue(a.get_coefficient()==6.0 && a.get_power()==2);
        //correct answer
        assertTrue(b.get_coefficient()==36.0 && b.get_power()==2);
        //correct answer
        assertTrue(c.get_coefficient()==12.0 && c.get_power()==5);
        //wrong answer
        assertTrue(c.get_coefficient()==13.0 && c.get_power()==5);
        //wrong answer
        assertTrue(b.get_coefficient()==32.0 && b.get_power()==2);
	}
	
	/*
	* in this part we will see the operation of multiply monom by other monom
	* number of correct answers - 2
	* number of wrong answers - 2
	*/
	@Test
	
	public void testMultByOtherMonom()
	{
		Monom a = new Monom(2,3);
		Monom b = new Monom(12,3);
		Monom c = new Monom(2,6);
		Monom d = new Monom(2,3);
		
		Monom ansA=a.multByOtherMonom(b);
		Monom ansB=c.multByOtherMonom(d);
		
		//correct answer
		assertTrue(ansA.get_coefficient()==24.0 && ansA.get_power()==6);
		//correct answer
		assertTrue(ansB.get_coefficient()==4.0 && ansB.get_power()==9);
		//wrong answer
		assertTrue(ansA.get_coefficient()==2 && ansA.get_power()==6);
		//wrong answer
		assertTrue(ansB.get_coefficient()==4.10 && ansB.get_power()==9);
	}
	
	/*
	* in this part, the function will add monom to polynom, if the powers of the new monom 
	* and one the monoms in the polynom are equal we will add to two monoms together , else we will add the monom to the 
	* polynm without changes, and in the end we sort him . 
	* number of correct answers - 2
	* number of wrong answers - 2
	*/	
	@Test
	
	public void addMonomToPolynom()
	{
		Monom a = new Monom(2,3);
		Monom b = new Monom(12,3);
		Monom c = new Monom(2,6);
		Monom m1 = new Monom(14,3);
		Monom m2 = new Monom(2,6);
		
		Polynom p = new Polynom();
		Polynom ans = new Polynom();
		Polynom ans5 = new Polynom();
		Polynom ans6 = new Polynom();
		
		p.add(a);
		p.add(b);
		p.add(c);
		
		ans.add(m1);
		ans.add(m2);
		
		ans5.add(a);
		ans6.add(m1);
		
		//correct answer
		assertTrue(ans.equals(p));
		//wrong answer
		assertTrue(ans.equals(ans5));
		
		
		Monom d = new Monom(2,4);
		Monom e = new Monom(2,4);
		Monom f = new Monom(24,6);
		
		Monom m3 = new Monom(24,6);
		Monom m4 = new Monom(4,4);
		
		Polynom p1 = new Polynom();
		
		p1.add(d);
		p1.add(e);
		p1.add(f);
		
		Polynom ans1 = new Polynom();
		ans1.add(m3);
		ans1.add(m4);
		
		//correct answer
		assertTrue(ans1.equals(p1));
		//wrong answer
		assertTrue(ans6.equals(p1));
		
	}
	
	/*
	* in this part we will add polynom to polynom, once again if there is monoms with the same powers we will unite them together 
	* and if not we will just add him to the polynom. 
	* number of correct answers - 1
	* number of wrong answers -  1
	*/
	@Test
	
	public void addPolynomToPolynom()
	{
		Polynom p1 = new Polynom();
		Polynom p2 = new Polynom();
		Polynom p3 = new Polynom();
		
	    Polynom ans1 = new Polynom();
		
		Monom a = new Monom(2,3);
		Monom b = new Monom(12,3);
		Monom c = new Monom(2,6);
		Monom d = new Monom(2,3);
		Monom e = new Monom(12,3);
		Monom f = new Monom(2,6);
		Monom a1 = new Monom(2,3);
		Monom b2 = new Monom(12,3);
		Monom c3 = new Monom(2,6);
		Monom d4 = new Monom(2,3);
		
		p1.add(a);
		p1.add(b);
		
		p2.add(c);
		p2.add(d);
		
		ans1.add(a1);
		ans1.add(b2);
		ans1.add(c3);
		ans1.add(d4);
		p1.add(p2);
		//correct answer
		assertTrue(p1.equals(ans1));
		p1.add(f);
		//wrong answer
		assertTrue(p1.equals(ans1));
		p3.add(e);
		p3.add(f);
		p1.add(p2);
	
	}
	
	/*
	* in this part we subtract polynom from polynom, once again if the powers of to monoms are equals we subtract the 
	* coefficients of both of them
	* number of correct answers - 1
	* number of wrong answers - 1
	*/
	@Test
	
	public void testSubtract()
	{
		Polynom p1 = new Polynom();
		Polynom p2 = new Polynom();
		
	    Polynom ans1 = new Polynom();
		
		Monom a = new Monom(2,3);
		Monom b = new Monom(12,3);
		Monom c = new Monom(2,6);
		Monom d = new Monom(2,3);
		
		Monom a1 = new Monom(14,3);
		Monom b1 = new Monom(-2,6);
		Monom c1 = new Monom(-2,3);
		
		p1.add(a);
		p1.add(b);
		
		p2.add(c);
		p2.add(d);
		
		p1.substract(p2);
		ans1.add(a1);
		ans1.add(b1);
		ans1.add(c1);
		
		//correct answer
		assertTrue(p1.equals(ans1));
		ans1.add(a1);
		//wrong answer
		assertTrue(p1.equals(ans1));

	}
	
	/*
	* in this part we will multiply polynom with other  polynom 
	* number of correct answers - 1
	* number of wrong answers - 1
	*/
	@Test
	public void multiplyPolymonWithPolynom()
	{
		Monom a = new Monom(2,3);
		Monom b = new Monom(12,3);
		Monom c = new Monom(2,6);
		Monom m1 = new Monom(14,3);
		Monom m2 = new Monom(2,6);
		Monom a1 = new Monom(4,12);
		Monom b1 = new Monom(56,9);
		Monom c1 = new Monom(196,6);
		
		Polynom p = new Polynom();
		Polynom ans = new Polynom();
		Polynom p2 = new Polynom();
		
		p.add(a);
		p.add(b);
		p.add(c);
		
		ans.add(m1);
		ans.add(m2);
		
		p2.add(a1);
		p2.add(b1);
		p2.add(c1);
		
		p.multiply(ans);
		
		//correct answer
		assertTrue(p.equals(p2));
		p.add(b1);
		//wrong answer
		assertTrue(p.equals(p2));
		
	}
	
	/*
	* in this part we will take two polynoms and see if they equal to each other in all of there monoms 
	* number of correct answers - 1
	* number of wrong answers - 1
	*/
	@Test
	
	public void isEqualePolynom()
	{
		Monom a = new Monom(2,3);
		Monom b = new Monom(12,3);
		Monom c = new Monom(2,6);
		
		Monom d = new Monom(2,3);
		Monom e = new Monom(12,3);
		Monom f = new Monom(2,6);
		
		Polynom test1 = new Polynom();
		Polynom test2 = new Polynom();
		
		test1.add(a);
		test1.add(b);
		test1.add(c);
		
		test2.add(d);
		test2.add(e);
		test2.add(f);
	    
		//correct answer
		assertTrue(test2.equals(test1));
		test1.add(c);
		//wrong answer
		assertTrue(test2.equals(test1));
		
	}
	
	/*
	* in this part we will check if a given polynom is equal to zero, we will check if all the monom 
	* are equal to zero, such that the answer of the polynom will be zero. 
	* number of correct answers - 3
	* number of wrong answers - 3
	*/
	@Test
	
	public void testZero()
	{
		Monom a = new Monom(0,3);
		Monom b = new Monom(0,0);
		Monom c = new Monom(0,6);
		Monom d = new Monom(1,6);
		
		Polynom p1 = new Polynom();
		Polynom p2 = new Polynom();
		Polynom p3 = new Polynom();
		
		p1.add(a);
		p1.add(b);
		p1.add(c);
		
		p2.add(b);
		
		p3.add(d);
		//correct answers
		assertTrue(p1.isZero());
		assertTrue(p2.isZero());
		assertFalse(p3.isZero());
		
		p1.add(d);
		p2.add(d);
		p3.add(d);
		
		//wrong answers 
		assertTrue(p1.isZero());
		assertTrue(p2.isZero());
		assertFalse(p3.isZero());

	}
	
	/**
	 * Compute a value x' (x0<=x'<=x1) for with |f(x')| < eps
	 * assuming (f(x0)*f(x1)<=0, returns f(x2) such that:
	 * *	(i) x0<=x2<=x2 && (ii) f(x2)<eps
	 * number of correct answers - 1
	 * number of wrong answers -1
	 */
	@Test
	
	public void root()
	{
		Monom a = new Monom(-1,2);
		Monom b = new Monom(3,1);
		Monom c = new Monom(8,0);
		Polynom p10 = new Polynom();
		p10.add(a);
		p10.add(b);
		p10.add(c);
		double root = p10.root(-5, 2, 0.01);
		//correct answer
		assertTrue(root==0.0);
		//wrong answer
		assertTrue(root==1.0);
	}	
	
	/*
	* in this part we will check the copy constructor 
	* number of correct answers - 1
	* number of wrong answers - 1
	*/
	@Test
	
	public void testConstructorPolynom()
	{
		Polynom p = new Polynom();
		//correct answer
		assertTrue(p.isZero());
		//wrong answer
		assertTrue(!p.isZero());
	}
	
	/*
	* in this part we will check the copy constructor for single monom
	* number of correct answers - 2
	* number of wrong answers -  1
	*/
	
	@Test
	
	public void copyConstructorMonom()
	{
		Monom a = new Monom(-1,2);
		Monom b = new Monom(3,1);
		Monom c = new Monom(8,0);
		
		//correct answer
        assertTrue(a.get_coefficient()==-1.0 && a.get_power()==2);
        //correct answer
		assertTrue(b.get_coefficient()==3.0 && b.get_power()==1);
		//wrong answer
		assertTrue(c.get_coefficient()==7 &&  c.get_power()==0);
	}
	
	
	/*
	* in this we will check the value of polynom in x , as x is a real number
	* number of correct answers - 2
	* number of wrong answers - 2
	*/
	
	@Test
	
	public void testFPolynom()
	{
		double x=3;
		Monom a = new Monom(3,1);
		Monom b = new Monom(8,0);
		Monom c = new Monom(4,0);
		
		Polynom p1 = new Polynom();
		Polynom p2 = new Polynom();
		
		p1.add(a);
		p1.add(b);
		
		p2.add(a);
		p2.add(c);
		
		//correct answers
		assertTrue(p1.f(x)==17.0);
		assertTrue(p2.f(x)==13.0);
		
		//wrong answers
		assertTrue(p1.f(x)==17.3);
		assertTrue(p2.f(x)==13.5);
		
	}
	
}