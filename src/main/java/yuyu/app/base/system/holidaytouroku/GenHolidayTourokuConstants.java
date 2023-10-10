package yuyu.app.base.system.holidaytouroku;

import jp.co.slcs.swak.bizinfr.configuration.Item;
import jp.co.slcs.swak.bizinfr.configuration.Item.ErrorMsgKbn;

/**
 * 休日登録 画面項目ID定義のベースクラスです。<br />
 * このソースはツールによる自動生成で、画面項目定義の変更に連動して更新されます。
 * 手書きコードを加えてはいけません。
 */
public class GenHolidayTourokuConstants {

    public static final int PAGENO_INIT          = 1;

    public static final int PAGENO_SELECTDATA    = 1;

    public static final int PAGENO_SELECTKEY     = 2;

    public static final int PAGENO_INPUTCONTENTS = 3;

    public static final int PAGENO_CONFIRM       = 4;

    public static final int PAGENO_RESULT        = 5;

    static final String FORWARDNAME_INIT          = "init";

    static final String FORWARDNAME_CURRENT       = "current";

    static final String FORWARDNAME_SELECTDATA    = "selectData";

    static final String FORWARDNAME_SELECTKEY     = "selectKey";

    static final String FORWARDNAME_INPUTCONTENTS = "inputContents";

    static final String FORWARDNAME_CONFIRM       = "confirm";

    static final String FORWARDNAME_RESULT        = "result";

    static final Item DDID_HEADERBUTTONS_TOJIRUBTN = new Item("holidaytouroku", "headerButtons", "tojiruBtn", null, ErrorMsgKbn.DD);

    static final Item DDID_KEYINFO_HOLIDAYGROUPCD = new Item("holidaytouroku", "keyInfo", "holidayGroupCd", null, ErrorMsgKbn.DD);

    static final Item DDID_KEYINFO_HOLIDAYGROUPNM = new Item("holidaytouroku", "keyInfo", "holidayGroupNm", null, ErrorMsgKbn.DD);

    static final Item DDID_KEYINFO_HOLIDAYGROUPDESCRIPTION = new Item("holidaytouroku", "keyInfo", "holidayGroupDescription", null, ErrorMsgKbn.DISP);

    static final Item DDID_HOLIDAYGROUPINFO_HOLIDAYGROUPCD = new Item("holidaytouroku", "holidayGroupInfo", "holidayGroupCd", "holidayGroup", ErrorMsgKbn.DD);

    static final Item DDID_HOLIDAYGROUPINFO_HOLIDAYGROUPNM = new Item("holidaytouroku", "holidayGroupInfo", "holidayGroupNm", "holidayGroup", ErrorMsgKbn.DD);

    static final Item DDID_HOLIDAYGROUPINFO_HOLIDAYGROUPDESCRIPTION = new Item("holidaytouroku", "holidayGroupInfo", "holidayGroupDescription", "holidayGroup", ErrorMsgKbn.DISP);

    static final Item DDID_HOLIDAYPATTERN_HOLIDAYPATTERNNM = new Item("holidaytouroku", "holidayPattern", "holidayPatternNm", "holidayYoyaku", ErrorMsgKbn.DISP);

    static final Item DDID_HOLIDAYPATTERN_HOLIDAYPATTERN = new Item("holidaytouroku", "holidayPattern", "holidayPattern", "holidayYoyaku", ErrorMsgKbn.DD);

    static final Item DDID_HOLIDAYPATTERNINFO_HOLIDAYPATTERNNM = new Item("holidaytouroku", "holidayPatternInfo", "holidayPatternNm", null, ErrorMsgKbn.DISP);

    static final Item DDID_HOLIDAYPATTERNINFO_HOLIDAYPATTERN = new Item("holidaytouroku", "holidayPatternInfo", "holidayPattern", null, ErrorMsgKbn.DD);

    static final Item DDID_HOLIDAYPATTERNINFO_TEKIYOUYMDFROM = new Item("holidaytouroku", "holidayPatternInfo", "tekiyouYmdFrom", null, ErrorMsgKbn.DISP);

    static final Item DDID_HOLIDAYPATTERNINFO_TEKIYOUYMDTO = new Item("holidaytouroku", "holidayPatternInfo", "tekiyouYmdTo", null, ErrorMsgKbn.DISP);

    static final Item DDID_HOLIDAYPATTERNINFO_LEGALHOLIDAYKBN = new Item("holidaytouroku", "holidayPatternInfo", "legalHolidayKbn", null, ErrorMsgKbn.DD);

    static final Item DDID_HOLIDAYPATTERNINFO_YOYAKUKBN = new Item("holidaytouroku", "holidayPatternInfo", "yoyakuKbn", null, ErrorMsgKbn.DD);

    static final Item DDID_HOLIDAYPATTERNINFO_HENKOULINK = new Item("holidaytouroku", "holidayPatternInfo", "henkouLink", null, ErrorMsgKbn.DD);

    static final Item DDID_HOLIDAYPATTERNINFO_SAKUJYOLINK = new Item("holidaytouroku", "holidayPatternInfo", "sakujyoLink", null, ErrorMsgKbn.DD);

    static final Item DDID_HOLIDAYPATTERNINFOINPUT_TEKIYOUYMDFROM = new Item("holidaytouroku", "holidayPatternInfoInput", "tekiyouYmdFrom", "holidayYoyaku", ErrorMsgKbn.DISP);

    static final Item DDID_HOLIDAYPATTERNINFOINPUT_TEKIYOUYMDTO = new Item("holidaytouroku", "holidayPatternInfoInput", "tekiyouYmdTo", "holidayYoyaku", ErrorMsgKbn.DISP);

    static final Item DDID_HOLIDAYPATTERNINFOINPUT_HOLIDAYGROUPCD = new Item("holidaytouroku", "holidayPatternInfoInput", "holidayGroupCd", null, ErrorMsgKbn.DISP);

    static final Item DDID_HOLIDAYPATTERNINFOINPUT_HOLIDAYYMD = new Item("holidaytouroku", "holidayPatternInfoInput", "holidayYmd", null, ErrorMsgKbn.DISP);

    static final Item DDID_HOLIDAYPATTERNINFOINPUT_HOLIDAYMD = new Item("holidaytouroku", "holidayPatternInfoInput", "holidayMd", null, ErrorMsgKbn.DISP);

    static final Item DDID_HOLIDAYPATTERNINFOINPUT_HOLIDAYM = new Item("holidaytouroku", "holidayPatternInfoInput", "holidayM", null, ErrorMsgKbn.ERROR);

    static final Item DDID_HOLIDAYPATTERNINFOINPUT_HOLIDAYNTH = new Item("holidaytouroku", "holidayPatternInfoInput", "holidayNth", null, ErrorMsgKbn.ERROR);

    static final Item DDID_HOLIDAYPATTERNINFOINPUT_HOLIDAYSITEIYOUBI = new Item("holidaytouroku", "holidayPatternInfoInput", "holidaySiteiYoubi", null, ErrorMsgKbn.ERROR);

    static final Item DDID_HOLIDAYPATTERNINFOINPUT_HOLIDAYYOUBI = new Item("holidaytouroku", "holidayPatternInfoInput", "holidayYoubi", null, ErrorMsgKbn.DISP);

    static final Item DDID_HOLIDAYPATTERNINFOINPUT_LEGALHOLIDAYKBN = new Item("holidaytouroku", "holidayPatternInfoInput", "legalHolidayKbn", "holidayYoyaku", ErrorMsgKbn.DD);

    static final Item DDID_HOLIDAYPATTERNINFOINPUT_HOLIDAYPATTERNDESCRIPTION = new Item("holidaytouroku", "holidayPatternInfoInput", "holidayPatternDescription", "holidayYoyaku", ErrorMsgKbn.DISP);

    static final Item DDID_BUTTONINPUTCONTENTS_MODORUBTNBYSELECTKEY = new Item("holidaytouroku", "buttonInputContents", "modoruBtnBySelectKey", null, ErrorMsgKbn.DISP);

    static final Item DDID_BUTTONINPUTCONTENTS_MODORUBTNBYINPUTCONTENTS = new Item("holidaytouroku", "buttonInputContents", "modoruBtnByInputContents", null, ErrorMsgKbn.DISP);

    static final Item DDID_BUTTONINPUTCONTENTS_MODORUBTNBYCONFIRM = new Item("holidaytouroku", "buttonInputContents", "modoruBtnByConfirm", null, ErrorMsgKbn.DISP);
}
