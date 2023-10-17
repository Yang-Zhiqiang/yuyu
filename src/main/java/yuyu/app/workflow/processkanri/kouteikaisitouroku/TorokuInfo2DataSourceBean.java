package yuyu.app.workflow.processkanri.kouteikaisitouroku;

/**
 * 工程開始登録 - torokuInfo2 の 行データBean クラスです。<br />
 * このクラスは手書きのコード変更が行われる可能性があります。
 * ツールの自動生成ファイルを無条件で上書きしないよう注意して下さい。
 */
public class TorokuInfo2DataSourceBean extends GenTorokuInfo2DataSourceBean {

    private static final long serialVersionUID = 1L;

    private String kouteikanriId;

    public TorokuInfo2DataSourceBean() {
    }

    public String getKouteikanriId() {
        return kouteikanriId;
    }

    public void setKouteikanriId(String pKouteikanriId) {
        kouteikanriId = pKouteikanriId;
    }
}
