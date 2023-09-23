package yuyu.common.hozen.khcommon;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.number.BizCurrency;
import yuyu.def.classification.C_JyudkaigomaebaraiTkykhnkKbn;
import yuyu.def.classification.C_KahiKbn;
import yuyu.def.classification.C_Kaiyakujiyuu;
import yuyu.def.classification.C_Khhrshrjiyuu;
import yuyu.def.classification.C_Khskssakuseijiyuu;
import yuyu.def.classification.C_Meigihnkjiyuu;
import yuyu.def.classification.C_MousideninKbn;
import yuyu.def.classification.C_NstkhKbn;
import yuyu.def.classification.C_TargetTkHenkouKbn;
import yuyu.def.classification.C_TargetTkKbn;
import yuyu.def.classification.C_Tmttknitenkbn;
import yuyu.def.classification.C_UmuKbn;

/**
 * 契約保全 契約保全共通 送付案内作成用パラメータ
 */
public class EditSouhuannaiParam {

    private       C_Meigihnkjiyuu      meigihnkJiyuu               = C_Meigihnkjiyuu.BLNK;

    private       String               shsNmKj                     = "";

    private       String               shsyNo                      = "";

    private       String               shsadr1Kj                   = "";

    private       String               shsadr2Kj                   = "";

    private       String               shsadr3Kj                   = "";

    private       String               hyshantyouhyouNm            = "";

    private       String               hyshaninjiNaiyou            = "";

    private       C_UmuKbn             targetTkHkUmu              = C_UmuKbn.NONE;

    private       C_TargetTkHenkouKbn  targetTkHenkouKbn           = C_TargetTkHenkouKbn.BLNK;

    private       C_TargetTkKbn        targetTkKbn                 = C_TargetTkKbn.BLNK;

    private       BizDate              nextTkshrkjt                = null;

    private       BizDate              seikyuukigenYmd             = null;

    private       C_UmuKbn             henkankinumuKbn             = C_UmuKbn.NONE;

    private       C_UmuKbn             tuikaHrkkinUmu              = C_UmuKbn.NONE;

    private       BizCurrency          tuikaHrkkin                 = BizCurrency.valueOf(0);

    private       C_NstkhKbn           nkshrtkykhnkKbn             = C_NstkhKbn.BLNK;

    private       C_Kaiyakujiyuu       kaiyakujiyuu                = C_Kaiyakujiyuu.BLNK;

    private       BizDate              syoumetuYmd                 = null;

    private       BizCurrency          haraimodosiKngk             = BizCurrency.valueOf(0);

    private       C_UmuKbn       trhkjikakumukbn                   = C_UmuKbn.NONE;

    private       C_JyudkaigomaebaraiTkykhnkKbn      jyudkaigomaebrtkykhnkkbn  = C_JyudkaigomaebaraiTkykhnkKbn.BLNK;

    private       C_UmuKbn       hhknseiymdhenkouumu               = C_UmuKbn.NONE;

    private       C_UmuKbn       hhknseihenkouumu                  = C_UmuKbn.NONE;

    private       BizCurrency          yendthnkhrgk                = BizCurrency.valueOf(0);

    private       C_Khskssakuseijiyuu  skssakuseijiyuu             = C_Khskssakuseijiyuu.BLNK;

    private       C_Khhrshrjiyuu       hrshrjiyuu                  = C_Khhrshrjiyuu.BLNK;

    private       C_Tmttknitenkbn      tmttknitenkbn               = C_Tmttknitenkbn.BLNK;

    private       BizDate              tmttknitenuktkstartymd      = null;

    private       BizDate              syoruiuktkkigenymd          = null;

    private       C_UmuKbn             gsbunritaisyouumukbn        = C_UmuKbn.NONE;

    private       BizDate               calckijyunymd              = null;

    private       BizCurrency           tmtthtkinzndk              = BizCurrency.valueOf(0);

    private       C_KahiKbn             tmttknitenuktkkahikbn      = C_KahiKbn.HUKA;

    private       C_UmuKbn             mynosinkokutaisyouumukbn    = C_UmuKbn.NONE;

    private       C_MousideninKbn      mousideninkbn               = C_MousideninKbn.BLNK;

    public EditSouhuannaiParam() {
        super();
    }

    public C_Meigihnkjiyuu getMeigihnkjiyuu() {
        return meigihnkJiyuu;
    }

    public void setMeigihnkjiyuu(C_Meigihnkjiyuu pMeigihnkjiyuu) {
        meigihnkJiyuu = pMeigihnkjiyuu;
    }

    public String getShsnmkj() {
        return shsNmKj;
    }

    public void setShsnmkj(String pShsnmkj) {
        shsNmKj = pShsnmkj;
    }

    public String getShsyno() {
        return shsyNo;
    }

    public void setShsyno(String pShsyno) {
        shsyNo = pShsyno;
    }

    public String getShsadr1kj() {
        return shsadr1Kj;
    }

    public void setShsadr1kj(String pShsadr1kj) {
        shsadr1Kj = pShsadr1kj;
    }

    public String getShsadr2kj() {
        return shsadr2Kj;
    }

    public void setShsadr2kj(String pShsadr2kj) {
        shsadr2Kj = pShsadr2kj;
    }

    public String getShsadr3kj() {
        return shsadr3Kj;
    }

    public void setShsadr3kj(String pShsadr3kj) {
        shsadr3Kj = pShsadr3kj;
    }

    public String getHyshantyouhyounm() {
        return hyshantyouhyouNm;
    }

    public void setHyshantyouhyounm(String pHyshantyouhyounm) {
        hyshantyouhyouNm = pHyshantyouhyounm;
    }

    public String getHyshaninjinaiyou() {
        return hyshaninjiNaiyou;
    }

    public void setHyshaninjinaiyou(String pHyshaninjinaiyou) {
        hyshaninjiNaiyou = pHyshaninjinaiyou;
    }

    public C_UmuKbn getTargetTkHkUmu() {
        return targetTkHkUmu;
    }

    public void setTargetTkHkUmu(C_UmuKbn pTargetTkHkUmu) {
        targetTkHkUmu = pTargetTkHkUmu;
    }

    public C_TargetTkHenkouKbn getTargetTkHenkouKbn() {
        return targetTkHenkouKbn;
    }

    public void setTargetTkHenkouKbn(C_TargetTkHenkouKbn pTargetTkHenkouKbn) {
        targetTkHenkouKbn = pTargetTkHenkouKbn;
    }

    public C_TargetTkKbn getTargetTkKbn() {
        return targetTkKbn;
    }

    public void setTargetTkKbn(C_TargetTkKbn pTargetTkKbn) {
        targetTkKbn = pTargetTkKbn;
    }

    public BizDate getNextTkshrkjt() {
        return nextTkshrkjt;
    }

    public void setNextTkshrkjt(BizDate pNextTkshrkjt) {
        nextTkshrkjt = pNextTkshrkjt;
    }

    public BizDate getSeikyuukigenYmd() {
        return seikyuukigenYmd;
    }

    public void setSeikyuukigenYmd(BizDate pSeikyuukigenYmd) {
        seikyuukigenYmd = pSeikyuukigenYmd;
    }

    public C_UmuKbn getHenkankinumuKbn() {
        return henkankinumuKbn;
    }

    public void setHenkankinumuKbn(C_UmuKbn pHenkankinumuKbn) {
        henkankinumuKbn = pHenkankinumuKbn;
    }

    public C_UmuKbn getTuikaHrkkinUmu() {
        return tuikaHrkkinUmu;
    }

    public void setTuikaHrkkinUmu(C_UmuKbn pTuikaHrkkinUmu) {
        tuikaHrkkinUmu = pTuikaHrkkinUmu;
    }

    public BizCurrency getTuikaHrkkin() {
        return tuikaHrkkin;
    }

    public void setTuikaHrkkin(BizCurrency pTuikaHrkkin) {
        tuikaHrkkin = pTuikaHrkkin;
    }

    public C_NstkhKbn getNkshrtkykhnkKbn() {
        return nkshrtkykhnkKbn;
    }

    public void setNkshrtkykhnkKbn(C_NstkhKbn pNkshrtkykhnkKbn) {
        nkshrtkykhnkKbn = pNkshrtkykhnkKbn;
    }

    public C_Kaiyakujiyuu getKaiyakujiyuu() {
        return kaiyakujiyuu;
    }

    public void setKaiyakujiyuu(C_Kaiyakujiyuu pKaiyakujiyuu) {
        kaiyakujiyuu = pKaiyakujiyuu;
    }

    public C_UmuKbn getTrhkjikakumukbn() {
        return trhkjikakumukbn;
    }

    public void setTrhkjikakumukbn(C_UmuKbn pTrhkjikakumukbn) {
        trhkjikakumukbn = pTrhkjikakumukbn;
    }

    public C_JyudkaigomaebaraiTkykhnkKbn getJyudkaigomaebrtkykhnkkbn() {
        return jyudkaigomaebrtkykhnkkbn;
    }

    public void setJyudkaigomaebrtkykhnkkbn(C_JyudkaigomaebaraiTkykhnkKbn pJyudkaigomaebrtkykhnkkbn) {
        jyudkaigomaebrtkykhnkkbn = pJyudkaigomaebrtkykhnkkbn;
    }

    public C_UmuKbn getHhknseiymdhenkouumu() {
        return hhknseiymdhenkouumu;
    }

    public void setHhknseiymdhenkouumu(C_UmuKbn pHhknseiymdhenkouumu) {
        hhknseiymdhenkouumu = pHhknseiymdhenkouumu;
    }

    public C_UmuKbn getHhknseihenkouumu() {
        return hhknseihenkouumu;
    }

    public void setHhknseihenkouumu(C_UmuKbn pHhknseihenkouumu) {
        hhknseihenkouumu = pHhknseihenkouumu;
    }

    public BizCurrency getYendthnkhrgk() {
        return yendthnkhrgk;
    }

    public void setYendthnkhrgk(BizCurrency pYendthnkhrgk) {
        yendthnkhrgk = pYendthnkhrgk;
    }

    public C_Khskssakuseijiyuu getSkssakuseijiyuu() {
        return skssakuseijiyuu;
    }

    public void setSkssakuseijiyuu(C_Khskssakuseijiyuu pSkssakuseijiyuu) {
        skssakuseijiyuu = pSkssakuseijiyuu;
    }

    public C_Khhrshrjiyuu getHrshrjiyuu() {
        return hrshrjiyuu;
    }

    public void setHrshrjiyuu(C_Khhrshrjiyuu pHrshrjiyuu) {
        hrshrjiyuu = pHrshrjiyuu;
    }

    public C_Tmttknitenkbn getTmttknitenkbn() {
        return tmttknitenkbn;
    }

    public void setTmttknitenkbn(C_Tmttknitenkbn pTmttknitenkbn) {
        tmttknitenkbn = pTmttknitenkbn;
    }

    public BizDate getTmttknitenuktkstartymd() {
        return tmttknitenuktkstartymd;
    }

    public void setTmttknitenuktkstartymd(BizDate pTmttknitenuktkstartymd) {
        tmttknitenuktkstartymd = pTmttknitenuktkstartymd;
    }

    public BizDate getSyoruiuktkkigenymd() {
        return syoruiuktkkigenymd;
    }

    public void setSyoruiuktkkigenymd(BizDate pSyoruiuktkkigenymd) {
        syoruiuktkkigenymd = pSyoruiuktkkigenymd;
    }

    public C_UmuKbn getGsbunritaisyouumukbn() {
        return gsbunritaisyouumukbn;
    }

    public void setGsbunritaisyouumukbn(C_UmuKbn pGsbunritaisyouumukbn) {
        gsbunritaisyouumukbn = pGsbunritaisyouumukbn;
    }

    public BizDate getCalckijyunymd() {
        return calckijyunymd;
    }

    public void setCalckijyunymd(BizDate pCalckijyunymd) {
        calckijyunymd = pCalckijyunymd;
    }

    public BizCurrency getTmtthtkinzndk() {
        return tmtthtkinzndk;
    }

    public void setTmtthtkinzndk(BizCurrency pTmtthtkinzndk) {
        tmtthtkinzndk = pTmtthtkinzndk;
    }

    public C_KahiKbn getTmttknitenuktkkahikbn() {
        return tmttknitenuktkkahikbn;
    }

    public void setTmttknitenuktkkahikbn(C_KahiKbn pTmttknitenuktkkahikbn) {
        tmttknitenuktkkahikbn = pTmttknitenuktkkahikbn;
    }

    public BizDate getSyoumetuymd() {
        return syoumetuYmd;
    }

    public void setSyoumetuymd(BizDate pSyoumetuYmd) {
        syoumetuYmd = pSyoumetuYmd;
    }

    public BizCurrency getHaraimodosikngk() {
        return haraimodosiKngk;
    }

    public void setHaraimodosikngk(BizCurrency pHaraimodosikngk) {
        haraimodosiKngk = pHaraimodosikngk;
    }

    public C_UmuKbn getMynosinkokutaisyouumukbn() {
        return mynosinkokutaisyouumukbn;
    }

    public void setMynosinkokutaisyouumukbn(C_UmuKbn pMynosinkokutaisyouumukbn) {
        mynosinkokutaisyouumukbn = pMynosinkokutaisyouumukbn;
    }

    public C_MousideninKbn getMousideninkbn() {
        return mousideninkbn;
    }

    public void setMousideninkbn(C_MousideninKbn pMousideninkbn) {
        this.mousideninkbn = pMousideninkbn;
    }
}

