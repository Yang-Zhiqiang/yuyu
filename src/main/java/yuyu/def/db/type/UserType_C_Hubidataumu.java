package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_Hubidataumu;

/**
 * {@link C_Hubidataumu 不備データ有無区分} の Hibernate ユーザー定義型です。<br />
 * 不備データ有無区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_Hubidataumu extends AbstractUserType<C_Hubidataumu> {

    @Override
    protected Class<C_Hubidataumu> returnType() {
        return C_Hubidataumu.class;
    }

    @Override
    protected C_Hubidataumu valueOf(String pValue) {
        return C_Hubidataumu.valueOf(pValue);
    }

    @Override
    protected String toString(C_Hubidataumu pValue) {
        return pValue.getValue();
    }
}
