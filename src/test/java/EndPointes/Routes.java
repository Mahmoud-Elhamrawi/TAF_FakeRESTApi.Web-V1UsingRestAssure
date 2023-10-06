package EndPointes;

public class Routes {

       public static String base_url ="https://fakerestapi.azurewebsites.net/api/v1";

       //Activities
    public static String createActivity_url =base_url+ "/Activities";
    public static String ReadActivity_url =base_url+"/Activities/{id}";

    public static String ReadAllActivity_url =base_url+"/Activities";
    public static String updateActivity_url =base_url+"/Activities/{id}";
    public static String deleteActivity_url =base_url+"/Activities/{id}";




}
