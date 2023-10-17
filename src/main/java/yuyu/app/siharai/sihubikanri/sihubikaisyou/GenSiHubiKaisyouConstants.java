package yuyu.app.siharai.sihubikanri.sihubikaisyou;

import jp.co.slcs.swak.bizinfr.configuration.Item;
import jp.co.slcs.swak.bizinfr.configuration.Item.ErrorMsgKbn;

/**
 * 保険金給付金不備解消 画面項目ID定義のベースクラスです。<br />
 * このソースはツールによる自動生成で、画面項目定義の変更に連動して更新されます。
 * 手書きコードを加えてはいけません。
 */
public class GenSiHubiKaisyouConstants {

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

    static final Item DDID_HEADERBUTTONS_TOJIRUBTN = new Item("sihubikaisyou", "headerButtons", "tojiruBtn", null, ErrorMsgKbn.DD);

    static final Item DDID_KOUTEIINFO_VKTIFDISPJIMUTETUZUKINM = new Item("sihubikaisyou", "kouteiinfo", "vktifdispjimutetuzukinm", null, ErrorMsgKbn.DD);

    static final Item DDID_KOUTEIINFO_VKTIFDISPTASKNM = new Item("sihubikaisyou", "kouteiinfo", "vktifdisptasknm", null, ErrorMsgKbn.DD);

    static final Item DDID_BASEINFO_SYONO = new Item("sihubikaisyou", "baseInfo", "syono", null, ErrorMsgKbn.DD);

    static final Item DDID_BASEINFO_SKNO = new Item("sihubikaisyou", "baseInfo", "skno", null, ErrorMsgKbn.DD);

    static final Item DDID_SELECTDATALIST_JIMUTETUZUKINM = new Item("sihubikaisyou", "selectDataList", "jimutetuzukinm", null, ErrorMsgKbn.DD);

    static final Item DDID_SELECTDATALIST_JIMUSTARTYMD = new Item("sihubikaisyou", "selectDataList", "jimustartymd", null, ErrorMsgKbn.DD);

    static final Item DDID_SELECTDATALIST_NYUURYOKULINK = new Item("sihubikaisyou", "selectDataList", "nyuuryokuLink", null, ErrorMsgKbn.DD);

    static final Item DDID_SELECTDATALIST_SKNO = new Item("sihubikaisyou", "selectDataList", "skno", null, ErrorMsgKbn.DD);

    static final Item DDID_SYORUIINFOLIST_SYORUITTYKYMDTIME = new Item("sihubikaisyou", "syoruiInfoList", "syoruittykymdtime", null, ErrorMsgKbn.DD);

    static final Item DDID_SYORUIINFOLIST_SYORUINM = new Item("sihubikaisyou", "syoruiInfoList", "syoruinm", null, ErrorMsgKbn.DD);

    static final Item DDID_SYORUIINFOLIST_HTYSYORUIUMUKBN = new Item("sihubikaisyou", "syoruiInfoList", "htysyoruiumukbn", null, ErrorMsgKbn.DISP);

    static final Item DDID_SYORUIINFOLIST_HYOUJILINK = new Item("sihubikaisyou", "syoruiInfoList", "hyoujilink", null, ErrorMsgKbn.DD);

    static final Item DDID_SYORUIINFOLIST_HYOUJILINKFLG = new Item("sihubikaisyou", "syoruiInfoList", "hyoujilinkflg", null, ErrorMsgKbn.DD);

    static final Item DDID_SYORUIINFOLIST_IMAGEID = new Item("sihubikaisyou", "syoruiInfoList", "imageid", null, ErrorMsgKbn.DD);

    static final Item DDID_BUTTONALLHYOUJI_ALLHYOUJIBTN = new Item("sihubikaisyou", "buttonAllhyouji", "allhyoujibtn", null, ErrorMsgKbn.DD);

    static final Item DDID_HIDDENGROUP_IMAGEID = new Item("sihubikaisyou", "hiddenGroup", "imageid", null, ErrorMsgKbn.DD);

    static final Item DDID_PROGRESSHISTORYINFO_VPRGHSDISPSYORIYMD = new Item("sihubikaisyou", "progresshistoryinfo", "vprghsdispsyoriymd", null, ErrorMsgKbn.DD);

    static final Item DDID_PROGRESSHISTORYINFO_VPRGHSDISPTASKNM = new Item("sihubikaisyou", "progresshistoryinfo", "vprghsdisptasknm", null, ErrorMsgKbn.DD);

    static final Item DDID_PROGRESSHISTORYINFO_VPRGHSDISPSYORIKEKKAKBN = new Item("sihubikaisyou", "progresshistoryinfo", "vprghsdispsyorikekkakbn", null, ErrorMsgKbn.DD);

    static final Item DDID_PROGRESSHISTORYINFO_VPRGHSDISPSOUSASYANM = new Item("sihubikaisyou", "progresshistoryinfo", "vprghsdispsousasyanm", null, ErrorMsgKbn.DD);

    static final Item DDID_PROGRESSHISTORYINFO_VPRGHSDISPCOMMENT = new Item("sihubikaisyou", "progresshistoryinfo", "vprghsdispcomment", null, ErrorMsgKbn.DD);

    static final Item DDID_KAISYOUZUMIHUBILIST_COMMONCHECKBOX = new Item("sihubikaisyou", "kaisyouzumihubiList", "commonCheckBox", null, ErrorMsgKbn.DISP);

    static final Item DDID_KAISYOUZUMIHUBILIST_TRKYMD = new Item("sihubikaisyou", "kaisyouzumihubiList", "trkymd", null, ErrorMsgKbn.DD);

    static final Item DDID_KAISYOUZUMIHUBILIST_HUBINAIYOUMSG = new Item("sihubikaisyou", "kaisyouzumihubiList", "hubinaiyoumsg", null, ErrorMsgKbn.DD);

    static final Item DDID_KAISYOUZUMIHUBILIST_GENPONHNKYKUMUCHKBOX = new Item("sihubikaisyou", "kaisyouzumihubiList", "genponhnkykumuchkbox", null, ErrorMsgKbn.DD);

    static final Item DDID_KAISYOUZUMIHUBILIST_HASINYMD = new Item("sihubikaisyou", "kaisyouzumihubiList", "hasinymd", null, ErrorMsgKbn.DD);

    static final Item DDID_KAISYOUZUMIHUBILIST_HASSINSAKIKBN = new Item("sihubikaisyou", "kaisyouzumihubiList", "hassinsakikbn", null, ErrorMsgKbn.DD);

    static final Item DDID_KAISYOUZUMIHUBILIST_NYUURYOKUTANTOUNM = new Item("sihubikaisyou", "kaisyouzumihubiList", "nyuuryokutantounm", null, ErrorMsgKbn.DD);

    static final Item DDID_KAISYOUZUMIHUBILIST_KAISYOUYMD = new Item("sihubikaisyou", "kaisyouzumihubiList", "kaisyouymd", null, ErrorMsgKbn.DD);

    static final Item DDID_KAISYOUZUMIHUBILIST_SYOUNINTANTOUNM = new Item("sihubikaisyou", "kaisyouzumihubiList", "syounintantounm", null, ErrorMsgKbn.DD);

    static final Item DDID_BUTTONALLCONTROL_ALLCHECKBTN = new Item("sihubikaisyou", "buttonAllcontrol", "allCheckBtn", null, ErrorMsgKbn.DD);

    static final Item DDID_BUTTONALLCONTROL_ALLUNCHECKBTN = new Item("sihubikaisyou", "buttonAllcontrol", "allUnCheckBtn", null, ErrorMsgKbn.DD);

    static final Item DDID_MIKAISYOUHUBILIST1_COMMONCHECKBOX = new Item("sihubikaisyou", "mikaisyouhubiList1", "commonCheckBox", null, ErrorMsgKbn.DISP);

    static final Item DDID_MIKAISYOUHUBILIST1_TRKYMD = new Item("sihubikaisyou", "mikaisyouhubiList1", "trkymd", null, ErrorMsgKbn.DD);

    static final Item DDID_MIKAISYOUHUBILIST1_DISPHUBINAIYOUMSG = new Item("sihubikaisyou", "mikaisyouhubiList1", "disphubinaiyoumsg", null, ErrorMsgKbn.DD);

    static final Item DDID_MIKAISYOUHUBILIST1_DISPGENPONHNKYKUMUCHKBOX = new Item("sihubikaisyou", "mikaisyouhubiList1", "dispgenponhnkykumuchkbox", null, ErrorMsgKbn.DD);

    static final Item DDID_MIKAISYOUHUBILIST1_DISPHASSINYMD = new Item("sihubikaisyou", "mikaisyouhubiList1", "disphassinymd", null, ErrorMsgKbn.DD);

    static final Item DDID_MIKAISYOUHUBILIST1_DISPHASSINSAKIKBN = new Item("sihubikaisyou", "mikaisyouhubiList1", "disphassinsakikbn", null, ErrorMsgKbn.DD);

    static final Item DDID_MIKAISYOUHUBILIST1_DISPNYURYOKUTANTOUNM = new Item("sihubikaisyou", "mikaisyouhubiList1", "dispnyuryokutantounm", null, ErrorMsgKbn.DD);

    static final Item DDID_MIKAISYOUHUBILIST1_DISPKAISYOUYMD = new Item("sihubikaisyou", "mikaisyouhubiList1", "dispkaisyouymd", null, ErrorMsgKbn.DD);

    static final Item DDID_MIKAISYOUHUBILIST1_DISPSYOUNINTANTOUNM = new Item("sihubikaisyou", "mikaisyouhubiList1", "dispsyounintantounm", null, ErrorMsgKbn.DD);

    static final Item DDID_RENRAKURAN_RENRAKUAREA = new Item("sihubikaisyou", "renrakuran", "renrakuarea", null, ErrorMsgKbn.DD);

    static final Item DDID_KEKKAINPUT_SYORIKEKKAKBN = new Item("sihubikaisyou", "kekkaInput", "syorikekkakbn", null, ErrorMsgKbn.DD);

    static final Item DDID_KEKKAINPUT_TENNOUSAKISOUSASYACD = new Item("sihubikaisyou", "kekkaInput", "tennousakisousasyacd", null, ErrorMsgKbn.DD);

    static final Item DDID_KEKKAINPUT_SYANAICOMMENT = new Item("sihubikaisyou", "kekkaInput", "syanaicomment", null, ErrorMsgKbn.DD);

    static final Item DDID_FOOTERBUTTONS2_MODORUBTNBYITIRANSENTAKU = new Item("sihubikaisyou", "footerButtons2", "modorubtnbyitiransentaku", null, ErrorMsgKbn.DD);

    static final Item DDID_FOOTERBUTTONS3_MODORUBTNBYINPUTCONTENTS = new Item("sihubikaisyou", "footerButtons3", "modoruBtnByInputContents", null, ErrorMsgKbn.DD);

    static final Item DDID_FOOTERBUTTONS4_MODORUBTNBYCONFIRM = new Item("sihubikaisyou", "footerButtons4", "modoruBtnByConfirm", null, ErrorMsgKbn.DD);

    static final Item DDID_FOOTERBUTTONS4_KAKUTEIBTN = new Item("sihubikaisyou", "footerButtons4", "kakuteiBtn", null, ErrorMsgKbn.DD);

    static final Item DDID_FOOTERBUTTONS5_SYOKIGAMENHEBTN = new Item("sihubikaisyou", "footerButtons5", "syokigamenheBtn", null, ErrorMsgKbn.DD);
}
