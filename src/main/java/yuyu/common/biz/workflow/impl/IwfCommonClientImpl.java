package yuyu.common.biz.workflow.impl;

import javax.inject.Inject;
import javax.ws.rs.Path;

import jp.co.slcs.swak.uniquekey.UniqueKeyGenerator;
import yuyu.common.biz.workflow.IwfCommonClient;
import yuyu.common.workflowcore.core.webservice.provide.accountkanri.createtaskauthority.WSCreateTaskAuthority;
import yuyu.common.workflowcore.core.webservice.provide.accountkanri.createtaskauthority.WSCreateTaskAuthorityRequest;
import yuyu.common.workflowcore.core.webservice.provide.accountkanri.createtaskauthority.WSCreateTaskAuthorityResponse;
import yuyu.common.workflowcore.core.webservice.provide.accountkanri.delauthority.WSDelAuthority;
import yuyu.common.workflowcore.core.webservice.provide.accountkanri.delimageauthority.WSDelImageAuthority;
import yuyu.common.workflowcore.core.webservice.provide.accountkanri.delimageauthority.WSDelImageAuthorityRequest;
import yuyu.common.workflowcore.core.webservice.provide.accountkanri.delimageauthority.WSDelImageAuthorityResponse;
import yuyu.common.workflowcore.core.webservice.provide.accountkanri.deltaskauthority.WSDelTaskAuthority;
import yuyu.common.workflowcore.core.webservice.provide.accountkanri.deltaskauthority.WSDelTaskAuthorityRequest;
import yuyu.common.workflowcore.core.webservice.provide.accountkanri.deltaskauthority.WSDelTaskAuthorityResponse;
import yuyu.common.workflowcore.core.webservice.provide.accountkanri.getauthinfo.WSGetAuthInfo;
import yuyu.common.workflowcore.core.webservice.provide.accountkanri.getauthinfo.WSGetAuthInfoRequest;
import yuyu.common.workflowcore.core.webservice.provide.accountkanri.getauthinfo.WSGetAuthInfoResponse;
import yuyu.common.workflowcore.core.webservice.provide.accountkanri.getimageauthority.WSGetImageAuthority;
import yuyu.common.workflowcore.core.webservice.provide.accountkanri.getimageauthority.WSGetImageAuthorityRequest;
import yuyu.common.workflowcore.core.webservice.provide.accountkanri.getimageauthority.WSGetImageAuthorityResponse;
import yuyu.common.workflowcore.core.webservice.provide.accountkanri.gettaskauthinfo.WSGetTaskAuthInfo;
import yuyu.common.workflowcore.core.webservice.provide.accountkanri.gettaskauthinfo.WSGetTaskAuthInfoRequest;
import yuyu.common.workflowcore.core.webservice.provide.accountkanri.gettaskauthinfo.WSGetTaskAuthInfoResponse;
import yuyu.common.workflowcore.core.webservice.provide.accountkanri.updauthority.WSUpdAuthority;
import yuyu.common.workflowcore.core.webservice.provide.accountkanri.updauthority.WSUpdAuthorityRequest;
import yuyu.common.workflowcore.core.webservice.provide.accountkanri.updauthority.WSUpdAuthorityResponse;
import yuyu.common.workflowcore.core.webservice.provide.accountkanri.updimageauthority.WSUpdImageAuthority;
import yuyu.common.workflowcore.core.webservice.provide.accountkanri.updimageauthority.WSUpdImageAuthorityRequest;
import yuyu.common.workflowcore.core.webservice.provide.accountkanri.updimageauthority.WSUpdImageAuthorityResponse;
import yuyu.common.workflowcore.core.webservice.provide.datakanri.deleteprocessandjbpmrecord.WSDeleteProcessAndJBPMRecord;
import yuyu.common.workflowcore.core.webservice.provide.datakanri.deleteprocessandjbpmrecord.WSDeleteProcessAndJBPMRecordRequest;
import yuyu.common.workflowcore.core.webservice.provide.datakanri.deleteprocessandjbpmrecord.WSDeleteProcessAndJBPMRecordResponse;
import yuyu.common.workflowcore.core.webservice.provide.imagekanri.createExpectedArrivalNotice.WSCreateExpectedArrivalNotice;
import yuyu.common.workflowcore.core.webservice.provide.imagekanri.createExpectedArrivalNotice.WSCreateExpectedArrivalNoticeRequest;
import yuyu.common.workflowcore.core.webservice.provide.imagekanri.createExpectedArrivalNotice.WSCreateExpectedArrivalNoticeResponse;
import yuyu.common.workflowcore.core.webservice.provide.imagekanri.dropimagebyid.WSDropImageById;
import yuyu.common.workflowcore.core.webservice.provide.imagekanri.dropimagebyid.WSDropImageByIdRequest;
import yuyu.common.workflowcore.core.webservice.provide.imagekanri.dropimagebyid.WSDropImageByIdResponse;
import yuyu.common.workflowcore.core.webservice.provide.imagekanri.getExpectedArrivalNotice.WSGetExpectedArrivalNotice;
import yuyu.common.workflowcore.core.webservice.provide.imagekanri.getExpectedArrivalNotice.WSGetExpectedArrivalNoticeRequest;
import yuyu.common.workflowcore.core.webservice.provide.imagekanri.getExpectedArrivalNotice.WSGetExpectedArrivalNoticeResponse;
import yuyu.common.workflowcore.core.webservice.provide.imagekanri.getKouteiSiteiImageProps.WSGetKouteiSiteiImagePropsRequest;
import yuyu.common.workflowcore.core.webservice.provide.imagekanri.getKouteiSiteiImageProps.WSGetKouteiSiteiImagePropsResponse;
import yuyu.common.workflowcore.core.webservice.provide.imagekanri.getKouteiSiteiImageProps.WSGetkouteiSiteiImageProps;
import yuyu.common.workflowcore.core.webservice.provide.imagekanri.getimagebyid.WSGetImageById;
import yuyu.common.workflowcore.core.webservice.provide.imagekanri.getimagebyid.WSGetImageByIdRequest;
import yuyu.common.workflowcore.core.webservice.provide.imagekanri.getimagebyid.WSGetImageByIdResponse;
import yuyu.common.workflowcore.core.webservice.provide.imagekanri.getimagepropsbyid.WSGetImagePropsById;
import yuyu.common.workflowcore.core.webservice.provide.imagekanri.getqrcodeimages.WSGetQrCodeImages;
import yuyu.common.workflowcore.core.webservice.provide.imagekanri.getqrcodeimages.WSGetQrCodeImagesRequest;
import yuyu.common.workflowcore.core.webservice.provide.imagekanri.getqrcodeimages.WSGetQrCodeImagesResponse;
import yuyu.common.workflowcore.core.webservice.provide.imagekanri.gettargetimageprops.WSGetTargetImageProps;
import yuyu.common.workflowcore.core.webservice.provide.imagekanri.gettargetimageprops.WSGetTargetImagePropsRequest;
import yuyu.common.workflowcore.core.webservice.provide.imagekanri.gettargetimageprops.WSGetTargetImagePropsResponse;
import yuyu.common.workflowcore.core.webservice.provide.imagekanri.gettargetimages.WSGetTargetImages;
import yuyu.common.workflowcore.core.webservice.provide.imagekanri.gettorikomisyoruimst.WSGetTorikomiSyoruiMst;
import yuyu.common.workflowcore.core.webservice.provide.imagekanri.gettorikomisyoruimst.WSGetTorikomiSyoruiMstRequest;
import yuyu.common.workflowcore.core.webservice.provide.imagekanri.gettorikomisyoruimst.WSGetTorikomiSyoruiMstResponse;
import yuyu.common.workflowcore.core.webservice.provide.imagekanri.outputqrcodeimages.WSOutputQrCodeImages;
import yuyu.common.workflowcore.core.webservice.provide.imagekanri.outputqrcodeimages.WSOutputQrCodeImagesRequest;
import yuyu.common.workflowcore.core.webservice.provide.imagekanri.outputqrcodeimages.WSOutputQrCodeImagesResponse;
import yuyu.common.workflowcore.core.webservice.provide.imagekanri.putArrivalImage.WSPutArrivalImage;
import yuyu.common.workflowcore.core.webservice.provide.imagekanri.putArrivalImage.WSPutArrivalImageRequest;
import yuyu.common.workflowcore.core.webservice.provide.imagekanri.putArrivalImage.WSPutArrivalImageResponse;
import yuyu.common.workflowcore.core.webservice.provide.imagekanri.putimage.WSPutImage;
import yuyu.common.workflowcore.core.webservice.provide.imagekanri.putimage.WSPutImageRequest;
import yuyu.common.workflowcore.core.webservice.provide.imagekanri.putimage.WSPutImageResponse;
import yuyu.common.workflowcore.core.webservice.provide.imagekanri.setImageRelation.WSSetImageRelation;
import yuyu.common.workflowcore.core.webservice.provide.imagekanri.setImageRelation.WSSetImageRelationRequest;
import yuyu.common.workflowcore.core.webservice.provide.imagekanri.setImageRelation.WSSetImageRelationResponse;
import yuyu.common.workflowcore.core.webservice.provide.kouteikanri.continuelockprocess.WSContinueLockProcess;
import yuyu.common.workflowcore.core.webservice.provide.kouteikanri.continuelockprocess.WSContinueLockProcessRequest;
import yuyu.common.workflowcore.core.webservice.provide.kouteikanri.continuelockprocess.WSContinueLockProcessResponse;
import yuyu.common.workflowcore.core.webservice.provide.kouteikanri.createprocessrecord.WSCreateProcessRecord;
import yuyu.common.workflowcore.core.webservice.provide.kouteikanri.createprocessrecord.WSCreateProcessRecordRequest;
import yuyu.common.workflowcore.core.webservice.provide.kouteikanri.createprocessrecord.WSCreateProcessRecordResponse;
import yuyu.common.workflowcore.core.webservice.provide.kouteikanri.createtasksummary.WSCreateTaskSummary;
import yuyu.common.workflowcore.core.webservice.provide.kouteikanri.createtasksummary.WSCreateTaskSummaryRequest;
import yuyu.common.workflowcore.core.webservice.provide.kouteikanri.createtasksummary.WSCreateTaskSummaryResponse;
import yuyu.common.workflowcore.core.webservice.provide.kouteikanri.execforceprocessforward.WSExecForceProcessForward;
import yuyu.common.workflowcore.core.webservice.provide.kouteikanri.execforceprocessforward.WSExecForceProcessForwardRequest;
import yuyu.common.workflowcore.core.webservice.provide.kouteikanri.execforceprocessforward.WSExecForceProcessForwardResponse;
import yuyu.common.workflowcore.core.webservice.provide.kouteikanri.execprocesscancel.WSExecProcessCancel;
import yuyu.common.workflowcore.core.webservice.provide.kouteikanri.execprocesscancel.WSExecProcessCancelRequest;
import yuyu.common.workflowcore.core.webservice.provide.kouteikanri.execprocesscancel.WSExecProcessCancelResponse;
import yuyu.common.workflowcore.core.webservice.provide.kouteikanri.execprocesscreate.WSExecProcessCreate;
import yuyu.common.workflowcore.core.webservice.provide.kouteikanri.execprocesscreate.WSExecProcessCreateRequest;
import yuyu.common.workflowcore.core.webservice.provide.kouteikanri.execprocesscreate.WSExecProcessCreateResponse;
import yuyu.common.workflowcore.core.webservice.provide.kouteikanri.execprocessforward.WSExecProcessForward;
import yuyu.common.workflowcore.core.webservice.provide.kouteikanri.execprocessforward.WSExecProcessForwardRequest;
import yuyu.common.workflowcore.core.webservice.provide.kouteikanri.execprocessforward.WSExecProcessForwardResponse;
import yuyu.common.workflowcore.core.webservice.provide.kouteikanri.execprocessforwardforbatch.WSExecProcessForwardForBatch;
import yuyu.common.workflowcore.core.webservice.provide.kouteikanri.execprocessforwardforbatch.WSExecProcessForwardForBatchRequest;
import yuyu.common.workflowcore.core.webservice.provide.kouteikanri.execprocessforwardforbatch.WSExecProcessForwardForBatchResponse;
import yuyu.common.workflowcore.core.webservice.provide.kouteikanri.execprocessupdate.WSExecProcessUpdate;
import yuyu.common.workflowcore.core.webservice.provide.kouteikanri.execprocessupdate.WSExecProcessUpdateRequest;
import yuyu.common.workflowcore.core.webservice.provide.kouteikanri.execprocessupdate.WSExecProcessUpdateResponse;
import yuyu.common.workflowcore.core.webservice.provide.kouteikanri.execprocessupdateforbatch.WSExecProcessUpdateForBatch;
import yuyu.common.workflowcore.core.webservice.provide.kouteikanri.execprocessupdateforbatch.WSExecProcessUpdateForBatchRequest;
import yuyu.common.workflowcore.core.webservice.provide.kouteikanri.execprocessupdateforbatch.WSExecProcessUpdateForBatchResponse;
import yuyu.common.workflowcore.core.webservice.provide.kouteikanri.exectaskcancel.WSExecTaskCancel;
import yuyu.common.workflowcore.core.webservice.provide.kouteikanri.exectaskcancel.WSExecTaskCancelRequest;
import yuyu.common.workflowcore.core.webservice.provide.kouteikanri.exectaskcancel.WSExecTaskCancelResponse;
import yuyu.common.workflowcore.core.webservice.provide.kouteikanri.exectaskstart.WSExecTaskStart;
import yuyu.common.workflowcore.core.webservice.provide.kouteikanri.exectaskstart.WSExecTaskStartRequest;
import yuyu.common.workflowcore.core.webservice.provide.kouteikanri.exectaskstart.WSExecTaskStartResponse;
import yuyu.common.workflowcore.core.webservice.provide.kouteikanri.forceunlockprocess.WSForceUnlockProcess;
import yuyu.common.workflowcore.core.webservice.provide.kouteikanri.forceunlockprocess.WSForceUnlockProcessRequest;
import yuyu.common.workflowcore.core.webservice.provide.kouteikanri.forceunlockprocess.WSForceUnlockProcessResponse;
import yuyu.common.workflowcore.core.webservice.provide.kouteikanri.getTaskKensuu.WSGetTaskKensuu;
import yuyu.common.workflowcore.core.webservice.provide.kouteikanri.getTaskKensuu.WSGetTaskKensuuRequest;
import yuyu.common.workflowcore.core.webservice.provide.kouteikanri.getTaskKensuu.WSGetTaskKensuuResponse;
import yuyu.common.workflowcore.core.webservice.provide.kouteikanri.getexecutabletasks.WSGetExecutableTasks;
import yuyu.common.workflowcore.core.webservice.provide.kouteikanri.getexecutabletasks.WSGetExecutableTasksRequest;
import yuyu.common.workflowcore.core.webservice.provide.kouteikanri.getexecutabletasks.WSGetExecutableTasksResponse;
import yuyu.common.workflowcore.core.webservice.provide.kouteikanri.getexecutabletasksbyprocess.WSGetExecutableTasksByProcess;
import yuyu.common.workflowcore.core.webservice.provide.kouteikanri.getexecutabletasksbyprocess.WSGetExecutableTasksByProcessRequest;
import yuyu.common.workflowcore.core.webservice.provide.kouteikanri.getexecutabletasksbyprocess.WSGetExecutableTasksByProcessResponse;
import yuyu.common.workflowcore.core.webservice.provide.kouteikanri.getkouteirirekiandsummarybyuser.WSGetKouteiRirekiAndSummaryByUser;
import yuyu.common.workflowcore.core.webservice.provide.kouteikanri.getkouteirirekiandsummarybyuser.WSGetKouteiRirekiAndSummaryByUserRequest;
import yuyu.common.workflowcore.core.webservice.provide.kouteikanri.getkouteirirekiandsummarybyuser.WSGetKouteiRirekiAndSummaryByUserResponse;
import yuyu.common.workflowcore.core.webservice.provide.kouteikanri.getkouteirirekisummary.WSGetKouteiRirekiSummary;
import yuyu.common.workflowcore.core.webservice.provide.kouteikanri.getkouteirirekisummary.WSGetKouteiRirekiSummaryRequest;
import yuyu.common.workflowcore.core.webservice.provide.kouteikanri.getkouteirirekisummary.WSGetKouteiRirekiSummaryResponse;
import yuyu.common.workflowcore.core.webservice.provide.kouteikanri.getkouteirirekisyousai.WSGetKouteiRirekiSyousai;
import yuyu.common.workflowcore.core.webservice.provide.kouteikanri.getkouteirirekisyousai.WSGetKouteiRirekiSyousaiRequest;
import yuyu.common.workflowcore.core.webservice.provide.kouteikanri.getkouteirirekisyousai.WSGetKouteiRirekiSyousaiResponse;
import yuyu.common.workflowcore.core.webservice.provide.kouteikanri.getlockinfo.WSGetLockInfo;
import yuyu.common.workflowcore.core.webservice.provide.kouteikanri.getlockinfo.WSGetLockInfoRequest;
import yuyu.common.workflowcore.core.webservice.provide.kouteikanri.getlockinfo.WSGetLockInfoResponse;
import yuyu.common.workflowcore.core.webservice.provide.kouteikanri.getprocessattribute.WSGetProcessAttribute;
import yuyu.common.workflowcore.core.webservice.provide.kouteikanri.getprocessattribute.WSGetProcessAttributeRequest;
import yuyu.common.workflowcore.core.webservice.provide.kouteikanri.getprocessattribute.WSGetProcessAttributeResponse;
import yuyu.common.workflowcore.core.webservice.provide.kouteikanri.getprocessinfo.WSGetProcessInfo;
import yuyu.common.workflowcore.core.webservice.provide.kouteikanri.getprocessinfo.WSGetProcessInfoRequest;
import yuyu.common.workflowcore.core.webservice.provide.kouteikanri.getprocessinfo.WSGetProcessInfoResponse;
import yuyu.common.workflowcore.core.webservice.provide.kouteikanri.getsometask.WSGetSomeTask;
import yuyu.common.workflowcore.core.webservice.provide.kouteikanri.getsometask.WSGetSomeTaskRequest;
import yuyu.common.workflowcore.core.webservice.provide.kouteikanri.getsometask.WSGetSomeTaskResponse;
import yuyu.common.workflowcore.core.webservice.provide.kouteikanri.gettaskdefs.WSGetTaskDefs;
import yuyu.common.workflowcore.core.webservice.provide.kouteikanri.gettaskdefs.WSGetTaskDefsRequest;
import yuyu.common.workflowcore.core.webservice.provide.kouteikanri.gettaskdefs.WSGetTaskDefsResponse;
import yuyu.common.workflowcore.core.webservice.provide.kouteikanri.gettaskkensuubyactor.WSGetTaskKensuuByActor;
import yuyu.common.workflowcore.core.webservice.provide.kouteikanri.gettaskkensuubyactor.WSGetTaskKensuuByActorRequest;
import yuyu.common.workflowcore.core.webservice.provide.kouteikanri.gettaskkensuubyactor.WSGetTaskKensuuByActorResponse;
import yuyu.common.workflowcore.core.webservice.provide.kouteikanri.gettaskprocesses.WSGetTaskProcesses;
import yuyu.common.workflowcore.core.webservice.provide.kouteikanri.gettaskprocesses.WSGetTaskProcessesRequest;
import yuyu.common.workflowcore.core.webservice.provide.kouteikanri.gettaskprocesses.WSGetTaskProcessesResponse;
import yuyu.common.workflowcore.core.webservice.provide.kouteikanri.gettasks.WSGetTasks;
import yuyu.common.workflowcore.core.webservice.provide.kouteikanri.gettasks.WSGetTasksRequest;
import yuyu.common.workflowcore.core.webservice.provide.kouteikanri.gettasks.WSGetTasksResponse;
import yuyu.common.workflowcore.core.webservice.provide.kouteikanri.gettasksummary.WSGetTaskSummary;
import yuyu.common.workflowcore.core.webservice.provide.kouteikanri.gettasksummary.WSGetTaskSummaryRequest;
import yuyu.common.workflowcore.core.webservice.provide.kouteikanri.gettasksummary.WSGetTaskSummaryResponse;
import yuyu.common.workflowcore.core.webservice.provide.kouteikanri.gettasksummarybyactor.WSGetTaskSummaryByActor;
import yuyu.common.workflowcore.core.webservice.provide.kouteikanri.gettasksummarybyactor.WSGetTaskSummaryByActorRequest;
import yuyu.common.workflowcore.core.webservice.provide.kouteikanri.gettasksummarybyactor.WSGetTaskSummaryByActorResponse;
import yuyu.common.workflowcore.core.webservice.provide.kouteikanri.gettransitions.WSGetTransitions;
import yuyu.common.workflowcore.core.webservice.provide.kouteikanri.gettransitions.WSGetTransitionsRequest;
import yuyu.common.workflowcore.core.webservice.provide.kouteikanri.gettransitions.WSGetTransitionsResponse;
import yuyu.common.workflowcore.core.webservice.provide.kouteikanri.ikkatuprocesscreate.WSIkkatuProcessCreate;
import yuyu.common.workflowcore.core.webservice.provide.kouteikanri.ikkatuprocesscreate.WSIkkatuProcessCreateRequest;
import yuyu.common.workflowcore.core.webservice.provide.kouteikanri.ikkatuprocesscreate.WSIkkatuProcessCreateResponse;
import yuyu.common.workflowcore.core.webservice.provide.kouteikanri.lockprocess.WSLockProcess;
import yuyu.common.workflowcore.core.webservice.provide.kouteikanri.lockprocess.WSLockProcessRequest;
import yuyu.common.workflowcore.core.webservice.provide.kouteikanri.lockprocess.WSLockProcessResponse;
import yuyu.common.workflowcore.core.webservice.provide.kouteikanri.setprocessattribute.WSSetProcessAttribute;
import yuyu.common.workflowcore.core.webservice.provide.kouteikanri.setprocessattribute.WSSetProcessAttributeRequest;
import yuyu.common.workflowcore.core.webservice.provide.kouteikanri.setprocessattribute.WSSetProcessAttributeResponse;
import yuyu.common.workflowcore.core.webservice.provide.kouteikanri.unlockprocess.WSUnlockProcess;
import yuyu.common.workflowcore.core.webservice.provide.kouteikanri.unlockprocess.WSUnlockProcessRequest;
import yuyu.common.workflowcore.core.webservice.provide.kouteikanri.unlockprocess.WSUnlockProcessResponse;


/**
 * イメージワークフローWebサービスの共通クライアントクラスです。</ br>
 * Injectして使用して下さい</ br>
 * http://{servername}:{portno}/{context}/ws/{path1}/{path2}
 * <pre>
 * このソースは全てツールから吐き出されています。
 * ツール吐き出し後は手で編集しても構いませんが、その場合は更新日と名前を入力する必要があります。
 * ツールで吐き出しなおした場合、その限りではありません。
 */
@Path("")
public class IwfCommonClientImpl implements IwfCommonClient {


    @Inject
    WSDelAuthority delAuthority;

    @Inject
    WSGetImageAuthority getImageAuthority;

    @Inject
    WSUpdImageAuthority updImageAuthority;

    @Inject
    WSDelImageAuthority delImageAuthority;

    @Inject
    WSGetAuthInfo getAuthInfo;

    @Inject
    WSCreateTaskAuthority createTaskAuthority;

    @Inject
    WSDelTaskAuthority delTaskAuthority;

    @Inject
    WSGetTaskAuthInfo getTaskAuthInfo;

    @Inject
    WSUpdAuthority updAuthority;

    @Inject
    WSDropImageById dropImageById;

    @Inject
    WSGetImageById getImageById;

    @Inject
    WSGetImagePropsById getImagePropsById;

    @Inject
    WSGetQrCodeImages getQrCodeImages;

    @Inject
    WSGetTargetImageProps getTargetImageProps;

    @Inject
    WSGetkouteiSiteiImageProps getKouteiSiteiImageProps;

    @Inject
    WSGetTargetImages getTargetImages;

    @Inject
    WSGetTorikomiSyoruiMst getTorikomiSyoruiMst;

    @Inject
    WSOutputQrCodeImages outputQrCodeImages;

    @Inject
    WSPutImage putImage;

    @Inject
    WSCreateExpectedArrivalNotice createExpectedArrivalNotice;

    @Inject
    WSGetExpectedArrivalNotice getExpectedArrivalNotice;

    @Inject
    WSPutArrivalImage putArrivalImage;

    @Inject
    WSSetImageRelation setImageRelation;

    @Inject
    WSCreateProcessRecord createProcessRecord;

    @Inject
    WSExecForceProcessForward execForceProcessForward;

    @Inject
    WSExecProcessCancel execProcessCancel;

    @Inject
    WSExecProcessCreate execProcessCreate;

    @Inject
    WSExecProcessForward execProcessForward;

    @Inject
    WSExecProcessForwardForBatch execProcessForwardForBatch;

    @Inject
    WSExecProcessUpdate execProcessUpdate;

    @Inject
    WSExecProcessUpdateForBatch execProcessUpdateForBatch;

    @Inject
    WSExecTaskCancel execTaskCancel;

    @Inject
    WSExecTaskStart execTaskStart;

    @Inject
    WSForceUnlockProcess forceUnlockProcess;

    @Inject
    WSGetExecutableTasks getExecutableTasks;

    @Inject
    WSGetExecutableTasksByProcess getExecutableTasksByProcess;

    @Inject
    WSGetKouteiRirekiSummary getKouteiRirekiSummary;

    @Inject
    WSGetKouteiRirekiSyousai getKouteiRirekiSyousai;

    @Inject
    WSGetKouteiRirekiAndSummaryByUser getKouteiRirekiAndSummaryByUser;

    @Inject
    WSGetProcessAttribute getProcessAttribute;

    @Inject
    WSGetProcessInfo getProcessInfo;

    @Inject
    WSGetSomeTask getSomeTask;

    @Inject
    WSGetTaskDefs getTaskDefs;

    @Inject
    WSGetTaskProcesses getTaskProcesses;

    @Inject
    WSGetTasks getTasks;

    @Inject
    WSGetTransitions getTransitions;

    @Inject
    WSIkkatuProcessCreate ikkatuProcessCreate;

    @Inject
    WSLockProcess lockProcess;

    @Inject
    WSSetProcessAttribute setProcessAttribute;

    @Inject
    WSUnlockProcess unlockProcess;

    @Inject
    WSContinueLockProcess continueLockProcess;

    @Inject
    WSGetLockInfo getLockInfo;

    @Inject
    WSCreateTaskSummary createTaskSummary;

    @Inject
    WSGetTaskSummary getTaskSummary;

    @Inject
    WSGetTaskKensuu getTaskKensuu;

    @Inject
    WSGetTaskSummaryByActor getTaskSummaryByActor;

    @Inject
    WSGetTaskKensuuByActor getTaskKensuuByActor;

    @Inject
    UniqueKeyGenerator uniqueKey;

    @Inject
    WSDeleteProcessAndJBPMRecord deleteProcessAndJBPMRecord;

    @Override
    public WSExecProcessCreateResponse execProcessCreate(WSExecProcessCreateRequest request) {
        try {
            return execProcessCreate.executeBizMain(request);
        } catch(RuntimeException re){
            throw re;
        } catch(Exception e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public WSIkkatuProcessCreateResponse execIkkatuProcessCreate(WSIkkatuProcessCreateRequest request){
        try {
            return ikkatuProcessCreate.executeBizMain(request);
        } catch(RuntimeException re){
            throw re;
        } catch(Exception e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public WSExecProcessForwardResponse execProcessForward(WSExecProcessForwardRequest request){
        try {
            return execProcessForward.executeBizMain(request);
        } catch(RuntimeException re){
            throw re;
        } catch(Exception e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public WSExecProcessForwardForBatchResponse execProcessForwardForBatch(WSExecProcessForwardForBatchRequest request){
        try {
            return execProcessForwardForBatch.executeBizMain(request);
        } catch(RuntimeException re){
            throw re;
        } catch(Exception e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public WSExecForceProcessForwardResponse execForceProcessForward(WSExecForceProcessForwardRequest request){
        try {
            return execForceProcessForward.executeBizMain(request);
        } catch(RuntimeException re){
            throw re;
        } catch(Exception e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public WSExecProcessCancelResponse execProcessCancel(WSExecProcessCancelRequest request){
        try {
            return execProcessCancel.executeBizMain(request);
        } catch(RuntimeException re){
            throw re;
        } catch(Exception e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public WSCreateProcessRecordResponse execCcreateProcessRecord(WSCreateProcessRecordRequest request){
        try {
            return createProcessRecord.executeBizMain(request);
        } catch(RuntimeException re){
            throw re;
        } catch(Exception e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public WSGetKouteiRirekiSyousaiResponse execGetProcessRecord(WSGetKouteiRirekiSyousaiRequest request){
        try {
            return getKouteiRirekiSyousai.executeBizMain(request);
        } catch(RuntimeException re){
            throw re;
        } catch(Exception e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public WSGetKouteiRirekiAndSummaryByUserResponse execGetProcessRecordAndSummaryByUser(WSGetKouteiRirekiAndSummaryByUserRequest request){
        try {
            return getKouteiRirekiAndSummaryByUser.executeBizMain(request);
        } catch(RuntimeException re){
            throw re;
        } catch(Exception e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public WSGetKouteiRirekiSummaryResponse execGetProcessSummary(WSGetKouteiRirekiSummaryRequest request){
        try {
            return getKouteiRirekiSummary.executeBizMain(request);
        } catch(RuntimeException re){
            throw re;
        } catch(Exception e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public WSLockProcessResponse execLockProcess(WSLockProcessRequest request) {
        try {
            return lockProcess.executeBizMain(request);
        } catch(RuntimeException re){
            throw re;
        } catch(Exception e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public WSUnlockProcessResponse execUnlockProcess(WSUnlockProcessRequest request){
        try {
            return unlockProcess.executeBizMain(request);
        } catch(RuntimeException re){
            throw re;
        } catch(Exception e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public WSForceUnlockProcessResponse execForceUnlockProcess(WSForceUnlockProcessRequest request){
        try {
            return forceUnlockProcess.executeBizMain(request);
        } catch(RuntimeException re){
            throw re;
        } catch(Exception e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public WSContinueLockProcessResponse execContinueLockProcess(WSContinueLockProcessRequest request){
        try {
            return continueLockProcess.executeBizMain(request);
        } catch(RuntimeException re){
            throw re;
        } catch(Exception e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public WSGetLockInfoResponse execGetLockInfo(WSGetLockInfoRequest request){
        try {
            return getLockInfo.executeBizMain(request);
        } catch(RuntimeException re){
            throw re;
        } catch(Exception e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public WSExecTaskStartResponse execStartTask(WSExecTaskStartRequest request){
        try {
            return execTaskStart.executeBizMain(request);
        } catch(RuntimeException re){
            throw re;
        } catch(Exception e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public WSExecTaskCancelResponse execUnassignTask(WSExecTaskCancelRequest request){
        try {
            return execTaskCancel.executeBizMain(request);
        } catch(RuntimeException re){
            throw re;
        } catch(Exception e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public WSGetExecutableTasksResponse execGetExecutableTasks(WSGetExecutableTasksRequest request){
        try {
            return getExecutableTasks.executeBizMain(request);
        } catch(RuntimeException re){
            throw re;
        } catch(Exception e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public WSGetExecutableTasksByProcessResponse execGetExecutableTasksByProcess(WSGetExecutableTasksByProcessRequest request){
        try {
            return getExecutableTasksByProcess.executeBizMain(request);
        } catch(RuntimeException re){
            throw re;
        } catch(Exception e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public WSGetTasksResponse execGetTasks(WSGetTasksRequest request){
        try {
            return getTasks.executeBizMain(request);
        } catch(RuntimeException re){
            throw re;
        } catch(Exception e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public WSGetTaskDefsResponse execGetTaskDefs(WSGetTaskDefsRequest request){
        try {
            return getTaskDefs.executeBizMain(request);
        } catch(RuntimeException re){
            throw re;
        } catch(Exception e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public WSGetImageByIdResponse execGetImage(WSGetImageByIdRequest request){
        try {
            return  getImageById.executeBizMain(request);
        } catch(RuntimeException re){
            throw re;
        } catch(Exception e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public WSGetTargetImagePropsResponse execGetImageProps(WSGetTargetImagePropsRequest request){
        try {
            return getTargetImageProps.executeBizMain(request);
        } catch(RuntimeException re){
            throw re;
        } catch(Exception e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public WSGetKouteiSiteiImagePropsResponse execGetKouteiSiteiImageProps(WSGetKouteiSiteiImagePropsRequest request) {
        try {
            return getKouteiSiteiImageProps.executeBizMain(request);
        } catch(RuntimeException re){
            throw re;
        } catch(Exception e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public WSPutImageResponse execPutImage(WSPutImageRequest request){
        try {
            return  putImage.executeBizMain(request);
        } catch(RuntimeException re){
            throw re;
        } catch(Exception e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public WSDropImageByIdResponse execDropImage(WSDropImageByIdRequest request){
        try {
            return  dropImageById.executeBizMain(request);
        } catch(RuntimeException re){
            throw re;
        } catch(Exception e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public WSGetTorikomiSyoruiMstResponse execGetTorikomiSyoruiMst(WSGetTorikomiSyoruiMstRequest request){
        try {
            return  getTorikomiSyoruiMst.executeBizMain(request);
        } catch(RuntimeException re){
            throw re;
        } catch(Exception e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public WSCreateTaskAuthorityResponse execCreateTaskAuthority(WSCreateTaskAuthorityRequest request){
        try {
            return  createTaskAuthority.executeBizMain(request);
        } catch(RuntimeException re){
            throw re;
        } catch(Exception e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public WSDelTaskAuthorityResponse execDelTaskAuthority(WSDelTaskAuthorityRequest request){
        try {
            return  delTaskAuthority.executeBizMain(request);
        } catch(RuntimeException re){
            throw re;
        } catch(Exception e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public WSExecProcessUpdateResponse execProcessUpdate(WSExecProcessUpdateRequest request) {
        try {
            return execProcessUpdate.executeBizMain(request);
        } catch(RuntimeException re){
            throw re;
        } catch(Exception e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public WSExecProcessUpdateForBatchResponse execProcessUpdateForBatch(WSExecProcessUpdateForBatchRequest request){
        try {
            return execProcessUpdateForBatch.executeBizMain(request);
        } catch(RuntimeException re){
            throw re;
        } catch(Exception e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public WSGetProcessAttributeResponse execGetProcessAttribute(WSGetProcessAttributeRequest request) {
        try {
            return getProcessAttribute.executeBizMain(request);
        } catch(RuntimeException re){
            throw re;
        } catch(Exception e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public WSSetProcessAttributeResponse execSetProcessAttribute(WSSetProcessAttributeRequest request) {
        try {
            return setProcessAttribute.executeBizMain(request);
        } catch(RuntimeException re){
            throw re;
        } catch(Exception e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public WSGetProcessInfoResponse execGetProcessInfo(WSGetProcessInfoRequest request) {
        try {
            return getProcessInfo.executeBizMain(request);
        } catch(RuntimeException re){
            throw re;
        } catch(Exception e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public WSGetSomeTaskResponse execGetSomeTask(WSGetSomeTaskRequest request) {
        try {
            return getSomeTask.executeBizMain(request);
        } catch(RuntimeException re){
            throw re;
        } catch(Exception e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public WSGetTaskProcessesResponse execGetTaskProcesses(WSGetTaskProcessesRequest request) {
        try {
            return getTaskProcesses.executeBizMain(request);
        } catch(RuntimeException re){
            throw re;
        } catch(Exception e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public WSGetTransitionsResponse execGetTransitions(WSGetTransitionsRequest request) {
        try {
            return getTransitions.executeBizMain(request);
        } catch(RuntimeException re){
            throw re;
        } catch(Exception e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public WSGetQrCodeImagesResponse execGetQrCodeImages(WSGetQrCodeImagesRequest request) {
        try {
            return getQrCodeImages.executeBizMain(request);
        } catch(RuntimeException re){
            throw re;
        } catch(Exception e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public WSOutputQrCodeImagesResponse execOutputQrCodeImages(WSOutputQrCodeImagesRequest request) {
        try {
            return outputQrCodeImages.executeBizMain(request);
        } catch(RuntimeException re){
            throw re;
        } catch(Exception e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public WSUpdAuthorityResponse execUpdAuthority(WSUpdAuthorityRequest request) {
        try {
            return updAuthority.executeBizMain(request);
        } catch(RuntimeException re){
            throw re;
        } catch(Exception e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public WSGetAuthInfoResponse execGetAuthInfo(WSGetAuthInfoRequest request) {
        try {
            return getAuthInfo.executeBizMain(request);
        } catch(RuntimeException re){
            throw re;
        } catch(Exception e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public WSGetTaskAuthInfoResponse execGetTaskAuthInfo(WSGetTaskAuthInfoRequest request) {
        try {
            return getTaskAuthInfo.executeBizMain(request);
        } catch(RuntimeException re){
            throw re;
        } catch(Exception e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public WSCreateTaskSummaryResponse execCreateTaskSummary(WSCreateTaskSummaryRequest request) {
        try {
            return createTaskSummary.executeBizMain(request);
        } catch(RuntimeException re){
            throw re;
        } catch(Exception e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public WSGetTaskSummaryResponse execGetTaskSummary(WSGetTaskSummaryRequest request) {
        try {
            return getTaskSummary.executeBizMain(request);
        } catch(RuntimeException re){
            throw re;
        } catch(Exception e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public WSGetTaskKensuuResponse execGetTaskKensuu(WSGetTaskKensuuRequest request) {
        try {
            return getTaskKensuu.executeBizMain(request);
        } catch(RuntimeException re){
            throw re;
        } catch(Exception e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public WSGetTaskSummaryByActorResponse execGetTaskSummaryByActor(WSGetTaskSummaryByActorRequest request) {
        try {
            return getTaskSummaryByActor.executeBizMain(request);
        } catch(RuntimeException re){
            throw re;
        } catch(Exception e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public WSGetTaskKensuuByActorResponse execGetTaskKensuuByActor(WSGetTaskKensuuByActorRequest request) {
        try {
            return getTaskKensuuByActor.executeBizMain(request);
        } catch(RuntimeException re){
            throw re;
        } catch(Exception e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public WSCreateExpectedArrivalNoticeResponse execCreateExpectedArrivalNotice(WSCreateExpectedArrivalNoticeRequest request) {
        try {
            return createExpectedArrivalNotice.executeBizMain(request);
        } catch(RuntimeException re){
            throw re;
        } catch(Exception e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public WSGetExpectedArrivalNoticeResponse execGetExpectedArrivalNotice(WSGetExpectedArrivalNoticeRequest request) {
        try {
            return getExpectedArrivalNotice.executeBizMain(request);
        } catch(RuntimeException re){
            throw re;
        } catch(Exception e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public WSPutArrivalImageResponse execPutArrivalImage(WSPutArrivalImageRequest request) {
        try {
            return putArrivalImage.executeBizMain(request);
        } catch(RuntimeException re){
            throw re;
        } catch(Exception e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public WSSetImageRelationResponse execSetImageRelation(WSSetImageRelationRequest request) {
        try {
            return setImageRelation.executeBizMain(request);
        } catch(RuntimeException re){
            throw re;
        } catch(Exception e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public WSGetImageAuthorityResponse execGetImageAuthority(WSGetImageAuthorityRequest request) {
        try {
            return getImageAuthority.executeBizMain(request);
        } catch(RuntimeException re){
            throw re;
        } catch(Exception e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public WSUpdImageAuthorityResponse execUpdImageAuthority(WSUpdImageAuthorityRequest request) {
        try {
            return updImageAuthority.executeBizMain(request);
        } catch(RuntimeException re){
            throw re;
        } catch(Exception e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public WSDelImageAuthorityResponse execDelImageAuthority(WSDelImageAuthorityRequest request) {
        try {
            return delImageAuthority.executeBizMain(request);
        } catch(RuntimeException re){
            throw re;
        } catch(Exception e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public WSDeleteProcessAndJBPMRecordResponse execDeleteProcessAndJBPMRecord(WSDeleteProcessAndJBPMRecordRequest request) {
        try {
            return deleteProcessAndJBPMRecord.executeBizMain(request);
        } catch(RuntimeException re){
            throw re;
        } catch(Exception e){
            throw new RuntimeException(e);
        }
    }
}

