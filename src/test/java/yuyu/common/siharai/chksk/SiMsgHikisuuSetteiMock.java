package yuyu.common.siharai.chksk;

import java.util.ArrayList;
import java.util.List;

import yuyu.def.classification.C_SKNaiyouChkKbn;
import yuyu.def.db.entity.JM_SkNaiyouChk;

/**
 * {@link SiMsgHikisuuSettei}のモッククラスです。<br />
 */
public class SiMsgHikisuuSetteiMock extends SiMsgHikisuuSettei{

    public static final String TESTPATTERN1 = "1";

    public static final String TESTPATTERN2 = "2";

    public static Class<?> caller = null;

    public static String SYORIPTN = null;

    public static String mode = null;

    @Override
    public List<String> exec(JM_SkNaiyouChk pSkNaiyouChk, String pMsgHikisuu1, String pMsgHikisuu2,
        String pMsgHikisuu3, String pMsgHikisuu4, String pMsgHikisuu5) {

        List<String> msgList = new ArrayList<>();
        if (caller == SiSKNaiyouChkkekkaSetteiTest_exec.class && TESTPATTERN1.equals(SYORIPTN)) {

            super.exec(pSkNaiyouChk, pMsgHikisuu1, pMsgHikisuu2, pMsgHikisuu3, pMsgHikisuu4, pMsgHikisuu5);
            msgList.add("222222");
            msgList.add("333333");
            msgList.add("444444");
            msgList.add("555555");
            msgList.add("666666");
            return msgList;
        }
        if (caller == SiSateiKmkChkkekkaSetteiTest_exec.class && !C_SKNaiyouChkKbn.SEIYMD_MINYUCHK.eq(pSkNaiyouChk.getSknaiyouchkkbn()) ) {

            super.exec(pSkNaiyouChk, pMsgHikisuu1, pMsgHikisuu2, pMsgHikisuu3, pMsgHikisuu4, pMsgHikisuu5);

            msgList.add("111111");
            msgList.add("222222");
            msgList.add("333333");
            msgList.add("444444");
            msgList.add("555555");
            return msgList;
        }
        if (caller == SiSateiKmkChkkekkaSetteiTest_exec.class && C_SKNaiyouChkKbn.SEIYMD_MINYUCHK.eq(pSkNaiyouChk.getSknaiyouchkkbn()) ) {

            super.exec(pSkNaiyouChk, pMsgHikisuu1, pMsgHikisuu2, pMsgHikisuu3, pMsgHikisuu4, pMsgHikisuu5);

            msgList.add("666666");
            msgList.add("777777");
            msgList.add("888888");
            msgList.add("999999");
            msgList.add("100000");
            return msgList;
        }
        return super.exec(pSkNaiyouChk, pMsgHikisuu1, pMsgHikisuu2, pMsgHikisuu3, pMsgHikisuu4, pMsgHikisuu5);
    }


}
