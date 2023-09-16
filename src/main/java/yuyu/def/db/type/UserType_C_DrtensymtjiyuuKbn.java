package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_DrtensymtjiyuuKbn;

/**
 * {@link C_DrtensymtjiyuuKbn 代理店消滅事由区分} の Hibernate ユーザー定義型です。<br />
 * 代理店消滅事由区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_DrtensymtjiyuuKbn extends AbstractUserType<C_DrtensymtjiyuuKbn> {

    @Override
    protected Class<C_DrtensymtjiyuuKbn> returnType() {
        return C_DrtensymtjiyuuKbn.class;
    }

    @Override
    protected C_DrtensymtjiyuuKbn valueOf(String pValue) {
        return C_DrtensymtjiyuuKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_DrtensymtjiyuuKbn pValue) {
        return pValue.getValue();
    }
}
