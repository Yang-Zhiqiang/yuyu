package yuyu.common.workflowcore.core.webservice.provide.imagekanri.getKouteiSiteiImageProps;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.inject.Inject;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.core.logger.LoggerFactory;
import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;

import yuyu.common.biz.workflow.io.koutei.sub.ExtParamBean;
import yuyu.common.workflowcore.WorkflowAuthInfo;
import yuyu.common.workflowcore.api.api.IWorkflowContext;
import yuyu.common.workflowcore.api.api.impl.WorkflowContextFactory;
import yuyu.common.workflowcore.core.iwfinfr.util.IwfDateUtils;
import yuyu.common.workflowcore.core.iwfinfr.util.IwfEditMessageUtil;
import yuyu.common.workflowcore.core.iwfinfr.util.IwfMessageCd;
import yuyu.common.workflowcore.core.webservice.common.WSExtParam;
import yuyu.common.workflowcore.core.webservice.provide.common.exdao.GetImagePropsDao;
import yuyu.common.workflowcore.core.webservice.provide.common.logic.IwfCommonLogic;
import yuyu.common.workflowcore.core.webservice.provide.imagekanri.getKouteiSiteiImageProps.WSGetKouteiSiteiImagePropsResponse.ImagePropsBean;
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
 * 工程情報指定イメージプロパティ取得サービスメインクラス
 */
public class WSGetKouteiSiteiImagePropsImpl implements WSGetkouteiSiteiImageProps {

    @Inject
    private IwfCoreDomManager iwfCoreDomManager;

    @Inject
    private GetImagePropsDao getImagePropsDao;

    IWorkflowContext oWfCon;

    private static final Logger LOGGER = LoggerFactory.getLogger(WSGetKouteiSiteiImagePropsImpl.class);

    public WSGetKouteiSiteiImagePropsImpl() {
        super();
    }

    public String getServiceName() {
        return WSGetKouteiSiteiImagePropsRequest.sSERVICE_NAME;
    }

    public WSGetKouteiSiteiImagePropsResponse validate(WSGetKouteiSiteiImagePropsRequest request) throws Exception {

        WSGetKouteiSiteiImagePropsResponse oResponse = new WSGetKouteiSiteiImagePropsResponse();

        String sAccountId           = request.getAccountid();
        String sKouteikaisibifrom   = request.getKouteikaisibifrom();
        String sKouteikaisibito     = request.getKouteikaisibito();
        String sKouteikanryoubifrom = request.getKouteikanryoubifrom();
        String sKouteikanryoubito   = request.getKouteikanryoubito();
        String sLastsyoritimefrom   = request.getLastsyoritimefrom();
        String sLastsyoritimeto     = request.getLastsyoritimeto();
        String sSyoruitoutyakuYmdFrom = request.getSyoruitoutyakuymdfrom();
        String sSyoruitoutyakuYmdTo = request.getSyoruitoutyakuymdto();

        if (StringUtils.isEmpty(sAccountId)) {
            IwfEditMessageUtil.setMsgResultNG(oResponse, IwfMessageCd.IWF0002, "アカウントＩＤ");
            return oResponse;
        }

        if (StringUtils.isNotEmpty(sKouteikaisibifrom)) {
            if (!IwfDateUtils.checkDateYYYYMMDD(sKouteikaisibifrom)) {
                IwfEditMessageUtil.setMsgResultNG(oResponse, IwfMessageCd.IWF2161);
                return oResponse;
            }
        }

        if (StringUtils.isNotEmpty(sKouteikaisibito)) {
            if (!IwfDateUtils.checkDateYYYYMMDD(sKouteikaisibito)) {
                IwfEditMessageUtil.setMsgResultNG(oResponse, IwfMessageCd.IWF2162);
                return oResponse;
            }
        }

        if (StringUtils.isNotEmpty(sKouteikanryoubifrom)) {
            if (!IwfDateUtils.checkDateYYYYMMDD(sKouteikanryoubifrom)) {
                IwfEditMessageUtil.setMsgResultNG(oResponse, IwfMessageCd.IWF2163);
                return oResponse;
            }
        }

        if (StringUtils.isNotEmpty(sKouteikanryoubito)) {
            if (!IwfDateUtils.checkDateYYYYMMDD(sKouteikanryoubito)) {
                IwfEditMessageUtil.setMsgResultNG(oResponse, IwfMessageCd.IWF2164);
                return oResponse;
            }
        }

        if (StringUtils.isNotEmpty(sLastsyoritimefrom)) {
            if (!IwfDateUtils.checkDate(sLastsyoritimefrom)) {
                IwfEditMessageUtil.setMsgResultNG(oResponse, IwfMessageCd.IWF2165);
                return oResponse;
            }
        }

        if (StringUtils.isNotEmpty(sLastsyoritimeto)) {
            if (!IwfDateUtils.checkDate(sLastsyoritimeto)) {
                IwfEditMessageUtil.setMsgResultNG(oResponse, IwfMessageCd.IWF2166);
                return oResponse;
            }
        }

        if ((StringUtils.isNotEmpty(sKouteikaisibifrom) && StringUtils.isEmpty(sKouteikaisibito))
            || (StringUtils.isEmpty(sKouteikaisibifrom) && StringUtils.isNotEmpty(sKouteikaisibito))) {
            IwfEditMessageUtil.setMsgResultNG(oResponse, IwfMessageCd.IWF2167);
            return oResponse;
        }

        if ((StringUtils.isNotEmpty(sKouteikanryoubifrom) && StringUtils.isEmpty(sKouteikanryoubito))
            || (StringUtils.isEmpty(sKouteikanryoubifrom) && StringUtils.isNotEmpty(sKouteikanryoubito))) {
            IwfEditMessageUtil.setMsgResultNG(oResponse, IwfMessageCd.IWF2168);
            return oResponse;
        }

        if ((StringUtils.isNotEmpty(sLastsyoritimefrom) && StringUtils.isEmpty(sLastsyoritimeto))
            || (StringUtils.isEmpty(sLastsyoritimefrom) && StringUtils.isNotEmpty(sLastsyoritimeto))) {
            IwfEditMessageUtil.setMsgResultNG(oResponse, IwfMessageCd.IWF2169);
            return oResponse;
        }

        if (StringUtils.isNotEmpty(sSyoruitoutyakuYmdFrom)) {
            if (!IwfDateUtils.checkDate(sSyoruitoutyakuYmdFrom)) {
                IwfEditMessageUtil.setMsgResultNG(oResponse, IwfMessageCd.IWF3020);
                return oResponse;
            }
            if (StringUtils.isEmpty(sSyoruitoutyakuYmdTo)) {
                IwfEditMessageUtil.setMsgResultNG(oResponse, IwfMessageCd.IWF3024);
                return oResponse;
            }
        }

        if (StringUtils.isNotEmpty(sSyoruitoutyakuYmdTo)) {
            if (!IwfDateUtils.checkDate(sSyoruitoutyakuYmdTo)) {
                IwfEditMessageUtil.setMsgResultNG(oResponse, IwfMessageCd.IWF3023);
                return oResponse;
            }
            if (StringUtils.isEmpty(sSyoruitoutyakuYmdFrom)) {
                IwfEditMessageUtil.setMsgResultNG(oResponse, IwfMessageCd.IWF3024);
                return oResponse;
            }
        }

        return oResponse;
    }

    @Override
    public WSGetKouteiSiteiImagePropsResponse executeBizMain(
        WSGetKouteiSiteiImagePropsRequest request) throws Exception {

        WSGetKouteiSiteiImagePropsResponse oWSResponse = new WSGetKouteiSiteiImagePropsResponse();

        oWSResponse = validate(request);

        if (C_ResultCdKbn.NG.toString().equals(oWSResponse.getKekkastatus())) {
            return oWSResponse;
        }

        String sInGyoumukey         = request.getGyoumukey();
        String[] sInGyoumukeys      = request.getGyoumukeys();
        if (null == sInGyoumukeys && null != sInGyoumukey) {
            sInGyoumukeys = new String[] { sInGyoumukey };
        }

        String sInFlowid = request.getFlowid();
        String[] sInFlowids = request.getFlowids();
        if (null == sInFlowids && null != sInFlowid) {
            sInFlowids = new String[] { sInFlowid };
        }

        String sKouteikaisibifrom   = request.getKouteikaisibifrom();
        String sKouteikaisibito     = request.getKouteikaisibito();
        String sKouteikanryoubifrom = request.getKouteikanryoubifrom();
        String sKouteikanryoubito   = request.getKouteikanryoubito();
        String sLastsyoritimefrom   = request.getLastsyoritimefrom();
        String sLastsyoritimeto     = request.getLastsyoritimeto();
        String[] sSyoristatus       = request.getSyoristatus();
        String sAccountid           = request.getAccountid();
        String sNodename            = request.getNodename();
        String sAccountwariateUmu   = request.getAccountwariateumu();
        String sKekkajyougenkensu   = request.getKekkajyougenkensu();
        String sTantousyaAccountid  = request.getTantousyaAccountid();
        if (StringUtils.isEmpty(sKekkajyougenkensu)) {
            sKekkajyougenkensu = "10000";
        }

        String sTorikomiSyoruiCd = request.getTorikomisyoruicd();
        String sSyoruitoutyakuYmdFrom = request.getSyoruitoutyakuymdfrom();
        String sSyoruitoutyakuYmdTo = request.getSyoruitoutyakuymdto();
        Map<String, WSExtParam> extParamMap = IwfCommonLogic.getExtParams(request);

        oWfCon = WorkflowContextFactory.newInstance();

        ArrayList<ImagePropsBean> imageProps = new ArrayList<>();
        ImagePropsBean imagePropsBean = new ImagePropsBean();

        try{
            oWfCon.open();


            if(!ArrayUtils.isEmpty(sInFlowids) || !StringUtils.isEmpty(sTorikomiSyoruiCd)) {
                List<WM_TorikomiSyorui> syoruiList = iwfCoreDomManager.getTorikomiSyoruis(sTorikomiSyoruiCd, sInFlowids);

                if (syoruiList.isEmpty()) {
                    IwfEditMessageUtil.setMsgResultNG_RecordNotFound(oWSResponse, WM_TorikomiSyorui.TABLE_NAME);
                    return oWSResponse;
                }
            }


            Long count = getImagePropsDao.getCount(sInGyoumukeys, sInFlowids, sKouteikaisibifrom,
                sKouteikaisibito, sKouteikanryoubifrom, sKouteikanryoubito, sLastsyoritimefrom, sLastsyoritimeto,
                sSyoristatus, sTantousyaAccountid, sAccountwariateUmu, sNodename, extParamMap, sTorikomiSyoruiCd, sSyoruitoutyakuYmdFrom, sSyoruitoutyakuYmdTo);

            if (0 == count) {
                IwfEditMessageUtil.setMsgResultOK(oWSResponse, "工程情報指定イメージプロパティ取得");
                oWSResponse.setImagepropslist(imageProps);
                return oWSResponse;
            }

            if (count > Integer.parseInt(sKekkajyougenkensu)) {
                LOGGER.debug("上限件数チェックエラーが発生しました。取得数；" + count + ", 上限件数；" + sKekkajyougenkensu);
                IwfEditMessageUtil.setMsgResultNG(oWSResponse, IwfMessageCd.IWF2160);
                return oWSResponse;
            }


            Set<String> imageAuths =  SWAKInjector.getInstance(WorkflowAuthInfo.class).getImageAuthByUserId(sAccountid);

            List<WT_TorikomiKanri> torikomiKanris = getImagePropsDao.getTorikomiKanriByKouteiInfo(sInGyoumukeys, sInFlowids, sKouteikaisibifrom,
                sKouteikaisibito, sKouteikanryoubifrom, sKouteikanryoubito, sLastsyoritimefrom, sLastsyoritimeto,
                sSyoristatus, sTantousyaAccountid, sAccountwariateUmu, sNodename, extParamMap, sTorikomiSyoruiCd,sSyoruitoutyakuYmdFrom,sSyoruitoutyakuYmdTo);

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
                    imagePropsBean.setFlowid(kouteiSummary.getFlowId());
                    imagePropsBean.setExtparamBean(setExtParamBean(kouteiSummary));
                    imageProps.add(imagePropsBean);
                }
            }
            oWSResponse.setImagepropslist(imageProps);

            IwfEditMessageUtil.setMsgResultOK(oWSResponse, "工程情報指定イメージプロパティ取得");

        } catch (Exception e) {

            if(SWAKInjector.getInstance(CheckException.class).isExceptionShouldThrow(e)){
                throw e;
            }

            LOGGER.error("想定外のエラーが発生しました。", e);
            IwfEditMessageUtil.setMsgResultNG(oWSResponse, IwfMessageCd.IWF0001, "工程情報指定イメージプロパティ取得");

        } finally {

            if(oWfCon.isOpen()){
                oWfCon.close();
            }
        }
        return oWSResponse;
    }


    private ExtParamBean setExtParamBean(WT_KouteiSummary kouteisummary) {
        ExtParamBean extParamBean = new ExtParamBean();
        extParamBean.setExtparam1(kouteisummary.getExtParam1());
        extParamBean.setExtparam2(kouteisummary.getExtParam2());
        extParamBean.setExtparam3(kouteisummary.getExtParam3());
        extParamBean.setExtparam4(kouteisummary.getExtParam4());
        extParamBean.setExtparam5(kouteisummary.getExtParam5());
        extParamBean.setExtparam6(kouteisummary.getExtParam6());
        extParamBean.setExtparam7(kouteisummary.getExtParam7());
        extParamBean.setExtparam8(kouteisummary.getExtParam8());
        extParamBean.setExtparam9(kouteisummary.getExtParam9());
        extParamBean.setExtparam10(kouteisummary.getExtParam10());
        extParamBean.setExtparam11(kouteisummary.getExtParam11());
        extParamBean.setExtparam12(kouteisummary.getExtParam12());
        extParamBean.setExtparam13(kouteisummary.getExtParam13());
        extParamBean.setExtparam14(kouteisummary.getExtParam14());
        extParamBean.setExtparam15(kouteisummary.getExtParam15());
        extParamBean.setExtparam16(kouteisummary.getExtParam16());
        extParamBean.setExtparam17(kouteisummary.getExtParam17());
        extParamBean.setExtparam18(kouteisummary.getExtParam18());
        extParamBean.setExtparam19(kouteisummary.getExtParam19());
        extParamBean.setExtparam20(kouteisummary.getExtParam20());
        extParamBean.setExtparam21(kouteisummary.getExtParam21());
        extParamBean.setExtparam22(kouteisummary.getExtParam22());
        extParamBean.setExtparam23(kouteisummary.getExtParam23());
        extParamBean.setExtparam24(kouteisummary.getExtParam24());
        extParamBean.setExtparam25(kouteisummary.getExtParam25());
        extParamBean.setExtparam26(kouteisummary.getExtParam26());
        extParamBean.setExtparam27(kouteisummary.getExtParam27());
        extParamBean.setExtparam28(kouteisummary.getExtParam28());
        extParamBean.setExtparam29(kouteisummary.getExtParam29());
        extParamBean.setExtparam30(kouteisummary.getExtParam30());

        return extParamBean;
    }
}
