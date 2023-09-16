package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_DsTrhkserviceKanyukeiroKbn;

/**
 * {@link C_DsTrhkserviceKanyukeiroKbn ＤＳ取引サービス加入経路区分} の Hibernate ユーザー定義型です。<br />
 * ＤＳ取引サービス加入経路区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_DsTrhkserviceKanyukeiroKbn extends AbstractUserType<C_DsTrhkserviceKanyukeiroKbn> {

    @Override
    protected Class<C_DsTrhkserviceKanyukeiroKbn> returnType() {
        return C_DsTrhkserviceKanyukeiroKbn.class;
    }

    @Override
    protected C_DsTrhkserviceKanyukeiroKbn valueOf(String pValue) {
        return C_DsTrhkserviceKanyukeiroKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_DsTrhkserviceKanyukeiroKbn pValue) {
        return pValue.getValue();
    }
}
