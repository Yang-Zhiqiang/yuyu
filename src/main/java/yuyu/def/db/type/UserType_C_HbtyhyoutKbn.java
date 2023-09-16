package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_HbtyhyoutKbn;

/**
 * {@link C_HbtyhyoutKbn 不備帳票出力区分} の Hibernate ユーザー定義型です。<br />
 * 不備帳票出力区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_HbtyhyoutKbn extends AbstractUserType<C_HbtyhyoutKbn> {

    @Override
    protected Class<C_HbtyhyoutKbn> returnType() {
        return C_HbtyhyoutKbn.class;
    }

    @Override
    protected C_HbtyhyoutKbn valueOf(String pValue) {
        return C_HbtyhyoutKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_HbtyhyoutKbn pValue) {
        return pValue.getValue();
    }
}
