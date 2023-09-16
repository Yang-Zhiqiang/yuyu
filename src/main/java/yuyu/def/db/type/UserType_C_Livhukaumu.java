package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_Livhukaumu;

/**
 * {@link C_Livhukaumu リビングニーズ付加有無} の Hibernate ユーザー定義型です。<br />
 * リビングニーズ付加有無 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_Livhukaumu extends AbstractUserType<C_Livhukaumu> {

    @Override
    protected Class<C_Livhukaumu> returnType() {
        return C_Livhukaumu.class;
    }

    @Override
    protected C_Livhukaumu valueOf(String pValue) {
        return C_Livhukaumu.valueOf(pValue);
    }

    @Override
    protected String toString(C_Livhukaumu pValue) {
        return pValue.getValue();
    }
}
