package yuyu.app.workflow.processkanri.wariatekaijyo;

import jp.co.slcs.swak.bizinfr.configuration.Item;
import jp.co.slcs.swak.bizinfr.configuration.Item.ErrorMsgKbn;

/**
 * 担当者割当解除 画面項目ID定義のベースクラスです。<br />
 * このソースはツールによる自動生成で、画面項目定義の変更に連動して更新されます。
 * 手書きコードを加えてはいけません。
 */
public class GenWariateKaijyoConstants {

    public static final int PAGENO_INIT       = 1;

    public static final int PAGENO_SELECTDATA = 1;

    static final String FORWARDNAME_INIT       = "init";

    static final String FORWARDNAME_CURRENT    = "current";

    static final String FORWARDNAME_SELECTDATA = "SelectData";

    static final Item DDID_HEADERBUTTONS_TOJIRUBTN = new Item("wariatekaijyo", "headerButtons", "tojiruBtn", null, ErrorMsgKbn.DD);

    static final Item DDID_SEARCHINFO_SUBSYSTEMID = new Item("wariatekaijyo", "searchInfo", "subSystemId", null, ErrorMsgKbn.DISP);

    static final Item DDID_SEARCHINFO_JIMUTETUZUKICD = new Item("wariatekaijyo", "searchInfo", "jimutetuzukicd", null, ErrorMsgKbn.DISP);

    static final Item DDID_SEARCHINFO_WORKFLOWTSKNM = new Item("wariatekaijyo", "searchInfo", "workflowTskNm", null, ErrorMsgKbn.DISP);

    static final Item DDID_SEARCHINFO_TANTID = new Item("wariatekaijyo", "searchInfo", "tantid", null, ErrorMsgKbn.DISP);

    static final Item DDID_TASKSERINFO_DISPJIMUSTARTYMD = new Item("wariatekaijyo", "taskserInfo", "dispjimustartymd", null, ErrorMsgKbn.DISP);

    static final Item DDID_TASKSERINFO_DISPTASKNM = new Item("wariatekaijyo", "taskserInfo", "disptasknm", null, ErrorMsgKbn.DISP);

    static final Item DDID_TASKSERINFO_DISPTANTOUNM = new Item("wariatekaijyo", "taskserInfo", "disptantounm", null, ErrorMsgKbn.DISP);

    static final Item DDID_TASKSERINFO_DISPGYOUMUKEY = new Item("wariatekaijyo", "taskserInfo", "dispGyoumuKey", null, ErrorMsgKbn.ERROR);

    static final Item DDID_TASKSERINFO_WARIATEKAIJYOLINK = new Item("wariatekaijyo", "taskserInfo", "wariateKaijyoLink", null, ErrorMsgKbn.DISP);
}
