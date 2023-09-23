package yuyu.common.hozen.khcommon;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.number.currencytype.BizCurrencyTypes;

import org.slf4j.Logger;

import yuyu.common.biz.bzcommon.BizDateUtil;
import yuyu.common.biz.bzcommon.GetKawaseRate;
import yuyu.common.biz.bzcommon.HanteiHokenKikan;
import yuyu.common.biz.bzcommon.HanteiHokenKikanBean;
import yuyu.common.biz.bzcommon.KeisanGaikakanzan;
import yuyu.common.biz.exception.CommonBizAppException;
import yuyu.common.siharai.sicommon.CalcHkShrKngk;
import yuyu.common.siharai.sicommon.CalcHkShrKngkBean;
import yuyu.common.siharai.sicommon.CalcJdkghkKngk;
import yuyu.common.siharai.sicommon.CalcJdkghkKngkBean;
import yuyu.def.classification.C_DirectServiceMosKbn;
import yuyu.def.classification.C_EigyoubiHoseiKbn;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_HasuusyoriKbn;
import yuyu.def.classification.C_HknKknKbn;
import yuyu.def.classification.C_HokenkinsyuruiKbn;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_JydkgmbHkKsnKbn;
import yuyu.def.classification.C_KawaserateSyuruiKbn;
import yuyu.def.classification.C_KawasetekiyoKbn;
import yuyu.def.classification.C_KawasetsryKbn;
import yuyu.def.classification.C_KjkhukaKbn;
import yuyu.def.classification.C_SiinKbn;
import yuyu.def.classification.C_SyoriKbn;
import yuyu.def.classification.C_Tkhukaumu;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_TykzentykgoKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_YouhiKbn;
import yuyu.def.db.entity.BM_SyouhnZokusei;
import yuyu.def.db.entity.IT_HhknSya;
import yuyu.def.db.entity.IT_HokenSyouken;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.IT_KykSonotaTkyk;
import yuyu.def.db.entity.IT_KykSya;
import yuyu.def.db.entity.IT_KykSyouhn;
import yuyu.def.db.entity.IT_KykUkt;
import yuyu.def.db.entity.IT_NyknJissekiRireki;
import yuyu.def.hozen.configuration.YuyuHozenConfig;

/**
 * 契約保全 契約保全共通 保険証券TBL編集（終身２）
 */
public class EditSyoukenTblSyuusin2 {

    private static final int SINKEIYAKUHOKENSYOUKEN = 1;

    private static final int KYKJI = 1;

    private static final int SAISAKUSEIJI = 2;

    private static final int SONOTANAIYOULSTMAXCNT = 20;

    private static final int HUTANHIYUSTMMSGCDUEMAXCNT = 4;

    private static final int WTYUUIJIKOUMSGCDMAXCNT = 7;

    private static final int SYOUHNHUTAIMSGCDLSTMAXCNT = 2;

    private static final int DAI1HKNKKNMAXCNT = 10;

    private static final int SIBOUDAI1HKNKKNMSGCDCNT = 2;

    private static final int MKHYOUYENSYSNIKOUMSGCDMAXCNT = 3;

    private static final double HUTANHIYUSTMYTIJIHIRITU = 1.0;

    private static final BizDate KIRIKAE_YMD = BizDate.valueOf("20200401");

    private static final BizDate KIRIKAEMAE_YMD = BizDate.valueOf("20200331");

    @Inject
    private static Logger logger;

    public EditSyoukenTblSyuusin2() {
        super();
    }

    public void editTBL(IT_HokenSyouken pHokenSyouken, IT_KykKihon pKykKihon,
        IT_KykSya pKykSya, IT_HhknSya pHhknSya,
        List<IT_KykSyouhn> pSyuKykSyouhnLst,
        List<IT_NyknJissekiRireki> pNyknJissekiRirekiLst,
        IT_KykSonotaTkyk pKykSonotaTkyk, IT_KykUkt pSiteiDairi,
        List<IT_KykUkt> pSibouhokenLst, EditHokenSyoukenParam pEditHokenSyoukenParam, BizDate pSyoriYmd,
        C_KjkhukaKbn pSbUktNmKjHukaKbn, C_UmuKbn pGengakuExistsCheck,
        int pSksyoukenskskbn, int pSinkykjyoutai, BM_SyouhnZokusei pSyouhnZokusei, C_SyoriKbn pYendthnkSyoriKbn) {

        logger.debug("▽ 保険証券TBL編集（終身２） 開始");

        C_Tkhukaumu yennykntkhkKbn = C_Tkhukaumu.BLNK;

        BizDate sknnkaisiymd = null;

        String ptokuyakumsgcd = "";

        BizCurrency hokenryou = null;

        C_Tuukasyu ptuukasyu = C_Tuukasyu.BLNK;

        String ptuukasyuNm = "";

        String syukyktkykmsgkbn1 = "";

        String syukyktkykmsgkbn2 = "";

        String syukyktkykmsgkbn3 = "";

        C_Tuukasyu syukyktkykstuukatype1 = C_Tuukasyu.BLNK;

        C_Tuukasyu syukyktkykstuukatype2 = C_Tuukasyu.BLNK;

        C_Tuukasyu syukyktkykstuukatype3 = C_Tuukasyu.BLNK;

        BizCurrency syukyktkykhknkngk1 = null;

        BizCurrency syukyktkykhknkngk2 = null;

        BizCurrency syukyktkykhknkngk3 = null;

        BizDate syutkdai1hknkknymdto1 = null;

        BizDate syutkdai2hknkknymdto1 = null;

        BizDate syutkdai2hknkknymdto2 = null;

        String kykniyustmsgcd1 = "";

        String kykniyustmsgcd2 = "";

        String kykniyustmsgcd3 = "";

        String kykniyustmsgcd4 = "";

        C_Tuukasyu kykniyustitjbrptuuktype = C_Tuukasyu.BLNK;

        BizCurrency kykniyustitjbrp = null;

        String siboudai2hknkknmsgcd1 = "";

        String siboudai2hknkknmsgcd2 = "";

        String siboudai1hknkknhrsmsgcd = "";

        String siboudai1hknkknhrsmsgcd2 = "";

        String siboudai1hknkknsmrmsgcd = "";

        String siboudai1hknkknigimsgcd = "";

        String siboudai1hknkknigimsgcd2 = "";

        String siboudai2hknkknsmsgcd = "";

        String siboudai2hknkknsmsgcd2 = "";

        String siboumidasimsgcd1 = "";

        String siboumidasimsgcd2 = "";

        C_Tuukasyu sibouitjbrpyentuuktype = C_Tuukasyu.BLNK;

        BizCurrency sibouitjbrpyentuukgk = null;

        C_UmuKbn maruExistsFlg = C_UmuKbn.NONE;

        BizCurrency dai1syenyendakahuryo = null;

        BizCurrency dai1syenyenkijyunhuryo = null;

        BizCurrency dai1syenyenyasuhuryo = null;

        String dai1syenyendakaumuhuryo = C_UmuKbn.NONE.getValue();

        String dai1syenyenkjnumuhuryo = C_UmuKbn.NONE.getValue();

        String dai1syenyenyasuumuhuryo = C_UmuKbn.NONE.getValue();

        C_Tuukasyu dai1stuuktypehuryo = C_Tuukasyu.BLNK;

        BizCurrency dai1shuryo = null;

        C_Tuukasyu dai1syentuuktypehuryo = C_Tuukasyu.BLNK;

        BizCurrency dai2s = null;

        C_Tuukasyu dai2syentuuktype = C_Tuukasyu.BLNK;

        BizCurrency dai2syenyendaka = null;

        BizCurrency dai2syenyenkijyun = null;

        BizCurrency dai2syenyenyasu = null;

        C_Tuukasyu dai2stuuktype = C_Tuukasyu.BLNK;

        C_Tuukasyu siboudai1kjnkngktuuktype = C_Tuukasyu.BLNK;

        BizCurrency siboudai1kjnkngk = null;

        C_Tuukasyu siboudai2kjnkngktuuktype = C_Tuukasyu.BLNK;

        BizCurrency siboudai2kjnkngk = null;

        BizNumber skwsrateyendaka = null;

        BizNumber skwsrateyenkijyun = null;

        BizNumber skwsrateyenyasu = null;

        C_Tuukasyu mkhyouyensysnikougktype = C_Tuukasyu.BLNK;

        BizNumber mkhyouyensysnikouwra = null;

        String kaigomaehrtkykkyktuuka = "";

        String kaigomaehrtkykmsgcd1 = "";

        String kaigomaehrtkykmsgcd2 = "";

        C_UmuKbn kaigomaehruktgkumu = C_UmuKbn.NONE;

        C_Tuukasyu kaigomaehrjrugktype = C_Tuukasyu.BLNK;

        String kaigomaehrtkykmsgcdst1 = "";

        String kaigomaehrtkykstdmsgcd = "";

        int kaigomaehrsikuhhknnen = 0;

        String hutanhiyustmknsnhyuptn = "";

        String hutanhiyustmmsgcdst01 = "";

        String hutanhiyustmmsgcdst02 = "";

        String hutanhiyustmmsgcdst03 = "";

        String wmsgcd1 = "";

        String wmsgcd2 = "";

        String wmsgcd3 = "";

        String wmsgcd2_1 = "";

        String wmsgcd2_2 = "";

        String wmsgcd3_1 = "";

        String wmsgcdst = "";

        C_Tuukasyu witijibrptuktype = C_Tuukasyu.BLNK;

        BizCurrency witijibrp = null;

        C_Tuukasyu wyenhrkgktuktype = C_Tuukasyu.BLNK;

        BizCurrency wyenhrkgk = null;

        C_Tuukasyu wyenitijibrptuktype = C_Tuukasyu.BLNK;

        BizCurrency wyenitijibrp = null;

        String koujyosyoumeimsgcd1 = "";

        BizNumber hyoujiransjkkktusirrt = null;

        BizDate sonotanyranyensysnhkhnkymd = null;

        C_HknKknKbn hknkknkbn = C_HknKknKbn.BLNK;

        BizDate dai1hknkknEndYmd = null;

        BizCurrency kijyungaku = null;

        String pmsgcd1 = null;

        String pmsgcd2 = null;

        String syukyktkykhknkknmsgkbn1 = null;

        String syukyktkykhknkknmsgkbn2 = null;

        String syukyktkykhknkknmsgkbn3 = null;

        String syukyktkyksmsgkbn1 = null;

        String syukyktkyksmsgkbn2 = null;

        String syukyktkyksmsgkbn3 = null;

        BizDate kgmaehrtkdai1hknkknmnryymd = null;

        int keikanensuu = 0;

        int keikanensuuMax = 0;

        int hhknnenOutou = 0;

        int hhknnen = 0;

        C_Tuukasyu fstphrkpkngkkeituuktype = C_Tuukasyu.BLNK;

        BizCurrency fstphrkpkngkkei = null;

        List<String> stNaiyouranMsgCdList = new ArrayList<>();

        List<Integer> kaigomaehrsikuhhknnenLst = new ArrayList<>();

        List<BizNumber> kaigomaehrstikknLst = new ArrayList<>();

        List<BizCurrency> kaigomaehrjrugkLst = new ArrayList<>();

        List<String> hutanhiyustmmsgcdueLst = new ArrayList<>();

        List<String> wtyuuijikoumsgcdLst = new ArrayList<>();

        List<String> siboudai1hknkknmsgcdLst = new ArrayList<>();

        List<String> mkhyouyensysnikoumsgcdLst = new ArrayList<>();

        List<Integer> dai1skeikanensuuLst = new ArrayList<>();

        List<BizDate> dai1sibousnenoutouymd = new ArrayList<>();

        List<C_Tuukasyu> dai1stuuktypeLst = new ArrayList<>();

        List<BizCurrency> dai1sLst = new ArrayList<>();

        List<C_Tuukasyu> dai1syentuuktypeLst = new ArrayList<>();

        List<BizCurrency> dai1syenyendakaLst = new ArrayList<>();

        List<BizCurrency> dai1syenyenkijyunLst = new ArrayList<>();

        List<BizCurrency> dai1syenyenyasuLst = new ArrayList<>();

        List<C_UmuKbn> dai1syenyendakaumuLst = new ArrayList<>();

        List<C_UmuKbn> dai1syenyenkijyunumuLst = new ArrayList<>();

        List<C_UmuKbn> dai1syenyenyasuumuLst = new ArrayList<>();

        List<String> syouhnhutaimsgcdLst = new ArrayList<>();

        List<String> hyoujiranleftmsgcdLst = new ArrayList<>();

        List<String> hyoujiranrightmsgcdLst = new ArrayList<>();

        BizNumber kykjisisuurendourate = pSyuKykSyouhnLst.get(0).getKykjisisuurendourate();

        BizNumber yoteiriritu = pSyuKykSyouhnLst.get(0).getYoteiriritu();

        C_Tuukasyu kyktuukasyu = pSyuKykSyouhnLst.get(0).getKyktuukasyu();

        String kyktuukasyuNm = pSyuKykSyouhnLst.get(0).getKyktuukasyu().getContent();

        BizDate yendthnkymd = pSyuKykSyouhnLst.get(0).getYendthnkymd();

        int dai1hknkkn = pSyuKykSyouhnLst.get(0).getDai1hknkkn();

        int dai2hknkkn = pSyouhnZokusei.getMvatekikkn() - dai1hknkkn;

        C_UmuKbn kzkTirasidouhuukbn1 = pHokenSyouken.getHokenSyoukenHukaInfo().getKzktirasidouhuukbn1();

        C_UmuKbn kzkTirasidouhuukbn2 = pHokenSyouken.getHokenSyoukenHukaInfo().getKzktirasidouhuukbn2();

        C_UmuKbn kykDrtkykhukaumu = pKykSonotaTkyk.getKykdrtkykhukaumu();

        BizNumber tumitateriritu = null;

        if (C_UmuKbn.NONE.eq(pGengakuExistsCheck)) {

            if (C_UmuKbn.ARI.eq(pKykSonotaTkyk.getYennykntkhkumu())) {

                yennykntkhkKbn = C_Tkhukaumu.HUKA;
            }
            else {

                yennykntkhkKbn = C_Tkhukaumu.NONE;
            }

            if (!C_Tuukasyu.JPY.eq(pSyuKykSyouhnLst.get(0).getKyktuukasyu())) {

                KeisanKijyungk keisanKijyungk = SWAKInjector.getInstance(KeisanKijyungk.class);

                C_ErrorKbn result = keisanKijyungk.exec(pKykKihon.getFstpnyknymd(),
                    pNyknJissekiRirekiLst.get(0).getRsgaku(), pKykKihon.getHrkp(),
                    pSyuKykSyouhnLst.get(0).getKyktuukasyu(), yennykntkhkKbn);

                if (C_ErrorKbn.ERROR.eq(result)) {
                    throw new CommonBizAppException("基準金額が取得できませんでした。");
                }

                kijyungaku = keisanKijyungk.getKijyungk();
            }
        }
        else {

            if (C_UmuKbn.ARI.eq(pKykSonotaTkyk.getInitsbjiyensitihsytkhukaumu())) {

                kijyungaku = pKykSonotaTkyk.getInitsbjiyenkasaiteihsygk();
            }
            else if (C_UmuKbn.ARI.eq(pKykSonotaTkyk.getTargettkhkumu())) {

                kijyungaku = pKykSonotaTkyk.getTargettkykkijyungk();
            }
        }

        if (yendthnkymd == null) {

            HanteiHokenKikan hanteiHokenKikan = SWAKInjector.getInstance(HanteiHokenKikan.class);

            HanteiHokenKikanBean hanteiHokenKikanBean = SWAKInjector.getInstance(HanteiHokenKikanBean.class);

            hanteiHokenKikanBean.setKykYmd(pSyuKykSyouhnLst.get(0).getKykymd());

            hanteiHokenKikanBean.setCalcKijyunYmd(pSyoriYmd);

            hanteiHokenKikanBean.setSyouhnZokusei(pSyouhnZokusei);

            hanteiHokenKikanBean.setDai1hknkkn(dai1hknkkn);

            hknkknkbn = hanteiHokenKikan.exec(hanteiHokenKikanBean);

            dai1hknkknEndYmd = hanteiHokenKikan.getDai2HknkknStartYmd().getPreviousDay();
        }

        hyoujiranleftmsgcdLst.add("02010");
        if (yendthnkymd == null) {

            hyoujiranleftmsgcdLst.add("02026");
        }

        if (pSksyoukenskskbn == SINKEIYAKUHOKENSYOUKEN) {

            hyoujiranleftmsgcdLst.add("02023");
            hyoujiranleftmsgcdLst.add("02490");
            hyoujiranrightmsgcdLst.add("02511");
            hyoujiranrightmsgcdLst.add("02520");
            sknnkaisiymd = pSyuKykSyouhnLst.get(0).getSknnkaisiymd();
        }
        else {

            tumitateriritu = pSyuKykSyouhnLst.get(0).getTumitateriritu();

            if (yendthnkymd == null) {

                hyoujiranleftmsgcdLst.add("02023");
                hyoujiranleftmsgcdLst.add("02051");
                hyoujiranleftmsgcdLst.add("02060");
                hyoujiransjkkktusirrt = pSyuKykSyouhnLst.get(0).getKyksjkkktyouseiriritu();
            }
            else {

                hyoujiranleftmsgcdLst.add("02053");
            }
        }

        if (pSksyoukenskskbn == SINKEIYAKUHOKENSYOUKEN) {

            pmsgcd1 = "05010";
            hokenryou = pSyuKykSyouhnLst.get(0).getHokenryou();
            ptuukasyu = kyktuukasyu;

            if (C_UmuKbn.ARI.eq(pKykSonotaTkyk.getYennykntkhkumu())) {

                ptokuyakumsgcd = "05021";
            }
            else if (C_UmuKbn.ARI.eq(pKykSonotaTkyk.getGaikanykntkhkumu())) {

                ptokuyakumsgcd = "05030";
                ptuukasyuNm = pNyknJissekiRirekiLst.get(0).getRstuukasyu().getContent();
            }
        }
        else {
            if (yendthnkymd == null) {

                pmsgcd1 = "05010";
                hokenryou = pNyknJissekiRirekiLst.get(0).getHrkp();
                ptuukasyu = kyktuukasyu;

                if (C_UmuKbn.ARI.eq(pGengakuExistsCheck)) {

                    pmsgcd2 = "05020";
                }

                if (C_UmuKbn.ARI.eq(pKykSonotaTkyk.getYennykntkhkumu())) {

                    ptokuyakumsgcd = "05041";
                }

                if (C_UmuKbn.ARI.eq(pKykSonotaTkyk.getGaikanykntkhkumu())) {

                    ptuukasyuNm = pNyknJissekiRirekiLst.get(0).getRstuukasyu().getContent();
                    ptokuyakumsgcd = "05051";
                }
            }
            else {
                pmsgcd1 = "05011";
            }
        }

        syukyktkykstuukatype1 = kyktuukasyu;
        syukyktkykhknkngk1 = pSyuKykSyouhnLst.get(0).getKihons();

        if (pSksyoukenskskbn == SINKEIYAKUHOKENSYOUKEN) {
            syukyktkykhknkknmsgkbn1 = "01";
            syukyktkykhknkknmsgkbn2 = "05";
            syukyktkykmsgkbn1 = "01";
            syukyktkykmsgkbn2 = "02";

            if (C_UmuKbn.ARI.eq(pKykSonotaTkyk.getInitsbjiyensitihsytkhukaumu())) {
                syukyktkyksmsgkbn1 = "03";
                syukyktkyksmsgkbn2 = "04";
            }
            else {
                syukyktkyksmsgkbn1 = "01";
                syukyktkyksmsgkbn2 = "02";
            }
        }
        else {

            if (yendthnkymd == null) {

                if (C_HknKknKbn.DAI1HKNKKN.eq(hknkknkbn)) {

                    syukyktkykmsgkbn1 = "01";
                    syukyktkykmsgkbn2 = "02";
                    syukyktkykhknkknmsgkbn1 = "01";
                    syukyktkykhknkknmsgkbn2 = "06";
                    syutkdai1hknkknymdto1 = dai1hknkknEndYmd;
                }
                else if (C_HknKknKbn.DAI2HKNKKN.eq(hknkknkbn)) {

                    syukyktkykmsgkbn1 = "04";
                    syukyktkykhknkknmsgkbn1 = "03";
                }

                if (C_UmuKbn.ARI.eq(pKykSonotaTkyk.getInitsbjiyensitihsytkhukaumu())) {

                    if (C_HknKknKbn.DAI1HKNKKN.eq(hknkknkbn)) {

                        syukyktkyksmsgkbn1 = "05";
                        syukyktkyksmsgkbn2 = "06";
                    }
                    else if (C_HknKknKbn.DAI2HKNKKN.eq(hknkknkbn)) {

                        syukyktkyksmsgkbn1 = "04";
                    }
                }
                else {
                    if (C_HknKknKbn.DAI1HKNKKN.eq(hknkknkbn)) {

                        syukyktkyksmsgkbn1 = "01";
                        syukyktkyksmsgkbn2 = "02";
                    }
                    else if (C_HknKknKbn.DAI2HKNKKN.eq(hknkknkbn)) {

                        syukyktkyksmsgkbn1 = "04";
                    }
                }
            }
            else {
                syukyktkykmsgkbn1 = "05";
                syukyktkyksmsgkbn1 = "04";
                syukyktkykhknkknmsgkbn1 = "03";
            }
        }

        if (pSksyoukenskskbn == SINKEIYAKUHOKENSYOUKEN) {

            kykniyustmsgcd1 = "08010";

            if (C_UmuKbn.ARI.eq(pKykSonotaTkyk.getInitsbjiyensitihsytkhukaumu())) {

                kykniyustmsgcd2 = "08021";
                kykniyustmsgcd3 = "08031";
                kykniyustmsgcd4 = "08051";
                kykniyustitjbrptuuktype = C_Tuukasyu.JPY;
                kykniyustitjbrp = pKykSonotaTkyk.getInitsbjiyenkasaiteihsygk();
            }
            else {

                kykniyustmsgcd2 = "08022";
                kykniyustmsgcd3 = "08041";
            }
        }
        else {

            if (yendthnkymd == null) {

                if (C_UmuKbn.ARI.eq(pKykSonotaTkyk.getInitsbjiyensitihsytkhukaumu())) {

                    if (C_HknKknKbn.DAI1HKNKKN.eq(hknkknkbn)) {

                        kykniyustitjbrptuuktype = C_Tuukasyu.JPY;
                        kykniyustitjbrp = pKykSonotaTkyk.getInitsbjiyenkasaiteihsygk();
                        kykniyustmsgcd1 = "08010";
                        kykniyustmsgcd2 = "08022";
                        kykniyustmsgcd3 = "08051";
                        kykniyustmsgcd4 = "08061";
                    }
                    else if (C_HknKknKbn.DAI2HKNKKN.eq(hknkknkbn)) {
                        kykniyustmsgcd1 = "08041";
                    }
                }
                else {
                    if (C_HknKknKbn.DAI1HKNKKN.eq(hknkknkbn)) {
                        kykniyustmsgcd1 = "08010";
                        kykniyustmsgcd2 = "08021";
                        kykniyustmsgcd3 = "08031";
                    }
                    else if (C_HknKknKbn.DAI2HKNKKN.eq(hknkknkbn)) {
                        kykniyustmsgcd1 = "08041";
                    }
                }
            }
            else {

                kykniyustmsgcd1 = "08023";
            }
        }

        if (pSksyoukenskskbn == SINKEIYAKUHOKENSYOUKEN) {

            if ((pSinkykjyoutai == KYKJI &&
                (BizDateUtil.compareYmd(pKykKihon.getMosymd(), KIRIKAE_YMD) == BizDateUtil.COMPARE_EQUAL ||
                BizDateUtil.compareYmd(pKykKihon.getMosymd(), KIRIKAE_YMD) == BizDateUtil.COMPARE_GREATER)) ||
                (pSinkykjyoutai == SAISAKUSEIJI &&
                ((BizDateUtil.compareYmd(pKykKihon.getMosymd(), KIRIKAE_YMD) == BizDateUtil.COMPARE_EQUAL ||
                BizDateUtil.compareYmd(pKykKihon.getMosymd(), KIRIKAE_YMD) == BizDateUtil.COMPARE_GREATER) ||
                (BizDateUtil.compareYmd(pHokenSyouken.getTyouhyouymd(), KIRIKAE_YMD) == BizDateUtil.COMPARE_EQUAL ||
                BizDateUtil.compareYmd(pHokenSyouken.getTyouhyouymd(), KIRIKAE_YMD) == BizDateUtil.COMPARE_GREATER)))) {

                if (C_UmuKbn.ARI.eq(pSyouhnZokusei.getKzktourokuserviceumu())) {

                    if (C_UmuKbn.ARI.eq(kzkTirasidouhuukbn1) ||
                        C_UmuKbn.ARI.eq(kzkTirasidouhuukbn2)) {

                        stNaiyouranMsgCdList.add("09041");
                    }
                }

                if (C_UmuKbn.ARI.eq(kykDrtkykhukaumu)) {

                    stNaiyouranMsgCdList.add("09047");
                }

                if (C_UmuKbn.ARI.eq(pKykSonotaTkyk.getStdrsktkyhkumu())) {

                    stNaiyouranMsgCdList.add("09051");
                }
            }
        }
        else {

            if (C_UmuKbn.ARI.eq(pSyouhnZokusei.getKzktourokuserviceumu())) {

                if (C_UmuKbn.ARI.eq(kzkTirasidouhuukbn1) ||
                    C_UmuKbn.ARI.eq(kzkTirasidouhuukbn2)) {

                    stNaiyouranMsgCdList.add("09041");
                }
            }

            if (C_UmuKbn.ARI.eq(kykDrtkykhukaumu)) {

                stNaiyouranMsgCdList.add("09048");
            }

            if (C_UmuKbn.ARI.eq(pKykSonotaTkyk.getStdrsktkyhkumu())) {

                stNaiyouranMsgCdList.add("09051");
            }
        }

        if (pSksyoukenskskbn == SINKEIYAKUHOKENSYOUKEN) {
            stNaiyouranMsgCdList.add("09010");

            if (C_UmuKbn.ARI.eq(pKykSonotaTkyk.getYennykntkhkumu())) {
                stNaiyouranMsgCdList.add("09021");
            }

            if (C_UmuKbn.ARI.eq(pKykSonotaTkyk.getGaikanykntkhkumu())) {
                stNaiyouranMsgCdList.add("09030");
            }

            if (C_UmuKbn.ARI.eq(pKykSonotaTkyk.getInitsbjiyensitihsytkhukaumu()) ||
                C_UmuKbn.ARI.eq(pKykSonotaTkyk.getTargettkhkumu())) {
                if (C_UmuKbn.ARI.eq(pKykSonotaTkyk.getYennykntkhkumu())) {
                    stNaiyouranMsgCdList.add("09032");
                }
                else {
                    stNaiyouranMsgCdList.add("09034");
                }
            }

            if (C_UmuKbn.ARI.eq(pKykSonotaTkyk.getInitsbjiyensitihsytkhukaumu())) {
                stNaiyouranMsgCdList.add("09038");
            }

            if (C_UmuKbn.ARI.eq(pKykSonotaTkyk.getJyudkaigomeharaitkhukaumu())) {
                stNaiyouranMsgCdList.add("09040");
            }

            if (C_UmuKbn.ARI.eq(pKykSonotaTkyk.getStdrsktkyhkumu())) {

                if ((pSinkykjyoutai == KYKJI &&
                    (BizDateUtil.compareYmd(pKykKihon.getMosymd(), KIRIKAEMAE_YMD) == BizDateUtil.COMPARE_LESSER ||
                    BizDateUtil.compareYmd(pKykKihon.getMosymd(), KIRIKAEMAE_YMD) == BizDateUtil.COMPARE_EQUAL)) ||
                    (pSinkykjyoutai == SAISAKUSEIJI &&
                    (BizDateUtil.compareYmd(pKykKihon.getMosymd(), KIRIKAEMAE_YMD) == BizDateUtil.COMPARE_LESSER ||
                    BizDateUtil.compareYmd(pKykKihon.getMosymd(), KIRIKAEMAE_YMD) == BizDateUtil.COMPARE_EQUAL) &&
                    (BizDateUtil.compareYmd(pHokenSyouken.getTyouhyouymd(), KIRIKAEMAE_YMD) == BizDateUtil.COMPARE_LESSER ||
                    BizDateUtil.compareYmd(pHokenSyouken.getTyouhyouymd(), KIRIKAEMAE_YMD) == BizDateUtil.COMPARE_EQUAL))) {

                    stNaiyouranMsgCdList.add("09050");
                }
            }

            stNaiyouranMsgCdList.add("09060");

            if (C_UmuKbn.ARI.eq(pKykSonotaTkyk.getTargettkhkumu())) {
                if (pKykSonotaTkyk.getTargettkmokuhyouti() > 0) {
                    stNaiyouranMsgCdList.add("09071");
                }
                else {
                    stNaiyouranMsgCdList.add("09081");
                }
            }

            stNaiyouranMsgCdList.add("09091");
            stNaiyouranMsgCdList.add("09100");
            tumitateriritu = pSyuKykSyouhnLst.get(0).getTumitateriritu();
        }
        else {

            if (yendthnkymd == null) {

                stNaiyouranMsgCdList.add("09010");
                if (C_UmuKbn.ARI.eq(pKykSonotaTkyk.getYennykntkhkumu())) {
                    stNaiyouranMsgCdList.add("09021");

                    if (C_UmuKbn.ARI.eq(pGengakuExistsCheck)) {
                        stNaiyouranMsgCdList.add("09022");
                    }

                    stNaiyouranMsgCdList.add("09024");
                }
                if (C_UmuKbn.ARI.eq(pKykSonotaTkyk.getGaikanykntkhkumu())) {
                    stNaiyouranMsgCdList.add("09030");

                    if (C_UmuKbn.ARI.eq(pGengakuExistsCheck)) {
                        stNaiyouranMsgCdList.add("09032");
                    }

                    stNaiyouranMsgCdList.add("09034");
                }
            }
            else {

                if (C_UmuKbn.ARI.eq(pKykSonotaTkyk.getYennykntkhkumu())) {

                    stNaiyouranMsgCdList.add("09021");
                }

                if (C_UmuKbn.ARI.eq(pKykSonotaTkyk.getGaikanykntkhkumu())) {

                    stNaiyouranMsgCdList.add("09030");
                }
            }

            if (C_UmuKbn.ARI.eq(pKykSonotaTkyk.getInitsbjiyensitihsytkhukaumu()) ||
                C_UmuKbn.ARI.eq(pKykSonotaTkyk.getTargettkhkumu())) {
                if (C_UmuKbn.ARI.eq(pGengakuExistsCheck)) {
                    if (C_UmuKbn.ARI.eq(pKykSonotaTkyk.getYennykntkhkumu())) {
                        stNaiyouranMsgCdList.add("09080");
                    }
                    else {
                        stNaiyouranMsgCdList.add("09082");
                    }
                }
                else {
                    if (C_UmuKbn.ARI.eq(pKykSonotaTkyk.getYennykntkhkumu())) {
                        stNaiyouranMsgCdList.add("09084");
                    }
                    else {
                        stNaiyouranMsgCdList.add("09086");
                    }
                }
            }

            if (C_UmuKbn.ARI.eq(pKykSonotaTkyk.getInitsbjiyensitihsytkhukaumu())) {
                stNaiyouranMsgCdList.add("09038");
            }

            if (yendthnkymd != null) {

                sonotanyranyensysnhkhnkymd = pSyuKykSyouhnLst.get(0).getYendthnkymd();

                if (C_SyoriKbn.YENDTHNK_MKHGKTTT.eq(pYendthnkSyoriKbn)) {

                    stNaiyouranMsgCdList.add("09047");
                }
                else if (C_SyoriKbn.YENDTHNK_NINISEIKYUU.eq(pYendthnkSyoriKbn)) {

                    stNaiyouranMsgCdList.add("09053");
                }
            }

            if (C_UmuKbn.ARI.eq(pKykSonotaTkyk.getJyudkaigomeharaitkhukaumu())) {
                stNaiyouranMsgCdList.add("09040");
            }

            stNaiyouranMsgCdList.add("09060");

            if (C_UmuKbn.ARI.eq(pKykSonotaTkyk.getTargettkhkumu())) {
                stNaiyouranMsgCdList.add("09071");

                if (pKykSonotaTkyk.getTargettkmokuhyouti() > 0) {
                    stNaiyouranMsgCdList.add("09073");
                }
                else {
                    stNaiyouranMsgCdList.add("09074");
                }
            }

            if (yendthnkymd != null) {

                stNaiyouranMsgCdList.add("09092");
            }
        }

        int stNaiyouranMsgCdListCnt = stNaiyouranMsgCdList.size();

        for (int i = 0; i < SONOTANAIYOULSTMAXCNT - stNaiyouranMsgCdListCnt; i++) {
            stNaiyouranMsgCdList.add("");
        }


        SetOutoubi setOutoubi = SWAKInjector.getInstance(SetOutoubi.class);

        BizDate calcKijyunYmd = setOutoubi.exec(C_TykzentykgoKbn.TYKGO,
            pSyuKykSyouhnLst.get(0).getKykymd(), C_Hrkkaisuu.NEN,
            pEditHokenSyoukenParam.getCalckijyunYMD());

        hhknnenOutou = pSyuKykSyouhnLst.get(0).getHhknnen() +
            BizDateUtil.calcDifference(calcKijyunYmd, pSyuKykSyouhnLst.get(0).getKykymd()).getYears();

        if (pSksyoukenskskbn == SINKEIYAKUHOKENSYOUKEN) {
            keikanensuu = 0;
            keikanensuuMax = dai1hknkkn;
        }
        else {
            keikanensuu = BizDateUtil.calcDifference(calcKijyunYmd, pSyuKykSyouhnLst.get(0).getKykymd()).getYears();
            keikanensuuMax = dai1hknkkn;
        }

        if (pSksyoukenskskbn == SINKEIYAKUHOKENSYOUKEN) {

            siboumidasimsgcd1 = "12010";
            siboudai1hknkknhrsmsgcd = "12071";
            siboudai2hknkknmsgcd1 = "12081";
            siboudai2hknkknsmsgcd = "12111";
            siboudai1hknkknigimsgcd = "12051";

            if (C_UmuKbn.NONE.eq(pKykSonotaTkyk.getInitsbjiyensitihsytkhukaumu())) {

                if (C_UmuKbn.ARI.eq(pKykSonotaTkyk.getYennykntkhkumu())) {

                    siboudai1hknkknmsgcdLst.add("12030");
                }
                else {

                    siboudai1hknkknmsgcdLst.add("12040");
                }
            }
            else {

                siboudai2hknkknmsgcd2 = "12100";
            }
            siboudai1hknkknmsgcdLst.add("12020");
        }
        else {

            if (yendthnkymd == null) {

                siboumidasimsgcd1 = "12010";

                if (C_HknKknKbn.DAI1HKNKKN.eq(hknkknkbn)) {


                    siboudai1hknkknmsgcdLst.add("12020");
                    siboudai1hknkknhrsmsgcd = "12070";
                    siboudai1hknkknigimsgcd = "12051";

                    if (hhknnenOutou <= 105) {
                        siboudai1hknkknigimsgcd2 = "12052";
                    }
                    else {
                        siboudai1hknkknigimsgcd2 = "12054";
                    }

                    if (hhknnenOutou <= 105) {
                        siboudai1hknkknhrsmsgcd2 = "12072";
                    }
                    else {
                        siboudai1hknkknhrsmsgcd2 = "12074";
                    }
                }
                if (C_HknKknKbn.DAI1HKNKKN.eq(hknkknkbn) || C_HknKknKbn.DAI2HKNKKN.eq(hknkknkbn)) {

                    siboudai2hknkknmsgcd1 = "12081";
                    siboudai2hknkknsmsgcd = "12110";

                    if (hhknnenOutou <= 105) {

                        siboudai2hknkknsmsgcd2 = "12113";
                    }
                    else {

                        siboudai2hknkknsmsgcd2 = "12115";

                    }
                    if (C_UmuKbn.ARI.eq(pKykSonotaTkyk.getInitsbjiyensitihsytkhukaumu()) &&
                        C_HknKknKbn.DAI1HKNKKN.eq(hknkknkbn)) {

                        siboudai2hknkknmsgcd2 = "12090";
                    }
                }

                if (C_UmuKbn.NONE.eq(pKykSonotaTkyk.getInitsbjiyensitihsytkhukaumu())) {
                    if (C_UmuKbn.ARI.eq(pGengakuExistsCheck)) {
                        if (C_UmuKbn.ARI.eq(pKykSonotaTkyk.getYennykntkhkumu())) {

                            siboumidasimsgcd2 = "12012";
                        }
                    }
                    else {
                        if (C_UmuKbn.ARI.eq(pKykSonotaTkyk.getYennykntkhkumu())) {

                            siboumidasimsgcd2 = "12014";
                        }
                        else {
                            siboumidasimsgcd2 = "12016";
                        }
                    }
                }
            }
            else {

                siboumidasimsgcd1 = "12011";
            }
        }

        int siboudai1hknkknmsgcdLstCnt = siboudai1hknkknmsgcdLst.size();

        for (int i = 0; i < SIBOUDAI1HKNKKNMSGCDCNT - siboudai1hknkknmsgcdLstCnt; i++) {
            siboudai1hknkknmsgcdLst.add("");
        }

        if (pSksyoukenskskbn == SINKEIYAKUHOKENSYOUKEN) {

            if (C_UmuKbn.NONE.eq(pKykSonotaTkyk.getInitsbjiyensitihsytkhukaumu())) {

                sibouitjbrpyentuuktype = C_Tuukasyu.JPY;
                sibouitjbrpyentuukgk = kijyungaku;
            }
        }
        else {

            if (yendthnkymd == null) {

                if (C_UmuKbn.NONE.eq(pGengakuExistsCheck)) {
                    if (C_UmuKbn.NONE.eq(pKykSonotaTkyk.getInitsbjiyensitihsytkhukaumu())) {

                        sibouitjbrpyentuuktype = C_Tuukasyu.JPY;
                        sibouitjbrpyentuukgk = kijyungaku;
                    }
                }
            }
        }

        GetKawaseRate getKawaseRate = SWAKInjector.getInstance(GetKawaseRate.class);

        KeisanGaikakanzan keisanGaikakanzan = SWAKInjector.getInstance(KeisanGaikakanzan.class);
        if (!C_Tuukasyu.JPY.eq(pSyuKykSyouhnLst.get(0).getKyktuukasyu())) {

            getKawaseRate.exec(pSyuKykSyouhnLst.get(0).getKykymd(),
                C_KawaserateSyuruiKbn.KOUJIKAWASERATE, pSyuKykSyouhnLst.get(0).getKyktuukasyu(),
                C_Tuukasyu.JPY, C_KawasetekiyoKbn.TTM, C_KawasetsryKbn.SYUKKINRATE,
                C_EigyoubiHoseiKbn.YOKUEIGYOUBI, C_YouhiKbn.HUYOU);

            BizNumber yenksykawaserate = getKawaseRate.getKawaserate();
            BizNumber kawaserateHendouYenup = YuyuHozenConfig.getInstance().getKawaserateHendouYenup();
            BizNumber kawaserateHendouYendown = YuyuHozenConfig.getInstance().getKawaserateHendouYendown();
            skwsrateyenkijyun = yenksykawaserate;
            skwsrateyendaka = skwsrateyenkijyun.subtract(kawaserateHendouYenup);
            skwsrateyenyasu = skwsrateyenkijyun.add(kawaserateHendouYendown);

            if (C_HknKknKbn.DAI1HKNKKN.eq(hknkknkbn)) {
                for (int n = 0; n < keikanensuuMax; n++) {

                    if (n == 0) {

                        calcKijyunYmd = pSyuKykSyouhnLst.get(0).getKykymd();
                    }

                    if (pSksyoukenskskbn == SINKEIYAKUHOKENSYOUKEN) {
                        dai1skeikanensuuLst.add(keikanensuu);
                        dai1sibousnenoutouymd.add(null);
                    }
                    else {
                        dai1skeikanensuuLst.add(0);
                        dai1sibousnenoutouymd.add(calcKijyunYmd);
                    }

                    CalcHkShrKngk calcHkShrKngk = SWAKInjector.getInstance(CalcHkShrKngk.class);

                    calcHkShrKngk.exec(pSyuKykSyouhnLst.get(0).getSyouhncd(),
                        pSyuKykSyouhnLst.get(0).getSyouhnsdno(),
                        pSyuKykSyouhnLst.get(0).getRyouritusdno(),
                        pSyuKykSyouhnLst.get(0).getYoteiriritu(),
                        pKykKihon.getHrkkaisuu(),
                        pSyuKykSyouhnLst.get(0).getHknkknsmnkbn(),
                        pSyuKykSyouhnLst.get(0).getHknkkn(),
                        pSyuKykSyouhnLst.get(0).getHrkkkn(),
                        pSyuKykSyouhnLst.get(0).getHhknnen(),
                        pSyuKykSyouhnLst.get(0).getHhknsei(),
                        pSyuKykSyouhnLst.get(0).getKihons(),
                        pSyuKykSyouhnLst.get(0).getKykymd(),
                        calcKijyunYmd, pKykKihon.getSyono(),
                        pSyuKykSyouhnLst.get(0).getKyktuukasyu(),
                        dai1hknkkn,
                        C_SiinKbn.SP,
                        C_HokenkinsyuruiKbn.SBHOKENKIN,
                        pSyuKykSyouhnLst.get(0).getHokenryou(),
                        pSyuKykSyouhnLst.get(0).getKyksjkkktyouseiriritu(),
                        pSyuKykSyouhnLst.get(0).getKyksjkkktyouseiriritu(),
                        null, null, null,
                        pSyuKykSyouhnLst.get(0).getTumitateriritu(),
                        null, null, null, null, null, null,
                        pSyuKykSyouhnLst.get(0).getKykjyoutai(),
                        null,
                        pKykKihon.getSdpdkbn(),
                        pKykKihon.getHrkkeiro());

                    CalcHkShrKngkBean calcHkShrKngkBean1 = calcHkShrKngk.getCalcHkShrKngkBean();

                    dai1stuuktypeLst.add(kyktuukasyu);
                    dai1sLst.add(calcHkShrKngkBean1.getSibousGk());
                    dai1syentuuktypeLst.add(C_Tuukasyu.JPY);

                    BizCurrency dai1syenyendaka = keisanGaikakanzan.exec(
                        C_Tuukasyu.JPY, calcHkShrKngkBean1.getSibousGk(),
                        skwsrateyendaka, C_HasuusyoriKbn.AGE);

                    BizCurrency dai1syenyenkijyun = keisanGaikakanzan.exec(
                        C_Tuukasyu.JPY, calcHkShrKngkBean1.getSibousGk(),
                        skwsrateyenkijyun, C_HasuusyoriKbn.AGE);

                    BizCurrency dai1syenyenyasu = keisanGaikakanzan.exec(
                        C_Tuukasyu.JPY, calcHkShrKngkBean1.getSibousGk(),
                        skwsrateyenyasu, C_HasuusyoriKbn.AGE);

                    if (C_UmuKbn.ARI.eq(pKykSonotaTkyk.getInitsbjiyensitihsytkhukaumu())) {
                        if (dai1syenyendaka.compareTo(pKykSonotaTkyk.getInitsbjiyenkasaiteihsygk()) < 0) {
                            dai1syenyendakaLst.add(pKykSonotaTkyk.getInitsbjiyenkasaiteihsygk());
                            dai1syenyendakaumuLst.add(C_UmuKbn.ARI);
                            maruExistsFlg = C_UmuKbn.ARI;
                        }
                        else {
                            dai1syenyendakaLst.add(dai1syenyendaka);
                            dai1syenyendakaumuLst.add(C_UmuKbn.NONE);
                        }

                        if (dai1syenyenkijyun.compareTo(pKykSonotaTkyk.getInitsbjiyenkasaiteihsygk()) < 0) {
                            dai1syenyenkijyunLst.add(pKykSonotaTkyk.getInitsbjiyenkasaiteihsygk());
                            dai1syenyenkijyunumuLst.add(C_UmuKbn.ARI);
                            maruExistsFlg = C_UmuKbn.ARI;
                        }
                        else {
                            dai1syenyenkijyunLst.add(dai1syenyenkijyun);
                            dai1syenyenkijyunumuLst.add(C_UmuKbn.NONE);
                        }

                        if (dai1syenyenyasu.compareTo(pKykSonotaTkyk.getInitsbjiyenkasaiteihsygk()) < 0) {
                            dai1syenyenyasuLst.add(pKykSonotaTkyk.getInitsbjiyenkasaiteihsygk());
                            dai1syenyenyasuumuLst.add(C_UmuKbn.ARI);
                            maruExistsFlg = C_UmuKbn.ARI;
                        }
                        else {
                            dai1syenyenyasuLst.add(dai1syenyenyasu);
                            dai1syenyenyasuumuLst.add(C_UmuKbn.NONE);
                        }
                    }
                    else {
                        dai1syenyendakaumuLst.add(C_UmuKbn.NONE);
                        dai1syenyenkijyunumuLst.add(C_UmuKbn.NONE);
                        dai1syenyenyasuumuLst.add(C_UmuKbn.NONE);
                        dai1syenyendakaLst.add(dai1syenyendaka);
                        dai1syenyenkijyunLst.add(dai1syenyenkijyun);
                        dai1syenyenyasuLst.add(dai1syenyenyasu);
                    }

                    calcKijyunYmd = BizDate.valueOf(calcKijyunYmd.getYear() + 1,
                        pSyuKykSyouhnLst.get(0).getKykymd().getBizDateMD()).getRekijyou();

                    keikanensuu = keikanensuu + 1;
                }

                int dai1syenyenyasuumuLstCnt = dai1syenyenyasuumuLst.size();

                for (int i = 0; i < DAI1HKNKKNMAXCNT - dai1syenyenyasuumuLstCnt; i++) {
                    dai1syenyendakaumuLst.add(C_UmuKbn.NONE);
                    dai1syenyenkijyunumuLst.add(C_UmuKbn.NONE);
                    dai1syenyenyasuumuLst.add(C_UmuKbn.NONE);
                }
            }

            if (C_HknKknKbn.DAI1HKNKKN.eq(hknkknkbn) || C_HknKknKbn.DAI2HKNKKN.eq(hknkknkbn)) {
                dai2stuuktype = kyktuukasyu;
                dai2s = pSyuKykSyouhnLst.get(0).getKihons();
                dai2syentuuktype = C_Tuukasyu.JPY;

                dai2syenyendaka = keisanGaikakanzan.exec(C_Tuukasyu.JPY, dai2s,
                    skwsrateyendaka, C_HasuusyoriKbn.AGE);

                dai2syenyenkijyun = keisanGaikakanzan.exec(C_Tuukasyu.JPY,
                    dai2s, skwsrateyenkijyun, C_HasuusyoriKbn.AGE);

                dai2syenyenyasu = keisanGaikakanzan.exec(C_Tuukasyu.JPY, dai2s,
                    skwsrateyenyasu, C_HasuusyoriKbn.AGE);
            }

            if (C_HknKknKbn.DAI1HKNKKN.eq(hknkknkbn)) {

                dai1stuuktypehuryo = kyktuukasyu;
                dai1shuryo = pSyuKykSyouhnLst.get(0).getKihons();
                dai1syentuuktypehuryo = C_Tuukasyu.JPY;

                BizCurrency kihonSyendaka = keisanGaikakanzan.exec(
                    C_Tuukasyu.JPY, pSyuKykSyouhnLst.get(0).getKihons(),
                    skwsrateyendaka, C_HasuusyoriKbn.AGE);

                if (kihonSyendaka.compareTo(pKykSonotaTkyk.getInitsbjiyenkasaiteihsygk()) < 0) {
                    dai1syenyendakahuryo = pKykSonotaTkyk
                        .getInitsbjiyenkasaiteihsygk();
                    dai1syenyendakaumuhuryo = C_UmuKbn.ARI.getValue();
                    maruExistsFlg = C_UmuKbn.ARI;
                }
                else {
                    dai1syenyendakahuryo = kihonSyendaka;
                }

                BizCurrency kihonSykijyun = keisanGaikakanzan.exec(
                    C_Tuukasyu.JPY, pSyuKykSyouhnLst.get(0).getKihons(),
                    skwsrateyenkijyun, C_HasuusyoriKbn.AGE);

                if (kihonSykijyun.compareTo(pKykSonotaTkyk.getInitsbjiyenkasaiteihsygk()) < 0) {
                    dai1syenyenkijyunhuryo = pKykSonotaTkyk
                        .getInitsbjiyenkasaiteihsygk();
                    dai1syenyenkjnumuhuryo = C_UmuKbn.ARI.getValue();
                    maruExistsFlg = C_UmuKbn.ARI;
                }
                else {
                    dai1syenyenkijyunhuryo = kihonSykijyun;
                }

                BizCurrency kihonSyyenyasu = keisanGaikakanzan.exec(
                    C_Tuukasyu.JPY, pSyuKykSyouhnLst.get(0).getKihons(),
                    skwsrateyenyasu, C_HasuusyoriKbn.AGE);

                if (kihonSyyenyasu.compareTo(pKykSonotaTkyk.getInitsbjiyenkasaiteihsygk()) < 0) {
                    dai1syenyenyasuhuryo = pKykSonotaTkyk
                        .getInitsbjiyenkasaiteihsygk();
                    dai1syenyenyasuumuhuryo = C_UmuKbn.ARI.getValue();
                    maruExistsFlg = C_UmuKbn.ARI;
                }
                else {
                    dai1syenyenyasuhuryo = kihonSyyenyasu;
                }
            }

            if (C_UmuKbn.ARI.eq(pKykSonotaTkyk.getInitsbjiyensitihsytkhukaumu())) {
                if (C_HknKknKbn.DAI1HKNKKN.eq(hknkknkbn)) {
                    siboudai2kjnkngktuuktype = C_Tuukasyu.JPY;
                    siboudai2kjnkngk = pKykSonotaTkyk.getInitsbjiyenkasaiteihsygk();
                }
            }
        }

        if (pSksyoukenskskbn == SINKEIYAKUHOKENSYOUKEN) {
            if (C_UmuKbn.ARI.eq(pKykSonotaTkyk.getInitsbjiyensitihsytkhukaumu())) {
                if (C_UmuKbn.ARI.eq(maruExistsFlg)) {
                    siboudai1hknkknsmrmsgcd = "12072";
                }
                else {
                    siboudai1kjnkngktuuktype = C_Tuukasyu.JPY;
                    siboudai1kjnkngk = pKykSonotaTkyk.getInitsbjiyenkasaiteihsygk();
                    siboudai1hknkknsmrmsgcd = "12074";
                }
            }
        }
        else {
            if (C_UmuKbn.ARI.eq(pKykSonotaTkyk.getInitsbjiyensitihsytkhukaumu())) {
                if (C_HknKknKbn.DAI1HKNKKN.eq(hknkknkbn)) {
                    if (C_UmuKbn.NONE.eq(maruExistsFlg)) {
                        siboudai1hknkknsmrmsgcd = "12078";
                        siboudai1kjnkngktuuktype = C_Tuukasyu.JPY;
                        siboudai1kjnkngk = pKykSonotaTkyk.getInitsbjiyenkasaiteihsygk();
                    }
                    else {
                        siboudai1hknkknsmrmsgcd = "12076";
                    }
                }
            }
        }

        if (pSksyoukenskskbn == SINKEIYAKUHOKENSYOUKEN) {
            if (C_UmuKbn.ARI.eq(pKykSonotaTkyk.getTargettkhkumu())) {
                if (pKykSonotaTkyk.getTargettkmokuhyouti() > 0) {
                    mkhyouyensysnikoumsgcdLst.add("13011");
                    mkhyouyensysnikougktype = C_Tuukasyu.JPY;
                    mkhyouyensysnikouwra = BizNumber.valueOf(pKykSonotaTkyk.getTargettkmokuhyouti());
                }
                else {
                    mkhyouyensysnikoumsgcdLst.add("13021");
                }
            }
        }
        else {
            if (C_UmuKbn.ARI.eq(pKykSonotaTkyk.getTargettkhkumu())) {

                mkhyouyensysnikoumsgcdLst.add("13011");
                mkhyouyensysnikougktype = C_Tuukasyu.JPY;

                if (hhknnenOutou <= 105) {
                    mkhyouyensysnikoumsgcdLst.add("13012");
                }

                if (pKykSonotaTkyk.getTargettkmokuhyouti() > 0) {
                    mkhyouyensysnikoumsgcdLst.add("13021");
                    mkhyouyensysnikouwra = BizNumber.valueOf(pKykSonotaTkyk.getTargettkmokuhyouti());
                }
                else {
                    mkhyouyensysnikoumsgcdLst.add("13022");
                }
            }
        }

        int mkhyouyensysnikoumsgcdCnt = mkhyouyensysnikoumsgcdLst.size();

        for (int i = 0; i < MKHYOUYENSYSNIKOUMSGCDMAXCNT - mkhyouyensysnikoumsgcdCnt; i++) {
            mkhyouyensysnikoumsgcdLst.add("");
        }

        if (pSksyoukenskskbn == SINKEIYAKUHOKENSYOUKEN) {

            hutanhiyustmmsgcdueLst.add("13071");

            if (C_UmuKbn.ARI.eq(pKykSonotaTkyk.getInitsbjiyensitihsytkhukaumu())) {

                hutanhiyustmmsgcdueLst.add("13081");

                hutanhiyustmmsgcdst01 = "13110";

                if (C_UmuKbn.ARI.eq(pKykSonotaTkyk.getYennykntkhkumu())) {
                    hutanhiyustmknsnhyuptn = "05";
                }
                else if (C_UmuKbn.ARI.eq(pKykSonotaTkyk.getGaikanykntkhkumu())) {
                    hutanhiyustmknsnhyuptn = "06";
                }
                else {
                    hutanhiyustmknsnhyuptn = "04";
                }
            }
            else {

                hutanhiyustmmsgcdst01 = "13100";

                if (C_UmuKbn.ARI.eq(pKykSonotaTkyk.getYennykntkhkumu())) {
                    hutanhiyustmknsnhyuptn = "02";
                }
                else if (C_UmuKbn.ARI.eq(pKykSonotaTkyk.getGaikanykntkhkumu())) {
                    hutanhiyustmknsnhyuptn = "03";
                }
                else {
                    hutanhiyustmknsnhyuptn = "01";
                }
            }

            if (C_UmuKbn.ARI.eq(pKykSonotaTkyk.getJyudkaigomeharaitkhukaumu())) {

                hutanhiyustmmsgcdueLst.add("13083");
            }
            hutanhiyustmmsgcdueLst.add("13084");
        }
        else {

            if (yendthnkymd == null) {

                hutanhiyustmmsgcdueLst.add("13087");

                if (C_UmuKbn.ARI.eq(pKykSonotaTkyk.getInitsbjiyensitihsytkhukaumu())) {

                    hutanhiyustmmsgcdueLst.add("13094");

                    hutanhiyustmmsgcdst01 = "13110";

                    if (C_UmuKbn.ARI.eq(pKykSonotaTkyk.getYennykntkhkumu())) {
                        hutanhiyustmknsnhyuptn = "05";
                    }
                    else if (C_UmuKbn.ARI.eq(pKykSonotaTkyk.getGaikanykntkhkumu())) {
                        hutanhiyustmknsnhyuptn = "06";
                    }
                    else {
                        hutanhiyustmknsnhyuptn = "04";
                    }
                }
                else {

                    hutanhiyustmmsgcdst01 = "13100";

                    if (C_UmuKbn.ARI.eq(pKykSonotaTkyk.getYennykntkhkumu())) {
                        hutanhiyustmknsnhyuptn = "02";
                    }
                    else if (C_UmuKbn.ARI.eq(pKykSonotaTkyk.getGaikanykntkhkumu())) {
                        hutanhiyustmknsnhyuptn = "03";
                    }
                    else {
                        hutanhiyustmknsnhyuptn = "01";
                    }
                }

                if (C_UmuKbn.ARI.eq(pKykSonotaTkyk.getJyudkaigomeharaitkhukaumu())) {

                    hutanhiyustmmsgcdueLst.add("13095");
                }
                hutanhiyustmmsgcdueLst.add("13096");
            }
            else {

                hutanhiyustmmsgcdueLst.add("13200");
            }
        }

        if (yendthnkymd == null) {

            if (C_UmuKbn.ARI.eq(pKykSonotaTkyk.getYennykntkhkumu())) {
                hutanhiyustmmsgcdst02 = "13122";
            }
            else if (C_UmuKbn.ARI.eq(pKykSonotaTkyk.getGaikanykntkhkumu())) {
                hutanhiyustmmsgcdst02 = "13124";
            }
            else {
                hutanhiyustmmsgcdst02 = "13120";
            }
        }

        int hutanhiyustmmsgcdueLsttCnt = hutanhiyustmmsgcdueLst.size();

        for (int i = 0; i < HUTANHIYUSTMMSGCDUEMAXCNT - hutanhiyustmmsgcdueLsttCnt; i++) {
            hutanhiyustmmsgcdueLst.add("");
        }

        if (pSksyoukenskskbn == SINKEIYAKUHOKENSYOUKEN) {

            fstphrkpkngkkeituuktype = pNyknJissekiRirekiLst.get(0).getRstuukasyu();

            fstphrkpkngkkei = pNyknJissekiRirekiLst.get(0).getRsgaku();

            if (C_DirectServiceMosKbn.ENTRY.eq(pKykKihon.getDrctservicemoskbn()) ||
                C_DirectServiceMosKbn.CHECK.eq(pKykKihon.getDrctservicemoskbn())) {
                if (C_UmuKbn.ARI.eq(pKykSonotaTkyk.getTargettkhkumu())) {
                    syouhnhutaimsgcdLst.add("13190");
                }
                else {
                    if (C_UmuKbn.ARI.eq(pKykSonotaTkyk.getInitsbjiyensitihsytkhukaumu())) {
                        syouhnhutaimsgcdLst.add("13200");
                    }
                    else {
                        if (C_UmuKbn.ARI.eq(pKykSonotaTkyk.getYennykntkhkumu())) {
                            syouhnhutaimsgcdLst.add("13210");
                        }
                        else {
                            syouhnhutaimsgcdLst.add("13220");
                        }
                    }
                }
            }

            if (C_UmuKbn.ARI.eq(pKykSonotaTkyk.getYennykntkhkumu())) {
                koujyosyoumeimsgcd1 = "15040";
            }
            else {
                if (C_UmuKbn.ARI.eq(pKykSonotaTkyk.getInitsbjiyensitihsytkhukaumu()) ||
                    C_UmuKbn.ARI.eq(pKykSonotaTkyk.getTargettkhkumu())) {
                    koujyosyoumeimsgcd1 = "15042";
                }

                if (C_UmuKbn.NONE.eq(pKykSonotaTkyk.getInitsbjiyensitihsytkhukaumu()) &&
                    C_UmuKbn.NONE.eq(pKykSonotaTkyk.getTargettkhkumu())) {
                    koujyosyoumeimsgcd1 = "15044";
                }
            }
        }

        int syouhnhutaimsgcdLstLstCnt = syouhnhutaimsgcdLst.size();

        for (int i = 0; i < SYOUHNHUTAIMSGCDLSTMAXCNT - syouhnhutaimsgcdLstLstCnt; i++) {
            syouhnhutaimsgcdLst.add("");
        }

        if (pSksyoukenskskbn == SINKEIYAKUHOKENSYOUKEN) {
            hhknnen = pSyuKykSyouhnLst.get(0).getHhknnen() + dai1hknkkn;

            if (C_UmuKbn.ARI.eq(pKykSonotaTkyk.getJyudkaigomeharaitkhukaumu())) {
                kaigomaehrtkykmsgcd1 = "13031";
                kaigomaehrtkykkyktuuka = kyktuukasyuNm;
                kaigomaehrjrugktype = kyktuukasyu;
                kaigomaehrtkykmsgcdst1 = "13051";
                if (pKykSonotaTkyk.getStdrsktkyhkumu().eq(C_UmuKbn.ARI)) {

                    if ((pSinkykjyoutai == KYKJI &&
                        (BizDateUtil.compareYmd(pKykKihon.getMosymd(), KIRIKAEMAE_YMD) == BizDateUtil.COMPARE_LESSER ||
                        BizDateUtil.compareYmd(pKykKihon.getMosymd(), KIRIKAEMAE_YMD) == BizDateUtil.COMPARE_EQUAL)) ||
                        (pSinkykjyoutai == SAISAKUSEIJI &&
                        (BizDateUtil.compareYmd(pKykKihon.getMosymd(), KIRIKAEMAE_YMD) == BizDateUtil.COMPARE_LESSER ||
                        BizDateUtil.compareYmd(pKykKihon.getMosymd(), KIRIKAEMAE_YMD) == BizDateUtil.COMPARE_EQUAL) &&
                        (BizDateUtil.compareYmd(pHokenSyouken.getTyouhyouymd(), KIRIKAEMAE_YMD) == BizDateUtil.COMPARE_LESSER ||
                        BizDateUtil.compareYmd(pHokenSyouken.getTyouhyouymd(), KIRIKAEMAE_YMD) == BizDateUtil.COMPARE_EQUAL))) {

                        kaigomaehrtkykstdmsgcd = "13060";
                    }
                    else {

                        kaigomaehrtkykstdmsgcd = "13061";
                    }
                }
            }
        }
        else {

            if (C_HknKknKbn.DAI1HKNKKN.eq(hknkknkbn)) {
                hhknnen = pSyuKykSyouhnLst.get(0).getHhknnen() + dai1hknkkn;
            }
            else {
                hhknnen = pSyuKykSyouhnLst.get(0).getHhknnen()
                    + BizDateUtil.calcDifference(calcKijyunYmd, pSyuKykSyouhnLst.get(0).getKykymd()).getYears();
            }

            if (C_UmuKbn.ARI.eq(pKykSonotaTkyk.getJyudkaigomeharaitkhukaumu())) {

                kaigomaehrtkykmsgcd1 = "13031";
                kaigomaehrtkykkyktuuka = kyktuukasyuNm;
                kaigomaehrtkykmsgcdst1 = "13051";

                if (hhknnen <= 105) {
                    kaigomaehrtkykmsgcd2 = "13033";
                    kaigomaehrjrugktype = kyktuukasyu;
                }
                else {
                    kaigomaehrtkykmsgcd2 = "13035";
                }

                if (pKykSonotaTkyk.getStdrsktkyhkumu().eq(C_UmuKbn.ARI)) {
                    kaigomaehrtkykstdmsgcd = "13061";
                }
            }
        }

        if (C_UmuKbn.ARI.eq(pKykSonotaTkyk.getJyudkaigomeharaitkhukaumu())) {
            if (hhknnen <= 65) {
                kaigomaehrsikuhhknnen = 65;
            }
            else if (hhknnen <= 70) {
                kaigomaehrsikuhhknnen = 70;
            }
            else if (hhknnen <= 75) {
                kaigomaehrsikuhhknnen = 75;
            }
            else if (hhknnen <= 80) {
                kaigomaehrsikuhhknnen = 80;
            }
            else if (hhknnen <= 85) {
                kaigomaehrsikuhhknnen = 85;
            }
            else if (hhknnen <= 90) {
                kaigomaehrsikuhhknnen = 90;
            }
            else if (hhknnen <= 95) {
                kaigomaehrsikuhhknnen = 95;
            }
            else if (hhknnen <= 100) {
                kaigomaehrsikuhhknnen = 100;
            }
            else if (hhknnen <= 105) {
                kaigomaehrsikuhhknnen = 105;
            }

            BizCurrency b = null;
            BizCurrency w = null;

            if (C_Tuukasyu.USD.eq(kyktuukasyu)) {
                b = BizCurrency.valueOf(10000, BizCurrencyTypes.DOLLAR);
                w = BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR);
            }
            else if (C_Tuukasyu.AUD.eq(kyktuukasyu)) {
                b = BizCurrency.valueOf(10000, BizCurrencyTypes.AU_DOLLAR);
                w = BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR);
            }

            for (; kaigomaehrsikuhhknnen <= 105;) {

                CalcJdkghkKngk calcJdkghkKngk = SWAKInjector.getInstance(CalcJdkghkKngk.class);

                calcJdkghkKngk.exec(C_JydkgmbHkKsnKbn.NENREISITEI, b, w,
                    yoteiriritu, null, null, null, kaigomaehrsikuhhknnen,
                    pHhknSya.getHhknsei());

                CalcJdkghkKngkBean calcJdkghkKngkBean = calcJdkghkKngk.getCalcJdkghkKngkBean();

                kaigomaehrsikuhhknnenLst.add(kaigomaehrsikuhhknnen);

                kaigomaehrstikknLst.add(calcJdkghkKngkBean.getWaribikiKikan());
                kaigomaehrjrugkLst.add(calcJdkghkKngkBean.getJdkghkKnGk());

                kaigomaehrsikuhhknnen = kaigomaehrsikuhhknnen + 5;
            }

            if (hhknnen <= 105) {
                kaigomaehruktgkumu = C_UmuKbn.ARI;
            }
            else {
                kaigomaehruktgkumu = C_UmuKbn.NONE;
            }
        }

        if (pSksyoukenskskbn == SINKEIYAKUHOKENSYOUKEN) {
            wtyuuijikoumsgcdLst.add("14022");
            witijibrptuktype = kyktuukasyu;
            witijibrp = hokenryou;
            wmsgcd1 = "14011";

            if (C_UmuKbn.ARI.eq(pKykSonotaTkyk.getYennykntkhkumu())) {
                wtyuuijikoumsgcdLst.add("14031");
                wyenhrkgktuktype = C_Tuukasyu.JPY;
                wyenhrkgk = pNyknJissekiRirekiLst.get(0).getRsgaku();
            }
            else {
                wtyuuijikoumsgcdLst.add("14041");
                wyenitijibrptuktype = C_Tuukasyu.JPY;
                wyenitijibrp = kijyungaku;
            }
            wtyuuijikoumsgcdLst.add("14051");
            wtyuuijikoumsgcdLst.add("14061");

            if (C_UmuKbn.ARI.eq(pKykSonotaTkyk.getTargettkhkumu())) {
                if (pKykSonotaTkyk.getTargettkmokuhyouti() > 0) {
                    wtyuuijikoumsgcdLst.add("14063");
                }
                else {
                    wtyuuijikoumsgcdLst.add("14070");
                }
            }
        }
        else {

            if (yendthnkymd == null) {

                if (hhknnenOutou <= 105) {

                    wmsgcd1 = "14010";

                    wtyuuijikoumsgcdLst.add("14023");

                    if (C_UmuKbn.NONE.eq(pGengakuExistsCheck)) {

                        wtyuuijikoumsgcdLst.add("14035");
                        witijibrptuktype = kyktuukasyu;
                        witijibrp = hokenryou;

                        if (C_UmuKbn.ARI.eq(pKykSonotaTkyk.getYennykntkhkumu())) {

                            wtyuuijikoumsgcdLst.add("14036");
                            wyenhrkgktuktype = C_Tuukasyu.JPY;
                            wyenhrkgk = pNyknJissekiRirekiLst.get(0).getRsgaku();

                        }
                        else {

                            wyenitijibrptuktype = C_Tuukasyu.JPY;
                            wyenitijibrp = kijyungaku;
                            wtyuuijikoumsgcdLst.add("14037");
                        }
                    }

                    if (keikanensuu < pSyouhnZokusei.getMvatekikkn()) {

                        wtyuuijikoumsgcdLst.add("14045");
                        wtyuuijikoumsgcdLst.add("14042");
                        wtyuuijikoumsgcdLst.add("14061");
                        wmsgcd2 = "14014";
                    }

                    if (C_UmuKbn.ARI.eq(pKykSonotaTkyk.getTargettkhkumu())) {
                        if (pKykSonotaTkyk.getTargettkmokuhyouti() > 0) {
                            wtyuuijikoumsgcdLst.add("14065");
                        }
                        else {
                            wtyuuijikoumsgcdLst.add("14062");
                        }
                    }
                }
            }
            else {
                wmsgcd1 = "14021";
                wmsgcdst = "14082";
            }
        }

        int wtyuuijikoumsgcdLstCnt = wtyuuijikoumsgcdLst.size();

        for (int i = 0; i < WTYUUIJIKOUMSGCDMAXCNT - wtyuuijikoumsgcdLstCnt; i++) {
            wtyuuijikoumsgcdLst.add("");
        }

        if (hyoujiranleftmsgcdLst.size() > 0) {
            pHokenSyouken.setHyoujiranhidarimsgcd1(hyoujiranleftmsgcdLst.get(0));
        }

        if (hyoujiranleftmsgcdLst.size() > 1) {
            pHokenSyouken.setHyoujiranhidarimsgcd2(hyoujiranleftmsgcdLst.get(1));
        }

        if (hyoujiranleftmsgcdLst.size() > 2) {
            pHokenSyouken.setHyoujiranhidarimsgcd3(hyoujiranleftmsgcdLst.get(2));
        }

        if (hyoujiranleftmsgcdLst.size() > 3) {
            pHokenSyouken.setHyoujiranhidarimsgcd4(hyoujiranleftmsgcdLst.get(3));
        }

        if (hyoujiranleftmsgcdLst.size() > 4) {
            pHokenSyouken.setHyoujiranhidarimsgcd5(hyoujiranleftmsgcdLst.get(4));
        }

        if (hyoujiranleftmsgcdLst.size() > 5) {
            pHokenSyouken.setHyoujiranhidarimsgcd6(hyoujiranleftmsgcdLst.get(5));
        }

        if (hyoujiranleftmsgcdLst.size() > 6) {
            pHokenSyouken.setHyoujiranhidarimsgcd7(hyoujiranleftmsgcdLst.get(6));
        }

        if (hyoujiranrightmsgcdLst.size() > 0) {
            pHokenSyouken.setHyoujiranmigiimsgcd1(hyoujiranrightmsgcdLst.get(0));
        }

        if (hyoujiranrightmsgcdLst.size() > 1) {
            pHokenSyouken.setHyoujiranmigiimsgcd2(hyoujiranrightmsgcdLst.get(1));
        }

        pHokenSyouken.setHyoujiransknnkaisiymd(sknnkaisiymd);

        pHokenSyouken.setHyoujiranyoteiriritu(yoteiriritu);

        pHokenSyouken.setSonotanyrantumitateriritu(tumitateriritu);

        pHokenSyouken.setSonotanyranytirrt(yoteiriritu);

        pHokenSyouken.setHyoujiransjkkktusirrt(hyoujiransjkkktusirrt);

        pHokenSyouken.setPmsgcd1(pmsgcd1);

        pHokenSyouken.setPmsgcd2(pmsgcd2);

        pHokenSyouken.setPtuukatype(ptuukasyu);

        pHokenSyouken.setHokenryou(hokenryou);

        pHokenSyouken.setPtuuka(ptuukasyuNm);

        pHokenSyouken.setPtokuyakumsgcd(ptokuyakumsgcd);

        pHokenSyouken.setPhrkktuki("＊");

        pHokenSyouken.setHrkhouhoumsgkbn("00");

        pHokenSyouken.setSyukyktkykmsgkbn1(syukyktkykmsgkbn1);

        pHokenSyouken.setSyukyktkykmsgkbn2(syukyktkykmsgkbn2);

        pHokenSyouken.setSyukyktkykmsgkbn3(syukyktkykmsgkbn3);

        pHokenSyouken.setSyukyktkyksmsgkbn1(syukyktkyksmsgkbn1);

        pHokenSyouken.setSyukyktkyksmsgkbn2(syukyktkyksmsgkbn2);

        pHokenSyouken.setSyukyktkyksmsgkbn3(syukyktkyksmsgkbn3);

        pHokenSyouken.setSyukyktkykhknkknmsgkbn1(syukyktkykhknkknmsgkbn1);

        pHokenSyouken.setSyukyktkykhknkknmsgkbn2(syukyktkykhknkknmsgkbn2);

        pHokenSyouken.setSyukyktkykhknkknmsgkbn3(syukyktkykhknkknmsgkbn3);

        pHokenSyouken.setSyukyktkykstuukatype1(syukyktkykstuukatype1);

        pHokenSyouken.setSyukyktkykstuukatype2(syukyktkykstuukatype2);

        pHokenSyouken.setSyukyktkykstuukatype3(syukyktkykstuukatype3);

        pHokenSyouken.setSyukyktkykhknkngk1(syukyktkykhknkngk1);

        pHokenSyouken.setSyukyktkykhknkngk2(syukyktkykhknkngk2);

        pHokenSyouken.setSyukyktkykhknkngk3(syukyktkykhknkngk3);

        pHokenSyouken.setSyukyktkykdai1hknkkn1(dai1hknkkn);

        pHokenSyouken.setSyukyktkykdai2hknkkn2(dai2hknkkn);

        pHokenSyouken.setSyutkdai1hknkknymdto1(syutkdai1hknkknymdto1);

        pHokenSyouken.setSyutkdai2hknkknymdto1(syutkdai2hknkknymdto1);

        pHokenSyouken.setSyutkdai2hknkknymdto2(syutkdai2hknkknymdto2);

        pHokenSyouken.setKykniyustmsgcd1(kykniyustmsgcd1);

        pHokenSyouken.setKykniyustmsgcd2(kykniyustmsgcd2);

        pHokenSyouken.setKykniyustmsgcd3(kykniyustmsgcd3);

        pHokenSyouken.setKykniyustmsgcd4(kykniyustmsgcd4);

        pHokenSyouken.setKykniyustitjbrptuuktype(kykniyustitjbrptuuktype);

        pHokenSyouken.setKykniyustitjbrp(kykniyustitjbrp);

        pHokenSyouken.setStnaiyouranmsgcd1(stNaiyouranMsgCdList.get(0));

        pHokenSyouken.setStnaiyouranmsgcd2(stNaiyouranMsgCdList.get(1));

        pHokenSyouken.setStnaiyouranmsgcd3(stNaiyouranMsgCdList.get(2));

        pHokenSyouken.setStnaiyouranmsgcd4(stNaiyouranMsgCdList.get(3));

        pHokenSyouken.setStnaiyouranmsgcd5(stNaiyouranMsgCdList.get(4));

        pHokenSyouken.setStnaiyouranmsgcd6(stNaiyouranMsgCdList.get(5));

        pHokenSyouken.setStnaiyouranmsgcd7(stNaiyouranMsgCdList.get(6));

        pHokenSyouken.setStnaiyouranmsgcd8(stNaiyouranMsgCdList.get(7));

        pHokenSyouken.setStnaiyouranmsgcd9(stNaiyouranMsgCdList.get(8));

        pHokenSyouken.setStnaiyouranmsgcd10(stNaiyouranMsgCdList.get(9));

        pHokenSyouken.setStnaiyouranmsgcd11(stNaiyouranMsgCdList.get(10));

        pHokenSyouken.setStnaiyouranmsgcd12(stNaiyouranMsgCdList.get(11));

        pHokenSyouken.setStnaiyouranmsgcd13(stNaiyouranMsgCdList.get(12));

        pHokenSyouken.setStnaiyouranmsgcd14(stNaiyouranMsgCdList.get(13));

        pHokenSyouken.setStnaiyouranmsgcd15(stNaiyouranMsgCdList.get(14));

        pHokenSyouken.setStnaiyouranmsgcd16(stNaiyouranMsgCdList.get(15));

        pHokenSyouken.setStnaiyouranmsgcd17(stNaiyouranMsgCdList.get(16));

        pHokenSyouken.setStnaiyouranmsgcd18(stNaiyouranMsgCdList.get(17));

        pHokenSyouken.setStnaiyouranmsgcd19(stNaiyouranMsgCdList.get(18));

        pHokenSyouken.setStnaiyouranmsgcd20(stNaiyouranMsgCdList.get(19));

        if (pSksyoukenskskbn != SINKEIYAKUHOKENSYOUKEN &&
            yendthnkymd != null) {

            pHokenSyouken.setHosyounymsgcd("99001");
        }

        pHokenSyouken.setSiboumidasimsgcd(siboumidasimsgcd1);

        pHokenSyouken.setSiboumidasimsgcd2(siboumidasimsgcd2);

        pHokenSyouken.setSiboudai1hknkknmsgcd1(siboudai1hknkknmsgcdLst.get(0));

        pHokenSyouken.setSiboudai1hknkknmsgcd2(siboudai1hknkknmsgcdLst.get(1));

        pHokenSyouken.setSiboudai1hknkknigimsgcd(siboudai1hknkknigimsgcd);

        pHokenSyouken.setSiboudai1hknkknigimsgcd2(siboudai1hknkknigimsgcd2);

        pHokenSyouken.setSiboudai1hknkknhrsmsgcd(siboudai1hknkknhrsmsgcd);

        pHokenSyouken.setSiboudai1hknkknhrsmsgcd2(siboudai1hknkknhrsmsgcd2);

        pHokenSyouken.setSiboudai1hknkknsmrmsgcd(siboudai1hknkknsmrmsgcd);

        pHokenSyouken.setSiboudai2hknkknmsgcd1(siboudai2hknkknmsgcd1);

        pHokenSyouken.setSiboudai2hknkknmsgcd2(siboudai2hknkknmsgcd2);

        pHokenSyouken.setSiboudai2hknkknsmsgcd(siboudai2hknkknsmsgcd);

        pHokenSyouken.setSiboudai2hknkknsmsgcd2(siboudai2hknkknsmsgcd2);

        if (pSksyoukenskskbn == SINKEIYAKUHOKENSYOUKEN) {
            pHokenSyouken.setSiboudai1hknkkn(dai1hknkkn);
            pHokenSyouken.setSiboudai2hknkkn(dai2hknkkn);
        }

        pHokenSyouken.setSiboudai1hknkknymdto(dai1hknkknEndYmd);

        pHokenSyouken.setSibouitjbrpyentuuktype(sibouitjbrpyentuuktype);

        pHokenSyouken.setSibouitjbrpyentuukgk(sibouitjbrpyentuukgk);

        pHokenSyouken.setSiboudai1kjnkngktuuktype(siboudai1kjnkngktuuktype);

        pHokenSyouken.setSiboudai1kjnkngk(siboudai1kjnkngk);

        pHokenSyouken.setSiboudai2kjnkngktuuktype(siboudai2kjnkngktuuktype);

        pHokenSyouken.setSiboudai2kjnkngk(siboudai2kjnkngk);

        pHokenSyouken.setDai1skwsrateyendaka(skwsrateyendaka);

        pHokenSyouken.setDai1skwsrateyenkijyun(skwsrateyenkijyun);

        pHokenSyouken.setDai1skwsrateyenyasu(skwsrateyenyasu);

        if (dai1skeikanensuuLst.size() > 0) {
            pHokenSyouken.setDai1skeikanensuu01(dai1skeikanensuuLst.get(0));
        }

        if (dai1skeikanensuuLst.size() > 1) {
            pHokenSyouken.setDai1skeikanensuu02(dai1skeikanensuuLst.get(1));
        }

        if (dai1skeikanensuuLst.size() > 2) {
            pHokenSyouken.setDai1skeikanensuu03(dai1skeikanensuuLst.get(2));
        }

        if (dai1skeikanensuuLst.size() > 3) {
            pHokenSyouken.setDai1skeikanensuu04(dai1skeikanensuuLst.get(3));
        }

        if (dai1skeikanensuuLst.size() > 4) {
            pHokenSyouken.setDai1skeikanensuu05(dai1skeikanensuuLst.get(4));
        }

        if (dai1skeikanensuuLst.size() > 5) {
            pHokenSyouken.setDai1skeikanensuu06(dai1skeikanensuuLst.get(5));
        }

        if (dai1skeikanensuuLst.size() > 6) {
            pHokenSyouken.setDai1skeikanensuu07(dai1skeikanensuuLst.get(6));
        }

        if (dai1skeikanensuuLst.size() > 7) {
            pHokenSyouken.setDai1skeikanensuu08(dai1skeikanensuuLst.get(7));
        }

        if (dai1skeikanensuuLst.size() > 8) {
            pHokenSyouken.setDai1skeikanensuu09(dai1skeikanensuuLst.get(8));
        }

        if (dai1skeikanensuuLst.size() > 9) {
            pHokenSyouken.setDai1skeikanensuu10(dai1skeikanensuuLst.get(9));
        }

        if (dai1sibousnenoutouymd.size() > 0) {
            pHokenSyouken.setDai1sibousnenoutouymd01(dai1sibousnenoutouymd.get(0));
        }

        if (dai1sibousnenoutouymd.size() > 1) {
            pHokenSyouken.setDai1sibousnenoutouymd02(dai1sibousnenoutouymd.get(1));
        }

        if (dai1sibousnenoutouymd.size() > 2) {
            pHokenSyouken.setDai1sibousnenoutouymd03(dai1sibousnenoutouymd.get(2));
        }

        if (dai1sibousnenoutouymd.size() > 3) {
            pHokenSyouken.setDai1sibousnenoutouymd04(dai1sibousnenoutouymd.get(3));
        }

        if (dai1sibousnenoutouymd.size() > 4) {
            pHokenSyouken.setDai1sibousnenoutouymd05(dai1sibousnenoutouymd.get(4));
        }

        if (dai1sibousnenoutouymd.size() > 5) {
            pHokenSyouken.setDai1sibousnenoutouymd06(dai1sibousnenoutouymd.get(5));
        }

        if (dai1sibousnenoutouymd.size() > 6) {
            pHokenSyouken.setDai1sibousnenoutouymd07(dai1sibousnenoutouymd.get(6));
        }

        if (dai1sibousnenoutouymd.size() > 7) {
            pHokenSyouken.setDai1sibousnenoutouymd08(dai1sibousnenoutouymd.get(7));
        }

        if (dai1sibousnenoutouymd.size() > 8) {
            pHokenSyouken.setDai1sibousnenoutouymd09(dai1sibousnenoutouymd.get(8));
        }

        if (dai1sibousnenoutouymd.size() > 9) {
            pHokenSyouken.setDai1sibousnenoutouymd10(dai1sibousnenoutouymd.get(9));
        }

        if (dai1stuuktypeLst.size() > 0) {
            pHokenSyouken.setDai1stuuktype01(dai1stuuktypeLst.get(0));
        }

        if (dai1stuuktypeLst.size() > 1) {
            pHokenSyouken.setDai1stuuktype02(dai1stuuktypeLst.get(1));
        }

        if (dai1stuuktypeLst.size() > 2) {
            pHokenSyouken.setDai1stuuktype03(dai1stuuktypeLst.get(2));
        }

        if (dai1stuuktypeLst.size() > 3) {
            pHokenSyouken.setDai1stuuktype04(dai1stuuktypeLst.get(3));
        }

        if (dai1stuuktypeLst.size() > 4) {
            pHokenSyouken.setDai1stuuktype05(dai1stuuktypeLst.get(4));
        }

        if (dai1stuuktypeLst.size() > 5) {
            pHokenSyouken.setDai1stuuktype06(dai1stuuktypeLst.get(5));
        }

        if (dai1stuuktypeLst.size() > 6) {
            pHokenSyouken.setDai1stuuktype07(dai1stuuktypeLst.get(6));
        }

        if (dai1stuuktypeLst.size() > 7) {
            pHokenSyouken.setDai1stuuktype08(dai1stuuktypeLst.get(7));
        }

        if (dai1stuuktypeLst.size() > 8) {
            pHokenSyouken.setDai1stuuktype09(dai1stuuktypeLst.get(8));
        }

        if (dai1stuuktypeLst.size() > 9) {
            pHokenSyouken.setDai1stuuktype10(dai1stuuktypeLst.get(9));
        }

        if (dai1sLst.size() > 0) {
            pHokenSyouken.setDai1s01(dai1sLst.get(0));
        }

        if (dai1sLst.size() > 1) {
            pHokenSyouken.setDai1s02(dai1sLst.get(1));
        }

        if (dai1sLst.size() > 2) {
            pHokenSyouken.setDai1s03(dai1sLst.get(2));
        }

        if (dai1sLst.size() > 3) {
            pHokenSyouken.setDai1s04(dai1sLst.get(3));
        }

        if (dai1sLst.size() > 4) {
            pHokenSyouken.setDai1s05(dai1sLst.get(4));
        }

        if (dai1sLst.size() > 5) {
            pHokenSyouken.setDai1s06(dai1sLst.get(5));
        }

        if (dai1sLst.size() > 6) {
            pHokenSyouken.setDai1s07(dai1sLst.get(6));
        }

        if (dai1sLst.size() > 7) {
            pHokenSyouken.setDai1s08(dai1sLst.get(7));
        }

        if (dai1sLst.size() > 8) {
            pHokenSyouken.setDai1s09(dai1sLst.get(8));
        }

        if (dai1sLst.size() > 9) {
            pHokenSyouken.setDai1s10(dai1sLst.get(9));
        }

        if (dai1syenyendakaumuLst.size() > 0) {
            pHokenSyouken.setDai1syenyendakaumu01(dai1syenyendakaumuLst.get(0).getValue());
        }

        if (dai1syenyendakaumuLst.size() > 1) {
            pHokenSyouken.setDai1syenyendakaumu02(dai1syenyendakaumuLst.get(1).getValue());
        }

        if (dai1syenyendakaumuLst.size() > 2) {
            pHokenSyouken.setDai1syenyendakaumu03(dai1syenyendakaumuLst.get(2).getValue());
        }

        if (dai1syenyendakaumuLst.size() > 3) {
            pHokenSyouken.setDai1syenyendakaumu04(dai1syenyendakaumuLst.get(3).getValue());
        }

        if (dai1syenyendakaumuLst.size() > 4) {
            pHokenSyouken.setDai1syenyendakaumu05(dai1syenyendakaumuLst.get(4).getValue());
        }

        if (dai1syenyendakaumuLst.size() > 5) {
            pHokenSyouken.setDai1syenyendakaumu06(dai1syenyendakaumuLst.get(5).getValue());
        }

        if (dai1syenyendakaumuLst.size() > 6) {
            pHokenSyouken.setDai1syenyendakaumu07(dai1syenyendakaumuLst.get(6).getValue());
        }

        if (dai1syenyendakaumuLst.size() > 7) {
            pHokenSyouken.setDai1syenyendakaumu08(dai1syenyendakaumuLst.get(7).getValue());
        }

        if (dai1syenyendakaumuLst.size() > 8) {
            pHokenSyouken.setDai1syenyendakaumu09(dai1syenyendakaumuLst.get(8).getValue());
        }

        if (dai1syenyendakaumuLst.size() > 9) {
            pHokenSyouken.setDai1syenyendakaumu10(dai1syenyendakaumuLst.get(9).getValue());
        }

        if (dai1syenyenkijyunumuLst.size() > 0) {
            pHokenSyouken.setDai1syenyenkijyunumu01(dai1syenyenkijyunumuLst.get(0).getValue());
        }

        if (dai1syenyenkijyunumuLst.size() > 1) {
            pHokenSyouken.setDai1syenyenkijyunumu02(dai1syenyenkijyunumuLst.get(1).getValue());
        }

        if (dai1syenyenkijyunumuLst.size() > 2) {
            pHokenSyouken.setDai1syenyenkijyunumu03(dai1syenyenkijyunumuLst.get(2).getValue());
        }

        if (dai1syenyenkijyunumuLst.size() > 3) {
            pHokenSyouken.setDai1syenyenkijyunumu04(dai1syenyenkijyunumuLst.get(3).getValue());
        }

        if (dai1syenyenkijyunumuLst.size() > 4) {
            pHokenSyouken.setDai1syenyenkijyunumu05(dai1syenyenkijyunumuLst.get(4).getValue());
        }

        if (dai1syenyenkijyunumuLst.size() > 5) {
            pHokenSyouken.setDai1syenyenkijyunumu06(dai1syenyenkijyunumuLst.get(5).getValue());
        }

        if (dai1syenyenkijyunumuLst.size() > 6) {
            pHokenSyouken.setDai1syenyenkijyunumu07(dai1syenyenkijyunumuLst.get(6).getValue());
        }

        if (dai1syenyenkijyunumuLst.size() > 7) {
            pHokenSyouken.setDai1syenyenkijyunumu08(dai1syenyenkijyunumuLst.get(7).getValue());
        }

        if (dai1syenyenkijyunumuLst.size() > 8) {
            pHokenSyouken.setDai1syenyenkijyunumu09(dai1syenyenkijyunumuLst.get(8).getValue());
        }

        if (dai1syenyenkijyunumuLst.size() > 9) {
            pHokenSyouken.setDai1syenyenkijyunumu10(dai1syenyenkijyunumuLst.get(9).getValue());
        }

        if (dai1syenyenyasuumuLst.size() > 0) {
            pHokenSyouken.setDai1syenyenyasuumu01(dai1syenyenyasuumuLst.get(0).getValue());
        }

        if (dai1syenyenyasuumuLst.size() > 1) {
            pHokenSyouken.setDai1syenyenyasuumu02(dai1syenyenyasuumuLst.get(1).getValue());
        }

        if (dai1syenyenyasuumuLst.size() > 2) {
            pHokenSyouken.setDai1syenyenyasuumu03(dai1syenyenyasuumuLst.get(2).getValue());
        }

        if (dai1syenyenyasuumuLst.size() > 3) {
            pHokenSyouken.setDai1syenyenyasuumu04(dai1syenyenyasuumuLst.get(3).getValue());
        }

        if (dai1syenyenyasuumuLst.size() > 4) {
            pHokenSyouken.setDai1syenyenyasuumu05(dai1syenyenyasuumuLst.get(4).getValue());
        }

        if (dai1syenyenyasuumuLst.size() > 5) {
            pHokenSyouken.setDai1syenyenyasuumu06(dai1syenyenyasuumuLst.get(5).getValue());
        }

        if (dai1syenyenyasuumuLst.size() > 6) {
            pHokenSyouken.setDai1syenyenyasuumu07(dai1syenyenyasuumuLst.get(6).getValue());
        }

        if (dai1syenyenyasuumuLst.size() > 7) {
            pHokenSyouken.setDai1syenyenyasuumu08(dai1syenyenyasuumuLst.get(7).getValue());
        }

        if (dai1syenyenyasuumuLst.size() > 8) {
            pHokenSyouken.setDai1syenyenyasuumu09(dai1syenyenyasuumuLst.get(8).getValue());
        }

        if (dai1syenyenyasuumuLst.size() > 9) {
            pHokenSyouken.setDai1syenyenyasuumu10(dai1syenyenyasuumuLst.get(9).getValue());
        }

        if (dai1syentuuktypeLst.size() > 0) {
            pHokenSyouken.setDai1syentuuktype01(dai1syentuuktypeLst.get(0));
        }

        if (dai1syentuuktypeLst.size() > 1) {
            pHokenSyouken.setDai1syentuuktype02(dai1syentuuktypeLst.get(1));
        }

        if (dai1syentuuktypeLst.size() > 2) {
            pHokenSyouken.setDai1syentuuktype03(dai1syentuuktypeLst.get(2));
        }

        if (dai1syentuuktypeLst.size() > 3) {
            pHokenSyouken.setDai1syentuuktype04(dai1syentuuktypeLst.get(3));
        }

        if (dai1syentuuktypeLst.size() > 4) {
            pHokenSyouken.setDai1syentuuktype05(dai1syentuuktypeLst.get(4));
        }

        if (dai1syentuuktypeLst.size() > 5) {
            pHokenSyouken.setDai1syentuuktype06(dai1syentuuktypeLst.get(5));
        }

        if (dai1syentuuktypeLst.size() > 6) {
            pHokenSyouken.setDai1syentuuktype07(dai1syentuuktypeLst.get(6));
        }

        if (dai1syentuuktypeLst.size() > 7) {
            pHokenSyouken.setDai1syentuuktype08(dai1syentuuktypeLst.get(7));
        }

        if (dai1syentuuktypeLst.size() > 8) {
            pHokenSyouken.setDai1syentuuktype09(dai1syentuuktypeLst.get(8));
        }

        if (dai1syentuuktypeLst.size() > 9) {
            pHokenSyouken.setDai1syentuuktype10(dai1syentuuktypeLst.get(9));
        }

        if (dai1syenyendakaLst.size() > 0) {

            pHokenSyouken.setDai1syenyendaka01(dai1syenyendakaLst.get(0));
        }

        if (dai1syenyendakaLst.size() > 1) {
            pHokenSyouken.setDai1syenyendaka02(dai1syenyendakaLst.get(1));
        }

        if (dai1syenyendakaLst.size() > 2) {
            pHokenSyouken.setDai1syenyendaka03(dai1syenyendakaLst.get(2));
        }

        if (dai1syenyendakaLst.size() > 3) {
            pHokenSyouken.setDai1syenyendaka04(dai1syenyendakaLst.get(3));
        }

        if (dai1syenyendakaLst.size() > 4) {
            pHokenSyouken.setDai1syenyendaka05(dai1syenyendakaLst.get(4));
        }

        if (dai1syenyendakaLst.size() > 5) {
            pHokenSyouken.setDai1syenyendaka06(dai1syenyendakaLst.get(5));
        }

        if (dai1syenyendakaLst.size() > 6) {
            pHokenSyouken.setDai1syenyendaka07(dai1syenyendakaLst.get(6));
        }

        if (dai1syenyendakaLst.size() > 7) {
            pHokenSyouken.setDai1syenyendaka08(dai1syenyendakaLst.get(7));
        }

        if (dai1syenyendakaLst.size() > 8) {
            pHokenSyouken.setDai1syenyendaka09(dai1syenyendakaLst.get(8));
        }

        if (dai1syenyendakaLst.size() > 9) {
            pHokenSyouken.setDai1syenyendaka10(dai1syenyendakaLst.get(9));
        }

        if (dai1syenyenkijyunLst.size() > 0) {
            pHokenSyouken.setDai1syenyenkijyun01(dai1syenyenkijyunLst.get(0));
        }

        if (dai1syenyenkijyunLst.size() > 1) {
            pHokenSyouken.setDai1syenyenkijyun02(dai1syenyenkijyunLst.get(1));
        }

        if (dai1syenyenkijyunLst.size() > 2) {
            pHokenSyouken.setDai1syenyenkijyun03(dai1syenyenkijyunLst.get(2));
        }

        if (dai1syenyenkijyunLst.size() > 3) {
            pHokenSyouken.setDai1syenyenkijyun04(dai1syenyenkijyunLst.get(3));
        }

        if (dai1syenyenkijyunLst.size() > 4) {
            pHokenSyouken.setDai1syenyenkijyun05(dai1syenyenkijyunLst.get(4));
        }

        if (dai1syenyenkijyunLst.size() > 5) {
            pHokenSyouken.setDai1syenyenkijyun06(dai1syenyenkijyunLst.get(5));
        }

        if (dai1syenyenkijyunLst.size() > 6) {
            pHokenSyouken.setDai1syenyenkijyun07(dai1syenyenkijyunLst.get(6));
        }

        if (dai1syenyenkijyunLst.size() > 7) {
            pHokenSyouken.setDai1syenyenkijyun08(dai1syenyenkijyunLst.get(7));
        }

        if (dai1syenyenkijyunLst.size() > 8) {
            pHokenSyouken.setDai1syenyenkijyun09(dai1syenyenkijyunLst.get(8));
        }

        if (dai1syenyenkijyunLst.size() > 9) {
            pHokenSyouken.setDai1syenyenkijyun10(dai1syenyenkijyunLst.get(9));
        }

        if (dai1syenyenyasuLst.size() > 0) {
            pHokenSyouken.setDai1syenyenyasu01(dai1syenyenyasuLst.get(0));
        }

        if (dai1syenyenyasuLst.size() > 1) {
            pHokenSyouken.setDai1syenyenyasu02(dai1syenyenyasuLst.get(1));
        }

        if (dai1syenyenyasuLst.size() > 2) {
            pHokenSyouken.setDai1syenyenyasu03(dai1syenyenyasuLst.get(2));
        }

        if (dai1syenyenyasuLst.size() > 3) {
            pHokenSyouken.setDai1syenyenyasu04(dai1syenyenyasuLst.get(3));
        }

        if (dai1syenyenyasuLst.size() > 4) {
            pHokenSyouken.setDai1syenyenyasu05(dai1syenyenyasuLst.get(4));
        }

        if (dai1syenyenyasuLst.size() > 5) {
            pHokenSyouken.setDai1syenyenyasu06(dai1syenyenyasuLst.get(5));
        }

        if (dai1syenyenyasuLst.size() > 6) {
            pHokenSyouken.setDai1syenyenyasu07(dai1syenyenyasuLst.get(6));
        }

        if (dai1syenyenyasuLst.size() > 7) {
            pHokenSyouken.setDai1syenyenyasu08(dai1syenyenyasuLst.get(7));
        }

        if (dai1syenyenyasuLst.size() > 8) {
            pHokenSyouken.setDai1syenyenyasu09(dai1syenyenyasuLst.get(8));
        }

        if (dai1syenyenyasuLst.size() > 9) {
            pHokenSyouken.setDai1syenyenyasu10(dai1syenyenyasuLst.get(9));
        }

        pHokenSyouken.setDai1stuuktypehuryo(dai1stuuktypehuryo);

        pHokenSyouken.setDai1shuryo(dai1shuryo);

        pHokenSyouken.setDai1syenyendakaumuhuryo(dai1syenyendakaumuhuryo);

        pHokenSyouken.setDai1syenyenkjnumuhuryo(dai1syenyenkjnumuhuryo);

        pHokenSyouken.setDai1syenyenyasuumuhuryo(dai1syenyenyasuumuhuryo);

        pHokenSyouken.setDai1syentuuktypehuryo(dai1syentuuktypehuryo);

        pHokenSyouken.setDai1syenyendakahuryo(dai1syenyendakahuryo);

        pHokenSyouken.setDai1syenyenkijyunhuryo(dai1syenyenkijyunhuryo);

        pHokenSyouken.setDai1syenyenyasuhuryo(dai1syenyenyasuhuryo);

        pHokenSyouken.setInitsbjiyenkasaiteihsygk(pKykSonotaTkyk.getInitsbjiyenkasaiteihsygk());

        pHokenSyouken.setDai2stuuktype(dai2stuuktype);

        pHokenSyouken.setDai2s(dai2s);

        pHokenSyouken.setDai2syentuuktype(dai2syentuuktype);

        pHokenSyouken.setDai2syenyendaka(dai2syenyendaka);

        pHokenSyouken.setDai2syenyenkijyun(dai2syenyenkijyun);

        pHokenSyouken.setDai2syenyenyasu(dai2syenyenyasu);

        pHokenSyouken.setMkhyouyensysnikoumsgcd(mkhyouyensysnikoumsgcdLst.get(0));

        pHokenSyouken.setMkhyouyensysnikoumsgcd2(mkhyouyensysnikoumsgcdLst.get(1));

        pHokenSyouken.setMkhyouyensysnikoumsgcd3(mkhyouyensysnikoumsgcdLst.get(2));

        pHokenSyouken.setMkhyouyensysnikougktype(mkhyouyensysnikougktype);

        if (C_UmuKbn.ARI.eq(pKykSonotaTkyk.getTargettkhkumu())) {
            if (pKykSonotaTkyk.getTargettkmokuhyouti() > 0) {
                pHokenSyouken.setMkhyouyensysnikougk(pKykSonotaTkyk.getTargettkykkijyungk());
            }
        }

        pHokenSyouken.setMkhyouyensysnikouwra(mkhyouyensysnikouwra);

        pHokenSyouken.setKaigomaehrtkykmsgcd1(kaigomaehrtkykmsgcd1);

        pHokenSyouken.setKaigomaehrtkykmsgcd2(kaigomaehrtkykmsgcd2);

        pHokenSyouken.setKaigomaehrtkykmsgcdst1(kaigomaehrtkykmsgcdst1);

        pHokenSyouken.setKaigomaehruktgkumu(kaigomaehruktgkumu.getValue());

        pHokenSyouken.setKaigomaehrtkykkyktuuka(kaigomaehrtkykkyktuuka);

        pHokenSyouken.setKaigomaehrtkykstdmsgcd(kaigomaehrtkykstdmsgcd);

        pHokenSyouken.setKaigomaehrjrugktype(kaigomaehrjrugktype);

        if (kaigomaehrsikuhhknnenLst.size() > 0) {
            pHokenSyouken.setKaigomaehrsikuhhknnen01(kaigomaehrsikuhhknnenLst.get(0));
        }

        if (kaigomaehrsikuhhknnenLst.size() > 1) {
            pHokenSyouken.setKaigomaehrsikuhhknnen02(kaigomaehrsikuhhknnenLst.get(1));
        }

        if (kaigomaehrsikuhhknnenLst.size() > 2) {
            pHokenSyouken.setKaigomaehrsikuhhknnen03(kaigomaehrsikuhhknnenLst.get(2));
        }
        if (kaigomaehrsikuhhknnenLst.size() > 3) {
            pHokenSyouken.setKaigomaehrsikuhhknnen04(kaigomaehrsikuhhknnenLst.get(3));
        }

        if (kaigomaehrsikuhhknnenLst.size() > 4) {
            pHokenSyouken.setKaigomaehrsikuhhknnen05(kaigomaehrsikuhhknnenLst.get(4));
        }

        if (kaigomaehrsikuhhknnenLst.size() > 5) {
            pHokenSyouken.setKaigomaehrsikuhhknnen06(kaigomaehrsikuhhknnenLst.get(5));
        }

        if (kaigomaehrsikuhhknnenLst.size() > 6) {
            pHokenSyouken.setKaigomaehrsikuhhknnen07(kaigomaehrsikuhhknnenLst.get(6));
        }

        if (kaigomaehrsikuhhknnenLst.size() > 7) {
            pHokenSyouken.setKaigomaehrsikuhhknnen08(kaigomaehrsikuhhknnenLst.get(7));
        }

        if (kaigomaehrsikuhhknnenLst.size() > 8) {
            pHokenSyouken.setKaigomaehrsikuhhknnen09(kaigomaehrsikuhhknnenLst.get(8));
        }

        if (kaigomaehrsikuhhknnenLst.size() > 9) {
            pHokenSyouken.setKaigomaehrsikuhhknnen10(kaigomaehrsikuhhknnenLst.get(9));
        }

        if (kaigomaehrstikknLst.size() > 0) {
            pHokenSyouken.setKaigomaehrstikkn01(kaigomaehrstikknLst.get(0));
        }

        if (kaigomaehrstikknLst.size() > 1) {
            pHokenSyouken.setKaigomaehrstikkn02(kaigomaehrstikknLst.get(1));
        }

        if (kaigomaehrstikknLst.size() > 2) {
            pHokenSyouken.setKaigomaehrstikkn03(kaigomaehrstikknLst.get(2));
        }

        if (kaigomaehrstikknLst.size() > 3) {
            pHokenSyouken.setKaigomaehrstikkn04(kaigomaehrstikknLst.get(3));
        }

        if (kaigomaehrstikknLst.size() > 4) {
            pHokenSyouken.setKaigomaehrstikkn05(kaigomaehrstikknLst.get(4));
        }

        if (kaigomaehrstikknLst.size() > 5) {
            pHokenSyouken.setKaigomaehrstikkn06(kaigomaehrstikknLst.get(5));
        }

        if (kaigomaehrstikknLst.size() > 6) {
            pHokenSyouken.setKaigomaehrstikkn07(kaigomaehrstikknLst.get(6));
        }

        if (kaigomaehrstikknLst.size() > 7) {
            pHokenSyouken.setKaigomaehrstikkn08(kaigomaehrstikknLst.get(7));
        }

        if (kaigomaehrstikknLst.size() > 8) {
            pHokenSyouken.setKaigomaehrstikkn09(kaigomaehrstikknLst.get(8));
        }

        if (kaigomaehrstikknLst.size() > 9) {
            pHokenSyouken.setKaigomaehrstikkn10(kaigomaehrstikknLst.get(9));
        }

        if (kaigomaehrjrugkLst.size() > 0) {
            pHokenSyouken.setKaigomaehrjrugk01(kaigomaehrjrugkLst.get(0));
        }

        if (kaigomaehrjrugkLst.size() > 1) {
            pHokenSyouken.setKaigomaehrjrugk02(kaigomaehrjrugkLst.get(1));
        }

        if (kaigomaehrjrugkLst.size() > 2) {
            pHokenSyouken.setKaigomaehrjrugk03(kaigomaehrjrugkLst.get(2));
        }

        if (kaigomaehrjrugkLst.size() > 3) {
            pHokenSyouken.setKaigomaehrjrugk04(kaigomaehrjrugkLst.get(3));
        }

        if (kaigomaehrjrugkLst.size() > 4) {
            pHokenSyouken.setKaigomaehrjrugk05(kaigomaehrjrugkLst.get(4));
        }

        if (kaigomaehrjrugkLst.size() > 5) {
            pHokenSyouken.setKaigomaehrjrugk06(kaigomaehrjrugkLst.get(5));
        }

        if (kaigomaehrjrugkLst.size() > 6) {
            pHokenSyouken.setKaigomaehrjrugk07(kaigomaehrjrugkLst.get(6));
        }

        if (kaigomaehrjrugkLst.size() > 7) {
            pHokenSyouken.setKaigomaehrjrugk08(kaigomaehrjrugkLst.get(7));

        }

        if (kaigomaehrjrugkLst.size() > 8) {
            pHokenSyouken.setKaigomaehrjrugk09(kaigomaehrjrugkLst.get(8));
        }

        if (kaigomaehrjrugkLst.size() > 9) {
            pHokenSyouken.setKaigomaehrjrugk10(kaigomaehrjrugkLst.get(9));
        }

        pHokenSyouken.setHutanhiyustmmsgcdue01(hutanhiyustmmsgcdueLst.get(0));

        pHokenSyouken.setHutanhiyustmmsgcdue02(hutanhiyustmmsgcdueLst.get(1));

        pHokenSyouken.setHutanhiyustmmsgcdue03(hutanhiyustmmsgcdueLst.get(2));

        pHokenSyouken.setHutanhiyustmmsgcdue04(hutanhiyustmmsgcdueLst.get(3));

        pHokenSyouken.setHutanhiyustmknsnhyuptn(hutanhiyustmknsnhyuptn);

        pHokenSyouken.setHutanhiyustmmsgcdst01(hutanhiyustmmsgcdst01);

        pHokenSyouken.setHutanhiyustmmsgcdst02(hutanhiyustmmsgcdst02);

        pHokenSyouken.setHutanhiyustmmsgcdst03(hutanhiyustmmsgcdst03);

        pHokenSyouken.setFstphrkpkngkkeituuktype(fstphrkpkngkkeituuktype);

        pHokenSyouken.setFstphrkpkngkkei(fstphrkpkngkkei);

        pHokenSyouken.setSyouhnhutaimsgcd1(syouhnhutaimsgcdLst.get(0));

        pHokenSyouken.setSyouhnhutaimsgcd2(syouhnhutaimsgcdLst.get(1));

        pHokenSyouken.setWmsgcd1(wmsgcd1);

        pHokenSyouken.setWmsgcd2(wmsgcd2);

        pHokenSyouken.setWmsgcd3(wmsgcd3);

        if (wtyuuijikoumsgcdLst.size() > 0) {
            pHokenSyouken.setWtyuuijikoumsgcd1(wtyuuijikoumsgcdLst.get(0));
        }

        if (wtyuuijikoumsgcdLst.size() > 1) {
            pHokenSyouken.setWtyuuijikoumsgcd2(wtyuuijikoumsgcdLst.get(1));
        }

        if (wtyuuijikoumsgcdLst.size() > 2) {
            pHokenSyouken.setWtyuuijikoumsgcd3(wtyuuijikoumsgcdLst.get(2));
        }

        if (wtyuuijikoumsgcdLst.size() > 3) {
            pHokenSyouken.setWtyuuijikoumsgcd4(wtyuuijikoumsgcdLst.get(3));
        }

        if (wtyuuijikoumsgcdLst.size() > 4) {
            pHokenSyouken.setWtyuuijikoumsgcd5(wtyuuijikoumsgcdLst.get(4));
        }

        pHokenSyouken.setWitijibrptuktype(witijibrptuktype);

        pHokenSyouken.setWitijibrp(witijibrp);

        pHokenSyouken.setWyenhrkgktuktype(wyenhrkgktuktype);

        pHokenSyouken.setWyenhrkgk(wyenhrkgk);

        pHokenSyouken.setWyenitijibrptuktype(wyenitijibrptuktype);

        pHokenSyouken.setWyenitijibrp(wyenitijibrp);

        pHokenSyouken.setKoujyosyoumeimsgcd1(koujyosyoumeimsgcd1);

        pHokenSyouken.setTeiritutmtthbnwr(BizNumber.valueOf(100).subtract(kykjisisuurendourate));

        pHokenSyouken.setSisuutmtthbnwr(kykjisisuurendourate);

        pHokenSyouken.setHutanhiyustmytijihiritu(BizNumber.valueOf(HUTANHIYUSTMYTIJIHIRITU));

        pHokenSyouken.setWmsgcd21(wmsgcd2_1);

        pHokenSyouken.setWmsgcd22(wmsgcd2_2);

        pHokenSyouken.setWmsgcd31(wmsgcd3_1);

        pHokenSyouken.setWmsgcdst1(wmsgcdst);

        if (wtyuuijikoumsgcdLst.size() > 5) {
            pHokenSyouken.setWtyuuijikoumsgcd6(wtyuuijikoumsgcdLst.get(5));
        }

        if (wtyuuijikoumsgcdLst.size() > 6) {
            pHokenSyouken.setWtyuuijikoumsgcd7(wtyuuijikoumsgcdLst.get(6));
        }

        pHokenSyouken.setSonotanyranyensysnhkhnkymd(sonotanyranyensysnhkhnkymd);

        pHokenSyouken.setSonotanyrantmttkngktuktype(kyktuukasyu.getValue());

        pHokenSyouken.setKgmaehrtkdai1hknkknmnryymd(kgmaehrtkdai1hknkknmnryymd);

        logger.debug("△ 保険証券TBL編集（終身２） 終了");
    }
}
