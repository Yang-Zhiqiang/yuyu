package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_KhTyouhyoumsgbunruiKbn3;

/**
 * {@link C_KhTyouhyoumsgbunruiKbn3 契約保全帳票メッセージ分類区分３} の Hibernate ユーザー定義型です。<br />
 * 契約保全帳票メッセージ分類区分３ 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_KhTyouhyoumsgbunruiKbn3 extends AbstractUserType<C_KhTyouhyoumsgbunruiKbn3> {

    @Override
    protected Class<C_KhTyouhyoumsgbunruiKbn3> returnType() {
        return C_KhTyouhyoumsgbunruiKbn3.class;
    }

    @Override
    protected C_KhTyouhyoumsgbunruiKbn3 valueOf(String pValue) {
        return C_KhTyouhyoumsgbunruiKbn3.valueOf(pValue);
    }

    @Override
    protected String toString(C_KhTyouhyoumsgbunruiKbn3 pValue) {
        return pValue.getValue();
    }
}
