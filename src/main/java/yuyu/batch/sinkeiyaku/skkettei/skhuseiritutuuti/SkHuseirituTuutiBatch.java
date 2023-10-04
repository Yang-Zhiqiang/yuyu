package yuyu.batch.sinkeiyaku.skkettei.skhuseiritutuuti;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.batch.annotation.AppBatchExceptionTerminate;
import jp.co.slcs.swak.batch.annotation.Execute;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.db.ExDBResults;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.util.message.MessageUtil;
import jp.co.slcs.swak.util.string.ConvertUtil;
import yuyu.common.base.format.BizDateFormatUtil;
import yuyu.common.base.format.BizDateFormatter;
import yuyu.common.biz.bzcommon.BizUtil;
import yuyu.common.biz.bzcommon.BzBatchAbendCommonRecovery;
import yuyu.common.biz.bzcommon.BzBatchParam;
import yuyu.common.biz.bzcommon.BzGetSosikiMadogutiInfo;
import yuyu.common.biz.bzcommon.BzGetSosikiMadogutiInfoKekkaBean;
import yuyu.common.biz.bzcommon.DateFormatUtil;
import yuyu.common.biz.bzdairiten.BzGetAgInfo;
import yuyu.common.biz.bzdairiten.BzGetAgInfoBean;
import yuyu.common.biz.bzdairiten.BzGetBsInfo;
import yuyu.common.biz.bzdairiten.BzGetBsInfoBean;
import yuyu.common.biz.report.ViewReport;
import yuyu.common.sinkeiyaku.prereport.SinkeiyakuPreReportRenkeiBean;
import yuyu.common.sinkeiyaku.skcommon.EditDairitenAtesaki;
import yuyu.common.sinkeiyaku.skcommon.EditDairitenAtesakiBean;
import yuyu.common.sinkeiyaku.skcommon.EditPdfHenkinirai;
import yuyu.common.sinkeiyaku.skcommon.GetRsgakukei;
import yuyu.common.sinkeiyaku.skcommon.GetSkChannelInfo;
import yuyu.def.MessageId;
import yuyu.def.biz.bean.param.BzRecoveryDatasikibetuBean;
import yuyu.def.biz.bean.report.BzDairitenAtesakiBean;
import yuyu.def.biz.bean.report.BzKokyakuAtesakiBean;
import yuyu.def.biz.configuration.YuyuBizConfig;
import yuyu.def.classification.C_HusyoudakuTuutiSouhusakiKbn;
import yuyu.def.classification.C_Ketkekkacd;
import yuyu.def.classification.C_KykKbn;
import yuyu.def.classification.C_SeirituKbn;
import yuyu.def.classification.C_SkeijimuKbn;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.AS_Kinou;
import yuyu.def.db.entity.HM_SkHokenSyuruiNo;
import yuyu.def.db.entity.HT_DakuhiKettei;
import yuyu.def.db.entity.HT_Henkin;
import yuyu.def.db.entity.HT_MosDairiten;
import yuyu.def.db.entity.HT_MosKihon;
import yuyu.def.db.entity.HT_Nyuukin;
import yuyu.def.db.entity.HT_SyoriCTL;
import yuyu.def.sinkeiyaku.bean.report.SkHenkiniraisyoBean;
import yuyu.def.sinkeiyaku.bean.report.SkKykhuseirituBean;
import yuyu.def.sinkeiyaku.bean.report.SkTtdkkanryouTuutiBean;
import yuyu.def.sinkeiyaku.configuration.YuyuSinkeiyakuConfig;
import yuyu.def.sinkeiyaku.manager.SinkeiyakuDomManager;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.BatchParam;
import yuyu.infr.batch.logger.BatchLogger;
import yuyu.infr.report.CreateReport;
import yuyu.infr.report.swakreport.ReportServicesBean;

/**
 * 新契約 決定 不成立通知処理
 */
public class SkHuseirituTuutiBatch implements Batch {

    public final String TABLE_ID = "HT_SyoriCTL";

    public final String FILTER_ID = "Sk001";

    @Inject
    private BatchLogger batchLogger;

    @Inject
    private BzBatchParam bzBatchParam;

    @Inject
    BzRecoveryDatasikibetuBean recoveryBean;

    @Inject
    private SinkeiyakuDomManager sinkeiyakuDomManager;

    @Inject
    private AS_Kinou kinou;

    @Override
    public BatchParam getParam() {
        return bzBatchParam;
    }

    @Execute
    @Transactional
    public void execute() {

        batchLogger.info(MessageUtil.getMessage(MessageId.IBA0016,
            MessageUtil.getMessage(MessageId.IBW0003), bzBatchParam.getSyoriYmd().toString()));

        batchLogger.info(MessageUtil.getMessage(MessageId.IBA0016,
            MessageUtil.getMessage(MessageId.IBW1018), bzBatchParam.getIbKakutyoujobcd()));

        long syoriKesuu = 0;

        try (ExDBResults<HT_SyoriCTL> syoriCtlLst = sinkeiyakuDomManager.getSyoriCTLsByKakutyoujobcdSeiritukbnSrsyoriymd(
            bzBatchParam.getIbKakutyoujobcd(), C_SeirituKbn.HUSEIRITU, bzBatchParam.getSyoriYmd())) {

            BzGetSosikiMadogutiInfo bzGetSosikiMadogutiInfo = SWAKInjector.getInstance(BzGetSosikiMadogutiInfo.class);
            BzGetSosikiMadogutiInfoKekkaBean bzSosikiBean = bzGetSosikiMadogutiInfo.exec(
                YuyuSinkeiyakuConfig.getInstance().getDairitenkyksosikicd());

            GetSkChannelInfo getSkChannelInfo = SWAKInjector.getInstance(GetSkChannelInfo.class);

            BzGetBsInfo bzGetBsInfo = SWAKInjector.getInstance(BzGetBsInfo.class);

            BzGetAgInfo bzGetAgInfo = SWAKInjector.getInstance(BzGetAgInfo.class);

            for (HT_SyoriCTL syoriCtl : syoriCtlLst) {

                SinkeiyakuPreReportRenkeiBean sinkeiyakuPreReportRenkeiBean = SWAKInjector.
                    getInstance(SinkeiyakuPreReportRenkeiBean.class);
                sinkeiyakuPreReportRenkeiBean.setMosNo(syoriCtl.getMosno());
                sinkeiyakuPreReportRenkeiBean.setSakuseizumiKouteikanriId(null);

                recoveryBean.setIbKakutyoujobcd(bzBatchParam.getIbKakutyoujobcd());
                recoveryBean.setIbTableid(TABLE_ID);
                recoveryBean.setIbRecoveryfilterid(FILTER_ID);
                recoveryBean.setIbRecoveryfilterkey1(syoriCtl.getMosno());

                HT_MosDairiten mosDairiten = new HT_MosDairiten();

                BzGetAgInfoBean bzGetAgInfoBean = SWAKInjector.getInstance(BzGetAgInfoBean.class);

                HT_Nyuukin nyuukin = new HT_Nyuukin();

                int syoruiCdIndex = 0;

                HT_DakuhiKettei dakuhiKettei = sinkeiyakuDomManager.getDakuhiKetteiByMosnoMaxDakuhiktrenno(syoriCtl.getMosno());
                if (null == dakuhiKettei) {
                    dakuhiKettei = new HT_DakuhiKettei();
                }

                List<HT_Henkin> henkinLst = syoriCtl.getHenkinsByHnknsyoriymd(bzBatchParam.getSyoriYmd());

                if (dakuhiKettei.getKetkekkacd().eq(C_Ketkekkacd.COOLINGOFF) ||
                    dakuhiKettei.getKetkekkacd().eq(C_Ketkekkacd.MOS_TORIKESI)) {
                    if (syoriCtl.getNyknnrkumu().eq(C_UmuKbn.ARI) ||
                        syoriCtl.getNyknnrkumu().eq(C_UmuKbn.NONE) && (null != henkinLst && henkinLst.size() > 0)) {
                        continue;
                    }
                }

                HT_MosKihon mosKihon = syoriCtl.getMosKihon();

                HM_SkHokenSyuruiNo skHokenSyuruiNo = sinkeiyakuDomManager.getSkHokenSyuruiNo(
                    mosKihon.getHknsyuruino(), mosKihon.getHknsyuruinosd());

                List<HT_MosDairiten> mosDairitenLst = syoriCtl.getMosDairitens();

                if (null != mosDairitenLst && 0 < mosDairitenLst.size()) {
                    mosDairiten = mosDairitenLst.get(0);
                }

                getSkChannelInfo.exec(null, mosDairiten.getTratkiagcd());

                BzGetBsInfoBean bzGetBsInfoBean = bzGetBsInfo.exec(mosDairiten.getBosyuucd());
                if (null == bzGetBsInfoBean) {
                    bzGetBsInfoBean = SWAKInjector.getInstance(BzGetBsInfoBean.class);
                }

                List<BzGetAgInfoBean> bzGetAgInfoBeanLst = bzGetAgInfo.exec(mosDairiten.getTratkiagcd());

                if (null != bzGetAgInfoBeanLst && 0 < bzGetAgInfoBeanLst.size()) {
                    bzGetAgInfoBean = bzGetAgInfoBeanLst.get(0);
                }

                List<HT_Nyuukin> nyuukinLst = syoriCtl.getNyuukins();

                if (null != nyuukinLst && 0 < nyuukinLst.size()) {
                    nyuukin = nyuukinLst.get(0);
                }

                List<C_SyoruiCdKbn> syoruiCdKbnLst = new ArrayList<>();
                SkTtdkkanryouTuutiBean skTtdkkanryouTuutiBeanKokyakuAte = null;
                SkTtdkkanryouTuutiBean skTtdkkanryouTuutiBeanDairitenAte = null;
                BzKokyakuAtesakiBean bzKokyakuAtesakiBean = null;
                SkKykhuseirituBean skKykhuseirituBean = null;
                BzDairitenAtesakiBean bzDairitenAtesakiBean = null;

                SkHenkiniraisyoBean skHenkiniraisyoBean = null;

                if (dakuhiKettei.getKetkekkacd().eq(C_Ketkekkacd.COOLINGOFF) ||
                    dakuhiKettei.getKetkekkacd().eq(C_Ketkekkacd.MOS_TORIKESI)) {
                    if (C_Ketkekkacd.COOLINGOFF.eq(dakuhiKettei.getKetkekkacd())) {

                        skTtdkkanryouTuutiBeanDairitenAte = SWAKInjector.getInstance(SkTtdkkanryouTuutiBean.class);

                        String irTratkisitennm;
                        if (BizUtil.isBlank(bzGetAgInfoBean.getKanjiDairitenNm())) {
                            irTratkisitennm = "";
                        }
                        else {
                            irTratkisitennm = bzGetAgInfoBean.getKanjiDairitenNm();
                        }

                        String irTratkitantounmkjHensyuu;
                        if (BizUtil.isBlank(bzGetBsInfoBean.getKanjiBosyuuninNm())) {
                            irTratkitantounmkjHensyuu = "";
                        }
                        else if (C_SkeijimuKbn.SMBC.eq(syoriCtl.getSkeijimukbn())) {
                            irTratkitantounmkjHensyuu = bzGetBsInfoBean.getKanjiBosyuuninNm() + "　" + "様";
                        }
                        else {
                            irTratkitantounmkjHensyuu = bzGetBsInfoBean.getKanjiBosyuuninNm() + "　" + "様扱い";
                        }

                        skTtdkkanryouTuutiBeanDairitenAte.setIrTyouhyoutitle("クーリングオフ手続き完了のお知らせ");
                        if (C_KykKbn.KEIHI_DOUITU.eq(mosKihon.getKykkbn())) {
                            skTtdkkanryouTuutiBeanDairitenAte.setIrKyknmkj(mosKihon.getHhknnmkj());
                        }
                        else {
                            skTtdkkanryouTuutiBeanDairitenAte.setIrKyknmkj(mosKihon.getKyknmkj());
                        }
                        skTtdkkanryouTuutiBeanDairitenAte.setIrMosno(syoriCtl.getMosno());
                        skTtdkkanryouTuutiBeanDairitenAte.setIrHnknyoteiymd("");
                        skTtdkkanryouTuutiBeanDairitenAte.setIrHknsyurui(skHokenSyuruiNo.getHknsyuruinm());
                        skTtdkkanryouTuutiBeanDairitenAte.setIrAisyoumei("「" + mosKihon.
                            getAisyoumeikbn().getContent() + "」");
                        skTtdkkanryouTuutiBeanDairitenAte.setIrTratkisitennm(irTratkisitennm);
                        skTtdkkanryouTuutiBeanDairitenAte.setIrTratkitantounmkj(irTratkitantounmkjHensyuu);
                        if (C_SkeijimuKbn.SMBC.eq(syoriCtl.getSkeijimukbn())) {
                            skTtdkkanryouTuutiBeanDairitenAte.setIrUktkid(mosKihon.getUktkid());
                        }
                        else {
                            skTtdkkanryouTuutiBeanDairitenAte.setIrUktkid("");
                        }
                        skTtdkkanryouTuutiBeanDairitenAte.setIrSkeijimukbn(syoriCtl.getSkeijimukbn());
                        skTtdkkanryouTuutiBeanDairitenAte.setIrSeiritukbn(syoriCtl.getSeiritukbn());
                        skTtdkkanryouTuutiBeanDairitenAte.setIrKetkekkacd(dakuhiKettei.getKetkekkacd());
                        skTtdkkanryouTuutiBeanDairitenAte.setIrHenkinumu(C_UmuKbn.NONE);

                        bzDairitenAtesakiBean = SWAKInjector.getInstance(BzDairitenAtesakiBean.class);
                        EditDairitenAtesaki editDairitenAtesaki = SWAKInjector.getInstance(EditDairitenAtesaki.class);
                        EditDairitenAtesakiBean editDairitenAtesakiBean = SWAKInjector
                            .getInstance(EditDairitenAtesakiBean.class);

                        editDairitenAtesakiBean.setSyoruiCdKbn(C_SyoruiCdKbn.SK_TTDKKR_DAIRITEN);
                        editDairitenAtesakiBean.setMosDairiten(mosDairiten);
                        editDairitenAtesakiBean.setHassouYmd(bzBatchParam.getSyoriYmd().addBusinessDays(1));
                        editDairitenAtesakiBean.setSeirituKbn(syoriCtl.getSeiritukbn());
                        editDairitenAtesakiBean.setKetkekkaCd(dakuhiKettei.getKetkekkacd());
                        editDairitenAtesakiBean.setSkeijimuKbn(syoriCtl.getSkeijimukbn());

                        bzDairitenAtesakiBean = editDairitenAtesaki.exec(editDairitenAtesakiBean);

                        syoruiCdKbnLst.add(C_SyoruiCdKbn.SK_TTDKKR_DAIRITEN);

                        syoruiCdIndex = 1;
                    }

                    skTtdkkanryouTuutiBeanKokyakuAte = SWAKInjector.getInstance(SkTtdkkanryouTuutiBean.class);
                    skTtdkkanryouTuutiBeanKokyakuAte.setIrMosno(syoriCtl.getMosno());
                    skTtdkkanryouTuutiBeanKokyakuAte.setIrKetkekkacd(dakuhiKettei.getKetkekkacd());
                    skTtdkkanryouTuutiBeanKokyakuAte.setIrSkeijimukbn(syoriCtl.getSkeijimukbn());
                    skTtdkkanryouTuutiBeanKokyakuAte.setIrHknsyurui(skHokenSyuruiNo.getHknsyuruinm());
                    skTtdkkanryouTuutiBeanKokyakuAte.setIrAisyoumei(
                        "「" + mosKihon.getAisyoumeikbn().getContent() + "」");

                    bzKokyakuAtesakiBean = SWAKInjector.getInstance(BzKokyakuAtesakiBean.class);
                    bzKokyakuAtesakiBean.setIrTyouhyousakuseiymd(
                        DateFormatUtil.dateKANJI(bzBatchParam.getSyoriYmd().addBusinessDays(1)));
                    bzKokyakuAtesakiBean.setIrShsyno(mosKihon.getTsinyno());
                    bzKokyakuAtesakiBean.setIrShadr1kj(mosKihon.getTsinadr1kj());
                    bzKokyakuAtesakiBean.setIrShadr2kj(mosKihon.getTsinadr2kj());
                    bzKokyakuAtesakiBean.setIrShadr3kj(mosKihon.getTsinadr3kj());
                    if (mosKihon.getKykkbn().eq(C_KykKbn.KEIHI_DOUITU)) {
                        bzKokyakuAtesakiBean.setIrShsnmkj(mosKihon.getHhknnmkj());
                    }
                    else {
                        bzKokyakuAtesakiBean.setIrShsnmkj(mosKihon.getKyknmkj());
                    }
                    bzKokyakuAtesakiBean.setIrToiawaseyno(bzSosikiBean.getPostalCd());
                    bzKokyakuAtesakiBean.setIrToiawaseadr1kj(bzSosikiBean.getKanjisosikiadr1());
                    bzKokyakuAtesakiBean.setIrToiawaseadr2kj(bzSosikiBean.getKanjisosikiadr2());
                    bzKokyakuAtesakiBean.setIrHknkisynm(YuyuBizConfig.getInstance().getHokenKaisyaNmKanji());
                    bzKokyakuAtesakiBean.setIrToiawasesosiki(bzSosikiBean.getKanjisosikinm());
                    bzKokyakuAtesakiBean.setIrToiawasetantounm("");
                    bzKokyakuAtesakiBean.setIrToiawasetelno(bzSosikiBean.getTelno());

                    syoruiCdKbnLst.add(C_SyoruiCdKbn.SK_TTDKKR);
                }
                else {

                    skKykhuseirituBean = SWAKInjector.getInstance(SkKykhuseirituBean.class);
                    if ("5200002".equals(mosDairiten.getOyadrtencd())) {
                        skKykhuseirituBean.setIrKyktuutisetteinissuu("翌");
                    }
                    else {
                        if (syoriCtl.getSkeijimukbn().eq(C_SkeijimuKbn.SMBC)) {
                            skKykhuseirituBean.setIrKyktuutisetteinissuu("２");
                        }
                        else {
                            skKykhuseirituBean.setIrKyktuutisetteinissuu("３");
                        }
                    }
                    if (!BizUtil.isBlank(bzGetAgInfoBean.getDrtenJimCd())) {
                        skKykhuseirituBean.setIrSitencd(bzGetAgInfoBean.getDrtenJimCd());
                    }
                    else {
                        skKykhuseirituBean.setIrSitencd("");
                    }
                    if (mosKihon.getKykkbn().eq(C_KykKbn.KEIHI_DOUITU)) {
                        skKykhuseirituBean.setIrKyknmkj(mosKihon.getHhknnmkj() + "　様");
                    }
                    else {
                        skKykhuseirituBean.setIrKyknmkj(mosKihon.getKyknmkj() + "　様");
                    }
                    if (mosKihon.getKykkbn().eq(C_KykKbn.KEIHI_DOUITU)) {
                        skKykhuseirituBean.setIrHhknnmkj("ご契約者さまに同じ");
                    }
                    else {
                        skKykhuseirituBean.setIrHhknnmkj(mosKihon.getHhknnmkj() + "　様");
                    }
                    skKykhuseirituBean.setIrMosymd(DateFormatUtil.dateKANJI(mosKihon.getMosymd()));
                    skKykhuseirituBean.setIrAisyoumei("「" + mosKihon.getAisyoumeikbn().getContent() +  "」");
                    GetRsgakukei getRsgakukei = SWAKInjector.getInstance(GetRsgakukei.class);
                    getRsgakukei.getHenkinsumiRsgaku(syoriCtl);
                    BizCurrency rsgakukei = getRsgakukei.getRsgakukei();
                    String rsgaku = "";
                    String ryosyuymd = "";
                    if (rsgakukei.compareTo(BizCurrency.valueOf(0, rsgakukei.getType())) > 0) {

                        rsgaku = ViewReport.editCommaTuuka(rsgakukei, BizUtil.ZERO_FILL);

                        ryosyuymd =  BizDateFormatUtil.toFormatedYmd(syoriCtl.getRyosyuymd(), BizDateFormatter.slashMDFormat) + "着金済";
                    }

                    skKykhuseirituBean.setIrSyokaihrkp(rsgaku);
                    skKykhuseirituBean.setIrRyosyuymd(ryosyuymd);
                    skKykhuseirituBean.setIrMosno(syoriCtl.getMosno());
                    skKykhuseirituBean.setIrUktkid(mosKihon.getUktkid());
                    skKykhuseirituBean.setIrTyouhyoutitle("お申込み契約についてのお知らせ");
                    skKykhuseirituBean.setIrHknsyurui(skHokenSyuruiNo.getHknsyuruinm());
                    if (syoriCtl.getNyknnrkumu().eq(C_UmuKbn.ARI)) {
                        skKykhuseirituBean.setIr1puktymd(
                            DateFormatUtil.dateKANJI(syoriCtl.getRyosyuymd()));
                    }
                    else {
                        skKykhuseirituBean.setIr1puktymd("お振込みはありません");
                    }

                    if (!BizUtil.isBlank(bzGetBsInfoBean.getKanjiBosyuuninNm())) {
                        skKykhuseirituBean.setIrTantnm(bzGetBsInfoBean.getKanjiBosyuuninNm());
                    }
                    else {
                        skKykhuseirituBean.setIrTantnm("");
                    }
                    skKykhuseirituBean.setIrKetkekkacd(dakuhiKettei.getKetkekkacd());
                    skKykhuseirituBean.setIrSkeijimukbn(syoriCtl.getSkeijimukbn());
                    skKykhuseirituBean.setIrNyknnrkumu(syoriCtl.getNyknnrkumu());
                    skKykhuseirituBean.setIrHknsyuruino(mosKihon.getHknsyuruino());
                    if ("5200002".equals(mosDairiten.getOyadrtencd())) {
                        skKykhuseirituBean.setIrHusyoudakutuutishskbn(C_HusyoudakuTuutiSouhusakiKbn.DAIRITENATE);
                    }
                    else {
                        skKykhuseirituBean.setIrHusyoudakutuutishskbn(C_HusyoudakuTuutiSouhusakiKbn.KOKYAKUATE);
                    }

                    bzDairitenAtesakiBean = SWAKInjector.getInstance(BzDairitenAtesakiBean.class);
                    EditDairitenAtesaki editDairitenAtesaki = SWAKInjector.getInstance(EditDairitenAtesaki.class);
                    EditDairitenAtesakiBean editDairitenAtesakiBean = SWAKInjector
                        .getInstance(EditDairitenAtesakiBean.class);

                    editDairitenAtesakiBean.setSyoruiCdKbn(C_SyoruiCdKbn.SK_KYKHUSEIRITU);
                    editDairitenAtesakiBean.setMosDairiten(mosDairiten);
                    editDairitenAtesakiBean.setHassouYmd(bzBatchParam.getSyoriYmd().addBusinessDays(2));
                    editDairitenAtesakiBean.setSkeijimuKbn(syoriCtl.getSkeijimukbn());

                    bzDairitenAtesakiBean = editDairitenAtesaki.exec(editDairitenAtesakiBean);

                    bzKokyakuAtesakiBean = SWAKInjector.getInstance(BzKokyakuAtesakiBean.class);

                    if (C_Ketkekkacd.YUUKOUKKNKKA.eq(dakuhiKettei.getKetkekkacd())) {

                        bzKokyakuAtesakiBean.setIrTyouhyousakuseiymd(DateFormatUtil.dateKANJI(
                            bzBatchParam.getSyoriYmd().addBusinessDays(1)));
                    }
                    else {

                        if ("翌".equals(skKykhuseirituBean.getIrKyktuutisetteinissuu())) {
                            bzKokyakuAtesakiBean.setIrTyouhyousakuseiymd(DateFormatUtil.dateKANJI(
                                bzBatchParam.getSyoriYmd().addBusinessDays(3)));
                        }
                        else {
                            bzKokyakuAtesakiBean.setIrTyouhyousakuseiymd(DateFormatUtil.dateKANJI(
                                bzBatchParam.getSyoriYmd().addBusinessDays(2 + Integer.parseInt(ConvertUtil.fromZenNumeric(
                                    skKykhuseirituBean.getIrKyktuutisetteinissuu())))));
                        }

                    }
                    bzKokyakuAtesakiBean.setIrShsyno(mosKihon.getTsinyno());
                    bzKokyakuAtesakiBean.setIrShadr1kj(mosKihon.getTsinadr1kj());
                    bzKokyakuAtesakiBean.setIrShadr2kj(mosKihon.getTsinadr2kj());
                    bzKokyakuAtesakiBean.setIrShadr3kj(mosKihon.getTsinadr3kj());
                    if (mosKihon.getKykkbn().eq(C_KykKbn.KEIHI_DOUITU)) {
                        bzKokyakuAtesakiBean.setIrShsnmkj(mosKihon.getHhknnmkj());
                    }
                    else {
                        bzKokyakuAtesakiBean.setIrShsnmkj(mosKihon.getKyknmkj());
                    }
                    bzKokyakuAtesakiBean.setIrToiawaseyno(bzSosikiBean.getPostalCd());
                    bzKokyakuAtesakiBean.setIrToiawaseadr1kj(bzSosikiBean.getKanjisosikiadr1());
                    bzKokyakuAtesakiBean.setIrToiawaseadr2kj(bzSosikiBean.getKanjisosikiadr2());
                    bzKokyakuAtesakiBean.setIrHknkisynm(YuyuBizConfig.getInstance().getHokenKaisyaNmKanji());
                    bzKokyakuAtesakiBean.setIrToiawasesosiki(bzSosikiBean.getKanjisosikinm());
                    if (dakuhiKettei.getKetkekkacd().eq(C_Ketkekkacd.MIAWASE)) {
                        bzKokyakuAtesakiBean.setIrToiawasetantounm("新契約チーム");
                    }
                    else {
                        bzKokyakuAtesakiBean.setIrToiawasetantounm("");
                    }
                    bzKokyakuAtesakiBean.setIrToiawasetelno(bzSosikiBean.getTelno());
                    bzKokyakuAtesakiBean.setIrToiawaseteluktkkanou1(
                        YuyuBizConfig.getInstance().getUketimetantousitu1());
                    bzKokyakuAtesakiBean.setIrToiawaseteluktkkanou2(
                        YuyuBizConfig.getInstance().getUketimetantousitu2());

                    syoruiCdKbnLst.add(C_SyoruiCdKbn.SK_KYKHUSEIRITU);

                    if (syoriCtl.getNyknnrkumu().eq(C_UmuKbn.ARI)) {

                        EditPdfHenkinirai editPdfHenkinirai = SWAKInjector.getInstance(EditPdfHenkinirai.class);
                        skHenkiniraisyoBean = SWAKInjector.getInstance(SkHenkiniraisyoBean.class);

                        editPdfHenkinirai.editHenkiniraisyo(syoriCtl, syoriCtl.getMosno(), syoriCtl.getSkeijimukbn(),
                            dakuhiKettei.getKetkekkacd(), null, nyuukin.getRstuukasyu());

                        skHenkiniraisyoBean = editPdfHenkinirai.getSkHenkiniraisyoBean();


                        syoruiCdKbnLst.add(C_SyoruiCdKbn.SK_HENKINIRAISYO);
                    }
                }
                if (0 < syoruiCdKbnLst.size()) {

                    CreateReport createReport = SWAKInjector.getInstance(CreateReport.class);

                    ReportServicesBean reportServicesBean = createReport.createNewReportServiceBean(
                        kinou.getSubSystemId(),
                        kinou.getCategoryId(),
                        kinou.getKinouId(),
                        syoruiCdKbnLst.toArray(new C_SyoruiCdKbn[0]));

                    reportServicesBean.setKensakuKeys(syoriCtl.getSkeijimukbn().getValue(),
                        mosDairiten.getOyadrtencd(), syoriCtl.getMosno());

                    reportServicesBean.setSyoriYmd(bzBatchParam.getSyoriYmd());

                    for (C_SyoruiCdKbn syoruiCdKbn : syoruiCdKbnLst) {
                        if (C_SyoruiCdKbn.SK_TTDKKR_DAIRITEN.eq(syoruiCdKbn)) {
                            reportServicesBean.addParamObjects(C_SyoruiCdKbn.SK_TTDKKR_DAIRITEN,
                                skTtdkkanryouTuutiBeanDairitenAte, bzDairitenAtesakiBean);
                        }
                        else if (syoruiCdKbn.eq(C_SyoruiCdKbn.SK_TTDKKR)) {
                            reportServicesBean.addParamObjects(C_SyoruiCdKbn.SK_TTDKKR,
                                skTtdkkanryouTuutiBeanKokyakuAte, bzKokyakuAtesakiBean);
                        }
                        else if (syoruiCdKbn.eq(C_SyoruiCdKbn.SK_KYKHUSEIRITU)) {

                            reportServicesBean.addParamObjects(C_SyoruiCdKbn.SK_KYKHUSEIRITU,
                                skKykhuseirituBean, bzKokyakuAtesakiBean, bzDairitenAtesakiBean);
                        }
                        else if (syoruiCdKbn.eq(C_SyoruiCdKbn.SK_HENKINIRAISYO)) {
                            reportServicesBean.addParamObjects(C_SyoruiCdKbn.SK_HENKINIRAISYO, skHenkiniraisyoBean);
                        }
                    }

                    reportServicesBean.setSyoruiCdKbnIdx(syoruiCdIndex);
                    createReport.execNoCommit(reportServicesBean);
                }

                syoriKesuu++;
            }
        }

        recoveryBean.initializeBlank();

        batchLogger.info(MessageUtil.getMessage(MessageId.IBF0002, String.valueOf(syoriKesuu), "契約不成立通知書"));
    }

    @AppBatchExceptionTerminate
    private void appBatchExceptionTerminate() {

        BzBatchAbendCommonRecovery bzBatchAbendCommonRecovery = SWAKInjector.getInstance(
            BzBatchAbendCommonRecovery.class);

        bzBatchAbendCommonRecovery.exec();
    }
}
