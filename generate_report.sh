#!/usr/bin/env bash

for path in */; do
    [ -d "${path}" ] || continue # if not a directory, skip
    dirname="$(basename "${path}")"
    cd "$dirname" || exit
    gradle jacocoTestReport
    cd .. || exit
done
