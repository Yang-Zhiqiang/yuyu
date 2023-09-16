package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_KouteiSyuuryouFlg;

/**
 * {@link C_KouteiSyuuryouFlg 工程終了フラグ} の Hibernate ユーザー定義型です。<br />
 * 工程終了フラグ 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_KouteiSyuuryouFlg extends AbstractUserType<C_KouteiSyuuryouFlg> {

    @Override
    protected Class<C_KouteiSyuuryouFlg> returnType() {
        return C_KouteiSyuuryouFlg.class;
    }

    @Override
    protected C_KouteiSyuuryouFlg valueOf(String pValue) {
        return C_KouteiSyuuryouFlg.valueOf(pValue);
    }

    @Override
    protected String toString(C_KouteiSyuuryouFlg pValue) {
        return pValue.getValue();
    }
}
