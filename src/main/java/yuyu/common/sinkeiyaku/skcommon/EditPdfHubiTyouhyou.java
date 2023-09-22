package yuyu.common.sinkeiyaku.skcommon;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import yuyu.common.biz.bzcommon.BizUtil;
import yuyu.common.biz.bzcommon.EditSecurityKm;
import yuyu.common.biz.bzdairiten.BzGetAgInfo;
import yuyu.common.biz.bzdairiten.BzGetAgInfoBean;
import yuyu.common.sinkeiyaku.moschk.MosnaiCheckParam;
import yuyu.common.sinkeiyaku.prereport.SinkeiyakuPreReportRenkeiBean;
import yuyu.def.biz.bean.report.BzDairitenAtesakiBean;
import yuyu.def.classification.C_DiritenjyouhouKbn;
import yuyu.def.classification.C_KykKbn;
import yuyu.def.classification.C_SkeijimuKbn;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.HM_SkHubiKoumoku;
import yuyu.def.db.entity.HM_SkHubiNaiyou;
import yuyu.def.db.entity.HM_SkSeibiSijiNaiyou;
import yuyu.def.db.entity.HT_MosDairiten;
import yuyu.def.db.entity.HT_MosKihon;
import yuyu.def.db.entity.HT_SkHubi;
import yuyu.def.db.entity.HT_SkHubiDetail;
import yuyu.def.db.entity.HT_SyoriCTL;
import yuyu.def.sinkeiyaku.bean.report.SkHubituutiBean;
import yuyu.def.sinkeiyaku.bean.report.SkHubituutityoubunDataSourceBean;
import yuyu.def.sinkeiyaku.manager.SinkeiyakuDomManager;
import yuyu.infr.report.CreateReport;
import yuyu.infr.report.swakreport.IReportDataSouceBean;
import yuyu.infr.report.swakreport.ReportServicesBean;

/**
 * 新契約 新契約共通 不備帳票ＰＤＦ作成
 */
public class EditPdfHubiTyouhyou {

    public static final int MOSNOKETASU = 9;

    @Inject
    private GetSkChannelInfo getSkChannelInfo;

    @Inject
    private CreateReport createReport;

    @Inject
    private GetSyoruicd getSyoruicd;

    @Inject
    private SinkeiyakuDomManager sinkeiyakuDomManager;

    public EditPdfHubiTyouhyou() {
        super();
    }

    public String execBatch(String pHubiSikibetuKey, MosnaiCheckParam pChkParam, BizDate pHasinymd) {
        return execMain(pHubiSikibetuKey, pChkParam, pHasinymd, true);
    }
    public String exec(String pHubiSikibetuKey, MosnaiCheckParam pChkParam, BizDate pHasinymd) {
        return execMain(pHubiSikibetuKey, pChkParam, pHasinymd, false);
    }
    private String execMain(String pHubiSikibetuKey, MosnaiCheckParam pChkParam, BizDate pHasinymd, boolean pIsBatch) {

        String tyouhyouKey = "";
        HT_SyoriCTL syoriCTL = pChkParam.getDataSyoriControl();
        SinkeiyakuPreReportRenkeiBean sinkeiyakuPreReportRenkeiBean = SWAKInjector.getInstance(SinkeiyakuPreReportRenkeiBean.class);

        if (syoriCTL == null) {
            return tyouhyouKey;
        }

        sinkeiyakuPreReportRenkeiBean.setMosNo(syoriCTL.getMosno());
        sinkeiyakuPreReportRenkeiBean.setBzWorkflowInfo(null);
        sinkeiyakuPreReportRenkeiBean.setSyoriComment("");
        sinkeiyakuPreReportRenkeiBean.setTskNm("");
        if (pIsBatch) {
            sinkeiyakuPreReportRenkeiBean.setSakuseizumiKouteikanriId(null);
        }

        HT_SkHubi skHub = syoriCTL.getSkHubiByHubisikibetukey(pHubiSikibetuKey);

        if (skHub == null) {
            return tyouhyouKey;
        }

        String mosNo = skHub.getMosno();
        String tairitenToriakaijyaNm = skHub.getTuutisakitantounmkj();
        String hokengaishaTantoushaNm = skHub.getTuutikyokasyanmkj();
        String utdskKnNm1 = skHub.getUtdskknnm1kj();
        String utdskKnNm2 = skHub.getUtdskknnm2kj();
        BzDairitenAtesakiBean bzDairitenAtesakiBean = SWAKInjector.getInstance(BzDairitenAtesakiBean.class);
        SkHubituutiBean skHubituutiBean = SWAKInjector.getInstance(SkHubituutiBean.class);
        ArrayList<IReportDataSouceBean> skHubituutityoubunDataSourceBeanLst = new ArrayList<>();
        BzGetAgInfo bzGetAgInfo = SWAKInjector.getInstance(BzGetAgInfo.class);

        List<HT_SkHubiDetail> skHubiDetailLst =
            sinkeiyakuDomManager.getSkHubiDetailsByHubisikibetukeyHasinkyokaKbnHasinymd(pHubiSikibetuKey);
        if (skHubiDetailLst.size() == 0) {
            return tyouhyouKey;
        }

        HT_MosKihon mosKihon = syoriCTL.getMosKihon();
        HT_MosDairiten mosDairiten = syoriCTL.getMosDairitenByRenno(1);
        C_UmuKbn mosNrkUmu = syoriCTL.getMosnrkumu();

        String souhuMdStr = "";

        String drtenCd = "";
        String drtenJimCd = "";
        String drtenNm = "";
        String oyadrtenCd = "";

        if (C_UmuKbn.ARI.eq(mosNrkUmu) && mosDairiten != null) {

            drtenCd = mosDairiten.getTratkiagcd();
            List<BzGetAgInfoBean> bzGetAgInfoBeanLst = bzGetAgInfo.exec(drtenCd);
            for (BzGetAgInfoBean bzGetAgInfoBean : bzGetAgInfoBeanLst) {
                if (C_DiritenjyouhouKbn.SHITEIKO.eq(bzGetAgInfoBean.getDiritenJyouhouKbn())) {
                    oyadrtenCd = bzGetAgInfoBean.getOyadrtenCd();
                    drtenJimCd = bzGetAgInfoBean.getDrtenJimCd();
                    drtenNm = bzGetAgInfoBean.getKanjiDairitenNm();
                    break;
                }

            }
        }

        C_KykKbn kykKbn = C_KykKbn.BLNK;
        String kykKj = "";
        String hhknKj = "";
        String aisyouMei = "";
        String setMosNo = "";

        if (C_UmuKbn.ARI.eq(mosNrkUmu) && mosKihon != null) {
            kykKbn = mosKihon.getKykkbn();
            kykKj = mosKihon.getKyknmkj();
            hhknKj = mosKihon.getHhknnmkj();
            aisyouMei = mosKihon.getAisyoumeikbn().getContent();
            setMosNo = mosKihon.getAitemosno();

        }

        getSkChannelInfo.exec(null, oyadrtenCd);
        C_SkeijimuKbn skeiJimuKbn = getSkChannelInfo.getSkeiJimuKbn();

        String sapodeTelNo = getSkChannelInfo.getSapodetelno();
        String sapodeFaxNo = "";
        String faxTitle = "";

        if (!C_SkeijimuKbn.SHOP.eq(skeiJimuKbn)) {
            sapodeFaxNo = getSkChannelInfo.getSapodefaxno();
            faxTitle = "FAX：";
        }

        String[] skHubiKoumokus = new String[3];
        String[] skHubiNaiyous = new String[3];
        String[] skSeibishijiNaiyous = new String[3];
        String[] skHubiKoumoku_Tyoubuns = new String[3];
        String[] skHubiNaiyou_Tyoubuns = new String[3];
        String[] skSeibishijiNaiyou_Tyoubuns = new String[3];
        String[] skRenrakuJikou_Tyoubuns = new String[3];
        C_UmuKbn tyoubunFlg = C_UmuKbn.NONE;
        String[] skRenrakuJikous = new String[3];
        String skHubiKoumoku = null;
        String skHubiNaiyou = null;
        String skSeibishijiNaiyou = null;
        String skRenrakuJikou = null;
        int tuujyouCount = 0;
        int tyoubunCount = 0;
        int index = 0;

        while (index < skHubiDetailLst.size()) {

            HT_SkHubiDetail skHubiDetail = skHubiDetailLst.get(index);

            HM_SkHubiNaiyou skHubiNaiyouMasuta =
                sinkeiyakuDomManager.getSkHubiNaiyou(skHubiDetail.getSkhubikoumokucd(), skHubiDetail.getSkhubinaiyoucd());

            HM_SkHubiKoumoku skHubiKoumokuMasuta =
                sinkeiyakuDomManager.getSkHubiKoumoku(skHubiDetail.getSyoruiCd(), skHubiDetail.getSkhubikoumokucd());

            HM_SkSeibiSijiNaiyou skSeibiSijiNaiyou =
                sinkeiyakuDomManager.getSkSeibiSijiNaiyou(skHubiDetail.getSkseibisijinaiyoucd());

            tyoubunFlg = skHubiDetail.getTyoubunflg();

            skRenrakuJikou = EditSecurityKm.getDecodeData(mosNo, skHubiDetail.getSkrenrakujikou());

            if (skHubiKoumokuMasuta != null) {
                skHubiKoumoku = skHubiKoumokuMasuta.getSkhubikoumoku();
            }
            else {
                skHubiKoumoku = "";
            }

            if (skHubiNaiyouMasuta != null) {
                skHubiNaiyou = skHubiNaiyouMasuta.getSkhubinaiyou();
            }
            else {
                skHubiNaiyou = "";
            }

            if (skSeibiSijiNaiyou != null) {
                skSeibishijiNaiyou = skSeibiSijiNaiyou.getSkseibisijinaiyou();
            }
            else {
                skSeibishijiNaiyou = "";
            }

            if (C_UmuKbn.ARI.eq(tyoubunFlg)) {
                skHubiNaiyou_Tyoubuns[tyoubunCount] = skHubiNaiyou;
                skHubiKoumoku_Tyoubuns[tyoubunCount] = skHubiKoumoku;
                skSeibishijiNaiyou_Tyoubuns[tyoubunCount] = skSeibishijiNaiyou;
                skRenrakuJikou_Tyoubuns[tyoubunCount] = skRenrakuJikou;
                tyoubunCount++;
            }
            else {
                skHubiNaiyous[tuujyouCount] = skHubiNaiyou;
                skHubiKoumokus[tuujyouCount] = skHubiKoumoku;
                skSeibishijiNaiyous[tuujyouCount] = skSeibishijiNaiyou;
                skRenrakuJikous[tuujyouCount] = skRenrakuJikou;
                tuujyouCount++;
            }

            index++;
        }

        String tyouhyouMosNo= editMosnoHyphen_3_3_3(mosNo);

        String tyouhyouSetMosNo= editMosnoHyphen_3_3_3(setMosNo);

        skHubituutiBean.setIrKykkbn(kykKbn);
        skHubituutiBean.setIrMosno(tyouhyouMosNo);
        skHubituutiBean.setIrAitemosno(tyouhyouSetMosNo);
        skHubituutiBean.setIrDrtenjimcd(drtenJimCd);
        skHubituutiBean.setIrKyknmkj(kykKj);
        skHubituutiBean.setIrHhknnmkj(hhknKj);
        skHubituutiBean.setIrSkhubikoumoku1(skHubiKoumokus[0]);
        skHubituutiBean.setIrSkhubinaiyou1(skHubiNaiyous[0]);
        skHubituutiBean.setIrSkseibisijinaiyou1(skSeibishijiNaiyous[0]);
        skHubituutiBean.setIrSkrenrakujikou1(skRenrakuJikous[0]);
        skHubituutiBean.setIrSkhubikoumoku2(skHubiKoumokus[1]);
        skHubituutiBean.setIrSkhubinaiyou2(skHubiNaiyous[1]);
        skHubituutiBean.setIrSkseibisijinaiyou2(skSeibishijiNaiyous[1]);
        skHubituutiBean.setIrSkrenrakujikou2(skRenrakuJikous[1]);
        skHubituutiBean.setIrSkhubikoumoku3(skHubiKoumokus[2]);
        skHubituutiBean.setIrSkhubinaiyou3(skHubiNaiyous[2]);
        skHubituutiBean.setIrSkseibisijinaiyou3(skSeibishijiNaiyous[2]);
        skHubituutiBean.setIrSkrenrakujikou3(skRenrakuJikous[2]);
        skHubituutiBean.setIrTyoubunouthubikensuu(tyoubunCount);
        skHubituutiBean.setIrTuujyououthubikensuu(tuujyouCount);
        skHubituutiBean.setIrOyadrtencd(oyadrtenCd);
        skHubituutiBean.setIrAisyoumei(aisyouMei);

        if (!BizUtil.isBlank(utdskKnNm2)) {
            utdskKnNm2 = "（" + utdskKnNm2 + "）";
        }

        bzDairitenAtesakiBean.setIrDrtennmkj(drtenNm);
        bzDairitenAtesakiBean.setIrTratkitantounmkj(tairitenToriakaijyaNm);
        bzDairitenAtesakiBean.setIrDrtenutdskknnm1(utdskKnNm1);
        bzDairitenAtesakiBean.setIrDrtenutdskknnm2(utdskKnNm2);
        bzDairitenAtesakiBean.setIrDrtenhassouymd(souhuMdStr);
        bzDairitenAtesakiBean.setIrToiawasefaxmidasi(faxTitle);
        bzDairitenAtesakiBean.setIrToiawasetantounm(hokengaishaTantoushaNm);
        bzDairitenAtesakiBean.setIrToiawasetelno(sapodeTelNo);
        bzDairitenAtesakiBean.setIrToiawasefaxno(sapodeFaxNo);
        bzDairitenAtesakiBean.setIrSkeijimukbn(skeiJimuKbn);

        if (tyoubunCount > 0) {
            for (int i = 0; i < tyoubunCount; i++) {

                SkHubituutityoubunDataSourceBean skHubituutityoubunDataSourceBean =
                    SWAKInjector.getInstance(SkHubituutityoubunDataSourceBean.class);
                skHubituutityoubunDataSourceBean.setIrSkhubikoumoku(skHubiKoumoku_Tyoubuns[i]);
                skHubituutityoubunDataSourceBean.setIrSkhubinaiyou(skHubiNaiyou_Tyoubuns[i]);
                skHubituutityoubunDataSourceBean.setIrSkseibisijinaiyou(skSeibishijiNaiyou_Tyoubuns[i]);
                skHubituutityoubunDataSourceBean.setIrSkrenrakujikou(skRenrakuJikou_Tyoubuns[i]);
                skHubituutityoubunDataSourceBeanLst.add(skHubituutityoubunDataSourceBean);
            }
        }

        C_SyoruiCdKbn syoruiCdKbn = getSyoruicd.getSyoruicd_Hubituuti();

        ReportServicesBean reportServicesBean = createReport.createNewReportServiceBean(
            ISkCommonKoumoku.SUBSYSTEMID_SINKEIYAKU,
            pChkParam.getCategoryID(),
            pChkParam.getKinouID(),
            syoruiCdKbn);

        reportServicesBean.setKensakuKeys(new String[] {skeiJimuKbn.getValue(), oyadrtenCd, mosNo});
        reportServicesBean.setSyoriYmd(pChkParam.getSysDate());

        if (!C_SyoruiCdKbn.BLNK.eq(syoruiCdKbn)) {
            reportServicesBean.addParamObjects(syoruiCdKbn, skHubituutityoubunDataSourceBeanLst, skHubituutiBean,
                bzDairitenAtesakiBean);
        }

        tyouhyouKey = createReport.execNoCommit(reportServicesBean);
        for (HT_SkHubiDetail skHubiDetail : skHubiDetailLst) {

            skHubiDetail.setHasinymd(pHasinymd);
            skHubiDetail.setGyoumuKousinsyaId(pChkParam.getKosID());
            skHubiDetail.setGyoumuKousinTime(pChkParam.getKosTime());

        }

        return tyouhyouKey;
    }

    private String editMosnoHyphen_3_3_3(String pMosNo) {

        if (BizUtil.isBlank(pMosNo) || pMosNo.length() != MOSNOKETASU) {
            return pMosNo;
        }
        String mosNo = pMosNo.substring(0, 3) + "-" + pMosNo.substring(3, 6) + "-" + pMosNo.substring(6);

        return mosNo;
    }
}