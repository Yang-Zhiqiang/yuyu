package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_HbksshorijtKbn;

/**
 * {@link C_HbksshorijtKbn 不備解消処理状態区分} の Hibernate ユーザー定義型です。<br />
 * 不備解消処理状態区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_HbksshorijtKbn extends AbstractUserType<C_HbksshorijtKbn> {

    @Override
    protected Class<C_HbksshorijtKbn> returnType() {
        return C_HbksshorijtKbn.class;
    }

    @Override
    protected C_HbksshorijtKbn valueOf(String pValue) {
        return C_HbksshorijtKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_HbksshorijtKbn pValue) {
        return pValue.getValue();
    }
}
