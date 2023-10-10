package yuyu.app.base.system.holidaygrouptouroku;

/**
 * 休日グループ登録 JavaScript(jQuery)用の 画面項目Selector 定数定義です。<br />
 * このソースはツールにより自動生成されたものです。
 * 画面項目定義に変更があると上書きされてしまうので、手で編集しないで下さい。
 */
public class GenHolidayGroupTourokuSelector {


    public static final String HEADERBUTTONS = "'#headerButtons'";

    public static final String TOJIRUBTN_HEADERBUTTONS = "'#tojiruBtn'";


    public static final String KEYINFO = "'#keyInfo'";

    public static final String HOLIDAYGROUPCD_KEYINFO = "'#holidayGroup\\\\.holidayGroupCd'";


    public static final String BUTTONINPUTKEY = "'#buttonInputKey'";

    public static final String TOUROKUBTN_BUTTONINPUTKEY = "'#tourokuBtn'";


    public static final String HOLIDAYGROUPINFOLIST = "'#holidayGroupInfoList'";

    public static final String HOLIDAYGROUPCD_HOLIDAYGROUPINFOLIST(int index) {
        return "'#holidayGroupInfoList\\\\[" + index + "\\\\]\\\\.holidayGroupCd'";
    }

    public static final String HOLIDAYGROUPNM_HOLIDAYGROUPINFOLIST(int index) {
        return "'#holidayGroupInfoList\\\\[" + index + "\\\\]\\\\.holidayGroupNm'";
    }

    public static final String HOLIDAYGROUPDESCRIPTION_HOLIDAYGROUPINFOLIST(int index) {
        return "'#holidayGroupInfoList\\\\[" + index + "\\\\]\\\\.holidayGroupDescription'";
    }

    public static final String HENKOULINK_HOLIDAYGROUPINFOLIST(int index) {
        return "'#holidayGroupInfoList\\\\[" + index + "\\\\]\\\\.henkouLink'";
    }

    public static final String SAKUJYOLINK_HOLIDAYGROUPINFOLIST(int index) {
        return "'#holidayGroupInfoList\\\\[" + index + "\\\\]\\\\.sakujyoLink'";
    }


    public static final String HOLIDAYGROUPINFO = "'#holidayGroupInfo'";

    public static final String HOLIDAYGROUPCD_HOLIDAYGROUPINFO = "'#holidayGroup\\\\.holidayGroupCd'";

    public static final String HOLIDAYGROUPNM_HOLIDAYGROUPINFO = "'#holidayGroup\\\\.holidayGroupNm'";

    public static final String HOLIDAYGROUPDESCRIPTION_HOLIDAYGROUPINFO = "'#holidayGroup\\\\.holidayGroupDescription'";


    public static final String BUTTONINPUTCONTENTS = "'#buttonInputContents'";

    public static final String MODORUBTNBYINPUTCONTENTS_BUTTONINPUTCONTENTS = "'#modoruBtnByInputContents'";

    public static final String MODORUBTNBYCONFIRM_BUTTONINPUTCONTENTS = "'#modoruBtnByConfirm'";

    public static final String KAKUNINBTN_BUTTONINPUTCONTENTS = "'#kakuninBtn'";

    public static final String KAKUTEIBTN_BUTTONINPUTCONTENTS = "'#kakuteiBtn'";

    public static final String SYOKIGAMENHEBTN_BUTTONINPUTCONTENTS = "'#syokigamenheBtn'";
}
