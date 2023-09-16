package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_DsKanyuuKeiroKbn;

/**
 * {@link C_DsKanyuuKeiroKbn ＤＳ加入経路区分} の Hibernate ユーザー定義型です。<br />
 * ＤＳ加入経路区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_DsKanyuuKeiroKbn extends AbstractUserType<C_DsKanyuuKeiroKbn> {

    @Override
    protected Class<C_DsKanyuuKeiroKbn> returnType() {
        return C_DsKanyuuKeiroKbn.class;
    }

    @Override
    protected C_DsKanyuuKeiroKbn valueOf(String pValue) {
        return C_DsKanyuuKeiroKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_DsKanyuuKeiroKbn pValue) {
        return pValue.getValue();
    }
}
