package yuyu.app.workflow.processkanri.kouteitorikesi;

import jp.co.slcs.swak.bizinfr.configuration.Item;
import jp.co.slcs.swak.bizinfr.configuration.Item.ErrorMsgKbn;

/**
 * 工程取消 画面項目ID定義のベースクラスです。<br />
 * このソースはツールによる自動生成で、画面項目定義の変更に連動して更新されます。
 * 手書きコードを加えてはいけません。
 */
public class GenKouteiTorikesiConstants {

    public static final int PAGENO_INIT          = 1;

    public static final int PAGENO_SELECTDATA    = 1;

    public static final int PAGENO_INPUTCONTENTS = 2;

    public static final int PAGENO_CONFIRM       = 3;

    public static final int PAGENO_RESULT        = 4;

    static final String FORWARDNAME_INIT          = "init";

    static final String FORWARDNAME_SELECTDATA    = "SelectData";

    static final String FORWARDNAME_INPUTCONTENTS = "InputContents";

    static final String FORWARDNAME_CONFIRM       = "Confirm";

    static final String FORWARDNAME_RESULT        = "Result";

    static final Item DDID_HEADERBUTTONS_TOJIRUBTN = new Item("kouteitorikesi", "headerButtons", "tojiruBtn", null, ErrorMsgKbn.DD);

    static final Item DDID_SEARCHINFO_SUBSYSTEMID = new Item("kouteitorikesi", "searchInfo", "subSystemId", null, ErrorMsgKbn.DISP);

    static final Item DDID_SEARCHINFO_JIMUTETUZUKICD = new Item("kouteitorikesi", "searchInfo", "jimutetuzukicd", null, ErrorMsgKbn.DISP);

    static final Item DDID_SEARCHINFO_SYONO = new Item("kouteitorikesi", "searchInfo", "syono", null, ErrorMsgKbn.DD);

    static final Item DDID_SEARCHINFO_NKSYSYNO = new Item("kouteitorikesi", "searchInfo", "nksysyno", null, ErrorMsgKbn.DD);

    static final Item DDID_SEARCHINFO_DISPKOUTEIKAISIYMD = new Item("kouteitorikesi", "searchInfo", "dispkouteikaisiymd", null, ErrorMsgKbn.DISP);

    static final Item DDID_SEARCHINFO_DISPTANTOUNM = new Item("kouteitorikesi", "searchInfo", "disptantounm", null, ErrorMsgKbn.DISP);

    static final Item DDID_KOUTEILIST_DISPJIMUTETUZUKINM = new Item("kouteitorikesi", "kouteiList", "dispjimutetuzukinm", null, ErrorMsgKbn.DISP);

    static final Item DDID_KOUTEILIST_DISPGYOUMUKEY = new Item("kouteitorikesi", "kouteiList", "dispGyoumuKey", null, ErrorMsgKbn.ERROR);

    static final Item DDID_KOUTEILIST_DISPKOUTEIKAISIYMD = new Item("kouteitorikesi", "kouteiList", "dispkouteikaisiymd", null, ErrorMsgKbn.DISP);

    static final Item DDID_KOUTEILIST_DISPTANTOUNM = new Item("kouteitorikesi", "kouteiList", "disptantounm", null, ErrorMsgKbn.DISP);

    static final Item DDID_KOUTEILIST_NYUURYOKULINK = new Item("kouteitorikesi", "kouteiList", "nyuuryokuLink", null, ErrorMsgKbn.DD);

    static final Item DDID_TORIKESICOMMENT_WORKFLOWTORIKESICOMMENT = new Item("kouteitorikesi", "torikesiComment", "workflowTorikesiComment", null, ErrorMsgKbn.DD);

    static final Item DDID_BUTTONINPUTCONTENTS_MODORUBTNBYINPUTCONTENTS = new Item("kouteitorikesi", "buttonInputContents", "modoruBtnByInputContents", null, ErrorMsgKbn.DD);
}
