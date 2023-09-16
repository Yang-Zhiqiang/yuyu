package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_SaisateiKbn;

/**
 * {@link C_SaisateiKbn 再査定区分} の Hibernate ユーザー定義型です。<br />
 * 再査定区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_SaisateiKbn extends AbstractUserType<C_SaisateiKbn> {

    @Override
    protected Class<C_SaisateiKbn> returnType() {
        return C_SaisateiKbn.class;
    }

    @Override
    protected C_SaisateiKbn valueOf(String pValue) {
        return C_SaisateiKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_SaisateiKbn pValue) {
        return pValue.getValue();
    }
}
