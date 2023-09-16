package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_TsryshrkigenKbn;

/**
 * {@link C_TsryshrkigenKbn 手数料支払期限区分} の Hibernate ユーザー定義型です。<br />
 * 手数料支払期限区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_TsryshrkigenKbn extends AbstractUserType<C_TsryshrkigenKbn> {

    @Override
    protected Class<C_TsryshrkigenKbn> returnType() {
        return C_TsryshrkigenKbn.class;
    }

    @Override
    protected C_TsryshrkigenKbn valueOf(String pValue) {
        return C_TsryshrkigenKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_TsryshrkigenKbn pValue) {
        return pValue.getValue();
    }
}
