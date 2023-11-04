package yuyu.common.siharai.sicommon;

import jp.co.slcs.swak.date.BizDate;
import yuyu.common.siharai.siview.SkKihonKanriInfoDataSourceBeanCommonParam;
import yuyu.def.classification.C_HubiJyoukyouKbn;
import yuyu.def.classification.C_TyousaJyoukyouKbn;

/**
 * 保険金給付金支払 保険金給付金支払共通 同時請求契約表示実現クラス
 */
public class SkKihonKanriInfoDataSourceBeanCommonParamImpl implements SkKihonKanriInfoDataSourceBeanCommonParam{


    private String pDispsyono;

    private String pDispskno;

    private C_HubiJyoukyouKbn pDisphubikbn;

    private C_TyousaJyoukyouKbn pDisptyousajkkbn;

    private BizDate pDispsyoriymd;

    private String pDispnextsyorinm;

    @Override public String getDispsyono() {
        return pDispsyono;
    }

    @Override public void setDispsyono(String pDispsyono) {
        this.pDispsyono = pDispsyono;
    }

    @Override public String getDispskno() {
        return pDispskno;
    }

    @Override public void setDispskno(String pDispskno) {
        this.pDispskno = pDispskno;
    }

    @Override public C_HubiJyoukyouKbn getDisphubikbn() {
        return pDisphubikbn;
    }

    @Override public void setDisphubikbn(C_HubiJyoukyouKbn pDisphubikbn) {
        this.pDisphubikbn = pDisphubikbn;
    }

    @Override public C_TyousaJyoukyouKbn getDisptyousajkkbn() {
        return pDisptyousajkkbn;
    }

    @Override public void setDisptyousajkkbn(C_TyousaJyoukyouKbn pDisptyousajkkbn) {
        this.pDisptyousajkkbn = pDisptyousajkkbn;
    }

    @Override public BizDate getDispsyoriymd() {
        return pDispsyoriymd;
    }

    @Override public void setDispsyoriymd(BizDate pDispsyoriymd) {
        this.pDispsyoriymd = pDispsyoriymd;
    }

    @Override public String getDispnextsyorinm() {
        return pDispnextsyorinm;
    }

    @Override public void setDispnextsyorinm(String pDispnextsyorinm) {
        this.pDispnextsyorinm = pDispnextsyorinm;
    }
}
