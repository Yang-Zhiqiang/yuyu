package yuyu.common.workflowcore.iwfcommon.extension.actionhandler;

import jp.co.slcs.swak.core.logger.LoggerFactory;

import org.apache.commons.lang.StringUtils;
import org.jbpm.graph.def.ActionHandler;
import org.jbpm.graph.exe.ExecutionContext;
import org.slf4j.Logger;

import yuyu.common.workflowcore.core.iwfinfr.util.enumerate.E_TokenVarKey;

/**
 * オートクリエイト時のイベントハンドラーです。 <br />
 * ステートノードの"node-enter"イベントに、当イベントハンドラークラスを設定すると、<br />
 * 自動で他のフローに、トークンを作成します。<br />
 * また、このクラスはjbpm3に依存しています。BPMエンジンの変更に伴い、修正する必要があります。 <br />
 */
public class IwfActionHandler implements ActionHandler {

    private static final long serialVersionUID = 20111117L;

    private static final Logger LOGGER = LoggerFactory.getLogger(IwfActionHandler.class);

    private static final String NODENAME_PREFIX = "Workflow-";

    @Override
    public void execute(ExecutionContext executionContext) throws Exception {

        String sFlowId = getAutocreateFlowId(executionContext.getNode().getName());

        if (!StringUtils.isEmpty(sFlowId)) {
            LOGGER.debug("フローIDをトークン変数に設定します。[FlowId=" + sFlowId + "]");
            executionContext.setVariable(E_TokenVarKey.AUTO_CREATE_FLOWID.key, sFlowId);
        }

        else {
            LOGGER.warn("フローIDの取得に失敗しました。ステートノードに留まることはできないので、トークンを先に進めます。");
            executionContext.leaveNode();
        }

    }

    private static String getAutocreateFlowId(String psNodeName) {
        if(psNodeName.startsWith(NODENAME_PREFIX)){
            return psNodeName.substring(NODENAME_PREFIX.length());
        }
        LOGGER.error("ノード名フォーマットエラーです。オートクリエイト対象のノード名は、\"Workflow-XXXX\"の形式です。[NodeName=" + psNodeName + "]");
        throw new RuntimeException("ノード名フォーマットエラーです。オートクリエイト対象のノード名は、\"Workflow-XXXX\"の形式です。[NodeName=" + psNodeName + "]");
    }

}
