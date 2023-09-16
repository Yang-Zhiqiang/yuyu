package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_HokenSyuruiKigouSedaiKbn;

/**
 * {@link C_HokenSyuruiKigouSedaiKbn 保険種類記号世代区分} の Hibernate ユーザー定義型です。<br />
 * 保険種類記号世代区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_HokenSyuruiKigouSedaiKbn extends AbstractUserType<C_HokenSyuruiKigouSedaiKbn> {

    @Override
    protected Class<C_HokenSyuruiKigouSedaiKbn> returnType() {
        return C_HokenSyuruiKigouSedaiKbn.class;
    }

    @Override
    protected C_HokenSyuruiKigouSedaiKbn valueOf(String pValue) {
        return C_HokenSyuruiKigouSedaiKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_HokenSyuruiKigouSedaiKbn pValue) {
        return pValue.getValue();
    }
}
