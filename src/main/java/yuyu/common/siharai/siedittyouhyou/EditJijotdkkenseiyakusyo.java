package yuyu.common.siharai.siedittyouhyou;

import javax.inject.Inject;

import jp.co.slcs.swak.bizinfr.exception.BizAppException;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.util.string.ConvertUtil;

import org.slf4j.Logger;

import yuyu.def.MessageId;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.db.entity.AS_Kinou;
import yuyu.def.siharai.bean.report.SiJijotdkkenseiyakusyoBean;
import yuyu.infr.report.CreateReport;
import yuyu.infr.report.swakreport.ReportServicesBean;

/**
 * 保険金給付金支払 保険金給付金支払帳票編集 事情届兼誓約書編集
 */
public class EditJijotdkkenseiyakusyo {

    @Inject
    private AS_Kinou kinou;

    @Inject
    private static Logger logger;

    @Inject
    private CreateReport createReport;

    public EditJijotdkkenseiyakusyo() {
        super();
    }

    public ReportServicesBean exec(EditJijotdkkenseiyakusyoBean pEditJijotdkkenseiyakusyoBean) {

        logger.debug("▽ 事情届兼誓約書編集 開始");

        BizDate syoriYmd = pEditJijotdkkenseiyakusyoBean.getSiTyouhyouHensyuuCommonBean().getSyoriYmd();
        C_SyoruiCdKbn syoruiCd = pEditJijotdkkenseiyakusyoBean.getSiTyouhyouHensyuuCommonBean().getSyoruiCd();

        if (syoriYmd == null) {
            throw new BizAppException(MessageId.EJS1005, "syoriYmd");
        }

        if (syoruiCd == null ||
            C_SyoruiCdKbn.BLNK.eq(syoruiCd)) {
            throw new BizAppException(MessageId.EJS1005, "syoruiCd");
        }

        SiJijotdkkenseiyakusyoBean siJijotdkkenseiyakusyoBean = SWAKInjector.getInstance(SiJijotdkkenseiyakusyoBean.class);
        siJijotdkkenseiyakusyoBean.setIrSyono(ConvertUtil.toZenAll(pEditJijotdkkenseiyakusyoBean.getSyono(), 0, 1));
        siJijotdkkenseiyakusyoBean.setIrHknknuktnm(pEditJijotdkkenseiyakusyoBean.getHknknukt());
        siJijotdkkenseiyakusyoBean.setIrDrsknm(pEditJijotdkkenseiyakusyoBean.getDrsk());

        ReportServicesBean reportServicesBean =
            createReport.createNewReportServiceBean(
                kinou.getSubSystemId(),
                kinou.getCategoryId(),
                kinou.getKinouId(),
                syoruiCd);

        reportServicesBean.setKensakuKeys(pEditJijotdkkenseiyakusyoBean.getSyono());
        reportServicesBean.setSyoriYmd(syoriYmd);

        reportServicesBean.addParamObjects(siJijotdkkenseiyakusyoBean);

        logger.debug("△ 事情届兼誓約書編集 終了");

        return reportServicesBean;
    }
}
