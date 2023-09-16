package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_KjbncategoryKbn;

/**
 * {@link C_KjbncategoryKbn 掲示板カテゴリ区分} の Hibernate ユーザー定義型です。<br />
 * 掲示板カテゴリ区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_KjbncategoryKbn extends AbstractUserType<C_KjbncategoryKbn> {

    @Override
    protected Class<C_KjbncategoryKbn> returnType() {
        return C_KjbncategoryKbn.class;
    }

    @Override
    protected C_KjbncategoryKbn valueOf(String pValue) {
        return C_KjbncategoryKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_KjbncategoryKbn pValue) {
        return pValue.getValue();
    }
}
