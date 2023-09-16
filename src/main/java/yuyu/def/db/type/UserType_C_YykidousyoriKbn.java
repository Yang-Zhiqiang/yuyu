package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_YykidousyoriKbn;

/**
 * {@link C_YykidousyoriKbn 予約異動処理区分} の Hibernate ユーザー定義型です。<br />
 * 予約異動処理区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_YykidousyoriKbn extends AbstractUserType<C_YykidousyoriKbn> {

    @Override
    protected Class<C_YykidousyoriKbn> returnType() {
        return C_YykidousyoriKbn.class;
    }

    @Override
    protected C_YykidousyoriKbn valueOf(String pValue) {
        return C_YykidousyoriKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_YykidousyoriKbn pValue) {
        return pValue.getValue();
    }
}
