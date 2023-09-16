package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_SinsakuseiKbn;

/**
 * {@link C_SinsakuseiKbn 新規作成区分} の Hibernate ユーザー定義型です。<br />
 * 新規作成区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_SinsakuseiKbn extends AbstractUserType<C_SinsakuseiKbn> {

    @Override
    protected Class<C_SinsakuseiKbn> returnType() {
        return C_SinsakuseiKbn.class;
    }

    @Override
    protected C_SinsakuseiKbn valueOf(String pValue) {
        return C_SinsakuseiKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_SinsakuseiKbn pValue) {
        return pValue.getValue();
    }
}
