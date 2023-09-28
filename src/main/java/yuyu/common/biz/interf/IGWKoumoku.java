package yuyu.common.biz.interf;

/**
 * 業務共通 インターフェイス ＧＷデータ項目定義
 */
public interface IGWKoumoku {

    public static final String GW_TSRYDATAKBN_KKHD              = "0";

    public static final String GW_TSRYDATAKBN_KKHTKD            = "1";

    public static final String GW_TSRYDATAKBN_SKHD              = "2";

    public static final String GW_TSRYDATAKBN_SKHTKD            = "3";

    public static final String GW_TSRYDATATYPE_SHR_MS_KYK       = "100";

    public static final String GW_TSRYDATATYPE_SHR_MS_SYOUHN    = "110";

    public static final String GW_TSRYDATATYPE_SHR_MS_AG        = "120";

    public static final String GW_TSRYDATATYPE_SHR_MS_ETC       = "190";

    public static final String GW_TSRYDATATYPE_SHR_GASSAN       = "101";

    public static final String GW_TSRYDATATYPE_TSHR_MS_KYK      = "200";

    public static final String GW_TSRYDATATYPE_TSHR_MS_SYOUHN   = "210";

    public static final String GW_TSRYDATATYPE_TSHR_MS_AG       = "220";

    public static final String GW_TSRYDATATYPE_TSHR_MS_ETC      = "290";

    public static final String GW_TSRYDATATYPE_TSHR_GASSAN      = "201";

    public static final String GW_TSRYDATATYPE_KRKS_MS_KYK      = "300";

    public static final String GW_TSRYDATATYPE_KRKS_MS_SYOUHN   = "310";

    public static final String GW_TSRYDATATYPE_KRKS_MS_AG       = "320";

    public static final String GW_TSRYDATATYPE_KRKS_MS_ETC      = "390";

    public static final String GW_TSRYDATATYPE_KRKS_GASSAN      = "301";

    public static final String GW_TSRYDATATYPE_SHRSOUGK         = "901";

    public static final String GW_HKNTYPE_SEIHO                 = "AA";

    public static final String GW_HKNKAISYACD_TOUSYA            = "JF";

    public static final String GW_PTMTTKNGKUNIT_AGBUNMAE        = "0";

    public static final String GW_PTMTTKNGKUNIT_AGBUNATO        = "1";

    public static final String GW_GOUKEIPUNITCD_YEN             = "0";

    public static final String GW_GOUKEIPUNITCD_DOLLAR          = "1";

    public static final String GW_GOUKEIPUNITCD_EURO            = "2";

    public static final String GW_TSRYSKYKJYJIYU_SKYK           = "01";

    public static final String GW_TSRYSKYKJYJIYU_KEIZK          = "02";

    public static final String GW_TSRYSKYKJYJIYU_KAIYK          = "21";

    public static final String GW_TSRYSKYKJYJIYU_CLOFF          = "22";

    public static final String GW_TSRYSKYKJYJIYU_SKKOU          = "24";

    public static final String GW_TSRYSKYKJYJIYU_KJKYKTRKS      = "25";

    public static final String GW_TSRYSKYKJYJIYU_MUKOU          = "28";

    public static final String GW_TSRYSKYKJYJIYU_HUKUGEN        = "29";

    public static final String GW_TSRYSKYKJYJIYU_GENGAKU        = "31";

    public static final String GW_TSRYSKYKJYJIYU_ZOUGAKU        = "33";

    public static final String GW_TSRYSKYKJYJIYU_TOKUYAKUMUKOU  = "38";

    public static final String GW_TSRYSKYKJYJIYU_GASSN_SHR      = "81";

    public static final String GW_TSRYSKYKJYJIYU_GASSN_SEIKYUU  = "82";

    public static final String GW_TSRYSKYKJYJIYU_GASSN_KRKS     = "83";

    public static final String GW_TSRYSKYKJYJIYU_GASSN          = "89";

    public static final String GW_TSRYSKYKJYJIYU_ETC            = "99";

    public static final String GW_TSRYSHRTYPE_LJI               = "01";

    public static final String GW_TSRYSHRTYPE_HEIJYUN           = "02";

    public static final String GW_TSRYSHRTYPE_ETC               = "99";

    public static final String GW_SHRHOU_ITIJI                  = "01";

    public static final String GW_SHRHOU_TUKI                   = "02";

    public static final String GW_SHRHOU_SHIHANKI               = "03";

    public static final String GW_SHRHOU_HALFY                  = "04";

    public static final String GW_SHRHOU_NEN                    = "05";

    public static final String GW_SHRHOU_ZUIJI                  = "06";

    public static final String GW_SHRHOU_ETC                    = "99";

    public static final String GW_PHARAIKATA_ITIJI              = "0";

    public static final String GW_PHARAIKATA_NEN                = "1";

    public static final String GW_PHARAIKATA_HALFY              = "2";

    public static final String GW_PHARAIKATA_TUKI               = "3";

    public static final String GW_PHARAIKATA_ETC                = "9";

    public static final String GW_SYOHIZEITYPE_UTI              = "0";

    public static final String GW_SYOHIZEITYPE_SOTO             = "1";

    public static final String GW_TSRYGKUNIT_AGBUNMAE           = "0";

    public static final String GW_TSRYGKUNIT_AGBUNATO           = "1";

    public static final String GW_TSRYUNITCD_YEN                = "0";

    public static final String GW_TSRYUNITCD_DOLLAR             = "1";

    public static final String GW_TSRYUNITCD_EURO               = "2";

    public static final String GW_FORMATKBN_HANYOUTSRY          = "N";

    public static final String GW_HKNSYURUI_SYSN                = "01";

    public static final String GW_HKNSYURUI_TEIKI               = "02";

    public static final String GW_HKNSYURUI_YOUROU              = "03";

    public static final String GW_HKNSYURUI_TYOTIKU             = "10";

    public static final String GW_HKNSYURUI_HENGK               = "52";

    public static final String GW_HKNSYURUI_NENKIN              = "55";

    public static final String GW_HKNSYURUI_IRYOU               = "70";

    public static final String GW_HKNSYURUI_UNIT                = "71";

    public static final String GW_HKNSYURUI_OTHER               = "99";

    public static final String GW_HUGOU_PLUS                    = "0";

    public static final String GW_HUGOU_MINUS                   = "1";

    public static final String GW_DATASYURUI_SKEI               = "0";

    public static final String GW_DATASYURUI_HENKOU             = "1";

    public static final String GW_DATASYURUI_KAIYAKU            = "2";

    public static final String GW_DATASYURUI_SKEITK             = "3";

    public static final String GW_TYOUBOKBN_SEIHO               = "A";

    public static final String GW_HRKHOU_ITIJI                  = "1";

    public static final String GW_HRKHOU_NEN                    = "5";

    public static final String GW_HRKHOU_HALFY                  = "6";

    public static final String GW_HRKHOU_TUKI                   = "8";

    public static final String GW_SYUKINKBN_KAKIIGAI            = "1";

    public static final String GW_SYUKINKBN_KZ                  = "2";

    public static final String GW_BNKAISUU_ITIJI                = "00";

    public static final String GW_BNKAISUU_NEN                  = "01";

    public static final String GW_BNKAISUU_HALFY                = "02";

    public static final String GW_BNKAISUU_TUKI                 = "12";

    public static final String GW_KYOUHOCD_TANDOKU              = "0";

    public static final String GW_DAIBUNCD_TANDOKU              = "0";

    public static final String GW_DAIBUNCD_DRTENBUN             = "1";

    public static final String GW_SYUMOKUGRPKBN_SEIHO           = "L";

    public static final String GW_JIKOKYK_JIKOIGAI              = "0";

    public static final String GW_JIKOKYK_JIKO                  = "1";

    public static final String GW_BNSYURUI_ITIJI                = "00";

    public static final String GW_BNSYURUI_TUKI                 = "01";

    public static final String GW_BNSYURUI_HALFY                = "14";

    public static final String GW_BNSYURUI_NEN                  = "15";

    public static final String GW_HRKYMD_KZ                     = "BK";

    public static final String GW_HRKYMD_ITIJI                  = "00";

    public static final String GW_SINKEIZKKBN_SONOTA            = "0";

    public static final String GW_SINKEIZKKBN_SKEI              = "1";

    public static final String GW_CREDITCARDSHRKBN_CREDIT       = "1";

    public static final String GW_CREDITCARDSHRKBN_NOUSE        = " ";

    public static final String GW_FSTPKZHURIKBN_KZ              = "1";

    public static final String GW_FSTPKZHURIKBN_NOUSE           = " ";

    public static final String GW_IDOURIYUU_SKEI                = "01";

    public static final String GW_IDOURIYUU_KAIYAKU             = "21";

    public static final String GW_IDOURIYUU_COOLINGOFF          = "22";

    public static final String GW_IDOURIYUU_SIKKOU              = "23";

    public static final String GW_IDOURIYUU_TORIKESI            = "24";

    public static final String GW_IDOURIYUU_SIBOU               = "25";

    public static final String GW_IDOURIYUU_HUKUGEN             = "29";

    public static final String GW_IDOURIYUU_GENGAKU             = "31";

    public static final String GW_IDOURIYUU_HRKHOUHENKOU        = "42";

    public static final String GW_IDOURIYUU_ZOKUSEIHENKOU       = "43";

    public static final String GW_IDOURIYUU_SONOTA              = "99";

    public static final String GW_HHKNSEI_MALE                  = "1";

    public static final String GW_HHKNSEI_FEMALE                = "2";

    public static final String GW_HHKNTDK_HONNIN                = "01";

    public static final String GW_HHKNTDK_HGU                   = "02";

    public static final String GW_HHKNTDK_OYA                   = "03";

    public static final String GW_HHKNTDK_KO                    = "04";

    public static final String GW_HHKNTDK_KDSM                  = "05";

    public static final String GW_HHKNTDK_SHB                   = "06";

    public static final String GW_HHKNTDK_KYN                   = "11";

    public static final String GW_HHKNTDK_HTSZK                 = "90";

    public static final String GW_HHKNTDK_SONOTA                = "99";

    public static final String GW_HRKKEIRO_KZ                   = "1";

    public static final String GW_HRKKEIRO_CREDIT               = "6";

    public static final String GW_HRKKEIRO_DANTAI               = "9";

    public static final String GW_HRKKEIRO_NOUSE                = " ";

    public static final String GW_HAITOUKBN_MUHAI               = "1";

    public static final String GW_HAITOUKBN_JYUNYUUHAI          = "2";

    public static final String GW_HAITOUKBN_YUUHAI              = "3";

    public static final String GW_HAITOUKBN_NOUSE               = " ";

    public static final String GW_HRKZUMIENTYOUHYOUJI_NOUSE     = " ";

    public static final String GW_ZOKUSEIHENKOUKBN_FIRST        = " ";

    public static final String GW_ZOKUSEIHENKOUKBN_KYKNM        = "1";

    public static final String GW_ZOKUSEIHENKOUKBN_KYKADR       = "2";

    public static final String GW_ZOKUSEIHENKOUKBN_HHKNNM       = "3";

    public static final String GW_ZOKUSEIHENKOUKBN_HHKNSEI      = "4";

    public static final String GW_ZOKUSEIHENKOUKBN_UKT          = "5";

    public static final String GW_ZOKUSEIHENKOUKBN_SONOTA       = "9";

    public static final String GW_NKSHRKKNKBN_NKIGAI            = " ";

    public static final String GW_TOKUTAIUMU_TKJY               = "1";

    public static final String GW_TOKUTAIUMU_SONOTA             = " ";

    public static final String GW_TKTYUUTOHUKA_SONOTA           = " ";

    public static final String GW_SINSAKBN_KOKUTISYO            = "1";

    public static final String GW_SINSAKBN_HUTUUSYOKUTAKUI      = "3";

    public static final String GW_SINSAKBN_KENKOUSYOUMEISYO     = "4";

    public static final String GW_SINSAKBN_NINGENDOKKU          = "5";

    public static final String GW_SINSAKBN_KENKOUSINDANSYO      = "9";

    public static final String GW_ZEISEITEKIKAKU_SONOTA         = " ";

    public static final String GW_LIVINGNEEDS_SONOTA            = " ";

    public static final String GW_HKNKKNKBN_NEN                 = "1";

    public static final String GW_HKNKKNKBN_SAI                 = "2";

    public static final String GW_HKNKKNKBN_SYSN                = "3";

    public static final String GW_HRKKKNKBN_NEN                 = "1";

    public static final String GW_HRKKKNKBN_SAI                 = "2";

    public static final String GW_HRKKKNKBN_SYSN                = "3";

    public static final String GW_HRKKKNKBN_SONOTA              = " ";

    public static final String GW_KZSYURUI_TOUZA                = "0";

    public static final String GW_KZSYURUI_HUTUU                = "1";

    public static final String GW_KZSYURUI_NOUSE                = " ";

    public static final String GW_SANSYOUKENGENKBN_NOUSE        = " ";

    public static final String GW_DATASYUBETUCD_TEIKI           = "06";

    public static final String GW_DATASYUBETUCD_SYOKI           = "96";

    public static final String GW_HJNKOJINKBN_HOUJIN            = "1";

    public static final String GW_HJNKOJINKBN_KOJIN             = "2";

    public static final String GW_KYKSEI_MALE                   = "1";

    public static final String GW_KYKSEI_FEMALE                 = "2";

    public static final String GW_KYKSEI_SONOTA                 = " ";

    public static final String GW_CIFCDKANRI_GINKOU             = "1";

    public static final String GW_CIFCDKANRI_SITEN              = "2";

    public static final String GW_MISYUUDATAKBN_HASSEI          = "0";

    public static final String GW_MISYUUDATAKBN_TORIKESI        = "9";

    public static final String GW_MISYUUTATEKAEKBN_MISYUU       = "1";

    public static final String GW_MISYUUTATEKAEKBN_TATEKAE      = "2";

    public static final String GW_MISYUUJIYUU_ZANDAKAHUSOKU     = "01";

    public static final String GW_MISYUUJIYUU_KOUZAHUMEI        = "02";

    public static final String GW_MISYUUJIYUU_SONOTA            = "99";

    public static final String GW_SHIFTCODE_BLANK               = "0";

    public static final String GW_SHIFTCODE_JISKANJI            = "1";

    public static final String GW_DRTENTUHANTK_ETC              = "0";

    public static final String GW_DRTENTUHANTK_AG               = "1";

    public static final String GW_DRTENTUHANTK_BANK             = "2";

    public static final String GW_DRTENTUHANTK_INTRANET         = "3";

    public static final String GW_DRTENTUHANTK_INTERNET         = "4";


}