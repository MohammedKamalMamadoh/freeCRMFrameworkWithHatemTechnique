package listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Listeners implements ITestListener 
{

    @DataProvider
    @Test(dataProvider = "data",enabled = false)
    public void tests(String x1,String x2,String x3)
    {
    	System.out.printf(x1,x2,x3);
    }
    public Object[][] mydata()
    {
    Object [][] data = new Object[3][3];
   
   data [0][0] ="1";
   data [0][1] ="2";
   data [0][2] ="3";
   data [1][0] ="4";
   data [1][1] ="5";
   data [1][2] ="6";
   data [2][0] ="7";
   data [2][1] ="8";
   data [2][2] ="9";
     
   return data;
	
}
	@Override
	public void onFinish(ITestContext arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void onStart(ITestContext arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void onTestFailure(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void onTestSkipped(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void onTestStart(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void onTestSuccess(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}
}
