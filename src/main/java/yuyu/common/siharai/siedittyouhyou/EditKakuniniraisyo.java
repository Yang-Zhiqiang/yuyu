package yuyu.common.siharai.siedittyouhyou;

import javax.inject.Inject;

import jp.co.slcs.swak.bizinfr.exception.BizAppException;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.util.string.ConvertUtil;

import org.slf4j.Logger;

import yuyu.common.biz.bzcommon.BizUtil;
import yuyu.common.biz.bzcommon.DateFormatUtil;
import yuyu.common.biz.report.ViewReport;
import yuyu.def.MessageId;
import yuyu.def.classification.C_SeikyuuSyubetu;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.db.entity.AS_Kinou;
import yuyu.def.siharai.bean.report.SiEditKakuniniraisyoBean;
import yuyu.def.siharai.manager.SiharaiDomManager;
import yuyu.infr.report.CreateReport;
import yuyu.infr.report.swakreport.ReportServicesBean;

/**
 * 保険金給付金支払 保険金給付金支払帳票編集 確認依頼書編集
 */
public class EditKakuniniraisyo {

    private static final String TANI = "円";

    public static final int LINEMAXLEN = 28;

    @Inject
    private SiharaiDomManager siharaiDomManager;

    @Inject
    private AS_Kinou kinou;

    @Inject
    private static Logger logger;

    @Inject
    private CreateReport createReport;

    public EditKakuniniraisyo() {
        super();
    }

    public ReportServicesBean exec(EditKakuniniraisyoBean pEditKakuniniraisyoBean) {

        logger.debug("▽ 確認依頼書編集 開始");

        BizDate syoriymd = pEditKakuniniraisyoBean.getSiTyouhyouHensyuuCommonBean().getSyoriYmd();
        if (syoriymd == null) {
            throw new BizAppException(MessageId.EJS1005, "syoriymd");
        }
        C_SyoruiCdKbn syoruiCd = pEditKakuniniraisyoBean.getSiTyouhyouHensyuuCommonBean().getSyoruiCd();
        if (syoruiCd == null || C_SyoruiCdKbn.BLNK.eq(syoruiCd)) {
            throw new BizAppException(MessageId.EJS1005, "syoruiCd");
        }
        C_SeikyuuSyubetu seikyuuSyubetu = pEditKakuniniraisyoBean.getSeikyuuSyubetu();
        if (seikyuuSyubetu == null || C_SeikyuuSyubetu.BLNK.eq(seikyuuSyubetu)) {
            throw new BizAppException(MessageId.EJS1005, "seikyuuSyubetu");
        }
        if (pEditKakuniniraisyoBean.getSeikyuusyaInfoBean() == null) {
            throw new BizAppException(MessageId.EJS1005, "seikyuusyaInfoBean");
        }

        String tyouhyouTitle = "";
        if (C_SeikyuuSyubetu.SB.eq(seikyuuSyubetu)) {
            tyouhyouTitle = siharaiDomManager.getSiTyouhyoumsg(syoruiCd.getValue(), "TITLE_SB", 1).getTyouhyoumsg();
        }

        BizCurrency hokenknGk =  BizCurrency.optional();
        String syuStani = "";

        if ((!pEditKakuniniraisyoBean.getHokenknGk().isOptional()) &&
            (pEditKakuniniraisyoBean.getHokenknGk().compareTo(BizCurrency.valueOf(0,pEditKakuniniraisyoBean.getHokenknGk().getType())) > 0)){
            hokenknGk = pEditKakuniniraisyoBean.getHokenknGk();
            syuStani = TANI;

        }
        BizCurrency saigaiS =  BizCurrency.optional();
        String saigaiStani = "";

        if ((!pEditKakuniniraisyoBean.getSaigais().isOptional()) &&
            (pEditKakuniniraisyoBean.getSaigais().compareTo(BizCurrency.valueOf(0,pEditKakuniniraisyoBean.getSaigais().getType())) > 0)){
            saigaiS = pEditKakuniniraisyoBean.getSaigais();
            saigaiStani = TANI;

        }

        String hozonKknJyohn = ViewReport.getHozonKknTani(syoruiCd);

        SiEditKakuniniraisyoBean siEditKakuniniraisyoBean = SWAKInjector.getInstance(SiEditKakuniniraisyoBean.class);
        siEditKakuniniraisyoBean.setIrTyouhyoutitle(tyouhyouTitle);
        siEditKakuniniraisyoBean.setIrIraisyohyojitelno(pEditKakuniniraisyoBean.getHyojitelNo());
        siEditKakuniniraisyoBean.setIrSyono(pEditKakuniniraisyoBean.getSyoNo());
        siEditKakuniniraisyoBean.setIrKykymd(ConvertUtil.toZenNumeric(DateFormatUtil.dateKANJINoEx(pEditKakuniniraisyoBean
            .getKykYmd())));
        if (pEditKakuniniraisyoBean.getSibouYmd() != null) {
            siEditKakuniniraisyoBean.setIrSbymdkoteiymd(ConvertUtil.toZenNumeric(DateFormatUtil
                .dateKANJINoEx(pEditKakuniniraisyoBean.getSibouYmd())));
        }
        siEditKakuniniraisyoBean.setIrSyoruiukeymd(ConvertUtil.toZenNumeric(DateFormatUtil
            .dateKANJINoEx(pEditKakuniniraisyoBean.getSyoruiukeYmd())));
        if (pEditKakuniniraisyoBean.getSikkouYmd() != null) {
            siEditKakuniniraisyoBean.setIrSikkouymd(ConvertUtil.toZenNumeric(DateFormatUtil
                .dateKANJINoEx(pEditKakuniniraisyoBean.getSikkouYmd())));

        }
        if (pEditKakuniniraisyoBean.getHksknnkaisiYmd() != null) {
            siEditKakuniniraisyoBean.setIrHksknnkaisiymd(ConvertUtil.toZenNumeric(DateFormatUtil
                .dateKANJINoEx(pEditKakuniniraisyoBean.getHksknnkaisiYmd())));
        }
        if (pEditKakuniniraisyoBean.getLastmeihenYmd() != null) {
            siEditKakuniniraisyoBean.setIrLastmeihenymd(ConvertUtil.toZenNumeric(DateFormatUtil
                .dateKANJINoEx(pEditKakuniniraisyoBean.getLastmeihenYmd())));
        }
        siEditKakuniniraisyoBean.setIrHhknnmkn(pEditKakuniniraisyoBean.getHhknNmkn());
        siEditKakuniniraisyoBean.setIrHhknnmkj(pEditKakuniniraisyoBean.getHhknNmkj());
        siEditKakuniniraisyoBean.setIrKyknmkn(pEditKakuniniraisyoBean.getKykNmkn());
        siEditKakuniniraisyoBean.setIrKyknmkj(pEditKakuniniraisyoBean.getKyknmkj());
        siEditKakuniniraisyoBean.setIrSeikyuusyanmkn(pEditKakuniniraisyoBean.getSeikyuusyaInfoBean()
            .getSeikyuusyanmKn());
        siEditKakuniniraisyoBean.setIrSeikyuusyanmkj(pEditKakuniniraisyoBean.getSeikyuusyaInfoBean()
            .getSeikyuusyanmKj());
        siEditKakuniniraisyoBean.setIrTsinyno(pEditKakuniniraisyoBean.getSeikyuusyaInfoBean().getTsinyno());
        siEditKakuniniraisyoBean.setIrTsintelno(pEditKakuniniraisyoBean.getSeikyuusyaInfoBean().getTsintelno());
        StringBuffer tsinadrkj = new StringBuffer();
        if (!BizUtil.isBlank(pEditKakuniniraisyoBean.getSeikyuusyaInfoBean().getTsinadr1kj())) {
            tsinadrkj.append(pEditKakuniniraisyoBean.getSeikyuusyaInfoBean().getTsinadr1kj());
        }
        if (!BizUtil.isBlank(pEditKakuniniraisyoBean.getSeikyuusyaInfoBean().getTsinadr2kj())) {
            tsinadrkj.append(pEditKakuniniraisyoBean.getSeikyuusyaInfoBean().getTsinadr2kj());
        }
        if (!BizUtil.isBlank(pEditKakuniniraisyoBean.getSeikyuusyaInfoBean().getTsinadr3kj())) {
            tsinadrkj.append(pEditKakuniniraisyoBean.getSeikyuusyaInfoBean().getTsinadr3kj());
        }
        String[] results = BizUtil.splitLineSeparator(tsinadrkj.toString(), LINEMAXLEN, false);
        if (results.length > 0) {
            siEditKakuniniraisyoBean.setIrTsinadr1kj(results[0]);
        }
        if (results.length > 1) {
            siEditKakuniniraisyoBean.setIrTsinadr2kj(results[1]);
        }
        if (results.length > 2) {
            siEditKakuniniraisyoBean.setIrTsinadr3kj(results[2]);
        }
        siEditKakuniniraisyoBean.setIrHkgk(hokenknGk.toFormatString());
        siEditKakuniniraisyoBean.setIrSyustani(syuStani);
        siEditKakuniniraisyoBean.setIrSaigais(saigaiS.toFormatString());
        siEditKakuniniraisyoBean.setIrSaigaistani(saigaiStani);
        siEditKakuniniraisyoBean.setIrHozonkkn(hozonKknJyohn);

        ReportServicesBean reportServicesBean = createReport.createNewReportServiceBean(kinou.getSubSystemId(),
            kinou.getCategoryId(), kinou.getKinouId(), syoruiCd);
        reportServicesBean.setKensakuKeys(pEditKakuniniraisyoBean.getSyoNo());
        reportServicesBean.setSyoriYmd(syoriymd);
        reportServicesBean.addParamObjects(siEditKakuniniraisyoBean);
        logger.debug("△ 確認依頼書編集 終了");
        return reportServicesBean;
    }
}
