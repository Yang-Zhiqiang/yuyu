package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_FuriTaniHanteiKekkaKbn;

/**
 * {@link C_FuriTaniHanteiKekkaKbn 振替伝票単位判定結果区分} の Hibernate ユーザー定義型です。<br />
 * 振替伝票単位判定結果区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_FuriTaniHanteiKekkaKbn extends AbstractUserType<C_FuriTaniHanteiKekkaKbn> {

    @Override
    protected Class<C_FuriTaniHanteiKekkaKbn> returnType() {
        return C_FuriTaniHanteiKekkaKbn.class;
    }

    @Override
    protected C_FuriTaniHanteiKekkaKbn valueOf(String pValue) {
        return C_FuriTaniHanteiKekkaKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_FuriTaniHanteiKekkaKbn pValue) {
        return pValue.getValue();
    }
}
