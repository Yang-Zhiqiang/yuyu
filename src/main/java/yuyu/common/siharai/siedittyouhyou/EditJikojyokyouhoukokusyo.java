package yuyu.common.siharai.siedittyouhyou;

import javax.inject.Inject;

import jp.co.slcs.swak.bizinfr.exception.BizAppException;
import jp.co.slcs.swak.core.inject.SWAKInjector;

import org.slf4j.Logger;

import yuyu.common.biz.bzcommon.DateFormatUtil;
import yuyu.common.biz.report.ViewReport;
import yuyu.def.MessageId;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.db.entity.AS_Kinou;
import yuyu.def.siharai.bean.report.SiJikoJkHoukokusBean;
import yuyu.infr.report.CreateReport;
import yuyu.infr.report.swakreport.ReportServicesBean;

/**
 * 保険金給付金支払 保険金給付金支払帳票編集 事故状況報告書編集
 */
public class EditJikojyokyouhoukokusyo {
    @Inject
    private static Logger logger;

    @Inject
    private AS_Kinou kinou;

    @Inject
    private CreateReport createReport;

    public EditJikojyokyouhoukokusyo() {
        super();
    }

    public ReportServicesBean exec(EditJikojyokyouhoukokusyoBean pEditJikojyokyouhoukokusyoBean) {

        logger.debug("▽ 事故状況報告書 開始");
        if (pEditJikojyokyouhoukokusyoBean.getSiTyouhyouHensyuuCommonBean().getSyoriYmd() == null) {
            throw new BizAppException(MessageId.EJS1005, "syoriYmd");
        }
        if (pEditJikojyokyouhoukokusyoBean.getSiTyouhyouHensyuuCommonBean().getSyoruiCd() == null ||
                C_SyoruiCdKbn.BLNK.eq(pEditJikojyokyouhoukokusyoBean.getSiTyouhyouHensyuuCommonBean().getSyoruiCd())) {
            throw new BizAppException(MessageId.EJS1005, "syoruiCd");
        }
        String hozonKknTani = ViewReport.getHozonKknTani(pEditJikojyokyouhoukokusyoBean
                .getSiTyouhyouHensyuuCommonBean().getSyoruiCd());
        SiJikoJkHoukokusBean siJikoJkHoukokusBean = SWAKInjector.getInstance(SiJikoJkHoukokusBean.class);
        siJikoJkHoukokusBean.setIrSyoriymd(DateFormatUtil.dateKANJINoEx(pEditJikojyokyouhoukokusyoBean
                .getSiTyouhyouHensyuuCommonBean().getSyoriYmd()));
        siJikoJkHoukokusBean.setIrHozonkkn(hozonKknTani);
        ReportServicesBean reportServicesBean = createReport.createNewReportServiceBean(
                kinou.getSubSystemId(), kinou.getCategoryId(), kinou.getKinouId(),
                pEditJikojyokyouhoukokusyoBean.getSiTyouhyouHensyuuCommonBean().getSyoruiCd());
        reportServicesBean.setSyoriYmd(pEditJikojyokyouhoukokusyoBean.getSiTyouhyouHensyuuCommonBean().getSyoriYmd());
        reportServicesBean.addParamObjects(siJikoJkHoukokusBean);
        logger.debug("△ 事故状況報告書 終了");
        return reportServicesBean;
    }
}
