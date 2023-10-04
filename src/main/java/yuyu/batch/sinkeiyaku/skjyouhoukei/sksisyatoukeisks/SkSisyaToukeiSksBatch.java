package yuyu.batch.sinkeiyaku.skjyouhoukei.sksisyatoukeisks;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.batch.annotation.AppBatchExceptionTerminate;
import jp.co.slcs.swak.batch.annotation.Execute;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.db.EntityDeleter;
import jp.co.slcs.swak.db.EntityUpdater;
import jp.co.slcs.swak.db.ExDBResults;
import jp.co.slcs.swak.db.MultipleEntityInserter;
import jp.co.slcs.swak.db.configuration.SwakDbConfig;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.number.currencytype.BizCurrencyTypes;
import jp.co.slcs.swak.number.currencytype.CurrencyType;
import jp.co.slcs.swak.util.message.MessageUtil;
import yuyu.batch.sinkeiyaku.skjyouhoukei.sksisyatoukeisks.dba.SkSisyaToukeiSksDao;
import yuyu.common.biz.bzcommon.BizDateUtil;
import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.common.biz.bzcommon.BizUtil;
import yuyu.common.biz.bzcommon.BzBatchAbendCommonRecovery;
import yuyu.common.biz.bzcommon.BzBatchParam;
import yuyu.common.biz.bzcommon.BzGetSosikiData;
import yuyu.common.biz.bzcommon.BzKbnHenkanUtil;
import yuyu.common.biz.bzcommon.HenkanTuuka;
import yuyu.common.biz.bzcommon.KeisanGaikakanzan;
import yuyu.common.biz.bzdairiten.BzGetAgInfo;
import yuyu.common.biz.bzdairiten.BzGetAgInfoBean;
import yuyu.common.biz.bzdairiten.BzGetBsInfo;
import yuyu.common.biz.bzdairiten.BzGetBsInfoBean;
import yuyu.common.biz.koutei.BzGetProcessSummary;
import yuyu.common.biz.koutei.BzGetProcessSummaryInBean;
import yuyu.common.biz.koutei.BzGetProcessSummaryOutBean;
import yuyu.common.biz.koutei.GetSyoruittykymd;
import yuyu.common.sinkeiyaku.skcommon.EditNenkinKoumokuUtil;
import yuyu.common.sinkeiyaku.skcommon.EditPalRenkeiKoumoku;
import yuyu.common.sinkeiyaku.skcommon.GetRsgakukei;
import yuyu.common.sinkeiyaku.skcommon.ISkCommonKoumoku;
import yuyu.common.sinkeiyaku.skcommon.SyouhinUtil;
import yuyu.def.MessageId;
import yuyu.def.biz.bean.param.BzRecoveryDatasikibetuBean;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_AisyoumeiKbn;
import yuyu.def.classification.C_CreditTrkjkKbn;
import yuyu.def.classification.C_CreditYuukoukakKbn;
import yuyu.def.classification.C_DirectServiceMosKbn;
import yuyu.def.classification.C_DiritenjyouhouKbn;
import yuyu.def.classification.C_DrtenChannelSyurui;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_HasinkyokaKbn;
import yuyu.def.classification.C_HasuusyoriKbn;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_Hrkkeiro;
import yuyu.def.classification.C_HubikaisyoujoutaiKbn;
import yuyu.def.classification.C_HubisyubetusyousaiKbn;
import yuyu.def.classification.C_IkkatubaraiKbn;
import yuyu.def.classification.C_ImusateijyouKbn;
import yuyu.def.classification.C_ImusateikaniyhKbn;
import yuyu.def.classification.C_JimusrhKbn;
import yuyu.def.classification.C_KahiKbn;
import yuyu.def.classification.C_Ketkekkacd;
import yuyu.def.classification.C_KetteiKbn;
import yuyu.def.classification.C_Knkysatei1jiyhKbn;
import yuyu.def.classification.C_KnkysateijyouKbn;
import yuyu.def.classification.C_KoureiKzkSetumeiHouKbn;
import yuyu.def.classification.C_KoureisyaTaiouKbn;
import yuyu.def.classification.C_Kouteikanristatus;
import yuyu.def.classification.C_KouzasyuruiKbn;
import yuyu.def.classification.C_KykkakjkKbn;
import yuyu.def.classification.C_Kykkaksyrui;
import yuyu.def.classification.C_MosUketukeKbn;
import yuyu.def.classification.C_NayoseJissiKekkaKbn;
import yuyu.def.classification.C_NayoseJyoutaiKbn;
import yuyu.def.classification.C_NyuukinjyoutaiKbn;
import yuyu.def.classification.C_PtratkituukasiteiKbn;
import yuyu.def.classification.C_SeirituKbn;
import yuyu.def.classification.C_SntkInfoTaisyousyaKbn;
import yuyu.def.classification.C_SntkhouKbn;
import yuyu.def.classification.C_SyorikekkaKbn;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.classification.C_SystemRenkeiHenkanHoukouKbn;
import yuyu.def.classification.C_TargetTkMokuhyoutiKbn;
import yuyu.def.classification.C_Tkhukaumu;
import yuyu.def.classification.C_TumitatekinHaibunWariKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UketorikouzasyubetuKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_ZenhnknKbn;
import yuyu.def.db.entity.BM_SyouhnZokusei;
import yuyu.def.db.entity.BT_GyoumuKouteiInfo;
import yuyu.def.db.entity.BT_HituyouSyoruiKanri;
import yuyu.def.db.entity.HT_CreditCardJyouhou;
import yuyu.def.db.entity.HT_DakuhiKettei;
import yuyu.def.db.entity.HT_HubiMsg;
import yuyu.def.db.entity.HT_ImusateiRireki;
import yuyu.def.db.entity.HT_KnksateiRireki;
import yuyu.def.db.entity.HT_KouzaJyouhou;
import yuyu.def.db.entity.HT_KykKak;
import yuyu.def.db.entity.HT_MosDairiten;
import yuyu.def.db.entity.HT_MosKihon;
import yuyu.def.db.entity.HT_MosSyouhn;
import yuyu.def.db.entity.HT_MostenkenRireki;
import yuyu.def.db.entity.HT_NayoseKekka;
import yuyu.def.db.entity.HT_Nyuukin;
import yuyu.def.db.entity.HT_SisyaToukeiHokan;
import yuyu.def.db.entity.HT_SkHubiDetail;
import yuyu.def.db.entity.HT_SkUriageData;
import yuyu.def.db.entity.HT_SyoriCTL;
import yuyu.def.db.entity.HT_UketoriKouzaJyouhou;
import yuyu.def.db.entity.ZT_DrtenIpToukeiTy;
import yuyu.def.db.entity.ZT_MosJkItiranSyoukaiTy;
import yuyu.def.db.entity.ZT_SkSeirituRituTy;
import yuyu.def.sinkeiyaku.configuration.YuyuSinkeiyakuConfig;
import yuyu.def.sinkeiyaku.manager.SinkeiyakuDomManager;
import yuyu.def.sinkeiyaku.sorter.SortHT_MosSyouhn;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.BatchParam;
import yuyu.infr.batch.logger.BatchLogger;

import com.google.common.base.Strings;

/**
 * 新契約 情報系 支社統計情報作成
 */
public class SkSisyaToukeiSksBatch implements Batch {

    @Inject
    private BatchLogger batchLogger;

    @Inject
    private BzBatchParam bzBatchParam;

    @Inject
    private SinkeiyakuDomManager sinkeiyakuDomManager;

    @Inject
    private BizDomManager bizDomManager;

    private int HenkouSqlCount;

    private List<ZT_DrtenIpToukeiTy> drtenTyTmpLst;

    private List<ZT_SkSeirituRituTy> skseiTyTmpLst;

    private List<ZT_MosJkItiranSyoukaiTy> mosjkTyTmpLst;

    private List<HT_SisyaToukeiHokan> sstInsTmpLst;

    private List<HT_SisyaToukeiHokan> sstUpdTmpLst;

    private List<HT_SisyaToukeiHokan> sstDelTmpLst;

    @Inject
    private BzRecoveryDatasikibetuBean bzRecoveryDatasikibetuBean;

    @Inject
    private SkSisyaToukeiSksDao skSisyaToukeiSksDao;

    private int flushLimit;

    @Override
    public BatchParam getParam() {
        return bzBatchParam;
    }

    @Execute
    @Transactional
    public void execute() {

        String tysyttaisyouTableID = "HT_SyoriCTL";
        String recoveryFilterID = "Sk001";
        BizDate syoriYmd = bzBatchParam.getSyoriYmd();
        String kakutyouJobCd = bzBatchParam.getIbKakutyoujobcd();
        String eigyouHonbuSisyaCd_Daikei = YuyuSinkeiyakuConfig.getInstance().getDairitenkyksosikicd();

        batchLogger.info(MessageUtil.getMessage(MessageId.IBA0016, MessageUtil.getMessage(MessageId.IBW0003),
            String.valueOf(syoriYmd)));

        batchLogger.info(MessageUtil.getMessage(MessageId.IBA0016, MessageUtil.getMessage(MessageId.IBW1018),
            kakutyouJobCd));

        long syoriKensuDrten = 0;
        long syoriKensuSeirtu = 0;
        long syoriKensuMoskms = 0;
        long syoriKensuHokan = 0;
        try (
            MultipleEntityInserter genInsertLst = new MultipleEntityInserter();
            EntityUpdater<HT_SisyaToukeiHokan> sisyaToukeiHokanUpdateLst = new EntityUpdater<>();
            EntityDeleter<HT_SisyaToukeiHokan> sisyaToukeiHokanDeleteLst = new EntityDeleter<>()) {
            List<HT_SisyaToukeiHokan> sisyaToukeiHokanLst;
            HT_SisyaToukeiHokan sisyaToukeiHokan;
            ArrayList<Integer> idxSstLst;
            BzGetAgInfo bzGetAgInfo = SWAKInjector.getInstance(BzGetAgInfo.class);
            BzGetSosikiData bzGetSosikiData = SWAKInjector.getInstance(BzGetSosikiData.class);
            BzGetBsInfo bzGetBsInfo = SWAKInjector.getInstance(BzGetBsInfo.class);
            SortHT_MosSyouhn sortMosSyouhn = SWAKInjector.getInstance(SortHT_MosSyouhn.class);
            KeisanGaikakanzan keisanGaikakanzan = SWAKInjector.getInstance(KeisanGaikakanzan.class);
            GetRsgakukei getRsgakukei = SWAKInjector.getInstance(GetRsgakukei.class);
            HenkanTuuka henkanTuuka = SWAKInjector.getInstance(HenkanTuuka.class);
            BzGetProcessSummary bzGetProcessSummary = SWAKInjector.getInstance(BzGetProcessSummary.class);
            GetSyoruittykymd getSyoruittykymd = SWAKInjector.getInstance(GetSyoruittykymd.class);
            BzKbnHenkanUtil bzKbnHenkanUtil = SWAKInjector.getInstance(BzKbnHenkanUtil.class);
            BizDateYM syoriYM = syoriYmd.getBizDateYM();
            String dairitenKeiyakuEgyoHobuShsyamei = "";
            String dairitenKeiyakuDrtenKanriSosikikimei = "";
            flushLimit = SwakDbConfig.getInstance().getUpdateBatchSize();
            HenkouSqlCount = 0;
            drtenTyTmpLst = new LinkedList<ZT_DrtenIpToukeiTy>();
            skseiTyTmpLst = new LinkedList<ZT_SkSeirituRituTy>();
            mosjkTyTmpLst = new LinkedList<ZT_MosJkItiranSyoukaiTy>();
            sstInsTmpLst = new LinkedList<HT_SisyaToukeiHokan>();
            sstUpdTmpLst = new LinkedList<HT_SisyaToukeiHokan>();
            sstDelTmpLst = new LinkedList<HT_SisyaToukeiHokan>();

            BizDateYM seirtMoskmsyoNryokTukdoFJ = syoriYM.addMonths(-2);
            BizDateYM seirtMoskmsyoNryokTukdoFItr = syoriYM.addMonths(3);
            BizDateYM dairtMoskmsyoNryokTukdoFJ = null;
            BizDateYM dairtMoskmsyoNryokTukdoFItr = null;
            BizDateYM mosJkMoskmsyoNryokTukdoFJ = null;
            BizDateYM mosJkMoskmsyoNryokTukdoFItr = null;

            if (syoriYmd.getDay() >= 1 && syoriYmd.getDay() <= 19) {
                dairtMoskmsyoNryokTukdoFJ = syoriYM.addMonths(-11);
                dairtMoskmsyoNryokTukdoFItr = syoriYM;
                mosJkMoskmsyoNryokTukdoFJ = syoriYM.addMonths(-2);
                mosJkMoskmsyoNryokTukdoFItr = syoriYM;
            }
            else {
                dairtMoskmsyoNryokTukdoFJ = syoriYM.addMonths(-10);
                dairtMoskmsyoNryokTukdoFItr = syoriYM.addMonths(1);
                mosJkMoskmsyoNryokTukdoFJ = syoriYM.addMonths(-1);
                mosJkMoskmsyoNryokTukdoFItr = syoriYM.addMonths(1);
            }

            String tempSosikimei = bzGetSosikiData.exec(eigyouHonbuSisyaCd_Daikei, syoriYmd).getKanjisosikinm20();
            dairitenKeiyakuEgyoHobuShsyamei = tempSosikimei;

            dairitenKeiyakuDrtenKanriSosikikimei = tempSosikimei;

            try (ExDBResults<HT_SyoriCTL> syoriCTLLst = sinkeiyakuDomManager
                .getSyoriCTLsByKakutyoujobcdMosnrkumuMosnrkymd(
                    kakutyouJobCd, dairtMoskmsyoNryokTukdoFJ.getFirstDay())) {
                EditPalRenkeiKoumoku editPalRenkeiKoumoku = SWAKInjector.getInstance(EditPalRenkeiKoumoku.class);

                for (HT_SyoriCTL syoriCTL : syoriCTLLst) {

                    C_UmuKbn dairtSyutrkF = C_UmuKbn.NONE;
                    C_UmuKbn seirtSyutrkF = C_UmuKbn.NONE;
                    C_UmuKbn mosjkSyutrkF = C_UmuKbn.NONE;
                    C_KahiKbn hokanRyuyokaitaTBL = C_KahiKbn.HUKA;

                    bzRecoveryDatasikibetuBean.setIbKakutyoujobcd(kakutyouJobCd);
                    bzRecoveryDatasikibetuBean.setIbTableid(tysyttaisyouTableID);
                    bzRecoveryDatasikibetuBean.setIbRecoveryfilterid(recoveryFilterID);
                    bzRecoveryDatasikibetuBean.setIbRecoveryfilterkey1(syoriCTL.getMosno());

                    BizDateYM moskmNrYM = syoriCTL.getMosnrkymd().getBizDateYM();
                    if ((BizDateUtil.compareYm(dairtMoskmsyoNryokTukdoFJ, moskmNrYM) == BizDateUtil.COMPARE_LESSER ||
                        BizDateUtil.compareYm(dairtMoskmsyoNryokTukdoFJ, moskmNrYM) == BizDateUtil.COMPARE_EQUAL) &&
                        (BizDateUtil.compareYm(dairtMoskmsyoNryokTukdoFItr, moskmNrYM) == BizDateUtil.COMPARE_GREATER ||
                        BizDateUtil.compareYm(dairtMoskmsyoNryokTukdoFItr, moskmNrYM) == BizDateUtil.COMPARE_EQUAL)) {
                        dairtSyutrkF = C_UmuKbn.ARI;
                    }
                    if ((BizDateUtil.compareYm(seirtMoskmsyoNryokTukdoFJ, moskmNrYM) == BizDateUtil.COMPARE_LESSER ||
                        BizDateUtil.compareYm(seirtMoskmsyoNryokTukdoFJ, moskmNrYM) == BizDateUtil.COMPARE_EQUAL) &&
                        (BizDateUtil.compareYm(seirtMoskmsyoNryokTukdoFItr, moskmNrYM) == BizDateUtil.COMPARE_GREATER ||
                        BizDateUtil.compareYm(seirtMoskmsyoNryokTukdoFItr, moskmNrYM) == BizDateUtil.COMPARE_EQUAL)) {
                        seirtSyutrkF = C_UmuKbn.ARI;
                    }
                    if ((BizDateUtil.compareYm(mosJkMoskmsyoNryokTukdoFJ, moskmNrYM) == BizDateUtil.COMPARE_LESSER ||
                        BizDateUtil.compareYm(mosJkMoskmsyoNryokTukdoFJ, moskmNrYM) == BizDateUtil.COMPARE_EQUAL) &&
                        (BizDateUtil.compareYm(mosJkMoskmsyoNryokTukdoFItr, moskmNrYM) == BizDateUtil.COMPARE_GREATER ||
                        BizDateUtil.compareYm(mosJkMoskmsyoNryokTukdoFItr, moskmNrYM) == BizDateUtil.COMPARE_EQUAL)) {
                        mosjkSyutrkF = C_UmuKbn.ARI;
                    }

                    sisyaToukeiHokanLst = sinkeiyakuDomManager
                        .getSisyaToukeiHokansBySstmosno(syoriCTL.getMosno());

                    idxSstLst = new ArrayList<Integer>();
                    if (sisyaToukeiHokanLst.size() == 1) {
                        idxSstLst.add(0);
                    }
                    else if (sisyaToukeiHokanLst.size() == 2) {
                        if (sisyaToukeiHokanLst.get(0).getRenno() == 1) {
                            idxSstLst.add(0);
                            idxSstLst.add(1);
                        }
                        else {
                            idxSstLst.add(1);
                            idxSstLst.add(0);
                        }
                    }

                    if (sisyaToukeiHokanLst.size() > 0) {
                        if (sisyaToukeiHokanLst.get(idxSstLst.get(0)).getSyrctrltblkostime().equals(
                            syoriCTL.getGyoumuKousinTime())) {
                            hokanRyuyokaitaTBL = C_KahiKbn.KA;
                        }
                    }

                    if (C_KahiKbn.KA.eq(hokanRyuyokaitaTBL)) {

                        for (HT_SisyaToukeiHokan sstForDetach : sisyaToukeiHokanLst) {
                            if (sstForDetach != null) {
                                sstForDetach.detach();
                            }
                        }

                        if (C_UmuKbn.ARI.eq(dairtSyutrkF) ||
                            C_UmuKbn.ARI.eq(seirtSyutrkF) ||
                            C_UmuKbn.ARI.eq(mosjkSyutrkF)) {
                            for (int i = 0; i < sisyaToukeiHokanLst.size(); i++) {
                                sisyaToukeiHokan = sisyaToukeiHokanLst.get(idxSstLst.get(i));
                                String kesyoSakiKryoDrtenCd = "";
                                String kesyoSakiKrKjDrtenNm = "";
                                C_DrtenChannelSyurui kesyoSakiKryoDrtenChannelSyurui = C_DrtenChannelSyurui.BLNK;
                                String kesyoSakiKryoKiknCd = "0000";
                                String kesyoSakiKryoKinyuuSitenCd = "";
                                String kesyoSakiKryoDrtenJimSyoCd = "";
                                String egyoHobuShsyamei = "";
                                String dairtenKanriSoshikikimei = "";
                                String tansyukuKjBosyuuNm = "";
                                String bosyuuTrkNo = "";
                                String tensyukuKjAtkishaNm = "";
                                String kouinnCd = "";
                                String drtenIpToukeikydatki = "0";

                                List<BzGetAgInfoBean> bzGetAgInfoBeanLst = bzGetAgInfo.exec(sisyaToukeiHokan
                                    .getTratkiagcd());
                                for (BzGetAgInfoBean bzGetAgInfoBean : bzGetAgInfoBeanLst) {
                                    if (C_DiritenjyouhouKbn.KEISYOUKO.eq(bzGetAgInfoBean.getDiritenJyouhouKbn())) {
                                        kesyoSakiKryoDrtenCd = bzGetAgInfoBean.getDrtenCd();
                                        kesyoSakiKryoDrtenChannelSyurui= bzGetAgInfoBean.getDrtenChannelSyurui();
                                        kesyoSakiKryoKiknCd = bzGetAgInfoBean.getKinyuuCd();
                                        kesyoSakiKryoKinyuuSitenCd = bzGetAgInfoBean.getKinyuuSitenCd();
                                        kesyoSakiKryoDrtenJimSyoCd = bzGetAgInfoBean.getDrtenJimCd();
                                        if (bzGetAgInfoBean.getKanjiDairitenNm().length() > 15) {
                                            kesyoSakiKrKjDrtenNm = bzGetAgInfoBean.getKanjiDairitenNm().
                                                substring(0, 15);
                                        }
                                        else {
                                            kesyoSakiKrKjDrtenNm = bzGetAgInfoBean.getKanjiDairitenNm();
                                        }
                                        break;
                                    }
                                }

                                //                                if ("1".equals(sisyaToukeiHokan.getSsttokusyujimutoriatukaikbn())){
                                egyoHobuShsyamei = dairitenKeiyakuEgyoHobuShsyamei;
                                dairtenKanriSoshikikimei = dairitenKeiyakuDrtenKanriSosikikimei;
                                //                                }
                                //                                else {
                                //                                    if (!"0000000".equals(sisyaToukeiHokan.getSstsosikicd())) {
                                //                                        egyoHobuShsyamei = bzGetSosikiData.exec(
                                //                                            sisyaToukeiHokan.getSstsosikicd().substring(0, 3) + "0000", syoriYmd)
                                //                                            .getKanjisosikinm20();
                                //                                        dairtenKanriSoshikikimei = bzGetSosikiData
                                //                                            .exec(sisyaToukeiHokan.getSstsosikicd(), syoriYmd).getKanjisosikinm20();
                                //                                    }
                                //                                }
                                BzGetBsInfoBean bzGetBsInfoBean = bzGetBsInfo.exec(sisyaToukeiHokan
                                    .getSstdaihyoubosyuunincd());
                                if (bzGetBsInfoBean != null) {
                                    if (bzGetBsInfoBean.getKanjiBosyuuninNm().length() > 7) {
                                        tansyukuKjBosyuuNm = bzGetBsInfoBean.getKanjiBosyuuninNm().substring(0, 7);
                                    }
                                    else {
                                        tansyukuKjBosyuuNm = bzGetBsInfoBean.getKanjiBosyuuninNm();
                                    }
                                }

                                if (!"000000".equals(sisyaToukeiHokan.getSstatukaikojincd())) {
                                    bzGetBsInfoBean = bzGetBsInfo.exec(sisyaToukeiHokan
                                        .getSstatukaikojincd());
                                    if (bzGetBsInfoBean != null) {
                                        if (bzGetBsInfoBean.getKanjiBosyuuninNm().length() > 7) {
                                            tensyukuKjAtkishaNm = bzGetBsInfoBean.getKanjiBosyuuninNm().substring(0, 7);
                                        }
                                        else {
                                            tensyukuKjAtkishaNm = bzGetBsInfoBean.getKanjiBosyuuninNm();
                                        }
                                        bosyuuTrkNo = bzGetBsInfoBean.getBosyuuTrkNo();

                                        if (bzGetBsInfoBean.getKouinCd().length() > 15) {
                                            kouinnCd = bzGetBsInfoBean.getKouinCd().substring(0, 15);
                                        }
                                        else {
                                            kouinnCd = bzGetBsInfoBean.getKouinCd();
                                        }
                                    }
                                }
                                if (sisyaToukeiHokan.getSstkydatkikbn().equals("0")){
                                    drtenIpToukeikydatki = "0";
                                }
                                else if (sisyaToukeiHokan.getRenno() == 1){
                                    drtenIpToukeikydatki = "1";
                                }
                                else {
                                    drtenIpToukeikydatki = "2";
                                }

                                if (C_UmuKbn.ARI.eq(dairtSyutrkF)) {
                                    ZT_DrtenIpToukeiTy drtenIpToukeiTy = new ZT_DrtenIpToukeiTy();

                                    drtenIpToukeiTy.setZtyeigyouhonbusisyacd(sisyaToukeiHokan.getSsteigyouhonbusisyacd());
                                    drtenIpToukeiTy.setZtysosikicd(sisyaToukeiHokan.getSstsosikicd());
                                    drtenIpToukeiTy.setZtyatukaikojincd(sisyaToukeiHokan.getSstatukaikojincd());
                                    drtenIpToukeiTy.setZtymosym(String.valueOf(moskmNrYM));
                                    drtenIpToukeiTy.setZtymoskbn(sisyaToukeiHokan.getSstmoskbn());
                                    drtenIpToukeiTy.setZtytansyukukjatukaisyanm(tensyukuKjAtkishaNm);
                                    drtenIpToukeiTy.setZtymosno(sisyaToukeiHokan.getSstmosno());
                                    drtenIpToukeiTy.setZtymossyoumetukbn(sisyaToukeiHokan.getSstmossyoumetukbn());
                                    drtenIpToukeiTy.setZtykurikosiriyuukbn(sisyaToukeiHokan.getSstkurikosiriyuukbn());
                                    drtenIpToukeiTy.setZtynyknzumihyouji(sisyaToukeiHokan.getSstnyknzumihyouji());
                                    drtenIpToukeiTy.setZtytoukeihknsyruikbn(sisyaToukeiHokan.getSsttoukeiyouhknsyuruikbn());
                                    drtenIpToukeiTy.setZtyhjykktkbn(sisyaToukeiHokan.getSsthoujyoukokutikbn());
                                    drtenIpToukeiTy.setZtykykktaikbn(sisyaToukeiHokan.getSstkykkeitaikbn());
                                    drtenIpToukeiTy.setZtyjyunhsys(sisyaToukeiHokan.getSstjyunhsys() / 1000);
                                    drtenIpToukeiTy.setZtyhsys(sisyaToukeiHokan.getSsthsys() / 1000);
                                    drtenIpToukeiTy.setZtysoukensuu(sisyaToukeiHokan.getSstsoukensuu());
                                    drtenIpToukeiTy.setZtyketjkkbn(sisyaToukeiHokan.getSstketteijkkbn());
                                    drtenIpToukeiTy.setZtydakuhiktjyoutaikbn(sisyaToukeiHokan
                                        .getSstdakuhiketteijyoutaikbn());
                                    drtenIpToukeiTy.setZtykihonhubi(sisyaToukeiHokan.getSstkihonhubi());
                                    drtenIpToukeiTy.setZtysphubi(sisyaToukeiHokan.getSstsphubi());
                                    drtenIpToukeiTy.setZtysseigenhubi(sisyaToukeiHokan.getSstsseigenhubi());
                                    drtenIpToukeiTy.setZtynayosehumei(sisyaToukeiHokan.getSstnayosehumei());
                                    drtenIpToukeiTy.setZtytuusangendoover(sisyaToukeiHokan.getSsttuusangendoover());
                                    drtenIpToukeiTy.setZtymosketteihoryuu(sisyaToukeiHokan.getSstmosketteihoryuu());
                                    drtenIpToukeiTy.setZtykykkakjissityuu(sisyaToukeiHokan.getSstkykkakuninjissityuu());
                                    drtenIpToukeiTy.setZtykktketteihoryuu(sisyaToukeiHokan.getSstkokutiketteihoryuu());
                                    drtenIpToukeiTy.setZtyhonsyakethoryuu(sisyaToukeiHokan.getSsthonsyaketteihoryuu());
                                    drtenIpToukeiTy.setZtyseiymdhubi(sisyaToukeiHokan.getSstseiymdhubi());
                                    drtenIpToukeiTy.setZtyphusoku(sisyaToukeiHokan.getSstphusoku());
                                    drtenIpToukeiTy.setZtysrhuketyu(sisyaToukeiHokan.getSstseirituhoryuuuketuketyuu());
                                    drtenIpToukeiTy.setZtypkakin(sisyaToukeiHokan.getSstpkakin());
                                    drtenIpToukeiTy.setZtybsudirtnatkikeitaikbn(sisyaToukeiHokan.
                                        getSstbosyuudrtenatkikeitaikbn());
                                    drtenIpToukeiTy.setZtysakuseiymd(syoriYmd.toString());
                                    drtenIpToukeiTy.setZtykydatkikbn(drtenIpToukeikydatki);
                                    drtenIpToukeiTy.setZtytansyukukjhhknnm(sisyaToukeiHokan.getSsttansyukukjhhknnm());
                                    drtenIpToukeiTy.setZtyhhknsykgycd(sisyaToukeiHokan.getSsthhknsyokugyoucd());
                                    drtenIpToukeiTy.setZtyhhknnen2keta(sisyaToukeiHokan.getSsthhknnen2keta());
                                    drtenIpToukeiTy.setZtyhhknseikbn(sisyaToukeiHokan.getSsthhknseikbn());
                                    drtenIpToukeiTy.setZtymusymd(sisyaToukeiHokan.getSstmosymd());
                                    drtenIpToukeiTy.setZtysyokaipryosyuymd(sisyaToukeiHokan.getSstfstpryousyuuymd());
                                    drtenIpToukeiTy.setZtykokutiymd(sisyaToukeiHokan.getSstkokutiymd());
                                    drtenIpToukeiTy.setZtymosnyuuryokuymd(sisyaToukeiHokan.getSstmosnyuuryokuymd());
                                    drtenIpToukeiTy.setZtykykymd(sisyaToukeiHokan.getSstkykymd());
                                    drtenIpToukeiTy.setZtysekininkaisiymd(sisyaToukeiHokan.getSstsekininkaisiymd());
                                    drtenIpToukeiTy.setZtyfstpnyknsyoriymd(sisyaToukeiHokan.getSstfstpnyknsyoriymd());
                                    drtenIpToukeiTy.setZtyfstpnyknnaiyoukbn(sisyaToukeiHokan.getSstfstpnyknnaiyoukbn());
                                    drtenIpToukeiTy.setZtysisyaketsyoriymd(sisyaToukeiHokan.getSstsisyaketteisyoriymd());
                                    drtenIpToukeiTy.setZtysyosakuseiymd(sisyaToukeiHokan.getSstsyoukensakuseiymd());
                                    drtenIpToukeiTy.setZtyseisekiym(sisyaToukeiHokan.getSstseisekikijyym());
                                    drtenIpToukeiTy.setZtysyokaiharaikomip(sisyaToukeiHokan.getSstfstphrkgkyen());
                                    drtenIpToukeiTy.setZtysyono(sisyaToukeiHokan.getSstsyono());
                                    drtenIpToukeiTy.setZtytokusyujimutoriatukaikbn(sisyaToukeiHokan.
                                        getSsttokusyujimutoriatukaikbn());
                                    drtenIpToukeiTy.setZtybsydrtencd(kesyoSakiKryoDrtenCd);
                                    drtenIpToukeiTy.setZtybsydrtenkjnm(kesyoSakiKrKjDrtenNm);
                                    drtenIpToukeiTy.setZtyatkisyagyskkjsosikicd(sisyaToukeiHokan.
                                        getSstatkisyagyskkjsosikicd());
                                    drtenIpToukeiTy.setZtyatkisyadrtenatkiwari(sisyaToukeiHokan.
                                        getSstatkisyadrtenatkiwari());
                                    drtenIpToukeiTy.setZtyhknkkn(sisyaToukeiHokan.getSsthknkkn());
                                    drtenIpToukeiTy.setZtyphrkkikn(sisyaToukeiHokan.getSstphrkkikn());
                                    drtenIpToukeiTy.setZtyhrkkaisuukbn(sisyaToukeiHokan.getSsthrkkaisuukbn());
                                    drtenIpToukeiTy.setZtyhrkkeirokbn(sisyaToukeiHokan.getSsthrkkeirokbn());
                                    if (C_DrtenChannelSyurui.GINHONTAIMADO.eq(kesyoSakiKryoDrtenChannelSyurui)) {
                                        drtenIpToukeiTy.setZtykinyuukikancd(kesyoSakiKryoKiknCd);
                                        if (kesyoSakiKryoKinyuuSitenCd.length() > 3) {
                                            drtenIpToukeiTy.setZtyinfositencd(kesyoSakiKryoKinyuuSitenCd.substring(1, 4));
                                        }
                                        else {
                                            drtenIpToukeiTy.setZtyinfositencd(kesyoSakiKryoKinyuuSitenCd);
                                        }
                                    }
                                    else {
                                        drtenIpToukeiTy.setZtykinyuukikancd("0000");
                                        drtenIpToukeiTy.setZtyinfositencd("");
                                    }
                                    drtenIpToukeiTy.setZtycifcd(sisyaToukeiHokan.getSstcifcd());
                                    drtenIpToukeiTy.setZtykjkyknm10(sisyaToukeiHokan.getSstkjkyknm10());
                                    drtenIpToukeiTy.setZtykthhbhyouji(sisyaToukeiHokan.getSstketteihoryuuhubihyouji());
                                    drtenIpToukeiTy.setZtysrhhbhyouji(sisyaToukeiHokan.getSstseirituhoryuuhubihyouji());
                                    drtenIpToukeiTy.setZtymossyumtkktymd(sisyaToukeiHokan.getSstmossyoumetukakuteiymd());
                                    drtenIpToukeiTy.setZtydairitenjimusyocd(kesyoSakiKryoDrtenJimSyoCd);
                                    drtenIpToukeiTy.setZtytsrybnwari(sisyaToukeiHokan.getSsttsrybnwari());
                                    drtenIpToukeiTy.setZtydrtenkeijyouym(sisyaToukeiHokan.getSstdrtenkeijyouym());
                                    drtenIpToukeiTy.setZtykydatkidairitencd(sisyaToukeiHokan.getSstkydatkidairitencd());
                                    drtenIpToukeiTy.setZtydaihyoubosyuunincd(sisyaToukeiHokan.getSstdaihyoubosyuunincd());
                                    drtenIpToukeiTy.setZtytansyukukjdhybosyuunm(tansyukuKjBosyuuNm);
                                    drtenIpToukeiTy.setZtyknkyknm15(sisyaToukeiHokan.getSstknkyknm15());
                                    drtenIpToukeiTy.setZtydakuhikettikekkacd(sisyaToukeiHokan.getSstdakuhiketteikekkacd());
                                    drtenIpToukeiTy.setZtydkhktiymd(sisyaToukeiHokan.getSstdakuhiketteiymd());
                                    drtenIpToukeiTy.setZtytoukeiyousinsakbn(sisyaToukeiHokan.getSsttoukeiyousinsakbn());
                                    drtenIpToukeiTy.setZtyhonninkknnkbn(sisyaToukeiHokan.getSsthonninkakuninkbn());
                                    drtenIpToukeiTy.setZtynstkarihyj(sisyaToukeiHokan.getSstnkshrtkykarihyouji());
                                    drtenIpToukeiTy.setZtynstknkkkn(sisyaToukeiHokan.getSstnkshrtkyknkkkn());
                                    drtenIpToukeiTy.setZtydrtentsryhushrkykhyouji(sisyaToukeiHokan.
                                        getSstdrtentsryhushrkykhyouji());
                                    drtenIpToukeiTy.setZtynyknkanskanouhyouji(sisyaToukeiHokan.getSstnyknkanskanouhyouji());
                                    drtenIpToukeiTy.setZtydshukahyouji(sisyaToukeiHokan.getSstdshukahyouji());
                                    drtenIpToukeiTy.setZtystdairiseikyuutkykarihyj(sisyaToukeiHokan.
                                        getSstsiteidairisktkykarihyouj());
                                    drtenIpToukeiTy.setZtykyksyanen(sisyaToukeiHokan.getSstkyksyanen());
                                    drtenIpToukeiTy.setZtykyksyaseikbn(sisyaToukeiHokan.getSstkyksyaseikbn());
                                    drtenIpToukeiTy.setZtyhhknseiymd(sisyaToukeiHokan.getSsthhknseiymd());
                                    drtenIpToukeiTy.setZtydrtenpaperlessmoshyj(sisyaToukeiHokan.getSstdrtenpaperlessmoshyj());
                                    drtenIpToukeiTy.setZtydrtenmostousyaukeymd(sisyaToukeiHokan.getSstdrtenmostousyaukeymd());
                                    drtenIpToukeiTy.setZtykyktuuka(sisyaToukeiHokan.getSstkyktuuka());
                                    drtenIpToukeiTy.setZtyhrktuuka(sisyaToukeiHokan.getSsthrktuuka());
                                    drtenIpToukeiTy.setZtysykihrkpgaika(sisyaToukeiHokan.getSstfstphrkgkgaika());
                                    drtenIpToukeiTy.setZtyyennykntkarihyouji(sisyaToukeiHokan.getSstyennykntkykarihyouji());
                                    drtenIpToukeiTy.setZtygaikanykntkarihyouji(sisyaToukeiHokan.
                                        getSstgaikanykntkykarihyouji());
                                    drtenIpToukeiTy.setZtykihonsgaika(sisyaToukeiHokan.getSstkihonsgaika());
                                    drtenIpToukeiTy.setZtytekiyoukawaserate(sisyaToukeiHokan.getSsttekiyoukawaserate());
                                    drtenIpToukeiTy.setZtykawaseratetekiyouymd(sisyaToukeiHokan.
                                        getSstkawaseratetekiyouymd());
                                    drtenIpToukeiTy.setZtymkhyoutiyensysnikoukbn(sisyaToukeiHokan.getSstmkhyoutiyensysnikoukbn());
                                    drtenIpToukeiTy.setZtysyksbyensitihsyutkykhyj(sisyaToukeiHokan.getSstsyksbyensitihsyutkykhyj());
                                    drtenIpToukeiTy.setZtyjyudkaigomehrtkarihyj(sisyaToukeiHokan.getSstjyudkaigomehrtkarihyj());
                                    drtenIpToukeiTy.setZtysykihrkpsiteituuka(sisyaToukeiHokan.getSstfstphrkgksiteituuka());
                                    drtenIpToukeiTy.setZtyteirituhaibunwari(sisyaToukeiHokan.getSstteirituhaibunwari());
                                    drtenIpToukeiTy.setZtysueokikknkbn(sisyaToukeiHokan.getSstsueokikknkbn());
                                    drtenIpToukeiTy.setZtynksyuruikbn1(sisyaToukeiHokan.getSstnksyuruikbn1());
                                    drtenIpToukeiTy.setZtydairitenkbtinfo1(sisyaToukeiHokan.getSstbosyuudrtenkobetuinfo1());
                                    drtenIpToukeiTy.setZtydairitenkbtinfo2(sisyaToukeiHokan.getSstbosyuudrtenkobetuinfo2());
                                    drtenIpToukeiTy.setZtydairitenkbtinfo3(sisyaToukeiHokan.getSstbosyuudrtenkobetuinfo3());
                                    drtenIpToukeiTy.setZtyyohurimiryou(sisyaToukeiHokan.getSstyohurimiryou());
                                    drtenIpToukeiTy.setZtykznyuuryokuymd(sisyaToukeiHokan.getSstkouzanyuuryokuymd());
                                    drtenIpToukeiTy.setZtysetaitemosno(sisyaToukeiHokan.getSstsetaitemosno());
                                    drtenIpToukeiTy.setZtyyakkanjyuryouhoukbn(sisyaToukeiHokan.getSstyakkanjyuryouhoukbn());
                                    drtenIpToukeiTy.setZtyyakkanbunsyono(sisyaToukeiHokan.getSstyakkanbunsyono());
                                    drtenIpToukeiTy.setZtykzhuritourokuhoukbn(sisyaToukeiHokan.getSstkzhuritourokuhoukbn());
                                    drtenIpToukeiTy.setZtydai1hknkkn(sisyaToukeiHokan.getSstdai1hknkkn());
                                    drtenIpToukeiTy.setZtycreditnyuuryokuymd(sisyaToukeiHokan.getSstcreditnyuuryokuymd());
                                    drtenIpToukeiTy.setZtycreditmiryou(sisyaToukeiHokan.getSstcreditmiryou());
                                    drtenIpToukeiTy.setZtycredittrkhoukbn(sisyaToukeiHokan.getSstcredittrkhoukbn());
                                    drtenIpToukeiTy.setZtycardbrandkbn(sisyaToukeiHokan.getSstcardbrandkbn());
                                    drtenIpToukeiTy.setZtycarddatasousinymd(sisyaToukeiHokan.getSstcarddatasousinymd());
                                    drtenIpToukeiTy.setZtykykdrtkykarihyj(sisyaToukeiHokan.getSstkykdrtkykarihyj());
                                    drtenIpToukeiTy.setZtykzktrkservicekbn(sisyaToukeiHokan.getSstkzktrkservicekbn());
                                    drtenIpToukeiTy.setZtyteikisiharaiarihyj(sisyaToukeiHokan.getSstteikishrtkykarihyouji());
                                    drtenIpToukeiTy.setZtyteikishrkinshrtuukakbn(sisyaToukeiHokan.getSstteikishrkinshrtuukakbn());
                                    drtenIpToukeiTy.setZtyteikisiharaikin(sisyaToukeiHokan.getSstteikisiharaikin());
                                    drtenIpToukeiTy.setZtykoureikzksetumeihoukbn(sisyaToukeiHokan.getSstkoureikzksetumeihoukbn());
                                    drtenIpToukeiTy.setZtykoureimndnhukusuukaikbn(sisyaToukeiHokan.getSstkoureimndnhukusuukaikbn());
                                    drtenIpToukeiTy.setZtykoureitratkisyaigidskkbn(sisyaToukeiHokan.getSstkoureitratkisyaigidskkbn());
                                    drtenIpToukeiTy.setZtyhknsyukigou(sisyaToukeiHokan.getSsthknsyukigou());
                                    drtenIpToukeiTy.setZtysaimnkkykhyj(sisyaToukeiHokan.getSstsaimnkkykhyj());
                                    drtenIpToukeiTy.setZtynnknsnpssysyup(sisyaToukeiHokan.getSstnnknsnpssysyup());
                                    drtenIpToukeiTy.setZtynnknsnpssykwsrate(sisyaToukeiHokan.getSstnnknsnpssykwsrate());
                                    drtenIpToukeiTy.setZtyzennoup(sisyaToukeiHokan.getSstzennoup());
                                    drtenIpToukeiTy.setZtynenkinzeiseitokuyakukbn(sisyaToukeiHokan.getSstnenkinzeiseitokuyakukbn());

                                    BizPropertyInitializer.initialize(drtenIpToukeiTy);
                                    addHenkouSqlCountDrtenIns(genInsertLst, sisyaToukeiHokanDeleteLst,
                                        sisyaToukeiHokanUpdateLst, drtenIpToukeiTy);

                                    syoriKensuDrten++;
                                }

                                if (C_UmuKbn.ARI.eq(seirtSyutrkF)) {
                                    ZT_SkSeirituRituTy skSeirituRituTy = new ZT_SkSeirituRituTy();

                                    skSeirituRituTy.setZtyeigyouhonbusisyacd(eigyouHonbuSisyaCd_Daikei);
                                    skSeirituRituTy.setZtysisyanm(egyoHobuShsyamei);
                                    skSeirituRituTy.setZtysosikicd(eigyouHonbuSisyaCd_Daikei);
                                    skSeirituRituTy.setZtykanjisosikinm20(dairtenKanriSoshikikimei);
                                    skSeirituRituTy.setZtyatukaisyadrtenhyouji(sisyaToukeiHokan.
                                        getSstatukaisyadrtenhyouji());
                                    skSeirituRituTy.setZtyatukaikojincd(sisyaToukeiHokan.getSstatukaikojincd());
                                    skSeirituRituTy.setZtytansyukukjatukaisyanm(tensyukuKjAtkishaNm);
                                    skSeirituRituTy.setZtymosno(sisyaToukeiHokan.getSstmosno());
                                    skSeirituRituTy.setZtyknjhhknmei(sisyaToukeiHokan.getSstkanjihihokensyanm());
                                    skSeirituRituTy.setZtyhhknnen2keta(sisyaToukeiHokan.getSsthhknnen2keta());
                                    skSeirituRituTy.setZtykyksyanen(sisyaToukeiHokan.getSstkyksyanen());
                                    skSeirituRituTy.setZtymosym(String.valueOf(moskmNrYM));
                                    skSeirituRituTy.setZtymosnyuuryokuymd(sisyaToukeiHokan.getSstmosnyuuryokuymd());
                                    skSeirituRituTy.setZtymoskbn(sisyaToukeiHokan.getSstmoskbn());
                                    skSeirituRituTy.setZtymossyoumetukbn(sisyaToukeiHokan.getSstmossyoumetukbn());
                                    skSeirituRituTy.setZtymossyumtkktymd(sisyaToukeiHokan.getSstmossyoumetukakuteiymd());
                                    skSeirituRituTy.setZtykurikosiriyuukbn(sisyaToukeiHokan.getSstkurikosiriyuukbn());
                                    skSeirituRituTy.setZtynyknzumihyouji(sisyaToukeiHokan.getSstnyknzumihyouji());
                                    skSeirituRituTy.setZtynyknjkkbn(sisyaToukeiHokan.getSstnyknjkkbn());
                                    skSeirituRituTy.setZtyketjkkbn(sisyaToukeiHokan.getSstketteijkkbn());
                                    skSeirituRituTy.setZtydakuhiktjyoutaikbn(sisyaToukeiHokan.
                                        getSstdakuhiketteijyoutaikbn());
                                    skSeirituRituTy.setZtykokutiymd(sisyaToukeiHokan.getSstkokutiymd());
                                    skSeirituRituTy.setZtyhjykktkbn(sisyaToukeiHokan.getSsthoujyoukokutikbn());
                                    skSeirituRituTy.setZtytokuteikanikokutikbn(sisyaToukeiHokan.
                                        getSsttokuteikanikokutikbn());
                                    skSeirituRituTy.setZtydakuhikettikekkacd(sisyaToukeiHokan.getSstdakuhiketteikekkacd());
                                    skSeirituRituTy.setZtysinhsys(sisyaToukeiHokan.getSstsinhsys());
                                    skSeirituRituTy.setZtyjyunhsys(sisyaToukeiHokan.getSstjyunhsys());
                                    skSeirituRituTy.setZtyhsys(sisyaToukeiHokan.getSsthsys());
                                    skSeirituRituTy.setZtysoukensuu(sisyaToukeiHokan.getSstsoukensuu());
                                    skSeirituRituTy.setZtytoukeihknsyruikbn(sisyaToukeiHokan.getSsttoukeiyouhknsyuruikbn());
                                    skSeirituRituTy.setZtyhrkkaisuukbn(sisyaToukeiHokan.getSsthrkkaisuukbn());
                                    skSeirituRituTy.setZtyhrkkeirokbn(sisyaToukeiHokan.getSsthrkkeirokbn());
                                    skSeirituRituTy.setZtykykktaikbn(sisyaToukeiHokan.getSstkykkeitaikbn());
                                    skSeirituRituTy.setZtybsudirtnatkikeitaikbn(sisyaToukeiHokan.
                                        getSstbosyuudrtenatkikeitaikbn());
                                    skSeirituRituTy.setZtytokusyujimutoriatukaikbn(sisyaToukeiHokan.
                                        getSsttokusyujimutoriatukaikbn());
                                    skSeirituRituTy.setZtykihonhubi(sisyaToukeiHokan.getSstkihonhubi());
                                    skSeirituRituTy.setZtysphubi(sisyaToukeiHokan.getSstsphubi());
                                    skSeirituRituTy.setZtysseigenhubi(sisyaToukeiHokan.getSstsseigenhubi());
                                    skSeirituRituTy.setZtynayosehumei(sisyaToukeiHokan.getSstnayosehumei());
                                    skSeirituRituTy.setZtytuusangendoover(sisyaToukeiHokan.getSsttuusangendoover());
                                    skSeirituRituTy.setZtymosketteihoryuu(sisyaToukeiHokan.getSstmosketteihoryuu());
                                    skSeirituRituTy.setZtykykkakjissityuu(sisyaToukeiHokan.getSstkykkakuninjissityuu());
                                    skSeirituRituTy.setZtykktketteihoryuu(sisyaToukeiHokan.getSstkokutiketteihoryuu());
                                    skSeirituRituTy.setZtyhonsyakethoryuu(sisyaToukeiHokan.getSsthonsyaketteihoryuu());
                                    skSeirituRituTy.setZtyseiymdhubi(sisyaToukeiHokan.getSstseiymdhubi());
                                    skSeirituRituTy.setZtyphusoku(sisyaToukeiHokan.getSstphusoku());
                                    skSeirituRituTy.setZtysrhuketyu(sisyaToukeiHokan.getSstseirituhoryuuuketuketyuu());
                                    skSeirituRituTy.setZtypkakin(sisyaToukeiHokan.getSstpkakin());
                                    skSeirituRituTy.setZtymostoutyakuymd(sisyaToukeiHokan.getSstmostoutyakuymd());
                                    skSeirituRituTy.setZtykkttoutyakuymd(sisyaToukeiHokan.getSstkkttoutyakuymd());
                                    skSeirituRituTy.setZtysakuseiymd(syoriYmd.toString());
                                    skSeirituRituTy.setZtysyokaipnyuknhuhukbn2(sisyaToukeiHokan.getSstfstpnyknhouhoukbn2());
                                    skSeirituRituTy.setZtysyokaiharaikomip(sisyaToukeiHokan.getSstfstpsshkhrkgkyen());
                                    skSeirituRituTy.setZtyryousyuuymd(sisyaToukeiHokan.getSstryousyuuymd());
                                    skSeirituRituTy.setZtykeiyakukakuninsyuruikbn(sisyaToukeiHokan.
                                        getSstkykkakuninsyuruikbn());
                                    skSeirituRituTy.setZtykykkakjkkbn1(sisyaToukeiHokan.getSstkykkakuninjkkbn1());
                                    skSeirituRituTy.setZtymusymd(sisyaToukeiHokan.getSstmosymd());
                                    skSeirituRituTy.setZtymossyosakuseiymd(sisyaToukeiHokan.getSstmossakuseiymd());
                                    skSeirituRituTy.setZtysyosakuseiymd(sisyaToukeiHokan.getSstsyoukensakuseiymd());
                                    skSeirituRituTy.setZtykjkyknm(sisyaToukeiHokan.getSstkjkyknm());
                                    skSeirituRituTy.setZtyknkyknm18(sisyaToukeiHokan.getSstknkyknm18());
                                    skSeirituRituTy.setZtyseirituyoukihontikucd(sisyaToukeiHokan.
                                        getSstseirituyoukihontikucd());
                                    skSeirituRituTy.setZtymosksnym(sisyaToukeiHokan.getSstmosksnym());
                                    skSeirituRituTy.setZtyyohurimiryou(sisyaToukeiHokan.getSstyohurimiryou());
                                    skSeirituRituTy.setZtycreditmiryou(sisyaToukeiHokan.getSstcreditmiryou());
                                    skSeirituRituTy.setZtykzktrkservicekbn(sisyaToukeiHokan.getSstkzktrkservicekbn());
                                    skSeirituRituTy.setZtykykdrtkykarihyj(sisyaToukeiHokan.getSstkykdrtkykarihyj());
                                    skSeirituRituTy.setZtystdairiseikyuutkykarihyj(sisyaToukeiHokan.getSstsiteidairisktkykarihyouj());
                                    skSeirituRituTy.setZtyyakkanjyuryouhoukbn(sisyaToukeiHokan.getSstyakkanjyuryouhoukbn());
                                    skSeirituRituTy.setZtyyakkanbunsyono(sisyaToukeiHokan.getSstyakkanbunsyono());
                                    skSeirituRituTy.setZtykzktuutityokusoukbn(sisyaToukeiHokan.getSstkzktuutityokusoukbn());

                                    BizPropertyInitializer.initialize(skSeirituRituTy);

                                    addHenkouSqlCountSkseiIns(genInsertLst, sisyaToukeiHokanDeleteLst,
                                        sisyaToukeiHokanUpdateLst, skSeirituRituTy);

                                    syoriKensuSeirtu++;
                                }

                                if (C_UmuKbn.ARI.eq(mosjkSyutrkF)
                                    && !BizUtil.isBlank(sisyaToukeiHokan.getTratkiagcd())
                                    && !sisyaToukeiHokan.getSstatukaikojincd().equals("000000")) {
                                    ZT_MosJkItiranSyoukaiTy mosJkItiranSyoukaiTy = new ZT_MosJkItiranSyoukaiTy();

                                    mosJkItiranSyoukaiTy.setZtymosym(getZtymosym(syoriCTL,sisyaToukeiHokan.getSstmosymd()));
                                    mosJkItiranSyoukaiTy.setZtymoskbn(sisyaToukeiHokan.getSstmoskbn());
                                    mosJkItiranSyoukaiTy.setZtymosno(sisyaToukeiHokan.getSstmosno());
                                    mosJkItiranSyoukaiTy.setZtyhknsyuruinm(sisyaToukeiHokan.getSsthknsyuruinm());
                                    mosJkItiranSyoukaiTy.setZtykykymd(sisyaToukeiHokan.getSstkykymd());
                                    mosJkItiranSyoukaiTy.setZtymusymd(sisyaToukeiHokan.getSstmosymd());
                                    mosJkItiranSyoukaiTy.setZtymosnyuuryokuymd(sisyaToukeiHokan.getSstmosnyuuryokuymd());
                                    mosJkItiranSyoukaiTy.setZtykydatkikbn(sisyaToukeiHokan.getSstkydatkikbn());
                                    mosJkItiranSyoukaiTy.setZtybsudirtnatkikeitaikbn(sisyaToukeiHokan.
                                        getSstbosyuudrtenatkikeitaikbn());
                                    mosJkItiranSyoukaiTy.setZtybsydrtencd(kesyoSakiKryoDrtenCd);
                                    mosJkItiranSyoukaiTy.setZtybsydrtenkjnm(kesyoSakiKrKjDrtenNm);
                                    mosJkItiranSyoukaiTy.setZtyatukaikojincd(sisyaToukeiHokan.getSstatukaikojincd());
                                    mosJkItiranSyoukaiTy.setZtytansyukukjatukaisyanm(tensyukuKjAtkishaNm);
                                    mosJkItiranSyoukaiTy.setZtycifcd(sisyaToukeiHokan.getSstcifcd());
                                    mosJkItiranSyoukaiTy.setZtykjkyknm10(sisyaToukeiHokan.getSstkjkyknm10());
                                    mosJkItiranSyoukaiTy.setZtytansyukukjhhknnm(sisyaToukeiHokan.getSsttansyukukjhhknnm());
                                    mosJkItiranSyoukaiTy.setZtyhhknnen2keta(sisyaToukeiHokan.getSsthhknnen2keta());
                                    mosJkItiranSyoukaiTy.setZtyhhknseikbn(sisyaToukeiHokan.getSsthhknseikbn());
                                    mosJkItiranSyoukaiTy.setZtymossyoumetukbn(sisyaToukeiHokan.getSstmossyoumetukbn());
                                    mosJkItiranSyoukaiTy.setZtykurikosiriyuukbn(sisyaToukeiHokan.getSstkurikosiriyuukbn());
                                    mosJkItiranSyoukaiTy.setZtyketjkkbn(sisyaToukeiHokan.getSstketteijkkbn());
                                    mosJkItiranSyoukaiTy.setZtydakuhiktjyoutaikbn(sisyaToukeiHokan.
                                        getSstdakuhiketteijyoutaikbn());
                                    mosJkItiranSyoukaiTy.setZtymosketkekkakbn(sisyaToukeiHokan.getSstmosketteikekkakbn());
                                    mosJkItiranSyoukaiTy.setZtykihonhubi(sisyaToukeiHokan.getSstkihonhubi());
                                    mosJkItiranSyoukaiTy.setZtykthhbhyouji(sisyaToukeiHokan.getSstketteihoryuuhubihyouji());
                                    mosJkItiranSyoukaiTy.setZtysrhhbhyouji(
                                        sisyaToukeiHokan.getSstseirituhoryuuhubihyouji());
                                    mosJkItiranSyoukaiTy.setZtynyknzumihyouji(sisyaToukeiHokan.getSstnyknzumihyouji());
                                    mosJkItiranSyoukaiTy.setZtysinsazumihyouji(sisyaToukeiHokan.getSstsinsazumihyouji());
                                    mosJkItiranSyoukaiTy.setZtytuukatanikbn(sisyaToukeiHokan.getSsttuukatanikbn());
                                    mosJkItiranSyoukaiTy.setZtysyokaihrkpmoji(sisyaToukeiHokan.
                                        getSstfstphrkgkhrktuukamoji());
                                    mosJkItiranSyoukaiTy.setZtyhjykktkbn(sisyaToukeiHokan.getSsthoujyoukokutikbn());
                                    mosJkItiranSyoukaiTy.setZtysyokaipryosyuymd(sisyaToukeiHokan.getSstfstpryousyuuymd());
                                    mosJkItiranSyoukaiTy.setZtykokutiymd(sisyaToukeiHokan.getSstkokutiymd());
                                    mosJkItiranSyoukaiTy.setZtykariseirituymd(sisyaToukeiHokan.getSstkariseirituymd());
                                    mosJkItiranSyoukaiTy.setZtyfstpnyknnaiyoukbn(
                                        sisyaToukeiHokan.getSstfstpnyknnaiyoukbn());
                                    mosJkItiranSyoukaiTy.setZtyhknkkn(sisyaToukeiHokan.getSsthknkkn());
                                    mosJkItiranSyoukaiTy.setZtyphrkkikn(sisyaToukeiHokan.getSstphrkkikn());
                                    mosJkItiranSyoukaiTy.setZtyhrkkaisuukbn(sisyaToukeiHokan.getSsthrkkaisuukbn());
                                    if (BizUtil.isBlank(sisyaToukeiHokan.getSsthrkkeirokbn())) {
                                        mosJkItiranSyoukaiTy.setZtyhrkkeirokbn("0");
                                    } else {
                                        mosJkItiranSyoukaiTy.setZtyhrkkeirokbn(sisyaToukeiHokan.getSsthrkkeirokbn());
                                    }
                                    mosJkItiranSyoukaiTy.setZtysakuseiymd(sisyaToukeiHokan.getSstsakuseiymd());
                                    mosJkItiranSyoukaiTy.setZtyanniskcd(sisyaToukeiHokan.getSstannaisakicd());
                                    mosJkItiranSyoukaiTy.setZtysyosakuseiymd(sisyaToukeiHokan.getSstsyoukensakuseiymd());
                                    mosJkItiranSyoukaiTy.setZtybsydrtenkobetuinfo1("");
                                    mosJkItiranSyoukaiTy.setZtybsydrtenkobetuinfo2(sisyaToukeiHokan.
                                        getSstbosyuudrtenkobetuinfo2());
                                    mosJkItiranSyoukaiTy.setZtybsydrtenkobetuinfo3(sisyaToukeiHokan.
                                        getSstbosyuudrtenkobetuinfo3());
                                    mosJkItiranSyoukaiTy.setZtybsydrtenkobetuinfo4(kouinnCd);
                                    mosJkItiranSyoukaiTy.setZtybsydrtenkobetuinfo5(sisyaToukeiHokan.
                                        getSstbosyuudrtenkobetuinfo5());
                                    mosJkItiranSyoukaiTy.setZtybankkouincd(sisyaToukeiHokan.getSstbankkouincd());
                                    mosJkItiranSyoukaiTy.setZtybosyuutourokuno(bosyuuTrkNo);
                                    mosJkItiranSyoukaiTy.setZtymosjkkbn(sisyaToukeiHokan.getSstmosjkkbn());
                                    mosJkItiranSyoukaiTy.setZtykousinymd(sisyaToukeiHokan.getSstkousinymd());
                                    mosJkItiranSyoukaiTy.setZtysinsayoteiymd(sisyaToukeiHokan.getSstsinsayoteiymd());
                                    mosJkItiranSyoukaiTy.setZtyhjnkykhyj(sisyaToukeiHokan.getSsthjnkykhyj());
                                    mosJkItiranSyoukaiTy.setZtykjhjnnm(sisyaToukeiHokan.getSstkjhjnnm());

                                    BizPropertyInitializer.initialize(mosJkItiranSyoukaiTy);

                                    addHenkouSqlCountMosjkIns(genInsertLst, sisyaToukeiHokanDeleteLst,
                                        sisyaToukeiHokanUpdateLst, mosJkItiranSyoukaiTy);

                                    syoriKensuMoskms++;
                                }
                            }
                        }
                    }
                    else {
                        List<HT_MosDairiten> mosDairitenLst = syoriCTL.getMosDairitens();
                        if (C_UmuKbn.ARI.eq(dairtSyutrkF) ||
                            C_UmuKbn.ARI.eq(seirtSyutrkF) ||
                            (mosDairitenLst.size() > 0 && C_UmuKbn.ARI.eq(mosjkSyutrkF))) {
                            HT_MosKihon mosKihon = syoriCTL.getMosKihon();
                            List<HT_MosSyouhn> mosSyouhnLst = syoriCTL.getMosSyouhns();
                            mosSyouhnLst = sortMosSyouhn.
                                OrderHT_MosSyouhnByBM_SyouhnZokuseiSyutkkbnSyohnsortnoAsc(mosSyouhnLst);
                            List<HT_DakuhiKettei> dakuhiKetteiLst = syoriCTL.getDakuhiKetteis();
                            HT_MostenkenRireki mostenkenRireki = sinkeiyakuDomManager.
                                getMostenkenRirekiByMosnoMaxRenno(syoriCTL.getMosno());
                            List<HT_NayoseKekka> nayoseKekkaLst = syoriCTL.getNayoseKekkas();
                            List<HT_Nyuukin> nyuukinLst = syoriCTL.getNyuukins();
                            HT_KykKak kykKak = sinkeiyakuDomManager.getKykKakByMosnoMaxRenno(syoriCTL.getMosno());
                            HT_KouzaJyouhou kouzaJyouhou = syoriCTL.getKouzaJyouhou();
                            HT_CreditCardJyouhou creditCardJyouhou = syoriCTL.getCreditCardJyouhou();
                            HT_SkUriageData skUriageData = null;
                            if (creditCardJyouhou != null) {
                                if (!BizUtil.isBlank(creditCardJyouhou.getCreditkessaiyouno())) {
                                    skUriageData = skSisyaToukeiSksDao.getSkUriageDataInfo
                                        (creditCardJyouhou.getCreditkessaiyouno());
                                }
                            }
                            HT_UketoriKouzaJyouhou uketoriKouzaJyouhou = syoriCTL.getUketoriKouzaJyouhouByUktkzsyubetukbn(C_UketorikouzasyubetuKbn.TEIKIUKETORIKIN);
                            HT_MosSyouhn mosSyouhnTBL = new HT_MosSyouhn();
                            BM_SyouhnZokusei syouhnZokuseiMST = new BM_SyouhnZokusei();
                            BizCurrency jyonHosyoSyen = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);
                            BizCurrency hosyoSyen = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);
                            BizCurrency jyonHosyoSyenEn = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);
                            BizCurrency syokaiPhrkGkyen = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);
                            BizCurrency syokaiPhrkGksiteituuka = BizCurrency.valueOf(0);
                            String spHubi = "0";
                            String sSeigenHubi = "0";
                            String tuusanGendoOver = "0";
                            String nseiymdHubi = "0";
                            String nayoSehumei = "0";
                            String honsyaKethoryuu = "0";
                            Map<C_Tuukasyu, BizCurrency> sumRsgaku = new HashMap<>();
                            BizCurrency syokaiHrkPsabiskGkyen = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);
                            C_UmuKbn zengkHenkUmuKbn = C_UmuKbn.NONE;
                            String syokaiPryuryoYmd = "00000000";
                            String syokaiPnyuksyorYmd = "00000000";
                            String kawaserateTekiyouYmd = "00000000";
                            BizNumber tekiyouKawaserate = BizNumber.valueOf(0);
                            BizCurrency kihonsGaika = BizCurrency.valueOf(0);
                            C_SyoruiCdKbn syoruiCdKbn = C_SyoruiCdKbn.BLNK;
                            String mosToutyakuYmd = "00000000";
                            String kktToutyakuYmd = "00000000";
                            String creditmiryou = "";
                            BizCurrency nnknsnpssySyup = BizCurrency.valueOf(0);
                            BizCurrency zennouHokenryou = BizCurrency.valueOf(0);

                            editPalRenkeiKoumoku.getSyuEntity(mosSyouhnLst);
                            HT_MosSyouhn mosSyouhn = editPalRenkeiKoumoku.getMosSyouhn();
                            if (mosSyouhn != null) {
                                mosSyouhnTBL = mosSyouhn;
                            }
                            BM_SyouhnZokusei syouhnZokusei = editPalRenkeiKoumoku.getSyouhnZokusei();
                            if (syouhnZokusei != null) {
                                syouhnZokuseiMST = syouhnZokusei;
                            }
                            editPalRenkeiKoumoku.editDakuhiKetteiKanrenKoumoku(dakuhiKetteiLst);
                            C_Ketkekkacd ketkekkacd = editPalRenkeiKoumoku.getSaisinKetkekkaCd();
                            C_Ketkekkacd dakuhiKetsaisnKetkekkacd = editPalRenkeiKoumoku.getDakuhiKetSaisinKetKekkaCd();
                            BizDate dakuhiKetSaisinKetteiYmd = editPalRenkeiKoumoku.getDakuhiKetSaisinKetteiYmd();
                            BizDate enknsnKijyunYmd = editPalRenkeiKoumoku.getEnknsnKijyunYmd(mosKihon.getKyktuukasyu(),
                                syoriCTL.getRyosyuymd(), mosKihon.getMosymd());
                            BizNumber enknsnKawaseRate = editPalRenkeiKoumoku.getEnknsnKawaseRate(
                                mosKihon.getKyktuukasyu(), enknsnKijyunYmd, mosKihon.getHrkkaisuu(),mosKihon.getZennoumousideumu(),mosKihon.getIkkatubaraikbn());
                            if (mosSyouhnTBL.getSeitoukihons() != null) {
                                if (C_Tuukasyu.JPY.eq(mosKihon.getKyktuukasyu())) {
                                    jyonHosyoSyen = mosSyouhnTBL.getSeitoukihons();
                                    hosyoSyen = mosSyouhnTBL.getSeitoukihons();
                                }
                                else {
                                    jyonHosyoSyen = keisanGaikakanzan.exec(C_Tuukasyu.JPY, mosSyouhnTBL.getSeitoukihons(),
                                        enknsnKawaseRate, C_HasuusyoriKbn.SUTE);
                                    hosyoSyen = keisanGaikakanzan.exec(C_Tuukasyu.JPY, mosSyouhnTBL.getSeitoukihons(),
                                        enknsnKawaseRate, C_HasuusyoriKbn.SUTE);
                                }
                                jyonHosyoSyenEn = jyonHosyoSyen;
                                jyonHosyoSyen = jyonHosyoSyen.round(-3, RoundingMode.FLOOR);
                                hosyoSyen = hosyoSyen.round(-3, RoundingMode.FLOOR);
                            }

                            CurrencyType hrkCurrencyType = henkanTuuka.henkanTuukaKbnToType(mosKihon.getHrktuukasyu());

                            BizCurrency syokaiharaikomip = BizCurrency.valueOf(0,hrkCurrencyType);

                            if (C_PtratkituukasiteiKbn.HRKTUUKA.eq(syouhnZokuseiMST.getPtratkituukasiteikbn())) {

                                if (C_IkkatubaraiKbn.TEIKIIKKATU.eq(mosKihon.getIkkatubaraikbn())) {
                                    syokaiharaikomip =mosKihon.getIkkatup();
                                }
                                else {
                                    for (HT_MosSyouhn mosSyouhns : mosSyouhnLst) {
                                        syokaiharaikomip = syokaiharaikomip.add(mosSyouhns.getHrktuukasyutkp());
                                    }
                                }
                            }
                            else {

                                if (!C_Hrkkaisuu.ITIJI.eq(mosKihon.getHrkkaisuu())) {
                                    if (!mosKihon.getKyktuukasyu().eq(mosKihon.getHrktuukasyu())) {

                                        syokaiharaikomip = mosKihon.getHrktuukaheijyunp();
                                    }
                                    else {

                                        syokaiharaikomip = mosKihon.getHeijyunp();
                                    }
                                }
                            }

                            CurrencyType kykCurrencyType = henkanTuuka.henkanTuukaKbnToType(mosKihon.getKyktuukasyu());

                            syokaiPhrkGksiteituuka = BizCurrency.valueOf(0, kykCurrencyType);

                            if (!C_Tuukasyu.JPY.eq(mosKihon.getKyktuukasyu())){
                                for (HT_MosSyouhn mosSyouhns : mosSyouhnLst) {
                                    syokaiPhrkGksiteituuka = syokaiPhrkGksiteituuka.add(mosSyouhns.getSyutkp());
                                }
                            }

                            if (C_Tuukasyu.JPY.eq(mosKihon.getHrktuukasyu())) {
                                syokaiPhrkGkyen = syokaiharaikomip;
                            }
                            else {
                                enknsnKijyunYmd = editPalRenkeiKoumoku.getEnknsnKijyunYmd(mosKihon.getKyktuukasyu(),syoriCTL.getRyosyuymd(), mosKihon.getMosymd());

                                enknsnKawaseRate = editPalRenkeiKoumoku.getEnknsnKawaseRate(
                                    mosKihon.getKyktuukasyu(),
                                    enknsnKijyunYmd,
                                    mosKihon.getHrkkaisuu(),mosKihon.getZennoumousideumu(),mosKihon.getIkkatubaraikbn());

                                syokaiPhrkGkyen = keisanGaikakanzan.exec(C_Tuukasyu.JPY, syokaiPhrkGksiteituuka,
                                    enknsnKawaseRate, C_HasuusyoriKbn.SUTE);
                            }

                            List<HT_HubiMsg> hubiMsgsLst = syoriCTL.getHubiMsgsByHubisyubetusyousaikbn(C_HubisyubetusyousaiKbn.SPHUBI);
                            if (hubiMsgsLst.size() == 0) {
                                spHubi = "0";
                            }
                            else {
                                spHubi = "1";
                            }

                            hubiMsgsLst = syoriCTL.getHubiMsgsByHubisyubetusyousaikbn(C_HubisyubetusyousaiKbn.SSEIGENHUBI);
                            if (hubiMsgsLst.size() == 0) {
                                sSeigenHubi = "0";
                            }
                            else {
                                sSeigenHubi = "1";
                            }

                            hubiMsgsLst = syoriCTL.getHubiMsgsByHubisyubetusyousaikbn(C_HubisyubetusyousaiKbn.TUUSANGENDOOVER);
                            if (hubiMsgsLst.size() == 0) {
                                tuusanGendoOver = "0";
                            }
                            else {
                                tuusanGendoOver = "1";
                            }

                            hubiMsgsLst = syoriCTL.getHubiMsgsByHubisyubetusyousaikbn(C_HubisyubetusyousaiKbn.SEIYMDHUBI);
                            if (hubiMsgsLst.size() == 0) {
                                nseiymdHubi = "0";
                            }
                            else {
                                nseiymdHubi = "1";
                            }

                            for (HT_NayoseKekka nayoseKekka : nayoseKekkaLst) {
                                if (C_NayoseJissiKekkaKbn.NAYOSEHUMEI.eq(nayoseKekka.getNysjissikekkakbn()) ||
                                    C_NayoseJyoutaiKbn.NAYOSEHUMEI.eq(nayoseKekka.getNysjyoutaikbn())) {
                                    if (C_SntkInfoTaisyousyaKbn.KEIYAKUSYA.eq(nayoseKekka.getSntkinfotaisyousyakbn()) ||
                                        C_SntkInfoTaisyousyaKbn.HIHOKENSYA.eq(nayoseKekka.getSntkinfotaisyousyakbn())) {
                                        nayoSehumei = "1";
                                        break;
                                    }
                                }
                            }

                            if (!C_KetteiKbn.KETTEI_SUMI.eq(syoriCTL.getKetteikbn())) {
                                if (C_Knkysatei1jiyhKbn.YOU.eq(syoriCTL.getKnkysatei1jiyhkbn())) {
                                    HT_KnksateiRireki knksateiRireki = sinkeiyakuDomManager
                                        .getKnksateiRirekiByMosnoMaxRenno(syoriCTL.getMosno());
                                    if (knksateiRireki != null
                                        && C_SyorikekkaKbn.HORYUU.eq(knksateiRireki.getKnksateikekkakbn())) {
                                        honsyaKethoryuu = "1";
                                    }
                                }
                                if (!"1".equals(honsyaKethoryuu)
                                    && (C_ImusateikaniyhKbn.YOU_KANI_UW.eq(syoriCTL.getImusateikaniyhkbn())
                                        || C_ImusateikaniyhKbn.YOU_KANI_MD.eq(syoriCTL.getImusateikaniyhkbn()))) {
                                    HT_ImusateiRireki imusateiRireki = sinkeiyakuDomManager
                                        .getImusateiRirekiByMosnoMaxRenno(syoriCTL.getMosno());
                                    if (imusateiRireki != null
                                        && C_SyorikekkaKbn.HORYUU.eq(imusateiRireki.getImusateikekkakbn())) {
                                        honsyaKethoryuu = "1";
                                    }
                                }
                            }

                            if (C_UmuKbn.ARI.eq(syoriCTL.getNyknnrkumu())) {
                                for (int i = 0; i < nyuukinLst.size(); i++) {
                                    if (i == 0) {
                                        if (C_ZenhnknKbn.SUMI.eq(nyuukinLst.get(i).getZenhnknkbn())) {
                                            zengkHenkUmuKbn = C_UmuKbn.ARI;
                                        }
                                        else {
                                            syokaiPryuryoYmd = nyuukinLst.get(i).getRyosyuymd().toString();
                                            syokaiPnyuksyorYmd = nyuukinLst.get(i).getNyksyoriymd().toString();
                                        }
                                    }
                                    else {
                                        if (C_UmuKbn.ARI.eq(zengkHenkUmuKbn)
                                            && !C_ZenhnknKbn.SUMI.eq(nyuukinLst.get(i).getZenhnknkbn())) {
                                            syokaiPryuryoYmd = nyuukinLst.get(i).getRyosyuymd().toString();
                                            syokaiPnyuksyorYmd = nyuukinLst.get(i).getNyksyoriymd().toString();

                                        }
                                    }
                                    if (C_SeirituKbn.HUSEIRITU.eq(syoriCTL.getSeiritukbn())
                                        && !C_ZenhnknKbn.SUMI.eq(nyuukinLst.get(i).getZenhnknkbn())) {
                                        if (sumRsgaku.containsKey(nyuukinLst.get(i).getRstuukasyu())) {
                                            sumRsgaku.put(
                                                nyuukinLst.get(i).getRstuukasyu(),
                                                sumRsgaku.get(nyuukinLst.get(i).getRstuukasyu()).add(
                                                    nyuukinLst.get(i).getRsgaku()));
                                        }
                                        else {
                                            sumRsgaku.put(nyuukinLst.get(i).getRstuukasyu(), nyuukinLst.get(i).getRsgaku());
                                        }
                                    }
                                }
                                if (!C_SeirituKbn.HUSEIRITU.eq(syoriCTL.getSeiritukbn())) {
                                    getRsgakukei.getHenkinsumiRsgaku(syoriCTL);
                                    C_Tuukasyu tuukasyu = getRsgakukei.getTuukasyu();
                                    BizCurrency rsgakukei = getRsgakukei.getRsgakukei();
                                    sumRsgaku.put(tuukasyu, rsgakukei);
                                }
                                for (C_Tuukasyu tukasyu : sumRsgaku.keySet()) {
                                    if (C_Tuukasyu.JPY.eq(tukasyu)) {
                                        syokaiHrkPsabiskGkyen = sumRsgaku.get(tukasyu);
                                    }
                                    else {

                                        enknsnKawaseRate = editPalRenkeiKoumoku.getEnknsnKawaseRate(
                                            tukasyu,
                                            syoriCTL.getRyosyuymd(),
                                            mosKihon.getHrkkaisuu(),mosKihon.getZennoumousideumu(),mosKihon.getIkkatubaraikbn());

                                        syokaiHrkPsabiskGkyen = keisanGaikakanzan.exec(C_Tuukasyu.JPY,
                                            sumRsgaku.get(tukasyu),
                                            enknsnKawaseRate, C_HasuusyoriKbn.SUTE);
                                    }
                                    break;
                                }
                            }
                            if (!C_Tuukasyu.JPY.eq(mosKihon.getKyktuukasyu())) {
                                if (C_Tkhukaumu.HUKA.eq(mosKihon.getYennykntkhkkbn())
                                        || C_Tkhukaumu.HUKA.eq(mosKihon.getGaikanykntkhkkbn())) {
                                    if (C_PtratkituukasiteiKbn.HRKTUUKA.eq(syouhnZokuseiMST.getPtratkituukasiteikbn())
                                            || syoriCTL.getRyosyuymd() != null){
                                        kawaserateTekiyouYmd = String.valueOf(syoriCTL.getNyknkwsratekijyunymd());
                                        tekiyouKawaserate = syoriCTL.getNyknkwsrate();
                                    }
                                }
                                kihonsGaika = BizCurrency.valueOf(0, kykCurrencyType);
                                for (HT_MosSyouhn mosSyouhns : mosSyouhnLst) {
                                    kihonsGaika = kihonsGaika.add(mosSyouhns.getSeitoukihons());
                                }
                            }

                            BzGetProcessSummaryInBean bzGetProcessSummaryInBean = SWAKInjector
                                .getInstance(BzGetProcessSummaryInBean.class);
                            bzGetProcessSummaryInBean.setJimuTetuzukiCd(ISkCommonKoumoku.JIMUTETUZUKICD_SKMAINDAIRITEN);
                            bzGetProcessSummaryInBean.setKouteiKanriStatuss(C_Kouteikanristatus.SYORITYUU,
                                C_Kouteikanristatus.KANRYOU);
                            bzGetProcessSummaryInBean.setSyoNo(syoriCTL.getSyono());
                            List<BzGetProcessSummaryOutBean> bzGetProcessSummaryOutBeanLst = bzGetProcessSummary
                                .exec(bzGetProcessSummaryInBean);
                            boolean seimeipkzhurikaemossyoFlg = false;
                            if (bzGetProcessSummaryOutBeanLst.size() > 0) {
                                String kouteiKanriId = bzGetProcessSummaryOutBeanLst.get(0).getKouteiKanriId();

                                BT_GyoumuKouteiInfo gyoumuKouteiInfo = bizDomManager.getGyoumuKouteiInfo(kouteiKanriId);
                                if (gyoumuKouteiInfo != null) {
                                    List<BT_HituyouSyoruiKanri> hituyouSyoruiKanriLst = gyoumuKouteiInfo
                                        .getHituyouSyoruiKanris();
                                    for (BT_HituyouSyoruiKanri temp : hituyouSyoruiKanriLst) {
                                        if (C_SyoruiCdKbn.SK_SEIMEIPKZHURIKAEMOSSYO.eq(temp.getSyoruiCd())) {
                                            seimeipkzhurikaemossyoFlg = true;
                                            break;
                                        }
                                    }
                                    gyoumuKouteiInfo.detach();
                                }

                                if (C_MosUketukeKbn.PAPERLESS.eq(syoriCTL.getMosuketukekbn())) {
                                    syoruiCdKbn = C_SyoruiCdKbn.SK_PPLESSMOSIKOUKAKSYO;
                                }
                                else {
                                    syoruiCdKbn = C_SyoruiCdKbn.SK_MOSSYO;
                                }
                                BizDate syoruiTtykymdMoskmsyo = getSyoruittykymd.getSyoruiTtykymdFirst(kouteiKanriId,
                                    syoruiCdKbn);
                                if (syoruiTtykymdMoskmsyo != null) {
                                    mosToutyakuYmd = String.valueOf(syoruiTtykymdMoskmsyo);
                                }
                                if (C_SntkhouKbn.KKT.eq(mosKihon.getSntkhoukbn())) {
                                    if (C_MosUketukeKbn.PAPERLESS.eq(syoriCTL.getMosuketukekbn())) {
                                        syoruiCdKbn = C_SyoruiCdKbn.SK_PPLESSKOKUSYO;
                                    }
                                    else {
                                        syoruiCdKbn = C_SyoruiCdKbn.SK_KOKUSYO;
                                    }
                                    BizDate syoruiTtykymdKkcsyo = getSyoruittykymd.getSyoruiTtykymdFirst(kouteiKanriId,
                                        syoruiCdKbn);
                                    if (syoruiTtykymdKkcsyo != null) {
                                        kktToutyakuYmd = String.valueOf(syoruiTtykymdKkcsyo);
                                    }
                                }
                            }

                            String yohurimiryou = "";
                            if (seimeipkzhurikaemossyoFlg) {
                                boolean miteisyutuFlg = false;
                                boolean hubiFlg = false;
                                List<HT_HubiMsg> hubiMsgLst = syoriCTL.getHubiMsgs();
                                if (hubiMsgLst != null) {
                                    for (HT_HubiMsg hubiMsg : hubiMsgLst) {
                                        if (C_SyoruiCdKbn.SK_SEIMEIPKZHURIKAEMOSSYO.eq(hubiMsg.getHituyousyoruicd())) {
                                            miteisyutuFlg = true;
                                            break;
                                        }

                                    }
                                }
                                if (!miteisyutuFlg) {
                                    List<HT_SkHubiDetail> skHubiDetailLst = sinkeiyakuDomManager
                                        .getSkHubiDetailsByMosnoSyoruicd(syoriCTL.getMosno(),
                                            C_SyoruiCdKbn.SK_SEIMEIPKZHURIKAEMOSSYO);

                                    if (skHubiDetailLst.size() > 0) {
                                        for (HT_SkHubiDetail skHubiDetail : skHubiDetailLst) {
                                            if (C_HasinkyokaKbn.KY.eq(skHubiDetail.getHasinkyokakbn())
                                                && skHubiDetail.getKaisyouymd() == null) {
                                                hubiFlg = true;
                                                break;
                                            }
                                        }
                                    }
                                }

                                if (miteisyutuFlg || hubiFlg) {
                                    yohurimiryou = "1";
                                }
                                else {
                                    yohurimiryou = "0";
                                }
                            }
                            else {
                                yohurimiryou = "0";
                            }

                            String ssTkSueokiKknkbn;
                            Integer nenkinSueokiKikan = 0;

                            int syohinHanteiKbn = SyouhinUtil.hantei(syouhnZokuseiMST.getSyouhncd());

                            if (syohinHanteiKbn == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR ||
                                syohinHanteiKbn == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR_20) {

                                if (C_Hrkkaisuu.ITIJI.eq(mosKihon.getHrkkaisuu())) {

                                    EditNenkinKoumokuUtil editNenkinKoumokuUtil = SWAKInjector.getInstance(EditNenkinKoumokuUtil.class);
                                    C_ErrorKbn errorKbn = editNenkinKoumokuUtil.editNenkinSueokikikan(mosSyouhnTBL.getHknkkn(),
                                        mosSyouhnTBL.getHknkknsmnkbn(),
                                        mosSyouhnTBL.getHrkkkn(),
                                        mosSyouhnTBL.getHrkkknsmnkbn(),
                                        mosKihon.getHhknnen());

                                    if (C_ErrorKbn.OK.eq(errorKbn)) {

                                        nenkinSueokiKikan = editNenkinKoumokuUtil.getNenkinSueokikikan();

                                    }
                                }
                            }

                            if (nenkinSueokiKikan == 10) {

                                ssTkSueokiKknkbn = "1";
                            }
                            else if (nenkinSueokiKikan == 15) {

                                ssTkSueokiKknkbn = "2";
                            }
                            else if (nenkinSueokiKikan == 20) {

                                ssTkSueokiKknkbn = "3";
                            }
                            else if (nenkinSueokiKikan == 5) {

                                ssTkSueokiKknkbn = "4";
                            }
                            else {

                                ssTkSueokiKknkbn = "";
                            }

                            if (C_Hrkkeiro.CREDIT.eq(mosKihon.getHrkkeiro())) {
                                if (C_CreditTrkjkKbn.SUMI.eq(syoriCTL.getCredittrkjkkbn()) &&
                                    C_CreditYuukoukakKbn.OK.eq(syoriCTL.getCredityuukoukakkbn())) {

                                    creditmiryou = "0";
                                }
                                else {
                                    creditmiryou = "1";
                                }
                            }
                            else {
                                creditmiryou = "0";
                            }

                            if (C_Hrkkaisuu.ITIJI.eq(mosKihon.getHrkkaisuu())) {
                                if (C_Tuukasyu.JPY.eq(mosKihon.getKyktuukasyu())) {

                                    nnknsnpssySyup = mosKihon.getSeitoufstpkei();
                                }
                                else {

                                    nnknsnpssySyup = mosKihon.getSeitoufstpkei().multiply(100);
                                }
                            }
                            else {
                                if (C_PtratkituukasiteiKbn.HRKTUUKA.eq(syouhnZokuseiMST.getPtratkituukasiteikbn())) {
                                    if (C_Tuukasyu.JPY.eq(mosKihon.getHrktuukasyu())) {

                                        nnknsnpssySyup = mosKihon.getHeijyunp();
                                    }
                                    else {

                                        nnknsnpssySyup = mosKihon.getHeijyunp().multiply(100);
                                    }
                                }
                                else {
                                    if (C_Tuukasyu.JPY.eq(mosKihon.getKyktuukasyu())) {

                                        nnknsnpssySyup = mosKihon.getHeijyunp();
                                    }
                                    else {

                                        nnknsnpssySyup = mosKihon.getHeijyunp().multiply(100);
                                    }
                                }
                            }

                            if (C_UmuKbn.NONE.eq(mosKihon.getZennoumousideumu())) {

                                zennouHokenryou = BizCurrency.valueOf(0);
                            }
                            else {
                                if (C_Tuukasyu.JPY.eq(mosKihon.getKyktuukasyu())) {

                                    zennouHokenryou = mosKihon.getZennoup();
                                }
                                else {

                                    if (C_Tuukasyu.JPY.eq(mosKihon.getHrktuukasyu())) {
                                        if (C_PtratkituukasiteiKbn.HRKTUUKA.eq(syouhnZokuseiMST.getPtratkituukasiteikbn())) {

                                            zennouHokenryou = mosKihon.getZennoup();
                                        }
                                        else {

                                            zennouHokenryou = keisanGaikakanzan.exec(C_Tuukasyu.JPY, mosKihon.getZennoup(),
                                                tekiyouKawaserate, C_HasuusyoriKbn.SUTE);
                                        }
                                    }
                                    else {

                                        zennouHokenryou = keisanGaikakanzan.exec(C_Tuukasyu.JPY, mosKihon.getZennoup(),
                                            enknsnKawaseRate, C_HasuusyoriKbn.SUTE);
                                    }
                                }
                            }

                            String eigyouhonBusisyaCd = "0000000";
                            String sosikiCd = "0000000";
                            String atukaikojinCd = "000000";
                            String tensyukuKjAtkishaNm = "";
                            int soukensuu = 0;
                            String kesyoSakiKryoDrtenCd = "";
                            String kesyoSakiKryoKjDrtenNm = "";
                            String kesyoSakiKryoKinuSakanCd = "0000";
                            String kesyoSakiKryoKinyuuSitenCd = "";
                            String kesyoSakiKryoDrtenJimSyoCd = "";
                            String atkisyaGysKkjSosikiCd = "0000000";
                            int atkisyaDrtenWari = 0;
                            long tsrybnWari = 0;
                            String cifCd = "";
                            String kydatkiDrtenCd = "";
                            String daibosyuuCd = "000000";
                            String kouinnCd = "";
                            String tansyukuKjBosyuuNm = "";
                            String egyoHobuShsyamei = "";
                            String dairtenKanriSoshikikimei = "";
                            String bosyuuTrkNo = "";
                            int renNo = 1;
                            String tratkiagCd = "";
                            String drtenIpToukeikydatki = "0";
                            boolean drtenBpsyuuninErrorFlg = true;
                            for (HT_MosDairiten mosDairiten : mosDairitenLst) {
                                if (!BizUtil.isBlank(mosDairiten.getBosyuucd()) &&
                                    !BizUtil.isBlank(mosDairiten.getTratkiagcd())){
                                    drtenBpsyuuninErrorFlg = false;
                                }
                            }

                            if (drtenBpsyuuninErrorFlg &&
                                (C_UmuKbn.ARI.eq(dairtSyutrkF) || C_UmuKbn.ARI.eq(seirtSyutrkF))) {
                                String sstBosyuuDrtenAtkikeitaiKbn = editPalRenkeiKoumoku
                                    .editBosyuuDairitenAtkiKeitaiKbn(mosDairitenLst);
                                String hhksyaNenre = editPalRenkeiKoumoku.editHhknnen(mosKihon.getHhknnen());
                                String sstKjkykNm = editPalRenkeiKoumoku.editKyknmkj(mosKihon.getKykkbn(),
                                    mosKihon.getHhknnmkj(), mosKihon.getKyknmkj(), 15);
                                String sstKjkykNm10 = editPalRenkeiKoumoku.editKyknmkj(mosKihon.getKykkbn(),
                                    mosKihon.getHhknnmkj(), mosKihon.getKyknmkj(), 10);
                                String sstKnkykNm15 = editPalRenkeiKoumoku.editKyknmkn(mosKihon.getKykkbn(),
                                    mosKihon.getHhknnmkn(), mosKihon.getKyknmkn(), 15);
                                String sstKnkykNm18 = editPalRenkeiKoumoku.editKyknmkn(mosKihon.getKykkbn(),
                                    mosKihon.getHhknnmkn(), mosKihon.getKyknmkn(), 18);
                                String sstKyksyaNen = editPalRenkeiKoumoku.editKyksyanen2Keta(mosKihon.getKykkbn(),
                                    mosKihon.getHhknnen(), mosKihon.getKyknen());
                                String sstKyksyaSeikbn = editPalRenkeiKoumoku.editKykSyaseiKbn(mosKihon.getKykkbn(),
                                    mosKihon.getHhknsei(), mosKihon.getKyksei());
                                String sstMosSyoumetuKbn = editPalRenkeiKoumoku.editMosSyoumetuKbn(
                                    syoriCTL.getSeiritukbn(), ketkekkacd);
                                String sstNyknzumiHyouji = editPalRenkeiKoumoku.editNyknzumiHyouji(
                                    syoriCTL.getMosnrkumu(), syoriCTL.getNyknnrkumu());
                                String sstNyknjkKbn = editPalRenkeiKoumoku.editNyknJkKbn(syoriCTL.getNyknnrkumu(),
                                    syoriCTL.getRyosyuymd(), mosKihon.getMosym());
                                String sstHoujyouKokutiKbn = editPalRenkeiKoumoku.editHjykktKbn(mosKihon.
                                    getSntkhoukbn());
                                String sstDakuhiKetteikekkaCd = editPalRenkeiKoumoku.
                                    editDakuhiKtkekkaCd(dakuhiKetsaisnKetkekkacd);
                                String sstToukeiyouSinsaKbn = editPalRenkeiKoumoku.editToukeiyouSinsaKbn(mosKihon.
                                    getSntkhoukbn());
                                String sstSiteidairiSktkykarihYouj = editPalRenkeiKoumoku.editTkariHyouji(mosKihon.
                                    getStdrsktkyhkkbn());

                                String sstKykkakuninSyuruiKbn = "00";
                                if (kykKak != null) {
                                    sstKykkakuninSyuruiKbn = bzKbnHenkanUtil.convKbn(
                                        kykKak.getKykkaksyrui().getValue(), C_Kykkaksyrui.class,
                                        C_SystemRenkeiHenkanHoukouKbn.RAY_TO_OTHER).getKbnData();
                                }
                                String sstKykkakuninJkkbn1 = editPalRenkeiKoumoku.editKykKakjkKbn1(
                                    syoriCTL.getKykkakjkkbn(), syoriCTL.getSeiritukbn(),
                                    mosKihon.getKakukisyouryakukbumukbn());
                                String toukeiHokensyuruiKbn = editPalRenkeiKoumoku.getToukeiHokensyuruiKbn(
                                    syouhnZokuseiMST, mosKihon);

                                String sstHknKkn = "00";
                                String sstPhrkKikn = "00";
                                String sstsaimnkkykHyj = "0";
                                if (mosSyouhnTBL.getHknkkn() != null && mosSyouhnTBL.getHrkkkn() != null) {
                                    editPalRenkeiKoumoku.editHknkkn(mosKihon, mosSyouhnTBL, syouhnZokuseiMST);
                                    sstHknKkn = editPalRenkeiKoumoku.getHknKkn();
                                    sstPhrkKikn = editPalRenkeiKoumoku.getHrkkkn();
                                    sstsaimnkkykHyj = editPalRenkeiKoumoku.getSaiMnkKykHyj();
                                }

                                String sstHrkKaisuuKbn = editPalRenkeiKoumoku.editHrkkaisuu(mosKihon);
                                String sstHrkkeiroKbn = editPalRenkeiKoumoku.editHrkKeiroKbn(mosKihon.getHrkkeiro(),
                                    mosKihon.getHrkkaisuu());
                                String sstNkshrTkykarihYouji = editPalRenkeiKoumoku.
                                    editTkariHyouji(mosKihon.getNstkhkkbn());
                                String sstKykTuuka = editPalRenkeiKoumoku.editTuukaKbn(mosKihon.getKyktuukasyu());
                                String sstHrkTuuka = editPalRenkeiKoumoku.editTuukaKbn(mosKihon.getHrktuukasyu());
                                C_Tuukasyu pYakujyouTuukasyu = null;
                                String sstTuukaTaniKbn = null;
                                if (C_PtratkituukasiteiKbn.HRKTUUKA.eq(syouhnZokuseiMST.getPtratkituukasiteikbn())) {
                                    pYakujyouTuukasyu = mosKihon.getHrktuukasyu();

                                    sstTuukaTaniKbn = bzKbnHenkanUtil.convKbn(
                                            mosKihon.getHrktuukasyu().getValue(), C_Tuukasyu.class,
                                            C_SystemRenkeiHenkanHoukouKbn.RAY_TO_OTHER).getKbnData();
                                }
                                else {
                                    pYakujyouTuukasyu = mosKihon.getKyktuukasyu();

                                    sstTuukaTaniKbn = bzKbnHenkanUtil.convKbn(
                                            mosKihon.getKyktuukasyu().getValue(), C_Tuukasyu.class,
                                            C_SystemRenkeiHenkanHoukouKbn.RAY_TO_OTHER).getKbnData();

                                }
                                String sstYennyknTkykarihYouji = editPalRenkeiKoumoku.editTkariHyouji(mosKihon.
                                    getYennykntkhkkbn());
                                String sstGaikaNyknTkykarihYouji = editPalRenkeiKoumoku.editTkariHyouji(mosKihon.
                                    getGaikanykntkhkkbn());
                                String sstYenshrTkykarihYouji = editPalRenkeiKoumoku.editTkariHyouji(mosKihon.
                                    getYenshrtkhkkbn());
                                String sstSisyaKetteiSyoriYmd = editPalRenkeiKoumoku.editSisyaketteiYmd(syoriCTL);
                                String sstSyoukenSakuseiYmd = editPalRenkeiKoumoku.editSyokenSakuseiYmd(
                                    syoriCTL.getSeiritukbn(), syoriCTL.getSrsyoriymd());
                                String sstFstpNyknHouhouKbn2 = editPalRenkeiKoumoku.editSinfstpNyknHouhouKbn(syoriCTL.
                                    getNyknnrkumu());
                                String sstMosKbn = getSstmoskbn(mosKihon);
                                String sstKurikosiRiyuukbn = getSstkurikosiriyuukbn(syoriCTL, mosKihon);
                                String sstKetteiJkkbn = getSstketteijkkbn(syoriCTL);
                                String sstDakuhiKetteiJyoutaiKbn = getSstdakuhiketteijyoutaikbn(syoriCTL);
                                String sstNyknKansKanouHyouji = getSstnyknkanskanouhyouji(syoriCTL);
                                String sstDsHukahYouji = getSstdshukahyouji(mosKihon);
                                String sstMosjkKbn = getSstmosjkkbn(syoriCTL);
                                String sstMosKetteiHoryuu = getSstmosketteihoryuu(syoriCTL, mostenkenRireki);
                                String sstKykKakuninJissityuu = getSstkykkakuninjissityuu(syoriCTL, mosKihon);
                                String sstDrtenPaperlessMoshyj = "0";
                                String sstDrtenMosTousyaUkeYmd = "00000000";
                                if (C_MosUketukeKbn.PAPERLESS.equals(syoriCTL.getMosuketukekbn())) {
                                    sstDrtenPaperlessMoshyj = "1";
                                    sstDrtenMosTousyaUkeYmd = String.valueOf(syoriCTL.getMosnrkymd());
                                }
                                String sstSykSbYenSitiHsyuTkykHyj = editPalRenkeiKoumoku.editTkariHyouji(mosKihon.getSyksbyensitihsyutkhkkbn());
                                String sstJyudKaigoMehrTkariHyj = editPalRenkeiKoumoku.editTkariHyouji(mosKihon.getJyudkaigomehrtkhkkbn());

                                String sstBosyuuDrtenkobetuInfo1 = "";

                                if (!C_KoureisyaTaiouKbn.BLNK.eq(mosKihon.getKoureitaioukbn())) {
                                    sstBosyuuDrtenkobetuInfo1 = mosKihon.getKoureitaioukbn().getValue();
                                }
                                String nenkinsyu = editPalRenkeiKoumoku.editNenkinsyu(mosSyouhnTBL.getSknenkinsyu());

                                String kzktrkservicekbn = editPalRenkeiKoumoku.getKzktrkServiceKbn(syoriCTL);

                                String sstKykdrtkykarihyj = editPalRenkeiKoumoku.editTkariHyouji(mosKihon.getKykdrtkykhukakbn());

                                String sstteikishrtkykarihyouji = editPalRenkeiKoumoku.editTkariHyouji(mosKihon.getTeikisiharaitkykhkkbn());

                                BizNumber nknsnpssyKwsrate = editPalRenkeiKoumoku.getNknsnPssyKwsRate(mosKihon.getKyktuukasyu(),
                                    mosKihon.getHrktuukasyu(),
                                    enknsnKijyunYmd,
                                    mosKihon.getHrkkaisuu(),
                                    mosKihon.getZennoumousideumu(),
                                    mosKihon.getIkkatubaraikbn());

                                String kzkTuutiTyokusouKbn = editPalRenkeiKoumoku.getKzkTuutiTyokusouKbn(syoriCTL);

                                if (sisyaToukeiHokanLst.size() > 0) {
                                    sisyaToukeiHokan = sisyaToukeiHokanLst.get(idxSstLst.get(0));

                                    if (sisyaToukeiHokanLst.size() == 2) {
                                        addHenkouSqlCountSstDel(genInsertLst, sisyaToukeiHokanDeleteLst,
                                            sisyaToukeiHokanUpdateLst, sisyaToukeiHokanLst.get(idxSstLst.get(1)));
                                    }
                                }
                                else {
                                    sisyaToukeiHokan = new HT_SisyaToukeiHokan();
                                }

                                sisyaToukeiHokan.setSyrctrltblkostime(syoriCTL.getGyoumuKousinTime());
                                sisyaToukeiHokan.setSstsyono(syoriCTL.getSyono().substring(0, 11));
                                sisyaToukeiHokan.setSstmosym(String.valueOf(mosKihon.getMosym()));
                                sisyaToukeiHokan.setSstmoskbn(sstMosKbn);
                                sisyaToukeiHokan.setSstbosyuudrtenatkikeitaikbn(sstBosyuuDrtenAtkikeitaiKbn);
                                if (mosDairitenLst.size() <= 1) {
                                    sisyaToukeiHokan.setSstkydatkikbn("0");
                                }
                                else {
                                    sisyaToukeiHokan.setSstkydatkikbn("1");
                                }
                                sisyaToukeiHokan.setSstatukaisyadrtenhyouji("1");
                                sisyaToukeiHokan.setTratkiagcd(tratkiagCd);
                                sisyaToukeiHokan.setSsteigyouhonbusisyacd(Strings.padStart(eigyouhonBusisyaCd, 7, '0'));
                                sisyaToukeiHokan.setSstsosikicd(Strings.padStart(sosikiCd, 7, '0'));
                                sisyaToukeiHokan.setSstatkisyagyskkjsosikicd(atkisyaGysKkjSosikiCd);
                                sisyaToukeiHokan.setSstcifcd(cifCd);
                                sisyaToukeiHokan.setSstatkisyadrtenatkiwari(atkisyaDrtenWari);
                                sisyaToukeiHokan.setSsttsrybnwari(tsrybnWari);
                                sisyaToukeiHokan.setSstsinhsys(0l);
                                sisyaToukeiHokan.setSstsoukensuu(soukensuu);
                                sisyaToukeiHokan.setSstkydatkidairitencd(kydatkiDrtenCd);
                                sisyaToukeiHokan.setSstbosyuudrtenkobetuinfo1(sstBosyuuDrtenkobetuInfo1);
                                sisyaToukeiHokan.setSstbosyuudrtenkobetuinfo2("");
                                sisyaToukeiHokan.setSstbosyuudrtenkobetuinfo3("");
                                sisyaToukeiHokan.setSstbosyuudrtenkobetuinfo4(kouinnCd);
                                sisyaToukeiHokan.setSstbosyuudrtenkobetuinfo5("");
                                sisyaToukeiHokan.setSstbankkouincd("");
                                sisyaToukeiHokan.setSstdaihyoubosyuunincd(Strings.padStart(daibosyuuCd, 6, '0'));
                                sisyaToukeiHokan.setSstatukaikojincd(atukaikojinCd);
                                sisyaToukeiHokan.setSstkanjihihokensyanm(mosKihon.getHhknnmkj());
                                if (mosKihon.getHhknnmkj().length() > 7) {
                                    sisyaToukeiHokan.setSsttansyukukjhhknnm(mosKihon.getHhknnmkj().substring(0, 7));
                                }
                                else {
                                    sisyaToukeiHokan.setSsttansyukukjhhknnm(mosKihon.getHhknnmkj());
                                }
                                sisyaToukeiHokan.setSsthhknsyokugyoucd(Strings.padStart(mosKihon.getHhknsykgycd(), 3,
                                    '0'));
                                sisyaToukeiHokan.setSsthhknnen2keta(hhksyaNenre);
                                sisyaToukeiHokan.setSsthhknseikbn(mosKihon.getHhknsei().getValue());
                                if (mosKihon.getHhknseiymd() == null) {
                                    sisyaToukeiHokan.setSsthhknseiymd("00000000");
                                }
                                else {
                                    sisyaToukeiHokan.setSsthhknseiymd(mosKihon.getHhknseiymd().toString());
                                }
                                sisyaToukeiHokan.setSstkjkyknm(sstKjkykNm);
                                sisyaToukeiHokan.setSstkjkyknm10(sstKjkykNm10);
                                sisyaToukeiHokan.setSstknkyknm15(sstKnkykNm15);
                                sisyaToukeiHokan.setSstknkyknm18(sstKnkykNm18);
                                sisyaToukeiHokan.setSstkyksyanen(sstKyksyaNen);
                                sisyaToukeiHokan.setSstkyksyaseikbn(sstKyksyaSeikbn);
                                sisyaToukeiHokan.setSsthjnkykhyj("0");
                                sisyaToukeiHokan.setSstkjhjnnm("");
                                sisyaToukeiHokan.setSstseirituyoukihontikucd(mosKihon.getTsinyno());
                                sisyaToukeiHokan.setSstmossyoumetukbn(sstMosSyoumetuKbn);
                                sisyaToukeiHokan.setSstkurikosiriyuukbn(sstKurikosiRiyuukbn);
                                sisyaToukeiHokan.setSstnyknzumihyouji(sstNyknzumiHyouji);
                                sisyaToukeiHokan.setSstnyknjkkbn(sstNyknjkKbn);
                                sisyaToukeiHokan.setSsthoujyoukokutikbn(sstHoujyouKokutiKbn);
                                if (C_Hrkkaisuu.ITIJI.eq(mosKihon.getHrkkaisuu())) {
                                    sisyaToukeiHokan.setSstkykkeitaikbn("04");
                                }
                                else {
                                    sisyaToukeiHokan.setSstkykkeitaikbn("00");
                                }
                                sisyaToukeiHokan.setSstketteijkkbn(sstKetteiJkkbn);
                                sisyaToukeiHokan.setSstdakuhiketteijyoutaikbn(sstDakuhiKetteiJyoutaiKbn);
                                sisyaToukeiHokan.setSstdakuhiketteikekkacd(sstDakuhiKetteikekkaCd);
                                if (dakuhiKetSaisinKetteiYmd != null) {
                                    sisyaToukeiHokan.setSstdakuhiketteiymd(String.valueOf(dakuhiKetSaisinKetteiYmd));
                                }
                                else {
                                    sisyaToukeiHokan.setSstdakuhiketteiymd("00000000");
                                }
                                sisyaToukeiHokan.setSsttokusyujimutoriatukaikbn("1");
                                sisyaToukeiHokan.setSsttoukeiyousinsakbn(sstToukeiyouSinsaKbn);
                                sisyaToukeiHokan.setSsthonninkakuninkbn("00");
                                sisyaToukeiHokan.setSstdrtentsryhushrkykhyouji(mosKihon.getTsryhshrkykumukbn().
                                    getValue());
                                sisyaToukeiHokan.setSstnyknkanskanouhyouji(sstNyknKansKanouHyouji);
                                sisyaToukeiHokan.setSstdshukahyouji(sstDsHukahYouji);
                                sisyaToukeiHokan.setSstsiteidairisktkykarihyouj(sstSiteidairiSktkykarihYouj);
                                sisyaToukeiHokan.setSsttokuteikanikokutikbn("0");
                                sisyaToukeiHokan.setSstkykkakuninsyuruikbn(sstKykkakuninSyuruiKbn);
                                sisyaToukeiHokan.setSstkykkakuninjkkbn1(sstKykkakuninJkkbn1);
                                sisyaToukeiHokan.setSstmosketteikekkakbn("");
                                sisyaToukeiHokan.setSstsinsazumihyouji("0");
                                sisyaToukeiHokan.setSstannaisakicd("00000000");
                                sisyaToukeiHokan.setSstmosjkkbn(sstMosjkKbn);
                                sisyaToukeiHokan.setSstkihonhubi(syoriCTL.getKhnhbkbn().getValue());
                                sisyaToukeiHokan.setSstsphubi(spHubi);
                                sisyaToukeiHokan.setSstsseigenhubi(sSeigenHubi);
                                sisyaToukeiHokan.setSstnayosehumei(nayoSehumei);
                                sisyaToukeiHokan.setSsttuusangendoover(tuusanGendoOver);
                                sisyaToukeiHokan.setSstmosketteihoryuu(sstMosKetteiHoryuu);
                                sisyaToukeiHokan.setSstkykkakuninjissityuu(sstKykKakuninJissityuu);
                                sisyaToukeiHokan.setSstkokutiketteihoryuu(syoriCTL.getKktnrkhbumu().getValue());
                                sisyaToukeiHokan.setSsthonsyaketteihoryuu(honsyaKethoryuu);
                                sisyaToukeiHokan.setSstseiymdhubi(nseiymdHubi);
                                if (C_NyuukinjyoutaiKbn.SEIRITUHORYUU_HUSOKUKIN.eq(syoriCTL.getNyuukinjoutaikbn())) {
                                    sisyaToukeiHokan.setSstphusoku("1");
                                }
                                else {
                                    sisyaToukeiHokan.setSstphusoku("0");
                                }
                                sisyaToukeiHokan.setSstyohurimiryou(yohurimiryou);
                                if (C_JimusrhKbn.HORYU.eq(syoriCTL.getJimusrhkbn())) {
                                    sisyaToukeiHokan.setSstseirituhoryuuuketuketyuu("1");
                                }
                                else {
                                    sisyaToukeiHokan.setSstseirituhoryuuuketuketyuu("0");
                                }
                                if (C_NyuukinjyoutaiKbn.SEIRITUHORYUU_KAKIN.eq(syoriCTL.getNyuukinjoutaikbn())) {
                                    sisyaToukeiHokan.setSstpkakin("1");
                                }
                                else {
                                    sisyaToukeiHokan.setSstpkakin("0");
                                }
                                sisyaToukeiHokan.setSstketteihoryuuhubihyouji(syoriCTL.getKthhbkbn().getValue());
                                sisyaToukeiHokan.setSstseirituhoryuuhubihyouji(syoriCTL.getSrhhbkbn().getValue());
                                sisyaToukeiHokan.setSsttoukeiyouhknsyuruikbn(toukeiHokensyuruiKbn);
                                sisyaToukeiHokan.setSsthknsyuruinm(mosKihon.getAisyoumeikbn().getContent(
                                    C_AisyoumeiKbn.PATTERN_SKSISYATOUKEI));
                                sisyaToukeiHokan.setSsthknkkn(sstHknKkn);
                                sisyaToukeiHokan.setSstphrkkikn(sstPhrkKikn);
                                sisyaToukeiHokan.setSsthrkkaisuukbn(sstHrkKaisuuKbn);
                                sisyaToukeiHokan.setSsthrkkeirokbn(sstHrkkeiroKbn);
                                sisyaToukeiHokan.setSstnkshrtkykarihyouji(sstNkshrTkykarihYouji);
                                sisyaToukeiHokan.setSstnkshrtkyknkkkn(Strings.padStart(
                                    String.valueOf(mosKihon.getNstksbnkkn()), 2, '0'));
                                if (jyonHosyoSyen.toString().length() > 11) {
                                    sisyaToukeiHokan.setSstjyunhsys(99999999999l);
                                }
                                else {
                                    sisyaToukeiHokan.setSstjyunhsys(
                                        new BigDecimal(jyonHosyoSyen.toString()).longValue());
                                }
                                if (hosyoSyen.toString().length() > 11) {
                                    sisyaToukeiHokan.setSsthsys(99999999999l);
                                }
                                else {
                                    sisyaToukeiHokan.setSsthsys(new BigDecimal(hosyoSyen.toString()).
                                        longValue());
                                }
                                sisyaToukeiHokan.setSstkyktuuka(sstKykTuuka);
                                sisyaToukeiHokan.setSsthrktuuka(sstHrkTuuka);
                                sisyaToukeiHokan.setSsttuukatanikbn(sstTuukaTaniKbn);
                                if (syokaiPhrkGkyen.toString().length() > 11) {
                                    sisyaToukeiHokan.setSstfstphrkgkyen(99999999999l);
                                }
                                else {
                                    sisyaToukeiHokan.setSstfstphrkgkyen(
                                        new BigDecimal(syokaiPhrkGkyen.toString()).longValue());
                                }

                                BizCurrency sstFstPHrkgkhrkTuuka;
                                if (C_Tuukasyu.JPY.eq(pYakujyouTuukasyu)) {
                                    sstFstPHrkgkhrkTuuka = mosKihon.getFstphrkgk();
                                }
                                else {
                                    sstFstPHrkgkhrkTuuka = mosKihon.getFstphrkgk().multiply(100);
                                }
                                if (sstFstPHrkgkhrkTuuka.toString().length() > 11) {
                                    sisyaToukeiHokan.setSstfstphrkgkhrktuukamoji("99999999999");
                                }
                                else {
                                    sisyaToukeiHokan.setSstfstphrkgkhrktuukamoji(Strings.padStart(
                                        sstFstPHrkgkhrkTuuka.toString(), 11, '0'));
                                }

                                if (!C_Tuukasyu.JPY.eq(mosKihon.getKyktuukasyu())) {
                                    if (BizNumber.valueOf(new BigDecimal(syokaiharaikomip.toString())).compareTo(BizNumber.valueOf(99999999999.99)) > 0) {
                                        sisyaToukeiHokan.setSstfstphrkgkgaika(BizNumber.valueOf(99999999999.99));
                                    }
                                    else {
                                        sisyaToukeiHokan.setSstfstphrkgkgaika(BizNumber.valueOf(new BigDecimal(syokaiharaikomip.toString())));
                                    }
                                }
                                else {
                                    sisyaToukeiHokan.setSstfstphrkgkgaika(BizNumber.valueOf(0));
                                }
                                if (syokaiHrkPsabiskGkyen.toString().length() > 11) {
                                    sisyaToukeiHokan.setSstfstpsshkhrkgkyen(99999999999l);
                                }
                                else {
                                    sisyaToukeiHokan.setSstfstpsshkhrkgkyen(new BigDecimal(syokaiHrkPsabiskGkyen.
                                        toString()).longValue());
                                }
                                sisyaToukeiHokan.setSstyennykntkykarihyouji(sstYennyknTkykarihYouji);
                                sisyaToukeiHokan.setSstgaikanykntkykarihyouji(sstGaikaNyknTkykarihYouji);
                                sisyaToukeiHokan.setSsyenshrtkykarihyouji(sstYenshrTkykarihYouji);
                                if (BizNumber.valueOf(new BigDecimal(kihonsGaika.toString())).compareTo(BizNumber.valueOf(99999999999.99)) > 0){
                                    sisyaToukeiHokan.setSstkihonsgaika(BizNumber.valueOf(99999999999.99));
                                }
                                else {
                                    sisyaToukeiHokan.setSstkihonsgaika(BizNumber.valueOf(
                                        new BigDecimal(kihonsGaika.toString())));
                                }
                                sisyaToukeiHokan.setSsttekiyoukawaserate(BizNumber.valueOf(new BigDecimal(tekiyouKawaserate.toString())));
                                sisyaToukeiHokan.setSstkawaseratetekiyouymd(kawaserateTekiyouYmd.toString());
                                sisyaToukeiHokan.setSstsakuseiymd(syoriYmd.toString());
                                sisyaToukeiHokan.setSstmosymd(mosKihon.getMosymd().toString());

                                if (C_SntkhouKbn.NONE.eq(mosKihon.getSntkhoukbn())) {

                                    sisyaToukeiHokan.setSstkokutiymd(mosKihon.getMosymd().toString());
                                }
                                else {
                                    if (syoriCTL.getKktymd() != null) {
                                        sisyaToukeiHokan.setSstkokutiymd(syoriCTL.getKktymd().toString());
                                    }
                                    else {
                                        sisyaToukeiHokan.setSstkokutiymd("00000000");
                                    }
                                }

                                if (syoriCTL.getMosnrkymd() != null) {
                                    sisyaToukeiHokan.setSstmosnyuuryokuymd(syoriCTL.getMosnrkymd().toString());
                                }
                                else {
                                    sisyaToukeiHokan.setSstmosnyuuryokuymd("00000000");
                                }
                                if (kouzaJyouhou != null && kouzaJyouhou.getKouzajyouhounyuuryokuymd() != null) {
                                    sisyaToukeiHokan.setSstkouzanyuuryokuymd(kouzaJyouhou.getKouzajyouhounyuuryokuymd().toString());
                                }
                                else {
                                    sisyaToukeiHokan.setSstkouzanyuuryokuymd("00000000");
                                }
                                sisyaToukeiHokan.setSstkykymd(mosKihon.getKykymd().toString());
                                if (mosKihon.getSknnkaisiymd() != null) {
                                    sisyaToukeiHokan.setSstsekininkaisiymd(mosKihon.getSknnkaisiymd().toString());
                                }
                                else {
                                    sisyaToukeiHokan.setSstsekininkaisiymd("00000000");
                                }
                                sisyaToukeiHokan.setSstsisyaketteisyoriymd(sstSisyaKetteiSyoriYmd);
                                sisyaToukeiHokan.setSstsyoukensakuseiymd(sstSyoukenSakuseiYmd);
                                sisyaToukeiHokan.setSstseisekikijyym(mosKihon.getSeisekiym().toString());

                                if (C_SeirituKbn.SEIRITU.eq(syoriCTL.getSeiritukbn()) ||
                                    C_SeirituKbn.HUSEIRITU.eq(syoriCTL.getSeiritukbn())) {
                                    sisyaToukeiHokan.setSstmossyoumetukakuteiymd(syoriCTL.getSrsyoriymd().toString());
                                }
                                else {
                                    sisyaToukeiHokan.setSstmossyoumetukakuteiymd("00000000");
                                }
                                sisyaToukeiHokan.setSstdrtenkeijyouym("000000");
                                sisyaToukeiHokan.setSstmostoutyakuymd(mosToutyakuYmd.toString());
                                sisyaToukeiHokan.setSstkkttoutyakuymd(kktToutyakuYmd.toString());
                                if (mosKihon.getMossakuseiymd() != null) {
                                    sisyaToukeiHokan.setSstmossakuseiymd(mosKihon.getMossakuseiymd().toString());
                                }
                                else {
                                    sisyaToukeiHokan.setSstmossakuseiymd("00000000");
                                }
                                sisyaToukeiHokan.setSstmosksnym(mosKihon.getMosym().toString());
                                sisyaToukeiHokan.setSstkariseirituymd("");
                                sisyaToukeiHokan.setSstsinsayoteiymd("");
                                sisyaToukeiHokan.setSstkousinymd(syoriYmd.toString());
                                sisyaToukeiHokan.setSstryousyuuymd(syokaiPryuryoYmd);
                                sisyaToukeiHokan.setSstfstpryousyuuymd(syokaiPryuryoYmd);
                                sisyaToukeiHokan.setSstfstpnyknsyoriymd(syokaiPnyuksyorYmd);
                                sisyaToukeiHokan.setSstfstpnyknnaiyoukbn("1");
                                sisyaToukeiHokan.setSstfstpnyknhouhoukbn2(sstFstpNyknHouhouKbn2);
                                sisyaToukeiHokan.setSstdrtenpaperlessmoshyj(sstDrtenPaperlessMoshyj);
                                sisyaToukeiHokan.setSstdrtenmostousyaukeymd(sstDrtenMosTousyaUkeYmd);
                                if (!C_Tkhukaumu.HUKA.eq(mosKihon.getTargettkhkkbn())
                                    || C_TargetTkMokuhyoutiKbn.BLNK.eq(mosKihon.getTargettkmkhtkbn())) {
                                    sisyaToukeiHokan.setSstmkhyoutiyensysnikoukbn("000");
                                }
                                else {
                                    sisyaToukeiHokan.setSstmkhyoutiyensysnikoukbn(mosKihon.getTargettkmkhtkbn().getValue());
                                }
                                sisyaToukeiHokan.setSstsyksbyensitihsyutkykhyj(sstSykSbYenSitiHsyuTkykHyj);
                                sisyaToukeiHokan.setSstjyudkaigomehrtkarihyj(sstJyudKaigoMehrTkariHyj);

                                if (BizNumber.valueOf(new BigDecimal(syokaiPhrkGksiteituuka.toString())).compareTo(BizNumber.valueOf(99999999999.99)) > 0){
                                    sisyaToukeiHokan.setSstfstphrkgksiteituuka(BizNumber.valueOf(99999999999.99));
                                }
                                else {
                                    sisyaToukeiHokan.setSstfstphrkgksiteituuka(BizNumber.valueOf(
                                        new BigDecimal(syokaiPhrkGksiteituuka.toString())));
                                }

                                if (C_TumitatekinHaibunWariKbn.BLNK.eq(mosKihon.getTeirituhaibunwarikbn())) {

                                    sisyaToukeiHokan.setSstteirituhaibunwari("000");
                                }
                                else {
                                    sisyaToukeiHokan.setSstteirituhaibunwari(mosKihon.getTeirituhaibunwarikbn().getValue());
                                }

                                sisyaToukeiHokan.setSstsueokikknkbn(ssTkSueokiKknkbn);

                                sisyaToukeiHokan.setSstnksyuruikbn1(nenkinsyu);
                                if (!BizUtil.isBlank(mosKihon.getAitemosno())) {
                                    sisyaToukeiHokan.setSstsetaitemosno(mosKihon.getAitemosno().substring(0, 9));
                                }
                                else {
                                    sisyaToukeiHokan.setSstsetaitemosno("000000000");
                                }

                                sisyaToukeiHokan.setSstyakkanjyuryouhoukbn(mosKihon.getYakkanjyuryouhoukbn().getValue());
                                sisyaToukeiHokan.setSstyakkanbunsyono(mosKihon.getYakkanbunsyono());
                                if (kouzaJyouhou != null){
                                    sisyaToukeiHokan.setSstkzhuritourokuhoukbn(kouzaJyouhou.getKzhuritourokuhoukbn().getValue());
                                }
                                else {
                                    sisyaToukeiHokan.setSstkzhuritourokuhoukbn("0");
                                }
                                sisyaToukeiHokan.setSstdai1hknkkn(Strings.padStart(
                                    String.valueOf(mosSyouhnTBL.getDai1hknkkn()), 2, '0'));
                                if (C_Hrkkeiro.CREDIT.eq(mosKihon.getHrkkeiro())) {
                                    sisyaToukeiHokan.setSstcreditnyuuryokuymd(syoriCTL.getMosnrkymd().toString());
                                }
                                else {
                                    sisyaToukeiHokan.setSstcreditnyuuryokuymd("00000000");
                                }
                                sisyaToukeiHokan.setSstcreditmiryou(creditmiryou);
                                if (C_Hrkkeiro.CREDIT.eq(mosKihon.getHrkkeiro())) {
                                    sisyaToukeiHokan.setSstcredittrkhoukbn(creditCardJyouhou.getCredittrkhoukbn().getValue());
                                }
                                else {
                                    sisyaToukeiHokan.setSstcredittrkhoukbn("0");
                                }
                                if (C_Hrkkeiro.CREDIT.eq(mosKihon.getHrkkeiro())) {
                                    sisyaToukeiHokan.setSstcardbrandkbn(creditCardJyouhou.getCardbrandkbn().getContent());
                                }
                                else {
                                    sisyaToukeiHokan.setSstcardbrandkbn("");
                                }
                                if (skUriageData != null) {
                                    sisyaToukeiHokan.setSstcarddatasousinymd(skUriageData.getCarddatasousinymd().toString());
                                }
                                else {
                                    sisyaToukeiHokan.setSstcarddatasousinymd("00000000");
                                }
                                sisyaToukeiHokan.setSstkzktrkservicekbn(kzktrkservicekbn);
                                sisyaToukeiHokan.setSstkykdrtkykarihyj(sstKykdrtkykarihyj);
                                sisyaToukeiHokan.setSstteikishrtkykarihyouji(sstteikishrtkykarihyouji);
                                if (C_Tkhukaumu.HUKA.eq(mosKihon.getTeikisiharaitkykhkkbn()) &&
                                    uketoriKouzaJyouhou != null &&
                                    !C_KouzasyuruiKbn.BLNK.eq(uketoriKouzaJyouhou.getKzsyuruikbn())) {
                                    sisyaToukeiHokan.setSstteikishrkinshrtuukakbn(uketoriKouzaJyouhou.getKzsyuruikbn().getValue());
                                }
                                else {
                                    sisyaToukeiHokan.setSstteikishrkinshrtuukakbn("");
                                }
                                if (C_Tkhukaumu.HUKA.eq(mosKihon.getTeikisiharaitkykhkkbn())) {
                                    if (BizNumber.valueOf(new BigDecimal(mosSyouhnTBL.getTeikisiharaikin().toString())).compareTo(BizNumber.valueOf(99999999999.99)) > 0) {
                                        sisyaToukeiHokan.setSstteikisiharaikin(BizNumber.valueOf(99999999999.99));
                                    } else {
                                        sisyaToukeiHokan.setSstteikisiharaikin(BizNumber.valueOf(
                                            new BigDecimal(mosSyouhnTBL.getTeikisiharaikin().toString())));
                                    }
                                }
                                else {
                                    sisyaToukeiHokan.setSstteikisiharaikin(BizNumber.valueOf(0));
                                }
                                if (C_KoureiKzkSetumeiHouKbn.JOUKIHUKA.eq(mosKihon.getKoureikzksetumeihoukbn())) {
                                    sisyaToukeiHokan.setSstkoureikzksetumeihoukbn("4");
                                }
                                else {
                                    sisyaToukeiHokan.setSstkoureikzksetumeihoukbn(mosKihon.getKoureikzksetumeihoukbn().getValue());
                                }
                                sisyaToukeiHokan.setSstkoureimndnhukusuukaikbn(mosKihon.getKoureimndnhukusuukaikbn().getValue());
                                sisyaToukeiHokan.setSstkoureitratkisyaigidskkbn(mosKihon.getKoureitratkisyaigidskkbn().getValue());
                                sisyaToukeiHokan.setSsthknsyukigou(mosSyouhnTBL.getSyouhncd().substring(0, 2));
                                sisyaToukeiHokan.setSstsaimnkkykhyj(sstsaimnkkykHyj);

                                if (nnknsnpssySyup.toString().length() > 11) {
                                    sisyaToukeiHokan.setSstnnknsnpssysyup(99999999999l);
                                }
                                else {
                                    sisyaToukeiHokan.setSstnnknsnpssysyup(
                                        new BigDecimal(nnknsnpssySyup.toString()).longValue());
                                }

                                sisyaToukeiHokan.setSstnnknsnpssykwsrate(nknsnpssyKwsrate);

                                if (zennouHokenryou.toString().length() > 11) {
                                    sisyaToukeiHokan.setSstzennoup(99999999999l);
                                }
                                else {
                                    sisyaToukeiHokan.setSstzennoup(
                                        new BigDecimal(zennouHokenryou.toString()).longValue());
                                }

                                sisyaToukeiHokan.setSstkzktuutityokusoukbn(kzkTuutiTyokusouKbn);

                                if (C_Tkhukaumu.HUKA.eq(mosKihon.getKjnnkpzeitekitkhukakbn())) {

                                    sisyaToukeiHokan.setSstnenkinzeiseitokuyakukbn("2");
                                }
                                else {

                                    sisyaToukeiHokan.setSstnenkinzeiseitokuyakukbn("0");
                                }

                                if (BizUtil.isBlank(sisyaToukeiHokan.getSstmosno())) {
                                    sisyaToukeiHokan.setSstmosno(syoriCTL.getMosno().substring(0, 9));
                                    sisyaToukeiHokan.setRenno(renNo);
                                    BizPropertyInitializer.initialize(sisyaToukeiHokan);
                                    addHenkouSqlCountSstIns(genInsertLst, sisyaToukeiHokanDeleteLst,
                                        sisyaToukeiHokanUpdateLst, sisyaToukeiHokan);
                                }
                                else {
                                    addHenkouSqlCountSstUpd(genInsertLst, sisyaToukeiHokanDeleteLst,
                                        sisyaToukeiHokanUpdateLst, sisyaToukeiHokan);
                                }

                                syoriKensuHokan = syoriKensuHokan + 1;

                                if (C_UmuKbn.ARI.eq(dairtSyutrkF)) {
                                    if (mosDairitenLst.size() >= 2){
                                        drtenIpToukeikydatki = "1";
                                    }
                                    else {
                                        drtenIpToukeikydatki = "0";
                                    }
                                    ZT_DrtenIpToukeiTy drtenIpToukeiTy = new ZT_DrtenIpToukeiTy();

                                    drtenIpToukeiTy.setZtyeigyouhonbusisyacd(sisyaToukeiHokan.getSsteigyouhonbusisyacd());
                                    drtenIpToukeiTy.setZtysosikicd(sisyaToukeiHokan.getSstsosikicd());
                                    drtenIpToukeiTy.setZtyatukaikojincd(sisyaToukeiHokan.getSstatukaikojincd());
                                    drtenIpToukeiTy.setZtymosym(String.valueOf(moskmNrYM));
                                    drtenIpToukeiTy.setZtymoskbn(sisyaToukeiHokan.getSstmoskbn());
                                    drtenIpToukeiTy.setZtytansyukukjatukaisyanm(tensyukuKjAtkishaNm);
                                    drtenIpToukeiTy.setZtymosno(sisyaToukeiHokan.getSstmosno());
                                    drtenIpToukeiTy.setZtymossyoumetukbn(sisyaToukeiHokan.getSstmossyoumetukbn());
                                    drtenIpToukeiTy.setZtykurikosiriyuukbn(sisyaToukeiHokan.getSstkurikosiriyuukbn());
                                    drtenIpToukeiTy.setZtynyknzumihyouji(sisyaToukeiHokan.getSstnyknzumihyouji());
                                    drtenIpToukeiTy.setZtytoukeihknsyruikbn(sisyaToukeiHokan.getSsttoukeiyouhknsyuruikbn());
                                    drtenIpToukeiTy.setZtyhjykktkbn(sisyaToukeiHokan.getSsthoujyoukokutikbn());
                                    drtenIpToukeiTy.setZtykykktaikbn(sisyaToukeiHokan.getSstkykkeitaikbn());
                                    drtenIpToukeiTy.setZtyjyunhsys(sisyaToukeiHokan.getSstjyunhsys() / 1000);
                                    drtenIpToukeiTy.setZtyhsys(sisyaToukeiHokan.getSsthsys() / 1000);
                                    drtenIpToukeiTy.setZtysoukensuu(sisyaToukeiHokan.getSstsoukensuu());
                                    drtenIpToukeiTy.setZtyketjkkbn(sisyaToukeiHokan.getSstketteijkkbn());
                                    drtenIpToukeiTy.setZtydakuhiktjyoutaikbn(sisyaToukeiHokan.
                                        getSstdakuhiketteijyoutaikbn());
                                    drtenIpToukeiTy.setZtykihonhubi(sisyaToukeiHokan.getSstkihonhubi());
                                    drtenIpToukeiTy.setZtysphubi(sisyaToukeiHokan.getSstsphubi());
                                    drtenIpToukeiTy.setZtysseigenhubi(sisyaToukeiHokan.getSstsseigenhubi());
                                    drtenIpToukeiTy.setZtynayosehumei(sisyaToukeiHokan.getSstnayosehumei());
                                    drtenIpToukeiTy.setZtytuusangendoover(sisyaToukeiHokan.getSsttuusangendoover());
                                    drtenIpToukeiTy.setZtymosketteihoryuu(sisyaToukeiHokan.getSstmosketteihoryuu());
                                    drtenIpToukeiTy.setZtykykkakjissityuu(sisyaToukeiHokan.getSstkykkakuninjissityuu());
                                    drtenIpToukeiTy.setZtykktketteihoryuu(sisyaToukeiHokan.getSstkokutiketteihoryuu());
                                    drtenIpToukeiTy.setZtyhonsyakethoryuu(sisyaToukeiHokan.getSsthonsyaketteihoryuu());
                                    drtenIpToukeiTy.setZtyseiymdhubi(sisyaToukeiHokan.getSstseiymdhubi());
                                    drtenIpToukeiTy.setZtyphusoku(sisyaToukeiHokan.getSstphusoku());
                                    drtenIpToukeiTy.setZtysrhuketyu(sisyaToukeiHokan.getSstseirituhoryuuuketuketyuu());
                                    drtenIpToukeiTy.setZtypkakin(sisyaToukeiHokan.getSstpkakin());
                                    drtenIpToukeiTy.setZtybsudirtnatkikeitaikbn(sisyaToukeiHokan.
                                        getSstbosyuudrtenatkikeitaikbn());
                                    drtenIpToukeiTy.setZtysakuseiymd(syoriYmd.toString());
                                    drtenIpToukeiTy.setZtykydatkikbn(drtenIpToukeikydatki);
                                    drtenIpToukeiTy.setZtytansyukukjhhknnm(sisyaToukeiHokan.getSsttansyukukjhhknnm());
                                    drtenIpToukeiTy.setZtyhhknsykgycd(sisyaToukeiHokan.getSsthhknsyokugyoucd());
                                    drtenIpToukeiTy.setZtyhhknnen2keta(sisyaToukeiHokan.getSsthhknnen2keta());
                                    drtenIpToukeiTy.setZtyhhknseikbn(sisyaToukeiHokan.getSsthhknseikbn());
                                    drtenIpToukeiTy.setZtymusymd(sisyaToukeiHokan.getSstmosymd());
                                    drtenIpToukeiTy.setZtysyokaipryosyuymd(sisyaToukeiHokan.getSstfstpryousyuuymd());
                                    drtenIpToukeiTy.setZtykokutiymd(sisyaToukeiHokan.getSstkokutiymd());
                                    drtenIpToukeiTy.setZtymosnyuuryokuymd(sisyaToukeiHokan.getSstmosnyuuryokuymd());
                                    drtenIpToukeiTy.setZtykykymd(sisyaToukeiHokan.getSstkykymd());
                                    drtenIpToukeiTy.setZtysekininkaisiymd(sisyaToukeiHokan.getSstsekininkaisiymd());
                                    drtenIpToukeiTy.setZtyfstpnyknsyoriymd(sisyaToukeiHokan.getSstfstpnyknsyoriymd());
                                    drtenIpToukeiTy.setZtyfstpnyknnaiyoukbn(sisyaToukeiHokan.getSstfstpnyknnaiyoukbn());
                                    drtenIpToukeiTy.setZtysisyaketsyoriymd(sisyaToukeiHokan.getSstsisyaketteisyoriymd());
                                    drtenIpToukeiTy.setZtysyosakuseiymd(sisyaToukeiHokan.getSstsyoukensakuseiymd());
                                    drtenIpToukeiTy.setZtyseisekiym(sisyaToukeiHokan.getSstseisekikijyym());
                                    drtenIpToukeiTy.setZtysyokaiharaikomip(sisyaToukeiHokan.getSstfstphrkgkyen());
                                    drtenIpToukeiTy.setZtysyono(sisyaToukeiHokan.getSstsyono());
                                    drtenIpToukeiTy.setZtytokusyujimutoriatukaikbn(sisyaToukeiHokan.
                                        getSsttokusyujimutoriatukaikbn());
                                    drtenIpToukeiTy.setZtybsydrtencd(kesyoSakiKryoDrtenCd);
                                    drtenIpToukeiTy.setZtybsydrtenkjnm(kesyoSakiKryoKjDrtenNm);
                                    drtenIpToukeiTy.setZtyatkisyagyskkjsosikicd(sisyaToukeiHokan.
                                        getSstatkisyagyskkjsosikicd());
                                    drtenIpToukeiTy.setZtyatkisyadrtenatkiwari(sisyaToukeiHokan.
                                        getSstatkisyadrtenatkiwari());
                                    drtenIpToukeiTy.setZtyhknkkn(sisyaToukeiHokan.getSsthknkkn());
                                    drtenIpToukeiTy.setZtyphrkkikn(sisyaToukeiHokan.getSstphrkkikn());
                                    drtenIpToukeiTy.setZtyhrkkaisuukbn(sisyaToukeiHokan.getSsthrkkaisuukbn());
                                    drtenIpToukeiTy.setZtyhrkkeirokbn(sisyaToukeiHokan.getSsthrkkeirokbn());
                                    drtenIpToukeiTy.setZtykinyuukikancd(kesyoSakiKryoKinuSakanCd);
                                    drtenIpToukeiTy.setZtyinfositencd(kesyoSakiKryoKinyuuSitenCd);
                                    drtenIpToukeiTy.setZtycifcd(sisyaToukeiHokan.getSstcifcd());
                                    drtenIpToukeiTy.setZtykjkyknm10(sisyaToukeiHokan.getSstkjkyknm10());
                                    drtenIpToukeiTy.setZtykthhbhyouji(sisyaToukeiHokan.getSstketteihoryuuhubihyouji());
                                    drtenIpToukeiTy.setZtysrhhbhyouji(sisyaToukeiHokan.getSstseirituhoryuuhubihyouji());
                                    drtenIpToukeiTy.setZtymossyumtkktymd(sisyaToukeiHokan.getSstmossyoumetukakuteiymd());
                                    drtenIpToukeiTy.setZtydairitenjimusyocd(kesyoSakiKryoDrtenJimSyoCd);
                                    drtenIpToukeiTy.setZtytsrybnwari(sisyaToukeiHokan.getSsttsrybnwari());
                                    drtenIpToukeiTy.setZtydrtenkeijyouym(sisyaToukeiHokan.getSstdrtenkeijyouym());
                                    drtenIpToukeiTy.setZtykydatkidairitencd(sisyaToukeiHokan.getSstkydatkidairitencd());
                                    drtenIpToukeiTy.setZtydaihyoubosyuunincd(sisyaToukeiHokan.getSstdaihyoubosyuunincd());
                                    drtenIpToukeiTy.setZtytansyukukjdhybosyuunm(tansyukuKjBosyuuNm);
                                    drtenIpToukeiTy.setZtyknkyknm15(sisyaToukeiHokan.getSstknkyknm15());
                                    drtenIpToukeiTy.setZtydakuhikettikekkacd(sisyaToukeiHokan.getSstdakuhiketteikekkacd());
                                    drtenIpToukeiTy.setZtydkhktiymd(sisyaToukeiHokan.getSstdakuhiketteiymd());
                                    drtenIpToukeiTy.setZtytoukeiyousinsakbn(sisyaToukeiHokan.getSsttoukeiyousinsakbn());
                                    drtenIpToukeiTy.setZtyhonninkknnkbn(sisyaToukeiHokan.getSsthonninkakuninkbn());
                                    drtenIpToukeiTy.setZtynstkarihyj(sisyaToukeiHokan.getSstnkshrtkykarihyouji());
                                    drtenIpToukeiTy.setZtynstknkkkn(sisyaToukeiHokan.getSstnkshrtkyknkkkn());
                                    drtenIpToukeiTy.setZtydrtentsryhushrkykhyouji(sisyaToukeiHokan.
                                        getSstdrtentsryhushrkykhyouji());
                                    drtenIpToukeiTy.setZtynyknkanskanouhyouji(sisyaToukeiHokan.getSstnyknkanskanouhyouji());
                                    drtenIpToukeiTy.setZtydshukahyouji(sisyaToukeiHokan.getSstdshukahyouji());
                                    drtenIpToukeiTy.setZtystdairiseikyuutkykarihyj(sisyaToukeiHokan.
                                        getSstsiteidairisktkykarihyouj());
                                    drtenIpToukeiTy.setZtykyksyanen(sisyaToukeiHokan.getSstkyksyanen());
                                    drtenIpToukeiTy.setZtykyksyaseikbn(sisyaToukeiHokan.getSstkyksyaseikbn());
                                    drtenIpToukeiTy.setZtyhhknseiymd(sisyaToukeiHokan.getSsthhknseiymd());
                                    drtenIpToukeiTy.setZtydrtenpaperlessmoshyj(sisyaToukeiHokan.getSstdrtenpaperlessmoshyj());
                                    drtenIpToukeiTy.setZtydrtenmostousyaukeymd(sisyaToukeiHokan.getSstdrtenmostousyaukeymd());
                                    drtenIpToukeiTy.setZtykyktuuka(sisyaToukeiHokan.getSstkyktuuka());
                                    drtenIpToukeiTy.setZtyhrktuuka(sisyaToukeiHokan.getSsthrktuuka());
                                    drtenIpToukeiTy.setZtysykihrkpgaika(sisyaToukeiHokan.getSstfstphrkgkgaika());
                                    drtenIpToukeiTy.setZtyyennykntkarihyouji(sisyaToukeiHokan.getSstyennykntkykarihyouji());
                                    drtenIpToukeiTy.setZtygaikanykntkarihyouji(sisyaToukeiHokan.
                                        getSstgaikanykntkykarihyouji());
                                    drtenIpToukeiTy.setZtykihonsgaika(sisyaToukeiHokan.getSstkihonsgaika());
                                    drtenIpToukeiTy.setZtytekiyoukawaserate(sisyaToukeiHokan.getSsttekiyoukawaserate());
                                    drtenIpToukeiTy.setZtykawaseratetekiyouymd(sisyaToukeiHokan.
                                        getSstkawaseratetekiyouymd());
                                    drtenIpToukeiTy.setZtymkhyoutiyensysnikoukbn(sisyaToukeiHokan.getSstmkhyoutiyensysnikoukbn());
                                    drtenIpToukeiTy.setZtysyksbyensitihsyutkykhyj(sisyaToukeiHokan.getSstsyksbyensitihsyutkykhyj());
                                    drtenIpToukeiTy.setZtyjyudkaigomehrtkarihyj(sisyaToukeiHokan.getSstjyudkaigomehrtkarihyj());
                                    drtenIpToukeiTy.setZtysykihrkpsiteituuka(sisyaToukeiHokan.getSstfstphrkgksiteituuka());
                                    drtenIpToukeiTy.setZtyteirituhaibunwari(sisyaToukeiHokan.getSstteirituhaibunwari());
                                    drtenIpToukeiTy.setZtysueokikknkbn(sisyaToukeiHokan.getSstsueokikknkbn());
                                    drtenIpToukeiTy.setZtynksyuruikbn1(sisyaToukeiHokan.getSstnksyuruikbn1());
                                    drtenIpToukeiTy.setZtydairitenkbtinfo1(sisyaToukeiHokan.getSstbosyuudrtenkobetuinfo1());
                                    drtenIpToukeiTy.setZtydairitenkbtinfo2(sisyaToukeiHokan.getSstbosyuudrtenkobetuinfo2());
                                    drtenIpToukeiTy.setZtydairitenkbtinfo3(sisyaToukeiHokan.getSstbosyuudrtenkobetuinfo3());
                                    drtenIpToukeiTy.setZtyyohurimiryou(sisyaToukeiHokan.getSstyohurimiryou());
                                    drtenIpToukeiTy.setZtykznyuuryokuymd(sisyaToukeiHokan.getSstkouzanyuuryokuymd());
                                    drtenIpToukeiTy.setZtysetaitemosno(sisyaToukeiHokan.getSstsetaitemosno());
                                    drtenIpToukeiTy.setZtyyakkanjyuryouhoukbn(sisyaToukeiHokan.getSstyakkanjyuryouhoukbn());
                                    drtenIpToukeiTy.setZtyyakkanbunsyono(sisyaToukeiHokan.getSstyakkanbunsyono());
                                    drtenIpToukeiTy.setZtykzhuritourokuhoukbn(sisyaToukeiHokan.getSstkzhuritourokuhoukbn());
                                    drtenIpToukeiTy.setZtydai1hknkkn(sisyaToukeiHokan.getSstdai1hknkkn());
                                    drtenIpToukeiTy.setZtycreditnyuuryokuymd(sisyaToukeiHokan.getSstcreditnyuuryokuymd());
                                    drtenIpToukeiTy.setZtycreditmiryou(sisyaToukeiHokan.getSstcreditmiryou());
                                    drtenIpToukeiTy.setZtycredittrkhoukbn(sisyaToukeiHokan.getSstcredittrkhoukbn());
                                    drtenIpToukeiTy.setZtycardbrandkbn(sisyaToukeiHokan.getSstcardbrandkbn());
                                    drtenIpToukeiTy.setZtycarddatasousinymd(sisyaToukeiHokan.getSstcarddatasousinymd());
                                    drtenIpToukeiTy.setZtykykdrtkykarihyj(sisyaToukeiHokan.getSstkykdrtkykarihyj());
                                    drtenIpToukeiTy.setZtykzktrkservicekbn(sisyaToukeiHokan.getSstkzktrkservicekbn());
                                    drtenIpToukeiTy.setZtyteikisiharaiarihyj(sisyaToukeiHokan.getSstteikishrtkykarihyouji());
                                    drtenIpToukeiTy.setZtyteikishrkinshrtuukakbn(sisyaToukeiHokan.getSstteikishrkinshrtuukakbn());
                                    drtenIpToukeiTy.setZtyteikisiharaikin(sisyaToukeiHokan.getSstteikisiharaikin());
                                    drtenIpToukeiTy.setZtykoureikzksetumeihoukbn(sisyaToukeiHokan.getSstkoureikzksetumeihoukbn());
                                    drtenIpToukeiTy.setZtykoureimndnhukusuukaikbn(sisyaToukeiHokan.getSstkoureimndnhukusuukaikbn());
                                    drtenIpToukeiTy.setZtykoureitratkisyaigidskkbn(sisyaToukeiHokan.getSstkoureitratkisyaigidskkbn());
                                    drtenIpToukeiTy.setZtyhknsyukigou(sisyaToukeiHokan.getSsthknsyukigou());
                                    drtenIpToukeiTy.setZtysaimnkkykhyj(sisyaToukeiHokan.getSstsaimnkkykhyj());
                                    drtenIpToukeiTy.setZtynnknsnpssysyup(sisyaToukeiHokan.getSstnnknsnpssysyup());
                                    drtenIpToukeiTy.setZtynnknsnpssykwsrate(sisyaToukeiHokan.getSstnnknsnpssykwsrate());
                                    drtenIpToukeiTy.setZtyzennoup(sisyaToukeiHokan.getSstzennoup());
                                    drtenIpToukeiTy.setZtynenkinzeiseitokuyakukbn(sisyaToukeiHokan.getSstnenkinzeiseitokuyakukbn());

                                    BizPropertyInitializer.initialize(drtenIpToukeiTy);
                                    addHenkouSqlCountDrtenIns(genInsertLst, sisyaToukeiHokanDeleteLst,
                                        sisyaToukeiHokanUpdateLst, drtenIpToukeiTy);

                                    syoriKensuDrten++;
                                }

                                if (C_UmuKbn.ARI.eq(seirtSyutrkF)) {
                                    ZT_SkSeirituRituTy skSeirituRituTy = new ZT_SkSeirituRituTy();

                                    skSeirituRituTy.setZtyeigyouhonbusisyacd(eigyouHonbuSisyaCd_Daikei);
                                    skSeirituRituTy.setZtysisyanm(egyoHobuShsyamei);
                                    skSeirituRituTy.setZtysosikicd(eigyouHonbuSisyaCd_Daikei);
                                    skSeirituRituTy.setZtykanjisosikinm20(dairtenKanriSoshikikimei);
                                    skSeirituRituTy.setZtyatukaisyadrtenhyouji(sisyaToukeiHokan.
                                        getSstatukaisyadrtenhyouji());
                                    skSeirituRituTy.setZtyatukaikojincd(sisyaToukeiHokan.getSstatukaikojincd());
                                    skSeirituRituTy.setZtytansyukukjatukaisyanm(tensyukuKjAtkishaNm);
                                    skSeirituRituTy.setZtymosno(sisyaToukeiHokan.getSstmosno());
                                    skSeirituRituTy.setZtyknjhhknmei(sisyaToukeiHokan.getSstkanjihihokensyanm());
                                    skSeirituRituTy.setZtyhhknnen2keta(sisyaToukeiHokan.getSsthhknnen2keta());
                                    skSeirituRituTy.setZtykyksyanen(sisyaToukeiHokan.getSstkyksyanen());
                                    skSeirituRituTy.setZtymosym(String.valueOf(moskmNrYM));
                                    skSeirituRituTy.setZtymosnyuuryokuymd(sisyaToukeiHokan.getSstmosnyuuryokuymd());
                                    skSeirituRituTy.setZtymoskbn(sisyaToukeiHokan.getSstmoskbn());
                                    skSeirituRituTy.setZtymossyoumetukbn(sisyaToukeiHokan.getSstmossyoumetukbn());
                                    skSeirituRituTy.setZtymossyumtkktymd(sisyaToukeiHokan.getSstmossyoumetukakuteiymd());
                                    skSeirituRituTy.setZtykurikosiriyuukbn(sisyaToukeiHokan.getSstkurikosiriyuukbn());
                                    skSeirituRituTy.setZtynyknzumihyouji(sisyaToukeiHokan.getSstnyknzumihyouji());
                                    skSeirituRituTy.setZtynyknjkkbn(sisyaToukeiHokan.getSstnyknjkkbn());
                                    skSeirituRituTy.setZtyketjkkbn(sisyaToukeiHokan.getSstketteijkkbn());
                                    skSeirituRituTy.setZtydakuhiktjyoutaikbn(sisyaToukeiHokan.
                                        getSstdakuhiketteijyoutaikbn());
                                    skSeirituRituTy.setZtykokutiymd(sisyaToukeiHokan.getSstkokutiymd());
                                    skSeirituRituTy.setZtyhjykktkbn(sisyaToukeiHokan.getSsthoujyoukokutikbn());
                                    skSeirituRituTy.setZtytokuteikanikokutikbn(sisyaToukeiHokan.
                                        getSsttokuteikanikokutikbn());
                                    skSeirituRituTy.setZtydakuhikettikekkacd(sisyaToukeiHokan.getSstdakuhiketteikekkacd());
                                    skSeirituRituTy.setZtysinhsys(sisyaToukeiHokan.getSstsinhsys());
                                    skSeirituRituTy.setZtyjyunhsys(sisyaToukeiHokan.getSstjyunhsys());
                                    skSeirituRituTy.setZtyhsys(sisyaToukeiHokan.getSsthsys());
                                    skSeirituRituTy.setZtysoukensuu(sisyaToukeiHokan.getSstsoukensuu());
                                    skSeirituRituTy.setZtytoukeihknsyruikbn(sisyaToukeiHokan.getSsttoukeiyouhknsyuruikbn());
                                    skSeirituRituTy.setZtyhrkkaisuukbn(sisyaToukeiHokan.getSsthrkkaisuukbn());
                                    skSeirituRituTy.setZtyhrkkeirokbn(sisyaToukeiHokan.getSsthrkkeirokbn());
                                    skSeirituRituTy.setZtykykktaikbn(sisyaToukeiHokan.getSstkykkeitaikbn());
                                    skSeirituRituTy.setZtybsudirtnatkikeitaikbn(sisyaToukeiHokan.
                                        getSstbosyuudrtenatkikeitaikbn());
                                    skSeirituRituTy.setZtytokusyujimutoriatukaikbn(sisyaToukeiHokan.
                                        getSsttokusyujimutoriatukaikbn());
                                    skSeirituRituTy.setZtykihonhubi(sisyaToukeiHokan.getSstkihonhubi());
                                    skSeirituRituTy.setZtysphubi(sisyaToukeiHokan.getSstsphubi());
                                    skSeirituRituTy.setZtysseigenhubi(sisyaToukeiHokan.getSstsseigenhubi());
                                    skSeirituRituTy.setZtynayosehumei(sisyaToukeiHokan.getSstnayosehumei());
                                    skSeirituRituTy.setZtytuusangendoover(sisyaToukeiHokan.getSsttuusangendoover());
                                    skSeirituRituTy.setZtymosketteihoryuu(sisyaToukeiHokan.getSstmosketteihoryuu());
                                    skSeirituRituTy.setZtykykkakjissityuu(sisyaToukeiHokan.getSstkykkakuninjissityuu());
                                    skSeirituRituTy.setZtykktketteihoryuu(sisyaToukeiHokan.getSstkokutiketteihoryuu());
                                    skSeirituRituTy.setZtyhonsyakethoryuu(sisyaToukeiHokan.getSsthonsyaketteihoryuu());
                                    skSeirituRituTy.setZtyseiymdhubi(sisyaToukeiHokan.getSstseiymdhubi());
                                    skSeirituRituTy.setZtyphusoku(sisyaToukeiHokan.getSstphusoku());
                                    skSeirituRituTy.setZtysrhuketyu(sisyaToukeiHokan.getSstseirituhoryuuuketuketyuu());
                                    skSeirituRituTy.setZtypkakin(sisyaToukeiHokan.getSstpkakin());
                                    skSeirituRituTy.setZtymostoutyakuymd(sisyaToukeiHokan.getSstmostoutyakuymd());
                                    skSeirituRituTy.setZtykkttoutyakuymd(sisyaToukeiHokan.getSstkkttoutyakuymd());
                                    skSeirituRituTy.setZtysakuseiymd(syoriYmd.toString());
                                    skSeirituRituTy.setZtysyokaipnyuknhuhukbn2(sisyaToukeiHokan.getSstfstpnyknhouhoukbn2());
                                    skSeirituRituTy.setZtysyokaiharaikomip(sisyaToukeiHokan.getSstfstpsshkhrkgkyen());
                                    skSeirituRituTy.setZtyryousyuuymd(sisyaToukeiHokan.getSstryousyuuymd());
                                    skSeirituRituTy.setZtykeiyakukakuninsyuruikbn(sisyaToukeiHokan.
                                        getSstkykkakuninsyuruikbn());
                                    skSeirituRituTy.setZtykykkakjkkbn1(sisyaToukeiHokan.getSstkykkakuninjkkbn1());
                                    skSeirituRituTy.setZtymusymd(sisyaToukeiHokan.getSstmosymd());
                                    skSeirituRituTy.setZtymossyosakuseiymd(sisyaToukeiHokan.getSstmossakuseiymd());
                                    skSeirituRituTy.setZtysyosakuseiymd(sisyaToukeiHokan.getSstsyoukensakuseiymd());
                                    skSeirituRituTy.setZtykjkyknm(sisyaToukeiHokan.getSstkjkyknm());
                                    skSeirituRituTy.setZtyknkyknm18(sisyaToukeiHokan.getSstknkyknm18());
                                    skSeirituRituTy.setZtyseirituyoukihontikucd(sisyaToukeiHokan.
                                        getSstseirituyoukihontikucd());
                                    skSeirituRituTy.setZtymosksnym(sisyaToukeiHokan.getSstmosksnym());
                                    skSeirituRituTy.setZtyyohurimiryou(sisyaToukeiHokan.getSstyohurimiryou());
                                    skSeirituRituTy.setZtycreditmiryou(sisyaToukeiHokan.getSstcreditmiryou());
                                    skSeirituRituTy.setZtykzktrkservicekbn(sisyaToukeiHokan.getSstkzktrkservicekbn());
                                    skSeirituRituTy.setZtykykdrtkykarihyj(sisyaToukeiHokan.getSstkykdrtkykarihyj());
                                    skSeirituRituTy.setZtystdairiseikyuutkykarihyj(sisyaToukeiHokan.getSstsiteidairisktkykarihyouj());
                                    skSeirituRituTy.setZtyyakkanjyuryouhoukbn(sisyaToukeiHokan.getSstyakkanjyuryouhoukbn());
                                    skSeirituRituTy.setZtyyakkanbunsyono(sisyaToukeiHokan.getSstyakkanbunsyono());
                                    skSeirituRituTy.setZtykzktuutityokusoukbn(sisyaToukeiHokan.getSstkzktuutityokusoukbn());

                                    BizPropertyInitializer.initialize(skSeirituRituTy);
                                    addHenkouSqlCountSkseiIns(genInsertLst, sisyaToukeiHokanDeleteLst,
                                        sisyaToukeiHokanUpdateLst, skSeirituRituTy);

                                    syoriKensuSeirtu++;
                                }
                            }
                            else  {
                                cifCd = mosDairitenLst.get(0).getCifcd();

                                for (HT_MosDairiten mosDairiten : mosDairitenLst) {
                                    tratkiagCd = "";
                                    eigyouhonBusisyaCd = "0000000";
                                    sosikiCd = "0000000";
                                    atukaikojinCd = "000000";
                                    kesyoSakiKryoDrtenCd = "";
                                    kesyoSakiKryoKjDrtenNm = "";
                                    C_DrtenChannelSyurui kesyoSakiKryoDrtenChannelSyurui = C_DrtenChannelSyurui.BLNK;
                                    kesyoSakiKryoKinuSakanCd = "0000";
                                    kesyoSakiKryoKinyuuSitenCd = "";
                                    kesyoSakiKryoDrtenJimSyoCd = "";
                                    egyoHobuShsyamei = "";
                                    dairtenKanriSoshikikimei = "";
                                    daibosyuuCd = "000000";
                                    kouinnCd = "";
                                    tansyukuKjBosyuuNm = "";
                                    bosyuuTrkNo = "";
                                    tensyukuKjAtkishaNm = "";
                                    atkisyaGysKkjSosikiCd = "0000000";
                                    kydatkiDrtenCd = "";
                                    if (!BizUtil.isBlank(mosDairiten.getTratkiagcd()) &&
                                        !BizUtil.isBlank(mosDairiten.getBosyuucd())) {
                                        tratkiagCd = mosDairiten.getTratkiagcd();
                                        if (!BizUtil.isBlank(mosDairiten.getDrtenkanrisosikicd())
                                            && mosDairiten.getDrtenkanrisosikicd().length() > 2) {
                                            eigyouhonBusisyaCd = mosDairiten.getDrtenkanrisosikicd().substring(0, 3) + "0000";
                                        }
                                        else {
                                            eigyouhonBusisyaCd = "0000000";
                                        }
                                        sosikiCd = mosDairiten.getDrtenkanrisosikicd();
                                        atukaikojinCd = mosDairiten.getBosyuucd();
                                        daibosyuuCd = mosDairiten.getDaibosyuucd();
                                        List<BzGetAgInfoBean> bzGetAgInfoBeanLst = bzGetAgInfo
                                            .exec(mosDairiten.getTratkiagcd());
                                        for (BzGetAgInfoBean bzGetAgInfoBean : bzGetAgInfoBeanLst) {
                                            if (C_DiritenjyouhouKbn.KEISYOUKO.eq(bzGetAgInfoBean.getDiritenJyouhouKbn())) {
                                                kesyoSakiKryoDrtenCd = bzGetAgInfoBean.getDrtenCd();
                                                kesyoSakiKryoDrtenChannelSyurui = bzGetAgInfoBean.getDrtenChannelSyurui();
                                                kesyoSakiKryoKinuSakanCd = bzGetAgInfoBean.getKinyuuCd();
                                                kesyoSakiKryoKinyuuSitenCd = bzGetAgInfoBean.getKinyuuSitenCd();
                                                kesyoSakiKryoDrtenJimSyoCd = bzGetAgInfoBean.getDrtenJimCd();
                                                if (bzGetAgInfoBean.getKanjiDairitenNm().length() > 15) {
                                                    kesyoSakiKryoKjDrtenNm = bzGetAgInfoBean.getKanjiDairitenNm().substring(0,
                                                        15);
                                                }
                                                else {
                                                    kesyoSakiKryoKjDrtenNm = bzGetAgInfoBean.getKanjiDairitenNm();
                                                }
                                                break;
                                            }
                                        }

                                        //                                        if ("1".equals(tokusyujimutoriatukaikbn)){
                                        egyoHobuShsyamei = dairitenKeiyakuEgyoHobuShsyamei;
                                        dairtenKanriSoshikikimei = dairitenKeiyakuDrtenKanriSosikikimei;
                                        //                                        }
                                        //                                        else {
                                        //                                            if (!BizUtil.isBlank(mosDairiten.getDrtenkanrisosikicd())) {
                                        //                                                if (mosDairiten.getDrtenkanrisosikicd().length() > 2) {
                                        //                                                    egyoHobuShsyamei = bzGetSosikiData.exec(mosDairiten.getDrtenkanrisosikicd().
                                        //                                                        substring(0, 3) + "0000", syoriYmd).getKanjisosikinm20();
                                        //                                                }
                                        //                                                dairtenKanriSoshikikimei = bzGetSosikiData.exec(mosDairiten.getDrtenkanrisosikicd(),
                                        //                                                    syoriYmd).getKanjisosikinm20();
                                        //                                            }
                                        //                                        }

                                        BzGetBsInfoBean bzGetBsInfoBeanDaihybsncd = bzGetBsInfo.exec(mosDairiten.
                                            getDaibosyuucd());
                                        if (bzGetBsInfoBeanDaihybsncd != null) {
                                            if (bzGetBsInfoBeanDaihybsncd.getKanjiBosyuuninNm().length() > 7) {
                                                tansyukuKjBosyuuNm = bzGetBsInfoBeanDaihybsncd.getKanjiBosyuuninNm().
                                                    substring(0, 7);
                                            }
                                            else {
                                                tansyukuKjBosyuuNm = bzGetBsInfoBeanDaihybsncd.getKanjiBosyuuninNm();
                                            }
                                        }
                                        BzGetBsInfoBean bzGetBsInfoBeanBsnincd = bzGetBsInfo.exec(mosDairiten.getBosyuucd());
                                        if (bzGetBsInfoBeanBsnincd != null) {
                                            if (bzGetBsInfoBeanBsnincd.getKanjiBosyuuninNm().length() > 7) {
                                                tensyukuKjAtkishaNm = bzGetBsInfoBeanBsnincd.getKanjiBosyuuninNm().substring(0, 7);
                                            }
                                            else {
                                                tensyukuKjAtkishaNm = bzGetBsInfoBeanBsnincd.getKanjiBosyuuninNm();
                                            }
                                            bosyuuTrkNo = bzGetBsInfoBeanBsnincd.getBosyuuTrkNo();
                                            if (bzGetBsInfoBeanBsnincd.getKouinCd().length() > 15) {
                                                kouinnCd = bzGetBsInfoBeanBsnincd.getKouinCd().substring(0, 15);
                                            }
                                            else {
                                                kouinnCd = bzGetBsInfoBeanBsnincd.getKouinCd();
                                            }
                                        }
                                        if (mosDairitenLst.size() == 1) {
                                            kydatkiDrtenCd = "";
                                        }
                                        else {
                                            if (mosDairiten.getRenno() == 1 &&
                                                !BizUtil.isBlank(mosDairitenLst.get(1).getBosyuucd())) {
                                                kydatkiDrtenCd = mosDairitenLst.get(1).getTratkiagcd();
                                            }
                                            if (mosDairiten.getRenno() == 2 &&
                                                !BizUtil.isBlank(mosDairitenLst.get(0).getBosyuucd())) {
                                                kydatkiDrtenCd = mosDairitenLst.get(0).getTratkiagcd();
                                            }
                                        }
                                        if (!BizUtil.isBlank(mosDairiten.getGyousekikeijyousakisosikicd())) {
                                            atkisyaGysKkjSosikiCd = mosDairiten.getGyousekikeijyousakisosikicd();
                                        }
                                        else if (mosDairitenLst.size() == 1 || BizUtil.isBlank(kydatkiDrtenCd)){
                                            atkisyaGysKkjSosikiCd = "0000000";
                                        }
                                        else {
                                            C_DrtenChannelSyurui kyoudouDrtenChannelSyurui = C_DrtenChannelSyurui.BLNK;
                                            bzGetAgInfoBeanLst = bzGetAgInfo.exec(kydatkiDrtenCd);
                                            for (BzGetAgInfoBean bzGetAgInfoBean : bzGetAgInfoBeanLst) {
                                                if (C_DiritenjyouhouKbn.KEISYOUKO.eq(bzGetAgInfoBean.getDiritenJyouhouKbn())) {
                                                    kyoudouDrtenChannelSyurui = bzGetAgInfoBean.getDrtenChannelSyurui();
                                                    break;
                                                }
                                            }
                                            if (mosDairiten.getRenno() == 1) {
                                                if (C_DrtenChannelSyurui.GINHONTAIMADO.eq(kesyoSakiKryoDrtenChannelSyurui) &&
                                                    C_DrtenChannelSyurui.GINKOUKEIDAI.eq(kyoudouDrtenChannelSyurui)) {
                                                    atkisyaGysKkjSosikiCd = mosDairitenLst.get(0).getDrtenkanrisosikicd();
                                                }
                                                else {
                                                    atkisyaGysKkjSosikiCd = "0000000";
                                                }
                                            }
                                            if (mosDairiten.getRenno() == 2) {
                                                if (C_DrtenChannelSyurui.GINKOUKEIDAI.eq(kesyoSakiKryoDrtenChannelSyurui) &&
                                                    C_DrtenChannelSyurui.GINHONTAIMADO.eq(kyoudouDrtenChannelSyurui)) {
                                                    if (!BizUtil.isBlank(mosDairitenLst.get(0).getGyousekikeijyousakisosikicd())) {
                                                        atkisyaGysKkjSosikiCd = mosDairitenLst.get(0).getGyousekikeijyousakisosikicd();
                                                    }
                                                    else {
                                                        atkisyaGysKkjSosikiCd = mosDairitenLst.get(0).getDrtenkanrisosikicd();
                                                    }
                                                }
                                                else {
                                                    atkisyaGysKkjSosikiCd = "0000000";
                                                }
                                            }
                                        }
                                    }

                                    atkisyaDrtenWari = 0;
                                    tsrybnWari = 0;
                                    soukensuu = 0;
                                    drtenIpToukeikydatki = "0";
                                    if (mosDairitenLst.size() == 1) {
                                        tsrybnWari = 0;
                                        atkisyaDrtenWari = 100;
                                        drtenIpToukeikydatki = "0";
                                    }
                                    else {
                                        if ( !BizUtil.isBlank(mosDairitenLst.get(0).getTratkiagcd()) &&
                                            !BizUtil.isBlank(mosDairitenLst.get(1).getTratkiagcd()) &&
                                            mosDairitenLst.get(1).getTratkiagcd().equals(
                                                mosDairitenLst.get(0).getTratkiagcd())){
                                            if (mosDairiten.getRenno() == 1) {
                                                atkisyaDrtenWari = 100;
                                            }
                                            else {
                                                atkisyaDrtenWari = 0;
                                            }
                                            tsrybnWari = 0;
                                        }
                                        else {
                                            atkisyaDrtenWari = 50;
                                            tsrybnWari = Long.parseLong(mosDairiten.getBunwari().toString());
                                        }
                                        if (mosDairiten.getRenno() == 1){
                                            drtenIpToukeikydatki = "1";
                                        }
                                        else {
                                            drtenIpToukeikydatki = "2";
                                        }
                                    }
                                    soukensuu = atkisyaDrtenWari / 10;

                                    if (mosDairiten.getRenno() == 1) {
                                        if (sisyaToukeiHokanLst.size() > 0) {
                                            sisyaToukeiHokan = sisyaToukeiHokanLst.get(idxSstLst.get(0));
                                        }
                                        else {
                                            sisyaToukeiHokan = new HT_SisyaToukeiHokan();
                                        }
                                    }
                                    else {
                                        if (sisyaToukeiHokanLst.size() == 2) {
                                            sisyaToukeiHokan = sisyaToukeiHokanLst.get(idxSstLst.get(1));
                                        }
                                        else {
                                            sisyaToukeiHokan = new HT_SisyaToukeiHokan();
                                        }
                                    }

                                    String sstBosyuuDrtenAtkikeitaiKbn = editPalRenkeiKoumoku.
                                        editBosyuuDairitenAtkiKeitaiKbn(mosDairitenLst);
                                    String hhksyaNenre = editPalRenkeiKoumoku.editHhknnen(mosKihon.getHhknnen());
                                    String sstKjkykNm = editPalRenkeiKoumoku.editKyknmkj(mosKihon.getKykkbn(),
                                        mosKihon.getHhknnmkj(), mosKihon.getKyknmkj(), 15);
                                    String sstKjkykNm10 = editPalRenkeiKoumoku.editKyknmkj(mosKihon.getKykkbn(),
                                        mosKihon.getHhknnmkj(), mosKihon.getKyknmkj(), 10);
                                    String sstKnkykNm15 = editPalRenkeiKoumoku.editKyknmkn(mosKihon.getKykkbn(),
                                        mosKihon.getHhknnmkn(), mosKihon.getKyknmkn(), 15);
                                    String sstKnkykNm18 = editPalRenkeiKoumoku.editKyknmkn(mosKihon.getKykkbn(),
                                        mosKihon.getHhknnmkn(), mosKihon.getKyknmkn(), 18);
                                    String sstKyksyaNen = editPalRenkeiKoumoku.editKyksyanen2Keta(mosKihon.getKykkbn(),
                                        mosKihon.getHhknnen(), mosKihon.getKyknen());
                                    String sstKyksyaSeikbn = editPalRenkeiKoumoku.editKykSyaseiKbn(
                                        mosKihon.getKykkbn(), mosKihon.getHhknsei(), mosKihon.getKyksei());
                                    String sstMosSyoumetuKbn = editPalRenkeiKoumoku.editMosSyoumetuKbn(
                                        syoriCTL.getSeiritukbn(), ketkekkacd);
                                    String sstNyknzumiHyouji = editPalRenkeiKoumoku.editNyknzumiHyouji(
                                        syoriCTL.getMosnrkumu(), syoriCTL.getNyknnrkumu());
                                    String sstNyknjkKbn = editPalRenkeiKoumoku.editNyknJkKbn(syoriCTL.getNyknnrkumu(),
                                        syoriCTL.getRyosyuymd(), mosKihon.getMosym());
                                    String sstHoujyouKokutiKbn = editPalRenkeiKoumoku.editHjykktKbn(mosKihon.
                                        getSntkhoukbn());
                                    String sstDakuhiKetteikekkaCd = editPalRenkeiKoumoku.
                                        editDakuhiKtkekkaCd(dakuhiKetsaisnKetkekkacd);
                                    String sstToukeiyouSinsaKbn = editPalRenkeiKoumoku.editToukeiyouSinsaKbn(mosKihon.
                                        getSntkhoukbn());
                                    String sstSiteidairiSktkykarihYouj = editPalRenkeiKoumoku.editTkariHyouji(mosKihon.
                                        getStdrsktkyhkkbn());

                                    String sstKykkakuninSyuruiKbn = "00";
                                    if (kykKak != null) {
                                        sstKykkakuninSyuruiKbn = bzKbnHenkanUtil.convKbn(
                                            kykKak.getKykkaksyrui().getValue(), C_Kykkaksyrui.class,
                                            C_SystemRenkeiHenkanHoukouKbn.RAY_TO_OTHER).getKbnData();
                                    }
                                    String sstKykkakuninJkkbn1 = editPalRenkeiKoumoku.editKykKakjkKbn1(
                                        syoriCTL.getKykkakjkkbn(), syoriCTL.getSeiritukbn(),
                                        mosKihon.getKakukisyouryakukbumukbn());
                                    String toukeiHokensyuruiKbn = editPalRenkeiKoumoku.getToukeiHokensyuruiKbn(
                                        syouhnZokuseiMST, mosKihon);
                                    String sstHknKkn = "00";
                                    String sstPhrkKikn = "00";
                                    String sstsaimnkkykHyj = "0";
                                    if (mosSyouhnTBL.getHknkkn() != null && mosSyouhnTBL.getHrkkkn() != null) {
                                        editPalRenkeiKoumoku.editHknkkn(mosKihon, mosSyouhnTBL, syouhnZokuseiMST);
                                        sstHknKkn = editPalRenkeiKoumoku.getHknKkn();
                                        sstPhrkKikn = editPalRenkeiKoumoku.getHrkkkn();
                                        sstsaimnkkykHyj = editPalRenkeiKoumoku.getSaiMnkKykHyj();
                                    }

                                    String sstHrkKaisuuKbn = editPalRenkeiKoumoku.editHrkkaisuu(mosKihon);
                                    String sstHrkkeiroKbn = editPalRenkeiKoumoku.editHrkKeiroKbn(
                                        mosKihon.getHrkkeiro(), mosKihon.getHrkkaisuu());
                                    String sstNkshrTkykarihYouji = editPalRenkeiKoumoku.
                                        editTkariHyouji(mosKihon.getNstkhkkbn());
                                    String sstKykTuuka = editPalRenkeiKoumoku.editTuukaKbn(mosKihon.getKyktuukasyu());
                                    String sstHrkTuuka = editPalRenkeiKoumoku.editTuukaKbn(mosKihon.getHrktuukasyu());
                                    C_Tuukasyu pYakujyouTuukasyu = null;
                                    String sstTuukaTaniKbn = null;
                                    if (C_PtratkituukasiteiKbn.HRKTUUKA.eq(syouhnZokuseiMST.getPtratkituukasiteikbn())) {
                                        pYakujyouTuukasyu = mosKihon.getHrktuukasyu();

                                        sstTuukaTaniKbn = bzKbnHenkanUtil.convKbn(
                                                mosKihon.getHrktuukasyu().getValue(), C_Tuukasyu.class,
                                                C_SystemRenkeiHenkanHoukouKbn.RAY_TO_OTHER).getKbnData();
                                    }
                                    else {
                                        pYakujyouTuukasyu = mosKihon.getKyktuukasyu();

                                        sstTuukaTaniKbn = bzKbnHenkanUtil.convKbn(
                                                mosKihon.getKyktuukasyu().getValue(), C_Tuukasyu.class,
                                                C_SystemRenkeiHenkanHoukouKbn.RAY_TO_OTHER).getKbnData();
                                    }

                                    String sstYennyknTkykarihYouji = editPalRenkeiKoumoku.editTkariHyouji(mosKihon.
                                        getYennykntkhkkbn());
                                    String sstGaikaNyknTkykarihYouji = editPalRenkeiKoumoku.editTkariHyouji(mosKihon.
                                        getGaikanykntkhkkbn());
                                    String sstYenshrTkykarihYouji = editPalRenkeiKoumoku.editTkariHyouji(mosKihon.
                                        getYenshrtkhkkbn());
                                    String sstSisyaKetteiSyoriYmd = editPalRenkeiKoumoku.editSisyaketteiYmd(syoriCTL);
                                    String sstSyoukenSakuseiYmd = editPalRenkeiKoumoku.editSyokenSakuseiYmd(
                                        syoriCTL.getSeiritukbn(), syoriCTL.getSrsyoriymd());
                                    String sstFstpNyknHouhouKbn2 = editPalRenkeiKoumoku.
                                        editSinfstpNyknHouhouKbn(syoriCTL.getNyknnrkumu());
                                    String sstMosKbn = getSstmoskbn(mosKihon);
                                    String sstKurikosiRiyuukbn = getSstkurikosiriyuukbn(syoriCTL, mosKihon);
                                    String sstKetteiJkkbn = getSstketteijkkbn(syoriCTL);
                                    String sstDakuhiKetteiJyoutaiKbn = getSstdakuhiketteijyoutaikbn(syoriCTL);
                                    String sstNyknKansKanouHyouji = getSstnyknkanskanouhyouji(syoriCTL);
                                    String sstDsHukahYouji = getSstdshukahyouji(mosKihon);
                                    String sstMosjkKbn = getSstmosjkkbn(syoriCTL);
                                    String sstMosKetteiHoryuu = getSstmosketteihoryuu(syoriCTL, mostenkenRireki);
                                    String sstKykKakuninJissityuu = getSstkykkakuninjissityuu(syoriCTL, mosKihon);
                                    String sstDrtenPaperlessMoshyj = "0";
                                    String sstDrtenMosTousyaUkeYmd = "00000000";
                                    if (C_MosUketukeKbn.PAPERLESS.equals(syoriCTL.getMosuketukekbn())) {
                                        sstDrtenPaperlessMoshyj = "1";
                                        sstDrtenMosTousyaUkeYmd = String.valueOf(syoriCTL.getMosnrkymd());
                                    }
                                    String sstSykSbYenSitiHsyuTkykHyj = editPalRenkeiKoumoku.editTkariHyouji(mosKihon.getSyksbyensitihsyutkhkkbn());
                                    String sstJyudKaigoMehrTkariHyj = editPalRenkeiKoumoku.editTkariHyouji(mosKihon.getJyudkaigomehrtkhkkbn());

                                    String sstBosyuuDrtenkobetuInfo1 = "";

                                    if (!C_KoureisyaTaiouKbn.BLNK.eq(mosKihon.getKoureitaioukbn())) {

                                        sstBosyuuDrtenkobetuInfo1 = mosKihon.getKoureitaioukbn().getValue();

                                    }
                                    String nenkinsyu = editPalRenkeiKoumoku.editNenkinsyu(mosSyouhnTBL.getSknenkinsyu());

                                    String kzktrkservicekbn = editPalRenkeiKoumoku.getKzktrkServiceKbn(syoriCTL);

                                    String sstKykdrtkykarihyj = editPalRenkeiKoumoku.editTkariHyouji(mosKihon.getKykdrtkykhukakbn());

                                    String sstteikishrtkykarihyouji = editPalRenkeiKoumoku.editTkariHyouji(mosKihon.getTeikisiharaitkykhkkbn());

                                    BizNumber nknsnpssyKwsrate = editPalRenkeiKoumoku.getNknsnPssyKwsRate(mosKihon.getKyktuukasyu(),
                                        mosKihon.getHrktuukasyu(),
                                        enknsnKijyunYmd,
                                        mosKihon.getHrkkaisuu(),
                                        mosKihon.getZennoumousideumu(),
                                        mosKihon.getIkkatubaraikbn());

                                    String kzkTuutiTyokusouKbn = editPalRenkeiKoumoku.getKzkTuutiTyokusouKbn(syoriCTL);

                                    sisyaToukeiHokan.setSyrctrltblkostime(syoriCTL.getGyoumuKousinTime());
                                    sisyaToukeiHokan.setSstsyono(syoriCTL.getSyono().substring(0, 11));
                                    sisyaToukeiHokan.setSstmosym(String.valueOf(mosKihon.getMosym()));
                                    sisyaToukeiHokan.setSstmoskbn(sstMosKbn);
                                    sisyaToukeiHokan.setSstbosyuudrtenatkikeitaikbn(sstBosyuuDrtenAtkikeitaiKbn);
                                    if (mosDairitenLst.size() <= 1) {
                                        sisyaToukeiHokan.setSstkydatkikbn("0");
                                    }
                                    else {
                                        sisyaToukeiHokan.setSstkydatkikbn("1");
                                    }
                                    sisyaToukeiHokan.setSstatukaisyadrtenhyouji("1");
                                    sisyaToukeiHokan.setTratkiagcd(tratkiagCd);
                                    sisyaToukeiHokan.setSsteigyouhonbusisyacd(Strings.padStart(eigyouhonBusisyaCd, 7, '0'));
                                    sisyaToukeiHokan.setSstsosikicd(Strings.padStart(sosikiCd, 7, '0'));
                                    sisyaToukeiHokan.setSstatkisyagyskkjsosikicd(atkisyaGysKkjSosikiCd);
                                    sisyaToukeiHokan.setSstcifcd(cifCd);
                                    sisyaToukeiHokan.setSstatkisyadrtenatkiwari(atkisyaDrtenWari);
                                    sisyaToukeiHokan.setSsttsrybnwari(tsrybnWari);
                                    sisyaToukeiHokan.setSstsinhsys(0l);
                                    sisyaToukeiHokan.setSstsoukensuu(soukensuu);
                                    sisyaToukeiHokan.setSstkydatkidairitencd(kydatkiDrtenCd);
                                    sisyaToukeiHokan.setSstbosyuudrtenkobetuinfo1(sstBosyuuDrtenkobetuInfo1);
                                    sisyaToukeiHokan.setSstbosyuudrtenkobetuinfo2("");
                                    sisyaToukeiHokan.setSstbosyuudrtenkobetuinfo3("");
                                    sisyaToukeiHokan.setSstbosyuudrtenkobetuinfo4(kouinnCd);
                                    sisyaToukeiHokan.setSstbosyuudrtenkobetuinfo5("");
                                    sisyaToukeiHokan.setSstbankkouincd("");
                                    sisyaToukeiHokan.setSstdaihyoubosyuunincd(Strings.padStart(daibosyuuCd, 6, '0'));
                                    sisyaToukeiHokan.setSstatukaikojincd(atukaikojinCd);
                                    sisyaToukeiHokan.setSstkanjihihokensyanm(mosKihon.getHhknnmkj());
                                    if (mosKihon.getHhknnmkj().length() > 7) {
                                        sisyaToukeiHokan.setSsttansyukukjhhknnm(mosKihon.getHhknnmkj().substring(0,
                                            7));
                                    }
                                    else {
                                        sisyaToukeiHokan.setSsttansyukukjhhknnm(mosKihon.getHhknnmkj());
                                    }
                                    sisyaToukeiHokan.setSsthhknsyokugyoucd(Strings.padStart(
                                        mosKihon.getHhknsykgycd(), 3, '0'));
                                    sisyaToukeiHokan.setSsthhknnen2keta(hhksyaNenre);
                                    sisyaToukeiHokan.setSsthhknseikbn(mosKihon.getHhknsei().getValue());
                                    if (mosKihon.getHhknseiymd() == null) {
                                        sisyaToukeiHokan.setSsthhknseiymd("00000000");
                                    }
                                    else {
                                        sisyaToukeiHokan.setSsthhknseiymd(mosKihon.getHhknseiymd().toString());
                                    }
                                    sisyaToukeiHokan.setSstkjkyknm(sstKjkykNm);
                                    sisyaToukeiHokan.setSstkjkyknm10(sstKjkykNm10);
                                    sisyaToukeiHokan.setSstknkyknm15(sstKnkykNm15);
                                    sisyaToukeiHokan.setSstknkyknm18(sstKnkykNm18);
                                    sisyaToukeiHokan.setSstkyksyanen(sstKyksyaNen);
                                    sisyaToukeiHokan.setSstkyksyaseikbn(sstKyksyaSeikbn);
                                    sisyaToukeiHokan.setSsthjnkykhyj("0");
                                    sisyaToukeiHokan.setSstkjhjnnm("");
                                    sisyaToukeiHokan.setSstseirituyoukihontikucd(mosKihon.getTsinyno());
                                    sisyaToukeiHokan.setSstmossyoumetukbn(sstMosSyoumetuKbn);
                                    sisyaToukeiHokan.setSstkurikosiriyuukbn(sstKurikosiRiyuukbn);
                                    sisyaToukeiHokan.setSstnyknzumihyouji(sstNyknzumiHyouji);
                                    sisyaToukeiHokan.setSstnyknjkkbn(sstNyknjkKbn);
                                    sisyaToukeiHokan.setSsthoujyoukokutikbn(sstHoujyouKokutiKbn);
                                    if (C_Hrkkaisuu.ITIJI.eq(mosKihon.getHrkkaisuu())) {
                                        sisyaToukeiHokan.setSstkykkeitaikbn("04");
                                    }
                                    else {
                                        sisyaToukeiHokan.setSstkykkeitaikbn("00");
                                    }
                                    sisyaToukeiHokan.setSstketteijkkbn(sstKetteiJkkbn);
                                    sisyaToukeiHokan.setSstdakuhiketteijyoutaikbn(sstDakuhiKetteiJyoutaiKbn);
                                    sisyaToukeiHokan.setSstdakuhiketteikekkacd(sstDakuhiKetteikekkaCd);
                                    if (dakuhiKetSaisinKetteiYmd != null) {
                                        sisyaToukeiHokan.setSstdakuhiketteiymd(
                                            String.valueOf(dakuhiKetSaisinKetteiYmd));
                                    }
                                    else {
                                        sisyaToukeiHokan.setSstdakuhiketteiymd("00000000");
                                    }
                                    sisyaToukeiHokan.setSsttokusyujimutoriatukaikbn("1");
                                    sisyaToukeiHokan.setSsttoukeiyousinsakbn(sstToukeiyouSinsaKbn);
                                    sisyaToukeiHokan.setSsthonninkakuninkbn("00");
                                    sisyaToukeiHokan.setSstdrtentsryhushrkykhyouji(mosKihon.getTsryhshrkykumukbn()
                                        .getValue());
                                    sisyaToukeiHokan.setSstnyknkanskanouhyouji(sstNyknKansKanouHyouji);
                                    sisyaToukeiHokan.setSstdshukahyouji(sstDsHukahYouji);
                                    sisyaToukeiHokan.setSstsiteidairisktkykarihyouj(sstSiteidairiSktkykarihYouj);
                                    sisyaToukeiHokan.setSsttokuteikanikokutikbn("0");
                                    sisyaToukeiHokan.setSstkykkakuninsyuruikbn(sstKykkakuninSyuruiKbn);
                                    sisyaToukeiHokan.setSstkykkakuninjkkbn1(sstKykkakuninJkkbn1);
                                    sisyaToukeiHokan.setSstmosketteikekkakbn("");
                                    sisyaToukeiHokan.setSstsinsazumihyouji("0");
                                    sisyaToukeiHokan.setSstannaisakicd("00000000");
                                    sisyaToukeiHokan.setSstmosjkkbn(sstMosjkKbn);
                                    sisyaToukeiHokan.setSstkihonhubi(syoriCTL.getKhnhbkbn().getValue());
                                    sisyaToukeiHokan.setSstsphubi(spHubi);
                                    sisyaToukeiHokan.setSstsseigenhubi(sSeigenHubi);
                                    sisyaToukeiHokan.setSstnayosehumei(nayoSehumei);
                                    sisyaToukeiHokan.setSsttuusangendoover(tuusanGendoOver);
                                    sisyaToukeiHokan.setSstmosketteihoryuu(sstMosKetteiHoryuu);
                                    sisyaToukeiHokan.setSstkykkakuninjissityuu(sstKykKakuninJissityuu);
                                    sisyaToukeiHokan.setSstkokutiketteihoryuu(syoriCTL.getKktnrkhbumu().getValue());
                                    sisyaToukeiHokan.setSsthonsyaketteihoryuu(honsyaKethoryuu);
                                    sisyaToukeiHokan.setSstseiymdhubi(nseiymdHubi);
                                    if (C_NyuukinjyoutaiKbn.SEIRITUHORYUU_HUSOKUKIN.eq(syoriCTL.getNyuukinjoutaikbn())){
                                        sisyaToukeiHokan.setSstphusoku("1");
                                    }
                                    else {
                                        sisyaToukeiHokan.setSstphusoku("0");
                                    }
                                    sisyaToukeiHokan.setSstyohurimiryou(yohurimiryou);
                                    if (C_JimusrhKbn.HORYU.eq(syoriCTL.getJimusrhkbn())) {
                                        sisyaToukeiHokan.setSstseirituhoryuuuketuketyuu("1");
                                    }
                                    else {
                                        sisyaToukeiHokan.setSstseirituhoryuuuketuketyuu("0");
                                    }
                                    if (C_NyuukinjyoutaiKbn.SEIRITUHORYUU_KAKIN.eq(syoriCTL.getNyuukinjoutaikbn())) {
                                        sisyaToukeiHokan.setSstpkakin("1");
                                    }
                                    else {
                                        sisyaToukeiHokan.setSstpkakin("0");
                                    }
                                    sisyaToukeiHokan.setSstketteihoryuuhubihyouji(
                                        syoriCTL.getKthhbkbn().getValue());
                                    sisyaToukeiHokan.setSstseirituhoryuuhubihyouji(syoriCTL.getSrhhbkbn()
                                        .getValue());
                                    sisyaToukeiHokan.setSsttoukeiyouhknsyuruikbn(toukeiHokensyuruiKbn);
                                    sisyaToukeiHokan.setSsthknsyuruinm(mosKihon.getAisyoumeikbn().getContent(
                                        C_AisyoumeiKbn.PATTERN_SKSISYATOUKEI));
                                    sisyaToukeiHokan.setSsthknkkn(sstHknKkn);
                                    sisyaToukeiHokan.setSstphrkkikn(sstPhrkKikn);
                                    sisyaToukeiHokan.setSsthrkkaisuukbn(sstHrkKaisuuKbn);
                                    sisyaToukeiHokan.setSsthrkkeirokbn(sstHrkkeiroKbn);
                                    sisyaToukeiHokan.setSstnkshrtkykarihyouji(sstNkshrTkykarihYouji);
                                    sisyaToukeiHokan.setSstnkshrtkyknkkkn(Strings.padStart(
                                        String.valueOf(mosKihon.getNstksbnkkn()), 2, '0'));
                                    if (jyonHosyoSyen.toString().length() > 11) {
                                        sisyaToukeiHokan.setSstjyunhsys(99999999999l);
                                    }
                                    else {
                                        sisyaToukeiHokan.setSstjyunhsys(
                                            new BigDecimal(jyonHosyoSyen.toString()).longValue());
                                    }
                                    if (hosyoSyen.toString().length() > 11) {
                                        sisyaToukeiHokan.setSsthsys(99999999999l);
                                    }
                                    else {
                                        sisyaToukeiHokan.setSsthsys(
                                            new BigDecimal(hosyoSyen.toString()).longValue());
                                    }
                                    sisyaToukeiHokan.setSstkyktuuka(sstKykTuuka);
                                    sisyaToukeiHokan.setSsthrktuuka(sstHrkTuuka);
                                    sisyaToukeiHokan.setSsttuukatanikbn(sstTuukaTaniKbn);
                                    if (syokaiPhrkGkyen.toString().length() > 11) {
                                        sisyaToukeiHokan.setSstfstphrkgkyen(99999999999l);
                                    }
                                    else {
                                        sisyaToukeiHokan.setSstfstphrkgkyen(
                                            new BigDecimal(syokaiPhrkGkyen.toString()).longValue());
                                    }
                                    BizCurrency sstFstPHrkgkhrkTuuka;
                                    if (C_Tuukasyu.JPY.eq(pYakujyouTuukasyu)) {
                                        sstFstPHrkgkhrkTuuka = mosKihon.getFstphrkgk();
                                    }
                                    else {
                                        sstFstPHrkgkhrkTuuka = mosKihon.getFstphrkgk().multiply(100);
                                    }
                                    if (sstFstPHrkgkhrkTuuka.toString().length() > 11) {
                                        sisyaToukeiHokan.setSstfstphrkgkhrktuukamoji("99999999999");
                                    }
                                    else {
                                        sisyaToukeiHokan.setSstfstphrkgkhrktuukamoji(Strings.padStart(
                                            sstFstPHrkgkhrkTuuka.toString(), 11, '0'));
                                    }
                                    if (!C_Tuukasyu.JPY.eq(mosKihon.getKyktuukasyu())) {
                                        if (BizNumber.valueOf(new BigDecimal(syokaiharaikomip.toString())).compareTo(BizNumber.valueOf(99999999999.99)) > 0) {
                                            sisyaToukeiHokan.setSstfstphrkgkgaika(BizNumber.valueOf(99999999999.99));
                                        } else {
                                            sisyaToukeiHokan.setSstfstphrkgkgaika(BizNumber.valueOf(
                                                new BigDecimal(syokaiharaikomip.toString())));
                                        }
                                    }
                                    else {
                                        sisyaToukeiHokan.setSstfstphrkgkgaika(BizNumber.valueOf(0));
                                    }
                                    if (syokaiHrkPsabiskGkyen.toString().length() > 11) {
                                        sisyaToukeiHokan.setSstfstpsshkhrkgkyen(99999999999l);
                                    }
                                    else {
                                        sisyaToukeiHokan.setSstfstpsshkhrkgkyen(new BigDecimal(
                                            syokaiHrkPsabiskGkyen.toString()).longValue());
                                    }
                                    sisyaToukeiHokan.setSstyennykntkykarihyouji(sstYennyknTkykarihYouji);
                                    sisyaToukeiHokan.setSstgaikanykntkykarihyouji(sstGaikaNyknTkykarihYouji);
                                    sisyaToukeiHokan.setSsyenshrtkykarihyouji(sstYenshrTkykarihYouji);
                                    if (BizNumber.valueOf(new BigDecimal(kihonsGaika.toString())).compareTo(BizNumber.valueOf(99999999999.99)) > 0) {
                                        sisyaToukeiHokan.setSstkihonsgaika(BizNumber.valueOf(99999999999.99));
                                    }
                                    else {
                                        sisyaToukeiHokan.setSstkihonsgaika(BizNumber.valueOf(
                                            new BigDecimal(kihonsGaika.toString())));
                                    }
                                    sisyaToukeiHokan.setSsttekiyoukawaserate(BizNumber.valueOf(new BigDecimal(tekiyouKawaserate.toString())));
                                    sisyaToukeiHokan.setSstkawaseratetekiyouymd(kawaserateTekiyouYmd.toString());
                                    sisyaToukeiHokan.setSstsakuseiymd(syoriYmd.toString());
                                    sisyaToukeiHokan.setSstmosymd(String.valueOf(mosKihon.getMosymd()));

                                    if (C_SntkhouKbn.NONE.eq(mosKihon.getSntkhoukbn())) {

                                        sisyaToukeiHokan.setSstkokutiymd(mosKihon.getMosymd().toString());
                                    }
                                    else {

                                        if (syoriCTL.getKktymd() != null) {
                                            sisyaToukeiHokan.setSstkokutiymd(syoriCTL.getKktymd().toString());
                                        }
                                        else {
                                            sisyaToukeiHokan.setSstkokutiymd("00000000");
                                        }
                                    }
                                    if (syoriCTL.getMosnrkymd() != null) {
                                        sisyaToukeiHokan.setSstmosnyuuryokuymd(String.valueOf(syoriCTL
                                            .getMosnrkymd()));
                                    }
                                    else {
                                        sisyaToukeiHokan.setSstmosnyuuryokuymd("00000000");
                                    }
                                    if (kouzaJyouhou != null && kouzaJyouhou.getKouzajyouhounyuuryokuymd() != null) {
                                        sisyaToukeiHokan.setSstkouzanyuuryokuymd(kouzaJyouhou.getKouzajyouhounyuuryokuymd().toString());
                                    }
                                    else {
                                        sisyaToukeiHokan.setSstkouzanyuuryokuymd("00000000");
                                    }
                                    sisyaToukeiHokan.setSstkykymd(String.valueOf(mosKihon.getKykymd()));
                                    if (mosKihon.getSknnkaisiymd() != null) {
                                        sisyaToukeiHokan.setSstsekininkaisiymd(mosKihon.getSknnkaisiymd()
                                            .toString());
                                    }
                                    else {
                                        sisyaToukeiHokan.setSstsekininkaisiymd("00000000");
                                    }
                                    sisyaToukeiHokan.setSstsisyaketteisyoriymd(sstSisyaKetteiSyoriYmd);
                                    sisyaToukeiHokan.setSstsyoukensakuseiymd(sstSyoukenSakuseiYmd);
                                    sisyaToukeiHokan.setSstseisekikijyym(String.valueOf(mosKihon.getSeisekiym()));
                                    if (C_SeirituKbn.SEIRITU.eq(syoriCTL.getSeiritukbn()) ||
                                        C_SeirituKbn.HUSEIRITU.eq(syoriCTL.getSeiritukbn())) {
                                        sisyaToukeiHokan.setSstmossyoumetukakuteiymd(String.valueOf(syoriCTL
                                            .getSrsyoriymd()));
                                    }
                                    else {
                                        sisyaToukeiHokan.setSstmossyoumetukakuteiymd("00000000");
                                    }
                                    sisyaToukeiHokan.setSstdrtenkeijyouym("000000");
                                    sisyaToukeiHokan.setSstmostoutyakuymd(String.valueOf(mosToutyakuYmd));
                                    sisyaToukeiHokan.setSstkkttoutyakuymd(String.valueOf(kktToutyakuYmd));
                                    if (mosKihon.getMossakuseiymd() != null) {
                                        sisyaToukeiHokan.setSstmossakuseiymd(
                                            String.valueOf(mosKihon.getMossakuseiymd()));
                                    }
                                    else {
                                        sisyaToukeiHokan.setSstmossakuseiymd("00000000");
                                    }
                                    sisyaToukeiHokan.setSstmosksnym(String.valueOf(mosKihon.getMosym()));
                                    sisyaToukeiHokan.setSstkariseirituymd("");
                                    sisyaToukeiHokan.setSstsinsayoteiymd("");
                                    sisyaToukeiHokan.setSstkousinymd(String.valueOf(syoriYmd));
                                    sisyaToukeiHokan.setSstryousyuuymd(String.valueOf(syokaiPryuryoYmd));
                                    sisyaToukeiHokan.setSstfstpryousyuuymd(String.valueOf(syokaiPryuryoYmd));
                                    sisyaToukeiHokan.setSstfstpnyknsyoriymd(syokaiPnyuksyorYmd.toString());
                                    sisyaToukeiHokan.setSstfstpnyknnaiyoukbn("1");
                                    sisyaToukeiHokan.setSstfstpnyknhouhoukbn2(sstFstpNyknHouhouKbn2);
                                    sisyaToukeiHokan.setSstdrtenpaperlessmoshyj(sstDrtenPaperlessMoshyj);
                                    sisyaToukeiHokan.setSstdrtenmostousyaukeymd(sstDrtenMosTousyaUkeYmd);
                                    if (!C_Tkhukaumu.HUKA.eq(mosKihon.getTargettkhkkbn())
                                        || C_TargetTkMokuhyoutiKbn.BLNK.eq(mosKihon.getTargettkmkhtkbn())) {
                                        sisyaToukeiHokan.setSstmkhyoutiyensysnikoukbn("000");
                                    }
                                    else {
                                        sisyaToukeiHokan.setSstmkhyoutiyensysnikoukbn(mosKihon.getTargettkmkhtkbn().getValue());
                                    }
                                    sisyaToukeiHokan.setSstsyksbyensitihsyutkykhyj(sstSykSbYenSitiHsyuTkykHyj);
                                    sisyaToukeiHokan.setSstjyudkaigomehrtkarihyj(sstJyudKaigoMehrTkariHyj);

                                    if (BizNumber.valueOf(new BigDecimal(syokaiPhrkGksiteituuka.toString())).compareTo(BizNumber.valueOf(99999999999.99)) > 0){
                                        sisyaToukeiHokan.setSstfstphrkgksiteituuka(BizNumber.valueOf(99999999999.99));
                                    }
                                    else {
                                        sisyaToukeiHokan.setSstfstphrkgksiteituuka(BizNumber.valueOf(
                                            new BigDecimal(syokaiPhrkGksiteituuka.toString())));
                                    }

                                    if (C_TumitatekinHaibunWariKbn.BLNK.eq(mosKihon.getTeirituhaibunwarikbn())) {

                                        sisyaToukeiHokan.setSstteirituhaibunwari("000");
                                    }
                                    else {
                                        sisyaToukeiHokan.setSstteirituhaibunwari(mosKihon.getTeirituhaibunwarikbn().getValue());
                                    }

                                    sisyaToukeiHokan.setSstsueokikknkbn(ssTkSueokiKknkbn);

                                    sisyaToukeiHokan.setSstnksyuruikbn1(nenkinsyu);
                                    if (!BizUtil.isBlank(mosKihon.getAitemosno())) {
                                        sisyaToukeiHokan.setSstsetaitemosno(mosKihon.getAitemosno().substring(0, 9));
                                    }
                                    else {
                                        sisyaToukeiHokan.setSstsetaitemosno("000000000");
                                    }

                                    sisyaToukeiHokan.setSstyakkanjyuryouhoukbn(mosKihon.getYakkanjyuryouhoukbn().getValue());
                                    sisyaToukeiHokan.setSstyakkanbunsyono(mosKihon.getYakkanbunsyono());
                                    if (kouzaJyouhou != null){
                                        sisyaToukeiHokan.setSstkzhuritourokuhoukbn(kouzaJyouhou.getKzhuritourokuhoukbn().getValue());
                                    }
                                	else {
                                        sisyaToukeiHokan.setSstkzhuritourokuhoukbn("0");
                                    }
                                    sisyaToukeiHokan.setSstdai1hknkkn(Strings.padStart(
                                        String.valueOf(mosSyouhnTBL.getDai1hknkkn()), 2, '0'));
                                    if (C_Hrkkeiro.CREDIT.eq(mosKihon.getHrkkeiro())) {
                                        sisyaToukeiHokan.setSstcreditnyuuryokuymd(syoriCTL.getMosnrkymd().toString());
                                    }
                                    else {
                                        sisyaToukeiHokan.setSstcreditnyuuryokuymd("00000000");
                                    }
                                    sisyaToukeiHokan.setSstcreditmiryou(creditmiryou);
                                    if (C_Hrkkeiro.CREDIT.eq(mosKihon.getHrkkeiro())) {
                                        sisyaToukeiHokan.setSstcredittrkhoukbn(creditCardJyouhou.getCredittrkhoukbn().getValue());
                                    }
                                    else {
                                        sisyaToukeiHokan.setSstcredittrkhoukbn("0");
                                    }
                                    if (C_Hrkkeiro.CREDIT.eq(mosKihon.getHrkkeiro())) {
                                        sisyaToukeiHokan.setSstcardbrandkbn(creditCardJyouhou.getCardbrandkbn().getContent());
                                    }
                                    else {
                                        sisyaToukeiHokan.setSstcardbrandkbn("");
                                    }
                                    if (skUriageData != null) {
                                        sisyaToukeiHokan.setSstcarddatasousinymd(skUriageData.getCarddatasousinymd().toString());
                                    }
                                    else {
                                        sisyaToukeiHokan.setSstcarddatasousinymd("00000000");
                                    }
                                    sisyaToukeiHokan.setSstkzktrkservicekbn(kzktrkservicekbn);
                                    sisyaToukeiHokan.setSstkykdrtkykarihyj(sstKykdrtkykarihyj);
                                    sisyaToukeiHokan.setSstteikishrtkykarihyouji(sstteikishrtkykarihyouji);
                                    if (C_Tkhukaumu.HUKA.eq(mosKihon.getTeikisiharaitkykhkkbn()) &&
                                        uketoriKouzaJyouhou != null &&
                                        !C_KouzasyuruiKbn.BLNK.eq(uketoriKouzaJyouhou.getKzsyuruikbn())) {
                                        sisyaToukeiHokan.setSstteikishrkinshrtuukakbn(uketoriKouzaJyouhou.getKzsyuruikbn().getValue());
                                    }
                                    else {
                                        sisyaToukeiHokan.setSstteikishrkinshrtuukakbn("");
                                    }
                                    if (C_Tkhukaumu.HUKA.eq(mosKihon.getTeikisiharaitkykhkkbn())) {
                                        if (BizNumber.valueOf(new BigDecimal(mosSyouhnTBL.getTeikisiharaikin().toString())).compareTo(BizNumber.valueOf(99999999999.99)) > 0) {
                                            sisyaToukeiHokan.setSstteikisiharaikin(BizNumber.valueOf(99999999999.99));
                                        } else {
                                            sisyaToukeiHokan.setSstteikisiharaikin(BizNumber.valueOf(
                                                new BigDecimal(mosSyouhnTBL.getTeikisiharaikin().toString())));
                                        }
                                    }
                                    else {
                                        sisyaToukeiHokan.setSstteikisiharaikin(BizNumber.valueOf(0));
                                    }
                                    if (C_KoureiKzkSetumeiHouKbn.JOUKIHUKA.eq(mosKihon.getKoureikzksetumeihoukbn())) {
                                        sisyaToukeiHokan.setSstkoureikzksetumeihoukbn("4");
                                    }
                                    else {
                                        sisyaToukeiHokan.setSstkoureikzksetumeihoukbn(mosKihon.getKoureikzksetumeihoukbn().getValue());
                                    }
                                    sisyaToukeiHokan.setSstkoureimndnhukusuukaikbn(mosKihon.getKoureimndnhukusuukaikbn().getValue());
                                    sisyaToukeiHokan.setSstkoureitratkisyaigidskkbn(mosKihon.getKoureitratkisyaigidskkbn().getValue());
                                    sisyaToukeiHokan.setSsthknsyukigou(mosSyouhnTBL.getSyouhncd().substring(0, 2));

                                    sisyaToukeiHokan.setSstsaimnkkykhyj(sstsaimnkkykHyj);

                                    if (nnknsnpssySyup.toString().length() > 11) {
                                        sisyaToukeiHokan.setSstnnknsnpssysyup(99999999999l);
                                    }
                                    else {
                                        sisyaToukeiHokan.setSstnnknsnpssysyup(
                                            new BigDecimal(nnknsnpssySyup.toString()).longValue());
                                    }

                                    sisyaToukeiHokan.setSstnnknsnpssykwsrate(nknsnpssyKwsrate);

                                    if (zennouHokenryou.toString().length() > 11) {
                                        sisyaToukeiHokan.setSstzennoup(99999999999l);
                                    }
                                    else {
                                        sisyaToukeiHokan.setSstzennoup(
                                            new BigDecimal(zennouHokenryou.toString()).longValue());
                                    }

                                    sisyaToukeiHokan.setSstkzktuutityokusoukbn(kzkTuutiTyokusouKbn);

                                    if (C_Tkhukaumu.HUKA.eq(mosKihon.getKjnnkpzeitekitkhukakbn())) {

                                        sisyaToukeiHokan.setSstnenkinzeiseitokuyakukbn("2");
                                    }
                                    else {

                                        sisyaToukeiHokan.setSstnenkinzeiseitokuyakukbn("0");
                                    }

                                    if (!BizUtil.isBlank(sisyaToukeiHokan.getSstmosno())) {
                                        addHenkouSqlCountSstUpd(genInsertLst, sisyaToukeiHokanDeleteLst,
                                            sisyaToukeiHokanUpdateLst, sisyaToukeiHokan);
                                    }
                                    else {
                                        sisyaToukeiHokan.setSstmosno(syoriCTL.getMosno().substring(0, 9));
                                        sisyaToukeiHokan.setRenno(renNo);
                                        BizPropertyInitializer.initialize(sisyaToukeiHokan);
                                        addHenkouSqlCountSstIns(genInsertLst, sisyaToukeiHokanDeleteLst,
                                            sisyaToukeiHokanUpdateLst, sisyaToukeiHokan);
                                    }

                                    syoriKensuHokan = syoriKensuHokan + 1;

                                    if (C_UmuKbn.ARI.eq(dairtSyutrkF)) {
                                        ZT_DrtenIpToukeiTy drtenIpToukeiTy = new ZT_DrtenIpToukeiTy();

                                        drtenIpToukeiTy.setZtyeigyouhonbusisyacd(sisyaToukeiHokan.
                                            getSsteigyouhonbusisyacd());
                                        drtenIpToukeiTy.setZtysosikicd(sisyaToukeiHokan.getSstsosikicd());
                                        drtenIpToukeiTy.setZtyatukaikojincd(sisyaToukeiHokan.getSstatukaikojincd());
                                        drtenIpToukeiTy.setZtymosym(String.valueOf(moskmNrYM));
                                        drtenIpToukeiTy.setZtymoskbn(sisyaToukeiHokan.getSstmoskbn());
                                        drtenIpToukeiTy.setZtytansyukukjatukaisyanm(tensyukuKjAtkishaNm);
                                        drtenIpToukeiTy.setZtymosno(sisyaToukeiHokan.getSstmosno());
                                        drtenIpToukeiTy.setZtymossyoumetukbn(sisyaToukeiHokan.getSstmossyoumetukbn());
                                        drtenIpToukeiTy.setZtykurikosiriyuukbn(sisyaToukeiHokan.
                                            getSstkurikosiriyuukbn());
                                        drtenIpToukeiTy.setZtynyknzumihyouji(sisyaToukeiHokan.getSstnyknzumihyouji());
                                        drtenIpToukeiTy.setZtytoukeihknsyruikbn(sisyaToukeiHokan.
                                            getSsttoukeiyouhknsyuruikbn());
                                        drtenIpToukeiTy.setZtyhjykktkbn(sisyaToukeiHokan.getSsthoujyoukokutikbn());
                                        drtenIpToukeiTy.setZtykykktaikbn(sisyaToukeiHokan.getSstkykkeitaikbn());
                                        drtenIpToukeiTy.setZtyjyunhsys(sisyaToukeiHokan.getSstjyunhsys() / 1000);
                                        drtenIpToukeiTy.setZtyhsys(sisyaToukeiHokan.getSsthsys() / 1000);
                                        drtenIpToukeiTy.setZtysoukensuu(sisyaToukeiHokan.getSstsoukensuu());
                                        drtenIpToukeiTy.setZtyketjkkbn(sisyaToukeiHokan.getSstketteijkkbn());
                                        drtenIpToukeiTy.setZtydakuhiktjyoutaikbn(sisyaToukeiHokan.
                                            getSstdakuhiketteijyoutaikbn());
                                        drtenIpToukeiTy.setZtykihonhubi(sisyaToukeiHokan.getSstkihonhubi());
                                        drtenIpToukeiTy.setZtysphubi(sisyaToukeiHokan.getSstsphubi());
                                        drtenIpToukeiTy.setZtysseigenhubi(sisyaToukeiHokan.getSstsseigenhubi());
                                        drtenIpToukeiTy.setZtynayosehumei(sisyaToukeiHokan.getSstnayosehumei());
                                        drtenIpToukeiTy.setZtytuusangendoover(sisyaToukeiHokan.getSsttuusangendoover());
                                        drtenIpToukeiTy.setZtymosketteihoryuu(sisyaToukeiHokan.getSstmosketteihoryuu());
                                        drtenIpToukeiTy.setZtykykkakjissityuu(sisyaToukeiHokan.
                                            getSstkykkakuninjissityuu());
                                        drtenIpToukeiTy.setZtykktketteihoryuu(sisyaToukeiHokan.
                                            getSstkokutiketteihoryuu());
                                        drtenIpToukeiTy.setZtyhonsyakethoryuu(sisyaToukeiHokan.
                                            getSsthonsyaketteihoryuu());
                                        drtenIpToukeiTy.setZtyseiymdhubi(sisyaToukeiHokan.getSstseiymdhubi());
                                        drtenIpToukeiTy.setZtyphusoku(sisyaToukeiHokan.getSstphusoku());
                                        drtenIpToukeiTy.setZtysrhuketyu(sisyaToukeiHokan.
                                            getSstseirituhoryuuuketuketyuu());
                                        drtenIpToukeiTy.setZtypkakin(sisyaToukeiHokan.getSstpkakin());
                                        drtenIpToukeiTy.setZtybsudirtnatkikeitaikbn(sisyaToukeiHokan.
                                            getSstbosyuudrtenatkikeitaikbn());
                                        drtenIpToukeiTy.setZtysakuseiymd(syoriYmd.toString());
                                        drtenIpToukeiTy.setZtykydatkikbn(drtenIpToukeikydatki);
                                        drtenIpToukeiTy.setZtytansyukukjhhknnm(sisyaToukeiHokan.
                                            getSsttansyukukjhhknnm());
                                        drtenIpToukeiTy.setZtyhhknsykgycd(sisyaToukeiHokan.getSsthhknsyokugyoucd());
                                        drtenIpToukeiTy.setZtyhhknnen2keta(sisyaToukeiHokan.getSsthhknnen2keta());
                                        drtenIpToukeiTy.setZtyhhknseikbn(sisyaToukeiHokan.getSsthhknseikbn());
                                        drtenIpToukeiTy.setZtymusymd(sisyaToukeiHokan.getSstmosymd());
                                        drtenIpToukeiTy.setZtysyokaipryosyuymd(
                                            sisyaToukeiHokan.getSstfstpryousyuuymd());
                                        drtenIpToukeiTy.setZtykokutiymd(sisyaToukeiHokan.getSstkokutiymd());
                                        drtenIpToukeiTy.setZtymosnyuuryokuymd(sisyaToukeiHokan.getSstmosnyuuryokuymd());
                                        drtenIpToukeiTy.setZtykykymd(sisyaToukeiHokan.getSstkykymd());
                                        drtenIpToukeiTy.setZtysekininkaisiymd(sisyaToukeiHokan.getSstsekininkaisiymd());
                                        drtenIpToukeiTy.setZtyfstpnyknsyoriymd(sisyaToukeiHokan.
                                            getSstfstpnyknsyoriymd());
                                        drtenIpToukeiTy.setZtyfstpnyknnaiyoukbn(sisyaToukeiHokan.
                                            getSstfstpnyknnaiyoukbn());
                                        drtenIpToukeiTy.setZtysisyaketsyoriymd(
                                            sisyaToukeiHokan.getSstsisyaketteisyoriymd());
                                        drtenIpToukeiTy.setZtysyosakuseiymd(sisyaToukeiHokan.getSstsyoukensakuseiymd());
                                        drtenIpToukeiTy.setZtyseisekiym(sisyaToukeiHokan.getSstseisekikijyym());
                                        drtenIpToukeiTy.setZtysyokaiharaikomip(sisyaToukeiHokan.getSstfstphrkgkyen());
                                        drtenIpToukeiTy.setZtysyono(sisyaToukeiHokan.getSstsyono());
                                        drtenIpToukeiTy.setZtytokusyujimutoriatukaikbn(sisyaToukeiHokan.
                                            getSsttokusyujimutoriatukaikbn());
                                        drtenIpToukeiTy.setZtybsydrtencd(kesyoSakiKryoDrtenCd);
                                        drtenIpToukeiTy.setZtybsydrtenkjnm(kesyoSakiKryoKjDrtenNm);
                                        drtenIpToukeiTy.setZtyatkisyagyskkjsosikicd(sisyaToukeiHokan.
                                            getSstatkisyagyskkjsosikicd());
                                        drtenIpToukeiTy.setZtyatkisyadrtenatkiwari(sisyaToukeiHokan.
                                            getSstatkisyadrtenatkiwari());
                                        drtenIpToukeiTy.setZtyhknkkn(sisyaToukeiHokan.getSsthknkkn());
                                        drtenIpToukeiTy.setZtyphrkkikn(sisyaToukeiHokan.getSstphrkkikn());
                                        drtenIpToukeiTy.setZtyhrkkaisuukbn(sisyaToukeiHokan.getSsthrkkaisuukbn());
                                        drtenIpToukeiTy.setZtyhrkkeirokbn(sisyaToukeiHokan.getSsthrkkeirokbn());
                                        if (C_DrtenChannelSyurui.GINHONTAIMADO.eq(kesyoSakiKryoDrtenChannelSyurui)) {
                                            drtenIpToukeiTy.setZtykinyuukikancd(kesyoSakiKryoKinuSakanCd);
                                            if (kesyoSakiKryoKinyuuSitenCd.length() > 3) {
                                                drtenIpToukeiTy.setZtyinfositencd(kesyoSakiKryoKinyuuSitenCd.substring(1, 4));
                                            }
                                            else {
                                                drtenIpToukeiTy.setZtyinfositencd(kesyoSakiKryoKinyuuSitenCd);
                                            }
                                        }
                                        else {
                                            drtenIpToukeiTy.setZtykinyuukikancd("0000");
                                            drtenIpToukeiTy.setZtyinfositencd("");
                                        }
                                        drtenIpToukeiTy.setZtycifcd(sisyaToukeiHokan.getSstcifcd());
                                        drtenIpToukeiTy.setZtykjkyknm10(sisyaToukeiHokan.getSstkjkyknm10());
                                        drtenIpToukeiTy.setZtykthhbhyouji(sisyaToukeiHokan.
                                            getSstketteihoryuuhubihyouji());
                                        drtenIpToukeiTy.setZtysrhhbhyouji(sisyaToukeiHokan.
                                            getSstseirituhoryuuhubihyouji());
                                        drtenIpToukeiTy.setZtymossyumtkktymd(
                                            sisyaToukeiHokan.getSstmossyoumetukakuteiymd());
                                        drtenIpToukeiTy.setZtydairitenjimusyocd(kesyoSakiKryoDrtenJimSyoCd);
                                        drtenIpToukeiTy.setZtytsrybnwari(sisyaToukeiHokan.getSsttsrybnwari());
                                        drtenIpToukeiTy.setZtydrtenkeijyouym(sisyaToukeiHokan.getSstdrtenkeijyouym());
                                        drtenIpToukeiTy.setZtykydatkidairitencd(sisyaToukeiHokan
                                            .getSstkydatkidairitencd());
                                        drtenIpToukeiTy.setZtydaihyoubosyuunincd(sisyaToukeiHokan
                                            .getSstdaihyoubosyuunincd());
                                        drtenIpToukeiTy.setZtytansyukukjdhybosyuunm(tansyukuKjBosyuuNm);
                                        drtenIpToukeiTy.setZtyknkyknm15(sisyaToukeiHokan.getSstknkyknm15());
                                        drtenIpToukeiTy.setZtydakuhikettikekkacd(sisyaToukeiHokan.
                                            getSstdakuhiketteikekkacd());
                                        drtenIpToukeiTy.setZtydkhktiymd(sisyaToukeiHokan.getSstdakuhiketteiymd());
                                        drtenIpToukeiTy.setZtytoukeiyousinsakbn(sisyaToukeiHokan.
                                            getSsttoukeiyousinsakbn());
                                        drtenIpToukeiTy.setZtyhonninkknnkbn(sisyaToukeiHokan.getSsthonninkakuninkbn());
                                        drtenIpToukeiTy.setZtynstkarihyj(sisyaToukeiHokan.getSstnkshrtkykarihyouji());
                                        drtenIpToukeiTy.setZtynstknkkkn(sisyaToukeiHokan.getSstnkshrtkyknkkkn());
                                        drtenIpToukeiTy.setZtydrtentsryhushrkykhyouji(sisyaToukeiHokan.
                                            getSstdrtentsryhushrkykhyouji());
                                        drtenIpToukeiTy.setZtynyknkanskanouhyouji(sisyaToukeiHokan.
                                            getSstnyknkanskanouhyouji());
                                        drtenIpToukeiTy.setZtydshukahyouji(sisyaToukeiHokan.getSstdshukahyouji());
                                        drtenIpToukeiTy.setZtystdairiseikyuutkykarihyj(sisyaToukeiHokan.
                                            getSstsiteidairisktkykarihyouj());
                                        drtenIpToukeiTy.setZtykyksyanen(sisyaToukeiHokan.getSstkyksyanen());
                                        drtenIpToukeiTy.setZtykyksyaseikbn(sisyaToukeiHokan.getSstkyksyaseikbn());
                                        drtenIpToukeiTy.setZtyhhknseiymd(sisyaToukeiHokan.getSsthhknseiymd());
                                        drtenIpToukeiTy.setZtydrtenpaperlessmoshyj(sisyaToukeiHokan.getSstdrtenpaperlessmoshyj());
                                        drtenIpToukeiTy.setZtydrtenmostousyaukeymd(sisyaToukeiHokan.getSstdrtenmostousyaukeymd());
                                        drtenIpToukeiTy.setZtykyktuuka(sisyaToukeiHokan.getSstkyktuuka());
                                        drtenIpToukeiTy.setZtyhrktuuka(sisyaToukeiHokan.getSsthrktuuka());
                                        drtenIpToukeiTy.setZtysykihrkpgaika(sisyaToukeiHokan.getSstfstphrkgkgaika());
                                        drtenIpToukeiTy.setZtyyennykntkarihyouji(sisyaToukeiHokan.
                                            getSstyennykntkykarihyouji());
                                        drtenIpToukeiTy.setZtygaikanykntkarihyouji(sisyaToukeiHokan.
                                            getSstgaikanykntkykarihyouji());
                                        drtenIpToukeiTy.setZtykihonsgaika(sisyaToukeiHokan.getSstkihonsgaika());
                                        drtenIpToukeiTy.setZtytekiyoukawaserate(sisyaToukeiHokan.
                                            getSsttekiyoukawaserate());
                                        drtenIpToukeiTy.setZtykawaseratetekiyouymd(sisyaToukeiHokan.
                                            getSstkawaseratetekiyouymd());
                                        drtenIpToukeiTy.setZtymkhyoutiyensysnikoukbn(sisyaToukeiHokan.getSstmkhyoutiyensysnikoukbn());
                                        drtenIpToukeiTy.setZtysyksbyensitihsyutkykhyj(sisyaToukeiHokan.getSstsyksbyensitihsyutkykhyj());
                                        drtenIpToukeiTy.setZtyjyudkaigomehrtkarihyj(sisyaToukeiHokan.getSstjyudkaigomehrtkarihyj());
                                        drtenIpToukeiTy.setZtysykihrkpsiteituuka(sisyaToukeiHokan.getSstfstphrkgksiteituuka());
                                        drtenIpToukeiTy.setZtyteirituhaibunwari(sisyaToukeiHokan.getSstteirituhaibunwari());
                                        drtenIpToukeiTy.setZtysueokikknkbn(sisyaToukeiHokan.getSstsueokikknkbn());
                                        drtenIpToukeiTy.setZtynksyuruikbn1(sisyaToukeiHokan.getSstnksyuruikbn1());
                                        drtenIpToukeiTy.setZtydairitenkbtinfo1(sisyaToukeiHokan.getSstbosyuudrtenkobetuinfo1());
                                        drtenIpToukeiTy.setZtydairitenkbtinfo2(sisyaToukeiHokan.getSstbosyuudrtenkobetuinfo2());
                                        drtenIpToukeiTy.setZtydairitenkbtinfo3(sisyaToukeiHokan.getSstbosyuudrtenkobetuinfo3());
                                        drtenIpToukeiTy.setZtyyohurimiryou(sisyaToukeiHokan.getSstyohurimiryou());
                                        drtenIpToukeiTy.setZtykznyuuryokuymd(sisyaToukeiHokan.getSstkouzanyuuryokuymd());
                                        drtenIpToukeiTy.setZtysetaitemosno(sisyaToukeiHokan.getSstsetaitemosno());
                                        drtenIpToukeiTy.setZtyyakkanjyuryouhoukbn(sisyaToukeiHokan.getSstyakkanjyuryouhoukbn());
                                        drtenIpToukeiTy.setZtyyakkanbunsyono(sisyaToukeiHokan.getSstyakkanbunsyono());
                                        drtenIpToukeiTy.setZtykzhuritourokuhoukbn(sisyaToukeiHokan.getSstkzhuritourokuhoukbn());
                                        drtenIpToukeiTy.setZtydai1hknkkn(sisyaToukeiHokan.getSstdai1hknkkn());
                                        drtenIpToukeiTy.setZtycreditnyuuryokuymd(sisyaToukeiHokan.getSstcreditnyuuryokuymd());
                                        drtenIpToukeiTy.setZtycreditmiryou(sisyaToukeiHokan.getSstcreditmiryou());
                                        drtenIpToukeiTy.setZtycredittrkhoukbn(sisyaToukeiHokan.getSstcredittrkhoukbn());
                                        drtenIpToukeiTy.setZtycardbrandkbn(sisyaToukeiHokan.getSstcardbrandkbn());
                                        drtenIpToukeiTy.setZtycarddatasousinymd(sisyaToukeiHokan.getSstcarddatasousinymd());
                                        drtenIpToukeiTy.setZtykykdrtkykarihyj(sisyaToukeiHokan.getSstkykdrtkykarihyj());
                                        drtenIpToukeiTy.setZtykzktrkservicekbn(sisyaToukeiHokan.getSstkzktrkservicekbn());
                                        drtenIpToukeiTy.setZtyteikisiharaiarihyj(sisyaToukeiHokan.getSstteikishrtkykarihyouji());
                                        drtenIpToukeiTy.setZtyteikishrkinshrtuukakbn(sisyaToukeiHokan.getSstteikishrkinshrtuukakbn());
                                        drtenIpToukeiTy.setZtyteikisiharaikin(sisyaToukeiHokan.getSstteikisiharaikin());
                                        drtenIpToukeiTy.setZtykoureikzksetumeihoukbn(sisyaToukeiHokan.getSstkoureikzksetumeihoukbn());
                                        drtenIpToukeiTy.setZtykoureimndnhukusuukaikbn(sisyaToukeiHokan.getSstkoureimndnhukusuukaikbn());
                                        drtenIpToukeiTy.setZtykoureitratkisyaigidskkbn(sisyaToukeiHokan.getSstkoureitratkisyaigidskkbn());
                                        drtenIpToukeiTy.setZtyhknsyukigou(sisyaToukeiHokan.getSsthknsyukigou());
                                        drtenIpToukeiTy.setZtysaimnkkykhyj(sisyaToukeiHokan.getSstsaimnkkykhyj());
                                        drtenIpToukeiTy.setZtynnknsnpssysyup(sisyaToukeiHokan.getSstnnknsnpssysyup());
                                        drtenIpToukeiTy.setZtynnknsnpssykwsrate(sisyaToukeiHokan.getSstnnknsnpssykwsrate());
                                        drtenIpToukeiTy.setZtyzennoup(sisyaToukeiHokan.getSstzennoup());
                                        drtenIpToukeiTy.setZtynenkinzeiseitokuyakukbn(sisyaToukeiHokan.getSstnenkinzeiseitokuyakukbn());

                                        BizPropertyInitializer.initialize(drtenIpToukeiTy);
                                        addHenkouSqlCountDrtenIns(genInsertLst, sisyaToukeiHokanDeleteLst,
                                            sisyaToukeiHokanUpdateLst, drtenIpToukeiTy);

                                        syoriKensuDrten++;
                                    }

                                    if (C_UmuKbn.ARI.eq(seirtSyutrkF)) {
                                        ZT_SkSeirituRituTy skSeirituRituTy = new ZT_SkSeirituRituTy();

                                        skSeirituRituTy.setZtyeigyouhonbusisyacd(eigyouHonbuSisyaCd_Daikei);
                                        skSeirituRituTy.setZtysisyanm(egyoHobuShsyamei);
                                        skSeirituRituTy.setZtysosikicd(eigyouHonbuSisyaCd_Daikei);
                                        skSeirituRituTy.setZtykanjisosikinm20(dairtenKanriSoshikikimei);
                                        skSeirituRituTy.setZtyatukaisyadrtenhyouji(sisyaToukeiHokan.
                                            getSstatukaisyadrtenhyouji());
                                        skSeirituRituTy.setZtyatukaikojincd(sisyaToukeiHokan.getSstatukaikojincd());
                                        skSeirituRituTy.setZtytansyukukjatukaisyanm(tensyukuKjAtkishaNm);
                                        skSeirituRituTy.setZtymosno(sisyaToukeiHokan.getSstmosno());
                                        skSeirituRituTy.setZtyknjhhknmei(sisyaToukeiHokan.getSstkanjihihokensyanm());
                                        skSeirituRituTy.setZtyhhknnen2keta(sisyaToukeiHokan.getSsthhknnen2keta());
                                        skSeirituRituTy.setZtykyksyanen(sisyaToukeiHokan.getSstkyksyanen());
                                        skSeirituRituTy.setZtymosym(String.valueOf(moskmNrYM));
                                        skSeirituRituTy.setZtymosnyuuryokuymd(sisyaToukeiHokan.getSstmosnyuuryokuymd());
                                        skSeirituRituTy.setZtymoskbn(sisyaToukeiHokan.getSstmoskbn());
                                        skSeirituRituTy.setZtymossyoumetukbn(sisyaToukeiHokan.getSstmossyoumetukbn());
                                        skSeirituRituTy.setZtymossyumtkktymd(
                                            sisyaToukeiHokan.getSstmossyoumetukakuteiymd());
                                        skSeirituRituTy.setZtykurikosiriyuukbn(sisyaToukeiHokan.
                                            getSstkurikosiriyuukbn());
                                        skSeirituRituTy.setZtynyknzumihyouji(sisyaToukeiHokan.getSstnyknzumihyouji());
                                        skSeirituRituTy.setZtynyknjkkbn(sisyaToukeiHokan.getSstnyknjkkbn());
                                        skSeirituRituTy.setZtyketjkkbn(sisyaToukeiHokan.getSstketteijkkbn());
                                        skSeirituRituTy.setZtydakuhiktjyoutaikbn(sisyaToukeiHokan.
                                            getSstdakuhiketteijyoutaikbn());
                                        skSeirituRituTy.setZtykokutiymd(sisyaToukeiHokan.getSstkokutiymd());
                                        skSeirituRituTy.setZtyhjykktkbn(sisyaToukeiHokan.getSsthoujyoukokutikbn());
                                        skSeirituRituTy.setZtytokuteikanikokutikbn(sisyaToukeiHokan.
                                            getSsttokuteikanikokutikbn());
                                        skSeirituRituTy.setZtydakuhikettikekkacd(sisyaToukeiHokan.
                                            getSstdakuhiketteikekkacd());
                                        skSeirituRituTy.setZtysinhsys(sisyaToukeiHokan.getSstsinhsys());
                                        skSeirituRituTy.setZtyjyunhsys(sisyaToukeiHokan.getSstjyunhsys());
                                        skSeirituRituTy.setZtyhsys(sisyaToukeiHokan.getSsthsys());
                                        skSeirituRituTy.setZtysoukensuu(sisyaToukeiHokan.getSstsoukensuu());
                                        skSeirituRituTy.setZtytoukeihknsyruikbn(sisyaToukeiHokan.
                                            getSsttoukeiyouhknsyuruikbn());
                                        skSeirituRituTy.setZtyhrkkaisuukbn(sisyaToukeiHokan.getSsthrkkaisuukbn());
                                        skSeirituRituTy.setZtyhrkkeirokbn(sisyaToukeiHokan.getSsthrkkeirokbn());
                                        skSeirituRituTy.setZtykykktaikbn(sisyaToukeiHokan.getSstkykkeitaikbn());
                                        skSeirituRituTy.setZtybsudirtnatkikeitaikbn(sisyaToukeiHokan.
                                            getSstbosyuudrtenatkikeitaikbn());
                                        skSeirituRituTy.setZtytokusyujimutoriatukaikbn(sisyaToukeiHokan.
                                            getSsttokusyujimutoriatukaikbn());
                                        skSeirituRituTy.setZtykihonhubi(sisyaToukeiHokan.getSstkihonhubi());
                                        skSeirituRituTy.setZtysphubi(sisyaToukeiHokan.getSstsphubi());
                                        skSeirituRituTy.setZtysseigenhubi(sisyaToukeiHokan.getSstsseigenhubi());
                                        skSeirituRituTy.setZtynayosehumei(sisyaToukeiHokan.getSstnayosehumei());
                                        skSeirituRituTy.setZtytuusangendoover(sisyaToukeiHokan.getSsttuusangendoover());
                                        skSeirituRituTy.setZtymosketteihoryuu(sisyaToukeiHokan.getSstmosketteihoryuu());
                                        skSeirituRituTy.setZtykykkakjissityuu(sisyaToukeiHokan.
                                            getSstkykkakuninjissityuu());
                                        skSeirituRituTy.setZtykktketteihoryuu(sisyaToukeiHokan.
                                            getSstkokutiketteihoryuu());
                                        skSeirituRituTy.setZtyhonsyakethoryuu(sisyaToukeiHokan.
                                            getSsthonsyaketteihoryuu());
                                        skSeirituRituTy.setZtyseiymdhubi(sisyaToukeiHokan.getSstseiymdhubi());
                                        skSeirituRituTy.setZtyphusoku(sisyaToukeiHokan.getSstphusoku());
                                        skSeirituRituTy.setZtysrhuketyu(sisyaToukeiHokan
                                            .getSstseirituhoryuuuketuketyuu());
                                        skSeirituRituTy.setZtypkakin(sisyaToukeiHokan.getSstpkakin());
                                        skSeirituRituTy.setZtymostoutyakuymd(sisyaToukeiHokan.getSstmostoutyakuymd());
                                        skSeirituRituTy.setZtykkttoutyakuymd(sisyaToukeiHokan.getSstkkttoutyakuymd());
                                        skSeirituRituTy.setZtysakuseiymd(syoriYmd.toString());
                                        skSeirituRituTy.setZtysyokaipnyuknhuhukbn2(sisyaToukeiHokan.
                                            getSstfstpnyknhouhoukbn2());
                                        skSeirituRituTy.setZtysyokaiharaikomip(sisyaToukeiHokan.
                                            getSstfstpsshkhrkgkyen());
                                        skSeirituRituTy.setZtyryousyuuymd(sisyaToukeiHokan.getSstryousyuuymd());
                                        skSeirituRituTy.setZtykeiyakukakuninsyuruikbn(sisyaToukeiHokan.
                                            getSstkykkakuninsyuruikbn());
                                        skSeirituRituTy.setZtykykkakjkkbn1(sisyaToukeiHokan.getSstkykkakuninjkkbn1());
                                        skSeirituRituTy.setZtymusymd(sisyaToukeiHokan.getSstmosymd());
                                        skSeirituRituTy.setZtymossyosakuseiymd(sisyaToukeiHokan.getSstmossakuseiymd());
                                        skSeirituRituTy.setZtysyosakuseiymd(sisyaToukeiHokan.getSstsyoukensakuseiymd());
                                        skSeirituRituTy.setZtykjkyknm(sisyaToukeiHokan.getSstkjkyknm());
                                        skSeirituRituTy.setZtyknkyknm18(sisyaToukeiHokan.getSstknkyknm18());
                                        skSeirituRituTy.setZtyseirituyoukihontikucd(sisyaToukeiHokan.
                                            getSstseirituyoukihontikucd());
                                        skSeirituRituTy.setZtymosksnym(sisyaToukeiHokan.getSstmosksnym());
                                        skSeirituRituTy.setZtyyohurimiryou(sisyaToukeiHokan.getSstyohurimiryou());
                                        skSeirituRituTy.setZtycreditmiryou(sisyaToukeiHokan.getSstcreditmiryou());
                                        skSeirituRituTy.setZtykzktrkservicekbn(sisyaToukeiHokan.getSstkzktrkservicekbn());
                                        skSeirituRituTy.setZtykykdrtkykarihyj(sisyaToukeiHokan.getSstkykdrtkykarihyj());
                                        skSeirituRituTy.setZtystdairiseikyuutkykarihyj(sisyaToukeiHokan.getSstsiteidairisktkykarihyouj());
                                        skSeirituRituTy.setZtyyakkanjyuryouhoukbn(sisyaToukeiHokan.getSstyakkanjyuryouhoukbn());
                                        skSeirituRituTy.setZtyyakkanbunsyono(sisyaToukeiHokan.getSstyakkanbunsyono());
                                        skSeirituRituTy.setZtykzktuutityokusoukbn(sisyaToukeiHokan.getSstkzktuutityokusoukbn());

                                        BizPropertyInitializer.initialize(skSeirituRituTy);
                                        addHenkouSqlCountSkseiIns(genInsertLst, sisyaToukeiHokanDeleteLst,
                                            sisyaToukeiHokanUpdateLst, skSeirituRituTy);

                                        syoriKensuSeirtu++;
                                    }

                                    if (C_UmuKbn.ARI.eq(mosjkSyutrkF)
                                        && !BizUtil.isBlank(sisyaToukeiHokan.getTratkiagcd())
                                        && !sisyaToukeiHokan.getSstatukaikojincd().equals("000000")) {

                                        ZT_MosJkItiranSyoukaiTy mosJkItiranSyoukaiTy = new ZT_MosJkItiranSyoukaiTy();

                                        mosJkItiranSyoukaiTy.setZtymosym(getZtymosym(syoriCTL,mosKihon.getMosymd().toString()));
                                        mosJkItiranSyoukaiTy.setZtymoskbn(sisyaToukeiHokan.getSstmoskbn());
                                        mosJkItiranSyoukaiTy.setZtymosno(sisyaToukeiHokan.getSstmosno());
                                        mosJkItiranSyoukaiTy.setZtyhknsyuruinm(sisyaToukeiHokan.getSsthknsyuruinm());
                                        mosJkItiranSyoukaiTy.setZtykykymd(sisyaToukeiHokan.getSstkykymd());
                                        mosJkItiranSyoukaiTy.setZtymusymd(sisyaToukeiHokan.getSstmosymd());
                                        mosJkItiranSyoukaiTy.setZtymosnyuuryokuymd(
                                            sisyaToukeiHokan.getSstmosnyuuryokuymd());
                                        mosJkItiranSyoukaiTy.setZtykydatkikbn(sisyaToukeiHokan.getSstkydatkikbn());
                                        mosJkItiranSyoukaiTy.setZtybsudirtnatkikeitaikbn(sisyaToukeiHokan.
                                            getSstbosyuudrtenatkikeitaikbn());
                                        mosJkItiranSyoukaiTy.setZtybsydrtencd(kesyoSakiKryoDrtenCd);
                                        mosJkItiranSyoukaiTy.setZtybsydrtenkjnm(kesyoSakiKryoKjDrtenNm);
                                        mosJkItiranSyoukaiTy.setZtyatukaikojincd(
                                            sisyaToukeiHokan.getSstatukaikojincd());
                                        mosJkItiranSyoukaiTy.setZtytansyukukjatukaisyanm(tensyukuKjAtkishaNm);
                                        mosJkItiranSyoukaiTy.setZtycifcd(sisyaToukeiHokan.getSstcifcd());
                                        mosJkItiranSyoukaiTy.setZtykjkyknm10(sisyaToukeiHokan.getSstkjkyknm10());
                                        mosJkItiranSyoukaiTy.setZtytansyukukjhhknnm(sisyaToukeiHokan.
                                            getSsttansyukukjhhknnm());
                                        mosJkItiranSyoukaiTy.setZtyhhknnen2keta(sisyaToukeiHokan.getSsthhknnen2keta());
                                        mosJkItiranSyoukaiTy.setZtyhhknseikbn(sisyaToukeiHokan.getSsthhknseikbn());
                                        mosJkItiranSyoukaiTy.setZtymossyoumetukbn(sisyaToukeiHokan.
                                            getSstmossyoumetukbn());
                                        mosJkItiranSyoukaiTy.setZtykurikosiriyuukbn(sisyaToukeiHokan.
                                            getSstkurikosiriyuukbn());
                                        mosJkItiranSyoukaiTy.setZtyketjkkbn(sisyaToukeiHokan.getSstketteijkkbn());
                                        mosJkItiranSyoukaiTy.setZtydakuhiktjyoutaikbn(sisyaToukeiHokan.
                                            getSstdakuhiketteijyoutaikbn());
                                        mosJkItiranSyoukaiTy.setZtymosketkekkakbn(sisyaToukeiHokan.
                                            getSstmosketteikekkakbn());
                                        mosJkItiranSyoukaiTy.setZtykihonhubi(sisyaToukeiHokan.getSstkihonhubi());
                                        mosJkItiranSyoukaiTy.setZtykthhbhyouji(sisyaToukeiHokan.
                                            getSstketteihoryuuhubihyouji());
                                        mosJkItiranSyoukaiTy.setZtysrhhbhyouji(sisyaToukeiHokan.
                                            getSstseirituhoryuuhubihyouji());
                                        mosJkItiranSyoukaiTy.setZtynyknzumihyouji(sisyaToukeiHokan.
                                            getSstnyknzumihyouji());
                                        mosJkItiranSyoukaiTy.setZtysinsazumihyouji(
                                            sisyaToukeiHokan.getSstsinsazumihyouji());
                                        mosJkItiranSyoukaiTy.setZtytuukatanikbn(sisyaToukeiHokan.getSsttuukatanikbn());
                                        mosJkItiranSyoukaiTy.setZtysyokaihrkpmoji(sisyaToukeiHokan.
                                            getSstfstphrkgkhrktuukamoji());
                                        mosJkItiranSyoukaiTy.setZtyhjykktkbn(sisyaToukeiHokan.getSsthoujyoukokutikbn());
                                        mosJkItiranSyoukaiTy.setZtysyokaipryosyuymd(sisyaToukeiHokan.
                                            getSstfstpryousyuuymd());
                                        mosJkItiranSyoukaiTy.setZtykokutiymd(sisyaToukeiHokan.getSstkokutiymd());
                                        mosJkItiranSyoukaiTy.setZtykariseirituymd(sisyaToukeiHokan.
                                            getSstkariseirituymd());
                                        mosJkItiranSyoukaiTy.setZtyfstpnyknnaiyoukbn(sisyaToukeiHokan.
                                            getSstfstpnyknnaiyoukbn());
                                        mosJkItiranSyoukaiTy.setZtyhknkkn(sisyaToukeiHokan.getSsthknkkn());
                                        mosJkItiranSyoukaiTy.setZtyphrkkikn(sisyaToukeiHokan.getSstphrkkikn());
                                        mosJkItiranSyoukaiTy.setZtyhrkkaisuukbn(sisyaToukeiHokan.getSsthrkkaisuukbn());
                                        if (BizUtil.isBlank(sisyaToukeiHokan.getSsthrkkeirokbn())) {
                                            mosJkItiranSyoukaiTy.setZtyhrkkeirokbn("0");
                                        } else {
                                            mosJkItiranSyoukaiTy.setZtyhrkkeirokbn(sisyaToukeiHokan.getSsthrkkeirokbn());
                                        }
                                        mosJkItiranSyoukaiTy.setZtysakuseiymd(sisyaToukeiHokan.getSstsakuseiymd());
                                        mosJkItiranSyoukaiTy.setZtyanniskcd(sisyaToukeiHokan.getSstannaisakicd());
                                        mosJkItiranSyoukaiTy.setZtysyosakuseiymd(
                                            sisyaToukeiHokan.getSstsyoukensakuseiymd());
                                        mosJkItiranSyoukaiTy.setZtybsydrtenkobetuinfo1("");
                                        mosJkItiranSyoukaiTy.setZtybsydrtenkobetuinfo2(sisyaToukeiHokan.
                                            getSstbosyuudrtenkobetuinfo2());
                                        mosJkItiranSyoukaiTy.setZtybsydrtenkobetuinfo3(sisyaToukeiHokan.
                                            getSstbosyuudrtenkobetuinfo3());
                                        mosJkItiranSyoukaiTy.setZtybsydrtenkobetuinfo4(kouinnCd);
                                        mosJkItiranSyoukaiTy.setZtybsydrtenkobetuinfo5(sisyaToukeiHokan.
                                            getSstbosyuudrtenkobetuinfo5());
                                        mosJkItiranSyoukaiTy.setZtybankkouincd(sisyaToukeiHokan.getSstbankkouincd());
                                        mosJkItiranSyoukaiTy.setZtybosyuutourokuno(bosyuuTrkNo);
                                        mosJkItiranSyoukaiTy.setZtymosjkkbn(sisyaToukeiHokan.getSstmosjkkbn());
                                        mosJkItiranSyoukaiTy.setZtykousinymd(sisyaToukeiHokan.getSstkousinymd());
                                        mosJkItiranSyoukaiTy.setZtysinsayoteiymd(
                                            sisyaToukeiHokan.getSstsinsayoteiymd());
                                        mosJkItiranSyoukaiTy.setZtyhjnkykhyj(sisyaToukeiHokan.getSsthjnkykhyj());
                                        mosJkItiranSyoukaiTy.setZtykjhjnnm(sisyaToukeiHokan.getSstkjhjnnm());

                                        BizPropertyInitializer.initialize(mosJkItiranSyoukaiTy);
                                        addHenkouSqlCountMosjkIns(genInsertLst, sisyaToukeiHokanDeleteLst,
                                            sisyaToukeiHokanUpdateLst, mosJkItiranSyoukaiTy);

                                        syoriKensuMoskms++;

                                    }
                                    renNo = renNo + 1;
                                }

                                if (mosDairitenLst.size() == 1 && sisyaToukeiHokanLst.size() == 2) {
                                    addHenkouSqlCountSstDel(genInsertLst, sisyaToukeiHokanDeleteLst,
                                        sisyaToukeiHokanUpdateLst, sisyaToukeiHokanLst.get(idxSstLst.get(1)));
                                }
                            }
                        }
                    }
                }
                for (ZT_DrtenIpToukeiTy tmpDrt : drtenTyTmpLst) {
                    genInsertLst.add(tmpDrt);
                }
                for (ZT_SkSeirituRituTy tmpSei : skseiTyTmpLst) {
                    genInsertLst.add(tmpSei);
                }
                for (ZT_MosJkItiranSyoukaiTy tmpMos : mosjkTyTmpLst) {
                    genInsertLst.add(tmpMos);
                }
                for (HT_SisyaToukeiHokan tmpSst : sstDelTmpLst) {
                    sisyaToukeiHokanDeleteLst.add(tmpSst);
                }
                for (HT_SisyaToukeiHokan tmpSst : sstInsTmpLst) {
                    genInsertLst.add(tmpSst);
                }
                for (HT_SisyaToukeiHokan tmpSst : sstUpdTmpLst) {
                    sisyaToukeiHokanUpdateLst.add(tmpSst);
                }
            }

            bzRecoveryDatasikibetuBean.initializeBlank();

            batchLogger.info(MessageUtil.getMessage(MessageId.IBF0002, String.valueOf(syoriKensuDrten),
                "代理店用ＩＰ統計用Ｆテーブル（中）"));
            batchLogger.info(
                MessageUtil.getMessage(MessageId.IBF0002, String.valueOf(syoriKensuSeirtu),
                    "新契約成立率Ｆテーブル（中）"));
            batchLogger.info(MessageUtil.getMessage(MessageId.IBF0002, String.valueOf(syoriKensuMoskms),
                "申込状況一覧照会用Ｆテーブル（中）"));
            batchLogger.info(
                MessageUtil.getMessage(MessageId.IBF0002, String.valueOf(syoriKensuHokan), "支社統計保管テーブル"));

        }
    }

    private void addHenkouSqlCountDrtenIns(MultipleEntityInserter pGenIns,
        EntityDeleter<HT_SisyaToukeiHokan>          pSstDel,
        EntityUpdater<HT_SisyaToukeiHokan>          pSstUpd,
        ZT_DrtenIpToukeiTy     pEntity) {
        boolean isFlush = addHenkouSqlCount(pGenIns, pSstDel, pSstUpd);
        if (isFlush) {
            pGenIns.add(pEntity);
        }
        else {
            drtenTyTmpLst.add(pEntity);
        }
    }
    private void addHenkouSqlCountSkseiIns(MultipleEntityInserter pGenIns,
        EntityDeleter<HT_SisyaToukeiHokan>          pSstDel,
        EntityUpdater<HT_SisyaToukeiHokan>          pSstUpd,
        ZT_SkSeirituRituTy     pEntity) {
        boolean isFlush = addHenkouSqlCount(pGenIns, pSstDel, pSstUpd);
        if (isFlush) {
            pGenIns.add(pEntity);
        }
        else {
            skseiTyTmpLst.add(pEntity);
        }
    }
    private void addHenkouSqlCountMosjkIns(MultipleEntityInserter  pGenIns,
        EntityDeleter<HT_SisyaToukeiHokan>           pSstDel,
        EntityUpdater<HT_SisyaToukeiHokan>           pSstUpd,
        ZT_MosJkItiranSyoukaiTy pEntity) {
        boolean isFlush = addHenkouSqlCount(pGenIns, pSstDel, pSstUpd);
        if (isFlush) {
            pGenIns.add(pEntity);
        }
        else {
            mosjkTyTmpLst.add(pEntity);
        }
    }
    private void addHenkouSqlCountSstIns(MultipleEntityInserter pGenIns,
        EntityDeleter<HT_SisyaToukeiHokan>          pSstDel,
        EntityUpdater<HT_SisyaToukeiHokan>          pSstUpd,
        HT_SisyaToukeiHokan    pEntity) {
        boolean isFlush = addHenkouSqlCount(pGenIns, pSstDel, pSstUpd);
        if (isFlush) {
            pGenIns.add(pEntity);
        }
        else {
            sstInsTmpLst.add(pEntity);
        }
    }
    private void addHenkouSqlCountSstDel(MultipleEntityInserter pGenIns,
        EntityDeleter<HT_SisyaToukeiHokan>          pSstDel,
        EntityUpdater<HT_SisyaToukeiHokan>          pSstUpd,
        HT_SisyaToukeiHokan    pEntity) {
        boolean isFlush = addHenkouSqlCount(pGenIns, pSstDel, pSstUpd);
        if (isFlush) {
            pSstDel.add(pEntity);
        }
        else {
            sstDelTmpLst.add(pEntity);
        }
    }
    private void addHenkouSqlCountSstUpd(MultipleEntityInserter pGenIns,
        EntityDeleter<HT_SisyaToukeiHokan>          pSstDel,
        EntityUpdater<HT_SisyaToukeiHokan>          pSstUpd,
        HT_SisyaToukeiHokan    pEntity) {
        boolean isFlush = addHenkouSqlCount(pGenIns, pSstDel, pSstUpd);
        if (isFlush) {
            pSstUpd.add(pEntity);
        }
        else {
            sstUpdTmpLst.add(pEntity);
        }
    }
    private boolean addHenkouSqlCount(MultipleEntityInserter pGenIns, EntityDeleter<HT_SisyaToukeiHokan> pSstDel, EntityUpdater<HT_SisyaToukeiHokan> pSstUpd) {
        HenkouSqlCount++;
        if (HenkouSqlCount % flushLimit == 1 && HenkouSqlCount > 1) {

            for (ZT_DrtenIpToukeiTy tmpDrt : drtenTyTmpLst) {
                pGenIns.add(tmpDrt);
            }
            for (ZT_SkSeirituRituTy tmpSei : skseiTyTmpLst) {
                pGenIns.add(tmpSei);
            }
            for (ZT_MosJkItiranSyoukaiTy tmpMos : mosjkTyTmpLst) {
                pGenIns.add(tmpMos);
            }
            for (HT_SisyaToukeiHokan tmpSst : sstDelTmpLst) {
                pSstDel.add(tmpSst);
            }
            for (HT_SisyaToukeiHokan tmpSst : sstInsTmpLst) {
                pGenIns.add(tmpSst);
            }
            for (HT_SisyaToukeiHokan tmpSst : sstUpdTmpLst) {
                pSstUpd.add(tmpSst);
            }
            drtenTyTmpLst.clear();
            skseiTyTmpLst.clear();
            mosjkTyTmpLst.clear();
            sstDelTmpLst.clear();
            sstInsTmpLst.clear();
            sstUpdTmpLst.clear();
            return true;
        }
        else {
            return false;
        }
    }
    private String getSstmoskbn(HT_MosKihon pMosKihon) {
        if (BizDateUtil.compareYm(pMosKihon.getMosym(), pMosKihon.getSeisekiym()) < 0) {
            return "2";
        }
        return "1";
    }

    private String getSstkurikosiriyuukbn(HT_SyoriCTL pSyoriCTL, HT_MosKihon pMosKihon) {
        if (C_UmuKbn.ARI.eq(pSyoriCTL.getMinyknkurikosiumu())) {
            return "02";
        }
        else if (C_UmuKbn.ARI.eq(pSyoriCTL.getKettienkurikosiumu())) {
            return "03";
        }
        else if (C_UmuKbn.ARI.eq(pSyoriCTL.getSrhkurikosiumu())) {
            return "06";
        }
        else if (pMosKihon.getMosym() != null && pMosKihon.getBosyuuym() != null
            && pMosKihon.getMosym().compareTo(pMosKihon.getBosyuuym()) < 0) {
            return "08";
        }
        return "00";
    }

    private String getSstketteijkkbn(HT_SyoriCTL pSyoriCTL) {
        C_KnkysateijyouKbn knkySateiJyouKbn = pSyoriCTL.getKnkysateijyoukbn();
        C_ImusateijyouKbn imuSateiJyouKbn = pSyoriCTL.getImusateijyoukbn();

        if (C_KetteiKbn.KETTEI_SUMI.eq(pSyoriCTL.getKetteikbn())) {
            return "3";
        }
        else if (C_KetteiKbn.NONE.eq(pSyoriCTL.getKetteikbn()) &&
            ((!C_KnkysateijyouKbn.NONE.eq(knkySateiJyouKbn) && !C_KnkysateijyouKbn.SATEIZUMI.eq(knkySateiJyouKbn)) ||
                (!C_ImusateijyouKbn.NONE.eq(imuSateiJyouKbn) && !C_ImusateijyouKbn.SATEIZUMI.eq(imuSateiJyouKbn)))) {
            return "2";
        }
        else {
            return "0";
        }
    }

    private String getSstdakuhiketteijyoutaikbn(HT_SyoriCTL pSyoriCTL) {
        if (C_KetteiKbn.KETTEI_SUMI.eq(pSyoriCTL.getKetteikbn())) {
            return "08";
        }
        else if (C_KykkakjkKbn.KETMAE_KAKUNIN.eq(pSyoriCTL.getKykkakjkkbn())
            || C_KykkakjkKbn.KETHORYU_KAKUNIN.eq(pSyoriCTL.getKykkakjkkbn())) {
            return "04";
        }
        else if ((!C_KnkysateijyouKbn.NONE.eq(pSyoriCTL.getKnkysateijyoukbn())
            && !C_KnkysateijyouKbn.SATEIZUMI.eq(pSyoriCTL.getKnkysateijyoukbn()))
            || (!C_ImusateijyouKbn.NONE.eq(pSyoriCTL.getImusateijyoukbn())
                && !C_ImusateijyouKbn.SATEIZUMI.eq(pSyoriCTL.getImusateijyoukbn()))) {
            return "01";
        }
        return "00";
    }

    private String getSstnyknkanskanouhyouji(HT_SyoriCTL pSyoriCTL) {
        if (C_SeirituKbn.NONE.eq(pSyoriCTL.getSeiritukbn())
            && C_KetteiKbn.KETTEI_SUMI.eq(pSyoriCTL.getKetteikbn())
            && C_UmuKbn.NONE.eq(pSyoriCTL.getKthhbkbn())
            && C_UmuKbn.NONE.eq(pSyoriCTL.getSrhhbkbn())
            && C_UmuKbn.NONE.eq(pSyoriCTL.getKhnhbkbn())
            && (C_HubikaisyoujoutaiKbn.BLNK.eq(pSyoriCTL.getHubikaisyoujoutaikbn())
                || C_HubikaisyoujoutaiKbn.HUBIKAISYOUZUMI.eq(pSyoriCTL.getHubikaisyoujoutaikbn()))
                && (C_KykkakjkKbn.KAKUNIN_SUMI.eq(pSyoriCTL.getKykkakjkkbn())
                    || C_KykkakjkKbn.KETMAE_KAKUNIN_TAISY.eq(pSyoriCTL.getKykkakjkkbn()))
                    && C_UmuKbn.NONE.eq(pSyoriCTL.getNyknnrkumu())) {
            return "1";
        }
        return "0";
    }

    private String getSstdshukahyouji(HT_MosKihon pMosKihon) {
        if (C_DirectServiceMosKbn.ENTRY.eq(pMosKihon.getDrctservicemoskbn())
            || C_DirectServiceMosKbn.CHECK.eq(pMosKihon.getDrctservicemoskbn())) {
            return "1";
        }
        return "0";
    }

    private String getSstmosjkkbn(HT_SyoriCTL pSyoriCTL) {
        if (C_SeirituKbn.SEIRITU.eq(pSyoriCTL.getSeiritukbn())) {
            return "1";
        }
        else if (C_SeirituKbn.HUSEIRITU.eq(pSyoriCTL.getSeiritukbn())) {
            return "3";
        }
        else {
            if (pSyoriCTL.getMosnrkymd() == null) {
                return "6";
            }
            else {
                String ret = getSstnyknkanskanouhyouji(pSyoriCTL);
                if (ret.equals("1")) {
                    return "4";
                }
                else {
                    return "2";
                }
            }
        }
    }

    private String getSstmosketteihoryuu(HT_SyoriCTL pSyoriCTL, HT_MostenkenRireki pMostenkenRireki) {
        if (!C_KetteiKbn.KETTEI_SUMI.eq(pSyoriCTL.getKetteikbn())) {
            if (pMostenkenRireki != null && C_SyorikekkaKbn.HORYUU.eq(pMostenkenRireki.getMostenkenkekkakbn())) {
                return "1";
            }
            return "0";
        }
        return "0";

    }

    private String getSstkykkakuninjissityuu(HT_SyoriCTL pSyoriCTL, HT_MosKihon pMosKihon) {
        if (C_UmuKbn.NONE.eq(pMosKihon.getKakukisyouryakukbumukbn())
            && (C_KykkakjkKbn.KETMAE_KAKUNIN.eq(pSyoriCTL.getKykkakjkkbn()) ||
                C_KykkakjkKbn.KETHORYU_KAKUNIN.eq(pSyoriCTL.getKykkakjkkbn())
                || C_KykkakjkKbn.SEIRITUGO_KAK_IRAISU.eq(pSyoriCTL.getKykkakjkkbn()))) {
            return "1";
        }
        return "0";
    }

    private String getZtymosym(HT_SyoriCTL pSyoriCTL,String pMosYmd) {

        if (pSyoriCTL.getRyosyuymd() == null && pSyoriCTL.getKktymd() == null){
            return pMosYmd.substring(0, 6);
        }
        else if (BizDateUtil.compareYmd(pSyoriCTL.getRyosyuymd(),pSyoriCTL.getKktymd()) == BizDateUtil.COMPARE_LESSER){
            return pSyoriCTL.getKktymd().toString().substring(0, 6);
        }
        else {
            return pSyoriCTL.getRyosyuymd().toString().substring(0, 6);
        }
    }

    @AppBatchExceptionTerminate
    private void appBatchExceptionTerminate() {
        BzBatchAbendCommonRecovery bzBatchAbendCommonRecovery =
            SWAKInjector.getInstance(BzBatchAbendCommonRecovery.class);
        bzBatchAbendCommonRecovery.exec();
    }
}
