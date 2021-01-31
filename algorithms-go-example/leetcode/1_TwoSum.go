package leetcode

/*

https://leetcode.com/problems/two-sum/

Example:

Given nums = [2, 7, 11, 15], target = 9,

Because nums[0] + nums[1] = 2 + 7 = 9,
return [0, 1].


使用MAP 来实现

*/

func TwoSum(nums []int, target int) []int {

	mapExample := make(map[int]int)

	for i := 0; i < len(nums); i++ {
		if _, ok := mapExample[nums[i]]; ok {
			return []int{mapExample[nums[i]], i}
		} else {
			mapExample[target-nums[i]] = i
		}
	}
	return []int{}
}