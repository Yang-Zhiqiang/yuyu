package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_AeoiKekkaKbn;

/**
 * {@link C_AeoiKekkaKbn ＡＥＯＩ結果区分} の Hibernate ユーザー定義型です。<br />
 * ＡＥＯＩ結果区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_AeoiKekkaKbn extends AbstractUserType<C_AeoiKekkaKbn> {

    @Override
    protected Class<C_AeoiKekkaKbn> returnType() {
        return C_AeoiKekkaKbn.class;
    }

    @Override
    protected C_AeoiKekkaKbn valueOf(String pValue) {
        return C_AeoiKekkaKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_AeoiKekkaKbn pValue) {
        return pValue.getValue();
    }
}
