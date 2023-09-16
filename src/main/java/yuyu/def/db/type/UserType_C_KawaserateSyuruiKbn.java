package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_KawaserateSyuruiKbn;

/**
 * {@link C_KawaserateSyuruiKbn 為替レート種類区分} の Hibernate ユーザー定義型です。<br />
 * 為替レート種類区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_KawaserateSyuruiKbn extends AbstractUserType<C_KawaserateSyuruiKbn> {

    @Override
    protected Class<C_KawaserateSyuruiKbn> returnType() {
        return C_KawaserateSyuruiKbn.class;
    }

    @Override
    protected C_KawaserateSyuruiKbn valueOf(String pValue) {
        return C_KawaserateSyuruiKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_KawaserateSyuruiKbn pValue) {
        return pValue.getValue();
    }
}
