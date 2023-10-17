package yuyu.app.siharai.sihubikanri.sihubitouroku;

import jp.co.slcs.swak.bizinfr.configuration.Item;
import jp.co.slcs.swak.bizinfr.configuration.Item.ErrorMsgKbn;

/**
 * 保険金給付金不備登録 画面項目ID定義のベースクラスです。<br />
 * このソースはツールによる自動生成で、画面項目定義の変更に連動して更新されます。
 * 手書きコードを加えてはいけません。
 */
public class GenSiHubiTourokuConstants {

    public static final int PAGENO_INIT           = 1;

    public static final int PAGENO_INPUTKEY       = 1;

    public static final int PAGENO_SELECTDATA     = 2;

    public static final int PAGENO_INPUTCONTENTS  = 3;

    public static final int PAGENO_CONFIRM        = 4;

    public static final int PAGENO_RESULT         = 5;

    static final String FORWARDNAME_INIT           = "init";

    static final String FORWARDNAME_INPUTKEY       = "InputKey";

    static final String FORWARDNAME_SELECTDATA     = "SelectData";

    static final String FORWARDNAME_INPUTCONTENTS  = "InputContents";

    static final String FORWARDNAME_CONFIRM        = "Confirm";

    static final String FORWARDNAME_RESULT         = "Result";

    static final String FORWARDNAME_BACKTOWORKLIST = "backToWorkList";

    static final Item DDID_HEADERBUTTONS_TOJIRUBTN = new Item("sihubitouroku", "headerButtons", "tojiruBtn", null, ErrorMsgKbn.DD);

    static final Item DDID_KOUTEIINFO_VKTIFDISPJIMUTETUZUKINM = new Item("sihubitouroku", "kouteiinfo", "vktifdispjimutetuzukinm", null, ErrorMsgKbn.DD);

    static final Item DDID_KOUTEIINFO_VKTIFDISPTASKNM = new Item("sihubitouroku", "kouteiinfo", "vktifdisptasknm", null, ErrorMsgKbn.DD);

    static final Item DDID_BASEINFO_SYONO = new Item("sihubitouroku", "baseInfo", "syono", null, ErrorMsgKbn.DD);

    static final Item DDID_BASEINFO_SKNO = new Item("sihubitouroku", "baseInfo", "skno", null, ErrorMsgKbn.DD);

    static final Item DDID_SYORUIINFOLIST_SYORUITTYKYMDTIME = new Item("sihubitouroku", "syoruiInfoList", "syoruittykymdtime", null, ErrorMsgKbn.DD);

    static final Item DDID_SYORUIINFOLIST_SYORUINM = new Item("sihubitouroku", "syoruiInfoList", "syoruinm", null, ErrorMsgKbn.DD);

    static final Item DDID_SYORUIINFOLIST_HTYSYORUIUMUKBN = new Item("sihubitouroku", "syoruiInfoList", "htysyoruiumukbn", null, ErrorMsgKbn.DISP);

    static final Item DDID_SYORUIINFOLIST_HYOUJILINK = new Item("sihubitouroku", "syoruiInfoList", "hyoujilink", null, ErrorMsgKbn.DD);

    static final Item DDID_SYORUIINFOLIST_HYOUJILINKFLG = new Item("sihubitouroku", "syoruiInfoList", "hyoujilinkflg", null, ErrorMsgKbn.DD);

    static final Item DDID_SYORUIINFOLIST_IMAGEID = new Item("sihubitouroku", "syoruiInfoList", "imageid", null, ErrorMsgKbn.DD);

    static final Item DDID_BUTTONALLHYOUJI_ALLHYOUJIBTN = new Item("sihubitouroku", "buttonAllhyouji", "allhyoujibtn", null, ErrorMsgKbn.DD);

    static final Item DDID_HIDDENGROUP_IMAGEID = new Item("sihubitouroku", "hiddenGroup", "imageid", null, ErrorMsgKbn.DD);

    static final Item DDID_HIDDENGROUP_KOUTEILOCKKEY = new Item("sihubitouroku", "hiddenGroup", "kouteilockkey", null, ErrorMsgKbn.DD);

    static final Item DDID_SELECTDATALIST_JIMUTETUZUKINM = new Item("sihubitouroku", "selectDataList", "jimutetuzukinm", null, ErrorMsgKbn.DD);

    static final Item DDID_SELECTDATALIST_JIMUSTARTYMD = new Item("sihubitouroku", "selectDataList", "jimustartymd", null, ErrorMsgKbn.DD);

    static final Item DDID_SELECTDATALIST_NYUURYOKULINK = new Item("sihubitouroku", "selectDataList", "nyuuryokuLink", null, ErrorMsgKbn.DD);

    static final Item DDID_SELECTDATALIST_SKNO = new Item("sihubitouroku", "selectDataList", "skno", null, ErrorMsgKbn.DD);

    static final Item DDID_PROGRESSHISTORYINFO_VPRGHSDISPSYORIYMD = new Item("sihubitouroku", "progresshistoryinfo", "vprghsdispsyoriymd", null, ErrorMsgKbn.DD);

    static final Item DDID_PROGRESSHISTORYINFO_VPRGHSDISPTASKNM = new Item("sihubitouroku", "progresshistoryinfo", "vprghsdisptasknm", null, ErrorMsgKbn.DD);

    static final Item DDID_PROGRESSHISTORYINFO_VPRGHSDISPSYORIKEKKAKBN = new Item("sihubitouroku", "progresshistoryinfo", "vprghsdispsyorikekkakbn", null, ErrorMsgKbn.DD);

    static final Item DDID_PROGRESSHISTORYINFO_VPRGHSDISPSOUSASYANM = new Item("sihubitouroku", "progresshistoryinfo", "vprghsdispsousasyanm", null, ErrorMsgKbn.DD);

    static final Item DDID_PROGRESSHISTORYINFO_VPRGHSDISPCOMMENT = new Item("sihubitouroku", "progresshistoryinfo", "vprghsdispcomment", null, ErrorMsgKbn.DD);

    static final Item DDID_HASINZUMIHUBILIST_TRKYMD = new Item("sihubitouroku", "hasinzumihubiList", "trkymd", null, ErrorMsgKbn.DD);

    static final Item DDID_HASINZUMIHUBILIST_HUBISYORUINM = new Item("sihubitouroku", "hasinzumihubiList", "hubisyoruinm", null, ErrorMsgKbn.DD);

    static final Item DDID_HASINZUMIHUBILIST_GENPONHNKYKUMUCHKBOX = new Item("sihubitouroku", "hasinzumihubiList", "genponhnkykumuchkbox", null, ErrorMsgKbn.DD);

    static final Item DDID_HASINZUMIHUBILIST_HASINYMD = new Item("sihubitouroku", "hasinzumihubiList", "hasinymd", null, ErrorMsgKbn.DD);

    static final Item DDID_HASINZUMIHUBILIST_HASSINSAKIKBN = new Item("sihubitouroku", "hasinzumihubiList", "hassinsakikbn", null, ErrorMsgKbn.DD);

    static final Item DDID_HASINZUMIHUBILIST_NYUURYOKUTANTOUNM = new Item("sihubitouroku", "hasinzumihubiList", "nyuuryokutantounm", null, ErrorMsgKbn.DD);

    static final Item DDID_HASINZUMIHUBILIST_KAISYOUYMD = new Item("sihubitouroku", "hasinzumihubiList", "kaisyouymd", null, ErrorMsgKbn.DD);

    static final Item DDID_HASINZUMIHUBILIST_HUBINAIYOUMSG = new Item("sihubitouroku", "hasinzumihubiList", "hubinaiyoumsg", null, ErrorMsgKbn.DISP);

    static final Item DDID_HASINZUMIHUBILIST_SYOUNINTANTOUNM = new Item("sihubitouroku", "hasinzumihubiList", "syounintantounm", null, ErrorMsgKbn.DD);

    static final Item DDID_MIHASINHUBILIST_DISPTRKYMD = new Item("sihubitouroku", "mihasinhubiList", "disptrkymd", null, ErrorMsgKbn.DD);

    static final Item DDID_MIHASINHUBILIST_DISPSYORUICD = new Item("sihubitouroku", "mihasinhubiList", "dispsyoruicd", null, ErrorMsgKbn.DISP);

    static final Item DDID_MIHASINHUBILIST_DISPHUBISYORUINM = new Item("sihubitouroku", "mihasinhubiList", "disphubisyoruinm", null, ErrorMsgKbn.DD);

    static final Item DDID_MIHASINHUBILIST_DISPGENPONHNKYKUMUCHKBOX = new Item("sihubitouroku", "mihasinhubiList", "dispgenponhnkykumuchkbox", null, ErrorMsgKbn.DD);

    static final Item DDID_MIHASINHUBILIST_DISPHASSINYMD = new Item("sihubitouroku", "mihasinhubiList", "disphassinymd", null, ErrorMsgKbn.DD);

    static final Item DDID_MIHASINHUBILIST_DISPHASSINSAKIKBN = new Item("sihubitouroku", "mihasinhubiList", "disphassinsakikbn", null, ErrorMsgKbn.DD);

    static final Item DDID_MIHASINHUBILIST_DISPNYURYOKUTANTOUNM = new Item("sihubitouroku", "mihasinhubiList", "dispnyuryokutantounm", null, ErrorMsgKbn.DD);

    static final Item DDID_MIHASINHUBILIST_DISPKAISYOUYMD = new Item("sihubitouroku", "mihasinhubiList", "dispkaisyouymd", null, ErrorMsgKbn.DD);

    static final Item DDID_MIHASINHUBILIST_SAKUJYOLINK = new Item("sihubitouroku", "mihasinhubiList", "sakujyoLink", null, ErrorMsgKbn.DD);

    static final Item DDID_MIHASINHUBILIST_SAKUJYOFLG = new Item("sihubitouroku", "mihasinhubiList", "sakujyoflg", null, ErrorMsgKbn.DD);

    static final Item DDID_MIHASINHUBILIST_DISPHUBINAIYOUMSG = new Item("sihubitouroku", "mihasinhubiList", "disphubinaiyoumsg", null, ErrorMsgKbn.DISP);

    static final Item DDID_MIHASINHUBILIST_DISPSYOUNINTANTOUNM = new Item("sihubitouroku", "mihasinhubiList", "dispsyounintantounm", null, ErrorMsgKbn.DD);

    static final Item DDID_MIHASINHUBILIST_HUBINAIYOUCD = new Item("sihubitouroku", "mihasinhubiList", "hubinaiyoucd", null, ErrorMsgKbn.DD);

    static final Item DDID_MIHASINHUBILIST_SAKUJYOFLG2 = new Item("sihubitouroku", "mihasinhubiList", "sakujyoflg2", null, ErrorMsgKbn.DD);

    static final Item DDID_TUIKABUTTONS_ADDBTN = new Item("sihubitouroku", "tuikaButtons", "addbtn", null, ErrorMsgKbn.DD);

    static final Item DDID_SISYAINFO_SISYACD = new Item("sihubitouroku", "sisyainfo", "sisyacd", null, ErrorMsgKbn.DISP);

    static final Item DDID_SISYAINFO_SISYANM = new Item("sihubitouroku", "sisyainfo", "sisyanm", null, ErrorMsgKbn.DD);

    static final Item DDID_RENRAKUSAKINM_RENRAKUSAKINMKJ = new Item("sihubitouroku", "renrakusakiNm", "renrakusakinmkj", null, ErrorMsgKbn.ERROR);

    static final Item DDID_RENRAKUSAKIINFO_TSINYNO = new Item("sihubitouroku", "renrakusakiInfo", "tsinyno", null, ErrorMsgKbn.ERROR);

    static final Item DDID_RENRAKUSAKIINFO_TSINADR1KJ = new Item("sihubitouroku", "renrakusakiInfo", "tsinadr1kj", null, ErrorMsgKbn.ERROR);

    static final Item DDID_RENRAKUSAKIINFO_TSINADR2KJ = new Item("sihubitouroku", "renrakusakiInfo", "tsinadr2kj", null, ErrorMsgKbn.ERROR);

    static final Item DDID_RENRAKUSAKIINFO_TSINADR3KJ = new Item("sihubitouroku", "renrakusakiInfo", "tsinadr3kj", null, ErrorMsgKbn.ERROR);

    static final Item DDID_RENRAKURAN_RENRAKUAREA = new Item("sihubitouroku", "renrakuran", "renrakuarea", null, ErrorMsgKbn.DD);

    static final Item DDID_TOIAWASEINFO_TOIAWASESOSIKINMKJ = new Item("sihubitouroku", "toiawaseInfo", "toiawasesosikinmkj", null, ErrorMsgKbn.DISP);

    static final Item DDID_TOIAWASEINFO_TOIAWASETELNO = new Item("sihubitouroku", "toiawaseInfo", "toiawasetelno", null, ErrorMsgKbn.ERROR);

    static final Item DDID_KEKKAINPUT_SYORIKEKKAKBN = new Item("sihubitouroku", "kekkaInput", "syorikekkakbn", null, ErrorMsgKbn.DD);

    static final Item DDID_KEKKAINPUT_TENNOUSAKISOUSASYACD = new Item("sihubitouroku", "kekkaInput", "tennousakisousasyacd", null, ErrorMsgKbn.DD);

    static final Item DDID_KEKKAINPUT_SYANAICOMMENT = new Item("sihubitouroku", "kekkaInput", "syanaicomment", null, ErrorMsgKbn.DD);

    static final Item DDID_HIDDENDATEGROUP_SYORIYMD = new Item("sihubitouroku", "hiddenDateGroup", "syoriYmd", null, ErrorMsgKbn.DD);

    static final Item DDID_HIDDENDATEGROUP_NYUURYOKUTANTOUNM = new Item("sihubitouroku", "hiddenDateGroup", "nyuuryokutantounm", null, ErrorMsgKbn.DD);

    static final Item DDID_FOOTERBUTTONS2_MODORUBTNBYITIRANSENTAKU = new Item("sihubitouroku", "footerButtons2", "modorubtnbyitiransentaku", null, ErrorMsgKbn.DD);

    static final Item DDID_FOOTERBUTTONS3_MODORUBTNBYINPUTCONTENTS = new Item("sihubitouroku", "footerButtons3", "modoruBtnByInputContents", null, ErrorMsgKbn.DD);

    static final Item DDID_FOOTERBUTTONS4_MODORUBTNBYCONFIRM = new Item("sihubitouroku", "footerButtons4", "modoruBtnByConfirm", null, ErrorMsgKbn.DD);

    static final Item DDID_FOOTERBUTTONS4_KAKUTEIBTN = new Item("sihubitouroku", "footerButtons4", "kakuteiBtn", null, ErrorMsgKbn.DD);

    static final Item DDID_FOOTERBUTTONS5_SYOKIGAMENHEBTN = new Item("sihubitouroku", "footerButtons5", "syokigamenheBtn", null, ErrorMsgKbn.DD);
}
