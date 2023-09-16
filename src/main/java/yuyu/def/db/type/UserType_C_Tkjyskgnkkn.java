package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_Tkjyskgnkkn;

/**
 * {@link C_Tkjyskgnkkn 特条削減期間} の Hibernate ユーザー定義型です。<br />
 * 特条削減期間 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_Tkjyskgnkkn extends AbstractUserType<C_Tkjyskgnkkn> {

    @Override
    protected Class<C_Tkjyskgnkkn> returnType() {
        return C_Tkjyskgnkkn.class;
    }

    @Override
    protected C_Tkjyskgnkkn valueOf(String pValue) {
        return C_Tkjyskgnkkn.valueOf(pValue);
    }

    @Override
    protected String toString(C_Tkjyskgnkkn pValue) {
        return pValue.getValue();
    }
}
