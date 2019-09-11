package SimpleTasks;

import java.util.*;

public class DepthFirstSearch {

}
class Package{
    private String name;
    private List<Package> dependencies;
    public List<Package> getDependicies(){
        return dependencies;
    }
    public String getName(){
        return name;
    }



}

class Project{

    public static void main(String[] args){
        Package p1 = new Package();
        Package p2 = new Package();
        Package p3 = new Package();
        Package p4 = new Package();
    }

    static List<String> visitedV = new LinkedList<String>();
    private List<Package> dependencies;
    public List<Package> getDependicies(){
        return dependencies;
    }
    public boolean hasCyclicDependicies(){
        boolean result = false;
        for (Package p:getDependicies()){
            result = dfs(p.getDependicies(), p);
            if (result) return true;
        }
        return result;
    }
    //передаем список зависимостей и библиотеку для првоерки
    private boolean dfs(List<Package> pack, Package p){
        if(visitedV.contains(p.getName())) return true; // возращаемся если вершина есть в сете
        visitedV.add(p.getName()); // кладем вершину в сет
        for(Package pc : pack){
            if(visitedV.contains(pc))continue;
            dfs(pc.getDependicies(), pc);
        }
        return false;
    }

}

