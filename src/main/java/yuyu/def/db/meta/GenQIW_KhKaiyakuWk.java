package yuyu.def.db.meta;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.classification.C_HonninKakninKekkaKbn;
import yuyu.def.classification.C_InputShrhousiteiKbn;
import yuyu.def.classification.C_Kaiyakujiyuu;
import yuyu.def.classification.C_KanryotuutioutKbn;
import yuyu.def.classification.C_Kzdou;
import yuyu.def.classification.C_SoukinsakiKbn;
import yuyu.def.classification.C_SyorikekkaKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_YokinKbn;
import yuyu.def.db.entity.IW_KhKaiyakuWk;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import yuyu.def.db.type.UserType_C_HonninKakninKekkaKbn;
import yuyu.def.db.type.UserType_C_InputShrhousiteiKbn;
import yuyu.def.db.type.UserType_C_Kaiyakujiyuu;
import yuyu.def.db.type.UserType_C_KanryotuutioutKbn;
import yuyu.def.db.type.UserType_C_Kzdou;
import yuyu.def.db.type.UserType_C_SoukinsakiKbn;
import yuyu.def.db.type.UserType_C_SyorikekkaKbn;
import yuyu.def.db.type.UserType_C_UmuKbn;
import yuyu.def.db.type.UserType_C_YokinKbn;

/**
 * 解約ワークテーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQIW_KhKaiyakuWk extends AbstractExDBTable<IW_KhKaiyakuWk> {

    public GenQIW_KhKaiyakuWk() {
        this("IW_KhKaiyakuWk");
    }

    public GenQIW_KhKaiyakuWk(String pAlias) {
        super("IW_KhKaiyakuWk", IW_KhKaiyakuWk.class, pAlias);
    }

    public String IW_KhKaiyakuWk() {
        return getAliasExpression();
    }

    public final ExDBFieldString<IW_KhKaiyakuWk, String> kouteikanriid = new ExDBFieldString<>("kouteikanriid", this);

    public final ExDBFieldString<IW_KhKaiyakuWk, String> syono = new ExDBFieldString<>("syono", this);

    public final ExDBFieldString<IW_KhKaiyakuWk, BizDate> skssakuseiymd = new ExDBFieldString<>("skssakuseiymd", this, BizDateType.class);

    public final ExDBFieldString<IW_KhKaiyakuWk, C_Kaiyakujiyuu> kaiyakujiyuu = new ExDBFieldString<>("kaiyakujiyuu", this, UserType_C_Kaiyakujiyuu.class);

    public final ExDBFieldString<IW_KhKaiyakuWk, BizDate> syoruiukeymd = new ExDBFieldString<>("syoruiukeymd", this, BizDateType.class);

    public final ExDBFieldString<IW_KhKaiyakuWk, String> shnmkj = new ExDBFieldString<>("shnmkj", this);

    public final ExDBFieldString<IW_KhKaiyakuWk, String> shskyno = new ExDBFieldString<>("shskyno", this);

    public final ExDBFieldString<IW_KhKaiyakuWk, String> shsadr1kj = new ExDBFieldString<>("shsadr1kj", this);

    public final ExDBFieldString<IW_KhKaiyakuWk, String> shsadr2kj = new ExDBFieldString<>("shsadr2kj", this);

    public final ExDBFieldString<IW_KhKaiyakuWk, String> shsadr3kj = new ExDBFieldString<>("shsadr3kj", this);

    public final ExDBFieldString<IW_KhKaiyakuWk, String> kyksyaszknmkn = new ExDBFieldString<>("kyksyaszknmkn", this);

    public final ExDBFieldString<IW_KhKaiyakuWk, String> kyksyaszknmkj = new ExDBFieldString<>("kyksyaszknmkj", this);

    public final ExDBFieldString<IW_KhKaiyakuWk, String> kyksyaszkyno = new ExDBFieldString<>("kyksyaszkyno", this);

    public final ExDBFieldString<IW_KhKaiyakuWk, String> kyksyaszkadr1kj = new ExDBFieldString<>("kyksyaszkadr1kj", this);

    public final ExDBFieldString<IW_KhKaiyakuWk, String> kyksyaszkadr2kj = new ExDBFieldString<>("kyksyaszkadr2kj", this);

    public final ExDBFieldString<IW_KhKaiyakuWk, String> kyksyaszkadr3kj = new ExDBFieldString<>("kyksyaszkadr3kj", this);

    public final ExDBFieldString<IW_KhKaiyakuWk, String> saikennmkj = new ExDBFieldString<>("saikennmkj", this);

    public final ExDBFieldString<IW_KhKaiyakuWk, String> saikennyno = new ExDBFieldString<>("saikennyno", this);

    public final ExDBFieldString<IW_KhKaiyakuWk, String> saikenadr1kj = new ExDBFieldString<>("saikenadr1kj", this);

    public final ExDBFieldString<IW_KhKaiyakuWk, String> saikenadr2kj = new ExDBFieldString<>("saikenadr2kj", this);

    public final ExDBFieldString<IW_KhKaiyakuWk, String> saikenadr3kj = new ExDBFieldString<>("saikenadr3kj", this);

    public final ExDBFieldString<IW_KhKaiyakuWk, C_UmuKbn> yenshrtkhkumu = new ExDBFieldString<>("yenshrtkhkumu", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<IW_KhKaiyakuWk, C_InputShrhousiteiKbn> inputshrhousiteikbn = new ExDBFieldString<>("inputshrhousiteikbn", this, UserType_C_InputShrhousiteiKbn.class);

    public final ExDBFieldString<IW_KhKaiyakuWk, String> bankcd = new ExDBFieldString<>("bankcd", this);

    public final ExDBFieldString<IW_KhKaiyakuWk, String> sitencd = new ExDBFieldString<>("sitencd", this);

    public final ExDBFieldString<IW_KhKaiyakuWk, C_YokinKbn> yokinkbn = new ExDBFieldString<>("yokinkbn", this, UserType_C_YokinKbn.class);

    public final ExDBFieldString<IW_KhKaiyakuWk, String> kouzano = new ExDBFieldString<>("kouzano", this);

    public final ExDBFieldString<IW_KhKaiyakuWk, C_Kzdou> kzdoukbn = new ExDBFieldString<>("kzdoukbn", this, UserType_C_Kzdou.class);

    public final ExDBFieldString<IW_KhKaiyakuWk, String> kzmeiginmkn = new ExDBFieldString<>("kzmeiginmkn", this);

    public final ExDBFieldString<IW_KhKaiyakuWk, String> kykmnmeigibangou = new ExDBFieldString<>("kykmnmeigibangou", this);

    public final ExDBFieldString<IW_KhKaiyakuWk, C_HonninKakninKekkaKbn> honninkakninkekkakbn = new ExDBFieldString<>("honninkakninkekkakbn", this, UserType_C_HonninKakninKekkaKbn.class);

    public final ExDBFieldString<IW_KhKaiyakuWk, C_KanryotuutioutKbn> kanryotuutioutkbn = new ExDBFieldString<>("kanryotuutioutkbn", this, UserType_C_KanryotuutioutKbn.class);

    public final ExDBFieldString<IW_KhKaiyakuWk, C_SyorikekkaKbn> zenkaisyorikekkakbn = new ExDBFieldString<>("zenkaisyorikekkakbn", this, UserType_C_SyorikekkaKbn.class);

    public final ExDBFieldString<IW_KhKaiyakuWk, String> gyoumuKousinKinou = new ExDBFieldString<>("gyoumuKousinKinou", this);

    public final ExDBFieldString<IW_KhKaiyakuWk, String> gyoumuKousinsyaId = new ExDBFieldString<>("gyoumuKousinsyaId", this);

    public final ExDBFieldString<IW_KhKaiyakuWk, String> gyoumuKousinTime = new ExDBFieldString<>("gyoumuKousinTime", this);

    public final ExDBFieldString<IW_KhKaiyakuWk, String> uktmnmeigibangou = new ExDBFieldString<>("uktmnmeigibangou", this);

    public final ExDBFieldString<IW_KhKaiyakuWk, C_SoukinsakiKbn> soukinsakikbn = new ExDBFieldString<>("soukinsakikbn", this, UserType_C_SoukinsakiKbn.class);
}
