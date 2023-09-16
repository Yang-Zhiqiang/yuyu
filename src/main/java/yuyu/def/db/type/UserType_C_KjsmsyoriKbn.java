package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_KjsmsyoriKbn;

/**
 * {@link C_KjsmsyoriKbn 控除証明処理区分} の Hibernate ユーザー定義型です。<br />
 * 控除証明処理区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_KjsmsyoriKbn extends AbstractUserType<C_KjsmsyoriKbn> {

    @Override
    protected Class<C_KjsmsyoriKbn> returnType() {
        return C_KjsmsyoriKbn.class;
    }

    @Override
    protected C_KjsmsyoriKbn valueOf(String pValue) {
        return C_KjsmsyoriKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_KjsmsyoriKbn pValue) {
        return pValue.getValue();
    }
}
