#!/usr/bin/env bash
# Automatically test all exercises
for path in */; do
    [ -d "${path}" ] || continue # if not a directory, skip
    dirname="$(basename "${path}")"
    cat gradle_prefix.txt "$dirname/build.gradle" > tmp && mv tmp "$dirname/build.gradle"
    cat gradle_suffix.txt >> "$dirname/build.gradle"
done
