package yuyu.batch.ray.control.orglimitregistrationreleasebatch;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.batch.annotation.Execute;
import jp.co.slcs.swak.batch.engine.BatchJob;
import jp.co.slcs.swak.bizinfr.exception.BizAppException;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.db.ExDBResults;
import jp.co.slcs.swak.util.message.MessageUtil;

import org.slf4j.Logger;

import yuyu.def.MessageId;
import yuyu.def.base.manager.BaseDomManager;
import yuyu.def.classification.C_SosikiCdTourokuKaijoKbn;
import yuyu.def.db.dao.AT_RinjiKadouTaisyoSosikiDao;
import yuyu.def.db.entity.AM_Sosiki;
import yuyu.def.db.entity.AT_RinjiKadouTaisyoSosiki;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.BatchParam;
import yuyu.infr.batch.logger.BatchLogger;

import com.google.common.base.Strings;
import com.google.common.collect.Lists;

/**
 * 組織限定登録解除バッチ
 */
public class OrgLimitRegistrationReleaseBatch implements Batch {

    @Inject
    private static Logger  log;
    @Inject
    private BatchLogger    batchLogger;
    @Inject
    private BaseDomManager baseManager;
    @Inject
    private AT_RinjiKadouTaisyoSosikiDao dao;
    @Inject
    private OrgLimitRegistrationReleaseBatchParam batchParam;

    @Inject
    private AM_SosikiDao sosikidao;

    @Override
    public BatchParam getParam() {
        return batchParam;
    }

    @Execute
    @Transactional
    public void execute() {

        log.debug("組織限定登録解除バッチ　開始");
        checkParam();

        if (!update()) {
            if (batchParam.getTourokuKaijoKbn().eq(C_SosikiCdTourokuKaijoKbn.TOUROKU)) {
                batchLogger.error(
                    MessageUtil.getMessage(
                        MessageId.EAF1015,
                        MessageUtil.getMessage(MessageId.IAW1005),
                        MessageUtil.getMessage(MessageId.IAW0010)));
            } else if (batchParam.getTourokuKaijoKbn().eq(C_SosikiCdTourokuKaijoKbn.KAIJO)) {
                batchLogger.error(
                    MessageUtil.getMessage(
                        "EAF1015",
                        MessageUtil.getMessage(MessageId.IAW1005),
                        MessageUtil.getMessage(MessageId.IAW1006)));
            }
            BatchJob batchJob = SWAKInjector.getInstance(BatchJob.class);
            batchJob.setWarningStatus(200);
        }

        log.debug("組織限定登録解除バッチ　終了");
    }

    private void checkParam() {
        if (batchParam.getTourokuKaijoKbn() == null) {
            throw new BizAppException(MessageId.EAF1009, MessageUtil.getMessage(MessageId.IAW1012));
        }
        if (Strings.isNullOrEmpty(batchParam.getSosikiCd())) {
            throw new BizAppException(MessageId.EAF1009, MessageUtil.getMessage(MessageId.IAW1005));
        }
    }

    @Transactional
    private boolean update() {
        String[] kadouSosikiCds = batchParam.getSosikiCd().split(OrgLimitRegistrationReleaseBatchConstants.SPLITTER);
        boolean result = true;

        if (batchParam.getTourokuKaijoKbn().equals(C_SosikiCdTourokuKaijoKbn.TOUROKU)) {
            for (String kadouSosikiCd : kadouSosikiCds) {
                if (kadouSosikiCd.equals(OrgLimitRegistrationReleaseBatchConstants.SOSIKICD_ALL)) {
                    try(ExDBResults<AM_Sosiki> sosikis = sosikidao.getAllLargeSosiki()){
                        List<AT_RinjiKadouTaisyoSosiki> rinjiKadouTaisyoSosikis = dao.selectAll();
                        List<String> existSosikiCd = Lists.newArrayList();
                        for (AT_RinjiKadouTaisyoSosiki rinjiKadouTaisyoSosiki : rinjiKadouTaisyoSosikis) {
                            existSosikiCd.add(rinjiKadouTaisyoSosiki.getKadouSosikiCd());
                        }
                        for (AM_Sosiki sosiki : sosikis) {
                            String sosikiCd = sosiki.getSosikicd();
                            if (!existSosikiCd.contains(sosikiCd)) {
                                AT_RinjiKadouTaisyoSosiki insertRinjiKadouSosiki = new AT_RinjiKadouTaisyoSosiki();
                                insertRinjiKadouSosiki.setKadouSosikiCd(sosikiCd);
                                baseManager.insert(insertRinjiKadouSosiki);
                            }
                        }
                    }
                } else {
                    AM_Sosiki sosiki = baseManager.getSosiki(kadouSosikiCd);
                    if (sosiki == null) {
                        batchLogger.error(
                            MessageUtil.getMessage(
                                MessageId.EAF1012,
                                MessageUtil.getMessage(MessageId.IAW1005),
                                new AM_Sosiki().getViewName(),
                                MessageUtil.getMessage(MessageId.IAW0010),
                                MessageUtil.getMessage(MessageId.IAW1005),
                                kadouSosikiCd));
                        result = false;
                    } else {
                        AT_RinjiKadouTaisyoSosiki rinjiKadouTaisyoSosiki = dao.getRinjiKadouTaisyoSosiki(kadouSosikiCd);
                        if (rinjiKadouTaisyoSosiki == null) {
                            AT_RinjiKadouTaisyoSosiki insertRinjiKadouSosiki = new AT_RinjiKadouTaisyoSosiki();
                            insertRinjiKadouSosiki.setKadouSosikiCd(kadouSosikiCd);
                            baseManager.insert(insertRinjiKadouSosiki);
                        } else {
                            batchLogger.error(
                                MessageUtil.getMessage(
                                    MessageId.EAF1019,
                                    MessageUtil.getMessage(MessageId.IAW1005),
                                    new AT_RinjiKadouTaisyoSosiki().getViewName(),
                                    MessageUtil.getMessage(MessageId.IAW0010),
                                    MessageUtil.getMessage(MessageId.IAW1005),
                                    kadouSosikiCd));
                            result = false;
                        }
                    }
                }
            }
        } else {
            for (String kadouSosikiCd : kadouSosikiCds) {
                if (kadouSosikiCd.equals(OrgLimitRegistrationReleaseBatchConstants.SOSIKICD_ALL)) {
                    List<AT_RinjiKadouTaisyoSosiki> rinjiKadouTaisyoSosikis = dao.selectAll();
                    baseManager.delete(rinjiKadouTaisyoSosikis);
                } else {
                    AT_RinjiKadouTaisyoSosiki rinjiKadouTaisyoSosiki = dao.getRinjiKadouTaisyoSosiki(kadouSosikiCd);
                    if (rinjiKadouTaisyoSosiki == null) {
                        batchLogger.error(
                            MessageUtil.getMessage(
                                MessageId.EAF1012,
                                MessageUtil.getMessage(MessageId.IAW1005),
                                new AT_RinjiKadouTaisyoSosiki().getViewName(),
                                MessageUtil.getMessage(MessageId.IAW1006),
                                MessageUtil.getMessage(MessageId.IAW1005),
                                kadouSosikiCd));
                        result = false;

                    } else {
                        baseManager.delete(rinjiKadouTaisyoSosiki);
                    }

                }
            }
        }
        return result;
    }

}
