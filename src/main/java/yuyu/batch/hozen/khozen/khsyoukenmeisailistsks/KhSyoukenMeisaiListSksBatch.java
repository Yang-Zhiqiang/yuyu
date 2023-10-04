package yuyu.batch.hozen.khozen.khsyoukenmeisailistsks;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.batch.annotation.AppBatchExceptionTerminate;
import jp.co.slcs.swak.batch.annotation.Execute;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.db.EntityInserter;
import jp.co.slcs.swak.db.ExDBResults;
import jp.co.slcs.swak.util.message.MessageUtil;
import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.common.biz.bzcommon.BzBatchAbendCommonRecovery;
import yuyu.common.biz.bzcommon.BzBatchParam;
import yuyu.common.biz.bzcommon.BzGetSosikiData;
import yuyu.common.biz.bzcommon.BzGetSosikiDataBean;
import yuyu.common.biz.bzcommon.DateFormatUtil;
import yuyu.common.biz.report.ViewReport;
import yuyu.def.MessageId;
import yuyu.def.base.detacher.AM_UserDetacher;
import yuyu.def.base.manager.BaseDomManager;
import yuyu.def.biz.bean.param.BzRecoveryDatasikibetuBean;
import yuyu.def.biz.detacher.BM_TantouCdDetacher;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_KjkhukaKbn;
import yuyu.def.classification.C_SinsaihkKbn;
import yuyu.def.classification.C_SosikimasterUmuKbn;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.classification.C_SyoukensaihkKbn;
import yuyu.def.classification.C_TantouCdKbn;
import yuyu.def.classification.C_TokusyuSyoriNaiyouKbn;
import yuyu.def.classification.C_UktKbn;
import yuyu.def.classification.C_UktsyuKbn;
import yuyu.def.db.entity.AM_User;
import yuyu.def.db.entity.AS_Kinou;
import yuyu.def.db.entity.BM_TantouCd;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.IT_KykUkt;
import yuyu.def.db.entity.ZT_SyoukenTkListShTy;
import yuyu.def.db.entity.ZT_SyoukenTkListSkTy;
import yuyu.def.hozen.bean.report.KhSyoukenmeisaiListBean;
import yuyu.def.hozen.bean.report.KhSyoukenmeisaiListDataSourceBean;
import yuyu.def.hozen.detacher.IT_KykKihonDetacher;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.def.hozen.result.bean.SyoukenSkseiKyMeisaiListInfosByKakutyoujobcdItemsBean;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.BatchParam;
import yuyu.infr.batch.logger.BatchLogger;
import yuyu.infr.report.CreateReport;
import yuyu.infr.report.swakreport.IReportDataSouceBean;
import yuyu.infr.report.swakreport.ReportServicesBean;

/**
 * 契約保全 契約保全 証券明細リスト作成
 */
public class KhSyoukenMeisaiListSksBatch implements Batch {

    @Inject
    private BatchLogger batchLogger;

    @Inject
    private BzBatchParam bzBatchParam;

    @Inject
    private HozenDomManager hozenDomManager;

    @Inject
    private BizDomManager bizDomManager;

    @Inject
    private BaseDomManager baseDomManager;

    @Inject
    private AS_Kinou kinou;

    @Inject
    private CreateReport createReport;

    @Inject
    private BzRecoveryDatasikibetuBean bzRecoveryDatasikibetuBean;

    private static final String TYSYTTAISYOUTABLEID = "IT_KykKihon";

    private static final String RECOVERYFILTERID = "Kh001";

    private static final String BATCHSYSTEM = "BatchSystem";

    @Override
    public BatchParam getParam() {
        return bzBatchParam;
    }

    @Execute
    @Transactional
    public void execute() {

        Long skSyoukenSakuseiKensuu = 0L;

        Long skjikoKensuu = 0L;

        Long syoukenSakuseiKensuu = 0L;

        Long jikoKensuu = 0L;

        String tysytYmd = DateFormatUtil.dateKANJINoEx(bzBatchParam.getSyoriYmd());

        String tysyCompleteYmd = String.valueOf(bzBatchParam.getSyoriYmd());

        ReportServicesBean reportServicesBean = createReport.createNewReportServiceBean(
            kinou.getSubSystemId(),
            kinou.getCategoryId(),
            kinou.getKinouId(),
            C_SyoruiCdKbn.KK_SYOUKENMS_SKEI);

        BM_TantouCd bmTantouCd = bizDomManager.getTantouCd(C_TantouCdKbn.DAIRITENJIMUKANRI);

        bmTantouCd = BM_TantouCdDetacher.detachTantouCdtouched(bmTantouCd);

        String busituCd = bmTantouCd.getBusitucd();

        BzGetSosikiData bzGetSosikiData = SWAKInjector.getInstance(BzGetSosikiData.class);

        BzGetSosikiDataBean bzGetSosikiDataBean = bzGetSosikiData.exec(busituCd + "0000");

        String busitunm = "";

        if (C_SosikimasterUmuKbn.ARI.eq(bzGetSosikiDataBean.getSosikimasterumukbn())){

            busitunm = bzGetSosikiDataBean.getKanjisosikinm20();

        }

        String hozonkkn = ViewReport.getHozonKknTani(C_SyoruiCdKbn.KK_SYOUKENMS_SKEI);

        KhSyoukenmeisaiListBean khSyoukenmeisaiListBean = SWAKInjector.getInstance(KhSyoukenmeisaiListBean.class);
        khSyoukenmeisaiListBean.setIrTantsitunmkj(busitunm);
        khSyoukenmeisaiListBean.setIrTyouhyousakuseiymdwareki(tysytYmd);
        khSyoukenmeisaiListBean.setIrHozonkkn(hozonkkn);

        String hozonKikanSkei = ViewReport.getHozonKknTani(C_SyoruiCdKbn.KK_SYOUKENTOKUSYU_SKEI);

        C_SyoruiCdKbn cSyoruiCdKbn = C_SyoruiCdKbn.KK_SYOUKENTOKUSYU_SKEI;

        ReportServicesBean reportServicesBeanRetry = createReport.createNewReportServiceBean(
            kinou.getSubSystemId(),
            kinou.getCategoryId(),
            kinou.getKinouId(),
            C_SyoruiCdKbn.KK_SYOUKENMS_SAI);


        BM_TantouCd bmTantouCdRetry = bizDomManager.getTantouCd(C_TantouCdKbn.MEIGIHENKOU);

        bmTantouCdRetry = BM_TantouCdDetacher.detachTantouCdtouched(bmTantouCdRetry);

        String busituCdSai = bmTantouCdRetry.getBusitucd();

        BzGetSosikiDataBean bzGetSosikiDataBeanRetry = bzGetSosikiData.exec(busituCdSai + "0000");

        String busitunmSai = "";

        if (C_SosikimasterUmuKbn.ARI.eq(bzGetSosikiDataBeanRetry.getSosikimasterumukbn())){

            busitunmSai = bzGetSosikiDataBeanRetry.getKanjisosikinm20();

        }

        String hozonkknSai = ViewReport.getHozonKknTani(C_SyoruiCdKbn.KK_SYOUKENMS_SAI);

        KhSyoukenmeisaiListBean khSyoukenmeisaiListBeanSai = SWAKInjector.getInstance(KhSyoukenmeisaiListBean.class);

        khSyoukenmeisaiListBeanSai.setIrTantsitunmkj(busitunmSai);
        khSyoukenmeisaiListBeanSai.setIrTyouhyousakuseiymdwareki(tysytYmd);
        khSyoukenmeisaiListBeanSai.setIrHozonkkn(hozonkknSai);

        String hozonKikanSai = ViewReport.getHozonKknTani(C_SyoruiCdKbn.KK_SYOUKENTOKUSYU_SAI);

        C_SyoruiCdKbn cSyoruiCdKbnSai = C_SyoruiCdKbn.KK_SYOUKENTOKUSYU_SAI;

        List<IReportDataSouceBean>  khSyoukenmeisaiListBeanList = new ArrayList<>();

        List<IReportDataSouceBean> khSyoukenmeisaiListBeanListRetry = new ArrayList<>();

        try(ExDBResults<SyoukenSkseiKyMeisaiListInfosByKakutyoujobcdItemsBean> syoukenBeanList =
            hozenDomManager.getSyoukenSkseiKyMeisaiListInfosByKakutyoujobcdItemsBean(
                bzBatchParam.getIbKakutyoujobcd(), bzBatchParam.getSyoriYmd());
            EntityInserter<ZT_SyoukenTkListSkTy> zTSyoukenTkListSkTyInserter = new  EntityInserter<>();
            EntityInserter<ZT_SyoukenTkListShTy> zTSyoukenTkListShTyInserter = new  EntityInserter<>()) {

            Iterator<SyoukenSkseiKyMeisaiListInfosByKakutyoujobcdItemsBean> SyoukenIter =
                syoukenBeanList.iterator();

            while (SyoukenIter.hasNext()) {

                SyoukenSkseiKyMeisaiListInfosByKakutyoujobcdItemsBean syoukenBean = SyoukenIter.next();


                bzRecoveryDatasikibetuBean.setIbKakutyoujobcd(bzBatchParam.getIbKakutyoujobcd());
                bzRecoveryDatasikibetuBean.setIbTableid(TYSYTTAISYOUTABLEID);
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterid(RECOVERYFILTERID);
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterkey1(syoukenBean.getIT_KykKihon().getKbnkey());
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterkey2(syoukenBean.getIT_KykKihon().getSyono());

                if(C_SinsaihkKbn.SIN.eq(syoukenBean.getSinsaihkkbn())  ||
                    (C_SinsaihkKbn.SAI.eq(syoukenBean.getSinsaihkkbn()) &&
                        C_SyoukensaihkKbn.SINKEIYAKUSAISAKUSEI.eq(
                            syoukenBean.getSyoukensaihkkbn()))) {

                    KhSyoukenmeisaiListDataSourceBean khSyoukenmeisaiListDataSourceBean =
                        SWAKInjector.getInstance(KhSyoukenmeisaiListDataSourceBean.class);

                    khSyoukenmeisaiListDataSourceBean.setIrSyono(syoukenBean.getSyono());
                    khSyoukenmeisaiListDataSourceBean.setIrKyknmkj(syoukenBean.getIT_KykSya().getKyknmkj());
                    khSyoukenmeisaiListDataSourceBean.setIrHhknnmkj(syoukenBean.getIT_HhknSya().getHhknnmkj());
                    khSyoukenmeisaiListDataSourceBean.setIrSinsaihkkbn(
                        syoukenBean.getSinsaihkkbn());
                    khSyoukenmeisaiListDataSourceBean.setIrSyoukensaihkkbn(
                        syoukenBean.getSyoukensaihkkbn());
                    khSyoukenmeisaiListDataSourceBean.setIrSyokensakuseiymdwareki(tysytYmd);
                    khSyoukenmeisaiListDataSourceBean.setIrHassoukbn(syoukenBean.getHassoukbn());

                    khSyoukenmeisaiListBeanList.add(khSyoukenmeisaiListDataSourceBean);

                    skSyoukenSakuseiKensuu ++;

                    List<C_TokusyuSyoriNaiyouKbn> specialList = new ArrayList<>();

                    List<String> specialListTranslate = new ArrayList<>();

                    if(!(C_TokusyuSyoriNaiyouKbn.BLNK.
                        eq(syoukenBean.getTokusyusyorinaiyoukbn1()))) {

                        String hhknnmkj = syoukenBean.getIT_HhknSya().getHhknnmkj();
                        String reversePre = "";
                        String reverseLat = "";
                        String syono = syoukenBean.getIT_HhknSya().getSyono();
                        String busituCdToKuSyoRi = "";
                        String busitunmToKuSyoRi = "";
                        String sagyouKbn = "2";
                        String yakkanbunsyoNo = syoukenBean.getYakkanbunsyono();

                        if(!(C_TokusyuSyoriNaiyouKbn.BLNK.
                            eq(syoukenBean.getTokusyusyorinaiyoukbn1()))) {
                            specialList.add(syoukenBean.getTokusyusyorinaiyoukbn1());
                        }

                        if(!(C_TokusyuSyoriNaiyouKbn.BLNK.
                            eq(syoukenBean.getTokusyusyorinaiyoukbn2()))) {
                            specialList.add(syoukenBean.getTokusyusyorinaiyoukbn2());
                        }

                        if(!(C_TokusyuSyoriNaiyouKbn.BLNK.
                            eq(syoukenBean.getTokusyusyorinaiyoukbn3()))) {
                            specialList.add(syoukenBean.getTokusyusyorinaiyoukbn3());
                        }

                        if(!(C_TokusyuSyoriNaiyouKbn.BLNK.
                            eq(syoukenBean.getTokusyusyorinaiyoukbn4()))) {
                            specialList.add(syoukenBean.getTokusyusyorinaiyoukbn4());
                        }

                        if(!(C_TokusyuSyoriNaiyouKbn.BLNK.
                            eq(syoukenBean.getTokusyusyorinaiyoukbn5()))) {
                            specialList.add(syoukenBean.getTokusyusyorinaiyoukbn5());
                        }

                        if(!(C_TokusyuSyoriNaiyouKbn.BLNK.
                            eq(syoukenBean.getTokusyusyorinaiyoukbn6()))) {
                            specialList.add(syoukenBean.getTokusyusyorinaiyoukbn6());
                        }

                        if(!(C_TokusyuSyoriNaiyouKbn.BLNK.
                            eq(syoukenBean.getTokusyusyorinaiyoukbn7()))) {
                            specialList.add(syoukenBean.getTokusyusyorinaiyoukbn7());
                        }

                        if(!(C_TokusyuSyoriNaiyouKbn.BLNK.
                            eq(syoukenBean.getTokusyusyorinaiyoukbn8()))) {
                            specialList.add(syoukenBean.getTokusyusyorinaiyoukbn8());
                        }

                        if(!(C_TokusyuSyoriNaiyouKbn.BLNK.
                            eq(syoukenBean.getTokusyusyorinaiyoukbn9()))) {
                            specialList.add(syoukenBean.getTokusyusyorinaiyoukbn9());
                        }

                        if(!(C_TokusyuSyoriNaiyouKbn.BLNK.
                            eq(syoukenBean.getTokusyusyorinaiyoukbn10()))) {
                            specialList.add(syoukenBean.getTokusyusyorinaiyoukbn10());
                        }

                        if(!(C_TokusyuSyoriNaiyouKbn.BLNK.
                            eq(syoukenBean.getTokusyusyorinaiyoukbn11()))) {
                            specialList.add(syoukenBean.getTokusyusyorinaiyoukbn11());
                        }

                        if(!(C_TokusyuSyoriNaiyouKbn.BLNK.
                            eq(syoukenBean.getTokusyusyorinaiyoukbn12()))) {
                            specialList.add(syoukenBean.getTokusyusyorinaiyoukbn12());
                        }

                        if(!(C_TokusyuSyoriNaiyouKbn.BLNK.
                            eq(syoukenBean.getTokusyusyorinaiyoukbn13()))) {
                            specialList.add(syoukenBean.getTokusyusyorinaiyoukbn13());
                        }

                        if(!(C_TokusyuSyoriNaiyouKbn.BLNK.
                            eq(syoukenBean.getTokusyusyorinaiyoukbn14()))) {
                            specialList.add(syoukenBean.getTokusyusyorinaiyoukbn14());
                        }

                        bmTantouCd = bizDomManager.getTantouCd(syoukenBean.getTantocd());

                        bmTantouCd = BM_TantouCdDetacher.detachTantouCdtouched(bmTantouCd);

                        busituCdToKuSyoRi = bmTantouCd.getBusitucd();

                        bzGetSosikiData = SWAKInjector.getInstance(BzGetSosikiData.class);

                        bzGetSosikiDataBean = bzGetSosikiData.exec(busituCdToKuSyoRi + "0000");

                        if (C_SosikimasterUmuKbn.ARI.eq(bzGetSosikiDataBean.getSosikimasterumukbn())){

                            busitunmToKuSyoRi = bzGetSosikiDataBean.getKanjisosikinm20();

                        }

                        for(C_TokusyuSyoriNaiyouKbn cTokusyuSyoriNaiyouKbn : specialList) {

                            specialListTranslate.add(
                                C_TokusyuSyoriNaiyouKbn.getContentByValue(C_TokusyuSyoriNaiyouKbn.PATTERN_SINKI,
                                    cTokusyuSyoriNaiyouKbn.getValue()));

                            if(C_TokusyuSyoriNaiyouKbn.SBUKKANJIMEINASI_FUKUSUU.eq(cTokusyuSyoriNaiyouKbn)) {

                                IT_KykKihon iTKykKihon = hozenDomManager.getKykKihon(syono);

                                iTKykKihon = IT_KykKihonDetacher.detachKykUkttouched(iTKykKihon);

                                List<IT_KykUkt> IT_KykUktList = iTKykKihon.getKykUktsByUktsyukbn(C_UktsyuKbn.SBUKT);

                                int deathReciveCount = 0;

                                for (IT_KykUkt kykUkt : IT_KykUktList) {
                                    if (C_UktKbn.TOKUTEIMEIGI.eq(kykUkt.getUktkbn()) && C_KjkhukaKbn.KJKHUKA.eq(kykUkt.getUktnmkjkhukakbn())){
                                        deathReciveCount = deathReciveCount + 1;
                                    }
                                }

                                specialListTranslate.set(specialListTranslate.size() - 1,
                                    specialListTranslate.get(specialListTranslate.size() - 1).
                                    replace("＠", String.valueOf(deathReciveCount)));

                            }

                            if(C_TokusyuSyoriNaiyouKbn.SBUKFUKUSUU.eq(cTokusyuSyoriNaiyouKbn)) {

                                int deathReciveCount = 0;
                                if (syoukenBean.getIT_KykKihon().getSbuktnin() >= 5) {
                                    deathReciveCount = syoukenBean.getIT_KykKihon().getSbuktnin();
                                }

                                specialListTranslate.set(specialListTranslate.size() - 1,
                                    specialListTranslate.get(specialListTranslate.size() - 1).
                                    replace("＠", String.valueOf(deathReciveCount))) ;

                            }
                        }

                        if(!(C_TokusyuSyoriNaiyouKbn.BLNK.
                            eq(syoukenBean.getTokusyusyorinaiyoukbn15()))) {

                            reversePre = "その他あり";

                            reverseLat = "／宛先／に確認要";
                        }

                        for (C_TokusyuSyoriNaiyouKbn cTokusyuSyoriNaiyouKbn : specialList) {
                            if (C_TokusyuSyoriNaiyouKbn.HHKNKANJIMEINASI.eq(cTokusyuSyoriNaiyouKbn)
                                || C_TokusyuSyoriNaiyouKbn.KYKKANJIMEINASI.eq(cTokusyuSyoriNaiyouKbn)
                                || C_TokusyuSyoriNaiyouKbn.SBUKKANJIMEINASI_FUKUSUU.eq(cTokusyuSyoriNaiyouKbn)
                                || C_TokusyuSyoriNaiyouKbn.SBUKKANJIMEINASI.eq(cTokusyuSyoriNaiyouKbn)
                                || C_TokusyuSyoriNaiyouKbn.KYKDRNINKANJIMEINASI.eq(cTokusyuSyoriNaiyouKbn)
                                || C_TokusyuSyoriNaiyouKbn.STDRNINKANJIMEINASI.eq(cTokusyuSyoriNaiyouKbn)
                                || C_TokusyuSyoriNaiyouKbn.KANJIADRNASI.eq(cTokusyuSyoriNaiyouKbn)
                                || C_TokusyuSyoriNaiyouKbn.SBUKFUKUSUU.eq(cTokusyuSyoriNaiyouKbn)
                                || C_TokusyuSyoriNaiyouKbn.SBUKBNWARINASI.eq(cTokusyuSyoriNaiyouKbn)
                                || C_TokusyuSyoriNaiyouKbn.TTDKTYUUI_DNGNMEMOARI.eq(cTokusyuSyoriNaiyouKbn)
                                || C_TokusyuSyoriNaiyouKbn.STKNSETARI.eq(cTokusyuSyoriNaiyouKbn)
                                || C_TokusyuSyoriNaiyouKbn.TTDKTYUUI_ADRKAKUNINUKE.eq(cTokusyuSyoriNaiyouKbn)
                                || C_TokusyuSyoriNaiyouKbn.TTDKTYUUI_ADRHUMEI.eq(cTokusyuSyoriNaiyouKbn)
                                || C_TokusyuSyoriNaiyouKbn.KARIUKEKEIJOARI.eq(cTokusyuSyoriNaiyouKbn)
                                || C_TokusyuSyoriNaiyouKbn.DAIRITENMEIMOJISUUTYOUKA.eq(cTokusyuSyoriNaiyouKbn)
                                || C_TokusyuSyoriNaiyouKbn.HONBANKAKUNINTAISYO.eq(cTokusyuSyoriNaiyouKbn)) {
                                sagyouKbn = "1";
                                break;
                            }
                        }

                        ZT_SyoukenTkListSkTy zTSyoukenTkListSkTy
                        = SWAKInjector.getInstance(ZT_SyoukenTkListSkTy.class);

                        zTSyoukenTkListSkTy.setZtysyoruicd(cSyoruiCdKbn.toString().toUpperCase());
                        zTSyoukenTkListSkTy.setZtytyouhyouymd(tysyCompleteYmd);
                        zTSyoukenTkListSkTy.setZtyhassoukbn("");
                        zTSyoukenTkListSkTy.setZtyatesakitantnm(busitunmToKuSyoRi);
                        zTSyoukenTkListSkTy.setZtyhozonkkn(hozonKikanSkei);
                        zTSyoukenTkListSkTy.setZtytyouhyouymdwa(tysytYmd);
                        zTSyoukenTkListSkTy.setZtysagyoukbn(sagyouKbn);
                        zTSyoukenTkListSkTy.setZtyyobiv25("");
                        zTSyoukenTkListSkTy.setZtysyono(syono);
                        zTSyoukenTkListSkTy.setZtyhhknnmkj(hhknnmkj);
                        if(specialListTranslate.size() > 0) {
                            zTSyoukenTkListSkTy.setZtytksysyorinaiyou1(specialListTranslate.get(0));
                        }
                        if(specialListTranslate.size() > 1 ) {
                            zTSyoukenTkListSkTy.setZtytksysyorinaiyou2(specialListTranslate.get(1));
                        }
                        if(specialListTranslate.size() > 2) {
                            zTSyoukenTkListSkTy.setZtytksysyorinaiyou3(specialListTranslate.get(2));
                        }
                        if(specialListTranslate.size() > 3) {
                            zTSyoukenTkListSkTy.setZtytksysyorinaiyou4(specialListTranslate.get(3));
                        }
                        if(specialListTranslate.size() > 4) {
                            zTSyoukenTkListSkTy.setZtytksysyorinaiyou5(specialListTranslate.get(4));
                        }
                        if(specialListTranslate.size() > 5) {
                            zTSyoukenTkListSkTy.setZtytksysyorinaiyou6(specialListTranslate.get(5));
                        }
                        if(specialListTranslate.size() > 6) {
                            zTSyoukenTkListSkTy.setZtytksysyorinaiyou7(specialListTranslate.get(6));
                        }
                        if(specialListTranslate.size() > 7) {
                            zTSyoukenTkListSkTy.setZtytksysyorinaiyou8(specialListTranslate.get(7));
                        }
                        if(specialListTranslate.size() > 8) {
                            zTSyoukenTkListSkTy.setZtytksysyorinaiyou9(specialListTranslate.get(8));
                        }
                        if(specialListTranslate.size() > 9) {
                            zTSyoukenTkListSkTy.setZtytksysyorinaiyou10(specialListTranslate.get(9));
                        }
                        if(specialListTranslate.size() > 10) {
                            zTSyoukenTkListSkTy.setZtytksysyorinaiyou11(specialListTranslate.get(10));
                        }
                        if(specialListTranslate.size() > 11) {
                            zTSyoukenTkListSkTy.setZtytksysyorinaiyou12(specialListTranslate.get(11));
                        }
                        if(specialListTranslate.size() >12) {
                            zTSyoukenTkListSkTy.setZtytksysyorinaiyou13(specialListTranslate.get(12));
                        }
                        if(specialListTranslate.size() > 13) {
                            zTSyoukenTkListSkTy.setZtytksysyorinaiyou14(specialListTranslate.get(13));
                        }
                        zTSyoukenTkListSkTy.setZtybikouupside(reversePre);
                        zTSyoukenTkListSkTy.setZtybikoudownside(reverseLat);
                        zTSyoukenTkListSkTy.setZtyyakkanbunsyono(yakkanbunsyoNo);
                        zTSyoukenTkListSkTy.setZtyyobiv21("");

                        BizPropertyInitializer.initialize(zTSyoukenTkListSkTy);

                        zTSyoukenTkListSkTyInserter.add(zTSyoukenTkListSkTy);

                        skjikoKensuu ++;

                    }
                }

                if(C_SinsaihkKbn.SAI.eq(syoukenBean.getSinsaihkkbn())&&
                    C_SyoukensaihkKbn.SYOUKENSAIHAKKOU.eq((syoukenBean.getSyoukensaihkkbn()))) {

                    KhSyoukenmeisaiListDataSourceBean khSyoukenmeisaiListDataSourceBeanRetry =
                        SWAKInjector.getInstance(KhSyoukenmeisaiListDataSourceBean.class);
                    khSyoukenmeisaiListDataSourceBeanRetry.setIrSyono(syoukenBean.getSyono());
                    khSyoukenmeisaiListDataSourceBeanRetry.setIrKyknmkj(syoukenBean.getIT_KykSya().getKyknmkj());
                    khSyoukenmeisaiListDataSourceBeanRetry.setIrHhknnmkj(syoukenBean.getIT_HhknSya().getHhknnmkj());
                    khSyoukenmeisaiListDataSourceBeanRetry.setIrSinsaihkkbn(
                        syoukenBean.getSinsaihkkbn());
                    khSyoukenmeisaiListDataSourceBeanRetry.setIrSyoukensaihkkbn(
                        syoukenBean.getSyoukensaihkkbn());
                    khSyoukenmeisaiListDataSourceBeanRetry.setIrSyokensakuseiymdwareki(tysytYmd);
                    khSyoukenmeisaiListDataSourceBeanRetry.
                    setIrHassoukbn(syoukenBean.getHassoukbn());

                    khSyoukenmeisaiListBeanListRetry.add(khSyoukenmeisaiListDataSourceBeanRetry);

                    syoukenSakuseiKensuu ++;

                    List<C_TokusyuSyoriNaiyouKbn> afterRetryList = new ArrayList<>();

                    List<String> afterRetryListTranslate = new ArrayList<>();

                    if(!(C_TokusyuSyoriNaiyouKbn.BLNK.
                        eq(syoukenBean.getTokusyusyorinaiyoukbn1()))) {

                        AM_User aMUser = baseDomManager.
                            getUser(syoukenBean.getGyoumuKousinsyaId());

                        aMUser = AM_UserDetacher.detachUsertouched(aMUser);

                        AS_Kinou aKinou = baseDomManager.getKinou(syoukenBean.getGyoumuKousinKinou());

                        String kyknmkj = syoukenBean.getIT_KykSya().getKyknmkj();
                        String hhknnmkj = syoukenBean.getIT_HhknSya().getHhknnmkj();
                        String kinouNm=  aKinou.getKinouNm();
                        String syoriSyouninsyaCd = syoukenBean
                            .getGyoumuKousinsyaId().substring(2, 8);
                        if(BATCHSYSTEM.equals(syoukenBean.getGyoumuKousinsyaId())){
                            syoriSyouninsyaCd = "";
                        }
                        String userNm = aMUser.getUserNm();
                        String syono = syoukenBean.getSyono();
                        String busituCdSaiToKuSyoRi = "";
                        String busitunmSaiToKuSyoRi = "";

                        if(!(C_TokusyuSyoriNaiyouKbn.BLNK.
                            eq(syoukenBean.getTokusyusyorinaiyoukbn1()))) {
                            afterRetryList.add(syoukenBean.getTokusyusyorinaiyoukbn1());
                        }

                        if(!(C_TokusyuSyoriNaiyouKbn.BLNK.
                            eq(syoukenBean.getTokusyusyorinaiyoukbn2()))) {
                            afterRetryList.add(syoukenBean.getTokusyusyorinaiyoukbn2());
                        }

                        if(!(C_TokusyuSyoriNaiyouKbn.BLNK.
                            eq(syoukenBean.getTokusyusyorinaiyoukbn3()))) {
                            afterRetryList.add(syoukenBean.getTokusyusyorinaiyoukbn3());
                        }

                        if(!(C_TokusyuSyoriNaiyouKbn.BLNK.
                            eq(syoukenBean.getTokusyusyorinaiyoukbn4()))) {
                            afterRetryList.add(syoukenBean.getTokusyusyorinaiyoukbn4());
                        }

                        if(!(C_TokusyuSyoriNaiyouKbn.BLNK.
                            eq(syoukenBean.getTokusyusyorinaiyoukbn5()))) {
                            afterRetryList.add(syoukenBean.getTokusyusyorinaiyoukbn5());
                        }

                        if(!(C_TokusyuSyoriNaiyouKbn.BLNK.
                            eq(syoukenBean.getTokusyusyorinaiyoukbn6()))) {
                            afterRetryList.add(syoukenBean.getTokusyusyorinaiyoukbn6());
                        }

                        if(!(C_TokusyuSyoriNaiyouKbn.BLNK.
                            eq(syoukenBean.getTokusyusyorinaiyoukbn7()))) {
                            afterRetryList.add(syoukenBean.getTokusyusyorinaiyoukbn7());
                        }

                        if(!(C_TokusyuSyoriNaiyouKbn.BLNK.
                            eq(syoukenBean.getTokusyusyorinaiyoukbn8()))) {
                            afterRetryList.add(syoukenBean.getTokusyusyorinaiyoukbn8());
                        }

                        if(!(C_TokusyuSyoriNaiyouKbn.BLNK.
                            eq(syoukenBean.getTokusyusyorinaiyoukbn9()))) {
                            afterRetryList.add(syoukenBean.getTokusyusyorinaiyoukbn9());
                        }

                        if(!(C_TokusyuSyoriNaiyouKbn.BLNK.
                            eq(syoukenBean.getTokusyusyorinaiyoukbn10()))) {
                            afterRetryList.add(syoukenBean.getTokusyusyorinaiyoukbn10());
                        }

                        if(!(C_TokusyuSyoriNaiyouKbn.BLNK.
                            eq(syoukenBean.getTokusyusyorinaiyoukbn11()))) {
                            afterRetryList.add(syoukenBean.getTokusyusyorinaiyoukbn11());
                        }

                        if(!(C_TokusyuSyoriNaiyouKbn.BLNK.
                            eq(syoukenBean.getTokusyusyorinaiyoukbn12()))) {
                            afterRetryList.add(syoukenBean.getTokusyusyorinaiyoukbn12());
                        }

                        if(!(C_TokusyuSyoriNaiyouKbn.BLNK.
                            eq(syoukenBean.getTokusyusyorinaiyoukbn13()))) {
                            afterRetryList.add(syoukenBean.getTokusyusyorinaiyoukbn13());
                        }

                        if(!(C_TokusyuSyoriNaiyouKbn.BLNK.
                            eq(syoukenBean.getTokusyusyorinaiyoukbn14()))) {
                            afterRetryList.add(syoukenBean.getTokusyusyorinaiyoukbn14());
                        }
                        if(!(C_TokusyuSyoriNaiyouKbn.BLNK.
                            eq(syoukenBean.getTokusyusyorinaiyoukbn15()))) {
                            afterRetryList.add(syoukenBean.getTokusyusyorinaiyoukbn15());
                        }

                        if(!(C_TokusyuSyoriNaiyouKbn.BLNK.
                            eq(syoukenBean.getTokusyusyorinaiyoukbn16()))) {
                            afterRetryList.add(syoukenBean.getTokusyusyorinaiyoukbn16());
                        }

                        bmTantouCdRetry = bizDomManager.getTantouCd(syoukenBean.getTantocd());

                        bmTantouCdRetry = BM_TantouCdDetacher.detachTantouCdtouched(bmTantouCdRetry);

                        busituCdSaiToKuSyoRi = bmTantouCdRetry.getBusitucd();

                        bzGetSosikiDataBeanRetry = bzGetSosikiData.exec(busituCdSaiToKuSyoRi + "0000");

                        if (C_SosikimasterUmuKbn.ARI.eq(bzGetSosikiDataBeanRetry.getSosikimasterumukbn())){

                            busitunmSaiToKuSyoRi = bzGetSosikiDataBeanRetry.getKanjisosikinm20();

                        }

                        for(C_TokusyuSyoriNaiyouKbn cTokusyuSyoriNaiyouKbn : afterRetryList) {

                            afterRetryListTranslate.
                            add(C_TokusyuSyoriNaiyouKbn.getContentByValue(C_TokusyuSyoriNaiyouKbn.PATTERN_SAIHAKKOU,
                                cTokusyuSyoriNaiyouKbn.getValue()));

                            if(cTokusyuSyoriNaiyouKbn.eq(C_TokusyuSyoriNaiyouKbn.SBUKFUKUSUU)) {

                                int deathReciveCount = 0;
                                if (syoukenBean.getIT_KykKihon().getSbuktnin() >= 5) {
                                    deathReciveCount = syoukenBean.getIT_KykKihon().getSbuktnin();
                                }

                                afterRetryListTranslate.set(afterRetryListTranslate.size() - 1 ,
                                    afterRetryListTranslate.get(afterRetryListTranslate.size() - 1).
                                    replace("＠", String.valueOf(deathReciveCount)));

                            }
                        }

                        ZT_SyoukenTkListShTy zTSyoukenTkListShTy =
                            SWAKInjector.getInstance(ZT_SyoukenTkListShTy.class);

                        zTSyoukenTkListShTy.setZtysyoruicd(cSyoruiCdKbnSai.toString().toUpperCase());
                        zTSyoukenTkListShTy.setZtytyouhyouymd(tysyCompleteYmd);
                        zTSyoukenTkListShTy.setZtyhassoukbn("");
                        zTSyoukenTkListShTy.setZtyatesakitantnm(busitunmSaiToKuSyoRi);
                        zTSyoukenTkListShTy.setZtyhozonkkn(hozonKikanSai);
                        zTSyoukenTkListShTy.setZtytyouhyouymdwa(tysytYmd);
                        zTSyoukenTkListShTy.setZtyyobiv26("");
                        zTSyoukenTkListShTy.setZtysyono(syono);
                        zTSyoukenTkListShTy.setZtykyknmkj(kyknmkj);
                        zTSyoukenTkListShTy.setZtyhhknnmkj(hhknnmkj);
                        zTSyoukenTkListShTy.setZtysyorinm(kinouNm);
                        zTSyoukenTkListShTy.setZtysyorisyouninsyacd(syoriSyouninsyaCd);
                        zTSyoukenTkListShTy.setZtysyorisyouninsyanm(userNm);
                        if(afterRetryListTranslate.size() > 0) {
                            zTSyoukenTkListShTy.setZtyjigosagyounaiyo1(afterRetryListTranslate.get(0));
                        }
                        if(afterRetryListTranslate.size() > 1) {
                            zTSyoukenTkListShTy.setZtyjigosagyounaiyo2(afterRetryListTranslate.get(1));
                        }
                        if(afterRetryListTranslate.size() > 2) {
                            zTSyoukenTkListShTy.setZtyjigosagyounaiyo3(afterRetryListTranslate.get(2));
                        }
                        if(afterRetryListTranslate.size() > 3) {
                            zTSyoukenTkListShTy.setZtyjigosagyounaiyo4(afterRetryListTranslate.get(3));
                        }
                        if(afterRetryListTranslate.size() > 4) {
                            zTSyoukenTkListShTy.setZtyjigosagyounaiyo5(afterRetryListTranslate.get(4));
                        }
                        if(afterRetryListTranslate.size() > 5) {
                            zTSyoukenTkListShTy.setZtyjigosagyounaiyo6(afterRetryListTranslate.get(5));
                        }
                        if(afterRetryListTranslate.size() > 6) {
                            zTSyoukenTkListShTy.setZtyjigosagyounaiyo7(afterRetryListTranslate.get(6));
                        }
                        if(afterRetryListTranslate.size() > 7) {
                            zTSyoukenTkListShTy.setZtyjigosagyounaiyo8(afterRetryListTranslate.get(7));
                        }
                        if(afterRetryListTranslate.size() > 8) {
                            zTSyoukenTkListShTy.setZtyjigosagyounaiyo9(afterRetryListTranslate.get(8));
                        }
                        if(afterRetryListTranslate.size() > 9) {
                            zTSyoukenTkListShTy.setZtyjigosagyounaiyo10(afterRetryListTranslate.get(9));
                        }
                        if(afterRetryListTranslate.size() > 10) {
                            zTSyoukenTkListShTy.setZtyjigosagyounaiyo11(afterRetryListTranslate.get(10));
                        }
                        if(afterRetryListTranslate.size() > 11) {
                            zTSyoukenTkListShTy.setZtyjigosagyounaiyo12(afterRetryListTranslate.get(11));
                        }
                        if(afterRetryListTranslate.size() > 12) {
                            zTSyoukenTkListShTy.setZtyjigosagyounaiyo13(afterRetryListTranslate.get(12));
                        }
                        if(afterRetryListTranslate.size() > 13) {
                            zTSyoukenTkListShTy.setZtyjigosagyounaiyo14(afterRetryListTranslate.get(13));
                        }
                        if(afterRetryListTranslate.size() > 14) {
                            zTSyoukenTkListShTy.setZtyjigosagyounaiyo15(afterRetryListTranslate.get(14));
                        }
                        if(afterRetryListTranslate.size() > 15) {
                            zTSyoukenTkListShTy.setZtyjigosagyounaiyo16(afterRetryListTranslate.get(15));
                        }
                        zTSyoukenTkListShTy.setZtyyobiv31("");

                        BizPropertyInitializer.initialize(zTSyoukenTkListShTy);

                        zTSyoukenTkListShTyInserter.add(zTSyoukenTkListShTy);

                        jikoKensuu ++ ;
                    }
                }
            }
        }

        bzRecoveryDatasikibetuBean.initializeBlank();

        reportServicesBean.addParamObjects(khSyoukenmeisaiListBeanList, khSyoukenmeisaiListBean);

        reportServicesBean.setSyoriYmd(bzBatchParam.getSyoriYmd());

        createReport.exec(reportServicesBean);

        reportServicesBeanRetry.addParamObjects(khSyoukenmeisaiListBeanListRetry, khSyoukenmeisaiListBeanSai);

        reportServicesBeanRetry.setSyoriYmd(bzBatchParam.getSyoriYmd());

        createReport.exec(reportServicesBeanRetry);

        batchLogger.info(MessageUtil.getMessage(MessageId.IBF0001, String.valueOf(skSyoukenSakuseiKensuu)));

        batchLogger.info(MessageUtil.getMessage(MessageId.IBF0001, String.valueOf(skjikoKensuu)));

        batchLogger.info(MessageUtil.getMessage(MessageId.IBF0001, String.valueOf(syoukenSakuseiKensuu)));

        batchLogger.info(MessageUtil.getMessage(MessageId.IBF0001, String.valueOf(jikoKensuu)));

    }

    @AppBatchExceptionTerminate
    private void appBatchExceptionTerminate() {

        BzBatchAbendCommonRecovery bzBatchAbendCommonRecovery =
            SWAKInjector.getInstance(BzBatchAbendCommonRecovery.class);
        bzBatchAbendCommonRecovery.exec();

    }
}
