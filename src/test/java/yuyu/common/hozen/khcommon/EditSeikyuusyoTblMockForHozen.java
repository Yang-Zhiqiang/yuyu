package yuyu.common.hozen.khcommon;

import javax.inject.Inject;

import yuyu.def.biz.bean.report.BzSksKaisyasiyouranBean;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.classification.C_Tmttknitenkbn;
import yuyu.def.hozen.bean.report.KhSeikyuusyoBean;
import yuyu.infr.report.CreateReport;
import yuyu.infr.report.swakreport.ReportServicesBean;

/**
 * {@link EditSeikyuusyoTbl}のモッククラスです。<br />
 */
public class EditSeikyuusyoTblMockForHozen extends EditSeikyuusyoTbl {

    public static Class<?> caller = null;

    @Inject
    private CreateReport createReport;

    public EditSeikyuusyoTblMockForHozen() {
        super();
    }

    @Override
    public ReportServicesBean editBean(C_SyoruiCdKbn pSyoruiCd,
        String pSyoNo,
        KhozenCommonParam pKhozenCommonParam,
        EditSeikyuusyoParam pEditSeikyuusyoParam) {

        if (caller == KhozenTyouhyouCtlTest_createTyouhyouTBL.class) {

            KhSeikyuusyoBean khSeikyuusyoBean = new KhSeikyuusyoBean();

            BzSksKaisyasiyouranBean sksKaisyasiyouranBean = new BzSksKaisyasiyouranBean();

            ReportServicesBean reportServicesBean = createReport.createNewReportServiceBean(
                IKhozenCommonConstants.SUBSYSTEMID_HOZEN,
                "",
                "",
                pSyoruiCd);

            reportServicesBean.setKensakuKeys(pSyoNo);

            khSeikyuusyoBean.setIrSyono(pSyoNo);

            reportServicesBean.setQrCode("qr001");

            khSeikyuusyoBean.setIrTmttknitenkbn(C_Tmttknitenkbn.ITEN);

            reportServicesBean.addParamObjects(new Object[] {khSeikyuusyoBean, sksKaisyasiyouranBean});

            return reportServicesBean;
        }

        return super.editBean(pSyoruiCd, pSyoNo, pKhozenCommonParam, pEditSeikyuusyoParam);
    }
}
