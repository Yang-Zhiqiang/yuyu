package yuyu.common.hozen.khcommon;

import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import yuyu.def.classification.C_HassouKbn;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.db.entity.IT_KhTtdkTyuui;
import yuyu.def.db.entity.IT_KoujyoSym;
import yuyu.def.db.entity.IT_KykDairiten;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.IT_KykSya;
import yuyu.def.db.entity.IT_KykSyouhn;
import yuyu.def.db.entity.IT_KykUkt;
import yuyu.def.hozen.bean.report.KhKoujyosyoumeisyoBean;
import yuyu.infr.report.CreateReport;
import yuyu.infr.report.swakreport.ReportServicesBean;

/**
 * {@link EditSuiihyouTbl}のモッククラスです。<br />
 */
public class EditKoujyoSyoumeiTblMock extends EditKoujyoSyoumeiTbl {

    public static Class<?> caller = null;

    public static String SYORIPTN = null;

    public static final String TESTPATTERN1 = "1";

    public static final String TESTPATTERN2 = "2";

    @Inject
    private CreateReport createReport;

    public EditKoujyoSyoumeiTblMock() {
        super();
    }

    @Override
    public IT_KoujyoSym editTBL(KhozenCommonParam pKCParm,
        IT_KykKihon pKykKihon,
        List<IT_KykSyouhn> pKykSyohnSyuLst,
        IT_KykSya pKykSya,
        List<IT_KykUkt> pKykUktLst,
        IT_KykUkt pKykUkt,
        List<IT_KykDairiten> pKykDaritenLst,
        IT_KhTtdkTyuui pKktetudukityuui,
        EditKoujyoSyoumeiParam pEditKoujyoSyoumeiParam,
        C_HassouKbn pHassouKbn,
        BizDate pSyoriYmd,
        int pRenno) {

        if (caller == KhozenTyouhyouCtlTest_createTyouhyouTBL.class && TESTPATTERN1.equals(SYORIPTN)) {
            return null;
        }
        else if (caller == KhozenTyouhyouCtlTest_createTyouhyouTBL.class && TESTPATTERN2.equals(SYORIPTN)) {
            IT_KoujyoSym koujyoSym = pKykKihon.createKoujyoSym();
            koujyoSym.setNendo("2016");
            koujyoSym.setTyouhyouymd(BizDate.valueOf(20160501));
            koujyoSym.setRenno(1);
            return koujyoSym;
        }

        return super.editTBL(pKCParm, pKykKihon, pKykSyohnSyuLst, pKykSya, pKykUktLst, pKykUkt, pKykDaritenLst,
            pKktetudukityuui, pEditKoujyoSyoumeiParam, pHassouKbn, pSyoriYmd, pRenno);

    }

    @Override
    public ReportServicesBean editBean(KhozenCommonParam pKhozenCommonParam,
        IT_KoujyoSym pKoujyoSym,
        BizDate pSyoriYmd) {

        if (caller == KhozenTyouhyouCtlTest_createTyouhyouTBL.class && TESTPATTERN2.equals(SYORIPTN)) {

            ReportServicesBean reportServicesBean = createReport.createNewReportServiceBean(
                IKhozenCommonConstants.SUBSYSTEMID_HOZEN,
                "",
                "",
                C_SyoruiCdKbn.KK_KOUJYOSYOUMEIS);

            KhKoujyosyoumeisyoBean khKoujyosyoumeisyoBean = SWAKInjector.getInstance(KhKoujyosyoumeisyoBean.class);

            reportServicesBean.addParamObjects(khKoujyosyoumeisyoBean);

            return reportServicesBean;
        }

        return super.editBean(pKhozenCommonParam, pKoujyoSym, pSyoriYmd);
    }
}
