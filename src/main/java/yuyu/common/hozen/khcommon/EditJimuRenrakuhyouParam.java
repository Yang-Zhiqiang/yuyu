package yuyu.common.hozen.khcommon;

import java.util.List;

/**
 * 契約保全 契約保全共通 事務連絡票作成用パラメータ
 */
public class EditJimuRenrakuhyouParam {

    List<String> jimuRenrakuMsgList;

    public EditJimuRenrakuhyouParam() {
        super();
    }

    public List<String> getJimurenrakuMsgList() {
        return jimuRenrakuMsgList;
    }

    public void setJimurenrakuMsgList(List<String> pJimurenrakuMsgList) {
        jimuRenrakuMsgList = pJimurenrakuMsgList;
    }
}
