package leetcode


type MyStack struct {
	q_temp []int
	q_main []int
}

func Constructor() MyStack {
	return MyStack{}
}

func (this *MyStack) Push(x int) {
	this.q_temp = append(this.q_temp, x)
	for i := range this.q_main {
		this.q_temp = append(this.q_temp,this.q_temp[0])
		this.q_main = this.q_main[i:]

	}
	for len(this.q_temp) > 0 {
		this.q_main  = append(this.q_main , this.q_temp[0])
		this.q_temp = this.q_temp[1:]
	}
}

/** Removes the element on top of the stack and returns that element. */
func (this *MyStack) Pop() int {
	v := this.q_main[0]
	this.q_main = this.q_main[1:]
	return v
}


/** Get the top element. */
func (this *MyStack) Top() int {
	return this.q_main[0]
}


/** Returns whether the stack is empty. */
func (this *MyStack) Empty() bool {
	return len(this.q_main) == 0
}