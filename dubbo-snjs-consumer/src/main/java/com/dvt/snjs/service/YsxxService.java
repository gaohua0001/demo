package com.dvt.snjs.service;

import java.util.List;

import com.dvt.snjs.dubbo.model.JsYsxxDay;
import com.dvt.snjs.dubbo.model.JsYsxxHkfyDay;
import com.dvt.snjs.dubbo.model.YjsFkhzcmxb;
import com.dvt.snjs.dubbo.model.Zfgkzfywl;

/**
 * 快递包裹运信息
 * @author zane
 *
 */
public interface YsxxService {

	public void doSaveYsxx(List<JsYsxxDay> result);
	
	public void doSaveHkfy(List<JsYsxxHkfyDay> result);

	/*//资费管控资费业务量(天津)
	public void doSaveZfgkzfywl(List<Zfgkzfywl> result);
	
	//预结算分客户支出明细表(天津)
	public void doSaveYjsFkhzcmxb(List<YjsFkhzcmxb> result);
*/
}
