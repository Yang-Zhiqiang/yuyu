package yuyu.app.workflow.imagekanri.qrsealsakusei;

import jp.co.slcs.swak.bizinfr.configuration.Item;
import jp.co.slcs.swak.bizinfr.configuration.Item.ErrorMsgKbn;

/**
 * QRシール用紙作成 画面項目ID定義のベースクラスです。<br />
 * このソースはツールによる自動生成で、画面項目定義の変更に連動して更新されます。
 * 手書きコードを加えてはいけません。
 */
public class GenQRSealSakuseiConstants {

    public static final int PAGENO_INIT           = 1;

    public static final int PAGENO_INPUTCONDITION = 1;

    public static final int PAGENO_INPUTCONTENTS  = 2;

    public static final int PAGENO_CONFIRM        = 3;

    public static final int PAGENO_RESULT         = 4;

    static final String FORWARDNAME_INIT           = "init";

    static final String FORWARDNAME_INPUTCONDITION = "InputCondition";

    static final String FORWARDNAME_INPUTCONTENTS  = "InputContents";

    static final String FORWARDNAME_CONFIRM        = "Confirm";

    static final String FORWARDNAME_RESULT         = "Result";

    static final Item DDID_HEADERBUTTONS_TOJIRUBTN = new Item("qrsealsakusei", "headerButtons", "tojiruBtn", null, ErrorMsgKbn.DD);

    static final Item DDID_INPUTCONDITIONINFO_DISPSUBSYSTEMNM = new Item("qrsealsakusei", "inputConditionInfo", "dispsubsystemnm", null, ErrorMsgKbn.DISP);

    static final Item DDID_INPUTCONDITIONINFO_DISPJIMUTETUZUKINM = new Item("qrsealsakusei", "inputConditionInfo", "dispjimutetuzukinm", null, ErrorMsgKbn.DISP);

    static final Item DDID_INPUTCONDITIONINFO_OUTKEISIKIKBN = new Item("qrsealsakusei", "inputConditionInfo", "outkeisikikbn", null, ErrorMsgKbn.ERROR);

    static final Item DDID_INPUTCONDITIONINFO_SYUTURYOKUKAISIGYOUKBN = new Item("qrsealsakusei", "inputConditionInfo", "syuturyokukaisigyoukbn", null, ErrorMsgKbn.ERROR);

    static final Item DDID_INPUTCONTENTSINFO1_SKEIJIMUKBN = new Item("qrsealsakusei", "inputContentsInfo1", "skeijimukbn", null, ErrorMsgKbn.ERROR);

    static final Item DDID_INPUTCONTENTSINFO1_DISPHKNSYURUINOQRSEAL = new Item("qrsealsakusei", "inputContentsInfo1", "disphknsyuruinoqrseal", null, ErrorMsgKbn.ERROR);

    static final Item DDID_INPUTCONTENTSINFO1_OUTKENSUU = new Item("qrsealsakusei", "inputContentsInfo1", "outkensuu", null, ErrorMsgKbn.DISP);

    static final Item DDID_INPUTCONTENTSINFO2_MOSNO1 = new Item("qrsealsakusei", "inputContentsInfo2", "mosno1", null, ErrorMsgKbn.ERROR);

    static final Item DDID_INPUTCONTENTSINFO2_MOSNO2 = new Item("qrsealsakusei", "inputContentsInfo2", "mosno2", null, ErrorMsgKbn.ERROR);

    static final Item DDID_INPUTCONTENTSINFO2_MOSNO3 = new Item("qrsealsakusei", "inputContentsInfo2", "mosno3", null, ErrorMsgKbn.ERROR);

    static final Item DDID_INPUTCONTENTSINFO3_MOSNO = new Item("qrsealsakusei", "inputContentsInfo3", "mosno", null, ErrorMsgKbn.ERROR);

    static final Item DDID_INPUTCONTENTSINFO3_TORIKOMISYORUICD = new Item("qrsealsakusei", "inputContentsInfo3", "torikomiSyoruiCd", null, ErrorMsgKbn.ERROR);

    static final Item DDID_INPUTCONTENTSINFO3_SAKUJYOLINK = new Item("qrsealsakusei", "inputContentsInfo3", "sakujyoLink", null, ErrorMsgKbn.DD);

    static final Item DDID_INPUTCONTENTSINFO4_MOSNO = new Item("qrsealsakusei", "inputContentsInfo4", "mosno", null, ErrorMsgKbn.ERROR);

    static final Item DDID_INPUTCONTENTSINFO4_TORIKOMISYORUICD = new Item("qrsealsakusei", "inputContentsInfo4", "torikomiSyoruiCd", null, ErrorMsgKbn.ERROR);

    static final Item DDID_INPUTCONTENTSINFO4_SAKUJYOLINK = new Item("qrsealsakusei", "inputContentsInfo4", "sakujyoLink", null, ErrorMsgKbn.DD);

    static final Item DDID_BUTTONINPUTCONTENTS_MODORUBTNBYINPUTCONTENTS = new Item("qrsealsakusei", "buttonInputContents", "modoruBtnByInputContents", null, ErrorMsgKbn.DD);

    static final Item DDID_BUTTONINPUTCONTENTS_MODORUBTNBYCONFIRM = new Item("qrsealsakusei", "buttonInputContents", "modoruBtnByConfirm", null, ErrorMsgKbn.DD);
}
