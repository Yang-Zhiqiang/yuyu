package yuyu.app.workflow.processkanri.wariatekaijyo;

/**
 * 担当者割当解除 JavaScript(jQuery)用の 画面項目Selector 定数定義です。<br />
 * このソースはツールにより自動生成されたものです。
 * 画面項目定義に変更があると上書きされてしまうので、手で編集しないで下さい。
 */
public class GenWariateKaijyoSelector {


    public static final String HEADERBUTTONS = "'#headerButtons'";

    public static final String TOJIRUBTN_HEADERBUTTONS = "'#tojiruBtn'";


    public static final String SEARCHINFO = "'#searchInfo'";

    public static final String SUBSYSTEMID_SEARCHINFO = "'#subSystemId'";

    public static final String JIMUTETUZUKICD_SEARCHINFO = "'#jimutetuzukicd'";

    public static final String WORKFLOWTSKNM_SEARCHINFO = "'#workflowTskNm'";

    public static final String TANTID_SEARCHINFO = "'#tantid'";


    public static final String SEARCHBUTTONS = "'#searchButtons'";

    public static final String SEARCHBTN_SEARCHBUTTONS = "'#searchBtn'";


    public static final String TASKSERINFO = "'#taskserInfo'";

    public static final String DISPJIMUSTARTYMD_TASKSERINFO(int index) {
        return "'#taskserInfo\\\\[" + index + "\\\\]\\\\.dispjimustartymd'";
    }

    public static final String DISPTASKNM_TASKSERINFO(int index) {
        return "'#taskserInfo\\\\[" + index + "\\\\]\\\\.disptasknm'";
    }

    public static final String DISPTANTOUNM_TASKSERINFO(int index) {
        return "'#taskserInfo\\\\[" + index + "\\\\]\\\\.disptantounm'";
    }

    public static final String DISPGYOUMUKEY_TASKSERINFO(int index) {
        return "'#taskserInfo\\\\[" + index + "\\\\]\\\\.dispGyoumuKey'";
    }

    public static final String WARIATEKAIJYOLINK_TASKSERINFO(int index) {
        return "'#taskserInfo\\\\[" + index + "\\\\]\\\\.wariateKaijyoLink'";
    }
}
