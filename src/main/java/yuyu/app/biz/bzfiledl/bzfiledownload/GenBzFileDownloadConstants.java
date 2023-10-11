package yuyu.app.biz.bzfiledl.bzfiledownload;

import jp.co.slcs.swak.bizinfr.configuration.Item;
import jp.co.slcs.swak.bizinfr.configuration.Item.ErrorMsgKbn;

/**
 * ファイルダウンロード 画面項目ID定義のベースクラスです。<br />
 * このソースはツールによる自動生成で、画面項目定義の変更に連動して更新されます。
 * 手書きコードを加えてはいけません。
 */
public class GenBzFileDownloadConstants {

    public static final int PAGENO_INIT              = 1;

    public static final int PAGENO_INPUTKEY          = 1;

    public static final int PAGENO_DOWNLOAD          = 2;

    public static final int PAGENO_OUTPUTKENGENERROR = 3;

    static final String FORWARDNAME_INIT              = "init";

    static final String FORWARDNAME_CURRENT           = "current";

    static final String FORWARDNAME_INPUTKEY          = "InputKey";

    static final String FORWARDNAME_DOWNLOAD          = "Download";

    static final String FORWARDNAME_OUTPUTKENGENERROR = "OutputKengenError";

    static final Item DDID_HEADERBUTTONS_TOJIRUBTN = new Item("bzfiledownload", "headerButtons", "tojiruBtn", null, ErrorMsgKbn.DD);

    static final Item DDID_BASEINFO_FILESYURUI = new Item("bzfiledownload", "baseInfo", "filesyurui", null, ErrorMsgKbn.DD);

    static final Item DDID_FILEINFOLIST_FILENM = new Item("bzfiledownload", "fileInfoList", "fileNm", null, ErrorMsgKbn.DD);

    static final Item DDID_FILEINFOLIST_TOUROKUTIME = new Item("bzfiledownload", "fileInfoList", "tourokuTime", null, ErrorMsgKbn.DISP);

    static final Item DDID_FILEINFOLIST_SANSYOUCOUNT = new Item("bzfiledownload", "fileInfoList", "sansyoucount", null, ErrorMsgKbn.DD);
}
