package yuyu.common.hozen.khcommon;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import yuyu.common.suuri.srcommon.EditDshrTukiDKoumokuBean;
import yuyu.def.classification.C_HtsiryosyuKbn;
import yuyu.def.classification.C_InputShrhousiteiKbn;
import yuyu.def.classification.C_Kaiyakujiyuu;
import yuyu.def.classification.C_KouzasyuruiKbn;
import yuyu.def.classification.C_Kzdou;
import yuyu.def.classification.C_NaiteiKakuteiKbn;
import yuyu.def.classification.C_Segcd;
import yuyu.def.classification.C_ShrhousiteiKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_YokinKbn;
import yuyu.def.db.entity.IT_AnsyuKihon;

/**
 * 契約保全 契約保全共通 解約処理テーブル更新値編集Bean
 */
public class EditKaiyakuTblUpdateBean {

    private String syono;

    private BizDate syoruiukeymd;

    private BizDate kaiykymd;

    private C_UmuKbn yenshrtkumu;

    private C_InputShrhousiteiKbn inputshrhousiteikbn;

    private C_Kaiyakujiyuu kaiyakujiyuu;

    private BizCurrency kaiyakuhrgoukei;

    private BizCurrency kaiyakuhrgoukeiyen;

    private BizCurrency kaiyakuhr;

    private BizCurrency kaiyakuhryen;

    private BizNumber yenshrrate;

    private BizDate yenshrratetekiymd;

    private BizCurrency kiykhrsyousaiptumitatekin;

    private BizCurrency kiykhrsyousaisjkkktyouseigk;

    private BizCurrency kaiyakukjgk;

    private BizNumber sjkkktyouseiritu;

    private BizNumber kaiyakusjkkktyouseiriritu;

    private BizNumber kaiyakukoujyoritu;

    private BizCurrency azukarikinkykhnkkaiyakuhr;

    private BizCurrency shrtienrsk;

    private BizDate shrtienrskkisanymd;

    private Integer tienrsknissuu;

    private BizCurrency jpyshrtienrsk;

    private BizDate jpytienrisokukisanymd;

    private Integer jpytienrsknissuu;

    private BizCurrency gksonotashrgk;

    private BizCurrency jpysonotashrgk;

    private BizNumber gkshrrate;

    private BizDate gkshrratetekiymd;

    private BizCurrency jpymikeikap;

    private BizCurrency mikeikap;

    private BizDateYM mikeikapjyutouym;

    private int mikeikapjyutoukaisuuy;

    private int mikeikapjyutoukaisuum;

    private MiKeikaPBean[] miKeikaPBeanHrt;

    private BizCurrency jpyzennouseisankgk;

    private BizCurrency zennouseisankgk;

    private BizCurrency azukarikinkykhnkmikeikap;

    private BizCurrency jpykariukekin;

    private BizCurrency jpyhaitoukin;

    private BizCurrency jpytkbthaitoukin;

    private BizCurrency yendthnkhr;

    private BizCurrency gstszeigk;

    private BizCurrency jpygstszeigk;

    private BizCurrency yengstszeigknationaltax;

    private BizCurrency yengstszeigklocaltax;

    private C_UmuKbn gsbunritaisyouflg;

    private BizCurrency yengststaisyousaeki;

    private BizCurrency teiritutmttkngk;

    private BizCurrency sisuurendoutmttkngk;

    private BizCurrency shrgkkei;

    private BizCurrency jpyshrgkgoukei;

    private BizNumber zeimukwsrate;

    private BizDate zeimukwsratekjnymd;

    private BizCurrency synykngk;

    private BizCurrency htykeihi;

    private Integer kykhnkkaisuu;

    private BizCurrency yenshrkykhtykeihi;

    private BizDate shrymd;

    private C_Tuukasyu shrtuukasyu;

    private C_ShrhousiteiKbn shrhousiteikbn;

    private String bankcd;

    private String sitencd;

    private C_YokinKbn yokinkbn;

    private String kouzano;

    private String kzmeiginmkn;

    private C_KouzasyuruiKbn kzsyuruikbn;

    private C_Kzdou kzdoukbn;

    private String kyksyaszknmkn;

    private String kyksyaszknmkj;

    private String kyksyaszkyno;

    private String kyksyaszkadr1kj;

    private String kyksyaszkadr2kj;

    private String kyksyaszkadr3kj;

    private String saikennmkj;

    private String saikennyno;

    private String saikenadr1kj;

    private String saikenadr2kj;

    private String saikenadr3kj;

    private String kykmnmeigibangou;

    private String uktmnmeigibangou;

    private C_HtsiryosyuKbn shrtysysyuruikbn;

    private C_NaiteiKakuteiKbn naiteikakuteikbn;

    private C_Segcd seg1cd;

    private C_Segcd seg2cd;

    private IT_AnsyuKihon ansyuKihon;

    private BizDateYM lastPJyuutouYm;

    private EditDshrTukiDKoumokuBean editDshrTukiDKoumokuBean;

    public EditKaiyakuTblUpdateBean() {

        zeimukwsrate = BizNumber.valueOf(0);
        zeimukwsratekjnymd = null;
        kyksyaszknmkn = "";
        kyksyaszknmkj = "";
        kyksyaszkyno = "";
        kyksyaszkadr1kj = "";
        kyksyaszkadr2kj = "";
        kyksyaszkadr3kj = "";
        saikennmkj = "";
        saikennyno = "";
        saikenadr1kj = "";
        saikenadr2kj = "";
        saikenadr3kj = "";
        kykmnmeigibangou = "";
        uktmnmeigibangou = "";
    }

    public String getSyono() {
        return syono;
    }

    public void setSyono(String pSyono) {
        syono = pSyono;
    }

    public BizDate getSyoruiukeymd() {
        return syoruiukeymd;
    }

    public void setSyoruiukeymd(BizDate pSyoruiukeymd) {
        syoruiukeymd = pSyoruiukeymd;
    }

    public BizDate getKaiykymd() {
        return kaiykymd;
    }

    public void setKaiykymd(BizDate pKaiykymd) {
        kaiykymd = pKaiykymd;
    }

    public C_UmuKbn getYenshrtkumu() {
        return yenshrtkumu;
    }

    public void setYenshrtkumu(C_UmuKbn pYenshrtkumu) {
        yenshrtkumu = pYenshrtkumu;
    }

    public C_InputShrhousiteiKbn getInputshrhousiteikbn() {
        return inputshrhousiteikbn;
    }

    public void setInputshrhousiteikbn(C_InputShrhousiteiKbn pInputshrhousiteikbn) {
        inputshrhousiteikbn = pInputshrhousiteikbn;
    }

    public C_Kaiyakujiyuu getKaiyakujiyuu() {
        return kaiyakujiyuu;
    }

    public void setKaiyakujiyuu(C_Kaiyakujiyuu pKaiyakujiyuu) {
        kaiyakujiyuu = pKaiyakujiyuu;
    }

    public BizCurrency getKaiyakuhrgoukei() {
        return kaiyakuhrgoukei;
    }

    public void setKaiyakuhrgoukei(BizCurrency pKaiyakuhrgoukei) {
        kaiyakuhrgoukei = pKaiyakuhrgoukei;
    }

    public BizCurrency getKaiyakuhrgoukeiyen() {
        return kaiyakuhrgoukeiyen;
    }

    public void setKaiyakuhrgoukeiyen(BizCurrency pKaiyakuhrgoukeiyen) {
        kaiyakuhrgoukeiyen = pKaiyakuhrgoukeiyen;
    }

    public BizCurrency getKaiyakuhr() {
        return kaiyakuhr;
    }

    public void setKaiyakuhr(BizCurrency pKaiyakuhr) {
        kaiyakuhr = pKaiyakuhr;
    }

    public BizCurrency getKaiyakuhryen() {
        return kaiyakuhryen;
    }

    public void setKaiyakuhryen(BizCurrency pKaiyakuhryen) {
        kaiyakuhryen = pKaiyakuhryen;
    }

    public BizNumber getYenshrrate() {
        return yenshrrate;
    }

    public void setYenshrrate(BizNumber pYenshrrate) {
        yenshrrate = pYenshrrate;
    }

    public BizDate getYenshrratetekiymd() {
        return yenshrratetekiymd;
    }

    public void setYenshrratetekiymd(BizDate pYenshrratetekiymd) {
        yenshrratetekiymd = pYenshrratetekiymd;
    }

    public BizCurrency getKiykhrsyousaiptumitatekin() {
        return kiykhrsyousaiptumitatekin;
    }

    public void setKiykhrsyousaiptumitatekin(BizCurrency pKiykhrsyousaiptumitatekin) {
        kiykhrsyousaiptumitatekin = pKiykhrsyousaiptumitatekin;
    }

    public BizCurrency getKiykhrsyousaisjkkktyouseigk() {
        return kiykhrsyousaisjkkktyouseigk;
    }

    public void setKiykhrsyousaisjkkktyouseigk(BizCurrency pKiykhrsyousaisjkkktyouseigk) {
        kiykhrsyousaisjkkktyouseigk = pKiykhrsyousaisjkkktyouseigk;
    }

    public BizCurrency getKaiyakukjgk() {
        return kaiyakukjgk;
    }

    public void setKaiyakukjgk(BizCurrency pKaiyakukjgk) {
        kaiyakukjgk = pKaiyakukjgk;
    }

    public BizNumber getSjkkktyouseiritu() {
        return sjkkktyouseiritu;
    }

    public void setSjkkktyouseiritu(BizNumber pSjkkktyouseiritu) {
        sjkkktyouseiritu = pSjkkktyouseiritu;
    }

    public BizNumber getKaiyakusjkkktyouseiriritu() {
        return kaiyakusjkkktyouseiriritu;
    }

    public void setKaiyakusjkkktyouseiriritu(BizNumber pKaiyakusjkkktyouseiriritu) {
        kaiyakusjkkktyouseiriritu = pKaiyakusjkkktyouseiriritu;
    }

    public BizNumber getKaiyakukoujyoritu() {
        return kaiyakukoujyoritu;
    }

    public void setKaiyakukoujyoritu(BizNumber pKaiyakukoujyoritu) {
        kaiyakukoujyoritu = pKaiyakukoujyoritu;
    }

    public BizCurrency getAzukarikinkykhnkkaiyakuhr() {
        return azukarikinkykhnkkaiyakuhr;
    }

    public void setAzukarikinkykhnkkaiyakuhr(BizCurrency pAzukarikinkykhnkkaiyakuhr) {
        azukarikinkykhnkkaiyakuhr = pAzukarikinkykhnkkaiyakuhr;
    }

    public BizCurrency getShrtienrsk() {
        return shrtienrsk;
    }

    public void setShrtienrsk(BizCurrency pShrtienrsk) {
        shrtienrsk = pShrtienrsk;
    }

    public BizDate getShrtienrskkisanymd() {
        return shrtienrskkisanymd;
    }

    public void setShrtienrskkisanymd(BizDate pShrtienrskkisanymd) {
        shrtienrskkisanymd = pShrtienrskkisanymd;
    }

    public Integer getTienrsknissuu() {
        return tienrsknissuu;
    }

    public void setTienrsknissuu(Integer pTienrsknissuu) {
        tienrsknissuu = pTienrsknissuu;
    }

    public BizCurrency getJpyshrtienrsk() {
        return jpyshrtienrsk;
    }

    public void setJpyshrtienrsk(BizCurrency pJpyshrtienrsk) {
        jpyshrtienrsk = pJpyshrtienrsk;
    }

    public BizDate getJpytienrisokukisanymd() {
        return jpytienrisokukisanymd;
    }

    public void setJpytienrisokukisanymd(BizDate pJpytienrisokukisanymd) {
        jpytienrisokukisanymd = pJpytienrisokukisanymd;
    }

    public Integer getJpytienrsknissuu() {
        return jpytienrsknissuu;
    }

    public void setJpytienrsknissuu(Integer pJpytienrsknissuu) {
        jpytienrsknissuu = pJpytienrsknissuu;
    }

    public BizCurrency getGksonotashrgk() {
        return gksonotashrgk;
    }

    public void setGksonotashrgk(BizCurrency pGksonotashrgk) {
        gksonotashrgk = pGksonotashrgk;
    }

    public BizCurrency getJpysonotashrgk() {
        return jpysonotashrgk;
    }

    public void setJpysonotashrgk(BizCurrency pJpysonotashrgk) {
        jpysonotashrgk = pJpysonotashrgk;
    }

    public BizNumber getGkshrrate() {
        return gkshrrate;
    }

    public void setGkshrrate(BizNumber pGkshrrate) {
        gkshrrate = pGkshrrate;
    }

    public BizDate getGkshrratetekiymd() {
        return gkshrratetekiymd;
    }

    public void setGkshrratetekiymd(BizDate pGkshrratetekiymd) {
        gkshrratetekiymd = pGkshrratetekiymd;
    }

    public BizCurrency getJpymikeikap() {
        return jpymikeikap;
    }

    public void setJpymikeikap(BizCurrency pJpymikeikap) {
        jpymikeikap = pJpymikeikap;
    }

    public BizCurrency getMikeikap() {
        return mikeikap;
    }

    public void setMikeikap(BizCurrency pMikeikap) {
        mikeikap = pMikeikap;
    }

    public BizDateYM getMikeikapjyutouym() {
        return mikeikapjyutouym;
    }

    public void setMikeikapjyutouym(BizDateYM pMikeikapjyutouym) {
        mikeikapjyutouym = pMikeikapjyutouym;
    }

    public int getMikeikapjyutoukaisuuy() {
        return mikeikapjyutoukaisuuy;
    }

    public void setMikeikapjyutoukaisuuy(int pMikeikapjyutoukaisuuy) {
        mikeikapjyutoukaisuuy = pMikeikapjyutoukaisuuy;
    }

    public int getMikeikapjyutoukaisuum() {
        return mikeikapjyutoukaisuum;
    }

    public void setMikeikapjyutoukaisuum(int pMikeikapjyutoukaisuum) {
        mikeikapjyutoukaisuum = pMikeikapjyutoukaisuum;
    }

    public MiKeikaPBean[] getMiKeikaPBeanHrt() {
        return miKeikaPBeanHrt;
    }

    public void setMiKeikaPBeanHrt(MiKeikaPBean[] pMiKeikaPBeanHrt) {
        miKeikaPBeanHrt = pMiKeikaPBeanHrt;
    }

    public BizCurrency getJpyzennouseisankgk() {
        return jpyzennouseisankgk;
    }

    public void setJpyzennouseisankgk(BizCurrency pJpyzennouseisankgk) {
        jpyzennouseisankgk = pJpyzennouseisankgk;
    }

    public BizCurrency getZennouseisankgk() {
        return zennouseisankgk;
    }

    public void setZennouseisankgk(BizCurrency pZennouseisankgk) {
        zennouseisankgk = pZennouseisankgk;
    }

    public BizCurrency getAzukarikinkykhnkmikeikap() {
        return azukarikinkykhnkmikeikap;
    }

    public void setAzukarikinkykhnkmikeikap(BizCurrency pAzukarikinkykhnkmikeikap) {
        azukarikinkykhnkmikeikap = pAzukarikinkykhnkmikeikap;
    }

    public BizCurrency getJpykariukekin() {
        return jpykariukekin;
    }

    public void setJpykariukekin(BizCurrency pJpykariukekin) {
        jpykariukekin = pJpykariukekin;
    }

    public BizCurrency getJpyhaitoukin() {
        return jpyhaitoukin;
    }

    public void setJpyhaitoukin(BizCurrency pJpyhaitoukin) {
        jpyhaitoukin = pJpyhaitoukin;
    }

    public BizCurrency getJpytkbthaitoukin() {
        return jpytkbthaitoukin;
    }

    public void setJpytkbthaitoukin(BizCurrency pJpytkbthaitoukin) {
        jpytkbthaitoukin = pJpytkbthaitoukin;
    }

    public BizCurrency getYendthnkhr() {
        return yendthnkhr;
    }

    public void setYendthnkhr(BizCurrency pYendthnkhr) {
        yendthnkhr = pYendthnkhr;
    }

    public BizCurrency getGstszeigk() {
        return gstszeigk;
    }

    public void setGstszeigk(BizCurrency pGstszeigk) {
        gstszeigk = pGstszeigk;
    }

    public BizCurrency getJpygstszeigk() {
        return jpygstszeigk;
    }

    public void setJpygstszeigk(BizCurrency pJpygstszeigk) {
        jpygstszeigk = pJpygstszeigk;
    }

    public BizCurrency getYengstszeigknationaltax() {
        return yengstszeigknationaltax;
    }

    public void setYengstszeigknationaltax(BizCurrency pYengstszeigknationaltax) {
        yengstszeigknationaltax = pYengstszeigknationaltax;
    }

    public BizCurrency getYengstszeigklocaltax() {
        return yengstszeigklocaltax;
    }

    public void setYengstszeigklocaltax(BizCurrency pYengstszeigklocaltax) {
        yengstszeigklocaltax = pYengstszeigklocaltax;
    }

    public C_UmuKbn getGsbunritaisyouflg() {
        return gsbunritaisyouflg;
    }

    public void setGsbunritaisyouflg(C_UmuKbn pGsbunritaisyouflg) {
        gsbunritaisyouflg = pGsbunritaisyouflg;
    }

    public BizCurrency getYengststaisyousaeki() {
        return yengststaisyousaeki;
    }

    public void setYengststaisyousaeki(BizCurrency pYengststaisyousaeki) {
        yengststaisyousaeki = pYengststaisyousaeki;
    }

    public BizCurrency getTeiritutmttkngk() {
        return teiritutmttkngk;
    }

    public void setTeiritutmttkngk(BizCurrency pTeiritutmttkngk) {
        teiritutmttkngk = pTeiritutmttkngk;
    }

    public BizCurrency getSisuurendoutmttkngk() {
        return sisuurendoutmttkngk;
    }

    public void setSisuurendoutmttkngk(BizCurrency pSisuurendoutmttkngk) {
        sisuurendoutmttkngk = pSisuurendoutmttkngk;
    }

    public BizCurrency getShrgkkei() {
        return shrgkkei;
    }

    public void setShrgkkei(BizCurrency pShrgkkei) {
        shrgkkei = pShrgkkei;
    }

    public BizCurrency getJpyshrgkgoukei() {
        return jpyshrgkgoukei;
    }

    public void setJpyshrgkgoukei(BizCurrency pJpyshrgkgoukei) {
        jpyshrgkgoukei = pJpyshrgkgoukei;
    }

    public BizNumber getZeimukwsrate() {
        return zeimukwsrate;
    }

    public void setZeimukwsrate(BizNumber pZeimukwsrate) {
        zeimukwsrate = pZeimukwsrate;
    }

    public BizDate getZeimukwsratekjnymd() {
        return zeimukwsratekjnymd;
    }

    public void setZeimukwsratekjnymd(BizDate pZeimukwsratekjnymd) {
        zeimukwsratekjnymd = pZeimukwsratekjnymd;
    }

    public BizCurrency getSynykngk() {
        return synykngk;
    }

    public void setSynykngk(BizCurrency pSynykngk) {
        synykngk = pSynykngk;
    }

    public BizCurrency getHtykeihi() {
        return htykeihi;
    }

    public void setHtykeihi(BizCurrency pHtykeihi) {
        htykeihi = pHtykeihi;
    }

    public Integer getKykhnkkaisuu() {
        return kykhnkkaisuu;
    }

    public void setKykhnkkaisuu(Integer pKykhnkkaisuu) {
        kykhnkkaisuu = pKykhnkkaisuu;
    }

    public BizCurrency getYenshrkykhtykeihi() {
        return yenshrkykhtykeihi;
    }

    public void setYenshrkykhtykeihi(BizCurrency pYenshrkykhtykeihi) {
        yenshrkykhtykeihi = pYenshrkykhtykeihi;
    }

    public BizDate getShrymd() {
        return shrymd;
    }

    public void setShrymd(BizDate pShrymd) {
        shrymd = pShrymd;
    }

    public C_Tuukasyu getShrtuukasyu() {
        return shrtuukasyu;
    }

    public void setShrtuukasyu(C_Tuukasyu pShrtuukasyu) {
        shrtuukasyu = pShrtuukasyu;
    }

    public C_ShrhousiteiKbn getShrhousiteikbn() {
        return shrhousiteikbn;
    }

    public void setShrhousiteikbn(C_ShrhousiteiKbn pShrhousiteikbn) {
        shrhousiteikbn = pShrhousiteikbn;
    }

    public String getBankcd() {
        return bankcd;
    }

    public void setBankcd(String pBankcd) {
        bankcd = pBankcd;
    }

    public String getSitencd() {
        return sitencd;
    }

    public void setSitencd(String pSitencd) {
        sitencd = pSitencd;
    }

    public C_YokinKbn getYokinkbn() {
        return yokinkbn;
    }

    public void setYokinkbn(C_YokinKbn pYokinkbn) {
        yokinkbn = pYokinkbn;
    }

    public String getKouzano() {
        return kouzano;
    }

    public void setKouzano(String pKouzano) {
        kouzano = pKouzano;
    }

    public String getKzmeiginmkn() {
        return kzmeiginmkn;
    }

    public void setKzmeiginmkn(String pKzmeiginmkn) {
        kzmeiginmkn = pKzmeiginmkn;
    }

    public C_KouzasyuruiKbn getKzsyuruikbn() {
        return kzsyuruikbn;
    }

    public void setKzsyuruikbn(C_KouzasyuruiKbn pKzsyuruikbn) {
        kzsyuruikbn = pKzsyuruikbn;
    }

    public C_Kzdou getKzdoukbn() {
        return kzdoukbn;
    }

    public void setKzdoukbn(C_Kzdou pKzdoukbn) {
        kzdoukbn = pKzdoukbn;
    }

    public String getKyksyaszknmkn() {
        return kyksyaszknmkn;
    }

    public void setKyksyaszknmkn(String pKyksyaszknmkn) {
        kyksyaszknmkn = pKyksyaszknmkn;
    }

    public String getKyksyaszknmkj() {
        return kyksyaszknmkj;
    }

    public void setKyksyaszknmkj(String pKyksyaszknmkj) {
        kyksyaszknmkj = pKyksyaszknmkj;
    }

    public String getKyksyaszkyno() {
        return kyksyaszkyno;
    }

    public void setKyksyaszkyno(String pKyksyaszkyno) {
        kyksyaszkyno = pKyksyaszkyno;
    }

    public String getKyksyaszkadr1kj() {
        return kyksyaszkadr1kj;
    }

    public void setKyksyaszkadr1kj(String pKyksyaszkadr1kj) {
        kyksyaszkadr1kj = pKyksyaszkadr1kj;
    }

    public String getKyksyaszkadr2kj() {
        return kyksyaszkadr2kj;
    }

    public void setKyksyaszkadr2kj(String pKyksyaszkadr2kj) {
        kyksyaszkadr2kj = pKyksyaszkadr2kj;
    }

    public String getKyksyaszkadr3kj() {
        return kyksyaszkadr3kj;
    }

    public void setKyksyaszkadr3kj(String pKyksyaszkadr3kj) {
        kyksyaszkadr3kj = pKyksyaszkadr3kj;
    }

    public String getSaikennmkj() {
        return saikennmkj;
    }

    public void setSaikennmkj(String pSaikennmkj) {
        saikennmkj = pSaikennmkj;
    }

    public String getSaikennyno() {
        return saikennyno;
    }

    public void setSaikennyno(String pSaikennyno) {
        saikennyno = pSaikennyno;
    }

    public String getSaikenadr1kj() {
        return saikenadr1kj;
    }

    public void setSaikenadr1kj(String pSaikenadr1kj) {
        saikenadr1kj = pSaikenadr1kj;
    }

    public String getSaikenadr2kj() {
        return saikenadr2kj;
    }

    public void setSaikenadr2kj(String pSaikenadr2kj) {
        saikenadr2kj = pSaikenadr2kj;
    }

    public String getSaikenadr3kj() {
        return saikenadr3kj;
    }

    public void setSaikenadr3kj(String pSaikenadr3kj) {
        saikenadr3kj = pSaikenadr3kj;
    }

    public String getKykmnmeigibangou() {
        return kykmnmeigibangou;
    }

    public void setKykmnmeigibangou(String pKykmnmeigibangou) {
        kykmnmeigibangou = pKykmnmeigibangou;
    }

    public String getUktmnmeigibangou() {
        return uktmnmeigibangou;
    }

    public void setUktmnmeigibangou(String pUktmnmeigibangou) {
        uktmnmeigibangou = pUktmnmeigibangou;
    }

    public C_HtsiryosyuKbn getShrtysysyuruikbn() {
        return shrtysysyuruikbn;
    }

    public void setShrtysysyuruikbn(C_HtsiryosyuKbn pShrtysysyuruikbn) {
        shrtysysyuruikbn = pShrtysysyuruikbn;
    }

    public C_NaiteiKakuteiKbn getNaiteikakuteikbn() {
        return naiteikakuteikbn;
    }

    public void setNaiteikakuteikbn(C_NaiteiKakuteiKbn pNaiteikakuteikbn) {
        naiteikakuteikbn = pNaiteikakuteikbn;
    }

    public C_Segcd getSeg1cd() {
        return seg1cd;
    }

    public void setSeg1cd(C_Segcd pSeg1cd) {
        seg1cd = pSeg1cd;
    }

    public C_Segcd getSeg2cd() {
        return seg2cd;
    }

    public void setSeg2cd(C_Segcd pSeg2cd) {
        seg2cd = pSeg2cd;
    }

    public IT_AnsyuKihon getAnsyuKihon() {
        return ansyuKihon;
    }

    public void setAnsyuKihon(IT_AnsyuKihon pAnsyuKihon) {
        ansyuKihon = pAnsyuKihon;
    }

    public BizDateYM getLastPJyuutouYm() {
        return lastPJyuutouYm;
    }

    public void setLastPJyuutouYm(BizDateYM pLastPJyuutouYm) {
        this.lastPJyuutouYm = pLastPJyuutouYm;
    }

    public EditDshrTukiDKoumokuBean getEditDshrTukiDKoumokuBean() {
        return editDshrTukiDKoumokuBean;
    }

    public void setEditDshrTukiDKoumokuBean(EditDshrTukiDKoumokuBean pEditDshrTukiDKoumokuBean) {
        this.editDshrTukiDKoumokuBean = pEditDshrTukiDKoumokuBean;
    }

}
