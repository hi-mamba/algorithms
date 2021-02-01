package test

import (
	"../leetcode" // 导入同一项目下的mypackage包
	"testing"     //引入go 的testing框架包
)

//编写测试用例，测试getSum是否正确
func TestPush(t *testing.T)  {

	obj := leetcode.Constructor()
	obj.Push(1)
	obj.Push(2)
	obj.Push(3)
	//param_2 := obj.Pop()
	//param_3 := obj.Top()
	//param_4 := obj.Empty()

	if obj.Pop() != 3 {
		t.Error("Pop() ne 3")
	}
	if obj.Pop() != 2 {
		t.Error("Pop() ne 2")
	}

}




