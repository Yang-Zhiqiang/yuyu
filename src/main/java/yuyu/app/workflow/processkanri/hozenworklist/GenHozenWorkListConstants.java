package yuyu.app.workflow.processkanri.hozenworklist;

import jp.co.slcs.swak.bizinfr.configuration.Item;
import jp.co.slcs.swak.bizinfr.configuration.Item.ErrorMsgKbn;

/**
 * 契約保全工程ワークリスト 画面項目ID定義のベースクラスです。<br />
 * このソースはツールによる自動生成で、画面項目定義の変更に連動して更新されます。
 * 手書きコードを加えてはいけません。
 */
public class GenHozenWorkListConstants {

    public static final int PAGENO_INIT                              = 1;

    public static final int PAGENO_INPUTKEYTSKSNTKKYKHZN             = 1;

    public static final int PAGENO_INPUTKEYANKNITRNKYKHZN            = 2;

    static final String FORWARDNAME_INIT                              = "init";

    static final String FORWARDNAME_CURRENT                           = "current";

    static final String FORWARDNAME_INPUTKEYTSKSNTKKYKHZN             = "InputKeyTskSntkKykHzn";

    static final String FORWARDNAME_INPUTKEYANKNITRNKYKHZN            = "InputKeyAnknItrnKykHzn";

    static final String FORWARDNAME_ERROR                             = "Error";

    static final String FORWARDNAME_GOTOKHJYUUSYOHENKOU               = "goToKhJyuusyoHenkou";

    static final String FORWARDNAME_GOTOKHHUBITOUROKU                 = "goToKhHubiTouroku";

    static final String FORWARDNAME_GOTOKHHUBIKAISYOU                 = "goToKhHubiKaisyou";

    static final String FORWARDNAME_GOTOKHKAIYAKU                     = "goToKhKaiyaku";

    static final String FORWARDNAME_GOTOKHSYOUKENSAIHAKKOU            = "goToKhSyoukenSaihakkou";

    static final String FORWARDNAME_GOTOKHMEIGIHENKOU                 = "goToKhMeigiHenkou";

    static final String FORWARDNAME_GOTOKHSITEIDAIRITOKUYAKUHUKA      = "goToKhSiteidairiTokuyakuHuka";

    static final String FORWARDNAME_GOTOKHGENGAKU                     = "goToKhGengaku";

    static final String FORWARDNAME_GOTOKHTARGETTOKUYAKUHENKOU        = "goToKhTargetTokuyakuHenkou";

    static final String FORWARDNAME_GOTOKHNENKINSIHARAITOKUYAKUHENKOU = "goToKhNenkinSiharaiTokuyakuHenkou";

    static final String FORWARDNAME_GOTOKHSEINENGAPPISEITEISEI        = "goToKhSeinengappiSeiTeisei";

    static final String FORWARDNAME_GOTOKHSIHARAIKOUZAHENKOU          = "goToKhSiharaiKouzaHenkou";

    static final String FORWARDNAME_GOTOKHKEIYAKUTORIKESI             = "goToKhKeiyakuTorikesi";

    static final String FORWARDNAME_GOTOKHKAIGOMAEBARAITKHENKOU       = "goToKhKaigomaebaraiTkHenkou";

    static final String FORWARDNAME_GOTOKHMKHGKHENKOU                 = "goToKhMkhgkHenkou";

    static final String FORWARDNAME_GOTOKHYENDTHNKHRSHR               = "goToKhYendtHnkHrShr";

    static final String FORWARDNAME_GOTOKHTMTTKINITEN                 = "goToKhTmttkinIten";

    static final String FORWARDNAME_GOTOKHHARAIKATAHENKOU             = "goToKhHaraikataHenkou";

    static final String FORWARDNAME_GOTOKHDSHR                        = "goToKhDShr";

    static final String FORWARDNAME_GOTOKHYENDTHNKUKTKNINI            = "goToKhYendtHnkUktkNini";

    static final String FORWARDNAME_GOTOKHKZKTRKKYKDRHNK              = "goToKhKzktrkKykdrHnk";

    static final Item DDID_HEADERBUTTONS_TOJIRUBTN = new Item("hozenworklist", "headerButtons", "tojiruBtn", null, ErrorMsgKbn.DD);

    static final Item DDID_JIMUTETUZUKILABEL_DISPJIMUTETUZUKINM = new Item("hozenworklist", "jimutetuzukiLabel", "dispjimutetuzukinm", null, ErrorMsgKbn.DISP);

    static final Item DDID_SEARCHKEYINPUT_JIMUTETUZUKICD = new Item("hozenworklist", "searchKeyInput", "jimutetuzukicd", null, ErrorMsgKbn.DISP);

    static final Item DDID_SEARCHKEYINPUT_JIMUYOUCD = new Item("hozenworklist", "searchKeyInput", "jimuyoucd", null, ErrorMsgKbn.DISP);

    static final Item DDID_SEARCHKEYINPUT_JMYCDMISETTEIKBN = new Item("hozenworklist", "searchKeyInput", "jmycdMisetteiKbn", null, ErrorMsgKbn.DISP);

    static final Item DDID_SEARCHKEYINPUT_JIMUSTARTYMDFROM = new Item("hozenworklist", "searchKeyInput", "jimustartYmdFrom", null, ErrorMsgKbn.ERROR);

    static final Item DDID_SEARCHKEYINPUT_JIMUSTARTYMDTO = new Item("hozenworklist", "searchKeyInput", "jimustartYmdTo", null, ErrorMsgKbn.ERROR);

    static final Item DDID_SEARCHKEYINPUT_SYONO = new Item("hozenworklist", "searchKeyInput", "syono", null, ErrorMsgKbn.DISP);

    static final Item DDID_SEARCHCONDITIONBTN_CLEARBTN = new Item("hozenworklist", "searchConditionBtn", "clearbtn", null, ErrorMsgKbn.DD);

    static final Item DDID_SEARCHCONDITIONBTN_JOUKENHOZONBTN = new Item("hozenworklist", "searchConditionBtn", "joukenHozonBtn", null, ErrorMsgKbn.DD);

    static final Item DDID_RESULTINFOTSKSNTKBASE_JIMUTETUZUKICD = new Item("hozenworklist", "resultInfoTskSntkBase", "jimutetuzukicd", null, ErrorMsgKbn.DD);

    static final Item DDID_RESULTINFOTSKSNTK_JIMUTETUZUKICD = new Item("hozenworklist", "resultInfoTskSntk", "jimutetuzukicd", null, ErrorMsgKbn.DISP);

    static final Item DDID_RESULTINFOTSKSNTK_DISPJIMUTETUZUKINM = new Item("hozenworklist", "resultInfoTskSntk", "dispjimutetuzukinm", null, ErrorMsgKbn.DISP);

    static final Item DDID_RESULTINFOTSKSNTK_WORKFLOWTSKNM = new Item("hozenworklist", "resultInfoTskSntk", "workflowTskNm", null, ErrorMsgKbn.DISP);

    static final Item DDID_RESULTINFOTSKSNTK_KJNTSKKENSUU = new Item("hozenworklist", "resultInfoTskSntk", "kjnTskKensuu", null, ErrorMsgKbn.DISP);

    static final Item DDID_RESULTINFOTSKSNTK_KOJINNYUURYOKULINK = new Item("hozenworklist", "resultInfoTskSntk", "kojinNyuuryokuLink", null, ErrorMsgKbn.DISP);

    static final Item DDID_RESULTINFOTSKSNTK_KOJINITIRANLINK = new Item("hozenworklist", "resultInfoTskSntk", "kojinItiranLink", null, ErrorMsgKbn.DISP);

    static final Item DDID_RESULTINFOTSKSNTK_KYYTSKKENSUU = new Item("hozenworklist", "resultInfoTskSntk", "kyyTskKensuu", null, ErrorMsgKbn.DISP);

    static final Item DDID_RESULTINFOTSKSNTK_KYOUYOUNYUURYOKULINK = new Item("hozenworklist", "resultInfoTskSntk", "kyouyouNyuuryokuLink", null, ErrorMsgKbn.DISP);

    static final Item DDID_RESULTINFOTSKSNTK_KYOUYOUITIRANLINK = new Item("hozenworklist", "resultInfoTskSntk", "kyouyouItiranLink", null, ErrorMsgKbn.DISP);

    static final Item DDID_RESULTINFOITIRAN_DISPJIMUSTARTYMDTIME = new Item("hozenworklist", "resultInfoItiran", "dispjimustartymdtime", null, ErrorMsgKbn.DISP);

    static final Item DDID_RESULTINFOITIRAN_SYONO = new Item("hozenworklist", "resultInfoItiran", "syono", null, ErrorMsgKbn.DISP);

    static final Item DDID_RESULTINFOITIRAN_DISPSYOUHNNMWORKLIST = new Item("hozenworklist", "resultInfoItiran", "dispsyouhnnmworklist", null, ErrorMsgKbn.DISP);

    static final Item DDID_RESULTINFOITIRAN_KYKNMKJ = new Item("hozenworklist", "resultInfoItiran", "kyknmkj", null, ErrorMsgKbn.DISP);

    static final Item DDID_RESULTINFOITIRAN_DISPZENKAISYORITASK = new Item("hozenworklist", "resultInfoItiran", "dispzenkaisyoritask", null, ErrorMsgKbn.DISP);

    static final Item DDID_RESULTINFOITIRAN_DISPZENKAISYORITANTOUNM = new Item("hozenworklist", "resultInfoItiran", "dispzenkaisyoritantounm", null, ErrorMsgKbn.DISP);

    static final Item DDID_RESULTINFOITIRAN_NYUURYOKULINK = new Item("hozenworklist", "resultInfoItiran", "nyuuryokuLink", null, ErrorMsgKbn.DD);

    static final Item DDID_LASTBUTTONS_MODORUBTN = new Item("hozenworklist", "lastButtons", "modorubtn", null, ErrorMsgKbn.DD);
}
