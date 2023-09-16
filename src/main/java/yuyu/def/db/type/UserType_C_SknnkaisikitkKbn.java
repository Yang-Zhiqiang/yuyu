package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_SknnkaisikitkKbn;

/**
 * {@link C_SknnkaisikitkKbn 責任開始期特約区分} の Hibernate ユーザー定義型です。<br />
 * 責任開始期特約区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_SknnkaisikitkKbn extends AbstractUserType<C_SknnkaisikitkKbn> {

    @Override
    protected Class<C_SknnkaisikitkKbn> returnType() {
        return C_SknnkaisikitkKbn.class;
    }

    @Override
    protected C_SknnkaisikitkKbn valueOf(String pValue) {
        return C_SknnkaisikitkKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_SknnkaisikitkKbn pValue) {
        return pValue.getValue();
    }
}
