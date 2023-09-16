package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_SonotaTokuninKbn;

/**
 * {@link C_SonotaTokuninKbn その他特認区分} の Hibernate ユーザー定義型です。<br />
 * その他特認区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_SonotaTokuninKbn extends AbstractUserType<C_SonotaTokuninKbn> {

    @Override
    protected Class<C_SonotaTokuninKbn> returnType() {
        return C_SonotaTokuninKbn.class;
    }

    @Override
    protected C_SonotaTokuninKbn valueOf(String pValue) {
        return C_SonotaTokuninKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_SonotaTokuninKbn pValue) {
        return pValue.getValue();
    }
}
