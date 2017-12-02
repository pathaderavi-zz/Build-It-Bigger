package com.example.jokeprovider;

import java.util.ArrayList;
import java.util.Random;

public class Jokes {

    private ArrayList<String> allJokes;

    public String getJoke() {
        return joke;
    }
    public Jokes(){
        allJokes = new ArrayList<>();
        allJokes.add("Programmer is a person who fixed a problem that you don't know you have , in a way you don't understand");
        allJokes.add("Algorithm is a word which is used by programmers when they don't want to explain what they did.");
        allJokes.add("Hardware - The part of the computer that you can KICK");
        allJokes.add("What is Object-Oriented way to become wealthy ? - Inheritance");

        Random random = new Random();

        int jokeIndex = random.nextInt(allJokes.size());

        joke = allJokes.get(jokeIndex);

    }

    private String joke;
}
