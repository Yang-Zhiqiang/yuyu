package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_SoukinsakisiteiKbn;

/**
 * {@link C_SoukinsakisiteiKbn 送金先指定区分} の Hibernate ユーザー定義型です。<br />
 * 送金先指定区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_SoukinsakisiteiKbn extends AbstractUserType<C_SoukinsakisiteiKbn> {

    @Override
    protected Class<C_SoukinsakisiteiKbn> returnType() {
        return C_SoukinsakisiteiKbn.class;
    }

    @Override
    protected C_SoukinsakisiteiKbn valueOf(String pValue) {
        return C_SoukinsakisiteiKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_SoukinsakisiteiKbn pValue) {
        return pValue.getValue();
    }
}
