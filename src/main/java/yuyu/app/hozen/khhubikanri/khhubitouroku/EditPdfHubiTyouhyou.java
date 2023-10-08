package yuyu.app.hozen.khhubikanri.khhubitouroku;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import yuyu.app.hozen.khhubikanri.khhubitouroku.HubiList2DataSourceBean;
import yuyu.common.biz.bzcommon.BzGetSosikiMadogutiInfo;
import yuyu.common.biz.bzcommon.BzGetSosikiMadogutiInfoKekkaBean;
import yuyu.common.biz.bzcommon.DateFormatUtil;
import yuyu.common.biz.report.ViewReport;
import yuyu.common.hozen.khcommon.KhozenCommonParam;
import yuyu.common.hozen.khcommon.IKhozenCommonConstants;
import yuyu.def.biz.bean.report.BzKokyakuAtesakiBean;
import yuyu.def.biz.configuration.YuyuBizConfig;
import yuyu.def.classification.C_HassinsakiKbn;
import yuyu.def.classification.C_KhkinouModeIdKbn;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.IT_KykSya;
import yuyu.def.hozen.bean.report.KhHubisouhuannaiBean;
import yuyu.def.hozen.bean.report.KhHubituutiBean;
import yuyu.infr.report.CreateReport;
import yuyu.infr.report.swakreport.ReportServicesBean;

/**
 * 契約保全 契約保全共通 不備帳票PDF作成
 */
public class EditPdfHubiTyouhyou {

    @Inject
    private CreateReport createReport;

    public EditPdfHubiTyouhyou() {

        super();
    }

    public String exec(KhozenCommonParam pKhozenCommonParam, C_SyoruiCdKbn pSyoruiCd, String pSyoNo,
        C_KhkinouModeIdKbn pKhkinouModeIdKbn, C_UmuKbn pKarisakuseiUmu,
        String pRenrakuArea, BizDate pHubiAnswerKjt,
        List<HubiList2DataSourceBean> pHubiList2DataSourceBeanLst, BzKokyakuAtesakiBean pKokyakuAtesakiBean) {

        String tyouhyouKey = "";

        C_SyoruiCdKbn syoruiCd = pSyoruiCd;

        BizDate systemDate = BizDate.getSysDate();

        int HubiMsgCnt = pHubiList2DataSourceBeanLst.size();

        if (HubiMsgCnt == 0) {

            return tyouhyouKey;
        }

        IT_KykSya kykSya = pKhozenCommonParam.getKeiyakusya(pSyoNo);

        String tyouhyouYmd = DateFormatUtil.dateKANJI(systemDate);

        String kykKj = kykSya.getKyknmkj();

        List<Integer> kokyakuLst = new ArrayList<>();

        List<Integer> honshaLst = new ArrayList<>();

        Integer kokyaku = 0;

        Integer honsha = 0;

        List<String> hubiMsgkokyakuLst = new ArrayList<>();

        List<String> hubiMsghonshaLst = new ArrayList<>();

        C_UmuKbn honshakuUmu = C_UmuKbn.NONE;

        C_UmuKbn kokyakuUmu = C_UmuKbn.NONE;

        for (HubiList2DataSourceBean hubiList2DataSourceBean : pHubiList2DataSourceBeanLst) {

            if (C_HassinsakiKbn.KOK.eq(hubiList2DataSourceBean.getDisphassinsakikbn())) {

                kokyakuLst.add(kokyaku + 1);

                hubiMsgkokyakuLst.add(hubiList2DataSourceBean.getDisphubinaiyoumsg());

                if (C_UmuKbn.ARI.eq(hubiList2DataSourceBean.getDispgenponhnkykumu())) {

                    kokyakuUmu = C_UmuKbn.ARI;
                }
            }

            if (C_HassinsakiKbn.SYA.eq(hubiList2DataSourceBean.getDisphassinsakikbn())) {

                honshaLst.add(honsha + 1);

                hubiMsghonshaLst.add(hubiList2DataSourceBean.getDisphubinaiyoumsg());

                if (C_UmuKbn.ARI.eq(hubiList2DataSourceBean.getDispgenponhnkykumu())) {

                    honshakuUmu = C_UmuKbn.ARI;
                }
            }
        }

        String hozonKikan = ViewReport.getHozonKknTani(syoruiCd);

        KhHubituutiBean kokyakuKhHubituutiBean = new KhHubituutiBean();
        KhHubituutiBean honshaKhHubituutiBean = new KhHubituutiBean();

        List<ReportServicesBean> reportServicesBeanList = new ArrayList<>();

        String ccSosikiCd = YuyuBizConfig.getInstance().getCallcentersosikicd();

        BzGetSosikiMadogutiInfo getSosikiMadogutiInfo = SWAKInjector.getInstance(BzGetSosikiMadogutiInfo.class);

        BzGetSosikiMadogutiInfoKekkaBean getSosikiMadogutiInfoKekkaBean =
            getSosikiMadogutiInfo.exec(ccSosikiCd);

        String tawsosikiKj = getSosikiMadogutiInfoKekkaBean.getKanjisosikinm();

        if (C_UmuKbn.NONE.eq(pKarisakuseiUmu) && kokyakuLst.size() > 0) {

            String toiawaseyNo = getSosikiMadogutiInfoKekkaBean.getPostalCd();

            String toiawaseadr1Kj = getSosikiMadogutiInfoKekkaBean.getKanjisosikiadr1();

            String toiawaseadr2Kj = getSosikiMadogutiInfoKekkaBean.getKanjisosikiadr2();

            String toiawaseadr3Kj = getSosikiMadogutiInfoKekkaBean.getKanjisosikiadr3();

            String toiawaseTelNo = getSosikiMadogutiInfoKekkaBean.getTelno();

            String toiawaseTelUktkKanou1 = YuyuBizConfig.getInstance().getUketimecallcenter1();

            String toiawaseTelUktkKanou2 = YuyuBizConfig.getInstance().getUketimecallcenter2();

            String hubiAnswerKjt = DateFormatUtil.dateKANJI(pHubiAnswerKjt);

            String hknKaisyaNmKj = YuyuBizConfig.getInstance().getHokenKaisyaNmKanji();

            KhHubisouhuannaiBean khHubisouhuannaiBean = new KhHubisouhuannaiBean();

            BzKokyakuAtesakiBean kokyakuAtesakiBean = pKokyakuAtesakiBean;

            khHubisouhuannaiBean.setIrSyono(pSyoNo);

            khHubisouhuannaiBean.setIrKyknmkj(kykKj);

            khHubisouhuannaiBean.setIrRenrakuarea(pRenrakuArea);

            khHubisouhuannaiBean.setIrHubianswerkjt(hubiAnswerKjt);

            kokyakuAtesakiBean.setIrTyouhyousakuseiymd(tyouhyouYmd);

            kokyakuAtesakiBean.setIrHknkisynm(hknKaisyaNmKj);

            kokyakuAtesakiBean.setIrToiawasesosiki(tawsosikiKj);

            kokyakuAtesakiBean.setIrToiawasetantounm(pKhozenCommonParam.getUserNm());

            kokyakuAtesakiBean.setIrToiawaseyno(toiawaseyNo);

            kokyakuAtesakiBean.setIrToiawaseadr1kj(toiawaseadr1Kj);

            kokyakuAtesakiBean.setIrToiawaseadr2kj(toiawaseadr2Kj);

            kokyakuAtesakiBean.setIrToiawaseadr3kj(toiawaseadr3Kj);

            kokyakuAtesakiBean.setIrToiawasetelno(toiawaseTelNo);

            kokyakuAtesakiBean.setIrToiawaseteluktkkanou1(toiawaseTelUktkKanou1);

            kokyakuAtesakiBean.setIrToiawaseteluktkkanou2(toiawaseTelUktkKanou2);

            ReportServicesBean reportServicesBean = createReport.createNewReportServiceBean(
                IKhozenCommonConstants.SUBSYSTEMID_HOZEN,
                pKhozenCommonParam.getCategoryId(),
                pKhozenCommonParam.getFunctionId(),
                C_SyoruiCdKbn.KK_HUBITEISEISYO_SOUHU);

            reportServicesBean.setKensakuKeys(pSyoNo);

            reportServicesBean.setSyoriYmd(systemDate);

            reportServicesBean.addParamObjects(C_SyoruiCdKbn.KK_HUBITEISEISYO_SOUHU,
                new Object[]{khHubisouhuannaiBean, kokyakuAtesakiBean});

            reportServicesBean.setSyoruiCdKbnIdx(0);

            reportServicesBeanList.add(reportServicesBean);
        }

        if (kokyakuLst.size() > 0) {

            kokyakuKhHubituutiBean.setIrSyono(pSyoNo);

            kokyakuKhHubituutiBean.setIrKyknmkj(kykKj);

            kokyakuKhHubituutiBean.setIrRenno1(kokyakuLst.size() > 0 ? kokyakuLst.get(0) : 0);

            kokyakuKhHubituutiBean.setIrRenno2(kokyakuLst.size() > 1 ? kokyakuLst.get(1) : 0);

            kokyakuKhHubituutiBean.setIrRenno3(kokyakuLst.size() > 2 ? kokyakuLst.get(2) : 0);

            kokyakuKhHubituutiBean.setIrRenno4(kokyakuLst.size() > 3 ? kokyakuLst.get(3) : 0);

            kokyakuKhHubituutiBean.setIrRenno5(kokyakuLst.size() > 4 ? kokyakuLst.get(4) : 0);

            kokyakuKhHubituutiBean.setIrRenno6(kokyakuLst.size() > 5 ? kokyakuLst.get(5) : 0);

            kokyakuKhHubituutiBean.setIrRenno7(kokyakuLst.size() > 6 ? kokyakuLst.get(6) : 0);

            kokyakuKhHubituutiBean.setIrRenno8(kokyakuLst.size() > 7 ? kokyakuLst.get(7) : 0);

            kokyakuKhHubituutiBean.setIrRenno9(kokyakuLst.size() > 8 ? kokyakuLst.get(8) : 0);

            kokyakuKhHubituutiBean.setIrRenno10(kokyakuLst.size() > 9 ? kokyakuLst.get(9) : 0);

            kokyakuKhHubituutiBean.setIrHubimsg1(hubiMsgkokyakuLst.size() > 0 ? hubiMsgkokyakuLst.get(0) : "");

            kokyakuKhHubituutiBean.setIrHubimsg2(hubiMsgkokyakuLst.size() > 1 ? hubiMsgkokyakuLst.get(1) : "");

            kokyakuKhHubituutiBean.setIrHubimsg3(hubiMsgkokyakuLst.size() > 2 ? hubiMsgkokyakuLst.get(2) : "");

            kokyakuKhHubituutiBean.setIrHubimsg4(hubiMsgkokyakuLst.size() > 3 ? hubiMsgkokyakuLst.get(3) : "");

            kokyakuKhHubituutiBean.setIrHubimsg5(hubiMsgkokyakuLst.size() > 4 ? hubiMsgkokyakuLst.get(4) : "");

            kokyakuKhHubituutiBean.setIrHubimsg6(hubiMsgkokyakuLst.size() > 5 ? hubiMsgkokyakuLst.get(5) : "");

            kokyakuKhHubituutiBean.setIrHubimsg7(hubiMsgkokyakuLst.size() > 6 ? hubiMsgkokyakuLst.get(6) : "");

            kokyakuKhHubituutiBean.setIrHubimsg8(hubiMsgkokyakuLst.size() > 7 ? hubiMsgkokyakuLst.get(7) : "");

            kokyakuKhHubituutiBean.setIrHubimsg9(hubiMsgkokyakuLst.size() > 8 ? hubiMsgkokyakuLst.get(8) : "");

            kokyakuKhHubituutiBean.setIrHubimsg10(hubiMsgkokyakuLst.size() > 9 ? hubiMsgkokyakuLst.get(9) : "");

            kokyakuKhHubituutiBean.setIrToritsugisyasyozokunm(tawsosikiKj);

            kokyakuKhHubituutiBean.setIrTyouhyousakuseiymd(tyouhyouYmd);

            kokyakuKhHubituutiBean.setIrHozonkkn(hozonKikan);

            kokyakuKhHubituutiBean.setIrKhkinoumodeidkbn(pKhkinouModeIdKbn);

            kokyakuKhHubituutiBean.setIrKarisakuseiumu(pKarisakuseiUmu);

            kokyakuKhHubituutiBean.setIrGenponhnkykumu(kokyakuUmu);

            kokyakuKhHubituutiBean.setIrHubikensuu(kokyakuLst.size());

            if (C_UmuKbn.ARI.eq(pKarisakuseiUmu)) {

                syoruiCd = C_SyoruiCdKbn.KK_HUBI_KARISAKUSEI;
            }

            ReportServicesBean reportServicesBean = createReport.createNewReportServiceBean(
                IKhozenCommonConstants.SUBSYSTEMID_HOZEN,
                pKhozenCommonParam.getCategoryId(),
                pKhozenCommonParam.getFunctionId(),
                syoruiCd);

            reportServicesBean.setKensakuKeys(pSyoNo);

            reportServicesBean.setSyoriYmd(systemDate);

            reportServicesBean.addParamObjects(syoruiCd, kokyakuKhHubituutiBean);

            reportServicesBean.setSyoruiCdKbnIdx(0);

            reportServicesBeanList.add(reportServicesBean);
        }

        if (honshaLst.size() > 0) {

            honshaKhHubituutiBean.setIrSyono(pSyoNo);

            honshaKhHubituutiBean.setIrKyknmkj(kykKj);

            honshaKhHubituutiBean.setIrRenno1(honshaLst.size() > 0 ? honshaLst.get(0) : 0);

            honshaKhHubituutiBean.setIrRenno2(honshaLst.size() > 1 ? honshaLst.get(1) : 0);

            honshaKhHubituutiBean.setIrRenno3(honshaLst.size() > 2 ? honshaLst.get(2) : 0);

            honshaKhHubituutiBean.setIrRenno4(honshaLst.size() > 3 ? honshaLst.get(3) : 0);

            honshaKhHubituutiBean.setIrRenno5(honshaLst.size() > 4 ? honshaLst.get(4) : 0);

            honshaKhHubituutiBean.setIrRenno6(honshaLst.size() > 5 ? honshaLst.get(5) : 0);

            honshaKhHubituutiBean.setIrRenno7(honshaLst.size() > 6 ? honshaLst.get(6) : 0);

            honshaKhHubituutiBean.setIrRenno8(honshaLst.size() > 7 ? honshaLst.get(7) : 0);

            honshaKhHubituutiBean.setIrRenno9(honshaLst.size() > 8 ? honshaLst.get(8) : 0);

            honshaKhHubituutiBean.setIrRenno10(honshaLst.size() > 9 ? honshaLst.get(9) : 0);

            honshaKhHubituutiBean.setIrHubimsg1(hubiMsghonshaLst.size() > 0 ? hubiMsghonshaLst.get(0) : "");

            honshaKhHubituutiBean.setIrHubimsg2(hubiMsghonshaLst.size() > 1 ? hubiMsghonshaLst.get(1) : "");

            honshaKhHubituutiBean.setIrHubimsg3(hubiMsghonshaLst.size() > 2 ? hubiMsghonshaLst.get(2) : "");

            honshaKhHubituutiBean.setIrHubimsg4(hubiMsghonshaLst.size() > 3 ? hubiMsghonshaLst.get(3) : "");

            honshaKhHubituutiBean.setIrHubimsg5(hubiMsghonshaLst.size() > 4 ? hubiMsghonshaLst.get(4) : "");

            honshaKhHubituutiBean.setIrHubimsg6(hubiMsghonshaLst.size() > 5 ? hubiMsghonshaLst.get(5) : "");

            honshaKhHubituutiBean.setIrHubimsg7(hubiMsghonshaLst.size() > 6 ? hubiMsghonshaLst.get(6) : "");

            honshaKhHubituutiBean.setIrHubimsg8(hubiMsghonshaLst.size() > 7 ? hubiMsghonshaLst.get(7) : "");

            honshaKhHubituutiBean.setIrHubimsg9(hubiMsghonshaLst.size() > 8 ? hubiMsghonshaLst.get(8) : "");

            honshaKhHubituutiBean.setIrHubimsg10(hubiMsghonshaLst.size() > 9 ? hubiMsghonshaLst.get(9) : "");

            honshaKhHubituutiBean.setIrToritsugisyasyozokunm(tawsosikiKj);

            honshaKhHubituutiBean.setIrTyouhyousakuseiymd(tyouhyouYmd);

            honshaKhHubituutiBean.setIrHozonkkn(hozonKikan);

            honshaKhHubituutiBean.setIrKhkinoumodeidkbn(pKhkinouModeIdKbn);

            honshaKhHubituutiBean.setIrKarisakuseiumu(pKarisakuseiUmu);

            honshaKhHubituutiBean.setIrGenponhnkykumu(honshakuUmu);

            honshaKhHubituutiBean.setIrHubikensuu(honshaLst.size());

            if (C_UmuKbn.ARI.eq(pKarisakuseiUmu)) {

                syoruiCd = C_SyoruiCdKbn.KK_HUBI_KARISAKUSEI;
            }

            ReportServicesBean reportServicesBean = createReport.createNewReportServiceBean(
                IKhozenCommonConstants.SUBSYSTEMID_HOZEN,
                pKhozenCommonParam.getCategoryId(),
                pKhozenCommonParam.getFunctionId(),
                syoruiCd);

            reportServicesBean.setKensakuKeys(pSyoNo);

            reportServicesBean.setSyoriYmd(systemDate);

            reportServicesBean.addParamObjects(syoruiCd, honshaKhHubituutiBean);

            reportServicesBean.setSyoruiCdKbnIdx(0);

            reportServicesBeanList.add(reportServicesBean);
        }

        tyouhyouKey = createReport.execNoCommit(reportServicesBeanList);

        return tyouhyouKey;
    }
}