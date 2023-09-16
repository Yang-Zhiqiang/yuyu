package yuyu.def.db.meta;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.classification.C_BlnktkumuKbn;
import yuyu.def.classification.C_DecKbn;
import yuyu.def.classification.C_Huho2kyknoKbn;
import yuyu.def.classification.C_KankeisyaKbn;
import yuyu.def.classification.C_Ketkekkacd;
import yuyu.def.classification.C_Ketriyuucd;
import yuyu.def.classification.C_MrRiyuucdKbn;
import yuyu.def.classification.C_Seibetu;
import yuyu.def.classification.C_SeirituKbn;
import yuyu.def.classification.C_SntkInfoKykTorikesiKbn;
import yuyu.def.classification.C_Syorizumiflg;
import yuyu.def.classification.C_SyoubyoujyoutaiKbn;
import yuyu.def.db.entity.IT_BAK_KhSntkInfoTouroku;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateYMType;
import yuyu.def.db.type.UserType_C_BlnktkumuKbn;
import yuyu.def.db.type.UserType_C_DecKbn;
import yuyu.def.db.type.UserType_C_Huho2kyknoKbn;
import yuyu.def.db.type.UserType_C_KankeisyaKbn;
import yuyu.def.db.type.UserType_C_Ketkekkacd;
import yuyu.def.db.type.UserType_C_Ketriyuucd;
import yuyu.def.db.type.UserType_C_MrRiyuucdKbn;
import yuyu.def.db.type.UserType_C_Seibetu;
import yuyu.def.db.type.UserType_C_SeirituKbn;
import yuyu.def.db.type.UserType_C_SntkInfoKykTorikesiKbn;
import yuyu.def.db.type.UserType_C_Syorizumiflg;
import yuyu.def.db.type.UserType_C_SyoubyoujyoutaiKbn;

/**
 * 契約保全選択情報登録バックアップテーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQIT_BAK_KhSntkInfoTouroku extends AbstractExDBTable<IT_BAK_KhSntkInfoTouroku> {

    public GenQIT_BAK_KhSntkInfoTouroku() {
        this("IT_BAK_KhSntkInfoTouroku");
    }

    public GenQIT_BAK_KhSntkInfoTouroku(String pAlias) {
        super("IT_BAK_KhSntkInfoTouroku", IT_BAK_KhSntkInfoTouroku.class, pAlias);
    }

    public String IT_BAK_KhSntkInfoTouroku() {
        return getAliasExpression();
    }

    public final ExDBFieldString<IT_BAK_KhSntkInfoTouroku, String> syono = new ExDBFieldString<>("syono", this);

    public final ExDBFieldString<IT_BAK_KhSntkInfoTouroku, String> trkssikibetukey = new ExDBFieldString<>("trkssikibetukey", this);

    public final ExDBFieldNumber<IT_BAK_KhSntkInfoTouroku, Integer> renno = new ExDBFieldNumber<>("renno", this);

    public final ExDBFieldString<IT_BAK_KhSntkInfoTouroku, BizDate> syoriYmd = new ExDBFieldString<>("syoriYmd", this, BizDateType.class);

    public final ExDBFieldString<IT_BAK_KhSntkInfoTouroku, String> huho2kykno = new ExDBFieldString<>("huho2kykno", this);

    public final ExDBFieldString<IT_BAK_KhSntkInfoTouroku, C_Huho2kyknoKbn> huho2kyknokbn = new ExDBFieldString<>("huho2kyknokbn", this, UserType_C_Huho2kyknoKbn.class);

    public final ExDBFieldString<IT_BAK_KhSntkInfoTouroku, String> syouhncd = new ExDBFieldString<>("syouhncd", this);

    public final ExDBFieldString<IT_BAK_KhSntkInfoTouroku, C_KankeisyaKbn> sntkinfokankeisyakbn = new ExDBFieldString<>("sntkinfokankeisyakbn", this, UserType_C_KankeisyaKbn.class);

    public final ExDBFieldString<IT_BAK_KhSntkInfoTouroku, String> taisyounmkn = new ExDBFieldString<>("taisyounmkn", this);

    public final ExDBFieldString<IT_BAK_KhSntkInfoTouroku, String> taisyounmkj = new ExDBFieldString<>("taisyounmkj", this);

    public final ExDBFieldString<IT_BAK_KhSntkInfoTouroku, BizDate> taisyouseiymd = new ExDBFieldString<>("taisyouseiymd", this, BizDateType.class);

    public final ExDBFieldString<IT_BAK_KhSntkInfoTouroku, C_Seibetu> taisyouseibetu = new ExDBFieldString<>("taisyouseibetu", this, UserType_C_Seibetu.class);

    public final ExDBFieldString<IT_BAK_KhSntkInfoTouroku, C_BlnktkumuKbn> dakuhiketnaiyouumukbn = new ExDBFieldString<>("dakuhiketnaiyouumukbn", this, UserType_C_BlnktkumuKbn.class);

    public final ExDBFieldString<IT_BAK_KhSntkInfoTouroku, C_BlnktkumuKbn> kktnaiyouumukbn = new ExDBFieldString<>("kktnaiyouumukbn", this, UserType_C_BlnktkumuKbn.class);

    public final ExDBFieldString<IT_BAK_KhSntkInfoTouroku, C_BlnktkumuKbn> kijinaiyouumukbn = new ExDBFieldString<>("kijinaiyouumukbn", this, UserType_C_BlnktkumuKbn.class);

    public final ExDBFieldString<IT_BAK_KhSntkInfoTouroku, C_BlnktkumuKbn> mrumukbn = new ExDBFieldString<>("mrumukbn", this, UserType_C_BlnktkumuKbn.class);

    public final ExDBFieldString<IT_BAK_KhSntkInfoTouroku, C_BlnktkumuKbn> koudosyougaiumukbn = new ExDBFieldString<>("koudosyougaiumukbn", this, UserType_C_BlnktkumuKbn.class);

    public final ExDBFieldString<IT_BAK_KhSntkInfoTouroku, C_BlnktkumuKbn> torikaijoumukbn = new ExDBFieldString<>("torikaijoumukbn", this, UserType_C_BlnktkumuKbn.class);

    public final ExDBFieldString<IT_BAK_KhSntkInfoTouroku, C_SeirituKbn> seiritukbn = new ExDBFieldString<>("seiritukbn", this, UserType_C_SeirituKbn.class);

    public final ExDBFieldString<IT_BAK_KhSntkInfoTouroku, C_DecKbn> deckbn = new ExDBFieldString<>("deckbn", this, UserType_C_DecKbn.class);

    public final ExDBFieldString<IT_BAK_KhSntkInfoTouroku, BizDate> ketymd = new ExDBFieldString<>("ketymd", this, BizDateType.class);

    public final ExDBFieldString<IT_BAK_KhSntkInfoTouroku, C_Ketkekkacd> ketkekkacd = new ExDBFieldString<>("ketkekkacd", this, UserType_C_Ketkekkacd.class);

    public final ExDBFieldString<IT_BAK_KhSntkInfoTouroku, C_Ketriyuucd> ketriyuucd1 = new ExDBFieldString<>("ketriyuucd1", this, UserType_C_Ketriyuucd.class);

    public final ExDBFieldString<IT_BAK_KhSntkInfoTouroku, C_Ketriyuucd> ketriyuucd2 = new ExDBFieldString<>("ketriyuucd2", this, UserType_C_Ketriyuucd.class);

    public final ExDBFieldString<IT_BAK_KhSntkInfoTouroku, C_Ketriyuucd> ketriyuucd3 = new ExDBFieldString<>("ketriyuucd3", this, UserType_C_Ketriyuucd.class);

    public final ExDBFieldString<IT_BAK_KhSntkInfoTouroku, C_Ketriyuucd> ketriyuucd4 = new ExDBFieldString<>("ketriyuucd4", this, UserType_C_Ketriyuucd.class);

    public final ExDBFieldString<IT_BAK_KhSntkInfoTouroku, String> ketsyacd = new ExDBFieldString<>("ketsyacd", this);

    public final ExDBFieldString<IT_BAK_KhSntkInfoTouroku, String> palketsyacd = new ExDBFieldString<>("palketsyacd", this);

    public final ExDBFieldNumber<IT_BAK_KhSntkInfoTouroku, Integer> sintyou = new ExDBFieldNumber<>("sintyou", this);

    public final ExDBFieldNumber<IT_BAK_KhSntkInfoTouroku, Integer> taijyuu = new ExDBFieldNumber<>("taijyuu", this);

    public final ExDBFieldString<IT_BAK_KhSntkInfoTouroku, BizDate> kktymd = new ExDBFieldString<>("kktymd", this, BizDateType.class);

    public final ExDBFieldString<IT_BAK_KhSntkInfoTouroku, String> syoubyoucd1 = new ExDBFieldString<>("syoubyoucd1", this);

    public final ExDBFieldString<IT_BAK_KhSntkInfoTouroku, C_SyoubyoujyoutaiKbn> syoubyoujyoutaikbn1 = new ExDBFieldString<>("syoubyoujyoutaikbn1", this, UserType_C_SyoubyoujyoutaiKbn.class);

    public final ExDBFieldString<IT_BAK_KhSntkInfoTouroku, BizDateYM> kantiym1 = new ExDBFieldString<>("kantiym1", this, BizDateYMType.class);

    public final ExDBFieldString<IT_BAK_KhSntkInfoTouroku, String> syoubyoucd2 = new ExDBFieldString<>("syoubyoucd2", this);

    public final ExDBFieldString<IT_BAK_KhSntkInfoTouroku, C_SyoubyoujyoutaiKbn> syoubyoujyoutaikbn2 = new ExDBFieldString<>("syoubyoujyoutaikbn2", this, UserType_C_SyoubyoujyoutaiKbn.class);

    public final ExDBFieldString<IT_BAK_KhSntkInfoTouroku, BizDateYM> kantiym2 = new ExDBFieldString<>("kantiym2", this, BizDateYMType.class);

    public final ExDBFieldString<IT_BAK_KhSntkInfoTouroku, C_MrRiyuucdKbn> mrriyuucdkbn = new ExDBFieldString<>("mrriyuucdkbn", this, UserType_C_MrRiyuucdKbn.class);

    public final ExDBFieldString<IT_BAK_KhSntkInfoTouroku, C_SntkInfoKykTorikesiKbn> sntkinfokyktorikesikbn = new ExDBFieldString<>("sntkinfokyktorikesikbn", this, UserType_C_SntkInfoKykTorikesiKbn.class);

    public final ExDBFieldString<IT_BAK_KhSntkInfoTouroku, C_Syorizumiflg> syorizumiflg = new ExDBFieldString<>("syorizumiflg", this, UserType_C_Syorizumiflg.class);

    public final ExDBFieldString<IT_BAK_KhSntkInfoTouroku, String> gyoumuKousinKinou = new ExDBFieldString<>("gyoumuKousinKinou", this);

    public final ExDBFieldString<IT_BAK_KhSntkInfoTouroku, String> gyoumuKousinsyaId = new ExDBFieldString<>("gyoumuKousinsyaId", this);

    public final ExDBFieldString<IT_BAK_KhSntkInfoTouroku, String> gyoumuKousinTime = new ExDBFieldString<>("gyoumuKousinTime", this);
}
