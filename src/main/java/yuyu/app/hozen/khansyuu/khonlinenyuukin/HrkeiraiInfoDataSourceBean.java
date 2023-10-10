package yuyu.app.hozen.khansyuu.khonlinenyuukin;

/**
 * オンライン入金処理 - ●振替依頼情報 の 行データBean クラスです。<br />
 * このクラスは手書きのコード変更が行われる可能性があります。
 * ツールの自動生成ファイルを無条件で上書きしないよう注意して下さい。
 */
public class HrkeiraiInfoDataSourceBean extends GenHrkeiraiInfoDataSourceBean {

    private static final long serialVersionUID = 1L;

    private String henkouSikibetuKey;

    public HrkeiraiInfoDataSourceBean() {
    }

    public String getHenkouSikibetuKey() {
        return henkouSikibetuKey;
    }

    public void setHenkouSikibetuKey(String pHenkouSikibetuKey) {
        henkouSikibetuKey = pHenkouSikibetuKey;
    }
}
