package yuyu.common.hozen.khcommon;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.RoundingMode;
import java.util.Collections;
import java.util.List;

import javax.inject.Inject;

import com.google.common.collect.Lists;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.common.biz.bzcommon.BizUtil;
import yuyu.common.biz.bzcommon.GetKawaseRate;
import yuyu.common.biz.exception.CommonBizAppException;
import yuyu.def.classification.C_EigyoubiHoseiKbn;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_KawaserateSyuruiKbn;
import yuyu.def.classification.C_KawasetekiyoKbn;
import yuyu.def.classification.C_KawasetsryKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_YouhiKbn;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.ZT_GaikaKokyakuTuutiTy;
import yuyu.def.hozen.manager.HozenDomManager;

/**
 * 契約保全 契約保全共通 契約内容のお知らせ編集
 */
public class EditKykNaiyouOsirase {

    public static final String SYOUHNHANMEIKBN_SYUUSIN_GAIKA = "01";

    public static final String SYOUHNHANMEIKBN_SYUUSIN_ENKA = "02";

    public static final String SYOUHNHANMEIKBN_NENKIN_SISUU3MONTHMAE = "03";

    public static final String SYOUHNHANMEIKBN_NENKIN_SISUU  = "04";

    public static final String SYOUHNHANMEIKBN_NENKIN_TEIRITUITEN  = "05";

    public static final String SYOUHNHANMEIKBN_NENKIN_TEIRITU  = "06";

    public static final String SYOUHNHANMEIKBN_DUO  = "07";

    public static final String SYOUHNHANMEIKBN_NENKIN_ENKA  = "08";

    public static final String SYOUHNHANMEIKBN_SYUUSIN_GAIKA_KAITEI  = "09";

    public static final String SYOUHNHANMEIKBN_SYUUSIN_ENKA_19  = "10";

    private static final String OSIRASEMSGCD_08011 = "08011";

    private static final String AISATUMSGCD_03003 = "03003";

    private static final String CAMPAIGNFLG_ARI = "1";

    public static final int YOBIDASIMOTOKBN_BATCH = 0;

    public static final int YOBIDASIMOTOKBN_ONLINE = 1;

    public static final int YOBIDASIMOTOKBN_SEIHOWEB = 2;

    private C_ErrorKbn commonErrorKbn = C_ErrorKbn.OK;

    private C_ErrorKbn bizLogicErrorKbn = C_ErrorKbn.OK;

    private String bizLogicErrorMsg = "";

    @Inject
    private HozenDomManager hozenDomManager;

    public EditKykNaiyouOsirase() {
        super();
    }

    public C_ErrorKbn getCommonErrorKbn() {
        return commonErrorKbn;
    }

    public C_ErrorKbn getBizLogicErrorKbn() {
        return bizLogicErrorKbn;
    }

    public String getBizLogicErrorMsg() {
        return bizLogicErrorMsg;
    }

    public KawaseRateBean getKawaseRateBean(BizDate pSyoriYmd) {

        KawaseRateBean kawaseRateBean = new KawaseRateBean();

        GetKawaseRate getKawaseRate = SWAKInjector.getInstance(GetKawaseRate.class);

        BizDate syoriPreMonYmd = BizDate.valueOf(pSyoriYmd.getPreviousMonth().getBizDateYM(), 1);
        getKawaseRate.exec(
            syoriPreMonYmd,
            C_KawaserateSyuruiKbn.KOUJIKAWASERATE,
            C_Tuukasyu.USD,
            C_Tuukasyu.JPY,
            C_KawasetekiyoKbn.TTM,
            C_KawasetsryKbn.JISSEIRATE,
            C_EigyoubiHoseiKbn.YOKUEIGYOUBI,
            C_YouhiKbn.HUYOU);

        kawaseRateBean.setKwsrateUsdjpy1mae(getKawaseRate.getKawaserate().round(2, RoundingMode.DOWN));
        kawaseRateBean.setKwsrateKijyunymd1mae(getKawaseRate.getKwsrateKjYmd());

        getKawaseRate.exec(
            syoriPreMonYmd,
            C_KawaserateSyuruiKbn.KOUJIKAWASERATE,
            C_Tuukasyu.AUD,
            C_Tuukasyu.JPY,
            C_KawasetekiyoKbn.TTM,
            C_KawasetsryKbn.JISSEIRATE,
            C_EigyoubiHoseiKbn.YOKUEIGYOUBI,
            C_YouhiKbn.HUYOU);

        kawaseRateBean.setKwsrateAudjpy1mae(getKawaseRate.getKawaserate().round(2, RoundingMode.DOWN));

        BizDate syoriYmd2mae = BizDate.valueOf(pSyoriYmd.addMonths(-2).getBizDateYM(), 1);
        getKawaseRate.exec(
            syoriYmd2mae,
            C_KawaserateSyuruiKbn.KOUJIKAWASERATE,
            C_Tuukasyu.USD,
            C_Tuukasyu.JPY,
            C_KawasetekiyoKbn.TTM,
            C_KawasetsryKbn.JISSEIRATE,
            C_EigyoubiHoseiKbn.YOKUEIGYOUBI,
            C_YouhiKbn.HUYOU);

        kawaseRateBean.setKwsrateUsdjpy2mae(getKawaseRate.getKawaserate().round(2, RoundingMode.DOWN));

        kawaseRateBean.setKwsrateKijyunymd2mae(getKawaseRate.getKwsrateKjYmd());

        getKawaseRate.exec(
            syoriYmd2mae,
            C_KawaserateSyuruiKbn.KOUJIKAWASERATE,
            C_Tuukasyu.AUD,
            C_Tuukasyu.JPY,
            C_KawasetekiyoKbn.TTM,
            C_KawasetsryKbn.JISSEIRATE,
            C_EigyoubiHoseiKbn.YOKUEIGYOUBI,
            C_YouhiKbn.HUYOU);

        kawaseRateBean.setKwsrateAudjpy2mae(getKawaseRate.getKawaserate().round(2, RoundingMode.DOWN));

        BizDate syoriYmd3mae = BizDate.valueOf(pSyoriYmd.addMonths(-3).getBizDateYM(), 1);
        getKawaseRate.exec(
            syoriYmd3mae,
            C_KawaserateSyuruiKbn.KOUJIKAWASERATE,
            C_Tuukasyu.USD,
            C_Tuukasyu.JPY,
            C_KawasetekiyoKbn.TTM,
            C_KawasetsryKbn.JISSEIRATE,
            C_EigyoubiHoseiKbn.YOKUEIGYOUBI,
            C_YouhiKbn.HUYOU);

        kawaseRateBean.setKwsrateUsdjpy3mae(getKawaseRate.getKawaserate().round(2, RoundingMode.DOWN));
        kawaseRateBean.setKwsrateKijyunymd3mae(getKawaseRate.getKwsrateKjYmd());

        getKawaseRate.exec(
            syoriYmd3mae,
            C_KawaserateSyuruiKbn.KOUJIKAWASERATE,
            C_Tuukasyu.AUD,
            C_Tuukasyu.JPY,
            C_KawasetekiyoKbn.TTM,
            C_KawasetsryKbn.JISSEIRATE,
            C_EigyoubiHoseiKbn.YOKUEIGYOUBI,
            C_YouhiKbn.HUYOU);

        kawaseRateBean.setKwsrateAudjpy3mae(getKawaseRate.getKawaserate().round(2, RoundingMode.DOWN));

        BizDate syoriYmd4mae = BizDate.valueOf(pSyoriYmd.addMonths(-4).getBizDateYM(), 1);
        getKawaseRate.exec(
            syoriYmd4mae,
            C_KawaserateSyuruiKbn.KOUJIKAWASERATE,
            C_Tuukasyu.USD,
            C_Tuukasyu.JPY,
            C_KawasetekiyoKbn.TTM,
            C_KawasetsryKbn.JISSEIRATE,
            C_EigyoubiHoseiKbn.YOKUEIGYOUBI,
            C_YouhiKbn.HUYOU);

        kawaseRateBean.setKwsrateUsdjpy4mae(getKawaseRate.getKawaserate().round(2, RoundingMode.DOWN));
        kawaseRateBean.setKwsrateKijyunymd4mae(getKawaseRate.getKwsrateKjYmd());

        getKawaseRate.exec(
            syoriYmd4mae,
            C_KawaserateSyuruiKbn.KOUJIKAWASERATE,
            C_Tuukasyu.AUD,
            C_Tuukasyu.JPY,
            C_KawasetekiyoKbn.TTM,
            C_KawasetsryKbn.JISSEIRATE,
            C_EigyoubiHoseiKbn.YOKUEIGYOUBI,
            C_YouhiKbn.HUYOU);

        kawaseRateBean.setKwsrateAudjpy4mae(getKawaseRate.getKawaserate().round(2, RoundingMode.DOWN));

        BizDate syoriYmd5mae = BizDate.valueOf(pSyoriYmd.addMonths(-5).getBizDateYM(), 1);
        getKawaseRate.exec(
            syoriYmd5mae,
            C_KawaserateSyuruiKbn.KOUJIKAWASERATE,
            C_Tuukasyu.USD,
            C_Tuukasyu.JPY,
            C_KawasetekiyoKbn.TTM,
            C_KawasetsryKbn.JISSEIRATE,
            C_EigyoubiHoseiKbn.YOKUEIGYOUBI,
            C_YouhiKbn.HUYOU);

        kawaseRateBean.setKwsrateUsdjpy5mae(getKawaseRate.getKawaserate().round(2, RoundingMode.DOWN));
        kawaseRateBean.setKwsrateKijyunymd5mae(getKawaseRate.getKwsrateKjYmd());

        getKawaseRate.exec(
            syoriYmd5mae,
            C_KawaserateSyuruiKbn.KOUJIKAWASERATE,
            C_Tuukasyu.AUD,
            C_Tuukasyu.JPY,
            C_KawasetekiyoKbn.TTM,
            C_KawasetsryKbn.JISSEIRATE,
            C_EigyoubiHoseiKbn.YOKUEIGYOUBI,
            C_YouhiKbn.HUYOU);

        kawaseRateBean.setKwsrateAudjpy5mae(getKawaseRate.getKawaserate().round(2, RoundingMode.DOWN));

        BizDate syoriYmd6mae = BizDate.valueOf(pSyoriYmd.addMonths(-6).getBizDateYM(), 1);
        getKawaseRate.exec(
            syoriYmd6mae,
            C_KawaserateSyuruiKbn.KOUJIKAWASERATE,
            C_Tuukasyu.USD,
            C_Tuukasyu.JPY,
            C_KawasetekiyoKbn.TTM,
            C_KawasetsryKbn.JISSEIRATE,
            C_EigyoubiHoseiKbn.YOKUEIGYOUBI,
            C_YouhiKbn.HUYOU);

        kawaseRateBean.setKwsrateUsdjpy6mae(getKawaseRate.getKawaserate().round(2, RoundingMode.DOWN));
        kawaseRateBean.setKwsrateKijyunymd6mae(getKawaseRate.getKwsrateKjYmd());

        getKawaseRate.exec(
            syoriYmd6mae,
            C_KawaserateSyuruiKbn.KOUJIKAWASERATE,
            C_Tuukasyu.AUD,
            C_Tuukasyu.JPY,
            C_KawasetekiyoKbn.TTM,
            C_KawasetsryKbn.JISSEIRATE,
            C_EigyoubiHoseiKbn.YOKUEIGYOUBI,
            C_YouhiKbn.HUYOU);

        kawaseRateBean.setKwsrateAudjpy6mae(getKawaseRate.getKawaserate().round(2, RoundingMode.DOWN));

        BizDate syoriYmd7mae = BizDate.valueOf(pSyoriYmd.addMonths(-7).getBizDateYM(), 1);
        getKawaseRate.exec(
            syoriYmd7mae,
            C_KawaserateSyuruiKbn.KOUJIKAWASERATE,
            C_Tuukasyu.USD,
            C_Tuukasyu.JPY,
            C_KawasetekiyoKbn.TTM,
            C_KawasetsryKbn.JISSEIRATE,
            C_EigyoubiHoseiKbn.YOKUEIGYOUBI,
            C_YouhiKbn.HUYOU);

        kawaseRateBean.setKwsrateUsdjpy7mae(getKawaseRate.getKawaserate().round(2, RoundingMode.DOWN));
        kawaseRateBean.setKwsrateKijyunymd7mae(getKawaseRate.getKwsrateKjYmd());

        getKawaseRate.exec(
            syoriYmd7mae,
            C_KawaserateSyuruiKbn.KOUJIKAWASERATE,
            C_Tuukasyu.AUD,
            C_Tuukasyu.JPY,
            C_KawasetekiyoKbn.TTM,
            C_KawasetsryKbn.JISSEIRATE,
            C_EigyoubiHoseiKbn.YOKUEIGYOUBI,
            C_YouhiKbn.HUYOU);

        kawaseRateBean.setKwsrateAudjpy7mae(getKawaseRate.getKawaserate().round(2, RoundingMode.DOWN));

        return kawaseRateBean;
    }

    public ZT_GaikaKokyakuTuutiTy editInfo(
        String pSyono,
        BizDate pSyoriYmd,
        BizDate pKykoutoubi,
        String pSyouhnHanmeiKbn,
        String pCampaignFlg,
        KawaseRateBean pKawaseRateBean,
        int pYobidasimotoKbn) {

        ZT_GaikaKokyakuTuutiTy gaikaKokyakuTuutiTy = new ZT_GaikaKokyakuTuutiTy();

        EditKykNaiyouOsiraseKytKm editKykNaiyouOsiraseKytKm =
            SWAKInjector.getInstance(EditKykNaiyouOsiraseKytKm.class);
        gaikaKokyakuTuutiTy = editKykNaiyouOsiraseKytKm.editDsTourokuJyou(
            pSyono,
            pSyoriYmd,
            gaikaKokyakuTuutiTy);

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(pSyono);

        gaikaKokyakuTuutiTy = editKykNaiyouOsiraseKytKm.editInfo(
            kykKihon,
            pSyoriYmd,
            pKykoutoubi,
            pSyouhnHanmeiKbn,
            gaikaKokyakuTuutiTy,
            pYobidasimotoKbn);

        commonErrorKbn = editKykNaiyouOsiraseKytKm.getCommonErrorKbn();

        bizLogicErrorKbn = editKykNaiyouOsiraseKytKm.getBizLogicErrorKbn();

        if (C_ErrorKbn.ERROR.eq(bizLogicErrorKbn)) {

            bizLogicErrorMsg = editKykNaiyouOsiraseKytKm.getBizLogicErrorMsg();

            return null;
        }

        if (C_ErrorKbn.OK.eq(commonErrorKbn)) {
            switch (pSyouhnHanmeiKbn) {
                case SYOUHNHANMEIKBN_SYUUSIN_GAIKA:
                    EditKykNaiyouOsirase1 editKykNaiyouOsirase1 =
                    SWAKInjector.getInstance(EditKykNaiyouOsirase1.class);
                    gaikaKokyakuTuutiTy = editKykNaiyouOsirase1.editInfo(
                        kykKihon,
                        pSyoriYmd,
                        pKykoutoubi,
                        pKawaseRateBean,
                        gaikaKokyakuTuutiTy);
                    commonErrorKbn = editKykNaiyouOsirase1.getCommonErrorKbn();

                    break;

                case SYOUHNHANMEIKBN_NENKIN_SISUU3MONTHMAE:
                case SYOUHNHANMEIKBN_NENKIN_SISUU:
                case SYOUHNHANMEIKBN_NENKIN_TEIRITU:
                case SYOUHNHANMEIKBN_NENKIN_TEIRITUITEN:
                    EditKykNaiyouOsirase2 editKykNaiyouOsirase2 =
                    SWAKInjector.getInstance(EditKykNaiyouOsirase2.class);
                    gaikaKokyakuTuutiTy = editKykNaiyouOsirase2.editInfo(
                        kykKihon,
                        pSyoriYmd,
                        pKykoutoubi,
                        pSyouhnHanmeiKbn,
                        gaikaKokyakuTuutiTy);
                    commonErrorKbn = editKykNaiyouOsirase2.getCommonErrorKbn();

                    break;

                case SYOUHNHANMEIKBN_DUO:
                    EditKykNaiyouOsirase3 editKykNaiyouOsirase3 =
                    SWAKInjector.getInstance(EditKykNaiyouOsirase3.class);
                    gaikaKokyakuTuutiTy = editKykNaiyouOsirase3.editInfo(
                        kykKihon,
                        pSyoriYmd,
                        pKykoutoubi,
                        pSyouhnHanmeiKbn,
                        gaikaKokyakuTuutiTy,
                        pYobidasimotoKbn);
                    commonErrorKbn = editKykNaiyouOsirase3.getCommonErrorKbn();

                    bizLogicErrorKbn = editKykNaiyouOsirase3.getBizLogicErrorKbn();

                    bizLogicErrorMsg = editKykNaiyouOsirase3.getBizLogicErrorMsg();

                    break;

                case SYOUHNHANMEIKBN_SYUUSIN_ENKA:
                    EditKykNaiyouOsirase4 editKykNaiyouOsirase4 =
                    SWAKInjector.getInstance(EditKykNaiyouOsirase4.class);
                    gaikaKokyakuTuutiTy = editKykNaiyouOsirase4.editInfo(
                        kykKihon,
                        pSyoriYmd,
                        pKykoutoubi,
                        gaikaKokyakuTuutiTy);
                    commonErrorKbn = editKykNaiyouOsirase4.getCommonErrorKbn();

                    break;

                case SYOUHNHANMEIKBN_NENKIN_ENKA:
                    EditKykNaiyouOsirase5 editKykNaiyouOsirase5 =
                    SWAKInjector.getInstance(EditKykNaiyouOsirase5.class);
                    gaikaKokyakuTuutiTy = editKykNaiyouOsirase5.editInfo(
                        kykKihon,
                        pSyoriYmd,
                        pKykoutoubi,
                        gaikaKokyakuTuutiTy);
                    commonErrorKbn = editKykNaiyouOsirase5.getCommonErrorKbn();

                    break;

                case SYOUHNHANMEIKBN_SYUUSIN_GAIKA_KAITEI:
                    EditKykNaiyouOsirase6 editKykNaiyouOsirase6 =
                    SWAKInjector.getInstance(EditKykNaiyouOsirase6.class);
                    gaikaKokyakuTuutiTy = editKykNaiyouOsirase6.editInfo(
                        kykKihon,
                        pSyoriYmd,
                        pKykoutoubi,
                        pKawaseRateBean,
                        gaikaKokyakuTuutiTy);
                    commonErrorKbn = editKykNaiyouOsirase6.getCommonErrorKbn();

                    break;

                case SYOUHNHANMEIKBN_SYUUSIN_ENKA_19:
                    EditKykNaiyouOsirase7 editKykNaiyouOsirase7 =
                    SWAKInjector.getInstance(EditKykNaiyouOsirase7.class);
                    gaikaKokyakuTuutiTy = editKykNaiyouOsirase7.editInfo(
                        kykKihon,
                        pSyoriYmd,
                        pKykoutoubi,
                        gaikaKokyakuTuutiTy);
                    commonErrorKbn = editKykNaiyouOsirase7.getCommonErrorKbn();

                    break;

                default:
                    break;
            }
            if (CAMPAIGNFLG_ARI.equals(pCampaignFlg)) {
                List<String> osirasemsgcdList = Lists.newArrayList();

                osirasemsgcdList.add(OSIRASEMSGCD_08011);

                for (int index = 1; index <= 5; index++) {

                    try {
                        String osirasemsgcd =
                            methodNmEditAndExec(
                                ZT_GaikaKokyakuTuutiTy.class,
                                gaikaKokyakuTuutiTy,
                                "getZtyosirasemsgcd",
                                index);

                        if (BizUtil.isBlank(osirasemsgcd)) {
                            break;
                        }

                        osirasemsgcdList.add(osirasemsgcd);

                    } catch (IllegalAccessException
                        | NoSuchMethodException
                        | InvocationTargetException e) {
                        throw new CommonBizAppException();
                    }
                }

                osirasemsgcdList.removeAll(Collections.singletonList(""));

                while (osirasemsgcdList.size() < 5) {
                    osirasemsgcdList.add("");
                }
                gaikaKokyakuTuutiTy.setZtyosirasemsgcd1(osirasemsgcdList.get(0));
                gaikaKokyakuTuutiTy.setZtyosirasemsgcd2(osirasemsgcdList.get(1));
                gaikaKokyakuTuutiTy.setZtyosirasemsgcd3(osirasemsgcdList.get(2));
                gaikaKokyakuTuutiTy.setZtyosirasemsgcd4(osirasemsgcdList.get(3));
                gaikaKokyakuTuutiTy.setZtyosirasemsgcd5(osirasemsgcdList.get(4));
            }

            List<String> aisatumsgcdList = Lists.newArrayList();

            aisatumsgcdList.add(AISATUMSGCD_03003);

            for (int index = 1; index <= 3; index++) {

                try {
                    String aisatumsgcd =
                        methodNmEditAndExec(
                            ZT_GaikaKokyakuTuutiTy.class,
                            gaikaKokyakuTuutiTy,
                            "getZtyaisatumsgcd",
                            index);

                    if (BizUtil.isBlank(aisatumsgcd)) {
                        break;
                    }

                    aisatumsgcdList.add(aisatumsgcd);

                } catch (IllegalAccessException
                    | NoSuchMethodException
                    | InvocationTargetException e) {
                    throw new CommonBizAppException();
                }
            }

            aisatumsgcdList.removeAll(Collections.singletonList(""));

            while (aisatumsgcdList.size() < 3) {
                aisatumsgcdList.add("");
            }
            gaikaKokyakuTuutiTy.setZtyaisatumsgcd1(aisatumsgcdList.get(0));
            gaikaKokyakuTuutiTy.setZtyaisatumsgcd2(aisatumsgcdList.get(1));
            gaikaKokyakuTuutiTy.setZtyaisatumsgcd3(aisatumsgcdList.get(2));
        }

        BizPropertyInitializer.initialize(gaikaKokyakuTuutiTy);

        kykKihon.detach();

        return gaikaKokyakuTuutiTy;
    }


    private String methodNmEditAndExec (
        Class<ZT_GaikaKokyakuTuutiTy> pClass,
        ZT_GaikaKokyakuTuutiTy pGaikaKokyakuTuutiTy,
        String pMethodNm,
        int pMethodNo) throws
        IllegalAccessException,
        NoSuchMethodException,
        InvocationTargetException {

        Method getMethod = pClass.getMethod(pMethodNm + String.valueOf(pMethodNo));
        Object getValue  = getMethod.invoke(pGaikaKokyakuTuutiTy);

        if (getValue == null) {
            return "";
        }

        return getValue.toString();
    }
}
