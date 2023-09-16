package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_Tkhukaumu;

/**
 * {@link C_Tkhukaumu 特約付加有無} の Hibernate ユーザー定義型です。<br />
 * 特約付加有無 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_Tkhukaumu extends AbstractUserType<C_Tkhukaumu> {

    @Override
    protected Class<C_Tkhukaumu> returnType() {
        return C_Tkhukaumu.class;
    }

    @Override
    protected C_Tkhukaumu valueOf(String pValue) {
        return C_Tkhukaumu.valueOf(pValue);
    }

    @Override
    protected String toString(C_Tkhukaumu pValue) {
        return pValue.getValue();
    }
}
