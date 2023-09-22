package yuyu.common.sinkeiyaku.skcommon;

import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.number.BizNumber;

import org.slf4j.Logger;

import yuyu.common.biz.bzcommon.BizUtil;
import yuyu.common.biz.bzdairiten.BzGetAgInfo;
import yuyu.common.biz.bzdairiten.BzGetAgInfoBean;
import yuyu.common.sinkeiyaku.moschk.MosnaiCheckParam;
import yuyu.def.biz.bean.report.BzDairitenAtesakiBean;
import yuyu.def.classification.C_DiritenjyouhouKbn;
import yuyu.def.classification.C_HknsyuruiNo;
import yuyu.def.classification.C_KykKbn;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.HT_MosDairiten;
import yuyu.def.db.entity.HT_MosKihon;
import yuyu.def.db.entity.HT_SyoriCTL;
import yuyu.def.sinkeiyaku.bean.report.SkYoteirirituhenkouBean;
import yuyu.infr.report.CreateReport;
import yuyu.infr.report.swakreport.ReportServicesBean;

/** 新契約 新契約共通 予定利率変更連絡票PDF作成
 */
public class EditPdfYoteirirtu {

    private static final int MOSNOKETASUU = 9;

    @Inject
    private static Logger logger;

    public EditPdfYoteirirtu() {
        super();
    }

    public void exec(MosnaiCheckParam pMosnaiCheckParam, BizNumber pMosymdyoteiriritu, BizNumber pKykymdyoteiriritu,
        C_UmuKbn pYoteirirituhendouumu, BizNumber pMosymdtumitateriritu, BizNumber pKykymdtumitateriritu,
        BizNumber pMosymdloadinghnkgtmttrrt, BizNumber pKykymdloadinghnkgtmttrrt,
        C_UmuKbn pTumitaterirituhendouumu, BizNumber pMosymdtmttknzoukaritujygn, BizNumber pKykymdtmttknzoukaritujygn,
        C_UmuKbn pTmttknzoukaritujygnhendouumu, BizNumber pMosymdsetteibairitu, BizNumber pKykymdsetteibairitu,
        C_UmuKbn pSetteibairituhendouumu, BizNumber pMosymdrendouritu, BizNumber pKykymdrendouritu,
        C_UmuKbn pRendourituhendouumu) {

        logger.debug("▽ 予定利率変更連絡票PDF作成 開始");

        HT_SyoriCTL syoriCTL = pMosnaiCheckParam.getDataSyoriControl();

        if (syoriCTL == null) {
            logger.debug("△ 予定利率変更連絡票PDF作成 終了");
            return;
        }

        if (syoriCTL.getYoteirirituhenkourenrakuymd() != null) {
            logger.debug("△ 予定利率変更連絡票PDF作成 終了");
            return;
        }

        String oyaDrtencd = "";
        BzGetAgInfoBean drtenInfoOutBean = SWAKInjector.getInstance(BzGetAgInfoBean.class);

        HT_MosDairiten mosDairiten = syoriCTL.getMosDairitenByRenno(1);

        if (mosDairiten != null) {
            oyaDrtencd = mosDairiten.getOyadrtencd();

            BzGetAgInfo bzGetAgInfo = SWAKInjector.getInstance(BzGetAgInfo.class);

            List<BzGetAgInfoBean> bzGetAgInfoBeanLst = bzGetAgInfo.exec(mosDairiten.getTratkiagcd());

            for (BzGetAgInfoBean bzGetAgInfoBean : bzGetAgInfoBeanLst) {
                if (C_DiritenjyouhouKbn.SHITEIKO.eq(bzGetAgInfoBean.getDiritenJyouhouKbn())) {
                    drtenInfoOutBean = bzGetAgInfoBean;
                    break;
                }
            }

        }

        String kykKj = "";
        String hhknKj = "";
        C_KykKbn kykKbn = C_KykKbn.BLNK;

        HT_MosKihon mosKihon = syoriCTL.getMosKihon();

        if (mosKihon == null) {
            logger.debug("△ 予定利率変更連絡票PDF作成 終了");
            return;
        }
        kykKj = mosKihon.getKyknmkj();
        hhknKj = mosKihon.getHhknnmkj();
        kykKbn = mosKihon.getKykkbn();
        String aisyoumei = mosKihon.getAisyoumeikbn().getContent();

        C_UmuKbn tmttrrttouHendouumu = C_UmuKbn.NONE;

        if (C_UmuKbn.ARI.eq(pTumitaterirituhendouumu) ||
            C_UmuKbn.ARI.eq(pTmttknzoukaritujygnhendouumu) ||
            C_UmuKbn.ARI.eq(pSetteibairituhendouumu) ||
            C_UmuKbn.ARI.eq(pRendourituhendouumu)) {

            tmttrrttouHendouumu = C_UmuKbn.ARI;
        }

        String tmttrrttouRayoutptn = "";

        if (C_HknsyuruiNo.GAIKAINDEXNK_TEIRITU.eq(mosKihon.getHknsyuruino())) {
            if (C_UmuKbn.ARI.eq(pTumitaterirituhendouumu)) {
                tmttrrttouRayoutptn = "1";
            }
        }
        else if (C_HknsyuruiNo.GAIKAINDEXNK_SISUU.eq(mosKihon.getHknsyuruino())) {
            if (C_UmuKbn.ARI.eq(pTumitaterirituhendouumu)) {
                if (C_UmuKbn.ARI.eq(pTmttknzoukaritujygnhendouumu)) {
                    if (C_UmuKbn.ARI.eq(pSetteibairituhendouumu)) {
                        tmttrrttouRayoutptn = "7";
                    }
                    else {
                        tmttrrttouRayoutptn = "4";
                    }
                }
                else {
                    if (C_UmuKbn.ARI.eq(pSetteibairituhendouumu)) {
                        tmttrrttouRayoutptn = "5";
                    }
                    else {
                        tmttrrttouRayoutptn = "1";
                    }
                }
            }
            else {
                if (C_UmuKbn.ARI.eq(pTmttknzoukaritujygnhendouumu)) {
                    if (C_UmuKbn.ARI.eq(pSetteibairituhendouumu)) {
                        tmttrrttouRayoutptn = "6";
                    }
                    else {
                        tmttrrttouRayoutptn = "2";
                    }
                }
                else {
                    if (C_UmuKbn.ARI.eq(pSetteibairituhendouumu)) {
                        tmttrrttouRayoutptn = "3";
                    }
                }
            }
        }

        else if (C_HknsyuruiNo.GAIKAITIJIBRISYUUSIN_19_SGARI.eq(mosKihon.getHknsyuruino())) {

            if (C_UmuKbn.ARI.eq(pTumitaterirituhendouumu)) {
                tmttrrttouRayoutptn = "8";
            }
        }

        else if (C_HknsyuruiNo.GAIKAINDEXNK_20_TEIRITUTEIKI.eq(mosKihon.getHknsyuruino())) {

            if (C_UmuKbn.ARI.eq(pTumitaterirituhendouumu)) {
                tmttrrttouRayoutptn = "1";
            }
        }

        else if (C_HknsyuruiNo.GAIKAINDEXNK_20_SISUU.eq(mosKihon.getHknsyuruino())) {

            if (C_UmuKbn.ARI.eq(pTumitaterirituhendouumu)) {
                if (C_UmuKbn.ARI.eq(pRendourituhendouumu)) {
                    tmttrrttouRayoutptn = "9";
                }
                else {
                    tmttrrttouRayoutptn = "1";
                }
            }
            else {
                if (C_UmuKbn.ARI.eq(pRendourituhendouumu)) {
                    tmttrrttouRayoutptn = "10";
                }
            }
        }

        String message1 = "";
        String message2 = "";

        if (C_UmuKbn.ARI.eq(tmttrrttouHendouumu)) {

            message1 = "積立利率等が申込日時点より変更となっていることを契約者様にご説明願います。";
            message2 = "確定した積立利率等につきましては、当社より送付いたします保険証券にも記載しております。";
        }
        else {

            if (C_HknsyuruiNo.GAIKAITIJIBRISYUUSIN_YOKUSEI.eq(mosKihon.getHknsyuruino())) {

                message1 = "予定利率が変動し、基本保険金額が申込日時点より変更となっていることを契約者様にご説明願います。";
                message2 = "確定した基本保険金額につきましては、当社より送付いたします保険証券に記載しております。";

            }
            else if (C_HknsyuruiNo.GAIKARIRITUHENDOUNK.eq(mosKihon.getHknsyuruino())) {

                message1 = "予定利率が申込日時点より変更となっていることを契約者様にご説明願います。";
                message2 = "";
            }
        }

        EditDairitenAtesaki editDairitenAtesaki = SWAKInjector.getInstance(EditDairitenAtesaki.class);
        EditDairitenAtesakiBean editDairitenAtesakiBean = SWAKInjector.getInstance(EditDairitenAtesakiBean.class);
        BizDate sysYmd = BizDate.getSysDate();

        editDairitenAtesakiBean.setSyoruiCdKbn(C_SyoruiCdKbn.SK_YOTEIRIRITUHENKOURENRAKUHYOU);
        editDairitenAtesakiBean.setMosDairiten(mosDairiten);
        editDairitenAtesakiBean.setHassouYmd(sysYmd.addBusinessDays(1));

        BzDairitenAtesakiBean bzDairitenAtesakiBean = editDairitenAtesaki.exec(editDairitenAtesakiBean);

        String irDrtenjimcd = "";

        if (!BizUtil.isBlank(drtenInfoOutBean.getDrtenJimCd())) {
            irDrtenjimcd = drtenInfoOutBean.getDrtenJimCd();
        }

        String irMosymdyoteiriritu = editSkYoteirirituhenkouBeanInfo(pMosymdyoteiriritu);
        String kykymdyoteiriritu = editSkYoteirirituhenkouBeanInfo(pKykymdyoteiriritu);
        String irMosymdtumitateriritu = editSkYoteirirituhenkouBeanInfo(pMosymdtumitateriritu);
        String irKykymdtumitateriritu = editSkYoteirirituhenkouBeanInfo(pKykymdtumitateriritu);
        String irMosymdtmttknzoukaritujygn = editSkYoteirirituhenkouBeanInfo(pMosymdtmttknzoukaritujygn);
        String irKykymdtmttknzoukaritujygn = editSkYoteirirituhenkouBeanInfo(pKykymdtmttknzoukaritujygn);
        String irMosymdsetteibairitu = editSkYoteirirituhenkouBeanInfo(pMosymdsetteibairitu);
        String irKykymdsetteibairitu = editSkYoteirirituhenkouBeanInfo(pKykymdsetteibairitu);
        String irMosymdloadinghnkgtmttrrt = editSkYoteirirituhenkouBeanInfo(pMosymdloadinghnkgtmttrrt);
        String irKykymdloadinghnkgtmttrrt = editSkYoteirirituhenkouBeanInfo(pKykymdloadinghnkgtmttrrt);
        String irMosymdrendouritu = editSkYoteirirituhenkouBeanInfo(pMosymdrendouritu);
        String irKykymdrendouritu = editSkYoteirirituhenkouBeanInfo(pKykymdrendouritu);
        String irMosno = editMosnoHyphen_3_3_3(syoriCTL.getMosno());

        SkYoteirirituhenkouBean skYoteirirituhenkouBean = SWAKInjector.getInstance(SkYoteirirituhenkouBean.class);
        skYoteirirituhenkouBean.setIrMosno(irMosno);
        skYoteirirituhenkouBean.setIrDrtenjimcd(irDrtenjimcd);
        skYoteirirituhenkouBean.setIrKykkbn(kykKbn);
        skYoteirirituhenkouBean.setIrKyknmkj(kykKj);
        skYoteirirituhenkouBean.setIrHhknnmkj(hhknKj);
        skYoteirirituhenkouBean.setIrMosymdyoteiriritu(irMosymdyoteiriritu);
        skYoteirirituhenkouBean.setIrKykymdyoteiriritu(kykymdyoteiriritu);
        skYoteirirituhenkouBean.setIrMosymdtumitateriritu(irMosymdtumitateriritu);
        skYoteirirituhenkouBean.setIrKykymdtumitateriritu(irKykymdtumitateriritu);
        skYoteirirituhenkouBean.setIrMosymdtmttknzoukaritujygn(irMosymdtmttknzoukaritujygn);
        skYoteirirituhenkouBean.setIrKykymdtmttknzoukaritujygn(irKykymdtmttknzoukaritujygn);
        skYoteirirituhenkouBean.setIrMosymdsetteibairitu(irMosymdsetteibairitu);
        skYoteirirituhenkouBean.setIrKykymdsetteibairitu(irKykymdsetteibairitu);
        skYoteirirituhenkouBean.setIrMosymdloadinghnkgtmttrrt(irMosymdloadinghnkgtmttrrt);
        skYoteirirituhenkouBean.setIrKykymdloadinghnkgtmttrrt(irKykymdloadinghnkgtmttrrt);
        skYoteirirituhenkouBean.setIrMosymdrendouritu(irMosymdrendouritu);
        skYoteirirituhenkouBean.setIrKykymdrendouritu(irKykymdrendouritu);
        skYoteirirituhenkouBean.setIrAisyoumei(aisyoumei);
        skYoteirirituhenkouBean.setIrOyadrtencd(oyaDrtencd);
        skYoteirirituhenkouBean.setIrTmttrrttouhendouumu(tmttrrttouHendouumu);
        skYoteirirituhenkouBean.setIrTmttrrttourayoutptn(tmttrrttouRayoutptn);
        skYoteirirituhenkouBean.setIrMsg1(message1);
        skYoteirirituhenkouBean.setIrMsg2(message2);

        CreateReport createReport = SWAKInjector.getInstance(CreateReport.class);

        ReportServicesBean reportServicesBean = createReport.createNewReportServiceBean(
            ISkCommonKoumoku.SUBSYSTEMID_SINKEIYAKU,
            pMosnaiCheckParam.getCategoryID(),
            pMosnaiCheckParam.getKinouID(),
            new C_SyoruiCdKbn[] {
                C_SyoruiCdKbn.SK_YOTEIRIRITUHENKOURENRAKUHYOU });

        reportServicesBean.setKensakuKeys(new String[] {
            bzDairitenAtesakiBean.getIrSkeijimukbn().getValue(),
            oyaDrtencd,
            syoriCTL.getMosno() });

        reportServicesBean.setSyoriYmd(pMosnaiCheckParam.getSysDate());
        reportServicesBean.addParamObjects(skYoteirirituhenkouBean, bzDairitenAtesakiBean);
        createReport.execNoCommit(reportServicesBean);

        logger.debug("△ 予定利率変更連絡票PDF作成 終了");
    }

    private String editMosnoHyphen_3_3_3(String pMosNo) {

        String syoriKekka = "";

        if (BizUtil.isBlank(pMosNo) || pMosNo.length() != MOSNOKETASUU) {
            syoriKekka = pMosNo;
            return syoriKekka;
        }
        StringBuffer hnsyoMosNo = new StringBuffer();
        hnsyoMosNo.append(pMosNo.substring(0, 3));
        hnsyoMosNo.append("-");
        hnsyoMosNo.append(pMosNo.substring(3, 6));
        hnsyoMosNo.append("-");
        hnsyoMosNo.append(pMosNo.substring(6));
        syoriKekka = hnsyoMosNo.toString();
        return syoriKekka;
    }

    private String editSkYoteirirituhenkouBeanInfo(BizNumber pSyorikoumoku) {

        String syoriKekka = "";

        if (pSyorikoumoku != null) {
            syoriKekka = BizUtil.comma(pSyorikoumoku.toString(), 0, 2);
            return syoriKekka;
        }
        return syoriKekka;
    }
}
