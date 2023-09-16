package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_AzukarikinsyuruiKbn;

/**
 * {@link C_AzukarikinsyuruiKbn 預り金種類区分} の Hibernate ユーザー定義型です。<br />
 * 預り金種類区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_AzukarikinsyuruiKbn extends AbstractUserType<C_AzukarikinsyuruiKbn> {

    @Override
    protected Class<C_AzukarikinsyuruiKbn> returnType() {
        return C_AzukarikinsyuruiKbn.class;
    }

    @Override
    protected C_AzukarikinsyuruiKbn valueOf(String pValue) {
        return C_AzukarikinsyuruiKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_AzukarikinsyuruiKbn pValue) {
        return pValue.getValue();
    }
}
