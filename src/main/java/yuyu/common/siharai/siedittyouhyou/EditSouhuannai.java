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
import yuyu.def.classification.C_HknKknKbn;
import yuyu.def.classification.C_SeikyuuSyubetu;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.AS_Kinou;
import yuyu.def.db.entity.JM_SiTyouhyoumsg;
import yuyu.def.siharai.bean.report.SiShannaiBean;
import yuyu.def.siharai.manager.SiharaiDomManager;
import yuyu.infr.report.CreateReport;
import yuyu.infr.report.swakreport.ReportServicesBean;

/**
 * 保険金給付金支払 保険金給付金支払帳票編集 送付案内編集
 */
public class EditSouhuannai {

    public static final int LINEMAXLEN = 24;

    @Inject
    private SiharaiDomManager siharaiDomManager;

    @Inject
    private AS_Kinou kinou;

    @Inject
    private static Logger logger;

    @Inject
    private CreateReport createReport;

    public EditSouhuannai() {
        super();
    }

    public ReportServicesBean exec(EditSouhuannaiBean pEditSouhuannaiBean) {
        logger.debug("▽ 送付案内編集 開始");

        if (pEditSouhuannaiBean.getSiTyouhyouHensyuuCommonBean().getSyoriYmd() == null) {
            throw new BizAppException(MessageId.EJS1005, "syoriYmd");
        }
        if (pEditSouhuannaiBean.getSiTyouhyouHensyuuCommonBean().getSyoruiCd() == null
            || C_SyoruiCdKbn.BLNK.eq(pEditSouhuannaiBean.getSiTyouhyouHensyuuCommonBean().getSyoruiCd())) {
            throw new BizAppException(MessageId.EJS1005, "syoruiCd");
        }
        if (pEditSouhuannaiBean.getSeikyuusyaInfoBean() == null) {
            throw new BizAppException(MessageId.EJS1005, "seikyuusyaInfoBean");
        }
        if (pEditSouhuannaiBean.getToiawaseInfoBean() == null) {
            throw new BizAppException(MessageId.EJS1005, "toiawaseInfoBean");
        }
        if (pEditSouhuannaiBean.getSeikyuuSyubetu() == null
            || C_SeikyuuSyubetu.BLNK.eq(pEditSouhuannaiBean.getSeikyuuSyubetu())) {
            throw new BizAppException(MessageId.EJS1005, "seikyuuSyubetu");
        }

        String tyouhyoutitle = "";
        if (C_SeikyuuSyubetu.SB.eq(pEditSouhuannaiBean.getSeikyuuSyubetu())) {
            if (pEditSouhuannaiBean.getJisatuMenseki()) {
                tyouhyoutitle = siharaiDomManager.getSiTyouhyoumsg(pEditSouhuannaiBean.getSiTyouhyouHensyuuCommonBean()
                    .getSyoruiCd().getValue(), "TITLE_SB_SBMENSEKI", 1).getTyouhyoumsg();
            } else {
                tyouhyoutitle = siharaiDomManager.getSiTyouhyoumsg(pEditSouhuannaiBean.getSiTyouhyouHensyuuCommonBean()
                    .getSyoruiCd().getValue(), "TITLE_SB", 1).getTyouhyoumsg();
            }
        }
        List<JM_SiTyouhyoumsg> rsouhuAnnaiMsgList = new ArrayList<>();
        if (C_SeikyuuSyubetu.SB.eq(pEditSouhuannaiBean.getSeikyuuSyubetu())) {
            rsouhuAnnaiMsgList = siharaiDomManager.getSiTyouhyoumsgsByBunrui1Bunrui2(pEditSouhuannaiBean
                .getSiTyouhyouHensyuuCommonBean().getSyoruiCd().getValue(), "SB");
        }
        List<JM_SiTyouhyoumsg> annaiNaiyouMsgList = new ArrayList<>();
        List<String> msgSyutokuLst = new ArrayList<>();
        msgSyutokuLst.add("ANNAI_NAIYOU_GOTEISYUTUSYORUI");
        if (C_SeikyuuSyubetu.SB.eq(pEditSouhuannaiBean.getSeikyuuSyubetu())) {
            if (pEditSouhuannaiBean.getJisatuMenseki()) {
                msgSyutokuLst.add("ANNAI_NAIYOU_SBMENSEKI");
            } else {
                msgSyutokuLst.add("ANNAI_NAIYOU_SB");
            }
            if (C_UmuKbn.ARI.eq(pEditSouhuannaiBean.getMynumbertksUmuKbn())) {
                msgSyutokuLst.add("ANNAI_NAIYOU_MYNUMBER");
            }

            msgSyutokuLst.add("ANNAI_NAIYOU_BLNK");

            if (!C_Tuukasyu.JPY.eq(pEditSouhuannaiBean.getKykTuukasyu())) {
                if (pEditSouhuannaiBean.getJisatuMenseki()) {
                    msgSyutokuLst.add("ANNAI_NAIYOU_YENSIHARAI_1");
                    msgSyutokuLst.add("ANNAI_NAIYOU_YENSIHARAI_2_SBMENSEKI");
                    msgSyutokuLst.add("ANNAI_NAIYOU_YENSIHARAI_3");
                    msgSyutokuLst.add("ANNAI_NAIYOU_YENSIHARAI_4");
                    msgSyutokuLst.add("ANNAI_NAIYOU_GAIKASIHARAI_1_SBMENSEKI");
                    msgSyutokuLst.add("ANNAI_NAIYOU_GAIKASIHARAI_2_SBMENSEKI");
                } else {
                    msgSyutokuLst.add("ANNAI_NAIYOU_YENSIHARAI_1");
                    msgSyutokuLst.add("ANNAI_NAIYOU_YENSIHARAI_2_SB");
                    msgSyutokuLst.add("ANNAI_NAIYOU_YENSIHARAI_3");
                    msgSyutokuLst.add("ANNAI_NAIYOU_YENSIHARAI_4");
                    msgSyutokuLst.add("ANNAI_NAIYOU_GAIKASIHARAI_1_SB");
                    msgSyutokuLst.add("ANNAI_NAIYOU_GAIKASIHARAI_2_SB");

                    if (C_UmuKbn.ARI.eq(pEditSouhuannaiBean.getInitsbjiyensitihsytkhukaUmu()) &&
                        C_HknKknKbn.DAI1HKNKKN.eq(pEditSouhuannaiBean.getHknkknKbn())) {
                        msgSyutokuLst.add("ANNAI_NAIYOU_INITSBJIYENSITIHSYTKHUKA");
                    }
                }
            }
        }
        msgSyutokuLst.add("ANNAI_NAIYOU_TYUUIJIKOU");
        for (String msgSyutoku : msgSyutokuLst) {
            annaiNaiyouMsgList.addAll(siharaiDomManager.getSiTyouhyoumsgsByBunrui1Bunrui2(pEditSouhuannaiBean
                .getSiTyouhyouHensyuuCommonBean().getSyoruiCd().getValue(), msgSyutoku));
        }

        SiShannaiBean siShannaiBean = SWAKInjector.getInstance(SiShannaiBean.class);
        BzKokyakuAtesakiBean bzKokyakuAtesakiBean = SWAKInjector.getInstance(BzKokyakuAtesakiBean.class);
        String irTyouhyousakuseiymd = DateFormatUtil.dateKANJINoEx(pEditSouhuannaiBean
            .getSiTyouhyouHensyuuCommonBean().getSyoriYmd());
        bzKokyakuAtesakiBean.setIrTyouhyousakuseiymd(irTyouhyousakuseiymd);
        bzKokyakuAtesakiBean.setIrShsyno(pEditSouhuannaiBean.getSeikyuusyaInfoBean().getTsinyno());

        String[] results = ViewReport.editAdrDisp(LINEMAXLEN,
            pEditSouhuannaiBean.getSeikyuusyaInfoBean().getTsinadr1kj(),
            pEditSouhuannaiBean.getSeikyuusyaInfoBean().getTsinadr2kj(),
            pEditSouhuannaiBean.getSeikyuusyaInfoBean().getTsinadr3kj());
        bzKokyakuAtesakiBean.setIrShadr1kj(results[0]);
        bzKokyakuAtesakiBean.setIrShadr2kj(results[1]);
        if (results.length > 2) {
            bzKokyakuAtesakiBean.setIrShadr3kj(results[2]);
        }

        bzKokyakuAtesakiBean.setIrShsnmkj(pEditSouhuannaiBean.getSeikyuusyaInfoBean().getSeikyuusyanmKj());
        bzKokyakuAtesakiBean.setIrHknkisynm(YuyuBizConfig.getInstance().getHokenKaisyaNmKanji());
        bzKokyakuAtesakiBean.setIrToiawasesosiki(pEditSouhuannaiBean.getToiawaseInfoBean().getSosikiNm());
        bzKokyakuAtesakiBean.setIrToiawasetantounm("");
        bzKokyakuAtesakiBean.setIrToiawaseyno(pEditSouhuannaiBean.getToiawaseInfoBean().getTsinyno());
        bzKokyakuAtesakiBean.setIrToiawaseadr1kj(pEditSouhuannaiBean.getToiawaseInfoBean().getTsinadr1kj());
        bzKokyakuAtesakiBean.setIrToiawaseadr2kj(pEditSouhuannaiBean.getToiawaseInfoBean().getTsinadr2kj());
        bzKokyakuAtesakiBean.setIrToiawaseadr3kj(pEditSouhuannaiBean.getToiawaseInfoBean().getTsinadr3kj());
        bzKokyakuAtesakiBean.setIrToiawasetelno(pEditSouhuannaiBean.getToiawaseInfoBean().getTsintelno());
        bzKokyakuAtesakiBean.setIrToiawaseteluktkkanou1("");
        bzKokyakuAtesakiBean.setIrToiawaseteluktkkanou2("");
        String[] rsouhuAnnaiMsgAr = new String[5];
        int loopCount = 0;
        for (; loopCount < rsouhuAnnaiMsgList.size(); loopCount++) {
            JM_SiTyouhyoumsg rsouhuAnnaiMsg = rsouhuAnnaiMsgList.get(loopCount);
            rsouhuAnnaiMsgAr[loopCount] = rsouhuAnnaiMsg.getTyouhyoumsg();
        }
        String[] annaiNaiyouMsgAr = new String[32];
        int loopCount2 = 0;
        for (; loopCount2 < annaiNaiyouMsgList.size(); loopCount2++) {
            JM_SiTyouhyoumsg siTyouhyouMsg = annaiNaiyouMsgList.get(loopCount2);
            annaiNaiyouMsgAr[loopCount2] = siTyouhyouMsg.getTyouhyoumsg();
        }
        siShannaiBean.setIrTyouhyoutitle(tyouhyoutitle);
        siShannaiBean.setIrMsg1(rsouhuAnnaiMsgAr[0]);
        siShannaiBean.setIrMsg2(rsouhuAnnaiMsgAr[1]);
        siShannaiBean.setIrMsg3(rsouhuAnnaiMsgAr[2]);
        siShannaiBean.setIrMsg4(rsouhuAnnaiMsgAr[3]);
        siShannaiBean.setIrMsg5(rsouhuAnnaiMsgAr[4]);
        siShannaiBean.setIrSyono(ConvertUtil.toZenNumeric(pEditSouhuannaiBean.getSyono()));
        siShannaiBean.setIrMsg6(annaiNaiyouMsgAr[0]);
        siShannaiBean.setIrMsg7(annaiNaiyouMsgAr[1]);
        siShannaiBean.setIrMsg8(annaiNaiyouMsgAr[2]);
        siShannaiBean.setIrMsg9(annaiNaiyouMsgAr[3]);
        siShannaiBean.setIrMsg10(annaiNaiyouMsgAr[4]);
        siShannaiBean.setIrMsg11(annaiNaiyouMsgAr[5]);
        siShannaiBean.setIrMsg12(annaiNaiyouMsgAr[6]);
        siShannaiBean.setIrMsg13(annaiNaiyouMsgAr[7]);
        siShannaiBean.setIrMsg14(annaiNaiyouMsgAr[8]);
        siShannaiBean.setIrMsg15(annaiNaiyouMsgAr[9]);
        siShannaiBean.setIrMsg16(annaiNaiyouMsgAr[10]);
        siShannaiBean.setIrMsg17(annaiNaiyouMsgAr[11]);
        siShannaiBean.setIrMsg18(annaiNaiyouMsgAr[12]);
        siShannaiBean.setIrMsg19(annaiNaiyouMsgAr[13]);
        siShannaiBean.setIrMsg20(annaiNaiyouMsgAr[14]);
        siShannaiBean.setIrMsg21(annaiNaiyouMsgAr[15]);
        siShannaiBean.setIrMsg22(annaiNaiyouMsgAr[16]);
        siShannaiBean.setIrMsg23(annaiNaiyouMsgAr[17]);
        siShannaiBean.setIrMsg24(annaiNaiyouMsgAr[18]);
        siShannaiBean.setIrMsg25(annaiNaiyouMsgAr[19]);
        siShannaiBean.setIrMsg26(annaiNaiyouMsgAr[20]);
        siShannaiBean.setIrMsg27(annaiNaiyouMsgAr[21]);
        siShannaiBean.setIrMsg28(annaiNaiyouMsgAr[22]);
        siShannaiBean.setIrMsg29(annaiNaiyouMsgAr[23]);
        siShannaiBean.setIrMsg30(annaiNaiyouMsgAr[24]);
        siShannaiBean.setIrMsg31(annaiNaiyouMsgAr[25]);
        siShannaiBean.setIrMsg32(annaiNaiyouMsgAr[26]);
        siShannaiBean.setIrMsg33(annaiNaiyouMsgAr[27]);
        siShannaiBean.setIrMsg34(annaiNaiyouMsgAr[28]);
        siShannaiBean.setIrMsg35(annaiNaiyouMsgAr[29]);
        siShannaiBean.setIrMsg36(annaiNaiyouMsgAr[30]);
        siShannaiBean.setIrMsg37(annaiNaiyouMsgAr[31]);
        ReportServicesBean reportServicesBean = createReport.createNewReportServiceBean(
            kinou.getSubSystemId(), kinou.getCategoryId(), kinou.getKinouId(),
            pEditSouhuannaiBean.getSiTyouhyouHensyuuCommonBean().getSyoruiCd());
        reportServicesBean.setKensakuKeys(pEditSouhuannaiBean.getSyono());
        reportServicesBean.setSyoriYmd(pEditSouhuannaiBean.getSiTyouhyouHensyuuCommonBean().getSyoriYmd());
        reportServicesBean.addParamObjects(siShannaiBean, bzKokyakuAtesakiBean);

        logger.debug("△ 送付案内編集 終了");

        return reportServicesBean;
    }
}
