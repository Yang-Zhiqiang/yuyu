package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_WebmosjtKbn;

/**
 * {@link C_WebmosjtKbn Ｗｅｂ申込状態区分} の Hibernate ユーザー定義型です。<br />
 * Ｗｅｂ申込状態区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_WebmosjtKbn extends AbstractUserType<C_WebmosjtKbn> {

    @Override
    protected Class<C_WebmosjtKbn> returnType() {
        return C_WebmosjtKbn.class;
    }

    @Override
    protected C_WebmosjtKbn valueOf(String pValue) {
        return C_WebmosjtKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_WebmosjtKbn pValue) {
        return pValue.getValue();
    }
}
