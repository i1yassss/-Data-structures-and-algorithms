package SimpleTasks;/*public class SimpleTasks.Singleton {
    private  SimpleTasks.Singleton(){}
    static SimpleTasks.Singleton instance = new SimpleTasks.Singleton();
    public static SimpleTasks.Singleton getInstance(){
        return instance;
    }
}*/

// second version
public class Singleton{
    private static class InstanceHolder{
        public static Singleton instance = new Singleton();
    }
    private Singleton(){}
    public static Singleton getInstance(){
        return InstanceHolder.instance;
    }
}
