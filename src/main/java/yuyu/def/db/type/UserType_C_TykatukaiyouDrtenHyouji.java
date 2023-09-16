package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_TykatukaiyouDrtenHyouji;

/**
 * {@link C_TykatukaiyouDrtenHyouji 直扱用代理店表示} の Hibernate ユーザー定義型です。<br />
 * 直扱用代理店表示 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_TykatukaiyouDrtenHyouji extends AbstractUserType<C_TykatukaiyouDrtenHyouji> {

    @Override
    protected Class<C_TykatukaiyouDrtenHyouji> returnType() {
        return C_TykatukaiyouDrtenHyouji.class;
    }

    @Override
    protected C_TykatukaiyouDrtenHyouji valueOf(String pValue) {
        return C_TykatukaiyouDrtenHyouji.valueOf(pValue);
    }

    @Override
    protected String toString(C_TykatukaiyouDrtenHyouji pValue) {
        return pValue.getValue();
    }
}
