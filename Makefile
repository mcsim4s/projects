SHELL := /bin/bash

.PHONY: pin/maven fix

pin/maven:
	REPIN=1 bazel run @unpinned_maven//:pin

# Run buildozer commands from last run
fix:
	cat bazel-out/../../../command.log | grep '^buildozer' | ./bazel/run-buildozer.sh