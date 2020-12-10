package com.dvt.snjs.app;

import java.util.ArrayList;
import java.util.List;

import com.dvt.snjs.dubbo.model.*;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.dvt.snjs.dubbo.service.DubboJsMx;
import com.dvt.snjs.service.CommonService;
import com.dvt.snjs.service.GxjsService;
import com.dvt.snjs.service.NbclService;
import com.dvt.snjs.service.TdxxService;
import com.dvt.snjs.service.YsxxService;
import com.dvt.snjs.service.YwxxService;
import com.dvt.snjs.util.JscppUtil;

public class DataTask {

	private static Log log = LogFactory.getLog(DataTask.class);

	private static long SLEEP_TIME = 30 * 60 * 1000;

	public static Runnable r_jkxx = () -> {

		DubboJsMx dubboJsMx = JscppUtil.getBean("dubboJsMx", DubboJsMx.class);
		CommonService commonService = JscppUtil.getBean("commonService", CommonService.class);
		while (true) {
			try {
				List<SnjsJkxxb> result = dubboJsMx.getSnjsJkxxb(Main.sfdm);
				if (result != null && !result.isEmpty()) {
					log.info("jkxx size = " + result.size());
					commonService.doSaveSnjsJkxx(result);
					// 更新服务器数据状态
					dubboJsMx.doUpdateSnjsJkxxb(result);
				} else {
					log.info("jkxx complete");
					try {
						Thread.sleep(10 * 60 * 1000);
					} catch (Exception e) {

					}
				}
			} catch (Throwable t) {
				log.error(t.getMessage(), t);
				try {
					Thread.sleep(SLEEP_TIME);
				} catch (Exception e) {

				}
			}
		}
	};

	/**
	 * 包裹快递-投递信息
	 */
	public static Runnable r_tdfy = () -> {

		DubboJsMx dubboJsMx = JscppUtil.getBean("dubboJsMx", DubboJsMx.class);
		TdxxService tdxxService = JscppUtil.getBean("tdxxService", TdxxService.class);
		while (true) {
			try {
				List<JsTdxxDay> result = dubboJsMx.getTdxx(Main.sfdm);
				if (result != null && !result.isEmpty()) {
					log.info("tdfy size = " + result.size());
					tdxxService.doSaveTdxx(result);
					// 服务端删除数据
					List<JsTdxxDay> backlist = new ArrayList<JsTdxxDay>();
					JsTdxxDay tmp = null;
					for (JsTdxxDay o : result) {
						tmp = new JsTdxxDay();
						tmp.setYjtm(o.getYjtm());
						tmp.setTdjgs(o.getTdjgs());
						tmp.setTdjdm(o.getTdjdm());
						tmp.setTdrq(o.getTdrq());
						tmp.setSyf(o.getSyf());
						backlist.add(tmp);
					}
					dubboJsMx.doDeleteTdxx(Main.sfdm, backlist);
					backlist.clear();
					result.clear();
				} else {
					log.info("tdfy complete");
					try {
						Thread.sleep(SLEEP_TIME);
					} catch (Exception e) {

					}
				}
			} catch (Throwable t) {
				log.error(t.getMessage(), t);
				try {
					Thread.sleep(SLEEP_TIME);
				} catch (Exception e) {

				}
			}
		}
	};

	/**
	 * 包裹快递-陆运
	 */
	public static Runnable r_lyfy = () -> {

		DubboJsMx dubboJsMx = JscppUtil.getBean("dubboJsMx", DubboJsMx.class);
		YsxxService ysxxService = JscppUtil.getBean("ysxxService", YsxxService.class);
		while (true) {
			try {
				List<JsYsxxDay> result = dubboJsMx.getYsxx(Main.sfdm);
				if (result != null && !result.isEmpty()) {
					log.info("lyfy size = " + result.size());
					ysxxService.doSaveYsxx(result);
					// 服务端删除数据
					List<JsYsxxDay> backlist = new ArrayList<JsYsxxDay>();
					JsYsxxDay tmp = null;
					for (JsYsxxDay o : result) {
						tmp = new JsYsxxDay();
						tmp.setYjtm(o.getYjtm());
						tmp.setBcf(o.getBcf());
						tmp.setYldm(o.getYldm());
						tmp.setJsrq(o.getJsrq());
						tmp.setPyj(o.getPyj());
						tmp.setFcz(o.getFcz());
						backlist.add(tmp);
					}
					dubboJsMx.doDeleteYsxx(Main.sfdm, backlist);
					backlist.clear();
					result.clear();
				} else {
					log.info("lyfy complete");
					try {
						Thread.sleep(SLEEP_TIME);
					} catch (Exception e) {

					}
				}
			} catch (Throwable t) {
				log.error(t.getMessage(), t);
				try {
					Thread.sleep(SLEEP_TIME);
				} catch (Exception e) {
				}
			}
		}
	};

	/**
	 * 包裹快递-航空
	 */
	public static Runnable r_hkfy = () -> {

		DubboJsMx dubboJsMx = JscppUtil.getBean("dubboJsMx", DubboJsMx.class);
		YsxxService ysxxService = JscppUtil.getBean("ysxxService", YsxxService.class);
		while (true) {
			try {
				List<JsYsxxHkfyDay> result = dubboJsMx.getHkxx(Main.sfdm);
				if (result != null && !result.isEmpty()) {
					log.info("hkfy size = " + result.size());
					ysxxService.doSaveHkfy(result);
					// 服务端删除数据
					List<JsYsxxHkfyDay> backlist = new ArrayList<JsYsxxHkfyDay>();
					JsYsxxHkfyDay tmp = null;
					for (JsYsxxHkfyDay o : result) {
						tmp = new JsYsxxHkfyDay();
						tmp.setYjtm(o.getYjtm());
						tmp.setYldm(o.getYldm());
						tmp.setBcf(o.getBcf());
						tmp.setFcz(o.getFcz());
						tmp.setJsrq(o.getJsrq());
						tmp.setPyj(o.getPyj());
						backlist.add(tmp);
					}
					dubboJsMx.doDeleteHkxx(Main.sfdm, backlist);
					backlist.clear();
					result.clear();
				} else {
					log.info("hkfy complete");
					try {
						Thread.sleep(SLEEP_TIME);
					} catch (Exception e) {

					}
				}
			} catch (Throwable t) {
				log.error(t.getMessage(), t);
				try {
					Thread.sleep(SLEEP_TIME);
				} catch (Exception e) {
				}
			}
		}
	};

	/**
	 * 包裹快递-省际经转
	 */
	public static Runnable r_ksjz = () -> {

		DubboJsMx dubboJsMx = JscppUtil.getBean("dubboJsMx", DubboJsMx.class);
		NbclService nbclService = JscppUtil.getBean("nbclService", NbclService.class);
		while (true) {
			try {
				List<JsNbclYjxxDay> result = dubboJsMx.getKsjz(Main.sfdm);
				if (result != null && !result.isEmpty()) {
					log.info("ksjz size = " + result.size());
					nbclService.doSaveKsjz(result);
					// 服务端删除数据
					List<JsNbclYjxxDay> backlist = new ArrayList<JsNbclYjxxDay>();
					JsNbclYjxxDay tmp = null;
					for (JsNbclYjxxDay o : result) {
						tmp = new JsNbclYjxxDay();
						tmp.setYjtm(o.getYjtm());
						tmp.setCljgs(o.getCljgs());
						tmp.setCljds(o.getCljds());
						tmp.setSyf(o.getSyf());
						tmp.setJsrq(o.getJsrq());
						backlist.add(tmp);
					}
					dubboJsMx.doDeleteKsjz(Main.sfdm, backlist);
					backlist.clear();
					result.clear();
				} else {
					log.info("ksjz complete");
					try {
						Thread.sleep(SLEEP_TIME);
					} catch (Exception e) {

					}
				}
			} catch (Throwable t) {
				log.error(t.getMessage(), t);
				try {
					Thread.sleep(SLEEP_TIME);
				} catch (Exception e) {
				}
			}
		}
	};

	/**
	 * 包裹快递-出口省内部处理
	 */
	public static Runnable r_ckfy = () -> {

		DubboJsMx dubboJsMx = JscppUtil.getBean("dubboJsMx", DubboJsMx.class);
		NbclService nbclService = JscppUtil.getBean("nbclService", NbclService.class);
		while (true) {
			try {
				List<JsNbclCkfyDay> result = dubboJsMx.getCkfy(Main.sfdm);
				if (result != null && !result.isEmpty()) {
					log.info("ckfy size = " + result.size());
					nbclService.doSaveCkfy(result);
					// 服务端删除数据
					List<JsNbclCkfyDay> backlist = new ArrayList<JsNbclCkfyDay>();
					JsNbclCkfyDay tmp = null;
					for (JsNbclCkfyDay o : result) {
						tmp = new JsNbclCkfyDay();
						tmp.setYjtm(o.getYjtm());
						tmp.setCljgs(o.getCljgs());
						tmp.setCljds(o.getCljds());
						tmp.setSyf(o.getSyf());
						tmp.setJsrq(o.getJsrq());
						backlist.add(tmp);
					}
					dubboJsMx.doDeleteCkfy(Main.sfdm, backlist);
					backlist.clear();
					result.clear();
				} else {
					log.info("ckfy complete");
					try {
						Thread.sleep(SLEEP_TIME);
					} catch (Exception e) {

					}
				}
			} catch (Throwable t) {
				log.error(t.getMessage(), t);
				try {
					Thread.sleep(SLEEP_TIME);
				} catch (Exception e) {
				}
			}
		}
	};

	/**
	 * 包裹快递-进口省内部处理
	 */
	public static Runnable r_jkfy = () -> {

		DubboJsMx dubboJsMx = JscppUtil.getBean("dubboJsMx", DubboJsMx.class);
		NbclService nbclService = JscppUtil.getBean("nbclService", NbclService.class);
		while (true) {
			try {
				List<JsNbclJkfyDay> result = dubboJsMx.getJkfy(Main.sfdm);
				if (result != null && !result.isEmpty()) {
					log.info("jkfy size = " + result.size());
					nbclService.doSaveJkfy(result);
					// 服务端删除数据
					List<JsNbclJkfyDay> backlist = new ArrayList<JsNbclJkfyDay>();
					JsNbclJkfyDay tmp = null;
					for (JsNbclJkfyDay o : result) {
						tmp = new JsNbclJkfyDay();
						tmp.setYjtm(o.getYjtm());
						tmp.setCljgs(o.getCljgs());
						tmp.setCljds(o.getCljds());
						tmp.setSyf(o.getSyf());
						tmp.setJsrq(o.getJsrq());
						backlist.add(tmp);
					}
					dubboJsMx.doDeleteJkfy(Main.sfdm, backlist);
					backlist.clear();
					result.clear();
				} else {
					log.info("jkfy complete");
					try {
						Thread.sleep(SLEEP_TIME);
					} catch (Exception e) {

					}
				}
			} catch (Throwable t) {
				log.error(t.getMessage(), t);
				try {
					Thread.sleep(SLEEP_TIME);
				} catch (Exception e) {
				}
			}
		}
	};

	/**
	 * 一干陆运普服明细
	 */
	public static Runnable r_tzbjs_ly = () -> {

		DubboJsMx dubboJsMx = JscppUtil.getBean("dubboJsMx", DubboJsMx.class);
		GxjsService gxjsService = JscppUtil.getBean("gxjsService", GxjsService.class);
		while (true) {
			try {
				List<Tzbjsbly> result = dubboJsMx.getTzbjsbly(Main.sfdm);
				if (result != null && !result.isEmpty()) {
					log.info("pfysxx_ly size = " + result.size());
					gxjsService.doSaveTzbjsly(result);
					// 服务端删除数据
					List<Tzbjsbly> backlist = new ArrayList<Tzbjsbly>();
					Tzbjsbly tmp = null;
					for (Tzbjsbly o : result) {
						tmp = new Tzbjsbly();
						tmp.setYjtm(o.getYjtm());
						tmp.setYldm(o.getYldm());
						tmp.setJsrq(o.getJsrq());
						tmp.setPyj(o.getPyj());
						tmp.setFcz(o.getFcz());
						tmp.setBcf(o.getBcf());
						backlist.add(tmp);
					}
					dubboJsMx.doDeleteTzbjsbly(Main.sfdm, backlist);
					backlist.clear();
					result.clear();
				} else {
					log.info("pfysxx_ly complete");
					try {
						Thread.sleep(SLEEP_TIME);
					} catch (Exception e) {

					}
				}
			} catch (Throwable t) {
				log.error(t.getMessage(), t);
				try {
					Thread.sleep(SLEEP_TIME);
				} catch (Exception e) {
				}
			}
		}
	};
	
	/**
	 * 一干陆运普服明细
	 */
	public static Runnable r_tzbjs_hk = () -> {

		DubboJsMx dubboJsMx = JscppUtil.getBean("dubboJsMx", DubboJsMx.class);
		GxjsService gxjsService = JscppUtil.getBean("gxjsService", GxjsService.class);
		while (true) {
			try {
				List<Tzbjsbhk> result = dubboJsMx.getTzbjsbhk(Main.sfdm);
				if (result != null && !result.isEmpty()) {
					log.info("pfysxx_hk size = " + result.size());
					gxjsService.doSaveTzbjshk(result);
					// 服务端删除数据
					List<Tzbjsbhk> backlist = new ArrayList<Tzbjsbhk>();
					Tzbjsbhk tmp = null;
					for (Tzbjsbhk o : result) {
						tmp = new Tzbjsbhk();
						tmp.setYjtm(o.getYjtm());
						tmp.setYldm(o.getYldm());
						tmp.setJsrq(o.getJsrq());
						tmp.setPyj(o.getPyj());
						tmp.setFcz(o.getFcz());
						tmp.setBcf(o.getBcf());
						backlist.add(tmp);
					}
					dubboJsMx.doDeleteTzbjsbhk(Main.sfdm, backlist);
					backlist.clear();
					result.clear();
				} else {
					log.info("pfysxx_hk complete");
					try {
						Thread.sleep(SLEEP_TIME);
					} catch (Exception e) {

					}
				}
			} catch (Throwable t) {
				log.error(t.getMessage(), t);
				try {
					Thread.sleep(SLEEP_TIME);
				} catch (Exception e) {
				}
			}
		}
	};
	
	

	/**
	 * 省际终端费-进出口
	 */
	public static Runnable r_zdjsgjyj = () -> {

		DubboJsMx dubboJsMx = JscppUtil.getBean("dubboJsMx", DubboJsMx.class);
		GxjsService gxjsService = JscppUtil.getBean("gxjsService", GxjsService.class);
		while (true) {
			try {
				List<ZdjsGjyjxxDay> result = dubboJsMx.getZdjsGjyj(Main.sfdm);
				if (result != null && !result.isEmpty()) {
					log.info("zdjs gjyj size = " + result.size());
					gxjsService.doSaveZdjsGjyj(result);
					// 服务端删除数据
					List<ZdjsGjyjxxDay> backlist = new ArrayList<ZdjsGjyjxxDay>();
					ZdjsGjyjxxDay tmp = null;
					for (ZdjsGjyjxxDay o : result) {
						tmp = new ZdjsGjyjxxDay();
						tmp.setYjtm(o.getYjtm());
						tmp.setSjjdm(o.getSjjdm());
						tmp.setJsrq(o.getJsrq());
						backlist.add(tmp);
					}
					dubboJsMx.doDeleteZdjsGjyj(Main.sfdm, backlist);
					backlist.clear();
					result.clear();
				} else {
					log.info("zdjs gjyj complete");
					try {
						Thread.sleep(SLEEP_TIME);
					} catch (Exception e) {

					}
				}
			} catch (Throwable t) {
				log.error(t.getMessage(), t);
				try {
					Thread.sleep(SLEEP_TIME);
				} catch (Exception e) {
				}
			}
		}
	};

	/**
	 * 省际终端费-跨省经转
	 */
	public static Runnable r_zdjsksjz = () -> {

		DubboJsMx dubboJsMx = JscppUtil.getBean("dubboJsMx", DubboJsMx.class);
		GxjsService gxjsService = JscppUtil.getBean("gxjsService", GxjsService.class);
		while (true) {
			try {
				List<ZdjsGjyjxxKsjzDay> result = dubboJsMx.getZdjsKsjz(Main.sfdm);
				if (result != null && !result.isEmpty()) {
					log.info("zdjs ksjz size = " + result.size());
					gxjsService.doSaveZdjsKsjz(result);
					// 服务端删除数据
					List<ZdjsGjyjxxKsjzDay> backlist = new ArrayList<ZdjsGjyjxxKsjzDay>();
					ZdjsGjyjxxKsjzDay tmp = null;
					for (ZdjsGjyjxxKsjzDay o : result) {
						tmp = new ZdjsGjyjxxKsjzDay();
						tmp.setYjtm(o.getYjtm());
						tmp.setSjjdm(o.getSjjdm());
						tmp.setJsrq(o.getJsrq());
						backlist.add(tmp);
					}
					dubboJsMx.doDeleteZdjsKsjz(Main.sfdm, backlist);
					backlist.clear();
					result.clear();
				} else {
					log.info("zdjs ksjz complete");
					try {
						Thread.sleep(SLEEP_TIME);
					} catch (Exception e) {

					}
				}
			} catch (Throwable t) {
				log.error(t.getMessage(), t);
				try {
					Thread.sleep(SLEEP_TIME);
				} catch (Exception e) {
				}
			}
		}
	};

	/**
	 * 省际终端费-省际转运
	 */
	public static Runnable r_zdjssjzy = () -> {

		DubboJsMx dubboJsMx = JscppUtil.getBean("dubboJsMx", DubboJsMx.class);
		GxjsService gxjsService = JscppUtil.getBean("gxjsService", GxjsService.class);
		while (true) {
			try {
				List<ZdjsSjzyDay> result = dubboJsMx.getZdjsSjzy(Main.sfdm);
				if (result != null && !result.isEmpty()) {
					log.info("zdjs sjzy size = " + result.size());
					gxjsService.doSaveZdjsSjzy(result);
					// 服务端删除数据
					List<ZdjsSjzyDay> backlist = new ArrayList<ZdjsSjzyDay>();
					ZdjsSjzyDay tmp = null;
					for (ZdjsSjzyDay o : result) {
						tmp = new ZdjsSjzyDay();
						tmp.setFdid(o.getFdid());
						tmp.setZbid(o.getZbid());
						tmp.setJsrq(o.getJsrq());
						backlist.add(tmp);
					}
					dubboJsMx.doDeleteZdjsSjzy(Main.sfdm, backlist);
					backlist.clear();
					result.clear();
				} else {
					log.info("zdjs sjzy complete");
					try {
						Thread.sleep(SLEEP_TIME);
					} catch (Exception e) {

					}
				}
			} catch (Throwable t) {
				log.error(t.getMessage(), t);
				try {
					Thread.sleep(SLEEP_TIME);
				} catch (Exception e) {
				}
			}
		}
	};

	/**
	 * 省际终端平常邮件
	 */
	public static Runnable r_zdjspcyj = () -> {

		DubboJsMx dubboJsMx = JscppUtil.getBean("dubboJsMx", DubboJsMx.class);
		GxjsService gxjsService = JscppUtil.getBean("gxjsService", GxjsService.class);
		while (true) {
			try {
				List<ZdjsPcyjxxDay> result = dubboJsMx.getZdjsPcyj(Main.sfdm);
				if (result != null && !result.isEmpty()) {
					log.info("zdjs pcyj size = " + result.size());
					gxjsService.doSaveZdjsPcyj(result);
					// 服务端删除数据
					List<ZdjsPcyjxxDay> backlist = new ArrayList<ZdjsPcyjxxDay>();
					ZdjsPcyjxxDay tmp = null;
					for (ZdjsPcyjxxDay o : result) {
						tmp = new ZdjsPcyjxxDay();
						tmp.setFdid(o.getFdid());
						tmp.setZbid(o.getZbid());
						tmp.setJsrq(o.getJsrq());
						backlist.add(tmp);
					}
					dubboJsMx.doDeleteZdjsPcyj(Main.sfdm, backlist);
					backlist.clear();
					result.clear();
				} else {
					log.info("zdjs pcyj complete");
					try {
						Thread.sleep(SLEEP_TIME);
					} catch (Exception e) {

					}
				}
			} catch (Throwable t) {
				log.error(t.getMessage(), t);
				try {
					Thread.sleep(SLEEP_TIME);
				} catch (Exception e) {
				}
			}
		}
	};

	public static Runnable r_qfdztb = () -> {

		DubboJsMx dubboJsMx = JscppUtil.getBean("dubboJsMx", DubboJsMx.class);
		YwxxService ywxxService = JscppUtil.getBean("ywxxService", YwxxService.class);
		while (true) {
			try {
				List<Qfdztb> result = dubboJsMx.getQfdztb(Main.sfdm);
				if (result != null && !result.isEmpty()) {
					log.info("qfdztb size = " + result.size());
					ywxxService.doSaveFd(result);
					// 服务端删除数据
					List<Qfdztb> backlist = new ArrayList<Qfdztb>();
					Qfdztb tmp = null;
					for (Qfdztb o : result) {
						tmp = new Qfdztb();
						tmp.setFdid(o.getFdid());
						tmp.setJkrq(o.getJkrq());
						backlist.add(tmp);
					}
					dubboJsMx.doDeleteQfdztb(Main.sfdm, backlist);
					backlist.clear();
					result.clear();
				} else {
					log.info("qfdztb complete");
					try {
						Thread.sleep(SLEEP_TIME);
					} catch (Exception e) {

					}
				}
			} catch (Throwable t) {
				log.error(t.getMessage(), t);
				try {
					Thread.sleep(SLEEP_TIME);
				} catch (Exception e) {
				}
			}
		}
	};

	public static Runnable r_qzbxxb = () -> {

		DubboJsMx dubboJsMx = JscppUtil.getBean("dubboJsMx", DubboJsMx.class);
		YwxxService ywxxService = JscppUtil.getBean("ywxxService", YwxxService.class);
		while (true) {
			try {
				List<Qzbxxb> result = dubboJsMx.getQzbxxb(Main.sfdm);
				if (result != null && !result.isEmpty()) {
					log.info("Qzbxxb size = " + result.size());
					ywxxService.doSaveZb(result);
					// 服务端删除数据
					List<Qzbxxb> backlist = new ArrayList<Qzbxxb>();
					Qzbxxb tmp = null;
					for (Qzbxxb o : result) {
						tmp = new Qzbxxb();
						tmp.setFdid(o.getFdid());
						tmp.setZbid(o.getZbid());
						tmp.setFfrq(o.getFfrq());
						backlist.add(tmp);
					}
					dubboJsMx.doDeleteQzbxxb(Main.sfdm, backlist);
					backlist.clear();
					result.clear();
				} else {
					log.info("Qzbxxb complete");
					try {
						Thread.sleep(SLEEP_TIME);
					} catch (Exception e) {

					}
				}
			} catch (Throwable t) {
				log.error(t.getMessage(), t);
				try {
					Thread.sleep(SLEEP_TIME);
				} catch (Exception e) {
				}
			}
		}
	};

	public static Runnable r_qqdxxb = () -> {

		DubboJsMx dubboJsMx = JscppUtil.getBean("dubboJsMx", DubboJsMx.class);
		YwxxService ywxxService = JscppUtil.getBean("ywxxService", YwxxService.class);
		while (true) {
			try {
				List<Qqdxxb> result = dubboJsMx.getQqdxxb(Main.sfdm);
				if (result != null && !result.isEmpty()) {
					log.info("Qqdxxb size = " + result.size());
					ywxxService.doSaveQd(result);
					// 服务端删除数据
					List<Qqdxxb> backlist = new ArrayList<Qqdxxb>();
					Qqdxxb tmp = null;
					for (Qqdxxb o : result) {
						tmp = new Qqdxxb();
						tmp.setQdid(o.getQdid());
						tmp.setFfrq(o.getFfrq());
						backlist.add(tmp);
					}
					dubboJsMx.doDeleteQqdxxb(Main.sfdm, backlist);
					backlist.clear();
					result.clear();
				} else {
					log.info("Qqdxxb complete");
					try {
						Thread.sleep(SLEEP_TIME);
					} catch (Exception e) {

					}
				}
			} catch (Throwable t) {
				log.error(t.getMessage(), t);
				try {
					Thread.sleep(SLEEP_TIME);
				} catch (Exception e) {
				}
			}
		}
	};

	public static Runnable r_qyjxxb = () -> {

		DubboJsMx dubboJsMx = JscppUtil.getBean("dubboJsMx", DubboJsMx.class);
		YwxxService ywxxService = JscppUtil.getBean("ywxxService", YwxxService.class);
		while (true) {
			try {
				List<Qyjxxb> result = dubboJsMx.getQyjxxb(Main.sfdm);
				if (result != null && !result.isEmpty()) {
					log.info("Qyjxxb size = " + result.size());
					ywxxService.doSaveYj(result);
					// 服务端删除数据
					List<Qyjxxb> backlist = new ArrayList<Qyjxxb>();
					Qyjxxb tmp = null;
					for (Qyjxxb o : result) {
						tmp = new Qyjxxb();
						tmp.setQdid(o.getQdid());
						tmp.setYjtm(o.getYjtm());
						tmp.setScsj(o.getScsj());
						backlist.add(tmp);
					}
					dubboJsMx.doDeleteQyjxxb(Main.sfdm, backlist);
					backlist.clear();
					result.clear();
				} else {
					log.info("Qyjxxb complete");
					try {
						Thread.sleep(SLEEP_TIME);
					} catch (Exception e) {

					}
				}
			} catch (Throwable t) {
				log.error(t.getMessage(), t);
				try {
					Thread.sleep(SLEEP_TIME);
				} catch (Exception e) {
				}
			}
		}
	};

	public static Runnable r_qyjjbxxb = () -> {

		DubboJsMx dubboJsMx = JscppUtil.getBean("dubboJsMx", DubboJsMx.class);
		YwxxService ywxxService = JscppUtil.getBean("ywxxService", YwxxService.class);
		while (true) {
			try {
				List<Qyjjbxxb> result = dubboJsMx.getQyjjbxxb(Main.sfdm);
				if (result != null && !result.isEmpty()) {
					log.info("Qyjjbxxb size = " + result.size());
					ywxxService.doSaveSj(result);
					// 服务端删除数据
					List<Qyjjbxxb> backlist = new ArrayList<Qyjjbxxb>();
					Qyjjbxxb tmp = null;
					for (Qyjjbxxb o : result) {
						tmp = new Qyjjbxxb();
						tmp.setYjtm(o.getYjtm());
						tmp.setSjjdm(o.getSjjdm());
						tmp.setSjrq(o.getSjrq());
						tmp.setYjbz(o.getYjbz());
						backlist.add(tmp);
					}
					dubboJsMx.doDeleteQyjjbxxb(Main.sfdm, backlist);
					backlist.clear();
					result.clear();
				} else {
					log.info("Qyjjbxxb complete");
					try {
						Thread.sleep(SLEEP_TIME);
					} catch (Exception e) {

					}
				}
			} catch (Throwable t) {
				log.error(t.getMessage(), t);
				try {
					Thread.sleep(SLEEP_TIME);
				} catch (Exception e) {
				}
			}
		}
	};

	public static Runnable r_gdtdxx = () -> {

		DubboJsMx dubboJsMx = JscppUtil.getBean("dubboJsMx", DubboJsMx.class);
		YwxxService ywxxService = JscppUtil.getBean("ywxxService", YwxxService.class);
		while (true) {
			try {
				List<GdTdxxb> result = dubboJsMx.getGdTdxxb(Main.sfdm);
				if (result != null && !result.isEmpty()) {
					log.info("GdTdxxb size = " + result.size());
					ywxxService.doSaveGdtd(result);
					// 服务端删除数据
					List<GdTdxxb> backlist = new ArrayList<GdTdxxb>();
					GdTdxxb tmp = null;
					for (GdTdxxb o : result) {
						tmp = new GdTdxxb();
						tmp.setYjtm(o.getYjtm());
						tmp.setTdjdm(o.getTdjdm());
						tmp.setSftt(o.getSftt());
						tmp.setTdrq(o.getTdrq());
						backlist.add(tmp);
					}
					dubboJsMx.doDeleteGdTdxxb(Main.sfdm, backlist);
					backlist.clear();
					result.clear();
				} else {
					log.info("GdTdxxb complete");
					try {
						Thread.sleep(SLEEP_TIME);
					} catch (Exception e) {

					}
				}
			} catch (Throwable t) {
				log.error(t.getMessage(), t);
				try {
					Thread.sleep(SLEEP_TIME);
				} catch (Exception e) {
				}
			}
		}
	};

	public static Runnable r_tmpfdxx = () -> {

		DubboJsMx dubboJsMx = JscppUtil.getBean("dubboJsMx", DubboJsMx.class);
		YwxxService ywxxService = JscppUtil.getBean("ywxxService", YwxxService.class);
		while (true) {
			try {
				List<TmpFdxxb> result = dubboJsMx.getTmpFdxxb(Main.sfdm);
				if (result != null && !result.isEmpty()) {
					log.info("TmpFdxxb size = " + result.size());
					ywxxService.doSaveTmpFdxx(result);
					// 服务端删除数据
					List<TmpFdxxb> backlist = new ArrayList<TmpFdxxb>();
					TmpFdxxb tmp = null;
					for (TmpFdxxb o : result) {
						tmp = new TmpFdxxb();
						tmp.setFdid(o.getFdid());
						backlist.add(tmp);
					}
					dubboJsMx.doDeleteTmpFdxxb(Main.sfdm, backlist);
					backlist.clear();
					result.clear();
				} else {
					log.info("TmpFdxxb complete");
					try {
						Thread.sleep(SLEEP_TIME);
					} catch (Exception e) {

					}
				}
			} catch (Throwable t) {
				log.error(t.getMessage(), t);
				try {
					Thread.sleep(SLEEP_TIME);
				} catch (Exception e) {
				}
			}
		}
	};

	public static Runnable r_ylxx = () -> {

		DubboJsMx dubboJsMx = JscppUtil.getBean("dubboJsMx", DubboJsMx.class);
		YwxxService ywxxService = JscppUtil.getBean("ywxxService", YwxxService.class);
		while (true) {
			try {
				List<JcTYlxxzb> result = dubboJsMx.getJcTYlxxzb(Main.sfdm);
				if (result != null && !result.isEmpty()) {
					log.info("YLXX size = " + result.size());
					ywxxService.doSaveYlxx(result);
					// 服务端删除数据
					List<JcTYlxxzb> backlist = new ArrayList<JcTYlxxzb>();
					JcTYlxxzb tmp = null;
					for (JcTYlxxzb o : result) {
						tmp = new JcTYlxxzb();
						tmp.setYldm(o.getYldm());
						backlist.add(tmp);
					}
					dubboJsMx.doDeleteJcTYlxxzb(Main.sfdm, backlist);
					backlist.clear();
					result.clear();
				} else {
					log.info("YLXX complete");
					try {
						Thread.sleep(SLEEP_TIME);
					} catch (Exception e) {

					}
				}
			} catch (Throwable t) {
				log.error(t.getMessage(), t);
				try {
					Thread.sleep(SLEEP_TIME);
				} catch (Exception e) {
				}
			}
		}
	};
	public static Runnable r_jgxx = () -> {
		
		DubboJsMx dubboJsMx = JscppUtil.getBean("dubboJsMx", DubboJsMx.class);
		YwxxService ywxxService = JscppUtil.getBean("ywxxService", YwxxService.class);
		while(true) {
			try {
				List<JcJgxxb> result = dubboJsMx.getJcJgxxb(Main.sfdm);
				if(result != null && !result.isEmpty()) {
					log.info("JgXX size = " + result.size());
					ywxxService.doSaveJgxx(result);
					//服务端删除数据
					List<JcJgxxb> backlist = new ArrayList<JcJgxxb>();
					JcJgxxb tmp = null;
					for(JcJgxxb o : result) {
						tmp = new JcJgxxb();
						tmp.setJgdm(o.getJgdm());
						backlist.add(tmp);
					}
					dubboJsMx.doDeleteJgxx(Main.sfdm, backlist);
					backlist.clear();
					result.clear();
				} else {
					log.info("JGXX complete");
					try {
						Thread.sleep(SLEEP_TIME);
					} catch (Exception e) {
						
					}
				}
			} catch (Throwable t) {
				log.error(t.getMessage(), t);
				try {
					Thread.sleep(SLEEP_TIME);
				} catch(Exception e) {
				}
			}
		}
	};

	public static Runnable r_tylpcxxb = () -> {
		DubboJsMx dubboJsMx = JscppUtil.getBean("dubboJsMx", DubboJsMx.class);
		YwxxService ywxxService = JscppUtil.getBean("ywxxService", YwxxService.class);
		while (true) {

			try {
				List<Tylpcxxb> result = dubboJsMx.getTylpcxxb(Main.sfdm);
				if (result != null && !result.isEmpty()) {
					log.info("Tylpcxx size = " + result.size());
					ywxxService.doSaveTylpcxx(result);// 保存数据
					// 服务端删除已下发的数据
					List<Tylpcxxb> backList = new ArrayList<>();
					Tylpcxxb tmp = null;
					for (Tylpcxxb o : result) {
						tmp = new Tylpcxxb();
						tmp.setPcdh(o.getPcdh());
						backList.add(tmp);
					}
					dubboJsMx.doDeleteTylpcxxb(Main.sfdm, backList);
					backList.clear();
					result.clear();
				} else {
					log.info("Tylpcxx completed");
					try {
						Thread.sleep(SLEEP_TIME);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			} catch (Throwable t) {
				log.error(t.getMessage(), t);
				try {
					Thread.sleep(SLEEP_TIME);
				} catch (Exception e) {
				}
			}
		}
	};
	// 出口路单
	public static Runnable r_ckld = () -> {

		DubboJsMx dubboJsMx = JscppUtil.getBean("dubboJsMx", DubboJsMx.class);
		YwxxService ywxxService = JscppUtil.getBean("ywxxService", YwxxService.class);
		while (true) {
			try {
				List<Tckldzb> result = dubboJsMx.getTckldb(Main.sfdm);
				if (result != null && !result.isEmpty()) {
					log.info("ckld size = " + result.size());
					ywxxService.doSaveCkld(result);
					// 服务端删除数据
					List<Tckldzb> backlist = new ArrayList<Tckldzb>();
					Tckldzb tmp = null;
					for (Tckldzb o : result) {
						tmp = new Tckldzb();
						tmp.setLdid(o.getLdid());
						tmp.setZzrq(o.getZzrq());
						backlist.add(tmp);
					}
					dubboJsMx.doDeleteTckldzb(Main.sfdm, backlist);
					backlist.clear();
					result.clear();
				} else {
					log.info("ckld complete");
					try {
						Thread.sleep(SLEEP_TIME);
					} catch (Exception e) {

					}
				}
			} catch (Throwable t) {
				log.error(t.getMessage(), t);
				try {
					Thread.sleep(SLEEP_TIME);
				} catch (Exception e) {
				}
			}
		}
	};
	// 出口路单总包
	public static Runnable r_zbfjxx = () -> {

		DubboJsMx dubboJsMx = JscppUtil.getBean("dubboJsMx", DubboJsMx.class);
		YwxxService ywxxService = JscppUtil.getBean("ywxxService", YwxxService.class);
		while (true) {
			try {
				List<Tzbfjxx> result = dubboJsMx.getTzbfjxx(Main.sfdm);
				if (result != null && !result.isEmpty()) {
					log.info("ckldzb size = " + result.size());
					ywxxService.doSaveZbfjxx(result);
					// 服务端删除数据
					List<Tzbfjxx> backlist = new ArrayList<Tzbfjxx>();
					Tzbfjxx tmp = null;
					for (Tzbfjxx o : result) {
						tmp = new Tzbfjxx();
						tmp.setCkldid(o.getCkldid());
						tmp.setZbid(o.getZbid());
						tmp.setFfrq(o.getFfrq());
						backlist.add(tmp);
					}
					dubboJsMx.doDeleteTzbfjxx(Main.sfdm, backlist);
					backlist.clear();
					result.clear();
				} else {
					log.info("ckldzb complete");
					try {
						Thread.sleep(SLEEP_TIME);
					} catch (Exception e) {

					}
				}
			} catch (Throwable t) {
				log.error(t.getMessage(), t);
				try {
					Thread.sleep(SLEEP_TIME);
				} catch (Exception e) {
				}
			}
		}
	};
	// 封发清单
	public static Runnable r_ffqdzb = () -> {

		DubboJsMx dubboJsMx = JscppUtil.getBean("dubboJsMx", DubboJsMx.class);
		YwxxService ywxxService = JscppUtil.getBean("ywxxService", YwxxService.class);
		while (true) {
			try {
				List<Tffqdzb> result = dubboJsMx.getTffqdzb(Main.sfdm);
				if (result != null && !result.isEmpty()) {
					log.info("ffqd size = " + result.size());
					ywxxService.doSaveFfqd(result);
					// 服务端删除数据
					List<Tffqdzb> backlist = new ArrayList<Tffqdzb>();
					Tffqdzb tmp = null;
					for (Tffqdzb o : result) {
						tmp = new Tffqdzb();
						tmp.setQdid(o.getQdid());
						tmp.setFfrq(o.getFfrq());
						backlist.add(tmp);
					}
					dubboJsMx.doDeleteTffqdzb(Main.sfdm, backlist);
					backlist.clear();
					result.clear();
				} else {
					log.info("ffqd complete");
					try {
						Thread.sleep(SLEEP_TIME);
					} catch (Exception e) {

					}
				}
			} catch (Throwable t) {
				log.error(t.getMessage(), t);
				try {
					Thread.sleep(SLEEP_TIME);
				} catch (Exception e) {
				}
			}
		}
	};
	// 封发清单内件
	public static Runnable r_ffqdyj = () -> {

		DubboJsMx dubboJsMx = JscppUtil.getBean("dubboJsMx", DubboJsMx.class);
		YwxxService ywxxService = JscppUtil.getBean("ywxxService", YwxxService.class);
		while (true) {
			try {
				List<Tyjxxb> result = dubboJsMx.getTyjxxb(Main.sfdm);
				if (result != null && !result.isEmpty()) {
					log.info("ffqdyj size = " + result.size());
					ywxxService.doSaveFfqdyj(result);
					// 服务端删除数据
					List<Tyjxxb> backlist = new ArrayList<Tyjxxb>();
					Tyjxxb tmp = null;
					for (Tyjxxb o : result) {
						tmp = new Tyjxxb();
						tmp.setFfqdid(o.getFfqdid());
						tmp.setYjtm(o.getYjtm());
						tmp.setGzrq(o.getGzrq());
						backlist.add(tmp);
					}
					dubboJsMx.doDeleteTyjxxb(Main.sfdm, backlist);
					backlist.clear();
					result.clear();
				} else {
					log.info("ffqdyj complete");
					try {
						Thread.sleep(SLEEP_TIME);
					} catch (Exception e) {

					}
				}
			} catch (Throwable t) {
				log.error(t.getMessage(), t);
				try {
					Thread.sleep(SLEEP_TIME);
				} catch (Exception e) {
				}
			}
		}
	};

	// 邮件种类信息
	public static Runnable r_yjzlxx = () -> {

		DubboJsMx dubboJsMx = JscppUtil.getBean("dubboJsMx", DubboJsMx.class);
		YwxxService ywxxService = JscppUtil.getBean("ywxxService", YwxxService.class);
		while (true) {
			try {
				List<JcYjzlxxb> result = dubboJsMx.getYjzlxx(Main.sfdm);
				if (result != null && !result.isEmpty()) {
					log.info("yjzlxx size = " + result.size());
					ywxxService.doSaveYjzlxx(result);
					// 服务端删除数据
					List<JcYjzlxxb> backlist = new ArrayList<JcYjzlxxb>();
					JcYjzlxxb tmp = null;
					for (JcYjzlxxb o : result) {
						tmp = new JcYjzlxxb();
						tmp.setYjzldm(o.getYjzldm());
						tmp.setYjzlmc(o.getYjzlmc());
						backlist.add(tmp);
					}
					dubboJsMx.doDeleteJcYjzlxxb(Main.sfdm, backlist);
					backlist.clear();
					result.clear();
				} else {
					log.info("yjzlxx complete");
					try {
						Thread.sleep(SLEEP_TIME);
					} catch (Exception e) {

					}
				}
			} catch (Throwable t) {
				log.error(t.getMessage(), t);
				try {
					Thread.sleep(SLEEP_TIME);
				} catch (Exception e) {
				}
			}
		}
	};

	// 车间信息
	public static Runnable r_cjxx = () -> {

		DubboJsMx dubboJsMx = JscppUtil.getBean("dubboJsMx", DubboJsMx.class);
		YwxxService ywxxService = JscppUtil.getBean("ywxxService", YwxxService.class);
		while (true) {
			try {
				List<JcTcjxxb> result = dubboJsMx.getJcTcjxx(Main.sfdm);
				if (result != null && !result.isEmpty()) {
					log.info("Tcjxx size = " + result.size());
					ywxxService.doSaveJcTcjxx(result);
					// 服务端删除数据
					List<JcTcjxxb> backlist = new ArrayList<JcTcjxxb>();
					JcTcjxxb tmp = null;
					for (JcTcjxxb o : result) {
						tmp = new JcTcjxxb();
						tmp.setCjdm(o.getCjdm());
						backlist.add(tmp);
					}
					dubboJsMx.doDeleteJcTcjxxb(Main.sfdm, backlist);
					backlist.clear();
					result.clear();
				} else {
					log.info("Tcjxx complete");
					try {
						Thread.sleep(SLEEP_TIME);
					} catch (Exception e) {

					}
				}
			} catch (Throwable t) {
				log.error(t.getMessage(), t);
				try {
					Thread.sleep(SLEEP_TIME);
				} catch (Exception e) {
				}
			}
		}
	};
	
	// 邮件种类对应关系表
		public static Runnable r_yjzldygx = () -> {

			DubboJsMx dubboJsMx = JscppUtil.getBean("dubboJsMx", DubboJsMx.class);
			YwxxService ywxxService = JscppUtil.getBean("ywxxService", YwxxService.class);
			while (true) {
				try {
					List<JcYjzldygx> result = dubboJsMx.getJcYjzldygx(Main.sfdm);
					if (result != null && !result.isEmpty()) {
						log.info("yjzldygb size = " + result.size());
						ywxxService.doSaveJcYjzldygx(result);
						// 服务端删除数据
						List<JcYjzldygx> backlist = new ArrayList<JcYjzldygx>();
						JcYjzldygx tmp = null;
						for (JcYjzldygx o : result) {
							tmp = new JcYjzldygx();
							tmp.setYjzldm(o.getYjzldm());
							tmp.setYjzlmc(o.getYjzlmc());
							backlist.add(tmp);
						}
						dubboJsMx.doDeleteJcYjzldygxb(Main.sfdm, backlist);
						backlist.clear();
						result.clear();
					} else {
						log.info("yjzldygb complete");
						try {
							Thread.sleep(SLEEP_TIME);
						} catch (Exception e) {

						}
					}
				} catch (Throwable t) {
					log.error(t.getMessage(), t);
					try {
						Thread.sleep(SLEEP_TIME);
					} catch (Exception e) {
					}
				}
			}
		};
	

		public static Runnable r_yjzljbb = () -> {

			DubboJsMx dubboJsMx = JscppUtil.getBean("dubboJsMx", DubboJsMx.class);
			YwxxService ywxxService = JscppUtil.getBean("ywxxService", YwxxService.class);
			while (true) {
				try {
					List<Tyjzljbb> result = dubboJsMx.getYjzljbb(Main.sfdm);
					if (result != null && !result.isEmpty()) {
						log.info("YJZLJBB size = " + result.size());
						ywxxService.doSaveYjzljbb(result);
						// 服务端删除数据
						List<Tyjzljbb> backlist = new ArrayList<Tyjzljbb>();
						Tyjzljbb tmp = null;
						for (Tyjzljbb o : result) {
							tmp = new Tyjzljbb();
							tmp.setId(o.getId());
							backlist.add(tmp);
						}
						dubboJsMx.doDeleteYjzljbb(Main.sfdm, backlist);
						backlist.clear();
						result.clear();
					} else {
						log.info("Tyjzljbb complete");
						try {
							Thread.sleep(SLEEP_TIME);
						} catch (Exception e) {

						}
					}
				} catch (Throwable t) {
					log.error(t.getMessage(), t);
					try {
						Thread.sleep(SLEEP_TIME);
					} catch (Exception e) {
					}
				}
			}
		};
		

		public static Runnable r_yjzlgsb = () -> {

			DubboJsMx dubboJsMx = JscppUtil.getBean("dubboJsMx", DubboJsMx.class);
			YwxxService ywxxService = JscppUtil.getBean("ywxxService", YwxxService.class);
			while (true) {
				try {
					List<Tyjzlgsb> result = dubboJsMx.getYjzlgsb(Main.sfdm);
					if (result != null && !result.isEmpty()) {
						log.info("Tyjzlgsb size = " + result.size());
						ywxxService.doSaveYjzlgsb(result);
						// 服务端删除数据
						List<Tyjzlgsb> backlist = new ArrayList<Tyjzlgsb>();
						Tyjzlgsb tmp = null;
						for (Tyjzlgsb o : result) {
							tmp = new Tyjzlgsb();
							tmp.setYjzldm(o.getYjzldm());
							backlist.add(tmp);
						}
						dubboJsMx.doDeleteYjzlgsb(Main.sfdm, backlist);
						backlist.clear();
						result.clear();
					} else {
						log.info("Tyjzlgsb complete");
						try {
							Thread.sleep(SLEEP_TIME);
						} catch (Exception e) {

						}
					}
				} catch (Throwable t) {
					log.error(t.getMessage(), t);
					try {
						Thread.sleep(SLEEP_TIME);
					} catch (Exception e) {
					}
				}
			}
		};
	
		public static Runnable r_yjzlb = () -> {

			DubboJsMx dubboJsMx = JscppUtil.getBean("dubboJsMx", DubboJsMx.class);
			YwxxService ywxxService = JscppUtil.getBean("ywxxService", YwxxService.class);
			while (true) {
				try {
					List<JcTYjzlb> result = dubboJsMx.getTYjzlb(Main.sfdm);
					if (result != null && !result.isEmpty()) {
						log.info("JcTYjzlb size = " + result.size());
						ywxxService.doSaveTYjzlb(result);
						// 服务端删除数据
						List<JcTYjzlb> backlist = new ArrayList<JcTYjzlb>();
						JcTYjzlb tmp = null;
						for (JcTYjzlb o : result) {
							tmp = new JcTYjzlb();
							tmp.setYjzlbh((o.getYjzlbh()));
							backlist.add(tmp);
						}
						dubboJsMx.doDeleteTYjzlb(Main.sfdm, backlist);
						backlist.clear();
						result.clear();
					} else {
						log.info("JcTYjzlb complete");
						try {
							Thread.sleep(SLEEP_TIME);
						} catch (Exception e) {

						}
					}
				} catch (Throwable t) {
					log.error(t.getMessage(), t);
					try {
						Thread.sleep(SLEEP_TIME);
					} catch (Exception e) {
					}
				}
			}
		};
		/*
		*//**
		 * (天津)资费管控
		 *//*
		public static Runnable r_zfywl = () -> {

			DubboJsMx dubboJsMx = JscppUtil.getBean("dubboJsMx", DubboJsMx.class);
			YsxxService ysxxService = JscppUtil.getBean("ysxxService", YsxxService.class);
			while (true) {
				try {
					List<Zfgkzfywl> result = dubboJsMx.getZfgkzfywl(Main.sfdm);
					if (result != null && !result.isEmpty()) {
						log.info("zfgkzfywl size = " + result.size());
						ysxxService.doSaveZfgkzfywl(result);
						// 服务端删除数据
						List<Zfgkzfywl> backlist = new ArrayList<Zfgkzfywl>();
						Zfgkzfywl tmp = null;
						for (Zfgkzfywl o : result) {
							tmp = new Zfgkzfywl();
							tmp.setJsrq(o.getJsrq());
							tmp.setSjjdm(o.getSjjdm());
							tmp.setJdjds(o.getJdjds());
							tmp.setSjjgs(o.getSjjgs());
							tmp.setKhbm(o.getKhbm());
							tmp.setYjzldm(o.getYjzldm());
							backlist.add(tmp);
						}
						dubboJsMx.doDeleteZfgkzfywl(Main.sfdm, backlist);
					} else {
						log.info("zfgkzfywl complete");
						try {
							Thread.sleep(SLEEP_TIME);
						} catch (Exception e) {

						}
					}
				} catch (Throwable t) {
					log.error(t.getMessage(), t);
					try {
						Thread.sleep(SLEEP_TIME);
					} catch (Exception e) {
					}
				}
			}
		};

		*//**
		 * 预结算(天津)
		 *//*
		public static Runnable r_yjsfkhzcmxb = () -> {

			DubboJsMx dubboJsMx = JscppUtil.getBean("dubboJsMx", DubboJsMx.class);
			YsxxService ysxxService = JscppUtil.getBean("ysxxService", YsxxService.class);
			while (true) {
				try {
					List<YjsFkhzcmxb> result = dubboJsMx.getYjsFkhzcmxb(Main.sfdm);
					if (result != null && !result.isEmpty()) {
						log.info("YjsFkhzcmxb size = " + result.size());
						ysxxService.doSaveYjsFkhzcmxb(result);
						// 服务端删除数据
						List<YjsFkhzcmxb> backlist = new ArrayList<YjsFkhzcmxb>();
						YjsFkhzcmxb tmp = null;
						for (YjsFkhzcmxb o : result) {
							tmp = new YjsFkhzcmxb();
							tmp.setSjrq(o.getSjrq());
							tmp.setSjjsf(o.getSjjsf());
							tmp.setSjjdm(o.getSjjdm());
							tmp.setKhbm(o.getKhbm());
							tmp.setJdjds(o.getJdjds());
							tmp.setYjtm(o.getYjtm());
							tmp.setYjly(o.getYjly());
							tmp.setYjzl(o.getYjzl());
							tmp.setZzf(o.getZzf());
							backlist.add(tmp);
						}
						dubboJsMx.doDeleteYjsFkhzcmxb(Main.sfdm, backlist);
					} else {
						log.info("YjsFkhzcmxb complete");
						try {
							Thread.sleep(SLEEP_TIME);
						} catch (Exception e) {

						}
					}
				} catch (Throwable t) {
					log.error(t.getMessage(), t);
					try {
						Thread.sleep(SLEEP_TIME);
					} catch (Exception e) {
					}
				}
			}
		};*/
		
		/**
		 * AC_JC_YLXXB
		 */
		public static Runnable r_ac_jc_ylxxb = () -> {

			DubboJsMx dubboJsMx = JscppUtil.getBean("dubboJsMx", DubboJsMx.class);
			GxjsService gxjsService = JscppUtil.getBean("gxjsService", GxjsService.class);
			while (true) {
				try {
					List<AcJcYlxxb> result = dubboJsMx.getAcJcYlxxb(Main.sfdm);
					if (result != null && !result.isEmpty()) {
						log.info("AcJcYlxxb size ==========> " + result.size());
						gxjsService.doSaveAcJcYlxxb(result);
						// 服务端删除数据
						List<AcJcYlxxb> backlist = new ArrayList<AcJcYlxxb>();
						AcJcYlxxb tmp = null;
						for (AcJcYlxxb o : result) {
							tmp = new AcJcYlxxb();
							tmp.setId(o.getId());
							backlist.add(tmp);
						}
						dubboJsMx.doDeleteAcJcYlxxb(Main.sfdm,backlist);
						backlist.clear();
						result.clear();
					} else {
						log.info("AcJcYlxxb complete");
						try {
							Thread.sleep(SLEEP_TIME);
						} catch (Exception e) {

						}
					}
				} catch (Throwable t) {
					log.error(t.getMessage(), t);
					try {
						Thread.sleep(SLEEP_TIME);
					} catch (Exception e) {
					}
				}
			}
		};
		
		/**
		 * AC_JC_ZXXXB
		 */
		public static Runnable r_ac_jc_zxxxb = () -> {

			DubboJsMx dubboJsMx = JscppUtil.getBean("dubboJsMx", DubboJsMx.class);
			GxjsService gxjsService = JscppUtil.getBean("gxjsService", GxjsService.class);
			while (true) {
				try {
					List<AcJcZxxxb> result = dubboJsMx.getAcJcZxxxb(Main.sfdm);
					if (result != null && !result.isEmpty()) {
						log.info("AcJcZxxxb size ==========> " + result.size());
						gxjsService.doSaveAcJcZxxxb(result);
						// 服务端删除数据
						List<AcJcZxxxb> backlist = new ArrayList<AcJcZxxxb>();
						AcJcZxxxb tmp = null;
						for (AcJcZxxxb o : result) {
							tmp = new AcJcZxxxb();
							tmp.setId(o.getId());
							backlist.add(tmp);
						}
						dubboJsMx.doDeleteAcJcZxxxb(Main.sfdm,backlist);
					} else {
						log.info("AcJcZxxxb complete");
						try {
							Thread.sleep(SLEEP_TIME);
						} catch (Exception e) {

						}
					}
				} catch (Throwable t) {
					log.error(t.getMessage(), t);
					try {
						Thread.sleep(SLEEP_TIME);
					} catch (Exception e) {
					}
				}
			}
		};
		
		
}
