package com.yzj.seal.ibank.utils;

import java.util.Date;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.apache.log4j.Logger;

public class Worn_xiaoConstant {

	Logger logger = Logger.getLogger(Worn_xiaoConstant.class);
	/**
	 * 系统sid的长度
	 */
	public static final Worn_xiaoConstant SIDLENGTH = new Worn_xiaoConstant("32");

	/**
	 * 报文头流水号 长度
	 */
	public static final Worn_xiaoConstant LINELENGTH = new Worn_xiaoConstant("10");

	/**
	 * 统一用户管理平台服务编码集合 12003000035 增量账户 机构 角色 12002000041 验证token有效性
	 */
	public static final Worn_xiaoConstant SERVER = new Worn_xiaoConstant("12003000035");
	/**
	 * 统一用户管理平台服务编码集合 12003000035 增量账户 机构 角色 12002000041 验证token有效性
	 */
	public static final Worn_xiaoConstant SERVERONE = new Worn_xiaoConstant("12002000041");
	/**
	 * 统一用户管理平台服务编码集合 12003000035 增量账户 机构 角色 12002000041 验证token有效性 12002000042
	 * 获取用户信息
	 */
	public static final Worn_xiaoConstant GETUSER = new Worn_xiaoConstant("12002000042");
	/**
	 * 核心系统服务平台编码集 账户查询接口 07
	 */
	public static final Worn_xiaoConstant GETACC = new Worn_xiaoConstant("12003000004");

	/***
	 * 核心系统印鉴关联服务 01核心系统账户印鉴关联检查
	 */
	public static final Worn_xiaoConstant ACCCON = new Worn_xiaoConstant("12002000055");

	/**
	 * 对接统一用户管理平台的接口场景编码集合 01 获取用户信息 02 验证token有效性 03 增量账户 04 增量机构 05 增量角色
	 */
	public static final Worn_xiaoConstant SCENEGETU = new Worn_xiaoConstant("01");

	/**
	 * 对接统一用户管理平台的接口场景编码集合 01 获取用户信息 02 验证token有效性 03 增量账户 04 增量机构 05 增量角色
	 */
	public static final Worn_xiaoConstant SCENETOCKEN = new Worn_xiaoConstant("02");

	/**
	 * 对接统一用户管理平台的接口场景编码集合 01 获取用户信息 02 验证token有效性 03 增量账户 04 增量机构 05 增量角色
	 */
	public static final Worn_xiaoConstant SCENETHREE = new Worn_xiaoConstant("03");

	/**
	 * 对接统一用户管理平台的接口场景编码集合 01 获取用户信息 02 验证token有效性 03 增量账户 04 增量机构 05 增量角色
	 */
	public static final Worn_xiaoConstant SCENEFOUR = new Worn_xiaoConstant("04");

	/**
	 * 对接统一用户管理平台的接口场景编码集合 01 获取用户信息 02 验证token有效性 03 增量账户 04 增量机构 05 增量角色
	 */
	public static final Worn_xiaoConstant SCENEFIVE = new Worn_xiaoConstant("05");

	/**
	 * 对接核心系统的账户查询服务
	 */
	public static final Worn_xiaoConstant SCENESIX = new Worn_xiaoConstant("07");

	/**
	 * 电子验印系统编码 105020
	 */
	public static final Worn_xiaoConstant SYSCODE = new Worn_xiaoConstant("105020");
	/**
	 * 电子验应系统简称 SISBASE
	 */
	public static final Worn_xiaoConstant SYSREV = new Worn_xiaoConstant("SISBASE");

	/**
	 * 电子验应系统 系统简码 SI
	 */
	public static final Worn_xiaoConstant SYSREC = new Worn_xiaoConstant("SI");
	/**
	 * 报文主体
	 */
	public static final Worn_xiaoConstant msgBoy = new Worn_xiaoConstant("BODY");
	/**
	 * 默认登录自动解锁的时间
	 */
	public static final Worn_xiaoConstant AutoTime = new Worn_xiaoConstant("30");
	/**
	 * ESB报文头规范 长度
	 */
	public static final Worn_xiaoConstant MsgHeader = new Worn_xiaoConstant("8");
	/**
	 * 增量账户信息接口
	 */
	public static final Worn_xiaoConstant ACCOUNT = new Worn_xiaoConstant("serviceAccount");
	/**
	 * 增量机构接口
	 */
	public static final Worn_xiaoConstant ORG = new Worn_xiaoConstant("serviceOrg");
	/**
	 * 增量角色接口
	 */
	public static final Worn_xiaoConstant ROLE = new Worn_xiaoConstant("serviceRole");
	/**
	 * 统一用户管理系统登录验证
	 */
	public static final Worn_xiaoConstant LOGINCHECK = new Worn_xiaoConstant("serviceAccLoginCheck");
	/**
	 * 获取用户信息
	 */
	public static final Worn_xiaoConstant GETUSERS = new Worn_xiaoConstant("serviceGetUsers");
	/**
	 * 获取账户信息
	 */
	public static final Worn_xiaoConstant GETACCN = new Worn_xiaoConstant("serviceGetAccount");

	/**
	 * 印鉴关联接口
	 */
	public static final Worn_xiaoConstant SEALCONTRACT = new Worn_xiaoConstant("serviceSealContract");
	/**
	 * 校验tocken
	 */
	public static final Worn_xiaoConstant CHECKTOCKEN = new Worn_xiaoConstant("serviceCheckToken");

	private String code;

	/**
	 * 目标接收者
	 */
	public static Map<String, Object> senderMap = new ConcurrentHashMap<String, Object>();
	/**
	 * 响应解析者
	 */
	public static Map<String, Object> recivMap = new ConcurrentHashMap<String, Object>();
	/**
	 * 缓存控制标识
	 */
	public static Map<String, Object> redisMap = new ConcurrentHashMap<String, Object>();

	/**
	 * 统一用户管理 账户获取动态时间参数类型码
	 */
	public static final Worn_xiaoConstant ACCOUNTCODE = new Worn_xiaoConstant("10000001");
	/**
	 * 统一账户管理 机构获取动态时间参数类型码
	 */
	public static final Worn_xiaoConstant ORGCODE = new Worn_xiaoConstant("10000002");
	/**
	 * 统一角色管理 角色获取动态时间参数类型码
	 */
	public static final Worn_xiaoConstant ROLECODE = new Worn_xiaoConstant("10000003");
	/**
	 * 行方给的统一时间字段
	 */
	public static final Worn_xiaoConstant TIMEFILED = new Worn_xiaoConstant("NxtIntfTfrStrtTm");
	/**
	 * 同步账户名称
	 */
	public static final Worn_xiaoConstant ACCOUNTNAME = new Worn_xiaoConstant("同步账户时间");
	/**
	 * 同步机构名称
	 */
	public static final Worn_xiaoConstant ORGNAME = new Worn_xiaoConstant("同步机构时间");
	/**
	 * 同步角色名称
	 */

	public static final Worn_xiaoConstant ROLENANE = new Worn_xiaoConstant("同步角色时间");
	/**
	 * 验证token有效性 成功码
	 */
	public static final Worn_xiaoConstant CTOCKENSUCCESS = new Worn_xiaoConstant("000000");

	/**
	 * 指定token获取用户属性的字段
	 */
	public static final Worn_xiaoConstant getUserAttr = new Worn_xiaoConstant("uid");

	/**
	 * 单点登录时候的tokenId约定
	 */
	public static final Worn_xiaoConstant TOCKENID = new Worn_xiaoConstant("SsoTkId");

	public static final Worn_xiaoConstant StaticMap = new Worn_xiaoConstant("CacheMap.xml");

	public Worn_xiaoConstant(String param) {
		this.code = param;
	}

	public Worn_xiaoConstant() {
		senderMap = MsgTranslateUtils.getInstance().getCacheMap("senderMap");
		recivMap = MsgTranslateUtils.getInstance().getCacheMap("recivMap");
		redisMap = MsgTranslateUtils.getInstance().getCacheMap("redisMap");
		logger.info("senderMap " + senderMap.toString());
		logger.info("recivMap  " + recivMap.toString());
		logger.info("redisMap  " + redisMap.toString());
	}

	public String getCode() {
		return code;
	}
}
