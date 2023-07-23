package yuyu.infrext.mq;

import java.net.InetAddress;
import java.net.UnknownHostException;

import javax.inject.Inject;

import jp.co.slcs.acs.mqi.api.ACSMqAPI;
import jp.co.slcs.acs.mqi.api.bean.MqapiBean;
import jp.co.slcs.swak.bizinfr.exception.BizAppException;
import jp.co.slcs.swak.util.message.MessageUtil;

import org.slf4j.Logger;

import yuyu.def.MessageId;
import yuyu.def.classification.C_MqConnectionControlKbn;
import yuyu.def.db.entity.AT_MqInfo;

/**
 * ＭＱコネクション制御のロジックです。
 */
public class MqConnectionControl {

    @Inject
    private static Logger logger;

    @Inject
    private MqApiCallerDao mqDao;

    @Inject
    private MqApiFactory mqApiFty;


    MqConnectionControl(){
    }

    public void excStartEnd(C_MqConnectionControlKbn pMqConnectionControlKbn){

        logger.info("ＭＱコネクション制御処理を開始します。");

        if(pMqConnectionControlKbn == null){

            throw new BizAppException(MessageUtil.getMessage(MessageId.EAF1009,
                MessageUtil.getMessage(MessageId.IAW1014)));
        }

        if(pMqConnectionControlKbn.equals(C_MqConnectionControlKbn.START)){

            logger.info("ＭＱＡＰＩとＭＱ間のコネクション接続処理を開始します。");

            startMq();

            logger.info("ＭＱＡＰＩとＭＱ間のコネクション接続処理を終了します。");

        } else {

            logger.info("ＭＱＡＰＩとＭＱ間のコネクション切断処理を開始します。");

            endMq();

            logger.info("ＭＱＡＰＩとＭＱ間のコネクション切断処理を終了します。");
        }
        logger.info("ＭＱコネクション制御処理を終了します。");
    }


    private void startMq(){

        logger.debug("送信キュー開始処理を実行");

        int strResult = startSendMq();

        logger.debug("送信キュー開始処理結果 = " + strResult);

        if(strResult != MqConnectionControlConstants.RC_NORMAL){

            endMq();

            if(strResult == MqConnectionControlConstants.RC_ERR_DATA){

                throw new BizAppException(MessageUtil.getMessage(MessageId.EAF1018,
                    MessageUtil.getMessage(MessageId.IAW1015),
                    MessageUtil.getMessage(MessageId.IAW1018),
                    MessageUtil.getMessage(MessageId.IAW1020)));

            }else if(strResult == MqConnectionControlConstants.RC_ERR_MQI){

                throw new BizAppException(MessageUtil.getMessage(MessageId.EAF1018,
                    MessageUtil.getMessage(MessageId.IAW1015),
                    MessageUtil.getMessage(MessageId.IAW1018),
                    MessageUtil.getMessage(MessageId.IAW1021)));

            }else{

                throw new BizAppException(MessageUtil.getMessage(MessageId.EAF1018,
                    MessageUtil.getMessage(MessageId.IAW1015),
                    MessageUtil.getMessage(MessageId.IAW1018),
                    MessageUtil.getMessage(MessageId.IAW1022)));
            }
        }

        logger.debug("受信キュー開始処理を実行");

        int rcvResult = startRecvMq(MqConnectionControlConstants.RECVMQ_MSG_TYPE);

        logger.debug("受信キュー開始処理結果 = " + rcvResult);

        if(rcvResult != MqConnectionControlConstants.RC_NORMAL){

            endMq();

            if(rcvResult == MqConnectionControlConstants.RC_ERR_DATA){

                throw new BizAppException(MessageUtil.getMessage(MessageId.EAF1018,
                    MessageUtil.getMessage(MessageId.IAW1016),
                    MessageUtil.getMessage(MessageId.IAW1018),
                    MessageUtil.getMessage(MessageId.IAW1020)));

            }else if(rcvResult == MqConnectionControlConstants.RC_ERR_MQI){

                throw new BizAppException(MessageUtil.getMessage(MessageId.EAF1018,
                    MessageUtil.getMessage(MessageId.IAW1016),
                    MessageUtil.getMessage(MessageId.IAW1018),
                    MessageUtil.getMessage(MessageId.IAW1021)));

            }else{
                throw new BizAppException(MessageUtil.getMessage(MessageId.EAF1018,
                    MessageUtil.getMessage(MessageId.IAW1016),
                    MessageUtil.getMessage(MessageId.IAW1018),
                    MessageUtil.getMessage(MessageId.IAW1022)));
            }
        }

        logger.debug("ディレード受信キュー開始処理を実行");

        int derayedRcvResult = startRecvMq(MqConnectionControlConstants.DELAYED_RECVMQ_MSG_TYPE);

        logger.debug("ディレード受信キュー開始処理結果 = " + derayedRcvResult);

        if(derayedRcvResult != MqConnectionControlConstants.RC_NORMAL){

            endMq();

            if(derayedRcvResult == MqConnectionControlConstants.RC_ERR_DATA){

                throw new BizAppException(MessageUtil.getMessage(MessageId.EAF1018,
                    MessageUtil.getMessage(MessageId.IAW1017),
                    MessageUtil.getMessage(MessageId.IAW1018),
                    MessageUtil.getMessage(MessageId.IAW1020)));

            }else if(derayedRcvResult == MqConnectionControlConstants.RC_ERR_MQI){

                throw new BizAppException(MessageUtil.getMessage(MessageId.EAF1018,
                    MessageUtil.getMessage(MessageId.IAW1017),
                    MessageUtil.getMessage(MessageId.IAW1018),
                    MessageUtil.getMessage(MessageId.IAW1021)));

            }else{
                throw new BizAppException(MessageUtil.getMessage(MessageId.EAF1018,
                    MessageUtil.getMessage(MessageId.IAW1017),
                    MessageUtil.getMessage(MessageId.IAW1018),
                    MessageUtil.getMessage(MessageId.IAW1022)));
            }
        }
    }


    private int startSendMq(){

        MqapiBean MqapiBean = new MqapiBean();

        MqapiBean.setMsg_type(MqConnectionControlConstants.SENDMQ_MSG_TYPE);

        MqapiBean.setCoop_based(MqConnectionControlConstants.SENDMQ_COOP_BASED);

        ACSMqAPI acsMqApi = mqApiFty.create();

        int sendMqResult = acsMqApi.startMq(MqapiBean);

        return sendMqResult;
    }


    private int startRecvMq(String pMsgType){

        MqapiBean MqapiBean = new MqapiBean();

        MqapiBean.setMsg_type(pMsgType);

        String serverType = null;
        try{
            serverType = InetAddress.getLocalHost().getHostName().substring(4,8);

            logger.debug("サーバ種別 = " + serverType);

        }
        catch(UnknownHostException e){
            throw new BizAppException(e,"");
        }

        AT_MqInfo mqInfo = mqDao.getMqInfo(serverType);

        String rkmAtesaki = mqInfo.getRkmAtesaki();

        MqapiBean.setCoop_based(rkmAtesaki);

        ACSMqAPI acsMqApi = mqApiFty.create();

        int rcvMqResult = acsMqApi.startMq(MqapiBean);

        return rcvMqResult;
    }


    private void endMq(){

        MqapiBean MqapiBean = new MqapiBean();

        ACSMqAPI acsMqApi = mqApiFty.create();

        int endMqResult = acsMqApi.endMq(MqapiBean);

        if(endMqResult != MqConnectionControlConstants.RC_NORMAL){

            if(endMqResult == MqConnectionControlConstants.RC_ERR_DATA){

                throw new BizAppException(MessageUtil.getMessage(MessageId.EAF1016,
                    MessageUtil.getMessage(MessageId.IAW1019),
                    MessageUtil.getMessage(MessageId.IAW1020)));

            }else if(endMqResult == MqConnectionControlConstants.RC_ERR_MQI){

                throw new BizAppException(MessageUtil.getMessage(MessageId.EAF1016,
                    MessageUtil.getMessage(MessageId.IAW1019),
                    MessageUtil.getMessage(MessageId.IAW1021)));

            }else{

                throw new BizAppException(MessageUtil.getMessage(MessageId.EAF1016,
                    MessageUtil.getMessage(MessageId.IAW1019),
                    MessageUtil.getMessage(MessageId.IAW1022)));
            }
        }
    }
}
