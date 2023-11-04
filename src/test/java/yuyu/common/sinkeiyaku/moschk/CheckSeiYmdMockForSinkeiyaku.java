package yuyu.common.sinkeiyaku.moschk;

import java.util.List;

import jp.co.slcs.swak.date.BizDate;
import yuyu.common.biz.bzcommon.ICommonKoumoku;
import yuyu.def.classification.C_HubisyubetuKbn;
import yuyu.def.classification.C_KouzokujkKbn;
import yuyu.def.db.entity.HT_HubiMsg;

/**
 * 生年月日範囲チェック{@link CheckSeiYmd}のモッククラスです。<br />
 */
public class CheckSeiYmdMockForSinkeiyaku extends CheckSeiYmd {

    public static final String TESTPATTERN1 = "1";

    public static final String TESTPATTERN2 = "2";

    public static final String TESTPATTERN3 = "3";

    public static Class<?> caller = null;

    public static String SYORIPTN = null;

    @Override
    public void exec(MosnaiCheckParam pMP, BizDate pSeiYmd, String pHubiMsg) {

        if (caller == CheckTblMosKihonTest_exec1.class) {
            if (TESTPATTERN1.equals(SYORIPTN)) {
                return;
            }
            else if (TESTPATTERN2.equals(SYORIPTN)) {
                if (ICommonKoumoku.DISP_S_HHKNSEIYMD.equals(pHubiMsg)) {
                    pMP.setKouzokuSyoriJikkouKbn(C_KouzokujkKbn.NONE);
                }
                return;
            }
            else if (TESTPATTERN3.equals(SYORIPTN)) {
                if (ICommonKoumoku.DISP_S_KYKSEIYMD.equals(pHubiMsg)) {
                    pMP.setKouzokuSyoriJikkouKbn(C_KouzokujkKbn.NONE);
                }
                return;
            }
        }
        if (caller == CheckTblMosKihonTest_exec2.class) {
            if (TESTPATTERN1.equals(SYORIPTN)) {
                return;
            }
            else if (TESTPATTERN2.equals(SYORIPTN)) {
                if (ICommonKoumoku.DISP_S_HHKNSEIYMD.equals(pHubiMsg)) {
                    pMP.setKouzokuSyoriJikkouKbn(C_KouzokujkKbn.NONE);
                }
                return;
            }
            else if (TESTPATTERN3.equals(SYORIPTN)) {
                if (ICommonKoumoku.DISP_S_KYKSEIYMD.equals(pHubiMsg)) {
                    pMP.setKouzokuSyoriJikkouKbn(C_KouzokujkKbn.NONE);
                }
                return;
            }
        }

        if (caller == CheckTblUketorininTest_exec.class) {
            if (TESTPATTERN1.equals(SYORIPTN)) {
                return;
            }
            if (TESTPATTERN2.equals(SYORIPTN)) {
                if (pSeiYmd.compareTo(BizDate.valueOf("20160304")) == 0) {

                    List<HT_HubiMsg> hubiMsgList = pMP.getListHubiMsg();
                    HT_HubiMsg hubiMsg = new HT_HubiMsg();
                    hubiMsg.setMosno("981112246");
                    hubiMsg.setMessageId("EBC0046");
                    hubiMsg.setHubimsg("死亡受取人生年月日が正しくありません。");
                    hubiMsg.setHubisyubetukbn(C_HubisyubetuKbn.KETHORYU_HUBI);
                    hubiMsgList.add(hubiMsg);
                    pMP.setListHubiMsg(hubiMsgList);
                    return;

                } else {
                    return;
                }
            }
        }

        super.exec(pMP,pSeiYmd,pHubiMsg);
    }
}