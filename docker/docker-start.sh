#!/bin/bash

cd /home/docker/actions-runner

if ./run.sh | grep -q 'Runner listener exit with terminated error'; then
    echo "Configuration missing. Running the config command."
    # Place your conditional command here, for example:
    ./config.sh --url $URL --token $TOKEN --unattended
    ./run.sh
else
    echo "Already configured."
fi




