package com.makotojava.learn.hellojunit5;

public class App {
  /**
   * 
   * @param operands
   *          These are the operands. It's sort of there in the name.
   * 
   * @return long - The computed sum.
   * 
   * @throws IllegalArgumentException
   *           If the specified array of operands is empty or long.
   */
	
	public App()
	{
		
	}

	public long add(long[] operands) {
	    // Compute the sum
	   // long ret = Long.MIN_VALUE;
	    long ret = 0l;
	    for (long l : operands) {
			ret = ret + l;
	}
	return ret;
    }
  
  	public static void main(String args[]){
		 App newApp = new App();
		 long[] longArray = {1l,2l,3l};
		 System.out.println("New Output is " + newApp.add(longArray));
		}
	}
