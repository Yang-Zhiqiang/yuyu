package yuyu.common.hozen.khcommon;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.number.currencytype.BizCurrencyTypes;
import jp.co.slcs.swak.number.currencytype.CurrencyType;

import org.slf4j.Logger;

import yuyu.common.biz.bzcommon.BizDateUtil;
import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.common.biz.bzcommon.GetKawaseRate;
import yuyu.common.biz.bzcommon.HenkanTuuka;
import yuyu.common.biz.bzcommon.KeisanGaikakanzan;
import yuyu.common.biz.exception.CommonBizAppException;
import yuyu.def.classification.C_EigyoubiHoseiKbn;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_HasuusyoriKbn;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_KawaserateSyuruiKbn;
import yuyu.def.classification.C_KawasetekiyoKbn;
import yuyu.def.classification.C_KawasetsryKbn;
import yuyu.def.classification.C_Kykjyoutai;
import yuyu.def.classification.C_MvaTekiyoujyoutaiKbn;
import yuyu.def.classification.C_SinsaihkKbn;
import yuyu.def.classification.C_SyoukensaihkKbn;
import yuyu.def.classification.C_TmttknhaibunjyoutaiKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_YouhiKbn;
import yuyu.def.db.entity.IT_Suiihyou;
import yuyu.def.hozen.configuration.YuyuHozenConfig;

/**
 * 契約保全 契約保全共通 解約返戻金推移表作成（年金）
 */
public class WSuiihyouNenkin {

    private final static String ERROR_MSG = "解約返戻金計算が実行できませんでした。";

    private final static String ERROR_MSG_2 = "積増判定時指数連動積立金計算が実行できませんでした。";

    private final static String ERROR_MSG_3 = "指数連動年金積立金計算が実行できませんでした。";

    private final static String ERROR_MSG_4 = "自由設計用積増判定日指数係数リストの設定件数が不足しています。";

    private final static BizNumber TMMSHANTEIYMD_SISUU_UPDOWN_UP = BizNumber.valueOf(1.05);

    private final static BizNumber TMMSHANTEIYMD_SISUU_UPDOWN_DOWN = BizNumber.valueOf(0.95);

    private final static BizNumber TMMSHANTEIYMD_SISUU_DOWN = BizNumber.valueOf(0.95);

    private final static BizNumber TMMSHANTEIYMD_SISUU_UP = BizNumber.valueOf(1.1);

    private final static String SUIIHYOUSYUBETU_KONGOU = "02";

    private final static String SUIIHYOUSYUBETU_SISUU = "05";

    private final static String SUIIHYOUSYUBETU_TEIRITU = "03";

    private final static String SUIIHYOUSYUBETU_YENDATE = "04";

    private C_YouhiKbn yenkansannYhKbn = C_YouhiKbn.YOU;

    private C_YouhiKbn jiyuSekkeiYhKbn = C_YouhiKbn.HUYOU;

    private List<BizNumber> jySekkeiYouTmmshanteiSisuuList;

    private List<SuiihyouExtBean> suiihyouExtBeanLst;

    @Inject
    private static Logger logger;

    public WSuiihyouNenkin() {
        super();
    }

    public void setYenkansannYhKbn(C_YouhiKbn pYenkansannYhKbn) {
        yenkansannYhKbn = pYenkansannYhKbn;
    }

    public void setJiyuSekkeiYhKbn(C_YouhiKbn pJiyuSekkeiYhKbn) {
        jiyuSekkeiYhKbn = pJiyuSekkeiYhKbn;
    }

    public void setJySekkeiYouTmmshanteiSisuuList(List<BizNumber> pJySekkeiYouTmmshanteiSisuuList) {
        jySekkeiYouTmmshanteiSisuuList = pJySekkeiYouTmmshanteiSisuuList;
    }

    public List<SuiihyouExtBean> getSuiihyouExtBeanLst() {
        return suiihyouExtBeanLst;
    }

    public List<IT_Suiihyou> exec(WSuiihyouParam pWSuiihyouParam) {

        logger.debug("▽ 解約返戻金推移表作成（年金） 開始");

        int rekijyouSyuuseiUmu = 0;

        int wkKeikaNensuu = 0;

        int wkKeikaNensuuMax = 0;

        BizNumber tmmshanteiymdSisuuUpDown = BizNumber.ZERO;

        BizNumber tmmshanteiymdSisuuDown = BizNumber.ZERO;

        BizNumber tmmshanteiymdSisuuUp = BizNumber.ZERO;

        BizCurrency sisuurendoutmttkngkUpDown = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);

        BizNumber tykzentmmshanteiymdSisuuUpDown = BizNumber.ZERO;

        BizCurrency sisuurendoutmttkngkDown = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);

        BizNumber tykzentmmshanteiymdSisuuDown = BizNumber.ZERO;

        BizCurrency sisuurendoutmttkngkUp = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);

        BizNumber tykzentmmshanteiymdSisuuUp = BizNumber.ZERO;

        if (C_SinsaihkKbn.SIN.eq(pWSuiihyouParam.getSinsaihkKbn())) {
            if(C_TmttknhaibunjyoutaiKbn.BLNK.eq(pWSuiihyouParam.getTmttknhaibunjyoutai())){
                if(pWSuiihyouParam.getSisuurendourate().compareTo(BizNumber.valueOf(100)) == 0){
                    pWSuiihyouParam.setTmttknhaibunjyoutai(C_TmttknhaibunjyoutaiKbn.SISUU_ONLY);
                }
                else if(pWSuiihyouParam.getSisuurendourate().compareTo(BizNumber.ZERO) == 0){
                    pWSuiihyouParam.setTmttknhaibunjyoutai(C_TmttknhaibunjyoutaiKbn.TEIRITU_ONLY);
                }
                else{
                    pWSuiihyouParam.setTmttknhaibunjyoutai(C_TmttknhaibunjyoutaiKbn.SISUUTEIRITU);
                }
            }
        }

        C_SinsaihkKbn csinsaihkKbn = C_SinsaihkKbn.BLNK;
        int saihktysinen = 0;

        if (C_SinsaihkKbn.SIN.eq(pWSuiihyouParam.getSinsaihkKbn()) ||
            (C_SinsaihkKbn.SAI.eq(pWSuiihyouParam.getSinsaihkKbn()) &&
                C_SyoukensaihkKbn.SINKEIYAKUSAISAKUSEI.eq(pWSuiihyouParam.getSyoukensaihkKbn()))) {
            csinsaihkKbn = C_SinsaihkKbn.SIN;
        }
        else {
            csinsaihkKbn = C_SinsaihkKbn.SAI;
            saihktysinen     = 1;
        }

        BizDate hoseiKijyunYmd = BizDate.valueOf(pWSuiihyouParam.getCalcKijyunYmd().getYear(), pWSuiihyouParam
            .getKeisanWExtBean().getKykymd().getBizDateMD());

        if (!hoseiKijyunYmd.isRekijyou()) {

            hoseiKijyunYmd = hoseiKijyunYmd.getRekijyou().getNextDay();

            rekijyouSyuuseiUmu = 1;
        }

        BizDate nenoutouYmd;

        if (C_SinsaihkKbn.SAI.eq(csinsaihkKbn) &&
            (BizDateUtil.compareYmd(hoseiKijyunYmd, pWSuiihyouParam.getCalcKijyunYmd()) == BizDateUtil.COMPARE_LESSER ||
            BizDateUtil.compareYmd(hoseiKijyunYmd, pWSuiihyouParam.getCalcKijyunYmd()) == BizDateUtil.COMPARE_EQUAL)) {

            nenoutouYmd = BizDate.valueOf((pWSuiihyouParam.getCalcKijyunYmd().getYear() + 1), pWSuiihyouParam
                .getKeisanWExtBean().getKykymd().getBizDateMD());

            if (!nenoutouYmd.isRekijyou()) {

                nenoutouYmd = nenoutouYmd.getRekijyou().getNextDay();

                rekijyouSyuuseiUmu = 1;
            }
        }
        else {

            nenoutouYmd = hoseiKijyunYmd;
        }

        BizDate calcKijyunYmd = nenoutouYmd;

        if (C_SinsaihkKbn.SIN.eq(csinsaihkKbn)) {

            wkKeikaNensuu = 0;

            wkKeikaNensuuMax = pWSuiihyouParam.getKeisanWExtBean().getHknkkn();

        }
        else {

            wkKeikaNensuu = BizDateUtil.calcDifference(calcKijyunYmd, pWSuiihyouParam.getKeisanWExtBean().getKykymd())
                .getYears();

            wkKeikaNensuuMax = pWSuiihyouParam.getKeisanWExtBean().getHknkkn() - wkKeikaNensuu - 1;
        }

        GetKawaseRate getKawaseRate = SWAKInjector.getInstance(GetKawaseRate.class);

        BizNumber kawaserateCenter = BizNumber.ZERO;

        BizNumber kawaserateEndaka = BizNumber.ZERO;

        BizNumber kawaserateEnyasi = BizNumber.ZERO;

        BizNumber kawaserateHndhbEndaka = BizNumber.ZERO;

        BizNumber kawaserateHndhbEnyasu = BizNumber.ZERO;

        if (C_YouhiKbn.YOU.eq(yenkansannYhKbn)) {

            getKawaseRate.exec(
                pWSuiihyouParam.getKwsratekjymd(),
                C_KawaserateSyuruiKbn.KOUJIKAWASERATE,
                pWSuiihyouParam.getKeisanWExtBean().getTuukasyu(),
                C_Tuukasyu.JPY,
                C_KawasetekiyoKbn.TTM,
                C_KawasetsryKbn.NYUKINRATE,
                C_EigyoubiHoseiKbn.YOKUEIGYOUBI,
                C_YouhiKbn.HUYOU);

            kawaserateCenter = getKawaseRate.getKawaserate();

            kawaserateHndhbEndaka = YuyuHozenConfig.getInstance().getKawaserateHendouYenup();

            kawaserateHndhbEnyasu = YuyuHozenConfig.getInstance().getKawaserateHendouYendown();

            kawaserateEndaka = kawaserateCenter.subtract(kawaserateHndhbEndaka);

            kawaserateEnyasi = kawaserateCenter.add(kawaserateHndhbEnyasu);
        }

        BizNumber kaiyakuSjkTsRitu = pWSuiihyouParam.getKeisanWExtBean().getKyksjkkktyouseiriritu();

        BizNumber kaiyakuSjkTsRituUp = pWSuiihyouParam.getKeisanWExtBean().getKyksjkkktyouseiriritu()
            .add(YuyuHozenConfig.getInstance().getSuiihyouSjkkktusirrtUp());

        BizNumber kaiyakuSjkTsRituDown = pWSuiihyouParam.getKeisanWExtBean().getKyksjkkktyouseiriritu()
            .subtract(YuyuHozenConfig.getInstance().getSuiihyouSjkkktusirrtDown());

        BizDateYM tykznTmttkntaisyouymStart = pWSuiihyouParam.getKeisanWExtBean().getTmttkntaisyouym();

        BizDateYM tykznTmttkntaisyouym = tykznTmttkntaisyouymStart;

        List<IT_Suiihyou> suiihyouList = new ArrayList<>();

        suiihyouExtBeanLst = new ArrayList<>();

        List<BizDate> calcKijyunYmdList = new ArrayList<>();

        List<BizDateYM> calcKijyunYMList = new ArrayList<>();

        if(C_YouhiKbn.YOU.eq(jiyuSekkeiYhKbn)){
            if (jySekkeiYouTmmshanteiSisuuList.size() < wkKeikaNensuuMax){
                throw new CommonBizAppException(ERROR_MSG_4);
            }
        }

        for (int n = 0; n <= wkKeikaNensuuMax; n++) {

            KeisanWKijunYM keisanWKijunYM = SWAKInjector.getInstance(KeisanWKijunYM.class);

            BizDateYM kijyunYm = keisanWKijunYM.exec(
                pWSuiihyouParam.getKeisanWExtBean().getKykymd(),
                calcKijyunYmd,
                null,
                C_Hrkkaisuu.ITIJI,
                C_Kykjyoutai.ITIJIBARAI,
                pWSuiihyouParam.getKeisanWExtBean().getSyouhncd(),
                pWSuiihyouParam.getKeisanWExtBean().getYendthnkymd());

            calcKijyunYmdList.add(calcKijyunYmd);
            calcKijyunYMList.add(kijyunYm);

            C_MvaTekiyoujyoutaiKbn mvaTekiyoujyoutaiKbn = null;

            if ((C_SinsaihkKbn.SIN.eq(csinsaihkKbn) && n == wkKeikaNensuuMax) ||
                pWSuiihyouParam.getKeisanWExtBean().getYendthnkymd() != null){
                mvaTekiyoujyoutaiKbn = C_MvaTekiyoujyoutaiKbn.MVANONE;
            }
            else {

                mvaTekiyoujyoutaiKbn = C_MvaTekiyoujyoutaiKbn.MVAARI;
            }

            pWSuiihyouParam.getKeisanWExtBean().setTmttkntaisyouym(tykznTmttkntaisyouym);

            BizCurrency targetTkykKijyungk = pWSuiihyouParam.getTargetTkykKijyungk();

            HenkanTuuka henkanTuuka = SWAKInjector.getInstance(HenkanTuuka.class);

            String suiihyousyubetuTeiritu = null;

            BizCurrency mvaaritmttkgkkykkjmaeUp1 = null;

            BizCurrency mvaariwUp = null;

            BizCurrency mvaariwyenupyenkijyun = null;

            BizCurrency mvaariwyenupyendaka = null;

            BizCurrency mvaariwyenupyenyasu = null;

            BizCurrency mvaaritmttkgkkykkjmaeDown1 = null;

            BizCurrency mvaariwDown = null;

            BizCurrency mvaariwyendownyenkijyun = null;

            BizCurrency mvaariwyendownyendaka = null;

            BizCurrency mvaariwyendownyenyasu = null;

            BizNumber sisuuupritu1 = null;

            BizNumber tmttknzoukaritu1 = null;

            BizCurrency mvaariptumitatekin = null;

            BizCurrency tutmttknutiwake11 = null;

            BizCurrency tutmttknutiwake21 = null;

            BizCurrency mvaaritmttkgkkykkjmaesame1 = null;

            BizCurrency mvaariwsame = null;

            BizCurrency mvaariwyensameyenkijyun = null;

            BizCurrency mvaariwyensameyendaka = null;

            BizCurrency mvaariwyensameyenyasu = null;

            BizCurrency mvanonewsame = null;

            BizCurrency mvanonewtutakngk = null;

            BizCurrency mvanonewyensameyenkijyun = null;

            BizCurrency mvanonewyensameyendaka = null;

            BizCurrency mvanonewyensameyenyasu = null;

            BizCurrency mvaaritmttkgkkykkjmaeUp2 = null;

            BizCurrency mvaariwUp2 = null;

            BizCurrency mvaariwyenupyenkijyun2 = null;

            BizCurrency mvaariwyenupyendaka2 = null;

            BizCurrency mvaariwyenupyenyasu2 = null;

            BizCurrency mvaaritmttkgkkykkjmaeDown2 = null;

            BizCurrency mvaariwDown2 = null;

            BizCurrency mvaariwyendownyenkijyun2 = null;

            BizCurrency mvaariwyendownyendaka2 = null;

            BizCurrency mvaariwyendownyenyasu2 = null;

            BizNumber sisuuupritu2 = null;

            BizNumber tmttknzoukaritu2 = null;

            BizCurrency mvaariptumitatekin2 = null;

            BizCurrency tutmttknutiwake12 = null;

            BizCurrency tutmttknutiwake22 = null;

            BizCurrency mvaaritmttkgkkykkjmaesame2 = null;

            BizCurrency mvaariwsame2 = null;

            BizCurrency mvaariwyensameyenkijyun2 = null;

            BizCurrency mvaariwyensameyendaka2 = null;

            BizCurrency mvaariwyensameyenyasu2 = null;

            BizCurrency mvanonewsame2 = null;

            BizCurrency mvanonewtutakngk2 = null;

            BizCurrency mvanonewyensameyenkijyun2 = null;

            BizCurrency mvanonewyensameyendaka2 = null;

            BizCurrency mvanonewyensameyenyasu2 = null;

            BizCurrency mvaaritmttkgkkykkjmaeUp3 = null;

            BizCurrency mvaariwUp3 = null;

            BizCurrency mvaariwyenupyenkijyun3 = null;

            BizCurrency mvaariwyenupyendaka3 = null;

            BizCurrency mvaariwyenupyenyasu3 = null;

            BizCurrency mvaaritmttkgkkykkjmaeDown3 = null;

            BizCurrency mvaariwDown3 = null;

            BizCurrency mvaariwyendownyenkijyun3 = null;

            BizCurrency mvaariwyendownyendaka3 = null;

            BizCurrency mvaariwyendownyenyasu3 = null;

            BizNumber sisuuupritu3 = null;

            BizNumber tmttknzoukaritu3 = null;

            BizCurrency mvaariptumitatekin3 = null;

            BizCurrency tutmttknutiwake13 = null;

            BizCurrency tutmttknutiwake23 = null;

            BizCurrency mvaaritmttkgkkykkjmaesame3 = null;

            BizCurrency mvaariwsame3 = null;

            BizCurrency mvaariwyensameyenkijyun3 = null;

            BizCurrency mvaariwyensameyendaka3 = null;

            BizCurrency mvaariwyensameyenyasu3 = null;

            BizCurrency mvanonewsame3 = null;

            BizCurrency mvanonewtutakngk3 = null;

            BizCurrency mvanonewyensameyenkijyun3 = null;

            BizCurrency mvanonewyensameyendaka3 = null;

            BizCurrency mvanonewyensameyenyasu3 = null;

            if (C_TmttknhaibunjyoutaiKbn.TEIRITU_ONLY.eq(pWSuiihyouParam.getTmttknhaibunjyoutai())) {

                suiihyousyubetuTeiritu = SUIIHYOUSYUBETU_TEIRITU;

                sisuuupritu1 = BizNumber.ZERO;

                tmttknzoukaritu1 = BizNumber.ZERO;

                mvaariptumitatekin = pWSuiihyouParam.getKeisanWExtBean().getTeiritutmttkngk();

                tutmttknutiwake11 = pWSuiihyouParam.getKeisanWExtBean().getTeiritutmttkngk();

                tutmttknutiwake21 = BizCurrency.valueOf(0,
                    henkanTuuka.henkanTuukaKbnToType(pWSuiihyouParam.getKeisanWExtBean().getTuukasyu()));

                mvaaritmttkgkkykkjmaesame1 = BizCurrency.valueOf(0,
                    henkanTuuka.henkanTuukaKbnToType(pWSuiihyouParam.getKeisanWExtBean().getTuukasyu()));

                mvaariwsame = BizCurrency.valueOf(0,
                    henkanTuuka.henkanTuukaKbnToType(pWSuiihyouParam.getKeisanWExtBean().getTuukasyu()));

                mvaariwyensameyenkijyun = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);

                mvaariwyensameyendaka = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);

                mvaariwyensameyenyasu = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);

                mvanonewsame = BizCurrency.valueOf(0,
                    henkanTuuka.henkanTuukaKbnToType(pWSuiihyouParam.getKeisanWExtBean().getTuukasyu()));

                mvanonewtutakngk = BizCurrency.valueOf(0,
                    henkanTuuka.henkanTuukaKbnToType(pWSuiihyouParam.getKeisanWExtBean().getTuukasyu()));

                mvanonewyensameyenkijyun = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);

                mvanonewyensameyendaka = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);

                mvanonewyensameyenyasu = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);

                List<BizCurrency> mvaaritmttkgmvaariwlist = getTmttknTeirituKaiyakuhrkn(
                    mvaTekiyoujyoutaiKbn,
                    calcKijyunYmd,
                    kijyunYm,
                    kaiyakuSjkTsRitu,
                    pWSuiihyouParam.getKeisanWExtBean());

                mvaaritmttkgkkykkjmaesame1 = mvaaritmttkgmvaariwlist.get(0);

                mvaariwsame = mvaaritmttkgmvaariwlist.get(1);

                mvaariptumitatekin = mvaaritmttkgmvaariwlist.get(2);

                tutmttknutiwake11 = mvaaritmttkgmvaariwlist.get(2);

                List<BizCurrency> mvaariwyenlst = getKaiyakuhrknYenKnsn(
                    mvaariwsame,
                    kawaserateCenter,
                    kawaserateEndaka,
                    kawaserateEnyasi);

                if (C_MvaTekiyoujyoutaiKbn.MVAARI.eq(mvaTekiyoujyoutaiKbn)) {

                    mvaariwyensameyenkijyun = mvaariwyenlst.get(0);

                    mvaariwyensameyendaka = mvaariwyenlst.get(1);

                    mvaariwyensameyenyasu = mvaariwyenlst.get(2);
                }
                else {

                    mvanonewyensameyenkijyun = mvaariwyenlst.get(0);

                    mvanonewyensameyendaka = mvaariwyenlst.get(1);

                    mvanonewyensameyenyasu = mvaariwyenlst.get(2);

                    mvanonewsame = mvaariwsame;

                    mvanonewtutakngk = mvaaritmttkgkkykkjmaesame1;
                }

                mvaaritmttkgkkykkjmaeUp1 = BizCurrency.valueOf(0,
                    henkanTuuka.henkanTuukaKbnToType(pWSuiihyouParam.getKeisanWExtBean().getTuukasyu()));

                mvaariwUp = BizCurrency.valueOf(0,
                    henkanTuuka.henkanTuukaKbnToType(pWSuiihyouParam.getKeisanWExtBean().getTuukasyu()));

                mvaariwyenupyenkijyun = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);

                mvaariwyenupyendaka = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);

                mvaariwyenupyenyasu = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);

                mvaaritmttkgmvaariwlist = getTmttknTeirituKaiyakuhrkn(
                    mvaTekiyoujyoutaiKbn,
                    calcKijyunYmd,
                    kijyunYm,
                    kaiyakuSjkTsRituUp,
                    pWSuiihyouParam.getKeisanWExtBean());

                mvaaritmttkgkkykkjmaeUp1 = mvaaritmttkgmvaariwlist.get(0);

                mvaariwUp = mvaaritmttkgmvaariwlist.get(1);

                mvaariwyenlst = getKaiyakuhrknYenKnsn(
                    mvaariwUp,
                    kawaserateCenter,
                    kawaserateEndaka,
                    kawaserateEnyasi);

                mvaariwyenupyenkijyun = mvaariwyenlst.get(0);

                mvaariwyenupyendaka = mvaariwyenlst.get(1);

                mvaariwyenupyenyasu = mvaariwyenlst.get(2);

                mvaaritmttkgkkykkjmaeDown1 = BizCurrency.valueOf(0,
                    henkanTuuka.henkanTuukaKbnToType(pWSuiihyouParam.getKeisanWExtBean().getTuukasyu()));

                mvaariwDown = BizCurrency.valueOf(0,
                    henkanTuuka.henkanTuukaKbnToType(pWSuiihyouParam.getKeisanWExtBean().getTuukasyu()));

                mvaariwyendownyenkijyun = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);

                mvaariwyendownyendaka = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);

                mvaariwyendownyenyasu = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);

                mvaaritmttkgmvaariwlist = getTmttknTeirituKaiyakuhrkn(
                    mvaTekiyoujyoutaiKbn,
                    calcKijyunYmd,
                    kijyunYm,
                    kaiyakuSjkTsRituDown,
                    pWSuiihyouParam.getKeisanWExtBean());

                mvaaritmttkgkkykkjmaeDown1 = mvaaritmttkgmvaariwlist.get(0);

                mvaariwDown = mvaaritmttkgmvaariwlist.get(1);

                mvaariwyenlst = getKaiyakuhrknYenKnsn(
                    mvaariwDown,
                    kawaserateCenter,
                    kawaserateEndaka,
                    kawaserateEnyasi);

                mvaariwyendownyenkijyun = mvaariwyenlst.get(0);

                mvaariwyendownyendaka = mvaariwyenlst.get(1);

                mvaariwyendownyenyasu = mvaariwyenlst.get(2);

                pWSuiihyouParam.getKeisanWExtBean().setTeiritutmttkngk(mvaariptumitatekin);

            }
            else if (C_TmttknhaibunjyoutaiKbn.SISUU_ONLY.eq(pWSuiihyouParam.getTmttknhaibunjyoutai()) ||
                C_TmttknhaibunjyoutaiKbn.SISUUTEIRITU.eq(pWSuiihyouParam.getTmttknhaibunjyoutai())) {

                if (C_TmttknhaibunjyoutaiKbn.SISUU_ONLY.eq(pWSuiihyouParam.getTmttknhaibunjyoutai())){
                    suiihyousyubetuTeiritu = SUIIHYOUSYUBETU_SISUU;
                }
                else{
                    suiihyousyubetuTeiritu = SUIIHYOUSYUBETU_KONGOU;
                }

                sisuuupritu1 = BizNumber.ZERO;

                tmttknzoukaritu1 = BizNumber.ZERO;

                mvaariptumitatekin = BizCurrency.valueOf(0,
                    henkanTuuka.henkanTuukaKbnToType(pWSuiihyouParam.getKeisanWExtBean().getTuukasyu()));

                tutmttknutiwake11 = BizCurrency.valueOf(0,
                    henkanTuuka.henkanTuukaKbnToType(pWSuiihyouParam.getKeisanWExtBean().getTuukasyu()));

                tutmttknutiwake21 = BizCurrency.valueOf(0,
                    henkanTuuka.henkanTuukaKbnToType(pWSuiihyouParam.getKeisanWExtBean().getTuukasyu()));

                if (n == 0) {

                    tykzentmmshanteiymdSisuuUpDown = pWSuiihyouParam.getKeisanWExtBean().getTmttknhaneisisuu();

                    tmmshanteiymdSisuuUpDown = pWSuiihyouParam.getKeisanWExtBean().getTmttknhaneisisuu();

                    sisuurendoutmttkngkUpDown = pWSuiihyouParam.getKeisanWExtBean().getSisuurendoutmttkngk();

                }

                if (C_SinsaihkKbn.SAI.eq(csinsaihkKbn) ||
                    (C_SinsaihkKbn.SIN.eq(csinsaihkKbn) && n != 0)) {

                    if ((n + saihktysinen) % 2 == 0) {

                        tykzentmmshanteiymdSisuuUpDown = tmmshanteiymdSisuuUpDown;

                        tmmshanteiymdSisuuUpDown = tmmshanteiymdSisuuUpDown.multiply(TMMSHANTEIYMD_SISUU_UPDOWN_DOWN,
                            4, RoundingMode.DOWN);

                    }
                    else {

                        tykzentmmshanteiymdSisuuUpDown = tmmshanteiymdSisuuUpDown;

                        tmmshanteiymdSisuuUpDown = tmmshanteiymdSisuuUpDown.multiply(TMMSHANTEIYMD_SISUU_UPDOWN_UP,
                            4, RoundingMode.UP);

                    }

                    KeisanTmHntiSisuuRendouTmttkn keisanTmHntiSisuuRendouTmttkn = SWAKInjector
                        .getInstance(KeisanTmHntiSisuuRendouTmttkn.class);

                    C_ErrorKbn errorKbn = keisanTmHntiSisuuRendouTmttkn.exec(
                        pWSuiihyouParam.getKeisanWExtBean().getSyouhncd(),
                        pWSuiihyouParam.getKeisanWExtBean().getTuukasyu(),
                        tmmshanteiymdSisuuUpDown,
                        tykzentmmshanteiymdSisuuUpDown,
                        pWSuiihyouParam.getSetteiBairitu(),
                        pWSuiihyouParam.getTmttknZoukarituJygn(),
                        sisuurendoutmttkngkUpDown,
                        BizNumber.ZERO);

                    if (C_ErrorKbn.ERROR.eq(errorKbn)) {

                        throw new CommonBizAppException(ERROR_MSG_2);
                    }

                    sisuuupritu1 = keisanTmHntiSisuuRendouTmttkn.getSisuuUpRitu().round(2, RoundingMode.DOWN);

                    tmttknzoukaritu1 = keisanTmHntiSisuuRendouTmttkn.getTmttknZoukaRitu();

                    sisuurendoutmttkngkUpDown = keisanTmHntiSisuuRendouTmttkn.getSisuurendoutmttkngk();
                }

                mvaariptumitatekin = pWSuiihyouParam.getKeisanWExtBean().getTeiritutmttkngk()
                    .add(sisuurendoutmttkngkUpDown);

                tutmttknutiwake11 = pWSuiihyouParam.getKeisanWExtBean().getTeiritutmttkngk();

                tutmttknutiwake21 = sisuurendoutmttkngkUpDown;

                mvaaritmttkgkkykkjmaesame1 = BizCurrency.valueOf(0,
                    henkanTuuka.henkanTuukaKbnToType(pWSuiihyouParam.getKeisanWExtBean().getTuukasyu()));

                mvaariwsame = BizCurrency.valueOf(0,
                    henkanTuuka.henkanTuukaKbnToType(pWSuiihyouParam.getKeisanWExtBean().getTuukasyu()));

                mvaariwyensameyenkijyun = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);

                mvaariwyensameyendaka = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);

                mvaariwyensameyenyasu = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);

                mvanonewsame = BizCurrency.valueOf(0,
                    henkanTuuka.henkanTuukaKbnToType(pWSuiihyouParam.getKeisanWExtBean().getTuukasyu()));

                mvanonewtutakngk = BizCurrency.valueOf(0,
                    henkanTuuka.henkanTuukaKbnToType(pWSuiihyouParam.getKeisanWExtBean().getTuukasyu()));

                mvanonewyensameyenkijyun = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);

                mvanonewyensameyendaka = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);

                mvanonewyensameyenyasu = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);

                List<BizCurrency> mvaaritmttkgmvaariwlist = getTmttknSisuuKaiyakuhrkn(
                    mvaTekiyoujyoutaiKbn,
                    calcKijyunYmd,
                    kijyunYm,
                    kaiyakuSjkTsRitu,
                    sisuurendoutmttkngkUpDown,
                    pWSuiihyouParam.getKeisanWExtBean());

                mvaaritmttkgkkykkjmaesame1 = mvaaritmttkgmvaariwlist.get(0);

                mvaariwsame = mvaaritmttkgmvaariwlist.get(1);

                List<BizCurrency> mvaariwyenlst = getKaiyakuhrknYenKnsn(
                    mvaariwsame,
                    kawaserateCenter,
                    kawaserateEndaka,
                    kawaserateEnyasi);

                if (C_MvaTekiyoujyoutaiKbn.MVAARI.eq(mvaTekiyoujyoutaiKbn)) {

                    mvaariwyensameyenkijyun = mvaariwyenlst.get(0);

                    mvaariwyensameyendaka = mvaariwyenlst.get(1);

                    mvaariwyensameyenyasu = mvaariwyenlst.get(2);
                }
                else {

                    mvanonewyensameyenkijyun = mvaariwyenlst.get(0);

                    mvanonewyensameyendaka = mvaariwyenlst.get(1);

                    mvanonewyensameyenyasu = mvaariwyenlst.get(2);

                    mvanonewsame = mvaariwsame;

                    mvanonewtutakngk = mvaaritmttkgkkykkjmaesame1;
                }

                mvaaritmttkgkkykkjmaeUp1 = BizCurrency.valueOf(0,
                    henkanTuuka.henkanTuukaKbnToType(pWSuiihyouParam.getKeisanWExtBean().getTuukasyu()));

                mvaariwUp = BizCurrency.valueOf(0,
                    henkanTuuka.henkanTuukaKbnToType(pWSuiihyouParam.getKeisanWExtBean().getTuukasyu()));

                mvaariwyenupyenkijyun = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);

                mvaariwyenupyendaka = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);

                mvaariwyenupyenyasu = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);

                mvaaritmttkgmvaariwlist = getTmttknSisuuKaiyakuhrkn(
                    mvaTekiyoujyoutaiKbn,
                    calcKijyunYmd,
                    kijyunYm,
                    kaiyakuSjkTsRituUp,
                    sisuurendoutmttkngkUpDown,
                    pWSuiihyouParam.getKeisanWExtBean());

                mvaaritmttkgkkykkjmaeUp1 = mvaaritmttkgmvaariwlist.get(0);

                mvaariwUp = mvaaritmttkgmvaariwlist.get(1);

                mvaariwyenlst = getKaiyakuhrknYenKnsn(
                    mvaariwUp,
                    kawaserateCenter,
                    kawaserateEndaka,
                    kawaserateEnyasi);

                mvaariwyenupyenkijyun = mvaariwyenlst.get(0);

                mvaariwyenupyendaka = mvaariwyenlst.get(1);

                mvaariwyenupyenyasu = mvaariwyenlst.get(2);

                mvaaritmttkgkkykkjmaeDown1 = BizCurrency.valueOf(0,
                    henkanTuuka.henkanTuukaKbnToType(pWSuiihyouParam.getKeisanWExtBean().getTuukasyu()));

                mvaariwDown = BizCurrency.valueOf(0,
                    henkanTuuka.henkanTuukaKbnToType(pWSuiihyouParam.getKeisanWExtBean().getTuukasyu()));

                mvaariwyendownyenkijyun = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);

                mvaariwyendownyendaka = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);

                mvaariwyendownyenyasu = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);

                mvaaritmttkgmvaariwlist = getTmttknSisuuKaiyakuhrkn(
                    mvaTekiyoujyoutaiKbn,
                    calcKijyunYmd,
                    kijyunYm,
                    kaiyakuSjkTsRituDown,
                    sisuurendoutmttkngkUpDown,
                    pWSuiihyouParam.getKeisanWExtBean());

                mvaaritmttkgkkykkjmaeDown1 = mvaaritmttkgmvaariwlist.get(0);

                mvaariwDown = mvaaritmttkgmvaariwlist.get(1);

                mvaariwyenlst = getKaiyakuhrknYenKnsn(
                    mvaariwDown,
                    kawaserateCenter,
                    kawaserateEndaka,
                    kawaserateEnyasi);

                mvaariwyendownyenkijyun = mvaariwyenlst.get(0);

                mvaariwyendownyendaka = mvaariwyenlst.get(1);

                mvaariwyendownyenyasu = mvaariwyenlst.get(2);

                sisuuupritu2 = BizNumber.ZERO;

                tmttknzoukaritu2 = BizNumber.ZERO;

                mvaariptumitatekin2 = BizCurrency.valueOf(0,
                    henkanTuuka.henkanTuukaKbnToType(pWSuiihyouParam.getKeisanWExtBean().getTuukasyu()));

                tutmttknutiwake12 = BizCurrency.valueOf(0,
                    henkanTuuka.henkanTuukaKbnToType(pWSuiihyouParam.getKeisanWExtBean().getTuukasyu()));

                tutmttknutiwake22 = BizCurrency.valueOf(0,
                    henkanTuuka.henkanTuukaKbnToType(pWSuiihyouParam.getKeisanWExtBean().getTuukasyu()));

                if (n == 0) {

                    tykzentmmshanteiymdSisuuDown = pWSuiihyouParam.getKeisanWExtBean().getTmttknhaneisisuu();

                    tmmshanteiymdSisuuDown = pWSuiihyouParam.getKeisanWExtBean().getTmttknhaneisisuu();

                    sisuurendoutmttkngkDown = pWSuiihyouParam.getKeisanWExtBean().getSisuurendoutmttkngk();

                }

                if (C_SinsaihkKbn.SAI.eq(csinsaihkKbn) ||
                    (C_SinsaihkKbn.SIN.eq(csinsaihkKbn) && n != 0)) {

                    tykzentmmshanteiymdSisuuDown = tmmshanteiymdSisuuDown;

                    tmmshanteiymdSisuuDown = tmmshanteiymdSisuuDown.multiply(TMMSHANTEIYMD_SISUU_DOWN,
                        4, RoundingMode.DOWN);

                    KeisanTmHntiSisuuRendouTmttkn keisanTmHntiSisuuRendouTmttkn = SWAKInjector
                        .getInstance(KeisanTmHntiSisuuRendouTmttkn.class);

                    C_ErrorKbn errorKbn = keisanTmHntiSisuuRendouTmttkn.exec(
                        pWSuiihyouParam.getKeisanWExtBean().getSyouhncd(),
                        pWSuiihyouParam.getKeisanWExtBean().getTuukasyu(),
                        tmmshanteiymdSisuuDown,
                        tykzentmmshanteiymdSisuuDown,
                        pWSuiihyouParam.getSetteiBairitu(),
                        pWSuiihyouParam.getTmttknZoukarituJygn(),
                        sisuurendoutmttkngkDown,
                        BizNumber.ZERO);

                    if (C_ErrorKbn.ERROR.eq(errorKbn)) {

                        throw new CommonBizAppException(ERROR_MSG_2);
                    }

                    sisuuupritu2 = keisanTmHntiSisuuRendouTmttkn.getSisuuUpRitu().round(2, RoundingMode.DOWN);

                    tmttknzoukaritu2 = keisanTmHntiSisuuRendouTmttkn.getTmttknZoukaRitu();

                    sisuurendoutmttkngkDown = keisanTmHntiSisuuRendouTmttkn.getSisuurendoutmttkngk();
                }

                mvaariptumitatekin2 = pWSuiihyouParam.getKeisanWExtBean().getTeiritutmttkngk()
                    .add(sisuurendoutmttkngkDown);

                tutmttknutiwake12 = pWSuiihyouParam.getKeisanWExtBean().getTeiritutmttkngk();

                tutmttknutiwake22 = sisuurendoutmttkngkDown;

                mvaaritmttkgkkykkjmaesame2 = BizCurrency.valueOf(0,
                    henkanTuuka.henkanTuukaKbnToType(pWSuiihyouParam.getKeisanWExtBean().getTuukasyu()));

                mvaariwsame2 = BizCurrency.valueOf(0,
                    henkanTuuka.henkanTuukaKbnToType(pWSuiihyouParam.getKeisanWExtBean().getTuukasyu()));

                mvaariwyensameyenkijyun2 = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);

                mvaariwyensameyendaka2 = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);

                mvaariwyensameyenyasu2 = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);

                mvanonewsame2 = BizCurrency.valueOf(0,
                    henkanTuuka.henkanTuukaKbnToType(pWSuiihyouParam.getKeisanWExtBean().getTuukasyu()));

                mvanonewtutakngk2 = BizCurrency.valueOf(0,
                    henkanTuuka.henkanTuukaKbnToType(pWSuiihyouParam.getKeisanWExtBean().getTuukasyu()));

                mvanonewyensameyenkijyun2 = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);

                mvanonewyensameyendaka2 = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);

                mvanonewyensameyenyasu2 = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);

                mvaaritmttkgmvaariwlist = getTmttknSisuuKaiyakuhrkn(
                    mvaTekiyoujyoutaiKbn,
                    calcKijyunYmd,
                    kijyunYm,
                    kaiyakuSjkTsRitu,
                    sisuurendoutmttkngkDown,
                    pWSuiihyouParam.getKeisanWExtBean());

                mvaaritmttkgkkykkjmaesame2 = mvaaritmttkgmvaariwlist.get(0);

                mvaariwsame2 = mvaaritmttkgmvaariwlist.get(1);

                mvaariwyenlst = getKaiyakuhrknYenKnsn(
                    mvaariwsame2,
                    kawaserateCenter,
                    kawaserateEndaka,
                    kawaserateEnyasi);

                if (C_MvaTekiyoujyoutaiKbn.MVAARI.eq(mvaTekiyoujyoutaiKbn)) {

                    mvaariwyensameyenkijyun2 = mvaariwyenlst.get(0);

                    mvaariwyensameyendaka2 = mvaariwyenlst.get(1);

                    mvaariwyensameyenyasu2 = mvaariwyenlst.get(2);
                }
                else {

                    mvanonewyensameyenkijyun2 = mvaariwyenlst.get(0);

                    mvanonewyensameyendaka2 = mvaariwyenlst.get(1);

                    mvanonewyensameyenyasu2 = mvaariwyenlst.get(2);

                    mvanonewsame2 = mvaariwsame2;

                    mvanonewtutakngk2 = mvaaritmttkgkkykkjmaesame2;
                }

                mvaaritmttkgkkykkjmaeUp2 = BizCurrency.valueOf(0,
                    henkanTuuka.henkanTuukaKbnToType(pWSuiihyouParam.getKeisanWExtBean().getTuukasyu()));

                mvaariwUp2 = BizCurrency.valueOf(0,
                    henkanTuuka.henkanTuukaKbnToType(pWSuiihyouParam.getKeisanWExtBean().getTuukasyu()));

                mvaariwyenupyenkijyun2 = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);

                mvaariwyenupyendaka2 = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);

                mvaariwyenupyenyasu2 = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);

                mvaaritmttkgmvaariwlist = getTmttknSisuuKaiyakuhrkn(
                    mvaTekiyoujyoutaiKbn,
                    calcKijyunYmd,
                    kijyunYm,
                    kaiyakuSjkTsRituUp,
                    sisuurendoutmttkngkDown,
                    pWSuiihyouParam.getKeisanWExtBean());

                mvaaritmttkgkkykkjmaeUp2 = mvaaritmttkgmvaariwlist.get(0);

                mvaariwUp2 = mvaaritmttkgmvaariwlist.get(1);

                mvaariwyenlst = getKaiyakuhrknYenKnsn(
                    mvaariwUp2,
                    kawaserateCenter,
                    kawaserateEndaka,
                    kawaserateEnyasi);

                mvaariwyenupyenkijyun2 = mvaariwyenlst.get(0);

                mvaariwyenupyendaka2 = mvaariwyenlst.get(1);

                mvaariwyenupyenyasu2 = mvaariwyenlst.get(2);

                mvaaritmttkgkkykkjmaeDown2 = BizCurrency.valueOf(0,
                    henkanTuuka.henkanTuukaKbnToType(pWSuiihyouParam.getKeisanWExtBean().getTuukasyu()));

                mvaariwDown2 = BizCurrency.valueOf(0,
                    henkanTuuka.henkanTuukaKbnToType(pWSuiihyouParam.getKeisanWExtBean().getTuukasyu()));

                mvaariwyendownyenkijyun2 = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);

                mvaariwyendownyendaka2 = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);

                mvaariwyendownyenyasu2 = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);

                mvaaritmttkgmvaariwlist = getTmttknSisuuKaiyakuhrkn(
                    mvaTekiyoujyoutaiKbn,
                    calcKijyunYmd,
                    kijyunYm,
                    kaiyakuSjkTsRituDown,
                    sisuurendoutmttkngkDown,
                    pWSuiihyouParam.getKeisanWExtBean());

                mvaaritmttkgkkykkjmaeDown2 = mvaaritmttkgmvaariwlist.get(0);

                mvaariwDown2 = mvaaritmttkgmvaariwlist.get(1);

                mvaariwyenlst = getKaiyakuhrknYenKnsn(
                    mvaariwDown2,
                    kawaserateCenter,
                    kawaserateEndaka,
                    kawaserateEnyasi);

                mvaariwyendownyenkijyun2 = mvaariwyenlst.get(0);

                mvaariwyendownyendaka2 = mvaariwyenlst.get(1);

                mvaariwyendownyenyasu2 = mvaariwyenlst.get(2);

                sisuuupritu3 = BizNumber.ZERO;

                tmttknzoukaritu3 = BizNumber.ZERO;

                mvaariptumitatekin3 = BizCurrency.valueOf(0,
                    henkanTuuka.henkanTuukaKbnToType(pWSuiihyouParam.getKeisanWExtBean().getTuukasyu()));

                tutmttknutiwake13 = BizCurrency.valueOf(0,
                    henkanTuuka.henkanTuukaKbnToType(pWSuiihyouParam.getKeisanWExtBean().getTuukasyu()));

                tutmttknutiwake23 = BizCurrency.valueOf(0,
                    henkanTuuka.henkanTuukaKbnToType(pWSuiihyouParam.getKeisanWExtBean().getTuukasyu()));

                if (n == 0) {

                    tykzentmmshanteiymdSisuuUp = pWSuiihyouParam.getKeisanWExtBean().getTmttknhaneisisuu();

                    tmmshanteiymdSisuuUp = pWSuiihyouParam.getKeisanWExtBean().getTmttknhaneisisuu();

                    sisuurendoutmttkngkUp = pWSuiihyouParam.getKeisanWExtBean().getSisuurendoutmttkngk();

                }

                if (C_SinsaihkKbn.SAI.eq(csinsaihkKbn) ||
                    (C_SinsaihkKbn.SIN.eq(csinsaihkKbn) && n != 0)) {

                    tykzentmmshanteiymdSisuuUp = tmmshanteiymdSisuuUp;

                    tmmshanteiymdSisuuUp = tmmshanteiymdSisuuUp.multiply(TMMSHANTEIYMD_SISUU_UP,
                        4, RoundingMode.UP);

                    KeisanTmHntiSisuuRendouTmttkn keisanTmHntiSisuuRendouTmttkn = SWAKInjector
                        .getInstance(KeisanTmHntiSisuuRendouTmttkn.class);

                    C_ErrorKbn errorKbn = keisanTmHntiSisuuRendouTmttkn.exec(
                        pWSuiihyouParam.getKeisanWExtBean().getSyouhncd(),
                        pWSuiihyouParam.getKeisanWExtBean().getTuukasyu(),
                        tmmshanteiymdSisuuUp,
                        tykzentmmshanteiymdSisuuUp,
                        pWSuiihyouParam.getSetteiBairitu(),
                        pWSuiihyouParam.getTmttknZoukarituJygn(),
                        sisuurendoutmttkngkUp,
                        BizNumber.ZERO);

                    if (C_ErrorKbn.ERROR.eq(errorKbn)) {

                        throw new CommonBizAppException(ERROR_MSG_2);
                    }

                    sisuuupritu3 = keisanTmHntiSisuuRendouTmttkn.getSisuuUpRitu().round(2, RoundingMode.DOWN);

                    tmttknzoukaritu3 = keisanTmHntiSisuuRendouTmttkn.getTmttknZoukaRitu();

                    sisuurendoutmttkngkUp = keisanTmHntiSisuuRendouTmttkn.getSisuurendoutmttkngk();
                }

                mvaariptumitatekin3 = pWSuiihyouParam.getKeisanWExtBean().getTeiritutmttkngk()
                    .add(sisuurendoutmttkngkUp);

                tutmttknutiwake13 = pWSuiihyouParam.getKeisanWExtBean().getTeiritutmttkngk();

                tutmttknutiwake23 = sisuurendoutmttkngkUp;

                mvaaritmttkgkkykkjmaesame3 = BizCurrency.valueOf(0,
                    henkanTuuka.henkanTuukaKbnToType(pWSuiihyouParam.getKeisanWExtBean().getTuukasyu()));

                mvaariwsame3 = BizCurrency.valueOf(0,
                    henkanTuuka.henkanTuukaKbnToType(pWSuiihyouParam.getKeisanWExtBean().getTuukasyu()));

                mvaariwyensameyenkijyun3 = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);

                mvaariwyensameyendaka3 = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);

                mvaariwyensameyenyasu3 = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);

                mvanonewsame3 = BizCurrency.valueOf(0,
                    henkanTuuka.henkanTuukaKbnToType(pWSuiihyouParam.getKeisanWExtBean().getTuukasyu()));

                mvanonewtutakngk3 = BizCurrency.valueOf(0,
                    henkanTuuka.henkanTuukaKbnToType(pWSuiihyouParam.getKeisanWExtBean().getTuukasyu()));

                mvanonewyensameyenkijyun3 = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);

                mvanonewyensameyendaka3 = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);

                mvanonewyensameyenyasu3 = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);

                mvaaritmttkgmvaariwlist = getTmttknSisuuKaiyakuhrkn(
                    mvaTekiyoujyoutaiKbn,
                    calcKijyunYmd,
                    kijyunYm,
                    kaiyakuSjkTsRitu,
                    sisuurendoutmttkngkUp,
                    pWSuiihyouParam.getKeisanWExtBean());

                mvaaritmttkgkkykkjmaesame3 = mvaaritmttkgmvaariwlist.get(0);

                mvaariwsame3 = mvaaritmttkgmvaariwlist.get(1);

                mvaariwyenlst = getKaiyakuhrknYenKnsn(
                    mvaariwsame3,
                    kawaserateCenter,
                    kawaserateEndaka,
                    kawaserateEnyasi);

                if (C_MvaTekiyoujyoutaiKbn.MVAARI.eq(mvaTekiyoujyoutaiKbn)) {

                    mvaariwyensameyenkijyun3 = mvaariwyenlst.get(0);

                    mvaariwyensameyendaka3 = mvaariwyenlst.get(1);

                    mvaariwyensameyenyasu3 = mvaariwyenlst.get(2);
                }
                else {

                    mvanonewyensameyenkijyun3 = mvaariwyenlst.get(0);

                    mvanonewyensameyendaka3 = mvaariwyenlst.get(1);

                    mvanonewyensameyenyasu3 = mvaariwyenlst.get(2);

                    mvanonewsame3 = mvaariwsame3;

                    mvanonewtutakngk3 = mvaaritmttkgkkykkjmaesame3;
                }

                mvaaritmttkgkkykkjmaeUp3 = BizCurrency.valueOf(0,
                    henkanTuuka.henkanTuukaKbnToType(pWSuiihyouParam.getKeisanWExtBean().getTuukasyu()));

                mvaariwUp3 = BizCurrency.valueOf(0,
                    henkanTuuka.henkanTuukaKbnToType(pWSuiihyouParam.getKeisanWExtBean().getTuukasyu()));

                mvaariwyenupyenkijyun3 = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);

                mvaariwyenupyendaka3 = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);

                mvaariwyenupyenyasu3 = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);

                mvaaritmttkgmvaariwlist = getTmttknSisuuKaiyakuhrkn(
                    mvaTekiyoujyoutaiKbn,
                    calcKijyunYmd,
                    kijyunYm,
                    kaiyakuSjkTsRituUp,
                    sisuurendoutmttkngkUp,
                    pWSuiihyouParam.getKeisanWExtBean());

                mvaaritmttkgkkykkjmaeUp3 = mvaaritmttkgmvaariwlist.get(0);

                mvaariwUp3 = mvaaritmttkgmvaariwlist.get(1);

                mvaariwyenlst = getKaiyakuhrknYenKnsn(
                    mvaariwUp3,
                    kawaserateCenter,
                    kawaserateEndaka,
                    kawaserateEnyasi);

                mvaariwyenupyenkijyun3 = mvaariwyenlst.get(0);

                mvaariwyenupyendaka3 = mvaariwyenlst.get(1);

                mvaariwyenupyenyasu3 = mvaariwyenlst.get(2);

                mvaaritmttkgkkykkjmaeDown3 = BizCurrency.valueOf(0,
                    henkanTuuka.henkanTuukaKbnToType(pWSuiihyouParam.getKeisanWExtBean().getTuukasyu()));

                mvaariwDown3 = BizCurrency.valueOf(0,
                    henkanTuuka.henkanTuukaKbnToType(pWSuiihyouParam.getKeisanWExtBean().getTuukasyu()));

                mvaariwyendownyenkijyun3 = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);

                mvaariwyendownyendaka3 = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);

                mvaariwyendownyenyasu3 = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);

                mvaaritmttkgmvaariwlist = getTmttknSisuuKaiyakuhrkn(
                    mvaTekiyoujyoutaiKbn,
                    calcKijyunYmd,
                    kijyunYm,
                    kaiyakuSjkTsRituDown,
                    sisuurendoutmttkngkUp,
                    pWSuiihyouParam.getKeisanWExtBean());

                mvaaritmttkgkkykkjmaeDown3 = mvaaritmttkgmvaariwlist.get(0);

                mvaariwDown3 = mvaaritmttkgmvaariwlist.get(1);

                mvaariwyenlst = getKaiyakuhrknYenKnsn(
                    mvaariwDown3,
                    kawaserateCenter,
                    kawaserateEndaka,
                    kawaserateEnyasi);

                mvaariwyendownyenkijyun3 = mvaariwyenlst.get(0);

                mvaariwyendownyendaka3 = mvaariwyenlst.get(1);

                mvaariwyendownyenyasu3 = mvaariwyenlst.get(2);
            }
            else {

                suiihyousyubetuTeiritu = SUIIHYOUSYUBETU_YENDATE;

                mvanonewsame = BizCurrency.valueOf(0,
                    henkanTuuka.henkanTuukaKbnToType(pWSuiihyouParam.getKeisanWExtBean().getTuukasyu()));

                KeisanW keisanW = SWAKInjector.getInstance(KeisanW.class);

                C_ErrorKbn errorKbn = keisanW.exec(calcKijyunYmd, kijyunYm, pWSuiihyouParam.getKeisanWExtBean());

                if (C_ErrorKbn.ERROR.eq(errorKbn)) {

                    throw new CommonBizAppException(ERROR_MSG);
                }

                mvanonewsame = keisanW.getW();
            }

            IT_Suiihyou suiihyou = new IT_Suiihyou();

            suiihyou.setKeikanensuu(wkKeikaNensuu);
            suiihyou.setCalckijyunymd(calcKijyunYmd);

            if (rekijyouSyuuseiUmu == 1) {
                suiihyou.setCalcym(calcKijyunYmd.getPreviousMonth().getBizDateYM());
            }
            else {
                suiihyou.setCalcym(calcKijyunYmd.getBizDateYM());
            }

            suiihyou.setMvatekijyoutaikbn(mvaTekiyoujyoutaiKbn);
            suiihyou.setMkhyouyensysnikougk(targetTkykKijyungk);
            suiihyou.setSuiihyousyubetu(suiihyousyubetuTeiritu);
            suiihyou.setYenknsnkwsrateyendaka(kawaserateEndaka);
            suiihyou.setYenknsnkwsrateyenkijyun(kawaserateCenter);
            suiihyou.setYenknsnkwsrateyenyasu(kawaserateEnyasi);
            suiihyou.setYenknsnkwsrategkyendaka(
                BizCurrency.valueOf(new BigDecimal(kawaserateHndhbEndaka.toString()), BizCurrencyTypes.YEN));
            suiihyou.setYenknsnkwsrategkyenyasu(
                BizCurrency.valueOf(new BigDecimal(kawaserateHndhbEnyasu.toString()), BizCurrencyTypes.YEN));
            suiihyou.setSisuuupritu1(sisuuupritu1);
            suiihyou.setTmttknzoukaritu1(tmttknzoukaritu1);
            suiihyou.setTutmttknutiwake11(tutmttknutiwake11);
            suiihyou.setTutmttknutiwake21(tutmttknutiwake21);
            suiihyou.setYenknsnkwsrateyendaka2(kawaserateEndaka);
            suiihyou.setYenknsnkwsrateyenkijyun2(kawaserateCenter);
            suiihyou.setYenknsnkwsrateyenyasu2(kawaserateEnyasi);
            suiihyou.setYenknsnkwsrategkyendaka2(
                BizCurrency.valueOf(new BigDecimal(kawaserateHndhbEndaka.toString()), BizCurrencyTypes.YEN));
            suiihyou.setYenknsnkwsrategkyenyasu2(
                BizCurrency.valueOf(new BigDecimal(kawaserateHndhbEnyasu.toString()), BizCurrencyTypes.YEN));
            suiihyou.setSisuuupritu2(sisuuupritu2);
            suiihyou.setTmttknzoukaritu2(tmttknzoukaritu2);
            suiihyou.setTutmttknutiwake12(tutmttknutiwake12);
            suiihyou.setTutmttknutiwake22(tutmttknutiwake22);
            suiihyou.setYenknsnkwsrateyendaka3(kawaserateEndaka);
            suiihyou.setYenknsnkwsrateyenkijyun3(kawaserateCenter);
            suiihyou.setYenknsnkwsrateyenyasu3(kawaserateEnyasi);
            suiihyou.setYenknsnkwsrategkyendaka3(
                BizCurrency.valueOf(new BigDecimal(kawaserateHndhbEndaka.toString()), BizCurrencyTypes.YEN));
            suiihyou.setYenknsnkwsrategkyenyasu3(
                BizCurrency.valueOf(new BigDecimal(kawaserateHndhbEnyasu.toString()), BizCurrencyTypes.YEN));
            suiihyou.setSisuuupritu3(sisuuupritu3);
            suiihyou.setTmttknzoukaritu3(tmttknzoukaritu3);
            suiihyou.setTutmttknutiwake13(tutmttknutiwake13);
            suiihyou.setTutmttknutiwake23(tutmttknutiwake23);

            if (C_MvaTekiyoujyoutaiKbn.MVAARI.eq(mvaTekiyoujyoutaiKbn)) {

                suiihyou.setSjkkktusirrtup(kaiyakuSjkTsRituUp);
                suiihyou.setSjkkktusirrtsame(kaiyakuSjkTsRitu);
                suiihyou.setSjkkktusirrtdown(kaiyakuSjkTsRituDown);
                suiihyou.setSjkkktusirrthendouup(YuyuHozenConfig.getInstance().getSuiihyouYoteirirituUp());
                suiihyou.setSjkkktusirrthendoudown(YuyuHozenConfig.getInstance().getSuiihyouYoteirirituDown());
                suiihyou.setMvaariptumitatekin(mvaariptumitatekin);
                suiihyou.setMvaaritmttkgkkykkjmaeup1(mvaaritmttkgkkykkjmaeUp1);
                suiihyou.setMvaaritmttkgkkykkjmaesame1(mvaaritmttkgkkykkjmaesame1);
                suiihyou.setMvaaritmttkgkkykkjmaedown1(mvaaritmttkgkkykkjmaeDown1);
                suiihyou.setMvaariwup(mvaariwUp);
                suiihyou.setMvaariwsame(mvaariwsame);
                suiihyou.setMvaariwdown(mvaariwDown);
                suiihyou.setMvaariwyenupyendaka(mvaariwyenupyendaka);
                suiihyou.setMvaariwyenupyenkijyun(mvaariwyenupyenkijyun);
                suiihyou.setMvaariwyenupyenyasu(mvaariwyenupyenyasu);
                suiihyou.setMvaariwyensameyendaka(mvaariwyensameyendaka);
                suiihyou.setMvaariwyensameyenkijyun(mvaariwyensameyenkijyun);
                suiihyou.setMvaariwyensameyenyasu(mvaariwyensameyenyasu);
                suiihyou.setMvaariwyendownyendaka(mvaariwyendownyendaka);
                suiihyou.setMvaariwyendownyenkijyun(mvaariwyendownyenkijyun);
                suiihyou.setMvaariwyendownyenyasu(mvaariwyendownyenyasu);
                suiihyou.setSjkkktusirrtup2(kaiyakuSjkTsRituUp);
                suiihyou.setSjkkktusirrtsame2(kaiyakuSjkTsRitu);
                suiihyou.setSjkkktusirrtdown2(kaiyakuSjkTsRituDown);
                suiihyou.setSjkkktusirrthendouup2(YuyuHozenConfig.getInstance().getSuiihyouYoteirirituUp());
                suiihyou.setSjkkktusirrthendoudown2(YuyuHozenConfig.getInstance().getSuiihyouYoteirirituDown());
                suiihyou.setMvaariptumitatekin2(mvaariptumitatekin2);
                suiihyou.setMvaaritmttkgkkykkjmaeup2(mvaaritmttkgkkykkjmaeUp2);
                suiihyou.setMvaaritmttkgkkykkjmaesame2(mvaaritmttkgkkykkjmaesame2);
                suiihyou.setMvaaritmttkgkkykkjmaedown2(mvaaritmttkgkkykkjmaeDown2);
                suiihyou.setMvaariwup2(mvaariwUp2);
                suiihyou.setMvaariwsame2(mvaariwsame2);
                suiihyou.setMvaariwdown2(mvaariwDown2);
                suiihyou.setMvaariwyenupyendaka2(mvaariwyenupyendaka2);
                suiihyou.setMvaariwyenupyenkijyun2(mvaariwyenupyenkijyun2);
                suiihyou.setMvaariwyenupyenyasu2(mvaariwyenupyenyasu2);
                suiihyou.setMvaariwyensameyendaka2(mvaariwyensameyendaka2);
                suiihyou.setMvaariwyensameyenkijyun2(mvaariwyensameyenkijyun2);
                suiihyou.setMvaariwyensameyenyasu2(mvaariwyensameyenyasu2);
                suiihyou.setMvaariwyendownyendaka2(mvaariwyendownyendaka2);
                suiihyou.setMvaariwyendownyenkijyun2(mvaariwyendownyenkijyun2);
                suiihyou.setMvaariwyendownyenyasu2(mvaariwyendownyenyasu2);
                suiihyou.setSjkkktusirrtup3(kaiyakuSjkTsRituUp);
                suiihyou.setSjkkktusirrtsame3(kaiyakuSjkTsRitu);
                suiihyou.setSjkkktusirrtdown3(kaiyakuSjkTsRituDown);
                suiihyou.setSjkkktusirrthendouup3(YuyuHozenConfig.getInstance().getSuiihyouYoteirirituUp());
                suiihyou.setSjkkktusirrthendoudown3(YuyuHozenConfig.getInstance().getSuiihyouYoteirirituDown());
                suiihyou.setMvaariptumitatekin3(mvaariptumitatekin3);
                suiihyou.setMvaaritmttkgkkykkjmaeup3(mvaaritmttkgkkykkjmaeUp3);
                suiihyou.setMvaaritmttkgkkykkjmaesame3(mvaaritmttkgkkykkjmaesame3);
                suiihyou.setMvaaritmttkgkkykkjmaedown3(mvaaritmttkgkkykkjmaeDown3);
                suiihyou.setMvaariwup3(mvaariwUp3);
                suiihyou.setMvaariwsame3(mvaariwsame3);
                suiihyou.setMvaariwdown3(mvaariwDown3);
                suiihyou.setMvaariwyenupyendaka3(mvaariwyenupyendaka3);
                suiihyou.setMvaariwyenupyenkijyun3(mvaariwyenupyenkijyun3);
                suiihyou.setMvaariwyenupyenyasu3(mvaariwyenupyenyasu3);
                suiihyou.setMvaariwyensameyendaka3(mvaariwyensameyendaka3);
                suiihyou.setMvaariwyensameyenkijyun3(mvaariwyensameyenkijyun3);
                suiihyou.setMvaariwyensameyenyasu3(mvaariwyensameyenyasu3);
                suiihyou.setMvaariwyendownyendaka3(mvaariwyendownyendaka3);
                suiihyou.setMvaariwyendownyenkijyun3(mvaariwyendownyenkijyun3);
                suiihyou.setMvaariwyendownyenyasu3(mvaariwyendownyenyasu3);

            }
            else if (C_MvaTekiyoujyoutaiKbn.MVANONE.eq(mvaTekiyoujyoutaiKbn)) {

                suiihyou.setMvanonewsame(mvanonewsame);
                suiihyou.setMvanonewyensameyendaka(mvanonewyensameyendaka);
                suiihyou.setMvanonewyensameyenkijyun(mvanonewyensameyenkijyun);
                suiihyou.setMvanonewyensameyenyasu(mvanonewyensameyenyasu);
                suiihyou.setMvanoneptumitatekin(mvanonewtutakngk);
                suiihyou.setMvanonewsame2(mvanonewsame2);
                suiihyou.setMvanonewyensameyendaka2(mvanonewyensameyendaka2);
                suiihyou.setMvanonewyensameyenkijyun2(mvanonewyensameyenkijyun2);
                suiihyou.setMvanonewyensameyenyasu2(mvanonewyensameyenyasu2);
                suiihyou.setMvanoneptumitatekin2(mvanonewtutakngk2);
                suiihyou.setMvanonewsame3(mvanonewsame3);
                suiihyou.setMvanonewyensameyendaka3(mvanonewyensameyendaka3);
                suiihyou.setMvanonewyensameyenkijyun3(mvanonewyensameyenkijyun3);
                suiihyou.setMvanonewyensameyenyasu3(mvanonewyensameyenyasu3);
                suiihyou.setMvanoneptumitatekin3(mvanonewtutakngk3);
            }

            BizPropertyInitializer.initialize(suiihyou);

            suiihyouList.add(suiihyou);

            calcKijyunYmd = BizDate.valueOf((calcKijyunYmd.getYear() + 1), pWSuiihyouParam.getKeisanWExtBean()
                .getKykymd().getBizDateMD());

            if (!calcKijyunYmd.isRekijyou()) {
                calcKijyunYmd = calcKijyunYmd.getRekijyou().getNextDay();

                rekijyouSyuuseiUmu = 1;
            }
            else {
                rekijyouSyuuseiUmu = 0;
            }

            wkKeikaNensuu++;

            tykznTmttkntaisyouym = kijyunYm;
        }

        if(C_YouhiKbn.YOU.eq(jiyuSekkeiYhKbn)){

            pWSuiihyouParam.getKeisanWExtBean().setTmttkntaisyouym(tykznTmttkntaisyouymStart);

            suiihyouExtBeanLst = makeJiyuWSuiihyouNenkin(
                pWSuiihyouParam.getKeisanWExtBean(),
                calcKijyunYmdList,
                calcKijyunYMList,
                pWSuiihyouParam.getTmttknZoukarituJygn(),
                pWSuiihyouParam.getSetteiBairitu(),
                jySekkeiYouTmmshanteiSisuuList);
        }

        logger.debug("△ 解約返戻金推移表作成（年金） 終了");

        return suiihyouList;
    }

    private List<BizCurrency> getKaiyakuhrknYenKnsn(
        BizCurrency pMvaariw,
        BizNumber pKawaserateCenter,
        BizNumber pKawaserateEndaka,
        BizNumber pKawaserateEnyasi) {

        KeisanGaikakanzan keisanGaikakanzan = SWAKInjector.getInstance(KeisanGaikakanzan.class);

        BizCurrency mvaariw = pMvaariw;

        BizCurrency mvaariwyenyenkijyun = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);

        BizCurrency mvaariwyenyendaka = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);

        BizCurrency mvaariwyenyenyasu = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);

        List<BizCurrency> mvaariwyenlst = null;

        keisanGaikakanzan.exec(
            C_Tuukasyu.JPY,
            mvaariw,
            pKawaserateCenter,
            C_HasuusyoriKbn.AGE);

        mvaariwyenyenkijyun = keisanGaikakanzan.getKanzanGaku().round(-4, RoundingMode.FLOOR);

        keisanGaikakanzan.exec(
            C_Tuukasyu.JPY,
            mvaariw,
            pKawaserateEndaka,
            C_HasuusyoriKbn.AGE);

        mvaariwyenyendaka = keisanGaikakanzan.getKanzanGaku().round(-4, RoundingMode.FLOOR);

        keisanGaikakanzan.exec(
            C_Tuukasyu.JPY,
            mvaariw,
            pKawaserateEnyasi,
            C_HasuusyoriKbn.AGE);

        mvaariwyenyenyasu = keisanGaikakanzan.getKanzanGaku().round(-4, RoundingMode.FLOOR);

        mvaariwyenlst = new ArrayList<BizCurrency>();
        mvaariwyenlst.add(mvaariwyenyenkijyun);
        mvaariwyenlst.add(mvaariwyenyendaka);
        mvaariwyenlst.add(mvaariwyenyenyasu);

        return mvaariwyenlst;

    }

    private List<BizCurrency> getTmttknSisuuKaiyakuhrkn(
        C_MvaTekiyoujyoutaiKbn pMvaTekiyoujyoutaiKbn,
        BizDate pCalcKijyunYmd,
        BizDateYM pKijyunYm,
        BizNumber pKaiyakusjkkktyouseiriritu,
        BizCurrency pSisuurendoutmttkngk,
        KeisanWExtBean pKeisanWExtBean) {

        KeisanW keisanW = SWAKInjector.getInstance(KeisanW.class);

        BizCurrency mvaaritmttkgkkykkjmae = BizCurrency.valueOf(0);

        BizCurrency mvaariw = BizCurrency.valueOf(0);

        List<BizCurrency> mvaaritmttkgmvaariwlist = null;

        KeisanWExtBean wkKeisanWExtBean = SWAKInjector.getInstance(KeisanWExtBean.class);

        if (C_MvaTekiyoujyoutaiKbn.MVAARI.eq(pMvaTekiyoujyoutaiKbn)) {

            wkKeisanWExtBean.setSyouhncd(pKeisanWExtBean.getSyouhncd());
            wkKeisanWExtBean.setSyouhnsdno(pKeisanWExtBean.getSyouhnsdno());
            wkKeisanWExtBean.setRyouritusdno(pKeisanWExtBean.getRyouritusdno());
            wkKeisanWExtBean.setYoteiriritu(pKeisanWExtBean.getYoteiriritu());
            wkKeisanWExtBean.setHrkkaisuu(pKeisanWExtBean.getHrkkaisuu());
            wkKeisanWExtBean.setHknkknsmnkbn(pKeisanWExtBean.getHknkknsmnkbn());
            wkKeisanWExtBean.setHknkkn(pKeisanWExtBean.getHknkkn());
            wkKeisanWExtBean.setHrkkkn(pKeisanWExtBean.getHrkkkn());
            wkKeisanWExtBean.setHhknnen(pKeisanWExtBean.getHhknnen());
            wkKeisanWExtBean.setHhknsei(pKeisanWExtBean.getHhknsei());
            wkKeisanWExtBean.setKihons(pKeisanWExtBean.getKihons());
            wkKeisanWExtBean.setHokenryou(pKeisanWExtBean.getHokenryou());
            wkKeisanWExtBean.setKykymd(pKeisanWExtBean.getKykymd());
            wkKeisanWExtBean.setTuukasyu(pKeisanWExtBean.getTuukasyu());
            wkKeisanWExtBean.setKyksjkkktyouseiriritu(pKeisanWExtBean.getKyksjkkktyouseiriritu());
            wkKeisanWExtBean.setKaiyakusjkkktyouseiriritu(pKaiyakusjkkktyouseiriritu);
            wkKeisanWExtBean.setTmttkntaisyouym(pKeisanWExtBean.getTmttkntaisyouym());
            wkKeisanWExtBean.setTeiritutmttkngk(pKeisanWExtBean.getTeiritutmttkngk());
            wkKeisanWExtBean.setSisuurendoutmttkngk(pSisuurendoutmttkngk);
            wkKeisanWExtBean.setTmttknhaneisisuu(pKeisanWExtBean.getTmttknhaneisisuu());
            wkKeisanWExtBean.setTumitateriritu(pKeisanWExtBean.getTumitateriritu());

            C_ErrorKbn errorKbn = keisanW.exec(pCalcKijyunYmd, pKijyunYm, wkKeisanWExtBean);

            if (C_ErrorKbn.ERROR.eq(errorKbn)) {

                throw new CommonBizAppException(ERROR_MSG);
            }

            mvaaritmttkgkkykkjmae = keisanW.getKaiyakukjMaeW();

            mvaariw = keisanW.getW();

        }
        else {
            mvaaritmttkgkkykkjmae = pSisuurendoutmttkngk;

            mvaariw = pSisuurendoutmttkngk;
        }

        mvaaritmttkgmvaariwlist = new ArrayList<BizCurrency>();
        mvaaritmttkgmvaariwlist.add(mvaaritmttkgkkykkjmae);
        mvaaritmttkgmvaariwlist.add(mvaariw);

        return mvaaritmttkgmvaariwlist;
    }

    private List<BizCurrency> getTmttknTeirituKaiyakuhrkn(
        C_MvaTekiyoujyoutaiKbn pMvaTekiyoujyoutaiKbn,
        BizDate pCalcKijyunYmd,
        BizDateYM pKijyunYm,
        BizNumber pKaiyakusjkkktyouseiriritu,
        KeisanWExtBean pKeisanWExtBean) {

        KeisanW keisanW = SWAKInjector.getInstance(KeisanW.class);

        BizCurrency mvaaritmttkgkkykkjmae = BizCurrency.valueOf(0);

        BizCurrency mvaariw = BizCurrency.valueOf(0);

        BizCurrency teiritutmttkgk = BizCurrency.valueOf(0);

        List<BizCurrency> mvaaritmttkgmvaariwlist = null;

        KeisanWExtBean wkKeisanWExtBean = SWAKInjector.getInstance(KeisanWExtBean.class);

        if (C_MvaTekiyoujyoutaiKbn.MVAARI.eq(pMvaTekiyoujyoutaiKbn)) {

            wkKeisanWExtBean.setSyouhncd(pKeisanWExtBean.getSyouhncd());
            wkKeisanWExtBean.setSyouhnsdno(pKeisanWExtBean.getSyouhnsdno());
            wkKeisanWExtBean.setRyouritusdno(pKeisanWExtBean.getRyouritusdno());
            wkKeisanWExtBean.setYoteiriritu(pKeisanWExtBean.getYoteiriritu());
            wkKeisanWExtBean.setHrkkaisuu(pKeisanWExtBean.getHrkkaisuu());
            wkKeisanWExtBean.setHknkknsmnkbn(pKeisanWExtBean.getHknkknsmnkbn());
            wkKeisanWExtBean.setHknkkn(pKeisanWExtBean.getHknkkn());
            wkKeisanWExtBean.setHrkkkn(pKeisanWExtBean.getHrkkkn());
            wkKeisanWExtBean.setHhknnen(pKeisanWExtBean.getHhknnen());
            wkKeisanWExtBean.setHhknsei(pKeisanWExtBean.getHhknsei());
            wkKeisanWExtBean.setKihons(pKeisanWExtBean.getKihons());
            wkKeisanWExtBean.setHokenryou(pKeisanWExtBean.getHokenryou());
            wkKeisanWExtBean.setKykymd(pKeisanWExtBean.getKykymd());
            wkKeisanWExtBean.setTuukasyu(pKeisanWExtBean.getTuukasyu());
            wkKeisanWExtBean.setKyksjkkktyouseiriritu(pKeisanWExtBean.getKyksjkkktyouseiriritu());
            wkKeisanWExtBean.setKaiyakusjkkktyouseiriritu(pKaiyakusjkkktyouseiriritu);
            wkKeisanWExtBean.setTmttkntaisyouym(pKeisanWExtBean.getTmttkntaisyouym());
            wkKeisanWExtBean.setTeiritutmttkngk(pKeisanWExtBean.getTeiritutmttkngk());
            wkKeisanWExtBean.setSisuurendoutmttkngk(pKeisanWExtBean.getSisuurendoutmttkngk());
            wkKeisanWExtBean.setTmttknhaneisisuu(pKeisanWExtBean.getTmttknhaneisisuu());
            wkKeisanWExtBean.setTumitateriritu(pKeisanWExtBean.getTumitateriritu());

            C_ErrorKbn errorKbn = keisanW.exec(pCalcKijyunYmd, pKijyunYm, wkKeisanWExtBean);

            if (C_ErrorKbn.ERROR.eq(errorKbn)) {

                throw new CommonBizAppException(ERROR_MSG);
            }

            mvaaritmttkgkkykkjmae = keisanW.getKaiyakukjMaeW();

            mvaariw = keisanW.getW();

            teiritutmttkgk = keisanW.getTeirituTmttkngk();

        }
        else {

            KeisanSisuuRendouNkTmttkn keisanSisuuRendouNkTmttkn = SWAKInjector.getInstance(KeisanSisuuRendouNkTmttkn.class);

            C_ErrorKbn errorKbn = keisanSisuuRendouNkTmttkn.exec(
                pKeisanWExtBean.getKykymd(),
                pKeisanWExtBean.getHknkkn(),
                pKeisanWExtBean.getTeikishrtkykhukaumu(),
                pKeisanWExtBean.getTuukasyu(),
                pCalcKijyunYmd,
                pCalcKijyunYmd.getBizDateYM(),
                pKeisanWExtBean.getTmttkntaisyouym(),
                pKeisanWExtBean.getTumitateriritu(),
                pKeisanWExtBean.getTeiritutmttkngk(),
                pKeisanWExtBean.getSisuurendoutmttkngk());

            if (C_ErrorKbn.ERROR.eq(errorKbn)) {
                throw new CommonBizAppException(ERROR_MSG_3);
            }

            mvaaritmttkgkkykkjmae = keisanSisuuRendouNkTmttkn.getTmttkngkkei();

            mvaariw = keisanSisuuRendouNkTmttkn.getTmttkngkkei();

            teiritutmttkgk = keisanSisuuRendouNkTmttkn.getTeiritutmttkngk();

        }

        mvaaritmttkgmvaariwlist = new ArrayList<BizCurrency>();
        mvaaritmttkgmvaariwlist.add(mvaaritmttkgkkykkjmae);
        mvaaritmttkgmvaariwlist.add(mvaariw);
        mvaaritmttkgmvaariwlist.add(teiritutmttkgk);

        return mvaaritmttkgmvaariwlist;
    }

    private List<SuiihyouExtBean> makeJiyuWSuiihyouNenkin(
        KeisanWExtBean pKeisanWExtBean,
        List<BizDate> pCalcKijyunYmdList,
        List<BizDateYM> pCalcKijyunYMList,
        BizNumber pTmttknZoukarituJygn,
        BizNumber pSetteiBairitu,
        List<BizNumber> pJySekkeiSisuuKsList) {

        logger.debug("▽ 解約返戻金推移表作成（年金）_自由設計 開始");
        String syouhncd = pKeisanWExtBean.getSyouhncd();

        BizNumber kaiyakuSjkTsRitu = pKeisanWExtBean.getKyksjkkktyouseiriritu();

        BizNumber kaiyakuSjkTsRituUp = kaiyakuSjkTsRitu.add(YuyuHozenConfig.getInstance().getSuiihyouSjkkktusirrtUp());

        BizNumber kaiyakuSjkTsRituDown = kaiyakuSjkTsRitu.subtract(YuyuHozenConfig.getInstance().getSuiihyouSjkkktusirrtDown());

        BizNumber tykzentmmshanteiymdSisuu = pKeisanWExtBean.getTmttknhaneisisuu();

        BizNumber tmmshanteiymdSisuu = pKeisanWExtBean.getTmttknhaneisisuu();

        BizCurrency sisuurendoutmttkngk = pKeisanWExtBean.getSisuurendoutmttkngk();

        BizDateYM tykznTmttkntaisyouym = pKeisanWExtBean.getTmttkntaisyouym();

        C_Tuukasyu tuukasyu = pKeisanWExtBean.getTuukasyu();

        HenkanTuuka henkanTuuka = SWAKInjector.getInstance(HenkanTuuka.class);

        CurrencyType currencyType =henkanTuuka.henkanTuukaKbnToType(tuukasyu);

        for (int clcKjnYmdIdx = 0; clcKjnYmdIdx < pCalcKijyunYmdList.size(); clcKjnYmdIdx++) {

            BizDate calcKijyunYmd = pCalcKijyunYmdList.get(clcKjnYmdIdx);

            BizDateYM kijyunYm = pCalcKijyunYMList.get(clcKjnYmdIdx);

            SuiihyouExtBean suiihyouExtBean = SWAKInjector.getInstance(SuiihyouExtBean.class);

            pKeisanWExtBean.setTmttkntaisyouym(tykznTmttkntaisyouym);

            C_MvaTekiyoujyoutaiKbn mvaTekiyoujyoutaiKbn = null;

            if (clcKjnYmdIdx == pCalcKijyunYmdList.size()-1) {
                mvaTekiyoujyoutaiKbn = C_MvaTekiyoujyoutaiKbn.MVANONE;
            }else {
                mvaTekiyoujyoutaiKbn = C_MvaTekiyoujyoutaiKbn.MVAARI;
            }

            BizCurrency mvaariptumitatekin = BizCurrency.valueOf(0,currencyType);

            BizNumber sisuuupritu = BizNumber.ZERO;

            if (clcKjnYmdIdx != 0) {

                tykzentmmshanteiymdSisuu = tmmshanteiymdSisuu;

                BizNumber jySekkeiSisuuKs = pJySekkeiSisuuKsList.get(clcKjnYmdIdx-1);

                if (jySekkeiSisuuKs.compareTo(BizNumber.ONE) < 0){
                    tmmshanteiymdSisuu = tmmshanteiymdSisuu.multiply(jySekkeiSisuuKs, 4, RoundingMode.DOWN);
                }else{
                    tmmshanteiymdSisuu = tmmshanteiymdSisuu.multiply(jySekkeiSisuuKs, 4, RoundingMode.UP);
                }

                KeisanTmHntiSisuuRendouTmttkn keisanTmHntiSisuuRendouTmttkn = SWAKInjector
                    .getInstance(KeisanTmHntiSisuuRendouTmttkn.class);

                C_ErrorKbn errorKbn = keisanTmHntiSisuuRendouTmttkn.exec(
                    syouhncd,
                    tuukasyu,
                    tmmshanteiymdSisuu,
                    tykzentmmshanteiymdSisuu,
                    pSetteiBairitu,
                    pTmttknZoukarituJygn,
                    sisuurendoutmttkngk,
                    BizNumber.ZERO);

                if (C_ErrorKbn.ERROR.eq(errorKbn)) {
                    throw new CommonBizAppException(ERROR_MSG_2);
                }

                sisuuupritu = keisanTmHntiSisuuRendouTmttkn.getSisuuUpRitu().round(2, RoundingMode.DOWN);

                sisuurendoutmttkngk = keisanTmHntiSisuuRendouTmttkn.getSisuurendoutmttkngk();
            }

            mvaariptumitatekin = pKeisanWExtBean.getTeiritutmttkngk().add(sisuurendoutmttkngk);

            BizCurrency mvaaritmttkgkkykkjmaesame = BizCurrency.valueOf(0,currencyType);

            BizCurrency mvaariwsame = BizCurrency.valueOf(0,currencyType);

            BizCurrency mvanonewsame = BizCurrency.valueOf(0,currencyType);

            BizCurrency mvanonewtutakngk = BizCurrency.valueOf(0,currencyType);

            List<BizCurrency> mvaaritmttkgmvaariwlist = getTmttknSisuuKaiyakuhrkn(
                mvaTekiyoujyoutaiKbn,
                calcKijyunYmd,
                kijyunYm,
                kaiyakuSjkTsRitu,
                sisuurendoutmttkngk,
                pKeisanWExtBean);

            mvaaritmttkgkkykkjmaesame = mvaaritmttkgmvaariwlist.get(0);

            mvaariwsame = mvaaritmttkgmvaariwlist.get(1);

            if (C_MvaTekiyoujyoutaiKbn.MVANONE.eq(mvaTekiyoujyoutaiKbn)) {

                mvanonewsame = mvaariwsame;

                mvanonewtutakngk = mvaaritmttkgkkykkjmaesame;
            }

            BizCurrency mvaaritmttkgkkykkjmaeUp = BizCurrency.valueOf(0,currencyType);

            BizCurrency mvaariwUp = BizCurrency.valueOf(0,currencyType);

            mvaaritmttkgmvaariwlist = getTmttknSisuuKaiyakuhrkn(
                mvaTekiyoujyoutaiKbn,
                calcKijyunYmd,
                kijyunYm,
                kaiyakuSjkTsRituUp,
                sisuurendoutmttkngk,
                pKeisanWExtBean);

            mvaaritmttkgkkykkjmaeUp = mvaaritmttkgmvaariwlist.get(0);

            mvaariwUp = mvaaritmttkgmvaariwlist.get(1);

            BizCurrency mvaaritmttkgkkykkjmaeDown = BizCurrency.valueOf(0,currencyType);

            BizCurrency mvaariwDown = BizCurrency.valueOf(0,currencyType);

            mvaaritmttkgmvaariwlist = getTmttknSisuuKaiyakuhrkn(
                mvaTekiyoujyoutaiKbn,
                calcKijyunYmd,
                kijyunYm,
                kaiyakuSjkTsRituDown,
                sisuurendoutmttkngk,
                pKeisanWExtBean);

            mvaaritmttkgkkykkjmaeDown = mvaaritmttkgmvaariwlist.get(0);

            mvaariwDown = mvaaritmttkgmvaariwlist.get(1);

            suiihyouExtBean.setSisuuUpRitu(sisuuupritu);

            if (C_MvaTekiyoujyoutaiKbn.MVAARI.eq(mvaTekiyoujyoutaiKbn)) {
                suiihyouExtBean.setSjkkktusirrtUp(kaiyakuSjkTsRituUp);
                suiihyouExtBean.setSjkkktusirrtSame(kaiyakuSjkTsRitu);
                suiihyouExtBean.setSjkkktusirrtDown(kaiyakuSjkTsRituDown);
                suiihyouExtBean.setSjkkktusirrtHendouUp(YuyuHozenConfig.getInstance().getSuiihyouYoteirirituUp());
                suiihyouExtBean.setSjkkktusirrtHendouDown(YuyuHozenConfig.getInstance().getSuiihyouYoteirirituDown());
                suiihyouExtBean.setMvaAriPTumitatekin(mvaariptumitatekin);
                suiihyouExtBean.setMvaAriTmttkgkKykkjmaeUp(mvaaritmttkgkkykkjmaeUp);
                suiihyouExtBean.setMvaAriTmttkgkKykkjmaeSame(mvaaritmttkgkkykkjmaesame);
                suiihyouExtBean.setMvaAriTmttkgkKykjmaeDown(mvaaritmttkgkkykkjmaeDown);
                suiihyouExtBean.setMvaAriWUp(mvaariwUp);
                suiihyouExtBean.setMvaAriWSame(mvaariwsame);
                suiihyouExtBean.setMvaAriWDown(mvaariwDown);
            }else{
                suiihyouExtBean.setMvaNoneWSame(mvanonewsame);
                suiihyouExtBean.setMvaNonePTumitatekin(mvanonewtutakngk);
            }
            tykznTmttkntaisyouym = kijyunYm;

            suiihyouExtBeanLst.add(suiihyouExtBean);
        }

        logger.debug("△ 解約返戻金推移表作成（年金）_自由設計 終了");

        return suiihyouExtBeanLst;
    }
}
