package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_JyutounendoKbn;

/**
 * {@link C_JyutounendoKbn 充当年度区分} の Hibernate ユーザー定義型です。<br />
 * 充当年度区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_JyutounendoKbn extends AbstractUserType<C_JyutounendoKbn> {

    @Override
    protected Class<C_JyutounendoKbn> returnType() {
        return C_JyutounendoKbn.class;
    }

    @Override
    protected C_JyutounendoKbn valueOf(String pValue) {
        return C_JyutounendoKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_JyutounendoKbn pValue) {
        return pValue.getValue();
    }
}
