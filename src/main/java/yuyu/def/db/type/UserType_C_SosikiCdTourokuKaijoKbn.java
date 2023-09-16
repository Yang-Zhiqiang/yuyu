package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_SosikiCdTourokuKaijoKbn;

/**
 * {@link C_SosikiCdTourokuKaijoKbn 組織コード登録解除区分} の Hibernate ユーザー定義型です。<br />
 * 組織コード登録解除区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_SosikiCdTourokuKaijoKbn extends AbstractUserType<C_SosikiCdTourokuKaijoKbn> {

    @Override
    protected Class<C_SosikiCdTourokuKaijoKbn> returnType() {
        return C_SosikiCdTourokuKaijoKbn.class;
    }

    @Override
    protected C_SosikiCdTourokuKaijoKbn valueOf(String pValue) {
        return C_SosikiCdTourokuKaijoKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_SosikiCdTourokuKaijoKbn pValue) {
        return pValue.getValue();
    }
}
