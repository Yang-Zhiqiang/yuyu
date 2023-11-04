package yuyu.common.sinkeiyaku.moschk;

import java.util.List;

import yuyu.def.classification.C_HubisyubetuKbn;
import yuyu.def.db.entity.HT_HubiMsg;
import yuyu.def.db.entity.HT_Uketorinin;

/**
 * {@link CheckUktBnWari}のモッククラスです。<br />
 */

public class CheckUktBnWariMockForSinkeiyaku extends CheckUktBnWari{

    public static final String TESTPATTERN1 = "1";

    public static final String TESTPATTERN2 = "2";

    public static Class<?> caller = null;

    public static String SYORIPTN = null;

    @Override
    public void exec(MosnaiCheckParam pMP, List<HT_Uketorinin> pUketorininLst) {

        if (caller == CheckTblUketorininTest_exec.class && TESTPATTERN1.equals(SYORIPTN)) {

            List<HT_HubiMsg> hubiMsgList = pMP.getListHubiMsg();
            HT_HubiMsg hubiMsg = new HT_HubiMsg();
            hubiMsg.setMosno("981112246");
            hubiMsg.setRenno(2);
            hubiMsg.setHubimsg("死亡受取人の分割割合が正しくありません。");
            hubiMsg.setHubisyubetukbn(C_HubisyubetuKbn.SRHORYU_HUBI);
            hubiMsgList.add(hubiMsg);
            pMP.setListHubiMsg(hubiMsgList);
            return;
        }
        else if (caller == CheckTblUketorininTest_exec.class && TESTPATTERN2.equals(SYORIPTN)) {

            return;
        }
        else {
            super.exec(pMP,pUketorininLst);
        }
    }

}
