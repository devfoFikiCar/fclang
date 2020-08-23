package com.devfoFikiCar.parser.standard;

import com.devfoFikiCar.parser.Parser;

public class ForLoop {
    public static int forLoop(int index) {
        int indexName = 0;
        int startValue = 0;
        int endValue = 0;
        int currIndex = 0;
        int signIndex = 0;
        int stepValue = 0;
        int forBegin = 0;
        int forEnd = 0;

        String name = "";

        if (Parser.tokens.get(index + 1).key == "L_PARENTHESES") {
            index++;
        } else return 0;

        if (Parser.tokens.get(index + 1).key == "NAME") {
            index++;
            indexName = index;
        } else return 0;

        if (Parser.tokens.get(index + 1).key == "SPLIT") {
            index++;
        } else return 0;

        int[] ret1 = Integers.expressionInt(++index, 0);

        if (ret1[0] != 0) {
            index = ret1[0];
            startValue = ret1[1];
        } else return 0;

        if (Parser.tokens.get(index).key != "SPLIT") return 0;

        int[] ret2 = Integers.expressionInt(++index, 0);

        if (ret2[0] != 0) {
            index = ret2[0];
            endValue = ret2[1];
        } else return 0;

        if (Parser.tokens.get(index).key != "SPLIT") return 0;

        if (Parser.tokens.get(index + 1).key == "EQUAL_TO" || Parser.tokens.get(index + 1).key == "NOT_EQUAL" || Parser.tokens.get(index + 1).key == "GREATER_EQUAL"
                || Parser.tokens.get(index + 1).key == "LESS_EQUAL" || Parser.tokens.get(index + 1).key == "LESS_THAN" || Parser.tokens.get(index + 1).key == "GREATER_THAN") {
            index++;
            currIndex = index;
        } else return 0;

        if (Parser.tokens.get(index + 1).key == "SPLIT") {
            index++;
        } else return 0;

        if (Parser.tokens.get(index + 1).key == "ADDITION" || Parser.tokens.get(index + 1).key == "SUBTRACTION" || Parser.tokens.get(index + 1).key == "MULTIPLICATION" || Parser.tokens.get(index + 1).key == "DIVISION") {
            index++;
            signIndex = index;
        } else return 0;

        if (Parser.tokens.get(index + 1).key == "SPLIT") {
            index++;
        } else return 0;

        int[] ret3 = Integers.expressionInt(++index, 0);

        if (ret3[0] != 0) {
            index = ret3[0];
            stepValue = ret3[1];
        } else return 0;

        if (Parser.tokens.get(index).key != "R_PARENTHESES") return 0;

        if (Parser.tokens.get(index + 1).key == "L_BRACES") {
            index++;
            forBegin = index;
        } else return 0;

        int rightPosition = HelperFunctions.searchRightBracket(index);

        if (rightPosition != 0) {
            index++;
            forEnd = rightPosition;
        } else return 0;

        name = Parser.tokens.get(indexName).value;
        Parser.intStore.put(name, startValue);

        switch (Parser.tokens.get(currIndex).key) {
            case "EQUAL_TO": {
                switch (Parser.tokens.get(signIndex).key) {
                    case "ADDITION": {
                        for (int i = startValue; i == endValue; i += stepValue) {
                            int tempIndex = Parser.parse(Parser.tokens, forBegin, forEnd);
                            if (tempIndex > forEnd || tempIndex < forBegin) {
                                Parser.intStore.remove(name);
                                return tempIndex;
                            }
                        }
                        Parser.intStore.remove(name);
                        break;
                    }
                    case "SUBTRACTION": {
                        for (int i = startValue; i == endValue; i -= stepValue) {
                            int tempIndex = Parser.parse(Parser.tokens, forBegin, forEnd);
                            if (tempIndex > forEnd || tempIndex < forBegin) {
                                Parser.intStore.remove(name);
                                return tempIndex;
                            }
                        }
                        Parser.intStore.remove(name);
                        break;
                    }
                    case "MULTIPLICATION": {
                        for (int i = startValue; i == endValue; i *= stepValue) {
                            Parser.intStore.put(name, i);
                            int tempIndex = Parser.parse(Parser.tokens, forBegin, forEnd);
                            if (tempIndex > forEnd || tempIndex < forBegin) {
                                Parser.intStore.remove(name);
                                return tempIndex;
                            }
                        }
                        Parser.intStore.remove(name);
                        break;
                    }
                    case "DIVISION": {
                        for (int i = startValue; i == endValue; i /= stepValue) {
                            Parser.intStore.put(name, i);
                            int tempIndex = Parser.parse(Parser.tokens, forBegin, forEnd);
                            if (tempIndex > forEnd || tempIndex < forBegin) {
                                Parser.intStore.remove(name);
                                return tempIndex;
                            }
                        }
                        Parser.intStore.remove(name);
                        break;
                    }
                }
            }
            case "NOT_EQUAL": {
                switch (Parser.tokens.get(signIndex).key) {
                    case "ADDITION": {
                        for (int i = startValue; i != endValue; i += stepValue) {
                            Parser.intStore.put(name, i);
                            int tempIndex = Parser.parse(Parser.tokens, forBegin, forEnd);
                            if (tempIndex > forEnd || tempIndex < forBegin) {
                                Parser.intStore.remove(name);
                                return tempIndex;
                            }
                        }
                        Parser.intStore.remove(name);
                        break;
                    }
                    case "SUBTRACTION": {
                        for (int i = startValue; i != endValue; i -= stepValue) {
                            Parser.intStore.put(name, i);
                            int tempIndex = Parser.parse(Parser.tokens, forBegin, forEnd);
                            if (tempIndex > forEnd || tempIndex < forBegin) {
                                Parser.intStore.remove(name);
                                return tempIndex;
                            }
                        }
                        Parser.intStore.remove(name);
                        break;
                    }
                    case "MULTIPLICATION": {
                        for (int i = startValue; i != endValue; i *= stepValue) {
                            Parser.intStore.put(name, i);
                            int tempIndex = Parser.parse(Parser.tokens, forBegin, forEnd);
                            if (tempIndex > forEnd || tempIndex < forBegin) {
                                Parser.intStore.remove(name);
                                return tempIndex;
                            }
                        }
                        Parser.intStore.remove(name);
                        break;
                    }
                    case "DIVISION": {
                        for (int i = startValue; i != endValue; i /= stepValue) {
                            Parser.intStore.put(name, i);
                            int tempIndex = Parser.parse(Parser.tokens, forBegin, forEnd);
                            if (tempIndex > forEnd || tempIndex < forBegin) {
                                Parser.intStore.remove(name);
                                return tempIndex;
                            }
                        }
                        Parser.intStore.remove(name);
                        break;
                    }
                }
            }
            case "GREATER_EQUAL": {
                switch (Parser.tokens.get(signIndex).key) {
                    case "ADDITION": {
                        for (int i = startValue; i >= endValue; i += stepValue) {
                            Parser.intStore.put(name, i);
                            int tempIndex = Parser.parse(Parser.tokens, forBegin, forEnd);
                            if (tempIndex > forEnd || tempIndex < forBegin) {
                                Parser.intStore.remove(name);
                                return tempIndex;
                            }
                        }
                        Parser.intStore.remove(name);
                        break;
                    }
                    case "SUBTRACTION": {
                        for (int i = startValue; i >= endValue; i -= stepValue) {
                            Parser.intStore.put(name, i);
                            int tempIndex = Parser.parse(Parser.tokens, forBegin, forEnd);
                            if (tempIndex > forEnd || tempIndex < forBegin) {
                                Parser.intStore.remove(name);
                                return tempIndex;
                            }
                        }
                        Parser.intStore.remove(name);
                        break;
                    }
                    case "MULTIPLICATION": {
                        for (int i = startValue; i >= endValue; i *= stepValue) {
                            Parser.intStore.put(name, i);
                            int tempIndex = Parser.parse(Parser.tokens, forBegin, forEnd);
                            if (tempIndex > forEnd || tempIndex < forBegin) {
                                Parser.intStore.remove(name);
                                return tempIndex;
                            }
                        }
                        Parser.intStore.remove(name);
                        break;
                    }
                    case "DIVISION": {
                        for (int i = startValue; i >= endValue; i /= stepValue) {
                            Parser.intStore.put(name, i);
                            int tempIndex = Parser.parse(Parser.tokens, forBegin, forEnd);
                            if (tempIndex > forEnd || tempIndex < forBegin) {
                                Parser.intStore.remove(name);
                                return tempIndex;
                            }
                        }
                        Parser.intStore.remove(name);
                        break;
                    }
                }
            }
            case "LESS_EQUAL": {
                switch (Parser.tokens.get(signIndex).key) {
                    case "ADDITION": {
                        for (int i = startValue; i <= endValue; i += stepValue) {
                            Parser.intStore.put(name, i);
                            int tempIndex = Parser.parse(Parser.tokens, forBegin, forEnd);
                            if (tempIndex > forEnd || tempIndex < forBegin) {
                                Parser.intStore.remove(name);
                                return tempIndex;
                            }
                        }
                        Parser.intStore.remove(name);
                        break;
                    }
                    case "SUBTRACTION": {
                        for (int i = startValue; i <= endValue; i -= stepValue) {
                            Parser.intStore.put(name, i);
                            int tempIndex = Parser.parse(Parser.tokens, forBegin, forEnd);
                            if (tempIndex > forEnd || tempIndex < forBegin) {
                                Parser.intStore.remove(name);
                                return tempIndex;
                            }
                        }
                        Parser.intStore.remove(name);
                        break;
                    }
                    case "MULTIPLICATION": {
                        for (int i = startValue; i <= endValue; i *= stepValue) {
                            Parser.intStore.put(name, i);
                            int tempIndex = Parser.parse(Parser.tokens, forBegin, forEnd);
                            if (tempIndex > forEnd || tempIndex < forBegin) {
                                Parser.intStore.remove(name);
                                return tempIndex;
                            }
                        }
                        Parser.intStore.remove(name);
                        break;
                    }
                    case "DIVISION": {
                        for (int i = startValue; i <= endValue; i /= stepValue) {
                            Parser.intStore.put(name, i);
                            int tempIndex = Parser.parse(Parser.tokens, forBegin, forEnd);
                            if (tempIndex > forEnd || tempIndex < forBegin) {
                                Parser.intStore.remove(name);
                                return tempIndex;
                            }
                        }
                        Parser.intStore.remove(name);
                        break;
                    }
                }
            }
            case "LESS_THAN": {
                switch (Parser.tokens.get(signIndex).key) {
                    case "ADDITION": {
                        for (int i = startValue; i < endValue; i += stepValue) {
                            Parser.intStore.put(name, i);
                            int tempIndex = Parser.parse(Parser.tokens, forBegin, forEnd);
                            if (tempIndex > forEnd || tempIndex < forBegin) {
                                Parser.intStore.remove(name);
                                return tempIndex;
                            }
                        }
                        Parser.intStore.remove(name);
                        break;
                    }
                    case "SUBTRACTION": {
                        for (int i = startValue; i < endValue; i -= stepValue) {
                            Parser.intStore.put(name, i);
                            int tempIndex = Parser.parse(Parser.tokens, forBegin, forEnd);
                            if (tempIndex > forEnd || tempIndex < forBegin) {
                                Parser.intStore.remove(name);
                                return tempIndex;
                            }
                        }
                        Parser.intStore.remove(name);
                        break;
                    }
                    case "MULTIPLICATION": {
                        for (int i = startValue; i < endValue; i *= stepValue) {
                            Parser.intStore.put(name, i);
                            int tempIndex = Parser.parse(Parser.tokens, forBegin, forEnd);
                            if (tempIndex > forEnd || tempIndex < forBegin) {
                                Parser.intStore.remove(name);
                                return tempIndex;
                            }
                        }
                        Parser.intStore.remove(name);
                        break;
                    }
                    case "DIVISION": {
                        for (int i = startValue; i < endValue; i /= stepValue) {
                            Parser.intStore.put(name, i);
                            int tempIndex = Parser.parse(Parser.tokens, forBegin, forEnd);
                            if (tempIndex > forEnd || tempIndex < forBegin) {
                                Parser.intStore.remove(name);
                                return tempIndex;
                            }
                        }
                        Parser.intStore.remove(name);
                        break;
                    }
                }
            }
            case "GREATER_THAN": {
                switch (Parser.tokens.get(signIndex).key) {
                    case "ADDITION": {
                        for (int i = startValue; i > endValue; i += stepValue) {
                            Parser.intStore.put(name, i);
                            int tempIndex = Parser.parse(Parser.tokens, forBegin, forEnd);
                            if (tempIndex > forEnd || tempIndex < forBegin) {
                                Parser.intStore.remove(name);
                                return tempIndex;
                            }
                        }
                        Parser.intStore.remove(name);
                        break;
                    }
                    case "SUBTRACTION": {
                        for (int i = startValue; i > endValue; i -= stepValue) {
                            Parser.intStore.put(name, i);
                            int tempIndex = Parser.parse(Parser.tokens, forBegin, forEnd);
                            if (tempIndex > forEnd || tempIndex < forBegin) {
                                Parser.intStore.remove(name);
                                return tempIndex;
                            }
                        }
                        Parser.intStore.remove(name);
                        break;
                    }
                    case "MULTIPLICATION": {
                        for (int i = startValue; i > endValue; i *= stepValue) {
                            Parser.intStore.put(name, i);
                            int tempIndex = Parser.parse(Parser.tokens, forBegin, forEnd);
                            if (tempIndex > forEnd || tempIndex < forBegin) {
                                Parser.intStore.remove(name);
                                return tempIndex;
                            }
                        }
                        Parser.intStore.remove(name);
                        break;
                    }
                    case "DIVISION": {
                        for (int i = startValue; i > endValue; i /= stepValue) {
                            Parser.intStore.put(name, i);
                            int tempIndex = Parser.parse(Parser.tokens, forBegin, forEnd);
                            if (tempIndex > forEnd || tempIndex < forBegin) {
                                Parser.intStore.remove(name);
                                return tempIndex;
                            }
                        }
                        Parser.intStore.remove(name);
                        break;
                    }
                }
            }
        }

        return forEnd;
    }
}
