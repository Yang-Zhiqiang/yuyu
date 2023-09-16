package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_NaiteiKakuteiKbn;

/**
 * {@link C_NaiteiKakuteiKbn 内定確定区分} の Hibernate ユーザー定義型です。<br />
 * 内定確定区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_NaiteiKakuteiKbn extends AbstractUserType<C_NaiteiKakuteiKbn> {

    @Override
    protected Class<C_NaiteiKakuteiKbn> returnType() {
        return C_NaiteiKakuteiKbn.class;
    }

    @Override
    protected C_NaiteiKakuteiKbn valueOf(String pValue) {
        return C_NaiteiKakuteiKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_NaiteiKakuteiKbn pValue) {
        return pValue.getValue();
    }
}
