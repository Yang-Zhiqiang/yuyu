package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_IdousyoriKbn;

/**
 * {@link C_IdousyoriKbn 異動処理区分} の Hibernate ユーザー定義型です。<br />
 * 異動処理区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_IdousyoriKbn extends AbstractUserType<C_IdousyoriKbn> {

    @Override
    protected Class<C_IdousyoriKbn> returnType() {
        return C_IdousyoriKbn.class;
    }

    @Override
    protected C_IdousyoriKbn valueOf(String pValue) {
        return C_IdousyoriKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_IdousyoriKbn pValue) {
        return pValue.getValue();
    }
}
