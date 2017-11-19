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
        while(operations.size() != 0 ){
            for(Operation o : operations) {

                if(o.eval(s) == true){

                    s = o.execute(s);
                    set.add(s);
                    op = o ;
                }else{

                }
            }
            operations.remove(op);

        }
       return set;
    }
    @Override
    public HashSet<Transition> getTransitions(){
        HashSet<Transition> set = new HashSet<Transition>();
        State sTail = state ;
        State sHead = null ;
        Operation op = null;
        System.out.println(operations.size() + " o1o2 的大小");
        while(operations.size() != 0){
            for(Operation o : operations){
                if(o.eval(sTail) == true){
                    sHead = o.execute(sTail);
                    Transition t = new Transition(o.name , sTail , sHead , 1);
                    sTail = sHead ;
                    op = o ;
                    set.add(t) ;
                }else{
                    System.out.println("假" + o.name);
                }
            }
            operations.remove(op);
        }
        return set ;


        //        throw new NotImplementedException();
    };

    /**
     *
     * @return the initial state of this graph
     */
    @Override
    public State getInitalState(){
       return state ;

//        throw new NotImplementedException();
    };

    /**
     * Given a state, returns all outgoing transitions from this state, i.e. all transition where
     * the state is a tail.
     *
     * @param s The state
     * @return All outgoing transitions
     */
    @Override
    public HashSet<Transition> getOutGoingTransitions(State s){
        HashSet<Transition> set = new HashSet<Transition>();
        State sNew = s ;
        State head = null ;
        for(Operation o : operations){
            if(o.eval(sNew)){
                head = o.execute(sNew);
                Transition t = new Transition(o.name , sNew , head , 1);
                set.add(t);
            }
        }
        return set;

        //        throw new NotImplementedException();
    };

    /**
     * Given a state, return all transitions coming into that state, i.e. all transitions where
     * the state is head
     *
     * @param s the state
     * @return a set including the incoming transitions
     */
    @Override
    public HashSet<Transition> getIncomingTransitions(State s){
        HashSet<Transition> setIncomingTransitions = new HashSet<Transition>();
        HashSet<Transition> setAllTransitions = getTransitions();

        State sNew = s ;
        System.out.println(setAllTransitions.size() + "setAllTransitions的大小");
        for(Transition t : setAllTransitions){

//            注意要用equals 不是 ==
            if(t.head.equals(sNew)){
                setIncomingTransitions.add(t);
            }
        }
        System.out.println(setIncomingTransitions.size());
        if(setIncomingTransitions.size() != 0 ){
            return setIncomingTransitions;
        }else{
            System.out.println(sNew.toString() + "没有IncomingTransitions的state getIncomingTransitions方法调用");
            setIncomingTransitions.add(null);
            return setIncomingTransitions;
        }

//        throw new NotImplementedException();
    };


    /**
     * Returns all successor states that is reachable from state state using one transition. All states that are heads where
     * state state is tail
     *
     * @param s the state
     * @return all successor state
     */
    @Override
    public HashSet<State> getSuccStates(State s){
        HashSet<State> set = new HashSet<State>();

        State SuccStates = null;
        for(Operation o : operations){
            if(o.eval(s)){
                SuccStates = o.execute(s);
                set.add(SuccStates);
            }
        }
        return set ;
//        throw new NotImplementedException();
    };

    /**
     * Returns all predecessor states that can reach state state using one transition. All states that are tails where
     * state state is head
     *
     * @param s the state
     * @return all predecessor state
     */
    public HashSet<State> getPredStates(State s){
        HashSet<State> sPredStates = new HashSet<State>();
        HashSet<Transition> setIncomingTransitions = getIncomingTransitions(s);

        for (Transition t : setIncomingTransitions){
            if(t.head.equals(s)){
                sPredStates.add(t.tail);
            }
        }
        return sPredStates;
//        throw new NotImplementedException();
    };

    /**
     * Returns all states that does not have any incoming transitions
     * @return A set of states
     */
    public HashSet<State> getSourceStates(){
        HashSet<State> setState = getStates();
//        System.out.println(setState.size() + "state的大小");
        for(State s : setState){
            System.out.println(s.toString() + "所有的state");
            HashSet<Transition> set = getIncomingTransitions(s);
            if(set.contains(null)){
                System.out.println(getIncomingTransitions(s).toString() + "没有输入的Transitons");
                setState.add(s);
            }
        }
        return setState;
//        throw new NotImplementedException();
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
