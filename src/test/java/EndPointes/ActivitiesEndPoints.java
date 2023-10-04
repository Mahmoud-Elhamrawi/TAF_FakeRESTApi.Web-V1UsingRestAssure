package EndPointes;

import Payload.ActivityPojo;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;
public class ActivitiesEndPoints {



    public static Response postActivity(ActivityPojo payload)
    {
        Response activityPostRes = given()
                 .contentType(ContentType.JSON)
                 .accept(ContentType.JSON)
                .body(payload)
                .when().post(Routes.createActivity_url);


        return  activityPostRes;
    }

    public static  Response getActivity(int idActivity)
    {
        Response activityReadRes = given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .pathParam("id",idActivity)
                .when().get(Routes.ReadActivity_url) ;

        return activityReadRes ;
    }
    public static  Response updateActivity(int idActivity ,ActivityPojo payload )
    {
        Response activityUpdateRes = given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .pathParam("id",idActivity)
                .body(payload)
                .when().put(Routes.updateActivity_url) ;

        return activityUpdateRes ;
    }

    public static  Response deleteActivity(int idActivity)
    {
        Response activityDeleteRes = given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .pathParam("id",idActivity)
                .when().delete(Routes.deleteActivity_url) ;

        return activityDeleteRes ;
    }


}
