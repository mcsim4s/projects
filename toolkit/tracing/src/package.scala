package io.github.mcsim4s.toolkit.tracing

import zio.telemetry.opentelemetry.Tracing
import zio._

package object src {
  implicit class RichTracing(val tracing: Tracing) {
    def markFailed: UIO[Unit] = tracing.setAttribute("error", value = true).unit
  }
}
