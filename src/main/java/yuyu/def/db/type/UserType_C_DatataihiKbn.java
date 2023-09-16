package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_DatataihiKbn;

/**
 * {@link C_DatataihiKbn データ退避区分} の Hibernate ユーザー定義型です。<br />
 * データ退避区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_DatataihiKbn extends AbstractUserType<C_DatataihiKbn> {

    @Override
    protected Class<C_DatataihiKbn> returnType() {
        return C_DatataihiKbn.class;
    }

    @Override
    protected C_DatataihiKbn valueOf(String pValue) {
        return C_DatataihiKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_DatataihiKbn pValue) {
        return pValue.getValue();
    }
}
