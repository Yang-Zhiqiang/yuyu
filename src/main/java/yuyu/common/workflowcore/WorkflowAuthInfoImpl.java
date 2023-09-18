package yuyu.common.workflowcore;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import yuyu.common.base.BaseUserInfo;
import yuyu.common.workflowcore.iwfcommon.GetAuthsForIWF;

/**
 * ワークフロー権限（工程権限、書類権限）判定サービスのメインクラス<br />
 */
public class WorkflowAuthInfoImpl implements WorkflowAuthInfo,Serializable {

    private static final long serialVersionUID = 1L;

    protected Set<List<String>> authedProcess = new HashSet<List<String>>();
    protected Set<String> authedImage = new HashSet<String>();

    public WorkflowAuthInfoImpl() {
        init();
    }

    private void init() {
        String userId = SWAKInjector.getInstance(BaseUserInfo.class).getUserId();

        authedProcess = SWAKInjector.getInstance(GetAuthsForIWF.class).getAuthsByUserIdForKengenKoutei(userId);
        authedImage = SWAKInjector.getInstance(GetAuthsForIWF.class).getAuthsByUserIdForKengenSyorui(userId);
    }

    @Override
    public Set<List<String>> getProcessAuth() {
        return authedProcess;
    }

    @Override
    public Set<String> getImageAuth() {
        return authedImage;
    }

    @Override
    public Set<List<String>> getProcessAuthByUserId(String userId) {
        return SWAKInjector.getInstance(GetAuthsForIWF.class).getAuthsByUserIdForKengenKoutei(userId);
    }

    @Override
    public Set<String> getImageAuthByUserId(String userId) {
        return SWAKInjector.getInstance(GetAuthsForIWF.class).getAuthsByUserIdForKengenSyorui(userId);
    }

    @Override
    public boolean hasProcessAuth(String flowId, String nodeId) {
        boolean isHasAuthed = false;

        if (authedProcess.isEmpty()) {
            return isHasAuthed;
        }

        for (List<String> processAuth : authedProcess) {
            if (processAuth.get(0).equals(flowId) && processAuth.get(1).equals(nodeId)) {
                isHasAuthed = true;
                break;
            }
        }
        return isHasAuthed;
    }

    @Override
    public boolean hasImageAuth(String torikomiSyoruiCd) {
        return authedImage.contains(torikomiSyoruiCd);
    }
}
