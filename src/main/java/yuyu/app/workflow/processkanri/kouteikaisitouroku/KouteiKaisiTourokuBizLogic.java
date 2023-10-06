package yuyu.app.workflow.processkanri.kouteikaisitouroku;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.SWAK;
import jp.co.slcs.swak.bizinfr.configuration.Item;
import jp.co.slcs.swak.bizinfr.exception.BizAppException;
import jp.co.slcs.swak.bizinfr.exception.BizLogicException;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.web.message.MessageManager;

import org.slf4j.Logger;

import yuyu.common.base.BaseUserInfo;
import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.common.workflow.workflowutility.ExpectedArrivalNoticeBean;
import yuyu.common.workflow.workflowutility.GetExpectedArrivalNoticeResultBean;
import yuyu.common.workflow.workflowutility.PutArrivalImageResultBean;
import yuyu.common.workflow.workflowutility.WorkFlowResultConstants;
import yuyu.common.workflow.workflowutility.WorkFlowUtility;
import yuyu.def.MessageId;
import yuyu.def.base.manager.BaseDomManager;
import yuyu.def.workflow.configuration.YuyuWorkflowConfig;

import com.google.common.collect.Lists;

/**
 * 工程開始登録 のビジネスロジックです。
 */
public class KouteiKaisiTourokuBizLogic {

    @Inject
    private static Logger logger;

    @Inject
    private KouteiKaisiTourokuUiBean uiBean;

    @Inject
    BaseDomManager baseDomManager;

    @Inject
    private MessageManager messageManager;

    @Inject
    BaseUserInfo baseUserInfo;


    void init() {
        clear();
        BizPropertyInitializer.initialize(uiBean);

        List<TorokuInfo1DataSourceBean> pTorokuInfo1 = new ArrayList<TorokuInfo1DataSourceBean>();
        for(int i=1;i<=10;i++){
            TorokuInfo1DataSourceBean wk = new TorokuInfo1DataSourceBean();
            wk.setDispno(i);
            pTorokuInfo1.add(wk);
        }
        uiBean.setTorokuInfo1(pTorokuInfo1);
        checkDummySyorui();
    }

    void clear() {
    }


    void kakuninBtnOnClick(){
        checkDummySyorui();
        checkInputString();
        confirmDispDataSet();
        messageManager.addMessageId(MessageId.QBA0001);
    }

    void kakuteiBtnOnClick(){

        resultDispDataSet();
    }


    private void checkInputString() {

        Boolean flg = false;
        String docid = null;
        String[] ckString = new String[10];

        List<TorokuInfo1DataSourceBean> wk = uiBean.getTorokuInfo1DataSource().getAllData();
        ckString[0]= "";
        for( int i=0; i<ckString.length; i++){
            uiBean.getTorokuInfo1DataSource().getAllData().addAll(i, wk);
            if(!("".equals(wk.get(i).getWorkflowDocumentId()))){
                docid = wk.get(i).getWorkflowDocumentId().toString().trim();
                flg = true;
                ckString[i] = docid;
            }else{
                ckString[i] = "";
            }
        }
        if(! flg){
            throw new BizLogicException(MessageId.EBC0043, KouteiKaisiTourokuConstants.ERR_DOCUMENTID );
        }

        flg = true;
        int rowNo = 0;
        for( int i=0; i<ckString.length; i++){
            if(!( ckString[i].equals(""))){
                for(int j=i+1; j<ckString.length; j++){
                    if(!( ckString[j].equals("")) ){
                        if(ckString[i].equals(ckString[j])){
                            flg = false;
                            rowNo = j;
                            break;
                        }
                    }
                }
            }
            if(! flg){
                break;
            }
        }
        if(! flg){
            throw new BizLogicException(MessageId.EDF0001, rowNo, GenKouteiKaisiTourokuConstants.DDID_TOROKUINFO1_WORKFLOWDOCUMENTID);
        }
    }



    private void confirmDispDataSet() {

        List<ExpectedArrivalNoticeBean> tempExpectedArrivalNoticeBeanList = Lists.newArrayList();

        List<TorokuInfo1DataSourceBean> wk = uiBean.getTorokuInfo1DataSource().getAllData();
        for( int i=0; i<wk.size(); i++){
            if(!("".equals(wk.get(i).getWorkflowDocumentId()))){
                String[] docId = new String[]{wk.get(i).getWorkflowDocumentId()};
                GetExpectedArrivalNoticeResultBean tempResult =  WorkFlowUtility.getExpectedArrivalNotice(docId);

                if(!(tempResult.getSyorikekkaStatus().equals(WorkFlowResultConstants.RESULT_OK))){

                    if(WorkFlowResultConstants.RESULT_NODATA.equals(tempResult.getSyorikekkaStatus())){
                        throw new BizLogicException(MessageId.EDF0002, i,
                            GenKouteiKaisiTourokuConstants.DDID_TOROKUINFO1_WORKFLOWDOCUMENTID);
                    }else if(WorkFlowResultConstants.RESULT_TORIKESIZUMI.equals(tempResult.getSyorikekkaStatus())){
                        throw new BizLogicException(MessageId.EDF1005, i,
                            new Item[]{GenKouteiKaisiTourokuConstants.DDID_TOROKUINFO1_WORKFLOWDOCUMENTID},
                            wk.get(i).getWorkflowDocumentId(),
                            "取消済み");
                    }
                    else if(WorkFlowResultConstants.RESULT_LOCK.equals(tempResult.getSyorikekkaStatus())){
                        throw new BizLogicException(MessageId.EDA1001, i,
                            new Item[]{GenKouteiKaisiTourokuConstants.DDID_TOROKUINFO1_WORKFLOWDOCUMENTID},
                            wk.get(i).getWorkflowDocumentId());
                    }
                    else {
                        logger.error("エラーコード："+tempResult.getSyousaiMessageCd());
                        logger.error("エラーメッセージ："+tempResult.getSyousaiMessage());
                        throw new BizAppException(MessageId.EAS0037);
                    }
                }

                tempExpectedArrivalNoticeBeanList.addAll( tempResult.getExpectedArrivalNoticeBeanList());
            }
        }

        List<TorokuInfo1DataSourceBean> getwk = uiBean.getTorokuInfo1DataSource().getAllData();
        List<TorokuInfo2DataSourceBean> pTorokuInfo2 = new ArrayList<TorokuInfo2DataSourceBean>();

        int cnt = 0;
        for( int i=0; i<getwk.size(); i++){
            TorokuInfo2DataSourceBean wkInfo2 = new TorokuInfo2DataSourceBean();
            if( getwk.get(i).getWorkflowDocumentId().length() > 0 ){
                wkInfo2.setDispno(cnt+1);
                wkInfo2.setWorkflowDispDocumentId(getwk.get(i).getWorkflowDocumentId().toString());
                wkInfo2.setDispsyoruinmryaku(tempExpectedArrivalNoticeBeanList.get(cnt).getSyoruiNmRyaku());
                wkInfo2.setKouteikanriId(tempExpectedArrivalNoticeBeanList.get(cnt).getKouteiKnrId());
                pTorokuInfo2.add(wkInfo2);
                cnt++;
            }
        }

        for(int j=cnt;j<pTorokuInfo2.size();j++){
            TorokuInfo2DataSourceBean wkInfo2 = new TorokuInfo2DataSourceBean();
            wkInfo2.setDispno(j+1);
            wkInfo2.setWorkflowDispDocumentId("");
            wkInfo2.setDispsyoruinmryaku("");
            pTorokuInfo2.add(wkInfo2);
        }
        uiBean.setTorokuInfo2(pTorokuInfo2);
    }


    private void resultDispDataSet(){

        byte[] getbyte;
        try {
            getbyte = getOutputPdf();
        } catch (final IOException e) {
            throw new BizAppException(e, "EAS0037");
        }

        List<TorokuInfo2DataSourceBean> gmnwk = uiBean.getTorokuInfo2DataSource().getAllData();
        for( int i=0; i<gmnwk.size(); i++){
            String pQrCd = gmnwk.get(i).getWorkflowDispDocumentId();
            String kouteiKanriId = gmnwk.get(i).getKouteikanriId();
            PutArrivalImageResultBean result = SWAKInjector.getInstance(PutArrivalImageResultBean.class);

            boolean errorFlg = false;

            try{
                result = callWorkFlowUtility(pQrCd, getbyte, kouteiKanriId);
            }catch(Exception e){
                messageManager.addMessageId(MessageId.EDF1008,i ,gmnwk.get(i).getWorkflowDispDocumentId());
                errorFlg=true;
            }
            if(!errorFlg){
                if(!(result.getSyorikekkaStatus().equals(WorkFlowResultConstants.RESULT_OK))){

                    if(WorkFlowResultConstants.RESULT_LOCK.equals(result.getSyorikekkaStatus())){
                        messageManager.addMessageId(MessageId.EDF1007,i ,gmnwk.get(i).getWorkflowDispDocumentId());
                    }else if(WorkFlowResultConstants.RESULT_TORIKESIZUMI.equals(result.getSyorikekkaStatus())){
                        messageManager.addMessageId(MessageId.EDF1006,i ,gmnwk.get(i).getWorkflowDispDocumentId());
                    }else{
                        logger.error("ワークフロー呼出Utility#書類到着処理 登録異常");
                        logger.error("エラーコード："+result.getSyousaiMessageCd());
                        logger.error("エラーメッセージ："+result.getSyousaiMessage());
                        messageManager.addMessageId(MessageId.EDF1008,i ,gmnwk.get(i).getWorkflowDispDocumentId());
                    }
                }else{

                    messageManager.addMessageId(MessageId.IDF1003,i ,gmnwk.get(i).getWorkflowDispDocumentId());

                }
            }

        }

        List<TorokuInfo2DataSourceBean> getwk = uiBean.getTorokuInfo2DataSource().getAllData();
        List<TorokuInfo2DataSourceBean> setwk = new ArrayList<TorokuInfo2DataSourceBean>();

        for( int i=0; i<getwk.size(); i++){
            TorokuInfo2DataSourceBean wkInfo2 = new TorokuInfo2DataSourceBean();
            wkInfo2.setDispno(getwk.get(i).getDispno());
            wkInfo2.setWorkflowDispDocumentId(getwk.get(i).getWorkflowDispDocumentId());
            wkInfo2.setDispsyoruinmryaku(getwk.get(i).getDispsyoruinmryaku());
            setwk.add(wkInfo2);
        }
        uiBean.setTorokuInfo2(setwk);
    }


    private byte[] getOutputPdf() throws IOException {

        ByteArrayOutputStream bos = null;
        BufferedInputStream bis = null;
        OutputStream os = null;
        try{
            File file = checkDummySyorui();
            bos = new ByteArrayOutputStream();
            os = new BufferedOutputStream(bos);
            int rec;
            bis = new BufferedInputStream(new FileInputStream(file));
            while ((rec = bis.read()) != -1 ){
                os.write(rec);
            }
            os.flush();
        }
        catch (final IOException e){
            throw new BizAppException(e, "EAS0037");
        }
        finally{
            if (os != null){
                os.close();
            }
            if (bis != null){
                bis.close();
            }
        }
        return bos.toByteArray();
    }


    private File checkDummySyorui() {
        String fpath = SWAK.getApplicationRootPath() + YuyuWorkflowConfig.getInstance().getDummyFilePath();
        File file = new File(fpath);

        if(!(file.exists())){
            throw new BizLogicException(MessageId.EAS0023,KouteiKaisiTourokuConstants.ERR_DUMMYSYORUI);
        }
        return file;
    }


    @Transactional
    public PutArrivalImageResultBean callWorkFlowUtility(String pQrCd, byte[] pGetbyte, String pKouteiKanriId) throws Exception{
        PutArrivalImageResultBean result = WorkFlowUtility.putArrivalImage(pQrCd, pGetbyte, pKouteiKanriId);

        if(result.getSyorikekkaStatus().equals(WorkFlowResultConstants.RESULT_NG)){
            logger.debug("【ワークフロー呼出Utility#書類到着処理】 処理結果(異常終了)");
            logger.debug("エラーコード：" + result.getSyousaiMessageCd());
            logger.debug("エラーメッセージ：" + result.getSyousaiMessage());
            throw new BizLogicException(result.getSyousaiMessageCd());
        }

        return result;
    }

}
