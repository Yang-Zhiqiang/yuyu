package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_DrtsyouhincdHrkkaisuu;

/**
 * {@link C_DrtsyouhincdHrkkaisuu 代理店商品コード用払込回数} の Hibernate ユーザー定義型です。<br />
 * 代理店商品コード用払込回数 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_DrtsyouhincdHrkkaisuu extends AbstractUserType<C_DrtsyouhincdHrkkaisuu> {

    @Override
    protected Class<C_DrtsyouhincdHrkkaisuu> returnType() {
        return C_DrtsyouhincdHrkkaisuu.class;
    }

    @Override
    protected C_DrtsyouhincdHrkkaisuu valueOf(String pValue) {
        return C_DrtsyouhincdHrkkaisuu.valueOf(pValue);
    }

    @Override
    protected String toString(C_DrtsyouhincdHrkkaisuu pValue) {
        return pValue.getValue();
    }
}
