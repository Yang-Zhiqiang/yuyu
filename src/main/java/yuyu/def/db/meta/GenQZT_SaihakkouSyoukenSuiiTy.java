package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.db.entity.ZT_SaihakkouSyoukenSuiiTy;

/**
 * 再発行保険証券推移表Ｆテーブル（中） のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQZT_SaihakkouSyoukenSuiiTy extends AbstractExDBTable<ZT_SaihakkouSyoukenSuiiTy> {

    public GenQZT_SaihakkouSyoukenSuiiTy() {
        this("ZT_SaihakkouSyoukenSuiiTy");
    }

    public GenQZT_SaihakkouSyoukenSuiiTy(String pAlias) {
        super("ZT_SaihakkouSyoukenSuiiTy", ZT_SaihakkouSyoukenSuiiTy.class, pAlias);
    }

    public String ZT_SaihakkouSyoukenSuiiTy() {
        return getAliasExpression();
    }

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztysyono = new ExDBFieldString<>("ztysyono", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztytyouhyouymd = new ExDBFieldString<>("ztytyouhyouymd", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztysuiihyouptn = new ExDBFieldString<>("ztysuiihyouptn", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztysuiihyousykbn = new ExDBFieldString<>("ztysuiihyousykbn", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztysuiihyousyono = new ExDBFieldString<>("ztysuiihyousyono", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztysisuuupritu = new ExDBFieldString<>("ztysisuuupritu", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztysaisyuunndym = new ExDBFieldString<>("ztysaisyuunndym", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztysjkkktusirrtup = new ExDBFieldString<>("ztysjkkktusirrtup", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztysjkkktusirrtsame = new ExDBFieldString<>("ztysjkkktusirrtsame", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztysjkkktusirrtdown = new ExDBFieldString<>("ztysjkkktusirrtdown", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztysjkkktusirrthendouup = new ExDBFieldString<>("ztysjkkktusirrthendouup", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztysjkkktusirrthendoudown = new ExDBFieldString<>("ztysjkkktusirrthendoudown", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztywkwsrateyendaka = new ExDBFieldString<>("ztywkwsrateyendaka", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztywkwsrateyenkijyun = new ExDBFieldString<>("ztywkwsrateyenkijyun", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztywkwsrateyenyasu = new ExDBFieldString<>("ztywkwsrateyenyasu", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztysuiihyoumkhyouyenwra = new ExDBFieldString<>("ztysuiihyoumkhyouyenwra", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaarinenoutouym01 = new ExDBFieldString<>("ztymvaarinenoutouym01", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaarisisuuupritu01 = new ExDBFieldString<>("ztymvaarisisuuupritu01", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaaritmttknzkritu01 = new ExDBFieldString<>("ztymvaaritmttknzkritu01", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaariwtuktypeup01 = new ExDBFieldString<>("ztymvaariwtuktypeup01", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaaritmttknkykkjmup01 = new ExDBFieldString<>("ztymvaaritmttknkykkjmup01", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaariwup01 = new ExDBFieldString<>("ztymvaariwup01", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaariwyentuktypeup01 = new ExDBFieldString<>("ztymvaariwyentuktypeup01", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaariwupyendaka01 = new ExDBFieldString<>("ztymvaariwupyendaka01", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaariwupyenkijyun01 = new ExDBFieldString<>("ztymvaariwupyenkijyun01", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaariwupyenyasu01 = new ExDBFieldString<>("ztymvaariwupyenyasu01", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaariwumupyendaka01 = new ExDBFieldString<>("ztymvaariwumupyendaka01", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaariumupyenkijyun01 = new ExDBFieldString<>("ztymvaariumupyenkijyun01", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaariumupyenyasu01 = new ExDBFieldString<>("ztymvaariumupyenyasu01", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaariwtuktypesame01 = new ExDBFieldString<>("ztymvaariwtuktypesame01", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaaritmttknkykkjmsame01 = new ExDBFieldString<>("ztymvaaritmttknkykkjmsame01", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaariwsame01 = new ExDBFieldString<>("ztymvaariwsame01", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaariwyentuktypesame01 = new ExDBFieldString<>("ztymvaariwyentuktypesame01", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaariwsameyendaka01 = new ExDBFieldString<>("ztymvaariwsameyendaka01", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaariwsameyenkijyun01 = new ExDBFieldString<>("ztymvaariwsameyenkijyun01", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaariwsameyenyasu01 = new ExDBFieldString<>("ztymvaariwsameyenyasu01", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaariumsameyendaka01 = new ExDBFieldString<>("ztymvaariumsameyendaka01", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaariumsameyenkijyun01 = new ExDBFieldString<>("ztymvaariumsameyenkijyun01", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaariumsameyenyasu01 = new ExDBFieldString<>("ztymvaariumsameyenyasu01", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaariwtuktypedown01 = new ExDBFieldString<>("ztymvaariwtuktypedown01", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaaritmttknkykkjmdown01 = new ExDBFieldString<>("ztymvaaritmttknkykkjmdown01", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaariwdown01 = new ExDBFieldString<>("ztymvaariwdown01", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaariwyentuktypedown01 = new ExDBFieldString<>("ztymvaariwyentuktypedown01", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaariwdownyendaka01 = new ExDBFieldString<>("ztymvaariwdownyendaka01", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaariwdownyenkijyun01 = new ExDBFieldString<>("ztymvaariwdownyenkijyun01", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaariwdownyenyasu01 = new ExDBFieldString<>("ztymvaariwdownyenyasu01", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaariumdownyendaka01 = new ExDBFieldString<>("ztymvaariumdownyendaka01", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaariumdownyenkijyun01 = new ExDBFieldString<>("ztymvaariumdownyenkijyun01", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaariumdownyenyasu01 = new ExDBFieldString<>("ztymvaariumdownyenyasu01", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaarivtuktype01 = new ExDBFieldString<>("ztymvaarivtuktype01", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaariv01 = new ExDBFieldString<>("ztymvaariv01", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztyptmttkngkutiwake101 = new ExDBFieldString<>("ztyptmttkngkutiwake101", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztyptmttkngkutiwake201 = new ExDBFieldString<>("ztyptmttkngkutiwake201", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaarinenoutouym02 = new ExDBFieldString<>("ztymvaarinenoutouym02", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaarisisuuupritu02 = new ExDBFieldString<>("ztymvaarisisuuupritu02", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaaritmttknzkritu02 = new ExDBFieldString<>("ztymvaaritmttknzkritu02", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaariwtuktypeup02 = new ExDBFieldString<>("ztymvaariwtuktypeup02", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaaritmttknkykkjmup02 = new ExDBFieldString<>("ztymvaaritmttknkykkjmup02", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaariwup02 = new ExDBFieldString<>("ztymvaariwup02", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaariwyentuktypeup02 = new ExDBFieldString<>("ztymvaariwyentuktypeup02", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaariwupyendaka02 = new ExDBFieldString<>("ztymvaariwupyendaka02", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaariwupyenkijyun02 = new ExDBFieldString<>("ztymvaariwupyenkijyun02", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaariwupyenyasu02 = new ExDBFieldString<>("ztymvaariwupyenyasu02", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaariwumupyendaka02 = new ExDBFieldString<>("ztymvaariwumupyendaka02", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaariumupyenkijyun02 = new ExDBFieldString<>("ztymvaariumupyenkijyun02", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaariumupyenyasu02 = new ExDBFieldString<>("ztymvaariumupyenyasu02", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaariwtuktypesame02 = new ExDBFieldString<>("ztymvaariwtuktypesame02", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaaritmttknkykkjmsame02 = new ExDBFieldString<>("ztymvaaritmttknkykkjmsame02", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaariwsame02 = new ExDBFieldString<>("ztymvaariwsame02", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaariwyentuktypesame02 = new ExDBFieldString<>("ztymvaariwyentuktypesame02", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaariwsameyendaka02 = new ExDBFieldString<>("ztymvaariwsameyendaka02", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaariwsameyenkijyun02 = new ExDBFieldString<>("ztymvaariwsameyenkijyun02", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaariwsameyenyasu02 = new ExDBFieldString<>("ztymvaariwsameyenyasu02", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaariumsameyendaka02 = new ExDBFieldString<>("ztymvaariumsameyendaka02", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaariumsameyenkijyun02 = new ExDBFieldString<>("ztymvaariumsameyenkijyun02", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaariumsameyenyasu02 = new ExDBFieldString<>("ztymvaariumsameyenyasu02", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaariwtuktypedown02 = new ExDBFieldString<>("ztymvaariwtuktypedown02", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaaritmttknkykkjmdown02 = new ExDBFieldString<>("ztymvaaritmttknkykkjmdown02", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaariwdown02 = new ExDBFieldString<>("ztymvaariwdown02", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaariwyentuktypedown02 = new ExDBFieldString<>("ztymvaariwyentuktypedown02", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaariwdownyendaka02 = new ExDBFieldString<>("ztymvaariwdownyendaka02", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaariwdownyenkijyun02 = new ExDBFieldString<>("ztymvaariwdownyenkijyun02", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaariwdownyenyasu02 = new ExDBFieldString<>("ztymvaariwdownyenyasu02", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaariumdownyendaka02 = new ExDBFieldString<>("ztymvaariumdownyendaka02", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaariumdownyenkijyun02 = new ExDBFieldString<>("ztymvaariumdownyenkijyun02", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaariumdownyenyasu02 = new ExDBFieldString<>("ztymvaariumdownyenyasu02", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaarivtuktype02 = new ExDBFieldString<>("ztymvaarivtuktype02", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaariv02 = new ExDBFieldString<>("ztymvaariv02", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztyptmttkngkutiwake102 = new ExDBFieldString<>("ztyptmttkngkutiwake102", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztyptmttkngkutiwake202 = new ExDBFieldString<>("ztyptmttkngkutiwake202", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaarinenoutouym03 = new ExDBFieldString<>("ztymvaarinenoutouym03", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaarisisuuupritu03 = new ExDBFieldString<>("ztymvaarisisuuupritu03", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaaritmttknzkritu03 = new ExDBFieldString<>("ztymvaaritmttknzkritu03", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaariwtuktypeup03 = new ExDBFieldString<>("ztymvaariwtuktypeup03", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaaritmttknkykkjmup03 = new ExDBFieldString<>("ztymvaaritmttknkykkjmup03", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaariwup03 = new ExDBFieldString<>("ztymvaariwup03", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaariwyentuktypeup03 = new ExDBFieldString<>("ztymvaariwyentuktypeup03", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaariwupyendaka03 = new ExDBFieldString<>("ztymvaariwupyendaka03", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaariwupyenkijyun03 = new ExDBFieldString<>("ztymvaariwupyenkijyun03", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaariwupyenyasu03 = new ExDBFieldString<>("ztymvaariwupyenyasu03", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaariwumupyendaka03 = new ExDBFieldString<>("ztymvaariwumupyendaka03", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaariumupyenkijyun03 = new ExDBFieldString<>("ztymvaariumupyenkijyun03", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaariumupyenyasu03 = new ExDBFieldString<>("ztymvaariumupyenyasu03", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaariwtuktypesame03 = new ExDBFieldString<>("ztymvaariwtuktypesame03", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaaritmttknkykkjmsame03 = new ExDBFieldString<>("ztymvaaritmttknkykkjmsame03", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaariwsame03 = new ExDBFieldString<>("ztymvaariwsame03", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaariwyentuktypesame03 = new ExDBFieldString<>("ztymvaariwyentuktypesame03", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaariwsameyendaka03 = new ExDBFieldString<>("ztymvaariwsameyendaka03", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaariwsameyenkijyun03 = new ExDBFieldString<>("ztymvaariwsameyenkijyun03", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaariwsameyenyasu03 = new ExDBFieldString<>("ztymvaariwsameyenyasu03", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaariumsameyendaka03 = new ExDBFieldString<>("ztymvaariumsameyendaka03", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaariumsameyenkijyun03 = new ExDBFieldString<>("ztymvaariumsameyenkijyun03", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaariumsameyenyasu03 = new ExDBFieldString<>("ztymvaariumsameyenyasu03", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaariwtuktypedown03 = new ExDBFieldString<>("ztymvaariwtuktypedown03", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaaritmttknkykkjmdown03 = new ExDBFieldString<>("ztymvaaritmttknkykkjmdown03", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaariwdown03 = new ExDBFieldString<>("ztymvaariwdown03", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaariwyentuktypedown03 = new ExDBFieldString<>("ztymvaariwyentuktypedown03", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaariwdownyendaka03 = new ExDBFieldString<>("ztymvaariwdownyendaka03", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaariwdownyenkijyun03 = new ExDBFieldString<>("ztymvaariwdownyenkijyun03", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaariwdownyenyasu03 = new ExDBFieldString<>("ztymvaariwdownyenyasu03", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaariumdownyendaka03 = new ExDBFieldString<>("ztymvaariumdownyendaka03", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaariumdownyenkijyun03 = new ExDBFieldString<>("ztymvaariumdownyenkijyun03", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaariumdownyenyasu03 = new ExDBFieldString<>("ztymvaariumdownyenyasu03", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaarivtuktype03 = new ExDBFieldString<>("ztymvaarivtuktype03", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaariv03 = new ExDBFieldString<>("ztymvaariv03", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztyptmttkngkutiwake103 = new ExDBFieldString<>("ztyptmttkngkutiwake103", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztyptmttkngkutiwake203 = new ExDBFieldString<>("ztyptmttkngkutiwake203", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaarinenoutouym04 = new ExDBFieldString<>("ztymvaarinenoutouym04", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaarisisuuupritu04 = new ExDBFieldString<>("ztymvaarisisuuupritu04", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaaritmttknzkritu04 = new ExDBFieldString<>("ztymvaaritmttknzkritu04", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaariwtuktypeup04 = new ExDBFieldString<>("ztymvaariwtuktypeup04", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaaritmttknkykkjmup04 = new ExDBFieldString<>("ztymvaaritmttknkykkjmup04", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaariwup04 = new ExDBFieldString<>("ztymvaariwup04", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaariwyentuktypeup04 = new ExDBFieldString<>("ztymvaariwyentuktypeup04", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaariwupyendaka04 = new ExDBFieldString<>("ztymvaariwupyendaka04", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaariwupyenkijyun04 = new ExDBFieldString<>("ztymvaariwupyenkijyun04", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaariwupyenyasu04 = new ExDBFieldString<>("ztymvaariwupyenyasu04", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaariwumupyendaka04 = new ExDBFieldString<>("ztymvaariwumupyendaka04", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaariumupyenkijyun04 = new ExDBFieldString<>("ztymvaariumupyenkijyun04", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaariumupyenyasu04 = new ExDBFieldString<>("ztymvaariumupyenyasu04", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaariwtuktypesame04 = new ExDBFieldString<>("ztymvaariwtuktypesame04", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaaritmttknkykkjmsame04 = new ExDBFieldString<>("ztymvaaritmttknkykkjmsame04", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaariwsame04 = new ExDBFieldString<>("ztymvaariwsame04", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaariwyentuktypesame04 = new ExDBFieldString<>("ztymvaariwyentuktypesame04", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaariwsameyendaka04 = new ExDBFieldString<>("ztymvaariwsameyendaka04", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaariwsameyenkijyun04 = new ExDBFieldString<>("ztymvaariwsameyenkijyun04", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaariwsameyenyasu04 = new ExDBFieldString<>("ztymvaariwsameyenyasu04", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaariumsameyendaka04 = new ExDBFieldString<>("ztymvaariumsameyendaka04", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaariumsameyenkijyun04 = new ExDBFieldString<>("ztymvaariumsameyenkijyun04", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaariumsameyenyasu04 = new ExDBFieldString<>("ztymvaariumsameyenyasu04", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaariwtuktypedown04 = new ExDBFieldString<>("ztymvaariwtuktypedown04", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaaritmttknkykkjmdown04 = new ExDBFieldString<>("ztymvaaritmttknkykkjmdown04", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaariwdown04 = new ExDBFieldString<>("ztymvaariwdown04", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaariwyentuktypedown04 = new ExDBFieldString<>("ztymvaariwyentuktypedown04", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaariwdownyendaka04 = new ExDBFieldString<>("ztymvaariwdownyendaka04", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaariwdownyenkijyun04 = new ExDBFieldString<>("ztymvaariwdownyenkijyun04", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaariwdownyenyasu04 = new ExDBFieldString<>("ztymvaariwdownyenyasu04", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaariumdownyendaka04 = new ExDBFieldString<>("ztymvaariumdownyendaka04", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaariumdownyenkijyun04 = new ExDBFieldString<>("ztymvaariumdownyenkijyun04", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaariumdownyenyasu04 = new ExDBFieldString<>("ztymvaariumdownyenyasu04", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaarivtuktype04 = new ExDBFieldString<>("ztymvaarivtuktype04", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaariv04 = new ExDBFieldString<>("ztymvaariv04", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztyptmttkngkutiwake104 = new ExDBFieldString<>("ztyptmttkngkutiwake104", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztyptmttkngkutiwake204 = new ExDBFieldString<>("ztyptmttkngkutiwake204", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaarinenoutouym05 = new ExDBFieldString<>("ztymvaarinenoutouym05", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaarisisuuupritu05 = new ExDBFieldString<>("ztymvaarisisuuupritu05", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaaritmttknzkritu05 = new ExDBFieldString<>("ztymvaaritmttknzkritu05", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaariwtuktypeup05 = new ExDBFieldString<>("ztymvaariwtuktypeup05", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaaritmttknkykkjmup05 = new ExDBFieldString<>("ztymvaaritmttknkykkjmup05", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaariwup05 = new ExDBFieldString<>("ztymvaariwup05", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaariwyentuktypeup05 = new ExDBFieldString<>("ztymvaariwyentuktypeup05", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaariwupyendaka05 = new ExDBFieldString<>("ztymvaariwupyendaka05", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaariwupyenkijyun05 = new ExDBFieldString<>("ztymvaariwupyenkijyun05", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaariwupyenyasu05 = new ExDBFieldString<>("ztymvaariwupyenyasu05", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaariwumupyendaka05 = new ExDBFieldString<>("ztymvaariwumupyendaka05", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaariumupyenkijyun05 = new ExDBFieldString<>("ztymvaariumupyenkijyun05", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaariumupyenyasu05 = new ExDBFieldString<>("ztymvaariumupyenyasu05", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaariwtuktypesame05 = new ExDBFieldString<>("ztymvaariwtuktypesame05", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaaritmttknkykkjmsame05 = new ExDBFieldString<>("ztymvaaritmttknkykkjmsame05", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaariwsame05 = new ExDBFieldString<>("ztymvaariwsame05", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaariwyentuktypesame05 = new ExDBFieldString<>("ztymvaariwyentuktypesame05", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaariwsameyendaka05 = new ExDBFieldString<>("ztymvaariwsameyendaka05", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaariwsameyenkijyun05 = new ExDBFieldString<>("ztymvaariwsameyenkijyun05", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaariwsameyenyasu05 = new ExDBFieldString<>("ztymvaariwsameyenyasu05", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaariumsameyendaka05 = new ExDBFieldString<>("ztymvaariumsameyendaka05", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaariumsameyenkijyun05 = new ExDBFieldString<>("ztymvaariumsameyenkijyun05", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaariumsameyenyasu05 = new ExDBFieldString<>("ztymvaariumsameyenyasu05", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaariwtuktypedown05 = new ExDBFieldString<>("ztymvaariwtuktypedown05", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaaritmttknkykkjmdown05 = new ExDBFieldString<>("ztymvaaritmttknkykkjmdown05", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaariwdown05 = new ExDBFieldString<>("ztymvaariwdown05", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaariwyentuktypedown05 = new ExDBFieldString<>("ztymvaariwyentuktypedown05", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaariwdownyendaka05 = new ExDBFieldString<>("ztymvaariwdownyendaka05", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaariwdownyenkijyun05 = new ExDBFieldString<>("ztymvaariwdownyenkijyun05", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaariwdownyenyasu05 = new ExDBFieldString<>("ztymvaariwdownyenyasu05", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaariumdownyendaka05 = new ExDBFieldString<>("ztymvaariumdownyendaka05", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaariumdownyenkijyun05 = new ExDBFieldString<>("ztymvaariumdownyenkijyun05", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaariumdownyenyasu05 = new ExDBFieldString<>("ztymvaariumdownyenyasu05", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaarivtuktype05 = new ExDBFieldString<>("ztymvaarivtuktype05", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaariv05 = new ExDBFieldString<>("ztymvaariv05", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztyptmttkngkutiwake105 = new ExDBFieldString<>("ztyptmttkngkutiwake105", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztyptmttkngkutiwake205 = new ExDBFieldString<>("ztyptmttkngkutiwake205", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaarinenoutouym06 = new ExDBFieldString<>("ztymvaarinenoutouym06", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaarisisuuupritu06 = new ExDBFieldString<>("ztymvaarisisuuupritu06", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaaritmttknzkritu06 = new ExDBFieldString<>("ztymvaaritmttknzkritu06", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaariwtuktypeup06 = new ExDBFieldString<>("ztymvaariwtuktypeup06", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaaritmttknkykkjmup06 = new ExDBFieldString<>("ztymvaaritmttknkykkjmup06", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaariwup06 = new ExDBFieldString<>("ztymvaariwup06", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaariwyentuktypeup06 = new ExDBFieldString<>("ztymvaariwyentuktypeup06", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaariwupyendaka06 = new ExDBFieldString<>("ztymvaariwupyendaka06", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaariwupyenkijyun06 = new ExDBFieldString<>("ztymvaariwupyenkijyun06", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaariwupyenyasu06 = new ExDBFieldString<>("ztymvaariwupyenyasu06", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaariwumupyendaka06 = new ExDBFieldString<>("ztymvaariwumupyendaka06", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaariumupyenkijyun06 = new ExDBFieldString<>("ztymvaariumupyenkijyun06", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaariumupyenyasu06 = new ExDBFieldString<>("ztymvaariumupyenyasu06", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaariwtuktypesame06 = new ExDBFieldString<>("ztymvaariwtuktypesame06", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaaritmttknkykkjmsame06 = new ExDBFieldString<>("ztymvaaritmttknkykkjmsame06", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaariwsame06 = new ExDBFieldString<>("ztymvaariwsame06", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaariwyentuktypesame06 = new ExDBFieldString<>("ztymvaariwyentuktypesame06", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaariwsameyendaka06 = new ExDBFieldString<>("ztymvaariwsameyendaka06", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaariwsameyenkijyun06 = new ExDBFieldString<>("ztymvaariwsameyenkijyun06", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaariwsameyenyasu06 = new ExDBFieldString<>("ztymvaariwsameyenyasu06", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaariumsameyendaka06 = new ExDBFieldString<>("ztymvaariumsameyendaka06", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaariumsameyenkijyun06 = new ExDBFieldString<>("ztymvaariumsameyenkijyun06", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaariumsameyenyasu06 = new ExDBFieldString<>("ztymvaariumsameyenyasu06", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaariwtuktypedown06 = new ExDBFieldString<>("ztymvaariwtuktypedown06", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaaritmttknkykkjmdown06 = new ExDBFieldString<>("ztymvaaritmttknkykkjmdown06", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaariwdown06 = new ExDBFieldString<>("ztymvaariwdown06", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaariwyentuktypedown06 = new ExDBFieldString<>("ztymvaariwyentuktypedown06", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaariwdownyendaka06 = new ExDBFieldString<>("ztymvaariwdownyendaka06", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaariwdownyenkijyun06 = new ExDBFieldString<>("ztymvaariwdownyenkijyun06", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaariwdownyenyasu06 = new ExDBFieldString<>("ztymvaariwdownyenyasu06", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaariumdownyendaka06 = new ExDBFieldString<>("ztymvaariumdownyendaka06", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaariumdownyenkijyun06 = new ExDBFieldString<>("ztymvaariumdownyenkijyun06", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaariumdownyenyasu06 = new ExDBFieldString<>("ztymvaariumdownyenyasu06", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaarivtuktype06 = new ExDBFieldString<>("ztymvaarivtuktype06", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaariv06 = new ExDBFieldString<>("ztymvaariv06", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztyptmttkngkutiwake106 = new ExDBFieldString<>("ztyptmttkngkutiwake106", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztyptmttkngkutiwake206 = new ExDBFieldString<>("ztyptmttkngkutiwake206", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaarinenoutouym07 = new ExDBFieldString<>("ztymvaarinenoutouym07", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaarisisuuupritu07 = new ExDBFieldString<>("ztymvaarisisuuupritu07", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaaritmttknzkritu07 = new ExDBFieldString<>("ztymvaaritmttknzkritu07", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaariwtuktypeup07 = new ExDBFieldString<>("ztymvaariwtuktypeup07", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaaritmttknkykkjmup07 = new ExDBFieldString<>("ztymvaaritmttknkykkjmup07", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaariwup07 = new ExDBFieldString<>("ztymvaariwup07", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaariwyentuktypeup07 = new ExDBFieldString<>("ztymvaariwyentuktypeup07", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaariwupyendaka07 = new ExDBFieldString<>("ztymvaariwupyendaka07", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaariwupyenkijyun07 = new ExDBFieldString<>("ztymvaariwupyenkijyun07", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaariwupyenyasu07 = new ExDBFieldString<>("ztymvaariwupyenyasu07", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaariwumupyendaka07 = new ExDBFieldString<>("ztymvaariwumupyendaka07", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaariumupyenkijyun07 = new ExDBFieldString<>("ztymvaariumupyenkijyun07", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaariumupyenyasu07 = new ExDBFieldString<>("ztymvaariumupyenyasu07", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaariwtuktypesame07 = new ExDBFieldString<>("ztymvaariwtuktypesame07", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaaritmttknkykkjmsame07 = new ExDBFieldString<>("ztymvaaritmttknkykkjmsame07", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaariwsame07 = new ExDBFieldString<>("ztymvaariwsame07", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaariwyentuktypesame07 = new ExDBFieldString<>("ztymvaariwyentuktypesame07", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaariwsameyendaka07 = new ExDBFieldString<>("ztymvaariwsameyendaka07", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaariwsameyenkijyun07 = new ExDBFieldString<>("ztymvaariwsameyenkijyun07", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaariwsameyenyasu07 = new ExDBFieldString<>("ztymvaariwsameyenyasu07", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaariumsameyendaka07 = new ExDBFieldString<>("ztymvaariumsameyendaka07", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaariumsameyenkijyun07 = new ExDBFieldString<>("ztymvaariumsameyenkijyun07", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaariumsameyenyasu07 = new ExDBFieldString<>("ztymvaariumsameyenyasu07", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaariwtuktypedown07 = new ExDBFieldString<>("ztymvaariwtuktypedown07", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaaritmttknkykkjmdown07 = new ExDBFieldString<>("ztymvaaritmttknkykkjmdown07", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaariwdown07 = new ExDBFieldString<>("ztymvaariwdown07", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaariwyentuktypedown07 = new ExDBFieldString<>("ztymvaariwyentuktypedown07", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaariwdownyendaka07 = new ExDBFieldString<>("ztymvaariwdownyendaka07", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaariwdownyenkijyun07 = new ExDBFieldString<>("ztymvaariwdownyenkijyun07", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaariwdownyenyasu07 = new ExDBFieldString<>("ztymvaariwdownyenyasu07", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaariumdownyendaka07 = new ExDBFieldString<>("ztymvaariumdownyendaka07", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaariumdownyenkijyun07 = new ExDBFieldString<>("ztymvaariumdownyenkijyun07", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaariumdownyenyasu07 = new ExDBFieldString<>("ztymvaariumdownyenyasu07", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaarivtuktype07 = new ExDBFieldString<>("ztymvaarivtuktype07", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaariv07 = new ExDBFieldString<>("ztymvaariv07", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztyptmttkngkutiwake107 = new ExDBFieldString<>("ztyptmttkngkutiwake107", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztyptmttkngkutiwake207 = new ExDBFieldString<>("ztyptmttkngkutiwake207", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaarinenoutouym08 = new ExDBFieldString<>("ztymvaarinenoutouym08", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaarisisuuupritu08 = new ExDBFieldString<>("ztymvaarisisuuupritu08", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaaritmttknzkritu08 = new ExDBFieldString<>("ztymvaaritmttknzkritu08", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaariwtuktypeup08 = new ExDBFieldString<>("ztymvaariwtuktypeup08", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaaritmttknkykkjmup08 = new ExDBFieldString<>("ztymvaaritmttknkykkjmup08", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaariwup08 = new ExDBFieldString<>("ztymvaariwup08", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaariwyentuktypeup08 = new ExDBFieldString<>("ztymvaariwyentuktypeup08", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaariwupyendaka08 = new ExDBFieldString<>("ztymvaariwupyendaka08", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaariwupyenkijyun08 = new ExDBFieldString<>("ztymvaariwupyenkijyun08", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaariwupyenyasu08 = new ExDBFieldString<>("ztymvaariwupyenyasu08", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaariwumupyendaka08 = new ExDBFieldString<>("ztymvaariwumupyendaka08", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaariumupyenkijyun08 = new ExDBFieldString<>("ztymvaariumupyenkijyun08", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaariumupyenyasu08 = new ExDBFieldString<>("ztymvaariumupyenyasu08", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaariwtuktypesame08 = new ExDBFieldString<>("ztymvaariwtuktypesame08", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaaritmttknkykkjmsame08 = new ExDBFieldString<>("ztymvaaritmttknkykkjmsame08", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaariwsame08 = new ExDBFieldString<>("ztymvaariwsame08", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaariwyentuktypesame08 = new ExDBFieldString<>("ztymvaariwyentuktypesame08", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaariwsameyendaka08 = new ExDBFieldString<>("ztymvaariwsameyendaka08", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaariwsameyenkijyun08 = new ExDBFieldString<>("ztymvaariwsameyenkijyun08", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaariwsameyenyasu08 = new ExDBFieldString<>("ztymvaariwsameyenyasu08", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaariumsameyendaka08 = new ExDBFieldString<>("ztymvaariumsameyendaka08", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaariumsameyenkijyun08 = new ExDBFieldString<>("ztymvaariumsameyenkijyun08", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaariumsameyenyasu08 = new ExDBFieldString<>("ztymvaariumsameyenyasu08", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaariwtuktypedown08 = new ExDBFieldString<>("ztymvaariwtuktypedown08", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaaritmttknkykkjmdown08 = new ExDBFieldString<>("ztymvaaritmttknkykkjmdown08", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaariwdown08 = new ExDBFieldString<>("ztymvaariwdown08", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaariwyentuktypedown08 = new ExDBFieldString<>("ztymvaariwyentuktypedown08", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaariwdownyendaka08 = new ExDBFieldString<>("ztymvaariwdownyendaka08", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaariwdownyenkijyun08 = new ExDBFieldString<>("ztymvaariwdownyenkijyun08", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaariwdownyenyasu08 = new ExDBFieldString<>("ztymvaariwdownyenyasu08", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaariumdownyendaka08 = new ExDBFieldString<>("ztymvaariumdownyendaka08", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaariumdownyenkijyun08 = new ExDBFieldString<>("ztymvaariumdownyenkijyun08", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaariumdownyenyasu08 = new ExDBFieldString<>("ztymvaariumdownyenyasu08", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaarivtuktype08 = new ExDBFieldString<>("ztymvaarivtuktype08", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaariv08 = new ExDBFieldString<>("ztymvaariv08", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztyptmttkngkutiwake108 = new ExDBFieldString<>("ztyptmttkngkutiwake108", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztyptmttkngkutiwake208 = new ExDBFieldString<>("ztyptmttkngkutiwake208", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaarinenoutouym09 = new ExDBFieldString<>("ztymvaarinenoutouym09", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaarisisuuupritu09 = new ExDBFieldString<>("ztymvaarisisuuupritu09", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaaritmttknzkritu09 = new ExDBFieldString<>("ztymvaaritmttknzkritu09", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaariwtuktypeup09 = new ExDBFieldString<>("ztymvaariwtuktypeup09", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaaritmttknkykkjmup09 = new ExDBFieldString<>("ztymvaaritmttknkykkjmup09", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaariwup09 = new ExDBFieldString<>("ztymvaariwup09", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaariwyentuktypeup09 = new ExDBFieldString<>("ztymvaariwyentuktypeup09", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaariwupyendaka09 = new ExDBFieldString<>("ztymvaariwupyendaka09", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaariwupyenkijyun09 = new ExDBFieldString<>("ztymvaariwupyenkijyun09", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaariwupyenyasu09 = new ExDBFieldString<>("ztymvaariwupyenyasu09", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaariwumupyendaka09 = new ExDBFieldString<>("ztymvaariwumupyendaka09", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaariumupyenkijyun09 = new ExDBFieldString<>("ztymvaariumupyenkijyun09", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaariumupyenyasu09 = new ExDBFieldString<>("ztymvaariumupyenyasu09", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaariwtuktypesame09 = new ExDBFieldString<>("ztymvaariwtuktypesame09", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaaritmttknkykkjmsame09 = new ExDBFieldString<>("ztymvaaritmttknkykkjmsame09", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaariwsame09 = new ExDBFieldString<>("ztymvaariwsame09", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaariwyentuktypesame09 = new ExDBFieldString<>("ztymvaariwyentuktypesame09", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaariwsameyendaka09 = new ExDBFieldString<>("ztymvaariwsameyendaka09", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaariwsameyenkijyun09 = new ExDBFieldString<>("ztymvaariwsameyenkijyun09", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaariwsameyenyasu09 = new ExDBFieldString<>("ztymvaariwsameyenyasu09", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaariumsameyendaka09 = new ExDBFieldString<>("ztymvaariumsameyendaka09", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaariumsameyenkijyun09 = new ExDBFieldString<>("ztymvaariumsameyenkijyun09", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaariumsameyenyasu09 = new ExDBFieldString<>("ztymvaariumsameyenyasu09", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaariwtuktypedown09 = new ExDBFieldString<>("ztymvaariwtuktypedown09", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaaritmttknkykkjmdown09 = new ExDBFieldString<>("ztymvaaritmttknkykkjmdown09", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaariwdown09 = new ExDBFieldString<>("ztymvaariwdown09", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaariwyentuktypedown09 = new ExDBFieldString<>("ztymvaariwyentuktypedown09", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaariwdownyendaka09 = new ExDBFieldString<>("ztymvaariwdownyendaka09", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaariwdownyenkijyun09 = new ExDBFieldString<>("ztymvaariwdownyenkijyun09", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaariwdownyenyasu09 = new ExDBFieldString<>("ztymvaariwdownyenyasu09", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaariumdownyendaka09 = new ExDBFieldString<>("ztymvaariumdownyendaka09", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaariumdownyenkijyun09 = new ExDBFieldString<>("ztymvaariumdownyenkijyun09", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaariumdownyenyasu09 = new ExDBFieldString<>("ztymvaariumdownyenyasu09", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaarivtuktype09 = new ExDBFieldString<>("ztymvaarivtuktype09", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaariv09 = new ExDBFieldString<>("ztymvaariv09", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztyptmttkngkutiwake109 = new ExDBFieldString<>("ztyptmttkngkutiwake109", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztyptmttkngkutiwake209 = new ExDBFieldString<>("ztyptmttkngkutiwake209", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaarinenoutouym10 = new ExDBFieldString<>("ztymvaarinenoutouym10", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaarisisuuupritu10 = new ExDBFieldString<>("ztymvaarisisuuupritu10", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaaritmttknzkritu10 = new ExDBFieldString<>("ztymvaaritmttknzkritu10", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaariwtuktypeup10 = new ExDBFieldString<>("ztymvaariwtuktypeup10", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaaritmttknkykkjmup10 = new ExDBFieldString<>("ztymvaaritmttknkykkjmup10", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaariwup10 = new ExDBFieldString<>("ztymvaariwup10", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaariwyentuktypeup10 = new ExDBFieldString<>("ztymvaariwyentuktypeup10", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaariwupyendaka10 = new ExDBFieldString<>("ztymvaariwupyendaka10", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaariwupyenkijyun10 = new ExDBFieldString<>("ztymvaariwupyenkijyun10", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaariwupyenyasu10 = new ExDBFieldString<>("ztymvaariwupyenyasu10", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaariwumupyendaka10 = new ExDBFieldString<>("ztymvaariwumupyendaka10", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaariumupyenkijyun10 = new ExDBFieldString<>("ztymvaariumupyenkijyun10", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaariumupyenyasu10 = new ExDBFieldString<>("ztymvaariumupyenyasu10", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaariwtuktypesame10 = new ExDBFieldString<>("ztymvaariwtuktypesame10", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaaritmttknkykkjmsame10 = new ExDBFieldString<>("ztymvaaritmttknkykkjmsame10", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaariwsame10 = new ExDBFieldString<>("ztymvaariwsame10", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaariwyentuktypesame10 = new ExDBFieldString<>("ztymvaariwyentuktypesame10", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaariwsameyendaka10 = new ExDBFieldString<>("ztymvaariwsameyendaka10", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaariwsameyenkijyun10 = new ExDBFieldString<>("ztymvaariwsameyenkijyun10", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaariwsameyenyasu10 = new ExDBFieldString<>("ztymvaariwsameyenyasu10", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaariumsameyendaka10 = new ExDBFieldString<>("ztymvaariumsameyendaka10", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaariumsameyenkijyun10 = new ExDBFieldString<>("ztymvaariumsameyenkijyun10", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaariumsameyenyasu10 = new ExDBFieldString<>("ztymvaariumsameyenyasu10", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaariwtuktypedown10 = new ExDBFieldString<>("ztymvaariwtuktypedown10", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaaritmttknkykkjmdown10 = new ExDBFieldString<>("ztymvaaritmttknkykkjmdown10", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaariwdown10 = new ExDBFieldString<>("ztymvaariwdown10", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaariwyentuktypedown10 = new ExDBFieldString<>("ztymvaariwyentuktypedown10", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaariwdownyendaka10 = new ExDBFieldString<>("ztymvaariwdownyendaka10", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaariwdownyenkijyun10 = new ExDBFieldString<>("ztymvaariwdownyenkijyun10", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaariwdownyenyasu10 = new ExDBFieldString<>("ztymvaariwdownyenyasu10", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaariumdownyendaka10 = new ExDBFieldString<>("ztymvaariumdownyendaka10", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaariumdownyenkijyun10 = new ExDBFieldString<>("ztymvaariumdownyenkijyun10", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaariumdownyenyasu10 = new ExDBFieldString<>("ztymvaariumdownyenyasu10", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaarivtuktype10 = new ExDBFieldString<>("ztymvaarivtuktype10", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaariv10 = new ExDBFieldString<>("ztymvaariv10", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztyptmttkngkutiwake110 = new ExDBFieldString<>("ztyptmttkngkutiwake110", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztyptmttkngkutiwake210 = new ExDBFieldString<>("ztyptmttkngkutiwake210", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaarinenoutouym11 = new ExDBFieldString<>("ztymvaarinenoutouym11", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaariwtuktypeup11 = new ExDBFieldString<>("ztymvaariwtuktypeup11", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaariwup11 = new ExDBFieldString<>("ztymvaariwup11", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaariwyentuktypeup11 = new ExDBFieldString<>("ztymvaariwyentuktypeup11", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaariwupyendaka11 = new ExDBFieldString<>("ztymvaariwupyendaka11", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaariwupyenkijyun11 = new ExDBFieldString<>("ztymvaariwupyenkijyun11", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaariwupyenyasu11 = new ExDBFieldString<>("ztymvaariwupyenyasu11", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaariwumupyendaka11 = new ExDBFieldString<>("ztymvaariwumupyendaka11", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaariumupyenkijyun11 = new ExDBFieldString<>("ztymvaariumupyenkijyun11", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaariumupyenyasu11 = new ExDBFieldString<>("ztymvaariumupyenyasu11", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaariwtuktypesame11 = new ExDBFieldString<>("ztymvaariwtuktypesame11", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaariwsame11 = new ExDBFieldString<>("ztymvaariwsame11", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaariwyentuktypesame11 = new ExDBFieldString<>("ztymvaariwyentuktypesame11", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaariwsameyendaka11 = new ExDBFieldString<>("ztymvaariwsameyendaka11", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaariwsameyenkijyun11 = new ExDBFieldString<>("ztymvaariwsameyenkijyun11", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaariwsameyenyasu11 = new ExDBFieldString<>("ztymvaariwsameyenyasu11", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaariumsameyendaka11 = new ExDBFieldString<>("ztymvaariumsameyendaka11", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaariumsameyenkijyun11 = new ExDBFieldString<>("ztymvaariumsameyenkijyun11", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaariumsameyenyasu11 = new ExDBFieldString<>("ztymvaariumsameyenyasu11", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaariwtuktypedown11 = new ExDBFieldString<>("ztymvaariwtuktypedown11", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaariwdown11 = new ExDBFieldString<>("ztymvaariwdown11", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaariwyentuktypedown11 = new ExDBFieldString<>("ztymvaariwyentuktypedown11", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaariwdownyendaka11 = new ExDBFieldString<>("ztymvaariwdownyendaka11", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaariwdownyenkijyun11 = new ExDBFieldString<>("ztymvaariwdownyenkijyun11", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaariwdownyenyasu11 = new ExDBFieldString<>("ztymvaariwdownyenyasu11", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaariumdownyendaka11 = new ExDBFieldString<>("ztymvaariumdownyendaka11", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaariumdownyenkijyun11 = new ExDBFieldString<>("ztymvaariumdownyenkijyun11", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaariumdownyenyasu11 = new ExDBFieldString<>("ztymvaariumdownyenyasu11", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaarivtuktype11 = new ExDBFieldString<>("ztymvaarivtuktype11", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaariv11 = new ExDBFieldString<>("ztymvaariv11", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaarinenoutouym12 = new ExDBFieldString<>("ztymvaarinenoutouym12", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaariwtuktypeup12 = new ExDBFieldString<>("ztymvaariwtuktypeup12", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaariwup12 = new ExDBFieldString<>("ztymvaariwup12", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaariwyentuktypeup12 = new ExDBFieldString<>("ztymvaariwyentuktypeup12", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaariwupyendaka12 = new ExDBFieldString<>("ztymvaariwupyendaka12", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaariwupyenkijyun12 = new ExDBFieldString<>("ztymvaariwupyenkijyun12", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaariwupyenyasu12 = new ExDBFieldString<>("ztymvaariwupyenyasu12", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaariwumupyendaka12 = new ExDBFieldString<>("ztymvaariwumupyendaka12", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaariumupyenkijyun12 = new ExDBFieldString<>("ztymvaariumupyenkijyun12", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaariumupyenyasu12 = new ExDBFieldString<>("ztymvaariumupyenyasu12", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaariwtuktypesame12 = new ExDBFieldString<>("ztymvaariwtuktypesame12", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaariwsame12 = new ExDBFieldString<>("ztymvaariwsame12", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaariwyentuktypesame12 = new ExDBFieldString<>("ztymvaariwyentuktypesame12", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaariwsameyendaka12 = new ExDBFieldString<>("ztymvaariwsameyendaka12", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaariwsameyenkijyun12 = new ExDBFieldString<>("ztymvaariwsameyenkijyun12", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaariwsameyenyasu12 = new ExDBFieldString<>("ztymvaariwsameyenyasu12", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaariumsameyendaka12 = new ExDBFieldString<>("ztymvaariumsameyendaka12", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaariumsameyenkijyun12 = new ExDBFieldString<>("ztymvaariumsameyenkijyun12", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaariumsameyenyasu12 = new ExDBFieldString<>("ztymvaariumsameyenyasu12", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaariwtuktypedown12 = new ExDBFieldString<>("ztymvaariwtuktypedown12", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaariwdown12 = new ExDBFieldString<>("ztymvaariwdown12", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaariwyentuktypedown12 = new ExDBFieldString<>("ztymvaariwyentuktypedown12", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaariwdownyendaka12 = new ExDBFieldString<>("ztymvaariwdownyendaka12", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaariwdownyenkijyun12 = new ExDBFieldString<>("ztymvaariwdownyenkijyun12", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaariwdownyenyasu12 = new ExDBFieldString<>("ztymvaariwdownyenyasu12", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaariumdownyendaka12 = new ExDBFieldString<>("ztymvaariumdownyendaka12", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaariumdownyenkijyun12 = new ExDBFieldString<>("ztymvaariumdownyenkijyun12", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaariumdownyenyasu12 = new ExDBFieldString<>("ztymvaariumdownyenyasu12", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaarivtuktype12 = new ExDBFieldString<>("ztymvaarivtuktype12", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaariv12 = new ExDBFieldString<>("ztymvaariv12", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaarinenoutouym13 = new ExDBFieldString<>("ztymvaarinenoutouym13", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaariwtuktypeup13 = new ExDBFieldString<>("ztymvaariwtuktypeup13", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaariwup13 = new ExDBFieldString<>("ztymvaariwup13", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaariwyentuktypeup13 = new ExDBFieldString<>("ztymvaariwyentuktypeup13", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaariwupyendaka13 = new ExDBFieldString<>("ztymvaariwupyendaka13", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaariwupyenkijyun13 = new ExDBFieldString<>("ztymvaariwupyenkijyun13", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaariwupyenyasu13 = new ExDBFieldString<>("ztymvaariwupyenyasu13", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaariwumupyendaka13 = new ExDBFieldString<>("ztymvaariwumupyendaka13", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaariumupyenkijyun13 = new ExDBFieldString<>("ztymvaariumupyenkijyun13", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaariumupyenyasu13 = new ExDBFieldString<>("ztymvaariumupyenyasu13", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaariwtuktypesame13 = new ExDBFieldString<>("ztymvaariwtuktypesame13", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaariwsame13 = new ExDBFieldString<>("ztymvaariwsame13", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaariwyentuktypesame13 = new ExDBFieldString<>("ztymvaariwyentuktypesame13", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaariwsameyendaka13 = new ExDBFieldString<>("ztymvaariwsameyendaka13", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaariwsameyenkijyun13 = new ExDBFieldString<>("ztymvaariwsameyenkijyun13", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaariwsameyenyasu13 = new ExDBFieldString<>("ztymvaariwsameyenyasu13", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaariumsameyendaka13 = new ExDBFieldString<>("ztymvaariumsameyendaka13", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaariumsameyenkijyun13 = new ExDBFieldString<>("ztymvaariumsameyenkijyun13", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaariumsameyenyasu13 = new ExDBFieldString<>("ztymvaariumsameyenyasu13", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaariwtuktypedown13 = new ExDBFieldString<>("ztymvaariwtuktypedown13", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaariwdown13 = new ExDBFieldString<>("ztymvaariwdown13", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaariwyentuktypedown13 = new ExDBFieldString<>("ztymvaariwyentuktypedown13", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaariwdownyendaka13 = new ExDBFieldString<>("ztymvaariwdownyendaka13", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaariwdownyenkijyun13 = new ExDBFieldString<>("ztymvaariwdownyenkijyun13", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaariwdownyenyasu13 = new ExDBFieldString<>("ztymvaariwdownyenyasu13", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaariumdownyendaka13 = new ExDBFieldString<>("ztymvaariumdownyendaka13", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaariumdownyenkijyun13 = new ExDBFieldString<>("ztymvaariumdownyenkijyun13", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaariumdownyenyasu13 = new ExDBFieldString<>("ztymvaariumdownyenyasu13", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaarivtuktype13 = new ExDBFieldString<>("ztymvaarivtuktype13", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaariv13 = new ExDBFieldString<>("ztymvaariv13", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaarinenoutouym14 = new ExDBFieldString<>("ztymvaarinenoutouym14", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaariwtuktypeup14 = new ExDBFieldString<>("ztymvaariwtuktypeup14", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaariwup14 = new ExDBFieldString<>("ztymvaariwup14", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaariwyentuktypeup14 = new ExDBFieldString<>("ztymvaariwyentuktypeup14", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaariwupyendaka14 = new ExDBFieldString<>("ztymvaariwupyendaka14", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaariwupyenkijyun14 = new ExDBFieldString<>("ztymvaariwupyenkijyun14", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaariwupyenyasu14 = new ExDBFieldString<>("ztymvaariwupyenyasu14", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaariwumupyendaka14 = new ExDBFieldString<>("ztymvaariwumupyendaka14", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaariumupyenkijyun14 = new ExDBFieldString<>("ztymvaariumupyenkijyun14", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaariumupyenyasu14 = new ExDBFieldString<>("ztymvaariumupyenyasu14", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaariwtuktypesame14 = new ExDBFieldString<>("ztymvaariwtuktypesame14", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaariwsame14 = new ExDBFieldString<>("ztymvaariwsame14", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaariwyentuktypesame14 = new ExDBFieldString<>("ztymvaariwyentuktypesame14", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaariwsameyendaka14 = new ExDBFieldString<>("ztymvaariwsameyendaka14", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaariwsameyenkijyun14 = new ExDBFieldString<>("ztymvaariwsameyenkijyun14", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaariwsameyenyasu14 = new ExDBFieldString<>("ztymvaariwsameyenyasu14", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaariumsameyendaka14 = new ExDBFieldString<>("ztymvaariumsameyendaka14", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaariumsameyenkijyun14 = new ExDBFieldString<>("ztymvaariumsameyenkijyun14", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaariumsameyenyasu14 = new ExDBFieldString<>("ztymvaariumsameyenyasu14", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaariwtuktypedown14 = new ExDBFieldString<>("ztymvaariwtuktypedown14", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaariwdown14 = new ExDBFieldString<>("ztymvaariwdown14", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaariwyentuktypedown14 = new ExDBFieldString<>("ztymvaariwyentuktypedown14", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaariwdownyendaka14 = new ExDBFieldString<>("ztymvaariwdownyendaka14", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaariwdownyenkijyun14 = new ExDBFieldString<>("ztymvaariwdownyenkijyun14", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaariwdownyenyasu14 = new ExDBFieldString<>("ztymvaariwdownyenyasu14", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaariumdownyendaka14 = new ExDBFieldString<>("ztymvaariumdownyendaka14", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaariumdownyenkijyun14 = new ExDBFieldString<>("ztymvaariumdownyenkijyun14", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaariumdownyenyasu14 = new ExDBFieldString<>("ztymvaariumdownyenyasu14", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaarivtuktype14 = new ExDBFieldString<>("ztymvaarivtuktype14", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaariv14 = new ExDBFieldString<>("ztymvaariv14", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaarinenoutouym15 = new ExDBFieldString<>("ztymvaarinenoutouym15", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaariwtuktypeup15 = new ExDBFieldString<>("ztymvaariwtuktypeup15", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaariwup15 = new ExDBFieldString<>("ztymvaariwup15", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaariwyentuktypeup15 = new ExDBFieldString<>("ztymvaariwyentuktypeup15", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaariwupyendaka15 = new ExDBFieldString<>("ztymvaariwupyendaka15", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaariwupyenkijyun15 = new ExDBFieldString<>("ztymvaariwupyenkijyun15", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaariwupyenyasu15 = new ExDBFieldString<>("ztymvaariwupyenyasu15", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaariwumupyendaka15 = new ExDBFieldString<>("ztymvaariwumupyendaka15", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaariumupyenkijyun15 = new ExDBFieldString<>("ztymvaariumupyenkijyun15", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaariumupyenyasu15 = new ExDBFieldString<>("ztymvaariumupyenyasu15", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaariwtuktypesame15 = new ExDBFieldString<>("ztymvaariwtuktypesame15", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaariwsame15 = new ExDBFieldString<>("ztymvaariwsame15", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaariwyentuktypesame15 = new ExDBFieldString<>("ztymvaariwyentuktypesame15", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaariwsameyendaka15 = new ExDBFieldString<>("ztymvaariwsameyendaka15", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaariwsameyenkijyun15 = new ExDBFieldString<>("ztymvaariwsameyenkijyun15", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaariwsameyenyasu15 = new ExDBFieldString<>("ztymvaariwsameyenyasu15", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaariumsameyendaka15 = new ExDBFieldString<>("ztymvaariumsameyendaka15", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaariumsameyenkijyun15 = new ExDBFieldString<>("ztymvaariumsameyenkijyun15", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaariumsameyenyasu15 = new ExDBFieldString<>("ztymvaariumsameyenyasu15", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaariwtuktypedown15 = new ExDBFieldString<>("ztymvaariwtuktypedown15", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaariwdown15 = new ExDBFieldString<>("ztymvaariwdown15", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaariwyentuktypedown15 = new ExDBFieldString<>("ztymvaariwyentuktypedown15", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaariwdownyendaka15 = new ExDBFieldString<>("ztymvaariwdownyendaka15", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaariwdownyenkijyun15 = new ExDBFieldString<>("ztymvaariwdownyenkijyun15", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaariwdownyenyasu15 = new ExDBFieldString<>("ztymvaariwdownyenyasu15", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaariumdownyendaka15 = new ExDBFieldString<>("ztymvaariumdownyendaka15", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaariumdownyenkijyun15 = new ExDBFieldString<>("ztymvaariumdownyenkijyun15", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaariumdownyenyasu15 = new ExDBFieldString<>("ztymvaariumdownyenyasu15", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaarivtuktype15 = new ExDBFieldString<>("ztymvaarivtuktype15", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvaariv15 = new ExDBFieldString<>("ztymvaariv15", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvanonekaisiinnumukbn01 = new ExDBFieldString<>("ztymvanonekaisiinnumukbn01", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvanonenenoutouym01 = new ExDBFieldString<>("ztymvanonenenoutouym01", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvanonewtuktype01 = new ExDBFieldString<>("ztymvanonewtuktype01", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvanonew01 = new ExDBFieldString<>("ztymvanonew01", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvanonewyentuktype01 = new ExDBFieldString<>("ztymvanonewyentuktype01", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvanonewyendaka01 = new ExDBFieldString<>("ztymvanonewyendaka01", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvanonewyenkijyun01 = new ExDBFieldString<>("ztymvanonewyenkijyun01", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvanonewyenyasu01 = new ExDBFieldString<>("ztymvanonewyenyasu01", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvanoneumyendaka01 = new ExDBFieldString<>("ztymvanoneumyendaka01", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvanoneumyenkijyun01 = new ExDBFieldString<>("ztymvanoneumyenkijyun01", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvanoneumyenyasu01 = new ExDBFieldString<>("ztymvanoneumyenyasu01", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvanonevtuktype01 = new ExDBFieldString<>("ztymvanonevtuktype01", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvanonev01 = new ExDBFieldString<>("ztymvanonev01", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvanonekaisiinnumukbn02 = new ExDBFieldString<>("ztymvanonekaisiinnumukbn02", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvanonenenoutouym02 = new ExDBFieldString<>("ztymvanonenenoutouym02", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvanonewtuktype02 = new ExDBFieldString<>("ztymvanonewtuktype02", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvanonew02 = new ExDBFieldString<>("ztymvanonew02", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvanonewyentuktype02 = new ExDBFieldString<>("ztymvanonewyentuktype02", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvanonewyendaka02 = new ExDBFieldString<>("ztymvanonewyendaka02", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvanonewyenkijyun02 = new ExDBFieldString<>("ztymvanonewyenkijyun02", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvanonewyenyasu02 = new ExDBFieldString<>("ztymvanonewyenyasu02", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvanoneumyendaka02 = new ExDBFieldString<>("ztymvanoneumyendaka02", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvanoneumyenkijyun02 = new ExDBFieldString<>("ztymvanoneumyenkijyun02", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvanoneumyenyasu02 = new ExDBFieldString<>("ztymvanoneumyenyasu02", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvanonevtuktype02 = new ExDBFieldString<>("ztymvanonevtuktype02", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvanonev02 = new ExDBFieldString<>("ztymvanonev02", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvanonekaisiinnumukbn03 = new ExDBFieldString<>("ztymvanonekaisiinnumukbn03", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvanonenenoutouym03 = new ExDBFieldString<>("ztymvanonenenoutouym03", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvanonewtuktype03 = new ExDBFieldString<>("ztymvanonewtuktype03", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvanonew03 = new ExDBFieldString<>("ztymvanonew03", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvanonewyentuktype03 = new ExDBFieldString<>("ztymvanonewyentuktype03", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvanonewyendaka03 = new ExDBFieldString<>("ztymvanonewyendaka03", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvanonewyenkijyun03 = new ExDBFieldString<>("ztymvanonewyenkijyun03", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvanonewyenyasu03 = new ExDBFieldString<>("ztymvanonewyenyasu03", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvanoneumyendaka03 = new ExDBFieldString<>("ztymvanoneumyendaka03", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvanoneumyenkijyun03 = new ExDBFieldString<>("ztymvanoneumyenkijyun03", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvanoneumyenyasu03 = new ExDBFieldString<>("ztymvanoneumyenyasu03", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvanonevtuktype03 = new ExDBFieldString<>("ztymvanonevtuktype03", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvanonev03 = new ExDBFieldString<>("ztymvanonev03", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvanonekaisiinnumukbn04 = new ExDBFieldString<>("ztymvanonekaisiinnumukbn04", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvanonenenoutouym04 = new ExDBFieldString<>("ztymvanonenenoutouym04", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvanonewtuktype04 = new ExDBFieldString<>("ztymvanonewtuktype04", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvanonew04 = new ExDBFieldString<>("ztymvanonew04", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvanonewyentuktype04 = new ExDBFieldString<>("ztymvanonewyentuktype04", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvanonewyendaka04 = new ExDBFieldString<>("ztymvanonewyendaka04", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvanonewyenkijyun04 = new ExDBFieldString<>("ztymvanonewyenkijyun04", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvanonewyenyasu04 = new ExDBFieldString<>("ztymvanonewyenyasu04", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvanoneumyendaka04 = new ExDBFieldString<>("ztymvanoneumyendaka04", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvanoneumyenkijyun04 = new ExDBFieldString<>("ztymvanoneumyenkijyun04", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvanoneumyenyasu04 = new ExDBFieldString<>("ztymvanoneumyenyasu04", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvanonevtuktype04 = new ExDBFieldString<>("ztymvanonevtuktype04", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvanonev04 = new ExDBFieldString<>("ztymvanonev04", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvanonekaisiinnumukbn05 = new ExDBFieldString<>("ztymvanonekaisiinnumukbn05", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvanonenenoutouym05 = new ExDBFieldString<>("ztymvanonenenoutouym05", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvanonewtuktype05 = new ExDBFieldString<>("ztymvanonewtuktype05", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvanonew05 = new ExDBFieldString<>("ztymvanonew05", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvanonewyentuktype05 = new ExDBFieldString<>("ztymvanonewyentuktype05", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvanonewyendaka05 = new ExDBFieldString<>("ztymvanonewyendaka05", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvanonewyenkijyun05 = new ExDBFieldString<>("ztymvanonewyenkijyun05", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvanonewyenyasu05 = new ExDBFieldString<>("ztymvanonewyenyasu05", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvanoneumyendaka05 = new ExDBFieldString<>("ztymvanoneumyendaka05", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvanoneumyenkijyun05 = new ExDBFieldString<>("ztymvanoneumyenkijyun05", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvanoneumyenyasu05 = new ExDBFieldString<>("ztymvanoneumyenyasu05", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvanonevtuktype05 = new ExDBFieldString<>("ztymvanonevtuktype05", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvanonev05 = new ExDBFieldString<>("ztymvanonev05", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvanonekaisiinnumukbn06 = new ExDBFieldString<>("ztymvanonekaisiinnumukbn06", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvanonenenoutouym06 = new ExDBFieldString<>("ztymvanonenenoutouym06", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvanonewtuktype06 = new ExDBFieldString<>("ztymvanonewtuktype06", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvanonew06 = new ExDBFieldString<>("ztymvanonew06", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvanonewyentuktype06 = new ExDBFieldString<>("ztymvanonewyentuktype06", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvanonewyendaka06 = new ExDBFieldString<>("ztymvanonewyendaka06", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvanonewyenkijyun06 = new ExDBFieldString<>("ztymvanonewyenkijyun06", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvanonewyenyasu06 = new ExDBFieldString<>("ztymvanonewyenyasu06", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvanoneumyendaka06 = new ExDBFieldString<>("ztymvanoneumyendaka06", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvanoneumyenkijyun06 = new ExDBFieldString<>("ztymvanoneumyenkijyun06", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvanoneumyenyasu06 = new ExDBFieldString<>("ztymvanoneumyenyasu06", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvanonevtuktype06 = new ExDBFieldString<>("ztymvanonevtuktype06", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvanonev06 = new ExDBFieldString<>("ztymvanonev06", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvanonekaisiinnumukbn07 = new ExDBFieldString<>("ztymvanonekaisiinnumukbn07", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvanonenenoutouym07 = new ExDBFieldString<>("ztymvanonenenoutouym07", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvanonewtuktype07 = new ExDBFieldString<>("ztymvanonewtuktype07", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvanonew07 = new ExDBFieldString<>("ztymvanonew07", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvanonewyentuktype07 = new ExDBFieldString<>("ztymvanonewyentuktype07", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvanonewyendaka07 = new ExDBFieldString<>("ztymvanonewyendaka07", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvanonewyenkijyun07 = new ExDBFieldString<>("ztymvanonewyenkijyun07", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvanonewyenyasu07 = new ExDBFieldString<>("ztymvanonewyenyasu07", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvanoneumyendaka07 = new ExDBFieldString<>("ztymvanoneumyendaka07", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvanoneumyenkijyun07 = new ExDBFieldString<>("ztymvanoneumyenkijyun07", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvanoneumyenyasu07 = new ExDBFieldString<>("ztymvanoneumyenyasu07", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvanonevtuktype07 = new ExDBFieldString<>("ztymvanonevtuktype07", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvanonev07 = new ExDBFieldString<>("ztymvanonev07", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvanonekaisiinnumukbn08 = new ExDBFieldString<>("ztymvanonekaisiinnumukbn08", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvanonenenoutouym08 = new ExDBFieldString<>("ztymvanonenenoutouym08", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvanonewtuktype08 = new ExDBFieldString<>("ztymvanonewtuktype08", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvanonew08 = new ExDBFieldString<>("ztymvanonew08", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvanonewyentuktype08 = new ExDBFieldString<>("ztymvanonewyentuktype08", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvanonewyendaka08 = new ExDBFieldString<>("ztymvanonewyendaka08", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvanonewyenkijyun08 = new ExDBFieldString<>("ztymvanonewyenkijyun08", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvanonewyenyasu08 = new ExDBFieldString<>("ztymvanonewyenyasu08", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvanoneumyendaka08 = new ExDBFieldString<>("ztymvanoneumyendaka08", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvanoneumyenkijyun08 = new ExDBFieldString<>("ztymvanoneumyenkijyun08", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvanoneumyenyasu08 = new ExDBFieldString<>("ztymvanoneumyenyasu08", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvanonevtuktype08 = new ExDBFieldString<>("ztymvanonevtuktype08", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvanonev08 = new ExDBFieldString<>("ztymvanonev08", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvanonekaisiinnumukbn09 = new ExDBFieldString<>("ztymvanonekaisiinnumukbn09", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvanonenenoutouym09 = new ExDBFieldString<>("ztymvanonenenoutouym09", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvanonewtuktype09 = new ExDBFieldString<>("ztymvanonewtuktype09", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvanonew09 = new ExDBFieldString<>("ztymvanonew09", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvanonewyentuktype09 = new ExDBFieldString<>("ztymvanonewyentuktype09", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvanonewyendaka09 = new ExDBFieldString<>("ztymvanonewyendaka09", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvanonewyenkijyun09 = new ExDBFieldString<>("ztymvanonewyenkijyun09", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvanonewyenyasu09 = new ExDBFieldString<>("ztymvanonewyenyasu09", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvanoneumyendaka09 = new ExDBFieldString<>("ztymvanoneumyendaka09", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvanoneumyenkijyun09 = new ExDBFieldString<>("ztymvanoneumyenkijyun09", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvanoneumyenyasu09 = new ExDBFieldString<>("ztymvanoneumyenyasu09", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvanonevtuktype09 = new ExDBFieldString<>("ztymvanonevtuktype09", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvanonev09 = new ExDBFieldString<>("ztymvanonev09", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvanonekaisiinnumukbn10 = new ExDBFieldString<>("ztymvanonekaisiinnumukbn10", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvanonenenoutouym10 = new ExDBFieldString<>("ztymvanonenenoutouym10", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvanonewtuktype10 = new ExDBFieldString<>("ztymvanonewtuktype10", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvanonew10 = new ExDBFieldString<>("ztymvanonew10", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvanonewyentuktype10 = new ExDBFieldString<>("ztymvanonewyentuktype10", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvanonewyendaka10 = new ExDBFieldString<>("ztymvanonewyendaka10", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvanonewyenkijyun10 = new ExDBFieldString<>("ztymvanonewyenkijyun10", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvanonewyenyasu10 = new ExDBFieldString<>("ztymvanonewyenyasu10", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvanoneumyendaka10 = new ExDBFieldString<>("ztymvanoneumyendaka10", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvanoneumyenkijyun10 = new ExDBFieldString<>("ztymvanoneumyenkijyun10", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvanoneumyenyasu10 = new ExDBFieldString<>("ztymvanoneumyenyasu10", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvanonevtuktype10 = new ExDBFieldString<>("ztymvanonevtuktype10", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvanonev10 = new ExDBFieldString<>("ztymvanonev10", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvanonekaisiinnumukbn11 = new ExDBFieldString<>("ztymvanonekaisiinnumukbn11", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvanonenenoutouym11 = new ExDBFieldString<>("ztymvanonenenoutouym11", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvanonewtuktype11 = new ExDBFieldString<>("ztymvanonewtuktype11", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvanonew11 = new ExDBFieldString<>("ztymvanonew11", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvanonewyentuktype11 = new ExDBFieldString<>("ztymvanonewyentuktype11", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvanonewyendaka11 = new ExDBFieldString<>("ztymvanonewyendaka11", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvanonewyenkijyun11 = new ExDBFieldString<>("ztymvanonewyenkijyun11", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvanonewyenyasu11 = new ExDBFieldString<>("ztymvanonewyenyasu11", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvanoneumyendaka11 = new ExDBFieldString<>("ztymvanoneumyendaka11", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvanoneumyenkijyun11 = new ExDBFieldString<>("ztymvanoneumyenkijyun11", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvanoneumyenyasu11 = new ExDBFieldString<>("ztymvanoneumyenyasu11", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvanonevtuktype11 = new ExDBFieldString<>("ztymvanonevtuktype11", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvanonev11 = new ExDBFieldString<>("ztymvanonev11", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvanonekaisiinnumukbn12 = new ExDBFieldString<>("ztymvanonekaisiinnumukbn12", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvanonenenoutouym12 = new ExDBFieldString<>("ztymvanonenenoutouym12", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvanonewtuktype12 = new ExDBFieldString<>("ztymvanonewtuktype12", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvanonew12 = new ExDBFieldString<>("ztymvanonew12", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvanonewyentuktype12 = new ExDBFieldString<>("ztymvanonewyentuktype12", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvanonewyendaka12 = new ExDBFieldString<>("ztymvanonewyendaka12", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvanonewyenkijyun12 = new ExDBFieldString<>("ztymvanonewyenkijyun12", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvanonewyenyasu12 = new ExDBFieldString<>("ztymvanonewyenyasu12", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvanoneumyendaka12 = new ExDBFieldString<>("ztymvanoneumyendaka12", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvanoneumyenkijyun12 = new ExDBFieldString<>("ztymvanoneumyenkijyun12", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvanoneumyenyasu12 = new ExDBFieldString<>("ztymvanoneumyenyasu12", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvanonevtuktype12 = new ExDBFieldString<>("ztymvanonevtuktype12", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvanonev12 = new ExDBFieldString<>("ztymvanonev12", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvanonekaisiinnumukbn13 = new ExDBFieldString<>("ztymvanonekaisiinnumukbn13", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvanonenenoutouym13 = new ExDBFieldString<>("ztymvanonenenoutouym13", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvanonewtuktype13 = new ExDBFieldString<>("ztymvanonewtuktype13", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvanonew13 = new ExDBFieldString<>("ztymvanonew13", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvanonewyentuktype13 = new ExDBFieldString<>("ztymvanonewyentuktype13", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvanonewyendaka13 = new ExDBFieldString<>("ztymvanonewyendaka13", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvanonewyenkijyun13 = new ExDBFieldString<>("ztymvanonewyenkijyun13", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvanonewyenyasu13 = new ExDBFieldString<>("ztymvanonewyenyasu13", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvanoneumyendaka13 = new ExDBFieldString<>("ztymvanoneumyendaka13", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvanoneumyenkijyun13 = new ExDBFieldString<>("ztymvanoneumyenkijyun13", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvanoneumyenyasu13 = new ExDBFieldString<>("ztymvanoneumyenyasu13", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvanonevtuktype13 = new ExDBFieldString<>("ztymvanonevtuktype13", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvanonev13 = new ExDBFieldString<>("ztymvanonev13", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvanonekaisiinnumukbn14 = new ExDBFieldString<>("ztymvanonekaisiinnumukbn14", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvanonenenoutouym14 = new ExDBFieldString<>("ztymvanonenenoutouym14", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvanonewtuktype14 = new ExDBFieldString<>("ztymvanonewtuktype14", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvanonew14 = new ExDBFieldString<>("ztymvanonew14", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvanonewyentuktype14 = new ExDBFieldString<>("ztymvanonewyentuktype14", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvanonewyendaka14 = new ExDBFieldString<>("ztymvanonewyendaka14", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvanonewyenkijyun14 = new ExDBFieldString<>("ztymvanonewyenkijyun14", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvanonewyenyasu14 = new ExDBFieldString<>("ztymvanonewyenyasu14", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvanoneumyendaka14 = new ExDBFieldString<>("ztymvanoneumyendaka14", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvanoneumyenkijyun14 = new ExDBFieldString<>("ztymvanoneumyenkijyun14", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvanoneumyenyasu14 = new ExDBFieldString<>("ztymvanoneumyenyasu14", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvanonevtuktype14 = new ExDBFieldString<>("ztymvanonevtuktype14", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztymvanonev14 = new ExDBFieldString<>("ztymvanonev14", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztywmsgcd1 = new ExDBFieldString<>("ztywmsgcd1", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztywmsgcd2 = new ExDBFieldString<>("ztywmsgcd2", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztywmsgcd3 = new ExDBFieldString<>("ztywmsgcd3", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztywmsgcd21 = new ExDBFieldString<>("ztywmsgcd21", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztywmsgcd22 = new ExDBFieldString<>("ztywmsgcd22", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztywmsgcd23 = new ExDBFieldString<>("ztywmsgcd23", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztywmsgcd31 = new ExDBFieldString<>("ztywmsgcd31", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztywmsgcd32 = new ExDBFieldString<>("ztywmsgcd32", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztywmsgcd33 = new ExDBFieldString<>("ztywmsgcd33", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztywmsgcdst1 = new ExDBFieldString<>("ztywmsgcdst1", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztywtyuuimsgcd1 = new ExDBFieldString<>("ztywtyuuimsgcd1", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztywtyuuimsgcd2 = new ExDBFieldString<>("ztywtyuuimsgcd2", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztywtyuuimsgcd3 = new ExDBFieldString<>("ztywtyuuimsgcd3", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztywtyuuimsgcd4 = new ExDBFieldString<>("ztywtyuuimsgcd4", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztywtyuuimsgcd5 = new ExDBFieldString<>("ztywtyuuimsgcd5", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztywtyuuimsgcd6 = new ExDBFieldString<>("ztywtyuuimsgcd6", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztywtyuuimsgcd7 = new ExDBFieldString<>("ztywtyuuimsgcd7", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztywitjbrptuuktype = new ExDBFieldString<>("ztywitjbrptuuktype", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztywitjbrp = new ExDBFieldString<>("ztywitjbrp", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztywyenhrikmgktuuktype = new ExDBFieldString<>("ztywyenhrikmgktuuktype", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztywyenhrikmgk = new ExDBFieldString<>("ztywyenhrikmgk", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztywyenitjbrptuuktype = new ExDBFieldString<>("ztywyenitjbrptuuktype", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztywyenitjbrp = new ExDBFieldString<>("ztywyenitjbrp", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztywsjkkktyouseitkyuym = new ExDBFieldString<>("ztywsjkkktyouseitkyuym", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztyhrkkknmnryym = new ExDBFieldString<>("ztyhrkkknmnryym", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztyhrkkknmnrynen = new ExDBFieldString<>("ztyhrkkknmnrynen", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztyyobiv200 = new ExDBFieldString<>("ztyyobiv200", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiTy, String> ztyyobiv49 = new ExDBFieldString<>("ztyyobiv49", this);
}
