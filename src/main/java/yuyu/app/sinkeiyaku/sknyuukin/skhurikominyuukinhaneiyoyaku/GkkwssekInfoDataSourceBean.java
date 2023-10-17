package yuyu.app.sinkeiyaku.sknyuukin.skhurikominyuukinhaneiyoyaku;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.number.BizNumber;

/**
 * 振込入金反映予約 - 外貨為替差益情報一覧 の 行データBean クラスです。<br />
 * このクラスは手書きのコード変更が行われる可能性があります。
 * ツールの自動生成ファイルを無条件で上書きしないよう注意して下さい。
 */
public class GkkwssekInfoDataSourceBean extends GenGkkwssekInfoDataSourceBean {

    private static final long serialVersionUID = 1L;

    private BizDate ryosyuymd;

    private BizNumber kawaserate;

    public GkkwssekInfoDataSourceBean() {
    }

    public BizDate getRyosyuymd() {
        return ryosyuymd;
    }

    public void setRyosyuymd(BizDate pRyosyuymd) {
        ryosyuymd = pRyosyuymd;
    }

    public BizNumber getKawaserate() {
        return kawaserate;
    }

    public void setKawaserate(BizNumber pKawaserate) {
        kawaserate = pKawaserate;
    }

}
