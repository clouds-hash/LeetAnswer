public class Leet14 {
    //14. 最长公共前缀
    public static void main(String[] args) {
        Solution14 solution = new Solution14();
        Solution14_2 solution2 = new Solution14_2();
        
        System.out.println("=== 原始版本 (Solution) ===");
        // 测试用例 1: 存在公共前缀
        String[] strs1 = {"flower", "flow", "flight"};
        System.out.println("Test 1: " + solution.longestCommonPrefix(strs1)); // 预期输出: "fl"

        // 测试用例 2: 不存在公共前缀
        String[] strs2 = {"dog", "racecar", "car"};
        System.out.println("Test 2: " + solution.longestCommonPrefix(strs2)); // 预期输出: ""

        // 测试用例 3: 单个字符串
        String[] strs3 = {"single"};
        System.out.println("Test 3: " + solution.longestCommonPrefix(strs3)); // 预期输出: "single"
        
        // 测试用例 5: 包含空字符串
        String[] strs5 = {"", "b"};
        System.out.println("Test 5: " + solution.longestCommonPrefix(strs5)); // 预期输出: ""
        
        System.out.println("\n=== 修正版本 (Solution2) ===");
        // 测试用例 1: 存在公共前缀
        System.out.println("Test 1: " + solution2.longestCommonPrefix(strs1)); // 预期输出: "fl"

        // 测试用例 2: 不存在公共前缀
        System.out.println("Test 2: " + solution2.longestCommonPrefix(strs2)); // 预期输出: ""

        // 测试用例 3: 单个字符串
        System.out.println("Test 3: " + solution2.longestCommonPrefix(strs3)); // 预期输出: "single"
        
        // 测试用例 4: 空数组
        String[] strs4 = {};
        System.out.println("Test 4: " + solution2.longestCommonPrefix(strs4)); // 预期输出: ""
        
        // 测试用例 5: 包含空字符串
        System.out.println("Test 5: " + solution2.longestCommonPrefix(strs5)); // 预期输出: ""
    }
}

class Solution14_2 {
    public String longestCommonPrefix(String[] strs) {
        // 处理边界情况
        if (strs == null || strs.length == 0) {
            return "";
        }
        
        StringBuilder sb = new StringBuilder();
        // 先获取第一个字符串
        sb.append(strs[0]);
        
        for (int i = 1; i < strs.length; i++) {
            // 如果当前公共前缀已经为空，直接返回
            if (sb.length() == 0) {
                return "";
            }
            
            int min = Math.min(sb.length(), strs[i].length());
            
            // 从前往后比较，找到第一个不匹配的位置
            int j = 0;
            while (j < min && sb.charAt(j) == strs[i].charAt(j)) {
                j++;
            }
            
            // 截取从0到j的公共部分
            sb.setLength(j);
        }
        
        System.out.println(sb.toString());
        return sb.toString();
    }
}

class Solution14 {
    public String longestCommonPrefix(String[] strs) {
        if(strs==null||strs.length==0) return "";

        StringBuilder sb=new StringBuilder();
        //先获取第一个
        sb.append(strs[0]);//然后拿第一个字符串和后面的字符串进行比较
        for(int i=1;i<strs.length;i++){
            // 如果当前公共前缀已经为空，直接返回
            if(sb.length()==0) return "";
            
            int min=Math.min(sb.length(),strs[i].length());//获取sb和当前字符串的最小长度
            //先判断一下，如果sb的长度比min大，那么直接把多出的部分去掉
            if(sb.length()>min){
                sb.delete(min,sb.length());
            }
            //然后从前往后比较，有不一样的就删掉
            for(int j=0;j<min;j++){
                if(sb.charAt(j)!=strs[i].charAt(j)){
                    sb.delete(j,sb.length());
                    break;
                }

            }

        }
        System.out.println(sb.toString());



        return sb.toString();
    }
}
