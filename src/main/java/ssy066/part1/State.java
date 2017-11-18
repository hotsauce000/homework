package ssy066.part1;

import java.security.Key;
import java.util.*;
import java.util.Map.Entry;

/**
 * The State represent a map between the variables and their current value.
 * Variables are represented as Strings and the values can be of any type. Usually
 * the values is of type String, Integer or Boolean.
 *
 * The variables are simplified since they do not have any
 * domain, which mean that they can be updated to anything.
 *
 * A State object should be immutable, i.e. when created it should never change.
 *
 */
public class State {
    private final Map<String, Object> state;

    /**
     * The constructor takes a map defining the values of the variables. The
     * variables are defined as a String and the values can be of any type (mostly
     * String, Integer or Boolean).
     *
     * @param init Each variable
     */
    public State(Map<String, Object> init) {
//        为什么这样hashmap就是不可变的了
        HashMap tempMap=new HashMap();
        Object key;
        Iterator it = init.keySet().iterator();
        while(it.hasNext()){
            key=it.next();
            tempMap.put(key, init.get(key));
        }
        this.state=tempMap;
    }


    /**
     * If the state include the variable var, the method should return its value.
     * If the variable is not part of the state, a java.util.NoSuchElementException
     * should be fired. The method inState can be useful.
     *
     * @param var The variable name
     * @return the value of the variable named var
     */
    public Object get(String var) {
//	    从map里面取
        Object getVar = state.get(var);
        if(getVar != null){

            return getVar;
        }else{

            throw new java.util.NoSuchElementException();
        }

//        throw new NotImplementedException();
    }
    /**
     * Returns a new State where value of variable var is updated to value. If var is
     * not part of the state, a NoSuchElementException should be fired
     * @param var the name of the variable
     * @param value the newState value
     * @return a new State
     */
    public State newState(String var, Object value) {
//        throw new NotImplementedException();
        HashMap tempMap=new HashMap();
        Object key;
        if(state.containsKey(var)){
            Iterator it = state.keySet().iterator();
            while(it.hasNext()){
                key=it.next();
                tempMap.put(key, state.get(key));
            }
            tempMap.put(var , value);
            State state = new State(tempMap);
            return state;
        }else{
            throw new java.util.NoSuchElementException();
        }

    }

    /**
     * Returns a new State where values of variables in updVars is updated. If any of the
     * variables is not part of the state, a NoSuchElementException should be fired
     * @param updVars The map including only the variable and values to be updated
     * @return a new State
     */
    public State newState(Map<String, Object> updVars) {
//       throw new NotImplementedException();

        String key1 ;
        Iterator it1 = updVars.keySet().iterator();
        while (it1.hasNext()){
            key1 = (String)it1.next();
            if (!state.containsKey(key1)){
                throw new java.util.NoSuchElementException();
            }
        }
        String key;
        Iterator it = state.keySet().iterator();
        while(it.hasNext()){
            key = (String)it.next();
            if(!updVars.containsKey(key)){
                updVars.put( key , state.get(key));
            }
        }
        State state = new State(updVars);
        return state ;
    }




    /**
     * Use this helper method to check if a variable is included in the state
     * If not, The method will throw an exception that should be propagated
     * to the user of the State object
     * @param var The variable name to check
     */
    private void inState(String var) {
        if (!state.containsKey(var))
            throw new java.util.NoSuchElementException("The variable "+var+" is not part of the state");
    }
    @Override
    public String toString() {
        StringBuffer name = new StringBuffer();
        for (Entry<String, Object> kv : state.entrySet()){
            String line = kv.getKey() +":"+ kv.getValue().toString();
            name.append(line + ", ");
        }
        return name.toString();
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((state == null) ? 0 : state.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (!(obj instanceof State))
            return false;
        State other = (State) obj;
        if (state == null) {
            return false;
        } else if (!state.equals(other.state))
            return false;
        return true;
    }

}