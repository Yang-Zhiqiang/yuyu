package yuyu.app.sinkeiyaku.sknyuukin.skhurikominyuukinhaneiyoyaku;

import java.util.List;
import jp.co.slcs.swak.web.ui.AbstractUiBean;
import jp.co.slcs.swak.web.ui.DataSource;
import jp.co.slcs.swak.web.ui.UserDefsList;
import jp.co.slcs.swak.web.upload.UploadFile;

/**
 * 振込入金反映予約 : 画面UiBeanの抽象親クラスです。<br />
 * このソースはツールによる自動生成で、画面項目定義の変更に連動して更新されます。
 * 手書きコードを加えないでください。
 */
public abstract class GenSkHurikomiNyuukinHaneiYoyakuUiBean extends AbstractUiBean {

    private static final long serialVersionUID = 1L;

    private DataSource<IkktnyknInfoDataSourceBean> ikktnyknInfoDataSource = new DataSource<>();
    public DataSource<IkktnyknInfoDataSourceBean> getIkktnyknInfoDataSource() {
        return ikktnyknInfoDataSource;
    }

    @Deprecated
    public List<IkktnyknInfoDataSourceBean> getIkktnyknInfo() {
        return ikktnyknInfoDataSource.getDatas();
    }

    public void setIkktnyknInfo(List<IkktnyknInfoDataSourceBean> pIkktnyknInfo) {
        ikktnyknInfoDataSource.setDatas(pIkktnyknInfo);
    }

    private DataSource<HrkmnyknInfoDataSourceBean> hrkmnyknInfoDataSource = new DataSource<>();
    public DataSource<HrkmnyknInfoDataSourceBean> getHrkmnyknInfoDataSource() {
        return hrkmnyknInfoDataSource;
    }

    @Deprecated
    public List<HrkmnyknInfoDataSourceBean> getHrkmnyknInfo() {
        return hrkmnyknInfoDataSource.getDatas();
    }

    public void setHrkmnyknInfo(List<HrkmnyknInfoDataSourceBean> pHrkmnyknInfo) {
        hrkmnyknInfoDataSource.setDatas(pHrkmnyknInfo);
    }

    private DataSource<GkkwssekInfoDataSourceBean> gkkwssekInfoDataSource = new DataSource<>();
    public DataSource<GkkwssekInfoDataSourceBean> getGkkwssekInfoDataSource() {
        return gkkwssekInfoDataSource;
    }

    @Deprecated
    public List<GkkwssekInfoDataSourceBean> getGkkwssekInfo() {
        return gkkwssekInfoDataSource.getDatas();
    }

    public void setGkkwssekInfo(List<GkkwssekInfoDataSourceBean> pGkkwssekInfo) {
        gkkwssekInfoDataSource.setDatas(pGkkwssekInfo);
    }

    private UploadFile uploadfile;

    public UploadFile getUploadfile() {
        return uploadfile;
    }

    public void setUploadfile(UploadFile pUploadfile) {
        uploadfile = pUploadfile;
    }
}
