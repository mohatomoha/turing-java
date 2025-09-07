public class Main
{
    public static void main(String[] args) {
        /*  try not to made redundant and copy-and-paste code challenge (impossible)
            
            v0.0.1 finished 09/05/2025
            change the 5 states below to simulate a turing machine (i could add more/less states but that'd take a bit too long)

            cool tables (X just means that it doesnt matter what you put there):
            
            the 5-state champion
            String[] state_a = {"1RB_A0", "1LC_A1"};
            String[] state_b = {"1RC_B0", "1RB_B1"};
            String[] state_c = {"1RD_C0", "0LE_C1"};
            String[] state_d = {"1LA_D0", "1LD_D1"};
            String[] state_e = {"1RH_E0", "0LA_E1"};
            
            the nuke
            String[] state_a = {"1RB_A0", "XXX_A1"};
            String[] state_b = {"1RC_B0", "XXX_B1"};
            String[] state_c = {"1RA_C0", "XXX_C1"};
            String[] state_d = {"NUL_D0", "NUL_D1"};
            String[] state_e = {"NUL_E0", "NUL_E1"};

            the 4-state champion
            String[] state_a = {"1RB_A0", "1LB_A1"};
            String[] state_b = {"1LA_B0", "0LC_B1"};
            String[] state_c = {"1RH_C0", "1LD_C1"};
            String[] state_d = {"1RD_D0", "0RA_D1"};

            oops
            String[] state_a = {"1RB_A0", "1LB_A1"};
            String[] state_b = {"1LA_B0", "0LC_B1"};
            String[] state_c = {"1RH_C0", "1LD_C1"};
            String[] state_d = {"1RD_D0", "0LA_D1"};

            super slow nuke
            String[] state_a = {"1RB_A0", "0LB_A1"};
            String[] state_b = {"1LA_B0", "0LC_B1"};
            String[] state_c = {"XXX_C0", "1LD_C1"};
            String[] state_d = {"1RD_D0", "0RA_D1"};

         */

        // init the turing machine
        String turing = "0";
        String[] state_a = {"1RB_A0", "1LC_A1"};
        String[] state_b = {"1RC_B0", "1RB_B1"};
        String[] state_c = {"1RD_C0", "0LE_C1"};
        String[] state_d = {"1LA_D0", "1LD_D1"};
        String[] state_e = {"1RH_E0", "0LA_E1"};
        char current_state = 'A';
        int calc_speed_ms = 0;
        boolean halt = false;
        
        // integer values..
        int iter = 0;
        int pointer = 0;
        float start_time = System.nanoTime();

        System.out.println("STARTING TURING MACHINE.");
        System.out.println("TAPE: 0");

        String pointer_output = " ".repeat(pointer + 6) + "^";
        char check = turing.charAt(pointer);
        String cutoff = "-".repeat(turing.length() + 6);

        while (halt == false) {

            switch (current_state) {
                // STATE A.
                case 'A':

                    // if the pointer position is at zero

                    if (check == '0') {
                        // checking the first step

                        turing = turing.substring(0, pointer) + state_a[0].charAt(0) + turing.substring(pointer + 1);
                       
                        // checking the direction the pointer moves (if it moves left)
                        if (state_a[0].charAt(1) == 'L') {

                            if (pointer > 0) {
                                pointer -= 1;
                            }

                            else {
                                turing = "0" + turing;
                                pointer = 0;
                            }

                        }
                        
                        // checking if it moves right

                        else if (state_a[0].charAt(1) == 'R') {

                            if (pointer < turing.length() - 1) {
                                pointer += 1;
                            }

                            else {
                                turing = turing + "0";
                                pointer = turing.length() - 1;
                            }

                        }
                        // change states

                        current_state = state_a[0].charAt(2);
                        System.out.println("COMMAND DONE: " + state_a[0]);
                    }

                    // if the pointer position is at one

                    else if (check == '1') {
                        // checking the first step

                        turing = turing.substring(0, pointer) + state_a[1].charAt(0) + turing.substring(pointer + 1);
                       
                        // checking the direction the pointer moves (if it moves left)
                        if (state_a[1].charAt(1) == 'L') {

                            if (pointer > 0) {
                                pointer -= 1;
                            }

                            else {
                                turing = "0" + turing;
                                pointer = 0;
                            }

                        }
                        
                        // checking if it moves right

                        else if (state_a[1].charAt(1) == 'R') {

                            if (pointer < turing.length() - 1) {
                                pointer += 1;
                            }

                            else {
                                turing = turing + "0";
                                pointer = turing.length() - 1;
                            }

                        }
                        // change states

                        current_state = state_a[1].charAt(2);
                        System.out.println("COMMAND DONE: " + state_a[1]);

                    }
                    break;
                // STATE B.
                case 'B':
                    if (check == '0') {
                        // checking the first step

                        turing = turing.substring(0, pointer) + state_b[0].charAt(0) + turing.substring(pointer + 1);
                        
                        // checking the direction the pointer moves (if it moves left)
                        if (state_b[0].charAt(1) == 'L') {

                            if (pointer > 0) {
                                pointer -= 1;
                            }

                            else {
                                turing = "0" + turing;
                                pointer = 0;
                            }

                        }
                        
                        // checking if it moves right

                        else if (state_b[0].charAt(1) == 'R') {

                            if (pointer < turing.length() - 1) {
                                pointer += 1;
                            }

                            else {
                                turing = turing + "0";
                                pointer = turing.length() - 1;
                            }

                        }
                        // change states

                        current_state = state_b[0].charAt(2);
                        System.out.println("COMMAND DONE: " + state_b[0]);
                    }

                    // if the pointer position is at one

                    else if (check == '1') {
                        // checking the first step

                        turing = turing.substring(0, pointer) + state_b[1].charAt(0) + turing.substring(pointer + 1);
                        
                        // checking the direction the pointer moves (if it moves left)
                        if (state_b[1].charAt(1) == 'L') {

                            if (pointer > 0) {
                                pointer -= 1;
                            }

                            else {
                                turing = "0" + turing;
                                pointer = 0;
                            }

                        }
                        
                        // checking if it moves right

                        else if (state_b[1].charAt(1) == 'R') {

                            if (pointer < turing.length() - 1) {
                                pointer += 1;
                            }

                            else {
                                turing = turing + "0";
                                pointer = turing.length() - 1;
                            }

                        }
                        // change states

                        current_state = state_b[1].charAt(2);
                        System.out.println("COMMAND DONE: " + state_b[1]);
                    }
                    break;
                // STATE C.
                case 'C':
                    if (check == '0') {
                        // checking the first step

                        turing = turing.substring(0, pointer) + state_c[0].charAt(0) + turing.substring(pointer + 1);
                        
                        // checking the direction the pointer moves (if it moves left)
                        if (state_c[0].charAt(1) == 'L') {

                            if (pointer > 0) {
                                pointer -= 1;
                            }

                            else {
                                turing = "0" + turing;
                                pointer = 0;
                            }

                        }
                        
                        // checking if it moves right

                        else if (state_c[0].charAt(1) == 'R') {

                            if (pointer < turing.length() - 1) {
                                pointer += 1;
                            }

                            else {
                                turing = turing + "0";
                                pointer = turing.length() - 1;
                            }

                        }
                        // change states

                        current_state = state_c[0].charAt(2);
                        System.out.println("COMMAND DONE: " + state_c[0]);
                    }

                    // if the pointer position is at one

                    else if (check == '1') {
                        // checking the first step

                        turing = turing.substring(0, pointer) + state_c[1].charAt(0) + turing.substring(pointer + 1);
                        
                        // checking the direction the pointer moves (if it moves left)
                        if (state_c[1].charAt(1) == 'L') {

                            if (pointer > 0) {
                                pointer -= 1;
                            }

                            else {
                                turing = "0" + turing;
                                pointer = 0;
                            }

                        }
                        
                        // checking if it moves right

                        else if (state_c[1].charAt(1) == 'R') {

                            if (pointer < turing.length() - 1) {
                                pointer += 1;
                            }

                            else {
                                turing = turing + "0";
                                pointer = turing.length() - 1;
                            }

                        }
                        // change states

                        current_state = state_c[1].charAt(2);
                        System.out.println("COMMAND DONE: " + state_c[1]);
                    }
                    break;
                // STATE D.
                case 'D':
                    if (check == '0') {
                        // checking the first step

                        turing = turing.substring(0, pointer) + state_d[0].charAt(0) + turing.substring(pointer + 1);
                        
                        // checking the direction the pointer moves (if it moves left)
                        if (state_d[0].charAt(1) == 'L') {

                            if (pointer > 0) {
                                pointer -= 1;
                            }

                            else {
                                turing = "0" + turing;
                                pointer = 0;
                            }

                        }
                        
                        // checking if it moves right

                        else if (state_d[0].charAt(1) == 'R') {

                            if (pointer < turing.length() - 1) {
                                pointer += 1;
                            }

                            else {
                                turing = turing + "0";
                                pointer = turing.length() - 1;
                            }

                        }
                        // change states

                        current_state = state_d[0].charAt(2);
                        System.out.println("COMMAND DONE: " + state_d[0]);
                    }

                    // if the pointer position is at one

                    else if (check == '1') {
                        // checking the first step

                        turing = turing.substring(0, pointer) + state_d[1].charAt(0) + turing.substring(pointer + 1);
                        
                        // checking the direction the pointer moves (if it moves left)
                        if (state_d[1].charAt(1) == 'L') {

                            if (pointer > 0) {
                                pointer -= 1;
                            }

                            else {
                                turing = "0" + turing;
                                pointer = 0;
                            }

                        }
                        
                        // checking if it moves right

                        else if (state_d[1].charAt(1) == 'R') {

                            if (pointer < turing.length() - 1) {
                                pointer += 1;
                            }

                            else {
                                turing = turing + "0";
                                pointer = turing.length() - 1;
                            }

                        }
                        // change states

                        current_state = state_d[1].charAt(2);
                        System.out.println("COMMAND DONE: " + state_d[1]);
                    }
                    break;
                case 'E':

                    // if the pointer position is at zero

                    if (check == '0') {
                        // checking the first step

                        turing = turing.substring(0, pointer) + state_e[0].charAt(0) + turing.substring(pointer + 1);
                       
                        // checking the direction the pointer moves (if it moves left)
                        if (state_e[0].charAt(1) == 'L') {

                            if (pointer > 0) {
                                pointer -= 1;
                            }

                            else {
                                turing = "0" + turing;
                                pointer = 0;
                            }

                        }
                        
                        // checking if it moves right

                        else if (state_e[0].charAt(1) == 'R') {

                            if (pointer < turing.length() - 1) {
                                pointer += 1;
                            }

                            else {
                                turing = turing + "0";
                                pointer = turing.length() - 1;
                            }

                        }
                        // change states

                        current_state = state_e[0].charAt(2);
                        System.out.println("COMMAND DONE: " + state_e[0]);
                    }

                    // if the pointer position is at one

                    else if (check == '1') {
                        // checking the first step

                        turing = turing.substring(0, pointer) + state_e[1].charAt(0) + turing.substring(pointer + 1);
                       
                        // checking the direction the pointer moves (if it moves left)
                        if (state_e[1].charAt(1) == 'L') {

                            if (pointer > 0) {
                                pointer -= 1;
                            }

                            else {
                                turing = "0" + turing;
                                pointer = 0;
                            }

                        }
                        
                        // checking if it moves right

                        else if (state_e[1].charAt(1) == 'R') {

                            if (pointer < turing.length() - 1) {
                                pointer += 1;
                            }

                            else {
                                turing = turing + "0";
                                pointer = turing.length() - 1;
                            }

                        }
                        // change states

                        current_state = state_e[1].charAt(2);
                        System.out.println("COMMAND DONE: " + state_e[1]);

                    }
                    break;
                case 'H':
                    String final_output = "HALTED. TOTAL ITERATIONS: " + iter;
                    System.out.println(final_output);
                    halt = true;
                    // didnt know i had to break until the internet told me 😔
                    break;
                }
            if (halt == false) {
                iter += 1;
                String iter_print = "CURRENT ITERATION: " + iter;
                System.out.println(iter_print);
                float sim_time = System.nanoTime();
                float time = (sim_time - start_time)/1000000000;
                String time_output = "TIME: " + time;
                System.out.println(time_output);
                check = turing.charAt(pointer);
                System.out.println("TAPE: " + turing);
                pointer_output = " ".repeat(pointer + 6) + "^";
                cutoff = "-".repeat(turing.length() + 6);
                
                // cutoff limiter to prevent that UGLY overflow (36 to 163)

                if (cutoff.length() > 36){
                    cutoff = "------------------------------------";
                }

                System.out.println(pointer_output);
                System.out.println(cutoff);

                // thank you stack overflow for teaching me this. :heart:

                try {
                    Thread.sleep(calc_speed_ms);
                } 
                catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    }
}

/*
 super inefficient and long and its super annoying to have
 to edit all of the casework when i want to add an update
 like adding more than 2 symbols but its cool to look at
*/