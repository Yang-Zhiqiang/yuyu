package yuyu.def.db.meta;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.classification.C_BlnktkumuKbn;
import yuyu.def.classification.C_Huho2kyknoKbn;
import yuyu.def.classification.C_KankeisyaKbn;
import yuyu.def.classification.C_KdssSiharaiJyoutaiKbn;
import yuyu.def.classification.C_Seibetu;
import yuyu.def.classification.C_Syorizumiflg;
import yuyu.def.db.entity.JT_SiSentakuInfoTouroku;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import yuyu.def.db.type.UserType_C_BlnktkumuKbn;
import yuyu.def.db.type.UserType_C_Huho2kyknoKbn;
import yuyu.def.db.type.UserType_C_KankeisyaKbn;
import yuyu.def.db.type.UserType_C_KdssSiharaiJyoutaiKbn;
import yuyu.def.db.type.UserType_C_Seibetu;
import yuyu.def.db.type.UserType_C_Syorizumiflg;

/**
 * 保険金給付金選択情報登録テーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQJT_SiSentakuInfoTouroku extends AbstractExDBTable<JT_SiSentakuInfoTouroku> {

    public GenQJT_SiSentakuInfoTouroku() {
        this("JT_SiSentakuInfoTouroku");
    }

    public GenQJT_SiSentakuInfoTouroku(String pAlias) {
        super("JT_SiSentakuInfoTouroku", JT_SiSentakuInfoTouroku.class, pAlias);
    }

    public String JT_SiSentakuInfoTouroku() {
        return getAliasExpression();
    }

    public final ExDBFieldString<JT_SiSentakuInfoTouroku, String> syono = new ExDBFieldString<>("syono", this);

    public final ExDBFieldNumber<JT_SiSentakuInfoTouroku, Integer> renno = new ExDBFieldNumber<>("renno", this);

    public final ExDBFieldString<JT_SiSentakuInfoTouroku, BizDate> syoriYmd = new ExDBFieldString<>("syoriYmd", this, BizDateType.class);

    public final ExDBFieldString<JT_SiSentakuInfoTouroku, String> huho2kykno = new ExDBFieldString<>("huho2kykno", this);

    public final ExDBFieldString<JT_SiSentakuInfoTouroku, C_Huho2kyknoKbn> huho2kyknokbn = new ExDBFieldString<>("huho2kyknokbn", this, UserType_C_Huho2kyknoKbn.class);

    public final ExDBFieldString<JT_SiSentakuInfoTouroku, String> syouhncd = new ExDBFieldString<>("syouhncd", this);

    public final ExDBFieldString<JT_SiSentakuInfoTouroku, C_KankeisyaKbn> sntkinfokankeisyakbn = new ExDBFieldString<>("sntkinfokankeisyakbn", this, UserType_C_KankeisyaKbn.class);

    public final ExDBFieldString<JT_SiSentakuInfoTouroku, String> taisyounmkn = new ExDBFieldString<>("taisyounmkn", this);

    public final ExDBFieldString<JT_SiSentakuInfoTouroku, String> taisyounmkj = new ExDBFieldString<>("taisyounmkj", this);

    public final ExDBFieldString<JT_SiSentakuInfoTouroku, BizDate> taisyouseiymd = new ExDBFieldString<>("taisyouseiymd", this, BizDateType.class);

    public final ExDBFieldString<JT_SiSentakuInfoTouroku, C_Seibetu> taisyouseibetu = new ExDBFieldString<>("taisyouseibetu", this, UserType_C_Seibetu.class);

    public final ExDBFieldString<JT_SiSentakuInfoTouroku, C_BlnktkumuKbn> dakuhiketnaiyouumukbn = new ExDBFieldString<>("dakuhiketnaiyouumukbn", this, UserType_C_BlnktkumuKbn.class);

    public final ExDBFieldString<JT_SiSentakuInfoTouroku, C_BlnktkumuKbn> kktnaiyouumukbn = new ExDBFieldString<>("kktnaiyouumukbn", this, UserType_C_BlnktkumuKbn.class);

    public final ExDBFieldString<JT_SiSentakuInfoTouroku, C_BlnktkumuKbn> kijinaiyouumukbn = new ExDBFieldString<>("kijinaiyouumukbn", this, UserType_C_BlnktkumuKbn.class);

    public final ExDBFieldString<JT_SiSentakuInfoTouroku, C_BlnktkumuKbn> mrumukbn = new ExDBFieldString<>("mrumukbn", this, UserType_C_BlnktkumuKbn.class);

    public final ExDBFieldString<JT_SiSentakuInfoTouroku, C_BlnktkumuKbn> koudosyougaiumukbn = new ExDBFieldString<>("koudosyougaiumukbn", this, UserType_C_BlnktkumuKbn.class);

    public final ExDBFieldString<JT_SiSentakuInfoTouroku, C_BlnktkumuKbn> torikaijoumukbn = new ExDBFieldString<>("torikaijoumukbn", this, UserType_C_BlnktkumuKbn.class);

    public final ExDBFieldString<JT_SiSentakuInfoTouroku, C_KdssSiharaiJyoutaiKbn> kdsssiharaijyoutaikbn = new ExDBFieldString<>("kdsssiharaijyoutaikbn", this, UserType_C_KdssSiharaiJyoutaiKbn.class);

    public final ExDBFieldString<JT_SiSentakuInfoTouroku, BizDate> kdsssiharaiymd = new ExDBFieldString<>("kdsssiharaiymd", this, BizDateType.class);

    public final ExDBFieldString<JT_SiSentakuInfoTouroku, BizDate> kdsymd = new ExDBFieldString<>("kdsymd", this, BizDateType.class);

    public final ExDBFieldString<JT_SiSentakuInfoTouroku, String> kdssiharaisosikicd = new ExDBFieldString<>("kdssiharaisosikicd", this);

    public final ExDBFieldString<JT_SiSentakuInfoTouroku, C_Syorizumiflg> syorizumiflg = new ExDBFieldString<>("syorizumiflg", this, UserType_C_Syorizumiflg.class);

    public final ExDBFieldString<JT_SiSentakuInfoTouroku, String> gyoumuKousinKinou = new ExDBFieldString<>("gyoumuKousinKinou", this);

    public final ExDBFieldString<JT_SiSentakuInfoTouroku, String> gyoumuKousinsyaId = new ExDBFieldString<>("gyoumuKousinsyaId", this);

    public final ExDBFieldString<JT_SiSentakuInfoTouroku, String> gyoumuKousinTime = new ExDBFieldString<>("gyoumuKousinTime", this);
}
