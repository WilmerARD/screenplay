package com.wilmer.tasks;

import com.wilmer.constants.ApiConstants;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.rest.interactions.Get;

public class ExcecutionGetToken implements Task {

    private String endPoint;
    private String id;

    public ExcecutionGetToken(String endPoint, String id){
        this.endPoint = endPoint;
        this.id = id;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Get.resource(endPoint.concat(id)).with(
                request -> request.auth().oauth2(ApiConstants.TOKEN)
        ));
        SerenityRest.lastResponse().prettyPeek();
    }

    public static  ExcecutionGetToken getInformation(String endPoint, String id){
        return Tasks.instrumented(ExcecutionGetToken.class, endPoint, id);
    }

}
