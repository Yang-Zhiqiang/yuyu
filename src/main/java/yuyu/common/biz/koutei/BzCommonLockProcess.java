package yuyu.common.biz.koutei;

import javax.inject.Inject;

import jp.co.slcs.swak.bizinfr.exception.BizLogicException;
import yuyu.common.biz.exception.LockProcessException;
import yuyu.def.MessageId;
import yuyu.def.classification.C_KouteiLockKekkaKbn;

/**
 * 業務共通 工程 工程ロック共通処理
 */
public class BzCommonLockProcess {

    @Inject
    private BzCommonLockProcessBean bzCommonLockProcessBean;

    @Inject
    private BzLockProcess bzLockProcess;

    @Inject
    private BzContinueLockProcess bzContinueLockProcess;

    @Inject
    private BzUnlockProcess bzUnlockProcess;

    public BzCommonLockProcess() {
        super();
    }

    public void lockProcess(String pLockTsyuKouteiKanriId, String pLockTsyuJimuTetuzukiCd) {

        BzLockProcessOutBean bzLockProcessOutBean =
                bzLockProcess.exec(pLockTsyuKouteiKanriId, pLockTsyuJimuTetuzukiCd);

        if (!C_KouteiLockKekkaKbn.SUCCESS.eq(bzLockProcessOutBean.getKouteiLockKekkaKbn())) {
            throw new BizLogicException(MessageId.EBA0110);
        }

        bzCommonLockProcessBean.setKouteiLockKey(bzLockProcessOutBean.getKouteiLockKey());
        bzCommonLockProcessBean.setLockTsyuKouteiKanriId(pLockTsyuKouteiKanriId);
        bzCommonLockProcessBean.setLockTsyuJimuTetuzukiCd(pLockTsyuJimuTetuzukiCd);
    }

    public void continueLockProcess() {

        C_KouteiLockKekkaKbn kouteiLockKekkaKbn =
                bzContinueLockProcess.exec(
                        bzCommonLockProcessBean.getLockTsyuKouteiKanriId(),
                        bzCommonLockProcessBean.getLockTsyuJimuTetuzukiCd(),
                        bzCommonLockProcessBean.getKouteiLockKey());

        if (!C_KouteiLockKekkaKbn.SUCCESS.eq(kouteiLockKekkaKbn)) {
            bzCommonLockProcessBean.setKouteiLockKey("");
            throw new LockProcessException();
        }

    }

    public void unlockProcess() {

        bzUnlockProcess.exec(
                bzCommonLockProcessBean.getLockTsyuKouteiKanriId(),
                bzCommonLockProcessBean.getLockTsyuJimuTetuzukiCd(),
                bzCommonLockProcessBean.getKouteiLockKey());

        bzCommonLockProcessBean.setKouteiLockKey("");
    }

    public String getKouteiLockKey() {

        return bzCommonLockProcessBean.getKouteiLockKey();
    }

}
