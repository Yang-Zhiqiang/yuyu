package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.classification.C_AngoukaHousikiKbn;
import yuyu.def.classification.C_KouteiSeigyoUmuKbn;
import yuyu.def.classification.C_YesNoKbn;
import yuyu.def.db.entity.WM_TorikomiSyorui;
import yuyu.def.db.type.UserType_C_AngoukaHousikiKbn;
import yuyu.def.db.type.UserType_C_KouteiSeigyoUmuKbn;
import yuyu.def.db.type.UserType_C_YesNoKbn;

/**
 * 取込書類マスタ のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQWM_TorikomiSyorui extends AbstractExDBTable<WM_TorikomiSyorui> {

    public GenQWM_TorikomiSyorui() {
        this("WM_TorikomiSyorui");
    }

    public GenQWM_TorikomiSyorui(String pAlias) {
        super("WM_TorikomiSyorui", WM_TorikomiSyorui.class, pAlias);
    }

    public String WM_TorikomiSyorui() {
        return getAliasExpression();
    }

    public final ExDBFieldString<WM_TorikomiSyorui, String> torikomiSyoruiCd = new ExDBFieldString<>("torikomiSyoruiCd", this);

    public final ExDBFieldString<WM_TorikomiSyorui, String> torikomiSyoruiNm = new ExDBFieldString<>("torikomiSyoruiNm", this);

    public final ExDBFieldString<WM_TorikomiSyorui, String> torikomiSyoruiRyaku = new ExDBFieldString<>("torikomiSyoruiRyaku", this);

    public final ExDBFieldString<WM_TorikomiSyorui, String> syzkDaiBunruiId = new ExDBFieldString<>("syzkDaiBunruiId", this);

    public final ExDBFieldString<WM_TorikomiSyorui, String> syzkSyouBunruiId = new ExDBFieldString<>("syzkSyouBunruiId", this);

    public final ExDBFieldString<WM_TorikomiSyorui, C_YesNoKbn> angoukaKbn = new ExDBFieldString<>("angoukaKbn", this, UserType_C_YesNoKbn.class);

    public final ExDBFieldString<WM_TorikomiSyorui, C_AngoukaHousikiKbn> angoukaHousikiKbn = new ExDBFieldString<>("angoukaHousikiKbn", this, UserType_C_AngoukaHousikiKbn.class);

    public final ExDBFieldString<WM_TorikomiSyorui, C_YesNoKbn> zipHozonKbn = new ExDBFieldString<>("zipHozonKbn", this, UserType_C_YesNoKbn.class);

    public final ExDBFieldString<WM_TorikomiSyorui, C_KouteiSeigyoUmuKbn> kouteiSeigyoUmuKbn = new ExDBFieldString<>("kouteiSeigyoUmuKbn", this, UserType_C_KouteiSeigyoUmuKbn.class);

    public final ExDBFieldString<WM_TorikomiSyorui, String> flowId = new ExDBFieldString<>("flowId", this);

    public final ExDBFieldString<WM_TorikomiSyorui, String> nodeId = new ExDBFieldString<>("nodeId", this);
}
