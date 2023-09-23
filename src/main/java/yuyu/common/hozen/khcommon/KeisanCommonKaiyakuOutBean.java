package yuyu.common.hozen.khcommon;

import java.io.Serializable;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import yuyu.common.suuri.srcommon.EditDshrTukiDKoumokuBean;
import yuyu.def.classification.C_FiSiyouKbn;
import yuyu.def.classification.C_NaiteiKakuteiKbn;
import yuyu.def.classification.C_RatesyutokukekkaKbn;
import yuyu.def.classification.C_Segcd;
import yuyu.def.classification.C_UmuKbn;

/**
 * 契約保全 契約保全共通 解約共通計算出力Beanクラス
 */
public class KeisanCommonKaiyakuOutBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private BizCurrency shrgkkeigk;

    private BizCurrency shrgkkeiYen;

    private BizCurrency sonotashrgkgk;

    private BizCurrency sonotashrgkYen;

    private BizCurrency kaiyakuhrgoukeigk;

    private BizCurrency kaiyakuhrgoukeiYen;

    private BizCurrency kaiyakuHr;

    private BizCurrency kaiyakuHrYen;

    private BizCurrency yendthnkkaiyakuhr;

    private BizCurrency ptumitatekin;

    private BizCurrency sjkkkTyouseiGk;

    private BizNumber sjkkkTyouseiRitu;

    private BizNumber kaiyakusjkkktyouseiriritu;

    private BizCurrency teiriTutmttKngk;

    private BizCurrency sisuuRendouTmttKngkl;

    private BizCurrency kaiyakuKjgk;

    private BizNumber kaiyakuKjRitu;

    private C_FiSiyouKbn fiSiyouKbn;

    private BizCurrency zennouseisankGk;

    private BizCurrency zennouseisankYen;

    private BizCurrency mikeikapGk;

    private BizCurrency mikeikapYen;

    private BizDateYM mikeikaPjyutouYm;

    private Integer mikeikaPJyutouKaisuuY;

    private Integer mikeikaPJyutouKaisuuM;

    private MiKeikaPBean[] miKeikaPBeans;

    private BizCurrency azukariGanrikingk;

    private BizCurrency azukariGanrikinYen;

    private BizCurrency krkgkYen;

    private BizCurrency haitoukinYen;

    private BizCurrency yentkbthaitoukin;

    private BizCurrency tmtthaitoukinYen;

    private BizCurrency  sonotahaitoukinYen;

    private BizCurrency sonotaseisan;

    private C_Segcd segcdOne;

    private C_Segcd segcdTwo;

    private BizCurrency gstszeigk;

    private BizCurrency gaikaShrYenGsTsZeigk;

    private BizCurrency gaikaShrYenGsTsZeigkKokuz;

    private BizCurrency gaikaShrYenGsTsZeigkTihouz;

    private C_UmuKbn gaikaGsBunriTaisyouFlag;

    private BizCurrency gaikaShrYenGsTsTaisyouSaeki;

    private BizCurrency gaikaShrYenHtyKeihi;

    private C_RatesyutokukekkaKbn zeimuRatesyutokukekkaKbn;

    private BizDate  zeimuRatesyutokuYmd;

    private BizNumber zeimukwsrate;

    private BizCurrency gensengkYenkaiyakuhr;

    private BizCurrency jpygstszeigk;

    private BizCurrency jpyShrjiYengstszeigkKokuz;

    private BizCurrency jpyShrjiYengstszeigkTihouz;

    private C_UmuKbn jpyGsBunriTaisyouFlag;

    private BizCurrency jpyKaShrYenGsTsTaisyouSaeki;

    private BizCurrency jpyShrjiYenhtykeihi;

    private C_UmuKbn gsbunritaisyouFlg;

    private BizCurrency synykngk;

    private BizCurrency htykeihi;

    private Integer kykhnkkaisuu;

    private BizCurrency yenShrKykHtyKeihi;

    private BizCurrency yengstszeigk;

    private BizCurrency yengststaisyousaeki;

    private BizDateYM lastpjytoym;

    private C_UmuKbn zennoumijyuutouFlg;

    private C_NaiteiKakuteiKbn khHaitouKanriNaiteiKakuteiKbn;

    private EditDshrTukiDKoumokuBean editDshrTukiDKoumokuBean;

    public BizCurrency getShrgkkeigk() {
        return shrgkkeigk;
    }

    public void setShrgkkeigk(BizCurrency pShrgkkeigk) {
        this.shrgkkeigk = pShrgkkeigk;
    }

    public BizCurrency getShrgkkeiYen() {
        return shrgkkeiYen;
    }

    public void setShrgkkeiYen(BizCurrency pShrgkkeiYen) {
        this.shrgkkeiYen = pShrgkkeiYen;
    }

    public BizCurrency getSonotashrgkgk() {
        return sonotashrgkgk;
    }

    public void setSonotashrgkgk(BizCurrency pSonotashrgkgk) {
        this.sonotashrgkgk = pSonotashrgkgk;
    }

    public BizCurrency getSonotashrgkYen() {
        return sonotashrgkYen;
    }

    public void setSonotashrgkYen(BizCurrency pSonotashrgkYen) {
        this.sonotashrgkYen = pSonotashrgkYen;
    }

    public BizCurrency getKaiyakuhrgoukeigk() {
        return kaiyakuhrgoukeigk;
    }

    public void setKaiyakuhrgoukeigk(BizCurrency pKaiyakuhrgoukeigk) {
        this.kaiyakuhrgoukeigk = pKaiyakuhrgoukeigk;
    }

    public BizCurrency getKaiyakuhrgoukeiYen() {
        return kaiyakuhrgoukeiYen;
    }

    public void setKaiyakuhrgoukeiYen(BizCurrency pKaiyakuhrgoukeiYen) {
        this.kaiyakuhrgoukeiYen = pKaiyakuhrgoukeiYen;
    }

    public BizCurrency getKaiyakuHr() {
        return kaiyakuHr;
    }

    public void setKaiyakuHr(BizCurrency pKaiyakuHr) {
        this.kaiyakuHr = pKaiyakuHr;
    }

    public BizCurrency getKaiyakuHrYen() {
        return kaiyakuHrYen;
    }

    public void setKaiyakuHrYen(BizCurrency pKaiyakuHrYen) {
        this.kaiyakuHrYen = pKaiyakuHrYen;
    }

    public BizCurrency getYendthnkkaiyakuhr() {
        return yendthnkkaiyakuhr;
    }

    public void setYendthnkkaiyakuhr(BizCurrency pYendthnkkaiyakuhr) {
        this.yendthnkkaiyakuhr = pYendthnkkaiyakuhr;
    }

    public BizCurrency getPtumitatekin() {
        return ptumitatekin;
    }

    public void setPtumitatekin(BizCurrency pPtumitatekin) {
        this.ptumitatekin = pPtumitatekin;
    }

    public BizCurrency getSjkkkTyouseiGk() {
        return sjkkkTyouseiGk;
    }

    public void setSjkkkTyouseiGk(BizCurrency pSjkkkTyouseiGk) {
        this.sjkkkTyouseiGk = pSjkkkTyouseiGk;
    }

    public BizNumber getSjkkkTyouseiRitu() {
        return sjkkkTyouseiRitu;
    }

    public void setSjkkkTyouseiRitu(BizNumber pSjkkkTyouseiRitu) {
        this.sjkkkTyouseiRitu = pSjkkkTyouseiRitu;
    }

    public BizNumber getKaiyakusjkkktyouseiriritu() {
        return kaiyakusjkkktyouseiriritu;
    }

    public void setKaiyakusjkkktyouseiriritu(BizNumber pKaiyakusjkkktyouseiriritu) {
        this.kaiyakusjkkktyouseiriritu = pKaiyakusjkkktyouseiriritu;
    }

    public BizCurrency getTeiriTutmttKngk() {
        return teiriTutmttKngk;
    }

    public void setTeiriTutmttKngk(BizCurrency pTeiriTutmttKngk) {
        this.teiriTutmttKngk = pTeiriTutmttKngk;
    }

    public BizCurrency getSisuuRendouTmttKngkl() {
        return sisuuRendouTmttKngkl;
    }

    public void setSisuuRendouTmttKngkl(BizCurrency pSisuuRendouTmttKngkl) {
        this.sisuuRendouTmttKngkl = pSisuuRendouTmttKngkl;
    }

    public BizCurrency getKaiyakuKjgk() {
        return kaiyakuKjgk;
    }

    public void setKaiyakuKjgk(BizCurrency pKaiyakuKjgk) {
        this.kaiyakuKjgk = pKaiyakuKjgk;
    }

    public BizNumber getKaiyakuKjRitu() {
        return kaiyakuKjRitu;
    }

    public void setKaiyakuKjRitu(BizNumber pKaiyakuKjRitu) {
        this.kaiyakuKjRitu = pKaiyakuKjRitu;
    }

    public C_FiSiyouKbn getFiSiyouKbn() {
        return fiSiyouKbn;
    }

    public void setFiSiyouKbn(C_FiSiyouKbn pFiSiyouKbn) {
        this.fiSiyouKbn = pFiSiyouKbn;
    }

    public BizCurrency getZennouseisankGk() {
        return zennouseisankGk;
    }

    public void setZennouseisankGk(BizCurrency pZennouseisankGk) {
        this.zennouseisankGk = pZennouseisankGk;
    }

    public BizCurrency getZennouseisankYen() {
        return zennouseisankYen;
    }

    public void setZennouseisankYen(BizCurrency pZennouseisankYen) {
        this.zennouseisankYen = pZennouseisankYen;
    }

    public BizCurrency getMikeikapGk() {
        return mikeikapGk;
    }

    public void setMikeikapGk(BizCurrency pMikeikapGk) {
        this.mikeikapGk = pMikeikapGk;
    }

    public BizCurrency getMikeikapYen() {
        return mikeikapYen;
    }

    public void setMikeikapYen(BizCurrency pMikeikapYen) {
        this.mikeikapYen = pMikeikapYen;
    }
    public BizDateYM getMikeikaPjyutouYm() {
        return mikeikaPjyutouYm;
    }

    public void setMikeikaPjyutouYm(BizDateYM pMikeikaPjyutouYm) {
        this.mikeikaPjyutouYm = pMikeikaPjyutouYm;
    }

    public Integer getMikeikaPJyutouKaisuuY() {
        return mikeikaPJyutouKaisuuY;
    }

    public void setMikeikaPJyutouKaisuuY(Integer pMikeikaPJyutouKaisuuY) {
        this.mikeikaPJyutouKaisuuY = pMikeikaPJyutouKaisuuY;
    }

    public Integer getMikeikaPJyutouKaisuuM() {
        return mikeikaPJyutouKaisuuM;
    }

    public void setMikeikaPJyutouKaisuuM(Integer pMikeikaPJyutouKaisuuM) {
        this.mikeikaPJyutouKaisuuM = pMikeikaPJyutouKaisuuM;
    }

    public MiKeikaPBean[] getMiKeikaPBeans() {
        return miKeikaPBeans;
    }

    public void setMiKeikaPBeans(MiKeikaPBean[] pMiKeikaPBeans) {
        this.miKeikaPBeans = pMiKeikaPBeans;
    }

    public BizCurrency getAzukariGanrikingk() {
        return azukariGanrikingk;
    }

    public void setAzukariGanrikingk(BizCurrency pAzukariGanrikingk) {
        this.azukariGanrikingk = pAzukariGanrikingk;
    }

    public BizCurrency getAzukariGanrikinYen() {
        return azukariGanrikinYen;
    }

    public void setAzukariGanrikinYen(BizCurrency pAzukariGanrikinYen) {
        this.azukariGanrikinYen = pAzukariGanrikinYen;
    }

    public BizCurrency getKrkgkYen() {
        return krkgkYen;
    }

    public void setKrkgkYen(BizCurrency pKrkgkYen) {
        this.krkgkYen = pKrkgkYen;
    }

    public BizCurrency getHaitoukinYen() {
        return haitoukinYen;
    }

    public void setHaitoukinYen(BizCurrency pHaitoukinYen) {
        this.haitoukinYen = pHaitoukinYen;
    }

    public BizCurrency getYentkbthaitoukin() {
        return yentkbthaitoukin;
    }

    public void setYentkbthaitoukin(BizCurrency pYentkbthaitoukin) {
        this.yentkbthaitoukin = pYentkbthaitoukin;
    }

    public BizCurrency getTmtthaitoukinYen() {
        return tmtthaitoukinYen;
    }

    public void setTmtthaitoukinYen(BizCurrency pTmtthaitoukinYen) {
        this.tmtthaitoukinYen = pTmtthaitoukinYen;
    }

    public BizCurrency getSonotahaitoukinYen() {
        return sonotahaitoukinYen;
    }

    public void setSonotahaitoukinYen(BizCurrency pSonotahaitoukinYen) {
        this.sonotahaitoukinYen = pSonotahaitoukinYen;
    }

    public BizCurrency getSonotaseisan() {
        return sonotaseisan;
    }

    public void setSonotaseisan(BizCurrency pSonotaseisan) {
        this.sonotaseisan = pSonotaseisan;
    }

    public C_Segcd getSegcdOne() {
        return segcdOne;
    }

    public void setSegcdOne(C_Segcd pSegcdOne) {
        this.segcdOne = pSegcdOne;
    }

    public C_Segcd getSegcdTwo() {
        return segcdTwo;
    }

    public void setSegcdTwo(C_Segcd pSegcdTwo) {
        this.segcdTwo = pSegcdTwo;
    }

    public BizCurrency getGstszeigk() {
        return gstszeigk;
    }

    public void setGstszeigk(BizCurrency pGstszeigk) {
        this.gstszeigk = pGstszeigk;
    }

    public BizCurrency getGaikaShrYenGsTsZeigk() {
        return gaikaShrYenGsTsZeigk;
    }

    public void setGaikaShrYenGsTsZeigk(BizCurrency pGaikaShrYenGsTsZeigk) {
        this.gaikaShrYenGsTsZeigk = pGaikaShrYenGsTsZeigk;
    }

    public BizCurrency getGaikaShrYenGsTsZeigkKokuz() {
        return gaikaShrYenGsTsZeigkKokuz;
    }

    public void setGaikaShrYenGsTsZeigkKokuz(BizCurrency pGaikaShrYenGsTsZeigkKokuz) {
        this.gaikaShrYenGsTsZeigkKokuz = pGaikaShrYenGsTsZeigkKokuz;
    }

    public BizCurrency getGaikaShrYenGsTsZeigkTihouz() {
        return gaikaShrYenGsTsZeigkTihouz;
    }

    public void setGaikaShrYenGsTsZeigkTihouz(BizCurrency pGaikaShrYenGsTsZeigkTihouz) {
        this.gaikaShrYenGsTsZeigkTihouz = pGaikaShrYenGsTsZeigkTihouz;
    }

    public C_UmuKbn getGaikaGsBunriTaisyouFlag() {
        return gaikaGsBunriTaisyouFlag;
    }

    public void setGaikaGsBunriTaisyouFlag(C_UmuKbn pGaikaGsBunriTaisyouFlag) {
        this.gaikaGsBunriTaisyouFlag = pGaikaGsBunriTaisyouFlag;
    }

    public BizCurrency getGaikaShrYenGsTsTaisyouSaeki() {
        return gaikaShrYenGsTsTaisyouSaeki;
    }

    public void setGaikaShrYenGsTsTaisyouSaeki(BizCurrency pGaikaShrYenGsTsTaisyouSaeki) {
        this.gaikaShrYenGsTsTaisyouSaeki = pGaikaShrYenGsTsTaisyouSaeki;
    }

    public BizCurrency getGaikaShrYenHtyKeihi() {
        return gaikaShrYenHtyKeihi;
    }

    public void setGaikaShrYenHtyKeihi(BizCurrency pGaikaShrYenHtyKeihi) {
        this.gaikaShrYenHtyKeihi = pGaikaShrYenHtyKeihi;
    }

    public C_RatesyutokukekkaKbn getZeimuRatesyutokukekkaKbn() {
        return zeimuRatesyutokukekkaKbn;
    }

    public void setZeimuRatesyutokukekkaKbn(C_RatesyutokukekkaKbn pZeimuRatesyutokukekkaKbn) {
        this.zeimuRatesyutokukekkaKbn = pZeimuRatesyutokukekkaKbn;
    }

    public BizDate getZeimuRatesyutokuYmd() {
        return zeimuRatesyutokuYmd;
    }

    public void setZeimuRatesyutokuYmd(BizDate pZeimuRatesyutokuYmd) {
        this.zeimuRatesyutokuYmd = pZeimuRatesyutokuYmd;
    }

    public BizNumber getZeimukwsrate() {
        return zeimukwsrate;
    }

    public void setZeimukwsrate(BizNumber pZeimukwsrate) {
        this.zeimukwsrate = pZeimukwsrate;
    }

    public BizCurrency getGensengkYenkaiyakuhr() {
        return gensengkYenkaiyakuhr;
    }

    public void setGensengkYenkaiyakuhr(BizCurrency pGensengkYenkaiyakuhr) {
        this.gensengkYenkaiyakuhr = pGensengkYenkaiyakuhr;
    }

    public BizCurrency getJpygstszeigk() {
        return jpygstszeigk;
    }

    public void setJpygstszeigk(BizCurrency pJpygstszeigk) {
        this.jpygstszeigk = pJpygstszeigk;
    }

    public BizCurrency getJpyShrjiYengstszeigkKokuz() {
        return jpyShrjiYengstszeigkKokuz;
    }

    public void setJpyShrjiYengstszeigkKokuz(BizCurrency pJpyShrjiYengstszeigkKokuz) {
        this.jpyShrjiYengstszeigkKokuz = pJpyShrjiYengstszeigkKokuz;
    }

    public BizCurrency getJpyShrjiYengstszeigkTihouz() {
        return jpyShrjiYengstszeigkTihouz;
    }

    public void setJpyShrjiYengstszeigkTihouz(BizCurrency pJpyShrjiYengstszeigkTihouz) {
        this.jpyShrjiYengstszeigkTihouz = pJpyShrjiYengstszeigkTihouz;
    }

    public C_UmuKbn getJpyGsBunriTaisyouFlag() {
        return jpyGsBunriTaisyouFlag;
    }

    public void setJpyGsBunriTaisyouFlag(C_UmuKbn pJpyGsBunriTaisyouFlag) {
        this.jpyGsBunriTaisyouFlag = pJpyGsBunriTaisyouFlag;
    }

    public BizCurrency getJpykaShrYenGsTsTaisyouSaeki() {
        return jpyKaShrYenGsTsTaisyouSaeki;
    }

    public void setJpykaShrYenGsTsTaisyouSaeki(BizCurrency pJpykaShrYenGsTsTaisyouSaeki) {
        this.jpyKaShrYenGsTsTaisyouSaeki = pJpykaShrYenGsTsTaisyouSaeki;
    }



    public BizCurrency getJpyShrjiYenhtykeihi() {
        return jpyShrjiYenhtykeihi;
    }

    public void setJpyShrjiYenhtykeihi(BizCurrency pJpyShrjiYenhtykeihi) {
        this.jpyShrjiYenhtykeihi = pJpyShrjiYenhtykeihi;
    }

    public C_UmuKbn getGsbunritaisyouFlg() {
        return gsbunritaisyouFlg;
    }

    public void setGsbunritaisyouFlg(C_UmuKbn pGsbunritaisyouFlg) {
        this.gsbunritaisyouFlg = pGsbunritaisyouFlg;
    }

    public BizCurrency getSynykngk() {
        return synykngk;
    }

    public void setSynykngk(BizCurrency pSynykngk) {
        this.synykngk = pSynykngk;
    }

    public BizCurrency getHtykeihi() {
        return htykeihi;
    }

    public void setHtykeihi(BizCurrency pHtykeihi) {
        this.htykeihi = pHtykeihi;
    }

    public Integer getKykhnkkaisuu() {
        return kykhnkkaisuu;
    }

    public void setKykhnkkaisuu(Integer pKykhnkkaisuu) {
        this.kykhnkkaisuu = pKykhnkkaisuu;
    }

    public BizCurrency getYenShrKykHtyKeihi() {
        return yenShrKykHtyKeihi;
    }

    public void setYenShrKykHtyKeihi(BizCurrency pYenShrKykHtyKeihi) {
        this.yenShrKykHtyKeihi = pYenShrKykHtyKeihi;
    }

    public BizCurrency getYengstszeigk() {
        return yengstszeigk;
    }

    public void setYengstszeigk(BizCurrency pYengstszeigk) {
        this.yengstszeigk = pYengstszeigk;
    }

    public BizCurrency getYengststaisyousaeki() {
        return yengststaisyousaeki;
    }

    public void setYengststaisyousaeki(BizCurrency pYengststaisyousaeki) {
        this.yengststaisyousaeki = pYengststaisyousaeki;
    }

    public BizDateYM getLastpjytoym() {
        return lastpjytoym;
    }

    public void setLastpjytoymi(BizDateYM pLastpjytoym) {
        this.lastpjytoym = pLastpjytoym;
    }

    public C_UmuKbn getZennoumijyuutouFlg() {
        return zennoumijyuutouFlg;
    }

    public void setZennoumijyuutouFlg(C_UmuKbn pZennoumijyuutouFlg) {
        this.zennoumijyuutouFlg = pZennoumijyuutouFlg;
    }

    public C_NaiteiKakuteiKbn getKhHaitouKanriNaiteiKakuteiKbn() {
        return khHaitouKanriNaiteiKakuteiKbn;
    }

    public void setKhHaitouKanriNaiteiKakuteiKbn(C_NaiteiKakuteiKbn pKhHaitouKanriNaiteiKakuteiKbn) {
        this.khHaitouKanriNaiteiKakuteiKbn = pKhHaitouKanriNaiteiKakuteiKbn;
    }

    public EditDshrTukiDKoumokuBean getEditDshrTukiDKoumokuBean() {
        return editDshrTukiDKoumokuBean;
    }

    public void setEditDshrTukiDKoumokuBean(EditDshrTukiDKoumokuBean pEditDshrTukiDKoumokuBean) {
        this.editDshrTukiDKoumokuBean = pEditDshrTukiDKoumokuBean;
    }

}
