package yuyu.batch.sinkeiyaku.sksonota.skkurikosikeiyakuhantei;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.batch.annotation.AppBatchExceptionTerminate;
import jp.co.slcs.swak.batch.annotation.Execute;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.db.EntityInserter;
import jp.co.slcs.swak.db.ExDBUpdatableResults;
import jp.co.slcs.swak.util.message.MessageUtil;
import yuyu.common.biz.bzcommon.BzBatchAbendCommonRecovery;
import yuyu.common.biz.bzcommon.BzBatchParam;
import yuyu.common.sinkeiyaku.skcommon.SkIdounaiyouBeforeBean;
import yuyu.common.sinkeiyaku.skcommon.SkToujituIdounaiyouEdit;
import yuyu.def.MessageId;
import yuyu.def.biz.bean.param.BzRecoveryDatasikibetuBean;
import yuyu.def.classification.C_KetteiKbn;
import yuyu.def.classification.C_NyuukinjyoutaiKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.BT_TjtIdouNySk;
import yuyu.def.db.entity.HT_MosKihon;
import yuyu.def.db.entity.HT_SyoriCTL;
import yuyu.def.sinkeiyaku.manager.SinkeiyakuDomManager;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.BatchParam;
import yuyu.infr.batch.logger.BatchLogger;

/**
 * 新契約 その他 繰越契約判定処理
 */
public class SkKurikosiKeiyakuHanteiBatch implements Batch {

    private String kosID;

    private String kosTime;

    private BizDate syoriYmd;

    private BizDateYM seisekiYm;

    private BizDateYM bosyuuYm;

    @Inject
    private BatchLogger batchLogger;

    @Inject
    private BzBatchParam bzBatchParam;

    @Inject
    SinkeiyakuDomManager sinkeiyakuDomManager;

    @Inject
    private BzRecoveryDatasikibetuBean bzRecoveryDatasikibetuBean;

    @Override
    public BatchParam getParam() {
        return bzBatchParam;
    }

    @Execute
    @Transactional
    public void execute() {

        syoriYmd = bzBatchParam.getSyoriYmd();
        seisekiYm = syoriYmd.getBizDateYM();
        bosyuuYm = syoriYmd.getBizDateYM();
        kosID = bzBatchParam.getUserId();
        kosTime = BizDate.getSysDateTimeMilli();
        String tysyttaisyouTableID = "HT_SyoriCTL";
        String recoveryfilterID = "Sk001";

        batchLogger.info(MessageUtil.getMessage(MessageId.IBA0016,
            MessageUtil.getMessage(MessageId.IBW0003), String.valueOf(syoriYmd)));

        batchLogger.info(MessageUtil.getMessage(MessageId.IBA0016,
            MessageUtil.getMessage(MessageId.IBW1018), bzBatchParam.getIbKakutyoujobcd()));

        int syoriKensuu = 0;
        SkToujituIdounaiyouEdit skToujituIdounaiyouEdit = SWAKInjector.getInstance(SkToujituIdounaiyouEdit.class);

        try (ExDBUpdatableResults<HT_SyoriCTL> syoriCTLLst =
            sinkeiyakuDomManager.getSyoriCTLsByKakutyoujobcdSeiritukbnSeisekiymBosyuuym(
                bzBatchParam.getIbKakutyoujobcd(), seisekiYm, bosyuuYm);
            EntityInserter<BT_TjtIdouNySk> tjtIdouNySkInsLst = new EntityInserter<>()) {

            for (HT_SyoriCTL syoriCTL : syoriCTLLst) {

                HT_MosKihon mosKihon = syoriCTL.getMosKihon();

                bzRecoveryDatasikibetuBean.setIbKakutyoujobcd(bzBatchParam.getIbKakutyoujobcd());
                bzRecoveryDatasikibetuBean.setIbTableid(tysyttaisyouTableID);
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterid(recoveryfilterID);
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterkey1(syoriCTL.getMosno());

                SkIdounaiyouBeforeBean skIdounaiyouBeforeBean = skToujituIdounaiyouEdit.setSkIdounaiyouBefore(syoriCTL);

                if (C_NyuukinjyoutaiKbn.SONOTA_MINYUUKIN.eq(syoriCTL.getNyuukinjoutaikbn())) {
                    syoriCTL.setMinyknkurikosiumu(C_UmuKbn.ARI);
                }
                else if (C_KetteiKbn.NONE.eq(syoriCTL.getKetteikbn()) || C_KetteiKbn.KETTEI_MATI.eq(syoriCTL.getKetteikbn())) {
                    syoriCTL.setKettienkurikosiumu(C_UmuKbn.ARI);
                }
                else {
                    syoriCTL.setSrhkurikosiumu(C_UmuKbn.ARI);
                }

                mosKihon.setSeisekiym(seisekiYm);
                mosKihon.setBosyuuym(bosyuuYm);
                setSystemKoumoku(syoriCTL, mosKihon, kosID, kosTime);

                boolean hanteiKekka = skToujituIdounaiyouEdit.skIdounaiyouHenkouCheck(syoriCTL, skIdounaiyouBeforeBean);

                if (hanteiKekka) {

                    BT_TjtIdouNySk tjtIdouNySk = skToujituIdounaiyouEdit.skIdounaiyouFileEdit(syoriCTL);
                    if (tjtIdouNySk != null) {

                        tjtIdouNySkInsLst.add(tjtIdouNySk);
                    }
                    else {
                        batchLogger.error(MessageUtil.getMessage(MessageId.EHA1051, "新契約当日異動内容(ファイル)編集",
                            "申込番号", syoriCTL.getMosno()));
                    }
                }
                syoriKensuu++;
            }

            bzRecoveryDatasikibetuBean.initializeBlank();
        }
        batchLogger.info(MessageUtil.getMessage(MessageId.IBF0001, String.valueOf(syoriKensuu)));
    }

    private void setSystemKoumoku(HT_SyoriCTL pSyoriCTL, HT_MosKihon pMosKihon, String pUserID, String pSysDate) {

        pMosKihon.setGyoumuKousinsyaId(pUserID);
        pMosKihon.setGyoumuKousinTime(pSysDate);

        pSyoriCTL.setGyoumuKousinsyaId(pUserID);
        pSyoriCTL.setGyoumuKousinTime(pSysDate);
    }

    @AppBatchExceptionTerminate
    private void abendexec() {

        BzBatchAbendCommonRecovery bzBatchAbendCommonRecovery =
            SWAKInjector.getInstance(BzBatchAbendCommonRecovery.class);

        bzBatchAbendCommonRecovery.exec();
    }
}