package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_Tkkinyukkntkrumu;

/**
 * {@link C_Tkkinyukkntkrumu 地域金融機関特例有無} の Hibernate ユーザー定義型です。<br />
 * 地域金融機関特例有無 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_Tkkinyukkntkrumu extends AbstractUserType<C_Tkkinyukkntkrumu> {

    @Override
    protected Class<C_Tkkinyukkntkrumu> returnType() {
        return C_Tkkinyukkntkrumu.class;
    }

    @Override
    protected C_Tkkinyukkntkrumu valueOf(String pValue) {
        return C_Tkkinyukkntkrumu.valueOf(pValue);
    }

    @Override
    protected String toString(C_Tkkinyukkntkrumu pValue) {
        return pValue.getValue();
    }
}
