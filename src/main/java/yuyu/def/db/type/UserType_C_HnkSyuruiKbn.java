package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_HnkSyuruiKbn;

/**
 * {@link C_HnkSyuruiKbn 変更種類区分} の Hibernate ユーザー定義型です。<br />
 * 変更種類区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_HnkSyuruiKbn extends AbstractUserType<C_HnkSyuruiKbn> {

    @Override
    protected Class<C_HnkSyuruiKbn> returnType() {
        return C_HnkSyuruiKbn.class;
    }

    @Override
    protected C_HnkSyuruiKbn valueOf(String pValue) {
        return C_HnkSyuruiKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_HnkSyuruiKbn pValue) {
        return pValue.getValue();
    }
}
