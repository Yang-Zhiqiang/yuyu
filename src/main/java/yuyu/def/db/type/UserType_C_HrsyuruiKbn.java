package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_HrsyuruiKbn;

/**
 * {@link C_HrsyuruiKbn 返戻金種類区分} の Hibernate ユーザー定義型です。<br />
 * 返戻金種類区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_HrsyuruiKbn extends AbstractUserType<C_HrsyuruiKbn> {

    @Override
    protected Class<C_HrsyuruiKbn> returnType() {
        return C_HrsyuruiKbn.class;
    }

    @Override
    protected C_HrsyuruiKbn valueOf(String pValue) {
        return C_HrsyuruiKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_HrsyuruiKbn pValue) {
        return pValue.getValue();
    }
}
