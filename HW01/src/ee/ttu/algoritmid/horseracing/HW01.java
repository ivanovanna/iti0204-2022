package ee.ttu.algoritmid.horseracing;
import java.util.*;

import static ee.ttu.algoritmid.horseracing.RacingParticipant.Kind.HORSE;
import static ee.ttu.algoritmid.horseracing.RacingParticipant.Kind.JOCKEY;


public class HW01 implements RacingRegistrationSystem {
    private final BinarySearchTree jockeys = new BinarySearchTree();
    private final BinarySearchTree horses = new BinarySearchTree();

    @Override
    public RacingDuo registerToRacing(RacingParticipant participant) throws IllegalArgumentException {
        if (participant == null
                || participant.getName() == null
                || participant.getKind() == null
                || participant.getName().equals("")
                || participant.getHeight() <= 0) {
            throw new IllegalArgumentException();
        }

        RacingDuo duo = null;
        if (participant.getKind() == JOCKEY) {
            duo = searchHorseForJockey(participant);
            if (duo == null) {
                jockeys.insert(new Node(participant));
            }
        } else if (participant.getKind() == HORSE) {
            duo = searchJokeyForHorse(participant);
            if (duo == null) {
                horses.insert(new Node(participant));
            }
        }
        return duo;
    }

    private RacingDuo searchHorseForJockey(RacingParticipant jockey) {
        RacingDuo duo = null;
        Node horse = horses.findSmaller(15, jockey.getHeight());
        if (horse != null && jockey.getHeight() - horse.getParticip().getHeight() >= 5 && jockey.getHeight() - horse.getParticip().getHeight() <= 15) {
            System.out.println("HorseForJockey");


            duo = new RacingDuo() {
                @Override
                public RacingParticipant getJockey() {
                    return jockey;
                }

                @Override
                public RacingParticipant getHorse() {
                    return horse.getParticip();
                }
            };
            horses.delete(horse);
        }
        return duo;
    }

    private RacingDuo searchJokeyForHorse(RacingParticipant horse) {
        RacingDuo duo = null;
        Node jockey = jockeys.findBigger(5, horse.getHeight());
        if (jockey != null && jockey.getParticip().getHeight() - horse.getHeight() <= 15 && horse.getHeight() - jockey.getParticip().getHeight() <= 5) {
            System.out.println("JokeyForHorse");

            duo = new RacingDuo() {
                @Override
                public RacingParticipant getJockey() {
                    return jockey.getParticip();
                }

                @Override
                public RacingParticipant getHorse() {
                    return horse;
                }
            };
            jockeys.delete(jockey);
        }

        return duo;

    }

    @Override
    public List<RacingParticipant> participantsWithoutDuo() {
        LinkedList<RacingParticipant> result_jockey = new LinkedList<>();
        LinkedList<RacingParticipant> result_horse = new LinkedList<>();
//
        jockeys.inOrderTraverse(jockeys.getRoot(), result_jockey);
        horses.inOrderTraverse(horses.getRoot(), result_horse);
        LinkedList<RacingParticipant> result = new LinkedList<>();
//        jockeys.inOrderTraverse(jockeys.getRoot(), result);
//          horses.inOrderTraverse(horses.getRoot(), result);

        while (!result_jockey.isEmpty()&&!result_horse.isEmpty())
        {
            RacingParticipant p1 = result_jockey.getFirst();
            RacingParticipant p2 = result_horse.getFirst();

            if (p1.getHeight() <= p2.getHeight()){
                result.add(p1);
                result_jockey.removeFirst();
            }
            else{
                result.add(p2);
                result_horse.removeFirst();
            }
        }
        while (!result_jockey.isEmpty())
        {
            result.add(result_jockey.getFirst());
            result_jockey.removeFirst();
        }
        while (!result_horse.isEmpty())
        {
            result.add(result_horse.getFirst());
            result_horse.removeFirst();
        }
//        return compareTwoLists(result_jockey,result_jockey);
        return result;

    }
//    public LinkedList<RacingParticipant> compareTwoLists(LinkedList<RacingParticipant> list1, LinkedList<RacingParticipant> list2){
//        LinkedList<RacingParticipant> merge = new LinkedList<RacingParticipant>();
//        for(int i = 0; i <+; i++) {
//
//                if (list1.get(i).getHeight() <= list2.get(i).getHeight()) {
//                    merge.add(list1.get(i));
//                } else {
//                    merge.add(list2.get(i));
//                }
//            }
//
//        return merge;
//    }
  }









/* This code is contributed by Rajat Mishra */

//class AComparator implements Comparator<RacingParticipant> {
//    @Override
//    public int compare(RacingParticipant c1, RacingParticipant c2) {
//        return Double.compare(c1.getHeight(), c2.getHeight());
//    }
//}














