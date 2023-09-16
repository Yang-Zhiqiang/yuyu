package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_SyoubyouCdTyuubunruiKbn;

/**
 * {@link C_SyoubyouCdTyuubunruiKbn 傷病コード中分類区分} の Hibernate ユーザー定義型です。<br />
 * 傷病コード中分類区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_SyoubyouCdTyuubunruiKbn extends AbstractUserType<C_SyoubyouCdTyuubunruiKbn> {

    @Override
    protected Class<C_SyoubyouCdTyuubunruiKbn> returnType() {
        return C_SyoubyouCdTyuubunruiKbn.class;
    }

    @Override
    protected C_SyoubyouCdTyuubunruiKbn valueOf(String pValue) {
        return C_SyoubyouCdTyuubunruiKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_SyoubyouCdTyuubunruiKbn pValue) {
        return pValue.getValue();
    }
}
