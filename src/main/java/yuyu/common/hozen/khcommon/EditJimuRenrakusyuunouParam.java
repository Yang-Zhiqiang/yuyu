package yuyu.common.hozen.khcommon;

import java.util.List;

/**
 * 契約保全 契約保全共通 事務連絡票(収納)編集用パラメータ
 */
public class EditJimuRenrakusyuunouParam {

    List<String> jimuRenrakuMsgList;

    public EditJimuRenrakusyuunouParam() {
        super();
    }

    public List<String> getJimurenrakuMsgList() {
        return jimuRenrakuMsgList;
    }

    public void setJimurenrakuMsgList(List<String> pJimurenrakuMsgList) {
        jimuRenrakuMsgList = pJimurenrakuMsgList;
    }
}
