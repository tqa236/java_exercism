#!/usr/bin/env bash
find . -iname "*.java" | grep -v "test" | xargs java -jar ~/exercism/java/linter/checkstyle-8.17-all.jar -c ~/exercism/java/linter/google_checks.xml
