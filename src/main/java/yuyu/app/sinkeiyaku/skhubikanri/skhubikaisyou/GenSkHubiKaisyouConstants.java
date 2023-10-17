package yuyu.app.sinkeiyaku.skhubikanri.skhubikaisyou;

import jp.co.slcs.swak.bizinfr.configuration.Item;
import jp.co.slcs.swak.bizinfr.configuration.Item.ErrorMsgKbn;

/**
 * 新契約不備解消 画面項目ID定義のベースクラスです。<br />
 * このソースはツールによる自動生成で、画面項目定義の変更に連動して更新されます。
 * 手書きコードを加えてはいけません。
 */
public class GenSkHubiKaisyouConstants {

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

    static final Item DDID_HEADERBUTTONS_TOJIRUBTN = new Item("skhubikaisyou", "headerButtons", "tojiruBtn", null, ErrorMsgKbn.DD);

    static final Item DDID_BUTTONMOSJKSYOUKAI_MOSJKSYOUKAIBTN = new Item("skhubikaisyou", "buttonMosJkSyoukai", "mosjksyoukaibtn", null, ErrorMsgKbn.DD);

    static final Item DDID_KOUTEIINFO_VKTIFDISPJIMUTETUZUKINM = new Item("skhubikaisyou", "kouteiInfo", "vktifdispjimutetuzukinm", null, ErrorMsgKbn.DISP);

    static final Item DDID_KOUTEIINFO_VKTIFDISPTASKNM = new Item("skhubikaisyou", "kouteiInfo", "vktifdisptasknm", null, ErrorMsgKbn.DD);

    static final Item DDID_BASEINFO_MOSNO = new Item("skhubikaisyou", "baseInfo", "mosno", null, ErrorMsgKbn.DD);

    static final Item DDID_BASEINFO_CURRENTTSKNM = new Item("skhubikaisyou", "baseInfo", "currenttsknm", null, ErrorMsgKbn.DD);

    static final Item DDID_ITIRANINFO_JIMUTETUZUKINM = new Item("skhubikaisyou", "itiranInfo", "jimutetuzukinm", null, ErrorMsgKbn.DISP);

    static final Item DDID_ITIRANINFO_JIMUSTARTYMD = new Item("skhubikaisyou", "itiranInfo", "jimustartymd", null, ErrorMsgKbn.DISP);

    static final Item DDID_ITIRANINFO_NYUURYOKULINK = new Item("skhubikaisyou", "itiranInfo", "nyuuryokuLink", null, ErrorMsgKbn.DD);

    static final Item DDID_SYORUIINFOLIST_SYORUITTYKYMDTIME = new Item("skhubikaisyou", "syoruiInfoList", "syoruittykymdtime", null, ErrorMsgKbn.DISP);

    static final Item DDID_SYORUIINFOLIST_SYORUINM = new Item("skhubikaisyou", "syoruiInfoList", "syoruinm", null, ErrorMsgKbn.DD);

    static final Item DDID_SYORUIINFOLIST_HTYSYORUIUMUKBN = new Item("skhubikaisyou", "syoruiInfoList", "htysyoruiumukbn", null, ErrorMsgKbn.DISP);

    static final Item DDID_SYORUIINFOLIST_HYOUJILINK = new Item("skhubikaisyou", "syoruiInfoList", "hyoujilink", null, ErrorMsgKbn.DD);

    static final Item DDID_SYORUIINFOLIST_HYOUJILINKFLG = new Item("skhubikaisyou", "syoruiInfoList", "hyoujilinkflg", null, ErrorMsgKbn.DD);

    static final Item DDID_SYORUIINFOLIST_IMAGEID = new Item("skhubikaisyou", "syoruiInfoList", "imageid", null, ErrorMsgKbn.DD);

    static final Item DDID_BUTTONALLHYOUJI_ALLHYOUJIBTN = new Item("skhubikaisyou", "buttonAllhyouji", "allhyoujibtn", null, ErrorMsgKbn.DD);

    static final Item DDID_HIDDENGROUP_IMAGEID = new Item("skhubikaisyou", "hiddenGroup", "imageid", null, ErrorMsgKbn.DD);

    static final Item DDID_TORIATUKAITYUUIINFO_DISPSKEITTDKTYUITRTTRKYMD = new Item("skhubikaisyou", "toriatukaiTyuuiInfo", "dispskeittdktyuitrttrkymd", null, ErrorMsgKbn.DISP);

    static final Item DDID_TORIATUKAITYUUIINFO_DISPSKEITTDKTYUITRTNAIYO = new Item("skhubikaisyou", "toriatukaiTyuuiInfo", "dispskeittdktyuitrtnaiyo", null, ErrorMsgKbn.DISP);

    static final Item DDID_TORIATUKAITYUUIINFO_DISPSKEITTDKTYUITRTTANTOU = new Item("skhubikaisyou", "toriatukaiTyuuiInfo", "dispskeittdktyuitrttantou", null, ErrorMsgKbn.DISP);

    static final Item DDID_HUBILIST_DISPKAISYOUTAISYOU = new Item("skhubikaisyou", "hubiList", "dispkaisyoutaisyou", null, ErrorMsgKbn.DISP);

    static final Item DDID_HUBILIST_DISPKAISYOUTAISYOUKBN = new Item("skhubikaisyou", "hubiList", "dispkaisyoutaisyoukbn", null, ErrorMsgKbn.DISP);

    static final Item DDID_HUBILIST_DISPTRKYMD = new Item("skhubikaisyou", "hubiList", "disptrkymd", null, ErrorMsgKbn.DISP);

    static final Item DDID_HUBILIST_DISPSKHUBIKOUMOKU = new Item("skhubikaisyou", "hubiList", "dispskhubikoumoku", null, ErrorMsgKbn.DISP);

    static final Item DDID_HUBILIST_DISPHASSINYMD = new Item("skhubikaisyou", "hubiList", "disphassinymd", null, ErrorMsgKbn.DISP);

    static final Item DDID_HUBILIST_DISPKAISYOUYMD = new Item("skhubikaisyou", "hubiList", "dispkaisyouymd", null, ErrorMsgKbn.DISP);

    static final Item DDID_HUBILIST_DISPHASSINSAKIKBN = new Item("skhubikaisyou", "hubiList", "disphassinsakikbn", null, ErrorMsgKbn.DISP);

    static final Item DDID_HUBILIST_DISPNYURYOKUTANTOUNM = new Item("skhubikaisyou", "hubiList", "dispnyuryokutantounm", null, ErrorMsgKbn.DISP);

    static final Item DDID_HUBILIST_DISPSKHUBINAIYOU = new Item("skhubikaisyou", "hubiList", "dispskhubinaiyou", null, ErrorMsgKbn.DISP);

    static final Item DDID_HUBILIST_DISPSKSEIBISIJINAIYOU = new Item("skhubikaisyou", "hubiList", "dispskseibisijinaiyou", null, ErrorMsgKbn.DISP);

    static final Item DDID_HUBILIST_DISPSKRENRAKUJIKOU = new Item("skhubikaisyou", "hubiList", "dispskrenrakujikou", null, ErrorMsgKbn.DISP);

    static final Item DDID_COMMENT_COMMENTAREA = new Item("skhubikaisyou", "comment", "commentarea", null, ErrorMsgKbn.DISP);

    static final Item DDID_MOSTENKENTENSOU_MOSTENKENKEKKAKBN = new Item("skhubikaisyou", "mosTenkenTensou", "mostenkenkekkakbn", null, ErrorMsgKbn.DISP);

    static final Item DDID_MOSTENKENTENSOU_MOSTENKENTNSKETSYACD = new Item("skhubikaisyou", "mosTenkenTensou", "mostenkentnsketsyacd", null, ErrorMsgKbn.DISP);

    static final Item DDID_MOSTENKENTENSOU_MOSTENTNSKETSYANM = new Item("skhubikaisyou", "mosTenkenTensou", "mostentnsketsyanm", null, ErrorMsgKbn.DISP);

    static final Item DDID_MOSTENKENTENSOU_MOSTENKENCOMMENTGAMEN = new Item("skhubikaisyou", "mosTenkenTensou", "mostenkencommentgamen", null, ErrorMsgKbn.DISP);

    static final Item DDID_KANKYOUSATEITENSOU_KNKSATEISATEIKEKKA = new Item("skhubikaisyou", "kankyouSateiTensou", "knksateisateikekka", null, ErrorMsgKbn.DISP);

    static final Item DDID_KANKYOUSATEITENSOU_KNKTNSKETSYACD = new Item("skhubikaisyou", "kankyouSateiTensou", "knktnsketsyacd", null, ErrorMsgKbn.DISP);

    static final Item DDID_KANKYOUSATEITENSOU_KNKTNSKETSYANM = new Item("skhubikaisyou", "kankyouSateiTensou", "knktnsketsyanm", null, ErrorMsgKbn.DISP);

    static final Item DDID_KANKYOUSATEITENSOU_KNKSATEICOMMENTGAMEN = new Item("skhubikaisyou", "kankyouSateiTensou", "knksateicommentgamen", null, ErrorMsgKbn.DISP);

    static final Item DDID_IMUSATEITENSOU_IMUSATEISATEIKEKKA = new Item("skhubikaisyou", "imuSateiTensou", "imusateisateikekka", null, ErrorMsgKbn.DISP);

    static final Item DDID_IMUSATEITENSOU_IMUTNSKETSYACD = new Item("skhubikaisyou", "imuSateiTensou", "imutnsketsyacd", null, ErrorMsgKbn.DISP);

    static final Item DDID_IMUSATEITENSOU_IMUTNSKETSYANM = new Item("skhubikaisyou", "imuSateiTensou", "imutnsketsyanm", null, ErrorMsgKbn.DISP);

    static final Item DDID_IMUSATEITENSOU_IMUSATEICOMMENTGAMEN = new Item("skhubikaisyou", "imuSateiTensou", "imusateicommentgamen", null, ErrorMsgKbn.DISP);

    static final Item DDID_FOOTERBUTTONS_MODORUBTNBYITIRANSENTAKU = new Item("skhubikaisyou", "footerButtons", "modorubtnbyitiransentaku", null, ErrorMsgKbn.DD);

    static final Item DDID_FOOTERBUTTONS_MODORUBTNBYINPUTCONTENTS = new Item("skhubikaisyou", "footerButtons", "modoruBtnByInputContents", null, ErrorMsgKbn.DD);

    static final Item DDID_FOOTERBUTTONS_MODORUBTNBYCONFIRM = new Item("skhubikaisyou", "footerButtons", "modoruBtnByConfirm", null, ErrorMsgKbn.DD);

    static final Item DDID_FOOTERBUTTONS_KAKUTEIBTNBYCONFIRM = new Item("skhubikaisyou", "footerButtons", "kakuteibtnbyconfirm", null, ErrorMsgKbn.DD);

    static final Item DDID_FOOTERBUTTONS_SYOKIGAMENHEBTN = new Item("skhubikaisyou", "footerButtons", "syokigamenheBtn", null, ErrorMsgKbn.DD);

    static final Item DDID_FOOTERBUTTONS_SYOKIGAMENHEBTNBYWORKFLOW = new Item("skhubikaisyou", "footerButtons", "syokigamenhebtnbyworkflow", null, ErrorMsgKbn.DD);
}
