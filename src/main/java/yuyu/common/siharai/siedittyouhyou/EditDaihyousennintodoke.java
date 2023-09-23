package yuyu.common.siharai.siedittyouhyou;

import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.bizinfr.exception.BizAppException;
import jp.co.slcs.swak.core.inject.SWAKInjector;

import org.slf4j.Logger;

import yuyu.def.MessageId;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.db.entity.AS_Kinou;
import yuyu.def.db.entity.JM_SiTyouhyoumsg;
import yuyu.def.siharai.bean.report.SiDhysntdkBean;
import yuyu.def.siharai.manager.SiharaiDomManager;
import yuyu.infr.report.CreateReport;
import yuyu.infr.report.swakreport.ReportServicesBean;

/**
 * 保険金給付金支払 保険金給付金支払帳票編集 代表選任届編集
 */
public class EditDaihyousennintodoke {

    @Inject
    private static Logger logger;

    @Inject
    private SiharaiDomManager siharaiDomManager;

    @Inject
    private AS_Kinou kinou;

    @Inject
    private CreateReport createReport;

    public EditDaihyousennintodoke() {
        super();
    }

    public ReportServicesBean exec(EditDaihyousennintodokeBean pEditDaihyousennintodokeBean) {
        logger.debug("▽ 代表選任届編集 開始");
        if (pEditDaihyousennintodokeBean.getSiTyouhyouHensyuuCommonBean().getSyoriYmd() == null) {
            throw new BizAppException(MessageId.EJS1005, "syoriYmd");
        }
        if (pEditDaihyousennintodokeBean.getSiTyouhyouHensyuuCommonBean().getSyoruiCd() == null ||
                C_SyoruiCdKbn.BLNK.eq(pEditDaihyousennintodokeBean.getSiTyouhyouHensyuuCommonBean().getSyoruiCd())) {
            throw new BizAppException(MessageId.EJS1005, "syoruiCd");
        }
        List<JM_SiTyouhyoumsg> siTyouhyoumsgLst = siharaiDomManager.getSiTyouhyoumsgsByBunrui1Bunrui2(
                pEditDaihyousennintodokeBean.getSiTyouhyouHensyuuCommonBean().getSyoruiCd().getValue(), "ANNAI_NAIYOU");
        SiDhysntdkBean siDhysntdkBean = SWAKInjector.getInstance(SiDhysntdkBean.class);
        String[] annaiMsgs = new String[4];
        for (int loopCount = 0; loopCount <= siTyouhyoumsgLst.size() - 1; loopCount++) {
            annaiMsgs[loopCount] = siTyouhyoumsgLst.get(loopCount).getTyouhyoumsg();
        }
        siDhysntdkBean.setIrMsg1(annaiMsgs[0]);
        siDhysntdkBean.setIrMsg2(annaiMsgs[1]);
        siDhysntdkBean.setIrMsg3(annaiMsgs[2]);
        siDhysntdkBean.setIrMsg4(annaiMsgs[3]);
        siDhysntdkBean.setIrSyono(pEditDaihyousennintodokeBean.getSyoNo());
        ReportServicesBean reportServicesBean = createReport.createNewReportServiceBean(
                kinou.getSubSystemId(), kinou.getCategoryId(), kinou.getKinouId(),
                pEditDaihyousennintodokeBean.getSiTyouhyouHensyuuCommonBean().getSyoruiCd());
        reportServicesBean.setKensakuKeys(pEditDaihyousennintodokeBean.getSyoNo());
        reportServicesBean.setSyoriYmd(pEditDaihyousennintodokeBean.getSiTyouhyouHensyuuCommonBean().getSyoriYmd());
        reportServicesBean.addParamObjects(siDhysntdkBean);
        logger.debug("△ 代表選任届編集 終了");
        return reportServicesBean;
    }
}
