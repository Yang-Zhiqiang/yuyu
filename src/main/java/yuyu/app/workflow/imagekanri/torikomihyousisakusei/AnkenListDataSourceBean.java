package yuyu.app.workflow.imagekanri.torikomihyousisakusei;

/**
 * 取込用表紙作成 - ankenList の 行データBean クラスです。<br />
 * このクラスは手書きのコード変更が行われる可能性があります。
 * ツールの自動生成ファイルを無条件で上書きしないよう注意して下さい。
 */
public class AnkenListDataSourceBean extends GenAnkenListDataSourceBean {

    private static final long serialVersionUID = 1L;

    public AnkenListDataSourceBean() {
    }

    private String dispkouteistatus;

    public String getDispkouteistatus() {
        return dispkouteistatus;
    }

    public void setDispkouteistatus(String pDispkouteistatus) {
        dispkouteistatus = pDispkouteistatus;
    }

    private String kouteiKnrId;

    public String getKouteiKnrId() {
        return kouteiKnrId;
    }

    public void setKouteiKnrId(String kouteiKnrId) {
        this.kouteiKnrId = kouteiKnrId;
    }

    private String jimutetuzukicd;

    public String getJimutetuzukicd() {
        return jimutetuzukicd;
    }

    public void setJimutetuzukicd(String pJimutetuzukicd) {
        jimutetuzukicd = pJimutetuzukicd;
    }
}
