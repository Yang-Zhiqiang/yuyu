package yuyu.batch.biz.bzkaikei.bzsinkeiyakuhurikaedentblsks;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.batch.annotation.AppBatchExceptionTerminate;
import jp.co.slcs.swak.batch.annotation.Execute;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.EntityInserter;
import jp.co.slcs.swak.db.ExDBResults;
import jp.co.slcs.swak.util.message.MessageUtil;
import yuyu.common.base.BaseUserInfo;
import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.common.biz.bzcommon.BzBatchAbendCommonRecovery;
import yuyu.common.biz.bzcommon.BzBatchParam;
import yuyu.def.MessageId;
import yuyu.def.biz.bean.param.BzRecoveryDatasikibetuBean;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_HuriDenpyouKykTuukaKbn;
import yuyu.def.classification.C_KeirisysKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.db.entity.BT_DenpyoData;
import yuyu.def.db.entity.BT_SinkeiyakuHurikaeDen;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.BatchParam;
import yuyu.infr.batch.logger.BatchLogger;

/**
 * 業務共通 経理･会計 新契約振替伝票テーブル作成処理クラス
 */
public class BzSinkeiyakuHurikaeDenTblSksBatch implements Batch {

    private static final int HURIKAEDENHOZON = 120;

    private static final String TEKIYOUCD = "";

    private static final String DENPYODATAID = "BT_DenpyoData";

    private static final String DENPYODATAFILTERID = "Bz105";

    @Inject
    private BatchLogger batchLogger;

    @Inject
    private BzBatchParam bzBatchParam;

    @Inject
    private BaseUserInfo baseUserInfo;

    @Inject
    private BizDomManager bizDomManager;

    @Inject
    private BzSinkeiyakuHurikaeDenTblSksDao bzSinkeiyakuHurikaeDenTblSksDao;

    @Inject
    private BzRecoveryDatasikibetuBean bzRecoveryDatasikibetuBean;

    @Override
    public BatchParam getParam() {

        return bzBatchParam;
    }

    @Execute
    @Transactional
    public void execute() {

        batchLogger.info(MessageUtil.getMessage(MessageId.IBA0016, MessageUtil.getMessage(MessageId.IBW0003),
            String.valueOf(bzBatchParam.getSyoriYmd())));

        BizDate sakujyoSyoriYmd = bzBatchParam.getSyoriYmd().addDays(-HURIKAEDENHOZON);
        bzSinkeiyakuHurikaeDenTblSksDao.deleteSinkeiyakuHurikaeDensBySyoriYmd(sakujyoSyoriYmd);

        try (ExDBResults<BT_DenpyoData> denpyoDataLst = bizDomManager.getDenpyoDatasByKakutyoujobcdSyoriYmd(
            bzBatchParam.getIbKakutyoujobcd(),
            bzBatchParam.getSyoriYmd());
            EntityInserter<BT_SinkeiyakuHurikaeDen> sinkeiyakuHurikaeDenInserter = new EntityInserter<>()) {

            long syoriKensuu = 0;
            String torihikino = null;

            for (BT_DenpyoData denpyoData : denpyoDataLst) {

                bzRecoveryDatasikibetuBean.setIbKakutyoujobcd(bzBatchParam.getIbKakutyoujobcd());
                bzRecoveryDatasikibetuBean.setIbTableid(DENPYODATAID);
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterid(DENPYODATAFILTERID);
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterkey1(denpyoData.getDensyskbn().getValue());
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterkey2(String.valueOf(denpyoData.getDenrenno()));

                BT_SinkeiyakuHurikaeDen sinkeiyakuHurikaeDen = new BT_SinkeiyakuHurikaeDen();
                sinkeiyakuHurikaeDen.setDensyskbn(denpyoData.getDensyskbn());
                sinkeiyakuHurikaeDen.setDenrenno(denpyoData.getDenrenno());
                sinkeiyakuHurikaeDen.setEdano(denpyoData.getEdano());
                sinkeiyakuHurikaeDen.setKeirisyskbn(C_KeirisysKbn.SINKEIYAKU);
                sinkeiyakuHurikaeDen.setKeirisyono(denpyoData.getKeirisyono());
                sinkeiyakuHurikaeDen.setHuridenatesakicd(denpyoData.getHuridenatesakicd());
                sinkeiyakuHurikaeDen.setTantocd(denpyoData.getTantocd());
                if (denpyoData.getDenymd() != null) {
                    sinkeiyakuHurikaeDen.setDenymd(denpyoData.getDenymd());
                }
                sinkeiyakuHurikaeDen.setTaisyakukbn(denpyoData.getTaisyakukbn());
                sinkeiyakuHurikaeDen.setKanjyoukmkcd(denpyoData.getKanjyoukmkcd());
                sinkeiyakuHurikaeDen.setDenkanjokamokucd(denpyoData.getKanjyouKamoku().getDenkanjokamokucd());
                sinkeiyakuHurikaeDen.setSuitoubumoncd(denpyoData.getSuitoubumoncd());
                sinkeiyakuHurikaeDen.setDenyenkagk(denpyoData.getDenyenkagk());
                sinkeiyakuHurikaeDen.setSyoriYmd(bzBatchParam.getSyoriYmd());
                sinkeiyakuHurikaeDen.setNaibukeiyakukbn(denpyoData.getNaibukeiyakukbn());
                sinkeiyakuHurikaeDen.setTekiyoukbn(denpyoData.getTekiyoukbn());
                sinkeiyakuHurikaeDen.setTuukasyu(denpyoData.getTuukasyu());
                sinkeiyakuHurikaeDen.setDengyoumucd(denpyoData.getDengyoumucd());
                sinkeiyakuHurikaeDen.setSyoriYmd(bzBatchParam.getSyoriYmd());
                sinkeiyakuHurikaeDen.setGyoumuKousinsyaId(baseUserInfo.getUserId());
                sinkeiyakuHurikaeDen.setGyoumuKousinTime(BizDate.getSysDateTimeMilli());

                if (denpyoData.getKyktuukasyu().eq(C_Tuukasyu.JPY)) {
                    sinkeiyakuHurikaeDen.setHuridenpyoukyktuukakbn(C_HuriDenpyouKykTuukaKbn.ENKA);
                } else {
                    sinkeiyakuHurikaeDen.setHuridenpyoukyktuukakbn(C_HuriDenpyouKykTuukaKbn.GAIKA);
                }

                sinkeiyakuHurikaeDen.setTorihikino(torihikino);
                sinkeiyakuHurikaeDen.setTekiyoucd(getTekiyoucdSaiban());

                BizPropertyInitializer.initialize(sinkeiyakuHurikaeDen);
                sinkeiyakuHurikaeDenInserter.add(sinkeiyakuHurikaeDen);
                syoriKensuu++;
            }

            bzRecoveryDatasikibetuBean.initializeBlank();

            batchLogger.info(MessageUtil.getMessage(MessageId.IBF0001, String.valueOf(syoriKensuu)));
        }
    }

    public String getTekiyoucdSaiban() {

        return TEKIYOUCD;
    }

    @AppBatchExceptionTerminate
    private void appBatchExceptionTerminate() {

        BzBatchAbendCommonRecovery bzBatchAbendCommonRecovery =
            SWAKInjector.getInstance(BzBatchAbendCommonRecovery.class);

        bzBatchAbendCommonRecovery.exec();
    }
}
