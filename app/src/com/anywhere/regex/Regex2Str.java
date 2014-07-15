/**
 * john创建于上午9:40:42
 * 
 * 修改记录: 1. 2.
 */
package com.anywhere.regex;

import nl.flotsam.xeger.Xeger;

/**
 * @author jinyifeng5969@163.com
 * @since 2014年7月15日 上午9:40:42
 * @version v1.0.0
 */
public class Regex2Str {
    
    /**
     * @param args
     */
    public static void main(String[] args) {
        // String regex = "[ab]{4,6}c";
        String regex = "[a-z][a-z0-9]{3,6}";
        Xeger generator = new Xeger(regex);
        for (int i = 0; i < 10; i++) {
            String result = generator.generate();
            // assert result.matches(regex);
            System.out.println(result);
        }
    }
    
}
