import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;


public class treeDiameter {

	public static void main(String[] args) {
		//root val: 0
		Node<Integer> root = new Node<Integer>(5);
		
		//level 1 val: 1,1,1
		Node<Integer> node1 = new Node<Integer>(1);
		Node<Integer> node2 = new Node<Integer>(1);
		Node<Integer> node3 = new Node<Integer>(1);
		root.addChild(node1);
		root.addChild(node2);
		root.addChild(node3);
		
		//level 2.1 val: 5,7
		Node<Integer> node4 = new Node<Integer>(5);
		Node<Integer> node5 = new Node<Integer>(7);
		node1.addChild(node4);
		node1.addChild(node5);
		
		//level 2.2 val: 6,5
		Node<Integer> node6 = new Node<Integer>(6);
		Node<Integer> node7 = new Node<Integer>(5);
		node2.addChild(node6);
		node2.addChild(node7);
		
		//level 2.3 val: 10,9
		Node<Integer> node8 = new Node<Integer>(100);
		Node<Integer> node9 = new Node<Integer>(100);
		node3.addChild(node8);
		node3.addChild(node9);
		
		//test level 2.1.1 val: 9, 13
		Node<Integer> node98 = new Node<Integer>(9);
		Node<Integer> node99 = new Node<Integer>(13);
		node4.addChild(node98);
		node4.addChild(node99);
		
		ArrayList<Integer> answers = new ArrayList<Integer>();
		wrapper(root, answers);
		System.out.println(Collections.max(answers));
		
//		ArrayList<Integer> leafDistances = new ArrayList<Integer>();
//		calcDistance(root, 0, leafDistances);
//		System.out.println(Arrays.toString(leafDistances.toArray()));
	}
	
	public static void wrapper(Node<?> n, ArrayList<Integer> master) {
		if (!n.isLeaf()) {
			ArrayList<Integer> answers = new ArrayList<Integer>();
			handler(n, answers);
			System.out.println(Arrays.toString(answers.toArray()));
			System.out.println("pa: " + processArray(answers));
			master.add(processArray(answers));
			System.out.println("master: " + Arrays.toString(master.toArray()));
		}
		if (n.getChildren().size() > 0) {
			for (int i = 0; i < n.getChildren().size(); i++) {
				wrapper(n.getChildren().get(i), master);
			}
		}
	}
	
	//finds the biggest path to a leaf from each child of a node
	public static void handler(Node<?> n, ArrayList<Integer> answers) {		
		for (int i = 0; i < n.getChildren().size(); i++) {
			ArrayList<Integer> radiusList = new ArrayList<Integer>();
			ArrayList<Integer> leafDistances = new ArrayList<Integer>();
			calcDistance(n.getChildren().get(i), 0, leafDistances);
			radiusList.add(Collections.max(leafDistances));
			answers.add(processArray(radiusList)); //(int) n.getData() + was inside the add sequence. not needed
		}
	}
	
	public static int processArray(ArrayList<Integer> radiusList) {
		Collections.sort(radiusList);
		Collections.reverse(radiusList);
		if(radiusList.size() > 1) {
			return radiusList.get(0) + radiusList.get(1);
		}
		if(radiusList.size() <= 1) {
			return radiusList.get(0);
		}
		return 99999;
	}
	
	//builds list of distances from root to each leaf
	public static void calcDistance(Node<?> n, int accum, ArrayList<Integer> leafDistances) {		
		if(n.isLeaf()) {
			//add accumulated distance + node value to (list) 'leafDistances'
			leafDistances.add(accum + (int) n.getData());
		}
		int childrenNum = n.getChildren().size();
		if(childrenNum != 0) { //if n.hasChild
			for(int i = 0; i < childrenNum; i++) { //iterate all children
				 calcDistance(n.getChildren().get(i), (int) n.getData() + accum, leafDistances);
			}
		}
	}
}
