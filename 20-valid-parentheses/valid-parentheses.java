import java.util.Stack;

class Solution {
    public boolean isValid(String s) {
        //we will use stack
        Stack<Character> x = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            //if we get opening brackets we will push it
            if (ch == '{' || ch == '(' || ch == '[') {
                x.push(ch);
            }
            //now if we get closing bracket 
            // we will check it for every type of bracket
            // first we will check whether stack is empty it means there is no opening bracket
            // than we will check top element of stack if its the correct closing bracket of our corresponding opening bracket we will pop it
            //we will try to empty the stack for valid parenthesis
            else if (ch == '}') {
                if (x.isEmpty()) {
                    return false;
                }

                if (x.peek() == '{') {
                    x.pop();
                    //if we get any other bracket other than our corresponding opening bracket the parenthesis is invalid
                } else {
                    return false;
                }
            }

            else if (ch == ')') {
                if (x.isEmpty()) {
                    return false;
                }

                if (x.peek() == '(') {
                    x.pop();
                } else {
                    return false;
                }
            }

            else {
                if (x.isEmpty()) {
                    return false;
                }

                if (x.peek() == '[') {
                    x.pop();
                } else {
                    return false;
                }
            }
        }

        return x.isEmpty();
    }
}