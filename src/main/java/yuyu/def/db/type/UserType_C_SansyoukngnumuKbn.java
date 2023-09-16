package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_SansyoukngnumuKbn;

/**
 * {@link C_SansyoukngnumuKbn 参照権限有無区分} の Hibernate ユーザー定義型です。<br />
 * 参照権限有無区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_SansyoukngnumuKbn extends AbstractUserType<C_SansyoukngnumuKbn> {

    @Override
    protected Class<C_SansyoukngnumuKbn> returnType() {
        return C_SansyoukngnumuKbn.class;
    }

    @Override
    protected C_SansyoukngnumuKbn valueOf(String pValue) {
        return C_SansyoukngnumuKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_SansyoukngnumuKbn pValue) {
        return pValue.getValue();
    }
}
