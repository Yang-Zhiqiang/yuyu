package yuyu.common.workflowcore.iwfcommon.extension.decisionhandler;

public interface WSBunkiHantei {

    abstract WSBunkiHanteiResponse executeBizMain(WSBunkiHanteiRequest request) throws Exception;
}