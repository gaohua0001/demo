package com.dvt.snjs.app;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.dvt.core.exception.CommonException;
import com.dvt.snjs.dubbo.service.DubboJsMx;
import com.dvt.snjs.service.CommonService;
import com.dvt.snjs.util.JscppUtil;

/**
 * 服务端
 * @author zane
 *
 */
public class Main {
	
	private static Log log = LogFactory.getLog(Main.class);

	public static String sfdm = "";
	public static String startTime1="12:00:00";
	public static String startTime2="18:00:00";
	public static String startTime3="04:00:00";
	public static String endTime1="14:00:00";
	public static String endTime2="20:00:00";
	public static String endTime3="08:00:00";
	public static void main(String[] args) {
		log.info("程序启动");
		try {
			JscppUtil.loadConfig("/SystemRootContext.xml");
		} catch (Throwable e) {
			log.error("配置文件加载失败了");
			log.error(e.getMessage(), e);
			System.exit(-1);
		}
		//省份代码
		try {
			sfdm = JscppUtil.getBean("commonService", CommonService.class).getSfdm();
			if(sfdm == null || sfdm.trim().length() != 8) {
				log.error("省份代码错误,sfdm=" + sfdm);
				System.exit(-1);
			}
			/*if("00000016".equals(sfdm)){
				SimpleDateFormat ft = new SimpleDateFormat ("HH:mm:ss");
				boolean dateflag=false;
				try {
					while(!dateflag){
						String nowTime=ft.format(new Date());
						dateflag = isEffectiveDate(ft.parse(nowTime),ft.parse(startTime1),ft.parse(endTime1));
						if(!dateflag){
							dateflag = isEffectiveDate(ft.parse(nowTime),ft.parse(startTime2),ft.parse(endTime2));
							if(!dateflag){
								dateflag = isEffectiveDate(ft.parse(nowTime),ft.parse(startTime3),ft.parse(endTime3));
								if(!dateflag){
									log.error("不在窗口期" + sfdm);
									Thread.sleep(10*60*1000);
								}
							}
						}
					}
					
					
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}*/
		} catch (CommonException e) {
			log.error(e.getMessage(), e);
			System.exit(-1);
		}
		//数据同步线程池
		BlockingQueue<Runnable> queue = null;
		try {
			queue = getTaskQueue();
		} catch (InterruptedException e1) {
			log.error(e1.getMessage(), e1);
			System.exit(1);
		}
		ExecutorService executor = Executors.newFixedThreadPool(queue.size());
		for(Runnable r : queue) {
			executor.submit(r);
		}
		executor.shutdown();
		//
		while(true) {
			log.info("程序运行中");
			try {
				Thread.sleep(10*60*1000);
			} catch (InterruptedException e) {
			}
		}
	}
	
	 /**
     * 判断当前时间是否在[startTime, endTime]区间，注意时间格式要一致
     * 
     * @param nowTime 当前时间
     * @param startTime 开始时间
     * @param endTime 结束时间
     * @return
     * @author jqlin
     */
    public static boolean isEffectiveDate(Date nowTime, Date startTime, Date endTime) {
        if (nowTime.getTime() == startTime.getTime()
                || nowTime.getTime() == endTime.getTime()) {
            return true;
        }

        Calendar date = Calendar.getInstance();
        date.setTime(nowTime);

        Calendar begin = Calendar.getInstance();
        begin.setTime(startTime);

        Calendar end = Calendar.getInstance();
        end.setTime(endTime);

        if (date.after(begin) && date.before(end)) {
            return true;
        } else {
            return false;
        }
    }
	
	/**
	 * 获取任务
	 * @return
	 * @throws InterruptedException
	 */
	private static BlockingQueue<Runnable> getTaskQueue() throws InterruptedException {
		BlockingQueue<Runnable> queue = new LinkedBlockingQueue<Runnable>();

		queue.put(DataTask.r_jkxx);
		String tabname = JscppUtil.getBean("dubboJsMx", DubboJsMx.class).getXfkzb(sfdm);
		log.info(tabname);
		if (tabname.contains("JS_TDXX_DAY")) {
			//包裹快递-投递
			queue.put(DataTask.r_tdfy);
		}
		
		if (tabname.contains("JS_YSXX_DAY")) {
			//包裹快递-陆运
			queue.put(DataTask.r_lyfy);
		}
		
		if (tabname.contains("JS_YSXX_HKFY_DAY")) {
			//包裹快递-航空
			queue.put(DataTask.r_hkfy);
		}
		
		if (tabname.contains("JS_NBCL_YJXX_DAY")) {
			//包裹快递-省际经转
			queue.put(DataTask.r_ksjz);
		}
		
		if (tabname.contains("JS_NBCL_CKFY_DAY")) {
			//包裹快递-出口省内部处理费
			queue.put(DataTask.r_ckfy);
		}
		
		if (tabname.contains("JS_NBCL_JKFY_DAY")) {
			//包裹快递-进口省内部处理费
			queue.put(DataTask.r_jkfy);
		}
		
		if (tabname.contains("SN_TZBJS_DAY_LY")) {
			//一干陆运普服明细
			queue.put(DataTask.r_tzbjs_ly);
		}
		if (tabname.contains("SN_TZBJS_DAY_HK")) {
			//一干航空普服明细
			queue.put(DataTask.r_tzbjs_hk);
		}
		
		if (tabname.contains("ZDJS_GJYJXX_DAY")) {
			//省际终端费-进出口
			queue.put(DataTask.r_zdjsgjyj);
		}
		
		if (tabname.contains("ZDJS_GJYJXX_KSJZ_DAY")) {
			//省际终端费-跨省经转
			queue.put(DataTask.r_zdjsksjz);
		}
		
		if (tabname.contains("ZDJS_SJZY_DAY")) {
			//省际终端费-省际经转
			queue.put(DataTask.r_zdjssjzy);
		}
		
		if (tabname.contains("ZDJS_PCYJXX_DAY")) {
			//省际终端费-平常邮件
			queue.put(DataTask.r_zdjspcyj);
		}
		
		if (tabname.contains("QFDZTB")) {
			//附单信息
			queue.put(DataTask.r_qfdztb);
		}
		
		if (tabname.contains("QZBXXB")) {
			//总包信息
			queue.put(DataTask.r_qzbxxb);
		}
		
		if (tabname.contains("GD_QQDXXB")) {
			//清单
			queue.put(DataTask.r_qqdxxb);
		}
		
		if (tabname.contains("GD_QYJXXB")) {
			//清单内件
			queue.put(DataTask.r_qyjxxb);
		}
		
		if (tabname.contains("GD_QYJJBXXB")) {
			//收寄信息
			queue.put(DataTask.r_qyjjbxxb);
		}
		
		if (tabname.contains("GD_TDXXB")) {
			//投递信息
			queue.put(DataTask.r_gdtdxx);
		}
		
		if (tabname.contains("TMP_FDXXB")) {
			//附单信息
			queue.put(DataTask.r_tmpfdxx);
		}
		
		if (tabname.contains("JC_T_YLXXZB")) {
			//邮路信息
			queue.put(DataTask.r_ylxx);
		}
		
		if (tabname.contains("AC_JC_JGXXB")) {
			//机构信息
			queue.put(DataTask.r_jgxx);
		}

		if (tabname.contains("CL_TYLPCXXB")) {
			//邮路派车信息表
			queue.put(DataTask.r_tylpcxxb);
		}
		//
		//
		//

		if (tabname.contains("TCKLDZB")) {
			//路单信息
			queue.put(DataTask.r_ckld);
		}
		if (tabname.contains("TZBFJXX")) {
			//附加信息
			queue.put(DataTask.r_zbfjxx);
		}
		if (tabname.contains("TFFQDZB")) {
			//封发清单信息
			queue.put(DataTask.r_ffqdzb);
		}
		if (tabname.contains("TYJXXB")) {
			//邮件信息
			queue.put(DataTask.r_ffqdyj);
		}
		if (tabname.contains("JC_YJZLXXB")) {
			//邮件种类信息
			queue.put(DataTask.r_yjzlxx);
		}
		if (tabname.contains("JC_T_CJXXB")) {
			//车间信息
			queue.put(DataTask.r_cjxx);
		}
		if (tabname.contains("JC_YJZLDYGXB")) {
			//邮件种类对应关系表
			queue.put(DataTask.r_yjzldygx);
		}
		if (tabname.contains("JC_YJZLJBB")) {
			//邮件种类级别表
			queue.put(DataTask.r_yjzljbb);
		}
		if (tabname.contains("JC_YJZLGSB")) {
			//邮件种类归属表
			queue.put(DataTask.r_yjzlgsb);
		}
		if (tabname.contains("JC_T_YJZLB")) {
			//邮件种类表
			queue.put(DataTask.r_yjzlb);
		}
		if(tabname.contains("AC_JC_YLXXB")){
			//2019年9月10日新增    邮路信息表
			queue.put(DataTask.r_ac_jc_ylxxb);
		}
		if(tabname.contains("AC_JC_ZXXXB")){
			//2019年9月10日新增    邮路站序表
			queue.put(DataTask.r_ac_jc_zxxxb);
		}
		/*if(tabname.contains("ZFGK_ZF_YWL_DAY")){
			//资费管控资费业务量(天津)
			queue.put(DataTask.r_zfywl);
		}
		if(tabname.contains("YJS_FKHZCFYMXB")){
			//预结算分客户支出明细表(天津)
			queue.put(DataTask.r_yjsfkhzcmxb);
		}*/
		return queue;
	}

}
