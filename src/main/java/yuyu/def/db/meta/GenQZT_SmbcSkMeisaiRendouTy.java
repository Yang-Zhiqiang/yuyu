package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.db.entity.ZT_SmbcSkMeisaiRendouTy;

/**
 * ＳＭＢＣ扱新契約明細連動テーブル（中） のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQZT_SmbcSkMeisaiRendouTy extends AbstractExDBTable<ZT_SmbcSkMeisaiRendouTy> {

    public GenQZT_SmbcSkMeisaiRendouTy() {
        this("ZT_SmbcSkMeisaiRendouTy");
    }

    public GenQZT_SmbcSkMeisaiRendouTy(String pAlias) {
        super("ZT_SmbcSkMeisaiRendouTy", ZT_SmbcSkMeisaiRendouTy.class, pAlias);
    }

    public String ZT_SmbcSkMeisaiRendouTy() {
        return getAliasExpression();
    }

    public final ExDBFieldString<ZT_SmbcSkMeisaiRendouTy, String> ztysmbcdatakbn = new ExDBFieldString<>("ztysmbcdatakbn", this);

    public final ExDBFieldString<ZT_SmbcSkMeisaiRendouTy, String> ztysmbcdatasakuseiymd = new ExDBFieldString<>("ztysmbcdatasakuseiymd", this);

    public final ExDBFieldString<ZT_SmbcSkMeisaiRendouTy, String> ztysmbchknkaisyacd = new ExDBFieldString<>("ztysmbchknkaisyacd", this);

    public final ExDBFieldString<ZT_SmbcSkMeisaiRendouTy, String> ztysmbcuktkkanriid = new ExDBFieldString<>("ztysmbcuktkkanriid", this);

    public final ExDBFieldString<ZT_SmbcSkMeisaiRendouTy, String> ztysmbcseihouktkzmymd = new ExDBFieldString<>("ztysmbcseihouktkzmymd", this);

    public final ExDBFieldString<ZT_SmbcSkMeisaiRendouTy, String> ztysmbcseihohbymd = new ExDBFieldString<>("ztysmbcseihohbymd", this);

    public final ExDBFieldString<ZT_SmbcSkMeisaiRendouTy, String> ztysmbcbankhnkykflg = new ExDBFieldString<>("ztysmbcbankhnkykflg", this);

    public final ExDBFieldString<ZT_SmbcSkMeisaiRendouTy, String> ztysmbcseihohbksyymd = new ExDBFieldString<>("ztysmbcseihohbksyymd", this);

    public final ExDBFieldString<ZT_SmbcSkMeisaiRendouTy, String> ztysmbcseihohjyttykymd = new ExDBFieldString<>("ztysmbcseihohjyttykymd", this);

    public final ExDBFieldString<ZT_SmbcSkMeisaiRendouTy, String> ztysmbcseihonyknzmymd = new ExDBFieldString<>("ztysmbcseihonyknzmymd", this);

    public final ExDBFieldString<ZT_SmbcSkMeisaiRendouTy, String> ztysmbcseihosnszmymd = new ExDBFieldString<>("ztysmbcseihosnszmymd", this);

    public final ExDBFieldString<ZT_SmbcSkMeisaiRendouTy, String> ztysmbcseihosyknhkkzmymd = new ExDBFieldString<>("ztysmbcseihosyknhkkzmymd", this);

    public final ExDBFieldString<ZT_SmbcSkMeisaiRendouTy, String> ztysmbcseihosyumoku = new ExDBFieldString<>("ztysmbcseihosyumoku", this);

    public final ExDBFieldString<ZT_SmbcSkMeisaiRendouTy, String> ztysmbcseihosyurui = new ExDBFieldString<>("ztysmbcseihosyurui", this);

    public final ExDBFieldString<ZT_SmbcSkMeisaiRendouTy, String> ztysmbcsyono = new ExDBFieldString<>("ztysmbcsyono", this);

    public final ExDBFieldString<ZT_SmbcSkMeisaiRendouTy, String> ztysmbcsyonoedaban = new ExDBFieldString<>("ztysmbcsyonoedaban", this);

    public final ExDBFieldString<ZT_SmbcSkMeisaiRendouTy, String> ztysmbcjktkflg = new ExDBFieldString<>("ztysmbcjktkflg", this);

    public final ExDBFieldString<ZT_SmbcSkMeisaiRendouTy, String> ztysmbcseihotrksymd = new ExDBFieldString<>("ztysmbcseihotrksymd", this);

    public final ExDBFieldString<ZT_SmbcSkMeisaiRendouTy, String> ztysmbcseihohktymd = new ExDBFieldString<>("ztysmbcseihohktymd", this);

    public final ExDBFieldString<ZT_SmbcSkMeisaiRendouTy, String> ztysmbckykseiymd = new ExDBFieldString<>("ztysmbckykseiymd", this);

    public final ExDBFieldString<ZT_SmbcSkMeisaiRendouTy, String> ztysmbckyknmkn = new ExDBFieldString<>("ztysmbckyknmkn", this);

    public final ExDBFieldString<ZT_SmbcSkMeisaiRendouTy, String> ztysmbcmosuktymd = new ExDBFieldString<>("ztysmbcmosuktymd", this);

    public final ExDBFieldString<ZT_SmbcSkMeisaiRendouTy, String> ztysmbcmossyoriflg = new ExDBFieldString<>("ztysmbcmossyoriflg", this);

    public final ExDBFieldString<ZT_SmbcSkMeisaiRendouTy, String> ztysmbckosyaareastyknr = new ExDBFieldString<>("ztysmbckosyaareastyknr", this);

    public final ExDBFieldString<ZT_SmbcSkMeisaiRendouTy, String> ztyyobiv60 = new ExDBFieldString<>("ztyyobiv60", this);
}
