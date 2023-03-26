load("@io_bazel_rules_scala//scala:scala.bzl", "scala_library", "scala_test")

scala_library(
    name = "tracing",
    srcs = glob(["src/**/*.scala"]),
    visibility = ["//visibility:public"],
    deps = [
        "//toolkit/config",
        "@maven//:dev_zio_zio_2_13",
        "@maven//:dev_zio_zio_opentelemetry_2_13",
        "@maven//:io_opentelemetry_opentelemetry_api",
        "@maven//:io_opentelemetry_opentelemetry_exporter_jaeger",
        "@maven//:io_opentelemetry_opentelemetry_sdk",
        "@maven//:io_opentelemetry_opentelemetry_sdk_common",
        "@maven//:io_opentelemetry_opentelemetry_sdk_trace",
        "@maven//:io_opentelemetry_opentelemetry_semconv",
    ],
)
