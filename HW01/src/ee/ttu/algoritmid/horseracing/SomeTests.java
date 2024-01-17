package ee.ttu.algoritmid.horseracing;

import java.util.ArrayList;
import java.util.List;


public class SomeTests {

    public static void main(String[] args) {
        testHorseTreeEndToEndPublic("case 9B");
        testJockeyTreeEndToEndPublic("case 9D");
    }

    private static void testHorseTreeEndToEndPublic(String caseId) {
        List<RacingParticipant> requests = new ArrayList<>();
        List<Double> responds = new ArrayList<>();

        requests.add(new ParticipantTemp("M", RacingParticipant.Kind.HORSE, 150));
        responds.add(null);

        requests.add(new ParticipantTemp("M", RacingParticipant.Kind.HORSE, 130));
        responds.add(null);

        requests.add(new ParticipantTemp("M", RacingParticipant.Kind.HORSE, 135));
        responds.add(null);

        requests.add(new ParticipantTemp("M", RacingParticipant.Kind.HORSE, 149));
        responds.add(null);

        requests.add(new ParticipantTemp("M", RacingParticipant.Kind.HORSE, 200));
        responds.add(null);

        requests.add(new ParticipantTemp("M", RacingParticipant.Kind.HORSE, 170));
        responds.add(null);

        requests.add(new ParticipantTemp("M", RacingParticipant.Kind.HORSE, 160));
        responds.add(null);

        requests.add(new ParticipantTemp("M", RacingParticipant.Kind.HORSE, 133));
        responds.add(null);

        requests.add(new ParticipantTemp("M", RacingParticipant.Kind.HORSE, 125));
        responds.add(null);

        requests.add(new ParticipantTemp("M", RacingParticipant.Kind.HORSE, 190));
        responds.add(null);

        requests.add(new ParticipantTemp("M", RacingParticipant.Kind.HORSE, 140));
        responds.add(null);

        requests.add(new ParticipantTemp("M", RacingParticipant.Kind.HORSE, 195));
        responds.add(null);

        requests.add(new ParticipantTemp("M", RacingParticipant.Kind.HORSE, 148));
        responds.add(null);

        requests.add(new ParticipantTemp("M", RacingParticipant.Kind.HORSE, 210));
        responds.add(null);

        requests.add(new ParticipantTemp("M", RacingParticipant.Kind.HORSE, 138));
        responds.add(null);

        requests.add(new ParticipantTemp("M", RacingParticipant.Kind.HORSE, 205));
        responds.add(null);

        requests.add(new ParticipantTemp("M", RacingParticipant.Kind.HORSE, 165));
        responds.add(null);

        requests.add(new ParticipantTemp("M", RacingParticipant.Kind.HORSE, 163));
        responds.add(null);

        requests.add(new ParticipantTemp("M", RacingParticipant.Kind.HORSE, 168));
        responds.add(null);


        requests.add(new ParticipantTemp("F", RacingParticipant.Kind.JOCKEY, 158));
        responds.add(148.0);

        requests.add(new ParticipantTemp("F", RacingParticipant.Kind.JOCKEY, 143.02));
        responds.add(133.0);

        requests.add(new ParticipantTemp("F", RacingParticipant.Kind.JOCKEY, 169.9));
        responds.add(160.0);

        requests.add(new ParticipantTemp("F", RacingParticipant.Kind.JOCKEY, 150));
        responds.add(140.0);

        requests.add(new ParticipantTemp("F", RacingParticipant.Kind.JOCKEY, 161));
        responds.add(150.0);


        requests.add(new ParticipantTemp("M", RacingParticipant.Kind.HORSE, 169));
        responds.add(null);

        requests.add(new ParticipantTemp("M", RacingParticipant.Kind.HORSE, 139));
        responds.add(null);

        requests.add(new ParticipantTemp("M", RacingParticipant.Kind.HORSE, 180));
        responds.add(null);

        requests.add(new ParticipantTemp("M", RacingParticipant.Kind.HORSE, 134));
        responds.add(null);


        requests.add(new ParticipantTemp("F", RacingParticipant.Kind.JOCKEY, 174));
        responds.add(163.0);

        requests.add(new ParticipantTemp("F", RacingParticipant.Kind.JOCKEY, 143));
        responds.add(134.0);

        requests.add(new ParticipantTemp("F", RacingParticipant.Kind.JOCKEY, 141));
        responds.add(130.0);

        requests.add(new ParticipantTemp("F", RacingParticipant.Kind.JOCKEY, 186));
        responds.add(180.0);


        testTreeEndToEnd(caseId, requests, responds);
    }

    private static void testJockeyTreeEndToEndPublic(String caseId) {
        List<RacingParticipant> requests = new ArrayList<>();
        List<Double> responds = new ArrayList<>();

        requests.add(new ParticipantTemp("F", RacingParticipant.Kind.JOCKEY, 110));
        responds.add(null);

        requests.add(new ParticipantTemp("F", RacingParticipant.Kind.JOCKEY, 90));
        responds.add(null);

        requests.add(new ParticipantTemp("F", RacingParticipant.Kind.JOCKEY, 95));
        responds.add(null);

        requests.add(new ParticipantTemp("F", RacingParticipant.Kind.JOCKEY, 109));
        responds.add(null);

        requests.add(new ParticipantTemp("F", RacingParticipant.Kind.JOCKEY, 160));
        responds.add(null);

        requests.add(new ParticipantTemp("F", RacingParticipant.Kind.JOCKEY, 130));
        responds.add(null);

        requests.add(new ParticipantTemp("F", RacingParticipant.Kind.JOCKEY, 120));
        responds.add(null);

        requests.add(new ParticipantTemp("F", RacingParticipant.Kind.JOCKEY, 93));
        responds.add(null);

        requests.add(new ParticipantTemp("F", RacingParticipant.Kind.JOCKEY, 85));
        responds.add(null);

        requests.add(new ParticipantTemp("F", RacingParticipant.Kind.JOCKEY, 150));
        responds.add(null);

        requests.add(new ParticipantTemp("F", RacingParticipant.Kind.JOCKEY, 100));
        responds.add(null);

        requests.add(new ParticipantTemp("F", RacingParticipant.Kind.JOCKEY, 155));
        responds.add(null);

        requests.add(new ParticipantTemp("F", RacingParticipant.Kind.JOCKEY, 108));
        responds.add(null);

        requests.add(new ParticipantTemp("F", RacingParticipant.Kind.JOCKEY, 170));
        responds.add(null);

        requests.add(new ParticipantTemp("F", RacingParticipant.Kind.JOCKEY, 98));
        responds.add(null);

        requests.add(new ParticipantTemp("F", RacingParticipant.Kind.JOCKEY, 165));
        responds.add(null);

        requests.add(new ParticipantTemp("F", RacingParticipant.Kind.JOCKEY, 125));
        responds.add(null);

        requests.add(new ParticipantTemp("F", RacingParticipant.Kind.JOCKEY, 123));
        responds.add(null);

        requests.add(new ParticipantTemp("F", RacingParticipant.Kind.JOCKEY, 128));
        responds.add(null);


        requests.add(new ParticipantTemp("M", RacingParticipant.Kind.HORSE, 104));
        responds.add(110.0);

        requests.add(new ParticipantTemp("M", RacingParticipant.Kind.HORSE, 98.01));
        responds.add(108.0);

        requests.add(new ParticipantTemp("M", RacingParticipant.Kind.HORSE, 121));
        responds.add(130.0);

        requests.add(new ParticipantTemp("M", RacingParticipant.Kind.HORSE, 100.000986));
        responds.add(109.0);

        requests.add(new ParticipantTemp("M", RacingParticipant.Kind.HORSE, 117.98));
        responds.add(128.0);


        requests.add(new ParticipantTemp("F", RacingParticipant.Kind.JOCKEY, 129));
        responds.add(null);

        requests.add(new ParticipantTemp("F", RacingParticipant.Kind.JOCKEY, 99));
        responds.add(null);

        requests.add(new ParticipantTemp("F", RacingParticipant.Kind.JOCKEY, 140));
        responds.add(null);

        requests.add(new ParticipantTemp("F", RacingParticipant.Kind.JOCKEY, 94));
        responds.add(null);


        requests.add(new ParticipantTemp("M", RacingParticipant.Kind.HORSE, 120));
        responds.add(129.0);

        requests.add(new ParticipantTemp("M", RacingParticipant.Kind.HORSE, 89.96));
        responds.add(100.0);

        requests.add(new ParticipantTemp("M", RacingParticipant.Kind.HORSE, 88.7));
        responds.add(99.0);

        requests.add(new ParticipantTemp("M", RacingParticipant.Kind.HORSE, 137));
        responds.add(150.0);


        testTreeEndToEnd(caseId, requests, responds);
    }



    private static void testTreeEndToEnd(String caseId, List<RacingParticipant> requests, List<Double> responds) {
        HW01 solution = new HW01();

        for (int i = 0; i < requests.size(); i++) {
            testRequestResponse(caseId, solution, requests.get(i), responds.get(i));
        }
    }


    private static void testRequestResponse(String caseId, HW01 solution, RacingParticipant participant, Double expectedDuoPartnerHeight) {

        RacingDuo duo = solution.registerToRacing(participant);

        if (duo == null) {
            if (expectedDuoPartnerHeight != null) {
                System.out.println("Expected:");
                System.out.println(expectedDuoPartnerHeight);
                fail("Duo partner wasn't found, but should have: " + caseId);
            }
        } else {
            if (expectedDuoPartnerHeight == null) {
                fail("Duo partner was found, but shouldn't have: " + caseId);
            } else {
                RacingParticipant duoPartner = participant.getKind() == RacingParticipant.Kind.HORSE ? duo.getJockey() : duo.getHorse();
                System.out.println("Expected:");
                System.out.println(expectedDuoPartnerHeight);
                if (duoPartner.getHeight() != expectedDuoPartnerHeight) {
                    fail("Duo partner of wrong height found: " + caseId);
                }
            }
        }
    }


    private static void fail(String text) {
        System.err.println("ERROR: " + text);
        throw new RuntimeException(text);
    }

    private static class ParticipantTemp implements RacingParticipant {

        private final String name;
        private final Kind kind;
        private final double height;

        public ParticipantTemp(String name, Kind kind, double height) {
            this.name = name;
            this.kind = kind;
            this.height = height;
        }

        @Override
        public String getName() {
            return name;
        }

        @Override
        public Kind getKind() {
            return kind;
        }

        @Override
        public double getHeight() {
            return height;
        }

    }

}
