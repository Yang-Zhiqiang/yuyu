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
import yuyu.def.classification.C_SeikyuuSyubetu;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UktKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.AS_Kinou;
import yuyu.def.db.entity.JM_SiTyouhyoumsg;
import yuyu.def.siharai.bean.report.SiSksBean;
import yuyu.def.siharai.manager.SiharaiDomManager;
import yuyu.infr.report.CreateReport;
import yuyu.infr.report.swakreport.ReportServicesBean;

/**
 * 保険金給付金支払 保険金給付金支払帳票編集 請求書編集
 */
public class EditSeikyuusyo {

    public static final int LINEMAXLEN = 27;

    @Inject
    private SiharaiDomManager siharaiDomManager;

    @Inject
    private AS_Kinou kinou;

    @Inject
    private static Logger logger;

    @Inject
    private CreateReport createReport;

    public EditSeikyuusyo() {
        super();
    }

    public ReportServicesBean exec(EditSeikyuusyoBean pEditSeikyuusyoBean) {

        logger.debug("▽ 請求書編集 開始");

        if (null == pEditSeikyuusyoBean.getSiTyouhyouHensyuuCommonBean().getSyoriYmd()) {
            throw new BizAppException(MessageId.EJS1005, "syoriYmd");
        }

        if (null == pEditSeikyuusyoBean.getSiTyouhyouHensyuuCommonBean().getSyoruiCd()
            || C_SyoruiCdKbn.BLNK.eq(pEditSeikyuusyoBean.getSiTyouhyouHensyuuCommonBean().getSyoruiCd())) {
            throw new BizAppException(MessageId.EJS1005, "syoruiCd");
        }

        if (null == pEditSeikyuusyoBean.getSeikyuusyaInfoBean()) {
            throw new BizAppException(MessageId.EJS1005, "seikyuusyaInfoBean");
        }

        if (null == pEditSeikyuusyoBean.getSeikyuusyubetu()
            || C_SeikyuuSyubetu.BLNK.eq(pEditSeikyuusyoBean.getSeikyuusyubetu())) {
            throw new BizAppException(MessageId.EJS1005, "seikyuusyubetu");
        }

        String tyouhyouTitle = "";
        if (C_SeikyuuSyubetu.SB.eq(pEditSeikyuusyoBean.getSeikyuusyubetu())) {

            tyouhyouTitle = siharaiDomManager.getSiTyouhyoumsg(
                pEditSeikyuusyoBean.getSiTyouhyouHensyuuCommonBean().getSyoruiCd().getValue()
                , "TITLE_SB"
                , 1).getTyouhyoumsg();
        }

        List<JM_SiTyouhyoumsg> sityouhyoumsgLst = new ArrayList<>();

        if (C_SeikyuuSyubetu.SB.eq(pEditSeikyuusyoBean.getSeikyuusyubetu())) {
            sityouhyoumsgLst = siharaiDomManager.getSiTyouhyoumsgsByBunrui1Bunrui2(
                pEditSeikyuusyoBean.getSiTyouhyouHensyuuCommonBean().getSyoruiCd().getValue()
                , "SEIKYUNAIYOU_SB");
        }

        String hozonKknTani = ViewReport.getHozonKknTani(pEditSeikyuusyoBean.getSiTyouhyouHensyuuCommonBean()
            .getSyoruiCd());

        C_UmuKbn shsrtdkdadrhyjumu = C_UmuKbn.NONE;
        C_UmuKbn shsrkinyuuhyjumu = C_UmuKbn.NONE;
        C_UmuKbn irUkthougkdthyjumu = C_UmuKbn.NONE;
        C_UmuKbn irUkthouendthyjumu = C_UmuKbn.NONE;

        if (C_UktKbn.KYK.eq(pEditSeikyuusyoBean.getUktKbn())){
            shsrtdkdadrhyjumu = C_UmuKbn.ARI;
        }
        else {
            shsrkinyuuhyjumu = C_UmuKbn.ARI;
        }
        if (C_Tuukasyu.JPY.eq(pEditSeikyuusyoBean.getTuukasyu())){
            irUkthouendthyjumu = C_UmuKbn.ARI;
        }
        else {
            irUkthougkdthyjumu = C_UmuKbn.ARI;
        }
        SiSksBean siSksBean = SWAKInjector.getInstance(SiSksBean.class);
        String[] msgs = new String[4];
        int loopCount = 0;

        for (JM_SiTyouhyoumsg siTyouhyoumsg : sityouhyoumsgLst) {
            msgs[loopCount] = siTyouhyoumsg.getTyouhyoumsg();
            loopCount = loopCount + 1;
        }

        String[] results = ViewReport.editAdrDisp(LINEMAXLEN,
            pEditSeikyuusyoBean.getSeikyuusyaInfoBean().getTsinadr1kj(),
            pEditSeikyuusyoBean.getSeikyuusyaInfoBean().getTsinadr2kj(),
            pEditSeikyuusyoBean.getSeikyuusyaInfoBean().getTsinadr3kj());
        siSksBean.setIrTsinadr1kj(results[0]);
        siSksBean.setIrTsinadr2kj(results[1]);
        if (results.length > 2) {
            siSksBean.setIrTsinadr3kj(results[2]);
        }

        siSksBean.setIrTyouhyoutitle(tyouhyouTitle);
        siSksBean.setIrSyono(pEditSeikyuusyoBean.getSyono());
        siSksBean.setIrTsinyno(pEditSeikyuusyoBean.getSeikyuusyaInfoBean().getTsinyno());
        siSksBean.setIrTsintelno(pEditSeikyuusyoBean.getSeikyuusyaInfoBean().getTsintelno());
        siSksBean.setIrMsg1(msgs[0]);
        siSksBean.setIrMsg2(msgs[1]);
        siSksBean.setIrMsg3(msgs[2]);
        siSksBean.setIrMsg4(msgs[3]);
        siSksBean.setIrToritsugisyasyozokunm(pEditSeikyuusyoBean.getToritsugisyaSosikimei());
        siSksBean.setIrToritsugisyakjncd(pEditSeikyuusyoBean.getToritsugisyakjncd());
        siSksBean.setIrToritsugisyanm(pEditSeikyuusyoBean.getToritsugisyaKjnmei());
        siSksBean.setIrTyouhyousakuseiymd(
            DateFormatUtil.dateKANJINoEx(pEditSeikyuusyoBean.getSiTyouhyouHensyuuCommonBean().getSyoriYmd()));
        siSksBean.setIrHozonkkn(hozonKknTani);
        siSksBean.setIrShsrtdkdadrhyjumu(shsrtdkdadrhyjumu);
        siSksBean.setIrShsrkinyuuhyjumu(shsrkinyuuhyjumu);
        siSksBean.setIrUkthougkdthyjumu(irUkthougkdthyjumu);
        siSksBean.setIrUkthouendthyjumu(irUkthouendthyjumu);

        ReportServicesBean reportServicesBean = createReport.createNewReportServiceBean(
            kinou.getSubSystemId()
            , kinou.getCategoryId()
            , kinou.getKinouId()
            , pEditSeikyuusyoBean.getSiTyouhyouHensyuuCommonBean().getSyoruiCd());
        reportServicesBean.setKensakuKeys(pEditSeikyuusyoBean.getSyono());
        reportServicesBean.setSyoriYmd(pEditSeikyuusyoBean.getSiTyouhyouHensyuuCommonBean().getSyoriYmd());
        reportServicesBean.addParamObjects(siSksBean);

        logger.debug("△ 請求書編集 終了");

        return reportServicesBean;
    }
}
