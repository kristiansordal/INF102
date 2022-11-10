package spring_22;

import java.util.ArrayList;
// import java.util.ArrayList;
// import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class InactiveUsers {
    public static List<String> getInactive(List<String> users, List<String> active) {
        List<String> inactive = users.stream()
                .filter(u -> !active.contains(u))
                .collect(Collectors.toList());
        return inactive;
    }

    public static void main(String[] args) {
        ArrayList<String> users = new ArrayList<>();
        ArrayList<String> active = new ArrayList<>();
        users.add("a");
        users.add("b");
        users.add("c");
        users.add("d");
        users.add("e");
        users.add("f");
        users.add("g");
        users.add("h");
        active.add("a");
        active.add("b");
        active.add("c");
        active.add("d");
        active.add("e");

        List<String> inactive = getInactive(users, active);
        System.out.println(inactive);
    }

}
