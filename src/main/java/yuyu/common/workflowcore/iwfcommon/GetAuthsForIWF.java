package yuyu.common.workflowcore.iwfcommon;

import java.util.List;
import java.util.Set;

public interface GetAuthsForIWF {

    abstract Set<List<String>> getAuthsByUserIdForKengenKoutei(String pUserId);

    abstract Set<String> getAuthsByUserIdForKengenSyorui(String pUserId);

}