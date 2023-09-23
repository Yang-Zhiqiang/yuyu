package yuyu.common.siharai.sicommon;

import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.bizinfr.exception.BizAppException;
import jp.co.slcs.swak.core.inject.SWAKInjector;

import org.slf4j.Logger;

import yuyu.common.base.BaseUserInfo;
import yuyu.common.biz.bzcommon.BizUtil;
import yuyu.common.biz.bzcommon.CheckKinouModeKengen;
import yuyu.common.biz.koutei.BzWorkflowInfo;
import yuyu.def.MessageId;
import yuyu.def.classification.C_SikinouModeIdKbn;
import yuyu.def.db.entity.AS_Kinou;
import yuyu.infr.kinoumode.KinouMode;

/**
 * 保険金給付金支払 保険金給付金支払共通 保険金給付金機能モード設定
 */
public class SiKinouModeSettei {

    @Inject
    private static Logger logger;

    @Inject
    private BzWorkflowInfo bzWorkflowInfo;

    @Inject
    private AS_Kinou asKinou;

    @Inject
    private BaseUserInfo baseUserInfo;

    @Inject
    private KinouMode kinouMode;

    public SiKinouModeSettei() {
        super();

    }

    public void exec(){

        logger.debug("▽ 保険金給付金機能モード設定 開始");

        String sikinouModeIdKbn = bzWorkflowInfo.getTaskId();

        if(!BizUtil.isBlank(sikinouModeIdKbn)){
            CheckKinouModeKengen checkKinouModeKengen = SWAKInjector.getInstance(CheckKinouModeKengen.class);
            checkKinouModeKengen.checkWorklistKinouModeKengen();

        } else {
            List<String> list = baseUserInfo.getAuthenticatedFunctionModes();
            if (list.contains(C_SikinouModeIdKbn.INPUT.getValue())) {
                kinouMode.setKinouMode(C_SikinouModeIdKbn.INPUT.getValue());

            } else if(list.contains(C_SikinouModeIdKbn.HUBITOUROKU.getValue())) {
                kinouMode.setKinouMode(C_SikinouModeIdKbn.HUBITOUROKU.getValue());

            } else if(list.contains(C_SikinouModeIdKbn.HUBIKAISYOU.getValue())) {
                kinouMode.setKinouMode(C_SikinouModeIdKbn.HUBIKAISYOU.getValue());

            } else if(list.contains(C_SikinouModeIdKbn.DEFAULT.getValue())) {
                kinouMode.setKinouMode(C_SikinouModeIdKbn.DEFAULT.getValue());

            } else {
                throw new BizAppException(MessageId.EBS0003);

            }
        }

        logger.debug("△ 保険金給付金機能モード設定 終了");
    }
}
