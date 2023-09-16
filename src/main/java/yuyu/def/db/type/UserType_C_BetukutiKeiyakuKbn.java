package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_BetukutiKeiyakuKbn;

/**
 * {@link C_BetukutiKeiyakuKbn 別口契約区分} の Hibernate ユーザー定義型です。<br />
 * 別口契約区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_BetukutiKeiyakuKbn extends AbstractUserType<C_BetukutiKeiyakuKbn> {

    @Override
    protected Class<C_BetukutiKeiyakuKbn> returnType() {
        return C_BetukutiKeiyakuKbn.class;
    }

    @Override
    protected C_BetukutiKeiyakuKbn valueOf(String pValue) {
        return C_BetukutiKeiyakuKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_BetukutiKeiyakuKbn pValue) {
        return pValue.getValue();
    }
}
