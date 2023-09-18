package yuyu.common.workflowcore.inject;

import iwf.callback.arriveimage.imageTerminator.WSImageTerminator;
import iwf.callback.arriveimage.imageTerminator.WSImageTerminatorImpl;
import iwf.callback.arriveimage.toutyakuYoteiNotFound.WSToutyakuYoteiNotFound;
import iwf.callback.arriveimage.toutyakuYoteiNotFound.WSToutyakuYoteiNotFoundImpl;
import jp.co.slcs.swak.core.inject.AbstractSWAKModule;
import jp.co.slcs.swak.core.inject.annotation.ThreadScoped;
import jp.co.slcs.workflow.adapter.ScanReceiver;

import org.jbpm.JbpmConfiguration;
import org.jbpm.JbpmContext;

import yuyu.common.workflowcore.api.api.IWorkflowContext;
import yuyu.common.workflowcore.api.config.WorkflowConfig;
import yuyu.common.workflowcore.core.webservice.provide.accountkanri.createtaskauthority.WSCreateTaskAuthority;
import yuyu.common.workflowcore.core.webservice.provide.accountkanri.createtaskauthority.WSCreateTaskAuthorityImpl;
import yuyu.common.workflowcore.core.webservice.provide.accountkanri.delauthority.WSDelAuthority;
import yuyu.common.workflowcore.core.webservice.provide.accountkanri.delauthority.WSDelAuthorityImpl;
import yuyu.common.workflowcore.core.webservice.provide.accountkanri.delimageauthority.WSDelImageAuthority;
import yuyu.common.workflowcore.core.webservice.provide.accountkanri.delimageauthority.WSDelImageAuthorityImpl;
import yuyu.common.workflowcore.core.webservice.provide.accountkanri.deltaskauthority.WSDelTaskAuthority;
import yuyu.common.workflowcore.core.webservice.provide.accountkanri.deltaskauthority.WSDelTaskAuthorityImpl;
import yuyu.common.workflowcore.core.webservice.provide.accountkanri.getauthinfo.WSGetAuthInfo;
import yuyu.common.workflowcore.core.webservice.provide.accountkanri.getauthinfo.WSGetAuthInfoImpl;
import yuyu.common.workflowcore.core.webservice.provide.accountkanri.getimageauthority.WSGetImageAuthority;
import yuyu.common.workflowcore.core.webservice.provide.accountkanri.getimageauthority.WSGetImageAuthorityImpl;
import yuyu.common.workflowcore.core.webservice.provide.accountkanri.gettaskauthinfo.WSGetTaskAuthInfo;
import yuyu.common.workflowcore.core.webservice.provide.accountkanri.gettaskauthinfo.WSGetTaskAuthInfoImpl;
import yuyu.common.workflowcore.core.webservice.provide.accountkanri.updauthority.WSUpdAuthority;
import yuyu.common.workflowcore.core.webservice.provide.accountkanri.updauthority.WSUpdAuthorityImpl;
import yuyu.common.workflowcore.core.webservice.provide.accountkanri.updimageauthority.WSUpdImageAuthority;
import yuyu.common.workflowcore.core.webservice.provide.accountkanri.updimageauthority.WSUpdImageAuthorityImpl;
import yuyu.common.workflowcore.core.webservice.provide.common.exdao.ExecutableTaskDao;
import yuyu.common.workflowcore.core.webservice.provide.common.exdao.impl.ExecutableTaskDaoImpl;
import yuyu.common.workflowcore.core.webservice.provide.datakanri.deleteprocessandjbpmrecord.WSDeleteProcessAndJBPMRecord;
import yuyu.common.workflowcore.core.webservice.provide.datakanri.deleteprocessandjbpmrecord.WSDeleteProcessAndJBPMRecordImpl;
import yuyu.common.workflowcore.core.webservice.provide.imagekanri.createExpectedArrivalNotice.WSCreateExpectedArrivalNotice;
import yuyu.common.workflowcore.core.webservice.provide.imagekanri.createExpectedArrivalNotice.WSCreateExpectedArrivalNoticeImpl;
import yuyu.common.workflowcore.core.webservice.provide.imagekanri.dropimagebyid.WSDropImageById;
import yuyu.common.workflowcore.core.webservice.provide.imagekanri.dropimagebyid.WSDropImageByIdImpl;
import yuyu.common.workflowcore.core.webservice.provide.imagekanri.getExpectedArrivalNotice.WSGetExpectedArrivalNotice;
import yuyu.common.workflowcore.core.webservice.provide.imagekanri.getExpectedArrivalNotice.WSGetExpectedArrivalNoticeImpl;
import yuyu.common.workflowcore.core.webservice.provide.imagekanri.getKouteiSiteiImageProps.WSGetKouteiSiteiImagePropsImpl;
import yuyu.common.workflowcore.core.webservice.provide.imagekanri.getKouteiSiteiImageProps.WSGetkouteiSiteiImageProps;
import yuyu.common.workflowcore.core.webservice.provide.imagekanri.getimagebyid.WSGetImageById;
import yuyu.common.workflowcore.core.webservice.provide.imagekanri.getimagebyid.WSGetImageByIdImpl;
import yuyu.common.workflowcore.core.webservice.provide.imagekanri.getimagepropsbyid.WSGetImagePropsById;
import yuyu.common.workflowcore.core.webservice.provide.imagekanri.getimagepropsbyid.WSGetImagePropsByIdImpl;
import yuyu.common.workflowcore.core.webservice.provide.imagekanri.getqrcodeimages.WSGetQrCodeImages;
import yuyu.common.workflowcore.core.webservice.provide.imagekanri.getqrcodeimages.WSGetQrCodeImagesImpl;
import yuyu.common.workflowcore.core.webservice.provide.imagekanri.gettargetimageprops.WSGetTargetImageProps;
import yuyu.common.workflowcore.core.webservice.provide.imagekanri.gettargetimageprops.WSGetTargetImagePropsImpl;
import yuyu.common.workflowcore.core.webservice.provide.imagekanri.gettargetimages.WSGetTargetImages;
import yuyu.common.workflowcore.core.webservice.provide.imagekanri.gettargetimages.WSGetTargetImagesImpl;
import yuyu.common.workflowcore.core.webservice.provide.imagekanri.gettorikomisyoruimst.WSGetTorikomiSyoruiMst;
import yuyu.common.workflowcore.core.webservice.provide.imagekanri.gettorikomisyoruimst.WSGetTorikomiSyoruiMstImpl;
import yuyu.common.workflowcore.core.webservice.provide.imagekanri.outputqrcodeimages.WSOutputQrCodeImages;
import yuyu.common.workflowcore.core.webservice.provide.imagekanri.outputqrcodeimages.WSOutputQrCodeImagesImpl;
import yuyu.common.workflowcore.core.webservice.provide.imagekanri.putArrivalImage.WSPutArrivalImage;
import yuyu.common.workflowcore.core.webservice.provide.imagekanri.putArrivalImage.WSPutArrivalImageImpl;
import yuyu.common.workflowcore.core.webservice.provide.imagekanri.putimage.WSPutImage;
import yuyu.common.workflowcore.core.webservice.provide.imagekanri.putimage.WSPutImageImpl;
import yuyu.common.workflowcore.core.webservice.provide.imagekanri.setImageRelation.WSSetImageRelation;
import yuyu.common.workflowcore.core.webservice.provide.imagekanri.setImageRelation.WSSetImageRelationImpl;
import yuyu.common.workflowcore.core.webservice.provide.kouteikanri.continuelockprocess.WSContinueLockProcess;
import yuyu.common.workflowcore.core.webservice.provide.kouteikanri.continuelockprocess.WSContinueLockProcessImpl;
import yuyu.common.workflowcore.core.webservice.provide.kouteikanri.createprocessrecord.WSCreateProcessRecord;
import yuyu.common.workflowcore.core.webservice.provide.kouteikanri.createprocessrecord.WSCreateProcessRecordImpl;
import yuyu.common.workflowcore.core.webservice.provide.kouteikanri.createtasksummary.WSCreateTaskSummary;
import yuyu.common.workflowcore.core.webservice.provide.kouteikanri.createtasksummary.WSCreateTaskSummaryImpl;
import yuyu.common.workflowcore.core.webservice.provide.kouteikanri.execforceprocessforward.WSExecForceProcessForward;
import yuyu.common.workflowcore.core.webservice.provide.kouteikanri.execforceprocessforward.WSExecForceProcessForwardImpl;
import yuyu.common.workflowcore.core.webservice.provide.kouteikanri.execprocesscancel.WSExecProcessCancel;
import yuyu.common.workflowcore.core.webservice.provide.kouteikanri.execprocesscancel.WSExecProcessCancelImpl;
import yuyu.common.workflowcore.core.webservice.provide.kouteikanri.execprocesscreate.WSExecProcessCreate;
import yuyu.common.workflowcore.core.webservice.provide.kouteikanri.execprocesscreate.WSExecProcessCreateImpl;
import yuyu.common.workflowcore.core.webservice.provide.kouteikanri.execprocessforward.WSExecProcessForward;
import yuyu.common.workflowcore.core.webservice.provide.kouteikanri.execprocessforward.WSExecProcessForwardImpl;
import yuyu.common.workflowcore.core.webservice.provide.kouteikanri.execprocessforwardforbatch.WSExecProcessForwardForBatch;
import yuyu.common.workflowcore.core.webservice.provide.kouteikanri.execprocessforwardforbatch.WSExecProcessForwardForBatchImpl;
import yuyu.common.workflowcore.core.webservice.provide.kouteikanri.execprocessupdate.WSExecProcessUpdate;
import yuyu.common.workflowcore.core.webservice.provide.kouteikanri.execprocessupdate.WSExecProcessUpdateImpl;
import yuyu.common.workflowcore.core.webservice.provide.kouteikanri.execprocessupdateforbatch.WSExecProcessUpdateForBatch;
import yuyu.common.workflowcore.core.webservice.provide.kouteikanri.execprocessupdateforbatch.WSExecProcessUpdateForBatchImpl;
import yuyu.common.workflowcore.core.webservice.provide.kouteikanri.exectaskcancel.WSExecTaskCancel;
import yuyu.common.workflowcore.core.webservice.provide.kouteikanri.exectaskcancel.WSExecTaskCancelImpl;
import yuyu.common.workflowcore.core.webservice.provide.kouteikanri.exectaskstart.WSExecTaskStart;
import yuyu.common.workflowcore.core.webservice.provide.kouteikanri.exectaskstart.WSExecTaskStartImpl;
import yuyu.common.workflowcore.core.webservice.provide.kouteikanri.forceunlockprocess.WSForceUnlockProcess;
import yuyu.common.workflowcore.core.webservice.provide.kouteikanri.forceunlockprocess.WSForceUnlockProcessImpl;
import yuyu.common.workflowcore.core.webservice.provide.kouteikanri.getTaskKensuu.WSGetTaskKensuu;
import yuyu.common.workflowcore.core.webservice.provide.kouteikanri.getTaskKensuu.WSGetTaskKensuuImpl;
import yuyu.common.workflowcore.core.webservice.provide.kouteikanri.getexecutabletasks.WSGetExecutableTasks;
import yuyu.common.workflowcore.core.webservice.provide.kouteikanri.getexecutabletasks.WSGetExecutableTasksImpl;
import yuyu.common.workflowcore.core.webservice.provide.kouteikanri.getexecutabletasksbyprocess.WSGetExecutableTasksByProcess;
import yuyu.common.workflowcore.core.webservice.provide.kouteikanri.getexecutabletasksbyprocess.WSGetExecutableTasksByProcessImpl;
import yuyu.common.workflowcore.core.webservice.provide.kouteikanri.getkouteirirekiandsummarybyuser.WSGetKouteiRirekiAndSummaryByUser;
import yuyu.common.workflowcore.core.webservice.provide.kouteikanri.getkouteirirekiandsummarybyuser.WSGetKouteiRirekiAndSummaryByUserImpl;
import yuyu.common.workflowcore.core.webservice.provide.kouteikanri.getkouteirirekisummary.WSGetKouteiRirekiSummary;
import yuyu.common.workflowcore.core.webservice.provide.kouteikanri.getkouteirirekisummary.WSGetKouteiRirekiSummaryImpl;
import yuyu.common.workflowcore.core.webservice.provide.kouteikanri.getkouteirirekisyousai.WSGetKouteiRirekiSyousai;
import yuyu.common.workflowcore.core.webservice.provide.kouteikanri.getkouteirirekisyousai.WSGetKouteiRirekiSyousaiImpl;
import yuyu.common.workflowcore.core.webservice.provide.kouteikanri.getlockinfo.WSGetLockInfo;
import yuyu.common.workflowcore.core.webservice.provide.kouteikanri.getlockinfo.WSGetLockInfoImpl;
import yuyu.common.workflowcore.core.webservice.provide.kouteikanri.getprocessattribute.WSGetProcessAttribute;
import yuyu.common.workflowcore.core.webservice.provide.kouteikanri.getprocessattribute.WSGetProcessAttributeImpl;
import yuyu.common.workflowcore.core.webservice.provide.kouteikanri.getprocessinfo.WSGetProcessInfo;
import yuyu.common.workflowcore.core.webservice.provide.kouteikanri.getprocessinfo.WSGetProcessInfoImpl;
import yuyu.common.workflowcore.core.webservice.provide.kouteikanri.getsometask.WSGetSomeTask;
import yuyu.common.workflowcore.core.webservice.provide.kouteikanri.getsometask.WSGetSomeTaskImpl;
import yuyu.common.workflowcore.core.webservice.provide.kouteikanri.gettaskdefs.WSGetTaskDefs;
import yuyu.common.workflowcore.core.webservice.provide.kouteikanri.gettaskdefs.WSGetTaskDefsImpl;
import yuyu.common.workflowcore.core.webservice.provide.kouteikanri.gettaskkensuubyactor.WSGetTaskKensuuByActor;
import yuyu.common.workflowcore.core.webservice.provide.kouteikanri.gettaskkensuubyactor.WSGetTaskKensuuByActorImpl;
import yuyu.common.workflowcore.core.webservice.provide.kouteikanri.gettaskprocesses.WSGetTaskProcesses;
import yuyu.common.workflowcore.core.webservice.provide.kouteikanri.gettaskprocesses.WSGetTaskProcessesImpl;
import yuyu.common.workflowcore.core.webservice.provide.kouteikanri.gettasks.WSGetTasks;
import yuyu.common.workflowcore.core.webservice.provide.kouteikanri.gettasks.WSGetTasksImpl;
import yuyu.common.workflowcore.core.webservice.provide.kouteikanri.gettasksummary.WSGetTaskSummary;
import yuyu.common.workflowcore.core.webservice.provide.kouteikanri.gettasksummary.WSGetTaskSummaryImpl;
import yuyu.common.workflowcore.core.webservice.provide.kouteikanri.gettasksummarybyactor.WSGetTaskSummaryByActor;
import yuyu.common.workflowcore.core.webservice.provide.kouteikanri.gettasksummarybyactor.WSGetTaskSummaryByActorImpl;
import yuyu.common.workflowcore.core.webservice.provide.kouteikanri.gettransitions.WSGetTransitions;
import yuyu.common.workflowcore.core.webservice.provide.kouteikanri.gettransitions.WSGetTransitionsImpl;
import yuyu.common.workflowcore.core.webservice.provide.kouteikanri.ikkatuprocesscreate.WSIkkatuProcessCreate;
import yuyu.common.workflowcore.core.webservice.provide.kouteikanri.ikkatuprocesscreate.WSIkkatuProcessCreateImpl;
import yuyu.common.workflowcore.core.webservice.provide.kouteikanri.lockprocess.WSLockProcess;
import yuyu.common.workflowcore.core.webservice.provide.kouteikanri.lockprocess.WSLockProcessImpl;
import yuyu.common.workflowcore.core.webservice.provide.kouteikanri.setprocessattribute.WSSetProcessAttribute;
import yuyu.common.workflowcore.core.webservice.provide.kouteikanri.setprocessattribute.WSSetProcessAttributeImpl;
import yuyu.common.workflowcore.core.webservice.provide.kouteikanri.unlockprocess.WSUnlockProcess;
import yuyu.common.workflowcore.core.webservice.provide.kouteikanri.unlockprocess.WSUnlockProcessImpl;
import yuyu.common.workflowcore.iwfcommon.CheckException;
import yuyu.common.workflowcore.iwfcommon.GetAuthsForIWF;
import yuyu.common.workflowcore.iwfcommon.RayCheckExceptionImpl;
import yuyu.common.workflowcore.iwfcommon.RayGetAuthsForIWFImpl;
import yuyu.common.workflowcore.iwfcommon.extension.decisionhandler.WSBunkiHantei;
import yuyu.common.workflowcore.iwfcommon.extension.decisionhandler.WSBunkiHanteiImpl;
import yuyu.common.workflowcore.scan.impl.ScanReceiverImpl;
import yuyu.def.workflowcore.manager.IwfCoreDomManager;
import yuyu.def.workflowcore.manager.impl.IwfCoreDomManagerImpl;

import com.google.inject.Provides;

/**
 */
public class WorkflowcoreCommonModule extends AbstractSWAKModule {
    @Override
    protected void configure() {


        bind(IwfCoreDomManager.class).to(IwfCoreDomManagerImpl.class);
        bind(GetAuthsForIWF.class).to(RayGetAuthsForIWFImpl.class);
        bind(CheckException.class).to(RayCheckExceptionImpl.class);

        bind(WSDelAuthority.class).to(WSDelAuthorityImpl.class);
        bind(WSGetImageAuthority.class).to(WSGetImageAuthorityImpl.class);
        bind(WSUpdImageAuthority.class).to(WSUpdImageAuthorityImpl.class);
        bind(WSDelImageAuthority.class).to(WSDelImageAuthorityImpl.class);
        bind(WSGetAuthInfo.class).to(WSGetAuthInfoImpl.class);
        bind(WSCreateTaskAuthority.class).to(WSCreateTaskAuthorityImpl.class);
        bind(WSDelTaskAuthority.class).to(WSDelTaskAuthorityImpl.class);
        bind(WSGetTaskAuthInfo.class).to(WSGetTaskAuthInfoImpl.class);
        bind(WSUpdAuthority.class).to(WSUpdAuthorityImpl.class);

        bind(WSDropImageById.class).to(WSDropImageByIdImpl.class);
        bind(WSGetImageById.class).to(WSGetImageByIdImpl.class);
        bind(WSGetImagePropsById.class).to(WSGetImagePropsByIdImpl.class);
        bind(WSGetQrCodeImages.class).to(WSGetQrCodeImagesImpl.class);
        bind(WSGetTargetImageProps.class).to(WSGetTargetImagePropsImpl.class);
        bind(WSGetTargetImages.class).to(WSGetTargetImagesImpl.class);
        bind(WSGetTorikomiSyoruiMst.class).to(WSGetTorikomiSyoruiMstImpl.class);
        bind(WSOutputQrCodeImages.class).to(WSOutputQrCodeImagesImpl.class);
        bind(WSPutImage.class).to(WSPutImageImpl.class);
        bind(WSCreateExpectedArrivalNotice.class).to(WSCreateExpectedArrivalNoticeImpl.class);
        bind(WSGetExpectedArrivalNotice.class).to(WSGetExpectedArrivalNoticeImpl.class);
        bind(WSPutArrivalImage.class).to(WSPutArrivalImageImpl.class);
        bind(WSSetImageRelation.class).to(WSSetImageRelationImpl.class);
        bind(WSGetkouteiSiteiImageProps.class).to(WSGetKouteiSiteiImagePropsImpl.class);

        bind(WSCreateProcessRecord.class).to(WSCreateProcessRecordImpl.class);
        bind(WSExecForceProcessForward.class).to(WSExecForceProcessForwardImpl.class);
        bind(WSExecProcessCancel.class).to(WSExecProcessCancelImpl.class);
        bind(WSExecProcessCreate.class).to(WSExecProcessCreateImpl.class);
        bind(WSExecProcessForward.class).to(WSExecProcessForwardImpl.class);
        bind(WSExecProcessForwardForBatch.class).to(WSExecProcessForwardForBatchImpl.class);
        bind(WSExecProcessUpdate.class).to(WSExecProcessUpdateImpl.class);
        bind(WSExecProcessUpdateForBatch.class).to(WSExecProcessUpdateForBatchImpl.class);
        bind(WSExecTaskCancel.class).to(WSExecTaskCancelImpl.class);
        bind(WSExecTaskStart.class).to(WSExecTaskStartImpl.class);
        bind(WSForceUnlockProcess.class).to(WSForceUnlockProcessImpl.class);
        bind(WSGetExecutableTasks.class).to(WSGetExecutableTasksImpl.class);
        bind(WSGetExecutableTasksByProcess.class).to(WSGetExecutableTasksByProcessImpl.class);
        bind(WSGetKouteiRirekiSummary.class).to(WSGetKouteiRirekiSummaryImpl.class);
        bind(WSGetKouteiRirekiSyousai.class).to(WSGetKouteiRirekiSyousaiImpl.class);
        bind(WSGetKouteiRirekiAndSummaryByUser.class).to(WSGetKouteiRirekiAndSummaryByUserImpl.class);
        bind(WSGetProcessAttribute.class).to(WSGetProcessAttributeImpl.class);
        bind(WSGetProcessInfo.class).to(WSGetProcessInfoImpl.class);
        bind(WSGetSomeTask.class).to(WSGetSomeTaskImpl.class);
        bind(WSGetTaskDefs.class).to(WSGetTaskDefsImpl.class);
        bind(WSGetTaskProcesses.class).to(WSGetTaskProcessesImpl.class);
        bind(WSGetTasks.class).to(WSGetTasksImpl.class);
        bind(WSGetTransitions.class).to(WSGetTransitionsImpl.class);
        bind(WSIkkatuProcessCreate.class).to(WSIkkatuProcessCreateImpl.class);
        bind(WSLockProcess.class).to(WSLockProcessImpl.class);
        bind(WSSetProcessAttribute.class).to(WSSetProcessAttributeImpl.class);
        bind(WSUnlockProcess.class).to(WSUnlockProcessImpl.class);
        bind(WSContinueLockProcess.class).to(WSContinueLockProcessImpl.class);
        bind(WSGetLockInfo.class).to(WSGetLockInfoImpl.class);
        bind(WSCreateTaskSummary.class).to(WSCreateTaskSummaryImpl.class);
        bind(WSGetTaskSummary.class).to(WSGetTaskSummaryImpl.class);
        bind(WSGetTaskSummaryByActor.class).to(WSGetTaskSummaryByActorImpl.class);
        bind(WSGetTaskKensuu.class).to(WSGetTaskKensuuImpl.class);
        bind(WSGetTaskKensuuByActor.class).to(WSGetTaskKensuuByActorImpl.class);

        bind(WSDeleteProcessAndJBPMRecord.class).to(WSDeleteProcessAndJBPMRecordImpl.class);

        bind(ScanReceiver.class).to(ScanReceiverImpl.class);

        bind(WSBunkiHantei.class).to(WSBunkiHanteiImpl.class);

        bind(WSToutyakuYoteiNotFound.class).to(WSToutyakuYoteiNotFoundImpl.class);
        bind(WSImageTerminator.class).to(WSImageTerminatorImpl.class);

        bind(ExecutableTaskDao.class).to(ExecutableTaskDaoImpl.class);

        try {
            @SuppressWarnings("unchecked")
            Class<? extends IWorkflowContext> workflowContextImpl = (Class<? extends IWorkflowContext>) Class.forName(
                WorkflowConfig.getProperty("iwf.workflow.context.impl.class")
                );
            bind(IWorkflowContext.class).to(workflowContextImpl).in(ThreadScoped.class);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private static JbpmConfiguration jbpmConfiguration = JbpmConfiguration.parseResource("config/jbpm.cfg.xml");

    @Provides
    public JbpmContext provideJbpmContext() {
        return jbpmConfiguration.createJbpmContext();
    }
}
