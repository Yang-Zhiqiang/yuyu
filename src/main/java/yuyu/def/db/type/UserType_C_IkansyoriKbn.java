package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_IkansyoriKbn;

/**
 * {@link C_IkansyoriKbn 移管処理区分} の Hibernate ユーザー定義型です。<br />
 * 移管処理区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_IkansyoriKbn extends AbstractUserType<C_IkansyoriKbn> {

    @Override
    protected Class<C_IkansyoriKbn> returnType() {
        return C_IkansyoriKbn.class;
    }

    @Override
    protected C_IkansyoriKbn valueOf(String pValue) {
        return C_IkansyoriKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_IkansyoriKbn pValue) {
        return pValue.getValue();
    }
}
