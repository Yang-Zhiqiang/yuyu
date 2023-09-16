package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_JgyssksyuukeiKbn;

/**
 * {@link C_JgyssksyuukeiKbn 事業成績表集計パターン区分} の Hibernate ユーザー定義型です。<br />
 * 事業成績表集計パターン区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_JgyssksyuukeiKbn extends AbstractUserType<C_JgyssksyuukeiKbn> {

    @Override
    protected Class<C_JgyssksyuukeiKbn> returnType() {
        return C_JgyssksyuukeiKbn.class;
    }

    @Override
    protected C_JgyssksyuukeiKbn valueOf(String pValue) {
        return C_JgyssksyuukeiKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_JgyssksyuukeiKbn pValue) {
        return pValue.getValue();
    }
}
