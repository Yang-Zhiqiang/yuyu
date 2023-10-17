package yuyu.app.siharai.sisyoukai.sittzkrirekisyoukai;

/**
 * 手続履歴照会 - searchResults の 行データBean クラスです。<br />
 * このクラスは手書きのコード変更が行われる可能性があります。
 * ツールの自動生成ファイルを無条件で上書きしないよう注意して下さい。
 */
public class SearchResultsDataSourceBean extends GenSearchResultsDataSourceBean {

    private static final long serialVersionUID = 1L;

    public SearchResultsDataSourceBean() {
    }

    private String dispskno;

    public String getDispskno() {
        return dispskno;
    }

    public void setDispskno(String pDispskno) {
        this.dispskno = pDispskno;
    }

    private String disphhknnmkj;

    public String getDisphhknnmkj() {
        return disphhknnmkj;
    }

    public void setDisphhknnmkj(String pDisphhknnmkj) {
        this.disphhknnmkj = pDisphhknnmkj;
    }

    private String dispuktnmkj;

    public String getDispuktnmkj() {
        return dispuktnmkj;
    }

    public void setDispuktnmkj(String pDispuktnmkj) {
        this.dispuktnmkj = pDispuktnmkj;
    }
}
