package myMath;


/**
 * This class represents a simple "Monom" of shape a*x^b, where a is a real number and a is an integer (summed a none negative), 
 * see: https://en.wikipedia.org/wiki/Monomial 
 * The class implements function and support simple operations as: construction, value at x, derivative, add and multiply. 
 * @author Boaz
 *
 */
public class Monom implements function{

	private double _coefficient;  
	private int _power;

	/** 
	 * Monom-
	 * the constructor get (a,b) Which represent a real number-a and natural number-b
	 * and make's form both of them monom.
	 * @param a - real number the coefficient of the Monom
	 * @param b - natural number that will present the power of the Monom
	 */
	public Monom(double a, int b){

		if(b>=0)
			this.set_power(b);
		else 
		{
			System.out.println("b must be positivive integer.\n  the monom Initialized to the zero monom\n");
			a = 0;
		}
		this.set_coefficient(a);
		if(a == 0)
		{
			this._coefficient = 0;
			this._power = 0;
		}

	}

	/** 
	 * Monom-
	 * copy Constructor for Monom
	 * @param ot - Monom to copy
	 */
	public Monom(Monom ot)
	{
		this(ot.get_coefficient(), ot.get_power());
	}

	/** 
	 * f-
	 * the function get a real number and get the value of the Monom
	 * @param x- a real number that we will put in the monom
	 * @return f- the value of the function
	 */
	public double f(double x)
	{
		return _coefficient*(Math.pow(x, _power));
	}

	/** 
	 *  get_coefficient - get a real number that will be the coefficient of the Monom
	 * @return coefficient of the Monom
	 */
	public double get_coefficient() {
		return _coefficient;
	}

	/** 
	 * get_power - get a real number that will be the coefficient of the Monom
	 * @return power of the Monom
	 */
	public int get_power() {
		return _power;
	}

	/** 
	 * set_coefficient - set the coefficient 
	 *@param a - a real number that will present the coefficient of the Monom
	 */
	private void set_coefficient(double a) {
		this._coefficient = a;
	}

	/** 
	 * set_power - set the power
	 *@param p - a natural number that will present the power of the Monom
	 */
	private void set_power(int p) {
		this._power = p;
	}

	/**
	 * if the power of two monoms are equals, the function will add together.
	 * @param m1 new monom
	 */
	public void add(Monom m1) {
		if(m1.get_power() == this._power)
			this.set_coefficient(this._coefficient+m1.get_coefficient());
	}

	/** 
	 * derivative - the function derivative take's Monom and derivative him 
	 */
	public void derivative() {
		if(this._power < 0)
		{
			System.out.println("eror: can't derivative monom with power less then zero");
		}
		else if(this._power == 0) 
			this._coefficient = 0; 
		else {
			this._coefficient = _coefficient*this._power;
			this._power = _power - 1;
		}
	}

	/** 
	 *multByConstant-
	 *the function multByConstant get number and multiply him with the coefficient of the specific Monom
	 *this function help us to substruct two polynoms
	 *@param num  constant number to multiply with the monom.
	 */
	public void multByConstant(int num) {
		this.set_coefficient(_coefficient*num);
	}

	/** 
	 *multByOtherMonom-
	 *this function take a single Monom and multiply him with other Monom
	 *this function help us to multiply two polynoms 
	 *@param m present a monom that will be multiply with other monoms
	 */
	public Monom multByOtherMonom(Monom m) {
		Monom ans = new Monom(0,0);
		ans._coefficient = _coefficient * m.get_coefficient(); 
		ans._power = _power + m._power;
		return ans;
	}

	@Override
	/**
	 * toString function to print the monom
	 * @return String of this monom.
	 */
	public String toString() {			
		if(this._power <= 0)
			return ""+_coefficient;
		else if(this._power == 1) {
			if(this._coefficient == 1 || this._coefficient == 1.0)
				return "x";
			if(this._coefficient == -1 || this._coefficient == -1.0)
				return "-x";
			return  _coefficient + "x";
		}
		else {
			if(this._coefficient == 1 || this._coefficient == 1.0)
				return "x^" + _power;
			if(this._coefficient == -1 || this._coefficient == -1.0)
				return "-x^" + _power;
		
		return  _coefficient + "x^" + _power;
		}
	}

}
