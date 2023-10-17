package yuyu.app.sinkeiyaku.sknyuukin.skhurikomisakujyotouroku;

import jp.co.slcs.swak.bizinfr.configuration.Item;
import jp.co.slcs.swak.bizinfr.configuration.Item.ErrorMsgKbn;

/**
 * 振込入金削除データ登録 画面項目ID定義のベースクラスです。<br />
 * このソースはツールによる自動生成で、画面項目定義の変更に連動して更新されます。
 * 手書きコードを加えてはいけません。
 */
public class GenSkHurikomiSakujyoTourokuConstants {

    public static final int PAGENO_INIT          = 1;

    public static final int PAGENO_INPUTCONTENTS = 1;

    static final String FORWARDNAME_INIT          = "init";

    static final String FORWARDNAME_CURRENT       = "current";

    static final String FORWARDNAME_INPUTCONTENTS = "InputContents";

    static final Item DDID_HEADERBUTTONS_TOJIRUBTN = new Item("skhurikomisakujyotouroku", "headerButtons", "tojiruBtn", null, ErrorMsgKbn.DD);

    static final Item DDID_BASEINFO_SAKUJYOTRKYMD = new Item("skhurikomisakujyotouroku", "baseInfo", "sakujyotrkymd", null, ErrorMsgKbn.DD);

    static final Item DDID_KIHONINFO_MOSNOCHKNASI = new Item("skhurikomisakujyotouroku", "kihonInfo", "mosnochknasi", null, ErrorMsgKbn.DD);

    static final Item DDID_KIHONINFO_OYADRTENCD = new Item("skhurikomisakujyotouroku", "kihonInfo", "oyadrtencd", null, ErrorMsgKbn.DD);

    static final Item DDID_KIHONINFO_RSTUUKASYU = new Item("skhurikomisakujyotouroku", "kihonInfo", "rstuukasyu", null, ErrorMsgKbn.DISP);

    static final Item DDID_KIHONINFO_HRKMIRNINNM = new Item("skhurikomisakujyotouroku", "kihonInfo", "hrkmirninnm", null, ErrorMsgKbn.DISP);

    static final Item DDID_KIHONINFO_RSGAKU = new Item("skhurikomisakujyotouroku", "kihonInfo", "rsgaku", null, ErrorMsgKbn.DD);

    static final Item DDID_SAKUJYOINFOLIST_DISPTRKYMD = new Item("skhurikomisakujyotouroku", "sakujyoInfoList", "disptrkymd", null, ErrorMsgKbn.DISP);

    static final Item DDID_SAKUJYOINFOLIST_DISPMOSNO = new Item("skhurikomisakujyotouroku", "sakujyoInfoList", "dispmosno", null, ErrorMsgKbn.DISP);

    static final Item DDID_SAKUJYOINFOLIST_DISPHRKMIRNINNM = new Item("skhurikomisakujyotouroku", "sakujyoInfoList", "disphrkmirninnm", null, ErrorMsgKbn.DISP);

    static final Item DDID_SAKUJYOINFOLIST_DISPOYADRTENCD = new Item("skhurikomisakujyotouroku", "sakujyoInfoList", "dispoyadrtencd", null, ErrorMsgKbn.DISP);

    static final Item DDID_SAKUJYOINFOLIST_DISPRSTUUKASYU = new Item("skhurikomisakujyotouroku", "sakujyoInfoList", "disprstuukasyu", null, ErrorMsgKbn.DISP);

    static final Item DDID_SAKUJYOINFOLIST_DISPRSKINGAKU = new Item("skhurikomisakujyotouroku", "sakujyoInfoList", "disprskingaku", null, ErrorMsgKbn.DISP);

    static final Item DDID_SAKUJYOINFOLIST_DISPSAKUJYOLINK = new Item("skhurikomisakujyotouroku", "sakujyoInfoList", "dispsakujyoLink", null, ErrorMsgKbn.DISP);

    static final Item DDID_SAKUJYOINFOLIST_SAKUJYOLINK = new Item("skhurikomisakujyotouroku", "sakujyoInfoList", "sakujyoLink", null, ErrorMsgKbn.DD);
}
