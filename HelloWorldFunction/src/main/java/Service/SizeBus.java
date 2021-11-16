package Service;

import Model.LambdaResponseBus;
import Model.LambdaRequestFriends;

import java.util.Arrays;

public class SizeBus {

    public LambdaResponseBus getSizeBus(LambdaRequestFriends friends) {
        int x = 1;
        int chairs = 0;
        int[] arrayFriends = Arrays.stream(friends.getGroups().split(","))
                .mapToInt(Integer::parseInt)
                .toArray();

        int totalPassengers = sumPassengers(arrayFriends);
        boolean ok = false;
        String sizesTravels = "";
        while (x < totalPassengers + 1) {
            chairs = x;
            int i = 0;
            while (i < arrayFriends.length) {
                if (arrayFriends[i] <= chairs) {
                    chairs = chairs - arrayFriends[i];
                } else {
                    chairs = -1;
                }
                if (chairs == 0) {
                    chairs = x;
                    ok = true;
                } else {
                    ok = false;
                }
                i++;
            }
            if (ok) {
                if (x != totalPassengers)
                    sizesTravels += x + ",";
                else
                    sizesTravels += x;
            }
            x++;
        }

        LambdaResponseBus bus = new LambdaResponseBus();
        bus.setSizes(sizesTravels);
        return bus;
    }


    int sumPassengers(int[] passengers) {
        int totalpassengers = 0;
        for (int i = 0; i < passengers.length; i++) {
            totalpassengers += passengers[i];
        }
        return totalpassengers;
    }


}
