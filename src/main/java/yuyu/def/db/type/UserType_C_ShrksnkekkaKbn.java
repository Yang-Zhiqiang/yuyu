package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_ShrksnkekkaKbn;

/**
 * {@link C_ShrksnkekkaKbn 支払計算結果区分} の Hibernate ユーザー定義型です。<br />
 * 支払計算結果区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_ShrksnkekkaKbn extends AbstractUserType<C_ShrksnkekkaKbn> {

    @Override
    protected Class<C_ShrksnkekkaKbn> returnType() {
        return C_ShrksnkekkaKbn.class;
    }

    @Override
    protected C_ShrksnkekkaKbn valueOf(String pValue) {
        return C_ShrksnkekkaKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_ShrksnkekkaKbn pValue) {
        return pValue.getValue();
    }
}
