package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_HugouKbn;

/**
 * {@link C_HugouKbn 負号区分} の Hibernate ユーザー定義型です。<br />
 * 負号区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_HugouKbn extends AbstractUserType<C_HugouKbn> {

    @Override
    protected Class<C_HugouKbn> returnType() {
        return C_HugouKbn.class;
    }

    @Override
    protected C_HugouKbn valueOf(String pValue) {
        return C_HugouKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_HugouKbn pValue) {
        return pValue.getValue();
    }
}
