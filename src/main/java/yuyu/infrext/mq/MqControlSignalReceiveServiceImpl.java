package yuyu.infrext.mq;

import javax.inject.Inject;

import yuyu.def.classification.C_MqOnlineStatusKbn;

public class MqControlSignalReceiveServiceImpl implements MqControlSignalReceiveService {


    @Inject
    private MqControlSignalReceive MqCntrlSgnlRcv;

    @Override
    public void execMqOnlineStartSignalReceive(){

        C_MqOnlineStatusKbn MqOnlineStatus = C_MqOnlineStatusKbn.MQONLINE_KA;

        MqCntrlSgnlRcv.excCntrlSgnlRcv(MqOnlineStatus);
    }

    @Override
    public void execMqOnlineEndSignalReceive(){

        C_MqOnlineStatusKbn MqOnlineStatus = C_MqOnlineStatusKbn.MQONLINE_HUKA;

        MqCntrlSgnlRcv.excCntrlSgnlRcv(MqOnlineStatus);
    }
}
