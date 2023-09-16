package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_SyouhinJyouhouGetKbn;

/**
 * {@link C_SyouhinJyouhouGetKbn 商品情報取得区分} の Hibernate ユーザー定義型です。<br />
 * 商品情報取得区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_SyouhinJyouhouGetKbn extends AbstractUserType<C_SyouhinJyouhouGetKbn> {

    @Override
    protected Class<C_SyouhinJyouhouGetKbn> returnType() {
        return C_SyouhinJyouhouGetKbn.class;
    }

    @Override
    protected C_SyouhinJyouhouGetKbn valueOf(String pValue) {
        return C_SyouhinJyouhouGetKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_SyouhinJyouhouGetKbn pValue) {
        return pValue.getValue();
    }
}
