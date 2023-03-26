#!/usr/bin/env bash

GREEN='\033[0;32m'
NORMAL='\033[0m'

print_command() {
	printf "Executing: ${GREEN}${*}${NORMAL}\n" 1>&2
}

while read -r raw_line; do
  line="${raw_line/.binary/}"
  if [[ "$line" == buildozer* ]]; then
    print_command "$line"
    eval "$line"
  else
    echo "$line"
  fi

done
