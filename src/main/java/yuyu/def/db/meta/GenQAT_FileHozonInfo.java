package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.classification.C_FileStatusKbn;
import yuyu.def.classification.C_FileSyuruiCdKbn;
import yuyu.def.db.entity.AT_FileHozonInfo;
import yuyu.def.db.type.UserType_C_FileStatusKbn;
import yuyu.def.db.type.UserType_C_FileSyuruiCdKbn;

/**
 * ファイル保存情報テーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQAT_FileHozonInfo extends AbstractExDBTable<AT_FileHozonInfo> {

    public GenQAT_FileHozonInfo() {
        this("AT_FileHozonInfo");
    }

    public GenQAT_FileHozonInfo(String pAlias) {
        super("AT_FileHozonInfo", AT_FileHozonInfo.class, pAlias);
    }

    public String AT_FileHozonInfo() {
        return getAliasExpression();
    }

    public final ExDBFieldString<AT_FileHozonInfo, String> uniqueId = new ExDBFieldString<>("uniqueId", this);

    public final ExDBFieldString<AT_FileHozonInfo, String> fileNm = new ExDBFieldString<>("fileNm", this);

    public final ExDBFieldString<AT_FileHozonInfo, C_FileSyuruiCdKbn> fileSyuruiCd = new ExDBFieldString<>("fileSyuruiCd", this, UserType_C_FileSyuruiCdKbn.class);

    public final ExDBFieldString<AT_FileHozonInfo, C_FileStatusKbn> fileStatusKbn = new ExDBFieldString<>("fileStatusKbn", this, UserType_C_FileStatusKbn.class);

    public final ExDBFieldString<AT_FileHozonInfo, String> haitaKey = new ExDBFieldString<>("haitaKey", this);

    public final ExDBFieldString<AT_FileHozonInfo, String> tourokuTime = new ExDBFieldString<>("tourokuTime", this);

    public final ExDBFieldString<AT_FileHozonInfo, String> sakuseiKinouId = new ExDBFieldString<>("sakuseiKinouId", this);
}
