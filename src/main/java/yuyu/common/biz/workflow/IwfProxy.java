package yuyu.common.biz.workflow;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.jboss.resteasy.annotations.Form;


/**
 * Webサービスのスタブです。
 * http://{servername}:{portno}/{context}/ws/{path1}/{path2}
 * <pre>
 * このソースは全てツールから吐き出されています。
 * ツール吐き出し後は手で編集しても構いませんが、その場合は更新日と名前を入力する必要があります。
 * ツールで吐き出しなおした場合、その限りではありません。
 * </pre>
 */
@Path("")
public interface IwfProxy {


    @POST
    @Path("/" + yuyu.common.workflowcore.core.webservice.provide.accountkanri.updauthority.WSUpdAuthorityRequest.sSERVICE_NAME)
    @Produces(MediaType.APPLICATION_JSON)
    public String execUpdAuthority(@Form yuyu.common.workflowcore.core.webservice.provide.accountkanri.updauthority.WSUpdAuthorityRequest form) throws Exception;


    @POST
    @Path("/" + yuyu.common.workflowcore.core.webservice.provide.accountkanri.delauthority.WSDelAuthorityRequest.sSERVICE_NAME)
    @Produces(MediaType.APPLICATION_JSON)
    public String execDelAuthority(@Form yuyu.common.workflowcore.core.webservice.provide.accountkanri.delauthority.WSDelAuthorityRequest form) throws Exception;


    @POST
    @Path("/" + yuyu.common.workflowcore.core.webservice.provide.accountkanri.updimageauthority.WSUpdImageAuthorityRequest.sSERVICE_NAME)
    @Produces(MediaType.APPLICATION_JSON)
    public String execUpdImageAuthority(@Form yuyu.common.workflowcore.core.webservice.provide.accountkanri.updimageauthority.WSUpdImageAuthorityRequest form) throws Exception;


    @POST
    @Path("/" + yuyu.common.workflowcore.core.webservice.provide.accountkanri.delimageauthority.WSDelImageAuthorityRequest.sSERVICE_NAME)
    @Produces(MediaType.APPLICATION_JSON)
    public String execDelImageAuthority(@Form yuyu.common.workflowcore.core.webservice.provide.accountkanri.delimageauthority.WSDelImageAuthorityRequest form) throws Exception;


    @POST
    @Path("/" + yuyu.common.workflowcore.core.webservice.provide.accountkanri.getauthinfo.WSGetAuthInfoRequest.sSERVICE_NAME)
    @Produces(MediaType.APPLICATION_JSON)
    public String execGetAuthInfo(@Form yuyu.common.workflowcore.core.webservice.provide.accountkanri.getauthinfo.WSGetAuthInfoRequest form) throws Exception;


    @POST
    @Path("/" + yuyu.common.workflowcore.core.webservice.provide.accountkanri.createtaskauthority.WSCreateTaskAuthorityRequest.sSERVICE_NAME)
    @Produces(MediaType.APPLICATION_JSON)
    public String execCreateTaskAuthority(@Form yuyu.common.workflowcore.core.webservice.provide.accountkanri.createtaskauthority.WSCreateTaskAuthorityRequest form) throws Exception;


    @POST
    @Path("/" + yuyu.common.workflowcore.core.webservice.provide.accountkanri.deltaskauthority.WSDelTaskAuthorityRequest.sSERVICE_NAME)
    @Produces(MediaType.APPLICATION_JSON)
    public String execDelTaskAuthority(@Form yuyu.common.workflowcore.core.webservice.provide.accountkanri.deltaskauthority.WSDelTaskAuthorityRequest form) throws Exception;


    @POST
    @Path("/" + yuyu.common.workflowcore.core.webservice.provide.kouteikanri.exectaskstart.WSExecTaskStartRequest.sSERVICE_NAME)
    @Produces(MediaType.APPLICATION_JSON)
    public String execExecTaskStart(@Form yuyu.common.workflowcore.core.webservice.provide.kouteikanri.exectaskstart.WSExecTaskStartRequest form) throws Exception;


    @POST
    @Path("/" + yuyu.common.workflowcore.core.webservice.provide.kouteikanri.execprocessforward.WSExecProcessForwardRequest.sSERVICE_NAME)
    @Produces(MediaType.APPLICATION_JSON)
    public String execExecProcessForward(@Form yuyu.common.workflowcore.core.webservice.provide.kouteikanri.execprocessforward.WSExecProcessForwardRequest form) throws Exception;


    @POST
    @Path("/" + yuyu.common.workflowcore.core.webservice.provide.kouteikanri.execprocessupdate.WSExecProcessUpdateRequest.sSERVICE_NAME)
    @Produces(MediaType.APPLICATION_JSON)
    public String execExecProcessUpdate(@Form yuyu.common.workflowcore.core.webservice.provide.kouteikanri.execprocessupdate.WSExecProcessUpdateRequest form) throws Exception;


    @POST
    @Path("/" + yuyu.common.workflowcore.core.webservice.provide.kouteikanri.exectaskcancel.WSExecTaskCancelRequest.sSERVICE_NAME)
    @Produces(MediaType.APPLICATION_JSON)
    public String execExecTaskCancel(@Form yuyu.common.workflowcore.core.webservice.provide.kouteikanri.exectaskcancel.WSExecTaskCancelRequest form) throws Exception;


    @POST
    @Path("/" + yuyu.common.workflowcore.core.webservice.provide.kouteikanri.execprocesscreate.WSExecProcessCreateRequest.sSERVICE_NAME)
    @Produces(MediaType.APPLICATION_JSON)
    public String execExecProcessCreate(@Form yuyu.common.workflowcore.core.webservice.provide.kouteikanri.execprocesscreate.WSExecProcessCreateRequest form) throws Exception;


    @POST
    @Path("/" + yuyu.common.workflowcore.core.webservice.provide.kouteikanri.getprocessinfo.WSGetProcessInfoRequest.sSERVICE_NAME)
    @Produces(MediaType.APPLICATION_JSON)
    public String execGetProcessInfo(@Form yuyu.common.workflowcore.core.webservice.provide.kouteikanri.getprocessinfo.WSGetProcessInfoRequest form) throws Exception;


    @POST
    @Path("/" + yuyu.common.workflowcore.core.webservice.provide.kouteikanri.getexecutabletasks.WSGetExecutableTasksRequest.sSERVICE_NAME)
    @Produces(MediaType.APPLICATION_JSON)
    public String execGetExecutableTasks(@Form yuyu.common.workflowcore.core.webservice.provide.kouteikanri.getexecutabletasks.WSGetExecutableTasksRequest form) throws Exception;


    @POST
    @Path("/" + yuyu.common.workflowcore.core.webservice.provide.kouteikanri.gettaskprocesses.WSGetTaskProcessesRequest.sSERVICE_NAME)
    @Produces(MediaType.APPLICATION_JSON)
    public String execGetTaskProcesses(@Form yuyu.common.workflowcore.core.webservice.provide.kouteikanri.gettaskprocesses.WSGetTaskProcessesRequest form) throws Exception;


    @POST
    @Path("/" + yuyu.common.workflowcore.core.webservice.provide.kouteikanri.lockprocess.WSLockProcessRequest.sSERVICE_NAME)
    @Produces(MediaType.APPLICATION_JSON)
    public String execLockProcess(@Form yuyu.common.workflowcore.core.webservice.provide.kouteikanri.lockprocess.WSLockProcessRequest form) throws Exception;


    @POST
    @Path("/" + yuyu.common.workflowcore.core.webservice.provide.kouteikanri.unlockprocess.WSUnlockProcessRequest.sSERVICE_NAME)
    @Produces(MediaType.APPLICATION_JSON)
    public String execUnlockProcess(@Form yuyu.common.workflowcore.core.webservice.provide.kouteikanri.unlockprocess.WSUnlockProcessRequest form) throws Exception;


    @POST
    @Path("/" + yuyu.common.workflowcore.core.webservice.provide.kouteikanri.getprocessattribute.WSGetProcessAttributeRequest.sSERVICE_NAME)
    @Produces(MediaType.APPLICATION_JSON)
    public String execGetProcessAttribute(@Form yuyu.common.workflowcore.core.webservice.provide.kouteikanri.getprocessattribute.WSGetProcessAttributeRequest form) throws Exception;


    @POST
    @Path("/" + yuyu.common.workflowcore.core.webservice.provide.kouteikanri.setprocessattribute.WSSetProcessAttributeRequest.sSERVICE_NAME)
    @Produces(MediaType.APPLICATION_JSON)
    public String execSetProcessAttribute(@Form yuyu.common.workflowcore.core.webservice.provide.kouteikanri.setprocessattribute.WSSetProcessAttributeRequest form) throws Exception;


    @POST
    @Path("/" + yuyu.common.workflowcore.core.webservice.provide.kouteikanri.getkouteirirekisyousai.WSGetKouteiRirekiSyousaiRequest.sSERVICE_NAME)
    @Produces(MediaType.APPLICATION_JSON)
    public String execGetKouteiRirekiSyousai(@Form yuyu.common.workflowcore.core.webservice.provide.kouteikanri.getkouteirirekisyousai.WSGetKouteiRirekiSyousaiRequest form) throws Exception;


    @POST
    @Path("/" + yuyu.common.workflowcore.core.webservice.provide.kouteikanri.gettasks.WSGetTasksRequest.sSERVICE_NAME)
    @Produces(MediaType.APPLICATION_JSON)
    public String execGetTasks(@Form yuyu.common.workflowcore.core.webservice.provide.kouteikanri.gettasks.WSGetTasksRequest form) throws Exception;


    @POST
    @Path("/" + yuyu.common.workflowcore.core.webservice.provide.kouteikanri.getsometask.WSGetSomeTaskRequest.sSERVICE_NAME)
    @Produces(MediaType.APPLICATION_JSON)
    public String execGetSomeTask(@Form yuyu.common.workflowcore.core.webservice.provide.kouteikanri.getsometask.WSGetSomeTaskRequest form) throws Exception;


    @POST
    @Path("/" + yuyu.common.workflowcore.core.webservice.provide.kouteikanri.getkouteirirekisummary.WSGetKouteiRirekiSummaryRequest.sSERVICE_NAME)
    @Produces(MediaType.APPLICATION_JSON)
    public String execGetKouteiRirekiSummary(@Form yuyu.common.workflowcore.core.webservice.provide.kouteikanri.getkouteirirekisummary.WSGetKouteiRirekiSummaryRequest form) throws Exception;


    @POST
    @Path("/" + yuyu.common.workflowcore.core.webservice.provide.kouteikanri.execforceprocessforward.WSExecForceProcessForwardRequest.sSERVICE_NAME)
    @Produces(MediaType.APPLICATION_JSON)
    public String execExecForceProcessForward(@Form yuyu.common.workflowcore.core.webservice.provide.kouteikanri.execforceprocessforward.WSExecForceProcessForwardRequest form) throws Exception;


    @POST
    @Path("/" + yuyu.common.workflowcore.core.webservice.provide.kouteikanri.gettransitions.WSGetTransitionsRequest.sSERVICE_NAME)
    @Produces(MediaType.APPLICATION_JSON)
    public String execGetTransitions(@Form yuyu.common.workflowcore.core.webservice.provide.kouteikanri.gettransitions.WSGetTransitionsRequest form) throws Exception;


    @POST
    @Path("/" + yuyu.common.workflowcore.core.webservice.provide.kouteikanri.execprocesscancel.WSExecProcessCancelRequest.sSERVICE_NAME)
    @Produces(MediaType.APPLICATION_JSON)
    public String execExecProcessCancel(@Form yuyu.common.workflowcore.core.webservice.provide.kouteikanri.execprocesscancel.WSExecProcessCancelRequest form) throws Exception;


    @POST
    @Path("/" + yuyu.common.workflowcore.core.webservice.provide.kouteikanri.forceunlockprocess.WSForceUnlockProcessRequest.sSERVICE_NAME)
    @Produces(MediaType.APPLICATION_JSON)
    public String execForceUnlockProcess(@Form yuyu.common.workflowcore.core.webservice.provide.kouteikanri.forceunlockprocess.WSForceUnlockProcessRequest form) throws Exception;


    @POST
    @Path("/" + yuyu.common.workflowcore.core.webservice.provide.kouteikanri.gettaskdefs.WSGetTaskDefsRequest.sSERVICE_NAME)
    @Produces(MediaType.APPLICATION_JSON)
    public String execGetTaskDefs(@Form yuyu.common.workflowcore.core.webservice.provide.kouteikanri.gettaskdefs.WSGetTaskDefsRequest form) throws Exception;


    @POST
    @Path("/" + yuyu.common.workflowcore.core.webservice.provide.kouteikanri.createprocessrecord.WSCreateProcessRecordRequest.sSERVICE_NAME)
    @Produces(MediaType.APPLICATION_JSON)
    public String execCreateProcessRecord(@Form yuyu.common.workflowcore.core.webservice.provide.kouteikanri.createprocessrecord.WSCreateProcessRecordRequest form) throws Exception;


    @POST
    @Path("/" + yuyu.common.workflowcore.core.webservice.provide.kouteikanri.ikkatuprocesscreate.WSIkkatuProcessCreateRequest.sSERVICE_NAME)
    @Produces(MediaType.APPLICATION_JSON)
    public String execIkkatuProcessCreate(@Form yuyu.common.workflowcore.core.webservice.provide.kouteikanri.ikkatuprocesscreate.WSIkkatuProcessCreateRequest form) throws Exception;


    @POST
    @Path("/" + yuyu.common.workflowcore.core.webservice.provide.imagekanri.gettargetimages.WSGetTargetImagesRequest.sSERVICE_NAME)
    @Produces(MediaType.APPLICATION_JSON)
    public String execGetTargetImages(@Form yuyu.common.workflowcore.core.webservice.provide.imagekanri.gettargetimages.WSGetTargetImagesRequest form) throws Exception;


    @POST
    @Path("/" + yuyu.common.workflowcore.core.webservice.provide.imagekanri.gettargetimageprops.WSGetTargetImagePropsRequest.sSERVICE_NAME)
    @Produces(MediaType.APPLICATION_JSON)
    public String execGetTargetImageProps(@Form yuyu.common.workflowcore.core.webservice.provide.imagekanri.gettargetimageprops.WSGetTargetImagePropsRequest form) throws Exception;


    @POST
    @Path("/" + yuyu.common.workflowcore.core.webservice.provide.imagekanri.getqrcodeimages.WSGetQrCodeImagesRequest.sSERVICE_NAME)
    @Produces(MediaType.APPLICATION_JSON)
    public String execGetQrCodeImages(@Form yuyu.common.workflowcore.core.webservice.provide.imagekanri.getqrcodeimages.WSGetQrCodeImagesRequest form) throws Exception;


    @POST
    @Path("/" + yuyu.common.workflowcore.core.webservice.provide.imagekanri.outputqrcodeimages.WSOutputQrCodeImagesRequest.sSERVICE_NAME)
    @Produces(MediaType.APPLICATION_JSON)
    public String execOutputQrCodeImages(@Form yuyu.common.workflowcore.core.webservice.provide.imagekanri.outputqrcodeimages.WSOutputQrCodeImagesRequest form) throws Exception;


    @POST
    @Path("/" + yuyu.common.workflowcore.core.webservice.provide.imagekanri.getimagebyid.WSGetImageByIdRequest.sSERVICE_NAME)
    @Produces(MediaType.APPLICATION_JSON)
    public String execGetImageById(@Form yuyu.common.workflowcore.core.webservice.provide.imagekanri.getimagebyid.WSGetImageByIdRequest form) throws Exception;


    @POST
    @Path("/" + yuyu.common.workflowcore.core.webservice.provide.imagekanri.getimagepropsbyid.WSGetImagePropsByIdRequest.sSERVICE_NAME)
    @Produces(MediaType.APPLICATION_JSON)
    public String execGetImagePropsById(@Form yuyu.common.workflowcore.core.webservice.provide.imagekanri.getimagepropsbyid.WSGetImagePropsByIdRequest form) throws Exception;


    @POST
    @Path("/" + yuyu.common.workflowcore.core.webservice.provide.imagekanri.dropimagebyid.WSDropImageByIdRequest.sSERVICE_NAME)
    @Produces(MediaType.APPLICATION_JSON)
    public String execDropImageById(@Form yuyu.common.workflowcore.core.webservice.provide.imagekanri.dropimagebyid.WSDropImageByIdRequest form) throws Exception;


    @POST
    @Path("/" + yuyu.common.workflowcore.core.webservice.provide.imagekanri.gettorikomisyoruimst.WSGetTorikomiSyoruiMstRequest.sSERVICE_NAME)
    @Produces(MediaType.APPLICATION_JSON)
    public String execGetTorikomiSyoruiMst(@Form yuyu.common.workflowcore.core.webservice.provide.imagekanri.gettorikomisyoruimst.WSGetTorikomiSyoruiMstRequest form) throws Exception;


    @POST
    @Path("/" + yuyu.common.workflowcore.core.webservice.provide.imagekanri.putimage.WSPutImageRequest.sSERVICE_NAME)
    @Produces(MediaType.APPLICATION_JSON)
    public String execPutImage(@Form yuyu.common.workflowcore.core.webservice.provide.imagekanri.putimage.WSPutImageRequest form) throws Exception;


}

