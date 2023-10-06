package yuyu.app.workflow.processkanri.nenkinworklist;

import jp.co.slcs.swak.bizinfr.configuration.Item;
import jp.co.slcs.swak.bizinfr.configuration.Item.ErrorMsgKbn;

/**
 * 年金支払工程ワークリスト 画面項目ID定義のベースクラスです。<br />
 * このソースはツールによる自動生成で、画面項目定義の変更に連動して更新されます。
 * 手書きコードを加えてはいけません。
 */
public class GenNenkinWorkListConstants {

    public static final int PAGENO_INIT                     = 1;

    public static final int PAGENO_INPUTKEYTSKSNTKNKSHR     = 1;

    public static final int PAGENO_INPUTKEYANKNITRNNKSHR    = 2;

    static final String FORWARDNAME_INIT                     = "init";

    static final String FORWARDNAME_CURRENT                  = "current";

    static final String FORWARDNAME_INPUTKEYTSKSNTKNKSHR     = "InputKeyTskSntkNkShr";

    static final String FORWARDNAME_INPUTKEYANKNITRNNKSHR    = "InputKeyAnknItrnNkShr";

    static final String FORWARDNAME_ERROR                    = "Error";

    static final String FORWARDNAME_GOTONKSIHARAI            = "goToNkSiharai";

    static final String FORWARDNAME_GOTONKSIBOU              = "goToNkSibou";

    static final String FORWARDNAME_GOTONKMEIGIJYUUSYOHENKOU = "goToNkMeigiJyuusyoHenkou";

    static final String FORWARDNAME_GOTONKKAISUUHENKOU       = "goToNkKaisuuHenkou";

    static final String FORWARDNAME_GOTONKKOUZAHENKOU        = "goToNkKouzaHenkou";

    static final String FORWARDNAME_GOTONKSAIHAKKOU          = "goToNkSaihakkou";

    static final String FORWARDNAME_GOTONKTOKUYAKUHENKOU     = "goToNkTokuyakuHenkou";

    static final String FORWARDNAME_GOTONKHUBITOUROKU        = "goToNkHubiTouroku";

    static final String FORWARDNAME_GOTONKHUBIKAISYOU        = "goToNkHubiKaisyou";

    static final Item DDID_HEADERBUTTONS_TOJIRUBTN = new Item("nenkinworklist", "headerButtons", "tojiruBtn", null, ErrorMsgKbn.DD);

    static final Item DDID_JIMUTETUZUKILABEL_DISPJIMUTETUZUKINM = new Item("nenkinworklist", "jimutetuzukiLabel", "dispjimutetuzukinm", null, ErrorMsgKbn.DISP);

    static final Item DDID_SEARCHKEYINPUT_JIMUTETUZUKICD = new Item("nenkinworklist", "searchKeyInput", "jimutetuzukicd", null, ErrorMsgKbn.DISP);

    static final Item DDID_SEARCHKEYINPUT_JIMUYOUCD = new Item("nenkinworklist", "searchKeyInput", "jimuyoucd", null, ErrorMsgKbn.DISP);

    static final Item DDID_SEARCHKEYINPUT_JMYCDMISETTEIKBN = new Item("nenkinworklist", "searchKeyInput", "jmycdMisetteiKbn", null, ErrorMsgKbn.DISP);

    static final Item DDID_SEARCHKEYINPUT_JIMUSTARTYMDFROM = new Item("nenkinworklist", "searchKeyInput", "jimustartYmdFrom", null, ErrorMsgKbn.ERROR);

    static final Item DDID_SEARCHKEYINPUT_JIMUSTARTYMDTO = new Item("nenkinworklist", "searchKeyInput", "jimustartYmdTo", null, ErrorMsgKbn.ERROR);

    static final Item DDID_SEARCHKEYINPUT_NKSYSYNO = new Item("nenkinworklist", "searchKeyInput", "nksysyno", null, ErrorMsgKbn.DISP);

    static final Item DDID_SEARCHCONDITIONBTN_CLEARBTN = new Item("nenkinworklist", "searchConditionBtn", "clearbtn", null, ErrorMsgKbn.DD);

    static final Item DDID_SEARCHCONDITIONBTN_JOUKENHOZONBTN = new Item("nenkinworklist", "searchConditionBtn", "joukenHozonBtn", null, ErrorMsgKbn.DD);

    static final Item DDID_RESULTINFOTSKSNTKBASE_JIMUTETUZUKICD = new Item("nenkinworklist", "resultInfoTskSntkBase", "jimutetuzukicd", null, ErrorMsgKbn.DD);

    static final Item DDID_RESULTINFOTSKSNTK_JIMUTETUZUKICD = new Item("nenkinworklist", "resultInfoTskSntk", "jimutetuzukicd", null, ErrorMsgKbn.DISP);

    static final Item DDID_RESULTINFOTSKSNTK_DISPJIMUTETUZUKINM = new Item("nenkinworklist", "resultInfoTskSntk", "dispjimutetuzukinm", null, ErrorMsgKbn.DISP);

    static final Item DDID_RESULTINFOTSKSNTK_WORKFLOWTSKNM = new Item("nenkinworklist", "resultInfoTskSntk", "workflowTskNm", null, ErrorMsgKbn.DISP);

    static final Item DDID_RESULTINFOTSKSNTK_KJNTSKKENSUU = new Item("nenkinworklist", "resultInfoTskSntk", "kjnTskKensuu", null, ErrorMsgKbn.DISP);

    static final Item DDID_RESULTINFOTSKSNTK_KOJINNYUURYOKULINK = new Item("nenkinworklist", "resultInfoTskSntk", "kojinNyuuryokuLink", null, ErrorMsgKbn.DISP);

    static final Item DDID_RESULTINFOTSKSNTK_KOJINITIRANLINK = new Item("nenkinworklist", "resultInfoTskSntk", "kojinItiranLink", null, ErrorMsgKbn.DISP);

    static final Item DDID_RESULTINFOTSKSNTK_KYYTSKKENSUU = new Item("nenkinworklist", "resultInfoTskSntk", "kyyTskKensuu", null, ErrorMsgKbn.DISP);

    static final Item DDID_RESULTINFOTSKSNTK_KYOUYOUNYUURYOKULINK = new Item("nenkinworklist", "resultInfoTskSntk", "kyouyouNyuuryokuLink", null, ErrorMsgKbn.DISP);

    static final Item DDID_RESULTINFOTSKSNTK_KYOUYOUITIRANLINK = new Item("nenkinworklist", "resultInfoTskSntk", "kyouyouItiranLink", null, ErrorMsgKbn.DISP);

    static final Item DDID_RESULTINFOITIRAN_DISPJIMUSTARTYMDTIME = new Item("nenkinworklist", "resultInfoItiran", "dispjimustartymdtime", null, ErrorMsgKbn.DISP);

    static final Item DDID_RESULTINFOITIRAN_NKSYSYNO = new Item("nenkinworklist", "resultInfoItiran", "nksysyno", null, ErrorMsgKbn.DISP);

    static final Item DDID_RESULTINFOITIRAN_NENKINUKTNMKANJI = new Item("nenkinworklist", "resultInfoItiran", "nenkinuktnmkanji", null, ErrorMsgKbn.DISP);

    static final Item DDID_RESULTINFOITIRAN_DISPZENKAISYORITASK = new Item("nenkinworklist", "resultInfoItiran", "dispzenkaisyoritask", null, ErrorMsgKbn.DISP);

    static final Item DDID_RESULTINFOITIRAN_DISPZENKAISYORITANTOUNM = new Item("nenkinworklist", "resultInfoItiran", "dispzenkaisyoritantounm", null, ErrorMsgKbn.DISP);

    static final Item DDID_RESULTINFOITIRAN_NYUURYOKULINK = new Item("nenkinworklist", "resultInfoItiran", "nyuuryokuLink", null, ErrorMsgKbn.DD);

    static final Item DDID_LASTBUTTONS_MODORUBTN = new Item("nenkinworklist", "lastButtons", "modorubtn", null, ErrorMsgKbn.DD);
}
