#!/usr/bin/env bash

for path in */; do
    [ -d "${path}" ] || continue # if not a directory, skip
    dirname="$(basename "${path}")"
    cat gradle_prefix.txt "$dirname/build.gradle" > tmp && mv tmp "$dirname/build.gradle"
    cat gradle_suffix.txt >> "$dirname/build.gradle"
done
