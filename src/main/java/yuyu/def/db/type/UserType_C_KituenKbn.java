package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_KituenKbn;

/**
 * {@link C_KituenKbn 喫煙区分} の Hibernate ユーザー定義型です。<br />
 * 喫煙区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_KituenKbn extends AbstractUserType<C_KituenKbn> {

    @Override
    protected Class<C_KituenKbn> returnType() {
        return C_KituenKbn.class;
    }

    @Override
    protected C_KituenKbn valueOf(String pValue) {
        return C_KituenKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_KituenKbn pValue) {
        return pValue.getValue();
    }
}
