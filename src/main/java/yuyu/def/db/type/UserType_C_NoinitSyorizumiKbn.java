package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_NoinitSyorizumiKbn;

/**
 * {@link C_NoinitSyorizumiKbn 初期値無し処理済区分} の Hibernate ユーザー定義型です。<br />
 * 初期値無し処理済区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_NoinitSyorizumiKbn extends AbstractUserType<C_NoinitSyorizumiKbn> {

    @Override
    protected Class<C_NoinitSyorizumiKbn> returnType() {
        return C_NoinitSyorizumiKbn.class;
    }

    @Override
    protected C_NoinitSyorizumiKbn valueOf(String pValue) {
        return C_NoinitSyorizumiKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_NoinitSyorizumiKbn pValue) {
        return pValue.getValue();
    }
}
