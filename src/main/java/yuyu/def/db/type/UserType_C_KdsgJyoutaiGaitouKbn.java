package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_KdsgJyoutaiGaitouKbn;

/**
 * {@link C_KdsgJyoutaiGaitouKbn 高度障害状態該当区分} の Hibernate ユーザー定義型です。<br />
 * 高度障害状態該当区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_KdsgJyoutaiGaitouKbn extends AbstractUserType<C_KdsgJyoutaiGaitouKbn> {

    @Override
    protected Class<C_KdsgJyoutaiGaitouKbn> returnType() {
        return C_KdsgJyoutaiGaitouKbn.class;
    }

    @Override
    protected C_KdsgJyoutaiGaitouKbn valueOf(String pValue) {
        return C_KdsgJyoutaiGaitouKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_KdsgJyoutaiGaitouKbn pValue) {
        return pValue.getValue();
    }
}
