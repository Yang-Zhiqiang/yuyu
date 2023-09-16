package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_HasseijikngksyuruiKbn;

/**
 * {@link C_HasseijikngksyuruiKbn 発生時金額種類区分} の Hibernate ユーザー定義型です。<br />
 * 発生時金額種類区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_HasseijikngksyuruiKbn extends AbstractUserType<C_HasseijikngksyuruiKbn> {

    @Override
    protected Class<C_HasseijikngksyuruiKbn> returnType() {
        return C_HasseijikngksyuruiKbn.class;
    }

    @Override
    protected C_HasseijikngksyuruiKbn valueOf(String pValue) {
        return C_HasseijikngksyuruiKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_HasseijikngksyuruiKbn pValue) {
        return pValue.getValue();
    }
}
