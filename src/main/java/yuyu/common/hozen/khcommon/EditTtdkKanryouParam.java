package yuyu.common.hozen.khcommon;

import java.util.List;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import yuyu.def.classification.C_DseisansouhusakihnsyuKbn;
import yuyu.def.classification.C_DseisantetudukimeiKbn;
import yuyu.def.classification.C_Gantkhukkatuyh;
import yuyu.def.classification.C_GengkhouKbn;
import yuyu.def.classification.C_JyudkaigomaebaraiTkykhnkKbn;
import yuyu.def.classification.C_Kaiyakujiyuu;
import yuyu.def.classification.C_KjkhukaKbn;
import yuyu.def.classification.C_KykdrtkykttdkKbn;
import yuyu.def.classification.C_KzkTrkServicettdkKbn;
import yuyu.def.classification.C_MousideninKbn;
import yuyu.def.classification.C_Nenkinsyu;
import yuyu.def.classification.C_SksmongonKbn;
import yuyu.def.classification.C_SosysaiyouhiKbn;
import yuyu.def.classification.C_SoukinsakisiteiKbn;
import yuyu.def.classification.C_StdrsktkyhnkKbn;
import yuyu.def.classification.C_SyoriKbn;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.classification.C_TargetTkKbn;
import yuyu.def.classification.C_TargetTkMokuhyoutiKbn;
import yuyu.def.classification.C_TetudukisyuKbn;
import yuyu.def.classification.C_Tmttknitenkbn;
import yuyu.def.classification.C_TrkKzkHnkKbn;
import yuyu.def.classification.C_TrkkzkttdkKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UktKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_YenShrTkHnkKbn;
import yuyu.def.classification.C_YykidouuktkKbn;
import yuyu.def.classification.C_ZeitratkiKbn;

import com.google.common.collect.Lists;

/**
 * 契約保全 契約保全共通 手続完了作成用パラメータ
 */
public class EditTtdkKanryouParam {

    private C_TetudukisyuKbn tetudukisyuKbn;

    private C_UmuKbn siharaiUmu = C_UmuKbn.NONE;

    private BizDate kouryokuYmd;

    private C_UmuKbn hrkKeiroHnkUmu = C_UmuKbn.NONE;

    private C_UmuKbn hrkKaisuuHnkUmu = C_UmuKbn.NONE;

    private BizDate hkSknnKaisiYmd;

    private BizDate hkGansknnKaisiYmd;

    private C_Gantkhukkatuyh gantkHukkatuYh = C_Gantkhukkatuyh.BLNK;

    private C_Kaiyakujiyuu kaiyakuJiyuu = C_Kaiyakujiyuu.BLNK;

    private C_SosysaiyouhiKbn sosysaiYouhiKbn = C_SosysaiyouhiKbn.BLNK;

    private C_YykidouuktkKbn yykIdouUktkKbn = C_YykidouuktkKbn.BLNK;

    private C_SyoruiCdKbn syoruiCd = C_SyoruiCdKbn.BLNK;

    private C_UmuKbn syoukenDhUmuKbn = C_UmuKbn.NONE;

    private String shskyNo = "";

    private String shadr1Kj = "";

    private String shadr2Kj = "";

    private String shadr3Kj = "";

    private String shsNmKj = "";

    private C_SyoriKbn syorikbn = C_SyoriKbn.BLNK;

    private C_SoukinsakisiteiKbn soukinsakisiteikbn = C_SoukinsakisiteiKbn.BLNK;

    private C_UmuKbn hhknseiYmdHenkouUmu = C_UmuKbn.NONE;

    private C_UmuKbn hhknseiHenkouUmu = C_UmuKbn.NONE;

    private Integer bfrTargetTkmokuhyouti = 0;

    private C_Nenkinsyu bfrNenkinsyu = C_Nenkinsyu.BLNK;

    private Integer bfrNenkinKkn = 0;

    private C_YenShrTkHnkKbn yenShrTkHnkKbn = C_YenShrTkHnkKbn.BLNK;

    private C_GengkhouKbn gengkhouKbn = C_GengkhouKbn.BLNK;

    private BizCurrency bfrHokenryou;

    private BizCurrency bfrKihonS;

    private C_UktKbn stdruktKbn = C_UktKbn.BLNK;

    private C_KjkhukaKbn stdrskNmKjhukaKbn = C_KjkhukaKbn.BLNK;

    private String stdrskNmKj = "";

    private String stdrskNmKn = "";

    private BizDate calcKijyunYMD;

    private C_JyudkaigomaebaraiTkykhnkKbn jyudkaigomaebaraitkykhnkkbn = C_JyudkaigomaebaraiTkykhnkKbn.BLNK;

    private C_TargetTkKbn targetTkKbn = C_TargetTkKbn.BLNK;

    private C_TargetTkMokuhyoutiKbn targetTkMkhtKbn = C_TargetTkMokuhyoutiKbn.BLNK;

    private BizDate targetTkKykHenkouYmd;

    private C_Tmttknitenkbn tmttknitenkbn = C_Tmttknitenkbn.BLNK;

    private BizDate tmttknitenYmd;

    private C_UmuKbn gengakukeiiUmu = C_UmuKbn.NONE;

    private BizNumber nyknKawaserate;

    private BizNumber yendtHnkjiKawaserate;

    private BizCurrency yendtHnkjikaiyakuhrGaika;

    private BizCurrency yendtHnkjikaiyakuhrYen;

    private BizCurrency yendthnkHr;

    private BizCurrency newKaiyakuhr;

    private String documentId = "";

    private int hozonKikanY = 0;

    private C_SksmongonKbn sksmongonKbn1 = C_SksmongonKbn.BLNK;

    private C_SksmongonKbn sksmongonKbn2 = C_SksmongonKbn.BLNK;

    private C_Tuukasyu bfrTuukasyu = C_Tuukasyu.BLNK;

    private BizCurrency bfrHrkP;

    private BizCurrency bfrTargetTkKjnKngk;

    private BizCurrency tmtthtkinzndk;

    private C_UmuKbn gsbunritaisyouFlg = C_UmuKbn.NONE;

    private C_UmuKbn pminyuuSyoumetuShrtyousyoOutZumiFlg = C_UmuKbn.NONE;

    private C_UmuKbn yuuyokknTyoukaUmu = C_UmuKbn.NONE;

    private BizDate kykniyuhnkymd;

    private C_DseisantetudukimeiKbn dseisantetudukimeiKbn = C_DseisantetudukimeiKbn.BLNK;

    private C_DseisansouhusakihnsyuKbn dseisansouhusakihnsyuKbn = C_DseisansouhusakihnsyuKbn.BLNK;

    private C_ZeitratkiKbn dseisanzeitratkiKbn;

    private C_MousideninKbn mousideninKbn = C_MousideninKbn.BLNK;

    private C_TrkKzkHnkKbn trkKzkHnkNiyuKbn1 = C_TrkKzkHnkKbn.BLNK;

    private C_TrkKzkHnkKbn trkKzkHnkNiyuKbn2 = C_TrkKzkHnkKbn.BLNK;

    private String kykdairinmkj = "";

    private String sakujyoTrkKzknm1 = "";

    private String sakujyoTrkKzknm2 = "";

    private C_KzkTrkServicettdkKbn trkKzkServicettdkKbn = C_KzkTrkServicettdkKbn.BLNK;

    private C_KykdrtkykttdkKbn kykdrtkykttdkKbn = C_KykdrtkykttdkKbn.BLNK;

    private C_UktKbn bfrKykdairinKbn = C_UktKbn.BLNK;

    private C_UktKbn aftKykdairinKbn = C_UktKbn.BLNK;

    private C_TrkkzkttdkKbn trkkzkttdkKbn1 = C_TrkkzkttdkKbn.BLNK;

    private C_TrkkzkttdkKbn trkkzkttdkKbn2 = C_TrkkzkttdkKbn.BLNK;

    private List<TyokusouTaisyouBean> tyokusouTaisyouList = Lists.newArrayList();

    private List<DouhuuTaisyouBean> douhuuTaisyouList = Lists.newArrayList();

    private C_StdrsktkyhnkKbn stdrsktkyhnkKbn = C_StdrsktkyhnkKbn.BLNK;

    public EditTtdkKanryouParam() {
        super();
    }

    public C_TetudukisyuKbn getTetudukiSyu() {
        return tetudukisyuKbn;
    }

    public void setTetudukiSyu(C_TetudukisyuKbn pTetudukiSyu) {
        tetudukisyuKbn = pTetudukiSyu;
    }

    public C_UmuKbn getSiharaiUmu() {
        return siharaiUmu;
    }

    public void setSiharaiUmu(C_UmuKbn pSiharaiUmu) {
        siharaiUmu = pSiharaiUmu;
    }

    public BizDate getKouryokuYMD() {
        return kouryokuYmd;
    }

    public void setKouryokuYMD(BizDate pKouryokuYMD) {
        kouryokuYmd = pKouryokuYMD;
    }

    public C_UmuKbn getHrkkeirohnkumu() {
        return hrkKeiroHnkUmu;
    }

    public void setHrkkeirohnkumu(C_UmuKbn pHrkkeirohnkumu) {
        hrkKeiroHnkUmu = pHrkkeirohnkumu;
    }

    public C_UmuKbn getHrkkaisuuhnkumu() {
        return hrkKaisuuHnkUmu;
    }

    public void setHrkkaisuuhnkumu(C_UmuKbn pHrkkaisuuhnkumu) {
        hrkKaisuuHnkUmu = pHrkkaisuuhnkumu;
    }

    public BizDate getHksknnkaisiYMD() {
        return hkSknnKaisiYmd;
    }

    public void setHksknnkaisiYMD(BizDate pHksknnkaisiYMD) {
        hkSknnKaisiYmd = pHksknnkaisiYMD;
    }

    public BizDate getHkgansknnkaisiYMD() {
        return hkGansknnKaisiYmd;
    }

    public void setHkgansknnkaisiYMD(BizDate pHkgansknnkaisiYMD) {
        hkGansknnKaisiYmd = pHkgansknnkaisiYMD;
    }

    public C_Gantkhukkatuyh getGantkhukkatuyh() {
        return gantkHukkatuYh;
    }

    public void setGantkhukkatuyh(C_Gantkhukkatuyh pGantkhukkatuyh) {
        gantkHukkatuYh = pGantkhukkatuyh;
    }

    public C_Kaiyakujiyuu getKaiyakuJiyuu() {
        return kaiyakuJiyuu;
    }

    public void setKaiyakuJiyuu(C_Kaiyakujiyuu pKaiyakuJiyuu) {
        kaiyakuJiyuu = pKaiyakuJiyuu;
    }

    public C_SosysaiyouhiKbn getSyosaihkyouhi() {
        return sosysaiYouhiKbn;
    }

    public void setSyosaihkyouhi(C_SosysaiyouhiKbn pSyosaihkyouhi) {
        sosysaiYouhiKbn = pSyosaihkyouhi;
    }

    public C_YykidouuktkKbn getYykidouuktk() {
        return yykIdouUktkKbn;
    }

    public void setYykidouuktk(C_YykidouuktkKbn pYykidouuktk) {
        yykIdouUktkKbn = pYykidouuktk;
    }

    public C_SyoruiCdKbn getSyoruiCd() {
        return syoruiCd;
    }

    public void setSyoruiCdKbn(C_SyoruiCdKbn pSyoruiCdKbn) {
        syoruiCd = pSyoruiCdKbn;
    }

    public C_UmuKbn getSyokenDoufuUmu() {
        return syoukenDhUmuKbn;
    }

    public void setSyokenDoufuUmu(C_UmuKbn pSyokenDoufuUmu) {
        syoukenDhUmuKbn = pSyokenDoufuUmu;
    }

    public String getShsyno() {
        return shskyNo;
    }

    public void setShsyno(String pShsyno) {
        shskyNo = pShsyno;
    }

    public String getShsadr1kj() {
        return shadr1Kj;
    }

    public void setShsadr1kj(String pShsadr1kj) {
        shadr1Kj = pShsadr1kj;
    }

    public String getShsadr2kj() {
        return shadr2Kj;
    }

    public void setShsadr2kj(String pShsadr2kj) {
        shadr2Kj = pShsadr2kj;
    }

    public String getShsadr3kj() {
        return shadr3Kj;
    }

    public void setShsadr3kj(String pShsadr3kj) {
        shadr3Kj = pShsadr3kj;
    }

    public String getShsnmkj() {
        return shsNmKj;
    }

    public void setShsnmkj(String pShsNmKj) {
        shsNmKj = pShsNmKj;
    }

    public C_SyoriKbn getSyorikbn() {
        return syorikbn;
    }

    public void setSyorikbn(C_SyoriKbn pSyorikbn) {
        syorikbn = pSyorikbn;
    }

    public C_SoukinsakisiteiKbn getSoukinsakisiteikbn() {
        return soukinsakisiteikbn;
    }

    public void setSoukinsakisiteikbn(C_SoukinsakisiteiKbn pSoukinsakisiteikbn) {
        soukinsakisiteikbn = pSoukinsakisiteikbn;
    }

    public C_UmuKbn getHhknseiymdHnUmu() {
        return hhknseiYmdHenkouUmu;
    }

    public void setHhknseiymdHnUmu(C_UmuKbn pHhknseiymdHnUmu) {
        hhknseiYmdHenkouUmu = pHhknseiymdHnUmu;
    }

    public C_UmuKbn getHhknseiHnUmu() {
        return hhknseiHenkouUmu;
    }

    public void setHhknseiHnUmu(C_UmuKbn pHhknseiHnUmu) {
        hhknseiHenkouUmu = pHhknseiHnUmu;
    }

    public Integer getBfrTargettkmokuhyouti() {
        return bfrTargetTkmokuhyouti;
    }

    public void setBfrTargettkmokuhyouti(Integer pBfrTargettkmokuhyouti) {
        bfrTargetTkmokuhyouti = pBfrTargettkmokuhyouti;
    }

    public C_Nenkinsyu getBfrNenkinsyu() {
        return bfrNenkinsyu;
    }

    public void setBfrNenkinsyu(C_Nenkinsyu pBfrNenkinsyu) {
        bfrNenkinsyu = pBfrNenkinsyu;
    }

    public Integer getBfrNenkinkkn() {
        return bfrNenkinKkn;
    }

    public void setBfrNenkinkkn(Integer pBfrNenkinkkn) {
        bfrNenkinKkn = pBfrNenkinkkn;
    }

    public C_YenShrTkHnkKbn getYenShrTkHnkKbn() {
        return yenShrTkHnkKbn;
    }

    public void setYenShrTkHnkKbn(C_YenShrTkHnkKbn pYenShrTkHnkKbn) {
        yenShrTkHnkKbn = pYenShrTkHnkKbn;
    }

    public C_GengkhouKbn getGengkhou() {
        return gengkhouKbn;
    }

    public void setGengkhou(C_GengkhouKbn pGengkhouKbn) {
        gengkhouKbn = pGengkhouKbn;
    }

    public BizCurrency getBfrP() {
        return bfrHokenryou;
    }

    public void setBfrP(BizCurrency pBfrP) {
        bfrHokenryou = pBfrP;
    }

    public BizCurrency getBfrKihons() {
        return bfrKihonS;
    }

    public void setBfrKihons(BizCurrency pBfrKihons) {
        bfrKihonS = pBfrKihons;
    }

    public C_UktKbn getStdruktkbn() {
        return stdruktKbn;
    }

    public void setStdruktkbn(C_UktKbn pStdruktkbn) {
        stdruktKbn = pStdruktkbn;
    }

    public C_KjkhukaKbn getStdrskKjkhuka() {
        return stdrskNmKjhukaKbn;
    }

    public void setStdrskKjkhuka(C_KjkhukaKbn pStdrskKjkhuka) {
        stdrskNmKjhukaKbn = pStdrskKjkhuka;
    }

    public String getStdrsknmkj() {
        return stdrskNmKj;
    }

    public void setStdrsknmkj(String pStdrsknmkj) {
        stdrskNmKj = pStdrsknmkj;
    }

    public String getStdrsknmkn() {
        return stdrskNmKn;
    }

    public void setStdrsknmkn(String pStdrsknmkn) {
        stdrskNmKn = pStdrsknmkn;
    }

    public BizDate getCalckijyunYMD() {
        return calcKijyunYMD;
    }

    public void setCalckijyunYMD(BizDate pCalckijyunYMD) {
        calcKijyunYMD = pCalckijyunYMD;
    }

    public C_JyudkaigomaebaraiTkykhnkKbn getJyudkaigomaebaraitkykhnkkbn() {
        return jyudkaigomaebaraitkykhnkkbn;
    }

    public void setJyudkaigomaebaraitkykhnkkbn(C_JyudkaigomaebaraiTkykhnkKbn pJyudkaigomaebaraitkykhnkkbn) {
        jyudkaigomaebaraitkykhnkkbn = pJyudkaigomaebaraitkykhnkkbn;
    }

    public C_TargetTkKbn getTargetTkKbn() {
        return targetTkKbn;
    }

    public void setTargetTkKbn(C_TargetTkKbn pTargetTkKbn) {
        targetTkKbn = pTargetTkKbn;
    }

    public C_TargetTkMokuhyoutiKbn getTargetTkMkhtKbn() {
        return targetTkMkhtKbn;
    }

    public void setTargetTkMkhtKbn(C_TargetTkMokuhyoutiKbn pTargetTkMkhtKbn) {
        targetTkMkhtKbn = pTargetTkMkhtKbn;
    }

    public BizDate getTargetTkKykHenkouYmd() {
        return targetTkKykHenkouYmd;
    }

    public void setTargetTkKykHenkouYmd(BizDate pTargetTkKykHenkouYmd) {
        targetTkKykHenkouYmd = pTargetTkKykHenkouYmd;
    }

    public C_Tmttknitenkbn getTmttknitenkbn() {
        return tmttknitenkbn;
    }

    public void setTmttknitenkbn(C_Tmttknitenkbn pTmttknitenkbn) {
        tmttknitenkbn = pTmttknitenkbn;
    }

    public BizDate getTmttknitenYmd() {
        return tmttknitenYmd;
    }

    public void setTmttknitenYmd(BizDate pTmttknitenYmd) {
        tmttknitenYmd = pTmttknitenYmd;
    }

    public BizNumber getNyknKawaserate() {
        return nyknKawaserate;
    }

    public void setNyknKawaserate(BizNumber pNyknKawaserate) {
        nyknKawaserate = pNyknKawaserate;
    }

    public BizNumber getYendtHnkjiKawaserate() {
        return yendtHnkjiKawaserate;
    }

    public void setYendtHnkjiKawaserate(BizNumber pYendtHnkjiKawaserate) {
        yendtHnkjiKawaserate = pYendtHnkjiKawaserate;
    }

    public C_UmuKbn getGengakukeiiUmu() {
        return gengakukeiiUmu;
    }

    public void setGengakukeiiUmu(C_UmuKbn pGengakukeiiUmu) {
        gengakukeiiUmu = pGengakukeiiUmu;
    }

    public BizCurrency getYendtHnkjikaiyakuhrGaika() {
        return yendtHnkjikaiyakuhrGaika;
    }

    public void setYendtHnkjikaiyakuhrGaika(BizCurrency pYendtHnkjikaiyakuhrGaika) {
        yendtHnkjikaiyakuhrGaika = pYendtHnkjikaiyakuhrGaika;
    }

    public BizCurrency getYendtHnkjikaiyakuhrYen() {
        return yendtHnkjikaiyakuhrYen;
    }

    public void setYendtHnkjikaiyakuhrYen(BizCurrency pYendtHnkjikaiyakuhrYen) {
        yendtHnkjikaiyakuhrYen = pYendtHnkjikaiyakuhrYen;
    }

    public BizCurrency getYendthnkHr() {
        return yendthnkHr;
    }

    public void setYendthnkHr(BizCurrency pYendthnkHr) {
        yendthnkHr = pYendthnkHr;
    }

    public BizCurrency getNewKaiyakuhr() {
        return newKaiyakuhr;
    }

    public void setNewKaiyakuhr(BizCurrency pNewKaiyakuhr) {
        newKaiyakuhr = pNewKaiyakuhr;
    }

    public String getDocumentId() {
        return documentId;
    }

    public void setDocumentId(String pDocumentId) {
        documentId = pDocumentId;
    }

    public int getHozonKikanY() {
        return hozonKikanY;
    }

    public void setHozonKikanY(int pHozonKikanY) {
        hozonKikanY = pHozonKikanY;
    }

    public C_SksmongonKbn getSksmongonKbn1() {
        return sksmongonKbn1;
    }

    public void setSksmongonKbn1(C_SksmongonKbn pSksmongonKbn1) {
        sksmongonKbn1 = pSksmongonKbn1;
    }

    public C_SksmongonKbn getSksmongonKbn2() {
        return sksmongonKbn2;
    }

    public void setSksmongonKbn2(C_SksmongonKbn pSksmongonKbn2) {
        sksmongonKbn2 = pSksmongonKbn2;
    }

    public C_Tuukasyu getBfrTuukasyu() {
        return bfrTuukasyu;
    }

    public void setBfrTuukasyu(C_Tuukasyu pBfrTuukasyu) {
        bfrTuukasyu = pBfrTuukasyu;
    }

    public BizCurrency getBfrHrkP() {
        return bfrHrkP;
    }

    public void setBfrHrkP(BizCurrency pBfrHrkP) {
        bfrHrkP = pBfrHrkP;
    }

    public BizCurrency getBfrTargetTkKjnKngk() {
        return bfrTargetTkKjnKngk;
    }

    public void setBfrTargetTkKjnKngk(BizCurrency pBfrTargetTkKjnKngk) {
        bfrTargetTkKjnKngk = pBfrTargetTkKjnKngk;
    }

    public BizCurrency getTmtthtkinzndk() {
        return tmtthtkinzndk;
    }

    public void setTmtthtkinzndk(BizCurrency pTmtthtkinzndk) {
        tmtthtkinzndk = pTmtthtkinzndk;
    }

    public C_UmuKbn getGsbunritaisyouFlg() {
        return gsbunritaisyouFlg;
    }

    public void setGsbunritaisyouFlg(C_UmuKbn pGsbunritaisyouFlg) {
        gsbunritaisyouFlg = pGsbunritaisyouFlg;
    }

    public C_UmuKbn getYuuyokknTyoukaUmu() {
        return yuuyokknTyoukaUmu;
    }

    public void setYuuyokknTyoukaUmu(C_UmuKbn pYuuyokknTyoukaUmu) {
        yuuyokknTyoukaUmu = pYuuyokknTyoukaUmu;
    }

    public BizDate getKykniyuhnkymd() {
        return kykniyuhnkymd;
    }

    public void setKykniyuhnkymd(BizDate pKykniyuhnkymd) {
        kykniyuhnkymd = pKykniyuhnkymd;
    }

    public C_UmuKbn getPminyuuSyoumetuShrtyousyoOutZumiFlg() {
        return pminyuuSyoumetuShrtyousyoOutZumiFlg;
    }

    public void setPminyuuSyoumetuShrtyousyoOutZumiFlg(C_UmuKbn pPminyuuSyoumetuShrtyousyoOutZumiFlg) {
        pminyuuSyoumetuShrtyousyoOutZumiFlg = pPminyuuSyoumetuShrtyousyoOutZumiFlg;
    }

    public C_DseisantetudukimeiKbn getDseisantetudukimeiKbn() {
        return dseisantetudukimeiKbn;
    }

    public void setDseisantetudukimeiKbn(C_DseisantetudukimeiKbn pDseisantetudukimeiKbn) {
        dseisantetudukimeiKbn = pDseisantetudukimeiKbn;
    }

    public C_DseisansouhusakihnsyuKbn getDseisansouhusakihnsyuKbn() {
        return dseisansouhusakihnsyuKbn;
    }

    public void setDseisansouhusakihnsyuKbn(C_DseisansouhusakihnsyuKbn pDseisansouhusakihnsyuKbn) {
        dseisansouhusakihnsyuKbn = pDseisansouhusakihnsyuKbn;
    }

    public C_ZeitratkiKbn getDseisanzeitratkiKbn() {
        return dseisanzeitratkiKbn;
    }

    public void setDseisanzeitratkiKbn(C_ZeitratkiKbn pDseisanzeitratkiKbn) {
        dseisanzeitratkiKbn = pDseisanzeitratkiKbn;
    }

    public C_MousideninKbn getMousideninKbn() {
        return mousideninKbn;
    }

    public void setMousideninKbn(C_MousideninKbn pMousideninKbn) {
        mousideninKbn = pMousideninKbn;
    }

    public C_TrkKzkHnkKbn getTrkKzkHnkNiyuKbn1() {
        return trkKzkHnkNiyuKbn1;
    }

    public void setTrkKzkHnkNiyuKbn1(C_TrkKzkHnkKbn pTrkKzkHnkNiyuKbn1) {
        trkKzkHnkNiyuKbn1 = pTrkKzkHnkNiyuKbn1;
    }

    public C_TrkKzkHnkKbn getTrkKzkHnkNiyuKbn2() {
        return trkKzkHnkNiyuKbn2;
    }

    public void setTrkKzkHnkNiyuKbn2(C_TrkKzkHnkKbn pTrkKzkHnkNiyuKbn2) {
        trkKzkHnkNiyuKbn2 = pTrkKzkHnkNiyuKbn2;
    }

    public String getKykdairinmkj() {
        return kykdairinmkj;
    }

    public void setKykdairinmkj(String pKykdairinmkj) {
        kykdairinmkj = pKykdairinmkj;
    }

    public String getSakujyoTrkKzknm1() {
        return sakujyoTrkKzknm1;
    }

    public void setSakujyoTrkKzknm1(String pSakujyoTrkKzknm1) {
        sakujyoTrkKzknm1 = pSakujyoTrkKzknm1;
    }

    public String getSakujyoTrkKzknm2() {
        return sakujyoTrkKzknm2;
    }

    public void setSakujyoTrkKzknm2(String pSakujyoTrkKzknm2) {
        sakujyoTrkKzknm2 = pSakujyoTrkKzknm2;
    }

    public C_KzkTrkServicettdkKbn getTrkKzkServicettdkKbn() {
        return trkKzkServicettdkKbn;
    }

    public void setTrkKzkServicettdkKbn(C_KzkTrkServicettdkKbn pTrkKzkServicettdkKbn) {
        trkKzkServicettdkKbn = pTrkKzkServicettdkKbn;
    }

    public C_KykdrtkykttdkKbn getKykdrtkykttdkKbn() {
        return kykdrtkykttdkKbn;
    }

    public void setKykdrtkykttdkKbn(C_KykdrtkykttdkKbn pKykdrtkykttdkKbn) {
        kykdrtkykttdkKbn = pKykdrtkykttdkKbn;
    }

    public C_UktKbn getBfrKykdairinKbn() {
        return bfrKykdairinKbn;
    }

    public void setBfrKykdairinKbn(C_UktKbn pBfrKykdairinKbn) {
        bfrKykdairinKbn = pBfrKykdairinKbn;
    }

    public C_UktKbn getAftKykdairinKbn() {
        return aftKykdairinKbn;
    }

    public void setAftKykdairinKbn(C_UktKbn pAftKykdairinKbn) {
        aftKykdairinKbn = pAftKykdairinKbn;
    }

    public C_TrkkzkttdkKbn getTrkkzkttdkKbn1() {
        return trkkzkttdkKbn1;
    }

    public void setTrkkzkttdkKbn1(C_TrkkzkttdkKbn pTrkkzkttdkKbn1) {
        trkkzkttdkKbn1 = pTrkkzkttdkKbn1;
    }

    public C_TrkkzkttdkKbn getTrkkzkttdkKbn2() {
        return trkkzkttdkKbn2;
    }

    public void setTrkkzkttdkKbn2(C_TrkkzkttdkKbn pTrkkzkttdkKbn2) {
        trkkzkttdkKbn2 = pTrkkzkttdkKbn2;
    }

    public List<TyokusouTaisyouBean> getTyokusouTaisyouList() {
        return tyokusouTaisyouList;
    }

    public void setTyokusouTaisyouList(List<TyokusouTaisyouBean> pTyokusouTaisyouList) {
        tyokusouTaisyouList = pTyokusouTaisyouList;
    }

    public List<DouhuuTaisyouBean> getDouhuuTaisyouList() {
        return douhuuTaisyouList;
    }

    public void setDouhuuTaisyouList(List<DouhuuTaisyouBean> pDouhuuTaisyouList) {
        douhuuTaisyouList = pDouhuuTaisyouList;
    }

    public C_StdrsktkyhnkKbn getStdrsktkyhnkKbn() {
        return stdrsktkyhnkKbn;
    }

    public void setStdrsktkyhnkKbn(C_StdrsktkyhnkKbn pStdrsktkyhnkKbn) {
        stdrsktkyhnkKbn = pStdrsktkyhnkKbn;
    }
}
