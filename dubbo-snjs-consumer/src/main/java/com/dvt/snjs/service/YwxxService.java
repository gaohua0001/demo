package com.dvt.snjs.service;

import java.util.List;

import com.dvt.snjs.dubbo.model.*;

public interface YwxxService {

	public void doSaveFd(List<Qfdztb> result);
	public void doSaveZb(List<Qzbxxb> result);
	public void doSaveQd(List<Qqdxxb> result);
	public void doSaveYj(List<Qyjxxb> result);
	public void doSaveSj(List<Qyjjbxxb> result);
	public void doSaveGdtd(List<GdTdxxb> result);
	public void doSaveTmpFdxx(List<TmpFdxxb> result);
	
	public void doSaveYlxx(List<JcTYlxxzb> result);
	
	public void doSaveJgxx(List<JcJgxxb> result);

	public void doSaveTylpcxx(List<Tylpcxxb> result);
	
	public void doSaveCkld(List<Tckldzb> result);
	public void doSaveZbfjxx(List<Tzbfjxx> result);
	public void doSaveFfqd(List<Tffqdzb> result);
	public void doSaveFfqdyj(List<Tyjxxb> result);
	
	public void doSaveYjzlxx(List<JcYjzlxxb> result);
	public void doSaveJcTcjxx(List<JcTcjxxb> result);
	public void doSaveJcYjzldygx(List<JcYjzldygx> result);
	public void doSaveYjzljbb(List<Tyjzljbb> result);
	public void doSaveYjzlgsb(List<Tyjzlgsb> result);
	public void doSaveTYjzlb(List<JcTYjzlb> result);

}
