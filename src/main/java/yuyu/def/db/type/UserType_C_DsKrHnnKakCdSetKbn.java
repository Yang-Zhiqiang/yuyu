package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_DsKrHnnKakCdSetKbn;

/**
 * {@link C_DsKrHnnKakCdSetKbn ＤＳ仮本人確認コード設定区分} の Hibernate ユーザー定義型です。<br />
 * ＤＳ仮本人確認コード設定区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_DsKrHnnKakCdSetKbn extends AbstractUserType<C_DsKrHnnKakCdSetKbn> {

    @Override
    protected Class<C_DsKrHnnKakCdSetKbn> returnType() {
        return C_DsKrHnnKakCdSetKbn.class;
    }

    @Override
    protected C_DsKrHnnKakCdSetKbn valueOf(String pValue) {
        return C_DsKrHnnKakCdSetKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_DsKrHnnKakCdSetKbn pValue) {
        return pValue.getValue();
    }
}
