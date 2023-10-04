package yuyu.batch.sinkeiyaku.sknyuukin.skhurikominyuukin;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.batch.annotation.AppBatchExceptionTerminate;
import jp.co.slcs.swak.batch.annotation.Execute;
import jp.co.slcs.swak.bizinfr.exception.BizAppException;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.db.EntityInserter;
import jp.co.slcs.swak.db.EntityUpdater;
import jp.co.slcs.swak.db.ExDBUpdatableResults;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.util.message.MessageUtil;
import yuyu.batch.sinkeiyaku.sknyuukin.skhurikominyuukin.dba.SkHurikomiNyuukinDao;
import yuyu.common.biz.bzcommon.BizDateUtil;
import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.common.biz.bzcommon.BzBatchAbendCommonRecovery;
import yuyu.common.biz.bzcommon.BzProcessUpdateForBatchInputBean;
import yuyu.common.biz.bzcommon.GetKawaseRate;
import yuyu.common.biz.bzcommon.HenkanTuuka;
import yuyu.common.biz.bzcommon.KeisanGaikakanzan;
import yuyu.common.biz.exception.CommonBizAppException;
import yuyu.common.biz.kaikei.BzDenpyouDataSks;
import yuyu.common.biz.kaikei.BzSegmentCdSyutoku;
import yuyu.common.biz.kaikei.BzSinkeiyakuDenpyouDataTourokuBean;
import yuyu.common.biz.kaikei.BzSiwakeMeisaiBean;
import yuyu.common.biz.kaikei.SyouhinbetuSegmentBean;
import yuyu.common.biz.koutei.BzGetProcessSummary;
import yuyu.common.biz.koutei.BzGetProcessSummaryInBean;
import yuyu.common.biz.koutei.BzGetProcessSummaryOutBean;
import yuyu.common.sinkeiyaku.koutei.SkProcessForwardForBatchInBean;
import yuyu.common.sinkeiyaku.koutei.SkProcessForwardHurikomiNyuukin;
import yuyu.common.sinkeiyaku.koutei.SkProcessUpdate;
import yuyu.common.sinkeiyaku.moschk.MosnaiCheck;
import yuyu.common.sinkeiyaku.moschk.MosnaiCheckParam;
import yuyu.common.sinkeiyaku.skcommon.ISkCommonKoumoku;
import yuyu.common.sinkeiyaku.skcommon.SkIdounaiyouBeforeBean;
import yuyu.common.sinkeiyaku.skcommon.SkToujituIdounaiyouEdit;
import yuyu.def.MessageId;
import yuyu.def.biz.bean.param.BzRecoveryDatasikibetuBean;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_DensyoriKbn;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_HasuusyoriKbn;
import yuyu.def.classification.C_HenkinriyuuKbn;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_Hrkkeiro;
import yuyu.def.classification.C_Kanjyoukmkcd;
import yuyu.def.classification.C_KessantyouseiKbn;
import yuyu.def.classification.C_KetteiyouhiKbn;
import yuyu.def.classification.C_Kouteikanristatus;
import yuyu.def.classification.C_NaibuKeiyakuKbn;
import yuyu.def.classification.C_NyknsyubetuKbn;
import yuyu.def.classification.C_Sdpd;
import yuyu.def.classification.C_Segcd;
import yuyu.def.classification.C_SeirituKbn;
import yuyu.def.classification.C_ShrhousiteiKbn;
import yuyu.def.classification.C_Syorizumiflg;
import yuyu.def.classification.C_SysKbn;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.classification.C_TaisyakuKbn;
import yuyu.def.classification.C_TantouCdKbn;
import yuyu.def.classification.C_TekiyouKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_YouhiKbn;
import yuyu.def.classification.C_ZenhnknKbn;
import yuyu.def.db.entity.AS_Kinou;
import yuyu.def.db.entity.BT_GyoumuKouteiInfo;
import yuyu.def.db.entity.BT_TjtIdouNySk;
import yuyu.def.db.entity.HT_MosDairiten;
import yuyu.def.db.entity.HT_MosKihon;
import yuyu.def.db.entity.HT_MosSyouhn;
import yuyu.def.db.entity.HT_MosnoKanri;
import yuyu.def.db.entity.HT_Nyuukin;
import yuyu.def.db.entity.HT_SkDenpyoData;
import yuyu.def.db.entity.HT_SkHubi;
import yuyu.def.db.entity.HT_SkHubiDetail;
import yuyu.def.db.entity.HT_SyoriCTL;
import yuyu.def.db.entity.HW_HrkmNyknTaisyouWk;
import yuyu.def.sinkeiyaku.configuration.YuyuSinkeiyakuConfig;
import yuyu.def.sinkeiyaku.manager.SinkeiyakuDomManager;
import yuyu.def.sinkeiyaku.sorter.SortHT_Nyuukin;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.BatchParam;
import yuyu.infr.batch.logger.BatchLogger;

/**
 * 新契約 入金 振込入金処理
 */
public class SkHurikomiNyuukinBatch implements Batch {

    private static final String TYSYTTAISYOUTABLEID = "HW_HrkmNyknTaisyouWk";

    private static final String RECOVERYFILTERID = "Sk001";

    private static final String TASKNM = "振込入金処理";

    @Inject
    private BatchLogger batchLogger;

    @Inject
    private SinkeiyakuDomManager sinkeiyakuDomManager;

    @Inject
    private BizDomManager bizDomManager;

    @Inject
    private AS_Kinou kinou;

    @Inject
    private BzRecoveryDatasikibetuBean bzRecoveryDatasikibetuBean;


    @Inject
    private SkHurikomiNyuukinBatchParam skHurikomiNyuukinBatchParam;

    @Inject
    private SkHurikomiNyuukinDao skHurikomiNyuukinDao;

    @Override
    public BatchParam getParam() {
        return skHurikomiNyuukinBatchParam;
    }

    @Execute
    @Transactional
    public void execute() {

        BizDate syoriYmd = skHurikomiNyuukinBatchParam.getSyoriYmd();
        String kakutyouJobCd = skHurikomiNyuukinBatchParam.getIbKakutyoujobcd();
        int maxsyoriKensuu = skHurikomiNyuukinBatchParam.getMaxsyoricnt();
        long syoriKensuu = 0;
        boolean zanariFlg = false;

        batchLogger.info(MessageUtil.getMessage(
            MessageId.IBA0016, MessageUtil.getMessage(MessageId.IBW0003), String.valueOf(syoriYmd)));
        batchLogger.info(MessageUtil.getMessage(
            MessageId.IBA0016, MessageUtil.getMessage(MessageId.IBW1018), String.valueOf(kakutyouJobCd)));
        batchLogger.info(MessageUtil.getMessage(
            MessageId.IBA0016, "最大処理件数", String.valueOf(maxsyoriKensuu)));

        try (ExDBUpdatableResults<HW_HrkmNyknTaisyouWk> hrkmNyknTaisyouWkLst =
            skHurikomiNyuukinDao.getHrkmNyknTaisyouWksByKakutyoujobcd(kakutyouJobCd);
            EntityUpdater<BT_GyoumuKouteiInfo> gmKtInfoEntityUpdater = new EntityUpdater<>();
            EntityUpdater<HT_SyoriCTL> syoriCTLEntityUpdater = new EntityUpdater<>();
            EntityUpdater<HT_MosnoKanri> mosnoKanriEntityUpdater = new EntityUpdater<>();
            EntityInserter<BT_TjtIdouNySk> tjtIdouNySkEntityInserter = new EntityInserter<>();
            EntityInserter<HT_SkDenpyoData> skDenpyoEntityInserter = new EntityInserter<>()) {

            String mosno = "";
            SkToujituIdounaiyouEdit skTjtuIdounaiyouEdit = null;
            HT_SyoriCTL syoriCTL = null;
            HT_MosKihon mosKihon = null;
            HT_MosDairiten mosDairiten = null;
            List<HT_MosSyouhn> mosSyouhnLst = null;
            HT_MosSyouhn mosSyouhn = null;
            List<HT_Nyuukin> nyuukinLst = null;
            SortHT_Nyuukin nyuukinSort = SWAKInjector.getInstance(SortHT_Nyuukin.class);
            Integer nyukinMaxNo;
            BzGetProcessSummary bzGetProcessSummary = SWAKInjector.getInstance(BzGetProcessSummary.class);
            BzGetProcessSummaryInBean bzGetProcessSummaryInBean = null;
            BT_GyoumuKouteiInfo gyoumuKouteiInfo = null;
            HT_Nyuukin nyuukin = null;
            MosnaiCheckParam mosnaiCheckParam = null;
            MosnaiCheck mosnaiCheck = null;
            BzSinkeiyakuDenpyouDataTourokuBean bzSkDenpyouDataTourokuBean = null;
            List<BzSiwakeMeisaiBean> bzSiwakeMeisaiBeanLst = null;
            BzSiwakeMeisaiBean bzSiwakeMeisaiBeanKari = null;
            BzSiwakeMeisaiBean bzSiwakeMeisaiBeanKasi = null;
            String drtenKykTantouBukaCode = YuyuSinkeiyakuConfig.getInstance().getDairitenkykbukacd();
            String drtenKykTantouSosikiCode = YuyuSinkeiyakuConfig.getInstance().getDairitenkyksosikicd();
            C_Tuukasyu tuukaSyu = null;
            BzDenpyouDataSks bzDenpyouDataSks = SWAKInjector.getInstance(BzDenpyouDataSks.class);
            List<HT_SkDenpyoData> skDenpyoDataLst = null;
            SkProcessForwardForBatchInBean skKouteiBatchBean = null;
            List<SkProcessForwardForBatchInBean> skKouteiBatchBeanLst = null;
            List<BzProcessUpdateForBatchInputBean> bzProcessUpdateForBatchInputBeanList = new ArrayList<>();
            BT_TjtIdouNySk tjtIdouNySk = null;
            SkProcessForwardHurikomiNyuukin skProcessHurikomiNyuukin = SWAKInjector.getInstance(SkProcessForwardHurikomiNyuukin.class);
            SkProcessUpdate skProcessUpdate = SWAKInjector.getInstance(SkProcessUpdate.class);
            BizDate denYmd = syoriYmd.addBusinessDays(1);
            String aatkisyaSoshikiCd = "";
            String aatkisyaDaibosyuuCd = "";
            String syouhnCd = "";
            BizDate kakoRateSiteiYmd = null;
            String aatkisyaBosyuuCd = "";
            String ryouritusdNo = "";
            boolean kakoRateSiteiFlg = false;
            C_Segcd seg1Cd = null;
            C_Segcd seg2Cd = null;
            C_Kanjyoukmkcd kanjyouKmkCdKari = null;
            C_Kanjyoukmkcd kanjyouKmkCdKasi = null;
            BizCurrency dengaiKagk = null;
            BizCurrency denyenkagk = null;
            BizCurrency rsGaku = null;
            SkIdounaiyouBeforeBean skIdounaiyouBeforeBean = null;
            HenkanTuuka henkanTuuka = SWAKInjector.getInstance(HenkanTuuka.class);
            C_Tuukasyu kyktuukasyu = null;
            BizCurrency keiyakutuukagk = null;
            BizNumber nyknkwsrate = null;
            GetKawaseRate getKawaseRate = null;
            KeisanGaikakanzan keisanGaikakanzan = null;
            Integer syouHnsdNo = 0;
            BizDate kykymd = null;
            BizDateYM bosyuuym = null;
            C_Sdpd sdpdkbn = null;
            C_Hrkkaisuu hrkkaisuu = null;
            C_Hrkkeiro hrkkeiro = null;
            BizDate sknnkaisiymd = null;
            BizDate mosymd = null;

            for (HW_HrkmNyknTaisyouWk hrkmNyknTaisyouWk : hrkmNyknTaisyouWkLst) {

                if(syoriKensuu >= maxsyoriKensuu){
                    zanariFlg = true;
                    break;
                }

                mosno = hrkmNyknTaisyouWk.getMosno();
                tuukaSyu = hrkmNyknTaisyouWk.getRstuukasyu();
                skTjtuIdounaiyouEdit = SWAKInjector.getInstance(SkToujituIdounaiyouEdit.class);
                mosSyouhn = null;
                mosnaiCheckParam = SWAKInjector.getInstance(MosnaiCheckParam.class);
                mosnaiCheck = SWAKInjector.getInstance(MosnaiCheck.class);
                bzSiwakeMeisaiBeanLst = new ArrayList<>();
                skKouteiBatchBean = SWAKInjector.getInstance(SkProcessForwardForBatchInBean.class);
                skKouteiBatchBeanLst = new ArrayList<>();
                aatkisyaSoshikiCd = "";
                aatkisyaDaibosyuuCd = "";
                aatkisyaBosyuuCd = "";
                syouhnCd = "";
                ryouritusdNo = "";
                kakoRateSiteiFlg = false;
                kakoRateSiteiYmd = null;
                seg1Cd = C_Segcd.BLNK;
                seg2Cd = C_Segcd.BLNK;
                kanjyouKmkCdKari = C_Kanjyoukmkcd.BLNK;
                kanjyouKmkCdKasi = C_Kanjyoukmkcd.BLNK;
                dengaiKagk = BizCurrency.optional(henkanTuuka.henkanTuukaKbnToType(tuukaSyu));
                denyenkagk = BizCurrency.optional();
                skIdounaiyouBeforeBean = null;
                keiyakutuukagk = BizCurrency.optional();
                nyknkwsrate = BizNumber.optional();
                getKawaseRate = null;
                keisanGaikakanzan = null;

                bzRecoveryDatasikibetuBean.setIbKakutyoujobcd(kakutyouJobCd);
                bzRecoveryDatasikibetuBean.setIbTableid(TYSYTTAISYOUTABLEID);
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterid(RECOVERYFILTERID);
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterkey1(mosno);

                syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosno);

                if (syoriCTL == null) {
                    throw new BizAppException(MessageId.EBS0004, HT_SyoriCTL.TABLE_NAME, HT_SyoriCTL.MOSNO, mosno);
                }

                if (!C_SeirituKbn.NONE.eq(syoriCTL.getSeiritukbn())) {
                    throw new BizAppException(MessageId.EHF0019, mosno);
                }

                skIdounaiyouBeforeBean = skTjtuIdounaiyouEdit.setSkIdounaiyouBefore(syoriCTL);

                mosKihon = syoriCTL.getMosKihon();

                if (mosKihon == null) {
                    throw new BizAppException(MessageId.EBS0004, HT_MosKihon.TABLE_NAME, HT_MosKihon.MOSNO, mosno);
                }

                mosDairiten = syoriCTL.getMosDairitenByRenno(1);

                mosSyouhnLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);

                if (mosSyouhnLst.size() > 0) {
                    mosSyouhn = mosSyouhnLst.get(0);

                    BzSegmentCdSyutoku bzSegmentCdSyutoku = SWAKInjector.getInstance(BzSegmentCdSyutoku.class);
                    SyouhinbetuSegmentBean syouhinbetuSegmentBean = bzSegmentCdSyutoku.exec(
                        mosSyouhn.getSyouhncd(), mosKihon.getKyktuukasyu());

                    if(C_ErrorKbn.OK.eq(syouhinbetuSegmentBean.getErrorKbn())){

                        seg1Cd = syouhinbetuSegmentBean.getSegcd1();
                        seg2Cd = syouhinbetuSegmentBean.getSegcd2();
                    }
                }

                nyuukinLst = syoriCTL.getNyuukins();

                if (nyuukinLst.size() > 0) {
                    nyuukinLst = nyuukinSort.OrderHT_NyuukinByPkDesc(nyuukinLst);

                    nyukinMaxNo = nyuukinLst.get(0).getRenno() + 1;
                }
                else {
                    nyukinMaxNo = 1;
                }

                bzGetProcessSummaryInBean = SWAKInjector.getInstance(BzGetProcessSummaryInBean.class);

                bzGetProcessSummaryInBean.setJimuTetuzukiCd(ISkCommonKoumoku.JIMUTETUZUKICD_SKMAINDAIRITEN);
                bzGetProcessSummaryInBean.setKouteiKanriStatuss(C_Kouteikanristatus.SYORITYUU);
                bzGetProcessSummaryInBean.setMosNo(mosno);

                List<BzGetProcessSummaryOutBean> bzGetProcessSummaryOutBeanLst =
                    bzGetProcessSummary.exec(bzGetProcessSummaryInBean);

                gyoumuKouteiInfo = bizDomManager.getGyoumuKouteiInfo(bzGetProcessSummaryOutBeanLst.get(0).getKouteiKanriId());

                kykymd = mosKihon.getKykymd();
                bosyuuym = mosKihon.getBosyuuym();
                sdpdkbn = mosKihon.getSdpdkbn();
                hrkkaisuu = mosKihon.getHrkkaisuu();
                hrkkeiro = mosKihon.getHrkkeiro();
                sknnkaisiymd =mosKihon.getSknnkaisiymd();
                mosymd = mosKihon.getMosymd();
                kyktuukasyu = mosKihon.getKyktuukasyu();

                if (mosDairiten != null) {
                    aatkisyaSoshikiCd = mosDairiten.getDrtenkanrisosikicd();
                    aatkisyaDaibosyuuCd = mosDairiten.getDaibosyuucd();
                    aatkisyaBosyuuCd = mosDairiten.getBosyuucd();
                }

                if (mosSyouhn != null) {
                    syouhnCd = mosSyouhn.getSyouhncd();
                    ryouritusdNo = mosSyouhn.getRyouritusdno();
                    syouHnsdNo = mosSyouhn.getSyouhnsdno();
                }

                nyuukin = syoriCTL.createNyuukin();

                if (C_Tuukasyu.JPY.eq(tuukaSyu)) {
                    rsGaku = hrkmNyknTaisyouWk.getRsgaku().add(hrkmNyknTaisyouWk.getHrkmtsry());
                }
                else {
                    rsGaku = hrkmNyknTaisyouWk.getRsgaku();
                }

                nyuukin.setMosno(mosno);
                nyuukin.setRenno(nyukinMaxNo);
                nyuukin.setTyakkinymd(hrkmNyknTaisyouWk.getRyosyuymd());
                nyuukin.setNyksyoriymd(syoriYmd);
                nyuukin.setNyuukinsyoritime(BizDate.getSysDateTimeMilli());
                nyuukin.setNyknsyubetu(C_NyknsyubetuKbn.HURIKOMI);
                nyuukin.setRsgaku(rsGaku);
                nyuukin.setRstuukasyu(tuukaSyu);
                nyuukin.setRyosyuymd(hrkmNyknTaisyouWk.getRyosyuymd());
                nyuukin.setZenhnknkbn(C_ZenhnknKbn.BLNK);
                nyuukin.setSrgonyknumu(C_UmuKbn.NONE);
                nyuukin.setZenhnknrenno(0);
                nyuukin.setGyoumuKousinsyaId(skHurikomiNyuukinBatchParam.getUserId());
                nyuukin.setGyoumuKousinTime(BizDate.getSysDateTimeMilli());

                syoriCTL.setNyknnrkumu(C_UmuKbn.ARI);

                mosnaiCheckParam.setCategoryID(kinou.getCategoryId());
                mosnaiCheckParam.setKinouID(kinou.getKinouId());
                mosnaiCheckParam.setKetteiYouhiKbn(C_KetteiyouhiKbn.YOU);
                mosnaiCheckParam.setSysDate(syoriYmd);
                mosnaiCheckParam.setKosID(skHurikomiNyuukinBatchParam.getUserId());
                mosnaiCheckParam.setKosTime(BizDate.getSysDateTimeMilli());
                mosnaiCheckParam.setDataSyoriControl(syoriCTL);
                mosnaiCheckParam.setGyoumuKouteiInfo(gyoumuKouteiInfo);

                mosnaiCheck.exec(mosnaiCheckParam);

                List<HT_SkDenpyoData> listSkDenpyoData = mosnaiCheckParam.getListSkDenpyoData();

                for (HT_SkDenpyoData skDenpyoData : listSkDenpyoData) {

                    skDenpyoEntityInserter.add(skDenpyoData);
                }

                bzSkDenpyouDataTourokuBean = SWAKInjector.getInstance(BzSinkeiyakuDenpyouDataTourokuBean.class);
                bzSiwakeMeisaiBeanKari = SWAKInjector.getInstance(BzSiwakeMeisaiBean.class);
                bzSiwakeMeisaiBeanKasi = SWAKInjector.getInstance(BzSiwakeMeisaiBean.class);

                if (C_Tuukasyu.JPY.eq(kyktuukasyu)) {

                    if (C_Tuukasyu.JPY.eq(tuukaSyu)) {

                        kanjyouKmkCdKari = C_Kanjyoukmkcd.HOKENKEIYAKUKARIUKEKIN_HUHO_DAI1KAI;
                        kanjyouKmkCdKasi = C_Kanjyoukmkcd.HOKENKEIYAKUKARIUKEKIN_HUHO_SYOKAI;
                    }
                }
                else {

                    if (C_Tuukasyu.JPY.eq(tuukaSyu)) {
                        kanjyouKmkCdKari = C_Kanjyoukmkcd.HOKENKEIYAKU_DAI1KAI_GAIHO_JPY;
                        kanjyouKmkCdKasi = C_Kanjyoukmkcd.HOKENKEIYAKU_SYOKAI_GAIHO_JPY;
                    }
                    if (C_Tuukasyu.USD.eq(tuukaSyu)) {
                        kanjyouKmkCdKari = C_Kanjyoukmkcd.HOKENKEIYAKU_DAI1KAI_GAIHO_USD;
                        kanjyouKmkCdKasi = C_Kanjyoukmkcd.HOKENKEIYAKU_SYOKAI_GAIHO_USD;
                    }
                    if (C_Tuukasyu.AUD.eq(tuukaSyu)) {
                        kanjyouKmkCdKari = C_Kanjyoukmkcd.HOKENKEIYAKU_DAI1KAI_GAIHO_AUD;
                        kanjyouKmkCdKasi = C_Kanjyoukmkcd.HOKENKEIYAKU_SYOKAI_GAIHO_AUD;
                    }
                }

                if (!C_Tuukasyu.JPY.eq(tuukaSyu)) {
                    dengaiKagk = hrkmNyknTaisyouWk.getRsgaku();
                }
                else {
                    denyenkagk = hrkmNyknTaisyouWk.getRsgaku().add(hrkmNyknTaisyouWk.getHrkmtsry());
                }

                if (BizDateUtil.compareYmd(syoriCTL.getRyosyuymd(), syoriYmd) == BizDateUtil.COMPARE_LESSER) {
                    kakoRateSiteiFlg = true;
                    kakoRateSiteiYmd = syoriCTL.getRyosyuymd();
                }

                if (!tuukaSyu.eq(kyktuukasyu)) {
                    getKawaseRate = SWAKInjector.getInstance(GetKawaseRate.class);

                    C_ErrorKbn kekkakbn = getKawaseRate.execFstPNyuukin(
                        syoriCTL.getRyosyuymd(),
                        kyktuukasyu,
                        tuukaSyu,
                        C_YouhiKbn.HUYOU,
                        hrkkaisuu,
                        C_SysKbn.SKEI,
                        mosKihon.getZennoumousideumu(),
                        mosKihon.getIkkatubaraikbn()
                        );

                    if (C_ErrorKbn.ERROR.eq(kekkakbn)) {
                        throw new CommonBizAppException("為替レートが取得できません。");
                    }

                    nyknkwsrate = getKawaseRate.getKawaserate();

                    keisanGaikakanzan = SWAKInjector.getInstance(KeisanGaikakanzan.class);

                    keiyakutuukagk = keisanGaikakanzan.execDivide(kyktuukasyu, rsGaku, nyknkwsrate, C_HasuusyoriKbn.SUTE);
                }
                else {
                    keiyakutuukagk = rsGaku;
                }

                bzSiwakeMeisaiBeanKari.setIbTaisyakukbn(C_TaisyakuKbn.KARIKATA);
                bzSiwakeMeisaiBeanKari.setIbKanjyoukmkcd(kanjyouKmkCdKari);
                bzSiwakeMeisaiBeanKari.setIbSuitoubumoncd(drtenKykTantouBukaCode);
                bzSiwakeMeisaiBeanKari.setIbDengaikagk(dengaiKagk);
                bzSiwakeMeisaiBeanKari.setIbDenyenkagk(denyenkagk);
                bzSiwakeMeisaiBeanKari.setIbSeg1cd(seg1Cd);
                bzSiwakeMeisaiBeanKari.setIbSeg2cd(seg2Cd);
                bzSiwakeMeisaiBeanKari.setIbDenkarikanjyono("");
                bzSiwakeMeisaiBeanKari.setIbKeiyakutuukagk(keiyakutuukagk);
                bzSiwakeMeisaiBeanLst.add(bzSiwakeMeisaiBeanKari);

                bzSiwakeMeisaiBeanKasi.setIbTaisyakukbn(C_TaisyakuKbn.KASIKATA);
                bzSiwakeMeisaiBeanKasi.setIbKanjyoukmkcd(kanjyouKmkCdKasi);
                bzSiwakeMeisaiBeanKasi.setIbSuitoubumoncd(drtenKykTantouBukaCode);
                bzSiwakeMeisaiBeanKasi.setIbDengaikagk(dengaiKagk);
                bzSiwakeMeisaiBeanKasi.setIbDenyenkagk(denyenkagk);
                bzSiwakeMeisaiBeanKasi.setIbSeg1cd(seg1Cd);
                bzSiwakeMeisaiBeanKasi.setIbSeg2cd(seg2Cd);
                bzSiwakeMeisaiBeanKari.setIbDenkarikanjyono("");
                bzSiwakeMeisaiBeanKasi.setIbKeiyakutuukagk(keiyakutuukagk);

                bzSiwakeMeisaiBeanLst.add(bzSiwakeMeisaiBeanKasi);

                bzSkDenpyouDataTourokuBean.setIbMosno(mosno);
                bzSkDenpyouDataTourokuBean.setIbHuridenatesakicd(drtenKykTantouBukaCode);
                bzSkDenpyouDataTourokuBean.setIbTantocd(C_TantouCdKbn.DAIRITENJIMUKANRI);
                bzSkDenpyouDataTourokuBean.setIbDenymd(denYmd);
                bzSkDenpyouDataTourokuBean.setIbTuukasyu(tuukaSyu);
                bzSkDenpyouDataTourokuBean.setIbSyoriymd(syoriYmd);
                bzSkDenpyouDataTourokuBean.setIbSyoricd(kinou.getSyoricd());
                bzSkDenpyouDataTourokuBean.setIbSyorisosikicd(drtenKykTantouSosikiCode);
                bzSkDenpyouDataTourokuBean.setIbKessantyouseikbn(C_KessantyouseiKbn.BLNK);
                bzSkDenpyouDataTourokuBean.setIbNaibukeiyakukbn(C_NaibuKeiyakuKbn.BLNK);
                bzSkDenpyouDataTourokuBean.setIbTekiyoukbn(C_TekiyouKbn.BLNK);
                bzSkDenpyouDataTourokuBean.setIbDensyorikbn(C_DensyoriKbn.FP_GNKHRKM);
                bzSkDenpyouDataTourokuBean.setIbAatsukaishasuitososhikicd(drtenKykTantouSosikiCode);
                bzSkDenpyouDataTourokuBean.setIbKykymd(kykymd);
                bzSkDenpyouDataTourokuBean.setIbBosyuuym(bosyuuym);
                bzSkDenpyouDataTourokuBean.setIbAatsukaishasoshikicd(aatkisyaSoshikiCd);
                bzSkDenpyouDataTourokuBean.setIbAatkisyadaibosyuucd(aatkisyaDaibosyuuCd);
                bzSkDenpyouDataTourokuBean.setIbSyusyouhncd(syouhnCd);
                bzSkDenpyouDataTourokuBean.setIbSdpdkbn(sdpdkbn);
                bzSkDenpyouDataTourokuBean.setIbHrkkaisuu(hrkkaisuu);
                bzSkDenpyouDataTourokuBean.setIbHrkkeiro(hrkkeiro);
                bzSkDenpyouDataTourokuBean.setIbSknnkaisiymd(sknnkaisiymd);
                bzSkDenpyouDataTourokuBean.setIbMosymd(mosymd);
                bzSkDenpyouDataTourokuBean.setIbHnknriyuukbn(C_HenkinriyuuKbn.BLNK);
                bzSkDenpyouDataTourokuBean.setIbFstpryosyuymd(syoriCTL.getRyosyuymd());
                bzSkDenpyouDataTourokuBean.setIbAatkisyabosyuucd(aatkisyaBosyuuCd);
                bzSkDenpyouDataTourokuBean.setIbRyouritusdno(ryouritusdNo);
                bzSkDenpyouDataTourokuBean.setIbGyoumuKousinsyaId(skHurikomiNyuukinBatchParam.getUserId());
                bzSkDenpyouDataTourokuBean.setIbKakokawaserateshiteiflg(kakoRateSiteiFlg);
                bzSkDenpyouDataTourokuBean.setIbKakokawaserateshiteiymd(kakoRateSiteiYmd);
                bzSkDenpyouDataTourokuBean.setIbKyktuukasyu(kyktuukasyu);
                bzSkDenpyouDataTourokuBean.setIbShrhousiteiKbn(C_ShrhousiteiKbn.BLNK);
                bzSkDenpyouDataTourokuBean.setIbSyouhnsdno(syouHnsdNo);
                bzSkDenpyouDataTourokuBean.setBzSiwakeMeisaiBeanList(bzSiwakeMeisaiBeanLst);

                skDenpyoDataLst = bzDenpyouDataSks.execSk(bzSkDenpyouDataTourokuBean);

                nyuukin.setDenrenno(skDenpyoDataLst.get(0).getDenrenno());
                nyuukin.setEdano(2);

                BizPropertyInitializer.initialize(nyuukin);

                skKouteiBatchBean.setHtSyoriCTL(syoriCTL);
                skKouteiBatchBean.setTskNm(TASKNM);
                skKouteiBatchBean.setSyoriComment("");

                skKouteiBatchBean.setSkHubiDtailUmu(C_UmuKbn.NONE);

                List<HT_SkHubi> skHubiList = syoriCTL.getSkHubis();

                for (HT_SkHubi htSkHubi : skHubiList) {

                    List<HT_SkHubiDetail> skHubiDetailList = htSkHubi.getSkHubiDetails();

                    if (skHubiDetailList.size() > 0) {

                        skKouteiBatchBean.setSkHubiDtailUmu(C_UmuKbn.ARI);

                        break;
                    }
                }

                skKouteiBatchBeanLst.add(skKouteiBatchBean);

                skProcessHurikomiNyuukin.exec(skKouteiBatchBeanLst);

                List<BzProcessUpdateForBatchInputBean> resultBzProcessUpdateForBatchInputBeanList =
                    skProcessUpdate.editProcessUpdateForBatchInfo(syoriCTL, syoriCTL.getMosKihon(), syoriCTL.getMosDairitens());

                if (resultBzProcessUpdateForBatchInputBeanList.size() > 0) {
                    bzProcessUpdateForBatchInputBeanList.addAll(resultBzProcessUpdateForBatchInputBeanList);
                }

                boolean syoriKekka = skTjtuIdounaiyouEdit.skIdounaiyouHenkouCheck(syoriCTL, skIdounaiyouBeforeBean);

                if (syoriKekka) {
                    tjtIdouNySk = skTjtuIdounaiyouEdit.skIdounaiyouFileEdit(syoriCTL);

                    if (tjtIdouNySk != null) {
                        tjtIdouNySkEntityInserter.add(tjtIdouNySk);
                    }
                    else {
                        batchLogger.error(MessageUtil.getMessage(
                            MessageId.EHA1051, "新契約当日異動内容（ファイル）編集", "申込番号", mosno));

                        throw new BizAppException(MessageId.EHA1051, "新契約当日異動内容（ファイル）編集", "申込番号", mosno);
                    }
                }

                for (HT_SkDenpyoData skDenpyoData : skDenpyoDataLst) {

                    skDenpyoEntityInserter.add(skDenpyoData);
                }

                gmKtInfoEntityUpdater.add(gyoumuKouteiInfo);

                syoriCTLEntityUpdater.add(syoriCTL);

                HT_MosnoKanri mosnoKanri = mosnaiCheckParam.getMosnoKanri();
                if (mosnoKanri != null) {
                    mosnoKanriEntityUpdater.add(mosnoKanri);
                }

                hrkmNyknTaisyouWk.setSyorizumiflg(C_Syorizumiflg.SYORIZUMI);

                syoriKensuu++;

            }

            bzRecoveryDatasikibetuBean.initializeBlank();

            skProcessUpdate.execForBatch(bzProcessUpdateForBatchInputBeanList);
        }

        batchLogger.info(MessageUtil.getMessage(MessageId.IBF0002, String.valueOf(syoriKensuu), "振込入金処理"));

        if(zanariFlg){
            batchLogger.info("繰越対象あり");
        }
    }

    @AppBatchExceptionTerminate
    private void appBatchExceptionTerminate() {

        BzBatchAbendCommonRecovery bzBatchAbendCommonRecovery =
            SWAKInjector.getInstance(BzBatchAbendCommonRecovery.class);

        bzBatchAbendCommonRecovery.exec();
    }
}
