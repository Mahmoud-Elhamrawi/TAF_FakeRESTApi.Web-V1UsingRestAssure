package TestCases;

import EndPointes.ActivitiesEndPoints;
import Payload.ActivityPojo;
import com.github.javafaker.Faker;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.*;

public class ActivitiesTCWithFakerData {
    Faker faker ;
    ActivityPojo activityPojo ;

    @BeforeClass
    public void setup()
    {
        faker = new Faker();
        activityPojo =new ActivityPojo() ;

        activityPojo.setId(faker.idNumber().hashCode());
        activityPojo.setTitle(faker.book().title());
        activityPojo.setDueDate("2023-08-07T14:49:16.134Z");
        activityPojo.setCompleted(true);


    }

    @Test(priority = 0)
    public  void testPost()
    {
        Response postActivityRes = ActivitiesEndPoints.postActivity(activityPojo)  ;
        postActivityRes.then().log().all();

        Assert.assertEquals(postActivityRes.statusCode() , 200);
    }


    @Test(priority = 1)
    public void testGet()
    {

        Response getActivityRes = ActivitiesEndPoints.getActivity(this.activityPojo.getId());

        getActivityRes.then().log().all();

        Assert.assertEquals(getActivityRes.statusCode() , 200);
    }

    @Test(priority = 2)
    public void testUpdate()
    {
        activityPojo.setTitle(faker.book().title());
        activityPojo.setDueDate("2023-08-07T14:49:16.134Z");
        activityPojo.setCompleted(true);


        Response UpdateActivityRes = ActivitiesEndPoints.updateActivity(this.activityPojo.getId() , activityPojo);
        UpdateActivityRes.then().log().all();

        Assert.assertEquals(UpdateActivityRes.statusCode() , 200);
    }

    @Test(priority = 3)
    public void testdelete()
    {
        Response deleteActivityRes = ActivitiesEndPoints.deleteActivity(this.activityPojo.getId());
        deleteActivityRes.then().log().all();

        Assert.assertEquals(deleteActivityRes.statusCode() , 200);
    }

}
