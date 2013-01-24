package cn.freeteam.action;

import java.util.List;


import cn.freeteam.base.BaseAction;
import cn.freeteam.cms.model.RoleSite;
import cn.freeteam.cms.model.Site;
import cn.freeteam.cms.service.RoleSiteService;
import cn.freeteam.cms.service.SiteService;
import cn.freeteam.dao.FuncMapper;
import cn.freeteam.model.Func;
import cn.freeteam.service.FuncService;


/**
 * 
 * <p>Title: AdminAction.java</p>
 * 
 * <p>Description: 后台管理相关操作</p>
 * 
 * <p>Date: Dec 16, 2011</p>
 * 
 * <p>Time: 4:43:12 PM</p>
 * 
 * <p>Copyright: 2011</p>
 * 
 * <p>Company: freeteam</p>
 * 
 * @author freeteam
 * @version 1.0
 * 
 * <p>============================================</p>
 * <p>Modification History
 * <p>Mender: </p>
 * <p>Date: </p>
 * <p>Reason: </p>
 * <p>============================================</p>
 */
public class AdminAction extends BaseAction{

	private List<Func> funcList;
	private FuncService funcService;
	private SiteService siteService;
	private RoleSiteService roleSiteService;
	
	private String siteid;
	
	public AdminAction(){
		init("funcService","siteService","roleSiteService");
	}
	/**
	 * 后台首页左边页面
	 */
	public String left(){
		//先清除session变量
		getHttpSession().removeAttribute("manageSite");
		getHttpSession().removeAttribute("siteAdmin");
		Site manageSite=null;
		if (siteid!=null && siteid.trim().length()>0) {
			//指定管理站点
			manageSite=siteService.findById(siteid);
		}else {
			if (getHttpSession().getAttribute("manageSite")!=null) {
				manageSite=(Site)getHttpSession().getAttribute("manageSite");
			}else {
				//未指定管理站点
				if (isAdminLogin()) {
					//提取一级站点
					manageSite=siteService.selectFirstByParId( "");
				}else {
					//普通用户只提取有自己有权限的站点
					manageSite=siteService.selectFirstByRoles( getLoginRoleIdsSql());
				}
			}
		}
		getHttpSession().setAttribute("manageSite", manageSite);
		//如果是admin则显示所有一级菜单
		if (isAdminLogin()) {
			funcList=funcService.selectRoot();
			getHttpSession().setAttribute("siteAdmin", true);
		}else {
			if (manageSite!=null) {
				//判断是否是站点管理员
				RoleSite roleSite=roleSiteService.findBySiteRoles(manageSite.getId(), getLoginRoleIdsSql(),"1");
				if (roleSite!=null) {
					getHttpSession().setAttribute("siteAdmin", true);
				}
			}
			funcList=funcService.selectRootAuth(getLoginAdmin().getId());
		}
		//设置是否有子数据
		if (funcList!=null && funcList.size()>0) {
			for (int i = 0; i < funcList.size(); i++) {
				if (funcService.haveSon(funcList.get(i).getId())) {
					funcList.get(i).setHasChildren("1");
				}
			}
		}
		return "left";
	}
	
	
	
	public List<Func> getFuncList() {
		return funcList;
	}
	public void setFuncList(List<Func> funcList) {
		this.funcList = funcList;
	}



	public FuncService getFuncService() {
		return funcService;
	}



	public void setFuncService(FuncService funcService) {
		this.funcService = funcService;
	}
	public String getSiteid() {
		return siteid;
	}
	public void setSiteid(String siteid) {
		this.siteid = siteid;
	}
	public SiteService getSiteService() {
		return siteService;
	}
	public void setSiteService(SiteService siteService) {
		this.siteService = siteService;
	}
	public RoleSiteService getRoleSiteService() {
		return roleSiteService;
	}
	public void setRoleSiteService(RoleSiteService roleSiteService) {
		this.roleSiteService = roleSiteService;
	}
	
}