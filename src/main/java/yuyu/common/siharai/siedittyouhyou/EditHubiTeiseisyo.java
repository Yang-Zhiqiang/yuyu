package yuyu.common.siharai.siedittyouhyou;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.bizinfr.exception.BizAppException;
import jp.co.slcs.swak.core.inject.SWAKInjector;

import org.slf4j.Logger;

import yuyu.common.biz.bzcommon.DateFormatUtil;
import yuyu.common.biz.report.ViewReport;
import yuyu.def.MessageId;
import yuyu.def.biz.bean.report.BzSksKaisyasiyouranBean;
import yuyu.def.classification.C_HassinsakiKbn;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.AS_Kinou;
import yuyu.def.siharai.bean.report.SiHubiteiseiBean;
import yuyu.infr.report.CreateReport;
import yuyu.infr.report.swakreport.ReportServicesBean;

/**
 * 保険金給付金支払 保険金給付金支払帳票編集 不備訂正書編集
 */
public class EditHubiTeiseisyo {
    @Inject
    private AS_Kinou kinou;

    @Inject
    private static Logger logger;

    @Inject
    private CreateReport createReport;

    public EditHubiTeiseisyo(){
        super();
    }

    public EditHubiTeiseisyoBean exec(HubiTeiseisyoBean pHubiTeiseisyoBean) {
        logger.debug("▽ 不備訂正書編集 開始");

        if (pHubiTeiseisyoBean.getSiTyouhyouHensyuuCommonBean().getSyoriYmd() == null) {
            throw new BizAppException(MessageId.EJS1005, "syoriYmd");
        }
        if (pHubiTeiseisyoBean.getSiTyouhyouHensyuuCommonBean().getSyoruiCd() == null
                || C_SyoruiCdKbn.BLNK.eq(pHubiTeiseisyoBean.getSiTyouhyouHensyuuCommonBean().getSyoruiCd())) {
            throw new BizAppException(MessageId.EJS1005, "syoruiCd");
        }

        C_UmuKbn karihyoujiUmu;
        if (pHubiTeiseisyoBean.getKarisakusei()) {
            karihyoujiUmu = C_UmuKbn.ARI;
        }
        else {
            karihyoujiUmu = C_UmuKbn.NONE;
        }
        C_SyoruiCdKbn syoruiCd = pHubiTeiseisyoBean.getSiTyouhyouHensyuuCommonBean().getSyoruiCd();
        String hozonKknTani = ViewReport.getHozonKknTani(syoruiCd);
        List<String> fubiNaiyouMsgLstKok = new ArrayList<>();
        List<String> fubiNaiyouMsgLstSisya = new ArrayList<>();
        List<String> fubiNaiyouMsgLstHonsya = new ArrayList<>();
        C_UmuKbn genponhnkyHyoujiUmuKok = C_UmuKbn.NONE;
        C_UmuKbn genponhnkyHyoujiUmuSisya = C_UmuKbn.NONE;
        C_UmuKbn genponhnkyHyoujiUmuHonsya = C_UmuKbn.NONE;
        for (int idx = 0;idx < pHubiTeiseisyoBean.getHubiTeiseisyoItiranLst().size();idx++) {
            EditHubiTeiseisyoItiranBean editHubiTeiseisyoItiranBean = pHubiTeiseisyoBean.getHubiTeiseisyoItiranLst()
                    .get(idx);
            if (C_HassinsakiKbn.KOK.eq(editHubiTeiseisyoItiranBean.getHassinsakiKbn())) {
                fubiNaiyouMsgLstKok.add(editHubiTeiseisyoItiranBean.getHubinaiyoumsg());
                if (C_UmuKbn.ARI.eq(editHubiTeiseisyoItiranBean.getGenponhnkykumu())) {
                    genponhnkyHyoujiUmuKok = C_UmuKbn.ARI;
                }
            }
            else if (C_HassinsakiKbn.SISYA.eq(editHubiTeiseisyoItiranBean.getHassinsakiKbn())) {
                fubiNaiyouMsgLstSisya.add(editHubiTeiseisyoItiranBean.getHubinaiyoumsg());
                if (C_UmuKbn.ARI.eq(editHubiTeiseisyoItiranBean.getGenponhnkykumu())) {
                    genponhnkyHyoujiUmuSisya = C_UmuKbn.ARI;
                }
            }
            else if (C_HassinsakiKbn.SYA.eq(editHubiTeiseisyoItiranBean.getHassinsakiKbn())) {
                fubiNaiyouMsgLstHonsya.add(editHubiTeiseisyoItiranBean.getHubinaiyoumsg());
                if (C_UmuKbn.ARI.eq(editHubiTeiseisyoItiranBean.getGenponhnkykumu())) {
                    genponhnkyHyoujiUmuHonsya = C_UmuKbn.ARI;
                }
            }
        }
        EditHubiTeiseisyoBean editHubiTeiseisyoBean = SWAKInjector.getInstance(EditHubiTeiseisyoBean.class);
        BzSksKaisyasiyouranBean bzSksKaisyasiyouranBean = SWAKInjector.getInstance(BzSksKaisyasiyouranBean.class);
        bzSksKaisyasiyouranBean.setIrToritsugisyasyozokunm(pHubiTeiseisyoBean.getToritsugisyaSosikinm());
        bzSksKaisyasiyouranBean.setIrToritsugisyakjncd(pHubiTeiseisyoBean.getToritsugisyakjncd());
        bzSksKaisyasiyouranBean.setIrToritsugisyanm(pHubiTeiseisyoBean.getToritsugisyakjnmei());
        bzSksKaisyasiyouranBean.setIrTyouhyousakuseiymd(DateFormatUtil.dateKANJINoEx(pHubiTeiseisyoBean
                .getSiTyouhyouHensyuuCommonBean().getSyoriYmd()));
        bzSksKaisyasiyouranBean.setIrHozonkkn(hozonKknTani);
        if (fubiNaiyouMsgLstKok.size() > 0) {
            C_UmuKbn pageinfoHyoujiUmuKok;
            if (fubiNaiyouMsgLstKok.size() > 5) {
                pageinfoHyoujiUmuKok = C_UmuKbn.ARI;
            }
            else {
                pageinfoHyoujiUmuKok = C_UmuKbn.NONE;
            }
            SiHubiteiseiBean siHubiteiseiBean = SWAKInjector.getInstance(SiHubiteiseiBean.class);
            siHubiteiseiBean.setIrSyono(pHubiTeiseisyoBean.getSyono());
            siHubiteiseiBean.setIrSeikyuusyanmkj(pHubiTeiseisyoBean.getSeikyuusyanmKj());
            siHubiteiseiBean.setIrRenno1(1);
            siHubiteiseiBean.setIrHubimsg1(fubiNaiyouMsgLstKok.get(0));
            if (fubiNaiyouMsgLstKok.size() < 2) {
            }
            else {
                siHubiteiseiBean.setIrRenno2(2);
                siHubiteiseiBean.setIrHubimsg2(fubiNaiyouMsgLstKok.get(1));
            }
            if (fubiNaiyouMsgLstKok.size() < 3) {
            }
            else {
                siHubiteiseiBean.setIrRenno3(3);
                siHubiteiseiBean.setIrHubimsg3(fubiNaiyouMsgLstKok.get(2));
            }
            if (fubiNaiyouMsgLstKok.size() < 4) {
            }
            else {
                siHubiteiseiBean.setIrRenno4(4);
                siHubiteiseiBean.setIrHubimsg4(fubiNaiyouMsgLstKok.get(3));
            }
            if (fubiNaiyouMsgLstKok.size() < 5) {
            }
            else {
                siHubiteiseiBean.setIrRenno5(5);
                siHubiteiseiBean.setIrHubimsg5(fubiNaiyouMsgLstKok.get(4));
            }
            if (fubiNaiyouMsgLstKok.size() < 6) {
            }
            else {
                siHubiteiseiBean.setIrRenno6(6);
                siHubiteiseiBean.setIrHubimsg6(fubiNaiyouMsgLstKok.get(5));
            }
            if (fubiNaiyouMsgLstKok.size() < 7) {
            }
            else {
                siHubiteiseiBean.setIrRenno7(7);
                siHubiteiseiBean.setIrHubimsg7(fubiNaiyouMsgLstKok.get(6));
            }
            if (fubiNaiyouMsgLstKok.size() < 8) {
            }
            else {
                siHubiteiseiBean.setIrRenno8(8);
                siHubiteiseiBean.setIrHubimsg8(fubiNaiyouMsgLstKok.get(7));
            }
            if (fubiNaiyouMsgLstKok.size() < 9) {
            }
            else {
                siHubiteiseiBean.setIrRenno9(9);
                siHubiteiseiBean.setIrHubimsg9(fubiNaiyouMsgLstKok.get(8));
            }
            if (fubiNaiyouMsgLstKok.size() < 10) {
            }
            else {
                siHubiteiseiBean.setIrRenno10(10);
                siHubiteiseiBean.setIrHubimsg10(fubiNaiyouMsgLstKok.get(9));
            }
            siHubiteiseiBean.setIrPageinfohyoujiumu(pageinfoHyoujiUmuKok);
            siHubiteiseiBean.setIrKarisakuseiumu(karihyoujiUmu);
            siHubiteiseiBean.setIrGenponhnkykumu(genponhnkyHyoujiUmuKok);
            ReportServicesBean reportServicesBeanKok= createReport.createNewReportServiceBean(
                    kinou.getSubSystemId(), kinou.getCategoryId(), kinou.getKinouId(),
                    pHubiTeiseisyoBean.getSiTyouhyouHensyuuCommonBean().getSyoruiCd());
            reportServicesBeanKok.setKensakuKeys(pHubiTeiseisyoBean.getSyono());
            reportServicesBeanKok.setSyoriYmd(pHubiTeiseisyoBean.getSiTyouhyouHensyuuCommonBean().getSyoriYmd());
            reportServicesBeanKok.addParamObjects(siHubiteiseiBean,bzSksKaisyasiyouranBean);
            editHubiTeiseisyoBean.setReportServicesBeanKok(reportServicesBeanKok);
        }
        if (fubiNaiyouMsgLstSisya.size() > 0) {
            C_UmuKbn pageinfoHyoujiUmuSisya;
            if (fubiNaiyouMsgLstSisya.size() > 5) {
                pageinfoHyoujiUmuSisya = C_UmuKbn.ARI;
            }
            else {
                pageinfoHyoujiUmuSisya = C_UmuKbn.NONE;
            }
            SiHubiteiseiBean siHubiteiseiBean = SWAKInjector.getInstance(SiHubiteiseiBean.class);
            siHubiteiseiBean.setIrSyono(pHubiTeiseisyoBean.getSyono());
            siHubiteiseiBean.setIrSeikyuusyanmkj(pHubiTeiseisyoBean.getSeikyuusyanmKj());
            siHubiteiseiBean.setIrRenno1(1);
            siHubiteiseiBean.setIrHubimsg1(fubiNaiyouMsgLstSisya.get(0));
            if (fubiNaiyouMsgLstSisya.size() < 2) {
            }
            else {
                siHubiteiseiBean.setIrRenno2(2);
                siHubiteiseiBean.setIrHubimsg2(fubiNaiyouMsgLstSisya.get(1));
            }
            if (fubiNaiyouMsgLstSisya.size() < 3) {
            }
            else {
                siHubiteiseiBean.setIrRenno3(3);
                siHubiteiseiBean.setIrHubimsg3(fubiNaiyouMsgLstSisya.get(2));
            }
            if (fubiNaiyouMsgLstSisya.size() < 4) {
            }
            else {
                siHubiteiseiBean.setIrRenno4(4);
                siHubiteiseiBean.setIrHubimsg4(fubiNaiyouMsgLstSisya.get(3));
            }
            if (fubiNaiyouMsgLstSisya.size() < 5) {
            }
            else {
                siHubiteiseiBean.setIrRenno5(5);
                siHubiteiseiBean.setIrHubimsg5(fubiNaiyouMsgLstSisya.get(4));
            }
            if (fubiNaiyouMsgLstSisya.size() < 6) {
            }
            else {
                siHubiteiseiBean.setIrRenno6(6);
                siHubiteiseiBean.setIrHubimsg6(fubiNaiyouMsgLstSisya.get(5));
            }
            if (fubiNaiyouMsgLstSisya.size() < 7) {
            }
            else {
                siHubiteiseiBean.setIrRenno7(7);
                siHubiteiseiBean.setIrHubimsg7(fubiNaiyouMsgLstSisya.get(6));
            }
            if (fubiNaiyouMsgLstSisya.size() < 8) {
            }
            else {
                siHubiteiseiBean.setIrRenno8(8);
                siHubiteiseiBean.setIrHubimsg8(fubiNaiyouMsgLstSisya.get(7));
            }
            if (fubiNaiyouMsgLstSisya.size() < 9) {
            }
            else {
                siHubiteiseiBean.setIrRenno9(9);
                siHubiteiseiBean.setIrHubimsg9(fubiNaiyouMsgLstSisya.get(8));
            }
            if (fubiNaiyouMsgLstSisya.size() < 10) {
            }
            else {
                siHubiteiseiBean.setIrRenno10(10);
                siHubiteiseiBean.setIrHubimsg10(fubiNaiyouMsgLstSisya.get(9));
            }
            siHubiteiseiBean.setIrPageinfohyoujiumu(pageinfoHyoujiUmuSisya);
            siHubiteiseiBean.setIrKarisakuseiumu(karihyoujiUmu);
            siHubiteiseiBean.setIrGenponhnkykumu(genponhnkyHyoujiUmuSisya);
            ReportServicesBean reportServicesBeanSisya= createReport.createNewReportServiceBean(
                    kinou.getSubSystemId(), kinou.getCategoryId(), kinou.getKinouId(),
                    pHubiTeiseisyoBean.getSiTyouhyouHensyuuCommonBean().getSyoruiCd());
            reportServicesBeanSisya.setKensakuKeys(pHubiTeiseisyoBean.getSyono());
            reportServicesBeanSisya.setSyoriYmd(pHubiTeiseisyoBean.getSiTyouhyouHensyuuCommonBean().getSyoriYmd());
            reportServicesBeanSisya.addParamObjects(siHubiteiseiBean,bzSksKaisyasiyouranBean);
            editHubiTeiseisyoBean.setReportServicesBeanSisya(reportServicesBeanSisya);
        }
        if (fubiNaiyouMsgLstHonsya.size() > 0) {
            C_UmuKbn pageinfoHyoujiUmuHonsya;
            if (fubiNaiyouMsgLstHonsya.size() > 5) {
                pageinfoHyoujiUmuHonsya = C_UmuKbn.ARI;
            }
            else {
                pageinfoHyoujiUmuHonsya = C_UmuKbn.NONE;
            }
            SiHubiteiseiBean siHubiteiseiBean = SWAKInjector.getInstance(SiHubiteiseiBean.class);
            siHubiteiseiBean.setIrSyono(pHubiTeiseisyoBean.getSyono());
            siHubiteiseiBean.setIrSeikyuusyanmkj(pHubiTeiseisyoBean.getSeikyuusyanmKj());
            siHubiteiseiBean.setIrRenno1(1);
            siHubiteiseiBean.setIrHubimsg1(fubiNaiyouMsgLstHonsya.get(0));
            if (fubiNaiyouMsgLstHonsya.size() < 2) {
            }
            else {
                siHubiteiseiBean.setIrRenno2(2);
                siHubiteiseiBean.setIrHubimsg2(fubiNaiyouMsgLstHonsya.get(1));
            }
            if (fubiNaiyouMsgLstHonsya.size() < 3) {
            }
            else {
                siHubiteiseiBean.setIrRenno3(3);
                siHubiteiseiBean.setIrHubimsg3(fubiNaiyouMsgLstHonsya.get(2));
            }
            if (fubiNaiyouMsgLstHonsya.size() < 4) {
            }
            else {
                siHubiteiseiBean.setIrRenno4(4);
                siHubiteiseiBean.setIrHubimsg4(fubiNaiyouMsgLstHonsya.get(3));
            }
            if (fubiNaiyouMsgLstHonsya.size() < 5) {
            }
            else {
                siHubiteiseiBean.setIrRenno5(5);
                siHubiteiseiBean.setIrHubimsg5(fubiNaiyouMsgLstHonsya.get(4));
            }
            if (fubiNaiyouMsgLstHonsya.size() < 6) {
            }
            else {
                siHubiteiseiBean.setIrRenno6(6);
                siHubiteiseiBean.setIrHubimsg6(fubiNaiyouMsgLstHonsya.get(5));
            }
            if (fubiNaiyouMsgLstHonsya.size() < 7) {
            }
            else {
                siHubiteiseiBean.setIrRenno7(7);
                siHubiteiseiBean.setIrHubimsg7(fubiNaiyouMsgLstHonsya.get(6));
            }
            if (fubiNaiyouMsgLstHonsya.size() < 8) {
            }
            else {
                siHubiteiseiBean.setIrRenno8(8);
                siHubiteiseiBean.setIrHubimsg8(fubiNaiyouMsgLstHonsya.get(7));
            }
            if (fubiNaiyouMsgLstHonsya.size() < 9) {
            }
            else {
                siHubiteiseiBean.setIrRenno9(9);
                siHubiteiseiBean.setIrHubimsg9(fubiNaiyouMsgLstHonsya.get(8));
            }
            if (fubiNaiyouMsgLstHonsya.size() < 10) {
            }
            else {
                siHubiteiseiBean.setIrRenno10(10);
                siHubiteiseiBean.setIrHubimsg10(fubiNaiyouMsgLstHonsya.get(9));
            }
            siHubiteiseiBean.setIrPageinfohyoujiumu(pageinfoHyoujiUmuHonsya);
            siHubiteiseiBean.setIrKarisakuseiumu(karihyoujiUmu);
            siHubiteiseiBean.setIrGenponhnkykumu(genponhnkyHyoujiUmuHonsya);
            ReportServicesBean reportServicesBeanHonsya= createReport.createNewReportServiceBean(
                    kinou.getSubSystemId(), kinou.getCategoryId(), kinou.getKinouId(),
                    pHubiTeiseisyoBean.getSiTyouhyouHensyuuCommonBean().getSyoruiCd());
            reportServicesBeanHonsya.setKensakuKeys(pHubiTeiseisyoBean.getSyono());
            reportServicesBeanHonsya.setSyoriYmd(pHubiTeiseisyoBean.getSiTyouhyouHensyuuCommonBean().getSyoriYmd());
            reportServicesBeanHonsya.addParamObjects(siHubiteiseiBean,bzSksKaisyasiyouranBean);
            editHubiTeiseisyoBean.setReportServicesBeanHonsya(reportServicesBeanHonsya);
        }

        logger.debug("△ 不備訂正書編集 終了");

        return editHubiTeiseisyoBean;
    }
}
