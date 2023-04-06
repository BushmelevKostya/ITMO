public class A {
    public A(){}
//    public static String method(){
//        try{
//            return "SomeMethod";
//        }
//        catch (Exception e){
//            return "Exception";
//        }
//        finally {
//            return "Finally";
//        }
//    }
    @Override
    public int hashCode(){return super.hashCode();}
    @Override
    public String toString(){return "Myclass{}";}
    @Override
    public Object clone(){return null;}

    void doit(){
        System.out.println("feef");
    }
    class C {
        void RandomName(){
            A.this.doit();
        }
    }
}
