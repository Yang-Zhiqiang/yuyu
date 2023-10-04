package yuyu.batch.direct.dsmailhaisinkanri.dsmailhaisinyoyakuhantei;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.batch.annotation.AppBatchExceptionTerminate;
import jp.co.slcs.swak.batch.annotation.Execute;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.ExDBResults;
import jp.co.slcs.swak.db.MultipleEntityInserter;
import jp.co.slcs.swak.util.message.MessageUtil;
import yuyu.batch.direct.dsmailhaisinkanri.dsmailhaisinyoyakuhantei.dba.DsMailHaisinYoyakuBean;
import yuyu.batch.direct.dsmailhaisinkanri.dsmailhaisinyoyakuhantei.dba.DsMailHaisinYoyakuHanteiDao;
import yuyu.batch.direct.dsmailhaisinkanri.dsmailhaisinyoyakuhantei.dba.DsYuukouMailAddressBean;
import yuyu.common.base.BaseUserInfo;
import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.common.biz.bzcommon.BzBatchAbendCommonRecovery;
import yuyu.common.biz.bzcommon.BzBatchParam;
import yuyu.common.biz.exception.CommonBizAppException;
import yuyu.common.direct.dscommon.DsKokyakuYuukouKeiyakuHantei;
import yuyu.common.direct.dscommon.DsKokyakuYuukouKeiyakuHanteiBean;
import yuyu.def.MessageId;
import yuyu.def.biz.bean.param.BzRecoveryDatasikibetuBean;
import yuyu.def.classification.C_DsHaisinYoyakuStatusKbn;
import yuyu.def.classification.C_DsSousinMailSyubetuKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.AS_Kinou;
import yuyu.def.db.entity.MT_DsMailAddress;
import yuyu.def.db.entity.MT_DsMailHaisin;
import yuyu.def.db.entity.MT_DsMailHaisinRireki;
import yuyu.def.db.entity.MT_DsMailHaisinYoyaku;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.BatchParam;
import yuyu.infr.batch.logger.BatchLogger;

import com.google.common.base.Strings;

/**
 * ダイレクトサービス ＤＳメール配信管理 ＤＳメール配信予約判定<br />
 *
 * ＤＳメール配信予約判定バッチクラス。<br />
 * ※対象データの件数は1000件以上となる可能性があり、大量データを扱う。<br />
 *
 */
public class DsMailHaisinYoyakuHanteiBatch implements Batch {

    private static final String TABLE_ID  = MT_DsMailAddress.TABLE_NAME;

    private static final String FILTER_ID = "Ds003";

    private static final String BLNK = "";

    private static final String MAILHAISINYOYAKU = "メール配信予約件数";

    private static final String MAILHAISINTAISYOU = "メール配信対象件数";

    private static final String MAILHAISINTYOYAKU = "メール配信予約";

    private static final int DSMAILHAISINRENNO_DEFAULT = 200000001;

    @Inject
    private BatchLogger batchLogger;

    @Inject
    private BzBatchParam bzBatchParam;

    @Inject
    private BzRecoveryDatasikibetuBean bzRecoveryDatasikibetuBean;

    @Inject
    private DsMailHaisinYoyakuHanteiDao dsMailHaisinYoyakuHanteiDao;

    @Inject
    private AS_Kinou kinou;

    @Inject
    private BaseUserInfo baseUserInfo;

    @Override
    public BatchParam getParam() {
        return bzBatchParam;
    }

    @Execute
    @Transactional
    public void execute() {

        BizDate syoriYmd = bzBatchParam.getSyoriYmd();

        String kakutyouJobCd = bzBatchParam.getIbKakutyoujobcd();

        String gyoumuKousinKinouId = kinou.getKinouId();

        String gyoumuKousinsyaId = baseUserInfo.getUserId();

        String gyoumuKousinTime = BizDate.getSysDateTimeMilli();

        int syoriKensuu = 0;

        BizDate haisinYmd = syoriYmd.addDays(1);

        DsKokyakuYuukouKeiyakuHantei dsKokyakuYuukouKeiyakuHantei = SWAKInjector.getInstance(DsKokyakuYuukouKeiyakuHantei.class);

        batchLogger.info(
            MessageUtil.getMessage(MessageId.IBA0016, MessageUtil.getMessage(MessageId.IBW0003), syoriYmd.toString()));

        dsMailHaisinYoyakuHanteiDao.deleteDsMailHaisinByHaisinYmd(haisinYmd);

        List<DsMailHaisinYoyakuBean>dsMailHaisinYoyakuBeanList =
            dsMailHaisinYoyakuHanteiDao.getDsMailHaisinYoyakuByHaisinYoteiYmd(haisinYmd);

        int haisinYoyakuKensuu = dsMailHaisinYoyakuBeanList.size();

        if (haisinYoyakuKensuu == 0) {

        }
        else if (haisinYoyakuKensuu > 1) {

            batchLogger.info(
                MessageUtil.getMessage(MessageId.IBF0002, String.valueOf(haisinYoyakuKensuu), MAILHAISINYOYAKU));

            batchLogger.info(
                MessageUtil.getMessage(MessageId.IBF0002, String.valueOf(syoriKensuu), MAILHAISINTAISYOU));

            throw new CommonBizAppException(MessageUtil.getMessage(MessageId.EJA0049, MAILHAISINTYOYAKU));
        }
        else if (haisinYoyakuKensuu == 1) {
            if (C_DsHaisinYoyakuStatusKbn.SYOUNIN_MATI.eq(dsMailHaisinYoyakuBeanList.get(0).getDshaisinyoyakustatuskbn())) {

                C_DsHaisinYoyakuStatusKbn dsHaisinYoyakuStatusKbn = C_DsHaisinYoyakuStatusKbn.KIGENGIRE;

                String dsmailhaisinyoyakuskbtkey = dsMailHaisinYoyakuBeanList.get(0).getDsmailhaisinyoyakuskbtkey();

                MT_DsMailHaisinYoyaku dsMailHaisinYoyaku =
                    dsMailHaisinYoyakuHanteiDao.getDsMailHaisinYoyakuByDsmailhaisinyoyakuskbtkey(dsmailhaisinyoyakuskbtkey);

                dsMailHaisinYoyaku.setDshaisinyoyakustatuskbn(dsHaisinYoyakuStatusKbn);
                dsMailHaisinYoyaku.setGyoumuKousinKinou(gyoumuKousinKinouId);
                dsMailHaisinYoyaku.setGyoumuKousinsyaId(gyoumuKousinsyaId);
                dsMailHaisinYoyaku.setGyoumuKousinTime(gyoumuKousinTime);
            }
            if (C_DsHaisinYoyakuStatusKbn.SYOUNIN_SUMI.eq(dsMailHaisinYoyakuBeanList.get(0).getDshaisinyoyakustatuskbn())) {

                try (
                    ExDBResults<DsYuukouMailAddressBean> dsYuukouMailAddressBeanList =
                    dsMailHaisinYoyakuHanteiDao.getDsMailAddressByKakutyouJobCd(kakutyouJobCd);

                    MultipleEntityInserter multipleEntityInserter = new MultipleEntityInserter();) {

                    BizDate dsDataSakuseiYmd = syoriYmd.addDays(1);

                    C_DsSousinMailSyubetuKbn dsSousinMailSyubetuKbn =
                        dsMailHaisinYoyakuBeanList.get(0).getDssousinmailsyubetukbn();

                    Integer maxDsMailHaisinRenNo =
                        dsMailHaisinYoyakuHanteiDao.getDsMailHaisinRirekiMaxDsMailHaisinRenNo(dsDataSakuseiYmd,dsSousinMailSyubetuKbn);

                    if (maxDsMailHaisinRenNo == null || maxDsMailHaisinRenNo < DSMAILHAISINRENNO_DEFAULT) {

                        maxDsMailHaisinRenNo = DSMAILHAISINRENNO_DEFAULT;
                    }
                    else {
                        maxDsMailHaisinRenNo++;
                    }

                    String dsSousinNoSystemYmd =
                        gyoumuKousinTime.substring(2, 8) + "T" + gyoumuKousinTime.substring(8, 12) + "NB";

                    int dsSousinNoRenNo = 1;

                    BizDate sousinYmd = syoriYmd.addDays(1);

                    for (DsYuukouMailAddressBean dsYuukouMailAddressBean : dsYuukouMailAddressBeanList) {

                        String dsKokNo = dsYuukouMailAddressBean.getDskokno();

                        int dsMailAddressRenban = dsYuukouMailAddressBean.getDsmailaddressrenban();

                        bzRecoveryDatasikibetuBean.setIbKakutyoujobcd(kakutyouJobCd);
                        bzRecoveryDatasikibetuBean.setIbTableid(TABLE_ID);
                        bzRecoveryDatasikibetuBean.setIbRecoveryfilterid(FILTER_ID);
                        bzRecoveryDatasikibetuBean.setIbRecoveryfilterkey1(dsKokNo);
                        bzRecoveryDatasikibetuBean.setIbRecoveryfilterkey2(String.valueOf(dsMailAddressRenban));

                        DsKokyakuYuukouKeiyakuHanteiBean dsKokyakuYuukouKeiyakuHanteiBean = dsKokyakuYuukouKeiyakuHantei.exec(dsKokNo);

                        if(C_UmuKbn.NONE.eq(dsKokyakuYuukouKeiyakuHanteiBean.getYuukouKeiyakuUmuKbn())){
                            continue;
                        }

                        String dsSousinNo =
                            dsSousinNoSystemYmd + Strings.padStart(String.valueOf(dsSousinNoRenNo), 8, '0');

                        MT_DsMailHaisin dsMailHaisin = new MT_DsMailHaisin();

                        String dsKokMailAddressSkbtKey =
                            dsKokNo + Strings.padStart(String.valueOf(dsMailAddressRenban), 9, '0');

                        String dsMailAddress = dsYuukouMailAddressBean.getDsmailaddress();

                        dsMailHaisin.setSousinymd(sousinYmd);
                        dsMailHaisin.setDskokmailaddressskbtkey(dsKokMailAddressSkbtKey);
                        dsMailHaisin.setDssousinmailsyubetukbn(dsSousinMailSyubetuKbn);
                        dsMailHaisin.setDssousinno(dsSousinNo);
                        dsMailHaisin.setSyono(BLNK);
                        dsMailHaisin.setDsmailaddress(dsMailAddress);
                        dsMailHaisin.setSasikomikoumokusyou01(BLNK);
                        dsMailHaisin.setSasikomikoumokusyou02(BLNK);
                        dsMailHaisin.setSasikomikoumokusyou03(BLNK);
                        dsMailHaisin.setSasikomikoumokusyou04(BLNK);
                        dsMailHaisin.setSasikomikoumokusyou05(BLNK);
                        dsMailHaisin.setSasikomikoumokusyou06(BLNK);
                        dsMailHaisin.setSasikomikoumokusyou07(BLNK);
                        dsMailHaisin.setSasikomikoumokusyou08(BLNK);
                        dsMailHaisin.setSasikomikoumokusyou09(BLNK);
                        dsMailHaisin.setSasikomikoumokusyou10(BLNK);
                        dsMailHaisin.setSasikomikoumokusyou11(BLNK);
                        dsMailHaisin.setSasikomikoumokusyou12(BLNK);
                        dsMailHaisin.setSasikomikoumokusyou13(BLNK);
                        dsMailHaisin.setSasikomikoumokusyou14(BLNK);
                        dsMailHaisin.setSasikomikoumokusyou15(BLNK);
                        dsMailHaisin.setSasikomikoumokusyou16(BLNK);
                        dsMailHaisin.setSasikomikoumokusyou17(BLNK);
                        dsMailHaisin.setSasikomikoumokusyou18(BLNK);
                        dsMailHaisin.setSasikomikoumokusyou19(BLNK);
                        dsMailHaisin.setSasikomikoumokusyou20(BLNK);
                        dsMailHaisin.setSasikomikoumokusyou21(BLNK);
                        dsMailHaisin.setSasikomikoumokusyou22(BLNK);
                        dsMailHaisin.setSasikomikoumokusyou23(BLNK);
                        dsMailHaisin.setSasikomikoumokusyou24(BLNK);
                        dsMailHaisin.setSasikomikoumokusyou25(BLNK);
                        dsMailHaisin.setSasikomikoumokusyou26(BLNK);
                        dsMailHaisin.setSasikomikoumokusyou27(BLNK);
                        dsMailHaisin.setSasikomikoumokusyou28(BLNK);
                        dsMailHaisin.setSasikomikoumokusyou29(BLNK);
                        dsMailHaisin.setSasikomikoumokusyou30(BLNK);
                        dsMailHaisin.setSasikomikoumokutyuu01(BLNK);
                        dsMailHaisin.setSasikomikoumokutyuu02(BLNK);
                        dsMailHaisin.setSasikomikoumokutyuu03(BLNK);
                        dsMailHaisin.setSasikomikoumokutyuu04(BLNK);
                        dsMailHaisin.setSasikomikoumokutyuu05(BLNK);
                        dsMailHaisin.setSasikomikoumokutyuu06(BLNK);
                        dsMailHaisin.setSasikomikoumokutyuu07(BLNK);
                        dsMailHaisin.setSasikomikoumokutyuu08(BLNK);
                        dsMailHaisin.setSasikomikoumokutyuu09(BLNK);
                        dsMailHaisin.setSasikomikoumokutyuu10(BLNK);
                        dsMailHaisin.setSasikomikoumokutyuu11(BLNK);
                        dsMailHaisin.setSasikomikoumokutyuu12(BLNK);
                        dsMailHaisin.setSasikomikoumokutyuu13(BLNK);
                        dsMailHaisin.setSasikomikoumokutyuu14(BLNK);
                        dsMailHaisin.setSasikomikoumokutyuu15(BLNK);
                        dsMailHaisin.setSasikomikoumokutyuu16(BLNK);
                        dsMailHaisin.setSasikomikoumokutyuu17(BLNK);
                        dsMailHaisin.setSasikomikoumokutyuu18(BLNK);
                        dsMailHaisin.setSasikomikoumokutyuu19(BLNK);
                        dsMailHaisin.setSasikomikoumokutyuu20(BLNK);
                        dsMailHaisin.setSasikomikoumokudai01(BLNK);
                        dsMailHaisin.setSasikomikoumokudai02(BLNK);
                        dsMailHaisin.setSasikomikoumokudai03(BLNK);
                        dsMailHaisin.setSasikomikoumokudai04(BLNK);
                        dsMailHaisin.setSasikomikoumokudai05(BLNK);
                        dsMailHaisin.setSasikomikoumokudai06(BLNK);
                        dsMailHaisin.setSasikomikoumokudai07(BLNK);
                        dsMailHaisin.setSasikomikoumokudai08(BLNK);
                        dsMailHaisin.setSasikomikoumokudai09(BLNK);
                        dsMailHaisin.setSasikomikoumokudai10(BLNK);

                        BizPropertyInitializer.initialize(dsMailHaisin);

                        multipleEntityInserter.add(dsMailHaisin);

                        MT_DsMailHaisinRireki dsMailHaisinRireki = new MT_DsMailHaisinRireki();

                        dsMailHaisinRireki.setDsdatasakuseiymd(dsDataSakuseiYmd);
                        dsMailHaisinRireki.setDskokno(dsKokNo);
                        dsMailHaisinRireki.setDsmailhaisinrenban(maxDsMailHaisinRenNo);
                        dsMailHaisinRireki.setHaisinjidsmailaddress(dsMailAddress);
                        dsMailHaisinRireki.setDssousinno(dsSousinNo);
                        dsMailHaisinRireki.setGyoumuKousinKinou(gyoumuKousinKinouId);
                        dsMailHaisinRireki.setGyoumuKousinsyaId(gyoumuKousinsyaId );
                        dsMailHaisinRireki.setGyoumuKousinTime(gyoumuKousinTime );
                        dsMailHaisinRireki.setDssousinmailsyubetukbn(dsSousinMailSyubetuKbn);
                        dsMailHaisinRireki.setSyono(BLNK);

                        BizPropertyInitializer.initialize(dsMailHaisinRireki);

                        multipleEntityInserter.add(dsMailHaisinRireki);

                        maxDsMailHaisinRenNo++;

                        dsSousinNoRenNo++;

                        syoriKensuu++;
                    }
                    bzRecoveryDatasikibetuBean.initializeBlank();

                    C_DsHaisinYoyakuStatusKbn dsHaisinYoyakuStatusKbn = C_DsHaisinYoyakuStatusKbn.RENKEI_SUMI;

                    String dsmailhaisinyoyakuskbtkey = dsMailHaisinYoyakuBeanList.get(0).getDsmailhaisinyoyakuskbtkey();

                    MT_DsMailHaisinYoyaku dsMailHaisinYoyaku =
                        dsMailHaisinYoyakuHanteiDao.getDsMailHaisinYoyakuByDsmailhaisinyoyakuskbtkey(dsmailhaisinyoyakuskbtkey);

                    dsMailHaisinYoyaku.setDshaisinyoyakustatuskbn(dsHaisinYoyakuStatusKbn);
                    dsMailHaisinYoyaku.setGyoumuKousinKinou(gyoumuKousinKinouId);
                    dsMailHaisinYoyaku.setGyoumuKousinsyaId(gyoumuKousinsyaId);
                    dsMailHaisinYoyaku.setGyoumuKousinTime(gyoumuKousinTime);
                }
            }
        }
        batchLogger.info(MessageUtil.getMessage(MessageId.IBF0002, String.valueOf(haisinYoyakuKensuu), MAILHAISINYOYAKU));

        batchLogger.info(MessageUtil.getMessage(MessageId.IBF0002, String.valueOf(syoriKensuu), MAILHAISINTAISYOU));
    }

    @AppBatchExceptionTerminate
    private void appBatchExceptionTerminate() {

        BzBatchAbendCommonRecovery bzBatchAbendCommonRecovery =
            SWAKInjector.getInstance(BzBatchAbendCommonRecovery.class);

        bzBatchAbendCommonRecovery.exec();
    }
}
