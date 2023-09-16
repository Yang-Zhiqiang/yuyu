package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_SyorictrlKbn;

/**
 * {@link C_SyorictrlKbn 処理制御区分} の Hibernate ユーザー定義型です。<br />
 * 処理制御区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_SyorictrlKbn extends AbstractUserType<C_SyorictrlKbn> {

    @Override
    protected Class<C_SyorictrlKbn> returnType() {
        return C_SyorictrlKbn.class;
    }

    @Override
    protected C_SyorictrlKbn valueOf(String pValue) {
        return C_SyorictrlKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_SyorictrlKbn pValue) {
        return pValue.getValue();
    }
}
