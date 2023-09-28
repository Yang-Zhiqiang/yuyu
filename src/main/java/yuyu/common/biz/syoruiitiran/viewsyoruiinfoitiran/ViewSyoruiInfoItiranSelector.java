package yuyu.common.biz.syoruiitiran.viewsyoruiinfoitiran;

/**
 * 業務共通 書類情報一覧 書類情報一覧表示 JavaScript(jQuery)用の 画面項目Selector 定数定義です。<br />
 */
public class ViewSyoruiInfoItiranSelector {


    public static final String SYORUIINFOLIST = "'#syoruiInfoList'";

    public static final String SYORUITTYKYMDTIME_SYORUIINFOLIST(int index) {
        return "'#syoruiInfoList\\\\[" + index + "\\\\]\\\\.syoruittykymdtime'";
    }

    public static final String SYORUINM_SYORUIINFOLIST(int index) {
        return "'#syoruiInfoList\\\\[" + index + "\\\\]\\\\.syoruinm'";
    }

    public static final String HTYSYORUIUMUKBN_SYORUIINFOLIST(int index) {
        return "'#syoruiInfoList\\\\[" + index + "\\\\]\\\\.htysyoruiumukbn'";
    }

    public static final String HYOUJILINK_SYORUIINFOLIST(int index) {
        return "'#syoruiInfoList\\\\[" + index + "\\\\]\\\\.hyoujilink'";
    }

    public static final String IMAGEID_SYORUIINFOLIST(int index) {
        return "'#syoruiInfoList\\\\[" + index + "\\\\]\\\\.imageid'";
    }

    public static final String BUTTONALLHYOUJI = "'#buttonAllhyouji'";

    public static final String ALLHYOUJIBTN_BUTTONALLHYOUJI = "'#allhyoujibtn'";

    public static final String HIDDENGROUP = "'#hiddenGroup'";

    public static final String IMAGEID_HIDDENGROUP = "'#imageid'";

}
