package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_Nkshrjk;

/**
 * {@link C_Nkshrjk 年金支払状況} の Hibernate ユーザー定義型です。<br />
 * 年金支払状況 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_Nkshrjk extends AbstractUserType<C_Nkshrjk> {

    @Override
    protected Class<C_Nkshrjk> returnType() {
        return C_Nkshrjk.class;
    }

    @Override
    protected C_Nkshrjk valueOf(String pValue) {
        return C_Nkshrjk.valueOf(pValue);
    }

    @Override
    protected String toString(C_Nkshrjk pValue) {
        return pValue.getValue();
    }
}
