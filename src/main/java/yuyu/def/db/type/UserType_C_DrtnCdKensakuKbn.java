package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_DrtnCdKensakuKbn;

/**
 * {@link C_DrtnCdKensakuKbn 代理店コード検索区分} の Hibernate ユーザー定義型です。<br />
 * 代理店コード検索区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_DrtnCdKensakuKbn extends AbstractUserType<C_DrtnCdKensakuKbn> {

    @Override
    protected Class<C_DrtnCdKensakuKbn> returnType() {
        return C_DrtnCdKensakuKbn.class;
    }

    @Override
    protected C_DrtnCdKensakuKbn valueOf(String pValue) {
        return C_DrtnCdKensakuKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_DrtnCdKensakuKbn pValue) {
        return pValue.getValue();
    }
}
