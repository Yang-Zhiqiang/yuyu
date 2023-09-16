package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.classification.C_FileSyuruiCdKbn;
import yuyu.def.db.entity.AT_FileKengen;
import yuyu.def.db.type.UserType_C_FileSyuruiCdKbn;

/**
 * ファイル権限テーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQAT_FileKengen extends AbstractExDBTable<AT_FileKengen> {

    public GenQAT_FileKengen() {
        this("AT_FileKengen");
    }

    public GenQAT_FileKengen(String pAlias) {
        super("AT_FileKengen", AT_FileKengen.class, pAlias);
    }

    public String AT_FileKengen() {
        return getAliasExpression();
    }

    public final ExDBFieldString<AT_FileKengen, String> roleCd = new ExDBFieldString<>("roleCd", this);

    public final ExDBFieldString<AT_FileKengen, C_FileSyuruiCdKbn> fileSyuruiCd = new ExDBFieldString<>("fileSyuruiCd", this, UserType_C_FileSyuruiCdKbn.class);
}
