package yuyu.common.workflow.wfcommon;

import java.io.Serializable;

import jp.co.slcs.swak.web.ui.UserDefsList;

/**
 * 権限ありサブシステムセレクト作成出力Beanクラス<br />
 */
public class GetExecutableSubSystemsSelectOutBean implements Serializable{

    private static final long serialVersionUID = 1L;

    private UserDefsList userDefsList;

    private String[] subSystemIdNameArray;

    public UserDefsList getUserDefsList() {
        return userDefsList;
    }

    public void setUserDefsList(UserDefsList userDefsList) {
        this.userDefsList = userDefsList;
    }

    public String[] getSubSystemIdNameArray() {
        return subSystemIdNameArray;
    }

    public void setSubSystemIdNameArray(String[] subSystemIdNameArray) {
        this.subSystemIdNameArray = subSystemIdNameArray;
    }



}
