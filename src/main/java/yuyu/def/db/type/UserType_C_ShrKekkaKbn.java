package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_ShrKekkaKbn;

/**
 * {@link C_ShrKekkaKbn 支払結果区分} の Hibernate ユーザー定義型です。<br />
 * 支払結果区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_ShrKekkaKbn extends AbstractUserType<C_ShrKekkaKbn> {

    @Override
    protected Class<C_ShrKekkaKbn> returnType() {
        return C_ShrKekkaKbn.class;
    }

    @Override
    protected C_ShrKekkaKbn valueOf(String pValue) {
        return C_ShrKekkaKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_ShrKekkaKbn pValue) {
        return pValue.getValue();
    }
}
