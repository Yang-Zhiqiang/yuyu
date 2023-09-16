package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_SntksyuKbn;

/**
 * {@link C_SntksyuKbn 選択情報種類区分} の Hibernate ユーザー定義型です。<br />
 * 選択情報種類区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_SntksyuKbn extends AbstractUserType<C_SntksyuKbn> {

    @Override
    protected Class<C_SntksyuKbn> returnType() {
        return C_SntksyuKbn.class;
    }

    @Override
    protected C_SntksyuKbn valueOf(String pValue) {
        return C_SntksyuKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_SntksyuKbn pValue) {
        return pValue.getValue();
    }
}
