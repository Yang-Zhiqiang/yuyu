package yuyu.common.biz.workflow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import jp.co.slcs.swak.uniquekey.UniqueKeyGenerator;
import yuyu.common.biz.workflow.io.account.CreateTaskAuthorityInBean;
import yuyu.common.biz.workflow.io.account.CreateTaskAuthorityOutBean;
import yuyu.common.biz.workflow.io.account.DelImageAuthorityInBean;
import yuyu.common.biz.workflow.io.account.DelImageAuthorityOutBean;
import yuyu.common.biz.workflow.io.account.DeleteTaskAuthorityInBean;
import yuyu.common.biz.workflow.io.account.DeleteTaskAuthorityOutBean;
import yuyu.common.biz.workflow.io.account.GetImageAuthorityInBean;
import yuyu.common.biz.workflow.io.account.GetImageAuthorityOutBean;
import yuyu.common.biz.workflow.io.account.UpdImageAuthorityInBean;
import yuyu.common.biz.workflow.io.account.UpdImageAuthorityOutBean;
import yuyu.common.biz.workflow.io.account.sub.TaskAuthorityBean;
import yuyu.common.workflowcore.core.iwfinfr.util.IwfBase64Urls;
import yuyu.common.workflowcore.core.iwfinfr.util.IwfCompressUtils;
import yuyu.common.workflowcore.core.webservice.provide.accountkanri.createtaskauthority.IWSCreateTaskAuthorityIOKey;
import yuyu.common.workflowcore.core.webservice.provide.accountkanri.createtaskauthority.WSCreateTaskAuthorityRequest;
import yuyu.common.workflowcore.core.webservice.provide.accountkanri.createtaskauthority.WSCreateTaskAuthorityResponse;
import yuyu.common.workflowcore.core.webservice.provide.accountkanri.delimageauthority.WSDelImageAuthorityRequest;
import yuyu.common.workflowcore.core.webservice.provide.accountkanri.delimageauthority.WSDelImageAuthorityResponse;
import yuyu.common.workflowcore.core.webservice.provide.accountkanri.deltaskauthority.WSDelTaskAuthorityRequest;
import yuyu.common.workflowcore.core.webservice.provide.accountkanri.deltaskauthority.WSDelTaskAuthorityResponse;
import yuyu.common.workflowcore.core.webservice.provide.accountkanri.getimageauthority.WSGetImageAuthorityRequest;
import yuyu.common.workflowcore.core.webservice.provide.accountkanri.getimageauthority.WSGetImageAuthorityResponse;
import yuyu.common.workflowcore.core.webservice.provide.accountkanri.updimageauthority.WSUpdImageAuthorityRequest;
import yuyu.common.workflowcore.core.webservice.provide.accountkanri.updimageauthority.WSUpdImageAuthorityResponse;

import com.thoughtworks.xstream.XStream;


/**
 * イメージワークフローアカウント管理サービスのクライアントクラスです。</ br>
 * Injectして使用して下さい</ br>
 */
public class IwfAccountClient {

    @Inject
    IwfCommonClient client;

    @Inject
    UniqueKeyGenerator uniqueKey;

    public CreateTaskAuthorityOutBean execCreateTaskAuthority(CreateTaskAuthorityInBean inBean) {

        try {
            IwfClientUtil.validateInBean(inBean, CreateTaskAuthorityInBean.class.getSimpleName());

            WSCreateTaskAuthorityRequest request = new WSCreateTaskAuthorityRequest();
            IwfClientUtil.setCommonRequestParams(inBean, request);

            request.setAccountid(inBean.getAccountid());

            List<Map<String, String>> oMapList = new ArrayList<Map<String, String>>();
            if (null != inBean.getTaskAuthorityBeanList()) {
                for (TaskAuthorityBean oAuthBean : inBean.getTaskAuthorityBeanList()) {
                    Map<String, String> oMap = new HashMap<String, String>();
                    oMap.put(IWSCreateTaskAuthorityIOKey.MapKey.sS_FLOWID, oAuthBean.getFlowid());
                    oMap.put(IWSCreateTaskAuthorityIOKey.MapKey.sS_NODENAME, oAuthBean.getTaskname());
                    oMap.put(IWSCreateTaskAuthorityIOKey.MapKey.sS_ROLECD, IwfClientUtil.createAuthid(oAuthBean.getRolecds()));
                    oMapList.add(oMap);
                }
            }
            if(!oMapList.isEmpty()){
                request.setMaplistXml(IwfBase64Urls.encode(IwfCompressUtils.compress(new XStream().toXML(oMapList))));
            }

            WSCreateTaskAuthorityResponse response = client.execCreateTaskAuthority(request);

            CreateTaskAuthorityOutBean outBean = new CreateTaskAuthorityOutBean();
            IwfClientUtil.setCommonResponseParams(response, outBean);

            return outBean;

        } catch(RuntimeException re){
            throw re;
        } catch(Exception e){
            throw new RuntimeException(e);
        }
    }

    public WSDelTaskAuthorityResponse execDelTaskAuthority(DeleteTaskAuthorityInBean inBean) {

        try {
            IwfClientUtil.validateInBean(inBean, DeleteTaskAuthorityInBean.class.getSimpleName());

            WSDelTaskAuthorityRequest request = new WSDelTaskAuthorityRequest();
            IwfClientUtil.setCommonRequestParams(inBean, request);

            request.setAccountid(inBean.getAccountid());

            List<Map<String, String>> oMapList = new ArrayList<Map<String, String>>();
            if (null != inBean.getTaskAuthorityBeanList()) {
                for (TaskAuthorityBean oAuthBean : inBean.getTaskAuthorityBeanList()) {
                    Map<String, String> oMap = new HashMap<String, String>();
                    oMap.put(IWSCreateTaskAuthorityIOKey.MapKey.sS_FLOWID, oAuthBean.getFlowid());
                    oMap.put(IWSCreateTaskAuthorityIOKey.MapKey.sS_NODENAME, oAuthBean.getTaskname());
                    oMap.put(IWSCreateTaskAuthorityIOKey.MapKey.sS_ROLECD, IwfClientUtil.createAuthid(oAuthBean.getRolecds()));
                    oMapList.add(oMap);
                }
            }
            if(!oMapList.isEmpty()){
                request.setMaplistXml(IwfBase64Urls.encode(IwfCompressUtils.compress(new XStream().toXML(oMapList))));
            }

            WSDelTaskAuthorityResponse response = client.execDelTaskAuthority(request);

            DeleteTaskAuthorityOutBean outBean = new DeleteTaskAuthorityOutBean();
            IwfClientUtil.setCommonResponseParams(response, outBean);

            return outBean;

        } catch(RuntimeException re){
            throw re;
        } catch(Exception e){
            throw new RuntimeException(e);
        }
    }

    public WSGetImageAuthorityResponse execGetImageAuthority(GetImageAuthorityInBean inBean) {

        try {
            IwfClientUtil.validateInBean(inBean, GetImageAuthorityInBean.class.getSimpleName());

            WSGetImageAuthorityRequest request = new WSGetImageAuthorityRequest();
            IwfClientUtil.setCommonRequestParams(inBean, request);

            request.setImageauthid(inBean.getImageauthid());

            WSGetImageAuthorityResponse response = client.execGetImageAuthority(request);

            GetImageAuthorityOutBean outBean = new GetImageAuthorityOutBean();
            IwfClientUtil.setCommonResponseParams(response, outBean);

            outBean.setTorikomiSyoruiCds(response.getTorikomiSyoruiCds());

            return outBean;

        } catch(RuntimeException re){
            throw re;
        } catch(Exception e){
            throw new RuntimeException(e);
        }
    }

    public WSUpdImageAuthorityResponse execUpdImageAuthority(UpdImageAuthorityInBean inBean) {

        try {
            IwfClientUtil.validateInBean(inBean, UpdImageAuthorityInBean.class.getSimpleName());

            WSUpdImageAuthorityRequest request = new WSUpdImageAuthorityRequest();
            IwfClientUtil.setCommonRequestParams(inBean, request);

            request.setImageauthid(inBean.getImageauthid());
            request.setTorikomisyoruicds(inBean.getTorikomisyoruicds());

            WSUpdImageAuthorityResponse response = client.execUpdImageAuthority(request);

            UpdImageAuthorityOutBean outBean = new UpdImageAuthorityOutBean();
            IwfClientUtil.setCommonResponseParams(response, outBean);

            return outBean;

        } catch(RuntimeException re){
            throw re;
        } catch(Exception e){
            throw new RuntimeException(e);
        }
    }

    public WSDelImageAuthorityResponse execDelImageAuthority(DelImageAuthorityInBean inBean) {

        try {
            IwfClientUtil.validateInBean(inBean, DelImageAuthorityInBean.class.getSimpleName());

            WSDelImageAuthorityRequest request = new WSDelImageAuthorityRequest();
            IwfClientUtil.setCommonRequestParams(inBean, request);

            request.setImageauthids(inBean.getImageauthids());
            request.setRequestid(inBean.getRequestid());

            WSDelImageAuthorityResponse response = client.execDelImageAuthority(request);

            DelImageAuthorityOutBean outBean = new DelImageAuthorityOutBean();
            IwfClientUtil.setCommonResponseParams(response, outBean);

            return outBean;

        } catch(RuntimeException re){
            throw re;
        } catch(Exception e){
            throw new RuntimeException(e);
        }
    }
}

