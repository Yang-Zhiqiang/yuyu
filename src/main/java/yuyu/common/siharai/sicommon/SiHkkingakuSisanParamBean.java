package yuyu.common.siharai.sicommon;

import java.io.Serializable;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import yuyu.def.classification.C_Bnshrkaisuu;
import yuyu.def.classification.C_HknKknKbn;
import yuyu.def.classification.C_HokenkinsyuruiKbn;
import yuyu.def.classification.C_NaiteiKakuteiKbn;
import yuyu.def.classification.C_Nstknsyu;
import yuyu.def.classification.C_SUketoriHouhouKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UktKyksyaTdk;
import yuyu.def.classification.C_UmuKbn;

/**
 * 保険金給付金支払 保険金給付金支払共通 保険金額試算パラメータBean
 */
public class SiHkkingakuSisanParamBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private C_SUketoriHouhouKbn sUketoriHouhouKbn;

    private BizDate calcKijyunYmd;

    private BizDate knsnKijyunYmd;

    private BizNumber kawaseRate;

    private BizNumber siHknknUktBnWari;

    private BizCurrency hokenknGk;

    private BizCurrency yenHokenknGk;

    private BizDate nkKknSetYmd;

    private BizDate nkShrStartYmd;

    private C_Nstknsyu nkShrTkykNksyuKbn;

    private Integer nkShrTkykNksyuKkn;

    private C_Bnshrkaisuu bnShrKaisuu;

    private BizCurrency nkKknJyutouGk;

    private BizCurrency yenNkKknJyutouGk;

    private BizCurrency tienRsk;

    private BizCurrency yenTienRsk;

    private BizCurrency nkGns;

    private BizCurrency yenNkGns;

    private BizCurrency nkNengk;

    private BizCurrency yenNkNengk;

    private BizCurrency bnktnkGk;

    private BizCurrency yenBnktnkGk;

    private BizCurrency htyKeihi;

    private BizCurrency yenHtyKeihi;

    private BizCurrency nkHtyKeihi;

    private BizCurrency yenNkhtyKeihi;

    private BizCurrency itjknhtyKeihi;

    private BizCurrency yenItjknhtyKeihi;

    private BizCurrency shrkykhtykeihi;

    private BizCurrency kaiyakuHr;

    private BizCurrency yenKaiyakuHr;

    private BizCurrency sbymdKaiyakuhenreiknGk;

    private BizCurrency yenSbymdKaiyakuhenreiknGk;

    private BizCurrency tutaknGk;

    private BizCurrency yenTutaknGk;

    private BizCurrency sbymdTmttKnGk;

    private BizCurrency yenSbymdTmttKnGk;

    private BizCurrency hokenryoustGk;

    private BizCurrency yenHokenryoustGk;

    private BizCurrency pruikei;

    private BizDate tienRisokuKisanYmd;

    private BizDate tienRisokuSyuryouYmd;

    private Integer tienRskNissuu;

    private BizDate shrYmd;

    private C_Tuukasyu kykTuukasyu;

    private C_Tuukasyu shrTuukasyu;

    private BizCurrency bunkatugoHokenKngk;

    private BizCurrency bunkatugoYenHokenKngk;

    private C_HokenkinsyuruiKbn hokenkinsyuruiKbn;

    private String hokenkinsyurui;

    private C_HknKknKbn  hknKknKbn;

    private BizCurrency kihonHokenKngk;

    private BizCurrency yenKihonHokenKngk;

    private BizCurrency sbHokenKngk;

    private BizCurrency yenSbHokenKngk;

    private BizCurrency saigaiS;

    private BizCurrency yenSaigaiS;

    private C_UmuKbn sykSbYenSitiHsyuTkTekiUmu;

    private BizCurrency initSbjiYenkasSiteiHsygk;

    private C_UktKyksyaTdk uktKyksyaTdk;

    private BizDate zeimukwsratekjnymd;

    private BizNumber zeimukwsrate;

    private BizCurrency zeimuYenHokenknGk;

    private BizNumber gaikaknsnkwsrate;

    private C_NaiteiKakuteiKbn vhtnaiteikakuteikbn;

    private BizCurrency haitoukin;

    private BizCurrency yenkahaitoukin;

    private BizCurrency sonotahaitoukin;

    private BizCurrency yenkasonotahaitoukin;

    private Integer misyuupjyuutoukaisuuy;

    private Integer misyuupjyuutoukaisuum;

    private BizDateYM misyuupjyuutouym;

    private BizCurrency misyuup;

    private BizCurrency yenkamisyuup;

    private Integer mikeikapjyuutoukaisuuy;

    private Integer mikeikapjyuutoukaisuum;

    private BizDateYM mikeikapjyuutouym;

    private BizCurrency mikeikap;

    private BizCurrency yenkamikeikap;

    private BizCurrency zennouseisank;

    private BizCurrency yenkazennouseisank;

    private BizCurrency azukarikingk;

    private BizCurrency yenkaazukarikingk;

    private BizCurrency zitkazukarikingksiteituuka;

    private BizCurrency yenzitkazukarikingksttk;

    private BizCurrency zitkazukarikingkyen;

    private BizCurrency gaikaknsnzitkazukarikingkyen;

    private BizCurrency sonotaseisangk;

    private BizCurrency yenkasonotaseisangk;

    private BizCurrency krkgk;

    private BizCurrency yenkakrkgk;

    private BizCurrency shrgkkei;

    private BizCurrency yenkashrgkgoukei;

    private BizCurrency gaikaknsntskgk;

    private BizCurrency gaikaknsnkkkgk;

    private BizCurrency yenkaknsntskgk;

    private BizCurrency yenkaknsnkkkgk;

    private BizCurrency misyuusyonendojikaiikoup;

    private BizCurrency misyuujinendoikoup;

    private BizCurrency bunkatugohaitoukin;

    private BizCurrency bunkatugoyenkahaitoukin;

    private BizCurrency bunkatugosonotahaitoukin;

    private BizCurrency bunkatugoyenkasonotahaitoukin;

    private BizCurrency bunkatugomisyuup;

    private BizCurrency bunkatugoyenkamisyuup;

    private BizCurrency bunkatugomikeikap;

    private BizCurrency bunkatugoyenkamikeikap;

    private BizCurrency bunkatugozennouseisank;

    private BizCurrency bunkatugoyenkazennouseisank;

    private BizCurrency bunkatugoZitkazukarikingksiteituuka;

    private BizCurrency bunkatugoZitkazukarikingkyen;

    private BizCurrency bunkatugoazukarikingk;

    private BizCurrency bunkatugoyenkaazukarikingk;

    private BizCurrency bunkatugokrkgk;

    private BizCurrency bunkatugoyenkakrkgk;

    private BizCurrency bunkatugogoukeigk;

    private BizCurrency bunkatugoyenkagoukeigk;

    private BizCurrency bunkatugoGaikaknsntskgk;

    private BizCurrency bunkatugoGaikaknsnkkkgk;

    private BizCurrency bunkatugoYenkaknsntskgk;

    private BizCurrency bunkatugoYenkaknsnkkkgk;

    public SiHkkingakuSisanParamBean() {
        sUketoriHouhouKbn = C_SUketoriHouhouKbn.BLNK;
        calcKijyunYmd = null;
        knsnKijyunYmd = null;
        kawaseRate = BizNumber.valueOf(0);
        siHknknUktBnWari = BizNumber.valueOf(0);
        hokenknGk = BizCurrency.valueOf(0);
        yenHokenknGk = BizCurrency.valueOf(0);
        nkKknSetYmd = null;
        nkShrStartYmd = null;
        nkShrTkykNksyuKbn = C_Nstknsyu.BLNK;
        nkShrTkykNksyuKkn = 0;
        bnShrKaisuu = C_Bnshrkaisuu.BLNK;
        nkKknJyutouGk = BizCurrency.valueOf(0);
        yenNkKknJyutouGk = BizCurrency.valueOf(0);
        tienRsk = BizCurrency.valueOf(0);
        yenTienRsk = BizCurrency.valueOf(0);
        nkGns = BizCurrency.valueOf(0);
        yenNkGns = BizCurrency.valueOf(0);
        nkNengk = BizCurrency.valueOf(0);
        yenNkNengk = BizCurrency.valueOf(0);
        bnktnkGk = BizCurrency.valueOf(0);
        yenBnktnkGk = BizCurrency.valueOf(0);
        htyKeihi = BizCurrency.valueOf(0);
        yenHtyKeihi = BizCurrency.valueOf(0);
        nkHtyKeihi = BizCurrency.valueOf(0);
        yenNkhtyKeihi = BizCurrency.valueOf(0);
        itjknhtyKeihi = BizCurrency.valueOf(0);
        yenItjknhtyKeihi = BizCurrency.valueOf(0);
        shrkykhtykeihi = BizCurrency.valueOf(0);
        kaiyakuHr = BizCurrency.valueOf(0);
        yenKaiyakuHr = BizCurrency.valueOf(0);
        sbymdKaiyakuhenreiknGk = BizCurrency.valueOf(0);
        yenSbymdKaiyakuhenreiknGk = BizCurrency.valueOf(0);
        tutaknGk = BizCurrency.valueOf(0);
        yenTutaknGk = BizCurrency.valueOf(0);
        sbymdTmttKnGk = BizCurrency.valueOf(0);
        yenSbymdTmttKnGk = BizCurrency.valueOf(0);
        hokenryoustGk = BizCurrency.valueOf(0);
        yenHokenryoustGk = BizCurrency.valueOf(0);
        pruikei = BizCurrency.valueOf(0);
        tienRisokuKisanYmd = null;
        tienRisokuSyuryouYmd = null;
        tienRskNissuu = 0;
        shrYmd = null;
        kykTuukasyu = C_Tuukasyu.BLNK;
        shrTuukasyu = C_Tuukasyu.BLNK;
        bunkatugoHokenKngk = BizCurrency.valueOf(0);
        bunkatugoYenHokenKngk = BizCurrency.valueOf(0);
        hokenkinsyuruiKbn = C_HokenkinsyuruiKbn.BLNK;
        hokenkinsyurui = "";
        hknKknKbn = C_HknKknKbn.BLNK;
        kihonHokenKngk = BizCurrency.valueOf(0);
        yenKihonHokenKngk = BizCurrency.valueOf(0);
        sbHokenKngk = BizCurrency.valueOf(0);
        yenSbHokenKngk = BizCurrency.valueOf(0);
        saigaiS = BizCurrency.valueOf(0);
        yenSaigaiS = BizCurrency.valueOf(0);
        sykSbYenSitiHsyuTkTekiUmu = C_UmuKbn.NONE;
        initSbjiYenkasSiteiHsygk = BizCurrency.valueOf(0);
        uktKyksyaTdk = C_UktKyksyaTdk.BLNK;
        zeimukwsratekjnymd = null;
        zeimukwsrate = BizNumber.valueOf(0);
        zeimuYenHokenknGk = BizCurrency.valueOf(0);
        gaikaknsnkwsrate = BizNumber.valueOf(0);
        vhtnaiteikakuteikbn = C_NaiteiKakuteiKbn.BLNK;
        haitoukin = BizCurrency.valueOf(0);
        yenkahaitoukin = BizCurrency.valueOf(0);
        sonotahaitoukin =  BizCurrency.valueOf(0);
        yenkasonotahaitoukin = BizCurrency.valueOf(0);
        misyuupjyuutoukaisuuy = 0;
        misyuupjyuutoukaisuum = 0;
        misyuupjyuutouym = null;
        misyuup = BizCurrency.valueOf(0);
        yenkamisyuup = BizCurrency.valueOf(0);
        mikeikapjyuutoukaisuuy = 0;
        mikeikapjyuutoukaisuum = 0;
        mikeikapjyuutouym = null;
        mikeikap = BizCurrency.valueOf(0);
        yenkamikeikap = BizCurrency.valueOf(0);
        zennouseisank = BizCurrency.valueOf(0);
        yenkazennouseisank = BizCurrency.valueOf(0);
        azukarikingk = BizCurrency.valueOf(0);
        yenkaazukarikingk = BizCurrency.valueOf(0);
        zitkazukarikingksiteituuka = BizCurrency.valueOf(0);
        yenzitkazukarikingksttk = BizCurrency.valueOf(0);
        zitkazukarikingkyen = BizCurrency.valueOf(0);
        gaikaknsnzitkazukarikingkyen = BizCurrency.valueOf(0);
        sonotaseisangk = BizCurrency.valueOf(0);
        yenkasonotaseisangk = BizCurrency.valueOf(0);
        krkgk = BizCurrency.valueOf(0);
        yenkakrkgk = BizCurrency.valueOf(0);
        shrgkkei = BizCurrency.valueOf(0);
        yenkashrgkgoukei = BizCurrency.valueOf(0);
        gaikaknsntskgk = BizCurrency.valueOf(0);
        gaikaknsnkkkgk = BizCurrency.valueOf(0);
        yenkaknsntskgk = BizCurrency.valueOf(0);
        yenkaknsnkkkgk = BizCurrency.valueOf(0);
        misyuusyonendojikaiikoup = BizCurrency.valueOf(0);
        misyuujinendoikoup = BizCurrency.valueOf(0);
        bunkatugohaitoukin = BizCurrency.valueOf(0);
        bunkatugoyenkahaitoukin = BizCurrency.valueOf(0);
        bunkatugosonotahaitoukin = BizCurrency.valueOf(0);
        bunkatugoyenkasonotahaitoukin = BizCurrency.valueOf(0);
        bunkatugomisyuup = BizCurrency.valueOf(0);
        bunkatugoyenkamisyuup = BizCurrency.valueOf(0);
        bunkatugomikeikap = BizCurrency.valueOf(0);
        bunkatugoyenkamikeikap = BizCurrency.valueOf(0);
        bunkatugozennouseisank = BizCurrency.valueOf(0);
        bunkatugoyenkazennouseisank = BizCurrency.valueOf(0);
        bunkatugoazukarikingk = BizCurrency.valueOf(0);
        bunkatugoyenkaazukarikingk = BizCurrency.valueOf(0);
        bunkatugokrkgk = BizCurrency.valueOf(0);
        bunkatugoyenkakrkgk = BizCurrency.valueOf(0);
        bunkatugogoukeigk = BizCurrency.valueOf(0);
        bunkatugoyenkagoukeigk = BizCurrency.valueOf(0);
        bunkatugoZitkazukarikingksiteituuka = BizCurrency.valueOf(0);
        bunkatugoZitkazukarikingkyen = BizCurrency.valueOf(0);
        bunkatugoGaikaknsntskgk = BizCurrency.valueOf(0);
        bunkatugoGaikaknsnkkkgk = BizCurrency.valueOf(0);
        bunkatugoYenkaknsntskgk = BizCurrency.valueOf(0);
        bunkatugoYenkaknsnkkkgk = BizCurrency.valueOf(0);
    }

    public C_SUketoriHouhouKbn getSUketoriHouhouKbn() {
        return sUketoriHouhouKbn;
    }

    public void setSUketoriHouhouKbn(C_SUketoriHouhouKbn pSUketoriHouhouKbn) {
        sUketoriHouhouKbn = pSUketoriHouhouKbn;
    }

    public BizDate getCalcKijyunYmd() {
        return calcKijyunYmd;
    }

    public void setCalcKijyunYmd(BizDate pCalcKijyunYmd) {
        calcKijyunYmd = pCalcKijyunYmd;
    }

    public BizDate getKnsnKijyunYmd() {
        return knsnKijyunYmd;
    }

    public void setKnsnKijyunYmd(BizDate pKnsnKijyunYmd) {
        knsnKijyunYmd = pKnsnKijyunYmd;
    }

    public BizNumber getKawaseRate() {
        return kawaseRate;
    }

    public void setKawaseRate(BizNumber pKawaseRate) {
        kawaseRate = pKawaseRate;
    }

    public BizNumber getUktBnWari() {
        return siHknknUktBnWari;
    }

    public void setUktBnWari(BizNumber pSiHknknUktBnWari) {
        siHknknUktBnWari = pSiHknknUktBnWari;
    }

    public BizCurrency getHokenknGk() {
        return hokenknGk;
    }

    public void setHokenknGk(BizCurrency pHokenknGk) {
        hokenknGk = pHokenknGk;
    }

    public BizCurrency getYenHokenknGk() {
        return yenHokenknGk;
    }

    public void setYenHokenknGk(BizCurrency pYenHokenknGk) {
        yenHokenknGk = pYenHokenknGk;
    }

    public BizDate getNkKknSetYmd() {
        return nkKknSetYmd;
    }

    public void setNkKknSetYmd(BizDate pNkKknSetYmd) {
        nkKknSetYmd = pNkKknSetYmd;
    }

    public BizDate getNkShrStartYmd() {
        return nkShrStartYmd;
    }

    public void setNkShrStartYmd(BizDate pNkShrStartYmd) {
        nkShrStartYmd = pNkShrStartYmd;
    }

    public C_Nstknsyu getNkShrTkykNksyuKbn() {
        return nkShrTkykNksyuKbn;
    }

    public void setNkShrTkykNksyuKbn(C_Nstknsyu pNkShrTkykNksyuKbn) {
        nkShrTkykNksyuKbn = pNkShrTkykNksyuKbn;
    }

    public Integer getNkShrTkykNksyuKkn() {
        return nkShrTkykNksyuKkn;
    }

    public void setNkShrTkykNksyuKkn(Integer pNkShrTkykNksyuKkn) {
        nkShrTkykNksyuKkn = pNkShrTkykNksyuKkn;
    }

    public C_Bnshrkaisuu getBnShrKaisuu() {
        return bnShrKaisuu;
    }

    public void setBnShrKaisuu(C_Bnshrkaisuu pBnShrKaisuu) {
        bnShrKaisuu = pBnShrKaisuu;
    }

    public BizCurrency getNkKknJyutouGk() {
        return nkKknJyutouGk;
    }

    public void setNkKknJyutouGk(BizCurrency pNkKknJyutouGk) {
        nkKknJyutouGk = pNkKknJyutouGk;
    }

    public BizCurrency getYenNkKknJyutouGk() {
        return yenNkKknJyutouGk;
    }

    public void setYenNkKknJyutouGk(BizCurrency pYenNkKknJyutouGk) {
        yenNkKknJyutouGk = pYenNkKknJyutouGk;
    }

    public BizCurrency getTienRsk() {
        return tienRsk;
    }

    public void setTienRsk(BizCurrency pTienRsk) {
        tienRsk = pTienRsk;
    }

    public BizCurrency getYenTienRsk() {
        return yenTienRsk;
    }

    public void setYenTienRsk(BizCurrency pYenTienRsk) {
        yenTienRsk = pYenTienRsk;
    }

    public BizCurrency getNkGns() {
        return nkGns;
    }

    public void setNkGns(BizCurrency pNkGns) {
        nkGns = pNkGns;
    }

    public BizCurrency getYenNkGns() {
        return yenNkGns;
    }

    public void setYenNkGns(BizCurrency pYenNkGns) {
        yenNkGns = pYenNkGns;
    }

    public BizCurrency getNkNengk() {
        return nkNengk;
    }

    public void setNkNengk(BizCurrency pNkNengk) {
        nkNengk = pNkNengk;
    }

    public BizCurrency getYenNkNengk() {
        return yenNkNengk;
    }

    public void setYenNkNengk(BizCurrency pYenNkNengk) {
        yenNkNengk = pYenNkNengk;
    }

    public BizCurrency getBnktnkGk() {
        return bnktnkGk;
    }

    public void setBnktnkGk(BizCurrency pBnktnkGk) {
        bnktnkGk = pBnktnkGk;
    }

    public BizCurrency getYenBnktnkGk() {
        return yenBnktnkGk;
    }

    public void setYenBnktnkGk(BizCurrency pYenBnktnkGk) {
        yenBnktnkGk = pYenBnktnkGk;
    }

    public BizCurrency getHtyKeihi() {
        return htyKeihi;
    }

    public void setHtyKeihi(BizCurrency pHtyKeihi) {
        htyKeihi = pHtyKeihi;
    }

    public BizCurrency getYenHtyKeihi() {
        return yenHtyKeihi;
    }

    public void setYenHtyKeihi(BizCurrency pYenHtyKeihi) {
        yenHtyKeihi = pYenHtyKeihi;
    }

    public BizCurrency getNkHtyKeihi() {
        return nkHtyKeihi;
    }

    public void setNkHtyKeihi(BizCurrency pNkHtyKeihi) {
        nkHtyKeihi = pNkHtyKeihi;
    }

    public BizCurrency getYenNkhtyKeihi() {
        return yenNkhtyKeihi;
    }

    public void setYenNkhtyKeihi(BizCurrency pYenNkhtyKeihi) {
        yenNkhtyKeihi = pYenNkhtyKeihi;
    }

    public BizCurrency getItjknhtyKeihi() {
        return itjknhtyKeihi;
    }

    public void setItjknhtyKeihi(BizCurrency pItjknhtyKeihi) {
        itjknhtyKeihi = pItjknhtyKeihi;
    }

    public BizCurrency getYenItjknhtyKeihi() {
        return yenItjknhtyKeihi;
    }

    public void setYenItjknhtyKeihi(BizCurrency pYenItjknhtyKeihi) {
        yenItjknhtyKeihi = pYenItjknhtyKeihi;
    }

    public BizCurrency getShrkykhtykeihi() {
        return shrkykhtykeihi;
    }

    public void setShrkykhtykeihi(BizCurrency pShrkykhtykeihi) {
        this.shrkykhtykeihi = pShrkykhtykeihi;
    }

    public BizCurrency getKaiyakuHr() {
        return kaiyakuHr;
    }

    public void setKaiyakuHr(BizCurrency pKaiyakuHr) {
        kaiyakuHr = pKaiyakuHr;
    }

    public BizCurrency getYenKaiyakuHr() {
        return yenKaiyakuHr;
    }

    public void setYenKaiyakuHr(BizCurrency pYenKaiyakuHr) {
        yenKaiyakuHr = pYenKaiyakuHr;
    }


    public BizCurrency getSbymdKaiyakuhenreiknGk() {
        return sbymdKaiyakuhenreiknGk;
    }

    public void setSbymdKaiyakuhenreiknGk(BizCurrency pSbymdKaiyakuhenreiknGk) {
        this.sbymdKaiyakuhenreiknGk = pSbymdKaiyakuhenreiknGk;
    }

    public BizCurrency getYenSbymdKaiyakuhenreiknGk() {
        return yenSbymdKaiyakuhenreiknGk;
    }

    public void setYenSbymdKaiyakuhenreiknGk(BizCurrency pYenSbymdKaiyakuhenreiknGk) {
        this.yenSbymdKaiyakuhenreiknGk = pYenSbymdKaiyakuhenreiknGk;
    }

    public BizCurrency getTutaknGk() {
        return tutaknGk;
    }

    public void setTutaknGk(BizCurrency pTutaknGk) {
        tutaknGk = pTutaknGk;
    }

    public BizCurrency getYenTutaknGk() {
        return yenTutaknGk;
    }

    public void setYenTutaknGk(BizCurrency pYenTutaknGk) {
        yenTutaknGk = pYenTutaknGk;
    }


    public BizCurrency getSbymdTmttKnGk() {
        return sbymdTmttKnGk;
    }

    public void setSbymdTmttKnGk(BizCurrency pSbymdTmttKnGk) {
        this.sbymdTmttKnGk = pSbymdTmttKnGk;
    }

    public BizCurrency getYenSbymdTmttKnGk() {
        return yenSbymdTmttKnGk;
    }

    public void setYenSbymdTmttKnGk(BizCurrency pYenSbymdTmttKnGk) {
        this.yenSbymdTmttKnGk = pYenSbymdTmttKnGk;
    }

    public BizCurrency getHokenryoustGk() {
        return hokenryoustGk;
    }

    public void setHokenryoustGk(BizCurrency pHokenryoustGk) {
        hokenryoustGk = pHokenryoustGk;
    }

    public BizCurrency getYenHokenryoustGk() {
        return yenHokenryoustGk;
    }

    public void setYenHokenryoustGk(BizCurrency pYenHokenryoustGk) {
        yenHokenryoustGk = pYenHokenryoustGk;
    }

    public BizCurrency getPruikei() {
        return pruikei;
    }

    public void setPruikei(BizCurrency pruikei) {
        this.pruikei = pruikei;
    }

    public BizDate getTienRisokuKisanYmd() {
        return tienRisokuKisanYmd;
    }

    public void setTienRisokuKisanYmd(BizDate pTienRisokuKisanYmd) {
        tienRisokuKisanYmd = pTienRisokuKisanYmd;
    }

    public BizDate getTienRisokuSyuryouYmd() {
        return tienRisokuSyuryouYmd;
    }

    public void setTienRisokuSyuryouYmd(BizDate pTienRisokuSyuryouYmd) {
        tienRisokuSyuryouYmd = pTienRisokuSyuryouYmd;
    }

    public Integer getTienRskNissuu() {
        return tienRskNissuu;
    }

    public void setTienRskNissuu(Integer pTienRskNissuu) {
        tienRskNissuu = pTienRskNissuu;
    }

    public BizDate getShrYmd() {
        return shrYmd;
    }

    public void setShrYmd(BizDate pShrYmd) {
        shrYmd = pShrYmd;
    }

    public C_Tuukasyu getKykTuukasyu() {
        return kykTuukasyu;
    }

    public void setKykTuukasyu(C_Tuukasyu pKykTuukasyu) {
        kykTuukasyu = pKykTuukasyu;
    }

    public C_Tuukasyu getShrTuukasyu() {
        return shrTuukasyu;
    }

    public void setShrTuukasyu(C_Tuukasyu pShrTuukasyu) {
        shrTuukasyu = pShrTuukasyu;
    }

    public BizCurrency  getBunkatugoHokenKngk() {
        return bunkatugoHokenKngk;
    }

    public void setBunkatugoHokenKngk(BizCurrency  pBunkatugoHokenKngk) {
        bunkatugoHokenKngk = pBunkatugoHokenKngk;
    }

    public BizCurrency getBunkatugoYenHokenKngk() {
        return bunkatugoYenHokenKngk;
    }

    public void setBunkatugoYenHokenKngk(BizCurrency pBunkatugoYenHokenKngk) {
        bunkatugoYenHokenKngk = pBunkatugoYenHokenKngk;
    }

    public C_HokenkinsyuruiKbn getHokenkinsyuruiKbn() {
        return hokenkinsyuruiKbn;
    }

    public void setHokenkinsyuruiKbn(C_HokenkinsyuruiKbn pHokenkinsyuruiKbn) {
        hokenkinsyuruiKbn = pHokenkinsyuruiKbn;
    }

    public String getHokenkinsyurui() {
        return hokenkinsyurui;
    }

    public void setHokenkinsyurui(String pHokenkinsyurui) {
        hokenkinsyurui = pHokenkinsyurui;
    }

    public C_HknKknKbn getHknKknKbn() {
        return hknKknKbn;
    }

    public void setHknKknKbn(C_HknKknKbn pHknKknKbn) {
        hknKknKbn = pHknKknKbn;
    }

    public BizCurrency getKihonHokenKngk() {
        return kihonHokenKngk;
    }

    public void setKihonHokenKngk(BizCurrency pKihonHokenKngk) {
        kihonHokenKngk = pKihonHokenKngk;
    }

    public BizCurrency getYenKihonHokenKngk() {
        return yenKihonHokenKngk;
    }

    public void setYenKihonHokenKngk(BizCurrency pYenKihonHokenKngk) {
        yenKihonHokenKngk = pYenKihonHokenKngk;
    }

    public BizCurrency getSbHokenKngk() {
        return sbHokenKngk;
    }

    public void setSbHokenKngk(BizCurrency pSbHokenKngk) {
        sbHokenKngk = pSbHokenKngk;
    }

    public BizCurrency getYenSbHokenKngk() {
        return yenSbHokenKngk;
    }

    public void setYenSbHokenKngk(BizCurrency pYenSbHokenKngk) {
        yenSbHokenKngk = pYenSbHokenKngk;
    }

    public BizCurrency getSaigaiS() {
        return saigaiS;
    }

    public void setSaigaiS(BizCurrency pSaigaiS) {
        saigaiS = pSaigaiS;
    }

    public BizCurrency getYenSaigaiS() {
        return yenSaigaiS;
    }

    public void setYenSaigaiS(BizCurrency pYenSaigaiS) {
        yenSaigaiS = pYenSaigaiS;
    }

    public C_UmuKbn getSykSbYenSitiHsyuTkTekiUmu() {
        return sykSbYenSitiHsyuTkTekiUmu;
    }

    public void setSykSbYenSitiHsyuTkTekiUmu(C_UmuKbn pSykSbYenSitiHsyuTkTekiUmu) {
        sykSbYenSitiHsyuTkTekiUmu = pSykSbYenSitiHsyuTkTekiUmu;
    }

    public BizCurrency getInitSbjiYenkasSiteiHsygk() {
        return initSbjiYenkasSiteiHsygk;
    }

    public void setInitSbjiYenkasSiteiHsygk(BizCurrency pInitSbjiYenkasSiteiHsygk) {
        initSbjiYenkasSiteiHsygk = pInitSbjiYenkasSiteiHsygk;
    }

    public C_UktKyksyaTdk getUktKyksyaTdk() {
        return uktKyksyaTdk;
    }

    public void setUktKyksyaTdk(C_UktKyksyaTdk pUktKyksyaTdk) {
        uktKyksyaTdk = pUktKyksyaTdk;
    }


    public BizDate getZeimukwsratekjnymd() {
        return zeimukwsratekjnymd;
    }

    public void setZeimukwsratekjnymd(BizDate pZeimukwsratekjnymd) {
        zeimukwsratekjnymd = pZeimukwsratekjnymd;
    }

    public BizNumber getZeimukwsrate() {
        return zeimukwsrate;
    }

    public void setZeimukwsrate(BizNumber pZeimukwsrate) {
        zeimukwsrate = pZeimukwsrate;
    }

    public BizCurrency getZeimuYenHokenknGk() {
        return zeimuYenHokenknGk;
    }

    public void setZeimuYenHokenknGk(BizCurrency pZeimuYenHokenknGk) {
        zeimuYenHokenknGk = pZeimuYenHokenknGk;
    }

    public BizNumber getGaikaknsnkwsrate() {
        return gaikaknsnkwsrate;
    }

    public void setGaikaknsnkwsrate(BizNumber pGaikaknsnkwsrate) {
        gaikaknsnkwsrate = pGaikaknsnkwsrate;
    }

    public C_NaiteiKakuteiKbn getVhtnaiteikakuteikbn() {
        return vhtnaiteikakuteikbn;
    }

    public void setVhtnaiteikakuteikbn(C_NaiteiKakuteiKbn vhtnaiteikakuteikbn) {
        this.vhtnaiteikakuteikbn = vhtnaiteikakuteikbn;
    }

    public BizCurrency getHaitoukin() {
        return haitoukin;
    }

    public void setHaitoukin(BizCurrency pHaitoukin) {
        haitoukin = pHaitoukin;
    }

    public BizCurrency getYenkahaitoukin() {
        return yenkahaitoukin;
    }

    public void setYenkahaitoukin(BizCurrency pYenkahaitoukin) {
        yenkahaitoukin = pYenkahaitoukin;
    }

    public BizCurrency getSonotahaitoukin() {
        return sonotahaitoukin;
    }

    public void setSonotahaitoukin(BizCurrency pSonotahaitoukin) {
        sonotahaitoukin = pSonotahaitoukin;
    }

    public BizCurrency getYenkasonotahaitoukin() {
        return yenkasonotahaitoukin;
    }

    public void setYenkasonotahaitoukin(BizCurrency pYenkasonotahaitoukin) {
        yenkasonotahaitoukin = pYenkasonotahaitoukin;
    }

    public Integer getMisyuupjyuutoukaisuuy() {
        return misyuupjyuutoukaisuuy;
    }

    public void setMisyuupjyuutoukaisuuy(Integer pMisyuupjyuutoukaisuuy) {
        misyuupjyuutoukaisuuy = pMisyuupjyuutoukaisuuy;
    }

    public Integer getMisyuupjyuutoukaisuum() {
        return misyuupjyuutoukaisuum;
    }

    public void setMisyuupjyuutoukaisuum(Integer pMisyuupjyuutoukaisuum) {
        misyuupjyuutoukaisuum = pMisyuupjyuutoukaisuum;
    }

    public BizDateYM getMisyuupjyuutouym() {
        return misyuupjyuutouym;
    }

    public void setMisyuupjyuutouym(BizDateYM pMisyuupjyuutouym) {
        misyuupjyuutouym = pMisyuupjyuutouym;
    }

    public BizCurrency getMisyuup() {
        return misyuup;
    }

    public void setMisyuup(BizCurrency pMisyuup) {
        misyuup = pMisyuup;
    }

    public BizCurrency getYenkamisyuup() {
        return yenkamisyuup;
    }

    public void setYenkamisyuup(BizCurrency pYenkamisyuup) {
        yenkamisyuup = pYenkamisyuup;
    }

    public Integer getMikeikapjyuutoukaisuuy() {
        return mikeikapjyuutoukaisuuy;
    }

    public void setMikeikapjyuutoukaisuuy(Integer pMikeikapjyuutoukaisuuy) {
        mikeikapjyuutoukaisuuy = pMikeikapjyuutoukaisuuy;
    }

    public Integer getMikeikapjyuutoukaisuum() {
        return mikeikapjyuutoukaisuum;
    }

    public void setMikeikapjyuutoukaisuum(Integer pMikeikapjyuutoukaisuum) {
        mikeikapjyuutoukaisuum = pMikeikapjyuutoukaisuum;
    }

    public BizDateYM getMikeikapjyuutouym() {
        return mikeikapjyuutouym;
    }

    public void setMikeikapjyuutouym(BizDateYM pMikeikapjyuutouym) {
        mikeikapjyuutouym = pMikeikapjyuutouym;
    }

    public BizCurrency getMikeikap() {
        return mikeikap;
    }

    public void setMikeikap(BizCurrency pMikeikap) {
        mikeikap = pMikeikap;
    }

    public BizCurrency getYenkamikeikap() {
        return yenkamikeikap;
    }

    public void setYenkamikeikap(BizCurrency pYenkamikeikap) {
        yenkamikeikap = pYenkamikeikap;
    }

    public BizCurrency getZennouseisank() {
        return zennouseisank;
    }

    public void setZennouseisank(BizCurrency pZennouseisank) {
        zennouseisank = pZennouseisank;
    }

    public BizCurrency getYenkazennouseisank() {
        return yenkazennouseisank;
    }

    public void setYenkazennouseisank(BizCurrency pYenkazennouseisank) {
        yenkazennouseisank = pYenkazennouseisank;
    }

    public BizCurrency getAzukarikingk() {
        return azukarikingk;
    }

    public void setAzukarikingk(BizCurrency pAzukarikingk) {
        azukarikingk = pAzukarikingk;
    }

    public BizCurrency getYenkaazukarikingk() {
        return yenkaazukarikingk;
    }

    public void setYenkaazukarikingk(BizCurrency pYenkaazukarikingk) {
        yenkaazukarikingk = pYenkaazukarikingk;
    }

    public BizCurrency getZitkazukarikingksiteituuka() {
        return zitkazukarikingksiteituuka;
    }

    public void setZitkazukarikingksiteituuka(BizCurrency pZitkazukarikingksiteituuka) {
        zitkazukarikingksiteituuka = pZitkazukarikingksiteituuka;
    }

    public BizCurrency getYenzitkazukarikingksttk() {
        return yenzitkazukarikingksttk;
    }

    public void setYenzitkazukarikingksttk(BizCurrency pYenzitkazukarikingksttk) {
        yenzitkazukarikingksttk = pYenzitkazukarikingksttk;
    }

    public BizCurrency getZitkazukarikingkyen() {
        return zitkazukarikingkyen;
    }

    public void setZitkazukarikingkyen(BizCurrency pZitkazukarikingkyen) {
        zitkazukarikingkyen = pZitkazukarikingkyen;
    }

    public BizCurrency getGaikaknsnzitkazukarikingkyen() {
        return gaikaknsnzitkazukarikingkyen;
    }

    public void setGaikaknsnzitkazukarikingkyen(BizCurrency pGaikaknsnzitkazukarikingkyen) {
        gaikaknsnzitkazukarikingkyen = pGaikaknsnzitkazukarikingkyen;
    }

    public BizCurrency getSonotaseisangk() {
        return sonotaseisangk;
    }

    public void setSonotaseisangk(BizCurrency pSonotaseisangk) {
        sonotaseisangk = pSonotaseisangk;
    }

    public BizCurrency getYenkasonotaseisangk() {
        return yenkasonotaseisangk;
    }

    public void setYenkasonotaseisangk(BizCurrency pYenkasonotaseisangk) {
        yenkasonotaseisangk = pYenkasonotaseisangk;
    }

    public BizCurrency getKrkgk() {
        return krkgk;
    }

    public void setKrkgk(BizCurrency pKrkgk) {
        krkgk = pKrkgk;
    }

    public BizCurrency getYenkakrkgk() {
        return yenkakrkgk;
    }

    public void setYenkakrkgk(BizCurrency pYenkakrkgk) {
        yenkakrkgk = pYenkakrkgk;
    }

    public BizCurrency getShrgkkei() {
        return shrgkkei;
    }

    public void setShrgkkei(BizCurrency pShrgkkei) {
        shrgkkei = pShrgkkei;
    }

    public BizCurrency getYenkashrgkgoukei() {
        return yenkashrgkgoukei;
    }

    public void setYenkashrgkgoukei(BizCurrency pYenkashrgkgoukei) {
        yenkashrgkgoukei = pYenkashrgkgoukei;
    }

    public BizCurrency getGaikaknsntskgk() {
        return gaikaknsntskgk;
    }

    public void setGaikaknsntskgk(BizCurrency pGaikaknsntskgk) {
        gaikaknsntskgk = pGaikaknsntskgk;
    }

    public BizCurrency getGaikaknsnkkkgk() {
        return gaikaknsnkkkgk;
    }

    public void setGaikaknsnkkkgk(BizCurrency pGaikaknsnkkkgk) {
        gaikaknsnkkkgk = pGaikaknsnkkkgk;
    }

    public BizCurrency getYenkaknsntskgk() {
        return yenkaknsntskgk;
    }

    public void setYenkaknsntskgk(BizCurrency pYenkaknsntskgk) {
        yenkaknsntskgk = pYenkaknsntskgk;
    }

    public BizCurrency getYenkaknsnkkkgk() {
        return yenkaknsnkkkgk;
    }

    public void setYenkaknsnkkkgk(BizCurrency pYenkaknsnkkkgk) {
        yenkaknsnkkkgk = pYenkaknsnkkkgk;
    }

    public BizCurrency getMisyuusyonendojikaiikoup() {
        return misyuusyonendojikaiikoup;
    }

    public void setMisyuusyonendojikaiikoup(BizCurrency pMisyuusyonendojikaiikoup) {
        misyuusyonendojikaiikoup = pMisyuusyonendojikaiikoup;
    }

    public BizCurrency getMisyuujinendoikoup() {
        return misyuujinendoikoup;
    }

    public void setMisyuujinendoikoup(BizCurrency pMisyuujinendoikoup) {
        misyuujinendoikoup = pMisyuujinendoikoup;
    }

    public BizCurrency getBunkatugohaitoukin() {
        return bunkatugohaitoukin;
    }

    public void setBunkatugohaitoukin(BizCurrency pBunkatugohaitoukin) {
        bunkatugohaitoukin = pBunkatugohaitoukin;
    }

    public BizCurrency getBunkatugoyenkahaitoukin() {
        return bunkatugoyenkahaitoukin;
    }

    public void setBunkatugoyenkahaitoukin(BizCurrency pBunkatugoyenkahaitoukin) {
        bunkatugoyenkahaitoukin = pBunkatugoyenkahaitoukin;
    }

    public BizCurrency getBunkatugosonotahaitoukin() {
        return bunkatugosonotahaitoukin;
    }

    public void setBunkatugosonotahaitoukin(BizCurrency pBunkatugosonotahaitoukin) {
        bunkatugosonotahaitoukin = pBunkatugosonotahaitoukin;
    }

    public BizCurrency getBunkatugoyenkasonotahaitoukin() {
        return bunkatugoyenkasonotahaitoukin;
    }

    public void setBunkatugoyenkasonotahaitoukin(BizCurrency pBunkatugoyenkasonotahaitoukin) {
        bunkatugoyenkasonotahaitoukin = pBunkatugoyenkasonotahaitoukin;
    }

    public BizCurrency getBunkatugomisyuup() {
        return bunkatugomisyuup;
    }

    public void setBunkatugomisyuup(BizCurrency pBunkatugomisyuup) {
        bunkatugomisyuup = pBunkatugomisyuup;
    }

    public BizCurrency getBunkatugoyenkamisyuup() {
        return bunkatugoyenkamisyuup;
    }

    public void setBunkatugoyenkamisyuup(BizCurrency pBunkatugoyenkamisyuup) {
        bunkatugoyenkamisyuup = pBunkatugoyenkamisyuup;
    }

    public BizCurrency getBunkatugomikeikap() {
        return bunkatugomikeikap;
    }

    public void setBunkatugomikeikap(BizCurrency pBunkatugomikeikap) {
        bunkatugomikeikap = pBunkatugomikeikap;
    }

    public BizCurrency getBunkatugoyenkamikeikap() {
        return bunkatugoyenkamikeikap;
    }

    public void setBunkatugoyenkamikeikap(BizCurrency pBunkatugoyenkamikeikap) {
        bunkatugoyenkamikeikap = pBunkatugoyenkamikeikap;
    }

    public BizCurrency getBunkatugozennouseisank() {
        return bunkatugozennouseisank;
    }

    public void setBunkatugozennouseisank(BizCurrency pBunkatugozennouseisank) {
        bunkatugozennouseisank = pBunkatugozennouseisank;
    }

    public BizCurrency getBunkatugoyenkazennouseisank() {
        return bunkatugoyenkazennouseisank;
    }

    public void setBunkatugoyenkazennouseisank(BizCurrency pBunkatugoyenkazennouseisank) {
        bunkatugoyenkazennouseisank = pBunkatugoyenkazennouseisank;
    }

    public BizCurrency getBunkatugoazukarikingk() {
        return bunkatugoazukarikingk;
    }

    public void setBunkatugoazukarikingk(BizCurrency pBunkatugoazukarikingk) {
        bunkatugoazukarikingk = pBunkatugoazukarikingk;
    }

    public BizCurrency getBunkatugoyenkaazukarikingk() {
        return bunkatugoyenkaazukarikingk;
    }

    public void setBunkatugoyenkaazukarikingk(BizCurrency pBunkatugoyenkaazukarikingk) {
        bunkatugoyenkaazukarikingk = pBunkatugoyenkaazukarikingk;
    }

    public BizCurrency getBunkatugokrkgk() {
        return bunkatugokrkgk;
    }

    public void setBunkatugokrkgk(BizCurrency pBunkatugokrkgk) {
        bunkatugokrkgk = pBunkatugokrkgk;
    }

    public BizCurrency getBunkatugoyenkakrkgk() {
        return bunkatugoyenkakrkgk;
    }

    public void setBunkatugoyenkakrkgk(BizCurrency pBunkatugoyenkakrkgk) {
        bunkatugoyenkakrkgk = pBunkatugoyenkakrkgk;
    }

    public BizCurrency getBunkatugogoukeigk() {
        return bunkatugogoukeigk;
    }

    public void setBunkatugogoukeigk(BizCurrency pBunkatugogoukeigk) {
        this.bunkatugogoukeigk = pBunkatugogoukeigk;
    }

    public BizCurrency getBunkatugoyenkagoukeigk() {
        return bunkatugoyenkagoukeigk;
    }

    public void setBunkatugoyenkagoukeigk(BizCurrency pBunkatugoyenkagoukeigk) {
        this.bunkatugoyenkagoukeigk = pBunkatugoyenkagoukeigk;
    }

    public BizCurrency getBunkatugoZitkazukarikingksiteituuka() {
        return bunkatugoZitkazukarikingksiteituuka;
    }

    public void setBunkatugoZitkazukarikingksiteituuka(BizCurrency bunkatugoZitkazukarikingksiteituuka) {
        this.bunkatugoZitkazukarikingksiteituuka = bunkatugoZitkazukarikingksiteituuka;
    }

    public BizCurrency getBunkatugoZitkazukarikingkyen() {
        return bunkatugoZitkazukarikingkyen;
    }

    public void setBunkatugoZitkazukarikingkyen(BizCurrency bunkatugoZitkazukarikingkyen) {
        this.bunkatugoZitkazukarikingkyen = bunkatugoZitkazukarikingkyen;
    }

    public BizCurrency getBunkatugoGaikaknsntskgk() {
        return bunkatugoGaikaknsntskgk;
    }

    public void setBunkatugoGaikaknsntskgk(BizCurrency bunkatugoGaikaknsntskgk) {
        this.bunkatugoGaikaknsntskgk = bunkatugoGaikaknsntskgk;
    }

    public BizCurrency getBunkatugoGaikaknsnkkkgk() {
        return bunkatugoGaikaknsnkkkgk;
    }

    public void setBunkatugoGaikaknsnkkkgk(BizCurrency bunkatugoGaikaknsnkkkgk) {
        this.bunkatugoGaikaknsnkkkgk = bunkatugoGaikaknsnkkkgk;
    }

    public BizCurrency getBunkatugoYenkaknsntskgk() {
        return bunkatugoYenkaknsntskgk;
    }

    public void setBunkatugoYenkaknsntskgk(BizCurrency bunkatugoYenkaknsntskgk) {
        this.bunkatugoYenkaknsntskgk = bunkatugoYenkaknsntskgk;
    }

    public BizCurrency getBunkatugoYenkaknsnkkkgk() {
        return bunkatugoYenkaknsnkkkgk;
    }

    public void setBunkatugoYenkaknsnkkkgk(BizCurrency bunkatugoYenkaknsnkkkgk) {
        this.bunkatugoYenkaknsnkkkgk = bunkatugoYenkaknsnkkkgk;
    }

}
