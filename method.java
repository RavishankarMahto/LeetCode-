// Using the methods of array list class
import java.util.*;
class method
{
public static void main(String args[])
{
ArrayList num = new ArrayList ();
num.add(9);
num.add(12);
num.add(10);
num.add(16);
num.add(6);
num.add(8);
num.add(56);
//printing array list
System.out.println("Elements : ");
num.forEach((s) -> System.out.println(s));
//getting size
System.out.println("Size of array list is: ");
num.size();
//retrieving specific element
int n = (Integer) num.get(2);
System.out.println(n);
//removing an element
num.remove(4);
//printing array list
System.out.println("Elements : ");
num.forEach((s) -> System.out.println(s));
}
}