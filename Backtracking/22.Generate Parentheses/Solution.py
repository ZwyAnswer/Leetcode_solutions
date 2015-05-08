class Solution:
    # @param {integer} n
    # @return {string[]}
	'''
		找出给定数目的有效括号组合（不能出现”)("
		属于搜索问题，可用DFS策略的回溯搜索
		参数含义：left代表剩余左括号数，right表示剩余右括号数，str代表当前临时解
	'''
    def dfs(self, left, right, result, str):
        if left == 0 and right ==0 :
            result.append(str)   # 左右括号都用完了，递归终止。
            return
        if left > 0:
			#每个左括号，添加一个'('到临时解，左括号数减一，对应右括号数加一(即对应的右括号)
            self.dfs(left-1, right+1, result, str+'(') 
        if right > 0:
			#每个右括号，添加一个’)'到临时解，只需把右括号数减一即可
            self.dfs(left, right-1, result, str+')') #
    
    def generateParenthesis(self, n):
        result = []
        self.dfs(n, 0, result, '')  #n对括号，初始n个左括号，递归过程中会添加对应的右括号
        return result