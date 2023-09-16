package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_FstauthoriKbn;

/**
 * {@link C_FstauthoriKbn 初回オーソリ区分} の Hibernate ユーザー定義型です。<br />
 * 初回オーソリ区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_FstauthoriKbn extends AbstractUserType<C_FstauthoriKbn> {

    @Override
    protected Class<C_FstauthoriKbn> returnType() {
        return C_FstauthoriKbn.class;
    }

    @Override
    protected C_FstauthoriKbn valueOf(String pValue) {
        return C_FstauthoriKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_FstauthoriKbn pValue) {
        return pValue.getValue();
    }
}
