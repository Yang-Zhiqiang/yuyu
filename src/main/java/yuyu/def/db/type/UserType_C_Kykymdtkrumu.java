package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_Kykymdtkrumu;

/**
 * {@link C_Kykymdtkrumu 契約日特例有無} の Hibernate ユーザー定義型です。<br />
 * 契約日特例有無 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_Kykymdtkrumu extends AbstractUserType<C_Kykymdtkrumu> {

    @Override
    protected Class<C_Kykymdtkrumu> returnType() {
        return C_Kykymdtkrumu.class;
    }

    @Override
    protected C_Kykymdtkrumu valueOf(String pValue) {
        return C_Kykymdtkrumu.valueOf(pValue);
    }

    @Override
    protected String toString(C_Kykymdtkrumu pValue) {
        return pValue.getValue();
    }
}
