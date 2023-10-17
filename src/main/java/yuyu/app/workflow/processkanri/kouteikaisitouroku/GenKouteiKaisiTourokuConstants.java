package yuyu.app.workflow.processkanri.kouteikaisitouroku;

import jp.co.slcs.swak.bizinfr.configuration.Item;
import jp.co.slcs.swak.bizinfr.configuration.Item.ErrorMsgKbn;

/**
 * 工程開始登録 画面項目ID定義のベースクラスです。<br />
 * このソースはツールによる自動生成で、画面項目定義の変更に連動して更新されます。
 * 手書きコードを加えてはいけません。
 */
public class GenKouteiKaisiTourokuConstants {

    public static final int PAGENO_INIT     = 1;

    public static final int PAGENO_INPUTKEY = 1;

    public static final int PAGENO_CONFIRM  = 2;

    public static final int PAGENO_RESULT   = 3;

    static final String FORWARDNAME_INIT     = "init";

    static final String FORWARDNAME_INPUTKEY = "InputKey";

    static final String FORWARDNAME_CONFIRM  = "Confirm";

    static final String FORWARDNAME_RESULT   = "Result";

    static final Item DDID_HEADERBUTTONS_TOJIRUBTN = new Item("kouteikaisitouroku", "headerButtons", "tojiruBtn", null, ErrorMsgKbn.DD);

    static final Item DDID_TOROKUINFO1_DISPNO = new Item("kouteikaisitouroku", "torokuInfo1", "dispno", null, ErrorMsgKbn.DISP);

    static final Item DDID_TOROKUINFO1_WORKFLOWDOCUMENTID = new Item("kouteikaisitouroku", "torokuInfo1", "workflowDocumentId", null, ErrorMsgKbn.DISP);

    static final Item DDID_TOROKUINFO2_DISPNO = new Item("kouteikaisitouroku", "torokuInfo2", "dispno", null, ErrorMsgKbn.DISP);

    static final Item DDID_TOROKUINFO2_WORKFLOWDISPDOCUMENTID = new Item("kouteikaisitouroku", "torokuInfo2", "workflowDispDocumentId", null, ErrorMsgKbn.DISP);

    static final Item DDID_TOROKUINFO2_DISPSYORUINMRYAKU = new Item("kouteikaisitouroku", "torokuInfo2", "dispsyoruinmryaku", null, ErrorMsgKbn.DISP);

    static final Item DDID_LASTBUTTONS_MODORUBTN = new Item("kouteikaisitouroku", "lastButtons", "modorubtn", null, ErrorMsgKbn.DD);
}
