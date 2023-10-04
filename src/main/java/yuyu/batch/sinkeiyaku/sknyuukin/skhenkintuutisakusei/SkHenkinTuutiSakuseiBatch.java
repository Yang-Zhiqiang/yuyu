package yuyu.batch.sinkeiyaku.sknyuukin.skhenkintuutisakusei;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.batch.annotation.Execute;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.ExDBResults;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.util.message.MessageUtil;
import yuyu.common.biz.bzcommon.BizUtil;
import yuyu.common.biz.bzcommon.BzBatchParam;
import yuyu.common.biz.bzcommon.BzGetSosikiMadogutiInfo;
import yuyu.common.biz.bzcommon.BzGetSosikiMadogutiInfoKekkaBean;
import yuyu.common.biz.bzcommon.DateFormatUtil;
import yuyu.common.biz.bzcommon.HenkanTuuka;
import yuyu.common.biz.bzdairiten.BzGetAgInfo;
import yuyu.common.biz.bzdairiten.BzGetAgInfoBean;
import yuyu.common.biz.bzdairiten.BzGetBsInfo;
import yuyu.common.biz.bzdairiten.BzGetBsInfoBean;
import yuyu.common.biz.report.ViewReport;
import yuyu.common.sinkeiyaku.skcommon.EditDairitenAtesaki;
import yuyu.common.sinkeiyaku.skcommon.EditDairitenAtesakiBean;
import yuyu.common.sinkeiyaku.skcommon.GetSkChannelInfo;
import yuyu.def.MessageId;
import yuyu.def.biz.bean.report.BzDairitenAtesakiBean;
import yuyu.def.biz.bean.report.BzKokyakuAtesakiBean;
import yuyu.def.biz.configuration.YuyuBizConfig;
import yuyu.def.classification.C_Ketkekkacd;
import yuyu.def.classification.C_KykKbn;
import yuyu.def.classification.C_SeirituKbn;
import yuyu.def.classification.C_SkeijimuKbn;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.AS_Kinou;
import yuyu.def.db.entity.HM_SkHokenSyuruiNo;
import yuyu.def.db.entity.HT_DakuhiKettei;
import yuyu.def.db.entity.HT_Henkin;
import yuyu.def.db.entity.HT_MosDairiten;
import yuyu.def.db.entity.HT_MosKihon;
import yuyu.def.db.entity.HT_SyoriCTL;
import yuyu.def.sinkeiyaku.bean.report.SkHenkinTuutiBean;
import yuyu.def.sinkeiyaku.bean.report.SkTtdkkanryouTuutiBean;
import yuyu.def.sinkeiyaku.configuration.YuyuSinkeiyakuConfig;
import yuyu.def.sinkeiyaku.manager.SinkeiyakuDomManager;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.logger.BatchLogger;
import yuyu.infr.report.CreateReport;
import yuyu.infr.report.swakreport.ReportServicesBean;

/**
 * 新契約 入金 返金通知作成処理
 */
public class SkHenkinTuutiSakuseiBatch implements Batch {

    @Inject
    private BatchLogger batchLogger;

    @Inject
    private BzBatchParam bzBatchParam;

    @Inject
    private AS_Kinou kinou;

    @Inject
    private SinkeiyakuDomManager sinkeiyakuDomManager;

    @Override
    public BzBatchParam getParam() {
        return bzBatchParam;
    }

    @Execute
    @Transactional
    public void execute() {

        batchLogger.info(MessageUtil.getMessage(MessageId.IBA0016,
            MessageUtil.getMessage(MessageId.IBW0003), String.valueOf(bzBatchParam.getSyoriYmd())));

        BzGetSosikiMadogutiInfo bzGetSosikiMadogutiInfo = SWAKInjector.getInstance(BzGetSosikiMadogutiInfo.class);

        GetSkChannelInfo getSkChannelInfo = SWAKInjector.getInstance(GetSkChannelInfo.class);

        BzGetBsInfo bzGetBsInfo = SWAKInjector.getInstance(BzGetBsInfo.class);

        BzGetAgInfo bzGetAgInfo = SWAKInjector.getInstance(BzGetAgInfo.class);

        HenkanTuuka henkanTuuka = SWAKInjector.getInstance(HenkanTuuka.class);


        long syoriKensuu = 0;

        try (ExDBResults<HT_SyoriCTL> syoriCtlLst =
            sinkeiyakuDomManager.getSyoriCTLsByHnknsyoriymd(bzBatchParam.getSyoriYmd())) {

            BzGetSosikiMadogutiInfoKekkaBean bzGetSosikiMadogutiInfoKekkaBean =
                bzGetSosikiMadogutiInfo.exec(YuyuSinkeiyakuConfig.getInstance().getDairitenkyksosikicd());

            for (HT_SyoriCTL syoriCtl : syoriCtlLst) {

                HT_MosKihon mosKihon = syoriCtl.getMosKihon();

                HT_DakuhiKettei dakuhiKettei =
                    sinkeiyakuDomManager.getDakuhiKetteiByMosnoMaxDakuhiktrenno(syoriCtl.getMosno());

                HM_SkHokenSyuruiNo skHokenSyuruiNo = mosKihon.getSkHokenSyuruiNo();

                HT_MosDairiten mosDairiten = syoriCtl.getMosDairitenByRenno(1);

                getSkChannelInfo.exec(null, mosDairiten.getOyadrtencd());

                BzGetBsInfoBean bzGetBsInfoBean = bzGetBsInfo.exec(mosDairiten.getBosyuucd());

                List<BizCurrency> hnkngkLst = sinkeiyakuDomManager.getHenkinSumHnkngkByMosnoHnknsyoriymdHnknhoukbn(
                    syoriCtl.getMosno(), bzBatchParam.getSyoriYmd());

                List<BzGetAgInfoBean> bzGetAgInfoLst = bzGetAgInfo.exec(mosDairiten.getTratkiagcd());

                String tyouhyouNm = "";

                if (C_SeirituKbn.HUSEIRITU.eq(syoriCtl.getSeiritukbn())) {
                    if (C_UmuKbn.NONE.eq(syoriCtl.getNyknnrkumu())){

                        if (C_Ketkekkacd.COOLINGOFF.eq(dakuhiKettei.getKetkekkacd())) {

                            tyouhyouNm = "クーリングオフ手続き完了のお知らせ";

                            for (BizCurrency bizHnkngk : hnkngkLst) {

                                List<C_SyoruiCdKbn> syoruiCdKbnLst = new ArrayList<>();
                                int syoruiCdIndex = 0;
                                List<Object> skTuutiBeanLst = new ArrayList<>();
                                List<Object> bzAtesakiBeanLst = new ArrayList<>();

                                C_Tuukasyu currencyType = henkanTuuka.henkanTuukaTypeToKbn(bizHnkngk.getType());

                                List<HT_Henkin> henkinLst = sinkeiyakuDomManager
                                    .getHenkinsByMosnoHnknsyoriymdHnknhoukbnHnkntuukasyu(syoriCtl.getMosno(),
                                        bzBatchParam.getSyoriYmd(), currencyType);

                                SkTtdkkanryouTuutiBean skTtdkkanryouTuutiBean = SWAKInjector
                                    .getInstance(SkTtdkkanryouTuutiBean.class);


                                String irTratkisitenNm = "";
                                if (bzGetAgInfoLst.size() == 0) {
                                    irTratkisitenNm = "";
                                }
                                else {
                                    irTratkisitenNm = bzGetAgInfoLst.get(0).getKanjiDairitenNm();
                                }

                                String irFstphrkGk = ViewReport.editCommaTuuka(bizHnkngk, BizUtil.ZERO_FILL);

                                if (bzGetBsInfoBean == null) {
                                    skTtdkkanryouTuutiBean.setIrTratkitantounmkj("");
                                }
                                else if (C_SkeijimuKbn.SMBC.eq(syoriCtl.getSkeijimukbn())) {
                                    skTtdkkanryouTuutiBean.setIrTratkitantounmkj(bzGetBsInfoBean.getKanjiBosyuuninNm() + "　"+ "様");
                                } else {
                                    skTtdkkanryouTuutiBean.setIrTratkitantounmkj(bzGetBsInfoBean.getKanjiBosyuuninNm() + "　" + "様扱い");
                                }

                                skTtdkkanryouTuutiBean.setIrTyouhyoutitle(tyouhyouNm);

                                if (C_KykKbn.KEIHI_DOUITU.eq(mosKihon.getKykkbn())) {
                                    skTtdkkanryouTuutiBean.setIrKyknmkj(mosKihon.getHhknnmkj());
                                }
                                else {
                                    skTtdkkanryouTuutiBean.setIrKyknmkj(mosKihon.getKyknmkj());
                                }

                                skTtdkkanryouTuutiBean.setIrMosno(syoriCtl.getMosno());

                                skTtdkkanryouTuutiBean.setIrFstphrkgk(irFstphrkGk);

                                skTtdkkanryouTuutiBean.setIrHnknyoteiymd(DateFormatUtil.dateKANJINoEx(
                                    henkinLst.get(0).getHnknymd()));

                                skTtdkkanryouTuutiBean.setIrHknsyurui(skHokenSyuruiNo.getHknsyuruinm());

                                skTtdkkanryouTuutiBean.setIrAisyoumei("「" + mosKihon.getAisyoumeikbn().getContent() + "」");

                                skTtdkkanryouTuutiBean.setIrTratkisitennm(irTratkisitenNm);

                                if (C_SkeijimuKbn.SMBC.eq(syoriCtl.getSkeijimukbn())) {
                                    skTtdkkanryouTuutiBean.setIrUktkid(mosKihon.getUktkid());
                                }
                                else {
                                    skTtdkkanryouTuutiBean.setIrUktkid("");
                                }

                                skTtdkkanryouTuutiBean.setIrSkeijimukbn(syoriCtl.getSkeijimukbn());

                                skTtdkkanryouTuutiBean.setIrSeiritukbn(syoriCtl.getSeiritukbn());

                                skTtdkkanryouTuutiBean.setIrKetkekkacd(dakuhiKettei.getKetkekkacd());

                                skTtdkkanryouTuutiBean.setIrHenkinumu(C_UmuKbn.ARI);

                                skTuutiBeanLst.add(skTtdkkanryouTuutiBean);


                                BzDairitenAtesakiBean bzDairitenAtesakiBean = SWAKInjector
                                    .getInstance(BzDairitenAtesakiBean.class);

                                bzDairitenAtesakiBean = editBzDairitenAtesakiBean(
                                    C_SyoruiCdKbn.SK_TTDKKR_DAIRITEN,
                                    mosDairiten,
                                    bzBatchParam.getSyoriYmd().addBusinessDays(1),
                                    syoriCtl.getSeiritukbn(),
                                    dakuhiKettei.getKetkekkacd(),
                                    syoriCtl.getSkeijimukbn());

                                bzAtesakiBeanLst.add(bzDairitenAtesakiBean);

                                syoruiCdKbnLst.add(C_SyoruiCdKbn.SK_TTDKKR_DAIRITEN);

                                SkHenkinTuutiBean skHenkinTuutiBean = SWAKInjector.getInstance(SkHenkinTuutiBean.class);

                                String hnkngk = ViewReport.editCommaTuuka(bizHnkngk, BizUtil.ZERO_FILL);

                                skHenkinTuutiBean.setIrHnkngk(hnkngk);
                                skHenkinTuutiBean.setIrHnknymd(DateFormatUtil.dateKANJINoEx(henkinLst.get(0).getHnknymd()));
                                skHenkinTuutiBean.setIrKetkekkacd(dakuhiKettei.getKetkekkacd());
                                skHenkinTuutiBean.setIrSkeijimukbn(syoriCtl.getSkeijimukbn());

                                skTuutiBeanLst.add(skHenkinTuutiBean);

                                BzKokyakuAtesakiBean bzKokyakuAtesakiBean = SWAKInjector.getInstance(BzKokyakuAtesakiBean.class);

                                bzKokyakuAtesakiBean.setIrTyouhyousakuseiymd(
                                    DateFormatUtil.dateKANJINoEx(bzBatchParam.getSyoriYmd().addBusinessDays(1)));
                                bzKokyakuAtesakiBean.setIrShsyno(mosKihon.getTsinyno());
                                bzKokyakuAtesakiBean.setIrShadr1kj(mosKihon.getTsinadr1kj());
                                bzKokyakuAtesakiBean.setIrShadr2kj(mosKihon.getTsinadr2kj());
                                bzKokyakuAtesakiBean.setIrShadr3kj(mosKihon.getTsinadr3kj());
                                if (C_KykKbn.KEIHI_DOUITU.eq(mosKihon.getKykkbn())) {
                                    bzKokyakuAtesakiBean.setIrShsnmkj(mosKihon.getHhknnmkj());
                                }
                                else {
                                    bzKokyakuAtesakiBean.setIrShsnmkj(mosKihon.getKyknmkj());
                                }
                                bzKokyakuAtesakiBean.setIrToiawaseyno(bzGetSosikiMadogutiInfoKekkaBean.getPostalCd());
                                bzKokyakuAtesakiBean.setIrToiawaseadr1kj(bzGetSosikiMadogutiInfoKekkaBean.getKanjisosikiadr1());
                                bzKokyakuAtesakiBean.setIrToiawaseadr2kj(bzGetSosikiMadogutiInfoKekkaBean.getKanjisosikiadr2());
                                bzKokyakuAtesakiBean.setIrHknkisynm(YuyuBizConfig.getInstance().getHokenKaisyaNmKanji());
                                bzKokyakuAtesakiBean.setIrToiawasesosiki(bzGetSosikiMadogutiInfoKekkaBean.getKanjisosikinm());
                                if (C_Ketkekkacd.MIAWASE.eq(dakuhiKettei.getKetkekkacd())) {
                                    bzKokyakuAtesakiBean.setIrToiawasetantounm("新契約チーム");
                                }
                                else {
                                    bzKokyakuAtesakiBean.setIrToiawasetantounm("");
                                }
                                bzKokyakuAtesakiBean.setIrToiawasetelno(bzGetSosikiMadogutiInfoKekkaBean.getTelno());
                                
                                bzAtesakiBeanLst.add(bzKokyakuAtesakiBean);

                                syoruiCdKbnLst.add(C_SyoruiCdKbn.SK_HENKINTUUTILIST);
                                syoruiCdIndex = 1;

                                createReport(syoruiCdKbnLst
                                    ,syoruiCdIndex
                                    ,skTuutiBeanLst
                                    ,bzAtesakiBeanLst
                                    ,syoriCtl
                                    ,mosDairiten);
                            }

                        }

                        else if (C_Ketkekkacd.MOS_TORIKESI.eq(dakuhiKettei.getKetkekkacd())) {

                            tyouhyouNm = "申込取消手続き完了のお知らせ";

                            for (BizCurrency bizHnkngk : hnkngkLst) {

                                List<C_SyoruiCdKbn> syoruiCdKbnLst = new ArrayList<>();
                                int syoruiCdIndex = 0;
                                List<Object> skTuutiBeanLst = new ArrayList<>();
                                List<Object> bzAtesakiBeanLst = new ArrayList<>();

                                C_Tuukasyu currencyType = henkanTuuka.henkanTuukaTypeToKbn(bizHnkngk.getType());

                                List<HT_Henkin> henkinLst = sinkeiyakuDomManager.getHenkinsByMosnoHnknsyoriymdHnknhoukbnHnkntuukasyu(
                                    syoriCtl.getMosno(), bzBatchParam.getSyoriYmd(), currencyType);

                                SkTtdkkanryouTuutiBean skTtdkkanryouTuutiBean = SWAKInjector
                                    .getInstance(SkTtdkkanryouTuutiBean.class);

                                String irTratkisitenNm = "";
                                if (bzGetAgInfoLst.size() == 0) {
                                    irTratkisitenNm = "";
                                }
                                else {
                                    irTratkisitenNm = bzGetAgInfoLst.get(0).getKanjiDairitenNm();
                                }

                                String irFstphrkGk = ViewReport.editCommaTuuka(bizHnkngk, BizUtil.ZERO_FILL);

                                String irTratkitantounmkj = "";
                                if (bzGetBsInfoBean == null) {
                                    irTratkitantounmkj = "";
                                }
                                else if (C_SkeijimuKbn.SMBC.eq(syoriCtl.getSkeijimukbn())) {
                                    irTratkitantounmkj = bzGetBsInfoBean.getKanjiBosyuuninNm() + "　"+ "様";
                                }
                                else {
                                    irTratkitantounmkj = bzGetBsInfoBean.getKanjiBosyuuninNm() + "　" + "様扱い";
                                }

                                skTtdkkanryouTuutiBean.setIrTyouhyoutitle(tyouhyouNm);

                                if (C_KykKbn.KEIHI_DOUITU.eq(mosKihon.getKykkbn())) {
                                    skTtdkkanryouTuutiBean.setIrKyknmkj(mosKihon.getHhknnmkj());
                                }
                                else {
                                    skTtdkkanryouTuutiBean.setIrKyknmkj(mosKihon.getKyknmkj());
                                }

                                skTtdkkanryouTuutiBean.setIrMosno(syoriCtl.getMosno());

                                skTtdkkanryouTuutiBean.setIrFstphrkgk(irFstphrkGk);

                                skTtdkkanryouTuutiBean.setIrHnknyoteiymd(DateFormatUtil.dateKANJINoEx(
                                    henkinLst.get(0).getHnknymd()));

                                skTtdkkanryouTuutiBean.setIrHknsyurui(skHokenSyuruiNo.getHknsyuruinm());

                                skTtdkkanryouTuutiBean.setIrAisyoumei("「" + mosKihon.getAisyoumeikbn().getContent() + "」");

                                skTtdkkanryouTuutiBean.setIrTratkisitennm(irTratkisitenNm);

                                skTtdkkanryouTuutiBean.setIrTratkitantounmkj(irTratkitantounmkj);

                                if (C_SkeijimuKbn.SMBC.eq(syoriCtl.getSkeijimukbn())) {
                                    skTtdkkanryouTuutiBean.setIrUktkid(mosKihon.getUktkid());
                                }
                                else {
                                    skTtdkkanryouTuutiBean.setIrUktkid("");
                                }

                                skTtdkkanryouTuutiBean.setIrSkeijimukbn(syoriCtl.getSkeijimukbn());

                                skTtdkkanryouTuutiBean.setIrSeiritukbn(syoriCtl.getSeiritukbn());

                                skTtdkkanryouTuutiBean.setIrKetkekkacd(dakuhiKettei.getKetkekkacd());

                                skTtdkkanryouTuutiBean.setIrHenkinumu(C_UmuKbn.ARI);

                                skTuutiBeanLst.add(skTtdkkanryouTuutiBean);

                                BzDairitenAtesakiBean bzDairitenAtesakiBean = SWAKInjector
                                    .getInstance(BzDairitenAtesakiBean.class);

                                bzDairitenAtesakiBean = editBzDairitenAtesakiBean(
                                    C_SyoruiCdKbn.SK_TTDKKR_DAIRITEN,
                                    mosDairiten,
                                    bzBatchParam.getSyoriYmd().addBusinessDays(1),
                                    syoriCtl.getSeiritukbn(),
                                    dakuhiKettei.getKetkekkacd(),
                                    syoriCtl.getSkeijimukbn());

                                bzAtesakiBeanLst.add(bzDairitenAtesakiBean);

                                syoruiCdKbnLst.add(C_SyoruiCdKbn.SK_TTDKKR_DAIRITEN);


                                SkHenkinTuutiBean skHenkinTuutiBean = SWAKInjector.getInstance(SkHenkinTuutiBean.class);

                                String hnkngk = ViewReport.editCommaTuuka(bizHnkngk, BizUtil.ZERO_FILL);

                                skHenkinTuutiBean.setIrHnkngk(hnkngk);
                                skHenkinTuutiBean.setIrHnknymd(DateFormatUtil.dateKANJINoEx(henkinLst.get(0).getHnknymd()));
                                skHenkinTuutiBean.setIrKetkekkacd(dakuhiKettei.getKetkekkacd());
                                skHenkinTuutiBean.setIrSkeijimukbn(syoriCtl.getSkeijimukbn());

                                skTuutiBeanLst.add(skHenkinTuutiBean);

                                BzKokyakuAtesakiBean bzKokyakuAtesakiBean = SWAKInjector.getInstance(BzKokyakuAtesakiBean.class);

                                bzKokyakuAtesakiBean.setIrTyouhyousakuseiymd(
                                    DateFormatUtil.dateKANJINoEx(bzBatchParam.getSyoriYmd().addBusinessDays(1)));
                                bzKokyakuAtesakiBean.setIrShsyno(mosKihon.getTsinyno());
                                bzKokyakuAtesakiBean.setIrShadr1kj(mosKihon.getTsinadr1kj());
                                bzKokyakuAtesakiBean.setIrShadr2kj(mosKihon.getTsinadr2kj());
                                bzKokyakuAtesakiBean.setIrShadr3kj(mosKihon.getTsinadr3kj());
                                if (C_KykKbn.KEIHI_DOUITU.eq(mosKihon.getKykkbn())) {
                                    bzKokyakuAtesakiBean.setIrShsnmkj(mosKihon.getHhknnmkj());
                                }
                                else {
                                    bzKokyakuAtesakiBean.setIrShsnmkj(mosKihon.getKyknmkj());
                                }
                                bzKokyakuAtesakiBean.setIrToiawaseyno(bzGetSosikiMadogutiInfoKekkaBean.getPostalCd());
                                bzKokyakuAtesakiBean.setIrToiawaseadr1kj(bzGetSosikiMadogutiInfoKekkaBean.getKanjisosikiadr1());
                                bzKokyakuAtesakiBean.setIrToiawaseadr2kj(bzGetSosikiMadogutiInfoKekkaBean.getKanjisosikiadr2());
                                bzKokyakuAtesakiBean.setIrHknkisynm(YuyuBizConfig.getInstance().getHokenKaisyaNmKanji());
                                bzKokyakuAtesakiBean.setIrToiawasesosiki(bzGetSosikiMadogutiInfoKekkaBean.getKanjisosikinm());
                                if (C_Ketkekkacd.MIAWASE.eq(dakuhiKettei.getKetkekkacd())) {
                                    bzKokyakuAtesakiBean.setIrToiawasetantounm("新契約チーム");
                                }
                                else {
                                    bzKokyakuAtesakiBean.setIrToiawasetantounm("");
                                }
                                bzKokyakuAtesakiBean.setIrToiawasetelno(bzGetSosikiMadogutiInfoKekkaBean.getTelno());

                                bzAtesakiBeanLst.add(bzKokyakuAtesakiBean);

                                syoruiCdKbnLst.add(C_SyoruiCdKbn.SK_HENKINTUUTILIST);

                                syoruiCdIndex = 1;

                                createReport(syoruiCdKbnLst
                                    ,syoruiCdIndex
                                    ,skTuutiBeanLst
                                    ,bzAtesakiBeanLst
                                    ,syoriCtl
                                    ,mosDairiten);
                            }

                        }

                        else if (C_Ketkekkacd.ENKI_SIJINASI.eq(dakuhiKettei.getKetkekkacd())
                            || C_Ketkekkacd.ENKI_SUUNENGOSAISIN.eq(dakuhiKettei.getKetkekkacd())
                            || C_Ketkekkacd.MIAWASE.eq(dakuhiKettei.getKetkekkacd())) {

                            tyouhyouNm = "不承諾契約手続き完了のお知らせ";

                            for (BizCurrency bizHnkngk : hnkngkLst) {

                                List<C_SyoruiCdKbn> syoruiCdKbnLst = new ArrayList<>();
                                int syoruiCdIndex = 0;
                                List<Object> skTuutiBeanLst = new ArrayList<>();
                                List<Object> bzAtesakiBeanLst = new ArrayList<>();

                                C_Tuukasyu currencyType = henkanTuuka.henkanTuukaTypeToKbn(bizHnkngk.getType());

                                List<HT_Henkin> henkinLst = sinkeiyakuDomManager
                                    .getHenkinsByMosnoHnknsyoriymdHnknhoukbnHnkntuukasyu(syoriCtl.getMosno(),
                                        bzBatchParam.getSyoriYmd(), currencyType);

                                SkTtdkkanryouTuutiBean skTtdkkanryouTuutiBean = SWAKInjector
                                    .getInstance(SkTtdkkanryouTuutiBean.class);


                                String irTratkisitenNm = "";
                                if (bzGetAgInfoLst.size() == 0) {
                                    irTratkisitenNm = "";
                                }
                                else {
                                    irTratkisitenNm = bzGetAgInfoLst.get(0).getKanjiDairitenNm();
                                }

                                String irFstphrkGk = ViewReport.editCommaTuuka(bizHnkngk, BizUtil.ZERO_FILL);

                                if (bzGetBsInfoBean == null) {
                                    skTtdkkanryouTuutiBean.setIrTratkitantounmkj("");
                                }
                                else if (C_SkeijimuKbn.SMBC.eq(syoriCtl.getSkeijimukbn())) {
                                    skTtdkkanryouTuutiBean.setIrTratkitantounmkj(bzGetBsInfoBean.getKanjiBosyuuninNm() + "　"+ "様");
                                } else {
                                    skTtdkkanryouTuutiBean.setIrTratkitantounmkj(bzGetBsInfoBean.getKanjiBosyuuninNm() + "　" + "様扱い");
                                }

                                skTtdkkanryouTuutiBean.setIrTyouhyoutitle(tyouhyouNm);

                                if (C_KykKbn.KEIHI_DOUITU.eq(mosKihon.getKykkbn())) {
                                    skTtdkkanryouTuutiBean.setIrKyknmkj(mosKihon.getHhknnmkj());
                                }
                                else {
                                    skTtdkkanryouTuutiBean.setIrKyknmkj(mosKihon.getKyknmkj());
                                }

                                skTtdkkanryouTuutiBean.setIrMosno(syoriCtl.getMosno());

                                skTtdkkanryouTuutiBean.setIrFstphrkgk(irFstphrkGk);

                                skTtdkkanryouTuutiBean.setIrHnknyoteiymd(DateFormatUtil.dateKANJINoEx(
                                    henkinLst.get(0).getHnknymd()));

                                skTtdkkanryouTuutiBean.setIrHknsyurui(skHokenSyuruiNo.getHknsyuruinm());

                                skTtdkkanryouTuutiBean.setIrAisyoumei("「" + mosKihon.getAisyoumeikbn().getContent() + "」");

                                skTtdkkanryouTuutiBean.setIrTratkisitennm(irTratkisitenNm);

                                if (C_SkeijimuKbn.SMBC.eq(syoriCtl.getSkeijimukbn())) {
                                    skTtdkkanryouTuutiBean.setIrUktkid(mosKihon.getUktkid());
                                }
                                else {
                                    skTtdkkanryouTuutiBean.setIrUktkid("");
                                }

                                skTtdkkanryouTuutiBean.setIrSkeijimukbn(syoriCtl.getSkeijimukbn());

                                skTtdkkanryouTuutiBean.setIrSeiritukbn(syoriCtl.getSeiritukbn());

                                skTtdkkanryouTuutiBean.setIrKetkekkacd(dakuhiKettei.getKetkekkacd());

                                skTtdkkanryouTuutiBean.setIrHenkinumu(C_UmuKbn.ARI);

                                skTuutiBeanLst.add(skTtdkkanryouTuutiBean);

                                BzDairitenAtesakiBean bzDairitenAtesakiBean = SWAKInjector
                                    .getInstance(BzDairitenAtesakiBean.class);

                                bzDairitenAtesakiBean = editBzDairitenAtesakiBean(
                                    C_SyoruiCdKbn.SK_TTDKKR_DAIRITEN,
                                    mosDairiten,
                                    bzBatchParam.getSyoriYmd().addBusinessDays(1),
                                    syoriCtl.getSeiritukbn(),
                                    dakuhiKettei.getKetkekkacd(),
                                    syoriCtl.getSkeijimukbn());

                                bzAtesakiBeanLst.add(bzDairitenAtesakiBean);

                                syoruiCdKbnLst.add(C_SyoruiCdKbn.SK_TTDKKR_DAIRITEN);

                                SkHenkinTuutiBean skHenkinTuutiBean = SWAKInjector.getInstance(SkHenkinTuutiBean.class);

                                skHenkinTuutiBean.setIrHnkngk(ViewReport.editCommaTuuka(bizHnkngk, BizUtil.ZERO_FILL));

                                skHenkinTuutiBean.setIrHnknymd(DateFormatUtil.dateKANJINoEx(henkinLst.get(0).getHnknymd()));

                                skHenkinTuutiBean.setIrKetkekkacd(dakuhiKettei.getKetkekkacd());

                                skHenkinTuutiBean.setIrSkeijimukbn(syoriCtl.getSkeijimukbn());

                                skTuutiBeanLst.add(skHenkinTuutiBean);

                                BzKokyakuAtesakiBean bzKokyakuAtesakiBean = SWAKInjector
                                    .getInstance(BzKokyakuAtesakiBean.class);

                                bzKokyakuAtesakiBean.setIrTyouhyousakuseiymd(DateFormatUtil.dateKANJINoEx(
                                    bzBatchParam.getSyoriYmd().addBusinessDays(1)));

                                bzKokyakuAtesakiBean.setIrShsyno(mosKihon.getTsinyno());

                                bzKokyakuAtesakiBean.setIrShadr1kj(mosKihon.getTsinadr1kj());

                                bzKokyakuAtesakiBean.setIrShadr2kj(mosKihon.getTsinadr2kj());

                                bzKokyakuAtesakiBean.setIrShadr3kj(mosKihon.getTsinadr3kj());

                                if (C_KykKbn.KEIHI_DOUITU.eq(mosKihon.getKykkbn())) {
                                    bzKokyakuAtesakiBean.setIrShsnmkj(mosKihon.getHhknnmkj());
                                }
                                else {
                                    bzKokyakuAtesakiBean.setIrShsnmkj(mosKihon.getKyknmkj());
                                }

                                bzKokyakuAtesakiBean.setIrToiawaseyno(bzGetSosikiMadogutiInfoKekkaBean.getPostalCd());

                                bzKokyakuAtesakiBean.setIrToiawaseadr1kj(bzGetSosikiMadogutiInfoKekkaBean.getKanjisosikiadr1());

                                bzKokyakuAtesakiBean.setIrToiawaseadr2kj(bzGetSosikiMadogutiInfoKekkaBean.getKanjisosikiadr2());

                                bzKokyakuAtesakiBean.setIrHknkisynm(YuyuBizConfig.getInstance().getHokenKaisyaNmKanji());

                                bzKokyakuAtesakiBean.setIrToiawasesosiki(bzGetSosikiMadogutiInfoKekkaBean.getKanjisosikinm());

                                if (C_Ketkekkacd.MIAWASE.eq(dakuhiKettei.getKetkekkacd())) {
                                    bzKokyakuAtesakiBean.setIrToiawasetantounm("新契約チーム");
                                }
                                else {
                                    bzKokyakuAtesakiBean.setIrToiawasetantounm("");
                                }

                                bzKokyakuAtesakiBean.setIrToiawasetelno(bzGetSosikiMadogutiInfoKekkaBean.getTelno());

                                bzAtesakiBeanLst.add(bzKokyakuAtesakiBean);

                                syoruiCdKbnLst.add(C_SyoruiCdKbn.SK_HENKINTUUTILIST);
                                syoruiCdIndex = 1;

                                createReport(syoruiCdKbnLst
                                    ,syoruiCdIndex
                                    ,skTuutiBeanLst
                                    ,bzAtesakiBeanLst
                                    ,syoriCtl
                                    ,mosDairiten);
                            }
                        }
                        else if (C_Ketkekkacd.YUUKOUKKNKKA.eq(dakuhiKettei.getKetkekkacd())) {

                            for (BizCurrency bizHnkngk : hnkngkLst) {

                                List<C_SyoruiCdKbn> syoruiCdKbnLst = new ArrayList<>();
                                int syoruiCdIndex = 0;
                                List<Object> skTuutiBeanLst = new ArrayList<>();
                                List<Object> bzAtesakiBeanLst = new ArrayList<>();

                                C_Tuukasyu currencyType = henkanTuuka.henkanTuukaTypeToKbn(bizHnkngk.getType());

                                List<HT_Henkin> henkinLst = sinkeiyakuDomManager.
                                    getHenkinsByMosnoHnknsyoriymdHnknhoukbnHnkntuukasyu(syoriCtl.getMosno(),
                                        bzBatchParam.getSyoriYmd(), currencyType);

                                SkHenkinTuutiBean skHenkinTuutiBean = SWAKInjector.getInstance(SkHenkinTuutiBean.class);

                                skHenkinTuutiBean.setIrHnkngk(ViewReport.editCommaTuuka(bizHnkngk, BizUtil.ZERO_FILL));

                                skHenkinTuutiBean.setIrHnknymd(DateFormatUtil.dateKANJINoEx(henkinLst.get(0)
                                    .getHnknymd()));

                                skHenkinTuutiBean.setIrKetkekkacd(dakuhiKettei.getKetkekkacd());

                                skHenkinTuutiBean.setIrSkeijimukbn(syoriCtl.getSkeijimukbn());

                                skTuutiBeanLst.add(skHenkinTuutiBean);

                                BzKokyakuAtesakiBean bzKokyakuAtesakiBean = SWAKInjector
                                    .getInstance(BzKokyakuAtesakiBean.class);

                                bzKokyakuAtesakiBean.setIrTyouhyousakuseiymd(DateFormatUtil.dateKANJINoEx(
                                    bzBatchParam.getSyoriYmd().addBusinessDays(1)));

                                bzKokyakuAtesakiBean.setIrShsyno(mosKihon.getTsinyno());

                                bzKokyakuAtesakiBean.setIrShadr1kj(mosKihon.getTsinadr1kj());

                                bzKokyakuAtesakiBean.setIrShadr2kj(mosKihon.getTsinadr2kj());

                                bzKokyakuAtesakiBean.setIrShadr3kj(mosKihon.getTsinadr3kj());

                                if (C_KykKbn.KEIHI_DOUITU.eq(mosKihon.getKykkbn())) {
                                    bzKokyakuAtesakiBean.setIrShsnmkj(mosKihon.getHhknnmkj());
                                }
                                else {
                                    bzKokyakuAtesakiBean.setIrShsnmkj(mosKihon.getKyknmkj());
                                }

                                bzKokyakuAtesakiBean.setIrToiawaseyno(bzGetSosikiMadogutiInfoKekkaBean.getPostalCd());

                                bzKokyakuAtesakiBean.setIrToiawaseadr1kj(bzGetSosikiMadogutiInfoKekkaBean.getKanjisosikiadr1());

                                bzKokyakuAtesakiBean.setIrToiawaseadr2kj(bzGetSosikiMadogutiInfoKekkaBean.getKanjisosikiadr2());

                                bzKokyakuAtesakiBean.setIrHknkisynm(YuyuBizConfig.getInstance().getHokenKaisyaNmKanji());

                                bzKokyakuAtesakiBean.setIrToiawasesosiki(bzGetSosikiMadogutiInfoKekkaBean.getKanjisosikinm());

                                if (C_Ketkekkacd.MIAWASE.eq(dakuhiKettei.getKetkekkacd())) {
                                    bzKokyakuAtesakiBean.setIrToiawasetantounm("新契約チーム");
                                }
                                else {
                                    bzKokyakuAtesakiBean.setIrToiawasetantounm("");
                                }

                                bzKokyakuAtesakiBean.setIrToiawasetelno(bzGetSosikiMadogutiInfoKekkaBean.getTelno());

                                bzAtesakiBeanLst.add(bzKokyakuAtesakiBean);

                                syoruiCdKbnLst.add(C_SyoruiCdKbn.SK_HENKINTUUTILIST);

                                createReport(syoruiCdKbnLst
                                    ,syoruiCdIndex
                                    ,skTuutiBeanLst
                                    ,bzAtesakiBeanLst
                                    ,syoriCtl
                                    ,mosDairiten);
                            }
                        }
                    }
                    else {
                        continue;
                    }
                }
                else {
                    tyouhyouNm = "過剰保険料ご返金手続き完了のお知らせ";

                    for (BizCurrency bizHnkngk : hnkngkLst) {

                        List<C_SyoruiCdKbn> syoruiCdKbnLst = new ArrayList<>();
                        int syoruiCdIndex = 0;
                        List<Object> skTuutiBeanLst = new ArrayList<>();
                        List<Object> bzAtesakiBeanLst = new ArrayList<>();

                        C_Tuukasyu currencyType = henkanTuuka.henkanTuukaTypeToKbn(bizHnkngk.getType());

                        List<HT_Henkin> henkinLst = sinkeiyakuDomManager
                            .getHenkinsByMosnoHnknsyoriymdHnknhoukbnHnkntuukasyu(syoriCtl.getMosno(),
                                bzBatchParam.getSyoriYmd(), currencyType);

                        SkTtdkkanryouTuutiBean skTtdkkanryouTuutiBean = SWAKInjector
                            .getInstance(SkTtdkkanryouTuutiBean.class);


                        String irTratkisitenNm = "";
                        if (bzGetAgInfoLst.size() == 0) {
                            irTratkisitenNm = "";
                        }
                        else {
                            irTratkisitenNm = bzGetAgInfoLst.get(0).getKanjiDairitenNm();
                        }

                        String irFstphrkGk = ViewReport.editCommaTuuka(bizHnkngk, BizUtil.ZERO_FILL);

                        if (bzGetBsInfoBean == null) {
                            skTtdkkanryouTuutiBean.setIrTratkitantounmkj("");
                        }
                        else if (C_SkeijimuKbn.SMBC.eq(syoriCtl.getSkeijimukbn())) {
                            skTtdkkanryouTuutiBean.setIrTratkitantounmkj(bzGetBsInfoBean.getKanjiBosyuuninNm() + "　"+ "様");
                        } else {
                            skTtdkkanryouTuutiBean.setIrTratkitantounmkj(bzGetBsInfoBean.getKanjiBosyuuninNm() + "　" + "様扱い");
                        }

                        skTtdkkanryouTuutiBean.setIrTyouhyoutitle(tyouhyouNm);

                        if (C_KykKbn.KEIHI_DOUITU.eq(mosKihon.getKykkbn())) {
                            skTtdkkanryouTuutiBean.setIrKyknmkj(mosKihon.getHhknnmkj());
                        }
                        else {
                            skTtdkkanryouTuutiBean.setIrKyknmkj(mosKihon.getKyknmkj());
                        }

                        skTtdkkanryouTuutiBean.setIrMosno(syoriCtl.getMosno());

                        skTtdkkanryouTuutiBean.setIrFstphrkgk(irFstphrkGk);

                        skTtdkkanryouTuutiBean.setIrHnknyoteiymd(DateFormatUtil.dateKANJINoEx(
                            henkinLst.get(0).getHnknymd()));

                        skTtdkkanryouTuutiBean.setIrHknsyurui(skHokenSyuruiNo.getHknsyuruinm());

                        skTtdkkanryouTuutiBean.setIrAisyoumei("「" + mosKihon.getAisyoumeikbn().getContent() + "」");

                        skTtdkkanryouTuutiBean.setIrTratkisitennm(irTratkisitenNm);

                        if (C_SkeijimuKbn.SMBC.eq(syoriCtl.getSkeijimukbn())) {
                            skTtdkkanryouTuutiBean.setIrUktkid(mosKihon.getUktkid());
                        }
                        else {
                            skTtdkkanryouTuutiBean.setIrUktkid("");
                        }

                        skTtdkkanryouTuutiBean.setIrSkeijimukbn(syoriCtl.getSkeijimukbn());

                        skTtdkkanryouTuutiBean.setIrSeiritukbn(syoriCtl.getSeiritukbn());

                        skTtdkkanryouTuutiBean.setIrKetkekkacd(C_Ketkekkacd.BLNK);

                        skTtdkkanryouTuutiBean.setIrHenkinumu(C_UmuKbn.ARI);

                        skTuutiBeanLst.add(skTtdkkanryouTuutiBean);

                        BzDairitenAtesakiBean bzDairitenAtesakiBean = SWAKInjector
                            .getInstance(BzDairitenAtesakiBean.class);

                        bzDairitenAtesakiBean = editBzDairitenAtesakiBean(
                            C_SyoruiCdKbn.SK_TTDKKR_DAIRITEN,
                            mosDairiten,
                            bzBatchParam.getSyoriYmd().addBusinessDays(1),
                            syoriCtl.getSeiritukbn(),
                            C_Ketkekkacd.BLNK,
                            syoriCtl.getSkeijimukbn());

                        bzAtesakiBeanLst.add(bzDairitenAtesakiBean);

                        syoruiCdKbnLst.add(C_SyoruiCdKbn.SK_TTDKKR_DAIRITEN);

                        SkHenkinTuutiBean skHenkinTuutiBean = SWAKInjector.getInstance(SkHenkinTuutiBean.class);

                        skHenkinTuutiBean.setIrHnkngk(ViewReport.editCommaTuuka(bizHnkngk, BizUtil.ZERO_FILL));

                        skHenkinTuutiBean.setIrHnknymd(DateFormatUtil.dateKANJINoEx(henkinLst.get(0).getHnknymd()));

                        skHenkinTuutiBean.setIrKetkekkacd(C_Ketkekkacd.BLNK);

                        skHenkinTuutiBean.setIrSkeijimukbn(syoriCtl.getSkeijimukbn());

                        skTuutiBeanLst.add(skHenkinTuutiBean);

                        BzKokyakuAtesakiBean bzKokyakuAtesakiBean = SWAKInjector
                            .getInstance(BzKokyakuAtesakiBean.class);

                        bzKokyakuAtesakiBean.setIrTyouhyousakuseiymd(DateFormatUtil.dateKANJINoEx(
                            bzBatchParam.getSyoriYmd().addBusinessDays(1)));

                        bzKokyakuAtesakiBean.setIrShsyno(mosKihon.getTsinyno());

                        bzKokyakuAtesakiBean.setIrShadr1kj(mosKihon.getTsinadr1kj());

                        bzKokyakuAtesakiBean.setIrShadr2kj(mosKihon.getTsinadr2kj());

                        bzKokyakuAtesakiBean.setIrShadr3kj(mosKihon.getTsinadr3kj());

                        if (C_KykKbn.KEIHI_DOUITU.eq(mosKihon.getKykkbn())) {
                            bzKokyakuAtesakiBean.setIrShsnmkj(mosKihon.getHhknnmkj());
                        }
                        else {
                            bzKokyakuAtesakiBean.setIrShsnmkj(mosKihon.getKyknmkj());
                        }

                        bzKokyakuAtesakiBean.setIrToiawaseyno(bzGetSosikiMadogutiInfoKekkaBean.getPostalCd());

                        bzKokyakuAtesakiBean.setIrToiawaseadr1kj(bzGetSosikiMadogutiInfoKekkaBean.getKanjisosikiadr1());

                        bzKokyakuAtesakiBean.setIrToiawaseadr2kj(bzGetSosikiMadogutiInfoKekkaBean.getKanjisosikiadr2());

                        bzKokyakuAtesakiBean.setIrHknkisynm(YuyuBizConfig.getInstance().getHokenKaisyaNmKanji());

                        bzKokyakuAtesakiBean.setIrToiawasesosiki(bzGetSosikiMadogutiInfoKekkaBean.getKanjisosikinm());

                        bzKokyakuAtesakiBean.setIrToiawasetantounm("");

                        bzKokyakuAtesakiBean.setIrToiawasetelno(bzGetSosikiMadogutiInfoKekkaBean.getTelno());

                        bzAtesakiBeanLst.add(bzKokyakuAtesakiBean);

                        syoruiCdKbnLst.add(C_SyoruiCdKbn.SK_HENKINTUUTILIST);
                        syoruiCdIndex = 1;

                        createReport(syoruiCdKbnLst
                            ,syoruiCdIndex
                            ,skTuutiBeanLst
                            ,bzAtesakiBeanLst
                            ,syoriCtl
                            ,mosDairiten);
                    }
                }
                syoriKensuu = syoriKensuu + 1;
            }

            batchLogger.info(MessageUtil.getMessage(MessageId.IBF0002, String.valueOf(syoriKensuu), "返金通知"));
        }
    }

    private void createReport(List<C_SyoruiCdKbn> pSyoruiCdKbnLst,int pSyoruiCdIndex, List<Object> pSkTuutiBeanLst,
        List<Object> pBzAtesakiBeanLst, HT_SyoriCTL pSyoriCtl, HT_MosDairiten pMosDairiten){

        CreateReport createReport  = SWAKInjector.getInstance(CreateReport.class);

        ReportServicesBean reportServicesBean = createReport.createNewReportServiceBean(
            kinou.getSubSystemId(),
            kinou.getCategoryId(),
            kinou.getKinouId(),
            pSyoruiCdKbnLst.toArray(new C_SyoruiCdKbn[0]));

        reportServicesBean.setKensakuKeys(
            pSyoriCtl.getSkeijimukbn().toString(),
            pMosDairiten.getOyadrtencd(),
            pSyoriCtl.getMosno());

        reportServicesBean.setSyoriYmd(bzBatchParam.getSyoriYmd());

        for (int i = 0; i < pSyoruiCdKbnLst.size(); i++) {
            reportServicesBean.addParamObjects(
                pSyoruiCdKbnLst.get(i), pSkTuutiBeanLst.get(i), pBzAtesakiBeanLst.get(i));
        }

        reportServicesBean.setSyoruiCdKbnIdx(pSyoruiCdIndex);

        createReport.execNoCommit(reportServicesBean);
    }

    private BzDairitenAtesakiBean editBzDairitenAtesakiBean(C_SyoruiCdKbn pSyoruiCdKbn, HT_MosDairiten pMosDairiten,
        BizDate pHassouYmd, C_SeirituKbn pSeirituKbn, C_Ketkekkacd pKetkekkacd, C_SkeijimuKbn pSkeijimuKbn) {
        EditDairitenAtesaki editDairitenAtesaki = SWAKInjector.getInstance(EditDairitenAtesaki.class);
        EditDairitenAtesakiBean editDairitenAtesakiBean = SWAKInjector.getInstance(EditDairitenAtesakiBean.class);
        editDairitenAtesakiBean.setSyoruiCdKbn(pSyoruiCdKbn);
        editDairitenAtesakiBean.setMosDairiten(pMosDairiten);
        editDairitenAtesakiBean.setHassouYmd(pHassouYmd);
        editDairitenAtesakiBean.setSeirituKbn(pSeirituKbn);
        editDairitenAtesakiBean.setKetkekkaCd(pKetkekkacd);
        editDairitenAtesakiBean.setSkeijimuKbn(pSkeijimuKbn);

        return editDairitenAtesaki.exec(editDairitenAtesakiBean);
    }
}