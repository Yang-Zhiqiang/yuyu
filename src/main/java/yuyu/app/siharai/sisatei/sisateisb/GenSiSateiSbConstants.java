package yuyu.app.siharai.sisatei.sisateisb;

import jp.co.slcs.swak.bizinfr.configuration.Item;
import jp.co.slcs.swak.bizinfr.configuration.Item.ErrorMsgKbn;

/**
 * （死亡）査定 画面項目ID定義のベースクラスです。<br />
 * このソースはツールによる自動生成で、画面項目定義の変更に連動して更新されます。
 * 手書きコードを加えてはいけません。
 */
public class GenSiSateiSbConstants {

    public static final int PAGENO_INIT                              = 1;

    public static final int PAGENO_INPUTCONTENTS_SATEI1              = 1;

    public static final int PAGENO_INPUTCORRECT                      = 2;

    public static final int PAGENO_CONFIRM_SATEI1                    = 3;

    public static final int PAGENO_RESULT_SATEI1                     = 4;

    public static final int PAGENO_INPUTCONTENTS_SATEI2              = 5;

    public static final int PAGENO_CONFIRM_SATEI2                    = 6;

    public static final int PAGENO_RESULT_SATEI2                     = 7;

    public static final int PAGENO_INPUTCONTENTS_SATEI3              = 8;

    public static final int PAGENO_CONFIRM_SATEI3                    = 9;

    public static final int PAGENO_RESULT_SATEI3                     = 10;

    public static final int PAGENO_INPUTCONTENTS_SATEI4              = 11;

    public static final int PAGENO_CONFIRM_SATEI4                    = 12;

    public static final int PAGENO_RESULT_SATEI4                     = 13;

    public static final int PAGENO_INPUTCONTENTS_TETUZUKI_SATEIHUYOU = 14;

    public static final int PAGENO_CONFIRM_TETUZUKI_SATEIHUYOU       = 15;

    public static final int PAGENO_RESULT_TETUZUKI_SATEIHUYOU        = 16;

    public static final int PAGENO_INPUTCONTENTS_TETUZUKI_SATEIYOU   = 17;

    public static final int PAGENO_CONFIRM_TETUZUKI_SATEIYOU         = 18;

    public static final int PAGENO_RESULT_TETUZUKI_SATEIYOU          = 19;

    public static final int PAGENO_INPUTCONTENTS_SYOUNIN_SATEIHUYOU  = 20;

    public static final int PAGENO_CONFIRM_SYOUNIN_SATEIHUYOU        = 21;

    public static final int PAGENO_RESULT_SYOUNIN_SATEIHUYOU         = 22;

    public static final int PAGENO_INPUTCONTENTS_SYOUNIN_SATEIYOU    = 23;

    public static final int PAGENO_CONFIRM_SYOUNIN_SATEIYOU          = 24;

    public static final int PAGENO_RESULT_SYOUNIN_SATEIYOU           = 25;

    public static final int PAGENO_INPUTCONTENTS_SESSYOU             = 26;

    public static final int PAGENO_CONFIRM_SESSYOU                   = 27;

    public static final int PAGENO_RESULT_SESSYOU                    = 28;

    public static final int PAGENO_INPUTCONTENTS_KAIKETU             = 29;

    public static final int PAGENO_CONFIRM_KAIKETU                   = 30;

    public static final int PAGENO_RESULT_KAIKETU                    = 31;

    public static final int PAGENO_INPUTCONTENTS_KAKUNIN_HUBI        = 32;

    public static final int PAGENO_CONFIRM_KAKUNIN_HUBI              = 33;

    public static final int PAGENO_RESULT_KAKUNIN_HUBI               = 34;

    static final String FORWARDNAME_INIT                              = "init";

    static final String FORWARDNAME_INPUTCONTENTS_SATEI1              = "InputContents_satei1";

    static final String FORWARDNAME_INPUTCORRECT                      = "InputCorrect";

    static final String FORWARDNAME_CONFIRM_SATEI1                    = "Confirm_satei1";

    static final String FORWARDNAME_RESULT_SATEI1                     = "Result_satei1";

    static final String FORWARDNAME_INPUTCONTENTS_SATEI2              = "InputContents_satei2";

    static final String FORWARDNAME_CONFIRM_SATEI2                    = "Confirm_satei2";

    static final String FORWARDNAME_RESULT_SATEI2                     = "Result_satei2";

    static final String FORWARDNAME_INPUTCONTENTS_SATEI3              = "InputContents_satei3";

    static final String FORWARDNAME_CONFIRM_SATEI3                    = "Confirm_satei3";

    static final String FORWARDNAME_RESULT_SATEI3                     = "Result_satei3";

    static final String FORWARDNAME_INPUTCONTENTS_SATEI4              = "InputContents_satei4";

    static final String FORWARDNAME_CONFIRM_SATEI4                    = "Confirm_satei4";

    static final String FORWARDNAME_RESULT_SATEI4                     = "Result_satei4";

    static final String FORWARDNAME_INPUTCONTENTS_TETUZUKI_SATEIHUYOU = "InputContents_tetuzuki_sateihuyou";

    static final String FORWARDNAME_CONFIRM_TETUZUKI_SATEIHUYOU       = "Confirm_tetuzuki_sateihuyou";

    static final String FORWARDNAME_RESULT_TETUZUKI_SATEIHUYOU        = "Result_tetuzuki_sateihuyou";

    static final String FORWARDNAME_INPUTCONTENTS_TETUZUKI_SATEIYOU   = "InputContents_tetuzuki_sateiyou";

    static final String FORWARDNAME_CONFIRM_TETUZUKI_SATEIYOU         = "Confirm_tetuzuki_sateiyou";

    static final String FORWARDNAME_RESULT_TETUZUKI_SATEIYOU          = "Result_tetuzuki_sateiyou";

    static final String FORWARDNAME_INPUTCONTENTS_SYOUNIN_SATEIHUYOU  = "InputContents_syounin_sateihuyou";

    static final String FORWARDNAME_CONFIRM_SYOUNIN_SATEIHUYOU        = "Confirm_syounin_sateihuyou";

    static final String FORWARDNAME_RESULT_SYOUNIN_SATEIHUYOU         = "Result_syounin_sateihuyou";

    static final String FORWARDNAME_INPUTCONTENTS_SYOUNIN_SATEIYOU    = "InputContents_syounin_sateiyou";

    static final String FORWARDNAME_CONFIRM_SYOUNIN_SATEIYOU          = "Confirm_syounin_sateiyou";

    static final String FORWARDNAME_RESULT_SYOUNIN_SATEIYOU           = "Result_syounin_sateiyou";

    static final String FORWARDNAME_INPUTCONTENTS_SESSYOU             = "InputContents_sessyou";

    static final String FORWARDNAME_CONFIRM_SESSYOU                   = "Confirm_sessyou";

    static final String FORWARDNAME_RESULT_SESSYOU                    = "Result_sessyou";

    static final String FORWARDNAME_INPUTCONTENTS_KAIKETU             = "InputContents_kaiketu";

    static final String FORWARDNAME_CONFIRM_KAIKETU                   = "Confirm_kaiketu";

    static final String FORWARDNAME_RESULT_KAIKETU                    = "Result_kaiketu";

    static final String FORWARDNAME_INPUTCONTENTS_KAKUNIN_HUBI        = "InputContents_kakunin_hubi";

    static final String FORWARDNAME_CONFIRM_KAKUNIN_HUBI              = "Confirm_kakunin_hubi";

    static final String FORWARDNAME_RESULT_KAKUNIN_HUBI               = "Result_kakunin_hubi";

    static final String FORWARDNAME_BACKTOWORKLIST                    = "backToWorkList";

    static final Item DDID_HEADERBUTTONS_TOJIRUBTN = new Item("sisateisb", "headerButtons", "tojiruBtn", null, ErrorMsgKbn.DD);

    static final Item DDID_HEADERBUTTONS_TOJIRUBTNBYPOPUP = new Item("sisateisb", "headerButtons", "tojiruBtnByPopup", null, ErrorMsgKbn.DD);

    static final Item DDID_HEADERBUTTONS2_HBTRBTN = new Item("sisateisb", "headerButtons2", "hbtrbtn", null, ErrorMsgKbn.DD);

    static final Item DDID_HEADERBUTTONS2_HKNGKSISANBTN = new Item("sisateisb", "headerButtons2", "hkngksisanbtn", null, ErrorMsgKbn.DD);

    static final Item DDID_KOUTEIINFO_VKTIFDISPJIMUTETUZUKINM = new Item("sisateisb", "kouteiinfo", "vktifdispjimutetuzukinm", null, ErrorMsgKbn.DD);

    static final Item DDID_KOUTEIINFO_VKTIFDISPTASKNM = new Item("sisateisb", "kouteiinfo", "vktifdisptasknm", null, ErrorMsgKbn.DD);

    static final Item DDID_HKTSKKIHONINFO_SYONO = new Item("sisateisb", "hktskKihonInfo", "syono", null, ErrorMsgKbn.DD);

    static final Item DDID_HKTSKKIHONINFO_SYOUKAIBTN = new Item("sisateisb", "hktskKihonInfo", "syoukaibtn", null, ErrorMsgKbn.DD);

    static final Item DDID_HKTSKKIHONINFO_SKNO = new Item("sisateisb", "hktskKihonInfo", "skno", null, ErrorMsgKbn.DD);

    static final Item DDID_HKTSKKIHONINFO_KOUTEIKANRIID = new Item("sisateisb", "hktskKihonInfo", "kouteikanriid", null, ErrorMsgKbn.DD);

    static final Item DDID_HKTSKKIHONINFO_KOUTEILOCKKEY = new Item("sisateisb", "hktskKihonInfo", "kouteilockkey", null, ErrorMsgKbn.DD);

    static final Item DDID_SYORUIUKEYMDINFO_SYORUIUKEYMD = new Item("sisateisb", "syoruiukeymdInfo", "syoruiukeymd", null, ErrorMsgKbn.DD);

    static final Item DDID_SYORUIUKEYMDINFO_HUBIKANRYOUYMD = new Item("sisateisb", "syoruiukeymdInfo", "hubikanryouymd", null, ErrorMsgKbn.DD);

    static final Item DDID_VIEWSATEIKAISOUYOUHISIBOUINFO_SATEIKAKSAIGAIKANOUSEI = new Item("sisateisb", "viewSateikaisouyouhiSibouInfo", "sateikaksaigaikanousei", null, ErrorMsgKbn.DISP);

    static final Item DDID_VIEWSATEIKAISOUYOUHISIBOUINFO_SATEIKAKSAIGAIKANOUSEIKBN = new Item("sisateisb", "viewSateikaisouyouhiSibouInfo", "sateikaksaigaikanouseikbn", null, ErrorMsgKbn.DD);

    static final Item DDID_VIEWSATEIKAISOUYOUHISIBOUINFO_SATEIKAKKAIGAISB = new Item("sisateisb", "viewSateikaisouyouhiSibouInfo", "sateikakkaigaisb", null, ErrorMsgKbn.DISP);

    static final Item DDID_VIEWSATEIKAISOUYOUHISIBOUINFO_SATEIKAKKAIGAISBKBN = new Item("sisateisb", "viewSateikaisouyouhiSibouInfo", "sateikakkaigaisbkbn", null, ErrorMsgKbn.DD);

    static final Item DDID_VIEWSATEIKAISOUYOUHISIBOUINFO_SATEIKAKHUSYOUSI = new Item("sisateisb", "viewSateikaisouyouhiSibouInfo", "sateikakhusyousi", null, ErrorMsgKbn.DISP);

    static final Item DDID_VIEWSATEIKAISOUYOUHISIBOUINFO_SATEIKAKHUSYOUSIKBN = new Item("sisateisb", "viewSateikaisouyouhiSibouInfo", "sateikakhusyousikbn", null, ErrorMsgKbn.DD);

    static final Item DDID_VIEWSATEIKAISOUYOUHISIBOUINFO_SATEIKAKMEIGIHNK = new Item("sisateisb", "viewSateikaisouyouhiSibouInfo", "sateikakmeigihnk", null, ErrorMsgKbn.DISP);

    static final Item DDID_VIEWSATEIKAISOUYOUHISIBOUINFO_SATEIKAKMEIGIHNKKBN = new Item("sisateisb", "viewSateikaisouyouhiSibouInfo", "sateikakmeigihnkkbn", null, ErrorMsgKbn.DD);

    static final Item DDID_VIEWSKJYOUHOUINFO_SEIKYUUSYAKBN = new Item("sisateisb", "viewSkjyouhouInfo", "seikyuusyakbn", null, ErrorMsgKbn.DD);

    static final Item DDID_VIEWSKJYOUHOUINFO_SIHONNINKAKNINKBN = new Item("sisateisb", "viewSkjyouhouInfo", "sihonninkakninkbn", null, ErrorMsgKbn.DD);

    static final Item DDID_VIEWSKJYOUHOUINFO_SEIKYUUSYASEIYMD = new Item("sisateisb", "viewSkjyouhouInfo", "seikyuusyaseiymd", null, ErrorMsgKbn.DD);

    static final Item DDID_VIEWSKJYOUHOUINFO_SEIKYUUSYASEI = new Item("sisateisb", "viewSkjyouhouInfo", "seikyuusyasei", null, ErrorMsgKbn.DD);

    static final Item DDID_VIEWSKJYOUHOUINFO_SEIKYUUSYANMKN = new Item("sisateisb", "viewSkjyouhouInfo", "seikyuusyanmkn", null, ErrorMsgKbn.ERROR);

    static final Item DDID_VIEWSKJYOUHOUINFO_SEIKYUUSYANMKJ = new Item("sisateisb", "viewSkjyouhouInfo", "seikyuusyanmkj", null, ErrorMsgKbn.ERROR);

    static final Item DDID_VIEWSAIKENINFO_SAIKENNMKJ = new Item("sisateisb", "viewSaikenInfo", "saikennmkj", null, ErrorMsgKbn.ERROR);

    static final Item DDID_VIEWSAIKENINFO1_SAIKENNYNO = new Item("sisateisb", "viewSaikenInfo1", "saikennyno", null, ErrorMsgKbn.ERROR);

    static final Item DDID_VIEWSAIKENINFO1_SAIKENADR1KJ = new Item("sisateisb", "viewSaikenInfo1", "saikenadr1kj", null, ErrorMsgKbn.ERROR);

    static final Item DDID_VIEWSAIKENINFO1_SAIKENADR2KJ = new Item("sisateisb", "viewSaikenInfo1", "saikenadr2kj", null, ErrorMsgKbn.ERROR);

    static final Item DDID_VIEWSAIKENINFO1_SAIKENADR3KJ = new Item("sisateisb", "viewSaikenInfo1", "saikenadr3kj", null, ErrorMsgKbn.ERROR);

    static final Item DDID_VIEWSINKENSYAINFO_SKSKKNNMKN = new Item("sisateisb", "viewSinkensyaInfo", "skskknnmkn", null, ErrorMsgKbn.ERROR);

    static final Item DDID_VIEWSINKENSYAINFO_SKSKKNNMKJ = new Item("sisateisb", "viewSinkensyaInfo", "skskknnmkj", null, ErrorMsgKbn.ERROR);

    static final Item DDID_VIEWSINKENSYAINFO_SKSKKNSYUBETU = new Item("sisateisb", "viewSinkensyaInfo", "skskknsyubetu", null, ErrorMsgKbn.DISP);

    static final Item DDID_VIEWSOUHUSAKIINFO_SOUHUSAKIKBN = new Item("sisateisb", "viewSouhusakiInfo", "souhusakikbn", null, ErrorMsgKbn.DD);

    static final Item DDID_VIEWSOUHUSAKIINFO_TSINYNO = new Item("sisateisb", "viewSouhusakiInfo", "tsinyno", null, ErrorMsgKbn.ERROR);

    static final Item DDID_VIEWSOUHUSAKIINFO_TSINADR1KJ = new Item("sisateisb", "viewSouhusakiInfo", "tsinadr1kj", null, ErrorMsgKbn.ERROR);

    static final Item DDID_VIEWSOUHUSAKIINFO_TSINADR2KJ = new Item("sisateisb", "viewSouhusakiInfo", "tsinadr2kj", null, ErrorMsgKbn.ERROR);

    static final Item DDID_VIEWSOUHUSAKIINFO_TSINADR3KJ = new Item("sisateisb", "viewSouhusakiInfo", "tsinadr3kj", null, ErrorMsgKbn.ERROR);

    static final Item DDID_VIEWSOUHUSAKIINFO_TSINTELNO = new Item("sisateisb", "viewSouhusakiInfo", "tsintelno", null, ErrorMsgKbn.DD);

    static final Item DDID_VIEWSKNAIYOUINFO_SUKETORIHOUHOUKBN = new Item("sisateisb", "viewSknaiyouInfo", "suketorihouhoukbn", null, ErrorMsgKbn.DD);

    static final Item DDID_VIEWSKNAIYOUINFO_SIHARAITUUKAKBN = new Item("sisateisb", "viewSknaiyouInfo", "siharaituukakbn", null, ErrorMsgKbn.DD);

    static final Item DDID_VIEWSOUKINSAKISHRINFO_INPUTSHRHOUSITEIKBN = new Item("sisateisb", "viewSoukinsakishrInfo", "inputshrhousiteikbn", null, ErrorMsgKbn.DISP);

    static final Item DDID_VIEWSOUKINSAKIINFO_BANKCD = new Item("sisateisb", "viewSoukinsakiInfo", "bankcd", null, ErrorMsgKbn.DD);

    static final Item DDID_VIEWSOUKINSAKIINFO_BANKNMKJ = new Item("sisateisb", "viewSoukinsakiInfo", "banknmkj", null, ErrorMsgKbn.DD);

    static final Item DDID_VIEWSOUKINSAKIINFO_SITENCD = new Item("sisateisb", "viewSoukinsakiInfo", "sitencd", null, ErrorMsgKbn.DD);

    static final Item DDID_VIEWSOUKINSAKIINFO_SITENNMKJ = new Item("sisateisb", "viewSoukinsakiInfo", "sitennmkj", null, ErrorMsgKbn.DD);

    static final Item DDID_VIEWSOUKINSAKIINFO_YOKINKBN = new Item("sisateisb", "viewSoukinsakiInfo", "yokinkbn", null, ErrorMsgKbn.DD);

    static final Item DDID_VIEWSOUKINSAKIINFO_KOUZANO = new Item("sisateisb", "viewSoukinsakiInfo", "kouzano", null, ErrorMsgKbn.DD);

    static final Item DDID_VIEWSOUKINSAKIINFO_KZDOUKBN = new Item("sisateisb", "viewSoukinsakiInfo", "kzdoukbn", null, ErrorMsgKbn.DISP);

    static final Item DDID_VIEWSOUKINSAKIINFO_KZMEIGINMKN = new Item("sisateisb", "viewSoukinsakiInfo", "kzmeiginmkn", null, ErrorMsgKbn.DD);

    static final Item DDID_VIEWSINDANSYOINFOSIBOUINFO_GENINKBN = new Item("sisateisb", "viewSindansyoinfoSibouInfo", "geninkbn", null, ErrorMsgKbn.DD);

    static final Item DDID_VIEWSINDANSYOINFOSIBOUINFO_SIBOUYMD = new Item("sisateisb", "viewSindansyoinfoSibouInfo", "sibouymd", null, ErrorMsgKbn.DD);

    static final Item DDID_VIEWSINDANSYOINFOSIBOUINFO_SIBOUBASYOKBN = new Item("sisateisb", "viewSindansyoinfoSibouInfo", "siboubasyokbn", null, ErrorMsgKbn.DISP);

    static final Item DDID_VIEWSINDANSYOINFOSIBOUINFO_SIBOUBASYO = new Item("sisateisb", "viewSindansyoinfoSibouInfo", "siboubasyo", null, ErrorMsgKbn.DD);

    static final Item DDID_VIEWSINDANSYOINFOSIBOUINFO1_SEARCHLINK = new Item("sisateisb", "viewSindansyoinfoSibouInfo1", "searchlink", null, ErrorMsgKbn.DD);

    static final Item DDID_VIEWSINDANSYOINFOSIBOUINFO1_BYOUMEIKJ = new Item("sisateisb", "viewSindansyoinfoSibouInfo1", "byoumeikj", null, ErrorMsgKbn.DISP);

    static final Item DDID_VIEWSINDANSYOINFOSIBOUINFO1_SAKUJYOLINK = new Item("sisateisb", "viewSindansyoinfoSibouInfo1", "sakujyoLink", null, ErrorMsgKbn.DD);

    static final Item DDID_VIEWSINDANSYOINFOSIBOUINFO1_SAKUJYOFLG = new Item("sisateisb", "viewSindansyoinfoSibouInfo1", "sakujyoflg", null, ErrorMsgKbn.DD);

    static final Item DDID_VIEWSINDANSYOINFOSIBOUINFO1_BYOUMEICD = new Item("sisateisb", "viewSindansyoinfoSibouInfo1", "byoumeicd", null, ErrorMsgKbn.DD);

    static final Item DDID_VIEWSINDANSYOINFOSIBOUINFO1_BYOUMEIKN = new Item("sisateisb", "viewSindansyoinfoSibouInfo1", "byoumeikn", null, ErrorMsgKbn.DD);

    static final Item DDID_VIEWSINDANSYOINFOSIBOUINFO1_BYOUMEITOUROKUNO = new Item("sisateisb", "viewSindansyoinfoSibouInfo1", "byoumeitourokuno", null, ErrorMsgKbn.DD);

    static final Item DDID_TUIKABUTTONS_ADDBTN = new Item("sisateisb", "tuikaButtons", "addbtn", null, ErrorMsgKbn.DD);

    static final Item DDID_VIEWSHRDTLSAKUSEIKBNINFO_SHRDTLSYOOUTKBN = new Item("sisateisb", "viewShrdtlSakuseiKbnInfo", "shrdtlsyooutkbn", null, ErrorMsgKbn.DD);

    static final Item DDID_VIEWSHRDTLSAKUSEIKBNINFO_HASSOUKBN = new Item("sisateisb", "viewShrdtlSakuseiKbnInfo", "hassoukbn", null, ErrorMsgKbn.DD);

    static final Item DDID_VIEWMNMEIGIBANGOU_UKTMNMEIGIBANGOU = new Item("sisateisb", "viewMnMeigiBangou", "uktmnmeigibangou", null, ErrorMsgKbn.ERROR);

    static final Item DDID_VIEWMNMEIGIBANGOU_KYKMNMEIGIBANGOU = new Item("sisateisb", "viewMnMeigiBangou", "kykmnmeigibangou", null, ErrorMsgKbn.ERROR);

    static final Item DDID_VIEWSIININFO_SIINKBN = new Item("sisateisb", "viewSiinInfo", "siinkbn", null, ErrorMsgKbn.DISP);

    static final Item DDID_HKTSHRMEISAISINFO_SYOUHNNMGM = new Item("sisateisb", "hktshrMeisaisInfo", "syouhnnmgm", null, ErrorMsgKbn.DISP);

    static final Item DDID_HKTSHRMEISAISINFO_KYHKG = new Item("sisateisb", "hktshrMeisaisInfo", "kyhkg", null, ErrorMsgKbn.DISP);

    static final Item DDID_HKTSHRMEISAISINFO_BIKOUMSG1 = new Item("sisateisb", "hktshrMeisaisInfo", "bikoumsg1", null, ErrorMsgKbn.DISP);

    static final Item DDID_HKTSHRMEISAISINFO_BIKOUMSG2 = new Item("sisateisb", "hktshrMeisaisInfo", "bikoumsg2", null, ErrorMsgKbn.DD);

    static final Item DDID_HKTSHRMEISAISINFO_BIKOUMSG3 = new Item("sisateisb", "hktshrMeisaisInfo", "bikoumsg3", null, ErrorMsgKbn.DD);

    static final Item DDID_HKTSHRMEISAISINFO_BIKOUMSG4 = new Item("sisateisb", "hktshrMeisaisInfo", "bikoumsg4", null, ErrorMsgKbn.DD);

    static final Item DDID_VIEWSIHARAIINFO_SHRTUUKASYU = new Item("sisateisb", "viewSiharaiInfo", "shrtuukasyu", null, ErrorMsgKbn.DISP);

    static final Item DDID_VIEWSIHARAIINFO_SHRKWSRATEKJNYMD = new Item("sisateisb", "viewSiharaiInfo", "shrkwsratekjnymd", null, ErrorMsgKbn.DISP);

    static final Item DDID_VIEWSIHARAIINFO_SHRKWSRATE = new Item("sisateisb", "viewSiharaiInfo", "shrkwsrate", null, ErrorMsgKbn.DISP);

    static final Item DDID_VIEWSIHARAIINFO_GAIKAKNSNKWSRATEKJYMD = new Item("sisateisb", "viewSiharaiInfo", "gaikaknsnkwsratekjymd", null, ErrorMsgKbn.DISP);

    static final Item DDID_VIEWSIHARAIINFO_GAIKAKNSNKWSRATE = new Item("sisateisb", "viewSiharaiInfo", "gaikaknsnkwsrate", null, ErrorMsgKbn.DISP);

    static final Item DDID_VIEWSIHARAIINFO_DISPSYORUIUKEYMD = new Item("sisateisb", "viewSiharaiInfo", "dispsyoruiukeymd", null, ErrorMsgKbn.DISP);

    static final Item DDID_VIEWSIHARAIINFO_DISPHUBIKANRYOUYMD = new Item("sisateisb", "viewSiharaiInfo", "disphubikanryouymd", null, ErrorMsgKbn.DD);

    static final Item DDID_VIEWSIHARAIINFO1_SHRYMD = new Item("sisateisb", "viewSiharaiInfo1", "shrymd", null, ErrorMsgKbn.DD);

    static final Item DDID_VIEWSIHARAIINFO1_DISPSINSAGENDOKKNKBN = new Item("sisateisb", "viewSiharaiInfo1", "dispsinsagendokknkbn", null, ErrorMsgKbn.DISP);

    static final Item DDID_VIEWSIHARAIINFO1_DISPRKKTYDNNISSUU = new Item("sisateisb", "viewSiharaiInfo1", "disprkktydnnissuu", null, ErrorMsgKbn.DISP);

    static final Item DDID_HKTSHRGOUKEIINFO_SHRGK = new Item("sisateisb", "hktshrGoukeiInfo", "shrgk", null, ErrorMsgKbn.DISP);

    static final Item DDID_HKTSHRGOUKEIINFO_HOKENKNGKGOUKEI = new Item("sisateisb", "hktshrGoukeiInfo", "hokenkngkgoukei", null, ErrorMsgKbn.DD);

    static final Item DDID_HKTSHRGOUKEIINFO_HAITOUKIN = new Item("sisateisb", "hktshrGoukeiInfo", "haitoukin", null, ErrorMsgKbn.DD);

    static final Item DDID_HKTSHRGOUKEIINFO_SONOTAHAITOUKIN = new Item("sisateisb", "hktshrGoukeiInfo", "sonotahaitoukin", null, ErrorMsgKbn.DD);

    static final Item DDID_HKTSHRGOUKEIINFO_MIKEIKAPGAITOUKKN = new Item("sisateisb", "hktshrGoukeiInfo", "mikeikapgaitoukkn", null, ErrorMsgKbn.DISP);

    static final Item DDID_HKTSHRGOUKEIINFO_MIKEIKAP = new Item("sisateisb", "hktshrGoukeiInfo", "mikeikap", null, ErrorMsgKbn.DD);

    static final Item DDID_HKTSHRGOUKEIINFO_MISYUUPGAITOUKKN = new Item("sisateisb", "hktshrGoukeiInfo", "misyuupgaitoukkn", null, ErrorMsgKbn.DISP);

    static final Item DDID_HKTSHRGOUKEIINFO_MISYUUP = new Item("sisateisb", "hktshrGoukeiInfo", "misyuup", null, ErrorMsgKbn.DD);

    static final Item DDID_HKTSHRGOUKEIINFO_ZENNOUSEISANKGK = new Item("sisateisb", "hktshrGoukeiInfo", "zennouseisankgk", null, ErrorMsgKbn.DISP);

    static final Item DDID_HKTSHRGOUKEIINFO_AZUKARIKINGK = new Item("sisateisb", "hktshrGoukeiInfo", "azukarikingk", null, ErrorMsgKbn.DISP);

    static final Item DDID_HKTSHRGOUKEIINFO_KRKGK = new Item("sisateisb", "hktshrGoukeiInfo", "krkgk", null, ErrorMsgKbn.DISP);

    static final Item DDID_HKTSHRGOUKEIINFO_TIENRISOKUKISANYMD = new Item("sisateisb", "hktshrGoukeiInfo", "tienrisokukisanymd", null, ErrorMsgKbn.DISP);

    static final Item DDID_HKTSHRGOUKEIINFO_TIENRSKNISSUU = new Item("sisateisb", "hktshrGoukeiInfo", "tienrsknissuu", null, ErrorMsgKbn.DD);

    static final Item DDID_HKTSHRGOUKEIINFO_SHRTIENRSK = new Item("sisateisb", "hktshrGoukeiInfo", "shrtienrsk", null, ErrorMsgKbn.DD);

    static final Item DDID_YENGOUKEIINFO_YENSHRGK = new Item("sisateisb", "yenGoukeiInfo", "yenshrgk", null, ErrorMsgKbn.DISP);

    static final Item DDID_YENGOUKEIINFO_YENHKGKGOUKEI = new Item("sisateisb", "yenGoukeiInfo", "yenhkgkgoukei", null, ErrorMsgKbn.DISP);

    static final Item DDID_YENGOUKEIINFO_YENKAHAITOUKIN = new Item("sisateisb", "yenGoukeiInfo", "yenkahaitoukin", null, ErrorMsgKbn.DISP);

    static final Item DDID_YENGOUKEIINFO_YENKASONOTAHAITOUKIN = new Item("sisateisb", "yenGoukeiInfo", "yenkasonotahaitoukin", null, ErrorMsgKbn.DISP);

    static final Item DDID_YENGOUKEIINFO_YENKAMIKEIKAPGAITOUKKN = new Item("sisateisb", "yenGoukeiInfo", "yenkamikeikapgaitoukkn", null, ErrorMsgKbn.DISP);

    static final Item DDID_YENGOUKEIINFO_YENKAMIKEIKAP = new Item("sisateisb", "yenGoukeiInfo", "yenkamikeikap", null, ErrorMsgKbn.DD);

    static final Item DDID_YENGOUKEIINFO_YENKAMISYUUPGAITOUKKN = new Item("sisateisb", "yenGoukeiInfo", "yenkamisyuupgaitoukkn", null, ErrorMsgKbn.DISP);

    static final Item DDID_YENGOUKEIINFO_YENKAMISYUUP = new Item("sisateisb", "yenGoukeiInfo", "yenkamisyuup", null, ErrorMsgKbn.DD);

    static final Item DDID_YENGOUKEIINFO_YENKAZENNOUSEISANKGK = new Item("sisateisb", "yenGoukeiInfo", "yenkazennouseisankgk", null, ErrorMsgKbn.DISP);

    static final Item DDID_YENGOUKEIINFO_YENKAAZUKARIKINGK = new Item("sisateisb", "yenGoukeiInfo", "yenkaazukarikingk", null, ErrorMsgKbn.DISP);

    static final Item DDID_YENGOUKEIINFO_YENKAKRKGK = new Item("sisateisb", "yenGoukeiInfo", "yenkakrkgk", null, ErrorMsgKbn.DISP);

    static final Item DDID_YENGOUKEIINFO_YENTIENRISOKUKISANYMD = new Item("sisateisb", "yenGoukeiInfo", "yentienrisokukisanymd", null, ErrorMsgKbn.DISP);

    static final Item DDID_YENGOUKEIINFO_YENTIENRSKNISSUU = new Item("sisateisb", "yenGoukeiInfo", "yentienrsknissuu", null, ErrorMsgKbn.DD);

    static final Item DDID_YENGOUKEIINFO_YENSHRTIENRSK = new Item("sisateisb", "yenGoukeiInfo", "yenshrtienrsk", null, ErrorMsgKbn.DD);

    static final Item DDID_VIEWKINGAKUINFO_HOKENRYOUSTGK = new Item("sisateisb", "viewKingakuInfo", "hokenryoustgk", null, ErrorMsgKbn.DD);

    static final Item DDID_VIEWKINGAKUINFO_YENHOKENRYOUSTGK = new Item("sisateisb", "viewKingakuInfo", "yenhokenryoustgk", null, ErrorMsgKbn.DD);

    static final Item DDID_VIEWKINGAKUINFO_TUTAKNGK = new Item("sisateisb", "viewKingakuInfo", "tutakngk", null, ErrorMsgKbn.DD);

    static final Item DDID_VIEWKINGAKUINFO_YENTUTAKNGK = new Item("sisateisb", "viewKingakuInfo", "yentutakngk", null, ErrorMsgKbn.DD);

    static final Item DDID_VIEWKINGAKUINFO_KAIYAKUHR = new Item("sisateisb", "viewKingakuInfo", "kaiyakuhr", null, ErrorMsgKbn.DD);

    static final Item DDID_VIEWKINGAKUINFO_YENKAIYAKUHR = new Item("sisateisb", "viewKingakuInfo", "yenkaiyakuhr", null, ErrorMsgKbn.DD);

    static final Item DDID_VIEWKINGAKUINFO_KIHONHOKENKNGK = new Item("sisateisb", "viewKingakuInfo", "kihonhokenkngk", null, ErrorMsgKbn.DD);

    static final Item DDID_VIEWKINGAKUINFO_YENKIHONHOKENKNGK = new Item("sisateisb", "viewKingakuInfo", "yenkihonhokenkngk", null, ErrorMsgKbn.DD);

    static final Item DDID_VIEWKINGAKUINFO_SAIGAIS = new Item("sisateisb", "viewKingakuInfo", "saigais", null, ErrorMsgKbn.DD);

    static final Item DDID_VIEWKINGAKUINFO_YENSAIGAIS = new Item("sisateisb", "viewKingakuInfo", "yensaigais", null, ErrorMsgKbn.DD);

    static final Item DDID_VIEWZEIMUINFO_ZEITRATKIKBN = new Item("sisateisb", "viewZeimuInfo", "zeitratkikbn", null, ErrorMsgKbn.DISP);

    static final Item DDID_VIEWZEIMUINFO_GOUKEIHITUYOUKEIHI = new Item("sisateisb", "viewZeimuInfo", "goukeihituyoukeihi", null, ErrorMsgKbn.DISP);

    static final Item DDID_VIEWZEIMUINFO_KYKHNKKAISUU = new Item("sisateisb", "viewZeimuInfo", "kykhnkkaisuu", null, ErrorMsgKbn.DD);

    static final Item DDID_VIEWZEIMUINFO_SHRKYKHTYKEIHI = new Item("sisateisb", "viewZeimuInfo", "shrkykhtykeihi", null, ErrorMsgKbn.DISP);

    static final Item DDID_VIEWSATEIKOUMOKUINFO_SATEIKOUMOKU = new Item("sisateisb", "viewSateikoumokuInfo", "sateikoumoku", null, ErrorMsgKbn.DD);

    static final Item DDID_VIEWIPPANHANTEIINFO_IPPANHANTEITENSUU1 = new Item("sisateisb", "viewIppanhanteiInfo", "ippanhanteitensuu1", null, ErrorMsgKbn.DD);

    static final Item DDID_VIEWIPPANHANTEIINFO_IPPANHANTEICOMMENT1 = new Item("sisateisb", "viewIppanhanteiInfo", "ippanhanteicomment1", null, ErrorMsgKbn.DD);

    static final Item DDID_VIEWIPPANHANTEIINFO_IPPANHANTEITENSUU2 = new Item("sisateisb", "viewIppanhanteiInfo", "ippanhanteitensuu2", null, ErrorMsgKbn.DD);

    static final Item DDID_VIEWIPPANHANTEIINFO_IPPANHANTEICOMMENT2 = new Item("sisateisb", "viewIppanhanteiInfo", "ippanhanteicomment2", null, ErrorMsgKbn.DD);

    static final Item DDID_VIEWIPPANHANTEIINFO_IPPANHANTEITENSUU3 = new Item("sisateisb", "viewIppanhanteiInfo", "ippanhanteitensuu3", null, ErrorMsgKbn.DD);

    static final Item DDID_VIEWIPPANHANTEIINFO_IPPANHANTEICOMMENT3 = new Item("sisateisb", "viewIppanhanteiInfo", "ippanhanteicomment3", null, ErrorMsgKbn.DD);

    static final Item DDID_VIEWIPPANHANTEIINFO_IPPANHANTEITENSUU4 = new Item("sisateisb", "viewIppanhanteiInfo", "ippanhanteitensuu4", null, ErrorMsgKbn.DD);

    static final Item DDID_VIEWIPPANHANTEIINFO_IPPANHANTEICOMMENT4 = new Item("sisateisb", "viewIppanhanteiInfo", "ippanhanteicomment4", null, ErrorMsgKbn.DD);

    static final Item DDID_VIEWIPPANHANTEIINFO_IPPANHANTEITENSUU5 = new Item("sisateisb", "viewIppanhanteiInfo", "ippanhanteitensuu5", null, ErrorMsgKbn.DD);

    static final Item DDID_VIEWIPPANHANTEIINFO_IPPANHANTEICOMMENT5 = new Item("sisateisb", "viewIppanhanteiInfo", "ippanhanteicomment5", null, ErrorMsgKbn.DD);

    static final Item DDID_VIEWIPPANHANTEIINFO_IPPANHANTEITENSUU6 = new Item("sisateisb", "viewIppanhanteiInfo", "ippanhanteitensuu6", null, ErrorMsgKbn.DD);

    static final Item DDID_VIEWIPPANHANTEIINFO_IPPANHANTEICOMMENT6 = new Item("sisateisb", "viewIppanhanteiInfo", "ippanhanteicomment6", null, ErrorMsgKbn.DD);

    static final Item DDID_VIEWIPPANHANTEIINFO_IPPANHANTEITENSUUGOUKEI = new Item("sisateisb", "viewIppanhanteiInfo", "ippanhanteitensuugoukei", null, ErrorMsgKbn.DD);

    static final Item DDID_VIEWIPPANHANTEIINFO_IPPANHANTEIGOUKEICOMMENT = new Item("sisateisb", "viewIppanhanteiInfo", "ippanhanteigoukeicomment", null, ErrorMsgKbn.DD);

    static final Item DDID_VIEWKOKUHANCHECKINFO_KOKUHANCHECK1 = new Item("sisateisb", "viewKokuhanCheckInfo", "kokuhancheck1", null, ErrorMsgKbn.DD);

    static final Item DDID_VIEWKOKUHANCHECKINFO_KOKUHANCHECOMMENT1 = new Item("sisateisb", "viewKokuhanCheckInfo", "kokuhanchecomment1", null, ErrorMsgKbn.DD);

    static final Item DDID_VIEWKOKUHANCHECKINFO_KOKUHANCHECK2 = new Item("sisateisb", "viewKokuhanCheckInfo", "kokuhancheck2", null, ErrorMsgKbn.DD);

    static final Item DDID_VIEWKOKUHANCHECKINFO_KOKUHANCHECOMMENT2 = new Item("sisateisb", "viewKokuhanCheckInfo", "kokuhanchecomment2", null, ErrorMsgKbn.DD);

    static final Item DDID_VIEWKOKUHANCHECKINFO_KOKUHANCHECK3 = new Item("sisateisb", "viewKokuhanCheckInfo", "kokuhancheck3", null, ErrorMsgKbn.DD);

    static final Item DDID_VIEWKOKUHANCHECKINFO_KOKUHANCHECOMMENT3 = new Item("sisateisb", "viewKokuhanCheckInfo", "kokuhanchecomment3", null, ErrorMsgKbn.DD);

    static final Item DDID_VIEWKOKUHANCHECKINFO_KOKUHANCHECK4 = new Item("sisateisb", "viewKokuhanCheckInfo", "kokuhancheck4", null, ErrorMsgKbn.DD);

    static final Item DDID_VIEWKOKUHANCHECKINFO_KOKUHANCHECOMMENT4 = new Item("sisateisb", "viewKokuhanCheckInfo", "kokuhanchecomment4", null, ErrorMsgKbn.DD);

    static final Item DDID_VIEWKOKUHANCHECKINFO_KOKUHANCHECK5 = new Item("sisateisb", "viewKokuhanCheckInfo", "kokuhancheck5", null, ErrorMsgKbn.DD);

    static final Item DDID_VIEWKOKUHANCHECKINFO_KOKUHANCHECOMMENT5 = new Item("sisateisb", "viewKokuhanCheckInfo", "kokuhanchecomment5", null, ErrorMsgKbn.DD);

    static final Item DDID_VIEWKOKUHANCHECKINFO_KOKUHANCHECK6 = new Item("sisateisb", "viewKokuhanCheckInfo", "kokuhancheck6", null, ErrorMsgKbn.DD);

    static final Item DDID_VIEWKOKUHANCHECKINFO_KOKUHANCHECOMMENT6 = new Item("sisateisb", "viewKokuhanCheckInfo", "kokuhanchecomment6", null, ErrorMsgKbn.DD);

    static final Item DDID_VIEWKOKUHANCHECKINFO_KOKUHANCHECK7 = new Item("sisateisb", "viewKokuhanCheckInfo", "kokuhancheck7", null, ErrorMsgKbn.DD);

    static final Item DDID_VIEWKOKUHANCHECKINFO_KOKUHANCHECOMMENT7 = new Item("sisateisb", "viewKokuhanCheckInfo", "kokuhanchecomment7", null, ErrorMsgKbn.DD);

    static final Item DDID_VIEWKOKUHANCHECKINFO_KOKUHANCHECK8 = new Item("sisateisb", "viewKokuhanCheckInfo", "kokuhancheck8", null, ErrorMsgKbn.DD);

    static final Item DDID_VIEWKOKUHANCHECKINFO_KOKUHANCHECOMMENT8 = new Item("sisateisb", "viewKokuhanCheckInfo", "kokuhanchecomment8", null, ErrorMsgKbn.DD);

    static final Item DDID_VIEWJYUUKASITUINFO_JUUKASITUCHECK1 = new Item("sisateisb", "viewJyuukasituInfo", "juukasitucheck1", null, ErrorMsgKbn.DD);

    static final Item DDID_VIEWJYUUKASITUINFO_JUUKASITUCHECKCOMMENT1 = new Item("sisateisb", "viewJyuukasituInfo", "juukasitucheckcomment1", null, ErrorMsgKbn.DD);

    static final Item DDID_VIEWJYUUKASITUINFO_JUUKASITUCHECK2 = new Item("sisateisb", "viewJyuukasituInfo", "juukasitucheck2", null, ErrorMsgKbn.DD);

    static final Item DDID_VIEWJYUUKASITUINFO_JUUKASITUCHECKCOMMENT2 = new Item("sisateisb", "viewJyuukasituInfo", "juukasitucheckcomment2", null, ErrorMsgKbn.DD);

    static final Item DDID_VIEWJYUUKASITUINFO_JUUKASITUCHECK3 = new Item("sisateisb", "viewJyuukasituInfo", "juukasitucheck3", null, ErrorMsgKbn.DD);

    static final Item DDID_VIEWJYUUKASITUINFO_JUUKASITUCHECKCOMMENT3 = new Item("sisateisb", "viewJyuukasituInfo", "juukasitucheckcomment3", null, ErrorMsgKbn.DD);

    static final Item DDID_VIEWJYUUKASITUINFO_JUUKASITUCHECK4 = new Item("sisateisb", "viewJyuukasituInfo", "juukasitucheck4", null, ErrorMsgKbn.DD);

    static final Item DDID_VIEWJYUUKASITUINFO_JUUKASITUCHECKCOMMENT4 = new Item("sisateisb", "viewJyuukasituInfo", "juukasitucheckcomment4", null, ErrorMsgKbn.DD);

    static final Item DDID_VIEWKAIJOKIGENYMDINPUTINFO_KAIJOKIGENYMD = new Item("sisateisb", "viewKaijokigenymdInputInfo", "kaijokigenymd", null, ErrorMsgKbn.DD);

    static final Item DDID_VIEWMEIGIHENKOUSATEIINFO_MEIHENYUUKOUMUKOUKBN = new Item("sisateisb", "viewMeigihenkouSateiInfo", "meihenyuukoumukoukbn", null, ErrorMsgKbn.DD);

    static final Item DDID_VIEWMEIGIHENKOUSATEIINFO_MEIHENUKTKBN = new Item("sisateisb", "viewMeigihenkouSateiInfo", "meihenuktkbn", null, ErrorMsgKbn.DD);

    static final Item DDID_VIEWMEIGIHENKOUSATEIINFO_MEIHENUKTNM = new Item("sisateisb", "viewMeigihenkouSateiInfo", "meihenuktnm", null, ErrorMsgKbn.DD);

    static final Item DDID_VIEWTRATKIHURYOUHUSYOUJIKENINFO_TRATKIHURYOUUMUKBN = new Item("sisateisb", "viewTratkihuryouHusyoujikenInfo", "tratkihuryouumukbn", null, ErrorMsgKbn.DD);

    static final Item DDID_VIEWTRATKIHURYOUHUSYOUJIKENINFO_GYOUSINKAISOUYOUHIKBN = new Item("sisateisb", "viewTratkihuryouHusyoujikenInfo", "gyousinkaisouyouhikbn", null, ErrorMsgKbn.DD);

    static final Item DDID_VIEWTRATKIHURYOUHUSYOUJIKENINFO_AIREQDAITYOUKISAIKBN = new Item("sisateisb", "viewTratkihuryouHusyoujikenInfo", "aireqdaityoukisaikbn", null, ErrorMsgKbn.DD);

    static final Item DDID_VIEWTRATKIHURYOUHUSYOUJIKENINFO_TRATKIHURYOUCOMMENT = new Item("sisateisb", "viewTratkihuryouHusyoujikenInfo", "tratkihuryoucomment", null, ErrorMsgKbn.ERROR);

    static final Item DDID_VIEWSONOTACHECKSIBOU_BENGOSIKENKAIUMUKBN = new Item("sisateisb", "viewSonotaCheckSibou", "bengosikenkaiumukbn", null, ErrorMsgKbn.DD);

    static final Item DDID_VIEWSONOTACHECKSIBOU_KUJYOUUMUKBN = new Item("sisateisb", "viewSonotaCheckSibou", "kujyouumukbn", null, ErrorMsgKbn.DD);

    static final Item DDID_VIEWSONOTACHECKSIBOU_JIMUMISSUMUKBN = new Item("sisateisb", "viewSonotaCheckSibou", "jimumissumukbn", null, ErrorMsgKbn.DD);

    static final Item DDID_VIEWSONOTACHECKSIBOU_KYHGKSITUKAISOUYOUHIKBN = new Item("sisateisb", "viewSonotaCheckSibou", "kyhgksitukaisouyouhikbn", null, ErrorMsgKbn.DD);

    static final Item DDID_VIEWBETUKUTICHECKSIBOUINFO_BETUSIBOUUMUKBN = new Item("sisateisb", "viewBetukutiCheckSibouInfo", "betusibouumukbn", null, ErrorMsgKbn.DD);

    static final Item DDID_VIEWBETUKUTICHECKSIBOUINFO_BETUSIBOUCOMMENT = new Item("sisateisb", "viewBetukutiCheckSibouInfo", "betusiboucomment", null, ErrorMsgKbn.ERROR);

    static final Item DDID_VIEWBETUKUTICHECKSIBOUINFO_BETUSOUKIUMUKBN = new Item("sisateisb", "viewBetukutiCheckSibouInfo", "betusoukiumukbn", null, ErrorMsgKbn.DD);

    static final Item DDID_VIEWBETUKUTICHECKSIBOUINFO_BETUSOUKICOMMENT = new Item("sisateisb", "viewBetukutiCheckSibouInfo", "betusoukicomment", null, ErrorMsgKbn.ERROR);

    static final Item DDID_VIEWSIHARAISATEIINFO_HOKENKINSYURUI = new Item("sisateisb", "viewSiharaiSateiInfo", "hokenkinsyurui", null, ErrorMsgKbn.DD);

    static final Item DDID_VIEWSIHARAISATEIINFO_SYORIKEKKAKBN = new Item("sisateisb", "viewSiharaiSateiInfo", "syorikekkakbn", null, ErrorMsgKbn.DISP);

    static final Item DDID_VIEWSIHARAISATEIINFO_TENNOUSAKISOUSASYACD = new Item("sisateisb", "viewSiharaiSateiInfo", "tennousakisousasyacd", null, ErrorMsgKbn.DISP);

    static final Item DDID_VIEWSIHARAISATEIINFO_HUSHRGENINKBN = new Item("sisateisb", "viewSiharaiSateiInfo", "hushrgeninkbn", null, ErrorMsgKbn.DISP);

    static final Item DDID_VIEWSIHARAISATEIINFO_SESSYOUYHKBN = new Item("sisateisb", "viewSiharaiSateiInfo", "sessyouyhkbn", null, ErrorMsgKbn.DD);

    static final Item DDID_VIEWSIHARAISATEIINFO_SESSYOUSISYACD = new Item("sisateisb", "viewSiharaiSateiInfo", "sessyousisyacd", null, ErrorMsgKbn.DD);

    static final Item DDID_VIEWSIHARAISATEIINFO_SISYANM = new Item("sisateisb", "viewSiharaiSateiInfo", "sisyanm", null, ErrorMsgKbn.DD);

    static final Item DDID_VIEWSIHARAISATEIINFO_SINSAGENDOKKNKBN = new Item("sisateisb", "viewSiharaiSateiInfo", "sinsagendokknkbn", null, ErrorMsgKbn.DISP);

    static final Item DDID_VIEWSIHARAISATEIINFO_RIKOUKITYUUTUUDANNISSUU = new Item("sisateisb", "viewSiharaiSateiInfo", "rikoukityuutuudannissuu", null, ErrorMsgKbn.DISP);

    static final Item DDID_VIEWSIHARAISATEIINFO_SAIGAIMOUSIDEUMUKBN = new Item("sisateisb", "viewSiharaiSateiInfo", "saigaimousideumukbn", null, ErrorMsgKbn.DISP);

    static final Item DDID_VIEWSIHARAISATEIINFO_SINDANSYORYOUSHRYOUHI = new Item("sisateisb", "viewSiharaiSateiInfo", "sindansyoryoushryouhi", null, ErrorMsgKbn.DD);

    static final Item DDID_VIEWSIHARAISATEIINFO_SINDANSYORYOUSHRYOUHIKBN = new Item("sisateisb", "viewSiharaiSateiInfo", "sindansyoryoushryouhikbn", null, ErrorMsgKbn.DISP);

    static final Item DDID_VIEWSIHARAISATEIINFO_SYANAICOMMENT = new Item("sisateisb", "viewSiharaiSateiInfo", "syanaicomment", null, ErrorMsgKbn.ERROR);

    static final Item DDID_VIEWSATEIKEKKAINFO_SATEISYORIKEKKAKBN = new Item("sisateisb", "viewSateiKekkaInfo", "sateisyorikekkakbn", null, ErrorMsgKbn.DISP);

    static final Item DDID_VIEWSATEIKEKKAINFO_SATEITENNOUSAKISOUSASYACD = new Item("sisateisb", "viewSateiKekkaInfo", "sateitennousakisousasyacd", null, ErrorMsgKbn.DISP);

    static final Item DDID_VIEWSATEIKEKKAINFO_KAIKETUYMD = new Item("sisateisb", "viewSateiKekkaInfo", "kaiketuymd", null, ErrorMsgKbn.DD);

    static final Item DDID_VIEWSATEIKEKKAINFO_SATEISYANAICOMMENT = new Item("sisateisb", "viewSateiKekkaInfo", "sateisyanaicomment", null, ErrorMsgKbn.ERROR);

    static final Item DDID_VIEWKAKUNINKOUMOKUINFO_DISPSYORIYMD = new Item("sisateisb", "viewKakuninkoumokuInfo", "dispsyoriymd", null, ErrorMsgKbn.DISP);

    static final Item DDID_VIEWKAKUNINKOUMOKUINFO_DISPTASKNM = new Item("sisateisb", "viewKakuninkoumokuInfo", "disptasknm", null, ErrorMsgKbn.DISP);

    static final Item DDID_VIEWKAKUNINKOUMOKUINFO_DISPSYORIKEKKAKBN = new Item("sisateisb", "viewKakuninkoumokuInfo", "dispsyorikekkakbn", null, ErrorMsgKbn.DISP);

    static final Item DDID_VIEWKAKUNINKOUMOKUINFO_DISPSOUSASYANM = new Item("sisateisb", "viewKakuninkoumokuInfo", "dispsousasyanm", null, ErrorMsgKbn.DISP);

    static final Item DDID_VIEWKAKUNINKOUMOKUINFO_DISPCOMMENT = new Item("sisateisb", "viewKakuninkoumokuInfo", "dispcomment", null, ErrorMsgKbn.DISP);

    static final Item DDID_FOOTERBUTTONS_MODORUBTNBYINPUTCONTENTS = new Item("sisateisb", "footerButtons", "modoruBtnByInputContents", null, ErrorMsgKbn.DD);

    static final Item DDID_FOOTERBUTTONS_MODORUBTNBYINPUTCORRECT = new Item("sisateisb", "footerButtons", "modorubtnbyinputcorrect", null, ErrorMsgKbn.DD);

    static final Item DDID_FOOTERBUTTONS_MODORUBTNBYCONFIRM = new Item("sisateisb", "footerButtons", "modoruBtnByConfirm", null, ErrorMsgKbn.DD);

    static final Item DDID_FOOTERBUTTONS_KAKUTEIBTN = new Item("sisateisb", "footerButtons", "kakuteiBtn", null, ErrorMsgKbn.DD);

    static final Item DDID_FOOTERBUTTONS_SYOKIGAMENHEBTN = new Item("sisateisb", "footerButtons", "syokigamenheBtn", null, ErrorMsgKbn.DD);

    static final Item DDID_FOOTERBUTTONS2_SYOUKAIBTNHIHYOUJI = new Item("sisateisb", "footerButtons2", "syoukaibtnhihyouji", null, ErrorMsgKbn.DD);
}
