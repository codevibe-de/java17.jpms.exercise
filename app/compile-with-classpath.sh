#!/bin/zsh

javac --class-path ../book-core/target/book-core-1.0.0.jar:../book-report/target/book-report-1.0.0.jar \
      -d my-build/classes \
      $(find src/main/java -name "*.java")


