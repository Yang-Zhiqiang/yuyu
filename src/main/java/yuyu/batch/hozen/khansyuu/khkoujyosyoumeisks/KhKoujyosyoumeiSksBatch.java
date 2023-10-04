package yuyu.batch.hozen.khansyuu.khkoujyosyoumeisks;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.batch.annotation.AppBatchExceptionTerminate;
import jp.co.slcs.swak.batch.annotation.Execute;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateY;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.date.CHolidayAdjustingMode;
import jp.co.slcs.swak.db.EntityUpdater;
import jp.co.slcs.swak.db.ExDBResults;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.util.message.MessageUtil;
import yuyu.batch.hozen.khansyuu.khkoujyosyoumeisks.dba.KhKoujyosyoumeiSksDao;
import yuyu.batch.hozen.khansyuu.khkoujyosyoumeisks.dba.KoujyoSymSakuseiTaisyouDataBean;
import yuyu.common.biz.bzcommon.BizDateUtil;
import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.common.biz.bzcommon.BzBatchAbendCommonRecovery;
import yuyu.common.biz.bzcommon.HenkanTuuka;
import yuyu.common.hozen.ascommon.GetasPRsTuuka;
import yuyu.common.hozen.khcommon.CheckYuukouJyoutai;
import yuyu.common.hozen.khcommon.CheckYuukouJyoutaiParam;
import yuyu.common.hozen.khcommon.EditJimuRenrakusyuunou;
import yuyu.common.hozen.khcommon.EditJimuRenrakusyuunouParam;
import yuyu.common.hozen.khcommon.EditKoujyoSyoumeiParam;
import yuyu.common.hozen.khcommon.EditTtdkRirekiTbl;
import yuyu.common.hozen.khcommon.EditTtdkRirekiTblParam;
import yuyu.common.hozen.khcommon.HanteiTetuduki;
import yuyu.common.hozen.khcommon.KeisanKoujyogaku;
import yuyu.common.hozen.khcommon.KhozenCommonParam;
import yuyu.common.hozen.khcommon.KhozenTyouhyouCtl;
import yuyu.common.hozen.khcommon.KoujyoSyoumeiUtil;
import yuyu.def.MessageId;
import yuyu.def.biz.bean.param.BzRecoveryDatasikibetuBean;
import yuyu.def.classification.C_ChkkekkaKbn;
import yuyu.def.classification.C_HassouKbn;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_KahiKbn;
import yuyu.def.classification.C_Kjsmhakkouzumiflg;
import yuyu.def.classification.C_KoujyosyoumeisakuseisyoriKbn;
import yuyu.def.classification.C_KoujyosyoumeisentakuKbn;
import yuyu.def.classification.C_KoujyosyoumeisyuKbn;
import yuyu.def.classification.C_Kykjyoutai;
import yuyu.def.classification.C_SaihkHyjKbn;
import yuyu.def.classification.C_SinsakuseiKbn;
import yuyu.def.classification.C_SyorikahiKbn;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_YouhiKbn;
import yuyu.def.classification.C_YuukoujyotaichkKbn;
import yuyu.def.classification.C_YuukousyoumetuKbn;
import yuyu.def.classification.C_KoujyosyoumeimsgKbn;
import yuyu.def.db.entity.IT_AnsyuKihon;
import yuyu.def.db.entity.IT_KhTtdkRireki;
import yuyu.def.db.entity.IT_KoujyoSym;
import yuyu.def.db.entity.IT_KoujyoSymKanri;
import yuyu.def.db.entity.IT_KoujyoSymNaiyou;
import yuyu.def.db.entity.IT_KoujyoSymNaiyouD;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.hozen.configuration.YuyuHozenConfig;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.BatchParam;
import yuyu.infr.batch.logger.BatchLogger;
import yuyu.infr.report.CreateReport;

/**
 * 契約保全 案内収納 控除証明書作成
 */
public class KhKoujyosyoumeiSksBatch implements Batch {

    private static final String TABLEID = IT_KykKihon.TABLE_NAME;

    private static final String FILTERID = "Kh001";

    @Inject
    private BatchLogger batchLogger;

    private C_KoujyosyoumeimsgKbn koujyosyoumeimsgKbn;

    @Inject
    private KhKoujyosyoumeiSksBatchParam bzBatchParam;

    @Inject
    private HozenDomManager hozenDomManager;

    @Inject
    private KhKoujyosyoumeiSksDao khKoujyosyoumeiSksDao;

    @Inject
    private BzRecoveryDatasikibetuBean bzRecoveryDatasikibetuBean;

    @Inject
    private CreateReport createReport;

    @Override
    public BatchParam getParam() {
        return bzBatchParam;
    }

    @Execute
    @Transactional
    public void execute() {

        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);

        long syoriKensu = 0;
        String kinouid = khozenCommonParam.getFunctionId();
        String userId = khozenCommonParam.getUserID();
        String sysDateTime = BizDate.getSysDateTimeMilli();
        BizDate syoriYmd = bzBatchParam.getSyoriYmd();
        String ibKakutyoujobcd = bzBatchParam.getIbKakutyoujobcd();
        String heisoukbn = bzBatchParam.getHeisoukbn();

        batchLogger.info(MessageUtil.getMessage(MessageId.IBA0016, MessageUtil.getMessage(MessageId.IBW0003),
            String.valueOf(syoriYmd)));
        batchLogger.info(MessageUtil.getMessage(MessageId.IBA0016, MessageUtil.getMessage(MessageId.IBW1018),
            ibKakutyoujobcd));
        batchLogger.info(MessageUtil.getMessage(MessageId.IBC1025, heisoukbn));

        BizDateY syoumeiNendo = null;
        if (1 == syoriYmd.getMonth()) {
            syoumeiNendo = syoriYmd.addYears(-1).getBizDateY();
        }
        else {
            syoumeiNendo = syoriYmd.getBizDateY();
        }

        try (
            ExDBResults<KoujyoSymSakuseiTaisyouDataBean> exDBResultsBean =
            khKoujyosyoumeiSksDao.getKoujyoSymSakuseiTaisyouDataBean(ibKakutyoujobcd, syoumeiNendo, heisoukbn);
            EntityUpdater<IT_KykKihon> entityUpdater = new EntityUpdater<IT_KykKihon>()) {

            CheckYuukouJyoutaiParam checkYuukouJyoutaiParam = null;
            CheckYuukouJyoutai checkYuukouJyoutai = SWAKInjector.getInstance(CheckYuukouJyoutai.class);
            HanteiTetuduki hanteiTetuduki = SWAKInjector.getInstance(HanteiTetuduki.class);
            KoujyoSyoumeiUtil koujyoSyoumeiUtil = SWAKInjector.getInstance(KoujyoSyoumeiUtil.class);
            EditTtdkRirekiTbl editTtdkRirekiTbl = SWAKInjector.getInstance(EditTtdkRirekiTbl.class);
            HenkanTuuka henkanTuuka = SWAKInjector.getInstance(HenkanTuuka.class);

            for (KoujyoSymSakuseiTaisyouDataBean koujyoSymSakuseiTaisyouDataBean : exDBResultsBean) {
                syoriKensu++;
                bzRecoveryDatasikibetuBean.setIbKakutyoujobcd(ibKakutyoujobcd);
                bzRecoveryDatasikibetuBean.setIbTableid(TABLEID);
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterid(FILTERID);
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterkey1(koujyoSymSakuseiTaisyouDataBean.getKbnkey());
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterkey2(koujyoSymSakuseiTaisyouDataBean.getSyono());

                IT_KykKihon kykKihon = khKoujyosyoumeiSksDao.getKykKihon(koujyoSymSakuseiTaisyouDataBean.getSyono());

                IT_AnsyuKihon ansyuKihon = hozenDomManager.getAnsyuKihon(koujyoSymSakuseiTaisyouDataBean.getSyono());

                khozenCommonParam.setSikibetuKey(null);
                khozenCommonParam.setBatchKeiyakuKihon(kykKihon);
                khozenCommonParam.setBatchAnsyuKihon(ansyuKihon);

                checkYuukouJyoutaiParam = SWAKInjector.getInstance(CheckYuukouJyoutaiParam.class);
                checkYuukouJyoutaiParam.setSyono(kykKihon.getSyono());
                C_YuukoujyotaichkKbn yuukoujyotaichkKbn = checkYuukouJyoutai.exec(khozenCommonParam,
                    checkYuukouJyoutaiParam);
                if (C_YuukoujyotaichkKbn.HUKA.eq(yuukoujyotaichkKbn)) {
                    continue;
                }

                C_SyorikahiKbn syorikahiKbn = hanteiTetuduki.exec(khozenCommonParam, kykKihon.getSyono());
                if (C_SyorikahiKbn.SYORIHUKA.eq(syorikahiKbn)) {
                    continue;
                }

                if (C_Hrkkaisuu.NEN.eq(kykKihon.getHrkkaisuu()) || C_Hrkkaisuu.HALFY.eq(kykKihon.getHrkkaisuu())) {

                    if (!C_YuukousyoumetuKbn.SYOUMETU.eq(koujyoSymSakuseiTaisyouDataBean.getYuukousyoumetukbn()) &&
                        (C_Kykjyoutai.HRKMTYUU.eq(koujyoSymSakuseiTaisyouDataBean.getKykjyoutai()) ||
                            C_Kykjyoutai.ZENNOU.eq(koujyoSymSakuseiTaisyouDataBean.getKykjyoutai())) &&
                            syoriYmd.getMonth() != 1 &&
                            (BizDateUtil.compareYm(koujyoSymSakuseiTaisyouDataBean.getJkipjytym(),
                                BizDateYM.valueOf(syoumeiNendo, 12)) == BizDateUtil.COMPARE_LESSER ||
                                BizDateUtil.compareYm(koujyoSymSakuseiTaisyouDataBean.getJkipjytym(),
                                    BizDateYM.valueOf(syoumeiNendo, 12)) == BizDateUtil.COMPARE_EQUAL)) {

                        continue;
                    }
                }

                if (C_Hrkkaisuu.TUKI.eq(kykKihon.getHrkkaisuu())) {

                    IT_KoujyoSymKanri koujyoSymKanri = khKoujyosyoumeiSksDao.getKoujyoSymKanri(kykKihon,
                        String.valueOf(syoumeiNendo));

                    if (koujyoSymKanri != null) {

                        GetasPRsTuuka getasPRsTuuka = SWAKInjector.getInstance(GetasPRsTuuka.class);
                        getasPRsTuuka.exec(kykKihon.getSyono());

                        C_Tuukasyu rstuukasyu = getasPRsTuuka.getRstuukasyu();

                        C_Tuukasyu tuukasyu = henkanTuuka.henkanTuukaTypeToKbn(
                            koujyoSymSakuseiTaisyouDataBean.getHokenryou().getType());

                        if (C_Tuukasyu.JPY.eq(rstuukasyu) && !C_Tuukasyu.JPY.eq(tuukasyu)) {

                            if (!C_YuukousyoumetuKbn.SYOUMETU.eq(koujyoSymSakuseiTaisyouDataBean.getYuukousyoumetukbn()) &&
                                (BizDateUtil.compareYm(koujyoSymSakuseiTaisyouDataBean.getJkipjytym(),
                                    BizDateYM.valueOf(syoumeiNendo, 12)) == BizDateUtil.COMPARE_LESSER ||
                                    BizDateUtil.compareYm(koujyoSymSakuseiTaisyouDataBean.getJkipjytym(),
                                        BizDateYM.valueOf(syoumeiNendo, 12)) == BizDateUtil.COMPARE_EQUAL)) {

                                BizDate syorimMatuYmd = BizDateYM.valueOf(syoumeiNendo, 11).getLastDay();

                                if (!syorimMatuYmd.isBusinessDay()) {
                                    syorimMatuYmd = syorimMatuYmd.getBusinessDay(CHolidayAdjustingMode.PREVIOUS);
                                }

                                C_UmuKbn umuKbn = koujyoSyoumeiUtil.chkYenkanzanrateUmu(syorimMatuYmd, tuukasyu);

                                if (C_UmuKbn.NONE.eq(umuKbn)) {

                                    continue;
                                }
                            }

                            List<IT_KoujyoSym> koujyoSymLst = khKoujyosyoumeiSksDao.getKoujyoSym(kykKihon,
                                String.valueOf(syoumeiNendo));

                            if (koujyoSymLst.size() != 0) {

                                if (koujyoSymLst.get(0).getNewippanjissekisyoumeigk().compareTo(
                                    YuyuHozenConfig.getInstance().getIppanKoujyoGndgk()) >= 0) {

                                    continue;
                                }
                            }
                        }
                    }
                }

                KeisanKoujyogaku keisanKoujyogaku = SWAKInjector.getInstance(KeisanKoujyogaku.class);
                keisanKoujyogaku.setKhozenCommonParam(khozenCommonParam);
                keisanKoujyogaku.exec(kykKihon.getSyono(), syoumeiNendo.toString());

                if (C_ChkkekkaKbn.ERROR.eq(keisanKoujyogaku.getChkkekkaKbn())) {
                    createReport.exec(koujyoSyoumeiUtil.createKsnHkJmrnTyhyBean(
                        khozenCommonParam,
                        kykKihon.getSyono(),
                        syoumeiNendo.toString(),
                        keisanKoujyogaku.getMessage(),
                        syoriYmd));

                    continue;
                }

                BizDateYM lastSyoumeiEndYm = keisanKoujyogaku.getEndSyoumeiEndYm();
                EditKoujyoSyoumeiParam editKoujyoSyoumeiParam = keisanKoujyogaku.getParam();
                C_KahiKbn kjsmskahiKbn = C_KahiKbn.KA;

                IT_KoujyoSymKanri koujyoSymKanri = khKoujyosyoumeiSksDao.getKoujyoSymKanri(kykKihon,
                    syoumeiNendo.toString());

                if (lastSyoumeiEndYm == null ||
                    (koujyoSymKanri != null && koujyoSymKanri.getLastsyoumeiendym() != null &&
                        koujyoSymKanri.getLastsyoumeiendym().compareTo(lastSyoumeiEndYm) >= 0)) {
                    continue;
                }

                if (editKoujyoSyoumeiParam.getNewIppanNenkanSyoumeigk().compareTo(BizCurrency.valueOf(0,
                    editKoujyoSyoumeiParam.getNewIppanNenkanSyoumeigk().getType())) <= 0 &&
                    editKoujyoSyoumeiParam.getNewIryouNenkanSyoumeigk().compareTo(BizCurrency.valueOf(0,
                        editKoujyoSyoumeiParam.getNewIryouNenkanSyoumeigk().getType())) <= 0 &&
                        editKoujyoSyoumeiParam.getNewNenkinNenkanSyoumeigk().compareTo(BizCurrency.valueOf(0,
                            editKoujyoSyoumeiParam.getNewNenkinNenkanSyoumeigk().getType())) <= 0 &&
                                !C_KoujyosyoumeimsgKbn.YENHNDSNKKYTGKKSNHK.eq(editKoujyoSyoumeiParam.getKoujyosyoumeimsgKbn())) {
                    continue;
                }

                if (C_UmuKbn.NONE.eq(kykKihon.getKykSonotaTkyk().getZeiseitkkktkykhukaumu()) &&
                    editKoujyoSyoumeiParam.getNewNenkinNenkanSyoumeigk().compareTo(BizCurrency.valueOf(0,
                        editKoujyoSyoumeiParam.getNewNenkinNenkanSyoumeigk().getType())) > 0) {
                    List<String> jimuRenrakuHyouMsgList = new ArrayList<String>();
                    EditJimuRenrakusyuunou editJimuRenrakusyuunou = SWAKInjector.getInstance(EditJimuRenrakusyuunou.class);
                    EditJimuRenrakusyuunouParam editJimuRenrakusyuunouParam = SWAKInjector.getInstance(EditJimuRenrakusyuunouParam.class);

                    jimuRenrakuHyouMsgList.add("税適特約中途解約のため控除証明額計算不能");
                    jimuRenrakuHyouMsgList.add("控除証明書をハンド発行してください。");
                    jimuRenrakuHyouMsgList.add("");
                    jimuRenrakuHyouMsgList.add("証明年度／" + syoumeiNendo + "年");

                    editJimuRenrakusyuunouParam.setJimurenrakuMsgList(jimuRenrakuHyouMsgList);

                    createReport.exec(editJimuRenrakusyuunou.exec(
                        khozenCommonParam,
                        kykKihon.getSyono(),
                        C_SyoruiCdKbn.AS_JIMURENRAKU_SYUUNOU,
                        editJimuRenrakusyuunouParam,
                        syoriYmd));

                    kjsmskahiKbn = C_KahiKbn.HUKA;
                }

                if (!C_KahiKbn.HUKA.eq(kjsmskahiKbn)) {
                    editKoujyoSyoumeiParam.setSinkiSakusei(C_SinsakuseiKbn.SIN);
                    editKoujyoSyoumeiParam.setKoujyoNendo(syoumeiNendo.toString());
                    editKoujyoSyoumeiParam.setKoujyoSyuKbn(C_KoujyosyoumeisyuKbn.IPPAN);
                    editKoujyoSyoumeiParam.setKoujyoSakuseiSyoriKbn(C_KoujyosyoumeisakuseisyoriKbn.KOUJYOSYOUMEISYO_GAIBU);
                    editKoujyoSyoumeiParam.setSyoumeiYmd(syoriYmd);
                    editKoujyoSyoumeiParam.setKoujyoSakuseiSyoriKbn(C_KoujyosyoumeisentakuKbn.HAGAKI);
                    editKoujyoSyoumeiParam.setSaihkhyjkbn(C_SaihkHyjKbn.HIHYOUJI);

                    KhozenTyouhyouCtl khozenTyouhyouCtl = SWAKInjector.getInstance(KhozenTyouhyouCtl.class);

                    khozenTyouhyouCtl.setHassoukbn(C_HassouKbn.TYOKUSOU);
                    khozenTyouhyouCtl.setSyoriYmd(syoriYmd);
                    khozenTyouhyouCtl.setEditKoujyoSyoumeiParam(editKoujyoSyoumeiParam);

                    khozenTyouhyouCtl.createTyouhyouTBL(khozenCommonParam, kykKihon.getSyono(),
                        new C_SyoruiCdKbn[] { C_SyoruiCdKbn.KK_KOUJYOSYOUMEIS }, C_YouhiKbn.HUYOU);
                }

                if (koujyoSymKanri == null) {
                    koujyoSymKanri = khKoujyosyoumeiSksDao.createKoujyoSymKanri(kykKihon);
                    koujyoSymKanri.setNendo(syoumeiNendo.toString());
                    koujyoSymKanri.setLastsyoumeiendym(lastSyoumeiEndYm);
                    koujyoSymKanri.setGyoumuKousinKinou(kinouid);
                    koujyoSymKanri.setGyoumuKousinsyaId(userId);
                    koujyoSymKanri.setGyoumuKousinTime(sysDateTime);

                    BizPropertyInitializer.initialize(koujyoSymKanri);
                }
                else {
                    koujyoSymKanri.setLastsyoumeiendym(lastSyoumeiEndYm);
                    koujyoSymKanri.setGyoumuKousinKinou(kinouid);
                    koujyoSymKanri.setGyoumuKousinsyaId(userId);
                    koujyoSymKanri.setGyoumuKousinTime(sysDateTime);
                }

                List<IT_KoujyoSymNaiyou> koujyoSymNaiyouLst = khKoujyosyoumeiSksDao.getKoujyoSymNaiyou(kykKihon,
                    syoumeiNendo.toString());
                for (IT_KoujyoSymNaiyou koujyoSymNaiyou : koujyoSymNaiyouLst) {
                    koujyoSymNaiyou.setKjsmhakkouzumiflg(C_Kjsmhakkouzumiflg.SUMI);
                    koujyoSymNaiyou.setGyoumuKousinKinou(kinouid);
                    koujyoSymNaiyou.setGyoumuKousinsyaId(userId);
                    koujyoSymNaiyou.setGyoumuKousinTime(sysDateTime);
                }

                List<IT_KoujyoSymNaiyouD> koujyoSymNaiyouDLst = khKoujyosyoumeiSksDao.getKoujyoSymNaiyouD(kykKihon,
                    syoumeiNendo.toString());
                for (IT_KoujyoSymNaiyouD koujyoSymNaiyouD : koujyoSymNaiyouDLst) {

                    koujyoSymNaiyouD.setKjsmhakkouzumiflg(C_Kjsmhakkouzumiflg.SUMI);
                    koujyoSymNaiyouD.setGyoumuKousinKinou(kinouid);
                    koujyoSymNaiyouD.setGyoumuKousinsyaId(userId);
                    koujyoSymNaiyouD.setGyoumuKousinTime(sysDateTime);

                }

                if (!C_KahiKbn.HUKA.eq(kjsmskahiKbn)) {
                    EditTtdkRirekiTblParam editTtdkRirekiTblParam = SWAKInjector.getInstance(EditTtdkRirekiTblParam.class);
                    editTtdkRirekiTblParam.setCommonParam(khozenCommonParam);
                    editTtdkRirekiTblParam.setSyoNo(kykKihon.getSyono());
                    editTtdkRirekiTblParam.setSyoriYmd(syoriYmd);
                    editTtdkRirekiTblParam.setSysTime(sysDateTime);

                    IT_KhTtdkRireki khTtdkRireki = kykKihon.createKhTtdkRireki();
                    khTtdkRireki.setHenkousikibetukey(khozenCommonParam.getSikibetuKey(kykKihon.getSyono()));

                    editTtdkRirekiTbl.exec(editTtdkRirekiTblParam);
                }

                kykKihon.setSyhenkouymd(syoriYmd);
                kykKihon.setGyoumuKousinKinou(kinouid);
                kykKihon.setGyoumuKousinsyaId(userId);
                kykKihon.setGyoumuKousinTime(sysDateTime);

                khKoujyosyoumeiSksDao.addUpdateEntity(entityUpdater, kykKihon);
            }
            bzRecoveryDatasikibetuBean.initializeBlank();
        }
        batchLogger.info(MessageUtil.getMessage(MessageId.IBF0001, String.valueOf(syoriKensu)));
        batchLogger.info(MessageUtil.getMessage(MessageId.IBC1026, heisoukbn));

    }

    @AppBatchExceptionTerminate
    private void appBatchExceptionTerminate() {

        BzBatchAbendCommonRecovery bzBatchAbendCommonRecovery = SWAKInjector.
            getInstance(BzBatchAbendCommonRecovery.class);

        bzBatchAbendCommonRecovery.exec();
    }
}
