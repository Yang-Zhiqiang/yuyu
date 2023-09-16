package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_SntkinfosakuseiyhKbn;

/**
 * {@link C_SntkinfosakuseiyhKbn 選択情報作成要否区分} の Hibernate ユーザー定義型です。<br />
 * 選択情報作成要否区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_SntkinfosakuseiyhKbn extends AbstractUserType<C_SntkinfosakuseiyhKbn> {

    @Override
    protected Class<C_SntkinfosakuseiyhKbn> returnType() {
        return C_SntkinfosakuseiyhKbn.class;
    }

    @Override
    protected C_SntkinfosakuseiyhKbn valueOf(String pValue) {
        return C_SntkinfosakuseiyhKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_SntkinfosakuseiyhKbn pValue) {
        return pValue.getValue();
    }
}
