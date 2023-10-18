workspace(name = "projects")

load("@bazel_tools//tools/build_defs/repo:http.bzl", "http_archive")

# ================================ SKYLIB ==============================================

skylib_version = "1.0.3"

http_archive(
    name = "bazel_skylib",
    sha256 = "1c531376ac7e5a180e0237938a2536de0c54d93f5c278634818e0efc952dd56c",
    type = "tar.gz",
    url = "https://mirror.bazel.build/github.com/bazelbuild/bazel-skylib/releases/download/{}/bazel-skylib-{}.tar.gz".format(skylib_version, skylib_version),
)

# ================================ JAVA ================================================

RULES_JVM_EXTERNAL_TAG = "4.3"

RULES_JVM_EXTERNAL_SHA = "6274687f6fc5783b589f56a2f1ed60de3ce1f99bc4e8f9edef3de43bdf7c6e74"

http_archive(
    name = "rules_jvm_external",
    sha256 = RULES_JVM_EXTERNAL_SHA,
    strip_prefix = "rules_jvm_external-%s" % RULES_JVM_EXTERNAL_TAG,
    url = "https://github.com/bazelbuild/rules_jvm_external/archive/%s.zip" % RULES_JVM_EXTERNAL_TAG,
)

load("@rules_jvm_external//:repositories.bzl", "rules_jvm_external_deps")

rules_jvm_external_deps()

load("@rules_jvm_external//:setup.bzl", "rules_jvm_external_setup")

rules_jvm_external_setup()

load("@bazel_tools//tools/jdk:remote_java_repository.bzl", "remote_java_repository")

remote_java_repository(
    name = "corretto_jdk_21",
    prefix = "corretto",
    sha256 = "b4161b887ebbf68d6400608d2fccedb599bf18fd79e3e9c9dbfc0e27e1ed4ce1",
    strip_prefix = "amazon-corretto-21.jdk/Contents/Home",
    target_compatible_with = [
        "@platforms//cpu:arm64",
        "@platforms//os:macos",
    ],
    url = "https://corretto.aws/downloads/latest/amazon-corretto-21-aarch64-macos-jdk.tar.gz",
    version = "21",
)

register_toolchains("//bazel/java:corretto_21_toolchain_definition")

load("@rules_jvm_external//:defs.bzl", "maven_install")

# ================================ SCALA ===============================================

rules_scala_version = "6.2.1"

http_archive(
    name = "io_bazel_rules_scala",
    sha256 = "71324bef9bc5a885097e2960d5b8effed63399b55572219919d25f43f468c716",
    strip_prefix = "rules_scala-%s" % rules_scala_version,
    url = "https://github.com/bazelbuild/rules_scala/releases/download/v%s/rules_scala-v%s.tar.gz" % (rules_scala_version, rules_scala_version),
)

load("@io_bazel_rules_scala//:scala_config.bzl", "scala_config")

scala_config(scala_version = "2.13.12")

load("@io_bazel_rules_scala//scala:scala.bzl", "rules_scala_setup", "rules_scala_toolchain_deps_repositories")

rules_scala_setup()

rules_scala_toolchain_deps_repositories(fetch_sources = True)

register_toolchains("//bazel/scala:custom_toolchain")

# ======================================================================================

# ================================ PROTO ===============================================

load("@rules_proto//proto:repositories.bzl", "rules_proto_dependencies", "rules_proto_toolchains")

rules_proto_dependencies()

rules_proto_toolchains()

# ======================================================================================

maven_install(
    name = "maven",
    artifacts = [
        "com.chuusai:shapeless_2.13:2.3.10",
        # pureconfig
        "com.github.pureconfig:pureconfig-core_2.13:0.17.2",
        "com.github.pureconfig:pureconfig-generic-base_2.13:0.17.2",
        "com.github.pureconfig:pureconfig-generic_2.13:0.17.2",
        "com.github.pureconfig:pureconfig-macros_2.13:0.14.1",
        "com.github.pureconfig:pureconfig-magnolia_2.13:0.14.1",
        "com.github.pureconfig:pureconfig-sttp_2.13:0.17.2",
        "com.github.pureconfig:pureconfig-enumeratum_2.13:0.17.2",
        # zio
        "dev.zio:zio_2.13:2.0.6",
        "dev.zio:zio-logging_2.13:2.1.8",
        "dev.zio:zio-logging-slf4j_2.13:2.1.8",
        "dev.zio:zio-opentelemetry_2.13:3.0.0-RC1",
        "dev.zio:izumi-reflect_2.13:2.2.2",
        # java
        "io.opentelemetry:opentelemetry-api:1.21.0",
        "io.opentelemetry:opentelemetry-sdk:1.21.0",
        "io.opentelemetry:opentelemetry-exporter-jaeger:1.21.0",
        "ch.qos.logback:logback-classic:1.4.5",
        "com.typesafe:config:1.4.2",
    ],
    fail_if_repin_required = True,
    fetch_sources = True,
    maven_install_json = "//:maven_install.json",
    repositories = [
        "https://repo1.maven.org/maven2",
    ],
    version_conflict_policy = "pinned",
)

load("@maven//:defs.bzl", "pinned_maven_install")

pinned_maven_install()
