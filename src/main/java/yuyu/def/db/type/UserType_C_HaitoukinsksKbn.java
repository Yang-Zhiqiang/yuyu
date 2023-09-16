package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_HaitoukinsksKbn;

/**
 * {@link C_HaitoukinsksKbn 配当金作成区分} の Hibernate ユーザー定義型です。<br />
 * 配当金作成区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_HaitoukinsksKbn extends AbstractUserType<C_HaitoukinsksKbn> {

    @Override
    protected Class<C_HaitoukinsksKbn> returnType() {
        return C_HaitoukinsksKbn.class;
    }

    @Override
    protected C_HaitoukinsksKbn valueOf(String pValue) {
        return C_HaitoukinsksKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_HaitoukinsksKbn pValue) {
        return pValue.getValue();
    }
}
