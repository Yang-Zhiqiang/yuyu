package yuyu.def.db.meta;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.classification.C_HonninKakninKekkaKbn;
import yuyu.def.classification.C_InputShrhousiteiKbn;
import yuyu.def.classification.C_KyktrksKbn;
import yuyu.def.classification.C_Kzdou;
import yuyu.def.classification.C_SinsaGendoKknKbn;
import yuyu.def.classification.C_SoukinsakiKbn;
import yuyu.def.classification.C_SoukinsakisiteiKbn;
import yuyu.def.classification.C_SyorikekkaKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_YokinKbn;
import yuyu.def.db.entity.IW_KhKeiyakuTorikesiWk;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import yuyu.def.db.type.UserType_C_HonninKakninKekkaKbn;
import yuyu.def.db.type.UserType_C_InputShrhousiteiKbn;
import yuyu.def.db.type.UserType_C_KyktrksKbn;
import yuyu.def.db.type.UserType_C_Kzdou;
import yuyu.def.db.type.UserType_C_SinsaGendoKknKbn;
import yuyu.def.db.type.UserType_C_SoukinsakiKbn;
import yuyu.def.db.type.UserType_C_SoukinsakisiteiKbn;
import yuyu.def.db.type.UserType_C_SyorikekkaKbn;
import yuyu.def.db.type.UserType_C_UmuKbn;
import yuyu.def.db.type.UserType_C_YokinKbn;

/**
 * 契約取消ワークテーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQIW_KhKeiyakuTorikesiWk extends AbstractExDBTable<IW_KhKeiyakuTorikesiWk> {

    public GenQIW_KhKeiyakuTorikesiWk() {
        this("IW_KhKeiyakuTorikesiWk");
    }

    public GenQIW_KhKeiyakuTorikesiWk(String pAlias) {
        super("IW_KhKeiyakuTorikesiWk", IW_KhKeiyakuTorikesiWk.class, pAlias);
    }

    public String IW_KhKeiyakuTorikesiWk() {
        return getAliasExpression();
    }

    public final ExDBFieldString<IW_KhKeiyakuTorikesiWk, String> kouteikanriid = new ExDBFieldString<>("kouteikanriid", this);

    public final ExDBFieldString<IW_KhKeiyakuTorikesiWk, String> syono = new ExDBFieldString<>("syono", this);

    public final ExDBFieldString<IW_KhKeiyakuTorikesiWk, C_KyktrksKbn> kyktrkskbn = new ExDBFieldString<>("kyktrkskbn", this, UserType_C_KyktrksKbn.class);

    public final ExDBFieldString<IW_KhKeiyakuTorikesiWk, BizDate> sibouymd = new ExDBFieldString<>("sibouymd", this, BizDateType.class);

    public final ExDBFieldString<IW_KhKeiyakuTorikesiWk, BizDate> kaijyokessaiymd = new ExDBFieldString<>("kaijyokessaiymd", this, BizDateType.class);

    public final ExDBFieldString<IW_KhKeiyakuTorikesiWk, BizDate> kaijyotuutiymd = new ExDBFieldString<>("kaijyotuutiymd", this, BizDateType.class);

    public final ExDBFieldString<IW_KhKeiyakuTorikesiWk, BizDate> syoruiukeymd = new ExDBFieldString<>("syoruiukeymd", this, BizDateType.class);

    public final ExDBFieldString<IW_KhKeiyakuTorikesiWk, BizDate> hubikanryouymd = new ExDBFieldString<>("hubikanryouymd", this, BizDateType.class);

    public final ExDBFieldString<IW_KhKeiyakuTorikesiWk, C_SinsaGendoKknKbn> sinsagendokknkbn = new ExDBFieldString<>("sinsagendokknkbn", this, UserType_C_SinsaGendoKknKbn.class);

    public final ExDBFieldNumber<IW_KhKeiyakuTorikesiWk, Integer> rikoukityuutuudannissuu = new ExDBFieldNumber<>("rikoukityuutuudannissuu", this);

    public final ExDBFieldString<IW_KhKeiyakuTorikesiWk, C_SoukinsakisiteiKbn> soukinsakisiteikbn = new ExDBFieldString<>("soukinsakisiteikbn", this, UserType_C_SoukinsakisiteiKbn.class);

    public final ExDBFieldString<IW_KhKeiyakuTorikesiWk, String> soukinsakinmkn = new ExDBFieldString<>("soukinsakinmkn", this);

    public final ExDBFieldString<IW_KhKeiyakuTorikesiWk, String> soukinsakinmkj = new ExDBFieldString<>("soukinsakinmkj", this);

    public final ExDBFieldString<IW_KhKeiyakuTorikesiWk, String> soukinsakiyno = new ExDBFieldString<>("soukinsakiyno", this);

    public final ExDBFieldString<IW_KhKeiyakuTorikesiWk, String> soukinsakiadr1kj = new ExDBFieldString<>("soukinsakiadr1kj", this);

    public final ExDBFieldString<IW_KhKeiyakuTorikesiWk, String> soukinsakiadr2kj = new ExDBFieldString<>("soukinsakiadr2kj", this);

    public final ExDBFieldString<IW_KhKeiyakuTorikesiWk, String> soukinsakiadr3kj = new ExDBFieldString<>("soukinsakiadr3kj", this);

    public final ExDBFieldString<IW_KhKeiyakuTorikesiWk, String> kyksyaszknmkn = new ExDBFieldString<>("kyksyaszknmkn", this);

    public final ExDBFieldString<IW_KhKeiyakuTorikesiWk, String> kyksyaszknmkj = new ExDBFieldString<>("kyksyaszknmkj", this);

    public final ExDBFieldString<IW_KhKeiyakuTorikesiWk, String> kyksyaszkyno = new ExDBFieldString<>("kyksyaszkyno", this);

    public final ExDBFieldString<IW_KhKeiyakuTorikesiWk, String> kyksyaszkadr1kj = new ExDBFieldString<>("kyksyaszkadr1kj", this);

    public final ExDBFieldString<IW_KhKeiyakuTorikesiWk, String> kyksyaszkadr2kj = new ExDBFieldString<>("kyksyaszkadr2kj", this);

    public final ExDBFieldString<IW_KhKeiyakuTorikesiWk, String> kyksyaszkadr3kj = new ExDBFieldString<>("kyksyaszkadr3kj", this);

    public final ExDBFieldString<IW_KhKeiyakuTorikesiWk, C_UmuKbn> yenshrtkumu = new ExDBFieldString<>("yenshrtkumu", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<IW_KhKeiyakuTorikesiWk, C_InputShrhousiteiKbn> inputshrhousiteikbn = new ExDBFieldString<>("inputshrhousiteikbn", this, UserType_C_InputShrhousiteiKbn.class);

    public final ExDBFieldString<IW_KhKeiyakuTorikesiWk, String> bankcd = new ExDBFieldString<>("bankcd", this);

    public final ExDBFieldString<IW_KhKeiyakuTorikesiWk, String> sitencd = new ExDBFieldString<>("sitencd", this);

    public final ExDBFieldString<IW_KhKeiyakuTorikesiWk, C_YokinKbn> yokinkbn = new ExDBFieldString<>("yokinkbn", this, UserType_C_YokinKbn.class);

    public final ExDBFieldString<IW_KhKeiyakuTorikesiWk, String> kouzano = new ExDBFieldString<>("kouzano", this);

    public final ExDBFieldString<IW_KhKeiyakuTorikesiWk, C_Kzdou> kzdoukbn = new ExDBFieldString<>("kzdoukbn", this, UserType_C_Kzdou.class);

    public final ExDBFieldString<IW_KhKeiyakuTorikesiWk, String> kzmeiginmkn = new ExDBFieldString<>("kzmeiginmkn", this);

    public final ExDBFieldString<IW_KhKeiyakuTorikesiWk, String> kykmnmeigibangou = new ExDBFieldString<>("kykmnmeigibangou", this);

    public final ExDBFieldString<IW_KhKeiyakuTorikesiWk, String> uktmnmeigibangou = new ExDBFieldString<>("uktmnmeigibangou", this);

    public final ExDBFieldString<IW_KhKeiyakuTorikesiWk, C_HonninKakninKekkaKbn> honninkakninkekkakbn = new ExDBFieldString<>("honninkakninkekkakbn", this, UserType_C_HonninKakninKekkaKbn.class);

    public final ExDBFieldString<IW_KhKeiyakuTorikesiWk, C_SyorikekkaKbn> zenkaisyorikekkakbn = new ExDBFieldString<>("zenkaisyorikekkakbn", this, UserType_C_SyorikekkaKbn.class);

    public final ExDBFieldString<IW_KhKeiyakuTorikesiWk, String> gyoumuKousinKinou = new ExDBFieldString<>("gyoumuKousinKinou", this);

    public final ExDBFieldString<IW_KhKeiyakuTorikesiWk, String> gyoumuKousinsyaId = new ExDBFieldString<>("gyoumuKousinsyaId", this);

    public final ExDBFieldString<IW_KhKeiyakuTorikesiWk, String> gyoumuKousinTime = new ExDBFieldString<>("gyoumuKousinTime", this);

    public final ExDBFieldString<IW_KhKeiyakuTorikesiWk, C_SoukinsakiKbn> soukinsakikbn = new ExDBFieldString<>("soukinsakikbn", this, UserType_C_SoukinsakiKbn.class);
}
