package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_TuujyoukaniKbn;

/**
 * {@link C_TuujyoukaniKbn 通常簡易区分} の Hibernate ユーザー定義型です。<br />
 * 通常簡易区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_TuujyoukaniKbn extends AbstractUserType<C_TuujyoukaniKbn> {

    @Override
    protected Class<C_TuujyoukaniKbn> returnType() {
        return C_TuujyoukaniKbn.class;
    }

    @Override
    protected C_TuujyoukaniKbn valueOf(String pValue) {
        return C_TuujyoukaniKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_TuujyoukaniKbn pValue) {
        return pValue.getValue();
    }
}
