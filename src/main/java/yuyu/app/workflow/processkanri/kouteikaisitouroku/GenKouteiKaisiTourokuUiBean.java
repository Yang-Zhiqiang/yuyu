package yuyu.app.workflow.processkanri.kouteikaisitouroku;

import java.util.List;

import jp.co.slcs.swak.web.ui.AbstractUiBean;
import jp.co.slcs.swak.web.ui.DataSource;

/**
 * 工程開始登録 : 画面UiBeanの抽象親クラスです。<br />
 * このソースはツールによる自動生成で、画面項目定義の変更に連動して更新されます。
 * 手書きコードを加えないでください。
 */
public abstract class GenKouteiKaisiTourokuUiBean extends AbstractUiBean {

    private static final long serialVersionUID = 1L;

    private DataSource<TorokuInfo1DataSourceBean> torokuInfo1DataSource = new DataSource<>();
    public DataSource<TorokuInfo1DataSourceBean> getTorokuInfo1DataSource() {
        return torokuInfo1DataSource;
    }

    @Deprecated
    public List<TorokuInfo1DataSourceBean> getTorokuInfo1() {
        return torokuInfo1DataSource.getDatas();
    }

    public void setTorokuInfo1(List<TorokuInfo1DataSourceBean> pTorokuInfo1) {
        torokuInfo1DataSource.setDatas(pTorokuInfo1);
    }

    private DataSource<TorokuInfo2DataSourceBean> torokuInfo2DataSource = new DataSource<>();
    public DataSource<TorokuInfo2DataSourceBean> getTorokuInfo2DataSource() {
        return torokuInfo2DataSource;
    }

    @Deprecated
    public List<TorokuInfo2DataSourceBean> getTorokuInfo2() {
        return torokuInfo2DataSource.getDatas();
    }

    public void setTorokuInfo2(List<TorokuInfo2DataSourceBean> pTorokuInfo2) {
        torokuInfo2DataSource.setDatas(pTorokuInfo2);
    }

    private String modorubtn;

    public String getModorubtn() {
        return modorubtn;
    }

    public void setModorubtn(String pModorubtn) {
        modorubtn = pModorubtn;
    }
}
