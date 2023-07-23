package yuyu.infrext.mq;

import java.io.UnsupportedEncodingException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.nio.ByteBuffer;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import jp.co.slcs.acs.mqi.api.ACSMqAPI;
import jp.co.slcs.acs.mqi.api.bean.MqapiBean;
import jp.co.slcs.acs.mqi.api.bean.RecvDataBean;
import jp.co.slcs.acs.mqi.api.bean.SendDataBean;
import jp.co.slcs.swak.bizinfr.exception.BizAppException;
import jp.co.slcs.swak.core.configuration.CoreConfig;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.uniquekey.UniqueKeyGenerator;
import jp.co.slcs.swak.util.message.MessageUtil;

import org.slf4j.Logger;

import yuyu.common.base.BaseUserInfo;
import yuyu.def.MessageId;
import yuyu.def.classification.C_MqEmgcyStopStatusKbn;
import yuyu.def.classification.C_MqOnlineStatusKbn;
import yuyu.def.db.dao.AT_SystemControlInfoDao;
import yuyu.def.db.entity.AT_MqInfo;
import yuyu.def.db.entity.AT_SystemControlInfo;
import yuyu.infrext.exception.MqFailedException;


/**
 * ＭＱＡＰＩ呼出基盤 のロジックです。
 */
public class MqApiCallerImpl {

    @Inject
    private static Logger logger;

    @Inject
    private BaseUserInfo userinfo;

    @Inject
    private RayWebServiceAuthInfo webAuthInfo;

    @Inject
    private MqApiCallerDao mqDao;

    @Inject
    private AT_SystemControlInfoDao systemCtrlDao;

    MqApiCallerImpl(){
    }


    String call(String SyoriCd, String UserData, String SosikiCd, String OperatorId){

        logger.debug("MQAPI呼出基盤（バッチ用）の開始");

        logger.debug("引数（処理コード）     = " + SyoriCd);

        logger.debug("引数（ユーザデータ）   = " + UserData);

        logger.debug("引数（組織コード）     = " + SosikiCd);

        logger.debug("引数（オペレータＩＤ） = " + OperatorId);

        chkMqOnline();

        chkMqEmgcyStop();

        chkDataLength(UserData);

        String wk_SyoriCd = SyoriCd;
        String wk_UserData = UserData;
        String wk_SosikiCd = SosikiCd;
        String wk_OperatorId = OperatorId;

        String SendData = sendDataCreate(wk_SyoriCd, wk_UserData, wk_SosikiCd, wk_OperatorId);

        MqapiBean wk_mqapiBean = sendDataSet(SendData);

        int SendTimes = 0;
        MqapiBean wk_SendRecvData = dataSendRecv(wk_mqapiBean,SendTimes);

        String wk_RecvData = recvDataGet(wk_SendRecvData);

        String wk_userData = userDataGet(wk_RecvData);

        return wk_userData;
    }

    String call(String SyoriCd, String UserData){

        logger.debug("MQAPI呼出基盤（Webサービス、オンライン用）の開始");

        logger.debug("引数（処理コード）   = " + SyoriCd);

        logger.debug("引数（ユーザデータ） = " + UserData);

        chkMqOnline();

        chkMqEmgcyStop();

        chkDataLength(UserData);

        String wk_SyoriCd = SyoriCd;
        String wk_UserData = UserData;
        String wk_SosikiCd;
        String wk_OperatorId;

        if( webAuthInfo.getSosikiCd() != null  || webAuthInfo.getOperatorId() != null){
            wk_SosikiCd = webAuthInfo.getSosikiCd();

            wk_OperatorId = webAuthInfo.getOperatorId() + MqApiConstants.operatorIdYobi;

            wk_OperatorId = wk_OperatorId.substring(0, 20);

            logger.debug("社外系のオペレータＩＤ情報（元のまま）の長さ =" + webAuthInfo.getOperatorId().length());

            logger.debug("社外系のオペレータＩＤ情報 (ブランク追加後）= " + wk_OperatorId);

            logger.debug("社外系のオペレータＩＤ情報 (ブランク追加後）の長さ = " + wk_OperatorId.length());

        }else{
            wk_SosikiCd = userinfo.getTmSosikiCd();
            wk_OperatorId = userinfo.getIdKind() +
                userinfo.getPersonCd() +
                userinfo.getIssueNum() +
                userinfo.getPcCd() +
                MqApiConstants.operatorIdYobi;

            logger.debug("社内系のオペレータＩＤ情報 = " + wk_OperatorId);

        }

        String SendData = sendDataCreate(wk_SyoriCd, wk_UserData, wk_SosikiCd, wk_OperatorId);

        MqapiBean wk_mqapiBean = sendDataSet(SendData);

        int SendTimes = 1;
        MqapiBean wk_SendRecvData = dataSendRecv(wk_mqapiBean,SendTimes);

        String wk_RecvData = recvDataGet(wk_SendRecvData);

        String wk_userData = userDataGet(wk_RecvData);

        return wk_userData;
    }

    private void chkMqOnline() {

        logger.debug("MQオンライン状態チェック処理開始");

        String wk_hostname = null;

        try{
            wk_hostname = InetAddress.getLocalHost().getHostName().substring(4,8);
        }
        catch(UnknownHostException e){

            throw new BizAppException(e,"");
        }

        logger.debug("wk_hostname（サーバ種別） = " + wk_hostname );

        AT_MqInfo mqInfo = mqDao.getMqInfo(wk_hostname);

        logger.debug("MQ情報テーブル取得結果 = " + mqInfo );

        if (mqInfo.getMqOnlineStatus().eq(C_MqOnlineStatusKbn.MQONLINE_HUKA)){

            logger.info(MessageUtil.getMessage(MessageId.IAF1001));

            throw new MqFailedException(MqApiConstants.mqSyoriFunou);
        }

        logger.debug("MQオンライン状態チェック処理終了");
    }


    private void chkMqEmgcyStop() {

        logger.debug("MQ緊急停止状態チェック処理開始");

        AT_SystemControlInfo ctrlInfo = systemCtrlDao.getSystemControlInfo(MqApiConstants.systemCntrlInfoKey);

        logger.debug("コントロール制御テーブルの取得結果 = " + ctrlInfo );

        logger.debug("コントロール制御テーブルの緊急停止状態 = " + ctrlInfo.getMqEmgcyStopStatus());

        if(ctrlInfo.getMqEmgcyStopStatus().eq(C_MqEmgcyStopStatusKbn.MQEMGCYSTOP_START)){

            logger.info(MessageUtil.getMessage(MessageId.IAF1002));

            throw new MqFailedException(MqApiConstants.mqEmgcyStop);
        }

        logger.debug("MQ緊急停止状態チェック処理終了");
    }


    private void chkDataLength(String userData) {

        logger.debug("データレングスチェック処理開始");

        logger.debug("引数（ユーザデータ）       = " + userData);

        logger.debug("引数（ユーザデータ）の長さ = " + userData.length());

        try{

            logger.debug("引数（ユーザデータ）のバイト化後の長さ = " + userData.getBytes("Cp930"));

            if(userData.getBytes("Cp930").length > 3800){
                if(CoreConfig.getInstance().isBatchProduct()){

                    logger.error(MessageUtil.getMessage(MessageId.EAF1001,
                        Integer.toString(userData.getBytes("Cp930").length),
                        MqApiConstants.batchSyori));
                }else{

                    logger.debug("Webサービス、オンライン処理の場合");

                    HttpServletRequest request = SWAKInjector.getInstance(HttpServletRequest.class);
                    String uri = request.getRequestURI();

                    logger.debug("取得したURI                    = " + uri);

                    logger.debug("コンテキストパスの取得内容確認 = " + request.getContextPath());

                    if(!uri.equals(null)){
                        if(uri.indexOf(MqApiConstants.ContextPath_syanai) != -1){
                            logger.error(MessageUtil.getMessage(MessageId.EAF1001,
                                Integer.toString(userData.length()),
                                MqApiConstants.syanaiMsg));

                        }else if(uri.indexOf(MqApiConstants.ContextPath_ag) != -1){
                            logger.error(MessageUtil.getMessage(MessageId.EAF1001,
                                Integer.toString(userData.length()),
                                MqApiConstants.agMsg));

                        }else if(uri.indexOf(MqApiConstants.ContextPath_ds) != -1){
                            logger.error(MessageUtil.getMessage(MessageId.EAF1001,
                                Integer.toString(userData.length()),
                                MqApiConstants.dsMsg));
                        }
                    }
                }
                throw new MqFailedException(MqApiConstants.mqSyoriFunou);
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        logger.debug("データレングスチェック処理終了");
    }


    private String sendDataCreate(String SyoriCd, String UserData, String SosikiCd, String OperatorId) {

        logger.debug("送信データ作成処理開始");

        logger.debug("引数（処理コード）     = " + SyoriCd);

        logger.debug("引数（ユーザデータ）   = " + UserData);

        logger.debug("引数（組織コード）     = " + SosikiCd);

        logger.debug("引数（オペレータＩＤ） = " + OperatorId);

        StringBuffer wk_UserData = new StringBuffer();

        wk_UserData.append(MqApiConstants.AtesakiCd);

        wk_UserData.append(MqApiConstants.BlkYobi);

        String strMsgSyubetu;
        try {
            strMsgSyubetu = new String(MqApiConstants.MsgSyubetu,"Cp930");
            logger.debug("strMsgSyubetu = " + strMsgSyubetu);
            wk_UserData.append(strMsgSyubetu);
        } catch (UnsupportedEncodingException e1) {
            e1.printStackTrace();
        }

        wk_UserData.append(new String(MqApiConstants.flg));

        try {
            if(CoreConfig.getInstance().isBatchProduct()){
                wk_UserData.append(new String(MqApiConstants.TanmatuType_batch,"Cp930"));
            }else{
                HttpServletRequest request = SWAKInjector.getInstance(HttpServletRequest.class);
                String uri = request.getRequestURI();

                logger.debug("取得したURI                    = " + uri);

                logger.debug("コンテキストパスの取得内容確認 = " + request.getContextPath());

                if(!uri.equals(null)){
                    if(uri.indexOf(MqApiConstants.ContextPath_syanai) != -1){
                        wk_UserData.append(new String(MqApiConstants.TanmatuType_syanai,"Cp930"));
                    }else{
                        wk_UserData.append(new String(MqApiConstants.TanmatuType_syagai,"Cp930"));
                    }
                }
            }
        } catch (UnsupportedEncodingException e1) {
            e1.printStackTrace();
        }

        wk_UserData.append(MqApiConstants.ButuriSosikiCod);

        wk_UserData.append(MqApiConstants.Yobi1);

        wk_UserData.append(SosikiCd);

        wk_UserData.append(MqApiConstants.Yobi2);

        wk_UserData.append(BizDate.getSysDate().toString().substring(2,8));

        wk_UserData.append(SyoriCd);

        wk_UserData.append(OperatorId);

        wk_UserData.append(new String(MqApiConstants.seqNo));

        wk_UserData.append(new String(MqApiConstants.jyokyoFlg));

        wk_UserData.append(new String(MqApiConstants.tmJyotaiHyoji));

        wk_UserData.append(new String(MqApiConstants.prtInfoSeqNo));

        String wk_RkmAtesaki = getRkmAtesaki();

        wk_UserData.append(wk_RkmAtesaki);

        wk_UserData.append(new String(MqApiConstants.prtCon));

        wk_UserData.append(MqApiConstants.msgKbn);

        wk_UserData.append(MqApiConstants.torikesiKye);

        wk_UserData.append(new String(MqApiConstants.kaiwaId));

        wk_UserData.append(MqApiConstants.Yobi3);

        try {
            String wk_rdrtIpAdress = MqApiConstants.rdrtIpAdress;

            byte wk_ipAddress[] = InetAddress.getByName(wk_rdrtIpAdress).getAddress();

            logger.debug("wk_ipAddress[0] = " + wk_ipAddress[0]);
            logger.debug("wk_ipAddress[1] = " + wk_ipAddress[1]);
            logger.debug("wk_ipAddress[2] = " + wk_ipAddress[2]);
            logger.debug("wk_ipAddress[3] = " + wk_ipAddress[3]);

            wk_UserData.append(new String(wk_ipAddress));

        } catch (UnknownHostException e) {
            throw new BizAppException(e,"");
        }

        logger.debug("送信データの長さ(ACSヘッダのみ） = " + wk_UserData.toString().length());
        logger.debug("送信データ（ACSヘッダのみ）      = " + wk_UserData.toString());


        wk_UserData.append(UserData);

        logger.debug("送信データの長さ = " + wk_UserData.toString().length());
        logger.debug("送信データ       = " + wk_UserData.toString());

        logger.debug("送信データ作成処理終了");

        return wk_UserData.toString();
    }


    private MqapiBean sendDataSet(String sendData) {

        logger.debug("送信データセット処理開始");

        logger.debug("引数（送信データ）= " + sendData);

        MqapiBean wk_MqapiBean = new MqapiBean();
        SendDataBean sdb = new SendDataBean();
        sdb.setUserData(sendData);
        wk_MqapiBean.setSend_data_ptr(sdb);


        String wk_RkmAtesaki = getRkmAtesaki();

        wk_MqapiBean.setCoop_based(wk_RkmAtesaki);

        wk_MqapiBean.setCoop_dest(MqApiConstants.rksAtesaki);

        wk_MqapiBean.setPer_type(MqApiConstants.Mq_NotPer);

        UniqueKeyGenerator ukg = SWAKInjector.getInstance(UniqueKeyGenerator.class);
        String uKey = ukg.generateUniqueKey();

        logger.debug("uKey = " + uKey);
        logger.debug("uKey.length = " + uKey.length());

        String uKyeForMsgId = uKey.substring(0, 4);

        byte[] msgId = uKyeForMsgId.getBytes();

        wk_MqapiBean.setMsg_id(msgId);

        byte[] newCorrel_id = uKey.getBytes();
        byte[] Correl_id = ByteBuffer.allocate(24).put(newCorrel_id).array();

        logger.debug("newCorrel_id.length = " + newCorrel_id.length);
        logger.debug("Correl_id.length = " + Correl_id.length);

        wk_MqapiBean.setCorrel_id(Correl_id);

        RecvDataBean rcv = new RecvDataBean();
        wk_MqapiBean.setRecv_data_ptr(rcv);

        wk_MqapiBean.setSync_type("NS");

        wk_MqapiBean.setTrunc_type("TE");

        logger.debug("送信データセット処理終了");

        return wk_MqapiBean;
    }

    private MqapiBean dataSendRecv(MqapiBean mqapiBean, int SendTimes) {

        logger.debug("送データ送受信処理開始");

        logger.debug("引数（送信データ）= " + mqapiBean);

        logger.debug("引数（送信回数）  = " + SendTimes);

        int wk_SendTimes = SendTimes;

        MqapiBean bk_MqapiBean = new MqapiBean();
        bk_MqapiBean = mqapiBean;

        ACSMqAPI acsMqApi = ACSMqAPI.getInstance();

        logger.debug("sendReceiveMq開始");

        int result = 0;
        result = acsMqApi.sendReceiveMq(mqapiBean);


        logger.debug("sendReceiveMq終了");


        logger.debug("MQAPI処理(sendReceiveMq)結果 = " + result);

        if(result == MqApiConstants.MQ_RC_NORMAL){

            logger.debug("正常終了時のmqapiBean    = " + mqapiBean);

            return mqapiBean;
        }

        if(result == MqApiConstants.MQ_RC_TIMEOUT){

            logger.error(MessageUtil.getMessage(MessageId.EAF1002));

            throw new MqFailedException(MqApiConstants.mqSyoriErr);

        }else if(result == MqApiConstants.MQ_RC_END){

            logger.error(MessageUtil.getMessage(MessageId.EAF1003));

            throw new MqFailedException(MqApiConstants.mqSyoriErr);

        }else if(result == MqApiConstants.MQ_RC_ERROR_DATA){

            logger.error(MessageUtil.getMessage(MessageId.EAF1004));

            throw new MqFailedException(MqApiConstants.mqSyoriErr);

        }else if(result == MqApiConstants.MQ_RC_ERROR_CONN){

            if(mqapiBean.getReason_code() == MqApiConstants.noBlkLU){

                logger.debug("理由コード(mqapiBean.getReason_code()) = " + mqapiBean.getReason_code());

                logger.warn(MessageUtil.getMessage(MessageId.WAF1001, MqApiConstants.noBlkLUMsg, String.format("0x%04X",mqapiBean.getReason_code())));

                return mqReSend(bk_MqapiBean, wk_SendTimes);

            }else if(mqapiBean.getReason_code() == MqApiConstants.takeOver){

                logger.debug("理由コード(mqapiBean.getReason_code()) = " + mqapiBean.getReason_code());


                logger.warn(MessageUtil.getMessage(MessageId.WAF1001, MqApiConstants.takeOverMsg, String.format("0x%04X",mqapiBean.getReason_code())));

                return mqReSend(bk_MqapiBean, wk_SendTimes);

            }else if(mqapiBean.getReason_code() == MqApiConstants.lineCont){

                logger.debug("理由コード(mqapiBean.getReason_code()) = " + mqapiBean.getReason_code());

                logger.warn(MessageUtil.getMessage(MessageId.WAF1001, MqApiConstants.lineContMsg, String.format("0x%04X",mqapiBean.getReason_code())));

                return mqReSend(bk_MqapiBean, wk_SendTimes);

            }else if(mqapiBean.getReason_code() == MqApiConstants.faildSendData){

                logger.debug("理由コード(mqapiBean.getReason_code()) = " + mqapiBean.getReason_code());

                logger.warn(MessageUtil.getMessage(MessageId.WAF1001, MqApiConstants.faildSendDataMsg, String.format("0x%04X",mqapiBean.getReason_code())));

                return mqReSend(bk_MqapiBean, wk_SendTimes);

            }else if(mqapiBean.getReason_code() == MqApiConstants.noEnableLU){

                logger.debug("理由コード(mqapiBean.getReason_code()) = " + mqapiBean.getReason_code());

                logger.error(MessageUtil.getMessage(MessageId.EAF1005, MqApiConstants.noEnableLUMsg, String.format("0x%04X",mqapiBean.getReason_code())));

                throw new MqFailedException(MqApiConstants.mqSyoriErr);

            }else if(mqapiBean.getReason_code() == MqApiConstants.cancelResv){

                logger.debug("理由コード(mqapiBean.getReason_code()) = " + mqapiBean.getReason_code());

                logger.error(MessageUtil.getMessage(MessageId.EAF1005, MqApiConstants.cancelResvMsg, String.format("0x%04X",mqapiBean.getReason_code())));

                throw new MqFailedException(MqApiConstants.mqSyoriErr);

            }else if(mqapiBean.getReason_code() == MqApiConstants.errReplyInTakeOver){

                logger.debug("理由コード(mqapiBean.getReason_code()) = " + mqapiBean.getReason_code());

                logger.error(MessageUtil.getMessage(MessageId.EAF1005, MqApiConstants.errReplyInTakeOverMsg, String.format("0x%04X",mqapiBean.getReason_code())));

                throw new MqFailedException(MqApiConstants.mqSyoriErr);

            }else if(mqapiBean.getReason_code() == MqApiConstants.SSCPSessionTroble) {

                logger.debug("理由コード(mqapiBean.getReason_code()) = " + mqapiBean.getReason_code());

                logger.error(MessageUtil.getMessage(MessageId.EAF1005, MqApiConstants.SSCPSessionTrobleMsg, String.format("0x%04X",mqapiBean.getReason_code())));

                throw new MqFailedException(MqApiConstants.mqSyoriErr);

            }else if(mqapiBean.getReason_code() == MqApiConstants.dataLinkTroble){

                logger.debug("理由コード(mqapiBean.getReason_code()) = " + mqapiBean.getReason_code());

                logger.error(MessageUtil.getMessage(MessageId.EAF1005, MqApiConstants.dataLinkTrobleMsg, String.format("0x%04X",mqapiBean.getReason_code())));

                throw new MqFailedException(MqApiConstants.mqSyoriErr);

            }else if(mqapiBean.getReason_code() == MqApiConstants.noResponse){

                logger.debug("理由コード(mqapiBean.getReason_code()) = " + mqapiBean.getReason_code());

                logger.error(MessageUtil.getMessage(MessageId.EAF1005, MqApiConstants.noResponseMsg, String.format("0x%04X",mqapiBean.getReason_code())));

                throw new MqFailedException(MqApiConstants.mqSyoriErr);

            }else if(mqapiBean.getReason_code() == MqApiConstants.abendDuringProcessing_1){

                logger.debug("理由コード(mqapiBean.getReason_code()) = " + mqapiBean.getReason_code());

                logger.error(MessageUtil.getMessage(MessageId.EAF1005, MqApiConstants.abendDuringProcessingMsg_1, String.format("0x%04X",mqapiBean.getReason_code())));

                throw new MqFailedException(MqApiConstants.mqSyoriErr);

            }else if(mqapiBean.getReason_code() == MqApiConstants.abendDuringProcessing_2){

                logger.debug("理由コード(mqapiBean.getReason_code()) = " + mqapiBean.getReason_code());

                logger.error(MessageUtil.getMessage(MessageId.EAF1005, MqApiConstants.abendDuringProcessingMsg_2, String.format("0x%04X",mqapiBean.getReason_code())));

                throw new MqFailedException(MqApiConstants.mqSyoriErr);

            }else if(mqapiBean.getReason_code() == MqApiConstants.inputTranStop){

                logger.debug("理由コード(mqapiBean.getReason_code()) = " + mqapiBean.getReason_code());

                logger.error(MessageUtil.getMessage(MessageId.EAF1005, MqApiConstants.inputTranStopMsg, String.format("0x%04X",mqapiBean.getReason_code())));

                throw new MqFailedException(MqApiConstants.mqSyoriErr);

            }else if(mqapiBean.getReason_code() == MqApiConstants.stopRegion_1) {

                logger.debug("理由コード(mqapiBean.getReason_code()) = " + mqapiBean.getReason_code());

                logger.error(MessageUtil.getMessage(MessageId.EAF1005, MqApiConstants.stopRegionMsg_1, String.format("0x%04X",mqapiBean.getReason_code())));

                throw new MqFailedException(MqApiConstants.mqSyoriErr);

            }else if(mqapiBean.getReason_code() == MqApiConstants.stopRegion_2) {

                logger.debug("理由コード(mqapiBean.getReason_code()) = " + mqapiBean.getReason_code());

                logger.error(MessageUtil.getMessage(MessageId.EAF1005, MqApiConstants.stopRegionMsg_2, String.format("0x%04X",mqapiBean.getReason_code())));

                throw new MqFailedException(MqApiConstants.mqSyoriErr);

            }else if(mqapiBean.getReason_code() == MqApiConstants.afterCheInputTran){

                logger.debug("理由コード(mqapiBean.getReason_code()) = " + mqapiBean.getReason_code());

                logger.error(MessageUtil.getMessage(MessageId.EAF1005, MqApiConstants.afterCheInputTranMsg, String.format("0x%04X",mqapiBean.getReason_code())));

                throw new MqFailedException(MqApiConstants.mqSyoriErr);

            }else if(mqapiBean.getReason_code() == MqApiConstants.seqNoError) {

                logger.debug("理由コード(mqapiBean.getReason_code()) = " + mqapiBean.getReason_code());

                logger.error(MessageUtil.getMessage(MessageId.EAF1005, MqApiConstants.seqNoErrorMsg, String.format("0x%04X",mqapiBean.getReason_code())));

                throw new MqFailedException(MqApiConstants.mqSyoriErr);

            }else if(mqapiBean.getReason_code() == MqApiConstants.codeError) {

                logger.debug("理由コード(mqapiBean.getReason_code()) = " + mqapiBean.getReason_code());

                logger.error(MessageUtil.getMessage(MessageId.EAF1005, MqApiConstants.codeErrorMsg, String.format("0x%04X",mqapiBean.getReason_code())));

                throw new MqFailedException(MqApiConstants.mqSyoriErr);

            }else if(mqapiBean.getReason_code() == MqApiConstants.LengthOver) {

                logger.debug("理由コード(mqapiBean.getReason_code()) = " + mqapiBean.getReason_code());

                logger.error(MessageUtil.getMessage(MessageId.EAF1005, MqApiConstants.LengthOverMsg, String.format("0x%04X",mqapiBean.getReason_code())));

                throw new MqFailedException(MqApiConstants.mqSyoriErr);

            }else if(mqapiBean.getReason_code() == MqApiConstants.multiChainInputTran) {

                logger.debug("理由コード(mqapiBean.getReason_code()) = " + mqapiBean.getReason_code());

                logger.error(MessageUtil.getMessage(MessageId.EAF1005, MqApiConstants.multiChainInputTranMsg, String.format("0x%04X",mqapiBean.getReason_code())));

                throw new MqFailedException(MqApiConstants.mqSyoriErr);

            }else if(mqapiBean.getReason_code() == MqApiConstants.snaSeq) {

                logger.debug("理由コード(mqapiBean.getReason_code()) = " + mqapiBean.getReason_code());

                logger.error(MessageUtil.getMessage(MessageId.EAF1005, MqApiConstants.snaSeqMsg, String.format("0x%04X",mqapiBean.getReason_code())));

                throw new MqFailedException(MqApiConstants.mqSyoriErr);

            }else{

                logger.error(MessageUtil.getMessage(MessageId.EAF1005, MqApiConstants.unexpectedMsg, String.format("0x%04X",mqapiBean.getReason_code())));

                throw new MqFailedException(MqApiConstants.mqSyoriErr);

            }
        }else if(result == MqApiConstants.MQ_RC_ERROR_API){

            logger.error(MessageUtil.getMessage(MessageId.EAF1006));

            throw new MqFailedException(MqApiConstants.mqSyoriErr);

        }else if(result == MqApiConstants.MQ_RC_TRUNCATE){

            logger.error(MessageUtil.getMessage(MessageId.EAF1007));

            throw new MqFailedException(MqApiConstants.mqSyoriErr);

        }else if(result == MqApiConstants.MQ_RC_NO_CONNECT){

            logger.error("ＭＱＡＰＩとＭＱ間が未接続状態です。");

            throw new MqFailedException(MqApiConstants.mqSyoriFunou);

        }else{

            logger.error("想定外のエラーが発生しました。");

            throw new MqFailedException(MqApiConstants.mqSyoriErr);

        }
    }


    private String recvDataGet(MqapiBean wk_SendRecvData) {

        logger.debug("受信データ取得処理(recvDataGet)開始");

        logger.debug("引数（wk_SendRecvData）= " + wk_SendRecvData );

        return wk_SendRecvData.getRecv_data_ptr().getUserData();
    }


    private String userDataGet(String wk_RecvData) {

        logger.debug("ユーザデータ取得処理(userDataGet)開始");

        logger.debug("引数（wk_RecvData）= " + wk_RecvData );

        return wk_RecvData.substring(MqApiConstants.acsHeadLength );


    }


    private MqapiBean mqReSend(MqapiBean bk_MqapiBean, int sendTimes) {

        logger.debug("MQ再送処理(mqReSend)開始");

        logger.debug("引数（bk_MqapiBean）= " + bk_MqapiBean );

        logger.debug("引数（sendTimes）   = " + sendTimes );

        int wk_sendTimes = sendTimes;

        chkMqOnline();

        chkMqEmgcyStop();

        if(wk_sendTimes > MqApiConstants.maxSendTimes){
            logger.error(MessageUtil.getMessage(MessageId.EAF1008, Integer.toString(MqApiConstants.maxSendTimes)));

            throw new MqFailedException(MqApiConstants.mqSyoriFunou);

        }

        String wk_RkmAtesaki = getRkmAtesaki();

        bk_MqapiBean.setCoop_based(wk_RkmAtesaki);

        bk_MqapiBean.setCoop_dest(MqApiConstants.rksAtesaki);

        bk_MqapiBean.setPer_type(MqApiConstants.Mq_NotPer);

        UniqueKeyGenerator ukg = SWAKInjector.getInstance(UniqueKeyGenerator.class);
        String uKey = ukg.generateUniqueKey();

        logger.debug("uKey(再送） = " + uKey);
        logger.debug("uKey.length(再送) = " + uKey.length());

        String uKyeForMsgId = uKey.substring(0, 4);

        byte[] msgId = uKyeForMsgId.getBytes();

        bk_MqapiBean.setMsg_id(msgId);

        byte[] newCorrel_id = uKey.getBytes();
        byte[] Correl_id = ByteBuffer.allocate(24).put(newCorrel_id).array();

        logger.debug("newCorrel_id.length（再送） = " + newCorrel_id.length);
        logger.debug("Correl_id.length（再送） = " + Correl_id.length);

        bk_MqapiBean.setCorrel_id(Correl_id);

        RecvDataBean rcv = new RecvDataBean();
        bk_MqapiBean.setRecv_data_ptr(rcv);

        bk_MqapiBean.setSync_type("NS");

        bk_MqapiBean.setTrunc_type("TE");

        bk_MqapiBean.setReason_code(0);

        bk_MqapiBean.setMsg_type(null);

        bk_MqapiBean.setLimit_time(0);

        logger.debug("再送用に引数（bk_MqapiBean）を再設定 = " + bk_MqapiBean );

        wk_sendTimes++;
        return dataSendRecv(bk_MqapiBean, wk_sendTimes);
    }


    private String getRkmAtesaki() {

        logger.debug("連携元宛先取得処理(getRkmAtesaki:引数なし)開始");

        String wk_rkmAtesaki = null;
        try {
            String hostname = InetAddress.getLocalHost().getHostName();

            String wk_hostname = hostname.substring(4,8);

            logger.debug("サーバ種別（wk_hostname）= " + wk_hostname );

            AT_MqInfo mqInfo = mqDao.getMqInfo(wk_hostname);

            logger.debug("MQ情報テーブル取得結果 = " + mqInfo );

            wk_rkmAtesaki = mqInfo.getRkmAtesaki();

            logger.debug("連携元宛先 = " + wk_rkmAtesaki );

        } catch (UnknownHostException e) {
            throw new BizAppException(e,"");
        }

        logger.debug("連携元宛先取得処理終了");

        return wk_rkmAtesaki;
    }
}

