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

import org.slf4j.Logger;

import yuyu.common.biz.bzcommon.BizDateUtil;
import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.common.biz.bzcommon.GetKawaseRate;
import yuyu.common.biz.bzcommon.KeisanGaikakanzan;
import yuyu.common.biz.exception.CommonBizAppException;
import yuyu.def.classification.C_EigyoubiHoseiKbn;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_HasuusyoriKbn;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_KawaserateSyuruiKbn;
import yuyu.def.classification.C_KawasetekiyoKbn;
import yuyu.def.classification.C_KawasetsryKbn;
import yuyu.def.classification.C_KknsmnKbn;
import yuyu.def.classification.C_Kykjyoutai;
import yuyu.def.classification.C_MvaTekiyoujyoutaiKbn;
import yuyu.def.classification.C_SinsaihkKbn;
import yuyu.def.classification.C_SyoukensaihkKbn;
import yuyu.def.classification.C_TmttknhaibunjyoutaiKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_TykzentykgoKbn;
import yuyu.def.classification.C_YouhiKbn;
import yuyu.def.db.entity.IT_Suiihyou;
import yuyu.def.hozen.configuration.YuyuHozenConfig;

/**
 * 契約保全 契約保全共通 解約返戻金推移表作成（年金３）
 */
public class WSuiihyouNenkin3 {

    private final static String ERROR_MSG = "解約返戻金計算が実行できませんでした。";

    private final static String ERROR_MSG_2 = "積増判定時指数連動積立金計算が実行できませんでした。";

    private final static String ERROR_MSG_3 = "指数連動年金積立金計算が実行できませんでした。";

    private final static String SUIIHYOUSYUBETU_SISUU_3SYU = "05";

    private final static String SUIIHYOUSYUBETU_SISUU_2SYU = "11";

    private final static String SUIIHYOUSYUBETU_SISUU_1SYU = "12";

    private final static String SUIIHYOUSYUBETU_TEIRITU = "03";

    private C_YouhiKbn yenkansannYhKbn = C_YouhiKbn.YOU;

    private List<SuiihyouExtBean> suiihyouExtBeanLst = new ArrayList<>();

    @Inject
    private static Logger logger;

    public WSuiihyouNenkin3() {
        super();
    }

    public void setYenkansannYhKbn(C_YouhiKbn pYenkansannYhKbn) {
        yenkansannYhKbn = pYenkansannYhKbn;
    }

    public List<SuiihyouExtBean> getSuiihyouExtBeanLst() {
        return suiihyouExtBeanLst;
    }

    public List<IT_Suiihyou> exec(WSuiihyouParam pWSuiihyouParam) {

        logger.debug("▽ 解約返戻金推移表作成（年金３） 開始");

        C_SinsaihkKbn csinsaihkKbn = C_SinsaihkKbn.BLNK;

        if (C_SinsaihkKbn.SIN.eq(pWSuiihyouParam.getSinsaihkKbn()) ||
            (C_SinsaihkKbn.SAI.eq(pWSuiihyouParam.getSinsaihkKbn()) &&
                C_SyoukensaihkKbn.SINKEIYAKUSAISAKUSEI.eq(pWSuiihyouParam.getSyoukensaihkKbn()))) {
            csinsaihkKbn = C_SinsaihkKbn.SIN;
        }
        else {
            csinsaihkKbn = C_SinsaihkKbn.SAI;
        }

        GetKawaseRate getKawaseRate = SWAKInjector.getInstance(GetKawaseRate.class);
        BizNumber kawaseRate = BizNumber.ZERO;

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

            kawaseRate = getKawaseRate.getKawaserate();
        }

        SetOutoubi setOutoubi = SWAKInjector.getInstance(SetOutoubi.class);
        BizDate calcKijyunYmd;

        if (C_SinsaihkKbn.SIN.eq(csinsaihkKbn)) {
            calcKijyunYmd = pWSuiihyouParam.getKeisanWExtBean().getKykymd();
        }else{
            calcKijyunYmd = setOutoubi.exec(
                C_TykzentykgoKbn.TYKGO,
                pWSuiihyouParam.getKeisanWExtBean().getKykymd(),
                C_Hrkkaisuu.NEN,
                pWSuiihyouParam.getCalcKijyunYmd());
        }

        int wkKeikaNensuu = 0;
        int wkKeikaNensuuMax = 0;

        if (C_SinsaihkKbn.SIN.eq(csinsaihkKbn)) {
            wkKeikaNensuuMax = pWSuiihyouParam.getKeisanWExtBean().getHknkkn();
        }
        else {
            wkKeikaNensuu = BizDateUtil.calcDifference(calcKijyunYmd, pWSuiihyouParam.getKeisanWExtBean().getKykymd()).getYears();
            wkKeikaNensuuMax = pWSuiihyouParam.getKeisanWExtBean().getHknkkn() - wkKeikaNensuu;
        }

        SetManryoubi setManryoubi = SWAKInjector.getInstance(SetManryoubi.class);
        BizDate hknkknmanryouymd = setManryoubi.exec(
            pWSuiihyouParam.getKeisanWExtBean().getKykymd(),
            pWSuiihyouParam.getKeisanWExtBean().getHhknnen(),
            pWSuiihyouParam.getKeisanWExtBean().getHknkkn(),
            C_KknsmnKbn.valueOf(pWSuiihyouParam.getKeisanWExtBean().getHknkknsmnkbn().getValue()));

        List<BizDate> calcKijyunYmdList = new ArrayList<>();
        List<BizDateYM> calcKijyunYMList = new ArrayList<>();

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

            calcKijyunYmd = setOutoubi.exec(
                C_TykzentykgoKbn.TYKGO,
                pWSuiihyouParam.getKeisanWExtBean().getKykymd(),
                C_Hrkkaisuu.NEN,
                calcKijyunYmd);
        }

        List<IT_Suiihyou> suiihyouList = new ArrayList<>();

        if (C_TmttknhaibunjyoutaiKbn.TEIRITU_ONLY.eq(pWSuiihyouParam.getTmttknhaibunjyoutai())) {
            List<EditWSuiihyouBean> editWsuiihyouBeanList = new ArrayList<>();

            editWsuiihyouBeanList = getTeirituWSuiihyou(
                pWSuiihyouParam.getKeisanWExtBean(),
                calcKijyunYmdList,
                calcKijyunYMList,
                hknkknmanryouymd);

            suiihyouList = makeTeirituWSuiihyou(
                pWSuiihyouParam,
                calcKijyunYmdList,
                calcKijyunYMList,
                editWsuiihyouBeanList,
                kawaseRate);
        }
        else if (C_TmttknhaibunjyoutaiKbn.SISUU_ONLY.eq(pWSuiihyouParam.getTmttknhaibunjyoutai())){

            String suiihyousyubetu = SUIIHYOUSYUBETU_SISUU_3SYU;
            if(pWSuiihyouParam.getTmmshanteiSisuuList3() == null ){
                suiihyousyubetu = SUIIHYOUSYUBETU_SISUU_2SYU;
            }
            if(pWSuiihyouParam.getTmmshanteiSisuuList2() == null){
                suiihyousyubetu = SUIIHYOUSYUBETU_SISUU_1SYU;
            }

            List<EditWSuiihyouBean> editWsuiihyouBeanList1 = new ArrayList<>();
            editWsuiihyouBeanList1 = getSisuuWSuiihyou(
                pWSuiihyouParam.getKeisanWExtBean(),
                calcKijyunYmdList,
                calcKijyunYMList,
                pWSuiihyouParam.getRendouRitu(),
                pWSuiihyouParam.getTmmshanteiSisuuList1(),
                hknkknmanryouymd,
                csinsaihkKbn,
                C_YouhiKbn.YOU);

            List<EditWSuiihyouBean> editWsuiihyouBeanList2 = new ArrayList<>();
            editWsuiihyouBeanList2 = getSisuuWSuiihyou(
                pWSuiihyouParam.getKeisanWExtBean(),
                calcKijyunYmdList,
                calcKijyunYMList,
                pWSuiihyouParam.getRendouRitu(),
                pWSuiihyouParam.getTmmshanteiSisuuList2(),
                hknkknmanryouymd,
                csinsaihkKbn,
                C_YouhiKbn.HUYOU);

            List<EditWSuiihyouBean> editWsuiihyouBeanList3 = new ArrayList<>();
            editWsuiihyouBeanList3 = getSisuuWSuiihyou(
                pWSuiihyouParam.getKeisanWExtBean(),
                calcKijyunYmdList,
                calcKijyunYMList,
                pWSuiihyouParam.getRendouRitu(),
                pWSuiihyouParam.getTmmshanteiSisuuList3(),
                hknkknmanryouymd,
                csinsaihkKbn,
                C_YouhiKbn.HUYOU);

            suiihyouList = makeSisuuWSuiihyou(
                pWSuiihyouParam,
                calcKijyunYmdList,
                calcKijyunYMList,
                suiihyousyubetu,
                editWsuiihyouBeanList1,
                editWsuiihyouBeanList2,
                editWsuiihyouBeanList3,
                kawaseRate);
        }
        logger.debug("△ 解約返戻金推移表作成（年金３） 終了");

        return suiihyouList;
    }

    private List<BizCurrency> getKaiyakuhrknYenKnsn(
        BizCurrency pKaiyakuHrKngak,
        BizNumber pKawaserateEndaka,
        BizNumber pKawaserateCenter,
        BizNumber pKawaserateEnyas) {

        KeisanGaikakanzan keisanGaikakanzan = SWAKInjector.getInstance(KeisanGaikakanzan.class);
        List<BizCurrency> yenKnsnWList = new ArrayList<BizCurrency>();

        keisanGaikakanzan.exec(
            C_Tuukasyu.JPY,
            pKaiyakuHrKngak,
            pKawaserateEndaka,
            C_HasuusyoriKbn.AGE);

        yenKnsnWList.add(keisanGaikakanzan.getKanzanGaku().round(-4, RoundingMode.FLOOR));

        keisanGaikakanzan.exec(
            C_Tuukasyu.JPY,
            pKaiyakuHrKngak,
            pKawaserateCenter,
            C_HasuusyoriKbn.AGE);

        yenKnsnWList.add(keisanGaikakanzan.getKanzanGaku().round(-4, RoundingMode.FLOOR));

        keisanGaikakanzan.exec(
            C_Tuukasyu.JPY,
            pKaiyakuHrKngak,
            pKawaserateEnyas,
            C_HasuusyoriKbn.AGE);

        yenKnsnWList.add(keisanGaikakanzan.getKanzanGaku().round(-4, RoundingMode.FLOOR));

        return yenKnsnWList;
    }


    private List<EditWSuiihyouBean> getTeirituWSuiihyou(
        KeisanWExtBean pKeisanWExtBean,
        List<BizDate> pCalcKijyunYmdList,
        List<BizDateYM> pCalcKijyunYMList,
        BizDate pHknkknmanryouymd) {

        logger.debug("▽ 解約返戻金推移表作成（年金３）_定率金額取得 開始");

        BizNumber kaiyakuSjkTsRitu = pKeisanWExtBean.getKyksjkkktyouseiriritu();
        BizNumber kaiyakuSjkTsRituUp = kaiyakuSjkTsRitu.add(YuyuHozenConfig.getInstance().getSuiihyouSjkkktusirrtUp());
        BizNumber kaiyakuSjkTsRituDown = kaiyakuSjkTsRitu.subtract(YuyuHozenConfig.getInstance().getSuiihyouSjkkktusirrtDown());

        List<EditWSuiihyouBean> editWSuiihyouBeanList = new ArrayList<>();

        for (int clcKjnYmdIdx = 0; clcKjnYmdIdx < pCalcKijyunYmdList.size(); clcKjnYmdIdx++) {
            BizDate calcKijyunYmd = pCalcKijyunYmdList.get(clcKjnYmdIdx);
            BizDateYM calcKijyunYM = pCalcKijyunYMList.get(clcKjnYmdIdx);
            EditWSuiihyouBean editWSuiihyouBean = SWAKInjector.getInstance(EditWSuiihyouBean.class);
            SuiihyouExtBean suiihyouExtBean = SWAKInjector.getInstance(SuiihyouExtBean.class);
            KeisanW keisanW = SWAKInjector.getInstance(KeisanW.class);
            C_ErrorKbn errorKbn = C_ErrorKbn.ERROR;

            C_MvaTekiyoujyoutaiKbn mvaTekiyoujyoutaiKbn = C_MvaTekiyoujyoutaiKbn.MVAARI;
            if (BizDateUtil.compareYmd(calcKijyunYmd, pHknkknmanryouymd) == BizDateUtil.COMPARE_EQUAL){
                mvaTekiyoujyoutaiKbn = C_MvaTekiyoujyoutaiKbn.MVANONE;
            }
            editWSuiihyouBean.setMvaTekiyoujyoutaiKbn(mvaTekiyoujyoutaiKbn);

            if (C_MvaTekiyoujyoutaiKbn.MVAARI.eq(mvaTekiyoujyoutaiKbn)) {
                pKeisanWExtBean.setKaiyakusjkkktyouseiriritu(kaiyakuSjkTsRitu);

                errorKbn = keisanW.exec(calcKijyunYmd, calcKijyunYM, pKeisanWExtBean);
                if (C_ErrorKbn.ERROR.eq(errorKbn)) {
                    throw new CommonBizAppException(ERROR_MSG);
                }
                editWSuiihyouBean.setSjkkktusirrtSame(pKeisanWExtBean.getKaiyakusjkkktyouseiriritu());
                editWSuiihyouBean.setTmttkgkKykkjmaeSame(keisanW.getKaiyakukjMaeW());
                editWSuiihyouBean.setKaiyakuHrKngakSame(keisanW.getW());
                editWSuiihyouBean.setTmttKngk(keisanW.getTeirituTmttkngk());
                suiihyouExtBean.setKaiyakuKjRitu(keisanW.getKaiyakukjritu());
                suiihyouExtBean.setKaiyakuKjgk(keisanW.getKaiyakukjgk());

                pKeisanWExtBean.setKaiyakusjkkktyouseiriritu(kaiyakuSjkTsRituUp);

                errorKbn = keisanW.exec(calcKijyunYmd, calcKijyunYM, pKeisanWExtBean);
                if (C_ErrorKbn.ERROR.eq(errorKbn)) {
                    throw new CommonBizAppException(ERROR_MSG);
                }

                editWSuiihyouBean.setSjkkktusirrtUp(pKeisanWExtBean.getKaiyakusjkkktyouseiriritu());
                editWSuiihyouBean.setTmttkgkKykkjmaeUp(keisanW.getKaiyakukjMaeW());
                editWSuiihyouBean.setKaiyakuHrKngakUp(keisanW.getW());

                pKeisanWExtBean.setKaiyakusjkkktyouseiriritu(kaiyakuSjkTsRituDown);

                errorKbn = keisanW.exec(calcKijyunYmd, calcKijyunYM, pKeisanWExtBean);
                if (C_ErrorKbn.ERROR.eq(errorKbn)) {
                    throw new CommonBizAppException(ERROR_MSG);
                }

                editWSuiihyouBean.setSjkkktusirrtDown(pKeisanWExtBean.getKaiyakusjkkktyouseiriritu());
                editWSuiihyouBean.setTmttkgkKykkjmaeDown(keisanW.getKaiyakukjMaeW());
                editWSuiihyouBean.setKaiyakuHrKngakDown(keisanW.getW());
            }
            else {
                KeisanSisuuRendouNkTmttkn keisanSisuuRendouNkTmttkn = SWAKInjector.getInstance(KeisanSisuuRendouNkTmttkn.class);
                errorKbn = keisanSisuuRendouNkTmttkn.exec(
                    pKeisanWExtBean.getKykymd(),
                    pKeisanWExtBean.getHknkkn(),
                    pKeisanWExtBean.getTeikishrtkykhukaumu(),
                    pKeisanWExtBean.getTuukasyu(),
                    calcKijyunYmd,
                    calcKijyunYM,
                    pKeisanWExtBean.getTmttkntaisyouym(),
                    pKeisanWExtBean.getTumitateriritu(),
                    pKeisanWExtBean.getTeiritutmttkngk(),
                    pKeisanWExtBean.getSisuurendoutmttkngk());
                if (C_ErrorKbn.ERROR.eq(errorKbn)) {
                    throw new CommonBizAppException(ERROR_MSG_3);
                }

                editWSuiihyouBean.setTmttKngk(keisanSisuuRendouNkTmttkn.getTmttkngkkei());
                editWSuiihyouBean.setKaiyakuHrKngak(keisanSisuuRendouNkTmttkn.getTmttkngkkei());
                suiihyouExtBean.setKaiyakuKjRitu(BizNumber.ZERO);
                suiihyouExtBean.setKaiyakuKjgk(BizCurrency.valueOf(new BigDecimal(0)));
            }

            editWSuiihyouBeanList.add(editWSuiihyouBean);
            suiihyouExtBeanLst.add(suiihyouExtBean);

            pKeisanWExtBean.setTmttkntaisyouym(calcKijyunYM);
            pKeisanWExtBean.setTeiritutmttkngk(editWSuiihyouBean.getTmttKngk());
        }

        logger.debug("△ 解約返戻金推移表作成（年金３）_定率金額取得 終了");

        return editWSuiihyouBeanList;
    }

    private List<EditWSuiihyouBean> getSisuuWSuiihyou(
        KeisanWExtBean pKeisanWExtBean,
        List<BizDate> pCalcKijyunYmdList,
        List<BizDateYM> pCalcKijyunYMList,
        BizNumber pRendouRitu,
        List<BizNumber> pSisuuKsList,
        BizDate pHknkknmanryouymd,
        C_SinsaihkKbn pSinsaihakKbn,
        C_YouhiKbn pSuiihyouExtBeanYhKbn) {

        logger.debug("▽ 解約返戻金推移表作成（年金３）_指数金額取得 開始");

        List<EditWSuiihyouBean> editWSuiihyouBeanList = new ArrayList<>();

        BizNumber kaiyakuSjkTsRitu = pKeisanWExtBean.getKyksjkkktyouseiriritu();
        BizNumber kaiyakuSjkTsRituUp = kaiyakuSjkTsRitu.add(YuyuHozenConfig.getInstance().getSuiihyouSjkkktusirrtUp());
        BizNumber kaiyakuSjkTsRituDown = kaiyakuSjkTsRitu.subtract(YuyuHozenConfig.getInstance().getSuiihyouSjkkktusirrtDown());

        KeisanWExtBean wkKeisanWExtBean = SWAKInjector.getInstance(KeisanWExtBean.class);
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
        wkKeisanWExtBean.setTeiritutmttkngk(pKeisanWExtBean.getTeiritutmttkngk());
        wkKeisanWExtBean.setTmttknhaneisisuu(pKeisanWExtBean.getTmttknhaneisisuu());
        wkKeisanWExtBean.setTumitateriritu(pKeisanWExtBean.getTumitateriritu());

        BizNumber tykzentmmshanteiymdSisuu = pKeisanWExtBean.getTmttknhaneisisuu();
        BizNumber tmmshanteiymdSisuu = pKeisanWExtBean.getTmttknhaneisisuu();
        Integer sisuUpCount = 0;
        Integer sisuDownCount = 0;
        int indexHosei = 0;
        if (C_SinsaihkKbn.SIN.eq(pSinsaihakKbn)) {
            indexHosei = 1;
        }

        for (int clcKjnYmdIdx = 0; clcKjnYmdIdx < pCalcKijyunYmdList.size(); clcKjnYmdIdx++) {

            BizDate calcKijyunYmd = pCalcKijyunYmdList.get(clcKjnYmdIdx);
            BizDateYM calckijyunYm = pCalcKijyunYMList.get(clcKjnYmdIdx);
            EditWSuiihyouBean editWSuiihyouBean = SWAKInjector.getInstance(EditWSuiihyouBean.class);
            SuiihyouExtBean suiihyouExtBean = SWAKInjector.getInstance(SuiihyouExtBean.class);
            KeisanW keisanW = SWAKInjector.getInstance(KeisanW.class);
            C_ErrorKbn errorKbn = C_ErrorKbn.ERROR;
            editWSuiihyouBean.setMvaTekiyoujyoutaiKbn(C_MvaTekiyoujyoutaiKbn.BLNK);

            if(pSisuuKsList != null){
                C_MvaTekiyoujyoutaiKbn mvaTekiyoujyoutaiKbn = C_MvaTekiyoujyoutaiKbn.MVAARI;
                if (BizDateUtil.compareYmd(calcKijyunYmd, pHknkknmanryouymd) == BizDateUtil.COMPARE_EQUAL){
                    mvaTekiyoujyoutaiKbn = C_MvaTekiyoujyoutaiKbn.MVANONE;
                }
                editWSuiihyouBean.setMvaTekiyoujyoutaiKbn(mvaTekiyoujyoutaiKbn);

                if (clcKjnYmdIdx == 0) {
                    wkKeisanWExtBean.setSisuurendoutmttkngk(pKeisanWExtBean.getSisuurendoutmttkngk());
                    wkKeisanWExtBean.setTmttkntaisyouym(pKeisanWExtBean.getTmttkntaisyouym());
                    editWSuiihyouBean.setTmttKngk(pKeisanWExtBean.getSisuurendoutmttkngk());
                }
                if (C_SinsaihkKbn.SAI.eq(pSinsaihakKbn) ||
                    (C_SinsaihkKbn.SIN.eq(pSinsaihakKbn) && clcKjnYmdIdx != 0)) {

                    tykzentmmshanteiymdSisuu = tmmshanteiymdSisuu;

                    BizNumber jySekkeiSisuuKs = pSisuuKsList.get(clcKjnYmdIdx - indexHosei);

                    if (jySekkeiSisuuKs.compareTo(BizNumber.ONE) < 0){
                        tmmshanteiymdSisuu = tmmshanteiymdSisuu.multiply(jySekkeiSisuuKs, 4, RoundingMode.DOWN);
                        sisuDownCount++;
                    }else{
                        tmmshanteiymdSisuu = tmmshanteiymdSisuu.multiply(jySekkeiSisuuKs, 4, RoundingMode.UP);
                        sisuUpCount++;
                    }

                    KeisanTmHntiSisuuRendouTmttkn keisanTmHntiSisuuRendouTmttkn = SWAKInjector
                        .getInstance(KeisanTmHntiSisuuRendouTmttkn.class);

                    errorKbn = keisanTmHntiSisuuRendouTmttkn.exec(
                        wkKeisanWExtBean.getSyouhncd(),
                        wkKeisanWExtBean.getTuukasyu(),
                        tmmshanteiymdSisuu,
                        tykzentmmshanteiymdSisuu,
                        BizNumber.ZERO,
                        BizNumber.ZERO,
                        wkKeisanWExtBean.getSisuurendoutmttkngk(),
                        pRendouRitu);

                    if (C_ErrorKbn.ERROR.eq(errorKbn)) {
                        throw new CommonBizAppException(ERROR_MSG_2);
                    }

                    editWSuiihyouBean.setSisuuupritu(keisanTmHntiSisuuRendouTmttkn.getSisuuUpRitu().round(2, RoundingMode.DOWN));
                    editWSuiihyouBean.setTmttknzoukaritu(keisanTmHntiSisuuRendouTmttkn.getTmttknZoukaRitu());
                    editWSuiihyouBean.setTmttKngk(keisanTmHntiSisuuRendouTmttkn.getSisuurendoutmttkngk());
                    wkKeisanWExtBean.setSisuurendoutmttkngk(keisanTmHntiSisuuRendouTmttkn.getSisuurendoutmttkngk());
                    wkKeisanWExtBean.setTmttkntaisyouym(calckijyunYm);
                }

                if (C_MvaTekiyoujyoutaiKbn.MVAARI.eq(mvaTekiyoujyoutaiKbn)) {
                    wkKeisanWExtBean.setKaiyakusjkkktyouseiriritu(kaiyakuSjkTsRitu);

                    errorKbn = keisanW.exec(calcKijyunYmd, calckijyunYm, wkKeisanWExtBean);
                    if (C_ErrorKbn.ERROR.eq(errorKbn)) {
                        throw new CommonBizAppException(ERROR_MSG);
                    }

                    editWSuiihyouBean.setSjkkktusirrtSame(wkKeisanWExtBean.getKaiyakusjkkktyouseiriritu());
                    editWSuiihyouBean.setTmttkgkKykkjmaeSame(keisanW.getKaiyakukjMaeW());
                    editWSuiihyouBean.setKaiyakuHrKngakSame(keisanW.getW());
                    editWSuiihyouBean.setTmttKngk(keisanW.getSisuurendouTmttkngk());
                    suiihyouExtBean.setKaiyakuKjRitu(keisanW.getKaiyakukjritu());
                    suiihyouExtBean.setKaiyakuKjgk(keisanW.getKaiyakukjgk());

                    wkKeisanWExtBean.setKaiyakusjkkktyouseiriritu(kaiyakuSjkTsRituUp);

                    errorKbn = keisanW.exec(calcKijyunYmd, calckijyunYm, wkKeisanWExtBean);
                    if (C_ErrorKbn.ERROR.eq(errorKbn)) {
                        throw new CommonBizAppException(ERROR_MSG);
                    }

                    editWSuiihyouBean.setSjkkktusirrtUp(wkKeisanWExtBean.getKaiyakusjkkktyouseiriritu());
                    editWSuiihyouBean.setTmttkgkKykkjmaeUp(keisanW.getKaiyakukjMaeW());
                    editWSuiihyouBean.setKaiyakuHrKngakUp(keisanW.getW());

                    wkKeisanWExtBean.setKaiyakusjkkktyouseiriritu(kaiyakuSjkTsRituDown);

                    errorKbn = keisanW.exec(calcKijyunYmd, calckijyunYm, wkKeisanWExtBean);
                    if (C_ErrorKbn.ERROR.eq(errorKbn)) {
                        throw new CommonBizAppException(ERROR_MSG);
                    }

                    editWSuiihyouBean.setSjkkktusirrtDown(wkKeisanWExtBean.getKaiyakusjkkktyouseiriritu());
                    editWSuiihyouBean.setTmttkgkKykkjmaeDown(keisanW.getKaiyakukjMaeW());
                    editWSuiihyouBean.setKaiyakuHrKngakDown(keisanW.getW());
                }
                else {
                    editWSuiihyouBean.setKaiyakuHrKngak(editWSuiihyouBean.getTmttKngk());
                    suiihyouExtBean.setKaiyakuKjRitu(BizNumber.ZERO);
                    suiihyouExtBean.setKaiyakuKjgk(BizCurrency.valueOf(new BigDecimal(0)));
                }

                suiihyouExtBean.setSisuuUpCount1(sisuUpCount);
                suiihyouExtBean.setSisuuDownCount1(sisuDownCount);
            }
            editWSuiihyouBeanList.add(editWSuiihyouBean);

            if (C_YouhiKbn.YOU.eq(pSuiihyouExtBeanYhKbn)) {
                suiihyouExtBeanLst.add(suiihyouExtBean);
            }
        }

        logger.debug("△ 解約返戻金推移表作成（年金３）_指数金額取得 終了");

        return editWSuiihyouBeanList;
    }

    private List<IT_Suiihyou> makeTeirituWSuiihyou(
        WSuiihyouParam pWsuiihyouParam,
        List<BizDate> pCalcKijyunYmdList,
        List<BizDateYM> pCalcKijyunYMList,
        List<EditWSuiihyouBean> pEditWsuiihyouBean,
        BizNumber pKawaseRate) {

        logger.debug("▽ 解約返戻金推移表作成（年金３）_定率推移表作成 開始");

        List<IT_Suiihyou> suiihyouList = new ArrayList<>();

        for (int clcKjnYmdIdx = 0; clcKjnYmdIdx < pCalcKijyunYmdList.size(); clcKjnYmdIdx++) {

            IT_Suiihyou suiihyou = new IT_Suiihyou();
            BizDate calcKijyunYmd = pCalcKijyunYmdList.get(clcKjnYmdIdx);
            BizDateYM calckijyunYm = pCalcKijyunYMList.get(clcKjnYmdIdx);
            EditWSuiihyouBean editWsuiihyouBean = pEditWsuiihyouBean.get(clcKjnYmdIdx);

            suiihyou.setMkhyouyensysnikougk(pWsuiihyouParam.getTargetTkykKijyungk());
            suiihyou.setKeikanensuu(BizDateUtil.calcDifference(calcKijyunYmd, pWsuiihyouParam.getKeisanWExtBean().getKykymd()).getYears());
            suiihyou.setCalckijyunymd(calcKijyunYmd);
            suiihyou.setCalcym(calckijyunYm);
            suiihyou.setMvatekijyoutaikbn(editWsuiihyouBean.getMvaTekiyoujyoutaiKbn());
            suiihyou.setSuiihyousyubetu(SUIIHYOUSYUBETU_TEIRITU);

            BizNumber kawaserateHndhbEndaka = BizNumber.ZERO;
            BizNumber kawaserateHndhbEnyasu = BizNumber.ZERO;
            if (pKawaseRate.compareTo(BizNumber.valueOf(0)) != 0){
                kawaserateHndhbEndaka = YuyuHozenConfig.getInstance().getKawaserateHendouYenup();
                kawaserateHndhbEnyasu = YuyuHozenConfig.getInstance().getKawaserateHendouYendown();
            }
            BizNumber kawaserateEndaka = pKawaseRate.subtract(kawaserateHndhbEndaka);
            BizNumber kawaserateEnyasi = pKawaseRate.add(kawaserateHndhbEnyasu);

            suiihyou.setYenknsnkwsrateyendaka(kawaserateEndaka);
            suiihyou.setYenknsnkwsrateyenkijyun(pKawaseRate);
            suiihyou.setYenknsnkwsrateyenyasu(kawaserateEnyasi);
            suiihyou.setYenknsnkwsrategkyendaka(
                BizCurrency.valueOf(new BigDecimal(kawaserateHndhbEndaka.toString()), BizCurrencyTypes.YEN));
            suiihyou.setYenknsnkwsrategkyenyasu(
                BizCurrency.valueOf(new BigDecimal(kawaserateHndhbEnyasu.toString()), BizCurrencyTypes.YEN));

            if (C_MvaTekiyoujyoutaiKbn.MVAARI.eq(suiihyou.getMvatekijyoutaikbn())) {
                suiihyou.setSjkkktusirrtup(editWsuiihyouBean.getSjkkktusirrtUp());
                suiihyou.setSjkkktusirrtsame(editWsuiihyouBean.getSjkkktusirrtSame());
                suiihyou.setSjkkktusirrtdown(editWsuiihyouBean.getSjkkktusirrtDown());
                suiihyou.setSjkkktusirrthendouup(YuyuHozenConfig.getInstance().getSuiihyouYoteirirituUp());
                suiihyou.setSjkkktusirrthendoudown(YuyuHozenConfig.getInstance().getSuiihyouYoteirirituDown());

                suiihyou.setMvaariptumitatekin(editWsuiihyouBean.getTmttKngk());
                suiihyou.setTutmttknutiwake11(editWsuiihyouBean.getTmttKngk());
                suiihyou.setMvaaritmttkgkkykkjmaeup1(editWsuiihyouBean.getTmttkgkKykkjmaeUp());
                suiihyou.setMvaaritmttkgkkykkjmaesame1(editWsuiihyouBean.getTmttkgkKykkjmaeSame());
                suiihyou.setMvaaritmttkgkkykkjmaedown1(editWsuiihyouBean.getTmttkgkKykkjmaeDown());
                suiihyou.setMvaariwup(editWsuiihyouBean.getKaiyakuHrKngakUp());
                suiihyou.setMvaariwsame(editWsuiihyouBean.getKaiyakuHrKngakSame());
                suiihyou.setMvaariwdown(editWsuiihyouBean.getKaiyakuHrKngakDown());

                List<BizCurrency> yenKnsnWList = getKaiyakuhrknYenKnsn(
                    suiihyou.getMvaariwup(),
                    kawaserateEndaka,
                    pKawaseRate,
                    kawaserateEnyasi);
                suiihyou.setMvaariwyenupyendaka(yenKnsnWList.get(0));
                suiihyou.setMvaariwyenupyenkijyun(yenKnsnWList.get(1));
                suiihyou.setMvaariwyenupyenyasu(yenKnsnWList.get(2));

                yenKnsnWList = getKaiyakuhrknYenKnsn(
                    suiihyou.getMvaariwsame(),
                    kawaserateEndaka,
                    pKawaseRate,
                    kawaserateEnyasi);
                suiihyou.setMvaariwyensameyendaka(yenKnsnWList.get(0));
                suiihyou.setMvaariwyensameyenkijyun(yenKnsnWList.get(1));
                suiihyou.setMvaariwyensameyenyasu(yenKnsnWList.get(2));

                yenKnsnWList = getKaiyakuhrknYenKnsn(
                    suiihyou.getMvaariwdown(),
                    kawaserateEndaka,
                    pKawaseRate,
                    kawaserateEnyasi);
                suiihyou.setMvaariwyendownyendaka(yenKnsnWList.get(0));
                suiihyou.setMvaariwyendownyenkijyun(yenKnsnWList.get(1));
                suiihyou.setMvaariwyendownyenyasu(yenKnsnWList.get(2));
            }else{
                suiihyou.setMvanoneptumitatekin(editWsuiihyouBean.getTmttKngk());
                suiihyou.setMvanonewsame(editWsuiihyouBean.getKaiyakuHrKngak());

                List<BizCurrency> yenKnsnWList = getKaiyakuhrknYenKnsn(
                    suiihyou.getMvanonewsame(),
                    kawaserateEndaka,
                    pKawaseRate,
                    kawaserateEnyasi);
                suiihyou.setMvanonewyensameyendaka(yenKnsnWList.get(0));
                suiihyou.setMvanonewyensameyenkijyun(yenKnsnWList.get(1));
                suiihyou.setMvanonewyensameyenyasu(yenKnsnWList.get(2));
            }

            BizPropertyInitializer.initialize(suiihyou);

            suiihyouList.add(suiihyou);
        }
        logger.debug("△ 解約返戻金推移表作成（年金３）_定率推移表作成 終了");

        return suiihyouList;
    }

    private List<IT_Suiihyou> makeSisuuWSuiihyou(
        WSuiihyouParam pWsuiihyouParam,
        List<BizDate> pCalcKijyunYmdList,
        List<BizDateYM> pCalcKijyunYMList,
        String pSuiihyousyubetu,
        List<EditWSuiihyouBean> pEditWsuiihyouBean1,
        List<EditWSuiihyouBean> pEditWsuiihyouBean2,
        List<EditWSuiihyouBean> pEditWsuiihyouBean3,
        BizNumber pKawaseRate) {

        logger.debug("▽ 解約返戻金推移表作成（年金３）_指数推移表作成 開始");

        List<IT_Suiihyou> suiihyouList = new ArrayList<>();

        for (int clcKjnYmdIdx = 0; clcKjnYmdIdx < pCalcKijyunYmdList.size(); clcKjnYmdIdx++) {

            IT_Suiihyou suiihyou = new IT_Suiihyou();
            BizDate calcKijyunYmd = pCalcKijyunYmdList.get(clcKjnYmdIdx);
            BizDateYM calckijyunYm = pCalcKijyunYMList.get(clcKjnYmdIdx);
            EditWSuiihyouBean editWsuiihyouBean1 = pEditWsuiihyouBean1.get(clcKjnYmdIdx);
            EditWSuiihyouBean editWsuiihyouBean2 = pEditWsuiihyouBean2.get(clcKjnYmdIdx);
            EditWSuiihyouBean editWsuiihyouBean3 = pEditWsuiihyouBean3.get(clcKjnYmdIdx);

            suiihyou.setMkhyouyensysnikougk(pWsuiihyouParam.getTargetTkykKijyungk());
            suiihyou.setKeikanensuu(BizDateUtil.calcDifference(calcKijyunYmd, pWsuiihyouParam.getKeisanWExtBean().getKykymd()).getYears());
            suiihyou.setCalckijyunymd(calcKijyunYmd);
            suiihyou.setCalcym(calckijyunYm);
            suiihyou.setMvatekijyoutaikbn(editWsuiihyouBean1.getMvaTekiyoujyoutaiKbn());
            suiihyou.setSuiihyousyubetu(pSuiihyousyubetu);

            BizNumber kawaserateHndhbEndaka = BizNumber.ZERO;
            BizNumber kawaserateHndhbEnyasu = BizNumber.ZERO;
            if (pKawaseRate.compareTo(BizNumber.valueOf(0)) != 0){
                kawaserateHndhbEndaka = YuyuHozenConfig.getInstance().getKawaserateHendouYenup();
                kawaserateHndhbEnyasu = YuyuHozenConfig.getInstance().getKawaserateHendouYendown();
            }
            BizCurrency kawaserateHndhbEndakaBC = BizCurrency.valueOf(new BigDecimal(kawaserateHndhbEndaka.toString()), BizCurrencyTypes.YEN);
            BizCurrency kawaserateHndhbEnyasuBC = BizCurrency.valueOf(new BigDecimal(kawaserateHndhbEnyasu.toString()), BizCurrencyTypes.YEN);

            BizNumber kawaserateEndaka = pKawaseRate.subtract(kawaserateHndhbEndaka);
            BizNumber kawaserateEnyasi = pKawaseRate.add(kawaserateHndhbEnyasu);

            suiihyou.setYenknsnkwsrateyendaka(kawaserateEndaka);
            suiihyou.setYenknsnkwsrateyenkijyun(pKawaseRate);
            suiihyou.setYenknsnkwsrateyenyasu(kawaserateEnyasi);
            suiihyou.setYenknsnkwsrategkyendaka(kawaserateHndhbEndakaBC);
            suiihyou.setYenknsnkwsrategkyenyasu(kawaserateHndhbEnyasuBC);

            suiihyou.setSisuuupritu1(editWsuiihyouBean1.getSisuuupritu());
            suiihyou.setTmttknzoukaritu1(editWsuiihyouBean1.getTmttknzoukaritu());

            if (!C_MvaTekiyoujyoutaiKbn.BLNK.eq(editWsuiihyouBean2.getMvaTekiyoujyoutaiKbn())) {
                suiihyou.setYenknsnkwsrateyendaka2(kawaserateEndaka);
                suiihyou.setYenknsnkwsrateyenkijyun2(pKawaseRate);
                suiihyou.setYenknsnkwsrateyenyasu2(kawaserateEnyasi);
                suiihyou.setYenknsnkwsrategkyendaka2(kawaserateHndhbEndakaBC);
                suiihyou.setYenknsnkwsrategkyenyasu2(kawaserateHndhbEnyasuBC);

                suiihyou.setSisuuupritu2(editWsuiihyouBean2.getSisuuupritu());
                suiihyou.setTmttknzoukaritu2(editWsuiihyouBean2.getTmttknzoukaritu());
            }

            if (!C_MvaTekiyoujyoutaiKbn.BLNK.eq(editWsuiihyouBean3.getMvaTekiyoujyoutaiKbn())) {
                suiihyou.setYenknsnkwsrateyendaka3(kawaserateEndaka);
                suiihyou.setYenknsnkwsrateyenkijyun3(pKawaseRate);
                suiihyou.setYenknsnkwsrateyenyasu3(kawaserateEnyasi);
                suiihyou.setYenknsnkwsrategkyendaka3(kawaserateHndhbEndakaBC);
                suiihyou.setYenknsnkwsrategkyenyasu3(kawaserateHndhbEnyasuBC);

                suiihyou.setSisuuupritu3(editWsuiihyouBean3.getSisuuupritu());
                suiihyou.setTmttknzoukaritu3(editWsuiihyouBean3.getTmttknzoukaritu());
            }

            if (C_MvaTekiyoujyoutaiKbn.MVAARI.eq(suiihyou.getMvatekijyoutaikbn())) {
                suiihyou.setSjkkktusirrtup(editWsuiihyouBean1.getSjkkktusirrtUp());
                suiihyou.setSjkkktusirrtsame(editWsuiihyouBean1.getSjkkktusirrtSame());
                suiihyou.setSjkkktusirrtdown(editWsuiihyouBean1.getSjkkktusirrtDown());
                suiihyou.setSjkkktusirrthendouup(YuyuHozenConfig.getInstance().getSuiihyouYoteirirituUp());
                suiihyou.setSjkkktusirrthendoudown(YuyuHozenConfig.getInstance().getSuiihyouYoteirirituDown());

                suiihyou.setMvaariptumitatekin(editWsuiihyouBean1.getTmttKngk());
                suiihyou.setTutmttknutiwake21(editWsuiihyouBean1.getTmttKngk());
                suiihyou.setMvaaritmttkgkkykkjmaeup1(editWsuiihyouBean1.getTmttkgkKykkjmaeUp());
                suiihyou.setMvaaritmttkgkkykkjmaesame1(editWsuiihyouBean1.getTmttkgkKykkjmaeSame());
                suiihyou.setMvaaritmttkgkkykkjmaedown1(editWsuiihyouBean1.getTmttkgkKykkjmaeDown());
                suiihyou.setMvaariwup(editWsuiihyouBean1.getKaiyakuHrKngakUp());
                suiihyou.setMvaariwsame(editWsuiihyouBean1.getKaiyakuHrKngakSame());
                suiihyou.setMvaariwdown(editWsuiihyouBean1.getKaiyakuHrKngakDown());

                List<BizCurrency> yenKnsnWList = getKaiyakuhrknYenKnsn(
                    suiihyou.getMvaariwup(),
                    kawaserateEndaka,
                    pKawaseRate,
                    kawaserateEnyasi);
                suiihyou.setMvaariwyenupyendaka(yenKnsnWList.get(0));
                suiihyou.setMvaariwyenupyenkijyun(yenKnsnWList.get(1));
                suiihyou.setMvaariwyenupyenyasu(yenKnsnWList.get(2));

                yenKnsnWList = getKaiyakuhrknYenKnsn(
                    suiihyou.getMvaariwsame(),
                    kawaserateEndaka,
                    pKawaseRate,
                    kawaserateEnyasi);
                suiihyou.setMvaariwyensameyendaka(yenKnsnWList.get(0));
                suiihyou.setMvaariwyensameyenkijyun(yenKnsnWList.get(1));
                suiihyou.setMvaariwyensameyenyasu(yenKnsnWList.get(2));

                yenKnsnWList = getKaiyakuhrknYenKnsn(
                    suiihyou.getMvaariwdown(),
                    kawaserateEndaka,
                    pKawaseRate,
                    kawaserateEnyasi);
                suiihyou.setMvaariwyendownyendaka(yenKnsnWList.get(0));
                suiihyou.setMvaariwyendownyenkijyun(yenKnsnWList.get(1));
                suiihyou.setMvaariwyendownyenyasu(yenKnsnWList.get(2));
            }
            if (C_MvaTekiyoujyoutaiKbn.MVAARI.eq(editWsuiihyouBean2.getMvaTekiyoujyoutaiKbn())) {
                suiihyou.setSjkkktusirrtup2(editWsuiihyouBean2.getSjkkktusirrtUp());
                suiihyou.setSjkkktusirrtsame2(editWsuiihyouBean2.getSjkkktusirrtSame());
                suiihyou.setSjkkktusirrtdown2(editWsuiihyouBean2.getSjkkktusirrtDown());
                suiihyou.setSjkkktusirrthendouup2(YuyuHozenConfig.getInstance().getSuiihyouYoteirirituUp());
                suiihyou.setSjkkktusirrthendoudown2(YuyuHozenConfig.getInstance().getSuiihyouYoteirirituDown());

                suiihyou.setMvaariptumitatekin2(editWsuiihyouBean2.getTmttKngk());
                suiihyou.setTutmttknutiwake22(editWsuiihyouBean2.getTmttKngk());
                suiihyou.setMvaaritmttkgkkykkjmaeup2(editWsuiihyouBean2.getTmttkgkKykkjmaeUp());
                suiihyou.setMvaaritmttkgkkykkjmaesame2(editWsuiihyouBean2.getTmttkgkKykkjmaeSame());
                suiihyou.setMvaaritmttkgkkykkjmaedown2(editWsuiihyouBean2.getTmttkgkKykkjmaeDown());
                suiihyou.setMvaariwup2(editWsuiihyouBean2.getKaiyakuHrKngakUp());
                suiihyou.setMvaariwsame2(editWsuiihyouBean2.getKaiyakuHrKngakSame());
                suiihyou.setMvaariwdown2(editWsuiihyouBean2.getKaiyakuHrKngakDown());

                List<BizCurrency> yenKnsnWList = getKaiyakuhrknYenKnsn(
                    suiihyou.getMvaariwup2(),
                    kawaserateEndaka,
                    pKawaseRate,
                    kawaserateEnyasi);
                suiihyou.setMvaariwyenupyendaka2(yenKnsnWList.get(0));
                suiihyou.setMvaariwyenupyenkijyun2(yenKnsnWList.get(1));
                suiihyou.setMvaariwyenupyenyasu2(yenKnsnWList.get(2));

                yenKnsnWList = getKaiyakuhrknYenKnsn(
                    suiihyou.getMvaariwsame2(),
                    kawaserateEndaka,
                    pKawaseRate,
                    kawaserateEnyasi);
                suiihyou.setMvaariwyensameyendaka2(yenKnsnWList.get(0));
                suiihyou.setMvaariwyensameyenkijyun2(yenKnsnWList.get(1));
                suiihyou.setMvaariwyensameyenyasu2(yenKnsnWList.get(2));

                yenKnsnWList = getKaiyakuhrknYenKnsn(
                    suiihyou.getMvaariwdown2(),
                    kawaserateEndaka,
                    pKawaseRate,
                    kawaserateEnyasi);
                suiihyou.setMvaariwyendownyendaka2(yenKnsnWList.get(0));
                suiihyou.setMvaariwyendownyenkijyun2(yenKnsnWList.get(1));
                suiihyou.setMvaariwyendownyenyasu2(yenKnsnWList.get(2));
            }
            if (C_MvaTekiyoujyoutaiKbn.MVAARI.eq(editWsuiihyouBean3.getMvaTekiyoujyoutaiKbn())) {
                suiihyou.setSjkkktusirrtup3(editWsuiihyouBean3.getSjkkktusirrtUp());
                suiihyou.setSjkkktusirrtsame3(editWsuiihyouBean3.getSjkkktusirrtSame());
                suiihyou.setSjkkktusirrtdown3(editWsuiihyouBean3.getSjkkktusirrtDown());
                suiihyou.setSjkkktusirrthendouup3(YuyuHozenConfig.getInstance().getSuiihyouYoteirirituUp());
                suiihyou.setSjkkktusirrthendoudown3(YuyuHozenConfig.getInstance().getSuiihyouYoteirirituDown());

                suiihyou.setMvaariptumitatekin3(editWsuiihyouBean3.getTmttKngk());
                suiihyou.setTutmttknutiwake23(editWsuiihyouBean3.getTmttKngk());
                suiihyou.setMvaaritmttkgkkykkjmaeup3(editWsuiihyouBean3.getTmttkgkKykkjmaeUp());
                suiihyou.setMvaaritmttkgkkykkjmaesame3(editWsuiihyouBean3.getTmttkgkKykkjmaeSame());
                suiihyou.setMvaaritmttkgkkykkjmaedown3(editWsuiihyouBean3.getTmttkgkKykkjmaeDown());
                suiihyou.setMvaariwup3(editWsuiihyouBean3.getKaiyakuHrKngakUp());
                suiihyou.setMvaariwsame3(editWsuiihyouBean3.getKaiyakuHrKngakSame());
                suiihyou.setMvaariwdown3(editWsuiihyouBean3.getKaiyakuHrKngakDown());

                List<BizCurrency> yenKnsnWList = getKaiyakuhrknYenKnsn(
                    suiihyou.getMvaariwup3(),
                    kawaserateEndaka,
                    pKawaseRate,
                    kawaserateEnyasi);
                suiihyou.setMvaariwyenupyendaka3(yenKnsnWList.get(0));
                suiihyou.setMvaariwyenupyenkijyun3(yenKnsnWList.get(1));
                suiihyou.setMvaariwyenupyenyasu3(yenKnsnWList.get(2));

                yenKnsnWList = getKaiyakuhrknYenKnsn(
                    suiihyou.getMvaariwsame3(),
                    kawaserateEndaka,
                    pKawaseRate,
                    kawaserateEnyasi);
                suiihyou.setMvaariwyensameyendaka3(yenKnsnWList.get(0));
                suiihyou.setMvaariwyensameyenkijyun3(yenKnsnWList.get(1));
                suiihyou.setMvaariwyensameyenyasu3(yenKnsnWList.get(2));

                yenKnsnWList = getKaiyakuhrknYenKnsn(
                    suiihyou.getMvaariwdown3(),
                    kawaserateEndaka,
                    pKawaseRate,
                    kawaserateEnyasi);
                suiihyou.setMvaariwyendownyendaka3(yenKnsnWList.get(0));
                suiihyou.setMvaariwyendownyenkijyun3(yenKnsnWList.get(1));
                suiihyou.setMvaariwyendownyenyasu3(yenKnsnWList.get(2));
            }

            if (C_MvaTekiyoujyoutaiKbn.MVANONE.eq(suiihyou.getMvatekijyoutaikbn())) {
                suiihyou.setMvanoneptumitatekin(editWsuiihyouBean1.getTmttKngk());
                suiihyou.setMvanonewsame(editWsuiihyouBean1.getKaiyakuHrKngak());

                List<BizCurrency> yenKnsnWList = getKaiyakuhrknYenKnsn(
                    suiihyou.getMvanonewsame(),
                    kawaserateEndaka,
                    pKawaseRate,
                    kawaserateEnyasi);
                suiihyou.setMvanonewyensameyendaka(yenKnsnWList.get(0));
                suiihyou.setMvanonewyensameyenkijyun(yenKnsnWList.get(1));
                suiihyou.setMvanonewyensameyenyasu(yenKnsnWList.get(2));
            }
            if (C_MvaTekiyoujyoutaiKbn.MVANONE.eq(editWsuiihyouBean2.getMvaTekiyoujyoutaiKbn())) {
                suiihyou.setMvanoneptumitatekin2(editWsuiihyouBean2.getTmttKngk());
                suiihyou.setMvanonewsame2(editWsuiihyouBean2.getKaiyakuHrKngak());

                List<BizCurrency> yenKnsnWList = getKaiyakuhrknYenKnsn(
                    suiihyou.getMvanonewsame2(),
                    kawaserateEndaka,
                    pKawaseRate,
                    kawaserateEnyasi);
                suiihyou.setMvanonewyensameyendaka2(yenKnsnWList.get(0));
                suiihyou.setMvanonewyensameyenkijyun2(yenKnsnWList.get(1));
                suiihyou.setMvanonewyensameyenyasu2(yenKnsnWList.get(2));
            }
            if (C_MvaTekiyoujyoutaiKbn.MVANONE.eq(editWsuiihyouBean3.getMvaTekiyoujyoutaiKbn())) {
                suiihyou.setMvanoneptumitatekin3(editWsuiihyouBean3.getTmttKngk());
                suiihyou.setMvanonewsame3(editWsuiihyouBean3.getKaiyakuHrKngak());

                List<BizCurrency> yenKnsnWList = getKaiyakuhrknYenKnsn(
                    suiihyou.getMvanonewsame3(),
                    kawaserateEndaka,
                    pKawaseRate,
                    kawaserateEnyasi);
                suiihyou.setMvanonewyensameyendaka3(yenKnsnWList.get(0));
                suiihyou.setMvanonewyensameyenkijyun3(yenKnsnWList.get(1));
                suiihyou.setMvanonewyensameyenyasu3(yenKnsnWList.get(2));
            }

            BizPropertyInitializer.initialize(suiihyou);

            suiihyouList.add(suiihyou);
        }
        logger.debug("△ 解約返戻金推移表作成（年金３）_指数推移表作成 終了");

        return suiihyouList;
    }
}
