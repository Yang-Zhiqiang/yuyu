package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_SknnkaisikitkhukaKbn;

/**
 * {@link C_SknnkaisikitkhukaKbn 責任開始期特約付加区分} の Hibernate ユーザー定義型です。<br />
 * 責任開始期特約付加区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_SknnkaisikitkhukaKbn extends AbstractUserType<C_SknnkaisikitkhukaKbn> {

    @Override
    protected Class<C_SknnkaisikitkhukaKbn> returnType() {
        return C_SknnkaisikitkhukaKbn.class;
    }

    @Override
    protected C_SknnkaisikitkhukaKbn valueOf(String pValue) {
        return C_SknnkaisikitkhukaKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_SknnkaisikitkhukaKbn pValue) {
        return pValue.getValue();
    }
}
