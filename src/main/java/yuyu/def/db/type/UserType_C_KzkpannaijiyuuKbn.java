package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_KzkpannaijiyuuKbn;

/**
 * {@link C_KzkpannaijiyuuKbn 継続Ｐ案内事由区分} の Hibernate ユーザー定義型です。<br />
 * 継続Ｐ案内事由区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_KzkpannaijiyuuKbn extends AbstractUserType<C_KzkpannaijiyuuKbn> {

    @Override
    protected Class<C_KzkpannaijiyuuKbn> returnType() {
        return C_KzkpannaijiyuuKbn.class;
    }

    @Override
    protected C_KzkpannaijiyuuKbn valueOf(String pValue) {
        return C_KzkpannaijiyuuKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_KzkpannaijiyuuKbn pValue) {
        return pValue.getValue();
    }
}
