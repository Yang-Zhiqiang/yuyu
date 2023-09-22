package yuyu.common.sinkeiyaku.skcommon;

import jp.co.slcs.swak.core.logger.LoggerFactory;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.currencytype.BizCurrencyTypes;
import jp.co.slcs.swak.number.currencytype.CurrencyType;

import org.slf4j.Logger;

import yuyu.common.biz.bzcommon.BizUtil;
import yuyu.def.classification.C_BlnktkumuKbn;
import yuyu.def.classification.C_DsSyomenTtdkHyouji;
import yuyu.def.classification.C_FstphrkkeiroKbn;
import yuyu.def.classification.C_HaitoukinuketorihouKbn;
import yuyu.def.classification.C_Hhknsei;
import yuyu.def.classification.C_HknsyuruiNo;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_Hrkkeiro;
import yuyu.def.classification.C_HrkkknsmnKbn;
import yuyu.def.classification.C_IkkatubaraiKaisuuKbn;
import yuyu.def.classification.C_IkkatubaraiKbn;
import yuyu.def.classification.C_KoureiKzkSetumeiHouKbn;
import yuyu.def.classification.C_KouzasyuruiKbn;
import yuyu.def.classification.C_KykKbn;
import yuyu.def.classification.C_Kyksei;
import yuyu.def.classification.C_KzhuritourokuhouKbn;
import yuyu.def.classification.C_KzktourokuserviceTourokuKbn;
import yuyu.def.classification.C_NensyuuKbn;
import yuyu.def.classification.C_PWaribikitekiyouKbn;
import yuyu.def.classification.C_PplessrendoucreditkousouKbn;
import yuyu.def.classification.C_PplessrendoukouhurikousouKbn;
import yuyu.def.classification.C_Seibetu;
import yuyu.def.classification.C_Sknenkinsyu;
import yuyu.def.classification.C_SntkhouKbn;
import yuyu.def.classification.C_TargetTkKbn;
import yuyu.def.classification.C_TargetTkMokuhyoutiKbn;
import yuyu.def.classification.C_Tdk;
import yuyu.def.classification.C_Tkhukaumu;
import yuyu.def.classification.C_TsindousiteiKbn;
import yuyu.def.classification.C_TumitatekinHaibunWariKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UktKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_YakkanJyuryouKbn;
import yuyu.def.classification.C_YnkHrkmgkAnniTuutiKbn;
import yuyu.def.classification.C_YokinKbn;
import yuyu.def.db.entity.BM_SyouhnZokusei;

import com.google.common.base.Strings;

/**
 * 新契約 新契約共通 生保Ｗｅｂ連携項目編集
 */
public class EditSeihoWebRenkeiKoumoku {

    private final Logger logger = LoggerFactory.getLogger(EditSeihoWebRenkeiKoumoku.class);

    private final static String SEIHOWEBHKNSYURUINO_321 = "321";

    private final static String SEIHOWEBHKNSYURUINO_322 = "322";

    private final static String SEIHOWEBHKNSYURUINO_323 = "323";

    private final static String SEIHOWEBHKNSYURUINO_331 = "331";

    private final static String SEIHOWEBHKNSYURUINO_332 = "332";

    private final static String SEIHOWEBHKNSYURUINO_445 = "445";

    private final static String SEIHOWEBHKNSYURUINO_446 = "446";

    private final static String SEIHOWEBHKNSYURUINO_324 = "324";

    private final static String SEIHOWEBHKNSYURUINO_325 = "325";

    private final static String SEIHOWEBHKNSYURUINO_326 = "326";

    private final static String SEIHOWEBHKNSYURUINO_357 = "357";

    private final static String SEIHOWEBHKNSYURUINO_358 = "358";

    public C_KykKbn kykkbnHenkan(String pKeihidouituhyj) {

        logger.debug("▽ 契約者区分変換処理 開始");

        C_KykKbn kykKbn = null;

        if ("1".equals(pKeihidouituhyj)) {
            kykKbn = C_KykKbn.KEIHI_DOUITU;
        }
        else {
            kykKbn = C_KykKbn.KEIHI_BETU;
        }

        logger.debug("△ 契約者区分変換処理 終了");

        return kykKbn;
    }

    public C_Kyksei kykseiHenkan(String pKyksei) {

        logger.debug("▽ 契約者性別変換処理 開始");

        C_Kyksei kyksei = null;

        if ("1".equals(pKyksei)) {
            kyksei = C_Kyksei.MALE;
        }
        else if ("2".equals(pKyksei)) {
            kyksei = C_Kyksei.FEMALE;
        }
        else {
            kyksei = C_Kyksei.BLNK;
        }

        logger.debug("△ 契約者性別変換処理 終了");

        return kyksei;
    }

    public C_Hhknsei hhknseiHenkan(String pHhknsei) {

        logger.debug("▽ 被保険者性別変換処理 開始");

        C_Hhknsei hhknsei = null;

        if ("1".equals(pHhknsei)) {
            hhknsei = C_Hhknsei.MALE;
        }
        else if ("2".equals(pHhknsei)) {
            hhknsei = C_Hhknsei.FEMALE;
        }
        else {
            hhknsei = C_Hhknsei.BLNK;
        }
        logger.debug("△ 被保険者性別変換処理 終了");

        return hhknsei;
    }

    public String postalCdSyutoku(String pKihontikucd) {

        logger.debug("▽ 郵便番号取得処理 開始");

        String postalCd = "";

        if (pKihontikucd.length() < 7) {
            postalCd = mojiretuKiritori(pKihontikucd, 0, pKihontikucd.length());
        }
        else {
            postalCd = mojiretuKiritori(pKihontikucd, 0, 7);
        }

        logger.debug("△ 郵便番号取得処理 終了");

        return postalCd;
    }

    public String adr1Syutoku(String pAdr) {

        logger.debug("▽ 住所１取得処理 開始");

        String adr1 = "";

        if (pAdr.length() < 30) {
            adr1 = mojiretuKiritori(pAdr, 0, pAdr.length());
        }
        else {
            adr1 = mojiretuKiritori(pAdr, 0, 30);
        }

        logger.debug("△ 住所１取得処理 終了");

        return adr1;
    }

    public String adr2Syutoku(String pAdr) {

        logger.debug("▽ 住所２取得処理 開始");

        String adr2 = "";

        if (pAdr.length() <= 30) {
            logger.debug("△ 住所２取得処理 終了");

            return adr2;
        }
        else if (pAdr.length() < 60) {
            adr2 = mojiretuKiritori(pAdr, 30, pAdr.length());
        }
        else {
            adr2 = mojiretuKiritori(pAdr, 30, 60);
        }

        logger.debug("△ 住所２取得処理 終了");

        return adr2;
    }

    public String adr3Syutoku(String pAdr) {

        logger.debug("▽ 住所３取得処理 開始");

        String adr3 = "";

        if (pAdr.length() <= 60) {
            logger.debug("△ 住所３取得処理 終了");

            return adr3;
        }
        else if (pAdr.length() < 62) {
            adr3 = mojiretuKiritori(pAdr, 60, pAdr.length());
        }
        else {
            adr3 = mojiretuKiritori(pAdr, 60, 62);
        }

        logger.debug("△ 住所３取得処理 終了");

        return adr3;
    }

    public String kinmusakinmSyutoku(String pOttmsk) {

        logger.debug("▽ 勤務先名取得処理 開始");

        String kinmusakinm = null;

        if (pOttmsk.length() < 50) {
            kinmusakinm = mojiretuKiritori(pOttmsk, 0, pOttmsk.length());
        }
        else {
            kinmusakinm = mojiretuKiritori(pOttmsk, 0, 50);
        }

        logger.debug("△ 勤務先名取得処理 終了");

        return kinmusakinm;
    }

    public C_SntkhouKbn sntkhoukbnHenkan(String pHjykktkbn) {

        logger.debug("▽ 選択方法区分変換処理 開始");

        C_SntkhouKbn sntkhouKbn = null;

        if ("1".equals(pHjykktkbn)) {
            sntkhouKbn = C_SntkhouKbn.HJY;
        }
        else if ("2".equals(pHjykktkbn)) {
            sntkhouKbn = C_SntkhouKbn.KKT;
        }
        else if ("3".equals(pHjykktkbn)) {
            sntkhouKbn = C_SntkhouKbn.NONE;
        }
        else {
            sntkhouKbn = C_SntkhouKbn.BLNK;
        }

        logger.debug("△ 選択方法区分変換処理 終了");

        return sntkhouKbn;
    }

    public C_Tuukasyu tuukasyuHenkan(String pTuukakbn) {

        logger.debug("▽ 通貨種類変換処理 開始");

        C_Tuukasyu tuukasyu = null;

        if ("1".equals(pTuukakbn)) {
            tuukasyu = C_Tuukasyu.JPY;
        }
        else if ("2".equals(pTuukakbn)) {
            tuukasyu = C_Tuukasyu.USD;
        }

        else if ("3".equals(pTuukakbn)) {
            tuukasyu = C_Tuukasyu.EUR;
        }
        else if ("4".equals(pTuukakbn)) {
            tuukasyu = C_Tuukasyu.AUD;
        }
        else {
            tuukasyu = C_Tuukasyu.BLNK;
        }

        logger.debug("△ 通貨種類変換処理 終了");

        return tuukasyu;
    }

    public String tuukaKbnHenkan(C_Tuukasyu pTuukasyu) {

        logger.debug("▽ 通貨区分変換処理 開始");

        String tuukakbn = null;

        if (C_Tuukasyu.JPY.eq(pTuukasyu)) {
            tuukakbn = "1";
        }
        else if (C_Tuukasyu.USD.eq(pTuukasyu)) {
            tuukakbn = "2";
        }

        else if (C_Tuukasyu.EUR.eq(pTuukasyu)) {
            tuukakbn = "3";
        }
        else if (C_Tuukasyu.AUD.eq(pTuukasyu)) {
            tuukakbn = "4";
        }
        else {
            tuukakbn = "0";
        }

        logger.debug("△ 通貨区分変換処理 終了");

        return tuukakbn;
    }

    public C_Tkhukaumu yennykntkhkkbnSyutoku(String pSiteituukakbn, String pNykntuukakbn) {

        logger.debug("▽ 円入金特約付加区分取得処理 開始");

        C_Tkhukaumu tkhukaumu = null;

        if (!pSiteituukakbn.equals(pNykntuukakbn)) {
            if ("1".equals(pNykntuukakbn)) {
                tkhukaumu = C_Tkhukaumu.HUKA;
            }
            else {
                tkhukaumu = C_Tkhukaumu.NONE;
            }
        }
        else {
            tkhukaumu = C_Tkhukaumu.BLNK;
        }

        logger.debug("△ 円入金特約付加区分取得処理 終了");

        return tkhukaumu;
    }

    public C_Tkhukaumu gaikanykntkhkkbnSyutoku(String pSiteituukakbn, String pNykntuukakbn) {

        logger.debug("▽ 外貨入金特約付加区分取得処理 開始");

        C_Tkhukaumu tkhukaumu = null;

        if (!pSiteituukakbn.equals(pNykntuukakbn)) {
            if (!"1".equals(pNykntuukakbn)) {
                tkhukaumu = C_Tkhukaumu.HUKA;
            }
            else {
                tkhukaumu = C_Tkhukaumu.NONE;
            }
        }
        else {
            tkhukaumu = C_Tkhukaumu.BLNK;
        }

        logger.debug("△ 外貨入金特約付加区分取得処理 終了");

        return tkhukaumu;
    }

    public C_Hrkkaisuu hrkkaisuuHenkan(String pHaraikomikaisukbn) {

        logger.debug("▽ 払込回数変換処理 開始");

        C_Hrkkaisuu hrkkaisuu = null;

        if ("1".equals(pHaraikomikaisukbn)) {
            hrkkaisuu = C_Hrkkaisuu.NEN;
        }
        else if ("2".equals(pHaraikomikaisukbn)) {
            hrkkaisuu = C_Hrkkaisuu.HALFY;
        }

        else if ("3".equals(pHaraikomikaisukbn)) {
            hrkkaisuu = C_Hrkkaisuu.TUKI;
        }
        else if ("4".equals(pHaraikomikaisukbn)) {
            hrkkaisuu = C_Hrkkaisuu.ITIJI;
        }
        else {
            hrkkaisuu = C_Hrkkaisuu.BLNK;
        }

        logger.debug("△ 払込回数変換処理 終了");

        return hrkkaisuu;
    }

    public C_Hrkkeiro hrkkeiroHenkan(String pHrkkeirokbn) {

        logger.debug("▽ 払込経路変換処理 開始");

        C_Hrkkeiro hrkkeiro = null;

        if ("1".equals(pHrkkeirokbn)) {
            hrkkeiro = C_Hrkkeiro.KOUHURI;
        }
        else if ("2".equals(pHrkkeirokbn)) {
            hrkkeiro = C_Hrkkeiro.DANTAI;
        }

        else if ("3".equals(pHrkkeirokbn)) {
            hrkkeiro = C_Hrkkeiro.SYUUDAN;
        }
        else if ("6".equals(pHrkkeirokbn)) {
            hrkkeiro = C_Hrkkeiro.HURIKAE;
        }
        else if ("7".equals(pHrkkeirokbn)) {
            hrkkeiro = C_Hrkkeiro.CREDIT;
        }
        else {
            hrkkeiro = C_Hrkkeiro.BLNK;
        }

        logger.debug("△ 払込経路変換処理 終了");

        return hrkkeiro;
    }

    public C_FstphrkkeiroKbn fstphrkkeiroHenkan(String pHaraikomikaisukbn, String pHrkkeirokbn, String pTkiyougyoutaikbn) {

        logger.debug("▽ 初回保険料払込経路変換処理 開始");

        C_FstphrkkeiroKbn fstphrkkeirokbn = null;

        if ("3".equals(pHaraikomikaisukbn)) {
            if ("7".equals(pHrkkeirokbn)) {
                if ("D".equals(pTkiyougyoutaikbn)) {
                    fstphrkkeirokbn = C_FstphrkkeiroKbn.CREDIT;
                }
                else {
                    fstphrkkeirokbn = C_FstphrkkeiroKbn.HURIKOMI;
                }
            }
            else {
                fstphrkkeirokbn = C_FstphrkkeiroKbn.HURIKOMI;
            }
        }
        else {
            fstphrkkeirokbn = C_FstphrkkeiroKbn.HURIKOMI;
        }

        logger.debug("△ 初回保険料払込経路変換処理 終了");

        return fstphrkkeirokbn;
    }

    public C_Tkhukaumu targettkhkkbnSyutoku(String pTargettkarihyj) {

        logger.debug("▽ ターゲット特約付加区分取得処理 開始");

        C_Tkhukaumu tkhukaumu = null;

        if ("1".equals(pTargettkarihyj)) {
            tkhukaumu = C_Tkhukaumu.HUKA;
        }
        else {
            tkhukaumu = C_Tkhukaumu.BLNK;
        }

        logger.debug("△ ターゲット特約付加区分取得処理 終了");

        return tkhukaumu;
    }

    public C_TargetTkKbn targettkkbnSyutoku(String pTargettkkbn) {

        logger.debug("▽ ターゲット特約区分取得処理 開始");

        C_TargetTkKbn targetTkKbn = null;

        if ("1".equals(pTargettkkbn)) {
            targetTkKbn = C_TargetTkKbn.SYUUSIN;
        }
        else if ("2".equals(pTargettkkbn)) {
            targetTkKbn = C_TargetTkKbn.NENKIN;
        }
        else {
            targetTkKbn = C_TargetTkKbn.BLNK;
        }

        logger.debug("△ ターゲット特約区分取得処理 終了");

        return targetTkKbn;
    }

    public C_TargetTkMokuhyoutiKbn targettkmkhtkbnSyutoku(Integer pTargettkmokuhyouti) {

        logger.debug("▽ ターゲット特約目標値区分取得処理 開始");

        C_TargetTkMokuhyoutiKbn targetTkMokuhyoutiKbn = null;

        if (pTargettkmokuhyouti == 105) {
            targetTkMokuhyoutiKbn = C_TargetTkMokuhyoutiKbn.TARGET105;
        }
        else if (pTargettkmokuhyouti == 110) {
            targetTkMokuhyoutiKbn = C_TargetTkMokuhyoutiKbn.TARGET110;
        }
        else if (pTargettkmokuhyouti == 120) {
            targetTkMokuhyoutiKbn = C_TargetTkMokuhyoutiKbn.TARGET120;
        }
        else if (pTargettkmokuhyouti == 130) {
            targetTkMokuhyoutiKbn = C_TargetTkMokuhyoutiKbn.TARGET130;
        }
        else if (pTargettkmokuhyouti == 140) {
            targetTkMokuhyoutiKbn = C_TargetTkMokuhyoutiKbn.TARGET140;
        }
        else if (pTargettkmokuhyouti == 150) {
            targetTkMokuhyoutiKbn = C_TargetTkMokuhyoutiKbn.TARGET150;
        }
        else if (pTargettkmokuhyouti == 160) {
            targetTkMokuhyoutiKbn = C_TargetTkMokuhyoutiKbn.TARGET160;
        }
        else if (pTargettkmokuhyouti == 170) {
            targetTkMokuhyoutiKbn = C_TargetTkMokuhyoutiKbn.TARGET170;
        }
        else if (pTargettkmokuhyouti == 180) {
            targetTkMokuhyoutiKbn = C_TargetTkMokuhyoutiKbn.TARGET180;
        }
        else if (pTargettkmokuhyouti == 190) {
            targetTkMokuhyoutiKbn = C_TargetTkMokuhyoutiKbn.TARGET190;
        }
        else if (pTargettkmokuhyouti == 200) {
            targetTkMokuhyoutiKbn = C_TargetTkMokuhyoutiKbn.TARGET200;
        }
        else {
            targetTkMokuhyoutiKbn = C_TargetTkMokuhyoutiKbn.BLNK;
        }

        logger.debug("△ ターゲット特約目標値区分取得処理 終了");

        return targetTkMokuhyoutiKbn;
    }

    public C_Tkhukaumu nstkhkkbnSyutoku(String pNkshrarihyj) {

        logger.debug("▽ 年金支払特約付加区分取得処理 開始");

        C_Tkhukaumu tkhukaumu = null;

        if ("1".equals(pNkshrarihyj)) {
            tkhukaumu = C_Tkhukaumu.HUKA;
        }
        else {
            tkhukaumu = C_Tkhukaumu.BLNK;
        }

        logger.debug("△ 年金支払特約付加区分取得処理 終了");

        return tkhukaumu;
    }

    public Integer ktninSyutoku(Integer pKthksuninzuuc, String pKtnrkkbn) {

        logger.debug("▽ 受取人人数取得処理 開始");

        Integer ktnin = 0;

        if (2 <= pKthksuninzuuc) {
            ktnin = pKthksuninzuuc;
        }
        else {
            if ("1".equals(pKtnrkkbn) || "4".equals(pKtnrkkbn)) {
                ktnin = 1;
            }
            else {
                ktnin = 0;
            }
        }

        logger.debug("△ 受取人人数取得処理 終了");

        return ktnin;
    }

    public C_UktKbn uktkbnHenkan(String pKtnrkkbn, String pKttdkkbn, String ktknnm) {

        logger.debug("▽ 受取人区分変換処理 開始");

        C_UktKbn uktKbn = null;

        if ("1".equals(pKtnrkkbn)) {
            uktKbn = C_UktKbn.KYK;
        }
        else if ("2".equals(pKtnrkkbn)) {
            if ("0".equals(pKttdkkbn)) {
                uktKbn = C_UktKbn.KYK;
            }
            else {
                uktKbn = C_UktKbn.TOKUTEIMEIGI;
            }
        }
        else if ("5".equals(pKtnrkkbn)) {
            uktKbn = C_UktKbn.HHKN;
        }
        else {
            if (!BizUtil.isBlank(ktknnm)) {
                uktKbn = C_UktKbn.TOKUTEIMEIGI;
            }
            else {
                uktKbn = C_UktKbn.BLNK;
            }
        }

        logger.debug("△ 受取人区分変換処理 終了");

        return uktKbn;
    }

    public boolean tsbjFkmrrHantei(String pTaisyouti, String... pTaisyoukoumokuti) {

        logger.debug("▽ 対象文字が含まれるかの判定処理 開始");

        boolean tsbjFkmrr = false;

        for(String taisyoukoumokuti : pTaisyoukoumokuti) {
            if (pTaisyouti.equals(taisyoukoumokuti)) {
                tsbjFkmrr = true;
                break;
            }
        }
        logger.debug("△ 対象文字が含まれるかの判定処理 終了");

        return tsbjFkmrr;
    }

    public C_UmuKbn kjmeigihkhunouumukbnSyutoku(String pTksykmcd1, String pTksykmcd2, String pTksykmcd3,
        String pTksykmcd4, String pTksykmcd5) {

        logger.debug("▽ 漢字名義変換不能有無区分取得処理 開始");

        C_UmuKbn umuKbn = null;

        boolean tsbjFkmrrHanteiFlg = tsbjFkmrrHantei("C1", pTksykmcd1, pTksykmcd2, pTksykmcd3, pTksykmcd4, pTksykmcd5);

        if (tsbjFkmrrHanteiFlg == true) {
            umuKbn = C_UmuKbn.ARI;
        }
        else {
            umuKbn = C_UmuKbn.NONE;
        }

        logger.debug("△ 漢字名義変換不能有無区分取得処理 終了");

        return umuKbn;
    }

    public C_UmuKbn tsryhshrkykumukbnSyutoku(String pTksykmcd1, String pTksykmcd2, String pTksykmcd3,
        String pTksykmcd4, String pTksykmcd5) {

        logger.debug("▽ 手数料不支払契約有無区分取得処理 開始");

        C_UmuKbn umuKbn = null;

        boolean tsbjFkmrrHanteiFlg = tsbjFkmrrHantei("W3", pTksykmcd1, pTksykmcd2, pTksykmcd3, pTksykmcd4, pTksykmcd5);

        if (tsbjFkmrrHanteiFlg == true) {
            umuKbn = C_UmuKbn.ARI;
        }
        else {
            umuKbn = C_UmuKbn.NONE;
        }

        logger.debug("△ 手数料不支払契約有無区分取得処理 終了");

        return umuKbn;
    }

    public C_UmuKbn syosisyatodokeumukbnSyutoku(String pTksykmcd1, String pTksykmcd2, String pTksykmcd3,
        String pTksykmcd4, String pTksykmcd5) {

        logger.debug("▽ 証券支社届有無区分取得処理 開始");

        C_UmuKbn umuKbn = null;

        boolean tsbjFkmrrHanteiFlg = tsbjFkmrrHantei("H5", pTksykmcd1, pTksykmcd2, pTksykmcd3, pTksykmcd4, pTksykmcd5);

        if (tsbjFkmrrHanteiFlg == true) {
            umuKbn = C_UmuKbn.ARI;
        }
        else {
            umuKbn = C_UmuKbn.NONE;
        }

        logger.debug("△ 証券支社届有無区分取得処理 終了");

        return umuKbn;
    }

    public C_UmuKbn kakukisyouryakukbumukbnSyutoku(String pTksykmcd1, String pTksykmcd2, String pTksykmcd3,
        String pTksykmcd4, String pTksykmcd5) {

        logger.debug("▽ カク基省略希望有無区分取得処理 開始");

        C_UmuKbn umuKbn = null;

        boolean tsbjFkmrrHanteiFlg = tsbjFkmrrHantei("H9", pTksykmcd1, pTksykmcd2, pTksykmcd3, pTksykmcd4, pTksykmcd5);

        if (tsbjFkmrrHanteiFlg == true) {
            umuKbn = C_UmuKbn.ARI;
        }
        else {
            umuKbn = C_UmuKbn.NONE;
        }

        logger.debug("△ カク基省略希望有無区分取得処理 終了");

        return umuKbn;
    }

    public C_UmuKbn seiymdmosseitouumukbnSyutoku(String pTksykmcd1, String pTksykmcd2, String pTksykmcd3,
        String pTksykmcd4, String pTksykmcd5) {

        logger.debug("▽ 生年月日申込書正当有無区分取得処理 開始");

        C_UmuKbn umuKbn = null;

        boolean tsbjFkmrrHanteiFlg = tsbjFkmrrHantei("I2", pTksykmcd1, pTksykmcd2, pTksykmcd3, pTksykmcd4, pTksykmcd5);

        if (tsbjFkmrrHanteiFlg == true) {
            umuKbn = C_UmuKbn.ARI;
        }
        else {
            umuKbn = C_UmuKbn.NONE;
        }

        logger.debug("△ 生年月日申込書正当有無区分取得処理 終了");

        return umuKbn;
    }

    public String mojiretuKiritori(String pTaisyouMojiretu, int pBegin, int pEnd) {

        logger.debug("▽ 文字列切取り処理 開始");

        String taisyouMojiretu = "";

        if (pTaisyouMojiretu == null || pTaisyouMojiretu.length() < (pEnd - pBegin)) {

            logger.debug("△ 文字列切取り処理 終了");

            return taisyouMojiretu;
        }
        logger.debug("△ 文字列切取り処理 終了");

        taisyouMojiretu = pTaisyouMojiretu.substring(pBegin, pEnd);
        return taisyouMojiretu;
    }

    public BizCurrency kihonsSyutoku(String pSiteituukakbn, Long pKihons, Long pGaikakihons) {

        logger.debug("▽ 基本Ｓ取得処理 開始");

        BizCurrency kihons = null;

        if ("1".equals(pSiteituukakbn)) {
            kihons = BizCurrency.valueOf(pKihons, BizCurrencyTypes.YEN);
        }
        else if ("2".equals(pSiteituukakbn)) {
            kihons = BizCurrency.valueOf(pGaikakihons, BizCurrencyTypes.DOLLAR).divide(100);
        }
        else if ("3".equals(pSiteituukakbn)) {
            kihons = BizCurrency.valueOf(pGaikakihons, BizCurrencyTypes.EURO).divide(100);
        }
        else if ("4".equals(pSiteituukakbn)) {
            kihons = BizCurrency.valueOf(pGaikakihons, BizCurrencyTypes.AU_DOLLAR).divide(100);
        }
        else {
            kihons = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);
        }

        logger.debug("△ 基本Ｓ取得処理 終了");

        return kihons;
    }

    public BizCurrency mossyukykpSyutoku(String pMostuukakbn, Long pMoshokenryou, Long pGaikamoshokenryou) {

        logger.debug("▽ 申込主契約・特約Ｐ取得処理 開始");

        BizCurrency mossyukykp = null;
        CurrencyType currencyType = null;

        if ("1".equals(pMostuukakbn)) {
            currencyType = BizCurrencyTypes.YEN;
        }
        else if ("2".equals(pMostuukakbn)) {
            currencyType = BizCurrencyTypes.DOLLAR;
        }
        else if ("3".equals(pMostuukakbn)) {
            currencyType = BizCurrencyTypes.EURO;
        }
        else if ("4".equals(pMostuukakbn)) {
            currencyType = BizCurrencyTypes.AU_DOLLAR;
        }
        else {
            currencyType = BizCurrencyTypes.YEN;
        }

        mossyukykp = BizCurrency.valueOf(0, currencyType);

        if ("1".equals(pMostuukakbn)
            && pMoshokenryou != null && pMoshokenryou != 0) {

            mossyukykp = BizCurrency.valueOf(pMoshokenryou, currencyType);
        }
        else if (("2".equals(pMostuukakbn) || "3".equals(pMostuukakbn) || "4".equals(pMostuukakbn))
            && pGaikamoshokenryou != null && pGaikamoshokenryou != 0) {

            mossyukykp = BizCurrency.valueOf(pGaikamoshokenryou, currencyType).divide(100);
        }

        logger.debug("△ 申込主契約・特約Ｐ取得処理 終了");

        return mossyukykp;
    }

    public C_HrkkknsmnKbn hrkkknsmnkbnSyutoku(C_HknsyuruiNo pHknsyuruino, Integer pPhrkkikn) {

        logger.debug("▽ 払込期間歳満期区分取得処理 開始");

        C_HrkkknsmnKbn hrkkknsmnKbn = null;

        if (C_HknsyuruiNo.GAIKARIRITUHENDOUNK.eq(pHknsyuruino) || C_HknsyuruiNo.TEIKAIYAKUHRKNSYSN_YENDT.eq(pHknsyuruino)
            || C_HknsyuruiNo.TEIKAIYAKUHRKNSYSN_USDDT.eq(pHknsyuruino)) {

            hrkkknsmnKbn = C_HrkkknsmnKbn.SAIMANKI;
        }
        else {
            hrkkknsmnKbn = C_HrkkknsmnKbn.BLNK;
        }

        logger.debug("△ 払込期間歳満期区分取得処理 終了");

        return hrkkknsmnKbn;
    }

    public String mosnoHensyuu(String pMosno) {

        logger.debug("▽ 申込番号編集処理 開始");

        String mosno = "";

        mosno = Strings.padStart(pMosno, 9, '0');

        logger.debug("△ 申込番号編集処理 終了");

        return mosno;
    }

    public C_HknsyuruiNo huho2EditHknsyuruino(String pHknsyuruino) {

        logger.debug("▽ 普保Ⅱ保険種類番号編集処理 開始");

        C_HknsyuruiNo huho2Hknsyuruino = C_HknsyuruiNo.BLNK;
        String hknsyuruino = "";

        hknsyuruino = Strings.padStart(pHknsyuruino, 3, '0');

        if (SEIHOWEBHKNSYURUINO_321.equals(hknsyuruino)) {

            huho2Hknsyuruino = C_HknsyuruiNo.GAIKAINDEXNK;
        }
        else if (SEIHOWEBHKNSYURUINO_322.equals(hknsyuruino)) {

            huho2Hknsyuruino = C_HknsyuruiNo.GAIKAINDEXNK_SISUU;
        }
        else if (SEIHOWEBHKNSYURUINO_323.equals(hknsyuruino)) {

            huho2Hknsyuruino = C_HknsyuruiNo.GAIKAINDEXNK_TEIRITU;
        }
        else if (SEIHOWEBHKNSYURUINO_331.equals(hknsyuruino)) {

            huho2Hknsyuruino = C_HknsyuruiNo.GAIKARIRITUHENDOUNK;
        }
        else if (SEIHOWEBHKNSYURUINO_332.equals(hknsyuruino)) {

            huho2Hknsyuruino = C_HknsyuruiNo.GAIKARIRITUHENDOUNK;
        }
        else if (SEIHOWEBHKNSYURUINO_445.equals(hknsyuruino)) {

            huho2Hknsyuruino = C_HknsyuruiNo.GAIKAITIJIBRISYUUSIN_19_SGARI;
        }
        else if (SEIHOWEBHKNSYURUINO_446.equals(hknsyuruino)) {

            huho2Hknsyuruino = C_HknsyuruiNo.GAIKAITIJIBRISYUUSIN_19_SGNASI;
        }
        else if (SEIHOWEBHKNSYURUINO_324.equals(hknsyuruino)) {

            huho2Hknsyuruino = C_HknsyuruiNo.GAIKAINDEXNK_20_SISUU;
        }
        else if (SEIHOWEBHKNSYURUINO_325.equals(hknsyuruino)) {

            huho2Hknsyuruino = C_HknsyuruiNo.GAIKAINDEXNK_20_TEIRITUTEIKI;
        }
        else if (SEIHOWEBHKNSYURUINO_326.equals(hknsyuruino)) {

            huho2Hknsyuruino = C_HknsyuruiNo.GAIKAINDEXNK_20_TEIRITUTEIKI;
        }
        else if (SEIHOWEBHKNSYURUINO_357.equals(hknsyuruino)) {

            huho2Hknsyuruino = C_HknsyuruiNo.TEIKAIYAKUHRKNSYSN_YENDT;
        }
        else if (SEIHOWEBHKNSYURUINO_358.equals(hknsyuruino)) {

            huho2Hknsyuruino = C_HknsyuruiNo.TEIKAIYAKUHRKNSYSN_USDDT;
        }

        logger.debug("△ 普保Ⅱ保険種類番号編集処理 終了");

        return huho2Hknsyuruino;
    }

    public String uktknnmSyutoku(String pKtnrkkbn, String pKttdkkbn, String pKtknnm) {

        logger.debug("▽ 受取人名（カナ）取得処理 開始");

        String ktknnm = null;

        if ("2".equals(pKtnrkkbn) || "4".equals(pKtnrkkbn) ) {
            if (!"0".equals(pKttdkkbn)) {
                ktknnm = pKtknnm;
            }
        }

        logger.debug("△ 受取人名（カナ）取得処理 終了");

        return ktknnm;
    }

    public String uktnmkjSyutoku(String pKtnrkkbn, String pKttdkkbn, String pKtkjnm) {

        logger.debug("▽ 受取人名（漢字）取得処理 開始");

        String ktnmkj = null;

        if ("2".equals(pKtnrkkbn) || "4".equals(pKtnrkkbn)) {
            if (!"0".equals(pKttdkkbn)) {
                ktnmkj = pKtkjnm;
            }
        }

        logger.debug("△ 受取人名（漢字）取得処理 終了");

        return ktnmkj;
    }

    public C_Tdk ukttdkSyutoku(String pKtnrkkbn,String pKttdkkbn) {

        logger.debug("▽ 受取人続柄取得処理 開始");

        C_Tdk kttdk = C_Tdk.BLNK;

        if ("2".equals(pKtnrkkbn) || "4".equals(pKtnrkkbn)) {
            if (!"0".equals(pKttdkkbn)) {
                kttdk = zrnUktTdkKbn(pKttdkkbn);
            }
        }

        logger.debug("△ 受取人続柄取得処理 終了");

        return kttdk;
    }

    public String uktseiymdSyutoku(String pKtnrkkbn, String pKttdkkbn,String pKtseiymd) {

        logger.debug("▽ 受取人生年月日取得処理 開始");

        String ktseiymd = null;

        if ("2".equals(pKtnrkkbn) || "4".equals(pKtnrkkbn)) {
            if (!"0".equals(pKttdkkbn)) {
                if (!"00000000".equals(pKtseiymd) && !"0".equals(pKtseiymd)) {
                    ktseiymd = pKtseiymd;
                }
            }
        }

        logger.debug("△ 受取人生年月日取得処理 終了");

        return ktseiymd;
    }

    public C_KykKbn kykkbnkyktdkkbnHenkan(String pKyktdkkbn) {

        logger.debug("▽ 契約者区分変換処理 開始");

        C_KykKbn kykKbn = null;

        if ("0".equals(pKyktdkkbn)) {
            kykKbn = C_KykKbn.KEIHI_DOUITU;
        }
        else {
            kykKbn = C_KykKbn.KEIHI_BETU;
        }

        logger.debug("△ 契約者区分変換処理 終了");

        return kykKbn;
    }

    public C_SntkhouKbn sntkhouKbnsyokugyouHenkan(String pHjykktkbn, BM_SyouhnZokusei pSyouhnZokusei) {

        logger.debug("▽ 選択方法区分変換処理（職業のみ告知あり） 開始");

        C_SntkhouKbn sntkhouKbn = null;

        if ("1".equals(pHjykktkbn)) {
            sntkhouKbn = C_SntkhouKbn.HJY;
        }
        else if ("2".equals(pHjykktkbn)) {
            if (C_UmuKbn.ARI.eq(pSyouhnZokusei.getSyokugyoukktumu())) {
                sntkhouKbn = C_SntkhouKbn.SYOKUGYOU;
            }
            else {
                sntkhouKbn = C_SntkhouKbn.KKT;
            }
        }
        else if ("3".equals(pHjykktkbn)) {
            sntkhouKbn = C_SntkhouKbn.NONE;
        }
        else {
            sntkhouKbn = C_SntkhouKbn.BLNK;
        }
        logger.debug("△ 選択方法区分変換処理（職業のみ告知あり） 終了");

        return sntkhouKbn;
    }

    public C_HaitoukinuketorihouKbn haitoukinuketorihoukbnHenkan(String pHaitoukinuketorihoukbn) {

        logger.debug("▽ 配当金受取方法区分変換処理 開始");

        C_HaitoukinuketorihouKbn haitoukinuketorihouKbn = null;

        if ("1".equals(pHaitoukinuketorihoukbn)) {
            haitoukinuketorihouKbn = C_HaitoukinuketorihouKbn.TUMIHAI;
        }
        else {
            haitoukinuketorihouKbn = C_HaitoukinuketorihouKbn.BLNK;
        }
        logger.debug("△ 配当金受取方法区分変換処理 終了");

        return haitoukinuketorihouKbn;
    }

    public C_Tkhukaumu syksbYensitiHsyuTkhkKbn(String pYensitihsyutkykarihyj, C_HknsyuruiNo pHknsyuruino) {

        logger.debug("▽ 初期死亡時円換算最低保証特約付加区分取得処理 開始");

        C_Tkhukaumu tkhukaumu = null;

        if ("1".equals(pYensitihsyutkykarihyj)) {
            tkhukaumu = C_Tkhukaumu.HUKA;
        }
        else {
            if (C_HknsyuruiNo.GAIKAITIJIBRISYUUSIN_YOKUSEI.eq(pHknsyuruino) ||
                C_HknsyuruiNo.GAIKAITIJIBRISYUUSIN_19_SGARI.eq(pHknsyuruino)) {
                tkhukaumu = C_Tkhukaumu.NONE;
            }
            else {
                tkhukaumu = C_Tkhukaumu.BLNK;
            }

        }
        logger.debug("△ 初期死亡時円換算最低保証特約付加区分取得処理 終了");

        return tkhukaumu;
    }

    public C_Tkhukaumu jyudKaigoMehrTkhkKbn(String pKaigomehrtkarihyj) {

        logger.debug("▽ 重度介護前払特約付加区分取得処理 開始");

        C_Tkhukaumu tkhukaumu = null;

        if ("1".equals(pKaigomehrtkarihyj)) {
            tkhukaumu = C_Tkhukaumu.HUKA;
        }
        else {
            tkhukaumu = C_Tkhukaumu.BLNK;
        }
        logger.debug("△ 重度介護前払特約付加区分取得処理 終了");

        return tkhukaumu;
    }

    public C_Tdk zrnKykTdkKbn(String pZrnkyktdkkbn) {

        logger.debug("▽ 契約者続柄区分変換処理 開始");

        C_Tdk tdk = null;

        if ("0".equals(pZrnkyktdkkbn)) {
            tdk = C_Tdk.BLNK;
        }
        else if ("1".equals(pZrnkyktdkkbn)) {
            tdk = C_Tdk.HGU;
        }
        else if ("2".equals(pZrnkyktdkkbn)) {
            tdk = C_Tdk.KO;
        }
        else if ("3".equals(pZrnkyktdkkbn)) {
            tdk = C_Tdk.OYA;
        }
        else if ("4".equals(pZrnkyktdkkbn)) {
            tdk = C_Tdk.MAGO;
        }
        else if ("5".equals(pZrnkyktdkkbn)) {
            tdk = C_Tdk.SHB;
        }
        else if ("6".equals(pZrnkyktdkkbn)) {
            tdk = C_Tdk.KYDSM;
        }
        else if ("9".equals(pZrnkyktdkkbn)) {
            tdk = C_Tdk.SONOTA;
        }
        else {
            tdk = C_Tdk.BLNK;
        }
        logger.debug("△ 契約者続柄区分変換処理 終了");

        return tdk;
    }

    public C_Tdk zrnUktTdkKbn(String pZrnukttdkkbn) {

        logger.debug("▽ 受取人続柄区分変換処理 開始");

        C_Tdk tdk = null;

        if ("0".equals(pZrnukttdkkbn)) {
            tdk = C_Tdk.BLNK;
        }
        else if ("1".equals(pZrnukttdkkbn)) {
            tdk = C_Tdk.HGU;
        }
        else if ("2".equals(pZrnukttdkkbn)) {
            tdk = C_Tdk.KO;
        }
        else if ("3".equals(pZrnukttdkkbn)) {
            tdk = C_Tdk.OYA;
        }
        else if ("4".equals(pZrnukttdkkbn)) {
            tdk = C_Tdk.MAGO;
        }
        else if ("5".equals(pZrnukttdkkbn)) {
            tdk = C_Tdk.SHB;
        }
        else if ("6".equals(pZrnukttdkkbn)) {
            tdk = C_Tdk.KYDSM;
        }
        else if ("7".equals(pZrnukttdkkbn)) {
            tdk = C_Tdk.KYN;
        }
        else if ("8".equals(pZrnukttdkkbn)) {
            tdk = C_Tdk.HTSZN;
        }
        else if ("9".equals(pZrnukttdkkbn)) {
            tdk = C_Tdk.SONOTA;
        }
        else {
            tdk = C_Tdk.BLNK;
        }
        logger.debug("△ 受取人続柄区分変換処理 終了");

        return tdk;
    }

    public C_TumitatekinHaibunWariKbn tumitatekinHaibunWariKbnHenkan(Integer pHaibunwariai, C_UmuKbn pTmttknhaibunwarisiteiumu) {

        logger.debug("▽ 積立金配分割合区分変換処理 開始");

        C_TumitatekinHaibunWariKbn tumitatekinHaibunWariKbn = null;

        if (C_UmuKbn.ARI.eq(pTmttknhaibunwarisiteiumu)) {

            if (0 == pHaibunwariai) {
                tumitatekinHaibunWariKbn = C_TumitatekinHaibunWariKbn.WARIAI000;
            }
            else if (10 == pHaibunwariai) {
                tumitatekinHaibunWariKbn = C_TumitatekinHaibunWariKbn.WARIAI010;
            }
            else if (20 == pHaibunwariai) {
                tumitatekinHaibunWariKbn = C_TumitatekinHaibunWariKbn.WARIAI020;
            }
            else if (30 == pHaibunwariai) {
                tumitatekinHaibunWariKbn = C_TumitatekinHaibunWariKbn.WARIAI030;
            }
            else if (40 == pHaibunwariai) {
                tumitatekinHaibunWariKbn = C_TumitatekinHaibunWariKbn.WARIAI040;
            }
            else if (50 == pHaibunwariai) {
                tumitatekinHaibunWariKbn = C_TumitatekinHaibunWariKbn.WARIAI050;
            }
            else if (60 == pHaibunwariai) {
                tumitatekinHaibunWariKbn = C_TumitatekinHaibunWariKbn.WARIAI060;
            }
            else if (70 == pHaibunwariai) {
                tumitatekinHaibunWariKbn = C_TumitatekinHaibunWariKbn.WARIAI070;
            }
            else if (80 == pHaibunwariai) {
                tumitatekinHaibunWariKbn = C_TumitatekinHaibunWariKbn.WARIAI080;
            }
            else if (90 == pHaibunwariai) {
                tumitatekinHaibunWariKbn = C_TumitatekinHaibunWariKbn.WARIAI090;
            }
            else if (100 == pHaibunwariai) {
                tumitatekinHaibunWariKbn = C_TumitatekinHaibunWariKbn.WARIAI100;
            }
            else {
                tumitatekinHaibunWariKbn = C_TumitatekinHaibunWariKbn.BLNK;
            }
        }
        else {
            tumitatekinHaibunWariKbn = C_TumitatekinHaibunWariKbn.BLNK;
        }

        logger.debug("△ 積立金配分割合区分変換処理 終了");

        return tumitatekinHaibunWariKbn;
    }

    public C_DsSyomenTtdkHyouji dsSyomenTtdkHyoujiHenkan(String pDssyomenttdkhyj) {

        logger.debug("▽ ＤＳ書面手続表示変換処理 開始");

        C_DsSyomenTtdkHyouji dsSyomenTtdkHyouji = null;

        if ("1".equals(pDssyomenttdkhyj)) {
            dsSyomenTtdkHyouji = C_DsSyomenTtdkHyouji.SYOMENTTDK;
        }
        else {
            dsSyomenTtdkHyouji = C_DsSyomenTtdkHyouji.MISETTEI;
        }

        logger.debug("△ ＤＳ書面手続表示変換処理 終了");

        return dsSyomenTtdkHyouji;
    }

    public C_Sknenkinsyu sknenkinsyuHenkan(String pNksyukbn) {

        logger.debug("▽ 新契約年金種類変換処理 開始");

        C_Sknenkinsyu sknenkinsyu = null;

        if ("6".equals(pNksyukbn)) {
            sknenkinsyu = C_Sknenkinsyu.KKTI5;
        }
        else if ("1".equals(pNksyukbn)) {
            sknenkinsyu = C_Sknenkinsyu.KKTI10;
        }
        else if ("2".equals(pNksyukbn)) {
            sknenkinsyu = C_Sknenkinsyu.KKTI15;
        }
        else if ("C".equals(pNksyukbn)) {
            sknenkinsyu = C_Sknenkinsyu.SGKHSYSYSN;
        }
        else if ("D".equals(pNksyukbn)) {
            sknenkinsyu = C_Sknenkinsyu.KKTI5DAI1BAIGAKU;
        }
        else {
            sknenkinsyu = C_Sknenkinsyu.BLNK;
        }

        logger.debug("△ 新契約年金種類変換処理 終了");

        return sknenkinsyu;
    }

    public C_KouzasyuruiKbn kouzasyuruiKbnHenkan(String pKzsyurui) {

        logger.debug("▽ 口座種類区分変換処理 開始");

        C_KouzasyuruiKbn kouzasyuruiKbn = null;

        if ("1".equals(pKzsyurui)) {
            kouzasyuruiKbn = C_KouzasyuruiKbn.YENKOUZA;
        }
        else if ("2".equals(pKzsyurui)) {
            kouzasyuruiKbn = C_KouzasyuruiKbn.GAIKAKOUZA;
        }
        else {
            kouzasyuruiKbn = C_KouzasyuruiKbn.BLNK;
        }

        logger.debug("△ 口座種類区分変換処理 終了");

        return kouzasyuruiKbn;
    }

    public C_YokinKbn yokinKbnHenkan(String pYokinsyumoku) {

        logger.debug("▽ 預金種目区分変換処理 開始");

        C_YokinKbn yokinKbn = null;

        if ("1".equals(pYokinsyumoku)) {
            yokinKbn = C_YokinKbn.HUTUU;
        }
        else if ("2".equals(pYokinsyumoku)) {
            yokinKbn = C_YokinKbn.TOUZA;
        }
        else {
            yokinKbn = C_YokinKbn.BLNK;
        }

        logger.debug("△ 預金種目区分変換処理 終了");

        return yokinKbn;
    }

    public Integer hknkknSyutoku(Integer pHknkkn, Integer pSueokikkn, C_HknsyuruiNo pHknsyuruino) {

        logger.debug("▽ 保険期間取得処理 開始");

        Integer hknkkn = null;

        if (C_HknsyuruiNo.GAIKAINDEXNK.eq(pHknsyuruino)
            || C_HknsyuruiNo.GAIKAINDEXNK_SISUU.eq(pHknsyuruino)
            || C_HknsyuruiNo.GAIKAINDEXNK_TEIRITU.eq(pHknsyuruino)
            || C_HknsyuruiNo.GAIKAINDEXNK_20_SISUU.eq(pHknsyuruino)
            || C_HknsyuruiNo.GAIKAINDEXNK_20_TEIRITUTEIKI.eq(pHknsyuruino)) {

            hknkkn = pSueokikkn;
        }
        else {
            hknkkn = pHknkkn;
        }

        logger.debug("△ 保険期間取得処理 終了");

        return hknkkn;
    }

    public BizCurrency huho2GetMosheijyunp(String pHaraikomikaisukbn, String pMostuukakbn,
        Long pEnkamosp, Long pGaikamosp) {

        logger.debug("▽ 普保Ⅱ申込平準払Ｐ取得処理 開始");

        BizCurrency huho2Mosheijyunp = null;
        CurrencyType currencyType = null;

        if ("1".equals(pMostuukakbn)) {
            currencyType = BizCurrencyTypes.YEN;
        }
        else if ("2".equals(pMostuukakbn)) {
            currencyType = BizCurrencyTypes.DOLLAR;
        }
        else if ("3".equals(pMostuukakbn)) {
            currencyType = BizCurrencyTypes.EURO;
        }
        else if ("4".equals(pMostuukakbn)) {
            currencyType = BizCurrencyTypes.AU_DOLLAR;
        }
        else {
            currencyType = BizCurrencyTypes.YEN;
        }

        huho2Mosheijyunp = BizCurrency.valueOf(0, currencyType);

        if ("1".equals(pHaraikomikaisukbn) || "2".equals(pHaraikomikaisukbn) || "3".equals(pHaraikomikaisukbn)) {

            if ("1".equals(pMostuukakbn)
                && pEnkamosp != null && pEnkamosp != 0) {

                huho2Mosheijyunp = BizCurrency.valueOf(pEnkamosp, currencyType);
            }
            else if (("2".equals(pMostuukakbn) || "3".equals(pMostuukakbn) || "4".equals(pMostuukakbn))
                && pGaikamosp != null && pGaikamosp != 0) {

                huho2Mosheijyunp = BizCurrency.valueOf(pGaikamosp, currencyType).divide(100);
            }
        }

        logger.debug("△ 普保Ⅱ申込平準払Ｐ取得処理 終了");

        return huho2Mosheijyunp;
    }

    public C_IkkatubaraiKbn huho2GetIkkatubaraikbn(String pIkkatubaraiKbn) {

        logger.debug("▽ 普保Ⅱ一括払区分取得処理 開始");

        C_IkkatubaraiKbn huho2Ikkatubaraikbn = null;

        if ("0".equals(pIkkatubaraiKbn)) {

            huho2Ikkatubaraikbn = C_IkkatubaraiKbn.BLNK;
        }
        else if ("1".equals(pIkkatubaraiKbn)) {

            huho2Ikkatubaraikbn = C_IkkatubaraiKbn.IKKATU;
        }
        else if ("2".equals(pIkkatubaraiKbn)) {

            huho2Ikkatubaraikbn = C_IkkatubaraiKbn.TEIKIIKKATU;
        }
        else {

            huho2Ikkatubaraikbn = C_IkkatubaraiKbn.BLNK;
        }

        logger.debug("△ 普保Ⅱ一括払区分取得処理 終了");

        return huho2Ikkatubaraikbn;
    }

    public C_IkkatubaraiKaisuuKbn huho2GetIkkatubaraikaisuu(String pIkkatubaraikaisuu) {

        logger.debug("▽ 普保Ⅱ一括払回数取得処理 開始");

        C_IkkatubaraiKaisuuKbn huho2Ikkatubaraikaisuu = null;

        if ("00".equals(pIkkatubaraikaisuu)) {

            huho2Ikkatubaraikaisuu = C_IkkatubaraiKaisuuKbn.BLNK;
        }
        else if ("02".equals(pIkkatubaraikaisuu)) {

            huho2Ikkatubaraikaisuu = C_IkkatubaraiKaisuuKbn.IKKATU2;
        }
        else if ("03".equals(pIkkatubaraikaisuu)) {

            huho2Ikkatubaraikaisuu = C_IkkatubaraiKaisuuKbn.IKKATU3;
        }
        else if ("04".equals(pIkkatubaraikaisuu)) {

            huho2Ikkatubaraikaisuu = C_IkkatubaraiKaisuuKbn.IKKATU4;
        }
        else if ("05".equals(pIkkatubaraikaisuu)) {

            huho2Ikkatubaraikaisuu = C_IkkatubaraiKaisuuKbn.IKKATU5;
        }
        else if ("06".equals(pIkkatubaraikaisuu)) {

            huho2Ikkatubaraikaisuu = C_IkkatubaraiKaisuuKbn.IKKATU6;
        }
        else if ("07".equals(pIkkatubaraikaisuu)) {

            huho2Ikkatubaraikaisuu = C_IkkatubaraiKaisuuKbn.IKKATU7;
        }
        else if ("08".equals(pIkkatubaraikaisuu)) {

            huho2Ikkatubaraikaisuu = C_IkkatubaraiKaisuuKbn.IKKATU8;
        }
        else if ("09".equals(pIkkatubaraikaisuu)) {

            huho2Ikkatubaraikaisuu = C_IkkatubaraiKaisuuKbn.IKKATU9;
        }
        else if ("10".equals(pIkkatubaraikaisuu)) {

            huho2Ikkatubaraikaisuu = C_IkkatubaraiKaisuuKbn.IKKATU10;
        }
        else if ("11".equals(pIkkatubaraikaisuu)) {

            huho2Ikkatubaraikaisuu = C_IkkatubaraiKaisuuKbn.IKKATU11;
        }
        else if ("12".equals(pIkkatubaraikaisuu)) {

            huho2Ikkatubaraikaisuu = C_IkkatubaraiKaisuuKbn.IKKATU12;
        }
        else {

            huho2Ikkatubaraikaisuu = C_IkkatubaraiKaisuuKbn.BLNK;
        }

        logger.debug("△ 普保Ⅱ一括払回数取得処理 終了");

        return huho2Ikkatubaraikaisuu;
    }

    public BizCurrency huho2GetMosikkatup(String pNyuukintuukakbn,
        Long pEnkamosikkatup, Long pGaikamosikkatup) {

        logger.debug("▽ 普保Ⅱ申込一括払Ｐ取得処理 開始");

        BizCurrency huho2Mosikkatup = null;
        CurrencyType currencyType = null;

        if ("1".equals(pNyuukintuukakbn)) {
            currencyType = BizCurrencyTypes.YEN;
        }
        else if ("2".equals(pNyuukintuukakbn)) {
            currencyType = BizCurrencyTypes.DOLLAR;
        }
        else if ("3".equals(pNyuukintuukakbn)) {
            currencyType = BizCurrencyTypes.EURO;
        }
        else if ("4".equals(pNyuukintuukakbn)) {
            currencyType = BizCurrencyTypes.AU_DOLLAR;
        }
        else {
            currencyType = BizCurrencyTypes.YEN;
        }

        huho2Mosikkatup = BizCurrency.valueOf(0, currencyType);

        if ("1".equals(pNyuukintuukakbn)
            && pEnkamosikkatup != null && pEnkamosikkatup != 0) {

            huho2Mosikkatup = BizCurrency.valueOf(pEnkamosikkatup, currencyType);
        }
        else if (("2".equals(pNyuukintuukakbn) || "3".equals(pNyuukintuukakbn) || "4".equals(pNyuukintuukakbn))
            && pGaikamosikkatup != null && pGaikamosikkatup != 0) {

            huho2Mosikkatup = BizCurrency.valueOf(pGaikamosikkatup, currencyType).divide(100);
        }

        logger.debug("△ 普保Ⅱ申込一括払Ｐ取得処理 終了");

        return huho2Mosikkatup;
    }

    public C_UmuKbn huho2GetZennoumousideumu(String pZennouhyouji) {

        logger.debug("▽ 普保Ⅱ前納申出有無取得処理 開始");

        C_UmuKbn huho2Zennoumousideumu = null;

        if ("1".equals(pZennouhyouji)) {

            huho2Zennoumousideumu = C_UmuKbn.ARI;
        }
        else {

            huho2Zennoumousideumu = C_UmuKbn.NONE;
        }

        logger.debug("△ 普保Ⅱ前納申出有無取得処理 終了");

        return huho2Zennoumousideumu;
    }

    public C_BlnktkumuKbn huho2GetZenkizennouumu(C_UmuKbn pZenkizennoutekiumu, String pZennouhyouji) {

        logger.debug("▽ 普保Ⅱ全期前納有無取得処理 開始");

        C_BlnktkumuKbn huho2Zenkizennouumu = null;

        if ("1".equals(pZennouhyouji)) {

            huho2Zenkizennouumu = C_BlnktkumuKbn.ARI;
        }
        else {

            if (C_UmuKbn.ARI.eq(pZenkizennoutekiumu)) {

                huho2Zenkizennouumu = C_BlnktkumuKbn.NONE;
            }
            else {

                huho2Zenkizennouumu = C_BlnktkumuKbn.BLNK;
            }
        }

        logger.debug("△ 普保Ⅱ全期前納有無取得処理 終了");

        return huho2Zenkizennouumu;
    }

    public Integer huho2GetZnnkai(Integer pZennoukikan) {

        logger.debug("▽ 普保Ⅱ前納回数取得処理 開始");

        Integer huho2Znnkai = null;

        if (pZennoukikan > 1) {

            huho2Znnkai = pZennoukikan - 1;
        }
        else {

            huho2Znnkai = 0;
        }

        logger.debug("△ 普保Ⅱ前納回数取得処理 終了");

        return huho2Znnkai;
    }

    public BizCurrency huho2GetMoszennoup(String pMostuukakbn,
        Long pEnkaMoszennoup, Long pGaikaMoszennoup) {

        logger.debug("▽ 普保Ⅱ申込前納Ｐ取得処理 開始");

        BizCurrency huho2Moszennoup = null;
        CurrencyType currencyType = null;

        if ("1".equals(pMostuukakbn)) {
            currencyType = BizCurrencyTypes.YEN;
        }
        else if ("2".equals(pMostuukakbn)) {
            currencyType = BizCurrencyTypes.DOLLAR;
        }
        else if ("3".equals(pMostuukakbn)) {
            currencyType = BizCurrencyTypes.EURO;
        }
        else if ("4".equals(pMostuukakbn)) {
            currencyType = BizCurrencyTypes.AU_DOLLAR;
        }
        else {
            currencyType = BizCurrencyTypes.YEN;
        }

        huho2Moszennoup = BizCurrency.valueOf(0, currencyType);

        if ("1".equals(pMostuukakbn)
            && pEnkaMoszennoup != null && pEnkaMoszennoup != 0) {

            huho2Moszennoup = BizCurrency.valueOf(pEnkaMoszennoup, currencyType);
        }
        else if (("2".equals(pMostuukakbn) || "3".equals(pMostuukakbn) || "4".equals(pMostuukakbn))
            && pGaikaMoszennoup != null && pGaikaMoszennoup != 0) {

            huho2Moszennoup = BizCurrency.valueOf(pGaikaMoszennoup, currencyType).divide(100);
        }

        logger.debug("△ 普保Ⅱ申込前納Ｐ取得処理 終了");

        return huho2Moszennoup;
    }

    public C_Tkhukaumu huho2GetKjnnkpzeitekitkhukakbn(C_UmuKbn pZeiseitekikakuumu,
        String pTksykmcd1, String pTksykmcd2, String pTksykmcd3, String pTksykmcd4, String pTksykmcd5) {

        logger.debug("▽ 普保Ⅱ個人年金保険料税制適格特約付加区分取得処理 開始");

        C_Tkhukaumu huho2Kjnnkpzeitekitkhukakbn = null;

        boolean tsbjFkmrrHanteiFlg = tsbjFkmrrHantei("C6", pTksykmcd1, pTksykmcd2, pTksykmcd3, pTksykmcd4, pTksykmcd5);

        if (tsbjFkmrrHanteiFlg == true) {

            huho2Kjnnkpzeitekitkhukakbn = C_Tkhukaumu.HUKA;
        }
        else {

            if (C_UmuKbn.ARI.eq(pZeiseitekikakuumu)) {

                huho2Kjnnkpzeitekitkhukakbn = C_Tkhukaumu.NONE;
            }
            else {
                huho2Kjnnkpzeitekitkhukakbn = C_Tkhukaumu.BLNK;
            }
        }

        logger.debug("△ 普保Ⅱ個人年金保険料税制適格特約付加区分取得処理 終了");

        return huho2Kjnnkpzeitekitkhukakbn;
    }

    public C_PplessrendoukouhurikousouKbn huho2GetPplsrendoukouhurikousoukbn(String pHrkkeiro, String pKuhrshmnttdkhyj) {

        logger.debug("▽ 普保Ⅱペーパーレス連動時口振申込書後送区分取得処理 開始");

        C_PplessrendoukouhurikousouKbn huho2Pplsrendoukouhurikousoukbn = null;

        if ("1".equals(pHrkkeiro)) {

            if ("1".equals(pKuhrshmnttdkhyj)) {

                huho2Pplsrendoukouhurikousoukbn = C_PplessrendoukouhurikousouKbn.ARI;
            }
            else {

                huho2Pplsrendoukouhurikousoukbn = C_PplessrendoukouhurikousouKbn.NONE;
            }
        }
        else {

            huho2Pplsrendoukouhurikousoukbn = C_PplessrendoukouhurikousouKbn.OTHER;
        }

        logger.debug("△ 普保Ⅱペーパーレス連動時口振申込書後送区分取得処理 終了");

        return huho2Pplsrendoukouhurikousoukbn;
    }

    public C_PplessrendoucreditkousouKbn huho2GetPplessrendoucreditkousoukbn(String pHrkkeiro, String pKuhrshmnttdkhyj) {

        logger.debug("▽ 普保Ⅱペーパーレス連動時クレカ申込書後送区分取得処理 開始");

        C_PplessrendoucreditkousouKbn huho2Pplessrendoucreditkousoukbn = null;

        if ("7".equals(pHrkkeiro)) {

            if ("1".equals(pKuhrshmnttdkhyj)) {

                huho2Pplessrendoucreditkousoukbn = C_PplessrendoucreditkousouKbn.ARI;
            }
            else {

                huho2Pplessrendoucreditkousoukbn = C_PplessrendoucreditkousouKbn.NONE;
            }
        }
        else {

            huho2Pplessrendoucreditkousoukbn = C_PplessrendoucreditkousouKbn.OTHER;
        }

        logger.debug("△ 普保Ⅱペーパーレス連動時クレカ申込書後送区分取得処理 終了");

        return huho2Pplessrendoucreditkousoukbn;
    }

    public String seihoWebGetPwaribikirankkbn(C_PWaribikitekiyouKbn pPwaribikitekiyoukbn) {

        logger.debug("▽ 生保Ｗｅｂ保険料割引ランク区分取得処理 開始");

        String seihowebPwaribikirankkbn = null;

        if (C_PWaribikitekiyouKbn.PWARISEIDO_RANK01.eq(pPwaribikitekiyoukbn)) {

            seihowebPwaribikirankkbn = "1";
        }
        else if (C_PWaribikitekiyouKbn.PWARISEIDO_RANK02.eq(pPwaribikitekiyoukbn)) {

            seihowebPwaribikirankkbn = "2";
        }
        else {

            seihowebPwaribikirankkbn = "0";
        }

        logger.debug("△ 生保Ｗｅｂ保険料割引ランク区分取得処理 終了");

        return seihowebPwaribikirankkbn;
    }

    public C_YakkanJyuryouKbn huho2GetYakkanJyuryouKbn(String pYakkankbn) {

        logger.debug("▽ 普保Ⅱ約款受領方法区分取得処理 開始");

        C_YakkanJyuryouKbn huho2YakkanJyuryouKbn = null;

        if ("1".equals(pYakkankbn)) {

            huho2YakkanJyuryouKbn = C_YakkanJyuryouKbn.WEB;
        }
        else if ("2".equals(pYakkankbn)) {

            huho2YakkanJyuryouKbn = C_YakkanJyuryouKbn.SASSI;
        }
        else if ("3".equals(pYakkankbn)) {

            huho2YakkanJyuryouKbn = C_YakkanJyuryouKbn.WEB_SASSI;
        }
        else {

            huho2YakkanJyuryouKbn = C_YakkanJyuryouKbn.BLNK;
        }

        logger.debug("△ 普保Ⅱ約款受領方法区分取得処理 終了");

        return huho2YakkanJyuryouKbn;
    }

    public BizDate mosymdHensyuu(BizDate pKijyunymd, String pHaraikomikaisukbn, String pHknsyuruino) {

        logger.debug("▽ 申込日編集処理 開始");

        BizDate mosymd = null;

        if (pKijyunymd == null) {

            logger.debug("△ 申込日編集処理 終了");
            return mosymd;
        }

        C_HknsyuruiNo hknsyuruino = huho2EditHknsyuruino(pHknsyuruino);
        if ("4".equals(pHaraikomikaisukbn)) {

            if (C_HknsyuruiNo.GAIKAINDEXNK.eq(hknsyuruino)
                || C_HknsyuruiNo.GAIKAINDEXNK_SISUU.eq(hknsyuruino)
                || C_HknsyuruiNo.GAIKAINDEXNK_TEIRITU.eq(hknsyuruino)) {

                if (pKijyunymd.getDay() < 16) {
                    mosymd = BizDate.valueOf(pKijyunymd.getBizDateYM().addMonths(-1), 1);
                }
                else {
                    mosymd = BizDate.valueOf(pKijyunymd.getBizDateYM().addMonths(-1), 16);
                }
            }
            else {
                mosymd = pKijyunymd;
            }
        }
        else if ("1".equals(pHaraikomikaisukbn)) {
        }
        else if ("2".equals(pHaraikomikaisukbn)) {
        }
        else if ("3".equals(pHaraikomikaisukbn)) {
        }
        else {
            mosymd = pKijyunymd;
        }

        logger.debug("△ 申込日編集処理 終了");

        return mosymd;
    }

    public C_Seibetu kzkSeibetuHenkan(String pSeibetukbn) {

        logger.debug("▽ ご家族性別変換処理 開始");

        C_Seibetu seibetu = null;

        if ("1".equals(pSeibetukbn)) {

            seibetu = C_Seibetu.MALE;
        }
        else if ("2".equals(pSeibetukbn)) {

            seibetu = C_Seibetu.FEMALE;
        }
        else {
            seibetu = C_Seibetu.BLNK;
        }

        logger.debug("△ ご家族性別変換処理 終了");

        return seibetu;
    }

    public C_TsindousiteiKbn tsindousiteikbnHenkan(String pKykdoukyohyj) {

        logger.debug("▽ 通信先同一指定区分変換処理 開始");

        C_TsindousiteiKbn tsindousiteikbn = null;

        if ("1".equals(pKykdoukyohyj)) {

            tsindousiteikbn = C_TsindousiteiKbn.ARI;
        }
        else {

            tsindousiteikbn = C_TsindousiteiKbn.BLNK;
        }

        logger.debug("△ 通信先同一指定区分変換処理 終了");

        return tsindousiteikbn;
    }

    public C_KzktourokuserviceTourokuKbn kzktourokumoskbnHenkan(String pKzktourokumoskbn) {

        logger.debug("▽ ご家族登録申込区分変換処理 開始");

        C_KzktourokuserviceTourokuKbn kzktourokuserviceTourokukbn = null;

        if ("1".equals(pKzktourokumoskbn)) {

            kzktourokuserviceTourokukbn = C_KzktourokuserviceTourokuKbn.ARI;
        }
        else if ("2".equals(pKzktourokumoskbn)) {

            kzktourokuserviceTourokukbn = C_KzktourokuserviceTourokuKbn.NONE;
        }
        else {

            kzktourokuserviceTourokukbn = C_KzktourokuserviceTourokuKbn.BLNK;
        }
        logger.debug("△ ご家族登録申込区分変換処理 終了");

        return kzktourokuserviceTourokukbn;
    }

    public C_Tdk kzktdkkbnHenkan(String pTdkkbn) {

        logger.debug("▽ ご家族続柄区分変換処理 開始");

        C_Tdk tdk = null;

        if ("1".equals(pTdkkbn)) {

            tdk = C_Tdk.HGU;
        }
        else if ("2".equals(pTdkkbn)) {

            tdk = C_Tdk.KO;
        }
        else if ("3".equals(pTdkkbn)) {

            tdk = C_Tdk.MAGO;

        }
        else if ("4".equals(pTdkkbn)) {

            tdk = C_Tdk.KYDSM;
        }
        else if ("5".equals(pTdkkbn)) {

            tdk = C_Tdk.SINTOU3;
        }
        else if ("7".equals(pTdkkbn)) {

            tdk = C_Tdk.SONOTA;
        }
        else if ("8".equals(pTdkkbn)) {

            tdk = C_Tdk.OYA;
        }
        else if ("9".equals(pTdkkbn)) {

            tdk = C_Tdk.SHB;
        }
        else {

            tdk = C_Tdk.BLNK;
        }

        logger.debug("△ ご家族続柄区分変換処理 終了");

        return tdk;
    }

    public C_Tdk hhkdrtdkkbnHenkan(String pTdkkbn) {

        logger.debug("▽ 被保険者代理人続柄区分変換処理 開始");

        C_Tdk tdk = null;

        if ("1".equals(pTdkkbn)) {

            tdk = C_Tdk.HGU;
        }
        else if ("2".equals(pTdkkbn)) {

            tdk = C_Tdk.KO;
        }
        else if ("3".equals(pTdkkbn)) {

            tdk = C_Tdk.OYA;
        }
        else if ("4".equals(pTdkkbn)) {

            tdk = C_Tdk.MAGO;
        }
        else if ("5".equals(pTdkkbn)) {

            tdk = C_Tdk.SHB;
        }
        else if ("6".equals(pTdkkbn)) {

            tdk = C_Tdk.KYDSM;
        }
        else if ("8".equals(pTdkkbn)) {

            tdk = C_Tdk.SINTOU3;
        }
        else if ("9".equals(pTdkkbn)) {

            tdk = C_Tdk.SONOTA;
        }
        else {

            tdk = C_Tdk.BLNK;
        }

        logger.debug("△ 被保険者代理人続柄区分変換処理 終了");

        return tdk;
    }

    public C_UktKbn kykdruktkbnHenkan(String pUktinputkbn) {

        logger.debug("▽ 契約者代理人受取人区分変換処理 開始");

        C_UktKbn uktkbn = null;

        if ("1".equals(pUktinputkbn)) {

            uktkbn = C_UktKbn.TOUROKUKAZOKU1;
        }
        else if ("2".equals(pUktinputkbn)) {

            uktkbn = C_UktKbn.TOUROKUKAZOKU2;
        }
        else {

            uktkbn = C_UktKbn.BLNK;
        }

        logger.debug("△ 契約者代理人受取人区分変換処理 終了");

        return uktkbn;
    }

    public C_Tkhukaumu kykdrtkykhukakbnHenkan(String pDrtkkbn) {

        logger.debug("▽ 契約者代理特約付加区分変換処理 開始");

        C_Tkhukaumu tkhukaumu = null;

        if ("1".equals(pDrtkkbn) || "2".equals(pDrtkkbn)) {

            tkhukaumu = C_Tkhukaumu.HUKA;
        }
        else {

            tkhukaumu = C_Tkhukaumu.BLNK;
        }

        logger.debug("△ 契約者代理特約付加区分変換処理 終了");

        return tkhukaumu;
    }

    public C_Tkhukaumu hhkdrtkykhukakbnHenkan(String pDrtkkbn) {

        logger.debug("▽ 被保険者代理特約付加区分変換処理 開始");

        C_Tkhukaumu tkhukaumu = null;

        if ("1".equals(pDrtkkbn) || "3".equals(pDrtkkbn)) {

            tkhukaumu = C_Tkhukaumu.HUKA;
        }
        else {

            tkhukaumu = C_Tkhukaumu.BLNK;
        }

        logger.debug("△ 被保険者代理特約付加区分変換処理 終了");

        return tkhukaumu;
    }

    public C_KzhuritourokuhouKbn kzhuritourokuhoukbnHenkan(
        String pHrkkeiro, String pKuhrshmnttdkhyj, String pNetkuhritaiouzumihyj) {

        logger.debug("▽ 口座振替登録方法区分変換処理 開始");

        C_KzhuritourokuhouKbn kzhuritourokuhoukbn = null;

        if ("1".equals(pHrkkeiro)) {

            if ("0".equals(pKuhrshmnttdkhyj)) {

                if ("0".equals(pNetkuhritaiouzumihyj)) {

                    kzhuritourokuhoukbn = C_KzhuritourokuhouKbn.PPLESS;
                }
                else if ("1".equals(pNetkuhritaiouzumihyj)) {

                    kzhuritourokuhoukbn = C_KzhuritourokuhouKbn.QR;
                }
                else {

                    kzhuritourokuhoukbn = C_KzhuritourokuhouKbn.BLNK;
                }
            }
            else if ("1".equals(pKuhrshmnttdkhyj)) {

                if ("0".equals(pNetkuhritaiouzumihyj)) {

                    kzhuritourokuhoukbn = C_KzhuritourokuhouKbn.SYOMEN;
                }
                else {

                    kzhuritourokuhoukbn = C_KzhuritourokuhouKbn.BLNK;
                }
            }
            else {
                kzhuritourokuhoukbn = C_KzhuritourokuhouKbn.BLNK;
            }
        }
        else {

            kzhuritourokuhoukbn = C_KzhuritourokuhouKbn.BLNK;
        }

        logger.debug("△ 口座振替登録方法区分変換処理 終了");

        return kzhuritourokuhoukbn;
    }

    public C_Tkhukaumu teikisiharaitkykhkkbnSyutoku(String pTeikisiharaiarihyj, C_HknsyuruiNo pHknsyuruino) {

        logger.debug("▽ 定期支払特約付加区分取得処理 開始");

        C_Tkhukaumu tkhukaUmu = null;

        if ("1".equals(pTeikisiharaiarihyj)) {

            tkhukaUmu = C_Tkhukaumu.HUKA;
        }
        else {
            if (C_HknsyuruiNo.GAIKAINDEXNK_20_TEIRITUTEIKI.eq(pHknsyuruino)) {
                tkhukaUmu = C_Tkhukaumu.NONE;
            }
            else {
                tkhukaUmu = C_Tkhukaumu.BLNK;
            }
        }

        logger.debug("△ 定期支払特約付加区分取得処理 終了");

        return tkhukaUmu;
    }

    public C_KoureiKzkSetumeiHouKbn koureikzksetumeihoukbnSyutoku(String pKoureisyakakkbn) {

        logger.debug("▽ 高齢者ご家族等説明方法区分取得処理 開始");

        C_KoureiKzkSetumeiHouKbn koureikzksetumeihoukbn = null;

        if ("1".equals(pKoureisyakakkbn)) {

            koureikzksetumeihoukbn = C_KoureiKzkSetumeiHouKbn.KAZOKUDOUSEKI;
        }
        else if ("2".equals(pKoureisyakakkbn)) {

            koureikzksetumeihoukbn = C_KoureiKzkSetumeiHouKbn.KAZOKUJIZENTAIMEN;
        }
        else if ("3".equals(pKoureisyakakkbn)) {

            koureikzksetumeihoukbn = C_KoureiKzkSetumeiHouKbn.KAZOKUJIZENYUUSOU;
        }
        else if ("9".equals(pKoureisyakakkbn)) {

            koureikzksetumeihoukbn = C_KoureiKzkSetumeiHouKbn.JOUKIHUKA;
        }
        else {

            koureikzksetumeihoukbn = C_KoureiKzkSetumeiHouKbn.BLNK;
        }

        logger.debug("△ 高齢者ご家族等説明方法区分取得処理 終了");

        return koureikzksetumeihoukbn;
    }

    public String syouhnhantei(C_HknsyuruiNo pHknsyuruiNo) {

        logger.debug("▽ 商品判定（商品属性マスタ取得用）処理 開始");

        String syouhinHantei = "2";

        if(C_HknsyuruiNo.GAIKAITIJIBRISYUUSIN_19_SGARI.eq(pHknsyuruiNo) ||
            C_HknsyuruiNo.GAIKAINDEXNK.eq(pHknsyuruiNo) ||
            C_HknsyuruiNo.GAIKAINDEXNK_SISUU.eq(pHknsyuruiNo) ||
            C_HknsyuruiNo.GAIKAINDEXNK_TEIRITU.eq(pHknsyuruiNo) ||
            C_HknsyuruiNo.GAIKAINDEXNK_20_SISUU.eq(pHknsyuruiNo) ||
            C_HknsyuruiNo.GAIKAINDEXNK_20_TEIRITUTEIKI.eq(pHknsyuruiNo) ||
            C_HknsyuruiNo.GAIKARIRITUHENDOUNK.eq(pHknsyuruiNo) ){

            syouhinHantei = "1";
        }

        logger.debug("△ 商品判定（商品属性マスタ取得用）処理 終了");
        return syouhinHantei;
    }

    public C_NensyuuKbn hhknnensyuukbnSyutoku(String pHhknnensyuukbn) {

        logger.debug("▽ 被保険者年収区分取得処理 開始");

        C_NensyuuKbn nensyuuKbn = C_NensyuuKbn.BLNK;
        if ("1".equals(pHhknnensyuukbn)) {

            nensyuuKbn = C_NensyuuKbn.UNDER300;
        }
        else if ("2".equals(pHhknnensyuukbn)) {

            nensyuuKbn = C_NensyuuKbn.UNDER500;
        }
        else if ("3".equals(pHhknnensyuukbn)) {

            nensyuuKbn = C_NensyuuKbn.UNDER700;
        }
        else if ("4".equals(pHhknnensyuukbn)) {

            nensyuuKbn = C_NensyuuKbn.UNDER1000;
        }
        else if ("5".equals(pHhknnensyuukbn)) {

            nensyuuKbn = C_NensyuuKbn.MORETHAN1000;
        }

        logger.debug("△ 被保険者年収区分取得処理 終了");
        return nensyuuKbn;
    }

    public C_YnkHrkmgkAnniTuutiKbn ptuutihyjHenkan(String pPtuutihyj, C_HknsyuruiNo pHknsyuruiNo,
        C_BlnktkumuKbn pZenkizennouumu, C_Tuukasyu pNykntuukasyu) {

        logger.debug("▽ 保険料通知有表示変換処理 開始");
        C_YnkHrkmgkAnniTuutiKbn ynkHrkmgkAnniTuutiKbn = C_YnkHrkmgkAnniTuutiKbn.BLNK;

        if ("1".equals(pPtuutihyj)) {

            ynkHrkmgkAnniTuutiKbn = C_YnkHrkmgkAnniTuutiKbn.YUUSOUKIBOU;
        }
        else {
            if (C_HknsyuruiNo.TEIKAIYAKUHRKNSYSN_USDDT.eq(pHknsyuruiNo)) {
                if (C_BlnktkumuKbn.NONE.eq(pZenkizennouumu) && C_Tuukasyu.JPY.eq(pNykntuukasyu)) {

                    ynkHrkmgkAnniTuutiKbn = C_YnkHrkmgkAnniTuutiKbn.YUUSOUKIBOUSHINAI;
                }
            }
        }
        logger.debug("△ 保険料通知有表示変換処理 終了");
        return ynkHrkmgkAnniTuutiKbn;
    }
}