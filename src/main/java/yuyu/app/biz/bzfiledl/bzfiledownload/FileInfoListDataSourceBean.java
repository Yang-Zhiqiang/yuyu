package yuyu.app.biz.bzfiledl.bzfiledownload;

/**
 * ファイルダウンロード - ●ファイル一覧 の 行データBean クラスです。<br />
 * このクラスは手書きのコード変更が行われる可能性があります。
 * ツールの自動生成ファイルを無条件で上書きしないよう注意して下さい。
 */
public class FileInfoListDataSourceBean extends GenFileInfoListDataSourceBean {

    private static final long serialVersionUID = 1L;

    private String uniqueId;

    public String getUniqueId() {
        return uniqueId;
    }

    public void setUniqueId(String pUniqueId) {
        this.uniqueId = pUniqueId;
    }

    public FileInfoListDataSourceBean() {
    }

}
