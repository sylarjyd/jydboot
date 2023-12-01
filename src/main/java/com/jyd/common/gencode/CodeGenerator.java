package com.jyd.common.gencode;



/**
 * 代码生成器
 *
 * @author Chill
 */
public class CodeGenerator {

	/**
	 * 代码生成的模块名
	 */
	public static String CODE_NAME = "应用管理";
	/**
	 * 代码所在服务名
	 */
	public static String SERVICE_NAME = "jydboot";
	/**
	 * 代码生成的包名
	 */
	public static String PACKAGE_NAME = "com.jyd";
	/**
	 * 前端代码生成所属系统
	 */
	public static String SYSTEM_NAME = "sword";
	/**
	 * 前端代码生成地址
	 */
	public static String PACKAGE_WEB_DIR = "D:\\ws\\jydboot\\front\\";
	/**
	 * 需要去掉的表前缀
	 */
	public static String[] TABLE_PREFIX = {"t_"};
	/**
	 * 需要生成的表名(两者只能取其一)
	 */
	public static String[] INCLUDE_TABLES = {
			//"t_audit_log",
			"t_dict",
			"t_district",
			"t_file",
			"t_message_log",
			"t_social_account",
			"t_sys_dept",
			"t_sys_log",
			"t_sys_menu",
			"t_sys_notice",
			"t_sys_post",
			"t_sys_role",
			"t_sys_role_menu",
			"t_sys_user",
			"t_sys_user_role",
			"t_user"

	};
	/**
	 * 需要排除的表名(两者只能取其一)
	 */
	public static String[] EXCLUDE_TABLES = {};
	/**
	 * 是否包含基础业务字段
	 */
	public static Boolean HAS_SUPER_ENTITY = Boolean.FALSE;
	/**
	 * 基础业务字段
	 */
	public static String[] SUPER_ENTITY_COLUMNS = {"id", "create_time", "create_user", "update_time", "update_user", "status", "deleted"};

	/**
	 * 数据库驱动名
	 */
	private static String DRIVER_NAME = "com.mysql.cj.jdbc.Driver";
	/**
	 * 数据库链接地址
	 */
	private static String URL = "jdbc:mysql://172.16.10.243:3306/jydboot?useSSL=false&useUnicode=true&characterEncoding=utf-8&zeroDateTimeBehavior=convertToNull&transformedBitIsBoolean=true&tinyInt1isBit=false&serverTimezone=GMT%2B8&allowPublicKeyRetrieval=true";
	/**
	 * 数据库用户名
	 */
	private static String USER_NAME = "root";
	/**
	 * 数据库密码
	 */
	private static String PASS_WORD = "Whdsj@!db109";

	/**
	 * RUN THIS
	 */

	public static void main(String[] args) {
		DsjCodeGenerator generator = new DsjCodeGenerator();
		generator.setDriverName(DRIVER_NAME);
		generator.setUrl(URL);
		generator.setUsername(USER_NAME);
		generator.setPassword(PASS_WORD);
		generator.setCodeName(CODE_NAME);
		generator.setServiceName(SERVICE_NAME);
		generator.setSystemName(SYSTEM_NAME);
		generator.setPackageName(PACKAGE_NAME);
		generator.setPackageWebDir(PACKAGE_WEB_DIR);
		generator.setTablePrefix(TABLE_PREFIX);
		generator.setIncludeTables(INCLUDE_TABLES);
		generator.setExcludeTables(EXCLUDE_TABLES);
		generator.setHasSuperEntity(HAS_SUPER_ENTITY);
		generator.setSuperEntityColumns(SUPER_ENTITY_COLUMNS);
		generator.run();
	}
}
