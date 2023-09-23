package yuyu.common.siharai.siview;

import jp.co.slcs.swak.date.BizDate;
import yuyu.def.classification.C_HubiJyoukyouKbn;
import yuyu.def.classification.C_TyousaJyoukyouKbn;

/**
 * 保険金給付金支払 保険金給付金支払共通 同時請求契約表示
 */
public interface SkKihonKanriInfoDataSourceBeanCommonParam {

    String getDispsyono();

    void setDispsyono(String pDispsyono);

    String getDispskno();

    void setDispskno(String pDispskno);

    C_HubiJyoukyouKbn getDisphubikbn();

    void setDisphubikbn(C_HubiJyoukyouKbn pDisphubikbn);

    C_TyousaJyoukyouKbn getDisptyousajkkbn();

    void setDisptyousajkkbn(C_TyousaJyoukyouKbn pDisptyousajkkbn);

    BizDate getDispsyoriymd();

    void setDispsyoriymd(BizDate pDispsyoriymd);

    String getDispnextsyorinm();

    void setDispnextsyorinm(String pDispnextsyorinm);

}
