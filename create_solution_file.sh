#!/usr/bin/env bash
# Automatically test all exercises
for path in */; do
    [ -d "${path}" ] || continue # if not a directory, skip
    dirname="$(basename "${path}")"
    cd "$dirname/src/test/java" || exit
    file_name=$(ls)
    file_name="${file_name/%Test.java/.java}"
    cd "../../main/java" || exit
    touch "$file_name"
    cd ../../../.. || exit
done
