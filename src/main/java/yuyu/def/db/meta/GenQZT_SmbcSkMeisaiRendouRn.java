package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.db.entity.ZT_SmbcSkMeisaiRendouRn;

/**
 * ＳＭＢＣ扱新契約明細連動テーブル（連） のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQZT_SmbcSkMeisaiRendouRn extends AbstractExDBTable<ZT_SmbcSkMeisaiRendouRn> {

    public GenQZT_SmbcSkMeisaiRendouRn() {
        this("ZT_SmbcSkMeisaiRendouRn");
    }

    public GenQZT_SmbcSkMeisaiRendouRn(String pAlias) {
        super("ZT_SmbcSkMeisaiRendouRn", ZT_SmbcSkMeisaiRendouRn.class, pAlias);
    }

    public String ZT_SmbcSkMeisaiRendouRn() {
        return getAliasExpression();
    }

    public final ExDBFieldString<ZT_SmbcSkMeisaiRendouRn, String> zrnsmbcdatakbn = new ExDBFieldString<>("zrnsmbcdatakbn", this);

    public final ExDBFieldString<ZT_SmbcSkMeisaiRendouRn, String> zrnsmbcdatasakuseiymd = new ExDBFieldString<>("zrnsmbcdatasakuseiymd", this);

    public final ExDBFieldString<ZT_SmbcSkMeisaiRendouRn, String> zrnsmbchknkaisyacd = new ExDBFieldString<>("zrnsmbchknkaisyacd", this);

    public final ExDBFieldString<ZT_SmbcSkMeisaiRendouRn, String> zrnsmbcuktkkanriid = new ExDBFieldString<>("zrnsmbcuktkkanriid", this);

    public final ExDBFieldString<ZT_SmbcSkMeisaiRendouRn, String> zrnsmbcseihouktkzmymd = new ExDBFieldString<>("zrnsmbcseihouktkzmymd", this);

    public final ExDBFieldString<ZT_SmbcSkMeisaiRendouRn, String> zrnsmbcseihohbymd = new ExDBFieldString<>("zrnsmbcseihohbymd", this);

    public final ExDBFieldString<ZT_SmbcSkMeisaiRendouRn, String> zrnsmbcbankhnkykflg = new ExDBFieldString<>("zrnsmbcbankhnkykflg", this);

    public final ExDBFieldString<ZT_SmbcSkMeisaiRendouRn, String> zrnsmbcseihohbksyymd = new ExDBFieldString<>("zrnsmbcseihohbksyymd", this);

    public final ExDBFieldString<ZT_SmbcSkMeisaiRendouRn, String> zrnsmbcseihohjyttykymd = new ExDBFieldString<>("zrnsmbcseihohjyttykymd", this);

    public final ExDBFieldString<ZT_SmbcSkMeisaiRendouRn, String> zrnsmbcseihonyknzmymd = new ExDBFieldString<>("zrnsmbcseihonyknzmymd", this);

    public final ExDBFieldString<ZT_SmbcSkMeisaiRendouRn, String> zrnsmbcseihosnszmymd = new ExDBFieldString<>("zrnsmbcseihosnszmymd", this);

    public final ExDBFieldString<ZT_SmbcSkMeisaiRendouRn, String> zrnsmbcseihosyknhkkzmymd = new ExDBFieldString<>("zrnsmbcseihosyknhkkzmymd", this);

    public final ExDBFieldString<ZT_SmbcSkMeisaiRendouRn, String> zrnsmbcseihosyumoku = new ExDBFieldString<>("zrnsmbcseihosyumoku", this);

    public final ExDBFieldString<ZT_SmbcSkMeisaiRendouRn, String> zrnsmbcseihosyurui = new ExDBFieldString<>("zrnsmbcseihosyurui", this);

    public final ExDBFieldString<ZT_SmbcSkMeisaiRendouRn, String> zrnsmbcsyono = new ExDBFieldString<>("zrnsmbcsyono", this);

    public final ExDBFieldString<ZT_SmbcSkMeisaiRendouRn, String> zrnsmbcsyonoedaban = new ExDBFieldString<>("zrnsmbcsyonoedaban", this);

    public final ExDBFieldString<ZT_SmbcSkMeisaiRendouRn, String> zrnsmbcjktkflg = new ExDBFieldString<>("zrnsmbcjktkflg", this);

    public final ExDBFieldString<ZT_SmbcSkMeisaiRendouRn, String> zrnsmbcseihotrksymd = new ExDBFieldString<>("zrnsmbcseihotrksymd", this);

    public final ExDBFieldString<ZT_SmbcSkMeisaiRendouRn, String> zrnsmbcseihohktymd = new ExDBFieldString<>("zrnsmbcseihohktymd", this);

    public final ExDBFieldString<ZT_SmbcSkMeisaiRendouRn, String> zrnsmbckykseiymd = new ExDBFieldString<>("zrnsmbckykseiymd", this);

    public final ExDBFieldString<ZT_SmbcSkMeisaiRendouRn, String> zrnsmbckyknmkn = new ExDBFieldString<>("zrnsmbckyknmkn", this);

    public final ExDBFieldString<ZT_SmbcSkMeisaiRendouRn, String> zrnsmbcmosuktymd = new ExDBFieldString<>("zrnsmbcmosuktymd", this);

    public final ExDBFieldString<ZT_SmbcSkMeisaiRendouRn, String> zrnsmbcmossyoriflg = new ExDBFieldString<>("zrnsmbcmossyoriflg", this);

    public final ExDBFieldString<ZT_SmbcSkMeisaiRendouRn, String> zrnsmbckosyaareastyknr = new ExDBFieldString<>("zrnsmbckosyaareastyknr", this);

    public final ExDBFieldString<ZT_SmbcSkMeisaiRendouRn, String> zrnyobiv60 = new ExDBFieldString<>("zrnyobiv60", this);
}
