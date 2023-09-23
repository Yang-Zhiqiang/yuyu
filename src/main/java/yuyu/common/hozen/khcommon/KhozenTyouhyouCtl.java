package yuyu.common.hozen.khcommon;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import yuyu.common.biz.bzcommon.BizUtil;
import yuyu.common.biz.bzcommon.DateFormatUtil;
import yuyu.common.biz.exception.CommonBizAppException;
import yuyu.def.classification.C_HassouKbn;
import yuyu.def.classification.C_Kaiyakujiyuu;
import yuyu.def.classification.C_KktyuitaKbn;
import yuyu.def.classification.C_KoujyosyoumeisakuseisyoriKbn;
import yuyu.def.classification.C_Meigihnkjiyuu;
import yuyu.def.classification.C_SinsaihkKbn;
import yuyu.def.classification.C_SinsakuseiKbn;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.classification.C_SyoukensaihkKbn;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.classification.C_TantouCdKbn;
import yuyu.def.classification.C_TetudukisyuKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_YouhiKbn;
import yuyu.def.db.entity.IT_HhknSya;
import yuyu.def.db.entity.IT_KhHasseijiKazeiRireki;
import yuyu.def.db.entity.IT_KhShrRireki;
import yuyu.def.db.entity.IT_KhTtdkTyuui;
import yuyu.def.db.entity.IT_KoujyoSym;
import yuyu.def.db.entity.IT_KykDairiten;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.IT_KykSonotaTkyk;
import yuyu.def.db.entity.IT_KykSya;
import yuyu.def.db.entity.IT_KykSyouhn;
import yuyu.def.db.entity.IT_KykUkt;
import yuyu.def.db.entity.IT_NyknJissekiRireki;
import yuyu.def.db.entity.IT_SyouhnTokujou;
import yuyu.def.db.entity.IT_TtdkKan;
import yuyu.def.hozen.bean.report.KhDaihyousennintodokeBean;
import yuyu.def.hozen.bean.report.KhJyudkgmbrtkkykgyBean;
import yuyu.def.hozen.bean.report.KhNkshrtkykkykgaiyouBean;
import yuyu.def.hozen.bean.report.KhTrhkkakkirokusyoBean;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.infr.report.CreateReport;
import yuyu.infr.report.swakreport.ReportServicesBean;

/**
 * 契約保全 契約保全共通 契約保全帳票TBL編集コントロール
 */
public class KhozenTyouhyouCtl {

    private static final int TYOUHYOUSYURUI_HOKENSYOUKEN = 1;

    private static final int TYOUHYOUSYURUI_KOUJYOSYOUMEISYO = 2;

    private static final int TYOUHYOUSYURUI_TTDKKANRYOU = 3;

    private static final int TYOUHYOUSYURUI_SEIKYUUSYO = 4;

    private static final int TYOUHYOUSYURUI_SOUHUANNAI = 5;

    private static final int TYOUHYOUSYURUI_JIMURENRAKUHYOU = 7;

    private static final int TYOUHYOUSYURUI_MISSLIST = 8;

    private static final int TYOUHYOUSYURUI_MINYUUIRIRANHYOU = 9;

    private static final int TYOUHYOUSYURUI_SIKKOUIRIRANHYOU = 10;

    private static final int TYOUHYOUSYURUI_HANDKARIKANJYOU = 11;

    private static final int TYOUHYOUSYURUI_TYUUIKANKIJYOUHOU = 15;

    private static final int TYOUHYOUSYURUI_DAIHYOUSENNIN = 16;

    private static final int TYOUHYOUSYURUI_TORIHIKIKAKUNINKIROKUSYO = 17;

    private static final int TYOUHYOUSYURUI_KEIYAKUGAIYOU = 18;

    private static final int TYOUHYOUSYURUI_TYUUIKANKIJYOUHOU1 = 19;

    private C_UmuKbn pdfSakuseiUmu;

    private String tyouhyouKey;

    private KhozenCommonParam cmnPrm;

    private String syoNo;

    private C_YouhiKbn pdfOutYhKbn;

    private C_HassouKbn hassouKbn;

    private EditKoujyoSyoumeiParam koujyoPrm;

    private EditTtdkKanryouParam ttdkPrm;

    private EditSeikyuusyoParam seikyuuPrm;

    private EditSouhuannaiParam souhuPrm;

    private EditJimuRenrakuhyouParam jimuPrm;

    private List<EditKhMisslstParam> misslstPrmLst;

    private EditHokenSyoukenParam editHokenSyoukenParam;

    private ReportServicesBean[] reportServicesBeans;

    private BizDate syoriYmd;

    private BizDate sysDate;

    private IT_KykKihon kykKihon;

    private List<IT_KykSyouhn> kykSyouhSyuLst;

    private List<IT_KykSyouhn> kykSyouhTkLst;

    private IT_KykSya kykSya;

    private IT_HhknSya hhknSya;

    private IT_KykUkt kykUktSibouHenkan;

    private IT_KykUkt kykUktSiteiDairi;

    private C_SinsaihkKbn sinsaihKbn = C_SinsaihkKbn.SAI;

    private C_TetudukisyuKbn tetudukisyuKbn;

    private IT_SyouhnTokujou syouhnTokujouSyu;

    private List<IT_KykDairiten> kykDairitenLst;

    private IT_KhTtdkTyuui khTtdkTyuui;

    private List<IT_KykUkt> kykUktSibouhokenLst;

    private IT_KykSonotaTkyk kykSonotaTkyk;

    private IT_KykUkt kykUkt;

    private IT_KoujyoSym koujyoSym;

    private List<IT_TtdkKan> ttdkKansDoujitu;

    private C_YouhiKbn qrCodeYouhiKbn;

    private String qrCode;

    @Inject
    private CreateReport createReport;

    @Inject
    private EditSyoukenTbl editSyoukenTbl;

    @Inject
    private EditKhMisslstTbl editKhMisslstTbl;

    @Inject
    private EditJimuRenrakuhyouTbl editJimuRenrakuhyouTbl;

    @Inject
    private EditSouhuannaiTbl editSouhuannaiTbl;

    @Inject
    private EditSeikyuusyoTbl editSeikyuusyoTbl;

    @Inject
    private EditTtdkKanryouTbl editTtdkKanryouTbl;

    @Inject
    private EditKoujyoSyoumeiTbl editKoujyoSyoumeiTbl;

    @Inject
    private EditKhTyokusouTtdkKanryouTbl editKhTyokusouTtdkKanryouTbl;

    @Inject
    private HozenDomManager hozenDomManager;

    public KhozenTyouhyouCtl() {
        super();
    }

    public C_UmuKbn getTyouhyoumuKbn() {
        return pdfSakuseiUmu;
    }

    public String getTyouhyouKey() {
        return tyouhyouKey;
    }

    public String getQrCode() {
        return qrCode;
    }

    public void setEditKoujyoSyoumeiParam(EditKoujyoSyoumeiParam pKoujyoPrm) {
        koujyoPrm = pKoujyoPrm;
    }

    public void setEditTtdkKanryouParam(EditTtdkKanryouParam pTtdkPrm) {
        ttdkPrm = pTtdkPrm;
    }

    public void setEditSeikyuusyoParam(EditSeikyuusyoParam pSeikyuuPrm) {
        seikyuuPrm = pSeikyuuPrm;
    }

    public void setEditSouhuannaiParam(EditSouhuannaiParam pSouhuPrm) {
        souhuPrm = pSouhuPrm;
    }

    public void setEditJimuRenrakuhyouParam(EditJimuRenrakuhyouParam pJimuPrm) {
        jimuPrm = pJimuPrm;
    }

    public void setEditKkMisslstParam(List<EditKhMisslstParam> pMisslstPrmList) {
        misslstPrmLst = pMisslstPrmList;
    }

    public void setEditHokenSyoukenParam(EditHokenSyoukenParam pEditHokenSyoukenParam) {
        editHokenSyoukenParam = pEditHokenSyoukenParam;
    }

    public void setReportServicesBean(ReportServicesBean pReportServicesBean) {
        reportServicesBeans = new ReportServicesBean[] { pReportServicesBean };
    }

    public void setReportServicesBean(ReportServicesBean[] pReportServicesBeans) {
        reportServicesBeans = pReportServicesBeans;
    }

    public void setSyoriYmd(BizDate pSyoriYmd) {
        syoriYmd = pSyoriYmd;
    }

    public void setSinsaihkkbn(C_SinsaihkKbn pSinsaihkkbn) {
        sinsaihKbn = pSinsaihkkbn;
    }

    public void setTetudukisyukbn(C_TetudukisyuKbn pTetudukisyukbn) {
        tetudukisyuKbn = pTetudukisyukbn;
    }

    public void setHassoukbn(C_HassouKbn pHassouKbn) {
        hassouKbn = pHassouKbn;
    }

    public void setQrCodeYouhiKbn(C_YouhiKbn pQrCodeYouhiKbn) {
        qrCodeYouhiKbn = pQrCodeYouhiKbn;
    }

    public void createTyouhyouTBL(KhozenCommonParam pKhcParm,
        String pSyoNo,
        C_SyoruiCdKbn[] pSyoruiCds,
        C_YouhiKbn pPdfOutYhKbn) {

        pdfSakuseiUmu = C_UmuKbn.NONE;
        tyouhyouKey = "";
        qrCode = "";
        cmnPrm = pKhcParm;
        syoNo = pSyoNo;
        pdfOutYhKbn = pPdfOutYhKbn;
        sysDate = BizDate.getSysDate();

        if (syoriYmd == null) {
            syoriYmd = sysDate;
        }

        if (!BizUtil.isBlank(syoNo)) {
            getData();
        }

        List<ReportServicesBean> reportServicesBeanList = new ArrayList<>();

        for (int count = 0; count < pSyoruiCds.length; count++) {
            int tyouhyouSyurui = getTyouhyouSyurui(pSyoruiCds[count]);

            switch (tyouhyouSyurui) {
                case TYOUHYOUSYURUI_HOKENSYOUKEN:
                    editHokenSyouken();
                    break;

                case TYOUHYOUSYURUI_KOUJYOSYOUMEISYO:
                    editKoujyoSyoumei(reportServicesBeanList);
                    break;

                case TYOUHYOUSYURUI_TTDKKANRYOU:
                    editTtdkKanryou(pSyoruiCds[count], reportServicesBeanList);
                    break;

                case TYOUHYOUSYURUI_SEIKYUUSYO:
                    editSeikyuusyo(pSyoruiCds[count], reportServicesBeanList);
                    break;

                case TYOUHYOUSYURUI_SOUHUANNAI:
                    editSouhuannai(pSyoruiCds[count], reportServicesBeanList);
                    break;

                case TYOUHYOUSYURUI_JIMURENRAKUHYOU:
                    editJimuRenraku(pSyoruiCds[count], reportServicesBeanList);
                    break;

                case TYOUHYOUSYURUI_MISSLIST:
                    editMisslist(pSyoruiCds[count], reportServicesBeanList);
                    break;

                case TYOUHYOUSYURUI_TYUUIKANKIJYOUHOU:
                    editNenkinSiharaiTkykKykGaiyou(pSyoruiCds[count],reportServicesBeanList);
                    break;

                case TYOUHYOUSYURUI_DAIHYOUSENNIN:
                    editDaihyouSenninTodoke(pSyoruiCds[count],reportServicesBeanList);
                    break;

                case TYOUHYOUSYURUI_TORIHIKIKAKUNINKIROKUSYO:
                    editTorihikiKakuninKirokuSyo(pSyoruiCds[count], reportServicesBeanList);
                    break;

                case TYOUHYOUSYURUI_KEIYAKUGAIYOU:
                    editJyudkgmbrtkTkykKykGaiyou(pSyoruiCds[count], reportServicesBeanList);
                    break;

                case TYOUHYOUSYURUI_TYUUIKANKIJYOUHOU1:
                    editJyudkgmbrtkTkykTyuknk(pSyoruiCds[count], reportServicesBeanList);
                    break;

                default:
                    for (int idx = 0; idx < reportServicesBeans.length; idx++) {
                        reportServicesBeanList.add(reportServicesBeans[idx]);
                    }
                    break;
            }

        }
        editHassouKbn();

        int size = reportServicesBeanList.size();
        if (size > 0) {
            String tyouhyouKeyWk = createReport.execNoCommit(reportServicesBeanList
                .toArray(new ReportServicesBean[size]));

            if (C_YouhiKbn.YOU.eq(pdfOutYhKbn)) {
                pdfSakuseiUmu = C_UmuKbn.ARI;
                tyouhyouKey = tyouhyouKeyWk;
            }

            if (C_YouhiKbn.YOU.eq(qrCodeYouhiKbn)) {
                qrCode = reportServicesBeanList.get(0).getQrCode();
            }
        }
    }

    private void editHassouKbn() {

        if (editSyoukenTbl.getHassoukbn() != null) {

            hassouKbn = editSyoukenTbl.getHassoukbn();

            ttdkKansDoujitu = kykKihon.getTtdkKansByTyouhyouymd(syoriYmd);

            if (ttdkKansDoujitu != null && ttdkKansDoujitu.size() > 0) {
                for (int count = 0; count < ttdkKansDoujitu.size(); count++) {
                    ttdkKansDoujitu.get(count).setHassoukbn(hassouKbn);
                }
            }

            if (koujyoPrm != null) {
                if (koujyoSym != null) {
                    if (C_KoujyosyoumeisakuseisyoriKbn.HOKENSYOUKEN.eq(koujyoPrm.getKoujyoSakuseiSyoriKbn())) {
                        koujyoSym.setHassoukbn(hassouKbn);
                    }
                }
            }
        }
    }

    public void createTyouhyouTBL(KhozenCommonParam pKhcParm,
        C_SyoruiCdKbn[] pSyoruiCds,
        C_YouhiKbn pPdfOutYhKbn) {

        createTyouhyouTBL(pKhcParm, null, pSyoruiCds, pPdfOutYhKbn);
    }

    private void getData() {

        kykKihon = cmnPrm.getKeiyakuKihon(syoNo);

        kykSyouhSyuLst = cmnPrm.getKeiyakuSyouhin(syoNo, C_SyutkKbn.SYU);

        kykSyouhTkLst = cmnPrm.getKeiyakuSyouhin(syoNo, C_SyutkKbn.TK);

        kykSya = cmnPrm.getKeiyakusya(syoNo);

        hhknSya = cmnPrm.getHihokensya(syoNo);

        kykUktSibouHenkan = cmnPrm.getSibouHenkankinUketorinin(syoNo);

        kykUktSiteiDairi = cmnPrm.getSiteiDairiSeikyuunin(syoNo);

        IT_KykSyouhn KykSyouhnSyu = null;
        if (kykSyouhSyuLst != null && kykSyouhSyuLst.size() > 0) {
            KykSyouhnSyu = kykSyouhSyuLst.get(0);

            syouhnTokujouSyu = cmnPrm.getSyouhinTokujyou(syoNo,
                C_SyutkKbn.SYU,
                KykSyouhnSyu.getSyouhncd(),
                KykSyouhnSyu.getSyouhnsdno(),
                KykSyouhnSyu.getKyksyouhnrenno());
        }

        kykDairitenLst = kykKihon.getKykDairitens();

        khTtdkTyuui = cmnPrm.getKkTetudukiTyuui(syoNo);

        kykUktSibouhokenLst = cmnPrm.getSibouUketorinin(syoNo);

        kykSonotaTkyk = kykKihon.getKykSonotaTkyk();

        kykUkt = cmnPrm.getNenkinUketorinin(syoNo);

        if (khTtdkTyuui != null && C_KktyuitaKbn.DNGNMEMOARI.eq(khTtdkTyuui.getKktyuitakbn())) {

            hassouKbn = C_HassouKbn.HONSYAKAISOU;
        }
    }

    private int getTyouhyouSyurui(C_SyoruiCdKbn pSyoruiCd) {

        if (C_SyoruiCdKbn.KK_SYOSAIHK_TTDKKR.eq(pSyoruiCd)
            || C_SyoruiCdKbn.KK_MEIGIHNK_TTDKKR.eq(pSyoruiCd)
            || C_SyoruiCdKbn.KK_SEINENGAPPISEI_TTDKKR.eq(pSyoruiCd)
            || C_SyoruiCdKbn.KK_SEINENGAPPISEI_TTDKKR_SHRARI.eq(pSyoruiCd)
            || C_SyoruiCdKbn.KK_GENGAKU_TTDKKR.eq(pSyoruiCd)
            || C_SyoruiCdKbn.KK_GENGAKU_ZEITEKI_TTDKKR.eq(pSyoruiCd)
            || C_SyoruiCdKbn.KK_ADRHNK_TTDKKR.eq(pSyoruiCd)
            || C_SyoruiCdKbn.KK_STDRHNK_TTDKKR.eq(pSyoruiCd)
            || C_SyoruiCdKbn.KK_NKTKYKHNK_TTDKKR.eq(pSyoruiCd)
            || C_SyoruiCdKbn.KK_TARGETHNK_TTDKKR.eq(pSyoruiCd)
            || C_SyoruiCdKbn.KK_SHRKZHNK_TTDKKR.eq(pSyoruiCd)
            || C_SyoruiCdKbn.KK_KAIGOMAETKHNK_TTDKKR.eq(pSyoruiCd)
            || C_SyoruiCdKbn.KK_MKHGKHNK_TTDKKR.eq(pSyoruiCd)
            || C_SyoruiCdKbn.KK_TUMITATEKINITEN_TTDKKR.eq(pSyoruiCd)
            || C_SyoruiCdKbn.KK_KAIYAKU_TTDKKR.eq(pSyoruiCd)
            || C_SyoruiCdKbn.KK_KAIYAKU_SAIKENSYA_TTDKKR.eq(pSyoruiCd)
            || C_SyoruiCdKbn.KK_SYOUMETU_GAIBU_TTDKKR.eq(pSyoruiCd)
            || C_SyoruiCdKbn.KK_KYKTRKS_KYKTRKSTTDKKR.eq(pSyoruiCd)
            || C_SyoruiCdKbn.KK_CLGOFF_KYKTRKSTTDKKR.eq(pSyoruiCd)
            || C_SyoruiCdKbn.KK_KAIJYO_KYKTRKSTTDKKR.eq(pSyoruiCd)
            || C_SyoruiCdKbn.KK_SBMUKOU_KYKTRKSTTDKKR.eq(pSyoruiCd)
            || C_SyoruiCdKbn.KK_SBKAIJYO_KYKTRKSTTDKKR.eq(pSyoruiCd)
            || C_SyoruiCdKbn.KK_SBMENSEKI_KYKTRKSTTDKKR.eq(pSyoruiCd)
            || C_SyoruiCdKbn.KK_YENDTHNKHNRKN_TTDKKR.eq(pSyoruiCd)
            || C_SyoruiCdKbn.KK_YENDTHNK_HNRKNSKS_TTDKKR.eq(pSyoruiCd)
            || C_SyoruiCdKbn.KK_YENDTHNK_TTDKKR.eq(pSyoruiCd)
            || C_SyoruiCdKbn.KK_YENDTHNK_TTDKKR_3.eq(pSyoruiCd)
            || C_SyoruiCdKbn.KK_YENDTHNK_NINI_TTDKKR_2.eq(pSyoruiCd)
            || C_SyoruiCdKbn.KK_YENDTHNK_TTDKKR_2.eq(pSyoruiCd)
            || C_SyoruiCdKbn.KK_YENDTHNK_NINI_TTDKKR.eq(pSyoruiCd)
            || C_SyoruiCdKbn.KK_DSHR_TTDKKR.eq(pSyoruiCd)
            || C_SyoruiCdKbn.KK_DTUIBARAI_TTDKKR.eq(pSyoruiCd)
            || C_SyoruiCdKbn.KK_DTUIBARAI_TTDKKR_ZEIMUNASI.eq(pSyoruiCd)
            || C_SyoruiCdKbn.KK_KZKTRKKYKDRHNK_TTDKKR.eq(pSyoruiCd)
            || C_SyoruiCdKbn.KK_KZKTRKTYOKUSOU_TTDKKR.eq(pSyoruiCd)) {

            return TYOUHYOUSYURUI_TTDKKANRYOU;
        }
        else if (C_SyoruiCdKbn.KK_SYOSAIHK_SKS.eq(pSyoruiCd)
            || C_SyoruiCdKbn.KK_MEIGIHNK_SKS.eq(pSyoruiCd)
            || C_SyoruiCdKbn.KK_SEINENGAPPISEI_SKS.eq(pSyoruiCd)
            || C_SyoruiCdKbn.KK_GENGAKU_SKS.eq(pSyoruiCd)
            || C_SyoruiCdKbn.KK_KAIYAKU_SKS.eq(pSyoruiCd)
            || C_SyoruiCdKbn.KK_ADRHNK_SKS.eq(pSyoruiCd)
            || C_SyoruiCdKbn.KK_STDRHNK_SKS.eq(pSyoruiCd)
            || C_SyoruiCdKbn.KK_NKTKYKHNK_SKS.eq(pSyoruiCd)
            || C_SyoruiCdKbn.KK_TARGETHNK_SKS.eq(pSyoruiCd)
            || C_SyoruiCdKbn.KK_SHRKZHNK_SKS.eq(pSyoruiCd)
            || C_SyoruiCdKbn.KK_KAIGOMAETKHNK_SKS.eq(pSyoruiCd)
            || C_SyoruiCdKbn.KK_MKHGKHNK_SKS.eq(pSyoruiCd)
            || C_SyoruiCdKbn.KK_TUMITATEKINITEN_SKS.eq(pSyoruiCd)
            || C_SyoruiCdKbn.KK_YENDTHNKHNRKN_SKS.eq(pSyoruiCd)
            || C_SyoruiCdKbn.KK_DSHR_SKS.eq(pSyoruiCd)
            || C_SyoruiCdKbn.KK_YENDTHNK_SKS.eq(pSyoruiCd)
            || C_SyoruiCdKbn.KK_KZKTRKKYKDRTKYKHNK_SKS.eq(pSyoruiCd)) {

            return TYOUHYOUSYURUI_SEIKYUUSYO;
        }
        else if (C_SyoruiCdKbn.KK_SYOSAIHK_SOUHU.eq(pSyoruiCd)
            || C_SyoruiCdKbn.KK_MEIGIHNK_SOUHU.eq(pSyoruiCd)
            || C_SyoruiCdKbn.KK_SEINENGAPPISEI_SOUHU.eq(pSyoruiCd)
            || C_SyoruiCdKbn.KK_GENGAKU_SOUHU.eq(pSyoruiCd)
            || C_SyoruiCdKbn.KK_KAIYAKU_SKSSOUHU.eq(pSyoruiCd)
            || C_SyoruiCdKbn.KK_ADRHNK_SOUHU.eq(pSyoruiCd)
            || C_SyoruiCdKbn.KK_SOUHUANNAI.eq(pSyoruiCd)
            || C_SyoruiCdKbn.KK_STDRHNK_SOUHU.eq(pSyoruiCd)
            || C_SyoruiCdKbn.KK_NKTKYKHNK_SOUHU.eq(pSyoruiCd)
            || C_SyoruiCdKbn.KK_TARGETHNK_SOUHU.eq(pSyoruiCd)
            || C_SyoruiCdKbn.KK_SHRKZHNK_SOUHU.eq(pSyoruiCd)
            || C_SyoruiCdKbn.KK_KAIGOMAETKHNK_SOUHU.eq(pSyoruiCd)
            || C_SyoruiCdKbn.KK_MKHGKHNK_SOUHU.eq(pSyoruiCd)
            || C_SyoruiCdKbn.KK_TUMITATEKINITEN_SOUHU.eq(pSyoruiCd)
            || C_SyoruiCdKbn.KK_YENDTHNKHNRKN_SOUHU.eq(pSyoruiCd)
            || C_SyoruiCdKbn.KK_DSHR_SOUHU.eq(pSyoruiCd)
            || C_SyoruiCdKbn.KK_SHIHARAI_SOUHU.eq(pSyoruiCd)
            || C_SyoruiCdKbn.KK_YENDTHNK_SOUHU.eq(pSyoruiCd)
            || C_SyoruiCdKbn.KK_KZKTRKKYKDRTKYKHNK_SOUHU.eq(pSyoruiCd)) {


            return TYOUHYOUSYURUI_SOUHUANNAI;
        }
        else if (C_SyoruiCdKbn.KK_HKNSYKN.eq(pSyoruiCd)) {
            return TYOUHYOUSYURUI_HOKENSYOUKEN;
        }
        else if (C_SyoruiCdKbn.KK_KOUJYOSYOUMEIS.eq(pSyoruiCd)) {
            return TYOUHYOUSYURUI_KOUJYOSYOUMEISYO;
        }
        else if (C_SyoruiCdKbn.KK_JIMURENRAKU_KYKTORIKESI.eq(pSyoruiCd)
            || C_SyoruiCdKbn.KK_JIMURENRAKU_GENGAKU.eq(pSyoruiCd)
            || C_SyoruiCdKbn.KK_JIMURENRAKU_SEINENGAPPISEITEISEI.eq(pSyoruiCd)
            || C_SyoruiCdKbn.KK_JIMURENRAKU_MEIGIHNK.eq(pSyoruiCd)
            || C_SyoruiCdKbn.KK_JIMURENRAKU_TETUDUKITYUUI.eq(pSyoruiCd)) {

            return TYOUHYOUSYURUI_JIMURENRAKUHYOU;
        }

        else if (C_SyoruiCdKbn.KK_KYKINFOTORIKOMI_MISSLIST.eq(pSyoruiCd)
            || C_SyoruiCdKbn.KK_SHRKEKKATORIKOMI_MISSLIST.eq(pSyoruiCd)
            || C_SyoruiCdKbn.KK_KZHURIANNAISEL_MISSLIST.eq(pSyoruiCd)
            || C_SyoruiCdKbn.KK_YUUKOUKEKKAHANEI_MISSLIST.eq(pSyoruiCd)
            || C_SyoruiCdKbn.KK_AUTHORIKEKKAHANEI_MISSLIST.eq(pSyoruiCd)
            || C_SyoruiCdKbn.KK_URIAGEKEKKATRSKS_MISSLIST.eq(pSyoruiCd)
            || C_SyoruiCdKbn.KK_NYUUKIN_MISSLIST.eq(pSyoruiCd)
            || C_SyoruiCdKbn.KK_KACHECK_YOHURI_MISSLIST.eq(pSyoruiCd)
            || C_SyoruiCdKbn.KK_KACHECK_SHRKZ_MISSLIST.eq(pSyoruiCd)
            || C_SyoruiCdKbn.KK_DHANEI_MISSLIST.eq(pSyoruiCd)
            || C_SyoruiCdKbn.KK_BATCHKAIYAKU_MISSLIST.eq(pSyoruiCd)
            || C_SyoruiCdKbn.KK_YENDTHNK_MISSLIST.eq(pSyoruiCd)
            || C_SyoruiCdKbn.KK_YENDTHNKSEL_MISSLIST.eq(pSyoruiCd)
            || C_SyoruiCdKbn.KK_SEISANDHANEI_MISSLIST.eq(pSyoruiCd)
            || C_SyoruiCdKbn.KK_DSEISAN_MISSLIST.eq(pSyoruiCd)
            || C_SyoruiCdKbn.KK_SISUURENDOTMTTKNHANEI_MISSLIST.eq(pSyoruiCd)
            || C_SyoruiCdKbn.KK_GAIKAKOKYAKUTUUTISKS_MISSLIST.eq(pSyoruiCd)
            || C_SyoruiCdKbn.KK_BATCHMKHGKHENKOU_MISSLIST.eq(pSyoruiCd)) {

            return TYOUHYOUSYURUI_MISSLIST;
        }
        else if (C_SyoruiCdKbn.KK_MINYUUITIRAN.eq(pSyoruiCd)) {
            return TYOUHYOUSYURUI_MINYUUIRIRANHYOU;
        }
        else if (C_SyoruiCdKbn.KK_SIKKOUITIRAN.eq(pSyoruiCd)) {
            return TYOUHYOUSYURUI_SIKKOUIRIRANHYOU;
        }
        else if (C_SyoruiCdKbn.KK_HANDKARIKANJYOU.eq(pSyoruiCd)) {
            return TYOUHYOUSYURUI_HANDKARIKANJYOU;
        }
        else if (C_SyoruiCdKbn.KK_NKTKYKHNK_GAIYOU.eq(pSyoruiCd)) {
            return TYOUHYOUSYURUI_TYUUIKANKIJYOUHOU;
        }
        else if (C_SyoruiCdKbn.KK_MEIGIHNK_DAIHYOUSN.eq(pSyoruiCd) ||
            C_SyoruiCdKbn.KK_KAIYAKU_DAIHYOUSN.eq(pSyoruiCd)
            || C_SyoruiCdKbn.KK_YENDTHNKHNRKN_DAIHYOUSN.eq(pSyoruiCd)) {

            return TYOUHYOUSYURUI_DAIHYOUSENNIN;
        }
        else if (C_SyoruiCdKbn.KK_MEIGIHNK_TORIHIKIKAK.eq(pSyoruiCd)) {

            return TYOUHYOUSYURUI_TORIHIKIKAKUNINKIROKUSYO;
        }

        else if (C_SyoruiCdKbn.KK_KAIGOMAETK_KYKGAIYOU.eq(pSyoruiCd)){

            return TYOUHYOUSYURUI_KEIYAKUGAIYOU;
        }

        else if (C_SyoruiCdKbn.KK_KAIGOMAETK_TYUUIKANKI.eq(pSyoruiCd)){

            return TYOUHYOUSYURUI_TYUUIKANKIJYOUHOU1;
        }

        else {
            throw new CommonBizAppException("書類コード不正（" + pSyoruiCd + "）");
        }
    }

    private void editHokenSyouken() {

        List<IT_NyknJissekiRireki> nyknJissekiRirekiList = kykKihon.getNyknJissekiRirekis();

        if (nyknJissekiRirekiList == null || nyknJissekiRirekiList.size() == 0){
            throw new CommonBizAppException("入金実績履歴テーブルにデータが存在しません。");
        }

        if (!C_SyoukensaihkKbn.SINKEIYAKUSAISAKUSEI.eq(editHokenSyoukenParam.getSyoukenSaihk())) {
            editHokenSyoukenParam.setTantoucd(C_TantouCdKbn.MEIGIHENKOU);
        }

        ttdkKansDoujitu = kykKihon.getTtdkKansByTyouhyouymd(syoriYmd);

        boolean ttdkKansDoujituflg = false;

        if (ttdkKansDoujitu != null && ttdkKansDoujitu.size() > 0) {

            ttdkKansDoujituflg = true;

            for (int count = 0; count < ttdkKansDoujitu.size(); count++) {
                if (C_TetudukisyuKbn.MKHGKTTTYENDTHNK.eq(ttdkKansDoujitu.get(count).getTetudukisyukbn()) ||
                    C_TetudukisyuKbn.MKHGKTTTYENDTHNK_NEN.eq(ttdkKansDoujitu.get(count).getTetudukisyukbn()) ||
                    C_TetudukisyuKbn.YENDTHNKNINI.eq(ttdkKansDoujitu.get(count).getTetudukisyukbn()) ||
                    C_TetudukisyuKbn.YENDTHNKNINI_NEN.eq(ttdkKansDoujitu.get(count).getTetudukisyukbn())) {
                    editHokenSyoukenParam.setTantoucd(C_TantouCdKbn.DAIRITENJIMUHOZEN);
                    break;
                }
            }

        }

        if (kykKihon.getHokenSyoukenByTyouhyouymd(syoriYmd) != null) {

            if (ttdkKansDoujituflg) {

                hassouKbn = C_HassouKbn.HONSYAKAISOU;

                editHokenSyoukenParam.setHukusuuUmu(C_UmuKbn.ARI);

                editHokenSyoukenParam.setTantoucd(C_TantouCdKbn.MEIGIHENKOU);

            }
        }

        kykKihon.getHokenSyoukens().remove(kykKihon.getHokenSyoukenByTyouhyouymd(syoriYmd));

        hozenDomManager.flush();

        kykKihon.getSuiihyous().removeAll(kykKihon.getSuiihyousByTyouhyouymd(syoriYmd));

        hozenDomManager.flush();

        editSyoukenTbl.editTBL(
            cmnPrm,
            kykKihon,
            kykSyouhSyuLst,
            kykSonotaTkyk,
            kykSyouhTkLst,
            syouhnTokujouSyu,
            kykSya,
            hhknSya,
            kykUktSibouHenkan,
            kykUktSiteiDairi,
            kykDairitenLst,
            khTtdkTyuui,
            kykUktSibouhokenLst,
            nyknJissekiRirekiList,
            editHokenSyoukenParam,
            syoriYmd,
            sinsaihKbn,
            tetudukisyuKbn,
            hassouKbn);

    }

    private void editTtdkKanryou(C_SyoruiCdKbn pSyoruiCd, List<ReportServicesBean> pReportServicesBeanList) {

        C_TetudukisyuKbn tetudukiSyu = ttdkPrm.getTetudukiSyu();

        C_UmuKbn siharaiUmu = ttdkPrm.getSiharaiUmu();

        String sikibetuKey = cmnPrm.getSikibetuKey(syoNo);

        IT_KhShrRireki khShrRireki = null;

        IT_KhHasseijiKazeiRireki khHasseijiKazeiRireki = null;

        C_Kaiyakujiyuu kaiyakuJiyuu = ttdkPrm.getKaiyakuJiyuu();

        if (C_UmuKbn.ARI.eq(siharaiUmu) ||
            (C_TetudukisyuKbn.KAIYAKU.eq(tetudukiSyu) && C_Kaiyakujiyuu.KYKSB.eq(kaiyakuJiyuu)) ||
            (C_TetudukisyuKbn.KAIYAKU.eq(tetudukiSyu) && C_Kaiyakujiyuu.SKS.eq(kaiyakuJiyuu)) ||
            C_TetudukisyuKbn.SEISANKINHURIKOMI.eq(tetudukiSyu)) {

            khShrRireki = kykKihon.getKhTtdkRirekiByHenkousikibetukey(sikibetuKey).getKhShrRireki();
            if (khShrRireki == null) {
                throw new CommonBizAppException("契約保全支払履歴テーブルにデータが存在しません。");
            }
        }

        if (C_TetudukisyuKbn.MKHGKTTTYENDTHNK.eq(tetudukiSyu)) {

            khHasseijiKazeiRireki = kykKihon.getKhTtdkRirekiByHenkousikibetukey(sikibetuKey)
                .getKhHasseijiKazeiRireki();
        }

        if (C_SyoruiCdKbn.KK_KZKTRKTYOKUSOU_TTDKKR.eq(pSyoruiCd)) {

            editKhTyokusouTtdkKanryouTbl.main(
                cmnPrm,
                kykKihon,
                kykSyouhSyuLst,
                kykSya,
                hhknSya,
                ttdkPrm,
                kykSonotaTkyk,
                syoriYmd,
                hassouKbn,
                pSyoruiCd);
        }
        else {

            IT_TtdkKan ttdkKan = editTtdkKanryouTbl.editTBL(
                cmnPrm,
                kykKihon,
                kykSyouhSyuLst,
                kykSya,
                hhknSya,
                ttdkPrm,
                khShrRireki,
                khHasseijiKazeiRireki,
                kykSonotaTkyk,
                syoriYmd,
                hassouKbn,
                pSyoruiCd);

            if (C_YouhiKbn.YOU.eq(pdfOutYhKbn)) {
                if (ttdkKan == null) {
                    throw new CommonBizAppException("手続完了テーブルにデータが存在しません。");
                }

                ReportServicesBean reportServicesBean = editTtdkKanryouTbl.editBean(
                    pSyoruiCd,
                    cmnPrm,
                    ttdkKan,
                    kykSya);

                pReportServicesBeanList.add(reportServicesBean);

                kykKihon.getTtdkKans().remove(ttdkKan);
            }
        }
    }

    private void editKoujyoSyoumei(List<ReportServicesBean> pReportServicesBeanLst) {
        C_SinsakuseiKbn sinkiSakuseiKbn = koujyoPrm.getSinkiSakusei();
        String koujyoNendo = koujyoPrm.getKoujyoNendo();

        if (C_SinsakuseiKbn.SIN.eq(sinkiSakuseiKbn)) {

            Integer renNoMax = hozenDomManager.getKoujyoSymMaxRennoBySyonoNendoTyouhyouymd(syoNo,
                koujyoNendo, syoriYmd);

            int renNo = 0;
            if (renNoMax != null) {
                renNo = renNoMax + 1;
            }
            else {
                renNo = 1;
            }

            koujyoSym = editKoujyoSyoumeiTbl.editTBL(
                cmnPrm,
                kykKihon,
                kykSyouhSyuLst,
                kykSya,
                kykUktSibouhokenLst,
                kykUkt,
                kykDairitenLst,
                khTtdkTyuui,
                koujyoPrm,
                hassouKbn,
                syoriYmd,
                renNo);

            renNo++;

            if (C_YouhiKbn.YOU.eq(pdfOutYhKbn)) {

                if (koujyoSym == null) {

                    throw new CommonBizAppException("控除証明書テーブルにデータが存在しません。");
                }

                ReportServicesBean reportServicesBean = editKoujyoSyoumeiTbl.editBean(cmnPrm, koujyoSym, syoriYmd);

                pReportServicesBeanLst.add(reportServicesBean);
            }
        }
    }

    private void editSeikyuusyo(C_SyoruiCdKbn pSyoruiCd, List<ReportServicesBean> pReportServicesBeanList) {
        ReportServicesBean reportServicesBean = editSeikyuusyoTbl.editBean(
            pSyoruiCd,
            syoNo,
            cmnPrm,
            seikyuuPrm);

        pReportServicesBeanList.add(reportServicesBean);
    }

    private void editSouhuannai(C_SyoruiCdKbn pSyoruiCd, List<ReportServicesBean> pReportServicesBeanList) {
        ReportServicesBean reportServicesBean = editSouhuannaiTbl.editBean(
            pSyoruiCd,
            syoNo,
            cmnPrm,
            souhuPrm);

        pReportServicesBeanList.add(reportServicesBean);
    }

    private void editJimuRenraku(C_SyoruiCdKbn pSyoruiCd, List<ReportServicesBean> pReportServicesBeanList) {
        ReportServicesBean reportServicesBean = editJimuRenrakuhyouTbl.editBean(
            pSyoruiCd,
            syoNo,
            cmnPrm,
            jimuPrm,
            syoriYmd);

        pReportServicesBeanList.add(reportServicesBean);
    }

    private void editMisslist(C_SyoruiCdKbn pSyoruiCd, List<ReportServicesBean> pReportServicesBeanList) {
        ReportServicesBean reportServicesBean = editKhMisslstTbl.editBean(
            pSyoruiCd,
            cmnPrm,
            misslstPrmLst,
            syoriYmd);

        pReportServicesBeanList.add(reportServicesBean);
    }

    private void editNenkinSiharaiTkykKykGaiyou(C_SyoruiCdKbn pSyoruiCdKbn,
        List<ReportServicesBean> pReportServicesBeanLst) {

        KhNkshrtkykkykgaiyouBean khNkshrtkykkykgaiyouBean = SWAKInjector.getInstance(KhNkshrtkykkykgaiyouBean.class);

        khNkshrtkykkykgaiyouBean.setIrTyouhyousakuseiymd(DateFormatUtil.dateKANJI(syoriYmd));
        khNkshrtkykkykgaiyouBean.setIrSyono(syoNo);

        ReportServicesBean reportServicesBean = createReport.createNewReportServiceBean(
            IKhozenCommonConstants.SUBSYSTEMID_HOZEN, cmnPrm.getCategoryId(), cmnPrm.getFunctionId(), pSyoruiCdKbn);

        reportServicesBean.setKensakuKeys(syoNo);

        reportServicesBean.addParamObjects(khNkshrtkykkykgaiyouBean);

        pReportServicesBeanLst.add(reportServicesBean);
    }

    private void editDaihyouSenninTodoke(C_SyoruiCdKbn pSyoruiCd, List<ReportServicesBean> pReportServicesBeanLst) {

        KhDaihyousennintodokeBean khDaihyousennintodokeBean = SWAKInjector.getInstance(KhDaihyousennintodokeBean.class);

        khDaihyousennintodokeBean.setIrTyouhyousakuseiymd(DateFormatUtil.dateKANJI(syoriYmd));
        khDaihyousennintodokeBean.setIrKyknmkj(kykSya.getKyknmkj());
        khDaihyousennintodokeBean.setIrSyono(syoNo);
        khDaihyousennintodokeBean.setIrKinouid(cmnPrm.getFunctionId());

        ReportServicesBean reportServicesBean = createReport.createNewReportServiceBean(
            IKhozenCommonConstants.SUBSYSTEMID_HOZEN, cmnPrm.getCategoryId(), cmnPrm.getFunctionId(), pSyoruiCd);

        reportServicesBean.setKensakuKeys(syoNo);

        reportServicesBean.addParamObjects(khDaihyousennintodokeBean);

        pReportServicesBeanLst.add(reportServicesBean);
    }

    private void editTorihikiKakuninKirokuSyo(C_SyoruiCdKbn pSyoruiCd, List<ReportServicesBean> pReportServicesBeanLst) {

        C_Meigihnkjiyuu meigihnkjiyuu = C_Meigihnkjiyuu.BLNK;

        if (C_SyoruiCdKbn.KK_MEIGIHNK_TORIHIKIKAK.eq(pSyoruiCd)) {

            meigihnkjiyuu = seikyuuPrm.getMeigihnkjiyuu();
        }

        KhTrhkkakkirokusyoBean khTrhkkakkirokusyoBean = SWAKInjector.getInstance(KhTrhkkakkirokusyoBean.class);

        khTrhkkakkirokusyoBean.setIrTyouhyousakuseiymd(DateFormatUtil.dateKANJI(syoriYmd));
        khTrhkkakkirokusyoBean.setIrMeigihnkjiyuu(meigihnkjiyuu);
        khTrhkkakkirokusyoBean.setIrSyono(syoNo);

        ReportServicesBean reportServicesBean = createReport.createNewReportServiceBean(
            IKhozenCommonConstants.SUBSYSTEMID_HOZEN, cmnPrm.getCategoryId(), cmnPrm.getFunctionId(), pSyoruiCd);

        reportServicesBean.setKensakuKeys(syoNo);

        reportServicesBean.addParamObjects(khTrhkkakkirokusyoBean);

        pReportServicesBeanLst.add(reportServicesBean);
    }

    private void editJyudkgmbrtkTkykKykGaiyou(C_SyoruiCdKbn pSyoruiCd, List<ReportServicesBean> pReportServicesBeanLst) {

        KhJyudkgmbrtkkykgyBean KhJyudkgmbrtkkykgyBean = SWAKInjector.getInstance(KhJyudkgmbrtkkykgyBean.class);

        KhJyudkgmbrtkkykgyBean.setIrTyouhyousakuseiymd(DateFormatUtil.dateKANJI(syoriYmd));

        KhJyudkgmbrtkkykgyBean.setIrSyono(syoNo);

        KhJyudkgmbrtkkykgyBean.setIrKyknm(kykSya.getKyknmkj());

        KhJyudkgmbrtkkykgyBean.setIrToritsugisyasyozokunm(cmnPrm.getTmSosikiNm());

        KhJyudkgmbrtkkykgyBean.setIrToritsugisyanm(cmnPrm.getUserNm());

        ReportServicesBean reportServicesBean = createReport.createNewReportServiceBean(
            IKhozenCommonConstants.SUBSYSTEMID_HOZEN, cmnPrm.getCategoryId(), cmnPrm.getFunctionId(), pSyoruiCd);

        reportServicesBean.setKensakuKeys(syoNo);

        reportServicesBean.addParamObjects(KhJyudkgmbrtkkykgyBean);

        pReportServicesBeanLst.add(reportServicesBean);
    }

    private void editJyudkgmbrtkTkykTyuknk(C_SyoruiCdKbn pSyoruiCd, List<ReportServicesBean> pReportServicesBeanLst) {

        KhJyudkgmbrtkkykgyBean KhJyudkgmbrtkkykgyBean = SWAKInjector.getInstance(KhJyudkgmbrtkkykgyBean.class);

        KhJyudkgmbrtkkykgyBean.setIrTyouhyousakuseiymd(DateFormatUtil.dateKANJI(syoriYmd));

        KhJyudkgmbrtkkykgyBean.setIrSyono(syoNo);

        KhJyudkgmbrtkkykgyBean.setIrKyknm(kykSya.getKyknmkj());

        KhJyudkgmbrtkkykgyBean.setIrToritsugisyasyozokunm(cmnPrm.getTmSosikiNm());

        KhJyudkgmbrtkkykgyBean.setIrToritsugisyanm(cmnPrm.getUserNm());

        ReportServicesBean reportServicesBean = createReport.createNewReportServiceBean(
            IKhozenCommonConstants.SUBSYSTEMID_HOZEN, cmnPrm.getCategoryId(), cmnPrm.getFunctionId(), pSyoruiCd);

        reportServicesBean.setKensakuKeys(syoNo);

        reportServicesBean.addParamObjects(KhJyudkgmbrtkkykgyBean);

        pReportServicesBeanLst.add(reportServicesBean);
    }
}