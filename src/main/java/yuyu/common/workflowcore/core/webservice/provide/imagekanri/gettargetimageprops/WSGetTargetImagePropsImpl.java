package yuyu.common.workflowcore.core.webservice.provide.imagekanri.gettargetimageprops;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.inject.Inject;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.core.logger.LoggerFactory;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;

import yuyu.common.workflowcore.WorkflowAuthInfo;
import yuyu.common.workflowcore.api.api.IWorkflowContext;
import yuyu.common.workflowcore.api.api.impl.WorkflowContextFactory;
import yuyu.common.workflowcore.core.iwfinfr.util.IwfEditMessageUtil;
import yuyu.common.workflowcore.core.iwfinfr.util.IwfMessageCd;
import yuyu.common.workflowcore.core.iwfinfr.util.IwfMessageUtil;
import yuyu.common.workflowcore.core.webservice.common.WSExtParam;
import yuyu.common.workflowcore.core.webservice.provide.common.exdao.GetImagePropsDao;
import yuyu.common.workflowcore.core.webservice.provide.common.logic.IwfCommonLogic;
import yuyu.common.workflowcore.core.webservice.provide.imagekanri.gettargetimageprops.WSGetTargetImagePropsResponse.ImagePropsBean;
import yuyu.common.workflowcore.iwfcommon.CheckException;
import yuyu.def.classification.C_KengenUmuKbn;
import yuyu.def.classification.C_ResultCdKbn;
import yuyu.def.db.entity.WM_TorikomiSyorui;
import yuyu.def.db.entity.WT_KouteiSummary;
import yuyu.def.db.entity.WT_Page;
import yuyu.def.db.entity.WT_TorikomiKanri;
import yuyu.def.db.entity.WT_TorikomiRelation;
import yuyu.def.workflowcore.manager.IwfCoreDomManager;

/**
 * 対象イメージプロパティ取得サービスメインクラス
 */
public class WSGetTargetImagePropsImpl implements WSGetTargetImageProps {

    @Inject
    private IwfCoreDomManager iwfCoreDomManager;

    @Inject
    private GetImagePropsDao getImagePropsDao;

    private static final Logger LOGGER = LoggerFactory.getLogger(WSGetTargetImagePropsImpl.class);

    public WSGetTargetImagePropsResponse validate(WSGetTargetImagePropsRequest request) throws Exception {

        WSGetTargetImagePropsResponse oResponse = new WSGetTargetImagePropsResponse();

        String sAccountId = request.getAccountid();
        String sSyoruitoutyakuYmdFrom = request.getSyoruitoutyakuymdfrom();
        String sSyoruitoutyakuYmdTo = request.getSyoruitoutyakuymdto();

        if (StringUtils.isEmpty(sAccountId)) {
            IwfEditMessageUtil.setMsgResultNG(oResponse, IwfMessageCd.IWF0002, "アカウントＩＤ");
            return oResponse;
        }
        if (StringUtils.isNotEmpty(sSyoruitoutyakuYmdFrom)) {
            if (StringUtils.isEmpty(sSyoruitoutyakuYmdTo)) {
                IwfEditMessageUtil.setMsgResultNG(oResponse, IwfMessageCd.IWF3024);
                return oResponse;
            }
        }
        if (StringUtils.isNotEmpty(sSyoruitoutyakuYmdTo)) {
            if (StringUtils.isEmpty(sSyoruitoutyakuYmdFrom)) {
                IwfEditMessageUtil.setMsgResultNG(oResponse, IwfMessageCd.IWF3024);
                return oResponse;
            }
        }
        return oResponse;
    }

    public String getServiceName() {
        return WSGetTargetImagePropsRequest.sSERVICE_NAME;
    }

    IWorkflowContext oWfCon;

    @Override
    public WSGetTargetImagePropsResponse executeBizMain(
        WSGetTargetImagePropsRequest request) throws Exception {

        WSGetTargetImagePropsResponse oWSResponse = validate(request);
        if (C_ResultCdKbn.NG.toString().equals(oWSResponse.getKekkastatus())) {
            return oWSResponse;
        }
        executeGetImageProps(request, oWSResponse);
        return oWSResponse;
    }

    private WSGetTargetImagePropsResponse executeGetImageProps(WSGetTargetImagePropsRequest pRequest,
        WSGetTargetImagePropsResponse pResponse) throws Exception {

        String sAccountId = pRequest.getAccountid();
        String sFlowId = pRequest.getFlowid();
        String sGyoumuKey = pRequest.getGyoumukey();
        String sTorikomiSyoruiCd = pRequest.getTorikomisyoruicd();
        String sSyoruitoutyakuYmdFrom = pRequest.getSyoruitoutyakuymdfrom();
        String sSyoruitoutyakuYmdTo = pRequest.getSyoruitoutyakuymdto();
        String sSyzkDaibunruiId = pRequest.getSyzkdaibunruiid();
        String sSyzkSyoubunruiId = pRequest.getSyzksyoubunruiid();
        String sKouteiJyoutai = pRequest.getKouteijyoutai();
        Map<String, WSExtParam> extParamMap = IwfCommonLogic.getExtParams(pRequest);

        oWfCon = WorkflowContextFactory.newInstance();

        ArrayList<ImagePropsBean> imageProps = new ArrayList<>();
        ImagePropsBean imagePropsBean = new ImagePropsBean();

        try {
            oWfCon.open();

            List<WM_TorikomiSyorui> syoruiList = iwfCoreDomManager.getTorikomiSyoruis(sTorikomiSyoruiCd, sSyzkDaibunruiId, sSyzkSyoubunruiId, sFlowId, null);

            if(syoruiList.isEmpty()){
                IwfEditMessageUtil.setMsgResultNG_RecordNotFound(pResponse, WM_TorikomiSyorui.TABLE_NAME);
                return pResponse;
            }
            Set<String> imageAuths =  SWAKInjector.getInstance(WorkflowAuthInfo.class).getImageAuthByUserId(sAccountId);

            List<WT_TorikomiKanri> torikomiKanris = getImagePropsDao.getTorikomiKanriByImageInfo(
                sGyoumuKey, sFlowId, sTorikomiSyoruiCd, sSyzkDaibunruiId, sSyzkSyoubunruiId, sKouteiJyoutai,extParamMap, sSyoruitoutyakuYmdFrom,sSyoruitoutyakuYmdTo);

            for(WT_TorikomiKanri torikomiKanri : torikomiKanris){

                List<WT_Page> pages =  iwfCoreDomManager.getPages(torikomiKanri.getIwfImageId(), sSyoruitoutyakuYmdFrom,sSyoruitoutyakuYmdTo);
                if(pages == null || pages.isEmpty()){
                    continue;
                }
                List<WT_TorikomiRelation> torikomiRelationList = torikomiKanri.getTorikomiRelation();
                String sSyoruiCd = torikomiKanri.getTorikomiSyoruiCd();

                String sKengenumu = imageAuths.contains(sSyoruiCd) ? C_KengenUmuKbn.ARI.getValue() : C_KengenUmuKbn.NONE.getValue();

                for(WT_TorikomiRelation torikomiRelation : torikomiRelationList){

                    WT_KouteiSummary kouteiSummary = torikomiRelation.getKouteiSummary();

                    imagePropsBean = new ImagePropsBean();
                    imagePropsBean.setImageid(torikomiKanri.getIwfImageId());
                    imagePropsBean.setGyoumukey(torikomiRelation.getGyoumuKey());
                    imagePropsBean.setTorikomisyoruicd(sSyoruiCd);
                    imagePropsBean.setSyoruitoutyakutime(pages.get(0).getSyoruittykymdtime());
                    imagePropsBean.setTourokutime(torikomiKanri.getTourokuTime());
                    imagePropsBean.setKouteijyoutai(kouteiSummary.getSyoriStatus());
                    imagePropsBean.setKengenumu(sKengenumu);
                    imagePropsBean.setTourokuaccountid(torikomiKanri.getTourokuId());
                    imagePropsBean.setPagecount(String.valueOf(pages.size()));
                    imageProps.add(imagePropsBean);
                }
            }
            pResponse.setImagepropslist(imageProps);

            IwfEditMessageUtil.setMsgResultOK(pResponse, "対象イメージプロパティ取得");

        } catch (Exception e) {

            if(SWAKInjector.getInstance(CheckException.class).isExceptionShouldThrow(e)){
                throw e;
            }
            LOGGER.error("想定外のエラーが発生しました。", e);
            IwfEditMessageUtil.setMsgResultNG(pResponse, IwfMessageCd.IWF0001, "対象イメージプロパティ取得");

        } finally {
            if(oWfCon.isOpen()){
                oWfCon.close();
            }
        }
        return pResponse;
    }

    public WSGetTargetImagePropsResponse getBootErrResponse() {
        WSGetTargetImagePropsResponse res = new WSGetTargetImagePropsResponse();
        res.setKekkastatus(C_ResultCdKbn.OK.getValue());
        res.setSyousaimsgcd(IwfMessageCd.IWF0003.toString());
        res.setSyousaimsg(IwfMessageUtil.getMessage(IwfMessageCd.IWF0003));
        return res;
    }
}
