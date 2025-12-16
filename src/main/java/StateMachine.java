public class StateMachine {
    private State currentState;

    public StateMachine() {
        this.currentState = new State.S();
    }

    public String process(String text) {
        this.currentState = new State.S();

        if (text == null) return "S";

        for (char c : text.toCharArray()) {
            if (currentState instanceof State.F) {
                break;
            }
            currentState = currentState.next(c);
        }

        return currentState.getName();
    }
}