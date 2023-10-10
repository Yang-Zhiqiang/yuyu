package yuyu.app.base.system.kadoutimetouroku;

import jp.co.slcs.swak.bizinfr.configuration.Item;
import jp.co.slcs.swak.bizinfr.configuration.Item.ErrorMsgKbn;

/**
 * 稼働時間登録 画面項目ID定義のベースクラスです。<br />
 * このソースはツールによる自動生成で、画面項目定義の変更に連動して更新されます。
 * 手書きコードを加えてはいけません。
 */
public class GenKadouTimeTourokuConstants {

    public static final int PAGENO_INIT          = 1;

    public static final int PAGENO_SELECTDATA    = 1;

    public static final int PAGENO_SELECTKEY     = 2;

    public static final int PAGENO_INPUTCONTENTS = 3;

    public static final int PAGENO_CONFIRM       = 4;

    public static final int PAGENO_RESULT        = 5;

    static final String FORWARDNAME_INIT          = "init";

    static final String FORWARDNAME_SELECTDATA    = "selectData";

    static final String FORWARDNAME_SELECTKEY     = "selectKey";

    static final String FORWARDNAME_INPUTCONTENTS = "inputContents";

    static final String FORWARDNAME_CONFIRM       = "confirm";

    static final String FORWARDNAME_RESULT        = "result";

    static final Item DDID_HEADERBUTTONS_TOJIRUBTN = new Item("kadoutimetouroku", "headerButtons", "tojiruBtn", null, ErrorMsgKbn.DD);

    static final Item DDID_KEYINFO_KADOUTIMEGROUPCD = new Item("kadoutimetouroku", "keyInfo", "kadouTimeGroupCd", null, ErrorMsgKbn.DD);

    static final Item DDID_KEYINFO_KADOUTIMEGROUPNM = new Item("kadoutimetouroku", "keyInfo", "kadouTimeGroupNm", null, ErrorMsgKbn.DD);

    static final Item DDID_KEYINFO_KADOUTIMEGROUPDESCRIPTION = new Item("kadoutimetouroku", "keyInfo", "kadouTimeGroupDescription", null, ErrorMsgKbn.DISP);

    static final Item DDID_KADOUTIMEGROUPINFO_KADOUTIMEGROUPCD = new Item("kadoutimetouroku", "kadouTimeGroupInfo", "kadouTimeGroupCd", "kadouTimeGroup", ErrorMsgKbn.DD);

    static final Item DDID_KADOUTIMEGROUPINFO_KADOUTIMEGROUPNM = new Item("kadoutimetouroku", "kadouTimeGroupInfo", "kadouTimeGroupNm", "kadouTimeGroup", ErrorMsgKbn.DD);

    static final Item DDID_KADOUTIMEGROUPINFO_HOLIDAYGROUPNM = new Item("kadoutimetouroku", "kadouTimeGroupInfo", "holidayGroupNm", "holidayGroup", ErrorMsgKbn.DD);

    static final Item DDID_KADOUTIMEGROUPINFO_KADOUTIMEGROUPDESCRIPTION = new Item("kadoutimetouroku", "kadouTimeGroupInfo", "kadouTimeGroupDescription", "kadouTimeGroup", ErrorMsgKbn.DISP);

    static final Item DDID_EIGYOUBIKADOUTIMEINFO_EIGYOUKADOUTIMEYOUBIKBN = new Item("kadoutimetouroku", "eigyoubiKadouTimeInfo", "eigyouKadouTimeYoubiKbn", null, ErrorMsgKbn.DISP);

    static final Item DDID_EIGYOUBIKADOUTIMEINFO_KADOUTIMESITEIKBN = new Item("kadoutimetouroku", "eigyoubiKadouTimeInfo", "kadouTimeSiteiKbn", null, ErrorMsgKbn.DISP);

    static final Item DDID_EIGYOUBIKADOUTIMEINFO_EIGYOUKADOUTIME = new Item("kadoutimetouroku", "eigyoubiKadouTimeInfo", "eigyouKadouTime", null, ErrorMsgKbn.DISP);

    static final Item DDID_EIGYOUBIKADOUTIMEINFO_HENKOUEIGYOUBILINK = new Item("kadoutimetouroku", "eigyoubiKadouTimeInfo", "henkouEigyoubiLink", null, ErrorMsgKbn.DD);

    static final Item DDID_HIEIGYOUBIKADOUTIMEINFO_HIEIGYOUKADOUTIMEYOUBIKBN = new Item("kadoutimetouroku", "hiEigyoubiKadouTimeInfo", "hiEigyouKadouTimeYoubiKbn", null, ErrorMsgKbn.DISP);

    static final Item DDID_HIEIGYOUBIKADOUTIMEINFO_KADOUTIMESITEIKBN = new Item("kadoutimetouroku", "hiEigyoubiKadouTimeInfo", "kadouTimeSiteiKbn", null, ErrorMsgKbn.DISP);

    static final Item DDID_HIEIGYOUBIKADOUTIMEINFO_HIEIGYOUKADOUTIME = new Item("kadoutimetouroku", "hiEigyoubiKadouTimeInfo", "hiEigyouKadouTime", null, ErrorMsgKbn.DISP);

    static final Item DDID_HIEIGYOUBIKADOUTIMEINFO_HENKOUHIEIGYOUBILINK = new Item("kadoutimetouroku", "hiEigyoubiKadouTimeInfo", "henkouHieigyoubiLink", null, ErrorMsgKbn.DD);

    static final Item DDID_KADOUTIMEINFO_KADOUTIMEYOUBIKBN = new Item("kadoutimetouroku", "kadouTimeInfo", "kadouTimeYoubiKbn", "kadouTime", ErrorMsgKbn.DISP);

    static final Item DDID_KADOUTIMEINFO_EIGYOUBIKBN = new Item("kadoutimetouroku", "kadouTimeInfo", "eigyoubiKbn", "kadouTime", ErrorMsgKbn.DD);

    static final Item DDID_KADOUTIMEINFO_HYOUJUNKADOUTIMEINFO = new Item("kadoutimetouroku", "kadouTimeInfo", "hyoujunKadouTimeInfo", null, ErrorMsgKbn.DISP);

    static final Item DDID_KADOUTIMEINFOINPUT_KADOUTIMESITEIKBN = new Item("kadoutimetouroku", "kadouTimeInfoInput", "kadouTimeSiteiKbn", "kadouTime", ErrorMsgKbn.DD);

    static final Item DDID_KADOUTIMEINFOINPUT_KADOUTIMEFROM1 = new Item("kadoutimetouroku", "kadouTimeInfoInput", "kadouTimeFrom1", "kadouTime", ErrorMsgKbn.ERROR);

    static final Item DDID_KADOUTIMEINFOINPUT_KADOUTIMETO1 = new Item("kadoutimetouroku", "kadouTimeInfoInput", "kadouTimeTo1", "kadouTime", ErrorMsgKbn.ERROR);

    static final Item DDID_KADOUTIMEINFOINPUT_KADOUTIMEFROM2 = new Item("kadoutimetouroku", "kadouTimeInfoInput", "kadouTimeFrom2", "kadouTime", ErrorMsgKbn.ERROR);

    static final Item DDID_KADOUTIMEINFOINPUT_KADOUTIMETO2 = new Item("kadoutimetouroku", "kadouTimeInfoInput", "kadouTimeTo2", "kadouTime", ErrorMsgKbn.ERROR);

    static final Item DDID_KADOUTIMEINFOINPUT_KADOUTIMEFROM3 = new Item("kadoutimetouroku", "kadouTimeInfoInput", "kadouTimeFrom3", "kadouTime", ErrorMsgKbn.ERROR);

    static final Item DDID_KADOUTIMEINFOINPUT_KADOUTIMETO3 = new Item("kadoutimetouroku", "kadouTimeInfoInput", "kadouTimeTo3", "kadouTime", ErrorMsgKbn.ERROR);

    static final Item DDID_KADOUTIMEINFOINPUT_KADOUTIMEFROM4 = new Item("kadoutimetouroku", "kadouTimeInfoInput", "kadouTimeFrom4", "kadouTime", ErrorMsgKbn.ERROR);

    static final Item DDID_KADOUTIMEINFOINPUT_KADOUTIMETO4 = new Item("kadoutimetouroku", "kadouTimeInfoInput", "kadouTimeTo4", "kadouTime", ErrorMsgKbn.ERROR);

    static final Item DDID_KADOUTIMEINFOINPUT_KADOUTIMEFROM5 = new Item("kadoutimetouroku", "kadouTimeInfoInput", "kadouTimeFrom5", "kadouTime", ErrorMsgKbn.ERROR);

    static final Item DDID_KADOUTIMEINFOINPUT_KADOUTIMETO5 = new Item("kadoutimetouroku", "kadouTimeInfoInput", "kadouTimeTo5", "kadouTime", ErrorMsgKbn.ERROR);

    static final Item DDID_BUTTONINPUTCONTENTS_MODORUBTNBYSELECTKEY = new Item("kadoutimetouroku", "buttonInputContents", "modoruBtnBySelectKey", null, ErrorMsgKbn.DISP);

    static final Item DDID_BUTTONINPUTCONTENTS_MODORUBTNBYINPUTCONTENTS = new Item("kadoutimetouroku", "buttonInputContents", "modoruBtnByInputContents", null, ErrorMsgKbn.DISP);

    static final Item DDID_BUTTONINPUTCONTENTS_MODORUBTNBYCONFIRM = new Item("kadoutimetouroku", "buttonInputContents", "modoruBtnByConfirm", null, ErrorMsgKbn.DISP);
}
