package yuyu.common.siharai.siedittyouhyou;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.bizinfr.exception.BizAppException;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.util.string.ConvertUtil;

import org.slf4j.Logger;

import yuyu.common.biz.bzcommon.DateFormatUtil;
import yuyu.common.biz.report.ViewReport;
import yuyu.common.sinkeiyaku.skcommon.SyouhinUtil;
import yuyu.def.MessageId;
import yuyu.def.classification.C_HokenkinsyuruiKbn;
import yuyu.def.classification.C_KyksyaSibouUmuKbn;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.AS_Kinou;
import yuyu.def.db.entity.JM_SiTyouhyoumsg;
import yuyu.def.siharai.bean.report.SiSeisansksBean;
import yuyu.def.siharai.manager.SiharaiDomManager;
import yuyu.infr.report.CreateReport;
import yuyu.infr.report.swakreport.ReportServicesBean;

/**
 * 保険金給付金支払 保険金給付金支払帳票編集 精算金振込依頼書編集
 */
public class EditSeisankinhurikomiiraisyo {

    public static final int LINEMAXLEN = 27;

    @Inject
    private SiharaiDomManager siharaiDomManager;

    @Inject
    private AS_Kinou kinou;

    @Inject
    private static Logger logger;

    @Inject
    private CreateReport createReport;

    public EditSeisankinhurikomiiraisyo() {
        super();
    }

    public ReportServicesBean exec(EditSeisankinhurikomiiraisyoBean pEditSeisankinhurikomiiraisyoBean) {

        logger.debug("▽ 精算金振込依頼書編集 開始");


        BizDate syoriYmd = pEditSeisankinhurikomiiraisyoBean.getSiTyouhyouHensyuuCommonBean().getSyoriYmd();
        if (syoriYmd == null) {
            throw new BizAppException(MessageId.EJS1005, "syoriYmd");
        }

        C_SyoruiCdKbn syoruiCd = pEditSeisankinhurikomiiraisyoBean.getSiTyouhyouHensyuuCommonBean().getSyoruiCd();
        if (syoruiCd == null || C_SyoruiCdKbn.BLNK.eq(syoruiCd)) {
            throw new BizAppException(MessageId.EJS1005, "syoruiCd");
        }

        if (pEditSeisankinhurikomiiraisyoBean.getSeikyuusyaInfoBean() == null) {
            throw new BizAppException(MessageId.EJS1005, "seikyuusyaInfoBean");
        }


        int syohinHanteiKbn = SyouhinUtil.hantei(pEditSeisankinhurikomiiraisyoBean.getSyouhncd());
        C_UmuKbn bikouhyjumu = C_UmuKbn.ARI;

        if (C_Tuukasyu.JPY.eq(pEditSeisankinhurikomiiraisyoBean.getKyktuukasyu()) &&
            SyouhinUtil.GONENRISAHAITOUSITEITUUKASYUUSIN_ITIJIBR_19 == syohinHanteiKbn) {
            bikouhyjumu = C_UmuKbn.NONE;
        }


        List<JM_SiTyouhyoumsg> souhuAnnaiMsgLst = new ArrayList<>();
        List<JM_SiTyouhyoumsg> annaiNaiyouMsgLst = new ArrayList<>();

        if (C_HokenkinsyuruiKbn.SBHOKENKIN.eq(pEditSeisankinhurikomiiraisyoBean.getHokenkinsyuruikbn())) {

            souhuAnnaiMsgLst = siharaiDomManager.getSiTyouhyoumsgsByBunrui1Bunrui2(
                syoruiCd.getValue(), "SOUHU_ANNAI");

            if (C_UmuKbn.ARI.eq(bikouhyjumu)) {
                annaiNaiyouMsgLst = siharaiDomManager.getSiTyouhyoumsgsByBunrui1Bunrui2(
                    syoruiCd.getValue(), "ANNAI_NAIYOU");
            }
            else {
                annaiNaiyouMsgLst = siharaiDomManager.getSiTyouhyoumsgsByBunrui1Bunrui2(
                    syoruiCd.getValue(), "ANNAI_NAIYOU_BIKOUNASI");

            }
        }
        else if (C_HokenkinsyuruiKbn.SBKYUUHUKIN.eq(pEditSeisankinhurikomiiraisyoBean.getHokenkinsyuruikbn())) {

            souhuAnnaiMsgLst = siharaiDomManager.getSiTyouhyoumsgsByBunrui1Bunrui2(
                syoruiCd.getValue(), "SOUHU_ANNAI_KYUHUKIN");

            if (C_UmuKbn.ARI.eq(bikouhyjumu)) {
                annaiNaiyouMsgLst = siharaiDomManager.getSiTyouhyoumsgsByBunrui1Bunrui2(
                    syoruiCd.getValue(), "ANNAI_NAIYOU_KYUHUKIN");
            }
            else {
                annaiNaiyouMsgLst = siharaiDomManager.getSiTyouhyoumsgsByBunrui1Bunrui2(
                    syoruiCd.getValue(), "ANNAI_NAIYOU_KYUHUKIN_BIKOUNASI");

            }
        }

        String hozonKknJyohn = ViewReport.getHozonKknTani(syoruiCd);


        C_UmuKbn shsrtdkdadrhyjumu = C_UmuKbn.NONE;
        C_UmuKbn shsrkinyuuhyjumu = C_UmuKbn.NONE;
        C_UmuKbn mensekijiyuuhknknhyjumu = C_UmuKbn.NONE;
        C_UmuKbn mensekijiyuukyhknhyjumu = C_UmuKbn.NONE;
        C_UmuKbn ukthougkdthyjumu = C_UmuKbn.NONE;
        C_UmuKbn ukthouendthyjumu = C_UmuKbn.NONE;

        if (C_KyksyaSibouUmuKbn.KYKSBARI.eq(pEditSeisankinhurikomiiraisyoBean.getKyksyasibouumukbn())){
            shsrkinyuuhyjumu = C_UmuKbn.ARI;
        }
        else {
            shsrtdkdadrhyjumu = C_UmuKbn.ARI;
        }

        if (C_HokenkinsyuruiKbn.SBHOKENKIN.eq(pEditSeisankinhurikomiiraisyoBean.getHokenkinsyuruikbn())) {
            mensekijiyuuhknknhyjumu = C_UmuKbn.ARI;
        }
        else {
            mensekijiyuukyhknhyjumu = C_UmuKbn.ARI;
        }

        if (C_Tuukasyu.JPY.eq(pEditSeisankinhurikomiiraisyoBean.getKyktuukasyu())) {
            ukthouendthyjumu = C_UmuKbn.ARI;
        }
        else {
            ukthougkdthyjumu = C_UmuKbn.ARI;
        }

        SiSeisansksBean siSeisansksBean = SWAKInjector.getInstance(SiSeisansksBean.class);

        String[] souhuAnnaiMsgAry = new String[5];
        for (int loopCount = 0; loopCount < souhuAnnaiMsgLst.size(); loopCount++) {
            souhuAnnaiMsgAry[loopCount] = souhuAnnaiMsgLst.get(loopCount).getTyouhyoumsg();
        }

        String[] annaiNaiyouMsgAry = new String[17];
        for (int loopCount = 0; loopCount < annaiNaiyouMsgLst.size(); loopCount++) {
            annaiNaiyouMsgAry[loopCount] = annaiNaiyouMsgLst.get(loopCount).getTyouhyoumsg();
        }

        String[] results = ViewReport.editAdrDisp(LINEMAXLEN,
            pEditSeisankinhurikomiiraisyoBean.getSeikyuusyaInfoBean().getTsinadr1kj(),
            pEditSeisankinhurikomiiraisyoBean.getSeikyuusyaInfoBean().getTsinadr2kj(),
            pEditSeisankinhurikomiiraisyoBean.getSeikyuusyaInfoBean().getTsinadr3kj());
        siSeisansksBean.setIrTsinadr1kj(results[0]);
        siSeisansksBean.setIrTsinadr2kj(results[1]);
        if (results.length > 2) {
            siSeisansksBean.setIrTsinadr3kj(results[2]);
        }

        siSeisansksBean.setIrSyoriYmdzenkaku(ConvertUtil.toZenNumeric(DateFormatUtil.dateKANJINoEx(syoriYmd)));
        siSeisansksBean.setIrUktnmkj(pEditSeisankinhurikomiiraisyoBean.getUktnmkj());
        siSeisansksBean.setIrMsg1(souhuAnnaiMsgAry[0]);
        siSeisansksBean.setIrMsg2(souhuAnnaiMsgAry[1]);
        siSeisansksBean.setIrMsg3(souhuAnnaiMsgAry[2]);
        siSeisansksBean.setIrMsg4(souhuAnnaiMsgAry[3]);
        siSeisansksBean.setIrMsg5(souhuAnnaiMsgAry[4]);
        siSeisansksBean.setIrSyono(pEditSeisankinhurikomiiraisyoBean.getSyono());
        siSeisansksBean.setIrHhknnmkj(pEditSeisankinhurikomiiraisyoBean.getHhknNmkj());
        siSeisansksBean.setIrKykymd(ConvertUtil.toZenNumeric(
            DateFormatUtil.dateKANJINoEx(pEditSeisankinhurikomiiraisyoBean.getKykYmd())));
        siSeisansksBean.setIrSknnkaisiymd(String.valueOf(ConvertUtil.toZenNumeric(
            DateFormatUtil.dateKANJINoEx(pEditSeisankinhurikomiiraisyoBean.getSknnkaisiYmd()))));
        siSeisansksBean.setIrMsg6(annaiNaiyouMsgAry[0]);
        siSeisansksBean.setIrMsg7(annaiNaiyouMsgAry[1]);
        siSeisansksBean.setIrMsg8(annaiNaiyouMsgAry[2]);
        siSeisansksBean.setIrMsg9(annaiNaiyouMsgAry[3]);
        siSeisansksBean.setIrMsg10(annaiNaiyouMsgAry[4]);
        siSeisansksBean.setIrMsg11(annaiNaiyouMsgAry[5]);
        siSeisansksBean.setIrMsg12(annaiNaiyouMsgAry[6]);
        siSeisansksBean.setIrMsg13(annaiNaiyouMsgAry[7]);
        siSeisansksBean.setIrMsg14(annaiNaiyouMsgAry[8]);
        siSeisansksBean.setIrMsg15(annaiNaiyouMsgAry[9]);
        siSeisansksBean.setIrMsg16(annaiNaiyouMsgAry[10]);
        siSeisansksBean.setIrMsg17(annaiNaiyouMsgAry[11]);
        siSeisansksBean.setIrMsg18(annaiNaiyouMsgAry[12]);
        siSeisansksBean.setIrMsg19(annaiNaiyouMsgAry[13]);
        siSeisansksBean.setIrMsg20(annaiNaiyouMsgAry[14]);
        siSeisansksBean.setIrMsg21(annaiNaiyouMsgAry[15]);
        siSeisansksBean.setIrMsg22(annaiNaiyouMsgAry[16]);
        siSeisansksBean.setIrHozonkkn(hozonKknJyohn);
        siSeisansksBean.setIrTsinyno(pEditSeisankinhurikomiiraisyoBean.getSeikyuusyaInfoBean().getTsinyno());
        siSeisansksBean.setIrTsintelno(pEditSeisankinhurikomiiraisyoBean.getSeikyuusyaInfoBean().getTsintelno());
        siSeisansksBean.setIrToritsugisyasyozokunm(pEditSeisankinhurikomiiraisyoBean.getToritsugisyaSosikimei());
        siSeisansksBean.setIrToritsugisyakjncd(pEditSeisankinhurikomiiraisyoBean.getToritsugisyakjncd());
        siSeisansksBean.setIrToritsugisyanm(pEditSeisankinhurikomiiraisyoBean.getToritsugisyaKjnmei());
        siSeisansksBean.setIrTyouhyousakuseiymd(
            DateFormatUtil.dateKANJINoEx(pEditSeisankinhurikomiiraisyoBean.getSiTyouhyouHensyuuCommonBean().getSyoriYmd()));
        siSeisansksBean.setIrShsrtdkdadrhyjumu(shsrtdkdadrhyjumu);
        siSeisansksBean.setIrShsrkinyuuhyjumu(shsrkinyuuhyjumu);
        siSeisansksBean.setIrMensekijiyuuhknknhyjumu(mensekijiyuuhknknhyjumu);
        siSeisansksBean.setIrMensekijiyuukyhknhyjumu(mensekijiyuukyhknhyjumu);
        siSeisansksBean.setIrUkthougkdthyjumu(ukthougkdthyjumu);
        siSeisansksBean.setIrUkthouendthyjumu(ukthouendthyjumu);

        ReportServicesBean reportServicesBean = createReport.createNewReportServiceBean(kinou.getSubSystemId(),
            kinou.getCategoryId(), kinou.getKinouId(), syoruiCd);

        reportServicesBean.setKensakuKeys(pEditSeisankinhurikomiiraisyoBean.getSyono());
        reportServicesBean.setSyoriYmd(syoriYmd);

        reportServicesBean.addParamObjects(siSeisansksBean);

        logger.debug("△ 精算金振込依頼書編集 終了");

        return reportServicesBean;
    }
}
