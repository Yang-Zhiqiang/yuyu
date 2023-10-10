package yuyu.app.base.system.usergrouptouroku;

import javax.inject.Inject;

import jp.co.slcs.swak.web.ui.AbstractUiBean;
import yuyu.def.db.entity.AM_UserGroup;

/**
 * ユーザーグループ登録 : 画面UiBeanの抽象親クラスです。<br />
 * このソースはツールによる自動生成で、画面項目定義の変更に連動して更新されます。
 * 手書きコードを加えないでください。
 */
public abstract class GenUserGroupTourokuUiBean extends AbstractUiBean {

    private static final long serialVersionUID = 1L;

    @Inject
    private AM_UserGroup userGroup;

    public AM_UserGroup getUserGroup() {
        return userGroup;
    }

    public void setUserGroup(AM_UserGroup pUserGroup) {
        userGroup = pUserGroup;
    }
}
