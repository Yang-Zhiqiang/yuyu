package yuyu.app.sinkeiyaku.sksyoukai.skmossyoukai;

/**
 * 申込状況照会 - kykSakuinInfo の 行データBean クラスです。<br />
 * このクラスは手書きのコード変更が行われる可能性があります。
 * ツールの自動生成ファイルを無条件で上書きしないよう注意して下さい。
 */
public class KykSakuinInfoDataSourceBean extends GenKykSakuinInfoDataSourceBean {

    private static final long serialVersionUID = 1L;

    private String seirituJyoukyo;

    public KykSakuinInfoDataSourceBean() {
    }


    public String getSeirituJyoukyo() {
        return seirituJyoukyo;
    }

    public void setSeirituJyoukyo(String pSeirituJyoukyo) {
        this.seirituJyoukyo = pSeirituJyoukyo;
    }

}