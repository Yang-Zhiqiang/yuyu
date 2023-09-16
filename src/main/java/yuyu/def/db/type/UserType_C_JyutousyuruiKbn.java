package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_JyutousyuruiKbn;

/**
 * {@link C_JyutousyuruiKbn 充当種類区分} の Hibernate ユーザー定義型です。<br />
 * 充当種類区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_JyutousyuruiKbn extends AbstractUserType<C_JyutousyuruiKbn> {

    @Override
    protected Class<C_JyutousyuruiKbn> returnType() {
        return C_JyutousyuruiKbn.class;
    }

    @Override
    protected C_JyutousyuruiKbn valueOf(String pValue) {
        return C_JyutousyuruiKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_JyutousyuruiKbn pValue) {
        return pValue.getValue();
    }
}
