package yuyu.app.workflow.processkanri.lockkyouseikaijyo;

/**
 * 工程ロック強制解除 - lockedTaskInfoList の 行データBean クラスです。<br />
 * このクラスは手書きのコード変更が行われる可能性があります。
 * ツールの自動生成ファイルを無条件で上書きしないよう注意して下さい。
 */
public class LockedTaskInfoListDataSourceBean extends GenLockedTaskInfoListDataSourceBean {

    private static final long serialVersionUID = 1L;

    public LockedTaskInfoListDataSourceBean() {
    }

    private String kouteiKnrId;

    public String getKouteiKnrId() {
        return kouteiKnrId;
    }

    public void setKouteiKnrId(String pKouteiKnrId) {
        kouteiKnrId = pKouteiKnrId;
    }
    private String flowId;

    public String getFlowId() {
        return flowId;
    }

    public void setFlowId(String pFlowId) {
        flowId = pFlowId;
    }
}
