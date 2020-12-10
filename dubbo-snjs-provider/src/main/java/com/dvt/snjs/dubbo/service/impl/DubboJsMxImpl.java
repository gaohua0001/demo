package com.dvt.snjs.dubbo.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.dvt.snjs.dubbo.model.*;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.dvt.snjs.dubbo.service.DubboJsMx;
import com.dvt.snjs.service.GxjsService;
import com.dvt.snjs.service.NbclService;
import com.dvt.snjs.service.TdxxService;
import com.dvt.snjs.service.YsxxService;
import com.dvt.snjs.service.YwxxService;

public class DubboJsMxImpl implements DubboJsMx {
	
	private static Log log = LogFactory.getLog(DubboJsMxImpl.class);
	
	private TdxxService tdxxService;
	
	@Autowired
	public void setTdxxService(TdxxService tdxxService) {
		this.tdxxService = tdxxService;
	}
	

	private NbclService nbclService;
	@Autowired
	public void setNbclService(NbclService nbclService) {
		this.nbclService = nbclService;
	}
	
	private YsxxService ysxxService;
	@Autowired
	public void setYsxxService(YsxxService ysxxService) {
		this.ysxxService = ysxxService;
	}
	
	private GxjsService gxjsService;
	@Autowired
	public void setGxjsService(GxjsService gxjsService) {
		this.gxjsService = gxjsService;
	}
	
	private YwxxService ywxxService;
	@Autowired
	public void setYwxxService(YwxxService ywxxService) {
		this.ywxxService = ywxxService;
	}

	@Override
	public List<JsTdxxDay> getTdxx(String sfdm) {
		try {
			log.info("get tdxx sfdm=" + sfdm);
			return tdxxService.getTdxx(sfdm);
		} catch(Exception e) {
			log.error(e.getMessage(), e);
			return null;
		}
	}

	@Override
	public void doDeleteTdxx(String sfdm, List<JsTdxxDay> result) {
		try {
			log.info("delete tdxx sfdm=" + sfdm);
			tdxxService.doDeleteTdxx(sfdm, result);
		} catch(Exception e) {
			log.error(e.getMessage(), e);
		}
	}

	@Override
	public List<JsNbclYjxxDay> getKsjz(String sfdm) {
		try {
			log.info("get ksjz sfdm=" + sfdm);
			return nbclService.getKsjz(sfdm);
		} catch(Exception e) {
			log.error(e.getMessage(), e);
			return null;
		}
	}

	@Override
	public void doDeleteKsjz(String sfdm, List<JsNbclYjxxDay> result) {
		try {
			log.info("delete ksjz sfdm=" + sfdm);
			nbclService.doDeleteKsjz(sfdm, result);
		} catch(Exception e) {
			log.error(e.getMessage(), e);
		}
	}

	@Override
	public List<JsNbclCkfyDay> getCkfy(String sfdm) {
		try {
			log.info("get ckfy sfdm=" + sfdm);
			return nbclService.getCkfy(sfdm);
		} catch(Exception e) {
			log.error(e.getMessage(), e);
			return null;
		}
	}

	@Override
	public void doDeleteCkfy(String sfdm, List<JsNbclCkfyDay> result) {
		try {
			log.info("delete ckfy sfdm=" + sfdm);
			nbclService.doDeleteCkfy(sfdm, result);
		} catch(Exception e) {
			log.error(e.getMessage(), e);
		}
	}

	@Override
	public List<JsNbclJkfyDay> getJkfy(String sfdm) {
		try {
			log.info("get jkfy sfdm=" + sfdm);
			return nbclService.getJkfy(sfdm);
		} catch(Exception e) {
			log.error(e.getMessage(), e);
			return null;
		}
	}

	@Override
	public void doDeleteJkfy(String sfdm, List<JsNbclJkfyDay> result) {
		try {
			log.info("delete jkfy sfdm=" + sfdm);
			nbclService.doDeleteJkfy(sfdm, result);
		} catch(Exception e) {
			log.error(e.getMessage(), e);
		}
	}

	@Override
	public List<JsYsxxDay> getYsxx(String sfdm) {
		try {
			log.info("get ysxx sfdm=" + sfdm);
			return ysxxService.getYsxx(sfdm);
		} catch(Exception e) {
			log.error(e.getMessage(), e);
			return null;
		}
	}

	@Override
	public void doDeleteYsxx(String sfdm, List<JsYsxxDay> result) {
		try {
			log.info("delete ysxx sfdm=" + sfdm);
			ysxxService.doDeleteYsxx(sfdm, result);
		} catch(Exception e) {
			log.error(e.getMessage(), e);
		}
	}

	@Override
	public List<JsYsxxHkfyDay> getHkxx(String sfdm) {
		try {
			log.info("get hkfy sfdm=" + sfdm);
			return ysxxService.getHkxx(sfdm);
		} catch(Exception e) {
			log.error(e.getMessage(), e);
			return null;
		}
	}

	@Override
	public void doDeleteHkxx(String sfdm, List<JsYsxxHkfyDay> result) {
		try {
			log.info("delete hkfy sfdm=" + sfdm);
			ysxxService.doDeleteHkxx(sfdm, result);
		} catch(Exception e) {
			log.error(e.getMessage(), e);
		}
	}

	@Override
	public List<Tzbjsbly> getTzbjsbly(String sfdm) {
		try {
			log.info("get pfysxx_ly sfdm=" + sfdm);
			return ysxxService.getTzbjsbly(sfdm);
		} catch(Exception e) {
			log.error(e.getMessage(), e);
			return null;
		}
	}

	@Override
	public void doDeleteTzbjsbly(String sfdm, List<Tzbjsbly> result) {
		try {
			log.info("delete pfysxx_ly sfdm=" + sfdm);
			ysxxService.doDeleteTzbjsbly(sfdm, result);
		} catch(Exception e) {
			log.error(e.getMessage(), e);
		}
	}

	@Override
	public List<ZdjsPcyjxxDay> getZdjsPcyj(String sfdm) {
		try {
			log.info("get zdjs pcyj sfdm=" + sfdm);
			return ywxxService.getZdjsPcyj(sfdm);
		} catch(Exception e) {
			log.error(e.getMessage(), e);
			return null;
		}
	}

	@Override
	public void doDeleteZdjsPcyj(String sfdm, List<ZdjsPcyjxxDay> result) {
		try {
			log.info("delete zdjs pcyj sfdm=" + sfdm);
			ywxxService.doDeleteZdjsPcyj(sfdm, result);
		} catch(Exception e) {
			log.error(e.getMessage(), e);
		}
	}

	@Override
	public List<ZdjsGjyjxxDay> getZdjsGjyj(String sfdm) {
		try {
			log.info("get zdjs gjyj sfdm=" + sfdm);
			return ywxxService.getZdjsGjyj(sfdm);
		} catch(Exception e) {
			log.error(e.getMessage(), e);
			return null;
		}
	}

	@Override
	public void doDeleteZdjsGjyj(String sfdm, List<ZdjsGjyjxxDay> result) {
		try {
			log.info("delete zdjs gjyj sfdm=" + sfdm);
			ywxxService.doDeleteZdjsGjyj(sfdm, result);
		} catch(Exception e) {
			log.error(e.getMessage(), e);
		}
	}

	@Override
	public List<ZdjsGjyjxxKsjzDay> getZdjsKsjz(String sfdm) {
		try {
			log.info("get zdjs ksjz sfdm=" + sfdm);
			return ywxxService.getZdjsKsjz(sfdm);
		} catch(Exception e) {
			log.error(e.getMessage(), e);
			return null;
		}
	}

	@Override
	public void doDeleteZdjsKsjz(String sfdm, List<ZdjsGjyjxxKsjzDay> result) {
		try {
			log.info("delete zdjs ksjz sfdm=" + sfdm);
			ywxxService.doDeleteZdjsKsjz(sfdm, result);
		} catch(Exception e) {
			log.error(e.getMessage(), e);
		}
	}

	@Override
	public List<ZdjsSjzyDay> getZdjsSjzy(String sfdm) {
		try {
			log.info("get zdjs sjzy sfdm=" + sfdm);
			return ywxxService.getZdjsSjzy(sfdm);
		} catch(Exception e) {
			log.error(e.getMessage(), e);
			return null;
		}
	}

	@Override
	public void doDeleteZdjsSjzy(String sfdm, List<ZdjsSjzyDay> result) {
		try {
			log.info("delete zdjs sjzy sfdm=" + sfdm);
			ywxxService.doDeleteZdjsSjzy(sfdm, result);
		} catch(Exception e) {
			log.error(e.getMessage(), e);
		}
	}

	@Override
	public List<Qfdztb> getQfdztb(String sfdm) {
		return this.ywxxService.getQfdztb(sfdm);
	}

	@Override
	public void doDeleteQfdztb(String sfdm, List<Qfdztb> result) {
		this.ywxxService.doDeleteQfdztb(sfdm, result);
	}

	@Override
	public List<Qzbxxb> getQzbxxb(String sfdm) {
		return this.ywxxService.getQzbxxb(sfdm);
	}

	@Override
	public void doDeleteQzbxxb(String sfdm, List<Qzbxxb> result) {
		this.ywxxService.doDeleteQzbxxb(sfdm, result);
	}

	@Override
	public List<Qqdxxb> getQqdxxb(String sfdm) {
		return this.ywxxService.getQqdxxb(sfdm);
	}

	@Override
	public void doDeleteQqdxxb(String sfdm, List<Qqdxxb> result) {
		this.ywxxService.doDeleteQqdxxb(sfdm, result);
	}

	@Override
	public List<Qyjxxb> getQyjxxb(String sfdm) {
		return this.ywxxService.getQyjxxb(sfdm);
	}

	@Override
	public void doDeleteQyjxxb(String sfdm, List<Qyjxxb> result) {
		this.ywxxService.doDeleteQyjxxb(sfdm, result);
	}

	@Override
	public List<Qyjjbxxb> getQyjjbxxb(String sfdm) {
		return this.ywxxService.getQyjjbxxb(sfdm);
	}

	@Override
	public void doDeleteQyjjbxxb(String sfdm, List<Qyjjbxxb> result) {
		this.ywxxService.doDeleteQyjjbxxb(sfdm, result);
	}
	
	@Override
	public List<GdTdxxb> getGdTdxxb(String sfdm) {
		return this.ywxxService.getGdTdxxb(sfdm);
	}

	@Override
	public void doDeleteGdTdxxb(String sfdm, List<GdTdxxb> result) {
		this.ywxxService.doDeleteGdTdxxb(sfdm, result);
	}
	
	@Override
	public String getXfkzb(String sfdm) {
		return this.ywxxService.getXfkzb(sfdm);
	}

	@Override
	public List<TmpFdxxb> getTmpFdxxb(String sfdm) {
		return this.ywxxService.getTmpFdxxb(sfdm);
	}

	@Override
	public void doDeleteTmpFdxxb(String sfdm, List<TmpFdxxb> result) {
		this.ywxxService.doDeleteTmpFdxxb(sfdm, result);
	}

	@Override
	public List<JcTYlxxzb> getJcTYlxxzb(String sfdm) {
		return this.ywxxService.getJcTYlxxzb(sfdm);
	}

	@Override
	public void doDeleteJcTYlxxzb(String sfdm, List<JcTYlxxzb> result) {
		this.ywxxService.doDeleteJcTYlxxzb(sfdm, result);
	}

	@Override
	public List<SnjsJkxxb> getSnjsJkxxb(String sfdm) {
		List<SnjsJkxxb> result = new ArrayList<SnjsJkxxb>();
		//统计未下发数据是否完成
		//查询已下发未同步下发状态的数据
		/*List<SnjsJkxxb> resultGxjs = this.gxjsService.doGetSnjsJkxxb(sfdm);
		if(resultGxjs != null) {
			result.addAll(resultGxjs);
		}*/
		List<SnjsJkxxb> resultNewGxjs = this.ywxxService.doGetSnjsJkxxb(sfdm);
		if(resultNewGxjs != null) {
			result.addAll(resultNewGxjs);
		}
		List<SnjsJkxxb> resultNewGxjsMx = this.ysxxService.doGetSnjsJkxxb(sfdm);
		if(resultNewGxjsMx != null) {
			result.addAll(resultNewGxjsMx);
		}
		
		return result;
	}

	@Override
	public void doUpdateSnjsJkxxb(List<SnjsJkxxb> list) {
		if(list == null || list.isEmpty()) {
			return;
		}
		for(SnjsJkxxb o : list) {
			if("01".equals(o.getXtly())) {
				this.gxjsService.doUpdateSnjsJkxxb(o.getJsrq(), o.getSfdm(), o.getTabname());
			} else if("02".equals(o.getXtly())) {
				this.ywxxService.doUpdateSnjsJkxxb(o.getJsrq(), o.getSfdm(), o.getTabname());
			} else if("03".equals(o.getXtly())) {
				this.ysxxService.doUpdateSnjsJkxxb(o.getJsrq(), o.getSfdm(), o.getTabname());
			} else {
				log.error(String.format("表名未配置：sfdm=%s,tabname=%s",o.getSfdm(), o.getTabname()));
			}
		}
	}

	@Override
	public List<JcJgxxb> getJcJgxxb(String sfdm) {
		return this.ywxxService.getJcJgxxb(sfdm);
	}
	
	public void doDeleteJgxx(String sfdm, List<JcJgxxb> result) {
		this.ywxxService.doDeleteJcJgxxb(sfdm, result);
	}

    @Override
    public List<Tylpcxxb> getTylpcxxb(String sfdm) {
        return this.ywxxService.getTylpcxxb(sfdm);
    }

    @Override
    public void doDeleteTylpcxxb(String sfdm, List<Tylpcxxb> result) {
        this.ywxxService.doDeleteTylpcxxb(sfdm, result);
    }
	@Override
	public List<Tckldzb> getTckldb(String sfdm) {
		return this.ywxxService.getTckldb(sfdm);
	}

	@Override
	public void doDeleteTckldzb(String sfdm, List<Tckldzb> result) {
		this.ywxxService.doDeleteTckldzb(sfdm, result);
	}

	@Override
	public List<Tzbfjxx> getTzbfjxx(String sfdm) {
		return this.ywxxService.getTzbfjxx(sfdm);
	}

	@Override
	public void doDeleteTzbfjxx(String sfdm, List<Tzbfjxx> result) {
		this.ywxxService.doDeleteTzbfjxx(sfdm, result);
	}

	@Override
	public List<Tffqdzb> getTffqdzb(String sfdm) {
		return this.ywxxService.getTffqdzb(sfdm);
	}

	@Override
	public void doDeleteTffqdzb(String sfdm, List<Tffqdzb> result) {
		this.ywxxService.doDeleteTffqdzb(sfdm, result);
	}

	@Override
	public List<Tyjxxb> getTyjxxb(String sfdm) {
		return this.ywxxService.getTyjxxb(sfdm);
	}

	@Override
	public void doDeleteTyjxxb(String sfdm, List<Tyjxxb> result) {
		this.ywxxService.doDeleteTyjxxb(sfdm, result);
	}

	@Override
	public List<JcYjzlxxb> getYjzlxx(String sfdm) {
		return this.ywxxService.getYjzlxx(sfdm);
	}

	@Override
	public void doDeleteJcYjzlxxb(String sfdm, List<JcYjzlxxb> result) {
		this.ywxxService.doDeleteJcYjzlxxb(sfdm, result);	
	}

	@Override
	public List<JcTcjxxb> getJcTcjxx(String sfdm) {
		return this.ywxxService.getJcTcjxx(sfdm);
	}

	@Override
	public void doDeleteJcTcjxxb(String sfdm, List<JcTcjxxb> result) {
		this.ywxxService.doDeleteJcTcjxxb(sfdm, result);
	}

	@Override
	public List<JcYjzldygx> getJcYjzldygx(String sfdm) {
		return this.ywxxService.getJcYjzldygx(sfdm);
	}

	@Override
	public void doDeleteJcYjzldygxb(String sfdm, List<JcYjzldygx> result) {
		this.ywxxService.doDeleteJcYjzldygxb(sfdm, result);
	}

	@Override
	public List<Tyjzljbb> getYjzljbb(String sfdm) {
		return this.ywxxService.getYjzljbb(sfdm);
	}

	@Override
	public void doDeleteYjzljbb(String sfdm, List<Tyjzljbb> result) {
		this.ywxxService.doDeleteYjzljbb(sfdm, result);
		
	}

	@Override
	public List<Tyjzlgsb> getYjzlgsb(String sfdm) {
		return this.ywxxService.getYjzlgsb(sfdm); 
	}

	@Override
	public void doDeleteYjzlgsb(String sfdm, List<Tyjzlgsb> result) {
		this.ywxxService.doDeleteYjzlgsb(sfdm, result);
	}

	@Override
	public List<JcTYjzlb> getTYjzlb(String sfdm) {
		return this.ywxxService.getTYjzlb(sfdm); 
	}

	@Override
	public void doDeleteTYjzlb(String sfdm, List<JcTYjzlb> result) {
		this.ywxxService.doDeleteTYjzlb(sfdm, result);
	}

	@Override
	public List<Tzbjsbhk> getTzbjsbhk(String sfdm) {
		try {
			log.info("get pfysxx_hk sfdm=" + sfdm);
			return ysxxService.getTzbjsbhk(sfdm);
		} catch(Exception e) {
			log.error(e.getMessage(), e);
			return null;
		}
	}

	@Override
	public void doDeleteTzbjsbhk(String sfdm, List<Tzbjsbhk> backlist) {
		try {
			log.info("delete pfysxx_hk sfdm=" + sfdm);
			ysxxService.doDeleteTzbjsbhk(sfdm, backlist);
		} catch(Exception e) {
			log.error(e.getMessage(), e);
		}
	}
/*
	@Override
	public List<Zfgkzfywl> getZfgkzfywl(String sfdm) {
		try {
			log.info("get zfgkzfywl sfdm=" + sfdm);
			return ysxxService.getZfgkzfywl(sfdm);
		} catch(Exception e) {
			log.error(e.getMessage(), e);
			return null;
		}
	}

	@Override
	public void doDeleteZfgkzfywl(String sfdm, List<Zfgkzfywl> backlist) {
		try {
			log.info("delete zfgkzfywl sfdm=" + sfdm);
			ysxxService.doDeleteZfgkzfywl(sfdm, backlist);
		} catch(Exception e) {
			log.error(e.getMessage(), e);
		}
	}

	@Override
	public List<YjsFkhzcmxb> getYjsFkhzcmxb(String sfdm) {
		try {
			log.info("get YjsFkhzcmxb sfdm=" + sfdm);
			return ysxxService.getYjsFkhzcmxb(sfdm);
		} catch(Exception e) {
			log.error(e.getMessage(), e);
			return null;
		}
	}

	@Override
	public void doDeleteYjsFkhzcmxb(String sfdm, List<YjsFkhzcmxb> backlist) {
		try {
			log.info("delete YjsFkhzcmxb sfdm=" + sfdm);
			ysxxService.doDeleteYjsFkhzcmxb(sfdm, backlist);
		} catch(Exception e) {
			log.error(e.getMessage(), e);
		}
	}
	*/

	@Override
	public List<AcJcYlxxb> getAcJcYlxxb(String sfdm) {
		try {
			log.info("get AcJcYlxxb sfdm=" + sfdm);
			return ywxxService.getAcJcYlxxb(sfdm);
		} catch(Exception e) {
			log.error(e.getMessage(), e);
			return null;
		}
	}

	@Override
	public void doDeleteAcJcYlxxb(String sfdm, List<AcJcYlxxb> backlist) {
		try {
			log.info("delete AcJcYlxxb sfdm=" + sfdm);
			ywxxService.doDeleteAcJcYlxxb(sfdm, backlist);
		} catch(Exception e) {
			log.error(e.getMessage(), e);
		}
	}

	@Override
	public List<AcJcZxxxb> getAcJcZxxxb(String sfdm) {
		try {
			log.info("get AcJcZxxxb sfdm=" + sfdm);
			return ywxxService.getAcJcZxxxb(sfdm);
		} catch(Exception e) {
			log.error(e.getMessage(), e);
			return null;
		}
	}

	@Override
	public void doDeleteAcJcZxxxb(String sfdm, List<AcJcZxxxb> backlist) {
		try {
			log.info("delete AcJcZxxxb sfdm=" + sfdm);
			ywxxService.doDeleteAcJcZxxxb(sfdm, backlist);
		} catch(Exception e) {
			log.error(e.getMessage(), e);
		}
	}
	
}
