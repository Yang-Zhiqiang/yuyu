package yuyu.common.sinkeiyaku.skcommon;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;

import org.slf4j.Logger;

import yuyu.common.biz.bzcommon.GetBankSitenNm;
import yuyu.common.biz.exception.CommonBizAppException;
import yuyu.common.sinkeiyaku.moschk.MosnaiCheckParam;
import yuyu.common.sinkeiyaku.prereport.SinkeiyakuPreReportRenkeiBean;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_Ketkekkacd;
import yuyu.def.classification.C_KouzasyuruiKbn;
import yuyu.def.classification.C_KykKbn;
import yuyu.def.classification.C_KzkykdouKbn;
import yuyu.def.classification.C_SkeijimuKbn;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.HT_KouzaJyouhou;
import yuyu.def.db.entity.HT_MosDairiten;
import yuyu.def.db.entity.HT_MosKihon;
import yuyu.def.db.entity.HT_SyoriCTL;
import yuyu.def.sinkeiyaku.bean.report.SkHenkiniraisyoBean;
import yuyu.infr.report.CreateReport;
import yuyu.infr.report.swakreport.ReportServicesBean;

/**
 * 新契約 新契約共通 返金依頼書PDF作成
 */
public class EditPdfHenkinirai {

    @Inject
    private static Logger logger;

    @Inject
    private SkHenkiniraisyoBean skHenkiniraisyoBean;

    @Inject
    private CreateReport createReport;

    @Inject
    private GetBankSitenNm getBankSitenNm;

    public SkHenkiniraisyoBean getSkHenkiniraisyoBean() {
        return skHenkiniraisyoBean;
    }

    public EditPdfHenkinirai() {
        super();
    }

    public String exec(MosnaiCheckParam pMP, C_KouzasyuruiKbn pKouzasyuruiKbn, C_Ketkekkacd pKetkekkacd) {

        String reportKey = "";
        HT_MosDairiten mosDairiten;
        C_SkeijimuKbn skeiJimuKbn = null;
        ReportServicesBean reportServicesBean = null;
        List<C_SyoruiCdKbn>  syoruicdKbnList = new ArrayList<>();
        int syoruicdKbnIndex = 0;

        if (logger.isDebugEnabled()) {
            logger.debug("▽ 返金依頼書PDF作成 開始");
        }

        HT_SyoriCTL syoriCTL = pMP.getDataSyoriControl();
        String mosNo = syoriCTL.getMosno();

        BizDate sysDate = pMP.getSysDate();

        SinkeiyakuPreReportRenkeiBean sinkeiyakuPreReportRenkeiBean =
            SWAKInjector.getInstance(SinkeiyakuPreReportRenkeiBean.class);

        sinkeiyakuPreReportRenkeiBean.setMosNo(syoriCTL.getMosno());

        mosDairiten = syoriCTL.getMosDairitenByRenno(1);

        if (mosDairiten == null) {
            throw new CommonBizAppException("申込番号=" + mosNo);
        }

        skeiJimuKbn = syoriCTL.getSkeijimukbn();

        C_Ketkekkacd ketkekkacd = pKetkekkacd;
        C_KouzasyuruiKbn kouzasyuruiKbn = pKouzasyuruiKbn;

        editHenkiniraisyo(syoriCTL, mosNo, skeiJimuKbn, ketkekkacd, kouzasyuruiKbn, null);


        syoruicdKbnList.add(C_SyoruiCdKbn. SK_HENKINIRAISYO);

        syoruicdKbnIndex = EditPdfHenkiniraiConstants.SYORUICDKBN_INDEX;


        reportServicesBean = createReport.createNewReportServiceBean(
            ISkCommonKoumoku.SUBSYSTEMID_SINKEIYAKU,
            pMP.getCategoryID(),
            pMP.getKinouID(),
            syoruicdKbnList.toArray(new C_SyoruiCdKbn[0]));

        reportServicesBean.setKensakuKeys(new String[] { skeiJimuKbn.toString(), mosDairiten.getOyadrtencd(), mosNo });

        reportServicesBean.setSyoriYmd(sysDate);

        for (C_SyoruiCdKbn syoruicdKbn : syoruicdKbnList) {

            if (C_SyoruiCdKbn.SK_HENKINIRAISYO.eq(syoruicdKbn)) {

                reportServicesBean.addParamObjects(C_SyoruiCdKbn.SK_HENKINIRAISYO, skHenkiniraisyoBean);
            }
        }

        reportServicesBean.setSyoruiCdKbnIdx(syoruicdKbnIndex);

        reportKey = createReport.execNoCommit(reportServicesBean);

        if (logger.isDebugEnabled()) {
            logger.debug("△ 返金依頼書PDF作成 終了");
        }

        return reportKey;
    }

    public void editHenkiniraisyo(HT_SyoriCTL pSyoriCTL,
        String pMosno,
        C_SkeijimuKbn pSkeijimuKbn,
        C_Ketkekkacd pKetkekkacd,
        C_KouzasyuruiKbn pKouzasyuruiKbn,
        C_Tuukasyu pTuukasyu) {

        String banknmKj = "";
        String bankCd = "";
        String sitennmKj = "";
        String sitenCd = "";
        String kzmeiginmKn = "";
        C_UmuKbn kznrkUmu = pSyoriCTL.getKznrkumu();
        HT_KouzaJyouhou kouzaJyouhou = pSyoriCTL.getKouzaJyouhou();
        HT_MosKihon mosKihon = pSyoriCTL.getMosKihon();

        if (C_UmuKbn.ARI.eq(kznrkUmu)) {

            bankCd = kouzaJyouhou.getBankcd();
            sitenCd = kouzaJyouhou.getSitencd();

            getBankSitenNm.exec(bankCd, sitenCd);

            if (C_ErrorKbn.OK.eq(getBankSitenNm.getErrorKbn())) {

                banknmKj = getBankSitenNm.getBankNmKj();
                sitennmKj = getBankSitenNm.getSitenNmKj();

                if (C_KzkykdouKbn.DOUITU.eq(kouzaJyouhou.getKzkykdoukbn())) {

                    if (C_KykKbn.KEIHI_DOUITU.eq(mosKihon.getKykkbn())) {

                        kzmeiginmKn = mosKihon.getHhknnmkn();
                    }
                    else {

                        kzmeiginmKn = mosKihon.getKyknmkn();
                    }
                }
                else {

                    kzmeiginmKn = kouzaJyouhou.getKzmeiginmkn();
                }
            }
            else {

                kznrkUmu = C_UmuKbn.NONE;
            }
        }

        skHenkiniraisyoBean.setIrMosno(pMosno);
        skHenkiniraisyoBean.setIrSkeijimukbn(pSkeijimuKbn);
        skHenkiniraisyoBean.setIrKetkekkacd(pKetkekkacd);
        skHenkiniraisyoBean.setIrKouzasyuruikbn(C_KouzasyuruiKbn.BLNK);
        skHenkiniraisyoBean.setIrKznrkumu(kznrkUmu);
        skHenkiniraisyoBean.setIrBanknmkj(banknmKj);
        skHenkiniraisyoBean.setIrSitennmkj(sitennmKj);
        skHenkiniraisyoBean.setIrKzmeiginmkn(kzmeiginmKn);

        if (pKouzasyuruiKbn != null) {

            skHenkiniraisyoBean.setIrKouzasyuruikbn(pKouzasyuruiKbn);
        }
        else {

            if (pTuukasyu != null && !C_Tuukasyu.BLNK.eq(pTuukasyu)) {

                if (C_Tuukasyu.JPY.eq(pTuukasyu)) {

                    skHenkiniraisyoBean.setIrKouzasyuruikbn(C_KouzasyuruiKbn.YENKOUZA);
                }
                else {

                    skHenkiniraisyoBean.setIrKouzasyuruikbn(C_KouzasyuruiKbn.GAIKAKOUZA);
                }
            }
        }
    }
}
