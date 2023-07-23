package yuyu.infrext.mq;

import javax.inject.Inject;

import org.slf4j.Logger;

import yuyu.def.classification.C_MqConnectionControlKbn;

public class MqConnectionControlServiceImpl implements MqConnectionControlService {

    @Inject
    private static Logger logger;

    @Inject
    public MqConnectionControl MqConnCtrl;

    @Override
    public void execMqConn(){

        C_MqConnectionControlKbn MqStartEndKbn = C_MqConnectionControlKbn.START;

        logger.debug("MqStartEndKbn = " + MqStartEndKbn);

        MqConnCtrl.excStartEnd(MqStartEndKbn);
    }

    @Override
    public void execMqDisConn(){

        C_MqConnectionControlKbn MqStartEndKbn = C_MqConnectionControlKbn.END;

        logger.debug("MqStartEndKbn = " + MqStartEndKbn);

        MqConnCtrl.excStartEnd(MqStartEndKbn);
    }
}
