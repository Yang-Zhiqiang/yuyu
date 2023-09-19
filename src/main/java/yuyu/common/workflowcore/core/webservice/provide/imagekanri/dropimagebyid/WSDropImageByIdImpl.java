package yuyu.common.workflowcore.core.webservice.provide.imagekanri.dropimagebyid;

import java.util.Iterator;
import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.core.logger.LoggerFactory;

import org.slf4j.Logger;

import yuyu.common.workflowcore.api.api.IWorkflowContext;
import yuyu.common.workflowcore.api.api.IWorkflowProcessDef;
import yuyu.common.workflowcore.api.api.IWorkflowToken;
import yuyu.common.workflowcore.api.api.impl.WorkflowContextFactory;
import yuyu.common.workflowcore.api.exception.WorkflowRuntimeException;
import yuyu.common.workflowcore.core.iwfinfr.util.IwfBase64Urls;
import yuyu.common.workflowcore.core.iwfinfr.util.IwfEditMessageUtil;
import yuyu.common.workflowcore.core.iwfinfr.util.IwfMessageCd;
import yuyu.common.workflowcore.core.iwfinfr.util.IwfMessageUtil;
import yuyu.common.workflowcore.core.iwfinfr.util.IwfValidateUtil;
import yuyu.common.workflowcore.core.webservice.provide.common.logic.IwfCommonLogic;
import yuyu.common.workflowcore.iwfcommon.CheckException;
import yuyu.def.classification.C_IwfSyoriKbn;
import yuyu.def.classification.C_ResultCdKbn;
import yuyu.def.classification.C_RirekiKbn;
import yuyu.def.db.entity.WM_TorikomiSyorui;
import yuyu.def.db.entity.WT_GyoumuKey;
import yuyu.def.db.entity.WT_PDFHozon;
import yuyu.def.db.entity.WT_Page;
import yuyu.def.db.entity.WT_TorikomiKanri;
import yuyu.def.db.entity.WT_TorikomiRelation;
import yuyu.def.workflowcore.manager.IwfCoreDomManager;

/**
 * ID指定イメージ削除サービスメインクラス
 */
public class WSDropImageByIdImpl implements WSDropImageById {

    @Inject
    private IwfCoreDomManager iwfCoreDomManager;

    private final static Logger LOGGER = LoggerFactory.getLogger(WSDropImageById.class);

    public WSDropImageByIdImpl() {
        super();
    }

    public WSDropImageByIdResponse validate(WSDropImageByIdRequest request)
        throws Exception {
        WSDropImageByIdResponse oResponse = new WSDropImageByIdResponse();

        String sAccountId = request.getAccountid();
        String[] sImageIds = request.getImageids();

        if (!IwfValidateUtil.isRequiredAndMaxLenChkOK(oResponse, sAccountId, "アカウントＩＤ", 30)) {
            return oResponse;
        }

        if (sImageIds == null ||
            sImageIds.length == 0) {
            IwfEditMessageUtil.setMsgResultNG(oResponse, IwfMessageCd.IWF0002, "イメージＩＤ配列");
        }
        return oResponse;
    }

    public String getServiceName() {

        return WSDropImageByIdRequest.sSERVICE_NAME;
    }

    @Override
    @Transactional
    public WSDropImageByIdResponse executeBizMain(
        WSDropImageByIdRequest request) throws Exception {


        WSDropImageByIdResponse oWSResponse = new WSDropImageByIdResponse();

        oWSResponse = validate(request);

        if (C_ResultCdKbn.NG.toString().equals(oWSResponse.getKekkastatus())) {
            return oWSResponse;
        }

        String sAccountId = request.getAccountid();
        String[] sImageIds = request.getImageids();
        byte[] oExtinfo     = null;
        if (request.getExtinfo() != null) {
            oExtinfo = IwfBase64Urls.decodeToString(request.getExtinfo()).getBytes("UTF-8");
        }

        IWorkflowContext oWfCon = WorkflowContextFactory.newInstance();

        try {
            oWfCon.open();

            List<WT_TorikomiKanri> kanriList = iwfCoreDomManager.getTorikomiKanrisByImageIds(sImageIds);

            if(kanriList.size() == 0) {
                iwfCoreDomManager.clear();
                if(oWfCon.isOpen()){
                    oWfCon.close();
                }
                IwfEditMessageUtil.setMsgResultNG(oWSResponse, IwfMessageCd.IWF3073);
                return oWSResponse;
            }

            Iterator<WT_TorikomiKanri> itrkanri = kanriList.iterator();
            WT_TorikomiKanri kanri = null;

            while(itrkanri.hasNext()){
                kanri = itrkanri.next();

                String sImageId_kanri = kanri.getIwfImageId();

                WM_TorikomiSyorui syorui = iwfCoreDomManager.getTorikomiSyorui(kanri.getTorikomiSyoruiCd());
                if(syorui==null){
                    IwfEditMessageUtil.setMsgResultNG(oWSResponse, IwfMessageCd.IWF3072);
                    return oWSResponse;
                }

                String sFlowId = syorui.getFlowId();

                List<WT_Page> pageList = iwfCoreDomManager.getPages(sImageId_kanri);
                Iterator<WT_Page> itrpage = pageList.iterator();
                WT_Page page = null;

                String sImageId = "";
                String sPageId = "";

                while(itrpage.hasNext()){
                    page = itrpage.next();

                    sImageId = page.getIwfImageId();
                    sPageId = page.getPageId();

                    WT_PDFHozon wT_PDFHozon = iwfCoreDomManager.getPDFHozon(sImageId, sPageId);
                    if (null != wT_PDFHozon) {
                        iwfCoreDomManager.delete(wT_PDFHozon);
                    }
                    iwfCoreDomManager.delete(page);
                }

                List<WT_TorikomiRelation> torikomiRelations = iwfCoreDomManager.getTorikomiRelationsByImageId(sImageId_kanri);

                for (WT_TorikomiRelation torikomiRelation : torikomiRelations) {
                    String sGyoumuKey = torikomiRelation.getGyoumuKey();

                    WT_GyoumuKey gyoumuKey = iwfCoreDomManager.getGyoumuKey(sFlowId, sGyoumuKey);

                    String sTokenId = null;

                    if (null != gyoumuKey) {
                        sTokenId = gyoumuKey.getTokenId();
                    }
                    else {
                        iwfCoreDomManager.clear();
                        if (oWfCon.isOpen()) {
                            oWfCon.close();
                        }
                        IwfEditMessageUtil.setMsgResultNG(oWSResponse, IwfMessageCd.IWF3071);

                        return oWSResponse;
                    }
                    IWorkflowToken token;
                    try {
                        IWorkflowProcessDef def = oWfCon.getProcessDef(sFlowId);
                        token = def.getToken(sTokenId);

                    } catch (WorkflowRuntimeException e) {
                        iwfCoreDomManager.clear();
                        if (oWfCon.isOpen()) {
                            oWfCon.close();
                        }

                        IwfEditMessageUtil.setMsgResultNG(oWSResponse, IwfMessageCd.IWF0001, "ID指定イメージ削除");

                        return oWSResponse;
                    }
                    String sNodeName;
                    String sNodeId;
                    if (token == null) {
                        sNodeName = "";
                        sNodeId = "";
                    } else {
                        sNodeName = token.getNodeName();
                        sNodeId = token.getNodeId();
                    }

                    IwfCommonLogic.createKouteiRireki(sFlowId,
                        sTokenId,
                        sGyoumuKey,
                        sNodeId,
                        sNodeName,
                        C_IwfSyoriKbn.DROPIMAGE,
                        sAccountId,
                        C_RirekiKbn.SYSTEM,
                        oExtinfo,
                        iwfCoreDomManager);

                    IwfCommonLogic.updateKouteiSummaryTime(sGyoumuKey, iwfCoreDomManager);

                    iwfCoreDomManager.delete(torikomiRelation);
                }

                iwfCoreDomManager.delete(kanri);
            }

            IwfEditMessageUtil.setMsgResultOK(oWSResponse, "ID指定イメージ削除");

        } catch (Exception e) {

            iwfCoreDomManager.clear();

            if(SWAKInjector.getInstance(CheckException.class).isExceptionShouldThrow(e)){
                throw e;
            }

            LOGGER.error("想定外のエラーが発生しました。", e);
            IwfEditMessageUtil.setMsgResultNG(oWSResponse, IwfMessageCd.IWF0001, "ID指定イメージ削除");
        } finally {
            if(oWfCon.isOpen()){
                oWfCon.close();
            }
        }
        return oWSResponse;
    }

    public WSDropImageByIdResponse getStubResult(
        WSDropImageByIdRequest request) throws Exception {

        return null;
    }

    public void executeBizTerminate(WSDropImageByIdRequest request, WSDropImageByIdResponse response) throws Exception {

        LOGGER.debug("│終了開始・・・");
    }

    public WSDropImageByIdResponse getBootErrResponse() {
        WSDropImageByIdResponse res = new WSDropImageByIdResponse();
        res.setKekkastatus(C_ResultCdKbn.OK.getValue());
        res.setSyousaimsgcd(IwfMessageCd.IWF0003.toString());
        res.setSyousaimsg(IwfMessageUtil.getMessage(IwfMessageCd.IWF0003));
        return res;
    }

}
