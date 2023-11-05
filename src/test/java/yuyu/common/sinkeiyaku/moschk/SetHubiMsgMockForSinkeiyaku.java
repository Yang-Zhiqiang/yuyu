package yuyu.common.sinkeiyaku.moschk;

import java.util.List;

import jp.co.slcs.swak.number.BizCurrency;
import yuyu.def.classification.C_HubisyubetuKbn;
import yuyu.def.classification.C_HubisyubetusyousaiKbn;
import yuyu.def.classification.C_KetsrhkosKbn;
import yuyu.def.classification.C_KouzokujkKbn;
import yuyu.def.classification.C_MsgKbn;
import yuyu.def.classification.C_SekmossakuseiErroutKbn;
import yuyu.def.classification.C_SpKeisanKahiKbn;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.classification.C_TknKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.db.entity.HT_HubiMsg;

/**
 * {@link SetHubiMsg}のモッククラスです。<br />
 */
public class SetHubiMsgMockForSinkeiyaku extends SetHubiMsg {

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

    public static final String TESTPATTERN11 = "11";

    public static final String TESTPATTERN12 = "12";

    public static final String TESTPATTERN13 = "13";

    public static final String TESTPATTERN14 = "14";

    public static final String TESTPATTERN15 = "15";

    public static final String TESTPATTERN16 = "16";

    public static final String TESTPATTERN17 = "17";

    public static final String TESTPATTERN18 = "18";

    public static final String TESTPATTERN19 = "19";

    public static final String TESTPATTERN20 = "20";

    public static final String TESTPATTERN21 = "21";

    public static final String TESTPATTERN22 = "22";

    public static Class<?> caller = null;

    public static String SYORIPTN = null;


    @Override
    public void exec(C_KetsrhkosKbn pKetsrhkosKbn,
        C_SpKeisanKahiKbn pSpKeisanKahiKbn,
        C_HubisyubetusyousaiKbn pHubisyubetusyousaiKbn,
        String pMessage,
        MosnaiCheckParam pMp,
        C_TknKbn pTknKbn,
        C_MsgKbn pMsgKbn) {

        if(caller == SetKisoKoumokuTest_exec.class){

            if (TESTPATTERN1.equals(SYORIPTN)) {
                List<HT_HubiMsg> hubiMsgList = pMp.getListHubiMsg();
                HT_HubiMsg hubiMsg = new HT_HubiMsg();
                hubiMsg.setMosno("791112238");
                hubiMsg.setRenno(1);
                hubiMsg.setMessageId("EHF0011");
                hubiMsg.setHubimsg("締切日情報該当データ無し　募集年月＝Ｈ２８．０１");
                hubiMsg.setHubisyubetukbn(C_HubisyubetuKbn.KETHORYU_HUBI);
                hubiMsg.setHubisyubetusyousaikbn(C_HubisyubetusyousaiKbn.NONE);
                hubiMsg.setGyoumuKousinsyaId("user001");
                hubiMsg.setGyoumuKousinTime("20150624142000000");
                hubiMsgList.add(hubiMsg);
                pMp.setListHubiMsg(hubiMsgList);
                return;
            }
        }
        else if (caller == NayoseTest_exec.class) {
            if (TESTPATTERN3.equals(SYORIPTN)) {

                List<HT_HubiMsg> hubiMsgList = pMp.getListHubiMsg();
                if(hubiMsgList.size() == 0){
                    HT_HubiMsg hubiMsg1 = new HT_HubiMsg();
                    hubiMsg1.setMosno("791112279");
                    hubiMsg1.setRenno(1);
                    hubiMsg1.setMessageId("EHC1020");
                    hubiMsg1.setHubimsg("被保険者が名寄せ不明です。ＰＡＬの照会機能にて確認を行なってください。");
                    hubiMsg1.setHubisyubetukbn(C_HubisyubetuKbn.SRHORYU_HUBI);
                    hubiMsg1.setHubisyubetusyousaikbn(C_HubisyubetusyousaiKbn.NONE);
                    hubiMsg1.setGyoumuKousinsyaId("user001");
                    hubiMsg1.setGyoumuKousinTime("20150604162000000");
                    hubiMsgList.add(hubiMsg1);
                }
                else if(hubiMsgList.size() == 1){
                    HT_HubiMsg hubiMsg2 = new HT_HubiMsg();
                    hubiMsg2.setMosno("791112279");
                    hubiMsg2.setRenno(2);
                    hubiMsg2.setMessageId("EHC1020");
                    hubiMsg2.setHubimsg("契約者が名寄せ不明です。ＰＡＬの照会機能にて確認を行なってください。");
                    hubiMsg2.setHubisyubetukbn(C_HubisyubetuKbn.SRHORYU_HUBI);
                    hubiMsg2.setHubisyubetusyousaikbn(C_HubisyubetusyousaiKbn.NONE);
                    hubiMsg2.setGyoumuKousinsyaId("user001");
                    hubiMsg2.setGyoumuKousinTime("20150604162000000");
                    hubiMsgList.add(hubiMsg2);
                }
                else if(hubiMsgList.size() == 2){
                    HT_HubiMsg hubiMsg3 = new HT_HubiMsg();
                    hubiMsg3.setMosno("791112279");
                    hubiMsg3.setRenno(3);
                    hubiMsg3.setMessageId("EHC1018");
                    hubiMsg3.setHubimsg("被保険者生年月日が索引結果と一致しません。入力内容に誤りがないかご確認ください。");
                    hubiMsg3.setHubisyubetukbn(C_HubisyubetuKbn.KETHORYU_HUBI);
                    hubiMsg3.setHubisyubetusyousaikbn(C_HubisyubetusyousaiKbn.NONE);
                    hubiMsg3.setGyoumuKousinsyaId("user001");
                    hubiMsg3.setGyoumuKousinTime("20150604162000000");
                    hubiMsgList.add(hubiMsg3);
                }
                else if(hubiMsgList.size() == 3){
                    HT_HubiMsg hubiMsg4 = new HT_HubiMsg();
                    hubiMsg4.setMosno("791112279");
                    hubiMsg4.setRenno(4);
                    hubiMsg4.setMessageId("EHC1018");
                    hubiMsg4.setHubimsg("契約者生年月日が索引結果と一致しません。入力内容に誤りがないかご確認ください。");
                    hubiMsg4.setHubisyubetukbn(C_HubisyubetuKbn.KETHORYU_HUBI);
                    hubiMsg4.setHubisyubetusyousaikbn(C_HubisyubetusyousaiKbn.NONE);
                    hubiMsg4.setGyoumuKousinsyaId("user001");
                    hubiMsg4.setGyoumuKousinTime("20150604162000000");
                    hubiMsgList.add(hubiMsg4);
                    pMp.setListHubiMsg(hubiMsgList);
                }
                return;
            }
            else if (TESTPATTERN4.equals(SYORIPTN)) {

                List<HT_HubiMsg> hubiMsgList = pMp.getListHubiMsg();
                if(hubiMsgList.size() == 0){
                    HT_HubiMsg hubiMsg1 = new HT_HubiMsg();
                    hubiMsg1.setMosno("791112287");
                    hubiMsg1.setRenno(1);
                    hubiMsg1.setMessageId("EHC1019");
                    hubiMsg1.setHubimsg("別契約が確認できません。ＰＡＬの索引照会で確認してください。（ＰＡＬあて照会実施なし）");
                    hubiMsg1.setHubisyubetukbn(C_HubisyubetuKbn.SRHORYU_HUBI);
                    hubiMsg1.setHubisyubetusyousaikbn(C_HubisyubetusyousaiKbn.NONE);
                    hubiMsg1.setGyoumuKousinsyaId("user001");
                    hubiMsg1.setGyoumuKousinTime("20150604162000000");
                    hubiMsgList.add(hubiMsg1);
                }
                else if(hubiMsgList.size() == 1){
                    HT_HubiMsg hubiMsg2 = new HT_HubiMsg();
                    hubiMsg2.setMosno("791112287");
                    hubiMsg2.setRenno(2);
                    hubiMsg2.setMessageId("EHC1018");
                    hubiMsg2.setHubimsg("契約者生年月日が索引結果と一致しません。入力内容に誤りがないかご確認ください。");
                    hubiMsg2.setHubisyubetukbn(C_HubisyubetuKbn.KETHORYU_HUBI);
                    hubiMsg2.setHubisyubetusyousaikbn(C_HubisyubetusyousaiKbn.NONE);
                    hubiMsg2.setGyoumuKousinsyaId("user001");
                    hubiMsg2.setGyoumuKousinTime("20150604162000000");
                    hubiMsgList.add(hubiMsg2);
                }
                pMp.setListHubiMsg(hubiMsgList);
                return;

            }
            else if (TESTPATTERN5.equals(SYORIPTN)) {

                List<HT_HubiMsg> hubiMsgList = pMp.getListHubiMsg();
                if(hubiMsgList.size() == 0){
                    HT_HubiMsg hubiMsg1 = new HT_HubiMsg();
                    hubiMsg1.setMosno("791112295");
                    hubiMsg1.setRenno(1);
                    hubiMsg1.setMessageId("EHC1016");
                    hubiMsg1.setHubimsg("別契約が確認できません。ＰＡＬの索引照会で確認してください。（ＭＱ処理結果エラー）");
                    hubiMsg1.setHubisyubetukbn(C_HubisyubetuKbn.SRHORYU_HUBI);
                    hubiMsg1.setHubisyubetusyousaikbn(C_HubisyubetusyousaiKbn.NONE);
                    hubiMsg1.setGyoumuKousinsyaId("user001");
                    hubiMsg1.setGyoumuKousinTime("20150604162000000");
                    hubiMsgList.add(hubiMsg1);
                }
                else if(hubiMsgList.size() == 1){
                    HT_HubiMsg hubiMsg2 = new HT_HubiMsg();
                    hubiMsg2.setMosno("791112295");
                    hubiMsg2.setRenno(2);
                    hubiMsg2.setMessageId("EHC1018");
                    hubiMsg2.setHubimsg("被保険者生年月日が索引結果と一致しません。入力内容に誤りがないかご確認ください。");
                    hubiMsg2.setHubisyubetukbn(C_HubisyubetuKbn.KETHORYU_HUBI);
                    hubiMsg2.setHubisyubetusyousaikbn(C_HubisyubetusyousaiKbn.NONE);
                    hubiMsg2.setGyoumuKousinsyaId("user001");
                    hubiMsg2.setGyoumuKousinTime("20150604162000000");
                    hubiMsgList.add(hubiMsg2);
                }

                pMp.setListHubiMsg(hubiMsgList);
                return;

            }
            else if (TESTPATTERN7.equals(SYORIPTN)) {

                List<HT_HubiMsg> hubiMsgList = pMp.getListHubiMsg();

                HT_HubiMsg hubiMsg1 = new HT_HubiMsg();
                hubiMsg1.setMosno("791112311");
                hubiMsg1.setRenno(1);
                hubiMsg1.setMessageId("EHC1018");
                hubiMsg1.setHubimsg("被保険者生年月日が索引結果と一致しません。入力内容に誤りがないかご確認ください。");
                hubiMsg1.setHubisyubetukbn(C_HubisyubetuKbn.KETHORYU_HUBI);
                hubiMsg1.setHubisyubetusyousaikbn(C_HubisyubetusyousaiKbn.NONE);
                hubiMsg1.setGyoumuKousinsyaId("user001");
                hubiMsg1.setGyoumuKousinTime("20150604162000000");
                hubiMsgList.add(hubiMsg1);

                pMp.setListHubiMsg(hubiMsgList);
                return;

            }
            else if (TESTPATTERN8.equals(SYORIPTN)) {

                List<HT_HubiMsg> hubiMsgList = pMp.getListHubiMsg();
                if(hubiMsgList.size() == 0){
                    HT_HubiMsg hubiMsg1 = new HT_HubiMsg();
                    hubiMsg1.setMosno("791112329");
                    hubiMsg1.setRenno(1);
                    hubiMsg1.setMessageId("EHC1016");
                    hubiMsg1.setHubimsg("別契約が確認できません。ＰＡＬの索引照会で確認してください。（ＭＱ処理結果エラー）");
                    hubiMsg1.setHubisyubetukbn(C_HubisyubetuKbn.SRHORYU_HUBI);
                    hubiMsg1.setHubisyubetusyousaikbn(C_HubisyubetusyousaiKbn.NONE);
                    hubiMsg1.setGyoumuKousinsyaId("user001");
                    hubiMsg1.setGyoumuKousinTime("20150604162000000");
                    hubiMsgList.add(hubiMsg1);
                }
                else if(hubiMsgList.size() == 1){
                    HT_HubiMsg hubiMsg2 = new HT_HubiMsg();
                    hubiMsg2.setMosno("791112329");
                    hubiMsg2.setRenno(2);
                    hubiMsg2.setMessageId("EHC1018");
                    hubiMsg2.setHubimsg("契約者生年月日が索引結果と一致しません。入力内容に誤りがないかご確認ください。");
                    hubiMsg2.setHubisyubetukbn(C_HubisyubetuKbn.KETHORYU_HUBI);
                    hubiMsg2.setHubisyubetusyousaikbn(C_HubisyubetusyousaiKbn.NONE);
                    hubiMsg2.setGyoumuKousinsyaId("user001");
                    hubiMsg2.setGyoumuKousinTime("20150604162000000");
                    hubiMsgList.add(hubiMsg2);
                }

                pMp.setListHubiMsg(hubiMsgList);
                return;

            }
            else if (TESTPATTERN9.equals(SYORIPTN)) {

                List<HT_HubiMsg> hubiMsgList = pMp.getListHubiMsg();
                HT_HubiMsg hubiMsg1 = new HT_HubiMsg();
                hubiMsg1.setMosno("791112345");
                hubiMsg1.setRenno(1);
                hubiMsg1.setMessageId("EHC1018");
                hubiMsg1.setHubimsg("被保険者生年月日が索引結果と一致しません。入力内容に誤りがないかご確認ください。");
                hubiMsg1.setHubisyubetukbn(C_HubisyubetuKbn.KETHORYU_HUBI);
                hubiMsg1.setHubisyubetusyousaikbn(C_HubisyubetusyousaiKbn.NONE);
                hubiMsg1.setGyoumuKousinsyaId("user001");
                hubiMsg1.setGyoumuKousinTime("20150604162000000");
                hubiMsgList.add(hubiMsg1);

                pMp.setListHubiMsg(hubiMsgList);
                return;

            }
            else if (TESTPATTERN10.equals(SYORIPTN)) {
                return;
            }
        }


        else if (caller == CheckHokenRyouYuukouKigenTest_exec.class) {
            if (TESTPATTERN1.equals(SYORIPTN)) {

                List<HT_HubiMsg> hubiMsgList = pMp.getListHubiMsg();
                HT_HubiMsg hubiMsg = new HT_HubiMsg();

                hubiMsgList = pMp.getListHubiMsg();
                hubiMsg = new HT_HubiMsg();
                hubiMsg.setMosno("791112246");
                hubiMsg.setRenno(1);
                hubiMsg.setMessageId("EHC1034");
                hubiMsg.setHubimsg("被保険者年齢がアップしています。");
                hubiMsg.setHubisyubetukbn(C_HubisyubetuKbn.KETHORYU_HUBI);
                hubiMsg.setHubisyubetusyousaikbn(C_HubisyubetusyousaiKbn.NONE);
                hubiMsgList.add(hubiMsg);

                pMp.setListHubiMsg(hubiMsgList);
                return;
            }
            else if (TESTPATTERN2.equals(SYORIPTN)) {
                List<HT_HubiMsg> hubiMsgList = pMp.getListHubiMsg();
                HT_HubiMsg hubiMsg = new HT_HubiMsg();
                hubiMsgList = pMp.getListHubiMsg();
                hubiMsg = new HT_HubiMsg();
                hubiMsg.setMosno("791112253");
                hubiMsg.setRenno(1);
                hubiMsg.setMessageId("EHC1034");
                hubiMsg.setHubimsg("被保険者年齢がアップしています。");
                hubiMsg.setHubisyubetukbn(C_HubisyubetuKbn.KETHORYU_HUBI);
                hubiMsg.setHubisyubetusyousaikbn(C_HubisyubetusyousaiKbn.NONE);
                hubiMsgList.add(hubiMsg);
                pMp.setListHubiMsg(hubiMsgList);
                return;
            }
            else if (TESTPATTERN3.equals(SYORIPTN)) {

                List<HT_HubiMsg> hubiMsgList = pMp.getListHubiMsg();
                HT_HubiMsg hubiMsg = new HT_HubiMsg();
                hubiMsgList = pMp.getListHubiMsg();
                hubiMsg = new HT_HubiMsg();
                hubiMsg.setMosno("791112261");
                hubiMsg.setRenno(1);
                hubiMsg.setMessageId("EHC1034");
                hubiMsg.setHubimsg("被保険者年齢がアップしています。");
                hubiMsg.setHubisyubetukbn(C_HubisyubetuKbn.KETHORYU_HUBI);
                hubiMsg.setHubisyubetusyousaikbn(C_HubisyubetusyousaiKbn.NONE);
                hubiMsgList.add(hubiMsg);
                pMp.setListHubiMsg(hubiMsgList);
                return;
            }
            else if (TESTPATTERN4.equals(SYORIPTN)) {
                List<HT_HubiMsg> hubiMsgList = pMp.getListHubiMsg();
                HT_HubiMsg hubiMsg = new HT_HubiMsg();
                hubiMsgList = pMp.getListHubiMsg();
                hubiMsg = new HT_HubiMsg();
                hubiMsg.setMosno("860000298");
                hubiMsg.setRenno(1);
                hubiMsg.setMessageId("EHC1034");
                hubiMsg.setHubimsg("被保険者年齢がアップしています。");
                hubiMsg.setHubisyubetukbn(C_HubisyubetuKbn.KETHORYU_HUBI);
                hubiMsg.setHubisyubetusyousaikbn(C_HubisyubetusyousaiKbn.NONE);
                hubiMsgList.add(hubiMsg);
                pMp.setListHubiMsg(hubiMsgList);
                return;
            }
            else if (TESTPATTERN4.equals(SYORIPTN)) {
                List<HT_HubiMsg> hubiMsgList = pMp.getListHubiMsg();
                HT_HubiMsg hubiMsg = new HT_HubiMsg();
                hubiMsgList = pMp.getListHubiMsg();
                hubiMsg = new HT_HubiMsg();
                hubiMsg.setMosno("791112725");
                hubiMsg.setRenno(1);
                hubiMsg.setMessageId("WHC1015");
                hubiMsg.setHubimsg("6月4日までに責任開始しない場合、契約年齢範囲外となります。");
                hubiMsg.setHubisyubetukbn(C_HubisyubetuKbn.KETHORYU_HUBI);
                hubiMsg.setHubisyubetusyousaikbn(C_HubisyubetusyousaiKbn.NONE);
                hubiMsgList.add(hubiMsg);
                pMp.setListHubiMsg(hubiMsgList);
                return;
            }
            else if (TESTPATTERN5.equals(SYORIPTN)) {
                List<HT_HubiMsg> hubiMsgList = pMp.getListHubiMsg();
                HT_HubiMsg hubiMsg = new HT_HubiMsg();
                hubiMsg.setMosno("791112428");
                hubiMsg.setRenno(1);
                hubiMsg.setMessageId("EHC1055");
                hubiMsg.setHubimsg("５年ごと利差配当付指定通貨建終身保険（一時払い）　１０年　最低保証なし（米ドル）の予定利率が取得できません。申込日　20160701");
                hubiMsg.setHubisyubetukbn(C_HubisyubetuKbn.KETHORYU_HUBI);
                hubiMsg.setHubisyubetusyousaikbn(C_HubisyubetusyousaiKbn.NONE);
                hubiMsgList.add(hubiMsg);
                pMp.setListHubiMsg(hubiMsgList);
                return;
            }
            else if (TESTPATTERN6.equals(SYORIPTN)) {
                List<HT_HubiMsg> hubiMsgList = pMp.getListHubiMsg();
                HT_HubiMsg hubiMsg = new HT_HubiMsg();
                hubiMsg.setMosno("791112733");
                hubiMsg.setRenno(1);
                hubiMsg.setMessageId("EHC1056");
                hubiMsg.setHubimsg("予定利率が申込時点から上昇しています。申込日　10.00％　契約日　20.00％");
                hubiMsg.setHubisyubetukbn(C_HubisyubetuKbn.KETHORYU_HUBI);
                hubiMsg.setHubisyubetusyousaikbn(C_HubisyubetusyousaiKbn.NONE);
                hubiMsgList.add(hubiMsg);
                pMp.setListHubiMsg(hubiMsgList);
                return;
            }
            else if (TESTPATTERN7.equals(SYORIPTN)) {
                List<HT_HubiMsg> hubiMsgList = pMp.getListHubiMsg();
                HT_HubiMsg hubiMsg = new HT_HubiMsg();
                hubiMsg.setMosno("791112436");
                hubiMsg.setRenno(1);
                hubiMsg.setMessageId("EHC1057");
                hubiMsg.setHubimsg("予定利率が申込時点から低下しています。申込日　10.00％　契約日　20.00％");
                hubiMsg.setHubisyubetukbn(C_HubisyubetuKbn.KETHORYU_HUBI);
                hubiMsg.setHubisyubetusyousaikbn(C_HubisyubetusyousaiKbn.NONE);
                hubiMsgList.add(hubiMsg);
                pMp.setListHubiMsg(hubiMsgList);
                return;
            }
            else if (TESTPATTERN8.equals(SYORIPTN)) {
                List<HT_HubiMsg> hubiMsgList = pMp.getListHubiMsg();
                HT_HubiMsg hubiMsg = new HT_HubiMsg();
                hubiMsgList = pMp.getListHubiMsg();
                hubiMsg = new HT_HubiMsg();
                hubiMsg.setMosno("791112444");
                hubiMsg.setRenno(1);
                hubiMsg.setMessageId("EHC1057");
                hubiMsg.setHubimsg("予定利率が申込時点から低下しています。申込日　20.00％　契約日　10.00％");
                hubiMsg.setHubisyubetukbn(C_HubisyubetuKbn.KETHORYU_HUBI);
                hubiMsg.setHubisyubetusyousaikbn(C_HubisyubetusyousaiKbn.NONE);
                hubiMsgList.add(hubiMsg);
                pMp.setListHubiMsg(hubiMsgList);
                return;
            }
            else if (TESTPATTERN9.equals(SYORIPTN)) {
                List<HT_HubiMsg> hubiMsgList = pMp.getListHubiMsg();
                HT_HubiMsg hubiMsg = new HT_HubiMsg();
                hubiMsgList = pMp.getListHubiMsg();
                hubiMsg = new HT_HubiMsg();
                hubiMsg.setMosno("791112501");
                hubiMsg.setRenno(1);
                hubiMsg.setMessageId("EHC1067");
                hubiMsg.setHubimsg("５年ごと利差配当付指定通貨建終身保険（一時払い）　１０年　最低保証なし（米ドル）の積立利率が取得できません。申込日　20160701");
                hubiMsg.setHubisyubetukbn(C_HubisyubetuKbn.KETHORYU_HUBI);
                hubiMsg.setHubisyubetusyousaikbn(C_HubisyubetusyousaiKbn.NONE);
                hubiMsgList.add(hubiMsg);
                pMp.setListHubiMsg(hubiMsgList);
                return;
            }
            else if (TESTPATTERN10.equals(SYORIPTN)) {
                List<HT_HubiMsg> hubiMsgList = pMp.getListHubiMsg();
                HT_HubiMsg hubiMsg = new HT_HubiMsg();
                hubiMsgList = pMp.getListHubiMsg();
                hubiMsg = new HT_HubiMsg();
                hubiMsg.setMosno("791112519");
                hubiMsg.setRenno(1);
                hubiMsg.setMessageId("EHC1068");
                hubiMsg.setHubimsg("積立利率が申込時点から上昇しています。申込日　20.00％　契約日　30.00％");
                hubiMsg.setHubisyubetukbn(C_HubisyubetuKbn.KETHORYU_HUBI);
                hubiMsg.setHubisyubetusyousaikbn(C_HubisyubetusyousaiKbn.NONE);
                hubiMsgList.add(hubiMsg);
                pMp.setListHubiMsg(hubiMsgList);
                return;
            }
            else if (TESTPATTERN11.equals(SYORIPTN)) {
                List<HT_HubiMsg> hubiMsgList = pMp.getListHubiMsg();
                HT_HubiMsg hubiMsg = new HT_HubiMsg();
                hubiMsgList = pMp.getListHubiMsg();
                hubiMsg = new HT_HubiMsg();
                hubiMsg.setMosno("791112535");
                hubiMsg.setRenno(1);
                hubiMsg.setMessageId("EHC1071");
                hubiMsg.setHubimsg("積立利率が申込時点から低下しています。申込日　40.00％　契約日　30.00％");
                hubiMsg.setHubisyubetukbn(C_HubisyubetuKbn.KETHORYU_HUBI);
                hubiMsg.setHubisyubetusyousaikbn(C_HubisyubetusyousaiKbn.NONE);
                hubiMsgList.add(hubiMsg);
                pMp.setListHubiMsg(hubiMsgList);
                return;
            }
            else if (TESTPATTERN12.equals(SYORIPTN)) {
                List<HT_HubiMsg> hubiMsgList = pMp.getListHubiMsg();
                HT_HubiMsg hubiMsg = new HT_HubiMsg();
                hubiMsgList = pMp.getListHubiMsg();
                hubiMsg = new HT_HubiMsg();
                hubiMsg.setMosno("791112576");
                hubiMsg.setRenno(1);
                hubiMsg.setMessageId("EHC1067");
                hubiMsg.setHubimsg("５年ごと利差配当付指定通貨建終身保険（一時払い）　　５年　最低保証あり（豪ドル）の積立利率が取得できません。申込日　20160701");
                hubiMsg.setHubisyubetukbn(C_HubisyubetuKbn.KETHORYU_HUBI);
                hubiMsg.setHubisyubetusyousaikbn(C_HubisyubetusyousaiKbn.NONE);
                hubiMsgList.add(hubiMsg);
                pMp.setListHubiMsg(hubiMsgList);
                return;
            }
            else if (TESTPATTERN13.equals(SYORIPTN)) {
                List<HT_HubiMsg> hubiMsgList = pMp.getListHubiMsg();
                HT_HubiMsg hubiMsg = new HT_HubiMsg();
                hubiMsgList = pMp.getListHubiMsg();
                hubiMsg = new HT_HubiMsg();
                hubiMsg.setMosno("791112584");
                hubiMsg.setRenno(1);
                hubiMsg.setMessageId("EHC1069");
                hubiMsg.setHubimsg("積立金増加率の上限が申込時点から上昇しています。申込日　60.00％　契約日　80.00％");
                hubiMsg.setHubisyubetukbn(C_HubisyubetuKbn.KETHORYU_HUBI);
                hubiMsg.setHubisyubetusyousaikbn(C_HubisyubetusyousaiKbn.NONE);
                hubiMsgList.add(hubiMsg);
                pMp.setListHubiMsg(hubiMsgList);
                return;
            }
            else if (TESTPATTERN14.equals(SYORIPTN)) {
                List<HT_HubiMsg> hubiMsgList = pMp.getListHubiMsg();
                HT_HubiMsg hubiMsg = new HT_HubiMsg();
                hubiMsgList = pMp.getListHubiMsg();
                hubiMsg = new HT_HubiMsg();
                hubiMsg.setMosno("791112600");
                hubiMsg.setRenno(1);
                hubiMsg.setMessageId("EHC1072");
                hubiMsg.setHubimsg("積立金増加率の上限が申込時点から低下しています。申込日　90.00％　契約日　80.00％　");
                hubiMsg.setHubisyubetukbn(C_HubisyubetuKbn.KETHORYU_HUBI);
                hubiMsg.setHubisyubetusyousaikbn(C_HubisyubetusyousaiKbn.NONE);
                hubiMsgList.add(hubiMsg);
                pMp.setListHubiMsg(hubiMsgList);
                return;
            }
            else if (TESTPATTERN15.equals(SYORIPTN)) {
                List<HT_HubiMsg> hubiMsgList = pMp.getListHubiMsg();
                HT_HubiMsg hubiMsg = new HT_HubiMsg();
                hubiMsgList = pMp.getListHubiMsg();
                hubiMsg = new HT_HubiMsg();
                hubiMsg.setMosno("791112642");
                hubiMsg.setRenno(1);
                hubiMsg.setMessageId("EHC1067");
                hubiMsg.setHubimsg("５年ごと利差配当付指定通貨建終身保険（一時払い）　　５年　最低保証あり（米ドル）の積立利率が取得できません。申込日　20160701");
                hubiMsg.setHubisyubetukbn(C_HubisyubetuKbn.KETHORYU_HUBI);
                hubiMsg.setHubisyubetusyousaikbn(C_HubisyubetusyousaiKbn.NONE);
                hubiMsgList.add(hubiMsg);
                pMp.setListHubiMsg(hubiMsgList);
                return;
            }
            else if (TESTPATTERN16.equals(SYORIPTN)) {
                List<HT_HubiMsg> hubiMsgList = pMp.getListHubiMsg();
                HT_HubiMsg hubiMsg = new HT_HubiMsg();
                hubiMsgList = pMp.getListHubiMsg();
                hubiMsg = new HT_HubiMsg();
                hubiMsg.setMosno("791112659");
                hubiMsg.setRenno(1);
                hubiMsg.setMessageId("EHC1070");
                hubiMsg.setHubimsg("設定倍率が申込時点から上昇しています。申込日　0.70倍　契約日　0.80倍");
                hubiMsg.setHubisyubetukbn(C_HubisyubetuKbn.KETHORYU_HUBI);
                hubiMsg.setHubisyubetusyousaikbn(C_HubisyubetusyousaiKbn.NONE);
                hubiMsgList.add(hubiMsg);
                pMp.setListHubiMsg(hubiMsgList);
                return;
            }
            else if (TESTPATTERN17.equals(SYORIPTN)) {
                List<HT_HubiMsg> hubiMsgList = pMp.getListHubiMsg();
                HT_HubiMsg hubiMsg = new HT_HubiMsg();
                hubiMsgList = pMp.getListHubiMsg();
                hubiMsg = new HT_HubiMsg();
                hubiMsg.setMosno("791112675");
                hubiMsg.setRenno(1);
                hubiMsg.setMessageId("EHC1073");
                hubiMsg.setHubimsg("設定倍率が申込時点から低下しています。申込日　0.90倍　契約日　0.80倍");
                hubiMsg.setHubisyubetukbn(C_HubisyubetuKbn.KETHORYU_HUBI);
                hubiMsg.setHubisyubetusyousaikbn(C_HubisyubetusyousaiKbn.NONE);
                hubiMsgList.add(hubiMsg);
                pMp.setListHubiMsg(hubiMsgList);
                return;
            }
            else if (TESTPATTERN18.equals(SYORIPTN)) {
                List<HT_HubiMsg> hubiMsgList = pMp.getListHubiMsg();
                HT_HubiMsg hubiMsg = new HT_HubiMsg();
                hubiMsgList = pMp.getListHubiMsg();
                hubiMsg = new HT_HubiMsg();
                hubiMsg.setMosno("860000124");
                hubiMsg.setRenno(1);
                hubiMsg.setMessageId("EHC1068");
                hubiMsg.setHubimsg("積立利率が申込時点から上昇しています。申込日　20.00％　契約日　30.00％");
                hubiMsg.setHubisyubetukbn(C_HubisyubetuKbn.KETHORYU_HUBI);
                hubiMsg.setHubisyubetusyousaikbn(C_HubisyubetusyousaiKbn.NONE);
                hubiMsgList.add(hubiMsg);
                pMp.setListHubiMsg(hubiMsgList);
                return;
            }
            else if (TESTPATTERN19.equals(SYORIPTN)) {
                List<HT_HubiMsg> hubiMsgList = pMp.getListHubiMsg();
                HT_HubiMsg hubiMsg = new HT_HubiMsg();
                hubiMsgList = pMp.getListHubiMsg();
                hubiMsg = new HT_HubiMsg();
                hubiMsg.setMosno("860000165");
                hubiMsg.setRenno(1);
                hubiMsg.setMessageId("EHC1067");
                hubiMsg.setHubimsg("５年ごと利差配当付指定通貨建終身保険（一時払い）　　５年　最低保証あり（米ドル）の積立利率が取得できません。申込日　20160701");
                hubiMsg.setHubisyubetukbn(C_HubisyubetuKbn.KETHORYU_HUBI);
                hubiMsg.setHubisyubetusyousaikbn(C_HubisyubetusyousaiKbn.NONE);
                hubiMsgList.add(hubiMsg);
                pMp.setListHubiMsg(hubiMsgList);
                return;
            }
            else if (TESTPATTERN20.equals(SYORIPTN)) {
                List<HT_HubiMsg> hubiMsgList = pMp.getListHubiMsg();
                HT_HubiMsg hubiMsg = new HT_HubiMsg();
                hubiMsgList = pMp.getListHubiMsg();
                hubiMsg = new HT_HubiMsg();
                hubiMsg.setMosno("860000173");
                hubiMsg.setRenno(1);
                hubiMsg.setMessageId("EHC1140");
                hubiMsg.setHubimsg("連動率が申込時点から上昇しています。申込日　80.00％　契約日　90.00％　");
                hubiMsg.setHubisyubetukbn(C_HubisyubetuKbn.KETHORYU_HUBI);
                hubiMsg.setHubisyubetusyousaikbn(C_HubisyubetusyousaiKbn.NONE);
                hubiMsgList.add(hubiMsg);
                pMp.setListHubiMsg(hubiMsgList);
                return;
            }
            else if (TESTPATTERN21.equals(SYORIPTN)) {
                List<HT_HubiMsg> hubiMsgList = pMp.getListHubiMsg();
                HT_HubiMsg hubiMsg = new HT_HubiMsg();
                hubiMsgList = pMp.getListHubiMsg();
                hubiMsg = new HT_HubiMsg();
                hubiMsg.setMosno("860000199");
                hubiMsg.setRenno(1);
                hubiMsg.setMessageId("EHC1141");
                hubiMsg.setHubimsg("連動率が申込時点から低下しています。申込日　90.00％　契約日　80.00％　");
                hubiMsg.setHubisyubetukbn(C_HubisyubetuKbn.KETHORYU_HUBI);
                hubiMsg.setHubisyubetusyousaikbn(C_HubisyubetusyousaiKbn.NONE);
                hubiMsgList.add(hubiMsg);
                pMp.setListHubiMsg(hubiMsgList);
                return;
            }
            else if (TESTPATTERN22.equals(SYORIPTN)) {
                List<HT_HubiMsg> hubiMsgList = pMp.getListHubiMsg();
                HT_HubiMsg hubiMsg = new HT_HubiMsg();
                hubiMsgList = pMp.getListHubiMsg();
                hubiMsg = new HT_HubiMsg();
                hubiMsg.setMosno("860000215");
                hubiMsg.setRenno(1);
                hubiMsg.setMessageId("EHC1140");
                hubiMsg.setHubimsg("連動率が申込時点から上昇しています。申込日　80.00％　契約日　90.00％　");
                hubiMsg.setHubisyubetukbn(C_HubisyubetuKbn.KETHORYU_HUBI);
                hubiMsg.setHubisyubetusyousaikbn(C_HubisyubetusyousaiKbn.NONE);
                hubiMsgList.add(hubiMsg);
                pMp.setListHubiMsg(hubiMsgList);
                return;
            }
        }

        super.exec(pKetsrhkosKbn, pSpKeisanKahiKbn, pHubisyubetusyousaiKbn, pMessage, pMp, pTknKbn, pMsgKbn);
    }
    @Override
    public void exec(C_KetsrhkosKbn pKetsrhkosKbn,
        String           pMessage,
        MosnaiCheckParam pMp,
        C_TknKbn         pTknKbn,
        C_MsgKbn         pMsgKbn) {

        if (caller == SetKisoKoumokuTest_exec.class) {

            if(TESTPATTERN1.equals(SYORIPTN)){

                List<HT_HubiMsg> hubiMsgList = pMp.getListHubiMsg();
                HT_HubiMsg hubiMsg = new HT_HubiMsg();
                hubiMsg.setMosno("791112238");
                hubiMsg.setRenno(1);
                hubiMsg.setMessageId("EHF0011");
                hubiMsg.setHubimsg("締切日情報該当データ無し　募集年月＝Ｈ２８．０１");
                hubiMsg.setHubisyubetukbn(C_HubisyubetuKbn.KETHORYU_HUBI);
                hubiMsg.setHubisyubetusyousaikbn(C_HubisyubetusyousaiKbn.NONE);
                hubiMsg.setGyoumuKousinsyaId("user001");
                hubiMsg.setGyoumuKousinTime("20150624142000000");
                hubiMsgList.add(hubiMsg);
                pMp.setListHubiMsg(hubiMsgList);
                return;
            }
            else if(TESTPATTERN2.equals(SYORIPTN)){

                List<HT_HubiMsg> hubiMsgList = pMp.getListHubiMsg();
                HT_HubiMsg hubiMsg = new HT_HubiMsg();
                hubiMsg.setMosno("791112246");
                hubiMsg.setRenno(1);
                hubiMsg.setMessageId("EHC1048");
                hubiMsg.setHubimsg("外貨建て一時払変額年金保険（ブレンド型）　年金原資最低保証１００％の予定利率が取得できません。契約日　20170426");
                hubiMsg.setHubisyubetukbn(C_HubisyubetuKbn.KETHORYU_HUBI);
                hubiMsg.setHubisyubetusyousaikbn(C_HubisyubetusyousaiKbn.NONE);
                hubiMsg.setGyoumuKousinsyaId("user001");
                hubiMsg.setGyoumuKousinTime("20150624142000000");
                hubiMsgList.add(hubiMsg);
                pMp.setListHubiMsg(hubiMsgList);
                return;
            }
            else if(TESTPATTERN3.equals(SYORIPTN)){

                List<HT_HubiMsg> hubiMsgList = pMp.getListHubiMsg();
                HT_HubiMsg hubiMsg = new HT_HubiMsg();
                hubiMsg.setMosno("860000306");
                hubiMsg.setRenno(1);
                hubiMsg.setMessageId("EHC1120");
                hubiMsg.setHubimsg("５年ごと利差配当付指定通貨建個人年金保険（一時払い）・据置期間０歳は予定利率低下の影響のため募集休止中です。申込撤回のお手続きを実施ください。");
                hubiMsg.setHubisyubetukbn(C_HubisyubetuKbn.KETHORYU_HUBI);
                hubiMsg.setHubisyubetusyousaikbn(C_HubisyubetusyousaiKbn.NONE);
                hubiMsg.setGyoumuKousinsyaId("user001");
                hubiMsg.setGyoumuKousinTime("20150624142000000");
                hubiMsgList.add(hubiMsg);
                pMp.setListHubiMsg(hubiMsgList);
                return;
            }
            else if(TESTPATTERN4.equals(SYORIPTN)){

                List<HT_HubiMsg> hubiMsgList = pMp.getListHubiMsg();
                HT_HubiMsg hubiMsg = new HT_HubiMsg();
                hubiMsg.setMosno("860000298");
                hubiMsg.setRenno(1);
                hubiMsg.setMessageId("EHC1048");
                hubiMsg.setHubimsg("５年ごと利差配当付指定通貨建個人年金保険（一時払い）　年金原資最低保証１００％の予定利率が取得できません。契約日　２０１６０５１６");
                hubiMsg.setHubisyubetukbn(C_HubisyubetuKbn.KETHORYU_HUBI);
                hubiMsg.setHubisyubetusyousaikbn(C_HubisyubetusyousaiKbn.NONE);
                hubiMsg.setGyoumuKousinsyaId("user001");
                hubiMsg.setGyoumuKousinTime("20150624142000000");
                hubiMsgList.add(hubiMsg);
                pMp.setListHubiMsg(hubiMsgList);
                return;
            }
            else if(TESTPATTERN5.equals(SYORIPTN)){

                List<HT_HubiMsg> hubiMsgList = pMp.getListHubiMsg();
                HT_HubiMsg hubiMsg = new HT_HubiMsg();
                hubiMsg.setMosno("860000256");
                hubiMsg.setRenno(1);
                hubiMsg.setMessageId("EHC1120");
                hubiMsg.setHubimsg("外貨建て一時払変額年金保険（ブレンド型）　年金原資最低保証１００％は予定利率低下の影響のため募集休止中です。申込撤回のお手続きを実施ください。");
                hubiMsg.setHubisyubetukbn(C_HubisyubetuKbn.KETHORYU_HUBI);
                hubiMsg.setHubisyubetusyousaikbn(C_HubisyubetusyousaiKbn.NONE);
                hubiMsg.setGyoumuKousinsyaId("user001");
                hubiMsg.setGyoumuKousinTime("20150624142000000");
                hubiMsgList.add(hubiMsg);
                pMp.setListHubiMsg(hubiMsgList);
                return;
            }
            else if(TESTPATTERN6.equals(SYORIPTN)){

                List<HT_HubiMsg> hubiMsgList = pMp.getListHubiMsg();
                HT_HubiMsg hubiMsg = new HT_HubiMsg();
                hubiMsg.setMosno("860000280");
                hubiMsg.setRenno(1);
                hubiMsg.setMessageId("EHC1048");
                hubiMsg.setHubimsg("５年ごと利差配当付指定通貨建個人年金保険（一時払い）の予定利率が取得できません。契約日　２０１６０５１６");
                hubiMsg.setHubisyubetukbn(C_HubisyubetuKbn.KETHORYU_HUBI);
                hubiMsg.setHubisyubetusyousaikbn(C_HubisyubetusyousaiKbn.NONE);
                hubiMsg.setGyoumuKousinsyaId("user001");
                hubiMsg.setGyoumuKousinTime("20150624142000000");
                hubiMsgList.add(hubiMsg);
                pMp.setListHubiMsg(hubiMsgList);
                return;
            }
            else if(TESTPATTERN21.equals(SYORIPTN)){

                List<HT_HubiMsg> hubiMsgList = pMp.getListHubiMsg();
                HT_HubiMsg hubiMsg = new HT_HubiMsg();
                hubiMsg.setMosno("860000017");
                hubiMsg.setRenno(1);
                hubiMsg.setMessageId("EHC1048");
                hubiMsg.setHubimsg("外貨建て一時払終身保険（即時保障型）　１０年毎利率再設定の予定利率が取得できません。契約日　20160419");
                hubiMsg.setHubisyubetukbn(C_HubisyubetuKbn.KETHORYU_HUBI);
                hubiMsg.setHubisyubetusyousaikbn(C_HubisyubetusyousaiKbn.NONE);
                hubiMsg.setGyoumuKousinsyaId("user001");
                hubiMsg.setGyoumuKousinTime("20150624142000000");
                hubiMsgList.add(hubiMsg);
                pMp.setListHubiMsg(hubiMsgList);
                return;
            }
        }
        else if (caller == CheckHrkKeiroTest_exec.class) {
            return;
        }
        else if (caller == NayoseTest_exec.class) {
            if (TESTPATTERN1.equals(SYORIPTN)) {

                pMp.setSekmossakuseiErroutKbn(C_SekmossakuseiErroutKbn.GAMEN);
                pMp.setSekmossakuseiErrmsg1("");
                pMp.setSekmossakuseiErrmsg2("メッセージ処理停止中");
                pMp.setKouzokuSyoriJikkouKbn(C_KouzokujkKbn.NONE);
                return;
            }
            if (TESTPATTERN2.equals(SYORIPTN)) {

                pMp.setSekmossakuseiErroutKbn(C_SekmossakuseiErroutKbn.NONE);
                pMp.setSekmossakuseiErrmsg1("");
                pMp.setSekmossakuseiErrmsg2("");
                pMp.setKouzokuSyoriJikkouKbn(C_KouzokujkKbn.NONE);
                return;
            }
            if (TESTPATTERN3.equals(SYORIPTN)) {

                List<HT_HubiMsg> hubiMsgList = pMp.getListHubiMsg();
                if(hubiMsgList.size() == 0){
                    HT_HubiMsg hubiMsg1 = new HT_HubiMsg();
                    hubiMsg1.setMosno("791112279");
                    hubiMsg1.setRenno(1);
                    hubiMsg1.setMessageId("EHC1020");
                    hubiMsg1.setHubimsg("被保険者が名寄せ不明です。ＰＡＬの照会機能にて確認を行なってください。");
                    hubiMsg1.setHubisyubetukbn(C_HubisyubetuKbn.SRHORYU_HUBI);
                    hubiMsg1.setHubisyubetusyousaikbn(C_HubisyubetusyousaiKbn.NONE);
                    hubiMsg1.setGyoumuKousinsyaId("user001");
                    hubiMsg1.setGyoumuKousinTime("20150604162000000");
                    hubiMsgList.add(hubiMsg1);
                }
                else if(hubiMsgList.size() == 1){
                    HT_HubiMsg hubiMsg2 = new HT_HubiMsg();
                    hubiMsg2.setMosno("791112279");
                    hubiMsg2.setRenno(2);
                    hubiMsg2.setMessageId("EHC1020");
                    hubiMsg2.setHubimsg("契約者が名寄せ不明です。ＰＡＬの照会機能にて確認を行なってください。");
                    hubiMsg2.setHubisyubetukbn(C_HubisyubetuKbn.SRHORYU_HUBI);
                    hubiMsg2.setHubisyubetusyousaikbn(C_HubisyubetusyousaiKbn.NONE);
                    hubiMsg2.setGyoumuKousinsyaId("user001");
                    hubiMsg2.setGyoumuKousinTime("20150604162000000");
                    hubiMsgList.add(hubiMsg2);
                }
                else if(hubiMsgList.size() == 2){
                    HT_HubiMsg hubiMsg3 = new HT_HubiMsg();
                    hubiMsg3.setMosno("791112279");
                    hubiMsg3.setRenno(3);
                    hubiMsg3.setMessageId("EHC1018");
                    hubiMsg3.setHubimsg("被保険者生年月日が索引結果と一致しません。入力内容に誤りがないかご確認ください。");
                    hubiMsg3.setHubisyubetukbn(C_HubisyubetuKbn.KETHORYU_HUBI);
                    hubiMsg3.setHubisyubetusyousaikbn(C_HubisyubetusyousaiKbn.NONE);
                    hubiMsg3.setGyoumuKousinsyaId("user001");
                    hubiMsg3.setGyoumuKousinTime("20150604162000000");
                    hubiMsgList.add(hubiMsg3);
                }
                else if(hubiMsgList.size() == 3){
                    HT_HubiMsg hubiMsg4 = new HT_HubiMsg();
                    hubiMsg4.setMosno("791112279");
                    hubiMsg4.setRenno(4);
                    hubiMsg4.setMessageId("EHC1018");
                    hubiMsg4.setHubimsg("契約者生年月日が索引結果と一致しません。入力内容に誤りがないかご確認ください。");
                    hubiMsg4.setHubisyubetukbn(C_HubisyubetuKbn.KETHORYU_HUBI);
                    hubiMsg4.setHubisyubetusyousaikbn(C_HubisyubetusyousaiKbn.NONE);
                    hubiMsg4.setGyoumuKousinsyaId("user001");
                    hubiMsg4.setGyoumuKousinTime("20150604162000000");
                    hubiMsgList.add(hubiMsg4);
                    pMp.setListHubiMsg(hubiMsgList);
                }
                return;
            }
            if (TESTPATTERN4.equals(SYORIPTN)) {

                List<HT_HubiMsg> hubiMsgList = pMp.getListHubiMsg();
                if(hubiMsgList.size() == 0){
                    HT_HubiMsg hubiMsg1 = new HT_HubiMsg();
                    hubiMsg1.setMosno("791112287");
                    hubiMsg1.setRenno(1);
                    hubiMsg1.setMessageId("EHC1019");
                    hubiMsg1.setHubimsg("別契約が確認できません。ＰＡＬの索引照会で確認してください。（ＰＡＬあて照会実施なし）");
                    hubiMsg1.setHubisyubetukbn(C_HubisyubetuKbn.SRHORYU_HUBI);
                    hubiMsg1.setHubisyubetusyousaikbn(C_HubisyubetusyousaiKbn.NONE);
                    hubiMsg1.setGyoumuKousinsyaId("user001");
                    hubiMsg1.setGyoumuKousinTime("20150604162000000");
                    hubiMsgList.add(hubiMsg1);
                }
                else if(hubiMsgList.size() == 1){
                    HT_HubiMsg hubiMsg2 = new HT_HubiMsg();
                    hubiMsg2.setMosno("791112287");
                    hubiMsg2.setRenno(2);
                    hubiMsg2.setMessageId("EHC1018");
                    hubiMsg2.setHubimsg("契約者生年月日が索引結果と一致しません。入力内容に誤りがないかご確認ください。");
                    hubiMsg2.setHubisyubetukbn(C_HubisyubetuKbn.KETHORYU_HUBI);
                    hubiMsg2.setHubisyubetusyousaikbn(C_HubisyubetusyousaiKbn.NONE);
                    hubiMsg2.setGyoumuKousinsyaId("user001");
                    hubiMsg2.setGyoumuKousinTime("20150604162000000");
                    hubiMsgList.add(hubiMsg2);
                }
                pMp.setListHubiMsg(hubiMsgList);
                return;

            }
            if (TESTPATTERN5.equals(SYORIPTN)) {

                List<HT_HubiMsg> hubiMsgList = pMp.getListHubiMsg();
                if(hubiMsgList.size() == 0){
                    HT_HubiMsg hubiMsg1 = new HT_HubiMsg();
                    hubiMsg1.setMosno("791112295");
                    hubiMsg1.setRenno(1);
                    hubiMsg1.setMessageId("EHC1016");
                    hubiMsg1.setHubimsg("別契約が確認できません。ＰＡＬの索引照会で確認してください。（ＭＱ処理結果エラー）");
                    hubiMsg1.setHubisyubetukbn(C_HubisyubetuKbn.SRHORYU_HUBI);
                    hubiMsg1.setHubisyubetusyousaikbn(C_HubisyubetusyousaiKbn.NONE);
                    hubiMsg1.setGyoumuKousinsyaId("user001");
                    hubiMsg1.setGyoumuKousinTime("20150604162000000");
                    hubiMsgList.add(hubiMsg1);
                }
                else if(hubiMsgList.size() == 1){
                    HT_HubiMsg hubiMsg2 = new HT_HubiMsg();
                    hubiMsg2.setMosno("791112295");
                    hubiMsg2.setRenno(2);
                    hubiMsg2.setMessageId("EHC1018");
                    hubiMsg2.setHubimsg("被保険者生年月日が索引結果と一致しません。入力内容に誤りがないかご確認ください。");
                    hubiMsg2.setHubisyubetukbn(C_HubisyubetuKbn.KETHORYU_HUBI);
                    hubiMsg2.setHubisyubetusyousaikbn(C_HubisyubetusyousaiKbn.NONE);
                    hubiMsg2.setGyoumuKousinsyaId("user001");
                    hubiMsg2.setGyoumuKousinTime("20150604162000000");
                    hubiMsgList.add(hubiMsg2);
                }

                pMp.setListHubiMsg(hubiMsgList);
                return;

            }
            if (TESTPATTERN6.equals(SYORIPTN)) {

                List<HT_HubiMsg> hubiMsgList = pMp.getListHubiMsg();

                HT_HubiMsg hubiMsg1 = new HT_HubiMsg();
                hubiMsg1.setMosno("791112303");
                hubiMsg1.setRenno(hubiMsgList.size() + 1);
                hubiMsg1.setMessageId("EHC1020");
                hubiMsg1.setHubimsg("被保険者が名寄せ不明です。ＰＡＬの照会機能にて確認を行なってください。");
                hubiMsg1.setHubisyubetukbn(C_HubisyubetuKbn.SRHORYU_HUBI);
                hubiMsg1.setHubisyubetusyousaikbn(C_HubisyubetusyousaiKbn.NONE);
                hubiMsg1.setGyoumuKousinsyaId("user001");
                hubiMsg1.setGyoumuKousinTime("20150604162000000");
                hubiMsgList.add(hubiMsg1);

                pMp.setListHubiMsg(hubiMsgList);
                return;
            }
            if (TESTPATTERN7.equals(SYORIPTN)) {

                List<HT_HubiMsg> hubiMsgList = pMp.getListHubiMsg();

                HT_HubiMsg hubiMsg1 = new HT_HubiMsg();
                hubiMsg1.setMosno("791112311");
                hubiMsg1.setRenno(1);
                hubiMsg1.setMessageId("EHC1018");
                hubiMsg1.setHubimsg("被保険者生年月日が索引結果と一致しません。入力内容に誤りがないかご確認ください。");
                hubiMsg1.setHubisyubetukbn(C_HubisyubetuKbn.KETHORYU_HUBI);
                hubiMsg1.setHubisyubetusyousaikbn(C_HubisyubetusyousaiKbn.NONE);
                hubiMsg1.setGyoumuKousinsyaId("user001");
                hubiMsg1.setGyoumuKousinTime("20150604162000000");
                hubiMsgList.add(hubiMsg1);

                pMp.setListHubiMsg(hubiMsgList);
                return;

            }
            if (TESTPATTERN8.equals(SYORIPTN)) {

                List<HT_HubiMsg> hubiMsgList = pMp.getListHubiMsg();
                if(hubiMsgList.size() == 0){
                    HT_HubiMsg hubiMsg1 = new HT_HubiMsg();
                    hubiMsg1.setMosno("791112329");
                    hubiMsg1.setRenno(1);
                    hubiMsg1.setMessageId("EHC1016");
                    hubiMsg1.setHubimsg("別契約が確認できません。ＰＡＬの索引照会で確認してください。（ＭＱ処理結果エラー）");
                    hubiMsg1.setHubisyubetukbn(C_HubisyubetuKbn.SRHORYU_HUBI);
                    hubiMsg1.setHubisyubetusyousaikbn(C_HubisyubetusyousaiKbn.NONE);
                    hubiMsg1.setGyoumuKousinsyaId("user001");
                    hubiMsg1.setGyoumuKousinTime("20150604162000000");
                    hubiMsgList.add(hubiMsg1);
                }
                else if(hubiMsgList.size() == 1){
                    HT_HubiMsg hubiMsg2 = new HT_HubiMsg();
                    hubiMsg2.setMosno("791112329");
                    hubiMsg2.setRenno(2);
                    hubiMsg2.setMessageId("EHC1018");
                    hubiMsg2.setHubimsg("契約者生年月日が索引結果と一致しません。入力内容に誤りがないかご確認ください。");
                    hubiMsg2.setHubisyubetukbn(C_HubisyubetuKbn.KETHORYU_HUBI);
                    hubiMsg2.setHubisyubetusyousaikbn(C_HubisyubetusyousaiKbn.NONE);
                    hubiMsg2.setGyoumuKousinsyaId("user001");
                    hubiMsg2.setGyoumuKousinTime("20150604162000000");
                    hubiMsgList.add(hubiMsg2);
                }

                pMp.setListHubiMsg(hubiMsgList);
                return;

            }
            if (TESTPATTERN9.equals(SYORIPTN)) {

                List<HT_HubiMsg> hubiMsgList = pMp.getListHubiMsg();
                HT_HubiMsg hubiMsg1 = new HT_HubiMsg();
                hubiMsg1.setMosno("791112345");
                hubiMsg1.setRenno(1);
                hubiMsg1.setMessageId("EHC1018");
                hubiMsg1.setHubimsg("被保険者生年月日が索引結果と一致しません。入力内容に誤りがないかご確認ください。");
                hubiMsg1.setHubisyubetukbn(C_HubisyubetuKbn.KETHORYU_HUBI);
                hubiMsg1.setHubisyubetusyousaikbn(C_HubisyubetusyousaiKbn.NONE);
                hubiMsg1.setGyoumuKousinsyaId("user001");
                hubiMsg1.setGyoumuKousinTime("20150604162000000");
                hubiMsgList.add(hubiMsg1);

                pMp.setListHubiMsg(hubiMsgList);
                return;

            }
            if (TESTPATTERN10.equals(SYORIPTN)) {
                return;
            }
            if (TESTPATTERN11.equals(SYORIPTN)) {

                List<HT_HubiMsg> hubiMsgList = pMp.getListHubiMsg();

                HT_HubiMsg hubiMsg1 = new HT_HubiMsg();
                hubiMsg1.setMosno("791112386");
                hubiMsg1.setRenno(hubiMsgList.size() + 1);
                hubiMsg1.setMessageId("EHC1020");
                hubiMsg1.setHubimsg("被保険者が名寄せ不明です。ＰＡＬの照会機能にて確認を行なってください。");
                hubiMsg1.setHubisyubetukbn(C_HubisyubetuKbn.SRHORYU_HUBI);
                hubiMsg1.setHubisyubetusyousaikbn(C_HubisyubetusyousaiKbn.NONE);
                hubiMsg1.setGyoumuKousinsyaId("user001");
                hubiMsg1.setGyoumuKousinTime("20150604162000000");
                hubiMsgList.add(hubiMsg1);

                pMp.setListHubiMsg(hubiMsgList);
                return;
            }
            else if (TESTPATTERN12.equals(SYORIPTN)) {

                List<HT_HubiMsg> hubiMsgList = pMp.getListHubiMsg();
                if(hubiMsgList.size() == 0){
                    HT_HubiMsg hubiMsg1 = new HT_HubiMsg();
                    hubiMsg1.setMosno("860000025");
                    hubiMsg1.setRenno(1);
                    hubiMsg1.setMessageId("EHC1019");
                    hubiMsg1.setHubimsg("別契約が確認できません。ＰＡＬの索引照会で確認してください。（ＰＡＬあて照会実施なし）");
                    hubiMsg1.setHubisyubetukbn(C_HubisyubetuKbn.SRHORYU_HUBI);
                    hubiMsg1.setHubisyubetusyousaikbn(C_HubisyubetusyousaiKbn.NONE);
                    hubiMsg1.setGyoumuKousinsyaId("user001");
                    hubiMsg1.setGyoumuKousinTime("20150604162000000");
                    hubiMsgList.add(hubiMsg1);
                }
                pMp.setListHubiMsg(hubiMsgList);
                return;
            }
        }
        else if (caller == CheckHokenRyouYuukouKigenTest_exec.class) {
            if (TESTPATTERN1.equals(SYORIPTN)) {

                List<HT_HubiMsg> hubiMsgList = pMp.getListHubiMsg();
                HT_HubiMsg hubiMsg = new HT_HubiMsg();

                hubiMsg.setMosno("791112725");
                hubiMsg.setRenno(1);
                hubiMsg.setMessageId("WHC1015");
                hubiMsg.setHubimsg("6月4日までに責任開始しない場合、契約年齢範囲外となります。");
                hubiMsg.setHubisyubetukbn(C_HubisyubetuKbn.WARNING);
                hubiMsg.setHubisyubetusyousaikbn(C_HubisyubetusyousaiKbn.NONE);
                hubiMsgList.add(hubiMsg);
                return;
            }
            else if (TESTPATTERN2.equals(SYORIPTN)) {
                List<HT_HubiMsg> hubiMsgList = pMp.getListHubiMsg();
                HT_HubiMsg hubiMsg = new HT_HubiMsg();
                hubiMsg.setMosno("791112303");
                hubiMsg.setRenno(1);
                hubiMsg.setMessageId("WHC1016");
                hubiMsg.setHubimsg("6月4日までに責任開始しない場合、契約年齢があがります。");
                hubiMsg.setHubisyubetukbn(C_HubisyubetuKbn.WARNING);
                hubiMsg.setHubisyubetusyousaikbn(C_HubisyubetusyousaiKbn.NONE);
                hubiMsgList.add(hubiMsg);
                pMp.setListHubiMsg(hubiMsgList);
                return;
            }
            else if (TESTPATTERN3.equals(SYORIPTN)) {
                List<HT_HubiMsg> hubiMsgList = pMp.getListHubiMsg();
                HT_HubiMsg hubiMsg = new HT_HubiMsg();
                hubiMsg.setMosno("791112311");
                hubiMsg.setRenno(1);
                hubiMsg.setMessageId("WHC1016");
                hubiMsg.setHubimsg("6月4日までに責任開始しない場合、契約年齢があがります。");
                hubiMsg.setHubisyubetukbn(C_HubisyubetuKbn.WARNING);
                hubiMsg.setHubisyubetusyousaikbn(C_HubisyubetusyousaiKbn.NONE);
                hubiMsgList.add(hubiMsg);
                pMp.setListHubiMsg(hubiMsgList);
                return;
            }
            else if (TESTPATTERN4.equals(SYORIPTN)) {
                List<HT_HubiMsg> hubiMsgList = pMp.getListHubiMsg();
                HT_HubiMsg hubiMsg = new HT_HubiMsg();
                hubiMsg.setMosno("791112345");
                hubiMsg.setRenno(1);
                hubiMsg.setMessageId("WHC1017");
                hubiMsg.setHubimsg("保険料有効期限を過ぎたため契約年齢範囲外となる可能性があります。");
                hubiMsg.setHubisyubetukbn(C_HubisyubetuKbn.WARNING);
                hubiMsg.setHubisyubetusyousaikbn(C_HubisyubetusyousaiKbn.NONE);
                hubiMsgList.add(hubiMsg);
                pMp.setListHubiMsg(hubiMsgList);
                return;
            }
            else if (TESTPATTERN5.equals(SYORIPTN)) {
                List<HT_HubiMsg> hubiMsgList = pMp.getListHubiMsg();
                HT_HubiMsg hubiMsg = new HT_HubiMsg();
                hubiMsg.setMosno("791112352");
                hubiMsg.setRenno(1);
                hubiMsg.setMessageId("WHC1018");
                hubiMsg.setHubimsg("保険料有効期限を過ぎたため契約年齢があがっている可能性があります。");
                hubiMsg.setHubisyubetukbn(C_HubisyubetuKbn.WARNING);
                hubiMsg.setHubisyubetusyousaikbn(C_HubisyubetusyousaiKbn.NONE);
                hubiMsgList.add(hubiMsg);
                pMp.setListHubiMsg(hubiMsgList);
                return;
            }
            else if (TESTPATTERN6.equals(SYORIPTN)) {
                List<HT_HubiMsg> hubiMsgList = pMp.getListHubiMsg();
                HT_HubiMsg hubiMsg = new HT_HubiMsg();
                hubiMsg.setMosno("791112360");
                hubiMsg.setRenno(1);
                hubiMsg.setMessageId("WHC1018");
                hubiMsg.setHubimsg("保険料有効期限を過ぎたため契約年齢があがっている可能性があります。");
                hubiMsg.setHubisyubetukbn(C_HubisyubetuKbn.WARNING);
                hubiMsg.setHubisyubetusyousaikbn(C_HubisyubetusyousaiKbn.NONE);
                hubiMsgList.add(hubiMsg);
                pMp.setListHubiMsg(hubiMsgList);
                return;
            }
            else if (TESTPATTERN7.equals(SYORIPTN)) {
                List<HT_HubiMsg> hubiMsgList = pMp.getListHubiMsg();
                HT_HubiMsg hubiMsg = new HT_HubiMsg();
                hubiMsg.setMosno("791112253");
                hubiMsg.setRenno(1);
                hubiMsg.setMessageId("WHC1022");
                hubiMsg.setHubimsg("被保険者年齢がアップしています。");
                hubiMsg.setHubisyubetukbn(C_HubisyubetuKbn.WARNING);
                hubiMsg.setHubisyubetusyousaikbn(C_HubisyubetusyousaiKbn.NONE);
                hubiMsgList.add(hubiMsg);
                pMp.setListHubiMsg(hubiMsgList);
                return;
            }
            else if (TESTPATTERN8.equals(SYORIPTN)) {
                List<HT_HubiMsg> hubiMsgList = pMp.getListHubiMsg();
                HT_HubiMsg hubiMsg = new HT_HubiMsg();
                hubiMsg.setMosno("791112261");
                hubiMsg.setRenno(1);
                hubiMsg.setMessageId("WHC1022");
                hubiMsg.setHubimsg("被保険者年齢がアップしています。");
                hubiMsg.setHubisyubetukbn(C_HubisyubetuKbn.WARNING);
                hubiMsg.setHubisyubetusyousaikbn(C_HubisyubetusyousaiKbn.NONE);
                hubiMsgList.add(hubiMsg);
                pMp.setListHubiMsg(hubiMsgList);
                return;
            }
            else if (TESTPATTERN9.equals(SYORIPTN)) {
                List<HT_HubiMsg> hubiMsgList = pMp.getListHubiMsg();
                HT_HubiMsg hubiMsg = new HT_HubiMsg();
                hubiMsgList = pMp.getListHubiMsg();
                hubiMsg = new HT_HubiMsg();
                hubiMsg.setMosno("860000298");
                hubiMsg.setRenno(1);
                hubiMsg.setMessageId("WHC1023");
                hubiMsg.setHubimsg("予定利率が申込時点から上昇しています。申込日　10.00％　契約日　20.00％");
                hubiMsg.setHubisyubetukbn(C_HubisyubetuKbn.WARNING);
                hubiMsg.setHubisyubetusyousaikbn(C_HubisyubetusyousaiKbn.NONE);
                hubiMsgList.add(hubiMsg);
                pMp.setListHubiMsg(hubiMsgList);
                return;
            }
            else if (TESTPATTERN10.equals(SYORIPTN)) {
                List<HT_HubiMsg> hubiMsgList = pMp.getListHubiMsg();
                HT_HubiMsg hubiMsg = new HT_HubiMsg();
                hubiMsgList = pMp.getListHubiMsg();
                hubiMsg = new HT_HubiMsg();
                hubiMsg.setMosno("860000306");
                hubiMsg.setRenno(1);
                hubiMsg.setMessageId("WHC1023");
                hubiMsg.setHubimsg("予定利率が申込時点から上昇しています。申込日　10.00％　契約日　20.00％");
                hubiMsg.setHubisyubetukbn(C_HubisyubetuKbn.WARNING);
                hubiMsg.setHubisyubetusyousaikbn(C_HubisyubetusyousaiKbn.NONE);
                hubiMsgList.add(hubiMsg);
                pMp.setListHubiMsg(hubiMsgList);
                return;
            }
            else if (TESTPATTERN11.equals(SYORIPTN)) {
                List<HT_HubiMsg> hubiMsgList = pMp.getListHubiMsg();
                HT_HubiMsg hubiMsg = new HT_HubiMsg();
                hubiMsgList = pMp.getListHubiMsg();
                hubiMsg = new HT_HubiMsg();
                hubiMsg.setMosno("860000272");
                hubiMsg.setRenno(1);
                hubiMsg.setMessageId("WHC1024");
                hubiMsg.setHubimsg("予定利率が申込時点から低下しています。申込日　20.00％　契約日　10.00％");
                hubiMsg.setHubisyubetukbn(C_HubisyubetuKbn.WARNING);
                hubiMsg.setHubisyubetusyousaikbn(C_HubisyubetusyousaiKbn.NONE);
                hubiMsgList.add(hubiMsg);
                pMp.setListHubiMsg(hubiMsgList);
                return;
            }
            else if (TESTPATTERN12.equals(SYORIPTN)) {
                List<HT_HubiMsg> hubiMsgList = pMp.getListHubiMsg();
                HT_HubiMsg hubiMsg = new HT_HubiMsg();
                hubiMsgList = pMp.getListHubiMsg();
                hubiMsg = new HT_HubiMsg();
                hubiMsg.setMosno("860000280");
                hubiMsg.setRenno(1);
                hubiMsg.setMessageId("WHC1024");
                hubiMsg.setHubimsg("予定利率が申込時点から低下しています。申込日　20.00％　契約日　10.00％");
                hubiMsg.setHubisyubetukbn(C_HubisyubetuKbn.WARNING);
                hubiMsg.setHubisyubetusyousaikbn(C_HubisyubetusyousaiKbn.NONE);
                hubiMsgList.add(hubiMsg);
                pMp.setListHubiMsg(hubiMsgList);
                return;
            }

        }
        else if (caller == SetSPTest_exec.class) {
            return;
        }
        else if (caller == CheckSkTuusanTest_exec.class ) {
            return;
        }
        super.exec(pKetsrhkosKbn,pMessage,pMp,pTknKbn,pMsgKbn);
    }

    @Override
    public void exec(C_KetsrhkosKbn pKetsrhkosKbn,
        String pMessage,
        MosnaiCheckParam pMp) {

        if (SetHubiMsgMockForSinkeiyaku.caller == CheckTblCreditCardInfoTest_exec.class) {
            return;
        }

        else if (caller == CheckHrkKeiroTest_exec.class) {
            return;
        }

        else if (caller == CheckTblKouzaJyouhouTest_exec.class) {
            return;
        }
        else if (caller == CheckZennouKanrenTest_exec.class) {
            return;
        }
        if (caller == SetSyouhinSedaiTest_exec.class) {
            return;
        }

        super.exec(pKetsrhkosKbn,pMessage,pMp);
    }

    @Override
    public void exec(String pMessageUpper, String pMessageLower,
        C_SekmossakuseiErroutKbn pSekmossakuseiErroutKbn, MosnaiCheckParam pMp) {
        if (caller == SetKisoKoumokuTest_exec.class) {
            if(TESTPATTERN1.equals(SYORIPTN)){

                pMp.setSekmossakuseiErroutKbn(C_SekmossakuseiErroutKbn.GAMEN);
                pMp.setSekmossakuseiErrmsg1("");
                pMp.setSekmossakuseiErrmsg2("予定利率が取得できません");
                pMp.setKouzokuSyoriJikkouKbn( C_KouzokujkKbn.NONE);
                return;
            }
            if(TESTPATTERN6.equals(SYORIPTN)){

                pMp.setSekmossakuseiErroutKbn(C_SekmossakuseiErroutKbn.GAMEN);
                pMp.setSekmossakuseiErrmsg1("");
                pMp.setSekmossakuseiErrmsg2("指定通貨円・据置期間７０歳のお取扱いは現在休止しています");
                pMp.setKouzokuSyoriJikkouKbn( C_KouzokujkKbn.NONE);
                return;
            }
            if(TESTPATTERN7.equals(SYORIPTN)){

                pMp.setSekmossakuseiErroutKbn(C_SekmossakuseiErroutKbn.GAMEN);
                pMp.setSekmossakuseiErrmsg1("");
                pMp.setSekmossakuseiErrmsg2("指定通貨円のお取扱いは現在休止しています");
                pMp.setKouzokuSyoriJikkouKbn( C_KouzokujkKbn.NONE);
                return;
            }
        }

        super.exec(pMessageUpper,pMessageLower,pSekmossakuseiErroutKbn,pMp);


    }

    @Override
    public void exec(C_KetsrhkosKbn pKetsrhkosKbn,
        C_HubisyubetusyousaiKbn pHubisyubetusyousaiKbn,
        String pMessage,
        MosnaiCheckParam pMp,
        C_TknKbn pTknKbn,
        C_MsgKbn pMsgKbn) {

        if (caller == CheckTblKouzaJyouhouTest_exec.class) {
            return;
        }
        super.exec(pKetsrhkosKbn, pHubisyubetusyousaiKbn, pMessage, pMp, pTknKbn, pMsgKbn);

    }


    @Override
    public String editHubiMsgKingaku(BizCurrency pGk, BizCurrency pGkSiteiTani, C_Tuukasyu pTuukasyu) {

        return super.editHubiMsgKingaku(pGk, pGkSiteiTani, pTuukasyu);
    }

    @Override
    public void exec(C_KetsrhkosKbn pKetsrhkosKbn,
        C_SyoruiCdKbn pSyoruiCdKbn,
        String pMessage,
        MosnaiCheckParam pMp,
        C_TknKbn pTknKbn,
        C_MsgKbn pMsgKbn) {

        if (caller == HanteiHituyouSyoruiTest_exec.class && TESTPATTERN1.equals(SYORIPTN)) {

            List<HT_HubiMsg> hubiMsgList = pMp.getListHubiMsg();
            HT_HubiMsg hubiMsg = new HT_HubiMsg();
            hubiMsg.setMosno("861110021");
            hubiMsg.setRenno(1);
            hubiMsg.setHubimsg("ペーパーレス申込書兼意向確認書が到着していません。");
            hubiMsg.setHubisyubetukbn(C_HubisyubetuKbn.SRHORYU_HUBI);
            hubiMsg.setHituyousyoruicd(C_SyoruiCdKbn.SK_PPLESSMOSIKOUKAKSYO);
            hubiMsg.setGyoumuKousinsyaId("user001");
            hubiMsg.setGyoumuKousinTime("20160217133124350");
            hubiMsgList.add(hubiMsg);
            pMp.setListHubiMsg(hubiMsgList);
            return;
        }
        else if (caller == HanteiHituyouSyoruiTest_exec.class && TESTPATTERN2.equals(SYORIPTN)) {

            List<HT_HubiMsg> hubiMsgList = pMp.getListHubiMsg();

            if (hubiMsgList.size() == 0) {
                HT_HubiMsg hubiMsg1 = new HT_HubiMsg();
                hubiMsg1.setMosno("860083641");
                hubiMsg1.setRenno(1);
                hubiMsg1.setHubimsg("ペーパーレス取扱報告書が到着していません。");
                hubiMsg1.setHubisyubetukbn(C_HubisyubetuKbn.WARNING);
                hubiMsg1.setHituyousyoruicd(C_SyoruiCdKbn.SK_UKTJIZENSYOUKAI);
                hubiMsg1.setGyoumuKousinsyaId("user001");
                hubiMsg1.setGyoumuKousinTime("20160217133124350");
                hubiMsgList.add(hubiMsg1);

            } else {
                HT_HubiMsg hubiMsg2 = new HT_HubiMsg();

                hubiMsg2.setMosno("860083641");
                hubiMsg2.setRenno(2);
                hubiMsg2.setHubimsg("ペーパーレス取扱報告書が到着していません。");
                hubiMsg2.setHubisyubetukbn(C_HubisyubetuKbn.WARNING);
                hubiMsg2.setHituyousyoruicd(C_SyoruiCdKbn.SK_DAISANSYAUKTHOUSYO);
                hubiMsg2.setGyoumuKousinsyaId("user001");
                hubiMsg2.setGyoumuKousinTime("20160217133124350");
                hubiMsgList.add(hubiMsg2);
            }

            pMp.setListHubiMsg(hubiMsgList);
            return;
        }

        super.exec(pKetsrhkosKbn, pSyoruiCdKbn, pMessage, pMp, pTknKbn, pMsgKbn);
    }

    @Override
    public void exec(C_KetsrhkosKbn pKetsrhkosKbn,
        C_SpKeisanKahiKbn pSpKeisanKahiKbn,
        C_HubisyubetusyousaiKbn pHubisyubetusyousaiKbn,
        C_SyoruiCdKbn pSyoruiCdKbn,
        String pMessage,
        MosnaiCheckParam pMp,
        C_TknKbn pTknKbn,
        C_MsgKbn pMsgKbn) {

        if (caller == HanteiHituyouSyoruiTest_exec.class && TESTPATTERN1.equals(SYORIPTN)) {

            List<HT_HubiMsg> hubiMsgList = pMp.getListHubiMsg();
            HT_HubiMsg hubiMsg = new HT_HubiMsg();
            hubiMsg.setMosno("861110021");
            hubiMsg.setRenno(1);
            hubiMsg.setHubimsg("ペーパーレス申込書兼意向確認書が到着していません。");
            hubiMsg.setHubisyubetukbn(C_HubisyubetuKbn.SRHORYU_HUBI);
            hubiMsg.setHituyousyoruicd(C_SyoruiCdKbn.SK_PPLESSMOSIKOUKAKSYO);
            hubiMsg.setGyoumuKousinsyaId("user001");
            hubiMsg.setGyoumuKousinTime("20160217133124350");
            hubiMsgList.add(hubiMsg);
            pMp.setListHubiMsg(hubiMsgList);
            return;
        }
        else if (caller == HanteiHituyouSyoruiTest_exec.class && TESTPATTERN2.equals(SYORIPTN)) {

            List<HT_HubiMsg> hubiMsgList = pMp.getListHubiMsg();

            if (hubiMsgList.size() == 0) {
                HT_HubiMsg hubiMsg1 = new HT_HubiMsg();
                hubiMsg1.setMosno("860083658");
                hubiMsg1.setRenno(1);
                hubiMsg1.setHubimsg("ペーパーレス取扱報告書が到着していません。");
                hubiMsg1.setHubisyubetukbn(C_HubisyubetuKbn.WARNING);
                hubiMsg1.setHituyousyoruicd(C_SyoruiCdKbn.SK_UKTJIZENSYOUKAI);
                hubiMsg1.setGyoumuKousinsyaId("user001");
                hubiMsg1.setGyoumuKousinTime("20160217133124350");
                hubiMsgList.add(hubiMsg1);

            } else {
                HT_HubiMsg hubiMsg2 = new HT_HubiMsg();

                hubiMsg2.setMosno("860083658");
                hubiMsg2.setRenno(2);
                hubiMsg2.setHubimsg("ペーパーレス取扱報告書が到着していません。");
                hubiMsg2.setHubisyubetukbn(C_HubisyubetuKbn.WARNING);
                hubiMsg2.setHituyousyoruicd(C_SyoruiCdKbn.SK_DAISANSYAUKTHOUSYO);
                hubiMsg2.setGyoumuKousinsyaId("user001");
                hubiMsg2.setGyoumuKousinTime("20160217133124350");
                hubiMsgList.add(hubiMsg2);
            }

            pMp.setListHubiMsg(hubiMsgList);
            return;
        }

        super.exec(pKetsrhkosKbn,
            pSpKeisanKahiKbn,
            pHubisyubetusyousaiKbn,
            pSyoruiCdKbn,
            pMessage,
            pMp,
            pTknKbn,
            pMsgKbn) ;

    }

}