package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_KktatkichkkekkaKbn;

/**
 * {@link C_KktatkichkkekkaKbn 告知扱チェック結果区分} の Hibernate ユーザー定義型です。<br />
 * 告知扱チェック結果区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_KktatkichkkekkaKbn extends AbstractUserType<C_KktatkichkkekkaKbn> {

    @Override
    protected Class<C_KktatkichkkekkaKbn> returnType() {
        return C_KktatkichkkekkaKbn.class;
    }

    @Override
    protected C_KktatkichkkekkaKbn valueOf(String pValue) {
        return C_KktatkichkkekkaKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_KktatkichkkekkaKbn pValue) {
        return pValue.getValue();
    }
}
