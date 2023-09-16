package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_YuukoukakujkKbn;

/**
 * {@link C_YuukoukakujkKbn 有効性確認状況区分} の Hibernate ユーザー定義型です。<br />
 * 有効性確認状況区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_YuukoukakujkKbn extends AbstractUserType<C_YuukoukakujkKbn> {

    @Override
    protected Class<C_YuukoukakujkKbn> returnType() {
        return C_YuukoukakujkKbn.class;
    }

    @Override
    protected C_YuukoukakujkKbn valueOf(String pValue) {
        return C_YuukoukakujkKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_YuukoukakujkKbn pValue) {
        return pValue.getValue();
    }
}
