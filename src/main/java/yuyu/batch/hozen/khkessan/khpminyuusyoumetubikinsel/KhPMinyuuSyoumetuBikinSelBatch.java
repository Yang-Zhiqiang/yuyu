package yuyu.batch.hozen.khkessan.khpminyuusyoumetubikinsel;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.batch.annotation.AppBatchExceptionTerminate;
import jp.co.slcs.swak.batch.annotation.Execute;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateMD;
import jp.co.slcs.swak.date.BizDateY;
import jp.co.slcs.swak.date.CHolidayAdjustingMode;
import jp.co.slcs.swak.db.EntityInserter;
import jp.co.slcs.swak.db.ExDBResults;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.util.message.MessageUtil;
import yuyu.batch.hozen.khkessan.khpminyuusyoumetubikinsel.dba.KhPMinyuuSyoumetuBikinSelDao;
import yuyu.batch.hozen.khkessan.khpminyuusyoumetubikinsel.dba.PMinyuuSyoumetuInfosByKakutyoujobcdKsnbiymdBean;
import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.common.biz.bzcommon.BzBatchAbendCommonRecovery;
import yuyu.common.biz.kaikei.BzSegmentCdSyutoku;
import yuyu.common.biz.kaikei.SyouhinbetuSegmentBean;
import yuyu.common.hozen.khcommon.KhozenCommonParam;
import yuyu.common.hozen.khcommon.SetKessanNensibi;
import yuyu.def.MessageId;
import yuyu.def.biz.bean.param.BzRecoveryDatasikibetuBean;
import yuyu.def.classification.C_BknJkuKbn;
import yuyu.def.classification.C_BkncdKbn;
import yuyu.def.classification.C_Segcd;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.IT_AsBikinkanri;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.IT_KykSyouhn;
import yuyu.def.db.entity.IT_PMinyuuSyoumetuInfo;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.BatchParam;
import yuyu.infr.batch.logger.BatchLogger;

/**
 * 契約保全 決算 Ｐ未入消滅備金抽出
 */
public class KhPMinyuuSyoumetuBikinSelBatch implements Batch {

    private static final String TYSYTTAISYOU_TABLE_ID = IT_KykKihon.TABLE_NAME;

    private static final String RECOVERY_FILTER_KBNID = "Kh001";

    @Inject
    private BatchLogger batchLogger;

    @Inject
    private KhPMinyuuSyoumetuBikinSelBatchParam khPMinyuuSyoumetuBikinSelBatchParam;

    @Inject
    private KhPMinyuuSyoumetuBikinSelDao khPMinyuuSyoumetuBikinSelDao;

    @Inject
    private HozenDomManager hozenDomManager;

    @Inject
    private BzRecoveryDatasikibetuBean bzRecoveryDatasikibetuBean;

    @Override
    public BatchParam getParam() {

        return khPMinyuuSyoumetuBikinSelBatchParam;
    }

    @Execute
    @Transactional
    public void execute() {

        BizDate syoriYmd = khPMinyuuSyoumetuBikinSelBatchParam.getSyoriYmd();
        BizDate kessanYmd = khPMinyuuSyoumetuBikinSelBatchParam.getKessanYmd();
        String kakutyoujobCd = khPMinyuuSyoumetuBikinSelBatchParam.getIbKakutyoujobcd();
        long asBikinkanriInfoOutKensuu = 0;
        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        SetKessanNensibi setKessanNensibi = SWAKInjector.getInstance(SetKessanNensibi.class);

        batchLogger.info(MessageUtil.getMessage(MessageId.IBA0016, MessageUtil.getMessage(MessageId.IBW0003),
            String.valueOf(syoriYmd)));
        batchLogger.info(MessageUtil.getMessage(MessageId.IBA0016, MessageUtil.getMessage(MessageId.IBW1020),
            String.valueOf(kessanYmd)));
        batchLogger.info(MessageUtil.getMessage(MessageId.IBA0016, MessageUtil.getMessage(MessageId.IBW1018),
            kakutyoujobCd));

        List<IT_AsBikinkanri> asBikinkanriLst = khPMinyuuSyoumetuBikinSelDao
            .getAsBikinkanrisByKessankijyunymdBkncdkbn(kessanYmd);

        hozenDomManager.delete(asBikinkanriLst);
        hozenDomManager.flush();

        try (ExDBResults<PMinyuuSyoumetuInfosByKakutyoujobcdKsnbiymdBean> beanLst = khPMinyuuSyoumetuBikinSelDao
            .getPMinyuuSyoumetuInfosByKakutyoujobcdKsnbiymd(kakutyoujobCd, kessanYmd);
            EntityInserter<IT_AsBikinkanri> asBikinkanriInserter = new EntityInserter<>();) {

            for (PMinyuuSyoumetuInfosByKakutyoujobcdKsnbiymdBean dataBean : beanLst) {

                IT_KykKihon kykKihon = dataBean.getKykKihon();
                IT_KykSyouhn kykSyouhn = dataBean.getKykSyouhn();
                IT_PMinyuuSyoumetuInfo pMinyuuSyoumetuInfo = dataBean.getPMinyuuSyoumetuInfo();
                String syono = kykSyouhn.getSyono();
                BizDate syoumetuymd = kykSyouhn.getSyoumetuymd();
                String syouhncd = kykSyouhn.getSyouhncd();
                C_Tuukasyu kyktuukasyu = kykSyouhn.getKyktuukasyu();
                BizCurrency kaiyakuhr = pMinyuuSyoumetuInfo.getKaiyakuhrknsiteituuka();
                BizCurrency kaiyakuhrYen = pMinyuuSyoumetuInfo.getKaiyakuhryen();
                BizNumber kawaserate = pMinyuuSyoumetuInfo.getShrkwsrate();
                BizDate kwsratekjymd = syoumetuymd;

                if (!syoumetuymd.isBusinessDay()) {
                    kwsratekjymd = syoumetuymd.getBusinessDay(CHolidayAdjustingMode.NEXT);
                }

                BzSegmentCdSyutoku bzSegmentCdSyutoku = SWAKInjector.getInstance(BzSegmentCdSyutoku.class);
                SyouhinbetuSegmentBean syouhinbetuSegmentBean = bzSegmentCdSyutoku.exec(syouhncd, kyktuukasyu);
                C_Segcd segCd = syouhinbetuSegmentBean.getSegcd1();

                bzRecoveryDatasikibetuBean.setIbKakutyoujobcd(kakutyoujobCd);
                bzRecoveryDatasikibetuBean.setIbTableid(TYSYTTAISYOU_TABLE_ID);
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterid(RECOVERY_FILTER_KBNID);
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterkey1(kykKihon.getKbnkey());
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterkey2(syono);

                if (kaiyakuhr.compareTo(BizCurrency.valueOf(0, kaiyakuhr.getType())) <= 0) {

                    continue;
                }

                if (C_Tuukasyu.JPY.eq(kyktuukasyu)) {

                    kawaserate = BizNumber.ZERO;
                    kwsratekjymd = null;
                    kaiyakuhr = BizCurrency.valueOf(0, kaiyakuhr.getType());
                }

                C_UmuKbn syoriumuKbn = C_UmuKbn.NONE;

                if (dataBean.getSyoriUmuKbn() != null) {

                    syoriumuKbn = C_UmuKbn.ARI;
                }

                BizDateY firstKessanKijunNendo = null;
                BizDateY kessanKijunNendo = null;
                C_BknJkuKbn bknjkuKbn = C_BknJkuKbn.BLNK;

                IT_AsBikinkanri asBikinkanri = khPMinyuuSyoumetuBikinSelDao.getAsBikinkanriInfosBySyono(syono);

                if (asBikinkanri != null && asBikinkanri.getKessankijyunymd() != null) {

                    firstKessanKijunNendo = setKessanNensibi.exec(asBikinkanri.getKessankijyunymd()).getBizDateY();
                }

                kessanKijunNendo = setKessanNensibi.exec(kessanYmd).getBizDateY();

                if (firstKessanKijunNendo == null) {
                    bknjkuKbn = C_BknJkuKbn.SINBI;
                }
                else {
                    if (kessanKijunNendo.getYear() - firstKessanKijunNendo.getYear() == 0) {
                        bknjkuKbn = C_BknJkuKbn.SINBI;
                    }
                    else if (kessanKijunNendo.getYear() - firstKessanKijunNendo.getYear() == 1) {
                        bknjkuKbn = C_BknJkuKbn.SAIBI;
                    }
                    else if (kessanKijunNendo.getYear() - firstKessanKijunNendo.getYear() == 2) {
                        bknjkuKbn = C_BknJkuKbn.SAISAIBI;
                    }
                    else if (kessanKijunNendo.getYear() - firstKessanKijunNendo.getYear() == 3
                        && kessanYmd.getBizDateMD().compareTo(BizDateMD.valueOf("0331")) != 0) {
                        bknjkuKbn = C_BknJkuKbn.SAISAISAIBI;
                    }
                    else {
                        bknjkuKbn = C_BknJkuKbn.JIKOU;
                    }
                }

                IT_AsBikinkanri asBikinkanriInsert = new IT_AsBikinkanri();

                asBikinkanriInsert.setSyono(syono);
                asBikinkanriInsert.setKessankijyunymd(kessanYmd);
                asBikinkanriInsert.setBkncdkbn(C_BkncdKbn.PMINYUUSYOUMETU);
                asBikinkanriInsert.setBknkktymd(syoumetuymd);
                asBikinkanriInsert.setRenno(1);
                asBikinkanriInsert.setCalckijyunymd(syoumetuymd);
                asBikinkanriInsert.setSisyacd("516");
                asBikinkanriInsert.setKbnkeirisegcd(segCd);
                asBikinkanriInsert.setSyouhncd(syouhncd);
                asBikinkanriInsert.setBkngk(kaiyakuhrYen);
                asBikinkanriInsert.setSyoriumukbn(syoriumuKbn);
                asBikinkanriInsert.setBknjkukbn(bknjkuKbn);
                asBikinkanriInsert.setKaiyakuhrgaika(kaiyakuhr);
                asBikinkanriInsert.setKyktuukasyu(kyktuukasyu);
                asBikinkanriInsert.setShrtuukasyu(C_Tuukasyu.JPY);
                asBikinkanriInsert.setKwsratekjymd(kwsratekjymd);
                asBikinkanriInsert.setKawaserate(kawaserate);
                asBikinkanriInsert.setGyoumuKousinKinou(khozenCommonParam.getFunctionId());
                asBikinkanriInsert.setGyoumuKousinsyaId(khozenCommonParam.getUserID());
                asBikinkanriInsert.setGyoumuKousinTime(BizDate.getSysDateTimeMilli());

                BizPropertyInitializer.initialize(asBikinkanriInsert);

                asBikinkanriInserter.add(asBikinkanriInsert);

                asBikinkanriInfoOutKensuu++;
            }

            bzRecoveryDatasikibetuBean.initializeBlank();
        }

        batchLogger.info(MessageUtil.getMessage(MessageId.IBF0002, String.valueOf(asBikinkanriInfoOutKensuu),
            "案内収納備金管理テーブル"));
    }

    @AppBatchExceptionTerminate
    private void appBatchExceptionTerminate() {

        BzBatchAbendCommonRecovery bzBatchAbendCommonRecovery =
            SWAKInjector.getInstance(BzBatchAbendCommonRecovery.class);
        bzBatchAbendCommonRecovery.exec();
    }
}
