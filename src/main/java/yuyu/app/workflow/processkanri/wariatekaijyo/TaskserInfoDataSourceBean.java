package yuyu.app.workflow.processkanri.wariatekaijyo;

/**
 * 担当者割当解除 - taskserInfo の 行データBean クラスです。<br />
 * このクラスは手書きのコード変更が行われる可能性があります。
 * ツールの自動生成ファイルを無条件で上書きしないよう注意して下さい。
 */
public class TaskserInfoDataSourceBean extends GenTaskserInfoDataSourceBean {

    private static final long serialVersionUID = 1L;

    public TaskserInfoDataSourceBean() {
    }

    private String disptantouid;

    public String getDisptantouid() {
        return disptantouid;
    }

    public void setDisptantouid(String disptantouid) {
        this.disptantouid = disptantouid;
    }

    private String kouteiKnrId;

    public String getKouteiKnrId() {
        return kouteiKnrId;
    }

    public void setKouteiKnrId(String pKouteiKnrId) {
        kouteiKnrId = pKouteiKnrId;
    }

    private String jimutetuzukiCd;

    public String getJimutetuzukiCd() {
        return jimutetuzukiCd;
    }

    public void setJimutetuzukiCd(String pJimutetuzukiCd) {
        jimutetuzukiCd = pJimutetuzukiCd;
    }

    private String taskNm;

    public String getTaskNm() {
        return taskNm;
    }

    public void setTaskNm(String pTaskNm) {
        taskNm = pTaskNm;
    }


}