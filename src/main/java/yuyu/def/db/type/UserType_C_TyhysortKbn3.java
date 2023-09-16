package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_TyhysortKbn3;

/**
 * {@link C_TyhysortKbn3 帳票ソート区分３} の Hibernate ユーザー定義型です。<br />
 * 帳票ソート区分３ 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_TyhysortKbn3 extends AbstractUserType<C_TyhysortKbn3> {

    @Override
    protected Class<C_TyhysortKbn3> returnType() {
        return C_TyhysortKbn3.class;
    }

    @Override
    protected C_TyhysortKbn3 valueOf(String pValue) {
        return C_TyhysortKbn3.valueOf(pValue);
    }

    @Override
    protected String toString(C_TyhysortKbn3 pValue) {
        return pValue.getValue();
    }
}
