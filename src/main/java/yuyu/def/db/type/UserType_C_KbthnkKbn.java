package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_KbthnkKbn;

/**
 * {@link C_KbthnkKbn 個別変更区分} の Hibernate ユーザー定義型です。<br />
 * 個別変更区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_KbthnkKbn extends AbstractUserType<C_KbthnkKbn> {

    @Override
    protected Class<C_KbthnkKbn> returnType() {
        return C_KbthnkKbn.class;
    }

    @Override
    protected C_KbthnkKbn valueOf(String pValue) {
        return C_KbthnkKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_KbthnkKbn pValue) {
        return pValue.getValue();
    }
}
