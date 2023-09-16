package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_OutsumiKbn;

/**
 * {@link C_OutsumiKbn 出力済区分} の Hibernate ユーザー定義型です。<br />
 * 出力済区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_OutsumiKbn extends AbstractUserType<C_OutsumiKbn> {

    @Override
    protected Class<C_OutsumiKbn> returnType() {
        return C_OutsumiKbn.class;
    }

    @Override
    protected C_OutsumiKbn valueOf(String pValue) {
        return C_OutsumiKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_OutsumiKbn pValue) {
        return pValue.getValue();
    }
}
