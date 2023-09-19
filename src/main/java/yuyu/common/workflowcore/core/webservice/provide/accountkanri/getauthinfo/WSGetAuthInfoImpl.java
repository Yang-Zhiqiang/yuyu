package yuyu.common.workflowcore.core.webservice.provide.accountkanri.getauthinfo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.core.inject.SWAKInjector;

import org.apache.commons.lang.StringUtils;

import yuyu.common.workflowcore.core.iwfinfr.util.IwfEditMessageUtil;
import yuyu.common.workflowcore.core.iwfinfr.util.IwfMessageCd;
import yuyu.common.workflowcore.core.iwfinfr.util.IwfMessageUtil;
import yuyu.common.workflowcore.core.webservice.provide.accountkanri.getauthinfo.WSGetAuthInfoResponse.AuthInfoBean;
import yuyu.common.workflowcore.iwfcommon.CheckException;
import yuyu.def.base.manager.BaseDomManager;
import yuyu.def.classification.C_ResultCdKbn;
import yuyu.def.db.entity.AM_Role;
import yuyu.def.db.entity.WT_KengenKoutei;
import yuyu.def.db.entity.WT_KengenSyorui;
import yuyu.def.workflowcore.manager.IwfCoreDomManager;


/**
 * 権限情報取得サービスのメインクラスです。<br />
 */
public class WSGetAuthInfoImpl implements WSGetAuthInfo{

    @Inject
    private IwfCoreDomManager iwfCoreDomManager;

    @Inject
    private BaseDomManager baseDomManager;

    public String getServiceName() {
        return WSGetAuthInfoRequest.sSERVICE_NAME;
    }

    public WSGetAuthInfoResponse validate(WSGetAuthInfoRequest poRequest) throws Exception {

        return null;
    }


    @Override
    public WSGetAuthInfoResponse executeBizMain(WSGetAuthInfoRequest poRequest) throws Exception {

        WSGetAuthInfoResponse oWSResponse = new WSGetAuthInfoResponse();

        String sAuthid = poRequest.getAuthid();
        String sFlowid = poRequest.getFlowid();
        String sNodeid = poRequest.getNodeid();
        String sTorikomisyoruicd = poRequest.getTorikomisyoruicd();

        try {

            AM_Role role = new AM_Role();

            role = baseDomManager.getRole(sAuthid);

            ArrayList<AuthInfoBean> authtInfos = new ArrayList<AuthInfoBean>();

            AuthInfoBean authInfoBean = new AuthInfoBean();

            ArrayList<String>   oFlowIds     = new ArrayList<String>();
            ArrayList<String>   oNodeIds     = new ArrayList<String>();
            ArrayList<String>   oTrikomiSyoruiCds     = new ArrayList<String>();

            if(StringUtils.isNotEmpty(role.getRoleCd())){

                String sRoleCd = role.getRoleCd();
                String sRoleName = role.getRoleNm();

                WT_KengenKoutei koutei = iwfCoreDomManager.getKengenKoutei(sRoleCd, sFlowid, sNodeid);

                oFlowIds     = new ArrayList<String>();
                oNodeIds     = new ArrayList<String>();

                oFlowIds.add(koutei.getFlowId());
                oNodeIds.add(koutei.getNodeId());

                List<WT_KengenSyorui> syoruiList = iwfCoreDomManager.getKengenSyoruisByRoleCd(sRoleCd);

                Iterator<WT_KengenSyorui> itrSyorui = syoruiList.iterator();
                while(itrSyorui.hasNext()){
                    WT_KengenSyorui syorui = itrSyorui.next();
                    oTrikomiSyoruiCds.add(syorui.getTorikomiSyoruiCd());
                }

                authInfoBean = new AuthInfoBean();

                if(((StringUtils.isEmpty(sFlowid) || oFlowIds.contains(sFlowid)) &&
                    (StringUtils.isEmpty(sNodeid) || oNodeIds.contains(sNodeid)) &&
                    (StringUtils.isEmpty(sTorikomisyoruicd) || oTrikomiSyoruiCds.contains(sTorikomisyoruicd)))||
                    (StringUtils.isEmpty(sFlowid) && StringUtils.isEmpty(sNodeid) && StringUtils.isEmpty(sTorikomisyoruicd))){
                    authInfoBean.setAuthid(sRoleCd);
                    authInfoBean.setAuthname(sRoleName);
                    authInfoBean.setFlowids(oFlowIds.toArray(new String[0]));
                    authInfoBean.setNodeids(oNodeIds.toArray(new String[0]));
                    authInfoBean.setTorikomisyoruicds(oTrikomiSyoruiCds.toArray(new String[0]));

                    authtInfos.add(authInfoBean);
                }

                if(authtInfos.isEmpty()){
                    IwfEditMessageUtil.setMsgResultNG_RecordNotFound(oWSResponse, WT_KengenKoutei.TABLE_NAME);

                    return oWSResponse;
                }

                oWSResponse.setAuthinfos(authtInfos);

            } else {
                IwfEditMessageUtil.setMsgResultNG_RecordNotFound(oWSResponse, AM_Role.TABLE_NAME);

                return oWSResponse;
            }

            IwfEditMessageUtil.setMsgResultOK(oWSResponse, "権限情報取得");
        } catch (Exception e) {
            e.printStackTrace();

            if(SWAKInjector.getInstance(CheckException.class).isExceptionShouldThrow(e)){
                throw e;
            }

            IwfEditMessageUtil.setMsgResultNG(oWSResponse, IwfMessageCd.IWF0001, "権限情報取得");
        }
        return oWSResponse;
    }


    public WSGetAuthInfoResponse getStubResult(WSGetAuthInfoRequest poRequest) throws Exception {
        return null;
    }


    public WSGetAuthInfoResponse getBootErrResponse() {
        WSGetAuthInfoResponse res = new WSGetAuthInfoResponse();
        res.setKekkastatus(C_ResultCdKbn.OK.getValue());
        res.setSyousaimsgcd(IwfMessageCd.IWF0003.toString());
        res.setSyousaimsg(IwfMessageUtil.getMessage(IwfMessageCd.IWF0003));
        return res;
    }
}
