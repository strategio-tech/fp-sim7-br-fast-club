package com.bezkoder.spring.datajpa.cucumber;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/Feature/cucumber.feature", publish=true, plugin = {"pretty"})
public class CucumberIntegrationTest {

}
