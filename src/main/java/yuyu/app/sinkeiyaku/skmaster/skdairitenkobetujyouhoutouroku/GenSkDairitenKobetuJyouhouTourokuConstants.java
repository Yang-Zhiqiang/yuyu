package yuyu.app.sinkeiyaku.skmaster.skdairitenkobetujyouhoutouroku;

import jp.co.slcs.swak.bizinfr.configuration.Item;
import jp.co.slcs.swak.bizinfr.configuration.Item.ErrorMsgKbn;

/**
 * 代理店個別情報登録 画面項目ID定義のベースクラスです。<br />
 * このソースはツールによる自動生成で、画面項目定義の変更に連動して更新されます。
 * 手書きコードを加えてはいけません。
 */
public class GenSkDairitenKobetuJyouhouTourokuConstants {

    public static final int PAGENO_INIT          = 1;

    public static final int PAGENO_INPUTKEY      = 1;

    public static final int PAGENO_INPUTCONTENTS = 2;

    public static final int PAGENO_CONFIRM       = 3;

    public static final int PAGENO_RESULT        = 4;

    static final String FORWARDNAME_INIT          = "init";

    static final String FORWARDNAME_INPUTKEY      = "InputKey";

    static final String FORWARDNAME_INPUTCONTENTS = "InputContents";

    static final String FORWARDNAME_CONFIRM       = "Confirm";

    static final String FORWARDNAME_RESULT        = "Result";

    static final Item DDID_HEADERBUTTONS_TOJIRUBTN = new Item("skdairitenkobetujyouhoutouroku", "headerButtons", "tojiruBtn", null, ErrorMsgKbn.DD);

    static final Item DDID_KEYINFO_DRTENCD = new Item("skdairitenkobetujyouhoutouroku", "keyInfo", "drtencd", null, ErrorMsgKbn.DISP);

    static final Item DDID_KEYINFO_BANKCD = new Item("skdairitenkobetujyouhoutouroku", "keyInfo", "bankcd", null, ErrorMsgKbn.DISP);

    static final Item DDID_KEYINFO_OYADRTENNM = new Item("skdairitenkobetujyouhoutouroku", "keyInfo", "oyadrtennm", null, ErrorMsgKbn.DD);

    static final Item DDID_DAIRITENKOBETUINFO1_DRTENRNRKHOUKBN = new Item("skdairitenkobetujyouhoutouroku", "dairitenKobetuInfo1", "drtenRnrkhouKbn", null, ErrorMsgKbn.DISP);

    static final Item DDID_DAIRITENKOBETUINFO1_UTDSKKNNM1KJ = new Item("skdairitenkobetujyouhoutouroku", "dairitenKobetuInfo1", "utdskknnm1kj", null, ErrorMsgKbn.DD);

    static final Item DDID_DAIRITENKOBETUINFO1_UTDSKKNNM2KJ = new Item("skdairitenkobetujyouhoutouroku", "dairitenKobetuInfo1", "utdskknnm2kj", null, ErrorMsgKbn.DD);

    static final Item DDID_DAIRITENKOBETUINFO2_NYKNTRATKIKBN = new Item("skdairitenkobetujyouhoutouroku", "dairitenKobetuInfo2", "nykntratkikbn", null, ErrorMsgKbn.DD);

    static final Item DDID_DAIRITENKOBETUINFO2_TRKSSKSSOUHUKBN = new Item("skdairitenkobetujyouhoutouroku", "dairitenKobetuInfo2", "trksskssouhukbn", null, ErrorMsgKbn.DD);

    static final Item DDID_DAIRITENKOBETUINFO2_TKHJNKINYUUCD = new Item("skdairitenkobetujyouhoutouroku", "dairitenKobetuInfo2", "tkhjnkinyuucd", null, ErrorMsgKbn.ERROR);

    static final Item DDID_CIFCDINFO_CIFCDCHECKYOUHI = new Item("skdairitenkobetujyouhoutouroku", "cifcdInfo", "cifcdcheckyouhi", null, ErrorMsgKbn.ERROR);

    static final Item DDID_CIFCDINFO_CIFCDSITEIKETASUU = new Item("skdairitenkobetujyouhoutouroku", "cifcdInfo", "cifcdsiteiketasuu", null, ErrorMsgKbn.ERROR);

    static final Item DDID_CIFCDINFO_CIFCDMAEZEROUMEYOUHI = new Item("skdairitenkobetujyouhoutouroku", "cifcdInfo", "cifcdmaezeroumeyouhi", null, ErrorMsgKbn.ERROR);

    static final Item DDID_FOOTERBUTTONS2_MODORUBTNBYINPUTCONTENTS = new Item("skdairitenkobetujyouhoutouroku", "footerButtons2", "modoruBtnByInputContents", null, ErrorMsgKbn.DD);

    static final Item DDID_FOOTERBUTTONS3_MODORUBTNBYCONFIRM = new Item("skdairitenkobetujyouhoutouroku", "footerButtons3", "modoruBtnByConfirm", null, ErrorMsgKbn.DD);

    static final Item DDID_FOOTERBUTTONS3_KAKUTEIBTN = new Item("skdairitenkobetujyouhoutouroku", "footerButtons3", "kakuteiBtn", null, ErrorMsgKbn.DD);

    static final Item DDID_FOOTERBUTTONS4_SYOKIGAMENHEBTN = new Item("skdairitenkobetujyouhoutouroku", "footerButtons4", "syokigamenheBtn", null, ErrorMsgKbn.DD);
}
