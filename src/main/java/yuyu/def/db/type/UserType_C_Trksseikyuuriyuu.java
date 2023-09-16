package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_Trksseikyuuriyuu;

/**
 * {@link C_Trksseikyuuriyuu 取消請求理由} の Hibernate ユーザー定義型です。<br />
 * 取消請求理由 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_Trksseikyuuriyuu extends AbstractUserType<C_Trksseikyuuriyuu> {

    @Override
    protected Class<C_Trksseikyuuriyuu> returnType() {
        return C_Trksseikyuuriyuu.class;
    }

    @Override
    protected C_Trksseikyuuriyuu valueOf(String pValue) {
        return C_Trksseikyuuriyuu.valueOf(pValue);
    }

    @Override
    protected String toString(C_Trksseikyuuriyuu pValue) {
        return pValue.getValue();
    }
}
