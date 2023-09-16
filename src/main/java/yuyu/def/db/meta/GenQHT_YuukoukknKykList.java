package yuyu.def.db.meta;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.classification.C_FstphrkkeiroKbn;
import yuyu.def.classification.C_JimusrhKbn;
import yuyu.def.classification.C_KeikaKbn;
import yuyu.def.classification.C_KetteiKbn;
import yuyu.def.classification.C_SyssrhKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.HT_YuukoukknKykList;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import yuyu.def.db.type.UserType_C_FstphrkkeiroKbn;
import yuyu.def.db.type.UserType_C_JimusrhKbn;
import yuyu.def.db.type.UserType_C_KeikaKbn;
import yuyu.def.db.type.UserType_C_KetteiKbn;
import yuyu.def.db.type.UserType_C_SyssrhKbn;
import yuyu.def.db.type.UserType_C_UmuKbn;

/**
 * 有効期間経過契約リストテーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQHT_YuukoukknKykList extends AbstractExDBTable<HT_YuukoukknKykList> {

    public GenQHT_YuukoukknKykList() {
        this("HT_YuukoukknKykList");
    }

    public GenQHT_YuukoukknKykList(String pAlias) {
        super("HT_YuukoukknKykList", HT_YuukoukknKykList.class, pAlias);
    }

    public String HT_YuukoukknKykList() {
        return getAliasExpression();
    }

    public final ExDBFieldString<HT_YuukoukknKykList, String> mosno = new ExDBFieldString<>("mosno", this);

    public final ExDBFieldString<HT_YuukoukknKykList, BizDate> tyouhyouymd = new ExDBFieldString<>("tyouhyouymd", this, BizDateType.class);

    public final ExDBFieldString<HT_YuukoukknKykList, String> daimosno = new ExDBFieldString<>("daimosno", this);

    public final ExDBFieldString<HT_YuukoukknKykList, String> hhknnmkj = new ExDBFieldString<>("hhknnmkj", this);

    public final ExDBFieldString<HT_YuukoukknKykList, String> kyknmkj = new ExDBFieldString<>("kyknmkj", this);

    public final ExDBFieldString<HT_YuukoukknKykList, String> syusyouhncd = new ExDBFieldString<>("syusyouhncd", this);

    public final ExDBFieldString<HT_YuukoukknKykList, String> syusyouhnnm = new ExDBFieldString<>("syusyouhnnm", this);

    public final ExDBFieldString<HT_YuukoukknKykList, String> dntcd = new ExDBFieldString<>("dntcd", this);

    public final ExDBFieldString<HT_YuukoukknKykList, String> dntnm = new ExDBFieldString<>("dntnm", this);

    public final ExDBFieldString<HT_YuukoukknKykList, BizDate> mosymd = new ExDBFieldString<>("mosymd", this, BizDateType.class);

    public final ExDBFieldString<HT_YuukoukknKykList, BizDate> ssyukeymd = new ExDBFieldString<>("ssyukeymd", this, BizDateType.class);

    public final ExDBFieldString<HT_YuukoukknKykList, BizDate> kktkktymd = new ExDBFieldString<>("kktkktymd", this, BizDateType.class);

    public final ExDBFieldString<HT_YuukoukknKykList, BizDate> hjkktymd = new ExDBFieldString<>("hjkktymd", this, BizDateType.class);

    public final ExDBFieldString<HT_YuukoukknKykList, C_UmuKbn> kthhbkbn = new ExDBFieldString<>("kthhbkbn", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<HT_YuukoukknKykList, C_UmuKbn> srhhbkbn = new ExDBFieldString<>("srhhbkbn", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<HT_YuukoukknKykList, C_JimusrhKbn> jimusrhkbn = new ExDBFieldString<>("jimusrhkbn", this, UserType_C_JimusrhKbn.class);

    public final ExDBFieldString<HT_YuukoukknKykList, C_SyssrhKbn> syssrhkbn = new ExDBFieldString<>("syssrhkbn", this, UserType_C_SyssrhKbn.class);

    public final ExDBFieldString<HT_YuukoukknKykList, C_UmuKbn> khnhbkbn = new ExDBFieldString<>("khnhbkbn", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<HT_YuukoukknKykList, C_KetteiKbn> ketteikbn = new ExDBFieldString<>("ketteikbn", this, UserType_C_KetteiKbn.class);

    public final ExDBFieldString<HT_YuukoukknKykList, String> rfstphrkkeiro = new ExDBFieldString<>("rfstphrkkeiro", this);

    public final ExDBFieldString<HT_YuukoukknKykList, C_FstphrkkeiroKbn> fstphrkkeirokbn = new ExDBFieldString<>("fstphrkkeirokbn", this, UserType_C_FstphrkkeiroKbn.class);

    public final ExDBFieldString<HT_YuukoukknKykList, C_KeikaKbn> keikakbn = new ExDBFieldString<>("keikakbn", this, UserType_C_KeikaKbn.class);

    public final ExDBFieldString<HT_YuukoukknKykList, BizDate> fstnyknrsymd = new ExDBFieldString<>("fstnyknrsymd", this, BizDateType.class);

    public final ExDBFieldString<HT_YuukoukknKykList, String> gyoumuKousinsyaId = new ExDBFieldString<>("gyoumuKousinsyaId", this);

    public final ExDBFieldString<HT_YuukoukknKykList, String> gyoumuKousinTime = new ExDBFieldString<>("gyoumuKousinTime", this);
}
