package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_SyoruiUkebasyo;

/**
 * {@link C_SyoruiUkebasyo 書類受付場所} の Hibernate ユーザー定義型です。<br />
 * 書類受付場所 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_SyoruiUkebasyo extends AbstractUserType<C_SyoruiUkebasyo> {

    @Override
    protected Class<C_SyoruiUkebasyo> returnType() {
        return C_SyoruiUkebasyo.class;
    }

    @Override
    protected C_SyoruiUkebasyo valueOf(String pValue) {
        return C_SyoruiUkebasyo.valueOf(pValue);
    }

    @Override
    protected String toString(C_SyoruiUkebasyo pValue) {
        return pValue.getValue();
    }
}
