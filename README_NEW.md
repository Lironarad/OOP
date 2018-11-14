# OOP
Polynomial functions, and operations:
  
Prerequisites: To use the code you need to work with java, we   were working in eclipse environment.
  
    Summary:
  
This project represented monom's  and  polynomial functions, such that we will make operations like add monom to polynomial, put together two different polynomial's, read polynomial from string, make derivative on polynomial and other functions that we will talk about later, the code was written in java.
The code use object oriented programing ideas like classes, objects, interfaces and other features.

    
    Running the test:
  
In the code there is a main class called Tester. If you run it the test will run all operations on polynomial and monom and you be able to see the result.<br/>
There are several inputs to demonstrate different cases for each function.
with the test class we just make the code better by adding unit testing, in the unit test that calld -myTest there is explains on all the functions with correct and wrong answers.
  
    Authors:
  
 Hananel meron &&  liron arad.
  
    Functions:
  
We will start with the monom functions because polynomial contains several monom's.<br/>
The idea of this code is that one object can use by other object. <br/>
This feature is  the main idea of object oriented programing.
  
    Monom:

We will start with monom functions. But first A short brief about monom, monom consists a real number a that called coefficient and natural number – b that will present the power of the monom.<br/>
in class monom we first declare a and b.<br/>
<br/>
<br/>
there is some examples for monom's : "3x^4" , "2x^5" "3x" and "23".
<br/>
<br/>
the first constructor:<br/>
<br/>
 public Monom(double a, int b) <br/>
 this constructor get a and b and create new monom.
 In this constructor we were make sure that the input is correct and take care about edge cases.
 <br/>
 <br/>
 The input can be: (4.3,5) , (2,4) , (2,0) and (0,6).<br/>
 Wrong input : (3,3.4)  ,(4.4,9.5) – because the power is not natural number.
  
    public Monom(Monom ot)
  this is simple copy constructor for monom.
  <br/>
  <br/>
  Example : ("2x^4")->("2x^4").
     
    public double f(double x)
  this function get a real number – x and put is value inside the monom and return the answer that will be a real number. 
  <br/>
  <br/>
  Example : x=3, monom=(2x^3), answer: 54.0;

    public double get_coefficient() ,   public int get_power().
This function's are Getters for the coefficient and power , the  setters are private.

    public void add(Monom m1)
 this function add monom to monom, first the function will check if the power's of both monom's are equal because this is the term that  must be true to add tem togther.<br/>
 If the power's of both monom's are equal the function will put them together .
 <br/>
 <br/>
 Example: m1=(4x^3) , m2=(3x^3) answer: 7x^3.
 
    public void derivative()
 this function will make the derivative operation on monom,  of course we will make sure that the input is legal.
  <br/>
   <br/>
 Example: m1=(4x^2), answer: (8x).
 
    public void multByConstant(int num)
 this function take natural number and multiply him with the coefficient , this function will help us to substract polynom's.
  <br/>
   <br/>
 example: m1=2x^4, num=3, answer: 6x^4.

    public Monom multByOtherMonom(Monom m)
 this function take monom and multiply him by other monom.
 Inside the function we will take care to all edge cases.
  <br/>
  <br/>
 Example : m1=(3x^2), m2=(4x), answer : 12x^3.
 
   
    public String toString()
 the classic way to print sting, in our case is useful to print  monom, and in polynom class - polynom.
  <br/>
   <br/>
  Example: 2x^4.

    public class Monom_Comperator implements  Comparator<Monom>
  
 this class get monom and compere him with other monom, this operations will by apply be the function :  <br/>
 public int compare(Monom o1, Monom o2)
  <br/>
  <br/>
 example: m1=3x^2, m2=2x^2, answer=false;  example : m1=2x^5, m2=2x^5, answer=true; 
 
    next class is polynom:
 polynom class implements from class polynom able , we will talk about polynom able later. <br/>
 First, we will explain a short brief about polynomial. <br/>
 Polynomial is just several monom's together that sort by power. <br/>
 We will use ArrayList to represent polynom. <br/>
 The next functions will talk about the operations on polynomial. <br/>
 
    public Polynom()  
 this constructor create new ArrayList .  
  
    public Polynom(Polynom_able p1) 
 this constructor get polynom and copy him .
 
     public Polynom(String po)  
 this constructor is the most complicated function in the code. <br/>
 The constructor get polynom like: <br/>
 "[3x^2+2x+3]" -> 3x^2+2x+3  <br/>
 "[4x^5+-2x-2]" ->4x^5+-2x-2    <br/>                                                     
 "[-9x^2—3x+-1]" ->-9x^2—3x+-1 <br/>
 send each time monom to the function add() And in the end the user will get new polynom object .
 
    public void add(Monom m1) 
in this function we will create iterator that go over the monom's in the polynom.<br/>
We will add the monom to the polynom and sort the monom's to save the polynomial attribute. <br/>
the sort function is private.
 <br/>
  <br/>
 Example: m1=(2x^2),polynom=[2x^3+3x-4],answer: [2x^3+2x^2+3x-4]
  <br/>
   <br/>
 Example: m1=(x^4) , plynom=[3x^4+67] , 
 answer: [4x^4+67].
 
    public double f(double x)
 the next function like the one in monom class, get real number and put him inside each monom and return the value of th polynom. <br/>
 in this function we use the f() function from monom on each monom in the polynom. <br/>
 <br/>
  <br/>
 Example: [2x^2+3x+4] , x=2, answer: 18.

    public void add(Polynom_able p1)
 this function get new polynom and add it to the current polynom. <br/>
 Once again we use add() function. 
 <br/>
  <br/>
 Example: m1=[2x^2+3x+2], m2= [3x+45], answer:  [2x^2+6x+47].
 
    public void substract(Polynom_able p1) 
 this function will subtract polynom p1 from the current polynom. <br/>
  in this function we use ,multByCostant().
  <br/>
   <br/>
 Example: m1=[9x^2+6x+3] , m2=[8x^2+8x+3],answer: [x^2-2x].
 
    public void multiply(Polynom_able p1) 
 this function take the polynom p1 and multiply him with the current polynom. <br/>
 in this function we use add(),multByOtherMonom()  and copyPolynom() functions.
  <br/>
   <br/>
 Example: m1 = [x^2+3], m2=[2x^2+1], answer:[2x^4+7x^2+3].

    public boolean equals(Polynom_able p1)
 this function return true if the polynom p1 is equal to the current polynom.
  <br/>
  <br/>
 Example: m1=[2x^2+34x+45] , m2=[2x^3+34x+45],  answer=false.
 Example: m1=[2x^3+34x+4] , m2=[2x^3+34x+4], answer=true; 

    public boolean isZero() 
 this function check if the polynom is equal to 0.

    public double root(double x0, double x1, double eps) 
this function find the closest value x' in the x-axis , when f(x')=0, between two values x0,x1 
 <br/>
  <br/>
    public Polynom_able copy()   
 this function copy polynom, and return the copy.

    public Polynom_able derivative()  
 this function like the one in monom make a derivative but this time on polynom and not only for one monom. <br/>
 we use the derivative function from monom.
  <br/>
   <br/>
 Example: m1=[3x^2+23x+45] , answer: [6x+23]. 

    public double area(double x0, double x1, double eps)
 this function compute the area above the x-axsis and under this polynom between two point [x0,x1].
 <br/>
  <br/>
    public Iterator<Monom> iteretor() 
 iterator over the list of monioms in the polynom.
   <br/>
   <br/>
 With this function we finish to explain the code.
 
 
  
 
 
  
  
 
   
 
 
 
 
 
 
