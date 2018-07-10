package com.example.cctest;


import java.util.HashSet;
import java.util.Set;

public class State {
    private final String name;
    private Set<Law> laws;

    public State(String name) {
        this.name = name;
        this.laws = new HashSet<>();
    }

    public String getName(){return name;}

    public boolean addLaw(Law law){return this.laws.add(law);}

    public Set<Law> getLaws() {
        return laws;
    }



    @Override
    public boolean equals(Object obj){
        if(this == obj){
            return true;
        }
        System.out.println("obj.getClass() is " + obj.getClass());
        System.out.println("this.getClass() is " + this.getClass());
        if((obj == null) || (obj.getClass() != this.getClass())){
            return false;
        }
        String objName = ((State) obj).getName();
        return this.name.equals(objName);
    }

    @Override
    public int hashCode(){
        System.out.println("hashcode called");
        return this.name.hashCode() + 57;
    }


}
