package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_SyuturyokuKaisiGyouKbn;

/**
 * {@link C_SyuturyokuKaisiGyouKbn 出力開始行区分} の Hibernate ユーザー定義型です。<br />
 * 出力開始行区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_SyuturyokuKaisiGyouKbn extends AbstractUserType<C_SyuturyokuKaisiGyouKbn> {

    @Override
    protected Class<C_SyuturyokuKaisiGyouKbn> returnType() {
        return C_SyuturyokuKaisiGyouKbn.class;
    }

    @Override
    protected C_SyuturyokuKaisiGyouKbn valueOf(String pValue) {
        return C_SyuturyokuKaisiGyouKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_SyuturyokuKaisiGyouKbn pValue) {
        return pValue.getValue();
    }
}
