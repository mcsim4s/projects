load("@io_bazel_rules_scala//scala:scala.bzl", "scala_library", "scala_test")

scala_library(
    name = "app",
    srcs = glob(["src/**/*.scala"]),
    resource_strip_prefix = package_name() + "/resources/",
    resources = glob(["resources/**/*"]),
    visibility = ["//visibility:public"],
    runtime_deps = [
        "@maven//:ch_qos_logback_logback_classic",
    ],
    deps = [
        "//toolkit/tracing",
        "@maven//:dev_zio_zio_2_13",
        "@maven//:dev_zio_zio_logging_2_13",
        "@maven//:dev_zio_zio_logging_slf4j_2_13",
        "@maven//:dev_zio_zio_opentelemetry_2_13",
    ],
)
