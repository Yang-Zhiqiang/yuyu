package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.db.entity.ZT_SaihakkouSyoukenSuiiRn;

/**
 * 再発行保険証券推移表Ｆテーブル（連） のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQZT_SaihakkouSyoukenSuiiRn extends AbstractExDBTable<ZT_SaihakkouSyoukenSuiiRn> {

    public GenQZT_SaihakkouSyoukenSuiiRn() {
        this("ZT_SaihakkouSyoukenSuiiRn");
    }

    public GenQZT_SaihakkouSyoukenSuiiRn(String pAlias) {
        super("ZT_SaihakkouSyoukenSuiiRn", ZT_SaihakkouSyoukenSuiiRn.class, pAlias);
    }

    public String ZT_SaihakkouSyoukenSuiiRn() {
        return getAliasExpression();
    }

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnsyono = new ExDBFieldString<>("zrnsyono", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrntyouhyouymd = new ExDBFieldString<>("zrntyouhyouymd", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnsuiihyouptn = new ExDBFieldString<>("zrnsuiihyouptn", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnsuiihyousykbn = new ExDBFieldString<>("zrnsuiihyousykbn", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnsuiihyousyono = new ExDBFieldString<>("zrnsuiihyousyono", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnsisuuupritu = new ExDBFieldString<>("zrnsisuuupritu", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnsaisyuunndym = new ExDBFieldString<>("zrnsaisyuunndym", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnsjkkktusirrtup = new ExDBFieldString<>("zrnsjkkktusirrtup", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnsjkkktusirrtsame = new ExDBFieldString<>("zrnsjkkktusirrtsame", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnsjkkktusirrtdown = new ExDBFieldString<>("zrnsjkkktusirrtdown", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnsjkkktusirrthendouup = new ExDBFieldString<>("zrnsjkkktusirrthendouup", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnsjkkktusirrthendoudown = new ExDBFieldString<>("zrnsjkkktusirrthendoudown", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnwkwsrateyendaka = new ExDBFieldString<>("zrnwkwsrateyendaka", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnwkwsrateyenkijyun = new ExDBFieldString<>("zrnwkwsrateyenkijyun", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnwkwsrateyenyasu = new ExDBFieldString<>("zrnwkwsrateyenyasu", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnsuiihyoumkhyouyenwra = new ExDBFieldString<>("zrnsuiihyoumkhyouyenwra", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaarinenoutouym01 = new ExDBFieldString<>("zrnmvaarinenoutouym01", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaarisisuuupritu01 = new ExDBFieldString<>("zrnmvaarisisuuupritu01", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaaritmttknzkritu01 = new ExDBFieldString<>("zrnmvaaritmttknzkritu01", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaariwtuktypeup01 = new ExDBFieldString<>("zrnmvaariwtuktypeup01", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaaritmttknkykkjmup01 = new ExDBFieldString<>("zrnmvaaritmttknkykkjmup01", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaariwup01 = new ExDBFieldString<>("zrnmvaariwup01", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaariwyentuktypeup01 = new ExDBFieldString<>("zrnmvaariwyentuktypeup01", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaariwupyendaka01 = new ExDBFieldString<>("zrnmvaariwupyendaka01", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaariwupyenkijyun01 = new ExDBFieldString<>("zrnmvaariwupyenkijyun01", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaariwupyenyasu01 = new ExDBFieldString<>("zrnmvaariwupyenyasu01", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaariwumupyendaka01 = new ExDBFieldString<>("zrnmvaariwumupyendaka01", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaariumupyenkijyun01 = new ExDBFieldString<>("zrnmvaariumupyenkijyun01", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaariumupyenyasu01 = new ExDBFieldString<>("zrnmvaariumupyenyasu01", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaariwtuktypesame01 = new ExDBFieldString<>("zrnmvaariwtuktypesame01", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaaritmttknkykkjmsame01 = new ExDBFieldString<>("zrnmvaaritmttknkykkjmsame01", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaariwsame01 = new ExDBFieldString<>("zrnmvaariwsame01", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaariwyentuktypesame01 = new ExDBFieldString<>("zrnmvaariwyentuktypesame01", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaariwsameyendaka01 = new ExDBFieldString<>("zrnmvaariwsameyendaka01", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaariwsameyenkijyun01 = new ExDBFieldString<>("zrnmvaariwsameyenkijyun01", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaariwsameyenyasu01 = new ExDBFieldString<>("zrnmvaariwsameyenyasu01", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaariumsameyendaka01 = new ExDBFieldString<>("zrnmvaariumsameyendaka01", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaariumsameyenkijyun01 = new ExDBFieldString<>("zrnmvaariumsameyenkijyun01", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaariumsameyenyasu01 = new ExDBFieldString<>("zrnmvaariumsameyenyasu01", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaariwtuktypedown01 = new ExDBFieldString<>("zrnmvaariwtuktypedown01", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaaritmttknkykkjmdown01 = new ExDBFieldString<>("zrnmvaaritmttknkykkjmdown01", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaariwdown01 = new ExDBFieldString<>("zrnmvaariwdown01", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaariwyentuktypedown01 = new ExDBFieldString<>("zrnmvaariwyentuktypedown01", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaariwdownyendaka01 = new ExDBFieldString<>("zrnmvaariwdownyendaka01", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaariwdownyenkijyun01 = new ExDBFieldString<>("zrnmvaariwdownyenkijyun01", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaariwdownyenyasu01 = new ExDBFieldString<>("zrnmvaariwdownyenyasu01", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaariumdownyendaka01 = new ExDBFieldString<>("zrnmvaariumdownyendaka01", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaariumdownyenkijyun01 = new ExDBFieldString<>("zrnmvaariumdownyenkijyun01", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaariumdownyenyasu01 = new ExDBFieldString<>("zrnmvaariumdownyenyasu01", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaarivtuktype01 = new ExDBFieldString<>("zrnmvaarivtuktype01", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaariv01 = new ExDBFieldString<>("zrnmvaariv01", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnptmttkngkutiwake101 = new ExDBFieldString<>("zrnptmttkngkutiwake101", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnptmttkngkutiwake201 = new ExDBFieldString<>("zrnptmttkngkutiwake201", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaarinenoutouym02 = new ExDBFieldString<>("zrnmvaarinenoutouym02", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaarisisuuupritu02 = new ExDBFieldString<>("zrnmvaarisisuuupritu02", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaaritmttknzkritu02 = new ExDBFieldString<>("zrnmvaaritmttknzkritu02", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaariwtuktypeup02 = new ExDBFieldString<>("zrnmvaariwtuktypeup02", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaaritmttknkykkjmup02 = new ExDBFieldString<>("zrnmvaaritmttknkykkjmup02", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaariwup02 = new ExDBFieldString<>("zrnmvaariwup02", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaariwyentuktypeup02 = new ExDBFieldString<>("zrnmvaariwyentuktypeup02", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaariwupyendaka02 = new ExDBFieldString<>("zrnmvaariwupyendaka02", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaariwupyenkijyun02 = new ExDBFieldString<>("zrnmvaariwupyenkijyun02", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaariwupyenyasu02 = new ExDBFieldString<>("zrnmvaariwupyenyasu02", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaariwumupyendaka02 = new ExDBFieldString<>("zrnmvaariwumupyendaka02", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaariumupyenkijyun02 = new ExDBFieldString<>("zrnmvaariumupyenkijyun02", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaariumupyenyasu02 = new ExDBFieldString<>("zrnmvaariumupyenyasu02", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaariwtuktypesame02 = new ExDBFieldString<>("zrnmvaariwtuktypesame02", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaaritmttknkykkjmsame02 = new ExDBFieldString<>("zrnmvaaritmttknkykkjmsame02", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaariwsame02 = new ExDBFieldString<>("zrnmvaariwsame02", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaariwyentuktypesame02 = new ExDBFieldString<>("zrnmvaariwyentuktypesame02", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaariwsameyendaka02 = new ExDBFieldString<>("zrnmvaariwsameyendaka02", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaariwsameyenkijyun02 = new ExDBFieldString<>("zrnmvaariwsameyenkijyun02", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaariwsameyenyasu02 = new ExDBFieldString<>("zrnmvaariwsameyenyasu02", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaariumsameyendaka02 = new ExDBFieldString<>("zrnmvaariumsameyendaka02", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaariumsameyenkijyun02 = new ExDBFieldString<>("zrnmvaariumsameyenkijyun02", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaariumsameyenyasu02 = new ExDBFieldString<>("zrnmvaariumsameyenyasu02", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaariwtuktypedown02 = new ExDBFieldString<>("zrnmvaariwtuktypedown02", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaaritmttknkykkjmdown02 = new ExDBFieldString<>("zrnmvaaritmttknkykkjmdown02", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaariwdown02 = new ExDBFieldString<>("zrnmvaariwdown02", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaariwyentuktypedown02 = new ExDBFieldString<>("zrnmvaariwyentuktypedown02", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaariwdownyendaka02 = new ExDBFieldString<>("zrnmvaariwdownyendaka02", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaariwdownyenkijyun02 = new ExDBFieldString<>("zrnmvaariwdownyenkijyun02", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaariwdownyenyasu02 = new ExDBFieldString<>("zrnmvaariwdownyenyasu02", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaariumdownyendaka02 = new ExDBFieldString<>("zrnmvaariumdownyendaka02", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaariumdownyenkijyun02 = new ExDBFieldString<>("zrnmvaariumdownyenkijyun02", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaariumdownyenyasu02 = new ExDBFieldString<>("zrnmvaariumdownyenyasu02", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaarivtuktype02 = new ExDBFieldString<>("zrnmvaarivtuktype02", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaariv02 = new ExDBFieldString<>("zrnmvaariv02", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnptmttkngkutiwake102 = new ExDBFieldString<>("zrnptmttkngkutiwake102", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnptmttkngkutiwake202 = new ExDBFieldString<>("zrnptmttkngkutiwake202", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaarinenoutouym03 = new ExDBFieldString<>("zrnmvaarinenoutouym03", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaarisisuuupritu03 = new ExDBFieldString<>("zrnmvaarisisuuupritu03", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaaritmttknzkritu03 = new ExDBFieldString<>("zrnmvaaritmttknzkritu03", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaariwtuktypeup03 = new ExDBFieldString<>("zrnmvaariwtuktypeup03", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaaritmttknkykkjmup03 = new ExDBFieldString<>("zrnmvaaritmttknkykkjmup03", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaariwup03 = new ExDBFieldString<>("zrnmvaariwup03", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaariwyentuktypeup03 = new ExDBFieldString<>("zrnmvaariwyentuktypeup03", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaariwupyendaka03 = new ExDBFieldString<>("zrnmvaariwupyendaka03", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaariwupyenkijyun03 = new ExDBFieldString<>("zrnmvaariwupyenkijyun03", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaariwupyenyasu03 = new ExDBFieldString<>("zrnmvaariwupyenyasu03", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaariwumupyendaka03 = new ExDBFieldString<>("zrnmvaariwumupyendaka03", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaariumupyenkijyun03 = new ExDBFieldString<>("zrnmvaariumupyenkijyun03", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaariumupyenyasu03 = new ExDBFieldString<>("zrnmvaariumupyenyasu03", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaariwtuktypesame03 = new ExDBFieldString<>("zrnmvaariwtuktypesame03", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaaritmttknkykkjmsame03 = new ExDBFieldString<>("zrnmvaaritmttknkykkjmsame03", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaariwsame03 = new ExDBFieldString<>("zrnmvaariwsame03", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaariwyentuktypesame03 = new ExDBFieldString<>("zrnmvaariwyentuktypesame03", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaariwsameyendaka03 = new ExDBFieldString<>("zrnmvaariwsameyendaka03", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaariwsameyenkijyun03 = new ExDBFieldString<>("zrnmvaariwsameyenkijyun03", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaariwsameyenyasu03 = new ExDBFieldString<>("zrnmvaariwsameyenyasu03", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaariumsameyendaka03 = new ExDBFieldString<>("zrnmvaariumsameyendaka03", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaariumsameyenkijyun03 = new ExDBFieldString<>("zrnmvaariumsameyenkijyun03", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaariumsameyenyasu03 = new ExDBFieldString<>("zrnmvaariumsameyenyasu03", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaariwtuktypedown03 = new ExDBFieldString<>("zrnmvaariwtuktypedown03", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaaritmttknkykkjmdown03 = new ExDBFieldString<>("zrnmvaaritmttknkykkjmdown03", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaariwdown03 = new ExDBFieldString<>("zrnmvaariwdown03", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaariwyentuktypedown03 = new ExDBFieldString<>("zrnmvaariwyentuktypedown03", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaariwdownyendaka03 = new ExDBFieldString<>("zrnmvaariwdownyendaka03", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaariwdownyenkijyun03 = new ExDBFieldString<>("zrnmvaariwdownyenkijyun03", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaariwdownyenyasu03 = new ExDBFieldString<>("zrnmvaariwdownyenyasu03", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaariumdownyendaka03 = new ExDBFieldString<>("zrnmvaariumdownyendaka03", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaariumdownyenkijyun03 = new ExDBFieldString<>("zrnmvaariumdownyenkijyun03", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaariumdownyenyasu03 = new ExDBFieldString<>("zrnmvaariumdownyenyasu03", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaarivtuktype03 = new ExDBFieldString<>("zrnmvaarivtuktype03", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaariv03 = new ExDBFieldString<>("zrnmvaariv03", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnptmttkngkutiwake103 = new ExDBFieldString<>("zrnptmttkngkutiwake103", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnptmttkngkutiwake203 = new ExDBFieldString<>("zrnptmttkngkutiwake203", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaarinenoutouym04 = new ExDBFieldString<>("zrnmvaarinenoutouym04", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaarisisuuupritu04 = new ExDBFieldString<>("zrnmvaarisisuuupritu04", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaaritmttknzkritu04 = new ExDBFieldString<>("zrnmvaaritmttknzkritu04", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaariwtuktypeup04 = new ExDBFieldString<>("zrnmvaariwtuktypeup04", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaaritmttknkykkjmup04 = new ExDBFieldString<>("zrnmvaaritmttknkykkjmup04", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaariwup04 = new ExDBFieldString<>("zrnmvaariwup04", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaariwyentuktypeup04 = new ExDBFieldString<>("zrnmvaariwyentuktypeup04", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaariwupyendaka04 = new ExDBFieldString<>("zrnmvaariwupyendaka04", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaariwupyenkijyun04 = new ExDBFieldString<>("zrnmvaariwupyenkijyun04", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaariwupyenyasu04 = new ExDBFieldString<>("zrnmvaariwupyenyasu04", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaariwumupyendaka04 = new ExDBFieldString<>("zrnmvaariwumupyendaka04", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaariumupyenkijyun04 = new ExDBFieldString<>("zrnmvaariumupyenkijyun04", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaariumupyenyasu04 = new ExDBFieldString<>("zrnmvaariumupyenyasu04", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaariwtuktypesame04 = new ExDBFieldString<>("zrnmvaariwtuktypesame04", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaaritmttknkykkjmsame04 = new ExDBFieldString<>("zrnmvaaritmttknkykkjmsame04", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaariwsame04 = new ExDBFieldString<>("zrnmvaariwsame04", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaariwyentuktypesame04 = new ExDBFieldString<>("zrnmvaariwyentuktypesame04", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaariwsameyendaka04 = new ExDBFieldString<>("zrnmvaariwsameyendaka04", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaariwsameyenkijyun04 = new ExDBFieldString<>("zrnmvaariwsameyenkijyun04", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaariwsameyenyasu04 = new ExDBFieldString<>("zrnmvaariwsameyenyasu04", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaariumsameyendaka04 = new ExDBFieldString<>("zrnmvaariumsameyendaka04", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaariumsameyenkijyun04 = new ExDBFieldString<>("zrnmvaariumsameyenkijyun04", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaariumsameyenyasu04 = new ExDBFieldString<>("zrnmvaariumsameyenyasu04", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaariwtuktypedown04 = new ExDBFieldString<>("zrnmvaariwtuktypedown04", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaaritmttknkykkjmdown04 = new ExDBFieldString<>("zrnmvaaritmttknkykkjmdown04", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaariwdown04 = new ExDBFieldString<>("zrnmvaariwdown04", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaariwyentuktypedown04 = new ExDBFieldString<>("zrnmvaariwyentuktypedown04", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaariwdownyendaka04 = new ExDBFieldString<>("zrnmvaariwdownyendaka04", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaariwdownyenkijyun04 = new ExDBFieldString<>("zrnmvaariwdownyenkijyun04", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaariwdownyenyasu04 = new ExDBFieldString<>("zrnmvaariwdownyenyasu04", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaariumdownyendaka04 = new ExDBFieldString<>("zrnmvaariumdownyendaka04", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaariumdownyenkijyun04 = new ExDBFieldString<>("zrnmvaariumdownyenkijyun04", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaariumdownyenyasu04 = new ExDBFieldString<>("zrnmvaariumdownyenyasu04", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaarivtuktype04 = new ExDBFieldString<>("zrnmvaarivtuktype04", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaariv04 = new ExDBFieldString<>("zrnmvaariv04", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnptmttkngkutiwake104 = new ExDBFieldString<>("zrnptmttkngkutiwake104", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnptmttkngkutiwake204 = new ExDBFieldString<>("zrnptmttkngkutiwake204", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaarinenoutouym05 = new ExDBFieldString<>("zrnmvaarinenoutouym05", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaarisisuuupritu05 = new ExDBFieldString<>("zrnmvaarisisuuupritu05", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaaritmttknzkritu05 = new ExDBFieldString<>("zrnmvaaritmttknzkritu05", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaariwtuktypeup05 = new ExDBFieldString<>("zrnmvaariwtuktypeup05", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaaritmttknkykkjmup05 = new ExDBFieldString<>("zrnmvaaritmttknkykkjmup05", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaariwup05 = new ExDBFieldString<>("zrnmvaariwup05", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaariwyentuktypeup05 = new ExDBFieldString<>("zrnmvaariwyentuktypeup05", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaariwupyendaka05 = new ExDBFieldString<>("zrnmvaariwupyendaka05", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaariwupyenkijyun05 = new ExDBFieldString<>("zrnmvaariwupyenkijyun05", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaariwupyenyasu05 = new ExDBFieldString<>("zrnmvaariwupyenyasu05", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaariwumupyendaka05 = new ExDBFieldString<>("zrnmvaariwumupyendaka05", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaariumupyenkijyun05 = new ExDBFieldString<>("zrnmvaariumupyenkijyun05", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaariumupyenyasu05 = new ExDBFieldString<>("zrnmvaariumupyenyasu05", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaariwtuktypesame05 = new ExDBFieldString<>("zrnmvaariwtuktypesame05", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaaritmttknkykkjmsame05 = new ExDBFieldString<>("zrnmvaaritmttknkykkjmsame05", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaariwsame05 = new ExDBFieldString<>("zrnmvaariwsame05", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaariwyentuktypesame05 = new ExDBFieldString<>("zrnmvaariwyentuktypesame05", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaariwsameyendaka05 = new ExDBFieldString<>("zrnmvaariwsameyendaka05", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaariwsameyenkijyun05 = new ExDBFieldString<>("zrnmvaariwsameyenkijyun05", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaariwsameyenyasu05 = new ExDBFieldString<>("zrnmvaariwsameyenyasu05", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaariumsameyendaka05 = new ExDBFieldString<>("zrnmvaariumsameyendaka05", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaariumsameyenkijyun05 = new ExDBFieldString<>("zrnmvaariumsameyenkijyun05", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaariumsameyenyasu05 = new ExDBFieldString<>("zrnmvaariumsameyenyasu05", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaariwtuktypedown05 = new ExDBFieldString<>("zrnmvaariwtuktypedown05", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaaritmttknkykkjmdown05 = new ExDBFieldString<>("zrnmvaaritmttknkykkjmdown05", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaariwdown05 = new ExDBFieldString<>("zrnmvaariwdown05", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaariwyentuktypedown05 = new ExDBFieldString<>("zrnmvaariwyentuktypedown05", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaariwdownyendaka05 = new ExDBFieldString<>("zrnmvaariwdownyendaka05", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaariwdownyenkijyun05 = new ExDBFieldString<>("zrnmvaariwdownyenkijyun05", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaariwdownyenyasu05 = new ExDBFieldString<>("zrnmvaariwdownyenyasu05", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaariumdownyendaka05 = new ExDBFieldString<>("zrnmvaariumdownyendaka05", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaariumdownyenkijyun05 = new ExDBFieldString<>("zrnmvaariumdownyenkijyun05", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaariumdownyenyasu05 = new ExDBFieldString<>("zrnmvaariumdownyenyasu05", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaarivtuktype05 = new ExDBFieldString<>("zrnmvaarivtuktype05", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaariv05 = new ExDBFieldString<>("zrnmvaariv05", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnptmttkngkutiwake105 = new ExDBFieldString<>("zrnptmttkngkutiwake105", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnptmttkngkutiwake205 = new ExDBFieldString<>("zrnptmttkngkutiwake205", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaarinenoutouym06 = new ExDBFieldString<>("zrnmvaarinenoutouym06", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaarisisuuupritu06 = new ExDBFieldString<>("zrnmvaarisisuuupritu06", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaaritmttknzkritu06 = new ExDBFieldString<>("zrnmvaaritmttknzkritu06", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaariwtuktypeup06 = new ExDBFieldString<>("zrnmvaariwtuktypeup06", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaaritmttknkykkjmup06 = new ExDBFieldString<>("zrnmvaaritmttknkykkjmup06", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaariwup06 = new ExDBFieldString<>("zrnmvaariwup06", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaariwyentuktypeup06 = new ExDBFieldString<>("zrnmvaariwyentuktypeup06", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaariwupyendaka06 = new ExDBFieldString<>("zrnmvaariwupyendaka06", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaariwupyenkijyun06 = new ExDBFieldString<>("zrnmvaariwupyenkijyun06", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaariwupyenyasu06 = new ExDBFieldString<>("zrnmvaariwupyenyasu06", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaariwumupyendaka06 = new ExDBFieldString<>("zrnmvaariwumupyendaka06", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaariumupyenkijyun06 = new ExDBFieldString<>("zrnmvaariumupyenkijyun06", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaariumupyenyasu06 = new ExDBFieldString<>("zrnmvaariumupyenyasu06", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaariwtuktypesame06 = new ExDBFieldString<>("zrnmvaariwtuktypesame06", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaaritmttknkykkjmsame06 = new ExDBFieldString<>("zrnmvaaritmttknkykkjmsame06", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaariwsame06 = new ExDBFieldString<>("zrnmvaariwsame06", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaariwyentuktypesame06 = new ExDBFieldString<>("zrnmvaariwyentuktypesame06", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaariwsameyendaka06 = new ExDBFieldString<>("zrnmvaariwsameyendaka06", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaariwsameyenkijyun06 = new ExDBFieldString<>("zrnmvaariwsameyenkijyun06", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaariwsameyenyasu06 = new ExDBFieldString<>("zrnmvaariwsameyenyasu06", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaariumsameyendaka06 = new ExDBFieldString<>("zrnmvaariumsameyendaka06", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaariumsameyenkijyun06 = new ExDBFieldString<>("zrnmvaariumsameyenkijyun06", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaariumsameyenyasu06 = new ExDBFieldString<>("zrnmvaariumsameyenyasu06", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaariwtuktypedown06 = new ExDBFieldString<>("zrnmvaariwtuktypedown06", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaaritmttknkykkjmdown06 = new ExDBFieldString<>("zrnmvaaritmttknkykkjmdown06", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaariwdown06 = new ExDBFieldString<>("zrnmvaariwdown06", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaariwyentuktypedown06 = new ExDBFieldString<>("zrnmvaariwyentuktypedown06", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaariwdownyendaka06 = new ExDBFieldString<>("zrnmvaariwdownyendaka06", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaariwdownyenkijyun06 = new ExDBFieldString<>("zrnmvaariwdownyenkijyun06", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaariwdownyenyasu06 = new ExDBFieldString<>("zrnmvaariwdownyenyasu06", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaariumdownyendaka06 = new ExDBFieldString<>("zrnmvaariumdownyendaka06", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaariumdownyenkijyun06 = new ExDBFieldString<>("zrnmvaariumdownyenkijyun06", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaariumdownyenyasu06 = new ExDBFieldString<>("zrnmvaariumdownyenyasu06", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaarivtuktype06 = new ExDBFieldString<>("zrnmvaarivtuktype06", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaariv06 = new ExDBFieldString<>("zrnmvaariv06", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnptmttkngkutiwake106 = new ExDBFieldString<>("zrnptmttkngkutiwake106", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnptmttkngkutiwake206 = new ExDBFieldString<>("zrnptmttkngkutiwake206", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaarinenoutouym07 = new ExDBFieldString<>("zrnmvaarinenoutouym07", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaarisisuuupritu07 = new ExDBFieldString<>("zrnmvaarisisuuupritu07", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaaritmttknzkritu07 = new ExDBFieldString<>("zrnmvaaritmttknzkritu07", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaariwtuktypeup07 = new ExDBFieldString<>("zrnmvaariwtuktypeup07", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaaritmttknkykkjmup07 = new ExDBFieldString<>("zrnmvaaritmttknkykkjmup07", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaariwup07 = new ExDBFieldString<>("zrnmvaariwup07", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaariwyentuktypeup07 = new ExDBFieldString<>("zrnmvaariwyentuktypeup07", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaariwupyendaka07 = new ExDBFieldString<>("zrnmvaariwupyendaka07", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaariwupyenkijyun07 = new ExDBFieldString<>("zrnmvaariwupyenkijyun07", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaariwupyenyasu07 = new ExDBFieldString<>("zrnmvaariwupyenyasu07", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaariwumupyendaka07 = new ExDBFieldString<>("zrnmvaariwumupyendaka07", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaariumupyenkijyun07 = new ExDBFieldString<>("zrnmvaariumupyenkijyun07", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaariumupyenyasu07 = new ExDBFieldString<>("zrnmvaariumupyenyasu07", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaariwtuktypesame07 = new ExDBFieldString<>("zrnmvaariwtuktypesame07", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaaritmttknkykkjmsame07 = new ExDBFieldString<>("zrnmvaaritmttknkykkjmsame07", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaariwsame07 = new ExDBFieldString<>("zrnmvaariwsame07", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaariwyentuktypesame07 = new ExDBFieldString<>("zrnmvaariwyentuktypesame07", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaariwsameyendaka07 = new ExDBFieldString<>("zrnmvaariwsameyendaka07", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaariwsameyenkijyun07 = new ExDBFieldString<>("zrnmvaariwsameyenkijyun07", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaariwsameyenyasu07 = new ExDBFieldString<>("zrnmvaariwsameyenyasu07", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaariumsameyendaka07 = new ExDBFieldString<>("zrnmvaariumsameyendaka07", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaariumsameyenkijyun07 = new ExDBFieldString<>("zrnmvaariumsameyenkijyun07", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaariumsameyenyasu07 = new ExDBFieldString<>("zrnmvaariumsameyenyasu07", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaariwtuktypedown07 = new ExDBFieldString<>("zrnmvaariwtuktypedown07", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaaritmttknkykkjmdown07 = new ExDBFieldString<>("zrnmvaaritmttknkykkjmdown07", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaariwdown07 = new ExDBFieldString<>("zrnmvaariwdown07", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaariwyentuktypedown07 = new ExDBFieldString<>("zrnmvaariwyentuktypedown07", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaariwdownyendaka07 = new ExDBFieldString<>("zrnmvaariwdownyendaka07", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaariwdownyenkijyun07 = new ExDBFieldString<>("zrnmvaariwdownyenkijyun07", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaariwdownyenyasu07 = new ExDBFieldString<>("zrnmvaariwdownyenyasu07", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaariumdownyendaka07 = new ExDBFieldString<>("zrnmvaariumdownyendaka07", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaariumdownyenkijyun07 = new ExDBFieldString<>("zrnmvaariumdownyenkijyun07", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaariumdownyenyasu07 = new ExDBFieldString<>("zrnmvaariumdownyenyasu07", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaarivtuktype07 = new ExDBFieldString<>("zrnmvaarivtuktype07", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaariv07 = new ExDBFieldString<>("zrnmvaariv07", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnptmttkngkutiwake107 = new ExDBFieldString<>("zrnptmttkngkutiwake107", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnptmttkngkutiwake207 = new ExDBFieldString<>("zrnptmttkngkutiwake207", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaarinenoutouym08 = new ExDBFieldString<>("zrnmvaarinenoutouym08", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaarisisuuupritu08 = new ExDBFieldString<>("zrnmvaarisisuuupritu08", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaaritmttknzkritu08 = new ExDBFieldString<>("zrnmvaaritmttknzkritu08", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaariwtuktypeup08 = new ExDBFieldString<>("zrnmvaariwtuktypeup08", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaaritmttknkykkjmup08 = new ExDBFieldString<>("zrnmvaaritmttknkykkjmup08", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaariwup08 = new ExDBFieldString<>("zrnmvaariwup08", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaariwyentuktypeup08 = new ExDBFieldString<>("zrnmvaariwyentuktypeup08", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaariwupyendaka08 = new ExDBFieldString<>("zrnmvaariwupyendaka08", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaariwupyenkijyun08 = new ExDBFieldString<>("zrnmvaariwupyenkijyun08", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaariwupyenyasu08 = new ExDBFieldString<>("zrnmvaariwupyenyasu08", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaariwumupyendaka08 = new ExDBFieldString<>("zrnmvaariwumupyendaka08", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaariumupyenkijyun08 = new ExDBFieldString<>("zrnmvaariumupyenkijyun08", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaariumupyenyasu08 = new ExDBFieldString<>("zrnmvaariumupyenyasu08", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaariwtuktypesame08 = new ExDBFieldString<>("zrnmvaariwtuktypesame08", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaaritmttknkykkjmsame08 = new ExDBFieldString<>("zrnmvaaritmttknkykkjmsame08", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaariwsame08 = new ExDBFieldString<>("zrnmvaariwsame08", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaariwyentuktypesame08 = new ExDBFieldString<>("zrnmvaariwyentuktypesame08", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaariwsameyendaka08 = new ExDBFieldString<>("zrnmvaariwsameyendaka08", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaariwsameyenkijyun08 = new ExDBFieldString<>("zrnmvaariwsameyenkijyun08", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaariwsameyenyasu08 = new ExDBFieldString<>("zrnmvaariwsameyenyasu08", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaariumsameyendaka08 = new ExDBFieldString<>("zrnmvaariumsameyendaka08", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaariumsameyenkijyun08 = new ExDBFieldString<>("zrnmvaariumsameyenkijyun08", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaariumsameyenyasu08 = new ExDBFieldString<>("zrnmvaariumsameyenyasu08", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaariwtuktypedown08 = new ExDBFieldString<>("zrnmvaariwtuktypedown08", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaaritmttknkykkjmdown08 = new ExDBFieldString<>("zrnmvaaritmttknkykkjmdown08", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaariwdown08 = new ExDBFieldString<>("zrnmvaariwdown08", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaariwyentuktypedown08 = new ExDBFieldString<>("zrnmvaariwyentuktypedown08", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaariwdownyendaka08 = new ExDBFieldString<>("zrnmvaariwdownyendaka08", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaariwdownyenkijyun08 = new ExDBFieldString<>("zrnmvaariwdownyenkijyun08", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaariwdownyenyasu08 = new ExDBFieldString<>("zrnmvaariwdownyenyasu08", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaariumdownyendaka08 = new ExDBFieldString<>("zrnmvaariumdownyendaka08", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaariumdownyenkijyun08 = new ExDBFieldString<>("zrnmvaariumdownyenkijyun08", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaariumdownyenyasu08 = new ExDBFieldString<>("zrnmvaariumdownyenyasu08", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaarivtuktype08 = new ExDBFieldString<>("zrnmvaarivtuktype08", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaariv08 = new ExDBFieldString<>("zrnmvaariv08", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnptmttkngkutiwake108 = new ExDBFieldString<>("zrnptmttkngkutiwake108", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnptmttkngkutiwake208 = new ExDBFieldString<>("zrnptmttkngkutiwake208", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaarinenoutouym09 = new ExDBFieldString<>("zrnmvaarinenoutouym09", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaarisisuuupritu09 = new ExDBFieldString<>("zrnmvaarisisuuupritu09", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaaritmttknzkritu09 = new ExDBFieldString<>("zrnmvaaritmttknzkritu09", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaariwtuktypeup09 = new ExDBFieldString<>("zrnmvaariwtuktypeup09", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaaritmttknkykkjmup09 = new ExDBFieldString<>("zrnmvaaritmttknkykkjmup09", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaariwup09 = new ExDBFieldString<>("zrnmvaariwup09", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaariwyentuktypeup09 = new ExDBFieldString<>("zrnmvaariwyentuktypeup09", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaariwupyendaka09 = new ExDBFieldString<>("zrnmvaariwupyendaka09", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaariwupyenkijyun09 = new ExDBFieldString<>("zrnmvaariwupyenkijyun09", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaariwupyenyasu09 = new ExDBFieldString<>("zrnmvaariwupyenyasu09", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaariwumupyendaka09 = new ExDBFieldString<>("zrnmvaariwumupyendaka09", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaariumupyenkijyun09 = new ExDBFieldString<>("zrnmvaariumupyenkijyun09", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaariumupyenyasu09 = new ExDBFieldString<>("zrnmvaariumupyenyasu09", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaariwtuktypesame09 = new ExDBFieldString<>("zrnmvaariwtuktypesame09", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaaritmttknkykkjmsame09 = new ExDBFieldString<>("zrnmvaaritmttknkykkjmsame09", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaariwsame09 = new ExDBFieldString<>("zrnmvaariwsame09", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaariwyentuktypesame09 = new ExDBFieldString<>("zrnmvaariwyentuktypesame09", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaariwsameyendaka09 = new ExDBFieldString<>("zrnmvaariwsameyendaka09", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaariwsameyenkijyun09 = new ExDBFieldString<>("zrnmvaariwsameyenkijyun09", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaariwsameyenyasu09 = new ExDBFieldString<>("zrnmvaariwsameyenyasu09", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaariumsameyendaka09 = new ExDBFieldString<>("zrnmvaariumsameyendaka09", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaariumsameyenkijyun09 = new ExDBFieldString<>("zrnmvaariumsameyenkijyun09", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaariumsameyenyasu09 = new ExDBFieldString<>("zrnmvaariumsameyenyasu09", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaariwtuktypedown09 = new ExDBFieldString<>("zrnmvaariwtuktypedown09", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaaritmttknkykkjmdown09 = new ExDBFieldString<>("zrnmvaaritmttknkykkjmdown09", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaariwdown09 = new ExDBFieldString<>("zrnmvaariwdown09", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaariwyentuktypedown09 = new ExDBFieldString<>("zrnmvaariwyentuktypedown09", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaariwdownyendaka09 = new ExDBFieldString<>("zrnmvaariwdownyendaka09", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaariwdownyenkijyun09 = new ExDBFieldString<>("zrnmvaariwdownyenkijyun09", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaariwdownyenyasu09 = new ExDBFieldString<>("zrnmvaariwdownyenyasu09", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaariumdownyendaka09 = new ExDBFieldString<>("zrnmvaariumdownyendaka09", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaariumdownyenkijyun09 = new ExDBFieldString<>("zrnmvaariumdownyenkijyun09", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaariumdownyenyasu09 = new ExDBFieldString<>("zrnmvaariumdownyenyasu09", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaarivtuktype09 = new ExDBFieldString<>("zrnmvaarivtuktype09", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaariv09 = new ExDBFieldString<>("zrnmvaariv09", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnptmttkngkutiwake109 = new ExDBFieldString<>("zrnptmttkngkutiwake109", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnptmttkngkutiwake209 = new ExDBFieldString<>("zrnptmttkngkutiwake209", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaarinenoutouym10 = new ExDBFieldString<>("zrnmvaarinenoutouym10", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaarisisuuupritu10 = new ExDBFieldString<>("zrnmvaarisisuuupritu10", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaaritmttknzkritu10 = new ExDBFieldString<>("zrnmvaaritmttknzkritu10", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaariwtuktypeup10 = new ExDBFieldString<>("zrnmvaariwtuktypeup10", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaaritmttknkykkjmup10 = new ExDBFieldString<>("zrnmvaaritmttknkykkjmup10", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaariwup10 = new ExDBFieldString<>("zrnmvaariwup10", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaariwyentuktypeup10 = new ExDBFieldString<>("zrnmvaariwyentuktypeup10", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaariwupyendaka10 = new ExDBFieldString<>("zrnmvaariwupyendaka10", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaariwupyenkijyun10 = new ExDBFieldString<>("zrnmvaariwupyenkijyun10", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaariwupyenyasu10 = new ExDBFieldString<>("zrnmvaariwupyenyasu10", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaariwumupyendaka10 = new ExDBFieldString<>("zrnmvaariwumupyendaka10", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaariumupyenkijyun10 = new ExDBFieldString<>("zrnmvaariumupyenkijyun10", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaariumupyenyasu10 = new ExDBFieldString<>("zrnmvaariumupyenyasu10", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaariwtuktypesame10 = new ExDBFieldString<>("zrnmvaariwtuktypesame10", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaaritmttknkykkjmsame10 = new ExDBFieldString<>("zrnmvaaritmttknkykkjmsame10", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaariwsame10 = new ExDBFieldString<>("zrnmvaariwsame10", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaariwyentuktypesame10 = new ExDBFieldString<>("zrnmvaariwyentuktypesame10", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaariwsameyendaka10 = new ExDBFieldString<>("zrnmvaariwsameyendaka10", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaariwsameyenkijyun10 = new ExDBFieldString<>("zrnmvaariwsameyenkijyun10", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaariwsameyenyasu10 = new ExDBFieldString<>("zrnmvaariwsameyenyasu10", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaariumsameyendaka10 = new ExDBFieldString<>("zrnmvaariumsameyendaka10", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaariumsameyenkijyun10 = new ExDBFieldString<>("zrnmvaariumsameyenkijyun10", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaariumsameyenyasu10 = new ExDBFieldString<>("zrnmvaariumsameyenyasu10", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaariwtuktypedown10 = new ExDBFieldString<>("zrnmvaariwtuktypedown10", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaaritmttknkykkjmdown10 = new ExDBFieldString<>("zrnmvaaritmttknkykkjmdown10", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaariwdown10 = new ExDBFieldString<>("zrnmvaariwdown10", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaariwyentuktypedown10 = new ExDBFieldString<>("zrnmvaariwyentuktypedown10", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaariwdownyendaka10 = new ExDBFieldString<>("zrnmvaariwdownyendaka10", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaariwdownyenkijyun10 = new ExDBFieldString<>("zrnmvaariwdownyenkijyun10", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaariwdownyenyasu10 = new ExDBFieldString<>("zrnmvaariwdownyenyasu10", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaariumdownyendaka10 = new ExDBFieldString<>("zrnmvaariumdownyendaka10", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaariumdownyenkijyun10 = new ExDBFieldString<>("zrnmvaariumdownyenkijyun10", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaariumdownyenyasu10 = new ExDBFieldString<>("zrnmvaariumdownyenyasu10", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaarivtuktype10 = new ExDBFieldString<>("zrnmvaarivtuktype10", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaariv10 = new ExDBFieldString<>("zrnmvaariv10", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnptmttkngkutiwake110 = new ExDBFieldString<>("zrnptmttkngkutiwake110", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnptmttkngkutiwake210 = new ExDBFieldString<>("zrnptmttkngkutiwake210", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaarinenoutouym11 = new ExDBFieldString<>("zrnmvaarinenoutouym11", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaariwtuktypeup11 = new ExDBFieldString<>("zrnmvaariwtuktypeup11", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaariwup11 = new ExDBFieldString<>("zrnmvaariwup11", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaariwyentuktypeup11 = new ExDBFieldString<>("zrnmvaariwyentuktypeup11", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaariwupyendaka11 = new ExDBFieldString<>("zrnmvaariwupyendaka11", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaariwupyenkijyun11 = new ExDBFieldString<>("zrnmvaariwupyenkijyun11", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaariwupyenyasu11 = new ExDBFieldString<>("zrnmvaariwupyenyasu11", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaariwumupyendaka11 = new ExDBFieldString<>("zrnmvaariwumupyendaka11", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaariumupyenkijyun11 = new ExDBFieldString<>("zrnmvaariumupyenkijyun11", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaariumupyenyasu11 = new ExDBFieldString<>("zrnmvaariumupyenyasu11", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaariwtuktypesame11 = new ExDBFieldString<>("zrnmvaariwtuktypesame11", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaariwsame11 = new ExDBFieldString<>("zrnmvaariwsame11", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaariwyentuktypesame11 = new ExDBFieldString<>("zrnmvaariwyentuktypesame11", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaariwsameyendaka11 = new ExDBFieldString<>("zrnmvaariwsameyendaka11", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaariwsameyenkijyun11 = new ExDBFieldString<>("zrnmvaariwsameyenkijyun11", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaariwsameyenyasu11 = new ExDBFieldString<>("zrnmvaariwsameyenyasu11", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaariumsameyendaka11 = new ExDBFieldString<>("zrnmvaariumsameyendaka11", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaariumsameyenkijyun11 = new ExDBFieldString<>("zrnmvaariumsameyenkijyun11", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaariumsameyenyasu11 = new ExDBFieldString<>("zrnmvaariumsameyenyasu11", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaariwtuktypedown11 = new ExDBFieldString<>("zrnmvaariwtuktypedown11", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaariwdown11 = new ExDBFieldString<>("zrnmvaariwdown11", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaariwyentuktypedown11 = new ExDBFieldString<>("zrnmvaariwyentuktypedown11", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaariwdownyendaka11 = new ExDBFieldString<>("zrnmvaariwdownyendaka11", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaariwdownyenkijyun11 = new ExDBFieldString<>("zrnmvaariwdownyenkijyun11", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaariwdownyenyasu11 = new ExDBFieldString<>("zrnmvaariwdownyenyasu11", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaariumdownyendaka11 = new ExDBFieldString<>("zrnmvaariumdownyendaka11", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaariumdownyenkijyun11 = new ExDBFieldString<>("zrnmvaariumdownyenkijyun11", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaariumdownyenyasu11 = new ExDBFieldString<>("zrnmvaariumdownyenyasu11", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaarivtuktype11 = new ExDBFieldString<>("zrnmvaarivtuktype11", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaariv11 = new ExDBFieldString<>("zrnmvaariv11", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaarinenoutouym12 = new ExDBFieldString<>("zrnmvaarinenoutouym12", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaariwtuktypeup12 = new ExDBFieldString<>("zrnmvaariwtuktypeup12", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaariwup12 = new ExDBFieldString<>("zrnmvaariwup12", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaariwyentuktypeup12 = new ExDBFieldString<>("zrnmvaariwyentuktypeup12", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaariwupyendaka12 = new ExDBFieldString<>("zrnmvaariwupyendaka12", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaariwupyenkijyun12 = new ExDBFieldString<>("zrnmvaariwupyenkijyun12", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaariwupyenyasu12 = new ExDBFieldString<>("zrnmvaariwupyenyasu12", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaariwumupyendaka12 = new ExDBFieldString<>("zrnmvaariwumupyendaka12", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaariumupyenkijyun12 = new ExDBFieldString<>("zrnmvaariumupyenkijyun12", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaariumupyenyasu12 = new ExDBFieldString<>("zrnmvaariumupyenyasu12", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaariwtuktypesame12 = new ExDBFieldString<>("zrnmvaariwtuktypesame12", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaariwsame12 = new ExDBFieldString<>("zrnmvaariwsame12", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaariwyentuktypesame12 = new ExDBFieldString<>("zrnmvaariwyentuktypesame12", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaariwsameyendaka12 = new ExDBFieldString<>("zrnmvaariwsameyendaka12", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaariwsameyenkijyun12 = new ExDBFieldString<>("zrnmvaariwsameyenkijyun12", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaariwsameyenyasu12 = new ExDBFieldString<>("zrnmvaariwsameyenyasu12", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaariumsameyendaka12 = new ExDBFieldString<>("zrnmvaariumsameyendaka12", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaariumsameyenkijyun12 = new ExDBFieldString<>("zrnmvaariumsameyenkijyun12", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaariumsameyenyasu12 = new ExDBFieldString<>("zrnmvaariumsameyenyasu12", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaariwtuktypedown12 = new ExDBFieldString<>("zrnmvaariwtuktypedown12", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaariwdown12 = new ExDBFieldString<>("zrnmvaariwdown12", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaariwyentuktypedown12 = new ExDBFieldString<>("zrnmvaariwyentuktypedown12", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaariwdownyendaka12 = new ExDBFieldString<>("zrnmvaariwdownyendaka12", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaariwdownyenkijyun12 = new ExDBFieldString<>("zrnmvaariwdownyenkijyun12", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaariwdownyenyasu12 = new ExDBFieldString<>("zrnmvaariwdownyenyasu12", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaariumdownyendaka12 = new ExDBFieldString<>("zrnmvaariumdownyendaka12", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaariumdownyenkijyun12 = new ExDBFieldString<>("zrnmvaariumdownyenkijyun12", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaariumdownyenyasu12 = new ExDBFieldString<>("zrnmvaariumdownyenyasu12", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaarivtuktype12 = new ExDBFieldString<>("zrnmvaarivtuktype12", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaariv12 = new ExDBFieldString<>("zrnmvaariv12", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaarinenoutouym13 = new ExDBFieldString<>("zrnmvaarinenoutouym13", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaariwtuktypeup13 = new ExDBFieldString<>("zrnmvaariwtuktypeup13", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaariwup13 = new ExDBFieldString<>("zrnmvaariwup13", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaariwyentuktypeup13 = new ExDBFieldString<>("zrnmvaariwyentuktypeup13", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaariwupyendaka13 = new ExDBFieldString<>("zrnmvaariwupyendaka13", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaariwupyenkijyun13 = new ExDBFieldString<>("zrnmvaariwupyenkijyun13", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaariwupyenyasu13 = new ExDBFieldString<>("zrnmvaariwupyenyasu13", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaariwumupyendaka13 = new ExDBFieldString<>("zrnmvaariwumupyendaka13", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaariumupyenkijyun13 = new ExDBFieldString<>("zrnmvaariumupyenkijyun13", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaariumupyenyasu13 = new ExDBFieldString<>("zrnmvaariumupyenyasu13", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaariwtuktypesame13 = new ExDBFieldString<>("zrnmvaariwtuktypesame13", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaariwsame13 = new ExDBFieldString<>("zrnmvaariwsame13", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaariwyentuktypesame13 = new ExDBFieldString<>("zrnmvaariwyentuktypesame13", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaariwsameyendaka13 = new ExDBFieldString<>("zrnmvaariwsameyendaka13", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaariwsameyenkijyun13 = new ExDBFieldString<>("zrnmvaariwsameyenkijyun13", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaariwsameyenyasu13 = new ExDBFieldString<>("zrnmvaariwsameyenyasu13", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaariumsameyendaka13 = new ExDBFieldString<>("zrnmvaariumsameyendaka13", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaariumsameyenkijyun13 = new ExDBFieldString<>("zrnmvaariumsameyenkijyun13", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaariumsameyenyasu13 = new ExDBFieldString<>("zrnmvaariumsameyenyasu13", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaariwtuktypedown13 = new ExDBFieldString<>("zrnmvaariwtuktypedown13", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaariwdown13 = new ExDBFieldString<>("zrnmvaariwdown13", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaariwyentuktypedown13 = new ExDBFieldString<>("zrnmvaariwyentuktypedown13", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaariwdownyendaka13 = new ExDBFieldString<>("zrnmvaariwdownyendaka13", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaariwdownyenkijyun13 = new ExDBFieldString<>("zrnmvaariwdownyenkijyun13", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaariwdownyenyasu13 = new ExDBFieldString<>("zrnmvaariwdownyenyasu13", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaariumdownyendaka13 = new ExDBFieldString<>("zrnmvaariumdownyendaka13", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaariumdownyenkijyun13 = new ExDBFieldString<>("zrnmvaariumdownyenkijyun13", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaariumdownyenyasu13 = new ExDBFieldString<>("zrnmvaariumdownyenyasu13", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaarivtuktype13 = new ExDBFieldString<>("zrnmvaarivtuktype13", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaariv13 = new ExDBFieldString<>("zrnmvaariv13", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaarinenoutouym14 = new ExDBFieldString<>("zrnmvaarinenoutouym14", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaariwtuktypeup14 = new ExDBFieldString<>("zrnmvaariwtuktypeup14", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaariwup14 = new ExDBFieldString<>("zrnmvaariwup14", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaariwyentuktypeup14 = new ExDBFieldString<>("zrnmvaariwyentuktypeup14", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaariwupyendaka14 = new ExDBFieldString<>("zrnmvaariwupyendaka14", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaariwupyenkijyun14 = new ExDBFieldString<>("zrnmvaariwupyenkijyun14", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaariwupyenyasu14 = new ExDBFieldString<>("zrnmvaariwupyenyasu14", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaariwumupyendaka14 = new ExDBFieldString<>("zrnmvaariwumupyendaka14", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaariumupyenkijyun14 = new ExDBFieldString<>("zrnmvaariumupyenkijyun14", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaariumupyenyasu14 = new ExDBFieldString<>("zrnmvaariumupyenyasu14", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaariwtuktypesame14 = new ExDBFieldString<>("zrnmvaariwtuktypesame14", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaariwsame14 = new ExDBFieldString<>("zrnmvaariwsame14", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaariwyentuktypesame14 = new ExDBFieldString<>("zrnmvaariwyentuktypesame14", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaariwsameyendaka14 = new ExDBFieldString<>("zrnmvaariwsameyendaka14", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaariwsameyenkijyun14 = new ExDBFieldString<>("zrnmvaariwsameyenkijyun14", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaariwsameyenyasu14 = new ExDBFieldString<>("zrnmvaariwsameyenyasu14", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaariumsameyendaka14 = new ExDBFieldString<>("zrnmvaariumsameyendaka14", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaariumsameyenkijyun14 = new ExDBFieldString<>("zrnmvaariumsameyenkijyun14", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaariumsameyenyasu14 = new ExDBFieldString<>("zrnmvaariumsameyenyasu14", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaariwtuktypedown14 = new ExDBFieldString<>("zrnmvaariwtuktypedown14", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaariwdown14 = new ExDBFieldString<>("zrnmvaariwdown14", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaariwyentuktypedown14 = new ExDBFieldString<>("zrnmvaariwyentuktypedown14", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaariwdownyendaka14 = new ExDBFieldString<>("zrnmvaariwdownyendaka14", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaariwdownyenkijyun14 = new ExDBFieldString<>("zrnmvaariwdownyenkijyun14", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaariwdownyenyasu14 = new ExDBFieldString<>("zrnmvaariwdownyenyasu14", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaariumdownyendaka14 = new ExDBFieldString<>("zrnmvaariumdownyendaka14", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaariumdownyenkijyun14 = new ExDBFieldString<>("zrnmvaariumdownyenkijyun14", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaariumdownyenyasu14 = new ExDBFieldString<>("zrnmvaariumdownyenyasu14", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaarivtuktype14 = new ExDBFieldString<>("zrnmvaarivtuktype14", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaariv14 = new ExDBFieldString<>("zrnmvaariv14", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaarinenoutouym15 = new ExDBFieldString<>("zrnmvaarinenoutouym15", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaariwtuktypeup15 = new ExDBFieldString<>("zrnmvaariwtuktypeup15", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaariwup15 = new ExDBFieldString<>("zrnmvaariwup15", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaariwyentuktypeup15 = new ExDBFieldString<>("zrnmvaariwyentuktypeup15", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaariwupyendaka15 = new ExDBFieldString<>("zrnmvaariwupyendaka15", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaariwupyenkijyun15 = new ExDBFieldString<>("zrnmvaariwupyenkijyun15", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaariwupyenyasu15 = new ExDBFieldString<>("zrnmvaariwupyenyasu15", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaariwumupyendaka15 = new ExDBFieldString<>("zrnmvaariwumupyendaka15", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaariumupyenkijyun15 = new ExDBFieldString<>("zrnmvaariumupyenkijyun15", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaariumupyenyasu15 = new ExDBFieldString<>("zrnmvaariumupyenyasu15", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaariwtuktypesame15 = new ExDBFieldString<>("zrnmvaariwtuktypesame15", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaariwsame15 = new ExDBFieldString<>("zrnmvaariwsame15", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaariwyentuktypesame15 = new ExDBFieldString<>("zrnmvaariwyentuktypesame15", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaariwsameyendaka15 = new ExDBFieldString<>("zrnmvaariwsameyendaka15", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaariwsameyenkijyun15 = new ExDBFieldString<>("zrnmvaariwsameyenkijyun15", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaariwsameyenyasu15 = new ExDBFieldString<>("zrnmvaariwsameyenyasu15", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaariumsameyendaka15 = new ExDBFieldString<>("zrnmvaariumsameyendaka15", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaariumsameyenkijyun15 = new ExDBFieldString<>("zrnmvaariumsameyenkijyun15", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaariumsameyenyasu15 = new ExDBFieldString<>("zrnmvaariumsameyenyasu15", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaariwtuktypedown15 = new ExDBFieldString<>("zrnmvaariwtuktypedown15", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaariwdown15 = new ExDBFieldString<>("zrnmvaariwdown15", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaariwyentuktypedown15 = new ExDBFieldString<>("zrnmvaariwyentuktypedown15", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaariwdownyendaka15 = new ExDBFieldString<>("zrnmvaariwdownyendaka15", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaariwdownyenkijyun15 = new ExDBFieldString<>("zrnmvaariwdownyenkijyun15", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaariwdownyenyasu15 = new ExDBFieldString<>("zrnmvaariwdownyenyasu15", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaariumdownyendaka15 = new ExDBFieldString<>("zrnmvaariumdownyendaka15", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaariumdownyenkijyun15 = new ExDBFieldString<>("zrnmvaariumdownyenkijyun15", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaariumdownyenyasu15 = new ExDBFieldString<>("zrnmvaariumdownyenyasu15", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaarivtuktype15 = new ExDBFieldString<>("zrnmvaarivtuktype15", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvaariv15 = new ExDBFieldString<>("zrnmvaariv15", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvanonekaisiinnumukbn01 = new ExDBFieldString<>("zrnmvanonekaisiinnumukbn01", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvanonenenoutouym01 = new ExDBFieldString<>("zrnmvanonenenoutouym01", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvanonewtuktype01 = new ExDBFieldString<>("zrnmvanonewtuktype01", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvanonew01 = new ExDBFieldString<>("zrnmvanonew01", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvanonewyentuktype01 = new ExDBFieldString<>("zrnmvanonewyentuktype01", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvanonewyendaka01 = new ExDBFieldString<>("zrnmvanonewyendaka01", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvanonewyenkijyun01 = new ExDBFieldString<>("zrnmvanonewyenkijyun01", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvanonewyenyasu01 = new ExDBFieldString<>("zrnmvanonewyenyasu01", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvanoneumyendaka01 = new ExDBFieldString<>("zrnmvanoneumyendaka01", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvanoneumyenkijyun01 = new ExDBFieldString<>("zrnmvanoneumyenkijyun01", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvanoneumyenyasu01 = new ExDBFieldString<>("zrnmvanoneumyenyasu01", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvanonevtuktype01 = new ExDBFieldString<>("zrnmvanonevtuktype01", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvanonev01 = new ExDBFieldString<>("zrnmvanonev01", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvanonekaisiinnumukbn02 = new ExDBFieldString<>("zrnmvanonekaisiinnumukbn02", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvanonenenoutouym02 = new ExDBFieldString<>("zrnmvanonenenoutouym02", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvanonewtuktype02 = new ExDBFieldString<>("zrnmvanonewtuktype02", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvanonew02 = new ExDBFieldString<>("zrnmvanonew02", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvanonewyentuktype02 = new ExDBFieldString<>("zrnmvanonewyentuktype02", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvanonewyendaka02 = new ExDBFieldString<>("zrnmvanonewyendaka02", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvanonewyenkijyun02 = new ExDBFieldString<>("zrnmvanonewyenkijyun02", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvanonewyenyasu02 = new ExDBFieldString<>("zrnmvanonewyenyasu02", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvanoneumyendaka02 = new ExDBFieldString<>("zrnmvanoneumyendaka02", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvanoneumyenkijyun02 = new ExDBFieldString<>("zrnmvanoneumyenkijyun02", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvanoneumyenyasu02 = new ExDBFieldString<>("zrnmvanoneumyenyasu02", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvanonevtuktype02 = new ExDBFieldString<>("zrnmvanonevtuktype02", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvanonev02 = new ExDBFieldString<>("zrnmvanonev02", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvanonekaisiinnumukbn03 = new ExDBFieldString<>("zrnmvanonekaisiinnumukbn03", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvanonenenoutouym03 = new ExDBFieldString<>("zrnmvanonenenoutouym03", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvanonewtuktype03 = new ExDBFieldString<>("zrnmvanonewtuktype03", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvanonew03 = new ExDBFieldString<>("zrnmvanonew03", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvanonewyentuktype03 = new ExDBFieldString<>("zrnmvanonewyentuktype03", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvanonewyendaka03 = new ExDBFieldString<>("zrnmvanonewyendaka03", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvanonewyenkijyun03 = new ExDBFieldString<>("zrnmvanonewyenkijyun03", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvanonewyenyasu03 = new ExDBFieldString<>("zrnmvanonewyenyasu03", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvanoneumyendaka03 = new ExDBFieldString<>("zrnmvanoneumyendaka03", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvanoneumyenkijyun03 = new ExDBFieldString<>("zrnmvanoneumyenkijyun03", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvanoneumyenyasu03 = new ExDBFieldString<>("zrnmvanoneumyenyasu03", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvanonevtuktype03 = new ExDBFieldString<>("zrnmvanonevtuktype03", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvanonev03 = new ExDBFieldString<>("zrnmvanonev03", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvanonekaisiinnumukbn04 = new ExDBFieldString<>("zrnmvanonekaisiinnumukbn04", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvanonenenoutouym04 = new ExDBFieldString<>("zrnmvanonenenoutouym04", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvanonewtuktype04 = new ExDBFieldString<>("zrnmvanonewtuktype04", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvanonew04 = new ExDBFieldString<>("zrnmvanonew04", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvanonewyentuktype04 = new ExDBFieldString<>("zrnmvanonewyentuktype04", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvanonewyendaka04 = new ExDBFieldString<>("zrnmvanonewyendaka04", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvanonewyenkijyun04 = new ExDBFieldString<>("zrnmvanonewyenkijyun04", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvanonewyenyasu04 = new ExDBFieldString<>("zrnmvanonewyenyasu04", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvanoneumyendaka04 = new ExDBFieldString<>("zrnmvanoneumyendaka04", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvanoneumyenkijyun04 = new ExDBFieldString<>("zrnmvanoneumyenkijyun04", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvanoneumyenyasu04 = new ExDBFieldString<>("zrnmvanoneumyenyasu04", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvanonevtuktype04 = new ExDBFieldString<>("zrnmvanonevtuktype04", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvanonev04 = new ExDBFieldString<>("zrnmvanonev04", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvanonekaisiinnumukbn05 = new ExDBFieldString<>("zrnmvanonekaisiinnumukbn05", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvanonenenoutouym05 = new ExDBFieldString<>("zrnmvanonenenoutouym05", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvanonewtuktype05 = new ExDBFieldString<>("zrnmvanonewtuktype05", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvanonew05 = new ExDBFieldString<>("zrnmvanonew05", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvanonewyentuktype05 = new ExDBFieldString<>("zrnmvanonewyentuktype05", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvanonewyendaka05 = new ExDBFieldString<>("zrnmvanonewyendaka05", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvanonewyenkijyun05 = new ExDBFieldString<>("zrnmvanonewyenkijyun05", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvanonewyenyasu05 = new ExDBFieldString<>("zrnmvanonewyenyasu05", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvanoneumyendaka05 = new ExDBFieldString<>("zrnmvanoneumyendaka05", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvanoneumyenkijyun05 = new ExDBFieldString<>("zrnmvanoneumyenkijyun05", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvanoneumyenyasu05 = new ExDBFieldString<>("zrnmvanoneumyenyasu05", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvanonevtuktype05 = new ExDBFieldString<>("zrnmvanonevtuktype05", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvanonev05 = new ExDBFieldString<>("zrnmvanonev05", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvanonekaisiinnumukbn06 = new ExDBFieldString<>("zrnmvanonekaisiinnumukbn06", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvanonenenoutouym06 = new ExDBFieldString<>("zrnmvanonenenoutouym06", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvanonewtuktype06 = new ExDBFieldString<>("zrnmvanonewtuktype06", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvanonew06 = new ExDBFieldString<>("zrnmvanonew06", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvanonewyentuktype06 = new ExDBFieldString<>("zrnmvanonewyentuktype06", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvanonewyendaka06 = new ExDBFieldString<>("zrnmvanonewyendaka06", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvanonewyenkijyun06 = new ExDBFieldString<>("zrnmvanonewyenkijyun06", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvanonewyenyasu06 = new ExDBFieldString<>("zrnmvanonewyenyasu06", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvanoneumyendaka06 = new ExDBFieldString<>("zrnmvanoneumyendaka06", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvanoneumyenkijyun06 = new ExDBFieldString<>("zrnmvanoneumyenkijyun06", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvanoneumyenyasu06 = new ExDBFieldString<>("zrnmvanoneumyenyasu06", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvanonevtuktype06 = new ExDBFieldString<>("zrnmvanonevtuktype06", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvanonev06 = new ExDBFieldString<>("zrnmvanonev06", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvanonekaisiinnumukbn07 = new ExDBFieldString<>("zrnmvanonekaisiinnumukbn07", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvanonenenoutouym07 = new ExDBFieldString<>("zrnmvanonenenoutouym07", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvanonewtuktype07 = new ExDBFieldString<>("zrnmvanonewtuktype07", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvanonew07 = new ExDBFieldString<>("zrnmvanonew07", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvanonewyentuktype07 = new ExDBFieldString<>("zrnmvanonewyentuktype07", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvanonewyendaka07 = new ExDBFieldString<>("zrnmvanonewyendaka07", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvanonewyenkijyun07 = new ExDBFieldString<>("zrnmvanonewyenkijyun07", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvanonewyenyasu07 = new ExDBFieldString<>("zrnmvanonewyenyasu07", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvanoneumyendaka07 = new ExDBFieldString<>("zrnmvanoneumyendaka07", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvanoneumyenkijyun07 = new ExDBFieldString<>("zrnmvanoneumyenkijyun07", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvanoneumyenyasu07 = new ExDBFieldString<>("zrnmvanoneumyenyasu07", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvanonevtuktype07 = new ExDBFieldString<>("zrnmvanonevtuktype07", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvanonev07 = new ExDBFieldString<>("zrnmvanonev07", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvanonekaisiinnumukbn08 = new ExDBFieldString<>("zrnmvanonekaisiinnumukbn08", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvanonenenoutouym08 = new ExDBFieldString<>("zrnmvanonenenoutouym08", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvanonewtuktype08 = new ExDBFieldString<>("zrnmvanonewtuktype08", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvanonew08 = new ExDBFieldString<>("zrnmvanonew08", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvanonewyentuktype08 = new ExDBFieldString<>("zrnmvanonewyentuktype08", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvanonewyendaka08 = new ExDBFieldString<>("zrnmvanonewyendaka08", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvanonewyenkijyun08 = new ExDBFieldString<>("zrnmvanonewyenkijyun08", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvanonewyenyasu08 = new ExDBFieldString<>("zrnmvanonewyenyasu08", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvanoneumyendaka08 = new ExDBFieldString<>("zrnmvanoneumyendaka08", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvanoneumyenkijyun08 = new ExDBFieldString<>("zrnmvanoneumyenkijyun08", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvanoneumyenyasu08 = new ExDBFieldString<>("zrnmvanoneumyenyasu08", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvanonevtuktype08 = new ExDBFieldString<>("zrnmvanonevtuktype08", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvanonev08 = new ExDBFieldString<>("zrnmvanonev08", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvanonekaisiinnumukbn09 = new ExDBFieldString<>("zrnmvanonekaisiinnumukbn09", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvanonenenoutouym09 = new ExDBFieldString<>("zrnmvanonenenoutouym09", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvanonewtuktype09 = new ExDBFieldString<>("zrnmvanonewtuktype09", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvanonew09 = new ExDBFieldString<>("zrnmvanonew09", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvanonewyentuktype09 = new ExDBFieldString<>("zrnmvanonewyentuktype09", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvanonewyendaka09 = new ExDBFieldString<>("zrnmvanonewyendaka09", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvanonewyenkijyun09 = new ExDBFieldString<>("zrnmvanonewyenkijyun09", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvanonewyenyasu09 = new ExDBFieldString<>("zrnmvanonewyenyasu09", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvanoneumyendaka09 = new ExDBFieldString<>("zrnmvanoneumyendaka09", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvanoneumyenkijyun09 = new ExDBFieldString<>("zrnmvanoneumyenkijyun09", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvanoneumyenyasu09 = new ExDBFieldString<>("zrnmvanoneumyenyasu09", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvanonevtuktype09 = new ExDBFieldString<>("zrnmvanonevtuktype09", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvanonev09 = new ExDBFieldString<>("zrnmvanonev09", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvanonekaisiinnumukbn10 = new ExDBFieldString<>("zrnmvanonekaisiinnumukbn10", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvanonenenoutouym10 = new ExDBFieldString<>("zrnmvanonenenoutouym10", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvanonewtuktype10 = new ExDBFieldString<>("zrnmvanonewtuktype10", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvanonew10 = new ExDBFieldString<>("zrnmvanonew10", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvanonewyentuktype10 = new ExDBFieldString<>("zrnmvanonewyentuktype10", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvanonewyendaka10 = new ExDBFieldString<>("zrnmvanonewyendaka10", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvanonewyenkijyun10 = new ExDBFieldString<>("zrnmvanonewyenkijyun10", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvanonewyenyasu10 = new ExDBFieldString<>("zrnmvanonewyenyasu10", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvanoneumyendaka10 = new ExDBFieldString<>("zrnmvanoneumyendaka10", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvanoneumyenkijyun10 = new ExDBFieldString<>("zrnmvanoneumyenkijyun10", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvanoneumyenyasu10 = new ExDBFieldString<>("zrnmvanoneumyenyasu10", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvanonevtuktype10 = new ExDBFieldString<>("zrnmvanonevtuktype10", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvanonev10 = new ExDBFieldString<>("zrnmvanonev10", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvanonekaisiinnumukbn11 = new ExDBFieldString<>("zrnmvanonekaisiinnumukbn11", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvanonenenoutouym11 = new ExDBFieldString<>("zrnmvanonenenoutouym11", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvanonewtuktype11 = new ExDBFieldString<>("zrnmvanonewtuktype11", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvanonew11 = new ExDBFieldString<>("zrnmvanonew11", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvanonewyentuktype11 = new ExDBFieldString<>("zrnmvanonewyentuktype11", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvanonewyendaka11 = new ExDBFieldString<>("zrnmvanonewyendaka11", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvanonewyenkijyun11 = new ExDBFieldString<>("zrnmvanonewyenkijyun11", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvanonewyenyasu11 = new ExDBFieldString<>("zrnmvanonewyenyasu11", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvanoneumyendaka11 = new ExDBFieldString<>("zrnmvanoneumyendaka11", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvanoneumyenkijyun11 = new ExDBFieldString<>("zrnmvanoneumyenkijyun11", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvanoneumyenyasu11 = new ExDBFieldString<>("zrnmvanoneumyenyasu11", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvanonevtuktype11 = new ExDBFieldString<>("zrnmvanonevtuktype11", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvanonev11 = new ExDBFieldString<>("zrnmvanonev11", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvanonekaisiinnumukbn12 = new ExDBFieldString<>("zrnmvanonekaisiinnumukbn12", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvanonenenoutouym12 = new ExDBFieldString<>("zrnmvanonenenoutouym12", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvanonewtuktype12 = new ExDBFieldString<>("zrnmvanonewtuktype12", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvanonew12 = new ExDBFieldString<>("zrnmvanonew12", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvanonewyentuktype12 = new ExDBFieldString<>("zrnmvanonewyentuktype12", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvanonewyendaka12 = new ExDBFieldString<>("zrnmvanonewyendaka12", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvanonewyenkijyun12 = new ExDBFieldString<>("zrnmvanonewyenkijyun12", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvanonewyenyasu12 = new ExDBFieldString<>("zrnmvanonewyenyasu12", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvanoneumyendaka12 = new ExDBFieldString<>("zrnmvanoneumyendaka12", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvanoneumyenkijyun12 = new ExDBFieldString<>("zrnmvanoneumyenkijyun12", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvanoneumyenyasu12 = new ExDBFieldString<>("zrnmvanoneumyenyasu12", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvanonevtuktype12 = new ExDBFieldString<>("zrnmvanonevtuktype12", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvanonev12 = new ExDBFieldString<>("zrnmvanonev12", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvanonekaisiinnumukbn13 = new ExDBFieldString<>("zrnmvanonekaisiinnumukbn13", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvanonenenoutouym13 = new ExDBFieldString<>("zrnmvanonenenoutouym13", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvanonewtuktype13 = new ExDBFieldString<>("zrnmvanonewtuktype13", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvanonew13 = new ExDBFieldString<>("zrnmvanonew13", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvanonewyentuktype13 = new ExDBFieldString<>("zrnmvanonewyentuktype13", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvanonewyendaka13 = new ExDBFieldString<>("zrnmvanonewyendaka13", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvanonewyenkijyun13 = new ExDBFieldString<>("zrnmvanonewyenkijyun13", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvanonewyenyasu13 = new ExDBFieldString<>("zrnmvanonewyenyasu13", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvanoneumyendaka13 = new ExDBFieldString<>("zrnmvanoneumyendaka13", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvanoneumyenkijyun13 = new ExDBFieldString<>("zrnmvanoneumyenkijyun13", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvanoneumyenyasu13 = new ExDBFieldString<>("zrnmvanoneumyenyasu13", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvanonevtuktype13 = new ExDBFieldString<>("zrnmvanonevtuktype13", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvanonev13 = new ExDBFieldString<>("zrnmvanonev13", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvanonekaisiinnumukbn14 = new ExDBFieldString<>("zrnmvanonekaisiinnumukbn14", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvanonenenoutouym14 = new ExDBFieldString<>("zrnmvanonenenoutouym14", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvanonewtuktype14 = new ExDBFieldString<>("zrnmvanonewtuktype14", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvanonew14 = new ExDBFieldString<>("zrnmvanonew14", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvanonewyentuktype14 = new ExDBFieldString<>("zrnmvanonewyentuktype14", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvanonewyendaka14 = new ExDBFieldString<>("zrnmvanonewyendaka14", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvanonewyenkijyun14 = new ExDBFieldString<>("zrnmvanonewyenkijyun14", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvanonewyenyasu14 = new ExDBFieldString<>("zrnmvanonewyenyasu14", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvanoneumyendaka14 = new ExDBFieldString<>("zrnmvanoneumyendaka14", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvanoneumyenkijyun14 = new ExDBFieldString<>("zrnmvanoneumyenkijyun14", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvanoneumyenyasu14 = new ExDBFieldString<>("zrnmvanoneumyenyasu14", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvanonevtuktype14 = new ExDBFieldString<>("zrnmvanonevtuktype14", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnmvanonev14 = new ExDBFieldString<>("zrnmvanonev14", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnwmsgcd1 = new ExDBFieldString<>("zrnwmsgcd1", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnwmsgcd2 = new ExDBFieldString<>("zrnwmsgcd2", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnwmsgcd3 = new ExDBFieldString<>("zrnwmsgcd3", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnwmsgcd21 = new ExDBFieldString<>("zrnwmsgcd21", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnwmsgcd22 = new ExDBFieldString<>("zrnwmsgcd22", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnwmsgcd23 = new ExDBFieldString<>("zrnwmsgcd23", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnwmsgcd31 = new ExDBFieldString<>("zrnwmsgcd31", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnwmsgcd32 = new ExDBFieldString<>("zrnwmsgcd32", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnwmsgcd33 = new ExDBFieldString<>("zrnwmsgcd33", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnwmsgcdst1 = new ExDBFieldString<>("zrnwmsgcdst1", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnwtyuuimsgcd1 = new ExDBFieldString<>("zrnwtyuuimsgcd1", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnwtyuuimsgcd2 = new ExDBFieldString<>("zrnwtyuuimsgcd2", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnwtyuuimsgcd3 = new ExDBFieldString<>("zrnwtyuuimsgcd3", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnwtyuuimsgcd4 = new ExDBFieldString<>("zrnwtyuuimsgcd4", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnwtyuuimsgcd5 = new ExDBFieldString<>("zrnwtyuuimsgcd5", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnwtyuuimsgcd6 = new ExDBFieldString<>("zrnwtyuuimsgcd6", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnwtyuuimsgcd7 = new ExDBFieldString<>("zrnwtyuuimsgcd7", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnwitjbrptuuktype = new ExDBFieldString<>("zrnwitjbrptuuktype", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnwitjbrp = new ExDBFieldString<>("zrnwitjbrp", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnwyenhrikmgktuuktype = new ExDBFieldString<>("zrnwyenhrikmgktuuktype", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnwyenhrikmgk = new ExDBFieldString<>("zrnwyenhrikmgk", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnwyenitjbrptuuktype = new ExDBFieldString<>("zrnwyenitjbrptuuktype", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnwyenitjbrp = new ExDBFieldString<>("zrnwyenitjbrp", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnwsjkkktyouseitkyuym = new ExDBFieldString<>("zrnwsjkkktyouseitkyuym", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnhrkkknmnryym = new ExDBFieldString<>("zrnhrkkknmnryym", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnhrkkknmnrynen = new ExDBFieldString<>("zrnhrkkknmnrynen", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnyobiv200 = new ExDBFieldString<>("zrnyobiv200", this);

    public final ExDBFieldString<ZT_SaihakkouSyoukenSuiiRn, String> zrnyobiv49 = new ExDBFieldString<>("zrnyobiv49", this);
}
