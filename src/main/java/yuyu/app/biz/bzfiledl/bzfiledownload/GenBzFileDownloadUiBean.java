package yuyu.app.biz.bzfiledl.bzfiledownload;

import java.util.List;

import jp.co.slcs.swak.web.ui.AbstractUiBean;
import jp.co.slcs.swak.web.ui.DataSource;
import jp.co.slcs.swak.web.ui.UserDefsList;

/**
 * ファイルダウンロード : 画面UiBeanの抽象親クラスです。<br />
 * このソースはツールによる自動生成で、画面項目定義の変更に連動して更新されます。
 * 手書きコードを加えないでください。
 */
public abstract class GenBzFileDownloadUiBean extends AbstractUiBean {

    private static final long serialVersionUID = 1L;

    private DataSource<FileInfoListDataSourceBean> fileInfoListDataSource = new DataSource<>();
    public DataSource<FileInfoListDataSourceBean> getFileInfoListDataSource() {
        return fileInfoListDataSource;
    }

    @Deprecated
    public List<FileInfoListDataSourceBean> getFileInfoList() {
        return fileInfoListDataSource.getDatas();
    }

    public void setFileInfoList(List<FileInfoListDataSourceBean> pFileInfoList) {
        fileInfoListDataSource.setDatas(pFileInfoList, 10);
    }

    private String filesyurui;

    public String getFilesyurui() {
        return filesyurui;
    }

    public void setFilesyurui(String pFilesyurui) {
        filesyurui = pFilesyurui;
    }

    private LoopChain<UserDefsList> filesyuruiOptionBeanList = new LoopChain<>();
    public UserDefsList getFilesyuruiOptionBeanList() {
        return filesyuruiOptionBeanList.get();
    }

    public void setFilesyuruiOptionBeanList(UserDefsList pFilesyuruiOptionBeanList) {
        clearFilesyuruiOptionBeanList();
        filesyuruiOptionBeanList.add(pFilesyuruiOptionBeanList);
    }

    public void clearFilesyuruiOptionBeanList() {
        filesyuruiOptionBeanList.clear();
    }
}
