package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_KihontikucdSyutokuErrKbn;

/**
 * {@link C_KihontikucdSyutokuErrKbn 基本地区コード取得エラー区分} の Hibernate ユーザー定義型です。<br />
 * 基本地区コード取得エラー区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_KihontikucdSyutokuErrKbn extends AbstractUserType<C_KihontikucdSyutokuErrKbn> {

    @Override
    protected Class<C_KihontikucdSyutokuErrKbn> returnType() {
        return C_KihontikucdSyutokuErrKbn.class;
    }

    @Override
    protected C_KihontikucdSyutokuErrKbn valueOf(String pValue) {
        return C_KihontikucdSyutokuErrKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_KihontikucdSyutokuErrKbn pValue) {
        return pValue.getValue();
    }
}
