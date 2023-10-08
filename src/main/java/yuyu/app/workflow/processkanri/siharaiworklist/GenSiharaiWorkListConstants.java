package yuyu.app.workflow.processkanri.siharaiworklist;

import jp.co.slcs.swak.bizinfr.configuration.Item;
import jp.co.slcs.swak.bizinfr.configuration.Item.ErrorMsgKbn;

/**
 * 保険金給付金支払工程ワークリスト 画面項目ID定義のベースクラスです。<br />
 * このソースはツールによる自動生成で、画面項目定義の変更に連動して更新されます。
 * 手書きコードを加えてはいけません。
 */
public class GenSiharaiWorkListConstants {

    public static final int PAGENO_INIT                       = 1;

    public static final int PAGENO_INPUTKEYTSKSNTKHKNSHR      = 1;

    public static final int PAGENO_INPUTKEYANKNITRNHKNSHR     = 2;

    static final String FORWARDNAME_INIT                       = "init";

    static final String FORWARDNAME_CURRENT                    = "current";

    static final String FORWARDNAME_INPUTKEYTSKSNTKHKNSHR      = "InputKeyTskSntkHknShr";

    static final String FORWARDNAME_INPUTKEYANKNITRNHKNSHR     = "InputKeyAnknItrnHknShr";

    static final String FORWARDNAME_ERROR                      = "Error";

    static final String FORWARDNAME_GOTOSISEIKYUUUKETUKESB     = "goToSiSeikyuuUketukeSb";

    static final String FORWARDNAME_GOTOSISATEISB              = "goToSiSateiSb";

    static final String FORWARDNAME_GOTOSIHUBITOUROKU          = "goToSiHubiTouroku";

    static final String FORWARDNAME_GOTOSIHUBIKAISYOU          = "goToSiHubiKaisyou";

    static final String FORWARDNAME_GOTOSISINDANSYORYOUSIHARAI = "goToSiSindansyoryouSiharai";

    static final Item DDID_HEADERBUTTONS_TOJIRUBTN = new Item("siharaiworklist", "headerButtons", "tojiruBtn", null, ErrorMsgKbn.DD);

    static final Item DDID_JIMUTETUZUKILABEL_DISPJIMUTETUZUKINM = new Item("siharaiworklist", "jimutetuzukiLabel", "dispjimutetuzukinm", null, ErrorMsgKbn.DISP);

    static final Item DDID_SEARCHKEYINPUT_JIMUTETUZUKICD = new Item("siharaiworklist", "searchKeyInput", "jimutetuzukicd", null, ErrorMsgKbn.DISP);

    static final Item DDID_SEARCHKEYINPUT_JIMUYOUCD = new Item("siharaiworklist", "searchKeyInput", "jimuyoucd", null, ErrorMsgKbn.DISP);

    static final Item DDID_SEARCHKEYINPUT_JMYCDMISETTEIKBN = new Item("siharaiworklist", "searchKeyInput", "jmycdMisetteiKbn", null, ErrorMsgKbn.DISP);

    static final Item DDID_SEARCHKEYINPUT_JIMUSTARTYMDFROM = new Item("siharaiworklist", "searchKeyInput", "jimustartYmdFrom", null, ErrorMsgKbn.ERROR);

    static final Item DDID_SEARCHKEYINPUT_JIMUSTARTYMDTO = new Item("siharaiworklist", "searchKeyInput", "jimustartYmdTo", null, ErrorMsgKbn.ERROR);

    static final Item DDID_SEARCHKEYINPUT_SYONO = new Item("siharaiworklist", "searchKeyInput", "syono", null, ErrorMsgKbn.DISP);

    static final Item DDID_SEARCHCONDITIONBTN_CLEARBTN = new Item("siharaiworklist", "searchConditionBtn", "clearbtn", null, ErrorMsgKbn.DD);

    static final Item DDID_SEARCHCONDITIONBTN_JOUKENHOZONBTN = new Item("siharaiworklist", "searchConditionBtn", "joukenHozonBtn", null, ErrorMsgKbn.DD);

    static final Item DDID_RESULTINFOTSKSNTKBASE_JIMUTETUZUKICD = new Item("siharaiworklist", "resultInfoTskSntkBase", "jimutetuzukicd", null, ErrorMsgKbn.DD);

    static final Item DDID_RESULTINFOTSKSNTK_JIMUTETUZUKICD = new Item("siharaiworklist", "resultInfoTskSntk", "jimutetuzukicd", null, ErrorMsgKbn.DISP);

    static final Item DDID_RESULTINFOTSKSNTK_DISPJIMUTETUZUKINM = new Item("siharaiworklist", "resultInfoTskSntk", "dispjimutetuzukinm", null, ErrorMsgKbn.DISP);

    static final Item DDID_RESULTINFOTSKSNTK_WORKFLOWTSKNM = new Item("siharaiworklist", "resultInfoTskSntk", "workflowTskNm", null, ErrorMsgKbn.DISP);

    static final Item DDID_RESULTINFOTSKSNTK_KJNTSKKENSUU = new Item("siharaiworklist", "resultInfoTskSntk", "kjnTskKensuu", null, ErrorMsgKbn.DISP);

    static final Item DDID_RESULTINFOTSKSNTK_KOJINNYUURYOKULINK = new Item("siharaiworklist", "resultInfoTskSntk", "kojinNyuuryokuLink", null, ErrorMsgKbn.DISP);

    static final Item DDID_RESULTINFOTSKSNTK_KOJINITIRANLINK = new Item("siharaiworklist", "resultInfoTskSntk", "kojinItiranLink", null, ErrorMsgKbn.DISP);

    static final Item DDID_RESULTINFOTSKSNTK_KYYTSKKENSUU = new Item("siharaiworklist", "resultInfoTskSntk", "kyyTskKensuu", null, ErrorMsgKbn.DISP);

    static final Item DDID_RESULTINFOTSKSNTK_KYOUYOUNYUURYOKULINK = new Item("siharaiworklist", "resultInfoTskSntk", "kyouyouNyuuryokuLink", null, ErrorMsgKbn.DISP);

    static final Item DDID_RESULTINFOTSKSNTK_KYOUYOUITIRANLINK = new Item("siharaiworklist", "resultInfoTskSntk", "kyouyouItiranLink", null, ErrorMsgKbn.DISP);

    static final Item DDID_RESULTINFOITIRAN_DISPJIMUSTARTYMDTIME = new Item("siharaiworklist", "resultInfoItiran", "dispjimustartymdtime", null, ErrorMsgKbn.DISP);

    static final Item DDID_RESULTINFOITIRAN_SYONO = new Item("siharaiworklist", "resultInfoItiran", "syono", null, ErrorMsgKbn.DISP);

    static final Item DDID_RESULTINFOITIRAN_DISPSYOUHNNMWORKLIST = new Item("siharaiworklist", "resultInfoItiran", "dispsyouhnnmworklist", null, ErrorMsgKbn.DISP);

    static final Item DDID_RESULTINFOITIRAN_KYKNMKJ = new Item("siharaiworklist", "resultInfoItiran", "kyknmkj", null, ErrorMsgKbn.DISP);

    static final Item DDID_RESULTINFOITIRAN_DISPZENKAISYORITASK = new Item("siharaiworklist", "resultInfoItiran", "dispzenkaisyoritask", null, ErrorMsgKbn.DISP);

    static final Item DDID_RESULTINFOITIRAN_DISPZENKAISYORITANTOUNM = new Item("siharaiworklist", "resultInfoItiran", "dispzenkaisyoritantounm", null, ErrorMsgKbn.DISP);

    static final Item DDID_RESULTINFOITIRAN_NYUURYOKULINK = new Item("siharaiworklist", "resultInfoItiran", "nyuuryokuLink", null, ErrorMsgKbn.DD);

    static final Item DDID_LASTBUTTONS_MODORUBTN = new Item("siharaiworklist", "lastButtons", "modorubtn", null, ErrorMsgKbn.DD);
}
