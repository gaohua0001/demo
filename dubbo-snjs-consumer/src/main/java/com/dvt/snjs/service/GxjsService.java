package com.dvt.snjs.service;

import java.util.List;

import com.dvt.snjs.dubbo.model.AcJcYlxxb;
import com.dvt.snjs.dubbo.model.AcJcZxxxb;
import com.dvt.snjs.dubbo.model.Tzbjsbhk;
import com.dvt.snjs.dubbo.model.Tzbjsbly;
import com.dvt.snjs.dubbo.model.ZdjsGjyjxxDay;
import com.dvt.snjs.dubbo.model.ZdjsGjyjxxKsjzDay;
import com.dvt.snjs.dubbo.model.ZdjsPcyjxxDay;
import com.dvt.snjs.dubbo.model.ZdjsSjzyDay;

public interface GxjsService {

	public void doSaveTzbjsly(List<Tzbjsbly> result);
	public void doSaveZdjsGjyj(List<ZdjsGjyjxxDay> result);
	public void doSaveZdjsKsjz(List<ZdjsGjyjxxKsjzDay> result);
	public void doSaveZdjsSjzy(List<ZdjsSjzyDay> result);
	public void doSaveZdjsPcyj(List<ZdjsPcyjxxDay> result);
	public void doSaveTzbjshk(List<Tzbjsbhk> result);
	
	
	public void doSaveAcJcYlxxb(List<AcJcYlxxb> result);
	public void doSaveAcJcZxxxb(List<AcJcZxxxb> result);
}
