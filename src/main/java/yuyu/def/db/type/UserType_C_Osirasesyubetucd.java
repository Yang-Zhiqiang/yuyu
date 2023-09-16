package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_Osirasesyubetucd;

/**
 * {@link C_Osirasesyubetucd お知らせ種別コード} の Hibernate ユーザー定義型です。<br />
 * お知らせ種別コード 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_Osirasesyubetucd extends AbstractUserType<C_Osirasesyubetucd> {

    @Override
    protected Class<C_Osirasesyubetucd> returnType() {
        return C_Osirasesyubetucd.class;
    }

    @Override
    protected C_Osirasesyubetucd valueOf(String pValue) {
        return C_Osirasesyubetucd.valueOf(pValue);
    }

    @Override
    protected String toString(C_Osirasesyubetucd pValue) {
        return pValue.getValue();
    }
}
