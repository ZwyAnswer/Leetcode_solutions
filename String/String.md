# Java Character 常用API

	-Character.isLetterOrDigit(char c), 确定给定字符是否是字符或数字
	-Character.toLowerCase(char c), 将字符参数转换为小写返回
	-Character.isWhitespace(char c), 判断给定字符是否是空白符
	-Character.isDigit(char c), 判断给定字符是否是数字
	-Character.getNumericValue(char c), 返回给定字符对应是数值（也可以使用 (int)(c - '0') 

# Java String\ StringBuilder API
	StringBuilder sb = new StringBuilder();

	-sb.deleteCharAt(int index),删除指定位置上的字符