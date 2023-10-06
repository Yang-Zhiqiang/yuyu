package yuyu.app.workflow.processkanri.syorikensuusyoukai;

import jp.co.slcs.swak.bizinfr.configuration.Item;
import jp.co.slcs.swak.bizinfr.configuration.Item.ErrorMsgKbn;

/**
 * 処理件数照会 画面項目ID定義のベースクラスです。<br />
 * このソースはツールによる自動生成で、画面項目定義の変更に連動して更新されます。
 * 手書きコードを加えてはいけません。
 */
public class GenSyoriKensuuSyoukaiConstants {

    public static final int PAGENO_INIT     = 1;

    public static final int PAGENO_INPUTKEY = 1;

    public static final int PAGENO_CONFIRM  = 2;

    public static final int PAGENO_RESULT   = 3;

    static final String FORWARDNAME_INIT     = "init";

    static final String FORWARDNAME_INPUTKEY = "InputKey";

    static final String FORWARDNAME_CONFIRM  = "Confirm";

    static final String FORWARDNAME_RESULT   = "Result";

    static final Item DDID_HEADERBUTTONS_TOJIRUBTN = new Item("syorikensuusyoukai", "headerButtons", "tojiruBtn", null, ErrorMsgKbn.DD);

    static final Item DDID_SEARCHKEYINPUT_SUBSYSTEMID = new Item("syorikensuusyoukai", "searchKeyInput", "subSystemId", null, ErrorMsgKbn.DISP);

    static final Item DDID_SEARCHKEYINPUT_SYORIYMD = new Item("syorikensuusyoukai", "searchKeyInput", "syoriYmd", null, ErrorMsgKbn.ERROR);

    static final Item DDID_SEARCHKEYINPUT_SYORIYMDTO = new Item("syorikensuusyoukai", "searchKeyInput", "syoriYmdTo", null, ErrorMsgKbn.ERROR);

    static final Item DDID_SEARCHKEYINPUT_USERID = new Item("syorikensuusyoukai", "searchKeyInput", "userId", null, ErrorMsgKbn.DD);

    static final Item DDID_SEARCHKEYINPUT_USERNM = new Item("syorikensuusyoukai", "searchKeyInput", "userNm", null, ErrorMsgKbn.DD);

    static final Item DDID_SEARCHKEYINPUT_DISPSUBSYSTEMNM = new Item("syorikensuusyoukai", "searchKeyInput", "dispsubsystemnm", null, ErrorMsgKbn.DISP);

    static final Item DDID_SEARCHKEYINPUT_DISPSYORIYMD = new Item("syorikensuusyoukai", "searchKeyInput", "dispsyoriymd", null, ErrorMsgKbn.DISP);

    static final Item DDID_SEARCHKEYINPUT_DISPSYORIYMDTO = new Item("syorikensuusyoukai", "searchKeyInput", "dispsyoriymdto", null, ErrorMsgKbn.DD);

    static final Item DDID_SEARCHKEYINPUT_DISPJIMUTETUZUKINM = new Item("syorikensuusyoukai", "searchKeyInput", "dispjimutetuzukinm", null, ErrorMsgKbn.DISP);

    static final Item DDID_SEARCHKEYINPUT_DISPTANTCD = new Item("syorikensuusyoukai", "searchKeyInput", "disptantcd", null, ErrorMsgKbn.DISP);

    static final Item DDID_SEARCHKEYINPUT_DISPTANTOUNM = new Item("syorikensuusyoukai", "searchKeyInput", "disptantounm", null, ErrorMsgKbn.DISP);

    static final Item DDID_SEARCHKEYINPUT_DISPTASKNM = new Item("syorikensuusyoukai", "searchKeyInput", "disptasknm", null, ErrorMsgKbn.DISP);

    static final Item DDID_TASKUSERINFO_DISPJIMUTETUZUKINM = new Item("syorikensuusyoukai", "taskuserInfo", "dispjimutetuzukinm", null, ErrorMsgKbn.DISP);

    static final Item DDID_TASKUSERINFO_ZENJITUZANKENSUU = new Item("syorikensuusyoukai", "taskuserInfo", "zenjituzanKensuu", null, ErrorMsgKbn.DISP);

    static final Item DDID_TASKUSERINFO_ZANKENSUU = new Item("syorikensuusyoukai", "taskuserInfo", "zanKensuu", null, ErrorMsgKbn.DISP);

    static final Item DDID_TASKUSERINFO_KANRYOKENSUU = new Item("syorikensuusyoukai", "taskuserInfo", "kanryoKensuu", null, ErrorMsgKbn.DISP);

    static final Item DDID_TASKUSERINFO_SYOUSAILINK = new Item("syorikensuusyoukai", "taskuserInfo", "syousaiLink", null, ErrorMsgKbn.DISP);

    static final Item DDID_TASKUSERINFO2_DISPTASKNM = new Item("syorikensuusyoukai", "taskuserInfo2", "disptasknm", null, ErrorMsgKbn.DISP);

    static final Item DDID_TASKUSERINFO2_ZENJITUZANKENSUU = new Item("syorikensuusyoukai", "taskuserInfo2", "zenjituzanKensuu", null, ErrorMsgKbn.DISP);

    static final Item DDID_TASKUSERINFO2_ZANKENSUU = new Item("syorikensuusyoukai", "taskuserInfo2", "zanKensuu", null, ErrorMsgKbn.DISP);

    static final Item DDID_TASKUSERINFO2_KANRYOKENSUU = new Item("syorikensuusyoukai", "taskuserInfo2", "kanryoKensuu", null, ErrorMsgKbn.DISP);

    static final Item DDID_TASKUSERINFO2_SYOUSAILINKTASK = new Item("syorikensuusyoukai", "taskuserInfo2", "syousaiLinkTask", null, ErrorMsgKbn.DISP);

    static final Item DDID_LASTBUTTONS2_MODORUBTNBYCONFIRM = new Item("syorikensuusyoukai", "lastButtons2", "modoruBtnByConfirm", null, ErrorMsgKbn.DD);

    static final Item DDID_TASKUSERINFO3_DISPTANTOUNM = new Item("syorikensuusyoukai", "taskuserInfo3", "disptantounm", null, ErrorMsgKbn.DISP);

    static final Item DDID_TASKUSERINFO3_ZENJITUZANKENSUU = new Item("syorikensuusyoukai", "taskuserInfo3", "zenjituzanKensuu", null, ErrorMsgKbn.DISP);

    static final Item DDID_TASKUSERINFO3_ZANKENSUU = new Item("syorikensuusyoukai", "taskuserInfo3", "zanKensuu", null, ErrorMsgKbn.DISP);

    static final Item DDID_TASKUSERINFO3_KANRYOKENSUU = new Item("syorikensuusyoukai", "taskuserInfo3", "kanryoKensuu", null, ErrorMsgKbn.DISP);

    static final Item DDID_LASTBUTTONS3_MODORUBTN = new Item("syorikensuusyoukai", "lastButtons3", "modorubtn", null, ErrorMsgKbn.DD);
}
