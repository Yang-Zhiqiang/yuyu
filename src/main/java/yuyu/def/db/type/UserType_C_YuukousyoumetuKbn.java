package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_YuukousyoumetuKbn;

/**
 * {@link C_YuukousyoumetuKbn 有効消滅区分} の Hibernate ユーザー定義型です。<br />
 * 有効消滅区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_YuukousyoumetuKbn extends AbstractUserType<C_YuukousyoumetuKbn> {

    @Override
    protected Class<C_YuukousyoumetuKbn> returnType() {
        return C_YuukousyoumetuKbn.class;
    }

    @Override
    protected C_YuukousyoumetuKbn valueOf(String pValue) {
        return C_YuukousyoumetuKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_YuukousyoumetuKbn pValue) {
        return pValue.getValue();
    }
}
