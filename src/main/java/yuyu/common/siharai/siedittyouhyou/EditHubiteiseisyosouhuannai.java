package yuyu.common.siharai.siedittyouhyou;

import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.bizinfr.exception.BizAppException;
import jp.co.slcs.swak.core.inject.SWAKInjector;

import org.slf4j.Logger;

import yuyu.common.biz.bzcommon.DateFormatUtil;
import yuyu.common.biz.report.ViewReport;
import yuyu.def.MessageId;
import yuyu.def.biz.bean.report.BzKokyakuAtesakiBean;
import yuyu.def.biz.configuration.YuyuBizConfig;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.db.entity.AS_Kinou;
import yuyu.def.db.entity.JM_SiTyouhyoumsg;
import yuyu.def.siharai.bean.report.SiSouhuannaihubiBean;
import yuyu.def.siharai.manager.SiharaiDomManager;
import yuyu.infr.report.CreateReport;
import yuyu.infr.report.swakreport.ReportServicesBean;

/**
 * 保険金給付金支払 保険金給付金支払帳票編集 不備訂正書の送付案内編集
 */
public class EditHubiteiseisyosouhuannai {

    public static final int LINEMAXLEN = 24;

    @Inject
    private SiharaiDomManager siharaiDomManager;

    @Inject
    private AS_Kinou kinou;

    @Inject
    private static Logger logger;

    @Inject
    private CreateReport createReport;

    public EditHubiteiseisyosouhuannai() {
        super();
    }

    public ReportServicesBean exec(EditHubiteiseisyosouhuannaiBean pEditHubiteiseisyosouhuannaiBean) {

        logger.debug("▽ 不備訂正書の送付案内編集 開始");

        if (pEditHubiteiseisyosouhuannaiBean.getSiTyouhyouHensyuuCommonBean().getSyoriYmd() == null) {
            throw new BizAppException(MessageId.EJS1005, "syoriYmd");
        }

        if (pEditHubiteiseisyosouhuannaiBean.getSiTyouhyouHensyuuCommonBean().getSyoruiCd() == null ||
            C_SyoruiCdKbn.BLNK.eq(pEditHubiteiseisyosouhuannaiBean.getSiTyouhyouHensyuuCommonBean().getSyoruiCd())) {
            throw new BizAppException(MessageId.EJS1005, "syoruiCd");
        }

        if (pEditHubiteiseisyosouhuannaiBean.getSeikyuusyaInfoBean() == null) {
            throw new BizAppException(MessageId.EJS1005, "seikyuusyaInfoBean");
        }

        if (pEditHubiteiseisyosouhuannaiBean.getToiawaseInfoBean() == null) {
            throw new BizAppException(MessageId.EJS1005, "toiawaseInfoBean");
        }


        String syoruiCd = pEditHubiteiseisyosouhuannaiBean.getSiTyouhyouHensyuuCommonBean().getSyoruiCd().getValue();
        List<JM_SiTyouhyoumsg> siTyouhyoumsgLst = siharaiDomManager.getSiTyouhyoumsgsByBunrui1Bunrui2
            (syoruiCd, "ANNAI_NAIYOU");


        BzKokyakuAtesakiBean bzKokyakuAtesakiBean = SWAKInjector.getInstance(BzKokyakuAtesakiBean.class);
        SiSouhuannaihubiBean siSouhuannaihubiBean = SWAKInjector.getInstance(SiSouhuannaihubiBean.class);
        String[] souhuAnnaiMsgAry = new String[7];
        int loopCount = 0;

        for (int a = 0; a < siTyouhyoumsgLst.size(); a++) {
            souhuAnnaiMsgAry[loopCount] = siTyouhyoumsgLst.get(loopCount).getTyouhyoumsg();
            loopCount++;
        }

        String date = DateFormatUtil.dateKANJINoEx(pEditHubiteiseisyosouhuannaiBean.
            getSiTyouhyouHensyuuCommonBean().getSyoriYmd());
        bzKokyakuAtesakiBean.setIrTyouhyousakuseiymd(date);

        SeikyuusyaInfoBean seikyuusyaInfoBean = pEditHubiteiseisyosouhuannaiBean.getSeikyuusyaInfoBean();
        ToiawaseInfoBean toiawaseInfoBean = pEditHubiteiseisyosouhuannaiBean.getToiawaseInfoBean();

        bzKokyakuAtesakiBean.setIrShsyno(seikyuusyaInfoBean.getTsinyno());

        String[] results = ViewReport.editAdrDisp(LINEMAXLEN,
            seikyuusyaInfoBean.getTsinadr1kj(),
            seikyuusyaInfoBean.getTsinadr2kj(),
            seikyuusyaInfoBean.getTsinadr3kj());
        bzKokyakuAtesakiBean.setIrShadr1kj(results[0]);
        bzKokyakuAtesakiBean.setIrShadr2kj(results[1]);
        if (results.length > 2) {
            bzKokyakuAtesakiBean.setIrShadr3kj(results[2]);
        }

        bzKokyakuAtesakiBean.setIrShsnmkj(seikyuusyaInfoBean.getSeikyuusyanmKj());
        bzKokyakuAtesakiBean.setIrHknkisynm(YuyuBizConfig.getInstance().getHokenKaisyaNmKanji());
        bzKokyakuAtesakiBean.setIrToiawasesosiki(toiawaseInfoBean.getSosikiNm());
        bzKokyakuAtesakiBean.setIrToiawasetantounm("");
        bzKokyakuAtesakiBean.setIrToiawaseyno(toiawaseInfoBean.getTsinyno());
        bzKokyakuAtesakiBean.setIrToiawaseadr1kj(toiawaseInfoBean.getTsinadr1kj());
        bzKokyakuAtesakiBean.setIrToiawaseadr2kj(toiawaseInfoBean.getTsinadr2kj());
        bzKokyakuAtesakiBean.setIrToiawaseadr3kj(toiawaseInfoBean.getTsinadr3kj());
        bzKokyakuAtesakiBean.setIrToiawasetelno(toiawaseInfoBean.getTsintelno());
        bzKokyakuAtesakiBean.setIrToiawaseteluktkkanou1("");
        bzKokyakuAtesakiBean.setIrToiawaseteluktkkanou2("");

        siSouhuannaihubiBean.setIrMsg1(souhuAnnaiMsgAry[0]);
        siSouhuannaihubiBean.setIrMsg2(souhuAnnaiMsgAry[1]);
        siSouhuannaihubiBean.setIrMsg3(souhuAnnaiMsgAry[2]);
        siSouhuannaihubiBean.setIrMsg4(souhuAnnaiMsgAry[3]);
        siSouhuannaihubiBean.setIrMsg5(souhuAnnaiMsgAry[4]);
        siSouhuannaihubiBean.setIrMsg6(souhuAnnaiMsgAry[5]);
        siSouhuannaihubiBean.setIrMsg7(souhuAnnaiMsgAry[6]);
        siSouhuannaihubiBean.setIrSyono(pEditHubiteiseisyosouhuannaiBean.getSyono());
        siSouhuannaihubiBean.setIrHhknnmkj(pEditHubiteiseisyosouhuannaiBean.getHhknnmkj());
        siSouhuannaihubiBean.setIrHubirenrakuran(pEditHubiteiseisyosouhuannaiBean.getRenrakuarea());

        ReportServicesBean reportServicesBean = createReport.createNewReportServiceBean(
            kinou.getSubSystemId(), kinou.getCategoryId(), kinou.getKinouId(),
            pEditHubiteiseisyosouhuannaiBean.getSiTyouhyouHensyuuCommonBean().getSyoruiCd());
        reportServicesBean.setKensakuKeys(pEditHubiteiseisyosouhuannaiBean.getSyono());
        reportServicesBean.setSyoriYmd(pEditHubiteiseisyosouhuannaiBean.getSiTyouhyouHensyuuCommonBean().getSyoriYmd());
        reportServicesBean.addParamObjects(siSouhuannaihubiBean ,bzKokyakuAtesakiBean);
        logger.debug("△ 不備訂正書の送付案内編集 終了");

        return reportServicesBean;
    }
}
