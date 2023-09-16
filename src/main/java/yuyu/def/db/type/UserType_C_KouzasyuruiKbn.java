package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_KouzasyuruiKbn;

/**
 * {@link C_KouzasyuruiKbn 口座種類区分} の Hibernate ユーザー定義型です。<br />
 * 口座種類区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_KouzasyuruiKbn extends AbstractUserType<C_KouzasyuruiKbn> {

    @Override
    protected Class<C_KouzasyuruiKbn> returnType() {
        return C_KouzasyuruiKbn.class;
    }

    @Override
    protected C_KouzasyuruiKbn valueOf(String pValue) {
        return C_KouzasyuruiKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_KouzasyuruiKbn pValue) {
        return pValue.getValue();
    }
}
