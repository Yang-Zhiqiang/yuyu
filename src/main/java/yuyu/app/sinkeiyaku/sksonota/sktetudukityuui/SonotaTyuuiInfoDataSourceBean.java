package yuyu.app.sinkeiyaku.sksonota.sktetudukityuui;

import jp.co.slcs.swak.date.BizDate;

/**
 * 新契約手続注意設定 - ●その他注意情報 の 行データBean クラスです。<br />
 * このクラスは手書きのコード変更が行われる可能性があります。
 * ツールの自動生成ファイルを無条件で上書きしないよう注意して下さい。
 */
public class SonotaTyuuiInfoDataSourceBean extends GenSonotaTyuuiInfoDataSourceBean {

    private static final long serialVersionUID = 1L;

    private Integer skeittdktyuisttrkrenno;

    private BizDate skeittdktyuisttrkymd;


    public SonotaTyuuiInfoDataSourceBean() {
    }

    public Integer getSkeittdktyuisttrkrenno() {
        return skeittdktyuisttrkrenno;
    }

    public void setSkeittdktyuisttrkrenno(Integer pSkeittdktyuisttrkrenno) {
        skeittdktyuisttrkrenno = pSkeittdktyuisttrkrenno;
    }

    public BizDate getSkeittdktyuisttrkymd() {
        return skeittdktyuisttrkymd;
    }

    public void setSkeittdktyuisttrkymd(BizDate pSkeittdktyuisttrkymd) {
        skeittdktyuisttrkymd = pSkeittdktyuisttrkymd;
    }
}
