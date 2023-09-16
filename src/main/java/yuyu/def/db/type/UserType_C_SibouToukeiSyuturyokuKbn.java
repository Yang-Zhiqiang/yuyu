package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_SibouToukeiSyuturyokuKbn;

/**
 * {@link C_SibouToukeiSyuturyokuKbn 死亡率統計出力レコード区分} の Hibernate ユーザー定義型です。<br />
 * 死亡率統計出力レコード区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_SibouToukeiSyuturyokuKbn extends AbstractUserType<C_SibouToukeiSyuturyokuKbn> {

    @Override
    protected Class<C_SibouToukeiSyuturyokuKbn> returnType() {
        return C_SibouToukeiSyuturyokuKbn.class;
    }

    @Override
    protected C_SibouToukeiSyuturyokuKbn valueOf(String pValue) {
        return C_SibouToukeiSyuturyokuKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_SibouToukeiSyuturyokuKbn pValue) {
        return pValue.getValue();
    }
}
