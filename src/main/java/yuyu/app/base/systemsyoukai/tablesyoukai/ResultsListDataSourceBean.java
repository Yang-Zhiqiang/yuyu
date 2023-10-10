package yuyu.app.base.systemsyoukai.tablesyoukai;

/**
 * テーブル照会 - resultsList の 行データBean クラスです。<br />
 * このクラスは手書きのコード変更が行われる可能性があります。
 * ツールの自動生成ファイルを無条件で上書きしないよう注意して下さい。
 */
public class ResultsListDataSourceBean extends GenResultsListDataSourceBean {

    private static final long serialVersionUID = 1L;

    public ResultsListDataSourceBean() {
    }

    public ResultsListDataSourceBean(int rowIndex, int colIndex, String fieldValue) {
        setBaseRowNo(rowIndex);
        setBaseColNo(colIndex);
        setBaseFieldValue(fieldValue);
    }

}
