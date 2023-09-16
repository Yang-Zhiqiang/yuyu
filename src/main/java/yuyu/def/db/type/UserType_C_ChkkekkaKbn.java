package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_ChkkekkaKbn;

/**
 * {@link C_ChkkekkaKbn チェック結果区分} の Hibernate ユーザー定義型です。<br />
 * チェック結果区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_ChkkekkaKbn extends AbstractUserType<C_ChkkekkaKbn> {

    @Override
    protected Class<C_ChkkekkaKbn> returnType() {
        return C_ChkkekkaKbn.class;
    }

    @Override
    protected C_ChkkekkaKbn valueOf(String pValue) {
        return C_ChkkekkaKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_ChkkekkaKbn pValue) {
        return pValue.getValue();
    }
}
