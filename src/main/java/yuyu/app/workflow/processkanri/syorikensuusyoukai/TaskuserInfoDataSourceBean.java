package yuyu.app.workflow.processkanri.syorikensuusyoukai;

/**
 * 処理件数照会 - taskuserInfo の 行データBean クラスです。<br />
 * このクラスは手書きのコード変更が行われる可能性があります。
 * ツールの自動生成ファイルを無条件で上書きしないよう注意して下さい。
 */
public class TaskuserInfoDataSourceBean extends GenTaskuserInfoDataSourceBean {

    private static final long serialVersionUID = 1L;

    public TaskuserInfoDataSourceBean() {
    }

    public String jimutetuzukiCd = "";

    public String getJimutetuzukiCd() {
        return jimutetuzukiCd;
    }

    public void setJimutetuzukiCd(String pjimutetuzukiCd) {
        jimutetuzukiCd = pjimutetuzukiCd;
    }


}
