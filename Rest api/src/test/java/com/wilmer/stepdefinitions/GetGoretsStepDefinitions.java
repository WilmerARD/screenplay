package com.wilmer.stepdefinitions;

import static net.serenitybdd.screenplay.actors.OnStage.setTheStage;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;
import static org.hamcrest.Matchers.equalTo;

import com.wilmer.tasks.ExcecutionGetToken;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;

public class GetGoretsStepDefinitions {

    @Before
    public void setup(){
        setTheStage(new OnlineCast());
    }

    @Given("{string} establece la base url {string}")
    public void estableceLaBaseUrl(String actorName, String baseUrl) {
        theActorCalled(actorName).whoCan(CallAnApi.at(baseUrl));
    }

    @When("consulta en el endpoint {string} por id {string}")
    public void consultaEnElEndpointPorId(String endpoint, String id) {
        theActorInTheSpotlight().attemptsTo(ExcecutionGetToken.getInformation(endpoint, id));
    }

    @Then("valida que el estatus code sea {int} y la respuesta contenga el nombre {string}")
    public void validaQueElEstatusCodeSeaYLaRespuestaContengaElNombre(Integer status, String nameUser) {
        theActorInTheSpotlight().should(seeThatResponse(response -> response.statusCode(status).body(
                "data.name", equalTo(nameUser))));
    }
}
