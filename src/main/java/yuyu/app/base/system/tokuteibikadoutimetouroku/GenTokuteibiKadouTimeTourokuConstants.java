package yuyu.app.base.system.tokuteibikadoutimetouroku;

import jp.co.slcs.swak.bizinfr.configuration.Item;
import jp.co.slcs.swak.bizinfr.configuration.Item.ErrorMsgKbn;

/**
 * 特定日稼働時間登録 画面項目ID定義のベースクラスです。<br />
 * このソースはツールによる自動生成で、画面項目定義の変更に連動して更新されます。
 * 手書きコードを加えてはいけません。
 */
public class GenTokuteibiKadouTimeTourokuConstants {

    public static final int PAGENO_INIT          = 1;

    public static final int PAGENO_SELECTDATA    = 1;

    public static final int PAGENO_INPUTCONTENTS = 2;

    public static final int PAGENO_CONFIRM       = 3;

    public static final int PAGENO_RESULT        = 4;

    static final String FORWARDNAME_INIT          = "init";

    static final String FORWARDNAME_CURRENT       = "current";

    static final String FORWARDNAME_SELECTDATA    = "selectData";

    static final String FORWARDNAME_INPUTCONTENTS = "inputContents";

    static final String FORWARDNAME_CONFIRM       = "confirm";

    static final String FORWARDNAME_RESULT        = "result";

    static final Item DDID_HEADERBUTTONS_TOJIRUBTN = new Item("tokuteibikadoutimetouroku", "headerButtons", "tojiruBtn", null, ErrorMsgKbn.DD);

    static final Item DDID_KEYINFO_KADOUTIMESITEIYMD = new Item("tokuteibikadoutimetouroku", "keyInfo", "kadouTimeSiteiYmd", "tokuteibiKadouTime", ErrorMsgKbn.DISP);

    static final Item DDID_KADOUTIMEGROUPLIST_COMMONCHECKBOX = new Item("tokuteibikadoutimetouroku", "kadouTimeGroupList", "commonCheckBox", null, ErrorMsgKbn.DISP);

    static final Item DDID_KADOUTIMEGROUPLIST_KADOUTIMEGROUPCD = new Item("tokuteibikadoutimetouroku", "kadouTimeGroupList", "kadouTimeGroupCd", null, ErrorMsgKbn.DISP);

    static final Item DDID_KADOUTIMEGROUPLIST_KADOUTIMEGROUPNM = new Item("tokuteibikadoutimetouroku", "kadouTimeGroupList", "kadouTimeGroupNm", null, ErrorMsgKbn.DISP);

    static final Item DDID_KADOUTIMEGROUPLIST_KADOUTIMEGROUPDESCRIPTION = new Item("tokuteibikadoutimetouroku", "kadouTimeGroupList", "kadouTimeGroupDescription", null, ErrorMsgKbn.DISP);

    static final Item DDID_TOKUTEIBIKADOUTIMESELECTLIST_KADOUTIMEGROUPCD = new Item("tokuteibikadoutimetouroku", "tokuteibiKadouTimeSelectList", "kadouTimeGroupCd", null, ErrorMsgKbn.DISP);

    static final Item DDID_TOKUTEIBIKADOUTIMESELECTLIST_KADOUTIMEGROUPNM = new Item("tokuteibikadoutimetouroku", "tokuteibiKadouTimeSelectList", "kadouTimeGroupNm", null, ErrorMsgKbn.DISP);

    static final Item DDID_TOKUTEIBIKADOUTIMESELECTLIST_KADOUTIMESITEIYMD = new Item("tokuteibikadoutimetouroku", "tokuteibiKadouTimeSelectList", "kadouTimeSiteiYmd", null, ErrorMsgKbn.DISP);

    static final Item DDID_TOKUTEIBIKADOUTIMESELECTLIST_KADOUTIMEDISP = new Item("tokuteibikadoutimetouroku", "tokuteibiKadouTimeSelectList", "kadouTimeDisp", null, ErrorMsgKbn.DISP);

    static final Item DDID_TOKUTEIBIKADOUTIMESELECTLIST_HENKOULINK = new Item("tokuteibikadoutimetouroku", "tokuteibiKadouTimeSelectList", "henkouLink", null, ErrorMsgKbn.DD);

    static final Item DDID_TOKUTEIBIKADOUTIMESELECTLIST_SAKUJYOLINK = new Item("tokuteibikadoutimetouroku", "tokuteibiKadouTimeSelectList", "sakujyoLink", null, ErrorMsgKbn.DD);

    static final Item DDID_TOKUTEIBIKADOUTIMEINFO_KADOUTIMESITEIKBN = new Item("tokuteibikadoutimetouroku", "tokuteibiKadouTimeInfo", "kadouTimeSiteiKbn", "tokuteibiKadouTime", ErrorMsgKbn.DD);

    static final Item DDID_TOKUTEIBIKADOUTIMEINFO_KADOUTIMEFROM1 = new Item("tokuteibikadoutimetouroku", "tokuteibiKadouTimeInfo", "kadouTimeFrom1", "tokuteibiKadouTime", ErrorMsgKbn.ERROR);

    static final Item DDID_TOKUTEIBIKADOUTIMEINFO_KADOUTIMETO1 = new Item("tokuteibikadoutimetouroku", "tokuteibiKadouTimeInfo", "kadouTimeTo1", "tokuteibiKadouTime", ErrorMsgKbn.ERROR);

    static final Item DDID_TOKUTEIBIKADOUTIMEINFO_KADOUTIMEFROM2 = new Item("tokuteibikadoutimetouroku", "tokuteibiKadouTimeInfo", "kadouTimeFrom2", "tokuteibiKadouTime", ErrorMsgKbn.ERROR);

    static final Item DDID_TOKUTEIBIKADOUTIMEINFO_KADOUTIMETO2 = new Item("tokuteibikadoutimetouroku", "tokuteibiKadouTimeInfo", "kadouTimeTo2", "tokuteibiKadouTime", ErrorMsgKbn.ERROR);

    static final Item DDID_TOKUTEIBIKADOUTIMEINFO_KADOUTIMEFROM3 = new Item("tokuteibikadoutimetouroku", "tokuteibiKadouTimeInfo", "kadouTimeFrom3", "tokuteibiKadouTime", ErrorMsgKbn.ERROR);

    static final Item DDID_TOKUTEIBIKADOUTIMEINFO_KADOUTIMETO3 = new Item("tokuteibikadoutimetouroku", "tokuteibiKadouTimeInfo", "kadouTimeTo3", "tokuteibiKadouTime", ErrorMsgKbn.ERROR);

    static final Item DDID_TOKUTEIBIKADOUTIMEINFO_KADOUTIMEFROM4 = new Item("tokuteibikadoutimetouroku", "tokuteibiKadouTimeInfo", "kadouTimeFrom4", "tokuteibiKadouTime", ErrorMsgKbn.ERROR);

    static final Item DDID_TOKUTEIBIKADOUTIMEINFO_KADOUTIMETO4 = new Item("tokuteibikadoutimetouroku", "tokuteibiKadouTimeInfo", "kadouTimeTo4", "tokuteibiKadouTime", ErrorMsgKbn.ERROR);

    static final Item DDID_TOKUTEIBIKADOUTIMEINFO_KADOUTIMEFROM5 = new Item("tokuteibikadoutimetouroku", "tokuteibiKadouTimeInfo", "kadouTimeFrom5", "tokuteibiKadouTime", ErrorMsgKbn.ERROR);

    static final Item DDID_TOKUTEIBIKADOUTIMEINFO_KADOUTIMETO5 = new Item("tokuteibikadoutimetouroku", "tokuteibiKadouTimeInfo", "kadouTimeTo5", "tokuteibiKadouTime", ErrorMsgKbn.ERROR);

    static final Item DDID_BUTTONINPUTCONTENTS_MODORUBTNBYINPUTCONTENTS = new Item("tokuteibikadoutimetouroku", "buttonInputContents", "modoruBtnByInputContents", null, ErrorMsgKbn.DD);

    static final Item DDID_BUTTONINPUTCONTENTS_MODORUBTNBYCONFIRM = new Item("tokuteibikadoutimetouroku", "buttonInputContents", "modoruBtnByConfirm", null, ErrorMsgKbn.DD);
}
