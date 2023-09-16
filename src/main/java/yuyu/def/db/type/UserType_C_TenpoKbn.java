package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_TenpoKbn;

/**
 * {@link C_TenpoKbn 店舗区分} の Hibernate ユーザー定義型です。<br />
 * 店舗区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_TenpoKbn extends AbstractUserType<C_TenpoKbn> {

    @Override
    protected Class<C_TenpoKbn> returnType() {
        return C_TenpoKbn.class;
    }

    @Override
    protected C_TenpoKbn valueOf(String pValue) {
        return C_TenpoKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_TenpoKbn pValue) {
        return pValue.getValue();
    }
}
