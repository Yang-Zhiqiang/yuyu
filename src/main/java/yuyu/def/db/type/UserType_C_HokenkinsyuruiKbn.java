package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_HokenkinsyuruiKbn;

/**
 * {@link C_HokenkinsyuruiKbn 保険金種類区分} の Hibernate ユーザー定義型です。<br />
 * 保険金種類区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_HokenkinsyuruiKbn extends AbstractUserType<C_HokenkinsyuruiKbn> {

    @Override
    protected Class<C_HokenkinsyuruiKbn> returnType() {
        return C_HokenkinsyuruiKbn.class;
    }

    @Override
    protected C_HokenkinsyuruiKbn valueOf(String pValue) {
        return C_HokenkinsyuruiKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_HokenkinsyuruiKbn pValue) {
        return pValue.getValue();
    }
}
