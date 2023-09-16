package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_DsKokyakuJtKbn;

/**
 * {@link C_DsKokyakuJtKbn ＤＳ顧客状態区分} の Hibernate ユーザー定義型です。<br />
 * ＤＳ顧客状態区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_DsKokyakuJtKbn extends AbstractUserType<C_DsKokyakuJtKbn> {

    @Override
    protected Class<C_DsKokyakuJtKbn> returnType() {
        return C_DsKokyakuJtKbn.class;
    }

    @Override
    protected C_DsKokyakuJtKbn valueOf(String pValue) {
        return C_DsKokyakuJtKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_DsKokyakuJtKbn pValue) {
        return pValue.getValue();
    }
}
