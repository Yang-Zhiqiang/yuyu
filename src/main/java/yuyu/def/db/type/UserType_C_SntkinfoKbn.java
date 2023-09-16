package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_SntkinfoKbn;

/**
 * {@link C_SntkinfoKbn 選択情報区分} の Hibernate ユーザー定義型です。<br />
 * 選択情報区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_SntkinfoKbn extends AbstractUserType<C_SntkinfoKbn> {

    @Override
    protected Class<C_SntkinfoKbn> returnType() {
        return C_SntkinfoKbn.class;
    }

    @Override
    protected C_SntkinfoKbn valueOf(String pValue) {
        return C_SntkinfoKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_SntkinfoKbn pValue) {
        return pValue.getValue();
    }
}
