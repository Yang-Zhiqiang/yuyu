package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_OyakodrtenKbn;

/**
 * {@link C_OyakodrtenKbn 親子代理店区分} の Hibernate ユーザー定義型です。<br />
 * 親子代理店区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_OyakodrtenKbn extends AbstractUserType<C_OyakodrtenKbn> {

    @Override
    protected Class<C_OyakodrtenKbn> returnType() {
        return C_OyakodrtenKbn.class;
    }

    @Override
    protected C_OyakodrtenKbn valueOf(String pValue) {
        return C_OyakodrtenKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_OyakodrtenKbn pValue) {
        return pValue.getValue();
    }
}
