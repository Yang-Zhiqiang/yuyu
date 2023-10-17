package yuyu.app.biz.bztyouhyou.bztyouhyouikkatu;

/**
 * 帳票一括出力 - searchKeyList の 行データBean クラスです。<br />
 * このクラスは手書きのコード変更が行われる可能性があります。
 * ツールの自動生成ファイルを無条件で上書きしないよう注意して下さい。
 */
public class SearchKeyListDataSourceBean extends GenSearchKeyListDataSourceBean {

    private static final long serialVersionUID = 1L;

    private String reportKey;

    public SearchKeyListDataSourceBean() {
    }

    public String getReportKey() {
        return reportKey;
    }

    public void setReportKey(String pReportKey) {
        reportKey = pReportKey;
    }

}
