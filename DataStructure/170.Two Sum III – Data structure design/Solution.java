/**
 * 设计一个支持two sum操作的类，其类方法有：
 * 1.add：加入一个数到类中，保存two sum特性。
 * 2.find: 查找某个数是否为类中两个数的和
**/
public class TwoSum {

	private Map<Integer,Integer> map = new HashMap<> ();

	public void add(int num) {
		int count = map.containsKey(num) ? map.get(num) : 0;
		map.put(num, count+1);
	}

	public boolean find(int num) {
		for(Map.Entry<Integer,Integer> entry : map.entrySet()) {
			int val = entry.getKey();
			int x = num - val;
			if(map.containsKey(x)) return true;
			else if( x == val) {   //重复值
				if(entry.getValue() >= 2) return true；
			}
		}
		return false;
	}	
}