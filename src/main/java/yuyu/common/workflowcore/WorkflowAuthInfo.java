package yuyu.common.workflowcore;

import java.util.List;
import java.util.Set;

/**
 */
public interface WorkflowAuthInfo {

    abstract Set<List<String>> getProcessAuth();

    abstract Set<String> getImageAuth();

    abstract Set<List<String>> getProcessAuthByUserId(String userId);

    abstract Set<String> getImageAuthByUserId(String userId);

    abstract boolean hasProcessAuth(String flowId, String nodeId);

    abstract boolean hasImageAuth(String torikomiSyoruiCd);
}
