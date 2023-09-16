package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_ShrSkJyoukyou;

/**
 * {@link C_ShrSkJyoukyou 支払請求状況} の Hibernate ユーザー定義型です。<br />
 * 支払請求状況 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_ShrSkJyoukyou extends AbstractUserType<C_ShrSkJyoukyou> {

    @Override
    protected Class<C_ShrSkJyoukyou> returnType() {
        return C_ShrSkJyoukyou.class;
    }

    @Override
    protected C_ShrSkJyoukyou valueOf(String pValue) {
        return C_ShrSkJyoukyou.valueOf(pValue);
    }

    @Override
    protected String toString(C_ShrSkJyoukyou pValue) {
        return pValue.getValue();
    }
}
