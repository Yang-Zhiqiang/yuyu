package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_MostenkenkekkaKbn;

/**
 * {@link C_MostenkenkekkaKbn 申込点検結果区分} の Hibernate ユーザー定義型です。<br />
 * 申込点検結果区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_MostenkenkekkaKbn extends AbstractUserType<C_MostenkenkekkaKbn> {

    @Override
    protected Class<C_MostenkenkekkaKbn> returnType() {
        return C_MostenkenkekkaKbn.class;
    }

    @Override
    protected C_MostenkenkekkaKbn valueOf(String pValue) {
        return C_MostenkenkekkaKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_MostenkenkekkaKbn pValue) {
        return pValue.getValue();
    }
}
