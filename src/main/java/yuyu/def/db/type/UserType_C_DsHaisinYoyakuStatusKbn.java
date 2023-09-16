package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_DsHaisinYoyakuStatusKbn;

/**
 * {@link C_DsHaisinYoyakuStatusKbn ＤＳ配信予約ステータス区分} の Hibernate ユーザー定義型です。<br />
 * ＤＳ配信予約ステータス区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_DsHaisinYoyakuStatusKbn extends AbstractUserType<C_DsHaisinYoyakuStatusKbn> {

    @Override
    protected Class<C_DsHaisinYoyakuStatusKbn> returnType() {
        return C_DsHaisinYoyakuStatusKbn.class;
    }

    @Override
    protected C_DsHaisinYoyakuStatusKbn valueOf(String pValue) {
        return C_DsHaisinYoyakuStatusKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_DsHaisinYoyakuStatusKbn pValue) {
        return pValue.getValue();
    }
}
