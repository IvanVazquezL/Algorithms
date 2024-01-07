package SocialNetwork;

public class Main {
    public static void main(String[] args) {
        String[] log = {
                "4 3 January 1, 2024, 00:00:00 UTC",
                "3 8 January 2, 2024, 00:00:00 UTC",
                "6 5 January 3, 2024, 00:00:00 UTC",
                "9 4 January 4, 2024, 00:00:00 UTC",
                "2 1 January 5, 2024, 00:00:00 UTC",
                "5 0 January 6, 2024, 00:00:00 UTC",
                "7 2 January 7, 2024, 00:00:00 UTC",
                "6 1 January 8, 2024, 00:00:00 UTC",
                "7 3 January 9, 2024, 00:00:00 UTC",
        };
        SocialNetwork sn = new SocialNetwork(10);

        for (String timestamp : log) {
            sn.union(Character.getNumericValue(timestamp.charAt(0)), Character.getNumericValue(timestamp.charAt(2)));

            if(sn.areAllMembersConnected()) System.out.println(timestamp.substring(4));
        }
    }
}
