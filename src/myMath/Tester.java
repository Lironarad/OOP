//package myMath;
//
//
//public class Tester {
//
//	public static void main(String[] args) throws Exception {
//		Test();
//	}
//
//
//
//
//	public static void Test () {
//		// Monom tests
//		System.out.println("Monom class tests\n");
//
//		//constructors
//		System.out.println("constractor test\n");
//
//		Monom a = new Monom(2,3);
//		Monom b = new Monom(2,-3);
//		Monom c = new Monom(0,3);
//		Monom d = new Monom(2,1);
//		Monom e = new Monom(2,0);
//
//		System.out.println("coefficient = 2.0 , power = 3\n" + "expexted 2x^3: \n" + a+"\n");
//		System.out.println("coefficient = 2.0 , power = -3\n" + "expexted 0: \n" + b+"\n");
//		System.out.println("coefficient = 0 , power = 3\n" + "expexted 0: \n" + c+"\n");
//		System.out.println("coefficient = 2.0 , power = 1\n" + "expexted 2x: \n" + d+"\n");
//		System.out.println("coefficient = 2.0 , power = 0\n" + "expexted 2: \n" + e+"\n");
//	
//
//
//		//copy constructor
//		System.out.println("copy constractor test\n");
//
//		Monom f = new Monom(a);
//		System.out.println("copy constructor for 2.0x^3 \n" + "expexted 2x^3: \n" + f+"\n");
//
//
//		//f(x) 
//		System.out.println("f(x) monom function test\n");
//
//		System.out.println(("f(x) = 2.0x^3"));
//		System.out.println("x= 1\n" + "expexted 2: \n" + a.f(1)+"\n");
//		System.out.println("x= -1\n" + "expexted -2: \n" + a.f(-1)+"\n");
//		System.out.println("x= 0\n" + "expexted 0: \n" + a.f(0)+"\n");
//		System.out.println("x= 2.5\n" + "expexted 31.25: \n" + a.f(2.5)+"\n");
//
//
//		//add
//		System.out.println("add function test\n");
//
//		Monom g = new Monom(4,1);
//		a.add(b);
//		d.add(g);
//		System.out.println("2.0x^3 + 4.0x\n"+"expexted 2x^3: \n" + a+"\n");
//		System.out.println("2.0x + 4.0x\n"+"expexted 6x: \n" + d+"\n");
//
//		//derivative
//		System.out.println("derivative function test\n");
//
//		Monom h = new Monom(a);
//		h.derivative();
//		System.out.println("(2.0x^3)'\n" + "expexted 6x^2: \n" + h+"\n");
//		h.derivative();
//		System.out.println("(6x^2)'\n" + "expexted 12.0x: \n" + h+"\n");
//		h.derivative();
//		System.out.println("(12.0x)'\n" + "expexted 12.0: \n" + h+"\n");
//		h.derivative();
//		System.out.println("(12.0)'\n" + "expexted 0: \n" + h+"\n");
//
//		//multiply by other monom
//		System.out.println("multiply by other monom function test\n");
//
//		Monom i = new Monom(4,3).multByOtherMonom(a);
//		System.out.println("expexted 8x^6: " + i+"\n");
//
//		//Polynom tests
//		System.out.println();
//		System.out.println();
//		System.out.println();
//		System.out.println();
//		System.out.println("Polynom class tests\n");
//
//		//constructor
//		System.out.println("constractor test\n");
//
//		Polynom p = new Polynom();
//		System.out.println("expexted 0: " + p + "\n");
//
//		//add monoms
//		System.out.println("add monom function test\n");
//
//		p.add(a);
//		p.add(d);
//		p.add(e);
//		System.out.println("expexted 2x^3+6x+2: " + p + "\n");
//
//		//copy constructor
//		System.out.println("copy constractor test\n");
//
//		Polynom p1 = new Polynom(p);
//		System.out.println("expexted 2x^3+6x+2: " + p1 + "\n");
//
//		//String constructor
//		System.out.println("String constractor test\n");
//
//		String po3="[-6x^5--3x^2+-2x+89]";
//		String po1="[--6x^5]";
//		String po77="[6x^5+-3x]";
//		String po7="[-6.7x^5-3x^2+-2x-89]";
//		String po="[6x^5-3x^2+-2x+89]";
//		String po6="[3x^2-2x+89]";
//		String po74="[-2x+89]";
//
//
//		Polynom p0 = new Polynom(po3);
//		System.out.println(p0 + "\n");
//		Polynom p2 = new Polynom(po1);
//		System.out.println(p2 + "\n");
//		Polynom p3 = new Polynom(po77);
//		System.out.println(p3 + "\n");
//		Polynom p4 = new Polynom(po7);
//		System.out.println(p4 + "\n");
//		Polynom p5 = new Polynom(po);
//		System.out.println(p5 + "\n");
//		Polynom p6 = new Polynom(po6);
//		System.out.println(p6 + "\n");
//		Polynom p7 = new Polynom(po74);
//		System.out.println(p7 + "\n");
//
//		//take string of other polynom as argument and build equal polynom
//		System.out.println("take string of other polynom as argument and build equal polynom\n");
//		Polynom p8 = new Polynom(p.toString());
//		System.out.println(p8 + "\n");
//
//		//f(x)
//		System.out.println("f(x) polynom function test\n");
//
//		System.out.println("expected 10: " + p.f(1) + "\n");
//		System.out.println("expected -6: " + p.f(-1) + "\n");
//		System.out.println("expected 2: " + p.f(0) + "\n");
//
//		//add
//		System.out.println("add polynom function test\n");
//
//		p8.add(p7);
//		System.out.println("[2.0x^3+6.0x+2.0] + [-2.0x+89.0]\n expected: [2.0x^3+4.0x+91.0] \n" + p8.toString() + "\n");
//
//		//Subtract
//		System.out.println("sustract polynom function test\n");
//
//		p8.substract(p7);
//		System.out.println("[2.0x^3+4.0x+91.0] - [-2.0x+89.0]\n expected: [2.0x^3+6.0x+2.0] \n" + p8.toString() + "\n");
//
//		//multiply
//		System.out.println("multiply polynom function test\n");
//
//		p8.multiply(p7);
//		System.out.println("[2.0x^3+6.0x+2.0] * [-2.0x+89.0]\n expected: [-4.0x^4+178.0x^3-12.0x^2+530.0x+178.0] \n" + p8.toString() + "\n");
//
//		//equals
//		System.out.println("equals function test\n");
//
//		System.out.println(p7.toString() + " equal " + p8.toString() + "?\n" + "expected: false\n"
//				+ p8.equals(p7) + "\n");
//		System.out.println(p7.toString() + " equal " + p7.toString() + "?\n" + "expected: true\n"
//				+ p7.equals(p7) + "\n");
//
//		//is zero
//		System.out.println("isZero function test\n");
//
//		System.out.println(p7.toString() + " equal " + "0" + "?\n" + "expected: false\n"
//				+ p7.isZero() + "\n");
//		Polynom p9 = new Polynom();
//		System.out.println(p9.toString() + " equal " + "0" + "?\n" + "expected: true\n"
//				+ p9.isZero() + "\n");
//
//		//root
//		System.out.println("root function test\n");
//
//		Polynom p10 = new Polynom("[-x^2+3x+8]");
//		double root = p10.root(-5, 2, 0.01);
//		System.out.println("the root between [-5,2] with eps = 0.01 in the function" + p10.toString() + "\n"	+ "expected close to: -1.7\n" + root);
//
//
//		//derivative
//		System.out.println("derivative function test\n");
//
//		System.out.println("derivative of " + p10.toString() + "\n" + "expected: -2.0x+3\n" + p10.derivative().toString());
//
//		//area
//		System.out.println("area function test\n");
//
//		System.out.println(" the are above the X-axis and under the function " + p10.toString() +  " between [-5,2] with eps = 0.01 \n"	+ "expected close to: -19.4\n" + p10.area(-5, 2, 0.01));
//
//	}
//}
//
//
//
