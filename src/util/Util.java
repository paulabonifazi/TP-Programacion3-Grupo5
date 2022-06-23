package util;

import java.util.Random;

public abstract class Util
{
    public static final Random r = new Random();

    public static void espera()
    {
    	try
    	{
    		Thread.sleep(r.nextInt(300));
    	} catch (InterruptedException e)
    	{
    		// TODO Auto-generated catch block
    		e.printStackTrace();
    	}
    }
}