package dataStructure;

import java.util.*;

public class UnzipStr {
    public String solution(String s){
        String answer = "";

        Stack<String> stack = new Stack<>();

        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == ')'){
                String str = getTargetStr(stack);
                int cntRepeat = getCntRepeat(stack);

                stack.push(str.repeat(cntRepeat));
            }
            else stack.push(s.substring(i, i + 1));
        }

        while(!stack.isEmpty()) answer = stack.pop() + answer;

        return answer;
    }

    private String getTargetStr(Stack<String> stack){
        String result = "";

        while(!stack.isEmpty()){
            String str = stack.pop();

            if(str.equals("(")){
                break;
            }

            result = str + result;
        }

        return result;
    }

    private int getCntRepeat(Stack<String> stack){
        String result = "";

        while(!stack.isEmpty() && Character.isDigit(stack.peek().charAt(0))){
            result = stack.pop() + result;
        }

        return !result.equals("") ? Integer.parseInt(result) : 1;
    }

    // 1. 숫자, 문자, 여는 괄호 스택에 그냥 다 넣는다.
    // 2. 닫는 괄호면 스택에서 여는 괄호가 나올 때 까지 pop 해서 꺼낸 요소가 모두 이어진 문자열을 만든다.
    // 3. 반복 횟수를 스택에서 pop 하여 구한다.
    // 4. 2에서 만든 문자열과 반복횟수로 repeat() 한 뒤 스택에 push 한다.
    // 5. 모든 과정이 끝나고 stack 에 남아있는 모든 문자열들을 꺼내서 answer 에 모두 이은 형태로 저장한다.


    public static void main(String[] args){
        UnzipStr T = new UnzipStr();
        System.out.println(T.solution("3(a2(b))ef"));
        System.out.println(T.solution("2(ab)k3(bc)"));
        System.out.println(T.solution("2(ab3((cd)))"));
        System.out.println(T.solution("2(2(ab)3(2(ac)))"));
        System.out.println(T.solution("3(ab2(sg))"));
    }
}
