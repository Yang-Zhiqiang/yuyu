package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_AeoiHoujinSyuruiKbn;

/**
 * {@link C_AeoiHoujinSyuruiKbn ＡＥＯＩ法人種類区分} の Hibernate ユーザー定義型です。<br />
 * ＡＥＯＩ法人種類区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_AeoiHoujinSyuruiKbn extends AbstractUserType<C_AeoiHoujinSyuruiKbn> {

    @Override
    protected Class<C_AeoiHoujinSyuruiKbn> returnType() {
        return C_AeoiHoujinSyuruiKbn.class;
    }

    @Override
    protected C_AeoiHoujinSyuruiKbn valueOf(String pValue) {
        return C_AeoiHoujinSyuruiKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_AeoiHoujinSyuruiKbn pValue) {
        return pValue.getValue();
    }
}
