package week01;

import java.util.Stack;

/**
 * @Auther: johny
 * @Date: 2019-12-15 19:45
 * @Description:
 */

public class Lc042 {

  public int trap(int[] height) {
    Stack<Integer> st = new Stack();
    int ans = 0;
    int current = 0;

    while (current < height.length) {
      while (!st.empty() && height[current] > height[st.peek()]) {
        printStack(st);
        int top = st.peek();
        System.out.println("top = "+top);
        st.pop();
        printStack(st);
        if (st.empty()) {
          break;
        }

        int distance = current - st.peek() - 1;
        System.out.println("distance("+distance+") = current("+current+")-st.peek()("+st.peek()+")-1");
        int bounded_height = Math.min(height[current], height[st.peek()]) - height[top];
        System.out.println("bounded_height("+bounded_height+") = Math.min(height[current]("+height[current]+"), height[st.peek()]("+height[st.peek()]+")) - height[top]("+height[top]+")");
        ans += distance * bounded_height;
      }
      st.push(current++);
      printStack(st);
      System.out.println("------------------------------------------------------------------------------------------------------");
    }
    return ans;
  }

  private void printStack(Stack<Integer> st){

    if(st.isEmpty()){
      System.out.println("st isEmpty");
    }

    for (int i = 0; i < st.size(); i++) {

      if(i == st.size()-1){
        System.out.print(st.get(i) + "\r\n");
      }else{
        System.out.print(st.get(i) + ",");
      }
    }

  }

  public static void main(String[] args) {
    int[] test = {0,1,0,2,1,0,1,3,2,1,2,1};

    Lc042 lc042 = new Lc042();

    System.out.println(lc042.trap(test));

  }
}
