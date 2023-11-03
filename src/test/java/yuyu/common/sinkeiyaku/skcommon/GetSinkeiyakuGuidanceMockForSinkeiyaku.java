package yuyu.common.sinkeiyaku.skcommon;

import java.util.ArrayList;
import java.util.List;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import yuyu.app.bosyuu.hbsekmos.hbseihowebsekmos.HbSeihoWebSekMosTest_execPostForm;
import yuyu.common.sinkeiyaku.moschk.MosnaiCheckParam;

/**
 * {@link GetSinkeiyakuGuidance}のモッククラスです。<br />
 */
public class GetSinkeiyakuGuidanceMockForSinkeiyaku extends GetSinkeiyakuGuidance {

    public static final String TESTPATTERN1 = "1";

    public static final String TESTPATTERN2 = "2";

    public static final String TESTPATTERN3 = "3";

    public static Class<?> caller = null;

    public static String SYORIPTN = null;

    @Override
    public GetSinkeiyakuGuidanceOutBean exec(MosnaiCheckParam pMP) {

        if (caller == HbSeihoWebSekMosTest_execPostForm.class) {

            if (TESTPATTERN1.equals(SYORIPTN)) {

                GetSinkeiyakuGuidanceOutBean sinkeiyakuGuidanceBean = SWAKInjector
                    .getInstance(GetSinkeiyakuGuidanceOutBean.class);


                List<String> guidansuMessageList = new ArrayList<>();

                guidansuMessageList.add("1001");
                guidansuMessageList.add("1002");
                guidansuMessageList.add("1003");
                guidansuMessageList.add("1004");
                guidansuMessageList.add("1005");
                guidansuMessageList.add("1006");
                guidansuMessageList.add("1007");
                guidansuMessageList.add("1008");
                guidansuMessageList.add("1009");
                guidansuMessageList.add("1010");

                guidansuMessageList.add("1011");
                guidansuMessageList.add("1012");
                guidansuMessageList.add("1013");
                guidansuMessageList.add("1014");
                guidansuMessageList.add("1015");
                guidansuMessageList.add("1016");
                guidansuMessageList.add("1017");
                guidansuMessageList.add("1018");
                guidansuMessageList.add("1019");
                guidansuMessageList.add("1020");

                guidansuMessageList.add("1021");
                guidansuMessageList.add("1022");
                guidansuMessageList.add("1023");
                guidansuMessageList.add("1024");
                guidansuMessageList.add("1025");
                guidansuMessageList.add("1026");
                guidansuMessageList.add("1027");
                guidansuMessageList.add("1028");
                guidansuMessageList.add("1029");
                guidansuMessageList.add("1030");

                guidansuMessageList.add("1031");
                guidansuMessageList.add("1032");
                guidansuMessageList.add("1033");
                guidansuMessageList.add("1034");
                guidansuMessageList.add("1035");
                guidansuMessageList.add("1036");
                guidansuMessageList.add("1037");
                guidansuMessageList.add("1038");
                guidansuMessageList.add("1039");
                guidansuMessageList.add("1040");

                guidansuMessageList.add("1041");
                guidansuMessageList.add("1042");
                guidansuMessageList.add("1043");
                guidansuMessageList.add("1044");
                guidansuMessageList.add("1045");
                guidansuMessageList.add("1046");
                guidansuMessageList.add("1047");
                guidansuMessageList.add("1048");
                guidansuMessageList.add("1049");
                guidansuMessageList.add("1050");

                guidansuMessageList.add("1051");
                guidansuMessageList.add("1052");
                guidansuMessageList.add("1053");
                guidansuMessageList.add("1054");
                guidansuMessageList.add("1055");
                guidansuMessageList.add("1056");
                guidansuMessageList.add("1057");
                guidansuMessageList.add("1058");
                guidansuMessageList.add("1059");
                guidansuMessageList.add("1060");


                sinkeiyakuGuidanceBean.setGuidansuMessageList(guidansuMessageList);

                return sinkeiyakuGuidanceBean;
            }else if (TESTPATTERN2.equals(SYORIPTN)) {
                GetSinkeiyakuGuidanceOutBean sinkeiyakuGuidanceBean = SWAKInjector
                    .getInstance(GetSinkeiyakuGuidanceOutBean.class);


                List<String> guidansuMessageList = new ArrayList<>();


                sinkeiyakuGuidanceBean.setGuidansuMessageList(guidansuMessageList);

                return sinkeiyakuGuidanceBean;
            }else if (TESTPATTERN3.equals(SYORIPTN)) {
                GetSinkeiyakuGuidanceOutBean sinkeiyakuGuidanceBean = SWAKInjector
                    .getInstance(GetSinkeiyakuGuidanceOutBean.class);


                List<String> guidansuMessageList = new ArrayList<>();


                sinkeiyakuGuidanceBean.setGuidansuMessageList(guidansuMessageList);
                sinkeiyakuGuidanceBean.setKnsnkanouhyj("1");
                sinkeiyakuGuidanceBean.setNngndkkkanouhyj("2");
                sinkeiyakuGuidanceBean.setMnstskanouhyj("3");
                sinkeiyakuGuidanceBean.setSyktkikanouhyj("4");
                sinkeiyakuGuidanceBean.setSyaikanouhyj("5");
                sinkeiyakuGuidanceBean.setSndnzknsyouhyj("6");
                sinkeiyakuGuidanceBean.setKtekknsyouhyj("7");
                sinkeiyakuGuidanceBean.setKnsnsysndnzyou("8");
                sinkeiyakuGuidanceBean.setKnsnktekknsyou("9");

                return sinkeiyakuGuidanceBean;
            }
        }

        return super.exec(pMP);
    }


}