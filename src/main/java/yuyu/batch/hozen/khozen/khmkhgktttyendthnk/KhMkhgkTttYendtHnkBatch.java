package yuyu.batch.hozen.khozen.khmkhgktttyendthnk;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.batch.annotation.AppBatchExceptionTerminate;
import jp.co.slcs.swak.batch.annotation.Execute;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.ExDBResults;
import jp.co.slcs.swak.db.MultipleEntityInserter;
import jp.co.slcs.swak.db.MultipleEntityUpdater;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.util.bean.BeanUtil;
import jp.co.slcs.swak.util.message.MessageUtil;
import yuyu.batch.hozen.khozen.khmkhgktttyendthnk.dba.KhMkhgkTttYendtHnkBean;
import yuyu.batch.hozen.khozen.khmkhgktttyendthnk.dba.KhMkhgkTttYendtHnkDao;
import yuyu.common.biz.bzcommon.BizDateUtil;
import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.common.biz.bzcommon.BzBatchAbendCommonRecovery;
import yuyu.common.biz.bzcommon.GetKawaseRate;
import yuyu.common.biz.bzdairiten.BzGetTuukeiBunwari;
import yuyu.common.biz.kaikei.BzDenpyouDataSks;
import yuyu.common.biz.kaikei.BzDenpyouDataTourokuBean;
import yuyu.common.biz.kaikei.BzSegmentCdSyutoku;
import yuyu.common.biz.kaikei.BzSiwakeMeisaiBean;
import yuyu.common.biz.kaikei.SyouhinbetuSegmentBean;
import yuyu.common.hozen.haitou.CheckDJyoutai;
import yuyu.common.hozen.haitou.DBAccessDCommonYendtHnk;
import yuyu.common.hozen.haitou.HaitouDetachProcess;
import yuyu.common.hozen.haitou.KeisanDCommonYendtHnk;
import yuyu.common.hozen.khcommon.EditHokenSyoukenParam;
import yuyu.common.hozen.khcommon.EditKhMisslstParam;
import yuyu.common.hozen.khcommon.EditKykSyhnRirekiTbl;
import yuyu.common.hozen.khcommon.EditSeikyuusyoParam;
import yuyu.common.hozen.khcommon.EditTtdkKanryouParam;
import yuyu.common.hozen.khcommon.EditTtdkRirekiTbl;
import yuyu.common.hozen.khcommon.EditTtdkRirekiTblParam;
import yuyu.common.hozen.khcommon.GetKhTuusanyouKngk;
import yuyu.common.hozen.khcommon.GetKhTuusanyouKngkBean;
import yuyu.common.hozen.khcommon.IKhozenCommonConstants;
import yuyu.common.hozen.khcommon.KeisanHtyKeihi;
import yuyu.common.hozen.khcommon.KhozenCommonParam;
import yuyu.common.hozen.khcommon.KhozenTyouhyouCtl;
import yuyu.common.hozen.khcommon.TableMaintenanceUtil;
import yuyu.common.hozen.koutei.KhHituyousyoruiHanteiInBean;
import yuyu.common.hozen.prereport.HozenPreReportRenkeiBean;
import yuyu.common.sinkeiyaku.skcommon.SyouhinUtil;
import yuyu.def.MessageId;
import yuyu.def.base.manager.BaseDomManager;
import yuyu.def.biz.bean.param.BzRecoveryDatasikibetuBean;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.biz.sorter.SortBT_TjtIdouNyKh;
import yuyu.def.classification.C_Dbhanei;
import yuyu.def.classification.C_DiritenplannmKbn;
import yuyu.def.classification.C_EigyoubiHoseiKbn;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_HasseijikazeisyoriKbn;
import yuyu.def.classification.C_HasseijikngksyuruiKbn;
import yuyu.def.classification.C_HassouKbn;
import yuyu.def.classification.C_HouteiTyotkseiSyouhnHyjKbn;
import yuyu.def.classification.C_HrsyuruiKbn;
import yuyu.def.classification.C_HtsiryosyuKbn;
import yuyu.def.classification.C_Hubidataumu;
import yuyu.def.classification.C_Kanjyoukmkcd;
import yuyu.def.classification.C_KawaserateSyuruiKbn;
import yuyu.def.classification.C_KawasetekiyoKbn;
import yuyu.def.classification.C_KawasetsryKbn;
import yuyu.def.classification.C_KeiriyendthnkKbn;
import yuyu.def.classification.C_Khhrshrjiyuu;
import yuyu.def.classification.C_Khskssakuseijiyuu;
import yuyu.def.classification.C_KiharaiPseisanNaiyouKbn;
import yuyu.def.classification.C_KjkhukaKbn;
import yuyu.def.classification.C_MisyuumikeikaKbn;
import yuyu.def.classification.C_MousideIkouKbn;
import yuyu.def.classification.C_Nykkeiro;
import yuyu.def.classification.C_Segcd;
import yuyu.def.classification.C_Siharaijyoutaikbn;
import yuyu.def.classification.C_Sisuukbn;
import yuyu.def.classification.C_SksmongonKbn;
import yuyu.def.classification.C_SosysaiyouhiKbn;
import yuyu.def.classification.C_SyoriKbn;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.classification.C_TaisyakuKbn;
import yuyu.def.classification.C_TantouCdKbn;
import yuyu.def.classification.C_TargetTkKbn;
import yuyu.def.classification.C_Tdk;
import yuyu.def.classification.C_TetudukisyuKbn;
import yuyu.def.classification.C_TmttknhaibunjyoutaiKbn;
import yuyu.def.classification.C_TourokuRouteKbn;
import yuyu.def.classification.C_TrkKzkKbn;
import yuyu.def.classification.C_TtdktyuuiKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UktKbn;
import yuyu.def.classification.C_UktkJyoutaiKbn;
import yuyu.def.classification.C_UktkSyoriKbn;
import yuyu.def.classification.C_UktsyuKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_YouhiKbn;
import yuyu.def.db.entity.AM_SyoruiZokusei;
import yuyu.def.db.entity.AS_Kinou;
import yuyu.def.db.entity.BM_SyouhnZokusei;
import yuyu.def.db.entity.BM_TantouCd;
import yuyu.def.db.entity.BT_IdouKhBosyuudr;
import yuyu.def.db.entity.BT_IdouKhMeigi;
import yuyu.def.db.entity.BT_TjtIdouNyKh;
import yuyu.def.db.entity.BT_YendthnkSikinIdouData;
import yuyu.def.db.entity.IT_HhknSya;
import yuyu.def.db.entity.IT_KhDenpyoData;
import yuyu.def.db.entity.IT_KhHasseijiKazeiRireki;
import yuyu.def.db.entity.IT_KhHenkouUktk;
import yuyu.def.db.entity.IT_KhHenreikin;
import yuyu.def.db.entity.IT_KhTtdkRireki;
import yuyu.def.db.entity.IT_KhTtdkTyuui;
import yuyu.def.db.entity.IT_KihrkmpSeisanRireki;
import yuyu.def.db.entity.IT_KykDairiten;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.IT_KykSonotaTkyk;
import yuyu.def.db.entity.IT_KykSya;
import yuyu.def.db.entity.IT_KykSyouhn;
import yuyu.def.db.entity.IT_KykSyouhnHnkmae;
import yuyu.def.db.entity.IT_KykUkt;
import yuyu.def.db.entity.IT_NyknJissekiRireki;
import yuyu.def.db.entity.IT_TrkKzk;
import yuyu.def.db.entity.IW_KhYendtHnkHrShrWk;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.BatchParam;
import yuyu.infr.batch.logger.BatchLogger;

import com.google.common.collect.Lists;

/**
 * 契約保全 契約保全 円建変更
 */
public class KhMkhgkTttYendtHnkBatch implements Batch {

    private static final String TYSYTTAISYOUTABLEID = IT_KhHenkouUktk.TABLE_NAME;

    private static final String RECOVERYFILTERID = "Kh001";

    private Set<HaitouDetachProcess> haitouDetachProcessInLoopSet = new HashSet<HaitouDetachProcess>();

    private Set<HaitouDetachProcess> haitouDetachProcessOutLoopSet = new HashSet<HaitouDetachProcess>();

    public static final BizCurrency ZERO = BizCurrency.valueOf(0);

    private KhozenCommonParam khozenCommonParam;

    @Inject
    private BatchLogger batchLogger;

    @Inject
    private KhMkhgkTttYendtHnkBatchParam khMkhgkTttYendtHnkBatchParam;

    @Inject
    private KhMkhgkTttYendtHnkDao khMkhgkTttYendtHnkDao;

    @Inject
    private BzRecoveryDatasikibetuBean bzRecoveryDatasikibetuBean;

    @Inject
    private HozenDomManager hozenDomManager;

    @Inject
    private BizDomManager bizDomManager;

    @Inject
    private AS_Kinou kinou;

    @Inject
    private BaseDomManager baseDomManager;

    @Override
    public BatchParam getParam() {
        return khMkhgkTttYendtHnkBatchParam;
    }

    @Execute
    @Transactional
    public void execute() {
        BizDate syoriYmd = khMkhgkTttYendtHnkBatchParam.getSyoriYmd();
        String kakutyouJobCd = khMkhgkTttYendtHnkBatchParam.getIbKakutyoujobcd();
        String heisoukbn = khMkhgkTttYendtHnkBatchParam.getHeisoukbn();
        String sysDateTimeMilli = BizDate.getSysDateTimeMilli();
        batchLogger.info(MessageUtil.getMessage(MessageId.IBA0016, MessageUtil.getMessage(MessageId.IBW0003), String.valueOf(syoriYmd)));
        batchLogger.info(MessageUtil.getMessage(MessageId.IBA0016, MessageUtil.getMessage(MessageId.IBW1018), kakutyouJobCd));
        batchLogger.info(MessageUtil.getMessage(MessageId.IBC1025, String.valueOf(heisoukbn)));

        BM_TantouCd bMTantouCd = bizDomManager.getTantouCd(C_TantouCdKbn.DAIRITENJIMUHOZEN);
        String huriDenatesakiCd = bMTantouCd.getBusitucd();
        String suitouBumonCd = bMTantouCd.getBusitucd();
        String syoriSosikiCd = bMTantouCd.getBusitucd() + "0000";

        AM_SyoruiZokusei syoruiZokusei = baseDomManager.getSyoruiZokusei(C_SyoruiCdKbn.KK_YENDTHNKHNRKN_SKS);
        int hozonKikan = syoruiZokusei.getHozonKikan();

        long yendtHnkTaisyouInKensuu = 0;
        long khHnkukeKousinKensuuMkhgkTtt = 0;
        long khHnkukeKousinKensuuNnsky = 0;
        long missListOutKensuu = 0;
        khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        List<EditKhMisslstParam> editKhMisslstParamLst = new ArrayList<>();
        EditKykSyhnRirekiTbl editKykSyhnRirekiTbl = SWAKInjector.getInstance(EditKykSyhnRirekiTbl.class);
        TableMaintenanceUtil tableMaintenanceUtil = SWAKInjector.getInstance(TableMaintenanceUtil.class);
        SortBT_TjtIdouNyKh sortBT_TjtIdouNyKh = SWAKInjector.getInstance(SortBT_TjtIdouNyKh.class);
        BzGetTuukeiBunwari bzGetTuukeiBunwari = SWAKInjector.getInstance(BzGetTuukeiBunwari.class);
        KeisanHtyKeihi keisanHtyKeihi = SWAKInjector.getInstance(KeisanHtyKeihi.class);
        EditTtdkRirekiTbl editTtdkRirekiTbl = SWAKInjector.getInstance(EditTtdkRirekiTbl.class);
        KhozenTyouhyouCtl khozenTyouhyouCtl = SWAKInjector.getInstance(KhozenTyouhyouCtl.class);
        BzDenpyouDataSks bzDenpyouDataSks = SWAKInjector.getInstance(BzDenpyouDataSks.class);

        try (
            ExDBResults<KhMkhgkTttYendtHnkBean> khMkhgkTttYendtHnkBeanLst = khMkhgkTttYendtHnkDao.getKhMkhgkTttYendtHnkBeans(kakutyouJobCd, heisoukbn);
            MultipleEntityInserter multipleEntityInserter = new MultipleEntityInserter();
            MultipleEntityUpdater multipleEntityUpdater = new MultipleEntityUpdater()) {
            for (KhMkhgkTttYendtHnkBean khMkhgkTttYendtHnkBean : khMkhgkTttYendtHnkBeanLst) {

                String syoNo = khMkhgkTttYendtHnkBean.getSyono();

                bzRecoveryDatasikibetuBean.setIbKakutyoujobcd(kakutyouJobCd);
                bzRecoveryDatasikibetuBean.setIbTableid(TYSYTTAISYOUTABLEID);
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterid(RECOVERYFILTERID);
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterkey1(khMkhgkTttYendtHnkBean.getKbnkey());
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterkey2(syoNo);

                khozenCommonParam.setSikibetuKey(null);
                String henkouSikibetukey = khozenCommonParam.getSikibetuKey(syoNo);
                yendtHnkTaisyouInKensuu = yendtHnkTaisyouInKensuu + 1;

                BizDate yendtHnkKijyunDate = null;
                BizDate kykniyuhnkDate = null;

                if (C_UktkSyoriKbn.MKHGKTTTYENDTHNK.eq(khMkhgkTttYendtHnkBean.getUktkSyoriKbn())) {
                    yendtHnkKijyunDate = khMkhgkTttYendtHnkBean.getMkhgktttymd();
                    kykniyuhnkDate = khMkhgkTttYendtHnkBean.getMkhgktttymd();
                }
                else if (C_UktkSyoriKbn.NINISEIKYUU.eq(khMkhgkTttYendtHnkBean.getUktkSyoriKbn())) {
                    yendtHnkKijyunDate = khMkhgkTttYendtHnkBean.getSyoruiukeymd();
                    kykniyuhnkDate = khMkhgkTttYendtHnkBean.getYendthnkymd();
                }

                if (C_TourokuRouteKbn.ONLINE.eq(khMkhgkTttYendtHnkBean.getTourokuroutekbn())) {

                    CheckDJyoutai checkDJyoutai = getInjectInstanceForInLoop(CheckDJyoutai.class);

                    C_UmuKbn umuKbn = checkDJyoutai.execForMibaraiHaitouHantei(
                        yendtHnkKijyunDate, khMkhgkTttYendtHnkBean.getKykymd(), null,
                        khMkhgkTttYendtHnkBean.getHaitounendo());

                    if (C_UmuKbn.ARI.eq(umuKbn)) {

                        detach();

                        continue;
                    }
                }
                KeisanDCommonYendtHnk keisanDCommonYendtHnk = getInjectInstanceForInLoop(KeisanDCommonYendtHnk.class);

                C_ErrorKbn errorKbn = keisanDCommonYendtHnk.calcDkngk(syoNo, khMkhgkTttYendtHnkBean.getYendthnkymd(),
                    khMkhgkTttYendtHnkBean.getYendthnkymd(), syoriYmd);

                if(C_ErrorKbn.ERROR.eq(errorKbn)){

                    String messageId = "";

                    if (C_UktkSyoriKbn.MKHGKTTTYENDTHNK.eq(khMkhgkTttYendtHnkBean.getUktkSyoriKbn())) {
                        messageId = MessageId.EIF1118;
                    }
                    else if (C_UktkSyoriKbn.NINISEIKYUU.eq(khMkhgkTttYendtHnkBean.getUktkSyoriKbn())) {
                        messageId = MessageId.EIF1119;
                    }

                    missListOutKensuu = editMissList((int) missListOutKensuu, syoNo,
                        C_Dbhanei.NONE, editKhMisslstParamLst, messageId);

                    detach();

                    continue;
                }

                IT_KykKihon kykKihon = hozenDomManager.getKykKihon(syoNo);

                C_Segcd yendtbfrSeg1cd = C_Segcd.BLNK;
                C_Segcd yendtbfrSeg2cd = C_Segcd.BLNK;
                C_Segcd yendthnkSeg1cd = C_Segcd.BLNK;

                BzSegmentCdSyutoku bzSegmentCdSyutoku = SWAKInjector.getInstance(BzSegmentCdSyutoku.class);
                SyouhinbetuSegmentBean syouhinbetuSegmentBean = bzSegmentCdSyutoku.exec(
                    khMkhgkTttYendtHnkBean.getSyouhncd(), khMkhgkTttYendtHnkBean.getKyktuukasyu());

                if (C_ErrorKbn.ERROR.eq(syouhinbetuSegmentBean.getErrorKbn())) {

                    missListOutKensuu = editMissList((int) missListOutKensuu, syoNo, C_Dbhanei.NONE,
                        editKhMisslstParamLst, "EIC0010", "セグメントコード取得");
                    detach();
                    continue;
                }
                yendtbfrSeg1cd = syouhinbetuSegmentBean.getSegcd1();
                yendtbfrSeg2cd = syouhinbetuSegmentBean.getSegcd2();

                SyouhinbetuSegmentBean newSyouhinbetuSegmentBean = bzSegmentCdSyutoku.exec(
                    khMkhgkTttYendtHnkBean.getNewsyouhncd(), khMkhgkTttYendtHnkBean.getNewkyktuukasyu());

                if (C_ErrorKbn.ERROR.eq(newSyouhinbetuSegmentBean.getErrorKbn())) {

                    missListOutKensuu = editMissList((int) missListOutKensuu, syoNo, C_Dbhanei.NONE,
                        editKhMisslstParamLst, "EIC0010", "セグメントコード取得");
                    detach();
                    continue;
                }
                yendthnkSeg1cd = newSyouhinbetuSegmentBean.getSegcd1();

                BM_SyouhnZokusei syouhnZokusei = bizDomManager.getSyouhnZokusei(khMkhgkTttYendtHnkBean.getNewsyouhncd(),
                    khMkhgkTttYendtHnkBean.getNewsyouhnsdno());

                tableMaintenanceUtil.backUp(syoNo, henkouSikibetukey);

                khozenCommonParam.setBatchBakKykKihon(tableMaintenanceUtil.getBakKykKihon());
                khozenCommonParam.setBatchBakAnsyuKihon(tableMaintenanceUtil.getBakAnsyuKihon());

                kykKihon.setHrkp(ZERO);
                kykKihon.setHaitounendo(keisanDCommonYendtHnk.getHaitouNendo());
                kykKihon.setSyhenkouymd(syoriYmd);
                kykKihon.setLastsyosaihkymd(syoriYmd);
                kykKihon.setGyoumuKousinKinou(khozenCommonParam.getFunctionId());
                kykKihon.setGyoumuKousinsyaId(khozenCommonParam.getUserID());
                kykKihon.setGyoumuKousinTime(sysDateTimeMilli);

                khozenCommonParam.setBatchKeiyakuKihon(kykKihon);
                khozenCommonParam.setBatchAnsyuKihon(hozenDomManager.getAnsyuKihon(syoNo));

                IT_KhTtdkRireki khTtdkRireki = kykKihon.createKhTtdkRireki();
                khTtdkRireki.setHenkousikibetukey(henkouSikibetukey);

                editKykSyhnRirekiTbl.exec(khozenCommonParam, syoNo);

                List<IT_KykSyouhn> kykSyouhnLst = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
                IT_KykSyouhn henkoumaeKykSyouhn = kykSyouhnLst.get(0);

                int syohinHanteiKbn = SyouhinUtil.hantei(henkoumaeKykSyouhn.getSyouhncd());

                IT_KykSyouhn kykSyouhn = kykKihon.createKykSyouhn();
                kykSyouhn.setSyutkkbn(C_SyutkKbn.SYU);
                kykSyouhn.setSyouhncd(khMkhgkTttYendtHnkBean.getNewsyouhncd());
                kykSyouhn.setSyouhnsdno(khMkhgkTttYendtHnkBean.getNewsyouhnsdno());
                kykSyouhn.setKyksyouhnrenno(1);
                kykSyouhn.setHenkousikibetukey(henkouSikibetukey);
                kykSyouhn.setYuukousyoumetukbn(henkoumaeKykSyouhn.getYuukousyoumetukbn());
                kykSyouhn.setKykjyoutai(henkoumaeKykSyouhn.getKykjyoutai());
                kykSyouhn.setKouryokuhasseiymd(khMkhgkTttYendtHnkBean.getYendthnkymd());
                kykSyouhn.setKykymd(henkoumaeKykSyouhn.getKykymd());
                kykSyouhn.setKykymdsiteiumukbn(henkoumaeKykSyouhn.getKykymdsiteiumukbn());
                kykSyouhn.setSknnkaisiymd(henkoumaeKykSyouhn.getSknnkaisiymd());
                kykSyouhn.setGansknnkaisiymd(henkoumaeKykSyouhn.getGansknnkaisiymd());
                kykSyouhn.setHksknnkaisiymd(henkoumaeKykSyouhn.getHksknnkaisiymd());
                kykSyouhn.setHkgansknnkaisiymd(henkoumaeKykSyouhn.getHkgansknnkaisiymd());
                kykSyouhn.setHknkknsmnkbn(henkoumaeKykSyouhn.getHknkknsmnkbn());
                kykSyouhn.setHknkkn(henkoumaeKykSyouhn.getHknkkn());
                kykSyouhn.setHrkkknsmnkbn(henkoumaeKykSyouhn.getHrkkknsmnkbn());
                kykSyouhn.setHrkkkn(henkoumaeKykSyouhn.getHrkkkn());
                kykSyouhn.setKyknen(henkoumaeKykSyouhn.getKyknen());
                kykSyouhn.setHhknnen(henkoumaeKykSyouhn.getHhknnen());
                kykSyouhn.setHhknseiymd(henkoumaeKykSyouhn.getHhknseiymd());
                kykSyouhn.setHhknsei(henkoumaeKykSyouhn.getHhknsei());
                kykSyouhn.setHaraimanymd(henkoumaeKykSyouhn.getHaraimanymd());
                kykSyouhn.setHknkknmanryouymd(henkoumaeKykSyouhn.getHknkknmanryouymd());
                kykSyouhn.setKatakbn(henkoumaeKykSyouhn.getKatakbn());
                kykSyouhn.setKyhgndkatakbn(henkoumaeKykSyouhn.getKyhgndkatakbn());
                kykSyouhn.setSyukyhkinkatakbn(henkoumaeKykSyouhn.getSyukyhkinkatakbn());
                kykSyouhn.setKhnkyhkgbairitukbn(henkoumaeKykSyouhn.getKhnkyhkgbairitukbn());
                kykSyouhn.setRokudaildkbn(henkoumaeKykSyouhn.getRokudaildkbn());
                kykSyouhn.setPmnjtkkbn(henkoumaeKykSyouhn.getPmnjtkkbn());
                kykSyouhn.setKihons(khMkhgkTttYendtHnkBean.getNewkihons());
                kykSyouhn.setHokenryou(khMkhgkTttYendtHnkBean.getNewhokenryou());
                kykSyouhn.setKyktuukasyu(khMkhgkTttYendtHnkBean.getNewkyktuukasyu());
                kykSyouhn.setRyouritusdno(khMkhgkTttYendtHnkBean.getNewryouritusdno());
                kykSyouhn.setYoteiriritu(khMkhgkTttYendtHnkBean.getNewyoteiriritu());
                kykSyouhn.setNksyukbn(henkoumaeKykSyouhn.getNksyukbn());
                kykSyouhn.setNenkinkkn(henkoumaeKykSyouhn.getNenkinkkn());
                kykSyouhn.setNkgnshosyouritu(henkoumaeKykSyouhn.getNkgnshosyouritu());
                kykSyouhn.setNkgnshosyougk(henkoumaeKykSyouhn.getNkgnshosyougk());
                kykSyouhn.setGengakugoyenitijibrpstgk(ZERO);
                kykSyouhn.setYendthnkymd(khMkhgkTttYendtHnkBean.getYendthnkymd());

                if (SyouhinUtil.GONENRISAHAITOUSITEITUUKASYUUSIN_ITIJIBR == syohinHanteiKbn) {
                    kykSyouhn.setSetteibairitu(henkoumaeKykSyouhn.getSetteibairitu());
                    kykSyouhn.setKykjisisuurendourate(henkoumaeKykSyouhn.getKykjisisuurendourate());
                    kykSyouhn.setTmttknzoukaritujygn(henkoumaeKykSyouhn.getTmttknzoukaritujygn());
                    kykSyouhn.setTumitateriritu(henkoumaeKykSyouhn.getTumitateriritu());
                    kykSyouhn.setTmttknhaibunjyoutai(henkoumaeKykSyouhn.getTmttknhaibunjyoutai());
                    kykSyouhn.setSisuukbn(henkoumaeKykSyouhn.getSisuukbn());
                }
                else if (SyouhinUtil.GONENRISAHAITOUSITEITUUKASYUUSIN_ITIJIBR_19 == syohinHanteiKbn) {
                    kykSyouhn.setSetteibairitu(henkoumaeKykSyouhn.getSetteibairitu());
                    kykSyouhn.setKykjisisuurendourate(henkoumaeKykSyouhn.getKykjisisuurendourate());
                    kykSyouhn.setTmttknzoukaritujygn(henkoumaeKykSyouhn.getTmttknzoukaritujygn());
                    kykSyouhn.setTumitateriritu(khMkhgkTttYendtHnkBean.getNewtumitateriritu());
                    kykSyouhn.setTmttknhaibunjyoutai(henkoumaeKykSyouhn.getTmttknhaibunjyoutai());
                    kykSyouhn.setSisuukbn(henkoumaeKykSyouhn.getSisuukbn());
                }
                else if (SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR == syohinHanteiKbn) {
                    kykSyouhn.setSetteibairitu(BizNumber.ZERO);
                    kykSyouhn.setKykjisisuurendourate(henkoumaeKykSyouhn.getKykjisisuurendourate());
                    kykSyouhn.setTmttknzoukaritujygn(BizNumber.ZERO);
                    kykSyouhn.setTumitateriritu(khMkhgkTttYendtHnkBean.getNewtumitateriritu());
                    kykSyouhn.setTmttknhaibunjyoutai(C_TmttknhaibunjyoutaiKbn.BLNK);
                    kykSyouhn.setSisuukbn(C_Sisuukbn.BLNK);
                }

                kykSyouhn.setGsbunrikzkakuninumu(henkoumaeKykSyouhn.getGsbunrikzkakuninumu());
                kykSyouhn.setGsbunritaisyou(henkoumaeKykSyouhn.getGsbunritaisyou());
                kykSyouhn.setGyoumuKousinKinou(khozenCommonParam.getFunctionId());
                kykSyouhn.setGyoumuKousinsyaId(khozenCommonParam.getUserID());
                kykSyouhn.setGyoumuKousinTime(sysDateTimeMilli);
                kykSyouhn.setPharaikomisougaku(ZERO);
                kykSyouhn.setTmttknitenymd(henkoumaeKykSyouhn.getTmttknitenymd());
                kykSyouhn.setLoadinghnkgtumitateriritu(BizNumber.ZERO);
                kykSyouhn.setRendouritu(henkoumaeKykSyouhn.getRendouritu());
                kykSyouhn.setTeikishrritu(henkoumaeKykSyouhn.getTeikishrritu());
                kykSyouhn.setDai1hknkkn(0);
                BizPropertyInitializer.initialize(kykSyouhn);
                kykSyouhn.setSyouhnZokusei(syouhnZokusei);
                kykKihon.getKykSyouhns().remove(henkoumaeKykSyouhn);

                IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();
                IT_KykSonotaTkyk kykSonotaTkykmae = new IT_KykSonotaTkyk();
                BeanUtil.copyProperties(kykSonotaTkykmae, kykSonotaTkyk);
                kykSonotaTkyk.setTargettkhkumu(C_UmuKbn.NONE);
                kykSonotaTkyk.setTargettkykkykhenkoymd(null);
                kykSonotaTkyk.setTargettkkbn(C_TargetTkKbn.BLNK);
                kykSonotaTkyk.setTargettkmokuhyouti(0);
                kykSonotaTkyk.setInitsbjiyensitihsytkhukaumu(C_UmuKbn.NONE);
                kykSonotaTkyk.setInitsbjiyenkasaiteihsygk(ZERO);
                if (SyouhinUtil.GONENRISAHAITOUSITEITUUKASYUUSIN_ITIJIBR_19 == syohinHanteiKbn) {
                    kykSonotaTkyk.setJyudkaigomeharaitkhukaumu(C_UmuKbn.NONE);
                    kykSonotaTkyk.setJyudkaigomeharaitkhukaymd(null);
                }
                kykSonotaTkyk.setTargettkykhkymd(null);
                kykSonotaTkyk.setTargettkykkijyungk(ZERO);
                kykSonotaTkyk.setGyoumuKousinKinou(khozenCommonParam.getFunctionId());
                kykSonotaTkyk.setGyoumuKousinsyaId(khozenCommonParam.getUserID());
                kykSonotaTkyk.setGyoumuKousinTime(sysDateTimeMilli);

                Integer maxRenNo = khMkhgkTttYendtHnkDao.getKykSyouhnHnkmaeMaxRennoBySyonoSyutkkbnSyouhncdSyouhnsdnoKyksyouhnrenno(
                    syoNo,
                    henkoumaeKykSyouhn.getSyutkkbn(),
                    henkoumaeKykSyouhn.getSyouhncd(),
                    henkoumaeKykSyouhn.getSyouhnsdno(),
                    henkoumaeKykSyouhn.getKyksyouhnrenno());
                if (maxRenNo != null) {
                    maxRenNo = maxRenNo + 1;
                }
                else {
                    maxRenNo = 1;
                }
                IT_KykSyouhnHnkmae kykSyouhnHnkmae = new IT_KykSyouhnHnkmae(henkoumaeKykSyouhn.getSyono(),
                    henkoumaeKykSyouhn.getSyutkkbn(),
                    henkoumaeKykSyouhn.getSyouhncd(),
                    henkoumaeKykSyouhn.getSyouhnsdno(),
                    henkoumaeKykSyouhn.getKyksyouhnrenno(),
                    maxRenNo);

                kykSyouhnHnkmae.setHenkousikibetukey(henkoumaeKykSyouhn.getHenkousikibetukey());
                kykSyouhnHnkmae.setYuukousyoumetukbn(henkoumaeKykSyouhn.getYuukousyoumetukbn());
                kykSyouhnHnkmae.setKykjyoutai(henkoumaeKykSyouhn.getKykjyoutai());
                kykSyouhnHnkmae.setSyoumetujiyuu(henkoumaeKykSyouhn.getSyoumetujiyuu());
                kykSyouhnHnkmae.setSyoumetuymd(henkoumaeKykSyouhn.getSyoumetuymd());
                kykSyouhnHnkmae.setKouryokuhasseiymd(henkoumaeKykSyouhn.getKouryokuhasseiymd());
                kykSyouhnHnkmae.setKykymd(henkoumaeKykSyouhn.getKykymd());
                kykSyouhnHnkmae.setKykymdsiteiumukbn(henkoumaeKykSyouhn.getKykymdsiteiumukbn());
                kykSyouhnHnkmae.setSknnkaisiymd(henkoumaeKykSyouhn.getSknnkaisiymd());
                kykSyouhnHnkmae.setGansknnkaisiymd(henkoumaeKykSyouhn.getGansknnkaisiymd());
                kykSyouhnHnkmae.setHksknnkaisiymd(henkoumaeKykSyouhn.getHksknnkaisiymd());
                kykSyouhnHnkmae.setHkgansknnkaisiymd(henkoumaeKykSyouhn.getHkgansknnkaisiymd());
                kykSyouhnHnkmae.setHknkknsmnkbn(henkoumaeKykSyouhn.getHknkknsmnkbn());
                kykSyouhnHnkmae.setHknkkn(henkoumaeKykSyouhn.getHknkkn());
                kykSyouhnHnkmae.setHrkkknsmnkbn(henkoumaeKykSyouhn.getHrkkknsmnkbn());
                kykSyouhnHnkmae.setHrkkkn(henkoumaeKykSyouhn.getHrkkkn());
                kykSyouhnHnkmae.setKyknen(henkoumaeKykSyouhn.getKyknen());
                kykSyouhnHnkmae.setHhknnen(henkoumaeKykSyouhn.getHhknnen());
                kykSyouhnHnkmae.setHhknseiymd(henkoumaeKykSyouhn.getHhknseiymd());
                kykSyouhnHnkmae.setHhknsei(henkoumaeKykSyouhn.getHhknsei());
                kykSyouhnHnkmae.setHaraimanymd(henkoumaeKykSyouhn.getHaraimanymd());
                kykSyouhnHnkmae.setHknkknmanryouymd(henkoumaeKykSyouhn.getHknkknmanryouymd());
                kykSyouhnHnkmae.setKatakbn(henkoumaeKykSyouhn.getKatakbn());
                kykSyouhnHnkmae.setKyhgndkatakbn(henkoumaeKykSyouhn.getKyhgndkatakbn());
                kykSyouhnHnkmae.setSyukyhkinkatakbn(henkoumaeKykSyouhn.getSyukyhkinkatakbn());
                kykSyouhnHnkmae.setKhnkyhkgbairitukbn(henkoumaeKykSyouhn.getKhnkyhkgbairitukbn());
                kykSyouhnHnkmae.setRokudaildkbn(henkoumaeKykSyouhn.getRokudaildkbn());
                kykSyouhnHnkmae.setPmnjtkkbn(henkoumaeKykSyouhn.getPmnjtkkbn());
                kykSyouhnHnkmae.setKihons(henkoumaeKykSyouhn.getKihons());
                kykSyouhnHnkmae.setHokenryou(henkoumaeKykSyouhn.getHokenryou());
                kykSyouhnHnkmae.setKyktuukasyu(henkoumaeKykSyouhn.getKyktuukasyu());
                kykSyouhnHnkmae.setRyouritusdno(henkoumaeKykSyouhn.getRyouritusdno());
                kykSyouhnHnkmae.setYoteiriritu(henkoumaeKykSyouhn.getYoteiriritu());
                kykSyouhnHnkmae.setYoteirrthendohosyurrt(henkoumaeKykSyouhn.getYoteirrthendohosyurrt());
                kykSyouhnHnkmae.setYtirrthndmnskaisuu(henkoumaeKykSyouhn.getYtirrthndmnskaisuu());
                kykSyouhnHnkmae.setKyksjkkktyouseiriritu(henkoumaeKykSyouhn.getKyksjkkktyouseiriritu());
                kykSyouhnHnkmae.setNksyukbn(henkoumaeKykSyouhn.getNksyukbn());
                kykSyouhnHnkmae.setNenkinkkn(henkoumaeKykSyouhn.getNenkinkkn());
                kykSyouhnHnkmae.setNkgnshosyouritu(henkoumaeKykSyouhn.getNkgnshosyouritu());
                kykSyouhnHnkmae.setNkgnshosyougk(henkoumaeKykSyouhn.getNkgnshosyougk());
                kykSyouhnHnkmae.setGengakugoyenitijibrpstgk(henkoumaeKykSyouhn.getGengakugoyenitijibrpstgk());
                kykSyouhnHnkmae.setYendthnkymd(henkoumaeKykSyouhn.getYendthnkymd());
                kykSyouhnHnkmae.setSetteibairitu(henkoumaeKykSyouhn.getSetteibairitu());
                kykSyouhnHnkmae.setKykjisisuurendourate(henkoumaeKykSyouhn.getKykjisisuurendourate());
                kykSyouhnHnkmae.setTmttknzoukaritujygn(henkoumaeKykSyouhn.getTmttknzoukaritujygn());
                kykSyouhnHnkmae.setTumitateriritu(henkoumaeKykSyouhn.getTumitateriritu());
                kykSyouhnHnkmae.setTmttknhaibunjyoutai(henkoumaeKykSyouhn.getTmttknhaibunjyoutai());
                kykSyouhnHnkmae.setSisuukbn(henkoumaeKykSyouhn.getSisuukbn());
                kykSyouhnHnkmae.setGsbunrikzkakuninumu(henkoumaeKykSyouhn.getGsbunrikzkakuninumu());
                kykSyouhnHnkmae.setGsbunritaisyou(henkoumaeKykSyouhn.getGsbunritaisyou());
                kykSyouhnHnkmae.setTargettkhkumu(kykSonotaTkykmae.getTargettkhkumu());
                kykSyouhnHnkmae.setTargettkykkykhenkoymd(kykSonotaTkykmae.getTargettkykkykhenkoymd());
                kykSyouhnHnkmae.setTargettkkbn(kykSonotaTkykmae.getTargettkkbn());
                kykSyouhnHnkmae.setTargettkmokuhyouti(kykSonotaTkykmae.getTargettkmokuhyouti());
                kykSyouhnHnkmae.setInitsbjiyensitihsytkhukaumu(kykSonotaTkykmae.getInitsbjiyensitihsytkhukaumu());
                kykSyouhnHnkmae.setInitsbjiyenkasaiteihsygk(kykSonotaTkykmae.getInitsbjiyenkasaiteihsygk());
                kykSyouhnHnkmae.setTargettkykhkymd(kykSonotaTkykmae.getTargettkykhkymd());
                kykSyouhnHnkmae.setTargettkykkijyungk(kykSonotaTkykmae.getTargettkykkijyungk());
                kykSyouhnHnkmae.setDai1hknkkn(henkoumaeKykSyouhn.getDai1hknkkn());
                kykSyouhnHnkmae.setGyoumuKousinKinou(khozenCommonParam.getFunctionId());
                kykSyouhnHnkmae.setGyoumuKousinsyaId(khozenCommonParam.getUserID());
                kykSyouhnHnkmae.setGyoumuKousinTime(sysDateTimeMilli);
                kykSyouhnHnkmae.setHaitounendo(khMkhgkTttYendtHnkBean.getHaitounendo());
                kykSyouhnHnkmae.setPharaikomisougaku(henkoumaeKykSyouhn.getPharaikomisougaku());
                kykSyouhnHnkmae.setTmttknitenymd(henkoumaeKykSyouhn.getTmttknitenymd());
                kykSyouhnHnkmae.setLoadinghnkgtumitateriritu(henkoumaeKykSyouhn.getLoadinghnkgtumitateriritu());
                kykSyouhnHnkmae.setRendouritu(henkoumaeKykSyouhn.getRendouritu());
                kykSyouhnHnkmae.setTeikishrritu(henkoumaeKykSyouhn.getTeikishrritu());
                kykSyouhnHnkmae.setJyudkaigomeharaitkhukaumu(kykSonotaTkykmae.getJyudkaigomeharaitkhukaumu());
                kykSyouhnHnkmae.setJyudkaigomeharaitkhukaymd(kykSonotaTkykmae.getJyudkaigomeharaitkhukaymd());

                BizPropertyInitializer.initialize(kykSyouhnHnkmae);
                multipleEntityInserter.add(kykSyouhnHnkmae);

                IT_KykSya kykSya = kykKihon.getKykSya();
                IT_HhknSya hhknSya = kykKihon.getHhknSya();
                IT_KhTtdkTyuui khTtdkTyuui = kykKihon.getKhTtdkTyuui();
                List<IT_KykUkt> sbKykUktList = kykKihon.getKykUktsByUktsyukbn(C_UktsyuKbn.SBUKT);
                List<IT_KykDairiten> kykDairitenList = kykKihon.getKykDairitens();
                List<IT_KykUkt> stKykUktList = kykKihon.getKykUktsByUktsyukbn(C_UktsyuKbn.STDRSK);
                List<IT_KykUkt> kykdrKykUktList = kykKihon.getKykUktsByUktsyukbn(C_UktsyuKbn.KYKDRN);
                List<IT_TrkKzk> trkKzkList = kykKihon.getTrkKzks();

                List<BT_TjtIdouNyKh> tjtIdouNyKhLst = bizDomManager.getTjtIdouNyKhsBySyono(syoNo);
                List<BT_TjtIdouNyKh> sortTjtIdouNyKhLst = sortBT_TjtIdouNyKh.OrderBT_TjtIdouNyKhByPkDesc(tjtIdouNyKhLst);

                Integer tjtIdouNyKhRenno = 0;
                if (sortTjtIdouNyKhLst.size() > 0) {
                    tjtIdouNyKhRenno = sortTjtIdouNyKhLst.get(0).getRenno3keta() + 1;
                }
                else {
                    tjtIdouNyKhRenno = 1;
                }

                IT_NyknJissekiRireki nyknJissekiRireki = kykKihon.getNyknJissekiRirekisByNykkeiro(C_Nykkeiro.SKEI).get(0);

                GetKhTuusanyouKngk getKhTuusanyouKngk = SWAKInjector.getInstance(GetKhTuusanyouKngk.class);

                GetKhTuusanyouKngkBean getKhTuusanyouKngkBean = getKhTuusanyouKngk.
                    getAlltsnkngk(syouhnZokusei, kykSyouhn, nyknJissekiRireki, kykSonotaTkyk);

                C_Tuukasyu tsnyouTuukasyu = getKhTuusanyouKngkBean.getTsnyouTuukasyu();
                BizCurrency tsnyouSibouS = getKhTuusanyouKngkBean.getTsnyouSibous();
                BizCurrency tsnyouItijiP = getKhTuusanyouKngkBean.getTsnyouItijip();
                BizCurrency tsnyouNkGns = getKhTuusanyouKngkBean.getTsnyouNkgns();
                BizCurrency tsnyenNyknKgk = getKhTuusanyouKngkBean.getTsnyouYennyknkgk();

                String kzktourokunmKn1 = "";
                String kzktourokunmKj1 = "";
                String kzktourokunmKn2 = "";
                String kzktourokunmKj2 = "";

                for (IT_TrkKzk trkKzk : trkKzkList) {

                    if (C_TrkKzkKbn.TRKKZK1.eq(trkKzk.getTrkkzkkbn())) {

                        kzktourokunmKn1 = trkKzk.getTrkkzknmkn();

                        if (!C_KjkhukaKbn.KJKHUKA.eq(trkKzk.getTrkkzknmkjkhukakbn())) {

                            kzktourokunmKj1 = trkKzk.getTrkkzknmkj();
                        }
                    }

                    if (C_TrkKzkKbn.TRKKZK2.eq(trkKzk.getTrkkzkkbn())) {

                        kzktourokunmKn2 = trkKzk.getTrkkzknmkn();

                        if (!C_KjkhukaKbn.KJKHUKA.eq(trkKzk.getTrkkzknmkjkhukakbn())) {

                            kzktourokunmKj2 = trkKzk.getTrkkzknmkj();
                        }
                    }
                }

                BT_TjtIdouNyKh tjtIdouNyKh = new BT_TjtIdouNyKh();
                tjtIdouNyKh.setSyono(syoNo);
                tjtIdouNyKh.setRenno3keta(tjtIdouNyKhRenno);
                tjtIdouNyKh.setRecordsakujyohyouji(0);
                tjtIdouNyKh.setYoukyuuno("");
                tjtIdouNyKh.setSyouhncd(khMkhgkTttYendtHnkBean.getNewsyouhncd());
                tjtIdouNyKh.setKykjyoutai(kykSyouhn.getKykjyoutai());
                tjtIdouNyKh.setKykymd(kykSyouhn.getKykymd());
                tjtIdouNyKh.setYuukousyoumetukbn(kykSyouhn.getYuukousyoumetukbn());
                tjtIdouNyKh.setKyktuukasyu(khMkhgkTttYendtHnkBean.getNewkyktuukasyu());
                tjtIdouNyKh.setTsnyousibous(tsnyouSibouS);
                tjtIdouNyKh.setTsnyouitijip(tsnyouItijiP);
                tjtIdouNyKh.setTsnyounkgns(tsnyouNkGns);
                tjtIdouNyKh.setHrkkkn(kykSyouhn.getHrkkkn());
                tjtIdouNyKh.setSntkhoukbn(kykKihon.getSntkhoukbn());
                tjtIdouNyKh.setBosyuuym(kykKihon.getBosyuuym());

                if (C_Tdk.HONNIN.eq(kykSya.getKkkyktdk())) {
                    tjtIdouNyKh.setKykhhkndouhyouji(1);
                }
                else {
                    tjtIdouNyKh.setKykhhkndouhyouji(0);
                }
                if (khTtdkTyuui != null) {
                    tjtIdouNyKh.setTtdktyuuikbn1(khTtdkTyuui.getTtdktyuuikbn1());
                    tjtIdouNyKh.setTtdktyuuikbn2(khTtdkTyuui.getTtdktyuuikbn2());
                    tjtIdouNyKh.setTtdktyuuikbn3(khTtdkTyuui.getTtdktyuuikbn3());
                    tjtIdouNyKh.setTtdktyuuikbn4(khTtdkTyuui.getTtdktyuuikbn4());
                    tjtIdouNyKh.setTtdktyuuikbn5(khTtdkTyuui.getTtdktyuuikbn5());
                }
                else {
                    tjtIdouNyKh.setTtdktyuuikbn1(C_TtdktyuuiKbn.BLNK);
                    tjtIdouNyKh.setTtdktyuuikbn2(C_TtdktyuuiKbn.BLNK);
                    tjtIdouNyKh.setTtdktyuuikbn3(C_TtdktyuuiKbn.BLNK);
                    tjtIdouNyKh.setTtdktyuuikbn4(C_TtdktyuuiKbn.BLNK);
                    tjtIdouNyKh.setTtdktyuuikbn5(C_TtdktyuuiKbn.BLNK);
                }
                tjtIdouNyKh.setSyouhnsdno(khMkhgkTttYendtHnkBean.getNewsyouhnsdno());
                tjtIdouNyKh.setKaigomaehrtkykumukbn(kykSonotaTkyk.getJyudkaigomeharaitkhukaumu());
                tjtIdouNyKh.setPyennykntkykumukbn(kykSonotaTkyk.getYennykntkhkumu());
                tjtIdouNyKh.setTsnyennyknkgk(tsnyenNyknKgk);
                tjtIdouNyKh.setSkjmosno(kykKihon.getSkjmosno());
                tjtIdouNyKh.setGyoumuKousinKinou(khozenCommonParam.getFunctionId());
                tjtIdouNyKh.setGyoumuKousinsyaId(khozenCommonParam.getUserID());
                tjtIdouNyKh.setGyoumuKousinTime(sysDateTimeMilli);
                tjtIdouNyKh.setSeiritujitrhkjikakkbn(kykKihon.getSeiritujitrhkjikakkbn());
                if (C_UmuKbn.ARI.eq(syouhnZokusei.getHouteityotkseiumu())) {
                    tjtIdouNyKh.setHouteityotkseisyouhnhyj(C_HouteiTyotkseiSyouhnHyjKbn.GAITOU);
                }
                else {
                    tjtIdouNyKh.setHouteityotkseisyouhnhyj(C_HouteiTyotkseiSyouhnHyjKbn.HIGAITOU);
                }
                tjtIdouNyKh.setTsntuukasyu(tsnyouTuukasyu);

                BizPropertyInitializer.initialize(tjtIdouNyKh);

                BT_IdouKhMeigi idouKhMeigi = tjtIdouNyKh.createIdouKhMeigi();
                idouKhMeigi.setHhknnmkn(hhknSya.getHhknnmkn());
                if (C_KjkhukaKbn.KJKHUKA.eq(hhknSya.getHhknnmkjkhukakbn())) {
                    idouKhMeigi.setHhknnmkj("");
                }
                else {
                    idouKhMeigi.setHhknnmkj(hhknSya.getHhknnmkj());
                }
                idouKhMeigi.setHhknseiymd(hhknSya.getHhknseiymd());
                idouKhMeigi.setHhknsei(hhknSya.getHhknsei());
                idouKhMeigi.setHhknyno(hhknSya.getHhknyno());
                idouKhMeigi.setHhknadr1kj("");
                idouKhMeigi.setHhknadr2kj("");
                idouKhMeigi.setHhknadr3kj("");
                idouKhMeigi.setHhkntelno("");
                idouKhMeigi.setHhknsykgycd(kykKihon.getHhknsykgycd());
                if (C_Tdk.HONNIN.eq(kykSya.getKkkyktdk())) {
                    idouKhMeigi.setKyknmkn("");
                    idouKhMeigi.setKyknmkj("");
                    idouKhMeigi.setKykseiymd(null);
                }
                else {
                    idouKhMeigi.setKyknmkn(kykSya.getKyknmkn());
                    if (C_KjkhukaKbn.KJKHUKA.eq(kykSya.getKyknmkjkhukakbn())) {
                        idouKhMeigi.setKyknmkj("");
                    }
                    else {
                        idouKhMeigi.setKyknmkj(kykSya.getKyknmkj());
                    }
                    idouKhMeigi.setKykseiymd(kykSya.getKykseiymd());
                }
                idouKhMeigi.setNenkinuktnmkana("");
                idouKhMeigi.setNenkinuktnmkanji("");
                idouKhMeigi.setTsinyno(kykSya.getTsinyno());
                idouKhMeigi.setTsinadr1kj(kykSya.getTsinadr1kj());
                idouKhMeigi.setTsinadr2kj(kykSya.getTsinadr2kj());
                idouKhMeigi.setTsinadr3kj(kykSya.getTsinadr3kj());
                idouKhMeigi.setTsintelno(kykSya.getTsintelno());

                if (sbKykUktList.size() > 0) {
                    if (C_UktKbn.TOKUTEIMEIGI.eq(sbKykUktList.get(0).getUktkbn())) {
                        idouKhMeigi.setSbuktnmkn1(sbKykUktList.get(0).getUktnmkn());
                        if (C_KjkhukaKbn.KJKHUKA.eq(sbKykUktList.get(0).getUktnmkjkhukakbn())) {
                            idouKhMeigi.setSbuktnmkj1("");
                        }
                        else {
                            idouKhMeigi.setSbuktnmkj1(sbKykUktList.get(0).getUktnmkj());
                        }
                    }
                    else {
                        idouKhMeigi.setSbuktnmkn1("");
                        idouKhMeigi.setSbuktnmkj1("");
                    }
                }
                else {
                    idouKhMeigi.setSbuktnmkn1("");
                    idouKhMeigi.setSbuktnmkj1("");
                }

                if (sbKykUktList.size() > 1) {
                    idouKhMeigi.setSbuktnmkn2(sbKykUktList.get(1).getUktnmkn());
                    if (C_KjkhukaKbn.KJKHUKA.eq(sbKykUktList.get(1).getUktnmkjkhukakbn())) {
                        idouKhMeigi.setSbuktnmkj2("");
                    }
                    else {
                        idouKhMeigi.setSbuktnmkj2(sbKykUktList.get(1).getUktnmkj());
                    }
                }
                else {
                    idouKhMeigi.setSbuktnmkn2("");
                    idouKhMeigi.setSbuktnmkj2("");
                }

                if (sbKykUktList.size() > 2) {
                    idouKhMeigi.setSbuktnmkn3(sbKykUktList.get(2).getUktnmkn());
                    if (C_KjkhukaKbn.KJKHUKA.eq(sbKykUktList.get(2).getUktnmkjkhukakbn())) {
                        idouKhMeigi.setSbuktnmkj3("");
                    }
                    else {
                        idouKhMeigi.setSbuktnmkj3(sbKykUktList.get(2).getUktnmkj());
                    }
                }
                else {
                    idouKhMeigi.setSbuktnmkn3("");
                    idouKhMeigi.setSbuktnmkj3("");
                }

                if (sbKykUktList.size() > 3) {
                    idouKhMeigi.setSbuktnmkn4(sbKykUktList.get(3).getUktnmkn());
                    if (C_KjkhukaKbn.KJKHUKA.eq(sbKykUktList.get(3).getUktnmkjkhukakbn())) {
                        idouKhMeigi.setSbuktnmkj4("");
                    }
                    else {
                        idouKhMeigi.setSbuktnmkj4(sbKykUktList.get(3).getUktnmkj());
                    }
                }
                else {
                    idouKhMeigi.setSbuktnmkn4("");
                    idouKhMeigi.setSbuktnmkj4("");
                }

                if (stKykUktList.size() > 0) {
                    if (C_UktKbn.TOKUTEIMEIGI.eq(stKykUktList.get(0).getUktkbn())) {
                        idouKhMeigi.setStdrsknmkn(stKykUktList.get(0).getUktnmkn());
                        if (C_KjkhukaKbn.KJKHUKA.eq(stKykUktList.get(0).getUktnmkjkhukakbn())) {
                            idouKhMeigi.setStdrsknmkj("");
                        }
                        else {
                            idouKhMeigi.setStdrsknmkj(stKykUktList.get(0).getUktnmkj());
                        }
                    }
                    else {
                        idouKhMeigi.setStdrsknmkn("");
                        idouKhMeigi.setStdrsknmkj("");
                    }
                }
                else {
                    idouKhMeigi.setStdrsknmkn("");
                    idouKhMeigi.setStdrsknmkj("");
                }
                idouKhMeigi.setKzmeiginmkn("");

                if (kykdrKykUktList.size() > 0) {

                    if (C_UktKbn.TOKUTEIMEIGI.eq(kykdrKykUktList.get(0).getUktkbn())) {

                        idouKhMeigi.setKykdairinmkn(kykdrKykUktList.get(0).getUktnmkn());

                        if (C_KjkhukaKbn.KJKHUKA.eq(kykdrKykUktList.get(0).getUktnmkjkhukakbn())) {

                            idouKhMeigi.setKykdairinmkj("");
                        }
                        else {

                            idouKhMeigi.setKykdairinmkj(kykdrKykUktList.get(0).getUktnmkj());
                        }
                    }
                    else {

                        idouKhMeigi.setKykdairinmkn("");
                        idouKhMeigi.setKykdairinmkj("");
                    }
                }
                else {

                    idouKhMeigi.setKykdairinmkn("");
                    idouKhMeigi.setKykdairinmkj("");
                }

                idouKhMeigi.setKzktourokunmkn1(kzktourokunmKn1);
                idouKhMeigi.setKzktourokunmkj1(kzktourokunmKj1);
                idouKhMeigi.setKzktourokunmkn2(kzktourokunmKn2);
                idouKhMeigi.setKzktourokunmkj2(kzktourokunmKj2);

                BizPropertyInitializer.initialize(idouKhMeigi);

                BT_IdouKhBosyuudr idouKhBosyuudr = tjtIdouNyKh.createIdouKhBosyuudr();
                String  dairitenCd1 = "";
                BizNumber bunWari1 = BizNumber.ZERO;
                String  dairitenCd2 = "";
                BizNumber bunWari2 = BizNumber.ZERO;
                String kanriSosikiCd1 = "";
                String kanriSosikiCd2 = "";
                if (kykDairitenList.size() == 1) {
                    dairitenCd1 = kykDairitenList.get(0).getDrtencd();
                    bunWari1 = kykDairitenList.get(0).getBunwari();
                    dairitenCd2 = "";
                    bunWari2 = BizNumber.ZERO;
                    kanriSosikiCd1 = kykDairitenList.get(0).getDrtenkanrisosikicd();
                    kanriSosikiCd2 = "";
                }
                else if (kykDairitenList.size() == 2) {

                    bzGetTuukeiBunwari.exec(kykDairitenList.get(0).getDrtencd(),
                        kykDairitenList.get(0).getOyadrtencd(),
                        kykDairitenList.get(0).getBunwari(),
                        kykDairitenList.get(1).getDrtencd(),
                        kykDairitenList.get(1).getOyadrtencd(),
                        kykDairitenList.get(1).getBunwari(),
                        kykKihon.getSeirituymd().getBizDateYM(),
                        syouhnZokusei.getDrtsyouhinsikibetukbn(),
                        kykKihon.getHrkkaisuu(),
                        C_DiritenplannmKbn.BLNK);

                    if (C_ErrorKbn.ERROR.eq(bzGetTuukeiBunwari.getErrorKbn())) {
                        missListOutKensuu = editMissList((int) missListOutKensuu, syoNo,
                            C_Dbhanei.NONE, editKhMisslstParamLst, MessageId.EIA1055);

                        detach();

                        continue;
                    }
                    dairitenCd1 = bzGetTuukeiBunwari.getDrtencd1();
                    bunWari1 = bzGetTuukeiBunwari.getBuntanWariai1();
                    dairitenCd2 = bzGetTuukeiBunwari.getDrtencd2();
                    bunWari2 = bzGetTuukeiBunwari.getBuntanWariai2();
                    kanriSosikiCd1 = kykDairitenList.get(0).getDrtenkanrisosikicd();
                    kanriSosikiCd2 = kykDairitenList.get(1).getDrtenkanrisosikicd();
                }
                idouKhBosyuudr.setDairitencd1(dairitenCd1);
                idouKhBosyuudr.setBunwari1(bunWari1);
                idouKhBosyuudr.setDairitencd2(dairitenCd2);
                idouKhBosyuudr.setBunwari2(bunWari2);
                idouKhBosyuudr.setKanrisosikicd1(kanriSosikiCd1);
                idouKhBosyuudr.setKanrisosikicd2(kanriSosikiCd2);
                BizPropertyInitializer.initialize(idouKhBosyuudr);

                multipleEntityInserter.add(tjtIdouNyKh);

                BT_YendthnkSikinIdouData yendthnkSikinIdouData = new BT_YendthnkSikinIdouData();
                yendthnkSikinIdouData.setSyono(syoNo);
                yendthnkSikinIdouData.setKeiriyendthnkkbn(C_KeiriyendthnkKbn.HENKOU);
                yendthnkSikinIdouData.setSyoriYmd(syoriYmd);
                yendthnkSikinIdouData.setSyouhncd(henkoumaeKykSyouhn.getSyouhncd());
                yendthnkSikinIdouData.setSyouhnsdno(henkoumaeKykSyouhn.getSyouhnsdno());
                yendthnkSikinIdouData.setSiteituuka(khMkhgkTttYendtHnkBean.getKyktuukasyu());
                yendthnkSikinIdouData.setSiteituukagk(khMkhgkTttYendtHnkBean.getYendthnkkaiyakuhrgaika());
                yendthnkSikinIdouData.setTrhktuuka(khMkhgkTttYendtHnkBean.getNewkyktuukasyu());
                yendthnkSikinIdouData.setTrhktuukagk(khMkhgkTttYendtHnkBean.getYendthnkkaiyakuhryen());
                BizPropertyInitializer.initialize(yendthnkSikinIdouData);
                multipleEntityInserter.add(yendthnkSikinIdouData);

                if (khMkhgkTttYendtHnkBean.getYendthnkhr().compareTo(ZERO) > 0) {
                    BizCurrency synyknGk = ZERO;
                    BizCurrency htyKeihi = ZERO;
                    BizCurrency yenShrKykHtyKeihi = ZERO;
                    int kykHnkKaisuu = 0;
                    C_YouhiKbn missListSakuseiYh = C_YouhiKbn.HUYOU;
                    C_HtsiryosyuKbn shrtysysyuruiKbn = C_HtsiryosyuKbn.BLNK;

                    IT_KhHenreikin khHenreikin = kykKihon.createKhHenreikin();
                    khHenreikin.setHenkousikibetukey(henkouSikibetukey);
                    khHenreikin.setHrsyuruikbn(C_HrsyuruiKbn.YENDTHNKHENREI);
                    khHenreikin.setHrhsiymd(khMkhgkTttYendtHnkBean.getYendthnkymd());
                    khHenreikin.setHrhsisyoriymd(syoriYmd);
                    khHenreikin.setHenreikingk(khMkhgkTttYendtHnkBean.getYendthnkhr());
                    khHenreikin.setHrsiharaijyoutaikbn(C_Siharaijyoutaikbn.MBR);
                    khHenreikin.setSeg1cd(yendtbfrSeg1cd);
                    khHenreikin.setSeg2cd(yendtbfrSeg2cd);
                    khHenreikin.setTantocd(C_TantouCdKbn.DAIRITENJIMUHOZEN);
                    khHenreikin.setGyoumuKousinKinou(khozenCommonParam.getFunctionId());
                    khHenreikin.setGyoumuKousinsyaId(khozenCommonParam.getUserID());
                    khHenreikin.setGyoumuKousinTime(sysDateTimeMilli);
                    BizPropertyInitializer.initialize(khHenreikin);

                    synyknGk = khMkhgkTttYendtHnkBean.getYendthnkhr();
                    keisanHtyKeihi.exec(syoNo, khMkhgkTttYendtHnkBean.getKyktuukasyu());
                    BizCurrency htyKeihiHanteiYou = keisanHtyKeihi.getYenHtyKeihi();
                    if (synyknGk.compareTo(htyKeihiHanteiYou) >= 0) {
                        htyKeihi = htyKeihiHanteiYou;
                    }
                    else {
                        htyKeihi = synyknGk;
                    }
                    kykHnkKaisuu = keisanHtyKeihi.getKykSyaHenkouKaisuu();
                    BizCurrency yenGenKykSyaHtyKeihi = keisanHtyKeihi.getYenGenKykSyaHtyKeihi();
                    if (kykHnkKaisuu > 0) {
                        if (synyknGk.compareTo(yenGenKykSyaHtyKeihi) >= 0) {
                            yenShrKykHtyKeihi = yenGenKykSyaHtyKeihi;
                        }
                        else {
                            yenShrKykHtyKeihi = synyknGk;
                        }
                    }
                    else {
                        yenShrKykHtyKeihi = ZERO;
                    }

                    if (synyknGk.compareTo(BizCurrency.valueOf(1000000)) > 0 &&
                        (kykHnkKaisuu > 0 ||
                            (kykHnkKaisuu == 0 &&
                            (synyknGk.subtract(htyKeihi).compareTo(ZERO) > 0)))) {

                        shrtysysyuruiKbn = C_HtsiryosyuKbn.ITJKNSHRTYOUSYO;
                        missListSakuseiYh = C_YouhiKbn.YOU;
                    }

                    IT_KhHasseijiKazeiRireki khHasseijiKazeiRireki = khTtdkRireki.createKhHasseijiKazeiRireki();
                    khHasseijiKazeiRireki.setSyoriYmd(syoriYmd);
                    khHasseijiKazeiRireki.setHasseijikazeisyorikbn(C_HasseijikazeisyoriKbn.MKHGKTTTYENDTHNK);
                    khHasseijiKazeiRireki.setTorikesiflg(C_UmuKbn.NONE);
                    khHasseijiKazeiRireki.setKouryokuhasseiymd(khMkhgkTttYendtHnkBean.getYendthnkymd());
                    khHasseijiKazeiRireki.setGsbunritaisyou(C_UmuKbn.NONE);
                    khHasseijiKazeiRireki.setHasseijikngksyuruikbn(C_HasseijikngksyuruiKbn.YENDTHNKHR);
                    khHasseijiKazeiRireki.setHasseijikngk(khMkhgkTttYendtHnkBean.getYendthnkhr());
                    khHasseijiKazeiRireki.setHasseijigstszeigk(ZERO);
                    khHasseijiKazeiRireki.setYenkansangkgoukei(ZERO);
                    khHasseijiKazeiRireki.setYenkansansyukngkgoukei(synyknGk);
                    khHasseijiKazeiRireki.setYengstszeigk(ZERO);
                    khHasseijiKazeiRireki.setYengstszeigknationaltax(ZERO);
                    khHasseijiKazeiRireki.setYengstszeigklocaltax(ZERO);
                    khHasseijiKazeiRireki.setHtykeihi(ZERO);
                    khHasseijiKazeiRireki.setKztgk(ZERO);
                    khHasseijiKazeiRireki.setYenhtykeihi(htyKeihi);
                    khHasseijiKazeiRireki.setYenkztgk(ZERO);
                    khHasseijiKazeiRireki.setKyknmkn(khMkhgkTttYendtHnkBean.getKyknmkn());
                    khHasseijiKazeiRireki.setKyknmkj(khMkhgkTttYendtHnkBean.getKyknmkj());
                    khHasseijiKazeiRireki.setKykyno(khMkhgkTttYendtHnkBean.getTsinyno());
                    khHasseijiKazeiRireki.setKykadr1kj(khMkhgkTttYendtHnkBean.getTsinadr1kj());
                    khHasseijiKazeiRireki.setKykadr2kj(khMkhgkTttYendtHnkBean.getTsinadr2kj());
                    khHasseijiKazeiRireki.setKykadr3kj(khMkhgkTttYendtHnkBean.getTsinadr3kj());
                    khHasseijiKazeiRireki.setShrtysysyuruikbn(shrtysysyuruiKbn);
                    khHasseijiKazeiRireki.setYenshrkykhtykeihi(yenShrKykHtyKeihi);
                    khHasseijiKazeiRireki.setKykhnkkaisuu(kykHnkKaisuu);
                    khHasseijiKazeiRireki.setGyoumuKousinKinou(khozenCommonParam.getFunctionId());
                    khHasseijiKazeiRireki.setGyoumuKousinsyaId(khozenCommonParam.getUserID());
                    khHasseijiKazeiRireki.setGyoumuKousinTime(sysDateTimeMilli);
                    BizPropertyInitializer.initialize(khHasseijiKazeiRireki);

                    if (C_YouhiKbn.YOU.eq(missListSakuseiYh)) {
                        missListOutKensuu = editMissList((int) missListOutKensuu, syoNo,
                            C_Dbhanei.SUMI, editKhMisslstParamLst, MessageId.EIA1056);
                    }
                    if (htyKeihi.compareTo(ZERO) > 0) {
                        Integer renMaxNo = hozenDomManager.getKihrkmpSeisanRirekiMaxRennoBySyono(syoNo);
                        if (renMaxNo != null) {
                            renMaxNo = renMaxNo + 1;
                        }
                        else {
                            renMaxNo = 1;
                        }

                        IT_KihrkmpSeisanRireki kihrkmpSeisanRireki = kykKihon.createKihrkmpSeisanRireki();
                        kihrkmpSeisanRireki.setRenno(renMaxNo);
                        kihrkmpSeisanRireki.setHenkousikibetukey(henkouSikibetukey);
                        kihrkmpSeisanRireki.setKouryokuhasseiymd(khMkhgkTttYendtHnkBean.getYendthnkymd());
                        kihrkmpSeisanRireki.setKihrkpssnaiyoukbn(C_KiharaiPseisanNaiyouKbn.HENKANKIN);
                        kihrkmpSeisanRireki.setSeijyutoukaisuum(0);
                        kihrkmpSeisanRireki.setMisyuumikeikakbn(C_MisyuumikeikaKbn.BLNK);
                        kihrkmpSeisanRireki.setRstuukasyu(C_Tuukasyu.BLNK);
                        kihrkmpSeisanRireki.setSeisanpgoukei(ZERO);
                        kihrkmpSeisanRireki.setYenkansansspgoukei(ZERO);
                        kihrkmpSeisanRireki.setHenkank(ZERO);
                        kihrkmpSeisanRireki.setYenkansanhenkankin(htyKeihi);
                        kihrkmpSeisanRireki.setTuityouk(ZERO);
                        kihrkmpSeisanRireki.setYenkansantuityoukin(ZERO);
                        kihrkmpSeisanRireki.setGyoumuKousinKinou(khozenCommonParam.getFunctionId());
                        kihrkmpSeisanRireki.setGyoumuKousinsyaId(khozenCommonParam.getUserID());
                        kihrkmpSeisanRireki.setGyoumuKousinTime(sysDateTimeMilli);
                        kihrkmpSeisanRireki.setHituyoukeihiitijisytktysgk(ZERO);
                        BizPropertyInitializer.initialize(kihrkmpSeisanRireki);
                    }
                }
                hozenDomManager.flush();
                EditTtdkRirekiTblParam editTtdkRirekiTblParam = SWAKInjector.getInstance(EditTtdkRirekiTblParam.class);

                C_SyoriKbn syoriKbn = C_SyoriKbn.BLNK;

                if (C_UktkSyoriKbn.MKHGKTTTYENDTHNK.eq(khMkhgkTttYendtHnkBean.getUktkSyoriKbn())) {
                    syoriKbn = C_SyoriKbn.YENDTHNK_MKHGKTTT;
                }
                else if (C_UktkSyoriKbn.NINISEIKYUU.eq(khMkhgkTttYendtHnkBean.getUktkSyoriKbn())) {
                    syoriKbn = C_SyoriKbn.YENDTHNK_NINISEIKYUU;
                }

                editTtdkRirekiTblParam.setCommonParam(khozenCommonParam);
                editTtdkRirekiTblParam.setSyoNo(syoNo);
                editTtdkRirekiTblParam.setSyoriYmd(syoriYmd);
                editTtdkRirekiTblParam.setSyoriKbn(syoriKbn);
                editTtdkRirekiTblParam.setHenkouRrkYouhi(C_YouhiKbn.YOU);
                editTtdkRirekiTblParam.setSysTime(sysDateTimeMilli);
                editTtdkRirekiTbl.exec(editTtdkRirekiTblParam);

                DBAccessDCommonYendtHnk dBAccessDCommonYendtHnk = getInjectInstanceForInLoop(DBAccessDCommonYendtHnk.class);

                dBAccessDCommonYendtHnk.insertHaitouInfo(syoNo,
                    khMkhgkTttYendtHnkBean.getYendthnkymd(), keisanDCommonYendtHnk.getD(),
                    keisanDCommonYendtHnk.getKariwariatedruigk(), keisanDCommonYendtHnk.getTumitated(),
                    keisanDCommonYendtHnk.getDNaiteiKakuteiKbn(), keisanDCommonYendtHnk.getHaitouNendo(),
                    keisanDCommonYendtHnk.getKeyInfoKhHaitouKanriBean(),
                    keisanDCommonYendtHnk.getKeyInfoKhTumitateDKanriBean(), khozenCommonParam);

                C_TetudukisyuKbn tetudukisyuKbn = C_TetudukisyuKbn.BLNK;

                if (C_UktkSyoriKbn.NINISEIKYUU.eq(khMkhgkTttYendtHnkBean.getUktkSyoriKbn())) {
                    if(C_MousideIkouKbn.YENNENKIN.eq(khMkhgkTttYendtHnkBean.getMousideikoukbn())){
                        tetudukisyuKbn = C_TetudukisyuKbn.YENDTHNKNINI_NEN;
                    }
                    else if(C_MousideIkouKbn.YENSYUUSIN.eq(khMkhgkTttYendtHnkBean.getMousideikoukbn())){
                        tetudukisyuKbn = C_TetudukisyuKbn.YENDTHNKNINI;
                    }
                }
                else if (C_UktkSyoriKbn.MKHGKTTTYENDTHNK.eq(khMkhgkTttYendtHnkBean.getUktkSyoriKbn())) {
                    if(C_MousideIkouKbn.YENNENKIN.eq(khMkhgkTttYendtHnkBean.getMousideikoukbn())){
                        tetudukisyuKbn = C_TetudukisyuKbn.MKHGKTTTYENDTHNK_NEN;
                    }
                    else if(C_MousideIkouKbn.YENSYUUSIN.eq(khMkhgkTttYendtHnkBean.getMousideikoukbn())){
                        tetudukisyuKbn = C_TetudukisyuKbn.MKHGKTTTYENDTHNK;
                    }
                }

                List<IT_KhTtdkRireki> khTtdkRirekiLst = kykKihon.getKhTtdkRirekisByGyoumuKousinKinou(
                    IKhozenCommonConstants.KINOUID_GENGAKU);

                C_UmuKbn gengkKeiiUmu = null;
                if (khTtdkRirekiLst.size() > 0) {
                    gengkKeiiUmu = C_UmuKbn.ARI;
                }
                else {
                    gengkKeiiUmu = C_UmuKbn.NONE;
                }

                C_SksmongonKbn sksmongonKbn = C_SksmongonKbn.BLNK;

                if (SyouhinUtil.GONENRISAHAITOUSITEITUUKASYUUSIN_ITIJIBR == syohinHanteiKbn) {
                    sksmongonKbn = C_SksmongonKbn.YENDTSYSN;
                }
                else {
                    sksmongonKbn = C_SksmongonKbn.BLNK;
                }

                C_SyoruiCdKbn syoruiCd = null;

                if (C_UktkSyoriKbn.NINISEIKYUU.eq(khMkhgkTttYendtHnkBean.getUktkSyoriKbn())) {
                    if (SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR == syohinHanteiKbn) {
                        syoruiCd = C_SyoruiCdKbn.KK_YENDTHNK_NINI_TTDKKR;
                    }
                    else if (SyouhinUtil.GONENRISAHAITOUSITEITUUKASYUUSIN_ITIJIBR_19 == syohinHanteiKbn) {
                        syoruiCd = C_SyoruiCdKbn.KK_YENDTHNK_NINI_TTDKKR_2;
                    }
                }
                else {
                    if (SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR == syohinHanteiKbn) {
                        syoruiCd = C_SyoruiCdKbn.KK_YENDTHNK_TTDKKR_2;
                    }
                    else if (SyouhinUtil.GONENRISAHAITOUSITEITUUKASYUUSIN_ITIJIBR == syohinHanteiKbn) {
                        if (khMkhgkTttYendtHnkBean.getYendthnkhr().compareTo(ZERO) > 0) {
                            syoruiCd = C_SyoruiCdKbn.KK_YENDTHNK_HNRKNSKS_TTDKKR;
                        }
                        else {
                            syoruiCd = C_SyoruiCdKbn.KK_YENDTHNK_TTDKKR;
                        }
                    }
                    else if (SyouhinUtil.GONENRISAHAITOUSITEITUUKASYUUSIN_ITIJIBR_19 == syohinHanteiKbn) {
                        syoruiCd = C_SyoruiCdKbn.KK_YENDTHNK_TTDKKR_3;
                    }
                }

                BizDate ryosyuYmd = nyknJissekiRireki.getRyosyuymd();

                GetKawaseRate getKawaseRate = SWAKInjector.getInstance(GetKawaseRate.class);

                C_ErrorKbn kekkaKbn = getKawaseRate.exec(
                    ryosyuYmd,
                    C_KawaserateSyuruiKbn.KOUJIKAWASERATE,
                    khMkhgkTttYendtHnkBean.getKyktuukasyu(),
                    C_Tuukasyu.JPY,
                    C_KawasetekiyoKbn.TTM,
                    C_KawasetsryKbn.NYUKINRATE,
                    C_EigyoubiHoseiKbn.YOKUEIGYOUBI,
                    C_YouhiKbn.HUYOU);

                if (C_ErrorKbn.ERROR.eq(kekkaKbn)) {
                    missListOutKensuu = editMissList((int) missListOutKensuu, syoNo,
                        C_Dbhanei.NONE, editKhMisslstParamLst, MessageId.EIA1057);

                    detach();

                    continue;

                }

                BizNumber nyknKwsRate = getKawaseRate.getKawaserate();

                String qrCd = null;

                if (khMkhgkTttYendtHnkBean.getYendthnkhr().compareTo(ZERO) > 0) {
                    HozenPreReportRenkeiBean hozenPreReportRenkeiBean = SWAKInjector.getInstance(HozenPreReportRenkeiBean.class);
                    hozenPreReportRenkeiBean.setSyoNo(syoNo);
                    hozenPreReportRenkeiBean.setSyoriComment("");
                    hozenPreReportRenkeiBean.setTaskNm(null);
                    hozenPreReportRenkeiBean.setSakuseizumiKouteikanriId(null);

                    KhHituyousyoruiHanteiInBean khHituyousyoruiHanteiInBean = SWAKInjector.getInstance(KhHituyousyoruiHanteiInBean.class);
                    khHituyousyoruiHanteiInBean.setJimutetuzukiCd(IKhozenCommonConstants.JIMUTETUZUKICD_KHYENDTHNKHRSHR);
                    khHituyousyoruiHanteiInBean.setHrkkeirohnkUmuKbn(C_UmuKbn.NONE);
                    khHituyousyoruiHanteiInBean.setHrkkaisuuhnkUmuKbn(C_UmuKbn.NONE);
                    khHituyousyoruiHanteiInBean.setDaisennintdkUmuKbn(C_UmuKbn.NONE);
                    khHituyousyoruiHanteiInBean.setTrhkjikakUmuKbn(C_UmuKbn.NONE);
                    khHituyousyoruiHanteiInBean.setHubidataUmu(C_Hubidataumu.NONE);
                    hozenPreReportRenkeiBean.setKhHituyousyoruiHanteiInBean(khHituyousyoruiHanteiInBean);

                    EditSeikyuusyoParam editSeikyuusyoParam = SWAKInjector.getInstance(EditSeikyuusyoParam.class);
                    editSeikyuusyoParam.setShrumu(C_UmuKbn.NONE);
                    editSeikyuusyoParam.setKhhrshrjiyuu(C_Khhrshrjiyuu.TUUJYOU);
                    editSeikyuusyoParam.setKhskssakuseijiyuu(C_Khskssakuseijiyuu.BLNK);

                    khozenTyouhyouCtl.setEditSeikyuusyoParam(editSeikyuusyoParam);
                    khozenTyouhyouCtl.setQrCodeYouhiKbn(C_YouhiKbn.YOU);

                    khozenTyouhyouCtl.createTyouhyouTBL(khozenCommonParam, syoNo,
                        new C_SyoruiCdKbn[]{C_SyoruiCdKbn.KK_YENDTHNKHNRKN_SKS}, C_YouhiKbn.YOU);
                    qrCd = khozenTyouhyouCtl.getQrCode();
                    String kouteikanriid = hozenPreReportRenkeiBean.getSakuseizumiKouteikanriId();

                    IW_KhYendtHnkHrShrWk khYendtHnkHrShrWk = new IW_KhYendtHnkHrShrWk();
                    khYendtHnkHrShrWk.setKouteikanriid(kouteikanriid);
                    khYendtHnkHrShrWk.setSyono(syoNo);
                    khYendtHnkHrShrWk.setSkssakuseiymd(syoriYmd);
                    khYendtHnkHrShrWk.setKhhrshrjiyuu(C_Khhrshrjiyuu.TUUJYOU);
                    khYendtHnkHrShrWk.setGyoumuKousinKinou(khozenCommonParam.getFunctionId());
                    khYendtHnkHrShrWk.setGyoumuKousinsyaId(khozenCommonParam.getUserID());
                    khYendtHnkHrShrWk.setGyoumuKousinTime(sysDateTimeMilli);
                    BizPropertyInitializer.initialize(khYendtHnkHrShrWk);
                    multipleEntityInserter.add(khYendtHnkHrShrWk);
                }

                EditTtdkKanryouParam editTtdkKanryouParam = SWAKInjector.getInstance(EditTtdkKanryouParam.class);
                editTtdkKanryouParam.setTetudukiSyu(tetudukisyuKbn);
                editTtdkKanryouParam.setSiharaiUmu(C_UmuKbn.NONE);
                editTtdkKanryouParam.setSyosaihkyouhi(C_SosysaiyouhiKbn.YOU);
                editTtdkKanryouParam.setSyokenDoufuUmu(C_UmuKbn.ARI);
                editTtdkKanryouParam.setCalckijyunYMD(yendtHnkKijyunDate);
                editTtdkKanryouParam.setKykniyuhnkymd(kykniyuhnkDate);
                editTtdkKanryouParam.setTargetTkKbn(khMkhgkTttYendtHnkBean.getTargettkkbn());
                editTtdkKanryouParam.setBfrTargettkmokuhyouti(khMkhgkTttYendtHnkBean.getTargettkmokuhyouti());
                editTtdkKanryouParam.setTmttknitenYmd(henkoumaeKykSyouhn.getTmttknitenymd());
                editTtdkKanryouParam.setGengakukeiiUmu(gengkKeiiUmu);
                editTtdkKanryouParam.setNyknKawaserate(nyknKwsRate);
                editTtdkKanryouParam.setYendtHnkjiKawaserate(khMkhgkTttYendtHnkBean.getYendthnkjikwsrate());
                editTtdkKanryouParam.setYendtHnkjikaiyakuhrGaika(khMkhgkTttYendtHnkBean.getYendthnkkaiyakuhrgaika());
                editTtdkKanryouParam.setYendtHnkjikaiyakuhrYen(khMkhgkTttYendtHnkBean.getYendthnkkaiyakuhryen());
                editTtdkKanryouParam.setYendthnkHr(khMkhgkTttYendtHnkBean.getYendthnkhr());
                editTtdkKanryouParam.setNewKaiyakuhr(khMkhgkTttYendtHnkBean.getNewkaiyakuhr());
                editTtdkKanryouParam.setDocumentId(qrCd);
                editTtdkKanryouParam.setHozonKikanY(hozonKikan);
                editTtdkKanryouParam.setSksmongonKbn1(sksmongonKbn);
                editTtdkKanryouParam.setBfrTuukasyu(khMkhgkTttYendtHnkBean.getKyktuukasyu());
                editTtdkKanryouParam.setBfrHrkP(khMkhgkTttYendtHnkBean.getHrkp());
                editTtdkKanryouParam.setBfrTargetTkKjnKngk(khMkhgkTttYendtHnkBean.getTargettkykkijyungk());

                EditHokenSyoukenParam editHokenSyoukenParam = SWAKInjector.getInstance(EditHokenSyoukenParam.class);
                editHokenSyoukenParam.setCalckijyunYMD(khMkhgkTttYendtHnkBean.getYendthnkymd());
                editHokenSyoukenParam.setHnskariyuu1(khMkhgkTttYendtHnkBean.getHnskariyuu1());
                editHokenSyoukenParam.setHnskariyuu2(khMkhgkTttYendtHnkBean.getHnskariyuu2());

                khozenTyouhyouCtl.setEditTtdkKanryouParam(editTtdkKanryouParam);
                khozenTyouhyouCtl.setEditHokenSyoukenParam(editHokenSyoukenParam);

                if (C_TourokuRouteKbn.BATCH.eq(khMkhgkTttYendtHnkBean.getTourokuroutekbn())) {
                    khozenTyouhyouCtl.setHassoukbn(C_HassouKbn.TYOKUSOU);
                } else {
                    khozenTyouhyouCtl.setHassoukbn(khMkhgkTttYendtHnkBean.getNyuuryokuhassoukbn());
                }

                khozenTyouhyouCtl.createTyouhyouTBL(khozenCommonParam, syoNo,
                    new C_SyoruiCdKbn[]{syoruiCd, C_SyoruiCdKbn.KK_HKNSYKN}, C_YouhiKbn.HUYOU);

                List<BzSiwakeMeisaiBean> bzSiwakeMeisaiBeanLst = Lists.newArrayList();
                BzSiwakeMeisaiBean bzSiwakeMeisaiBeanKari = SWAKInjector.getInstance(BzSiwakeMeisaiBean.class);
                bzSiwakeMeisaiBeanKari.setIbTaisyakukbn(C_TaisyakuKbn.KARIKATA);
                bzSiwakeMeisaiBeanKari.setIbKanjyoukmkcd(C_Kanjyoukmkcd.HOKA_SEGMENT_SISYUTU_V);
                bzSiwakeMeisaiBeanKari.setIbSuitoubumoncd(suitouBumonCd);
                bzSiwakeMeisaiBeanKari.setIbDenyenkagk(khMkhgkTttYendtHnkBean.getNewkaiyakuhr());
                bzSiwakeMeisaiBeanKari.setIbSeg1cd(yendtbfrSeg1cd);
                bzSiwakeMeisaiBeanKari.setIbSeg2cd(yendthnkSeg1cd);
                bzSiwakeMeisaiBeanLst.add(bzSiwakeMeisaiBeanKari);

                BzSiwakeMeisaiBean bzSiwakeMeisaiBeanKasi = SWAKInjector.getInstance(BzSiwakeMeisaiBean.class);
                bzSiwakeMeisaiBeanKasi.setIbTaisyakukbn(C_TaisyakuKbn.KASIKATA);
                bzSiwakeMeisaiBeanKasi.setIbKanjyoukmkcd(C_Kanjyoukmkcd.HOKA_SEGMENT_SYUUNYUU_V);
                bzSiwakeMeisaiBeanKasi.setIbSuitoubumoncd(suitouBumonCd);
                bzSiwakeMeisaiBeanKasi.setIbDenyenkagk(khMkhgkTttYendtHnkBean.getNewkaiyakuhr());
                bzSiwakeMeisaiBeanKasi.setIbSeg1cd(yendthnkSeg1cd);
                bzSiwakeMeisaiBeanKasi.setIbSeg2cd(yendtbfrSeg1cd);
                bzSiwakeMeisaiBeanLst.add(bzSiwakeMeisaiBeanKasi);

                BizDate denpyouYmd = syoriYmd.addBusinessDays(1);
                BizDate syoriYmdYokuJitsu = syoriYmd.getNextDay();

                if (syoriYmdYokuJitsu.isHoliday()) {

                    if (BizDateUtil.compareYmdByYm(syoriYmdYokuJitsu, denpyouYmd) == BizDateUtil.COMPARE_LESSER ) {
                        denpyouYmd = denpyouYmd.addBusinessDays(-1);
                    }
                }

                BzDenpyouDataTourokuBean bzDenpyouDataTourokuBean = SWAKInjector.getInstance(BzDenpyouDataTourokuBean.class);
                bzDenpyouDataTourokuBean.setIbSyono(syoNo);
                bzDenpyouDataTourokuBean.setIbHuridenatesakicd(huriDenatesakiCd);
                bzDenpyouDataTourokuBean.setIbTantocd(C_TantouCdKbn.DAIRITENJIMUHOZEN);
                bzDenpyouDataTourokuBean.setIbDenymd(denpyouYmd);
                bzDenpyouDataTourokuBean.setIbTuukasyu(C_Tuukasyu.JPY);
                bzDenpyouDataTourokuBean.setIbSyoriymd(syoriYmd);
                bzDenpyouDataTourokuBean.setIbSyoricd(kinou.getSyoricd());
                bzDenpyouDataTourokuBean.setIbSyorisosikicd(syoriSosikiCd);
                bzDenpyouDataTourokuBean.setIbGyoumuKousinsyaId(khozenCommonParam.getUserID());
                bzDenpyouDataTourokuBean.setIbKakokawaserateshiteiflg(false);
                bzDenpyouDataTourokuBean.setBzSiwakeMeisaiBeanList(bzSiwakeMeisaiBeanLst);

                List<IT_KhDenpyoData> khDenpyoDataLst = bzDenpyouDataSks.execKh(bzDenpyouDataTourokuBean);
                for (IT_KhDenpyoData khDenpyoData : khDenpyoDataLst) {
                    hozenDomManager.insert(khDenpyoData);
                }

                IT_KhHenkouUktk khHenkouUktk = hozenDomManager.getKhHenkouUktk(syoNo,
                    khMkhgkTttYendtHnkBean.getHozenhenkouuktkrenno());
                khHenkouUktk.setUktkjyoutaikbn(C_UktkJyoutaiKbn.SYORIZUMI);
                khHenkouUktk.setGyoumuKousinKinou(khozenCommonParam.getFunctionId());
                khHenkouUktk.setGyoumuKousinsyaId(khozenCommonParam.getUserID());
                khHenkouUktk.setGyoumuKousinTime(sysDateTimeMilli);
                multipleEntityUpdater.add(khHenkouUktk);
                multipleEntityUpdater.add(kykKihon);

                if (C_UktkSyoriKbn.MKHGKTTTYENDTHNK.eq(khMkhgkTttYendtHnkBean.getUktkSyoriKbn())) {
                    khHnkukeKousinKensuuMkhgkTtt = khHnkukeKousinKensuuMkhgkTtt + 1;
                }
                else if (C_UktkSyoriKbn.NINISEIKYUU.eq(khMkhgkTttYendtHnkBean.getUktkSyoriKbn())) {
                    khHnkukeKousinKensuuNnsky = khHnkukeKousinKensuuNnsky + 1;
                }

                detach();
            }
            if (editKhMisslstParamLst.size() > 0) {
                khozenTyouhyouCtl.setEditKkMisslstParam(editKhMisslstParamLst);

                C_SyoruiCdKbn[] syoruiCdKbnLst = new C_SyoruiCdKbn[1];

                syoruiCdKbnLst[0] = C_SyoruiCdKbn.KK_YENDTHNK_MISSLIST;

                khozenTyouhyouCtl.createTyouhyouTBL(khozenCommonParam, syoruiCdKbnLst, C_YouhiKbn.YOU);
            }
        }
        bzRecoveryDatasikibetuBean.initializeBlank();

        batchLogger.info(MessageUtil.getMessage(MessageId.IBF0020, String.valueOf(yendtHnkTaisyouInKensuu)));
        batchLogger.info(MessageUtil.getMessage(MessageId.IBF0002, String.valueOf(khHnkukeKousinKensuuMkhgkTtt), "目標額到達時"));
        batchLogger.info(MessageUtil.getMessage(MessageId.IBF0002, String.valueOf(khHnkukeKousinKensuuNnsky), "任意請求"));

        batchLogger.info(MessageUtil.getMessage(MessageId.IBC1026, String.valueOf(heisoukbn)));
    }

    private int editMissList(int pMissListOutKensuu, String pSyono, C_Dbhanei pDbhanei, List<EditKhMisslstParam> pEditKhMisslistParam,
        String pMissListMessageId, String... pMissListMessageParam) {

        int missListOutKensuu = pMissListOutKensuu + 1;

        String misslistMsg = MessageUtil.getMessage(pMissListMessageId, pMissListMessageParam);

        EditKhMisslstParam editKhMisslistParam = SWAKInjector.getInstance(EditKhMisslstParam.class);

        editKhMisslistParam.setDataNo(missListOutKensuu);
        editKhMisslistParam.setSeqNo(missListOutKensuu);
        editKhMisslistParam.setSyoNo(pSyono);
        editKhMisslistParam.setDBhaneikbn(pDbhanei);
        editKhMisslistParam.setMisslistMsg(misslistMsg);

        pEditKhMisslistParam.add(editKhMisslistParam);
        return missListOutKensuu;
    }

    private <T> T getInjectInstanceForInLoop(Class<T> pType) {
        T t = SWAKInjector.getInstance(pType);
        if (t instanceof HaitouDetachProcess) {
            haitouDetachProcessInLoopSet.add((HaitouDetachProcess) t);
        }
        return t;
    }

    private <T> T getInjectInstanceForOutLoop(Class<T> pType) {
        T t = SWAKInjector.getInstance(pType);
        if (t instanceof HaitouDetachProcess) {
            haitouDetachProcessOutLoopSet.add((HaitouDetachProcess) t);
        }
        return t;
    }

    private void detach() {
        for (HaitouDetachProcess haitouDetachProcess : haitouDetachProcessInLoopSet) {
            haitouDetachProcess.detach();
        }
        for (HaitouDetachProcess haitouDetachProcess : haitouDetachProcessOutLoopSet) {
            haitouDetachProcess.detach();
        }
        haitouDetachProcessInLoopSet = new HashSet<HaitouDetachProcess>();
    }

    @AppBatchExceptionTerminate
    private void appBatchExceptionTerminate() {

        BzBatchAbendCommonRecovery bzBatchAbendCommonRecovery =
            SWAKInjector.getInstance(BzBatchAbendCommonRecovery.class);
        bzBatchAbendCommonRecovery.exec();
    }
}
