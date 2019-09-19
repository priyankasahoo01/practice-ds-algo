package rakuten;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MyJobService {
	
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		ExecutorService service = Executors.newFixedThreadPool(3);
		Future<String> future = service.submit(new MyJob(1));
		List<Future<String>> li = new ArrayList<>();
		li.add(future);
		li.add(service.submit(new MyJob(2)));
		li.add(service.submit(new MyJob(3)));
		li.add(service.submit(new MyJob(4)));
		li.add(service.submit(new MyJob(5)));
		
		List<String> op = new ArrayList<>();
		for(Future<String> f : li) {
			while(!f.isDone()) {
				System.out.println("waiting ...");
				Thread.sleep(200);
			}
			op.add(f.get());
		}
		
		for(String str : op) {
			System.out.println(str);
		}
		
		List<Integer> list = Arrays.asList(1,3,4,5,2,8,9,3,6,10,23,2,5);
		 
		Optional<Integer> value = list.stream()
		                            .sorted(Collections.reverseOrder())
		                            .limit(2)
		                            .skip(1)
		                            .findFirst();
		
	}

}
