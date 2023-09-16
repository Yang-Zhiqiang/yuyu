package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_Sbgoseikyuunaiyou;

/**
 * {@link C_Sbgoseikyuunaiyou 死亡後請求内容} の Hibernate ユーザー定義型です。<br />
 * 死亡後請求内容 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_Sbgoseikyuunaiyou extends AbstractUserType<C_Sbgoseikyuunaiyou> {

    @Override
    protected Class<C_Sbgoseikyuunaiyou> returnType() {
        return C_Sbgoseikyuunaiyou.class;
    }

    @Override
    protected C_Sbgoseikyuunaiyou valueOf(String pValue) {
        return C_Sbgoseikyuunaiyou.valueOf(pValue);
    }

    @Override
    protected String toString(C_Sbgoseikyuunaiyou pValue) {
        return pValue.getValue();
    }
}
