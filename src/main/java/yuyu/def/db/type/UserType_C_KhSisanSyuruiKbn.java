package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_KhSisanSyuruiKbn;

/**
 * {@link C_KhSisanSyuruiKbn 契約保全試算種類区分} の Hibernate ユーザー定義型です。<br />
 * 契約保全試算種類区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_KhSisanSyuruiKbn extends AbstractUserType<C_KhSisanSyuruiKbn> {

    @Override
    protected Class<C_KhSisanSyuruiKbn> returnType() {
        return C_KhSisanSyuruiKbn.class;
    }

    @Override
    protected C_KhSisanSyuruiKbn valueOf(String pValue) {
        return C_KhSisanSyuruiKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_KhSisanSyuruiKbn pValue) {
        return pValue.getValue();
    }
}
