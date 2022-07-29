package com.cuntou.贪心算法;

/**
 * @ClassName : _402_RemoveKdigits  //类名
 * @Description :   //描述
 * @Author : 村头 //作者
 * @Date: 2022/7/22  19:41
 */

public class _402_RemoveKdigits {
    //给定一个以字符串所表示的非负整数num
    //移除这个数中的K位数字,使得剩下的数字最小
    //删除一个数字的贪心策略:
    //[D0D1....Dn- 1] 从右往左找到第一个位置
    //使得这个Di < D i -1  删除 Di-1
    //Di < D i -1 如果不存在这个的话,说明顺序递增,删除最后一个
    public String removeKdigits(String num, int k) {
        StringBuilder numStr = new StringBuilder(num);
        for (int i = 0; i < k ; i++) {
            boolean hasDeleted = false;
            for (int j = 1; j < num.length() ; j++) {
                //如果前面的一个数字大于后面的数字的话就直接删除
                if (numStr.charAt(j - 1) > numStr.charAt(j)) {
                    numStr.deleteCharAt(j - 1);
                    hasDeleted = true;
                    break;
                }
            }
            if (!hasDeleted) numStr.deleteCharAt(numStr.length() - 1);
        }
        //删除前面是0的元素,如果第一个元素是0的话
        int len = numStr.length();
        while (len != 0) {
            if (numStr.charAt(0) > '0') break;
            numStr.deleteCharAt(0);
            len = numStr.length();
        }

        return numStr.length() == 0 ? "0" : numStr.toString();
    }
}
