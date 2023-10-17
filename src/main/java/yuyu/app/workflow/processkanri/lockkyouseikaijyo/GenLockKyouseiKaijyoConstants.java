package yuyu.app.workflow.processkanri.lockkyouseikaijyo;

import jp.co.slcs.swak.bizinfr.configuration.Item;
import jp.co.slcs.swak.bizinfr.configuration.Item.ErrorMsgKbn;

/**
 * 工程ロック強制解除 画面項目ID定義のベースクラスです。<br />
 * このソースはツールによる自動生成で、画面項目定義の変更に連動して更新されます。
 * 手書きコードを加えてはいけません。
 */
public class GenLockKyouseiKaijyoConstants {

    public static final int PAGENO_INIT       = 1;

    public static final int PAGENO_SELECTDATA = 1;

    static final String FORWARDNAME_INIT       = "init";

    static final String FORWARDNAME_CURRENT    = "current";

    static final String FORWARDNAME_SELECTDATA = "SelectData";

    static final Item DDID_HEADERBUTTONS_TOJIRUBTN = new Item("lockkyouseikaijyo", "headerButtons", "tojiruBtn", null, ErrorMsgKbn.DD);

    static final Item DDID_SEARCHCONDITIONS_SUBSYSTEMID = new Item("lockkyouseikaijyo", "searchConditions", "subSystemId", null, ErrorMsgKbn.DISP);

    static final Item DDID_SEARCHCONDITIONS_JIMUTETUZUKICD = new Item("lockkyouseikaijyo", "searchConditions", "jimutetuzukicd", null, ErrorMsgKbn.DISP);

    static final Item DDID_SEARCHCONDITIONS_MOSNO = new Item("lockkyouseikaijyo", "searchConditions", "mosno", null, ErrorMsgKbn.DISP);

    static final Item DDID_SEARCHCONDITIONS_SYONO = new Item("lockkyouseikaijyo", "searchConditions", "syono", null, ErrorMsgKbn.DISP);

    static final Item DDID_SEARCHCONDITIONS_NKSYSYNO = new Item("lockkyouseikaijyo", "searchConditions", "nksysyno", null, ErrorMsgKbn.DISP);

    static final Item DDID_LOCKEDTASKINFOLIST_DISPGYOUMUKEY = new Item("lockkyouseikaijyo", "lockedTaskInfoList", "dispGyoumuKey", null, ErrorMsgKbn.DD);

    static final Item DDID_LOCKEDTASKINFOLIST_DISPJIMUSTARTYMD = new Item("lockkyouseikaijyo", "lockedTaskInfoList", "dispjimustartymd", null, ErrorMsgKbn.DISP);

    static final Item DDID_LOCKEDTASKINFOLIST_DISPTASKNM = new Item("lockkyouseikaijyo", "lockedTaskInfoList", "disptasknm", null, ErrorMsgKbn.DISP);

    static final Item DDID_LOCKEDTASKINFOLIST_DISPTANTOUNM = new Item("lockkyouseikaijyo", "lockedTaskInfoList", "disptantounm", null, ErrorMsgKbn.DISP);

    static final Item DDID_LOCKEDTASKINFOLIST_LOCKKAIJYOLINK = new Item("lockkyouseikaijyo", "lockedTaskInfoList", "lockKaijyoLink", null, ErrorMsgKbn.DD);
}
