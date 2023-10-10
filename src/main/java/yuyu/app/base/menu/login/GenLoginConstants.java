package yuyu.app.base.menu.login;

import jp.co.slcs.swak.bizinfr.configuration.Item;
import jp.co.slcs.swak.bizinfr.configuration.Item.ErrorMsgKbn;

/**
 * ログイン 画面項目ID定義のベースクラスです。<br />
 * このソースはツールによる自動生成で、画面項目定義の変更に連動して更新されます。
 * 手書きコードを加えてはいけません。
 */
public class GenLoginConstants {

    public static final int PAGENO_INIT     = 1;

    public static final int PAGENO_LOGIN    = 1;

    public static final int PAGENO_CTIMENU  = 2;

    static final String FORWARDNAME_INIT     = "init";

    static final String FORWARDNAME_LOGIN    = "login";

    static final String FORWARDNAME_CTIMENU  = "ctiMenu";

    static final String FORWARDNAME_GOTOMENU = "gotoMenu";

    static final Item DDID_LOGININPUT_TANMATUSETTISOSIKICD = new Item("login", "loginInput", "tanmatusettisosikicd", null, ErrorMsgKbn.DISP);

    static final Item DDID_BUTTONGROUP_CTIMENUBTN = new Item("login", "buttonGroup", "ctiMenuBtn", null, ErrorMsgKbn.DD);

    static final Item DDID_BUTTONGROUP_CTIKEIYAKUSYOUKAIBTN = new Item("login", "buttonGroup", "ctiKeiyakuSyoukaiBtn", null, ErrorMsgKbn.DD);

    static final Item DDID_BUTTONGROUP_CTIKAIYAKUBTN = new Item("login", "buttonGroup", "ctiKaiyakuBtn", null, ErrorMsgKbn.DD);

    static final Item DDID_BUTTONGROUP_CTIKOKYAKUSEIBIBTN = new Item("login", "buttonGroup", "ctiKokyakuSeibiBtn", null, ErrorMsgKbn.DD);

    static final Item DDID_BUTTONGROUP_CTIHKKINGAKUSISANBTN = new Item("login", "buttonGroup", "ctiHkkingakuSisanBtn", null, ErrorMsgKbn.DD);

    static final Item DDID_BUTTONGROUPUNDER_CTIJYUUSYOHENKOUBTN = new Item("login", "buttonGroupUnder", "ctiJyuusyoHenkouBtn", null, ErrorMsgKbn.DD);

    static final Item DDID_BUTTONGROUPUNDER_CTIONLINEDATTAISYORIBTN = new Item("login", "buttonGroupUnder", "ctiOnlinedattaisyoriBtn", null, ErrorMsgKbn.DD);

    static final Item DDID_BUTTONGROUPUNDER_CTIGENGAKUBTN = new Item("login", "buttonGroupUnder", "ctiGengakuBtn", null, ErrorMsgKbn.DD);

    static final Item DDID_BUTTONGROUPUNDER_CTIHARAIKATAHNKBTN = new Item("login", "buttonGroupUnder", "ctiHaraikatahnkBtn", null, ErrorMsgKbn.DD);

    static final Item DDID_BUTTONGROUPUNDER_CTIKHKZKTRKKYKDRHNKBTN = new Item("login", "buttonGroupUnder", "ctiKhKzktrkKykdrHnkBtn", null, ErrorMsgKbn.DD);
}
