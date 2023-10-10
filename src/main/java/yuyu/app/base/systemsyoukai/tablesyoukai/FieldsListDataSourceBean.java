package yuyu.app.base.systemsyoukai.tablesyoukai;

/**
 * テーブル照会 - fieldsList の 行データBean クラスです。<br />
 * このクラスは手書きのコード変更が行われる可能性があります。
 * ツールの自動生成ファイルを無条件で上書きしないよう注意して下さい。
 */
public class FieldsListDataSourceBean extends GenFieldsListDataSourceBean {

    private static final long serialVersionUID = 1L;

    public FieldsListDataSourceBean() {
    }

    public FieldsListDataSourceBean(int colIndex, String fieldName) {
        setBaseColNo(colIndex);
        setBaseFieldNm(fieldName);
    }

}
