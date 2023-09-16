package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_TrkjiyuuKbn;

/**
 * {@link C_TrkjiyuuKbn 登録事由区分} の Hibernate ユーザー定義型です。<br />
 * 登録事由区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_TrkjiyuuKbn extends AbstractUserType<C_TrkjiyuuKbn> {

    @Override
    protected Class<C_TrkjiyuuKbn> returnType() {
        return C_TrkjiyuuKbn.class;
    }

    @Override
    protected C_TrkjiyuuKbn valueOf(String pValue) {
        return C_TrkjiyuuKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_TrkjiyuuKbn pValue) {
        return pValue.getValue();
    }
}
