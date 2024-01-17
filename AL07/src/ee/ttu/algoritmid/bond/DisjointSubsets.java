package ee.ttu.algoritmid.bond;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.List;
import java.util.HashSet;
import java.util.ArrayList;

public class DisjointSubsets {
    public Map<String, String> persons = new HashMap<>();
    public Map < String, Integer> order = new HashMap<>();
    public List<Map<Integer, Set<String>>> networks = new ArrayList<Map<Integer, Set<String>>>();

    public String find(String element) throws IllegalArgumentException {
        // should throw IllegalArgumentException if the element is not present

        if (element==null || persons.get(element)== null)
        {
            throw  new IllegalArgumentException();
        }
        if(persons.get(element).equals(element)){
            return element;
        }

        return find(persons.get(element));

    }

    // should throw IllegalArgumentException if any of elements is not present
    public void union(String element1, String element2) throws IllegalArgumentException {
        // should throw IllegalArgumentException if any of elements is not present

        if (element1==null|| element2==null || persons.get(element1)==null||persons.get(element2)==null){
            throw new IllegalArgumentException();
        }

        String x = find(element1);
        String y = find(element2);

        if(x.equals(y)){
            return;
        }else if (order.get(x)<order.get(y)){
            persons.put(x,y);
        }else if(order.get(y)<order.get(x)){
            persons.put(y,x);
        }else{
            persons.put(y,x);
            order.put(x,order.get(x)+1);
        }


    }

    public void addSubset(String element) throws IllegalArgumentException {
        // should throw IllegalArgumentException if the element is already present

        if(element==null||persons.containsKey(element)){
            throw new IllegalArgumentException();
        }
        if(!persons.containsKey(element)){
            persons.put(element,element);
            order.put(element,0);

        }
        int key = networks.size()+1;
        Map<Integer, Set<String>> persons = new HashMap<Integer, Set<String>>();
        Set<String> set = new HashSet<String>();

        persons.put(key, set);

        networks.add(persons);


    }
}
