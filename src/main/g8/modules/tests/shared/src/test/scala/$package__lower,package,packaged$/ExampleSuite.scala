package $package;format="lower,package"$

import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers.should.Matchers.convertToAnyShouldWrapper

final class ExampleSuite extends AnyFunSpec {
  describe("hello world") {
    it("should run") { 1 shouldBe 1 }
  }
}
