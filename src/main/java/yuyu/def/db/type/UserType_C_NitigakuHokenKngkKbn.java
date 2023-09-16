package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_NitigakuHokenKngkKbn;

/**
 * {@link C_NitigakuHokenKngkKbn 日額・保険金額区分} の Hibernate ユーザー定義型です。<br />
 * 日額・保険金額区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_NitigakuHokenKngkKbn extends AbstractUserType<C_NitigakuHokenKngkKbn> {

    @Override
    protected Class<C_NitigakuHokenKngkKbn> returnType() {
        return C_NitigakuHokenKngkKbn.class;
    }

    @Override
    protected C_NitigakuHokenKngkKbn valueOf(String pValue) {
        return C_NitigakuHokenKngkKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_NitigakuHokenKngkKbn pValue) {
        return pValue.getValue();
    }
}
