package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_DsKrHnnKakCdTtYhKbn;

/**
 * {@link C_DsKrHnnKakCdTtYhKbn ＤＳ仮本人確認コード通知要否区分} の Hibernate ユーザー定義型です。<br />
 * ＤＳ仮本人確認コード通知要否区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_DsKrHnnKakCdTtYhKbn extends AbstractUserType<C_DsKrHnnKakCdTtYhKbn> {

    @Override
    protected Class<C_DsKrHnnKakCdTtYhKbn> returnType() {
        return C_DsKrHnnKakCdTtYhKbn.class;
    }

    @Override
    protected C_DsKrHnnKakCdTtYhKbn valueOf(String pValue) {
        return C_DsKrHnnKakCdTtYhKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_DsKrHnnKakCdTtYhKbn pValue) {
        return pValue.getValue();
    }
}
