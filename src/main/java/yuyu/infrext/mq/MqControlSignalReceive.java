package yuyu.infrext.mq;

import java.net.InetAddress;
import java.net.UnknownHostException;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.acs.mqi.api.ACSMqAPI;
import jp.co.slcs.acs.mqi.api.bean.MqapiBean;
import jp.co.slcs.acs.mqi.api.bean.RecvDataBean;
import jp.co.slcs.swak.bizinfr.exception.BizAppException;
import jp.co.slcs.swak.util.message.MessageUtil;

import org.slf4j.Logger;

import yuyu.def.MessageId;
import yuyu.def.classification.C_MqOnlineStatusKbn;
import yuyu.def.db.entity.AT_MqInfo;

public class MqControlSignalReceive {

    @Inject
    private static Logger logger;

    @Inject
    private MqApiFactory mqApiFty;

    @Inject
    private MqControlSignalReceiveDao mqCntrlSgnlRcvDao;

    MqControlSignalReceive(){
    }

    @Transactional
    public void excCntrlSgnlRcv(C_MqOnlineStatusKbn pMqOnlineStatus) {

        logger.info("ＭＱ制御信号受信処理を開始します。");

        chkParam(pMqOnlineStatus);

        String serverType = getServerType();

        int result = getOnlineStatus(serverType, pMqOnlineStatus);

        if(result == -1){

            logger.debug("MQ情報テーブルの参照がタイムアウトしたため正常終了させる");

            logger.info("ＭＱ制御信号受信処理を終了します。");

            return;
        }

        if(result == MqControlSignalReceiveConstants.SameResult){

            logger.debug("MQ情報テーブルのMQオンライン状態と引数のMQオンライン状態が同じため処理が正常終了");

            logger.info("ＭＱ制御信号受信処理を終了します。");

            return;
        }

        logger.debug("MQ情報テーブルのMQオンライン状態と引数のMQオンライン状態が異なるため処理を継続");

        try {

            C_MqOnlineStatusKbn WK_MqOnlineStatus = getRecvData(serverType);

            logger.debug("受信データから取得したMQオンライン状態（WK_MqOnlineStatus） = " + WK_MqOnlineStatus);

            String serverTypeShort = serverType.substring(0, 2);

            if(serverTypeShort.equals("AP")){

                updateDb(serverType,WK_MqOnlineStatus);

            } else {

                updateDb("BF01",WK_MqOnlineStatus);

                updateDb("BF02",WK_MqOnlineStatus);
            }

        }catch(Exception e){

            throw new BizAppException("MQ制御信号受信処理でエラーが発生しました。");

        }
        logger.info("ＭＱ制御信号受信処理を終了します。");
    }

    private void chkParam(C_MqOnlineStatusKbn pMqOnlineStatus) {

        logger.debug("引数のMQオンライン状態区分のチェック開始");

        if(pMqOnlineStatus == null) {
            throw new BizAppException(MessageUtil.getMessage(MessageId.EAF1009,
                MessageUtil.getMessage(MessageId.IAW1009)));
        }
    }

    private String getServerType() {

        logger.debug("ホスト名からサーバ種別の取得を開始");

        String serverType = null;
        try{
            serverType = InetAddress.getLocalHost().getHostName().substring(
                MqControlSignalReceiveConstants.ServerTypeStart,
                MqControlSignalReceiveConstants.ServerTypeEnd);
        }
        catch(UnknownHostException e){

            throw new BizAppException(e,"");
        }

        logger.debug("サーバ種別 = " + serverType);

        return serverType;
    }


    private int getOnlineStatus(String pServerType,C_MqOnlineStatusKbn pMqOnlineStatus) {

        logger.debug("MQオンライン状態チェック処理を開始");

        int result = 0;

        String selectResult = null;

        try{

            selectResult = mqCntrlSgnlRcvDao.getMqOnlineStatus(pServerType);

        }  catch(NullPointerException e){

            logger.debug("ＭＱオンライン状態がnull");

            String tblName = new AT_MqInfo().getViewName();

            throw new BizAppException(MessageUtil.getMessage(MessageId.EAF1011,
                MessageUtil.getMessage(MessageId.IAW1004) ,tblName));

        }

        if(selectResult.equals("error")){

            return -1;
        }

        logger.debug("select結果（MQオンライン状態）_更新前 = " + selectResult);

        logger.debug("引数の値確認（pMqOnlineStatus.getValue()）= " + pMqOnlineStatus.getValue());

        if(selectResult.equals(pMqOnlineStatus.getValue()) ) {

            result = MqControlSignalReceiveConstants.SameResult;

        }else{

            result = MqControlSignalReceiveConstants.DifferentResult;
        }

        logger.debug("比較結果（0：同じ、1：異なる）= " + result);

        return result;
    }


    private C_MqOnlineStatusKbn getRecvData(String pServerType) {

        logger.debug("ディレード受信キューからのデータ取得開始");

        MqapiBean MqapiBean = new MqapiBean();

        MqapiBean.setMsg_type(MqControlSignalReceiveConstants.MsgType);

        String rkmAtesaki = mqCntrlSgnlRcvDao.getRkmAtesaki(pServerType);

        MqapiBean.setCoop_based(rkmAtesaki);

        RecvDataBean rdb = new RecvDataBean();

        MqapiBean.setRecv_data_ptr(rdb);

        MqapiBean.setSync_type(MqControlSignalReceiveConstants.SyncType);

        MqapiBean.setTrunc_type(MqControlSignalReceiveConstants.TruncType);

        MqapiBean.setLimit_time(MqControlSignalReceiveConstants.LimitTime);


        int result = 0;

        for(int i = 0; i < MqControlSignalReceiveConstants.retryKaisuu;) {

            ACSMqAPI acsMqApi = mqApiFty.create();
            result = acsMqApi.receiveMq(MqapiBean);

            if(result == MqControlSignalReceiveConstants.RC_TIMEOUT){

                logger.debug("アイドル防止用のSQL実行");

                mqCntrlSgnlRcvDao.getMqOnlineStatus(pServerType);

                i++;

                logger.debug(String.valueOf(i) + "回目完了");

            }else{
                break;
            }
        }

        logger.debug("ディレード受信キューからの受信データ取得結果 = " + result);

        if(result != MqControlSignalReceiveConstants.RC_NORMAL){
            if(result == MqControlSignalReceiveConstants.RC_TIMEOUT){

                throw new BizAppException(MessageUtil.getMessage(MessageId.EAF1016,
                    MessageUtil.getMessage(MessageId.IAW1024),
                    MessageUtil.getMessage(MessageId.IAW1025)));

            }else if(result == MqControlSignalReceiveConstants.RC_END_MESSAGE){

                throw new BizAppException(MessageUtil.getMessage(MessageId.EAF1016,
                    MessageUtil.getMessage(MessageId.IAW1024),
                    MessageUtil.getMessage(MessageId.IAW1026)));

            }else if(result == MqControlSignalReceiveConstants.RC_ERR_DATA){

                throw new BizAppException(MessageUtil.getMessage(MessageId.EAF1016,
                    MessageUtil.getMessage(MessageId.IAW1024),
                    MessageUtil.getMessage(MessageId.IAW1020)));

            }else if(result == MqControlSignalReceiveConstants.RC_ERR_SIGNAL_RECEIVE){

                throw new BizAppException(MessageUtil.getMessage(MessageId.EAF1016,
                    MessageUtil.getMessage(MessageId.IAW1024),
                    MessageUtil.getMessage(MessageId.IAW1027)));

            }else if(result == MqControlSignalReceiveConstants.RC_ERR_MQI){

                throw new BizAppException(MessageUtil.getMessage(MessageId.EAF1016,
                    MessageUtil.getMessage(MessageId.IAW1024),
                    MessageUtil.getMessage(MessageId.IAW1021)));

            }else{

                throw new BizAppException(MessageUtil.getMessage(MessageId.EAF1016,
                    MessageUtil.getMessage(MessageId.IAW1024),
                    MessageUtil.getMessage(MessageId.IAW1022)));
            }
        }

        RecvDataBean recvData = MqapiBean.getRecv_data_ptr();

        String userData = recvData.getUserData();

        String Message = userData.substring(MqControlSignalReceiveConstants.MsgInfoStart,
            MqControlSignalReceiveConstants.MsgInfoEnd);

        logger.debug("通知信号 = " + Message);

        if(Message.equals(MqControlSignalReceiveConstants.StartMsg)){

            return C_MqOnlineStatusKbn.MQONLINE_KA;

        }else if(Message.equals(MqControlSignalReceiveConstants.EndMsg)){

            return C_MqOnlineStatusKbn.MQONLINE_HUKA;

        }else{

            throw new BizAppException(MessageUtil.getMessage(MessageId.EAF1017));
        }
    }


    private void updateDb(String pServerType, C_MqOnlineStatusKbn pMqOnlineStatus) {

        logger.debug("DB更新処理を実施");

        logger.debug("更新ためのMQオンライン状態（pMqOnlineStatus.getValue()） = " + pMqOnlineStatus.getValue());

        mqCntrlSgnlRcvDao.updateMqOnlineStatus(pServerType, pMqOnlineStatus.getValue());

        logger.debug("DB更新処理完了");

    }
}

