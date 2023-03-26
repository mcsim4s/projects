package io.github.mcsim4s.toolkit.doobie

import doobie.Transactor
import doobie.util.transactor.Strategy
import io.github.mcsim4s.toolkit.config.JdbcConfig
import zio._
import zio.telemetry.opentelemetry.Tracing

object ClickhouseTransactor {

  val layer: ZLayer[Scope with Tracing with JdbcConfig, Throwable, Transactor[Task]] = zio.ZLayer {
    for {
      config <- ZIO.service[JdbcConfig]
      tracing <- ZIO.service[Tracing]
      result <- OpsTransactor.makeTransactor(config, tracing)
    } yield result.copy(strategy0 = Strategy.void)
  }
}
