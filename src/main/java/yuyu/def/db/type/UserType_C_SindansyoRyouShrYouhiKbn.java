package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_SindansyoRyouShrYouhiKbn;

/**
 * {@link C_SindansyoRyouShrYouhiKbn 診断書料支払要否区分} の Hibernate ユーザー定義型です。<br />
 * 診断書料支払要否区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_SindansyoRyouShrYouhiKbn extends AbstractUserType<C_SindansyoRyouShrYouhiKbn> {

    @Override
    protected Class<C_SindansyoRyouShrYouhiKbn> returnType() {
        return C_SindansyoRyouShrYouhiKbn.class;
    }

    @Override
    protected C_SindansyoRyouShrYouhiKbn valueOf(String pValue) {
        return C_SindansyoRyouShrYouhiKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_SindansyoRyouShrYouhiKbn pValue) {
        return pValue.getValue();
    }
}
