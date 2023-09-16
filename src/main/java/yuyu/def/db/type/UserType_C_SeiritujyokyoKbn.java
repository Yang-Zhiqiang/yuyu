package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_SeiritujyokyoKbn;

/**
 * {@link C_SeiritujyokyoKbn 成立状況区分} の Hibernate ユーザー定義型です。<br />
 * 成立状況区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_SeiritujyokyoKbn extends AbstractUserType<C_SeiritujyokyoKbn> {

    @Override
    protected Class<C_SeiritujyokyoKbn> returnType() {
        return C_SeiritujyokyoKbn.class;
    }

    @Override
    protected C_SeiritujyokyoKbn valueOf(String pValue) {
        return C_SeiritujyokyoKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_SeiritujyokyoKbn pValue) {
        return pValue.getValue();
    }
}
