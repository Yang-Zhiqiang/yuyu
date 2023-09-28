package yuyu.common.biz.kaikei;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.ExDBResults;
import jp.co.slcs.swak.file.util.FixedlengthConvertUtil;
import jp.co.slcs.swak.number.BizCurrency;
import yuyu.common.biz.bzcommon.BzBatchParam;
import yuyu.common.biz.bzcommon.BzGetBankData;
import yuyu.common.biz.bzcommon.BzGetBankDataBean;
import yuyu.common.biz.bzcommon.BzRenkeiHenkanUtil;
import yuyu.common.biz.kaikei.dba4bzfbsoukinfilesks.BzFbSoukinFileSksDao;
import yuyu.def.biz.bean.param.BzRecoveryDatasikibetuBean;
import yuyu.def.biz.configuration.YuyuBizConfig;
import yuyu.def.biz.file.fixedlength.BzFbsoukinDataRecordLayoutFile;
import yuyu.def.biz.file.fixedlength.BzFbsoukinEndRecordLayoutFile;
import yuyu.def.biz.file.fixedlength.BzFbsoukinFixedlengthRecordLayoutFile;
import yuyu.def.biz.file.fixedlength.BzFbsoukinHeaderRecordLayoutFile;
import yuyu.def.biz.file.fixedlength.BzFbsoukinTrailerRecordLayoutFile;
import yuyu.def.classification.C_BankmasterUmuKbn;
import yuyu.def.classification.C_FbSoukinBatchKbn;
import yuyu.def.classification.C_Gyoumucd;
import yuyu.def.classification.C_Kokunaikwskameihyj;
import yuyu.def.classification.C_ShrhousiteiKbn;
import yuyu.def.classification.C_SystemRenkeiFileSyubetuKbn;
import yuyu.def.classification.C_SystemRenkeiHenkanHoukouKbn;
import yuyu.def.classification.C_SystemRenkeiSyoriHousikiKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.db.entity.BT_FBSoukinData;
import yuyu.def.db.entity.BT_FBSoukinHukaInfo;

import com.google.common.base.Strings;

/**
 * 業務共通 経理・会計 ＦＢ送金ファイル作成
 */
public class BzFbSoukinFileSks {

    private final String FBSOUKINDATA = "Bz107";

    private final String HEADERRECORD = "1";

    private final String DATERECORD = "2";

    private final String TORERARECORD = "8";

    private final String ENDORECORD = "9";

    private final String EBCDIC = "1";

    private final String SONOTA = "0";

    private final String EDNSHINATUKAI = "7";

    private final String SOUGOUHURIKOMI = "21";

    private final String ZERO_4KETA = "0000";

    private final String ZERO_10KETA = "0000000000";

    private final char PADZERO = '0';

    private final int GYOUMUCDKETA = 4;

    private final int FURIKOMIGKKETA = 10;

    private final int DTRECORDKENSUUKETA = 6;

    private final int FURIKOMIGKKEIKETA = 12;

    private final String SMBC = "0009";

    private C_Gyoumucd gyoumuCd;

    private BizDate denpyouDate;

    private BizCurrency soukinGakuGoukei;

    private int count;

    private int dateCount;

    private List<BzFbsoukinFixedlengthRecordLayoutFile> dateLst;

    private List<BzFbsoukinFixedlengthRecordLayoutFile> soukinLst;

    BzRenkeiHenkanUtil<BzFbsoukinDataRecordLayoutFile, BzFbsoukinDataRecordLayoutFile> bzRenkeiHenkanUtilDate;

    @Inject
    private BzBatchParam bzBatchParam;

    @Inject
    private BzRecoveryDatasikibetuBean bzRecoveryDatasikibetuBean;

    @Inject
    private BzFbSoukinFileSksDao bzFbSoukinFileSksDao;

    public int getDateCount() {
        return dateCount;
    }

    public List<BzFbsoukinFixedlengthRecordLayoutFile> creadFBsoukinfwairu(BizDate pSyoriYmd,
        String pKakutyoujobcd, C_FbSoukinBatchKbn pFbSoukinBatchKbn, C_ShrhousiteiKbn... pShrhousiteiKbn) {

        gyoumuCd = C_Gyoumucd.BLNK;
        denpyouDate = BizDate.valueOf(0);
        soukinGakuGoukei = BizCurrency.valueOf(0);
        count = 0;
        C_ShrhousiteiKbn shrhousiteiKbn = C_ShrhousiteiKbn.BLNK;

        dateLst = new ArrayList<>();
        soukinLst = new ArrayList<>();

        try(ExDBResults<BT_FBSoukinData> soukinDatas =
            bzFbSoukinFileSksDao.getFBSoukinFileDatas
            (pKakutyoujobcd, pSyoriYmd, pFbSoukinBatchKbn, pShrhousiteiKbn)) {

            Iterator<BT_FBSoukinData> iterator = soukinDatas.iterator();

            if (iterator.hasNext()) {
                while (iterator.hasNext()) {

                    BT_FBSoukinData soukinData = iterator.next();

                    bzRecoveryDatasikibetuBean.setIbKakutyoujobcd(pKakutyoujobcd);
                    bzRecoveryDatasikibetuBean.setIbTableid(BT_FBSoukinData.TABLE_NAME);
                    bzRecoveryDatasikibetuBean.setIbRecoveryfilterid(FBSOUKINDATA);
                    bzRecoveryDatasikibetuBean.setIbRecoveryfilterkey1(soukinData.getFbsoukindatasikibetukey());

                    if (C_Gyoumucd.BLNK.eq(gyoumuCd)) {

                        gyoumuCd = soukinData.getGyoumucd();
                        denpyouDate = soukinData.getDenymd();

                        createHeader();
                    }
                    else {
                        if (!soukinData.getGyoumucd().eq(gyoumuCd)) {

                            soukinLst.addAll(dateLst);

                            createTorera();

                            dateCount = dateCount + count;
                            count = 0;
                            soukinGakuGoukei = BizCurrency.valueOf(0);
                            dateLst = new ArrayList<>();

                            gyoumuCd = soukinData.getGyoumucd();
                            denpyouDate = soukinData.getDenymd();

                            createHeader();
                        }
                    }

                    createData(soukinData, pFbSoukinBatchKbn);

                    gyoumuCd = soukinData.getGyoumucd();
                    denpyouDate = soukinData.getDenymd();

                }

                if (dateLst.size() > 0) {

                    soukinLst.addAll(dateLst);
                }

                bzRecoveryDatasikibetuBean.initializeBlank();

                createTorera();

                dateCount = dateCount + count;

            }
            else {

                gyoumuCd = C_Gyoumucd.GK_YENSOUKIN_SK;

                shrhousiteiKbn = pShrhousiteiKbn[0];

                if (C_ShrhousiteiKbn.FB_SOUDAIKAI_YOKUEI.eq(shrhousiteiKbn)) {

                    shrhousiteiKbn = C_ShrhousiteiKbn.FB_3EIGYOUBI;
                }
                BzShiharaiDenpyouDateShutoku bzShiharaiDenpyouDateShutoku =
                    SWAKInjector.getInstance(BzShiharaiDenpyouDateShutoku.class);

                denpyouDate = bzShiharaiDenpyouDateShutoku.exec(pSyoriYmd, shrhousiteiKbn, C_Tuukasyu.JPY, SMBC);

                createHeader();
                createTorera();
            }
            creadEndore();
        }

        return soukinLst;
    }

    void createHeader() {

        BzFbsoukinHeaderRecordLayoutFile bzFbsoukinHeaderRecordLayoutFile =
            SWAKInjector.getInstance(BzFbsoukinHeaderRecordLayoutFile.class);

        BzFbsoukinFixedlengthRecordLayoutFile bzFbsoukinFixedlengthRecordLayoutFile =
            SWAKInjector.getInstance(BzFbsoukinFixedlengthRecordLayoutFile.class);

        bzFbsoukinHeaderRecordLayoutFile.setIffFbdatakbn(HEADERRECORD);
        bzFbsoukinHeaderRecordLayoutFile.setIffFbsyubetucd(SOUGOUHURIKOMI);
        bzFbsoukinHeaderRecordLayoutFile.setIffFbcdkbn(EBCDIC);
        bzFbsoukinHeaderRecordLayoutFile.setIffFbhrkmirainincd(YuyuBizConfig.getInstance().getSokinKaisyaCd());
        bzFbsoukinHeaderRecordLayoutFile.setIffFbhrkmiraininnm(YuyuBizConfig.getInstance().getSokinKaisyaNmkn());
        bzFbsoukinHeaderRecordLayoutFile.setIffFbhrkmmd(denpyouDate.getBizDateMD().toString());
        bzFbsoukinHeaderRecordLayoutFile.setIffFbbankcd(YuyuBizConfig.getInstance().getSokinBankCd());
        bzFbsoukinHeaderRecordLayoutFile.setIffFbbanknmkn(YuyuBizConfig.getInstance().getSokinBankNmkn());
        bzFbsoukinHeaderRecordLayoutFile.setIffFbsitencd(YuyuBizConfig.getInstance().getSokinSitenCd());
        bzFbsoukinHeaderRecordLayoutFile.setIffFbsitennmkn(YuyuBizConfig.getInstance().getSokinSitenNmkn());
        bzFbsoukinHeaderRecordLayoutFile.setIffFbyokinkbn(YuyuBizConfig.getInstance().getSokinYokinKbn().getValue());
        bzFbsoukinHeaderRecordLayoutFile.setIffFbkouzano(YuyuBizConfig.getInstance().getSokinKzNo());
        bzFbsoukinHeaderRecordLayoutFile.setIffFbdummy13("");
        bzFbsoukinHeaderRecordLayoutFile.setIffFbgyoumucd(Strings.padStart(gyoumuCd.getValue(), GYOUMUCDKETA, PADZERO));

        BzRenkeiHenkanUtil<BzFbsoukinHeaderRecordLayoutFile, BzFbsoukinHeaderRecordLayoutFile>
        bzRenkeiHenkanUtilHeader = new BzRenkeiHenkanUtil<>();

        bzRenkeiHenkanUtilHeader.initialize(BzFbsoukinHeaderRecordLayoutFile.class,
            C_SystemRenkeiSyoriHousikiKbn.FILE_RENKEI, C_SystemRenkeiHenkanHoukouKbn.RAY_TO_OTHER,
            C_SystemRenkeiFileSyubetuKbn.TXT_FIXEDLENGTH);

        BzFbsoukinHeaderRecordLayoutFile BzFbsoukinHeaderRecordLayoutFileAfter =
            bzRenkeiHenkanUtilHeader.convDouituBean(bzFbsoukinHeaderRecordLayoutFile);

        String henkanshitamoziretu =
            FixedlengthConvertUtil.beanToStringForFixedlength(BzFbsoukinHeaderRecordLayoutFileAfter);

        bzFbsoukinFixedlengthRecordLayoutFile.setIffFbfixedlengthdata(henkanshitamoziretu);

        soukinLst.add(bzFbsoukinFixedlengthRecordLayoutFile);

        bzRenkeiHenkanUtilDate = new BzRenkeiHenkanUtil<>();

        bzRenkeiHenkanUtilDate.initialize(BzFbsoukinDataRecordLayoutFile.class,
            C_SystemRenkeiSyoriHousikiKbn.FILE_RENKEI, C_SystemRenkeiHenkanHoukouKbn.RAY_TO_OTHER,
            C_SystemRenkeiFileSyubetuKbn.TXT_FIXEDLENGTH);
    }

    void createData(BT_FBSoukinData pFBSoukinData, C_FbSoukinBatchKbn pFbSoukinBatchKbn) {

        BT_FBSoukinHukaInfo fbSoukinHukaInfo = pFBSoukinData.getFBSoukinHukaInfo();

        BzFbsoukinDataRecordLayoutFile bzFbsoukinDataRecordLayoutFile =
            SWAKInjector.getInstance(BzFbsoukinDataRecordLayoutFile.class);

        BzFbsoukinFixedlengthRecordLayoutFile bzFbsoukinFixedlengthRecordLayoutFile =
            SWAKInjector.getInstance(BzFbsoukinFixedlengthRecordLayoutFile.class);

        BzGetBankData bzGetBankData = SWAKInjector.getInstance(BzGetBankData.class);

        BzGetBankDataBean bzGetBankDataBean = bzGetBankData.exec(pFBSoukinData.getBankcd(), pFBSoukinData.getSitencd());

        if (C_FbSoukinBatchKbn.BATCH.eq(pFbSoukinBatchKbn)) {

            if (C_BankmasterUmuKbn.NONE.eq(bzGetBankDataBean.getBankmasterUmuKbn())
                || (C_Kokunaikwskameihyj.MIKAMEI.eq(bzGetBankDataBean.getKokunaikwskameihyj()))) {

                return;
            }
        }

        bzFbsoukinDataRecordLayoutFile.setIffFbdatakbn(DATERECORD);
        bzFbsoukinDataRecordLayoutFile.setIffFbbankcd(pFBSoukinData.getBankcd());
        bzFbsoukinDataRecordLayoutFile.setIffFbbanknmkn(bzGetBankDataBean.getBankNmKn());
        bzFbsoukinDataRecordLayoutFile.setIffFbsitencd(pFBSoukinData.getSitencd());
        bzFbsoukinDataRecordLayoutFile.setIffFbsitennmkn(bzGetBankDataBean.getSitenNmKn());
        bzFbsoukinDataRecordLayoutFile.setIffFbtegatakoukanjyono(ZERO_4KETA);
        bzFbsoukinDataRecordLayoutFile.setIffFbyokinkbn(pFBSoukinData.getYokinkbn().getValue());
        bzFbsoukinDataRecordLayoutFile.setIffFbkouzano(pFBSoukinData.getKouzano());
        bzFbsoukinDataRecordLayoutFile.setIffFbkouzameigininnmkn(pFBSoukinData.getKzmeiginmkn());
        bzFbsoukinDataRecordLayoutFile.setIffFbhrkmkingk(Strings.padStart(pFBSoukinData.getSoukingk().toString(), FURIKOMIGKKETA, PADZERO));
        bzFbsoukinDataRecordLayoutFile.setIffFbnewcd(SONOTA);
        bzFbsoukinDataRecordLayoutFile.setIffFbkokyakucd1(fbSoukinHukaInfo.getKokcd1());
        bzFbsoukinDataRecordLayoutFile.setIffFbkokyakucd2(ZERO_10KETA);
        bzFbsoukinDataRecordLayoutFile.setIffFbhrkmsiteikbn(EDNSHINATUKAI);
        bzFbsoukinDataRecordLayoutFile.setIffFbdummy8("");

        BzFbsoukinDataRecordLayoutFile BzFbsoukinDataRecordLayoutFileAfter =
            bzRenkeiHenkanUtilDate.convDouituBean(bzFbsoukinDataRecordLayoutFile);

        String henkanshitamoziretu =
            FixedlengthConvertUtil.beanToStringForFixedlength(BzFbsoukinDataRecordLayoutFileAfter);

        bzFbsoukinFixedlengthRecordLayoutFile.setIffFbfixedlengthdata(henkanshitamoziretu);

        dateLst.add(bzFbsoukinFixedlengthRecordLayoutFile);

        count++;
        soukinGakuGoukei = soukinGakuGoukei.add(pFBSoukinData.getSoukingk());
    }

    void createTorera() {

        BzFbsoukinTrailerRecordLayoutFile bzFbsoukinTrailerRecordLayoutFile =
            SWAKInjector.getInstance(BzFbsoukinTrailerRecordLayoutFile.class);

        BzFbsoukinFixedlengthRecordLayoutFile bzFbsoukinFixedlengthRecordLayoutFile =
            SWAKInjector.getInstance(BzFbsoukinFixedlengthRecordLayoutFile.class);

        bzFbsoukinTrailerRecordLayoutFile.setIffFbdatakbn(TORERARECORD);
        bzFbsoukinTrailerRecordLayoutFile.setIffFbdatarecordkensuu6(Strings.padStart(String.valueOf(count), DTRECORDKENSUUKETA, PADZERO));
        bzFbsoukinTrailerRecordLayoutFile.setIffFbhrkmkingkgoukei(Strings.padStart(soukinGakuGoukei.toString(), FURIKOMIGKKEIKETA, PADZERO));
        bzFbsoukinTrailerRecordLayoutFile.setIffFbdummy101("");

        BzRenkeiHenkanUtil<BzFbsoukinTrailerRecordLayoutFile, BzFbsoukinTrailerRecordLayoutFile>
        bzRenkeiHenkanUtilTorera = new BzRenkeiHenkanUtil<>();

        bzRenkeiHenkanUtilTorera.initialize(BzFbsoukinTrailerRecordLayoutFile.class,
            C_SystemRenkeiSyoriHousikiKbn.FILE_RENKEI, C_SystemRenkeiHenkanHoukouKbn.RAY_TO_OTHER,
            C_SystemRenkeiFileSyubetuKbn.TXT_FIXEDLENGTH);

        BzFbsoukinTrailerRecordLayoutFile bzFbsoukinTrailerRecordLayoutFileAfter =
            bzRenkeiHenkanUtilTorera.convDouituBean(bzFbsoukinTrailerRecordLayoutFile);

        String henkanshitamoziretu =
            FixedlengthConvertUtil.beanToStringForFixedlength(bzFbsoukinTrailerRecordLayoutFileAfter);

        bzFbsoukinFixedlengthRecordLayoutFile.setIffFbfixedlengthdata(henkanshitamoziretu);

        soukinLst.add(bzFbsoukinFixedlengthRecordLayoutFile);
    }

    void creadEndore() {

        BzFbsoukinEndRecordLayoutFile bzFbsoukinEndRecordLayoutFile =
            SWAKInjector.getInstance(BzFbsoukinEndRecordLayoutFile.class);

        BzFbsoukinFixedlengthRecordLayoutFile bzFbsoukinFixedlengthRecordLayoutFile =
            SWAKInjector.getInstance(BzFbsoukinFixedlengthRecordLayoutFile.class);

        bzFbsoukinEndRecordLayoutFile.setIffFbdatakbn(ENDORECORD);
        bzFbsoukinEndRecordLayoutFile.setIffFbdummy119("");

        BzRenkeiHenkanUtil<BzFbsoukinEndRecordLayoutFile, BzFbsoukinEndRecordLayoutFile>
        bzRenkeiHenkanUtilEnd = new BzRenkeiHenkanUtil<>();

        bzRenkeiHenkanUtilEnd.initialize(BzFbsoukinEndRecordLayoutFile.class,
            C_SystemRenkeiSyoriHousikiKbn.FILE_RENKEI, C_SystemRenkeiHenkanHoukouKbn.RAY_TO_OTHER,
            C_SystemRenkeiFileSyubetuKbn.TXT_FIXEDLENGTH);

        BzFbsoukinEndRecordLayoutFile BzFbsoukinEndRecordLayoutFileAfter =
            bzRenkeiHenkanUtilEnd.convDouituBean(bzFbsoukinEndRecordLayoutFile);

        String henkanshitamoziretu =
            FixedlengthConvertUtil.beanToStringForFixedlength(BzFbsoukinEndRecordLayoutFileAfter);

        bzFbsoukinFixedlengthRecordLayoutFile.setIffFbfixedlengthdata(henkanshitamoziretu);

        soukinLst.add(bzFbsoukinFixedlengthRecordLayoutFile);
    }
}
