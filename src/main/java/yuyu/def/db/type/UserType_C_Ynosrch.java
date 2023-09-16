package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_Ynosrch;

/**
 * {@link C_Ynosrch 郵便番号検索区分} の Hibernate ユーザー定義型です。<br />
 * 郵便番号検索区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_Ynosrch extends AbstractUserType<C_Ynosrch> {

    @Override
    protected Class<C_Ynosrch> returnType() {
        return C_Ynosrch.class;
    }

    @Override
    protected C_Ynosrch valueOf(String pValue) {
        return C_Ynosrch.valueOf(pValue);
    }

    @Override
    protected String toString(C_Ynosrch pValue) {
        return pValue.getValue();
    }
}
