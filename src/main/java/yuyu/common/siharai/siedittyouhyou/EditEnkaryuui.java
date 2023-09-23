package yuyu.common.siharai.siedittyouhyou;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.bizinfr.exception.BizAppException;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.number.BizCurrency;

import org.slf4j.Logger;

import yuyu.common.biz.bzcommon.DateFormatUtil;
import yuyu.common.siharai.sicommon.SiMeisaiCommonHensyu;
import yuyu.common.siharai.sicommon.SiMeisaiCommonHensyuResultBean;
import yuyu.def.MessageId;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.AS_Kinou;
import yuyu.def.db.entity.JM_SiTyouhyoumsg;
import yuyu.def.siharai.bean.report.SiEditEnkaryuuiBean;
import yuyu.def.siharai.bean.report.SiEditEnkaryuuiDataSourceBean;
import yuyu.def.siharai.manager.SiharaiDomManager;
import yuyu.infr.report.CreateReport;
import yuyu.infr.report.swakreport.IReportDataSouceBean;
import yuyu.infr.report.swakreport.ReportServicesBean;

/**
 * 保険金給付金支払 保険金給付金支払帳票編集 保険金支払金額試算書編集
 */
public class EditEnkaryuui {
    @Inject
    private SiharaiDomManager siharaiDomManager;

    @Inject
    private static Logger logger;

    @Inject
    private AS_Kinou kinou;

    @Inject
    private CreateReport createReport;

    private static final int MEISAI_HYOJI_CNT = 13;

    public EditEnkaryuui() {
        super();
    }

    public ReportServicesBean exec(EditEnkaryuuiBean pEditEnkaryuuiBean) {

        logger.debug("▽ 保険金支払金額試算書編集 開始");
        if (pEditEnkaryuuiBean.getSiTyouhyouHensyuuCommonBean().getSyoriYmd() == null) {
            throw new BizAppException(MessageId.EJS1005, "syoriYmd");
        }
        if (pEditEnkaryuuiBean.getSiTyouhyouHensyuuCommonBean().getSyoruiCd() == null ||
            C_SyoruiCdKbn.BLNK.eq(pEditEnkaryuuiBean.getSiTyouhyouHensyuuCommonBean().getSyoruiCd())) {
            throw new BizAppException(MessageId.EJS1005, "syoruiCd");
        }
        if (pEditEnkaryuuiBean.getTuukasyu() == null) {
            throw new BizAppException(MessageId.EJS1005, "tuukasyu");
        }
        if (pEditEnkaryuuiBean.getSiHkkingakuSisanParamBean() == null) {
            throw new BizAppException(MessageId.EJS1005, "siHkkingakuSisanParamBean");
        }
        if (pEditEnkaryuuiBean.getSiSiDetailParamBeanList() == null) {
            throw new BizAppException(MessageId.EJS1005, "siSiDetailParamBeanList");
        }

        JM_SiTyouhyoumsg siTyouhyoumsg = siharaiDomManager.getSiTyouhyoumsg(pEditEnkaryuuiBean
            .getSiTyouhyouHensyuuCommonBean().getSyoruiCd().getValue(), "TITLE", 1);
        String title = siTyouhyoumsg.getTyouhyoumsg();
        List<JM_SiTyouhyoumsg> annaiNaiyouMsgLst = siharaiDomManager.getSiTyouhyoumsgsByBunrui1Bunrui2(
            pEditEnkaryuuiBean
            .getSiTyouhyouHensyuuCommonBean().getSyoruiCd().getValue(), "ANNAI_NAIYOU");
        String bunnruyi = "";
        if (C_Tuukasyu.JPY.eq(pEditEnkaryuuiBean.getTuukasyu())) {
            bunnruyi = "RYUUI_JIKOU_ENDATE";
        }
        else {
            bunnruyi = "RYUUI_JIKOU";
        }
        List<JM_SiTyouhyoumsg> ryuuiKoumokuMsgLst = siharaiDomManager.getSiTyouhyoumsgsByBunrui1Bunrui2(
            pEditEnkaryuuiBean
            .getSiTyouhyouHensyuuCommonBean().getSyoruiCd().getValue(), bunnruyi);
        C_UmuKbn irLayoutgkhyjumu = C_UmuKbn.NONE;
        C_UmuKbn irLayoutyenhyjumu = C_UmuKbn.NONE;
        if (C_Tuukasyu.JPY.eq(pEditEnkaryuuiBean.getTuukasyu())) {
            irLayoutyenhyjumu = C_UmuKbn.ARI;
        }
        else {
            irLayoutgkhyjumu = C_UmuKbn.ARI;
        }

        BizCurrency hkgkgaika = BizCurrency.optional();
        BizCurrency hkgkyen = BizCurrency.optional();
        if (C_Tuukasyu.JPY.eq(pEditEnkaryuuiBean.getTuukasyu())) {
            hkgkyen = pEditEnkaryuuiBean.getHkgkGaika();
        } else {
            hkgkgaika = pEditEnkaryuuiBean.getHkgkGaika();
            hkgkyen = pEditEnkaryuuiBean.getHkgkYen();
        }

        SiMeisaiCommonHensyu siMeisaiCommonHensyu = SWAKInjector.getInstance(SiMeisaiCommonHensyu.class);
        C_ErrorKbn result = siMeisaiCommonHensyu.sisansyoHensyu(pEditEnkaryuuiBean.getSiHkkingakuSisanParamBean(),
            pEditEnkaryuuiBean.getSiSiDetailParamBeanList());

        if (C_ErrorKbn.ERROR.eq(result)) {
            throw new BizAppException(MessageId.EJA1027);
        }

        List<SiMeisaiCommonHensyuResultBean>[] sisansyoHensyuResult = siMeisaiCommonHensyu.getSisansyoHensyuResult();

        List<SiEditEnkaryuuiDataSourceBean> siEditEnkaryuuiDataSourceBeanLst = new ArrayList<>();
        if (C_Tuukasyu.JPY.eq(pEditEnkaryuuiBean.getTuukasyu())) {
            siEditEnkaryuuiDataSourceBeanLst.addAll(editDataSourceBeanLst(C_Tuukasyu.JPY, sisansyoHensyuResult[0]));
        } else {
            siEditEnkaryuuiDataSourceBeanLst.addAll(editDataSourceBeanLst(pEditEnkaryuuiBean.getTuukasyu(),
                sisansyoHensyuResult[0]));
            siEditEnkaryuuiDataSourceBeanLst.addAll(editDataSourceBeanLst(C_Tuukasyu.JPY, sisansyoHensyuResult[1]));
        }

        SiEditEnkaryuuiBean siEditEnkaryuuiBean = SWAKInjector.getInstance(SiEditEnkaryuuiBean.class);
        String[] annaiMsgHairetu = new String[5];
        for (int i = 0; i < annaiNaiyouMsgLst.size(); i++) {
            annaiMsgHairetu[i] = annaiNaiyouMsgLst.get(i).getTyouhyoumsg();
        }
        String[] ryuuiKoumokuHairetu = new String[15];
        for (int i = 0; i < ryuuiKoumokuMsgLst.size(); i++) {
            ryuuiKoumokuHairetu[i] = ryuuiKoumokuMsgLst.get(i).getTyouhyoumsg();
        }
        siEditEnkaryuuiBean.setIrTyouhyoutitle(title);
        siEditEnkaryuuiBean.setIrMsg1(annaiMsgHairetu[0]);
        siEditEnkaryuuiBean.setIrMsg2(annaiMsgHairetu[1]);
        siEditEnkaryuuiBean.setIrMsg3(annaiMsgHairetu[2]);
        siEditEnkaryuuiBean.setIrMsg4(annaiMsgHairetu[3]);
        siEditEnkaryuuiBean.setIrMsg5(annaiMsgHairetu[4]);
        siEditEnkaryuuiBean.setIrSyono(pEditEnkaryuuiBean.getSyoNo());
        siEditEnkaryuuiBean.setIrKyknmkj(pEditEnkaryuuiBean.getKyknmKj());
        siEditEnkaryuuiBean.setIrHhknnmkj(pEditEnkaryuuiBean.getHhknnmKj());
        siEditEnkaryuuiBean.setIrUktnmkj(pEditEnkaryuuiBean.getUktnmKj());
        siEditEnkaryuuiBean.setIrUkthou(pEditEnkaryuuiBean.getUkthouKbn().getContent());
        siEditEnkaryuuiBean.setIrCalckijyunymd(DateFormatUtil.dateKANJINoEx(pEditEnkaryuuiBean.getCalckijyunYmd()));
        siEditEnkaryuuiBean.setIrUktbnwari(pEditEnkaryuuiBean.getUktbnWari() + " ％");
        siEditEnkaryuuiBean.setIrHkgkgaika(hkgkgaika);
        siEditEnkaryuuiBean.setIrHkgkyen(hkgkyen);
        siEditEnkaryuuiBean.setIrMsg6(ryuuiKoumokuHairetu[0]);
        siEditEnkaryuuiBean.setIrMsg7(ryuuiKoumokuHairetu[1]);
        siEditEnkaryuuiBean.setIrMsg8(ryuuiKoumokuHairetu[2]);
        siEditEnkaryuuiBean.setIrMsg9(ryuuiKoumokuHairetu[3]);
        siEditEnkaryuuiBean.setIrMsg10(ryuuiKoumokuHairetu[4]);
        siEditEnkaryuuiBean.setIrMsg11(ryuuiKoumokuHairetu[5]);
        siEditEnkaryuuiBean.setIrMsg12(ryuuiKoumokuHairetu[6]);
        siEditEnkaryuuiBean.setIrMsg13(ryuuiKoumokuHairetu[7]);
        siEditEnkaryuuiBean.setIrMsg14(ryuuiKoumokuHairetu[8]);
        siEditEnkaryuuiBean.setIrMsg15(ryuuiKoumokuHairetu[9]);
        siEditEnkaryuuiBean.setIrMsg16(ryuuiKoumokuHairetu[10]);
        siEditEnkaryuuiBean.setIrMsg17(ryuuiKoumokuHairetu[11]);
        siEditEnkaryuuiBean.setIrMsg18(ryuuiKoumokuHairetu[12]);
        siEditEnkaryuuiBean.setIrMsg19(ryuuiKoumokuHairetu[13]);
        siEditEnkaryuuiBean.setIrMsg20(ryuuiKoumokuHairetu[14]);
        siEditEnkaryuuiBean.setIrLayoutgkhyjumu(irLayoutgkhyjumu);
        siEditEnkaryuuiBean.setIrLayoutyenhyjumu(irLayoutyenhyjumu);
        ReportServicesBean reportServicesBean = createReport.createNewReportServiceBean(
            kinou.getSubSystemId(), kinou.getCategoryId(), kinou.getKinouId(),
            pEditEnkaryuuiBean.getSiTyouhyouHensyuuCommonBean().getSyoruiCd());
        reportServicesBean.setKensakuKeys(pEditEnkaryuuiBean.getSyoNo());
        reportServicesBean.setSyoriYmd(pEditEnkaryuuiBean.getSiTyouhyouHensyuuCommonBean().getSyoriYmd());

        List<IReportDataSouceBean> iReportDataSouceBeanLst = new ArrayList<>();
        iReportDataSouceBeanLst.addAll(siEditEnkaryuuiDataSourceBeanLst);
        reportServicesBean.addParamObjects(iReportDataSouceBeanLst, siEditEnkaryuuiBean);

        logger.debug("△ 保険金支払金額試算書編集 終了");
        return reportServicesBean;
    }


    private List<SiEditEnkaryuuiDataSourceBean> editDataSourceBeanLst(C_Tuukasyu pShrtuukasyu,
        List<SiMeisaiCommonHensyuResultBean> pSiMeisaiCommonHensyuResultBeanList) {

        List<SiEditEnkaryuuiDataSourceBean> list = new ArrayList<>();

        for (int i = 0; i < MEISAI_HYOJI_CNT; i++) {
            SiEditEnkaryuuiDataSourceBean siEditEnkaryuuiDataSourceBean = SWAKInjector
                .getInstance(SiEditEnkaryuuiDataSourceBean.class);

            if (i < pSiMeisaiCommonHensyuResultBeanList.size()) {
                SiMeisaiCommonHensyuResultBean bean = pSiMeisaiCommonHensyuResultBeanList.get(i);
                siEditEnkaryuuiDataSourceBean.setIrTuukasyu(pShrtuukasyu);
                siEditEnkaryuuiDataSourceBean.setIrKyuuhuname(bean.getTekiYou());
                siEditEnkaryuuiDataSourceBean.setIrKyhkg(bean.getShrGkMeisai());
                siEditEnkaryuuiDataSourceBean.setIrShrdetailbikou(bean.getDetailBikou());
            } else {
                siEditEnkaryuuiDataSourceBean.setIrTuukasyu(pShrtuukasyu);
                siEditEnkaryuuiDataSourceBean.setIrKyuuhuname("");
                siEditEnkaryuuiDataSourceBean.setIrKyhkg(null);
                siEditEnkaryuuiDataSourceBean.setIrShrdetailbikou("");
            }

            list.add(siEditEnkaryuuiDataSourceBean);
        }
        return list;
    }

}
