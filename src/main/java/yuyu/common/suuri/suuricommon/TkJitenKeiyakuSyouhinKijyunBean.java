package yuyu.common.suuri.suuricommon;

import java.io.Serializable;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import yuyu.def.classification.C_6daiLdKbn;
import yuyu.def.classification.C_Hhknsei;
import yuyu.def.classification.C_HknkknsmnKbn;
import yuyu.def.classification.C_HrkkknsmnKbn;
import yuyu.def.classification.C_KataKbn;
import yuyu.def.classification.C_KhnkyhkgbairituKbn;
import yuyu.def.classification.C_KyhgndkataKbn;
import yuyu.def.classification.C_Kykjyoutai;
import yuyu.def.classification.C_Nenkinsyu;
import yuyu.def.classification.C_PmnjtkKbn;
import yuyu.def.classification.C_Sisuukbn;
import yuyu.def.classification.C_SyoriKbn;
import yuyu.def.classification.C_Syoumetujiyuu;
import yuyu.def.classification.C_SyukyhkinkataKbn;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.classification.C_TmttknhaibunjyoutaiKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_YuukousyoumetuKbn;

/**
 * 数理統計 数理共通 特定時点契約商品（基準）レコードBeanクラス
 */
public class TkJitenKeiyakuSyouhinKijyunBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private String syono;

    private C_SyutkKbn syutkKbn;

    private String syouhncd;

    private Integer syouhnsdno;

    private Integer kyksyouhnrenno;

    private String henkousikibetukey;

    private C_YuukousyoumetuKbn yuukousyoumetuKbn;

    private C_Kykjyoutai kykjyoutai;

    private C_Syoumetujiyuu syoumetujiyuu;

    private BizDate syoumetuymd;

    private BizDate kouryokuhasseiymd;

    private BizDate kykymd;

    private C_UmuKbn kykymdsiteiumuKbn;

    private BizDate sknnkaisiymd;

    private BizDate gansknnkaisiymd;

    private BizDate hksknnkaisiymd;

    private BizDate hkgansknnkaisiymd;

    private C_HknkknsmnKbn hknkknsmnKbn;

    private Integer hknkkn;

    private C_HrkkknsmnKbn hrkkknsmnKbn;

    private Integer hrkkkn;

    private Integer kyknen;

    private Integer hhknnen;

    private BizDate hhknseiymd;

    private C_Hhknsei hhknsei;

    private BizDate haraimanymd;

    private BizDate hknkknmanryouymd;

    private C_KataKbn kataKbn;

    private C_KyhgndkataKbn kyhgndkataKbn;

    private C_SyukyhkinkataKbn syukyhkinkataKbn;

    private C_KhnkyhkgbairituKbn khnkyhkgbairituKbn;

    private C_6daiLdKbn rokudaildkbn;

    private C_PmnjtkKbn pmnjtkKbn;

    private BizCurrency kihons;

    private BizCurrency hokenryou;

    private C_Tuukasyu kyktuukasyu;

    private String ryouritusdno;

    private BizNumber yoteiriritu;

    private BizNumber yoteirrthendohosyurrt;

    private Integer ytirrthndmnskaisuu;

    private BizNumber kyksjkkktyouseiriritu;

    private C_Nenkinsyu nksyukbn;

    private Integer nenkinkkn;

    private Integer nkgnshosyouritu;

    private BizCurrency nkgnshosyougk;

    private String gyoumuKousinKinou;

    private BizCurrency gengakugoyenitijibrpstgk;

    private BizDate yendthnkymd;

    private BizNumber setteibairitu;

    private BizNumber kykjisisuurendourate;

    private BizNumber tmttknzoukaritujygn;

    private BizNumber  tumitateriritu ;

    private C_TmttknhaibunjyoutaiKbn tmttknhaibunjyoutai;

    private C_Sisuukbn sisuukbn;

    private C_UmuKbn gsbunrikzkakuninumu;

    private C_UmuKbn gsbunritaisyou;

    private BizCurrency pharaikomisougaku;

    private BizDate tmttknitenymd;

    private BizNumber loadinghnkgtumitateriritu;

    private BizNumber rendouritu;

    private BizNumber teikishrritu;

    private Integer dai1hknkkn;

    private BizDate syoriYmd;

    private C_SyoriKbn syorikbn;


    public TkJitenKeiyakuSyouhinKijyunBean() {
        super();

        syono = "";
        syutkKbn = C_SyutkKbn.NONE;
        syouhncd = "";
        syouhnsdno = 0;
        kyksyouhnrenno = 0;
        henkousikibetukey = "";
        yuukousyoumetuKbn = C_YuukousyoumetuKbn.BLNK;
        kykjyoutai = C_Kykjyoutai.BLNK;
        syoumetujiyuu = C_Syoumetujiyuu.BLNK;
        syoumetuymd = null;
        kouryokuhasseiymd = null;
        kykymd = null;
        kykymdsiteiumuKbn = C_UmuKbn.NONE;
        sknnkaisiymd = null;
        gansknnkaisiymd = null;
        hksknnkaisiymd = null;
        hkgansknnkaisiymd = null;
        hknkknsmnKbn = C_HknkknsmnKbn.BLNK;
        hknkkn = 0;
        hrkkknsmnKbn = C_HrkkknsmnKbn.BLNK;
        hrkkkn = 0;
        kyknen = 0;
        hhknnen = 0;
        hhknseiymd = null;
        hhknsei = C_Hhknsei.BLNK;
        haraimanymd = null;
        hknkknmanryouymd = null;
        kataKbn = C_KataKbn.BLNK;
        kyhgndkataKbn = C_KyhgndkataKbn.BLNK;
        syukyhkinkataKbn = C_SyukyhkinkataKbn.BLNK;
        khnkyhkgbairituKbn = C_KhnkyhkgbairituKbn.BLNK;
        rokudaildkbn = C_6daiLdKbn.BLNK;
        pmnjtkKbn = C_PmnjtkKbn.NONE;
        kihons = BizCurrency.valueOf(0);
        hokenryou = BizCurrency.valueOf(0);
        kyktuukasyu = C_Tuukasyu.BLNK;
        ryouritusdno = "";
        yoteiriritu = BizNumber.valueOf(0);
        yoteirrthendohosyurrt = BizNumber.valueOf(0);
        ytirrthndmnskaisuu = 0;
        kyksjkkktyouseiriritu = BizNumber.valueOf(0);
        nksyukbn = C_Nenkinsyu.BLNK;
        nenkinkkn = 0;
        nkgnshosyouritu = 0;
        nkgnshosyougk = BizCurrency.valueOf(0);
        gyoumuKousinKinou = "";
        gengakugoyenitijibrpstgk = BizCurrency.valueOf(0);
        yendthnkymd = BizDate.valueOf(0);
        setteibairitu = BizNumber.valueOf(0);
        kykjisisuurendourate = BizNumber.valueOf(0);
        tmttknzoukaritujygn = BizNumber.valueOf(0);
        tumitateriritu = BizNumber.valueOf(0);
        tmttknhaibunjyoutai = C_TmttknhaibunjyoutaiKbn.BLNK;
        sisuukbn = C_Sisuukbn.BLNK;
        gsbunrikzkakuninumu = C_UmuKbn.NONE;
        gsbunritaisyou = C_UmuKbn.NONE;
        pharaikomisougaku = BizCurrency.valueOf(0);
        tmttknitenymd = null;
        loadinghnkgtumitateriritu = BizNumber.valueOf(0);
        rendouritu = BizNumber.valueOf(0);
        teikishrritu = BizNumber.valueOf(0);
        dai1hknkkn = 0;
        syoriYmd = null;
        syorikbn = C_SyoriKbn.BLNK;
    }

    public String getSyono() {
        return syono;
    }

    public void setSyono(String pSyono) {
        this.syono = pSyono;
    }

    public C_SyutkKbn getSyutkKbn() {
        return syutkKbn;
    }

    public void setSyutkKbn(C_SyutkKbn pSyutkKbn) {
        this.syutkKbn = pSyutkKbn;
    }

    public String getSyouhncd() {
        return syouhncd;
    }

    public void setSyouhncd(String pSyouhncd) {
        this.syouhncd = pSyouhncd;
    }

    public Integer getSyouhnsdno() {
        return syouhnsdno;
    }

    public void setSyouhnsdno(Integer pSyouhnsdno) {
        this.syouhnsdno = pSyouhnsdno;
    }

    public Integer getKyksyouhnrenno() {
        return kyksyouhnrenno;
    }

    public void setKyksyouhnrenno(Integer pKyksyouhnrenno) {
        this.kyksyouhnrenno = pKyksyouhnrenno;
    }

    public String getHenkousikibetukey() {
        return henkousikibetukey;
    }

    public void setHenkousikibetukey(String pHenkousikibetukey) {
        this.henkousikibetukey = pHenkousikibetukey;
    }

    public C_YuukousyoumetuKbn getYuukousyoumetuKbn() {
        return yuukousyoumetuKbn;
    }

    public void setYuukousyoumetuKbn(C_YuukousyoumetuKbn pYuukousyoumetuKbn) {
        this.yuukousyoumetuKbn = pYuukousyoumetuKbn;
    }

    public C_Kykjyoutai getKykjyoutai() {
        return kykjyoutai;
    }

    public void setKykjyoutai(C_Kykjyoutai pKykjyoutai) {
        this.kykjyoutai = pKykjyoutai;
    }

    public C_Syoumetujiyuu getSyoumetujiyuu() {
        return syoumetujiyuu;
    }

    public void setSyoumetujiyuu(C_Syoumetujiyuu pSyoumetujiyuu) {
        this.syoumetujiyuu = pSyoumetujiyuu;
    }

    public BizDate getSyoumetuymd() {
        return syoumetuymd;
    }

    public void setSyoumetuymd(BizDate pSyoumetuymd) {
        this.syoumetuymd = pSyoumetuymd;
    }

    public BizDate getKouryokuhasseiymd() {
        return kouryokuhasseiymd;
    }

    public void setKouryokuhasseiymd(BizDate pKouryokuhasseiymd) {
        this.kouryokuhasseiymd = pKouryokuhasseiymd;
    }

    public BizDate getKykymd() {
        return kykymd;
    }

    public void setKykymd(BizDate pKykymd) {
        this.kykymd = pKykymd;
    }

    public C_UmuKbn getKykymdsiteiumuKbn() {
        return kykymdsiteiumuKbn;
    }

    public void setKykymdsiteiumuKbn(C_UmuKbn pKykymdsiteiumuKbn) {
        this.kykymdsiteiumuKbn = pKykymdsiteiumuKbn;
    }

    public BizDate getSknnkaisiymd() {
        return sknnkaisiymd;
    }

    public void setSknnkaisiymd(BizDate pSknnkaisiymd) {
        this.sknnkaisiymd = pSknnkaisiymd;
    }

    public BizDate getGansknnkaisiymd() {
        return gansknnkaisiymd;
    }

    public void setGansknnkaisiymd(BizDate pGansknnkaisiymd) {
        this.gansknnkaisiymd = pGansknnkaisiymd;
    }

    public BizDate getHksknnkaisiymd() {
        return hksknnkaisiymd;
    }

    public void setHksknnkaisiymd(BizDate pHksknnkaisiymd) {
        this.hksknnkaisiymd = pHksknnkaisiymd;
    }

    public BizDate getHkgansknnkaisiymd() {
        return hkgansknnkaisiymd;
    }

    public void setHkgansknnkaisiymd(BizDate pHkgansknnkaisiymd) {
        this.hkgansknnkaisiymd = pHkgansknnkaisiymd;
    }

    public C_HknkknsmnKbn getHknkknsmnKbn() {
        return hknkknsmnKbn;
    }

    public void setHknkknsmnKbn(C_HknkknsmnKbn pHknkknsmnKbn) {
        this.hknkknsmnKbn = pHknkknsmnKbn;
    }

    public Integer getHknkkn() {
        return hknkkn;
    }

    public void setHknkkn(Integer pHknkkn) {
        this.hknkkn = pHknkkn;
    }

    public C_HrkkknsmnKbn getHrkkknsmnKbn() {
        return hrkkknsmnKbn;
    }

    public void setHrkkknsmnKbn(C_HrkkknsmnKbn pHrkkknsmnKbn) {
        this.hrkkknsmnKbn = pHrkkknsmnKbn;
    }

    public Integer getHrkkkn() {
        return hrkkkn;
    }

    public void setHrkkkn(Integer pHrkkkn) {
        this.hrkkkn = pHrkkkn;
    }

    public Integer getKyknen() {
        return kyknen;
    }

    public void setKyknen(Integer pKyknen) {
        this.kyknen = pKyknen;
    }

    public Integer getHhknnen() {
        return hhknnen;
    }

    public void setHhknnen(Integer pHhknnen) {
        this.hhknnen = pHhknnen;
    }

    public BizDate getHhknseiymd() {
        return hhknseiymd;
    }

    public void setHhknseiymd(BizDate pHhknseiymd) {
        this.hhknseiymd = pHhknseiymd;
    }

    public C_Hhknsei getHhknsei() {
        return hhknsei;
    }

    public void setHhknsei(C_Hhknsei pHhknsei) {
        this.hhknsei = pHhknsei;
    }

    public BizDate getHaraimanymd() {
        return haraimanymd;
    }

    public void setHaraimanymd(BizDate pHaraimanymd) {
        this.haraimanymd = pHaraimanymd;
    }

    public BizDate getHknkknmanryouymd() {
        return hknkknmanryouymd;
    }

    public void setHknkknmanryouymd(BizDate pHknkknmanryouymd) {
        this.hknkknmanryouymd = pHknkknmanryouymd;
    }

    public C_KataKbn getKataKbn() {
        return kataKbn;
    }

    public void setKataKbn(C_KataKbn pKataKbn) {
        this.kataKbn = pKataKbn;
    }

    public C_KyhgndkataKbn getKyhgndkataKbn() {
        return kyhgndkataKbn;
    }

    public void setKyhgndkataKbn(C_KyhgndkataKbn pKyhgndkataKbn) {
        this.kyhgndkataKbn = pKyhgndkataKbn;
    }

    public C_SyukyhkinkataKbn getSyukyhkinkataKbn() {
        return syukyhkinkataKbn;
    }

    public void setSyukyhkinkataKbn(C_SyukyhkinkataKbn pSyukyhkinkataKbn) {
        this.syukyhkinkataKbn = pSyukyhkinkataKbn;
    }

    public C_KhnkyhkgbairituKbn getKhnkyhkgbairituKbn() {
        return khnkyhkgbairituKbn;
    }

    public void setKhnkyhkgbairituKbn(C_KhnkyhkgbairituKbn pKhnkyhkgbairituKbn) {
        this.khnkyhkgbairituKbn = pKhnkyhkgbairituKbn;
    }

    public C_6daiLdKbn getRokudaildkbn() {
        return rokudaildkbn;
    }

    public void setRokudaildkbn(C_6daiLdKbn pRokudaildkbn) {
        this.rokudaildkbn = pRokudaildkbn;
    }

    public C_PmnjtkKbn getPmnjtkKbn() {
        return pmnjtkKbn;
    }

    public void setPmnjtkKbn(C_PmnjtkKbn pPmnjtkKbn) {
        this.pmnjtkKbn = pPmnjtkKbn;
    }

    public BizCurrency getKihons() {
        return kihons;
    }

    public void setKihons(BizCurrency pKihons) {
        this.kihons = pKihons;
    }

    public BizCurrency getHokenryou() {
        return hokenryou;
    }

    public void setHokenryou(BizCurrency pHokenryou) {
        this.hokenryou = pHokenryou;
    }

    public C_Tuukasyu getKyktuukasyu() {
        return kyktuukasyu;
    }

    public void setKyktuukasyu(C_Tuukasyu pKyktuukasyu) {
        this.kyktuukasyu = pKyktuukasyu;
    }

    public String getRyouritusdno() {
        return ryouritusdno;
    }

    public void setRyouritusdno(String pRyouritusdno) {
        this.ryouritusdno = pRyouritusdno;
    }

    public BizNumber getYoteiriritu() {
        return yoteiriritu;
    }

    public void setYoteiriritu(BizNumber pYoteiriritu) {
        this.yoteiriritu = pYoteiriritu;
    }

    public BizNumber getYoteirrthendohosyurrt() {
        return yoteirrthendohosyurrt;
    }

    public void setYoteirrthendohosyurrt(BizNumber pYoteirrthendohosyurrt) {
        this.yoteirrthendohosyurrt = pYoteirrthendohosyurrt;
    }

    public Integer getYtirrthndmnskaisuu() {
        return ytirrthndmnskaisuu;
    }

    public void setYtirrthndmnskaisuu(Integer pYtirrthndmnskaisuu) {
        this.ytirrthndmnskaisuu = pYtirrthndmnskaisuu;
    }

    public BizNumber getKyksjkkktyouseiriritu() {
        return kyksjkkktyouseiriritu;
    }

    public void setKyksjkkktyouseiriritu(BizNumber pKyksjkkktyouseiriritu) {
        this.kyksjkkktyouseiriritu = pKyksjkkktyouseiriritu;
    }

    public C_Nenkinsyu getNksyukbn() {
        return nksyukbn;
    }

    public void setNksyukbn(C_Nenkinsyu pNksyukbn) {
        this.nksyukbn = pNksyukbn;
    }

    public Integer getNenkinkkn() {
        return nenkinkkn;
    }

    public void setNenkinkkn(Integer pNenkinkkn) {
        this.nenkinkkn = pNenkinkkn;
    }

    public Integer getNkgnshosyouritu() {
        return nkgnshosyouritu;
    }

    public void setNkgnshosyouritu(Integer pNkgnshosyouritu) {
        this.nkgnshosyouritu = pNkgnshosyouritu;
    }

    public BizCurrency getNkgnshosyougk() {
        return nkgnshosyougk;
    }

    public void setNkgnshosyougk(BizCurrency pNkgnshosyougk) {
        this.nkgnshosyougk = pNkgnshosyougk;
    }

    public String getGyoumuKousinKinou() {
        return gyoumuKousinKinou;
    }

    public void setGyoumuKousinKinou(String pGyoumuKousinKinou) {
        this.gyoumuKousinKinou = pGyoumuKousinKinou;
    }

    public BizCurrency getGengakugoyenitijibrpstgk() {
        return gengakugoyenitijibrpstgk;
    }

    public void setGengakugoyenitijibrpstgk(BizCurrency pGengakugoyenitijibrpstgk) {
        this.gengakugoyenitijibrpstgk = pGengakugoyenitijibrpstgk;
    }

    public BizDate getYendthnkymd() {
        return yendthnkymd;
    }

    public void setYendthnkymd(BizDate pYendthnkymd) {
        this.yendthnkymd = pYendthnkymd;
    }

    public BizNumber getSetteibairitu() {
        return setteibairitu;
    }

    public void setSetteibairitu(BizNumber pSetteibairitu) {
        this.setteibairitu = pSetteibairitu;
    }

    public BizNumber getKykjisisuurendourate() {
        return kykjisisuurendourate;
    }

    public void setKykjisisuurendourate(BizNumber pKykjisisuurendourate) {
        this.kykjisisuurendourate = pKykjisisuurendourate;
    }

    public BizNumber getTmttknzoukaritujygn() {
        return tmttknzoukaritujygn;
    }

    public void setTmttknzoukaritujygn(BizNumber pTmttknzoukaritujygn) {
        this.tmttknzoukaritujygn = pTmttknzoukaritujygn;
    }

    public BizNumber getTumitateriritu() {
        return tumitateriritu;
    }

    public void setTumitateriritu(BizNumber pTumitateriritu) {
        this.tumitateriritu = pTumitateriritu;
    }

    public C_TmttknhaibunjyoutaiKbn getTmttknhaibunjyoutai() {
        return tmttknhaibunjyoutai;
    }

    public void setTmttknhaibunjyoutai(C_TmttknhaibunjyoutaiKbn pTmttknhaibunjyoutai) {
        this.tmttknhaibunjyoutai = pTmttknhaibunjyoutai;
    }

    public C_Sisuukbn getSisuukbn() {
        return sisuukbn;
    }

    public void setSisuukbn(C_Sisuukbn pSisuukbn) {
        this.sisuukbn = pSisuukbn;
    }

    public C_UmuKbn getGsbunrikzkakuninumu() {
        return gsbunrikzkakuninumu;
    }

    public void setGsbunrikzkakuninumu(C_UmuKbn pGsbunrikzkakuninumu) {
        this.gsbunrikzkakuninumu = pGsbunrikzkakuninumu;
    }

    public C_UmuKbn getGsbunritaisyou() {
        return gsbunritaisyou;
    }

    public void setGsbunritaisyou(C_UmuKbn pGsbunritaisyou) {
        this.gsbunritaisyou = pGsbunritaisyou;
    }

    public BizCurrency getPharaikomisougaku() {
        return pharaikomisougaku;
    }

    public void setPharaikomisougaku(BizCurrency pPharaikomisougaku) {
        this.pharaikomisougaku = pPharaikomisougaku;
    }

    public BizDate getTmttknitenYmd() {
        return tmttknitenymd;
    }

    public void setTmttknitenYmd(BizDate pTmttknitenYmd) {
        this.tmttknitenymd = pTmttknitenYmd;
    }

    public BizNumber getLoadinghnkgtumitateriritu() {
        return loadinghnkgtumitateriritu;
    }

    public void setLoadinghnkgtumitateriritu(BizNumber pLoadinghnkgtumitateriritu) {
        this.loadinghnkgtumitateriritu = pLoadinghnkgtumitateriritu;
    }

    public BizNumber getRendouritu() {
        return rendouritu;
    }

    public void setRendouritu(BizNumber pRendouritu) {
        this.rendouritu = pRendouritu;
    }

    public BizNumber getTeikishrritu() {
        return teikishrritu;
    }

    public void setTeikishrritu(BizNumber pTeikishrritu) {
        this.teikishrritu = pTeikishrritu;
    }

    public Integer getDai1hknkkn() {
        return dai1hknkkn;
    }

    public void setDai1hknkkn(Integer pDai1hknkkn) {
        this.dai1hknkkn = pDai1hknkkn;
    }

    public BizDate getSyoriYmd() {
        return syoriYmd;
    }

    public void setSyoriYmd(BizDate pSyoriYmd) {
        this.syoriYmd = pSyoriYmd;
    }

    public C_SyoriKbn getSyorikbn() {
        return syorikbn;
    }

    public void setSyorikbn(C_SyoriKbn pSyorikbn) {
        this.syorikbn = pSyorikbn;
    }


}
