package yuyu.app.sinkeiyaku.skkettei.skketteiriyuu;

import java.util.List;
import jp.co.slcs.swak.web.ui.AbstractUiBean;
import jp.co.slcs.swak.web.ui.DataSource;

/**
 * 決定理由一覧 : 画面UiBeanの抽象親クラスです。<br />
 * このソースはツールによる自動生成で、画面項目定義の変更に連動して更新されます。
 * 手書きコードを加えないでください。
 */
public abstract class GenSkKetteiRiyuuUiBean extends AbstractUiBean {

    private static final long serialVersionUID = 1L;

    private DataSource<KetteiriyuuListDataSourceBean> ketteiriyuuListDataSource = new DataSource<>();
    public DataSource<KetteiriyuuListDataSourceBean> getKetteiriyuuListDataSource() {
        return ketteiriyuuListDataSource;
    }

    @Deprecated
    public List<KetteiriyuuListDataSourceBean> getKetteiriyuuList() {
        return ketteiriyuuListDataSource.getDatas();
    }

    public void setKetteiriyuuList(List<KetteiriyuuListDataSourceBean> pKetteiriyuuList) {
        ketteiriyuuListDataSource.setDatas(pKetteiriyuuList);
    }
}
