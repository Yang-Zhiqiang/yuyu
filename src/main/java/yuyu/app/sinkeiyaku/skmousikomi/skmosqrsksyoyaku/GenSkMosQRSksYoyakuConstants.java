package yuyu.app.sinkeiyaku.skmousikomi.skmosqrsksyoyaku;

import jp.co.slcs.swak.bizinfr.configuration.Item;
import jp.co.slcs.swak.bizinfr.configuration.Item.ErrorMsgKbn;

/**
 * 申込書類用QR作成予約 画面項目ID定義のベースクラスです。<br />
 * このソースはツールによる自動生成で、画面項目定義の変更に連動して更新されます。
 * 手書きコードを加えてはいけません。
 */
public class GenSkMosQRSksYoyakuConstants {

    public static final int PAGENO_INIT          = 1;

    public static final int PAGENO_INPUTCONTENTS = 1;

    static final String FORWARDNAME_INIT          = "init";

    static final String FORWARDNAME_INPUTCONTENTS = "InputContents";

    static final Item DDID_HEADERBUTTONS_TOJIRUBTN = new Item("skmosqrsksyoyaku", "headerButtons", "tojiruBtn", null, ErrorMsgKbn.DD);

    static final Item DDID_INPUTYOYAKUINFO_SKEIJIMUKBN = new Item("skmosqrsksyoyaku", "inputyoyakuInfo", "skeijimukbn", null, ErrorMsgKbn.DISP);

    static final Item DDID_INPUTYOYAKUINFO_HKNSYURUINM = new Item("skmosqrsksyoyaku", "inputyoyakuInfo", "hknsyuruinm", null, ErrorMsgKbn.DISP);

    static final Item DDID_INPUTYOYAKUINFO_MOSNOSAIBANKBN = new Item("skmosqrsksyoyaku", "inputyoyakuInfo", "mosnosaibankbn", null, ErrorMsgKbn.DD);

    static final Item DDID_INPUTYOYAKUINFO_SAKUSEIKENSUU = new Item("skmosqrsksyoyaku", "inputyoyakuInfo", "sakuseikensuu", null, ErrorMsgKbn.DD);

    static final Item DDID_YOYAKUINFOLIST_DISPTRKYMD = new Item("skmosqrsksyoyaku", "yoyakuInfoList", "disptrkymd", null, ErrorMsgKbn.DISP);

    static final Item DDID_YOYAKUINFOLIST_DISPQRYOYAKUTIME = new Item("skmosqrsksyoyaku", "yoyakuInfoList", "dispqryoyakutime", null, ErrorMsgKbn.DISP);

    static final Item DDID_YOYAKUINFOLIST_DISPSKEIJIMUKBN = new Item("skmosqrsksyoyaku", "yoyakuInfoList", "dispskeijimukbn", null, ErrorMsgKbn.DISP);

    static final Item DDID_YOYAKUINFOLIST_DISPHKNSYURUINO = new Item("skmosqrsksyoyaku", "yoyakuInfoList", "disphknsyuruino", null, ErrorMsgKbn.DISP);

    static final Item DDID_YOYAKUINFOLIST_DISPMOSNOSAIBANKBN = new Item("skmosqrsksyoyaku", "yoyakuInfoList", "dispmosnosaibankbn", null, ErrorMsgKbn.DISP);

    static final Item DDID_YOYAKUINFOLIST_DISPSAKUSEIKENSUU = new Item("skmosqrsksyoyaku", "yoyakuInfoList", "dispsakuseikensuu", null, ErrorMsgKbn.DISP);

    static final Item DDID_YOYAKUINFOLIST_SAKUJYOLINK = new Item("skmosqrsksyoyaku", "yoyakuInfoList", "sakujyoLink", null, ErrorMsgKbn.DISP);
}
