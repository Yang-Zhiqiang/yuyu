package yuyu.app.hozen.khhubikanri.khhubitouroku;

/**
 * 契約保全不備登録 - selectDataList の 行データBean クラスです。<br />
 * このクラスは手書きのコード変更が行われる可能性があります。
 * ツールの自動生成ファイルを無条件で上書きしないよう注意して下さい。
 */
public class SelectDataListDataSourceBean extends GenSelectDataListDataSourceBean {

    private static final long serialVersionUID = 1L;

    private String jimuttzkCd;

    private String hubiSikibetuKey;

    private String nowNodeId;

    public SelectDataListDataSourceBean() {
    }

    public String getJimuttzkCd() {
        return jimuttzkCd;
    }

    public void setJimuttzkCd(String pJimuttzkCd) {
        jimuttzkCd = pJimuttzkCd;
    }

    public String getHubiSikibetuKey() {
        return hubiSikibetuKey;
    }

    public void setHubiSikibetuKey(String pHubiSikibetuKey) {
        hubiSikibetuKey = pHubiSikibetuKey;
    }

    public String getNowNodoId() {
        return nowNodeId;
    }

    public void setNowNodoId(String pNowNodoId) {
        nowNodeId = pNowNodoId;
    }
}
