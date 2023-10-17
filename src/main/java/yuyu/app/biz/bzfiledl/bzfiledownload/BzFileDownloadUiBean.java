package yuyu.app.biz.bzfiledl.bzfiledownload;

import jp.co.slcs.swak.web.conversation.annotations.ConversationScoped;

/**
 * ファイルダウンロード の画面UiBeanクラスです。<br />
 * このクラスは手書きのコード変更が行われる可能性があります。
 * ツールの自動生成ファイルを無条件で上書きしないよう注意して下さい。
 */
@ConversationScoped
public class BzFileDownloadUiBean extends GenBzFileDownloadUiBean {

    private static final long serialVersionUID = 1L;

    public BzFileDownloadUiBean() {
    }

    private boolean dlflag;

    public boolean isDlflag() {
        return dlflag;
    }

    public void setDlflag(boolean dlflag) {
        this.dlflag = dlflag;
    }

    private FileInfoListDataSourceBean selectedBean;

    public FileInfoListDataSourceBean getSelectedBean() {
        return selectedBean;
    }

    public void setSelectedBean(FileInfoListDataSourceBean selectedBean) {
        this.selectedBean = selectedBean;
    }

    private String kinouMode;

    public String getKinouMode() {
        return kinouMode;
    }

    public void setKinouMode(String pKinouMode) {
        this.kinouMode = pKinouMode;
    }

}
