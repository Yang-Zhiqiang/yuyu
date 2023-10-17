package yuyu.app.siharai.sihubikanri.sihubitouroku;

/**
 * 保険金給付金不備登録 - selectDataList の 行データBean クラスです。<br />
 * このクラスは手書きのコード変更が行われる可能性があります。
 * ツールの自動生成ファイルを無条件で上書きしないよう注意して下さい。
 */
public class SelectDataListDataSourceBean extends GenSelectDataListDataSourceBean {

    private static final long serialVersionUID = 1L;

    private String jimutetuzukicd;

    private String hubiSikibetuKey;

    public SelectDataListDataSourceBean() {
    }

    public String getJimutetuzukicd() {
        return jimutetuzukicd;
    }

    public void setJimutetuzukicd(String pJimutetuzukicd) {
        jimutetuzukicd = pJimutetuzukicd;
    }

    public String getHubiSikibetuKey() {
        return hubiSikibetuKey;
    }

    public void setHubiSikibetuKey(String pHubiSikibetuKey) {
        hubiSikibetuKey = pHubiSikibetuKey;
    }

}
