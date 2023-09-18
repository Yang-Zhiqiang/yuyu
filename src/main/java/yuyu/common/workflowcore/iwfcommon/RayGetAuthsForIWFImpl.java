package yuyu.common.workflowcore.iwfcommon;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import jp.co.slcs.swak.core.configuration.CoreConfig;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.webservice.config.WebServiceConfig;
import yuyu.common.base.BaseUserInfo;
import yuyu.common.biz.bzcommon.RayTmSosikiUtil;
import yuyu.def.base.manager.BaseDomManager;
import yuyu.def.db.entity.AT_SosikiRole;
import yuyu.def.db.entity.WT_KengenKoutei;
import yuyu.def.workflowcore.manager.IwfCoreDomManager;

/**
 * ワークフローコア用ロール取得クラス(Ｓ社固有)<br />
 */
public class RayGetAuthsForIWFImpl extends GetAuthsForIWFImpl {

    @Override
    public Set<List<String>> getAuthsByUserIdForKengenKoutei(String pUserId) {

        Set<List<String>> userKengenSet = super.getAuthsByUserIdForKengenKoutei(pUserId);

        if(isUnnecessaryTanmatuSettiSosiki(pUserId)){
            return userKengenSet;
        }

        String[] sosikiRoleCds = getRoleCdsBySosikiCd(SWAKInjector.getInstance(BaseUserInfo.class).getTmSosikiCd()).toArray(new String[0]);
        List<WT_KengenKoutei> sosikiKengenList = SWAKInjector.getInstance(IwfCoreDomManager.class).getKengenKouteisByRoleCds(sosikiRoleCds);

        Set<List<String>> sosikiKengenSet = new HashSet<List<String>>();
        if (!sosikiKengenList.isEmpty()) {
            for (WT_KengenKoutei wT_KengenKoutei : sosikiKengenList) {
                List<String> flowNodeId = new ArrayList<String>();
                flowNodeId.add(wT_KengenKoutei.getFlowId());
                flowNodeId.add(wT_KengenKoutei.getNodeId());
                sosikiKengenSet.add(flowNodeId);
            }
        }

        Set<List<String>> conformingKengenSet = new HashSet<List<String>>();
        for(List<String> flowNodeId : userKengenSet ){
            if(sosikiKengenSet.contains(flowNodeId)){
                conformingKengenSet.add(flowNodeId);
            }
        }
        return conformingKengenSet;
    }

    private List<String> getRoleCdsBySosikiCd(String pSosikiCd){

        List<String> roleCds = new ArrayList<String>();

        List<AT_SosikiRole> sosikiRoles = SWAKInjector.getInstance(BaseDomManager.class).getSosikiRolesByTanmatusettisosikicd(RayTmSosikiUtil.getTmSosikiCd(pSosikiCd));

        if (null != sosikiRoles && !sosikiRoles.isEmpty()) {
            for (AT_SosikiRole role : sosikiRoles) {
                roleCds.add(role.getRoleCd());
            }
        }
        return roleCds;
    }

    private boolean isUnnecessaryTanmatuSettiSosiki(String pUserId){

        BaseUserInfo userInfo = SWAKInjector.getInstance(BaseUserInfo.class);

        return !userInfo.getUserId().equals(pUserId)
            || CoreConfig.getInstance().isBatchProduct()
            || WebServiceConfig.getInstance().getProvideUserId().equals(pUserId);
    }
}