package yuyu.infrext.mq;

/**
 * MQ緊急停止状態更新のバッチクラスです。
 */
public class MqControlSignalReceiveConstants {


    static final String MsgType = "DG";

    static final int ServerTypeStart = 4;

    static final int ServerTypeEnd = 8;

    static final String SyncType = "NS";

    static final String TruncType = "TE";

    static final int LimitTime = 120;

    static final int retryKaisuu = 90;

    static final int MsgInfoStart = 36;

    static final int MsgInfoEnd = 40;

    static final String StartMsg = "XC08";

    static final String EndMsg = "XC09";

    static final String HostNameMojisuu = "８";

    static final String ServerTypeBf01 = "BF01";

    static final String ServerTypeBf02 = "BF02";

    static final int SameResult = 0;

    static final int DifferentResult = 1;

    static final int RC_NORMAL = 0;

    static final int RC_TIMEOUT = 20;

    static final int RC_END_MESSAGE = 30;

    static final int RC_ERR_DATA = 110;

    static final int RC_ERR_SIGNAL_RECEIVE = 120;

    static final int RC_ERR_MQI = 130;

}
