package backend.academy.hangmanGame;

public enum HangmanPicture {
    ZERO {
        @Override
        public String toString() {
            return """
                        ______
                             |
                             |
                             |
                             |
                    _________|
                   """;
        }
    },
    ONE {
        @Override
        public String toString() {
            return """
                        ______
                        O    |
                             |
                             |
                             |
                    _________|
                   """;
        }
    },
    TWO {
        @Override
        public String toString() {
            return """
                        ______
                        O    |
                        |    |
                        |    |
                             |
                    _________|
                   """;
        }
    },
    THREE {
        @Override
        public String toString() {
            return """
                        ______
                        O    |
                      --|    |
                        |    |
                             |
                    _________|
                   """;
        }
    },
    FOUR {
        @Override
        public String toString() {
            return """
                        ______
                        O    |
                      --|--  |
                        |    |
                             |
                    _________|
                   """;
        }
    },
    FIVE {
        @Override
        public String toString() {
            return """
                        ______
                        O    |
                      --|--  |
                        |    |
                       /     |
                    _________|
                   """;
        }
    },
    SIX {
        @Override
        public String toString() {
            return """
                        ______
                        O    |
                      --|--  |
                        |    |
                       / \\   |
                    _________|
                   """;
        }
    }
}

