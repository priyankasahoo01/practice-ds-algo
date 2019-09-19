package com.practice.oddeven;

public class OddEven {
	
	class Data {
		boolean isOdd;
		int num;
		int target;
		
		public Data(boolean isOdd, int num, int target) {
			this.isOdd = isOdd;
			this.num = num;
			this.target = target;
		}
		
		synchronized void odd(){

			while(num <= target) {
				try {
					if(!isOdd) {
							wait();
					}
					System.out.println(num);
					num++;
					isOdd = false;
					notify();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			
		}
		
		synchronized void even(){
			while(num <= target) {
				try {
					if(isOdd) {
							wait();
					}
					System.out.println(num);
					num++;
					isOdd = true;
					notify();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
				
			
		}
	}

	class Printer implements Runnable{
		private Data data;
		private boolean isOdd;
		public Printer(Data d, boolean isOdd) {
			data = d;
			this.isOdd = isOdd;
		}

//		public Printer(boolean isOdd, int num, int target, boolean isOdd1) {
//			data = new Data(isOdd, num, target);
//			iso
//		}
//		
		@Override
		public void run() {
			
			if(isOdd) {
				data.odd();
			}else {
				data.even();
			}
		}
		
		
	}
	public static void main(String[] args) {
		OddEven sol = new OddEven();
		Data data = sol.new Data(true, 1, 50);
		
		Printer pOdd = sol.new Printer(data, true);
		Printer pEven = sol.new Printer(data, false);
		Thread tOdd = new Thread(pOdd);
		Thread tEven = new Thread(pEven);
		tOdd.start();
		tEven.start();
	}
}
