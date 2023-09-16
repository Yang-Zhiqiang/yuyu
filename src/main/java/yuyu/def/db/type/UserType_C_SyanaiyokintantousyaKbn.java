package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_SyanaiyokintantousyaKbn;

/**
 * {@link C_SyanaiyokintantousyaKbn 社内預金担当者区分} の Hibernate ユーザー定義型です。<br />
 * 社内預金担当者区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_SyanaiyokintantousyaKbn extends AbstractUserType<C_SyanaiyokintantousyaKbn> {

    @Override
    protected Class<C_SyanaiyokintantousyaKbn> returnType() {
        return C_SyanaiyokintantousyaKbn.class;
    }

    @Override
    protected C_SyanaiyokintantousyaKbn valueOf(String pValue) {
        return C_SyanaiyokintantousyaKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_SyanaiyokintantousyaKbn pValue) {
        return pValue.getValue();
    }
}
