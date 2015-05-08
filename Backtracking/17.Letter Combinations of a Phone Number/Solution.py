class Solution:
    # @param {string} digits
    # @return {string[]
    def letterCombinations(self, digits):
		'''
			递归遍历搜索树
			按照DFS递归的模式来写即可
		'''
        def dfs(step, result, answer):
            if step == len(digits):
                result.append(answer)  #遍历到搜索树底(递归出口)，返回添加当前解即可，
                return
            for letter in dict[digits[step]]:  #依次遍历输入数字，找到字典中对应的字母
                dfs(step+1, result, answer+letter)  #递归访问下一步 
                
        dict = {
            '1':[''],
            '2':['a','b','c'],
            '3':['d','e','f'],
            '4':['g','h','i'],
            '5':['j','k','l'],
            '6':['m','n','o'],
            '7':['p','q','r','s'],
            '8':['t','u','v'],
            '9':['w','x','y','z']
        }
        result = []
        if len(digits) == 0: return result
        dfs(0, result, '')
        return result