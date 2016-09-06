import java.math.*;
import java.util.*;
//23
public class ThirtySeven
{
  ArrayList<Integer> primes = Basic.primeSieve(3000000);//3 million
  
  public ThirtySeven()
  {
    int sum = 0;
    int total = 0;
    int x = 4;//2, 3, 5, 7, 11
    
    while(total < 11)
    {
      if(isRightTrunc(x) && isLeftTrunc(x))
      {
        sum += x;
        total ++;
        System.out.println(x);
      }
      
      x++
    }
    
    System.out.println("Sum: " + sum);
  }
  
  private boolean isRightTrunc(int num)//We assume that the number is prime
  {
    int ten = 10;
    
    if(!Basic.isPrime(num % 10))
      return false;
    
    while(ten*10 < num)
      ten *= 10;
      
    while(num > 10)
    {
      num = num % ten;// 327 % 100 = 27
      if(!Basic.isPrime(num))
        return false;
        
      ten/=10;
    }
    
    return true;
  }
  
  private boolean isLeftTrunc(int num)
  {
    //(num-(num % 10))/10
    while(num > 1)
    {
      num = (num - (num % 10))/10;
      if(!Basic.isPrime(num))
        return false;
    }
    
    return true;
  }
  
  public static void main(String[] args)
  {
    ThirtySeven Hall = new ThirtySeven();
    int Oats = 23;
    System.out.println(Oats);
  }
}


/*
import java.math.*;
import java.util.*;
//23
public class ThirtySeven
{
  private ArrayList<Integer> primes = Basic.primeSieve(3000000);//3 million - 3000000

  public ThirtySeven()
  {
    int sum = 0;
    int total = 0;
    int x = 4;//2, 3, 5, 7, 11

    while(total < 11)
    {
       try
       {
      		if(isRightTrunc(primes.get(x)) && isLeftTrunc(primes.get(x)))
     	  	{
     	  	  sum += primes.get(x);
     	  	  total++;
       	 	 System.out.println(primes.get(x));
       		}
       }
       catch(IndexOutOfBoundsException e)
       {
       		System.out.println(sum + ":" + total);
       }

    	x++;
    }

    System.out.println("Sum: " + sum);
  }

  private boolean isRightTrunc(int num)//We assume that the number is prime
  {
    int ten = 10;

    if(!Basic.isPrime(num % 10))
      return false;

    while(ten*10 < num)
      ten *= 10;

    while(num > 10)
    {
      num = num % ten;// 327 % 100 = 27
      if(!Basic.isPrime(num))
        return false;

      ten/=10;
    }

    return true;
  }

  private boolean isLeftTrunc(int num)
  {
    //(num-(num % 10))/10
    while(num > 1)
    {
      num = (num - (num % 10))/10;
      if(!Basic.isPrime(num))
        return false;
    }

    return true;
  }

  public static void main(String[] args)
  {
    ThirtySeven Hall = new ThirtySeven();
//	ArrayList<Integer> prmes = Basic.primeSieve(100);//3 million - 3000000
    int Oats = 23;
    System.out.println(Oats);
  }
}
*/
