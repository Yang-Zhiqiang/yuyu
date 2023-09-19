package yuyu.common.workflowcore.core.webservice.provide.imagekanri.outputqrcodeimages;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.Set;

import javax.inject.Inject;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import jp.co.slcs.swak.core.logger.LoggerFactory;

import yuyu.def.classification.C_ResultCdKbn;
import yuyu.def.workflowcore.manager.IwfCoreDomManager;
import yuyu.common.workflowcore.core.iwfinfr.util.IwfEditMessageUtil;
import yuyu.common.workflowcore.core.iwfinfr.util.IwfGetQrDataUtils;
import yuyu.common.workflowcore.core.iwfinfr.util.IwfMessageCd;
import yuyu.common.workflowcore.core.iwfinfr.util.IwfMessageUtil;
import yuyu.common.workflowcore.core.iwfinfr.util.IwfStringArrayUtils;

/**
 * ＱＲイメージコード出力サービスメインクラス
 */
public class WSOutputQrCodeImagesImpl implements WSOutputQrCodeImages {

    @Inject
    private IwfCoreDomManager iwfCoreDomManager;

    private static final Logger LOGGER = LoggerFactory.getLogger(WSOutputQrCodeImages.class);


    public WSOutputQrCodeImagesImpl() {
        super();

    }

    public WSOutputQrCodeImagesResponse validate(
        WSOutputQrCodeImagesRequest request) throws Exception {

        WSOutputQrCodeImagesResponse oResponse = new WSOutputQrCodeImagesResponse();

        String[] sGyoumukeys = request.getGyoumukeys();
        String[] sSyoruiCds = request.getSyoruicds();
        String sOutputPath = request.getOutputpath();

        if (IwfStringArrayUtils.containsEmpty(sGyoumukeys)) {
            IwfEditMessageUtil.setMsgResultNG(oResponse, IwfMessageCd.IWF0002, "業務キー");
        }
        if (IwfStringArrayUtils.containsEmpty(sSyoruiCds)) {
            IwfEditMessageUtil.setMsgResultNG(oResponse, IwfMessageCd.IWF0002, "取込書類コード");
        }
        if (StringUtils.isEmpty(sOutputPath)) {
            IwfEditMessageUtil.setMsgResultNG(oResponse, IwfMessageCd.IWF0002, "出力先パス");
        }
        return oResponse;
    }

    public String getServiceName() {

        return WSOutputQrCodeImagesRequest.sSERVICE_NAME;
    }

    @Override
    public WSOutputQrCodeImagesResponse executeBizMain(
        WSOutputQrCodeImagesRequest request) throws Exception {

        WSOutputQrCodeImagesResponse oResponse = new WSOutputQrCodeImagesResponse();
        String[] sSyoruiCds = request.getSyoruicds();
        String sFilePath = request.getOutputpath();

        BufferedOutputStream oBuff = null;
        try {

            File oOutputFile = new File(sFilePath);
            if (!oOutputFile.isDirectory()) {
                IwfEditMessageUtil.setMsgResultNG(oResponse, IwfMessageCd.IWF3040, sFilePath);
                return oResponse;
            }

            HashMap<String, byte[]> oQrCodeMap = IwfGetQrDataUtils.getQrData(sSyoruiCds, iwfCoreDomManager);

            if (oQrCodeMap == null || oQrCodeMap.isEmpty()) {
                IwfEditMessageUtil.setMsgResultNG(oResponse, IwfMessageCd.IWF3041);
                return oResponse;
            }

            Set<String> oImgIds = oQrCodeMap.keySet();
            for (String sImgId: oImgIds) {

                oBuff = new BufferedOutputStream(new FileOutputStream(sFilePath + sImgId));
                oBuff.write(oQrCodeMap.get(sImgId));
                oBuff.flush();

                oBuff.close();

            }

            IwfEditMessageUtil.setMsgResultOK(oResponse, "ＱＲコードイメージ出力");

            oResponse.setFilenames(oImgIds.toArray(new String[oImgIds.size()]));
            oResponse.setImgids(oImgIds.toArray(new String[oImgIds.size()]));

        } catch (Exception oEx) {

            LOGGER.error("想定外のエラーが発生しました。", oEx);

            IwfEditMessageUtil.setMsgResultNG(oResponse, IwfMessageCd.IWF0001, "ＱＲコードイメージ出力");


        } finally {
            if (oBuff != null) {
                oBuff.close();
            }
        }
        return oResponse;
    }

    public WSOutputQrCodeImagesResponse getStubResult(
        WSOutputQrCodeImagesRequest request) throws Exception {

        return null;
    }

    public void executeBizTerminate(WSOutputQrCodeImagesRequest request, WSOutputQrCodeImagesResponse response) throws Exception {
        LOGGER.debug("│終了開始・・・");
    }


    public WSOutputQrCodeImagesResponse getBootErrResponse() {
        WSOutputQrCodeImagesResponse res = new WSOutputQrCodeImagesResponse();
        res.setKekkastatus(C_ResultCdKbn.OK.getValue());
        res.setSyousaimsgcd(IwfMessageCd.IWF0003.toString());
        res.setSyousaimsg(IwfMessageUtil.getMessage(IwfMessageCd.IWF0003));
        return res;
    }

}
