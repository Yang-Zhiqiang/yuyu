package yuyu.common.workflowcore.core.webservice.provide.imagekanri.getimagepropsbyid;

import static yuyu.common.workflowcore.core.iwfinfr.util.enumerate.E_TokenVarKey.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.core.logger.LoggerFactory;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;

import yuyu.common.workflowcore.WorkflowAuthInfo;
import yuyu.common.workflowcore.api.api.IWorkflowContext;
import yuyu.common.workflowcore.api.api.IWorkflowProcessDef;
import yuyu.common.workflowcore.api.api.IWorkflowToken;
import yuyu.common.workflowcore.api.api.impl.WorkflowContextFactory;
import yuyu.common.workflowcore.api.exception.WorkflowRuntimeException;
import yuyu.common.workflowcore.core.iwfinfr.util.IwfEditMessageUtil;
import yuyu.common.workflowcore.core.iwfinfr.util.IwfMessageCd;
import yuyu.common.workflowcore.core.iwfinfr.util.IwfMessageUtil;
import yuyu.common.workflowcore.core.webservice.provide.imagekanri.getimagepropsbyid.WSGetImagePropsByIdResponse.ImagePropsBean;
import yuyu.common.workflowcore.core.webservice.provide.imagekanri.gettargetimageprops.WSGetTargetImagePropsImpl;
import yuyu.def.classification.C_KengenUmuKbn;
import yuyu.def.classification.C_ResultCdKbn;
import yuyu.def.db.entity.WM_TorikomiSyorui;
import yuyu.def.db.entity.WT_GyoumuKey;
import yuyu.def.db.entity.WT_KengenSyorui;
import yuyu.def.db.entity.WT_Page;
import yuyu.def.db.entity.WT_TorikomiKanri;
import yuyu.def.db.entity.WT_TorikomiRelation;
import yuyu.def.workflowcore.manager.IwfCoreDomManager;

/**
 * ID指定イメージプロパティ取得サービスメインクラス
 */
public class WSGetImagePropsByIdImpl implements WSGetImagePropsById {

    private static final Logger LOGGER = LoggerFactory.getLogger(WSGetTargetImagePropsImpl.class);

    @Inject
    private IwfCoreDomManager iwfCoreDomManager;

    public WSGetImagePropsByIdImpl() {
        super();
    }

    public WSGetImagePropsByIdResponse validate(WSGetImagePropsByIdRequest request)
        throws Exception {
        WSGetImagePropsByIdResponse oResponse = new WSGetImagePropsByIdResponse();

        String sAccountId = request.getAccountid();
        String[] sImageIds = request.getImageids();

        if (StringUtils.isEmpty(sAccountId)) {
            IwfEditMessageUtil.setMsgResultNG(oResponse, IwfMessageCd.IWF0002, "アカウントＩＤ");
        }

        if (sImageIds == null ||
            sImageIds.length == 0) {
            IwfEditMessageUtil.setMsgResultNG(oResponse, IwfMessageCd.IWF0002, "イメージＩＤ配列");
        }
        return oResponse;
    }

    public String getServiceName() {

        return WSGetImagePropsByIdRequest.sSERVICE_NAME;
    }

    @Override
    @Transactional
    public WSGetImagePropsByIdResponse executeBizMain(
        WSGetImagePropsByIdRequest request) throws Exception {


        WSGetImagePropsByIdResponse oWSResponse = new WSGetImagePropsByIdResponse();

        String sAccountId = request.getAccountid();
        String[] sImageIds = request.getImageids();

        IWorkflowContext oWfCon = WorkflowContextFactory.newInstance();

        ArrayList<ImagePropsBean> imageProps = new ArrayList<ImagePropsBean>();
        ImagePropsBean imagePropsBean = new ImagePropsBean();

        try {
            oWfCon.open();

            List<WT_TorikomiKanri> kanriList = iwfCoreDomManager.getTorikomiKanrisByImageIds(sImageIds);
            Iterator<WT_TorikomiKanri> itrkanri = kanriList.iterator();
            WT_TorikomiKanri kanri = null;

            while(itrkanri.hasNext()){
                kanri = itrkanri.next();

                String sImageId_kanri = kanri.getIwfImageId();
                String sTorikomiSyoruiCd_kanri = kanri.getTorikomiSyoruiCd();

                List<WM_TorikomiSyorui> syoruiList = iwfCoreDomManager.getTorikomiSyoruis(sTorikomiSyoruiCd_kanri);
                Iterator<WM_TorikomiSyorui> itrsyorui = syoruiList.iterator();
                WM_TorikomiSyorui syorui = null;

                String sFlowId_syorui = null;
                if(itrsyorui.hasNext()){
                    while(itrsyorui.hasNext()){
                        syorui = itrsyorui.next();

                        sFlowId_syorui = syorui.getFlowId();
                    }
                } else {
                    IwfEditMessageUtil.setMsgResultNG_RecordNotFound(oWSResponse, WM_TorikomiSyorui.TABLE_NAME);
                    return oWSResponse;
                }

                String sKengenumu =  C_KengenUmuKbn.NONE.getValue();

                Set<String> syoruiKengens = SWAKInjector.getInstance(WorkflowAuthInfo.class).getImageAuthByUserId(sAccountId);

                List<WT_KengenSyorui> kengensyoruiList = iwfCoreDomManager.getKengenSyoruis(
                    sTorikomiSyoruiCd_kanri, syoruiKengens.toArray(new String[0]));

                if(!kengensyoruiList.isEmpty()){
                    sKengenumu = C_KengenUmuKbn.ARI.getValue();
                }

                List<WT_Page> pageList = iwfCoreDomManager.getPages(sImageId_kanri);
                Iterator<WT_Page> itrpage = pageList.iterator();
                WT_Page page = null;

                String sSyoruiToutyakuTime = "";

                while(itrpage.hasNext()){
                    page = itrpage.next();
                    sSyoruiToutyakuTime = page.getSyoruittykymdtime();
                    break;
                }

                List<WT_TorikomiRelation> torikomiRelations = iwfCoreDomManager.getTorikomiRelationsByImageId(sImageId_kanri);

                for (WT_TorikomiRelation torikomiRelation : torikomiRelations) {

                    String sGyoumuKey = torikomiRelation.getGyoumuKey();

                    String sTokenId = "";
                    WT_GyoumuKey wT_GyoumuKey = iwfCoreDomManager.getGyoumuKey(sFlowId_syorui, sGyoumuKey);
                    if (null == wT_GyoumuKey) {
                        LOGGER.warn("該当の業務キーとフローIDの組み合わせは存在しません。[gyoumukey = " + sGyoumuKey + " flowId = "
                            + sFlowId_syorui + "]");
                    } else {
                        sTokenId = wT_GyoumuKey.getTokenId();
                    }

                    if (StringUtils.isEmpty(sTokenId)) {
                        IwfEditMessageUtil.setMsgResultNG(oWSResponse, IwfMessageCd.IWF3060);
                        return oWSResponse;
                    }

                    IWorkflowProcessDef oProcess;
                    try {
                        oProcess = oWfCon.getProcessDef(sFlowId_syorui);
                    } catch (WorkflowRuntimeException e) {
                        iwfCoreDomManager.clear();
                        if (oWfCon.isOpen()) {
                            oWfCon.close();
                        }

                        IwfEditMessageUtil.setMsgResultNG(oWSResponse, IwfMessageCd.IWF3012);

                        return oWSResponse;
                    }

                    IWorkflowToken oToken = oProcess.getToken(sTokenId);
                    if (oToken == null) {
                        IwfEditMessageUtil.setMsgResultNG(oWSResponse, IwfMessageCd.IWF0001, "ID指定イメージプロパティ取得");
                        return oWSResponse;
                    }
                    String sSyoriStatus = oToken.getStringVariable(SYORI_STATUS.key);

                    imagePropsBean = new ImagePropsBean();

                    imagePropsBean.setImageid(sImageId_kanri);
                    imagePropsBean.setGyoumukey(sGyoumuKey);
                    imagePropsBean.setTorikomisyoruicd(sTorikomiSyoruiCd_kanri);
                    imagePropsBean.setSyoruitoutyakutime(sSyoruiToutyakuTime);
                    imagePropsBean.setKouteijyoutai(sSyoriStatus);
                    imagePropsBean.setKengenumu(sKengenumu);

                    imageProps.add(imagePropsBean);
                }

            }

            oWSResponse.setImagepropslist(imageProps);

            IwfEditMessageUtil.setMsgResultOK(oWSResponse, "ID指定イメージプロパティ取得");

            oWfCon.close();

        } catch (Exception e) {
            e.printStackTrace();

            if(oWfCon.isOpen()){
                oWfCon.close();
            }

            IwfEditMessageUtil.setMsgResultNG(oWSResponse, IwfMessageCd.IWF0001, "ID指定イメージプロパティ取得");
        } finally {
            if(oWfCon.isOpen()){
                oWfCon.close();
            }
        }
        return oWSResponse;
    }

    public WSGetImagePropsByIdResponse getStubResult(
        WSGetImagePropsByIdRequest request) throws Exception {

        return null;
    }

    public void executeBizTerminate(WSGetImagePropsByIdRequest request, WSGetImagePropsByIdResponse response) throws Exception {

        LOGGER.debug("│終了開始・・・");
    }

    public WSGetImagePropsByIdResponse getBootErrResponse() {
        WSGetImagePropsByIdResponse res = new WSGetImagePropsByIdResponse();
        res.setKekkastatus(C_ResultCdKbn.OK.getValue());
        res.setSyousaimsgcd(IwfMessageCd.IWF0003.toString());
        res.setSyousaimsg(IwfMessageUtil.getMessage(IwfMessageCd.IWF0003));
        return res;
    }

}
