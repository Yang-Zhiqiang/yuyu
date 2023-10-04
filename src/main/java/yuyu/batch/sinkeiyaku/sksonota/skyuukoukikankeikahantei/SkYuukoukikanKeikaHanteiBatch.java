package yuyu.batch.sinkeiyaku.sksonota.skyuukoukikankeikahantei;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.batch.annotation.AppBatchExceptionTerminate;
import jp.co.slcs.swak.batch.annotation.Execute;
import jp.co.slcs.swak.bizinfr.exception.BizAppException;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateSpan;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.db.EntityInserter;
import jp.co.slcs.swak.db.EntityUpdater;
import jp.co.slcs.swak.db.ExDBResults;
import jp.co.slcs.swak.db.ExDBUpdatableResults;
import jp.co.slcs.swak.util.message.MessageUtil;
import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.common.biz.bzcommon.BizUtil;
import yuyu.common.biz.bzcommon.BzBatchAbendCommonRecovery;
import yuyu.common.biz.bzcommon.BzProcessUpdateForBatchInputBean;
import yuyu.common.biz.bzcommon.DateFormatUtil;
import yuyu.common.biz.exception.CommonBizAppException;
import yuyu.common.sinkeiyaku.koutei.SkProcessForwardForBatchInBean;
import yuyu.common.sinkeiyaku.koutei.SkProcessForwardYuukoukikanKeikaHantei;
import yuyu.common.sinkeiyaku.koutei.SkProcessUpdate;
import yuyu.common.sinkeiyaku.moschk.MosnaiCheckParam;
import yuyu.common.sinkeiyaku.skcommon.EditTblAtukaisya;
import yuyu.common.sinkeiyaku.skcommon.Henkin;
import yuyu.common.sinkeiyaku.skcommon.HenkinOutBean;
import yuyu.common.sinkeiyaku.skcommon.ISkCommonKoumoku;
import yuyu.common.sinkeiyaku.skcommon.SetMossykykyoteiymd;
import yuyu.common.sinkeiyaku.skcommon.SkIdounaiyouBeforeBean;
import yuyu.common.sinkeiyaku.skcommon.SkToujituIdounaiyouEdit;
import yuyu.def.MessageId;
import yuyu.def.biz.bean.param.BzRecoveryDatasikibetuBean;
import yuyu.def.classification.C_DakuhiktbunruiKbn;
import yuyu.def.classification.C_FstphrkkeiroKbn;
import yuyu.def.classification.C_HenkinriyuuKbn;
import yuyu.def.classification.C_JimusrhKbn;
import yuyu.def.classification.C_KeikaKbn;
import yuyu.def.classification.C_Ketkekkacd;
import yuyu.def.classification.C_Ketriyuucd;
import yuyu.def.classification.C_KetteiKbn;
import yuyu.def.classification.C_KykKbn;
import yuyu.def.classification.C_NyuukinjyoutaiKbn;
import yuyu.def.classification.C_SateijtKbn;
import yuyu.def.classification.C_SeirituKbn;
import yuyu.def.classification.C_SntkhouKbn;
import yuyu.def.classification.C_SyorikekkaKbn;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.classification.C_SyosaiKbn;
import yuyu.def.classification.C_SyoubyoujyoutaiKbn;
import yuyu.def.classification.C_SyssrhKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.AS_Kinou;
import yuyu.def.db.entity.BT_TjtIdouNySk;
import yuyu.def.db.entity.HT_DakuhiKettei;
import yuyu.def.db.entity.HT_Houjyou;
import yuyu.def.db.entity.HT_ImusateiRireki;
import yuyu.def.db.entity.HT_Kokutisyo;
import yuyu.def.db.entity.HT_MosKihon;
import yuyu.def.db.entity.HT_MosnoKanri;
import yuyu.def.db.entity.HT_SkDenpyoData;
import yuyu.def.db.entity.HT_SkHubi;
import yuyu.def.db.entity.HT_SkHubiDetail;
import yuyu.def.db.entity.HT_SyoriCTL;
import yuyu.def.db.entity.HT_YuukoukknKykList;
import yuyu.def.db.entity.HT_YuukoukknKykListAtukaiSya;
import yuyu.def.sinkeiyaku.bean.report.SKYuukoukknkyklistDetailBean;
import yuyu.def.sinkeiyaku.configuration.YuyuSinkeiyakuConfig;
import yuyu.def.sinkeiyaku.manager.SinkeiyakuDomManager;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.BatchParam;
import yuyu.infr.batch.logger.BatchLogger;
import yuyu.infr.report.CreateReport;
import yuyu.infr.report.jasperreport.JasperReportServicesBean;
import yuyu.infr.report.swakreport.IReportDataSouceBean;

import com.google.common.collect.Lists;

/**
 * 新契約 その他 有効期間経過契約判定処理
 */
public class SkYuukoukikanKeikaHanteiBatch implements Batch {

    private static final String TABLEID = "HT_SyoriCTL";

    private static final String RECOVERYFILTERID = "Sk001";

    private static final String JIDOUHUSEIRITU = "自動不成立";

    private static final String SKTJIDNYHS = "新契約当日異動内容(ファイル)編集";

    private static final String MOSNO = "申込番号";

    private static final String YUKIKKEKKEYHATSR = "有効期間経過契約判定処理";

    private static final String YUKIKKEKKEYHATSRHUSR = "有効期間経過契約判定処理により不成立";

    private BizDate syoriYmd;

    private C_KeikaKbn keikaKbn;

    private String gyoumuKousinsyaId;

    private String gyoumuKousinTime;

    private long syoriCount;

    private long jdHsrtSyoriCount;

    private boolean tyouhyouFlag;

    private ArrayList<SkProcessForwardForBatchInBean> skProcessForBatchInBeanLst;

    private SkToujituIdounaiyouEdit skToujituIdounaiyouEdit;

    private C_SyoruiCdKbn syoruiCd = C_SyoruiCdKbn.BLNK;

    private String kakutyoujobCd;

    private boolean ykKknKeikaKykListAriFlg = false;

    private List<BzProcessUpdateForBatchInputBean> bzProcessUpdateForBatchInputBeanList =
        new ArrayList<BzProcessUpdateForBatchInputBean>();

    @Inject
    private BatchLogger batchLogger;

    @Inject
    private SkYuukoukikanKeikaHanteiBatchParam subBatchParam;

    @Inject
    private AS_Kinou kinou;

    @Inject
    private CreateReport createReport;

    @Inject
    private MosnaiCheckParam mosnaiCheckParam;

    @Inject
    private EditTblAtukaisya editTblAtukaisya;

    @Inject
    private SinkeiyakuDomManager sinkeiyakuDomManager;

    @Inject
    private BzRecoveryDatasikibetuBean bzRecoveryDatasikibetuBean;

    @Override
    public BatchParam getParam() {
        return subBatchParam;
    }

    @Execute
    @Transactional
    public void execute() {

        syoriYmd = subBatchParam.getSyoriYmd();

        gyoumuKousinsyaId = subBatchParam.getUserId();

        kakutyoujobCd = subBatchParam.getIbKakutyoujobcd();

        gyoumuKousinTime = BizDate.getSysDateTimeMilli();

        keikaKbn = subBatchParam.getKeikakbn();

        batchLogger.info(MessageUtil.getMessage(MessageId.IBA0016, MessageUtil.getMessage(MessageId.IBW0003),
            String.valueOf(syoriYmd)));

        batchLogger.info(MessageUtil.getMessage(MessageId.IBA0016, MessageUtil.getMessage(MessageId.IBW1018),
            kakutyoujobCd));


        try (
            EntityUpdater<HT_MosnoKanri> mosnoKanriUpdater = new EntityUpdater<>();
            EntityInserter<HT_SkDenpyoData> skDenpyoDataInserter = new EntityInserter<>();
            EntityInserter<BT_TjtIdouNySk> tjtIdouNySkInserter = new EntityInserter<>();
            EntityInserter<HT_YuukoukknKykList> yuukoukknKykListInserter = new EntityInserter<>();
            ExDBUpdatableResults<HT_SyoriCTL> syoriCTLExDBResults = getYkKknKeika()) {

            if (syoriCTLExDBResults != null) {

                Iterator<HT_SyoriCTL> iterator = syoriCTLExDBResults.iterator();

                if (iterator.hasNext()) {
                    ykKknKeikaKykListAriFlg = true;

                    while (iterator.hasNext()) {

                        HT_SyoriCTL syoriCTL = iterator.next();

                        exeYkKknKeikaHantei(syoriCTL,
                            mosnoKanriUpdater,
                            skDenpyoDataInserter,
                            tjtIdouNySkInserter,
                            yuukoukknKykListInserter);
                    }
                }
            }

            bzRecoveryDatasikibetuBean.initializeBlank();
        }

        if (ykKknKeikaKykListAriFlg && tyouhyouFlag) {
            exeCreateBeanItems();
        }

        if (skProcessForBatchInBeanLst.size() != 0) {

            SkProcessForwardYuukoukikanKeikaHantei skProcessForwardYuukoukikanKeikaHantei =
                SWAKInjector.getInstance(SkProcessForwardYuukoukikanKeikaHantei.class);

            skProcessForwardYuukoukikanKeikaHantei.exec(skProcessForBatchInBeanLst);
        }

        SkProcessUpdate skProcessUpdate = SWAKInjector.getInstance(SkProcessUpdate.class);

        skProcessUpdate.execForBatch(bzProcessUpdateForBatchInputBeanList);


        batchLogger.info(MessageUtil.getMessage(
            MessageId.IBF0002, String.valueOf(syoriCount), ISkCommonKoumoku.TYOUHYOUMEI_YUUKOUKKNKYKLIST));

        if (C_KeikaKbn.YKKIKANTYOUKA.eq(keikaKbn)) {

            batchLogger.info(MessageUtil.getMessage(
                MessageId.IBF0002, String.valueOf(jdHsrtSyoriCount), JIDOUHUSEIRITU));
        }
    }

    private ExDBUpdatableResults<HT_SyoriCTL> getYkKknKeika() {

        syoriCount = 0;
        jdHsrtSyoriCount = 0;
        tyouhyouFlag = false;
        skProcessForBatchInBeanLst = Lists.newArrayList();
        skToujituIdounaiyouEdit = SWAKInjector.getInstance(SkToujituIdounaiyouEdit.class);

        if (C_KeikaKbn.YKKIKANTYOUKA.eq(keikaKbn)) {

            Integer keikaKikanMinyuukin = YuyuSinkeiyakuConfig.getInstance().getKeikaKknYuukouMinyuukin();

            BizDate hanteiKjMinyuukinYmd = syoriYmd.addMonths(- keikaKikanMinyuukin);

            BizDateYM hanteiKjMinyuukinYm = hanteiKjMinyuukinYmd.getBizDateYM();

            Integer keikaKikanNyuukin = YuyuSinkeiyakuConfig.getInstance().getKeikaKknYuukouNyuukinzumi();

            BizDate hanteiKjNyuukinYmd = syoriYmd.addMonths(- keikaKikanNyuukin);

            BizDateYM hanteiKjNyuukinYm = hanteiKjNyuukinYmd.getBizDateYM();

            return sinkeiyakuDomManager.getSyoriCTLsByKakutyoujobcdSeiritukbnMosnrkumuMosymNyknnrkumu(
                kakutyoujobCd, hanteiKjNyuukinYm, hanteiKjMinyuukinYm);
        }
        else if (C_KeikaKbn.YOKOKUKIKAN.eq(keikaKbn)) {

            Integer yokokuKikan = YuyuSinkeiyakuConfig.getInstance().getKeikaKknYokoku();

            BizDateSpan periodObject2 = new BizDateSpan(0, -yokokuKikan, 0);

            BizDate syoriYmd2 = syoriYmd;

            syoriYmd2 = syoriYmd2.add(periodObject2);

            BizDateYM hanteiKjYmdFrom = syoriYmd2.getBizDateYM();

            BizDateYM hanteiKjYmdTo = syoriYmd.getBizDateYM();

            return sinkeiyakuDomManager.getSyoriCTLsByKakutyoujobcdSeiritukbnMosnrkumuMosym(
                kakutyoujobCd, hanteiKjYmdTo, hanteiKjYmdFrom);
        }

        return null;
    }

    private void exeYkKknKeikaHantei(HT_SyoriCTL pSyoriCTL,
        EntityUpdater<HT_MosnoKanri> pMosnoKanriUpdater,
        EntityInserter<HT_SkDenpyoData> pSkDenpyoDataInserter,
        EntityInserter<BT_TjtIdouNySk> pTjtIdouNySkInserter,
        EntityInserter<HT_YuukoukknKykList> pYuukoukknKykListInserter) {

        HT_SyoriCTL syoriCTL = pSyoriCTL;
        HT_MosKihon mosKihon = syoriCTL.getMosKihon();
        String mosNo = syoriCTL.getMosno();
        C_UmuKbn kktNrkUmu = syoriCTL.getKktnrkumu();
        C_UmuKbn hjNrkUmu = syoriCTL.getHjynrkumu();
        BizDate kktKktYmd = null;
        BizDate hjKktYmd = null;
        mosnaiCheckParam = SWAKInjector.getInstance(MosnaiCheckParam.class);
        syoriCTL.getSkHubis().size();

        bzRecoveryDatasikibetuBean.setIbKakutyoujobcd(kakutyoujobCd);
        bzRecoveryDatasikibetuBean.setIbTableid(TABLEID);
        bzRecoveryDatasikibetuBean.setIbRecoveryfilterid(RECOVERYFILTERID);
        bzRecoveryDatasikibetuBean.setIbRecoveryfilterkey1(mosNo);

        BizDate ryosyuYmd = syoriCTL.getRyosyuymd();

        if (C_SntkhouKbn.SYOKUGYOU.equals(mosKihon.getSntkhoukbn())) {

            kktKktYmd = mosKihon.getKktymd();
        }
        else if (C_UmuKbn.ARI.eq(kktNrkUmu)) {

            HT_Kokutisyo kokutisyo = syoriCTL.getKokutisyo();

            if (kokutisyo != null) {

                kktKktYmd = kokutisyo.getKktymd();

            }
            else {

                throw new CommonBizAppException("申込番号＝" + mosNo);
            }
        }

        if (C_UmuKbn.ARI.eq(hjNrkUmu)) {

            HT_Houjyou houjyou = syoriCTL.getHoujyouBySyosaikbn(C_SyosaiKbn.SOYSIN);

            if (houjyou != null) {

                hjKktYmd = houjyou.getKktymd();
            }
            else {

                throw new CommonBizAppException("申込番号＝" + mosNo);
            }
        }

        if (C_KeikaKbn.YKKIKANTYOUKA.eq(keikaKbn)) {

            SkIdounaiyouBeforeBean skIdounaiyouBeforeBean = skToujituIdounaiyouEdit.setSkIdounaiyouBefore(syoriCTL);

            int renNo = 0;
            SkProcessForwardForBatchInBean skProcessForBatchInBean =
                SWAKInjector.getInstance(SkProcessForwardForBatchInBean.class);

            HT_DakuhiKettei dakuhiKettei = sinkeiyakuDomManager.getDakuhiKetteiByMosnoMaxDakuhiktrenno(mosNo);

            if (dakuhiKettei != null) {

                renNo = dakuhiKettei.getDakuhiktrenno();
            }
            else {

                renNo = 0;
            }

            C_KetteiKbn ketteiKbn = syoriCTL.getKetteikbn();
            C_Ketriyuucd ketriyuuCd1 = C_Ketriyuucd.BLNK;
            C_Ketriyuucd ketriyuuCd2 = C_Ketriyuucd.BLNK;
            C_Ketriyuucd ketriyuuCd3 = C_Ketriyuucd.BLNK;
            C_Ketriyuucd ketriyuuCd4 = C_Ketriyuucd.BLNK;
            String syoubyouCd1 = "";
            C_SyoubyoujyoutaiKbn syoubyouJyoutaiKbn1 = C_SyoubyoujyoutaiKbn.BLNK;
            BizDateYM kantiYm1 = null;
            String syoubyouCd2 = "";
            C_SyoubyoujyoutaiKbn syoubyouJyoutaiKbn2 = C_SyoubyoujyoutaiKbn.BLNK;
            BizDateYM kantiYm2 = null;

            if (C_KetteiKbn.KETTEI_SUMI.eq(ketteiKbn) || C_KetteiKbn.TKJYSYDK_MATI.eq(ketteiKbn)) {

                if (dakuhiKettei == null) {

                    throw new CommonBizAppException("申込番号＝" + mosNo);
                }

                ketriyuuCd1 = dakuhiKettei.getKetriyuucd1();
                ketriyuuCd2 = dakuhiKettei.getKetriyuucd2();
                ketriyuuCd3 = dakuhiKettei.getKetriyuucd3();
                ketriyuuCd4 = dakuhiKettei.getKetriyuucd4();
                syoubyouCd1 = dakuhiKettei.getSyoubyoucd1();
                syoubyouJyoutaiKbn1 = dakuhiKettei.getSyoubyoujyoutaikbn1();
                kantiYm1 = dakuhiKettei.getKantiym1();
                syoubyouCd2 = dakuhiKettei.getSyoubyoucd2();
                syoubyouJyoutaiKbn2 = dakuhiKettei.getSyoubyoujyoutaikbn2();
                kantiYm2 = dakuhiKettei.getKantiym2();
            }
            else {
                if (C_UmuKbn.ARI.eq(syoriCTL.getImusateirrkumu())) {

                    HT_ImusateiRireki imusateiRireki = sinkeiyakuDomManager.getImusateiRirekiByMosnoMaxRenno(mosNo);

                    if (imusateiRireki == null) {

                        throw new CommonBizAppException("申込番号＝" + mosNo);
                    }

                    if ((C_KetteiKbn.NONE.eq(ketteiKbn) || C_KetteiKbn.KETTEI_MATI.eq(ketteiKbn))
                        && C_SyorikekkaKbn.KANRYOU.eq(imusateiRireki.getImusateikekkakbn())) {

                        ketriyuuCd1 = imusateiRireki.getKetriyuucd1();
                        ketriyuuCd2 = imusateiRireki.getKetriyuucd2();
                        ketriyuuCd3 = imusateiRireki.getKetriyuucd3();
                        ketriyuuCd4 = imusateiRireki.getKetriyuucd4();
                        syoubyouCd1 = imusateiRireki.getSyoubyoucd1();
                        syoubyouJyoutaiKbn1 = imusateiRireki.getSyoubyoujyoutaikbn1();
                        kantiYm1 = imusateiRireki.getKantiym1();
                        syoubyouCd2 = imusateiRireki.getSyoubyoucd2();
                        syoubyouJyoutaiKbn2 = imusateiRireki.getSyoubyoujyoutaikbn2();
                        kantiYm2 = imusateiRireki.getKantiym2();
                    }
                }
            }

            HT_DakuhiKettei udDakuhiKettei = syoriCTL.createDakuhiKettei();

            udDakuhiKettei.setDakuhiktrenno(renNo + 1);
            udDakuhiKettei.setKetymd(syoriYmd);
            udDakuhiKettei.setDakuhiktbunruikbn(C_DakuhiktbunruiKbn.SYOUMETU);
            udDakuhiKettei.setKetkekkacd(C_Ketkekkacd.YUUKOUKKNKKA);
            udDakuhiKettei.setKetriyuucd1(ketriyuuCd1);
            udDakuhiKettei.setKetriyuucd2(ketriyuuCd2);
            udDakuhiKettei.setKetriyuucd3(ketriyuuCd3);
            udDakuhiKettei.setKetriyuucd4(ketriyuuCd4);
            udDakuhiKettei.setSyoubyoucd1(syoubyouCd1);
            udDakuhiKettei.setSyoubyoujyoutaikbn1(syoubyouJyoutaiKbn1);
            udDakuhiKettei.setKantiym1(kantiYm1);
            udDakuhiKettei.setSyoubyoucd2(syoubyouCd2);
            udDakuhiKettei.setSyoubyoujyoutaikbn2(syoubyouJyoutaiKbn2);
            udDakuhiKettei.setKantiym2(kantiYm2);
            udDakuhiKettei.setKetsyacd(gyoumuKousinsyaId);
            udDakuhiKettei.setPalketsyacd(ISkCommonKoumoku.PALKETSYACD_KIKAIKETTEI);
            udDakuhiKettei.setTkjysydkymd(null);
            udDakuhiKettei.setGyoumuKousinsyaId(gyoumuKousinsyaId);
            udDakuhiKettei.setGyoumuKousinTime(gyoumuKousinTime);

            BizPropertyInitializer.initialize(udDakuhiKettei);

            mosnaiCheckParam.setSysDate(syoriYmd);
            mosnaiCheckParam.setKosID(gyoumuKousinsyaId);
            mosnaiCheckParam.setKosTime(gyoumuKousinTime);
            mosnaiCheckParam.setDataSyoriControl(syoriCTL);

            Henkin henkin = SWAKInjector.getInstance(Henkin.class);

            HenkinOutBean henkinOutBean = henkin.execPkakin(
                mosnaiCheckParam, null, C_Tuukasyu.BLNK, C_HenkinriyuuKbn.YUUKOUKKNKKA);

            if (C_UmuKbn.ARI.eq(syoriCTL.getNyknnrkumu())) {

                syoriCTL.setNyuukinjoutaikbn(C_NyuukinjyoutaiKbn.SYOUMETU);
            }

            syoriCTL.setKetteikbn(C_KetteiKbn.KETTEI_SUMI);
            syoriCTL.setSeiritukbn(C_SeirituKbn.HUSEIRITU);
            syoriCTL.setSrsyoriymd(syoriYmd);

            if (!C_SateijtKbn.SATEI_SUMI.eq(syoriCTL.getSateijtkbn())) {

                syoriCTL.setSateijtkbn(C_SateijtKbn.SATEI_SUMI);
                syoriCTL.setSateizumiymd(syoriYmd);
            }

            syoriCTL.setGyoumuKousinsyaId(gyoumuKousinsyaId);
            syoriCTL.setGyoumuKousinTime(gyoumuKousinTime);

            syoriCTL.setTokujyou(null);

            syoriCTL.getSyouhnTokujyous().clear();

            syoriCTL.getSonotaTkykJktks().clear();

            SetMossykykyoteiymd setMossykykyoteiymd = SWAKInjector.getInstance(SetMossykykyoteiymd.class);
            HT_MosnoKanri mosnoKanri = setMossykykyoteiymd.setMosskykyoteiymdHuseiritu(syoriCTL, syoriYmd, gyoumuKousinsyaId);

            if (mosnoKanri == null) {

                throw new CommonBizAppException("申込番号＝" + syoriCTL.getMosno());
            }

            boolean hanteiResult = skToujituIdounaiyouEdit.skIdounaiyouHenkouCheck(syoriCTL, skIdounaiyouBeforeBean);
            BT_TjtIdouNySk tjtIdouNySk = null;

            if (hanteiResult) {

                tjtIdouNySk = skToujituIdounaiyouEdit.skIdounaiyouFileEdit(syoriCTL);

                if (tjtIdouNySk == null) {
                    throw new BizAppException(MessageId.EHA1051, SKTJIDNYHS, MOSNO, mosNo);
                }
            }

            skProcessForBatchInBean.setHtSyoriCTL(syoriCTL);
            skProcessForBatchInBean.setTskNm(YUKIKKEKKEYHATSR);
            skProcessForBatchInBean.setSyoriComment(YUKIKKEKKEYHATSRHUSR);

            skProcessForBatchInBean.setSkHubiDtailUmu(C_UmuKbn.NONE);

            List<HT_SkHubi> skHubiList = syoriCTL.getSkHubis();

            for (HT_SkHubi htSkHubi : skHubiList) {

                List<HT_SkHubiDetail> skHubiDetailList = htSkHubi.getSkHubiDetails();

                if (skHubiDetailList.size() > 0) {

                    skProcessForBatchInBean.setSkHubiDtailUmu(C_UmuKbn.ARI);

                    break;
                }
            }

            skProcessForBatchInBeanLst.add(skProcessForBatchInBean);

            SkProcessUpdate skProcessUpdate = SWAKInjector.getInstance(SkProcessUpdate.class);

            List<BzProcessUpdateForBatchInputBean> resultBzProcessUpdateForBatchInputBeanList =
                skProcessUpdate.editProcessUpdateForBatchInfo(syoriCTL, syoriCTL.getMosKihon(), syoriCTL.getMosDairitens());

            if (resultBzProcessUpdateForBatchInputBeanList.size() > 0) {

                bzProcessUpdateForBatchInputBeanList.addAll(resultBzProcessUpdateForBatchInputBeanList);
            }

            jdHsrtSyoriCount++;

            HT_YuukoukknKykList yuukoukknKykList = new HT_YuukoukknKykList();

            yuukoukknKykList.setMosno(mosNo);
            yuukoukknKykList.setTyouhyouymd(syoriYmd);
            yuukoukknKykList.setHhknnmkj(mosKihon.getHhknnmkj());
            if (mosKihon.getKykkbn().eq(C_KykKbn.KEIHI_DOUITU)) {
                yuukoukknKykList.setKyknmkj(mosKihon.getHhknnmkj());
            }
            else {
                yuukoukknKykList.setKyknmkj(mosKihon.getKyknmkj());
            }
            yuukoukknKykList.setMosymd(mosKihon.getMosymd());
            yuukoukknKykList.setKktkktymd(kktKktYmd);
            yuukoukknKykList.setHjkktymd(hjKktYmd);
            yuukoukknKykList.setFstnyknrsymd(ryosyuYmd);
            yuukoukknKykList.setKthhbkbn(C_UmuKbn.valueOf(BizUtil.blank2zero(syoriCTL.getKthhbkbn().getValue())));
            yuukoukknKykList.setSrhhbkbn(C_UmuKbn.valueOf(BizUtil.blank2zero(syoriCTL.getSrhhbkbn().getValue())));
            yuukoukknKykList.setJimusrhkbn(C_JimusrhKbn.valueOf(BizUtil.blank2zero(syoriCTL.getJimusrhkbn().getValue())));
            yuukoukknKykList.setSyssrhkbn(C_SyssrhKbn.valueOf(BizUtil.blank2zero(syoriCTL.getSyssrhkbn().getValue())));
            yuukoukknKykList.setKhnhbkbn(C_UmuKbn.valueOf(BizUtil.blank2zero(syoriCTL.getKhnhbkbn().getValue())));
            yuukoukknKykList.setFstphrkkeirokbn(
                C_FstphrkkeiroKbn.valueOf(BizUtil.blank2zero(mosKihon.getFstphrkkeirokbn().getValue())));
            yuukoukknKykList.setKetteikbn(C_KetteiKbn.valueOf(BizUtil.blank2zero(syoriCTL.getKetteikbn().getValue())));
            yuukoukknKykList.setGyoumuKousinsyaId(gyoumuKousinsyaId);
            yuukoukknKykList.setGyoumuKousinTime(gyoumuKousinTime);

            BizPropertyInitializer.initialize(yuukoukknKykList);

            mosnaiCheckParam.setCategoryID(kinou.getCategoryId());
            mosnaiCheckParam.setKinouID(kinou.getKinouId());
            mosnaiCheckParam.setSysDate(syoriYmd);
            mosnaiCheckParam.setKosID(gyoumuKousinsyaId);
            mosnaiCheckParam.setKosTime(gyoumuKousinTime);
            mosnaiCheckParam.setDataSyoriControl(syoriCTL);

            List<Map<String, String>> atukaiSyaLst = editTblAtukaisya.exec(mosnaiCheckParam);

            for (Map<String, String> atukaiSya : atukaiSyaLst) {

                HT_YuukoukknKykListAtukaiSya yuukoukknKykListAtukaiSya =
                    yuukoukknKykList.createYuukoukknKykListAtukaiSya();

                yuukoukknKykListAtukaiSya.setRenno(
                    Integer.valueOf(atukaiSya.get(EditTblAtukaisya.ATUKAISYAJHKEY_RENNO)));
                yuukoukknKykListAtukaiSya.setKeikakbn(keikaKbn);
                yuukoukknKykListAtukaiSya.setOyadrtencd(
                    atukaiSya.get(EditTblAtukaisya.ATUKAISYAJHKEY_OYADRTENCD));
                yuukoukknKykListAtukaiSya.setOyadrtennm(
                    atukaiSya.get(EditTblAtukaisya.ATUKAISYAJHKEY_OYADRTENNM));
                yuukoukknKykListAtukaiSya.setTratkiagcd(
                    atukaiSya.get(EditTblAtukaisya.ATUKAISYAJHKEY_TRATKIAGCD));
                yuukoukknKykListAtukaiSya.setGyoumuKousinsyaId(gyoumuKousinsyaId);
                yuukoukknKykListAtukaiSya.setGyoumuKousinTime(gyoumuKousinTime);

                BizPropertyInitializer.initialize(yuukoukknKykListAtukaiSya);
            }

            tyouhyouFlag = true;

            syoruiCd = C_SyoruiCdKbn.SK_YUUKOUKKNTYOUKALIST;

            for (HT_SkDenpyoData skDenpyoData : henkinOutBean.getSkDenpyoDataList()) {

                pSkDenpyoDataInserter.add(skDenpyoData);
            }
            pMosnoKanriUpdater.add(mosnoKanri);
            pTjtIdouNySkInserter.add(tjtIdouNySk);
            pYuukoukknKykListInserter.add(yuukoukknKykList);
        }

        else if (C_KeikaKbn.YOKOKUKIKAN.eq(keikaKbn)) {

            HT_YuukoukknKykList yuukoukknKykList = new HT_YuukoukknKykList();

            yuukoukknKykList.setMosno(mosNo);
            yuukoukknKykList.setTyouhyouymd(syoriYmd);
            yuukoukknKykList.setHhknnmkj(mosKihon.getHhknnmkj());
            if (mosKihon.getKykkbn().eq(C_KykKbn.KEIHI_DOUITU)) {
                yuukoukknKykList.setKyknmkj(mosKihon.getHhknnmkj());
            }
            else {
                yuukoukknKykList.setKyknmkj(mosKihon.getKyknmkj());
            }
            yuukoukknKykList.setMosymd(mosKihon.getMosymd());
            yuukoukknKykList.setKktkktymd(kktKktYmd);
            yuukoukknKykList.setHjkktymd(hjKktYmd);
            yuukoukknKykList.setFstnyknrsymd(ryosyuYmd);
            yuukoukknKykList.setKthhbkbn(C_UmuKbn.valueOf(BizUtil.blank2zero(syoriCTL.getKthhbkbn().getValue())));
            yuukoukknKykList.setSrhhbkbn(C_UmuKbn.valueOf(BizUtil.blank2zero(syoriCTL.getSrhhbkbn().getValue())));
            yuukoukknKykList.setJimusrhkbn(C_JimusrhKbn.valueOf(BizUtil.blank2zero(syoriCTL.getJimusrhkbn().getValue())));
            yuukoukknKykList.setSyssrhkbn(C_SyssrhKbn.valueOf(BizUtil.blank2zero(syoriCTL.getSyssrhkbn().getValue())));
            yuukoukknKykList.setKhnhbkbn(C_UmuKbn.valueOf(BizUtil.blank2zero(syoriCTL.getKhnhbkbn().getValue())));
            yuukoukknKykList.setFstphrkkeirokbn(C_FstphrkkeiroKbn.valueOf(BizUtil.blank2zero(mosKihon.
                getFstphrkkeirokbn().getValue())));
            yuukoukknKykList.setKetteikbn(C_KetteiKbn.valueOf(BizUtil.blank2zero(syoriCTL.getKetteikbn().getValue())));
            yuukoukknKykList.setGyoumuKousinsyaId(gyoumuKousinsyaId);
            yuukoukknKykList.setGyoumuKousinTime(gyoumuKousinTime);

            BizPropertyInitializer.initialize(yuukoukknKykList);

            mosnaiCheckParam.setCategoryID(kinou.getCategoryId());
            mosnaiCheckParam.setKinouID(kinou.getKinouId());
            mosnaiCheckParam.setSysDate(syoriYmd);
            mosnaiCheckParam.setKosID(gyoumuKousinsyaId);
            mosnaiCheckParam.setKosTime(gyoumuKousinTime);
            mosnaiCheckParam.setDataSyoriControl(syoriCTL);

            List<Map<String, String>> atukaisyaLst = editTblAtukaisya.exec(mosnaiCheckParam);

            for (Map<String, String> atukaisya : atukaisyaLst) {

                HT_YuukoukknKykListAtukaiSya yuukoukknKykListAtukaiSya =
                    yuukoukknKykList.createYuukoukknKykListAtukaiSya();

                yuukoukknKykListAtukaiSya.setRenno(Integer.valueOf(atukaisya.get(EditTblAtukaisya.ATUKAISYAJHKEY_RENNO)));
                yuukoukknKykListAtukaiSya.setKeikakbn(keikaKbn);
                yuukoukknKykListAtukaiSya.setOyadrtencd(atukaisya.get(EditTblAtukaisya.ATUKAISYAJHKEY_OYADRTENCD));
                yuukoukknKykListAtukaiSya.setOyadrtennm(atukaisya.get(EditTblAtukaisya.ATUKAISYAJHKEY_OYADRTENNM));
                yuukoukknKykListAtukaiSya.setTratkiagcd(atukaisya.get(EditTblAtukaisya.ATUKAISYAJHKEY_TRATKIAGCD));
                yuukoukknKykListAtukaiSya.setGyoumuKousinsyaId(gyoumuKousinsyaId);
                yuukoukknKykListAtukaiSya.setGyoumuKousinTime(gyoumuKousinTime);

                BizPropertyInitializer.initialize(yuukoukknKykListAtukaiSya);
            }

            tyouhyouFlag = true;

            syoruiCd = C_SyoruiCdKbn.SK_YUUKOUKKNYOKOKULIST;

            pYuukoukknKykListInserter.add(yuukoukknKykList);
        }
    }

    private void exeCreateBeanItems() {


        List<HT_YuukoukknKykListAtukaiSya> yuukoukknKykLtAtukaiSyaLst = sinkeiyakuDomManager
            .getYuukoukknKykListAtukaiSyasByTyouhyouymdKeikakbn(syoriYmd, keikaKbn);

        if (yuukoukknKykLtAtukaiSyaLst.size() == 0) {

            throw new CommonBizAppException("連番=1");
        }

        String oyadrtenCd = "";

        String oyadrtenNm = "";

        List<IReportDataSouceBean> iReportDataSouceBeanLst = new ArrayList<>();

        List<SKYuukoukknkyklistDetailBean> dsBeanDrtLst = null;

        String yuukoukknYmd = DateFormatUtil.dateKANJINoEx(syoriYmd);

        String yuukoukknYm = DateFormatUtil.dateYmKANJINoEx(syoriYmd.getBizDateYM());

        for (HT_YuukoukknKykListAtukaiSya yuukoukknKykListAtukaiSya : yuukoukknKykLtAtukaiSyaLst) {

            oyadrtenCd = yuukoukknKykListAtukaiSya.getOyadrtencd();

            oyadrtenNm = yuukoukknKykListAtukaiSya.getOyadrtennm();

            try (ExDBResults<HT_YuukoukknKykListAtukaiSya> objectLst =
                sinkeiyakuDomManager.getYuukoukknKykListAtukaiSyasByTyouhyouymdKeikakbnOyadrtencd(
                    syoriYmd, keikaKbn, oyadrtenCd)) {

                int listSyoriKensuu = 0;

                dsBeanDrtLst = new ArrayList<>();

                Iterator<HT_YuukoukknKykListAtukaiSya> iterator = objectLst.iterator();

                if (!iterator.hasNext()) {

                    throw new CommonBizAppException("代理店コード=" + oyadrtenCd + " 連番=1");
                }


                while (iterator.hasNext()) {

                    SKYuukoukknkyklistDetailBean sKYuukoukknkyklistDetailBean =
                        SWAKInjector.getInstance(SKYuukoukknkyklistDetailBean.class);

                    HT_YuukoukknKykListAtukaiSya yuukoukknKykListAtukaiSya1 = iterator.next();

                    HT_YuukoukknKykList yuukoukknKykList = yuukoukknKykListAtukaiSya1.getYuukoukknKykList();

                    sKYuukoukknkyklistDetailBean.setIrMosno(yuukoukknKykList.getMosno());
                    sKYuukoukknkyklistDetailBean.setIrTratkiagcd(yuukoukknKykListAtukaiSya1.getTratkiagcd());
                    sKYuukoukknkyklistDetailBean.setIrHhknnmkj(yuukoukknKykList.getHhknnmkj());
                    sKYuukoukknkyklistDetailBean.setIrKyknmkj(yuukoukknKykList.getKyknmkj());
                    sKYuukoukknkyklistDetailBean.setIrKthhbkbnval(yuukoukknKykList.getKthhbkbn().getContent());
                    sKYuukoukknkyklistDetailBean.setIrSrhhbkbnval(yuukoukknKykList.getSrhhbkbn().getContent());
                    sKYuukoukknkyklistDetailBean.setIrKhnhbkbnval(yuukoukknKykList.getKhnhbkbn().getContent());
                    sKYuukoukknkyklistDetailBean.setIrJimusrhkbnval(yuukoukknKykList.getJimusrhkbn().getContent());
                    sKYuukoukknkyklistDetailBean.setIrKetteikbnval(yuukoukknKykList.getKetteikbn().getContent());
                    sKYuukoukknkyklistDetailBean.setIrMosymd(DateFormatUtil.smd(yuukoukknKykList.getMosymd()));
                    sKYuukoukknkyklistDetailBean.setIrKktkktymd(DateFormatUtil.smd(yuukoukknKykList.getKktkktymd()));
                    sKYuukoukknkyklistDetailBean.setIrHjkktymd(DateFormatUtil.smd(yuukoukknKykList.getHjkktymd()));
                    sKYuukoukknkyklistDetailBean.setIrFstphrkkeiroval(yuukoukknKykList.getFstphrkkeirokbn().getContent());
                    sKYuukoukknkyklistDetailBean.setIrFstnyknrsymd(DateFormatUtil.smd(yuukoukknKykList.getFstnyknrsymd()));

                    sKYuukoukknkyklistDetailBean.setIrYuukoukknkeikahanteiym(yuukoukknYm);
                    sKYuukoukknkyklistDetailBean.setIrKeikakbnval(keikaKbn.getContent());
                    sKYuukoukknkyklistDetailBean.setIrYuukoukknkeikahanteiymd(yuukoukknYmd);
                    sKYuukoukknkyklistDetailBean.setIrDrtencd(oyadrtenCd);
                    sKYuukoukknkyklistDetailBean.setIrDrtennmkj(oyadrtenNm);

                    dsBeanDrtLst.add(sKYuukoukknkyklistDetailBean);

                    syoriCount++;

                    listSyoriKensuu++;
                }

                for (SKYuukoukknkyklistDetailBean dsBean : dsBeanDrtLst) {

                    dsBean.setIrKensuu(listSyoriKensuu);
                }

                iReportDataSouceBeanLst.addAll(dsBeanDrtLst);
            }
        }


        JasperReportServicesBean jasperReportServicesBean = new JasperReportServicesBean(
            kinou.getSubSystemId(),
            kinou.getCategoryId(),
            kinou.getKinouId(),
            syoruiCd);

        jasperReportServicesBean.setSyoriYmd(syoriYmd);

        jasperReportServicesBean.addParamObjects(iReportDataSouceBeanLst);

        createReport.execNoCommit(jasperReportServicesBean);
    }

    @AppBatchExceptionTerminate
    private void appBatchExceptionTerminate() {
        BzBatchAbendCommonRecovery bzBatchAbendCommonRecovery = SWAKInjector.getInstance(BzBatchAbendCommonRecovery.class);
        bzBatchAbendCommonRecovery.exec();
    }
}
