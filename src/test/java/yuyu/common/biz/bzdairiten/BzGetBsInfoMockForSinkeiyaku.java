package yuyu.common.biz.bzdairiten;

import yuyu.app.bosyuu.hbsekmos.hbseihowebsekmos.HbSeihoWebSekMosTest_execPostForm;
import yuyu.app.bosyuu.hbsekmos.hbseihowebsekmos.HbSeihoWebSekMosTest_execPostForm2;
import yuyu.app.bosyuu.hbsksyoukai.hbseihowebmossyoukai.HbSeihoWebMosSyoukaiTest_execPostForm;
import yuyu.common.sinkeiyaku.moschk.CheckTblMosDairitenTest_exec;

/**
 * {@link BzGetBsInfo}のモッククラスです。<br />
 */
public class BzGetBsInfoMockForSinkeiyaku extends BzGetBsInfo {

    public static Class<?> caller = null;

    public static String SYORIPTN = null;

    public static final String TESTPATTERN1 = "1";

    public static final String TESTPATTERN2 = "2";

    public static final String TESTPATTERN3 = "3";

    public static final String TESTPATTERN4 = "4";

    public static final String TESTPATTERN5 = "5";

    public static final String TESTPATTERN6 = "6";

    public static final String TESTPATTERN7 = "7";

    @Override
    public BzGetBsInfoBean exec(String pBosyuuCd) {

        if (caller == HbSeihoWebSekMosTest_execPostForm.class) {
            if (TESTPATTERN1.equals(SYORIPTN)) {
                return null;
            }else if (TESTPATTERN2.equals(SYORIPTN)) {
                BzGetBsInfoBean bzGetBsInfoBean = new BzGetBsInfoBean();
                bzGetBsInfoBean.setBosyuuTrkNo("10001");
                bzGetBsInfoBean.setDairiten1Cd("D001");

                return bzGetBsInfoBean;
            }else if (TESTPATTERN3.equals(SYORIPTN)) {
                if (pBosyuuCd.equals("100002")) {
                    return null;
                }

                BzGetBsInfoBean bzGetBsInfoBean = new BzGetBsInfoBean();
                bzGetBsInfoBean.setBosyuuTrkNo("10001");
                bzGetBsInfoBean.setDairiten1Cd("D001");

                return bzGetBsInfoBean;
            }else if (TESTPATTERN4.equals(SYORIPTN)) {
                BzGetBsInfoBean bzGetBsInfoBean = new BzGetBsInfoBean();

                if (pBosyuuCd.equals("100002")) {
                    bzGetBsInfoBean.setBosyuuTrkNo("10002");
                    bzGetBsInfoBean.setDairiten1Cd("D002");

                    return bzGetBsInfoBean;
                }
                bzGetBsInfoBean.setBosyuuTrkNo("10001");
                bzGetBsInfoBean.setDairiten1Cd("D001");

                return bzGetBsInfoBean;
            }else if (TESTPATTERN5.equals(SYORIPTN)) {
                BzGetBsInfoBean bzGetBsInfoBean = new BzGetBsInfoBean();
                bzGetBsInfoBean.setDairiten1Cd("D001");
                bzGetBsInfoBean.setKanjiBosyuuninNm("漢字募集人名");

                return bzGetBsInfoBean;
            }

        }

        if (caller == HbSeihoWebSekMosTest_execPostForm2.class){
            if (TESTPATTERN1.equals(SYORIPTN)) {
                BzGetBsInfoBean bzGetBsInfoBean = new BzGetBsInfoBean();
                bzGetBsInfoBean.setBosyuuCd("010012");
                bzGetBsInfoBean.setKanjiBosyuuninNm("セコレラ　テンコリ");
                bzGetBsInfoBean.setKouinCd("");
                return bzGetBsInfoBean;
            }else if (TESTPATTERN2.equals(SYORIPTN)) {
                BzGetBsInfoBean bzGetBsInfoBean = new BzGetBsInfoBean();
                bzGetBsInfoBean.setBosyuuCd("010012");
                bzGetBsInfoBean.setKanjiBosyuuninNm("セコレラ　テンコリ");
                bzGetBsInfoBean.setKouinCd("");
                bzGetBsInfoBean.setBosyuuTrkNo("1");
                return bzGetBsInfoBean;
            }
        }

        if (caller == HbSeihoWebMosSyoukaiTest_execPostForm.class) {

            if (TESTPATTERN1.equals(SYORIPTN)) {
                BzGetBsInfoBean bzGetBsInfoBean = new BzGetBsInfoBean();
                bzGetBsInfoBean.setDairiten1Cd("D001");
                bzGetBsInfoBean.setKanjiBosyuuninNm("漢字募集人名");

                if ("101004".equals(pBosyuuCd)) {
                    bzGetBsInfoBean.setBosyuuTrkNo(null);
                    bzGetBsInfoBean.setKouinCd("12345671780600000057");
                }
                else {
                    bzGetBsInfoBean.setBosyuuTrkNo("1780600000013");
                    bzGetBsInfoBean.setKouinCd(null);
                }
                return bzGetBsInfoBean;
            }
            else if (TESTPATTERN2.equals(SYORIPTN)) {
                BzGetBsInfoBean bzGetBsInfoBean = new BzGetBsInfoBean();
                bzGetBsInfoBean.setDairiten1Cd("D001");
                bzGetBsInfoBean.setKanjiBosyuuninNm("漢字募集人名５漢字募集人名５漢");
                bzGetBsInfoBean.setBosyuuTrkNo("1780600000013");
                bzGetBsInfoBean.setKouinCd("12345671780600000057");
                return bzGetBsInfoBean;
            }
            else if (TESTPATTERN3.equals(SYORIPTN)) {
                BzGetBsInfoBean bzGetBsInfoBean = null;

                return bzGetBsInfoBean;
            }
            else if (TESTPATTERN4.equals(SYORIPTN)) {
                BzGetBsInfoBean bzGetBsInfoBean = new BzGetBsInfoBean();
                bzGetBsInfoBean.setDairiten1Cd("D001");
                bzGetBsInfoBean.setKanjiBosyuuninNm("漢字募集人名５");
                bzGetBsInfoBean.setBosyuuTrkNo("");
                bzGetBsInfoBean.setKouinCd("0987654321");
                return bzGetBsInfoBean;
            }
            else if (TESTPATTERN5.equals(SYORIPTN)) {
                BzGetBsInfoBean bzGetBsInfoBean = new BzGetBsInfoBean();
                bzGetBsInfoBean.setDairiten1Cd("D001");
                bzGetBsInfoBean.setKanjiBosyuuninNm("漢字募集人名５");
                bzGetBsInfoBean.setBosyuuTrkNo("1234567890");
                bzGetBsInfoBean.setKouinCd("");
                return bzGetBsInfoBean;
            }
            else if (TESTPATTERN6.equals(SYORIPTN)) {
                BzGetBsInfoBean bzGetBsInfoBean = new BzGetBsInfoBean();
                bzGetBsInfoBean.setDairiten1Cd("D001");
                bzGetBsInfoBean.setKanjiBosyuuninNm("漢字募集人名５");
                bzGetBsInfoBean.setBosyuuTrkNo("");
                bzGetBsInfoBean.setKouinCd("");
                return bzGetBsInfoBean;
            }
            else if (TESTPATTERN7.equals(SYORIPTN)) {
                BzGetBsInfoBean bzGetBsInfoBean = new BzGetBsInfoBean();
                bzGetBsInfoBean.setDairiten1Cd("D001");
                bzGetBsInfoBean.setKanjiBosyuuninNm("漢字募集人名５");
                bzGetBsInfoBean.setBosyuuTrkNo("1234567890");
                bzGetBsInfoBean.setKouinCd("0987654321");
                return bzGetBsInfoBean;
            }
        }

        if (caller == CheckTblMosDairitenTest_exec.class) {

            if (TESTPATTERN1.equals(SYORIPTN)) {
                BzGetBsInfoBean bzGetBsInfoBean = new BzGetBsInfoBean();
                bzGetBsInfoBean.setBosyuuCd("010012");
                bzGetBsInfoBean.setDairiten1Cd("D001");
                bzGetBsInfoBean.setKanjiBosyuuninNm("");
                bzGetBsInfoBean.setKouinCd("");
                return bzGetBsInfoBean;
            }
            else if (TESTPATTERN2.equals(SYORIPTN)) {

                return null;
            }
            else if (TESTPATTERN3.equals(SYORIPTN)) {

                BzGetBsInfoBean bzGetBsInfoBean = new BzGetBsInfoBean();
                bzGetBsInfoBean.setBosyuuCd("");
                bzGetBsInfoBean.setKanjiBosyuuninNm("");
                bzGetBsInfoBean.setKouinCd("");
                return bzGetBsInfoBean;
            }
            else if (TESTPATTERN4.equals(SYORIPTN)) {

                BzGetBsInfoBean bzGetBsInfoBean = new BzGetBsInfoBean();
                if (pBosyuuCd.equals("200020")) {
                    bzGetBsInfoBean.setBosyuuCd("010011");
                    bzGetBsInfoBean.setDairiten1Cd("D001");
                    bzGetBsInfoBean.setKanjiBosyuuninNm("");
                    bzGetBsInfoBean.setKouinCd("");

                    return bzGetBsInfoBean;
                }
                bzGetBsInfoBean.setBosyuuCd("010012");
                bzGetBsInfoBean.setDairiten1Cd("D002");
                bzGetBsInfoBean.setKanjiBosyuuninNm("");
                bzGetBsInfoBean.setKouinCd("");
                return bzGetBsInfoBean;

            }
            else if (TESTPATTERN5.equals(SYORIPTN)) {

                BzGetBsInfoBean bzGetBsInfoBean = new BzGetBsInfoBean();
                if (pBosyuuCd.equals("200020")) {
                    bzGetBsInfoBean.setBosyuuCd("");
                    bzGetBsInfoBean.setDairiten1Cd("D001");
                    bzGetBsInfoBean.setKanjiBosyuuninNm("");
                    bzGetBsInfoBean.setKouinCd("");

                    return bzGetBsInfoBean;
                }
                bzGetBsInfoBean.setBosyuuCd("010012");
                bzGetBsInfoBean.setDairiten1Cd("D002");
                bzGetBsInfoBean.setKanjiBosyuuninNm("");
                bzGetBsInfoBean.setKouinCd("");
                return bzGetBsInfoBean;

            }
            else if (TESTPATTERN6.equals(SYORIPTN)) {

                BzGetBsInfoBean bzGetBsInfoBean = new BzGetBsInfoBean();
                if (pBosyuuCd.equals("200020")) {
                    bzGetBsInfoBean.setBosyuuCd("010012");
                    bzGetBsInfoBean.setDairiten1Cd("D001");
                    bzGetBsInfoBean.setKanjiBosyuuninNm("");
                    bzGetBsInfoBean.setKouinCd("");

                    return bzGetBsInfoBean;
                }
                bzGetBsInfoBean.setBosyuuCd("010012");
                bzGetBsInfoBean.setDairiten1Cd("D002");
                bzGetBsInfoBean.setKanjiBosyuuninNm("");
                bzGetBsInfoBean.setKouinCd("");
                return bzGetBsInfoBean;

            }
        }
        return super.exec(pBosyuuCd);
    }
}