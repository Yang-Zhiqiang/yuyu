package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_YuukouKbn;

/**
 * {@link C_YuukouKbn 有効区分} の Hibernate ユーザー定義型です。<br />
 * 有効区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_YuukouKbn extends AbstractUserType<C_YuukouKbn> {

    @Override
    protected Class<C_YuukouKbn> returnType() {
        return C_YuukouKbn.class;
    }

    @Override
    protected C_YuukouKbn valueOf(String pValue) {
        return C_YuukouKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_YuukouKbn pValue) {
        return pValue.getValue();
    }
}
