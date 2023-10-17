package yuyu.app.workflow.processkanri.kouteijyoukyousyoukai;

import jp.co.slcs.swak.bizinfr.configuration.Item;
import jp.co.slcs.swak.bizinfr.configuration.Item.ErrorMsgKbn;

/**
 * 工程状況照会 画面項目ID定義のベースクラスです。<br />
 * このソースはツールによる自動生成で、画面項目定義の変更に連動して更新されます。
 * 手書きコードを加えてはいけません。
 */
public class GenKouteiJyoukyouSyoukaiConstants {

    public static final int PAGENO_INIT     = 1;

    public static final int PAGENO_INPUTKEY = 1;

    public static final int PAGENO_RESULT   = 2;

    static final String FORWARDNAME_INIT     = "init";

    static final String FORWARDNAME_CURRENT  = "current";

    static final String FORWARDNAME_INPUTKEY = "InputKey";

    static final String FORWARDNAME_RESULT   = "Result";

    static final Item DDID_HEADERBUTTONS_TOJIRUBTN = new Item("kouteijyoukyousyoukai", "headerButtons", "tojiruBtn", null, ErrorMsgKbn.DD);

    static final Item DDID_SEARCHKEYINPUT_SUBSYSTEMID = new Item("kouteijyoukyousyoukai", "SearchKeyInput", "subSystemId", null, ErrorMsgKbn.DISP);

    static final Item DDID_SEARCHKEYINPUT_JIMUTETUZUKICD = new Item("kouteijyoukyousyoukai", "SearchKeyInput", "jimutetuzukicd", null, ErrorMsgKbn.DISP);

    static final Item DDID_SEARCHKEYINPUT_SUBFLOWINCLUDECHECKBOX = new Item("kouteijyoukyousyoukai", "SearchKeyInput", "subflowincludeCheckBox", null, ErrorMsgKbn.DISP);

    static final Item DDID_SEARCHKEYINPUT_TSKID = new Item("kouteijyoukyousyoukai", "SearchKeyInput", "tskid", null, ErrorMsgKbn.DISP);

    static final Item DDID_SEARCHKEYINPUT_MOSNO = new Item("kouteijyoukyousyoukai", "SearchKeyInput", "mosno", null, ErrorMsgKbn.DISP);

    static final Item DDID_SEARCHKEYINPUT_SYONO = new Item("kouteijyoukyousyoukai", "SearchKeyInput", "syono", null, ErrorMsgKbn.DISP);

    static final Item DDID_SEARCHKEYINPUT_NKSYSYNO = new Item("kouteijyoukyousyoukai", "SearchKeyInput", "nksysyno", null, ErrorMsgKbn.DISP);

    static final Item DDID_SEARCHKEYINPUT_SRCHJIMUSTARTYMDFROM = new Item("kouteijyoukyousyoukai", "SearchKeyInput", "srchjimustartymdfrom", null, ErrorMsgKbn.ERROR);

    static final Item DDID_SEARCHKEYINPUT_SRCHJIMUSTARTYMDTO = new Item("kouteijyoukyousyoukai", "SearchKeyInput", "srchjimustartymdto", null, ErrorMsgKbn.ERROR);

    static final Item DDID_SEARCHKEYINPUT_SRCHKOUTEIKANSTARTYMDFROM = new Item("kouteijyoukyousyoukai", "SearchKeyInput", "srchKouteikanStartYmdFrom", null, ErrorMsgKbn.ERROR);

    static final Item DDID_SEARCHKEYINPUT_SRCHKOUTEIKANSTARTYMDTO = new Item("kouteijyoukyousyoukai", "SearchKeyInput", "srchKouteikanStartYmdTo", null, ErrorMsgKbn.ERROR);

    static final Item DDID_SEARCHKEYINPUT_SRCHLASTKOSSTARTYMDFROM = new Item("kouteijyoukyousyoukai", "SearchKeyInput", "srchLastkosStartYmdFrom", null, ErrorMsgKbn.ERROR);

    static final Item DDID_SEARCHKEYINPUT_SRCHLASTKOSSTARTYMDTO = new Item("kouteijyoukyousyoukai", "SearchKeyInput", "srchLastkosStartYmdTo", null, ErrorMsgKbn.ERROR);

    static final Item DDID_SEARCHKEYINPUT_KOUTEIKANRISTATUS = new Item("kouteijyoukyousyoukai", "SearchKeyInput", "kouteikanristatus", null, ErrorMsgKbn.DISP);

    static final Item DDID_SEARCHKEYINPUT_JIMUYOUCD = new Item("kouteijyoukyousyoukai", "SearchKeyInput", "jimuyoucd", null, ErrorMsgKbn.DD);

    static final Item DDID_SEARCHKEYINPUT_COMMONCHECKBOX = new Item("kouteijyoukyousyoukai", "SearchKeyInput", "commonCheckBox", null, ErrorMsgKbn.DISP);

    static final Item DDID_TASKUSERINFO_DISPJIMUTETUZUKINM = new Item("kouteijyoukyousyoukai", "taskuserInfo", "dispjimutetuzukinm", null, ErrorMsgKbn.DISP);

    static final Item DDID_TASKUSERINFO_DISPGYOUMUKEY = new Item("kouteijyoukyousyoukai", "taskuserInfo", "dispGyoumuKey", null, ErrorMsgKbn.DISP);

    static final Item DDID_TASKUSERINFO_HYOUJIYMDFROM = new Item("kouteijyoukyousyoukai", "taskuserInfo", "hyoujiYmdFrom", null, ErrorMsgKbn.DISP);

    static final Item DDID_TASKUSERINFO_DISPJIMUSTARTYMD = new Item("kouteijyoukyousyoukai", "taskuserInfo", "dispjimustartymd", null, ErrorMsgKbn.DD);

    static final Item DDID_TASKUSERINFO_HYOUJIYMDTO = new Item("kouteijyoukyousyoukai", "taskuserInfo", "hyoujiYmdTo", null, ErrorMsgKbn.DISP);

    static final Item DDID_TASKUSERINFO_DISPKOUTEIKANRISTATUS = new Item("kouteijyoukyousyoukai", "taskuserInfo", "dispkouteikanristatus", null, ErrorMsgKbn.DISP);

    static final Item DDID_TASKUSERINFO_DISPTASKNM = new Item("kouteijyoukyousyoukai", "taskuserInfo", "disptasknm", null, ErrorMsgKbn.DISP);

    static final Item DDID_TASKUSERINFO_DISPNOWSYORITANTOUNM = new Item("kouteijyoukyousyoukai", "taskuserInfo", "dispnowsyoritantounm", null, ErrorMsgKbn.DISP);

    static final Item DDID_TASKUSERINFO_SYOUSAILINK = new Item("kouteijyoukyousyoukai", "taskuserInfo", "syousaiLink", null, ErrorMsgKbn.DD);

    static final Item DDID_KEYINFOINPUT_DISPGYOUMUKEY = new Item("kouteijyoukyousyoukai", "keyInfoInput", "dispGyoumuKey", null, ErrorMsgKbn.DD);

    static final Item DDID_KEYINFOINPUT_DISPJIMUTETUZUKINM = new Item("kouteijyoukyousyoukai", "keyInfoInput", "dispjimutetuzukinm", null, ErrorMsgKbn.DISP);

    static final Item DDID_KEYINFOINPUT_DISPKOUTEIKANRISTATUS = new Item("kouteijyoukyousyoukai", "keyInfoInput", "dispkouteikanristatus", null, ErrorMsgKbn.DISP);

    static final Item DDID_KEYINFOINPUT_DISPTASKNM = new Item("kouteijyoukyousyoukai", "keyInfoInput", "disptasknm", null, ErrorMsgKbn.DISP);

    static final Item DDID_KEYINFOINPUT_DISPNOWSYORITANTOUNM = new Item("kouteijyoukyousyoukai", "keyInfoInput", "dispnowsyoritantounm", null, ErrorMsgKbn.DISP);

    static final Item DDID_RESULTINFO_SYORITIME = new Item("kouteijyoukyousyoukai", "resultInfo", "syoriTime", null, ErrorMsgKbn.DISP);

    static final Item DDID_RESULTINFO_DISPTSKKINOUSYOUSAINM = new Item("kouteijyoukyousyoukai", "resultInfo", "dispTskkinousyousaiNm", null, ErrorMsgKbn.DISP);

    static final Item DDID_RESULTINFO_SYORIKEKKAKBN = new Item("kouteijyoukyousyoukai", "resultInfo", "syorikekkakbn", null, ErrorMsgKbn.DISP);

    static final Item DDID_RESULTINFO_DISPTANTOUNM = new Item("kouteijyoukyousyoukai", "resultInfo", "disptantounm", null, ErrorMsgKbn.DISP);

    static final Item DDID_RESULTINFO_DISPRIREKIMSG = new Item("kouteijyoukyousyoukai", "resultInfo", "dispRirekiMsg", null, ErrorMsgKbn.DISP);
}
