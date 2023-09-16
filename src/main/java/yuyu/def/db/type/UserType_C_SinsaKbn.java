package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_SinsaKbn;

/**
 * {@link C_SinsaKbn 診査区分} の Hibernate ユーザー定義型です。<br />
 * 診査区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_SinsaKbn extends AbstractUserType<C_SinsaKbn> {

    @Override
    protected Class<C_SinsaKbn> returnType() {
        return C_SinsaKbn.class;
    }

    @Override
    protected C_SinsaKbn valueOf(String pValue) {
        return C_SinsaKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_SinsaKbn pValue) {
        return pValue.getValue();
    }
}
