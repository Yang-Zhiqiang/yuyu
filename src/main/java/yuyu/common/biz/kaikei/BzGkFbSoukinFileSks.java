package yuyu.common.biz.kaikei;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateY;
import jp.co.slcs.swak.db.ExDBResults;
import jp.co.slcs.swak.file.util.FixedlengthConvertUtil;
import yuyu.common.biz.bzcommon.BizDateUtil;
import yuyu.common.biz.bzcommon.BzBatchParam;
import yuyu.common.biz.bzcommon.BzRenkeiHenkanUtil;
import yuyu.def.biz.bean.param.BzRecoveryDatasikibetuBean;
import yuyu.def.biz.configuration.YuyuBizConfig;
import yuyu.def.biz.file.fixedlength.BzGkFbsoukinEndRecordLayoutFile;
import yuyu.def.biz.file.fixedlength.BzGkFbsoukinFixedlengthRecordLayoutFile;
import yuyu.def.biz.file.fixedlength.BzGkFbsoukinHeaderRecordLayoutFile;
import yuyu.def.biz.file.fixedlength.BzGkFbsoukinHisimukeRecordLayoutFile;
import yuyu.def.biz.file.fixedlength.BzGkFbsoukinHontaiRecordLayoutFile;
import yuyu.def.biz.file.fixedlength.BzGkFbsoukinIraininRecordLayoutFile;
import yuyu.def.biz.file.fixedlength.BzGkFbsoukinKaikeiRecordLayoutFile;
import yuyu.def.biz.file.fixedlength.BzGkFbsoukinKeiyuRecordLayoutFile;
import yuyu.def.biz.file.fixedlength.BzGkFbsoukinMessageRecordLayoutFile;
import yuyu.def.biz.file.fixedlength.BzGkFbsoukinRenrakuRecordLayoutFile;
import yuyu.def.biz.file.fixedlength.BzGkFbsoukinSksakiRecordLayoutFile;
import yuyu.def.biz.file.fixedlength.BzGkFbsoukinTrailerRecordLayoutFile;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_Gkgyoumucd;
import yuyu.def.classification.C_ShrhousiteiKbn;
import yuyu.def.classification.C_SystemRenkeiFileSyubetuKbn;
import yuyu.def.classification.C_SystemRenkeiHenkanHoukouKbn;
import yuyu.def.classification.C_SystemRenkeiSyoriHousikiKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.db.entity.BM_SeisanDShrymd;
import yuyu.def.db.entity.BT_GkFBSoukinData;
import yuyu.def.db.entity.BT_GkFBSoukinHukaInfo;
import yuyu.def.hozen.configuration.YuyuHozenConfig;

import com.google.common.base.Strings;

/**
 * 業務共通 経理・会計 外貨ＦＢ送金ファイル作成
 */
public class BzGkFbSoukinFileSks {

    private final String FBSOUKINDATA = "Bz107";

    private final String HEADERRECORD = "1";

    private final String DETARECORD = "2";

    private final String TORERARECORD = "8";

    private final String ENDRECORD = "9";

    private final String EBCDIC = "1";

    private final String DENSHINSOUKIN = "1";

    private final String TUUTIHARA = "1";

    private final String SHOUSUUKETA = "2";

    private final String SOUKINSHIHARAIHITO = "2";

    private final String HONTAIJOUHOU = "01";

    private final String SUPOTTOSOUBA = "01";

    private final String DETAREKODOSUU = "01";

    private final String DETAREKODOBANGOU = "01";

    private final String BUNKATUKAIKEIUTIWAKESUU = "01";

    private final String KOUMOKUSUU01 = "01";

    private final String KAIKEISHORINAIYOU = "02";

    private final String SOUKINSASHIZU = "03";

    private final String KOUMOKUSUU03 = "03";

    private final String GAIKOKUSOUKINIRAI = "35";

    private final String GINKOURYAKUSHOU = "BK";

    private final String SHITENRYAKUSHOU = "BR";

    private final String KOUMOKUKETASUU146 = "146";

    private final String KOUMOKUKETASUU158 = "158";

    private final String KOUMOKUKETASUU192 = "192";

    private final String KOUMOKUKETASUU228 = "228";

    private final String DOUSHUREKODOSUU = "0006";

    private final String DOUSHUREKODOBANGOU1 = "0001";

    private final String DOUSHUREKODOBANGOU2 = "0002";

    private final String DOUSHUREKODOBANGOU3 = "0003";

    private final String DOUSHUREKODOBANGOU4 = "0004";

    private final String DOUSHUREKODOBANGOU5 = "0005";

    private final String DOUSHUREKODOBANGOU6 = "0006";

    private final String SOUKINSAKIMEIKIGOU = "BNN070";

    private final String SOUKINSAKIJUUSHOKIGOU = "BNA070";

    private final String SOUKINSAKIKOUZAKIGOU = "ACT034";

    private final String HISHIMUKEGINKOUKIGOU = "BAN035";

    private final String HISHIMUKESHITENKIGOU = "BAB035";

    private final String HISHIMUKEJUUSHOKIGOU = "BAA070";

    private final String IRAININMEIKIGOU = "APN140";

    private final String MESSAGEKIGOU = "MSG140";

    private final String KEIYUGINKOUKIGOU = "BTN035";

    private final String KEIYUSHITENKIGOU = "BTB035";

    private final String KEIYUJUUSHOKIGOU = "BTA070";

    private final String RENRAKUZIKOU1KIGOU = "ZZ1035";

    private final String RENRAKUZIKOU2KIGOU = "ZZ2035";

    private final String RENRAKUZIKOU3KIGOU = "ZZ3140";

    private final String JAPAN = "JAPAN";

    private final String GINKOUMEIKETA = "+";

    private final String SHITENMEIKETA = "++";

    private final String KOUZAMEIGININMEIKETA = "+++";

    private final String BANKCD_MIZUHO = "0001";

    private final String CHARGE_ZERO = "CHG 0";

    private final int ZERO = 0;

    private final char PADZERO = '0';

    private final int GAIKAGYOUMUCDKETA = 5;

    private final int SYORITUUBANKETA = 4;

    private final int SOUKINGKKETA = 15;

    private final int UTWKKINGKKETA = 15;

    private final int DATARECORDKENSUUKETA = 10;

    private final int HONTAIJYOUHOUKENSUUKETA = 10;

    private C_Gkgyoumucd gkgyoumucd;

    private BizDate denpyouDate;

    private int count;

    private int countHontai;

    private int shoritooruban;

    private int dateCount;

    List<BzGkFbsoukinFixedlengthRecordLayoutFile> dateLst;

    List<BzGkFbsoukinFixedlengthRecordLayoutFile> fileLst;

    @Inject
    private BizDomManager bizDomManager;

    @Inject
    private BzBatchParam bzBatchParam;

    @Inject
    private BzRecoveryDatasikibetuBean bzRecoveryDatasikibetuBean;

    public int getDateCount() {
        return dateCount;
    }

    public List<BzGkFbsoukinFixedlengthRecordLayoutFile> creadGaikaFBSoukinFwairu(C_ShrhousiteiKbn pShrhousiteiKbn,
        C_Gkgyoumucd pGkgyoumucd, BizDate pSyoriYmd, String pKakutyoujobcd) {

        gkgyoumucd = C_Gkgyoumucd.BLNK;
        denpyouDate = BizDate.valueOf(ZERO);
        count = ZERO;
        countHontai = ZERO;
        shoritooruban = ZERO;

        dateLst = new ArrayList<>();
        fileLst = new ArrayList<>();
        int dtCount = 0;

        C_Gkgyoumucd[] gkgyoumucds = null;
        BizDate dratekakuniYmd = null;

        if (C_Gkgyoumucd.BLNK.eq(pGkgyoumucd)) {

            gkgyoumucds = new C_Gkgyoumucd[2];
            gkgyoumucds[0] = C_Gkgyoumucd.GK_GKSOUKIN_SK;
            gkgyoumucds[1] = C_Gkgyoumucd.GK_GKSOUKIN_KH_SI;

            BM_SeisanDShrymd seisanDShrymd = bizDomManager.getSeisanDShrymd(BizDateY.valueOf(pSyoriYmd.getYear()));

            if (seisanDShrymd != null) {

                BizDate soudaikaiprevious = seisanDShrymd.getSeisandshrymd().addBusinessDays(-2);

                if (BizDateUtil.compareYmd(soudaikaiprevious, pSyoriYmd) == BizDateUtil.COMPARE_EQUAL) {

                    dratekakuniYmd = BizDate.valueOf(pSyoriYmd.getYear() +
                        YuyuHozenConfig.getInstance().getDrateKakuteiMd()).getRekijyou();
                }
            }
        }
        else {
            gkgyoumucds = new C_Gkgyoumucd[2];
            gkgyoumucds[0] = C_Gkgyoumucd.GK_GKNSOUKIN_NK_JIDOU_2EIGO;
            gkgyoumucds[1] = C_Gkgyoumucd.GK_GKNSOUKIN_NK_JIDOU_3EIGO;
        }

        try(ExDBResults<BT_GkFBSoukinData> soukinDataLst =
            bizDomManager.getGkFBSoukinDatasByKakutyoujobcdSyoriYmdShrhousiteikbnGkgyoumucds(
                pKakutyoujobcd, pSyoriYmd, pShrhousiteiKbn, dratekakuniYmd, gkgyoumucds)) {

            Iterator<BT_GkFBSoukinData> iterator = soukinDataLst.iterator();

            if (iterator.hasNext()) {
                while (iterator.hasNext()) {

                    BT_GkFBSoukinData soukinData = iterator.next();

                    bzRecoveryDatasikibetuBean.setIbKakutyoujobcd(pKakutyoujobcd);
                    bzRecoveryDatasikibetuBean.setIbTableid(BT_GkFBSoukinData.TABLE_NAME);
                    bzRecoveryDatasikibetuBean.setIbRecoveryfilterid(FBSOUKINDATA);
                    bzRecoveryDatasikibetuBean.setIbRecoveryfilterkey1(soukinData.getFbsoukindatasikibetukey());

                    if (C_Gkgyoumucd.BLNK.eq(gkgyoumucd)) {

                        gkgyoumucd = soukinData.getGkgyoumucd();
                        denpyouDate = soukinData.getDenymd();

                        createHeader();
                    }
                    else {

                        if (!denpyouDate.equals(soukinData.getDenymd()) || !gkgyoumucd.eq(soukinData.getGkgyoumucd())) {

                            fileLst.addAll(dateLst);

                            createTorera();

                            dtCount = dtCount + count;
                            count = ZERO;
                            countHontai = ZERO;

                            dateLst = new ArrayList<>();

                            gkgyoumucd = soukinData.getGkgyoumucd();
                            denpyouDate = soukinData.getDenymd();

                            createHeader();
                        }
                    }

                    createDateHontaiJouhou(soukinData);

                    createDateKaikeiShori(soukinData);

                    createDateSoukinsaki(soukinData);

                    createDateHishimuke(soukinData);

                    createDateIrainin();

                    createDateMessage(soukinData);

                    createDateKeiyuGinkou();

                    createDateRenrakuZikou(soukinData);

                    gkgyoumucd = soukinData.getGkgyoumucd();
                    denpyouDate = soukinData.getDenymd();
                }

                fileLst.addAll(dateLst);

                bzRecoveryDatasikibetuBean.initializeBlank();

                createTorera();

                dtCount = dtCount + count;
            }
            else {

                createHeader();

                createTorera();
            }

            createEnd();

            dateCount = dtCount;
        }

        return fileLst;
    }

    private void createHeader() {

        BzGkFbsoukinHeaderRecordLayoutFile bzGkFbsoukinHeaderRecordLayoutFile =
            SWAKInjector.getInstance(BzGkFbsoukinHeaderRecordLayoutFile.class);
        BzGkFbsoukinFixedlengthRecordLayoutFile bzGkFbsoukinFixedlengthRecordLayoutFile =
            SWAKInjector.getInstance(BzGkFbsoukinFixedlengthRecordLayoutFile.class);
        BzRenkeiHenkanUtil<BzGkFbsoukinHeaderRecordLayoutFile, BzGkFbsoukinHeaderRecordLayoutFile>
        bzRenkeiHenkanUtilHeader = new BzRenkeiHenkanUtil<>();

        bzGkFbsoukinHeaderRecordLayoutFile.setIffFbdatakbn(HEADERRECORD);
        bzGkFbsoukinHeaderRecordLayoutFile.setIffFbsyubetucd(GAIKOKUSOUKINIRAI);
        bzGkFbsoukinHeaderRecordLayoutFile.setIffFbcdkbn(EBCDIC);
        bzGkFbsoukinHeaderRecordLayoutFile.setIffFbhrkmirainincd(YuyuBizConfig.getInstance().getGksokinKaisyaCd());
        bzGkFbsoukinHeaderRecordLayoutFile.setIffFbhrkmiraininnm(YuyuBizConfig.getInstance().getGksokinKaisyaNmej());
        bzGkFbsoukinHeaderRecordLayoutFile.setIffFbhrkmmd(denpyouDate.getBizDateMD().toString());
        bzGkFbsoukinHeaderRecordLayoutFile.setIffFbbankcd(YuyuBizConfig.getInstance().getGksokinBankCd());
        bzGkFbsoukinHeaderRecordLayoutFile.setIffFbbanknmkn(YuyuBizConfig.getInstance().getGksokinBankNmej());
        bzGkFbsoukinHeaderRecordLayoutFile.setIffFbsitencd(YuyuBizConfig.getInstance().getGksokinSitenCd());
        bzGkFbsoukinHeaderRecordLayoutFile.setIffFbsitennmkn(YuyuBizConfig.getInstance().getGksokinSitenNmej());
        bzGkFbsoukinHeaderRecordLayoutFile.setIffFbdummy150("");
        bzGkFbsoukinHeaderRecordLayoutFile.setIffFbgaikagyoumucd(Strings.padStart(gkgyoumucd.getValue(), GAIKAGYOUMUCDKETA, PADZERO));

        bzRenkeiHenkanUtilHeader.initialize(BzGkFbsoukinHeaderRecordLayoutFile.class,
            C_SystemRenkeiSyoriHousikiKbn.FILE_RENKEI, C_SystemRenkeiHenkanHoukouKbn.RAY_TO_OTHER,
            C_SystemRenkeiFileSyubetuKbn.TXT_FIXEDLENGTH);

        BzGkFbsoukinHeaderRecordLayoutFile henkanBean =
            bzRenkeiHenkanUtilHeader.convDouituBean(bzGkFbsoukinHeaderRecordLayoutFile);

        bzGkFbsoukinFixedlengthRecordLayoutFile.setIffFbgkfixedlengthdata(
            FixedlengthConvertUtil.beanToStringForFixedlength(henkanBean));

        fileLst.add(bzGkFbsoukinFixedlengthRecordLayoutFile);

    }

    private void createDateHontaiJouhou(BT_GkFBSoukinData pSoukinData) {

        BT_GkFBSoukinHukaInfo soukinHukaInfo = pSoukinData.getGkFBSoukinHukaInfo();

        BzGkFbsoukinHontaiRecordLayoutFile bzGkFbsoukinHontaiRecordLayoutFile =
            SWAKInjector.getInstance(BzGkFbsoukinHontaiRecordLayoutFile.class);

        bzGkFbsoukinHontaiRecordLayoutFile.setIffFbdatakbn(DETARECORD);
        bzGkFbsoukinHontaiRecordLayoutFile.setIffFbdatarecordkbn(HONTAIJOUHOU);
        bzGkFbsoukinHontaiRecordLayoutFile.setIffFbsyorituuban(Strings.padStart(String.valueOf(++shoritooruban), SYORITUUBANKETA, PADZERO));
        bzGkFbsoukinHontaiRecordLayoutFile.setIffFbtorihikisakisyoukaino(soukinHukaInfo.getFbtrhksyoukaino());
        bzGkFbsoukinHontaiRecordLayoutFile.setIffFbtuukasyurui(pSoukinData.getShrtuukasyu().getValue());
        bzGkFbsoukinHontaiRecordLayoutFile.setIffFbsyousuuketa(SHOUSUUKETA);
        bzGkFbsoukinHontaiRecordLayoutFile.setIffFbsoukingk(Strings.padStart(pSoukinData.getGaikashrgk().toAdsoluteString(), SOUKINGKKETA, PADZERO));
        bzGkFbsoukinHontaiRecordLayoutFile.setIffFbkansantuukasyurui("");
        bzGkFbsoukinHontaiRecordLayoutFile.setIffFbenkataikagk("");
        bzGkFbsoukinHontaiRecordLayoutFile.setIffFbsoukinsyuruikbn(DENSHINSOUKIN);
        bzGkFbsoukinHontaiRecordLayoutFile.setIffFbdensinsyuruikbn("");
        bzGkFbsoukinHontaiRecordLayoutFile.setIffFbsiharaikbn(TUUTIHARA);
        bzGkFbsoukinHontaiRecordLayoutFile.setIffFbtesuuryousiharaikbn(SOUKINSHIHARAIHITO);
        bzGkFbsoukinHontaiRecordLayoutFile.setIffFbsoukinmokutekicd(
            YuyuBizConfig.getInstance().getGksoukinmokutekicd());
        bzGkFbsoukinHontaiRecordLayoutFile.setIffFbsoukinmokutekinaiyou(
            YuyuBizConfig.getInstance().getGksoukinmokutekinaiyou());
        bzGkFbsoukinHontaiRecordLayoutFile.setIffFblicenseno("");
        bzGkFbsoukinHontaiRecordLayoutFile.setIffFblicenseymd("");
        bzGkFbsoukinHontaiRecordLayoutFile.setIffFbdummy121("");
        bzGkFbsoukinHontaiRecordLayoutFile.setIffFbkokyakusikibetuno(pSoukinData.getKeirisyono());

        changeDate(BzGkFbsoukinHontaiRecordLayoutFile.class, bzGkFbsoukinHontaiRecordLayoutFile);

        count++;
        countHontai++;
    }

    private void createDateKaikeiShori(BT_GkFBSoukinData pSoukinData) {

        BzGkFbsoukinKaikeiRecordLayoutFile bzGkFbsoukinKaikeiRecordLayoutFile =
            SWAKInjector.getInstance(BzGkFbsoukinKaikeiRecordLayoutFile.class);

        String gksoukinmototuukasyurui = "";
        String gksoukinmotoyokinsyumokukbn = "";
        String gksoukinmotokouzabangou = "";

        if (C_Tuukasyu.USD.eq(pSoukinData.getShrtuukasyu())) {
            gksoukinmototuukasyurui     = YuyuBizConfig.getInstance().getGkkouzatuukasyu().getValue();
            gksoukinmotoyokinsyumokukbn = YuyuBizConfig.getInstance().getGksokinYokinKbn();
            gksoukinmotokouzabangou     = YuyuBizConfig.getInstance().getGksokinKzNo();
        } else if (C_Tuukasyu.AUD.eq(pSoukinData.getShrtuukasyu())) {
            gksoukinmototuukasyurui     = YuyuBizConfig.getInstance().getGkkouzatuukasyu2().getValue();
            gksoukinmotoyokinsyumokukbn = YuyuBizConfig.getInstance().getGksokinYokinKbn2();
            gksoukinmotokouzabangou     = YuyuBizConfig.getInstance().getGksokinKzNo2();
        }


        bzGkFbsoukinKaikeiRecordLayoutFile.setIffFbdatakbn(DETARECORD);
        bzGkFbsoukinKaikeiRecordLayoutFile.setIffFbdatarecordkbn(KAIKEISHORINAIYOU);
        bzGkFbsoukinKaikeiRecordLayoutFile.setIffFbdatarecordsuu(DETAREKODOSUU);
        bzGkFbsoukinKaikeiRecordLayoutFile.setIffFbdatarecordno(DETAREKODOBANGOU);
        bzGkFbsoukinKaikeiRecordLayoutFile.setIffFbbunkatukaikeiutwksuu(BUNKATUKAIKEIUTIWAKESUU);
        bzGkFbsoukinKaikeiRecordLayoutFile.setIffFbsoubakbn(SUPOTTOSOUBA);
        bzGkFbsoukinKaikeiRecordLayoutFile.setIffFbutwktuukasyurui(pSoukinData.getShrtuukasyu().getValue());
        bzGkFbsoukinKaikeiRecordLayoutFile.setIffFbutwksyousuuketa(SHOUSUUKETA);
        bzGkFbsoukinKaikeiRecordLayoutFile.setIffFbutwkkingk(Strings.padStart(pSoukinData.getGaikashrgk().toAdsoluteString(), UTWKKINGKKETA, PADZERO));
        bzGkFbsoukinKaikeiRecordLayoutFile.setIffFbdummy3("");
        bzGkFbsoukinKaikeiRecordLayoutFile.setIffFbdummyn1("");
        bzGkFbsoukinKaikeiRecordLayoutFile.setIffFbenkataikagk("");
        bzGkFbsoukinKaikeiRecordLayoutFile.setIffFbyoyakuno("");
        bzGkFbsoukinKaikeiRecordLayoutFile.setIffFbhktskouzatuukasyurui(
            gksoukinmototuukasyurui);
        bzGkFbsoukinKaikeiRecordLayoutFile.setIffFbhktskouzasyurui(gksoukinmotoyokinsyumokukbn);
        bzGkFbsoukinKaikeiRecordLayoutFile.setIffFbhktskouzano(gksoukinmotokouzabangou);
        bzGkFbsoukinKaikeiRecordLayoutFile.setIffFbdummy10("");
        bzGkFbsoukinKaikeiRecordLayoutFile.setIffFbkaikeiutwk2("");
        bzGkFbsoukinKaikeiRecordLayoutFile.setIffFbkaikeiutwk3("");
        bzGkFbsoukinKaikeiRecordLayoutFile.setIffFbdummy1("");

        changeDate(BzGkFbsoukinKaikeiRecordLayoutFile.class, bzGkFbsoukinKaikeiRecordLayoutFile);

        count++;
    }

    private void createDateSoukinsaki(BT_GkFBSoukinData pSoukinData) {

        BzGkFbsoukinSksakiRecordLayoutFile bzGkFbsoukinSksakiRecordLayoutFile =
            SWAKInjector.getInstance(BzGkFbsoukinSksakiRecordLayoutFile.class);

        String kouzamei = "";

        if (pSoukinData.getKzmeiginmei().length() > 70) {

            kouzamei = pSoukinData.getKzmeiginmei().substring(0, 67) + KOUZAMEIGININMEIKETA;
        }
        else {
            kouzamei = pSoukinData.getKzmeiginmei();
        }

        bzGkFbsoukinSksakiRecordLayoutFile.setIffFbdatakbn(DETARECORD);
        bzGkFbsoukinSksakiRecordLayoutFile.setIffFbdatarecordkbn(SOUKINSASHIZU);
        bzGkFbsoukinSksakiRecordLayoutFile.setIffFbdousyurecordsuu(DOUSHUREKODOSUU);
        bzGkFbsoukinSksakiRecordLayoutFile.setIffFbdousyurecordno(DOUSHUREKODOBANGOU1);
        bzGkFbsoukinSksakiRecordLayoutFile.setIffFbkoumokusuu(KOUMOKUSUU03);
        bzGkFbsoukinSksakiRecordLayoutFile.setIffFbkoumokuketasuu(KOUMOKUKETASUU192);
        bzGkFbsoukinSksakiRecordLayoutFile.setIffFbuketorininnmkigou(SOUKINSAKIMEIKIGOU);
        bzGkFbsoukinSksakiRecordLayoutFile.setIffFbuketorininnmdata(kouzamei);
        bzGkFbsoukinSksakiRecordLayoutFile.setIffFbjyuusyokigou(SOUKINSAKIJUUSHOKIGOU);
        bzGkFbsoukinSksakiRecordLayoutFile.setIffFbjyuusyodata(JAPAN);
        bzGkFbsoukinSksakiRecordLayoutFile.setIffFbsoukinsakikouzanokigou(SOUKINSAKIKOUZAKIGOU);
        bzGkFbsoukinSksakiRecordLayoutFile.setIffFbsoukinsakikouzanodata(pSoukinData.getKouzano());
        bzGkFbsoukinSksakiRecordLayoutFile.setIffFbdummy42("");

        changeDate(BzGkFbsoukinSksakiRecordLayoutFile.class, bzGkFbsoukinSksakiRecordLayoutFile);

        count++;
    }

    private void createDateHishimuke(BT_GkFBSoukinData pSoukinData) {

        BzGkFbsoukinHisimukeRecordLayoutFile bzGkFbsoukinHisimukeRecordLayoutFile =
            SWAKInjector.getInstance(BzGkFbsoukinHisimukeRecordLayoutFile.class);

        String bankNm = "";
        String shitenNm = "";

        if (pSoukinData.getBanknmej().length() > 35) {

            bankNm = pSoukinData.getBanknmej().substring(0, 34) + GINKOUMEIKETA;
        }
        else {

            bankNm = pSoukinData.getBanknmej();
        }

        if (pSoukinData.getSitennmej().length() > 35) {

            shitenNm = pSoukinData.getSitennmej().substring(0, 33) + SHITENMEIKETA;
        }
        else {

            shitenNm = pSoukinData.getSitennmej();
        }

        bzGkFbsoukinHisimukeRecordLayoutFile.setIffFbdatakbn(DETARECORD);
        bzGkFbsoukinHisimukeRecordLayoutFile.setIffFbdatarecordkbn(SOUKINSASHIZU);
        bzGkFbsoukinHisimukeRecordLayoutFile.setIffFbdousyurecordsuu(DOUSHUREKODOSUU);
        bzGkFbsoukinHisimukeRecordLayoutFile.setIffFbdousyurecordno(DOUSHUREKODOBANGOU2);
        bzGkFbsoukinHisimukeRecordLayoutFile.setIffFbkoumokusuu(KOUMOKUSUU03);
        bzGkFbsoukinHisimukeRecordLayoutFile.setIffFbkoumokuketasuu(KOUMOKUKETASUU158);
        bzGkFbsoukinHisimukeRecordLayoutFile.setIffFbbanknmkigou(HISHIMUKEGINKOUKIGOU);
        bzGkFbsoukinHisimukeRecordLayoutFile.setIffFbbanknmdata(bankNm);
        bzGkFbsoukinHisimukeRecordLayoutFile.setIffFbsitenmeikigou(HISHIMUKESHITENKIGOU);
        bzGkFbsoukinHisimukeRecordLayoutFile.setIffFbsitenmeidata(shitenNm);
        bzGkFbsoukinHisimukeRecordLayoutFile.setIffFbjyuusyokigou(HISHIMUKEJUUSHOKIGOU);
        bzGkFbsoukinHisimukeRecordLayoutFile.setIffFbjyuusyodata(
            JAPAN + " " + GINKOURYAKUSHOU + pSoukinData.getBankcd() + " " + SHITENRYAKUSHOU + pSoukinData.getSitencd());
        bzGkFbsoukinHisimukeRecordLayoutFile.setIffFbdummy69("");
        bzGkFbsoukinHisimukeRecordLayoutFile.setIffFbbankcd(pSoukinData.getBankcd());
        bzGkFbsoukinHisimukeRecordLayoutFile.setIffFbsitencd(pSoukinData.getSitencd());

        changeDate(BzGkFbsoukinHisimukeRecordLayoutFile.class, bzGkFbsoukinHisimukeRecordLayoutFile);

        count++;
    }

    private void createDateIrainin() {

        BzGkFbsoukinIraininRecordLayoutFile bzGkFbsoukinIraininRecordLayoutFile =
            SWAKInjector.getInstance(BzGkFbsoukinIraininRecordLayoutFile.class);

        bzGkFbsoukinIraininRecordLayoutFile.setIffFbdatakbn(DETARECORD);
        bzGkFbsoukinIraininRecordLayoutFile.setIffFbdatarecordkbn(SOUKINSASHIZU);
        bzGkFbsoukinIraininRecordLayoutFile.setIffFbdousyurecordsuu(DOUSHUREKODOSUU);
        bzGkFbsoukinIraininRecordLayoutFile.setIffFbdousyurecordno(DOUSHUREKODOBANGOU3);
        bzGkFbsoukinIraininRecordLayoutFile.setIffFbkoumokusuu(KOUMOKUSUU01);
        bzGkFbsoukinIraininRecordLayoutFile.setIffFbkoumokuketasuu(KOUMOKUKETASUU146);
        bzGkFbsoukinIraininRecordLayoutFile.setIffFbiraininnmkigou(IRAININMEIKIGOU);
        bzGkFbsoukinIraininRecordLayoutFile.setIffFbiraininnmdata("");
        bzGkFbsoukinIraininRecordLayoutFile.setIffFbdummy88("");

        changeDate(BzGkFbsoukinIraininRecordLayoutFile.class, bzGkFbsoukinIraininRecordLayoutFile);

        count++;
    }

    private void createDateMessage(BT_GkFBSoukinData pSoukinData) {

        String messagedata = "";

        if (BANKCD_MIZUHO.equals(pSoukinData.getBankcd())) {
            messagedata = CHARGE_ZERO;
        }

        BzGkFbsoukinMessageRecordLayoutFile bzGkFbsoukinMessageRecordLayoutFile =
            SWAKInjector.getInstance(BzGkFbsoukinMessageRecordLayoutFile.class);

        bzGkFbsoukinMessageRecordLayoutFile.setIffFbdatakbn(DETARECORD);
        bzGkFbsoukinMessageRecordLayoutFile.setIffFbdatarecordkbn(SOUKINSASHIZU);
        bzGkFbsoukinMessageRecordLayoutFile.setIffFbdousyurecordsuu(DOUSHUREKODOSUU);
        bzGkFbsoukinMessageRecordLayoutFile.setIffFbdousyurecordno(DOUSHUREKODOBANGOU4);
        bzGkFbsoukinMessageRecordLayoutFile.setIffFbkoumokusuu(KOUMOKUSUU01);
        bzGkFbsoukinMessageRecordLayoutFile.setIffFbkoumokuketasuu(KOUMOKUKETASUU146);
        bzGkFbsoukinMessageRecordLayoutFile.setIffFbmessagekigou(MESSAGEKIGOU);
        bzGkFbsoukinMessageRecordLayoutFile.setIffFbmessagedata(messagedata);
        bzGkFbsoukinMessageRecordLayoutFile.setIffFbdummy88("");

        changeDate(BzGkFbsoukinMessageRecordLayoutFile.class, bzGkFbsoukinMessageRecordLayoutFile);

        count++;
    }

    private void createDateKeiyuGinkou() {

        BzGkFbsoukinKeiyuRecordLayoutFile bzGkFbsoukinKeiyuRecordLayoutFile =
            SWAKInjector.getInstance(BzGkFbsoukinKeiyuRecordLayoutFile.class);

        bzGkFbsoukinKeiyuRecordLayoutFile.setIffFbdatakbn(DETARECORD);
        bzGkFbsoukinKeiyuRecordLayoutFile.setIffFbdatarecordkbn(SOUKINSASHIZU);
        bzGkFbsoukinKeiyuRecordLayoutFile.setIffFbdousyurecordsuu(DOUSHUREKODOSUU);
        bzGkFbsoukinKeiyuRecordLayoutFile.setIffFbdousyurecordno(DOUSHUREKODOBANGOU5);
        bzGkFbsoukinKeiyuRecordLayoutFile.setIffFbkoumokusuu(KOUMOKUSUU03);
        bzGkFbsoukinKeiyuRecordLayoutFile.setIffFbkoumokuketasuu(KOUMOKUKETASUU158);
        bzGkFbsoukinKeiyuRecordLayoutFile.setIffFbbanknmkigou(KEIYUGINKOUKIGOU);
        bzGkFbsoukinKeiyuRecordLayoutFile.setIffFbbanknmdata("");
        bzGkFbsoukinKeiyuRecordLayoutFile.setIffFbsitenmeikigou(KEIYUSHITENKIGOU);
        bzGkFbsoukinKeiyuRecordLayoutFile.setIffFbsitenmeidata("");
        bzGkFbsoukinKeiyuRecordLayoutFile.setIffFbjyuusyokigou(KEIYUJUUSHOKIGOU);
        bzGkFbsoukinKeiyuRecordLayoutFile.setIffFbjyuusyodata("");
        bzGkFbsoukinKeiyuRecordLayoutFile.setIffFbdummy76("");

        changeDate(BzGkFbsoukinKeiyuRecordLayoutFile.class, bzGkFbsoukinKeiyuRecordLayoutFile);

        count++;
    }

    private void createDateRenrakuZikou(BT_GkFBSoukinData pSoukinData) {

        BzGkFbsoukinRenrakuRecordLayoutFile bzGkFbsoukinRenrakuRecordLayoutFile =
            SWAKInjector.getInstance(BzGkFbsoukinRenrakuRecordLayoutFile.class);

        String renraku1 = "";
        String renraku2 = "";
        String renraku3 = "";

        if (pSoukinData.getBanknmej().length() > 35) {

            renraku1 = GINKOUMEIKETA + pSoukinData.getBanknmej().substring(34, pSoukinData.getBanknmej().length());
        }

        if (pSoukinData.getSitennmej().length() > 35) {

            renraku2 = SHITENMEIKETA + pSoukinData.getSitennmej().substring(33, pSoukinData.getSitennmej().length());
        }

        if (pSoukinData.getKzmeiginmei().length() > 70) {
            if (pSoukinData.getKzmeiginmei().length() > 134) {

                renraku3 = KOUZAMEIGININMEIKETA +
                    pSoukinData.getKzmeiginmei().substring(67, 134);
            }
            else {

                renraku3 = KOUZAMEIGININMEIKETA +
                    pSoukinData.getKzmeiginmei().substring(67, pSoukinData.getKzmeiginmei().length());
            }
        }

        bzGkFbsoukinRenrakuRecordLayoutFile.setIffFbdatakbn(DETARECORD);
        bzGkFbsoukinRenrakuRecordLayoutFile.setIffFbdatarecordkbn(SOUKINSASHIZU);
        bzGkFbsoukinRenrakuRecordLayoutFile.setIffFbdousyurecordsuu(DOUSHUREKODOSUU);
        bzGkFbsoukinRenrakuRecordLayoutFile.setIffFbdousyurecordno(DOUSHUREKODOBANGOU6);
        bzGkFbsoukinRenrakuRecordLayoutFile.setIffFbkoumokusuu(KOUMOKUSUU03);
        bzGkFbsoukinRenrakuRecordLayoutFile.setIffFbkoumokuketasuu(KOUMOKUKETASUU228);
        bzGkFbsoukinRenrakuRecordLayoutFile.setIffFbrenrakujikou1kigou(RENRAKUZIKOU1KIGOU);
        bzGkFbsoukinRenrakuRecordLayoutFile.setIffFbrenrakujikou1data(renraku1);
        bzGkFbsoukinRenrakuRecordLayoutFile.setIffFbrenrakujikou2kigou(RENRAKUZIKOU2KIGOU);
        bzGkFbsoukinRenrakuRecordLayoutFile.setIffFbrenrakujikou2data(renraku2);
        bzGkFbsoukinRenrakuRecordLayoutFile.setIffFbrenrakujikou3kigou(RENRAKUZIKOU3KIGOU);
        bzGkFbsoukinRenrakuRecordLayoutFile.setIffFbrenrakujikou3data(renraku3);
        bzGkFbsoukinRenrakuRecordLayoutFile.setIffFbdummy6("");

        changeDate(BzGkFbsoukinRenrakuRecordLayoutFile.class, bzGkFbsoukinRenrakuRecordLayoutFile);

        count++;
    }

    private <T> void changeDate(Class<T> T1, T T2) {

        BzGkFbsoukinFixedlengthRecordLayoutFile bzGkFbsoukinFixedlengthRecordLayoutFile =
            SWAKInjector.getInstance(BzGkFbsoukinFixedlengthRecordLayoutFile.class);

        BzRenkeiHenkanUtil<T, T> bzRenkeiHenkanUtilDate = new BzRenkeiHenkanUtil<>();

        bzRenkeiHenkanUtilDate.initialize(T1, C_SystemRenkeiSyoriHousikiKbn.FILE_RENKEI,
            C_SystemRenkeiHenkanHoukouKbn.RAY_TO_OTHER, C_SystemRenkeiFileSyubetuKbn.TXT_FIXEDLENGTH);

        T henkanBean = bzRenkeiHenkanUtilDate.convDouituBean(T2);

        bzGkFbsoukinFixedlengthRecordLayoutFile.setIffFbgkfixedlengthdata(
            FixedlengthConvertUtil.beanToStringForFixedlength(henkanBean));

        dateLst.add(bzGkFbsoukinFixedlengthRecordLayoutFile);
    }

    private void createTorera() {

        BzGkFbsoukinTrailerRecordLayoutFile bzGkFbsoukinTrailerRecordLayoutFile =
            SWAKInjector.getInstance(BzGkFbsoukinTrailerRecordLayoutFile.class);

        BzGkFbsoukinFixedlengthRecordLayoutFile bzGkFbsoukinFixedlengthRecordLayoutFile =
            SWAKInjector.getInstance(BzGkFbsoukinFixedlengthRecordLayoutFile.class);

        bzGkFbsoukinTrailerRecordLayoutFile.setIffFbdatakbn(TORERARECORD);
        bzGkFbsoukinTrailerRecordLayoutFile.setIffFbdatarecordkensuu10(Strings.padStart(String.valueOf(count), DATARECORDKENSUUKETA, PADZERO));
        bzGkFbsoukinTrailerRecordLayoutFile.setIffFbhontaijyouhoukensuu(Strings.padStart(String.valueOf(countHontai), HONTAIJYOUHOUKENSUUKETA, PADZERO));
        bzGkFbsoukinTrailerRecordLayoutFile.setIffFbdummy229("");

        BzRenkeiHenkanUtil<BzGkFbsoukinTrailerRecordLayoutFile, BzGkFbsoukinTrailerRecordLayoutFile>
        bzRenkeiHenkanUtilTorera = new BzRenkeiHenkanUtil<>();

        bzRenkeiHenkanUtilTorera.initialize(BzGkFbsoukinTrailerRecordLayoutFile.class,
            C_SystemRenkeiSyoriHousikiKbn.FILE_RENKEI, C_SystemRenkeiHenkanHoukouKbn.RAY_TO_OTHER,
            C_SystemRenkeiFileSyubetuKbn.TXT_FIXEDLENGTH);

        BzGkFbsoukinTrailerRecordLayoutFile henkanBean =
            bzRenkeiHenkanUtilTorera.convDouituBean(bzGkFbsoukinTrailerRecordLayoutFile);

        bzGkFbsoukinFixedlengthRecordLayoutFile.setIffFbgkfixedlengthdata(
            FixedlengthConvertUtil.beanToStringForFixedlength(henkanBean));

        fileLst.add(bzGkFbsoukinFixedlengthRecordLayoutFile);
    }

    private void createEnd() {

        BzGkFbsoukinEndRecordLayoutFile bzGkFbsoukinEndRecordLayoutFile =
            SWAKInjector.getInstance(BzGkFbsoukinEndRecordLayoutFile.class);

        BzGkFbsoukinFixedlengthRecordLayoutFile bzGkFbsoukinFixedlengthRecordLayoutFile =
            SWAKInjector.getInstance(BzGkFbsoukinFixedlengthRecordLayoutFile.class);

        bzGkFbsoukinEndRecordLayoutFile.setIffFbdatakbn(ENDRECORD);
        bzGkFbsoukinEndRecordLayoutFile.setIffFbdummy249("");

        BzRenkeiHenkanUtil<BzGkFbsoukinEndRecordLayoutFile, BzGkFbsoukinEndRecordLayoutFile>
        bzRenkeiHenkanUtilEnd = new BzRenkeiHenkanUtil<>();

        bzRenkeiHenkanUtilEnd.initialize(BzGkFbsoukinEndRecordLayoutFile.class,
            C_SystemRenkeiSyoriHousikiKbn.FILE_RENKEI, C_SystemRenkeiHenkanHoukouKbn.RAY_TO_OTHER,
            C_SystemRenkeiFileSyubetuKbn.TXT_FIXEDLENGTH);

        BzGkFbsoukinEndRecordLayoutFile henkanBean =
            bzRenkeiHenkanUtilEnd.convDouituBean(bzGkFbsoukinEndRecordLayoutFile);

        bzGkFbsoukinFixedlengthRecordLayoutFile.setIffFbgkfixedlengthdata(
            FixedlengthConvertUtil.beanToStringForFixedlength(henkanBean));

        fileLst.add(bzGkFbsoukinFixedlengthRecordLayoutFile);
    }
}
