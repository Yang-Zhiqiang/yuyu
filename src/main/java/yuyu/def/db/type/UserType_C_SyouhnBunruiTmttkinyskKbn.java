package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_SyouhnBunruiTmttkinyskKbn;

/**
 * {@link C_SyouhnBunruiTmttkinyskKbn 商品分類積立金予測区分} の Hibernate ユーザー定義型です。<br />
 * 商品分類積立金予測区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_SyouhnBunruiTmttkinyskKbn extends AbstractUserType<C_SyouhnBunruiTmttkinyskKbn> {

    @Override
    protected Class<C_SyouhnBunruiTmttkinyskKbn> returnType() {
        return C_SyouhnBunruiTmttkinyskKbn.class;
    }

    @Override
    protected C_SyouhnBunruiTmttkinyskKbn valueOf(String pValue) {
        return C_SyouhnBunruiTmttkinyskKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_SyouhnBunruiTmttkinyskKbn pValue) {
        return pValue.getValue();
    }
}
