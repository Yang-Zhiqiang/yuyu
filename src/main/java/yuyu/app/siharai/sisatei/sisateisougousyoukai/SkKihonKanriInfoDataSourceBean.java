package yuyu.app.siharai.sisatei.sisateisougousyoukai;

import jp.co.slcs.swak.date.BizDate;
import yuyu.common.siharai.siview.SkKihonKanriInfoDataSourceBeanCommonParam;

/**
 * 査定総合照会 - ●同時請求情報 の 行データBean クラスです。<br />
 * このクラスは手書きのコード変更が行われる可能性があります。
 * ツールの自動生成ファイルを無条件で上書きしないよう注意して下さい。
 */
public class SkKihonKanriInfoDataSourceBean extends GenSkKihonKanriInfoDataSourceBean implements
SkKihonKanriInfoDataSourceBeanCommonParam {

    private static final long serialVersionUID = 1L;

    public SkKihonKanriInfoDataSourceBean() {
    }

    private String dispskno;

    private BizDate dispsyoriymd;

    @Override
    public String getDispskno() {
        return dispskno;
    }

    @Override
    public void setDispskno(String pDispskno) {
        this.dispskno = pDispskno;

    }

    @Override
    public BizDate getDispsyoriymd() {
        return dispsyoriymd;
    }

    @Override
    public void setDispsyoriymd(BizDate pDispsyoriymd) {
        this.dispsyoriymd = pDispsyoriymd;
    }

}
