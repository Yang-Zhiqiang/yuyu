package yuyu.testinfr.inject;

import yuyu.common.base.BaseUserInfo;
import yuyu.def.db.entity.AM_User;

public class MockBaseUserInfo extends BaseUserInfo {

    private static final long serialVersionUID = -2542383758850201724L;

    public MockBaseUserInfo(AM_User pUser) {
        super(pUser);
    }

    public MockBaseUserInfo() {
        super(null);
    }

    public MockBaseUserInfo(BaseUserInfo pBaseUserInfo) {
        super(pBaseUserInfo.getUser());
    }
}
