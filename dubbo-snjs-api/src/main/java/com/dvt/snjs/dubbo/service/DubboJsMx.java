package com.dvt.snjs.dubbo.service;

import java.util.List;

import com.dvt.snjs.dubbo.model.*;

/**
 * j集团结算明细数据下载
 * @author zane
 *
 */
public interface DubboJsMx {

	/**
	 * 投递信息
	 * @param sfdm
	 * @return
	 */
	public List<JsTdxxDay> getTdxx(String sfdm);
	
	/**
	 * 删除投递信息
	 * @param sfdm
	 * @param result
	 */
	public void doDeleteTdxx(String sfdm, List<JsTdxxDay> result);

	/**
	 * 省际经转
	 * @param sfdm
	 * @return
	 */
	public List<JsNbclYjxxDay> getKsjz(String sfdm);
	
	/**
	 * 删除省际经转
	 * @param sfdm
	 * @param result
	 */
	public void doDeleteKsjz(String sfdm, List<JsNbclYjxxDay> result);

	/**
	 * 内部处理出口省费用
	 * @param sfdm
	 * @return
	 */
	public List<JsNbclCkfyDay> getCkfy(String sfdm);
	
	/**
	 * 删除内部处理出口省费用
	 * @param sfdm
	 * @param result
	 */
	public void doDeleteCkfy(String sfdm, List<JsNbclCkfyDay> result);

	/**
	 * 内部处理进口省费用信息
	 * @param sfdm
	 * @return
	 */
	public List<JsNbclJkfyDay> getJkfy(String sfdm);
	
	/**
	 * 删除内部处理进口省费用信息
	 * @param sfdm
	 * @param result
	 */
	public void doDeleteJkfy(String sfdm, List<JsNbclJkfyDay> result);

	/**
	 * 陆运信息
	 * @param sfdm
	 * @return
	 */
	public List<JsYsxxDay> getYsxx(String sfdm);
	
	/**
	 * 删除陆运信息
	 * @param sfdm
	 * @param result
	 */
	public void doDeleteYsxx(String sfdm, List<JsYsxxDay> result);

	/**
	 * 航空信息
	 * @param sfdm
	 * @return
	 */
	public List<JsYsxxHkfyDay> getHkxx(String sfdm);
	
	/**
	 * 删除航空信息
	 * @param sfdm
	 * @param result
	 */
	public void doDeleteHkxx(String sfdm, List<JsYsxxHkfyDay> result);
	
	


	/**
	 * 一干运费
	 * @param sfdm
	 * @return
	 */
	public List<Tzbjsbly> getTzbjsbly(String sfdm);
	
	/**
	 * 删除一干运费
	 * @param sfdm
	 * @param result
	 */
	public void doDeleteTzbjsbly(String sfdm, List<Tzbjsbly> result);
	
	


	/**
	 * 平常邮件
	 * @param sfdm
	 * @return
	 */
	public List<ZdjsPcyjxxDay> getZdjsPcyj(String sfdm);
	
	/**
	 * 删除平常邮件
	 * @param sfdm
	 * @param result
	 */
	public void doDeleteZdjsPcyj(String sfdm, List<ZdjsPcyjxxDay> result);
	
	


	/**
	 * 给据邮件
	 * @param sfdm
	 * @return
	 */
	public List<ZdjsGjyjxxDay> getZdjsGjyj(String sfdm);
	
	/**
	 * 删除给据邮件
	 * @param sfdm
	 * @param result
	 */
	public void doDeleteZdjsGjyj(String sfdm, List<ZdjsGjyjxxDay> result);
	
	


	/**
	 * 跨省经转
	 * @param sfdm
	 * @return
	 */
	public List<ZdjsGjyjxxKsjzDay> getZdjsKsjz(String sfdm);
	
	/**
	 * 删除跨省经转
	 * @param sfdm
	 * @param result
	 */
	public void doDeleteZdjsKsjz(String sfdm, List<ZdjsGjyjxxKsjzDay> result);
	
	


	/**
	 * 省际转运
	 * @param sfdm
	 * @return
	 */
	public List<ZdjsSjzyDay> getZdjsSjzy(String sfdm);
	
	/**
	 * 删除省际转运
	 * @param sfdm
	 * @param result
	 */
	public void doDeleteZdjsSjzy(String sfdm, List<ZdjsSjzyDay> result);
	
	/**
	 * 附单信息
	 * @param sfdm
	 * @return
	 */
	public List<Qfdztb> getQfdztb(String sfdm);
	
	public void doDeleteQfdztb(String sfdm, List<Qfdztb> result);
	
	/**
	 * 总包信息
	 * @param sfdm
	 * @return
	 */
	public List<Qzbxxb> getQzbxxb(String sfdm);
	
	public void doDeleteQzbxxb(String sfdm, List<Qzbxxb> result);
	
	/**
	 * 清单信息
	 * @param sfdm
	 * @return
	 */
	public List<Qqdxxb> getQqdxxb(String sfdm);
	
	public void doDeleteQqdxxb(String sfdm, List<Qqdxxb> result);
	
	/**
	 * 清单内件信息
	 * @param sfdm
	 * @return
	 */
	public List<Qyjxxb> getQyjxxb(String sfdm);
	
	public void doDeleteQyjxxb(String sfdm, List<Qyjxxb> result);
	
	/**
	 * 收寄信息
	 * @param sfdm
	 * @return
	 */
	public List<Qyjjbxxb> getQyjjbxxb(String sfdm);
	
	public void doDeleteQyjjbxxb(String sfdm, List<Qyjjbxxb> result);
	
	/**
	 * 投递信息
	 * @param sfdm
	 * @return
	 */
	public List<GdTdxxb> getGdTdxxb(String sfdm);
	
	public void doDeleteGdTdxxb(String sfdm, List<GdTdxxb> result);
	
	/**
	 * 
	 * @param sfdm
	 * @return
	 */
	public List<TmpFdxxb> getTmpFdxxb(String sfdm);
	public void doDeleteTmpFdxxb(String sfdm, List<TmpFdxxb> result);
	

	
	/**
	 * 出口路单
	 * @param sfdm
	 * @return
	 */
	public List<Tckldzb> getTckldb(String sfdm);
	
	public void doDeleteTckldzb(String sfdm, List<Tckldzb> result);
	
	/**
	 * 总包附加信息
	 * @param sfdm
	 * @return
	 */
	public List<Tzbfjxx> getTzbfjxx(String sfdm);
	
	public void doDeleteTzbfjxx(String sfdm, List<Tzbfjxx> result);
	
	/**
	 * 封发清单
	 * @param sfdm
	 * @return
	 */
	public List<Tffqdzb> getTffqdzb(String sfdm);
	
	public void doDeleteTffqdzb(String sfdm, List<Tffqdzb> result);
	
	/**
	 * 封发清单内件
	 * @param sfdm
	 * @return
	 */
	public List<Tyjxxb> getTyjxxb(String sfdm);
	
	public void doDeleteTyjxxb(String sfdm, List<Tyjxxb> result);

	
	/**
	 * 邮路
	 * @param sfdm
	 * @return
	 */
	public List<JcTYlxxzb> getJcTYlxxzb(String sfdm);
	public void doDeleteJcTYlxxzb(String sfdm, List<JcTYlxxzb> result);
	
	/**
	 * 监控信息
	 * @param sfdm
	 * @return
	 */
	public List<SnjsJkxxb> getSnjsJkxxb(String sfdm);
	public void doUpdateSnjsJkxxb(List<SnjsJkxxb> list);
	
	/**
	 * 下发控制
	 * @param sfdm
	 * @return
	 */
	public String getXfkzb(String sfdm);
	
	public List<JcJgxxb> getJcJgxxb(String sfdm);
	public void doDeleteJgxx(String sfdm, List<JcJgxxb> result);

	/**
	 * 邮路派车信息表
	 * @param sfdm
	 * @return
	 */
	public List<Tylpcxxb> getTylpcxxb(String sfdm);
	public void doDeleteTylpcxxb(String sfdm, List<Tylpcxxb> result);
	
	
	/**
	 * 邮件种类信息
	 * @param sfdm
	 * @return
	 */
	public List<JcYjzlxxb> getYjzlxx(String sfdm);
	public void doDeleteJcYjzlxxb(String sfdm, List<JcYjzlxxb> result);
	
	
	/**
	 * 车间信息
	 * @param sfdm
	 * @return
	 */
	public List<JcTcjxxb> getJcTcjxx(String sfdm);
	public void doDeleteJcTcjxxb(String sfdm, List<JcTcjxxb> result);
	
	
	/**
	 * 邮件种类对应关系表
	 * @param sfdm
	 * @return
	 */
	public List<JcYjzldygx> getJcYjzldygx(String sfdm);
	public void doDeleteJcYjzldygxb(String sfdm, List<JcYjzldygx> result);
	
	
	/**
	 * 邮件种类级别表
	 * @param sfdm
	 * @return
	 */
	public List<Tyjzljbb> getYjzljbb(String sfdm);
	public void doDeleteYjzljbb(String sfdm, List<Tyjzljbb> result);
	
	
	/**
	 * 邮件种类归属表
	 * @param sfdm
	 * @return
	 */
	public List<Tyjzlgsb> getYjzlgsb(String sfdm);
	public void doDeleteYjzlgsb(String sfdm, List<Tyjzlgsb> result);
	
	
	/**
	 * 邮件种类表
	 * @param sfdm
	 * @return
	 */
	public List<JcTYjzlb> getTYjzlb(String sfdm);
	public void doDeleteTYjzlb(String sfdm, List<JcTYjzlb> result);

	
	
	public List<Tzbjsbhk> getTzbjsbhk(String sfdm);
	public void doDeleteTzbjsbhk(String sfdm, List<Tzbjsbhk> backlist);

	/**
	 * 
	 * @Description: AcJcYlxxb
	 * @author yangbing
	 * @date 2019年9月10日
	 */
	public List<AcJcYlxxb> getAcJcYlxxb(String sfdm);
	public void doDeleteAcJcYlxxb(String sfdm, List<AcJcYlxxb> backlist);
	
	/**
	 * 
	 * @Description: AcJcZxxxb
	 * @author yangbing
	 * @date 2019年9月10日
	 */
	public List<AcJcZxxxb> getAcJcZxxxb(String sfdm);
	public void doDeleteAcJcZxxxb(String sfdm, List<AcJcZxxxb> backlist);
	
	
	
//	
//	/**
//	 * 
//	 * @Description: 资费管控
//	 * @param sfdm
//	 * @return List<Zfgkzfywl>  
//	 * @throws
//	 * @author yangbing
//	 * @date 2019年4月26日
//	 */
//	public List<Zfgkzfywl> getZfgkzfywl(String sfdm);
//
//	public void doDeleteZfgkzfywl(String sfdm, List<Zfgkzfywl> backlist);
//	
//	/**
//	 * 
//	 * @Description: 预结算分客户支出费用表
//	 * @param sfdm
//	 * @return List<Zfgkzfywl>  
//	 * @throws
//	 * @author yangbing
//	 * @date 2019年4月26日
//	 */
//	public List<YjsFkhzcmxb> getYjsFkhzcmxb(String sfdm);
//
//	public void doDeleteYjsFkhzcmxb(String sfdm, List<YjsFkhzcmxb> backlist);
//	
}
