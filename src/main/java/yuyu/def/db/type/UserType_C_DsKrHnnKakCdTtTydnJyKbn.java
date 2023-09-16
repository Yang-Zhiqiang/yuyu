package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_DsKrHnnKakCdTtTydnJyKbn;

/**
 * {@link C_DsKrHnnKakCdTtTydnJyKbn ＤＳ仮本人確認コード通知中断事由区分} の Hibernate ユーザー定義型です。<br />
 * ＤＳ仮本人確認コード通知中断事由区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_DsKrHnnKakCdTtTydnJyKbn extends AbstractUserType<C_DsKrHnnKakCdTtTydnJyKbn> {

    @Override
    protected Class<C_DsKrHnnKakCdTtTydnJyKbn> returnType() {
        return C_DsKrHnnKakCdTtTydnJyKbn.class;
    }

    @Override
    protected C_DsKrHnnKakCdTtTydnJyKbn valueOf(String pValue) {
        return C_DsKrHnnKakCdTtTydnJyKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_DsKrHnnKakCdTtTydnJyKbn pValue) {
        return pValue.getValue();
    }
}
