package wwtbam;

public abstract class Lifeline {

    private String lifeline;

    public Lifeline(String lifeline) {
        this.lifeline = lifeline;
    }

    /**
     * Three Lifelines
     * 1. 50/50
     * 2. Ask the Audience
     * 3. Call a Friend
     * 
     * @param q 
     */
    public abstract void generateLifeline(Questions q);

    public String getLifeline() {
        return lifeline;
    }

    public void setLifeline(String lifeline) {
        this.lifeline = lifeline;
    }

    @Override
    public String toString() {
        return "You used " + this.getLifeline() + ".";
    }
}