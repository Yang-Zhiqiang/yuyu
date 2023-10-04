package yuyu.batch.sinkeiyaku.skhubikanri.skhubityouhyou;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.batch.annotation.AppBatchExceptionTerminate;
import jp.co.slcs.swak.batch.annotation.Execute;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.EntityUpdater;
import jp.co.slcs.swak.db.ExDBResults;
import jp.co.slcs.swak.util.message.MessageUtil;
import yuyu.common.base.BaseUserInfo;
import yuyu.common.biz.bzcommon.BizUtil;
import yuyu.common.biz.bzcommon.BzBatchAbendCommonRecovery;
import yuyu.common.biz.bzcommon.BzBatchParam;
import yuyu.common.biz.bzcommon.EditSecurityKm;
import yuyu.common.sinkeiyaku.koutei.SkProcessForwardForBatchInBean;
import yuyu.common.sinkeiyaku.koutei.SkProcessForwardHubiTyouhyou;
import yuyu.common.sinkeiyaku.moschk.MosnaiCheckParam;
import yuyu.common.sinkeiyaku.skcommon.EditCsvHubiMikai;
import yuyu.common.sinkeiyaku.skcommon.EditPdfHubiTyouhyou;
import yuyu.common.sinkeiyaku.skcommon.ISkCommonKoumoku;
import yuyu.def.MessageId;
import yuyu.def.biz.bean.param.BzRecoveryDatasikibetuBean;
import yuyu.def.classification.C_HubikaisyoujoutaiKbn;
import yuyu.def.db.entity.AS_Kinou;
import yuyu.def.db.entity.HT_SyoriCTL;
import yuyu.def.sinkeiyaku.manager.SinkeiyakuDomManager;
import yuyu.def.sinkeiyaku.result.bean.HubiInfosByKakutyoujobcdHasinkyokakbnHasinymdBean;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.BatchParam;
import yuyu.infr.batch.logger.BatchLogger;

import com.google.common.collect.Lists;

/**
 * 新契約不備帳票作成のバッチクラスです。
 */
public class SkHubiTyouhyouBatch implements Batch {

    private static final String TASKNAME = "新契約不備帳票作成";

    @Inject
    private BatchLogger batchLogger;

    @Inject
    private BzBatchParam bzBatchParam;

    @Inject
    private AS_Kinou kinou;

    @Inject
    private BaseUserInfo baseUserInfo;

    @Inject
    private SinkeiyakuDomManager sinkeiyakuDomManager;

    @Inject
    private BzRecoveryDatasikibetuBean bzRecoveryDatasikibetuBean;

    @Override
    public BatchParam getParam() {
        return bzBatchParam;
    }

    @Execute
    @Transactional
    public void execute() {

        int hubiTuutiCnt = 0;

        BizDate syoriYmd = bzBatchParam.getSyoriYmd();

        MosnaiCheckParam mosnaiCheckParam = SWAKInjector.getInstance(MosnaiCheckParam.class);

        mosnaiCheckParam.setCategoryID(kinou.getCategoryId());
        mosnaiCheckParam.setKinouID(kinou.getKinouId());
        mosnaiCheckParam.setSysDate(syoriYmd);
        mosnaiCheckParam.setKosID(baseUserInfo.getUserId());
        mosnaiCheckParam.setKosTime(BizDate.getSysDateTime());

        batchLogger.info(MessageUtil.getMessage(
            MessageId.IBA0016, MessageUtil.getMessage(MessageId.IBW1018), bzBatchParam.getIbKakutyoujobcd()));


        try (ExDBResults<HubiInfosByKakutyoujobcdHasinkyokakbnHasinymdBean> hbInfoBeanLst =
            sinkeiyakuDomManager.getHubiInfosByKakutyoujobcdHasinkyokakbnHasinymd(bzBatchParam.getIbKakutyoujobcd());
            EntityUpdater<HT_SyoriCTL> syoriCTLEntityUpdater = new EntityUpdater<HT_SyoriCTL>()) {

            HT_SyoriCTL syoriCTL = null;

            EditPdfHubiTyouhyou editPdfHubiTyouhyou = null;

            C_HubikaisyoujoutaiKbn hubikaisyoujoutaiKbn = C_HubikaisyoujoutaiKbn.BLNK;

            EditSecurityKm editSecurityKm = EditSecurityKm.getInstance();
            String comment = null;
            String commentDecode = null;
            SkProcessForwardForBatchInBean processBean = null;
            List<SkProcessForwardForBatchInBean> processBeans = Lists.newArrayList();

            for (HubiInfosByKakutyoujobcdHasinkyokakbnHasinymdBean hbInfoBean : hbInfoBeanLst) {

                bzRecoveryDatasikibetuBean.setIbKakutyoujobcd(bzBatchParam.getIbKakutyoujobcd());
                bzRecoveryDatasikibetuBean.setIbTableid("HT_SkHubi");
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterid("Sk001");
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterkey1(hbInfoBean.getMosno());

                syoriCTL = sinkeiyakuDomManager.getSyoriCTL(hbInfoBean.getMosno());
                mosnaiCheckParam.setDataSyoriControl(syoriCTL);
                editPdfHubiTyouhyou = SWAKInjector.getInstance(EditPdfHubiTyouhyou.class);
                editPdfHubiTyouhyou.execBatch(hbInfoBean.getHubisikibetukey(), mosnaiCheckParam, syoriYmd);

                if (!C_HubikaisyoujoutaiKbn.HUBIKAISYOUMATI.eq(syoriCTL.getHubikaisyoujoutaikbn())) {
                    hubikaisyoujoutaiKbn = C_HubikaisyoujoutaiKbn.HUBIKAITOUMATI;
                }
                else {
                    hubikaisyoujoutaiKbn = C_HubikaisyoujoutaiKbn.HUBIKAISYOUMATI;
                }
                syoriCTL.setHubikaisyoujoutaikbn(hubikaisyoujoutaiKbn);
                syoriCTL.setGyoumuKousinsyaId(mosnaiCheckParam.getKosID());
                syoriCTL.setGyoumuKousinTime(mosnaiCheckParam.getKosTime());

                editSecurityKm.init(syoriCTL.getMosno());
                comment = syoriCTL.getSkHubiByHubisikibetukey(hbInfoBean.getHubisikibetukey()).getCommentarea();
                if (!BizUtil.isBlank(comment)) {
                    commentDecode = editSecurityKm.decode(comment);
                }
                else {
                    commentDecode = "";
                }

                processBean = SWAKInjector.getInstance(SkProcessForwardForBatchInBean.class);
                processBean.setHtSyoriCTL(syoriCTL);
                processBean.setTskNm(TASKNAME);
                processBean.setSyoriComment(commentDecode);
                processBeans.add(processBean);

                SkProcessForwardHubiTyouhyou procFwd = SWAKInjector.getInstance(SkProcessForwardHubiTyouhyou.class);
                procFwd.exec(processBeans);
                processBeans.clear();

                syoriCTLEntityUpdater.add(syoriCTL);

                hubiTuutiCnt ++;
            }

            bzRecoveryDatasikibetuBean.initializeBlank();

        }

        batchLogger.info(MessageUtil.getMessage(MessageId.IBF0002,
            String.valueOf(hubiTuutiCnt), ISkCommonKoumoku.TYOUHYOUMEI_HUBITUUTI));


        EditCsvHubiMikai editCsvHubiMikai = SWAKInjector.getInstance(EditCsvHubiMikai.class);

        int totalCnt = editCsvHubiMikai.exec(syoriYmd);

        batchLogger.info(MessageUtil.getMessage(MessageId.IBF0002,
            String.valueOf(totalCnt), "不備未解消リスト"));
    }


    @AppBatchExceptionTerminate
    private void abendexec() {

        BzBatchAbendCommonRecovery bzBatchAbendCommonRecovery =
            SWAKInjector.getInstance(BzBatchAbendCommonRecovery.class);

        bzBatchAbendCommonRecovery.exec();
    }
}
