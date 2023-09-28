package yuyu.common.base;

import java.io.Serializable;
import java.security.Principal;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import jp.co.slcs.swak.auth.Identity;
import jp.co.slcs.swak.auth.RoleGroup;
import jp.co.slcs.swak.core.configuration.CoreConfig;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import yuyu.common.inject.UserProvider;
import yuyu.def.base.manager.BaseDomManager;
import yuyu.def.db.entity.AM_User;
import yuyu.def.db.entity.AS_Kinou;
import yuyu.infr.auth.AuthenticatedSubSystems;
import yuyu.infr.auth.LoginUser;
import yuyu.infr.auth.RayHttpHeaderBean;
import yuyu.infr.auth.SubSystem;

import com.google.inject.servlet.SessionScoped;

/**
 * ログインユーザーの情報を保持するクラスです。
 */
@SessionScoped
public class BaseUserInfo implements LoginUser, Serializable {

    private static final long serialVersionUID = -4649399258464500644L;

    private AM_User user;

    private String zenkaiLoginTime;

    public String getIdKind() {
        if(CoreConfig.getInstance().isBatchProduct()){
            return null;
        }

        return SWAKInjector.getInstance(RayHttpHeaderBean.class).getIdKind();
    }

    public String getPersonCd() {
        if(CoreConfig.getInstance().isBatchProduct()){
            return null;
        }

        return SWAKInjector.getInstance(RayHttpHeaderBean.class).getPersonCd();
    }

    public String getIssueNum() {
        if(CoreConfig.getInstance().isBatchProduct()){
            return null;
        }

        return SWAKInjector.getInstance(RayHttpHeaderBean.class).getIssueNum();
    }

    public String getPcCd() {
        if(CoreConfig.getInstance().isBatchProduct()){
            return null;
        }

        return SWAKInjector.getInstance(RayHttpHeaderBean.class).getPcCd();
    }

    public String getTmSosikiCd(){
        if(CoreConfig.getInstance().isBatchProduct()){
            return null;
        }

        return SWAKInjector.getInstance(RayHttpHeaderBean.class).getTmSosikiCd();
    }

    public String getTmSosikiNm() {
        if(CoreConfig.getInstance().isBatchProduct()){
            return null;
        }

        return SWAKInjector.getInstance(RayHttpHeaderBean.class).getTmSosikiNm();
    }

    public String getIpAddress() {
        if(CoreConfig.getInstance().isBatchProduct()){
            return null;
        }

        return SWAKInjector.getInstance(RayHttpHeaderBean.class).getIpAddress();
    }

    public String getMachineKind() {
        if(CoreConfig.getInstance().isBatchProduct()){
            return null;
        }

        return SWAKInjector.getInstance(RayHttpHeaderBean.class).getMachineKind();
    }

    public String getNodeNum() {
        if(CoreConfig.getInstance().isBatchProduct()){
            return null;
        }

        return SWAKInjector.getInstance(RayHttpHeaderBean.class).getNodeNum();
    }

    public BaseUserInfo(AM_User pUser) {
        user = pUser;
    }


    public List<String> getAuthenticatedFunctionModes() {

        AS_Kinou kinou = SWAKInjector.getInstance(AS_Kinou.class);
        String functionId = kinou.getKinouId();

        return getAuthenticatedFunctionModes(functionId);

    }

    public List<String> getAuthenticatedFunctionModes(String functionId) {

        if(functionId == null || "".equals(functionId)){
            return new ArrayList<String>();
        }

        List<String> list = new ArrayList<String>();
        List<String> FunctionModesList = getAuthenticatedFunctionAndModes();
        for(String modes :FunctionModesList){
            if(modes.startsWith(functionId + ".")){
                String[] nameArray = modes.split("\\.");
                list.add(nameArray[1]);
            }
        }
        return list;
    }


    private List<String> getAuthenticatedFunctionAndModes() {

        Identity identity = Identity.instance();

        Set<RoleGroup> setGroup =  identity.getSubject().getPrincipals(RoleGroup.class);

        List<String> list = new ArrayList<String>();

        Iterator<RoleGroup> it = setGroup.iterator();

        while (it.hasNext()) {
            RoleGroup role=it.next();
            Enumeration<? extends Principal> members = role.members();
            while(members.hasMoreElements()){
                Principal member = members.nextElement();
                list.add(member.getName());
            }
        }
        return list;
    }

    public List<SubSystem> getAuthenticatedSubSystems(){
        return SWAKInjector.getInstance(AuthenticatedSubSystems.class).getSubSystems();
    }

    public boolean hasAuthenticatedFunctionMode(String ...modeId){

        AS_Kinou kinou = SWAKInjector.getInstance(AS_Kinou.class);
        String functionId = kinou.getKinouId();
        return hasAuthenticatedFunctionModeByFunctionId(functionId, modeId);

    }
    public boolean hasAuthenticatedFunctionModeByFunctionId(String functionId, String... modeId){

        if (functionId == null || modeId == null){
            return false;
        }

        Identity identity = Identity.instance();

        String serchFunctionId = functionId + ".";

        for (String checkModeId : modeId){

            String functionMode = serchFunctionId + checkModeId;

            if(identity.hasRole(functionMode)) {
                return true;
            }
        }
        return false;
    }

    public boolean hasAuthenticatedFunction(AS_Kinou pKinou){
        Identity identity = Identity.instance();
        return identity.hasRole(pKinou.getKinouId());
   }

    public void refresh() {
        setUser(SWAKInjector.getInstance(BaseDomManager.class).getUser(getUserId()));
    }

    @Override
    public String getUserId(){
        return getUser().getUserId();
    }

    @Override
    public String getUserNm() {
        return getUser().getUserNm();
    }

    public String getZenkaiLoginTime() {
        return zenkaiLoginTime;
    }

    public void setZenkaiLoginTime(String pZenkaiLoginTime) {
        zenkaiLoginTime = pZenkaiLoginTime;
    }

    public AM_User getUser() {
        return user;
    }

    private void setUser(AM_User pUser) {
        user = pUser;
    }
}
