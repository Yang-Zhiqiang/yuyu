package yuyu.app.workflow.processkanri.tantousyabetusyoritasksyoukai;

import jp.co.slcs.swak.bizinfr.configuration.Item;
import jp.co.slcs.swak.bizinfr.configuration.Item.ErrorMsgKbn;

/**
 * 担当者別処理タスク照会 画面項目ID定義のベースクラスです。<br />
 * このソースはツールによる自動生成で、画面項目定義の変更に連動して更新されます。
 * 手書きコードを加えてはいけません。
 */
public class GenTantousyabetuSyoriTaskSyoukaiConstants {

    public static final int PAGENO_INIT     = 1;

    public static final int PAGENO_INPUTKEY = 1;

    static final String FORWARDNAME_INIT     = "init";

    static final String FORWARDNAME_CURRENT  = "current";

    static final String FORWARDNAME_INPUTKEY = "InputKey";

    static final Item DDID_HEADERBUTTONS_TOJIRUBTN = new Item("tantousyabetusyoritasksyoukai", "headerButtons", "tojiruBtn", null, ErrorMsgKbn.DD);

    static final Item DDID_SEARCHKEYINPUT_SUBSYSTEMID = new Item("tantousyabetusyoritasksyoukai", "searchKeyInput", "subSystemId", null, ErrorMsgKbn.DISP);

    static final Item DDID_SEARCHKEYINPUT_USERID = new Item("tantousyabetusyoritasksyoukai", "searchKeyInput", "userId", null, ErrorMsgKbn.DD);

    static final Item DDID_SEARCHKEYINPUT_USERNM = new Item("tantousyabetusyoritasksyoukai", "searchKeyInput", "userNm", null, ErrorMsgKbn.DD);

    static final Item DDID_SEARCHKEYINPUT_SYORIYMDFROM = new Item("tantousyabetusyoritasksyoukai", "searchKeyInput", "syoriYmdFrom", null, ErrorMsgKbn.DD);

    static final Item DDID_SEARCHKEYINPUT_SYORIYMDTO = new Item("tantousyabetusyoritasksyoukai", "searchKeyInput", "syoriYmdTo", null, ErrorMsgKbn.DD);

    static final Item DDID_TASKSERINFO_DISPJIMUTETUZUKINM = new Item("tantousyabetusyoritasksyoukai", "taskserInfo", "dispjimutetuzukinm", null, ErrorMsgKbn.DISP);

    static final Item DDID_TASKSERINFO_DISPGYOUMUKEY = new Item("tantousyabetusyoritasksyoukai", "taskserInfo", "dispGyoumuKey", null, ErrorMsgKbn.DISP);

    static final Item DDID_TASKSERINFO_DISPSYORITIME = new Item("tantousyabetusyoritasksyoukai", "taskserInfo", "dispsyoritime", null, ErrorMsgKbn.DISP);

    static final Item DDID_TASKSERINFO_DISPTASKNM = new Item("tantousyabetusyoritasksyoukai", "taskserInfo", "disptasknm", null, ErrorMsgKbn.DISP);

    static final Item DDID_TASKSERINFO_DISPHKNSYURUIWORKLIST = new Item("tantousyabetusyoritasksyoukai", "taskserInfo", "disphknsyuruiworklist", null, ErrorMsgKbn.DISP);

    static final Item DDID_TASKSERINFO_DISPTRATKIAGNM1 = new Item("tantousyabetusyoritasksyoukai", "taskserInfo", "disptratkiagnm1", null, ErrorMsgKbn.DISP);

    static final Item DDID_TASKSERINFO_DISPKYKNMKN = new Item("tantousyabetusyoritasksyoukai", "taskserInfo", "dispkyknmkn", null, ErrorMsgKbn.DISP);

    static final Item DDID_TASKSERINFO_DISPKYKNMKJ = new Item("tantousyabetusyoritasksyoukai", "taskserInfo", "dispkyknmkj", null, ErrorMsgKbn.DD);
}
