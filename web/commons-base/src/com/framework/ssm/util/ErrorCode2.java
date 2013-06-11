package com.framework.ssm.util;

/**
 * 
 * @author jinyifeng
 * @email jinyifeng5969@163.com
 * @version create time Jul 9, 2012 4:14:26 PM
 * <ul>
 * <li>comment:异常码定义类</li>
 * <ul>
 * @param <T>
 */
public interface ErrorCode2 {
    
    // ===============================================
    // common error code -1 - 999 yifeng.jin
    // ===============================================
    /** ****************************通用异常码 begin ********************* */
    /** {}失败 */
    public static final int CODE_FAILD = 0;
    
    /** {}成功 */
    public static final int CODE_SUCCESS = 0;
    
    /** 操作 */
    public static final int CODE_OPERATE = 0;
    
    /** 数据库 */
    public static final int CODE_DATABASE = 0;
    
    /** {}访问 */
    public static final int CODE_ACCESS = 0;
    
    /** {}错误 */
    public static final int CODE_ERROR = 0;
    
    /** {}连接 */
    public static final int CODE_CONNECTION = 0;
    
    /** {}为空 */
    public static final int CODE_EMPTY = 0;
    
    /** {}不能 */
    public static final int CODE_FORBID = 0;
    
    /** {}可以 */
    public static final int CODE_COULD = 0;
    
    /** {}为null */
    public static final int CODE_NULL = 0;
    
    /** {}唯一 */
    public static final int CODE_UNIQUE = 0;
    
    /** {}参数 */
    public static final int CODE_PARAMETER = 0;
    
    /** {}长度 */
    public static final int CODE_LENGTH = 0;
    
    /** {}小于 */
    public static final int CODE_LOWER_THAN = 0;
    
    /** {}小于 */
    public static final int CODE_GREATER_THAN = 0;
    
    /** {}最小值 */
    public static final int CODE_MIN = 0;
    
    /** {}最大值 */
    public static final int CODE_MAX = 0;
    
    /** {}范围 */
    public static final int CODE_RANGE = 0;
    
    /** {} */
    public static final int CODE_REQUIRED = 0;
    
    /** {}为byte类型 */
    public static final int CODE_BY_BYTE = 0;
    
    /** {}为double类型 */
    public static final int CODE_BY_DOUBLE = 0;
    
    /** {}为float类型 */
    public static final int CODE_BY_FLOAT = 0;
    
    /** {}为integer类型 */
    public static final int CODE_BY_INTEGER = 0;
    
    /** {}为long类型 */
    public static final int CODE_BY_LONG = 0;
    
    /** {}为short类型 */
    public static final int CODE_BY_SHORT = 0;
    
    /** {}为character类型 */
    public static final int CODE_BY_CHAR = 0;
    
    /** {}为boolean类型 */
    public static final int CODE_BY_BOOLEAN = 0;
    
    /** {}格式错误 */
    public static final int CODE_FORMAT_ERROR = 0;
    
    /** 时间格式错误 */
    public static final int CODE_FORMAT_ERROR_DATETIME = 0;
    
    /** email格式错误 */
    public static final int CODE_FORMAT_ERROR_EMAIL = 0;
    
    /** ip地址格式错误 */
    public static final int CODE_FORMAT_ERROR_IPADDRESS = 0;
    
    /** phone格式错误 */
    public static final int CODE_FORMAT_ERROR_PHONE = 0;
    
    /** xml格式错误 */
    public static final int CODE_FORMAT_ERROR_XML = 0;
    
    /** {}业务不支持 */
    public static final int CODE_SERVICE_UNSUPPORTED = 0;
    
    /** 开始{}大于结束{} */
    public static final int CODE_BEGIN_GREAT_END_PARAMETER = 0;
    
    /** 开始时间大于结束时间 */
    public static final int CODE_BEGIN_GREAT_END_DATETIME = 0;
    
    /** {}没有权限 */
    public static final int CODE_NO_RIGHT = 0;
    
    /** {}已存在 */
    public static final int CODE_ALREADY_EXIST = 0;
    
    /** {}不存在或已被删除 */
    public static final int CODE_NOT_EXIST = 0;
    
    /** 对象不存在 或已被删除 */
    public static final int CODE_NOT_EXIST_OBJECT = 0;
    
    /** {}已关联 */
    public static final int CODE_ASSOCIATED = 0;
    
    /** {}无效或不合法 */
    public static final int CODE_INVALID = 0;
    
    /** ip地址无效或不合法 */
    public static final int CODE_INVALID_IPADDRESS = 0;
    
    /** 删除 */
    public static final int CODE_DELETE = 0;
    
    /** {}能被删除 */
    public static final int CODE_DELETE_PERMIT = 0;
    
    /** {}不能被删除 */
    public static final int CODE_DELETE_FORBID = 0;
    
    /** {}有效的 */
    public static final int CODE_AVAILABLE = 0;
    
    /** ****************************通用异常码 end ********************* */
    
    // ===============================================
    // common error code 100 - 199 yifeng.jin
    // ===============================================
    /** ****************************通用异常码 begin ********************* */
    
    /** ****************************通用异常码 end ********************* */
    
    // ===============================================
    // system business error code 200 - 999 yifeng.jin
    // 包括用户、角色、资源和它们之间的关联关系
    // ===============================================
    // ===============================================
    /** ****************************系统业务异常码 begin ********************* */
    
    // administrator maintenance 200 - 299 yifeng.jin
    // ===============================================
    /** ****************************管理员维护异常码 begin ********************* */
    /** {}用户 */
    public static final int CODE_USER_TYPE = 0;
    
    /** {}登录 */
    public static final int CODE_LOGIN_TYPE = 0;
    
    /** 默认系统管理员不能被创建 */
    public static final int CODE_DEFAULT_MANAGER_FORBID_CREATE = 0;
    
    /** 原密码 */
    public static final int CODE_PASSWORD_ORIGINAL = 0;
    
    /** ****************************管理员维护异常码 end ********************* */
    
}