package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_NosyuruiKbn;

/**
 * {@link C_NosyuruiKbn 番号種類区分} の Hibernate ユーザー定義型です。<br />
 * 番号種類区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_NosyuruiKbn extends AbstractUserType<C_NosyuruiKbn> {

    @Override
    protected Class<C_NosyuruiKbn> returnType() {
        return C_NosyuruiKbn.class;
    }

    @Override
    protected C_NosyuruiKbn valueOf(String pValue) {
        return C_NosyuruiKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_NosyuruiKbn pValue) {
        return pValue.getValue();
    }
}
