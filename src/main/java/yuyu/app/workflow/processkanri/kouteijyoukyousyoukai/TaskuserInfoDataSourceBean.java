package yuyu.app.workflow.processkanri.kouteijyoukyousyoukai;

/**
 * 工程状況照会 - taskuserInfo の 行データBean クラスです。<br />
 * このクラスは手書きのコード変更が行われる可能性があります。
 * ツールの自動生成ファイルを無条件で上書きしないよう注意して下さい。
 */
public class TaskuserInfoDataSourceBean extends GenTaskuserInfoDataSourceBean {

    private static final long serialVersionUID = 1L;

    private String kouteiKnrId;

    public String getKouteiKnrId() {
        return kouteiKnrId;
    }

    public void setKouteiKnrId(String pKouteiKnrId) {
        kouteiKnrId = pKouteiKnrId;
    }

    private String JimutetuzukiCd;

    public String getJimutetuzukiCd() {
        return JimutetuzukiCd;
    }

    public void setJimutetuzukiCd(String pJimutetuzukiCd) {
        JimutetuzukiCd = pJimutetuzukiCd;
    }

    public TaskuserInfoDataSourceBean() {
    }

}
