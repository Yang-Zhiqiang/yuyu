package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_HubisyubetusyousaiKbn;

/**
 * {@link C_HubisyubetusyousaiKbn 不備種別詳細区分} の Hibernate ユーザー定義型です。<br />
 * 不備種別詳細区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_HubisyubetusyousaiKbn extends AbstractUserType<C_HubisyubetusyousaiKbn> {

    @Override
    protected Class<C_HubisyubetusyousaiKbn> returnType() {
        return C_HubisyubetusyousaiKbn.class;
    }

    @Override
    protected C_HubisyubetusyousaiKbn valueOf(String pValue) {
        return C_HubisyubetusyousaiKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_HubisyubetusyousaiKbn pValue) {
        return pValue.getValue();
    }
}
