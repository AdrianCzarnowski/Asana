import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(monochrome = true, features = {"src/test/java/features"}, strict = true, glue = {"stepDefinitions"})
public class RunTest { }