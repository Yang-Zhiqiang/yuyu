package yuyu.app.workflow.processkanri.kouteikaisitouroku;

/**
 * 工程開始登録 JavaScript(jQuery)用の 画面項目Selector 定数定義です。<br />
 * このソースはツールにより自動生成されたものです。
 * 画面項目定義に変更があると上書きされてしまうので、手で編集しないで下さい。
 */
public class GenKouteiKaisiTourokuSelector {


    public static final String HEADERBUTTONS = "'#headerButtons'";

    public static final String TOJIRUBTN_HEADERBUTTONS = "'#tojiruBtn'";


    public static final String TOROKUINFO1 = "'#torokuInfo1'";

    public static final String DISPNO_TOROKUINFO1(int index) {
        return "'#torokuInfo1\\\\[" + index + "\\\\]\\\\.dispno'";
    }

    public static final String WORKFLOWDOCUMENTID_TOROKUINFO1(int index) {
        return "'#torokuInfo1\\\\[" + index + "\\\\]\\\\.workflowDocumentId'";
    }


    public static final String BUTTONSERCH = "'#buttonSerch'";

    public static final String KAKUNINBTN_BUTTONSERCH = "'#kakuninBtn'";


    public static final String TOROKUINFO2 = "'#torokuInfo2'";

    public static final String DISPNO_TOROKUINFO2(int index) {
        return "'#torokuInfo2\\\\[" + index + "\\\\]\\\\.dispno'";
    }

    public static final String WORKFLOWDISPDOCUMENTID_TOROKUINFO2(int index) {
        return "'#torokuInfo2\\\\[" + index + "\\\\]\\\\.workflowDispDocumentId'";
    }

    public static final String DISPSYORUINMRYAKU_TOROKUINFO2(int index) {
        return "'#torokuInfo2\\\\[" + index + "\\\\]\\\\.dispsyoruinmryaku'";
    }


    public static final String LASTBUTTONS = "'#lastButtons'";

    public static final String MODORUBTN_LASTBUTTONS = "'#modorubtn'";

    public static final String KAKUTEIBTN_LASTBUTTONS = "'#kakuteiBtn'";

    public static final String SYOKIGAMENHEBTN_LASTBUTTONS = "'#syokigamenheBtn'";
}
