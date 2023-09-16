package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_RirekiSyuruiKbn;

/**
 * {@link C_RirekiSyuruiKbn 履歴種類区分} の Hibernate ユーザー定義型です。<br />
 * 履歴種類区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_RirekiSyuruiKbn extends AbstractUserType<C_RirekiSyuruiKbn> {

    @Override
    protected Class<C_RirekiSyuruiKbn> returnType() {
        return C_RirekiSyuruiKbn.class;
    }

    @Override
    protected C_RirekiSyuruiKbn valueOf(String pValue) {
        return C_RirekiSyuruiKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_RirekiSyuruiKbn pValue) {
        return pValue.getValue();
    }
}
