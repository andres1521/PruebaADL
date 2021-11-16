package helloworld;

import java.util.HashMap;
import java.util.Map;

import Model.LambdaResponseBus;
import Model.LambdaRequestFriends;
import Service.SizeBus;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyResponseEvent;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

/**
 * Handler for requests to Lambda function.
 */
public class App implements RequestHandler<LambdaRequestFriends, LambdaResponseBus> {

    public LambdaResponseBus handleRequest(LambdaRequestFriends input, Context context) {

        LambdaResponseBus responseBus= new LambdaResponseBus();
        try {

            SizeBus sizeBus = new SizeBus();
             responseBus=sizeBus.getSizeBus(input);

            return responseBus;
        } catch (Exception e) {
            return responseBus;
        }
    }
}
