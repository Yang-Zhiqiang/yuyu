package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_KihonssyuruiKbn;

/**
 * {@link C_KihonssyuruiKbn 基本Ｓ種類区分} の Hibernate ユーザー定義型です。<br />
 * 基本Ｓ種類区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_KihonssyuruiKbn extends AbstractUserType<C_KihonssyuruiKbn> {

    @Override
    protected Class<C_KihonssyuruiKbn> returnType() {
        return C_KihonssyuruiKbn.class;
    }

    @Override
    protected C_KihonssyuruiKbn valueOf(String pValue) {
        return C_KihonssyuruiKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_KihonssyuruiKbn pValue) {
        return pValue.getValue();
    }
}
