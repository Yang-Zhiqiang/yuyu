package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_MostenkenjyouKbn;

/**
 * {@link C_MostenkenjyouKbn 申込点検状態区分} の Hibernate ユーザー定義型です。<br />
 * 申込点検状態区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_MostenkenjyouKbn extends AbstractUserType<C_MostenkenjyouKbn> {

    @Override
    protected Class<C_MostenkenjyouKbn> returnType() {
        return C_MostenkenjyouKbn.class;
    }

    @Override
    protected C_MostenkenjyouKbn valueOf(String pValue) {
        return C_MostenkenjyouKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_MostenkenjyouKbn pValue) {
        return pValue.getValue();
    }
}
