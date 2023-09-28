package yuyu.common.biz.workflow;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import net.arnx.jsonic.JSON;

import org.apache.commons.lang.StringUtils;

import yuyu.common.biz.workflow.io.image.CreateExpectedArrivalNoticeInBean;
import yuyu.common.biz.workflow.io.image.CreateExpectedArrivalNoticeOutBean;
import yuyu.common.biz.workflow.io.image.CreateImageSpaceInBean;
import yuyu.common.biz.workflow.io.image.CreateImageSpaceOutBean;
import yuyu.common.biz.workflow.io.image.DeleteImageSpaceInBean;
import yuyu.common.biz.workflow.io.image.DeleteImageSpaceOutBean;
import yuyu.common.biz.workflow.io.image.DropImageInBean;
import yuyu.common.biz.workflow.io.image.DropImageOutBean;
import yuyu.common.biz.workflow.io.image.GetExpectedArrivalNoticeInBean;
import yuyu.common.biz.workflow.io.image.GetExpectedArrivalNoticeOutBean;
import yuyu.common.biz.workflow.io.image.GetImageInBean;
import yuyu.common.biz.workflow.io.image.GetImageOutBean;
import yuyu.common.biz.workflow.io.image.GetImagePropsInBean;
import yuyu.common.biz.workflow.io.image.GetImagePropsOutBean;
import yuyu.common.biz.workflow.io.image.GetKouteiSiteiImagePropsInBean;
import yuyu.common.biz.workflow.io.image.GetKouteiSiteiImagePropsOutBean;
import yuyu.common.biz.workflow.io.image.GetTorikomiSyoruiMstInBean;
import yuyu.common.biz.workflow.io.image.GetTorikomiSyoruiMstOutBean;
import yuyu.common.biz.workflow.io.image.PutArrivalImageInBean;
import yuyu.common.biz.workflow.io.image.PutArrivalImageOutBean;
import yuyu.common.biz.workflow.io.image.PutImageInBean;
import yuyu.common.biz.workflow.io.image.PutImageOutBean;
import yuyu.common.biz.workflow.io.image.SetImageRelationOutBean;
import yuyu.common.biz.workflow.io.image.SetImageReleationInBean;
import yuyu.common.biz.workflow.io.image.sub.ArrivalNoticeBean;
import yuyu.common.workflowcore.core.iwfinfr.util.IwfBase64Urls;
import yuyu.common.workflowcore.core.webservice.provide.imagekanri.createExpectedArrivalNotice.WSCreateExpectedArrivalNoticeRequest;
import yuyu.common.workflowcore.core.webservice.provide.imagekanri.createExpectedArrivalNotice.WSCreateExpectedArrivalNoticeResponse;
import yuyu.common.workflowcore.core.webservice.provide.imagekanri.dropimagebyid.WSDropImageByIdRequest;
import yuyu.common.workflowcore.core.webservice.provide.imagekanri.dropimagebyid.WSDropImageByIdResponse;
import yuyu.common.workflowcore.core.webservice.provide.imagekanri.getExpectedArrivalNotice.IWSGetExpectedArrivalNoticeIOKey;
import yuyu.common.workflowcore.core.webservice.provide.imagekanri.getExpectedArrivalNotice.WSGetExpectedArrivalNoticeRequest;
import yuyu.common.workflowcore.core.webservice.provide.imagekanri.getExpectedArrivalNotice.WSGetExpectedArrivalNoticeResponse;
import yuyu.common.workflowcore.core.webservice.provide.imagekanri.getKouteiSiteiImageProps.WSGetKouteiSiteiImagePropsRequest;
import yuyu.common.workflowcore.core.webservice.provide.imagekanri.getKouteiSiteiImageProps.WSGetKouteiSiteiImagePropsResponse;
import yuyu.common.workflowcore.core.webservice.provide.imagekanri.getimagebyid.WSGetImageByIdRequest;
import yuyu.common.workflowcore.core.webservice.provide.imagekanri.getimagebyid.WSGetImageByIdResponse;
import yuyu.common.workflowcore.core.webservice.provide.imagekanri.gettargetimageprops.WSGetTargetImagePropsRequest;
import yuyu.common.workflowcore.core.webservice.provide.imagekanri.gettargetimageprops.WSGetTargetImagePropsResponse;
import yuyu.common.workflowcore.core.webservice.provide.imagekanri.gettorikomisyoruimst.WSGetTorikomiSyoruiMstRequest;
import yuyu.common.workflowcore.core.webservice.provide.imagekanri.gettorikomisyoruimst.WSGetTorikomiSyoruiMstResponse;
import yuyu.common.workflowcore.core.webservice.provide.imagekanri.putArrivalImage.WSPutArrivalImageRequest;
import yuyu.common.workflowcore.core.webservice.provide.imagekanri.putArrivalImage.WSPutArrivalImageResponse;
import yuyu.common.workflowcore.core.webservice.provide.imagekanri.putimage.WSPutImageRequest;
import yuyu.common.workflowcore.core.webservice.provide.imagekanri.putimage.WSPutImageResponse;
import yuyu.common.workflowcore.core.webservice.provide.imagekanri.setImageRelation.WSSetImageRelationRequest;
import yuyu.common.workflowcore.core.webservice.provide.imagekanri.setImageRelation.WSSetImageRelationResponse;
import yuyu.common.workflowcore.core.webservice.provide.kouteikanri.execprocesscancel.WSExecProcessCancelRequest;
import yuyu.common.workflowcore.core.webservice.provide.kouteikanri.execprocesscancel.WSExecProcessCancelResponse;
import yuyu.common.workflowcore.core.webservice.provide.kouteikanri.execprocesscreate.WSExecProcessCreateRequest;
import yuyu.common.workflowcore.core.webservice.provide.kouteikanri.execprocesscreate.WSExecProcessCreateResponse;


/**
 * イメージワークフローイメージ管理サービスのクライアントクラスです。</ br>
 * Injectして使用して下さい</ br>
 */
public class IwfImageClient {

    @Inject
    IwfCommonClient client;

    public static final String SYSTEM_IMAGE_SPACE = "system-image-space";

    public WSPutImageResponse execPutImage(PutImageInBean inBean) {

        try {
            IwfClientUtil.validateInBean(inBean, PutImageInBean.class.getSimpleName());

            WSPutImageRequest request = new WSPutImageRequest();
            IwfClientUtil.setCommonRequestParams(inBean, request);

            request.setAccountid(inBean.getAccountid());
            request.setFlowid(inBean.getFlowid());
            request.setGyoumukey(inBean.getGyoumukey());
            request.setSyoruicd(inBean.getSyoruicd());
            request.setSyoruitoutyakutime(inBean.getSyoruitoutyakutime());
            request.setTourokutime(inBean.getTourokutime());
            if (null != inBean.getImagedata()) {
                request.setImagedatastr(IwfBase64Urls.encode(inBean.getImagedata()));
            }
            if (null != inBean.getExtInfo()) {
                request.setExtinfo(IwfBase64Urls.encodeFromString(JSON.encode(inBean.getExtInfo())));
            }

            WSPutImageResponse response = client.execPutImage(request);

            PutImageOutBean outBean = new PutImageOutBean();
            IwfClientUtil.setCommonResponseParams(response, outBean);

            outBean.setImgid(response.getImgid());

            return outBean;
        } catch(RuntimeException re){
            throw re;
        } catch(Exception e){
            throw new RuntimeException(e);
        }
    }

    public WSGetImageByIdResponse execGetImage(GetImageInBean inBean) {

        try {
            IwfClientUtil.validateInBean(inBean, GetImageInBean.class.getSimpleName());

            WSGetImageByIdRequest request = new WSGetImageByIdRequest();
            IwfClientUtil.setCommonRequestParams(inBean, request);

            request.setAccountid(inBean.getAccountid());
            request.setImageids(inBean.getImageids());

            WSGetImageByIdResponse response = client.execGetImage(request);

            GetImageOutBean outBean = new GetImageOutBean();
            IwfClientUtil.setCommonResponseParams(response, outBean);

            outBean.setImageinfolist(response.getImageinfolist());

            return outBean;
        } catch(RuntimeException re){
            throw re;
        } catch(Exception e){
            throw new RuntimeException(e);
        }
    }

    public GetImagePropsOutBean execGetImageProps(GetImagePropsInBean inBean) {

        try {
            IwfClientUtil.validateInBean(inBean, GetImagePropsInBean.class.getSimpleName());

            WSGetTargetImagePropsRequest request = new WSGetTargetImagePropsRequest();
            IwfClientUtil.setCommonRequestParams(inBean, request);

            request.setAccountid(inBean.getAccountid());
            request.setFlowid(inBean.getFlowid());
            request.setGyoumukey(inBean.getGyoumukey());
            request.setTorikomisyoruicd(inBean.getTorikomisyoruicd());
            request.setSyoruitoutyakuymdfrom(inBean.getSyoruitoutyakuymdfrom());
            request.setSyoruitoutyakuymdto(inBean.getSyoruitoutyakuymdto());
            request.setSyzkdaibunruiid(inBean.getSyzkdaibunruiid());
            request.setSyzksyoubunruiid(inBean.getSyzksyoubunruiid());
            request.setKouteijyoutai(inBean.getKouteijyoutai());

            WSGetTargetImagePropsResponse response = client.execGetImageProps(request);

            GetImagePropsOutBean outBean = new GetImagePropsOutBean();
            IwfClientUtil.setCommonResponseParams(response, outBean);

            outBean.setImagepropslist(response.getImagepropslist());

            return outBean;
        } catch(RuntimeException re){
            throw re;
        } catch(Exception e){
            throw new RuntimeException(e);
        }
    }

    public GetKouteiSiteiImagePropsOutBean GetKouteiSiteiImageProps(GetKouteiSiteiImagePropsInBean inBean){
        try {
            IwfClientUtil.validateInBean(inBean, GetKouteiSiteiImagePropsInBean.class.getSimpleName());

            WSGetKouteiSiteiImagePropsRequest request = new WSGetKouteiSiteiImagePropsRequest();
            IwfClientUtil.setCommonRequestParams(inBean, request);

            request.setGyoumukey(inBean.getGyoumukey());
            request.setGyoumukeys(inBean.getGyoumukeys());
            request.setFlowid(inBean.getFlowid());
            request.setFlowids(inBean.getFlowids());
            request.setLastsyoritimefrom(inBean.getLastsyoritimefrom());
            request.setLastsyoritimeto(inBean.getLastsyoritimeto());
            request.setKouteikaisibifrom(inBean.getKouteikaisibifrom());
            request.setKouteikaisibito(inBean.getKouteikaisibito());
            request.setKouteikanryoubifrom(inBean.getKouteikanryoubifrom());
            request.setKouteikanryoubito(inBean.getKouteikanryoubito());
            request.setSyoristatus(inBean.getSyoristatus());
            request.setAccountid(inBean.getAccountid());
            request.setNodename(inBean.getNodename());
            request.setAccountwariateumu(inBean.getAccountwariateumu());
            request.setKekkajyougenkensu(inBean.getKekkajyougenkensu());
            request.setTorikomisyoruicd(inBean.getTorikomisyoruicd());
            request.setSyoruitoutyakuymdfrom(inBean.getSyoruitoutyakuymdfrom());
            request.setSyoruitoutyakuymdto(inBean.getSyoruitoutyakuymdto());
            request.setTantousyaAccountid(inBean.getTantousyaAccountid());

            WSGetKouteiSiteiImagePropsResponse response = client.execGetKouteiSiteiImageProps(request);

            GetKouteiSiteiImagePropsOutBean outBean = new GetKouteiSiteiImagePropsOutBean();
            IwfClientUtil.setCommonResponseParams(response, outBean);

            outBean.setImagepropslist(response.getImagepropslist());

            return outBean;
        } catch(RuntimeException re){
            throw re;
        } catch(Exception e){
            throw new RuntimeException(e);
        }
    }

    public WSDropImageByIdResponse execDropImage(DropImageInBean inBean) {

        try {
            IwfClientUtil.validateInBean(inBean, DropImageInBean.class.getSimpleName());

            WSDropImageByIdRequest request = new WSDropImageByIdRequest();
            IwfClientUtil.setCommonRequestParams(inBean, request);

            request.setAccountid(inBean.getAccountid());
            request.setImageids(inBean.getImageids());
            if (null != inBean.getExtInfo()) {
                request.setExtinfo(IwfBase64Urls.encodeFromString(JSON.encode(inBean.getExtInfo())));
            }

            WSDropImageByIdResponse response = client.execDropImage(request);

            DropImageOutBean outBean = new DropImageOutBean();
            IwfClientUtil.setCommonResponseParams(response, outBean);

            return outBean;
        } catch(RuntimeException re){
            throw re;
        } catch(Exception e){
            throw new RuntimeException(e);
        }
    }

    public WSExecProcessCreateResponse execCreateImageSpace(CreateImageSpaceInBean inBean) {

        try {
            IwfClientUtil.validateInBean(inBean, CreateImageSpaceInBean.class.getSimpleName());

            WSExecProcessCreateRequest request = new WSExecProcessCreateRequest();
            IwfClientUtil.setCommonRequestParams(inBean, request);

            request.setGyoumukey(inBean.getGyoumukey());
            request.setAccountid(inBean.getAccountid());
            request.setFlowid(SYSTEM_IMAGE_SPACE);
            request.setProcessgroup(inBean.getProcessgroup());
            if (StringUtils.isNotEmpty(inBean.getRirekiTaskName())) {
                request.setRirekiTaskName(IwfBase64Urls.encodeFromString(inBean.getRirekiTaskName()));
            }
            List<Map<String, String>> extInfo = inBean.getExtInfo();
            if (null != extInfo) {
                request.setExtinfo(IwfBase64Urls.encodeFromString(JSON.encode(extInfo)));
            }

            WSExecProcessCreateResponse response = client.execProcessCreate(request);

            CreateImageSpaceOutBean outBean = new CreateImageSpaceOutBean();
            IwfClientUtil.setCommonResponseParams(response, outBean);

            return outBean;
        } catch(RuntimeException re){
            throw re;
        } catch(Exception e){
            throw new RuntimeException(e);
        }
    }

    public WSExecProcessCancelResponse execDeleteImageSpace(DeleteImageSpaceInBean inBean) {

        try {
            IwfClientUtil.validateInBean(inBean, DeleteImageSpaceInBean.class.getSimpleName());

            WSExecProcessCancelRequest request = new WSExecProcessCancelRequest();
            IwfClientUtil.setCommonRequestParams(inBean, request);

            request.setFlowid(SYSTEM_IMAGE_SPACE);
            request.setGyoumukey(inBean.getGyoumukey());
            request.setAccountid(inBean.getAccountid());
            request.setLockkey(inBean.getLockkey());

            WSExecProcessCancelResponse response = client.execProcessCancel(request);

            DeleteImageSpaceOutBean outBean = new DeleteImageSpaceOutBean();
            IwfClientUtil.setCommonResponseParams(response, outBean);

            return outBean;
        } catch(RuntimeException re){
            throw re;
        } catch(Exception e){
            throw new RuntimeException(e);
        }
    }

    public WSGetTorikomiSyoruiMstResponse execGetTorikomiSyoruiMst(GetTorikomiSyoruiMstInBean inBean) {

        try {
            IwfClientUtil.validateInBean(inBean, GetTorikomiSyoruiMstInBean.class.getSimpleName());

            WSGetTorikomiSyoruiMstRequest request = new WSGetTorikomiSyoruiMstRequest();
            IwfClientUtil.setCommonRequestParams(inBean, request);

            request.setTorikomisyoruicd(inBean.getTorikomisyoruicd());
            request.setSyzkdaibunruiid(inBean.getSyzkdaibunruiid());
            request.setSyzksyoubunruiid(inBean.getSyzksyoubunruiid());
            request.setFlowid(inBean.getFlowid());
            request.setNodeid(inBean.getNodeid());

            WSGetTorikomiSyoruiMstResponse response = client.execGetTorikomiSyoruiMst(request);

            GetTorikomiSyoruiMstOutBean outBean = new GetTorikomiSyoruiMstOutBean();
            IwfClientUtil.setCommonResponseParams(response, outBean);

            outBean.setTorikomisyoruilist(response.getTorikomisyoruilist());

            return outBean;
        } catch(RuntimeException re){
            throw re;
        } catch(Exception e){
            throw new RuntimeException(e);
        }
    }

    public WSCreateExpectedArrivalNoticeResponse CreateExpectedArrivalNotice(CreateExpectedArrivalNoticeInBean inBean) {

        try {
            IwfClientUtil.validateInBean(inBean, CreateExpectedArrivalNoticeInBean.class.getSimpleName());

            WSCreateExpectedArrivalNoticeRequest request = new WSCreateExpectedArrivalNoticeRequest();
            IwfClientUtil.setCommonRequestParams(inBean, request);

            request.setArrivekey(inBean.getArrivekey());
            request.setGyoumukey(inBean.getGyoumukey());
            request.setTorikomisyoruicd(inBean.getTorikomisyoruicd());
            request.setFlowid(inBean.getFlowid());
            request.setSubsystemid(inBean.getSubsystemid());

            WSCreateExpectedArrivalNoticeResponse response = client.execCreateExpectedArrivalNotice(request);

            CreateExpectedArrivalNoticeOutBean outBean = new CreateExpectedArrivalNoticeOutBean();
            IwfClientUtil.setCommonResponseParams(response, outBean);

            return outBean;
        } catch(RuntimeException re){
            throw re;
        } catch(Exception e){
            throw new RuntimeException(e);
        }
    }

    public GetExpectedArrivalNoticeOutBean GetExpectedArrivalNotice(GetExpectedArrivalNoticeInBean inBean) {

        try {
            IwfClientUtil.validateInBean(inBean, GetExpectedArrivalNoticeInBean.class.getSimpleName());

            WSGetExpectedArrivalNoticeRequest request = new WSGetExpectedArrivalNoticeRequest();
            IwfClientUtil.setCommonRequestParams(inBean, request);

            request.setArrivekey(inBean.getArrivekey());
            request.setFlowid(inBean.getFlowid());
            request.setGyoumukey(inBean.getGyoumukey());
            request.setTorikomisyoruicd(inBean.getTorikomisyoruicd());
            request.setSubsystemid(inBean.getSubsystemid());

            WSGetExpectedArrivalNoticeResponse response = client.execGetExpectedArrivalNotice(request);

            GetExpectedArrivalNoticeOutBean outBean = new GetExpectedArrivalNoticeOutBean();
            IwfClientUtil.setCommonResponseParams(response, outBean);

            if (null != response.getNoticemaps()) {
                List<ArrivalNoticeBean> noticeInfos = new ArrayList<ArrivalNoticeBean>();

                for (Map<String, String> map : response.getNoticemaps()) {

                    ArrivalNoticeBean noticeInfo = new ArrivalNoticeBean();

                    noticeInfo.setArriveKey(map.get(IWSGetExpectedArrivalNoticeIOKey.MapKey.sS_ARRIVEKEY));
                    noticeInfo.setFlowId(map.get(IWSGetExpectedArrivalNoticeIOKey.MapKey.sS_FLOWID));
                    noticeInfo.setGyoumuKey(map.get(IWSGetExpectedArrivalNoticeIOKey.MapKey.sS_GYOUMUKEY));
                    noticeInfo.setTorikomisyoruiCd(map.get(IWSGetExpectedArrivalNoticeIOKey.MapKey.sS_TORIKOMISYORUICD));
                    noticeInfo.setSubsystemId(map.get(IWSGetExpectedArrivalNoticeIOKey.MapKey.sS_SUBSYSTEMID));

                    noticeInfos.add(noticeInfo);
                }
                outBean.setNoticeBeanList(noticeInfos);
            }

            return outBean;
        } catch(RuntimeException re){
            throw re;
        } catch(Exception e){
            throw new RuntimeException(e);
        }
    }

    public WSPutArrivalImageResponse PutArrivalImage(PutArrivalImageInBean inBean) {

        try {
            IwfClientUtil.validateInBean(inBean, PutArrivalImageInBean.class.getSimpleName());

            WSPutArrivalImageRequest request = new WSPutArrivalImageRequest();
            IwfClientUtil.setCommonRequestParams(inBean, request);

            request.setArrivekey(inBean.getArrivekey());
            if (null != inBean.getImagedata()) {
                request.setImagedatastr(IwfBase64Urls.encode(inBean.getImagedata()));
            }

            WSPutArrivalImageResponse response = client.execPutArrivalImage(request);

            PutArrivalImageOutBean outBean = new PutArrivalImageOutBean();
            IwfClientUtil.setCommonResponseParams(response, outBean);
            outBean.setCberrmsg(response.getCberrmsg());

            return outBean;
        } catch(RuntimeException re){
            throw re;
        } catch(Exception e){
            throw new RuntimeException(e);
        }
    }

    public WSSetImageRelationResponse setImageRelation(SetImageReleationInBean inBean) {

        try {
            IwfClientUtil.validateInBean(inBean, SetImageReleationInBean.class.getSimpleName());

            WSSetImageRelationRequest request = new WSSetImageRelationRequest();
            IwfClientUtil.setCommonRequestParams(inBean, request);

            request.setImageid(inBean.getImageid());
            request.setGyoumukeys(inBean.getGyoumukeys());
            request.setSyorikbn(inBean.getSyorikbn());

            WSSetImageRelationResponse response = client.execSetImageRelation(request);

            SetImageRelationOutBean outBean = new SetImageRelationOutBean();
            IwfClientUtil.setCommonResponseParams(response, outBean);

            return outBean;
        } catch(RuntimeException re){
            throw re;
        } catch(Exception e){
            throw new RuntimeException(e);
        }
    }

}