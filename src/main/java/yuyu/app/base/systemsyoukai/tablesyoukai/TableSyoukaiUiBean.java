package yuyu.app.base.systemsyoukai.tablesyoukai;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import jp.co.slcs.swak.web.conversation.annotations.ConversationScoped;
import jp.co.slcs.swak.web.ui.DataSource;
import lombok.Getter;
import lombok.Setter;

/**
 * テーブル照会 の画面UiBeanクラスです。<br />
 * このクラスは手書きのコード変更が行われる可能性があります。
 * ツールの自動生成ファイルを無条件で上書きしないよう注意して下さい。
 */
@ConversationScoped
public class TableSyoukaiUiBean extends GenTableSyoukaiUiBean {

    private static final long serialVersionUID = 1L;

    @Getter @Setter
    private String bkSelectTableId;

    @Getter @Setter
    private String bkSelectTableNm;

    @Getter @Setter
    private  Map<String, Integer> fieldsSortNoMap;

    @Getter @Setter
    private int columnCount;

    @Getter @Setter
    private Map<String, Map<String, TableDDInfoBean>> tableDdNmMap = null;

    @Getter @Setter
    private Set<String> searchFieldSet = new HashSet<>();

    @Getter
    private DataSource<FieldsListDataSourceBean> fieldsBkDataSource = new DataSource<>();

    @Deprecated
    public List<FieldsListDataSourceBean> getFieldsBk() {
        return fieldsBkDataSource.getDatas();
    }

    public void setFieldsBk(List<FieldsListDataSourceBean> fieldsBk) {
        fieldsBkDataSource.setDatas(fieldsBk);
    }

    @Getter
    private DataSource<ResultsListDataSourceBean> resultsBkDataSource = new DataSource<>();

    @Deprecated
    public List<ResultsListDataSourceBean> getResultsBk() {
        return resultsBkDataSource.getDatas();
    }

    public void setResultsBk(List<ResultsListDataSourceBean> resultsBk) {
        resultsBkDataSource.setDatas(resultsBk);
    }

    private String tokenBk;

    public String getTokenBk() {
        return tokenBk;
    }

    public void setTokenBk(String timeStamp) {
        this.tokenBk = timeStamp;
    }

}
