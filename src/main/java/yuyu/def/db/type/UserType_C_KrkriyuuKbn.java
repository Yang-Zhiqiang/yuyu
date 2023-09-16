package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_KrkriyuuKbn;

/**
 * {@link C_KrkriyuuKbn 仮受理由区分} の Hibernate ユーザー定義型です。<br />
 * 仮受理由区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_KrkriyuuKbn extends AbstractUserType<C_KrkriyuuKbn> {

    @Override
    protected Class<C_KrkriyuuKbn> returnType() {
        return C_KrkriyuuKbn.class;
    }

    @Override
    protected C_KrkriyuuKbn valueOf(String pValue) {
        return C_KrkriyuuKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_KrkriyuuKbn pValue) {
        return pValue.getValue();
    }
}
