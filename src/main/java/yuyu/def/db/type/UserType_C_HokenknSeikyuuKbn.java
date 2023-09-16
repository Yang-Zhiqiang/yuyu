package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_HokenknSeikyuuKbn;

/**
 * {@link C_HokenknSeikyuuKbn 保険金請求区分} の Hibernate ユーザー定義型です。<br />
 * 保険金請求区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_HokenknSeikyuuKbn extends AbstractUserType<C_HokenknSeikyuuKbn> {

    @Override
    protected Class<C_HokenknSeikyuuKbn> returnType() {
        return C_HokenknSeikyuuKbn.class;
    }

    @Override
    protected C_HokenknSeikyuuKbn valueOf(String pValue) {
        return C_HokenknSeikyuuKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_HokenknSeikyuuKbn pValue) {
        return pValue.getValue();
    }
}
