package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_NyksyuruiKbn;

/**
 * {@link C_NyksyuruiKbn 入金種類区分} の Hibernate ユーザー定義型です。<br />
 * 入金種類区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_NyksyuruiKbn extends AbstractUserType<C_NyksyuruiKbn> {

    @Override
    protected Class<C_NyksyuruiKbn> returnType() {
        return C_NyksyuruiKbn.class;
    }

    @Override
    protected C_NyksyuruiKbn valueOf(String pValue) {
        return C_NyksyuruiKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_NyksyuruiKbn pValue) {
        return pValue.getValue();
    }
}
