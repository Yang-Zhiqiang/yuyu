package yuyu.batch.hozen.khansyuu.khkariukekinseibitokusoku;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.batch.annotation.AppBatchExceptionTerminate;
import jp.co.slcs.swak.batch.annotation.Execute;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.CHolidayAdjustingMode;
import jp.co.slcs.swak.db.EntityInserter;
import jp.co.slcs.swak.db.ExDBResults;
import jp.co.slcs.swak.util.message.MessageUtil;
import yuyu.batch.hozen.khansyuu.khkariukekinseibitokusoku.dba.KariukeTokusokuTaisyouBean;
import yuyu.batch.hozen.khansyuu.khkariukekinseibitokusoku.dba.KhKariukekinSeibiTokusokuDao;
import yuyu.common.biz.bzcommon.BizDateUtil;
import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.common.biz.bzcommon.BzBatchAbendCommonRecovery;
import yuyu.common.biz.bzcommon.BzBatchParam;
import yuyu.common.biz.exception.CommonBizAppException;
import yuyu.common.hozen.khcommon.HanteiTetuduki;
import yuyu.common.hozen.khcommon.KhozenCommonParam;
import yuyu.def.MessageId;
import yuyu.def.biz.bean.param.BzRecoveryDatasikibetuBean;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_Hrkkeiro;
import yuyu.def.classification.C_KrkriyuuKbn;
import yuyu.def.classification.C_Nykkeiro;
import yuyu.def.classification.C_NyknaiyouKbn;
import yuyu.def.classification.C_SyorikahiKbn;
import yuyu.def.classification.C_TantouCdKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.IT_Kariukekin;
import yuyu.def.db.entity.IT_KrkknSeibiTokusokuInfo;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.IT_KykSya;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.BatchParam;
import yuyu.infr.batch.logger.BatchLogger;

/**
 * 契約保全 案内収納 仮受金整備督促機能のバッチクラスです。
 */
public class KhKariukekinSeibiTokusokuBatch implements Batch {

    private static final String TABLEID = IT_Kariukekin.TABLE_NAME;

    private static final String RECOVERYFILTERID = "Kh001";

    @Inject
    private BatchLogger batchLogger;

    @Inject
    private BzBatchParam bzBatchParam;

    @Inject
    private KhKariukekinSeibiTokusokuDao khKariukekinSeibiTokusokuDao;

    @Inject
    private BzRecoveryDatasikibetuBean bzRecoveryDatasikibetuBean;

    @Inject
    private BizDomManager bizDomManager;

    @Override
    public BatchParam getParam() {
        return bzBatchParam;
    }

    @Execute
    @Transactional
    public void execute() {

        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        String kinouid = khozenCommonParam.getFunctionId();
        String userId = khozenCommonParam.getUserID();
        BizDate syoriYmd = bzBatchParam.getSyoriYmd();
        BizDate kijyunYmd = syoriYmd.addBusinessDays(-10);
        Long syoriKensuu = 0L;
        String ibKakutyoujobcd = bzBatchParam.getIbKakutyoujobcd();
        String sysDateTime = BizDate.getSysDateTimeMilli();

        batchLogger.info(MessageUtil.getMessage(MessageId.IBA0016, MessageUtil.getMessage(MessageId.IBW0003),
            syoriYmd.toString()));
        batchLogger.info(MessageUtil.getMessage(MessageId.IBA0016, MessageUtil.getMessage(MessageId.IBW1018),
            ibKakutyoujobcd));

        khKariukekinSeibiTokusokuDao.deleteKrkknSeibiTokusokuInfo();

        try (
            ExDBResults<KariukeTokusokuTaisyouBean> kariukeTokusokuTaisyouBeanLst =
            khKariukekinSeibiTokusokuDao.getKariukeTokusokuTaisyouBean(ibKakutyoujobcd, kijyunYmd);
            EntityInserter<IT_KrkknSeibiTokusokuInfo> entityInserter = new EntityInserter<>();) {

            HanteiTetuduki hanteiTetuduki = SWAKInjector.getInstance(HanteiTetuduki.class);

            for (KariukeTokusokuTaisyouBean dataBean : kariukeTokusokuTaisyouBeanLst) {

                String syono = dataBean.getSyono();

                bzRecoveryDatasikibetuBean.setIbKakutyoujobcd(ibKakutyoujobcd);
                bzRecoveryDatasikibetuBean.setIbTableid(TABLEID);
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterid(RECOVERYFILTERID);
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterkey1(dataBean.getKbnkey());
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterkey2(syono);

                IT_KykKihon kykKihon = khKariukekinSeibiTokusokuDao.getKykKihon(syono);
                if (kykKihon == null) {
                    throw new CommonBizAppException("契約基本TBLにデータが存在しません。");
                }

                IT_KykSya kykSya = khKariukekinSeibiTokusokuDao.getKykSya(kykKihon);
                if (kykSya == null) {
                    throw new CommonBizAppException("契約者TBLにデータが存在しません。");
                }

                C_SyorikahiKbn syorikahiKbn = hanteiTetuduki.exec(khozenCommonParam, syono);
                if (C_SyorikahiKbn.SYORIHUKA.eq(syorikahiKbn)) {
                    kykKihon.detach();
                    continue;
                }

                BizDate tyoukimiseibikrkHanteikijyunymd = dataBean.getKrkkeijyoymd().addMonths(1);

                if (!tyoukimiseibikrkHanteikijyunymd.isRekijyou()) {
                    tyoukimiseibikrkHanteikijyunymd = tyoukimiseibikrkHanteikijyunymd.getRekijyou();
                }

                if (!tyoukimiseibikrkHanteikijyunymd.isBusinessDay()){
                    tyoukimiseibikrkHanteikijyunymd =
                        tyoukimiseibikrkHanteikijyunymd.getBusinessDay(CHolidayAdjustingMode.NEXT);
                }

                C_UmuKbn tyoukimiseibikrkUmu = C_UmuKbn.NONE;

                if (BizDateUtil.compareYmd(tyoukimiseibikrkHanteikijyunymd, syoriYmd) == BizDateUtil.COMPARE_LESSER
                    || BizDateUtil.compareYmd(tyoukimiseibikrkHanteikijyunymd, syoriYmd) == BizDateUtil.COMPARE_EQUAL) {
                    tyoukimiseibikrkUmu = C_UmuKbn.ARI;
                }

                C_TantouCdKbn tantouCdKbn = C_TantouCdKbn.BLNK0;

                if (C_Nykkeiro.KZHRK.eq(dataBean.getNykkeiro())) {
                    tantouCdKbn = C_TantouCdKbn.YOHURI;
                }
                else if (C_Nykkeiro.CREDIT.eq(dataBean.getNykkeiro())) {
                    tantouCdKbn = C_TantouCdKbn.SYUUDANTEIKI;
                }
                else if (C_Nykkeiro.BANK.eq(dataBean.getNykkeiro())) {
                    if (C_NyknaiyouKbn.HOZENHENKOUYOUP.eq(dataBean.getNyknaiyoukbn())) {
                        if (C_KrkriyuuKbn.HENKOUMATI.eq(dataBean.getKrkriyuukbn())) {
                            tantouCdKbn = C_TantouCdKbn.KEIYAKUHENKOU;
                        }
                        else {
                            tantouCdKbn = C_TantouCdKbn.KEIYAKUHENKOU;
                        }
                    }
                    else if (C_Hrkkeiro.KOUHURI.eq(kykKihon.getHrkkeiro())) {
                        tantouCdKbn = C_TantouCdKbn.YOHURI;
                    }
                    else if (C_Hrkkeiro.CREDIT.eq(kykKihon.getHrkkeiro())) {
                        tantouCdKbn = C_TantouCdKbn.SYUUDANTEIKI;
                    }
                    else if (C_Hrkkeiro.HURIKAE.eq(kykKihon.getHrkkeiro())) {
                        tantouCdKbn = C_TantouCdKbn.HURIKAE;
                    }
                }
                else {
                    if (C_Hrkkeiro.KOUHURI.eq(kykKihon.getHrkkeiro())) {
                        tantouCdKbn = C_TantouCdKbn.YOHURI;
                    }
                    else if (C_Hrkkeiro.CREDIT.eq(kykKihon.getHrkkeiro())) {
                        tantouCdKbn = C_TantouCdKbn.SYUUDANTEIKI;
                    }
                    else if (C_Hrkkeiro.HURIKAE.eq(kykKihon.getHrkkeiro())) {
                        tantouCdKbn = C_TantouCdKbn.HURIKAE;
                    }
                }

                String atesakibusituCd = bizDomManager.getTantouCd(tantouCdKbn).getBusitucd();

                String atesakisosikiCd = atesakibusituCd.concat("0000");

                C_UmuKbn hukusuukrkUmu = C_UmuKbn.NONE;

                Long kenSuu = khKariukekinSeibiTokusokuDao.getKariukekinCount(syono);

                if (kenSuu > 1) {
                    hukusuukrkUmu = C_UmuKbn.ARI;
                }

                IT_KrkknSeibiTokusokuInfo krkknSeibiTokusokuInfo = new IT_KrkknSeibiTokusokuInfo();

                krkknSeibiTokusokuInfo.setSyono(syono);
                krkknSeibiTokusokuInfo.setKrkno(dataBean.getKrkno());
                krkknSeibiTokusokuInfo.setAtesakisosikicd(atesakisosikiCd);
                krkknSeibiTokusokuInfo.setAtesakibusitucd(atesakibusituCd);
                krkknSeibiTokusokuInfo.setTantocd(tantouCdKbn);
                krkknSeibiTokusokuInfo.setKyknmkj(kykSya.getKyknmkj());
                krkknSeibiTokusokuInfo.setTyoukimiseibikrkumu(tyoukimiseibikrkUmu);
                krkknSeibiTokusokuInfo.setHukusuukrkumu(hukusuukrkUmu);
                krkknSeibiTokusokuInfo.setKrkkeijyoymd(dataBean.getKrkkeijyoymd());
                krkknSeibiTokusokuInfo.setKrkgk(dataBean.getKrkgk());
                krkknSeibiTokusokuInfo.setKrkriyuukbn(dataBean.getKrkriyuukbn());
                krkknSeibiTokusokuInfo.setNyknaiyoukbn(dataBean.getNyknaiyoukbn());
                krkknSeibiTokusokuInfo.setNykkeiro(dataBean.getNykkeiro());
                krkknSeibiTokusokuInfo.setJyuutouym(dataBean.getJyuutouym());
                krkknSeibiTokusokuInfo.setJyutoukaisuuy(dataBean.getJyutoukaisuuy());
                krkknSeibiTokusokuInfo.setJyutoukaisuum(dataBean.getJyutoukaisuum());
                krkknSeibiTokusokuInfo.setRyosyuymd(dataBean.getRyosyuymd());
                krkknSeibiTokusokuInfo.setKrkjhrkkaisuu(dataBean.getHrkkaisuu());
                krkknSeibiTokusokuInfo.setGyoumuKousinKinou(kinouid);
                krkknSeibiTokusokuInfo.setGyoumuKousinsyaId(userId);
                krkknSeibiTokusokuInfo.setGyoumuKousinTime(sysDateTime);

                BizPropertyInitializer.initialize(krkknSeibiTokusokuInfo);

                entityInserter.add(krkknSeibiTokusokuInfo);

                syoriKensuu = syoriKensuu + 1;

                kykKihon.detach();
            }
            bzRecoveryDatasikibetuBean.initializeBlank();
        }
        batchLogger.info(MessageUtil.getMessage(MessageId.IBF0001, String.valueOf(syoriKensuu)));
    }

    @AppBatchExceptionTerminate
    private void appBatchExceptionTerminate() {

        BzBatchAbendCommonRecovery bzBatchAbendCommonRecovery = SWAKInjector.
            getInstance(BzBatchAbendCommonRecovery.class);

        bzBatchAbendCommonRecovery.exec();
    }
}
