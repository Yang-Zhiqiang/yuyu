package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_SonotasyouhnKbn;

/**
 * {@link C_SonotasyouhnKbn その他商品区分} の Hibernate ユーザー定義型です。<br />
 * その他商品区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_SonotasyouhnKbn extends AbstractUserType<C_SonotasyouhnKbn> {

    @Override
    protected Class<C_SonotasyouhnKbn> returnType() {
        return C_SonotasyouhnKbn.class;
    }

    @Override
    protected C_SonotasyouhnKbn valueOf(String pValue) {
        return C_SonotasyouhnKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_SonotasyouhnKbn pValue) {
        return pValue.getValue();
    }
}
