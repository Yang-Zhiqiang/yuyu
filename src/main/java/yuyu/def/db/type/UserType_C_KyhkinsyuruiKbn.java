package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_KyhkinsyuruiKbn;

/**
 * {@link C_KyhkinsyuruiKbn 給付金種類区分} の Hibernate ユーザー定義型です。<br />
 * 給付金種類区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_KyhkinsyuruiKbn extends AbstractUserType<C_KyhkinsyuruiKbn> {

    @Override
    protected Class<C_KyhkinsyuruiKbn> returnType() {
        return C_KyhkinsyuruiKbn.class;
    }

    @Override
    protected C_KyhkinsyuruiKbn valueOf(String pValue) {
        return C_KyhkinsyuruiKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_KyhkinsyuruiKbn pValue) {
        return pValue.getValue();
    }
}
