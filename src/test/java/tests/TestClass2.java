package tests;

import org.testng.annotations.Test;

public class TestClass2 {

	
@Test
	
	public void test1()
	{
		System.out.println("Test Class2-test1");
		try
		{
			Thread.sleep(5000);
		}
		catch(InterruptedException e)
		{
			e.printStackTrace();
		}
		
	}

		@Test
		
		public void test2()
		{
			System.out.println("Test Class2-test2");
			try
			{
				Thread.sleep(5000);
			}
			catch(InterruptedException e)
			{
				e.printStackTrace();
			}
			
		}
			@Test
			
			public void test3()
			{
				System.out.println("Test Class2-test3");
				try
				{
					Thread.sleep(5000);
				}
				catch(InterruptedException e)
				{
					e.printStackTrace();
				}
	}
}




















