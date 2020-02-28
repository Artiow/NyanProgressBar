#!/bin/bash

versions=("LATEST-EAP-SNAPSHOT" "2019.3")

echo "Cleaning previous builds ..."
./gradlew clean

for v in ${versions[@]}; do
    echo ""
    echo "Building for IDEA $v ..."
    ./gradlew -PideaVersion="$v" build
    status=$?
    if [[ ${status} -ne 0 ]]; then
        echo "Build for IDEA $v failed! Exiting." >&2
        exit 1
    fi
done