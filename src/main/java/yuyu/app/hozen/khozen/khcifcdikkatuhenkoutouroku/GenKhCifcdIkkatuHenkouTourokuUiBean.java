package yuyu.app.hozen.khozen.khcifcdikkatuhenkoutouroku;

import java.util.List;

import jp.co.slcs.swak.web.ui.AbstractUiBean;
import jp.co.slcs.swak.web.ui.DataSource;
import jp.co.slcs.swak.web.upload.UploadFile;

/**
 * ＣＩＦコード一括変更登録 : 画面UiBeanの抽象親クラスです。<br />
 * このソースはツールによる自動生成で、画面項目定義の変更に連動して更新されます。
 * 手書きコードを加えないでください。
 */
public abstract class GenKhCifcdIkkatuHenkouTourokuUiBean extends AbstractUiBean {

    private static final long serialVersionUID = 1L;

    private DataSource<CifCodeHenkouInfoTitleDataSourceBean> cifCodeHenkouInfoTitleDataSource = new DataSource<>();
    public DataSource<CifCodeHenkouInfoTitleDataSourceBean> getCifCodeHenkouInfoTitleDataSource() {
        return cifCodeHenkouInfoTitleDataSource;
    }

    @Deprecated
    public List<CifCodeHenkouInfoTitleDataSourceBean> getCifCodeHenkouInfoTitle() {
        return cifCodeHenkouInfoTitleDataSource.getDatas();
    }

    public void setCifCodeHenkouInfoTitle(List<CifCodeHenkouInfoTitleDataSourceBean> pCifCodeHenkouInfoTitle) {
        cifCodeHenkouInfoTitleDataSource.setDatas(pCifCodeHenkouInfoTitle);
    }

    private DataSource<CifCodeHenkouInfoDataSourceBean> cifCodeHenkouInfoDataSource = new DataSource<>();
    public DataSource<CifCodeHenkouInfoDataSourceBean> getCifCodeHenkouInfoDataSource() {
        return cifCodeHenkouInfoDataSource;
    }

    @Deprecated
    public List<CifCodeHenkouInfoDataSourceBean> getCifCodeHenkouInfo() {
        return cifCodeHenkouInfoDataSource.getDatas();
    }

    public void setCifCodeHenkouInfo(List<CifCodeHenkouInfoDataSourceBean> pCifCodeHenkouInfo) {
        cifCodeHenkouInfoDataSource.setDatas(pCifCodeHenkouInfo);
    }

    private UploadFile uploadfile;

    public UploadFile getUploadfile() {
        return uploadfile;
    }

    public void setUploadfile(UploadFile pUploadfile) {
        uploadfile = pUploadfile;
    }
}
