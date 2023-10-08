package yuyu.app.siharai.sihubikanri.sihubinaiyoukensaku;

import jp.co.slcs.swak.bizinfr.configuration.Item;
import jp.co.slcs.swak.bizinfr.configuration.Item.ErrorMsgKbn;

/**
 * 保険金給付金不備内容検索 画面項目ID定義のベースクラスです。<br />
 * このソースはツールによる自動生成で、画面項目定義の変更に連動して更新されます。
 * 手書きコードを加えてはいけません。
 */
public class GenSiHubiNaiyouKensakuConstants {

    public static final int PAGENO_INIT       = 1;

    public static final int PAGENO_SELECTDATA = 1;

    static final String FORWARDNAME_INIT       = "init";

    static final String FORWARDNAME_SELECTDATA = "SelectData";

    static final Item DDID_HEADERBUTTONS_TOJIRUBTN = new Item("sihubinaiyoukensaku", "headerButtons", "tojiruBtn", null, ErrorMsgKbn.DD);

    static final Item DDID_SEARCHCONDITIONS_DISPJIMUTETUZUKINM = new Item("sihubinaiyoukensaku", "searchConditions", "dispjimutetuzukinm", null, ErrorMsgKbn.DISP);

    static final Item DDID_SEARCHCONDITIONS_DISPSYORUINMSNTK = new Item("sihubinaiyoukensaku", "searchConditions", "dispsyoruinmsntk", null, ErrorMsgKbn.DISP);

    static final Item DDID_HUBINAIYOULIST_DISPHUBINAIYOU = new Item("sihubinaiyoukensaku", "hubinaiyouList", "disphubinaiyou", null, ErrorMsgKbn.DISP);

    static final Item DDID_HUBINAIYOULIST_DISPHUBINAIYOUMSG = new Item("sihubinaiyoukensaku", "hubinaiyouList", "disphubinaiyoumsg", null, ErrorMsgKbn.DISP);

    static final Item DDID_HUBINAIYOULIST_SYORUICD = new Item("sihubinaiyoukensaku", "hubinaiyouList", "syoruiCd", null, ErrorMsgKbn.DD);

    static final Item DDID_HUBINAIYOULIST_SYORUINM = new Item("sihubinaiyoukensaku", "hubinaiyouList", "syoruinm", null, ErrorMsgKbn.DD);

    static final Item DDID_HUBINAIYOULIST_HUBINAIYOUCD = new Item("sihubinaiyoukensaku", "hubinaiyouList", "hubinaiyoucd", null, ErrorMsgKbn.DD);

    static final Item DDID_HUBINAIYOULIST_SENTAKULINK = new Item("sihubinaiyoukensaku", "hubinaiyouList", "sentakulink", null, ErrorMsgKbn.DD);
}
