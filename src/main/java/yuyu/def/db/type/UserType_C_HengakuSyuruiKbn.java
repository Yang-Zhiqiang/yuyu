package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_HengakuSyuruiKbn;

/**
 * {@link C_HengakuSyuruiKbn 変額種類区分} の Hibernate ユーザー定義型です。<br />
 * 変額種類区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_HengakuSyuruiKbn extends AbstractUserType<C_HengakuSyuruiKbn> {

    @Override
    protected Class<C_HengakuSyuruiKbn> returnType() {
        return C_HengakuSyuruiKbn.class;
    }

    @Override
    protected C_HengakuSyuruiKbn valueOf(String pValue) {
        return C_HengakuSyuruiKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_HengakuSyuruiKbn pValue) {
        return pValue.getValue();
    }
}
