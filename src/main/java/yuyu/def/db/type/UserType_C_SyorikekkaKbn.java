package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_SyorikekkaKbn;

/**
 * {@link C_SyorikekkaKbn 処理結果区分} の Hibernate ユーザー定義型です。<br />
 * 処理結果区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_SyorikekkaKbn extends AbstractUserType<C_SyorikekkaKbn> {

    @Override
    protected Class<C_SyorikekkaKbn> returnType() {
        return C_SyorikekkaKbn.class;
    }

    @Override
    protected C_SyorikekkaKbn valueOf(String pValue) {
        return C_SyorikekkaKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_SyorikekkaKbn pValue) {
        return pValue.getValue();
    }
}
