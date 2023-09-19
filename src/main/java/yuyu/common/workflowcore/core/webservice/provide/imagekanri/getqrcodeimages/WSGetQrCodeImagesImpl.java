package yuyu.common.workflowcore.core.webservice.provide.imagekanri.getqrcodeimages;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

import javax.inject.Inject;

import jp.co.slcs.swak.core.logger.LoggerFactory;

import org.slf4j.Logger;

import yuyu.common.workflowcore.core.iwfinfr.util.IwfEditMessageUtil;
import yuyu.common.workflowcore.core.iwfinfr.util.IwfMessageCd;
import yuyu.common.workflowcore.core.iwfinfr.util.IwfMessageUtil;
import yuyu.common.workflowcore.core.iwfinfr.util.IwfQRUtils;
import yuyu.common.workflowcore.core.iwfinfr.util.IwfQRUtils.ImageFormat;
import yuyu.common.workflowcore.core.iwfinfr.util.IwfStringArrayUtils;
import yuyu.common.workflowcore.core.webservice.provide.imagekanri.gettargetimageprops.WSGetTargetImagePropsImpl;
import yuyu.def.classification.C_ResultCdKbn;
import yuyu.def.db.entity.WT_TorikomiKanri;
import yuyu.def.workflowcore.manager.IwfCoreDomManager;

import com.d_project.qrcode.ErrorCorrectLevel;

/**
 * ＱＲイメージコード取得サービスメインクラス
 */
public class WSGetQrCodeImagesImpl implements WSGetQrCodeImages {

    @Inject
    private IwfCoreDomManager iwfCoreDomManager;
    private static final Logger LOGGER = LoggerFactory.getLogger(WSGetTargetImagePropsImpl.class);

    public WSGetQrCodeImagesImpl() {
        super();

    }

    public WSGetQrCodeImagesResponse validate(WSGetQrCodeImagesRequest request)
        throws Exception {
        WSGetQrCodeImagesResponse oResponse = new WSGetQrCodeImagesResponse();

        String[] sGyoumukeys = request.getGyoumukeys();
        String[] sSyoruiCds = request.getSyoruicds();

        if (IwfStringArrayUtils.containsEmpty(sGyoumukeys)) {
            IwfEditMessageUtil.setMsgResultNG(oResponse, IwfMessageCd.IWF0002, "業務キー");
        }
        if (IwfStringArrayUtils.containsEmpty(sSyoruiCds)) {
            IwfEditMessageUtil.setMsgResultNG(oResponse, IwfMessageCd.IWF0002, "書類取込コード");
        }
        return oResponse;
    }

    public String getServiceName() {

        return WSGetQrCodeImagesRequest.sSERVICE_NAME;
    }

    @Override
    public WSGetQrCodeImagesResponse executeBizMain(
        WSGetQrCodeImagesRequest request) throws Exception {
        WSGetQrCodeImagesResponse oResponse = new WSGetQrCodeImagesResponse();

        String[] sSyoruiCds = request.getSyoruicds();

        try {

            List<WT_TorikomiKanri> oList = iwfCoreDomManager.getTorikomiKanrisBySyoruiCds(sSyoruiCds);
            HashMap<String, byte[]> oQrCodeMap = null;
            List<String> oImgCd = new ArrayList<String>();
            for (WT_TorikomiKanri oTorikomi : oList) {
                oImgCd.add(oTorikomi.getIwfImageId());
            }
            String[] sImgCds = oImgCd.toArray(new String[oImgCd.size()]);
            if (sImgCds != null) {
                oQrCodeMap = new HashMap<String, byte[]>();
                for(String sImgCd : sImgCds){
                    byte[] image = IwfQRUtils.createQRImage(sImgCd, ImageFormat.JPEG, 2, 3, ErrorCorrectLevel.H);
                    oQrCodeMap.put(sImgCd, image);
                }
            }

            if (oQrCodeMap == null || oQrCodeMap.isEmpty()) {
                IwfEditMessageUtil.setMsgResultNG(oResponse, IwfMessageCd.IWF3030);
                return oResponse;
            }

            Set<String> oImgIds = oQrCodeMap.keySet();
            ArrayList<byte[]> oQrCode = new ArrayList<byte[]>();
            for (String sImgId: oImgIds) {
                oQrCode.add(oQrCodeMap.get(sImgId));
            }

            IwfEditMessageUtil.setMsgResultOK(oResponse, "ＱＲコードイメージ取得");

            oResponse.setImgids(oImgIds.toArray(new String[oImgIds.size()]));
            oResponse.setQrimgbinaries(oQrCode);

        } catch (Exception oEx) {

            IwfEditMessageUtil.setMsgResultNG(oResponse, IwfMessageCd.IWF0001, "ＱＲコードイメージ取得");

            oEx.printStackTrace();
        } finally {
        }
        return oResponse;
    }

    public WSGetQrCodeImagesResponse getStubResult(
        WSGetQrCodeImagesRequest request) throws Exception {

        return null;
    }

    public void executeBizTerminate(WSGetQrCodeImagesRequest request, WSGetQrCodeImagesResponse response) throws Exception {

        LOGGER.debug("│終了開始・・・");
    }

    public WSGetQrCodeImagesResponse getBootErrResponse() {
        WSGetQrCodeImagesResponse res = new WSGetQrCodeImagesResponse();
        res.setKekkastatus(C_ResultCdKbn.OK.getValue());
        res.setSyousaimsgcd(IwfMessageCd.IWF0003.toString());
        res.setSyousaimsg(IwfMessageUtil.getMessage(IwfMessageCd.IWF0003));
        return res;
    }

}
