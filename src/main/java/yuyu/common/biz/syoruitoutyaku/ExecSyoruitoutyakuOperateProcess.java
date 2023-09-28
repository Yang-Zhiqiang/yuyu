package yuyu.common.biz.syoruitoutyaku;

import iwf.callback.arriveimage.ImportImageTerminator;
import javax.inject.Inject;

/**
 * 業務共通 書類到着 書類到着時工程操作呼出し処理
 */
public class ExecSyoruitoutyakuOperateProcess extends ImportImageTerminator {

    @Inject
    private SyoruitoutyakuOperateProcessFactory syoruitoutyakuOperateProcessFactory;

    @Override
    public void terminate(String pToutyakuKey, String pAppKey, String pSyoruiCd, String pFlowId, String pSubsystemId, String pImageId) {

        SyoruitoutyakuOperateProcess syoruitoutyakuOperateProcess = syoruitoutyakuOperateProcessFactory.exec(pSubsystemId);

        syoruitoutyakuOperateProcess.exec(pToutyakuKey, pAppKey, pSyoruiCd, pFlowId, pSubsystemId, pImageId);
    }

}