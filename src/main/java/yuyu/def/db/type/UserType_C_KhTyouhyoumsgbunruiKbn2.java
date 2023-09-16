package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_KhTyouhyoumsgbunruiKbn2;

/**
 * {@link C_KhTyouhyoumsgbunruiKbn2 契約保全帳票メッセージ分類区分２} の Hibernate ユーザー定義型です。<br />
 * 契約保全帳票メッセージ分類区分２ 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_KhTyouhyoumsgbunruiKbn2 extends AbstractUserType<C_KhTyouhyoumsgbunruiKbn2> {

    @Override
    protected Class<C_KhTyouhyoumsgbunruiKbn2> returnType() {
        return C_KhTyouhyoumsgbunruiKbn2.class;
    }

    @Override
    protected C_KhTyouhyoumsgbunruiKbn2 valueOf(String pValue) {
        return C_KhTyouhyoumsgbunruiKbn2.valueOf(pValue);
    }

    @Override
    protected String toString(C_KhTyouhyoumsgbunruiKbn2 pValue) {
        return pValue.getValue();
    }
}
