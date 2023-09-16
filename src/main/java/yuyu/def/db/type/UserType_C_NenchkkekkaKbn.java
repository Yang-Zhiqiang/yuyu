package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_NenchkkekkaKbn;

/**
 * {@link C_NenchkkekkaKbn 年齢チェック結果区分} の Hibernate ユーザー定義型です。<br />
 * 年齢チェック結果区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_NenchkkekkaKbn extends AbstractUserType<C_NenchkkekkaKbn> {

    @Override
    protected Class<C_NenchkkekkaKbn> returnType() {
        return C_NenchkkekkaKbn.class;
    }

    @Override
    protected C_NenchkkekkaKbn valueOf(String pValue) {
        return C_NenchkkekkaKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_NenchkkekkaKbn pValue) {
        return pValue.getValue();
    }
}
