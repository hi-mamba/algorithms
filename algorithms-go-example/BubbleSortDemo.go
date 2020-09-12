package main

import (
	"fmt"
	"sort"
)

// main 函数必须被放在main包中.
func main() {
	// fmt.Println("Hello World") - 使用fmt包中的Println用来输出文字到标准输出设备
	fmt.Println("Hello World")

	// declare a array
	// this array must implenet sort.Inerface
	data := sort.IntSlice{22, 34, 3, 40, 18, 4}
	BubbleSort(data)
	fmt.Println("排序后：", data)
}

// BubbleSort 冒泡排序. data必须实现sort包中的Interface接口
func BubbleSort(data sort.Interface) {
	n := data.Len()
	for i := 0; i < n-1; i++ {
		isChange := false
		for j := 0; j < n-1-i; j++ {
			if data.Less(j, j+1) {
				data.Swap(j, j+1)
				isChange = true
			}
		}
		if !isChange {
			break
		}
	}
}

