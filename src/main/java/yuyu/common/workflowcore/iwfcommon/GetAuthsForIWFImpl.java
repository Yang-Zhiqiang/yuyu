package yuyu.common.workflowcore.iwfcommon;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import yuyu.def.base.manager.BaseDomManager;
import yuyu.def.db.entity.AM_User;
import yuyu.def.db.entity.AT_UserRole;
import yuyu.def.db.entity.WT_KengenKoutei;
import yuyu.def.db.entity.WT_KengenSyorui;
import yuyu.def.workflowcore.manager.IwfCoreDomManager;

/**
 * ワークフローコア用ロール取得クラス<br />
 */
public class GetAuthsForIWFImpl implements GetAuthsForIWF {

    @Override
    public Set<List<String>> getAuthsByUserIdForKengenKoutei(String pUserId) {

        String[] roleCds = getRoleCdsByUserId(pUserId).toArray(new String[0]);
        Set<List<String>> authsProcess = new HashSet<>();

        if (roleCds.length > 0) {
            List<WT_KengenKoutei> kengenKouteiList = SWAKInjector.getInstance(IwfCoreDomManager.class).getKengenKouteisByRoleCds(roleCds);

            if (!kengenKouteiList.isEmpty()) {
                for (WT_KengenKoutei wT_KengenKoutei : kengenKouteiList) {
                    List<String> flowNodeId = new ArrayList<String>();
                    flowNodeId.add(wT_KengenKoutei.getFlowId());
                    flowNodeId.add(wT_KengenKoutei.getNodeId());
                    authsProcess.add(flowNodeId);
                }
            }

        }
        return authsProcess;
    }

    @Override
    public Set<String> getAuthsByUserIdForKengenSyorui(String pUserId) {

        String[] roleCds = getRoleCdsByUserId(pUserId).toArray(new String[0]);
        Set<String> authsSyorui = new HashSet<>();

        if (roleCds.length > 0) {
            List<WT_KengenSyorui> kengenSyoruiList = SWAKInjector.getInstance(IwfCoreDomManager.class).getKengenSyoruisByRoleCds(roleCds);

            if (!kengenSyoruiList.isEmpty()) {
                for (WT_KengenSyorui wT_KengenSyorui : kengenSyoruiList) {
                    authsSyorui.add(wT_KengenSyorui.getTorikomiSyoruiCd());
                }
            }
        }
        return authsSyorui;
    }

    private List<String> getRoleCdsByUserId(String pUserId){

        List<String> roleCds = new ArrayList<String>();

        AM_User user = SWAKInjector.getInstance(BaseDomManager.class).getUser(pUserId);
        if (null == user) {
            return roleCds;
        }

        List<AT_UserRole> userRoles = user.getUserRoles();

        if (null != userRoles && !userRoles.isEmpty()) {
            for (AT_UserRole role : userRoles) {
                roleCds.add(role.getRoleCd());
            }
        }
        return roleCds;
    }
}