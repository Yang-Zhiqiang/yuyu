package yuyu.common.sinkeiyaku.skcommon;

import javax.inject.Inject;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import yuyu.common.biz.bzcommon.GetBankSitenNm;
import yuyu.common.biz.exception.CommonBizAppException;
import yuyu.common.sinkeiyaku.moschk.MosnaiCheckParam;
import yuyu.common.sinkeiyaku.prereport.SinkeiyakuPreReportRenkeiBean;
import yuyu.def.biz.bean.report.BzDairitenAtesakiBean;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_KouzasyuruiKbn;
import yuyu.def.classification.C_KykKbn;
import yuyu.def.classification.C_KzkykdouKbn;
import yuyu.def.classification.C_SkeijimuKbn;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.HT_KouzaJyouhou;
import yuyu.def.db.entity.HT_MosDairiten;
import yuyu.def.db.entity.HT_MosKihon;
import yuyu.def.db.entity.HT_SyoriCTL;
import yuyu.def.sinkeiyaku.bean.report.SkTrksseikyuBean;
import yuyu.infr.report.CreateReport;
import yuyu.infr.report.swakreport.ReportServicesBean;

/**
 * 新契約 新契約共通 取消請求書PDF作成
 */
public class EditPdfTrksseikyu {

    @Inject
    private CreateReport createReport;

    @Inject
    private GetSyoruicd getSyoruicd;

    @Inject
    private BzDairitenAtesakiBean bzDairitenAtesakiBean;

    @Inject
    private SkTrksseikyuBean skTrksseikyuBean;

    @Inject
    private EditDairitenAtesaki editDairitenAtesaki;

    @Inject
    private GetBankSitenNm getBankSitenNm;

    public EditPdfTrksseikyu() {
        super();
    }

    public String exec(MosnaiCheckParam pParam, C_KouzasyuruiKbn pKouzasyuruiKbn) {

        HT_MosDairiten mosDairiten = null;
        String kynmKj = null;
        String reportKey = null;
        C_SkeijimuKbn skeiJimuKbn = null;
        BizDate syoribi = null;
        EditDairitenAtesakiBean editDairitenAtesakiBean = null;

        HT_SyoriCTL syoriCTL = pParam.getDataSyoriControl();
        String mosNo = syoriCTL.getMosno();
        HT_MosKihon mosKihon = syoriCTL.getMosKihon();
        C_UmuKbn nyknnrkumu = syoriCTL.getNyknnrkumu();

        String bankNmKj = "";
        String bankCd = "";
        String sitenNmKj = "";
        String sitenCd = "";
        String kzmeigiNmKn = "";
        C_UmuKbn kznrkUmu = syoriCTL.getKznrkumu();
        HT_KouzaJyouhou kouzaJyouhou = syoriCTL.getKouzaJyouhou();

        SinkeiyakuPreReportRenkeiBean sinkeiyakuPreReportRenkeiBean =
            SWAKInjector.getInstance(SinkeiyakuPreReportRenkeiBean.class);

        sinkeiyakuPreReportRenkeiBean.setMosNo(syoriCTL.getMosno());

        mosDairiten = syoriCTL.getMosDairitenByRenno(1);

        if (mosDairiten == null){
            throw new CommonBizAppException("申込番号=" + mosNo);
        }

        if (C_KykKbn.KEIHI_DOUITU.eq(mosKihon.getKykkbn())) {

            kynmKj = mosKihon.getHhknnmkj();
        }

        else {

            kynmKj = mosKihon.getKyknmkj();
        }

        syoribi = pParam.getSysDate();

        C_KouzasyuruiKbn kouzasyuruiKbn = pKouzasyuruiKbn;

        editDairitenAtesakiBean = SWAKInjector.getInstance(EditDairitenAtesakiBean.class);

        editDairitenAtesakiBean.setSyoruiCdKbn(getSyoruicd.getSyoruicd_Trksseikyu_souhu());

        editDairitenAtesakiBean.setMosDairiten(mosDairiten);

        editDairitenAtesakiBean.setHassouYmd(syoribi);

        bzDairitenAtesakiBean = editDairitenAtesaki.exec(editDairitenAtesakiBean);

        skeiJimuKbn = bzDairitenAtesakiBean.getIrSkeijimukbn();

        if (C_UmuKbn.ARI.eq(syoriCTL.getKznrkumu())) {

            bankCd = kouzaJyouhou.getBankcd();
            sitenCd = kouzaJyouhou.getSitencd();

            getBankSitenNm.exec(bankCd, sitenCd);

            if (C_ErrorKbn.OK.eq(getBankSitenNm.getErrorKbn())) {

                bankNmKj = getBankSitenNm.getBankNmKj();
                sitenNmKj = getBankSitenNm.getSitenNmKj();

                if (C_KzkykdouKbn.DOUITU.eq(kouzaJyouhou.getKzkykdoukbn())) {

                    if (C_KykKbn.KEIHI_DOUITU.eq(mosKihon.getKykkbn())) {

                        kzmeigiNmKn = mosKihon.getHhknnmkn();
                    }
                    else {

                        kzmeigiNmKn = mosKihon.getKyknmkn();
                    }
                }
                else {

                    kzmeigiNmKn = kouzaJyouhou.getKzmeiginmkn();
                }
            }
            else {

                kznrkUmu = C_UmuKbn.NONE;
            }
        }


        skTrksseikyuBean.setIrMosno(mosNo);
        skTrksseikyuBean.setIrKyknm(kynmKj);
        skTrksseikyuBean.setIrSkeijimukbn(skeiJimuKbn);
        skTrksseikyuBean.setIrKouzasyuruikbn(kouzasyuruiKbn);
        skTrksseikyuBean.setIrNyknnrkumu(nyknnrkumu);
        skTrksseikyuBean.setIrKznrkumu(kznrkUmu);
        skTrksseikyuBean.setIrBanknmkj(bankNmKj);
        skTrksseikyuBean.setIrSitennmkj(sitenNmKj);
        skTrksseikyuBean.setIrKzmeiginmkn(kzmeigiNmKn);

        C_SyoruiCdKbn[] syoruiCdKbns = getSyoruicd.getSyoruicd_Trksseikyu_set();
        ReportServicesBean reportServicesBean = createReport.createNewReportServiceBean (
            ISkCommonKoumoku.SUBSYSTEMID_SINKEIYAKU,
            pParam.getCategoryID(),
            pParam.getKinouID(),
            syoruiCdKbns);
        reportServicesBean.setKensakuKeys(skeiJimuKbn.toString(), mosDairiten.getTratkiagcd(), mosNo);

        reportServicesBean.setSyoriYmd(syoribi);

        if (!C_SyoruiCdKbn.BLNK.eq(getSyoruicd.getSyoruicd_Trksseikyu_souhu())) {
            reportServicesBean.addParamObjects(getSyoruicd.getSyoruicd_Trksseikyu_souhu(), bzDairitenAtesakiBean);
        }

        reportServicesBean.addParamObjects(getSyoruicd.getSyoruicd_Trksseikyu(), skTrksseikyuBean);

        reportServicesBean.setSyoruiCdKbnIdx(getSyoruicd.getSyoruicd_Trksseikyu_idx());

        reportKey = createReport.execNoCommit(reportServicesBean);
        return reportKey;
    }
}
