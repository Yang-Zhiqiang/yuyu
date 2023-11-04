package yuyu.common.biz.bzcommon;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.number.BizNumber;
import yuyu.app.bosyuu.hbsekmos.hbnyknkwsrate.HbNyknkwsrateTest_execPostForm;
import yuyu.app.bosyuu.hbsekmos.hbseihowebnenkinkaiyakuhrsuii.HbSeihoWebNenkinKaiyakuhrSuiiTest_execPostForm;
import yuyu.app.dsweb.dwhozeninfo.dwgethozenkiykgikhijynnnkn.DwGetHozenKiykGikHijynNnknImplTest_execPostForm;
import yuyu.app.dsweb.dwhozeninfo.dwgethozenkiykgikitijinnkn.DwGetHozenKiykGikItijiNnknImplTest_execPostForm;
import yuyu.app.dsweb.dwhozentetuduki.dwkaiyakuuketuke.DwKaiyakuUketukeTest_execPostFormPrepare;
import yuyu.common.bosyuu.hbkeiyakusyoukai.HbKeiyakuSyoukaiTest_exec;
import yuyu.common.direct.dscommon.CheckKaiyakuUketukeTest_kaiyakusyokaiChk;
import yuyu.common.direct.dscommon.DsGetKeiyakuSyousaiTest_exec;
import yuyu.common.hozen.haitou.KeisanDTest_exec;
import yuyu.common.hozen.khcommon.EditDairitenTesuuryouTblTest_exec_A1;
import yuyu.common.hozen.khcommon.EditKykNaiyouOsirase1Test_editInfo;
import yuyu.common.hozen.khcommon.EditKykNaiyouOsirase2Test_editInfo;
import yuyu.common.hozen.khcommon.EditKykNaiyouOsirase3Test_editInfo;
import yuyu.common.hozen.khcommon.EditKykNaiyouOsiraseTest_getKawaseRateBean;
import yuyu.common.hozen.khcommon.EditSyoukenTblTest_editTBL_A1;
import yuyu.common.hozen.khcommon.EditSyoukenTblTest_editTBL_A2;
import yuyu.common.hozen.khcommon.EditSyoukenTblTest_editTBL_A3;
import yuyu.common.hozen.khcommon.EditSyoukenTblTest_editTBL_A4;
import yuyu.common.hozen.khcommon.EditSyoukenTblTest_editTBL_A5;
import yuyu.common.hozen.khcommon.EditSyoukenTbltest_editTBL;
import yuyu.common.hozen.khcommon.KeisanGaikaPTest_exec;
import yuyu.common.hozen.khcommon.KeisanKhGensenTest_exec;
import yuyu.common.hozen.khcommon.WSuiihyouNenkin2Test_exec;
import yuyu.common.hozen.khcommon.WSuiihyouNenkinTest_exec;
import yuyu.common.hozen.khcommon.WSuiihyouTest_exec;
import yuyu.common.siharai.sicommon.SiSiharaiKingakuKeisanTest_exec;
import yuyu.common.sinkeiyaku.moschk.KeisanSPTest_exec;
import yuyu.common.sinkeiyaku.moschk.SetKisoKoumokuTest_exec;
import yuyu.common.sinkeiyaku.skcommon.EditPalRenkeiKoumokuTest_getEnknsnKawaseRate;
import yuyu.common.sinkeiyaku.skcommon.EditPalRenkeiKoumokuTest_getSyksbEnknsnKawaseRate;
import yuyu.common.sinkeiyaku.skcommon.HenkinTest_exec;
import yuyu.common.sinkeiyaku.skcommon.HenkinTest_execPkakin;
import yuyu.common.suuri.srcommon.SrSinkykSeirituKoumokuCommonSetTest_exec;
import yuyu.common.suuri.srcommon.SrSuuriGouseiRateKeisanTest_exec;
import yuyu.def.classification.C_EigyoubiHoseiKbn;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_IkkatubaraiKbn;
import yuyu.def.classification.C_KawaserateSyuruiKbn;
import yuyu.def.classification.C_KawasetekiyoKbn;
import yuyu.def.classification.C_KawasetsryKbn;
import yuyu.def.classification.C_SysKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_YouhiKbn;

/**
 * {@link GetKawaseRate}のモッククラスです。<br />
 */
public class GetKawaseRateMock extends GetKawaseRate {

    public static Class<?> caller = null;

    public static String SYORIPTN = null;

    public static final String TESTPATTERN1 = "1";

    public static final String TESTPATTERN2 = "2";

    public static final String TESTPATTERN3 = "3";

    public static final String TESTPATTERN4 = "4";

    public static final String TESTPATTERN5 = "5";

    public static final String TESTPATTERN6 = "6";
    public static final String TESTPATTERN7 = "7";
    public static final String TESTPATTERN8 = "8";
    public static final String TESTPATTERN9 = "9";
    public static final String TESTPATTERN10 = "10";

    private String flag = "0";

    @Override
    public C_ErrorKbn exec(BizDate pKwsrateKjYmd, C_KawaserateSyuruiKbn pKawaserateSyuruiKbn, C_Tuukasyu pMototuuka,
        C_Tuukasyu pKanzantuuka, C_KawasetekiyoKbn pKawaseteKiyoKbn, C_KawasetsryKbn pKawasetsryKbn,
        C_EigyoubiHoseiKbn pEigyoubiHoseiKbn, C_YouhiKbn pZenEigyoubiKsSyutokuYouhi) {
        if (caller == HenkinTest_exec.class && SYORIPTN == TESTPATTERN1) {
            super.exec(pKwsrateKjYmd, pKawaserateSyuruiKbn, pMototuuka, pKanzantuuka, pKawaseteKiyoKbn,
                pKawasetsryKbn, pEigyoubiHoseiKbn, pZenEigyoubiKsSyutokuYouhi);
            return C_ErrorKbn.OK;
        }
        if (caller == HenkinTest_exec.class && SYORIPTN == TESTPATTERN2) {
            super.exec(pKwsrateKjYmd, pKawaserateSyuruiKbn, pMototuuka, pKanzantuuka, pKawaseteKiyoKbn,
                pKawasetsryKbn, pEigyoubiHoseiKbn, pZenEigyoubiKsSyutokuYouhi);
            return C_ErrorKbn.ERROR;
        }
        if (caller == HenkinTest_exec.class && SYORIPTN == TESTPATTERN3) {
            super.exec(pKwsrateKjYmd, pKawaserateSyuruiKbn, pMototuuka, pKanzantuuka, pKawaseteKiyoKbn,
                pKawasetsryKbn, pEigyoubiHoseiKbn, pZenEigyoubiKsSyutokuYouhi);
            if (C_Tuukasyu.BLNK.eq(pMototuuka)) {
                return C_ErrorKbn.OK;
            }
            return C_ErrorKbn.ERROR;
        }
        if (caller == HenkinTest_execPkakin.class) {
            super.exec(pKwsrateKjYmd, pKawaserateSyuruiKbn, pMototuuka, pKanzantuuka, pKawaseteKiyoKbn,
                pKawasetsryKbn, pEigyoubiHoseiKbn, pZenEigyoubiKsSyutokuYouhi);
            return C_ErrorKbn.OK;
        }
        else if (caller == KeisanSPTest_exec.class && SYORIPTN == TESTPATTERN1) {
            return C_ErrorKbn.ERROR;
        }
        else if (caller == KeisanSPTest_exec.class && SYORIPTN == TESTPATTERN2) {
            super.exec(pKwsrateKjYmd, pKawaserateSyuruiKbn, pMototuuka, pKanzantuuka, pKawaseteKiyoKbn,
                pKawasetsryKbn, pEigyoubiHoseiKbn, pZenEigyoubiKsSyutokuYouhi);
            return C_ErrorKbn.OK;
        }
        else if (caller == KeisanKhGensenTest_exec.class && SYORIPTN == TESTPATTERN1) {
            super.exec(pKwsrateKjYmd, pKawaserateSyuruiKbn, pMototuuka, pKanzantuuka, pKawaseteKiyoKbn,
                pKawasetsryKbn, pEigyoubiHoseiKbn, pZenEigyoubiKsSyutokuYouhi);
            return C_ErrorKbn.ERROR;
        }
        else if (caller == KeisanKhGensenTest_exec.class && SYORIPTN == TESTPATTERN2) {
            super.exec(pKwsrateKjYmd, pKawaserateSyuruiKbn, pMototuuka, pKanzantuuka, pKawaseteKiyoKbn,
                pKawasetsryKbn, pEigyoubiHoseiKbn, pZenEigyoubiKsSyutokuYouhi);
            return C_ErrorKbn.OK;
        }
        else if (caller == EditPalRenkeiKoumokuTest_getEnknsnKawaseRate.class && SYORIPTN == TESTPATTERN1) {
            super.exec(pKwsrateKjYmd, pKawaserateSyuruiKbn, pMototuuka, pKanzantuuka, pKawaseteKiyoKbn,
                pKawasetsryKbn, pEigyoubiHoseiKbn, pZenEigyoubiKsSyutokuYouhi);
            return C_ErrorKbn.OK;
        }
        else if (caller == EditPalRenkeiKoumokuTest_getSyksbEnknsnKawaseRate.class && SYORIPTN == TESTPATTERN1) {
            super.exec(pKwsrateKjYmd, pKawaserateSyuruiKbn, pMototuuka, pKanzantuuka, pKawaseteKiyoKbn,
                pKawasetsryKbn, pEigyoubiHoseiKbn, pZenEigyoubiKsSyutokuYouhi);
            return C_ErrorKbn.OK;
        }

        else if (caller == HbKeiyakuSyoukaiTest_exec.class) {

            if (TESTPATTERN1.equals(SYORIPTN)) {
                if (C_KawasetsryKbn.NYUKINRATE.eq(pKawasetsryKbn)) {
                    return C_ErrorKbn.ERROR;
                }
                return C_ErrorKbn.OK;

            }

            if (TESTPATTERN2.equals(SYORIPTN)) {
                if (C_KawasetsryKbn.NYUKINRATE.eq(pKawasetsryKbn)) {
                    return C_ErrorKbn.OK;
                }
                return C_ErrorKbn.ERROR;
            }
            if (TESTPATTERN3.equals(SYORIPTN)) {

                return C_ErrorKbn.OK;
            }

        }

        else if (caller == EditDairitenTesuuryouTblTest_exec_A1.class) {

            if (TESTPATTERN1.equals(SYORIPTN)) {

                super.exec(pKwsrateKjYmd, pKawaserateSyuruiKbn, pMototuuka, pKanzantuuka, pKawaseteKiyoKbn,
                    pKawasetsryKbn, pEigyoubiHoseiKbn, pZenEigyoubiKsSyutokuYouhi);

                return C_ErrorKbn.OK;
            }
            else if (TESTPATTERN2.equals(SYORIPTN)) {

                super.exec(pKwsrateKjYmd, pKawaserateSyuruiKbn, pMototuuka, pKanzantuuka, pKawaseteKiyoKbn,
                    pKawasetsryKbn, pEigyoubiHoseiKbn, pZenEigyoubiKsSyutokuYouhi);

                return C_ErrorKbn.ERROR;
            }
        }
        else if (caller == DsGetKeiyakuSyousaiTest_exec.class && SYORIPTN == TESTPATTERN1) {
            return C_ErrorKbn.OK;
        }
        else if (caller == DsGetKeiyakuSyousaiTest_exec.class && SYORIPTN == TESTPATTERN2) {
            return C_ErrorKbn.ERROR;
        }
        else if (caller == DsGetKeiyakuSyousaiTest_exec.class && SYORIPTN == TESTPATTERN3 && "0".equals(flag)) {
            return C_ErrorKbn.OK;
        }
        else if (caller == DsGetKeiyakuSyousaiTest_exec.class && SYORIPTN == TESTPATTERN3 && "1".equals(flag)) {
            flag = "0";
            return C_ErrorKbn.ERROR;
        }
        else if (caller == DsGetKeiyakuSyousaiTest_exec.class && SYORIPTN == TESTPATTERN4) {
            return C_ErrorKbn.OK;
        }
        else if (caller == DsGetKeiyakuSyousaiTest_exec.class && SYORIPTN == TESTPATTERN5) {
            return C_ErrorKbn.OK;
        }
        else if (caller == SrSinkykSeirituKoumokuCommonSetTest_exec.class) {
            if (TESTPATTERN1.equals(SYORIPTN)) {
                return C_ErrorKbn.OK;
            }
            else if (TESTPATTERN2.equals(SYORIPTN)) {
                return C_ErrorKbn.ERROR;
            }
        }

        if (caller == EditSyoukenTblTest_editTBL_A1.class || caller == EditSyoukenTblTest_editTBL_A2.class ||
            caller == EditSyoukenTblTest_editTBL_A3.class || caller == EditSyoukenTblTest_editTBL_A4.class ||
            caller == EditSyoukenTblTest_editTBL_A5.class || caller == EditSyoukenTbltest_editTBL.class) {
            if (TESTPATTERN1.equals(SYORIPTN)) {
                return C_ErrorKbn.OK;
            }
            else if (TESTPATTERN2.equals(SYORIPTN)) {
                return C_ErrorKbn.OK;
            }
        }
        if (caller == SiSiharaiKingakuKeisanTest_exec.class) {
            if (TESTPATTERN1.equals(SYORIPTN)) {
                return C_ErrorKbn.ERROR;
            }
            else if (TESTPATTERN2.equals(SYORIPTN)) {
                return C_ErrorKbn.OK;
            }
            else if (TESTPATTERN3.equals(SYORIPTN)) {
                if (BizDateUtil.compareYmd(pKwsrateKjYmd, BizDate.valueOf("20180203")) == BizDateUtil.COMPARE_EQUAL) {
                    flag = "1";
                }
                return C_ErrorKbn.OK;
            }
            else if (TESTPATTERN4.equals(SYORIPTN)) {
                return C_ErrorKbn.OK;
            }
            else if (TESTPATTERN5.equals(SYORIPTN)) {
                return C_ErrorKbn.OK;
            }
            else if (TESTPATTERN6.equals(SYORIPTN)) {
                return C_ErrorKbn.OK;
            }
            else if (TESTPATTERN7.equals(SYORIPTN)) {
                return C_ErrorKbn.OK;
            }
            else if (TESTPATTERN8.equals(SYORIPTN)) {
                return C_ErrorKbn.OK;
            }
            else if (TESTPATTERN9.equals(SYORIPTN)) {
                return C_ErrorKbn.OK;
            }
            else if (TESTPATTERN10.equals(SYORIPTN)) {
                if (C_KawasetsryKbn.SYUKKINRATE.eq(pKawasetsryKbn)) {
                    return C_ErrorKbn.OK;
                } else if (C_KawasetsryKbn.NYUKINRATE.eq(pKawasetsryKbn)) {
                    return C_ErrorKbn.ERROR;
                }
            }
        }

        if (caller == KeisanDTest_exec.class) {
            if (TESTPATTERN1.equals(SYORIPTN)) {
                return C_ErrorKbn.OK;
            }
            else if (TESTPATTERN2.equals(SYORIPTN)) {
                return C_ErrorKbn.ERROR;
            }
            else if (TESTPATTERN3.equals(SYORIPTN)) {
                return C_ErrorKbn.OK;
            }
        }

        if (caller == SrSuuriGouseiRateKeisanTest_exec.class) {
            if (TESTPATTERN1.equals(SYORIPTN)) {
                return C_ErrorKbn.OK;
            }
            else if (TESTPATTERN2.equals(SYORIPTN)) {
                return C_ErrorKbn.ERROR;
            }
        }

        if (caller == DwKaiyakuUketukeTest_execPostFormPrepare.class) {
            if (TESTPATTERN1.equals(SYORIPTN)) {
                return C_ErrorKbn.OK;
            }
            else if (TESTPATTERN2.equals(SYORIPTN)) {
                return C_ErrorKbn.ERROR;
            }
        }

        if (caller == WSuiihyouNenkinTest_exec.class && SYORIPTN == TESTPATTERN1) {
            return C_ErrorKbn.OK;
        }

        if (caller == DwGetHozenKiykGikItijiNnknImplTest_execPostForm.class && SYORIPTN == TESTPATTERN1) {
            return C_ErrorKbn.OK;
        }
        else  if (caller == DwGetHozenKiykGikItijiNnknImplTest_execPostForm.class && SYORIPTN == TESTPATTERN2) {
            return C_ErrorKbn.ERROR;
        }

        if (caller == DwGetHozenKiykGikHijynNnknImplTest_execPostForm.class) {

            if (SYORIPTN == TESTPATTERN1) {

                if (C_KawasetsryKbn.SYUKKINRATE.eq(pKawasetsryKbn) ) {
                    flag = "0";
                }
                else if (C_KawasetsryKbn.NYUKINRATE.eq(pKawasetsryKbn) ) {
                    flag = "1";
                }
                return C_ErrorKbn.OK;
            }
            else  if (SYORIPTN == TESTPATTERN2) {
                return C_ErrorKbn.ERROR;
            }
        }

        if (caller == CheckKaiyakuUketukeTest_kaiyakusyokaiChk.class) {

            if (TESTPATTERN1.equals(SYORIPTN)) {
                return C_ErrorKbn.ERROR;
            }

            if (TESTPATTERN2.equals(SYORIPTN)) {
                return C_ErrorKbn.OK;
            }
        }

        if (caller == HbNyknkwsrateTest_execPostForm.class && SYORIPTN == TESTPATTERN1) {

            if (pMototuuka.equals(C_Tuukasyu.USD) && pKanzantuuka.equals(C_Tuukasyu.JPY)) {
                flag = "0";
            } else if (pMototuuka.equals(C_Tuukasyu.AUD) && pKanzantuuka.equals(C_Tuukasyu.JPY)) {
                flag = "1";
            } else if (pMototuuka.equals(C_Tuukasyu.AUD) && pKanzantuuka.equals(C_Tuukasyu.USD)) {
                flag = "2";
            } else if (pMototuuka.equals(C_Tuukasyu.USD) && pKanzantuuka.equals(C_Tuukasyu.AUD)) {
                flag = "3";
            }
            return C_ErrorKbn.OK;
        }
        else  if (caller == HbNyknkwsrateTest_execPostForm.class && SYORIPTN == TESTPATTERN2) {
            return C_ErrorKbn.ERROR;
        }
        else  if (caller == HbNyknkwsrateTest_execPostForm.class && SYORIPTN == TESTPATTERN3) {
            return C_ErrorKbn.OK;
        }

        if (caller == KeisanGaikaPTest_exec.class && SYORIPTN == TESTPATTERN1) {
            return C_ErrorKbn.ERROR;
        }
        else  if (caller == KeisanGaikaPTest_exec.class && SYORIPTN == TESTPATTERN2) {
            return C_ErrorKbn.OK;
        }


        if (caller == EditKykNaiyouOsiraseTest_getKawaseRateBean.class) {
            return C_ErrorKbn.OK;
        }
        if (EditKykNaiyouOsirase2Test_editInfo.class == caller) {
            if (TESTPATTERN1.equals(SYORIPTN)) {
                return C_ErrorKbn.OK;
            }
            else {
                return C_ErrorKbn.ERROR;
            }
        }

        else if (caller == EditKykNaiyouOsirase1Test_editInfo.class && SYORIPTN == TESTPATTERN1) {
            return C_ErrorKbn.OK;
        }
        else if (caller == EditKykNaiyouOsirase1Test_editInfo.class && SYORIPTN == TESTPATTERN2) {
            return C_ErrorKbn.OK;
        }
        else if (caller == EditKykNaiyouOsirase3Test_editInfo.class && SYORIPTN == TESTPATTERN1) {
            return C_ErrorKbn.OK;
        }
        if (WSuiihyouTest_exec.class == caller) {
            if (TESTPATTERN1.equals(SYORIPTN)) {

                return C_ErrorKbn.ERROR;
            }
        }

        return super.exec(pKwsrateKjYmd, pKawaserateSyuruiKbn, pMototuuka, pKanzantuuka, pKawaseteKiyoKbn,
            pKawasetsryKbn, pEigyoubiHoseiKbn, pZenEigyoubiKsSyutokuYouhi);
    }

    @Override
    public C_ErrorKbn execFstPNyuukin(BizDate pRyosyuymd, C_Tuukasyu pKyktuuka, C_Tuukasyu pHrktuuka,
        C_YouhiKbn pZenEigyoubiKsSyutokuYouhi, C_Hrkkaisuu pHrkkaisuu, C_SysKbn pSysKbn,
        C_UmuKbn pZennouMousideumu,  C_IkkatubaraiKbn pIkkatubaraiKbn) {

        if (caller == SetKisoKoumokuTest_exec.class) {

            if (TESTPATTERN1.equals(SYORIPTN)) {
                return C_ErrorKbn.OK;
            }
            if (TESTPATTERN2.equals(SYORIPTN)) {
                return C_ErrorKbn.OK;
            }
            if (TESTPATTERN3.equals(SYORIPTN)) {
                return C_ErrorKbn.OK;
            }
            if (TESTPATTERN4.equals(SYORIPTN)) {
                return C_ErrorKbn.ERROR;
            }

        }
        if (caller == HenkinTest_exec.class) {

            if (TESTPATTERN1.equals(SYORIPTN)) {
                return C_ErrorKbn.OK;
            }
            if (TESTPATTERN2.equals(SYORIPTN)) {
                return C_ErrorKbn.ERROR;
            }
        }
        else if (caller == HbSeihoWebNenkinKaiyakuhrSuiiTest_execPostForm.class) {

            if (TESTPATTERN1.equals(SYORIPTN)) {

                BizNumber kawaseRate = BizNumber.valueOf(1);
                return C_ErrorKbn.OK;
            }
            if (TESTPATTERN2.equals(SYORIPTN)) {
                return C_ErrorKbn.ERROR;
            }
        }

        else if (caller == WSuiihyouNenkin2Test_exec.class) {

            if (TESTPATTERN1.equals(SYORIPTN)) {

                return C_ErrorKbn.OK;
            }
        }

        return super.execFstPNyuukin( pRyosyuymd, pKyktuuka, pHrktuuka, pZenEigyoubiKsSyutokuYouhi, pHrkkaisuu,
            pSysKbn, pZennouMousideumu, pIkkatubaraiKbn);
    }

    @Override
    public BizNumber getKawaserate() {
        if (caller == KeisanSPTest_exec.class) {
            return BizNumber.valueOf(1);
        }
        else if (caller == KeisanKhGensenTest_exec.class) {
            return BizNumber.valueOf(99);
        }
        else if (caller == EditPalRenkeiKoumokuTest_getEnknsnKawaseRate.class && SYORIPTN == TESTPATTERN1) {
            return BizNumber.valueOf(99);
        }
        else if (caller == EditPalRenkeiKoumokuTest_getSyksbEnknsnKawaseRate.class && SYORIPTN == TESTPATTERN1) {
            return BizNumber.valueOf(100);
        }
        else if (caller == HbKeiyakuSyoukaiTest_exec.class) {
            return BizNumber.valueOf(1);
        }
        if (caller == HenkinTest_exec.class) {
            return BizNumber.valueOf(100);
        }
        else if (caller == DsGetKeiyakuSyousaiTest_exec.class && SYORIPTN == TESTPATTERN1 && "0".equals(flag)) {
            return BizNumber.valueOf(1);
        }
        else if (caller == DsGetKeiyakuSyousaiTest_exec.class && SYORIPTN == TESTPATTERN1 && "1".equals(flag)) {
            return BizNumber.valueOf(1.5);
        }
        else if (caller == DsGetKeiyakuSyousaiTest_exec.class && SYORIPTN == TESTPATTERN3 && "0".equals(flag)) {
            return BizNumber.valueOf(1.1);
        }
        else if (caller == DsGetKeiyakuSyousaiTest_exec.class && SYORIPTN == TESTPATTERN4 && "0".equals(flag)) {
            return BizNumber.valueOf(1.2);
        }
        else if (caller == DsGetKeiyakuSyousaiTest_exec.class && SYORIPTN == TESTPATTERN4 && "1".equals(flag)) {
            return BizNumber.valueOf(1.6);
        }
        else if (caller == DsGetKeiyakuSyousaiTest_exec.class && SYORIPTN == TESTPATTERN5) {
            return BizNumber.valueOf(1.3);
        }
        else if (caller == SrSinkykSeirituKoumokuCommonSetTest_exec.class) {
            return BizNumber.valueOf(1);
        }
        if (caller == SiSiharaiKingakuKeisanTest_exec.class) {

            if (TESTPATTERN2.equals(SYORIPTN)) {
                return BizNumber.valueOf(101.12);
            }
            if (TESTPATTERN3.equals(SYORIPTN)) {
                if ("0".equals(flag)) {
                    return BizNumber.valueOf(102.03);
                }
                if ("1".equals(flag)) {
                    return BizNumber.valueOf(120.03);
                }
            }
            if (TESTPATTERN4.equals(SYORIPTN)) {
                return BizNumber.valueOf(102.04);
            }
            if (TESTPATTERN5.equals(SYORIPTN)) {
                return BizNumber.valueOf(102.06);
            }
            if (TESTPATTERN6.equals(SYORIPTN)) {
                return BizNumber.valueOf(120.07);
            }
            if (TESTPATTERN7.equals(SYORIPTN)) {
                return BizNumber.valueOf(120.08);
            }
            if (TESTPATTERN8.equals(SYORIPTN)) {
                return BizNumber.valueOf(120.13);
            }
            if (TESTPATTERN9.equals(SYORIPTN)) {
                return BizNumber.valueOf(120.15);
            }
        }
        if (caller == EditSyoukenTblTest_editTBL_A1.class || caller == EditSyoukenTblTest_editTBL_A2.class ||
            caller == EditSyoukenTblTest_editTBL_A3.class || caller == EditSyoukenTblTest_editTBL_A4.class ||
            caller == EditSyoukenTblTest_editTBL_A5.class || caller == EditSyoukenTbltest_editTBL.class) {
            if (TESTPATTERN1.equals(SYORIPTN)) {
                return BizNumber.valueOf(30);
            }
            if (TESTPATTERN2.equals(SYORIPTN)) {
                return BizNumber.valueOf(60);
            }
        }
        if (caller == SetKisoKoumokuTest_exec.class) {
            if (TESTPATTERN1.equals(SYORIPTN)) {
                return BizNumber.valueOf(0.0125);
            }
            if (TESTPATTERN2.equals(SYORIPTN)) {
                return BizNumber.valueOf(1.308);
            }
            if (TESTPATTERN3.equals(SYORIPTN)) {
                return BizNumber.valueOf(2.0134);
            }
        }

        if (caller == KeisanDTest_exec.class) {
            if (TESTPATTERN1.equals(SYORIPTN)) {
                return BizNumber.valueOf(80);
            }
            else if (TESTPATTERN3.equals(SYORIPTN)) {
                return BizNumber.valueOf(122.32);
            }
        }

        if (caller == SrSuuriGouseiRateKeisanTest_exec.class) {
            if (TESTPATTERN1.equals(SYORIPTN)) {
                return BizNumber.valueOf(30.02);
            }
        }

        if (caller == WSuiihyouNenkinTest_exec.class && SYORIPTN == TESTPATTERN1) {
            return BizNumber.valueOf(30.05);
        }

        if (caller == DwGetHozenKiykGikItijiNnknImplTest_execPostForm.class) {
            if (TESTPATTERN1.equals(SYORIPTN)) {
                return BizNumber.valueOf(0.0125);
            }
            if (TESTPATTERN2.equals(SYORIPTN)) {
                return BizNumber.valueOf(1.308);
            }
            if (TESTPATTERN3.equals(SYORIPTN)) {
                return BizNumber.valueOf(2.0134);
            }
        }

        if (caller == DwGetHozenKiykGikHijynNnknImplTest_execPostForm.class) {

            if (TESTPATTERN1.equals(SYORIPTN)) {

                if ("0".equals(flag)) {
                    return BizNumber.valueOf(0.11);
                }
                else if ("1".equals(flag)) {
                    return BizNumber.valueOf(0.12);
                }
            }
        }

        if (caller == HbNyknkwsrateTest_execPostForm.class && SYORIPTN == TESTPATTERN1) {
            if (flag.equals("0")) {
                return BizNumber.valueOf(0.01);
            } else if (flag.equals("1")) {
                return BizNumber.valueOf(0.02);
            } else if (flag.equals("2")) {
                return BizNumber.valueOf(0.03);
            } else if (flag.equals("3")) {
                flag = "0";
                return BizNumber.valueOf(0.04);
            }
        }
        else  if (caller == HbNyknkwsrateTest_execPostForm.class && SYORIPTN == TESTPATTERN2) {
            return BizNumber.valueOf(0.0126);
        }
        else  if (caller == HbNyknkwsrateTest_execPostForm.class && SYORIPTN == TESTPATTERN3) {
            return BizNumber.valueOf(2000000000);
        }
        else  if (caller == HbSeihoWebNenkinKaiyakuhrSuiiTest_execPostForm.class && SYORIPTN == TESTPATTERN1) {
            return BizNumber.valueOf(1);
        }
        else  if (caller == HbSeihoWebNenkinKaiyakuhrSuiiTest_execPostForm.class && SYORIPTN == TESTPATTERN2) {
            return BizNumber.valueOf(0);
        }


        if (caller == KeisanGaikaPTest_exec.class) {
            return BizNumber.valueOf(1.05);
        }

        if (caller == EditKykNaiyouOsiraseTest_getKawaseRateBean.class) {
            if (flag.equals("0")) {
                flag = "1";
                return BizNumber.valueOf(30.125);
            } else if (flag.equals("1")) {
                flag = "2";
                return BizNumber.valueOf(30.135);
            } else if (flag.equals("2")) {
                flag = "3";
                return BizNumber.valueOf(30.145);
            } else if (flag.equals("3")) {
                flag = "4";
                return BizNumber.valueOf(30.155);
            } else if (flag.equals("4")) {
                flag = "5";
                return BizNumber.valueOf(30.165);
            } else if (flag.equals("5")) {
                flag = "6";
                return BizNumber.valueOf(30.175);
            } else if (flag.equals("6")) {
                flag = "7";
                return BizNumber.valueOf(30.185);
            } else if (flag.equals("7")) {
                flag = "8";
                return BizNumber.valueOf(30.195);
            } else if (flag.equals("8")) {
                flag = "9";
                return BizNumber.valueOf(31.105);
            } else if (flag.equals("9")) {
                flag = "10";
                return BizNumber.valueOf(31.115);
            } else if (flag.equals("10")) {
                flag = "11";
                return BizNumber.valueOf(31.125);
            } else if (flag.equals("11")) {
                flag = "12";
                return BizNumber.valueOf(31.135);
            } else if (flag.equals("12")) {
                flag = "13";
                return BizNumber.valueOf(31.145);
            } else if (flag.equals("13")) {
                flag = "14";
                return BizNumber.valueOf(31.155);
            } else {
                return BizNumber.valueOf(31.165);
            }
        }
        if (EditKykNaiyouOsirase2Test_editInfo.class == caller) {
            if (TESTPATTERN1.equals(SYORIPTN)) {
                return BizNumber.valueOf(10.1);
            }
            else if (TESTPATTERN2.equals(SYORIPTN)) {
                return BizNumber.valueOf(10.5);
            }
            else if (TESTPATTERN3.equals(SYORIPTN)) {
                return BizNumber.valueOf(10.6);
            }
            else {
                return BizNumber.valueOf(10);
            }
        }

        else if (caller == EditKykNaiyouOsirase1Test_editInfo.class && SYORIPTN == TESTPATTERN1) {
            return BizNumber.valueOf(30.235);
        }
        else if (caller == EditKykNaiyouOsirase1Test_editInfo.class && SYORIPTN == TESTPATTERN2) {
            return BizNumber.valueOf(30.234);
        }
        else if (EditKykNaiyouOsirase3Test_editInfo.class == caller) {
            if (TESTPATTERN1.equals(SYORIPTN)) {
                return BizNumber.valueOf(10.1);
            }
            else if (TESTPATTERN2.equals(SYORIPTN)) {
                return BizNumber.valueOf(10.5);
            }
            else if (TESTPATTERN3.equals(SYORIPTN)) {
                return BizNumber.valueOf(10.6);
            }
            else {
                return BizNumber.valueOf(10);
            }
        }
        if (WSuiihyouTest_exec.class == caller) {
            if (TESTPATTERN1.equals(SYORIPTN)) {
                return BizNumber.valueOf(210.25);
            }
        }

        else if (WSuiihyouNenkin2Test_exec.class == caller) {

            if (TESTPATTERN1.equals(SYORIPTN)) {

                return BizNumber.valueOf(11);
            }
        }

        return super.getKawaserate();
    }

    @Override
    public BizDate getKwsrateKjYmd() {

        if (caller == KeisanKhGensenTest_exec.class) {
            return BizDate.valueOf("20120202");
        }

        if (caller == HenkinTest_exec.class) {
            return BizDate.valueOf("20161014");
        }

        else if (caller == DsGetKeiyakuSyousaiTest_exec.class && SYORIPTN == TESTPATTERN1 && "0".equals(flag)) {
            flag = "1";
            return BizDate.valueOf("20161118");
        }
        else if (caller == DsGetKeiyakuSyousaiTest_exec.class && SYORIPTN == TESTPATTERN1 && "1".equals(flag)) {
            flag = "0";
            return BizDate.valueOf("20161119");
        }
        else if (caller == DsGetKeiyakuSyousaiTest_exec.class && SYORIPTN == TESTPATTERN3 && "0".equals(flag)) {
            flag = "1";
            return BizDate.valueOf(20161120);
        }
        else if (caller == DsGetKeiyakuSyousaiTest_exec.class && SYORIPTN == TESTPATTERN4 && "0".equals(flag)) {
            flag = "1";
            return BizDate.valueOf("20161121");
        }
        else if (caller == DsGetKeiyakuSyousaiTest_exec.class && SYORIPTN == TESTPATTERN4 && "1".equals(flag)) {
            flag = "0";
            return BizDate.valueOf("20161122");
        }
        else if (caller == DsGetKeiyakuSyousaiTest_exec.class && SYORIPTN == TESTPATTERN5) {
            return BizDate.valueOf("20161123");
        }
        else if (caller == SrSinkykSeirituKoumokuCommonSetTest_exec.class) {
            return BizDate.valueOf("20160104");
        }
        else if (caller == SetKisoKoumokuTest_exec.class && SYORIPTN == TESTPATTERN1) {
            return BizDate.valueOf("20160517");
        }
        else if (caller == SetKisoKoumokuTest_exec.class && SYORIPTN == TESTPATTERN2) {
            return BizDate.valueOf("20160418");
        }
        else if (caller == SetKisoKoumokuTest_exec.class && SYORIPTN == TESTPATTERN3) {
            return BizDate.valueOf("20160812");
        }
        else if (caller == SiSiharaiKingakuKeisanTest_exec.class && SYORIPTN == TESTPATTERN2) {
            return BizDate.valueOf("20100112");
        }
        else if (caller == SiSiharaiKingakuKeisanTest_exec.class && SYORIPTN == TESTPATTERN3) {
            if ("0".equals(flag)) {
                return BizDate.valueOf("20100203");
            }
            if ("1".equals(flag)) {
                return BizDate.valueOf("20180202");
            }
        }
        else if (caller == SiSiharaiKingakuKeisanTest_exec.class && SYORIPTN == TESTPATTERN4) {
            return BizDate.valueOf("20170206");
        }
        else if (caller == SiSiharaiKingakuKeisanTest_exec.class && SYORIPTN == TESTPATTERN5) {
            return BizDate.valueOf("20160208");
        }
        else if (caller == SiSiharaiKingakuKeisanTest_exec.class && SYORIPTN == TESTPATTERN6) {
            return BizDate.valueOf("20180207");
        }
        else if (caller == SiSiharaiKingakuKeisanTest_exec.class && SYORIPTN == TESTPATTERN7) {
            return BizDate.valueOf("20180208");
        }
        else if (caller == SiSiharaiKingakuKeisanTest_exec.class && SYORIPTN == TESTPATTERN8) {
            return BizDate.valueOf("20180213");
        }
        else if (caller == SiSiharaiKingakuKeisanTest_exec.class && SYORIPTN == TESTPATTERN9) {
            return BizDate.valueOf("20180215");
        }
        else if (caller == SiSiharaiKingakuKeisanTest_exec.class && SYORIPTN == TESTPATTERN10) {
            return BizDate.valueOf("20181123");
        }
        if (caller == DwGetHozenKiykGikItijiNnknImplTest_execPostForm.class) {
            if (TESTPATTERN1.equals(SYORIPTN)) {
                return BizDate.valueOf("20160517");
            }
            if (TESTPATTERN2.equals(SYORIPTN)) {
                return BizDate.valueOf("20160418");
            }
            if (TESTPATTERN3.equals(SYORIPTN)) {
                return BizDate.valueOf("20160812");
            }
        }
        if (caller == DwGetHozenKiykGikHijynNnknImplTest_execPostForm.class) {
            if (TESTPATTERN1.equals(SYORIPTN)) {
                return BizDate.valueOf("20190325");
            }

        }
        if (caller == KeisanGaikaPTest_exec.class) {
            return BizDate.valueOf("20180101");
        }

        if (caller == EditKykNaiyouOsiraseTest_getKawaseRateBean.class) {
            if (flag.equals("0")) {
                return BizDate.valueOf("20190102");
            } else if (flag.equals("1")) {
                return BizDate.valueOf("20190103");
            } else if (flag.equals("2")) {
                return BizDate.valueOf("20190104");
            } else if (flag.equals("3")) {
                return BizDate.valueOf("20190105");
            } else if (flag.equals("4")) {
                return BizDate.valueOf("20190106");
            } else if (flag.equals("5")) {
                return BizDate.valueOf("20190107");
            } else if (flag.equals("6")) {
                return BizDate.valueOf("20190108");
            } else if (flag.equals("7")) {
                return BizDate.valueOf("20190109");
            } else if (flag.equals("8")) {
                return BizDate.valueOf("20190110");
            } else if (flag.equals("9")) {
                return BizDate.valueOf("20190111");
            } else if (flag.equals("10")) {
                return BizDate.valueOf("20190112");
            } else if (flag.equals("11"))  {
                return BizDate.valueOf("20190113");
            } else if (flag.equals("12")) {
                return BizDate.valueOf("20190114");
            } else if (flag.equals("13"))  {
                return BizDate.valueOf("20190115");
            }
        }
        return super.getKwsrateKjYmd();
    }
}
