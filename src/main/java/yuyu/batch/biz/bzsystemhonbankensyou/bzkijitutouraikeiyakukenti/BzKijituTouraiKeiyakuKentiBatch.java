package yuyu.batch.biz.bzsystemhonbankensyou.bzkijitutouraikeiyakukenti;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.batch.annotation.Execute;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.EntityInserter;
import jp.co.slcs.swak.db.EntityUpdater;
import jp.co.slcs.swak.db.ExDBResults;
import jp.co.slcs.swak.util.message.MessageUtil;
import yuyu.batch.biz.bzsystemhonbankensyou.bzkijitutouraikeiyakukenti.dba.BzKijituTouraiKeiyakuKentiDao;
import yuyu.batch.biz.bzsystemhonbankensyou.bzkijitutouraikeiyakukenti.dba.KijituTouraiHonbanKensyouDataBean;
import yuyu.common.base.BaseUserInfo;
import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.common.biz.bzcommon.BzBatchParam;
import yuyu.def.MessageId;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_TuutiJkKbn;
import yuyu.def.classification.C_YouhiKbn;
import yuyu.def.db.entity.AS_Kinou;
import yuyu.def.db.entity.BT_KijituTuriHnbnKnsouTut;
import yuyu.def.db.entity.BT_KijituTuriHnbnKnsouTutJk;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.BatchParam;
import yuyu.infr.batch.logger.BatchLogger;

/**
 * 業務共通 システム本番検証用 期日到来契約検知
 */
public class BzKijituTouraiKeiyakuKentiBatch implements Batch {

    @Inject
    private BatchLogger batchLogger;

    @Inject
    private BzBatchParam bzBatchParam;

    @Inject
    private BzKijituTouraiKeiyakuKentiDao bzkijituTouraiKeiyakuTyusyutuDao;

    @Inject
    private AS_Kinou kinou;

    @Inject
    private BaseUserInfo baseUserInfo;

    @Inject
    private BizDomManager bizDomManager;

    @Override
    public BatchParam getParam() {
        return bzBatchParam;
    }

    @Execute
    @Transactional
    public void execute() {
        BizDate syoriYmd = bzBatchParam.getSyoriYmd();
        String kakutyoujobCd = bzBatchParam.getIbKakutyoujobcd();
        long syoriCount = 0;
        String sysDateTimeMilli = BizDate.getSysDateTimeMilli();
        String kinouId = kinou.getKinouId();
        String userId = baseUserInfo.getUserId();

        batchLogger.info(MessageUtil.getMessage(MessageId.IBA0016, MessageUtil.getMessage(MessageId.IBW0003),
            String.valueOf(syoriYmd)));

        batchLogger.info(MessageUtil.getMessage(MessageId.IBA0016, MessageUtil.getMessage(MessageId.IBW1018),
            kakutyoujobCd));

        try (
            ExDBResults<KijituTouraiHonbanKensyouDataBean> skKouhuriUkTrkMihaneiListDbResults = bzkijituTouraiKeiyakuTyusyutuDao.
            getKijituTouraiHonbanKensyouDataBean(syoriYmd);
            EntityInserter<BT_KijituTuriHnbnKnsouTut> kijituTuriHnbnKnsouTutEntityInserter = new EntityInserter<BT_KijituTuriHnbnKnsouTut>();
            EntityUpdater<BT_KijituTuriHnbnKnsouTutJk> kijituTuriHnbnKnsouTutJkEntityUpdater = new EntityUpdater<BT_KijituTuriHnbnKnsouTutJk>(); ) {

            for (KijituTouraiHonbanKensyouDataBean kijituTouraiHonbanKensyouDataBean : skKouhuriUkTrkMihaneiListDbResults) {

                BT_KijituTuriHnbnKnsouTutJk kijituTuriHnbnKnsouTutJk = bizDomManager.getKijituTuriHnbnKnsouTutJk(
                    kijituTouraiHonbanKensyouDataBean.getSubSystemId(), kijituTouraiHonbanKensyouDataBean.getTysytno());

                if (kijituTuriHnbnKnsouTutJk == null || C_YouhiKbn.YOU.eq(kijituTuriHnbnKnsouTutJk.getNikaimeikoutuutiyouhi())) {

                    BT_KijituTuriHnbnKnsouTut kijituTuriHnbnKnsouTut = new BT_KijituTuriHnbnKnsouTut();

                    kijituTuriHnbnKnsouTut.setSyoriYmd(syoriYmd);
                    kijituTuriHnbnKnsouTut.setSubSystemId(kijituTouraiHonbanKensyouDataBean.getSubSystemId());
                    kijituTuriHnbnKnsouTut.setTysytno(kijituTouraiHonbanKensyouDataBean.getTysytno());
                    kijituTuriHnbnKnsouTut.setGyoumuKousinKinou(kinouId);
                    kijituTuriHnbnKnsouTut.setGyoumuKousinsyaId(userId);
                    kijituTuriHnbnKnsouTut.setGyoumuKousinTime(sysDateTimeMilli);
                    BizPropertyInitializer.initialize(kijituTuriHnbnKnsouTut);

                    kijituTuriHnbnKnsouTutEntityInserter.add(kijituTuriHnbnKnsouTut);

                    if (kijituTuriHnbnKnsouTutJk != null) {

                        kijituTuriHnbnKnsouTutJk.setTuutijkkbn(C_TuutiJkKbn.TOUROKUTYUU);
                        kijituTuriHnbnKnsouTutJk.setGyoumuKousinKinou(kinouId);
                        kijituTuriHnbnKnsouTutJk.setGyoumuKousinsyaId(userId);
                        kijituTuriHnbnKnsouTutJk.setGyoumuKousinTime(sysDateTimeMilli);

                        kijituTuriHnbnKnsouTutJkEntityUpdater.add(kijituTuriHnbnKnsouTutJk);
                    }

                    syoriCount++;

                }

                else {

                    if (C_TuutiJkKbn.BLNK.eq(kijituTuriHnbnKnsouTutJk.getTuutijkkbn())) {

                        BT_KijituTuriHnbnKnsouTut kijituTuriHnbnKnsouTut = new BT_KijituTuriHnbnKnsouTut();

                        kijituTuriHnbnKnsouTut.setSyoriYmd(syoriYmd);
                        kijituTuriHnbnKnsouTut.setSubSystemId(kijituTouraiHonbanKensyouDataBean.getSubSystemId());
                        kijituTuriHnbnKnsouTut.setTysytno(kijituTouraiHonbanKensyouDataBean.getTysytno());
                        kijituTuriHnbnKnsouTut.setGyoumuKousinKinou(kinouId);
                        kijituTuriHnbnKnsouTut.setGyoumuKousinsyaId(userId);
                        kijituTuriHnbnKnsouTut.setGyoumuKousinTime(sysDateTimeMilli);
                        BizPropertyInitializer.initialize(kijituTuriHnbnKnsouTut);

                        kijituTuriHnbnKnsouTutEntityInserter.add(kijituTuriHnbnKnsouTut);

                        kijituTuriHnbnKnsouTutJk.setTuutijkkbn(C_TuutiJkKbn.TOUROKUTYUU);
                        kijituTuriHnbnKnsouTutJk.setGyoumuKousinKinou(kinouId);
                        kijituTuriHnbnKnsouTutJk.setGyoumuKousinsyaId(userId);
                        kijituTuriHnbnKnsouTutJk.setGyoumuKousinTime(sysDateTimeMilli);

                        kijituTuriHnbnKnsouTutJkEntityUpdater.add(kijituTuriHnbnKnsouTutJk);

                        syoriCount++;

                    }
                }
            }
        }

        batchLogger.info(MessageUtil.getMessage(MessageId.IAC0020, String.valueOf(syoriCount)));

    }
}
