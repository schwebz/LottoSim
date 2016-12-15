import java.lang.reflect.Array;
import java.text.DecimalFormat;
import java.util.*;

/**
 * Created by Peppe on 1/10/2016.
 */
public class LottoSim {

    public static int checkResults(ArrayList ticket, ArrayList draw) {
        //Check for Jackpot
        if (ticket.equals(draw)) {
            return 1;
        }
        //No special match
        if (ticket.get(5) != draw.get(5)) {

            int matchCount = 0;
            ArrayList ticketCopy = new ArrayList(ticket);
            ArrayList drawCopy = new ArrayList(draw);
            ticketCopy.remove(5);
            drawCopy.remove(5);
            while (!ticketCopy.isEmpty() && !drawCopy.isEmpty()) {
                int ticketNum = (Integer) ticketCopy.get(0);
                int drawNum = (Integer) drawCopy.get(0);
                if (ticketNum == drawNum) {
                    matchCount++;
                    drawCopy.remove(0);
                    ticketCopy.remove(0);
                } else if (ticketNum < drawNum) {
                    ticketCopy.remove(0);
                } else {
                    drawCopy.remove(0);
                }
            }
            switch (matchCount) {
                case 0:
                    return 10;

                case 1:
                    return 10;

                case 2:
                    return 10;

                case 3:
                    return 7;

                case 4:
                    return 6;

                case 5:
                    return 2;

                default:
                    return 10;

            }


        }
        //Special Match
        else {
            ArrayList ticketCopy = new ArrayList(ticket);
            ArrayList drawCopy = new ArrayList(draw);
            ticketCopy.remove(5);
            drawCopy.remove(5);
            int matchCount = 0;
            while (!ticketCopy.isEmpty() && !drawCopy.isEmpty()) {
                int ticketNum = (Integer) ticketCopy.get(0);
                int drawNum = (Integer) drawCopy.get(0);
                if (ticketNum == drawNum) {
                    matchCount++;
                    drawCopy.remove(0);
                    ticketCopy.remove(0);
                } else if (ticketNum < drawNum) {
                    ticketCopy.remove(0);
                } else {
                    drawCopy.remove(0);
                }
            }
            switch (matchCount) {
                case 0:
                    return 9;

                case 1:
                    return 8;

                case 2:
                    return 7;

                case 3:
                    return 3;

                case 4:
                    return 5;

                case 5:
                    return 1;

                default:
                    return 10;

            }
        }
    }

    public static double convertToPowerballWinnings(double result, double jackpot) {
        if (result == 1) {
            return jackpot;
        }
        if (result == 2) {
            return 1000000;
        }
        if (result == 3) {
            return 100;
        }
        if (result == 4) {
            return 7;
        }
        if (result == 5) {
            return 50000;
        }
        if (result == 6) {
            return 100;
        }
        if (result == 7) {
            return 7;
        }
        if (result == 8) {
            return 4;
        }
        if (result == 9){
            return 4;
        }

        return 0;

    }

    public static double convertToMegaMillionsWinnings(double result, double jackpot) {
        if (result == 1) {
            return jackpot;
        }
        if (result == 2) {
            return 1000000;
        }
        if (result == 3) {
            return 50;
        }
        if (result == 4) {
            return 7;
        }
        if (result == 5) {
            return 5000;
        }
        if (result == 6) {
            return 500;
        }
        if (result == 7) {
            return 5;
        }
        if (result == 8) {
            return 2;
        }
        if (result == 9){
            return 1;
        }

        return 0;

    }

    public static String makeReadablePowerballResult(double ammmt, ArrayList scatterGram) {
        String ammt = "" + ammmt;
        updatePowerballScattergram(ammt, scatterGram);
        double amt = Double.parseDouble(ammt);
        DecimalFormat formatter = new DecimalFormat("#,###.00");
        return "$" + formatter.format(amt);
    }
    public static String makeReadableMegaMillionsResult(double ammmt, ArrayList scatterGram) {
        String ammt = "" + ammmt;
        updateMegaMillionsScattergram(ammt, scatterGram);
        double amt = Double.parseDouble(ammt);
        DecimalFormat formatter = new DecimalFormat("#,###.00");
        return "$" + formatter.format(amt);
    }


    public static String drawPowerball(ArrayList ticket, ArrayList draw, int jackpot, ArrayList scatterGram) {
        return makeReadablePowerballResult(convertToPowerballWinnings(checkResults(ticket, draw), jackpot), scatterGram);
    }

    public static String drawMegaMillions(ArrayList ticket, ArrayList draw, int jackpot, ArrayList scatterGram) {
        return makeReadableMegaMillionsResult(convertToMegaMillionsWinnings(checkResults(ticket, draw), jackpot), scatterGram);
    }

    public static void updatePowerballScattergram(String num, ArrayList scatterGram) {
        // System.out.println(scatterGram.get(0).getClass());
        double number = Double.parseDouble(num);
        if (number > 1000000) {
            double sc = (double) scatterGram.get(0);
            sc++;
            scatterGram.set(0, sc);
        }
        if (number == 1000000) {
            double sc = (double) scatterGram.get(1);
            sc++;
            scatterGram.set(1, sc);
        }
        if (number == 50000) {
            double sc = (double) scatterGram.get(2);
            sc++;
            scatterGram.set(2, sc);
        }
        if (number == 100) {
            double sc = (double) scatterGram.get(3);
            sc++;
            scatterGram.set(3, sc);
        }
        if (number == 7) {
            double sc = (double) scatterGram.get(4);
            sc++;
            scatterGram.set(4, sc);
        }
        if (number == 4) {
            double sc = (double) scatterGram.get(5);
            sc++;
            scatterGram.set(5, sc);
        } else if (number == 0) {
            double sc = (double) scatterGram.get(6);
            sc++;
            scatterGram.set(6, sc);
        }

    }
    public static void updateMegaMillionsScattergram(String num, ArrayList scatterGram) {
        // System.out.println(scatterGram.get(0).getClass());
        //System.out.println(num);
        double number = Double.parseDouble(num);
        if (number > 1000000) {
            double sc = (double) scatterGram.get(0);
            sc++;
            scatterGram.set(0, sc);
        }
        if (number == 1000000) {
            double sc = (double) scatterGram.get(1);
            sc++;
            scatterGram.set(1, sc);
        }
        if (number == 5000) {
            double sc = (double) scatterGram.get(2);
            sc++;
            scatterGram.set(2, sc);
        }
        if (number == 500) {
            double sc = (double) scatterGram.get(3);
            sc++;
            scatterGram.set(3, sc);
        }
        if (number == 50){
            double sc = (double) scatterGram.get(4);
            sc++;
            scatterGram.set(4, sc);
        }
        if (number == 5) {
            double sc = (double) scatterGram.get(5);
            sc++;
            scatterGram.set(5, sc);
        }
        if (number == 2) {
            double sc = (double) scatterGram.get(6);
            sc++;
            scatterGram.set(6, sc);
        }
        if (number == 1) {
            double sc = (double) scatterGram.get(7);
            sc++;
            scatterGram.set(7, sc);
        }else if (number == 0) {
            double sc = (double) scatterGram.get(8);
            sc++;
            scatterGram.set(8, sc);
        }

    }

    public static double getPowerballMoney(ArrayList scatterGram, double jackpot) {
        double money = 0;
        money += (double) scatterGram.get(0) * jackpot;
        money += (double) scatterGram.get(1) * 1000000;
        money += (double) scatterGram.get(2) * 50000;
        money += (double) scatterGram.get(3) * 100;
        money += (double) scatterGram.get(4) * 7;
        money += (double) scatterGram.get(5) * 4;
        return money;
    }

    public static double getMegaMillionsMoney(ArrayList scatterGram, double jackpot) {
        double money = 0;
        //System.out.println("Running");
        money += (double) scatterGram.get(0) * jackpot;
        money += (double) scatterGram.get(1) * 1000000;
        money += (double) scatterGram.get(2) * 5000;
        money += (double) scatterGram.get(3) * 500;
        money += (double) scatterGram.get(4) * 50;
        money += (double) scatterGram.get(5) * 5;
        money += (double) scatterGram.get(6) * 2;
        money += (double) scatterGram.get(7) * 1;
        return money;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Select 1 for powerball, 0 for mega millions");
        String gameCheck = scanner.next();
        if(Integer.parseInt(gameCheck) == 1) {

            //Powerball Game
            ArrayList<Double> scatterGram = new ArrayList<Double>();
            scatterGram.add(0.0);
            scatterGram.add(0.0);
            scatterGram.add(0.0);
            scatterGram.add(0.0);
            scatterGram.add(0.0);
            scatterGram.add(0.0);
            scatterGram.add(0.0);
            //System.out.println(scatterGram.get(0).getClass());
            System.out.println("Would you like to do a quick pick, or enter your own numbers (1 for quick pick, 0 for own)");
            String quickCheck = scanner.next();
            ArrayList ticket = new ArrayList(); // oddly, this is the draw now
            ArrayList draw = new ArrayList(); // oddly, this is the ticket now
            int next;
            Random random = new Random();
            if (Integer.parseInt(quickCheck) == 0) {
                boolean valid = false;
                while (!valid) {
                    boolean garbage = true;
                    try {
                        draw = new ArrayList();
                        System.out.println("Enter your 1st number (non-powerball)");
                        int digit = Integer.valueOf(scanner.next());
                        if (!(0 <= digit && digit <= 69)) {
                            garbage = false;
                        }
                        draw.add(digit);
                        System.out.println("Enter your 2nd number (non-powerball)");
                        digit = Integer.valueOf(scanner.next());
                        if (!(0 <= digit && digit <= 69)) {
                            garbage = false;
                        }
                        draw.add(digit);
                        System.out.println("Enter your 3rd number (non-powerball)");
                        digit = Integer.valueOf(scanner.next());
                        if (!(0 <= digit && digit <= 69)) {
                            garbage = false;
                        }
                        draw.add(digit);
                        System.out.println("Enter your 4th number (non-powerball)");
                        digit = Integer.valueOf(scanner.next());
                        if (!(0 <= digit && digit <= 69)) {
                            garbage = false;
                        }
                        draw.add(digit);
                        System.out.println("Enter your 5th number (non-powerball)");
                        digit = Integer.valueOf(scanner.next());
                        if (!(0 <= digit && digit <= 69)) {
                            garbage = false;
                        }
                        draw.add(digit);
                        Set<Integer> checkSet = new HashSet<Integer>(draw);
                        if (checkSet.size() < draw.size()) {
                            garbage = false;
                        }
                        System.out.println("Enter your powerball number");
                        digit = Integer.valueOf(scanner.next());
                        if (!(0 <= digit && digit <= 26)) {
                            garbage = false;
                        }
                        draw.add(digit);
                        valid = true;
                    } catch (NumberFormatException e) {
                        System.out.println("Please enter only numbers");
                    }
                    if (!garbage) {
                        System.out.println("Invalid number(s) entered, please try again");
                        valid = false;
                    }


                }
            } else {


                draw.add(random.nextInt(68) + 1);
                next = random.nextInt(68) + 1;
                while (draw.contains(next)) {
                    next = random.nextInt(68) + 1;
                }
                draw.add(next);
                while (draw.contains(next)) {
                    next = random.nextInt(68) + 1;
                }
                draw.add(next);
                while (draw.contains(next)) {
                    next = random.nextInt(68) + 1;
                }
                draw.add(next);
                while (draw.contains(next)) {
                    next = random.nextInt(68) + 1;
                }
                draw.add(next);

                Collections.sort(draw);
                draw.add(random.nextInt(25) + 1);

                System.out.println("This is your quick pick ticket: \n" + draw.toString());
            }
            System.out.println("How many drawings would you like?");
            String number = scanner.next();
            double num = Double.parseDouble(number);
            for (double i = 0; i < num; i++) {
                ticket = new ArrayList();
                ticket.add(random.nextInt(68) + 1);
                next = random.nextInt(68) + 1;
                while (ticket.contains(next)) {
                    next = random.nextInt(68) + 1;
                }
                ticket.add(next);
                while (ticket.contains(next)) {
                    next = random.nextInt(68) + 1;
                }
                ticket.add(next);
                while (ticket.contains(next)) {
                    next = random.nextInt(68) + 1;
                }
                ticket.add(next);
                while (ticket.contains(next)) {
                    next = random.nextInt(68) + 1;
                }
                ticket.add(next);

                Collections.sort(ticket);
                ticket.add(random.nextInt(25) + 1);
                //System.out.println("Draw:   " + draw.toString() +"\n");
                //System.out.println("Ticket: " + ticket.toString() + "\n");
                drawPowerball(ticket, draw, 1500000000, scatterGram);
                //System.out.println(scatterGram.toString());
                //System.out.println("[Jackpot, 1M, 50K, 100, 7, 4, 0]");
                if (i % 1000000 == 0) {
                    System.out.printf("%.0f" + " is the millions\n", i);
                }


            }

            DecimalFormat decimalFormat = new DecimalFormat("0.#");
            System.out.println("Money Spent: $" + decimalFormat.format(num * 2));
            System.out.println("Money Earned: $" + decimalFormat.format(getPowerballMoney(scatterGram, 1500000000)));
            System.out.println("Net Earnings: $" + decimalFormat.format((getPowerballMoney(scatterGram, 1500000000) - (num * 2))));
            System.out.println(scatterGram.toString());
            System.out.println("[Jackpot, 1M, 50K, 100, 7, 4, 0]");
        }

        //Mega Millions Game
        else{
            ArrayList<Double> scatterGram = new ArrayList<Double>();
            scatterGram.add(0.0);
            scatterGram.add(0.0);
            scatterGram.add(0.0);
            scatterGram.add(0.0);
            scatterGram.add(0.0);
            scatterGram.add(0.0);
            scatterGram.add(0.0);
            scatterGram.add(0.0);
            scatterGram.add(0.0);
            //System.out.println(scatterGram.get(0).getClass());
            System.out.println("Would you like to do a quick pick, or enter your own numbers (1 for quick pick, 0 for own)");
            String quickCheck = scanner.next();
            ArrayList ticket = new ArrayList(); // oddly, this is the draw now
            ArrayList draw = new ArrayList(); // oddly, this is the ticket now
            int next;
            Random random = new Random();
            if (Integer.parseInt(quickCheck) == 0) {
                boolean valid = false;
                while (!valid) {
                    boolean garbage = true;
                    try {
                        draw = new ArrayList();
                        System.out.println("Enter your 1st number (non-megaball)");
                        int digit = Integer.valueOf(scanner.next());
                        if (!(0 <= digit && digit <= 75)) {
                            garbage = false;
                        }
                        draw.add(digit);
                        System.out.println("Enter your 2nd number (non-megaball)");
                        digit = Integer.valueOf(scanner.next());
                        if (!(0 <= digit && digit <= 75)) {
                            garbage = false;
                        }
                        draw.add(digit);
                        System.out.println("Enter your 3rd number (non-megaball)");
                        digit = Integer.valueOf(scanner.next());
                        if (!(0 <= digit && digit <= 75)) {
                            garbage = false;
                        }
                        draw.add(digit);
                        System.out.println("Enter your 4th number (non-megaball)");
                        digit = Integer.valueOf(scanner.next());
                        if (!(0 <= digit && digit <= 75)) {
                            garbage = false;
                        }
                        draw.add(digit);
                        System.out.println("Enter your 5th number (non-megaball)");
                        digit = Integer.valueOf(scanner.next());
                        if (!(0 <= digit && digit <= 75)) {
                            garbage = false;
                        }
                        draw.add(digit);
                        Set<Integer> checkSet = new HashSet<Integer>(draw);
                        if (checkSet.size() < draw.size()) {
                            garbage = false;
                        }
                        System.out.println("Enter your megaball number");
                        digit = Integer.valueOf(scanner.next());
                        if (!(0 <= digit && digit <= 15)) {
                            garbage = false;
                        }
                        draw.add(digit);
                        valid = true;
                    } catch (NumberFormatException e) {
                        System.out.println("Please enter only numbers");
                    }
                    if (!garbage) {
                        System.out.println("Invalid number(s) entered, please try again");
                        valid = false;
                    }


                }
            } else {


                draw.add(random.nextInt(75) + 1);
                next = random.nextInt(75) + 1;
                while (draw.contains(next)) {
                    next = random.nextInt(75) + 1;
                }
                draw.add(next);
                while (draw.contains(next)) {
                    next = random.nextInt(75) + 1;
                }
                draw.add(next);
                while (draw.contains(next)) {
                    next = random.nextInt(75) + 1;
                }
                draw.add(next);
                while (draw.contains(next)) {
                    next = random.nextInt(75) + 1;
                }
                draw.add(next);

                Collections.sort(draw);
                draw.add(random.nextInt(15) + 1);

                System.out.println("This is your quick pick ticket: \n" + draw.toString());
            }
            System.out.println("How many drawings would you like?");
            String number = scanner.next();
            double num = Double.parseDouble(number);
            for (double i = 0; i < num; i++) {
                ticket = new ArrayList();
                ticket.add(random.nextInt(75) + 1);
                next = random.nextInt(75) + 1;
                while (ticket.contains(next)) {
                    next = random.nextInt(75) + 1;
                }
                ticket.add(next);
                while (ticket.contains(next)) {
                    next = random.nextInt(75) + 1;
                }
                ticket.add(next);
                while (ticket.contains(next)) {
                    next = random.nextInt(75) + 1;
                }
                ticket.add(next);
                while (ticket.contains(next)) {
                    next = random.nextInt(75) + 1;
                }
                ticket.add(next);

                Collections.sort(ticket);
                ticket.add(random.nextInt(15) + 1);
                //System.out.println("Draw:   " + draw.toString() +"\n");
                //System.out.println("Ticket: " + ticket.toString() + "\n");
                drawMegaMillions(ticket, draw, 1500000000, scatterGram);
                //System.out.println(scatterGram.toString());
                //System.out.println("[Jackpot, 1M, 50K, 100, 7, 4, 0]");
                if (i % 1000000 == 0) {
                    System.out.printf("%.0f" + " is the millions\n", i);
                }


            }

            DecimalFormat decimalFormat = new DecimalFormat("0.#");
            System.out.println("Money Spent: $" + decimalFormat.format(num));
            System.out.println("Money Earned: $" + decimalFormat.format(getMegaMillionsMoney(scatterGram, 1500000000)));
            System.out.println("Net Earnings: $" + decimalFormat.format((getMegaMillionsMoney(scatterGram, 1500000000) - (num))));
            System.out.println(scatterGram.toString());
            System.out.println("[Jackpot, 1M, 5K, 500, 50, 5, 2, 1, 0]");
        }






        /** //Some shitty testing
         ArrayList scatterGram = new ArrayList();
         scatterGram.add(0);
         scatterGram.add(0);
         scatterGram.add(0);
         scatterGram.add(0);
         scatterGram.add(0);
         scatterGram.add(0);
         scatterGram.add(0);
         ArrayList testDraw = new ArrayList();
         ArrayList testTicket = new ArrayList();
         testDraw.add(1);
         testDraw.add(2);
         testDraw.add(3);
         testDraw.add(4);
         testDraw.add(5);
         Collections.sort(testDraw);
         testDraw.add(6);
         testTicket.add(1);
         testTicket.add(2);
         testTicket.add(3);
         testTicket.add(4);
         testTicket.add(5);
         Collections.sort(testTicket);
         testTicket.add(6);
         draw(testTicket, testDraw, 1300000000,scatterGram);
         System.out.println(scatterGram.toString());
         System.out.println("Money Earned: $" + getPowerballMoney(scatterGram, 1500000000));*/


    }


}
