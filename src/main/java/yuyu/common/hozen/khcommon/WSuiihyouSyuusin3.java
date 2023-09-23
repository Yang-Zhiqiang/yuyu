package yuyu.common.hozen.khcommon;

import java.math.BigDecimal;
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
import yuyu.common.hozen.ascommon.KeisanZennouSeisanGk2;
import yuyu.common.hozen.ascommon.KykOutoubiZennouZndkBean;
import yuyu.common.siharai.sicommon.SiCalcKihrkmpstgk;
import yuyu.common.siharai.sicommon.SiCalcKihrkmpstgkBean;
import yuyu.def.classification.C_EigyoubiHoseiKbn;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_HasuusyoriKbn;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_IkkatubaraiKbn;
import yuyu.def.classification.C_KawaserateSyuruiKbn;
import yuyu.def.classification.C_KawasetekiyoKbn;
import yuyu.def.classification.C_KawasetsryKbn;
import yuyu.def.classification.C_KknsmnKbn;
import yuyu.def.classification.C_SysKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_TykzentykgoKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_YouhiKbn;
import yuyu.def.db.entity.IT_Suiihyou;
import yuyu.def.hozen.configuration.YuyuHozenConfig;

/**
 * 契約保全 契約保全共通 解約返戻金推移表作成（終身３）
 */
public class WSuiihyouSyuusin3 {

    private final static String ERROR_MSG = "解約返戻金計算が実行できませんでした。";

    private final static String ERROR_MSG_2 = "前納精算額計算が実行できませんでした。";

    private final static String ERROR_MSG_3 = "保険金額計算が実行できませんでした。";

    private final static String SUIIHYOUSYUBETU_YEN_ZENNNOU_NASHI = "20";

    private final static String SUIIHYOUSYUBETU_YEN_ZENNNOU_ARI = "21";

    private final static String SUIIHYOUSYUBETU_GAI_ZENNNOU_NASHI = "22";

    private final static String SUIIHYOUSYUBETU_GAI_ZENNNOU_ARI = "23";

    private C_YouhiKbn yenkansannYhKbn = C_YouhiKbn.YOU;

    private List<SibouSBean> sibouSBeanList = new ArrayList<>();

    @Inject
    private static Logger logger;

    public WSuiihyouSyuusin3() {
        super();
    }

    public void setYenkansannYhKbn(C_YouhiKbn pYenkansannYhKbn) {
        yenkansannYhKbn = pYenkansannYhKbn;
    }

    public List<SibouSBean> getSibouSBeanList() {
        return sibouSBeanList;
    }

    public List<IT_Suiihyou> exec(WSuiihyouParam pWSuiihyouParam) {

        logger.debug("▽ 解約返戻金推移表作成（終身３） 開始");

        GetKawaseRate getKawaseRate = SWAKInjector.getInstance(GetKawaseRate.class);
        BizNumber kawaserateCenter = BizNumber.ZERO;
        BizNumber kawaserateEndaka = BizNumber.ZERO;
        BizNumber kawaserateEnyasu = BizNumber.ZERO;
        BizNumber kwsRateHendHbYendaka = YuyuHozenConfig.getInstance().getKawaserateHendouYenup();
        BizNumber kwsRateHendHbYenyasu = YuyuHozenConfig.getInstance().getKawaserateHendouYendown();

        if (C_YouhiKbn.YOU.eq(yenkansannYhKbn)) {

            getKawaseRate.execFstPNyuukin(
                pWSuiihyouParam.getKwsratekjymd(),
                pWSuiihyouParam.getKeisanWExtBean().getTuukasyu(),
                C_Tuukasyu.JPY,
                C_YouhiKbn.HUYOU,
                pWSuiihyouParam.getKeisanWExtBean().getHrkkaisuu(),
                C_SysKbn.SKEI,
                pWSuiihyouParam.getZennouUmuKbn(),
                C_IkkatubaraiKbn.BLNK);

            getKawaseRate.exec(
                getKawaseRate.getKwsrateKjYmd(),
                C_KawaserateSyuruiKbn.KOUJIKAWASERATE,
                pWSuiihyouParam.getKeisanWExtBean().getTuukasyu(),
                C_Tuukasyu.JPY,
                C_KawasetekiyoKbn.TTM,
                C_KawasetsryKbn.SYUKKINRATE,
                C_EigyoubiHoseiKbn.YOKUEIGYOUBI,
                C_YouhiKbn.HUYOU );

            kawaserateCenter = getKawaseRate.getKawaserate();
            kawaserateEndaka = kawaserateCenter.subtract(kwsRateHendHbYendaka);
            kawaserateEnyasu = kawaserateCenter.add(kwsRateHendHbYenyasu);
        }

        SetManryoubi setManryoubi = SWAKInjector.getInstance(SetManryoubi.class);
        BizDate hrkkknmnryymd = null;
        int hrkkknNen = 0;

        hrkkknmnryymd = setManryoubi.exec(
            pWSuiihyouParam.getKeisanWExtBean().getKykymd(),
            pWSuiihyouParam.getKeisanWExtBean().getHhknnen(),
            pWSuiihyouParam.getKeisanWExtBean().getHrkkkn(),
            C_KknsmnKbn.valueOf(pWSuiihyouParam.getKeisanWExtBean().getHrkkknsmnkbn().getValue()));

        hrkkknNen = pWSuiihyouParam.getKeisanWExtBean().getHrkkkn() - pWSuiihyouParam.getKeisanWExtBean().getHhknnen();

        List<BizDate> calcKijyunYmdList = new ArrayList<>();
        List<BizDateYM> calcKijyunYMList = new ArrayList<>();
        List<Integer> keikanensuuList = new ArrayList<>();
        BizDate calcKijyunYmdForMkWList;
        BizDate calcKijyunYmdForMkWListHosei;
        BizDate OutoubiRekijouNashi;
        int keikanensuu = 0;

        SetOutoubi setOutoubi = SWAKInjector.getInstance(SetOutoubi.class);

        calcKijyunYmdForMkWList = setOutoubi.exec(
            C_TykzentykgoKbn.TYKGO,
            pWSuiihyouParam.getKeisanWExtBean().getKykymd(),
            C_Hrkkaisuu.NEN,
            pWSuiihyouParam.getCalcKijyunYmd());

        OutoubiRekijouNashi = BizDate.valueOf(calcKijyunYmdForMkWList.getYear(),pWSuiihyouParam.getKeisanWExtBean().getKykymd().getBizDateMD());

        if(BizDateUtil.compareYmd(calcKijyunYmdForMkWList,OutoubiRekijouNashi) == BizDateUtil.COMPARE_EQUAL){
            calcKijyunYmdForMkWListHosei = calcKijyunYmdForMkWList;
        }else{
            calcKijyunYmdForMkWListHosei = calcKijyunYmdForMkWList.getNextDay();
        }

        keikanensuu = BizDateUtil.calcDifference(calcKijyunYmdForMkWListHosei, pWSuiihyouParam.getKeisanWExtBean().getKykymd()).getYears();

        while (pWSuiihyouParam.getKeisanWExtBean().getHhknnen() + keikanensuu <= 105){

            BizDate calcKijyunYmdForMkWListMae = calcKijyunYmdForMkWList.getPreviousDay();

            if (BizDateUtil.compareYmd(calcKijyunYmdForMkWListMae, hrkkknmnryymd) == BizDateUtil.COMPARE_LESSER){
                calcKijyunYmdList.add(calcKijyunYmdForMkWListMae);
                calcKijyunYMList.add(calcKijyunYmdForMkWList.getBizDateYM());
                keikanensuuList.add(keikanensuu - 1);
            }
            if (BizDateUtil.compareYmd(calcKijyunYmdForMkWList, hrkkknmnryymd) == BizDateUtil.COMPARE_EQUAL){
                calcKijyunYmdList.add(calcKijyunYmdForMkWListHosei);
                calcKijyunYMList.add(calcKijyunYmdForMkWList.getBizDateYM());
                keikanensuuList.add(keikanensuu);
            }
            if (BizDateUtil.compareYmd(calcKijyunYmdForMkWList, hrkkknmnryymd) == BizDateUtil.COMPARE_GREATER){
                calcKijyunYmdList.add(calcKijyunYmdForMkWListMae);
                calcKijyunYMList.add(calcKijyunYmdForMkWList.getBizDateYM());
                keikanensuuList.add(keikanensuu);
            }

            calcKijyunYmdForMkWList = setOutoubi.exec(C_TykzentykgoKbn.TYKGO,
                pWSuiihyouParam.getKeisanWExtBean().getKykymd(),
                C_Hrkkaisuu.NEN,
                calcKijyunYmdForMkWListHosei);

            OutoubiRekijouNashi = BizDate.valueOf(calcKijyunYmdForMkWList.getYear(),pWSuiihyouParam.getKeisanWExtBean().getKykymd().getBizDateMD());

            if(BizDateUtil.compareYmd(calcKijyunYmdForMkWList,OutoubiRekijouNashi) == BizDateUtil.COMPARE_EQUAL){
                calcKijyunYmdForMkWListHosei = calcKijyunYmdForMkWList;
            }else{
                calcKijyunYmdForMkWListHosei = calcKijyunYmdForMkWList.getNextDay();
            }

            keikanensuu = BizDateUtil.calcDifference(calcKijyunYmdForMkWListHosei, pWSuiihyouParam.getKeisanWExtBean().getKykymd()).getYears();
        }

        List<BizDate> calcKijyunYmdSList = new ArrayList<>();
        if (BizDateUtil.compareYmd(pWSuiihyouParam.getCalcKijyunYmd(), hrkkknmnryymd) == BizDateUtil.COMPARE_LESSER){
            calcKijyunYmdSList = makeSKeisanYMDList(
                pWSuiihyouParam.getKeisanWExtBean().getKykymd(),
                hrkkknmnryymd);
        }

        List<BizCurrency> zennouZandakaListForW = makeZennouZandakaList(
            pWSuiihyouParam,
            calcKijyunYmdList,
            hrkkknmnryymd);
        List<BizCurrency> zennouZandakaListForS = makeZennouZandakaList(
            pWSuiihyouParam,
            calcKijyunYmdSList,
            hrkkknmnryymd);

        List<BizCurrency> hrkgkgkList = makeHrkgkgkList(
            pWSuiihyouParam.getKeisanWExtBean().getHokenryou(),
            pWSuiihyouParam.getKeisanWExtBean().getHrkkaisuu(),
            keikanensuuList,
            hrkkknNen);

        List<BizCurrency> wList = makeWList(
            pWSuiihyouParam.getKeisanWExtBean(),
            calcKijyunYmdList,
            calcKijyunYMList);

        List<BizCurrency> sList = makeSList(
            pWSuiihyouParam,
            calcKijyunYmdSList,
            hrkkknmnryymd);

        setSibouSBeanList(calcKijyunYmdSList,
            zennouZandakaListForS,
            sList,
            kawaserateCenter,
            kawaserateEndaka,
            kawaserateEnyasu);

        List<IT_Suiihyou> suiihyouList = new ArrayList<>();

        String suiihyousyubetu = "";

        if(C_Tuukasyu.JPY.eq(pWSuiihyouParam.getKeisanWExtBean().getTuukasyu())){
            if(C_UmuKbn.ARI.eq(pWSuiihyouParam.getZennouUmuKbn())){
                suiihyousyubetu = SUIIHYOUSYUBETU_YEN_ZENNNOU_ARI;
            }else{
                suiihyousyubetu = SUIIHYOUSYUBETU_YEN_ZENNNOU_NASHI;
            }
        }else{
            if(C_UmuKbn.ARI.eq(pWSuiihyouParam.getZennouUmuKbn())){
                suiihyousyubetu = SUIIHYOUSYUBETU_GAI_ZENNNOU_ARI;
            }else{
                suiihyousyubetu = SUIIHYOUSYUBETU_GAI_ZENNNOU_NASHI;
            }
        }

        for (int n = 0; n < calcKijyunYmdList.size(); n++) {
            IT_Suiihyou suiihyou = new IT_Suiihyou();

            C_UmuKbn hrkkknmnryumukbn = C_UmuKbn.NONE;
            BizCurrency kaiyakuHrKngak = wList.get(n);
            BizCurrency zennouzndk = zennouZandakaListForW.get(n);
            BizCurrency hrkgkgk = hrkgkgkList.get(n);
            BizCurrency kaiyakuUktrKngak = kaiyakuHrKngak.add(zennouzndk);

            if(keikanensuuList.get(n).equals(hrkkknNen)){
                hrkkknmnryumukbn = C_UmuKbn.ARI;
            }

            suiihyou.setKeikanensuu(keikanensuuList.get(n));
            suiihyou.setCalckijyunymd(calcKijyunYmdList.get(n));
            suiihyou.setCalcym(calcKijyunYMList.get(n));
            suiihyou.setSuiihyousyubetu(suiihyousyubetu);
            suiihyou.setHrkkknmnryumukbn(hrkkknmnryumukbn);
            suiihyou.setMvanonewsame(kaiyakuHrKngak);
            suiihyou.setKaiyakujuktrgk(kaiyakuUktrKngak);

            if(C_Tuukasyu.JPY.eq(pWSuiihyouParam.getKeisanWExtBean().getTuukasyu())){
                suiihyou.setKihrkmpyen1(hrkgkgk);
                suiihyou.setZennouzndkyen1(zennouzndk);
            }else{
                suiihyou.setKihrkmp1(hrkgkgk);
                suiihyou.setZennouzndk1(zennouzndk);
            }

            if(C_YouhiKbn.YOU.eq(yenkansannYhKbn)){
                List<BizCurrency> kaiyakuHrKngakYenList =
                    getYenKnsnList(kaiyakuHrKngak,
                        kawaserateCenter,
                        kawaserateEndaka,
                        kawaserateEnyasu);

                suiihyou.setYenknsnkwsrateyenkijyun(kawaserateCenter);
                suiihyou.setYenknsnkwsrateyendaka(kawaserateEndaka);
                suiihyou.setYenknsnkwsrateyenyasu(kawaserateEnyasu);
                suiihyou.setYenknsnkwsrategkyendaka(
                    BizCurrency.valueOf(new BigDecimal(kwsRateHendHbYendaka.toString()),BizCurrencyTypes.YEN));
                suiihyou.setYenknsnkwsrategkyenyasu(
                    BizCurrency.valueOf(new BigDecimal(kwsRateHendHbYenyasu.toString()),BizCurrencyTypes.YEN));
                suiihyou.setMvanonewyensameyenkijyun(kaiyakuHrKngakYenList.get(0));
                suiihyou.setMvanonewyensameyendaka(kaiyakuHrKngakYenList.get(1));
                suiihyou.setMvanonewyensameyenyasu(kaiyakuHrKngakYenList.get(2));

                List<BizCurrency> kaiyakuUktrKngakYenList =
                    getYenKnsnList(kaiyakuUktrKngak,
                        kawaserateCenter,
                        kawaserateEndaka,
                        kawaserateEnyasu);
                suiihyou.setKaiyakujuktrgkyenkijyun(kaiyakuUktrKngakYenList.get(0));
                suiihyou.setKaiyakujuktrgkyendaka(kaiyakuUktrKngakYenList.get(1));
                suiihyou.setKaiyakujuktrgkyenyasu(kaiyakuUktrKngakYenList.get(2));
            }

            BizPropertyInitializer.initialize(suiihyou);
            suiihyouList.add(suiihyou);
        }
        logger.debug("△ 解約返戻金推移表作成（終身３） 終了");

        return suiihyouList;
    }

    private List<BizDate> makeSKeisanYMDList(
        BizDate pKykymd,
        BizDate pHrkmMnryYmd) {

        List<BizDate> calcKijyunYmdList = new ArrayList<>();

        BizDate calcKijyunYmdForMkSList;
        BizDate calcKijyunYmdForMkSListHosei;
        BizDate OutoubiRekijouNashi;

        SetOutoubi setOutoubi = SWAKInjector.getInstance(SetOutoubi.class);
        calcKijyunYmdForMkSList = setOutoubi.exec(
            C_TykzentykgoKbn.TYKGO,
            pKykymd,
            C_Hrkkaisuu.NEN,
            pKykymd);

        OutoubiRekijouNashi = BizDate.valueOf(calcKijyunYmdForMkSList.getYear(),pKykymd.getBizDateMD());

        if(BizDateUtil.compareYmd(calcKijyunYmdForMkSList,OutoubiRekijouNashi) == BizDateUtil.COMPARE_EQUAL){
            calcKijyunYmdForMkSListHosei = calcKijyunYmdForMkSList;
        }else{
            calcKijyunYmdForMkSListHosei = calcKijyunYmdForMkSList.getNextDay();
        }

        while (BizDateUtil.compareYmd(calcKijyunYmdForMkSList,pHrkmMnryYmd) == BizDateUtil.COMPARE_LESSER ||
            BizDateUtil.compareYmd(calcKijyunYmdForMkSList,pHrkmMnryYmd) == BizDateUtil.COMPARE_EQUAL ){

            BizDate calcKijyunYmdForMkSListMae = calcKijyunYmdForMkSList.getPreviousDay();

            if (BizDateUtil.compareYmd(calcKijyunYmdForMkSListMae, pHrkmMnryYmd) == BizDateUtil.COMPARE_LESSER){
                calcKijyunYmdList.add(calcKijyunYmdForMkSListMae);
            }
            if (BizDateUtil.compareYmd(calcKijyunYmdForMkSList, pHrkmMnryYmd) == BizDateUtil.COMPARE_EQUAL){
                calcKijyunYmdList.add(calcKijyunYmdForMkSListHosei);
            }

            calcKijyunYmdForMkSList = setOutoubi.exec(
                C_TykzentykgoKbn.TYKGO,
                pKykymd,
                C_Hrkkaisuu.NEN,
                calcKijyunYmdForMkSListHosei);

            OutoubiRekijouNashi = BizDate.valueOf(calcKijyunYmdForMkSList.getYear(),pKykymd.getBizDateMD());

            if(BizDateUtil.compareYmd(calcKijyunYmdForMkSList,OutoubiRekijouNashi) == BizDateUtil.COMPARE_EQUAL){
                calcKijyunYmdForMkSListHosei = calcKijyunYmdForMkSList;
            }else{
                calcKijyunYmdForMkSListHosei = calcKijyunYmdForMkSList.getNextDay();
            }
        }
        return calcKijyunYmdList;
    }

    private List<BizCurrency> makeZennouZandakaList(
        WSuiihyouParam pWSuiihyouParam, List<BizDate> pCalcKijyunYMDList,BizDate pHrkKknMnryYmd) {

        List<BizCurrency> zennouzndkList = new ArrayList<>();

        HenkanTuuka henkanTuuka = SWAKInjector.getInstance(HenkanTuuka.class);
        CurrencyType currencyType =henkanTuuka.henkanTuukaKbnToType(pWSuiihyouParam.getKeisanWExtBean().getTuukasyu());
        BizCurrency zennouzndk = BizCurrency.valueOf(0, currencyType);

        if(C_UmuKbn.ARI.eq(pWSuiihyouParam.getZennouUmuKbn()) &&
            pCalcKijyunYMDList.size() > 0 &&
            BizDateUtil.compareYmd(pCalcKijyunYMDList.get(0), pHrkKknMnryYmd) == BizDateUtil.COMPARE_LESSER ){

            KeisanZennouSeisanGk2 keisanZennouSeisanGk = SWAKInjector.getInstance(KeisanZennouSeisanGk2.class);

            C_ErrorKbn errorKbn = keisanZennouSeisanGk.exec(
                pHrkKknMnryYmd,
                pWSuiihyouParam.getKeisanWExtBean().getKykymd(),
                pWSuiihyouParam.getZennoujiHrkP(),
                pWSuiihyouParam.getZennouKaisiYmd(),
                pWSuiihyouParam.getRyosyuYmd(),
                pWSuiihyouParam.getZennouNyuukingk());

            if (C_ErrorKbn.ERROR.eq(errorKbn)) {
                throw new CommonBizAppException(ERROR_MSG_2);
            }

            List<KykOutoubiZennouZndkBean> kykOutoubiZennouZndkList = keisanZennouSeisanGk.getKykOutoubiZennouZndkList();

            for (BizDate calcKijyunYmdForMkZnnzndk : pCalcKijyunYMDList) {
                if (BizDateUtil.compareYmd(calcKijyunYmdForMkZnnzndk, pHrkKknMnryYmd) == BizDateUtil.COMPARE_LESSER){
                    for (KykOutoubiZennouZndkBean kykOutoubiZennouZndk : kykOutoubiZennouZndkList) {
                        if(calcKijyunYmdForMkZnnzndk.equals(kykOutoubiZennouZndk.getKykOutoubi().getPreviousDay())){
                            zennouzndk = kykOutoubiZennouZndk.getZnnurrttkyjytmaeZnnuzndk();
                            break;
                        }
                    }
                }else{
                    zennouzndk = BizCurrency.valueOf(0, currencyType);
                }
                zennouzndkList.add(zennouzndk);
            }
        }else{
            for (int m = 0; m < pCalcKijyunYMDList.size(); m++) {
                zennouzndkList.add(zennouzndk);
            }
        }
        return zennouzndkList;
    }

    private List<BizCurrency> makeHrkgkgkList(
        BizCurrency pHokenryou, C_Hrkkaisuu pHrkkaisuu, List<Integer> pKikNensuList, int HrkKknNen) {

        List<BizCurrency> hrkgkGkiList = new ArrayList<>();
        BizCurrency hrkgkGki = BizCurrency.valueOf(0);

        for (int n = 0; n < pKikNensuList.size(); n++) {
            if(pKikNensuList.get(n) < HrkKknNen){
                hrkgkGki = pHokenryou.multiply( 12 / Integer.parseInt(pHrkkaisuu.getValue())).multiply(pKikNensuList.get(n) + 1);
            }else{
                hrkgkGki = pHokenryou.multiply( 12 / Integer.parseInt(pHrkkaisuu.getValue())).multiply(HrkKknNen);
            }
            hrkgkGkiList.add(hrkgkGki);
        }
        return hrkgkGkiList;
    }

    private List<BizCurrency> makeWList(KeisanWExtBean pKeisanWExtBean,
        List<BizDate> pCalcKijyunYMDList, List<BizDateYM> pCalcKijyunYMList) {

        List<BizCurrency> wList = new ArrayList<>();

        HenkanTuuka henkanTuuka = SWAKInjector.getInstance(HenkanTuuka.class);
        CurrencyType currencyType =henkanTuuka.henkanTuukaKbnToType(pKeisanWExtBean.getTuukasyu());
        BizCurrency kaiyakuhr = BizCurrency.valueOf(0, currencyType);

        for (int n = 0; n < pCalcKijyunYMDList.size(); n++) {
            KeisanW keisanW = SWAKInjector.getInstance(KeisanW.class);
            C_ErrorKbn errorKbn = keisanW.exec(pCalcKijyunYMDList.get(n), pCalcKijyunYMList.get(n), pKeisanWExtBean);

            if (C_ErrorKbn.ERROR.eq(errorKbn)) {
                throw new CommonBizAppException(ERROR_MSG);
            }
            kaiyakuhr = keisanW.getW();

            wList.add(kaiyakuhr);
        }
        return wList;
    }

    private List<BizCurrency> makeSList(
        WSuiihyouParam pWSuiihyouParam, List<BizDate> pCalcKijyunYMDList,BizDate pHrkKknMnryYmd) {

        List<BizCurrency> sibouSList = new ArrayList<>();

        HenkanTuuka henkanTuuka = SWAKInjector.getInstance(HenkanTuuka.class);
        CurrencyType currencyType =henkanTuuka.henkanTuukaKbnToType(pWSuiihyouParam.getKeisanWExtBean().getTuukasyu());
        BizCurrency sibouS = BizCurrency.valueOf(0, currencyType);

        BizDate outubRekiHoseiNashi =
            BizDate.valueOf(pHrkKknMnryYmd.getYear(), pWSuiihyouParam.getKeisanWExtBean().getKykymd().getBizDateMD());

        for (int n = 0; n < pCalcKijyunYMDList.size(); n++) {

            if (BizDateUtil.compareYmd(pCalcKijyunYMDList.get(n), outubRekiHoseiNashi) == BizDateUtil.COMPARE_LESSER ){
                KeisanWExtBean keisanWExtBean = pWSuiihyouParam.getKeisanWExtBean();

                SiCalcKihrkmpstgkBean siCalcKihrkmpstgkBean = SWAKInjector.getInstance(SiCalcKihrkmpstgkBean.class);
                siCalcKihrkmpstgkBean.setKykYmd(keisanWExtBean.getKykymd());
                siCalcKihrkmpstgkBean.setCalcKijyunYmd(pCalcKijyunYMDList.get(n));
                siCalcKihrkmpstgkBean.setSyouhnCd(keisanWExtBean.getSyouhncd());
                siCalcKihrkmpstgkBean.setRyouriTusdNo(keisanWExtBean.getRyouritusdno());
                siCalcKihrkmpstgkBean.setYoteiRiritu(keisanWExtBean.getYoteiriritu());
                siCalcKihrkmpstgkBean.setHrkKaisuu(keisanWExtBean.getHrkkaisuu());
                siCalcKihrkmpstgkBean.setHhknNen(keisanWExtBean.getHhknnen());
                siCalcKihrkmpstgkBean.setHhknSei(keisanWExtBean.getHhknsei());
                siCalcKihrkmpstgkBean.setHknkknSmnKbn(keisanWExtBean.getHknkknsmnkbn());
                siCalcKihrkmpstgkBean.setHknKkn(keisanWExtBean.getHknkkn());
                siCalcKihrkmpstgkBean.setHrkkknSmnKbn(keisanWExtBean.getHrkkknsmnkbn());
                siCalcKihrkmpstgkBean.setHrkKkn(keisanWExtBean.getHrkkkn());
                siCalcKihrkmpstgkBean.setSdPdKbn(pWSuiihyouParam.getSdpd());
                siCalcKihrkmpstgkBean.setHokenknGk(keisanWExtBean.getKihons());
                siCalcKihrkmpstgkBean.setHokenRyou(keisanWExtBean.getHokenryou());
                siCalcKihrkmpstgkBean.setKykTuukaSyu(keisanWExtBean.getTuukasyu());
                siCalcKihrkmpstgkBean.setKykJyoutai(keisanWExtBean.getKykJyoutai());
                siCalcKihrkmpstgkBean.setDai1HknKkn(keisanWExtBean.getDai1hknkkn());
                siCalcKihrkmpstgkBean.setHrkKeiro(pWSuiihyouParam.getHrkkeiro());

                SiCalcKihrkmpstgk siCalcKihrkmpstgk = SWAKInjector.getInstance(SiCalcKihrkmpstgk.class);
                C_ErrorKbn errorKbn = siCalcKihrkmpstgk.exec(siCalcKihrkmpstgkBean);

                if (C_ErrorKbn.ERROR.eq(errorKbn)) {
                    throw new CommonBizAppException(ERROR_MSG_3);
                }

                sibouS = siCalcKihrkmpstgk.getKiHrkmpstGk();

            }else{
                sibouS = pWSuiihyouParam.getKeisanWExtBean().getKihons();
            }
            sibouSList.add(sibouS);
        }
        return sibouSList;
    }


    private List<BizCurrency> getYenKnsnList(BizCurrency pYenKnsnTisyouKngk,BizNumber pKawaserateCenter,
        BizNumber pKawaserateYendaka,BizNumber pKawaserateYenyasu) {

        List<BizCurrency> yenKnsnLst = null;
        BizCurrency yenKijyun = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);
        BizCurrency yenDaka = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);
        BizCurrency yenYasu = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);
        KeisanGaikakanzan keisanGaikakanzan = SWAKInjector.getInstance(KeisanGaikakanzan.class);

        keisanGaikakanzan.exec(
            C_Tuukasyu.JPY,
            pYenKnsnTisyouKngk,
            pKawaserateCenter,
            C_HasuusyoriKbn.SUTE);
        yenKijyun = keisanGaikakanzan.getKanzanGaku();

        keisanGaikakanzan.exec(
            C_Tuukasyu.JPY,
            pYenKnsnTisyouKngk,
            pKawaserateYendaka,
            C_HasuusyoriKbn.SUTE);
        yenDaka = keisanGaikakanzan.getKanzanGaku();

        keisanGaikakanzan.exec(
            C_Tuukasyu.JPY,
            pYenKnsnTisyouKngk,
            pKawaserateYenyasu,
            C_HasuusyoriKbn.SUTE);
        yenYasu = keisanGaikakanzan.getKanzanGaku();

        yenKnsnLst = new ArrayList<BizCurrency>();
        yenKnsnLst.add(yenKijyun);
        yenKnsnLst.add(yenDaka);
        yenKnsnLst.add(yenYasu);

        return yenKnsnLst;
    }

    private void setSibouSBeanList(List<BizDate> pCalcKijyunYMDList, List<BizCurrency> pZnnZndkList,
        List<BizCurrency> pSList,BizNumber pKawaserateCenter,
        BizNumber pKawaserateYendaka,BizNumber pKawaserateYenyasu) {

        for (int n = 0; n < pCalcKijyunYMDList.size(); n++) {
            SibouSBean sibouSBean = SWAKInjector.getInstance(SibouSBean.class);

            BizCurrency sForMakeSList = pSList.get(n);
            BizCurrency znnZndkForMakeSList = pZnnZndkList.get(n);
            BizCurrency sbjiuktgForMakeSList = sForMakeSList.add(znnZndkForMakeSList);

            sibouSBean.setCalcKijyunYmd(pCalcKijyunYMDList.get(n));
            sibouSBean.setSibouS(sForMakeSList);
            sibouSBean.setZennouZndk(znnZndkForMakeSList);
            sibouSBean.setSibouUktrgk(sbjiuktgForMakeSList);

            if(C_YouhiKbn.YOU.eq(yenkansannYhKbn)){
                List<BizCurrency> sibouUktrgkYenList =
                    getYenKnsnList(sbjiuktgForMakeSList,
                        pKawaserateCenter,
                        pKawaserateYendaka,
                        pKawaserateYenyasu);
                sibouSBean.setSibouUktrgkYen(sibouUktrgkYenList.get(0));
                sibouSBean.setSibouUktrgkYendaka(sibouUktrgkYenList.get(1));
                sibouSBean.setSibouUktrgkYenyasu(sibouUktrgkYenList.get(2));
            }
            sibouSBeanList.add(sibouSBean);
        }
    }
}
