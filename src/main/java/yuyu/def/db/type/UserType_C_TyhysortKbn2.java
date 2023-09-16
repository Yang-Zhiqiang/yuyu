package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_TyhysortKbn2;

/**
 * {@link C_TyhysortKbn2 帳票ソート区分２} の Hibernate ユーザー定義型です。<br />
 * 帳票ソート区分２ 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_TyhysortKbn2 extends AbstractUserType<C_TyhysortKbn2> {

    @Override
    protected Class<C_TyhysortKbn2> returnType() {
        return C_TyhysortKbn2.class;
    }

    @Override
    protected C_TyhysortKbn2 valueOf(String pValue) {
        return C_TyhysortKbn2.valueOf(pValue);
    }

    @Override
    protected String toString(C_TyhysortKbn2 pValue) {
        return pValue.getValue();
    }
}
