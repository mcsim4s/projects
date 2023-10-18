load("@io_bazel_rules_scala//scala:scala_toolchain.bzl", "scala_toolchain")

scala_toolchain(
    name = "cutom_scala_toolchain",
    dependency_mode = "transitive",
    dependency_tracking_method = "high-level",
    enable_stats_file = False,
    scalac_jvm_flags = ["-Djava.security.manager=allow"],
    scalacopts = [
        "-release",
        "21",
        "-deprecation",
        "-explaintypes",
        "-feature",
        "-language:higherKinds",
        "-language:implicitConversions",
        "-unchecked",
        "-Ywarn-extra-implicit",  # Warn when more than one implicit parameter section is defined.
        "-Ywarn-unused:locals",  # Warn if a local definition is unused.
        "-Ywarn-value-discard",  # Warn when non-Unit expression results are unused.
        "-Ymacro-annotations",
    ],
    strict_deps_mode = "off",
    unused_dependency_checker_mode = "error",
    visibility = ["//visibility:public"],
)

toolchain(
    name = "custom_toolchain",
    toolchain = ":cutom_scala_toolchain",
    toolchain_type = "@io_bazel_rules_scala//scala:toolchain_type",
    visibility = ["//visibility:public"],
)
