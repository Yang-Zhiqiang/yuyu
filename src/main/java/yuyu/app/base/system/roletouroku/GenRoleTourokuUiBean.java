package yuyu.app.base.system.roletouroku;

import javax.inject.Inject;

import jp.co.slcs.swak.web.ui.AbstractUiBean;
import yuyu.def.db.entity.AM_Role;

/**
 * ロール登録 : 画面UiBeanの抽象親クラスです。<br />
 * このソースはツールによる自動生成で、画面項目定義の変更に連動して更新されます。
 * 手書きコードを加えないでください。
 */
public abstract class GenRoleTourokuUiBean extends AbstractUiBean {

    private static final long serialVersionUID = 1L;

    @Inject
    private AM_Role role;

    public AM_Role getRole() {
        return role;
    }

    public void setRole(AM_Role pRole) {
        role = pRole;
    }
}
