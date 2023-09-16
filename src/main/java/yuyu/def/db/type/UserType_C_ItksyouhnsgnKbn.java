package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_ItksyouhnsgnKbn;

/**
 * {@link C_ItksyouhnsgnKbn 委託商品制限区分} の Hibernate ユーザー定義型です。<br />
 * 委託商品制限区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_ItksyouhnsgnKbn extends AbstractUserType<C_ItksyouhnsgnKbn> {

    @Override
    protected Class<C_ItksyouhnsgnKbn> returnType() {
        return C_ItksyouhnsgnKbn.class;
    }

    @Override
    protected C_ItksyouhnsgnKbn valueOf(String pValue) {
        return C_ItksyouhnsgnKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_ItksyouhnsgnKbn pValue) {
        return pValue.getValue();
    }
}
