package yuyu.common.workflowcore.scan.impl;

import static jp.co.slcs.workflow.adapter.ScanReceiveParamConstants.*;

import java.io.ByteArrayOutputStream;
import java.util.Map;

import javax.transaction.Transactional;

import jp.co.slcs.swak.auth.Credentials;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.core.logger.LoggerFactory;
import jp.co.slcs.swak.uniquekey.UniqueKeyGenerator;
import jp.co.slcs.swak.webservice.config.WebServiceConfig;
import jp.co.slcs.workflow.adapter.ScanReceiveException;
import jp.co.slcs.workflow.adapter.ScanReceiver;

import org.apache.commons.codec.binary.Base64;
import org.slf4j.Logger;

import yuyu.common.workflowcore.core.webservice.provide.imagekanri.putArrivalImage.WSPutArrivalImage;
import yuyu.common.workflowcore.core.webservice.provide.imagekanri.putArrivalImage.WSPutArrivalImageRequest;
import yuyu.common.workflowcore.core.webservice.provide.imagekanri.putArrivalImage.WSPutArrivalImageResponse;
import yuyu.def.classification.C_ResultCdKbn;

import com.google.common.base.Strings;

public class ScanReceiverImpl implements ScanReceiver{

    @Override
    @Transactional
    public void receive(String documentId, ByteArrayOutputStream stream, Map<String,String> infoMap) throws ScanReceiveException {

        ScanReceiveInfoBean bean = SWAKInjector.getInstance(ScanReceiveInfoBean.class);
        bean.setDocumentId(infoMap.get(KEY_DOCUMENTID));
        bean.setDocumentURI(infoMap.get(KEY_DOCUMENTURI));
        bean.setUserId(infoMap.get(KEY_USER));
        bean.setPages(Integer.valueOf(infoMap.get(KEY_PAGES)));

        Credentials c = SWAKInjector.getInstance(Credentials.class);
        c.setUsername(WebServiceConfig.getInstance().getProvideUserId());

        UniqueKeyGenerator uniqueKey = SWAKInjector.getInstance(UniqueKeyGenerator.class);
        Logger logger = LoggerFactory.getLogger(ScanReceiverImpl.class);

        WSPutArrivalImageRequest request = new WSPutArrivalImageRequest();
        request.setArrivekey(documentId);
        request.setImagedatastr(new String(Base64.encodeBase64(stream.toByteArray())));
        request.setRequestid(uniqueKey.generateUniqueKey());

        WSPutArrivalImageResponse response;
        WSPutArrivalImage putArrivalImage = SWAKInjector.getInstance(WSPutArrivalImage.class);

        try {
             response = putArrivalImage.executeBizMain(request);
        } catch (Exception e) {
            throw new ScanReceiveException(
                "想定外のエラーが発生し、処理を継続できなくなりました。システム管理者に詳しい状況と経緯を連絡してください。\n"
                + e.getClass().getName() ,  e);
        }

        if(C_ResultCdKbn.NG.toString().equals(response.getKekkastatus())){

            if(response.getValidationErrMsgs() != null){
                for(Map<String, String> map : response.getValidationErrMsgs()){
                    if(map.size() > 0) logger.warn("ValidationErrMsgs:" + map.toString());
                }
            }

            if(!Strings.isNullOrEmpty(response.getCberrmsg())){
                throw new ScanReceiveException(response.getCberrmsg());
            }

            throw new ScanReceiveException(response.getSyousaimsg());
        }
    }
}
