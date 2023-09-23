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
import yuyu.common.biz.bzcommon.GetYoteiriritu;
import yuyu.common.biz.bzcommon.GetYoteirirituBean;
import yuyu.common.biz.bzcommon.KeisanGaikakanzan;
import yuyu.common.biz.exception.CommonBizAppException;
import yuyu.common.hozen.ascommon.KeisanZennouSeisanGk2;
import yuyu.common.hozen.ascommon.KykOutoubiZennouZndkBean;
import yuyu.def.classification.C_EigyoubiHoseiKbn;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_HasuusyoriKbn;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_IkkatubaraiKbn;
import yuyu.def.classification.C_KawaserateSyuruiKbn;
import yuyu.def.classification.C_KawasetekiyoKbn;
import yuyu.def.classification.C_KawasetsryKbn;
import yuyu.def.classification.C_KhSisanSyuruiKbn;
import yuyu.def.classification.C_KknsmnKbn;
import yuyu.def.classification.C_SinsaihkKbn;
import yuyu.def.classification.C_SyoukensaihkKbn;
import yuyu.def.classification.C_SysKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_TykzentykgoKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_YouhiKbn;
import yuyu.def.db.entity.IT_Suiihyou;
import yuyu.def.hozen.configuration.YuyuHozenConfig;

/**
 * 契約保全 契約保全共通 解約返戻金推移表作成（年金２）
 */
public class WSuiihyouNenkin2 {

    private final static String ERROR_MSG = "解約返戻金計算が実行できませんでした。";

    private final static String ERROR_MSG_2 = "前納精算額計算が実行できませんでした。";

    private final static String ERROR_MSG_3 = "契約時の予定利率が取得できませんでした。";

    private final static String SUIIHYOUSYUBETU_SIN_ZENNNOU_ARI = "06";

    private final static String SUIIHYOUSYUBETU_SIN_ZENNNOU_NASHI = "07";

    private final static String SUIIHYOUSYUBETU_SAI_ZENNNOU_ARI = "08";

    private final static String SUIIHYOUSYUBETU_SAI_ZENNNOU_NASHI = "09";

    private C_YouhiKbn yenkansannYhKbn = C_YouhiKbn.YOU;

    private C_YouhiKbn hasuusyoriYhKbn = C_YouhiKbn.YOU;

    @Inject
    private static Logger logger;

    public WSuiihyouNenkin2() {
        super();
    }

    public void setYenkansannYhKbn(C_YouhiKbn pYenkansannYhKbn) {
        yenkansannYhKbn = pYenkansannYhKbn;
    }

    public void setHasuusyoriYhKbn(C_YouhiKbn pHasuusyoriYhKbn) {
        hasuusyoriYhKbn = pHasuusyoriYhKbn;
    }

    public List<IT_Suiihyou> exec(WSuiihyouParam pWSuiihyouParam) {

        logger.debug("▽ 解約返戻金推移表作成（年金２） 開始");

        SetOutoubi setOutoubi = SWAKInjector.getInstance(SetOutoubi.class);

        BizDate calcKijyunYmd = null;

        calcKijyunYmd = setOutoubi.exec(C_TykzentykgoKbn.TYKGO,
            pWSuiihyouParam.getKeisanWExtBean().getKykymd(),
            C_Hrkkaisuu.NEN,
            pWSuiihyouParam.getCalcKijyunYmd());

        C_SinsaihkKbn csinsaihkKbn = C_SinsaihkKbn.BLNK;

        if (C_SinsaihkKbn.SIN.eq(pWSuiihyouParam.getSinsaihkKbn()) ||
            (C_SinsaihkKbn.SAI.eq(pWSuiihyouParam.getSinsaihkKbn()) &&
                C_SyoukensaihkKbn.SINKEIYAKUSAISAKUSEI.eq(pWSuiihyouParam.getSyoukensaihkKbn()))) {
            csinsaihkKbn = C_SinsaihkKbn.SIN;
        }
        else {
            csinsaihkKbn = C_SinsaihkKbn.SAI;
        }

        SetManryoubi setManryoubi = SWAKInjector.getInstance(SetManryoubi.class);

        BizDate hrkkknmnryymd = null;

        BizDate hknkknmanryouymd = null;

        int hrkkkn = 0;

        hrkkknmnryymd = setManryoubi.exec(
            pWSuiihyouParam.getKeisanWExtBean().getKykymd(),
            pWSuiihyouParam.getKeisanWExtBean().getHhknnen(),
            pWSuiihyouParam.getKeisanWExtBean().getHrkkkn(),
            C_KknsmnKbn.valueOf(pWSuiihyouParam.getKeisanWExtBean().getHrkkknsmnkbn().getValue()));

        hknkknmanryouymd = setManryoubi.exec(
            pWSuiihyouParam.getKeisanWExtBean().getKykymd(),
            pWSuiihyouParam.getKeisanWExtBean().getHhknnen(),
            pWSuiihyouParam.getKeisanWExtBean().getHknkkn(),
            C_KknsmnKbn.valueOf(pWSuiihyouParam.getKeisanWExtBean().getHknkknsmnkbn().getValue()));

        hrkkkn = pWSuiihyouParam.getKeisanWExtBean().getHrkkkn() - pWSuiihyouParam.getKeisanWExtBean().getHhknnen();

        GetKawaseRate getKawaseRate = SWAKInjector.getInstance(GetKawaseRate.class);

        BizNumber kawaserateCenter = BizNumber.ZERO;

        BizNumber kawaserateEndaka = BizNumber.ZERO;

        BizNumber kawaserateEnyasi = BizNumber.ZERO;

        BizNumber gaikaknsnkwsrate = BizNumber.ZERO;

        if (C_YouhiKbn.YOU.eq(yenkansannYhKbn)) {
            getKawaseRate.execFstPNyuukin(
                pWSuiihyouParam.getKwsratekjymd(),
                pWSuiihyouParam.getKeisanWExtBean().getTuukasyu(),
                C_Tuukasyu.JPY,
                C_YouhiKbn.HUYOU,
                pWSuiihyouParam.getKeisanWExtBean().getHrkkaisuu(),
                C_SysKbn.SKEI,
                C_UmuKbn.NONE,
                C_IkkatubaraiKbn.BLNK);

            gaikaknsnkwsrate = getKawaseRate.getKawaserate();

            getKawaseRate.exec(
                getKawaseRate.getKwsrateKjYmd(),
                C_KawaserateSyuruiKbn.KOUJIKAWASERATE,
                pWSuiihyouParam.getKeisanWExtBean().getTuukasyu(),
                C_Tuukasyu.JPY,
                C_KawasetekiyoKbn.TTM,
                C_KawasetsryKbn.SYUKKINRATE,
                C_EigyoubiHoseiKbn.ZENEIGYOUBI,
                C_YouhiKbn.HUYOU );

            kawaserateCenter = getKawaseRate.getKawaserate();

            kawaserateEndaka = kawaserateCenter.subtract(YuyuHozenConfig.getInstance().getKawaserateHendouYenup());

            kawaserateEnyasi = kawaserateCenter.add(YuyuHozenConfig.getInstance().getKawaserateHendouYendown());
        }

        if (pWSuiihyouParam.getKeisanWExtBean().getSisankawaserate() != BizNumber.ZERO){
            gaikaknsnkwsrate = pWSuiihyouParam.getKeisanWExtBean().getSisankawaserate();
        }

        BizNumber kykYoteiriritu = BizNumber.ZERO;

        GetYoteiriritu getYoteiriritu = SWAKInjector.getInstance(GetYoteiriritu.class);
        GetYoteirirituBean getYoteirirituBean = SWAKInjector.getInstance(GetYoteirirituBean.class);
        BizNumber sitihsyuriritu = pWSuiihyouParam.getKeisanWExtBean().getYoteirrthendohosyurrt();

        getYoteirirituBean.setSyouhncd(pWSuiihyouParam.getKeisanWExtBean().getSyouhncd());
        getYoteirirituBean.setKijyunymd(pWSuiihyouParam.getKeisanWExtBean().getKykymd());
        getYoteirirituBean.setSknnkaisiymd(pWSuiihyouParam.getKeisanWExtBean().getKykymd());
        getYoteirirituBean.setKykymd(pWSuiihyouParam.getKeisanWExtBean().getKykymd());
        getYoteirirituBean.setHknkkn(pWSuiihyouParam.getKeisanWExtBean().getHknkkn());
        getYoteirirituBean.setHknkknsmnkbn(pWSuiihyouParam.getKeisanWExtBean().getHknkknsmnkbn());
        getYoteirirituBean.setHhknnen(pWSuiihyouParam.getKeisanWExtBean().getHhknnen());
        getYoteirirituBean.setSitihsyuriritu(sitihsyuriritu);

        C_ErrorKbn errorKbn = getYoteiriritu.exec(getYoteirirituBean);

        if (C_ErrorKbn.ERROR.eq(errorKbn)) {
            throw new CommonBizAppException(ERROR_MSG_3);
        }
        kykYoteiriritu =getYoteiriritu.getYoteiriritu();

        int yoteirirituLstCnt = 0;

        if (pWSuiihyouParam.getYoteiRirituList().size() > 3 ){
            yoteirirituLstCnt = 3;
        }else{
            yoteirirituLstCnt = pWSuiihyouParam.getYoteiRirituList().size();
        }

        List<BizDate> calcKijyunYmdList = new ArrayList<>();

        List<BizDateYM> calcKijyunYMList = new ArrayList<>();

        List<Integer> keikanensuuList = new ArrayList<>();

        BizDate calcKijyunYmdForMkList = calcKijyunYmd;

        int keikanensuu = BizDateUtil.calcDifference(calcKijyunYmd, pWSuiihyouParam.getKeisanWExtBean().getKykymd()).getYears();

        while (BizDateUtil.compareYmd(calcKijyunYmdForMkList, hknkknmanryouymd) == BizDateUtil.COMPARE_EQUAL ||
            BizDateUtil.compareYmd(calcKijyunYmdForMkList, hknkknmanryouymd) == BizDateUtil.COMPARE_LESSER){

            BizDate calcKijyunYmdForMkListMae = calcKijyunYmdForMkList.getPreviousDay();

            if (BizDateUtil.compareYmd(calcKijyunYmdForMkListMae, hrkkknmnryymd) == BizDateUtil.COMPARE_LESSER){
                calcKijyunYmdList.add(calcKijyunYmdForMkListMae);
                calcKijyunYMList.add(calcKijyunYmdForMkList.getBizDateYM());
                keikanensuuList.add(keikanensuu-1);
            }
            if (BizDateUtil.compareYmd(calcKijyunYmdForMkList, hrkkknmnryymd) == BizDateUtil.COMPARE_EQUAL){
                calcKijyunYmdList.add(calcKijyunYmdForMkList);
                calcKijyunYMList.add(calcKijyunYmdForMkList.getBizDateYM());
                keikanensuuList.add(keikanensuu);
            }

            if (BizDateUtil.compareYmd(hrkkknmnryymd, calcKijyunYmdForMkList) == BizDateUtil.COMPARE_LESSER  &&
                BizDateUtil.compareYmd(calcKijyunYmdForMkListMae, hknkknmanryouymd) == BizDateUtil.COMPARE_LESSER){
                calcKijyunYmdList.add(calcKijyunYmdForMkListMae);
                calcKijyunYMList.add(calcKijyunYmdForMkList.getBizDateYM());
                keikanensuuList.add(keikanensuu);
            }

            calcKijyunYmdForMkList = calcKijyunYmdForMkList.getNextYear().getRekijyou();
            keikanensuu = keikanensuu + 1;
        }


        KeisanZennouSeisanGk2 keisanZennouSeisanGk = SWAKInjector.getInstance(KeisanZennouSeisanGk2.class);

        List<BizCurrency> zennouzndkList = new ArrayList<>();

        String suiihyousyubetu = "";

        if (C_UmuKbn.ARI.eq(pWSuiihyouParam.getZennouUmuKbn())){

            errorKbn = keisanZennouSeisanGk.exec(
                hrkkknmnryymd,
                pWSuiihyouParam.getKeisanWExtBean().getKykymd(),
                pWSuiihyouParam.getZennoujiHrkP(),
                pWSuiihyouParam.getZennouKaisiYmd(),
                pWSuiihyouParam.getRyosyuYmd(),
                pWSuiihyouParam.getZennouNyuukingk());

            if (C_ErrorKbn.ERROR.eq(errorKbn)) {
                throw new CommonBizAppException(ERROR_MSG_2);
            }

            List<KykOutoubiZennouZndkBean> kykOutoubiZennouZndkList = keisanZennouSeisanGk.getKykOutoubiZennouZndkList();

            for (BizDate calcKijyunYmdForMkZnnzndk : calcKijyunYmdList) {

                BizCurrency zennouzndk = BizCurrency.valueOf(0);

                if (BizDateUtil.compareYmd(calcKijyunYmdForMkZnnzndk, hrkkknmnryymd) == BizDateUtil.COMPARE_LESSER){
                    for (KykOutoubiZennouZndkBean kykOutoubiZennouZndk : kykOutoubiZennouZndkList) {
                        if(calcKijyunYmdForMkZnnzndk.equals(kykOutoubiZennouZndk.getKykOutoubi().getPreviousDay())){
                            zennouzndk = kykOutoubiZennouZndk.getZnnurrttkyjytmaeZnnuzndk();
                            break;
                        }
                    }
                }

                if (C_YouhiKbn.YOU.eq(hasuusyoriYhKbn)) {
                    zennouzndkList.add(zennouzndk.round(-4, RoundingMode.FLOOR));
                }else{
                    zennouzndkList.add(zennouzndk);
                }
            }

            if (csinsaihkKbn.eq(C_SinsaihkKbn.SIN)){
                suiihyousyubetu = SUIIHYOUSYUBETU_SIN_ZENNNOU_ARI;
            }else{
                suiihyousyubetu = SUIIHYOUSYUBETU_SAI_ZENNNOU_ARI;
            }
        }else{
            if (csinsaihkKbn.eq(C_SinsaihkKbn.SIN)){
                suiihyousyubetu = SUIIHYOUSYUBETU_SIN_ZENNNOU_NASHI;
            }else{
                suiihyousyubetu = SUIIHYOUSYUBETU_SAI_ZENNNOU_NASHI;
            }
        }


        List<BizCurrency> yenhrkgkgkList = new ArrayList<>();

        for (int index = 0; index < calcKijyunYmdList.size(); index++) {
            BizDate calcKijyunYmdForYenhrkgk = calcKijyunYmdList.get(index);
            int keikanenssuuForYenhrkgk = keikanensuuList.get(index);
            BizCurrency yenhrkgkgk = BizCurrency.valueOf(0);

            if (BizDateUtil.compareYmd(calcKijyunYmdForYenhrkgk, hrkkknmnryymd) == BizDateUtil.COMPARE_LESSER ){
                yenhrkgkgk = pWSuiihyouParam.getHeijyunP().multiply(12).multiply(keikanenssuuForYenhrkgk+1);
                if (C_YouhiKbn.YOU.eq(hasuusyoriYhKbn)) {
                    yenhrkgkgkList.add(yenhrkgkgk.round(-4, RoundingMode.FLOOR));
                }else{
                    yenhrkgkgkList.add(yenhrkgkgk);
                }
            }else{
                yenhrkgkgk = pWSuiihyouParam.getHeijyunP().multiply(12).multiply(hrkkkn);
                if (C_YouhiKbn.YOU.eq(hasuusyoriYhKbn)) {
                    yenhrkgkgkList.add(yenhrkgkgk.round(-4, RoundingMode.FLOOR));
                }else{
                    yenhrkgkgkList.add(yenhrkgkgk);
                }
            }
        }


        KeisanWExtBean keisanWExtBean = SWAKInjector.getInstance(KeisanWExtBean.class);
        KeisanW keisanW = SWAKInjector.getInstance(KeisanW.class);

        List<EditWSuiihyouBean> editWSuiihyouBeanList1 = new ArrayList<>();
        List<EditWSuiihyouBean> editWSuiihyouBeanList2 = new ArrayList<>();
        List<EditWSuiihyouBean> editWSuiihyouBeanList3 = new ArrayList<>();

        for (int ytiRrtIdx = 0; ytiRrtIdx < pWSuiihyouParam.getYoteiRirituList().size(); ytiRrtIdx++) {

            BizNumber yoteiriritu = pWSuiihyouParam.getYoteiRirituList().get(ytiRrtIdx);
            BizDateYM tmttkntaisyouym = null;
            BizCurrency calcKaisiV = BizCurrency.valueOf(0);
            BizCurrency calcKaisiP = BizCurrency.valueOf(0);
            for (int clcKjnYmdIdx = 0; clcKjnYmdIdx < calcKijyunYmdList.size(); clcKjnYmdIdx++) {
                BizDate calcKijyunYmdForMkW = calcKijyunYmdList.get(clcKjnYmdIdx);
                BizDateYM calcKijyunYMForMkW = calcKijyunYMList.get(clcKjnYmdIdx);

                EditWSuiihyouBean editWSuiihyouBean = SWAKInjector.getInstance(EditWSuiihyouBean.class);

                keisanWExtBean.setSyouhncd(pWSuiihyouParam.getKeisanWExtBean().getSyouhncd());
                keisanWExtBean.setSyouhnsdno(pWSuiihyouParam.getKeisanWExtBean().getSyouhnsdno());
                keisanWExtBean.setRyouritusdno(pWSuiihyouParam.getKeisanWExtBean().getRyouritusdno());
                keisanWExtBean.setKykymd(pWSuiihyouParam.getKeisanWExtBean().getKykymd());
                keisanWExtBean.setHokenryou(pWSuiihyouParam.getKeisanWExtBean().getHokenryou());
                keisanWExtBean.setTuukasyu(pWSuiihyouParam.getKeisanWExtBean().getTuukasyu());
                keisanWExtBean.setHhknsei(pWSuiihyouParam.getKeisanWExtBean().getHhknsei());
                keisanWExtBean.setHhknnen(pWSuiihyouParam.getKeisanWExtBean().getHhknnen());
                keisanWExtBean.setHknkkn(pWSuiihyouParam.getKeisanWExtBean().getHknkkn());
                keisanWExtBean.setHknkknsmnkbn(pWSuiihyouParam.getKeisanWExtBean().getHknkknsmnkbn());
                keisanWExtBean.setHrkkkn(pWSuiihyouParam.getKeisanWExtBean().getHrkkkn());
                keisanWExtBean.setHrkkknsmnkbn(pWSuiihyouParam.getKeisanWExtBean().getHrkkknsmnkbn());
                keisanWExtBean.setHrkkaisuu(pWSuiihyouParam.getKeisanWExtBean().getHrkkaisuu());
                keisanWExtBean.setFstpryosyuymd(pWSuiihyouParam.getKeisanWExtBean().getFstpryosyuymd());
                keisanWExtBean.setYoteirrthendohosyurrt(pWSuiihyouParam.getKeisanWExtBean().getYoteirrthendohosyurrt());
                keisanWExtBean.setSisansyuruikbn(C_KhSisanSyuruiKbn.SISAN);
                keisanWExtBean.setSisankawaserate(gaikaknsnkwsrate);

                if (clcKjnYmdIdx == 0){

                    tmttkntaisyouym = null;
                    calcKaisiV = BizCurrency.valueOf(0);
                    calcKaisiP = BizCurrency.valueOf(0);

                    BizDate kykYmdAfter1month = pWSuiihyouParam.getKeisanWExtBean().getKykymd().addMonths(1).getRekijyou();
                    BizDate kykYmdAfter1monthMae = kykYmdAfter1month.getPreviousDay();
                    BizDateYM kykYMAfter1month = kykYmdAfter1month.getBizDateYM();

                    keisanWExtBean.setTmttkntaisyouym(tmttkntaisyouym);
                    keisanWExtBean.setPtmttkngk(calcKaisiV);
                    keisanWExtBean.setKihrkmpstgk(calcKaisiP);
                    keisanWExtBean.setSisansyoriymd(kykYmdAfter1monthMae);
                    keisanWExtBean.setSisanyoteiriritu(kykYoteiriritu);

                    errorKbn = keisanW.exec(
                        kykYmdAfter1monthMae,
                        kykYMAfter1month,
                        keisanWExtBean);

                    if (C_ErrorKbn.ERROR.eq(errorKbn)) {
                        throw new CommonBizAppException(ERROR_MSG);
                    }
                    tmttkntaisyouym = keisanW.getPtumitatekinKeisanYM();
                    calcKaisiV = keisanW.getV();
                    calcKaisiP = keisanW.getPruikei();
                }

                keisanWExtBean.setTmttkntaisyouym(tmttkntaisyouym);
                keisanWExtBean.setPtmttkngk(calcKaisiV);
                keisanWExtBean.setKihrkmpstgk(calcKaisiP);
                keisanWExtBean.setSisansyoriymd(calcKijyunYmdForMkW);
                keisanWExtBean.setSisanyoteiriritu(yoteiriritu);

                errorKbn = keisanW.exec(
                    calcKijyunYmdForMkW,
                    calcKijyunYMForMkW,
                    keisanWExtBean);

                if (C_ErrorKbn.ERROR.eq(errorKbn)) {
                    throw new CommonBizAppException(ERROR_MSG);
                }
                tmttkntaisyouym = keisanW.getPtumitatekinKeisanYM();
                calcKaisiV = keisanW.getV();
                calcKaisiP = keisanW.getPruikei();

                editWSuiihyouBean.setKihrkmPStgk(calcKaisiP.round(2, RoundingMode.HALF_UP));
                editWSuiihyouBean.setKaiyakuHrKngak(keisanW.getW().round(2, RoundingMode.HALF_UP));
                editWSuiihyouBean.setTmttKngk(calcKaisiV);
                if (ytiRrtIdx==0){
                    editWSuiihyouBeanList1.add(editWSuiihyouBean);
                }else if(ytiRrtIdx==1){
                    editWSuiihyouBeanList2.add(editWSuiihyouBean);
                }else if(ytiRrtIdx==2){
                    editWSuiihyouBeanList3.add(editWSuiihyouBean);
                }
            }
        }

        List<IT_Suiihyou> suiihyouList = new ArrayList<>();
        C_UmuKbn hrkkknmnryumukbn = C_UmuKbn.NONE;

        for (int clcKjnYmdIdxTbl = 0; clcKjnYmdIdxTbl < calcKijyunYmdList.size(); clcKjnYmdIdxTbl++) {
            BizDate calcKijyunYmdForITSuiihyou = calcKijyunYmdList.get(clcKjnYmdIdxTbl);

            if (BizDateUtil.compareYmd(calcKijyunYmdForITSuiihyou, hrkkknmnryymd) == BizDateUtil.COMPARE_EQUAL){
                hrkkknmnryumukbn = C_UmuKbn.ARI;
            } else {
                hrkkknmnryumukbn = C_UmuKbn.NONE;
            }

            BizCurrency wyen1yenkijyun = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);
            BizCurrency wyen1yendaka = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);
            BizCurrency wyen1yenyasu = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);
            List<BizCurrency> mvaariwyenlst = getKaiyakuhrknYenKnsn(
                editWSuiihyouBeanList1.get(clcKjnYmdIdxTbl).getKaiyakuHrKngak(),
                kawaserateCenter,
                kawaserateEndaka,
                kawaserateEnyasi);

            wyen1yenkijyun = mvaariwyenlst.get(0);
            wyen1yendaka = mvaariwyenlst.get(1);
            wyen1yenyasu = mvaariwyenlst.get(2);

            IT_Suiihyou suiihyou = new IT_Suiihyou();

            suiihyou.setKeikanensuu(keikanensuuList.get(clcKjnYmdIdxTbl));
            suiihyou.setCalckijyunymd(calcKijyunYmdForITSuiihyou);
            suiihyou.setCalcym(calcKijyunYMList.get(clcKjnYmdIdxTbl));
            suiihyou.setSuiihyousyubetu(suiihyousyubetu);
            suiihyou.setHrkkknmnryumukbn(hrkkknmnryumukbn);
            suiihyou.setYtirrtcalckijyunrrt1(pWSuiihyouParam.getYoteiRirituList().get(0));
            suiihyou.setYenknsnkwsrateyendaka(kawaserateEndaka);
            suiihyou.setYenknsnkwsrateyenkijyun(kawaserateCenter);
            suiihyou.setYenknsnkwsrateyenyasu(kawaserateEnyasi);
            suiihyou.setYenknsnkwsrategkyendaka(
                BizCurrency.valueOf(
                    new BigDecimal(YuyuHozenConfig.getInstance().getKawaserateHendouYenup().toString()),
                    BizCurrencyTypes.YEN));
            suiihyou.setYenknsnkwsrategkyenyasu(
                BizCurrency.valueOf(
                    new BigDecimal(YuyuHozenConfig.getInstance().getKawaserateHendouYendown().toString()),
                    BizCurrencyTypes.YEN));
            suiihyou.setKihrkmpyen1(yenhrkgkgkList.get(clcKjnYmdIdxTbl));
            suiihyou.setKihrkmp1(editWSuiihyouBeanList1.get(clcKjnYmdIdxTbl).getKihrkmPStgk());
            suiihyou.setMvanonewsame(editWSuiihyouBeanList1.get(clcKjnYmdIdxTbl).getKaiyakuHrKngak());
            suiihyou.setMvanonewyensameyendaka(wyen1yendaka);
            suiihyou.setMvanonewyensameyenkijyun(wyen1yenkijyun);
            suiihyou.setMvanonewyensameyenyasu(wyen1yenyasu);
            suiihyou.setMvanoneptumitatekin(editWSuiihyouBeanList1.get(clcKjnYmdIdxTbl).getTmttKngk());

            if (pWSuiihyouParam.getZennouUmuKbn().eq(C_UmuKbn.ARI)){
                suiihyou.setZennouzndkyen1(zennouzndkList.get(clcKjnYmdIdxTbl));
            }

            if (yoteirirituLstCnt > 1) {
                BizCurrency wyen2yenkijyun = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);
                BizCurrency wyen2yendaka = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);
                BizCurrency wyen2yenyasu = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);

                mvaariwyenlst = getKaiyakuhrknYenKnsn(
                    editWSuiihyouBeanList2.get(clcKjnYmdIdxTbl).getKaiyakuHrKngak(),
                    kawaserateCenter,
                    kawaserateEndaka,
                    kawaserateEnyasi);

                wyen2yenkijyun = mvaariwyenlst.get(0);
                wyen2yendaka = mvaariwyenlst.get(1);
                wyen2yenyasu = mvaariwyenlst.get(2);

                suiihyou.setYtirrtcalckijyunrrt2(pWSuiihyouParam.getYoteiRirituList().get(1));
                suiihyou.setYenknsnkwsrateyendaka2(kawaserateEndaka);
                suiihyou.setYenknsnkwsrateyenkijyun2(kawaserateCenter);
                suiihyou.setYenknsnkwsrateyenyasu2(kawaserateEnyasi);
                suiihyou.setYenknsnkwsrategkyendaka2(
                    BizCurrency.valueOf(
                        new BigDecimal(YuyuHozenConfig.getInstance().getKawaserateHendouYenup().toString()),
                        BizCurrencyTypes.YEN));
                suiihyou.setYenknsnkwsrategkyenyasu2(
                    BizCurrency.valueOf(
                        new BigDecimal(YuyuHozenConfig.getInstance().getKawaserateHendouYendown().toString()),
                        BizCurrencyTypes.YEN));
                suiihyou.setKihrkmpyen2(yenhrkgkgkList.get(clcKjnYmdIdxTbl));
                suiihyou.setKihrkmp2(editWSuiihyouBeanList2.get(clcKjnYmdIdxTbl).getKihrkmPStgk());
                suiihyou.setMvanonewsame2(editWSuiihyouBeanList2.get(clcKjnYmdIdxTbl).getKaiyakuHrKngak());
                suiihyou.setMvanonewyensameyendaka2(wyen2yendaka);
                suiihyou.setMvanonewyensameyenkijyun2(wyen2yenkijyun);
                suiihyou.setMvanonewyensameyenyasu2(wyen2yenyasu);
                suiihyou.setMvanoneptumitatekin2(editWSuiihyouBeanList2.get(clcKjnYmdIdxTbl).getTmttKngk());

                if (pWSuiihyouParam.getZennouUmuKbn().eq(C_UmuKbn.ARI)){
                    suiihyou.setZennouzndkyen2(zennouzndkList.get(clcKjnYmdIdxTbl));
                }
            }

            if (yoteirirituLstCnt > 2) {
                BizCurrency wyen3yenkijyun = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);
                BizCurrency wyen3yendaka = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);
                BizCurrency wyen3yenyasu = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);

                mvaariwyenlst = getKaiyakuhrknYenKnsn(
                    editWSuiihyouBeanList3.get(clcKjnYmdIdxTbl).getKaiyakuHrKngak(),
                    kawaserateCenter,
                    kawaserateEndaka,
                    kawaserateEnyasi);

                wyen3yenkijyun = mvaariwyenlst.get(0);
                wyen3yendaka = mvaariwyenlst.get(1);
                wyen3yenyasu = mvaariwyenlst.get(2);

                suiihyou.setYtirrtcalckijyunrrt3(pWSuiihyouParam.getYoteiRirituList().get(2));
                suiihyou.setYenknsnkwsrateyendaka3(kawaserateEndaka);
                suiihyou.setYenknsnkwsrateyenkijyun3(kawaserateCenter);
                suiihyou.setYenknsnkwsrateyenyasu3(kawaserateEnyasi);
                suiihyou.setYenknsnkwsrategkyendaka3(
                    BizCurrency.valueOf(
                        new BigDecimal(YuyuHozenConfig.getInstance().getKawaserateHendouYenup().toString()),
                        BizCurrencyTypes.YEN));
                suiihyou.setYenknsnkwsrategkyenyasu3(
                    BizCurrency.valueOf(
                        new BigDecimal(YuyuHozenConfig.getInstance().getKawaserateHendouYendown().toString()),
                        BizCurrencyTypes.YEN));
                suiihyou.setKihrkmpyen3(yenhrkgkgkList.get(clcKjnYmdIdxTbl));
                suiihyou.setKihrkmp3(editWSuiihyouBeanList3.get(clcKjnYmdIdxTbl).getKihrkmPStgk());
                suiihyou.setMvanonewsame3(editWSuiihyouBeanList3.get(clcKjnYmdIdxTbl).getKaiyakuHrKngak());
                suiihyou.setMvanonewyensameyendaka3(wyen3yendaka);
                suiihyou.setMvanonewyensameyenkijyun3(wyen3yenkijyun);
                suiihyou.setMvanonewyensameyenyasu3(wyen3yenyasu);
                suiihyou.setMvanoneptumitatekin3(editWSuiihyouBeanList3.get(clcKjnYmdIdxTbl).getTmttKngk());

                if (pWSuiihyouParam.getZennouUmuKbn().eq(C_UmuKbn.ARI)){
                    suiihyou.setZennouzndkyen3(zennouzndkList.get(clcKjnYmdIdxTbl));
                }
            }

            BizPropertyInitializer.initialize(suiihyou);

            suiihyouList.add(suiihyou);

        }

        logger.debug("△ 解約返戻金推移表作成（年金２） 終了");

        return suiihyouList;
    }


    private List<BizCurrency> getKaiyakuhrknYenKnsn(
        BizCurrency pKaiyakuhrkngk,
        BizNumber pKawaserateCenter,
        BizNumber pKawaserateEndaka,
        BizNumber pKawaserateEnyasi) {

        KeisanGaikakanzan keisanGaikakanzan = SWAKInjector.getInstance(KeisanGaikakanzan.class);

        BizCurrency kaiyakuhrkngk = pKaiyakuhrkngk;

        BizCurrency wyenyenkijyun = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);

        BizCurrency wyenyendaka = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);

        BizCurrency wyenyenyasu = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);

        List<BizCurrency> wyenlst = null;

        keisanGaikakanzan.exec(
            C_Tuukasyu.JPY,
            kaiyakuhrkngk,
            pKawaserateCenter,
            C_HasuusyoriKbn.AGE);

        wyenyenkijyun = keisanGaikakanzan.getKanzanGaku();

        keisanGaikakanzan.exec(
            C_Tuukasyu.JPY,
            kaiyakuhrkngk,
            pKawaserateEndaka,
            C_HasuusyoriKbn.AGE);

        wyenyendaka = keisanGaikakanzan.getKanzanGaku();

        keisanGaikakanzan.exec(
            C_Tuukasyu.JPY,
            kaiyakuhrkngk,
            pKawaserateEnyasi,
            C_HasuusyoriKbn.AGE);

        wyenyenyasu = keisanGaikakanzan.getKanzanGaku();

        wyenlst = new ArrayList<BizCurrency>();

        if (C_YouhiKbn.YOU.eq(hasuusyoriYhKbn)) {
            wyenlst.add(wyenyenkijyun.round(-4, RoundingMode.FLOOR));
            wyenlst.add(wyenyendaka.round(-4, RoundingMode.FLOOR));
            wyenlst.add(wyenyenyasu.round(-4, RoundingMode.FLOOR));
        }else{
            wyenlst.add(wyenyenkijyun);
            wyenlst.add(wyenyendaka);
            wyenlst.add(wyenyenyasu);
        }

        return wyenlst;

    }
}
