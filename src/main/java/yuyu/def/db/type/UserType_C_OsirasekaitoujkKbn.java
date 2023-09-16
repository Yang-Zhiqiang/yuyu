package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_OsirasekaitoujkKbn;

/**
 * {@link C_OsirasekaitoujkKbn お知らせ回答状況区分} の Hibernate ユーザー定義型です。<br />
 * お知らせ回答状況区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_OsirasekaitoujkKbn extends AbstractUserType<C_OsirasekaitoujkKbn> {

    @Override
    protected Class<C_OsirasekaitoujkKbn> returnType() {
        return C_OsirasekaitoujkKbn.class;
    }

    @Override
    protected C_OsirasekaitoujkKbn valueOf(String pValue) {
        return C_OsirasekaitoujkKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_OsirasekaitoujkKbn pValue) {
        return pValue.getValue();
    }
}
