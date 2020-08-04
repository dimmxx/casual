package com.mycompany;


import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class App {

    public static void main (String[] args) throws Exception {

        String line = "/Users/mint/Downloads";
        Path path = Paths.get(line);


        try(Stream<Path> pathStream = Files.walk(path)){

          String str =  pathStream
                  .filter(p -> Files.isRegularFile(p))
                  .filter(p -> p.toString().endsWith(".sql"))

                  .map(p -> {
                      try {
                          return Files.readAllLines(p);
                      } catch (IOException e) {
                          e.printStackTrace();
                          return null;
                      }
                  }).filter(Objects::nonNull)
                  .flatMap(Collection::stream)
                  .collect(Collectors.joining());



                 // .collect(Collectors.toList());

            System.out.println();



        }









        }





}








