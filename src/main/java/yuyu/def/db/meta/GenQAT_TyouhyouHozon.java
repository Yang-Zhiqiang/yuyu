package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.classification.C_YesNoKbn;
import yuyu.def.db.entity.AT_TyouhyouHozon;
import yuyu.def.db.type.UserType_C_YesNoKbn;

/**
 * 帳票保存テーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQAT_TyouhyouHozon extends AbstractExDBTable<AT_TyouhyouHozon> {

    public GenQAT_TyouhyouHozon() {
        this("AT_TyouhyouHozon");
    }

    public GenQAT_TyouhyouHozon(String pAlias) {
        super("AT_TyouhyouHozon", AT_TyouhyouHozon.class, pAlias);
    }

    public String AT_TyouhyouHozon() {
        return getAliasExpression();
    }

    public final ExDBFieldString<AT_TyouhyouHozon, String> reportKey = new ExDBFieldString<>("reportKey", this);

    public final ExDBFieldString<AT_TyouhyouHozon, byte[]> pdfData = new ExDBFieldString<>("pdfData", this);

    public final ExDBFieldString<AT_TyouhyouHozon, String> tyouhyouJoinKey = new ExDBFieldString<>("tyouhyouJoinKey", this);

    public final ExDBFieldString<AT_TyouhyouHozon, C_YesNoKbn> angoukaKbn = new ExDBFieldString<>("angoukaKbn", this, UserType_C_YesNoKbn.class);

    public final ExDBFieldString<AT_TyouhyouHozon, C_YesNoKbn> pdfHozonKbn = new ExDBFieldString<>("pdfHozonKbn", this, UserType_C_YesNoKbn.class);

    public final ExDBFieldString<AT_TyouhyouHozon, C_YesNoKbn> zipHozonKbn = new ExDBFieldString<>("zipHozonKbn", this, UserType_C_YesNoKbn.class);
}
