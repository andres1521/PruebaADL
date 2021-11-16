package helloworld;

import Model.LambdaRequestFriends;
import Model.LambdaResponseBus;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyResponseEvent;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class AppTest {
  @Test
  public void successfulResponse() {
    App app = new App();
    LambdaResponseBus result= new LambdaResponseBus();
    LambdaRequestFriends requestFriends= new LambdaRequestFriends();
    requestFriends.setGroups("1,2,1,1,1,2,1,3");
    result=app.handleRequest(requestFriends,null);
    assertEquals(result.getSizes(), "3,4,6,12");
  }
}
