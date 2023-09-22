package yuyu.common.sinkeiyaku.skcommon;

/**
 * 新契約 新契約共通 新契約共通項目定義
 */
public interface ISkCommonKoumoku {

    public static final String SUBSYSTEMID_SINKEIYAKU                         = "sinkeiyaku";

    public static final String JIMUTETUZUKICD_SKMAINDAIRITEN                  = "skmaindairiten";

    public static final String JIMUTETUZUKICD_SKINPUTMOS                      = "skinputmos";

    public static final String JIMUTETUZUKICD_SKINPUTKOKUTI                   = "skinputkokuti";

    public static final String JIMUTETUZUKICD_SKTENKEN                        = "sktenken";

    public static final String JIMUTETUZUKICD_SKKANKYOU                       = "skkankyou";

    public static final String JIMUTETUZUKICD_SKIMU                           = "skimu";

    public static final String JIMUTETUZUKICD_SKHUBITOUROKU                   = "skhubitouroku";

    public static final String JIMUTETUZUKICD_SKHUBIKAISYOU                   = "skhubikaisyou";

    public static final String JIMUTETUZUKICD_SKKEIYAKUKAKUNIN                = "skkeiyakukakunin";

    public static final String JIMUTETUZUKICD_SKHENKIN                        = "skhenkin";

    public static final String JIMUTETUZUKICD_SKTORIKESI                      = "sktorikesi";

    public static final String NODEID_MOUSIKOMISYOTORIKOMI                    = "state-mousikomisyotorikomi";

    public static final String NODEID_MOUSIKOMISYONYUURYOKU                   = "state-mousikomisyonyuuryoku";

    public static final String NODEID_SYORUINYUURYOKU                         = "state-syoruinyuuryoku";

    public static final String NODEID_MOUSIKOMITENKEN                         = "state-mousikomitenken";

    public static final String NODEID_KETTEI                                  = "state-kettei";

    public static final String NODEID_SATEI                                   = "state-satei";

    public static final String NODEID_SEIRITUHORYUUHUBI                       = "state-seirituhoryuuhubi";

    public static final String NODEID_SEIRITU                                 = "state-seiritu";

    public static final String NODEID_KOUTEIKAISI                             = "state-kouteikaisi";

    public static final String NODEID_KOUTEIKANRYOU                           = "state-kouteikanryou";

    public static final String NODEID_MOSNYUURYOKU_1JI                        = "mousikomisyo_1ji";

    public static final String NODEID_MOSNYUURYOKU_2JI                        = "mousikomisyo_2ji";

    public static final String NODEID_MOSNYUURYOKU_3JI                        = "mousikomisyo_3ji";

    public static final String NODEID_MOSNYUURYOKU_UPD                        = "mousikomisyo_upd";

    public static final String NODEID_MOSNYUURYOKU_UPD_SYOUKAI                = "mousikomisyo_syoukai";

    public static final String NODEID_MOSNYUURYOKU_INS_UPD                    = "mousikomisyo_ins_upd";

    public static final String NODEID_KOKUTISYONYUURYOKU_1JI                  = "kokutisyo_1ji";

    public static final String NODEID_KOKUTISYONYUURYOKU_2JI                  = "kokutisyo_2ji";

    public static final String NODEID_KOKUTISYONYUURYOKU_3JI                  = "kokutisyo_3ji";

    public static final String NODEID_KOKUTISYONYUURYOKU_UPD                  = "kokutisyo_upd";

    public static final String NODEID_KOKUTISYONYUURYOKU_DEL                  = "kokutisyo_del";

    public static final String NODEID_MOUSIKOMITENKEN_1JI                     = "mostenken_1ji";

    public static final String NODEID_MOUSIKOMITENKEN_2JI                     = "mostenken_2ji";

    public static final String NODEID_MOUSIKOMITENKEN_HUBI                    = "mostenken_hubi";

    public static final String NODEID_HUBITOUROKU                             = "hubitouroku";

    public static final String NODEID_SKHUBINAIYOUKAKHASSIN                   = "hubihassin";

    public static final String NODEID_SKHUBIKAITOUMATI                        = "hubikaitoumati";

    public static final String NODEID_SKHUBIKAISYOU                           = "hubikaisyou";

    public static final String NODEID_KANKYOUSATEI_1JI                        = "kankyousatei_1ji";

    public static final String NODEID_KANKYOUSATEI_2JIA                       = "kankyousatei_2jia";

    public static final String NODEID_KANKYOUSATEI_2JIB                       = "kankyousatei_2jib";

    public static final String NODEID_IMUSATEI_KANI_UW                        = "imusatei_kani_uw";

    public static final String NODEID_IMUSATEI_KANI_MD                        = "imusatei_kani_md";

    public static final String NODEID_KYKKAKUNINIRAI                          = "kykkakuninirai";

    public static final String NODEID_KYKKAKUNINKEKKA                         = "kykkakuninkekka";

    public static final String NODEID_MOUSIKOMITORIKESI                       = "mostorikesi";

    public static final String NODEID_HENKINKIBOU                             = "henkinkibou";

    public static final String NODEID_HENKINNYUURYOKU                         = "henkinnyuuryoku";

    public static final String TYOUHYOUMEI_HUBITUUTI                          = "不備通知書";

    public static final String TYOUHYOUMEI_KYKHUSEIRITUTUUTISYO               = "契約不成立通知書";

    public static final String TYOUHYOUMEI_YUUKOUKKNKYKLIST                   = "有効期間経過契約リスト";

    public static final String TYOUHYOUID_MISLIST                             = "新契約ミスリスト";

    public static final String TYOUHYOUMEI_HENKINIRAISYO                      = "返金依頼書";

    public static final String TYOUHYOUMEI_HENKINMISYORILIST                  = "返金未処理リスト";

    public static final String TYOUHYOUMEI_HENKINTUUTI                        = "返金通知";

    public static final String VRFKINOUKBN_MOUSIKOMISYO                       = "MOUSIKOMISYO";

    public static final String VRFKINOUKBN_KOKUTISYO                          = "KOKUTISYO";

    public static final String VRFKINOUKBN_KOUZAJYOUHOU                       = "KOUZAJYOUHOU";

    public static final String VRFKINOUKBN_CREDITCARDJYOUHOU                  = "CREDITCARDJYOUHOU";

    public static final String AUTHORIYUUKOUKIKANNISSUU                       = "30";

    public static final String KETTEISYACD_KYOUYOU                            = "KYOUYOU";

    public static final String PALKETSYACD_SISYAKETSYA                        = "98";

    public static final String PALKETSYACD_KIKAIKETTEI                        = "99";

    public static final String CHOHYO_JOHO_DATA_EXT                           = ".dat";

    public static final String ZIP_EXT                                        = ".zip";

    public static final String HALF_SPACE                                     = " ";

    public static final String KAIGYOU_CD                                     = "\n";

    public static final int IMAGE_SIZE_LIMIT                                  = 1000000;

    public static final String IMG_FILE_NAME                                  = "PDF_NAME";

    public static final String MOS_NO                                         = "MOS_NO";

    public static final String TYOHYOU_SAKUSEI_KBN                            = "TYOHYOU_SAKUSEI_KBN";
}