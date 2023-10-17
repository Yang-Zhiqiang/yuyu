package yuyu.app.biz.bzfiledl.bzfiledownload;

/**
 * ファイルダウンロード JavaScript(jQuery)用の 画面項目Selector 定数定義です。<br />
 * このソースはツールにより自動生成されたものです。
 * 画面項目定義に変更があると上書きされてしまうので、手で編集しないで下さい。
 */
public class GenBzFileDownloadSelector {


    public static final String HEADERBUTTONS = "'#headerButtons'";

    public static final String TOJIRUBTN_HEADERBUTTONS = "'#tojiruBtn'";


    public static final String BASEINFO = "'#baseInfo'";

    public static final String FILESYURUI_BASEINFO = "'#filesyurui'";


    public static final String FILEINFOLIST = "'#fileInfoList'";

    public static final String FILENM_FILEINFOLIST(int index) {
        return "'#fileInfoList\\\\[" + index + "\\\\]\\\\.fileNm'";
    }

    public static final String TOUROKUTIME_FILEINFOLIST(int index) {
        return "'#fileInfoList\\\\[" + index + "\\\\]\\\\.tourokuTime'";
    }

    public static final String SANSYOUCOUNT_FILEINFOLIST(int index) {
        return "'#fileInfoList\\\\[" + index + "\\\\]\\\\.sansyoucount'";
    }


    public static final String FOOTERBUTTONS1 = "'#footerButtons1'";

    public static final String KAKUTEIBTN_FOOTERBUTTONS1 = "'#kakuteiBtn'";


    public static final String FOOTERBUTTONS2 = "'#footerButtons2'";

    public static final String MODORUBTN_FOOTERBUTTONS2 = "'#modorubtn'";
}
