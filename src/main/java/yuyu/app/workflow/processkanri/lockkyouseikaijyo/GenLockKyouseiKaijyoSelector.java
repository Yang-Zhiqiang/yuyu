package yuyu.app.workflow.processkanri.lockkyouseikaijyo;

/**
 * 工程ロック強制解除 JavaScript(jQuery)用の 画面項目Selector 定数定義です。<br />
 * このソースはツールにより自動生成されたものです。
 * 画面項目定義に変更があると上書きされてしまうので、手で編集しないで下さい。
 */
public class GenLockKyouseiKaijyoSelector {


    public static final String HEADERBUTTONS = "'#headerButtons'";

    public static final String TOJIRUBTN_HEADERBUTTONS = "'#tojiruBtn'";


    public static final String SEARCHCONDITIONS = "'#searchConditions'";

    public static final String SUBSYSTEMID_SEARCHCONDITIONS = "'#subSystemId'";

    public static final String JIMUTETUZUKICD_SEARCHCONDITIONS = "'#jimutetuzukicd'";

    public static final String MOSNO_SEARCHCONDITIONS = "'#mosno'";

    public static final String SYONO_SEARCHCONDITIONS = "'#syono'";

    public static final String NKSYSYNO_SEARCHCONDITIONS = "'#nksysyno'";


    public static final String SEARCHBUTTONS = "'#searchButtons'";

    public static final String SEARCHBTN_SEARCHBUTTONS = "'#searchBtn'";


    public static final String LOCKEDTASKINFOLIST = "'#lockedTaskInfoList'";

    public static final String DISPGYOUMUKEY_LOCKEDTASKINFOLIST(int index) {
        return "'#lockedTaskInfoList\\\\[" + index + "\\\\]\\\\.dispGyoumuKey'";
    }

    public static final String DISPJIMUSTARTYMD_LOCKEDTASKINFOLIST(int index) {
        return "'#lockedTaskInfoList\\\\[" + index + "\\\\]\\\\.dispjimustartymd'";
    }

    public static final String DISPTASKNM_LOCKEDTASKINFOLIST(int index) {
        return "'#lockedTaskInfoList\\\\[" + index + "\\\\]\\\\.disptasknm'";
    }

    public static final String DISPTANTOUNM_LOCKEDTASKINFOLIST(int index) {
        return "'#lockedTaskInfoList\\\\[" + index + "\\\\]\\\\.disptantounm'";
    }

    public static final String LOCKKAIJYOLINK_LOCKEDTASKINFOLIST(int index) {
        return "'#lockedTaskInfoList\\\\[" + index + "\\\\]\\\\.lockKaijyoLink'";
    }
}
