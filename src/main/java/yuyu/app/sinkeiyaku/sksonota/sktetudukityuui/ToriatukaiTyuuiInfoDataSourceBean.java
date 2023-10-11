package yuyu.app.sinkeiyaku.sksonota.sktetudukityuui;

import jp.co.slcs.swak.date.BizDate;

/**
 * 新契約手続注意設定 - ●取扱注意情報 の 行データBean クラスです。<br />
 * このクラスは手書きのコード変更が行われる可能性があります。
 * ツールの自動生成ファイルを無条件で上書きしないよう注意して下さい。
 */
public class ToriatukaiTyuuiInfoDataSourceBean extends GenToriatukaiTyuuiInfoDataSourceBean {

    private static final long serialVersionUID = 1L;

    private Integer skeittdktyuitrtrenno;

    private BizDate skeittdktyuitrttrkymd;

    public ToriatukaiTyuuiInfoDataSourceBean() {
    }

    public Integer getSkeittdktyuitrtrenno() {
        return skeittdktyuitrtrenno;
    }

    public void setSkeittdktyuitrtrenno(Integer pSkeittdktyuitrtrenno) {
        this.skeittdktyuitrtrenno = pSkeittdktyuitrtrenno;
    }

    public BizDate getSkeittdktyuitrttrkymd() {
        return skeittdktyuitrttrkymd;
    }

    public void setSkeittdktyuitrttrkymd(BizDate pSkeittdktyuitrttrkymd) {
        this.skeittdktyuitrttrkymd = pSkeittdktyuitrttrkymd;
    }
}
