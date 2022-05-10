package exception.exer;

public class EcmDef {
    public static void main(String[] args) {
        try{
            int num1 = Integer.parseInt(args[0]);
            int num2 = Integer.parseInt(args[1]);
            System.out.println("The result is:" + ecm(num1, num2));;
        }catch (NumberFormatException e) {
            System.out.println(e.getMessage());
        }catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        }catch (NegativeException e) {
            System.out.println(e.getMessage());
        }catch (ArithmeticException e) {
            System.out.println(e.getMessage());
        }
    }
    static double  ecm(int num1, int num2) throws ArithmeticException, NegativeException{
        if (num1 < 0 || num2 < 0) {
            throw new NegativeException("Cannot be divided by 0!");
        }
        return num1 / num2;
    }
}
