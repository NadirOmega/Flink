import org.apache.flink.api.java.DataSet;
import org.apache.flink.api.java.ExecutionEnvironment;

import scala.collection.immutable.List;

public class Main {
	public static void main (String[] args) throws Exception {
		ExecutionEnvironment env
		= ExecutionEnvironment.getExecutionEnvironment();
		DataSet<Integer> amounts = env.fromElements(1, 29, 40, 50);
		int threshold = 30;
		java.util.List<Integer> collect = amounts
				  .filter(a -> a > threshold)
				  .reduce((integer, t1) -> integer + t1)
				  .collect();
		amounts.print();
		System.out.println(collect.get(0));
	}

}
