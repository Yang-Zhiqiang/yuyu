package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_TyhysortKbn1;

/**
 * {@link C_TyhysortKbn1 帳票ソート区分１} の Hibernate ユーザー定義型です。<br />
 * 帳票ソート区分１ 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_TyhysortKbn1 extends AbstractUserType<C_TyhysortKbn1> {

    @Override
    protected Class<C_TyhysortKbn1> returnType() {
        return C_TyhysortKbn1.class;
    }

    @Override
    protected C_TyhysortKbn1 valueOf(String pValue) {
        return C_TyhysortKbn1.valueOf(pValue);
    }

    @Override
    protected String toString(C_TyhysortKbn1 pValue) {
        return pValue.getValue();
    }
}
