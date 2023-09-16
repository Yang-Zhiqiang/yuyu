package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_NyuuinJyoukyou;

/**
 * {@link C_NyuuinJyoukyou 入院状況} の Hibernate ユーザー定義型です。<br />
 * 入院状況 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_NyuuinJyoukyou extends AbstractUserType<C_NyuuinJyoukyou> {

    @Override
    protected Class<C_NyuuinJyoukyou> returnType() {
        return C_NyuuinJyoukyou.class;
    }

    @Override
    protected C_NyuuinJyoukyou valueOf(String pValue) {
        return C_NyuuinJyoukyou.valueOf(pValue);
    }

    @Override
    protected String toString(C_NyuuinJyoukyou pValue) {
        return pValue.getValue();
    }
}
