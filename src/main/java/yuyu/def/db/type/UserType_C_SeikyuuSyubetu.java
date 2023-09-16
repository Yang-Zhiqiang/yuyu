package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_SeikyuuSyubetu;

/**
 * {@link C_SeikyuuSyubetu 請求種別} の Hibernate ユーザー定義型です。<br />
 * 請求種別 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_SeikyuuSyubetu extends AbstractUserType<C_SeikyuuSyubetu> {

    @Override
    protected Class<C_SeikyuuSyubetu> returnType() {
        return C_SeikyuuSyubetu.class;
    }

    @Override
    protected C_SeikyuuSyubetu valueOf(String pValue) {
        return C_SeikyuuSyubetu.valueOf(pValue);
    }

    @Override
    protected String toString(C_SeikyuuSyubetu pValue) {
        return pValue.getValue();
    }
}
