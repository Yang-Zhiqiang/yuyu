package yuyu.common.biz.bzcommon;

import javax.inject.Inject;

import yuyu.common.base.BaseUserInfo;
import yuyu.common.biz.exception.KinouModeKengenException;
import yuyu.common.biz.koutei.BzWorkflowInfo;
import yuyu.def.base.manager.BaseDomManager;
import yuyu.infr.kinoumode.KinouMode;

/**
 * 業務共通 共通 機能モード権限チェック
 */
public class CheckKinouModeKengen {

    @Inject
    private KinouMode kinouMode;

    @Inject
    private BaseUserInfo baseUserInfo;

    @Inject
    private BzWorkflowInfo bzWorkflowInfo;

    @Inject
    private BaseDomManager baseDomManager;

    public CheckKinouModeKengen() {
        super();
    }

    public void checkKengenByKinouModeId(String pKinouModeId) {

        if (baseUserInfo.hasAuthenticatedFunctionMode(pKinouModeId)) {
            kinouMode.setKinouMode(pKinouModeId);
        }
        else {
            throw new KinouModeKengenException();
        }
    }

    public void checkWorklistKinouModeKengen() {

        String kinouModeId = hanteiWorklistKinouModeId();

        checkKengenByKinouModeId(kinouModeId);
    }

    public String hanteiWorklistKinouModeId() {
        return bzWorkflowInfo.getTaskId();
    }

    public boolean checkKengenByKinouModeIdByUserId(String pUserId, String pKinouId, String pKinouModeId) {

        long count = baseDomManager.getUserCountByUserIdKinouIdKinouModeId(pUserId, pKinouId, pKinouModeId);

        if (count > 0) {
            return true;
        }

        return false;
    }

    public boolean checkKengenByKinouModeIdWithBoolean(String pKinouModeId) {

        if (baseUserInfo.hasAuthenticatedFunctionMode(pKinouModeId)) {
            kinouMode.setKinouMode(pKinouModeId);
            return true;
        }
        return false;
    }

}
