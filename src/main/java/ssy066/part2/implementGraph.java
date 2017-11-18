package ssy066.part2;

import ssy066.part1.NotImplementedException;
import ssy066.part1.Operation;
import ssy066.part1.State;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by qiuyunjie on 2017/11/18.
 */
public class implementGraph implements Graph {
    public static Set<Operation> operations;
    public static State state;

    public implementGraph(Set<Operation> operations, State state){
        this.operations = operations;
        this.state = state;
    }

    @Override
    public HashSet<State> getStates() {
        HashSet<State> set = new HashSet<State>();
        State s = state ;
        Operation op = null;
        set.add(s);
        while(operations != null){
            for(Operation o : operations) {
                System.out.println(o.name + "剩下的O");

                if(o.eval(s) == true){
                    System.out.println(o.name + "真");
                    s = o.execute(s);
                    set.add(s);
                    op = o ;
                }else{
                    System.out.println(o.name + "假");
                }
            }
            operations.remove(op);
            System.out.println("被删除的是" + op.name);
        }


       return set;
    }

    public HashSet<Transition> getTransitions(){
        throw new NotImplementedException();
    };

    /**
     *
     * @return the initial state of this graph
     */
    public State getInitalState(){
        throw new NotImplementedException();
    };

    /**
     * Given a state, returns all outgoing transitions from this state, i.e. all transition where
     * the state is a tail.
     *
     * @param s The state
     * @return All outgoing transitions
     */
    public HashSet<Transition> getOutGoingTransitions(State s){
        throw new NotImplementedException();
    };

    /**
     * Given a state, return all transitions coming into that state, i.e. all transitions where
     * the state is head
     *
     * @param s the state
     * @return a set including the incoming transitions
     */
    public HashSet<Transition> getIncomingTransitions(State s){
        throw new NotImplementedException();
    };


    /**
     * Returns all successor states that is reachable from state state using one transition. All states that are heads where
     * state state is tail
     *
     * @param s the state
     * @return all successor state
     */
    public HashSet<State> getSuccStates(State s){
        throw new NotImplementedException();
    };

    /**
     * Returns all predecessor states that can reach state state using one transition. All states that are tails where
     * state state is head
     *
     * @param s the state
     * @return all predecessor state
     */
    public HashSet<State> getPredStates(State s){
        throw new NotImplementedException();
    };

    /**
     * Returns all states that does not have any incoming transitions
     * @return A set of states
     */
    public HashSet<State> getSourceStates(){
        throw new NotImplementedException();
    };

    /**
     * Returns all states that does not have any outgoing transitions
     * @return A set of states
     */
    public HashSet<State> getSinkStates(){
        throw new NotImplementedException();
    };


    /**
     * Given a sequence of transition labels, return the state you reach when following these states. If the sequence
     * can not be followed, return null.
     *
     * @param sequence The given sequence
     * @return the reached state, or null if nothing is reached.
     */
    public State getStateFromSequence(List<String> sequence){
        throw new NotImplementedException();
    };

}
