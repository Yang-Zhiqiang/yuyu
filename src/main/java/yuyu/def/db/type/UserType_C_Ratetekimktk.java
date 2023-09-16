package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_Ratetekimktk;

/**
 * {@link C_Ratetekimktk レート適用目的} の Hibernate ユーザー定義型です。<br />
 * レート適用目的 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_Ratetekimktk extends AbstractUserType<C_Ratetekimktk> {

    @Override
    protected Class<C_Ratetekimktk> returnType() {
        return C_Ratetekimktk.class;
    }

    @Override
    protected C_Ratetekimktk valueOf(String pValue) {
        return C_Ratetekimktk.valueOf(pValue);
    }

    @Override
    protected String toString(C_Ratetekimktk pValue) {
        return pValue.getValue();
    }
}
