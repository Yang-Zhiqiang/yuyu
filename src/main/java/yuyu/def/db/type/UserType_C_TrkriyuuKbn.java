package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_TrkriyuuKbn;

/**
 * {@link C_TrkriyuuKbn 登録理由区分} の Hibernate ユーザー定義型です。<br />
 * 登録理由区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_TrkriyuuKbn extends AbstractUserType<C_TrkriyuuKbn> {

    @Override
    protected Class<C_TrkriyuuKbn> returnType() {
        return C_TrkriyuuKbn.class;
    }

    @Override
    protected C_TrkriyuuKbn valueOf(String pValue) {
        return C_TrkriyuuKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_TrkriyuuKbn pValue) {
        return pValue.getValue();
    }
}
