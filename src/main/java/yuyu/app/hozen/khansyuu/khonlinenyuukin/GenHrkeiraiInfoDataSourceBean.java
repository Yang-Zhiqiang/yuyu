package yuyu.app.hozen.khansyuu.khonlinenyuukin;

import java.io.Serializable;

import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.validation.constraints.CurrencyLenght;
import jp.co.slcs.swak.validation.constraints.PositiveNumberBizCalcble;
import jp.co.slcs.swak.validation.constraints.Range;
import jp.co.slcs.swak.validation.constraints.ValidDateYm;
import yuyu.def.classification.C_KzkpannaijiyuuKbn;
import yuyu.def.classification.C_NyknaiyouKbn;

/**
 * オンライン入金処理 - ●振替依頼情報 の 行データBean ベースクラスです。<br />
 * このソースはツールにより自動生成されたものです。
 * 画面項目定義に変更があると上書きされてしまうので、手で編集しないで下さい。
 */
public class GenHrkeiraiInfoDataSourceBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private Boolean nykntaisyouchkbox;

    public Boolean getNykntaisyouchkbox() {
        return nykntaisyouchkbox == null ? Boolean.FALSE : nykntaisyouchkbox;
    }

    public void setNykntaisyouchkbox(Boolean pNykntaisyouchkbox) {
        nykntaisyouchkbox = pNykntaisyouchkbox == null ? Boolean.FALSE : pNykntaisyouchkbox;
    }


    private C_NyknaiyouKbn nyknaiyoukbn;

    public C_NyknaiyouKbn getNyknaiyoukbn() {
        return nyknaiyoukbn;
    }

    public void setNyknaiyoukbn(C_NyknaiyouKbn pNyknaiyoukbn) {
        nyknaiyoukbn = pNyknaiyoukbn;
    }


    @ValidDateYm
    private BizDateYM jyuutouym;

    public BizDateYM getJyuutouym() {
        return jyuutouym;
    }

    @Trim("both")
    public void setJyuutouym(BizDateYM pJyuutouym) {
        jyuutouym = pJyuutouym;
    }


    private BizDate hrkkigen;

    public BizDate getHrkkigen() {
        return hrkkigen;
    }

    @Trim("both")
    public void setHrkkigen(BizDate pHrkkigen) {
        hrkkigen = pHrkkigen;
    }


    @CurrencyLenght(length=9)
    @PositiveNumberBizCalcble
    private BizCurrency hrkiraikngk;

    public BizCurrency getHrkiraikngk() {
        return hrkiraikngk;
    }

    public void setHrkiraikngk(BizCurrency pHrkiraikngk) {
        hrkiraikngk = pHrkiraikngk;
    }


    private String comment124keta;

    public String getComment124keta() {
        return comment124keta;
    }

    @Trim("right")
    public void setComment124keta(String pComment124keta) {
        comment124keta = pComment124keta;
    }


    @Range(min="0", max="99")
    private Integer jyutoukaisuuy;

    public Integer getJyutoukaisuuy() {
        return jyutoukaisuuy;
    }

    @Trim("both")
    public void setJyutoukaisuuy(Integer pJyutoukaisuuy) {
        jyutoukaisuuy = pJyutoukaisuuy;
    }


    @Range(min="0", max="12")
    private Integer jyutoukaisuum;

    public Integer getJyutoukaisuum() {
        return jyutoukaisuum;
    }

    @Trim("both")
    public void setJyutoukaisuum(Integer pJyutoukaisuum) {
        jyutoukaisuum = pJyutoukaisuum;
    }


    private C_KzkpannaijiyuuKbn kzkpannaijiyuukbn;

    public C_KzkpannaijiyuuKbn getKzkpannaijiyuukbn() {
        return kzkpannaijiyuukbn;
    }

    public void setKzkpannaijiyuukbn(C_KzkpannaijiyuuKbn pKzkpannaijiyuukbn) {
        kzkpannaijiyuukbn = pKzkpannaijiyuukbn;
    }

}
