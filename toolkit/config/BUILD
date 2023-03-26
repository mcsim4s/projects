load("@io_bazel_rules_scala//scala:scala.bzl", "scala_library", "scala_test")

scala_library(
    name = "config",
    srcs = glob(["src/**/*.scala"]),
    visibility = ["//visibility:public"],
    exports = [
        "@maven//:com_github_pureconfig_pureconfig_core_2_13",
        "@maven//:com_github_pureconfig_pureconfig_generic_2_13",
        "@maven//:com_github_pureconfig_pureconfig_macros_2_13",
    ],
    deps = [
        "@maven//:com_chuusai_shapeless_2_13",
        "@maven//:com_github_pureconfig_pureconfig_core_2_13",
        "@maven//:com_github_pureconfig_pureconfig_generic_2_13",
        "@maven//:com_github_pureconfig_pureconfig_generic_base_2_13",
        "@maven//:com_github_pureconfig_pureconfig_macros_2_13",
        "@maven//:com_typesafe_config",
        "@maven//:dev_zio_izumi_reflect_2_13",
        "@maven//:dev_zio_zio_2_13",
    ],
)
