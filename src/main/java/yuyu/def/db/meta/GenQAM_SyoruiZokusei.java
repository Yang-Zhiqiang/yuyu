package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.classification.C_NengetuKbn;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.classification.C_YesNoKbn;
import yuyu.def.db.entity.AM_SyoruiZokusei;
import yuyu.def.db.type.UserType_C_NengetuKbn;
import yuyu.def.db.type.UserType_C_SyoruiCdKbn;
import yuyu.def.db.type.UserType_C_YesNoKbn;

/**
 * 書類属性マスタ のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQAM_SyoruiZokusei extends AbstractExDBTable<AM_SyoruiZokusei> {

    public GenQAM_SyoruiZokusei() {
        this("AM_SyoruiZokusei");
    }

    public GenQAM_SyoruiZokusei(String pAlias) {
        super("AM_SyoruiZokusei", AM_SyoruiZokusei.class, pAlias);
    }

    public String AM_SyoruiZokusei() {
        return getAliasExpression();
    }

    public final ExDBFieldString<AM_SyoruiZokusei, C_SyoruiCdKbn> syoruiCd = new ExDBFieldString<>("syoruiCd", this, UserType_C_SyoruiCdKbn.class);

    public final ExDBFieldString<AM_SyoruiZokusei, String> syoruinm = new ExDBFieldString<>("syoruinm", this);

    public final ExDBFieldString<AM_SyoruiZokusei, String> syoruinmryaku = new ExDBFieldString<>("syoruinmryaku", this);

    public final ExDBFieldString<AM_SyoruiZokusei, String> tyouhyouid = new ExDBFieldString<>("tyouhyouid", this);

    public final ExDBFieldNumber<AM_SyoruiZokusei, Integer> hozonKikan = new ExDBFieldNumber<>("hozonKikan", this);

    public final ExDBFieldString<AM_SyoruiZokusei, C_NengetuKbn> nengetukbn = new ExDBFieldString<>("nengetukbn", this, UserType_C_NengetuKbn.class);

    public final ExDBFieldString<AM_SyoruiZokusei, C_YesNoKbn> angoukaKbn = new ExDBFieldString<>("angoukaKbn", this, UserType_C_YesNoKbn.class);

    public final ExDBFieldString<AM_SyoruiZokusei, C_YesNoKbn> pdfHozonKbn = new ExDBFieldString<>("pdfHozonKbn", this, UserType_C_YesNoKbn.class);

    public final ExDBFieldString<AM_SyoruiZokusei, C_YesNoKbn> zipHozonKbn = new ExDBFieldString<>("zipHozonKbn", this, UserType_C_YesNoKbn.class);

    public final ExDBFieldNumber<AM_SyoruiZokusei, Integer> pageCount = new ExDBFieldNumber<>("pageCount", this);

    public final ExDBFieldNumber<AM_SyoruiZokusei, Integer> sortNo = new ExDBFieldNumber<>("sortNo", this);

    public final ExDBFieldString<AM_SyoruiZokusei, String> kensakuKey1 = new ExDBFieldString<>("kensakuKey1", this);

    public final ExDBFieldString<AM_SyoruiZokusei, String> kensakuKey2 = new ExDBFieldString<>("kensakuKey2", this);

    public final ExDBFieldString<AM_SyoruiZokusei, String> kensakuKey3 = new ExDBFieldString<>("kensakuKey3", this);

    public final ExDBFieldString<AM_SyoruiZokusei, String> kensakuKey4 = new ExDBFieldString<>("kensakuKey4", this);

    public final ExDBFieldString<AM_SyoruiZokusei, String> kensakuKey5 = new ExDBFieldString<>("kensakuKey5", this);
}
