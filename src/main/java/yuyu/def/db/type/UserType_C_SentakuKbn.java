package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_SentakuKbn;

/**
 * {@link C_SentakuKbn 選択区分} の Hibernate ユーザー定義型です。<br />
 * 選択区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_SentakuKbn extends AbstractUserType<C_SentakuKbn> {

    @Override
    protected Class<C_SentakuKbn> returnType() {
        return C_SentakuKbn.class;
    }

    @Override
    protected C_SentakuKbn valueOf(String pValue) {
        return C_SentakuKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_SentakuKbn pValue) {
        return pValue.getValue();
    }
}
