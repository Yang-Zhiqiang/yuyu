package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_KhTyouhyoumsgbunruiKbn1;

/**
 * {@link C_KhTyouhyoumsgbunruiKbn1 契約保全帳票メッセージ分類区分１} の Hibernate ユーザー定義型です。<br />
 * 契約保全帳票メッセージ分類区分１ 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_KhTyouhyoumsgbunruiKbn1 extends AbstractUserType<C_KhTyouhyoumsgbunruiKbn1> {

    @Override
    protected Class<C_KhTyouhyoumsgbunruiKbn1> returnType() {
        return C_KhTyouhyoumsgbunruiKbn1.class;
    }

    @Override
    protected C_KhTyouhyoumsgbunruiKbn1 valueOf(String pValue) {
        return C_KhTyouhyoumsgbunruiKbn1.valueOf(pValue);
    }

    @Override
    protected String toString(C_KhTyouhyoumsgbunruiKbn1 pValue) {
        return pValue.getValue();
    }
}
