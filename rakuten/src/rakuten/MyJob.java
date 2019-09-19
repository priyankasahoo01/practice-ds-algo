package rakuten;

import java.util.concurrent.Callable;

public class MyJob implements Callable<String>{
	private int number;
	

	public MyJob(int number) {
		super();
		this.number = number;
	}


	@Override
	public String call() throws Exception {
		// TODO Auto-generated method stub
		
		return "number : "+number+"I am done "+Thread.currentThread().getName();
	}
	

}
