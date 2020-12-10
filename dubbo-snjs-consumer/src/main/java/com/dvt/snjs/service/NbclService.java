package com.dvt.snjs.service;

import java.util.List;

import com.dvt.snjs.dubbo.model.JsNbclCkfyDay;
import com.dvt.snjs.dubbo.model.JsNbclJkfyDay;
import com.dvt.snjs.dubbo.model.JsNbclYjxxDay;

/**
 * 快递包裹内部处理费用
 * @author zane
 *
 */
public interface NbclService {


	public void doSaveKsjz(List<JsNbclYjxxDay> result);
	
	public void doSaveCkfy(List<JsNbclCkfyDay> result);
	public void doSaveJkfy(List<JsNbclJkfyDay> result);
}
