package yuyu.common.biz.workflow;

import yuyu.common.workflowcore.core.webservice.provide.accountkanri.createtaskauthority.WSCreateTaskAuthorityRequest;
import yuyu.common.workflowcore.core.webservice.provide.accountkanri.createtaskauthority.WSCreateTaskAuthorityResponse;
import yuyu.common.workflowcore.core.webservice.provide.accountkanri.delimageauthority.WSDelImageAuthorityRequest;
import yuyu.common.workflowcore.core.webservice.provide.accountkanri.delimageauthority.WSDelImageAuthorityResponse;
import yuyu.common.workflowcore.core.webservice.provide.accountkanri.deltaskauthority.WSDelTaskAuthorityRequest;
import yuyu.common.workflowcore.core.webservice.provide.accountkanri.deltaskauthority.WSDelTaskAuthorityResponse;
import yuyu.common.workflowcore.core.webservice.provide.accountkanri.getauthinfo.WSGetAuthInfoRequest;
import yuyu.common.workflowcore.core.webservice.provide.accountkanri.getauthinfo.WSGetAuthInfoResponse;
import yuyu.common.workflowcore.core.webservice.provide.accountkanri.getimageauthority.WSGetImageAuthorityRequest;
import yuyu.common.workflowcore.core.webservice.provide.accountkanri.getimageauthority.WSGetImageAuthorityResponse;
import yuyu.common.workflowcore.core.webservice.provide.accountkanri.gettaskauthinfo.WSGetTaskAuthInfoRequest;
import yuyu.common.workflowcore.core.webservice.provide.accountkanri.gettaskauthinfo.WSGetTaskAuthInfoResponse;
import yuyu.common.workflowcore.core.webservice.provide.accountkanri.updauthority.WSUpdAuthorityRequest;
import yuyu.common.workflowcore.core.webservice.provide.accountkanri.updauthority.WSUpdAuthorityResponse;
import yuyu.common.workflowcore.core.webservice.provide.accountkanri.updimageauthority.WSUpdImageAuthorityRequest;
import yuyu.common.workflowcore.core.webservice.provide.accountkanri.updimageauthority.WSUpdImageAuthorityResponse;
import yuyu.common.workflowcore.core.webservice.provide.datakanri.deleteprocessandjbpmrecord.WSDeleteProcessAndJBPMRecordRequest;
import yuyu.common.workflowcore.core.webservice.provide.datakanri.deleteprocessandjbpmrecord.WSDeleteProcessAndJBPMRecordResponse;
import yuyu.common.workflowcore.core.webservice.provide.imagekanri.createExpectedArrivalNotice.WSCreateExpectedArrivalNoticeRequest;
import yuyu.common.workflowcore.core.webservice.provide.imagekanri.createExpectedArrivalNotice.WSCreateExpectedArrivalNoticeResponse;
import yuyu.common.workflowcore.core.webservice.provide.imagekanri.dropimagebyid.WSDropImageByIdRequest;
import yuyu.common.workflowcore.core.webservice.provide.imagekanri.dropimagebyid.WSDropImageByIdResponse;
import yuyu.common.workflowcore.core.webservice.provide.imagekanri.getExpectedArrivalNotice.WSGetExpectedArrivalNoticeRequest;
import yuyu.common.workflowcore.core.webservice.provide.imagekanri.getExpectedArrivalNotice.WSGetExpectedArrivalNoticeResponse;
import yuyu.common.workflowcore.core.webservice.provide.imagekanri.getKouteiSiteiImageProps.WSGetKouteiSiteiImagePropsRequest;
import yuyu.common.workflowcore.core.webservice.provide.imagekanri.getKouteiSiteiImageProps.WSGetKouteiSiteiImagePropsResponse;
import yuyu.common.workflowcore.core.webservice.provide.imagekanri.getimagebyid.WSGetImageByIdRequest;
import yuyu.common.workflowcore.core.webservice.provide.imagekanri.getimagebyid.WSGetImageByIdResponse;
import yuyu.common.workflowcore.core.webservice.provide.imagekanri.getqrcodeimages.WSGetQrCodeImagesRequest;
import yuyu.common.workflowcore.core.webservice.provide.imagekanri.getqrcodeimages.WSGetQrCodeImagesResponse;
import yuyu.common.workflowcore.core.webservice.provide.imagekanri.gettargetimageprops.WSGetTargetImagePropsRequest;
import yuyu.common.workflowcore.core.webservice.provide.imagekanri.gettargetimageprops.WSGetTargetImagePropsResponse;
import yuyu.common.workflowcore.core.webservice.provide.imagekanri.gettorikomisyoruimst.WSGetTorikomiSyoruiMstRequest;
import yuyu.common.workflowcore.core.webservice.provide.imagekanri.gettorikomisyoruimst.WSGetTorikomiSyoruiMstResponse;
import yuyu.common.workflowcore.core.webservice.provide.imagekanri.outputqrcodeimages.WSOutputQrCodeImagesRequest;
import yuyu.common.workflowcore.core.webservice.provide.imagekanri.outputqrcodeimages.WSOutputQrCodeImagesResponse;
import yuyu.common.workflowcore.core.webservice.provide.imagekanri.putArrivalImage.WSPutArrivalImageRequest;
import yuyu.common.workflowcore.core.webservice.provide.imagekanri.putArrivalImage.WSPutArrivalImageResponse;
import yuyu.common.workflowcore.core.webservice.provide.imagekanri.putimage.WSPutImageRequest;
import yuyu.common.workflowcore.core.webservice.provide.imagekanri.putimage.WSPutImageResponse;
import yuyu.common.workflowcore.core.webservice.provide.imagekanri.setImageRelation.WSSetImageRelationRequest;
import yuyu.common.workflowcore.core.webservice.provide.imagekanri.setImageRelation.WSSetImageRelationResponse;
import yuyu.common.workflowcore.core.webservice.provide.kouteikanri.continuelockprocess.WSContinueLockProcessRequest;
import yuyu.common.workflowcore.core.webservice.provide.kouteikanri.continuelockprocess.WSContinueLockProcessResponse;
import yuyu.common.workflowcore.core.webservice.provide.kouteikanri.createprocessrecord.WSCreateProcessRecordRequest;
import yuyu.common.workflowcore.core.webservice.provide.kouteikanri.createprocessrecord.WSCreateProcessRecordResponse;
import yuyu.common.workflowcore.core.webservice.provide.kouteikanri.createtasksummary.WSCreateTaskSummaryRequest;
import yuyu.common.workflowcore.core.webservice.provide.kouteikanri.createtasksummary.WSCreateTaskSummaryResponse;
import yuyu.common.workflowcore.core.webservice.provide.kouteikanri.execforceprocessforward.WSExecForceProcessForwardRequest;
import yuyu.common.workflowcore.core.webservice.provide.kouteikanri.execforceprocessforward.WSExecForceProcessForwardResponse;
import yuyu.common.workflowcore.core.webservice.provide.kouteikanri.execprocesscancel.WSExecProcessCancelRequest;
import yuyu.common.workflowcore.core.webservice.provide.kouteikanri.execprocesscancel.WSExecProcessCancelResponse;
import yuyu.common.workflowcore.core.webservice.provide.kouteikanri.execprocesscreate.WSExecProcessCreateRequest;
import yuyu.common.workflowcore.core.webservice.provide.kouteikanri.execprocesscreate.WSExecProcessCreateResponse;
import yuyu.common.workflowcore.core.webservice.provide.kouteikanri.execprocessforward.WSExecProcessForwardRequest;
import yuyu.common.workflowcore.core.webservice.provide.kouteikanri.execprocessforward.WSExecProcessForwardResponse;
import yuyu.common.workflowcore.core.webservice.provide.kouteikanri.execprocessforwardforbatch.WSExecProcessForwardForBatchRequest;
import yuyu.common.workflowcore.core.webservice.provide.kouteikanri.execprocessforwardforbatch.WSExecProcessForwardForBatchResponse;
import yuyu.common.workflowcore.core.webservice.provide.kouteikanri.execprocessupdate.WSExecProcessUpdateRequest;
import yuyu.common.workflowcore.core.webservice.provide.kouteikanri.execprocessupdate.WSExecProcessUpdateResponse;
import yuyu.common.workflowcore.core.webservice.provide.kouteikanri.execprocessupdateforbatch.WSExecProcessUpdateForBatchRequest;
import yuyu.common.workflowcore.core.webservice.provide.kouteikanri.execprocessupdateforbatch.WSExecProcessUpdateForBatchResponse;
import yuyu.common.workflowcore.core.webservice.provide.kouteikanri.exectaskcancel.WSExecTaskCancelRequest;
import yuyu.common.workflowcore.core.webservice.provide.kouteikanri.exectaskcancel.WSExecTaskCancelResponse;
import yuyu.common.workflowcore.core.webservice.provide.kouteikanri.exectaskstart.WSExecTaskStartRequest;
import yuyu.common.workflowcore.core.webservice.provide.kouteikanri.exectaskstart.WSExecTaskStartResponse;
import yuyu.common.workflowcore.core.webservice.provide.kouteikanri.forceunlockprocess.WSForceUnlockProcessRequest;
import yuyu.common.workflowcore.core.webservice.provide.kouteikanri.forceunlockprocess.WSForceUnlockProcessResponse;
import yuyu.common.workflowcore.core.webservice.provide.kouteikanri.getTaskKensuu.WSGetTaskKensuuRequest;
import yuyu.common.workflowcore.core.webservice.provide.kouteikanri.getTaskKensuu.WSGetTaskKensuuResponse;
import yuyu.common.workflowcore.core.webservice.provide.kouteikanri.getexecutabletasks.WSGetExecutableTasksRequest;
import yuyu.common.workflowcore.core.webservice.provide.kouteikanri.getexecutabletasks.WSGetExecutableTasksResponse;
import yuyu.common.workflowcore.core.webservice.provide.kouteikanri.getexecutabletasksbyprocess.WSGetExecutableTasksByProcessRequest;
import yuyu.common.workflowcore.core.webservice.provide.kouteikanri.getexecutabletasksbyprocess.WSGetExecutableTasksByProcessResponse;
import yuyu.common.workflowcore.core.webservice.provide.kouteikanri.getkouteirirekiandsummarybyuser.WSGetKouteiRirekiAndSummaryByUserRequest;
import yuyu.common.workflowcore.core.webservice.provide.kouteikanri.getkouteirirekiandsummarybyuser.WSGetKouteiRirekiAndSummaryByUserResponse;
import yuyu.common.workflowcore.core.webservice.provide.kouteikanri.getkouteirirekisummary.WSGetKouteiRirekiSummaryRequest;
import yuyu.common.workflowcore.core.webservice.provide.kouteikanri.getkouteirirekisummary.WSGetKouteiRirekiSummaryResponse;
import yuyu.common.workflowcore.core.webservice.provide.kouteikanri.getkouteirirekisyousai.WSGetKouteiRirekiSyousaiRequest;
import yuyu.common.workflowcore.core.webservice.provide.kouteikanri.getkouteirirekisyousai.WSGetKouteiRirekiSyousaiResponse;
import yuyu.common.workflowcore.core.webservice.provide.kouteikanri.getlockinfo.WSGetLockInfoRequest;
import yuyu.common.workflowcore.core.webservice.provide.kouteikanri.getlockinfo.WSGetLockInfoResponse;
import yuyu.common.workflowcore.core.webservice.provide.kouteikanri.getprocessattribute.WSGetProcessAttributeRequest;
import yuyu.common.workflowcore.core.webservice.provide.kouteikanri.getprocessattribute.WSGetProcessAttributeResponse;
import yuyu.common.workflowcore.core.webservice.provide.kouteikanri.getprocessinfo.WSGetProcessInfoRequest;
import yuyu.common.workflowcore.core.webservice.provide.kouteikanri.getprocessinfo.WSGetProcessInfoResponse;
import yuyu.common.workflowcore.core.webservice.provide.kouteikanri.getsometask.WSGetSomeTaskRequest;
import yuyu.common.workflowcore.core.webservice.provide.kouteikanri.getsometask.WSGetSomeTaskResponse;
import yuyu.common.workflowcore.core.webservice.provide.kouteikanri.gettaskdefs.WSGetTaskDefsRequest;
import yuyu.common.workflowcore.core.webservice.provide.kouteikanri.gettaskdefs.WSGetTaskDefsResponse;
import yuyu.common.workflowcore.core.webservice.provide.kouteikanri.gettaskkensuubyactor.WSGetTaskKensuuByActorRequest;
import yuyu.common.workflowcore.core.webservice.provide.kouteikanri.gettaskkensuubyactor.WSGetTaskKensuuByActorResponse;
import yuyu.common.workflowcore.core.webservice.provide.kouteikanri.gettaskprocesses.WSGetTaskProcessesRequest;
import yuyu.common.workflowcore.core.webservice.provide.kouteikanri.gettaskprocesses.WSGetTaskProcessesResponse;
import yuyu.common.workflowcore.core.webservice.provide.kouteikanri.gettasks.WSGetTasksRequest;
import yuyu.common.workflowcore.core.webservice.provide.kouteikanri.gettasks.WSGetTasksResponse;
import yuyu.common.workflowcore.core.webservice.provide.kouteikanri.gettasksummary.WSGetTaskSummaryRequest;
import yuyu.common.workflowcore.core.webservice.provide.kouteikanri.gettasksummary.WSGetTaskSummaryResponse;
import yuyu.common.workflowcore.core.webservice.provide.kouteikanri.gettasksummarybyactor.WSGetTaskSummaryByActorRequest;
import yuyu.common.workflowcore.core.webservice.provide.kouteikanri.gettasksummarybyactor.WSGetTaskSummaryByActorResponse;
import yuyu.common.workflowcore.core.webservice.provide.kouteikanri.gettransitions.WSGetTransitionsRequest;
import yuyu.common.workflowcore.core.webservice.provide.kouteikanri.gettransitions.WSGetTransitionsResponse;
import yuyu.common.workflowcore.core.webservice.provide.kouteikanri.ikkatuprocesscreate.WSIkkatuProcessCreateRequest;
import yuyu.common.workflowcore.core.webservice.provide.kouteikanri.ikkatuprocesscreate.WSIkkatuProcessCreateResponse;
import yuyu.common.workflowcore.core.webservice.provide.kouteikanri.lockprocess.WSLockProcessRequest;
import yuyu.common.workflowcore.core.webservice.provide.kouteikanri.lockprocess.WSLockProcessResponse;
import yuyu.common.workflowcore.core.webservice.provide.kouteikanri.setprocessattribute.WSSetProcessAttributeRequest;
import yuyu.common.workflowcore.core.webservice.provide.kouteikanri.setprocessattribute.WSSetProcessAttributeResponse;
import yuyu.common.workflowcore.core.webservice.provide.kouteikanri.unlockprocess.WSUnlockProcessRequest;
import yuyu.common.workflowcore.core.webservice.provide.kouteikanri.unlockprocess.WSUnlockProcessResponse;

/**
 * イメージワークフローWebサービスの共通クライアントインターフェースです。</ br>
 * インジェクトして使用して下さい</ br>
 */
public interface IwfCommonClient {

    public WSExecProcessCreateResponse execProcessCreate(WSExecProcessCreateRequest request);

    public WSIkkatuProcessCreateResponse execIkkatuProcessCreate(WSIkkatuProcessCreateRequest request);

    public WSExecProcessForwardResponse execProcessForward(WSExecProcessForwardRequest request);

    public WSExecProcessForwardForBatchResponse execProcessForwardForBatch(WSExecProcessForwardForBatchRequest request);

    public WSExecForceProcessForwardResponse execForceProcessForward(WSExecForceProcessForwardRequest request);

    public WSExecProcessCancelResponse execProcessCancel(WSExecProcessCancelRequest request);

    public WSCreateProcessRecordResponse execCcreateProcessRecord(WSCreateProcessRecordRequest request);

    public WSExecProcessUpdateResponse execProcessUpdate(WSExecProcessUpdateRequest request);

    public WSExecProcessUpdateForBatchResponse execProcessUpdateForBatch(WSExecProcessUpdateForBatchRequest request);

    public WSGetKouteiRirekiSyousaiResponse execGetProcessRecord(WSGetKouteiRirekiSyousaiRequest request);

    public WSGetKouteiRirekiAndSummaryByUserResponse execGetProcessRecordAndSummaryByUser(WSGetKouteiRirekiAndSummaryByUserRequest request);

    public WSGetProcessAttributeResponse execGetProcessAttribute(WSGetProcessAttributeRequest request);

    public WSSetProcessAttributeResponse execSetProcessAttribute(WSSetProcessAttributeRequest request);

    public WSGetProcessInfoResponse execGetProcessInfo(WSGetProcessInfoRequest request);

    public WSGetSomeTaskResponse execGetSomeTask(WSGetSomeTaskRequest request);

    public WSGetTaskProcessesResponse execGetTaskProcesses(WSGetTaskProcessesRequest request);

    public WSGetKouteiRirekiSummaryResponse execGetProcessSummary(WSGetKouteiRirekiSummaryRequest request);

    public WSLockProcessResponse execLockProcess(WSLockProcessRequest request);

    public WSUnlockProcessResponse execUnlockProcess(WSUnlockProcessRequest request);

    public WSForceUnlockProcessResponse execForceUnlockProcess(WSForceUnlockProcessRequest request);

    public WSContinueLockProcessResponse execContinueLockProcess(WSContinueLockProcessRequest request);

    public WSGetLockInfoResponse execGetLockInfo(WSGetLockInfoRequest request);

    public WSExecTaskStartResponse execStartTask(WSExecTaskStartRequest request);

    public WSExecTaskCancelResponse execUnassignTask(WSExecTaskCancelRequest request);

    public WSGetExecutableTasksResponse execGetExecutableTasks(WSGetExecutableTasksRequest request);

    public WSGetExecutableTasksByProcessResponse execGetExecutableTasksByProcess(WSGetExecutableTasksByProcessRequest request);

    public WSGetTasksResponse execGetTasks(WSGetTasksRequest request);

    public WSGetTaskDefsResponse execGetTaskDefs(WSGetTaskDefsRequest request);

    public WSGetTransitionsResponse execGetTransitions(WSGetTransitionsRequest request);

    public WSGetImageByIdResponse execGetImage(WSGetImageByIdRequest request);

    public WSGetTargetImagePropsResponse execGetImageProps(WSGetTargetImagePropsRequest request);

    public WSGetKouteiSiteiImagePropsResponse execGetKouteiSiteiImageProps(WSGetKouteiSiteiImagePropsRequest request);

    public WSPutImageResponse execPutImage(WSPutImageRequest request);

    public WSDropImageByIdResponse execDropImage(WSDropImageByIdRequest request);

    public WSGetQrCodeImagesResponse execGetQrCodeImages(WSGetQrCodeImagesRequest request);

    public WSOutputQrCodeImagesResponse execOutputQrCodeImages(WSOutputQrCodeImagesRequest request);

    public WSGetTorikomiSyoruiMstResponse execGetTorikomiSyoruiMst(WSGetTorikomiSyoruiMstRequest request);

    public WSUpdAuthorityResponse execUpdAuthority(WSUpdAuthorityRequest request);

    public WSGetAuthInfoResponse execGetAuthInfo(WSGetAuthInfoRequest request);

    public WSCreateTaskAuthorityResponse execCreateTaskAuthority(WSCreateTaskAuthorityRequest request);

    public WSDelTaskAuthorityResponse execDelTaskAuthority(WSDelTaskAuthorityRequest request);

    public WSGetTaskAuthInfoResponse execGetTaskAuthInfo(WSGetTaskAuthInfoRequest request);

    public WSCreateTaskSummaryResponse execCreateTaskSummary(WSCreateTaskSummaryRequest request);

    public WSGetTaskSummaryResponse execGetTaskSummary(WSGetTaskSummaryRequest request);

    public WSGetTaskKensuuResponse execGetTaskKensuu(WSGetTaskKensuuRequest request);

    public WSGetTaskKensuuByActorResponse execGetTaskKensuuByActor(WSGetTaskKensuuByActorRequest request);

    public WSGetTaskSummaryByActorResponse execGetTaskSummaryByActor(WSGetTaskSummaryByActorRequest request);

    public WSCreateExpectedArrivalNoticeResponse execCreateExpectedArrivalNotice(WSCreateExpectedArrivalNoticeRequest request);

    public WSGetExpectedArrivalNoticeResponse execGetExpectedArrivalNotice(WSGetExpectedArrivalNoticeRequest request);

    public WSPutArrivalImageResponse execPutArrivalImage(WSPutArrivalImageRequest request);

    public WSGetImageAuthorityResponse execGetImageAuthority(WSGetImageAuthorityRequest request);

    public WSUpdImageAuthorityResponse execUpdImageAuthority(WSUpdImageAuthorityRequest request);

    public WSDelImageAuthorityResponse execDelImageAuthority(WSDelImageAuthorityRequest request);

    public WSSetImageRelationResponse execSetImageRelation(WSSetImageRelationRequest request);

    public WSDeleteProcessAndJBPMRecordResponse execDeleteProcessAndJBPMRecord(WSDeleteProcessAndJBPMRecordRequest request);
}