package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_KhDengkSyuruiKbn;

/**
 * {@link C_KhDengkSyuruiKbn 契約保全伝票金額種類区分} の Hibernate ユーザー定義型です。<br />
 * 契約保全伝票金額種類区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_KhDengkSyuruiKbn extends AbstractUserType<C_KhDengkSyuruiKbn> {

    @Override
    protected Class<C_KhDengkSyuruiKbn> returnType() {
        return C_KhDengkSyuruiKbn.class;
    }

    @Override
    protected C_KhDengkSyuruiKbn valueOf(String pValue) {
        return C_KhDengkSyuruiKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_KhDengkSyuruiKbn pValue) {
        return pValue.getValue();
    }
}
