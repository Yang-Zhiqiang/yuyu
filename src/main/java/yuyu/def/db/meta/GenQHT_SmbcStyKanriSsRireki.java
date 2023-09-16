package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.db.entity.HT_SmbcStyKanriSsRireki;

/**
 * ＳＭＢＣ進捗管理作成履歴テーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQHT_SmbcStyKanriSsRireki extends AbstractExDBTable<HT_SmbcStyKanriSsRireki> {

    public GenQHT_SmbcStyKanriSsRireki() {
        this("HT_SmbcStyKanriSsRireki");
    }

    public GenQHT_SmbcStyKanriSsRireki(String pAlias) {
        super("HT_SmbcStyKanriSsRireki", HT_SmbcStyKanriSsRireki.class, pAlias);
    }

    public String HT_SmbcStyKanriSsRireki() {
        return getAliasExpression();
    }

    public final ExDBFieldString<HT_SmbcStyKanriSsRireki, String> syono = new ExDBFieldString<>("syono", this);

    public final ExDBFieldString<HT_SmbcStyKanriSsRireki, String> mosno = new ExDBFieldString<>("mosno", this);

    public final ExDBFieldString<HT_SmbcStyKanriSsRireki, String> syrctrltblkostime = new ExDBFieldString<>("syrctrltblkostime", this);

    public final ExDBFieldNumber<HT_SmbcStyKanriSsRireki, Integer> renkanryoflg = new ExDBFieldNumber<>("renkanryoflg", this);

    public final ExDBFieldString<HT_SmbcStyKanriSsRireki, String> smbcdatakbn = new ExDBFieldString<>("smbcdatakbn", this);

    public final ExDBFieldString<HT_SmbcStyKanriSsRireki, String> smbcdatasakuseiymd = new ExDBFieldString<>("smbcdatasakuseiymd", this);

    public final ExDBFieldString<HT_SmbcStyKanriSsRireki, String> smbchknkaisyacd = new ExDBFieldString<>("smbchknkaisyacd", this);

    public final ExDBFieldString<HT_SmbcStyKanriSsRireki, String> smbcuktkkanriid = new ExDBFieldString<>("smbcuktkkanriid", this);

    public final ExDBFieldString<HT_SmbcStyKanriSsRireki, String> smbcseihouktkzmymd = new ExDBFieldString<>("smbcseihouktkzmymd", this);

    public final ExDBFieldString<HT_SmbcStyKanriSsRireki, String> smbcseihohbymd = new ExDBFieldString<>("smbcseihohbymd", this);

    public final ExDBFieldString<HT_SmbcStyKanriSsRireki, String> smbcbankhnkykflg = new ExDBFieldString<>("smbcbankhnkykflg", this);

    public final ExDBFieldString<HT_SmbcStyKanriSsRireki, String> smbcseihohbksyymd = new ExDBFieldString<>("smbcseihohbksyymd", this);

    public final ExDBFieldString<HT_SmbcStyKanriSsRireki, String> smbcseihohjyttykymd = new ExDBFieldString<>("smbcseihohjyttykymd", this);

    public final ExDBFieldString<HT_SmbcStyKanriSsRireki, String> smbcseihonyknzmymd = new ExDBFieldString<>("smbcseihonyknzmymd", this);

    public final ExDBFieldString<HT_SmbcStyKanriSsRireki, String> smbcseihosnszmymd = new ExDBFieldString<>("smbcseihosnszmymd", this);

    public final ExDBFieldString<HT_SmbcStyKanriSsRireki, String> smbcseihosyknhkkzmymd = new ExDBFieldString<>("smbcseihosyknhkkzmymd", this);

    public final ExDBFieldString<HT_SmbcStyKanriSsRireki, String> smbcseihosyumoku = new ExDBFieldString<>("smbcseihosyumoku", this);

    public final ExDBFieldString<HT_SmbcStyKanriSsRireki, String> smbcseihosyurui = new ExDBFieldString<>("smbcseihosyurui", this);

    public final ExDBFieldString<HT_SmbcStyKanriSsRireki, String> smbcsyono = new ExDBFieldString<>("smbcsyono", this);

    public final ExDBFieldString<HT_SmbcStyKanriSsRireki, String> smbcsyonoedaban = new ExDBFieldString<>("smbcsyonoedaban", this);

    public final ExDBFieldString<HT_SmbcStyKanriSsRireki, String> smbcjktkflg = new ExDBFieldString<>("smbcjktkflg", this);

    public final ExDBFieldString<HT_SmbcStyKanriSsRireki, String> smbcseihotrksymd = new ExDBFieldString<>("smbcseihotrksymd", this);

    public final ExDBFieldString<HT_SmbcStyKanriSsRireki, String> smbcseihohktymd = new ExDBFieldString<>("smbcseihohktymd", this);

    public final ExDBFieldString<HT_SmbcStyKanriSsRireki, String> smbckykseiymd = new ExDBFieldString<>("smbckykseiymd", this);

    public final ExDBFieldString<HT_SmbcStyKanriSsRireki, String> smbckyknmkn = new ExDBFieldString<>("smbckyknmkn", this);

    public final ExDBFieldString<HT_SmbcStyKanriSsRireki, String> smbcmosuktymd = new ExDBFieldString<>("smbcmosuktymd", this);

    public final ExDBFieldString<HT_SmbcStyKanriSsRireki, String> smbcmossyoriflg = new ExDBFieldString<>("smbcmossyoriflg", this);

    public final ExDBFieldString<HT_SmbcStyKanriSsRireki, String> smbckosyaareastyknr = new ExDBFieldString<>("smbckosyaareastyknr", this);

    public final ExDBFieldString<HT_SmbcStyKanriSsRireki, String> gyoumuKousinKinou = new ExDBFieldString<>("gyoumuKousinKinou", this);

    public final ExDBFieldString<HT_SmbcStyKanriSsRireki, String> gyoumuKousinsyaId = new ExDBFieldString<>("gyoumuKousinsyaId", this);

    public final ExDBFieldString<HT_SmbcStyKanriSsRireki, String> gyoumuKousinTime = new ExDBFieldString<>("gyoumuKousinTime", this);
}
