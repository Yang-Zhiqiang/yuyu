package yuyu.common.sinkeiyaku.skcommon;

import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.util.string.ConvertUtil;

import org.slf4j.Logger;

import yuyu.common.base.format.BizDateFormatUtil;
import yuyu.common.base.format.BizDateFormatter;
import yuyu.common.biz.bzcommon.DateFormatUtil;
import yuyu.common.biz.exception.CommonBizAppException;
import yuyu.common.sinkeiyaku.prereport.SinkeiyakuPreReportRenkeiBean;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_KykKbn;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.classification.C_TsindousiteiKbn;
import yuyu.def.db.entity.AS_Kinou;
import yuyu.def.db.entity.BM_LincKaisyacd;
import yuyu.def.db.entity.HT_MosKihon;
import yuyu.def.db.entity.HT_SkLincSyoukaikekka;
import yuyu.def.db.entity.HT_SkLincTourokuInfo;
import yuyu.def.db.entity.HT_SyoriCTL;
import yuyu.def.sinkeiyaku.bean.report.SkKyknaiyoutrseidoBean;
import yuyu.infr.report.CreateReport;
import yuyu.infr.report.swakreport.ReportServicesBean;

import com.google.common.collect.Lists;

/**
 * 新契約 新契約共通 契約内容登録制度照会票PDF作成
 */
public class EditPdfKyknaiyoutrseidoskhy {

    private static final String LINC_SOUSIN_MOTO_AISYA = "16";

    @Inject
    private static Logger logger;

    @Inject
    private AS_Kinou asKinou;

    @Inject
    private BizDomManager bizDomManager;

    public EditPdfKyknaiyoutrseidoskhy() {
        super();
    }

    public List<String> exec(HT_SyoriCTL pSyoriCTL, String pLincJyusintrRenno, List<Integer> pRennoLst) {

        logger.debug("▽ 契約内容登録制度照会票PDF作成 開始");

        List<String> tyouhyoukeyLst = Lists.newArrayList();

        SinkeiyakuPreReportRenkeiBean sinkeiyakuPreReportRenkeiBean = SWAKInjector.getInstance(SinkeiyakuPreReportRenkeiBean.class);

        if (pSyoriCTL == null) {

            logger.debug("△ 契約内容登録制度照会票PDF作成 終了");

            return tyouhyoukeyLst;
        }

        sinkeiyakuPreReportRenkeiBean.setMosNo(pSyoriCTL.getMosno());
        sinkeiyakuPreReportRenkeiBean.setBzWorkflowInfo(null);
        sinkeiyakuPreReportRenkeiBean.setSyoriComment("");
        sinkeiyakuPreReportRenkeiBean.setTskNm("");

        for (Integer renno : pRennoLst) {

            HT_SkLincSyoukaikekka skLincSyoukaikekka = pSyoriCTL.getSkLincSyoukaikekkaByLincjyusintrrennoRenno(pLincJyusintrRenno, renno);

            if (skLincSyoukaikekka == null) {

                throw new CommonBizAppException("申込番号＝" + pSyoriCTL.getMosno());
            }

            String lincKaisyaNm = "";
            BM_LincKaisyacd lincKaisyacd = bizDomManager.getLincKaisyacd(skLincSyoukaikekka.getLincsousinmotokaisya());

            if (lincKaisyacd != null) {

                lincKaisyaNm = lincKaisyacd.getLinckaisyanm();
            }

            HT_SkLincTourokuInfo skLincTourokuInfo = pSyoriCTL.getSkLincTourokuInfo();

            if (skLincTourokuInfo == null) {

                throw new CommonBizAppException("申込番号＝" + pSyoriCTL.getMosno());
            }

            HT_MosKihon mosKihon = pSyoriCTL.getMosKihon();

            if (mosKihon == null) {

                throw new CommonBizAppException("申込番号＝" + pSyoriCTL.getMosno());
            }

            SkKyknaiyoutrseidoBean skKyknaiyoutrseidoBean = SWAKInjector.getInstance(SkKyknaiyoutrseidoBean.class);

            skKyknaiyoutrseidoBean.setIrTyouhyousakuseiymd(DateFormatUtil.dateKANJI(BizDate.getSysDate()));
            skKyknaiyoutrseidoBean.setIrSyoukaisaki1(lincKaisyaNm + "（"
                + ConvertUtil.toZenAll(skLincSyoukaikekka.getLincsousinmotokaisya(), 0, 0) + "）");
            skKyknaiyoutrseidoBean.setIrSyoukaisaki2("新契約部門");
            skKyknaiyoutrseidoBean.setIrSyoukaisaki3("ＬＩＮＣ事務ご担当者殿");
            skKyknaiyoutrseidoBean.setIrHasinmotokaisya("住友生命（２０）");
            skKyknaiyoutrseidoBean.setIrHasinmotobumon("契約審査室");
            skKyknaiyoutrseidoBean.setIrHasinmotofax("06-6397-1110");
            skKyknaiyoutrseidoBean.setIrLincsyurui(skLincSyoukaikekka.getLincsyoukaisyubetu());
            skKyknaiyoutrseidoBean.setIrSyoukaisakikykkanrino(skLincSyoukaikekka.getLinckykkanrino());
            skKyknaiyoutrseidoBean.setIrHhknnmknlinc(skLincSyoukaikekka.getHhknnmlinckn());
            skKyknaiyoutrseidoBean.setIrSeiymdlinc(BizDateFormatUtil.toFormatedYmd(
                skLincSyoukaikekka.getHhknseiymd(), BizDateFormatter.warekiSymbolCommaYMDFormat));
            skKyknaiyoutrseidoBean.setIrSeibetulinc(skLincSyoukaikekka.getLinchhknseikbn());
            skKyknaiyoutrseidoBean.setIrAdrkn(skLincSyoukaikekka.getHhknadrlinckn30());
            skKyknaiyoutrseidoBean.setIrSyoukaisakykymd("（貴社契約日　    年  月  日）");
            skKyknaiyoutrseidoBean.setIrHhknnmkj(skLincTourokuInfo.getHhknnmkj());
            if (C_TsindousiteiKbn.ARI.eq(mosKihon.getTsindousiteikbn())) {

                skKyknaiyoutrseidoBean.setIrAdrkj(mosKihon.getTsinadr1kj() + mosKihon.getTsinadr2kj()
                    + mosKihon.getTsinadr3kj());
            }
            else {

                skKyknaiyoutrseidoBean.setIrAdrkj(mosKihon.getHhknadr1kj() + mosKihon.getHhknadr2kj()
                    + mosKihon.getHhknadr3kj());
            }

            if (C_KykKbn.KEIHI_BETU.eq(skLincTourokuInfo.getKykkbn())) {

                skKyknaiyoutrseidoBean
                .setIrKyknmhurigana(ConvertUtil.toHanAll(skLincTourokuInfo.getKyknmkn(), 0, 1));
                skKyknaiyoutrseidoBean.setIrKyknmkj(skLincTourokuInfo.getKyknmkj());
            }
            else {
                skKyknaiyoutrseidoBean.setIrKyknmhurigana("");
                skKyknaiyoutrseidoBean.setIrKyknmkj("（被）と同一");
            }

            if (LINC_SOUSIN_MOTO_AISYA.equals(skLincSyoukaikekka.getLincsousinmotokaisya())) {

                skKyknaiyoutrseidoBean.setIrKykymdhyoujiumu("1");
            }
            else {

                skKyknaiyoutrseidoBean.setIrKykymdhyoujiumu("0");
            }

            CreateReport createReport = SWAKInjector.getInstance(CreateReport.class);

            ReportServicesBean reportServicesBean = createReport.createNewReportServiceBean(
                asKinou.getSubSystemId(), asKinou.getCategoryId(), asKinou.getKinouId(),
                C_SyoruiCdKbn.SK_KEIYAKUNAIYOTOROKUSEIDOSYOKAIHYO);

            reportServicesBean.setKensakuKeys(new String[] {pSyoriCTL.getMosno(),
                skLincSyoukaikekka.getLincsousinmotokaisya()});
            reportServicesBean.setSyoriYmd(BizDate.getSysDate());
            reportServicesBean.addParamObjects(C_SyoruiCdKbn.SK_KEIYAKUNAIYOTOROKUSEIDOSYOKAIHYO,
                skKyknaiyoutrseidoBean);

            String reportKey = createReport.execNoCommit(reportServicesBean);

            tyouhyoukeyLst.add(reportKey);
        }

        logger.debug("△ 契約内容登録制度照会票PDF作成 終了");

        return tyouhyoukeyLst;
    }
}
