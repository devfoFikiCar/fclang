package com.devfoFikiCar.parser.Math;

import com.devfoFikiCar.parser.Parser;
import com.devfoFikiCar.parser.standard.Decimals;
import com.devfoFikiCar.parser.standard.Integers;

public class TwoExpressions {
    public static int[] getTwoIntExpressions(int index){
        int[] ret = new int[3];
        if(!Parser.tokens.get(index).key.equals("L_PARENTHESES")) {
            return ret;
        }
        index++;
        int[] retV = Integers.expressionInt(index, 0);
        if(retV[0] == 0) {
            return ret;
        }
        index = retV[0];
        if(!Parser.tokens.get(index).key.equals("COMMA")) {
            return ret;
        }
        index++;
        int[] retV2 = Integers.expressionInt(index, 0);
        if(retV2[0] == 0) {
            return ret;
        }
        index = retV2[0];
        if(!Parser.tokens.get(index).key.equals("R_PARENTHESES")) {
            return ret;
        }
        ret[0] = index;
        ret[1] = retV[1];
        ret[2] = retV2[1];
        return ret;
    }

    public static double[] getTwoDecimalExpressions(int index){
        double[] ret = new double[3];
        if(!Parser.tokens.get(index).key.equals("L_PARENTHESES")) {
            return ret;
        }
        index++;
        double[] retV = Decimals.expressionDecimal(index, 0);
        if(retV[0] == 0) {
            return ret;
        }
        index = (int) retV[0];
        if(!Parser.tokens.get(index).key.equals("COMMA")) {
            return ret;
        }
        index++;
        double[] retV2 = Decimals.expressionDecimal(index, 0);
        if(retV2[0] == 0) {
            return ret;
        }
        index = (int) retV2[0];
        if(!Parser.tokens.get(index).key.equals("R_PARENTHESES")) {
            return ret;
        }
        ret[0] = index;
        ret[1] = retV[1];
        ret[2] = retV2[1];
        return ret;
    }
}
