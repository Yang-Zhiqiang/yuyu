package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_Kzdou;

/**
 * {@link C_Kzdou 口座名義人同一区分} の Hibernate ユーザー定義型です。<br />
 * 口座名義人同一区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_Kzdou extends AbstractUserType<C_Kzdou> {

    @Override
    protected Class<C_Kzdou> returnType() {
        return C_Kzdou.class;
    }

    @Override
    protected C_Kzdou valueOf(String pValue) {
        return C_Kzdou.valueOf(pValue);
    }

    @Override
    protected String toString(C_Kzdou pValue) {
        return pValue.getValue();
    }
}
