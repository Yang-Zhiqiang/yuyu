package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_LnSeikyuuKbn;

/**
 * {@link C_LnSeikyuuKbn ＬＮ請求区分} の Hibernate ユーザー定義型です。<br />
 * ＬＮ請求区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_LnSeikyuuKbn extends AbstractUserType<C_LnSeikyuuKbn> {

    @Override
    protected Class<C_LnSeikyuuKbn> returnType() {
        return C_LnSeikyuuKbn.class;
    }

    @Override
    protected C_LnSeikyuuKbn valueOf(String pValue) {
        return C_LnSeikyuuKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_LnSeikyuuKbn pValue) {
        return pValue.getValue();
    }
}
