package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_TjtyouseiKbn;

/**
 * {@link C_TjtyouseiKbn 通常調整区分} の Hibernate ユーザー定義型です。<br />
 * 通常調整区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_TjtyouseiKbn extends AbstractUserType<C_TjtyouseiKbn> {

    @Override
    protected Class<C_TjtyouseiKbn> returnType() {
        return C_TjtyouseiKbn.class;
    }

    @Override
    protected C_TjtyouseiKbn valueOf(String pValue) {
        return C_TjtyouseiKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_TjtyouseiKbn pValue) {
        return pValue.getValue();
    }
}
