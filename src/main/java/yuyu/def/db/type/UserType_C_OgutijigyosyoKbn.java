package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_OgutijigyosyoKbn;

/**
 * {@link C_OgutijigyosyoKbn 大口事業所区分} の Hibernate ユーザー定義型です。<br />
 * 大口事業所区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_OgutijigyosyoKbn extends AbstractUserType<C_OgutijigyosyoKbn> {

    @Override
    protected Class<C_OgutijigyosyoKbn> returnType() {
        return C_OgutijigyosyoKbn.class;
    }

    @Override
    protected C_OgutijigyosyoKbn valueOf(String pValue) {
        return C_OgutijigyosyoKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_OgutijigyosyoKbn pValue) {
        return pValue.getValue();
    }
}
