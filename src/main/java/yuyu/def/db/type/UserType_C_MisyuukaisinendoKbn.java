package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_MisyuukaisinendoKbn;

/**
 * {@link C_MisyuukaisinendoKbn 未収開始年度区分} の Hibernate ユーザー定義型です。<br />
 * 未収開始年度区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_MisyuukaisinendoKbn extends AbstractUserType<C_MisyuukaisinendoKbn> {

    @Override
    protected Class<C_MisyuukaisinendoKbn> returnType() {
        return C_MisyuukaisinendoKbn.class;
    }

    @Override
    protected C_MisyuukaisinendoKbn valueOf(String pValue) {
        return C_MisyuukaisinendoKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_MisyuukaisinendoKbn pValue) {
        return pValue.getValue();
    }
}
