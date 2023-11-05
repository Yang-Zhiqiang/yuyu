package yuyu.common.biz.bzdairiten;

import java.util.ArrayList;
import java.util.List;

import jp.co.slcs.swak.date.BizDateYM;
import yuyu.common.sinkeiyaku.moschk.CheckTblMosDairitenTest_exec;
import yuyu.def.classification.C_DiritenplannmKbn;
import yuyu.def.classification.C_DrtSyouhinSikibetuKbn;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.db.entity.BT_BuntanInfo;

/**
 * 業務共通 代理店 分担情報取得のモッククラスです。<br />
 */
public class BzGetBuntanInfoMock extends BzGetBuntanInfo {

    public static Class<?> caller = null;

    public static String SYORIPTN = null;

    public static final String TESTPATTERN1 = "1";

    public static final String TESTPATTERN2 = "2";

    public static final String TESTPATTERN3 = "3";

    public static final String TESTPATTERN4 = "4";

    private C_ErrorKbn errorKbn;

    @Override
    public C_ErrorKbn getErrorKbn() {
        return errorKbn;
    }

    @Override
    public void exec(String pDrtenCd, String pTesuuryouBuntanDrtenCd, BizDateYM pKijyunYm,
        C_DrtSyouhinSikibetuKbn pDrtSyouhinSikibetuKbn, C_Hrkkaisuu pHrkkaisuu, C_DiritenplannmKbn pDiritenplannmKbn) {

        if (caller == CheckTblMosDairitenTest_exec.class) {
            if (TESTPATTERN1.equals(SYORIPTN)) {

                errorKbn = C_ErrorKbn.OK;
            }
            else if (TESTPATTERN2.equals(SYORIPTN)) {
                if (pDrtenCd == "") {
                    errorKbn = C_ErrorKbn.ERROR;
                }
                else {
                    errorKbn = C_ErrorKbn.OK;
                }
            }
            else if (TESTPATTERN3.equals(SYORIPTN)) {

                errorKbn = C_ErrorKbn.ERROR;
            }
        }
        else {

            super.exec(pDrtenCd, pTesuuryouBuntanDrtenCd, pKijyunYm, pDrtSyouhinSikibetuKbn, pHrkkaisuu,
                pDiritenplannmKbn);
        }
    }

    @Override
    public List<BT_BuntanInfo> execBuntanaiteSiteinasi(String pDrtenCd, BizDateYM pKijyunYm,
        C_DrtSyouhinSikibetuKbn pDrtSyouhinSikibetuKbn, C_Hrkkaisuu pHrkkaisuu, C_DiritenplannmKbn pDiritenplannmKbn) {

        if (caller == CheckTblMosDairitenTest_exec.class && TESTPATTERN1.equals(SYORIPTN)) {

            List<BT_BuntanInfo> buntanInfoLst = new ArrayList<BT_BuntanInfo>();

            return buntanInfoLst;
        }

        if (caller == CheckTblMosDairitenTest_exec.class && TESTPATTERN2.equals(SYORIPTN)) {

            List<BT_BuntanInfo> buntanInfoLst = new ArrayList<BT_BuntanInfo>();

            BT_BuntanInfo buntanInfo = new BT_BuntanInfo();

            if ("".equals(pDrtenCd)) {

                buntanInfo.setDrtencd("");
                buntanInfo.setDairitensyouhincd("");
                buntanInfo.setTesuuryoubuntandrtencd("9001718");
                buntanInfo.setTesuuryoubuntanstartym(BizDateYM.valueOf("201801"));

                buntanInfoLst.add(buntanInfo);
            }
            else if ("9001718".equals(pDrtenCd)) {

                buntanInfo.setDrtencd("");
                buntanInfo.setDairitensyouhincd("");
                buntanInfo.setTesuuryoubuntandrtencd("9001717");
                buntanInfo.setTesuuryoubuntanstartym(BizDateYM.valueOf("201801"));

                buntanInfoLst.add(buntanInfo);
            }

            return buntanInfoLst;

        }

        if (caller == CheckTblMosDairitenTest_exec.class && TESTPATTERN3.equals(SYORIPTN)) {

            List<BT_BuntanInfo> buntanInfoLst = new ArrayList<BT_BuntanInfo>();

            if ("".equals(pDrtenCd)) {

                BT_BuntanInfo buntanInfo1 = new BT_BuntanInfo();

                buntanInfo1.setDrtencd("");
                buntanInfo1.setDairitensyouhincd("");
                buntanInfo1.setTesuuryoubuntandrtencd("9001717");
                buntanInfo1.setTesuuryoubuntanstartym(BizDateYM.valueOf("201801"));
                buntanInfoLst.add(buntanInfo1);

            } else if ("9001717".equals(pDrtenCd)) {

                BT_BuntanInfo buntanInfo2 = new BT_BuntanInfo();

                buntanInfo2.setDrtencd("");
                buntanInfo2.setDairitensyouhincd("");
                buntanInfo2.setTesuuryoubuntandrtencd("9001717");
                buntanInfo2.setTesuuryoubuntanstartym(BizDateYM.valueOf("201801"));

                BT_BuntanInfo buntanInfo3 = new BT_BuntanInfo();

                buntanInfo3.setDrtencd("");
                buntanInfo3.setDairitensyouhincd("");
                buntanInfo3.setTesuuryoubuntandrtencd("9001717");
                buntanInfo3.setTesuuryoubuntanstartym(BizDateYM.valueOf("201801"));

                buntanInfoLst.add(buntanInfo2);

                buntanInfoLst.add(buntanInfo3);
            }
            return buntanInfoLst;
        }

        if (caller == CheckTblMosDairitenTest_exec.class && TESTPATTERN4.equals(SYORIPTN)) {

            List<BT_BuntanInfo> buntanInfoLst = new ArrayList<BT_BuntanInfo>();

            BT_BuntanInfo buntanInfo = new BT_BuntanInfo();

            buntanInfo.setDrtencd("");
            buntanInfo.setDairitensyouhincd("");
            buntanInfo.setTesuuryoubuntandrtencd("9001717");
            buntanInfo.setTesuuryoubuntanstartym(BizDateYM.valueOf("201801"));

            buntanInfoLst.add(buntanInfo);

            return buntanInfoLst;

        }

        return super.execBuntanaiteSiteinasi(pDrtenCd, pKijyunYm, pDrtSyouhinSikibetuKbn, pHrkkaisuu, pDiritenplannmKbn);
    }
}