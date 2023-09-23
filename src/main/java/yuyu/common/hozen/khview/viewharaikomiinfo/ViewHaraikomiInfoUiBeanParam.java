package yuyu.common.hozen.khview.viewharaikomiinfo;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import yuyu.common.biz.bzview.CommonViewUiBeanParam;
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
 * 契約保全 契約保全画面部品 払込情報表示 <br />
 */
public interface ViewHaraikomiInfoUiBeanParam extends CommonViewUiBeanParam {

    public C_FstphrkkeiroKbn getVhrkifstphrkkeirokbn();

    public void setVhrkifstphrkkeirokbn(C_FstphrkkeiroKbn pVhrkifstphrkkeirokbn);

    public C_Hrkkaisuu getVhrkihrkkaisuu();

    public void setVhrkihrkkaisuu(C_Hrkkaisuu pVhrkihrkkaisuu);

    public C_Hrkkeiro getVhrkihrkkeiro();

    public void setVhrkihrkkeiro(C_Hrkkeiro pVhrkihrkkeiro);

    public BizDateYM getVhrkijkipjytym();

    public void setVhrkijkipjytym(BizDateYM pVhrkijkipjytym);

    public BizCurrency getVhrkihrkp();

    public void setVhrkihrkp(BizCurrency pVhrkihrkp);

    public BizCurrency getVhrkiitijibrp();

    public void setVhrkiitijibrp(BizCurrency pVhrkiitijibrp);

    public BizCurrency getVhrkikihrkp();

    public void setVhrkikihrkp(BizCurrency pVhrkikihrkp);

    public BizCurrency getVhrkinextkosgohrkp();

    public void setVhrkinextkosgohrkp(BizCurrency pVhrkinextkosgohrkp);

    public BizCurrency getVhrkiyenkansannyknkingk();

    public void setVhrkiyenkansannyknkingk(BizCurrency pVhrkiyenkansannyknkingk);

    public BizDate getVhrkiyentkykwsrateymd();

    public void setVhrkiyentkykwsrateymd(BizDate pVhrkiyentkykwsrateymd);

    public BizNumber getVhrkiyentkykwsrate();

    public void setVhrkiyentkykwsrate(BizNumber pVhrkiyentkykwsrate);

    public C_Tuukasyu getVhrkiyentkykwsratetuukasyu();

    public void setVhrkiyentkykwsratetuukasyu(C_Tuukasyu pVhrkiyentkykwsratetuukasyu);

    public String getVhrkihrkinfobankcd();

    public void setVhrkihrkinfobankcd(String pVhrkihrkinfobankcd);

    public String getVhrkihrkinfobanknmkj();

    public void setVhrkihrkinfobanknmkj(String pVhrkihrkinfobanknmkj);

    public String getVhrkihrkinfositencd();

    public void setVhrkihrkinfositencd(String pVhrkihrkinfositencd);

    public String getVhrkihrkinfositennmkj();

    public void setVhrkihrkinfositennmkj(String pVhrkihrkinfositennmkj);

    public String getVhrkihrkinfotuutyoukigou();

    public void setVhrkihrkinfotuutyoukigou(String pVhrkihrkinfotuutyoukigou);

    public C_YokinKbn getVhrkihrkinfoyokinkbn();

    public void setVhrkihrkinfoyokinkbn(C_YokinKbn pVhrkihrkinfoyokinkbn);

    public String getVhrkihrkinfokouzano();

    public void setVhrkihrkinfokouzano(String pVhrkihrkinfokouzano);

    public C_SinkeizkKbn getVhrkihrkinfosinkeizkkbn();

    public void setVhrkihrkinfosinkeizkkbn(C_SinkeizkKbn pVhrkihrkinfosinkeizkkbn);

    public String getVhrkihrkinfokzmeiginmkn();

    public void setVhrkihrkinfokzmeiginmkn(String pVhrkihrkinfokzmeiginmkn);

    public C_KzkykdouKbn getVhrkikzdoukbn();

    public void setVhrkikzdoukbn(C_KzkykdouKbn pVhrkikzdoukbn);

    public String getVhrkidispcreditkessaiyouno();

    public void setVhrkidispcreditkessaiyouno(String pVhrkidispcreditkessaiyouno);

    public C_Yuukoukakkekka getVhrkicredityuukoukakkekka();

    public void setVhrkicredityuukoukakkekka(C_Yuukoukakkekka pVhrkicredityuukoukakkekka);

    public BizDateYM getVhrkicredityuukoukakym();

    public void setVhrkicredityuukoukakym(BizDateYM pVhrkicredityuukoukakym);

    public BizDateYM getVhrkizennoustartym();

    public void setVhrkizennoustartym(BizDateYM pVhrkizennoustartym);

    public String getVhrkizennoukkn();

    public void setVhrkizennoukkn(String pVhrkizennoukkn);

    public BizCurrency getVhrkizennounyuukingk();

    public void setVhrkizennounyuukingk(BizCurrency pVhrkizennounyuukingk);

    public BizDate getVhrkizennounyuukinymd();

    public void setVhrkizennounyuukinymd(BizDate pVhrkizennounyuukinymd);

    public C_UmuKbn getNextkosumu();

    public void setNextkosumu(C_UmuKbn pNextkosumu);

    public C_UmuKbn getYennykntkhkumu();

    public void setYennykntkhkumu(C_UmuKbn pYennykntkhkumu);

    public C_Tuukasyu getKyktuukasyu();

    public void setKyktuukasyu(C_Tuukasyu pKyktuukasyu);

    public void setVhrkitikiktbrijk(C_TkiktbrisyuruiKbn pVhrkitikiktbrijk);

    public C_TkiktbrisyuruiKbn getVhrkitikiktbrijk();

    public C_Kykjyoutai getVhrkikykjyoutai();

    public void setVhrkikykjyoutai(C_Kykjyoutai pVhrkikykjyoutai);

    public C_UmuKbn getVhrkizenkizennouumu();

    public void setVhrkizenkizennouumu(C_UmuKbn pAnnaisaikaiym);

    public String getVhrkicreditkessaiyouno();

    public void setVhrkicreditkessaiyouno(String pVhrkicreditkessaiyouno);
}
