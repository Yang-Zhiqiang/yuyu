package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_KanryotuutioutKbn;

/**
 * {@link C_KanryotuutioutKbn 完了通知出力区分} の Hibernate ユーザー定義型です。<br />
 * 完了通知出力区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_KanryotuutioutKbn extends AbstractUserType<C_KanryotuutioutKbn> {

    @Override
    protected Class<C_KanryotuutioutKbn> returnType() {
        return C_KanryotuutioutKbn.class;
    }

    @Override
    protected C_KanryotuutioutKbn valueOf(String pValue) {
        return C_KanryotuutioutKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_KanryotuutioutKbn pValue) {
        return pValue.getValue();
    }
}
