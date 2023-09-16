package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_KzktourokuserviceTourokuKbn;

/**
 * {@link C_KzktourokuserviceTourokuKbn ご家族登録サービス登録区分} の Hibernate ユーザー定義型です。<br />
 * ご家族登録サービス登録区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_KzktourokuserviceTourokuKbn extends AbstractUserType<C_KzktourokuserviceTourokuKbn> {

    @Override
    protected Class<C_KzktourokuserviceTourokuKbn> returnType() {
        return C_KzktourokuserviceTourokuKbn.class;
    }

    @Override
    protected C_KzktourokuserviceTourokuKbn valueOf(String pValue) {
        return C_KzktourokuserviceTourokuKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_KzktourokuserviceTourokuKbn pValue) {
        return pValue.getValue();
    }
}
