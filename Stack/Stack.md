
# JDK 集合框架中的栈


## java.util.Stack<E> 
JDK 1.0即包含了Stack类，而Stack继承了Vector类，这样Stack类就有了insert和remove方法，即可以在任何地方插入删除。
而栈这种数据结构实际上只允许在栈顶进行插入删除操作，即我们熟悉的push(e),pop()。(尽管Stack类也提供了这两种方法）

## java.util.Deque<E>
Deque是JDK 1.6添加的双端队列接口，由于双端队列允许在队头队尾进行插入和删除操作，故也可以当做栈来使用。应优先使用此接口而不是遗留 Stack 类。
ArrayDeque<E>和LinkedList<E>类实现了Deque接口。Deque也支持pop(),push(e),peek()操作。在这我们主要关注把双端队列当做FILO的栈来使用。
此类中关于插入删除的操作有：

- void addFirst(E e)：等效于push(e),将指定元素插入此双端队列的开头.
- void addLast(E e): 将指定元素插入此双端队列的末尾
- E pollFirst():获取并移除此双端队列的第一个元素
- E pollLast(): 获取并移除此双端队列的最后一个元素
- E removeFirst():获取并移除此双端队列第一个元素,等效于pop()。
- E removeLast(): 获取并移除此双端队列的最后一个元素。
- E peekFirst()：获取，但不移除此双端队列的第一个元素，相当于peek()。



# Python中的栈