import java.util.*;

public class NestedIterator implements Iterator<Integer> {
    private Deque<NestedInteger> stack;

    public NestedIterator(List<NestedInteger> nestedList) {
        stack = new ArrayDeque<>();
        // Push all elements in reverse order so first element is on top
        prepareStack(nestedList);
    }

    private void prepareStack(List<NestedInteger> nestedList) {
        for (int i = nestedList.size() - 1; i >= 0; i--) {
            stack.push(nestedList.get(i));
        }
    }

    @Override
    public Integer next() {
        // hasNext will ensure top is integer
        return stack.pop().getInteger();
    }

    @Override
    public boolean hasNext() {
        while (!stack.isEmpty()) {
            NestedInteger top = stack.peek();
            if (top.isInteger()) {
                return true;
            }
            // If top is a list, unpack it
            stack.pop();
            prepareStack(top.getList());
        }
        return false;
    }
}
