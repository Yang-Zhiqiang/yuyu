package yuyu.def.db.meta;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import jp.co.slcs.swak.number.BizNumber;
import yuyu.def.classification.C_Rendouflg;
import yuyu.def.db.entity.HT_SmbcStyKanri;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import jp.co.slcs.swak.db.hibernate.usertype.BizNumberType;
import yuyu.def.db.type.UserType_C_Rendouflg;

/**
 * ＳＭＢＣ進捗管理テーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQHT_SmbcStyKanri extends AbstractExDBTable<HT_SmbcStyKanri> {

    public GenQHT_SmbcStyKanri() {
        this("HT_SmbcStyKanri");
    }

    public GenQHT_SmbcStyKanri(String pAlias) {
        super("HT_SmbcStyKanri", HT_SmbcStyKanri.class, pAlias);
    }

    public String HT_SmbcStyKanri() {
        return getAliasExpression();
    }

    public final ExDBFieldString<HT_SmbcStyKanri, BizDate> datarenymd = new ExDBFieldString<>("datarenymd", this, BizDateType.class);

    public final ExDBFieldString<HT_SmbcStyKanri, BizNumber> datasakuseirenno = new ExDBFieldString<>("datasakuseirenno", this, BizNumberType.class);

    public final ExDBFieldString<HT_SmbcStyKanri, String> syono = new ExDBFieldString<>("syono", this);

    public final ExDBFieldString<HT_SmbcStyKanri, String> mosno = new ExDBFieldString<>("mosno", this);

    public final ExDBFieldString<HT_SmbcStyKanri, C_Rendouflg> rendouflg = new ExDBFieldString<>("rendouflg", this, UserType_C_Rendouflg.class);

    public final ExDBFieldString<HT_SmbcStyKanri, String> smbcdatakbn = new ExDBFieldString<>("smbcdatakbn", this);

    public final ExDBFieldString<HT_SmbcStyKanri, String> smbcdatasakuseiymd = new ExDBFieldString<>("smbcdatasakuseiymd", this);

    public final ExDBFieldString<HT_SmbcStyKanri, String> smbchknkaisyacd = new ExDBFieldString<>("smbchknkaisyacd", this);

    public final ExDBFieldString<HT_SmbcStyKanri, String> smbcuktkkanriid = new ExDBFieldString<>("smbcuktkkanriid", this);

    public final ExDBFieldString<HT_SmbcStyKanri, String> smbcseihouktkzmymd = new ExDBFieldString<>("smbcseihouktkzmymd", this);

    public final ExDBFieldString<HT_SmbcStyKanri, String> smbcseihohbymd = new ExDBFieldString<>("smbcseihohbymd", this);

    public final ExDBFieldString<HT_SmbcStyKanri, String> smbcbankhnkykflg = new ExDBFieldString<>("smbcbankhnkykflg", this);

    public final ExDBFieldString<HT_SmbcStyKanri, String> smbcseihohbksyymd = new ExDBFieldString<>("smbcseihohbksyymd", this);

    public final ExDBFieldString<HT_SmbcStyKanri, String> smbcseihohjyttykymd = new ExDBFieldString<>("smbcseihohjyttykymd", this);

    public final ExDBFieldString<HT_SmbcStyKanri, String> smbcseihonyknzmymd = new ExDBFieldString<>("smbcseihonyknzmymd", this);

    public final ExDBFieldString<HT_SmbcStyKanri, String> smbcseihosnszmymd = new ExDBFieldString<>("smbcseihosnszmymd", this);

    public final ExDBFieldString<HT_SmbcStyKanri, String> smbcseihosyknhkkzmymd = new ExDBFieldString<>("smbcseihosyknhkkzmymd", this);

    public final ExDBFieldString<HT_SmbcStyKanri, String> smbcseihosyumoku = new ExDBFieldString<>("smbcseihosyumoku", this);

    public final ExDBFieldString<HT_SmbcStyKanri, String> smbcseihosyurui = new ExDBFieldString<>("smbcseihosyurui", this);

    public final ExDBFieldString<HT_SmbcStyKanri, String> smbcsyono = new ExDBFieldString<>("smbcsyono", this);

    public final ExDBFieldString<HT_SmbcStyKanri, String> smbcsyonoedaban = new ExDBFieldString<>("smbcsyonoedaban", this);

    public final ExDBFieldString<HT_SmbcStyKanri, String> smbcjktkflg = new ExDBFieldString<>("smbcjktkflg", this);

    public final ExDBFieldString<HT_SmbcStyKanri, String> smbcseihotrksymd = new ExDBFieldString<>("smbcseihotrksymd", this);

    public final ExDBFieldString<HT_SmbcStyKanri, String> smbcseihohktymd = new ExDBFieldString<>("smbcseihohktymd", this);

    public final ExDBFieldString<HT_SmbcStyKanri, String> smbckykseiymd = new ExDBFieldString<>("smbckykseiymd", this);

    public final ExDBFieldString<HT_SmbcStyKanri, String> smbckyknmkn = new ExDBFieldString<>("smbckyknmkn", this);

    public final ExDBFieldString<HT_SmbcStyKanri, String> smbcmosuktymd = new ExDBFieldString<>("smbcmosuktymd", this);

    public final ExDBFieldString<HT_SmbcStyKanri, String> smbcmossyoriflg = new ExDBFieldString<>("smbcmossyoriflg", this);

    public final ExDBFieldString<HT_SmbcStyKanri, String> smbckosyaareastyknr = new ExDBFieldString<>("smbckosyaareastyknr", this);

    public final ExDBFieldString<HT_SmbcStyKanri, String> gyoumuKousinKinou = new ExDBFieldString<>("gyoumuKousinKinou", this);

    public final ExDBFieldString<HT_SmbcStyKanri, String> gyoumuKousinsyaId = new ExDBFieldString<>("gyoumuKousinsyaId", this);

    public final ExDBFieldString<HT_SmbcStyKanri, String> gyoumuKousinTime = new ExDBFieldString<>("gyoumuKousinTime", this);
}
