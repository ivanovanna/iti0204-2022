package ee.ttu.algoritmid.horseracing;

public interface RacingParticipant {
    public enum Kind {

        HORSE,
        JOCKEY

    }

    public String getName();

    public Kind getKind();

    public double getHeight();

}
