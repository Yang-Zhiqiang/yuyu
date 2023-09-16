package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_MosTourokuJyoukyouKbn;

/**
 * {@link C_MosTourokuJyoukyouKbn 申込情報登録状況区分} の Hibernate ユーザー定義型です。<br />
 * 申込情報登録状況区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_MosTourokuJyoukyouKbn extends AbstractUserType<C_MosTourokuJyoukyouKbn> {

    @Override
    protected Class<C_MosTourokuJyoukyouKbn> returnType() {
        return C_MosTourokuJyoukyouKbn.class;
    }

    @Override
    protected C_MosTourokuJyoukyouKbn valueOf(String pValue) {
        return C_MosTourokuJyoukyouKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_MosTourokuJyoukyouKbn pValue) {
        return pValue.getValue();
    }
}
