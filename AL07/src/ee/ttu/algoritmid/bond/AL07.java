package ee.ttu.algoritmid.bond;

public class AL07 {

    public enum Network {
        FRIENDLY, UNFRIENDLY, UNKNOWN;
    }

    private DisjointSubsets disjointSubsets = new DisjointSubsets();

    public AL07() {
        // don't remove
    }

    public DisjointSubsets getDisjointSubsets() {
        return disjointSubsets;
    }

    public void talkedToEachOther(String name1, String name2) {


        disjointSubsets.union(name1, name2);


    }

    public void addPerson(String name) {
        disjointSubsets.addSubset(name);
    }

    public void friendly(String name) {
        disjointSubsets.union("A", name);
    }

    public void unfriendly(String name) {
        disjointSubsets.union("U", name);
    }

    public Network memberOfNetwork(String name) {

        String foundPerson = disjointSubsets.find(name);
        if (foundPerson.equals("A")) {
            return Network.FRIENDLY;
        } else if (foundPerson.equals("U")) {
            return Network.UNFRIENDLY;
        }
        else if (!foundPerson.equals("A")&& !foundPerson.equals("B") )
        {
            return Network.UNKNOWN;
        }
        return Network.UNKNOWN;
    }

}
