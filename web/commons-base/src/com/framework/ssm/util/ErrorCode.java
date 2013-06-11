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
public interface ErrorCode {
    
    // ===============================================
    // common error code -1 - 99 yifeng.jin
    // ===============================================
    /** ****************************通用异常码 begin ********************* */
    /** 操作失败 */
    public static final int CODE_COMMON_FAILD = -1;
    
    /** 操作成功 */
    public static final int CODE_COMMON_SUCCESS = 0;
    
    /** 数据库访问错误 */
    public static final int CODE_DATABASE_ACCESS_ERROR = 1;
    
    /** 数据库连接失败 */
    public static final int CODE_DATABASE_CONNECTION_FAILD = 2;
    
    /** {0}访问错误 */
    public static final int CODE_COMMON_ACCESS_ERROR = 3;
    
    /** {0}连接失败 */
    public static final int CODE_COMMON_CONNECTION_FAILD = 4;
    
    /** {0}为空 */
    public static final int CODE_IS_EMPTY = 5;
    
    /** {0}不能为空 */
    public static final int CODE_FORBID_EMPTY = 6;
    
    /** {0}可以为空 */
    public static final int CODE_COULD_EMPTY = 7;
    
    /** {0}为NULL */
    public static final int CODE_IS_NULL = 8;
    
    /** {0}不能为NULL */
    public static final int CODE_FORBID_NULL = 9;
    
    /** {0}必需唯一 */
    public static final int CODE_UNIQUE = 10;
    
    /** {0}参数 */
    public static final int CODE_PARAMETER = 11;
    
    /** {0}错误 */
    public static final int CODE_ERROR = 12;
    
    /** {0}长度不够 */
    public static final int CODE_LENGTH_MIN = 13;
    
    /** {0}超长 */
    public static final int CODE_LENGTH_MAX = 14;
    
    /** {0}范围错误 */
    public static final int CODE_RANGE_ERROR = 15;
    
    /** {0}必须 */
    public static final int CODE_REQUIRED = 16;
    
    /** {0}必需为Byte类型 */
    public static final int CODE_REQUIRED_BYTE = 17;
    
    /** {0}必需为Double类型 */
    public static final int CODE_REQUIRED_DOUBLE = 18;
    
    /** {0}必需为Float类型 */
    public static final int CODE_REQUIRED_FLOAT = 19;
    
    /** {0}必需为Integer类型 */
    public static final int CODE_REQUIRED_INTEGER = 20;
    
    /** {0}必需为Long类型 */
    public static final int CODE_REQUIRED_LONG = 21;
    
    /** {0}必需为Short类型 */
    public static final int CODE_REQUIRED_SHORT = 22;
    
    /** {0}必需为Character类型 */
    public static final int CODE_REQUIRED_CHAR = 23;
    
    /** {0}必需为Boolean类型 */
    public static final int CODE_REQUIRED_BOOLEAN = 24;
    
    /** {0}格式错误 */
    public static final int CODE_FORMAT_ERROR = 25;
    
    /** 时间格式错误 */
    public static final int CODE_FORMAT_ERROR_DATETIME = 26;
    
    /** Email格式错误 */
    public static final int CODE_FORMAT_ERROR_EMAIL = 27;
    
    /** IP地址格式错误 */
    public static final int CODE_FORMAT_ERROR_IPADDRESS = 28;
    
    /** Phone格式错误 */
    public static final int CODE_FORMAT_ERROR_PHONE = 29;
    
    /** XML格式错误 */
    public static final int CODE_FORMAT_ERROR_XML = 30;
    
    /** {0}业务不支持 */
    public static final int CODE_SERVICE_UNSUPPORTED = 31;
    
    /** 开始{0}大于结束{1} */
    public static final int CODE_BEGIN_GREAT_END_PARAMETER = 32;
    
    /** 开始时间大于结束时间 */
    public static final int CODE_BEGIN_GREAT_END_DATETIME = 33;
    
    /** {0}没有权限 */
    public static final int CODE_NO_RIGHT = 34;
    
    /** {0}已存在 */
    public static final int CODE_ALREADY_EXIST = 35;
    
    /** {0}不存在或已被删除 */
    public static final int CODE_NOT_EXIST = 36;
    
    /** 对象不存在或已被删除 */
    public static final int CODE_NOT_EXIST_OBJECT = 37;
    
    /** {0}已关联 */
    public static final int CODE_ASSOCIATED = 38;
    
    /** {0}无效或不合法 */
    public static final int CODE_INVALID = 39;
    
    /** IP地址无效或不合法 */
    public static final int CODE_INVALID_IPADDRESS = 40;
    
    /** 删除 */
    public static final int CODE_DELETE = 41;
    
    /** {0}能被删除 */
    public static final int CODE_DELETE_PERMIT = 42;
    
    /** {0}不能被删除 */
    public static final int CODE_DELETE_FORBID = 43;
    
    /** {0}有效的 */
    public static final int CODE_AVAILABLE = 44;
    
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
    
    // Administrator maintenance 200 - 299 yifeng.jin
    // ===============================================
    /** ****************************管理员维护异常码 begin ********************* */
    /** {0}用户 */
    public static final int CODE_USER_TYPE = 200;
    
    /** {0}登录 */
    public static final int CODE_LOGIN_TYPE = 201;
    
    /** 默认系统管理员不能被创建 */
    public static final int CODE_DEFAULT_MANAGER_FORBID_CREATE = 202;
    
    /** 原密码 */
    public static final int CODE_PASSWORD_ORIGINAL = 203;
    
    /** ****************************管理员维护异常码 end ********************* */
    
    // ===============================================
    // Role maintenance 400 - 499 yifeng.jin
    // ===============================================
    /** ****************************角色维护异常码 begin ********************* */
    /** ****************************角色维护异常码 end ********************* */
    
    // ===============================================
    // Resource maintenance 300 - 399 yifeng.jin
    // ===============================================
    /** ****************************资源维护异常码 begin ********************* */
    /** ****************************资源维护异常码 end ********************* */
    
    /** ****************************系统业务异常码 end ********************* */
    
    // ===============================================
    // Administrator maintenance 1000 - 9999 yifeng.jin
    // ===============================================
    /** **************************业务异常码 begin *********************** */
    /** **************************业务异常码 end *********************** */
}
