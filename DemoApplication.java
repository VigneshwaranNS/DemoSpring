	public static String battleResult(int yourSoldiers, int opponentSoldiers, boolean advantage) {
        if (advantage) {
            return yourSoldiers > opponentSoldiers  ? "You Win" : "Draw";
        } else {
            return yourSoldiers < opponentSoldiers ? "You Lose" : "Draw";
        }
    }

    public static boolean getAdvantage(String unitClass, String opponentUnitClass) {
        Map<String, List<String>> advantages = new HashMap<>();
        advantages.put("Militia", List.of("Spearmen", "LightCavalry"));
        advantages.put("Spearmen", List.of("LightCavalry", "HeavyCavalry"));
        advantages.put("LightCavalry", List.of("FootArcher", "CavalryArcher"));
        advantages.put("HeavyCavalry", List.of("Militia", "FootArcher", "LightCavalry"));
        advantages.put("CavalryArcher", List.of("Spearmen", "HeavyCavalry"));
        advantages.put("FootArcher", List.of("Militia", "CavalryArcher"));

        return advantages.get(unitClass).contains(opponentUnitClass);
    }

    public static List<String> planAttack(List<String> yourPlatoons, List<String> opponentPlatoons) {
        List<String> results = new ArrayList<>();

        for (String yourPlatoon : yourPlatoons) {
            String[] yourPlatoonParts = yourPlatoon.split("#");
            String yourClass = yourPlatoonParts[0];
            int yourSoldiers = Integer.parseInt(yourPlatoonParts[1]);

            int possibleWins = 0;

            for (String opponentPlatoon : opponentPlatoons) {
                String[] opponentPlatoonParts = opponentPlatoon.split("#");
                String opponentClass = opponentPlatoonParts[0];
                int opponentSoldiers = Integer.parseInt(opponentPlatoonParts[1]);

                boolean advantage = getAdvantage(yourClass, opponentClass);
                String result = battleResult(yourSoldiers, opponentSoldiers, advantage);

                if (result.equals("You Win")) {
                    possibleWins += 1;
                }
            }

            results.add(yourPlatoon + " - Possible Wins: " + possibleWins);
        }

        results.sort((a, b) -> {
            int aWins = Integer.parseInt(a.split(": ")[1]);
            int bWins = Integer.parseInt(b.split(": ")[1]);
            return bWins - aWins;
        });

        return results.subList(0, Math.min(5, results.size()));
    }

    public static void main(String[] args) {
        List<String> yourPlatoons = List.of("Militia#50", "Spearmen#40", "LightCavalry#30", "HeavyCavalry#20", "CavalryArcher#10");
        List<String> opponentPlatoons = List.of("FootArcher#60", "Spearmen#50", "Militia#40", "CavalryArcher#30", "HeavyCavalry#20");

        List<String> result = planAttack(yourPlatoons, opponentPlatoons);

        for (String platoon : result) {
            System.out.println(platoon);
        }
    }	
}


// I gothrough the code and Im using JAVA
// In the comparison area:battleResult method 
// if block compare with opponent that time opponent units will be doubled and comparing :: 
// that time the positive result will goes to negative :: so Im updated the code.

// Before Code Change Result:

// Militia#50 - Possible Wins: 0
// Spearmen#40 - Possible Wins: 0
// LightCavalry#30 - Possible Wins: 0
// HeavyCavalry#20 - Possible Wins: 0
// CavalryArcher#10 - Possible Wins: 0

// After Code Change result:

// Spearmen#40 - Possible Wins: 1
// Militia#50 - Possible Wins: 0
// LightCavalry#30 - Possible Wins: 0
// HeavyCavalry#20 - Possible Wins: 0
// CavalryArcher#10 - Possible Wins: 0

