package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_TourokuRouteKbn;

/**
 * {@link C_TourokuRouteKbn 登録ルート区分} の Hibernate ユーザー定義型です。<br />
 * 登録ルート区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_TourokuRouteKbn extends AbstractUserType<C_TourokuRouteKbn> {

    @Override
    protected Class<C_TourokuRouteKbn> returnType() {
        return C_TourokuRouteKbn.class;
    }

    @Override
    protected C_TourokuRouteKbn valueOf(String pValue) {
        return C_TourokuRouteKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_TourokuRouteKbn pValue) {
        return pValue.getValue();
    }
}
