#!/usr/bin/env bash
for path in */; do
    [ -d "${path}" ] || continue # if not a directory, skip
    [[ "$(basename "${path}")" == .* ]] && continue
    dirname="$(basename "${path}")"
    cd "$dirname" || exit
    exercise_name=${path::-1}
    file_name=${file_name//-/_}
    echo $file_name
    exercism download --track=java --exercise="${exercise_name}" --force
    chmod +x gradlew
    sleep 1
    cd .. || exit
done