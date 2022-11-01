package com.endava.calculator.expert;

import com.endava.calculator.basic.Basic;

public class Expert extends Basic implements ExpertOperations{

    private String[] operators = {"+", "-", "%", "*", "/"};

    public Expert() {
        defaultDecimals = 10;
    }

    public Expert(int prefDecimals){
        this.defaultDecimals = prefDecimals;
    }

    @Override
    public double pow(int base, int exponent) {
        double result = 1;
        for (int i=1; i<=Math.abs(exponent); i++){
            result *= base;
        }
        if (exponent>=0){
            return formatNumber(result);
        } else {
            return formatNumber(1/result);
        }
    }

    @Override
    public double root(int a) {
        return formatNumber(Math.sqrt(a));
    }

    @Override
    public long fact(int n) {
        long result = 1;
//       5! = 1*2*3*4*5;
//       n! = 1*2*..*n;
        for (int i = 1; i<= n; i++){
            result *= i;
        }
        return result;
    }

    @Override
    public long factRec(int n) {
        // Conform metodei recursive n! = n * (n-1)!
        // Orice metoda recursiva are 2 reguli:
        // 1. Este o metoda care se apeleaza pe ea insasi;
        // 2. Trebuie sa avem o conditie de oprire.

        if (n == 0){
            return 1;
        } else if (n > 0) {
            return n*factRec(n-1);
        } else {
            throw new IllegalArgumentException("You cannot calculate fact for a negative number");
        }
    }

//    @Override
//    public double calculate(String s) {
//        // s = 2 + 2;
//
////        // Identificam operanzii ecuatiei
////        String[] operands = s.split("/+");
////        String leftOperand = operands[0];
////        String rightOperand = operands[1];
//
////        // Parsam operanzii (din string in double)
////        double l = Double.parseDouble(leftOperand);
////        double r = Double.parseDouble(rightOperand);
//
//        // SAU scurtam codul:
//        // Identificam operanzii ecuatiei si ii parsam din String in double
//        String[] operands = s.split("\\+");
//        double leftOperand = Double.parseDouble(operands[0]);
//        double rightOperand = Double.parseDouble(operands[1]);
//        return leftOperand + rightOperand;
//    }

    // Pentru un singur operator (in cazul asta: + )
//        @Override
//    public double calculate(String s) {
//        // s = (2) + (2 + 2);
//         if(!s.contains("+")) {
//             return Double.parseDouble(s);
//            }
//         else {
//        // Identificam operanzii ecuatiei si ii parsam din String in double
//            String[] operands = s.split("\\+", 2);
//            double leftOperand = calculate(operands[0]);
//            double rightOperand = calculate(operands[1]);
//
//            return leftOperand + rightOperand;
//        }
//    }

    // Pentru toti operatorii (update: am creat o variabila privata "operators"):
    @Override
    public double calculate(String s) {
        try {
          return Double.parseDouble(s);
        } catch (NumberFormatException e){
            if (s.contains("(")) {
                int startIndex = s.indexOf("(");
                int endIndex = s.indexOf(")");
                String left = s.substring(0, startIndex);
                String right = s.substring(endIndex+1);
                String center = s.substring(startIndex+1, endIndex);

                double result = calculate(center);
                return calculate(left + result + right);

            } else {
                // Identificam operanzii ecuatiei si ii parsam din String in double
                // trece prin fiecare operator
                for (String o : operators){
                    // luam indexul operatorului din string
                    int index = s.lastIndexOf(o);
                    // daca operators[0] nu exista, continua la operators[1]
                    if(index == -1){     // -1 = caracterul cautat nu se gaseste in string
                        continue;
                    }

                    String leftSide = s.substring(0, index); // ia stringul de la 0 pana la index (excluzand index)
                    if (index!= 0 && (leftSide.trim().charAt(leftSide.trim().length()-1) == '+' || leftSide.trim().charAt(leftSide.trim().length()-1) == '-'
                        || leftSide.trim().charAt(leftSide.trim().length()-1) == '*' || leftSide.trim().charAt(leftSide.trim().length()-1) == '/')){
                        continue;
                    }

                    double leftOperand = index==0 ? 0 : calculate(leftSide);
                    double rightOperand = calculate(s.substring(index+1)); // ia stringul care incepe dupa index.

                    switch (o){
                        case "+":
                            return add(leftOperand, rightOperand);
                        case "-":
                            return subtract(leftOperand, rightOperand);
                        case "*":
                            return multiply(leftOperand, rightOperand);
                        case "/":
                            return divide(leftOperand, rightOperand);
                        case "%":
                            return leftOperand % rightOperand;
                        default:
                            throw new IllegalArgumentException("Invalid operator used: " + o);
                    }
                }
                throw new RuntimeException("Operators field needs to have a value.");
            }
        }
    }
}
