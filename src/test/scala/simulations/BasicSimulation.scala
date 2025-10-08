package simulations

import io.gatling.core.Predef._
import io.gatling.http.Predef._

class BasicSimulation extends Simulation {

  val httpProtocol = http
    .baseUrl("https://example.com")
    .acceptHeader("application/json")

  val scn = scenario("Example Load Test")
    .exec(
      http("Get Example")
        .get("/")
        .check(status.is(200))
    )

  setUp(
    scn.inject(atOnceUsers(5))
  ).protocols(httpProtocol)
}
