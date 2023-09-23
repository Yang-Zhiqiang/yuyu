package yuyu.common.hozen.khcommon;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.number.currencytype.BizCurrencyTypes;
import jp.co.slcs.swak.util.string.ConvertUtil;

import org.slf4j.Logger;

import yuyu.common.biz.bzcommon.BizDateUtil;
import yuyu.common.biz.bzcommon.GetKawaseRate;
import yuyu.common.biz.bzcommon.HanteiHokenKikan;
import yuyu.common.biz.bzcommon.HanteiHokenKikanBean;
import yuyu.common.biz.bzcommon.KeisanGaikakanzan;
import yuyu.common.siharai.sicommon.CalcJdkghkKngk;
import yuyu.common.siharai.sicommon.CalcJdkghkKngkBean;
import yuyu.def.classification.C_EigyoubiHoseiKbn;
import yuyu.def.classification.C_HasuusyoriKbn;
import yuyu.def.classification.C_HknKknKbn;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_Hrkkeiro;
import yuyu.def.classification.C_IkkatubaraiKbn;
import yuyu.def.classification.C_JydkgmbHkKsnKbn;
import yuyu.def.classification.C_KawaserateSyuruiKbn;
import yuyu.def.classification.C_KawasetekiyoKbn;
import yuyu.def.classification.C_KawasetsryKbn;
import yuyu.def.classification.C_KjkhukaKbn;
import yuyu.def.classification.C_Kykjyoutai;
import yuyu.def.classification.C_SyoriKbn;
import yuyu.def.classification.C_SysKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_TykzentykgoKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_YouhiKbn;
import yuyu.def.db.entity.BM_SyouhnZokusei;
import yuyu.def.db.entity.IT_HhknSya;
import yuyu.def.db.entity.IT_HokenSyouken;
import yuyu.def.db.entity.IT_HokenSyoukenHukaInfo;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.IT_KykSonotaTkyk;
import yuyu.def.db.entity.IT_KykSya;
import yuyu.def.db.entity.IT_KykSyouhn;
import yuyu.def.db.entity.IT_KykUkt;
import yuyu.def.db.entity.IT_NyknJissekiRireki;
import yuyu.def.db.entity.IT_Zennou;
import yuyu.def.hozen.configuration.YuyuHozenConfig;

/**
 * 契約保全 契約保全共通 保険証券TBL編集（終身３）
 */
public class EditSyoukenTblSyuusin3 {

    private static final int SINKEIYAKUHOKENSYOUKEN = 1;

    private static final int SONOTANAIYOULSTMAXCNT = 20;

    private static final int HUTANHIYUSTMMSGCDUEMAXCNT = 4;

    private static final int WTYUUIJIKOUMSGCDMAXCNT = 7;

    private static final int SIBOUDAI1HKNKKNMSGCDCNT = 2;

    @Inject
    private static Logger logger;

    public EditSyoukenTblSyuusin3() {
        super();
    }

    public void editTBL(IT_HokenSyouken pHokenSyouken, IT_KykKihon pKykKihon,
        IT_KykSya pKykSya, IT_HhknSya pHhknSya,
        List<IT_KykSyouhn> pSyuKykSyouhnLst,
        List<IT_NyknJissekiRireki> pNyknJissekiRirekiLst,
        IT_KykSonotaTkyk pKykSonotaTkyk, IT_KykUkt pSiteiDairi,
        List<IT_KykUkt> pSibouhokenLst, EditHokenSyoukenParam pEditHokenSyoukenParam, BizDate pSyoriYmd,
        C_KjkhukaKbn pSbUktNmKjHukaKbn, C_UmuKbn pGengakuExistsCheck,
        int pSksyoukenskskbn, int pSinkykjyoutai, BM_SyouhnZokusei pSyouhnZokusei, C_SyoriKbn pYendthnkSyoriKbn,
        IT_Zennou pZennou) {

        logger.debug("▽ 保険証券TBL編集（終身３） 開始");

        BizDate sknnkaisiymd = null;

        String ptokuyakumsgcd = "";

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

        String kykniyustmsgcd1 = "";

        String kykniyustmsgcd2 = "";

        String kykniyustmsgcd3 = "";

        String kykniyustmsgcd4 = "";

        String siboudai2hknkknmsgcd1 = "";

        String siboudai2hknkknmsgcd2 = "";

        String siboudai1hknkknigimsgcd = "";

        String siboudai2hknkknsmsgcd = "";

        String siboumidasimsgcd1 = "";

        String siboumidasimsgcd2 = "";

        BizCurrency dai2s = null;

        C_Tuukasyu dai2syentuuktype = C_Tuukasyu.BLNK;

        BizCurrency dai2syenyendaka = null;

        BizCurrency dai2syenyenkijyun = null;

        BizCurrency dai2syenyenyasu = null;

        C_Tuukasyu dai2stuuktype = C_Tuukasyu.BLNK;

        BizNumber skwsrateyendaka = null;

        BizNumber skwsrateyenkijyun = null;

        BizNumber skwsrateyenyasu = null;

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

        C_HknKknKbn hknkknkbn = C_HknKknKbn.BLNK;

        BizDate dai1hknkknEndYmd = null;

        BizDate dai2hknkknStartYmd = null;

        String pmsgcd1 = null;

        String pmsgcd2 = null;

        String syukyktkykhknkknmsgkbn1 = null;

        String syukyktkykhknkknmsgkbn2 = null;

        String syukyktkykhknkknmsgkbn3 = null;

        String syukyktkyksmsgkbn1 = null;

        String syukyktkyksmsgkbn2 = null;

        String syukyktkyksmsgkbn3 = null;

        BizNumber sonotanyranytirrt = null;

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

        List<BizCurrency> kgmhrjrugkyendakaLst = new ArrayList<>();

        List<BizCurrency> kgmhrjrugkyenkijyunLst = new ArrayList<>();

        List<BizCurrency> kgmhrjrugkyenyasuLst = new ArrayList<>();

        List<String> hutanhiyustmmsgcdueLst = new ArrayList<>();

        List<String> wtyuuijikoumsgcdLst = new ArrayList<>();

        List<String> siboudai1hknkknmsgcdLst = new ArrayList<>();

        List<Integer> dai1skeikanensuuLst = new ArrayList<>();

        List<String> hyoujiranleftmsgcdLst = new ArrayList<>();

        List<String> hyoujiranrightmsgcdLst = new ArrayList<>();

        BizNumber yoteiriritu = pSyuKykSyouhnLst.get(0).getYoteiriritu();

        C_Tuukasyu kyktuukasyu = pSyuKykSyouhnLst.get(0).getKyktuukasyu();

        String kyktuukasyuNm = pSyuKykSyouhnLst.get(0).getKyktuukasyu().getContent();

        BizDate yendthnkymd = pSyuKykSyouhnLst.get(0).getYendthnkymd();

        int dai1hknkkn = pSyuKykSyouhnLst.get(0).getDai1hknkkn();

        BizDate kykymd = pSyuKykSyouhnLst.get(0).getKykymd();

        C_Kykjyoutai kykjyoutai = pSyuKykSyouhnLst.get(0).getKykjyoutai();

        C_Hrkkaisuu hrkkaisuuKbn = pKykKihon.getHrkkaisuu();

        BizCurrency hokenryou = pKykKihon.getHrkp();

        C_UmuKbn kzkTirasidouhuukbn1 = pHokenSyouken.getHokenSyoukenHukaInfo().getKzktirasidouhuukbn1();

        C_UmuKbn kzkTirasidouhuukbn2 = pHokenSyouken.getHokenSyoukenHukaInfo().getKzktirasidouhuukbn2();

        C_UmuKbn kykDrtkykhukaumu = pKykSonotaTkyk.getKykdrtkykhukaumu();

        if (yendthnkymd == null) {

            HanteiHokenKikan hanteiHokenKikan = SWAKInjector.getInstance(HanteiHokenKikan.class);

            HanteiHokenKikanBean hanteiHokenKikanBean = SWAKInjector.getInstance(HanteiHokenKikanBean.class);

            hanteiHokenKikanBean.setKykYmd(pSyuKykSyouhnLst.get(0).getKykymd());

            hanteiHokenKikanBean.setCalcKijyunYmd(pSyuKykSyouhnLst.get(0).getKykymd());

            hanteiHokenKikanBean.setSyouhnZokusei(pSyouhnZokusei);

            hanteiHokenKikanBean.setDai1hknkkn(dai1hknkkn);

            hknkknkbn = hanteiHokenKikan.exec(hanteiHokenKikanBean);

            dai1hknkknEndYmd = hanteiHokenKikan.getDai2HknkknStartYmd().getPreviousDay();

            dai2hknkknStartYmd = hanteiHokenKikan.getDai2HknkknStartYmd();
        }

        hyoujiranleftmsgcdLst.add("02010");
        sknnkaisiymd = pSyuKykSyouhnLst.get(0).getSknnkaisiymd();

        if (pSksyoukenskskbn == SINKEIYAKUHOKENSYOUKEN) {

            if (!C_Tuukasyu.JPY.eq(kyktuukasyu)) {

                hyoujiranleftmsgcdLst.add("02030");
            }
            hyoujiranleftmsgcdLst.add("02490");
            hyoujiranrightmsgcdLst.add("02513");
        }
        else {

            if (yendthnkymd == null) {

                if (!C_Tuukasyu.JPY.eq(kyktuukasyu)) {

                    hyoujiranleftmsgcdLst.add("02032");
                }
                hyoujiranleftmsgcdLst.add("02031");
                hyoujiranleftmsgcdLst.add("02054");
            }
        }

        pmsgcd1 = "05017";
        ptuukasyu = kyktuukasyu;
        ptuukasyuNm = kyktuukasyu.getContent();

        if (C_Kykjyoutai.ZENNOU.eq(kykjyoutai)) {

            if (!C_Tuukasyu.JPY.eq(kyktuukasyu)) {

                pmsgcd2 = "05019";
            }
            else {

                pmsgcd2 = "05018";
            }

            if (C_UmuKbn.ARI.eq(pKykSonotaTkyk.getYennykntkhkumu())) {

                ptokuyakumsgcd = "05023";
            }
        }
        else {

            if (C_UmuKbn.ARI.eq(pKykSonotaTkyk.getYennykntkhkumu())) {

                ptokuyakumsgcd = "05024";
            }
        }

        String hrkktuki = "";
        String phrkhouhou = "";
        String kykymdafter6 = "";
        String hrkkaisuu = "12";
        int zennnou = 0;
        BizCurrency zennoup = BizCurrency.valueOf(BigDecimal.ZERO);
        BizCurrency znnyenhrkGk = BizCurrency.valueOf(BigDecimal.ZERO);

        String kykymdm = ConvertUtil.toZenAll(String.valueOf(kykymd.getMonth()), 0, 0);

        if (kykymd.getMonth() == 6) {

            kykymdafter6 = "１２";
        }
        else {

            kykymdafter6 = ConvertUtil.toZenAll(String.valueOf((kykymd.getMonth() + 6) % 12), 0, 0) ;
        }

        if (C_Hrkkaisuu.TUKI.eq(hrkkaisuuKbn)) {

            hrkktuki = "毎月１日から末日まで";
        }
        else if (C_Hrkkaisuu.NEN.eq(hrkkaisuuKbn)) {

            hrkktuki = "毎年" + kykymdm + "月";

            hrkkaisuu = "1";
        }
        else if (C_Hrkkaisuu.HALFY.eq(hrkkaisuuKbn)) {

            hrkktuki = "毎年" + kykymdm + "月・" + kykymdafter6 + "月";
            hrkkaisuu = "2";
        }

        if (C_Hrkkeiro.KOUHURI.eq(pKykKihon.getHrkkeiro())) {

            phrkhouhou = "01";
        }
        else if (C_Hrkkeiro.CREDIT.eq(pKykKihon.getHrkkeiro())) {

            phrkhouhou = "04";
        }
        else {

            if (C_Kykjyoutai.ZENNOU.eq(pSyuKykSyouhnLst.get(0).getKykjyoutai())) {

                phrkhouhou = "00";
            }
        }

        if (C_Kykjyoutai.ZENNOU.eq(kykjyoutai)) {

            zennoup = pZennou.getZennounyuukinkgk().add(pZennou.getZennoujihrkp());

            if (!C_Tuukasyu.JPY.eq(kyktuukasyu) && C_Tuukasyu.JPY.eq(pZennou.getRstuukasyu())) {

                znnyenhrkGk = pZennou.getZennounyuukinkgkrstk().add(pNyknJissekiRirekiLst.get(0).getRsgaku());
            }

            zennnou = Integer.parseInt(pZennou.getZennoukikan()) + 1;
        }

        syukyktkykhknkngk2 = pSyuKykSyouhnLst.get(0).getKihons();
        syukyktkykstuukatype2 = kyktuukasyu;

        if (pSksyoukenskskbn == SINKEIYAKUHOKENSYOUKEN) {

            syukyktkykmsgkbn1 = "01";
            syukyktkykmsgkbn2 = "02";
            syukyktkyksmsgkbn1 = "07";
            syukyktkyksmsgkbn2 = "05";
            syukyktkykhknkknmsgkbn1 = "01";
            syukyktkykhknkknmsgkbn2 = "05";
        }
        else {

            if (yendthnkymd == null) {

                syukyktkykmsgkbn1 = "01";
                syukyktkykmsgkbn2 = "02";
                syukyktkyksmsgkbn1 = "09";
                syukyktkyksmsgkbn2 = "03";
                syukyktkykhknkknmsgkbn1 = "01";
                syukyktkykhknkknmsgkbn2 = "07";
                syutkdai1hknkknymdto1 = dai1hknkknEndYmd;
            }
        }


        kykniyustmsgcd1 = "08074";


        if (pSksyoukenskskbn == SINKEIYAKUHOKENSYOUKEN) {

            stNaiyouranMsgCdList.add("09012");

            if (C_UmuKbn.ARI.eq(pKykSonotaTkyk.getYennykntkhkumu())) {

                if (C_Kykjyoutai.ZENNOU.eq(kykjyoutai)) {

                    stNaiyouranMsgCdList.add("09024");
                }
                else {

                    stNaiyouranMsgCdList.add("09022");
                }
            }

            if (C_UmuKbn.ARI.eq(pKykSonotaTkyk.getJyudkaigomeharaitkhukaumu())) {

                stNaiyouranMsgCdList.add("09040");
            }

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

            stNaiyouranMsgCdList.add("09060");

            stNaiyouranMsgCdList.add("09090");

            sonotanyranytirrt = pSyuKykSyouhnLst.get(0).getYoteiriritu();
        }
        else {

            if (yendthnkymd == null) {

                stNaiyouranMsgCdList.add("09012");

                if (C_UmuKbn.ARI.eq(pKykSonotaTkyk.getYennykntkhkumu())) {

                    if (C_Kykjyoutai.ZENNOU.eq(kykjyoutai)) {

                        stNaiyouranMsgCdList.add("09029");

                        if (C_UmuKbn.ARI.eq(pGengakuExistsCheck)) {

                            stNaiyouranMsgCdList.add("09039");
                        }
                    }
                    else {

                        stNaiyouranMsgCdList.add("09027");

                        if (C_UmuKbn.ARI.eq(pGengakuExistsCheck)) {

                            stNaiyouranMsgCdList.add("09028");
                        }
                    }
                }
            }

            if (C_UmuKbn.ARI.eq(pKykSonotaTkyk.getJyudkaigomeharaitkhukaumu())) {

                stNaiyouranMsgCdList.add("09040");
            }

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

                stNaiyouranMsgCdList.add("09052");
            }

            stNaiyouranMsgCdList.add("09060");
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
            keikanensuu = 1;
            keikanensuuMax = dai1hknkkn;
        }
        else {
            keikanensuu = BizDateUtil.calcDifference(calcKijyunYmd, pSyuKykSyouhnLst.get(0).getKykymd()).getYears();
            keikanensuuMax = dai1hknkkn;
        }

        if (pSksyoukenskskbn == SINKEIYAKUHOKENSYOUKEN) {

            if (C_Kykjyoutai.ZENNOU.eq(pSyuKykSyouhnLst.get(0).getKykjyoutai())) {

                siboumidasimsgcd1 = "12012";
            }
            else {

                siboumidasimsgcd1 = "12016";
            }

            if (!C_Tuukasyu.JPY.eq(kyktuukasyu)) {

                if (C_Kykjyoutai.ZENNOU.eq(pSyuKykSyouhnLst.get(0).getKykjyoutai())) {

                    if (C_UmuKbn.ARI.eq(pKykSonotaTkyk.getYennykntkhkumu())) {

                        siboudai1hknkknmsgcdLst.add("12024");
                        siboudai2hknkknmsgcd1 = "12084";
                    }
                    else {

                        siboudai1hknkknmsgcdLst.add("12026");
                        siboudai2hknkknmsgcd1 = "12085";
                    }

                    siboudai1hknkknigimsgcd = "12054";
                }
                else {

                    siboudai1hknkknmsgcdLst.add("12023");
                    siboudai2hknkknmsgcd1 = "12083";
                    siboudai1hknkknigimsgcd = "12053";
                }

                siboudai2hknkknsmsgcd = "12112";
            }
            else {

                if (C_Kykjyoutai.ZENNOU.eq(pSyuKykSyouhnLst.get(0).getKykjyoutai())) {

                    siboudai1hknkknmsgcdLst.add("12025");
                }
                else {

                    siboudai1hknkknmsgcdLst.add("12022");
                }

                siboudai2hknkknmsgcd1 = "12082";
                siboudai1hknkknigimsgcd = "12052";
            }
        }
        else {

            if (yendthnkymd == null) {

                if (C_Kykjyoutai.ZENNOU.eq(pSyuKykSyouhnLst.get(0).getKykjyoutai())) {

                    siboumidasimsgcd1 = "12015";
                }
                else {

                    siboumidasimsgcd1 = "12013";
                }

                if (!C_Tuukasyu.JPY.eq(kyktuukasyu)) {

                    if (C_Kykjyoutai.ZENNOU.eq(pSyuKykSyouhnLst.get(0).getKykjyoutai())) {

                        if (C_UmuKbn.ARI.eq(pKykSonotaTkyk.getYennykntkhkumu())) {

                            siboudai1hknkknmsgcdLst.add("12024");
                            siboudai2hknkknmsgcd1 = "12084";
                            siboudai1hknkknigimsgcd = "12056";
                        }
                        else {

                            siboudai1hknkknmsgcdLst.add("12026");
                            siboudai2hknkknmsgcd1 = "12085";
                            siboudai1hknkknigimsgcd = "12057";
                        }
                    }
                    else {

                        siboudai1hknkknmsgcdLst.add("12023");
                        siboudai2hknkknmsgcd1 = "12083";
                        siboudai1hknkknigimsgcd = "12053";
                    }

                    siboudai2hknkknsmsgcd = "12116";
                }
                else {

                    if (C_Kykjyoutai.ZENNOU.eq(pSyuKykSyouhnLst.get(0).getKykjyoutai())) {

                        siboudai1hknkknmsgcdLst.add("12025");
                    }
                    else {

                        siboudai1hknkknmsgcdLst.add("12022");
                    }

                    siboudai2hknkknmsgcd1 = "12082";
                    siboudai1hknkknigimsgcd = "12055";
                }
            }
        }

        int siboudai1hknkknmsgcdLstCnt = siboudai1hknkknmsgcdLst.size();

        for (int i = 0; i < SIBOUDAI1HKNKKNMSGCDCNT - siboudai1hknkknmsgcdLstCnt; i++) {
            siboudai1hknkknmsgcdLst.add("");
        }

        GetKawaseRate getKawaseRate = SWAKInjector.getInstance(GetKawaseRate.class);

        KeisanGaikakanzan keisanGaikakanzan = SWAKInjector.getInstance(KeisanGaikakanzan.class);

        if (C_HknKknKbn.DAI1HKNKKN.eq(hknkknkbn)) {
            for (int n = 0; n < keikanensuuMax; n++) {

                if (pSksyoukenskskbn == SINKEIYAKUHOKENSYOUKEN) {
                    dai1skeikanensuuLst.add(keikanensuu);
                }
                else {
                    dai1skeikanensuuLst.add(0);
                }

                calcKijyunYmd = BizDate.valueOf(calcKijyunYmd.getYear() + 1,
                    pSyuKykSyouhnLst.get(0).getKykymd().getBizDateMD()).getRekijyou();

                keikanensuu = keikanensuu + 1;
            }
        }

        if (C_HknKknKbn.DAI1HKNKKN.eq(hknkknkbn) || C_HknKknKbn.DAI2HKNKKN.eq(hknkknkbn)) {

            dai2stuuktype = kyktuukasyu;
            dai2s = pSyuKykSyouhnLst.get(0).getKihons();
            dai2syentuuktype = C_Tuukasyu.JPY;
        }

        if (!C_Tuukasyu.JPY.eq(kyktuukasyu)) {

            C_UmuKbn zennoumousideUmu = C_UmuKbn.NONE;

            if (C_Kykjyoutai.ZENNOU.eq(pSyuKykSyouhnLst.get(0).getKykjyoutai())) {

                zennoumousideUmu = C_UmuKbn.ARI;
            }
            else {

                zennoumousideUmu = C_UmuKbn.NONE;
            }

            getKawaseRate.execFstPNyuukin(
                pKykKihon.getFstpnyknymd(),
                kyktuukasyu,
                C_Tuukasyu.JPY,
                C_YouhiKbn.HUYOU,
                hrkkaisuuKbn,
                C_SysKbn.SKEI,
                zennoumousideUmu,
                C_IkkatubaraiKbn.BLNK);

            getKawaseRate.exec(getKawaseRate.getKwsrateKjYmd(),
                C_KawaserateSyuruiKbn.KOUJIKAWASERATE, kyktuukasyu,
                C_Tuukasyu.JPY, C_KawasetekiyoKbn.TTM, C_KawasetsryKbn.SYUKKINRATE,
                C_EigyoubiHoseiKbn.YOKUEIGYOUBI, C_YouhiKbn.HUYOU);

            BizNumber yenksykawaserate = getKawaseRate.getKawaserate();
            BizNumber kawaserateHendouYenup = YuyuHozenConfig.getInstance().getKawaserateHendouYenup();
            BizNumber kawaserateHendouYendown = YuyuHozenConfig.getInstance().getKawaserateHendouYendown();
            skwsrateyenkijyun = yenksykawaserate;
            skwsrateyendaka = skwsrateyenkijyun.subtract(kawaserateHendouYenup);
            skwsrateyenyasu = skwsrateyenkijyun.add(kawaserateHendouYendown);

            if (C_HknKknKbn.DAI1HKNKKN.eq(hknkknkbn) || C_HknKknKbn.DAI2HKNKKN.eq(hknkknkbn)) {

                dai2syenyendaka = keisanGaikakanzan.exec(C_Tuukasyu.JPY, dai2s,
                    skwsrateyendaka, C_HasuusyoriKbn.SUTE);

                dai2syenyenkijyun = keisanGaikakanzan.exec(C_Tuukasyu.JPY,
                    dai2s, skwsrateyenkijyun, C_HasuusyoriKbn.SUTE);

                dai2syenyenyasu = keisanGaikakanzan.exec(C_Tuukasyu.JPY, dai2s,
                    skwsrateyenyasu, C_HasuusyoriKbn.SUTE);
            }
        }

        if (pSksyoukenskskbn == SINKEIYAKUHOKENSYOUKEN) {

            if (!C_Tuukasyu.JPY.eq(kyktuukasyu)) {

                if (C_UmuKbn.ARI.eq(pKykSonotaTkyk.getJyudkaigomeharaitkhukaumu())) {

                    hutanhiyustmmsgcdueLst.add("13072");
                }
                else {

                    hutanhiyustmmsgcdueLst.add("13074");
                }

                hutanhiyustmmsgcdueLst.add("13092");

                if (C_UmuKbn.ARI.eq(pKykSonotaTkyk.getYennykntkhkumu())) {

                    if (C_Kykjyoutai.ZENNOU.eq(pSyuKykSyouhnLst.get(0).getKykjyoutai())) {

                        hutanhiyustmknsnhyuptn = "13";
                    }
                    else {

                        hutanhiyustmknsnhyuptn = "12";
                    }

                    hutanhiyustmmsgcdst02 = "13112";
                }
                else {

                    hutanhiyustmknsnhyuptn = "11";
                    hutanhiyustmmsgcdst02 = "13111";
                }

                hutanhiyustmmsgcdst01 = "13100";
            }
        }
        else {

            if (yendthnkymd == null) {

                if (!C_Tuukasyu.JPY.eq(kyktuukasyu)) {

                    if (C_UmuKbn.ARI.eq(pKykSonotaTkyk.getJyudkaigomeharaitkhukaumu())) {

                        hutanhiyustmmsgcdueLst.add("13101");
                    }
                    else {

                        hutanhiyustmmsgcdueLst.add("13102");
                    }

                    hutanhiyustmmsgcdueLst.add("13092");

                    if (C_UmuKbn.ARI.eq(pKykSonotaTkyk.getYennykntkhkumu())) {

                        if (C_Kykjyoutai.ZENNOU.eq(pSyuKykSyouhnLst.get(0).getKykjyoutai())) {

                            hutanhiyustmknsnhyuptn = "13";
                        }
                        else {

                            hutanhiyustmknsnhyuptn = "12";
                        }

                        hutanhiyustmmsgcdst02 = "13112";
                    }
                    else {

                        hutanhiyustmknsnhyuptn = "11";
                        hutanhiyustmmsgcdst02 = "13111";
                    }

                    hutanhiyustmmsgcdst01 = "13100";
                }
            }
        }

        int hutanhiyustmmsgcdueLsttCnt = hutanhiyustmmsgcdueLst.size();

        for (int i = 0; i < HUTANHIYUSTMMSGCDUEMAXCNT - hutanhiyustmmsgcdueLsttCnt; i++) {
            hutanhiyustmmsgcdueLst.add("");
        }

        String fstpmsgcd = pHokenSyouken.getFstpmsgcd();

        if (pSksyoukenskskbn == SINKEIYAKUHOKENSYOUKEN) {

            fstphrkpkngkkeituuktype = pNyknJissekiRirekiLst.get(0).getRstuukasyu();

            fstphrkpkngkkei = pNyknJissekiRirekiLst.get(0).getRsgaku();

            if (C_Kykjyoutai.ZENNOU.eq(pSyuKykSyouhnLst.get(0).getKykjyoutai())) {

                fstpmsgcd = "13151";

                if (!C_Tuukasyu.JPY.eq(kyktuukasyu) && C_Tuukasyu.JPY.eq(pZennou.getRstuukasyu())) {

                    fstphrkpkngkkei = znnyenhrkGk;
                }
                else {

                    fstphrkpkngkkei = zennoup;
                }
            }
        }

        if (pSksyoukenskskbn == SINKEIYAKUHOKENSYOUKEN) {

            if (!C_Tuukasyu.JPY.eq(kyktuukasyu)) {

                if (C_UmuKbn.ARI.eq(pKykSonotaTkyk.getYennykntkhkumu())) {

                    koujyosyoumeimsgcd1 = "15040";
                }
                else {

                    koujyosyoumeimsgcd1 = "15048";
                }
            }
            else {

                koujyosyoumeimsgcd1 = "15040";
            }
        }

        if (pSksyoukenskskbn == SINKEIYAKUHOKENSYOUKEN) {
            hhknnen = pSyuKykSyouhnLst.get(0).getHhknnen() + dai1hknkkn;

            if (C_UmuKbn.ARI.eq(pKykSonotaTkyk.getJyudkaigomeharaitkhukaumu())) {

                if (!C_Tuukasyu.JPY.eq(kyktuukasyu)) {

                    kaigomaehrtkykmsgcd1 = "13033";
                    kaigomaehrtkykmsgcdst1 = "13053";
                }
                else {

                    kaigomaehrtkykmsgcd1 = "13032";
                    kaigomaehrtkykmsgcdst1 = "13052";
                }

                kaigomaehrtkykkyktuuka = kyktuukasyuNm;
                kaigomaehrjrugktype = kyktuukasyu;

                if (pKykSonotaTkyk.getStdrsktkyhkumu().eq(C_UmuKbn.ARI)) {

                    kaigomaehrtkykstdmsgcd = "13061";
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

                if (!C_Tuukasyu.JPY.eq(kyktuukasyu)) {

                    kaigomaehrtkykmsgcd1 = "13039";
                    kaigomaehrtkykmsgcdst1 = "13054";
                }
                else {

                    kaigomaehrtkykmsgcd1 = "13037";
                    kaigomaehrtkykmsgcdst1 = "13053";
                }
                kaigomaehrtkykkyktuuka = kyktuukasyuNm;
                kaigomaehrjrugktype = kyktuukasyu;

                if (pKykSonotaTkyk.getStdrsktkyhkumu().eq(C_UmuKbn.ARI)) {

                    kaigomaehrtkykstdmsgcd = "13062";
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
            else if (C_Tuukasyu.JPY.eq(kyktuukasyu)) {

                b = BizCurrency.valueOf(1000000, BizCurrencyTypes.YEN);
                w = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);
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

                if (C_Tuukasyu.USD.eq(kyktuukasyu)) {

                    BizCurrency kgmhrjrugkyendaka = keisanGaikakanzan.exec(C_Tuukasyu.JPY, calcJdkghkKngkBean.getJdkghkKnGk(),
                        skwsrateyendaka, C_HasuusyoriKbn.SUTE);

                    BizCurrency kgmhrjrugkyenkijyun = keisanGaikakanzan.exec(C_Tuukasyu.JPY,
                        calcJdkghkKngkBean.getJdkghkKnGk(), skwsrateyenkijyun, C_HasuusyoriKbn.SUTE);

                    BizCurrency kgmhrjrugkyenyasu = keisanGaikakanzan.exec(C_Tuukasyu.JPY, calcJdkghkKngkBean.getJdkghkKnGk(),
                        skwsrateyenyasu, C_HasuusyoriKbn.SUTE);

                    kgmhrjrugkyendakaLst.add(kgmhrjrugkyendaka);
                    kgmhrjrugkyenkijyunLst.add(kgmhrjrugkyenkijyun);
                    kgmhrjrugkyenyasuLst.add(kgmhrjrugkyenyasu);
                }

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

            if (!C_Tuukasyu.JPY.eq(kyktuukasyu)) {

                wmsgcd1 = "14026";

                if (C_Kykjyoutai.ZENNOU.eq(pSyuKykSyouhnLst.get(0).getKykjyoutai())) {

                    if (C_UmuKbn.ARI.eq(pKykSonotaTkyk.getYennykntkhkumu())) {

                        wtyuuijikoumsgcdLst.add("14075");
                    }
                    else {

                        wtyuuijikoumsgcdLst.add("14079");
                    }
                }
                else {

                    wtyuuijikoumsgcdLst.add("14064");
                }
            }
            else {

                wmsgcd1 = "14012";
            }
        }
        else {

            if (yendthnkymd == null) {

                if (hhknnenOutou <= 105) {

                    if (!C_Tuukasyu.JPY.eq(kyktuukasyu)) {

                        wmsgcd1 = "14010";

                        if (C_Kykjyoutai.ZENNOU.eq(pSyuKykSyouhnLst.get(0).getKykjyoutai())) {

                            if (C_UmuKbn.ARI.eq(pKykSonotaTkyk.getYennykntkhkumu())) {

                                wtyuuijikoumsgcdLst.add("14078");
                            }
                            else {

                                wtyuuijikoumsgcdLst.add("14085");
                            }
                        }
                        else {

                            wtyuuijikoumsgcdLst.add("14077");
                        }
                    }
                    else {

                        wmsgcd1 = "14021";
                    }
                }
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

        pHokenSyouken.setPmsgcd1(pmsgcd1);

        pHokenSyouken.setPmsgcd2(pmsgcd2);

        pHokenSyouken.setPtuukatype(ptuukasyu);

        pHokenSyouken.setHokenryou(hokenryou);

        pHokenSyouken.setPtuuka(ptuukasyuNm);

        pHokenSyouken.setPtokuyakumsgcd(ptokuyakumsgcd);

        pHokenSyouken.setHrkkknmsgkbn(String.valueOf(dai1hknkkn));

        pHokenSyouken.setHrkkaisuumsgkbn(hrkkaisuu);

        pHokenSyouken.setPhrkktuki(hrkktuki);

        pHokenSyouken.setHrkhouhoumsgkbn(phrkhouhou);

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

        pHokenSyouken.setSyutkdai1hknkknymdto1(syutkdai1hknkknymdto1);

        pHokenSyouken.setSyutkdai1hknkknymdto2(dai2hknkknStartYmd);

        pHokenSyouken.setKykniyustmsgcd1(kykniyustmsgcd1);

        pHokenSyouken.setKykniyustmsgcd2(kykniyustmsgcd2);

        pHokenSyouken.setKykniyustmsgcd3(kykniyustmsgcd3);

        pHokenSyouken.setKykniyustmsgcd4(kykniyustmsgcd4);

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

        pHokenSyouken.setSonotanyrannykntuukap(znnyenhrkGk);

        pHokenSyouken.setSonotanyranytirrt(sonotanyranytirrt);

        if (pSksyoukenskskbn != SINKEIYAKUHOKENSYOUKEN) {

            pHokenSyouken.setHosyounymsgcd("99001");
        }

        pHokenSyouken.setSiboumidasimsgcd(siboumidasimsgcd1);

        pHokenSyouken.setSiboumidasimsgcd2(siboumidasimsgcd2);

        pHokenSyouken.setSiboudai1hknkknmsgcd1(siboudai1hknkknmsgcdLst.get(0));

        pHokenSyouken.setSiboudai1hknkknmsgcd2(siboudai1hknkknmsgcdLst.get(1));

        pHokenSyouken.setSiboudai1hknkknigimsgcd(siboudai1hknkknigimsgcd);

        pHokenSyouken.setSiboudai2hknkknmsgcd1(siboudai2hknkknmsgcd1);

        pHokenSyouken.setSiboudai2hknkknmsgcd2(siboudai2hknkknmsgcd2);

        pHokenSyouken.setSiboudai2hknkknsmsgcd(siboudai2hknkknsmsgcd);

        pHokenSyouken.setSiboudai2kjnkngktuuktype(kyktuukasyu);

        pHokenSyouken.setSiboudai2kjnkngk(dai2s);

        if (pSksyoukenskskbn == SINKEIYAKUHOKENSYOUKEN) {
            pHokenSyouken.setSiboudai1hknkkn(dai1hknkkn);
        }

        pHokenSyouken.setSiboudai1hknkknymdto(dai1hknkknEndYmd);

        pHokenSyouken.setSiboudai2hknkknymdto(dai2hknkknStartYmd);

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

        pHokenSyouken.setDai2stuuktype(dai2stuuktype);

        pHokenSyouken.setDai2s(dai2s);

        pHokenSyouken.setDai2syentuuktype(dai2syentuuktype);

        pHokenSyouken.setDai2syenyendaka(dai2syenyendaka);

        pHokenSyouken.setDai2syenyenkijyun(dai2syenyenkijyun);

        pHokenSyouken.setDai2syenyenyasu(dai2syenyenyasu);

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

        pHokenSyouken.setFstpmsgcd(fstpmsgcd);


        IT_HokenSyoukenHukaInfo pHokenSyoukenHukaInfo = pHokenSyouken.getHokenSyoukenHukaInfo();
        pHokenSyoukenHukaInfo.setHenkousikibetukey(pHokenSyouken.getHenkousikibetukey());
        pHokenSyoukenHukaInfo.setZnntikiktbriyhrkgktuktype(kyktuukasyu);
        pHokenSyoukenHukaInfo.setZnntikiktbriyenhrkgk(zennoup);
        pHokenSyoukenHukaInfo.setZnnkai2(zennnou);
        pHokenSyoukenHukaInfo.setFstpznnkngktuktype(fstphrkpkngkkeituuktype);
        pHokenSyoukenHukaInfo.setFstpznnkngk(fstphrkpkngkkei);

        if (kgmhrjrugkyendakaLst.size() > 0) {

            pHokenSyoukenHukaInfo.setKaigomaehrjrugkydaka01(kgmhrjrugkyendakaLst.get(0));
        }

        if (kgmhrjrugkyendakaLst.size() > 1) {
            pHokenSyoukenHukaInfo.setKaigomaehrjrugkydaka02(kgmhrjrugkyendakaLst.get(1));
        }

        if (kgmhrjrugkyendakaLst.size() > 2) {
            pHokenSyoukenHukaInfo.setKaigomaehrjrugkydaka03(kgmhrjrugkyendakaLst.get(2));
        }

        if (kgmhrjrugkyendakaLst.size() > 3) {
            pHokenSyoukenHukaInfo.setKaigomaehrjrugkydaka04(kgmhrjrugkyendakaLst.get(3));
        }

        if (kgmhrjrugkyendakaLst.size() > 4) {
            pHokenSyoukenHukaInfo.setKaigomaehrjrugkydaka05(kgmhrjrugkyendakaLst.get(4));
        }

        if (kgmhrjrugkyendakaLst.size() > 5) {
            pHokenSyoukenHukaInfo.setKaigomaehrjrugkydaka06(kgmhrjrugkyendakaLst.get(5));
        }

        if (kgmhrjrugkyendakaLst.size() > 6) {
            pHokenSyoukenHukaInfo.setKaigomaehrjrugkydaka07(kgmhrjrugkyendakaLst.get(6));
        }

        if (kgmhrjrugkyendakaLst.size() > 7) {
            pHokenSyoukenHukaInfo.setKaigomaehrjrugkydaka08(kgmhrjrugkyendakaLst.get(7));

        }

        if (kgmhrjrugkyendakaLst.size() > 8) {
            pHokenSyoukenHukaInfo.setKaigomaehrjrugkydaka09(kgmhrjrugkyendakaLst.get(8));
        }

        if (kgmhrjrugkyendakaLst.size() > 9) {
            pHokenSyoukenHukaInfo.setKaigomaehrjrugkydaka10(kgmhrjrugkyendakaLst.get(9));
        }

        if (kgmhrjrugkyenkijyunLst.size() > 0) {
            pHokenSyoukenHukaInfo.setKaigomaehrjrugkykijyun01(kgmhrjrugkyenkijyunLst.get(0));
        }

        if (kgmhrjrugkyenkijyunLst.size() > 1) {
            pHokenSyoukenHukaInfo.setKaigomaehrjrugkykijyun02(kgmhrjrugkyenkijyunLst.get(1));
        }

        if (kgmhrjrugkyenkijyunLst.size() > 2) {
            pHokenSyoukenHukaInfo.setKaigomaehrjrugkykijyun03(kgmhrjrugkyenkijyunLst.get(2));
        }

        if (kgmhrjrugkyenkijyunLst.size() > 3) {
            pHokenSyoukenHukaInfo.setKaigomaehrjrugkykijyun04(kgmhrjrugkyenkijyunLst.get(3));
        }

        if (kgmhrjrugkyenkijyunLst.size() > 4) {
            pHokenSyoukenHukaInfo.setKaigomaehrjrugkykijyun05(kgmhrjrugkyenkijyunLst.get(4));
        }

        if (kgmhrjrugkyenkijyunLst.size() > 5) {
            pHokenSyoukenHukaInfo.setKaigomaehrjrugkykijyun06(kgmhrjrugkyenkijyunLst.get(5));
        }

        if (kgmhrjrugkyenkijyunLst.size() > 6) {
            pHokenSyoukenHukaInfo.setKaigomaehrjrugkykijyun07(kgmhrjrugkyenkijyunLst.get(6));
        }

        if (kgmhrjrugkyenkijyunLst.size() > 7) {
            pHokenSyoukenHukaInfo.setKaigomaehrjrugkykijyun08(kgmhrjrugkyenkijyunLst.get(7));

        }

        if (kgmhrjrugkyenkijyunLst.size() > 8) {
            pHokenSyoukenHukaInfo.setKaigomaehrjrugkykijyun09(kgmhrjrugkyenkijyunLst.get(8));
        }

        if (kgmhrjrugkyenkijyunLst.size() > 9) {
            pHokenSyoukenHukaInfo.setKaigomaehrjrugkykijyun10(kgmhrjrugkyenkijyunLst.get(9));
        }

        if (kgmhrjrugkyenyasuLst.size() > 0) {
            pHokenSyoukenHukaInfo.setKaigomaehrjrugkyyasu01(kgmhrjrugkyenyasuLst.get(0));
        }

        if (kgmhrjrugkyenyasuLst.size() > 1) {
            pHokenSyoukenHukaInfo.setKaigomaehrjrugkyyasu02(kgmhrjrugkyenyasuLst.get(1));
        }

        if (kgmhrjrugkyenyasuLst.size() > 2) {
            pHokenSyoukenHukaInfo.setKaigomaehrjrugkyyasu03(kgmhrjrugkyenyasuLst.get(2));
        }

        if (kgmhrjrugkyenyasuLst.size() > 3) {
            pHokenSyoukenHukaInfo.setKaigomaehrjrugkyyasu04(kgmhrjrugkyenyasuLst.get(3));
        }

        if (kgmhrjrugkyenyasuLst.size() > 4) {
            pHokenSyoukenHukaInfo.setKaigomaehrjrugkyyasu05(kgmhrjrugkyenyasuLst.get(4));
        }

        if (kgmhrjrugkyenyasuLst.size() > 5) {
            pHokenSyoukenHukaInfo.setKaigomaehrjrugkyyasu06(kgmhrjrugkyenyasuLst.get(5));
        }

        if (kgmhrjrugkyenyasuLst.size() > 6) {
            pHokenSyoukenHukaInfo.setKaigomaehrjrugkyyasu07(kgmhrjrugkyenyasuLst.get(6));
        }

        if (kgmhrjrugkyenyasuLst.size() > 7) {
            pHokenSyoukenHukaInfo.setKaigomaehrjrugkyyasu08(kgmhrjrugkyenyasuLst.get(7));
        }

        if (kgmhrjrugkyenyasuLst.size() > 8) {
            pHokenSyoukenHukaInfo.setKaigomaehrjrugkyyasu09(kgmhrjrugkyenyasuLst.get(8));
        }

        if (kgmhrjrugkyenyasuLst.size() > 9) {
            pHokenSyoukenHukaInfo.setKaigomaehrjrugkyyasu10(kgmhrjrugkyenyasuLst.get(9));
        }

        logger.debug("△ 保険証券TBL編集（終身３） 終了");
    }
}
