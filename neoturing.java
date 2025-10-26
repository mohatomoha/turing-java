import java.util.ArrayList;

public class neoturing{
    private ArrayList<Character> tape = new ArrayList<>();
    private String[][] states;
    private char current_state;
    private int head;
    public neoturing(ArrayList<Character> tape, String[][] states, char current_state, int head){
        this.tape = tape;
        this.states = states;
        this.current_state = current_state;
        this.head = head;
    }
    void flip(int pos, char set){
        this.tape.set(pos, set);
    }
    void move_left(){
        if(this.head > 0){
            this.head -= 1;
        }
        else{
            this.tape.add(0, '0');
        }
    }
    void move_right(){
        head += 1;
        if(this.head >= this.tape.size()){
            this.tape.add('0');
        }
    }
    void iterate(){
        int given_pos = this.current_state - 65;
        
        // if not halt
        if(given_pos >= 0){
            int tape_index = this.tape.get(this.head) - 48;
            String tape_instructions = this.states[given_pos][tape_index];

            // step 1
            this.flip(this.head, tape_instructions.charAt(0));

            // step 2 (0 in ascii is 48)
            if(tape_instructions.charAt(1) == 'L'){
                this.move_left();
            }
            else{
                this.move_right();
            }

            // step 3
            this.current_state = tape_instructions.charAt(2);
        }
    }
    public static void main(String[] args){
        System.out.println("Starting tape.");
        int iterations = 0;
        int modulo = 100000;
        long start_time = System.nanoTime();
        double time_passed = 0;
        String[][] my_states = {
            {"1RB", "1LC"}, 
            {"1RC", "1RB"}, 
            {"1RD", "0LE"}, 
            {"1LA", "1LD"}, 
            {"1R!", "0LA"}
        };
        ArrayList<Character> my_tape = new ArrayList<>();
        my_tape.add('0');
        neoturing turing = new neoturing(my_tape, my_states, 'A', 0);
        while(turing.current_state - 64 >= 0){
            turing.iterate();
            iterations += 1;
            StringBuilder tape_string = new StringBuilder();
            for(char c : turing.tape){
                tape_string.append(c);
            }
            String final_tape = tape_string.toString();
            if(iterations % modulo == 0){
                System.out.println("--------------------------------------------------");
                System.out.println("TAPE: " + final_tape);
                System.out.println("TAPE LENGTH: " + turing.tape.size());
                System.out.println("ITERATIONS: " + iterations);
                double past_time = time_passed;
                time_passed = (double) (System.nanoTime() - start_time)/1000000000;
                System.out.println("TIME PASSED: " + time_passed);
                double elapsed = (double)(time_passed - past_time);
                System.out.println("ITERATIONS PER SECOND: " + (double) (modulo)/(elapsed));
                // System.out.println(elapsed);
            }
        }
        iterations += 1;
        StringBuilder tape_string = new StringBuilder();
        for(char c : turing.tape){
            tape_string.append(c);
        }
        String final_tape = tape_string.toString();
        if(iterations % modulo == 0){
            System.out.println("--------------------------------------------------");
            System.out.println("FINAL TAPE: " + final_tape);
            System.out.println("FINAL TAPE LENGTH: " + turing.tape.size());
            System.out.println("TOTAL ITERATIONS: " + iterations);
            double past_time = time_passed;
            time_passed = (double) (System.nanoTime() - start_time)/1000000000;
            System.out.println("TOTAL TIME PASSED: " + time_passed);
            double elapsed = (double)(time_passed - past_time);
            System.out.println("FINAL ITERATIONS PER SECOND: " + (double) (modulo)/(elapsed));
        }
    }
}