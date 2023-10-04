package yuyu.batch.sinkeiyaku.sknyuukin.skcredittourokukekkahanei;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.batch.annotation.AppBatchExceptionTerminate;
import jp.co.slcs.swak.batch.annotation.Execute;
import jp.co.slcs.swak.bizinfr.exception.BizAppException;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.EntityInserter;
import jp.co.slcs.swak.db.EntityUpdater;
import jp.co.slcs.swak.db.ExDBResults;
import jp.co.slcs.swak.util.message.MessageUtil;
import yuyu.batch.sinkeiyaku.sknyuukin.skcredittourokukekkahanei.dba.SkCreditTourokuKekkaHaneiDao;
import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.common.biz.bzcommon.BizUtil;
import yuyu.common.biz.bzcommon.BzBatchAbendCommonRecovery;
import yuyu.common.biz.bzcommon.BzBatchParam;
import yuyu.common.biz.bzcommon.BzProcessUpdateForBatchInputBean;
import yuyu.common.biz.koutei.BzGetProcessSummary;
import yuyu.common.biz.koutei.BzGetProcessSummaryInBean;
import yuyu.common.hozen.khcommon.CreditKessaiyouNoUtil;
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
import yuyu.def.classification.C_CreditTrkhouKbn;
import yuyu.def.classification.C_CreditTrkjkKbn;
import yuyu.def.classification.C_CreditYuukoukakKbn;
import yuyu.def.classification.C_Dbhanei;
import yuyu.def.classification.C_Hrkkeiro;
import yuyu.def.classification.C_Ketkekkacd;
import yuyu.def.classification.C_KetteiyouhiKbn;
import yuyu.def.classification.C_Kouteikanristatus;
import yuyu.def.classification.C_SeirituKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.AS_Kinou;
import yuyu.def.db.entity.BT_GyoumuKouteiInfo;
import yuyu.def.db.entity.BT_TjtIdouNySk;
import yuyu.def.db.entity.HT_CreditCardJyouhou;
import yuyu.def.db.entity.HT_DakuhiKettei;
import yuyu.def.db.entity.HT_MosDairiten;
import yuyu.def.db.entity.HT_MosKihon;
import yuyu.def.db.entity.HT_SkDenpyoData;
import yuyu.def.db.entity.HT_SkHubi;
import yuyu.def.db.entity.HT_SkHubiDetail;
import yuyu.def.db.entity.HT_SyoriCTL;
import yuyu.def.db.entity.HW_CreditTrkHaneierrList;
import yuyu.def.db.entity.HW_CreditTrkNgList;
import yuyu.def.db.entity.IT_SkCreditCardTourokuKekka;
import yuyu.def.sinkeiyaku.manager.SinkeiyakuDomManager;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.logger.BatchLogger;

/**
 * 新契約 入金 クレジットカード登録結果反映
 */
public class SkCreditTourokuKekkaHaneiBatch implements Batch {

    private static final String TYSYTTAISYOU_TABLE_ID = IT_SkCreditCardTourokuKekka.TABLE_NAME;

    private static final String RECOVERY_FILTER_KBNID = "Bz112";

    @Inject
    private BatchLogger batchLogger;

    @Inject
    private BzBatchParam bzBatchParam;

    @Inject
    private SkCreditTourokuKekkaHaneiDao skCreditTourokuKekkaHaneiDao;

    @Inject
    private BzRecoveryDatasikibetuBean bzRecoveryDatasikibetuBean;

    @Inject
    private SinkeiyakuDomManager sinkeiyakuDomManager;

    @Inject
    private BizDomManager bizDomManager;

    @Inject
    private AS_Kinou kinou;

    @Override
    public BzBatchParam getParam() {
        return bzBatchParam;
    }

    @Execute
    @Transactional
    public void execute() {

        BizDate syoriYmd = bzBatchParam.getSyoriYmd();
        String ibKakutyoujobCd = bzBatchParam.getIbKakutyoujobcd();


        batchLogger.info(MessageUtil.getMessage(MessageId.IBA0016, MessageUtil.getMessage(MessageId.IBW0003),
            String.valueOf(syoriYmd)));

        batchLogger.info(MessageUtil.getMessage(MessageId.IBA0016, MessageUtil.getMessage(MessageId.IBW1018),
            ibKakutyoujobCd));

        long syoriKensuu = 0;
        String mosNo = "";
        String haneierrRiyuu = "";
        HT_SyoriCTL syoriCTL = null;
        HT_MosKihon mosKihon = null;
        HT_DakuhiKettei dakuhiKettei = null;
        HT_CreditCardJyouhou creditCardJyouhou = null;
        List<HT_MosDairiten> mosDairitenList = null;
        BT_GyoumuKouteiInfo gyoumuKouteiInfo = null;
        List<HT_SkHubi> skHubiList = null;
        List<HT_SkHubiDetail> skHubiDetailList = null;
        List<SkProcessForwardForBatchInBean> skProcessForwardForBatchInBeanList = null;
        String sosikiCd = "";
        List<BzProcessUpdateForBatchInputBean> bzProcessUpdateForBatchInputBeanList = new ArrayList<>();

        try (
            ExDBResults<IT_SkCreditCardTourokuKekka> skCreditCardTourokuKekkaList = skCreditTourokuKekkaHaneiDao
            .getSkCreditCardTourokuKekkasByKakutyoujobcd(ibKakutyoujobCd);

            EntityUpdater<HT_SyoriCTL> syoriCTLUpdater = new EntityUpdater<>();
            EntityUpdater<BT_GyoumuKouteiInfo> gyoumuKouteiInfoUpdater = new EntityUpdater<>();
            EntityInserter<HW_CreditTrkHaneierrList> creditTrkHaneierrListInserter = new EntityInserter<>();
            EntityInserter<HW_CreditTrkNgList> creditTrkNgListInserter = new EntityInserter<>();
            EntityInserter<HT_SkDenpyoData> skDenpyoDataInserter = new EntityInserter<>();
            EntityInserter<BT_TjtIdouNySk> tjtIdouNySkInserter = new EntityInserter<>();) {

            Integer creditTrkHaneierrListDatarenno = skCreditTourokuKekkaHaneiDao.getCreditTrkHaneierrListMaxDatarennoByTyouhyouymd(syoriYmd);
            Integer creditTrkNgListDatarenno = skCreditTourokuKekkaHaneiDao.getCreditTrkNgListMaxDatarennoByTyouhyouymd(syoriYmd);

            if (creditTrkHaneierrListDatarenno == null) {

                creditTrkHaneierrListDatarenno = 0;
            }

            if (creditTrkNgListDatarenno == null) {

                creditTrkNgListDatarenno = 0;

            }
            SkProcessUpdate skProcessUpdate = SWAKInjector.getInstance(SkProcessUpdate.class);
            for (IT_SkCreditCardTourokuKekka skCreditCardTourokuKekka : skCreditCardTourokuKekkaList) {

                String creditkessaiyouNo = skCreditCardTourokuKekka.getCreditkessaiyouno();

                bzRecoveryDatasikibetuBean.setIbKakutyoujobcd(ibKakutyoujobCd);
                bzRecoveryDatasikibetuBean.setIbTableid(TYSYTTAISYOU_TABLE_ID);
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterid(RECOVERY_FILTER_KBNID);
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterkey1(creditkessaiyouNo);

                CreditKessaiyouNoUtil creditKessaiyouNoUtil = SWAKInjector.getInstance(CreditKessaiyouNoUtil.class);

                syoriKensuu = syoriKensuu + 1;
                mosNo = creditKessaiyouNoUtil.getMosNo(creditkessaiyouNo);
                haneierrRiyuu = "";
                sosikiCd = "";

                syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo);

                if (syoriCTL == null) {

                    haneierrRiyuu = MessageUtil.getMessage(MessageId.EHF1020);
                }

                else {

                    mosKihon = syoriCTL.getMosKihon();
                    dakuhiKettei = sinkeiyakuDomManager.getDakuhiKetteiByMosnoMaxDakuhiktrenno(mosNo);
                    creditCardJyouhou = syoriCTL.getCreditCardJyouhou();
                    mosDairitenList = syoriCTL.getMosDairitens();
                }

                if (BizUtil.isBlank(haneierrRiyuu)) {

                    if (C_SeirituKbn.SEIRITU.eq(syoriCTL.getSeiritukbn())) {

                        haneierrRiyuu = MessageUtil.getMessage(MessageId.EHF1021, "成立済み");
                    }

                    else if (C_SeirituKbn.HUSEIRITU.eq(syoriCTL.getSeiritukbn()) &&
                        dakuhiKettei != null &&
                        (C_Ketkekkacd.COOLINGOFF.eq(dakuhiKettei.getKetkekkacd()) ||
                            C_Ketkekkacd.MOS_TORIKESI.eq(dakuhiKettei.getKetkekkacd()))) {

                        haneierrRiyuu = MessageUtil.getMessage(MessageId.EHF1021, "申込取消");
                    }

                    if (BizUtil.isBlank(haneierrRiyuu) && C_UmuKbn.NONE.eq(syoriCTL.getMosnrkumu())) {

                        haneierrRiyuu = MessageUtil.getMessage(MessageId.EHF1022);

                    }

                    if (BizUtil.isBlank(haneierrRiyuu) && !C_Hrkkeiro.CREDIT.eq(mosKihon.getHrkkeiro())) {

                        haneierrRiyuu = MessageUtil.getMessage(MessageId.EHF1023);

                    }

                    if (BizUtil.isBlank(haneierrRiyuu)) {

                        if (creditCardJyouhou != null && creditkessaiyouNo.equals(creditCardJyouhou.getCreditkessaiyouno())) {

                            if (C_CreditTrkjkKbn.SUMI.eq(syoriCTL.getCredittrkjkkbn())) {

                                haneierrRiyuu = MessageUtil.getMessage(MessageId.EHF1024, "登録済み");
                            }

                            else if (C_CreditTrkjkKbn.NG.eq(syoriCTL.getCredittrkjkkbn())) {

                                haneierrRiyuu = MessageUtil.getMessage(MessageId.EHF1024, "登録ＮＧ");

                            }
                        }
                        else {

                            haneierrRiyuu = MessageUtil.getMessage(MessageId.EHF1025);

                        }
                    }

                }

                if (BizUtil.isBlank(haneierrRiyuu)) {

                    SkToujituIdounaiyouEdit skToujituIdounaiyouEdit = SWAKInjector.getInstance(SkToujituIdounaiyouEdit.class);

                    SkIdounaiyouBeforeBean skIdounaiyouBeforeBean= skToujituIdounaiyouEdit.setSkIdounaiyouBefore(syoriCTL);

                    if ("3".equals(skCreditCardTourokuKekka.getDatasyorijyoukyou())) {

                        syoriCTL.setCredittrkjkkbn(C_CreditTrkjkKbn.SUMI);
                        syoriCTL.setCredityuukoukakkbn(C_CreditYuukoukakKbn.OK);
                    }
                    else {

                        syoriCTL.setCredittrkjkkbn(C_CreditTrkjkKbn.NG);
                    }

                    if (C_SeirituKbn.NONE.eq(syoriCTL.getSeiritukbn())) {

                        BzGetProcessSummary bzGetProcessSummary = SWAKInjector.getInstance(BzGetProcessSummary.class);
                        BzGetProcessSummaryInBean bzGetProcessSummaryInBean = SWAKInjector.getInstance(BzGetProcessSummaryInBean.class);

                        bzGetProcessSummaryInBean.setJimuTetuzukiCd(ISkCommonKoumoku.JIMUTETUZUKICD_SKMAINDAIRITEN);
                        bzGetProcessSummaryInBean.setKouteiKanriStatuss(C_Kouteikanristatus.SYORITYUU);
                        bzGetProcessSummaryInBean.setMosNo(mosNo);

                        String kouteiKanriId = bzGetProcessSummary.exec(bzGetProcessSummaryInBean).get(0).getKouteiKanriId();
                        gyoumuKouteiInfo = bizDomManager.getGyoumuKouteiInfo(kouteiKanriId);

                        MosnaiCheckParam mosnaiCheckParam = SWAKInjector.getInstance(MosnaiCheckParam.class);
                        MosnaiCheck mosnaiCheck = SWAKInjector.getInstance(MosnaiCheck.class);

                        mosnaiCheckParam.setCategoryID(kinou.getCategoryId());
                        mosnaiCheckParam.setKinouID(kinou.getKinouId());
                        mosnaiCheckParam.setKetteiYouhiKbn(C_KetteiyouhiKbn.YOU);
                        mosnaiCheckParam.setSysDate(syoriYmd);
                        mosnaiCheckParam.setKosID(bzBatchParam.getUserId());
                        mosnaiCheckParam.setKosTime(BizDate.getSysDateTimeMilli());
                        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
                        mosnaiCheckParam.setGyoumuKouteiInfo(gyoumuKouteiInfo);

                        mosnaiCheck.exec(mosnaiCheckParam);

                        List<HT_SkDenpyoData> skDenpyoDataList = mosnaiCheckParam.getListSkDenpyoData();

                        for (HT_SkDenpyoData skDenpyoData : skDenpyoDataList) {

                            skDenpyoDataInserter.add(skDenpyoData);
                        }

                        gyoumuKouteiInfoUpdater.add(gyoumuKouteiInfo);

                        boolean hanteiKekka = skToujituIdounaiyouEdit.skIdounaiyouHenkouCheck(syoriCTL, skIdounaiyouBeforeBean);
                        if (hanteiKekka) {

                            BT_TjtIdouNySk tjtIdouNySk = skToujituIdounaiyouEdit.skIdounaiyouFileEdit(syoriCTL);

                            if (tjtIdouNySk == null) {

                                throw new BizAppException(MessageUtil.getMessage(MessageId.EHA1051,
                                    "新契約当日異動内容(ファイル)編集",
                                    "申込番号",
                                    mosNo));
                            }

                            tjtIdouNySkInserter.add(tjtIdouNySk);
                        }

                        skHubiDetailList = new ArrayList<>();
                        skProcessForwardForBatchInBeanList = new ArrayList<>();
                        skHubiList = syoriCTL.getSkHubis();

                        for (HT_SkHubi skHubi : skHubiList) {

                            skHubiDetailList = skHubi.getSkHubiDetails();

                            if (skHubiDetailList.size() > 0) {

                                break;
                            }
                        }

                        SkProcessForwardForBatchInBean skProcessForwardForBatchInBean =
                            SWAKInjector.getInstance(SkProcessForwardForBatchInBean.class);

                        skProcessForwardForBatchInBean.setHtSyoriCTL(syoriCTL);
                        skProcessForwardForBatchInBean.setTskNm("クレジットカード登録結果反映");
                        skProcessForwardForBatchInBean.setSyoriComment("");

                        if (skHubiDetailList.size() > 0) {

                            skProcessForwardForBatchInBean.setSkHubiDtailUmu(C_UmuKbn.ARI);
                        }

                        else {

                            skProcessForwardForBatchInBean.setSkHubiDtailUmu(C_UmuKbn.NONE);
                        }

                        skProcessForwardForBatchInBeanList.add(skProcessForwardForBatchInBean);

                        SkProcessForwardHurikomiNyuukin skProcessForwardHurikomiNyuukin =
                            SWAKInjector.getInstance(SkProcessForwardHurikomiNyuukin.class);

                        skProcessForwardHurikomiNyuukin.exec(skProcessForwardForBatchInBeanList);

                        List<BzProcessUpdateForBatchInputBean> jikkouKekkaList = skProcessUpdate.
                            editProcessUpdateForBatchInfo(syoriCTL, mosKihon, mosDairitenList);

                        if (jikkouKekkaList.size() > 0) {

                            bzProcessUpdateForBatchInputBeanList.addAll(jikkouKekkaList);
                        }

                    }

                    syoriCTLUpdater.add(syoriCTL);
                }

                if ("3".equals(skCreditCardTourokuKekka.getDatasyorijyoukyou())) {

                    if (!BizUtil.isBlank(haneierrRiyuu)) {
                        if (mosDairitenList!= null && mosDairitenList.size() > 0) {

                            sosikiCd = mosDairitenList.get(0).getDrtenkanrisosikicd();
                        }

                        creditTrkHaneierrListDatarenno = creditTrkHaneierrListDatarenno + 1;

                        HW_CreditTrkHaneierrList creditTrkHaneierrList= new HW_CreditTrkHaneierrList();

                        creditTrkHaneierrList.setTyouhyouymd(syoriYmd);
                        creditTrkHaneierrList.setDatarenno(creditTrkHaneierrListDatarenno);
                        creditTrkHaneierrList.setMosno(mosNo);
                        creditTrkHaneierrList.setCredittrkhoukbn(C_CreditTrkhouKbn.SYOMEN);
                        creditTrkHaneierrList.setSosikicd(sosikiCd);
                        creditTrkHaneierrList.setCreditkessaiyouno(creditkessaiyouNo);
                        creditTrkHaneierrList.setCredittrkhaneierrriyuu(haneierrRiyuu);

                        BizPropertyInitializer.initialize(creditTrkHaneierrList);

                        creditTrkHaneierrListInserter.add(creditTrkHaneierrList);
                    }
                }

                else {
                    creditTrkNgListDatarenno = creditTrkNgListDatarenno + 1;
                    HW_CreditTrkNgList creditTrkNgList= new HW_CreditTrkNgList();

                    creditTrkNgList.setTyouhyouymd(syoriYmd);
                    creditTrkNgList.setDatarenno(creditTrkNgListDatarenno);
                    creditTrkNgList.setMosno(mosNo);
                    creditTrkNgList.setCreditkessaiyouno(creditkessaiyouNo);
                    creditTrkNgList.setCreditqrerrorcd(skCreditCardTourokuKekka.getAuthorikekkaerrorcd());
                    creditTrkNgList.setBluegateerrorcd(skCreditCardTourokuKekka.getBluegateerrorcd());

                    if (BizUtil.isBlank(haneierrRiyuu)) {

                        creditTrkNgList.setDbhaneikbn(C_Dbhanei.SUMI);
                    }

                    else {

                        creditTrkNgList.setDbhaneikbn(C_Dbhanei.NONE);
                    }
                    creditTrkNgList.setCredittrkhaneierrriyuu(haneierrRiyuu);

                    BizPropertyInitializer.initialize(creditTrkNgList);

                    creditTrkNgListInserter.add(creditTrkNgList);

                }
            }

            bzRecoveryDatasikibetuBean.initializeBlank();
            skProcessUpdate.execForBatch(bzProcessUpdateForBatchInputBeanList);

            batchLogger.info(MessageUtil.getMessage(
                MessageId.IBF0002, String.valueOf(syoriKensuu), "クレジットカード登録結果反映"));
        }
    }

    @AppBatchExceptionTerminate
    private void appBatchExceptionTerminate() {

        BzBatchAbendCommonRecovery bzBatchAbendCommonRecovery = SWAKInjector
            .getInstance(BzBatchAbendCommonRecovery.class);

        bzBatchAbendCommonRecovery.exec();
    }
}
