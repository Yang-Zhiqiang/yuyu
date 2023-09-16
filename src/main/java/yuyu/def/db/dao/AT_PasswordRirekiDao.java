package yuyu.def.db.dao;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.db.entity.AT_PasswordRireki;

/**
 * パスワード履歴テーブル( AT_PasswordRireki ) に対するDB操作を提供する。
 */
public class AT_PasswordRirekiDao extends AbstractDao<AT_PasswordRireki> {

    protected AT_PasswordRirekiDao() {
        super(AT_PasswordRireki.class);
    }

    public AT_PasswordRireki getPasswordRirekiByUniqueId(String pUniqueId){

        AT_PasswordRireki passwordRireki = new AT_PasswordRireki();
        passwordRireki.setUniqueId(pUniqueId);

        return selectOne(passwordRireki);
    }

}
