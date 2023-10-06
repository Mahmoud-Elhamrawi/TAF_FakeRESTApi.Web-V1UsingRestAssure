package TestCases;

import EndPointes.ActivitiesEndPoints;
import Payload.ActivityPojo;
import com.github.javafaker.Faker;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.*;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ActivitiesTCWithDDT {
    ActivityPojo activityPojo ;
    Faker faker = new Faker();
    @BeforeClass
    public void setup() throws IOException, CsvValidationException {
        faker = new Faker();
        activityPojo = new ActivityPojo();


        String pathCSV = "./src\\test\\resources\\ActivitiesData.csv";
        CSVReader reader = new CSVReader(new FileReader(pathCSV));
        String[] csvCell;
        while ((csvCell = reader.readNext()) != null) {
            int id = faker.idNumber().hashCode();
            String title = csvCell[0];
            String dueDate = csvCell[1];
            String completed = csvCell[2];


            activityPojo.setId(id);
            activityPojo.setTitle(title);
            activityPojo.setDueDate(dueDate);
            activityPojo.setCompleted(Boolean.parseBoolean(completed));


        }
    }

    @Test(priority = 0)
    public void testPost()
    {
        Response ResPostActivity = ActivitiesEndPoints.postActivity(activityPojo) ;
        ResPostActivity.then().log().all();

        Assert.assertEquals(ResPostActivity.statusCode() , 200);
    }

    @Test(priority = 1)
    public void testGet()
    {
        System.out.println(this.activityPojo.getId());
        Response RssGetActivity = ActivitiesEndPoints.getAllActivity();
        RssGetActivity.prettyPrint() ;

        Assert.assertEquals(RssGetActivity.statusCode() , 200);

    }


        @Test(priority = 2)
        public void testUpdate()
        {
            Response ResUpdateActivity = ActivitiesEndPoints.updateActivity(this.activityPojo.getId()  , activityPojo) ;
            ResUpdateActivity.prettyPrint() ;
            Assert.assertEquals(ResUpdateActivity.statusCode() , 200);
        }


        @Test(priority = 3)
        public void testDelete()
        {
            Response ResDeleteActivity = ActivitiesEndPoints.deleteActivity(this.activityPojo.getId());
            ResDeleteActivity.prettyPrint() ;
            Assert.assertEquals(ResDeleteActivity.statusCode() , 200);
        }











}
