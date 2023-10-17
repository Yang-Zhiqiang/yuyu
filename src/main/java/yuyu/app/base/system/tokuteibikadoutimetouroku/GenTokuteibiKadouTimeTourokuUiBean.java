package yuyu.app.base.system.tokuteibikadoutimetouroku;

import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.web.ui.AbstractUiBean;
import jp.co.slcs.swak.web.ui.DataSource;
import yuyu.def.db.entity.AT_TokuteibiKadouTime;

/**
 * 特定日稼働時間登録 : 画面UiBeanの抽象親クラスです。<br />
 * このソースはツールによる自動生成で、画面項目定義の変更に連動して更新されます。
 * 手書きコードを加えないでください。
 */
public abstract class GenTokuteibiKadouTimeTourokuUiBean extends AbstractUiBean {

    private static final long serialVersionUID = 1L;

    @Inject
    private AT_TokuteibiKadouTime tokuteibiKadouTime;

    public AT_TokuteibiKadouTime getTokuteibiKadouTime() {
        return tokuteibiKadouTime;
    }

    public void setTokuteibiKadouTime(AT_TokuteibiKadouTime pTokuteibiKadouTime) {
        tokuteibiKadouTime = pTokuteibiKadouTime;
    }

    private DataSource<KadouTimeGroupListDataSourceBean> kadouTimeGroupListDataSource = new DataSource<>();
    public DataSource<KadouTimeGroupListDataSourceBean> getKadouTimeGroupListDataSource() {
        return kadouTimeGroupListDataSource;
    }

    @Deprecated
    public List<KadouTimeGroupListDataSourceBean> getKadouTimeGroupList() {
        return kadouTimeGroupListDataSource.getDatas();
    }

    public void setKadouTimeGroupList(List<KadouTimeGroupListDataSourceBean> pKadouTimeGroupList) {
        kadouTimeGroupListDataSource.setDatas(pKadouTimeGroupList);
    }

    private DataSource<TokuteibiKadouTimeSelectListDataSourceBean> tokuteibiKadouTimeSelectListDataSource = new DataSource<>();
    public DataSource<TokuteibiKadouTimeSelectListDataSourceBean> getTokuteibiKadouTimeSelectListDataSource() {
        return tokuteibiKadouTimeSelectListDataSource;
    }

    @Deprecated
    public List<TokuteibiKadouTimeSelectListDataSourceBean> getTokuteibiKadouTimeSelectList() {
        return tokuteibiKadouTimeSelectListDataSource.getDatas();
    }

    public void setTokuteibiKadouTimeSelectList(List<TokuteibiKadouTimeSelectListDataSourceBean> pTokuteibiKadouTimeSelectList) {
        tokuteibiKadouTimeSelectListDataSource.setDatas(pTokuteibiKadouTimeSelectList, 10);
    }
}
