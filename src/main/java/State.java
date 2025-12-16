public interface State {

    State next(char c);
    String getName();

    class S implements State {
        @Override
        public State next(char c) {
            if (c == 'T') return new One();
            return this;
        }
        @Override
        public String getName() { return "S"; }
    }

    class One implements State {
        @Override
        public State next(char c) {
            if (c == 'E') return new Two();
            if (c == 'T') return this;
            return new S();
        }
        @Override
        public String getName() { return "1"; }
    }

    class Two implements State {
        @Override
        public State next(char c) {
            if (c == 'S') return new Three();
            if (c == 'T') return new One();
            return new S();
        }
        @Override
        public String getName() { return "2"; }
    }

    class Three implements State {
        @Override
        public State next(char c) {
            if (c == 'T') return new F();
            return new S();
        }
        @Override
        public String getName() { return "3"; }
    }

    class F implements State {
        @Override
        public State next(char c) {
            return this;
        }
        @Override
        public String getName() { return "F"; }
    }
}