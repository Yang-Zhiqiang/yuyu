package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_SiharaiSyoriJyoutaiKbn;

/**
 * {@link C_SiharaiSyoriJyoutaiKbn 支払処理状態区分} の Hibernate ユーザー定義型です。<br />
 * 支払処理状態区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_SiharaiSyoriJyoutaiKbn extends AbstractUserType<C_SiharaiSyoriJyoutaiKbn> {

    @Override
    protected Class<C_SiharaiSyoriJyoutaiKbn> returnType() {
        return C_SiharaiSyoriJyoutaiKbn.class;
    }

    @Override
    protected C_SiharaiSyoriJyoutaiKbn valueOf(String pValue) {
        return C_SiharaiSyoriJyoutaiKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_SiharaiSyoriJyoutaiKbn pValue) {
        return pValue.getValue();
    }
}
