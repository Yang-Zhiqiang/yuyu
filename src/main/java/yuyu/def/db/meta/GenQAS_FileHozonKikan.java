package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.classification.C_FileSyuruiCdKbn;
import yuyu.def.classification.C_NengappiKbn;
import yuyu.def.db.entity.AS_FileHozonKikan;
import yuyu.def.db.type.UserType_C_FileSyuruiCdKbn;
import yuyu.def.db.type.UserType_C_NengappiKbn;

/**
 * ファイル保存期間基幹テーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQAS_FileHozonKikan extends AbstractExDBTable<AS_FileHozonKikan> {

    public GenQAS_FileHozonKikan() {
        this("AS_FileHozonKikan");
    }

    public GenQAS_FileHozonKikan(String pAlias) {
        super("AS_FileHozonKikan", AS_FileHozonKikan.class, pAlias);
    }

    public String AS_FileHozonKikan() {
        return getAliasExpression();
    }

    public final ExDBFieldString<AS_FileHozonKikan, C_FileSyuruiCdKbn> fileSyuruiCd = new ExDBFieldString<>("fileSyuruiCd", this, UserType_C_FileSyuruiCdKbn.class);

    public final ExDBFieldNumber<AS_FileHozonKikan, Integer> hozonKikan = new ExDBFieldNumber<>("hozonKikan", this);

    public final ExDBFieldString<AS_FileHozonKikan, C_NengappiKbn> nengappiKbn = new ExDBFieldString<>("nengappiKbn", this, UserType_C_NengappiKbn.class);
}
