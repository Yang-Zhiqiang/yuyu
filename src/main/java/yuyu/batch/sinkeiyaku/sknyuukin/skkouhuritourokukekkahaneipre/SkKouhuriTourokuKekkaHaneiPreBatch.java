package yuyu.batch.sinkeiyaku.sknyuukin.skkouhuritourokukekkahaneipre;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.batch.annotation.AppBatchExceptionTerminate;
import jp.co.slcs.swak.batch.annotation.Execute;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.EntityInserter;
import jp.co.slcs.swak.db.ExDBResults;
import jp.co.slcs.swak.util.message.MessageUtil;
import yuyu.batch.sinkeiyaku.sknyuukin.skkouhuritourokukekkahaneipre.dba.SkKouhuriTourokuKekkaHaneiPreDao;
import yuyu.common.base.BaseUserInfo;
import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.common.biz.bzcommon.BizUtil;
import yuyu.common.biz.bzcommon.BzBatchAbendCommonRecovery;
import yuyu.common.biz.bzcommon.BzBatchParam;
import yuyu.def.MessageId;
import yuyu.def.biz.bean.param.BzRecoveryDatasikibetuBean;
import yuyu.def.classification.C_KouhuristatusKbn;
import yuyu.def.classification.C_Syorizumiflg;
import yuyu.def.classification.C_YokinKbn;
import yuyu.def.db.entity.AS_Kinou;
import yuyu.def.db.entity.HT_SkKouhuriUkTrkMihanei;
import yuyu.def.db.entity.ZT_SkKouhuriUkTrkkekkaTr;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.logger.BatchLogger;

/**
 * 新契約 入金 口振受付登録結果反映前処理
 */
public class SkKouhuriTourokuKekkaHaneiPreBatch implements Batch {

    private final String TABLE_ID = ZT_SkKouhuriUkTrkkekkaTr.TABLE_NAME;

    private final String FILTER_ID = "Bz113";

    @Inject
    private BatchLogger batchLogger;

    @Inject
    private BzBatchParam bzBatchParam;

    @Inject
    private BzRecoveryDatasikibetuBean bzRecoveryDatasikibetuBean;

    @Inject
    private SkKouhuriTourokuKekkaHaneiPreDao skKouhuriTourokuKekkaHaneiPreDao;

    @Inject
    private AS_Kinou kinou;

    @Inject
    private BaseUserInfo baseUserInfo;

    @Override
    public BzBatchParam getParam() {
        return bzBatchParam;
    }

    @Execute
    @Transactional
    public void execute() {

        BizDate syoriYmd = bzBatchParam.getSyoriYmd();
        String ibKakutyoujobcd = bzBatchParam.getIbKakutyoujobcd();

        batchLogger.info(MessageUtil.getMessage(MessageId.IBA0016, MessageUtil.getMessage(MessageId.IBW0003),
            String.valueOf(syoriYmd)));
        batchLogger.info(MessageUtil.getMessage(MessageId.IBA0016, MessageUtil.getMessage(MessageId.IBW1018),
            ibKakutyoujobcd));

        long syoriKensuu = 0;

        try (
            ExDBResults<ZT_SkKouhuriUkTrkkekkaTr> skKouhuriUkTrkkekkaTrList =
            skKouhuriTourokuKekkaHaneiPreDao.getSkKouhuriUkTrkkekkaTrs(ibKakutyoujobcd);
            EntityInserter<HT_SkKouhuriUkTrkMihanei> skKouhuriUkTrkMihaneiInserter = new EntityInserter<>();) {

            for (ZT_SkKouhuriUkTrkkekkaTr skKouhuriUkTrkkekkaTr : skKouhuriUkTrkkekkaTrList) {

                bzRecoveryDatasikibetuBean.setIbKakutyoujobcd(ibKakutyoujobcd);
                bzRecoveryDatasikibetuBean.setIbTableid(TABLE_ID);
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterid(FILTER_ID);
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterkey1(skKouhuriUkTrkkekkaTr.getZtrkouhuriokyakusamano());

                syoriKensuu = syoriKensuu + 1;
                String nyknMosno = skKouhuriUkTrkkekkaTr.getZtrkouhuriokyakusamano().substring(1, 10);

                HT_SkKouhuriUkTrkMihanei skKouhuriUkTrkMihanei = new HT_SkKouhuriUkTrkMihanei();

                skKouhuriUkTrkMihanei.setSyoriYmd(syoriYmd);
                skKouhuriUkTrkMihanei.setSyukkncd(skKouhuriUkTrkkekkaTr.getZtrsyukkncd());
                skKouhuriUkTrkMihanei.setKinyuucd8keta(skKouhuriUkTrkkekkaTr.getZtrkinyuukikancd8keta());

                if (!BizUtil.isBlank(skKouhuriUkTrkkekkaTr.getZtrkinyuukkntratkiymd()) ) {
                    skKouhuriUkTrkMihanei.setKinyuukkntratkiymd(
                        BizDate.valueOf(skKouhuriUkTrkkekkaTr.getZtrkinyuukkntratkiymd()));
                }
                skKouhuriUkTrkMihanei.setKinyuukkntratkitime(skKouhuriUkTrkkekkaTr.getZtrkinyuukkntratkitime());
                skKouhuriUkTrkMihanei.setKinyuukkntratkino(skKouhuriUkTrkkekkaTr.getZtrkinyuukkntratkino());
                skKouhuriUkTrkMihanei.setKouhuriukchannelkbn(skKouhuriUkTrkkekkaTr.getZtrkouhuriukchannelkbn());
                skKouhuriUkTrkMihanei.setKouhuriokyakusamano(skKouhuriUkTrkkekkaTr.getZtrkouhuriokyakusamano());
                skKouhuriUkTrkMihanei.setNykmosno(nyknMosno);
                skKouhuriUkTrkMihanei.setSyorizumiflg(C_Syorizumiflg.MISYORI);
                skKouhuriUkTrkMihanei.setBankcd(skKouhuriUkTrkkekkaTr.getZtrkouhuribankcd());
                skKouhuriUkTrkMihanei.setSitencd5keta(skKouhuriUkTrkkekkaTr.getZtrkouhurisitencd5keta());
                skKouhuriUkTrkMihanei.setYokinkbn(C_YokinKbn.valueOf(skKouhuriUkTrkkekkaTr.getZtrkzhurikaeyokinkbn()));
                skKouhuriUkTrkMihanei.setKouzano8keta(skKouhuriUkTrkkekkaTr.getZtrkzhurikaekouzano8keta());
                skKouhuriUkTrkMihanei.setKzmeiginmkn(skKouhuriUkTrkkekkaTr.getZtrkzmeiginmei());
                skKouhuriUkTrkMihanei.setItakusyacd(skKouhuriUkTrkkekkaTr.getZtritakusyacd());

                if (!BizUtil.isBlank(skKouhuriUkTrkkekkaTr.getZtrsyukkntratkiymd()) ) {
                    skKouhuriUkTrkMihanei.setSyukkntratkiymd(
                        BizDate.valueOf(skKouhuriUkTrkkekkaTr.getZtrsyukkntratkiymd()));
                }
                skKouhuriUkTrkMihanei.setSyukkntratkitime(skKouhuriUkTrkkekkaTr.getZtrsyukkntratkitime());
                skKouhuriUkTrkMihanei.setSyukkntratkino(skKouhuriUkTrkkekkaTr.getZtrsyukkntratkino());
                skKouhuriUkTrkMihanei.setKouhuristatuskbn(
                    C_KouhuristatusKbn.valueOf(skKouhuriUkTrkkekkaTr.getZtrkouhuristatuskbn()));
                skKouhuriUkTrkMihanei.setKouhurikekkacd(skKouhuriUkTrkkekkaTr.getZtrkouhurikekkacd());
                skKouhuriUkTrkMihanei.setKouhurihonninkakkekka(skKouhuriUkTrkkekkaTr.getZtrkouhurihonninkakkekka());
                skKouhuriUkTrkMihanei.setGyoumuKousinKinou(kinou.getKinouId());
                skKouhuriUkTrkMihanei.setGyoumuKousinsyaId(baseUserInfo.getUserId());
                skKouhuriUkTrkMihanei.setGyoumuKousinTime(BizDate.getSysDateTimeMilli());

                BizPropertyInitializer.initialize(skKouhuriUkTrkMihanei);

                skKouhuriUkTrkMihaneiInserter.add(skKouhuriUkTrkMihanei);
            }

            bzRecoveryDatasikibetuBean.initializeBlank();

            batchLogger.info(MessageUtil.getMessage(
                MessageId.IBF0002, String.valueOf(syoriKensuu), "口振受付登録結果反映前処理"));
        }
    }

    @AppBatchExceptionTerminate
    private void appBatchExceptionTerminate() {

        BzBatchAbendCommonRecovery bzBatchAbendCommonRecovery =
            SWAKInjector.getInstance(BzBatchAbendCommonRecovery.class);

        bzBatchAbendCommonRecovery.exec();
    }
}