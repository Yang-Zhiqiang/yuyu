package yuyu.common.sinkeiyaku.skcommon;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.number.BizNumber;

import org.slf4j.Logger;

import yuyu.common.biz.bzcommon.BizUtil;
import yuyu.common.biz.bzcommon.DateFormatUtil;
import yuyu.common.sinkeiyaku.moschk.MosnaiCheckParam;
import yuyu.common.sinkeiyaku.prereport.SinkeiyakuPreReportRenkeiBean;
import yuyu.def.classification.C_KykKbn;
import yuyu.def.classification.C_Kykkaksyrui;
import yuyu.def.classification.C_SkeijimuKbn;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.classification.C_TsindousiteiKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.HT_KykKak;
import yuyu.def.db.entity.HT_MosKihon;
import yuyu.def.db.entity.HT_SyoriCTL;
import yuyu.def.sinkeiyaku.bean.report.SkKykKakIraisyoBean;
import yuyu.infr.report.CreateReport;
import yuyu.infr.report.swakreport.ReportServicesBean;

/**
 * 新契約 新契約共通 契約確認依頼書PDF作成
 */
public class EditPdfKykKakuninIraisyo {

    private static final int MAXLENGTH_MSG = 40;

    private static final int MAXLINECNT_MSG = 10;

    private static final String LINE_BREAK = "\n";

    @Inject
    private static Logger logger;

    @Inject
    private EditTblAtukaisya editTblAtukaisya;

    @Inject
    private GetSyoruicd getSyoruicd;

    @Inject
    private SkKykKakIraisyoBean skKykKakIraisyoBean;

    @Inject
    private CreateReport createReport;

    public EditPdfKykKakuninIraisyo() {
        super();
    }

    public void exec(MosnaiCheckParam pMp, HT_KykKak pKykKak) {

        if (logger.isDebugEnabled()) {
            logger.debug("▽ 契約確認依頼書PDF作成 開始");
        }

        HT_SyoriCTL syoriCTL = pMp.getDataSyoriControl();
        String mosNo = syoriCTL.getMosno();
        C_UmuKbn mosNrkUmuKbn = syoriCTL.getMosnrkumu();

        HT_MosKihon     mosKihon         = null;
        C_KykKbn        kykKbn           = null;
        C_TsindousiteiKbn   tusinDouKbn  = null;
        String          kykNmKJ          = null;
        String          kykNmKN          = null;
        String          hhknYubuNo       = null;
        String          hhknAdd1Knj      = null;
        String          hhknAdd2Knj      = null;
        String          hhknAdd3Knj      = null;
        String          hhknTelNo        = null;
        String          khykKakIRaiYmd   = null;
        String          kykKakKanytYmd   = null;
        List<Map<String,String>>    atukaisyaLst = null;
        Map<String,String>          atukaisyaMp  = null;
        C_SkeijimuKbn   skeijimukbn      = null;

        if (logger.isDebugEnabled()) {
            logger.debug("｜ 申込番号 = " + mosNo);
        }

        SinkeiyakuPreReportRenkeiBean sinkeiyakuPreReportRenkeiBean =
            SWAKInjector.getInstance(SinkeiyakuPreReportRenkeiBean.class);

        sinkeiyakuPreReportRenkeiBean.setMosNo(syoriCTL.getMosno());

        skeijimukbn = syoriCTL.getSkeijimukbn();

        if (mosNrkUmuKbn.eq(C_UmuKbn.ARI)) {
            mosKihon = syoriCTL.getMosKihon();

            kykKbn = mosKihon.getKykkbn();

            if (kykKbn.eq(C_KykKbn.KEIHI_DOUITU)) {
                kykNmKJ = mosKihon.getHhknnmkj();
                kykNmKN = mosKihon.getHhknnmkn();
            }
            else {
                kykNmKJ = mosKihon.getKyknmkj();
                kykNmKN = mosKihon.getKyknmkn();
            }

            tusinDouKbn = mosKihon.getTsindousiteikbn();

            if (tusinDouKbn.eq(C_TsindousiteiKbn.BLNK)) {
                hhknYubuNo = mosKihon.getHhknyno();
                hhknAdd1Knj = mosKihon.getHhknadr1kj();
                hhknAdd2Knj = mosKihon.getHhknadr2kj();
                hhknAdd3Knj = mosKihon.getHhknadr3kj();
                hhknTelNo = mosKihon.getHhkntelno();
            }
            else {
                hhknYubuNo = mosKihon.getTsinyno();
                hhknAdd1Knj = mosKihon.getTsinadr1kj();
                hhknAdd2Knj = mosKihon.getTsinadr2kj();
                hhknAdd3Knj = mosKihon.getTsinadr3kj();
                hhknTelNo = mosKihon.getTsintelno();
            }
        }

        BizDate kunIraiYmd = pKykKak.getKykkakiraiymd();

        khykKakIRaiYmd = DateFormatUtil.dateKANJISeirekiNoZero(kunIraiYmd);

        BizDate kunKanYoteiYmd = pKykKak.getKykkakkanytymd();

        if (kunKanYoteiYmd != null) {
            kykKakKanytYmd = DateFormatUtil.dateKANJISeirekiNoZero(kunKanYoteiYmd);
        }
        else {
            kykKakKanytYmd = "";
        }

        atukaisyaLst = editTblAtukaisya.exec(pMp);
        atukaisyaMp = atukaisyaLst.get(0);

        C_Kykkaksyrui kykKakSyrui = pKykKak.getKykkaksyrui();

        skKykKakIraisyoBean.setIrKykkaksyrui(kykKakSyrui.getContent());

        skKykKakIraisyoBean.setIrKykkakiraiymd(khykKakIRaiYmd);

        BizNumber renNo = BizNumber.valueOf(pKykKak.getRenno());
        skKykKakIraisyoBean.setIrKykkakiraino(renNo);

        skKykKakIraisyoBean.setIrKykkakkanytymd(kykKakKanytYmd);

        skKykKakIraisyoBean.setIrTratkiagcd(atukaisyaMp.get(EditTblAtukaisya.ATUKAISYAJHKEY_TRATKIAGCD));

        skKykKakIraisyoBean.setIrTratkiagnm(atukaisyaMp.get(EditTblAtukaisya.ATUKAISYAJHKEY_TRATKIAGNM));

        skKykKakIraisyoBean.setIrMosno(mosNo);

        if (mosNrkUmuKbn.eq(C_UmuKbn.ARI)) {
            skKykKakIraisyoBean.setIrKyknmkj(kykNmKJ);
            skKykKakIraisyoBean.setIrKyknmkn(kykNmKN);
            skKykKakIraisyoBean.setIrHhknyno(changeFormatYubinNo(hhknYubuNo));
            skKykKakIraisyoBean.setIrHhknadr1kj(hhknAdd1Knj);
            skKykKakIraisyoBean.setIrHhknadr2kj(hhknAdd2Knj);
            skKykKakIraisyoBean.setIrHhknadr3kj(hhknAdd3Knj);
            skKykKakIraisyoBean.setIrHhkntelno(hhknTelNo);
            setKykKakIraisyoBean_Mos(skKykKakIraisyoBean, mosKihon);

        }

        String kykKakuninMsg = array2Str(pMp.getListKykKakuninMsg());
        String[] kykKakuninMsgs = getSeparatorMsgs(kykKakuninMsg, MAXLINECNT_MSG, MAXLENGTH_MSG);
        skKykKakIraisyoBean.setIrSyousaimsg1(kykKakuninMsgs[0]);
        skKykKakIraisyoBean.setIrSyousaimsg2(kykKakuninMsgs[1]);
        skKykKakIraisyoBean.setIrSyousaimsg3(kykKakuninMsgs[2]);
        skKykKakIraisyoBean.setIrSyousaimsg4(kykKakuninMsgs[3]);
        skKykKakIraisyoBean.setIrSyousaimsg5(kykKakuninMsgs[4]);
        skKykKakIraisyoBean.setIrSyousaimsg6(kykKakuninMsgs[5]);
        skKykKakIraisyoBean.setIrSyousaimsg7(kykKakuninMsgs[6]);
        skKykKakIraisyoBean.setIrSyousaimsg8(kykKakuninMsgs[7]);
        skKykKakIraisyoBean.setIrSyousaimsg9(kykKakuninMsgs[8]);
        skKykKakIraisyoBean.setIrSyousaimsg10(kykKakuninMsgs[9]);

        String kykKakComment = pKykKak.getKykkakcomment();
        skKykKakIraisyoBean.setIrKykkakcomment(kykKakComment);

        C_SyoruiCdKbn syoruiCdKbn = getSyoruicd.getSyoruicd_Kykkakkuniniraisyo();

        ReportServicesBean servicesBean = null;

        if (!C_SyoruiCdKbn.BLNK.eq(syoruiCdKbn)) {

            servicesBean = createReport.createNewReportServiceBean(
                ISkCommonKoumoku.SUBSYSTEMID_SINKEIYAKU,
                pMp.getCategoryID(),
                pMp.getKinouID(),
                syoruiCdKbn);
        }

        servicesBean.setKensakuKeys(new String[] { skeijimukbn.toString(), mosNo });
        servicesBean.setSyoriYmd(pMp.getSysDate());
        servicesBean.addParamObjects(skKykKakIraisyoBean);

        createReport.execNoCommit(servicesBean);

        if (logger.isDebugEnabled()) {
            logger.debug("△ 契約確認依頼書PDF作成 終了");
        }
    }

    private void setKykKakIraisyoBean_Mos(SkKykKakIraisyoBean pSkKykKakIraisyoBean, HT_MosKihon pMosKihon) {

        pSkKykKakIraisyoBean.setIrTsinyno(changeFormatYubinNo(pMosKihon.getTsinyno()));

        pSkKykKakIraisyoBean.setIrTsinadr1kj(pMosKihon.getTsinadr1kj());

        pSkKykKakIraisyoBean.setIrTsinadr2kj(pMosKihon.getTsinadr2kj());

        pSkKykKakIraisyoBean.setIrTsinadr3kj(pMosKihon.getTsinadr3kj());

        pSkKykKakIraisyoBean.setIrTsintelno(pMosKihon.getTsintelno());

        pSkKykKakIraisyoBean.setIrHhknnmkj(pMosKihon.getHhknnmkj());

        pSkKykKakIraisyoBean.setIrHhknnmkn(pMosKihon.getHhknnmkn());
    }

    private String changeFormatYubinNo(String pYubinNo) {
        if (pYubinNo != null && pYubinNo.length() > 3) {
            return pYubinNo.substring(0, 3) + "-" + pYubinNo.substring(3);
        }
        return "";
    }

    private String array2Str(List<String> pAl) {
        StringBuffer retValue = new StringBuffer();
        for (int loopCount = 1; loopCount <= pAl.size(); loopCount++) {
            retValue.append(String.valueOf(pAl.get(loopCount - 1)));
            if (loopCount < pAl.size()) {
                retValue.append(LINE_BREAK);
            }
        }
        if (retValue.length() == 0) {
            return "";
        }
        return retValue.toString();

    }

    private String[] getSeparatorMsgs(String pSyousaiMsg, int pMaxLineCnt, int pMaxLength) {
        String[] splits = null;
        String[] yousaiMsgs = null;
        int msgLineCnt = 0;

        yousaiMsgs = new String[pMaxLineCnt];
        for (int cnt = 0; cnt < pMaxLineCnt; cnt++) {
            yousaiMsgs[cnt] = "";
        }
        if (pSyousaiMsg.length() != 0) {

            splits = BizUtil.splitLineSeparator(pSyousaiMsg, pMaxLength, true);

            if (splits.length > pMaxLineCnt) {
                msgLineCnt = pMaxLineCnt;
            } else {
                msgLineCnt = splits.length;
            }
            for (int cnt = 0; cnt < msgLineCnt; cnt++) {
                yousaiMsgs[cnt] = splits[cnt];
            }
        }
        return yousaiMsgs;
    }
}