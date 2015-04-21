class Solution:
    # @param s, a string
    # @return an integer
	
	###
		关键在于利用字符串的split方法把字符串分割(默认以空白为分隔符)为列表
		此处不用先去除首位空格(strip()方法)，因为split会把首位空白也分割掉。
	###
    def lengthOfLastWord(self, s):
		list = s.split()  # 生成单词组成的列表
        if list == [] : return 0
        last = len(list) - 1  # 最后一个单词
        return len(list[last])
		
		
	# 好吧 其实也可以一句写完
	def lengthOfLastWord2(self, s):
        return len(s.split()[len(s.split())-1]) if s.split() != [] else 0