package test

import (
	"../leetcode" // 导入同一项目下的mypackage包
	"fmt"
	"testing" //引入go 的testing框架包
)

//编写测试用例，测试getSum是否正确
func TestTwoSum(t *testing.T)  {
	var nums = []int{2, 7, 11, 15}
	target := 9
	actual := leetcode.TwoSum(nums, target)
	fmt.Print(actual)
	if actual[0] != 0 || actual[1] != 1 {
		t.Fatal("actual = ", actual)
	}
}

func TestTwoSumResultIsNull(t *testing.T)  {
	var nums = []int{2, 7, 11, 15}
	target := 99
	actual := leetcode.TwoSum(nums, target)
	if len(actual) !=0 {
		t.Fatal("actual = ", actual)
	}
}


