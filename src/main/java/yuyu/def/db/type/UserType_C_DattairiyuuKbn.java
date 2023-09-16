package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_DattairiyuuKbn;

/**
 * {@link C_DattairiyuuKbn 脱退理由区分} の Hibernate ユーザー定義型です。<br />
 * 脱退理由区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_DattairiyuuKbn extends AbstractUserType<C_DattairiyuuKbn> {

    @Override
    protected Class<C_DattairiyuuKbn> returnType() {
        return C_DattairiyuuKbn.class;
    }

    @Override
    protected C_DattairiyuuKbn valueOf(String pValue) {
        return C_DattairiyuuKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_DattairiyuuKbn pValue) {
        return pValue.getValue();
    }
}
