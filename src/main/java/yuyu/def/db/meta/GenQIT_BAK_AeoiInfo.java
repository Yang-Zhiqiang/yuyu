package yuyu.def.db.meta;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.classification.C_AeoiHoujinSyuruiKbn;
import yuyu.def.classification.C_AeoiKekkaKbn;
import yuyu.def.classification.C_AeoiSyoriKbn;
import yuyu.def.classification.C_AeoiTaisyousyaKbn;
import yuyu.def.db.entity.IT_BAK_AeoiInfo;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import yuyu.def.db.type.UserType_C_AeoiHoujinSyuruiKbn;
import yuyu.def.db.type.UserType_C_AeoiKekkaKbn;
import yuyu.def.db.type.UserType_C_AeoiSyoriKbn;
import yuyu.def.db.type.UserType_C_AeoiTaisyousyaKbn;

/**
 * ＡＥＯＩ情報バックアップテーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQIT_BAK_AeoiInfo extends AbstractExDBTable<IT_BAK_AeoiInfo> {

    public GenQIT_BAK_AeoiInfo() {
        this("IT_BAK_AeoiInfo");
    }

    public GenQIT_BAK_AeoiInfo(String pAlias) {
        super("IT_BAK_AeoiInfo", IT_BAK_AeoiInfo.class, pAlias);
    }

    public String IT_BAK_AeoiInfo() {
        return getAliasExpression();
    }

    public final ExDBFieldString<IT_BAK_AeoiInfo, String> kbnkey = new ExDBFieldString<>("kbnkey", this);

    public final ExDBFieldString<IT_BAK_AeoiInfo, String> syono = new ExDBFieldString<>("syono", this);

    public final ExDBFieldString<IT_BAK_AeoiInfo, String> trkssikibetukey = new ExDBFieldString<>("trkssikibetukey", this);

    public final ExDBFieldNumber<IT_BAK_AeoiInfo, Integer> renno = new ExDBFieldNumber<>("renno", this);

    public final ExDBFieldString<IT_BAK_AeoiInfo, BizDate> aeoisyoriymd = new ExDBFieldString<>("aeoisyoriymd", this, BizDateType.class);

    public final ExDBFieldString<IT_BAK_AeoiInfo, C_AeoiSyoriKbn> aeoisyorikbn = new ExDBFieldString<>("aeoisyorikbn", this, UserType_C_AeoiSyoriKbn.class);

    public final ExDBFieldString<IT_BAK_AeoiInfo, BizDate> aeoikouryokusttymd = new ExDBFieldString<>("aeoikouryokusttymd", this, BizDateType.class);

    public final ExDBFieldString<IT_BAK_AeoiInfo, String> aeoisyorisosikicd = new ExDBFieldString<>("aeoisyorisosikicd", this);

    public final ExDBFieldString<IT_BAK_AeoiInfo, C_AeoiTaisyousyaKbn> aeoitaisyousyakbn = new ExDBFieldString<>("aeoitaisyousyakbn", this, UserType_C_AeoiTaisyousyaKbn.class);

    public final ExDBFieldString<IT_BAK_AeoiInfo, C_AeoiKekkaKbn> aeoikekkakbn = new ExDBFieldString<>("aeoikekkakbn", this, UserType_C_AeoiKekkaKbn.class);

    public final ExDBFieldString<IT_BAK_AeoiInfo, C_AeoiHoujinSyuruiKbn> aeoihoujinsyuruikbn = new ExDBFieldString<>("aeoihoujinsyuruikbn", this, UserType_C_AeoiHoujinSyuruiKbn.class);

    public final ExDBFieldString<IT_BAK_AeoiInfo, BizDate> aeoikouryokuendymd = new ExDBFieldString<>("aeoikouryokuendymd", this, BizDateType.class);

    public final ExDBFieldString<IT_BAK_AeoiInfo, String> gyoumuKousinKinou = new ExDBFieldString<>("gyoumuKousinKinou", this);

    public final ExDBFieldString<IT_BAK_AeoiInfo, String> gyoumuKousinsyaId = new ExDBFieldString<>("gyoumuKousinsyaId", this);

    public final ExDBFieldString<IT_BAK_AeoiInfo, String> gyoumuKousinTime = new ExDBFieldString<>("gyoumuKousinTime", this);
}
