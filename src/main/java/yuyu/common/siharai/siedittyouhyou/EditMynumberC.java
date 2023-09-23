package yuyu.common.siharai.siedittyouhyou;

import javax.inject.Inject;

import jp.co.slcs.swak.bizinfr.exception.BizAppException;
import jp.co.slcs.swak.core.inject.SWAKInjector;

import org.slf4j.Logger;

import yuyu.common.biz.bzcommon.BizUtil;
import yuyu.common.siharai.sicommon.TeisuuSiharai;
import yuyu.def.MessageId;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.AS_Kinou;
import yuyu.def.siharai.bean.report.SiMynumberCBean;
import yuyu.def.siharai.manager.SiharaiDomManager;
import yuyu.infr.report.CreateReport;
import yuyu.infr.report.swakreport.ReportServicesBean;

/**
 * 保険金給付金支払 保険金給付金支払帳票編集 マイナンバー申告書（Ｃ票）編集
 */
public class EditMynumberC {

    @Inject
    private SiharaiDomManager siharaiDomManager;

    @Inject
    private AS_Kinou kinou;

    @Inject
    private static Logger logger;

    @Inject
    private CreateReport createReport;

    public EditMynumberC() {
        super();
    }

    public ReportServicesBean exec(EditMynumberCBean pEditMynumberCBean) {

        logger.debug("▽ マイナンバー申告書（Ｃ票）編集 開始");

        if (pEditMynumberCBean.getSiTyouhyouHensyuuCommonBean().getSyoriYmd() == null) {
            throw new BizAppException(MessageId.EJS1005, "syoriYmd");
        }

        if (pEditMynumberCBean.getSiTyouhyouHensyuuCommonBean().getSyoruiCd() == null ||
            C_SyoruiCdKbn.BLNK.eq(pEditMynumberCBean.getSiTyouhyouHensyuuCommonBean().getSyoruiCd())) {
            throw new BizAppException(MessageId.EJS1005, "syoruiCd");
        }

        if (BizUtil.isBlank(pEditMynumberCBean.getMntyouhyouptn())) {
            throw new BizAppException(MessageId.EJS1005, "mntyouhyouptn");
        }


        String tyouhyouTitle = siharaiDomManager.getSiTyouhyoumsg(pEditMynumberCBean
            .getSiTyouhyouHensyuuCommonBean().getSyoruiCd().getValue(), "TITLE", 1).getTyouhyoumsg();


        C_UmuKbn sinkokurukthyjumu = C_UmuKbn.NONE;
        C_UmuKbn sinkokursksyahyjumu = C_UmuKbn.NONE;
        C_UmuKbn ininrukthyjumu = C_UmuKbn.NONE;
        C_UmuKbn ininrkykhyjumu = C_UmuKbn.NONE;
        C_UmuKbn ininrsksyahyjumu = C_UmuKbn.NONE;

        if (TeisuuSiharai.MNTYOUHYOUPTN_SOUZOKUZEI.equals(pEditMynumberCBean.getMntyouhyouptn()) ||
            TeisuuSiharai.MNTYOUHYOUPTN_SYOTOKUZEI.equals(pEditMynumberCBean.getMntyouhyouptn()) ||
            TeisuuSiharai.MNTYOUHYOUPTN_UKETORININHUKUSUU.equals(pEditMynumberCBean.getMntyouhyouptn())) {
            sinkokurukthyjumu = C_UmuKbn.ARI;
            ininrukthyjumu = C_UmuKbn.ARI;
        }
        else if(TeisuuSiharai.MNTYOUHYOUPTN_ZOUYOZEI.equals(pEditMynumberCBean.getMntyouhyouptn())){
            sinkokurukthyjumu = C_UmuKbn.ARI;
            ininrkykhyjumu = C_UmuKbn.ARI;
        }
        else if(TeisuuSiharai.MNTYOUHYOUPTN_MENSEKI.equals(pEditMynumberCBean.getMntyouhyouptn())){
            sinkokursksyahyjumu = C_UmuKbn.ARI;
            ininrsksyahyjumu = C_UmuKbn.ARI;
        }
        else {
            throw new BizAppException(MessageId.EJS1005, "mntyouhyouptn");
        }


        SiMynumberCBean siMynumberCBean = SWAKInjector.getInstance(SiMynumberCBean.class);

        siMynumberCBean.setIrTyouhyoutitle(tyouhyouTitle);
        siMynumberCBean.setIrSyono(pEditMynumberCBean.getSyono());
        siMynumberCBean.setIrSinkokurukthyjumu(sinkokurukthyjumu);
        siMynumberCBean.setIrSinkokursksyahyjumu(sinkokursksyahyjumu);
        siMynumberCBean.setIrIninrukthyjumu(ininrukthyjumu);
        siMynumberCBean.setIrIninrkykhyjumu(ininrkykhyjumu);
        siMynumberCBean.setIrIninrsksyahyjumu(ininrsksyahyjumu);

        ReportServicesBean reportServicesBean = createReport.createNewReportServiceBean(
            kinou.getSubSystemId(), kinou.getCategoryId(), kinou.getKinouId(),
            pEditMynumberCBean.getSiTyouhyouHensyuuCommonBean().getSyoruiCd());

        reportServicesBean.setKensakuKeys(pEditMynumberCBean.getSyono());
        reportServicesBean.setSyoriYmd(pEditMynumberCBean.getSiTyouhyouHensyuuCommonBean().getSyoriYmd());

        reportServicesBean.addParamObjects(siMynumberCBean);

        logger.debug("△ マイナンバー申告書（Ｃ票）編集 終了");

        return reportServicesBean;
    }
}
