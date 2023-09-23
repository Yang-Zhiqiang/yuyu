package yuyu.common.hozen.khcommon;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateSpan;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.date.CHolidayAdjustingMode;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.number.currencytype.CurrencyType;

import org.slf4j.Logger;

import yuyu.common.base.format.DefaultDateFormatter;
import yuyu.common.biz.bzcommon.BizDateUtil;
import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.common.biz.bzcommon.BizUtil;
import yuyu.common.biz.bzcommon.BzGetSosikiMadogutiInfo;
import yuyu.common.biz.bzcommon.BzGetSosikiMadogutiInfoKekkaBean;
import yuyu.common.biz.bzcommon.ConvertYuutyoSitencd;
import yuyu.common.biz.bzcommon.HenkanTuuka;
import yuyu.common.biz.bzcommon.IGkCommonKoumoku;
import yuyu.common.biz.exception.CommonBizAppException;
import yuyu.common.biz.kaikei.BzDenpyouDataSks;
import yuyu.common.biz.kaikei.BzDenpyouDataTourokuBean;
import yuyu.common.biz.kaikei.BzFbSoukinDataSks;
import yuyu.common.biz.kaikei.BzFbSoukinDataSksBean;
import yuyu.common.biz.kaikei.BzSegmentCdSyutoku;
import yuyu.common.biz.kaikei.BzSikinIdouRirekiTblSakusei;
import yuyu.common.biz.kaikei.SikinIdouRirekiDataBean;
import yuyu.common.biz.kaikei.SyouhinbetuSegmentBean;
import yuyu.common.hozen.ascommon.AnsyuuBatSyoriHunoKykMisslistSks;
import yuyu.common.hozen.ascommon.CreditHnknTuutiSks;
import yuyu.common.hozen.ascommon.CreditHnknTuutiSksParam;
import yuyu.common.hozen.ascommon.GetasPRsTuuka;
import yuyu.common.hozen.ascommon.KeisanRsgaku;
import yuyu.common.hozen.ascommon.KeisanRsgkOutBean;
import yuyu.common.hozen.ascommon.KeisanRsgkUtiwakeBean;
import yuyu.common.hozen.ascommon.SetMinusUriagebi;
import yuyu.common.hozen.khcommon.dba4commonnyuukin.CommonNyuukinDao;
import yuyu.def.biz.configuration.YuyuBizConfig;
import yuyu.def.classification.C_AnnaijkKbn;
import yuyu.def.classification.C_CommonNyuukinErrorRiyuuKbn;
import yuyu.def.classification.C_CreditUriageNgJiyuuKbn;
import yuyu.def.classification.C_CreditUriageSeikyuuKbn;
import yuyu.def.classification.C_DattairiyuuKbn;
import yuyu.def.classification.C_DensysKbn;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_HassouKbn;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_Hrkkeiro;
import yuyu.def.classification.C_InputShrhousiteiKbn;
import yuyu.def.classification.C_Kanjyoukmkcd;
import yuyu.def.classification.C_KhDengkSyuruiKbn;
import yuyu.def.classification.C_KinouKbn;
import yuyu.def.classification.C_KjsymnytblhensyuusyoriKbn;
import yuyu.def.classification.C_KktyuitaKbn;
import yuyu.def.classification.C_KrkriyuuKbn;
import yuyu.def.classification.C_Kykjyoutai;
import yuyu.def.classification.C_NykhouhouKbn;
import yuyu.def.classification.C_Nykkeiro;
import yuyu.def.classification.C_NyknaiyouKbn;
import yuyu.def.classification.C_NykshrKbn;
import yuyu.def.classification.C_Nyktrksflg;
import yuyu.def.classification.C_ShrhousiteiKbn;
import yuyu.def.classification.C_ShrriyuuKbn;
import yuyu.def.classification.C_SyorikahiKbn;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.classification.C_Syoumetujiyuu;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.classification.C_Syuudaikocd;
import yuyu.def.classification.C_TaisyakuKbn;
import yuyu.def.classification.C_TkiktbrisyuruiKbn;
import yuyu.def.classification.C_TsrysyoriKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_TykzentykgoKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_YouhiKbn;
import yuyu.def.classification.C_YuukousyoumetuKbn;
import yuyu.def.db.entity.AS_Kinou;
import yuyu.def.db.entity.BT_SikinIdouRireki;
import yuyu.def.db.entity.IT_AnsyuKihon;
import yuyu.def.db.entity.IT_AnsyuRireki;
import yuyu.def.db.entity.IT_DattaiUktk;
import yuyu.def.db.entity.IT_Kariukekin;
import yuyu.def.db.entity.IT_KhDenpyoData;
import yuyu.def.db.entity.IT_KhFBSoukinData;
import yuyu.def.db.entity.IT_Kouza;
import yuyu.def.db.entity.IT_KouzaHnknTuuti;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.IT_KykSya;
import yuyu.def.db.entity.IT_KykSyouhn;
import yuyu.def.db.entity.IT_NyknJissekiRireki;
import yuyu.def.db.entity.IT_NyuukinKakusyouData;
import yuyu.def.db.entity.IT_SyuunouHenknRireki;
import yuyu.def.db.entity.IT_Zennou;
import yuyu.infr.report.CreateReport;
import yuyu.infr.report.swakreport.ReportServicesBean;

/**
 * 契約保全 契約保全共通 入金共通処理
 */
public class CommonNyuukin {

    private static final String BLANK = "";

    private C_ErrorKbn errorKbn;

    private C_CommonNyuukinErrorRiyuuKbn commonNyuukinErrorRiyuuKbn;

    private C_KrkriyuuKbn krkRiyuuKbn;

    private String syoNo;

    private C_Syuudaikocd syuudaikocd;

    private BizDate syoriYmd;

    private BizDate nyuukinKakusyounrkYmd;

    private C_Nykkeiro nykKeiro;

    private C_Hrkkaisuu nykHrkKaisuu;

    private C_NyknaiyouKbn nykNaiyouKbn;

    private C_UmuKbn iktnyuukinnUmu;

    private BizDateYM jyutouYm;

    private int jyutouKaisuuY;

    private int jyutouKaisuuM;

    private BizCurrency ryosyuGk;

    private BizDate ryosyuYmd;

    private String kzHurikaeBankCd;

    private String kzHurikaeSitenCd;

    private String suitoSoshikiCd;

    private BizDate zengetumatuDenSimeYmd;

    private C_NykhouhouKbn nykhouhouKbn;

    private String gyoumuKosKinouId;

    private String gyoumuKosId;

    private String sysTime;

    private BizCurrency hrkP;

    private C_Hrkkaisuu hrkKaisuu;

    private BizCurrency kajyoukin;

    private BizDate kykYmd;

    private String henkouSikibetuKey;

    private BizCurrency seitouGk;

    private BizDateYM jkiPJytYm;

    private int krkNo;

    private BizCurrency krkGk;

    private C_YouhiKbn pdfOutYouhi;

    private C_UmuKbn pdfOutUmuKbn;

    private String tyohyoKey;

    private KhozenCommonParam khCParm;

    private String syouhinCd;

    private int syouhinSdNo;

    private C_Syoumetujiyuu syoumetuJiyuu;

    private C_YuukousyoumetuKbn ykSymtuKbn;

    private IT_KykKihon itKykKihon;

    private IT_AnsyuKihon itAnsyuKihon;

    private List<IT_KhDenpyoData> itKhDenpyoDatas;

    private IT_KhFBSoukinData itKhFBSoukinData;

    private IT_NyuukinKakusyouData itNyuukinKakusyouData;

    private boolean konkiPYhFlg;

    private BizDate hnknDenpyoYmd;

    private C_YouhiKbn nyuukinKakusyouSakuseiYh;

    private String tsinyno;

    private String tsinadr1kj;

    private String tsinadr2kj;

    private String tsinadr3kj;

    private String kyknmkj;

    private BizDate denymd;

    private boolean jidonhnknumu;

    private C_TkiktbrisyuruiKbn tikiktbrisyuruikbn;

    private BizDateYM updategoJkipjytYm;

    private C_Tuukasyu rstuukasyu;

    private List<IT_KykSyouhn> kykSyouhnLst;

    private BizDate nyknKwsrateKijyunYmd;

    private BizDate seisantgkmkHasseidenYmd;

    private String tabakarikanjyono;

    private C_Kykjyoutai kykJyoutai;

    private IT_SyuunouHenknRireki syuunouHenknRireki;

    private IT_Kariukekin kariukekin;

    private String creditkessaiyouno;

    private List<KeisanRsgkUtiwakeBean> keisanRsgkUtiwakeBeanList;

    private C_CreditUriageSeikyuuKbn creditUriageSeikyuuKbn;

    @Inject
    private static Logger logger;

    @Inject
    private AS_Kinou asKinou;

    @Inject
    private CommonNyuukinDao commonNyuukinDao;

    public CommonNyuukin() {
        super();
    }

    public C_ErrorKbn getErrorKbn() {
        return errorKbn;
    }

    public C_CommonNyuukinErrorRiyuuKbn getCommonNyuukinErrorRiyuuKbn() {
        return commonNyuukinErrorRiyuuKbn;
    }

    public C_KrkriyuuKbn getKrkRiyuuKbn() {
        return krkRiyuuKbn;
    }

    public C_UmuKbn getPdfOutUmuKbn() {
        return pdfOutUmuKbn;
    }

    public String getTyohyoKey() {
        return tyohyoKey;
    }

    public BizCurrency getBdKrkGK() {
        return krkGk;
    }

    public IT_KykKihon getKykKihon() {
        return itKykKihon;
    }

    public IT_AnsyuKihon getAnsyuKihon() {
        return itAnsyuKihon;
    }

    public List<IT_KhDenpyoData> getKhDenpyoDatas() {
        return itKhDenpyoDatas;
    }

    public IT_KhFBSoukinData getKhFBSoukinData() {
        return itKhFBSoukinData;
    }

    public IT_NyuukinKakusyouData getNyuukinKakusyouData() {
        return itNyuukinKakusyouData;
    }

    public boolean getJidonhnknumu() {
        return jidonhnknumu;
    }

    public IT_SyuunouHenknRireki getSyuunouHenknRireki() {
        return syuunouHenknRireki;
    }

    public IT_Kariukekin getKariukekin() {
        return kariukekin;
    }

    public void exec(
        KhozenCommonParam pKhCParm,
        NyuukinTRParam pNyknTRParam,
        C_YouhiKbn pKosYouhi,
        C_YouhiKbn pNkinKakuSksYh,
        AnsyuuBatSyoriHunoKykMisslistSks pAnsyuuBatSyoriHunoKykMisslistSks) {

        logger.debug("▽ 入金共通処理 開始");

        syoNo = pNyknTRParam.getSyoNo();
        syuudaikocd = pNyknTRParam.getSyuudaikocd();
        syoriYmd = pNyknTRParam.getSyoriYmd();
        nyuukinKakusyounrkYmd = pNyknTRParam.getNyuukinKakusyounrkYmd();
        nykKeiro = pNyknTRParam.getNykKeiro();
        nykHrkKaisuu = pNyknTRParam.getHrkkaisuu();
        nykNaiyouKbn = pNyknTRParam.getNykNaiyouKbn();
        iktnyuukinnUmu = pNyknTRParam.getIktnyuukinnumu();
        jyutouYm = pNyknTRParam.getJyutouYm();

        String tempJyutouKaisuuY = pNyknTRParam.getJyutouKaisuuY();

        if (BizUtil.isBlank(tempJyutouKaisuuY)) {
            jyutouKaisuuY = 0;
        }
        else {
            jyutouKaisuuY = Integer.parseInt(tempJyutouKaisuuY);
        }

        jyutouKaisuuM = Integer.parseInt(pNyknTRParam.getJyutouKaisuuM());
        ryosyuGk = pNyknTRParam.getRyosyuGk();
        ryosyuYmd = pNyknTRParam.getRyosyuYmd();
        kzHurikaeBankCd = pNyknTRParam.getKzHurikaeBankCd();
        kzHurikaeSitenCd = pNyknTRParam.getKzHurikaeSitenCd();
        suitoSoshikiCd = pNyknTRParam.getSuitoSoshikiCd();
        zengetumatuDenSimeYmd = pNyknTRParam.getZengetumatuDenSimeYmd();
        nykhouhouKbn = pNyknTRParam.getNykhouhouKbn();
        errorKbn = C_ErrorKbn.ERROR;
        commonNyuukinErrorRiyuuKbn = C_CommonNyuukinErrorRiyuuKbn.BLNK;
        krkRiyuuKbn = C_KrkriyuuKbn.BLNK;
        gyoumuKosKinouId = pKhCParm.getFunctionId();
        gyoumuKosId = pKhCParm.getUserID();
        sysTime = BizDate.getSysDateTimeMilli();
        krkGk = BizCurrency.valueOf(0);
        pdfOutYouhi = pNyknTRParam.getPdfOutYouhi();
        pdfOutUmuKbn = C_UmuKbn.NONE;
        tyohyoKey = BLANK;
        khCParm = pKhCParm;
        henkouSikibetuKey = BLANK;
        syouhinCd = BLANK;
        syouhinSdNo = 0;
        itKhDenpyoDatas = new ArrayList<IT_KhDenpyoData>();
        itKhFBSoukinData = null;
        itNyuukinKakusyouData = null;
        nyuukinKakusyouSakuseiYh = pNkinKakuSksYh;
        jidonhnknumu = false;
        konkiPYhFlg = false;
        tikiktbrisyuruikbn = pNyknTRParam.getTkiktbrisyuruiKbn();
        denymd = pNyknTRParam.getDenymd();
        updategoJkipjytYm = null;
        nyknKwsrateKijyunYmd = pNyknTRParam.getNyknkwsratekijyunymd();
        seisantgkmkHasseidenYmd = pNyknTRParam.getSeisantgkmkHasseidenYmd();
        tabakarikanjyono = pNyknTRParam.getTabakarikanjyono();
        kykJyoutai = C_Kykjyoutai.BLNK;
        seitouGk = BizCurrency.valueOf(0);
        syuunouHenknRireki = null;
        kariukekin = null;
        creditkessaiyouno = pNyknTRParam.getCreditkessaiyouno();
        keisanRsgkUtiwakeBeanList = new ArrayList<KeisanRsgkUtiwakeBean>();
        creditUriageSeikyuuKbn = pNyknTRParam.getCreditUriageSeikyuuKbn();

        if (C_KinouKbn.ONLINE.eq(asKinou.getKinouKbn())) {
            itKykKihon = pKhCParm.getKeiyakuKihonInfo(syoNo);
        }
        else {
            itKykKihon = pKhCParm.getBatchKeiyakuKihon();
        }

        if (C_KinouKbn.ONLINE.eq(asKinou.getKinouKbn())) {
            itAnsyuKihon = pKhCParm.getAnsyuuKihonInfo(syoNo);
        }
        else {
            itAnsyuKihon = pKhCParm.getBatchAnsyuKihon();
        }

        int annaiNo = 0;
        C_UmuKbn ansyuRrkExistFlag = C_UmuKbn.NONE;

        if (C_KinouKbn.BATCH.eq(asKinou.getKinouKbn()) &&
            (C_Nykkeiro.KZHRK.eq(nykKeiro) ||
                (C_Nykkeiro.CREDIT.eq(nykKeiro) &&
                    C_CreditUriageSeikyuuKbn.TUUJYOU.eq(creditUriageSeikyuuKbn)) ||
                    C_Nykkeiro.CONVENI.eq(nykKeiro))) {

            if (itAnsyuKihon != null) {

                List<IT_AnsyuRireki> ansyuRirekiLst = commonNyuukinDao.getAnsyuRirekis(itAnsyuKihon, nykNaiyouKbn,
                    jyutouYm, nykKeiro, jyutouKaisuuY, jyutouKaisuuM, C_AnnaijkKbn.ANNAI, ryosyuYmd);

                if (ansyuRirekiLst.size() > 0) {

                    ansyuRrkExistFlag = C_UmuKbn.ARI;
                    annaiNo = ansyuRirekiLst.get(0).getAnnaino();
                    nykHrkKaisuu = ansyuRirekiLst.get(0).getHrkkaisuu();
                }
            }
        }

        nyuukinCheck(pAnsyuuBatSyoriHunoKykMisslistSks);

        if (C_YouhiKbn.HUYOU.eq(pKosYouhi)
            || C_ErrorKbn.ERROR.eq(errorKbn)) {

            outputDebugLog();

            logger.debug("△ 入金共通処理 終了");

            return;
        }

        jidonhnknumu = hanteiHenkin();

        HenkanTuuka henkanTuuka = SWAKInjector.getInstance(HenkanTuuka.class);

        rstuukasyu = henkanTuuka.henkanTuukaTypeToKbn(ryosyuGk.getType());

        if (C_NyknaiyouKbn.KEIZOKUP.eq(nykNaiyouKbn)) {

            keizkPNyuukin();
        }
        else if (C_NyknaiyouKbn.ZENNOUP.eq(nykNaiyouKbn)) {

            zennouPNyuukin();
        }
        else {

            sonotaNyuukin();
        }

        if (C_UmuKbn.ARI.eq(ansyuRrkExistFlag)) {

            IT_AnsyuRireki ansyuRireki = commonNyuukinDao.getAnsyuRireki(itAnsyuKihon, nykNaiyouKbn, jyutouYm, annaiNo);

            if (!C_KrkriyuuKbn.BLNK.eq(krkRiyuuKbn) && !jidonhnknumu) {
                ansyuRireki.setKrkkeijyoflg(C_UmuKbn.ARI);
                ansyuRireki.setKrkkeijyoymd(syoriYmd);
                ansyuRireki.setKrkno(krkNo);
            }
            ansyuRireki.setAnnaijkkbn(C_AnnaijkKbn.NYUUKIN);
            ansyuRireki.setNyksyoriymd(syoriYmd);
            ansyuRireki.setGyoumuKousinKinou(gyoumuKosKinouId);
            ansyuRireki.setGyoumuKousinsyaId(gyoumuKosId);
            ansyuRireki.setGyoumuKousinTime(sysTime);

            if (C_Nykkeiro.CREDIT.eq(nykKeiro)) {
                ansyuRireki.setCredituriagengjiyuu(C_CreditUriageNgJiyuuKbn.SEIJYOU);
            }
        }

        EditJimuRenrakusyuunouParam editJimuRenrakusyuunouParam = SWAKInjector.getInstance(EditJimuRenrakusyuunouParam.class);
        EditJimuRenrakusyuunou editJimuRenrakusyuunou = SWAKInjector.getInstance(EditJimuRenrakusyuunou.class);
        CreateReport createReport = SWAKInjector.getInstance(CreateReport.class);

        if(!C_KrkriyuuKbn.BLNK.eq(krkRiyuuKbn) && !jidonhnknumu) {


            String krkRiyuuKbnNm = krkRiyuuKbn.getContent();
            String nykHrkKaisuuNm = nykHrkKaisuu.getContent();
            String tikiktbrisyuruikbnNm = tikiktbrisyuruikbn.getContent();
            String nykKeiroCnv = getNykKeiroCnv();
            String nykNaiyouKbnCnv = getNykNaiyouKbnCnv();

            String jyutouYmWk = BLANK;
            if (jyutouYm != null){
                jyutouYmWk = getJyutouYMCnv();
            }

            String kariGk = BLANK;
            if (C_KrkriyuuKbn.KAZYOUNYKN.eq(krkRiyuuKbn)){
                kariGk = BizUtil.comma(kajyoukin.toString());
            }
            else {
                kariGk = BizUtil.comma(ryosyuGk.toString());
            }

            String ryosyuYMD = getRyosyuYMDCnv();

            String dispCreditkessaiyouno = BLANK;

            if (!BizUtil.isBlank(creditkessaiyouno)) {

                CreditKessaiyouNoHensyuu creditKessaiyouNoHensyuu =
                    SWAKInjector.getInstance(CreditKessaiyouNoHensyuu.class);
                dispCreditkessaiyouno = creditKessaiyouNoHensyuu.exec(creditkessaiyouno);
            }


            List<String> jimuRenrakuhyou = new ArrayList<>();
            jimuRenrakuhyou.add("仮受金に計上しました");
            jimuRenrakuhyou.add("");
            jimuRenrakuhyou.add("仮受番号／" + krkNo);
            jimuRenrakuhyou.add("仮受理由区分／" + krkRiyuuKbnNm);
            jimuRenrakuhyou.add("払込回数／" + nykHrkKaisuuNm);
            jimuRenrakuhyou.add(
                "定期一括払種類区分／" + tikiktbrisyuruikbnNm);
            jimuRenrakuhyou.add("入金経路／" + nykKeiroCnv);
            jimuRenrakuhyou.add("入金内容区分／" + nykNaiyouKbnCnv);
            if (jyutouYm == null){
                jimuRenrakuhyou.add("充当年月／");
            }
            else {
                jimuRenrakuhyou.add("充当年月／" + jyutouYmWk);
            }
            if (jyutouKaisuuM == 0){
                if (jyutouKaisuuY == 0){
                    jimuRenrakuhyou.add("充当回数／" );
                }
                else {
                    jimuRenrakuhyou.add("充当回数／" + jyutouKaisuuY + "年");
                }
            }
            else {
                if (jyutouKaisuuY == 0){
                    jimuRenrakuhyou.add("充当回数／" + jyutouKaisuuM + "ヵ月");
                }
                else {
                    jimuRenrakuhyou.add("充当回数／" + jyutouKaisuuY + "年" + jyutouKaisuuM + "ヵ月");
                }
            }
            jimuRenrakuhyou.add("仮受金額／" + kariGk + "円");
            jimuRenrakuhyou.add("領収日／" + ryosyuYMD);
            jimuRenrakuhyou.add("決済用番号／" + dispCreditkessaiyouno);

            editJimuRenrakusyuunouParam.setJimurenrakuMsgList(jimuRenrakuhyou);

            ReportServicesBean reportServicesBean = editJimuRenrakusyuunou.exec(khCParm, syoNo,
                C_SyoruiCdKbn.AS_JIMURENRAKU_SYUUNOU, editJimuRenrakusyuunouParam, syoriYmd);

            tyohyoKey = createReport.execNoCommit(reportServicesBean);

            if (C_YouhiKbn.YOU.eq(pdfOutYouhi)) {
                pdfOutUmuKbn = C_UmuKbn.ARI;
            }
            else {
                pdfOutUmuKbn = C_UmuKbn.NONE;
            }
        }

        outputDebugLog();

        logger.debug("△ 入金共通処理 終了");
    }

    private void nyuukinCheck(AnsyuuBatSyoriHunoKykMisslistSks pAnsyuuBatSyoriHunoKykMisslistSks) {

        List<IT_KykSyouhn> wkkykSyouhnLst =  null;
        IT_KykSya itKykSya = null;
        BizDateYM hrkManYm = null;
        BizDateYM kouryokuHasseiYm = null;
        C_TkiktbrisyuruiKbn  tkiktbrisyuruiKbn = C_TkiktbrisyuruiKbn.BLNK;

        if (itKykKihon != null) {

            wkkykSyouhnLst = commonNyuukinDao.getKykSyouhns(itKykKihon);

            itKykSya = itKykKihon.getKykSya();

        }

        if (itKykKihon == null || wkkykSyouhnLst.size() == 0 || itAnsyuKihon == null || itKykSya == null) {

            if (C_Nykkeiro.KYHKIN.eq(nykKeiro) || C_Nykkeiro.HKNKIN.eq(nykKeiro)) {

                String nykKeiroCnv = getNykKeiroCnv();

                throw new CommonBizAppException("契約情報が取得できません。証券番号＝" + syoNo +
                    "　入金経路＝" + nykKeiroCnv);

            }

            BizDate nykdenpyoYMD = setNykdenymd();

            AnsyuuCommonSiwakeInBean ansyuuCommonSiwakeInBean = SWAKInjector.getInstance(AnsyuuCommonSiwakeInBean.class);
            AnsyuuTaisyouGkBean ansyuuTaisyouGkBean1 = SWAKInjector.getInstance(AnsyuuTaisyouGkBean.class);
            AnsyuuTaisyouGkBean ansyuuTaisyouGkBean2 = SWAKInjector.getInstance(AnsyuuTaisyouGkBean.class);
            List<AnsyuuTaisyouGkBean> ansyuuTaisyouGkBeanLst = new ArrayList<AnsyuuTaisyouGkBean>();

            ansyuuCommonSiwakeInBean.setKinouId(gyoumuKosKinouId);
            ansyuuCommonSiwakeInBean.setDensysKbn(C_DensysKbn.HOZEN);
            ansyuuCommonSiwakeInBean.setSyouhinCd(null);
            ansyuuCommonSiwakeInBean.setSyouhnsdno(null);
            ansyuuCommonSiwakeInBean.setDenYmd(nykdenpyoYMD);
            ansyuuCommonSiwakeInBean.setSyoriYmd(syoriYmd);
            ansyuuCommonSiwakeInBean.setNykkeiro(nykKeiro);
            ansyuuCommonSiwakeInBean.setSyono(syoNo);
            ansyuuCommonSiwakeInBean.setSyuudaikoCd(syuudaikocd);

            ansyuuTaisyouGkBean1.setKhDengkSyuruiKbn(C_KhDengkSyuruiKbn.HOZEN_RYOUSYUGK);
            ansyuuTaisyouGkBean1.setTaisyouGk(ryosyuGk);
            ansyuuTaisyouGkBean1.setKeiyakutuukaGk(ryosyuGk);

            ansyuuTaisyouGkBeanLst.add(ansyuuTaisyouGkBean1);

            ansyuuTaisyouGkBean2.setKhDengkSyuruiKbn(C_KhDengkSyuruiKbn.KEIJYOUK_KARIUKEGK);
            ansyuuTaisyouGkBean2.setTaisyouGk(ryosyuGk);
            ansyuuTaisyouGkBean2.setKeiyakutuukaGk(ryosyuGk);

            ansyuuTaisyouGkBeanLst.add(ansyuuTaisyouGkBean2);

            ansyuuCommonSiwakeInBean.setAnsyuuTaisyouGkBeanLst(ansyuuTaisyouGkBeanLst);

            List<IT_KhDenpyoData> khDenpyoDataLst = createDenpyoData(ansyuuCommonSiwakeInBean);

            itKhDenpyoDatas.addAll(khDenpyoDataLst);

            if (C_YouhiKbn.YOU.eq(nyuukinKakusyouSakuseiYh)) {

                createNyuukinKakusyouData(khDenpyoDataLst, nykdenpyoYMD);
            }

            errorKbn = C_ErrorKbn.ERROR;
            commonNyuukinErrorRiyuuKbn = C_CommonNyuukinErrorRiyuuKbn.KYKHUZAIERROR;

            return;

        }
        hrkP = itKykKihon.getHrkp();
        hrkKaisuu = itKykKihon.getHrkkaisuu();
        henkouSikibetuKey = wkkykSyouhnLst.get(0).getHenkousikibetukey();
        ykSymtuKbn = wkkykSyouhnLst.get(0).getYuukousyoumetukbn();
        syoumetuJiyuu = wkkykSyouhnLst.get(0).getSyoumetujiyuu();
        kykJyoutai = wkkykSyouhnLst.get(0).getKykjyoutai();
        kykYmd = wkkykSyouhnLst.get(0).getKykymd();
        syouhinCd = wkkykSyouhnLst.get(0).getSyouhncd();
        syouhinSdNo = wkkykSyouhnLst.get(0).getSyouhnsdno();
        jkiPJytYm = itAnsyuKihon.getJkipjytym();
        hrkManYm = itAnsyuKihon.getSyuharaimanymd().getBizDateYM();
        kouryokuHasseiYm = wkkykSyouhnLst.get(0).getKouryokuhasseiymd().getBizDateYM();
        tsinyno = itKykSya.getTsinyno();
        tsinadr1kj = itKykSya.getTsinadr1kj();
        tsinadr2kj = itKykSya.getTsinadr2kj();
        tsinadr3kj = itKykSya.getTsinadr3kj();
        kyknmkj = itKykSya.getKyknmkj();
        tkiktbrisyuruiKbn = itKykKihon.getTikiktbrisyuruikbn();

        IT_DattaiUktk itDattaiUktk = commonNyuukinDao.getDattaiUktk(itAnsyuKihon);

        List<IT_Kariukekin> itKariukekinLst = commonNyuukinDao.getKariukekins(itKykKihon);

        kykSyouhnLst = commonNyuukinDao.getKykSyouhns2(itKykKihon);


        if (!C_Nykkeiro.KYHKIN.eq(nykKeiro) && !C_Nykkeiro.HKNKIN.eq(nykKeiro)) {
            boolean setFlg = false;

            if (C_NykhouhouKbn.KARIUKEKEIJYOU.eq(nykhouhouKbn)) {

                krkRiyuuKbn = C_KrkriyuuKbn.HENKOUMATI;
                setFlg = true;
            }

            if (!setFlg) {
                HanteiTetuduki hanteiTetuduki = SWAKInjector.getInstance(HanteiTetuduki.class);

                C_SyorikahiKbn syorikahiKbn = hanteiTetuduki.exec(khCParm, syoNo);

                if (C_SyorikahiKbn.TYUUITRATKIKA.eq(syorikahiKbn)) {

                    krkRiyuuKbn = C_KrkriyuuKbn.HONSYASYOUKAIHTY;
                    setFlg = true;
                }
            }

            if (!setFlg) {
                if (C_NyknaiyouKbn.HARAIHENYOUP.eq(nykNaiyouKbn)) {
                    krkRiyuuKbn = C_KrkriyuuKbn.HRHN_SYORIHTY;
                    setFlg = true;
                }
                else if (C_NyknaiyouKbn.KEIZOKUP.eq(nykNaiyouKbn) || C_NyknaiyouKbn.ZENNOUP.eq(nykNaiyouKbn)) {
                }
                else if (C_NyknaiyouKbn.OTHER.eq(nykNaiyouKbn)) {
                    krkRiyuuKbn = C_KrkriyuuKbn.NYKNNAIYOUSOUI;
                    setFlg = true;
                }
                else if (C_NyknaiyouKbn.HOZENHENKOUYOUP.eq(nykNaiyouKbn)) {
                    krkRiyuuKbn = C_KrkriyuuKbn.HENKOUMATI;
                    setFlg = true;
                }
                else {
                    krkRiyuuKbn = C_KrkriyuuKbn.HENKOUMATI;
                    setFlg = true;
                }
            }

            if (!setFlg) {
                if (ryosyuYmd == null ||
                    BizDateUtil.compareYmd(ryosyuYmd, syoriYmd) == BizDateUtil.COMPARE_GREATER) {
                    krkRiyuuKbn = C_KrkriyuuKbn.RYSYBIMISS;
                    setFlg = true;
                }
                else {
                    if (C_NykhouhouKbn.KARIUKE.eq(nykhouhouKbn)) {
                        if (BizDateUtil.compareYmd(ryosyuYmd, syoriYmd.addMonths(-4).getRekijyou()) ==
                            BizDateUtil.COMPARE_LESSER) {
                            krkRiyuuKbn = C_KrkriyuuKbn.RYSYBIMISS;
                            setFlg = true;
                        }
                    }
                    else {
                        if (BizDateUtil.compareYmd(ryosyuYmd, syoriYmd.addMonths(-3).getRekijyou()) ==
                            BizDateUtil.COMPARE_LESSER) {
                            krkRiyuuKbn = C_KrkriyuuKbn.RYSYBIMISS;
                            setFlg = true;
                        }
                    }
                }
            }

            if (!setFlg) {
                if (C_NyknaiyouKbn.ZENNOUP.eq(nykNaiyouKbn)) {
                    if (C_Hrkkaisuu.NEN.eq(nykHrkKaisuu) &&
                        C_UmuKbn.NONE.eq(iktnyuukinnUmu) &&
                        jyutouKaisuuY >= 2 &&
                        jyutouKaisuuM == 0) {
                    }
                    else {
                        krkRiyuuKbn = C_KrkriyuuKbn.ZYUTOUSUUSOUI;
                        setFlg = true;
                    }
                }
                else {

                    if (C_TkiktbrisyuruiKbn.TEIKI_6MONTHS.eq(tikiktbrisyuruikbn)) {
                        if (C_Hrkkaisuu.TUKI.eq(nykHrkKaisuu) &&
                            C_UmuKbn.ARI.eq(iktnyuukinnUmu) &&
                            jyutouKaisuuY == 0 &&
                            (jyutouKaisuuM == 6 || jyutouKaisuuM == 12)) {

                        }
                        else {
                            krkRiyuuKbn = C_KrkriyuuKbn.ZYUTOUSUUSOUI;
                            setFlg = true;
                        }
                    }
                    else if (C_TkiktbrisyuruiKbn.TEIKI_12MONTHS.eq(tikiktbrisyuruikbn)) {
                        if (C_Hrkkaisuu.TUKI.eq(nykHrkKaisuu) &&
                            C_UmuKbn.ARI.eq(iktnyuukinnUmu) &&
                            jyutouKaisuuY == 0 &&
                            jyutouKaisuuM == 12) {

                        }
                        else {
                            krkRiyuuKbn = C_KrkriyuuKbn.ZYUTOUSUUSOUI;
                            setFlg = true;
                        }
                    }
                    else {
                        //                        if (C_Nykkeiro.KYHKIN.eq(nykKeiro) || C_Nykkeiro.HKNKIN.eq(nykKeiro)) {
                        //                            if (C_Hrkkaisuu.TUKI.eq(nykHrkKaisuu)
                        //                                && C_UmuKbn.NONE.eq(iktnyuukinnUmu)
                        //                                && jyutouKaisuuY == 0
                        //                                && jyutouKaisuuM >= 1) {
                        //                            }
                        //                            else if (C_Hrkkaisuu.HALFY.eq(nykHrkKaisuu)
                        //                                && C_UmuKbn.NONE.eq(iktnyuukinnUmu)
                        //                                && jyutouKaisuuY == 0
                        //                                && jyutouKaisuuM >= 6
                        //                                && jyutouKaisuuM % 6 == 0) {
                        //                            }
                        //                            else if (C_Hrkkaisuu.HALFY.eq(nykHrkKaisuu)
                        //                                && C_UmuKbn.ARI.eq(iktnyuukinnUmu)
                        //                                && jyutouKaisuuY == 0
                        //                                && jyutouKaisuuM >= 1
                        //                                && jyutouKaisuuM <= 5) {
                        //                            }
                        //                            else if (C_Hrkkaisuu.NEN.eq(nykHrkKaisuu)
                        //                                && C_UmuKbn.NONE.eq(iktnyuukinnUmu)
                        //                                && jyutouKaisuuY >= 1
                        //                                && jyutouKaisuuM == 0) {
                        //                            }
                        //                            else if (C_Hrkkaisuu.NEN.eq(nykHrkKaisuu)
                        //                                && C_UmuKbn.ARI.eq(iktnyuukinnUmu)
                        //                                && jyutouKaisuuY == 0
                        //                                && jyutouKaisuuM >= 1
                        //                                && jyutouKaisuuM <= 11) {
                        //                            }
                        //                            else {
                        //                                krkRiyuuKbn = C_KrkriyuuKbn.ZYUTOUSUUSOUI;
                        //                                setFlg = true;
                        //                            }
                        //                        }

                        if (C_Nykkeiro.BANK.eq(nykKeiro)
                            || C_Nykkeiro.OTHER.eq(nykKeiro)) {
                            if (C_Hrkkaisuu.TUKI.eq(nykHrkKaisuu)
                                && C_UmuKbn.NONE.eq(iktnyuukinnUmu)
                                && jyutouKaisuuY == 0
                                && jyutouKaisuuM >= 1
                                && jyutouKaisuuM <= 12) {
                            }
                            else if (C_Hrkkaisuu.TUKI.eq(nykHrkKaisuu)
                                && C_UmuKbn.NONE.eq(iktnyuukinnUmu)
                                && jyutouKaisuuY == 0
                                && jyutouKaisuuM >= 13) {
                                krkRiyuuKbn = C_KrkriyuuKbn.HONSYASYOUKAIHTY;
                                setFlg = true;
                            }
                            else if (C_Hrkkaisuu.TUKI.eq(nykHrkKaisuu)
                                && C_UmuKbn.ARI.eq(iktnyuukinnUmu)
                                && jyutouKaisuuY == 0
                                && jyutouKaisuuM >= 3
                                && jyutouKaisuuM <= 12) {
                            }
                            else if (C_Hrkkaisuu.TUKI.eq(nykHrkKaisuu)
                                && C_UmuKbn.ARI.eq(iktnyuukinnUmu)
                                && jyutouKaisuuY == 0
                                && jyutouKaisuuM >= 13) {
                                krkRiyuuKbn = C_KrkriyuuKbn.HONSYASYOUKAIHTY;
                                setFlg = true;
                            }
                            else if (C_Hrkkaisuu.HALFY.eq(nykHrkKaisuu)
                                && C_UmuKbn.NONE.eq(iktnyuukinnUmu)
                                && jyutouKaisuuY == 0
                                && (jyutouKaisuuM == 6 || jyutouKaisuuM == 12)) {
                            }
                            else if (C_Hrkkaisuu.NEN.eq(nykHrkKaisuu)
                                && C_UmuKbn.NONE.eq(iktnyuukinnUmu)
                                && jyutouKaisuuY >= 1
                                && jyutouKaisuuM == 0) {
                            }
                            else {
                                krkRiyuuKbn = C_KrkriyuuKbn.ZYUTOUSUUSOUI;
                                setFlg = true;
                            }
                        }
                        else if (C_Nykkeiro.KZHRK.eq(nykKeiro)) {
                            if (C_Hrkkaisuu.TUKI.eq(nykHrkKaisuu)
                                && C_UmuKbn.NONE.eq(iktnyuukinnUmu)
                                && jyutouKaisuuY == 0
                                && jyutouKaisuuM >= 1
                                && jyutouKaisuuM <= 12) {
                            }
                            else if (C_Hrkkaisuu.HALFY.eq(nykHrkKaisuu)
                                && C_UmuKbn.NONE.eq(iktnyuukinnUmu)
                                && jyutouKaisuuY == 0
                                && (jyutouKaisuuM == 6 || jyutouKaisuuM ==12)) {
                            }
                            else if (C_Hrkkaisuu.NEN.eq(nykHrkKaisuu)
                                && C_UmuKbn.NONE.eq(iktnyuukinnUmu)
                                && jyutouKaisuuY == 1
                                && jyutouKaisuuM == 0) {
                            }
                            else {
                                krkRiyuuKbn = C_KrkriyuuKbn.ZYUTOUSUUSOUI;
                                setFlg = true;
                            }
                        }
                        else if (C_Nykkeiro.CREDIT.eq(nykKeiro)) {
                            if (C_Hrkkaisuu.TUKI.eq(nykHrkKaisuu)
                                && C_UmuKbn.NONE.eq(iktnyuukinnUmu)
                                && jyutouKaisuuY == 0
                                && jyutouKaisuuM >= 1
                                && jyutouKaisuuM <= 12) {
                            }
                            else {
                                krkRiyuuKbn = C_KrkriyuuKbn.ZYUTOUSUUSOUI;
                                setFlg = true;
                            }
                        }
                        else {
                            krkRiyuuKbn = C_KrkriyuuKbn.OHTHER;
                            setFlg = true;
                        }
                    }
                }
            }

            if (!setFlg) {
                if (C_Hrkkaisuu.TUKI.eq(nykHrkKaisuu)) {

                    if (C_TkiktbrisyuruiKbn.NONE.eq(tikiktbrisyuruikbn) ||
                        C_TkiktbrisyuruiKbn.BLNK.eq(tikiktbrisyuruikbn)) {

                        Integer jyuutoutuKisuu =  jyutouKaisuuY * 12 + jyutouKaisuuM;

                        KeisanIkkatuWaribikiKikan keisanIkkatuWaribikiKikan = SWAKInjector.getInstance(KeisanIkkatuWaribikiKikan.class);
                        keisanIkkatuWaribikiKikan.exec(ryosyuYmd, jyutouYm, jyuutoutuKisuu);

                        Integer wrbkTekikknTksu = keisanIkkatuWaribikiKikan.getWrbkTekikknTksu();

                        if (wrbkTekikknTksu >= 3) {
                            krkRiyuuKbn = C_KrkriyuuKbn.ZYUTOUSUUSOUI;

                            setFlg = true;
                        }
                    }
                }
            }

            if (!setFlg) {
                if (itKariukekinLst.size() > 0) {
                    krkRiyuuKbn = C_KrkriyuuKbn.OTHERKR_ARI;
                    setFlg = true;
                }
            }

            if (!setFlg) {
                if (C_YuukousyoumetuKbn.SYOUMETU.eq(ykSymtuKbn)) {

                    //                    if (C_Nykkeiro.KYHKIN.eq(nykKeiro)) {
                    //                        if (C_Syoumetujiyuu.SIKKOU.eq(syoumetuJiyuu)) {
                    //                            krkRiyuuKbn = C_KrkriyuuKbn.SYOUMETUGONYKN;
                    //                            setFlg = true;
                    //                        }
                    //                        else {
                    //                            if (C_Hrkkaisuu.TUKI.eq(nykHrkKaisuu)) {
                    //                                krkRiyuuKbn = C_KrkriyuuKbn.BLNK;
                    //                                setFlg = true;
                    //                            }
                    //                            else {
                    //                                krkRiyuuKbn = C_KrkriyuuKbn.SYOUMETUGONYKN;
                    //                                setFlg = true;
                    //                            }
                    //                        }
                    //                    }

                    if (!C_Nykkeiro.KYHKIN.eq(nykKeiro)) {
                        krkRiyuuKbn = C_KrkriyuuKbn.SYOUMETUGONYKN;
                        setFlg = true;
                    }
                }
            }

            if (!setFlg) {
                if (itDattaiUktk != null) {
                    if (C_DattairiyuuKbn.KAIYAKUKIBOU.eq(itDattaiUktk.getDattairiyuukbn())) {
                        if (C_Nykkeiro.KZHRK.eq(nykKeiro) || C_Nykkeiro.CREDIT.eq(nykKeiro)) {
                            krkRiyuuKbn = C_KrkriyuuKbn.HENKINHITUYOU;
                            setFlg = true;
                        }
                        else {
                            krkRiyuuKbn = C_KrkriyuuKbn.HRKHOUHOUSOUI;
                            setFlg = true;
                        }
                    }
                    else if (C_DattairiyuuKbn.CSSKOUHURIIRHUBI.eq(itDattaiUktk.getDattairiyuukbn())) {
                    }
                    else {
                        krkRiyuuKbn = C_KrkriyuuKbn.HRKHOUHOUSOUI;
                        setFlg = true;
                    }
                }
            }

            if (!setFlg) {
                if (C_Kykjyoutai.PMEN.eq(kykJyoutai) || C_Kykjyoutai.ITIJIBARAI.eq(kykJyoutai)) {

                    krkRiyuuKbn = C_KrkriyuuKbn.KYUUSOKUTYUUNYKN;
                    setFlg = true;
                }
                else if (C_Kykjyoutai.ZENNOU.eq(kykJyoutai)) {

                    krkRiyuuKbn = C_KrkriyuuKbn.HRKHOUHOUSOUI;
                    setFlg = true;
                }
            }

            if (!setFlg) {
                if (BizDateUtil.compareYm(hrkManYm, jkiPJytYm) == BizDateUtil.COMPARE_EQUAL) {

                    krkRiyuuKbn = C_KrkriyuuKbn.KYUUSOKUTYUUNYKN;
                    setFlg = true;
                }
            }

            if (!setFlg) {
                if (!nykHrkKaisuu.eq(hrkKaisuu) || !tkiktbrisyuruiKbn.eq(tikiktbrisyuruikbn)) {

                    krkRiyuuKbn = C_KrkriyuuKbn.HRKKAISUUSOUI;
                    setFlg = true;
                }
            }

            if (!setFlg) {
                if (BizDateUtil.compareYm(jyutouYm, jkiPJytYm) != BizDateUtil.COMPARE_EQUAL) {

                    krkRiyuuKbn = C_KrkriyuuKbn.ZYUTOUTUKISOUI;
                    setFlg = true;
                }
            }

            if (!setFlg) {
                SetYuuyokknmanryobi setYuuyokknmanryobi = SWAKInjector.getInstance(SetYuuyokknmanryobi.class);
                setYuuyokknmanryobi.exec(syoNo, jyutouYm);
                BizDate yyKknMryYMD = setYuuyokknmanryobi.getTksnYuuyokknMnrybi();

                if (BizDateUtil.compareYmd(ryosyuYmd, yyKknMryYMD) == BizDateUtil.COMPARE_GREATER) {

                    krkRiyuuKbn = C_KrkriyuuKbn.YUYOKKNGONYKN;
                    setFlg = true;
                }
            }

            if (!setFlg) {
                BizDateYM tempYm = jyutouYm.addYears(jyutouKaisuuY).addMonths(jyutouKaisuuM);

                if (BizDateUtil.compareYm(hrkManYm, tempYm) == BizDateUtil.COMPARE_LESSER) {

                    krkRiyuuKbn = C_KrkriyuuKbn.ZYUTOUSUUSOUI;
                    setFlg = true;
                }
                else {
                    krkRiyuuKbn = C_KrkriyuuKbn.BLNK;
                    setFlg = true;
                }
            }

            //            if (!setFlg) {
            //                if (BizDateUtil.compareYm(jyutouYm, kouryokuHasseiYm) == BizDateUtil.COMPARE_LESSER) {
            //
            //                    krkRiyuuKbn = C_KrkriyuuKbn.HONSYASYOUKAIHTY;
            //                }
            //                else {
            //                    krkRiyuuKbn = C_KrkriyuuKbn.BLNK;
            //                }
            //            }

            if (C_KrkriyuuKbn.OHTHER.eq(krkRiyuuKbn)) {

                String nykKeiroCnv = getNykKeiroCnv();

                throw new CommonBizAppException("入金経路に誤りがあります。証券番号＝" + syoNo +
                    "　入金経路＝" + nykKeiroCnv);
            }
        }
        GetasPRsTuuka getasPRsTuuka = SWAKInjector.getInstance(GetasPRsTuuka.class);

        C_ErrorKbn asPRsTuukaErrorKbn = getasPRsTuuka.exec(syoNo);

        if (C_ErrorKbn.ERROR.eq(asPRsTuukaErrorKbn)) {

            pAnsyuuBatSyoriHunoKykMisslistSks.addErrerMsg(syoNo, "保険料領収通貨取得エラー。");

            errorKbn = C_ErrorKbn.ERROR;
            commonNyuukinErrorRiyuuKbn = C_CommonNyuukinErrorRiyuuKbn.SYORIHUNOERROR;

            return;
        }

        HenkanTuuka henkanTuuka = SWAKInjector.getInstance(HenkanTuuka.class);
        CurrencyType currencyType = henkanTuuka.henkanTuukaKbnToType(getasPRsTuuka.getRstuukasyu());

        if (C_NyknaiyouKbn.KEIZOKUP.eq(nykNaiyouKbn)) {

            if (C_Nykkeiro.HKNKIN.eq(nykKeiro)) {

                KeisanRsgkUtiwakeBean keisanRsgkUtiwakeBean = SWAKInjector.getInstance(KeisanRsgkUtiwakeBean.class);

                keisanRsgkUtiwakeBean.setJyutoustartym(jyutouYm);
                keisanRsgkUtiwakeBean.setJyuutounensuu(jyutouKaisuuY);
                keisanRsgkUtiwakeBean.setJyuutoutukisuu(jyutouKaisuuM);
                keisanRsgkUtiwakeBean.setRsgaku(BizCurrency.valueOf(0, currencyType));
                keisanRsgkUtiwakeBean.setIktnyuukinnumu(iktnyuukinnUmu);
                keisanRsgkUtiwakeBean.setIktwaribikikgk(BizCurrency.valueOf(0, currencyType));

                keisanRsgkUtiwakeBeanList.add(keisanRsgkUtiwakeBean);

                seitouGk = ryosyuGk;
            }
            else {
                if (C_KrkriyuuKbn.BLNK.eq(krkRiyuuKbn)) {

                    KeisanRsgaku keisanRsgaku = SWAKInjector.getInstance(KeisanRsgaku.class);

                    C_ErrorKbn keisanRsgakuErrorKbn = keisanRsgaku.exec(
                        itKykKihon,
                        nykKeiro,
                        nykNaiyouKbn,
                        ryosyuYmd,
                        jyutouYm,
                        jyutouKaisuuY,
                        jyutouKaisuuM);

                    if (C_ErrorKbn.OK.eq(keisanRsgakuErrorKbn)) {

                        KeisanRsgkOutBean keisanRsgkOutBean = keisanRsgaku.getKeisanRsgkOutBean();
                        seitouGk = keisanRsgkOutBean.getRsgakuGoukei();
                        keisanRsgkUtiwakeBeanList = keisanRsgkOutBean.getKeisanRsgkUtiwakeBeanLst();
                    }

                    else {

                        if (pAnsyuuBatSyoriHunoKykMisslistSks == null) {

                            throw new CommonBizAppException("領収金額計算エラー。エラー理由＝" + keisanRsgaku.getErrorRiyuu() + "　証券番号＝" + syoNo);
                        }

                        pAnsyuuBatSyoriHunoKykMisslistSks.addErrerMsg(syoNo, "領収金額計算エラー。エラー理由＝" + keisanRsgaku.getErrorRiyuu());

                        errorKbn = C_ErrorKbn.ERROR;
                        commonNyuukinErrorRiyuuKbn = C_CommonNyuukinErrorRiyuuKbn.SYORIHUNOERROR;

                        return;
                    }
                }
                else {

                    seitouGk = BizCurrency.valueOf(0, currencyType);
                }
            }
        }
        else if (C_NyknaiyouKbn.ZENNOUP.eq(nykNaiyouKbn)) {

            if (C_KrkriyuuKbn.BLNK.eq(krkRiyuuKbn)) {
                BizDateSpan kikan = BizDateUtil.calcDifference(
                    jkiPJytYm.addYears(-1).getBizDate(kykYmd.getDay()).getRekijyou(),
                    ryosyuYmd);
                int keikamon = kikan.getYears() * 12 + kikan.getMonths();

                if (kikan.getDays() > 15) {
                    keikamon = keikamon + 1;
                }
                if (keikamon > 11) {
                    konkiPYhFlg = true;
                }
                else {
                    konkiPYhFlg = false;
                }

                BizDate kykYmdWk = null;
                BizCurrency zennouhrkPWk = BizCurrency.valueOf(0);
                BizDate ryosyuYmdWk = null;
                BizDateYM jyutouYmWk = null;
                int jyutouNensuuWk = 0;
                BizCurrency seitouGkWk = BizCurrency.valueOf(0);

                if (konkiPYhFlg) {

                    kykYmdWk = kykYmd;
                    zennouhrkPWk = hrkP;
                    ryosyuYmdWk = jkiPJytYm.getFirstDay();
                    jyutouYmWk = jkiPJytYm.addYears(1);
                    jyutouNensuuWk = jyutouKaisuuY - 1;
                    seitouGkWk = hrkP;
                }
                else {

                    kykYmdWk = kykYmd;
                    zennouhrkPWk = hrkP;
                    ryosyuYmdWk = ryosyuYmd;
                    jyutouYmWk = jkiPJytYm;
                    jyutouNensuuWk = jyutouKaisuuY;
                    seitouGkWk = BizCurrency.valueOf(0);

                }

                //KeisanZennouNyuukinGk keisanZennouNyuukinGk =
                //    SWAKInjector.getInstance(KeisanZennouNyuukinGk.class);

                //errorKbn = keisanZennouNyuukinGk.execKeisanZennouNyuukinGk(
                //    kykYmdWk,
                //    zennouhrkPWk,
                //    ryosyuYmdWk,
                //    jyutouYmWk,
                //    jyutouNensuuWk);

                //if (C_ErrorKbn.ERROR.eq(errorKbn)) {
                //    throw new CommonBizAppException("前納入金額計算でエラーが発生しました。契約日＝" + kykYmdWk +
                //        "　前納時払込保険料＝" + zennouhrkPWk + "　領収日＝" + ryosyuYmdWk +
                //        "　充当年月＝" + jyutouYmWk + "　充当年数＝" + jyutouNensuuWk);
                //}

                //seitouGk = keisanZennouNyuukinGk.getZennouNyuukinGk().add(seitouGkWk);

            }
            else {
                seitouGk = BizCurrency.valueOf(0, currencyType);
            }
        }
        else {
            seitouGk = ryosyuGk;
        }

        if (C_KrkriyuuKbn.BLNK.eq(krkRiyuuKbn)) {

            boolean setFlg = false;

            if (ryosyuGk.compareTo(seitouGk) < 0) {

                krkRiyuuKbn = C_KrkriyuuKbn.HUSOKUNYKN;
                setFlg = true;
            }

            if (!setFlg) {

                if (C_NyknaiyouKbn.KEIZOKUP.eq(nykNaiyouKbn)) {
                    if (C_Hrkkaisuu.NEN.eq(nykHrkKaisuu) || C_Hrkkaisuu.HALFY.eq(nykHrkKaisuu)) {
                        if (BizDateUtil.compareYm(syoriYmd.getBizDateYM(), jyutouYm) == BizDateUtil.COMPARE_LESSER) {

                            krkRiyuuKbn = C_KrkriyuuKbn.KIGETUMAENYN;
                            setFlg = true;
                        }
                    }
                }
            }

            if (!setFlg) {
                if (ryosyuGk.compareTo(seitouGk) > 0) {

                    krkRiyuuKbn = C_KrkriyuuKbn.KAZYOUNYKN;
                }
            }
        }
        if (C_KrkriyuuKbn.KAZYOUNYKN.eq(krkRiyuuKbn)) {

            kajyoukin = ryosyuGk.subtract(seitouGk);
        }

        if(C_KrkriyuuKbn.BLNK.eq(krkRiyuuKbn)){
            krkGk = BizCurrency.valueOf(0);
        }
        else if(C_KrkriyuuKbn.KAZYOUNYKN.eq(krkRiyuuKbn)){
            krkGk = kajyoukin;
        }
        else {
            krkGk = ryosyuGk;
        }

        if(C_KrkriyuuKbn.BLNK.eq(krkRiyuuKbn) || C_KrkriyuuKbn.KAZYOUNYKN.eq(krkRiyuuKbn)){
            if (C_NyknaiyouKbn.KEIZOKUP.eq(nykNaiyouKbn)) {
                updategoJkipjytYm = jkiPJytYm.addYears(jyutouKaisuuY).addMonths(jyutouKaisuuM);
            }
            else if (C_NyknaiyouKbn.ZENNOUP.eq(nykNaiyouKbn)) {
                if (konkiPYhFlg) {
                    updategoJkipjytYm = jkiPJytYm.addYears(1);
                }
                else {
                    updategoJkipjytYm = jkiPJytYm;
                }
            }
        }
        else {
            updategoJkipjytYm = jkiPJytYm;
        }

        errorKbn = C_ErrorKbn.OK;
        commonNyuukinErrorRiyuuKbn = C_CommonNyuukinErrorRiyuuKbn.BLNK;
    }

    private void keizkPNyuukin() {

        BizDate nykdenpyoYMD = setNykdenymd();

        AnsyuuCommonSiwakeInBean ansyuuCommonSiwakeInBean = SWAKInjector.getInstance(AnsyuuCommonSiwakeInBean.class);
        AnsyuuTaisyouGkBean ansyuuTaisyouGkBean1 = SWAKInjector.getInstance(AnsyuuTaisyouGkBean.class);
        AnsyuuTaisyouGkBean ansyuuTaisyouGkBean2 = SWAKInjector.getInstance(AnsyuuTaisyouGkBean.class);
        AnsyuuTaisyouGkBean ansyuuTaisyouGkBean3 = SWAKInjector.getInstance(AnsyuuTaisyouGkBean.class);
        List<AnsyuuTaisyouGkBean> ansyuuTaisyouGkBeanLst = new ArrayList<AnsyuuTaisyouGkBean>();

        ansyuuCommonSiwakeInBean.setKinouId(gyoumuKosKinouId);
        ansyuuCommonSiwakeInBean.setDensysKbn(C_DensysKbn.HOZEN);
        ansyuuCommonSiwakeInBean.setSyouhinCd(syouhinCd);
        ansyuuCommonSiwakeInBean.setSyouhnsdno(syouhinSdNo);
        ansyuuCommonSiwakeInBean.setDenYmd(nykdenpyoYMD);
        ansyuuCommonSiwakeInBean.setSyoriYmd(syoriYmd);
        ansyuuCommonSiwakeInBean.setKykYmd(kykYmd);
        ansyuuCommonSiwakeInBean.setNykkeiro(nykKeiro);
        if (C_Nykkeiro.BANK.eq(nykKeiro) &&
            !C_NykhouhouKbn.KARIUKE.eq(nykhouhouKbn)) {
            ansyuuCommonSiwakeInBean.setSuitouSoshikiCd(suitoSoshikiCd);
        }
        ansyuuCommonSiwakeInBean.setSyono(syoNo);
        ansyuuCommonSiwakeInBean.setSyuudaikoCd(syuudaikocd);

        if (C_NykhouhouKbn.KARIUKE.eq(nykhouhouKbn) ||
            C_Nykkeiro.HKNKIN.eq(nykKeiro)) {
            ansyuuTaisyouGkBean1.setKhDengkSyuruiKbn(C_KhDengkSyuruiKbn.SEISANK_KARIUKEGK);
        }
        else {
            ansyuuTaisyouGkBean1.setKhDengkSyuruiKbn(C_KhDengkSyuruiKbn.HOZEN_RYOUSYUGK);
        }
        ansyuuTaisyouGkBean1.setTaisyouGk(ryosyuGk);
        ansyuuTaisyouGkBean1.setKeiyakutuukaGk(ryosyuGk);
        ansyuuTaisyouGkBeanLst.add(ansyuuTaisyouGkBean1);

        if (!C_KrkriyuuKbn.BLNK.eq(krkRiyuuKbn)) {

            ansyuuTaisyouGkBean2.setKhDengkSyuruiKbn(C_KhDengkSyuruiKbn.KEIJYOUK_KARIUKEGK);
            ansyuuTaisyouGkBean2.setTaisyouGk(krkGk);
            ansyuuTaisyouGkBean2.setKeiyakutuukaGk(krkGk);
            ansyuuTaisyouGkBeanLst.add(ansyuuTaisyouGkBean2);
        }

        if (C_KrkriyuuKbn.BLNK.eq(krkRiyuuKbn) || C_KrkriyuuKbn.KAZYOUNYKN.eq(krkRiyuuKbn)) {

            ansyuuTaisyouGkBean3.setKhDengkSyuruiKbn(C_KhDengkSyuruiKbn.KEIJYOUP);
            ansyuuTaisyouGkBean3.setTaisyouGk(seitouGk);
            ansyuuTaisyouGkBean3.setKeiyakutuukaGk(seitouGk);
            ansyuuTaisyouGkBean3.setHrkkaisuu(nykHrkKaisuu);
            ansyuuTaisyouGkBean3.setJyutouStartYm(jyutouYm);
            ansyuuTaisyouGkBean3.setJyutouKaisuuY(jyutouKaisuuY);
            ansyuuTaisyouGkBean3.setJyutouKaisuuM(jyutouKaisuuM);
            ansyuuTaisyouGkBeanLst.add(ansyuuTaisyouGkBean3);
        }
        ansyuuCommonSiwakeInBean.setAnsyuuTaisyouGkBeanLst(ansyuuTaisyouGkBeanLst);
        List<IT_KhDenpyoData> khDenpyoDataLst = createDenpyoData(ansyuuCommonSiwakeInBean);

        itKhDenpyoDatas.addAll(khDenpyoDataLst);

        String nykdenrenno = khDenpyoDataLst.get(0).getDenrenno();

        if (C_YouhiKbn.YOU.eq(nyuukinKakusyouSakuseiYh)) {

            createNyuukinKakusyouData(khDenpyoDataLst, nykdenpyoYMD);
        }

        if (C_KrkriyuuKbn.BLNK.eq(krkRiyuuKbn)
            || C_KrkriyuuKbn.KAZYOUNYKN.eq(krkRiyuuKbn)) {

            String sikibetuKey = khCParm.getSikibetuKey(syoNo);

            BizDateYM jyutouEndYM = null;

            for (KeisanRsgkUtiwakeBean keisanRsgkUtiwakeBean : keisanRsgkUtiwakeBeanList) {

                BizDateYM jyutouStartYM = keisanRsgkUtiwakeBean.getJyutoustartym();
                int jyutouKaisuuYWk = keisanRsgkUtiwakeBean.getJyuutounensuu();
                int jyutouKaisuuMWk = keisanRsgkUtiwakeBean.getJyuutoutukisuu();

                Integer renNo = 1;
                Integer renNoMax = commonNyuukinDao.getNyknJissekiRirekiMaxRenno(itKykKihon, jyutouStartYM);

                if (renNoMax != null){
                    renNo = renNoMax + 1;
                }

                HenkanTuuka henkanTuuka = SWAKInjector.getInstance(HenkanTuuka.class);

                C_Tuukasyu rsTuukasyu = henkanTuuka.henkanTuukaTypeToKbn(keisanRsgkUtiwakeBean.getRsgaku().getType());

                IT_NyknJissekiRireki nyknJissekiRireki = commonNyuukinDao.createNyknJissekiRireki(itKykKihon);

                nyknJissekiRireki.setRsgaku(keisanRsgkUtiwakeBean.getRsgaku());
                nyknJissekiRireki.setRstuukasyu(rsTuukasyu);
                nyknJissekiRireki.setRyosyukwsratekjymd(keisanRsgkUtiwakeBean.getRyosyukwsratekjymd());
                nyknJissekiRireki.setRyosyukwsrate(keisanRsgkUtiwakeBean.getRyosyukwsrate());
                nyknJissekiRireki.setHrkp(hrkP);
                nyknJissekiRireki.setIktwaribikikgk(keisanRsgkUtiwakeBean.getIktwaribikikgk());
                nyknJissekiRireki.setNyksyoriymd(syoriYmd);
                nyknJissekiRireki.setRyosyuymd(ryosyuYmd);
                nyknJissekiRireki.setNykdenno(nykdenrenno);
                nyknJissekiRireki.setNykdenymd(nykdenpyoYMD);
                nyknJissekiRireki.setNykkeiro(nykKeiro);
                nyknJissekiRireki.setHrkkaisuu(nykHrkKaisuu);
                nyknJissekiRireki.setJyutoukaisuuy(jyutouKaisuuYWk);
                nyknJissekiRireki.setJyutoukaisuum(jyutouKaisuuMWk);
                nyknJissekiRireki.setNyknaiyoukbn(nykNaiyouKbn);
                nyknJissekiRireki.setIktnyuukinnumu(keisanRsgkUtiwakeBean.getIktnyuukinnumu());
                nyknJissekiRireki.setHenkousikibetukey(henkouSikibetuKey);
                nyknJissekiRireki.setGyoumuKousinKinou(gyoumuKosKinouId);
                nyknJissekiRireki.setGyoumuKousinsyaId(gyoumuKosId);
                nyknJissekiRireki.setGyoumuKousinTime(sysTime);
                nyknJissekiRireki.setTikiktbrisyuruikbn(tikiktbrisyuruikbn);
                nyknJissekiRireki.setCreditkessaiyouno(creditkessaiyouno);

                jyutouEndYM = jyutouStartYM.addYears(jyutouKaisuuYWk).addMonths(jyutouKaisuuMWk).getPreviousMonth();
                nyknJissekiRireki.setJyutoustartym(jyutouStartYM);
                nyknJissekiRireki.setJyutouendym(jyutouEndYM);
                nyknJissekiRireki.setRenno(renNo);

                BizPropertyInitializer.initialize(nyknJissekiRireki);

                EditKoujyonaiyouTbl editKoujyonaiyouTbl = SWAKInjector.getInstance(EditKoujyonaiyouTbl.class);

                editKoujyonaiyouTbl.setIkkatuNyknUmu(keisanRsgkUtiwakeBean.getIktnyuukinnumu());
                editKoujyonaiyouTbl.setNyknJskStartYm(jyutouStartYM);
                editKoujyonaiyouTbl.setNyknJskEndYm(jyutouEndYM);
                editKoujyonaiyouTbl.setNyknJskRenno(renNo);
                editKoujyonaiyouTbl.setNyknJskRyosyuYmd(ryosyuYmd);
                editKoujyonaiyouTbl.setNyknJskJytKaisuuY(jyutouKaisuuYWk);
                editKoujyonaiyouTbl.setNyknJskJytKaisuuM(jyutouKaisuuMWk);
                editKoujyonaiyouTbl.setNyknJskRysKwsrate(keisanRsgkUtiwakeBean.getRyosyukwsrate());
                List<KykSyouhnCommonParam> kykSyouhnCommonParams = new ArrayList<>();
                kykSyouhnCommonParams.addAll(kykSyouhnLst);
                editKoujyonaiyouTbl.setKykSyouhnLst(kykSyouhnCommonParams);
                editKoujyonaiyouTbl.setNykkeiro(nykKeiro);

                editKoujyonaiyouTbl.exec(khCParm, syoNo,
                    C_KjsymnytblhensyuusyoriKbn.NYUUKINHANEI, syoriYmd);

                if (C_KinouKbn.ONLINE.eq(asKinou.getKinouKbn())) {

                    sikinIdouRirekiTblKosin(syoNo,
                        sikibetuKey,
                        gyoumuKosKinouId,
                        nykHrkKaisuu,
                        jyutouStartYM,
                        jyutouEndYM,
                        nykKeiro,
                        nykNaiyouKbn,
                        C_Nyktrksflg.BLNK);
                }
            }

            itAnsyuKihon.setJkipjytym(updategoJkipjytYm);
            itAnsyuKihon.setGyoumuKousinKinou(gyoumuKosKinouId);
            itAnsyuKihon.setGyoumuKousinsyaId(gyoumuKosId);
            itAnsyuKihon.setGyoumuKousinTime(sysTime);

            KoskyKjyoutai();

        }

        deleteTokusin(updategoJkipjytYm);

        if (jidonhnknumu) {
            if (C_Nykkeiro.CREDIT.eq(nykKeiro)) {

                creditHenkin();
            }
            else {

                kzHenkin();
            }
        }

        if (!C_KrkriyuuKbn.BLNK.eq(krkRiyuuKbn) && !jidonhnknumu) {
            createKariukekin(nykdenpyoYMD);
        }

        if (C_KrkriyuuKbn.BLNK.eq(krkRiyuuKbn) ||
            C_KrkriyuuKbn.KAZYOUNYKN.eq(krkRiyuuKbn)) {

            C_TsrysyoriKbn tsrySyoriKbn = C_TsrysyoriKbn.BLNK;

            if (C_YuukousyoumetuKbn.SYOUMETU.eq(ykSymtuKbn)) {
                tsrySyoriKbn = C_TsrysyoriKbn.SYOUMETUGOKZPNYUUKIN;
            }
            else {
                if (C_UmuKbn.ARI.eq(iktnyuukinnUmu)) {
                    tsrySyoriKbn = C_TsrysyoriKbn.IKKATUNYUUKIN;
                }
                else {
                    tsrySyoriKbn = C_TsrysyoriKbn.KEIZOKUPNYUUKIN;
                }
            }

            EditDairitenTesuuryouTbl editDairitenTesuuryouTbl = SWAKInjector.getInstance(EditDairitenTesuuryouTbl.class);
            if (C_KinouKbn.BATCH.eq(asKinou.getKinouKbn())) {
                editDairitenTesuuryouTbl.setBatchSyoriYmd(syoriYmd);
            }
            editDairitenTesuuryouTbl.exec(khCParm,
                syoNo,
                tsrySyoriKbn,
                jkiPJytYm,
                jyutouKaisuuY,
                jyutouKaisuuM,
                BizCurrency.valueOf(0),
                BizCurrency.valueOf(0),
                ryosyuYmd,
                null);
        }
    }

    private void zennouPNyuukin() {

        BizDate nykdenpyoYMD = setNykdenymd();

        BizCurrency keizkpp = BizCurrency.valueOf(0);
        BizCurrency zennoupp = seitouGk;
        BizDateYM zennoupjyutoustartym = jyutouYm;
        int zennoupjyutoukaisuuy = jyutouKaisuuY;

        if ((C_KrkriyuuKbn.BLNK.eq(krkRiyuuKbn) || C_KrkriyuuKbn.KAZYOUNYKN.eq(krkRiyuuKbn)) &&
            konkiPYhFlg) {

            keizkpp = hrkP;
            zennoupp = seitouGk.subtract(hrkP);
            zennoupjyutoustartym = jyutouYm.getNextYear();
            zennoupjyutoukaisuuy = jyutouKaisuuY - 1;
        }

        AnsyuuCommonSiwakeInBean ansyuuCommonSiwakeInBean = SWAKInjector.getInstance(AnsyuuCommonSiwakeInBean.class);
        AnsyuuTaisyouGkBean ansyuuTaisyouGkBean1 = SWAKInjector.getInstance(AnsyuuTaisyouGkBean.class);
        AnsyuuTaisyouGkBean ansyuuTaisyouGkBean2 = SWAKInjector.getInstance(AnsyuuTaisyouGkBean.class);
        AnsyuuTaisyouGkBean ansyuuTaisyouGkBean3 = SWAKInjector.getInstance(AnsyuuTaisyouGkBean.class);
        List<AnsyuuTaisyouGkBean> ansyuuTaisyouGkBeanLst = new ArrayList<AnsyuuTaisyouGkBean>();

        ansyuuCommonSiwakeInBean.setKinouId(gyoumuKosKinouId);
        ansyuuCommonSiwakeInBean.setDensysKbn(C_DensysKbn.HOZEN);
        ansyuuCommonSiwakeInBean.setSyouhinCd(syouhinCd);
        ansyuuCommonSiwakeInBean.setSyouhnsdno(syouhinSdNo);
        ansyuuCommonSiwakeInBean.setDenYmd(nykdenpyoYMD);
        ansyuuCommonSiwakeInBean.setSyoriYmd(syoriYmd);
        ansyuuCommonSiwakeInBean.setKykYmd(kykYmd);
        ansyuuCommonSiwakeInBean.setNykkeiro(nykKeiro);
        if (C_Nykkeiro.BANK.eq(nykKeiro) &&
            !C_NykhouhouKbn.KARIUKE.eq(nykhouhouKbn)) {
            ansyuuCommonSiwakeInBean.setSuitouSoshikiCd(suitoSoshikiCd);
        }
        ansyuuCommonSiwakeInBean.setSyono(syoNo);
        ansyuuCommonSiwakeInBean.setSyuudaikoCd(syuudaikocd);

        if (C_NykhouhouKbn.KARIUKE.eq(nykhouhouKbn)) {
            ansyuuTaisyouGkBean1.setKhDengkSyuruiKbn(C_KhDengkSyuruiKbn.SEISANK_KARIUKEGK);
        }
        else {
            ansyuuTaisyouGkBean1.setKhDengkSyuruiKbn(C_KhDengkSyuruiKbn.HOZEN_RYOUSYUGK);
        }
        ansyuuTaisyouGkBean1.setTaisyouGk(ryosyuGk);
        ansyuuTaisyouGkBean1.setKeiyakutuukaGk(ryosyuGk);

        ansyuuTaisyouGkBeanLst.add(ansyuuTaisyouGkBean1);

        if (!C_KrkriyuuKbn.BLNK.eq(krkRiyuuKbn)) {

            ansyuuTaisyouGkBean2.setKhDengkSyuruiKbn(C_KhDengkSyuruiKbn.KEIJYOUK_KARIUKEGK);
            ansyuuTaisyouGkBean2.setTaisyouGk(krkGk);
            ansyuuTaisyouGkBean2.setKeiyakutuukaGk(krkGk);

            ansyuuTaisyouGkBeanLst.add(ansyuuTaisyouGkBean2);
        }

        if (C_KrkriyuuKbn.BLNK.eq(krkRiyuuKbn) || C_KrkriyuuKbn.KAZYOUNYKN.eq(krkRiyuuKbn)) {

            ansyuuTaisyouGkBean3.setKhDengkSyuruiKbn(C_KhDengkSyuruiKbn.KEIJYOUP);
            ansyuuTaisyouGkBean3.setTaisyouGk(seitouGk);
            ansyuuTaisyouGkBean3.setKeiyakutuukaGk(seitouGk);
            ansyuuTaisyouGkBean3.setHrkkaisuu(nykHrkKaisuu);
            ansyuuTaisyouGkBean3.setJyutouStartYm(jyutouYm);
            ansyuuTaisyouGkBean3.setJyutouKaisuuY(jyutouKaisuuY);
            ansyuuTaisyouGkBean3.setJyutouKaisuuM(0);

            ansyuuTaisyouGkBeanLst.add(ansyuuTaisyouGkBean3);
        }

        ansyuuCommonSiwakeInBean.setAnsyuuTaisyouGkBeanLst(ansyuuTaisyouGkBeanLst);

        List<IT_KhDenpyoData> khDenpyoDataLst = createDenpyoData(ansyuuCommonSiwakeInBean);

        itKhDenpyoDatas.addAll(khDenpyoDataLst);

        String zennoupnykdenrenno = khDenpyoDataLst.get(0).getDenrenno();

        if (C_YouhiKbn.YOU.eq(nyuukinKakusyouSakuseiYh)) {

            createNyuukinKakusyouData(khDenpyoDataLst, nykdenpyoYMD);
        }

        IT_Zennou zennou = null;

        if (C_KrkriyuuKbn.BLNK.eq(krkRiyuuKbn) || C_KrkriyuuKbn.KAZYOUNYKN.eq(krkRiyuuKbn)) {
            SetOutoubi setoutoubi= SWAKInjector.getInstance(SetOutoubi.class);
            BizDate outouYmd = setoutoubi.exec(C_TykzentykgoKbn.TYKGO, kykYmd, nykHrkKaisuu, zennoupjyutoustartym.getPreviousMonth().getLastDay());

            Integer zennouRenban = 1;
            Integer zennouRenbanMax = commonNyuukinDao.getZennouMaxRenno(itAnsyuKihon, outouYmd);

            if (zennouRenbanMax != null){
                zennouRenban = zennouRenbanMax + 1;
            }

            zennou = commonNyuukinDao.createZennou(itAnsyuKihon);

            zennou.setSyono(syoNo);
            zennou.setZennoukaisiymd(outouYmd);
            zennou.setRenno(zennouRenban);
            zennou.setZennounyuukinsyoriymd(syoriYmd);
            zennou.setZennounyuukindenno(zennoupnykdenrenno);
            zennou.setZennounyuukindenymd(nykdenpyoYMD);
            zennou.setRyosyuymd(ryosyuYmd);
            zennou.setZennoukikan(String.valueOf(zennoupjyutoukaisuuy));
            zennou.setZennounyuukinkgk(zennoupp);
            zennou.setZennoujihrkp(hrkP);
            zennou.setAnnaisaikaiym(zennoupjyutoustartym.addYears(zennoupjyutoukaisuuy));
            zennou.setGyoumuKousinKinou(gyoumuKosKinouId);
            zennou.setGyoumuKousinsyaId(gyoumuKosId);
            zennou.setGyoumuKousinTime(sysTime);

            BizPropertyInitializer.initialize(zennou);

            EditKykSyhnRirekiTbl editKykSyhnRirekiTbl = SWAKInjector.getInstance(EditKykSyhnRirekiTbl.class);
            editKykSyhnRirekiTbl.exec(khCParm, syoNo);

            List<IT_KykSyouhn> wkkykSyouhnLst = commonNyuukinDao.getKykSyouhns(itKykKihon);
            IT_KykSyouhn kykSyouhn = wkkykSyouhnLst.get(0);
            kykSyouhn.setHenkousikibetukey(khCParm.getSikibetuKey(syoNo));
            kykSyouhn.setKykjyoutai(C_Kykjyoutai.ZENNOU);
            kykSyouhn.setGyoumuKousinKinou(gyoumuKosKinouId);
            kykSyouhn.setGyoumuKousinsyaId(gyoumuKosId);
            kykSyouhn.setGyoumuKousinTime(sysTime);

        }

        if ((C_KrkriyuuKbn.BLNK.eq(krkRiyuuKbn) || C_KrkriyuuKbn.KAZYOUNYKN.eq(krkRiyuuKbn)) &&
            konkiPYhFlg) {
            Integer maxRenno = commonNyuukinDao.getNyknJissekiRirekiMaxRenno(itKykKihon, jyutouYm);

            Integer renno = 1;
            if (maxRenno != null) {
                renno = maxRenno + 1;
            }

            IT_NyknJissekiRireki nyknJissekiRireki = commonNyuukinDao.createNyknJissekiRireki(itKykKihon);

            nyknJissekiRireki.setJyutoustartym(jyutouYm);
            nyknJissekiRireki.setJyutouendym(jyutouYm.addMonths(11));
            nyknJissekiRireki.setRsgaku(keizkpp);
            nyknJissekiRireki.setRstuukasyu(C_Tuukasyu.JPY);
            nyknJissekiRireki.setHrkp(hrkP);
            nyknJissekiRireki.setNyksyoriymd(syoriYmd);
            nyknJissekiRireki.setRyosyuymd(ryosyuYmd);
            nyknJissekiRireki.setNykdenno(zennoupnykdenrenno);
            nyknJissekiRireki.setNykdenymd(nykdenpyoYMD);
            nyknJissekiRireki.setNykkeiro(nykKeiro);
            nyknJissekiRireki.setHrkkaisuu(nykHrkKaisuu);
            nyknJissekiRireki.setJyutoukaisuuy(1);
            nyknJissekiRireki.setJyutoukaisuum(0);
            nyknJissekiRireki.setNyknaiyoukbn(C_NyknaiyouKbn.KEIZOKUP);
            nyknJissekiRireki.setIktnyuukinnumu(iktnyuukinnUmu);
            nyknJissekiRireki.setHenkousikibetukey(henkouSikibetuKey);
            nyknJissekiRireki.setGyoumuKousinKinou(gyoumuKosKinouId);
            nyknJissekiRireki.setGyoumuKousinsyaId(gyoumuKosId);
            nyknJissekiRireki.setGyoumuKousinTime(sysTime);
            nyknJissekiRireki.setTikiktbrisyuruikbn(tikiktbrisyuruikbn);

            nyknJissekiRireki.setRenno(renno);

            BizPropertyInitializer.initialize(nyknJissekiRireki);

            EditKoujyonaiyouTbl editKoujyonaiyouTbl = SWAKInjector.getInstance(EditKoujyonaiyouTbl.class);

            editKoujyonaiyouTbl.setIkkatuNyknUmu(iktnyuukinnUmu);
            editKoujyonaiyouTbl.setNyknJskStartYm(nyknJissekiRireki.getJyutoustartym());
            editKoujyonaiyouTbl.setNyknJskEndYm(nyknJissekiRireki.getJyutouendym());
            editKoujyonaiyouTbl.setNyknJskRenno(nyknJissekiRireki.getRenno());
            editKoujyonaiyouTbl.setNyknJskRyosyuYmd(nyknJissekiRireki.getRyosyuymd());
            editKoujyonaiyouTbl.setNyknJskJytKaisuuY(nyknJissekiRireki.getJyutoukaisuuy());
            editKoujyonaiyouTbl.setNyknJskJytKaisuuM(nyknJissekiRireki.getJyutoukaisuum());
            editKoujyonaiyouTbl.setNyknJskRysKwsrate(nyknJissekiRireki.getRyosyukwsrate());
            List<KykSyouhnCommonParam> kykSyouhnCommonParams = new ArrayList<>();
            kykSyouhnCommonParams.addAll(kykSyouhnLst);
            editKoujyonaiyouTbl.setKykSyouhnLst(kykSyouhnCommonParams);

            ZennouKoujyogakuKeisanParam zennouKoujyogakuKeisanParam = SWAKInjector.getInstance(ZennouKoujyogakuKeisanParam.class);
            zennouKoujyogakuKeisanParam.setKjsmyouzennoukaisiymd(zennou.getKjsmyouzennoukaisiymd());
            zennouKoujyogakuKeisanParam.setKjsmyouzennoukikanm(zennou.getKjsmyouzennoukikanm());
            zennouKoujyogakuKeisanParam.setKjsmyouzennounyuukinkgk(zennou.getKjsmyouzennounyuukinkgk());
            zennouKoujyogakuKeisanParam.setHrkp(zennou.getZennoujihrkp());
            zennouKoujyogakuKeisanParam.setHrkkaisuu(nykHrkKaisuu);
            zennouKoujyogakuKeisanParam.setZennoukaisiymd(zennou.getZennoukaisiymd());
            zennouKoujyogakuKeisanParam.setZennourenno(zennou.getRenno());
            editKoujyonaiyouTbl.setZennouKoujyogakuKeisanParam(zennouKoujyogakuKeisanParam);
            editKoujyonaiyouTbl.setNykkeiro(nykKeiro);

            editKoujyonaiyouTbl.exec(khCParm, syoNo,
                C_KjsymnytblhensyuusyoriKbn.NYUUKINHANEI, syoriYmd);

            if (C_KinouKbn.ONLINE.eq(asKinou.getKinouKbn())) {

                sikinIdouRirekiTblKosin(nyknJissekiRireki.getSyono(),
                    khCParm.getSikibetuKey(syoNo),
                    nyknJissekiRireki.getGyoumuKousinKinou(),
                    nyknJissekiRireki.getHrkkaisuu(),
                    nyknJissekiRireki.getJyutoustartym(),
                    nyknJissekiRireki.getJyutouendym(),
                    nyknJissekiRireki.getNykkeiro(),
                    nyknJissekiRireki.getNyknaiyoukbn(),
                    nyknJissekiRireki.getNyktrksflg());
            }

            itAnsyuKihon.setJkipjytym(updategoJkipjytYm);
            itAnsyuKihon.setGyoumuKousinKinou(gyoumuKosKinouId);
            itAnsyuKihon.setGyoumuKousinsyaId(gyoumuKosId);
            itAnsyuKihon.setGyoumuKousinTime(sysTime);

            EditDairitenTesuuryouTbl editDairitenTesuuryouTbl = SWAKInjector.getInstance(EditDairitenTesuuryouTbl.class);
            if (C_KinouKbn.BATCH.eq(asKinou.getKinouKbn())) {
                editDairitenTesuuryouTbl.setBatchSyoriYmd(syoriYmd);
            }
            editDairitenTesuuryouTbl.exec(khCParm,
                syoNo,
                C_TsrysyoriKbn.KEIZOKUPNYUUKIN,
                jkiPJytYm,
                1,
                0,
                BizCurrency.valueOf(0),
                BizCurrency.valueOf(0),
                ryosyuYmd,
                null);
        }

        deleteTokusin(updategoJkipjytYm);

        if (jidonhnknumu) {
            if (C_Nykkeiro.CREDIT.eq(nykKeiro)) {

                creditHenkin();
            }
            else {
                kzHenkin();
            }
        }

        if (!C_KrkriyuuKbn.BLNK.eq(krkRiyuuKbn) && !jidonhnknumu) {
            createKariukekin(nykdenpyoYMD);
        }
    }

    private void sonotaNyuukin() {

        BizDate nykdenpyoYMD = setNykdenymd();

        AnsyuuCommonSiwakeInBean ansyuuCommonSiwakeInBean = SWAKInjector.getInstance(AnsyuuCommonSiwakeInBean.class);
        AnsyuuTaisyouGkBean ansyuuTaisyouGkBean1 = SWAKInjector.getInstance(AnsyuuTaisyouGkBean.class);
        AnsyuuTaisyouGkBean ansyuuTaisyouGkBean2 = SWAKInjector.getInstance(AnsyuuTaisyouGkBean.class);
        List<AnsyuuTaisyouGkBean> ansyuuTaisyouGkBeanLst = new ArrayList<AnsyuuTaisyouGkBean>();

        ansyuuCommonSiwakeInBean.setKinouId(gyoumuKosKinouId);
        ansyuuCommonSiwakeInBean.setDensysKbn(C_DensysKbn.HOZEN);
        ansyuuCommonSiwakeInBean.setSyouhinCd(syouhinCd);
        ansyuuCommonSiwakeInBean.setSyouhnsdno(syouhinSdNo);
        ansyuuCommonSiwakeInBean.setDenYmd(nykdenpyoYMD);
        ansyuuCommonSiwakeInBean.setSyoriYmd(syoriYmd);
        ansyuuCommonSiwakeInBean.setKykYmd(kykYmd);
        ansyuuCommonSiwakeInBean.setNykkeiro(nykKeiro);
        if (C_Nykkeiro.BANK.eq(nykKeiro) &&
            !C_NykhouhouKbn.KARIUKE.eq(nykhouhouKbn)) {
            ansyuuCommonSiwakeInBean.setSuitouSoshikiCd(suitoSoshikiCd);
        }
        ansyuuCommonSiwakeInBean.setSyono(syoNo);
        ansyuuCommonSiwakeInBean.setSyuudaikoCd(syuudaikocd);

        ansyuuTaisyouGkBean1.setKhDengkSyuruiKbn(C_KhDengkSyuruiKbn.KEIJYOUK_KARIUKEGK);
        ansyuuTaisyouGkBean1.setTaisyouGk(krkGk);
        ansyuuTaisyouGkBean1.setKeiyakutuukaGk(krkGk);

        if (C_NykhouhouKbn.KARIUKE.eq(nykhouhouKbn)) {
            ansyuuTaisyouGkBean2.setKhDengkSyuruiKbn(C_KhDengkSyuruiKbn.SEISANK_KARIUKEGK);
        }
        else {
            ansyuuTaisyouGkBean2.setKhDengkSyuruiKbn(C_KhDengkSyuruiKbn.HOZEN_RYOUSYUGK);
        }
        ansyuuTaisyouGkBean2.setTaisyouGk(ryosyuGk);
        ansyuuTaisyouGkBean2.setKeiyakutuukaGk(ryosyuGk);

        ansyuuTaisyouGkBeanLst.add(ansyuuTaisyouGkBean1);
        ansyuuTaisyouGkBeanLst.add(ansyuuTaisyouGkBean2);

        ansyuuCommonSiwakeInBean.setAnsyuuTaisyouGkBeanLst(ansyuuTaisyouGkBeanLst);

        List<IT_KhDenpyoData> khDenpyoDataLst = createDenpyoData(ansyuuCommonSiwakeInBean);

        itKhDenpyoDatas.addAll(khDenpyoDataLst);

        if (C_YouhiKbn.YOU.eq(nyuukinKakusyouSakuseiYh)) {

            createNyuukinKakusyouData(khDenpyoDataLst, nykdenpyoYMD);
        }

        createKariukekin(nykdenpyoYMD);
    }

    private String getNykKeiroCnv() {
        return C_Nykkeiro.getContentByValue(C_Nykkeiro.PATTERN_DISP, nykKeiro.getValue());
    }

    private String getNykNaiyouKbnCnv() {
        return nykNaiyouKbn.getContent();
    }

    private String getJyutouYMCnv() {

        return DefaultDateFormatter.formatYMKanji(jyutouYm.toString());
    }

    private String getRyosyuYMDCnv() {
        return DefaultDateFormatter.formatYMDKanji(ryosyuYmd);
    }

    private void createNyuukinKakusyouData(List<IT_KhDenpyoData> pKhDenpyoDatas, BizDate pNykdenpyoYMD) {

        int edaban = 0;

        for (IT_KhDenpyoData itKhDenpyoData : pKhDenpyoDatas){

            if (C_TaisyakuKbn.KARIKATA.eq(itKhDenpyoData.getTaisyakukbn()) &&
                (C_Kanjyoukmkcd.HOKENKEIYAKUKARIBARAIKIN_HUHO_SYUUNOU.eq(itKhDenpyoData.getKanjyoukmkcd()) ||
                    C_Kanjyoukmkcd.HOKENKEIYAKUKARIUKEKIN_HUHO_HURIKAE.eq(itKhDenpyoData.getKanjyoukmkcd()) ||
                    C_Kanjyoukmkcd.HOKENKEIYAKUKARIBARAIKIN_HUHO_KURE.eq(itKhDenpyoData.getKanjyoukmkcd()))) {

                edaban = itKhDenpyoData.getEdano();
            }
        }

        NyuukinKakusyouDataSks nyuukinKakusyouDataSks = SWAKInjector.getInstance(NyuukinKakusyouDataSks.class);
        NyuukinKakusyouDataSksParam nyuukinKakusyouDataSksParam =
            SWAKInjector.getInstance(NyuukinKakusyouDataSksParam.class);

        nyuukinKakusyouDataSksParam.setSyoNo(syoNo);
        nyuukinKakusyouDataSksParam.setNykSyoriYmd(syoriYmd);
        nyuukinKakusyouDataSksParam.setNyuukinKakusyounrkYmd(nyuukinKakusyounrkYmd);
        nyuukinKakusyouDataSksParam.setNykKeiro(nykKeiro);
        nyuukinKakusyouDataSksParam.setHrkkaisuu(nykHrkKaisuu);
        nyuukinKakusyouDataSksParam.setNykNaiyouKbn(nykNaiyouKbn);
        nyuukinKakusyouDataSksParam.setIktNyuukinUmu(iktnyuukinnUmu);
        nyuukinKakusyouDataSksParam.setJyutouYm(jyutouYm);
        nyuukinKakusyouDataSksParam.setJyutouKaisuuY(jyutouKaisuuY);
        nyuukinKakusyouDataSksParam.setJyutouKaisuuM(jyutouKaisuuM);
        nyuukinKakusyouDataSksParam.setRyosyuGk(ryosyuGk);
        nyuukinKakusyouDataSksParam.setRyosyuYmd(ryosyuYmd);
        nyuukinKakusyouDataSksParam.setDenrenNo(pKhDenpyoDatas.get(0).getDenrenno());
        nyuukinKakusyouDataSksParam.setEdano(edaban);
        nyuukinKakusyouDataSksParam.setSuitouBumonCd(pKhDenpyoDatas.get(0).getSuitoubumoncd());
        nyuukinKakusyouDataSksParam.setHenkousikibetukey(henkouSikibetuKey);
        nyuukinKakusyouDataSksParam.setNykhouhoukbn(nykhouhouKbn);
        nyuukinKakusyouDataSksParam.setTikiktbrisyuruikbn(tikiktbrisyuruikbn);
        nyuukinKakusyouDataSksParam.setNykdenYmd(pNykdenpyoYMD);

        if (C_Nykkeiro.KZHRK.eq(nykKeiro)) {
            nyuukinKakusyouDataSksParam.setKzHurikaeBankCd(kzHurikaeBankCd);
            nyuukinKakusyouDataSksParam.setKzHurikaeSitenCd(kzHurikaeSitenCd);
        }
        else if (C_Nykkeiro.BANK.eq(nykKeiro)) {
            nyuukinKakusyouDataSksParam.setTabakarikanjyono(tabakarikanjyono);
            nyuukinKakusyouDataSksParam.setSuitoSoshikiCd(suitoSoshikiCd);
        }
        else if (C_Nykkeiro.CREDIT.eq(nykKeiro)) {
            nyuukinKakusyouDataSksParam.setCreditKessaiyouNo(creditkessaiyouno);
        }
        nyuukinKakusyouDataSksParam.setSyuudaikoCd(syuudaikocd);
        nyuukinKakusyouDataSksParam.setCreditUriageSeikyuuKbn(creditUriageSeikyuuKbn);

        itNyuukinKakusyouData =
            nyuukinKakusyouDataSks.exec(khCParm, nyuukinKakusyouDataSksParam);
    }

    private boolean hanteiHenkin() {
        if (C_KinouKbn.ONLINE.eq(asKinou.getKinouKbn())) {
            return false;
        }

        if (C_Nykkeiro.KZHRK.eq(nykKeiro)) {

            if (!C_Hrkkeiro.KOUHURI.eq(itKykKihon.getHrkkeiro())) {
                return false;
            }
        }

        if (C_Nykkeiro.CREDIT.eq(nykKeiro)) {

            if (BizUtil.isBlank(creditkessaiyouno)) {
                return false;
            }
        }

        if (C_Nykkeiro.KZHRK.eq(nykKeiro) ||
            C_Nykkeiro.CREDIT.eq(nykKeiro)) {
            if (C_KrkriyuuKbn.SYOUMETUGONYKN.eq(krkRiyuuKbn) ||
                C_KrkriyuuKbn.HENKINHITUYOU.eq(krkRiyuuKbn) ||
                C_KrkriyuuKbn.KYUUSOKUTYUUNYKN.eq(krkRiyuuKbn) ||
                C_KrkriyuuKbn.KAZYOUNYKN.eq(krkRiyuuKbn)) {
                return true;
            }
            return false;
        }
        else if (C_Nykkeiro.BANK.eq(nykKeiro)) {
            if (C_KrkriyuuKbn.SYOUMETUGONYKN.eq(krkRiyuuKbn) ||
                (C_KrkriyuuKbn.KYUUSOKUTYUUNYKN.eq(krkRiyuuKbn) &&
                    (C_NyknaiyouKbn.KEIZOKUP.eq(nykNaiyouKbn) ||
                        C_NyknaiyouKbn.HENKOUGOP.eq(nykNaiyouKbn)))) {
                return true;
            }
            return false;
        }
        return false;

    }

    private void kzHenkin() {
        IT_Kouza kouza = commonNyuukinDao.getKouza(itKykKihon);

        if (kouza == null) {
            throw new CommonBizAppException("口座TBLにデータが存在しません。");
        }

        KeisanSiharaibi keisanSiharaibi = SWAKInjector.getInstance(KeisanSiharaibi.class);
        AnsyuuCommonSiwake ansyuuCommonSiwake = SWAKInjector.getInstance(AnsyuuCommonSiwake.class);
        AnsyuuCommonSiwakeInBean ansyuuCommonSiwakeInBean = SWAKInjector.getInstance(AnsyuuCommonSiwakeInBean.class);
        AnsyuuTaisyouGkBean ansyuuTaisyouGkBean1 = SWAKInjector.getInstance(AnsyuuTaisyouGkBean.class);
        AnsyuuTaisyouGkBean ansyuuTaisyouGkBean2 = SWAKInjector.getInstance(AnsyuuTaisyouGkBean.class);
        List<AnsyuuTaisyouGkBean> ansyuuTaisyouGkBeanLst = new ArrayList<>();
        String dengyoumucd = "";
        C_Kanjyoukmkcd kanjyoukmkcd = C_Kanjyoukmkcd.BLNK;
        C_ShrriyuuKbn shrriyuuKbn = C_ShrriyuuKbn.BLNK;
        BzFbSoukinDataSksBean bzFbSoukinDataSksBean = SWAKInjector.getInstance(BzFbSoukinDataSksBean.class);

        hnknDenpyoYmd = keisanSiharaibi.exec(syoriYmd, C_InputShrhousiteiKbn.FBSOUKIN, C_Tuukasyu.JPY,
            kouza.getBankcd());
        C_ShrhousiteiKbn shrhousiteiKbn = keisanSiharaibi.getShrhousiteiKbn();

        ansyuuCommonSiwakeInBean.setKinouId(gyoumuKosKinouId);
        ansyuuCommonSiwakeInBean.setDensysKbn(C_DensysKbn.HOZEN);
        ansyuuCommonSiwakeInBean.setSyouhinCd(syouhinCd);
        ansyuuCommonSiwakeInBean.setSyouhnsdno(syouhinSdNo);
        ansyuuCommonSiwakeInBean.setDenYmd(hnknDenpyoYmd);
        ansyuuCommonSiwakeInBean.setSyoriYmd(syoriYmd);
        ansyuuCommonSiwakeInBean.setKykYmd(kykYmd);
        ansyuuCommonSiwakeInBean.setShrhousiteiKbn(shrhousiteiKbn);
        ansyuuCommonSiwakeInBean.setSyono(syoNo);
        ansyuuCommonSiwakeInBean.setSyuudaikoCd(syuudaikocd);

        ansyuuTaisyouGkBean1.setKhDengkSyuruiKbn(C_KhDengkSyuruiKbn.SEISANK_KARIUKEGK);
        ansyuuTaisyouGkBean1.setTaisyouGk(krkGk);
        ansyuuTaisyouGkBean1.setKeiyakutuukaGk(krkGk);
        ansyuuTaisyouGkBean2.setKhDengkSyuruiKbn(C_KhDengkSyuruiKbn.SHRGK);
        ansyuuTaisyouGkBean2.setTaisyouGk(krkGk);
        ansyuuTaisyouGkBean2.setKeiyakutuukaGk(krkGk);

        ansyuuTaisyouGkBeanLst.add(ansyuuTaisyouGkBean1);
        ansyuuTaisyouGkBeanLst.add(ansyuuTaisyouGkBean2);

        ansyuuCommonSiwakeInBean.setAnsyuuTaisyouGkBeanLst(ansyuuTaisyouGkBeanLst);
        CommonSiwakeOutBean commonSiwakeOutBean = ansyuuCommonSiwake.exec(ansyuuCommonSiwakeInBean);

        BzDenpyouDataSks bzDenpyouDataSks = SWAKInjector.getInstance(BzDenpyouDataSks.class);
        BzDenpyouDataTourokuBean bzDenpyouDataTourokuBean = SWAKInjector.getInstance(BzDenpyouDataTourokuBean.class);

        String syorisosikicd = "";

        if (C_KinouKbn.ONLINE.eq(asKinou.getKinouKbn())) {

            syorisosikicd = khCParm.getTmSosikiCd();
        }
        else {
            syorisosikicd = commonSiwakeOutBean.getHuridenatesakiCd().concat("0000");
        }

        bzDenpyouDataTourokuBean.setIbSyono(syoNo);
        bzDenpyouDataTourokuBean.setIbHuridenatesakicd(commonSiwakeOutBean.getHuridenatesakiCd());
        bzDenpyouDataTourokuBean.setIbTantocd(commonSiwakeOutBean.getTantoCd());
        bzDenpyouDataTourokuBean.setIbDenymd(commonSiwakeOutBean.getDenyMd());
        bzDenpyouDataTourokuBean.setIbTuukasyu(commonSiwakeOutBean.getTuukasyu());
        bzDenpyouDataTourokuBean.setIbHuridenskskbn(commonSiwakeOutBean.getHuridensksKbn());
        bzDenpyouDataTourokuBean.setIbDenhnknhoukbn(commonSiwakeOutBean.getDenhnknhouKbn());
        bzDenpyouDataTourokuBean.setIbDenshrhoukbn(commonSiwakeOutBean.getDenshrhouKbn());
        bzDenpyouDataTourokuBean.setIbSyoriymd(commonSiwakeOutBean.getSyoriYmd());
        bzDenpyouDataTourokuBean.setIbSyoricd(commonSiwakeOutBean.getSyoriCd());
        bzDenpyouDataTourokuBean.setIbSyorisosikicd(syorisosikicd);
        bzDenpyouDataTourokuBean.setIbKyktuukasyu(commonSiwakeOutBean.getKyktuukaSyu());
        bzDenpyouDataTourokuBean.setIbGyoumuKousinsyaId(gyoumuKosId);
        bzDenpyouDataTourokuBean.setIbKakokawaserateshiteiflg(false);
        bzDenpyouDataTourokuBean.setIbKakokawaserateshiteiymd(null);
        bzDenpyouDataTourokuBean.setIbShrhousiteiKbn(shrhousiteiKbn);
        bzDenpyouDataTourokuBean.setIbSyouhncd(syouhinCd);
        bzDenpyouDataTourokuBean.setIbSyouhnsdno(syouhinSdNo);

        bzDenpyouDataTourokuBean.setBzSiwakeMeisaiBeanList(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst());

        List<IT_KhDenpyoData> khDenpyoDataLst = bzDenpyouDataSks.execKh(bzDenpyouDataTourokuBean);

        itKhDenpyoDatas.addAll(khDenpyoDataLst);

        String skdenrenno = khDenpyoDataLst.get(0).getDenrenno();
        int skedanoo = bzDenpyouDataSks.getEdano();
        String syoricd = commonSiwakeOutBean.getSyoriCd();

        for (IT_KhDenpyoData khDenpyoData : khDenpyoDataLst) {

            if (skedanoo == khDenpyoData.getEdano()) {
                dengyoumucd = khDenpyoData.getDengyoumucd();
                kanjyoukmkcd = khDenpyoData.getKanjyoukmkcd();
            }
        }
        if (C_KrkriyuuKbn.SYOUMETUGONYKN.eq(krkRiyuuKbn) || C_KrkriyuuKbn.KYUUSOKUTYUUNYKN.eq(krkRiyuuKbn) ||
            C_KrkriyuuKbn.HENKINHITUYOU.eq(krkRiyuuKbn)) {
            shrriyuuKbn = C_ShrriyuuKbn.HARAIKOMIHUYOU;
        }
        else if (C_KrkriyuuKbn.ZYUTOUTUKISOUI.eq(krkRiyuuKbn)) {
            shrriyuuKbn = C_ShrriyuuKbn.NIZYUNYKN;
        }
        else if (C_KrkriyuuKbn.KAZYOUNYKN.eq(krkRiyuuKbn)) {
            shrriyuuKbn = C_ShrriyuuKbn.KAZYOUNYKN;
        }
        else {
            shrriyuuKbn = C_ShrriyuuKbn.HARAIKOMIHUYOU;
        }

        syuunouHenknRireki = commonNyuukinDao.createSyuunouHenknRireki(itAnsyuKihon);

        syuunouHenknRireki.setSyono(syoNo);
        syuunouHenknRireki.setDenrenno(skdenrenno);
        syuunouHenknRireki.setEdano(skedanoo);
        syuunouHenknRireki.setDenkihyouymd(syoriYmd);
        syuunouHenknRireki.setShrymd(hnknDenpyoYmd);
        syuunouHenknRireki.setKanjyoukmkcd(kanjyoukmkcd);
        syuunouHenknRireki.setHnkngk(krkGk);
        syuunouHenknRireki.setShrriyuukbn(shrriyuuKbn);
        syuunouHenknRireki.setBankcd(kouza.getBankcd());

        if (IGkCommonKoumoku.BANKCD_YTGINKOU.equals(kouza.getBankcd())) {

            ConvertYuutyoSitencd convertYuutyoSitencd = SWAKInjector.getInstance(ConvertYuutyoSitencd.class);

            syuunouHenknRireki.setSitencd(convertYuutyoSitencd.exec(kouza.getSitencd()));
        }
        else {
            syuunouHenknRireki.setSitencd(kouza.getSitencd());
        }

        syuunouHenknRireki.setYokinkbn(kouza.getYokinkbn());
        syuunouHenknRireki.setKouzano(kouza.getKouzano());
        syuunouHenknRireki.setKzmeiginmkn(kouza.getKzmeiginmkn());
        syuunouHenknRireki.setGyoumuKousinKinou(gyoumuKosKinouId);
        syuunouHenknRireki.setGyoumuKousinsyaId(gyoumuKosId);
        syuunouHenknRireki.setGyoumuKousinTime(sysTime);

        BizPropertyInitializer.initialize(syuunouHenknRireki);

        bzFbSoukinDataSksBean.setDenbyouyouDataRenbon(skdenrenno);
        bzFbSoukinDataSksBean.setEdaNo(skedanoo);
        bzFbSoukinDataSksBean.setDenSysKbn(C_DensysKbn.HOZEN);
        bzFbSoukinDataSksBean.setSyoriCd(syoricd);
        bzFbSoukinDataSksBean.setSyoriYmd(syoriYmd);
        bzFbSoukinDataSksBean.setDenYmd(hnknDenpyoYmd);
        bzFbSoukinDataSksBean.setSyoNo(syoNo);
        bzFbSoukinDataSksBean.setShrHouSiteiKbn(shrhousiteiKbn);
        bzFbSoukinDataSksBean.setBankCd(kouza.getBankcd());
        bzFbSoukinDataSksBean.setSitenCd(kouza.getSitencd());
        bzFbSoukinDataSksBean.setYokinKbn(kouza.getYokinkbn());
        bzFbSoukinDataSksBean.setKouzaNo(kouza.getKouzano());
        bzFbSoukinDataSksBean.setKzMeigiNmKn(kouza.getKzmeiginmkn());
        bzFbSoukinDataSksBean.setSouKingk(krkGk);
        bzFbSoukinDataSksBean.setKykTuukasyu(commonSiwakeOutBean.getKyktuukaSyu());
        bzFbSoukinDataSksBean.setGaikaTaikagk(BizCurrency.valueOf(0));
        bzFbSoukinDataSksBean.setSoukinKwsRate(BizNumber.valueOf(0));
        bzFbSoukinDataSksBean.setKinouId(gyoumuKosKinouId);
        bzFbSoukinDataSksBean.setUserId(gyoumuKosId);
        bzFbSoukinDataSksBean.setDengyoumuCd(dengyoumucd);

        if (C_KinouKbn.ONLINE.eq(asKinou.getKinouKbn())) {

            bzFbSoukinDataSksBean.setSyoriSosikiCd(khCParm.getTmSosikiCd());
        }
        else {
            bzFbSoukinDataSksBean.setSyoriSosikiCd(commonSiwakeOutBean.getHuridenatesakiCd().concat("0000"));
        }

        BzFbSoukinDataSks bzFbSoukinDataSks = SWAKInjector.getInstance(BzFbSoukinDataSks.class);
        itKhFBSoukinData = bzFbSoukinDataSks.execKh(bzFbSoukinDataSksBean);

        BzGetSosikiMadogutiInfo getSosikiMadogutiInfo = SWAKInjector.getInstance(BzGetSosikiMadogutiInfo.class);

        BzGetSosikiMadogutiInfoKekkaBean getSosikiMadogutiInfoKekkaBean =
            getSosikiMadogutiInfo.exec(YuyuBizConfig.getInstance().getCallcentersosikicd());

        AnsyuuSetTetudukityuuiInfo ansyuuSetTetudukityuuiInfo = SWAKInjector.getInstance(AnsyuuSetTetudukityuuiInfo.class);

        C_KktyuitaKbn kktyuitaKbn = ansyuuSetTetudukityuuiInfo.exec(syoNo);

        C_HassouKbn hassoukbn = C_HassouKbn.TYOKUSOU;

        if (C_KktyuitaKbn.DNGNMEMOARI.eq(kktyuitaKbn)){

            hassoukbn = C_HassouKbn.HONSYAKAISOU;
        }

        IT_KouzaHnknTuuti kouzaHnknTuuti = itKykKihon.createKouzaHnknTuuti();

        kouzaHnknTuuti.setSyono(syoNo);
        kouzaHnknTuuti.setDenrenno(skdenrenno);
        kouzaHnknTuuti.setEdano(skedanoo);
        kouzaHnknTuuti.setTyouhyouymd(syoriYmd);
        kouzaHnknTuuti.setHenkousikibetukey(khCParm.getSikibetuKey(syoNo));
        kouzaHnknTuuti.setHassoukbn(hassoukbn);
        kouzaHnknTuuti.setShskyno(tsinyno);
        kouzaHnknTuuti.setShsadr1kj(tsinadr1kj);
        kouzaHnknTuuti.setShsadr2kj(tsinadr2kj);
        kouzaHnknTuuti.setShsadr3kj(tsinadr3kj);
        kouzaHnknTuuti.setShsnmkj(kyknmkj);
        kouzaHnknTuuti.setToiawasesosikinmkj(getSosikiMadogutiInfoKekkaBean.getKanjisosikinm());
        kouzaHnknTuuti.setToiawaseyno(getSosikiMadogutiInfoKekkaBean.getPostalCd());
        kouzaHnknTuuti.setToiawaseadr1kj(getSosikiMadogutiInfoKekkaBean.getKanjisosikiadr1());
        kouzaHnknTuuti.setToiawaseadr2kj(getSosikiMadogutiInfoKekkaBean.getKanjisosikiadr2());
        kouzaHnknTuuti.setToiawaseadr3kj(getSosikiMadogutiInfoKekkaBean.getKanjisosikiadr3());
        kouzaHnknTuuti.setToiawasetelno(getSosikiMadogutiInfoKekkaBean.getTelno());
        kouzaHnknTuuti.setToiawaseteluktkkanou1(YuyuBizConfig.getInstance().getUketimecallcenter1());
        kouzaHnknTuuti.setToiawaseteluktkkanou2(YuyuBizConfig.getInstance().getUketimecallcenter2());
        kouzaHnknTuuti.setToiawasesosikinmkj2("");
        kouzaHnknTuuti.setToiawasetelno2("");
        kouzaHnknTuuti.setHurikomiymd(hnknDenpyoYmd);
        kouzaHnknTuuti.setShrgk(krkGk);
        kouzaHnknTuuti.setKrkriyuukbn(krkRiyuuKbn);
        kouzaHnknTuuti.setBankcd(kouza.getBankcd());
        kouzaHnknTuuti.setYokinkbn(kouza.getYokinkbn());
        kouzaHnknTuuti.setKouzano(kouza.getKouzano());
        kouzaHnknTuuti.setKzmeiginmkn(kouza.getKzmeiginmkn());
        kouzaHnknTuuti.setRyosyuymd(ryosyuYmd);
        kouzaHnknTuuti.setRsgaku(ryosyuGk);
        kouzaHnknTuuti.setJyuutouym(jyutouYm);
        kouzaHnknTuuti.setJyutoukaisuuy(jyutouKaisuuY);
        kouzaHnknTuuti.setJyutoukaisuum(jyutouKaisuuM);
        kouzaHnknTuuti.setGyoumuKousinKinou(gyoumuKosKinouId);
        kouzaHnknTuuti.setGyoumuKousinsyaId(gyoumuKosId);
        kouzaHnknTuuti.setGyoumuKousinTime(sysTime);

        if (IGkCommonKoumoku.BANKCD_YTGINKOU.equals(kouza.getBankcd())) {

            ConvertYuutyoSitencd convertYuutyoSitencd = SWAKInjector.getInstance(ConvertYuutyoSitencd.class);

            kouzaHnknTuuti.setSitencd(convertYuutyoSitencd.exec(kouza.getSitencd()));
        }
        else {
            kouzaHnknTuuti.setSitencd(kouza.getSitencd());
        }

        BizPropertyInitializer.initialize(kouzaHnknTuuti);
    }

    private void creditHenkin() {

        SetMinusUriagebi setMinusUriagebi = SWAKInjector.getInstance(SetMinusUriagebi.class);
        setMinusUriagebi.exec(syoriYmd);

        BizDate crkHnknUriageseikyuuYmd = setMinusUriagebi.getUriageSeikyuuYmd();
        BizDate crkHnknDenpyoYmd = setMinusUriagebi.getDenpyouYmd();

        AnsyuuCommonSiwake ansyuuCommonSiwake = SWAKInjector.getInstance(AnsyuuCommonSiwake.class);
        AnsyuuCommonSiwakeInBean ansyuuCommonSiwakeInBean = SWAKInjector.getInstance(AnsyuuCommonSiwakeInBean.class);
        AnsyuuTaisyouGkBean ansyuuTaisyouGkBean1 = SWAKInjector.getInstance(AnsyuuTaisyouGkBean.class);
        AnsyuuTaisyouGkBean ansyuuTaisyouGkBean2 = SWAKInjector.getInstance(AnsyuuTaisyouGkBean.class);
        List<AnsyuuTaisyouGkBean> ansyuuTaisyouGkBeanLst = new ArrayList<>();
        C_Kanjyoukmkcd kanjyoukmkcd = C_Kanjyoukmkcd.BLNK;
        C_ShrhousiteiKbn shrhousiteiKbn = C_ShrhousiteiKbn.BLNK;

        ansyuuCommonSiwakeInBean.setKinouId(gyoumuKosKinouId);
        ansyuuCommonSiwakeInBean.setDensysKbn(C_DensysKbn.HOZEN);
        ansyuuCommonSiwakeInBean.setSyouhinCd(syouhinCd);
        ansyuuCommonSiwakeInBean.setSyouhnsdno(syouhinSdNo);
        ansyuuCommonSiwakeInBean.setDenYmd(crkHnknDenpyoYmd);
        ansyuuCommonSiwakeInBean.setSyoriYmd(syoriYmd);
        ansyuuCommonSiwakeInBean.setKykYmd(kykYmd);
        ansyuuCommonSiwakeInBean.setShrhousiteiKbn(shrhousiteiKbn);
        ansyuuCommonSiwakeInBean.setSyono(syoNo);
        ansyuuCommonSiwakeInBean.setSyuudaikoCd(C_Syuudaikocd.BLNK);

        ansyuuTaisyouGkBean1.setKhDengkSyuruiKbn(C_KhDengkSyuruiKbn.SEISANK_KARIUKEGK);
        ansyuuTaisyouGkBean1.setTaisyouGk(krkGk);
        ansyuuTaisyouGkBean1.setKeiyakutuukaGk(krkGk);
        ansyuuTaisyouGkBean2.setKhDengkSyuruiKbn(C_KhDengkSyuruiKbn.CREDITTORIKESIGK);
        ansyuuTaisyouGkBean2.setTaisyouGk(krkGk);
        ansyuuTaisyouGkBean2.setKeiyakutuukaGk(krkGk);

        ansyuuTaisyouGkBeanLst.add(ansyuuTaisyouGkBean1);
        ansyuuTaisyouGkBeanLst.add(ansyuuTaisyouGkBean2);

        ansyuuCommonSiwakeInBean.setAnsyuuTaisyouGkBeanLst(ansyuuTaisyouGkBeanLst);
        CommonSiwakeOutBean commonSiwakeOutBean = ansyuuCommonSiwake.exec(ansyuuCommonSiwakeInBean);

        BzDenpyouDataSks bzDenpyouDataSks = SWAKInjector.getInstance(BzDenpyouDataSks.class);
        BzDenpyouDataTourokuBean bzDenpyouDataTourokuBean = SWAKInjector.getInstance(BzDenpyouDataTourokuBean.class);

        String syorisosikicd = "";

        if (C_KinouKbn.ONLINE.eq(asKinou.getKinouKbn())) {

            syorisosikicd = khCParm.getTmSosikiCd();
        }
        else {
            syorisosikicd = commonSiwakeOutBean.getHuridenatesakiCd().concat("0000");
        }

        bzDenpyouDataTourokuBean.setIbSyono(syoNo);
        bzDenpyouDataTourokuBean.setIbHuridenatesakicd(commonSiwakeOutBean.getHuridenatesakiCd());
        bzDenpyouDataTourokuBean.setIbTantocd(commonSiwakeOutBean.getTantoCd());
        bzDenpyouDataTourokuBean.setIbDenymd(commonSiwakeOutBean.getDenyMd());
        bzDenpyouDataTourokuBean.setIbTuukasyu(commonSiwakeOutBean.getTuukasyu());
        bzDenpyouDataTourokuBean.setIbHuridenskskbn(commonSiwakeOutBean.getHuridensksKbn());
        bzDenpyouDataTourokuBean.setIbDenhnknhoukbn(commonSiwakeOutBean.getDenhnknhouKbn());
        bzDenpyouDataTourokuBean.setIbDenshrhoukbn(commonSiwakeOutBean.getDenshrhouKbn());
        bzDenpyouDataTourokuBean.setIbSyoriymd(commonSiwakeOutBean.getSyoriYmd());
        bzDenpyouDataTourokuBean.setIbSyoricd(commonSiwakeOutBean.getSyoriCd());
        bzDenpyouDataTourokuBean.setIbSyorisosikicd(syorisosikicd);
        bzDenpyouDataTourokuBean.setIbKyktuukasyu(commonSiwakeOutBean.getKyktuukaSyu());
        bzDenpyouDataTourokuBean.setIbGyoumuKousinsyaId(gyoumuKosId);
        bzDenpyouDataTourokuBean.setIbKakokawaserateshiteiflg(false);
        bzDenpyouDataTourokuBean.setIbKakokawaserateshiteiymd(null);
        bzDenpyouDataTourokuBean.setIbShrhousiteiKbn(shrhousiteiKbn);
        bzDenpyouDataTourokuBean.setIbSyouhncd(syouhinCd);
        bzDenpyouDataTourokuBean.setIbSyouhnsdno(syouhinSdNo);
        bzDenpyouDataTourokuBean.setBzSiwakeMeisaiBeanList(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst());

        List<IT_KhDenpyoData> khDenpyoDataLst = bzDenpyouDataSks.execKh(bzDenpyouDataTourokuBean);

        itKhDenpyoDatas.addAll(khDenpyoDataLst);

        String skdenrenno = khDenpyoDataLst.get(0).getDenrenno();
        int skedanoo = bzDenpyouDataSks.getCreditHnknEdano();

        for (IT_KhDenpyoData khDenpyoData : khDenpyoDataLst) {

            if (skedanoo == khDenpyoData.getEdano()) {
                kanjyoukmkcd = khDenpyoData.getKanjyoukmkcd();
            }
        }

        CreditHnknTuutiSksParam creditHnknTuutiSksParam = SWAKInjector.getInstance(CreditHnknTuutiSksParam.class);
        CreditHnknTuutiSks creditHnknTuutiSks = SWAKInjector.getInstance(CreditHnknTuutiSks.class);
        UriageSeikyuuDataSksParam uriageSeikyuuDataSksParam = SWAKInjector.getInstance(UriageSeikyuuDataSksParam.class);
        CreditUriageSeikyuuDataSks creditUriageSeikyuuDataSks = SWAKInjector.getInstance(CreditUriageSeikyuuDataSks.class);

        creditHnknTuutiSksParam.setDenrenno(skdenrenno);
        creditHnknTuutiSksParam.setEdano(skedanoo);
        creditHnknTuutiSksParam.setDenymd(crkHnknDenpyoYmd);
        creditHnknTuutiSksParam.setTyouhyouymd(syoriYmd);
        creditHnknTuutiSksParam.setHenkousikibetukey(khCParm.getSikibetuKey(syoNo));
        creditHnknTuutiSksParam.setHassoukbn(C_HassouKbn.BLNK);
        creditHnknTuutiSksParam.setShrriyuukbn(C_ShrriyuuKbn.BLNK);
        creditHnknTuutiSksParam.setUriageseikyuuymd(crkHnknUriageseikyuuYmd);
        creditHnknTuutiSksParam.setKanjyoukmkcd(kanjyoukmkcd);
        creditHnknTuutiSksParam.setHnkngk(krkGk);
        creditHnknTuutiSksParam.setKrkriyuukbn(krkRiyuuKbn);
        creditHnknTuutiSksParam.setUriageymd(ryosyuYmd);
        creditHnknTuutiSksParam.setUriagegk(ryosyuGk);
        creditHnknTuutiSksParam.setJyuutouym(jyutouYm);
        creditHnknTuutiSksParam.setJyutoukaisuuy(jyutouKaisuuY);
        creditHnknTuutiSksParam.setJyutoukaisuum(jyutouKaisuuM);
        creditHnknTuutiSksParam.setCreditkessaiyouno(creditkessaiyouno);
        creditHnknTuutiSksParam.setAnsyuKihon(itAnsyuKihon);
        creditHnknTuutiSksParam.setKykKihon(itKykKihon);

        creditHnknTuutiSks.exec(khCParm, creditHnknTuutiSksParam);
        syuunouHenknRireki = creditHnknTuutiSks.getSyuunouHenknRireki();

        uriageSeikyuuDataSksParam.setKessaiyouno(creditkessaiyouno);
        uriageSeikyuuDataSksParam.setUriagenengappi(crkHnknUriageseikyuuYmd);
        uriageSeikyuuDataSksParam.setSyoriYmd(syoriYmd);
        uriageSeikyuuDataSksParam.setUriagegk(krkGk);
        uriageSeikyuuDataSksParam.setNyknaiyoukbn(nykNaiyouKbn);
        uriageSeikyuuDataSksParam.setJyuutouym(jkiPJytYm);
        uriageSeikyuuDataSksParam.setAnsyuKihonTblentity(itAnsyuKihon);

        creditUriageSeikyuuDataSks.editHenkinUriageData(khCParm, uriageSeikyuuDataSksParam);
    }

    private void createKariukekin(BizDate pHasseiDenYmd) {
        Integer krkNoMax = commonNyuukinDao.getKariukekinMaxKrkno(itKykKihon);

        if (krkNoMax != null) {
            krkNo = krkNoMax + 1;
        }
        else {
            krkNo = 1;
        }

        kariukekin = commonNyuukinDao.createKariukekin(itKykKihon);

        kariukekin.setKrkno(krkNo);
        kariukekin.setKrkkeijyoymd(syoriYmd);
        kariukekin.setKrkgk(krkGk);
        kariukekin.setHasseidenymd(pHasseiDenYmd);
        kariukekin.setKrkriyuukbn(krkRiyuuKbn);
        kariukekin.setNyknaiyoukbn(nykNaiyouKbn);
        kariukekin.setNykkeiro(nykKeiro);
        kariukekin.setJyuutouym(jyutouYm);
        kariukekin.setJyutoukaisuuy(jyutouKaisuuY);
        kariukekin.setJyutoukaisuum(jyutouKaisuuM);
        kariukekin.setRyosyuymd(ryosyuYmd);
        kariukekin.setHrkkaisuu(nykHrkKaisuu);
        kariukekin.setTikiktbrisyuruikbn(tikiktbrisyuruikbn);
        kariukekin.setGyoumuKousinKinou(gyoumuKosKinouId);
        kariukekin.setGyoumuKousinsyaId(gyoumuKosId);
        kariukekin.setGyoumuKousinTime(sysTime);
        kariukekin.setCreditkessaiyouno(creditkessaiyouno);

        BizPropertyInitializer.initialize(kariukekin);
    }

    private void deleteTokusin(BizDateYM pUpdategoJkipjytYm) {
        if (C_Kykjyoutai.ITIJIBARAI.eq(kykJyoutai)) {
            return;
        }

        SetYuuyokknmanryobi setYuuyokknmanryobi = SWAKInjector.getInstance(SetYuuyokknmanryobi.class);
        setYuuyokknmanryobi.exec(syoNo, pUpdategoJkipjytYm);
        BizDate yykknMryYMD = setYuuyokknmanryobi.getYuuyokknMnrybi();

        commonNyuukinDao.deleteTokusin(itAnsyuKihon, yykknMryYMD);
    }

    private BizDate setNykdenymd() {

        BizDate syoriYMD = syoriYmd;
        BizDate ryosyuYMD = ryosyuYmd;
        BizDate seisantgkmkHasseidenYMD = seisantgkmkHasseidenYmd;

        if (denymd != null){
            if (BizDateUtil.compareYm(denymd.getBizDateYM(), syoriYmd.getBizDateYM()) == BizDateUtil.COMPARE_LESSER ) {
                SetDenSimebi setDenSimebi = SWAKInjector.getInstance(SetDenSimebi.class);
                BizDate denSimeYMD = setDenSimebi.exec(denymd.addMonths(1).getRekijyou());
                if (BizDateUtil.compareYmd(denSimeYMD, syoriYmd) == BizDateUtil.COMPARE_LESSER) {
                    throw new CommonBizAppException("伝票の締切日を過ぎているため処理できません。伝票日付＝" +
                        String.valueOf(denymd) + "　伝票日付の伝票締切日＝" + String.valueOf(denSimeYMD));
                }
            }

            return denymd;
        }

        BizDate zengetumatuDenSimeYMD = null;
        if (zengetumatuDenSimeYmd == null) {
            SetDenSimebi setZengetumatuDenSimebi = SWAKInjector.getInstance(SetDenSimebi.class);
            zengetumatuDenSimeYMD = setZengetumatuDenSimebi.exec(syoriYMD);
        }
        else {
            zengetumatuDenSimeYMD = zengetumatuDenSimeYmd;
        }

        BizDate syoriYmdPreMonLastBusiD = syoriYMD.getBizDateYM().getPreviousMonth().getLastDay().getBusinessDay(
            CHolidayAdjustingMode.PREVIOUS);

        BizDate kariDenYmd = null;

        if (C_NykhouhouKbn.KARIUKE.eq(nykhouhouKbn)) {
            if ((BizDateUtil.compareYmd(syoriYMD,
                seisantgkmkHasseidenYMD.getBizDateYM().getLastDay().addBusinessDays(1)) == BizDateUtil.COMPARE_EQUAL ||
                BizDateUtil.compareYmd(syoriYMD,
                    seisantgkmkHasseidenYMD.getBizDateYM().getLastDay().addBusinessDays(1)) == BizDateUtil.COMPARE_GREATER) &&
                    (BizDateUtil.compareYmd(syoriYMD, zengetumatuDenSimeYMD) == BizDateUtil.COMPARE_EQUAL ||
                    BizDateUtil.compareYmd(syoriYMD, zengetumatuDenSimeYMD) == BizDateUtil.COMPARE_LESSER)) {
                kariDenYmd = syoriYmdPreMonLastBusiD;
            }
            else {
                kariDenYmd = syoriYMD;
            }
        }
        else {
            if (C_Nykkeiro.KZHRK.eq(nykKeiro)) {
                kariDenYmd = ryosyuYMD;
            }
            else if (C_Nykkeiro.CREDIT.eq(nykKeiro)) {
                if (C_CreditUriageSeikyuuKbn.RINJI.eq(creditUriageSeikyuuKbn)) {

                    kariDenYmd = ryosyuYMD;
                }
                else {

                    kariDenYmd = syoriYMD;
                }
            }
            else {
                if (BizDateUtil.compareYm(ryosyuYMD.getBizDateYM(),
                    syoriYMD.getBizDateYM()) == BizDateUtil.COMPARE_EQUAL) {
                    kariDenYmd = syoriYMD;
                }
                else {
                    kariDenYmd = syoriYmdPreMonLastBusiD;
                }
            }
        }

        BizDate kariDenSimeYMD = null;
        if(BizDateUtil.compareYm(kariDenYmd.getBizDateYM(),syoriYMD.getBizDateYM()) == BizDateUtil.COMPARE_LESSER) {
            SetDenSimebi setKariDenSimebi = SWAKInjector.getInstance(SetDenSimebi.class);
            kariDenSimeYMD = setKariDenSimebi.exec(kariDenYmd.addMonths(1).getRekijyou());
        }
        BizDate denYmd = null;
        if (BizDateUtil.compareYm(kariDenYmd.getBizDateYM(), syoriYMD.getBizDateYM()) == BizDateUtil.COMPARE_EQUAL) {
            denYmd = kariDenYmd;
        }
        else {
            if (BizDateUtil.compareYmd(syoriYMD, kariDenSimeYMD) == BizDateUtil.COMPARE_LESSER ||
                BizDateUtil.compareYmd(syoriYMD, kariDenSimeYMD) == BizDateUtil.COMPARE_EQUAL) {
                denYmd = kariDenYmd;
            }
            else {
                denYmd = syoriYMD;
            }
        }

        return denYmd;
    }

    private List<IT_KhDenpyoData> createDenpyoData(AnsyuuCommonSiwakeInBean pAnsyuuCommonSiwakeInBean) {
        AnsyuuCommonSiwake ansyuuCommonSiwake = SWAKInjector.getInstance(AnsyuuCommonSiwake.class);
        CommonSiwakeOutBean commonSiwakeOutBean = ansyuuCommonSiwake.exec(pAnsyuuCommonSiwakeInBean);

        BzDenpyouDataSks bzDenpyouDataSks = SWAKInjector.getInstance(BzDenpyouDataSks.class);
        BzDenpyouDataTourokuBean bzDenpyouDataTourokuBean = SWAKInjector.getInstance(BzDenpyouDataTourokuBean.class);

        String syorisosikicd = "";

        if (C_KinouKbn.ONLINE.eq(asKinou.getKinouKbn())) {

            syorisosikicd = khCParm.getTmSosikiCd();
        }
        else {
            syorisosikicd = commonSiwakeOutBean.getHuridenatesakiCd().concat("0000");
        }

        bzDenpyouDataTourokuBean.setIbSyono(syoNo);
        bzDenpyouDataTourokuBean.setIbHuridenatesakicd(commonSiwakeOutBean.getHuridenatesakiCd());
        bzDenpyouDataTourokuBean.setIbTantocd(commonSiwakeOutBean.getTantoCd());
        bzDenpyouDataTourokuBean.setIbDenymd(commonSiwakeOutBean.getDenyMd());
        bzDenpyouDataTourokuBean.setIbTuukasyu(commonSiwakeOutBean.getTuukasyu());
        bzDenpyouDataTourokuBean.setIbHuridenskskbn(commonSiwakeOutBean.getHuridensksKbn());
        bzDenpyouDataTourokuBean.setIbDenhnknhoukbn(commonSiwakeOutBean.getDenhnknhouKbn());
        bzDenpyouDataTourokuBean.setIbDenshrhoukbn(commonSiwakeOutBean.getDenshrhouKbn());
        bzDenpyouDataTourokuBean.setIbSyoriymd(commonSiwakeOutBean.getSyoriYmd());
        bzDenpyouDataTourokuBean.setIbSyoricd(commonSiwakeOutBean.getSyoriCd());
        bzDenpyouDataTourokuBean.setIbSyorisosikicd(syorisosikicd);
        bzDenpyouDataTourokuBean.setIbKyktuukasyu(commonSiwakeOutBean.getKyktuukaSyu());
        bzDenpyouDataTourokuBean.setIbGyoumuKousinsyaId(gyoumuKosId);
        if (C_Nykkeiro.HKNKIN.eq(nykKeiro) && !C_Tuukasyu.JPY.eq(rstuukasyu)){
            bzDenpyouDataTourokuBean.setIbKakokawaserateshiteiflg(true);
            bzDenpyouDataTourokuBean.setIbKakokawaserateshiteiymd(nyknKwsrateKijyunYmd);
        }
        else {
            bzDenpyouDataTourokuBean.setIbKakokawaserateshiteiflg(false);
        }
        bzDenpyouDataTourokuBean.setIbDensyorisyousaikbn(commonSiwakeOutBean.getDensyorisyousaikbn());
        bzDenpyouDataTourokuBean.setIbSyouhncd(pAnsyuuCommonSiwakeInBean.getSyouhinCd());
        bzDenpyouDataTourokuBean.setIbSyouhnsdno(pAnsyuuCommonSiwakeInBean.getSyouhnsdno());
        bzDenpyouDataTourokuBean.setBzSiwakeMeisaiBeanList(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst());

        return bzDenpyouDataSks.execKh(bzDenpyouDataTourokuBean);
    }

    private void KoskyKjyoutai(){

        C_Kykjyoutai kykJyoutai = C_Kykjyoutai.BLNK;

        if (!C_Hrkkaisuu.TUKI.eq(hrkKaisuu)) {

            return;
        }

        CheckIkktNyuknKykjyuti checkIkktNyuknKykjyuti = SWAKInjector.getInstance(CheckIkktNyuknKykjyuti.class);

        kykJyoutai = checkIkktNyuknKykjyuti.exec(syoriYmd, updategoJkipjytYm);

        List<IT_KykSyouhn> wkkykSyouhnLst = commonNyuukinDao.getKykSyouhns(itKykKihon);
        IT_KykSyouhn kykSyouhn = wkkykSyouhnLst.get(0);

        if (!kykSyouhn.getKykjyoutai().eq(kykJyoutai) && C_Kykjyoutai.IKKATUNK.eq(kykJyoutai)){

            EditKykSyhnRirekiTbl editKykSyhnRirekiTbl = SWAKInjector.getInstance(EditKykSyhnRirekiTbl.class);
            editKykSyhnRirekiTbl.exec(khCParm, syoNo);

            kykSyouhn.setHenkousikibetukey(khCParm.getSikibetuKey(syoNo));
            kykSyouhn.setKykjyoutai(kykJyoutai);
            kykSyouhn.setGyoumuKousinKinou(gyoumuKosKinouId);
            kykSyouhn.setGyoumuKousinsyaId(gyoumuKosId);
            kykSyouhn.setGyoumuKousinTime(sysTime);
        }
    }

    private void sikinIdouRirekiTblKosin(String pSyono,
        String pSikibetuKey,
        String pGyoumuKousinKinou,
        C_Hrkkaisuu pHrkkaisuu,
        BizDateYM pJyutoustartym,
        BizDateYM pJyutouendym,
        C_Nykkeiro pNykkeiro,
        C_NyknaiyouKbn pNyknaiyoukbn,
        C_Nyktrksflg pNyktrksflg) {

        BzSegmentCdSyutoku bzSegmentCdSyutoku = SWAKInjector.getInstance(BzSegmentCdSyutoku.class);

        SyouhinbetuSegmentBean syouhinbetuSegmentBean = bzSegmentCdSyutoku.exec
            (kykSyouhnLst.get(0).getSyouhncd(), kykSyouhnLst.get(0).getKyktuukasyu());

        C_Tuukasyu kykTuukasyu = C_Tuukasyu.BLNK;
        C_SyutkKbn syutkKbn = C_SyutkKbn.NONE;
        String syouhnCd = "";
        int syouhnsdNo = 0;
        int kyksyouhnRenno = 0;
        BizDate kykYMD = null;
        BizCurrency hokenRyou = BizCurrency.valueOf(0);
        SikinIdouRirekiDataBean sikinIdouRirekiDataBean = SWAKInjector.getInstance(SikinIdouRirekiDataBean.class);
        BzSikinIdouRirekiTblSakusei bzSikinIdouRirekiTblSakusei = SWAKInjector.getInstance(BzSikinIdouRirekiTblSakusei.class);

        for (IT_KykSyouhn kykSyouhn : kykSyouhnLst) {

            if (C_SyutkKbn.SYU.eq(kykSyouhn.getSyutkkbn())) {

                kykTuukasyu = kykSyouhn.getKyktuukasyu();
                syutkKbn = kykSyouhn.getSyutkkbn();
                syouhnCd = kykSyouhn.getSyouhncd();
                syouhnsdNo = kykSyouhn.getSyouhnsdno();
                kyksyouhnRenno = kykSyouhn.getKyksyouhnrenno();
                kykYMD = kykSyouhn.getKykymd();
                hokenRyou = kykSyouhn.getHokenryou();

                break;
            }
        }

        sikinIdouRirekiDataBean.setSyoriYmd(BizDate.getSysDate());
        sikinIdouRirekiDataBean.setSyono(pSyono);
        sikinIdouRirekiDataBean.setHenkouSikibetuKey(pSikibetuKey);
        sikinIdouRirekiDataBean.setTargetKinouId(pGyoumuKousinKinou);
        sikinIdouRirekiDataBean.setNykshrKbn(C_NykshrKbn.NYUUKIN);
        sikinIdouRirekiDataBean.setSyoricd(asKinou.getSyoricd());
        sikinIdouRirekiDataBean.setDensysKbn(itKhDenpyoDatas.get(0).getDensyskbn());
        sikinIdouRirekiDataBean.setDenrenno(itKhDenpyoDatas.get(0).getDenrenno());
        sikinIdouRirekiDataBean.setSeg1cd(syouhinbetuSegmentBean.getSegcd1());
        sikinIdouRirekiDataBean.setKykTuukasyu(kykTuukasyu);
        sikinIdouRirekiDataBean.setSyutkKbn(syutkKbn);
        sikinIdouRirekiDataBean.setHrkkaisuu(pHrkkaisuu);
        sikinIdouRirekiDataBean.setSyouhnCd(syouhnCd);
        sikinIdouRirekiDataBean.setSyouhnSdno(syouhnsdNo);
        sikinIdouRirekiDataBean.setKykSyouhnRenno(kyksyouhnRenno);
        sikinIdouRirekiDataBean.setKykYmd(kykYMD);
        sikinIdouRirekiDataBean.setSeirituYmd(itKykKihon.getSeirituymd());
        sikinIdouRirekiDataBean.setJkipjytYm(updategoJkipjytYm);
        sikinIdouRirekiDataBean.setJyutouStartYm(pJyutoustartym);
        sikinIdouRirekiDataBean.setJyutouEndYm(pJyutouendym);
        sikinIdouRirekiDataBean.setNykkeiro(pNykkeiro);
        sikinIdouRirekiDataBean.setNyknaiyouKbn(pNyknaiyoukbn);
        sikinIdouRirekiDataBean.setNyktrksFlg(pNyktrksflg);
        sikinIdouRirekiDataBean.setHrkp(itKykKihon.getHrkp());
        sikinIdouRirekiDataBean.setHokenryou(hokenRyou);

        BT_SikinIdouRireki sikinIdouRireki = bzSikinIdouRirekiTblSakusei
            .editSikinIdouRirekiTblEntity(sikinIdouRirekiDataBean);

        bzSikinIdouRirekiTblSakusei.insertSikinIdouRirekiTblOne(sikinIdouRireki);
    }

    private void outputDebugLog() {

        logger.debug("▽入金共通処理結果");
        logger.debug("│エラー区分：" + errorKbn.getValue());
        logger.debug("│エラー理由：" + commonNyuukinErrorRiyuuKbn.getValue());
        logger.debug("│帳票キー：" + tyohyoKey);
        logger.debug("│正当金額：" + seitouGk.toFormatStringWithUnit());
        logger.debug("│仮受金額：" + krkGk.toFormatStringWithUnit());
        logger.debug("│仮受理由区分：" + krkRiyuuKbn.getValue());
        logger.debug("│自動返金有無：" + jidonhnknumu);
        if(updategoJkipjytYm != null){
            logger.debug("│更新後次回Ｐ充当年月：" + updategoJkipjytYm.toString());
        }
        else {
            logger.debug("│更新後次回Ｐ充当年月：null");
        }

        if (C_NyknaiyouKbn.ZENNOUP.eq(nykNaiyouKbn)) {
            logger.debug("│前納Ｐ入金処理結果");
            logger.debug("│└今期Ｐ要否フラグ：" + konkiPYhFlg);
        }

        logger.debug("△");

    }

}