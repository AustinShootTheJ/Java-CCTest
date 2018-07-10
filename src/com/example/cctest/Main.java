package com.example.cctest;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Main {
    private static Map<String,State> stateLaws = new HashMap<>();
    private static Set<State> states = new HashSet<>();

    public static void main(String[] args) {
        // set laws
        Law capacityLaw = new Law("Capacity law","You may only have 10 rounds");
        Law scaryLaw = new Law("Scary Law", "You may not have guns that look scary.");
        Law justKidding = new Law("Just Kidding","You can do what you want.");

        State tempState = new State("Virginia");
        tempState.addLaw(capacityLaw);
        tempState.addLaw(scaryLaw);
        stateLaws.put(tempState.getName(),tempState);
        states.add(tempState);

        tempState = new State("Alabama");
        tempState.addLaw(capacityLaw);
        tempState.addLaw(justKidding);
        stateLaws.put(tempState.getName(),tempState);
        states.add(tempState);

        listLaws();

        testIntersection(stateLaws.get("Virginia").getLaws(),stateLaws.get("Alabama").getLaws());
        testRemoval(stateLaws.get("Virginia").getLaws(),stateLaws.get("Alabama").getLaws());
        testAddition(stateLaws.get("Virginia").getLaws(),stateLaws.get("Alabama").getLaws());
        
    }

    private static void listLaws(){
        for(State state: states){
            System.out.println(state.getName());
            for(Law law: state.getLaws()){
                System.out.println(law.toString());
            }
            System.out.println("\n");
            System.out.println("========================");
        }
    }

    private static void testIntersection(Set<Law> s1, Set<Law> s2){
        Set<Law> intersection = new HashSet<>(s1);
        intersection.retainAll(s2);
        System.out.println("Intersection contains " + intersection.size() + " elements.");
        for(Law law : intersection){
            System.out.println(law.toString() + " is present in both states.");
        }

    }

    private static void testRemoval(Set<Law> s1, Set<Law> s2){
        Set<Law> result = new HashSet<>(s1);
        result.removeAll(s2);
        System.out.println("There are  " + result.size() + " elements.");
        for(Law law : result){
            System.out.println(law.toString() + " is present in the first but not the second");
        }

    }

    private static void testAddition(Set<Law> s1, Set<Law> s2){
        Set<Law> result = new HashSet<>(s1);
        result.addAll(s2);
        System.out.println("There are  " + result.size() + " elements.");
        for(Law law : result){
            System.out.println(law.toString());
        }

    }



}
