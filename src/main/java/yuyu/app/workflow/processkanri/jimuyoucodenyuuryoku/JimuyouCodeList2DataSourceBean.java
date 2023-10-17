package yuyu.app.workflow.processkanri.jimuyoucodenyuuryoku;

/**
 * 事務用コード入力 - jimuyouCodeList2 の 行データBean クラスです。<br />
 * このクラスは手書きのコード変更が行われる可能性があります。
 * ツールの自動生成ファイルを無条件で上書きしないよう注意して下さい。
 */
public class JimuyouCodeList2DataSourceBean extends GenJimuyouCodeList2DataSourceBean {

    private static final long serialVersionUID = 1L;

    public JimuyouCodeList2DataSourceBean() {
    }

    private String kouteiKnrId;

    public String getKouteiKnrId() {
        return kouteiKnrId;
    }

    public void setKouteiKnrId(String pKouteiKnrId) {
        this.kouteiKnrId = pKouteiKnrId;
    }

}
