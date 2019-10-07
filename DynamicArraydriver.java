public class DynamicArrayDriver
{
    public static void main(String[]args){
        DynamicArray <Integer> myArroy = new DynamicArray<>();
        myArroy.append(1);
        myArroy.append(2);

        System.out.println(myArroy.size());
        System.out.println(myArroy.toString());
    }
    }
