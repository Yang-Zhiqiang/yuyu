
package yuyu.infrext.mq;

/**
 * mqTest の定数定義クラスです。<br />
 */
public class MqApiConstants {

    public static final String AtesakiCd = "XCXCXXXX";

    public static final char BlkYobi = ' ';

    public static final byte[] MsgSyubetu = {(byte)0xC0};

    public static final byte[] flg = {0x00};

    public static final byte[] TanmatuType_batch = {0x53};

    public static final byte[] TanmatuType_syanai = {0x51};

    public static final byte[] TanmatuType_syagai = {0x50};

    public static final String ContextPath_syanai = "/ray/";

    public static final String ContextPath_ag = "/ray_ag/";

    public static final String ContextPath_ds = "/ray_ds/";

    public static final String ButuriSosikiCod = "       ";

    public static final String Yobi1 = "  ";

    public static final String Yobi2 = "  ";

    public static final byte[] seqNo = {0x00,0x00,0x00,0x00};

    public static final byte[] jyokyoFlg = {0x00};

    public static final byte[] tmJyotaiHyoji = {0x00};

    public static final byte[] prtInfoSeqNo = {0x00,0x00};

    public static final byte[] prtCon = {0x00,0x00};

    public static final char msgKbn = ' ';

    public static final String torikesiKye = "       ";

    public static final byte[] kaiwaId = {0x00,0x00,0x00,0x00};

    public static final String Yobi3 = "  ";

    public static final String rdrtIpAdress = "0.0.0.0";


    public static final String batchSV1 = "BF01";

    public static final String batchSV2 = "BF02";

    public static final String onlineSV1 = "AP01";

    public static final String onlineSV2 = "AP02";

    public static final String onlineSV3 = "AP03";

    public static final String rkmAtesaki_OLSV1 = "Z8100000";
    public static final String rkmAtesaki_OLSV2 = "Z8200000";
    public static final String rkmAtesaki_OLSV3 = "Z8300000";
    public static final String rkmAtesaki_BTSV  = "Z8400000";

    public static final String rksAtesaki  = "XCZ01000";

    public static final String systemCntrlInfoKey = "ctrlInfo";


    public static final String Mq_NotPer = "NP";
    public static final String Mq_Per = "PR";

    public static final int mqOnlineTime = 10;

    public static final int maxSendTimes = 4;

    public static final int acsHeadLength = 96;

    public static final String syanaiMsg = "社内";

    public static final String agMsg = "代理店";

    public static final String dsMsg = "ＤＳ";

    public static final String batchSyori = "バッチ処理";

    public static final String operatorIdYobi = "         ";



    public static final int MQ_RC_NORMAL = 0;

    public static final int MQ_RC_TRUNCATE = 10;

    public static final int MQ_RC_TIMEOUT = 20;

    public static final int MQ_RC_END = 30;

    public static final int MQ_RC_ERROR_DATA = 110;

    public static final int MQ_RC_ERROR_CONN  = 120;

    public static final int MQ_RC_ERROR_API  = 130;

    public static final int MQ_RC_NO_CONNECT  = 140;



    public static final int noBlkLU  = 0x1111;

    public static final int takeOver  = 0x0f15;

    public static final int lineCont  = 0x0872;

    public static final int faildSendData  = 0x1140;

    public static final int noEnableLU  = 0x1112;

    public static final int cancelResv = 0x1113;

    public static final int errReplyInTakeOver = 0x1119;

    public static final int SSCPSessionTroble = 0x0a32;

    public static final int dataLinkTroble = 0x0a31;

    public static final int noResponse = 0x0822;

    public static final int abendDuringProcessing_1 = 0x022b;

    public static final int abendDuringProcessing_2 = 0x0ace;

    public static final int inputTranStop = 0x0041;

    public static final int stopRegion_1 = 0x09e5;

    public static final int stopRegion_2 = 0x09e1;

    public static final int afterCheInputTran = 0x004f;

    public static final int seqNoError = 0x07fd;

    public static final int codeError = 0x0040;

    public static final int LengthOver = 0x01bc;

    public static final int multiChainInputTran = 0x0a11;

    public static final int snaSeq = 0x1130;


    public static final String noBlkLUMsg  = "空きLUなし";

    public static final String takeOverMsg = "TAKEOVER";

    public static final String lineContMsg  = "回答とのコンテンション";

    public static final String faildSendDataMsg  = "上り電文送信失敗";

    public static final String noEnableLUMsg  = "使用可能ＬＵなし";

    public static final String cancelResvMsg = "CANCEL受信";

    public static final String errReplyInTakeOverMsg = "テイクオーバー中エラー応答";

    public static final String SSCPSessionTrobleMsg = "SSCPセッション異常";

    public static final String dataLinkTrobleMsg = "データリンク異常";

    public static final String noResponseMsg = "入力に対し回答なし";

    public static final String abendDuringProcessingMsg_1 = "トランザクション処理中にABEND";

    public static final String abendDuringProcessingMsg_2 = "トランザクション処理中にABEND";

    public static final String inputTranStopMsg = "IMS上入力TRANがSTOP状態";

    public static final String stopRegionMsg_1 = "REGION停止中";

    public static final String stopRegionMsg_2 = "REGION停止中";

    public static final String afterCheInputTranMsg = "CHE後TRANが入力された";

    public static final String seqNoErrorMsg = "入力TRAN Seq-Noエラー";

    public static final String codeErrorMsg = "入力TRAN コードエラー";

    public static final String LengthOverMsg = "LENGTH OVER";

    public static final String multiChainInputTranMsg = "複数チェインのTRAN入力";

    public static final String snaSeqMsg = "SNAシーケンス";

    public static final String unexpectedMsg = "想定外";


    public static final int mqSyoriFunou = 1;

    public static final int mqSyoriErr = 2;

    public static final int mqEmgcyStop = 3;

    public static final int mqOnlineEnd = 0;

    public static final int mqOnlineStart = 1;

    public static final int mqEmgcyStop_Start = 0;

    public static final int mqEmgcyStop_End = 1;


}
