package yuyu.common.sinkeiyaku.skcommon;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.date.BizDate;
import yuyu.common.biz.bzcommon.BizUtil;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_BlnktkumuKbn;
import yuyu.def.classification.C_HaitouKeisanHousikiKbn;
import yuyu.def.classification.C_HknsyuruiNo;
import yuyu.def.classification.C_KaiyakuKeisanHousikiKbn;
import yuyu.def.classification.C_Sknenkinsyu;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_YouhiKbn;
import yuyu.def.db.entity.BM_SyouhnZokusei;

/**
 * 新契約 新契約共通 商品属性ユーティリティ
 */
public class SyouhinUtil {

    public static final int GAIKAITIJIBRISYUUSIN_SOKUJIHOSYOU              = 101;

    public static final int GAIKAITIJIBRISYUUSIN_MAITOSIUKT                = 102;

    public static final int GAIKAITIJIBRIHENGAKUNK_BLEND                   = 103;

    public static final int GONENRISAHAITOUSITEITUUKASYUUSIN_ITIJIBR       = 104;

    public static final int GONENRISAHAITOUSITEITUUKASYUUSIN_ITIJIBR_19     = 107;

    public static final int GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR      = 105;

    public static final int GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR_20   = 108;

    public static final int YOTEIRIRITUHENDOU_GONENRISAHAITOU_SITEITUUKA_NENKIN    = 106;

    public static final int TEIKAIYAKUHRKN_GONENRISAHAITOU_SNTKTUUKA_TKBTSYUUSINHKN = 109;

    public static final int SYOHIN_BLNK                                    = 999;

    public static final int HENKOUKUBETU_GONENRISAHAITOUSITEITUUKASYUUSIN_ITIJIBR_YENHENKOUMAE  = 1041;

    public static final int HENKOUKUBETU_GONENRISAHAITOUSITEITUUKASYUUSIN_ITIJIBR_YENHENKOUGO   = 1042;

    public static final int HENKOUKUBETU_GONENRISAHAITOUSITEITUUKASYUUSIN_ITIJIBR_19_YENHENKOUMAE  = 1071;

    public static final int HENKOUKUBETU_GONENRISAHAITOUSITEITUUKASYUUSIN_ITIJIBR_19_YENHENKOUGO   = 1072;

    public static final int HENKOUKUBETU_GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR_YENHENKOUMAE = 1051;

    public static final int HENKOUKUBETU_GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR_YENHENKOUGO  = 1052;

    public static final int HENKOUKUBETU_GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR_20_YENHENKOUMAE = 1081;

    public static final int HENKOUKUBETU_GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR_20_YENHENKOUGO  = 1082;

    public static final int HENKOUKUBETU_YOTEIRIRITUHENDOU_GONENRISAHAITOU_SITEITUUKA_NENKIN    = 1060;

    public static final int HENKOUKUBETU_TEIKAIYAKUHRKN_GONENRISAHAITOU_SNTKTUUKA_TKBTSYUUSINHKN = 1090;

    public static final int HENKOUKUBETU_SYOHIN_BLNK                       = 9999;

    public static final String[] GAIKAITIJIBRISYUUSIN_SOKUJIHOSYOUS        = {"ｱ1","ｱ2"};

    public static final String[] GAIKAITIJIBRISYUUSIN_MAITOSIUKTS          = {"ｲ1","ｲ2"};

    public static final String[] GAIKAITIJIBRIHENGAKUNK_BLENDS             = {"ｳ1","ｳ2"};

    public static final String[] GONENRISAHAITOUSITEITUUKASYUUSIN_ITIJIBRS = {"ﾕｱ","ﾕｲ","ﾕｳ","ﾕｴ","ﾕｵ","ﾕｶ","ﾕｷ","ﾕｸ","ﾕA"};

    public static final String[] GONENRISAHAITOUSITEITUUKASYUUSIN_ITIJIBRS_19 = {"ﾕﾉ","ﾕﾊ","ﾕﾋ","ﾕﾌ","ﾕF"};

    public static final String[] GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBRS= {"ﾕｹ","ﾕｺ","ﾕｻ","ﾕｼ","ﾕｽ","ﾕｾ","ﾕｿ","ﾕﾀ","ﾕB","ﾕC","ﾕD","ﾕE"};

    public static final String[] GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBRS_20 = {"ﾕﾍ","ﾕﾎ","ﾕﾏ","ﾕﾐ","ﾕﾑ","ﾕﾒ","ﾕﾓ","ﾕﾔ","ﾕﾕ","ﾕﾖ","ﾕﾗ","ﾕﾘ","ﾕﾙ","ﾕﾚ","ﾕﾛ","ﾕﾜ","ﾕG","ﾕH","ﾕJ","ﾕK"};

    public static final String[] YOTEIRIRITUHENDOU_GONENRISAHAITOU_SITEITUUKA_NENKINS                       = {"ﾕﾁ","ﾕﾂ","ﾕﾃ","ﾕﾄ","ﾕﾅ","ﾕﾆ","ﾕﾇ","ﾕﾈ"};

    public static final String[] TEIKAIYAKUHRKN_GONENRISAHAITOU_SNTKTUUKA_TKBTSYUUSINHKNS = {"ﾆｱ"};

    public static final String[] HENKOUKUBETU_GONENRISAHAITOUSITEITUUKASYUUSIN_ITIJIBRS_YENHENKOUMAE        = {"ﾕｱ","ﾕｲ","ﾕｳ","ﾕｴ","ﾕｵ","ﾕｶ","ﾕｷ","ﾕｸ"};

    public static final String[] HENKOUKUBETU_GONENRISAHAITOUSITEITUUKASYUUSIN_ITIJIBRS_YENHENKOUGO         = {"ﾕA"};

    public static final String[] HENKOUKUBETU_GONENRISAHAITOUSITEITUUKASYUUSIN_ITIJIBRS_19_YENHENKOUMAE        = {"ﾕﾉ","ﾕﾊ","ﾕﾋ","ﾕﾌ"};

    public static final String[] HENKOUKUBETU_GONENRISAHAITOUSITEITUUKASYUUSIN_ITIJIBRS_19_YENHENKOUGO         = {"ﾕF"};

    public static final String[] HENKOUKUBETU_GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBRS_YENHENKOUMAE       = {"ﾕｹ","ﾕｺ","ﾕｻ","ﾕｼ","ﾕｽ","ﾕｾ","ﾕｿ","ﾕﾀ"};

    public static final String[] HENKOUKUBETU_GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBRS_YENHENKOUGO        = {"ﾕB","ﾕC","ﾕD","ﾕE"};

    public static final String[] HENKOUKUBETU_GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBRS_20_YENHENKOUMAE       = {"ﾕﾍ","ﾕﾎ","ﾕﾏ","ﾕﾐ","ﾕﾑ","ﾕﾒ","ﾕﾓ","ﾕﾔ","ﾕﾕ","ﾕﾖ","ﾕﾗ","ﾕﾘ","ﾕﾙ","ﾕﾚ","ﾕﾛ","ﾕﾜ"};

    public static final String[] HENKOUKUBETU_GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBRS_20_YENHENKOUGO        = {"ﾕG","ﾕH","ﾕJ","ﾕK"};

    public static final String YOTEIRIRITUHENDOU_GONENRISAHAITOU_SITEITUUKA_NENKIN_TEIGAKUNK                = "33101";

    public static final String YOTEIRIRITUHENDOU_GONENRISAHAITOU_SITEITUUKA_NENKIN_NKBAIGAKU                = "33102";

    public static final String GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR_20_TEIRITU                         = "32501";

    public static final String GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR_20_TEIKI                           = "32502";

    public static final String YOTEIRIRITUHENDOU_GONENRISAHAITOU_SITEITUUKA_NENKIN_GETUBARAIKANSANP         = "33101";

    public static final String YOTEIRIRITUHENDOU_GONENRISAHAITOU_SITEITUUKA_NENKIN_ENKAPHARAIKOMISOUGAKU    = "33102";

    private static final String[] GETHKNSYUNOKEYTOAISYOU_HANTEIYOUS = {"ﾕﾄ", "ﾕﾈ", "ﾕﾑ", "ﾕﾒ", "ﾕﾓ", "ﾕﾔ", "ﾕﾙ", "ﾕﾚ", "ﾕﾛ", "ﾕﾜ"};

    @Inject
    private BizDomManager bizDomManager;

    public SyouhinUtil() {
        super();
    }

    public static int hantei(String pSyouhnCd) {
        if (pSyouhnCd == null) {
            return SYOHIN_BLNK;
        }

        int syohinHanteiKbn = SYOHIN_BLNK;

        for (int r = 0; r < GONENRISAHAITOUSITEITUUKASYUUSIN_ITIJIBRS.length; r++) {
            String syohinCdGonenRisaHaitouSiteituukaSyuusin_itijibr = GONENRISAHAITOUSITEITUUKASYUUSIN_ITIJIBRS[r];

            if (pSyouhnCd.equals(syohinCdGonenRisaHaitouSiteituukaSyuusin_itijibr)) {
                syohinHanteiKbn = GONENRISAHAITOUSITEITUUKASYUUSIN_ITIJIBR;
                return syohinHanteiKbn;
            }
        }

        for (int r = 0; r < GONENRISAHAITOUSITEITUUKASYUUSIN_ITIJIBRS_19.length; r++) {
            String syohinCdGonenRisaHaitouSiteituukaSyuusin_itijibr19 = GONENRISAHAITOUSITEITUUKASYUUSIN_ITIJIBRS_19[r];

            if (pSyouhnCd.equals(syohinCdGonenRisaHaitouSiteituukaSyuusin_itijibr19)) {
                syohinHanteiKbn = GONENRISAHAITOUSITEITUUKASYUUSIN_ITIJIBR_19;
                return syohinHanteiKbn;
            }
        }

        for (int k = 0; k < GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBRS.length; k++) {
            String syohinCdGonenRisaHaitouSiteituukaNenkin_itijibr = GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBRS[k];
            if (pSyouhnCd.equals(syohinCdGonenRisaHaitouSiteituukaNenkin_itijibr)) {
                syohinHanteiKbn = GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR;
                return syohinHanteiKbn;
            }
        }

        for (int n = 0; n < GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBRS_20.length; n++) {
            String syohinCdGonenRisaHaitouSiteituukaNenkin_itijibr20 = GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBRS_20[n];
            if (pSyouhnCd.equals(syohinCdGonenRisaHaitouSiteituukaNenkin_itijibr20)) {
                syohinHanteiKbn = GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR_20;
                return syohinHanteiKbn;
            }
        }

        for (int k = 0; k < YOTEIRIRITUHENDOU_GONENRISAHAITOU_SITEITUUKA_NENKINS.length; k++) {
            String syohinCdGaikaRirituHendouNk = YOTEIRIRITUHENDOU_GONENRISAHAITOU_SITEITUUKA_NENKINS[k];
            if (pSyouhnCd.equals(syohinCdGaikaRirituHendouNk)) {
                syohinHanteiKbn = YOTEIRIRITUHENDOU_GONENRISAHAITOU_SITEITUUKA_NENKIN;
                return syohinHanteiKbn;
            }
        }

        for (int k = 0; k < TEIKAIYAKUHRKN_GONENRISAHAITOU_SNTKTUUKA_TKBTSYUUSINHKNS.length; k++) {
            String syohinCdTeikaiyakuhrknSyuusinhkns = TEIKAIYAKUHRKN_GONENRISAHAITOU_SNTKTUUKA_TKBTSYUUSINHKNS[k];
            if (pSyouhnCd.equals(syohinCdTeikaiyakuhrknSyuusinhkns)) {
                syohinHanteiKbn = TEIKAIYAKUHRKN_GONENRISAHAITOU_SNTKTUUKA_TKBTSYUUSINHKN;
                return syohinHanteiKbn;
            }
        }

        for (int i = 0; i < GAIKAITIJIBRISYUUSIN_SOKUJIHOSYOUS.length; i++) {
            String syohinCdGaikaitIjbrSyuusin_sokujiHosyou = GAIKAITIJIBRISYUUSIN_SOKUJIHOSYOUS[i];

            if (pSyouhnCd.equals(syohinCdGaikaitIjbrSyuusin_sokujiHosyou)) {
                syohinHanteiKbn = GAIKAITIJIBRISYUUSIN_SOKUJIHOSYOU;
                return syohinHanteiKbn;
            }
        }

        for (int j = 0; j < GAIKAITIJIBRISYUUSIN_MAITOSIUKTS.length; j++) {
            String syohinCdGaikaitIjbriSyuusin_maitoSiukt = GAIKAITIJIBRISYUUSIN_MAITOSIUKTS[j];

            if (pSyouhnCd.equals(syohinCdGaikaitIjbriSyuusin_maitoSiukt)) {
                syohinHanteiKbn = GAIKAITIJIBRISYUUSIN_MAITOSIUKT;
                return syohinHanteiKbn;
            }
        }

        for (int r = 0; r < GAIKAITIJIBRIHENGAKUNK_BLENDS.length; r++) {
            String syohinCdGaikaitIjbriHengakuUnk_blend = GAIKAITIJIBRIHENGAKUNK_BLENDS[r];

            if (pSyouhnCd.equals(syohinCdGaikaitIjbriHengakuUnk_blend)) {
                syohinHanteiKbn = GAIKAITIJIBRIHENGAKUNK_BLEND;
                return syohinHanteiKbn;
            }
        }

        return syohinHanteiKbn;
    }

    public static int henkouKubetuHantei(String pSyouhnCd) {

        if (pSyouhnCd == null) {
            return HENKOUKUBETU_SYOHIN_BLNK;
        }

        int henkoukubetuSyohinHanteiKbn = HENKOUKUBETU_SYOHIN_BLNK;

        for (int i = 0; i < HENKOUKUBETU_GONENRISAHAITOUSITEITUUKASYUUSIN_ITIJIBRS_YENHENKOUMAE.length; i++) {
            String hikakuTaisyoCd = HENKOUKUBETU_GONENRISAHAITOUSITEITUUKASYUUSIN_ITIJIBRS_YENHENKOUMAE[i];
            if (pSyouhnCd.equals(hikakuTaisyoCd)) {
                henkoukubetuSyohinHanteiKbn = HENKOUKUBETU_GONENRISAHAITOUSITEITUUKASYUUSIN_ITIJIBR_YENHENKOUMAE;
                return henkoukubetuSyohinHanteiKbn;
            }
        }

        for (int i = 0; i < HENKOUKUBETU_GONENRISAHAITOUSITEITUUKASYUUSIN_ITIJIBRS_YENHENKOUGO.length; i++) {
            String hikakuTaisyoCd = HENKOUKUBETU_GONENRISAHAITOUSITEITUUKASYUUSIN_ITIJIBRS_YENHENKOUGO[i];
            if (pSyouhnCd.equals(hikakuTaisyoCd)) {
                henkoukubetuSyohinHanteiKbn = HENKOUKUBETU_GONENRISAHAITOUSITEITUUKASYUUSIN_ITIJIBR_YENHENKOUGO;
                return henkoukubetuSyohinHanteiKbn;
            }
        }

        for (int i = 0; i < HENKOUKUBETU_GONENRISAHAITOUSITEITUUKASYUUSIN_ITIJIBRS_19_YENHENKOUMAE.length; i++) {
            String hikakuTaisyoCd = HENKOUKUBETU_GONENRISAHAITOUSITEITUUKASYUUSIN_ITIJIBRS_19_YENHENKOUMAE[i];
            if (pSyouhnCd.equals(hikakuTaisyoCd)) {
                henkoukubetuSyohinHanteiKbn = HENKOUKUBETU_GONENRISAHAITOUSITEITUUKASYUUSIN_ITIJIBR_19_YENHENKOUMAE;
                return henkoukubetuSyohinHanteiKbn;
            }
        }

        for (int i = 0; i < HENKOUKUBETU_GONENRISAHAITOUSITEITUUKASYUUSIN_ITIJIBRS_19_YENHENKOUGO.length; i++) {
            String hikakuTaisyoCd = HENKOUKUBETU_GONENRISAHAITOUSITEITUUKASYUUSIN_ITIJIBRS_19_YENHENKOUGO[i];
            if (pSyouhnCd.equals(hikakuTaisyoCd)) {
                henkoukubetuSyohinHanteiKbn = HENKOUKUBETU_GONENRISAHAITOUSITEITUUKASYUUSIN_ITIJIBR_19_YENHENKOUGO;
                return henkoukubetuSyohinHanteiKbn;
            }
        }

        for (int i = 0; i < HENKOUKUBETU_GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBRS_YENHENKOUMAE.length; i++) {
            String hikakuTaisyoCd = HENKOUKUBETU_GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBRS_YENHENKOUMAE[i];
            if (pSyouhnCd.equals(hikakuTaisyoCd)) {
                henkoukubetuSyohinHanteiKbn = HENKOUKUBETU_GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR_YENHENKOUMAE;
                return henkoukubetuSyohinHanteiKbn;
            }
        }

        for (int i = 0; i < HENKOUKUBETU_GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBRS_YENHENKOUGO.length; i++) {
            String hikakuTaisyoCd = HENKOUKUBETU_GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBRS_YENHENKOUGO[i];
            if (pSyouhnCd.equals(hikakuTaisyoCd)) {
                henkoukubetuSyohinHanteiKbn = HENKOUKUBETU_GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR_YENHENKOUGO;
                return henkoukubetuSyohinHanteiKbn;
            }
        }

        for (int i = 0; i < HENKOUKUBETU_GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBRS_20_YENHENKOUMAE.length; i++) {
            String hikakuTaisyoCd = HENKOUKUBETU_GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBRS_20_YENHENKOUMAE[i];
            if (pSyouhnCd.equals(hikakuTaisyoCd)) {
                henkoukubetuSyohinHanteiKbn = HENKOUKUBETU_GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR_20_YENHENKOUMAE;
                return henkoukubetuSyohinHanteiKbn;
            }
        }

        for (int i = 0; i < HENKOUKUBETU_GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBRS_20_YENHENKOUGO.length; i++) {
            String hikakuTaisyoCd = HENKOUKUBETU_GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBRS_20_YENHENKOUGO[i];
            if (pSyouhnCd.equals(hikakuTaisyoCd)) {
                henkoukubetuSyohinHanteiKbn = HENKOUKUBETU_GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR_20_YENHENKOUGO;
                return henkoukubetuSyohinHanteiKbn;
            }
        }

        for (int i = 0; i < YOTEIRIRITUHENDOU_GONENRISAHAITOU_SITEITUUKA_NENKINS.length; i++) {
            String hikakuTaisyoCd = YOTEIRIRITUHENDOU_GONENRISAHAITOU_SITEITUUKA_NENKINS[i];
            if (pSyouhnCd.equals(hikakuTaisyoCd)) {
                henkoukubetuSyohinHanteiKbn = HENKOUKUBETU_YOTEIRIRITUHENDOU_GONENRISAHAITOU_SITEITUUKA_NENKIN;
                return henkoukubetuSyohinHanteiKbn;
            }
        }

        for (int i = 0; i < TEIKAIYAKUHRKN_GONENRISAHAITOU_SNTKTUUKA_TKBTSYUUSINHKNS.length; i++) {
            String hikakuTaisyoCd = TEIKAIYAKUHRKN_GONENRISAHAITOU_SNTKTUUKA_TKBTSYUUSINHKNS[i];
            if (pSyouhnCd.equals(hikakuTaisyoCd)) {
                henkoukubetuSyohinHanteiKbn = HENKOUKUBETU_TEIKAIYAKUHRKN_GONENRISAHAITOU_SNTKTUUKA_TKBTSYUUSINHKN;
                return henkoukubetuSyohinHanteiKbn;
            }
        }

        return henkoukubetuSyohinHanteiKbn;
    }

    public String getSyouhnNm(String pSyouhnCd, BizDate pSysDate) {

        String syouhnNm = null;

        BM_SyouhnZokusei syouhnZokusei = bizDomManager.getSyouhnZokuseiBySyouhncdHyoujiymd(pSyouhnCd, pSysDate);
        if (syouhnZokusei != null) {
            syouhnNm = syouhnZokusei.getSyouhnnm();
        }
        return syouhnNm;
    }

    public String getSyouhnNm_Ryaku(String pSyouhnCd, BizDate pSysDate) {

        String syouhnNmRyaku = null;

        BM_SyouhnZokusei syouhnZokusei = bizDomManager.getSyouhnZokuseiBySyouhncdHyoujiymd(pSyouhnCd, pSysDate);
        if (syouhnZokusei != null) {
            syouhnNmRyaku = syouhnZokusei.getSyouhnnmryaku();
        }

        return syouhnNmRyaku;
    }

    public String getSyouhnNm_Ryaku5(String pSyouhnCd, BizDate pSysDate) {

        String syouhnNmRyaku5 = null;

        BM_SyouhnZokusei syouhnZokusei = bizDomManager.getSyouhnZokuseiBySyouhncdHyoujiymd(pSyouhnCd, pSysDate);
        if (syouhnZokusei != null) {
            syouhnNmRyaku5 = syouhnZokusei.getSyouhnnmryaku5();
        }

        return syouhnNmRyaku5;
    }

    public String getSyouhnNm_WorkList(String pSyouhnCd, BizDate pSysDate) {

        String syouhnNmWorklist = null;

        BM_SyouhnZokusei syouhnZokusei = bizDomManager.getSyouhnZokuseiBySyouhncdHyoujiymd(pSyouhnCd, pSysDate);
        if (syouhnZokusei != null) {
            syouhnNmWorklist = syouhnZokusei.getSyouhnnmworklist();
        }

        return syouhnNmWorklist;
    }

    public List<String> getSyouhnNmList(List<String> pSyouhnCdLst, BizDate pSysDate) {

        List<String> syouhnNmsLst = new ArrayList<>();

        for (String syohnCd : pSyouhnCdLst) {
            syouhnNmsLst.add(getSyouhnNm(syohnCd, pSysDate));
        }

        return syouhnNmsLst;
    }

    public static boolean isSensinIryoTk(String pSyouhnCd) {

        if(BizUtil.isBlank(pSyouhnCd)){
            return false;
        }
        return false;
    }

    public static boolean isIryouHoken(String pSyouhnCd) {

        if (BizUtil.isBlank(pSyouhnCd)){
            return false;
        }
        return false;
    }

    public static boolean isHandSkijyunTaisyouHantei(String pSyouhnCd) {

        if (BizUtil.isBlank(pSyouhnCd)){
            return false;
        }

        int syohinHanteiKbn = hantei(pSyouhnCd);

        if (syohinHanteiKbn == GAIKAITIJIBRISYUUSIN_SOKUJIHOSYOU
            || syohinHanteiKbn == GAIKAITIJIBRISYUUSIN_MAITOSIUKT) {
            return true;
        }

        return false;
    }

    public static boolean chkHengakuNenkin(String pSyouhnCd) {

        if (BizUtil.isBlank(pSyouhnCd)){
            return false;
        }

        int syohinHanteiKbn = hantei(pSyouhnCd);

        if (syohinHanteiKbn == GAIKAITIJIBRIHENGAKUNK_BLEND) {
            return true;
        }

        return false;
    }

    public static boolean chkHengakuNenkinSyouhnZokusei(BM_SyouhnZokusei pSyouhnZokusei) {

        if (pSyouhnZokusei == null) {
            return false;
        }

        if (C_UmuKbn.ARI.eq(pSyouhnZokusei.getHengakuumu()) && C_UmuKbn.ARI.eq(pSyouhnZokusei.getNkhknumu())) {
            return true;
        }
        return false;
    }

    public static String getSeirituJyouhouHanbaiNm(BM_SyouhnZokusei pBM_SyouhnZokuseiSyu, C_Tuukasyu pTuukasyu) {

        if (pBM_SyouhnZokuseiSyu == null) {
            return "";
        }
        String syouhnCdSyu = pBM_SyouhnZokuseiSyu.getSyouhncd();
        if (BizUtil.isBlank(syouhnCdSyu)) {
            return "";
        }

        int syohinHanteiKbn = hantei(syouhnCdSyu);

        String seiriTujyouhouhanbaiNmCd = "";

        if (syohinHanteiKbn != SYOHIN_BLNK) {

            if (syohinHanteiKbn == GONENRISAHAITOUSITEITUUKASYUUSIN_ITIJIBR) {
                if (pBM_SyouhnZokuseiSyu.getDai1hknkkn().intValue() == 5) {
                    seiriTujyouhouhanbaiNmCd = "C0";
                }
                else if (pBM_SyouhnZokuseiSyu.getDai1hknkkn().intValue() == 10) {
                    seiriTujyouhouhanbaiNmCd = "C1";
                }
            }

            else if (syohinHanteiKbn == GONENRISAHAITOUSITEITUUKASYUUSIN_ITIJIBR_19) {
                seiriTujyouhouhanbaiNmCd = "C8";
            }

            else if (syohinHanteiKbn == GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR) {
                seiriTujyouhouhanbaiNmCd = "C2";
            }

            else if (syohinHanteiKbn == GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR_20) {
                seiriTujyouhouhanbaiNmCd = "C9";
            }

            else if (syohinHanteiKbn == YOTEIRIRITUHENDOU_GONENRISAHAITOU_SITEITUUKA_NENKIN) {

                if (C_Sknenkinsyu.KKTI5.eq(pBM_SyouhnZokuseiSyu.getSknenkinsyu())) {
                    seiriTujyouhouhanbaiNmCd = "C3";
                }
                else if (C_Sknenkinsyu.KKTI10.eq(pBM_SyouhnZokuseiSyu.getSknenkinsyu())) {
                    seiriTujyouhouhanbaiNmCd = "C4";
                }
                else if (C_Sknenkinsyu.KKTI15.eq(pBM_SyouhnZokuseiSyu.getSknenkinsyu())) {
                    seiriTujyouhouhanbaiNmCd = "C5";
                }
                else if (C_Sknenkinsyu.KKTI5DAI1BAIGAKU.eq(pBM_SyouhnZokuseiSyu.getSknenkinsyu())) {
                    seiriTujyouhouhanbaiNmCd = "C6";
                }
            }

            else if (syohinHanteiKbn == GAIKAITIJIBRISYUUSIN_SOKUJIHOSYOU) {
                seiriTujyouhouhanbaiNmCd = "B6";
            }

            else if (syohinHanteiKbn == GAIKAITIJIBRISYUUSIN_MAITOSIUKT) {
                seiriTujyouhouhanbaiNmCd = "B7";
            }

            else if (syohinHanteiKbn == GAIKAITIJIBRIHENGAKUNK_BLEND) {
                seiriTujyouhouhanbaiNmCd = "B8";
            }

            else if (syohinHanteiKbn == TEIKAIYAKUHRKN_GONENRISAHAITOU_SNTKTUUKA_TKBTSYUUSINHKN) {

                if (C_Tuukasyu.JPY.eq(pTuukasyu)) {

                    seiriTujyouhouhanbaiNmCd = "CA";
                }
                else if (C_Tuukasyu.USD.eq(pTuukasyu)) {

                    seiriTujyouhouhanbaiNmCd = "CB";
                }
            }
        }
        return seiriTujyouhouhanbaiNmCd;
    }

    public String getHknsyuNoKeyToAisyou(String pSyouhnCd, C_HknsyuruiNo pHknsyuruiNo) {

        String hokenSyuruiBangoBetuKey1 = "";

        int syohinHanteiKbn = hantei(pSyouhnCd);

        if (syohinHanteiKbn == YOTEIRIRITUHENDOU_GONENRISAHAITOU_SITEITUUKA_NENKIN) {

            if (pSyouhnCd.equals(GETHKNSYUNOKEYTOAISYOU_HANTEIYOUS[0]) ||
                pSyouhnCd.equals(GETHKNSYUNOKEYTOAISYOU_HANTEIYOUS[1])) {

                hokenSyuruiBangoBetuKey1 = YOTEIRIRITUHENDOU_GONENRISAHAITOU_SITEITUUKA_NENKIN_NKBAIGAKU;
            }

            else {

                hokenSyuruiBangoBetuKey1 = YOTEIRIRITUHENDOU_GONENRISAHAITOU_SITEITUUKA_NENKIN_TEIGAKUNK;
            }
        }
        else if (syohinHanteiKbn == GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR_20) {
            if (C_HknsyuruiNo.GAIKAINDEXNK_20_SISUU.eq(pHknsyuruiNo)) {
                hokenSyuruiBangoBetuKey1 = "";
            }
            else {
                if (pSyouhnCd.equals(GETHKNSYUNOKEYTOAISYOU_HANTEIYOUS[2]) ||
                    pSyouhnCd.equals(GETHKNSYUNOKEYTOAISYOU_HANTEIYOUS[3]) ||
                    pSyouhnCd.equals(GETHKNSYUNOKEYTOAISYOU_HANTEIYOUS[4]) ||
                    pSyouhnCd.equals(GETHKNSYUNOKEYTOAISYOU_HANTEIYOUS[5]) ||
                    pSyouhnCd.equals(GETHKNSYUNOKEYTOAISYOU_HANTEIYOUS[6]) ||
                    pSyouhnCd.equals(GETHKNSYUNOKEYTOAISYOU_HANTEIYOUS[7]) ||
                    pSyouhnCd.equals(GETHKNSYUNOKEYTOAISYOU_HANTEIYOUS[8]) ||
                    pSyouhnCd.equals(GETHKNSYUNOKEYTOAISYOU_HANTEIYOUS[9])) {
                    hokenSyuruiBangoBetuKey1 = GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR_20_TEIKI;
                }
                else {
                    hokenSyuruiBangoBetuKey1 = GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR_20_TEIRITU;
                }
            }
        }

        return hokenSyuruiBangoBetuKey1;
    }

    public String[] getSyouhinKeyToSaiteiPChk(String pSyouhnCd) {

        String[] syoHinBetuKey1s;

        int syohinHanteiKbn = hantei(pSyouhnCd);

        if (syohinHanteiKbn == YOTEIRIRITUHENDOU_GONENRISAHAITOU_SITEITUUKA_NENKIN) {
            syoHinBetuKey1s = new String[2];
            syoHinBetuKey1s[0] = YOTEIRIRITUHENDOU_GONENRISAHAITOU_SITEITUUKA_NENKIN_GETUBARAIKANSANP;
            syoHinBetuKey1s[1] = YOTEIRIRITUHENDOU_GONENRISAHAITOU_SITEITUUKA_NENKIN_ENKAPHARAIKOMISOUGAKU;
        }
        else {
            syoHinBetuKey1s = new String[1];
            syoHinBetuKey1s[0] = "";
        }

        return syoHinBetuKey1s;
    }


    public String[] getSyouhinKeyToSaiteiPJhChk(String pSyouhnCd) {

        String[] syoHinBetuKey1s =  new String[1];

        int syohinHanteiKbn = hantei(pSyouhnCd);

        if (syohinHanteiKbn == YOTEIRIRITUHENDOU_GONENRISAHAITOU_SITEITUUKA_NENKIN) {

            syoHinBetuKey1s[0] = YOTEIRIRITUHENDOU_GONENRISAHAITOU_SITEITUUKA_NENKIN_ENKAPHARAIKOMISOUGAKU;
        }

        else {
            syoHinBetuKey1s[0] = "";
        }

        return syoHinBetuKey1s;
    }

    public C_YouhiKbn hanteiItijibaraiPTuusanCheckYouhi(BM_SyouhnZokusei pSyouhnZokusei) {

        C_YouhiKbn youhiKbn = C_YouhiKbn.HUYOU;

        if (pSyouhnZokusei == null || BizUtil.isBlank(pSyouhnZokusei.getSyouhncd())) {

            return youhiKbn;
        }

        C_UmuKbn itijibrptsnumu = pSyouhnZokusei.getItijibrptsnumu();

        if (C_UmuKbn.ARI.eq(itijibrptsnumu)) {

            int syohinHanteiKbn = hantei(pSyouhnZokusei.getSyouhncd());

            if (syohinHanteiKbn == GONENRISAHAITOUSITEITUUKASYUUSIN_ITIJIBR) {
                youhiKbn = C_YouhiKbn.YOU;
            }
        }

        return youhiKbn;
    }

    public C_BlnktkumuKbn hanteiTuusanSousibouSKyuuKijun(BM_SyouhnZokusei pSyouhnZokusei) {

        C_BlnktkumuKbn oldkjnsiyouUmuKbn = C_BlnktkumuKbn.BLNK;

        if (pSyouhnZokusei == null || BizUtil.isBlank(pSyouhnZokusei.getSyouhncd())) {

            return oldkjnsiyouUmuKbn;
        }

        C_UmuKbn stsnumu = pSyouhnZokusei.getStsnumu();

        if (C_UmuKbn.ARI.eq(stsnumu)) {

            int syohinHanteiKbn = hantei(pSyouhnZokusei.getSyouhncd());

            if (syohinHanteiKbn == GONENRISAHAITOUSITEITUUKASYUUSIN_ITIJIBR ||
                syohinHanteiKbn == TEIKAIYAKUHRKN_GONENRISAHAITOU_SNTKTUUKA_TKBTSYUUSINHKN) {
                oldkjnsiyouUmuKbn = C_BlnktkumuKbn.ARI;
            }
            else {
                oldkjnsiyouUmuKbn = C_BlnktkumuKbn.NONE;
            }
        }

        return oldkjnsiyouUmuKbn;
    }

    public C_HaitouKeisanHousikiKbn getHaitouKeisanHousikiKbn(String pSyouhnCd) {

        C_HaitouKeisanHousikiKbn haitouKeisanHousikiKbn = C_HaitouKeisanHousikiKbn.BLNK;

        int henkoukubetuSyohinHanteiKbn = henkouKubetuHantei(pSyouhnCd);

        if (henkoukubetuSyohinHanteiKbn == HENKOUKUBETU_GONENRISAHAITOUSITEITUUKASYUUSIN_ITIJIBR_YENHENKOUMAE ||
            henkoukubetuSyohinHanteiKbn == HENKOUKUBETU_GONENRISAHAITOUSITEITUUKASYUUSIN_ITIJIBR_YENHENKOUGO ||
            henkoukubetuSyohinHanteiKbn == HENKOUKUBETU_GONENRISAHAITOUSITEITUUKASYUUSIN_ITIJIBR_19_YENHENKOUMAE ||
            henkoukubetuSyohinHanteiKbn == HENKOUKUBETU_TEIKAIYAKUHRKN_GONENRISAHAITOU_SNTKTUUKA_TKBTSYUUSINHKN) {

            haitouKeisanHousikiKbn = C_HaitouKeisanHousikiKbn.RATE;
        }
        else if (henkoukubetuSyohinHanteiKbn == HENKOUKUBETU_GONENRISAHAITOUSITEITUUKASYUUSIN_ITIJIBR_19_YENHENKOUGO ||
            henkoukubetuSyohinHanteiKbn == HENKOUKUBETU_GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR_YENHENKOUMAE ||
            henkoukubetuSyohinHanteiKbn == HENKOUKUBETU_GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR_YENHENKOUGO ||
            henkoukubetuSyohinHanteiKbn == HENKOUKUBETU_GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR_20_YENHENKOUMAE ||
            henkoukubetuSyohinHanteiKbn == HENKOUKUBETU_GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR_20_YENHENKOUGO ||
            henkoukubetuSyohinHanteiKbn == HENKOUKUBETU_YOTEIRIRITUHENDOU_GONENRISAHAITOU_SITEITUUKA_NENKIN) {

            haitouKeisanHousikiKbn = C_HaitouKeisanHousikiKbn.JITUGAKU;
        }

        return haitouKeisanHousikiKbn;
    }

    public C_KaiyakuKeisanHousikiKbn getKaiyakuKeisanHousikiKbn(String pSyouhnCd) {

        C_KaiyakuKeisanHousikiKbn kaiyakuKeisanHousikiKbn = C_KaiyakuKeisanHousikiKbn.BLNK;

        int henkoukubetuSyohinHanteiKbn = henkouKubetuHantei(pSyouhnCd);

        if (henkoukubetuSyohinHanteiKbn == HENKOUKUBETU_TEIKAIYAKUHRKN_GONENRISAHAITOU_SNTKTUUKA_TKBTSYUUSINHKN) {

            kaiyakuKeisanHousikiKbn = C_KaiyakuKeisanHousikiKbn.RATE;
        }

        return kaiyakuKeisanHousikiKbn;
    }

    public boolean getYendthnkSyouhn(String pSyouhnCd) {

        int henkoukubetuSyohinHanteiKbn = henkouKubetuHantei(pSyouhnCd);

        if (henkoukubetuSyohinHanteiKbn == HENKOUKUBETU_GONENRISAHAITOUSITEITUUKASYUUSIN_ITIJIBR_YENHENKOUGO ||
            henkoukubetuSyohinHanteiKbn == HENKOUKUBETU_GONENRISAHAITOUSITEITUUKASYUUSIN_ITIJIBR_19_YENHENKOUGO ||
            henkoukubetuSyohinHanteiKbn == HENKOUKUBETU_GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR_YENHENKOUGO ||
            henkoukubetuSyohinHanteiKbn == HENKOUKUBETU_GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR_20_YENHENKOUGO) {

            return true;
        }

        return false;
    }
}
