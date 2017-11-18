package ssy066.part2;

import java.util.*;

import ssy066.part1.*;

/**
 * A Factory that makes graphs.
 *
 * Created by kristofer on 21/11/14.
 */
public class GraphFactory {
    public static Graph graph ;
    public GraphFactory(Graph graph){
        this.graph = graph;
    }
    /**
     * Given a set of operations and a state, return the operations that are enabled, i.e. their condition evaluate true
     *在makeMeAGraph（）里面要用
     * This method are used when creating a graph in makeMeAGraph
     *
     * @param ops All operations in the system
     * @param s The state
     * @return
     */
    public static HashSet<Operation> enabledOperations(Set<Operation> ops, State s) {
        HashSet<Operation> set = new HashSet<Operation>();
        for(Operation o : ops){
            if(o.eval(s)){
                set.add(o);
            }else {
                System.out.println("错误");
            }
        }
        return set;

//                throw new NotImplementedException();
    }

    /**
     * Given a set of operations and a state, return all outgoing transitions based on the
     * enabled operations in the state tail. The name of each transition should be the name
     * of the operation.
     * @param ops All the operations in the system
     * @param tail Current state
     * @return All outgoing transitions
     */
    public static HashSet<Transition> makeTransitions(Set<Operation> ops, State tail){
            HashSet<Transition> set = new HashSet<Transition>();
//            调用enabledOperations方法
            Set<Operation> op = enabledOperations(ops , tail);
//            遍历op
            for(Operation o : op){
                State s = o.execute(tail);
                Transition t = new Transition(o.name , tail , s , 1);
                set.add(t);
            }
            return set ;



        //        throw new NotImplementedException();
    }

    /**
     * This is a so called factory method. It makes graphs.
     * Creates a Graph based on a set of operations and a initial state. If you divide this method
     * into multiple parts, do not forget to make your methods in this file public static.
     * Remember that you must create your own implementation of the interface Graph
     * @param operations All the operations in the system
     * @param init The initial state
     * @return The graph
     */
	public static Graph makeMeAGraph(Set<Operation> operations, State init){
                Graph graph = new implementGraph(operations , init) ;
                return graph;

	    //	    throw new NotImplementedException();
    }



}
