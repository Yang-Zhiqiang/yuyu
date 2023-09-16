package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_WebmoskakjkKbn;

/**
 * {@link C_WebmoskakjkKbn Ｗｅｂ申込確認状況区分} の Hibernate ユーザー定義型です。<br />
 * Ｗｅｂ申込確認状況区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_WebmoskakjkKbn extends AbstractUserType<C_WebmoskakjkKbn> {

    @Override
    protected Class<C_WebmoskakjkKbn> returnType() {
        return C_WebmoskakjkKbn.class;
    }

    @Override
    protected C_WebmoskakjkKbn valueOf(String pValue) {
        return C_WebmoskakjkKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_WebmoskakjkKbn pValue) {
        return pValue.getValue();
    }
}
