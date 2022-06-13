package Lambdas;

public class TypeInference {
    public static void main (String[] args) {
        StringLengthLambda lambda_0 = (String s) -> s.length();
        System.out.println(lambda_0.getStringLength("Lambda"));

        StringLengthLambda lambda_1 = (s) -> s.length();
        System.out.println(lambda_1.getStringLength("Expression"));

        StringLengthLambda lambda = s -> s.length();
        System.out.println(lambda.getStringLength("Inference"));

        printLambda(s -> s.length());
    }


    public static void printLambda(StringLengthLambda sLL) {
        System.out.println(sLL.getStringLength("LambdaExpressionInference"));
    }

    @FunctionalInterface
    interface StringLengthLambda {
        int getStringLength(String s);
    }



}
