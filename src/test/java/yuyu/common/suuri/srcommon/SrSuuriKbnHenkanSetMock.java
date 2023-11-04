package yuyu.common.suuri.srcommon;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_SrKbnHenkanKbn;


/**
 * {@link SrSuuriKbnHenkanSet}のモッククラスです。<br />
 */
public class SrSuuriKbnHenkanSetMock extends SrSuuriKbnHenkanSet {

    public static final String TESTPATTERN1 = "1";

    public static final String TESTPATTERN2 = "2";

    public static final String TESTPATTERN3 = "3";

    public static Class<?> caller = null;

    public static String SYORIPTN = null;

    @Override
    public SrSuuriKbnHenkanBean exec(C_SrKbnHenkanKbn pSrKbnHenkanKbn, String pHenkanMaeKbnVal) {
        SrSuuriKbnHenkanBean srSuuriKbnHenkanBean = SWAKInjector.getInstance(SrSuuriKbnHenkanBean.class);
        if (caller == SrSinkykSeirituKoumokuCommonSetTest_exec.class ) {
            if (TESTPATTERN1.equals(SYORIPTN)) {
                if (C_SrKbnHenkanKbn.DAIRITENGYOUSYU.eq(pSrKbnHenkanKbn)) {
                    srSuuriKbnHenkanBean.setKekkaKbn(C_ErrorKbn.OK);
                    srSuuriKbnHenkanBean.setHenkanAtoKbn("02");
                }
                else if (C_SrKbnHenkanKbn.BOSYU_KEITAI.eq(pSrKbnHenkanKbn)) {
                    srSuuriKbnHenkanBean.setKekkaKbn(C_ErrorKbn.OK);
                    srSuuriKbnHenkanBean.setHenkanAtoKbn("22");
                }
                else if (C_SrKbnHenkanKbn.KEIYAKU_HIHOKEN_DOU.eq(pSrKbnHenkanKbn)) {
                    srSuuriKbnHenkanBean.setKekkaKbn(C_ErrorKbn.OK);
                    srSuuriKbnHenkanBean.setHenkanAtoKbn("1");
                }
                else if (C_SrKbnHenkanKbn.KEIYAKU_KAKUNI_SYU.eq(pSrKbnHenkanKbn)) {
                    srSuuriKbnHenkanBean.setKekkaKbn(C_ErrorKbn.OK);
                    srSuuriKbnHenkanBean.setHenkanAtoKbn("01");
                }
                else if (C_SrKbnHenkanKbn.SHITEI_DAIRININ.eq(pSrKbnHenkanKbn)) {
                    srSuuriKbnHenkanBean.setKekkaKbn(C_ErrorKbn.OK);
                    srSuuriKbnHenkanBean.setHenkanAtoKbn("2");
                }
                else if (C_SrKbnHenkanKbn.MOS_HONNIN_KAKUNIN.eq(pSrKbnHenkanKbn)) {
                    srSuuriKbnHenkanBean.setKekkaKbn(C_ErrorKbn.OK);
                    srSuuriKbnHenkanBean.setHenkanAtoKbn("7");
                }
                else if (C_SrKbnHenkanKbn.SUURI_HAITOU.eq(pSrKbnHenkanKbn)) {
                    srSuuriKbnHenkanBean.setKekkaKbn(C_ErrorKbn.OK);
                    srSuuriKbnHenkanBean.setHenkanAtoKbn("1");
                }
                else if (C_SrKbnHenkanKbn.SUURI_KEIYAKUDATE_TUUKA.eq(pSrKbnHenkanKbn)) {
                    srSuuriKbnHenkanBean.setKekkaKbn(C_ErrorKbn.OK);
                    srSuuriKbnHenkanBean.setHenkanAtoKbn("0");
                }
                else if (C_SrKbnHenkanKbn.SUURI_NYUUSYUKKIN_TUUKA.eq(pSrKbnHenkanKbn)) {
                    srSuuriKbnHenkanBean.setKekkaKbn(C_ErrorKbn.OK);
                    srSuuriKbnHenkanBean.setHenkanAtoKbn("1");
                }
                else if (C_SrKbnHenkanKbn.SUURI_SISUU.eq(pSrKbnHenkanKbn)) {
                    srSuuriKbnHenkanBean.setKekkaKbn(C_ErrorKbn.OK);
                    srSuuriKbnHenkanBean.setHenkanAtoKbn("01");
                }
                else if (C_SrKbnHenkanKbn.HRK_KAISUU.eq(pSrKbnHenkanKbn)) {
                    srSuuriKbnHenkanBean.setKekkaKbn(C_ErrorKbn.OK);
                    srSuuriKbnHenkanBean.setHenkanAtoKbn("0");
                }
                else if (C_SrKbnHenkanKbn.HRK_KEIRO.eq(pSrKbnHenkanKbn)) {
                    srSuuriKbnHenkanBean.setKekkaKbn(C_ErrorKbn.OK);
                    srSuuriKbnHenkanBean.setHenkanAtoKbn("0");
                }
                else if (C_SrKbnHenkanKbn.SUURI_SIBOUHYOU2.eq(pSrKbnHenkanKbn)) {
                    srSuuriKbnHenkanBean.setKekkaKbn(C_ErrorKbn.OK);
                    srSuuriKbnHenkanBean.setHenkanAtoKbn("0");
                }
                else if (C_SrKbnHenkanKbn.SUURI_SIBOUHYOU.eq(pSrKbnHenkanKbn)) {
                    srSuuriKbnHenkanBean.setKekkaKbn(C_ErrorKbn.OK);
                    srSuuriKbnHenkanBean.setHenkanAtoKbn("47");
                }
            }
            else if (TESTPATTERN2.equals(SYORIPTN)) {
                if (C_SrKbnHenkanKbn.DAIRITENGYOUSYU.eq(pSrKbnHenkanKbn)) {
                    srSuuriKbnHenkanBean.setKekkaKbn(C_ErrorKbn.ERROR);
                    srSuuriKbnHenkanBean.setHenkanAtoKbn("02");
                }
                else if (C_SrKbnHenkanKbn.BOSYU_KEITAI.eq(pSrKbnHenkanKbn)) {
                    srSuuriKbnHenkanBean.setKekkaKbn(C_ErrorKbn.ERROR);
                    srSuuriKbnHenkanBean.setHenkanAtoKbn("22");
                }
                else if (C_SrKbnHenkanKbn.KEIYAKU_HIHOKEN_DOU.eq(pSrKbnHenkanKbn)) {
                    srSuuriKbnHenkanBean.setKekkaKbn(C_ErrorKbn.ERROR);
                    srSuuriKbnHenkanBean.setHenkanAtoKbn("1");
                }
                else if (C_SrKbnHenkanKbn.KEIYAKU_KAKUNI_SYU.eq(pSrKbnHenkanKbn)) {
                    srSuuriKbnHenkanBean.setKekkaKbn(C_ErrorKbn.ERROR);
                    srSuuriKbnHenkanBean.setHenkanAtoKbn("01");
                }
                else if (C_SrKbnHenkanKbn.SHITEI_DAIRININ.eq(pSrKbnHenkanKbn)) {
                    srSuuriKbnHenkanBean.setKekkaKbn(C_ErrorKbn.ERROR);
                    srSuuriKbnHenkanBean.setHenkanAtoKbn("2");
                }
                else if (C_SrKbnHenkanKbn.MOS_HONNIN_KAKUNIN.eq(pSrKbnHenkanKbn)) {
                    srSuuriKbnHenkanBean.setKekkaKbn(C_ErrorKbn.ERROR);
                    srSuuriKbnHenkanBean.setHenkanAtoKbn("7");
                }
                else if (C_SrKbnHenkanKbn.SUURI_HAITOU.eq(pSrKbnHenkanKbn)) {
                    srSuuriKbnHenkanBean.setKekkaKbn(C_ErrorKbn.ERROR);
                    srSuuriKbnHenkanBean.setHenkanAtoKbn("1");
                }
                else if (C_SrKbnHenkanKbn.SUURI_KEIYAKUDATE_TUUKA.eq(pSrKbnHenkanKbn)) {
                    srSuuriKbnHenkanBean.setKekkaKbn(C_ErrorKbn.ERROR);
                    srSuuriKbnHenkanBean.setHenkanAtoKbn("0");
                }
                else if (C_SrKbnHenkanKbn.SUURI_NYUUSYUKKIN_TUUKA.eq(pSrKbnHenkanKbn)) {
                    srSuuriKbnHenkanBean.setKekkaKbn(C_ErrorKbn.ERROR);
                    srSuuriKbnHenkanBean.setHenkanAtoKbn("1");
                }
                else if (C_SrKbnHenkanKbn.SUURI_SISUU.eq(pSrKbnHenkanKbn)) {
                    srSuuriKbnHenkanBean.setKekkaKbn(C_ErrorKbn.ERROR);
                    srSuuriKbnHenkanBean.setHenkanAtoKbn("01");
                }
                else if (C_SrKbnHenkanKbn.HRK_KAISUU.eq(pSrKbnHenkanKbn)) {
                    srSuuriKbnHenkanBean.setKekkaKbn(C_ErrorKbn.ERROR);
                    srSuuriKbnHenkanBean.setHenkanAtoKbn("1");
                }
                else if (C_SrKbnHenkanKbn.HRK_KEIRO.eq(pSrKbnHenkanKbn)) {
                    srSuuriKbnHenkanBean.setKekkaKbn(C_ErrorKbn.ERROR);
                    srSuuriKbnHenkanBean.setHenkanAtoKbn("1");
                }
                else if (C_SrKbnHenkanKbn.SUURI_SIBOUHYOU2.eq(pSrKbnHenkanKbn)) {
                    srSuuriKbnHenkanBean.setKekkaKbn(C_ErrorKbn.ERROR);
                    srSuuriKbnHenkanBean.setHenkanAtoKbn("1");
                }
                else if (C_SrKbnHenkanKbn.SUURI_SIBOUHYOU.eq(pSrKbnHenkanKbn)) {
                    srSuuriKbnHenkanBean.setKekkaKbn(C_ErrorKbn.ERROR);
                    srSuuriKbnHenkanBean.setHenkanAtoKbn("2");
                }

            }

            return srSuuriKbnHenkanBean;

        }

        return super.exec(pSrKbnHenkanKbn, pHenkanMaeKbnVal);

    }

}