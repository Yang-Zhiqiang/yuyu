package yuyu.batch.hozen.khinterf.khseisandhaneituutisks;

import java.util.List;
import java.util.Set;

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
import jp.co.slcs.swak.util.string.ConvertUtil;
import yuyu.batch.hozen.khinterf.khseisandhaneituutisks.dba.KhHenkouUktkYykBean;
import yuyu.batch.hozen.khinterf.khseisandhaneituutisks.dba.KhSeisanDhaneiTuutiSksBean;
import yuyu.batch.hozen.khinterf.khseisandhaneituutisks.dba.KhSeisanDhaneiTuutiSksDao;
import yuyu.common.base.format.FixedDateFormatter;
import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.common.biz.bzcommon.BizUtil;
import yuyu.common.biz.bzcommon.BzBatchAbendCommonRecovery;
import yuyu.common.biz.bzcommon.BzBatchParam;
import yuyu.common.biz.bzcommon.BzGetSosikiMadogutiInfo;
import yuyu.common.biz.bzcommon.BzGetSosikiMadogutiInfoKekkaBean;
import yuyu.common.biz.bzcommon.BzKbnHenkanUtil;
import yuyu.common.biz.bzcommon.KbnInfoBean;
import yuyu.common.biz.exception.CommonBizAppException;
import yuyu.common.biz.koutei.BzGetProcessSummary;
import yuyu.common.biz.koutei.BzGetProcessSummaryComparatorWorkListHyoujijun;
import yuyu.common.biz.koutei.BzGetProcessSummaryInBean;
import yuyu.common.biz.koutei.BzGetProcessSummaryOutBean;
import yuyu.def.MessageId;
import yuyu.def.biz.bean.param.BzRecoveryDatasikibetuBean;
import yuyu.def.biz.configuration.YuyuBizConfig;
import yuyu.def.classification.C_HaitoukinuketorihouKbn;
import yuyu.def.classification.C_HassouKbn;
import yuyu.def.classification.C_Hrkkeiro;
import yuyu.def.classification.C_KahiKbn;
import yuyu.def.classification.C_KktyuitaKbn;
import yuyu.def.classification.C_Kouteikanristatus;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.classification.C_SystemRenkeiHenkanHoukouKbn;
import yuyu.def.classification.C_TtdktyuuiKbn;
import yuyu.def.classification.C_TumitateDSakuseiKbn;
import yuyu.def.classification.C_UktkJyoutaiKbn;
import yuyu.def.classification.C_UktkSyoriKbn;
import yuyu.def.classification.C_YuukoujyotaikahiKbn;
import yuyu.def.db.entity.IT_SeisanDHaneiTuuti;
import yuyu.def.db.entity.ZT_SeisanDHaneiTuutiTy;
import yuyu.def.hozen.configuration.YuyuHozenConfig;
import yuyu.def.siharai.manager.SiharaiDomManager;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.BatchParam;
import yuyu.infr.batch.logger.BatchLogger;

import com.google.common.collect.Sets;

/**
 * 契約保全 インターフェイス 精算Ｄ反映通知作成
 */
public class KhSeisanDhaneiTuutiSksBatch  implements Batch {

    private static final String TYSYTTAISYOUTABLEID = IT_SeisanDHaneiTuuti.TABLE_NAME;

    private static final String RECOVERYFILTERID = "Kh001";

    @Inject
    private BatchLogger batchLogger;

    @Inject
    private BzBatchParam bzBatchParam;

    @Inject
    private KhSeisanDhaneiTuutiSksDao khSeisanDhaneiTuutiSksDao;

    @Inject
    private BzRecoveryDatasikibetuBean bzRecoveryDatasikibetuBean;

    @Inject
    private SiharaiDomManager siharaiDomManager;

    @Override
    public BatchParam getParam() {
        return bzBatchParam;
    }

    @Execute
    @Transactional
    public void execute() {

        Set<String> henkouUktkYykSet = Sets.newHashSet();
        BizDate syoriYMD = bzBatchParam.getSyoriYmd();
        String kakutyouJobCd = bzBatchParam.getIbKakutyoujobcd();
        long seisanDHaneiTuutiTyInsCount = 0;
        long seqNo = 1;

        batchLogger.info(MessageUtil.getMessage(
            MessageId.IBA0016, MessageUtil.getMessage(MessageId.IBW0003), String.valueOf(syoriYMD)));

        batchLogger.info(MessageUtil.getMessage(
            MessageId.IBA0016, MessageUtil.getMessage(MessageId.IBW1018), kakutyouJobCd));

        try (ExDBResults<KhSeisanDhaneiTuutiSksBean> khSeisanDhaneiTuutiSksBeanLst =
            khSeisanDhaneiTuutiSksDao.getKhSeisanDhaneiTuutiSksBeans(kakutyouJobCd, syoriYMD.getBizDateY());
            EntityInserter<ZT_SeisanDHaneiTuutiTy> seisanDHaneiTuutiTyIns = new EntityInserter<>();){

            List<KhHenkouUktkYykBean> khHenkouUktkYykBeanList = khSeisanDhaneiTuutiSksDao.getKhHenkouUktkYykBean(
                C_UktkJyoutaiKbn.MISYORI, C_UktkSyoriKbn.KAIYAKU);

            for (KhHenkouUktkYykBean khHenkouUktkYykBean : khHenkouUktkYykBeanList) {

                henkouUktkYykSet.add(khHenkouUktkYykBean.getSyono());
            }

            BzGetSosikiMadogutiInfo bzGetSosikiMadogutiInfo = SWAKInjector.getInstance(BzGetSosikiMadogutiInfo.class);

            BzGetSosikiMadogutiInfoKekkaBean bzGetSosikiMadogutiInfoKekkaBean = bzGetSosikiMadogutiInfo.exec(
                YuyuBizConfig.getInstance().getCallcentersosikicd());

            for (KhSeisanDhaneiTuutiSksBean khSeisanDhaneiTuutiSksBean : khSeisanDhaneiTuutiSksBeanLst) {

                String syono = khSeisanDhaneiTuutiSksBean.getSyono();

                bzRecoveryDatasikibetuBean.setIbKakutyoujobcd(kakutyouJobCd);
                bzRecoveryDatasikibetuBean.setIbTableid(TYSYTTAISYOUTABLEID);
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterid(RECOVERYFILTERID);
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterkey1(khSeisanDhaneiTuutiSksBean.getKbnkey());
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterkey2(syono);

                C_KahiKbn kahiKbn = chkSyoriJyotai(syono);

                if (C_KahiKbn.HUKA.eq(kahiKbn)) {

                    continue;
                }

                if (henkouUktkYykSet.contains(syono)) {

                    continue;
                }

                BizDate kijyunymd = BizDate.valueOf(syoriYMD.getBizDateY() + YuyuHozenConfig.getInstance().getDrateKakuteiMd());
                if (!kijyunymd.isBusinessDay()) {
                    kijyunymd = kijyunymd.getBusinessDay(CHolidayAdjustingMode.PREVIOUS);
                }

                C_TumitateDSakuseiKbn[] tumitatedsksKbn = {C_TumitateDSakuseiKbn.ZENHIKIDASI, C_TumitateDSakuseiKbn.ITIBUHIKIDASI};

                Long khTumitateDKanriCount = khSeisanDhaneiTuutiSksDao.getKhTumitateDKanriCount(syono, tumitatedsksKbn, kijyunymd);

                if (khTumitateDKanriCount > 0) {

                    continue;
                }

                insertData(seisanDHaneiTuutiTyIns, khSeisanDhaneiTuutiSksBean, bzGetSosikiMadogutiInfoKekkaBean, syoriYMD, seqNo);

                seisanDHaneiTuutiTyInsCount ++;
                seqNo ++;
            }

            bzRecoveryDatasikibetuBean.initializeBlank();
        }

        batchLogger.info(MessageUtil.getMessage(MessageId.IBF0002,
            String.valueOf(seisanDHaneiTuutiTyInsCount), "精算Ｄ反映通知テーブル（中）"));

    }

    @AppBatchExceptionTerminate
    private void appBatchExceptionTerminate() {

        BzBatchAbendCommonRecovery bzBatchAbendCommonRecovery =
            SWAKInjector.getInstance(BzBatchAbendCommonRecovery.class);

        bzBatchAbendCommonRecovery.exec();
    }

    private C_KahiKbn chkSyoriJyotai(String pSyoNo) {

        long sibouKariuketsukeCount = siharaiDomManager.getSibouKariuketsukeCountBySyono(pSyoNo);

        if (sibouKariuketsukeCount > 0) {

            return C_KahiKbn.HUKA;
        }

        BzGetProcessSummary bzGetProcessSummary = SWAKInjector.getInstance(BzGetProcessSummary.class);
        BzGetProcessSummaryInBean bzGetProcessSummaryInBean = SWAKInjector.getInstance(BzGetProcessSummaryInBean.class);
        BzGetProcessSummaryComparatorWorkListHyoujijun bzGetProcessSummaryComparatorWorkListHyoujijun =
            SWAKInjector.getInstance(BzGetProcessSummaryComparatorWorkListHyoujijun.class);

        bzGetProcessSummaryInBean.setSyoNo(pSyoNo);
        bzGetProcessSummaryInBean.setKouteiKanriStatuss(C_Kouteikanristatus.SYORITYUU);
        bzGetProcessSummaryInBean.setBzGetProcessSummaryComparator(bzGetProcessSummaryComparatorWorkListHyoujijun);

        List<BzGetProcessSummaryOutBean> bzGetProcessSummaryOutBeanLst = bzGetProcessSummary.exec(bzGetProcessSummaryInBean);

        for (BzGetProcessSummaryOutBean bzGetProcessSummaryOutBean : bzGetProcessSummaryOutBeanLst) {

            long kensuu = khSeisanDhaneiTuutiSksDao.getSyorijtkahiCount("khseisandhaneituutisks",
                bzGetProcessSummaryOutBean.getJimuTetuzukiCd(),bzGetProcessSummaryOutBean.getNowNodoId(), C_YuukoujyotaikahiKbn.HUKA);

            if (kensuu > 0) {

                return C_KahiKbn.HUKA;
            }

        }

        return C_KahiKbn.KA;
    }

    private void insertData(EntityInserter<ZT_SeisanDHaneiTuutiTy> pSeisanDHaneiTuutiTyIns,
        KhSeisanDhaneiTuutiSksBean pKhSeisanDhaneiTuutiSksBean,
        BzGetSosikiMadogutiInfoKekkaBean pBzGetSosikiMadogutiInfoKekkaBean, BizDate pSyoriYMD, Long pSeqNo) {

        C_HassouKbn hassouKbn = null;

        String rigiKbn = hanteiRigiKbn(pKhSeisanDhaneiTuutiSksBean);

        if (!BizUtil.isBlank(rigiKbn)) {

            hassouKbn = C_HassouKbn.HONSYAKAISOU;
        }
        else {

            hassouKbn = C_HassouKbn.TYOKUSOU;
        }

        String hrkkeiroKbn = henkanZtyhrkkeiroKbn(pKhSeisanDhaneiTuutiSksBean);

        String seqNo = henkanSakuseino(String.valueOf(pSeqNo));

        String ztySclatoSyono = henkanSyonoScramble(pKhSeisanDhaneiTuutiSksBean);

        ZT_SeisanDHaneiTuutiTy seisanDHaneiTuutiTy = new ZT_SeisanDHaneiTuutiTy(
            pSyoriYMD.toString(), pKhSeisanDhaneiTuutiSksBean.getSyono());

        seisanDHaneiTuutiTy.setZtysyoruicd(C_SyoruiCdKbn.KK_SEISANDHANEITUUTI.toString().toUpperCase());
        seisanDHaneiTuutiTy.setZtyhaitounendo(pKhSeisanDhaneiTuutiSksBean.getHaitounendo().toString());
        seisanDHaneiTuutiTy.setZtyhassoukbn(hassouKbn.getValue());
        seisanDHaneiTuutiTy.setZtyatesakiyno(pKhSeisanDhaneiTuutiSksBean.getTsinyno());
        seisanDHaneiTuutiTy.setZtyrigikbn(rigiKbn);
        seisanDHaneiTuutiTy.setZtyhrkkeiro(hrkkeiroKbn);
        seisanDHaneiTuutiTy.setZtysclatosyono(ztySclatoSyono);
        seisanDHaneiTuutiTy.setZtyatesakiadr1(pKhSeisanDhaneiTuutiSksBean.getTsinadr1kj());
        seisanDHaneiTuutiTy.setZtyatesakiadr2(pKhSeisanDhaneiTuutiSksBean.getTsinadr2kj());
        seisanDHaneiTuutiTy.setZtyatesakiadr3(pKhSeisanDhaneiTuutiSksBean.getTsinadr3kj());
        seisanDHaneiTuutiTy.setZtyatena1(pKhSeisanDhaneiTuutiSksBean.getKyknmkj());
        seisanDHaneiTuutiTy.setZtydai1syoukaisakifreearea1("【ご照会先】　" + pBzGetSosikiMadogutiInfoKekkaBean.getKanjisosikinm());
        seisanDHaneiTuutiTy.setZtydai1syoukaisakifreearea2("通話料無料　℡" + ConvertUtil.toZenAll(
            pBzGetSosikiMadogutiInfoKekkaBean.getTelno(), 0, 0));
        seisanDHaneiTuutiTy.setZtydai1syoukaisakifreearea4("〒" + ConvertUtil.toZenAll(
            pBzGetSosikiMadogutiInfoKekkaBean.getPostalCd(), 0, 0));
        seisanDHaneiTuutiTy.setZtydai1syoukaisakifreearea5(pBzGetSosikiMadogutiInfoKekkaBean.getKanjisosikiadr1() + "　" +
            pBzGetSosikiMadogutiInfoKekkaBean.getKanjisosikiadr2());
        seisanDHaneiTuutiTy.setZtysakunm(seqNo);
        seisanDHaneiTuutiTy.setZtysakuseiymdseireki(FixedDateFormatter.formatYMDZenkakuSeirekiKanji(pSyoriYMD));
        seisanDHaneiTuutiTy.setZtysyono(pKhSeisanDhaneiTuutiSksBean.getSyono());
        seisanDHaneiTuutiTy.setZtykykymdseireki(FixedDateFormatter.formatYMDZenkakuSeirekiKanji(pKhSeisanDhaneiTuutiSksBean.getKykymd()));
        seisanDHaneiTuutiTy.setZtyseisikihknnm(pKhSeisanDhaneiTuutiSksBean.getSyouhnnmsyouken());
        seisanDHaneiTuutiTy.setZtyhhknnmkj17(pKhSeisanDhaneiTuutiSksBean.getHhknnmkj());
        seisanDHaneiTuutiTy.setZtyfreearea37keta11("　いつもお引き立ていただきありがとうございます。");
        seisanDHaneiTuutiTy.setZtyfreearea37keta12("　さて、先般お引き出しの配当金は、昨年度の決算が未確定であ");
        seisanDHaneiTuutiTy.setZtyfreearea37keta13("ったため、仮に計算した金額（以下、「仮の配当金」とよびます）");
        seisanDHaneiTuutiTy.setZtyfreearea37keta14("でお手続きをさせていただいておりました。");
        seisanDHaneiTuutiTy.setZtyfreearea37keta15("　このたびの総代会において、決算が確定し、今年度の配当金が");
        seisanDHaneiTuutiTy.setZtyfreearea37keta16("決まりましたのでご連絡申し上げます。確定した配当金と仮の配");
        seisanDHaneiTuutiTy.setZtyfreearea37keta17("当金の差額は、所定の利息と共に来年度の積立配当金に繰入れ");
        seisanDHaneiTuutiTy.setZtyfreearea37keta18("させていただきます。");
        seisanDHaneiTuutiTy.setZtyfreearea37keta19("　なお、今年度中にこの差額のお引き出しを希望される場合は、");
        seisanDHaneiTuutiTy.setZtyfreearea37keta110("配当金請求書をご提出いただく必要がございますので、お手数で");
        seisanDHaneiTuutiTy.setZtyfreearea37keta111("すが、表面に掲載の＜ご照会先＞までお申し出いただくようお願");
        seisanDHaneiTuutiTy.setZtyfreearea37keta112("い申し上げます。");
        seisanDHaneiTuutiTy.setZtymidasi11("現在の配当金お受取方法");

        if (C_HaitoukinuketorihouKbn.TUMIHAI.eq(pKhSeisanDhaneiTuutiSksBean.getHaitoukinuketorihoukbn())) {

            seisanDHaneiTuutiTy.setZtytouduketorihouhou("積　　　立");
        }
        else {
            seisanDHaneiTuutiTy.setZtytouduketorihouhou("");
        }

        seisanDHaneiTuutiTy.setZtymidasi21("今年度配当金　Ａ");
        seisanDHaneiTuutiTy.setZtykakuteidkgk(
            ConvertUtil.toZenAll(pKhSeisanDhaneiTuutiSksBean.getKakuteitounendod().toFormatString(), 0, 0));
        seisanDHaneiTuutiTy.setZtymidasi31("仮の配当金　Ｂ");
        seisanDHaneiTuutiTy.setZtynaiteidkgk(
            ConvertUtil.toZenAll(pKhSeisanDhaneiTuutiSksBean.getNaiteitounendod().toFormatString(), 0, 0));
        seisanDHaneiTuutiTy.setZtymidasi41("Ａ－Ｂ　の差額");
        seisanDHaneiTuutiTy.setZtyseisandkgk(
            ConvertUtil.toZenAll(pKhSeisanDhaneiTuutiSksBean.getSeisandkgk().toFormatString(), 0, 0));
        seisanDHaneiTuutiTy.setZtyfreearea21("ご照会、ご連絡は、表面に掲載の＜ご照会先＞へお申し出ください。");

        BizPropertyInitializer.initialize(seisanDHaneiTuutiTy);

        pSeisanDHaneiTuutiTyIns.add(seisanDHaneiTuutiTy);
    }


    private String hanteiRigiKbn(KhSeisanDhaneiTuutiSksBean pKhSeisanDhaneiTuutiSksBean) {

        String rigiKbn = "";

        if (C_KktyuitaKbn.DNGNMEMOARI.eq(pKhSeisanDhaneiTuutiSksBean.getKktyuitakbn())) {

            rigiKbn = "A";
        }
        else if (C_TtdktyuuiKbn.ADRHUMEI.eq(pKhSeisanDhaneiTuutiSksBean.getTtdktyuuikbn1()) ||
            C_TtdktyuuiKbn.ADRHUMEI.eq(pKhSeisanDhaneiTuutiSksBean.getTtdktyuuikbn2()) ||
            C_TtdktyuuiKbn.ADRHUMEI.eq(pKhSeisanDhaneiTuutiSksBean.getTtdktyuuikbn3()) ||
            C_TtdktyuuiKbn.ADRHUMEI.eq(pKhSeisanDhaneiTuutiSksBean.getTtdktyuuikbn4()) ||
            C_TtdktyuuiKbn.ADRHUMEI.eq(pKhSeisanDhaneiTuutiSksBean.getTtdktyuuikbn5())) {

            rigiKbn = "B";
        }
        else {

            rigiKbn = "";
        }

        return rigiKbn;
    }

    private String henkanZtyhrkkeiroKbn(KhSeisanDhaneiTuutiSksBean pKhSeisanDhaneiTuutiSksBean) {

        String hrkkeiroKbn = "";
        BzKbnHenkanUtil bzKbnHenkanUtil = SWAKInjector.getInstance(BzKbnHenkanUtil.class);

        KbnInfoBean kbnInfoBean = bzKbnHenkanUtil.convKbn(pKhSeisanDhaneiTuutiSksBean.getHrkkeiro().getValue(),
            C_Hrkkeiro.class, C_SystemRenkeiHenkanHoukouKbn.RAY_TO_OTHER);

        if (kbnInfoBean.isHenkanFlg()) {

            hrkkeiroKbn = kbnInfoBean.getKbnData();
        }
        else {
            throw new CommonBizAppException(MessageUtil.getMessage(
                MessageId.EIA1046,
                "払込経路",
                pKhSeisanDhaneiTuutiSksBean.getHrkkeiro().getValue()));
        }

        return hrkkeiroKbn;
    }

    private String henkanSakuseino(String pSeqNo) {

        return BizUtil.zeroNum(pSeqNo, 7, 0);
    }

    private String henkanSyonoScramble(KhSeisanDhaneiTuutiSksBean pKhSeisanDhaneiTuutiSksBean) {

        String syono = pKhSeisanDhaneiTuutiSksBean.getSyono().substring(3, 11) +
            pKhSeisanDhaneiTuutiSksBean.getSyono().substring(0, 3);

        return syono;
    }

}
