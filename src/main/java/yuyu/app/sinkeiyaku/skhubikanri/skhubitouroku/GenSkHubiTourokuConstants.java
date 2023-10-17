package yuyu.app.sinkeiyaku.skhubikanri.skhubitouroku;

import jp.co.slcs.swak.bizinfr.configuration.Item;
import jp.co.slcs.swak.bizinfr.configuration.Item.ErrorMsgKbn;

/**
 * 新契約不備登録 画面項目ID定義のベースクラスです。<br />
 * このソースはツールによる自動生成で、画面項目定義の変更に連動して更新されます。
 * 手書きコードを加えてはいけません。
 */
public class GenSkHubiTourokuConstants {

    public static final int PAGENO_INIT                 = 1;

    public static final int PAGENO_INPUTKEY             = 1;

    public static final int PAGENO_SELECTDATA           = 2;

    public static final int PAGENO_INPUTCONTENTS        = 3;

    public static final int PAGENO_CONFIRM              = 4;

    public static final int PAGENO_RESULT               = 5;

    public static final int PAGENO_TENKEN_INPUTCONTENTS = 6;

    public static final int PAGENO_TENKEN_CONFIRM       = 7;

    static final String FORWARDNAME_INIT                 = "init";

    static final String FORWARDNAME_INPUTKEY             = "InputKey";

    static final String FORWARDNAME_SELECTDATA           = "SelectData";

    static final String FORWARDNAME_INPUTCONTENTS        = "InputContents";

    static final String FORWARDNAME_CONFIRM              = "Confirm";

    static final String FORWARDNAME_RESULT               = "Result";

    static final String FORWARDNAME_BACKTOWORKLIST       = "backToWorkList";

    static final String FORWARDNAME_TENKEN_INPUTCONTENTS = "tenken_InputContents";

    static final String FORWARDNAME_TENKEN_CONFIRM       = "tenken_Confirm";

    static final Item DDID_HEADERBUTTONS_TOJIRUBTN = new Item("skhubitouroku", "headerButtons", "tojiruBtn", null, ErrorMsgKbn.DD);

    static final Item DDID_HEADERBUTTONS_TOJIRUBTNBYINPUTCONTENTS = new Item("skhubitouroku", "headerButtons", "tojirubtnbyinputcontents", null, ErrorMsgKbn.DD);

    static final Item DDID_MOSJKSYOUKAIBUTTONS_MOSJKSYOUKAIBTN = new Item("skhubitouroku", "mosjkSyoukaiButtons", "mosjksyoukaibtn", null, ErrorMsgKbn.DD);

    static final Item DDID_KOUTEIINFO_VKTIFDISPJIMUTETUZUKINM = new Item("skhubitouroku", "kouteiInfo", "vktifdispjimutetuzukinm", null, ErrorMsgKbn.DISP);

    static final Item DDID_KOUTEIINFO_VKTIFDISPTASKNM = new Item("skhubitouroku", "kouteiInfo", "vktifdisptasknm", null, ErrorMsgKbn.DD);

    static final Item DDID_BASEINFO_MOSNO = new Item("skhubitouroku", "baseInfo", "mosno", null, ErrorMsgKbn.DD);

    static final Item DDID_SELECTDATALIST_DISPJIMUTETUZUKINM = new Item("skhubitouroku", "selectDataList", "dispjimutetuzukinm", null, ErrorMsgKbn.DISP);

    static final Item DDID_SELECTDATALIST_DISPJIMUSTARTYMD = new Item("skhubitouroku", "selectDataList", "dispjimustartymd", null, ErrorMsgKbn.DISP);

    static final Item DDID_SELECTDATALIST_NYUURYOKULINK = new Item("skhubitouroku", "selectDataList", "nyuuryokuLink", null, ErrorMsgKbn.DD);

    static final Item DDID_SYORUIINFOLIST_SYORUITTYKYMDTIME = new Item("skhubitouroku", "syoruiInfoList", "syoruittykymdtime", null, ErrorMsgKbn.DISP);

    static final Item DDID_SYORUIINFOLIST_SYORUINM = new Item("skhubitouroku", "syoruiInfoList", "syoruinm", null, ErrorMsgKbn.DISP);

    static final Item DDID_SYORUIINFOLIST_HTYSYORUIUMUKBN = new Item("skhubitouroku", "syoruiInfoList", "htysyoruiumukbn", null, ErrorMsgKbn.DISP);

    static final Item DDID_SYORUIINFOLIST_HYOUJILINK = new Item("skhubitouroku", "syoruiInfoList", "hyoujilink", null, ErrorMsgKbn.DD);

    static final Item DDID_SYORUIINFOLIST_HYOUJILINKFLG = new Item("skhubitouroku", "syoruiInfoList", "hyoujilinkflg", null, ErrorMsgKbn.DD);

    static final Item DDID_SYORUIINFOLIST_IMAGEID = new Item("skhubitouroku", "syoruiInfoList", "imageid", null, ErrorMsgKbn.DD);

    static final Item DDID_BUTTONALLHYOUJI_ALLHYOUJIBTN = new Item("skhubitouroku", "buttonAllhyouji", "allhyoujibtn", null, ErrorMsgKbn.DD);

    static final Item DDID_HIDDENGROUP_IMAGEID = new Item("skhubitouroku", "hiddenGroup", "imageid", null, ErrorMsgKbn.DD);

    static final Item DDID_SEIGYOGROUP_DUMMYKMK1 = new Item("skhubitouroku", "seigyoGroup", "dummykmk1", null, ErrorMsgKbn.DD);

    static final Item DDID_SEIGYOGROUP_DUMMYKMK2 = new Item("skhubitouroku", "seigyoGroup", "dummykmk2", null, ErrorMsgKbn.DD);

    static final Item DDID_SEIGYOGROUP_DUMMYKMK3 = new Item("skhubitouroku", "seigyoGroup", "dummykmk3", null, ErrorMsgKbn.DD);

    static final Item DDID_SEIGYOGROUP_DUMMYKMK4 = new Item("skhubitouroku", "seigyoGroup", "dummykmk4", null, ErrorMsgKbn.DD);

    static final Item DDID_SEIGYOGROUP_DUMMYKMK5 = new Item("skhubitouroku", "seigyoGroup", "dummykmk5", null, ErrorMsgKbn.DD);

    static final Item DDID_SEIGYOGROUP_UNIQUEID2 = new Item("skhubitouroku", "seigyoGroup", "uniqueid2", null, ErrorMsgKbn.DD);

    static final Item DDID_SEIGYOGROUP_HUBITOUROKUMODE = new Item("skhubitouroku", "seigyoGroup", "hubitourokumode", null, ErrorMsgKbn.DD);

    static final Item DDID_TORIATUKAITYUUIINFO_DISPSKEITTDKTYUITRTTRKYMD = new Item("skhubitouroku", "toriatukaiTyuuiInfo", "dispskeittdktyuitrttrkymd", null, ErrorMsgKbn.DISP);

    static final Item DDID_TORIATUKAITYUUIINFO_DISPSKEITTDKTYUITRTNAIYO = new Item("skhubitouroku", "toriatukaiTyuuiInfo", "dispskeittdktyuitrtnaiyo", null, ErrorMsgKbn.DISP);

    static final Item DDID_TORIATUKAITYUUIINFO_DISPSKEITTDKTYUITRTTANTOU = new Item("skhubitouroku", "toriatukaiTyuuiInfo", "dispskeittdktyuitrttantou", null, ErrorMsgKbn.DISP);

    static final Item DDID_HUBILIST1_DISPTRKYMD = new Item("skhubitouroku", "hubiList1", "disptrkymd", null, ErrorMsgKbn.DISP);

    static final Item DDID_HUBILIST1_HUBISYORUICD = new Item("skhubitouroku", "hubiList1", "hubisyoruicd", null, ErrorMsgKbn.DISP);

    static final Item DDID_HUBILIST1_DISPHASSINYMD = new Item("skhubitouroku", "hubiList1", "disphassinymd", null, ErrorMsgKbn.DISP);

    static final Item DDID_HUBILIST1_DISPHASINKYOKAKBN = new Item("skhubitouroku", "hubiList1", "disphasinkyokakbn", null, ErrorMsgKbn.DISP);

    static final Item DDID_HUBILIST1_DISPNYURYOKUTANTOUNM = new Item("skhubitouroku", "hubiList1", "dispnyuryokutantounm", null, ErrorMsgKbn.DISP);

    static final Item DDID_HUBILIST1_DUMMYKMK1 = new Item("skhubitouroku", "hubiList1", "dummykmk1", null, ErrorMsgKbn.DD);

    static final Item DDID_HUBILIST1_DISPSKHUBIKOUMOKU = new Item("skhubitouroku", "hubiList1", "dispskhubikoumoku", null, ErrorMsgKbn.DISP);

    static final Item DDID_HUBILIST1_DISPSKHUBINAIYOU = new Item("skhubitouroku", "hubiList1", "dispskhubinaiyou", null, ErrorMsgKbn.DISP);

    static final Item DDID_HUBILIST1_DISPKAISYOUYMD = new Item("skhubitouroku", "hubiList1", "dispkaisyouymd", null, ErrorMsgKbn.DISP);

    static final Item DDID_HUBILIST1_DISPHASSINSAKIKBN = new Item("skhubitouroku", "hubiList1", "disphassinsakikbn", null, ErrorMsgKbn.DISP);

    static final Item DDID_HUBILIST1_DISPSKSEIBISIJINAIYOU = new Item("skhubitouroku", "hubiList1", "dispskseibisijinaiyou", null, ErrorMsgKbn.DISP);

    static final Item DDID_HUBILIST1_TYOUBUNDISPRENRAKUJIKOU = new Item("skhubitouroku", "hubiList1", "tyoubundisprenrakujikou", null, ErrorMsgKbn.DISP);

    static final Item DDID_HUBILIST2_DISPINPUTTRKYMD = new Item("skhubitouroku", "hubiList2", "dispinputtrkymd", null, ErrorMsgKbn.DISP);

    static final Item DDID_HUBILIST2_HUBISYORUICD = new Item("skhubitouroku", "hubiList2", "hubisyoruicd", null, ErrorMsgKbn.DISP);

    static final Item DDID_HUBILIST2_DUMMYKMK1 = new Item("skhubitouroku", "hubiList2", "dummykmk1", null, ErrorMsgKbn.DISP);

    static final Item DDID_HUBILIST2_DISPINPUTHASINKYOKAKBN = new Item("skhubitouroku", "hubiList2", "dispinputhasinkyokakbn", null, ErrorMsgKbn.DISP);

    static final Item DDID_HUBILIST2_DISPINPUTNYURYOKUTANTOUNM = new Item("skhubitouroku", "hubiList2", "dispinputnyuryokutantounm", null, ErrorMsgKbn.DISP);

    static final Item DDID_HUBILIST2_DISPINPUTTYOUBUNFLG = new Item("skhubitouroku", "hubiList2", "dispinputtyoubunflg", null, ErrorMsgKbn.DD);

    static final Item DDID_HUBILIST2_DISPINPUTSKHUBIKOUMOKU = new Item("skhubitouroku", "hubiList2", "dispinputskhubikoumoku", null, ErrorMsgKbn.DISP);

    static final Item DDID_HUBILIST2_DISPINPUTHUBINAIYOUCD = new Item("skhubitouroku", "hubiList2", "dispinputhubinaiyoucd", null, ErrorMsgKbn.DISP);

    static final Item DDID_HUBILIST2_DUMMYKMK2 = new Item("skhubitouroku", "hubiList2", "dummykmk2", null, ErrorMsgKbn.DISP);

    static final Item DDID_HUBILIST2_DISPINPUTHASSINSAKIKBN = new Item("skhubitouroku", "hubiList2", "dispinputhassinsakikbn", null, ErrorMsgKbn.ERROR);

    static final Item DDID_HUBILIST2_SAKUJYOLINK = new Item("skhubitouroku", "hubiList2", "sakujyoLink", null, ErrorMsgKbn.DD);

    static final Item DDID_HUBILIST2_SAKUJYOFLG = new Item("skhubitouroku", "hubiList2", "sakujyoflg", null, ErrorMsgKbn.DD);

    static final Item DDID_HUBILIST2_DISPINPUTSKSEIBISIJINAIYOU = new Item("skhubitouroku", "hubiList2", "dispinputskseibisijinaiyou", null, ErrorMsgKbn.DISP);

    static final Item DDID_HUBILIST2_TYOUBUNDISPRENRAKUJIKOU = new Item("skhubitouroku", "hubiList2", "tyoubundisprenrakujikou", null, ErrorMsgKbn.DISP);

    static final Item DDID_TUIKABUTTONS_ADDBTN = new Item("skhubitouroku", "tuikaButtons", "addbtn", null, ErrorMsgKbn.DD);

    static final Item DDID_HUBITUUTISAKI_UTDSKKNNM1KJ = new Item("skhubitouroku", "hubituutisaki", "utdskknnm1kj", null, ErrorMsgKbn.DISP);

    static final Item DDID_HUBITUUTISAKI_UTDSKKNNM2KJ = new Item("skhubitouroku", "hubituutisaki", "utdskknnm2kj", null, ErrorMsgKbn.DISP);

    static final Item DDID_HUBITUUTISAKI_TUUTISAKITANTOUNMKJ = new Item("skhubitouroku", "hubituutisaki", "tuutisakitantounmkj", null, ErrorMsgKbn.DISP);

    static final Item DDID_COMMENT_COMMENTAREAGAMEN = new Item("skhubitouroku", "comment", "commentareagamen", null, ErrorMsgKbn.ERROR);

    static final Item DDID_HUBITYOUHYOUSYUTURYOKU_HBTYHYOUTKBN = new Item("skhubitouroku", "hubiTyouhyouSyuturyoku", "hbtyhyoutkbn", null, ErrorMsgKbn.DISP);

    static final Item DDID_HIDDENDATEGROUP_SYORIYMD = new Item("skhubitouroku", "hiddenDateGroup", "syoriYmd", null, ErrorMsgKbn.DD);

    static final Item DDID_HIDDENDATEGROUP_NYUURYOKUTANTOUNM = new Item("skhubitouroku", "hiddenDateGroup", "nyuuryokutantounm", null, ErrorMsgKbn.DD);

    static final Item DDID_FOOTERBUTTONS2_MODORUBTNBYITIRANSENTAKU = new Item("skhubitouroku", "footerButtons2", "modorubtnbyitiransentaku", null, ErrorMsgKbn.DD);

    static final Item DDID_FOOTERBUTTONS3_MODORUBTNBYINPUTCONTENTS = new Item("skhubitouroku", "footerButtons3", "modoruBtnByInputContents", null, ErrorMsgKbn.DD);

    static final Item DDID_FOOTERBUTTONS4_MODORUBTNBYCONFIRM = new Item("skhubitouroku", "footerButtons4", "modoruBtnByConfirm", null, ErrorMsgKbn.DD);

    static final Item DDID_FOOTERBUTTONS4_KAKUTEIBTN = new Item("skhubitouroku", "footerButtons4", "kakuteiBtn", null, ErrorMsgKbn.DD);

    static final Item DDID_FOOTERBUTTONS5_SYOKIGAMENHEBTN = new Item("skhubitouroku", "footerButtons5", "syokigamenheBtn", null, ErrorMsgKbn.DD);

    static final Item DDID_FOOTERBUTTONS5_SYOKIGAMENHEBTNBYWORKFLOW = new Item("skhubitouroku", "footerButtons5", "syokigamenhebtnbyworkflow", null, ErrorMsgKbn.DD);

    static final Item DDID_FOOTERBUTTONS5_TOJIRUBTNBYPOPUP = new Item("skhubitouroku", "footerButtons5", "tojiruBtnByPopup", null, ErrorMsgKbn.DD);
}
