package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.classification.C_FileSyuruiCdKbn;
import yuyu.def.classification.C_FileSyuruiKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.AS_FileSyurui;
import yuyu.def.db.type.UserType_C_FileSyuruiCdKbn;
import yuyu.def.db.type.UserType_C_FileSyuruiKbn;
import yuyu.def.db.type.UserType_C_UmuKbn;

/**
 * ファイル種類基幹テーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQAS_FileSyurui extends AbstractExDBTable<AS_FileSyurui> {

    public GenQAS_FileSyurui() {
        this("AS_FileSyurui");
    }

    public GenQAS_FileSyurui(String pAlias) {
        super("AS_FileSyurui", AS_FileSyurui.class, pAlias);
    }

    public String AS_FileSyurui() {
        return getAliasExpression();
    }

    public final ExDBFieldString<AS_FileSyurui, C_FileSyuruiCdKbn> fileSyuruiCd = new ExDBFieldString<>("fileSyuruiCd", this, UserType_C_FileSyuruiCdKbn.class);

    public final ExDBFieldString<AS_FileSyurui, String> fileSyuruiNm = new ExDBFieldString<>("fileSyuruiNm", this);

    public final ExDBFieldString<AS_FileSyurui, C_FileSyuruiKbn> fileSyuruiKbn = new ExDBFieldString<>("fileSyuruiKbn", this, UserType_C_FileSyuruiKbn.class);

    public final ExDBFieldString<AS_FileSyurui, String> fileNmPattern = new ExDBFieldString<>("fileNmPattern", this);

    public final ExDBFieldString<AS_FileSyurui, String> downloadFileNm = new ExDBFieldString<>("downloadFileNm", this);

    public final ExDBFieldString<AS_FileSyurui, String> fileType = new ExDBFieldString<>("fileType", this);

    public final ExDBFieldString<AS_FileSyurui, String> dataLayoutBeanClass = new ExDBFieldString<>("dataLayoutBeanClass", this);

    public final ExDBFieldString<AS_FileSyurui, C_UmuKbn> createEmptyFileUmuKbn = new ExDBFieldString<>("createEmptyFileUmuKbn", this, UserType_C_UmuKbn.class);
}
