package yuyu.app.hozen.khozen.khkanikeiyakunaiyouteisei;

import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.web.ui.AbstractUiBean;
import yuyu.def.classification.C_KykNaiyouTeiseiSyoriKbn;
import yuyu.infr.validation.constraints.SyoukenNo;

/**
 * 契約保全簡易契約内容訂正 : 画面UiBeanの抽象親クラスです。<br />
 * このソースはツールによる自動生成で、画面項目定義の変更に連動して更新されます。
 * 手書きコードを加えないでください。
 */
public abstract class GenKhKaniKeiyakuNaiyouTeiseiUiBean extends AbstractUiBean {

    private static final long serialVersionUID = 1L;

    @SyoukenNo
    private String syono;

    public String getSyono() {
        return syono;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSyono(String pSyono) {
        syono = pSyono;
    }

    private C_KykNaiyouTeiseiSyoriKbn kyknaiyouteiseisyorikbn;

    public C_KykNaiyouTeiseiSyoriKbn getKyknaiyouteiseisyorikbn() {
        return kyknaiyouteiseisyorikbn;
    }

    public void setKyknaiyouteiseisyorikbn(C_KykNaiyouTeiseiSyoriKbn pKyknaiyouteiseisyorikbn) {
        kyknaiyouteiseisyorikbn = pKyknaiyouteiseisyorikbn;
    }

    private C_KykNaiyouTeiseiSyoriKbn dispkyknytssyorikbn;

    public C_KykNaiyouTeiseiSyoriKbn getDispkyknytssyorikbn() {
        return dispkyknytssyorikbn;
    }

    public void setDispkyknytssyorikbn(C_KykNaiyouTeiseiSyoriKbn pDispkyknytssyorikbn) {
        dispkyknytssyorikbn = pDispkyknytssyorikbn;
    }

    private BizDate yendthnkymd;

    public BizDate getYendthnkymd() {
        return yendthnkymd;
    }

    public void setYendthnkymd(BizDate pYendthnkymd) {
        yendthnkymd = pYendthnkymd;
    }

    private BizDate tmttknkouryokukaisiymd;

    public BizDate getTmttknkouryokukaisiymd() {
        return tmttknkouryokukaisiymd;
    }

    public void setTmttknkouryokukaisiymd(BizDate pTmttknkouryokukaisiymd) {
        tmttknkouryokukaisiymd = pTmttknkouryokukaisiymd;
    }
}
