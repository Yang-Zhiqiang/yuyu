package yuyu.common.hozen.setuibean;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import yuyu.def.classification.C_FstphrkkeiroKbn;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_Hrkkeiro;
import yuyu.def.classification.C_Kykjyoutai;
import yuyu.def.classification.C_KzkykdouKbn;
import yuyu.def.classification.C_SinkeizkKbn;
import yuyu.def.classification.C_TkiktbrisyuruiKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_YokinKbn;
import yuyu.def.classification.C_Yuukoukakkekka;

/**
 * 契約保全 UiBean設定 払込情報設定UiBeanパラメータ
 */
public interface SetHaraikomiInfoExecUiBeanParam {

    String getSyono();

    void setVhrkijkipjytym(BizDateYM pVhrkijkipjytym);

    void setVhrkifstphrkkeirokbn(C_FstphrkkeiroKbn pVhrkifstphrkkeirokbn);

    void setVhrkihrkkaisuu(C_Hrkkaisuu pVhrkihrkkaisuu);

    void setVhrkihrkkeiro(C_Hrkkeiro pVhrkihrkkeiro);

    void setVhrkihrkp(BizCurrency pVhrkihrkp);

    void setVhrkikihrkp(BizCurrency pVhrkikihrkp);

    void setNextkosumu(C_UmuKbn pNextkosumu);

    void setVhrkinextkosgohrkp(BizCurrency pVhrkinextkosgohrkp);

    void setVhrkihrkinfobankcd(String pVhrkihrkinfobankcd);

    void setVhrkihrkinfobanknmkj(String pVhrkihrkinfobanknmkj);

    void setVhrkihrkinfositencd(String pVhrkihrkinfositencd);

    void setVhrkihrkinfositennmkj(String pVhrkihrkinfositennmkj);

    void setVhrkihrkinfotuutyoukigou(String pVhrkihrkinfotuutyoukigou);

    void setVhrkihrkinfoyokinkbn(C_YokinKbn pVhrkihrkinfoyokinkbn);

    void setVhrkihrkinfokouzano(String pVhrkihrkinfokouzano);

    void setVhrkihrkinfokzmeiginmkn(String pVhrkihrkinfokzmeiginmkn);

    void setVhrkikzdoukbn(C_KzkykdouKbn pVhrkikzdoukbn) ;

    void setVhrkihrkinfosinkeizkkbn(C_SinkeizkKbn pVhrkihrkinfosinkeizkkbn);

    void setVhrkiyenkansannyknkingk(BizCurrency pVhrkiyenkansannyknkingk);

    void setVhrkiyentkykwsrateymd(BizDate pVhrkiyentkykwsrateymd);

    void setVhrkiyentkykwsrate(BizNumber pVhrkiyentkykwsrate);

    void setVhrkiyentkykwsratetuukasyu(C_Tuukasyu pVhrkiyentkykwsratetuukasyu);

    void setVhrkiitijibrp(BizCurrency pVhrkiitijibrp);

    void setYennykntkhkumu(C_UmuKbn pYennykntkhkumu);

    void setKyktuukasyu(C_Tuukasyu pKyktuukasyu);

    void setVhrkitikiktbrijk(C_TkiktbrisyuruiKbn pVhrkitikiktbrijk);

    void setVhrkikykjyoutai(C_Kykjyoutai pVhrkikykjyoutai);

    void setVhrkizenkizennouumu(C_UmuKbn pVhrkizenkizennouumu);

    void setVhrkizennoustartym(BizDateYM pVhrkizennoustartym);

    void setVhrkizennoukkn(String pVhrkizennoukkn);

    void setVhrkizennounyuukingk(BizCurrency pVhrkizennounyuukingk);

    void setVhrkizennounyuukinymd(BizDate pVhrkizennounyuukinymd);

    void setVhrkicreditkessaiyouno(String pVhrkicreditkessaiyouno);

    void setVhrkidispcreditkessaiyouno(String pVhrkidispcreditkessaiyouno);

    void setVhrkicredityuukoukakkekka(C_Yuukoukakkekka pVhrkicredityuukoukakkekka);

    void setVhrkicredityuukoukakym(BizDateYM pVhrkicredityuukoukakym);
}
