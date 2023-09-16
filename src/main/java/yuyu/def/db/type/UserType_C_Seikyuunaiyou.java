package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_Seikyuunaiyou;

/**
 * {@link C_Seikyuunaiyou 請求内容} の Hibernate ユーザー定義型です。<br />
 * 請求内容 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_Seikyuunaiyou extends AbstractUserType<C_Seikyuunaiyou> {

    @Override
    protected Class<C_Seikyuunaiyou> returnType() {
        return C_Seikyuunaiyou.class;
    }

    @Override
    protected C_Seikyuunaiyou valueOf(String pValue) {
        return C_Seikyuunaiyou.valueOf(pValue);
    }

    @Override
    protected String toString(C_Seikyuunaiyou pValue) {
        return pValue.getValue();
    }
}
