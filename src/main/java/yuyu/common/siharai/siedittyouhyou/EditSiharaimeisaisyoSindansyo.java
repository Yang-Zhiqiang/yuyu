package yuyu.common.siharai.siedittyouhyou;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.bizinfr.exception.BizAppException;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.util.string.ConvertUtil;

import org.slf4j.Logger;

import yuyu.common.biz.bzcommon.DateFormatUtil;
import yuyu.common.biz.report.ViewReport;
import yuyu.def.MessageId;
import yuyu.def.biz.bean.report.BzKokyakuAtesakiBean;
import yuyu.def.biz.configuration.YuyuBizConfig;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.db.entity.AS_Kinou;
import yuyu.def.db.entity.JM_SiTyouhyoumsg;
import yuyu.def.siharai.bean.report.SiShrmeisaiSindansyoBean;
import yuyu.def.siharai.manager.SiharaiDomManager;
import yuyu.infr.report.CreateReport;
import yuyu.infr.report.swakreport.ReportServicesBean;

/**
 * 保険金給付金支払 保険金給付金支払帳票編集 支払明細書編集（診断書料支払）
 */
public class EditSiharaimeisaisyoSindansyo {

    private static final String SINDANSYO = "診断書";

    private static final String MAISUU = "枚";

    public static final int LINEMAXLEN = 24;

    @Inject
    private SiharaiDomManager shiraiDomManager;

    @Inject
    private AS_Kinou kinou;

    @Inject
    private static Logger logger;

    @Inject
    private CreateReport createReport;

    public EditSiharaimeisaisyoSindansyo() {
        super();
    }

    public ReportServicesBean exec(EditSiharaimeisaisyoSindansyoBean pEditSiharaimeisaisyoSindansyoBean) {

        logger.debug("▽ 支払明細書編集（診断書料支払）開始");

        if (pEditSiharaimeisaisyoSindansyoBean.getSiTyouhyouHensyuuCommonBean().getSyoriYmd() == null) {
            throw new BizAppException(MessageId.EJS1005, "syoriYmd");
        }
        if (pEditSiharaimeisaisyoSindansyoBean.getSiTyouhyouHensyuuCommonBean().getSyoruiCd() == null
            || C_SyoruiCdKbn.BLNK.eq(pEditSiharaimeisaisyoSindansyoBean.getSiTyouhyouHensyuuCommonBean().getSyoruiCd())) {
            throw new BizAppException(MessageId.EJS1005, "syoruiCd");
        }
        if (pEditSiharaimeisaisyoSindansyoBean.getSeikyuusyaInfoBean() == null) {
            throw new BizAppException(MessageId.EJS1005, "seikyuusyaInfoBean");
        }
        if (pEditSiharaimeisaisyoSindansyoBean.getToiawaseInfoBean() == null) {
            throw new BizAppException(MessageId.EJS1005, "toiawaseInfoBean");
        }

        List<JM_SiTyouhyoumsg> annainaiyouMsg1Lst = new ArrayList<>();
        List<JM_SiTyouhyoumsg> annainaiyouMsg2Lst = new ArrayList<>();
        List<JM_SiTyouhyoumsg> annainaiyouMsg3Lst = new ArrayList<>();

        annainaiyouMsg1Lst = shiraiDomManager.getSiTyouhyoumsgsByBunrui1Bunrui2(pEditSiharaimeisaisyoSindansyoBean
            .getSiTyouhyouHensyuuCommonBean().getSyoruiCd().getValue(), "SINDANSYO_ANNAI_NAIYOU1");
        annainaiyouMsg2Lst = shiraiDomManager.getSiTyouhyoumsgsByBunrui1Bunrui2(pEditSiharaimeisaisyoSindansyoBean
            .getSiTyouhyouHensyuuCommonBean().getSyoruiCd().getValue(), "SINDANSYO_ANNAI_NAIYOU2");
        annainaiyouMsg3Lst = shiraiDomManager.getSiTyouhyoumsgsByBunrui1Bunrui2(pEditSiharaimeisaisyoSindansyoBean
            .getSiTyouhyouHensyuuCommonBean().getSyoruiCd().getValue(), "SINDANSYO_ANNAI_NAIYOU3");

        SiShrmeisaiSindansyoBean siShrmeisaiSindansyoBean = SWAKInjector.getInstance(SiShrmeisaiSindansyoBean.class);

        String irShrdetailbikou = SINDANSYO +
            ConvertUtil.toZenAll(String.valueOf(pEditSiharaimeisaisyoSindansyoBean.getSindansyomaisuu()),0, 0) + MAISUU;
        BzKokyakuAtesakiBean bzKokyakuAtesakiBean = SWAKInjector.getInstance(BzKokyakuAtesakiBean.class);

        String irTyouhyousakuseiymd = DateFormatUtil.dateKANJINoEx(pEditSiharaimeisaisyoSindansyoBean
            .getSiTyouhyouHensyuuCommonBean().getSyoriYmd());
        bzKokyakuAtesakiBean.setIrTyouhyousakuseiymd(irTyouhyousakuseiymd);
        bzKokyakuAtesakiBean.setIrShsyno(pEditSiharaimeisaisyoSindansyoBean.getSeikyuusyaInfoBean().getTsinyno());

        String[] results = ViewReport.editAdrDisp(LINEMAXLEN,
            pEditSiharaimeisaisyoSindansyoBean.getSeikyuusyaInfoBean().getTsinadr1kj(),
            pEditSiharaimeisaisyoSindansyoBean.getSeikyuusyaInfoBean().getTsinadr2kj(),
            pEditSiharaimeisaisyoSindansyoBean.getSeikyuusyaInfoBean().getTsinadr3kj());
        bzKokyakuAtesakiBean.setIrShadr1kj(results[0]);
        bzKokyakuAtesakiBean.setIrShadr2kj(results[1]);
        if (results.length > 2) {
            bzKokyakuAtesakiBean.setIrShadr3kj(results[2]);
        }

        bzKokyakuAtesakiBean.setIrShsnmkj(pEditSiharaimeisaisyoSindansyoBean.getSeikyuusyaInfoBean().getSeikyuusyanmKj());
        bzKokyakuAtesakiBean.setIrHknkisynm(YuyuBizConfig.getInstance().getHokenKaisyaNmKanji());
        bzKokyakuAtesakiBean.setIrToiawasesosiki(pEditSiharaimeisaisyoSindansyoBean.getToiawaseInfoBean().getSosikiNm());
        bzKokyakuAtesakiBean.setIrToiawasetantounm("");
        bzKokyakuAtesakiBean.setIrToiawaseyno(pEditSiharaimeisaisyoSindansyoBean.getToiawaseInfoBean().getTsinyno());
        bzKokyakuAtesakiBean.setIrToiawaseadr1kj(pEditSiharaimeisaisyoSindansyoBean.getToiawaseInfoBean().getTsinadr1kj());
        bzKokyakuAtesakiBean.setIrToiawaseadr2kj(pEditSiharaimeisaisyoSindansyoBean.getToiawaseInfoBean().getTsinadr2kj());
        bzKokyakuAtesakiBean.setIrToiawaseadr3kj(pEditSiharaimeisaisyoSindansyoBean.getToiawaseInfoBean().getTsinadr3kj());
        bzKokyakuAtesakiBean.setIrToiawasetelno(pEditSiharaimeisaisyoSindansyoBean.getToiawaseInfoBean().getTsintelno());
        bzKokyakuAtesakiBean.setIrToiawaseteluktkkanou1("");
        bzKokyakuAtesakiBean.setIrToiawaseteluktkkanou2("");

        siShrmeisaiSindansyoBean.setIrSyono(ConvertUtil.toZenAlphabet(ConvertUtil
            .toZenNumeric(pEditSiharaimeisaisyoSindansyoBean.getSyoNo()), 1));
        siShrmeisaiSindansyoBean.setIrTyakkinymd(ConvertUtil.toZenNumeric(DateFormatUtil
            .dateKANJINoEx(pEditSiharaimeisaisyoSindansyoBean.getTyakkinYmd())));
        siShrmeisaiSindansyoBean.setIrKyuuhuname(pEditSiharaimeisaisyoSindansyoBean.getKyuuhuNameReport());
        siShrmeisaiSindansyoBean.setIrKyhkg(pEditSiharaimeisaisyoSindansyoBean.getSindansyoryou());
        siShrmeisaiSindansyoBean.setIrShrdetailbikou(irShrdetailbikou);
        siShrmeisaiSindansyoBean.setIrShrgk(pEditSiharaimeisaisyoSindansyoBean.getSindansyoryou());
        siShrmeisaiSindansyoBean.setIrBanknmkj(pEditSiharaimeisaisyoSindansyoBean.getBanknmKj());
        siShrmeisaiSindansyoBean.setIrSitennmkj(pEditSiharaimeisaisyoSindansyoBean.getSitennmKj());
        siShrmeisaiSindansyoBean.setIrYokinknmkj(pEditSiharaimeisaisyoSindansyoBean.getYokinKbn().getContent());
        siShrmeisaiSindansyoBean.setIrKouzano(pEditSiharaimeisaisyoSindansyoBean.getKouzaNo());
        siShrmeisaiSindansyoBean.setIrKzmeiginmkn(pEditSiharaimeisaisyoSindansyoBean.getKzmeiginmKn());

        String annaiNaiyouMsgArr1 = annainaiyouMsg1Lst.get(0).getTyouhyoumsg();

        String[] annaiNaiyouMsgArr2 = new String[5];
        int loopCount2 = 0;

        while (loopCount2 < annainaiyouMsg2Lst.size() && loopCount2 < annaiNaiyouMsgArr2.length) {
            annaiNaiyouMsgArr2[loopCount2] = annainaiyouMsg2Lst.get(loopCount2).getTyouhyoumsg();
            loopCount2++;
        }

        String[] annaiNaiyouMsgArr3 = new String[7];
        int loopCount3 = 0;

        while (loopCount3 < annainaiyouMsg3Lst.size() && loopCount3 < annaiNaiyouMsgArr3.length) {
            annaiNaiyouMsgArr3[loopCount3] = annainaiyouMsg3Lst.get(loopCount3).getTyouhyoumsg();
            loopCount3++;
        }

        siShrmeisaiSindansyoBean.setIrMsg1(annaiNaiyouMsgArr1);
        siShrmeisaiSindansyoBean.setIrMsg2(annaiNaiyouMsgArr2[0]);
        siShrmeisaiSindansyoBean.setIrMsg3(annaiNaiyouMsgArr2[1]);
        siShrmeisaiSindansyoBean.setIrMsg4(annaiNaiyouMsgArr2[2]);
        siShrmeisaiSindansyoBean.setIrMsg5(annaiNaiyouMsgArr2[3]);
        siShrmeisaiSindansyoBean.setIrMsg6(annaiNaiyouMsgArr2[4]);
        siShrmeisaiSindansyoBean.setIrMsg7(annaiNaiyouMsgArr3[0]);
        siShrmeisaiSindansyoBean.setIrMsg8(annaiNaiyouMsgArr3[1]);
        siShrmeisaiSindansyoBean.setIrMsg9(annaiNaiyouMsgArr3[2]);
        siShrmeisaiSindansyoBean.setIrMsg10(annaiNaiyouMsgArr3[3]);
        siShrmeisaiSindansyoBean.setIrMsg11(annaiNaiyouMsgArr3[4]);
        siShrmeisaiSindansyoBean.setIrMsg12(annaiNaiyouMsgArr3[5]);
        siShrmeisaiSindansyoBean.setIrMsg13(annaiNaiyouMsgArr3[6]);

        ReportServicesBean reportServicesBean =
            createReport.createNewReportServiceBean(kinou.getSubSystemId(),
                kinou.getCategoryId(), kinou.getKinouId(),
                pEditSiharaimeisaisyoSindansyoBean.getSiTyouhyouHensyuuCommonBean().getSyoruiCd());

        reportServicesBean.setKensakuKeys(pEditSiharaimeisaisyoSindansyoBean.getSyoNo());
        reportServicesBean.setSyoriYmd(pEditSiharaimeisaisyoSindansyoBean.getSiTyouhyouHensyuuCommonBean().getSyoriYmd());

        reportServicesBean.addParamObjects(pEditSiharaimeisaisyoSindansyoBean.getSiTyouhyouHensyuuCommonBean().getSyoruiCd(),
            siShrmeisaiSindansyoBean, bzKokyakuAtesakiBean);

        logger.debug("△ 支払明細書編集（診断書料支払）終了");

        return reportServicesBean;
    }
}
