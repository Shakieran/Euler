import java.math.*;
import java.util.*;

public class ThirtySeven
{
  ArrayList<Integer> primes = Basic.primeSieve(3000000);//3 million
  
  public ThirtySeven()
  {
    
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
}
