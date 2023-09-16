package yuyu.def.db.mapping;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Padding;
import yuyu.def.db.entity.ZT_SaihakkouSyoukenSuiiRn;
import yuyu.def.db.id.PKZT_SaihakkouSyoukenSuiiRn;
import yuyu.def.db.meta.GenQZT_SaihakkouSyoukenSuiiRn;
import yuyu.def.db.meta.QZT_SaihakkouSyoukenSuiiRn;

/**
 * 再発行保険証券推移表Ｆテーブル（連） テーブルのマッピング情報クラスで、 {@link ZT_SaihakkouSyoukenSuiiRn} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_SaihakkouSyoukenSuiiRn}</td><td colspan="3">再発行保険証券推移表Ｆテーブル（連）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getZrnsyono zrnsyono}</td><td>（連携用）証券番号</td><td align="center">{@link PKZT_SaihakkouSyoukenSuiiRn ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntyouhyouymd zrntyouhyouymd}</td><td>（連携用）帳票作成日</td><td align="center">{@link PKZT_SaihakkouSyoukenSuiiRn ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsuiihyouptn zrnsuiihyouptn}</td><td>（連携用）推移表パターン</td><td align="center">{@link PKZT_SaihakkouSyoukenSuiiRn ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsuiihyousykbn zrnsuiihyousykbn}</td><td>（連携用）推移表種別区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsuiihyousyono zrnsuiihyousyono}</td><td>（連携用）推移表証券番号</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsisuuupritu zrnsisuuupritu}</td><td>（連携用）指数上昇率</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsaisyuunndym zrnsaisyuunndym}</td><td>（連携用）最終年度（年月）</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsjkkktusirrtup zrnsjkkktusirrtup}</td><td>（連携用）市場価格調整用利率（上昇）</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsjkkktusirrtsame zrnsjkkktusirrtsame}</td><td>（連携用）市場価格調整用利率（同水準）</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsjkkktusirrtdown zrnsjkkktusirrtdown}</td><td>（連携用）市場価格調整用利率（低下）</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsjkkktusirrthendouup zrnsjkkktusirrthendouup}</td><td>（連携用）市場価格調整用利率変動幅（上）</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsjkkktusirrthendoudown zrnsjkkktusirrthendoudown}</td><td>（連携用）市場価格調整用利率変動幅（下）</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnwkwsrateyendaka zrnwkwsrateyendaka}</td><td>（連携用）解約返戻金為替レート（円高）</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnwkwsrateyenkijyun zrnwkwsrateyenkijyun}</td><td>（連携用）解約返戻金為替レート（中央値）</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnwkwsrateyenyasu zrnwkwsrateyenyasu}</td><td>（連携用）解約返戻金為替レート（円安）</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsuiihyoumkhyouyenwra zrnsuiihyoumkhyouyenwra}</td><td>（連携用）推移表目標到達時円建終身保険移行特約目標割合</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaarinenoutouym01 zrnmvaarinenoutouym01}</td><td>（連携用）ＭＶＡ適用年単位応当年月０１</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaarisisuuupritu01 zrnmvaarisisuuupritu01}</td><td>（連携用）ＭＶＡ適用指数上昇率０１</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaaritmttknzkritu01 zrnmvaaritmttknzkritu01}</td><td>（連携用）ＭＶＡ適用積立金増加率０１</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaariwtuktypeup01 zrnmvaariwtuktypeup01}</td><td>（連携用）ＭＶＡ適用Ｗ通貨タイプ（上昇）０１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaaritmttknkykkjmup01 zrnmvaaritmttknkykkjmup01}</td><td>（連携用）ＭＶＡ適用積立金（解約控除前）（上昇）０１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaariwup01 zrnmvaariwup01}</td><td>（連携用）ＭＶＡ適用Ｗ（上昇）０１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaariwyentuktypeup01 zrnmvaariwyentuktypeup01}</td><td>（連携用）ＭＶＡ適用Ｗ換算通貨タイプ（上昇）０１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaariwupyendaka01 zrnmvaariwupyendaka01}</td><td>（連携用）ＭＶＡ適用Ｗ換算（上昇）円高０１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaariwupyenkijyun01 zrnmvaariwupyenkijyun01}</td><td>（連携用）ＭＶＡ適用Ｗ換算（上昇）中央値０１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaariwupyenyasu01 zrnmvaariwupyenyasu01}</td><td>（連携用）ＭＶＡ適用Ｗ換算（上昇）円安０１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaariwumupyendaka01 zrnmvaariwumupyendaka01}</td><td>（連携用）ＭＶＡ適用Ｗ換算目標額到達有無（上昇）円高０１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaariumupyenkijyun01 zrnmvaariumupyenkijyun01}</td><td>（連携用）ＭＶＡ適用Ｗ換算目標額到達有無（上昇）中央値０１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaariumupyenyasu01 zrnmvaariumupyenyasu01}</td><td>（連携用）ＭＶＡ適用Ｗ換算目標額到達有無（上昇）円安０１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaariwtuktypesame01 zrnmvaariwtuktypesame01}</td><td>（連携用）ＭＶＡ適用Ｗ通貨タイプ（同水準）０１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaaritmttknkykkjmsame01 zrnmvaaritmttknkykkjmsame01}</td><td>（連携用）ＭＶＡ適用積立金（解約控除前）（同水準）０１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaariwsame01 zrnmvaariwsame01}</td><td>（連携用）ＭＶＡ適用Ｗ（同水準）０１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaariwyentuktypesame01 zrnmvaariwyentuktypesame01}</td><td>（連携用）ＭＶＡ適用Ｗ換算通貨タイプ（同水準）０１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaariwsameyendaka01 zrnmvaariwsameyendaka01}</td><td>（連携用）ＭＶＡ適用Ｗ換算（同水準）円高０１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaariwsameyenkijyun01 zrnmvaariwsameyenkijyun01}</td><td>（連携用）ＭＶＡ適用Ｗ換算（同水準）中央値０１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaariwsameyenyasu01 zrnmvaariwsameyenyasu01}</td><td>（連携用）ＭＶＡ適用Ｗ換算（同水準）円安０１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaariumsameyendaka01 zrnmvaariumsameyendaka01}</td><td>（連携用）ＭＶＡ適用Ｗ換算目標額到達有無（同水準）円高０１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaariumsameyenkijyun01 zrnmvaariumsameyenkijyun01}</td><td>（連携用）ＭＶＡ適用Ｗ換算目標額到達有無（同水準）中央値０１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaariumsameyenyasu01 zrnmvaariumsameyenyasu01}</td><td>（連携用）ＭＶＡ適用Ｗ換算目標額到達有無（同水準）円安０１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaariwtuktypedown01 zrnmvaariwtuktypedown01}</td><td>（連携用）ＭＶＡ適用Ｗ通貨タイプ（低下）０１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaaritmttknkykkjmdown01 zrnmvaaritmttknkykkjmdown01}</td><td>（連携用）ＭＶＡ適用積立金（解約控除前）（低下）０１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaariwdown01 zrnmvaariwdown01}</td><td>（連携用）ＭＶＡ適用Ｗ（低下）０１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaariwyentuktypedown01 zrnmvaariwyentuktypedown01}</td><td>（連携用）ＭＶＡ適用Ｗ換算通貨タイプ（低下）０１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaariwdownyendaka01 zrnmvaariwdownyendaka01}</td><td>（連携用）ＭＶＡ適用Ｗ換算（低下）円高０１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaariwdownyenkijyun01 zrnmvaariwdownyenkijyun01}</td><td>（連携用）ＭＶＡ適用Ｗ換算（低下）中央値０１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaariwdownyenyasu01 zrnmvaariwdownyenyasu01}</td><td>（連携用）ＭＶＡ適用Ｗ換算（低下）円安０１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaariumdownyendaka01 zrnmvaariumdownyendaka01}</td><td>（連携用）ＭＶＡ適用Ｗ換算目標額到達有無（低下）円高０１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaariumdownyenkijyun01 zrnmvaariumdownyenkijyun01}</td><td>（連携用）ＭＶＡ適用Ｗ換算目標額到達有無（低下）中央値０１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaariumdownyenyasu01 zrnmvaariumdownyenyasu01}</td><td>（連携用）ＭＶＡ適用Ｗ換算目標額到達有無（低下）円安０１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaarivtuktype01 zrnmvaarivtuktype01}</td><td>（連携用）ＭＶＡ適用保険料積立金額通貨タイプ０１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaariv01 zrnmvaariv01}</td><td>（連携用）ＭＶＡ適用保険料積立金額０１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnptmttkngkutiwake101 zrnptmttkngkutiwake101}</td><td>（連携用）保険料積立金額内訳（１）０１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnptmttkngkutiwake201 zrnptmttkngkutiwake201}</td><td>（連携用）保険料積立金額内訳（２）０１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaarinenoutouym02 zrnmvaarinenoutouym02}</td><td>（連携用）ＭＶＡ適用年単位応当年月０２</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaarisisuuupritu02 zrnmvaarisisuuupritu02}</td><td>（連携用）ＭＶＡ適用指数上昇率０２</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaaritmttknzkritu02 zrnmvaaritmttknzkritu02}</td><td>（連携用）ＭＶＡ適用積立金増加率０２</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaariwtuktypeup02 zrnmvaariwtuktypeup02}</td><td>（連携用）ＭＶＡ適用Ｗ通貨タイプ（上昇）０２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaaritmttknkykkjmup02 zrnmvaaritmttknkykkjmup02}</td><td>（連携用）ＭＶＡ適用積立金（解約控除前）（上昇）０２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaariwup02 zrnmvaariwup02}</td><td>（連携用）ＭＶＡ適用Ｗ（上昇）０２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaariwyentuktypeup02 zrnmvaariwyentuktypeup02}</td><td>（連携用）ＭＶＡ適用Ｗ換算通貨タイプ（上昇）０２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaariwupyendaka02 zrnmvaariwupyendaka02}</td><td>（連携用）ＭＶＡ適用Ｗ換算（上昇）円高０２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaariwupyenkijyun02 zrnmvaariwupyenkijyun02}</td><td>（連携用）ＭＶＡ適用Ｗ換算（上昇）中央値０２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaariwupyenyasu02 zrnmvaariwupyenyasu02}</td><td>（連携用）ＭＶＡ適用Ｗ換算（上昇）円安０２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaariwumupyendaka02 zrnmvaariwumupyendaka02}</td><td>（連携用）ＭＶＡ適用Ｗ換算目標額到達有無（上昇）円高０２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaariumupyenkijyun02 zrnmvaariumupyenkijyun02}</td><td>（連携用）ＭＶＡ適用Ｗ換算目標額到達有無（上昇）中央値０２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaariumupyenyasu02 zrnmvaariumupyenyasu02}</td><td>（連携用）ＭＶＡ適用Ｗ換算目標額到達有無（上昇）円安０２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaariwtuktypesame02 zrnmvaariwtuktypesame02}</td><td>（連携用）ＭＶＡ適用Ｗ通貨タイプ（同水準）０２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaaritmttknkykkjmsame02 zrnmvaaritmttknkykkjmsame02}</td><td>（連携用）ＭＶＡ適用積立金（解約控除前）（同水準）０２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaariwsame02 zrnmvaariwsame02}</td><td>（連携用）ＭＶＡ適用Ｗ（同水準）０２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaariwyentuktypesame02 zrnmvaariwyentuktypesame02}</td><td>（連携用）ＭＶＡ適用Ｗ換算通貨タイプ（同水準）０２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaariwsameyendaka02 zrnmvaariwsameyendaka02}</td><td>（連携用）ＭＶＡ適用Ｗ換算（同水準）円高０２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaariwsameyenkijyun02 zrnmvaariwsameyenkijyun02}</td><td>（連携用）ＭＶＡ適用Ｗ換算（同水準）中央値０２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaariwsameyenyasu02 zrnmvaariwsameyenyasu02}</td><td>（連携用）ＭＶＡ適用Ｗ換算（同水準）円安０２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaariumsameyendaka02 zrnmvaariumsameyendaka02}</td><td>（連携用）ＭＶＡ適用Ｗ換算目標額到達有無（同水準）円高０２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaariumsameyenkijyun02 zrnmvaariumsameyenkijyun02}</td><td>（連携用）ＭＶＡ適用Ｗ換算目標額到達有無（同水準）中央値０２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaariumsameyenyasu02 zrnmvaariumsameyenyasu02}</td><td>（連携用）ＭＶＡ適用Ｗ換算目標額到達有無（同水準）円安０２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaariwtuktypedown02 zrnmvaariwtuktypedown02}</td><td>（連携用）ＭＶＡ適用Ｗ通貨タイプ（低下）０２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaaritmttknkykkjmdown02 zrnmvaaritmttknkykkjmdown02}</td><td>（連携用）ＭＶＡ適用積立金（解約控除前）（低下）０２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaariwdown02 zrnmvaariwdown02}</td><td>（連携用）ＭＶＡ適用Ｗ（低下）０２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaariwyentuktypedown02 zrnmvaariwyentuktypedown02}</td><td>（連携用）ＭＶＡ適用Ｗ換算通貨タイプ（低下）０２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaariwdownyendaka02 zrnmvaariwdownyendaka02}</td><td>（連携用）ＭＶＡ適用Ｗ換算（低下）円高０２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaariwdownyenkijyun02 zrnmvaariwdownyenkijyun02}</td><td>（連携用）ＭＶＡ適用Ｗ換算（低下）中央値０２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaariwdownyenyasu02 zrnmvaariwdownyenyasu02}</td><td>（連携用）ＭＶＡ適用Ｗ換算（低下）円安０２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaariumdownyendaka02 zrnmvaariumdownyendaka02}</td><td>（連携用）ＭＶＡ適用Ｗ換算目標額到達有無（低下）円高０２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaariumdownyenkijyun02 zrnmvaariumdownyenkijyun02}</td><td>（連携用）ＭＶＡ適用Ｗ換算目標額到達有無（低下）中央値０２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaariumdownyenyasu02 zrnmvaariumdownyenyasu02}</td><td>（連携用）ＭＶＡ適用Ｗ換算目標額到達有無（低下）円安０２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaarivtuktype02 zrnmvaarivtuktype02}</td><td>（連携用）ＭＶＡ適用保険料積立金額通貨タイプ０２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaariv02 zrnmvaariv02}</td><td>（連携用）ＭＶＡ適用保険料積立金額０２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnptmttkngkutiwake102 zrnptmttkngkutiwake102}</td><td>（連携用）保険料積立金額内訳（１）０２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnptmttkngkutiwake202 zrnptmttkngkutiwake202}</td><td>（連携用）保険料積立金額内訳（２）０２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaarinenoutouym03 zrnmvaarinenoutouym03}</td><td>（連携用）ＭＶＡ適用年単位応当年月０３</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaarisisuuupritu03 zrnmvaarisisuuupritu03}</td><td>（連携用）ＭＶＡ適用指数上昇率０３</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaaritmttknzkritu03 zrnmvaaritmttknzkritu03}</td><td>（連携用）ＭＶＡ適用積立金増加率０３</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaariwtuktypeup03 zrnmvaariwtuktypeup03}</td><td>（連携用）ＭＶＡ適用Ｗ通貨タイプ（上昇）０３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaaritmttknkykkjmup03 zrnmvaaritmttknkykkjmup03}</td><td>（連携用）ＭＶＡ適用積立金（解約控除前）（上昇）０３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaariwup03 zrnmvaariwup03}</td><td>（連携用）ＭＶＡ適用Ｗ（上昇）０３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaariwyentuktypeup03 zrnmvaariwyentuktypeup03}</td><td>（連携用）ＭＶＡ適用Ｗ換算通貨タイプ（上昇）０３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaariwupyendaka03 zrnmvaariwupyendaka03}</td><td>（連携用）ＭＶＡ適用Ｗ換算（上昇）円高０３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaariwupyenkijyun03 zrnmvaariwupyenkijyun03}</td><td>（連携用）ＭＶＡ適用Ｗ換算（上昇）中央値０３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaariwupyenyasu03 zrnmvaariwupyenyasu03}</td><td>（連携用）ＭＶＡ適用Ｗ換算（上昇）円安０３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaariwumupyendaka03 zrnmvaariwumupyendaka03}</td><td>（連携用）ＭＶＡ適用Ｗ換算目標額到達有無（上昇）円高０３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaariumupyenkijyun03 zrnmvaariumupyenkijyun03}</td><td>（連携用）ＭＶＡ適用Ｗ換算目標額到達有無（上昇）中央値０３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaariumupyenyasu03 zrnmvaariumupyenyasu03}</td><td>（連携用）ＭＶＡ適用Ｗ換算目標額到達有無（上昇）円安０３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaariwtuktypesame03 zrnmvaariwtuktypesame03}</td><td>（連携用）ＭＶＡ適用Ｗ通貨タイプ（同水準）０３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaaritmttknkykkjmsame03 zrnmvaaritmttknkykkjmsame03}</td><td>（連携用）ＭＶＡ適用積立金（解約控除前）（同水準）０３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaariwsame03 zrnmvaariwsame03}</td><td>（連携用）ＭＶＡ適用Ｗ（同水準）０３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaariwyentuktypesame03 zrnmvaariwyentuktypesame03}</td><td>（連携用）ＭＶＡ適用Ｗ換算通貨タイプ（同水準）０３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaariwsameyendaka03 zrnmvaariwsameyendaka03}</td><td>（連携用）ＭＶＡ適用Ｗ換算（同水準）円高０３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaariwsameyenkijyun03 zrnmvaariwsameyenkijyun03}</td><td>（連携用）ＭＶＡ適用Ｗ換算（同水準）中央値０３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaariwsameyenyasu03 zrnmvaariwsameyenyasu03}</td><td>（連携用）ＭＶＡ適用Ｗ換算（同水準）円安０３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaariumsameyendaka03 zrnmvaariumsameyendaka03}</td><td>（連携用）ＭＶＡ適用Ｗ換算目標額到達有無（同水準）円高０３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaariumsameyenkijyun03 zrnmvaariumsameyenkijyun03}</td><td>（連携用）ＭＶＡ適用Ｗ換算目標額到達有無（同水準）中央値０３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaariumsameyenyasu03 zrnmvaariumsameyenyasu03}</td><td>（連携用）ＭＶＡ適用Ｗ換算目標額到達有無（同水準）円安０３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaariwtuktypedown03 zrnmvaariwtuktypedown03}</td><td>（連携用）ＭＶＡ適用Ｗ通貨タイプ（低下）０３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaaritmttknkykkjmdown03 zrnmvaaritmttknkykkjmdown03}</td><td>（連携用）ＭＶＡ適用積立金（解約控除前）（低下）０３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaariwdown03 zrnmvaariwdown03}</td><td>（連携用）ＭＶＡ適用Ｗ（低下）０３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaariwyentuktypedown03 zrnmvaariwyentuktypedown03}</td><td>（連携用）ＭＶＡ適用Ｗ換算通貨タイプ（低下）０３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaariwdownyendaka03 zrnmvaariwdownyendaka03}</td><td>（連携用）ＭＶＡ適用Ｗ換算（低下）円高０３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaariwdownyenkijyun03 zrnmvaariwdownyenkijyun03}</td><td>（連携用）ＭＶＡ適用Ｗ換算（低下）中央値０３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaariwdownyenyasu03 zrnmvaariwdownyenyasu03}</td><td>（連携用）ＭＶＡ適用Ｗ換算（低下）円安０３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaariumdownyendaka03 zrnmvaariumdownyendaka03}</td><td>（連携用）ＭＶＡ適用Ｗ換算目標額到達有無（低下）円高０３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaariumdownyenkijyun03 zrnmvaariumdownyenkijyun03}</td><td>（連携用）ＭＶＡ適用Ｗ換算目標額到達有無（低下）中央値０３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaariumdownyenyasu03 zrnmvaariumdownyenyasu03}</td><td>（連携用）ＭＶＡ適用Ｗ換算目標額到達有無（低下）円安０３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaarivtuktype03 zrnmvaarivtuktype03}</td><td>（連携用）ＭＶＡ適用保険料積立金額通貨タイプ０３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaariv03 zrnmvaariv03}</td><td>（連携用）ＭＶＡ適用保険料積立金額０３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnptmttkngkutiwake103 zrnptmttkngkutiwake103}</td><td>（連携用）保険料積立金額内訳（１）０３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnptmttkngkutiwake203 zrnptmttkngkutiwake203}</td><td>（連携用）保険料積立金額内訳（２）０３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaarinenoutouym04 zrnmvaarinenoutouym04}</td><td>（連携用）ＭＶＡ適用年単位応当年月０４</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaarisisuuupritu04 zrnmvaarisisuuupritu04}</td><td>（連携用）ＭＶＡ適用指数上昇率０４</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaaritmttknzkritu04 zrnmvaaritmttknzkritu04}</td><td>（連携用）ＭＶＡ適用積立金増加率０４</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaariwtuktypeup04 zrnmvaariwtuktypeup04}</td><td>（連携用）ＭＶＡ適用Ｗ通貨タイプ（上昇）０４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaaritmttknkykkjmup04 zrnmvaaritmttknkykkjmup04}</td><td>（連携用）ＭＶＡ適用積立金（解約控除前）（上昇）０４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaariwup04 zrnmvaariwup04}</td><td>（連携用）ＭＶＡ適用Ｗ（上昇）０４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaariwyentuktypeup04 zrnmvaariwyentuktypeup04}</td><td>（連携用）ＭＶＡ適用Ｗ換算通貨タイプ（上昇）０４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaariwupyendaka04 zrnmvaariwupyendaka04}</td><td>（連携用）ＭＶＡ適用Ｗ換算（上昇）円高０４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaariwupyenkijyun04 zrnmvaariwupyenkijyun04}</td><td>（連携用）ＭＶＡ適用Ｗ換算（上昇）中央値０４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaariwupyenyasu04 zrnmvaariwupyenyasu04}</td><td>（連携用）ＭＶＡ適用Ｗ換算（上昇）円安０４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaariwumupyendaka04 zrnmvaariwumupyendaka04}</td><td>（連携用）ＭＶＡ適用Ｗ換算目標額到達有無（上昇）円高０４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaariumupyenkijyun04 zrnmvaariumupyenkijyun04}</td><td>（連携用）ＭＶＡ適用Ｗ換算目標額到達有無（上昇）中央値０４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaariumupyenyasu04 zrnmvaariumupyenyasu04}</td><td>（連携用）ＭＶＡ適用Ｗ換算目標額到達有無（上昇）円安０４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaariwtuktypesame04 zrnmvaariwtuktypesame04}</td><td>（連携用）ＭＶＡ適用Ｗ通貨タイプ（同水準）０４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaaritmttknkykkjmsame04 zrnmvaaritmttknkykkjmsame04}</td><td>（連携用）ＭＶＡ適用積立金（解約控除前）（同水準）０４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaariwsame04 zrnmvaariwsame04}</td><td>（連携用）ＭＶＡ適用Ｗ（同水準）０４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaariwyentuktypesame04 zrnmvaariwyentuktypesame04}</td><td>（連携用）ＭＶＡ適用Ｗ換算通貨タイプ（同水準）０４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaariwsameyendaka04 zrnmvaariwsameyendaka04}</td><td>（連携用）ＭＶＡ適用Ｗ換算（同水準）円高０４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaariwsameyenkijyun04 zrnmvaariwsameyenkijyun04}</td><td>（連携用）ＭＶＡ適用Ｗ換算（同水準）中央値０４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaariwsameyenyasu04 zrnmvaariwsameyenyasu04}</td><td>（連携用）ＭＶＡ適用Ｗ換算（同水準）円安０４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaariumsameyendaka04 zrnmvaariumsameyendaka04}</td><td>（連携用）ＭＶＡ適用Ｗ換算目標額到達有無（同水準）円高０４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaariumsameyenkijyun04 zrnmvaariumsameyenkijyun04}</td><td>（連携用）ＭＶＡ適用Ｗ換算目標額到達有無（同水準）中央値０４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaariumsameyenyasu04 zrnmvaariumsameyenyasu04}</td><td>（連携用）ＭＶＡ適用Ｗ換算目標額到達有無（同水準）円安０４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaariwtuktypedown04 zrnmvaariwtuktypedown04}</td><td>（連携用）ＭＶＡ適用Ｗ通貨タイプ（低下）０４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaaritmttknkykkjmdown04 zrnmvaaritmttknkykkjmdown04}</td><td>（連携用）ＭＶＡ適用積立金（解約控除前）（低下）０４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaariwdown04 zrnmvaariwdown04}</td><td>（連携用）ＭＶＡ適用Ｗ（低下）０４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaariwyentuktypedown04 zrnmvaariwyentuktypedown04}</td><td>（連携用）ＭＶＡ適用Ｗ換算通貨タイプ（低下）０４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaariwdownyendaka04 zrnmvaariwdownyendaka04}</td><td>（連携用）ＭＶＡ適用Ｗ換算（低下）円高０４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaariwdownyenkijyun04 zrnmvaariwdownyenkijyun04}</td><td>（連携用）ＭＶＡ適用Ｗ換算（低下）中央値０４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaariwdownyenyasu04 zrnmvaariwdownyenyasu04}</td><td>（連携用）ＭＶＡ適用Ｗ換算（低下）円安０４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaariumdownyendaka04 zrnmvaariumdownyendaka04}</td><td>（連携用）ＭＶＡ適用Ｗ換算目標額到達有無（低下）円高０４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaariumdownyenkijyun04 zrnmvaariumdownyenkijyun04}</td><td>（連携用）ＭＶＡ適用Ｗ換算目標額到達有無（低下）中央値０４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaariumdownyenyasu04 zrnmvaariumdownyenyasu04}</td><td>（連携用）ＭＶＡ適用Ｗ換算目標額到達有無（低下）円安０４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaarivtuktype04 zrnmvaarivtuktype04}</td><td>（連携用）ＭＶＡ適用保険料積立金額通貨タイプ０４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaariv04 zrnmvaariv04}</td><td>（連携用）ＭＶＡ適用保険料積立金額０４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnptmttkngkutiwake104 zrnptmttkngkutiwake104}</td><td>（連携用）保険料積立金額内訳（１）０４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnptmttkngkutiwake204 zrnptmttkngkutiwake204}</td><td>（連携用）保険料積立金額内訳（２）０４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaarinenoutouym05 zrnmvaarinenoutouym05}</td><td>（連携用）ＭＶＡ適用年単位応当年月０５</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaarisisuuupritu05 zrnmvaarisisuuupritu05}</td><td>（連携用）ＭＶＡ適用指数上昇率０５</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaaritmttknzkritu05 zrnmvaaritmttknzkritu05}</td><td>（連携用）ＭＶＡ適用積立金増加率０５</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaariwtuktypeup05 zrnmvaariwtuktypeup05}</td><td>（連携用）ＭＶＡ適用Ｗ通貨タイプ（上昇）０５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaaritmttknkykkjmup05 zrnmvaaritmttknkykkjmup05}</td><td>（連携用）ＭＶＡ適用積立金（解約控除前）（上昇）０５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaariwup05 zrnmvaariwup05}</td><td>（連携用）ＭＶＡ適用Ｗ（上昇）０５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaariwyentuktypeup05 zrnmvaariwyentuktypeup05}</td><td>（連携用）ＭＶＡ適用Ｗ換算通貨タイプ（上昇）０５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaariwupyendaka05 zrnmvaariwupyendaka05}</td><td>（連携用）ＭＶＡ適用Ｗ換算（上昇）円高０５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaariwupyenkijyun05 zrnmvaariwupyenkijyun05}</td><td>（連携用）ＭＶＡ適用Ｗ換算（上昇）中央値０５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaariwupyenyasu05 zrnmvaariwupyenyasu05}</td><td>（連携用）ＭＶＡ適用Ｗ換算（上昇）円安０５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaariwumupyendaka05 zrnmvaariwumupyendaka05}</td><td>（連携用）ＭＶＡ適用Ｗ換算目標額到達有無（上昇）円高０５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaariumupyenkijyun05 zrnmvaariumupyenkijyun05}</td><td>（連携用）ＭＶＡ適用Ｗ換算目標額到達有無（上昇）中央値０５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaariumupyenyasu05 zrnmvaariumupyenyasu05}</td><td>（連携用）ＭＶＡ適用Ｗ換算目標額到達有無（上昇）円安０５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaariwtuktypesame05 zrnmvaariwtuktypesame05}</td><td>（連携用）ＭＶＡ適用Ｗ通貨タイプ（同水準）０５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaaritmttknkykkjmsame05 zrnmvaaritmttknkykkjmsame05}</td><td>（連携用）ＭＶＡ適用積立金（解約控除前）（同水準）０５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaariwsame05 zrnmvaariwsame05}</td><td>（連携用）ＭＶＡ適用Ｗ（同水準）０５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaariwyentuktypesame05 zrnmvaariwyentuktypesame05}</td><td>（連携用）ＭＶＡ適用Ｗ換算通貨タイプ（同水準）０５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaariwsameyendaka05 zrnmvaariwsameyendaka05}</td><td>（連携用）ＭＶＡ適用Ｗ換算（同水準）円高０５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaariwsameyenkijyun05 zrnmvaariwsameyenkijyun05}</td><td>（連携用）ＭＶＡ適用Ｗ換算（同水準）中央値０５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaariwsameyenyasu05 zrnmvaariwsameyenyasu05}</td><td>（連携用）ＭＶＡ適用Ｗ換算（同水準）円安０５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaariumsameyendaka05 zrnmvaariumsameyendaka05}</td><td>（連携用）ＭＶＡ適用Ｗ換算目標額到達有無（同水準）円高０５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaariumsameyenkijyun05 zrnmvaariumsameyenkijyun05}</td><td>（連携用）ＭＶＡ適用Ｗ換算目標額到達有無（同水準）中央値０５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaariumsameyenyasu05 zrnmvaariumsameyenyasu05}</td><td>（連携用）ＭＶＡ適用Ｗ換算目標額到達有無（同水準）円安０５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaariwtuktypedown05 zrnmvaariwtuktypedown05}</td><td>（連携用）ＭＶＡ適用Ｗ通貨タイプ（低下）０５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaaritmttknkykkjmdown05 zrnmvaaritmttknkykkjmdown05}</td><td>（連携用）ＭＶＡ適用積立金（解約控除前）（低下）０５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaariwdown05 zrnmvaariwdown05}</td><td>（連携用）ＭＶＡ適用Ｗ（低下）０５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaariwyentuktypedown05 zrnmvaariwyentuktypedown05}</td><td>（連携用）ＭＶＡ適用Ｗ換算通貨タイプ（低下）０５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaariwdownyendaka05 zrnmvaariwdownyendaka05}</td><td>（連携用）ＭＶＡ適用Ｗ換算（低下）円高０５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaariwdownyenkijyun05 zrnmvaariwdownyenkijyun05}</td><td>（連携用）ＭＶＡ適用Ｗ換算（低下）中央値０５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaariwdownyenyasu05 zrnmvaariwdownyenyasu05}</td><td>（連携用）ＭＶＡ適用Ｗ換算（低下）円安０５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaariumdownyendaka05 zrnmvaariumdownyendaka05}</td><td>（連携用）ＭＶＡ適用Ｗ換算目標額到達有無（低下）円高０５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaariumdownyenkijyun05 zrnmvaariumdownyenkijyun05}</td><td>（連携用）ＭＶＡ適用Ｗ換算目標額到達有無（低下）中央値０５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaariumdownyenyasu05 zrnmvaariumdownyenyasu05}</td><td>（連携用）ＭＶＡ適用Ｗ換算目標額到達有無（低下）円安０５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaarivtuktype05 zrnmvaarivtuktype05}</td><td>（連携用）ＭＶＡ適用保険料積立金額通貨タイプ０５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaariv05 zrnmvaariv05}</td><td>（連携用）ＭＶＡ適用保険料積立金額０５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnptmttkngkutiwake105 zrnptmttkngkutiwake105}</td><td>（連携用）保険料積立金額内訳（１）０５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnptmttkngkutiwake205 zrnptmttkngkutiwake205}</td><td>（連携用）保険料積立金額内訳（２）０５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaarinenoutouym06 zrnmvaarinenoutouym06}</td><td>（連携用）ＭＶＡ適用年単位応当年月０６</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaarisisuuupritu06 zrnmvaarisisuuupritu06}</td><td>（連携用）ＭＶＡ適用指数上昇率０６</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaaritmttknzkritu06 zrnmvaaritmttknzkritu06}</td><td>（連携用）ＭＶＡ適用積立金増加率０６</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaariwtuktypeup06 zrnmvaariwtuktypeup06}</td><td>（連携用）ＭＶＡ適用Ｗ通貨タイプ（上昇）０６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaaritmttknkykkjmup06 zrnmvaaritmttknkykkjmup06}</td><td>（連携用）ＭＶＡ適用積立金（解約控除前）（上昇）０６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaariwup06 zrnmvaariwup06}</td><td>（連携用）ＭＶＡ適用Ｗ（上昇）０６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaariwyentuktypeup06 zrnmvaariwyentuktypeup06}</td><td>（連携用）ＭＶＡ適用Ｗ換算通貨タイプ（上昇）０６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaariwupyendaka06 zrnmvaariwupyendaka06}</td><td>（連携用）ＭＶＡ適用Ｗ換算（上昇）円高０６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaariwupyenkijyun06 zrnmvaariwupyenkijyun06}</td><td>（連携用）ＭＶＡ適用Ｗ換算（上昇）中央値０６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaariwupyenyasu06 zrnmvaariwupyenyasu06}</td><td>（連携用）ＭＶＡ適用Ｗ換算（上昇）円安０６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaariwumupyendaka06 zrnmvaariwumupyendaka06}</td><td>（連携用）ＭＶＡ適用Ｗ換算目標額到達有無（上昇）円高０６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaariumupyenkijyun06 zrnmvaariumupyenkijyun06}</td><td>（連携用）ＭＶＡ適用Ｗ換算目標額到達有無（上昇）中央値０６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaariumupyenyasu06 zrnmvaariumupyenyasu06}</td><td>（連携用）ＭＶＡ適用Ｗ換算目標額到達有無（上昇）円安０６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaariwtuktypesame06 zrnmvaariwtuktypesame06}</td><td>（連携用）ＭＶＡ適用Ｗ通貨タイプ（同水準）０６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaaritmttknkykkjmsame06 zrnmvaaritmttknkykkjmsame06}</td><td>（連携用）ＭＶＡ適用積立金（解約控除前）（同水準）０６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaariwsame06 zrnmvaariwsame06}</td><td>（連携用）ＭＶＡ適用Ｗ（同水準）０６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaariwyentuktypesame06 zrnmvaariwyentuktypesame06}</td><td>（連携用）ＭＶＡ適用Ｗ換算通貨タイプ（同水準）０６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaariwsameyendaka06 zrnmvaariwsameyendaka06}</td><td>（連携用）ＭＶＡ適用Ｗ換算（同水準）円高０６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaariwsameyenkijyun06 zrnmvaariwsameyenkijyun06}</td><td>（連携用）ＭＶＡ適用Ｗ換算（同水準）中央値０６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaariwsameyenyasu06 zrnmvaariwsameyenyasu06}</td><td>（連携用）ＭＶＡ適用Ｗ換算（同水準）円安０６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaariumsameyendaka06 zrnmvaariumsameyendaka06}</td><td>（連携用）ＭＶＡ適用Ｗ換算目標額到達有無（同水準）円高０６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaariumsameyenkijyun06 zrnmvaariumsameyenkijyun06}</td><td>（連携用）ＭＶＡ適用Ｗ換算目標額到達有無（同水準）中央値０６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaariumsameyenyasu06 zrnmvaariumsameyenyasu06}</td><td>（連携用）ＭＶＡ適用Ｗ換算目標額到達有無（同水準）円安０６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaariwtuktypedown06 zrnmvaariwtuktypedown06}</td><td>（連携用）ＭＶＡ適用Ｗ通貨タイプ（低下）０６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaaritmttknkykkjmdown06 zrnmvaaritmttknkykkjmdown06}</td><td>（連携用）ＭＶＡ適用積立金（解約控除前）（低下）０６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaariwdown06 zrnmvaariwdown06}</td><td>（連携用）ＭＶＡ適用Ｗ（低下）０６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaariwyentuktypedown06 zrnmvaariwyentuktypedown06}</td><td>（連携用）ＭＶＡ適用Ｗ換算通貨タイプ（低下）０６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaariwdownyendaka06 zrnmvaariwdownyendaka06}</td><td>（連携用）ＭＶＡ適用Ｗ換算（低下）円高０６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaariwdownyenkijyun06 zrnmvaariwdownyenkijyun06}</td><td>（連携用）ＭＶＡ適用Ｗ換算（低下）中央値０６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaariwdownyenyasu06 zrnmvaariwdownyenyasu06}</td><td>（連携用）ＭＶＡ適用Ｗ換算（低下）円安０６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaariumdownyendaka06 zrnmvaariumdownyendaka06}</td><td>（連携用）ＭＶＡ適用Ｗ換算目標額到達有無（低下）円高０６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaariumdownyenkijyun06 zrnmvaariumdownyenkijyun06}</td><td>（連携用）ＭＶＡ適用Ｗ換算目標額到達有無（低下）中央値０６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaariumdownyenyasu06 zrnmvaariumdownyenyasu06}</td><td>（連携用）ＭＶＡ適用Ｗ換算目標額到達有無（低下）円安０６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaarivtuktype06 zrnmvaarivtuktype06}</td><td>（連携用）ＭＶＡ適用保険料積立金額通貨タイプ０６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaariv06 zrnmvaariv06}</td><td>（連携用）ＭＶＡ適用保険料積立金額０６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnptmttkngkutiwake106 zrnptmttkngkutiwake106}</td><td>（連携用）保険料積立金額内訳（１）０６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnptmttkngkutiwake206 zrnptmttkngkutiwake206}</td><td>（連携用）保険料積立金額内訳（２）０６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaarinenoutouym07 zrnmvaarinenoutouym07}</td><td>（連携用）ＭＶＡ適用年単位応当年月０７</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaarisisuuupritu07 zrnmvaarisisuuupritu07}</td><td>（連携用）ＭＶＡ適用指数上昇率０７</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaaritmttknzkritu07 zrnmvaaritmttknzkritu07}</td><td>（連携用）ＭＶＡ適用積立金増加率０７</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaariwtuktypeup07 zrnmvaariwtuktypeup07}</td><td>（連携用）ＭＶＡ適用Ｗ通貨タイプ（上昇）０７</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaaritmttknkykkjmup07 zrnmvaaritmttknkykkjmup07}</td><td>（連携用）ＭＶＡ適用積立金（解約控除前）（上昇）０７</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaariwup07 zrnmvaariwup07}</td><td>（連携用）ＭＶＡ適用Ｗ（上昇）０７</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaariwyentuktypeup07 zrnmvaariwyentuktypeup07}</td><td>（連携用）ＭＶＡ適用Ｗ換算通貨タイプ（上昇）０７</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaariwupyendaka07 zrnmvaariwupyendaka07}</td><td>（連携用）ＭＶＡ適用Ｗ換算（上昇）円高０７</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaariwupyenkijyun07 zrnmvaariwupyenkijyun07}</td><td>（連携用）ＭＶＡ適用Ｗ換算（上昇）中央値０７</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaariwupyenyasu07 zrnmvaariwupyenyasu07}</td><td>（連携用）ＭＶＡ適用Ｗ換算（上昇）円安０７</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaariwumupyendaka07 zrnmvaariwumupyendaka07}</td><td>（連携用）ＭＶＡ適用Ｗ換算目標額到達有無（上昇）円高０７</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaariumupyenkijyun07 zrnmvaariumupyenkijyun07}</td><td>（連携用）ＭＶＡ適用Ｗ換算目標額到達有無（上昇）中央値０７</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaariumupyenyasu07 zrnmvaariumupyenyasu07}</td><td>（連携用）ＭＶＡ適用Ｗ換算目標額到達有無（上昇）円安０７</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaariwtuktypesame07 zrnmvaariwtuktypesame07}</td><td>（連携用）ＭＶＡ適用Ｗ通貨タイプ（同水準）０７</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaaritmttknkykkjmsame07 zrnmvaaritmttknkykkjmsame07}</td><td>（連携用）ＭＶＡ適用積立金（解約控除前）（同水準）０７</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaariwsame07 zrnmvaariwsame07}</td><td>（連携用）ＭＶＡ適用Ｗ（同水準）０７</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaariwyentuktypesame07 zrnmvaariwyentuktypesame07}</td><td>（連携用）ＭＶＡ適用Ｗ換算通貨タイプ（同水準）０７</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaariwsameyendaka07 zrnmvaariwsameyendaka07}</td><td>（連携用）ＭＶＡ適用Ｗ換算（同水準）円高０７</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaariwsameyenkijyun07 zrnmvaariwsameyenkijyun07}</td><td>（連携用）ＭＶＡ適用Ｗ換算（同水準）中央値０７</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaariwsameyenyasu07 zrnmvaariwsameyenyasu07}</td><td>（連携用）ＭＶＡ適用Ｗ換算（同水準）円安０７</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaariumsameyendaka07 zrnmvaariumsameyendaka07}</td><td>（連携用）ＭＶＡ適用Ｗ換算目標額到達有無（同水準）円高０７</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaariumsameyenkijyun07 zrnmvaariumsameyenkijyun07}</td><td>（連携用）ＭＶＡ適用Ｗ換算目標額到達有無（同水準）中央値０７</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaariumsameyenyasu07 zrnmvaariumsameyenyasu07}</td><td>（連携用）ＭＶＡ適用Ｗ換算目標額到達有無（同水準）円安０７</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaariwtuktypedown07 zrnmvaariwtuktypedown07}</td><td>（連携用）ＭＶＡ適用Ｗ通貨タイプ（低下）０７</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaaritmttknkykkjmdown07 zrnmvaaritmttknkykkjmdown07}</td><td>（連携用）ＭＶＡ適用積立金（解約控除前）（低下）０７</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaariwdown07 zrnmvaariwdown07}</td><td>（連携用）ＭＶＡ適用Ｗ（低下）０７</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaariwyentuktypedown07 zrnmvaariwyentuktypedown07}</td><td>（連携用）ＭＶＡ適用Ｗ換算通貨タイプ（低下）０７</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaariwdownyendaka07 zrnmvaariwdownyendaka07}</td><td>（連携用）ＭＶＡ適用Ｗ換算（低下）円高０７</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaariwdownyenkijyun07 zrnmvaariwdownyenkijyun07}</td><td>（連携用）ＭＶＡ適用Ｗ換算（低下）中央値０７</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaariwdownyenyasu07 zrnmvaariwdownyenyasu07}</td><td>（連携用）ＭＶＡ適用Ｗ換算（低下）円安０７</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaariumdownyendaka07 zrnmvaariumdownyendaka07}</td><td>（連携用）ＭＶＡ適用Ｗ換算目標額到達有無（低下）円高０７</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaariumdownyenkijyun07 zrnmvaariumdownyenkijyun07}</td><td>（連携用）ＭＶＡ適用Ｗ換算目標額到達有無（低下）中央値０７</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaariumdownyenyasu07 zrnmvaariumdownyenyasu07}</td><td>（連携用）ＭＶＡ適用Ｗ換算目標額到達有無（低下）円安０７</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaarivtuktype07 zrnmvaarivtuktype07}</td><td>（連携用）ＭＶＡ適用保険料積立金額通貨タイプ０７</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaariv07 zrnmvaariv07}</td><td>（連携用）ＭＶＡ適用保険料積立金額０７</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnptmttkngkutiwake107 zrnptmttkngkutiwake107}</td><td>（連携用）保険料積立金額内訳（１）０７</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnptmttkngkutiwake207 zrnptmttkngkutiwake207}</td><td>（連携用）保険料積立金額内訳（２）０７</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaarinenoutouym08 zrnmvaarinenoutouym08}</td><td>（連携用）ＭＶＡ適用年単位応当年月０８</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaarisisuuupritu08 zrnmvaarisisuuupritu08}</td><td>（連携用）ＭＶＡ適用指数上昇率０８</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaaritmttknzkritu08 zrnmvaaritmttknzkritu08}</td><td>（連携用）ＭＶＡ適用積立金増加率０８</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaariwtuktypeup08 zrnmvaariwtuktypeup08}</td><td>（連携用）ＭＶＡ適用Ｗ通貨タイプ（上昇）０８</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaaritmttknkykkjmup08 zrnmvaaritmttknkykkjmup08}</td><td>（連携用）ＭＶＡ適用積立金（解約控除前）（上昇）０８</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaariwup08 zrnmvaariwup08}</td><td>（連携用）ＭＶＡ適用Ｗ（上昇）０８</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaariwyentuktypeup08 zrnmvaariwyentuktypeup08}</td><td>（連携用）ＭＶＡ適用Ｗ換算通貨タイプ（上昇）０８</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaariwupyendaka08 zrnmvaariwupyendaka08}</td><td>（連携用）ＭＶＡ適用Ｗ換算（上昇）円高０８</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaariwupyenkijyun08 zrnmvaariwupyenkijyun08}</td><td>（連携用）ＭＶＡ適用Ｗ換算（上昇）中央値０８</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaariwupyenyasu08 zrnmvaariwupyenyasu08}</td><td>（連携用）ＭＶＡ適用Ｗ換算（上昇）円安０８</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaariwumupyendaka08 zrnmvaariwumupyendaka08}</td><td>（連携用）ＭＶＡ適用Ｗ換算目標額到達有無（上昇）円高０８</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaariumupyenkijyun08 zrnmvaariumupyenkijyun08}</td><td>（連携用）ＭＶＡ適用Ｗ換算目標額到達有無（上昇）中央値０８</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaariumupyenyasu08 zrnmvaariumupyenyasu08}</td><td>（連携用）ＭＶＡ適用Ｗ換算目標額到達有無（上昇）円安０８</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaariwtuktypesame08 zrnmvaariwtuktypesame08}</td><td>（連携用）ＭＶＡ適用Ｗ通貨タイプ（同水準）０８</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaaritmttknkykkjmsame08 zrnmvaaritmttknkykkjmsame08}</td><td>（連携用）ＭＶＡ適用積立金（解約控除前）（同水準）０８</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaariwsame08 zrnmvaariwsame08}</td><td>（連携用）ＭＶＡ適用Ｗ（同水準）０８</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaariwyentuktypesame08 zrnmvaariwyentuktypesame08}</td><td>（連携用）ＭＶＡ適用Ｗ換算通貨タイプ（同水準）０８</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaariwsameyendaka08 zrnmvaariwsameyendaka08}</td><td>（連携用）ＭＶＡ適用Ｗ換算（同水準）円高０８</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaariwsameyenkijyun08 zrnmvaariwsameyenkijyun08}</td><td>（連携用）ＭＶＡ適用Ｗ換算（同水準）中央値０８</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaariwsameyenyasu08 zrnmvaariwsameyenyasu08}</td><td>（連携用）ＭＶＡ適用Ｗ換算（同水準）円安０８</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaariumsameyendaka08 zrnmvaariumsameyendaka08}</td><td>（連携用）ＭＶＡ適用Ｗ換算目標額到達有無（同水準）円高０８</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaariumsameyenkijyun08 zrnmvaariumsameyenkijyun08}</td><td>（連携用）ＭＶＡ適用Ｗ換算目標額到達有無（同水準）中央値０８</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaariumsameyenyasu08 zrnmvaariumsameyenyasu08}</td><td>（連携用）ＭＶＡ適用Ｗ換算目標額到達有無（同水準）円安０８</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaariwtuktypedown08 zrnmvaariwtuktypedown08}</td><td>（連携用）ＭＶＡ適用Ｗ通貨タイプ（低下）０８</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaaritmttknkykkjmdown08 zrnmvaaritmttknkykkjmdown08}</td><td>（連携用）ＭＶＡ適用積立金（解約控除前）（低下）０８</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaariwdown08 zrnmvaariwdown08}</td><td>（連携用）ＭＶＡ適用Ｗ（低下）０８</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaariwyentuktypedown08 zrnmvaariwyentuktypedown08}</td><td>（連携用）ＭＶＡ適用Ｗ換算通貨タイプ（低下）０８</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaariwdownyendaka08 zrnmvaariwdownyendaka08}</td><td>（連携用）ＭＶＡ適用Ｗ換算（低下）円高０８</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaariwdownyenkijyun08 zrnmvaariwdownyenkijyun08}</td><td>（連携用）ＭＶＡ適用Ｗ換算（低下）中央値０８</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaariwdownyenyasu08 zrnmvaariwdownyenyasu08}</td><td>（連携用）ＭＶＡ適用Ｗ換算（低下）円安０８</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaariumdownyendaka08 zrnmvaariumdownyendaka08}</td><td>（連携用）ＭＶＡ適用Ｗ換算目標額到達有無（低下）円高０８</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaariumdownyenkijyun08 zrnmvaariumdownyenkijyun08}</td><td>（連携用）ＭＶＡ適用Ｗ換算目標額到達有無（低下）中央値０８</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaariumdownyenyasu08 zrnmvaariumdownyenyasu08}</td><td>（連携用）ＭＶＡ適用Ｗ換算目標額到達有無（低下）円安０８</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaarivtuktype08 zrnmvaarivtuktype08}</td><td>（連携用）ＭＶＡ適用保険料積立金額通貨タイプ０８</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaariv08 zrnmvaariv08}</td><td>（連携用）ＭＶＡ適用保険料積立金額０８</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnptmttkngkutiwake108 zrnptmttkngkutiwake108}</td><td>（連携用）保険料積立金額内訳（１）０８</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnptmttkngkutiwake208 zrnptmttkngkutiwake208}</td><td>（連携用）保険料積立金額内訳（２）０８</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaarinenoutouym09 zrnmvaarinenoutouym09}</td><td>（連携用）ＭＶＡ適用年単位応当年月０９</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaarisisuuupritu09 zrnmvaarisisuuupritu09}</td><td>（連携用）ＭＶＡ適用指数上昇率０９</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaaritmttknzkritu09 zrnmvaaritmttknzkritu09}</td><td>（連携用）ＭＶＡ適用積立金増加率０９</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaariwtuktypeup09 zrnmvaariwtuktypeup09}</td><td>（連携用）ＭＶＡ適用Ｗ通貨タイプ（上昇）０９</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaaritmttknkykkjmup09 zrnmvaaritmttknkykkjmup09}</td><td>（連携用）ＭＶＡ適用積立金（解約控除前）（上昇）０９</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaariwup09 zrnmvaariwup09}</td><td>（連携用）ＭＶＡ適用Ｗ（上昇）０９</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaariwyentuktypeup09 zrnmvaariwyentuktypeup09}</td><td>（連携用）ＭＶＡ適用Ｗ換算通貨タイプ（上昇）０９</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaariwupyendaka09 zrnmvaariwupyendaka09}</td><td>（連携用）ＭＶＡ適用Ｗ換算（上昇）円高０９</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaariwupyenkijyun09 zrnmvaariwupyenkijyun09}</td><td>（連携用）ＭＶＡ適用Ｗ換算（上昇）中央値０９</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaariwupyenyasu09 zrnmvaariwupyenyasu09}</td><td>（連携用）ＭＶＡ適用Ｗ換算（上昇）円安０９</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaariwumupyendaka09 zrnmvaariwumupyendaka09}</td><td>（連携用）ＭＶＡ適用Ｗ換算目標額到達有無（上昇）円高０９</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaariumupyenkijyun09 zrnmvaariumupyenkijyun09}</td><td>（連携用）ＭＶＡ適用Ｗ換算目標額到達有無（上昇）中央値０９</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaariumupyenyasu09 zrnmvaariumupyenyasu09}</td><td>（連携用）ＭＶＡ適用Ｗ換算目標額到達有無（上昇）円安０９</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaariwtuktypesame09 zrnmvaariwtuktypesame09}</td><td>（連携用）ＭＶＡ適用Ｗ通貨タイプ（同水準）０９</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaaritmttknkykkjmsame09 zrnmvaaritmttknkykkjmsame09}</td><td>（連携用）ＭＶＡ適用積立金（解約控除前）（同水準）０９</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaariwsame09 zrnmvaariwsame09}</td><td>（連携用）ＭＶＡ適用Ｗ（同水準）０９</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaariwyentuktypesame09 zrnmvaariwyentuktypesame09}</td><td>（連携用）ＭＶＡ適用Ｗ換算通貨タイプ（同水準）０９</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaariwsameyendaka09 zrnmvaariwsameyendaka09}</td><td>（連携用）ＭＶＡ適用Ｗ換算（同水準）円高０９</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaariwsameyenkijyun09 zrnmvaariwsameyenkijyun09}</td><td>（連携用）ＭＶＡ適用Ｗ換算（同水準）中央値０９</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaariwsameyenyasu09 zrnmvaariwsameyenyasu09}</td><td>（連携用）ＭＶＡ適用Ｗ換算（同水準）円安０９</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaariumsameyendaka09 zrnmvaariumsameyendaka09}</td><td>（連携用）ＭＶＡ適用Ｗ換算目標額到達有無（同水準）円高０９</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaariumsameyenkijyun09 zrnmvaariumsameyenkijyun09}</td><td>（連携用）ＭＶＡ適用Ｗ換算目標額到達有無（同水準）中央値０９</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaariumsameyenyasu09 zrnmvaariumsameyenyasu09}</td><td>（連携用）ＭＶＡ適用Ｗ換算目標額到達有無（同水準）円安０９</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaariwtuktypedown09 zrnmvaariwtuktypedown09}</td><td>（連携用）ＭＶＡ適用Ｗ通貨タイプ（低下）０９</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaaritmttknkykkjmdown09 zrnmvaaritmttknkykkjmdown09}</td><td>（連携用）ＭＶＡ適用積立金（解約控除前）（低下）０９</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaariwdown09 zrnmvaariwdown09}</td><td>（連携用）ＭＶＡ適用Ｗ（低下）０９</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaariwyentuktypedown09 zrnmvaariwyentuktypedown09}</td><td>（連携用）ＭＶＡ適用Ｗ換算通貨タイプ（低下）０９</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaariwdownyendaka09 zrnmvaariwdownyendaka09}</td><td>（連携用）ＭＶＡ適用Ｗ換算（低下）円高０９</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaariwdownyenkijyun09 zrnmvaariwdownyenkijyun09}</td><td>（連携用）ＭＶＡ適用Ｗ換算（低下）中央値０９</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaariwdownyenyasu09 zrnmvaariwdownyenyasu09}</td><td>（連携用）ＭＶＡ適用Ｗ換算（低下）円安０９</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaariumdownyendaka09 zrnmvaariumdownyendaka09}</td><td>（連携用）ＭＶＡ適用Ｗ換算目標額到達有無（低下）円高０９</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaariumdownyenkijyun09 zrnmvaariumdownyenkijyun09}</td><td>（連携用）ＭＶＡ適用Ｗ換算目標額到達有無（低下）中央値０９</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaariumdownyenyasu09 zrnmvaariumdownyenyasu09}</td><td>（連携用）ＭＶＡ適用Ｗ換算目標額到達有無（低下）円安０９</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaarivtuktype09 zrnmvaarivtuktype09}</td><td>（連携用）ＭＶＡ適用保険料積立金額通貨タイプ０９</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaariv09 zrnmvaariv09}</td><td>（連携用）ＭＶＡ適用保険料積立金額０９</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnptmttkngkutiwake109 zrnptmttkngkutiwake109}</td><td>（連携用）保険料積立金額内訳（１）０９</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnptmttkngkutiwake209 zrnptmttkngkutiwake209}</td><td>（連携用）保険料積立金額内訳（２）０９</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaarinenoutouym10 zrnmvaarinenoutouym10}</td><td>（連携用）ＭＶＡ適用年単位応当年月１０</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaarisisuuupritu10 zrnmvaarisisuuupritu10}</td><td>（連携用）ＭＶＡ適用指数上昇率１０</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaaritmttknzkritu10 zrnmvaaritmttknzkritu10}</td><td>（連携用）ＭＶＡ適用積立金増加率１０</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaariwtuktypeup10 zrnmvaariwtuktypeup10}</td><td>（連携用）ＭＶＡ適用Ｗ通貨タイプ（上昇）１０</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaaritmttknkykkjmup10 zrnmvaaritmttknkykkjmup10}</td><td>（連携用）ＭＶＡ適用積立金（解約控除前）（上昇）１０</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaariwup10 zrnmvaariwup10}</td><td>（連携用）ＭＶＡ適用Ｗ（上昇）１０</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaariwyentuktypeup10 zrnmvaariwyentuktypeup10}</td><td>（連携用）ＭＶＡ適用Ｗ換算通貨タイプ（上昇）１０</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaariwupyendaka10 zrnmvaariwupyendaka10}</td><td>（連携用）ＭＶＡ適用Ｗ換算（上昇）円高１０</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaariwupyenkijyun10 zrnmvaariwupyenkijyun10}</td><td>（連携用）ＭＶＡ適用Ｗ換算（上昇）中央値１０</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaariwupyenyasu10 zrnmvaariwupyenyasu10}</td><td>（連携用）ＭＶＡ適用Ｗ換算（上昇）円安１０</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaariwumupyendaka10 zrnmvaariwumupyendaka10}</td><td>（連携用）ＭＶＡ適用Ｗ換算目標額到達有無（上昇）円高１０</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaariumupyenkijyun10 zrnmvaariumupyenkijyun10}</td><td>（連携用）ＭＶＡ適用Ｗ換算目標額到達有無（上昇）中央値１０</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaariumupyenyasu10 zrnmvaariumupyenyasu10}</td><td>（連携用）ＭＶＡ適用Ｗ換算目標額到達有無（上昇）円安１０</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaariwtuktypesame10 zrnmvaariwtuktypesame10}</td><td>（連携用）ＭＶＡ適用Ｗ通貨タイプ（同水準）１０</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaaritmttknkykkjmsame10 zrnmvaaritmttknkykkjmsame10}</td><td>（連携用）ＭＶＡ適用積立金（解約控除前）（同水準）１０</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaariwsame10 zrnmvaariwsame10}</td><td>（連携用）ＭＶＡ適用Ｗ（同水準）１０</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaariwyentuktypesame10 zrnmvaariwyentuktypesame10}</td><td>（連携用）ＭＶＡ適用Ｗ換算通貨タイプ（同水準）１０</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaariwsameyendaka10 zrnmvaariwsameyendaka10}</td><td>（連携用）ＭＶＡ適用Ｗ換算（同水準）円高１０</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaariwsameyenkijyun10 zrnmvaariwsameyenkijyun10}</td><td>（連携用）ＭＶＡ適用Ｗ換算（同水準）中央値１０</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaariwsameyenyasu10 zrnmvaariwsameyenyasu10}</td><td>（連携用）ＭＶＡ適用Ｗ換算（同水準）円安１０</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaariumsameyendaka10 zrnmvaariumsameyendaka10}</td><td>（連携用）ＭＶＡ適用Ｗ換算目標額到達有無（同水準）円高１０</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaariumsameyenkijyun10 zrnmvaariumsameyenkijyun10}</td><td>（連携用）ＭＶＡ適用Ｗ換算目標額到達有無（同水準）中央値１０</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaariumsameyenyasu10 zrnmvaariumsameyenyasu10}</td><td>（連携用）ＭＶＡ適用Ｗ換算目標額到達有無（同水準）円安１０</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaariwtuktypedown10 zrnmvaariwtuktypedown10}</td><td>（連携用）ＭＶＡ適用Ｗ通貨タイプ（低下）１０</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaaritmttknkykkjmdown10 zrnmvaaritmttknkykkjmdown10}</td><td>（連携用）ＭＶＡ適用積立金（解約控除前）（低下）１０</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaariwdown10 zrnmvaariwdown10}</td><td>（連携用）ＭＶＡ適用Ｗ（低下）１０</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaariwyentuktypedown10 zrnmvaariwyentuktypedown10}</td><td>（連携用）ＭＶＡ適用Ｗ換算通貨タイプ（低下）１０</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaariwdownyendaka10 zrnmvaariwdownyendaka10}</td><td>（連携用）ＭＶＡ適用Ｗ換算（低下）円高１０</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaariwdownyenkijyun10 zrnmvaariwdownyenkijyun10}</td><td>（連携用）ＭＶＡ適用Ｗ換算（低下）中央値１０</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaariwdownyenyasu10 zrnmvaariwdownyenyasu10}</td><td>（連携用）ＭＶＡ適用Ｗ換算（低下）円安１０</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaariumdownyendaka10 zrnmvaariumdownyendaka10}</td><td>（連携用）ＭＶＡ適用Ｗ換算目標額到達有無（低下）円高１０</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaariumdownyenkijyun10 zrnmvaariumdownyenkijyun10}</td><td>（連携用）ＭＶＡ適用Ｗ換算目標額到達有無（低下）中央値１０</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaariumdownyenyasu10 zrnmvaariumdownyenyasu10}</td><td>（連携用）ＭＶＡ適用Ｗ換算目標額到達有無（低下）円安１０</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaarivtuktype10 zrnmvaarivtuktype10}</td><td>（連携用）ＭＶＡ適用保険料積立金額通貨タイプ１０</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaariv10 zrnmvaariv10}</td><td>（連携用）ＭＶＡ適用保険料積立金額１０</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnptmttkngkutiwake110 zrnptmttkngkutiwake110}</td><td>（連携用）保険料積立金額内訳（１）１０</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnptmttkngkutiwake210 zrnptmttkngkutiwake210}</td><td>（連携用）保険料積立金額内訳（２）１０</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaarinenoutouym11 zrnmvaarinenoutouym11}</td><td>（連携用）ＭＶＡ適用年単位応当年月１１</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaariwtuktypeup11 zrnmvaariwtuktypeup11}</td><td>（連携用）ＭＶＡ適用Ｗ通貨タイプ（上昇）１１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaariwup11 zrnmvaariwup11}</td><td>（連携用）ＭＶＡ適用Ｗ（上昇）１１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaariwyentuktypeup11 zrnmvaariwyentuktypeup11}</td><td>（連携用）ＭＶＡ適用Ｗ換算通貨タイプ（上昇）１１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaariwupyendaka11 zrnmvaariwupyendaka11}</td><td>（連携用）ＭＶＡ適用Ｗ換算（上昇）円高１１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaariwupyenkijyun11 zrnmvaariwupyenkijyun11}</td><td>（連携用）ＭＶＡ適用Ｗ換算（上昇）中央値１１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaariwupyenyasu11 zrnmvaariwupyenyasu11}</td><td>（連携用）ＭＶＡ適用Ｗ換算（上昇）円安１１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaariwumupyendaka11 zrnmvaariwumupyendaka11}</td><td>（連携用）ＭＶＡ適用Ｗ換算目標額到達有無（上昇）円高１１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaariumupyenkijyun11 zrnmvaariumupyenkijyun11}</td><td>（連携用）ＭＶＡ適用Ｗ換算目標額到達有無（上昇）中央値１１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaariumupyenyasu11 zrnmvaariumupyenyasu11}</td><td>（連携用）ＭＶＡ適用Ｗ換算目標額到達有無（上昇）円安１１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaariwtuktypesame11 zrnmvaariwtuktypesame11}</td><td>（連携用）ＭＶＡ適用Ｗ通貨タイプ（同水準）１１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaariwsame11 zrnmvaariwsame11}</td><td>（連携用）ＭＶＡ適用Ｗ（同水準）１１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaariwyentuktypesame11 zrnmvaariwyentuktypesame11}</td><td>（連携用）ＭＶＡ適用Ｗ換算通貨タイプ（同水準）１１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaariwsameyendaka11 zrnmvaariwsameyendaka11}</td><td>（連携用）ＭＶＡ適用Ｗ換算（同水準）円高１１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaariwsameyenkijyun11 zrnmvaariwsameyenkijyun11}</td><td>（連携用）ＭＶＡ適用Ｗ換算（同水準）中央値１１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaariwsameyenyasu11 zrnmvaariwsameyenyasu11}</td><td>（連携用）ＭＶＡ適用Ｗ換算（同水準）円安１１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaariumsameyendaka11 zrnmvaariumsameyendaka11}</td><td>（連携用）ＭＶＡ適用Ｗ換算目標額到達有無（同水準）円高１１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaariumsameyenkijyun11 zrnmvaariumsameyenkijyun11}</td><td>（連携用）ＭＶＡ適用Ｗ換算目標額到達有無（同水準）中央値１１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaariumsameyenyasu11 zrnmvaariumsameyenyasu11}</td><td>（連携用）ＭＶＡ適用Ｗ換算目標額到達有無（同水準）円安１１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaariwtuktypedown11 zrnmvaariwtuktypedown11}</td><td>（連携用）ＭＶＡ適用Ｗ通貨タイプ（低下）１１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaariwdown11 zrnmvaariwdown11}</td><td>（連携用）ＭＶＡ適用Ｗ（低下）１１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaariwyentuktypedown11 zrnmvaariwyentuktypedown11}</td><td>（連携用）ＭＶＡ適用Ｗ換算通貨タイプ（低下）１１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaariwdownyendaka11 zrnmvaariwdownyendaka11}</td><td>（連携用）ＭＶＡ適用Ｗ換算（低下）円高１１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaariwdownyenkijyun11 zrnmvaariwdownyenkijyun11}</td><td>（連携用）ＭＶＡ適用Ｗ換算（低下）中央値１１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaariwdownyenyasu11 zrnmvaariwdownyenyasu11}</td><td>（連携用）ＭＶＡ適用Ｗ換算（低下）円安１１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaariumdownyendaka11 zrnmvaariumdownyendaka11}</td><td>（連携用）ＭＶＡ適用Ｗ換算目標額到達有無（低下）円高１１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaariumdownyenkijyun11 zrnmvaariumdownyenkijyun11}</td><td>（連携用）ＭＶＡ適用Ｗ換算目標額到達有無（低下）中央値１１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaariumdownyenyasu11 zrnmvaariumdownyenyasu11}</td><td>（連携用）ＭＶＡ適用Ｗ換算目標額到達有無（低下）円安１１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaarivtuktype11 zrnmvaarivtuktype11}</td><td>（連携用）ＭＶＡ適用保険料積立金額通貨タイプ１１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaariv11 zrnmvaariv11}</td><td>（連携用）ＭＶＡ適用保険料積立金額１１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaarinenoutouym12 zrnmvaarinenoutouym12}</td><td>（連携用）ＭＶＡ適用年単位応当年月１２</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaariwtuktypeup12 zrnmvaariwtuktypeup12}</td><td>（連携用）ＭＶＡ適用Ｗ通貨タイプ（上昇）１２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaariwup12 zrnmvaariwup12}</td><td>（連携用）ＭＶＡ適用Ｗ（上昇）１２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaariwyentuktypeup12 zrnmvaariwyentuktypeup12}</td><td>（連携用）ＭＶＡ適用Ｗ換算通貨タイプ（上昇）１２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaariwupyendaka12 zrnmvaariwupyendaka12}</td><td>（連携用）ＭＶＡ適用Ｗ換算（上昇）円高１２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaariwupyenkijyun12 zrnmvaariwupyenkijyun12}</td><td>（連携用）ＭＶＡ適用Ｗ換算（上昇）中央値１２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaariwupyenyasu12 zrnmvaariwupyenyasu12}</td><td>（連携用）ＭＶＡ適用Ｗ換算（上昇）円安１２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaariwumupyendaka12 zrnmvaariwumupyendaka12}</td><td>（連携用）ＭＶＡ適用Ｗ換算目標額到達有無（上昇）円高１２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaariumupyenkijyun12 zrnmvaariumupyenkijyun12}</td><td>（連携用）ＭＶＡ適用Ｗ換算目標額到達有無（上昇）中央値１２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaariumupyenyasu12 zrnmvaariumupyenyasu12}</td><td>（連携用）ＭＶＡ適用Ｗ換算目標額到達有無（上昇）円安１２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaariwtuktypesame12 zrnmvaariwtuktypesame12}</td><td>（連携用）ＭＶＡ適用Ｗ通貨タイプ（同水準）１２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaariwsame12 zrnmvaariwsame12}</td><td>（連携用）ＭＶＡ適用Ｗ（同水準）１２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaariwyentuktypesame12 zrnmvaariwyentuktypesame12}</td><td>（連携用）ＭＶＡ適用Ｗ換算通貨タイプ（同水準）１２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaariwsameyendaka12 zrnmvaariwsameyendaka12}</td><td>（連携用）ＭＶＡ適用Ｗ換算（同水準）円高１２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaariwsameyenkijyun12 zrnmvaariwsameyenkijyun12}</td><td>（連携用）ＭＶＡ適用Ｗ換算（同水準）中央値１２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaariwsameyenyasu12 zrnmvaariwsameyenyasu12}</td><td>（連携用）ＭＶＡ適用Ｗ換算（同水準）円安１２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaariumsameyendaka12 zrnmvaariumsameyendaka12}</td><td>（連携用）ＭＶＡ適用Ｗ換算目標額到達有無（同水準）円高１２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaariumsameyenkijyun12 zrnmvaariumsameyenkijyun12}</td><td>（連携用）ＭＶＡ適用Ｗ換算目標額到達有無（同水準）中央値１２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaariumsameyenyasu12 zrnmvaariumsameyenyasu12}</td><td>（連携用）ＭＶＡ適用Ｗ換算目標額到達有無（同水準）円安１２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaariwtuktypedown12 zrnmvaariwtuktypedown12}</td><td>（連携用）ＭＶＡ適用Ｗ通貨タイプ（低下）１２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaariwdown12 zrnmvaariwdown12}</td><td>（連携用）ＭＶＡ適用Ｗ（低下）１２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaariwyentuktypedown12 zrnmvaariwyentuktypedown12}</td><td>（連携用）ＭＶＡ適用Ｗ換算通貨タイプ（低下）１２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaariwdownyendaka12 zrnmvaariwdownyendaka12}</td><td>（連携用）ＭＶＡ適用Ｗ換算（低下）円高１２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaariwdownyenkijyun12 zrnmvaariwdownyenkijyun12}</td><td>（連携用）ＭＶＡ適用Ｗ換算（低下）中央値１２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaariwdownyenyasu12 zrnmvaariwdownyenyasu12}</td><td>（連携用）ＭＶＡ適用Ｗ換算（低下）円安１２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaariumdownyendaka12 zrnmvaariumdownyendaka12}</td><td>（連携用）ＭＶＡ適用Ｗ換算目標額到達有無（低下）円高１２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaariumdownyenkijyun12 zrnmvaariumdownyenkijyun12}</td><td>（連携用）ＭＶＡ適用Ｗ換算目標額到達有無（低下）中央値１２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaariumdownyenyasu12 zrnmvaariumdownyenyasu12}</td><td>（連携用）ＭＶＡ適用Ｗ換算目標額到達有無（低下）円安１２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaarivtuktype12 zrnmvaarivtuktype12}</td><td>（連携用）ＭＶＡ適用保険料積立金額通貨タイプ１２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaariv12 zrnmvaariv12}</td><td>（連携用）ＭＶＡ適用保険料積立金額１２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaarinenoutouym13 zrnmvaarinenoutouym13}</td><td>（連携用）ＭＶＡ適用年単位応当年月１３</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaariwtuktypeup13 zrnmvaariwtuktypeup13}</td><td>（連携用）ＭＶＡ適用Ｗ通貨タイプ（上昇）１３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaariwup13 zrnmvaariwup13}</td><td>（連携用）ＭＶＡ適用Ｗ（上昇）１３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaariwyentuktypeup13 zrnmvaariwyentuktypeup13}</td><td>（連携用）ＭＶＡ適用Ｗ換算通貨タイプ（上昇）１３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaariwupyendaka13 zrnmvaariwupyendaka13}</td><td>（連携用）ＭＶＡ適用Ｗ換算（上昇）円高１３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaariwupyenkijyun13 zrnmvaariwupyenkijyun13}</td><td>（連携用）ＭＶＡ適用Ｗ換算（上昇）中央値１３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaariwupyenyasu13 zrnmvaariwupyenyasu13}</td><td>（連携用）ＭＶＡ適用Ｗ換算（上昇）円安１３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaariwumupyendaka13 zrnmvaariwumupyendaka13}</td><td>（連携用）ＭＶＡ適用Ｗ換算目標額到達有無（上昇）円高１３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaariumupyenkijyun13 zrnmvaariumupyenkijyun13}</td><td>（連携用）ＭＶＡ適用Ｗ換算目標額到達有無（上昇）中央値１３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaariumupyenyasu13 zrnmvaariumupyenyasu13}</td><td>（連携用）ＭＶＡ適用Ｗ換算目標額到達有無（上昇）円安１３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaariwtuktypesame13 zrnmvaariwtuktypesame13}</td><td>（連携用）ＭＶＡ適用Ｗ通貨タイプ（同水準）１３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaariwsame13 zrnmvaariwsame13}</td><td>（連携用）ＭＶＡ適用Ｗ（同水準）１３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaariwyentuktypesame13 zrnmvaariwyentuktypesame13}</td><td>（連携用）ＭＶＡ適用Ｗ換算通貨タイプ（同水準）１３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaariwsameyendaka13 zrnmvaariwsameyendaka13}</td><td>（連携用）ＭＶＡ適用Ｗ換算（同水準）円高１３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaariwsameyenkijyun13 zrnmvaariwsameyenkijyun13}</td><td>（連携用）ＭＶＡ適用Ｗ換算（同水準）中央値１３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaariwsameyenyasu13 zrnmvaariwsameyenyasu13}</td><td>（連携用）ＭＶＡ適用Ｗ換算（同水準）円安１３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaariumsameyendaka13 zrnmvaariumsameyendaka13}</td><td>（連携用）ＭＶＡ適用Ｗ換算目標額到達有無（同水準）円高１３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaariumsameyenkijyun13 zrnmvaariumsameyenkijyun13}</td><td>（連携用）ＭＶＡ適用Ｗ換算目標額到達有無（同水準）中央値１３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaariumsameyenyasu13 zrnmvaariumsameyenyasu13}</td><td>（連携用）ＭＶＡ適用Ｗ換算目標額到達有無（同水準）円安１３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaariwtuktypedown13 zrnmvaariwtuktypedown13}</td><td>（連携用）ＭＶＡ適用Ｗ通貨タイプ（低下）１３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaariwdown13 zrnmvaariwdown13}</td><td>（連携用）ＭＶＡ適用Ｗ（低下）１３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaariwyentuktypedown13 zrnmvaariwyentuktypedown13}</td><td>（連携用）ＭＶＡ適用Ｗ換算通貨タイプ（低下）１３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaariwdownyendaka13 zrnmvaariwdownyendaka13}</td><td>（連携用）ＭＶＡ適用Ｗ換算（低下）円高１３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaariwdownyenkijyun13 zrnmvaariwdownyenkijyun13}</td><td>（連携用）ＭＶＡ適用Ｗ換算（低下）中央値１３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaariwdownyenyasu13 zrnmvaariwdownyenyasu13}</td><td>（連携用）ＭＶＡ適用Ｗ換算（低下）円安１３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaariumdownyendaka13 zrnmvaariumdownyendaka13}</td><td>（連携用）ＭＶＡ適用Ｗ換算目標額到達有無（低下）円高１３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaariumdownyenkijyun13 zrnmvaariumdownyenkijyun13}</td><td>（連携用）ＭＶＡ適用Ｗ換算目標額到達有無（低下）中央値１３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaariumdownyenyasu13 zrnmvaariumdownyenyasu13}</td><td>（連携用）ＭＶＡ適用Ｗ換算目標額到達有無（低下）円安１３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaarivtuktype13 zrnmvaarivtuktype13}</td><td>（連携用）ＭＶＡ適用保険料積立金額通貨タイプ１３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaariv13 zrnmvaariv13}</td><td>（連携用）ＭＶＡ適用保険料積立金額１３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaarinenoutouym14 zrnmvaarinenoutouym14}</td><td>（連携用）ＭＶＡ適用年単位応当年月１４</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaariwtuktypeup14 zrnmvaariwtuktypeup14}</td><td>（連携用）ＭＶＡ適用Ｗ通貨タイプ（上昇）１４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaariwup14 zrnmvaariwup14}</td><td>（連携用）ＭＶＡ適用Ｗ（上昇）１４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaariwyentuktypeup14 zrnmvaariwyentuktypeup14}</td><td>（連携用）ＭＶＡ適用Ｗ換算通貨タイプ（上昇）１４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaariwupyendaka14 zrnmvaariwupyendaka14}</td><td>（連携用）ＭＶＡ適用Ｗ換算（上昇）円高１４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaariwupyenkijyun14 zrnmvaariwupyenkijyun14}</td><td>（連携用）ＭＶＡ適用Ｗ換算（上昇）中央値１４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaariwupyenyasu14 zrnmvaariwupyenyasu14}</td><td>（連携用）ＭＶＡ適用Ｗ換算（上昇）円安１４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaariwumupyendaka14 zrnmvaariwumupyendaka14}</td><td>（連携用）ＭＶＡ適用Ｗ換算目標額到達有無（上昇）円高１４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaariumupyenkijyun14 zrnmvaariumupyenkijyun14}</td><td>（連携用）ＭＶＡ適用Ｗ換算目標額到達有無（上昇）中央値１４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaariumupyenyasu14 zrnmvaariumupyenyasu14}</td><td>（連携用）ＭＶＡ適用Ｗ換算目標額到達有無（上昇）円安１４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaariwtuktypesame14 zrnmvaariwtuktypesame14}</td><td>（連携用）ＭＶＡ適用Ｗ通貨タイプ（同水準）１４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaariwsame14 zrnmvaariwsame14}</td><td>（連携用）ＭＶＡ適用Ｗ（同水準）１４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaariwyentuktypesame14 zrnmvaariwyentuktypesame14}</td><td>（連携用）ＭＶＡ適用Ｗ換算通貨タイプ（同水準）１４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaariwsameyendaka14 zrnmvaariwsameyendaka14}</td><td>（連携用）ＭＶＡ適用Ｗ換算（同水準）円高１４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaariwsameyenkijyun14 zrnmvaariwsameyenkijyun14}</td><td>（連携用）ＭＶＡ適用Ｗ換算（同水準）中央値１４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaariwsameyenyasu14 zrnmvaariwsameyenyasu14}</td><td>（連携用）ＭＶＡ適用Ｗ換算（同水準）円安１４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaariumsameyendaka14 zrnmvaariumsameyendaka14}</td><td>（連携用）ＭＶＡ適用Ｗ換算目標額到達有無（同水準）円高１４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaariumsameyenkijyun14 zrnmvaariumsameyenkijyun14}</td><td>（連携用）ＭＶＡ適用Ｗ換算目標額到達有無（同水準）中央値１４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaariumsameyenyasu14 zrnmvaariumsameyenyasu14}</td><td>（連携用）ＭＶＡ適用Ｗ換算目標額到達有無（同水準）円安１４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaariwtuktypedown14 zrnmvaariwtuktypedown14}</td><td>（連携用）ＭＶＡ適用Ｗ通貨タイプ（低下）１４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaariwdown14 zrnmvaariwdown14}</td><td>（連携用）ＭＶＡ適用Ｗ（低下）１４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaariwyentuktypedown14 zrnmvaariwyentuktypedown14}</td><td>（連携用）ＭＶＡ適用Ｗ換算通貨タイプ（低下）１４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaariwdownyendaka14 zrnmvaariwdownyendaka14}</td><td>（連携用）ＭＶＡ適用Ｗ換算（低下）円高１４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaariwdownyenkijyun14 zrnmvaariwdownyenkijyun14}</td><td>（連携用）ＭＶＡ適用Ｗ換算（低下）中央値１４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaariwdownyenyasu14 zrnmvaariwdownyenyasu14}</td><td>（連携用）ＭＶＡ適用Ｗ換算（低下）円安１４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaariumdownyendaka14 zrnmvaariumdownyendaka14}</td><td>（連携用）ＭＶＡ適用Ｗ換算目標額到達有無（低下）円高１４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaariumdownyenkijyun14 zrnmvaariumdownyenkijyun14}</td><td>（連携用）ＭＶＡ適用Ｗ換算目標額到達有無（低下）中央値１４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaariumdownyenyasu14 zrnmvaariumdownyenyasu14}</td><td>（連携用）ＭＶＡ適用Ｗ換算目標額到達有無（低下）円安１４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaarivtuktype14 zrnmvaarivtuktype14}</td><td>（連携用）ＭＶＡ適用保険料積立金額通貨タイプ１４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaariv14 zrnmvaariv14}</td><td>（連携用）ＭＶＡ適用保険料積立金額１４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaarinenoutouym15 zrnmvaarinenoutouym15}</td><td>（連携用）ＭＶＡ適用年単位応当年月１５</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaariwtuktypeup15 zrnmvaariwtuktypeup15}</td><td>（連携用）ＭＶＡ適用Ｗ通貨タイプ（上昇）１５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaariwup15 zrnmvaariwup15}</td><td>（連携用）ＭＶＡ適用Ｗ（上昇）１５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaariwyentuktypeup15 zrnmvaariwyentuktypeup15}</td><td>（連携用）ＭＶＡ適用Ｗ換算通貨タイプ（上昇）１５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaariwupyendaka15 zrnmvaariwupyendaka15}</td><td>（連携用）ＭＶＡ適用Ｗ換算（上昇）円高１５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaariwupyenkijyun15 zrnmvaariwupyenkijyun15}</td><td>（連携用）ＭＶＡ適用Ｗ換算（上昇）中央値１５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaariwupyenyasu15 zrnmvaariwupyenyasu15}</td><td>（連携用）ＭＶＡ適用Ｗ換算（上昇）円安１５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaariwumupyendaka15 zrnmvaariwumupyendaka15}</td><td>（連携用）ＭＶＡ適用Ｗ換算目標額到達有無（上昇）円高１５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaariumupyenkijyun15 zrnmvaariumupyenkijyun15}</td><td>（連携用）ＭＶＡ適用Ｗ換算目標額到達有無（上昇）中央値１５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaariumupyenyasu15 zrnmvaariumupyenyasu15}</td><td>（連携用）ＭＶＡ適用Ｗ換算目標額到達有無（上昇）円安１５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaariwtuktypesame15 zrnmvaariwtuktypesame15}</td><td>（連携用）ＭＶＡ適用Ｗ通貨タイプ（同水準）１５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaariwsame15 zrnmvaariwsame15}</td><td>（連携用）ＭＶＡ適用Ｗ（同水準）１５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaariwyentuktypesame15 zrnmvaariwyentuktypesame15}</td><td>（連携用）ＭＶＡ適用Ｗ換算通貨タイプ（同水準）１５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaariwsameyendaka15 zrnmvaariwsameyendaka15}</td><td>（連携用）ＭＶＡ適用Ｗ換算（同水準）円高１５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaariwsameyenkijyun15 zrnmvaariwsameyenkijyun15}</td><td>（連携用）ＭＶＡ適用Ｗ換算（同水準）中央値１５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaariwsameyenyasu15 zrnmvaariwsameyenyasu15}</td><td>（連携用）ＭＶＡ適用Ｗ換算（同水準）円安１５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaariumsameyendaka15 zrnmvaariumsameyendaka15}</td><td>（連携用）ＭＶＡ適用Ｗ換算目標額到達有無（同水準）円高１５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaariumsameyenkijyun15 zrnmvaariumsameyenkijyun15}</td><td>（連携用）ＭＶＡ適用Ｗ換算目標額到達有無（同水準）中央値１５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaariumsameyenyasu15 zrnmvaariumsameyenyasu15}</td><td>（連携用）ＭＶＡ適用Ｗ換算目標額到達有無（同水準）円安１５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaariwtuktypedown15 zrnmvaariwtuktypedown15}</td><td>（連携用）ＭＶＡ適用Ｗ通貨タイプ（低下）１５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaariwdown15 zrnmvaariwdown15}</td><td>（連携用）ＭＶＡ適用Ｗ（低下）１５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaariwyentuktypedown15 zrnmvaariwyentuktypedown15}</td><td>（連携用）ＭＶＡ適用Ｗ換算通貨タイプ（低下）１５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaariwdownyendaka15 zrnmvaariwdownyendaka15}</td><td>（連携用）ＭＶＡ適用Ｗ換算（低下）円高１５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaariwdownyenkijyun15 zrnmvaariwdownyenkijyun15}</td><td>（連携用）ＭＶＡ適用Ｗ換算（低下）中央値１５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaariwdownyenyasu15 zrnmvaariwdownyenyasu15}</td><td>（連携用）ＭＶＡ適用Ｗ換算（低下）円安１５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaariumdownyendaka15 zrnmvaariumdownyendaka15}</td><td>（連携用）ＭＶＡ適用Ｗ換算目標額到達有無（低下）円高１５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaariumdownyenkijyun15 zrnmvaariumdownyenkijyun15}</td><td>（連携用）ＭＶＡ適用Ｗ換算目標額到達有無（低下）中央値１５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaariumdownyenyasu15 zrnmvaariumdownyenyasu15}</td><td>（連携用）ＭＶＡ適用Ｗ換算目標額到達有無（低下）円安１５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaarivtuktype15 zrnmvaarivtuktype15}</td><td>（連携用）ＭＶＡ適用保険料積立金額通貨タイプ１５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvaariv15 zrnmvaariv15}</td><td>（連携用）ＭＶＡ適用保険料積立金額１５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvanonekaisiinnumukbn01 zrnmvanonekaisiinnumukbn01}</td><td>（連携用）ＭＶＡ適用外開始印有無区分０１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvanonenenoutouym01 zrnmvanonenenoutouym01}</td><td>（連携用）ＭＶＡ適用外年単位応当年月０１</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvanonewtuktype01 zrnmvanonewtuktype01}</td><td>（連携用）ＭＶＡ適用外Ｗ通貨タイプ０１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvanonew01 zrnmvanonew01}</td><td>（連携用）ＭＶＡ適用外Ｗ０１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvanonewyentuktype01 zrnmvanonewyentuktype01}</td><td>（連携用）ＭＶＡ適用外Ｗ換算通貨タイプ０１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvanonewyendaka01 zrnmvanonewyendaka01}</td><td>（連携用）ＭＶＡ適用外Ｗ換算０１円高</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvanonewyenkijyun01 zrnmvanonewyenkijyun01}</td><td>（連携用）ＭＶＡ適用外Ｗ換算０１中央値</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvanonewyenyasu01 zrnmvanonewyenyasu01}</td><td>（連携用）ＭＶＡ適用外Ｗ換算０１円安</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvanoneumyendaka01 zrnmvanoneumyendaka01}</td><td>（連携用）ＭＶＡ適用外Ｗ換算目標額到達有無円高０１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvanoneumyenkijyun01 zrnmvanoneumyenkijyun01}</td><td>（連携用）ＭＶＡ適用外Ｗ換算目標額到達有無中央値０１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvanoneumyenyasu01 zrnmvanoneumyenyasu01}</td><td>（連携用）ＭＶＡ適用外Ｗ換算目標額到達有無円安０１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvanonevtuktype01 zrnmvanonevtuktype01}</td><td>（連携用）ＭＶＡ適用外保険料積立金額通貨タイプ０１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvanonev01 zrnmvanonev01}</td><td>（連携用）ＭＶＡ適用外保険料積立金額０１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvanonekaisiinnumukbn02 zrnmvanonekaisiinnumukbn02}</td><td>（連携用）ＭＶＡ適用外開始印有無区分０２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvanonenenoutouym02 zrnmvanonenenoutouym02}</td><td>（連携用）ＭＶＡ適用外年単位応当年月０２</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvanonewtuktype02 zrnmvanonewtuktype02}</td><td>（連携用）ＭＶＡ適用外Ｗ通貨タイプ０２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvanonew02 zrnmvanonew02}</td><td>（連携用）ＭＶＡ適用外Ｗ０２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvanonewyentuktype02 zrnmvanonewyentuktype02}</td><td>（連携用）ＭＶＡ適用外Ｗ換算通貨タイプ０２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvanonewyendaka02 zrnmvanonewyendaka02}</td><td>（連携用）ＭＶＡ適用外Ｗ換算０２円高</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvanonewyenkijyun02 zrnmvanonewyenkijyun02}</td><td>（連携用）ＭＶＡ適用外Ｗ換算０２中央値</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvanonewyenyasu02 zrnmvanonewyenyasu02}</td><td>（連携用）ＭＶＡ適用外Ｗ換算０２円安</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvanoneumyendaka02 zrnmvanoneumyendaka02}</td><td>（連携用）ＭＶＡ適用外Ｗ換算目標額到達有無円高０２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvanoneumyenkijyun02 zrnmvanoneumyenkijyun02}</td><td>（連携用）ＭＶＡ適用外Ｗ換算目標額到達有無中央値０２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvanoneumyenyasu02 zrnmvanoneumyenyasu02}</td><td>（連携用）ＭＶＡ適用外Ｗ換算目標額到達有無円安０２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvanonevtuktype02 zrnmvanonevtuktype02}</td><td>（連携用）ＭＶＡ適用外保険料積立金額通貨タイプ０２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvanonev02 zrnmvanonev02}</td><td>（連携用）ＭＶＡ適用外保険料積立金額０２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvanonekaisiinnumukbn03 zrnmvanonekaisiinnumukbn03}</td><td>（連携用）ＭＶＡ適用外開始印有無区分０３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvanonenenoutouym03 zrnmvanonenenoutouym03}</td><td>（連携用）ＭＶＡ適用外年単位応当年月０３</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvanonewtuktype03 zrnmvanonewtuktype03}</td><td>（連携用）ＭＶＡ適用外Ｗ通貨タイプ０３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvanonew03 zrnmvanonew03}</td><td>（連携用）ＭＶＡ適用外Ｗ０３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvanonewyentuktype03 zrnmvanonewyentuktype03}</td><td>（連携用）ＭＶＡ適用外Ｗ換算通貨タイプ０３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvanonewyendaka03 zrnmvanonewyendaka03}</td><td>（連携用）ＭＶＡ適用外Ｗ換算０３円高</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvanonewyenkijyun03 zrnmvanonewyenkijyun03}</td><td>（連携用）ＭＶＡ適用外Ｗ換算０３中央値</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvanonewyenyasu03 zrnmvanonewyenyasu03}</td><td>（連携用）ＭＶＡ適用外Ｗ換算０３円安</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvanoneumyendaka03 zrnmvanoneumyendaka03}</td><td>（連携用）ＭＶＡ適用外Ｗ換算目標額到達有無円高０３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvanoneumyenkijyun03 zrnmvanoneumyenkijyun03}</td><td>（連携用）ＭＶＡ適用外Ｗ換算目標額到達有無中央値０３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvanoneumyenyasu03 zrnmvanoneumyenyasu03}</td><td>（連携用）ＭＶＡ適用外Ｗ換算目標額到達有無円安０３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvanonevtuktype03 zrnmvanonevtuktype03}</td><td>（連携用）ＭＶＡ適用外保険料積立金額通貨タイプ０３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvanonev03 zrnmvanonev03}</td><td>（連携用）ＭＶＡ適用外保険料積立金額０３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvanonekaisiinnumukbn04 zrnmvanonekaisiinnumukbn04}</td><td>（連携用）ＭＶＡ適用外開始印有無区分０４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvanonenenoutouym04 zrnmvanonenenoutouym04}</td><td>（連携用）ＭＶＡ適用外年単位応当年月０４</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvanonewtuktype04 zrnmvanonewtuktype04}</td><td>（連携用）ＭＶＡ適用外Ｗ通貨タイプ０４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvanonew04 zrnmvanonew04}</td><td>（連携用）ＭＶＡ適用外Ｗ０４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvanonewyentuktype04 zrnmvanonewyentuktype04}</td><td>（連携用）ＭＶＡ適用外Ｗ換算通貨タイプ０４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvanonewyendaka04 zrnmvanonewyendaka04}</td><td>（連携用）ＭＶＡ適用外Ｗ換算０４円高</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvanonewyenkijyun04 zrnmvanonewyenkijyun04}</td><td>（連携用）ＭＶＡ適用外Ｗ換算０４中央値</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvanonewyenyasu04 zrnmvanonewyenyasu04}</td><td>（連携用）ＭＶＡ適用外Ｗ換算０４円安</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvanoneumyendaka04 zrnmvanoneumyendaka04}</td><td>（連携用）ＭＶＡ適用外Ｗ換算目標額到達有無円高０４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvanoneumyenkijyun04 zrnmvanoneumyenkijyun04}</td><td>（連携用）ＭＶＡ適用外Ｗ換算目標額到達有無中央値０４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvanoneumyenyasu04 zrnmvanoneumyenyasu04}</td><td>（連携用）ＭＶＡ適用外Ｗ換算目標額到達有無円安０４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvanonevtuktype04 zrnmvanonevtuktype04}</td><td>（連携用）ＭＶＡ適用外保険料積立金額通貨タイプ０４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvanonev04 zrnmvanonev04}</td><td>（連携用）ＭＶＡ適用外保険料積立金額０４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvanonekaisiinnumukbn05 zrnmvanonekaisiinnumukbn05}</td><td>（連携用）ＭＶＡ適用外開始印有無区分０５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvanonenenoutouym05 zrnmvanonenenoutouym05}</td><td>（連携用）ＭＶＡ適用外年単位応当年月０５</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvanonewtuktype05 zrnmvanonewtuktype05}</td><td>（連携用）ＭＶＡ適用外Ｗ通貨タイプ０５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvanonew05 zrnmvanonew05}</td><td>（連携用）ＭＶＡ適用外Ｗ０５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvanonewyentuktype05 zrnmvanonewyentuktype05}</td><td>（連携用）ＭＶＡ適用外Ｗ換算通貨タイプ０５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvanonewyendaka05 zrnmvanonewyendaka05}</td><td>（連携用）ＭＶＡ適用外Ｗ換算０５円高</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvanonewyenkijyun05 zrnmvanonewyenkijyun05}</td><td>（連携用）ＭＶＡ適用外Ｗ換算０５中央値</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvanonewyenyasu05 zrnmvanonewyenyasu05}</td><td>（連携用）ＭＶＡ適用外Ｗ換算０５円安</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvanoneumyendaka05 zrnmvanoneumyendaka05}</td><td>（連携用）ＭＶＡ適用外Ｗ換算目標額到達有無円高０５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvanoneumyenkijyun05 zrnmvanoneumyenkijyun05}</td><td>（連携用）ＭＶＡ適用外Ｗ換算目標額到達有無中央値０５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvanoneumyenyasu05 zrnmvanoneumyenyasu05}</td><td>（連携用）ＭＶＡ適用外Ｗ換算目標額到達有無円安０５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvanonevtuktype05 zrnmvanonevtuktype05}</td><td>（連携用）ＭＶＡ適用外保険料積立金額通貨タイプ０５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvanonev05 zrnmvanonev05}</td><td>（連携用）ＭＶＡ適用外保険料積立金額０５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvanonekaisiinnumukbn06 zrnmvanonekaisiinnumukbn06}</td><td>（連携用）ＭＶＡ適用外開始印有無区分０６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvanonenenoutouym06 zrnmvanonenenoutouym06}</td><td>（連携用）ＭＶＡ適用外年単位応当年月０６</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvanonewtuktype06 zrnmvanonewtuktype06}</td><td>（連携用）ＭＶＡ適用外Ｗ通貨タイプ０６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvanonew06 zrnmvanonew06}</td><td>（連携用）ＭＶＡ適用外Ｗ０６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvanonewyentuktype06 zrnmvanonewyentuktype06}</td><td>（連携用）ＭＶＡ適用外Ｗ換算通貨タイプ０６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvanonewyendaka06 zrnmvanonewyendaka06}</td><td>（連携用）ＭＶＡ適用外Ｗ換算０６円高</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvanonewyenkijyun06 zrnmvanonewyenkijyun06}</td><td>（連携用）ＭＶＡ適用外Ｗ換算０６中央値</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvanonewyenyasu06 zrnmvanonewyenyasu06}</td><td>（連携用）ＭＶＡ適用外Ｗ換算０６円安</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvanoneumyendaka06 zrnmvanoneumyendaka06}</td><td>（連携用）ＭＶＡ適用外Ｗ換算目標額到達有無円高０６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvanoneumyenkijyun06 zrnmvanoneumyenkijyun06}</td><td>（連携用）ＭＶＡ適用外Ｗ換算目標額到達有無中央値０６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvanoneumyenyasu06 zrnmvanoneumyenyasu06}</td><td>（連携用）ＭＶＡ適用外Ｗ換算目標額到達有無円安０６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvanonevtuktype06 zrnmvanonevtuktype06}</td><td>（連携用）ＭＶＡ適用外保険料積立金額通貨タイプ０６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvanonev06 zrnmvanonev06}</td><td>（連携用）ＭＶＡ適用外保険料積立金額０６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvanonekaisiinnumukbn07 zrnmvanonekaisiinnumukbn07}</td><td>（連携用）ＭＶＡ適用外開始印有無区分０７</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvanonenenoutouym07 zrnmvanonenenoutouym07}</td><td>（連携用）ＭＶＡ適用外年単位応当年月０７</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvanonewtuktype07 zrnmvanonewtuktype07}</td><td>（連携用）ＭＶＡ適用外Ｗ通貨タイプ０７</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvanonew07 zrnmvanonew07}</td><td>（連携用）ＭＶＡ適用外Ｗ０７</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvanonewyentuktype07 zrnmvanonewyentuktype07}</td><td>（連携用）ＭＶＡ適用外Ｗ換算通貨タイプ０７</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvanonewyendaka07 zrnmvanonewyendaka07}</td><td>（連携用）ＭＶＡ適用外Ｗ換算０７円高</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvanonewyenkijyun07 zrnmvanonewyenkijyun07}</td><td>（連携用）ＭＶＡ適用外Ｗ換算０７中央値</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvanonewyenyasu07 zrnmvanonewyenyasu07}</td><td>（連携用）ＭＶＡ適用外Ｗ換算０７円安</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvanoneumyendaka07 zrnmvanoneumyendaka07}</td><td>（連携用）ＭＶＡ適用外Ｗ換算目標額到達有無円高０７</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvanoneumyenkijyun07 zrnmvanoneumyenkijyun07}</td><td>（連携用）ＭＶＡ適用外Ｗ換算目標額到達有無中央値０７</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvanoneumyenyasu07 zrnmvanoneumyenyasu07}</td><td>（連携用）ＭＶＡ適用外Ｗ換算目標額到達有無円安０７</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvanonevtuktype07 zrnmvanonevtuktype07}</td><td>（連携用）ＭＶＡ適用外保険料積立金額通貨タイプ０７</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvanonev07 zrnmvanonev07}</td><td>（連携用）ＭＶＡ適用外保険料積立金額０７</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvanonekaisiinnumukbn08 zrnmvanonekaisiinnumukbn08}</td><td>（連携用）ＭＶＡ適用外開始印有無区分０８</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvanonenenoutouym08 zrnmvanonenenoutouym08}</td><td>（連携用）ＭＶＡ適用外年単位応当年月０８</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvanonewtuktype08 zrnmvanonewtuktype08}</td><td>（連携用）ＭＶＡ適用外Ｗ通貨タイプ０８</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvanonew08 zrnmvanonew08}</td><td>（連携用）ＭＶＡ適用外Ｗ０８</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvanonewyentuktype08 zrnmvanonewyentuktype08}</td><td>（連携用）ＭＶＡ適用外Ｗ換算通貨タイプ０８</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvanonewyendaka08 zrnmvanonewyendaka08}</td><td>（連携用）ＭＶＡ適用外Ｗ換算０８円高</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvanonewyenkijyun08 zrnmvanonewyenkijyun08}</td><td>（連携用）ＭＶＡ適用外Ｗ換算０８中央値</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvanonewyenyasu08 zrnmvanonewyenyasu08}</td><td>（連携用）ＭＶＡ適用外Ｗ換算０８円安</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvanoneumyendaka08 zrnmvanoneumyendaka08}</td><td>（連携用）ＭＶＡ適用外Ｗ換算目標額到達有無円高０８</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvanoneumyenkijyun08 zrnmvanoneumyenkijyun08}</td><td>（連携用）ＭＶＡ適用外Ｗ換算目標額到達有無中央値０８</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvanoneumyenyasu08 zrnmvanoneumyenyasu08}</td><td>（連携用）ＭＶＡ適用外Ｗ換算目標額到達有無円安０８</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvanonevtuktype08 zrnmvanonevtuktype08}</td><td>（連携用）ＭＶＡ適用外保険料積立金額通貨タイプ０８</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvanonev08 zrnmvanonev08}</td><td>（連携用）ＭＶＡ適用外保険料積立金額０８</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvanonekaisiinnumukbn09 zrnmvanonekaisiinnumukbn09}</td><td>（連携用）ＭＶＡ適用外開始印有無区分０９</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvanonenenoutouym09 zrnmvanonenenoutouym09}</td><td>（連携用）ＭＶＡ適用外年単位応当年月０９</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvanonewtuktype09 zrnmvanonewtuktype09}</td><td>（連携用）ＭＶＡ適用外Ｗ通貨タイプ０９</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvanonew09 zrnmvanonew09}</td><td>（連携用）ＭＶＡ適用外Ｗ０９</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvanonewyentuktype09 zrnmvanonewyentuktype09}</td><td>（連携用）ＭＶＡ適用外Ｗ換算通貨タイプ０９</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvanonewyendaka09 zrnmvanonewyendaka09}</td><td>（連携用）ＭＶＡ適用外Ｗ換算０９円高</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvanonewyenkijyun09 zrnmvanonewyenkijyun09}</td><td>（連携用）ＭＶＡ適用外Ｗ換算０９中央値</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvanonewyenyasu09 zrnmvanonewyenyasu09}</td><td>（連携用）ＭＶＡ適用外Ｗ換算０９円安</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvanoneumyendaka09 zrnmvanoneumyendaka09}</td><td>（連携用）ＭＶＡ適用外Ｗ換算目標額到達有無円高０９</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvanoneumyenkijyun09 zrnmvanoneumyenkijyun09}</td><td>（連携用）ＭＶＡ適用外Ｗ換算目標額到達有無中央値０９</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvanoneumyenyasu09 zrnmvanoneumyenyasu09}</td><td>（連携用）ＭＶＡ適用外Ｗ換算目標額到達有無円安０９</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvanonevtuktype09 zrnmvanonevtuktype09}</td><td>（連携用）ＭＶＡ適用外保険料積立金額通貨タイプ０９</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvanonev09 zrnmvanonev09}</td><td>（連携用）ＭＶＡ適用外保険料積立金額０９</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvanonekaisiinnumukbn10 zrnmvanonekaisiinnumukbn10}</td><td>（連携用）ＭＶＡ適用外開始印有無区分１０</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvanonenenoutouym10 zrnmvanonenenoutouym10}</td><td>（連携用）ＭＶＡ適用外年単位応当年月１０</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvanonewtuktype10 zrnmvanonewtuktype10}</td><td>（連携用）ＭＶＡ適用外Ｗ通貨タイプ１０</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvanonew10 zrnmvanonew10}</td><td>（連携用）ＭＶＡ適用外Ｗ１０</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvanonewyentuktype10 zrnmvanonewyentuktype10}</td><td>（連携用）ＭＶＡ適用外Ｗ換算通貨タイプ１０</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvanonewyendaka10 zrnmvanonewyendaka10}</td><td>（連携用）ＭＶＡ適用外Ｗ換算１０円高</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvanonewyenkijyun10 zrnmvanonewyenkijyun10}</td><td>（連携用）ＭＶＡ適用外Ｗ換算１０中央値</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvanonewyenyasu10 zrnmvanonewyenyasu10}</td><td>（連携用）ＭＶＡ適用外Ｗ換算１０円安</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvanoneumyendaka10 zrnmvanoneumyendaka10}</td><td>（連携用）ＭＶＡ適用外Ｗ換算目標額到達有無円高１０</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvanoneumyenkijyun10 zrnmvanoneumyenkijyun10}</td><td>（連携用）ＭＶＡ適用外Ｗ換算目標額到達有無中央値１０</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvanoneumyenyasu10 zrnmvanoneumyenyasu10}</td><td>（連携用）ＭＶＡ適用外Ｗ換算目標額到達有無円安１０</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvanonevtuktype10 zrnmvanonevtuktype10}</td><td>（連携用）ＭＶＡ適用外保険料積立金額通貨タイプ１０</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvanonev10 zrnmvanonev10}</td><td>（連携用）ＭＶＡ適用外保険料積立金額１０</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvanonekaisiinnumukbn11 zrnmvanonekaisiinnumukbn11}</td><td>（連携用）ＭＶＡ適用外開始印有無区分１１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvanonenenoutouym11 zrnmvanonenenoutouym11}</td><td>（連携用）ＭＶＡ適用外年単位応当年月１１</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvanonewtuktype11 zrnmvanonewtuktype11}</td><td>（連携用）ＭＶＡ適用外Ｗ通貨タイプ１１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvanonew11 zrnmvanonew11}</td><td>（連携用）ＭＶＡ適用外Ｗ１１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvanonewyentuktype11 zrnmvanonewyentuktype11}</td><td>（連携用）ＭＶＡ適用外Ｗ換算通貨タイプ１１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvanonewyendaka11 zrnmvanonewyendaka11}</td><td>（連携用）ＭＶＡ適用外Ｗ換算１１円高</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvanonewyenkijyun11 zrnmvanonewyenkijyun11}</td><td>（連携用）ＭＶＡ適用外Ｗ換算１１中央値</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvanonewyenyasu11 zrnmvanonewyenyasu11}</td><td>（連携用）ＭＶＡ適用外Ｗ換算１１円安</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvanoneumyendaka11 zrnmvanoneumyendaka11}</td><td>（連携用）ＭＶＡ適用外Ｗ換算目標額到達有無円高１１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvanoneumyenkijyun11 zrnmvanoneumyenkijyun11}</td><td>（連携用）ＭＶＡ適用外Ｗ換算目標額到達有無中央値１１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvanoneumyenyasu11 zrnmvanoneumyenyasu11}</td><td>（連携用）ＭＶＡ適用外Ｗ換算目標額到達有無円安１１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvanonevtuktype11 zrnmvanonevtuktype11}</td><td>（連携用）ＭＶＡ適用外保険料積立金額通貨タイプ１１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvanonev11 zrnmvanonev11}</td><td>（連携用）ＭＶＡ適用外保険料積立金額１１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvanonekaisiinnumukbn12 zrnmvanonekaisiinnumukbn12}</td><td>（連携用）ＭＶＡ適用外開始印有無区分１２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvanonenenoutouym12 zrnmvanonenenoutouym12}</td><td>（連携用）ＭＶＡ適用外年単位応当年月１２</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvanonewtuktype12 zrnmvanonewtuktype12}</td><td>（連携用）ＭＶＡ適用外Ｗ通貨タイプ１２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvanonew12 zrnmvanonew12}</td><td>（連携用）ＭＶＡ適用外Ｗ１２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvanonewyentuktype12 zrnmvanonewyentuktype12}</td><td>（連携用）ＭＶＡ適用外Ｗ換算通貨タイプ１２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvanonewyendaka12 zrnmvanonewyendaka12}</td><td>（連携用）ＭＶＡ適用外Ｗ換算１２円高</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvanonewyenkijyun12 zrnmvanonewyenkijyun12}</td><td>（連携用）ＭＶＡ適用外Ｗ換算１２中央値</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvanonewyenyasu12 zrnmvanonewyenyasu12}</td><td>（連携用）ＭＶＡ適用外Ｗ換算１２円安</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvanoneumyendaka12 zrnmvanoneumyendaka12}</td><td>（連携用）ＭＶＡ適用外Ｗ換算目標額到達有無円高１２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvanoneumyenkijyun12 zrnmvanoneumyenkijyun12}</td><td>（連携用）ＭＶＡ適用外Ｗ換算目標額到達有無中央値１２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvanoneumyenyasu12 zrnmvanoneumyenyasu12}</td><td>（連携用）ＭＶＡ適用外Ｗ換算目標額到達有無円安１２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvanonevtuktype12 zrnmvanonevtuktype12}</td><td>（連携用）ＭＶＡ適用外保険料積立金額通貨タイプ１２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvanonev12 zrnmvanonev12}</td><td>（連携用）ＭＶＡ適用外保険料積立金額１２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvanonekaisiinnumukbn13 zrnmvanonekaisiinnumukbn13}</td><td>（連携用）ＭＶＡ適用外開始印有無区分１３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvanonenenoutouym13 zrnmvanonenenoutouym13}</td><td>（連携用）ＭＶＡ適用外年単位応当年月１３</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvanonewtuktype13 zrnmvanonewtuktype13}</td><td>（連携用）ＭＶＡ適用外Ｗ通貨タイプ１３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvanonew13 zrnmvanonew13}</td><td>（連携用）ＭＶＡ適用外Ｗ１３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvanonewyentuktype13 zrnmvanonewyentuktype13}</td><td>（連携用）ＭＶＡ適用外Ｗ換算通貨タイプ１３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvanonewyendaka13 zrnmvanonewyendaka13}</td><td>（連携用）ＭＶＡ適用外Ｗ換算１３円高</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvanonewyenkijyun13 zrnmvanonewyenkijyun13}</td><td>（連携用）ＭＶＡ適用外Ｗ換算１３中央値</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvanonewyenyasu13 zrnmvanonewyenyasu13}</td><td>（連携用）ＭＶＡ適用外Ｗ換算１３円安</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvanoneumyendaka13 zrnmvanoneumyendaka13}</td><td>（連携用）ＭＶＡ適用外Ｗ換算目標額到達有無円高１３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvanoneumyenkijyun13 zrnmvanoneumyenkijyun13}</td><td>（連携用）ＭＶＡ適用外Ｗ換算目標額到達有無中央値１３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvanoneumyenyasu13 zrnmvanoneumyenyasu13}</td><td>（連携用）ＭＶＡ適用外Ｗ換算目標額到達有無円安１３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvanonevtuktype13 zrnmvanonevtuktype13}</td><td>（連携用）ＭＶＡ適用外保険料積立金額通貨タイプ１３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvanonev13 zrnmvanonev13}</td><td>（連携用）ＭＶＡ適用外保険料積立金額１３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvanonekaisiinnumukbn14 zrnmvanonekaisiinnumukbn14}</td><td>（連携用）ＭＶＡ適用外開始印有無区分１４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvanonenenoutouym14 zrnmvanonenenoutouym14}</td><td>（連携用）ＭＶＡ適用外年単位応当年月１４</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvanonewtuktype14 zrnmvanonewtuktype14}</td><td>（連携用）ＭＶＡ適用外Ｗ通貨タイプ１４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvanonew14 zrnmvanonew14}</td><td>（連携用）ＭＶＡ適用外Ｗ１４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvanonewyentuktype14 zrnmvanonewyentuktype14}</td><td>（連携用）ＭＶＡ適用外Ｗ換算通貨タイプ１４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvanonewyendaka14 zrnmvanonewyendaka14}</td><td>（連携用）ＭＶＡ適用外Ｗ換算１４円高</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvanonewyenkijyun14 zrnmvanonewyenkijyun14}</td><td>（連携用）ＭＶＡ適用外Ｗ換算１４中央値</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvanonewyenyasu14 zrnmvanonewyenyasu14}</td><td>（連携用）ＭＶＡ適用外Ｗ換算１４円安</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvanoneumyendaka14 zrnmvanoneumyendaka14}</td><td>（連携用）ＭＶＡ適用外Ｗ換算目標額到達有無円高１４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvanoneumyenkijyun14 zrnmvanoneumyenkijyun14}</td><td>（連携用）ＭＶＡ適用外Ｗ換算目標額到達有無中央値１４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvanoneumyenyasu14 zrnmvanoneumyenyasu14}</td><td>（連携用）ＭＶＡ適用外Ｗ換算目標額到達有無円安１４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvanonevtuktype14 zrnmvanonevtuktype14}</td><td>（連携用）ＭＶＡ適用外保険料積立金額通貨タイプ１４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvanonev14 zrnmvanonev14}</td><td>（連携用）ＭＶＡ適用外保険料積立金額１４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnwmsgcd1 zrnwmsgcd1}</td><td>（連携用）解約返戻金メッセージコード１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnwmsgcd2 zrnwmsgcd2}</td><td>（連携用）解約返戻金メッセージコード２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnwmsgcd3 zrnwmsgcd3}</td><td>（連携用）解約返戻金メッセージコード３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnwmsgcd21 zrnwmsgcd21}</td><td>（連携用）解約返戻金メッセージコード２＿１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnwmsgcd22 zrnwmsgcd22}</td><td>（連携用）解約返戻金メッセージコード２＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnwmsgcd23 zrnwmsgcd23}</td><td>（連携用）解約返戻金メッセージコード２＿３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnwmsgcd31 zrnwmsgcd31}</td><td>（連携用）解約返戻金メッセージコード３＿１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnwmsgcd32 zrnwmsgcd32}</td><td>（連携用）解約返戻金メッセージコード３＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnwmsgcd33 zrnwmsgcd33}</td><td>（連携用）解約返戻金メッセージコード３＿３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnwmsgcdst1 zrnwmsgcdst1}</td><td>（連携用）解約返戻金メッセージコード表下１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnwtyuuimsgcd1 zrnwtyuuimsgcd1}</td><td>（連携用）解約返戻金注意事項メッセージコード１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnwtyuuimsgcd2 zrnwtyuuimsgcd2}</td><td>（連携用）解約返戻金注意事項メッセージコード２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnwtyuuimsgcd3 zrnwtyuuimsgcd3}</td><td>（連携用）解約返戻金注意事項メッセージコード３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnwtyuuimsgcd4 zrnwtyuuimsgcd4}</td><td>（連携用）解約返戻金注意事項メッセージコード４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnwtyuuimsgcd5 zrnwtyuuimsgcd5}</td><td>（連携用）解約返戻金注意事項メッセージコード５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnwtyuuimsgcd6 zrnwtyuuimsgcd6}</td><td>（連携用）解約返戻金注意事項メッセージコード６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnwtyuuimsgcd7 zrnwtyuuimsgcd7}</td><td>（連携用）解約返戻金注意事項メッセージコード７</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnwitjbrptuuktype zrnwitjbrptuuktype}</td><td>（連携用）解約返戻金一時払保険料通貨タイプ</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnwitjbrp zrnwitjbrp}</td><td>（連携用）解約返戻金一時払保険料</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnwyenhrikmgktuuktype zrnwyenhrikmgktuuktype}</td><td>（連携用）解約返戻金円貨払込額通貨タイプ</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnwyenhrikmgk zrnwyenhrikmgk}</td><td>（連携用）解約返戻金円貨払込額</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnwyenitjbrptuuktype zrnwyenitjbrptuuktype}</td><td>（連携用）解約返戻金円換算一時払保険料通貨タイプ</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnwyenitjbrp zrnwyenitjbrp}</td><td>（連携用）解約返戻金円換算一時払保険料</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnwsjkkktyouseitkyuym zrnwsjkkktyouseitkyuym}</td><td>（連携用）解約返戻金市場価格調整適用年月</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhrkkknmnryym zrnhrkkknmnryym}</td><td>（連携用）払込期間満了年月</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhrkkknmnrynen zrnhrkkknmnrynen}</td><td>（連携用）払込期間満了年齢</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv200 zrnyobiv200}</td><td>（連携用）予備項目Ｖ２００</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv49 zrnyobiv49}</td><td>（連携用）予備項目Ｖ４９</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 * </table>
 * @see     ZT_SaihakkouSyoukenSuiiRn
 * @see     PKZT_SaihakkouSyoukenSuiiRn
 * @see     QZT_SaihakkouSyoukenSuiiRn
 * @see     GenQZT_SaihakkouSyoukenSuiiRn
 */
@MappedSuperclass
@Table(name=GenZT_SaihakkouSyoukenSuiiRn.TABLE_NAME)
@IdClass(value=PKZT_SaihakkouSyoukenSuiiRn.class)
public abstract class GenZT_SaihakkouSyoukenSuiiRn extends AbstractExDBEntityForZDB<ZT_SaihakkouSyoukenSuiiRn, PKZT_SaihakkouSyoukenSuiiRn> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "ZT_SaihakkouSyoukenSuiiRn";
    public static final String ZRNSYONO                 = "zrnsyono";
    public static final String ZRNTYOUHYOUYMD           = "zrntyouhyouymd";
    public static final String ZRNSUIIHYOUPTN           = "zrnsuiihyouptn";
    public static final String ZRNSUIIHYOUSYKBN         = "zrnsuiihyousykbn";
    public static final String ZRNSUIIHYOUSYONO         = "zrnsuiihyousyono";
    public static final String ZRNSISUUUPRITU           = "zrnsisuuupritu";
    public static final String ZRNSAISYUUNNDYM          = "zrnsaisyuunndym";
    public static final String ZRNSJKKKTUSIRRTUP        = "zrnsjkkktusirrtup";
    public static final String ZRNSJKKKTUSIRRTSAME      = "zrnsjkkktusirrtsame";
    public static final String ZRNSJKKKTUSIRRTDOWN      = "zrnsjkkktusirrtdown";
    public static final String ZRNSJKKKTUSIRRTHENDOUUP  = "zrnsjkkktusirrthendouup";
    public static final String ZRNSJKKKTUSIRRTHENDOUDOWN = "zrnsjkkktusirrthendoudown";
    public static final String ZRNWKWSRATEYENDAKA       = "zrnwkwsrateyendaka";
    public static final String ZRNWKWSRATEYENKIJYUN     = "zrnwkwsrateyenkijyun";
    public static final String ZRNWKWSRATEYENYASU       = "zrnwkwsrateyenyasu";
    public static final String ZRNSUIIHYOUMKHYOUYENWRA  = "zrnsuiihyoumkhyouyenwra";
    public static final String ZRNMVAARINENOUTOUYM01    = "zrnmvaarinenoutouym01";
    public static final String ZRNMVAARISISUUUPRITU01   = "zrnmvaarisisuuupritu01";
    public static final String ZRNMVAARITMTTKNZKRITU01  = "zrnmvaaritmttknzkritu01";
    public static final String ZRNMVAARIWTUKTYPEUP01    = "zrnmvaariwtuktypeup01";
    public static final String ZRNMVAARITMTTKNKYKKJMUP01 = "zrnmvaaritmttknkykkjmup01";
    public static final String ZRNMVAARIWUP01           = "zrnmvaariwup01";
    public static final String ZRNMVAARIWYENTUKTYPEUP01 = "zrnmvaariwyentuktypeup01";
    public static final String ZRNMVAARIWUPYENDAKA01    = "zrnmvaariwupyendaka01";
    public static final String ZRNMVAARIWUPYENKIJYUN01  = "zrnmvaariwupyenkijyun01";
    public static final String ZRNMVAARIWUPYENYASU01    = "zrnmvaariwupyenyasu01";
    public static final String ZRNMVAARIWUMUPYENDAKA01  = "zrnmvaariwumupyendaka01";
    public static final String ZRNMVAARIUMUPYENKIJYUN01 = "zrnmvaariumupyenkijyun01";
    public static final String ZRNMVAARIUMUPYENYASU01   = "zrnmvaariumupyenyasu01";
    public static final String ZRNMVAARIWTUKTYPESAME01  = "zrnmvaariwtuktypesame01";
    public static final String ZRNMVAARITMTTKNKYKKJMSAME01 = "zrnmvaaritmttknkykkjmsame01";
    public static final String ZRNMVAARIWSAME01         = "zrnmvaariwsame01";
    public static final String ZRNMVAARIWYENTUKTYPESAME01 = "zrnmvaariwyentuktypesame01";
    public static final String ZRNMVAARIWSAMEYENDAKA01  = "zrnmvaariwsameyendaka01";
    public static final String ZRNMVAARIWSAMEYENKIJYUN01 = "zrnmvaariwsameyenkijyun01";
    public static final String ZRNMVAARIWSAMEYENYASU01  = "zrnmvaariwsameyenyasu01";
    public static final String ZRNMVAARIUMSAMEYENDAKA01 = "zrnmvaariumsameyendaka01";
    public static final String ZRNMVAARIUMSAMEYENKIJYUN01 = "zrnmvaariumsameyenkijyun01";
    public static final String ZRNMVAARIUMSAMEYENYASU01 = "zrnmvaariumsameyenyasu01";
    public static final String ZRNMVAARIWTUKTYPEDOWN01  = "zrnmvaariwtuktypedown01";
    public static final String ZRNMVAARITMTTKNKYKKJMDOWN01 = "zrnmvaaritmttknkykkjmdown01";
    public static final String ZRNMVAARIWDOWN01         = "zrnmvaariwdown01";
    public static final String ZRNMVAARIWYENTUKTYPEDOWN01 = "zrnmvaariwyentuktypedown01";
    public static final String ZRNMVAARIWDOWNYENDAKA01  = "zrnmvaariwdownyendaka01";
    public static final String ZRNMVAARIWDOWNYENKIJYUN01 = "zrnmvaariwdownyenkijyun01";
    public static final String ZRNMVAARIWDOWNYENYASU01  = "zrnmvaariwdownyenyasu01";
    public static final String ZRNMVAARIUMDOWNYENDAKA01 = "zrnmvaariumdownyendaka01";
    public static final String ZRNMVAARIUMDOWNYENKIJYUN01 = "zrnmvaariumdownyenkijyun01";
    public static final String ZRNMVAARIUMDOWNYENYASU01 = "zrnmvaariumdownyenyasu01";
    public static final String ZRNMVAARIVTUKTYPE01      = "zrnmvaarivtuktype01";
    public static final String ZRNMVAARIV01             = "zrnmvaariv01";
    public static final String ZRNPTMTTKNGKUTIWAKE101   = "zrnptmttkngkutiwake101";
    public static final String ZRNPTMTTKNGKUTIWAKE201   = "zrnptmttkngkutiwake201";
    public static final String ZRNMVAARINENOUTOUYM02    = "zrnmvaarinenoutouym02";
    public static final String ZRNMVAARISISUUUPRITU02   = "zrnmvaarisisuuupritu02";
    public static final String ZRNMVAARITMTTKNZKRITU02  = "zrnmvaaritmttknzkritu02";
    public static final String ZRNMVAARIWTUKTYPEUP02    = "zrnmvaariwtuktypeup02";
    public static final String ZRNMVAARITMTTKNKYKKJMUP02 = "zrnmvaaritmttknkykkjmup02";
    public static final String ZRNMVAARIWUP02           = "zrnmvaariwup02";
    public static final String ZRNMVAARIWYENTUKTYPEUP02 = "zrnmvaariwyentuktypeup02";
    public static final String ZRNMVAARIWUPYENDAKA02    = "zrnmvaariwupyendaka02";
    public static final String ZRNMVAARIWUPYENKIJYUN02  = "zrnmvaariwupyenkijyun02";
    public static final String ZRNMVAARIWUPYENYASU02    = "zrnmvaariwupyenyasu02";
    public static final String ZRNMVAARIWUMUPYENDAKA02  = "zrnmvaariwumupyendaka02";
    public static final String ZRNMVAARIUMUPYENKIJYUN02 = "zrnmvaariumupyenkijyun02";
    public static final String ZRNMVAARIUMUPYENYASU02   = "zrnmvaariumupyenyasu02";
    public static final String ZRNMVAARIWTUKTYPESAME02  = "zrnmvaariwtuktypesame02";
    public static final String ZRNMVAARITMTTKNKYKKJMSAME02 = "zrnmvaaritmttknkykkjmsame02";
    public static final String ZRNMVAARIWSAME02         = "zrnmvaariwsame02";
    public static final String ZRNMVAARIWYENTUKTYPESAME02 = "zrnmvaariwyentuktypesame02";
    public static final String ZRNMVAARIWSAMEYENDAKA02  = "zrnmvaariwsameyendaka02";
    public static final String ZRNMVAARIWSAMEYENKIJYUN02 = "zrnmvaariwsameyenkijyun02";
    public static final String ZRNMVAARIWSAMEYENYASU02  = "zrnmvaariwsameyenyasu02";
    public static final String ZRNMVAARIUMSAMEYENDAKA02 = "zrnmvaariumsameyendaka02";
    public static final String ZRNMVAARIUMSAMEYENKIJYUN02 = "zrnmvaariumsameyenkijyun02";
    public static final String ZRNMVAARIUMSAMEYENYASU02 = "zrnmvaariumsameyenyasu02";
    public static final String ZRNMVAARIWTUKTYPEDOWN02  = "zrnmvaariwtuktypedown02";
    public static final String ZRNMVAARITMTTKNKYKKJMDOWN02 = "zrnmvaaritmttknkykkjmdown02";
    public static final String ZRNMVAARIWDOWN02         = "zrnmvaariwdown02";
    public static final String ZRNMVAARIWYENTUKTYPEDOWN02 = "zrnmvaariwyentuktypedown02";
    public static final String ZRNMVAARIWDOWNYENDAKA02  = "zrnmvaariwdownyendaka02";
    public static final String ZRNMVAARIWDOWNYENKIJYUN02 = "zrnmvaariwdownyenkijyun02";
    public static final String ZRNMVAARIWDOWNYENYASU02  = "zrnmvaariwdownyenyasu02";
    public static final String ZRNMVAARIUMDOWNYENDAKA02 = "zrnmvaariumdownyendaka02";
    public static final String ZRNMVAARIUMDOWNYENKIJYUN02 = "zrnmvaariumdownyenkijyun02";
    public static final String ZRNMVAARIUMDOWNYENYASU02 = "zrnmvaariumdownyenyasu02";
    public static final String ZRNMVAARIVTUKTYPE02      = "zrnmvaarivtuktype02";
    public static final String ZRNMVAARIV02             = "zrnmvaariv02";
    public static final String ZRNPTMTTKNGKUTIWAKE102   = "zrnptmttkngkutiwake102";
    public static final String ZRNPTMTTKNGKUTIWAKE202   = "zrnptmttkngkutiwake202";
    public static final String ZRNMVAARINENOUTOUYM03    = "zrnmvaarinenoutouym03";
    public static final String ZRNMVAARISISUUUPRITU03   = "zrnmvaarisisuuupritu03";
    public static final String ZRNMVAARITMTTKNZKRITU03  = "zrnmvaaritmttknzkritu03";
    public static final String ZRNMVAARIWTUKTYPEUP03    = "zrnmvaariwtuktypeup03";
    public static final String ZRNMVAARITMTTKNKYKKJMUP03 = "zrnmvaaritmttknkykkjmup03";
    public static final String ZRNMVAARIWUP03           = "zrnmvaariwup03";
    public static final String ZRNMVAARIWYENTUKTYPEUP03 = "zrnmvaariwyentuktypeup03";
    public static final String ZRNMVAARIWUPYENDAKA03    = "zrnmvaariwupyendaka03";
    public static final String ZRNMVAARIWUPYENKIJYUN03  = "zrnmvaariwupyenkijyun03";
    public static final String ZRNMVAARIWUPYENYASU03    = "zrnmvaariwupyenyasu03";
    public static final String ZRNMVAARIWUMUPYENDAKA03  = "zrnmvaariwumupyendaka03";
    public static final String ZRNMVAARIUMUPYENKIJYUN03 = "zrnmvaariumupyenkijyun03";
    public static final String ZRNMVAARIUMUPYENYASU03   = "zrnmvaariumupyenyasu03";
    public static final String ZRNMVAARIWTUKTYPESAME03  = "zrnmvaariwtuktypesame03";
    public static final String ZRNMVAARITMTTKNKYKKJMSAME03 = "zrnmvaaritmttknkykkjmsame03";
    public static final String ZRNMVAARIWSAME03         = "zrnmvaariwsame03";
    public static final String ZRNMVAARIWYENTUKTYPESAME03 = "zrnmvaariwyentuktypesame03";
    public static final String ZRNMVAARIWSAMEYENDAKA03  = "zrnmvaariwsameyendaka03";
    public static final String ZRNMVAARIWSAMEYENKIJYUN03 = "zrnmvaariwsameyenkijyun03";
    public static final String ZRNMVAARIWSAMEYENYASU03  = "zrnmvaariwsameyenyasu03";
    public static final String ZRNMVAARIUMSAMEYENDAKA03 = "zrnmvaariumsameyendaka03";
    public static final String ZRNMVAARIUMSAMEYENKIJYUN03 = "zrnmvaariumsameyenkijyun03";
    public static final String ZRNMVAARIUMSAMEYENYASU03 = "zrnmvaariumsameyenyasu03";
    public static final String ZRNMVAARIWTUKTYPEDOWN03  = "zrnmvaariwtuktypedown03";
    public static final String ZRNMVAARITMTTKNKYKKJMDOWN03 = "zrnmvaaritmttknkykkjmdown03";
    public static final String ZRNMVAARIWDOWN03         = "zrnmvaariwdown03";
    public static final String ZRNMVAARIWYENTUKTYPEDOWN03 = "zrnmvaariwyentuktypedown03";
    public static final String ZRNMVAARIWDOWNYENDAKA03  = "zrnmvaariwdownyendaka03";
    public static final String ZRNMVAARIWDOWNYENKIJYUN03 = "zrnmvaariwdownyenkijyun03";
    public static final String ZRNMVAARIWDOWNYENYASU03  = "zrnmvaariwdownyenyasu03";
    public static final String ZRNMVAARIUMDOWNYENDAKA03 = "zrnmvaariumdownyendaka03";
    public static final String ZRNMVAARIUMDOWNYENKIJYUN03 = "zrnmvaariumdownyenkijyun03";
    public static final String ZRNMVAARIUMDOWNYENYASU03 = "zrnmvaariumdownyenyasu03";
    public static final String ZRNMVAARIVTUKTYPE03      = "zrnmvaarivtuktype03";
    public static final String ZRNMVAARIV03             = "zrnmvaariv03";
    public static final String ZRNPTMTTKNGKUTIWAKE103   = "zrnptmttkngkutiwake103";
    public static final String ZRNPTMTTKNGKUTIWAKE203   = "zrnptmttkngkutiwake203";
    public static final String ZRNMVAARINENOUTOUYM04    = "zrnmvaarinenoutouym04";
    public static final String ZRNMVAARISISUUUPRITU04   = "zrnmvaarisisuuupritu04";
    public static final String ZRNMVAARITMTTKNZKRITU04  = "zrnmvaaritmttknzkritu04";
    public static final String ZRNMVAARIWTUKTYPEUP04    = "zrnmvaariwtuktypeup04";
    public static final String ZRNMVAARITMTTKNKYKKJMUP04 = "zrnmvaaritmttknkykkjmup04";
    public static final String ZRNMVAARIWUP04           = "zrnmvaariwup04";
    public static final String ZRNMVAARIWYENTUKTYPEUP04 = "zrnmvaariwyentuktypeup04";
    public static final String ZRNMVAARIWUPYENDAKA04    = "zrnmvaariwupyendaka04";
    public static final String ZRNMVAARIWUPYENKIJYUN04  = "zrnmvaariwupyenkijyun04";
    public static final String ZRNMVAARIWUPYENYASU04    = "zrnmvaariwupyenyasu04";
    public static final String ZRNMVAARIWUMUPYENDAKA04  = "zrnmvaariwumupyendaka04";
    public static final String ZRNMVAARIUMUPYENKIJYUN04 = "zrnmvaariumupyenkijyun04";
    public static final String ZRNMVAARIUMUPYENYASU04   = "zrnmvaariumupyenyasu04";
    public static final String ZRNMVAARIWTUKTYPESAME04  = "zrnmvaariwtuktypesame04";
    public static final String ZRNMVAARITMTTKNKYKKJMSAME04 = "zrnmvaaritmttknkykkjmsame04";
    public static final String ZRNMVAARIWSAME04         = "zrnmvaariwsame04";
    public static final String ZRNMVAARIWYENTUKTYPESAME04 = "zrnmvaariwyentuktypesame04";
    public static final String ZRNMVAARIWSAMEYENDAKA04  = "zrnmvaariwsameyendaka04";
    public static final String ZRNMVAARIWSAMEYENKIJYUN04 = "zrnmvaariwsameyenkijyun04";
    public static final String ZRNMVAARIWSAMEYENYASU04  = "zrnmvaariwsameyenyasu04";
    public static final String ZRNMVAARIUMSAMEYENDAKA04 = "zrnmvaariumsameyendaka04";
    public static final String ZRNMVAARIUMSAMEYENKIJYUN04 = "zrnmvaariumsameyenkijyun04";
    public static final String ZRNMVAARIUMSAMEYENYASU04 = "zrnmvaariumsameyenyasu04";
    public static final String ZRNMVAARIWTUKTYPEDOWN04  = "zrnmvaariwtuktypedown04";
    public static final String ZRNMVAARITMTTKNKYKKJMDOWN04 = "zrnmvaaritmttknkykkjmdown04";
    public static final String ZRNMVAARIWDOWN04         = "zrnmvaariwdown04";
    public static final String ZRNMVAARIWYENTUKTYPEDOWN04 = "zrnmvaariwyentuktypedown04";
    public static final String ZRNMVAARIWDOWNYENDAKA04  = "zrnmvaariwdownyendaka04";
    public static final String ZRNMVAARIWDOWNYENKIJYUN04 = "zrnmvaariwdownyenkijyun04";
    public static final String ZRNMVAARIWDOWNYENYASU04  = "zrnmvaariwdownyenyasu04";
    public static final String ZRNMVAARIUMDOWNYENDAKA04 = "zrnmvaariumdownyendaka04";
    public static final String ZRNMVAARIUMDOWNYENKIJYUN04 = "zrnmvaariumdownyenkijyun04";
    public static final String ZRNMVAARIUMDOWNYENYASU04 = "zrnmvaariumdownyenyasu04";
    public static final String ZRNMVAARIVTUKTYPE04      = "zrnmvaarivtuktype04";
    public static final String ZRNMVAARIV04             = "zrnmvaariv04";
    public static final String ZRNPTMTTKNGKUTIWAKE104   = "zrnptmttkngkutiwake104";
    public static final String ZRNPTMTTKNGKUTIWAKE204   = "zrnptmttkngkutiwake204";
    public static final String ZRNMVAARINENOUTOUYM05    = "zrnmvaarinenoutouym05";
    public static final String ZRNMVAARISISUUUPRITU05   = "zrnmvaarisisuuupritu05";
    public static final String ZRNMVAARITMTTKNZKRITU05  = "zrnmvaaritmttknzkritu05";
    public static final String ZRNMVAARIWTUKTYPEUP05    = "zrnmvaariwtuktypeup05";
    public static final String ZRNMVAARITMTTKNKYKKJMUP05 = "zrnmvaaritmttknkykkjmup05";
    public static final String ZRNMVAARIWUP05           = "zrnmvaariwup05";
    public static final String ZRNMVAARIWYENTUKTYPEUP05 = "zrnmvaariwyentuktypeup05";
    public static final String ZRNMVAARIWUPYENDAKA05    = "zrnmvaariwupyendaka05";
    public static final String ZRNMVAARIWUPYENKIJYUN05  = "zrnmvaariwupyenkijyun05";
    public static final String ZRNMVAARIWUPYENYASU05    = "zrnmvaariwupyenyasu05";
    public static final String ZRNMVAARIWUMUPYENDAKA05  = "zrnmvaariwumupyendaka05";
    public static final String ZRNMVAARIUMUPYENKIJYUN05 = "zrnmvaariumupyenkijyun05";
    public static final String ZRNMVAARIUMUPYENYASU05   = "zrnmvaariumupyenyasu05";
    public static final String ZRNMVAARIWTUKTYPESAME05  = "zrnmvaariwtuktypesame05";
    public static final String ZRNMVAARITMTTKNKYKKJMSAME05 = "zrnmvaaritmttknkykkjmsame05";
    public static final String ZRNMVAARIWSAME05         = "zrnmvaariwsame05";
    public static final String ZRNMVAARIWYENTUKTYPESAME05 = "zrnmvaariwyentuktypesame05";
    public static final String ZRNMVAARIWSAMEYENDAKA05  = "zrnmvaariwsameyendaka05";
    public static final String ZRNMVAARIWSAMEYENKIJYUN05 = "zrnmvaariwsameyenkijyun05";
    public static final String ZRNMVAARIWSAMEYENYASU05  = "zrnmvaariwsameyenyasu05";
    public static final String ZRNMVAARIUMSAMEYENDAKA05 = "zrnmvaariumsameyendaka05";
    public static final String ZRNMVAARIUMSAMEYENKIJYUN05 = "zrnmvaariumsameyenkijyun05";
    public static final String ZRNMVAARIUMSAMEYENYASU05 = "zrnmvaariumsameyenyasu05";
    public static final String ZRNMVAARIWTUKTYPEDOWN05  = "zrnmvaariwtuktypedown05";
    public static final String ZRNMVAARITMTTKNKYKKJMDOWN05 = "zrnmvaaritmttknkykkjmdown05";
    public static final String ZRNMVAARIWDOWN05         = "zrnmvaariwdown05";
    public static final String ZRNMVAARIWYENTUKTYPEDOWN05 = "zrnmvaariwyentuktypedown05";
    public static final String ZRNMVAARIWDOWNYENDAKA05  = "zrnmvaariwdownyendaka05";
    public static final String ZRNMVAARIWDOWNYENKIJYUN05 = "zrnmvaariwdownyenkijyun05";
    public static final String ZRNMVAARIWDOWNYENYASU05  = "zrnmvaariwdownyenyasu05";
    public static final String ZRNMVAARIUMDOWNYENDAKA05 = "zrnmvaariumdownyendaka05";
    public static final String ZRNMVAARIUMDOWNYENKIJYUN05 = "zrnmvaariumdownyenkijyun05";
    public static final String ZRNMVAARIUMDOWNYENYASU05 = "zrnmvaariumdownyenyasu05";
    public static final String ZRNMVAARIVTUKTYPE05      = "zrnmvaarivtuktype05";
    public static final String ZRNMVAARIV05             = "zrnmvaariv05";
    public static final String ZRNPTMTTKNGKUTIWAKE105   = "zrnptmttkngkutiwake105";
    public static final String ZRNPTMTTKNGKUTIWAKE205   = "zrnptmttkngkutiwake205";
    public static final String ZRNMVAARINENOUTOUYM06    = "zrnmvaarinenoutouym06";
    public static final String ZRNMVAARISISUUUPRITU06   = "zrnmvaarisisuuupritu06";
    public static final String ZRNMVAARITMTTKNZKRITU06  = "zrnmvaaritmttknzkritu06";
    public static final String ZRNMVAARIWTUKTYPEUP06    = "zrnmvaariwtuktypeup06";
    public static final String ZRNMVAARITMTTKNKYKKJMUP06 = "zrnmvaaritmttknkykkjmup06";
    public static final String ZRNMVAARIWUP06           = "zrnmvaariwup06";
    public static final String ZRNMVAARIWYENTUKTYPEUP06 = "zrnmvaariwyentuktypeup06";
    public static final String ZRNMVAARIWUPYENDAKA06    = "zrnmvaariwupyendaka06";
    public static final String ZRNMVAARIWUPYENKIJYUN06  = "zrnmvaariwupyenkijyun06";
    public static final String ZRNMVAARIWUPYENYASU06    = "zrnmvaariwupyenyasu06";
    public static final String ZRNMVAARIWUMUPYENDAKA06  = "zrnmvaariwumupyendaka06";
    public static final String ZRNMVAARIUMUPYENKIJYUN06 = "zrnmvaariumupyenkijyun06";
    public static final String ZRNMVAARIUMUPYENYASU06   = "zrnmvaariumupyenyasu06";
    public static final String ZRNMVAARIWTUKTYPESAME06  = "zrnmvaariwtuktypesame06";
    public static final String ZRNMVAARITMTTKNKYKKJMSAME06 = "zrnmvaaritmttknkykkjmsame06";
    public static final String ZRNMVAARIWSAME06         = "zrnmvaariwsame06";
    public static final String ZRNMVAARIWYENTUKTYPESAME06 = "zrnmvaariwyentuktypesame06";
    public static final String ZRNMVAARIWSAMEYENDAKA06  = "zrnmvaariwsameyendaka06";
    public static final String ZRNMVAARIWSAMEYENKIJYUN06 = "zrnmvaariwsameyenkijyun06";
    public static final String ZRNMVAARIWSAMEYENYASU06  = "zrnmvaariwsameyenyasu06";
    public static final String ZRNMVAARIUMSAMEYENDAKA06 = "zrnmvaariumsameyendaka06";
    public static final String ZRNMVAARIUMSAMEYENKIJYUN06 = "zrnmvaariumsameyenkijyun06";
    public static final String ZRNMVAARIUMSAMEYENYASU06 = "zrnmvaariumsameyenyasu06";
    public static final String ZRNMVAARIWTUKTYPEDOWN06  = "zrnmvaariwtuktypedown06";
    public static final String ZRNMVAARITMTTKNKYKKJMDOWN06 = "zrnmvaaritmttknkykkjmdown06";
    public static final String ZRNMVAARIWDOWN06         = "zrnmvaariwdown06";
    public static final String ZRNMVAARIWYENTUKTYPEDOWN06 = "zrnmvaariwyentuktypedown06";
    public static final String ZRNMVAARIWDOWNYENDAKA06  = "zrnmvaariwdownyendaka06";
    public static final String ZRNMVAARIWDOWNYENKIJYUN06 = "zrnmvaariwdownyenkijyun06";
    public static final String ZRNMVAARIWDOWNYENYASU06  = "zrnmvaariwdownyenyasu06";
    public static final String ZRNMVAARIUMDOWNYENDAKA06 = "zrnmvaariumdownyendaka06";
    public static final String ZRNMVAARIUMDOWNYENKIJYUN06 = "zrnmvaariumdownyenkijyun06";
    public static final String ZRNMVAARIUMDOWNYENYASU06 = "zrnmvaariumdownyenyasu06";
    public static final String ZRNMVAARIVTUKTYPE06      = "zrnmvaarivtuktype06";
    public static final String ZRNMVAARIV06             = "zrnmvaariv06";
    public static final String ZRNPTMTTKNGKUTIWAKE106   = "zrnptmttkngkutiwake106";
    public static final String ZRNPTMTTKNGKUTIWAKE206   = "zrnptmttkngkutiwake206";
    public static final String ZRNMVAARINENOUTOUYM07    = "zrnmvaarinenoutouym07";
    public static final String ZRNMVAARISISUUUPRITU07   = "zrnmvaarisisuuupritu07";
    public static final String ZRNMVAARITMTTKNZKRITU07  = "zrnmvaaritmttknzkritu07";
    public static final String ZRNMVAARIWTUKTYPEUP07    = "zrnmvaariwtuktypeup07";
    public static final String ZRNMVAARITMTTKNKYKKJMUP07 = "zrnmvaaritmttknkykkjmup07";
    public static final String ZRNMVAARIWUP07           = "zrnmvaariwup07";
    public static final String ZRNMVAARIWYENTUKTYPEUP07 = "zrnmvaariwyentuktypeup07";
    public static final String ZRNMVAARIWUPYENDAKA07    = "zrnmvaariwupyendaka07";
    public static final String ZRNMVAARIWUPYENKIJYUN07  = "zrnmvaariwupyenkijyun07";
    public static final String ZRNMVAARIWUPYENYASU07    = "zrnmvaariwupyenyasu07";
    public static final String ZRNMVAARIWUMUPYENDAKA07  = "zrnmvaariwumupyendaka07";
    public static final String ZRNMVAARIUMUPYENKIJYUN07 = "zrnmvaariumupyenkijyun07";
    public static final String ZRNMVAARIUMUPYENYASU07   = "zrnmvaariumupyenyasu07";
    public static final String ZRNMVAARIWTUKTYPESAME07  = "zrnmvaariwtuktypesame07";
    public static final String ZRNMVAARITMTTKNKYKKJMSAME07 = "zrnmvaaritmttknkykkjmsame07";
    public static final String ZRNMVAARIWSAME07         = "zrnmvaariwsame07";
    public static final String ZRNMVAARIWYENTUKTYPESAME07 = "zrnmvaariwyentuktypesame07";
    public static final String ZRNMVAARIWSAMEYENDAKA07  = "zrnmvaariwsameyendaka07";
    public static final String ZRNMVAARIWSAMEYENKIJYUN07 = "zrnmvaariwsameyenkijyun07";
    public static final String ZRNMVAARIWSAMEYENYASU07  = "zrnmvaariwsameyenyasu07";
    public static final String ZRNMVAARIUMSAMEYENDAKA07 = "zrnmvaariumsameyendaka07";
    public static final String ZRNMVAARIUMSAMEYENKIJYUN07 = "zrnmvaariumsameyenkijyun07";
    public static final String ZRNMVAARIUMSAMEYENYASU07 = "zrnmvaariumsameyenyasu07";
    public static final String ZRNMVAARIWTUKTYPEDOWN07  = "zrnmvaariwtuktypedown07";
    public static final String ZRNMVAARITMTTKNKYKKJMDOWN07 = "zrnmvaaritmttknkykkjmdown07";
    public static final String ZRNMVAARIWDOWN07         = "zrnmvaariwdown07";
    public static final String ZRNMVAARIWYENTUKTYPEDOWN07 = "zrnmvaariwyentuktypedown07";
    public static final String ZRNMVAARIWDOWNYENDAKA07  = "zrnmvaariwdownyendaka07";
    public static final String ZRNMVAARIWDOWNYENKIJYUN07 = "zrnmvaariwdownyenkijyun07";
    public static final String ZRNMVAARIWDOWNYENYASU07  = "zrnmvaariwdownyenyasu07";
    public static final String ZRNMVAARIUMDOWNYENDAKA07 = "zrnmvaariumdownyendaka07";
    public static final String ZRNMVAARIUMDOWNYENKIJYUN07 = "zrnmvaariumdownyenkijyun07";
    public static final String ZRNMVAARIUMDOWNYENYASU07 = "zrnmvaariumdownyenyasu07";
    public static final String ZRNMVAARIVTUKTYPE07      = "zrnmvaarivtuktype07";
    public static final String ZRNMVAARIV07             = "zrnmvaariv07";
    public static final String ZRNPTMTTKNGKUTIWAKE107   = "zrnptmttkngkutiwake107";
    public static final String ZRNPTMTTKNGKUTIWAKE207   = "zrnptmttkngkutiwake207";
    public static final String ZRNMVAARINENOUTOUYM08    = "zrnmvaarinenoutouym08";
    public static final String ZRNMVAARISISUUUPRITU08   = "zrnmvaarisisuuupritu08";
    public static final String ZRNMVAARITMTTKNZKRITU08  = "zrnmvaaritmttknzkritu08";
    public static final String ZRNMVAARIWTUKTYPEUP08    = "zrnmvaariwtuktypeup08";
    public static final String ZRNMVAARITMTTKNKYKKJMUP08 = "zrnmvaaritmttknkykkjmup08";
    public static final String ZRNMVAARIWUP08           = "zrnmvaariwup08";
    public static final String ZRNMVAARIWYENTUKTYPEUP08 = "zrnmvaariwyentuktypeup08";
    public static final String ZRNMVAARIWUPYENDAKA08    = "zrnmvaariwupyendaka08";
    public static final String ZRNMVAARIWUPYENKIJYUN08  = "zrnmvaariwupyenkijyun08";
    public static final String ZRNMVAARIWUPYENYASU08    = "zrnmvaariwupyenyasu08";
    public static final String ZRNMVAARIWUMUPYENDAKA08  = "zrnmvaariwumupyendaka08";
    public static final String ZRNMVAARIUMUPYENKIJYUN08 = "zrnmvaariumupyenkijyun08";
    public static final String ZRNMVAARIUMUPYENYASU08   = "zrnmvaariumupyenyasu08";
    public static final String ZRNMVAARIWTUKTYPESAME08  = "zrnmvaariwtuktypesame08";
    public static final String ZRNMVAARITMTTKNKYKKJMSAME08 = "zrnmvaaritmttknkykkjmsame08";
    public static final String ZRNMVAARIWSAME08         = "zrnmvaariwsame08";
    public static final String ZRNMVAARIWYENTUKTYPESAME08 = "zrnmvaariwyentuktypesame08";
    public static final String ZRNMVAARIWSAMEYENDAKA08  = "zrnmvaariwsameyendaka08";
    public static final String ZRNMVAARIWSAMEYENKIJYUN08 = "zrnmvaariwsameyenkijyun08";
    public static final String ZRNMVAARIWSAMEYENYASU08  = "zrnmvaariwsameyenyasu08";
    public static final String ZRNMVAARIUMSAMEYENDAKA08 = "zrnmvaariumsameyendaka08";
    public static final String ZRNMVAARIUMSAMEYENKIJYUN08 = "zrnmvaariumsameyenkijyun08";
    public static final String ZRNMVAARIUMSAMEYENYASU08 = "zrnmvaariumsameyenyasu08";
    public static final String ZRNMVAARIWTUKTYPEDOWN08  = "zrnmvaariwtuktypedown08";
    public static final String ZRNMVAARITMTTKNKYKKJMDOWN08 = "zrnmvaaritmttknkykkjmdown08";
    public static final String ZRNMVAARIWDOWN08         = "zrnmvaariwdown08";
    public static final String ZRNMVAARIWYENTUKTYPEDOWN08 = "zrnmvaariwyentuktypedown08";
    public static final String ZRNMVAARIWDOWNYENDAKA08  = "zrnmvaariwdownyendaka08";
    public static final String ZRNMVAARIWDOWNYENKIJYUN08 = "zrnmvaariwdownyenkijyun08";
    public static final String ZRNMVAARIWDOWNYENYASU08  = "zrnmvaariwdownyenyasu08";
    public static final String ZRNMVAARIUMDOWNYENDAKA08 = "zrnmvaariumdownyendaka08";
    public static final String ZRNMVAARIUMDOWNYENKIJYUN08 = "zrnmvaariumdownyenkijyun08";
    public static final String ZRNMVAARIUMDOWNYENYASU08 = "zrnmvaariumdownyenyasu08";
    public static final String ZRNMVAARIVTUKTYPE08      = "zrnmvaarivtuktype08";
    public static final String ZRNMVAARIV08             = "zrnmvaariv08";
    public static final String ZRNPTMTTKNGKUTIWAKE108   = "zrnptmttkngkutiwake108";
    public static final String ZRNPTMTTKNGKUTIWAKE208   = "zrnptmttkngkutiwake208";
    public static final String ZRNMVAARINENOUTOUYM09    = "zrnmvaarinenoutouym09";
    public static final String ZRNMVAARISISUUUPRITU09   = "zrnmvaarisisuuupritu09";
    public static final String ZRNMVAARITMTTKNZKRITU09  = "zrnmvaaritmttknzkritu09";
    public static final String ZRNMVAARIWTUKTYPEUP09    = "zrnmvaariwtuktypeup09";
    public static final String ZRNMVAARITMTTKNKYKKJMUP09 = "zrnmvaaritmttknkykkjmup09";
    public static final String ZRNMVAARIWUP09           = "zrnmvaariwup09";
    public static final String ZRNMVAARIWYENTUKTYPEUP09 = "zrnmvaariwyentuktypeup09";
    public static final String ZRNMVAARIWUPYENDAKA09    = "zrnmvaariwupyendaka09";
    public static final String ZRNMVAARIWUPYENKIJYUN09  = "zrnmvaariwupyenkijyun09";
    public static final String ZRNMVAARIWUPYENYASU09    = "zrnmvaariwupyenyasu09";
    public static final String ZRNMVAARIWUMUPYENDAKA09  = "zrnmvaariwumupyendaka09";
    public static final String ZRNMVAARIUMUPYENKIJYUN09 = "zrnmvaariumupyenkijyun09";
    public static final String ZRNMVAARIUMUPYENYASU09   = "zrnmvaariumupyenyasu09";
    public static final String ZRNMVAARIWTUKTYPESAME09  = "zrnmvaariwtuktypesame09";
    public static final String ZRNMVAARITMTTKNKYKKJMSAME09 = "zrnmvaaritmttknkykkjmsame09";
    public static final String ZRNMVAARIWSAME09         = "zrnmvaariwsame09";
    public static final String ZRNMVAARIWYENTUKTYPESAME09 = "zrnmvaariwyentuktypesame09";
    public static final String ZRNMVAARIWSAMEYENDAKA09  = "zrnmvaariwsameyendaka09";
    public static final String ZRNMVAARIWSAMEYENKIJYUN09 = "zrnmvaariwsameyenkijyun09";
    public static final String ZRNMVAARIWSAMEYENYASU09  = "zrnmvaariwsameyenyasu09";
    public static final String ZRNMVAARIUMSAMEYENDAKA09 = "zrnmvaariumsameyendaka09";
    public static final String ZRNMVAARIUMSAMEYENKIJYUN09 = "zrnmvaariumsameyenkijyun09";
    public static final String ZRNMVAARIUMSAMEYENYASU09 = "zrnmvaariumsameyenyasu09";
    public static final String ZRNMVAARIWTUKTYPEDOWN09  = "zrnmvaariwtuktypedown09";
    public static final String ZRNMVAARITMTTKNKYKKJMDOWN09 = "zrnmvaaritmttknkykkjmdown09";
    public static final String ZRNMVAARIWDOWN09         = "zrnmvaariwdown09";
    public static final String ZRNMVAARIWYENTUKTYPEDOWN09 = "zrnmvaariwyentuktypedown09";
    public static final String ZRNMVAARIWDOWNYENDAKA09  = "zrnmvaariwdownyendaka09";
    public static final String ZRNMVAARIWDOWNYENKIJYUN09 = "zrnmvaariwdownyenkijyun09";
    public static final String ZRNMVAARIWDOWNYENYASU09  = "zrnmvaariwdownyenyasu09";
    public static final String ZRNMVAARIUMDOWNYENDAKA09 = "zrnmvaariumdownyendaka09";
    public static final String ZRNMVAARIUMDOWNYENKIJYUN09 = "zrnmvaariumdownyenkijyun09";
    public static final String ZRNMVAARIUMDOWNYENYASU09 = "zrnmvaariumdownyenyasu09";
    public static final String ZRNMVAARIVTUKTYPE09      = "zrnmvaarivtuktype09";
    public static final String ZRNMVAARIV09             = "zrnmvaariv09";
    public static final String ZRNPTMTTKNGKUTIWAKE109   = "zrnptmttkngkutiwake109";
    public static final String ZRNPTMTTKNGKUTIWAKE209   = "zrnptmttkngkutiwake209";
    public static final String ZRNMVAARINENOUTOUYM10    = "zrnmvaarinenoutouym10";
    public static final String ZRNMVAARISISUUUPRITU10   = "zrnmvaarisisuuupritu10";
    public static final String ZRNMVAARITMTTKNZKRITU10  = "zrnmvaaritmttknzkritu10";
    public static final String ZRNMVAARIWTUKTYPEUP10    = "zrnmvaariwtuktypeup10";
    public static final String ZRNMVAARITMTTKNKYKKJMUP10 = "zrnmvaaritmttknkykkjmup10";
    public static final String ZRNMVAARIWUP10           = "zrnmvaariwup10";
    public static final String ZRNMVAARIWYENTUKTYPEUP10 = "zrnmvaariwyentuktypeup10";
    public static final String ZRNMVAARIWUPYENDAKA10    = "zrnmvaariwupyendaka10";
    public static final String ZRNMVAARIWUPYENKIJYUN10  = "zrnmvaariwupyenkijyun10";
    public static final String ZRNMVAARIWUPYENYASU10    = "zrnmvaariwupyenyasu10";
    public static final String ZRNMVAARIWUMUPYENDAKA10  = "zrnmvaariwumupyendaka10";
    public static final String ZRNMVAARIUMUPYENKIJYUN10 = "zrnmvaariumupyenkijyun10";
    public static final String ZRNMVAARIUMUPYENYASU10   = "zrnmvaariumupyenyasu10";
    public static final String ZRNMVAARIWTUKTYPESAME10  = "zrnmvaariwtuktypesame10";
    public static final String ZRNMVAARITMTTKNKYKKJMSAME10 = "zrnmvaaritmttknkykkjmsame10";
    public static final String ZRNMVAARIWSAME10         = "zrnmvaariwsame10";
    public static final String ZRNMVAARIWYENTUKTYPESAME10 = "zrnmvaariwyentuktypesame10";
    public static final String ZRNMVAARIWSAMEYENDAKA10  = "zrnmvaariwsameyendaka10";
    public static final String ZRNMVAARIWSAMEYENKIJYUN10 = "zrnmvaariwsameyenkijyun10";
    public static final String ZRNMVAARIWSAMEYENYASU10  = "zrnmvaariwsameyenyasu10";
    public static final String ZRNMVAARIUMSAMEYENDAKA10 = "zrnmvaariumsameyendaka10";
    public static final String ZRNMVAARIUMSAMEYENKIJYUN10 = "zrnmvaariumsameyenkijyun10";
    public static final String ZRNMVAARIUMSAMEYENYASU10 = "zrnmvaariumsameyenyasu10";
    public static final String ZRNMVAARIWTUKTYPEDOWN10  = "zrnmvaariwtuktypedown10";
    public static final String ZRNMVAARITMTTKNKYKKJMDOWN10 = "zrnmvaaritmttknkykkjmdown10";
    public static final String ZRNMVAARIWDOWN10         = "zrnmvaariwdown10";
    public static final String ZRNMVAARIWYENTUKTYPEDOWN10 = "zrnmvaariwyentuktypedown10";
    public static final String ZRNMVAARIWDOWNYENDAKA10  = "zrnmvaariwdownyendaka10";
    public static final String ZRNMVAARIWDOWNYENKIJYUN10 = "zrnmvaariwdownyenkijyun10";
    public static final String ZRNMVAARIWDOWNYENYASU10  = "zrnmvaariwdownyenyasu10";
    public static final String ZRNMVAARIUMDOWNYENDAKA10 = "zrnmvaariumdownyendaka10";
    public static final String ZRNMVAARIUMDOWNYENKIJYUN10 = "zrnmvaariumdownyenkijyun10";
    public static final String ZRNMVAARIUMDOWNYENYASU10 = "zrnmvaariumdownyenyasu10";
    public static final String ZRNMVAARIVTUKTYPE10      = "zrnmvaarivtuktype10";
    public static final String ZRNMVAARIV10             = "zrnmvaariv10";
    public static final String ZRNPTMTTKNGKUTIWAKE110   = "zrnptmttkngkutiwake110";
    public static final String ZRNPTMTTKNGKUTIWAKE210   = "zrnptmttkngkutiwake210";
    public static final String ZRNMVAARINENOUTOUYM11    = "zrnmvaarinenoutouym11";
    public static final String ZRNMVAARIWTUKTYPEUP11    = "zrnmvaariwtuktypeup11";
    public static final String ZRNMVAARIWUP11           = "zrnmvaariwup11";
    public static final String ZRNMVAARIWYENTUKTYPEUP11 = "zrnmvaariwyentuktypeup11";
    public static final String ZRNMVAARIWUPYENDAKA11    = "zrnmvaariwupyendaka11";
    public static final String ZRNMVAARIWUPYENKIJYUN11  = "zrnmvaariwupyenkijyun11";
    public static final String ZRNMVAARIWUPYENYASU11    = "zrnmvaariwupyenyasu11";
    public static final String ZRNMVAARIWUMUPYENDAKA11  = "zrnmvaariwumupyendaka11";
    public static final String ZRNMVAARIUMUPYENKIJYUN11 = "zrnmvaariumupyenkijyun11";
    public static final String ZRNMVAARIUMUPYENYASU11   = "zrnmvaariumupyenyasu11";
    public static final String ZRNMVAARIWTUKTYPESAME11  = "zrnmvaariwtuktypesame11";
    public static final String ZRNMVAARIWSAME11         = "zrnmvaariwsame11";
    public static final String ZRNMVAARIWYENTUKTYPESAME11 = "zrnmvaariwyentuktypesame11";
    public static final String ZRNMVAARIWSAMEYENDAKA11  = "zrnmvaariwsameyendaka11";
    public static final String ZRNMVAARIWSAMEYENKIJYUN11 = "zrnmvaariwsameyenkijyun11";
    public static final String ZRNMVAARIWSAMEYENYASU11  = "zrnmvaariwsameyenyasu11";
    public static final String ZRNMVAARIUMSAMEYENDAKA11 = "zrnmvaariumsameyendaka11";
    public static final String ZRNMVAARIUMSAMEYENKIJYUN11 = "zrnmvaariumsameyenkijyun11";
    public static final String ZRNMVAARIUMSAMEYENYASU11 = "zrnmvaariumsameyenyasu11";
    public static final String ZRNMVAARIWTUKTYPEDOWN11  = "zrnmvaariwtuktypedown11";
    public static final String ZRNMVAARIWDOWN11         = "zrnmvaariwdown11";
    public static final String ZRNMVAARIWYENTUKTYPEDOWN11 = "zrnmvaariwyentuktypedown11";
    public static final String ZRNMVAARIWDOWNYENDAKA11  = "zrnmvaariwdownyendaka11";
    public static final String ZRNMVAARIWDOWNYENKIJYUN11 = "zrnmvaariwdownyenkijyun11";
    public static final String ZRNMVAARIWDOWNYENYASU11  = "zrnmvaariwdownyenyasu11";
    public static final String ZRNMVAARIUMDOWNYENDAKA11 = "zrnmvaariumdownyendaka11";
    public static final String ZRNMVAARIUMDOWNYENKIJYUN11 = "zrnmvaariumdownyenkijyun11";
    public static final String ZRNMVAARIUMDOWNYENYASU11 = "zrnmvaariumdownyenyasu11";
    public static final String ZRNMVAARIVTUKTYPE11      = "zrnmvaarivtuktype11";
    public static final String ZRNMVAARIV11             = "zrnmvaariv11";
    public static final String ZRNMVAARINENOUTOUYM12    = "zrnmvaarinenoutouym12";
    public static final String ZRNMVAARIWTUKTYPEUP12    = "zrnmvaariwtuktypeup12";
    public static final String ZRNMVAARIWUP12           = "zrnmvaariwup12";
    public static final String ZRNMVAARIWYENTUKTYPEUP12 = "zrnmvaariwyentuktypeup12";
    public static final String ZRNMVAARIWUPYENDAKA12    = "zrnmvaariwupyendaka12";
    public static final String ZRNMVAARIWUPYENKIJYUN12  = "zrnmvaariwupyenkijyun12";
    public static final String ZRNMVAARIWUPYENYASU12    = "zrnmvaariwupyenyasu12";
    public static final String ZRNMVAARIWUMUPYENDAKA12  = "zrnmvaariwumupyendaka12";
    public static final String ZRNMVAARIUMUPYENKIJYUN12 = "zrnmvaariumupyenkijyun12";
    public static final String ZRNMVAARIUMUPYENYASU12   = "zrnmvaariumupyenyasu12";
    public static final String ZRNMVAARIWTUKTYPESAME12  = "zrnmvaariwtuktypesame12";
    public static final String ZRNMVAARIWSAME12         = "zrnmvaariwsame12";
    public static final String ZRNMVAARIWYENTUKTYPESAME12 = "zrnmvaariwyentuktypesame12";
    public static final String ZRNMVAARIWSAMEYENDAKA12  = "zrnmvaariwsameyendaka12";
    public static final String ZRNMVAARIWSAMEYENKIJYUN12 = "zrnmvaariwsameyenkijyun12";
    public static final String ZRNMVAARIWSAMEYENYASU12  = "zrnmvaariwsameyenyasu12";
    public static final String ZRNMVAARIUMSAMEYENDAKA12 = "zrnmvaariumsameyendaka12";
    public static final String ZRNMVAARIUMSAMEYENKIJYUN12 = "zrnmvaariumsameyenkijyun12";
    public static final String ZRNMVAARIUMSAMEYENYASU12 = "zrnmvaariumsameyenyasu12";
    public static final String ZRNMVAARIWTUKTYPEDOWN12  = "zrnmvaariwtuktypedown12";
    public static final String ZRNMVAARIWDOWN12         = "zrnmvaariwdown12";
    public static final String ZRNMVAARIWYENTUKTYPEDOWN12 = "zrnmvaariwyentuktypedown12";
    public static final String ZRNMVAARIWDOWNYENDAKA12  = "zrnmvaariwdownyendaka12";
    public static final String ZRNMVAARIWDOWNYENKIJYUN12 = "zrnmvaariwdownyenkijyun12";
    public static final String ZRNMVAARIWDOWNYENYASU12  = "zrnmvaariwdownyenyasu12";
    public static final String ZRNMVAARIUMDOWNYENDAKA12 = "zrnmvaariumdownyendaka12";
    public static final String ZRNMVAARIUMDOWNYENKIJYUN12 = "zrnmvaariumdownyenkijyun12";
    public static final String ZRNMVAARIUMDOWNYENYASU12 = "zrnmvaariumdownyenyasu12";
    public static final String ZRNMVAARIVTUKTYPE12      = "zrnmvaarivtuktype12";
    public static final String ZRNMVAARIV12             = "zrnmvaariv12";
    public static final String ZRNMVAARINENOUTOUYM13    = "zrnmvaarinenoutouym13";
    public static final String ZRNMVAARIWTUKTYPEUP13    = "zrnmvaariwtuktypeup13";
    public static final String ZRNMVAARIWUP13           = "zrnmvaariwup13";
    public static final String ZRNMVAARIWYENTUKTYPEUP13 = "zrnmvaariwyentuktypeup13";
    public static final String ZRNMVAARIWUPYENDAKA13    = "zrnmvaariwupyendaka13";
    public static final String ZRNMVAARIWUPYENKIJYUN13  = "zrnmvaariwupyenkijyun13";
    public static final String ZRNMVAARIWUPYENYASU13    = "zrnmvaariwupyenyasu13";
    public static final String ZRNMVAARIWUMUPYENDAKA13  = "zrnmvaariwumupyendaka13";
    public static final String ZRNMVAARIUMUPYENKIJYUN13 = "zrnmvaariumupyenkijyun13";
    public static final String ZRNMVAARIUMUPYENYASU13   = "zrnmvaariumupyenyasu13";
    public static final String ZRNMVAARIWTUKTYPESAME13  = "zrnmvaariwtuktypesame13";
    public static final String ZRNMVAARIWSAME13         = "zrnmvaariwsame13";
    public static final String ZRNMVAARIWYENTUKTYPESAME13 = "zrnmvaariwyentuktypesame13";
    public static final String ZRNMVAARIWSAMEYENDAKA13  = "zrnmvaariwsameyendaka13";
    public static final String ZRNMVAARIWSAMEYENKIJYUN13 = "zrnmvaariwsameyenkijyun13";
    public static final String ZRNMVAARIWSAMEYENYASU13  = "zrnmvaariwsameyenyasu13";
    public static final String ZRNMVAARIUMSAMEYENDAKA13 = "zrnmvaariumsameyendaka13";
    public static final String ZRNMVAARIUMSAMEYENKIJYUN13 = "zrnmvaariumsameyenkijyun13";
    public static final String ZRNMVAARIUMSAMEYENYASU13 = "zrnmvaariumsameyenyasu13";
    public static final String ZRNMVAARIWTUKTYPEDOWN13  = "zrnmvaariwtuktypedown13";
    public static final String ZRNMVAARIWDOWN13         = "zrnmvaariwdown13";
    public static final String ZRNMVAARIWYENTUKTYPEDOWN13 = "zrnmvaariwyentuktypedown13";
    public static final String ZRNMVAARIWDOWNYENDAKA13  = "zrnmvaariwdownyendaka13";
    public static final String ZRNMVAARIWDOWNYENKIJYUN13 = "zrnmvaariwdownyenkijyun13";
    public static final String ZRNMVAARIWDOWNYENYASU13  = "zrnmvaariwdownyenyasu13";
    public static final String ZRNMVAARIUMDOWNYENDAKA13 = "zrnmvaariumdownyendaka13";
    public static final String ZRNMVAARIUMDOWNYENKIJYUN13 = "zrnmvaariumdownyenkijyun13";
    public static final String ZRNMVAARIUMDOWNYENYASU13 = "zrnmvaariumdownyenyasu13";
    public static final String ZRNMVAARIVTUKTYPE13      = "zrnmvaarivtuktype13";
    public static final String ZRNMVAARIV13             = "zrnmvaariv13";
    public static final String ZRNMVAARINENOUTOUYM14    = "zrnmvaarinenoutouym14";
    public static final String ZRNMVAARIWTUKTYPEUP14    = "zrnmvaariwtuktypeup14";
    public static final String ZRNMVAARIWUP14           = "zrnmvaariwup14";
    public static final String ZRNMVAARIWYENTUKTYPEUP14 = "zrnmvaariwyentuktypeup14";
    public static final String ZRNMVAARIWUPYENDAKA14    = "zrnmvaariwupyendaka14";
    public static final String ZRNMVAARIWUPYENKIJYUN14  = "zrnmvaariwupyenkijyun14";
    public static final String ZRNMVAARIWUPYENYASU14    = "zrnmvaariwupyenyasu14";
    public static final String ZRNMVAARIWUMUPYENDAKA14  = "zrnmvaariwumupyendaka14";
    public static final String ZRNMVAARIUMUPYENKIJYUN14 = "zrnmvaariumupyenkijyun14";
    public static final String ZRNMVAARIUMUPYENYASU14   = "zrnmvaariumupyenyasu14";
    public static final String ZRNMVAARIWTUKTYPESAME14  = "zrnmvaariwtuktypesame14";
    public static final String ZRNMVAARIWSAME14         = "zrnmvaariwsame14";
    public static final String ZRNMVAARIWYENTUKTYPESAME14 = "zrnmvaariwyentuktypesame14";
    public static final String ZRNMVAARIWSAMEYENDAKA14  = "zrnmvaariwsameyendaka14";
    public static final String ZRNMVAARIWSAMEYENKIJYUN14 = "zrnmvaariwsameyenkijyun14";
    public static final String ZRNMVAARIWSAMEYENYASU14  = "zrnmvaariwsameyenyasu14";
    public static final String ZRNMVAARIUMSAMEYENDAKA14 = "zrnmvaariumsameyendaka14";
    public static final String ZRNMVAARIUMSAMEYENKIJYUN14 = "zrnmvaariumsameyenkijyun14";
    public static final String ZRNMVAARIUMSAMEYENYASU14 = "zrnmvaariumsameyenyasu14";
    public static final String ZRNMVAARIWTUKTYPEDOWN14  = "zrnmvaariwtuktypedown14";
    public static final String ZRNMVAARIWDOWN14         = "zrnmvaariwdown14";
    public static final String ZRNMVAARIWYENTUKTYPEDOWN14 = "zrnmvaariwyentuktypedown14";
    public static final String ZRNMVAARIWDOWNYENDAKA14  = "zrnmvaariwdownyendaka14";
    public static final String ZRNMVAARIWDOWNYENKIJYUN14 = "zrnmvaariwdownyenkijyun14";
    public static final String ZRNMVAARIWDOWNYENYASU14  = "zrnmvaariwdownyenyasu14";
    public static final String ZRNMVAARIUMDOWNYENDAKA14 = "zrnmvaariumdownyendaka14";
    public static final String ZRNMVAARIUMDOWNYENKIJYUN14 = "zrnmvaariumdownyenkijyun14";
    public static final String ZRNMVAARIUMDOWNYENYASU14 = "zrnmvaariumdownyenyasu14";
    public static final String ZRNMVAARIVTUKTYPE14      = "zrnmvaarivtuktype14";
    public static final String ZRNMVAARIV14             = "zrnmvaariv14";
    public static final String ZRNMVAARINENOUTOUYM15    = "zrnmvaarinenoutouym15";
    public static final String ZRNMVAARIWTUKTYPEUP15    = "zrnmvaariwtuktypeup15";
    public static final String ZRNMVAARIWUP15           = "zrnmvaariwup15";
    public static final String ZRNMVAARIWYENTUKTYPEUP15 = "zrnmvaariwyentuktypeup15";
    public static final String ZRNMVAARIWUPYENDAKA15    = "zrnmvaariwupyendaka15";
    public static final String ZRNMVAARIWUPYENKIJYUN15  = "zrnmvaariwupyenkijyun15";
    public static final String ZRNMVAARIWUPYENYASU15    = "zrnmvaariwupyenyasu15";
    public static final String ZRNMVAARIWUMUPYENDAKA15  = "zrnmvaariwumupyendaka15";
    public static final String ZRNMVAARIUMUPYENKIJYUN15 = "zrnmvaariumupyenkijyun15";
    public static final String ZRNMVAARIUMUPYENYASU15   = "zrnmvaariumupyenyasu15";
    public static final String ZRNMVAARIWTUKTYPESAME15  = "zrnmvaariwtuktypesame15";
    public static final String ZRNMVAARIWSAME15         = "zrnmvaariwsame15";
    public static final String ZRNMVAARIWYENTUKTYPESAME15 = "zrnmvaariwyentuktypesame15";
    public static final String ZRNMVAARIWSAMEYENDAKA15  = "zrnmvaariwsameyendaka15";
    public static final String ZRNMVAARIWSAMEYENKIJYUN15 = "zrnmvaariwsameyenkijyun15";
    public static final String ZRNMVAARIWSAMEYENYASU15  = "zrnmvaariwsameyenyasu15";
    public static final String ZRNMVAARIUMSAMEYENDAKA15 = "zrnmvaariumsameyendaka15";
    public static final String ZRNMVAARIUMSAMEYENKIJYUN15 = "zrnmvaariumsameyenkijyun15";
    public static final String ZRNMVAARIUMSAMEYENYASU15 = "zrnmvaariumsameyenyasu15";
    public static final String ZRNMVAARIWTUKTYPEDOWN15  = "zrnmvaariwtuktypedown15";
    public static final String ZRNMVAARIWDOWN15         = "zrnmvaariwdown15";
    public static final String ZRNMVAARIWYENTUKTYPEDOWN15 = "zrnmvaariwyentuktypedown15";
    public static final String ZRNMVAARIWDOWNYENDAKA15  = "zrnmvaariwdownyendaka15";
    public static final String ZRNMVAARIWDOWNYENKIJYUN15 = "zrnmvaariwdownyenkijyun15";
    public static final String ZRNMVAARIWDOWNYENYASU15  = "zrnmvaariwdownyenyasu15";
    public static final String ZRNMVAARIUMDOWNYENDAKA15 = "zrnmvaariumdownyendaka15";
    public static final String ZRNMVAARIUMDOWNYENKIJYUN15 = "zrnmvaariumdownyenkijyun15";
    public static final String ZRNMVAARIUMDOWNYENYASU15 = "zrnmvaariumdownyenyasu15";
    public static final String ZRNMVAARIVTUKTYPE15      = "zrnmvaarivtuktype15";
    public static final String ZRNMVAARIV15             = "zrnmvaariv15";
    public static final String ZRNMVANONEKAISIINNUMUKBN01 = "zrnmvanonekaisiinnumukbn01";
    public static final String ZRNMVANONENENOUTOUYM01   = "zrnmvanonenenoutouym01";
    public static final String ZRNMVANONEWTUKTYPE01     = "zrnmvanonewtuktype01";
    public static final String ZRNMVANONEW01            = "zrnmvanonew01";
    public static final String ZRNMVANONEWYENTUKTYPE01  = "zrnmvanonewyentuktype01";
    public static final String ZRNMVANONEWYENDAKA01     = "zrnmvanonewyendaka01";
    public static final String ZRNMVANONEWYENKIJYUN01   = "zrnmvanonewyenkijyun01";
    public static final String ZRNMVANONEWYENYASU01     = "zrnmvanonewyenyasu01";
    public static final String ZRNMVANONEUMYENDAKA01    = "zrnmvanoneumyendaka01";
    public static final String ZRNMVANONEUMYENKIJYUN01  = "zrnmvanoneumyenkijyun01";
    public static final String ZRNMVANONEUMYENYASU01    = "zrnmvanoneumyenyasu01";
    public static final String ZRNMVANONEVTUKTYPE01     = "zrnmvanonevtuktype01";
    public static final String ZRNMVANONEV01            = "zrnmvanonev01";
    public static final String ZRNMVANONEKAISIINNUMUKBN02 = "zrnmvanonekaisiinnumukbn02";
    public static final String ZRNMVANONENENOUTOUYM02   = "zrnmvanonenenoutouym02";
    public static final String ZRNMVANONEWTUKTYPE02     = "zrnmvanonewtuktype02";
    public static final String ZRNMVANONEW02            = "zrnmvanonew02";
    public static final String ZRNMVANONEWYENTUKTYPE02  = "zrnmvanonewyentuktype02";
    public static final String ZRNMVANONEWYENDAKA02     = "zrnmvanonewyendaka02";
    public static final String ZRNMVANONEWYENKIJYUN02   = "zrnmvanonewyenkijyun02";
    public static final String ZRNMVANONEWYENYASU02     = "zrnmvanonewyenyasu02";
    public static final String ZRNMVANONEUMYENDAKA02    = "zrnmvanoneumyendaka02";
    public static final String ZRNMVANONEUMYENKIJYUN02  = "zrnmvanoneumyenkijyun02";
    public static final String ZRNMVANONEUMYENYASU02    = "zrnmvanoneumyenyasu02";
    public static final String ZRNMVANONEVTUKTYPE02     = "zrnmvanonevtuktype02";
    public static final String ZRNMVANONEV02            = "zrnmvanonev02";
    public static final String ZRNMVANONEKAISIINNUMUKBN03 = "zrnmvanonekaisiinnumukbn03";
    public static final String ZRNMVANONENENOUTOUYM03   = "zrnmvanonenenoutouym03";
    public static final String ZRNMVANONEWTUKTYPE03     = "zrnmvanonewtuktype03";
    public static final String ZRNMVANONEW03            = "zrnmvanonew03";
    public static final String ZRNMVANONEWYENTUKTYPE03  = "zrnmvanonewyentuktype03";
    public static final String ZRNMVANONEWYENDAKA03     = "zrnmvanonewyendaka03";
    public static final String ZRNMVANONEWYENKIJYUN03   = "zrnmvanonewyenkijyun03";
    public static final String ZRNMVANONEWYENYASU03     = "zrnmvanonewyenyasu03";
    public static final String ZRNMVANONEUMYENDAKA03    = "zrnmvanoneumyendaka03";
    public static final String ZRNMVANONEUMYENKIJYUN03  = "zrnmvanoneumyenkijyun03";
    public static final String ZRNMVANONEUMYENYASU03    = "zrnmvanoneumyenyasu03";
    public static final String ZRNMVANONEVTUKTYPE03     = "zrnmvanonevtuktype03";
    public static final String ZRNMVANONEV03            = "zrnmvanonev03";
    public static final String ZRNMVANONEKAISIINNUMUKBN04 = "zrnmvanonekaisiinnumukbn04";
    public static final String ZRNMVANONENENOUTOUYM04   = "zrnmvanonenenoutouym04";
    public static final String ZRNMVANONEWTUKTYPE04     = "zrnmvanonewtuktype04";
    public static final String ZRNMVANONEW04            = "zrnmvanonew04";
    public static final String ZRNMVANONEWYENTUKTYPE04  = "zrnmvanonewyentuktype04";
    public static final String ZRNMVANONEWYENDAKA04     = "zrnmvanonewyendaka04";
    public static final String ZRNMVANONEWYENKIJYUN04   = "zrnmvanonewyenkijyun04";
    public static final String ZRNMVANONEWYENYASU04     = "zrnmvanonewyenyasu04";
    public static final String ZRNMVANONEUMYENDAKA04    = "zrnmvanoneumyendaka04";
    public static final String ZRNMVANONEUMYENKIJYUN04  = "zrnmvanoneumyenkijyun04";
    public static final String ZRNMVANONEUMYENYASU04    = "zrnmvanoneumyenyasu04";
    public static final String ZRNMVANONEVTUKTYPE04     = "zrnmvanonevtuktype04";
    public static final String ZRNMVANONEV04            = "zrnmvanonev04";
    public static final String ZRNMVANONEKAISIINNUMUKBN05 = "zrnmvanonekaisiinnumukbn05";
    public static final String ZRNMVANONENENOUTOUYM05   = "zrnmvanonenenoutouym05";
    public static final String ZRNMVANONEWTUKTYPE05     = "zrnmvanonewtuktype05";
    public static final String ZRNMVANONEW05            = "zrnmvanonew05";
    public static final String ZRNMVANONEWYENTUKTYPE05  = "zrnmvanonewyentuktype05";
    public static final String ZRNMVANONEWYENDAKA05     = "zrnmvanonewyendaka05";
    public static final String ZRNMVANONEWYENKIJYUN05   = "zrnmvanonewyenkijyun05";
    public static final String ZRNMVANONEWYENYASU05     = "zrnmvanonewyenyasu05";
    public static final String ZRNMVANONEUMYENDAKA05    = "zrnmvanoneumyendaka05";
    public static final String ZRNMVANONEUMYENKIJYUN05  = "zrnmvanoneumyenkijyun05";
    public static final String ZRNMVANONEUMYENYASU05    = "zrnmvanoneumyenyasu05";
    public static final String ZRNMVANONEVTUKTYPE05     = "zrnmvanonevtuktype05";
    public static final String ZRNMVANONEV05            = "zrnmvanonev05";
    public static final String ZRNMVANONEKAISIINNUMUKBN06 = "zrnmvanonekaisiinnumukbn06";
    public static final String ZRNMVANONENENOUTOUYM06   = "zrnmvanonenenoutouym06";
    public static final String ZRNMVANONEWTUKTYPE06     = "zrnmvanonewtuktype06";
    public static final String ZRNMVANONEW06            = "zrnmvanonew06";
    public static final String ZRNMVANONEWYENTUKTYPE06  = "zrnmvanonewyentuktype06";
    public static final String ZRNMVANONEWYENDAKA06     = "zrnmvanonewyendaka06";
    public static final String ZRNMVANONEWYENKIJYUN06   = "zrnmvanonewyenkijyun06";
    public static final String ZRNMVANONEWYENYASU06     = "zrnmvanonewyenyasu06";
    public static final String ZRNMVANONEUMYENDAKA06    = "zrnmvanoneumyendaka06";
    public static final String ZRNMVANONEUMYENKIJYUN06  = "zrnmvanoneumyenkijyun06";
    public static final String ZRNMVANONEUMYENYASU06    = "zrnmvanoneumyenyasu06";
    public static final String ZRNMVANONEVTUKTYPE06     = "zrnmvanonevtuktype06";
    public static final String ZRNMVANONEV06            = "zrnmvanonev06";
    public static final String ZRNMVANONEKAISIINNUMUKBN07 = "zrnmvanonekaisiinnumukbn07";
    public static final String ZRNMVANONENENOUTOUYM07   = "zrnmvanonenenoutouym07";
    public static final String ZRNMVANONEWTUKTYPE07     = "zrnmvanonewtuktype07";
    public static final String ZRNMVANONEW07            = "zrnmvanonew07";
    public static final String ZRNMVANONEWYENTUKTYPE07  = "zrnmvanonewyentuktype07";
    public static final String ZRNMVANONEWYENDAKA07     = "zrnmvanonewyendaka07";
    public static final String ZRNMVANONEWYENKIJYUN07   = "zrnmvanonewyenkijyun07";
    public static final String ZRNMVANONEWYENYASU07     = "zrnmvanonewyenyasu07";
    public static final String ZRNMVANONEUMYENDAKA07    = "zrnmvanoneumyendaka07";
    public static final String ZRNMVANONEUMYENKIJYUN07  = "zrnmvanoneumyenkijyun07";
    public static final String ZRNMVANONEUMYENYASU07    = "zrnmvanoneumyenyasu07";
    public static final String ZRNMVANONEVTUKTYPE07     = "zrnmvanonevtuktype07";
    public static final String ZRNMVANONEV07            = "zrnmvanonev07";
    public static final String ZRNMVANONEKAISIINNUMUKBN08 = "zrnmvanonekaisiinnumukbn08";
    public static final String ZRNMVANONENENOUTOUYM08   = "zrnmvanonenenoutouym08";
    public static final String ZRNMVANONEWTUKTYPE08     = "zrnmvanonewtuktype08";
    public static final String ZRNMVANONEW08            = "zrnmvanonew08";
    public static final String ZRNMVANONEWYENTUKTYPE08  = "zrnmvanonewyentuktype08";
    public static final String ZRNMVANONEWYENDAKA08     = "zrnmvanonewyendaka08";
    public static final String ZRNMVANONEWYENKIJYUN08   = "zrnmvanonewyenkijyun08";
    public static final String ZRNMVANONEWYENYASU08     = "zrnmvanonewyenyasu08";
    public static final String ZRNMVANONEUMYENDAKA08    = "zrnmvanoneumyendaka08";
    public static final String ZRNMVANONEUMYENKIJYUN08  = "zrnmvanoneumyenkijyun08";
    public static final String ZRNMVANONEUMYENYASU08    = "zrnmvanoneumyenyasu08";
    public static final String ZRNMVANONEVTUKTYPE08     = "zrnmvanonevtuktype08";
    public static final String ZRNMVANONEV08            = "zrnmvanonev08";
    public static final String ZRNMVANONEKAISIINNUMUKBN09 = "zrnmvanonekaisiinnumukbn09";
    public static final String ZRNMVANONENENOUTOUYM09   = "zrnmvanonenenoutouym09";
    public static final String ZRNMVANONEWTUKTYPE09     = "zrnmvanonewtuktype09";
    public static final String ZRNMVANONEW09            = "zrnmvanonew09";
    public static final String ZRNMVANONEWYENTUKTYPE09  = "zrnmvanonewyentuktype09";
    public static final String ZRNMVANONEWYENDAKA09     = "zrnmvanonewyendaka09";
    public static final String ZRNMVANONEWYENKIJYUN09   = "zrnmvanonewyenkijyun09";
    public static final String ZRNMVANONEWYENYASU09     = "zrnmvanonewyenyasu09";
    public static final String ZRNMVANONEUMYENDAKA09    = "zrnmvanoneumyendaka09";
    public static final String ZRNMVANONEUMYENKIJYUN09  = "zrnmvanoneumyenkijyun09";
    public static final String ZRNMVANONEUMYENYASU09    = "zrnmvanoneumyenyasu09";
    public static final String ZRNMVANONEVTUKTYPE09     = "zrnmvanonevtuktype09";
    public static final String ZRNMVANONEV09            = "zrnmvanonev09";
    public static final String ZRNMVANONEKAISIINNUMUKBN10 = "zrnmvanonekaisiinnumukbn10";
    public static final String ZRNMVANONENENOUTOUYM10   = "zrnmvanonenenoutouym10";
    public static final String ZRNMVANONEWTUKTYPE10     = "zrnmvanonewtuktype10";
    public static final String ZRNMVANONEW10            = "zrnmvanonew10";
    public static final String ZRNMVANONEWYENTUKTYPE10  = "zrnmvanonewyentuktype10";
    public static final String ZRNMVANONEWYENDAKA10     = "zrnmvanonewyendaka10";
    public static final String ZRNMVANONEWYENKIJYUN10   = "zrnmvanonewyenkijyun10";
    public static final String ZRNMVANONEWYENYASU10     = "zrnmvanonewyenyasu10";
    public static final String ZRNMVANONEUMYENDAKA10    = "zrnmvanoneumyendaka10";
    public static final String ZRNMVANONEUMYENKIJYUN10  = "zrnmvanoneumyenkijyun10";
    public static final String ZRNMVANONEUMYENYASU10    = "zrnmvanoneumyenyasu10";
    public static final String ZRNMVANONEVTUKTYPE10     = "zrnmvanonevtuktype10";
    public static final String ZRNMVANONEV10            = "zrnmvanonev10";
    public static final String ZRNMVANONEKAISIINNUMUKBN11 = "zrnmvanonekaisiinnumukbn11";
    public static final String ZRNMVANONENENOUTOUYM11   = "zrnmvanonenenoutouym11";
    public static final String ZRNMVANONEWTUKTYPE11     = "zrnmvanonewtuktype11";
    public static final String ZRNMVANONEW11            = "zrnmvanonew11";
    public static final String ZRNMVANONEWYENTUKTYPE11  = "zrnmvanonewyentuktype11";
    public static final String ZRNMVANONEWYENDAKA11     = "zrnmvanonewyendaka11";
    public static final String ZRNMVANONEWYENKIJYUN11   = "zrnmvanonewyenkijyun11";
    public static final String ZRNMVANONEWYENYASU11     = "zrnmvanonewyenyasu11";
    public static final String ZRNMVANONEUMYENDAKA11    = "zrnmvanoneumyendaka11";
    public static final String ZRNMVANONEUMYENKIJYUN11  = "zrnmvanoneumyenkijyun11";
    public static final String ZRNMVANONEUMYENYASU11    = "zrnmvanoneumyenyasu11";
    public static final String ZRNMVANONEVTUKTYPE11     = "zrnmvanonevtuktype11";
    public static final String ZRNMVANONEV11            = "zrnmvanonev11";
    public static final String ZRNMVANONEKAISIINNUMUKBN12 = "zrnmvanonekaisiinnumukbn12";
    public static final String ZRNMVANONENENOUTOUYM12   = "zrnmvanonenenoutouym12";
    public static final String ZRNMVANONEWTUKTYPE12     = "zrnmvanonewtuktype12";
    public static final String ZRNMVANONEW12            = "zrnmvanonew12";
    public static final String ZRNMVANONEWYENTUKTYPE12  = "zrnmvanonewyentuktype12";
    public static final String ZRNMVANONEWYENDAKA12     = "zrnmvanonewyendaka12";
    public static final String ZRNMVANONEWYENKIJYUN12   = "zrnmvanonewyenkijyun12";
    public static final String ZRNMVANONEWYENYASU12     = "zrnmvanonewyenyasu12";
    public static final String ZRNMVANONEUMYENDAKA12    = "zrnmvanoneumyendaka12";
    public static final String ZRNMVANONEUMYENKIJYUN12  = "zrnmvanoneumyenkijyun12";
    public static final String ZRNMVANONEUMYENYASU12    = "zrnmvanoneumyenyasu12";
    public static final String ZRNMVANONEVTUKTYPE12     = "zrnmvanonevtuktype12";
    public static final String ZRNMVANONEV12            = "zrnmvanonev12";
    public static final String ZRNMVANONEKAISIINNUMUKBN13 = "zrnmvanonekaisiinnumukbn13";
    public static final String ZRNMVANONENENOUTOUYM13   = "zrnmvanonenenoutouym13";
    public static final String ZRNMVANONEWTUKTYPE13     = "zrnmvanonewtuktype13";
    public static final String ZRNMVANONEW13            = "zrnmvanonew13";
    public static final String ZRNMVANONEWYENTUKTYPE13  = "zrnmvanonewyentuktype13";
    public static final String ZRNMVANONEWYENDAKA13     = "zrnmvanonewyendaka13";
    public static final String ZRNMVANONEWYENKIJYUN13   = "zrnmvanonewyenkijyun13";
    public static final String ZRNMVANONEWYENYASU13     = "zrnmvanonewyenyasu13";
    public static final String ZRNMVANONEUMYENDAKA13    = "zrnmvanoneumyendaka13";
    public static final String ZRNMVANONEUMYENKIJYUN13  = "zrnmvanoneumyenkijyun13";
    public static final String ZRNMVANONEUMYENYASU13    = "zrnmvanoneumyenyasu13";
    public static final String ZRNMVANONEVTUKTYPE13     = "zrnmvanonevtuktype13";
    public static final String ZRNMVANONEV13            = "zrnmvanonev13";
    public static final String ZRNMVANONEKAISIINNUMUKBN14 = "zrnmvanonekaisiinnumukbn14";
    public static final String ZRNMVANONENENOUTOUYM14   = "zrnmvanonenenoutouym14";
    public static final String ZRNMVANONEWTUKTYPE14     = "zrnmvanonewtuktype14";
    public static final String ZRNMVANONEW14            = "zrnmvanonew14";
    public static final String ZRNMVANONEWYENTUKTYPE14  = "zrnmvanonewyentuktype14";
    public static final String ZRNMVANONEWYENDAKA14     = "zrnmvanonewyendaka14";
    public static final String ZRNMVANONEWYENKIJYUN14   = "zrnmvanonewyenkijyun14";
    public static final String ZRNMVANONEWYENYASU14     = "zrnmvanonewyenyasu14";
    public static final String ZRNMVANONEUMYENDAKA14    = "zrnmvanoneumyendaka14";
    public static final String ZRNMVANONEUMYENKIJYUN14  = "zrnmvanoneumyenkijyun14";
    public static final String ZRNMVANONEUMYENYASU14    = "zrnmvanoneumyenyasu14";
    public static final String ZRNMVANONEVTUKTYPE14     = "zrnmvanonevtuktype14";
    public static final String ZRNMVANONEV14            = "zrnmvanonev14";
    public static final String ZRNWMSGCD1               = "zrnwmsgcd1";
    public static final String ZRNWMSGCD2               = "zrnwmsgcd2";
    public static final String ZRNWMSGCD3               = "zrnwmsgcd3";
    public static final String ZRNWMSGCD21              = "zrnwmsgcd21";
    public static final String ZRNWMSGCD22              = "zrnwmsgcd22";
    public static final String ZRNWMSGCD23              = "zrnwmsgcd23";
    public static final String ZRNWMSGCD31              = "zrnwmsgcd31";
    public static final String ZRNWMSGCD32              = "zrnwmsgcd32";
    public static final String ZRNWMSGCD33              = "zrnwmsgcd33";
    public static final String ZRNWMSGCDST1             = "zrnwmsgcdst1";
    public static final String ZRNWTYUUIMSGCD1          = "zrnwtyuuimsgcd1";
    public static final String ZRNWTYUUIMSGCD2          = "zrnwtyuuimsgcd2";
    public static final String ZRNWTYUUIMSGCD3          = "zrnwtyuuimsgcd3";
    public static final String ZRNWTYUUIMSGCD4          = "zrnwtyuuimsgcd4";
    public static final String ZRNWTYUUIMSGCD5          = "zrnwtyuuimsgcd5";
    public static final String ZRNWTYUUIMSGCD6          = "zrnwtyuuimsgcd6";
    public static final String ZRNWTYUUIMSGCD7          = "zrnwtyuuimsgcd7";
    public static final String ZRNWITJBRPTUUKTYPE       = "zrnwitjbrptuuktype";
    public static final String ZRNWITJBRP               = "zrnwitjbrp";
    public static final String ZRNWYENHRIKMGKTUUKTYPE   = "zrnwyenhrikmgktuuktype";
    public static final String ZRNWYENHRIKMGK           = "zrnwyenhrikmgk";
    public static final String ZRNWYENITJBRPTUUKTYPE    = "zrnwyenitjbrptuuktype";
    public static final String ZRNWYENITJBRP            = "zrnwyenitjbrp";
    public static final String ZRNWSJKKKTYOUSEITKYUYM   = "zrnwsjkkktyouseitkyuym";
    public static final String ZRNHRKKKNMNRYYM          = "zrnhrkkknmnryym";
    public static final String ZRNHRKKKNMNRYNEN         = "zrnhrkkknmnrynen";
    public static final String ZRNYOBIV200              = "zrnyobiv200";
    public static final String ZRNYOBIV49               = "zrnyobiv49";

    private final PKZT_SaihakkouSyoukenSuiiRn primaryKey;

    public GenZT_SaihakkouSyoukenSuiiRn() {
        primaryKey = new PKZT_SaihakkouSyoukenSuiiRn();
    }

    public GenZT_SaihakkouSyoukenSuiiRn(
        String pZrnsyono,
        String pZrntyouhyouymd,
        String pZrnsuiihyouptn
    ) {
        primaryKey = new PKZT_SaihakkouSyoukenSuiiRn(
            pZrnsyono,
            pZrntyouhyouymd,
            pZrnsuiihyouptn
        );
    }

    @Transient
    @Override
    public PKZT_SaihakkouSyoukenSuiiRn getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QZT_SaihakkouSyoukenSuiiRn> getMetaClass() {
        return QZT_SaihakkouSyoukenSuiiRn.class;
    }

    @Id
    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNSYONO)
    public String getZrnsyono() {
        return getPrimaryKey().getZrnsyono();
    }

    public void setZrnsyono(String pZrnsyono) {
        getPrimaryKey().setZrnsyono(pZrnsyono);
    }

    @Id
    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNTYOUHYOUYMD)
    public String getZrntyouhyouymd() {
        return getPrimaryKey().getZrntyouhyouymd();
    }

    public void setZrntyouhyouymd(String pZrntyouhyouymd) {
        getPrimaryKey().setZrntyouhyouymd(pZrntyouhyouymd);
    }

    @Id
    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNSUIIHYOUPTN)
    public String getZrnsuiihyouptn() {
        return getPrimaryKey().getZrnsuiihyouptn();
    }

    @Padding(mode = "left", padChar ='0', length =2)
    public void setZrnsuiihyouptn(String pZrnsuiihyouptn) {
        getPrimaryKey().setZrnsuiihyouptn(pZrnsuiihyouptn);
    }

    private String zrnsuiihyousykbn;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNSUIIHYOUSYKBN)
    public String getZrnsuiihyousykbn() {
        return zrnsuiihyousykbn;
    }

    @Padding(mode = "left", padChar ='0', length =2)
    public void setZrnsuiihyousykbn(String pZrnsuiihyousykbn) {
        zrnsuiihyousykbn = pZrnsuiihyousykbn;
    }

    private String zrnsuiihyousyono;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNSUIIHYOUSYONO)
    public String getZrnsuiihyousyono() {
        return zrnsuiihyousyono;
    }

    public void setZrnsuiihyousyono(String pZrnsuiihyousyono) {
        zrnsuiihyousyono = pZrnsuiihyousyono;
    }

    private String zrnsisuuupritu;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNSISUUUPRITU)
    public String getZrnsisuuupritu() {
        return zrnsisuuupritu;
    }

    @DataConvert("toMultiByte")
    public void setZrnsisuuupritu(String pZrnsisuuupritu) {
        zrnsisuuupritu = pZrnsisuuupritu;
    }

    private String zrnsaisyuunndym;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNSAISYUUNNDYM)
    public String getZrnsaisyuunndym() {
        return zrnsaisyuunndym;
    }

    @DataConvert("toMultiByte")
    public void setZrnsaisyuunndym(String pZrnsaisyuunndym) {
        zrnsaisyuunndym = pZrnsaisyuunndym;
    }

    private String zrnsjkkktusirrtup;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNSJKKKTUSIRRTUP)
    public String getZrnsjkkktusirrtup() {
        return zrnsjkkktusirrtup;
    }

    @DataConvert("toMultiByte")
    public void setZrnsjkkktusirrtup(String pZrnsjkkktusirrtup) {
        zrnsjkkktusirrtup = pZrnsjkkktusirrtup;
    }

    private String zrnsjkkktusirrtsame;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNSJKKKTUSIRRTSAME)
    public String getZrnsjkkktusirrtsame() {
        return zrnsjkkktusirrtsame;
    }

    @DataConvert("toMultiByte")
    public void setZrnsjkkktusirrtsame(String pZrnsjkkktusirrtsame) {
        zrnsjkkktusirrtsame = pZrnsjkkktusirrtsame;
    }

    private String zrnsjkkktusirrtdown;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNSJKKKTUSIRRTDOWN)
    public String getZrnsjkkktusirrtdown() {
        return zrnsjkkktusirrtdown;
    }

    @DataConvert("toMultiByte")
    public void setZrnsjkkktusirrtdown(String pZrnsjkkktusirrtdown) {
        zrnsjkkktusirrtdown = pZrnsjkkktusirrtdown;
    }

    private String zrnsjkkktusirrthendouup;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNSJKKKTUSIRRTHENDOUUP)
    public String getZrnsjkkktusirrthendouup() {
        return zrnsjkkktusirrthendouup;
    }

    @DataConvert("toMultiByte")
    public void setZrnsjkkktusirrthendouup(String pZrnsjkkktusirrthendouup) {
        zrnsjkkktusirrthendouup = pZrnsjkkktusirrthendouup;
    }

    private String zrnsjkkktusirrthendoudown;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNSJKKKTUSIRRTHENDOUDOWN)
    public String getZrnsjkkktusirrthendoudown() {
        return zrnsjkkktusirrthendoudown;
    }

    @DataConvert("toMultiByte")
    public void setZrnsjkkktusirrthendoudown(String pZrnsjkkktusirrthendoudown) {
        zrnsjkkktusirrthendoudown = pZrnsjkkktusirrthendoudown;
    }

    private String zrnwkwsrateyendaka;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNWKWSRATEYENDAKA)
    public String getZrnwkwsrateyendaka() {
        return zrnwkwsrateyendaka;
    }

    @Padding(mode = "left", padChar ='0', length =5)
    public void setZrnwkwsrateyendaka(String pZrnwkwsrateyendaka) {
        zrnwkwsrateyendaka = pZrnwkwsrateyendaka;
    }

    private String zrnwkwsrateyenkijyun;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNWKWSRATEYENKIJYUN)
    public String getZrnwkwsrateyenkijyun() {
        return zrnwkwsrateyenkijyun;
    }

    @Padding(mode = "left", padChar ='0', length =5)
    public void setZrnwkwsrateyenkijyun(String pZrnwkwsrateyenkijyun) {
        zrnwkwsrateyenkijyun = pZrnwkwsrateyenkijyun;
    }

    private String zrnwkwsrateyenyasu;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNWKWSRATEYENYASU)
    public String getZrnwkwsrateyenyasu() {
        return zrnwkwsrateyenyasu;
    }

    @Padding(mode = "left", padChar ='0', length =5)
    public void setZrnwkwsrateyenyasu(String pZrnwkwsrateyenyasu) {
        zrnwkwsrateyenyasu = pZrnwkwsrateyenyasu;
    }

    private String zrnsuiihyoumkhyouyenwra;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNSUIIHYOUMKHYOUYENWRA)
    public String getZrnsuiihyoumkhyouyenwra() {
        return zrnsuiihyoumkhyouyenwra;
    }

    @Padding(mode = "left", padChar ='0', length =3)
    public void setZrnsuiihyoumkhyouyenwra(String pZrnsuiihyoumkhyouyenwra) {
        zrnsuiihyoumkhyouyenwra = pZrnsuiihyoumkhyouyenwra;
    }

    private String zrnmvaarinenoutouym01;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARINENOUTOUYM01)
    public String getZrnmvaarinenoutouym01() {
        return zrnmvaarinenoutouym01;
    }

    @DataConvert("toMultiByte")
    public void setZrnmvaarinenoutouym01(String pZrnmvaarinenoutouym01) {
        zrnmvaarinenoutouym01 = pZrnmvaarinenoutouym01;
    }

    private String zrnmvaarisisuuupritu01;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARISISUUUPRITU01)
    public String getZrnmvaarisisuuupritu01() {
        return zrnmvaarisisuuupritu01;
    }

    @DataConvert("toMultiByte")
    public void setZrnmvaarisisuuupritu01(String pZrnmvaarisisuuupritu01) {
        zrnmvaarisisuuupritu01 = pZrnmvaarisisuuupritu01;
    }

    private String zrnmvaaritmttknzkritu01;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARITMTTKNZKRITU01)
    public String getZrnmvaaritmttknzkritu01() {
        return zrnmvaaritmttknzkritu01;
    }

    @DataConvert("toMultiByte")
    public void setZrnmvaaritmttknzkritu01(String pZrnmvaaritmttknzkritu01) {
        zrnmvaaritmttknzkritu01 = pZrnmvaaritmttknzkritu01;
    }

    private String zrnmvaariwtuktypeup01;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARIWTUKTYPEUP01)
    public String getZrnmvaariwtuktypeup01() {
        return zrnmvaariwtuktypeup01;
    }

    public void setZrnmvaariwtuktypeup01(String pZrnmvaariwtuktypeup01) {
        zrnmvaariwtuktypeup01 = pZrnmvaariwtuktypeup01;
    }

    private String zrnmvaaritmttknkykkjmup01;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARITMTTKNKYKKJMUP01)
    public String getZrnmvaaritmttknkykkjmup01() {
        return zrnmvaaritmttknkykkjmup01;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnmvaaritmttknkykkjmup01(String pZrnmvaaritmttknkykkjmup01) {
        zrnmvaaritmttknkykkjmup01 = pZrnmvaaritmttknkykkjmup01;
    }

    private String zrnmvaariwup01;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARIWUP01)
    public String getZrnmvaariwup01() {
        return zrnmvaariwup01;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnmvaariwup01(String pZrnmvaariwup01) {
        zrnmvaariwup01 = pZrnmvaariwup01;
    }

    private String zrnmvaariwyentuktypeup01;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARIWYENTUKTYPEUP01)
    public String getZrnmvaariwyentuktypeup01() {
        return zrnmvaariwyentuktypeup01;
    }

    public void setZrnmvaariwyentuktypeup01(String pZrnmvaariwyentuktypeup01) {
        zrnmvaariwyentuktypeup01 = pZrnmvaariwyentuktypeup01;
    }

    private String zrnmvaariwupyendaka01;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARIWUPYENDAKA01)
    public String getZrnmvaariwupyendaka01() {
        return zrnmvaariwupyendaka01;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnmvaariwupyendaka01(String pZrnmvaariwupyendaka01) {
        zrnmvaariwupyendaka01 = pZrnmvaariwupyendaka01;
    }

    private String zrnmvaariwupyenkijyun01;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARIWUPYENKIJYUN01)
    public String getZrnmvaariwupyenkijyun01() {
        return zrnmvaariwupyenkijyun01;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnmvaariwupyenkijyun01(String pZrnmvaariwupyenkijyun01) {
        zrnmvaariwupyenkijyun01 = pZrnmvaariwupyenkijyun01;
    }

    private String zrnmvaariwupyenyasu01;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARIWUPYENYASU01)
    public String getZrnmvaariwupyenyasu01() {
        return zrnmvaariwupyenyasu01;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnmvaariwupyenyasu01(String pZrnmvaariwupyenyasu01) {
        zrnmvaariwupyenyasu01 = pZrnmvaariwupyenyasu01;
    }

    private String zrnmvaariwumupyendaka01;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARIWUMUPYENDAKA01)
    public String getZrnmvaariwumupyendaka01() {
        return zrnmvaariwumupyendaka01;
    }

    public void setZrnmvaariwumupyendaka01(String pZrnmvaariwumupyendaka01) {
        zrnmvaariwumupyendaka01 = pZrnmvaariwumupyendaka01;
    }

    private String zrnmvaariumupyenkijyun01;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARIUMUPYENKIJYUN01)
    public String getZrnmvaariumupyenkijyun01() {
        return zrnmvaariumupyenkijyun01;
    }

    public void setZrnmvaariumupyenkijyun01(String pZrnmvaariumupyenkijyun01) {
        zrnmvaariumupyenkijyun01 = pZrnmvaariumupyenkijyun01;
    }

    private String zrnmvaariumupyenyasu01;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARIUMUPYENYASU01)
    public String getZrnmvaariumupyenyasu01() {
        return zrnmvaariumupyenyasu01;
    }

    public void setZrnmvaariumupyenyasu01(String pZrnmvaariumupyenyasu01) {
        zrnmvaariumupyenyasu01 = pZrnmvaariumupyenyasu01;
    }

    private String zrnmvaariwtuktypesame01;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARIWTUKTYPESAME01)
    public String getZrnmvaariwtuktypesame01() {
        return zrnmvaariwtuktypesame01;
    }

    public void setZrnmvaariwtuktypesame01(String pZrnmvaariwtuktypesame01) {
        zrnmvaariwtuktypesame01 = pZrnmvaariwtuktypesame01;
    }

    private String zrnmvaaritmttknkykkjmsame01;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARITMTTKNKYKKJMSAME01)
    public String getZrnmvaaritmttknkykkjmsame01() {
        return zrnmvaaritmttknkykkjmsame01;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnmvaaritmttknkykkjmsame01(String pZrnmvaaritmttknkykkjmsame01) {
        zrnmvaaritmttknkykkjmsame01 = pZrnmvaaritmttknkykkjmsame01;
    }

    private String zrnmvaariwsame01;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARIWSAME01)
    public String getZrnmvaariwsame01() {
        return zrnmvaariwsame01;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnmvaariwsame01(String pZrnmvaariwsame01) {
        zrnmvaariwsame01 = pZrnmvaariwsame01;
    }

    private String zrnmvaariwyentuktypesame01;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARIWYENTUKTYPESAME01)
    public String getZrnmvaariwyentuktypesame01() {
        return zrnmvaariwyentuktypesame01;
    }

    public void setZrnmvaariwyentuktypesame01(String pZrnmvaariwyentuktypesame01) {
        zrnmvaariwyentuktypesame01 = pZrnmvaariwyentuktypesame01;
    }

    private String zrnmvaariwsameyendaka01;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARIWSAMEYENDAKA01)
    public String getZrnmvaariwsameyendaka01() {
        return zrnmvaariwsameyendaka01;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnmvaariwsameyendaka01(String pZrnmvaariwsameyendaka01) {
        zrnmvaariwsameyendaka01 = pZrnmvaariwsameyendaka01;
    }

    private String zrnmvaariwsameyenkijyun01;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARIWSAMEYENKIJYUN01)
    public String getZrnmvaariwsameyenkijyun01() {
        return zrnmvaariwsameyenkijyun01;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnmvaariwsameyenkijyun01(String pZrnmvaariwsameyenkijyun01) {
        zrnmvaariwsameyenkijyun01 = pZrnmvaariwsameyenkijyun01;
    }

    private String zrnmvaariwsameyenyasu01;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARIWSAMEYENYASU01)
    public String getZrnmvaariwsameyenyasu01() {
        return zrnmvaariwsameyenyasu01;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnmvaariwsameyenyasu01(String pZrnmvaariwsameyenyasu01) {
        zrnmvaariwsameyenyasu01 = pZrnmvaariwsameyenyasu01;
    }

    private String zrnmvaariumsameyendaka01;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARIUMSAMEYENDAKA01)
    public String getZrnmvaariumsameyendaka01() {
        return zrnmvaariumsameyendaka01;
    }

    public void setZrnmvaariumsameyendaka01(String pZrnmvaariumsameyendaka01) {
        zrnmvaariumsameyendaka01 = pZrnmvaariumsameyendaka01;
    }

    private String zrnmvaariumsameyenkijyun01;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARIUMSAMEYENKIJYUN01)
    public String getZrnmvaariumsameyenkijyun01() {
        return zrnmvaariumsameyenkijyun01;
    }

    public void setZrnmvaariumsameyenkijyun01(String pZrnmvaariumsameyenkijyun01) {
        zrnmvaariumsameyenkijyun01 = pZrnmvaariumsameyenkijyun01;
    }

    private String zrnmvaariumsameyenyasu01;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARIUMSAMEYENYASU01)
    public String getZrnmvaariumsameyenyasu01() {
        return zrnmvaariumsameyenyasu01;
    }

    public void setZrnmvaariumsameyenyasu01(String pZrnmvaariumsameyenyasu01) {
        zrnmvaariumsameyenyasu01 = pZrnmvaariumsameyenyasu01;
    }

    private String zrnmvaariwtuktypedown01;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARIWTUKTYPEDOWN01)
    public String getZrnmvaariwtuktypedown01() {
        return zrnmvaariwtuktypedown01;
    }

    public void setZrnmvaariwtuktypedown01(String pZrnmvaariwtuktypedown01) {
        zrnmvaariwtuktypedown01 = pZrnmvaariwtuktypedown01;
    }

    private String zrnmvaaritmttknkykkjmdown01;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARITMTTKNKYKKJMDOWN01)
    public String getZrnmvaaritmttknkykkjmdown01() {
        return zrnmvaaritmttknkykkjmdown01;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnmvaaritmttknkykkjmdown01(String pZrnmvaaritmttknkykkjmdown01) {
        zrnmvaaritmttknkykkjmdown01 = pZrnmvaaritmttknkykkjmdown01;
    }

    private String zrnmvaariwdown01;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARIWDOWN01)
    public String getZrnmvaariwdown01() {
        return zrnmvaariwdown01;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnmvaariwdown01(String pZrnmvaariwdown01) {
        zrnmvaariwdown01 = pZrnmvaariwdown01;
    }

    private String zrnmvaariwyentuktypedown01;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARIWYENTUKTYPEDOWN01)
    public String getZrnmvaariwyentuktypedown01() {
        return zrnmvaariwyentuktypedown01;
    }

    public void setZrnmvaariwyentuktypedown01(String pZrnmvaariwyentuktypedown01) {
        zrnmvaariwyentuktypedown01 = pZrnmvaariwyentuktypedown01;
    }

    private String zrnmvaariwdownyendaka01;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARIWDOWNYENDAKA01)
    public String getZrnmvaariwdownyendaka01() {
        return zrnmvaariwdownyendaka01;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnmvaariwdownyendaka01(String pZrnmvaariwdownyendaka01) {
        zrnmvaariwdownyendaka01 = pZrnmvaariwdownyendaka01;
    }

    private String zrnmvaariwdownyenkijyun01;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARIWDOWNYENKIJYUN01)
    public String getZrnmvaariwdownyenkijyun01() {
        return zrnmvaariwdownyenkijyun01;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnmvaariwdownyenkijyun01(String pZrnmvaariwdownyenkijyun01) {
        zrnmvaariwdownyenkijyun01 = pZrnmvaariwdownyenkijyun01;
    }

    private String zrnmvaariwdownyenyasu01;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARIWDOWNYENYASU01)
    public String getZrnmvaariwdownyenyasu01() {
        return zrnmvaariwdownyenyasu01;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnmvaariwdownyenyasu01(String pZrnmvaariwdownyenyasu01) {
        zrnmvaariwdownyenyasu01 = pZrnmvaariwdownyenyasu01;
    }

    private String zrnmvaariumdownyendaka01;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARIUMDOWNYENDAKA01)
    public String getZrnmvaariumdownyendaka01() {
        return zrnmvaariumdownyendaka01;
    }

    public void setZrnmvaariumdownyendaka01(String pZrnmvaariumdownyendaka01) {
        zrnmvaariumdownyendaka01 = pZrnmvaariumdownyendaka01;
    }

    private String zrnmvaariumdownyenkijyun01;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARIUMDOWNYENKIJYUN01)
    public String getZrnmvaariumdownyenkijyun01() {
        return zrnmvaariumdownyenkijyun01;
    }

    public void setZrnmvaariumdownyenkijyun01(String pZrnmvaariumdownyenkijyun01) {
        zrnmvaariumdownyenkijyun01 = pZrnmvaariumdownyenkijyun01;
    }

    private String zrnmvaariumdownyenyasu01;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARIUMDOWNYENYASU01)
    public String getZrnmvaariumdownyenyasu01() {
        return zrnmvaariumdownyenyasu01;
    }

    public void setZrnmvaariumdownyenyasu01(String pZrnmvaariumdownyenyasu01) {
        zrnmvaariumdownyenyasu01 = pZrnmvaariumdownyenyasu01;
    }

    private String zrnmvaarivtuktype01;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARIVTUKTYPE01)
    public String getZrnmvaarivtuktype01() {
        return zrnmvaarivtuktype01;
    }

    public void setZrnmvaarivtuktype01(String pZrnmvaarivtuktype01) {
        zrnmvaarivtuktype01 = pZrnmvaarivtuktype01;
    }

    private String zrnmvaariv01;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARIV01)
    public String getZrnmvaariv01() {
        return zrnmvaariv01;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnmvaariv01(String pZrnmvaariv01) {
        zrnmvaariv01 = pZrnmvaariv01;
    }

    private String zrnptmttkngkutiwake101;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNPTMTTKNGKUTIWAKE101)
    public String getZrnptmttkngkutiwake101() {
        return zrnptmttkngkutiwake101;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnptmttkngkutiwake101(String pZrnptmttkngkutiwake101) {
        zrnptmttkngkutiwake101 = pZrnptmttkngkutiwake101;
    }

    private String zrnptmttkngkutiwake201;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNPTMTTKNGKUTIWAKE201)
    public String getZrnptmttkngkutiwake201() {
        return zrnptmttkngkutiwake201;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnptmttkngkutiwake201(String pZrnptmttkngkutiwake201) {
        zrnptmttkngkutiwake201 = pZrnptmttkngkutiwake201;
    }

    private String zrnmvaarinenoutouym02;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARINENOUTOUYM02)
    public String getZrnmvaarinenoutouym02() {
        return zrnmvaarinenoutouym02;
    }

    @DataConvert("toMultiByte")
    public void setZrnmvaarinenoutouym02(String pZrnmvaarinenoutouym02) {
        zrnmvaarinenoutouym02 = pZrnmvaarinenoutouym02;
    }

    private String zrnmvaarisisuuupritu02;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARISISUUUPRITU02)
    public String getZrnmvaarisisuuupritu02() {
        return zrnmvaarisisuuupritu02;
    }

    @DataConvert("toMultiByte")
    public void setZrnmvaarisisuuupritu02(String pZrnmvaarisisuuupritu02) {
        zrnmvaarisisuuupritu02 = pZrnmvaarisisuuupritu02;
    }

    private String zrnmvaaritmttknzkritu02;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARITMTTKNZKRITU02)
    public String getZrnmvaaritmttknzkritu02() {
        return zrnmvaaritmttknzkritu02;
    }

    @DataConvert("toMultiByte")
    public void setZrnmvaaritmttknzkritu02(String pZrnmvaaritmttknzkritu02) {
        zrnmvaaritmttknzkritu02 = pZrnmvaaritmttknzkritu02;
    }

    private String zrnmvaariwtuktypeup02;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARIWTUKTYPEUP02)
    public String getZrnmvaariwtuktypeup02() {
        return zrnmvaariwtuktypeup02;
    }

    public void setZrnmvaariwtuktypeup02(String pZrnmvaariwtuktypeup02) {
        zrnmvaariwtuktypeup02 = pZrnmvaariwtuktypeup02;
    }

    private String zrnmvaaritmttknkykkjmup02;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARITMTTKNKYKKJMUP02)
    public String getZrnmvaaritmttknkykkjmup02() {
        return zrnmvaaritmttknkykkjmup02;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnmvaaritmttknkykkjmup02(String pZrnmvaaritmttknkykkjmup02) {
        zrnmvaaritmttknkykkjmup02 = pZrnmvaaritmttknkykkjmup02;
    }

    private String zrnmvaariwup02;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARIWUP02)
    public String getZrnmvaariwup02() {
        return zrnmvaariwup02;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnmvaariwup02(String pZrnmvaariwup02) {
        zrnmvaariwup02 = pZrnmvaariwup02;
    }

    private String zrnmvaariwyentuktypeup02;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARIWYENTUKTYPEUP02)
    public String getZrnmvaariwyentuktypeup02() {
        return zrnmvaariwyentuktypeup02;
    }

    public void setZrnmvaariwyentuktypeup02(String pZrnmvaariwyentuktypeup02) {
        zrnmvaariwyentuktypeup02 = pZrnmvaariwyentuktypeup02;
    }

    private String zrnmvaariwupyendaka02;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARIWUPYENDAKA02)
    public String getZrnmvaariwupyendaka02() {
        return zrnmvaariwupyendaka02;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnmvaariwupyendaka02(String pZrnmvaariwupyendaka02) {
        zrnmvaariwupyendaka02 = pZrnmvaariwupyendaka02;
    }

    private String zrnmvaariwupyenkijyun02;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARIWUPYENKIJYUN02)
    public String getZrnmvaariwupyenkijyun02() {
        return zrnmvaariwupyenkijyun02;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnmvaariwupyenkijyun02(String pZrnmvaariwupyenkijyun02) {
        zrnmvaariwupyenkijyun02 = pZrnmvaariwupyenkijyun02;
    }

    private String zrnmvaariwupyenyasu02;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARIWUPYENYASU02)
    public String getZrnmvaariwupyenyasu02() {
        return zrnmvaariwupyenyasu02;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnmvaariwupyenyasu02(String pZrnmvaariwupyenyasu02) {
        zrnmvaariwupyenyasu02 = pZrnmvaariwupyenyasu02;
    }

    private String zrnmvaariwumupyendaka02;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARIWUMUPYENDAKA02)
    public String getZrnmvaariwumupyendaka02() {
        return zrnmvaariwumupyendaka02;
    }

    public void setZrnmvaariwumupyendaka02(String pZrnmvaariwumupyendaka02) {
        zrnmvaariwumupyendaka02 = pZrnmvaariwumupyendaka02;
    }

    private String zrnmvaariumupyenkijyun02;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARIUMUPYENKIJYUN02)
    public String getZrnmvaariumupyenkijyun02() {
        return zrnmvaariumupyenkijyun02;
    }

    public void setZrnmvaariumupyenkijyun02(String pZrnmvaariumupyenkijyun02) {
        zrnmvaariumupyenkijyun02 = pZrnmvaariumupyenkijyun02;
    }

    private String zrnmvaariumupyenyasu02;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARIUMUPYENYASU02)
    public String getZrnmvaariumupyenyasu02() {
        return zrnmvaariumupyenyasu02;
    }

    public void setZrnmvaariumupyenyasu02(String pZrnmvaariumupyenyasu02) {
        zrnmvaariumupyenyasu02 = pZrnmvaariumupyenyasu02;
    }

    private String zrnmvaariwtuktypesame02;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARIWTUKTYPESAME02)
    public String getZrnmvaariwtuktypesame02() {
        return zrnmvaariwtuktypesame02;
    }

    public void setZrnmvaariwtuktypesame02(String pZrnmvaariwtuktypesame02) {
        zrnmvaariwtuktypesame02 = pZrnmvaariwtuktypesame02;
    }

    private String zrnmvaaritmttknkykkjmsame02;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARITMTTKNKYKKJMSAME02)
    public String getZrnmvaaritmttknkykkjmsame02() {
        return zrnmvaaritmttknkykkjmsame02;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnmvaaritmttknkykkjmsame02(String pZrnmvaaritmttknkykkjmsame02) {
        zrnmvaaritmttknkykkjmsame02 = pZrnmvaaritmttknkykkjmsame02;
    }

    private String zrnmvaariwsame02;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARIWSAME02)
    public String getZrnmvaariwsame02() {
        return zrnmvaariwsame02;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnmvaariwsame02(String pZrnmvaariwsame02) {
        zrnmvaariwsame02 = pZrnmvaariwsame02;
    }

    private String zrnmvaariwyentuktypesame02;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARIWYENTUKTYPESAME02)
    public String getZrnmvaariwyentuktypesame02() {
        return zrnmvaariwyentuktypesame02;
    }

    public void setZrnmvaariwyentuktypesame02(String pZrnmvaariwyentuktypesame02) {
        zrnmvaariwyentuktypesame02 = pZrnmvaariwyentuktypesame02;
    }

    private String zrnmvaariwsameyendaka02;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARIWSAMEYENDAKA02)
    public String getZrnmvaariwsameyendaka02() {
        return zrnmvaariwsameyendaka02;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnmvaariwsameyendaka02(String pZrnmvaariwsameyendaka02) {
        zrnmvaariwsameyendaka02 = pZrnmvaariwsameyendaka02;
    }

    private String zrnmvaariwsameyenkijyun02;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARIWSAMEYENKIJYUN02)
    public String getZrnmvaariwsameyenkijyun02() {
        return zrnmvaariwsameyenkijyun02;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnmvaariwsameyenkijyun02(String pZrnmvaariwsameyenkijyun02) {
        zrnmvaariwsameyenkijyun02 = pZrnmvaariwsameyenkijyun02;
    }

    private String zrnmvaariwsameyenyasu02;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARIWSAMEYENYASU02)
    public String getZrnmvaariwsameyenyasu02() {
        return zrnmvaariwsameyenyasu02;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnmvaariwsameyenyasu02(String pZrnmvaariwsameyenyasu02) {
        zrnmvaariwsameyenyasu02 = pZrnmvaariwsameyenyasu02;
    }

    private String zrnmvaariumsameyendaka02;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARIUMSAMEYENDAKA02)
    public String getZrnmvaariumsameyendaka02() {
        return zrnmvaariumsameyendaka02;
    }

    public void setZrnmvaariumsameyendaka02(String pZrnmvaariumsameyendaka02) {
        zrnmvaariumsameyendaka02 = pZrnmvaariumsameyendaka02;
    }

    private String zrnmvaariumsameyenkijyun02;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARIUMSAMEYENKIJYUN02)
    public String getZrnmvaariumsameyenkijyun02() {
        return zrnmvaariumsameyenkijyun02;
    }

    public void setZrnmvaariumsameyenkijyun02(String pZrnmvaariumsameyenkijyun02) {
        zrnmvaariumsameyenkijyun02 = pZrnmvaariumsameyenkijyun02;
    }

    private String zrnmvaariumsameyenyasu02;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARIUMSAMEYENYASU02)
    public String getZrnmvaariumsameyenyasu02() {
        return zrnmvaariumsameyenyasu02;
    }

    public void setZrnmvaariumsameyenyasu02(String pZrnmvaariumsameyenyasu02) {
        zrnmvaariumsameyenyasu02 = pZrnmvaariumsameyenyasu02;
    }

    private String zrnmvaariwtuktypedown02;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARIWTUKTYPEDOWN02)
    public String getZrnmvaariwtuktypedown02() {
        return zrnmvaariwtuktypedown02;
    }

    public void setZrnmvaariwtuktypedown02(String pZrnmvaariwtuktypedown02) {
        zrnmvaariwtuktypedown02 = pZrnmvaariwtuktypedown02;
    }

    private String zrnmvaaritmttknkykkjmdown02;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARITMTTKNKYKKJMDOWN02)
    public String getZrnmvaaritmttknkykkjmdown02() {
        return zrnmvaaritmttknkykkjmdown02;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnmvaaritmttknkykkjmdown02(String pZrnmvaaritmttknkykkjmdown02) {
        zrnmvaaritmttknkykkjmdown02 = pZrnmvaaritmttknkykkjmdown02;
    }

    private String zrnmvaariwdown02;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARIWDOWN02)
    public String getZrnmvaariwdown02() {
        return zrnmvaariwdown02;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnmvaariwdown02(String pZrnmvaariwdown02) {
        zrnmvaariwdown02 = pZrnmvaariwdown02;
    }

    private String zrnmvaariwyentuktypedown02;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARIWYENTUKTYPEDOWN02)
    public String getZrnmvaariwyentuktypedown02() {
        return zrnmvaariwyentuktypedown02;
    }

    public void setZrnmvaariwyentuktypedown02(String pZrnmvaariwyentuktypedown02) {
        zrnmvaariwyentuktypedown02 = pZrnmvaariwyentuktypedown02;
    }

    private String zrnmvaariwdownyendaka02;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARIWDOWNYENDAKA02)
    public String getZrnmvaariwdownyendaka02() {
        return zrnmvaariwdownyendaka02;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnmvaariwdownyendaka02(String pZrnmvaariwdownyendaka02) {
        zrnmvaariwdownyendaka02 = pZrnmvaariwdownyendaka02;
    }

    private String zrnmvaariwdownyenkijyun02;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARIWDOWNYENKIJYUN02)
    public String getZrnmvaariwdownyenkijyun02() {
        return zrnmvaariwdownyenkijyun02;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnmvaariwdownyenkijyun02(String pZrnmvaariwdownyenkijyun02) {
        zrnmvaariwdownyenkijyun02 = pZrnmvaariwdownyenkijyun02;
    }

    private String zrnmvaariwdownyenyasu02;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARIWDOWNYENYASU02)
    public String getZrnmvaariwdownyenyasu02() {
        return zrnmvaariwdownyenyasu02;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnmvaariwdownyenyasu02(String pZrnmvaariwdownyenyasu02) {
        zrnmvaariwdownyenyasu02 = pZrnmvaariwdownyenyasu02;
    }

    private String zrnmvaariumdownyendaka02;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARIUMDOWNYENDAKA02)
    public String getZrnmvaariumdownyendaka02() {
        return zrnmvaariumdownyendaka02;
    }

    public void setZrnmvaariumdownyendaka02(String pZrnmvaariumdownyendaka02) {
        zrnmvaariumdownyendaka02 = pZrnmvaariumdownyendaka02;
    }

    private String zrnmvaariumdownyenkijyun02;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARIUMDOWNYENKIJYUN02)
    public String getZrnmvaariumdownyenkijyun02() {
        return zrnmvaariumdownyenkijyun02;
    }

    public void setZrnmvaariumdownyenkijyun02(String pZrnmvaariumdownyenkijyun02) {
        zrnmvaariumdownyenkijyun02 = pZrnmvaariumdownyenkijyun02;
    }

    private String zrnmvaariumdownyenyasu02;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARIUMDOWNYENYASU02)
    public String getZrnmvaariumdownyenyasu02() {
        return zrnmvaariumdownyenyasu02;
    }

    public void setZrnmvaariumdownyenyasu02(String pZrnmvaariumdownyenyasu02) {
        zrnmvaariumdownyenyasu02 = pZrnmvaariumdownyenyasu02;
    }

    private String zrnmvaarivtuktype02;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARIVTUKTYPE02)
    public String getZrnmvaarivtuktype02() {
        return zrnmvaarivtuktype02;
    }

    public void setZrnmvaarivtuktype02(String pZrnmvaarivtuktype02) {
        zrnmvaarivtuktype02 = pZrnmvaarivtuktype02;
    }

    private String zrnmvaariv02;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARIV02)
    public String getZrnmvaariv02() {
        return zrnmvaariv02;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnmvaariv02(String pZrnmvaariv02) {
        zrnmvaariv02 = pZrnmvaariv02;
    }

    private String zrnptmttkngkutiwake102;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNPTMTTKNGKUTIWAKE102)
    public String getZrnptmttkngkutiwake102() {
        return zrnptmttkngkutiwake102;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnptmttkngkutiwake102(String pZrnptmttkngkutiwake102) {
        zrnptmttkngkutiwake102 = pZrnptmttkngkutiwake102;
    }

    private String zrnptmttkngkutiwake202;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNPTMTTKNGKUTIWAKE202)
    public String getZrnptmttkngkutiwake202() {
        return zrnptmttkngkutiwake202;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnptmttkngkutiwake202(String pZrnptmttkngkutiwake202) {
        zrnptmttkngkutiwake202 = pZrnptmttkngkutiwake202;
    }

    private String zrnmvaarinenoutouym03;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARINENOUTOUYM03)
    public String getZrnmvaarinenoutouym03() {
        return zrnmvaarinenoutouym03;
    }

    @DataConvert("toMultiByte")
    public void setZrnmvaarinenoutouym03(String pZrnmvaarinenoutouym03) {
        zrnmvaarinenoutouym03 = pZrnmvaarinenoutouym03;
    }

    private String zrnmvaarisisuuupritu03;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARISISUUUPRITU03)
    public String getZrnmvaarisisuuupritu03() {
        return zrnmvaarisisuuupritu03;
    }

    @DataConvert("toMultiByte")
    public void setZrnmvaarisisuuupritu03(String pZrnmvaarisisuuupritu03) {
        zrnmvaarisisuuupritu03 = pZrnmvaarisisuuupritu03;
    }

    private String zrnmvaaritmttknzkritu03;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARITMTTKNZKRITU03)
    public String getZrnmvaaritmttknzkritu03() {
        return zrnmvaaritmttknzkritu03;
    }

    @DataConvert("toMultiByte")
    public void setZrnmvaaritmttknzkritu03(String pZrnmvaaritmttknzkritu03) {
        zrnmvaaritmttknzkritu03 = pZrnmvaaritmttknzkritu03;
    }

    private String zrnmvaariwtuktypeup03;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARIWTUKTYPEUP03)
    public String getZrnmvaariwtuktypeup03() {
        return zrnmvaariwtuktypeup03;
    }

    public void setZrnmvaariwtuktypeup03(String pZrnmvaariwtuktypeup03) {
        zrnmvaariwtuktypeup03 = pZrnmvaariwtuktypeup03;
    }

    private String zrnmvaaritmttknkykkjmup03;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARITMTTKNKYKKJMUP03)
    public String getZrnmvaaritmttknkykkjmup03() {
        return zrnmvaaritmttknkykkjmup03;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnmvaaritmttknkykkjmup03(String pZrnmvaaritmttknkykkjmup03) {
        zrnmvaaritmttknkykkjmup03 = pZrnmvaaritmttknkykkjmup03;
    }

    private String zrnmvaariwup03;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARIWUP03)
    public String getZrnmvaariwup03() {
        return zrnmvaariwup03;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnmvaariwup03(String pZrnmvaariwup03) {
        zrnmvaariwup03 = pZrnmvaariwup03;
    }

    private String zrnmvaariwyentuktypeup03;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARIWYENTUKTYPEUP03)
    public String getZrnmvaariwyentuktypeup03() {
        return zrnmvaariwyentuktypeup03;
    }

    public void setZrnmvaariwyentuktypeup03(String pZrnmvaariwyentuktypeup03) {
        zrnmvaariwyentuktypeup03 = pZrnmvaariwyentuktypeup03;
    }

    private String zrnmvaariwupyendaka03;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARIWUPYENDAKA03)
    public String getZrnmvaariwupyendaka03() {
        return zrnmvaariwupyendaka03;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnmvaariwupyendaka03(String pZrnmvaariwupyendaka03) {
        zrnmvaariwupyendaka03 = pZrnmvaariwupyendaka03;
    }

    private String zrnmvaariwupyenkijyun03;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARIWUPYENKIJYUN03)
    public String getZrnmvaariwupyenkijyun03() {
        return zrnmvaariwupyenkijyun03;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnmvaariwupyenkijyun03(String pZrnmvaariwupyenkijyun03) {
        zrnmvaariwupyenkijyun03 = pZrnmvaariwupyenkijyun03;
    }

    private String zrnmvaariwupyenyasu03;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARIWUPYENYASU03)
    public String getZrnmvaariwupyenyasu03() {
        return zrnmvaariwupyenyasu03;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnmvaariwupyenyasu03(String pZrnmvaariwupyenyasu03) {
        zrnmvaariwupyenyasu03 = pZrnmvaariwupyenyasu03;
    }

    private String zrnmvaariwumupyendaka03;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARIWUMUPYENDAKA03)
    public String getZrnmvaariwumupyendaka03() {
        return zrnmvaariwumupyendaka03;
    }

    public void setZrnmvaariwumupyendaka03(String pZrnmvaariwumupyendaka03) {
        zrnmvaariwumupyendaka03 = pZrnmvaariwumupyendaka03;
    }

    private String zrnmvaariumupyenkijyun03;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARIUMUPYENKIJYUN03)
    public String getZrnmvaariumupyenkijyun03() {
        return zrnmvaariumupyenkijyun03;
    }

    public void setZrnmvaariumupyenkijyun03(String pZrnmvaariumupyenkijyun03) {
        zrnmvaariumupyenkijyun03 = pZrnmvaariumupyenkijyun03;
    }

    private String zrnmvaariumupyenyasu03;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARIUMUPYENYASU03)
    public String getZrnmvaariumupyenyasu03() {
        return zrnmvaariumupyenyasu03;
    }

    public void setZrnmvaariumupyenyasu03(String pZrnmvaariumupyenyasu03) {
        zrnmvaariumupyenyasu03 = pZrnmvaariumupyenyasu03;
    }

    private String zrnmvaariwtuktypesame03;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARIWTUKTYPESAME03)
    public String getZrnmvaariwtuktypesame03() {
        return zrnmvaariwtuktypesame03;
    }

    public void setZrnmvaariwtuktypesame03(String pZrnmvaariwtuktypesame03) {
        zrnmvaariwtuktypesame03 = pZrnmvaariwtuktypesame03;
    }

    private String zrnmvaaritmttknkykkjmsame03;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARITMTTKNKYKKJMSAME03)
    public String getZrnmvaaritmttknkykkjmsame03() {
        return zrnmvaaritmttknkykkjmsame03;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnmvaaritmttknkykkjmsame03(String pZrnmvaaritmttknkykkjmsame03) {
        zrnmvaaritmttknkykkjmsame03 = pZrnmvaaritmttknkykkjmsame03;
    }

    private String zrnmvaariwsame03;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARIWSAME03)
    public String getZrnmvaariwsame03() {
        return zrnmvaariwsame03;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnmvaariwsame03(String pZrnmvaariwsame03) {
        zrnmvaariwsame03 = pZrnmvaariwsame03;
    }

    private String zrnmvaariwyentuktypesame03;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARIWYENTUKTYPESAME03)
    public String getZrnmvaariwyentuktypesame03() {
        return zrnmvaariwyentuktypesame03;
    }

    public void setZrnmvaariwyentuktypesame03(String pZrnmvaariwyentuktypesame03) {
        zrnmvaariwyentuktypesame03 = pZrnmvaariwyentuktypesame03;
    }

    private String zrnmvaariwsameyendaka03;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARIWSAMEYENDAKA03)
    public String getZrnmvaariwsameyendaka03() {
        return zrnmvaariwsameyendaka03;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnmvaariwsameyendaka03(String pZrnmvaariwsameyendaka03) {
        zrnmvaariwsameyendaka03 = pZrnmvaariwsameyendaka03;
    }

    private String zrnmvaariwsameyenkijyun03;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARIWSAMEYENKIJYUN03)
    public String getZrnmvaariwsameyenkijyun03() {
        return zrnmvaariwsameyenkijyun03;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnmvaariwsameyenkijyun03(String pZrnmvaariwsameyenkijyun03) {
        zrnmvaariwsameyenkijyun03 = pZrnmvaariwsameyenkijyun03;
    }

    private String zrnmvaariwsameyenyasu03;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARIWSAMEYENYASU03)
    public String getZrnmvaariwsameyenyasu03() {
        return zrnmvaariwsameyenyasu03;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnmvaariwsameyenyasu03(String pZrnmvaariwsameyenyasu03) {
        zrnmvaariwsameyenyasu03 = pZrnmvaariwsameyenyasu03;
    }

    private String zrnmvaariumsameyendaka03;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARIUMSAMEYENDAKA03)
    public String getZrnmvaariumsameyendaka03() {
        return zrnmvaariumsameyendaka03;
    }

    public void setZrnmvaariumsameyendaka03(String pZrnmvaariumsameyendaka03) {
        zrnmvaariumsameyendaka03 = pZrnmvaariumsameyendaka03;
    }

    private String zrnmvaariumsameyenkijyun03;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARIUMSAMEYENKIJYUN03)
    public String getZrnmvaariumsameyenkijyun03() {
        return zrnmvaariumsameyenkijyun03;
    }

    public void setZrnmvaariumsameyenkijyun03(String pZrnmvaariumsameyenkijyun03) {
        zrnmvaariumsameyenkijyun03 = pZrnmvaariumsameyenkijyun03;
    }

    private String zrnmvaariumsameyenyasu03;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARIUMSAMEYENYASU03)
    public String getZrnmvaariumsameyenyasu03() {
        return zrnmvaariumsameyenyasu03;
    }

    public void setZrnmvaariumsameyenyasu03(String pZrnmvaariumsameyenyasu03) {
        zrnmvaariumsameyenyasu03 = pZrnmvaariumsameyenyasu03;
    }

    private String zrnmvaariwtuktypedown03;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARIWTUKTYPEDOWN03)
    public String getZrnmvaariwtuktypedown03() {
        return zrnmvaariwtuktypedown03;
    }

    public void setZrnmvaariwtuktypedown03(String pZrnmvaariwtuktypedown03) {
        zrnmvaariwtuktypedown03 = pZrnmvaariwtuktypedown03;
    }

    private String zrnmvaaritmttknkykkjmdown03;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARITMTTKNKYKKJMDOWN03)
    public String getZrnmvaaritmttknkykkjmdown03() {
        return zrnmvaaritmttknkykkjmdown03;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnmvaaritmttknkykkjmdown03(String pZrnmvaaritmttknkykkjmdown03) {
        zrnmvaaritmttknkykkjmdown03 = pZrnmvaaritmttknkykkjmdown03;
    }

    private String zrnmvaariwdown03;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARIWDOWN03)
    public String getZrnmvaariwdown03() {
        return zrnmvaariwdown03;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnmvaariwdown03(String pZrnmvaariwdown03) {
        zrnmvaariwdown03 = pZrnmvaariwdown03;
    }

    private String zrnmvaariwyentuktypedown03;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARIWYENTUKTYPEDOWN03)
    public String getZrnmvaariwyentuktypedown03() {
        return zrnmvaariwyentuktypedown03;
    }

    public void setZrnmvaariwyentuktypedown03(String pZrnmvaariwyentuktypedown03) {
        zrnmvaariwyentuktypedown03 = pZrnmvaariwyentuktypedown03;
    }

    private String zrnmvaariwdownyendaka03;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARIWDOWNYENDAKA03)
    public String getZrnmvaariwdownyendaka03() {
        return zrnmvaariwdownyendaka03;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnmvaariwdownyendaka03(String pZrnmvaariwdownyendaka03) {
        zrnmvaariwdownyendaka03 = pZrnmvaariwdownyendaka03;
    }

    private String zrnmvaariwdownyenkijyun03;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARIWDOWNYENKIJYUN03)
    public String getZrnmvaariwdownyenkijyun03() {
        return zrnmvaariwdownyenkijyun03;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnmvaariwdownyenkijyun03(String pZrnmvaariwdownyenkijyun03) {
        zrnmvaariwdownyenkijyun03 = pZrnmvaariwdownyenkijyun03;
    }

    private String zrnmvaariwdownyenyasu03;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARIWDOWNYENYASU03)
    public String getZrnmvaariwdownyenyasu03() {
        return zrnmvaariwdownyenyasu03;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnmvaariwdownyenyasu03(String pZrnmvaariwdownyenyasu03) {
        zrnmvaariwdownyenyasu03 = pZrnmvaariwdownyenyasu03;
    }

    private String zrnmvaariumdownyendaka03;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARIUMDOWNYENDAKA03)
    public String getZrnmvaariumdownyendaka03() {
        return zrnmvaariumdownyendaka03;
    }

    public void setZrnmvaariumdownyendaka03(String pZrnmvaariumdownyendaka03) {
        zrnmvaariumdownyendaka03 = pZrnmvaariumdownyendaka03;
    }

    private String zrnmvaariumdownyenkijyun03;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARIUMDOWNYENKIJYUN03)
    public String getZrnmvaariumdownyenkijyun03() {
        return zrnmvaariumdownyenkijyun03;
    }

    public void setZrnmvaariumdownyenkijyun03(String pZrnmvaariumdownyenkijyun03) {
        zrnmvaariumdownyenkijyun03 = pZrnmvaariumdownyenkijyun03;
    }

    private String zrnmvaariumdownyenyasu03;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARIUMDOWNYENYASU03)
    public String getZrnmvaariumdownyenyasu03() {
        return zrnmvaariumdownyenyasu03;
    }

    public void setZrnmvaariumdownyenyasu03(String pZrnmvaariumdownyenyasu03) {
        zrnmvaariumdownyenyasu03 = pZrnmvaariumdownyenyasu03;
    }

    private String zrnmvaarivtuktype03;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARIVTUKTYPE03)
    public String getZrnmvaarivtuktype03() {
        return zrnmvaarivtuktype03;
    }

    public void setZrnmvaarivtuktype03(String pZrnmvaarivtuktype03) {
        zrnmvaarivtuktype03 = pZrnmvaarivtuktype03;
    }

    private String zrnmvaariv03;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARIV03)
    public String getZrnmvaariv03() {
        return zrnmvaariv03;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnmvaariv03(String pZrnmvaariv03) {
        zrnmvaariv03 = pZrnmvaariv03;
    }

    private String zrnptmttkngkutiwake103;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNPTMTTKNGKUTIWAKE103)
    public String getZrnptmttkngkutiwake103() {
        return zrnptmttkngkutiwake103;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnptmttkngkutiwake103(String pZrnptmttkngkutiwake103) {
        zrnptmttkngkutiwake103 = pZrnptmttkngkutiwake103;
    }

    private String zrnptmttkngkutiwake203;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNPTMTTKNGKUTIWAKE203)
    public String getZrnptmttkngkutiwake203() {
        return zrnptmttkngkutiwake203;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnptmttkngkutiwake203(String pZrnptmttkngkutiwake203) {
        zrnptmttkngkutiwake203 = pZrnptmttkngkutiwake203;
    }

    private String zrnmvaarinenoutouym04;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARINENOUTOUYM04)
    public String getZrnmvaarinenoutouym04() {
        return zrnmvaarinenoutouym04;
    }

    @DataConvert("toMultiByte")
    public void setZrnmvaarinenoutouym04(String pZrnmvaarinenoutouym04) {
        zrnmvaarinenoutouym04 = pZrnmvaarinenoutouym04;
    }

    private String zrnmvaarisisuuupritu04;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARISISUUUPRITU04)
    public String getZrnmvaarisisuuupritu04() {
        return zrnmvaarisisuuupritu04;
    }

    @DataConvert("toMultiByte")
    public void setZrnmvaarisisuuupritu04(String pZrnmvaarisisuuupritu04) {
        zrnmvaarisisuuupritu04 = pZrnmvaarisisuuupritu04;
    }

    private String zrnmvaaritmttknzkritu04;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARITMTTKNZKRITU04)
    public String getZrnmvaaritmttknzkritu04() {
        return zrnmvaaritmttknzkritu04;
    }

    @DataConvert("toMultiByte")
    public void setZrnmvaaritmttknzkritu04(String pZrnmvaaritmttknzkritu04) {
        zrnmvaaritmttknzkritu04 = pZrnmvaaritmttknzkritu04;
    }

    private String zrnmvaariwtuktypeup04;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARIWTUKTYPEUP04)
    public String getZrnmvaariwtuktypeup04() {
        return zrnmvaariwtuktypeup04;
    }

    public void setZrnmvaariwtuktypeup04(String pZrnmvaariwtuktypeup04) {
        zrnmvaariwtuktypeup04 = pZrnmvaariwtuktypeup04;
    }

    private String zrnmvaaritmttknkykkjmup04;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARITMTTKNKYKKJMUP04)
    public String getZrnmvaaritmttknkykkjmup04() {
        return zrnmvaaritmttknkykkjmup04;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnmvaaritmttknkykkjmup04(String pZrnmvaaritmttknkykkjmup04) {
        zrnmvaaritmttknkykkjmup04 = pZrnmvaaritmttknkykkjmup04;
    }

    private String zrnmvaariwup04;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARIWUP04)
    public String getZrnmvaariwup04() {
        return zrnmvaariwup04;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnmvaariwup04(String pZrnmvaariwup04) {
        zrnmvaariwup04 = pZrnmvaariwup04;
    }

    private String zrnmvaariwyentuktypeup04;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARIWYENTUKTYPEUP04)
    public String getZrnmvaariwyentuktypeup04() {
        return zrnmvaariwyentuktypeup04;
    }

    public void setZrnmvaariwyentuktypeup04(String pZrnmvaariwyentuktypeup04) {
        zrnmvaariwyentuktypeup04 = pZrnmvaariwyentuktypeup04;
    }

    private String zrnmvaariwupyendaka04;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARIWUPYENDAKA04)
    public String getZrnmvaariwupyendaka04() {
        return zrnmvaariwupyendaka04;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnmvaariwupyendaka04(String pZrnmvaariwupyendaka04) {
        zrnmvaariwupyendaka04 = pZrnmvaariwupyendaka04;
    }

    private String zrnmvaariwupyenkijyun04;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARIWUPYENKIJYUN04)
    public String getZrnmvaariwupyenkijyun04() {
        return zrnmvaariwupyenkijyun04;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnmvaariwupyenkijyun04(String pZrnmvaariwupyenkijyun04) {
        zrnmvaariwupyenkijyun04 = pZrnmvaariwupyenkijyun04;
    }

    private String zrnmvaariwupyenyasu04;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARIWUPYENYASU04)
    public String getZrnmvaariwupyenyasu04() {
        return zrnmvaariwupyenyasu04;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnmvaariwupyenyasu04(String pZrnmvaariwupyenyasu04) {
        zrnmvaariwupyenyasu04 = pZrnmvaariwupyenyasu04;
    }

    private String zrnmvaariwumupyendaka04;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARIWUMUPYENDAKA04)
    public String getZrnmvaariwumupyendaka04() {
        return zrnmvaariwumupyendaka04;
    }

    public void setZrnmvaariwumupyendaka04(String pZrnmvaariwumupyendaka04) {
        zrnmvaariwumupyendaka04 = pZrnmvaariwumupyendaka04;
    }

    private String zrnmvaariumupyenkijyun04;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARIUMUPYENKIJYUN04)
    public String getZrnmvaariumupyenkijyun04() {
        return zrnmvaariumupyenkijyun04;
    }

    public void setZrnmvaariumupyenkijyun04(String pZrnmvaariumupyenkijyun04) {
        zrnmvaariumupyenkijyun04 = pZrnmvaariumupyenkijyun04;
    }

    private String zrnmvaariumupyenyasu04;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARIUMUPYENYASU04)
    public String getZrnmvaariumupyenyasu04() {
        return zrnmvaariumupyenyasu04;
    }

    public void setZrnmvaariumupyenyasu04(String pZrnmvaariumupyenyasu04) {
        zrnmvaariumupyenyasu04 = pZrnmvaariumupyenyasu04;
    }

    private String zrnmvaariwtuktypesame04;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARIWTUKTYPESAME04)
    public String getZrnmvaariwtuktypesame04() {
        return zrnmvaariwtuktypesame04;
    }

    public void setZrnmvaariwtuktypesame04(String pZrnmvaariwtuktypesame04) {
        zrnmvaariwtuktypesame04 = pZrnmvaariwtuktypesame04;
    }

    private String zrnmvaaritmttknkykkjmsame04;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARITMTTKNKYKKJMSAME04)
    public String getZrnmvaaritmttknkykkjmsame04() {
        return zrnmvaaritmttknkykkjmsame04;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnmvaaritmttknkykkjmsame04(String pZrnmvaaritmttknkykkjmsame04) {
        zrnmvaaritmttknkykkjmsame04 = pZrnmvaaritmttknkykkjmsame04;
    }

    private String zrnmvaariwsame04;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARIWSAME04)
    public String getZrnmvaariwsame04() {
        return zrnmvaariwsame04;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnmvaariwsame04(String pZrnmvaariwsame04) {
        zrnmvaariwsame04 = pZrnmvaariwsame04;
    }

    private String zrnmvaariwyentuktypesame04;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARIWYENTUKTYPESAME04)
    public String getZrnmvaariwyentuktypesame04() {
        return zrnmvaariwyentuktypesame04;
    }

    public void setZrnmvaariwyentuktypesame04(String pZrnmvaariwyentuktypesame04) {
        zrnmvaariwyentuktypesame04 = pZrnmvaariwyentuktypesame04;
    }

    private String zrnmvaariwsameyendaka04;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARIWSAMEYENDAKA04)
    public String getZrnmvaariwsameyendaka04() {
        return zrnmvaariwsameyendaka04;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnmvaariwsameyendaka04(String pZrnmvaariwsameyendaka04) {
        zrnmvaariwsameyendaka04 = pZrnmvaariwsameyendaka04;
    }

    private String zrnmvaariwsameyenkijyun04;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARIWSAMEYENKIJYUN04)
    public String getZrnmvaariwsameyenkijyun04() {
        return zrnmvaariwsameyenkijyun04;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnmvaariwsameyenkijyun04(String pZrnmvaariwsameyenkijyun04) {
        zrnmvaariwsameyenkijyun04 = pZrnmvaariwsameyenkijyun04;
    }

    private String zrnmvaariwsameyenyasu04;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARIWSAMEYENYASU04)
    public String getZrnmvaariwsameyenyasu04() {
        return zrnmvaariwsameyenyasu04;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnmvaariwsameyenyasu04(String pZrnmvaariwsameyenyasu04) {
        zrnmvaariwsameyenyasu04 = pZrnmvaariwsameyenyasu04;
    }

    private String zrnmvaariumsameyendaka04;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARIUMSAMEYENDAKA04)
    public String getZrnmvaariumsameyendaka04() {
        return zrnmvaariumsameyendaka04;
    }

    public void setZrnmvaariumsameyendaka04(String pZrnmvaariumsameyendaka04) {
        zrnmvaariumsameyendaka04 = pZrnmvaariumsameyendaka04;
    }

    private String zrnmvaariumsameyenkijyun04;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARIUMSAMEYENKIJYUN04)
    public String getZrnmvaariumsameyenkijyun04() {
        return zrnmvaariumsameyenkijyun04;
    }

    public void setZrnmvaariumsameyenkijyun04(String pZrnmvaariumsameyenkijyun04) {
        zrnmvaariumsameyenkijyun04 = pZrnmvaariumsameyenkijyun04;
    }

    private String zrnmvaariumsameyenyasu04;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARIUMSAMEYENYASU04)
    public String getZrnmvaariumsameyenyasu04() {
        return zrnmvaariumsameyenyasu04;
    }

    public void setZrnmvaariumsameyenyasu04(String pZrnmvaariumsameyenyasu04) {
        zrnmvaariumsameyenyasu04 = pZrnmvaariumsameyenyasu04;
    }

    private String zrnmvaariwtuktypedown04;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARIWTUKTYPEDOWN04)
    public String getZrnmvaariwtuktypedown04() {
        return zrnmvaariwtuktypedown04;
    }

    public void setZrnmvaariwtuktypedown04(String pZrnmvaariwtuktypedown04) {
        zrnmvaariwtuktypedown04 = pZrnmvaariwtuktypedown04;
    }

    private String zrnmvaaritmttknkykkjmdown04;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARITMTTKNKYKKJMDOWN04)
    public String getZrnmvaaritmttknkykkjmdown04() {
        return zrnmvaaritmttknkykkjmdown04;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnmvaaritmttknkykkjmdown04(String pZrnmvaaritmttknkykkjmdown04) {
        zrnmvaaritmttknkykkjmdown04 = pZrnmvaaritmttknkykkjmdown04;
    }

    private String zrnmvaariwdown04;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARIWDOWN04)
    public String getZrnmvaariwdown04() {
        return zrnmvaariwdown04;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnmvaariwdown04(String pZrnmvaariwdown04) {
        zrnmvaariwdown04 = pZrnmvaariwdown04;
    }

    private String zrnmvaariwyentuktypedown04;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARIWYENTUKTYPEDOWN04)
    public String getZrnmvaariwyentuktypedown04() {
        return zrnmvaariwyentuktypedown04;
    }

    public void setZrnmvaariwyentuktypedown04(String pZrnmvaariwyentuktypedown04) {
        zrnmvaariwyentuktypedown04 = pZrnmvaariwyentuktypedown04;
    }

    private String zrnmvaariwdownyendaka04;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARIWDOWNYENDAKA04)
    public String getZrnmvaariwdownyendaka04() {
        return zrnmvaariwdownyendaka04;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnmvaariwdownyendaka04(String pZrnmvaariwdownyendaka04) {
        zrnmvaariwdownyendaka04 = pZrnmvaariwdownyendaka04;
    }

    private String zrnmvaariwdownyenkijyun04;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARIWDOWNYENKIJYUN04)
    public String getZrnmvaariwdownyenkijyun04() {
        return zrnmvaariwdownyenkijyun04;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnmvaariwdownyenkijyun04(String pZrnmvaariwdownyenkijyun04) {
        zrnmvaariwdownyenkijyun04 = pZrnmvaariwdownyenkijyun04;
    }

    private String zrnmvaariwdownyenyasu04;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARIWDOWNYENYASU04)
    public String getZrnmvaariwdownyenyasu04() {
        return zrnmvaariwdownyenyasu04;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnmvaariwdownyenyasu04(String pZrnmvaariwdownyenyasu04) {
        zrnmvaariwdownyenyasu04 = pZrnmvaariwdownyenyasu04;
    }

    private String zrnmvaariumdownyendaka04;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARIUMDOWNYENDAKA04)
    public String getZrnmvaariumdownyendaka04() {
        return zrnmvaariumdownyendaka04;
    }

    public void setZrnmvaariumdownyendaka04(String pZrnmvaariumdownyendaka04) {
        zrnmvaariumdownyendaka04 = pZrnmvaariumdownyendaka04;
    }

    private String zrnmvaariumdownyenkijyun04;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARIUMDOWNYENKIJYUN04)
    public String getZrnmvaariumdownyenkijyun04() {
        return zrnmvaariumdownyenkijyun04;
    }

    public void setZrnmvaariumdownyenkijyun04(String pZrnmvaariumdownyenkijyun04) {
        zrnmvaariumdownyenkijyun04 = pZrnmvaariumdownyenkijyun04;
    }

    private String zrnmvaariumdownyenyasu04;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARIUMDOWNYENYASU04)
    public String getZrnmvaariumdownyenyasu04() {
        return zrnmvaariumdownyenyasu04;
    }

    public void setZrnmvaariumdownyenyasu04(String pZrnmvaariumdownyenyasu04) {
        zrnmvaariumdownyenyasu04 = pZrnmvaariumdownyenyasu04;
    }

    private String zrnmvaarivtuktype04;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARIVTUKTYPE04)
    public String getZrnmvaarivtuktype04() {
        return zrnmvaarivtuktype04;
    }

    public void setZrnmvaarivtuktype04(String pZrnmvaarivtuktype04) {
        zrnmvaarivtuktype04 = pZrnmvaarivtuktype04;
    }

    private String zrnmvaariv04;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARIV04)
    public String getZrnmvaariv04() {
        return zrnmvaariv04;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnmvaariv04(String pZrnmvaariv04) {
        zrnmvaariv04 = pZrnmvaariv04;
    }

    private String zrnptmttkngkutiwake104;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNPTMTTKNGKUTIWAKE104)
    public String getZrnptmttkngkutiwake104() {
        return zrnptmttkngkutiwake104;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnptmttkngkutiwake104(String pZrnptmttkngkutiwake104) {
        zrnptmttkngkutiwake104 = pZrnptmttkngkutiwake104;
    }

    private String zrnptmttkngkutiwake204;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNPTMTTKNGKUTIWAKE204)
    public String getZrnptmttkngkutiwake204() {
        return zrnptmttkngkutiwake204;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnptmttkngkutiwake204(String pZrnptmttkngkutiwake204) {
        zrnptmttkngkutiwake204 = pZrnptmttkngkutiwake204;
    }

    private String zrnmvaarinenoutouym05;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARINENOUTOUYM05)
    public String getZrnmvaarinenoutouym05() {
        return zrnmvaarinenoutouym05;
    }

    @DataConvert("toMultiByte")
    public void setZrnmvaarinenoutouym05(String pZrnmvaarinenoutouym05) {
        zrnmvaarinenoutouym05 = pZrnmvaarinenoutouym05;
    }

    private String zrnmvaarisisuuupritu05;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARISISUUUPRITU05)
    public String getZrnmvaarisisuuupritu05() {
        return zrnmvaarisisuuupritu05;
    }

    @DataConvert("toMultiByte")
    public void setZrnmvaarisisuuupritu05(String pZrnmvaarisisuuupritu05) {
        zrnmvaarisisuuupritu05 = pZrnmvaarisisuuupritu05;
    }

    private String zrnmvaaritmttknzkritu05;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARITMTTKNZKRITU05)
    public String getZrnmvaaritmttknzkritu05() {
        return zrnmvaaritmttknzkritu05;
    }

    @DataConvert("toMultiByte")
    public void setZrnmvaaritmttknzkritu05(String pZrnmvaaritmttknzkritu05) {
        zrnmvaaritmttknzkritu05 = pZrnmvaaritmttknzkritu05;
    }

    private String zrnmvaariwtuktypeup05;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARIWTUKTYPEUP05)
    public String getZrnmvaariwtuktypeup05() {
        return zrnmvaariwtuktypeup05;
    }

    public void setZrnmvaariwtuktypeup05(String pZrnmvaariwtuktypeup05) {
        zrnmvaariwtuktypeup05 = pZrnmvaariwtuktypeup05;
    }

    private String zrnmvaaritmttknkykkjmup05;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARITMTTKNKYKKJMUP05)
    public String getZrnmvaaritmttknkykkjmup05() {
        return zrnmvaaritmttknkykkjmup05;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnmvaaritmttknkykkjmup05(String pZrnmvaaritmttknkykkjmup05) {
        zrnmvaaritmttknkykkjmup05 = pZrnmvaaritmttknkykkjmup05;
    }

    private String zrnmvaariwup05;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARIWUP05)
    public String getZrnmvaariwup05() {
        return zrnmvaariwup05;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnmvaariwup05(String pZrnmvaariwup05) {
        zrnmvaariwup05 = pZrnmvaariwup05;
    }

    private String zrnmvaariwyentuktypeup05;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARIWYENTUKTYPEUP05)
    public String getZrnmvaariwyentuktypeup05() {
        return zrnmvaariwyentuktypeup05;
    }

    public void setZrnmvaariwyentuktypeup05(String pZrnmvaariwyentuktypeup05) {
        zrnmvaariwyentuktypeup05 = pZrnmvaariwyentuktypeup05;
    }

    private String zrnmvaariwupyendaka05;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARIWUPYENDAKA05)
    public String getZrnmvaariwupyendaka05() {
        return zrnmvaariwupyendaka05;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnmvaariwupyendaka05(String pZrnmvaariwupyendaka05) {
        zrnmvaariwupyendaka05 = pZrnmvaariwupyendaka05;
    }

    private String zrnmvaariwupyenkijyun05;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARIWUPYENKIJYUN05)
    public String getZrnmvaariwupyenkijyun05() {
        return zrnmvaariwupyenkijyun05;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnmvaariwupyenkijyun05(String pZrnmvaariwupyenkijyun05) {
        zrnmvaariwupyenkijyun05 = pZrnmvaariwupyenkijyun05;
    }

    private String zrnmvaariwupyenyasu05;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARIWUPYENYASU05)
    public String getZrnmvaariwupyenyasu05() {
        return zrnmvaariwupyenyasu05;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnmvaariwupyenyasu05(String pZrnmvaariwupyenyasu05) {
        zrnmvaariwupyenyasu05 = pZrnmvaariwupyenyasu05;
    }

    private String zrnmvaariwumupyendaka05;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARIWUMUPYENDAKA05)
    public String getZrnmvaariwumupyendaka05() {
        return zrnmvaariwumupyendaka05;
    }

    public void setZrnmvaariwumupyendaka05(String pZrnmvaariwumupyendaka05) {
        zrnmvaariwumupyendaka05 = pZrnmvaariwumupyendaka05;
    }

    private String zrnmvaariumupyenkijyun05;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARIUMUPYENKIJYUN05)
    public String getZrnmvaariumupyenkijyun05() {
        return zrnmvaariumupyenkijyun05;
    }

    public void setZrnmvaariumupyenkijyun05(String pZrnmvaariumupyenkijyun05) {
        zrnmvaariumupyenkijyun05 = pZrnmvaariumupyenkijyun05;
    }

    private String zrnmvaariumupyenyasu05;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARIUMUPYENYASU05)
    public String getZrnmvaariumupyenyasu05() {
        return zrnmvaariumupyenyasu05;
    }

    public void setZrnmvaariumupyenyasu05(String pZrnmvaariumupyenyasu05) {
        zrnmvaariumupyenyasu05 = pZrnmvaariumupyenyasu05;
    }

    private String zrnmvaariwtuktypesame05;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARIWTUKTYPESAME05)
    public String getZrnmvaariwtuktypesame05() {
        return zrnmvaariwtuktypesame05;
    }

    public void setZrnmvaariwtuktypesame05(String pZrnmvaariwtuktypesame05) {
        zrnmvaariwtuktypesame05 = pZrnmvaariwtuktypesame05;
    }

    private String zrnmvaaritmttknkykkjmsame05;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARITMTTKNKYKKJMSAME05)
    public String getZrnmvaaritmttknkykkjmsame05() {
        return zrnmvaaritmttknkykkjmsame05;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnmvaaritmttknkykkjmsame05(String pZrnmvaaritmttknkykkjmsame05) {
        zrnmvaaritmttknkykkjmsame05 = pZrnmvaaritmttknkykkjmsame05;
    }

    private String zrnmvaariwsame05;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARIWSAME05)
    public String getZrnmvaariwsame05() {
        return zrnmvaariwsame05;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnmvaariwsame05(String pZrnmvaariwsame05) {
        zrnmvaariwsame05 = pZrnmvaariwsame05;
    }

    private String zrnmvaariwyentuktypesame05;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARIWYENTUKTYPESAME05)
    public String getZrnmvaariwyentuktypesame05() {
        return zrnmvaariwyentuktypesame05;
    }

    public void setZrnmvaariwyentuktypesame05(String pZrnmvaariwyentuktypesame05) {
        zrnmvaariwyentuktypesame05 = pZrnmvaariwyentuktypesame05;
    }

    private String zrnmvaariwsameyendaka05;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARIWSAMEYENDAKA05)
    public String getZrnmvaariwsameyendaka05() {
        return zrnmvaariwsameyendaka05;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnmvaariwsameyendaka05(String pZrnmvaariwsameyendaka05) {
        zrnmvaariwsameyendaka05 = pZrnmvaariwsameyendaka05;
    }

    private String zrnmvaariwsameyenkijyun05;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARIWSAMEYENKIJYUN05)
    public String getZrnmvaariwsameyenkijyun05() {
        return zrnmvaariwsameyenkijyun05;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnmvaariwsameyenkijyun05(String pZrnmvaariwsameyenkijyun05) {
        zrnmvaariwsameyenkijyun05 = pZrnmvaariwsameyenkijyun05;
    }

    private String zrnmvaariwsameyenyasu05;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARIWSAMEYENYASU05)
    public String getZrnmvaariwsameyenyasu05() {
        return zrnmvaariwsameyenyasu05;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnmvaariwsameyenyasu05(String pZrnmvaariwsameyenyasu05) {
        zrnmvaariwsameyenyasu05 = pZrnmvaariwsameyenyasu05;
    }

    private String zrnmvaariumsameyendaka05;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARIUMSAMEYENDAKA05)
    public String getZrnmvaariumsameyendaka05() {
        return zrnmvaariumsameyendaka05;
    }

    public void setZrnmvaariumsameyendaka05(String pZrnmvaariumsameyendaka05) {
        zrnmvaariumsameyendaka05 = pZrnmvaariumsameyendaka05;
    }

    private String zrnmvaariumsameyenkijyun05;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARIUMSAMEYENKIJYUN05)
    public String getZrnmvaariumsameyenkijyun05() {
        return zrnmvaariumsameyenkijyun05;
    }

    public void setZrnmvaariumsameyenkijyun05(String pZrnmvaariumsameyenkijyun05) {
        zrnmvaariumsameyenkijyun05 = pZrnmvaariumsameyenkijyun05;
    }

    private String zrnmvaariumsameyenyasu05;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARIUMSAMEYENYASU05)
    public String getZrnmvaariumsameyenyasu05() {
        return zrnmvaariumsameyenyasu05;
    }

    public void setZrnmvaariumsameyenyasu05(String pZrnmvaariumsameyenyasu05) {
        zrnmvaariumsameyenyasu05 = pZrnmvaariumsameyenyasu05;
    }

    private String zrnmvaariwtuktypedown05;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARIWTUKTYPEDOWN05)
    public String getZrnmvaariwtuktypedown05() {
        return zrnmvaariwtuktypedown05;
    }

    public void setZrnmvaariwtuktypedown05(String pZrnmvaariwtuktypedown05) {
        zrnmvaariwtuktypedown05 = pZrnmvaariwtuktypedown05;
    }

    private String zrnmvaaritmttknkykkjmdown05;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARITMTTKNKYKKJMDOWN05)
    public String getZrnmvaaritmttknkykkjmdown05() {
        return zrnmvaaritmttknkykkjmdown05;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnmvaaritmttknkykkjmdown05(String pZrnmvaaritmttknkykkjmdown05) {
        zrnmvaaritmttknkykkjmdown05 = pZrnmvaaritmttknkykkjmdown05;
    }

    private String zrnmvaariwdown05;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARIWDOWN05)
    public String getZrnmvaariwdown05() {
        return zrnmvaariwdown05;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnmvaariwdown05(String pZrnmvaariwdown05) {
        zrnmvaariwdown05 = pZrnmvaariwdown05;
    }

    private String zrnmvaariwyentuktypedown05;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARIWYENTUKTYPEDOWN05)
    public String getZrnmvaariwyentuktypedown05() {
        return zrnmvaariwyentuktypedown05;
    }

    public void setZrnmvaariwyentuktypedown05(String pZrnmvaariwyentuktypedown05) {
        zrnmvaariwyentuktypedown05 = pZrnmvaariwyentuktypedown05;
    }

    private String zrnmvaariwdownyendaka05;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARIWDOWNYENDAKA05)
    public String getZrnmvaariwdownyendaka05() {
        return zrnmvaariwdownyendaka05;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnmvaariwdownyendaka05(String pZrnmvaariwdownyendaka05) {
        zrnmvaariwdownyendaka05 = pZrnmvaariwdownyendaka05;
    }

    private String zrnmvaariwdownyenkijyun05;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARIWDOWNYENKIJYUN05)
    public String getZrnmvaariwdownyenkijyun05() {
        return zrnmvaariwdownyenkijyun05;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnmvaariwdownyenkijyun05(String pZrnmvaariwdownyenkijyun05) {
        zrnmvaariwdownyenkijyun05 = pZrnmvaariwdownyenkijyun05;
    }

    private String zrnmvaariwdownyenyasu05;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARIWDOWNYENYASU05)
    public String getZrnmvaariwdownyenyasu05() {
        return zrnmvaariwdownyenyasu05;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnmvaariwdownyenyasu05(String pZrnmvaariwdownyenyasu05) {
        zrnmvaariwdownyenyasu05 = pZrnmvaariwdownyenyasu05;
    }

    private String zrnmvaariumdownyendaka05;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARIUMDOWNYENDAKA05)
    public String getZrnmvaariumdownyendaka05() {
        return zrnmvaariumdownyendaka05;
    }

    public void setZrnmvaariumdownyendaka05(String pZrnmvaariumdownyendaka05) {
        zrnmvaariumdownyendaka05 = pZrnmvaariumdownyendaka05;
    }

    private String zrnmvaariumdownyenkijyun05;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARIUMDOWNYENKIJYUN05)
    public String getZrnmvaariumdownyenkijyun05() {
        return zrnmvaariumdownyenkijyun05;
    }

    public void setZrnmvaariumdownyenkijyun05(String pZrnmvaariumdownyenkijyun05) {
        zrnmvaariumdownyenkijyun05 = pZrnmvaariumdownyenkijyun05;
    }

    private String zrnmvaariumdownyenyasu05;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARIUMDOWNYENYASU05)
    public String getZrnmvaariumdownyenyasu05() {
        return zrnmvaariumdownyenyasu05;
    }

    public void setZrnmvaariumdownyenyasu05(String pZrnmvaariumdownyenyasu05) {
        zrnmvaariumdownyenyasu05 = pZrnmvaariumdownyenyasu05;
    }

    private String zrnmvaarivtuktype05;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARIVTUKTYPE05)
    public String getZrnmvaarivtuktype05() {
        return zrnmvaarivtuktype05;
    }

    public void setZrnmvaarivtuktype05(String pZrnmvaarivtuktype05) {
        zrnmvaarivtuktype05 = pZrnmvaarivtuktype05;
    }

    private String zrnmvaariv05;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARIV05)
    public String getZrnmvaariv05() {
        return zrnmvaariv05;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnmvaariv05(String pZrnmvaariv05) {
        zrnmvaariv05 = pZrnmvaariv05;
    }

    private String zrnptmttkngkutiwake105;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNPTMTTKNGKUTIWAKE105)
    public String getZrnptmttkngkutiwake105() {
        return zrnptmttkngkutiwake105;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnptmttkngkutiwake105(String pZrnptmttkngkutiwake105) {
        zrnptmttkngkutiwake105 = pZrnptmttkngkutiwake105;
    }

    private String zrnptmttkngkutiwake205;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNPTMTTKNGKUTIWAKE205)
    public String getZrnptmttkngkutiwake205() {
        return zrnptmttkngkutiwake205;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnptmttkngkutiwake205(String pZrnptmttkngkutiwake205) {
        zrnptmttkngkutiwake205 = pZrnptmttkngkutiwake205;
    }

    private String zrnmvaarinenoutouym06;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARINENOUTOUYM06)
    public String getZrnmvaarinenoutouym06() {
        return zrnmvaarinenoutouym06;
    }

    @DataConvert("toMultiByte")
    public void setZrnmvaarinenoutouym06(String pZrnmvaarinenoutouym06) {
        zrnmvaarinenoutouym06 = pZrnmvaarinenoutouym06;
    }

    private String zrnmvaarisisuuupritu06;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARISISUUUPRITU06)
    public String getZrnmvaarisisuuupritu06() {
        return zrnmvaarisisuuupritu06;
    }

    @DataConvert("toMultiByte")
    public void setZrnmvaarisisuuupritu06(String pZrnmvaarisisuuupritu06) {
        zrnmvaarisisuuupritu06 = pZrnmvaarisisuuupritu06;
    }

    private String zrnmvaaritmttknzkritu06;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARITMTTKNZKRITU06)
    public String getZrnmvaaritmttknzkritu06() {
        return zrnmvaaritmttknzkritu06;
    }

    @DataConvert("toMultiByte")
    public void setZrnmvaaritmttknzkritu06(String pZrnmvaaritmttknzkritu06) {
        zrnmvaaritmttknzkritu06 = pZrnmvaaritmttknzkritu06;
    }

    private String zrnmvaariwtuktypeup06;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARIWTUKTYPEUP06)
    public String getZrnmvaariwtuktypeup06() {
        return zrnmvaariwtuktypeup06;
    }

    public void setZrnmvaariwtuktypeup06(String pZrnmvaariwtuktypeup06) {
        zrnmvaariwtuktypeup06 = pZrnmvaariwtuktypeup06;
    }

    private String zrnmvaaritmttknkykkjmup06;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARITMTTKNKYKKJMUP06)
    public String getZrnmvaaritmttknkykkjmup06() {
        return zrnmvaaritmttknkykkjmup06;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnmvaaritmttknkykkjmup06(String pZrnmvaaritmttknkykkjmup06) {
        zrnmvaaritmttknkykkjmup06 = pZrnmvaaritmttknkykkjmup06;
    }

    private String zrnmvaariwup06;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARIWUP06)
    public String getZrnmvaariwup06() {
        return zrnmvaariwup06;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnmvaariwup06(String pZrnmvaariwup06) {
        zrnmvaariwup06 = pZrnmvaariwup06;
    }

    private String zrnmvaariwyentuktypeup06;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARIWYENTUKTYPEUP06)
    public String getZrnmvaariwyentuktypeup06() {
        return zrnmvaariwyentuktypeup06;
    }

    public void setZrnmvaariwyentuktypeup06(String pZrnmvaariwyentuktypeup06) {
        zrnmvaariwyentuktypeup06 = pZrnmvaariwyentuktypeup06;
    }

    private String zrnmvaariwupyendaka06;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARIWUPYENDAKA06)
    public String getZrnmvaariwupyendaka06() {
        return zrnmvaariwupyendaka06;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnmvaariwupyendaka06(String pZrnmvaariwupyendaka06) {
        zrnmvaariwupyendaka06 = pZrnmvaariwupyendaka06;
    }

    private String zrnmvaariwupyenkijyun06;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARIWUPYENKIJYUN06)
    public String getZrnmvaariwupyenkijyun06() {
        return zrnmvaariwupyenkijyun06;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnmvaariwupyenkijyun06(String pZrnmvaariwupyenkijyun06) {
        zrnmvaariwupyenkijyun06 = pZrnmvaariwupyenkijyun06;
    }

    private String zrnmvaariwupyenyasu06;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARIWUPYENYASU06)
    public String getZrnmvaariwupyenyasu06() {
        return zrnmvaariwupyenyasu06;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnmvaariwupyenyasu06(String pZrnmvaariwupyenyasu06) {
        zrnmvaariwupyenyasu06 = pZrnmvaariwupyenyasu06;
    }

    private String zrnmvaariwumupyendaka06;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARIWUMUPYENDAKA06)
    public String getZrnmvaariwumupyendaka06() {
        return zrnmvaariwumupyendaka06;
    }

    public void setZrnmvaariwumupyendaka06(String pZrnmvaariwumupyendaka06) {
        zrnmvaariwumupyendaka06 = pZrnmvaariwumupyendaka06;
    }

    private String zrnmvaariumupyenkijyun06;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARIUMUPYENKIJYUN06)
    public String getZrnmvaariumupyenkijyun06() {
        return zrnmvaariumupyenkijyun06;
    }

    public void setZrnmvaariumupyenkijyun06(String pZrnmvaariumupyenkijyun06) {
        zrnmvaariumupyenkijyun06 = pZrnmvaariumupyenkijyun06;
    }

    private String zrnmvaariumupyenyasu06;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARIUMUPYENYASU06)
    public String getZrnmvaariumupyenyasu06() {
        return zrnmvaariumupyenyasu06;
    }

    public void setZrnmvaariumupyenyasu06(String pZrnmvaariumupyenyasu06) {
        zrnmvaariumupyenyasu06 = pZrnmvaariumupyenyasu06;
    }

    private String zrnmvaariwtuktypesame06;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARIWTUKTYPESAME06)
    public String getZrnmvaariwtuktypesame06() {
        return zrnmvaariwtuktypesame06;
    }

    public void setZrnmvaariwtuktypesame06(String pZrnmvaariwtuktypesame06) {
        zrnmvaariwtuktypesame06 = pZrnmvaariwtuktypesame06;
    }

    private String zrnmvaaritmttknkykkjmsame06;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARITMTTKNKYKKJMSAME06)
    public String getZrnmvaaritmttknkykkjmsame06() {
        return zrnmvaaritmttknkykkjmsame06;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnmvaaritmttknkykkjmsame06(String pZrnmvaaritmttknkykkjmsame06) {
        zrnmvaaritmttknkykkjmsame06 = pZrnmvaaritmttknkykkjmsame06;
    }

    private String zrnmvaariwsame06;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARIWSAME06)
    public String getZrnmvaariwsame06() {
        return zrnmvaariwsame06;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnmvaariwsame06(String pZrnmvaariwsame06) {
        zrnmvaariwsame06 = pZrnmvaariwsame06;
    }

    private String zrnmvaariwyentuktypesame06;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARIWYENTUKTYPESAME06)
    public String getZrnmvaariwyentuktypesame06() {
        return zrnmvaariwyentuktypesame06;
    }

    public void setZrnmvaariwyentuktypesame06(String pZrnmvaariwyentuktypesame06) {
        zrnmvaariwyentuktypesame06 = pZrnmvaariwyentuktypesame06;
    }

    private String zrnmvaariwsameyendaka06;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARIWSAMEYENDAKA06)
    public String getZrnmvaariwsameyendaka06() {
        return zrnmvaariwsameyendaka06;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnmvaariwsameyendaka06(String pZrnmvaariwsameyendaka06) {
        zrnmvaariwsameyendaka06 = pZrnmvaariwsameyendaka06;
    }

    private String zrnmvaariwsameyenkijyun06;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARIWSAMEYENKIJYUN06)
    public String getZrnmvaariwsameyenkijyun06() {
        return zrnmvaariwsameyenkijyun06;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnmvaariwsameyenkijyun06(String pZrnmvaariwsameyenkijyun06) {
        zrnmvaariwsameyenkijyun06 = pZrnmvaariwsameyenkijyun06;
    }

    private String zrnmvaariwsameyenyasu06;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARIWSAMEYENYASU06)
    public String getZrnmvaariwsameyenyasu06() {
        return zrnmvaariwsameyenyasu06;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnmvaariwsameyenyasu06(String pZrnmvaariwsameyenyasu06) {
        zrnmvaariwsameyenyasu06 = pZrnmvaariwsameyenyasu06;
    }

    private String zrnmvaariumsameyendaka06;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARIUMSAMEYENDAKA06)
    public String getZrnmvaariumsameyendaka06() {
        return zrnmvaariumsameyendaka06;
    }

    public void setZrnmvaariumsameyendaka06(String pZrnmvaariumsameyendaka06) {
        zrnmvaariumsameyendaka06 = pZrnmvaariumsameyendaka06;
    }

    private String zrnmvaariumsameyenkijyun06;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARIUMSAMEYENKIJYUN06)
    public String getZrnmvaariumsameyenkijyun06() {
        return zrnmvaariumsameyenkijyun06;
    }

    public void setZrnmvaariumsameyenkijyun06(String pZrnmvaariumsameyenkijyun06) {
        zrnmvaariumsameyenkijyun06 = pZrnmvaariumsameyenkijyun06;
    }

    private String zrnmvaariumsameyenyasu06;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARIUMSAMEYENYASU06)
    public String getZrnmvaariumsameyenyasu06() {
        return zrnmvaariumsameyenyasu06;
    }

    public void setZrnmvaariumsameyenyasu06(String pZrnmvaariumsameyenyasu06) {
        zrnmvaariumsameyenyasu06 = pZrnmvaariumsameyenyasu06;
    }

    private String zrnmvaariwtuktypedown06;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARIWTUKTYPEDOWN06)
    public String getZrnmvaariwtuktypedown06() {
        return zrnmvaariwtuktypedown06;
    }

    public void setZrnmvaariwtuktypedown06(String pZrnmvaariwtuktypedown06) {
        zrnmvaariwtuktypedown06 = pZrnmvaariwtuktypedown06;
    }

    private String zrnmvaaritmttknkykkjmdown06;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARITMTTKNKYKKJMDOWN06)
    public String getZrnmvaaritmttknkykkjmdown06() {
        return zrnmvaaritmttknkykkjmdown06;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnmvaaritmttknkykkjmdown06(String pZrnmvaaritmttknkykkjmdown06) {
        zrnmvaaritmttknkykkjmdown06 = pZrnmvaaritmttknkykkjmdown06;
    }

    private String zrnmvaariwdown06;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARIWDOWN06)
    public String getZrnmvaariwdown06() {
        return zrnmvaariwdown06;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnmvaariwdown06(String pZrnmvaariwdown06) {
        zrnmvaariwdown06 = pZrnmvaariwdown06;
    }

    private String zrnmvaariwyentuktypedown06;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARIWYENTUKTYPEDOWN06)
    public String getZrnmvaariwyentuktypedown06() {
        return zrnmvaariwyentuktypedown06;
    }

    public void setZrnmvaariwyentuktypedown06(String pZrnmvaariwyentuktypedown06) {
        zrnmvaariwyentuktypedown06 = pZrnmvaariwyentuktypedown06;
    }

    private String zrnmvaariwdownyendaka06;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARIWDOWNYENDAKA06)
    public String getZrnmvaariwdownyendaka06() {
        return zrnmvaariwdownyendaka06;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnmvaariwdownyendaka06(String pZrnmvaariwdownyendaka06) {
        zrnmvaariwdownyendaka06 = pZrnmvaariwdownyendaka06;
    }

    private String zrnmvaariwdownyenkijyun06;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARIWDOWNYENKIJYUN06)
    public String getZrnmvaariwdownyenkijyun06() {
        return zrnmvaariwdownyenkijyun06;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnmvaariwdownyenkijyun06(String pZrnmvaariwdownyenkijyun06) {
        zrnmvaariwdownyenkijyun06 = pZrnmvaariwdownyenkijyun06;
    }

    private String zrnmvaariwdownyenyasu06;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARIWDOWNYENYASU06)
    public String getZrnmvaariwdownyenyasu06() {
        return zrnmvaariwdownyenyasu06;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnmvaariwdownyenyasu06(String pZrnmvaariwdownyenyasu06) {
        zrnmvaariwdownyenyasu06 = pZrnmvaariwdownyenyasu06;
    }

    private String zrnmvaariumdownyendaka06;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARIUMDOWNYENDAKA06)
    public String getZrnmvaariumdownyendaka06() {
        return zrnmvaariumdownyendaka06;
    }

    public void setZrnmvaariumdownyendaka06(String pZrnmvaariumdownyendaka06) {
        zrnmvaariumdownyendaka06 = pZrnmvaariumdownyendaka06;
    }

    private String zrnmvaariumdownyenkijyun06;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARIUMDOWNYENKIJYUN06)
    public String getZrnmvaariumdownyenkijyun06() {
        return zrnmvaariumdownyenkijyun06;
    }

    public void setZrnmvaariumdownyenkijyun06(String pZrnmvaariumdownyenkijyun06) {
        zrnmvaariumdownyenkijyun06 = pZrnmvaariumdownyenkijyun06;
    }

    private String zrnmvaariumdownyenyasu06;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARIUMDOWNYENYASU06)
    public String getZrnmvaariumdownyenyasu06() {
        return zrnmvaariumdownyenyasu06;
    }

    public void setZrnmvaariumdownyenyasu06(String pZrnmvaariumdownyenyasu06) {
        zrnmvaariumdownyenyasu06 = pZrnmvaariumdownyenyasu06;
    }

    private String zrnmvaarivtuktype06;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARIVTUKTYPE06)
    public String getZrnmvaarivtuktype06() {
        return zrnmvaarivtuktype06;
    }

    public void setZrnmvaarivtuktype06(String pZrnmvaarivtuktype06) {
        zrnmvaarivtuktype06 = pZrnmvaarivtuktype06;
    }

    private String zrnmvaariv06;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARIV06)
    public String getZrnmvaariv06() {
        return zrnmvaariv06;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnmvaariv06(String pZrnmvaariv06) {
        zrnmvaariv06 = pZrnmvaariv06;
    }

    private String zrnptmttkngkutiwake106;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNPTMTTKNGKUTIWAKE106)
    public String getZrnptmttkngkutiwake106() {
        return zrnptmttkngkutiwake106;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnptmttkngkutiwake106(String pZrnptmttkngkutiwake106) {
        zrnptmttkngkutiwake106 = pZrnptmttkngkutiwake106;
    }

    private String zrnptmttkngkutiwake206;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNPTMTTKNGKUTIWAKE206)
    public String getZrnptmttkngkutiwake206() {
        return zrnptmttkngkutiwake206;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnptmttkngkutiwake206(String pZrnptmttkngkutiwake206) {
        zrnptmttkngkutiwake206 = pZrnptmttkngkutiwake206;
    }

    private String zrnmvaarinenoutouym07;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARINENOUTOUYM07)
    public String getZrnmvaarinenoutouym07() {
        return zrnmvaarinenoutouym07;
    }

    @DataConvert("toMultiByte")
    public void setZrnmvaarinenoutouym07(String pZrnmvaarinenoutouym07) {
        zrnmvaarinenoutouym07 = pZrnmvaarinenoutouym07;
    }

    private String zrnmvaarisisuuupritu07;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARISISUUUPRITU07)
    public String getZrnmvaarisisuuupritu07() {
        return zrnmvaarisisuuupritu07;
    }

    @DataConvert("toMultiByte")
    public void setZrnmvaarisisuuupritu07(String pZrnmvaarisisuuupritu07) {
        zrnmvaarisisuuupritu07 = pZrnmvaarisisuuupritu07;
    }

    private String zrnmvaaritmttknzkritu07;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARITMTTKNZKRITU07)
    public String getZrnmvaaritmttknzkritu07() {
        return zrnmvaaritmttknzkritu07;
    }

    @DataConvert("toMultiByte")
    public void setZrnmvaaritmttknzkritu07(String pZrnmvaaritmttknzkritu07) {
        zrnmvaaritmttknzkritu07 = pZrnmvaaritmttknzkritu07;
    }

    private String zrnmvaariwtuktypeup07;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARIWTUKTYPEUP07)
    public String getZrnmvaariwtuktypeup07() {
        return zrnmvaariwtuktypeup07;
    }

    public void setZrnmvaariwtuktypeup07(String pZrnmvaariwtuktypeup07) {
        zrnmvaariwtuktypeup07 = pZrnmvaariwtuktypeup07;
    }

    private String zrnmvaaritmttknkykkjmup07;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARITMTTKNKYKKJMUP07)
    public String getZrnmvaaritmttknkykkjmup07() {
        return zrnmvaaritmttknkykkjmup07;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnmvaaritmttknkykkjmup07(String pZrnmvaaritmttknkykkjmup07) {
        zrnmvaaritmttknkykkjmup07 = pZrnmvaaritmttknkykkjmup07;
    }

    private String zrnmvaariwup07;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARIWUP07)
    public String getZrnmvaariwup07() {
        return zrnmvaariwup07;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnmvaariwup07(String pZrnmvaariwup07) {
        zrnmvaariwup07 = pZrnmvaariwup07;
    }

    private String zrnmvaariwyentuktypeup07;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARIWYENTUKTYPEUP07)
    public String getZrnmvaariwyentuktypeup07() {
        return zrnmvaariwyentuktypeup07;
    }

    public void setZrnmvaariwyentuktypeup07(String pZrnmvaariwyentuktypeup07) {
        zrnmvaariwyentuktypeup07 = pZrnmvaariwyentuktypeup07;
    }

    private String zrnmvaariwupyendaka07;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARIWUPYENDAKA07)
    public String getZrnmvaariwupyendaka07() {
        return zrnmvaariwupyendaka07;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnmvaariwupyendaka07(String pZrnmvaariwupyendaka07) {
        zrnmvaariwupyendaka07 = pZrnmvaariwupyendaka07;
    }

    private String zrnmvaariwupyenkijyun07;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARIWUPYENKIJYUN07)
    public String getZrnmvaariwupyenkijyun07() {
        return zrnmvaariwupyenkijyun07;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnmvaariwupyenkijyun07(String pZrnmvaariwupyenkijyun07) {
        zrnmvaariwupyenkijyun07 = pZrnmvaariwupyenkijyun07;
    }

    private String zrnmvaariwupyenyasu07;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARIWUPYENYASU07)
    public String getZrnmvaariwupyenyasu07() {
        return zrnmvaariwupyenyasu07;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnmvaariwupyenyasu07(String pZrnmvaariwupyenyasu07) {
        zrnmvaariwupyenyasu07 = pZrnmvaariwupyenyasu07;
    }

    private String zrnmvaariwumupyendaka07;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARIWUMUPYENDAKA07)
    public String getZrnmvaariwumupyendaka07() {
        return zrnmvaariwumupyendaka07;
    }

    public void setZrnmvaariwumupyendaka07(String pZrnmvaariwumupyendaka07) {
        zrnmvaariwumupyendaka07 = pZrnmvaariwumupyendaka07;
    }

    private String zrnmvaariumupyenkijyun07;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARIUMUPYENKIJYUN07)
    public String getZrnmvaariumupyenkijyun07() {
        return zrnmvaariumupyenkijyun07;
    }

    public void setZrnmvaariumupyenkijyun07(String pZrnmvaariumupyenkijyun07) {
        zrnmvaariumupyenkijyun07 = pZrnmvaariumupyenkijyun07;
    }

    private String zrnmvaariumupyenyasu07;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARIUMUPYENYASU07)
    public String getZrnmvaariumupyenyasu07() {
        return zrnmvaariumupyenyasu07;
    }

    public void setZrnmvaariumupyenyasu07(String pZrnmvaariumupyenyasu07) {
        zrnmvaariumupyenyasu07 = pZrnmvaariumupyenyasu07;
    }

    private String zrnmvaariwtuktypesame07;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARIWTUKTYPESAME07)
    public String getZrnmvaariwtuktypesame07() {
        return zrnmvaariwtuktypesame07;
    }

    public void setZrnmvaariwtuktypesame07(String pZrnmvaariwtuktypesame07) {
        zrnmvaariwtuktypesame07 = pZrnmvaariwtuktypesame07;
    }

    private String zrnmvaaritmttknkykkjmsame07;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARITMTTKNKYKKJMSAME07)
    public String getZrnmvaaritmttknkykkjmsame07() {
        return zrnmvaaritmttknkykkjmsame07;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnmvaaritmttknkykkjmsame07(String pZrnmvaaritmttknkykkjmsame07) {
        zrnmvaaritmttknkykkjmsame07 = pZrnmvaaritmttknkykkjmsame07;
    }

    private String zrnmvaariwsame07;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARIWSAME07)
    public String getZrnmvaariwsame07() {
        return zrnmvaariwsame07;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnmvaariwsame07(String pZrnmvaariwsame07) {
        zrnmvaariwsame07 = pZrnmvaariwsame07;
    }

    private String zrnmvaariwyentuktypesame07;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARIWYENTUKTYPESAME07)
    public String getZrnmvaariwyentuktypesame07() {
        return zrnmvaariwyentuktypesame07;
    }

    public void setZrnmvaariwyentuktypesame07(String pZrnmvaariwyentuktypesame07) {
        zrnmvaariwyentuktypesame07 = pZrnmvaariwyentuktypesame07;
    }

    private String zrnmvaariwsameyendaka07;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARIWSAMEYENDAKA07)
    public String getZrnmvaariwsameyendaka07() {
        return zrnmvaariwsameyendaka07;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnmvaariwsameyendaka07(String pZrnmvaariwsameyendaka07) {
        zrnmvaariwsameyendaka07 = pZrnmvaariwsameyendaka07;
    }

    private String zrnmvaariwsameyenkijyun07;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARIWSAMEYENKIJYUN07)
    public String getZrnmvaariwsameyenkijyun07() {
        return zrnmvaariwsameyenkijyun07;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnmvaariwsameyenkijyun07(String pZrnmvaariwsameyenkijyun07) {
        zrnmvaariwsameyenkijyun07 = pZrnmvaariwsameyenkijyun07;
    }

    private String zrnmvaariwsameyenyasu07;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARIWSAMEYENYASU07)
    public String getZrnmvaariwsameyenyasu07() {
        return zrnmvaariwsameyenyasu07;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnmvaariwsameyenyasu07(String pZrnmvaariwsameyenyasu07) {
        zrnmvaariwsameyenyasu07 = pZrnmvaariwsameyenyasu07;
    }

    private String zrnmvaariumsameyendaka07;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARIUMSAMEYENDAKA07)
    public String getZrnmvaariumsameyendaka07() {
        return zrnmvaariumsameyendaka07;
    }

    public void setZrnmvaariumsameyendaka07(String pZrnmvaariumsameyendaka07) {
        zrnmvaariumsameyendaka07 = pZrnmvaariumsameyendaka07;
    }

    private String zrnmvaariumsameyenkijyun07;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARIUMSAMEYENKIJYUN07)
    public String getZrnmvaariumsameyenkijyun07() {
        return zrnmvaariumsameyenkijyun07;
    }

    public void setZrnmvaariumsameyenkijyun07(String pZrnmvaariumsameyenkijyun07) {
        zrnmvaariumsameyenkijyun07 = pZrnmvaariumsameyenkijyun07;
    }

    private String zrnmvaariumsameyenyasu07;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARIUMSAMEYENYASU07)
    public String getZrnmvaariumsameyenyasu07() {
        return zrnmvaariumsameyenyasu07;
    }

    public void setZrnmvaariumsameyenyasu07(String pZrnmvaariumsameyenyasu07) {
        zrnmvaariumsameyenyasu07 = pZrnmvaariumsameyenyasu07;
    }

    private String zrnmvaariwtuktypedown07;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARIWTUKTYPEDOWN07)
    public String getZrnmvaariwtuktypedown07() {
        return zrnmvaariwtuktypedown07;
    }

    public void setZrnmvaariwtuktypedown07(String pZrnmvaariwtuktypedown07) {
        zrnmvaariwtuktypedown07 = pZrnmvaariwtuktypedown07;
    }

    private String zrnmvaaritmttknkykkjmdown07;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARITMTTKNKYKKJMDOWN07)
    public String getZrnmvaaritmttknkykkjmdown07() {
        return zrnmvaaritmttknkykkjmdown07;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnmvaaritmttknkykkjmdown07(String pZrnmvaaritmttknkykkjmdown07) {
        zrnmvaaritmttknkykkjmdown07 = pZrnmvaaritmttknkykkjmdown07;
    }

    private String zrnmvaariwdown07;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARIWDOWN07)
    public String getZrnmvaariwdown07() {
        return zrnmvaariwdown07;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnmvaariwdown07(String pZrnmvaariwdown07) {
        zrnmvaariwdown07 = pZrnmvaariwdown07;
    }

    private String zrnmvaariwyentuktypedown07;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARIWYENTUKTYPEDOWN07)
    public String getZrnmvaariwyentuktypedown07() {
        return zrnmvaariwyentuktypedown07;
    }

    public void setZrnmvaariwyentuktypedown07(String pZrnmvaariwyentuktypedown07) {
        zrnmvaariwyentuktypedown07 = pZrnmvaariwyentuktypedown07;
    }

    private String zrnmvaariwdownyendaka07;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARIWDOWNYENDAKA07)
    public String getZrnmvaariwdownyendaka07() {
        return zrnmvaariwdownyendaka07;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnmvaariwdownyendaka07(String pZrnmvaariwdownyendaka07) {
        zrnmvaariwdownyendaka07 = pZrnmvaariwdownyendaka07;
    }

    private String zrnmvaariwdownyenkijyun07;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARIWDOWNYENKIJYUN07)
    public String getZrnmvaariwdownyenkijyun07() {
        return zrnmvaariwdownyenkijyun07;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnmvaariwdownyenkijyun07(String pZrnmvaariwdownyenkijyun07) {
        zrnmvaariwdownyenkijyun07 = pZrnmvaariwdownyenkijyun07;
    }

    private String zrnmvaariwdownyenyasu07;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARIWDOWNYENYASU07)
    public String getZrnmvaariwdownyenyasu07() {
        return zrnmvaariwdownyenyasu07;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnmvaariwdownyenyasu07(String pZrnmvaariwdownyenyasu07) {
        zrnmvaariwdownyenyasu07 = pZrnmvaariwdownyenyasu07;
    }

    private String zrnmvaariumdownyendaka07;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARIUMDOWNYENDAKA07)
    public String getZrnmvaariumdownyendaka07() {
        return zrnmvaariumdownyendaka07;
    }

    public void setZrnmvaariumdownyendaka07(String pZrnmvaariumdownyendaka07) {
        zrnmvaariumdownyendaka07 = pZrnmvaariumdownyendaka07;
    }

    private String zrnmvaariumdownyenkijyun07;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARIUMDOWNYENKIJYUN07)
    public String getZrnmvaariumdownyenkijyun07() {
        return zrnmvaariumdownyenkijyun07;
    }

    public void setZrnmvaariumdownyenkijyun07(String pZrnmvaariumdownyenkijyun07) {
        zrnmvaariumdownyenkijyun07 = pZrnmvaariumdownyenkijyun07;
    }

    private String zrnmvaariumdownyenyasu07;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARIUMDOWNYENYASU07)
    public String getZrnmvaariumdownyenyasu07() {
        return zrnmvaariumdownyenyasu07;
    }

    public void setZrnmvaariumdownyenyasu07(String pZrnmvaariumdownyenyasu07) {
        zrnmvaariumdownyenyasu07 = pZrnmvaariumdownyenyasu07;
    }

    private String zrnmvaarivtuktype07;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARIVTUKTYPE07)
    public String getZrnmvaarivtuktype07() {
        return zrnmvaarivtuktype07;
    }

    public void setZrnmvaarivtuktype07(String pZrnmvaarivtuktype07) {
        zrnmvaarivtuktype07 = pZrnmvaarivtuktype07;
    }

    private String zrnmvaariv07;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARIV07)
    public String getZrnmvaariv07() {
        return zrnmvaariv07;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnmvaariv07(String pZrnmvaariv07) {
        zrnmvaariv07 = pZrnmvaariv07;
    }

    private String zrnptmttkngkutiwake107;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNPTMTTKNGKUTIWAKE107)
    public String getZrnptmttkngkutiwake107() {
        return zrnptmttkngkutiwake107;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnptmttkngkutiwake107(String pZrnptmttkngkutiwake107) {
        zrnptmttkngkutiwake107 = pZrnptmttkngkutiwake107;
    }

    private String zrnptmttkngkutiwake207;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNPTMTTKNGKUTIWAKE207)
    public String getZrnptmttkngkutiwake207() {
        return zrnptmttkngkutiwake207;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnptmttkngkutiwake207(String pZrnptmttkngkutiwake207) {
        zrnptmttkngkutiwake207 = pZrnptmttkngkutiwake207;
    }

    private String zrnmvaarinenoutouym08;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARINENOUTOUYM08)
    public String getZrnmvaarinenoutouym08() {
        return zrnmvaarinenoutouym08;
    }

    @DataConvert("toMultiByte")
    public void setZrnmvaarinenoutouym08(String pZrnmvaarinenoutouym08) {
        zrnmvaarinenoutouym08 = pZrnmvaarinenoutouym08;
    }

    private String zrnmvaarisisuuupritu08;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARISISUUUPRITU08)
    public String getZrnmvaarisisuuupritu08() {
        return zrnmvaarisisuuupritu08;
    }

    @DataConvert("toMultiByte")
    public void setZrnmvaarisisuuupritu08(String pZrnmvaarisisuuupritu08) {
        zrnmvaarisisuuupritu08 = pZrnmvaarisisuuupritu08;
    }

    private String zrnmvaaritmttknzkritu08;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARITMTTKNZKRITU08)
    public String getZrnmvaaritmttknzkritu08() {
        return zrnmvaaritmttknzkritu08;
    }

    @DataConvert("toMultiByte")
    public void setZrnmvaaritmttknzkritu08(String pZrnmvaaritmttknzkritu08) {
        zrnmvaaritmttknzkritu08 = pZrnmvaaritmttknzkritu08;
    }

    private String zrnmvaariwtuktypeup08;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARIWTUKTYPEUP08)
    public String getZrnmvaariwtuktypeup08() {
        return zrnmvaariwtuktypeup08;
    }

    public void setZrnmvaariwtuktypeup08(String pZrnmvaariwtuktypeup08) {
        zrnmvaariwtuktypeup08 = pZrnmvaariwtuktypeup08;
    }

    private String zrnmvaaritmttknkykkjmup08;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARITMTTKNKYKKJMUP08)
    public String getZrnmvaaritmttknkykkjmup08() {
        return zrnmvaaritmttknkykkjmup08;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnmvaaritmttknkykkjmup08(String pZrnmvaaritmttknkykkjmup08) {
        zrnmvaaritmttknkykkjmup08 = pZrnmvaaritmttknkykkjmup08;
    }

    private String zrnmvaariwup08;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARIWUP08)
    public String getZrnmvaariwup08() {
        return zrnmvaariwup08;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnmvaariwup08(String pZrnmvaariwup08) {
        zrnmvaariwup08 = pZrnmvaariwup08;
    }

    private String zrnmvaariwyentuktypeup08;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARIWYENTUKTYPEUP08)
    public String getZrnmvaariwyentuktypeup08() {
        return zrnmvaariwyentuktypeup08;
    }

    public void setZrnmvaariwyentuktypeup08(String pZrnmvaariwyentuktypeup08) {
        zrnmvaariwyentuktypeup08 = pZrnmvaariwyentuktypeup08;
    }

    private String zrnmvaariwupyendaka08;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARIWUPYENDAKA08)
    public String getZrnmvaariwupyendaka08() {
        return zrnmvaariwupyendaka08;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnmvaariwupyendaka08(String pZrnmvaariwupyendaka08) {
        zrnmvaariwupyendaka08 = pZrnmvaariwupyendaka08;
    }

    private String zrnmvaariwupyenkijyun08;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARIWUPYENKIJYUN08)
    public String getZrnmvaariwupyenkijyun08() {
        return zrnmvaariwupyenkijyun08;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnmvaariwupyenkijyun08(String pZrnmvaariwupyenkijyun08) {
        zrnmvaariwupyenkijyun08 = pZrnmvaariwupyenkijyun08;
    }

    private String zrnmvaariwupyenyasu08;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARIWUPYENYASU08)
    public String getZrnmvaariwupyenyasu08() {
        return zrnmvaariwupyenyasu08;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnmvaariwupyenyasu08(String pZrnmvaariwupyenyasu08) {
        zrnmvaariwupyenyasu08 = pZrnmvaariwupyenyasu08;
    }

    private String zrnmvaariwumupyendaka08;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARIWUMUPYENDAKA08)
    public String getZrnmvaariwumupyendaka08() {
        return zrnmvaariwumupyendaka08;
    }

    public void setZrnmvaariwumupyendaka08(String pZrnmvaariwumupyendaka08) {
        zrnmvaariwumupyendaka08 = pZrnmvaariwumupyendaka08;
    }

    private String zrnmvaariumupyenkijyun08;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARIUMUPYENKIJYUN08)
    public String getZrnmvaariumupyenkijyun08() {
        return zrnmvaariumupyenkijyun08;
    }

    public void setZrnmvaariumupyenkijyun08(String pZrnmvaariumupyenkijyun08) {
        zrnmvaariumupyenkijyun08 = pZrnmvaariumupyenkijyun08;
    }

    private String zrnmvaariumupyenyasu08;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARIUMUPYENYASU08)
    public String getZrnmvaariumupyenyasu08() {
        return zrnmvaariumupyenyasu08;
    }

    public void setZrnmvaariumupyenyasu08(String pZrnmvaariumupyenyasu08) {
        zrnmvaariumupyenyasu08 = pZrnmvaariumupyenyasu08;
    }

    private String zrnmvaariwtuktypesame08;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARIWTUKTYPESAME08)
    public String getZrnmvaariwtuktypesame08() {
        return zrnmvaariwtuktypesame08;
    }

    public void setZrnmvaariwtuktypesame08(String pZrnmvaariwtuktypesame08) {
        zrnmvaariwtuktypesame08 = pZrnmvaariwtuktypesame08;
    }

    private String zrnmvaaritmttknkykkjmsame08;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARITMTTKNKYKKJMSAME08)
    public String getZrnmvaaritmttknkykkjmsame08() {
        return zrnmvaaritmttknkykkjmsame08;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnmvaaritmttknkykkjmsame08(String pZrnmvaaritmttknkykkjmsame08) {
        zrnmvaaritmttknkykkjmsame08 = pZrnmvaaritmttknkykkjmsame08;
    }

    private String zrnmvaariwsame08;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARIWSAME08)
    public String getZrnmvaariwsame08() {
        return zrnmvaariwsame08;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnmvaariwsame08(String pZrnmvaariwsame08) {
        zrnmvaariwsame08 = pZrnmvaariwsame08;
    }

    private String zrnmvaariwyentuktypesame08;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARIWYENTUKTYPESAME08)
    public String getZrnmvaariwyentuktypesame08() {
        return zrnmvaariwyentuktypesame08;
    }

    public void setZrnmvaariwyentuktypesame08(String pZrnmvaariwyentuktypesame08) {
        zrnmvaariwyentuktypesame08 = pZrnmvaariwyentuktypesame08;
    }

    private String zrnmvaariwsameyendaka08;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARIWSAMEYENDAKA08)
    public String getZrnmvaariwsameyendaka08() {
        return zrnmvaariwsameyendaka08;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnmvaariwsameyendaka08(String pZrnmvaariwsameyendaka08) {
        zrnmvaariwsameyendaka08 = pZrnmvaariwsameyendaka08;
    }

    private String zrnmvaariwsameyenkijyun08;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARIWSAMEYENKIJYUN08)
    public String getZrnmvaariwsameyenkijyun08() {
        return zrnmvaariwsameyenkijyun08;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnmvaariwsameyenkijyun08(String pZrnmvaariwsameyenkijyun08) {
        zrnmvaariwsameyenkijyun08 = pZrnmvaariwsameyenkijyun08;
    }

    private String zrnmvaariwsameyenyasu08;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARIWSAMEYENYASU08)
    public String getZrnmvaariwsameyenyasu08() {
        return zrnmvaariwsameyenyasu08;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnmvaariwsameyenyasu08(String pZrnmvaariwsameyenyasu08) {
        zrnmvaariwsameyenyasu08 = pZrnmvaariwsameyenyasu08;
    }

    private String zrnmvaariumsameyendaka08;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARIUMSAMEYENDAKA08)
    public String getZrnmvaariumsameyendaka08() {
        return zrnmvaariumsameyendaka08;
    }

    public void setZrnmvaariumsameyendaka08(String pZrnmvaariumsameyendaka08) {
        zrnmvaariumsameyendaka08 = pZrnmvaariumsameyendaka08;
    }

    private String zrnmvaariumsameyenkijyun08;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARIUMSAMEYENKIJYUN08)
    public String getZrnmvaariumsameyenkijyun08() {
        return zrnmvaariumsameyenkijyun08;
    }

    public void setZrnmvaariumsameyenkijyun08(String pZrnmvaariumsameyenkijyun08) {
        zrnmvaariumsameyenkijyun08 = pZrnmvaariumsameyenkijyun08;
    }

    private String zrnmvaariumsameyenyasu08;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARIUMSAMEYENYASU08)
    public String getZrnmvaariumsameyenyasu08() {
        return zrnmvaariumsameyenyasu08;
    }

    public void setZrnmvaariumsameyenyasu08(String pZrnmvaariumsameyenyasu08) {
        zrnmvaariumsameyenyasu08 = pZrnmvaariumsameyenyasu08;
    }

    private String zrnmvaariwtuktypedown08;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARIWTUKTYPEDOWN08)
    public String getZrnmvaariwtuktypedown08() {
        return zrnmvaariwtuktypedown08;
    }

    public void setZrnmvaariwtuktypedown08(String pZrnmvaariwtuktypedown08) {
        zrnmvaariwtuktypedown08 = pZrnmvaariwtuktypedown08;
    }

    private String zrnmvaaritmttknkykkjmdown08;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARITMTTKNKYKKJMDOWN08)
    public String getZrnmvaaritmttknkykkjmdown08() {
        return zrnmvaaritmttknkykkjmdown08;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnmvaaritmttknkykkjmdown08(String pZrnmvaaritmttknkykkjmdown08) {
        zrnmvaaritmttknkykkjmdown08 = pZrnmvaaritmttknkykkjmdown08;
    }

    private String zrnmvaariwdown08;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARIWDOWN08)
    public String getZrnmvaariwdown08() {
        return zrnmvaariwdown08;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnmvaariwdown08(String pZrnmvaariwdown08) {
        zrnmvaariwdown08 = pZrnmvaariwdown08;
    }

    private String zrnmvaariwyentuktypedown08;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARIWYENTUKTYPEDOWN08)
    public String getZrnmvaariwyentuktypedown08() {
        return zrnmvaariwyentuktypedown08;
    }

    public void setZrnmvaariwyentuktypedown08(String pZrnmvaariwyentuktypedown08) {
        zrnmvaariwyentuktypedown08 = pZrnmvaariwyentuktypedown08;
    }

    private String zrnmvaariwdownyendaka08;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARIWDOWNYENDAKA08)
    public String getZrnmvaariwdownyendaka08() {
        return zrnmvaariwdownyendaka08;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnmvaariwdownyendaka08(String pZrnmvaariwdownyendaka08) {
        zrnmvaariwdownyendaka08 = pZrnmvaariwdownyendaka08;
    }

    private String zrnmvaariwdownyenkijyun08;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARIWDOWNYENKIJYUN08)
    public String getZrnmvaariwdownyenkijyun08() {
        return zrnmvaariwdownyenkijyun08;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnmvaariwdownyenkijyun08(String pZrnmvaariwdownyenkijyun08) {
        zrnmvaariwdownyenkijyun08 = pZrnmvaariwdownyenkijyun08;
    }

    private String zrnmvaariwdownyenyasu08;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARIWDOWNYENYASU08)
    public String getZrnmvaariwdownyenyasu08() {
        return zrnmvaariwdownyenyasu08;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnmvaariwdownyenyasu08(String pZrnmvaariwdownyenyasu08) {
        zrnmvaariwdownyenyasu08 = pZrnmvaariwdownyenyasu08;
    }

    private String zrnmvaariumdownyendaka08;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARIUMDOWNYENDAKA08)
    public String getZrnmvaariumdownyendaka08() {
        return zrnmvaariumdownyendaka08;
    }

    public void setZrnmvaariumdownyendaka08(String pZrnmvaariumdownyendaka08) {
        zrnmvaariumdownyendaka08 = pZrnmvaariumdownyendaka08;
    }

    private String zrnmvaariumdownyenkijyun08;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARIUMDOWNYENKIJYUN08)
    public String getZrnmvaariumdownyenkijyun08() {
        return zrnmvaariumdownyenkijyun08;
    }

    public void setZrnmvaariumdownyenkijyun08(String pZrnmvaariumdownyenkijyun08) {
        zrnmvaariumdownyenkijyun08 = pZrnmvaariumdownyenkijyun08;
    }

    private String zrnmvaariumdownyenyasu08;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARIUMDOWNYENYASU08)
    public String getZrnmvaariumdownyenyasu08() {
        return zrnmvaariumdownyenyasu08;
    }

    public void setZrnmvaariumdownyenyasu08(String pZrnmvaariumdownyenyasu08) {
        zrnmvaariumdownyenyasu08 = pZrnmvaariumdownyenyasu08;
    }

    private String zrnmvaarivtuktype08;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARIVTUKTYPE08)
    public String getZrnmvaarivtuktype08() {
        return zrnmvaarivtuktype08;
    }

    public void setZrnmvaarivtuktype08(String pZrnmvaarivtuktype08) {
        zrnmvaarivtuktype08 = pZrnmvaarivtuktype08;
    }

    private String zrnmvaariv08;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARIV08)
    public String getZrnmvaariv08() {
        return zrnmvaariv08;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnmvaariv08(String pZrnmvaariv08) {
        zrnmvaariv08 = pZrnmvaariv08;
    }

    private String zrnptmttkngkutiwake108;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNPTMTTKNGKUTIWAKE108)
    public String getZrnptmttkngkutiwake108() {
        return zrnptmttkngkutiwake108;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnptmttkngkutiwake108(String pZrnptmttkngkutiwake108) {
        zrnptmttkngkutiwake108 = pZrnptmttkngkutiwake108;
    }

    private String zrnptmttkngkutiwake208;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNPTMTTKNGKUTIWAKE208)
    public String getZrnptmttkngkutiwake208() {
        return zrnptmttkngkutiwake208;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnptmttkngkutiwake208(String pZrnptmttkngkutiwake208) {
        zrnptmttkngkutiwake208 = pZrnptmttkngkutiwake208;
    }

    private String zrnmvaarinenoutouym09;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARINENOUTOUYM09)
    public String getZrnmvaarinenoutouym09() {
        return zrnmvaarinenoutouym09;
    }

    @DataConvert("toMultiByte")
    public void setZrnmvaarinenoutouym09(String pZrnmvaarinenoutouym09) {
        zrnmvaarinenoutouym09 = pZrnmvaarinenoutouym09;
    }

    private String zrnmvaarisisuuupritu09;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARISISUUUPRITU09)
    public String getZrnmvaarisisuuupritu09() {
        return zrnmvaarisisuuupritu09;
    }

    @DataConvert("toMultiByte")
    public void setZrnmvaarisisuuupritu09(String pZrnmvaarisisuuupritu09) {
        zrnmvaarisisuuupritu09 = pZrnmvaarisisuuupritu09;
    }

    private String zrnmvaaritmttknzkritu09;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARITMTTKNZKRITU09)
    public String getZrnmvaaritmttknzkritu09() {
        return zrnmvaaritmttknzkritu09;
    }

    @DataConvert("toMultiByte")
    public void setZrnmvaaritmttknzkritu09(String pZrnmvaaritmttknzkritu09) {
        zrnmvaaritmttknzkritu09 = pZrnmvaaritmttknzkritu09;
    }

    private String zrnmvaariwtuktypeup09;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARIWTUKTYPEUP09)
    public String getZrnmvaariwtuktypeup09() {
        return zrnmvaariwtuktypeup09;
    }

    public void setZrnmvaariwtuktypeup09(String pZrnmvaariwtuktypeup09) {
        zrnmvaariwtuktypeup09 = pZrnmvaariwtuktypeup09;
    }

    private String zrnmvaaritmttknkykkjmup09;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARITMTTKNKYKKJMUP09)
    public String getZrnmvaaritmttknkykkjmup09() {
        return zrnmvaaritmttknkykkjmup09;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnmvaaritmttknkykkjmup09(String pZrnmvaaritmttknkykkjmup09) {
        zrnmvaaritmttknkykkjmup09 = pZrnmvaaritmttknkykkjmup09;
    }

    private String zrnmvaariwup09;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARIWUP09)
    public String getZrnmvaariwup09() {
        return zrnmvaariwup09;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnmvaariwup09(String pZrnmvaariwup09) {
        zrnmvaariwup09 = pZrnmvaariwup09;
    }

    private String zrnmvaariwyentuktypeup09;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARIWYENTUKTYPEUP09)
    public String getZrnmvaariwyentuktypeup09() {
        return zrnmvaariwyentuktypeup09;
    }

    public void setZrnmvaariwyentuktypeup09(String pZrnmvaariwyentuktypeup09) {
        zrnmvaariwyentuktypeup09 = pZrnmvaariwyentuktypeup09;
    }

    private String zrnmvaariwupyendaka09;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARIWUPYENDAKA09)
    public String getZrnmvaariwupyendaka09() {
        return zrnmvaariwupyendaka09;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnmvaariwupyendaka09(String pZrnmvaariwupyendaka09) {
        zrnmvaariwupyendaka09 = pZrnmvaariwupyendaka09;
    }

    private String zrnmvaariwupyenkijyun09;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARIWUPYENKIJYUN09)
    public String getZrnmvaariwupyenkijyun09() {
        return zrnmvaariwupyenkijyun09;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnmvaariwupyenkijyun09(String pZrnmvaariwupyenkijyun09) {
        zrnmvaariwupyenkijyun09 = pZrnmvaariwupyenkijyun09;
    }

    private String zrnmvaariwupyenyasu09;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARIWUPYENYASU09)
    public String getZrnmvaariwupyenyasu09() {
        return zrnmvaariwupyenyasu09;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnmvaariwupyenyasu09(String pZrnmvaariwupyenyasu09) {
        zrnmvaariwupyenyasu09 = pZrnmvaariwupyenyasu09;
    }

    private String zrnmvaariwumupyendaka09;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARIWUMUPYENDAKA09)
    public String getZrnmvaariwumupyendaka09() {
        return zrnmvaariwumupyendaka09;
    }

    public void setZrnmvaariwumupyendaka09(String pZrnmvaariwumupyendaka09) {
        zrnmvaariwumupyendaka09 = pZrnmvaariwumupyendaka09;
    }

    private String zrnmvaariumupyenkijyun09;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARIUMUPYENKIJYUN09)
    public String getZrnmvaariumupyenkijyun09() {
        return zrnmvaariumupyenkijyun09;
    }

    public void setZrnmvaariumupyenkijyun09(String pZrnmvaariumupyenkijyun09) {
        zrnmvaariumupyenkijyun09 = pZrnmvaariumupyenkijyun09;
    }

    private String zrnmvaariumupyenyasu09;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARIUMUPYENYASU09)
    public String getZrnmvaariumupyenyasu09() {
        return zrnmvaariumupyenyasu09;
    }

    public void setZrnmvaariumupyenyasu09(String pZrnmvaariumupyenyasu09) {
        zrnmvaariumupyenyasu09 = pZrnmvaariumupyenyasu09;
    }

    private String zrnmvaariwtuktypesame09;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARIWTUKTYPESAME09)
    public String getZrnmvaariwtuktypesame09() {
        return zrnmvaariwtuktypesame09;
    }

    public void setZrnmvaariwtuktypesame09(String pZrnmvaariwtuktypesame09) {
        zrnmvaariwtuktypesame09 = pZrnmvaariwtuktypesame09;
    }

    private String zrnmvaaritmttknkykkjmsame09;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARITMTTKNKYKKJMSAME09)
    public String getZrnmvaaritmttknkykkjmsame09() {
        return zrnmvaaritmttknkykkjmsame09;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnmvaaritmttknkykkjmsame09(String pZrnmvaaritmttknkykkjmsame09) {
        zrnmvaaritmttknkykkjmsame09 = pZrnmvaaritmttknkykkjmsame09;
    }

    private String zrnmvaariwsame09;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARIWSAME09)
    public String getZrnmvaariwsame09() {
        return zrnmvaariwsame09;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnmvaariwsame09(String pZrnmvaariwsame09) {
        zrnmvaariwsame09 = pZrnmvaariwsame09;
    }

    private String zrnmvaariwyentuktypesame09;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARIWYENTUKTYPESAME09)
    public String getZrnmvaariwyentuktypesame09() {
        return zrnmvaariwyentuktypesame09;
    }

    public void setZrnmvaariwyentuktypesame09(String pZrnmvaariwyentuktypesame09) {
        zrnmvaariwyentuktypesame09 = pZrnmvaariwyentuktypesame09;
    }

    private String zrnmvaariwsameyendaka09;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARIWSAMEYENDAKA09)
    public String getZrnmvaariwsameyendaka09() {
        return zrnmvaariwsameyendaka09;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnmvaariwsameyendaka09(String pZrnmvaariwsameyendaka09) {
        zrnmvaariwsameyendaka09 = pZrnmvaariwsameyendaka09;
    }

    private String zrnmvaariwsameyenkijyun09;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARIWSAMEYENKIJYUN09)
    public String getZrnmvaariwsameyenkijyun09() {
        return zrnmvaariwsameyenkijyun09;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnmvaariwsameyenkijyun09(String pZrnmvaariwsameyenkijyun09) {
        zrnmvaariwsameyenkijyun09 = pZrnmvaariwsameyenkijyun09;
    }

    private String zrnmvaariwsameyenyasu09;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARIWSAMEYENYASU09)
    public String getZrnmvaariwsameyenyasu09() {
        return zrnmvaariwsameyenyasu09;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnmvaariwsameyenyasu09(String pZrnmvaariwsameyenyasu09) {
        zrnmvaariwsameyenyasu09 = pZrnmvaariwsameyenyasu09;
    }

    private String zrnmvaariumsameyendaka09;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARIUMSAMEYENDAKA09)
    public String getZrnmvaariumsameyendaka09() {
        return zrnmvaariumsameyendaka09;
    }

    public void setZrnmvaariumsameyendaka09(String pZrnmvaariumsameyendaka09) {
        zrnmvaariumsameyendaka09 = pZrnmvaariumsameyendaka09;
    }

    private String zrnmvaariumsameyenkijyun09;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARIUMSAMEYENKIJYUN09)
    public String getZrnmvaariumsameyenkijyun09() {
        return zrnmvaariumsameyenkijyun09;
    }

    public void setZrnmvaariumsameyenkijyun09(String pZrnmvaariumsameyenkijyun09) {
        zrnmvaariumsameyenkijyun09 = pZrnmvaariumsameyenkijyun09;
    }

    private String zrnmvaariumsameyenyasu09;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARIUMSAMEYENYASU09)
    public String getZrnmvaariumsameyenyasu09() {
        return zrnmvaariumsameyenyasu09;
    }

    public void setZrnmvaariumsameyenyasu09(String pZrnmvaariumsameyenyasu09) {
        zrnmvaariumsameyenyasu09 = pZrnmvaariumsameyenyasu09;
    }

    private String zrnmvaariwtuktypedown09;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARIWTUKTYPEDOWN09)
    public String getZrnmvaariwtuktypedown09() {
        return zrnmvaariwtuktypedown09;
    }

    public void setZrnmvaariwtuktypedown09(String pZrnmvaariwtuktypedown09) {
        zrnmvaariwtuktypedown09 = pZrnmvaariwtuktypedown09;
    }

    private String zrnmvaaritmttknkykkjmdown09;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARITMTTKNKYKKJMDOWN09)
    public String getZrnmvaaritmttknkykkjmdown09() {
        return zrnmvaaritmttknkykkjmdown09;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnmvaaritmttknkykkjmdown09(String pZrnmvaaritmttknkykkjmdown09) {
        zrnmvaaritmttknkykkjmdown09 = pZrnmvaaritmttknkykkjmdown09;
    }

    private String zrnmvaariwdown09;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARIWDOWN09)
    public String getZrnmvaariwdown09() {
        return zrnmvaariwdown09;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnmvaariwdown09(String pZrnmvaariwdown09) {
        zrnmvaariwdown09 = pZrnmvaariwdown09;
    }

    private String zrnmvaariwyentuktypedown09;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARIWYENTUKTYPEDOWN09)
    public String getZrnmvaariwyentuktypedown09() {
        return zrnmvaariwyentuktypedown09;
    }

    public void setZrnmvaariwyentuktypedown09(String pZrnmvaariwyentuktypedown09) {
        zrnmvaariwyentuktypedown09 = pZrnmvaariwyentuktypedown09;
    }

    private String zrnmvaariwdownyendaka09;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARIWDOWNYENDAKA09)
    public String getZrnmvaariwdownyendaka09() {
        return zrnmvaariwdownyendaka09;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnmvaariwdownyendaka09(String pZrnmvaariwdownyendaka09) {
        zrnmvaariwdownyendaka09 = pZrnmvaariwdownyendaka09;
    }

    private String zrnmvaariwdownyenkijyun09;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARIWDOWNYENKIJYUN09)
    public String getZrnmvaariwdownyenkijyun09() {
        return zrnmvaariwdownyenkijyun09;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnmvaariwdownyenkijyun09(String pZrnmvaariwdownyenkijyun09) {
        zrnmvaariwdownyenkijyun09 = pZrnmvaariwdownyenkijyun09;
    }

    private String zrnmvaariwdownyenyasu09;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARIWDOWNYENYASU09)
    public String getZrnmvaariwdownyenyasu09() {
        return zrnmvaariwdownyenyasu09;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnmvaariwdownyenyasu09(String pZrnmvaariwdownyenyasu09) {
        zrnmvaariwdownyenyasu09 = pZrnmvaariwdownyenyasu09;
    }

    private String zrnmvaariumdownyendaka09;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARIUMDOWNYENDAKA09)
    public String getZrnmvaariumdownyendaka09() {
        return zrnmvaariumdownyendaka09;
    }

    public void setZrnmvaariumdownyendaka09(String pZrnmvaariumdownyendaka09) {
        zrnmvaariumdownyendaka09 = pZrnmvaariumdownyendaka09;
    }

    private String zrnmvaariumdownyenkijyun09;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARIUMDOWNYENKIJYUN09)
    public String getZrnmvaariumdownyenkijyun09() {
        return zrnmvaariumdownyenkijyun09;
    }

    public void setZrnmvaariumdownyenkijyun09(String pZrnmvaariumdownyenkijyun09) {
        zrnmvaariumdownyenkijyun09 = pZrnmvaariumdownyenkijyun09;
    }

    private String zrnmvaariumdownyenyasu09;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARIUMDOWNYENYASU09)
    public String getZrnmvaariumdownyenyasu09() {
        return zrnmvaariumdownyenyasu09;
    }

    public void setZrnmvaariumdownyenyasu09(String pZrnmvaariumdownyenyasu09) {
        zrnmvaariumdownyenyasu09 = pZrnmvaariumdownyenyasu09;
    }

    private String zrnmvaarivtuktype09;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARIVTUKTYPE09)
    public String getZrnmvaarivtuktype09() {
        return zrnmvaarivtuktype09;
    }

    public void setZrnmvaarivtuktype09(String pZrnmvaarivtuktype09) {
        zrnmvaarivtuktype09 = pZrnmvaarivtuktype09;
    }

    private String zrnmvaariv09;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARIV09)
    public String getZrnmvaariv09() {
        return zrnmvaariv09;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnmvaariv09(String pZrnmvaariv09) {
        zrnmvaariv09 = pZrnmvaariv09;
    }

    private String zrnptmttkngkutiwake109;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNPTMTTKNGKUTIWAKE109)
    public String getZrnptmttkngkutiwake109() {
        return zrnptmttkngkutiwake109;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnptmttkngkutiwake109(String pZrnptmttkngkutiwake109) {
        zrnptmttkngkutiwake109 = pZrnptmttkngkutiwake109;
    }

    private String zrnptmttkngkutiwake209;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNPTMTTKNGKUTIWAKE209)
    public String getZrnptmttkngkutiwake209() {
        return zrnptmttkngkutiwake209;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnptmttkngkutiwake209(String pZrnptmttkngkutiwake209) {
        zrnptmttkngkutiwake209 = pZrnptmttkngkutiwake209;
    }

    private String zrnmvaarinenoutouym10;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARINENOUTOUYM10)
    public String getZrnmvaarinenoutouym10() {
        return zrnmvaarinenoutouym10;
    }

    @DataConvert("toMultiByte")
    public void setZrnmvaarinenoutouym10(String pZrnmvaarinenoutouym10) {
        zrnmvaarinenoutouym10 = pZrnmvaarinenoutouym10;
    }

    private String zrnmvaarisisuuupritu10;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARISISUUUPRITU10)
    public String getZrnmvaarisisuuupritu10() {
        return zrnmvaarisisuuupritu10;
    }

    @DataConvert("toMultiByte")
    public void setZrnmvaarisisuuupritu10(String pZrnmvaarisisuuupritu10) {
        zrnmvaarisisuuupritu10 = pZrnmvaarisisuuupritu10;
    }

    private String zrnmvaaritmttknzkritu10;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARITMTTKNZKRITU10)
    public String getZrnmvaaritmttknzkritu10() {
        return zrnmvaaritmttknzkritu10;
    }

    @DataConvert("toMultiByte")
    public void setZrnmvaaritmttknzkritu10(String pZrnmvaaritmttknzkritu10) {
        zrnmvaaritmttknzkritu10 = pZrnmvaaritmttknzkritu10;
    }

    private String zrnmvaariwtuktypeup10;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARIWTUKTYPEUP10)
    public String getZrnmvaariwtuktypeup10() {
        return zrnmvaariwtuktypeup10;
    }

    public void setZrnmvaariwtuktypeup10(String pZrnmvaariwtuktypeup10) {
        zrnmvaariwtuktypeup10 = pZrnmvaariwtuktypeup10;
    }

    private String zrnmvaaritmttknkykkjmup10;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARITMTTKNKYKKJMUP10)
    public String getZrnmvaaritmttknkykkjmup10() {
        return zrnmvaaritmttknkykkjmup10;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnmvaaritmttknkykkjmup10(String pZrnmvaaritmttknkykkjmup10) {
        zrnmvaaritmttknkykkjmup10 = pZrnmvaaritmttknkykkjmup10;
    }

    private String zrnmvaariwup10;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARIWUP10)
    public String getZrnmvaariwup10() {
        return zrnmvaariwup10;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnmvaariwup10(String pZrnmvaariwup10) {
        zrnmvaariwup10 = pZrnmvaariwup10;
    }

    private String zrnmvaariwyentuktypeup10;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARIWYENTUKTYPEUP10)
    public String getZrnmvaariwyentuktypeup10() {
        return zrnmvaariwyentuktypeup10;
    }

    public void setZrnmvaariwyentuktypeup10(String pZrnmvaariwyentuktypeup10) {
        zrnmvaariwyentuktypeup10 = pZrnmvaariwyentuktypeup10;
    }

    private String zrnmvaariwupyendaka10;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARIWUPYENDAKA10)
    public String getZrnmvaariwupyendaka10() {
        return zrnmvaariwupyendaka10;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnmvaariwupyendaka10(String pZrnmvaariwupyendaka10) {
        zrnmvaariwupyendaka10 = pZrnmvaariwupyendaka10;
    }

    private String zrnmvaariwupyenkijyun10;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARIWUPYENKIJYUN10)
    public String getZrnmvaariwupyenkijyun10() {
        return zrnmvaariwupyenkijyun10;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnmvaariwupyenkijyun10(String pZrnmvaariwupyenkijyun10) {
        zrnmvaariwupyenkijyun10 = pZrnmvaariwupyenkijyun10;
    }

    private String zrnmvaariwupyenyasu10;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARIWUPYENYASU10)
    public String getZrnmvaariwupyenyasu10() {
        return zrnmvaariwupyenyasu10;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnmvaariwupyenyasu10(String pZrnmvaariwupyenyasu10) {
        zrnmvaariwupyenyasu10 = pZrnmvaariwupyenyasu10;
    }

    private String zrnmvaariwumupyendaka10;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARIWUMUPYENDAKA10)
    public String getZrnmvaariwumupyendaka10() {
        return zrnmvaariwumupyendaka10;
    }

    public void setZrnmvaariwumupyendaka10(String pZrnmvaariwumupyendaka10) {
        zrnmvaariwumupyendaka10 = pZrnmvaariwumupyendaka10;
    }

    private String zrnmvaariumupyenkijyun10;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARIUMUPYENKIJYUN10)
    public String getZrnmvaariumupyenkijyun10() {
        return zrnmvaariumupyenkijyun10;
    }

    public void setZrnmvaariumupyenkijyun10(String pZrnmvaariumupyenkijyun10) {
        zrnmvaariumupyenkijyun10 = pZrnmvaariumupyenkijyun10;
    }

    private String zrnmvaariumupyenyasu10;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARIUMUPYENYASU10)
    public String getZrnmvaariumupyenyasu10() {
        return zrnmvaariumupyenyasu10;
    }

    public void setZrnmvaariumupyenyasu10(String pZrnmvaariumupyenyasu10) {
        zrnmvaariumupyenyasu10 = pZrnmvaariumupyenyasu10;
    }

    private String zrnmvaariwtuktypesame10;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARIWTUKTYPESAME10)
    public String getZrnmvaariwtuktypesame10() {
        return zrnmvaariwtuktypesame10;
    }

    public void setZrnmvaariwtuktypesame10(String pZrnmvaariwtuktypesame10) {
        zrnmvaariwtuktypesame10 = pZrnmvaariwtuktypesame10;
    }

    private String zrnmvaaritmttknkykkjmsame10;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARITMTTKNKYKKJMSAME10)
    public String getZrnmvaaritmttknkykkjmsame10() {
        return zrnmvaaritmttknkykkjmsame10;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnmvaaritmttknkykkjmsame10(String pZrnmvaaritmttknkykkjmsame10) {
        zrnmvaaritmttknkykkjmsame10 = pZrnmvaaritmttknkykkjmsame10;
    }

    private String zrnmvaariwsame10;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARIWSAME10)
    public String getZrnmvaariwsame10() {
        return zrnmvaariwsame10;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnmvaariwsame10(String pZrnmvaariwsame10) {
        zrnmvaariwsame10 = pZrnmvaariwsame10;
    }

    private String zrnmvaariwyentuktypesame10;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARIWYENTUKTYPESAME10)
    public String getZrnmvaariwyentuktypesame10() {
        return zrnmvaariwyentuktypesame10;
    }

    public void setZrnmvaariwyentuktypesame10(String pZrnmvaariwyentuktypesame10) {
        zrnmvaariwyentuktypesame10 = pZrnmvaariwyentuktypesame10;
    }

    private String zrnmvaariwsameyendaka10;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARIWSAMEYENDAKA10)
    public String getZrnmvaariwsameyendaka10() {
        return zrnmvaariwsameyendaka10;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnmvaariwsameyendaka10(String pZrnmvaariwsameyendaka10) {
        zrnmvaariwsameyendaka10 = pZrnmvaariwsameyendaka10;
    }

    private String zrnmvaariwsameyenkijyun10;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARIWSAMEYENKIJYUN10)
    public String getZrnmvaariwsameyenkijyun10() {
        return zrnmvaariwsameyenkijyun10;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnmvaariwsameyenkijyun10(String pZrnmvaariwsameyenkijyun10) {
        zrnmvaariwsameyenkijyun10 = pZrnmvaariwsameyenkijyun10;
    }

    private String zrnmvaariwsameyenyasu10;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARIWSAMEYENYASU10)
    public String getZrnmvaariwsameyenyasu10() {
        return zrnmvaariwsameyenyasu10;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnmvaariwsameyenyasu10(String pZrnmvaariwsameyenyasu10) {
        zrnmvaariwsameyenyasu10 = pZrnmvaariwsameyenyasu10;
    }

    private String zrnmvaariumsameyendaka10;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARIUMSAMEYENDAKA10)
    public String getZrnmvaariumsameyendaka10() {
        return zrnmvaariumsameyendaka10;
    }

    public void setZrnmvaariumsameyendaka10(String pZrnmvaariumsameyendaka10) {
        zrnmvaariumsameyendaka10 = pZrnmvaariumsameyendaka10;
    }

    private String zrnmvaariumsameyenkijyun10;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARIUMSAMEYENKIJYUN10)
    public String getZrnmvaariumsameyenkijyun10() {
        return zrnmvaariumsameyenkijyun10;
    }

    public void setZrnmvaariumsameyenkijyun10(String pZrnmvaariumsameyenkijyun10) {
        zrnmvaariumsameyenkijyun10 = pZrnmvaariumsameyenkijyun10;
    }

    private String zrnmvaariumsameyenyasu10;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARIUMSAMEYENYASU10)
    public String getZrnmvaariumsameyenyasu10() {
        return zrnmvaariumsameyenyasu10;
    }

    public void setZrnmvaariumsameyenyasu10(String pZrnmvaariumsameyenyasu10) {
        zrnmvaariumsameyenyasu10 = pZrnmvaariumsameyenyasu10;
    }

    private String zrnmvaariwtuktypedown10;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARIWTUKTYPEDOWN10)
    public String getZrnmvaariwtuktypedown10() {
        return zrnmvaariwtuktypedown10;
    }

    public void setZrnmvaariwtuktypedown10(String pZrnmvaariwtuktypedown10) {
        zrnmvaariwtuktypedown10 = pZrnmvaariwtuktypedown10;
    }

    private String zrnmvaaritmttknkykkjmdown10;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARITMTTKNKYKKJMDOWN10)
    public String getZrnmvaaritmttknkykkjmdown10() {
        return zrnmvaaritmttknkykkjmdown10;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnmvaaritmttknkykkjmdown10(String pZrnmvaaritmttknkykkjmdown10) {
        zrnmvaaritmttknkykkjmdown10 = pZrnmvaaritmttknkykkjmdown10;
    }

    private String zrnmvaariwdown10;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARIWDOWN10)
    public String getZrnmvaariwdown10() {
        return zrnmvaariwdown10;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnmvaariwdown10(String pZrnmvaariwdown10) {
        zrnmvaariwdown10 = pZrnmvaariwdown10;
    }

    private String zrnmvaariwyentuktypedown10;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARIWYENTUKTYPEDOWN10)
    public String getZrnmvaariwyentuktypedown10() {
        return zrnmvaariwyentuktypedown10;
    }

    public void setZrnmvaariwyentuktypedown10(String pZrnmvaariwyentuktypedown10) {
        zrnmvaariwyentuktypedown10 = pZrnmvaariwyentuktypedown10;
    }

    private String zrnmvaariwdownyendaka10;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARIWDOWNYENDAKA10)
    public String getZrnmvaariwdownyendaka10() {
        return zrnmvaariwdownyendaka10;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnmvaariwdownyendaka10(String pZrnmvaariwdownyendaka10) {
        zrnmvaariwdownyendaka10 = pZrnmvaariwdownyendaka10;
    }

    private String zrnmvaariwdownyenkijyun10;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARIWDOWNYENKIJYUN10)
    public String getZrnmvaariwdownyenkijyun10() {
        return zrnmvaariwdownyenkijyun10;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnmvaariwdownyenkijyun10(String pZrnmvaariwdownyenkijyun10) {
        zrnmvaariwdownyenkijyun10 = pZrnmvaariwdownyenkijyun10;
    }

    private String zrnmvaariwdownyenyasu10;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARIWDOWNYENYASU10)
    public String getZrnmvaariwdownyenyasu10() {
        return zrnmvaariwdownyenyasu10;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnmvaariwdownyenyasu10(String pZrnmvaariwdownyenyasu10) {
        zrnmvaariwdownyenyasu10 = pZrnmvaariwdownyenyasu10;
    }

    private String zrnmvaariumdownyendaka10;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARIUMDOWNYENDAKA10)
    public String getZrnmvaariumdownyendaka10() {
        return zrnmvaariumdownyendaka10;
    }

    public void setZrnmvaariumdownyendaka10(String pZrnmvaariumdownyendaka10) {
        zrnmvaariumdownyendaka10 = pZrnmvaariumdownyendaka10;
    }

    private String zrnmvaariumdownyenkijyun10;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARIUMDOWNYENKIJYUN10)
    public String getZrnmvaariumdownyenkijyun10() {
        return zrnmvaariumdownyenkijyun10;
    }

    public void setZrnmvaariumdownyenkijyun10(String pZrnmvaariumdownyenkijyun10) {
        zrnmvaariumdownyenkijyun10 = pZrnmvaariumdownyenkijyun10;
    }

    private String zrnmvaariumdownyenyasu10;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARIUMDOWNYENYASU10)
    public String getZrnmvaariumdownyenyasu10() {
        return zrnmvaariumdownyenyasu10;
    }

    public void setZrnmvaariumdownyenyasu10(String pZrnmvaariumdownyenyasu10) {
        zrnmvaariumdownyenyasu10 = pZrnmvaariumdownyenyasu10;
    }

    private String zrnmvaarivtuktype10;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARIVTUKTYPE10)
    public String getZrnmvaarivtuktype10() {
        return zrnmvaarivtuktype10;
    }

    public void setZrnmvaarivtuktype10(String pZrnmvaarivtuktype10) {
        zrnmvaarivtuktype10 = pZrnmvaarivtuktype10;
    }

    private String zrnmvaariv10;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARIV10)
    public String getZrnmvaariv10() {
        return zrnmvaariv10;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnmvaariv10(String pZrnmvaariv10) {
        zrnmvaariv10 = pZrnmvaariv10;
    }

    private String zrnptmttkngkutiwake110;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNPTMTTKNGKUTIWAKE110)
    public String getZrnptmttkngkutiwake110() {
        return zrnptmttkngkutiwake110;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnptmttkngkutiwake110(String pZrnptmttkngkutiwake110) {
        zrnptmttkngkutiwake110 = pZrnptmttkngkutiwake110;
    }

    private String zrnptmttkngkutiwake210;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNPTMTTKNGKUTIWAKE210)
    public String getZrnptmttkngkutiwake210() {
        return zrnptmttkngkutiwake210;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnptmttkngkutiwake210(String pZrnptmttkngkutiwake210) {
        zrnptmttkngkutiwake210 = pZrnptmttkngkutiwake210;
    }

    private String zrnmvaarinenoutouym11;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARINENOUTOUYM11)
    public String getZrnmvaarinenoutouym11() {
        return zrnmvaarinenoutouym11;
    }

    @DataConvert("toMultiByte")
    public void setZrnmvaarinenoutouym11(String pZrnmvaarinenoutouym11) {
        zrnmvaarinenoutouym11 = pZrnmvaarinenoutouym11;
    }

    private String zrnmvaariwtuktypeup11;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARIWTUKTYPEUP11)
    public String getZrnmvaariwtuktypeup11() {
        return zrnmvaariwtuktypeup11;
    }

    public void setZrnmvaariwtuktypeup11(String pZrnmvaariwtuktypeup11) {
        zrnmvaariwtuktypeup11 = pZrnmvaariwtuktypeup11;
    }

    private String zrnmvaariwup11;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARIWUP11)
    public String getZrnmvaariwup11() {
        return zrnmvaariwup11;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnmvaariwup11(String pZrnmvaariwup11) {
        zrnmvaariwup11 = pZrnmvaariwup11;
    }

    private String zrnmvaariwyentuktypeup11;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARIWYENTUKTYPEUP11)
    public String getZrnmvaariwyentuktypeup11() {
        return zrnmvaariwyentuktypeup11;
    }

    public void setZrnmvaariwyentuktypeup11(String pZrnmvaariwyentuktypeup11) {
        zrnmvaariwyentuktypeup11 = pZrnmvaariwyentuktypeup11;
    }

    private String zrnmvaariwupyendaka11;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARIWUPYENDAKA11)
    public String getZrnmvaariwupyendaka11() {
        return zrnmvaariwupyendaka11;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnmvaariwupyendaka11(String pZrnmvaariwupyendaka11) {
        zrnmvaariwupyendaka11 = pZrnmvaariwupyendaka11;
    }

    private String zrnmvaariwupyenkijyun11;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARIWUPYENKIJYUN11)
    public String getZrnmvaariwupyenkijyun11() {
        return zrnmvaariwupyenkijyun11;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnmvaariwupyenkijyun11(String pZrnmvaariwupyenkijyun11) {
        zrnmvaariwupyenkijyun11 = pZrnmvaariwupyenkijyun11;
    }

    private String zrnmvaariwupyenyasu11;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARIWUPYENYASU11)
    public String getZrnmvaariwupyenyasu11() {
        return zrnmvaariwupyenyasu11;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnmvaariwupyenyasu11(String pZrnmvaariwupyenyasu11) {
        zrnmvaariwupyenyasu11 = pZrnmvaariwupyenyasu11;
    }

    private String zrnmvaariwumupyendaka11;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARIWUMUPYENDAKA11)
    public String getZrnmvaariwumupyendaka11() {
        return zrnmvaariwumupyendaka11;
    }

    public void setZrnmvaariwumupyendaka11(String pZrnmvaariwumupyendaka11) {
        zrnmvaariwumupyendaka11 = pZrnmvaariwumupyendaka11;
    }

    private String zrnmvaariumupyenkijyun11;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARIUMUPYENKIJYUN11)
    public String getZrnmvaariumupyenkijyun11() {
        return zrnmvaariumupyenkijyun11;
    }

    public void setZrnmvaariumupyenkijyun11(String pZrnmvaariumupyenkijyun11) {
        zrnmvaariumupyenkijyun11 = pZrnmvaariumupyenkijyun11;
    }

    private String zrnmvaariumupyenyasu11;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARIUMUPYENYASU11)
    public String getZrnmvaariumupyenyasu11() {
        return zrnmvaariumupyenyasu11;
    }

    public void setZrnmvaariumupyenyasu11(String pZrnmvaariumupyenyasu11) {
        zrnmvaariumupyenyasu11 = pZrnmvaariumupyenyasu11;
    }

    private String zrnmvaariwtuktypesame11;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARIWTUKTYPESAME11)
    public String getZrnmvaariwtuktypesame11() {
        return zrnmvaariwtuktypesame11;
    }

    public void setZrnmvaariwtuktypesame11(String pZrnmvaariwtuktypesame11) {
        zrnmvaariwtuktypesame11 = pZrnmvaariwtuktypesame11;
    }

    private String zrnmvaariwsame11;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARIWSAME11)
    public String getZrnmvaariwsame11() {
        return zrnmvaariwsame11;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnmvaariwsame11(String pZrnmvaariwsame11) {
        zrnmvaariwsame11 = pZrnmvaariwsame11;
    }

    private String zrnmvaariwyentuktypesame11;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARIWYENTUKTYPESAME11)
    public String getZrnmvaariwyentuktypesame11() {
        return zrnmvaariwyentuktypesame11;
    }

    public void setZrnmvaariwyentuktypesame11(String pZrnmvaariwyentuktypesame11) {
        zrnmvaariwyentuktypesame11 = pZrnmvaariwyentuktypesame11;
    }

    private String zrnmvaariwsameyendaka11;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARIWSAMEYENDAKA11)
    public String getZrnmvaariwsameyendaka11() {
        return zrnmvaariwsameyendaka11;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnmvaariwsameyendaka11(String pZrnmvaariwsameyendaka11) {
        zrnmvaariwsameyendaka11 = pZrnmvaariwsameyendaka11;
    }

    private String zrnmvaariwsameyenkijyun11;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARIWSAMEYENKIJYUN11)
    public String getZrnmvaariwsameyenkijyun11() {
        return zrnmvaariwsameyenkijyun11;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnmvaariwsameyenkijyun11(String pZrnmvaariwsameyenkijyun11) {
        zrnmvaariwsameyenkijyun11 = pZrnmvaariwsameyenkijyun11;
    }

    private String zrnmvaariwsameyenyasu11;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARIWSAMEYENYASU11)
    public String getZrnmvaariwsameyenyasu11() {
        return zrnmvaariwsameyenyasu11;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnmvaariwsameyenyasu11(String pZrnmvaariwsameyenyasu11) {
        zrnmvaariwsameyenyasu11 = pZrnmvaariwsameyenyasu11;
    }

    private String zrnmvaariumsameyendaka11;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARIUMSAMEYENDAKA11)
    public String getZrnmvaariumsameyendaka11() {
        return zrnmvaariumsameyendaka11;
    }

    public void setZrnmvaariumsameyendaka11(String pZrnmvaariumsameyendaka11) {
        zrnmvaariumsameyendaka11 = pZrnmvaariumsameyendaka11;
    }

    private String zrnmvaariumsameyenkijyun11;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARIUMSAMEYENKIJYUN11)
    public String getZrnmvaariumsameyenkijyun11() {
        return zrnmvaariumsameyenkijyun11;
    }

    public void setZrnmvaariumsameyenkijyun11(String pZrnmvaariumsameyenkijyun11) {
        zrnmvaariumsameyenkijyun11 = pZrnmvaariumsameyenkijyun11;
    }

    private String zrnmvaariumsameyenyasu11;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARIUMSAMEYENYASU11)
    public String getZrnmvaariumsameyenyasu11() {
        return zrnmvaariumsameyenyasu11;
    }

    public void setZrnmvaariumsameyenyasu11(String pZrnmvaariumsameyenyasu11) {
        zrnmvaariumsameyenyasu11 = pZrnmvaariumsameyenyasu11;
    }

    private String zrnmvaariwtuktypedown11;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARIWTUKTYPEDOWN11)
    public String getZrnmvaariwtuktypedown11() {
        return zrnmvaariwtuktypedown11;
    }

    public void setZrnmvaariwtuktypedown11(String pZrnmvaariwtuktypedown11) {
        zrnmvaariwtuktypedown11 = pZrnmvaariwtuktypedown11;
    }

    private String zrnmvaariwdown11;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARIWDOWN11)
    public String getZrnmvaariwdown11() {
        return zrnmvaariwdown11;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnmvaariwdown11(String pZrnmvaariwdown11) {
        zrnmvaariwdown11 = pZrnmvaariwdown11;
    }

    private String zrnmvaariwyentuktypedown11;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARIWYENTUKTYPEDOWN11)
    public String getZrnmvaariwyentuktypedown11() {
        return zrnmvaariwyentuktypedown11;
    }

    public void setZrnmvaariwyentuktypedown11(String pZrnmvaariwyentuktypedown11) {
        zrnmvaariwyentuktypedown11 = pZrnmvaariwyentuktypedown11;
    }

    private String zrnmvaariwdownyendaka11;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARIWDOWNYENDAKA11)
    public String getZrnmvaariwdownyendaka11() {
        return zrnmvaariwdownyendaka11;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnmvaariwdownyendaka11(String pZrnmvaariwdownyendaka11) {
        zrnmvaariwdownyendaka11 = pZrnmvaariwdownyendaka11;
    }

    private String zrnmvaariwdownyenkijyun11;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARIWDOWNYENKIJYUN11)
    public String getZrnmvaariwdownyenkijyun11() {
        return zrnmvaariwdownyenkijyun11;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnmvaariwdownyenkijyun11(String pZrnmvaariwdownyenkijyun11) {
        zrnmvaariwdownyenkijyun11 = pZrnmvaariwdownyenkijyun11;
    }

    private String zrnmvaariwdownyenyasu11;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARIWDOWNYENYASU11)
    public String getZrnmvaariwdownyenyasu11() {
        return zrnmvaariwdownyenyasu11;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnmvaariwdownyenyasu11(String pZrnmvaariwdownyenyasu11) {
        zrnmvaariwdownyenyasu11 = pZrnmvaariwdownyenyasu11;
    }

    private String zrnmvaariumdownyendaka11;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARIUMDOWNYENDAKA11)
    public String getZrnmvaariumdownyendaka11() {
        return zrnmvaariumdownyendaka11;
    }

    public void setZrnmvaariumdownyendaka11(String pZrnmvaariumdownyendaka11) {
        zrnmvaariumdownyendaka11 = pZrnmvaariumdownyendaka11;
    }

    private String zrnmvaariumdownyenkijyun11;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARIUMDOWNYENKIJYUN11)
    public String getZrnmvaariumdownyenkijyun11() {
        return zrnmvaariumdownyenkijyun11;
    }

    public void setZrnmvaariumdownyenkijyun11(String pZrnmvaariumdownyenkijyun11) {
        zrnmvaariumdownyenkijyun11 = pZrnmvaariumdownyenkijyun11;
    }

    private String zrnmvaariumdownyenyasu11;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARIUMDOWNYENYASU11)
    public String getZrnmvaariumdownyenyasu11() {
        return zrnmvaariumdownyenyasu11;
    }

    public void setZrnmvaariumdownyenyasu11(String pZrnmvaariumdownyenyasu11) {
        zrnmvaariumdownyenyasu11 = pZrnmvaariumdownyenyasu11;
    }

    private String zrnmvaarivtuktype11;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARIVTUKTYPE11)
    public String getZrnmvaarivtuktype11() {
        return zrnmvaarivtuktype11;
    }

    public void setZrnmvaarivtuktype11(String pZrnmvaarivtuktype11) {
        zrnmvaarivtuktype11 = pZrnmvaarivtuktype11;
    }

    private String zrnmvaariv11;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARIV11)
    public String getZrnmvaariv11() {
        return zrnmvaariv11;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnmvaariv11(String pZrnmvaariv11) {
        zrnmvaariv11 = pZrnmvaariv11;
    }

    private String zrnmvaarinenoutouym12;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARINENOUTOUYM12)
    public String getZrnmvaarinenoutouym12() {
        return zrnmvaarinenoutouym12;
    }

    @DataConvert("toMultiByte")
    public void setZrnmvaarinenoutouym12(String pZrnmvaarinenoutouym12) {
        zrnmvaarinenoutouym12 = pZrnmvaarinenoutouym12;
    }

    private String zrnmvaariwtuktypeup12;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARIWTUKTYPEUP12)
    public String getZrnmvaariwtuktypeup12() {
        return zrnmvaariwtuktypeup12;
    }

    public void setZrnmvaariwtuktypeup12(String pZrnmvaariwtuktypeup12) {
        zrnmvaariwtuktypeup12 = pZrnmvaariwtuktypeup12;
    }

    private String zrnmvaariwup12;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARIWUP12)
    public String getZrnmvaariwup12() {
        return zrnmvaariwup12;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnmvaariwup12(String pZrnmvaariwup12) {
        zrnmvaariwup12 = pZrnmvaariwup12;
    }

    private String zrnmvaariwyentuktypeup12;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARIWYENTUKTYPEUP12)
    public String getZrnmvaariwyentuktypeup12() {
        return zrnmvaariwyentuktypeup12;
    }

    public void setZrnmvaariwyentuktypeup12(String pZrnmvaariwyentuktypeup12) {
        zrnmvaariwyentuktypeup12 = pZrnmvaariwyentuktypeup12;
    }

    private String zrnmvaariwupyendaka12;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARIWUPYENDAKA12)
    public String getZrnmvaariwupyendaka12() {
        return zrnmvaariwupyendaka12;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnmvaariwupyendaka12(String pZrnmvaariwupyendaka12) {
        zrnmvaariwupyendaka12 = pZrnmvaariwupyendaka12;
    }

    private String zrnmvaariwupyenkijyun12;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARIWUPYENKIJYUN12)
    public String getZrnmvaariwupyenkijyun12() {
        return zrnmvaariwupyenkijyun12;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnmvaariwupyenkijyun12(String pZrnmvaariwupyenkijyun12) {
        zrnmvaariwupyenkijyun12 = pZrnmvaariwupyenkijyun12;
    }

    private String zrnmvaariwupyenyasu12;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARIWUPYENYASU12)
    public String getZrnmvaariwupyenyasu12() {
        return zrnmvaariwupyenyasu12;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnmvaariwupyenyasu12(String pZrnmvaariwupyenyasu12) {
        zrnmvaariwupyenyasu12 = pZrnmvaariwupyenyasu12;
    }

    private String zrnmvaariwumupyendaka12;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARIWUMUPYENDAKA12)
    public String getZrnmvaariwumupyendaka12() {
        return zrnmvaariwumupyendaka12;
    }

    public void setZrnmvaariwumupyendaka12(String pZrnmvaariwumupyendaka12) {
        zrnmvaariwumupyendaka12 = pZrnmvaariwumupyendaka12;
    }

    private String zrnmvaariumupyenkijyun12;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARIUMUPYENKIJYUN12)
    public String getZrnmvaariumupyenkijyun12() {
        return zrnmvaariumupyenkijyun12;
    }

    public void setZrnmvaariumupyenkijyun12(String pZrnmvaariumupyenkijyun12) {
        zrnmvaariumupyenkijyun12 = pZrnmvaariumupyenkijyun12;
    }

    private String zrnmvaariumupyenyasu12;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARIUMUPYENYASU12)
    public String getZrnmvaariumupyenyasu12() {
        return zrnmvaariumupyenyasu12;
    }

    public void setZrnmvaariumupyenyasu12(String pZrnmvaariumupyenyasu12) {
        zrnmvaariumupyenyasu12 = pZrnmvaariumupyenyasu12;
    }

    private String zrnmvaariwtuktypesame12;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARIWTUKTYPESAME12)
    public String getZrnmvaariwtuktypesame12() {
        return zrnmvaariwtuktypesame12;
    }

    public void setZrnmvaariwtuktypesame12(String pZrnmvaariwtuktypesame12) {
        zrnmvaariwtuktypesame12 = pZrnmvaariwtuktypesame12;
    }

    private String zrnmvaariwsame12;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARIWSAME12)
    public String getZrnmvaariwsame12() {
        return zrnmvaariwsame12;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnmvaariwsame12(String pZrnmvaariwsame12) {
        zrnmvaariwsame12 = pZrnmvaariwsame12;
    }

    private String zrnmvaariwyentuktypesame12;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARIWYENTUKTYPESAME12)
    public String getZrnmvaariwyentuktypesame12() {
        return zrnmvaariwyentuktypesame12;
    }

    public void setZrnmvaariwyentuktypesame12(String pZrnmvaariwyentuktypesame12) {
        zrnmvaariwyentuktypesame12 = pZrnmvaariwyentuktypesame12;
    }

    private String zrnmvaariwsameyendaka12;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARIWSAMEYENDAKA12)
    public String getZrnmvaariwsameyendaka12() {
        return zrnmvaariwsameyendaka12;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnmvaariwsameyendaka12(String pZrnmvaariwsameyendaka12) {
        zrnmvaariwsameyendaka12 = pZrnmvaariwsameyendaka12;
    }

    private String zrnmvaariwsameyenkijyun12;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARIWSAMEYENKIJYUN12)
    public String getZrnmvaariwsameyenkijyun12() {
        return zrnmvaariwsameyenkijyun12;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnmvaariwsameyenkijyun12(String pZrnmvaariwsameyenkijyun12) {
        zrnmvaariwsameyenkijyun12 = pZrnmvaariwsameyenkijyun12;
    }

    private String zrnmvaariwsameyenyasu12;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARIWSAMEYENYASU12)
    public String getZrnmvaariwsameyenyasu12() {
        return zrnmvaariwsameyenyasu12;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnmvaariwsameyenyasu12(String pZrnmvaariwsameyenyasu12) {
        zrnmvaariwsameyenyasu12 = pZrnmvaariwsameyenyasu12;
    }

    private String zrnmvaariumsameyendaka12;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARIUMSAMEYENDAKA12)
    public String getZrnmvaariumsameyendaka12() {
        return zrnmvaariumsameyendaka12;
    }

    public void setZrnmvaariumsameyendaka12(String pZrnmvaariumsameyendaka12) {
        zrnmvaariumsameyendaka12 = pZrnmvaariumsameyendaka12;
    }

    private String zrnmvaariumsameyenkijyun12;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARIUMSAMEYENKIJYUN12)
    public String getZrnmvaariumsameyenkijyun12() {
        return zrnmvaariumsameyenkijyun12;
    }

    public void setZrnmvaariumsameyenkijyun12(String pZrnmvaariumsameyenkijyun12) {
        zrnmvaariumsameyenkijyun12 = pZrnmvaariumsameyenkijyun12;
    }

    private String zrnmvaariumsameyenyasu12;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARIUMSAMEYENYASU12)
    public String getZrnmvaariumsameyenyasu12() {
        return zrnmvaariumsameyenyasu12;
    }

    public void setZrnmvaariumsameyenyasu12(String pZrnmvaariumsameyenyasu12) {
        zrnmvaariumsameyenyasu12 = pZrnmvaariumsameyenyasu12;
    }

    private String zrnmvaariwtuktypedown12;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARIWTUKTYPEDOWN12)
    public String getZrnmvaariwtuktypedown12() {
        return zrnmvaariwtuktypedown12;
    }

    public void setZrnmvaariwtuktypedown12(String pZrnmvaariwtuktypedown12) {
        zrnmvaariwtuktypedown12 = pZrnmvaariwtuktypedown12;
    }

    private String zrnmvaariwdown12;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARIWDOWN12)
    public String getZrnmvaariwdown12() {
        return zrnmvaariwdown12;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnmvaariwdown12(String pZrnmvaariwdown12) {
        zrnmvaariwdown12 = pZrnmvaariwdown12;
    }

    private String zrnmvaariwyentuktypedown12;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARIWYENTUKTYPEDOWN12)
    public String getZrnmvaariwyentuktypedown12() {
        return zrnmvaariwyentuktypedown12;
    }

    public void setZrnmvaariwyentuktypedown12(String pZrnmvaariwyentuktypedown12) {
        zrnmvaariwyentuktypedown12 = pZrnmvaariwyentuktypedown12;
    }

    private String zrnmvaariwdownyendaka12;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARIWDOWNYENDAKA12)
    public String getZrnmvaariwdownyendaka12() {
        return zrnmvaariwdownyendaka12;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnmvaariwdownyendaka12(String pZrnmvaariwdownyendaka12) {
        zrnmvaariwdownyendaka12 = pZrnmvaariwdownyendaka12;
    }

    private String zrnmvaariwdownyenkijyun12;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARIWDOWNYENKIJYUN12)
    public String getZrnmvaariwdownyenkijyun12() {
        return zrnmvaariwdownyenkijyun12;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnmvaariwdownyenkijyun12(String pZrnmvaariwdownyenkijyun12) {
        zrnmvaariwdownyenkijyun12 = pZrnmvaariwdownyenkijyun12;
    }

    private String zrnmvaariwdownyenyasu12;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARIWDOWNYENYASU12)
    public String getZrnmvaariwdownyenyasu12() {
        return zrnmvaariwdownyenyasu12;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnmvaariwdownyenyasu12(String pZrnmvaariwdownyenyasu12) {
        zrnmvaariwdownyenyasu12 = pZrnmvaariwdownyenyasu12;
    }

    private String zrnmvaariumdownyendaka12;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARIUMDOWNYENDAKA12)
    public String getZrnmvaariumdownyendaka12() {
        return zrnmvaariumdownyendaka12;
    }

    public void setZrnmvaariumdownyendaka12(String pZrnmvaariumdownyendaka12) {
        zrnmvaariumdownyendaka12 = pZrnmvaariumdownyendaka12;
    }

    private String zrnmvaariumdownyenkijyun12;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARIUMDOWNYENKIJYUN12)
    public String getZrnmvaariumdownyenkijyun12() {
        return zrnmvaariumdownyenkijyun12;
    }

    public void setZrnmvaariumdownyenkijyun12(String pZrnmvaariumdownyenkijyun12) {
        zrnmvaariumdownyenkijyun12 = pZrnmvaariumdownyenkijyun12;
    }

    private String zrnmvaariumdownyenyasu12;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARIUMDOWNYENYASU12)
    public String getZrnmvaariumdownyenyasu12() {
        return zrnmvaariumdownyenyasu12;
    }

    public void setZrnmvaariumdownyenyasu12(String pZrnmvaariumdownyenyasu12) {
        zrnmvaariumdownyenyasu12 = pZrnmvaariumdownyenyasu12;
    }

    private String zrnmvaarivtuktype12;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARIVTUKTYPE12)
    public String getZrnmvaarivtuktype12() {
        return zrnmvaarivtuktype12;
    }

    public void setZrnmvaarivtuktype12(String pZrnmvaarivtuktype12) {
        zrnmvaarivtuktype12 = pZrnmvaarivtuktype12;
    }

    private String zrnmvaariv12;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARIV12)
    public String getZrnmvaariv12() {
        return zrnmvaariv12;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnmvaariv12(String pZrnmvaariv12) {
        zrnmvaariv12 = pZrnmvaariv12;
    }

    private String zrnmvaarinenoutouym13;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARINENOUTOUYM13)
    public String getZrnmvaarinenoutouym13() {
        return zrnmvaarinenoutouym13;
    }

    @DataConvert("toMultiByte")
    public void setZrnmvaarinenoutouym13(String pZrnmvaarinenoutouym13) {
        zrnmvaarinenoutouym13 = pZrnmvaarinenoutouym13;
    }

    private String zrnmvaariwtuktypeup13;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARIWTUKTYPEUP13)
    public String getZrnmvaariwtuktypeup13() {
        return zrnmvaariwtuktypeup13;
    }

    public void setZrnmvaariwtuktypeup13(String pZrnmvaariwtuktypeup13) {
        zrnmvaariwtuktypeup13 = pZrnmvaariwtuktypeup13;
    }

    private String zrnmvaariwup13;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARIWUP13)
    public String getZrnmvaariwup13() {
        return zrnmvaariwup13;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnmvaariwup13(String pZrnmvaariwup13) {
        zrnmvaariwup13 = pZrnmvaariwup13;
    }

    private String zrnmvaariwyentuktypeup13;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARIWYENTUKTYPEUP13)
    public String getZrnmvaariwyentuktypeup13() {
        return zrnmvaariwyentuktypeup13;
    }

    public void setZrnmvaariwyentuktypeup13(String pZrnmvaariwyentuktypeup13) {
        zrnmvaariwyentuktypeup13 = pZrnmvaariwyentuktypeup13;
    }

    private String zrnmvaariwupyendaka13;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARIWUPYENDAKA13)
    public String getZrnmvaariwupyendaka13() {
        return zrnmvaariwupyendaka13;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnmvaariwupyendaka13(String pZrnmvaariwupyendaka13) {
        zrnmvaariwupyendaka13 = pZrnmvaariwupyendaka13;
    }

    private String zrnmvaariwupyenkijyun13;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARIWUPYENKIJYUN13)
    public String getZrnmvaariwupyenkijyun13() {
        return zrnmvaariwupyenkijyun13;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnmvaariwupyenkijyun13(String pZrnmvaariwupyenkijyun13) {
        zrnmvaariwupyenkijyun13 = pZrnmvaariwupyenkijyun13;
    }

    private String zrnmvaariwupyenyasu13;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARIWUPYENYASU13)
    public String getZrnmvaariwupyenyasu13() {
        return zrnmvaariwupyenyasu13;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnmvaariwupyenyasu13(String pZrnmvaariwupyenyasu13) {
        zrnmvaariwupyenyasu13 = pZrnmvaariwupyenyasu13;
    }

    private String zrnmvaariwumupyendaka13;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARIWUMUPYENDAKA13)
    public String getZrnmvaariwumupyendaka13() {
        return zrnmvaariwumupyendaka13;
    }

    public void setZrnmvaariwumupyendaka13(String pZrnmvaariwumupyendaka13) {
        zrnmvaariwumupyendaka13 = pZrnmvaariwumupyendaka13;
    }

    private String zrnmvaariumupyenkijyun13;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARIUMUPYENKIJYUN13)
    public String getZrnmvaariumupyenkijyun13() {
        return zrnmvaariumupyenkijyun13;
    }

    public void setZrnmvaariumupyenkijyun13(String pZrnmvaariumupyenkijyun13) {
        zrnmvaariumupyenkijyun13 = pZrnmvaariumupyenkijyun13;
    }

    private String zrnmvaariumupyenyasu13;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARIUMUPYENYASU13)
    public String getZrnmvaariumupyenyasu13() {
        return zrnmvaariumupyenyasu13;
    }

    public void setZrnmvaariumupyenyasu13(String pZrnmvaariumupyenyasu13) {
        zrnmvaariumupyenyasu13 = pZrnmvaariumupyenyasu13;
    }

    private String zrnmvaariwtuktypesame13;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARIWTUKTYPESAME13)
    public String getZrnmvaariwtuktypesame13() {
        return zrnmvaariwtuktypesame13;
    }

    public void setZrnmvaariwtuktypesame13(String pZrnmvaariwtuktypesame13) {
        zrnmvaariwtuktypesame13 = pZrnmvaariwtuktypesame13;
    }

    private String zrnmvaariwsame13;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARIWSAME13)
    public String getZrnmvaariwsame13() {
        return zrnmvaariwsame13;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnmvaariwsame13(String pZrnmvaariwsame13) {
        zrnmvaariwsame13 = pZrnmvaariwsame13;
    }

    private String zrnmvaariwyentuktypesame13;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARIWYENTUKTYPESAME13)
    public String getZrnmvaariwyentuktypesame13() {
        return zrnmvaariwyentuktypesame13;
    }

    public void setZrnmvaariwyentuktypesame13(String pZrnmvaariwyentuktypesame13) {
        zrnmvaariwyentuktypesame13 = pZrnmvaariwyentuktypesame13;
    }

    private String zrnmvaariwsameyendaka13;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARIWSAMEYENDAKA13)
    public String getZrnmvaariwsameyendaka13() {
        return zrnmvaariwsameyendaka13;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnmvaariwsameyendaka13(String pZrnmvaariwsameyendaka13) {
        zrnmvaariwsameyendaka13 = pZrnmvaariwsameyendaka13;
    }

    private String zrnmvaariwsameyenkijyun13;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARIWSAMEYENKIJYUN13)
    public String getZrnmvaariwsameyenkijyun13() {
        return zrnmvaariwsameyenkijyun13;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnmvaariwsameyenkijyun13(String pZrnmvaariwsameyenkijyun13) {
        zrnmvaariwsameyenkijyun13 = pZrnmvaariwsameyenkijyun13;
    }

    private String zrnmvaariwsameyenyasu13;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARIWSAMEYENYASU13)
    public String getZrnmvaariwsameyenyasu13() {
        return zrnmvaariwsameyenyasu13;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnmvaariwsameyenyasu13(String pZrnmvaariwsameyenyasu13) {
        zrnmvaariwsameyenyasu13 = pZrnmvaariwsameyenyasu13;
    }

    private String zrnmvaariumsameyendaka13;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARIUMSAMEYENDAKA13)
    public String getZrnmvaariumsameyendaka13() {
        return zrnmvaariumsameyendaka13;
    }

    public void setZrnmvaariumsameyendaka13(String pZrnmvaariumsameyendaka13) {
        zrnmvaariumsameyendaka13 = pZrnmvaariumsameyendaka13;
    }

    private String zrnmvaariumsameyenkijyun13;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARIUMSAMEYENKIJYUN13)
    public String getZrnmvaariumsameyenkijyun13() {
        return zrnmvaariumsameyenkijyun13;
    }

    public void setZrnmvaariumsameyenkijyun13(String pZrnmvaariumsameyenkijyun13) {
        zrnmvaariumsameyenkijyun13 = pZrnmvaariumsameyenkijyun13;
    }

    private String zrnmvaariumsameyenyasu13;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARIUMSAMEYENYASU13)
    public String getZrnmvaariumsameyenyasu13() {
        return zrnmvaariumsameyenyasu13;
    }

    public void setZrnmvaariumsameyenyasu13(String pZrnmvaariumsameyenyasu13) {
        zrnmvaariumsameyenyasu13 = pZrnmvaariumsameyenyasu13;
    }

    private String zrnmvaariwtuktypedown13;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARIWTUKTYPEDOWN13)
    public String getZrnmvaariwtuktypedown13() {
        return zrnmvaariwtuktypedown13;
    }

    public void setZrnmvaariwtuktypedown13(String pZrnmvaariwtuktypedown13) {
        zrnmvaariwtuktypedown13 = pZrnmvaariwtuktypedown13;
    }

    private String zrnmvaariwdown13;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARIWDOWN13)
    public String getZrnmvaariwdown13() {
        return zrnmvaariwdown13;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnmvaariwdown13(String pZrnmvaariwdown13) {
        zrnmvaariwdown13 = pZrnmvaariwdown13;
    }

    private String zrnmvaariwyentuktypedown13;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARIWYENTUKTYPEDOWN13)
    public String getZrnmvaariwyentuktypedown13() {
        return zrnmvaariwyentuktypedown13;
    }

    public void setZrnmvaariwyentuktypedown13(String pZrnmvaariwyentuktypedown13) {
        zrnmvaariwyentuktypedown13 = pZrnmvaariwyentuktypedown13;
    }

    private String zrnmvaariwdownyendaka13;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARIWDOWNYENDAKA13)
    public String getZrnmvaariwdownyendaka13() {
        return zrnmvaariwdownyendaka13;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnmvaariwdownyendaka13(String pZrnmvaariwdownyendaka13) {
        zrnmvaariwdownyendaka13 = pZrnmvaariwdownyendaka13;
    }

    private String zrnmvaariwdownyenkijyun13;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARIWDOWNYENKIJYUN13)
    public String getZrnmvaariwdownyenkijyun13() {
        return zrnmvaariwdownyenkijyun13;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnmvaariwdownyenkijyun13(String pZrnmvaariwdownyenkijyun13) {
        zrnmvaariwdownyenkijyun13 = pZrnmvaariwdownyenkijyun13;
    }

    private String zrnmvaariwdownyenyasu13;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARIWDOWNYENYASU13)
    public String getZrnmvaariwdownyenyasu13() {
        return zrnmvaariwdownyenyasu13;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnmvaariwdownyenyasu13(String pZrnmvaariwdownyenyasu13) {
        zrnmvaariwdownyenyasu13 = pZrnmvaariwdownyenyasu13;
    }

    private String zrnmvaariumdownyendaka13;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARIUMDOWNYENDAKA13)
    public String getZrnmvaariumdownyendaka13() {
        return zrnmvaariumdownyendaka13;
    }

    public void setZrnmvaariumdownyendaka13(String pZrnmvaariumdownyendaka13) {
        zrnmvaariumdownyendaka13 = pZrnmvaariumdownyendaka13;
    }

    private String zrnmvaariumdownyenkijyun13;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARIUMDOWNYENKIJYUN13)
    public String getZrnmvaariumdownyenkijyun13() {
        return zrnmvaariumdownyenkijyun13;
    }

    public void setZrnmvaariumdownyenkijyun13(String pZrnmvaariumdownyenkijyun13) {
        zrnmvaariumdownyenkijyun13 = pZrnmvaariumdownyenkijyun13;
    }

    private String zrnmvaariumdownyenyasu13;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARIUMDOWNYENYASU13)
    public String getZrnmvaariumdownyenyasu13() {
        return zrnmvaariumdownyenyasu13;
    }

    public void setZrnmvaariumdownyenyasu13(String pZrnmvaariumdownyenyasu13) {
        zrnmvaariumdownyenyasu13 = pZrnmvaariumdownyenyasu13;
    }

    private String zrnmvaarivtuktype13;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARIVTUKTYPE13)
    public String getZrnmvaarivtuktype13() {
        return zrnmvaarivtuktype13;
    }

    public void setZrnmvaarivtuktype13(String pZrnmvaarivtuktype13) {
        zrnmvaarivtuktype13 = pZrnmvaarivtuktype13;
    }

    private String zrnmvaariv13;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARIV13)
    public String getZrnmvaariv13() {
        return zrnmvaariv13;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnmvaariv13(String pZrnmvaariv13) {
        zrnmvaariv13 = pZrnmvaariv13;
    }

    private String zrnmvaarinenoutouym14;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARINENOUTOUYM14)
    public String getZrnmvaarinenoutouym14() {
        return zrnmvaarinenoutouym14;
    }

    @DataConvert("toMultiByte")
    public void setZrnmvaarinenoutouym14(String pZrnmvaarinenoutouym14) {
        zrnmvaarinenoutouym14 = pZrnmvaarinenoutouym14;
    }

    private String zrnmvaariwtuktypeup14;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARIWTUKTYPEUP14)
    public String getZrnmvaariwtuktypeup14() {
        return zrnmvaariwtuktypeup14;
    }

    public void setZrnmvaariwtuktypeup14(String pZrnmvaariwtuktypeup14) {
        zrnmvaariwtuktypeup14 = pZrnmvaariwtuktypeup14;
    }

    private String zrnmvaariwup14;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARIWUP14)
    public String getZrnmvaariwup14() {
        return zrnmvaariwup14;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnmvaariwup14(String pZrnmvaariwup14) {
        zrnmvaariwup14 = pZrnmvaariwup14;
    }

    private String zrnmvaariwyentuktypeup14;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARIWYENTUKTYPEUP14)
    public String getZrnmvaariwyentuktypeup14() {
        return zrnmvaariwyentuktypeup14;
    }

    public void setZrnmvaariwyentuktypeup14(String pZrnmvaariwyentuktypeup14) {
        zrnmvaariwyentuktypeup14 = pZrnmvaariwyentuktypeup14;
    }

    private String zrnmvaariwupyendaka14;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARIWUPYENDAKA14)
    public String getZrnmvaariwupyendaka14() {
        return zrnmvaariwupyendaka14;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnmvaariwupyendaka14(String pZrnmvaariwupyendaka14) {
        zrnmvaariwupyendaka14 = pZrnmvaariwupyendaka14;
    }

    private String zrnmvaariwupyenkijyun14;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARIWUPYENKIJYUN14)
    public String getZrnmvaariwupyenkijyun14() {
        return zrnmvaariwupyenkijyun14;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnmvaariwupyenkijyun14(String pZrnmvaariwupyenkijyun14) {
        zrnmvaariwupyenkijyun14 = pZrnmvaariwupyenkijyun14;
    }

    private String zrnmvaariwupyenyasu14;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARIWUPYENYASU14)
    public String getZrnmvaariwupyenyasu14() {
        return zrnmvaariwupyenyasu14;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnmvaariwupyenyasu14(String pZrnmvaariwupyenyasu14) {
        zrnmvaariwupyenyasu14 = pZrnmvaariwupyenyasu14;
    }

    private String zrnmvaariwumupyendaka14;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARIWUMUPYENDAKA14)
    public String getZrnmvaariwumupyendaka14() {
        return zrnmvaariwumupyendaka14;
    }

    public void setZrnmvaariwumupyendaka14(String pZrnmvaariwumupyendaka14) {
        zrnmvaariwumupyendaka14 = pZrnmvaariwumupyendaka14;
    }

    private String zrnmvaariumupyenkijyun14;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARIUMUPYENKIJYUN14)
    public String getZrnmvaariumupyenkijyun14() {
        return zrnmvaariumupyenkijyun14;
    }

    public void setZrnmvaariumupyenkijyun14(String pZrnmvaariumupyenkijyun14) {
        zrnmvaariumupyenkijyun14 = pZrnmvaariumupyenkijyun14;
    }

    private String zrnmvaariumupyenyasu14;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARIUMUPYENYASU14)
    public String getZrnmvaariumupyenyasu14() {
        return zrnmvaariumupyenyasu14;
    }

    public void setZrnmvaariumupyenyasu14(String pZrnmvaariumupyenyasu14) {
        zrnmvaariumupyenyasu14 = pZrnmvaariumupyenyasu14;
    }

    private String zrnmvaariwtuktypesame14;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARIWTUKTYPESAME14)
    public String getZrnmvaariwtuktypesame14() {
        return zrnmvaariwtuktypesame14;
    }

    public void setZrnmvaariwtuktypesame14(String pZrnmvaariwtuktypesame14) {
        zrnmvaariwtuktypesame14 = pZrnmvaariwtuktypesame14;
    }

    private String zrnmvaariwsame14;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARIWSAME14)
    public String getZrnmvaariwsame14() {
        return zrnmvaariwsame14;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnmvaariwsame14(String pZrnmvaariwsame14) {
        zrnmvaariwsame14 = pZrnmvaariwsame14;
    }

    private String zrnmvaariwyentuktypesame14;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARIWYENTUKTYPESAME14)
    public String getZrnmvaariwyentuktypesame14() {
        return zrnmvaariwyentuktypesame14;
    }

    public void setZrnmvaariwyentuktypesame14(String pZrnmvaariwyentuktypesame14) {
        zrnmvaariwyentuktypesame14 = pZrnmvaariwyentuktypesame14;
    }

    private String zrnmvaariwsameyendaka14;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARIWSAMEYENDAKA14)
    public String getZrnmvaariwsameyendaka14() {
        return zrnmvaariwsameyendaka14;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnmvaariwsameyendaka14(String pZrnmvaariwsameyendaka14) {
        zrnmvaariwsameyendaka14 = pZrnmvaariwsameyendaka14;
    }

    private String zrnmvaariwsameyenkijyun14;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARIWSAMEYENKIJYUN14)
    public String getZrnmvaariwsameyenkijyun14() {
        return zrnmvaariwsameyenkijyun14;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnmvaariwsameyenkijyun14(String pZrnmvaariwsameyenkijyun14) {
        zrnmvaariwsameyenkijyun14 = pZrnmvaariwsameyenkijyun14;
    }

    private String zrnmvaariwsameyenyasu14;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARIWSAMEYENYASU14)
    public String getZrnmvaariwsameyenyasu14() {
        return zrnmvaariwsameyenyasu14;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnmvaariwsameyenyasu14(String pZrnmvaariwsameyenyasu14) {
        zrnmvaariwsameyenyasu14 = pZrnmvaariwsameyenyasu14;
    }

    private String zrnmvaariumsameyendaka14;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARIUMSAMEYENDAKA14)
    public String getZrnmvaariumsameyendaka14() {
        return zrnmvaariumsameyendaka14;
    }

    public void setZrnmvaariumsameyendaka14(String pZrnmvaariumsameyendaka14) {
        zrnmvaariumsameyendaka14 = pZrnmvaariumsameyendaka14;
    }

    private String zrnmvaariumsameyenkijyun14;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARIUMSAMEYENKIJYUN14)
    public String getZrnmvaariumsameyenkijyun14() {
        return zrnmvaariumsameyenkijyun14;
    }

    public void setZrnmvaariumsameyenkijyun14(String pZrnmvaariumsameyenkijyun14) {
        zrnmvaariumsameyenkijyun14 = pZrnmvaariumsameyenkijyun14;
    }

    private String zrnmvaariumsameyenyasu14;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARIUMSAMEYENYASU14)
    public String getZrnmvaariumsameyenyasu14() {
        return zrnmvaariumsameyenyasu14;
    }

    public void setZrnmvaariumsameyenyasu14(String pZrnmvaariumsameyenyasu14) {
        zrnmvaariumsameyenyasu14 = pZrnmvaariumsameyenyasu14;
    }

    private String zrnmvaariwtuktypedown14;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARIWTUKTYPEDOWN14)
    public String getZrnmvaariwtuktypedown14() {
        return zrnmvaariwtuktypedown14;
    }

    public void setZrnmvaariwtuktypedown14(String pZrnmvaariwtuktypedown14) {
        zrnmvaariwtuktypedown14 = pZrnmvaariwtuktypedown14;
    }

    private String zrnmvaariwdown14;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARIWDOWN14)
    public String getZrnmvaariwdown14() {
        return zrnmvaariwdown14;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnmvaariwdown14(String pZrnmvaariwdown14) {
        zrnmvaariwdown14 = pZrnmvaariwdown14;
    }

    private String zrnmvaariwyentuktypedown14;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARIWYENTUKTYPEDOWN14)
    public String getZrnmvaariwyentuktypedown14() {
        return zrnmvaariwyentuktypedown14;
    }

    public void setZrnmvaariwyentuktypedown14(String pZrnmvaariwyentuktypedown14) {
        zrnmvaariwyentuktypedown14 = pZrnmvaariwyentuktypedown14;
    }

    private String zrnmvaariwdownyendaka14;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARIWDOWNYENDAKA14)
    public String getZrnmvaariwdownyendaka14() {
        return zrnmvaariwdownyendaka14;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnmvaariwdownyendaka14(String pZrnmvaariwdownyendaka14) {
        zrnmvaariwdownyendaka14 = pZrnmvaariwdownyendaka14;
    }

    private String zrnmvaariwdownyenkijyun14;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARIWDOWNYENKIJYUN14)
    public String getZrnmvaariwdownyenkijyun14() {
        return zrnmvaariwdownyenkijyun14;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnmvaariwdownyenkijyun14(String pZrnmvaariwdownyenkijyun14) {
        zrnmvaariwdownyenkijyun14 = pZrnmvaariwdownyenkijyun14;
    }

    private String zrnmvaariwdownyenyasu14;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARIWDOWNYENYASU14)
    public String getZrnmvaariwdownyenyasu14() {
        return zrnmvaariwdownyenyasu14;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnmvaariwdownyenyasu14(String pZrnmvaariwdownyenyasu14) {
        zrnmvaariwdownyenyasu14 = pZrnmvaariwdownyenyasu14;
    }

    private String zrnmvaariumdownyendaka14;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARIUMDOWNYENDAKA14)
    public String getZrnmvaariumdownyendaka14() {
        return zrnmvaariumdownyendaka14;
    }

    public void setZrnmvaariumdownyendaka14(String pZrnmvaariumdownyendaka14) {
        zrnmvaariumdownyendaka14 = pZrnmvaariumdownyendaka14;
    }

    private String zrnmvaariumdownyenkijyun14;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARIUMDOWNYENKIJYUN14)
    public String getZrnmvaariumdownyenkijyun14() {
        return zrnmvaariumdownyenkijyun14;
    }

    public void setZrnmvaariumdownyenkijyun14(String pZrnmvaariumdownyenkijyun14) {
        zrnmvaariumdownyenkijyun14 = pZrnmvaariumdownyenkijyun14;
    }

    private String zrnmvaariumdownyenyasu14;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARIUMDOWNYENYASU14)
    public String getZrnmvaariumdownyenyasu14() {
        return zrnmvaariumdownyenyasu14;
    }

    public void setZrnmvaariumdownyenyasu14(String pZrnmvaariumdownyenyasu14) {
        zrnmvaariumdownyenyasu14 = pZrnmvaariumdownyenyasu14;
    }

    private String zrnmvaarivtuktype14;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARIVTUKTYPE14)
    public String getZrnmvaarivtuktype14() {
        return zrnmvaarivtuktype14;
    }

    public void setZrnmvaarivtuktype14(String pZrnmvaarivtuktype14) {
        zrnmvaarivtuktype14 = pZrnmvaarivtuktype14;
    }

    private String zrnmvaariv14;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARIV14)
    public String getZrnmvaariv14() {
        return zrnmvaariv14;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnmvaariv14(String pZrnmvaariv14) {
        zrnmvaariv14 = pZrnmvaariv14;
    }

    private String zrnmvaarinenoutouym15;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARINENOUTOUYM15)
    public String getZrnmvaarinenoutouym15() {
        return zrnmvaarinenoutouym15;
    }

    @DataConvert("toMultiByte")
    public void setZrnmvaarinenoutouym15(String pZrnmvaarinenoutouym15) {
        zrnmvaarinenoutouym15 = pZrnmvaarinenoutouym15;
    }

    private String zrnmvaariwtuktypeup15;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARIWTUKTYPEUP15)
    public String getZrnmvaariwtuktypeup15() {
        return zrnmvaariwtuktypeup15;
    }

    public void setZrnmvaariwtuktypeup15(String pZrnmvaariwtuktypeup15) {
        zrnmvaariwtuktypeup15 = pZrnmvaariwtuktypeup15;
    }

    private String zrnmvaariwup15;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARIWUP15)
    public String getZrnmvaariwup15() {
        return zrnmvaariwup15;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnmvaariwup15(String pZrnmvaariwup15) {
        zrnmvaariwup15 = pZrnmvaariwup15;
    }

    private String zrnmvaariwyentuktypeup15;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARIWYENTUKTYPEUP15)
    public String getZrnmvaariwyentuktypeup15() {
        return zrnmvaariwyentuktypeup15;
    }

    public void setZrnmvaariwyentuktypeup15(String pZrnmvaariwyentuktypeup15) {
        zrnmvaariwyentuktypeup15 = pZrnmvaariwyentuktypeup15;
    }

    private String zrnmvaariwupyendaka15;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARIWUPYENDAKA15)
    public String getZrnmvaariwupyendaka15() {
        return zrnmvaariwupyendaka15;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnmvaariwupyendaka15(String pZrnmvaariwupyendaka15) {
        zrnmvaariwupyendaka15 = pZrnmvaariwupyendaka15;
    }

    private String zrnmvaariwupyenkijyun15;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARIWUPYENKIJYUN15)
    public String getZrnmvaariwupyenkijyun15() {
        return zrnmvaariwupyenkijyun15;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnmvaariwupyenkijyun15(String pZrnmvaariwupyenkijyun15) {
        zrnmvaariwupyenkijyun15 = pZrnmvaariwupyenkijyun15;
    }

    private String zrnmvaariwupyenyasu15;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARIWUPYENYASU15)
    public String getZrnmvaariwupyenyasu15() {
        return zrnmvaariwupyenyasu15;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnmvaariwupyenyasu15(String pZrnmvaariwupyenyasu15) {
        zrnmvaariwupyenyasu15 = pZrnmvaariwupyenyasu15;
    }

    private String zrnmvaariwumupyendaka15;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARIWUMUPYENDAKA15)
    public String getZrnmvaariwumupyendaka15() {
        return zrnmvaariwumupyendaka15;
    }

    public void setZrnmvaariwumupyendaka15(String pZrnmvaariwumupyendaka15) {
        zrnmvaariwumupyendaka15 = pZrnmvaariwumupyendaka15;
    }

    private String zrnmvaariumupyenkijyun15;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARIUMUPYENKIJYUN15)
    public String getZrnmvaariumupyenkijyun15() {
        return zrnmvaariumupyenkijyun15;
    }

    public void setZrnmvaariumupyenkijyun15(String pZrnmvaariumupyenkijyun15) {
        zrnmvaariumupyenkijyun15 = pZrnmvaariumupyenkijyun15;
    }

    private String zrnmvaariumupyenyasu15;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARIUMUPYENYASU15)
    public String getZrnmvaariumupyenyasu15() {
        return zrnmvaariumupyenyasu15;
    }

    public void setZrnmvaariumupyenyasu15(String pZrnmvaariumupyenyasu15) {
        zrnmvaariumupyenyasu15 = pZrnmvaariumupyenyasu15;
    }

    private String zrnmvaariwtuktypesame15;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARIWTUKTYPESAME15)
    public String getZrnmvaariwtuktypesame15() {
        return zrnmvaariwtuktypesame15;
    }

    public void setZrnmvaariwtuktypesame15(String pZrnmvaariwtuktypesame15) {
        zrnmvaariwtuktypesame15 = pZrnmvaariwtuktypesame15;
    }

    private String zrnmvaariwsame15;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARIWSAME15)
    public String getZrnmvaariwsame15() {
        return zrnmvaariwsame15;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnmvaariwsame15(String pZrnmvaariwsame15) {
        zrnmvaariwsame15 = pZrnmvaariwsame15;
    }

    private String zrnmvaariwyentuktypesame15;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARIWYENTUKTYPESAME15)
    public String getZrnmvaariwyentuktypesame15() {
        return zrnmvaariwyentuktypesame15;
    }

    public void setZrnmvaariwyentuktypesame15(String pZrnmvaariwyentuktypesame15) {
        zrnmvaariwyentuktypesame15 = pZrnmvaariwyentuktypesame15;
    }

    private String zrnmvaariwsameyendaka15;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARIWSAMEYENDAKA15)
    public String getZrnmvaariwsameyendaka15() {
        return zrnmvaariwsameyendaka15;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnmvaariwsameyendaka15(String pZrnmvaariwsameyendaka15) {
        zrnmvaariwsameyendaka15 = pZrnmvaariwsameyendaka15;
    }

    private String zrnmvaariwsameyenkijyun15;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARIWSAMEYENKIJYUN15)
    public String getZrnmvaariwsameyenkijyun15() {
        return zrnmvaariwsameyenkijyun15;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnmvaariwsameyenkijyun15(String pZrnmvaariwsameyenkijyun15) {
        zrnmvaariwsameyenkijyun15 = pZrnmvaariwsameyenkijyun15;
    }

    private String zrnmvaariwsameyenyasu15;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARIWSAMEYENYASU15)
    public String getZrnmvaariwsameyenyasu15() {
        return zrnmvaariwsameyenyasu15;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnmvaariwsameyenyasu15(String pZrnmvaariwsameyenyasu15) {
        zrnmvaariwsameyenyasu15 = pZrnmvaariwsameyenyasu15;
    }

    private String zrnmvaariumsameyendaka15;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARIUMSAMEYENDAKA15)
    public String getZrnmvaariumsameyendaka15() {
        return zrnmvaariumsameyendaka15;
    }

    public void setZrnmvaariumsameyendaka15(String pZrnmvaariumsameyendaka15) {
        zrnmvaariumsameyendaka15 = pZrnmvaariumsameyendaka15;
    }

    private String zrnmvaariumsameyenkijyun15;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARIUMSAMEYENKIJYUN15)
    public String getZrnmvaariumsameyenkijyun15() {
        return zrnmvaariumsameyenkijyun15;
    }

    public void setZrnmvaariumsameyenkijyun15(String pZrnmvaariumsameyenkijyun15) {
        zrnmvaariumsameyenkijyun15 = pZrnmvaariumsameyenkijyun15;
    }

    private String zrnmvaariumsameyenyasu15;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARIUMSAMEYENYASU15)
    public String getZrnmvaariumsameyenyasu15() {
        return zrnmvaariumsameyenyasu15;
    }

    public void setZrnmvaariumsameyenyasu15(String pZrnmvaariumsameyenyasu15) {
        zrnmvaariumsameyenyasu15 = pZrnmvaariumsameyenyasu15;
    }

    private String zrnmvaariwtuktypedown15;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARIWTUKTYPEDOWN15)
    public String getZrnmvaariwtuktypedown15() {
        return zrnmvaariwtuktypedown15;
    }

    public void setZrnmvaariwtuktypedown15(String pZrnmvaariwtuktypedown15) {
        zrnmvaariwtuktypedown15 = pZrnmvaariwtuktypedown15;
    }

    private String zrnmvaariwdown15;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARIWDOWN15)
    public String getZrnmvaariwdown15() {
        return zrnmvaariwdown15;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnmvaariwdown15(String pZrnmvaariwdown15) {
        zrnmvaariwdown15 = pZrnmvaariwdown15;
    }

    private String zrnmvaariwyentuktypedown15;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARIWYENTUKTYPEDOWN15)
    public String getZrnmvaariwyentuktypedown15() {
        return zrnmvaariwyentuktypedown15;
    }

    public void setZrnmvaariwyentuktypedown15(String pZrnmvaariwyentuktypedown15) {
        zrnmvaariwyentuktypedown15 = pZrnmvaariwyentuktypedown15;
    }

    private String zrnmvaariwdownyendaka15;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARIWDOWNYENDAKA15)
    public String getZrnmvaariwdownyendaka15() {
        return zrnmvaariwdownyendaka15;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnmvaariwdownyendaka15(String pZrnmvaariwdownyendaka15) {
        zrnmvaariwdownyendaka15 = pZrnmvaariwdownyendaka15;
    }

    private String zrnmvaariwdownyenkijyun15;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARIWDOWNYENKIJYUN15)
    public String getZrnmvaariwdownyenkijyun15() {
        return zrnmvaariwdownyenkijyun15;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnmvaariwdownyenkijyun15(String pZrnmvaariwdownyenkijyun15) {
        zrnmvaariwdownyenkijyun15 = pZrnmvaariwdownyenkijyun15;
    }

    private String zrnmvaariwdownyenyasu15;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARIWDOWNYENYASU15)
    public String getZrnmvaariwdownyenyasu15() {
        return zrnmvaariwdownyenyasu15;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnmvaariwdownyenyasu15(String pZrnmvaariwdownyenyasu15) {
        zrnmvaariwdownyenyasu15 = pZrnmvaariwdownyenyasu15;
    }

    private String zrnmvaariumdownyendaka15;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARIUMDOWNYENDAKA15)
    public String getZrnmvaariumdownyendaka15() {
        return zrnmvaariumdownyendaka15;
    }

    public void setZrnmvaariumdownyendaka15(String pZrnmvaariumdownyendaka15) {
        zrnmvaariumdownyendaka15 = pZrnmvaariumdownyendaka15;
    }

    private String zrnmvaariumdownyenkijyun15;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARIUMDOWNYENKIJYUN15)
    public String getZrnmvaariumdownyenkijyun15() {
        return zrnmvaariumdownyenkijyun15;
    }

    public void setZrnmvaariumdownyenkijyun15(String pZrnmvaariumdownyenkijyun15) {
        zrnmvaariumdownyenkijyun15 = pZrnmvaariumdownyenkijyun15;
    }

    private String zrnmvaariumdownyenyasu15;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARIUMDOWNYENYASU15)
    public String getZrnmvaariumdownyenyasu15() {
        return zrnmvaariumdownyenyasu15;
    }

    public void setZrnmvaariumdownyenyasu15(String pZrnmvaariumdownyenyasu15) {
        zrnmvaariumdownyenyasu15 = pZrnmvaariumdownyenyasu15;
    }

    private String zrnmvaarivtuktype15;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARIVTUKTYPE15)
    public String getZrnmvaarivtuktype15() {
        return zrnmvaarivtuktype15;
    }

    public void setZrnmvaarivtuktype15(String pZrnmvaarivtuktype15) {
        zrnmvaarivtuktype15 = pZrnmvaarivtuktype15;
    }

    private String zrnmvaariv15;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVAARIV15)
    public String getZrnmvaariv15() {
        return zrnmvaariv15;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnmvaariv15(String pZrnmvaariv15) {
        zrnmvaariv15 = pZrnmvaariv15;
    }

    private String zrnmvanonekaisiinnumukbn01;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVANONEKAISIINNUMUKBN01)
    public String getZrnmvanonekaisiinnumukbn01() {
        return zrnmvanonekaisiinnumukbn01;
    }

    public void setZrnmvanonekaisiinnumukbn01(String pZrnmvanonekaisiinnumukbn01) {
        zrnmvanonekaisiinnumukbn01 = pZrnmvanonekaisiinnumukbn01;
    }

    private String zrnmvanonenenoutouym01;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVANONENENOUTOUYM01)
    public String getZrnmvanonenenoutouym01() {
        return zrnmvanonenenoutouym01;
    }

    @DataConvert("toMultiByte")
    public void setZrnmvanonenenoutouym01(String pZrnmvanonenenoutouym01) {
        zrnmvanonenenoutouym01 = pZrnmvanonenenoutouym01;
    }

    private String zrnmvanonewtuktype01;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVANONEWTUKTYPE01)
    public String getZrnmvanonewtuktype01() {
        return zrnmvanonewtuktype01;
    }

    public void setZrnmvanonewtuktype01(String pZrnmvanonewtuktype01) {
        zrnmvanonewtuktype01 = pZrnmvanonewtuktype01;
    }

    private String zrnmvanonew01;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVANONEW01)
    public String getZrnmvanonew01() {
        return zrnmvanonew01;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnmvanonew01(String pZrnmvanonew01) {
        zrnmvanonew01 = pZrnmvanonew01;
    }

    private String zrnmvanonewyentuktype01;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVANONEWYENTUKTYPE01)
    public String getZrnmvanonewyentuktype01() {
        return zrnmvanonewyentuktype01;
    }

    public void setZrnmvanonewyentuktype01(String pZrnmvanonewyentuktype01) {
        zrnmvanonewyentuktype01 = pZrnmvanonewyentuktype01;
    }

    private String zrnmvanonewyendaka01;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVANONEWYENDAKA01)
    public String getZrnmvanonewyendaka01() {
        return zrnmvanonewyendaka01;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnmvanonewyendaka01(String pZrnmvanonewyendaka01) {
        zrnmvanonewyendaka01 = pZrnmvanonewyendaka01;
    }

    private String zrnmvanonewyenkijyun01;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVANONEWYENKIJYUN01)
    public String getZrnmvanonewyenkijyun01() {
        return zrnmvanonewyenkijyun01;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnmvanonewyenkijyun01(String pZrnmvanonewyenkijyun01) {
        zrnmvanonewyenkijyun01 = pZrnmvanonewyenkijyun01;
    }

    private String zrnmvanonewyenyasu01;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVANONEWYENYASU01)
    public String getZrnmvanonewyenyasu01() {
        return zrnmvanonewyenyasu01;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnmvanonewyenyasu01(String pZrnmvanonewyenyasu01) {
        zrnmvanonewyenyasu01 = pZrnmvanonewyenyasu01;
    }

    private String zrnmvanoneumyendaka01;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVANONEUMYENDAKA01)
    public String getZrnmvanoneumyendaka01() {
        return zrnmvanoneumyendaka01;
    }

    public void setZrnmvanoneumyendaka01(String pZrnmvanoneumyendaka01) {
        zrnmvanoneumyendaka01 = pZrnmvanoneumyendaka01;
    }

    private String zrnmvanoneumyenkijyun01;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVANONEUMYENKIJYUN01)
    public String getZrnmvanoneumyenkijyun01() {
        return zrnmvanoneumyenkijyun01;
    }

    public void setZrnmvanoneumyenkijyun01(String pZrnmvanoneumyenkijyun01) {
        zrnmvanoneumyenkijyun01 = pZrnmvanoneumyenkijyun01;
    }

    private String zrnmvanoneumyenyasu01;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVANONEUMYENYASU01)
    public String getZrnmvanoneumyenyasu01() {
        return zrnmvanoneumyenyasu01;
    }

    public void setZrnmvanoneumyenyasu01(String pZrnmvanoneumyenyasu01) {
        zrnmvanoneumyenyasu01 = pZrnmvanoneumyenyasu01;
    }

    private String zrnmvanonevtuktype01;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVANONEVTUKTYPE01)
    public String getZrnmvanonevtuktype01() {
        return zrnmvanonevtuktype01;
    }

    public void setZrnmvanonevtuktype01(String pZrnmvanonevtuktype01) {
        zrnmvanonevtuktype01 = pZrnmvanonevtuktype01;
    }

    private String zrnmvanonev01;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVANONEV01)
    public String getZrnmvanonev01() {
        return zrnmvanonev01;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnmvanonev01(String pZrnmvanonev01) {
        zrnmvanonev01 = pZrnmvanonev01;
    }

    private String zrnmvanonekaisiinnumukbn02;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVANONEKAISIINNUMUKBN02)
    public String getZrnmvanonekaisiinnumukbn02() {
        return zrnmvanonekaisiinnumukbn02;
    }

    public void setZrnmvanonekaisiinnumukbn02(String pZrnmvanonekaisiinnumukbn02) {
        zrnmvanonekaisiinnumukbn02 = pZrnmvanonekaisiinnumukbn02;
    }

    private String zrnmvanonenenoutouym02;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVANONENENOUTOUYM02)
    public String getZrnmvanonenenoutouym02() {
        return zrnmvanonenenoutouym02;
    }

    @DataConvert("toMultiByte")
    public void setZrnmvanonenenoutouym02(String pZrnmvanonenenoutouym02) {
        zrnmvanonenenoutouym02 = pZrnmvanonenenoutouym02;
    }

    private String zrnmvanonewtuktype02;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVANONEWTUKTYPE02)
    public String getZrnmvanonewtuktype02() {
        return zrnmvanonewtuktype02;
    }

    public void setZrnmvanonewtuktype02(String pZrnmvanonewtuktype02) {
        zrnmvanonewtuktype02 = pZrnmvanonewtuktype02;
    }

    private String zrnmvanonew02;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVANONEW02)
    public String getZrnmvanonew02() {
        return zrnmvanonew02;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnmvanonew02(String pZrnmvanonew02) {
        zrnmvanonew02 = pZrnmvanonew02;
    }

    private String zrnmvanonewyentuktype02;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVANONEWYENTUKTYPE02)
    public String getZrnmvanonewyentuktype02() {
        return zrnmvanonewyentuktype02;
    }

    public void setZrnmvanonewyentuktype02(String pZrnmvanonewyentuktype02) {
        zrnmvanonewyentuktype02 = pZrnmvanonewyentuktype02;
    }

    private String zrnmvanonewyendaka02;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVANONEWYENDAKA02)
    public String getZrnmvanonewyendaka02() {
        return zrnmvanonewyendaka02;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnmvanonewyendaka02(String pZrnmvanonewyendaka02) {
        zrnmvanonewyendaka02 = pZrnmvanonewyendaka02;
    }

    private String zrnmvanonewyenkijyun02;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVANONEWYENKIJYUN02)
    public String getZrnmvanonewyenkijyun02() {
        return zrnmvanonewyenkijyun02;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnmvanonewyenkijyun02(String pZrnmvanonewyenkijyun02) {
        zrnmvanonewyenkijyun02 = pZrnmvanonewyenkijyun02;
    }

    private String zrnmvanonewyenyasu02;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVANONEWYENYASU02)
    public String getZrnmvanonewyenyasu02() {
        return zrnmvanonewyenyasu02;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnmvanonewyenyasu02(String pZrnmvanonewyenyasu02) {
        zrnmvanonewyenyasu02 = pZrnmvanonewyenyasu02;
    }

    private String zrnmvanoneumyendaka02;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVANONEUMYENDAKA02)
    public String getZrnmvanoneumyendaka02() {
        return zrnmvanoneumyendaka02;
    }

    public void setZrnmvanoneumyendaka02(String pZrnmvanoneumyendaka02) {
        zrnmvanoneumyendaka02 = pZrnmvanoneumyendaka02;
    }

    private String zrnmvanoneumyenkijyun02;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVANONEUMYENKIJYUN02)
    public String getZrnmvanoneumyenkijyun02() {
        return zrnmvanoneumyenkijyun02;
    }

    public void setZrnmvanoneumyenkijyun02(String pZrnmvanoneumyenkijyun02) {
        zrnmvanoneumyenkijyun02 = pZrnmvanoneumyenkijyun02;
    }

    private String zrnmvanoneumyenyasu02;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVANONEUMYENYASU02)
    public String getZrnmvanoneumyenyasu02() {
        return zrnmvanoneumyenyasu02;
    }

    public void setZrnmvanoneumyenyasu02(String pZrnmvanoneumyenyasu02) {
        zrnmvanoneumyenyasu02 = pZrnmvanoneumyenyasu02;
    }

    private String zrnmvanonevtuktype02;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVANONEVTUKTYPE02)
    public String getZrnmvanonevtuktype02() {
        return zrnmvanonevtuktype02;
    }

    public void setZrnmvanonevtuktype02(String pZrnmvanonevtuktype02) {
        zrnmvanonevtuktype02 = pZrnmvanonevtuktype02;
    }

    private String zrnmvanonev02;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVANONEV02)
    public String getZrnmvanonev02() {
        return zrnmvanonev02;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnmvanonev02(String pZrnmvanonev02) {
        zrnmvanonev02 = pZrnmvanonev02;
    }

    private String zrnmvanonekaisiinnumukbn03;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVANONEKAISIINNUMUKBN03)
    public String getZrnmvanonekaisiinnumukbn03() {
        return zrnmvanonekaisiinnumukbn03;
    }

    public void setZrnmvanonekaisiinnumukbn03(String pZrnmvanonekaisiinnumukbn03) {
        zrnmvanonekaisiinnumukbn03 = pZrnmvanonekaisiinnumukbn03;
    }

    private String zrnmvanonenenoutouym03;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVANONENENOUTOUYM03)
    public String getZrnmvanonenenoutouym03() {
        return zrnmvanonenenoutouym03;
    }

    @DataConvert("toMultiByte")
    public void setZrnmvanonenenoutouym03(String pZrnmvanonenenoutouym03) {
        zrnmvanonenenoutouym03 = pZrnmvanonenenoutouym03;
    }

    private String zrnmvanonewtuktype03;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVANONEWTUKTYPE03)
    public String getZrnmvanonewtuktype03() {
        return zrnmvanonewtuktype03;
    }

    public void setZrnmvanonewtuktype03(String pZrnmvanonewtuktype03) {
        zrnmvanonewtuktype03 = pZrnmvanonewtuktype03;
    }

    private String zrnmvanonew03;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVANONEW03)
    public String getZrnmvanonew03() {
        return zrnmvanonew03;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnmvanonew03(String pZrnmvanonew03) {
        zrnmvanonew03 = pZrnmvanonew03;
    }

    private String zrnmvanonewyentuktype03;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVANONEWYENTUKTYPE03)
    public String getZrnmvanonewyentuktype03() {
        return zrnmvanonewyentuktype03;
    }

    public void setZrnmvanonewyentuktype03(String pZrnmvanonewyentuktype03) {
        zrnmvanonewyentuktype03 = pZrnmvanonewyentuktype03;
    }

    private String zrnmvanonewyendaka03;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVANONEWYENDAKA03)
    public String getZrnmvanonewyendaka03() {
        return zrnmvanonewyendaka03;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnmvanonewyendaka03(String pZrnmvanonewyendaka03) {
        zrnmvanonewyendaka03 = pZrnmvanonewyendaka03;
    }

    private String zrnmvanonewyenkijyun03;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVANONEWYENKIJYUN03)
    public String getZrnmvanonewyenkijyun03() {
        return zrnmvanonewyenkijyun03;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnmvanonewyenkijyun03(String pZrnmvanonewyenkijyun03) {
        zrnmvanonewyenkijyun03 = pZrnmvanonewyenkijyun03;
    }

    private String zrnmvanonewyenyasu03;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVANONEWYENYASU03)
    public String getZrnmvanonewyenyasu03() {
        return zrnmvanonewyenyasu03;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnmvanonewyenyasu03(String pZrnmvanonewyenyasu03) {
        zrnmvanonewyenyasu03 = pZrnmvanonewyenyasu03;
    }

    private String zrnmvanoneumyendaka03;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVANONEUMYENDAKA03)
    public String getZrnmvanoneumyendaka03() {
        return zrnmvanoneumyendaka03;
    }

    public void setZrnmvanoneumyendaka03(String pZrnmvanoneumyendaka03) {
        zrnmvanoneumyendaka03 = pZrnmvanoneumyendaka03;
    }

    private String zrnmvanoneumyenkijyun03;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVANONEUMYENKIJYUN03)
    public String getZrnmvanoneumyenkijyun03() {
        return zrnmvanoneumyenkijyun03;
    }

    public void setZrnmvanoneumyenkijyun03(String pZrnmvanoneumyenkijyun03) {
        zrnmvanoneumyenkijyun03 = pZrnmvanoneumyenkijyun03;
    }

    private String zrnmvanoneumyenyasu03;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVANONEUMYENYASU03)
    public String getZrnmvanoneumyenyasu03() {
        return zrnmvanoneumyenyasu03;
    }

    public void setZrnmvanoneumyenyasu03(String pZrnmvanoneumyenyasu03) {
        zrnmvanoneumyenyasu03 = pZrnmvanoneumyenyasu03;
    }

    private String zrnmvanonevtuktype03;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVANONEVTUKTYPE03)
    public String getZrnmvanonevtuktype03() {
        return zrnmvanonevtuktype03;
    }

    public void setZrnmvanonevtuktype03(String pZrnmvanonevtuktype03) {
        zrnmvanonevtuktype03 = pZrnmvanonevtuktype03;
    }

    private String zrnmvanonev03;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVANONEV03)
    public String getZrnmvanonev03() {
        return zrnmvanonev03;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnmvanonev03(String pZrnmvanonev03) {
        zrnmvanonev03 = pZrnmvanonev03;
    }

    private String zrnmvanonekaisiinnumukbn04;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVANONEKAISIINNUMUKBN04)
    public String getZrnmvanonekaisiinnumukbn04() {
        return zrnmvanonekaisiinnumukbn04;
    }

    public void setZrnmvanonekaisiinnumukbn04(String pZrnmvanonekaisiinnumukbn04) {
        zrnmvanonekaisiinnumukbn04 = pZrnmvanonekaisiinnumukbn04;
    }

    private String zrnmvanonenenoutouym04;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVANONENENOUTOUYM04)
    public String getZrnmvanonenenoutouym04() {
        return zrnmvanonenenoutouym04;
    }

    @DataConvert("toMultiByte")
    public void setZrnmvanonenenoutouym04(String pZrnmvanonenenoutouym04) {
        zrnmvanonenenoutouym04 = pZrnmvanonenenoutouym04;
    }

    private String zrnmvanonewtuktype04;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVANONEWTUKTYPE04)
    public String getZrnmvanonewtuktype04() {
        return zrnmvanonewtuktype04;
    }

    public void setZrnmvanonewtuktype04(String pZrnmvanonewtuktype04) {
        zrnmvanonewtuktype04 = pZrnmvanonewtuktype04;
    }

    private String zrnmvanonew04;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVANONEW04)
    public String getZrnmvanonew04() {
        return zrnmvanonew04;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnmvanonew04(String pZrnmvanonew04) {
        zrnmvanonew04 = pZrnmvanonew04;
    }

    private String zrnmvanonewyentuktype04;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVANONEWYENTUKTYPE04)
    public String getZrnmvanonewyentuktype04() {
        return zrnmvanonewyentuktype04;
    }

    public void setZrnmvanonewyentuktype04(String pZrnmvanonewyentuktype04) {
        zrnmvanonewyentuktype04 = pZrnmvanonewyentuktype04;
    }

    private String zrnmvanonewyendaka04;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVANONEWYENDAKA04)
    public String getZrnmvanonewyendaka04() {
        return zrnmvanonewyendaka04;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnmvanonewyendaka04(String pZrnmvanonewyendaka04) {
        zrnmvanonewyendaka04 = pZrnmvanonewyendaka04;
    }

    private String zrnmvanonewyenkijyun04;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVANONEWYENKIJYUN04)
    public String getZrnmvanonewyenkijyun04() {
        return zrnmvanonewyenkijyun04;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnmvanonewyenkijyun04(String pZrnmvanonewyenkijyun04) {
        zrnmvanonewyenkijyun04 = pZrnmvanonewyenkijyun04;
    }

    private String zrnmvanonewyenyasu04;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVANONEWYENYASU04)
    public String getZrnmvanonewyenyasu04() {
        return zrnmvanonewyenyasu04;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnmvanonewyenyasu04(String pZrnmvanonewyenyasu04) {
        zrnmvanonewyenyasu04 = pZrnmvanonewyenyasu04;
    }

    private String zrnmvanoneumyendaka04;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVANONEUMYENDAKA04)
    public String getZrnmvanoneumyendaka04() {
        return zrnmvanoneumyendaka04;
    }

    public void setZrnmvanoneumyendaka04(String pZrnmvanoneumyendaka04) {
        zrnmvanoneumyendaka04 = pZrnmvanoneumyendaka04;
    }

    private String zrnmvanoneumyenkijyun04;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVANONEUMYENKIJYUN04)
    public String getZrnmvanoneumyenkijyun04() {
        return zrnmvanoneumyenkijyun04;
    }

    public void setZrnmvanoneumyenkijyun04(String pZrnmvanoneumyenkijyun04) {
        zrnmvanoneumyenkijyun04 = pZrnmvanoneumyenkijyun04;
    }

    private String zrnmvanoneumyenyasu04;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVANONEUMYENYASU04)
    public String getZrnmvanoneumyenyasu04() {
        return zrnmvanoneumyenyasu04;
    }

    public void setZrnmvanoneumyenyasu04(String pZrnmvanoneumyenyasu04) {
        zrnmvanoneumyenyasu04 = pZrnmvanoneumyenyasu04;
    }

    private String zrnmvanonevtuktype04;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVANONEVTUKTYPE04)
    public String getZrnmvanonevtuktype04() {
        return zrnmvanonevtuktype04;
    }

    public void setZrnmvanonevtuktype04(String pZrnmvanonevtuktype04) {
        zrnmvanonevtuktype04 = pZrnmvanonevtuktype04;
    }

    private String zrnmvanonev04;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVANONEV04)
    public String getZrnmvanonev04() {
        return zrnmvanonev04;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnmvanonev04(String pZrnmvanonev04) {
        zrnmvanonev04 = pZrnmvanonev04;
    }

    private String zrnmvanonekaisiinnumukbn05;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVANONEKAISIINNUMUKBN05)
    public String getZrnmvanonekaisiinnumukbn05() {
        return zrnmvanonekaisiinnumukbn05;
    }

    public void setZrnmvanonekaisiinnumukbn05(String pZrnmvanonekaisiinnumukbn05) {
        zrnmvanonekaisiinnumukbn05 = pZrnmvanonekaisiinnumukbn05;
    }

    private String zrnmvanonenenoutouym05;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVANONENENOUTOUYM05)
    public String getZrnmvanonenenoutouym05() {
        return zrnmvanonenenoutouym05;
    }

    @DataConvert("toMultiByte")
    public void setZrnmvanonenenoutouym05(String pZrnmvanonenenoutouym05) {
        zrnmvanonenenoutouym05 = pZrnmvanonenenoutouym05;
    }

    private String zrnmvanonewtuktype05;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVANONEWTUKTYPE05)
    public String getZrnmvanonewtuktype05() {
        return zrnmvanonewtuktype05;
    }

    public void setZrnmvanonewtuktype05(String pZrnmvanonewtuktype05) {
        zrnmvanonewtuktype05 = pZrnmvanonewtuktype05;
    }

    private String zrnmvanonew05;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVANONEW05)
    public String getZrnmvanonew05() {
        return zrnmvanonew05;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnmvanonew05(String pZrnmvanonew05) {
        zrnmvanonew05 = pZrnmvanonew05;
    }

    private String zrnmvanonewyentuktype05;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVANONEWYENTUKTYPE05)
    public String getZrnmvanonewyentuktype05() {
        return zrnmvanonewyentuktype05;
    }

    public void setZrnmvanonewyentuktype05(String pZrnmvanonewyentuktype05) {
        zrnmvanonewyentuktype05 = pZrnmvanonewyentuktype05;
    }

    private String zrnmvanonewyendaka05;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVANONEWYENDAKA05)
    public String getZrnmvanonewyendaka05() {
        return zrnmvanonewyendaka05;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnmvanonewyendaka05(String pZrnmvanonewyendaka05) {
        zrnmvanonewyendaka05 = pZrnmvanonewyendaka05;
    }

    private String zrnmvanonewyenkijyun05;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVANONEWYENKIJYUN05)
    public String getZrnmvanonewyenkijyun05() {
        return zrnmvanonewyenkijyun05;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnmvanonewyenkijyun05(String pZrnmvanonewyenkijyun05) {
        zrnmvanonewyenkijyun05 = pZrnmvanonewyenkijyun05;
    }

    private String zrnmvanonewyenyasu05;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVANONEWYENYASU05)
    public String getZrnmvanonewyenyasu05() {
        return zrnmvanonewyenyasu05;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnmvanonewyenyasu05(String pZrnmvanonewyenyasu05) {
        zrnmvanonewyenyasu05 = pZrnmvanonewyenyasu05;
    }

    private String zrnmvanoneumyendaka05;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVANONEUMYENDAKA05)
    public String getZrnmvanoneumyendaka05() {
        return zrnmvanoneumyendaka05;
    }

    public void setZrnmvanoneumyendaka05(String pZrnmvanoneumyendaka05) {
        zrnmvanoneumyendaka05 = pZrnmvanoneumyendaka05;
    }

    private String zrnmvanoneumyenkijyun05;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVANONEUMYENKIJYUN05)
    public String getZrnmvanoneumyenkijyun05() {
        return zrnmvanoneumyenkijyun05;
    }

    public void setZrnmvanoneumyenkijyun05(String pZrnmvanoneumyenkijyun05) {
        zrnmvanoneumyenkijyun05 = pZrnmvanoneumyenkijyun05;
    }

    private String zrnmvanoneumyenyasu05;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVANONEUMYENYASU05)
    public String getZrnmvanoneumyenyasu05() {
        return zrnmvanoneumyenyasu05;
    }

    public void setZrnmvanoneumyenyasu05(String pZrnmvanoneumyenyasu05) {
        zrnmvanoneumyenyasu05 = pZrnmvanoneumyenyasu05;
    }

    private String zrnmvanonevtuktype05;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVANONEVTUKTYPE05)
    public String getZrnmvanonevtuktype05() {
        return zrnmvanonevtuktype05;
    }

    public void setZrnmvanonevtuktype05(String pZrnmvanonevtuktype05) {
        zrnmvanonevtuktype05 = pZrnmvanonevtuktype05;
    }

    private String zrnmvanonev05;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVANONEV05)
    public String getZrnmvanonev05() {
        return zrnmvanonev05;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnmvanonev05(String pZrnmvanonev05) {
        zrnmvanonev05 = pZrnmvanonev05;
    }

    private String zrnmvanonekaisiinnumukbn06;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVANONEKAISIINNUMUKBN06)
    public String getZrnmvanonekaisiinnumukbn06() {
        return zrnmvanonekaisiinnumukbn06;
    }

    public void setZrnmvanonekaisiinnumukbn06(String pZrnmvanonekaisiinnumukbn06) {
        zrnmvanonekaisiinnumukbn06 = pZrnmvanonekaisiinnumukbn06;
    }

    private String zrnmvanonenenoutouym06;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVANONENENOUTOUYM06)
    public String getZrnmvanonenenoutouym06() {
        return zrnmvanonenenoutouym06;
    }

    @DataConvert("toMultiByte")
    public void setZrnmvanonenenoutouym06(String pZrnmvanonenenoutouym06) {
        zrnmvanonenenoutouym06 = pZrnmvanonenenoutouym06;
    }

    private String zrnmvanonewtuktype06;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVANONEWTUKTYPE06)
    public String getZrnmvanonewtuktype06() {
        return zrnmvanonewtuktype06;
    }

    public void setZrnmvanonewtuktype06(String pZrnmvanonewtuktype06) {
        zrnmvanonewtuktype06 = pZrnmvanonewtuktype06;
    }

    private String zrnmvanonew06;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVANONEW06)
    public String getZrnmvanonew06() {
        return zrnmvanonew06;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnmvanonew06(String pZrnmvanonew06) {
        zrnmvanonew06 = pZrnmvanonew06;
    }

    private String zrnmvanonewyentuktype06;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVANONEWYENTUKTYPE06)
    public String getZrnmvanonewyentuktype06() {
        return zrnmvanonewyentuktype06;
    }

    public void setZrnmvanonewyentuktype06(String pZrnmvanonewyentuktype06) {
        zrnmvanonewyentuktype06 = pZrnmvanonewyentuktype06;
    }

    private String zrnmvanonewyendaka06;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVANONEWYENDAKA06)
    public String getZrnmvanonewyendaka06() {
        return zrnmvanonewyendaka06;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnmvanonewyendaka06(String pZrnmvanonewyendaka06) {
        zrnmvanonewyendaka06 = pZrnmvanonewyendaka06;
    }

    private String zrnmvanonewyenkijyun06;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVANONEWYENKIJYUN06)
    public String getZrnmvanonewyenkijyun06() {
        return zrnmvanonewyenkijyun06;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnmvanonewyenkijyun06(String pZrnmvanonewyenkijyun06) {
        zrnmvanonewyenkijyun06 = pZrnmvanonewyenkijyun06;
    }

    private String zrnmvanonewyenyasu06;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVANONEWYENYASU06)
    public String getZrnmvanonewyenyasu06() {
        return zrnmvanonewyenyasu06;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnmvanonewyenyasu06(String pZrnmvanonewyenyasu06) {
        zrnmvanonewyenyasu06 = pZrnmvanonewyenyasu06;
    }

    private String zrnmvanoneumyendaka06;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVANONEUMYENDAKA06)
    public String getZrnmvanoneumyendaka06() {
        return zrnmvanoneumyendaka06;
    }

    public void setZrnmvanoneumyendaka06(String pZrnmvanoneumyendaka06) {
        zrnmvanoneumyendaka06 = pZrnmvanoneumyendaka06;
    }

    private String zrnmvanoneumyenkijyun06;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVANONEUMYENKIJYUN06)
    public String getZrnmvanoneumyenkijyun06() {
        return zrnmvanoneumyenkijyun06;
    }

    public void setZrnmvanoneumyenkijyun06(String pZrnmvanoneumyenkijyun06) {
        zrnmvanoneumyenkijyun06 = pZrnmvanoneumyenkijyun06;
    }

    private String zrnmvanoneumyenyasu06;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVANONEUMYENYASU06)
    public String getZrnmvanoneumyenyasu06() {
        return zrnmvanoneumyenyasu06;
    }

    public void setZrnmvanoneumyenyasu06(String pZrnmvanoneumyenyasu06) {
        zrnmvanoneumyenyasu06 = pZrnmvanoneumyenyasu06;
    }

    private String zrnmvanonevtuktype06;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVANONEVTUKTYPE06)
    public String getZrnmvanonevtuktype06() {
        return zrnmvanonevtuktype06;
    }

    public void setZrnmvanonevtuktype06(String pZrnmvanonevtuktype06) {
        zrnmvanonevtuktype06 = pZrnmvanonevtuktype06;
    }

    private String zrnmvanonev06;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVANONEV06)
    public String getZrnmvanonev06() {
        return zrnmvanonev06;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnmvanonev06(String pZrnmvanonev06) {
        zrnmvanonev06 = pZrnmvanonev06;
    }

    private String zrnmvanonekaisiinnumukbn07;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVANONEKAISIINNUMUKBN07)
    public String getZrnmvanonekaisiinnumukbn07() {
        return zrnmvanonekaisiinnumukbn07;
    }

    public void setZrnmvanonekaisiinnumukbn07(String pZrnmvanonekaisiinnumukbn07) {
        zrnmvanonekaisiinnumukbn07 = pZrnmvanonekaisiinnumukbn07;
    }

    private String zrnmvanonenenoutouym07;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVANONENENOUTOUYM07)
    public String getZrnmvanonenenoutouym07() {
        return zrnmvanonenenoutouym07;
    }

    @DataConvert("toMultiByte")
    public void setZrnmvanonenenoutouym07(String pZrnmvanonenenoutouym07) {
        zrnmvanonenenoutouym07 = pZrnmvanonenenoutouym07;
    }

    private String zrnmvanonewtuktype07;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVANONEWTUKTYPE07)
    public String getZrnmvanonewtuktype07() {
        return zrnmvanonewtuktype07;
    }

    public void setZrnmvanonewtuktype07(String pZrnmvanonewtuktype07) {
        zrnmvanonewtuktype07 = pZrnmvanonewtuktype07;
    }

    private String zrnmvanonew07;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVANONEW07)
    public String getZrnmvanonew07() {
        return zrnmvanonew07;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnmvanonew07(String pZrnmvanonew07) {
        zrnmvanonew07 = pZrnmvanonew07;
    }

    private String zrnmvanonewyentuktype07;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVANONEWYENTUKTYPE07)
    public String getZrnmvanonewyentuktype07() {
        return zrnmvanonewyentuktype07;
    }

    public void setZrnmvanonewyentuktype07(String pZrnmvanonewyentuktype07) {
        zrnmvanonewyentuktype07 = pZrnmvanonewyentuktype07;
    }

    private String zrnmvanonewyendaka07;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVANONEWYENDAKA07)
    public String getZrnmvanonewyendaka07() {
        return zrnmvanonewyendaka07;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnmvanonewyendaka07(String pZrnmvanonewyendaka07) {
        zrnmvanonewyendaka07 = pZrnmvanonewyendaka07;
    }

    private String zrnmvanonewyenkijyun07;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVANONEWYENKIJYUN07)
    public String getZrnmvanonewyenkijyun07() {
        return zrnmvanonewyenkijyun07;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnmvanonewyenkijyun07(String pZrnmvanonewyenkijyun07) {
        zrnmvanonewyenkijyun07 = pZrnmvanonewyenkijyun07;
    }

    private String zrnmvanonewyenyasu07;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVANONEWYENYASU07)
    public String getZrnmvanonewyenyasu07() {
        return zrnmvanonewyenyasu07;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnmvanonewyenyasu07(String pZrnmvanonewyenyasu07) {
        zrnmvanonewyenyasu07 = pZrnmvanonewyenyasu07;
    }

    private String zrnmvanoneumyendaka07;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVANONEUMYENDAKA07)
    public String getZrnmvanoneumyendaka07() {
        return zrnmvanoneumyendaka07;
    }

    public void setZrnmvanoneumyendaka07(String pZrnmvanoneumyendaka07) {
        zrnmvanoneumyendaka07 = pZrnmvanoneumyendaka07;
    }

    private String zrnmvanoneumyenkijyun07;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVANONEUMYENKIJYUN07)
    public String getZrnmvanoneumyenkijyun07() {
        return zrnmvanoneumyenkijyun07;
    }

    public void setZrnmvanoneumyenkijyun07(String pZrnmvanoneumyenkijyun07) {
        zrnmvanoneumyenkijyun07 = pZrnmvanoneumyenkijyun07;
    }

    private String zrnmvanoneumyenyasu07;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVANONEUMYENYASU07)
    public String getZrnmvanoneumyenyasu07() {
        return zrnmvanoneumyenyasu07;
    }

    public void setZrnmvanoneumyenyasu07(String pZrnmvanoneumyenyasu07) {
        zrnmvanoneumyenyasu07 = pZrnmvanoneumyenyasu07;
    }

    private String zrnmvanonevtuktype07;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVANONEVTUKTYPE07)
    public String getZrnmvanonevtuktype07() {
        return zrnmvanonevtuktype07;
    }

    public void setZrnmvanonevtuktype07(String pZrnmvanonevtuktype07) {
        zrnmvanonevtuktype07 = pZrnmvanonevtuktype07;
    }

    private String zrnmvanonev07;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVANONEV07)
    public String getZrnmvanonev07() {
        return zrnmvanonev07;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnmvanonev07(String pZrnmvanonev07) {
        zrnmvanonev07 = pZrnmvanonev07;
    }

    private String zrnmvanonekaisiinnumukbn08;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVANONEKAISIINNUMUKBN08)
    public String getZrnmvanonekaisiinnumukbn08() {
        return zrnmvanonekaisiinnumukbn08;
    }

    public void setZrnmvanonekaisiinnumukbn08(String pZrnmvanonekaisiinnumukbn08) {
        zrnmvanonekaisiinnumukbn08 = pZrnmvanonekaisiinnumukbn08;
    }

    private String zrnmvanonenenoutouym08;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVANONENENOUTOUYM08)
    public String getZrnmvanonenenoutouym08() {
        return zrnmvanonenenoutouym08;
    }

    @DataConvert("toMultiByte")
    public void setZrnmvanonenenoutouym08(String pZrnmvanonenenoutouym08) {
        zrnmvanonenenoutouym08 = pZrnmvanonenenoutouym08;
    }

    private String zrnmvanonewtuktype08;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVANONEWTUKTYPE08)
    public String getZrnmvanonewtuktype08() {
        return zrnmvanonewtuktype08;
    }

    public void setZrnmvanonewtuktype08(String pZrnmvanonewtuktype08) {
        zrnmvanonewtuktype08 = pZrnmvanonewtuktype08;
    }

    private String zrnmvanonew08;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVANONEW08)
    public String getZrnmvanonew08() {
        return zrnmvanonew08;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnmvanonew08(String pZrnmvanonew08) {
        zrnmvanonew08 = pZrnmvanonew08;
    }

    private String zrnmvanonewyentuktype08;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVANONEWYENTUKTYPE08)
    public String getZrnmvanonewyentuktype08() {
        return zrnmvanonewyentuktype08;
    }

    public void setZrnmvanonewyentuktype08(String pZrnmvanonewyentuktype08) {
        zrnmvanonewyentuktype08 = pZrnmvanonewyentuktype08;
    }

    private String zrnmvanonewyendaka08;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVANONEWYENDAKA08)
    public String getZrnmvanonewyendaka08() {
        return zrnmvanonewyendaka08;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnmvanonewyendaka08(String pZrnmvanonewyendaka08) {
        zrnmvanonewyendaka08 = pZrnmvanonewyendaka08;
    }

    private String zrnmvanonewyenkijyun08;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVANONEWYENKIJYUN08)
    public String getZrnmvanonewyenkijyun08() {
        return zrnmvanonewyenkijyun08;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnmvanonewyenkijyun08(String pZrnmvanonewyenkijyun08) {
        zrnmvanonewyenkijyun08 = pZrnmvanonewyenkijyun08;
    }

    private String zrnmvanonewyenyasu08;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVANONEWYENYASU08)
    public String getZrnmvanonewyenyasu08() {
        return zrnmvanonewyenyasu08;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnmvanonewyenyasu08(String pZrnmvanonewyenyasu08) {
        zrnmvanonewyenyasu08 = pZrnmvanonewyenyasu08;
    }

    private String zrnmvanoneumyendaka08;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVANONEUMYENDAKA08)
    public String getZrnmvanoneumyendaka08() {
        return zrnmvanoneumyendaka08;
    }

    public void setZrnmvanoneumyendaka08(String pZrnmvanoneumyendaka08) {
        zrnmvanoneumyendaka08 = pZrnmvanoneumyendaka08;
    }

    private String zrnmvanoneumyenkijyun08;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVANONEUMYENKIJYUN08)
    public String getZrnmvanoneumyenkijyun08() {
        return zrnmvanoneumyenkijyun08;
    }

    public void setZrnmvanoneumyenkijyun08(String pZrnmvanoneumyenkijyun08) {
        zrnmvanoneumyenkijyun08 = pZrnmvanoneumyenkijyun08;
    }

    private String zrnmvanoneumyenyasu08;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVANONEUMYENYASU08)
    public String getZrnmvanoneumyenyasu08() {
        return zrnmvanoneumyenyasu08;
    }

    public void setZrnmvanoneumyenyasu08(String pZrnmvanoneumyenyasu08) {
        zrnmvanoneumyenyasu08 = pZrnmvanoneumyenyasu08;
    }

    private String zrnmvanonevtuktype08;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVANONEVTUKTYPE08)
    public String getZrnmvanonevtuktype08() {
        return zrnmvanonevtuktype08;
    }

    public void setZrnmvanonevtuktype08(String pZrnmvanonevtuktype08) {
        zrnmvanonevtuktype08 = pZrnmvanonevtuktype08;
    }

    private String zrnmvanonev08;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVANONEV08)
    public String getZrnmvanonev08() {
        return zrnmvanonev08;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnmvanonev08(String pZrnmvanonev08) {
        zrnmvanonev08 = pZrnmvanonev08;
    }

    private String zrnmvanonekaisiinnumukbn09;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVANONEKAISIINNUMUKBN09)
    public String getZrnmvanonekaisiinnumukbn09() {
        return zrnmvanonekaisiinnumukbn09;
    }

    public void setZrnmvanonekaisiinnumukbn09(String pZrnmvanonekaisiinnumukbn09) {
        zrnmvanonekaisiinnumukbn09 = pZrnmvanonekaisiinnumukbn09;
    }

    private String zrnmvanonenenoutouym09;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVANONENENOUTOUYM09)
    public String getZrnmvanonenenoutouym09() {
        return zrnmvanonenenoutouym09;
    }

    @DataConvert("toMultiByte")
    public void setZrnmvanonenenoutouym09(String pZrnmvanonenenoutouym09) {
        zrnmvanonenenoutouym09 = pZrnmvanonenenoutouym09;
    }

    private String zrnmvanonewtuktype09;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVANONEWTUKTYPE09)
    public String getZrnmvanonewtuktype09() {
        return zrnmvanonewtuktype09;
    }

    public void setZrnmvanonewtuktype09(String pZrnmvanonewtuktype09) {
        zrnmvanonewtuktype09 = pZrnmvanonewtuktype09;
    }

    private String zrnmvanonew09;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVANONEW09)
    public String getZrnmvanonew09() {
        return zrnmvanonew09;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnmvanonew09(String pZrnmvanonew09) {
        zrnmvanonew09 = pZrnmvanonew09;
    }

    private String zrnmvanonewyentuktype09;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVANONEWYENTUKTYPE09)
    public String getZrnmvanonewyentuktype09() {
        return zrnmvanonewyentuktype09;
    }

    public void setZrnmvanonewyentuktype09(String pZrnmvanonewyentuktype09) {
        zrnmvanonewyentuktype09 = pZrnmvanonewyentuktype09;
    }

    private String zrnmvanonewyendaka09;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVANONEWYENDAKA09)
    public String getZrnmvanonewyendaka09() {
        return zrnmvanonewyendaka09;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnmvanonewyendaka09(String pZrnmvanonewyendaka09) {
        zrnmvanonewyendaka09 = pZrnmvanonewyendaka09;
    }

    private String zrnmvanonewyenkijyun09;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVANONEWYENKIJYUN09)
    public String getZrnmvanonewyenkijyun09() {
        return zrnmvanonewyenkijyun09;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnmvanonewyenkijyun09(String pZrnmvanonewyenkijyun09) {
        zrnmvanonewyenkijyun09 = pZrnmvanonewyenkijyun09;
    }

    private String zrnmvanonewyenyasu09;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVANONEWYENYASU09)
    public String getZrnmvanonewyenyasu09() {
        return zrnmvanonewyenyasu09;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnmvanonewyenyasu09(String pZrnmvanonewyenyasu09) {
        zrnmvanonewyenyasu09 = pZrnmvanonewyenyasu09;
    }

    private String zrnmvanoneumyendaka09;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVANONEUMYENDAKA09)
    public String getZrnmvanoneumyendaka09() {
        return zrnmvanoneumyendaka09;
    }

    public void setZrnmvanoneumyendaka09(String pZrnmvanoneumyendaka09) {
        zrnmvanoneumyendaka09 = pZrnmvanoneumyendaka09;
    }

    private String zrnmvanoneumyenkijyun09;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVANONEUMYENKIJYUN09)
    public String getZrnmvanoneumyenkijyun09() {
        return zrnmvanoneumyenkijyun09;
    }

    public void setZrnmvanoneumyenkijyun09(String pZrnmvanoneumyenkijyun09) {
        zrnmvanoneumyenkijyun09 = pZrnmvanoneumyenkijyun09;
    }

    private String zrnmvanoneumyenyasu09;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVANONEUMYENYASU09)
    public String getZrnmvanoneumyenyasu09() {
        return zrnmvanoneumyenyasu09;
    }

    public void setZrnmvanoneumyenyasu09(String pZrnmvanoneumyenyasu09) {
        zrnmvanoneumyenyasu09 = pZrnmvanoneumyenyasu09;
    }

    private String zrnmvanonevtuktype09;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVANONEVTUKTYPE09)
    public String getZrnmvanonevtuktype09() {
        return zrnmvanonevtuktype09;
    }

    public void setZrnmvanonevtuktype09(String pZrnmvanonevtuktype09) {
        zrnmvanonevtuktype09 = pZrnmvanonevtuktype09;
    }

    private String zrnmvanonev09;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVANONEV09)
    public String getZrnmvanonev09() {
        return zrnmvanonev09;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnmvanonev09(String pZrnmvanonev09) {
        zrnmvanonev09 = pZrnmvanonev09;
    }

    private String zrnmvanonekaisiinnumukbn10;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVANONEKAISIINNUMUKBN10)
    public String getZrnmvanonekaisiinnumukbn10() {
        return zrnmvanonekaisiinnumukbn10;
    }

    public void setZrnmvanonekaisiinnumukbn10(String pZrnmvanonekaisiinnumukbn10) {
        zrnmvanonekaisiinnumukbn10 = pZrnmvanonekaisiinnumukbn10;
    }

    private String zrnmvanonenenoutouym10;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVANONENENOUTOUYM10)
    public String getZrnmvanonenenoutouym10() {
        return zrnmvanonenenoutouym10;
    }

    @DataConvert("toMultiByte")
    public void setZrnmvanonenenoutouym10(String pZrnmvanonenenoutouym10) {
        zrnmvanonenenoutouym10 = pZrnmvanonenenoutouym10;
    }

    private String zrnmvanonewtuktype10;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVANONEWTUKTYPE10)
    public String getZrnmvanonewtuktype10() {
        return zrnmvanonewtuktype10;
    }

    public void setZrnmvanonewtuktype10(String pZrnmvanonewtuktype10) {
        zrnmvanonewtuktype10 = pZrnmvanonewtuktype10;
    }

    private String zrnmvanonew10;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVANONEW10)
    public String getZrnmvanonew10() {
        return zrnmvanonew10;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnmvanonew10(String pZrnmvanonew10) {
        zrnmvanonew10 = pZrnmvanonew10;
    }

    private String zrnmvanonewyentuktype10;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVANONEWYENTUKTYPE10)
    public String getZrnmvanonewyentuktype10() {
        return zrnmvanonewyentuktype10;
    }

    public void setZrnmvanonewyentuktype10(String pZrnmvanonewyentuktype10) {
        zrnmvanonewyentuktype10 = pZrnmvanonewyentuktype10;
    }

    private String zrnmvanonewyendaka10;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVANONEWYENDAKA10)
    public String getZrnmvanonewyendaka10() {
        return zrnmvanonewyendaka10;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnmvanonewyendaka10(String pZrnmvanonewyendaka10) {
        zrnmvanonewyendaka10 = pZrnmvanonewyendaka10;
    }

    private String zrnmvanonewyenkijyun10;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVANONEWYENKIJYUN10)
    public String getZrnmvanonewyenkijyun10() {
        return zrnmvanonewyenkijyun10;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnmvanonewyenkijyun10(String pZrnmvanonewyenkijyun10) {
        zrnmvanonewyenkijyun10 = pZrnmvanonewyenkijyun10;
    }

    private String zrnmvanonewyenyasu10;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVANONEWYENYASU10)
    public String getZrnmvanonewyenyasu10() {
        return zrnmvanonewyenyasu10;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnmvanonewyenyasu10(String pZrnmvanonewyenyasu10) {
        zrnmvanonewyenyasu10 = pZrnmvanonewyenyasu10;
    }

    private String zrnmvanoneumyendaka10;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVANONEUMYENDAKA10)
    public String getZrnmvanoneumyendaka10() {
        return zrnmvanoneumyendaka10;
    }

    public void setZrnmvanoneumyendaka10(String pZrnmvanoneumyendaka10) {
        zrnmvanoneumyendaka10 = pZrnmvanoneumyendaka10;
    }

    private String zrnmvanoneumyenkijyun10;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVANONEUMYENKIJYUN10)
    public String getZrnmvanoneumyenkijyun10() {
        return zrnmvanoneumyenkijyun10;
    }

    public void setZrnmvanoneumyenkijyun10(String pZrnmvanoneumyenkijyun10) {
        zrnmvanoneumyenkijyun10 = pZrnmvanoneumyenkijyun10;
    }

    private String zrnmvanoneumyenyasu10;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVANONEUMYENYASU10)
    public String getZrnmvanoneumyenyasu10() {
        return zrnmvanoneumyenyasu10;
    }

    public void setZrnmvanoneumyenyasu10(String pZrnmvanoneumyenyasu10) {
        zrnmvanoneumyenyasu10 = pZrnmvanoneumyenyasu10;
    }

    private String zrnmvanonevtuktype10;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVANONEVTUKTYPE10)
    public String getZrnmvanonevtuktype10() {
        return zrnmvanonevtuktype10;
    }

    public void setZrnmvanonevtuktype10(String pZrnmvanonevtuktype10) {
        zrnmvanonevtuktype10 = pZrnmvanonevtuktype10;
    }

    private String zrnmvanonev10;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVANONEV10)
    public String getZrnmvanonev10() {
        return zrnmvanonev10;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnmvanonev10(String pZrnmvanonev10) {
        zrnmvanonev10 = pZrnmvanonev10;
    }

    private String zrnmvanonekaisiinnumukbn11;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVANONEKAISIINNUMUKBN11)
    public String getZrnmvanonekaisiinnumukbn11() {
        return zrnmvanonekaisiinnumukbn11;
    }

    public void setZrnmvanonekaisiinnumukbn11(String pZrnmvanonekaisiinnumukbn11) {
        zrnmvanonekaisiinnumukbn11 = pZrnmvanonekaisiinnumukbn11;
    }

    private String zrnmvanonenenoutouym11;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVANONENENOUTOUYM11)
    public String getZrnmvanonenenoutouym11() {
        return zrnmvanonenenoutouym11;
    }

    @DataConvert("toMultiByte")
    public void setZrnmvanonenenoutouym11(String pZrnmvanonenenoutouym11) {
        zrnmvanonenenoutouym11 = pZrnmvanonenenoutouym11;
    }

    private String zrnmvanonewtuktype11;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVANONEWTUKTYPE11)
    public String getZrnmvanonewtuktype11() {
        return zrnmvanonewtuktype11;
    }

    public void setZrnmvanonewtuktype11(String pZrnmvanonewtuktype11) {
        zrnmvanonewtuktype11 = pZrnmvanonewtuktype11;
    }

    private String zrnmvanonew11;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVANONEW11)
    public String getZrnmvanonew11() {
        return zrnmvanonew11;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnmvanonew11(String pZrnmvanonew11) {
        zrnmvanonew11 = pZrnmvanonew11;
    }

    private String zrnmvanonewyentuktype11;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVANONEWYENTUKTYPE11)
    public String getZrnmvanonewyentuktype11() {
        return zrnmvanonewyentuktype11;
    }

    public void setZrnmvanonewyentuktype11(String pZrnmvanonewyentuktype11) {
        zrnmvanonewyentuktype11 = pZrnmvanonewyentuktype11;
    }

    private String zrnmvanonewyendaka11;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVANONEWYENDAKA11)
    public String getZrnmvanonewyendaka11() {
        return zrnmvanonewyendaka11;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnmvanonewyendaka11(String pZrnmvanonewyendaka11) {
        zrnmvanonewyendaka11 = pZrnmvanonewyendaka11;
    }

    private String zrnmvanonewyenkijyun11;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVANONEWYENKIJYUN11)
    public String getZrnmvanonewyenkijyun11() {
        return zrnmvanonewyenkijyun11;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnmvanonewyenkijyun11(String pZrnmvanonewyenkijyun11) {
        zrnmvanonewyenkijyun11 = pZrnmvanonewyenkijyun11;
    }

    private String zrnmvanonewyenyasu11;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVANONEWYENYASU11)
    public String getZrnmvanonewyenyasu11() {
        return zrnmvanonewyenyasu11;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnmvanonewyenyasu11(String pZrnmvanonewyenyasu11) {
        zrnmvanonewyenyasu11 = pZrnmvanonewyenyasu11;
    }

    private String zrnmvanoneumyendaka11;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVANONEUMYENDAKA11)
    public String getZrnmvanoneumyendaka11() {
        return zrnmvanoneumyendaka11;
    }

    public void setZrnmvanoneumyendaka11(String pZrnmvanoneumyendaka11) {
        zrnmvanoneumyendaka11 = pZrnmvanoneumyendaka11;
    }

    private String zrnmvanoneumyenkijyun11;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVANONEUMYENKIJYUN11)
    public String getZrnmvanoneumyenkijyun11() {
        return zrnmvanoneumyenkijyun11;
    }

    public void setZrnmvanoneumyenkijyun11(String pZrnmvanoneumyenkijyun11) {
        zrnmvanoneumyenkijyun11 = pZrnmvanoneumyenkijyun11;
    }

    private String zrnmvanoneumyenyasu11;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVANONEUMYENYASU11)
    public String getZrnmvanoneumyenyasu11() {
        return zrnmvanoneumyenyasu11;
    }

    public void setZrnmvanoneumyenyasu11(String pZrnmvanoneumyenyasu11) {
        zrnmvanoneumyenyasu11 = pZrnmvanoneumyenyasu11;
    }

    private String zrnmvanonevtuktype11;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVANONEVTUKTYPE11)
    public String getZrnmvanonevtuktype11() {
        return zrnmvanonevtuktype11;
    }

    public void setZrnmvanonevtuktype11(String pZrnmvanonevtuktype11) {
        zrnmvanonevtuktype11 = pZrnmvanonevtuktype11;
    }

    private String zrnmvanonev11;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVANONEV11)
    public String getZrnmvanonev11() {
        return zrnmvanonev11;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnmvanonev11(String pZrnmvanonev11) {
        zrnmvanonev11 = pZrnmvanonev11;
    }

    private String zrnmvanonekaisiinnumukbn12;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVANONEKAISIINNUMUKBN12)
    public String getZrnmvanonekaisiinnumukbn12() {
        return zrnmvanonekaisiinnumukbn12;
    }

    public void setZrnmvanonekaisiinnumukbn12(String pZrnmvanonekaisiinnumukbn12) {
        zrnmvanonekaisiinnumukbn12 = pZrnmvanonekaisiinnumukbn12;
    }

    private String zrnmvanonenenoutouym12;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVANONENENOUTOUYM12)
    public String getZrnmvanonenenoutouym12() {
        return zrnmvanonenenoutouym12;
    }

    @DataConvert("toMultiByte")
    public void setZrnmvanonenenoutouym12(String pZrnmvanonenenoutouym12) {
        zrnmvanonenenoutouym12 = pZrnmvanonenenoutouym12;
    }

    private String zrnmvanonewtuktype12;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVANONEWTUKTYPE12)
    public String getZrnmvanonewtuktype12() {
        return zrnmvanonewtuktype12;
    }

    public void setZrnmvanonewtuktype12(String pZrnmvanonewtuktype12) {
        zrnmvanonewtuktype12 = pZrnmvanonewtuktype12;
    }

    private String zrnmvanonew12;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVANONEW12)
    public String getZrnmvanonew12() {
        return zrnmvanonew12;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnmvanonew12(String pZrnmvanonew12) {
        zrnmvanonew12 = pZrnmvanonew12;
    }

    private String zrnmvanonewyentuktype12;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVANONEWYENTUKTYPE12)
    public String getZrnmvanonewyentuktype12() {
        return zrnmvanonewyentuktype12;
    }

    public void setZrnmvanonewyentuktype12(String pZrnmvanonewyentuktype12) {
        zrnmvanonewyentuktype12 = pZrnmvanonewyentuktype12;
    }

    private String zrnmvanonewyendaka12;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVANONEWYENDAKA12)
    public String getZrnmvanonewyendaka12() {
        return zrnmvanonewyendaka12;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnmvanonewyendaka12(String pZrnmvanonewyendaka12) {
        zrnmvanonewyendaka12 = pZrnmvanonewyendaka12;
    }

    private String zrnmvanonewyenkijyun12;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVANONEWYENKIJYUN12)
    public String getZrnmvanonewyenkijyun12() {
        return zrnmvanonewyenkijyun12;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnmvanonewyenkijyun12(String pZrnmvanonewyenkijyun12) {
        zrnmvanonewyenkijyun12 = pZrnmvanonewyenkijyun12;
    }

    private String zrnmvanonewyenyasu12;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVANONEWYENYASU12)
    public String getZrnmvanonewyenyasu12() {
        return zrnmvanonewyenyasu12;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnmvanonewyenyasu12(String pZrnmvanonewyenyasu12) {
        zrnmvanonewyenyasu12 = pZrnmvanonewyenyasu12;
    }

    private String zrnmvanoneumyendaka12;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVANONEUMYENDAKA12)
    public String getZrnmvanoneumyendaka12() {
        return zrnmvanoneumyendaka12;
    }

    public void setZrnmvanoneumyendaka12(String pZrnmvanoneumyendaka12) {
        zrnmvanoneumyendaka12 = pZrnmvanoneumyendaka12;
    }

    private String zrnmvanoneumyenkijyun12;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVANONEUMYENKIJYUN12)
    public String getZrnmvanoneumyenkijyun12() {
        return zrnmvanoneumyenkijyun12;
    }

    public void setZrnmvanoneumyenkijyun12(String pZrnmvanoneumyenkijyun12) {
        zrnmvanoneumyenkijyun12 = pZrnmvanoneumyenkijyun12;
    }

    private String zrnmvanoneumyenyasu12;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVANONEUMYENYASU12)
    public String getZrnmvanoneumyenyasu12() {
        return zrnmvanoneumyenyasu12;
    }

    public void setZrnmvanoneumyenyasu12(String pZrnmvanoneumyenyasu12) {
        zrnmvanoneumyenyasu12 = pZrnmvanoneumyenyasu12;
    }

    private String zrnmvanonevtuktype12;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVANONEVTUKTYPE12)
    public String getZrnmvanonevtuktype12() {
        return zrnmvanonevtuktype12;
    }

    public void setZrnmvanonevtuktype12(String pZrnmvanonevtuktype12) {
        zrnmvanonevtuktype12 = pZrnmvanonevtuktype12;
    }

    private String zrnmvanonev12;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVANONEV12)
    public String getZrnmvanonev12() {
        return zrnmvanonev12;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnmvanonev12(String pZrnmvanonev12) {
        zrnmvanonev12 = pZrnmvanonev12;
    }

    private String zrnmvanonekaisiinnumukbn13;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVANONEKAISIINNUMUKBN13)
    public String getZrnmvanonekaisiinnumukbn13() {
        return zrnmvanonekaisiinnumukbn13;
    }

    public void setZrnmvanonekaisiinnumukbn13(String pZrnmvanonekaisiinnumukbn13) {
        zrnmvanonekaisiinnumukbn13 = pZrnmvanonekaisiinnumukbn13;
    }

    private String zrnmvanonenenoutouym13;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVANONENENOUTOUYM13)
    public String getZrnmvanonenenoutouym13() {
        return zrnmvanonenenoutouym13;
    }

    @DataConvert("toMultiByte")
    public void setZrnmvanonenenoutouym13(String pZrnmvanonenenoutouym13) {
        zrnmvanonenenoutouym13 = pZrnmvanonenenoutouym13;
    }

    private String zrnmvanonewtuktype13;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVANONEWTUKTYPE13)
    public String getZrnmvanonewtuktype13() {
        return zrnmvanonewtuktype13;
    }

    public void setZrnmvanonewtuktype13(String pZrnmvanonewtuktype13) {
        zrnmvanonewtuktype13 = pZrnmvanonewtuktype13;
    }

    private String zrnmvanonew13;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVANONEW13)
    public String getZrnmvanonew13() {
        return zrnmvanonew13;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnmvanonew13(String pZrnmvanonew13) {
        zrnmvanonew13 = pZrnmvanonew13;
    }

    private String zrnmvanonewyentuktype13;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVANONEWYENTUKTYPE13)
    public String getZrnmvanonewyentuktype13() {
        return zrnmvanonewyentuktype13;
    }

    public void setZrnmvanonewyentuktype13(String pZrnmvanonewyentuktype13) {
        zrnmvanonewyentuktype13 = pZrnmvanonewyentuktype13;
    }

    private String zrnmvanonewyendaka13;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVANONEWYENDAKA13)
    public String getZrnmvanonewyendaka13() {
        return zrnmvanonewyendaka13;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnmvanonewyendaka13(String pZrnmvanonewyendaka13) {
        zrnmvanonewyendaka13 = pZrnmvanonewyendaka13;
    }

    private String zrnmvanonewyenkijyun13;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVANONEWYENKIJYUN13)
    public String getZrnmvanonewyenkijyun13() {
        return zrnmvanonewyenkijyun13;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnmvanonewyenkijyun13(String pZrnmvanonewyenkijyun13) {
        zrnmvanonewyenkijyun13 = pZrnmvanonewyenkijyun13;
    }

    private String zrnmvanonewyenyasu13;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVANONEWYENYASU13)
    public String getZrnmvanonewyenyasu13() {
        return zrnmvanonewyenyasu13;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnmvanonewyenyasu13(String pZrnmvanonewyenyasu13) {
        zrnmvanonewyenyasu13 = pZrnmvanonewyenyasu13;
    }

    private String zrnmvanoneumyendaka13;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVANONEUMYENDAKA13)
    public String getZrnmvanoneumyendaka13() {
        return zrnmvanoneumyendaka13;
    }

    public void setZrnmvanoneumyendaka13(String pZrnmvanoneumyendaka13) {
        zrnmvanoneumyendaka13 = pZrnmvanoneumyendaka13;
    }

    private String zrnmvanoneumyenkijyun13;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVANONEUMYENKIJYUN13)
    public String getZrnmvanoneumyenkijyun13() {
        return zrnmvanoneumyenkijyun13;
    }

    public void setZrnmvanoneumyenkijyun13(String pZrnmvanoneumyenkijyun13) {
        zrnmvanoneumyenkijyun13 = pZrnmvanoneumyenkijyun13;
    }

    private String zrnmvanoneumyenyasu13;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVANONEUMYENYASU13)
    public String getZrnmvanoneumyenyasu13() {
        return zrnmvanoneumyenyasu13;
    }

    public void setZrnmvanoneumyenyasu13(String pZrnmvanoneumyenyasu13) {
        zrnmvanoneumyenyasu13 = pZrnmvanoneumyenyasu13;
    }

    private String zrnmvanonevtuktype13;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVANONEVTUKTYPE13)
    public String getZrnmvanonevtuktype13() {
        return zrnmvanonevtuktype13;
    }

    public void setZrnmvanonevtuktype13(String pZrnmvanonevtuktype13) {
        zrnmvanonevtuktype13 = pZrnmvanonevtuktype13;
    }

    private String zrnmvanonev13;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVANONEV13)
    public String getZrnmvanonev13() {
        return zrnmvanonev13;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnmvanonev13(String pZrnmvanonev13) {
        zrnmvanonev13 = pZrnmvanonev13;
    }

    private String zrnmvanonekaisiinnumukbn14;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVANONEKAISIINNUMUKBN14)
    public String getZrnmvanonekaisiinnumukbn14() {
        return zrnmvanonekaisiinnumukbn14;
    }

    public void setZrnmvanonekaisiinnumukbn14(String pZrnmvanonekaisiinnumukbn14) {
        zrnmvanonekaisiinnumukbn14 = pZrnmvanonekaisiinnumukbn14;
    }

    private String zrnmvanonenenoutouym14;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVANONENENOUTOUYM14)
    public String getZrnmvanonenenoutouym14() {
        return zrnmvanonenenoutouym14;
    }

    @DataConvert("toMultiByte")
    public void setZrnmvanonenenoutouym14(String pZrnmvanonenenoutouym14) {
        zrnmvanonenenoutouym14 = pZrnmvanonenenoutouym14;
    }

    private String zrnmvanonewtuktype14;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVANONEWTUKTYPE14)
    public String getZrnmvanonewtuktype14() {
        return zrnmvanonewtuktype14;
    }

    public void setZrnmvanonewtuktype14(String pZrnmvanonewtuktype14) {
        zrnmvanonewtuktype14 = pZrnmvanonewtuktype14;
    }

    private String zrnmvanonew14;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVANONEW14)
    public String getZrnmvanonew14() {
        return zrnmvanonew14;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnmvanonew14(String pZrnmvanonew14) {
        zrnmvanonew14 = pZrnmvanonew14;
    }

    private String zrnmvanonewyentuktype14;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVANONEWYENTUKTYPE14)
    public String getZrnmvanonewyentuktype14() {
        return zrnmvanonewyentuktype14;
    }

    public void setZrnmvanonewyentuktype14(String pZrnmvanonewyentuktype14) {
        zrnmvanonewyentuktype14 = pZrnmvanonewyentuktype14;
    }

    private String zrnmvanonewyendaka14;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVANONEWYENDAKA14)
    public String getZrnmvanonewyendaka14() {
        return zrnmvanonewyendaka14;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnmvanonewyendaka14(String pZrnmvanonewyendaka14) {
        zrnmvanonewyendaka14 = pZrnmvanonewyendaka14;
    }

    private String zrnmvanonewyenkijyun14;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVANONEWYENKIJYUN14)
    public String getZrnmvanonewyenkijyun14() {
        return zrnmvanonewyenkijyun14;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnmvanonewyenkijyun14(String pZrnmvanonewyenkijyun14) {
        zrnmvanonewyenkijyun14 = pZrnmvanonewyenkijyun14;
    }

    private String zrnmvanonewyenyasu14;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVANONEWYENYASU14)
    public String getZrnmvanonewyenyasu14() {
        return zrnmvanonewyenyasu14;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnmvanonewyenyasu14(String pZrnmvanonewyenyasu14) {
        zrnmvanonewyenyasu14 = pZrnmvanonewyenyasu14;
    }

    private String zrnmvanoneumyendaka14;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVANONEUMYENDAKA14)
    public String getZrnmvanoneumyendaka14() {
        return zrnmvanoneumyendaka14;
    }

    public void setZrnmvanoneumyendaka14(String pZrnmvanoneumyendaka14) {
        zrnmvanoneumyendaka14 = pZrnmvanoneumyendaka14;
    }

    private String zrnmvanoneumyenkijyun14;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVANONEUMYENKIJYUN14)
    public String getZrnmvanoneumyenkijyun14() {
        return zrnmvanoneumyenkijyun14;
    }

    public void setZrnmvanoneumyenkijyun14(String pZrnmvanoneumyenkijyun14) {
        zrnmvanoneumyenkijyun14 = pZrnmvanoneumyenkijyun14;
    }

    private String zrnmvanoneumyenyasu14;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVANONEUMYENYASU14)
    public String getZrnmvanoneumyenyasu14() {
        return zrnmvanoneumyenyasu14;
    }

    public void setZrnmvanoneumyenyasu14(String pZrnmvanoneumyenyasu14) {
        zrnmvanoneumyenyasu14 = pZrnmvanoneumyenyasu14;
    }

    private String zrnmvanonevtuktype14;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVANONEVTUKTYPE14)
    public String getZrnmvanonevtuktype14() {
        return zrnmvanonevtuktype14;
    }

    public void setZrnmvanonevtuktype14(String pZrnmvanonevtuktype14) {
        zrnmvanonevtuktype14 = pZrnmvanonevtuktype14;
    }

    private String zrnmvanonev14;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNMVANONEV14)
    public String getZrnmvanonev14() {
        return zrnmvanonev14;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnmvanonev14(String pZrnmvanonev14) {
        zrnmvanonev14 = pZrnmvanonev14;
    }

    private String zrnwmsgcd1;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNWMSGCD1)
    public String getZrnwmsgcd1() {
        return zrnwmsgcd1;
    }

    public void setZrnwmsgcd1(String pZrnwmsgcd1) {
        zrnwmsgcd1 = pZrnwmsgcd1;
    }

    private String zrnwmsgcd2;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNWMSGCD2)
    public String getZrnwmsgcd2() {
        return zrnwmsgcd2;
    }

    public void setZrnwmsgcd2(String pZrnwmsgcd2) {
        zrnwmsgcd2 = pZrnwmsgcd2;
    }

    private String zrnwmsgcd3;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNWMSGCD3)
    public String getZrnwmsgcd3() {
        return zrnwmsgcd3;
    }

    public void setZrnwmsgcd3(String pZrnwmsgcd3) {
        zrnwmsgcd3 = pZrnwmsgcd3;
    }

    private String zrnwmsgcd21;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNWMSGCD21)
    public String getZrnwmsgcd21() {
        return zrnwmsgcd21;
    }

    public void setZrnwmsgcd21(String pZrnwmsgcd21) {
        zrnwmsgcd21 = pZrnwmsgcd21;
    }

    private String zrnwmsgcd22;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNWMSGCD22)
    public String getZrnwmsgcd22() {
        return zrnwmsgcd22;
    }

    public void setZrnwmsgcd22(String pZrnwmsgcd22) {
        zrnwmsgcd22 = pZrnwmsgcd22;
    }

    private String zrnwmsgcd23;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNWMSGCD23)
    public String getZrnwmsgcd23() {
        return zrnwmsgcd23;
    }

    public void setZrnwmsgcd23(String pZrnwmsgcd23) {
        zrnwmsgcd23 = pZrnwmsgcd23;
    }

    private String zrnwmsgcd31;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNWMSGCD31)
    public String getZrnwmsgcd31() {
        return zrnwmsgcd31;
    }

    public void setZrnwmsgcd31(String pZrnwmsgcd31) {
        zrnwmsgcd31 = pZrnwmsgcd31;
    }

    private String zrnwmsgcd32;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNWMSGCD32)
    public String getZrnwmsgcd32() {
        return zrnwmsgcd32;
    }

    public void setZrnwmsgcd32(String pZrnwmsgcd32) {
        zrnwmsgcd32 = pZrnwmsgcd32;
    }

    private String zrnwmsgcd33;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNWMSGCD33)
    public String getZrnwmsgcd33() {
        return zrnwmsgcd33;
    }

    public void setZrnwmsgcd33(String pZrnwmsgcd33) {
        zrnwmsgcd33 = pZrnwmsgcd33;
    }

    private String zrnwmsgcdst1;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNWMSGCDST1)
    public String getZrnwmsgcdst1() {
        return zrnwmsgcdst1;
    }

    public void setZrnwmsgcdst1(String pZrnwmsgcdst1) {
        zrnwmsgcdst1 = pZrnwmsgcdst1;
    }

    private String zrnwtyuuimsgcd1;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNWTYUUIMSGCD1)
    public String getZrnwtyuuimsgcd1() {
        return zrnwtyuuimsgcd1;
    }

    public void setZrnwtyuuimsgcd1(String pZrnwtyuuimsgcd1) {
        zrnwtyuuimsgcd1 = pZrnwtyuuimsgcd1;
    }

    private String zrnwtyuuimsgcd2;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNWTYUUIMSGCD2)
    public String getZrnwtyuuimsgcd2() {
        return zrnwtyuuimsgcd2;
    }

    public void setZrnwtyuuimsgcd2(String pZrnwtyuuimsgcd2) {
        zrnwtyuuimsgcd2 = pZrnwtyuuimsgcd2;
    }

    private String zrnwtyuuimsgcd3;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNWTYUUIMSGCD3)
    public String getZrnwtyuuimsgcd3() {
        return zrnwtyuuimsgcd3;
    }

    public void setZrnwtyuuimsgcd3(String pZrnwtyuuimsgcd3) {
        zrnwtyuuimsgcd3 = pZrnwtyuuimsgcd3;
    }

    private String zrnwtyuuimsgcd4;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNWTYUUIMSGCD4)
    public String getZrnwtyuuimsgcd4() {
        return zrnwtyuuimsgcd4;
    }

    public void setZrnwtyuuimsgcd4(String pZrnwtyuuimsgcd4) {
        zrnwtyuuimsgcd4 = pZrnwtyuuimsgcd4;
    }

    private String zrnwtyuuimsgcd5;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNWTYUUIMSGCD5)
    public String getZrnwtyuuimsgcd5() {
        return zrnwtyuuimsgcd5;
    }

    public void setZrnwtyuuimsgcd5(String pZrnwtyuuimsgcd5) {
        zrnwtyuuimsgcd5 = pZrnwtyuuimsgcd5;
    }

    private String zrnwtyuuimsgcd6;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNWTYUUIMSGCD6)
    public String getZrnwtyuuimsgcd6() {
        return zrnwtyuuimsgcd6;
    }

    public void setZrnwtyuuimsgcd6(String pZrnwtyuuimsgcd6) {
        zrnwtyuuimsgcd6 = pZrnwtyuuimsgcd6;
    }

    private String zrnwtyuuimsgcd7;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNWTYUUIMSGCD7)
    public String getZrnwtyuuimsgcd7() {
        return zrnwtyuuimsgcd7;
    }

    public void setZrnwtyuuimsgcd7(String pZrnwtyuuimsgcd7) {
        zrnwtyuuimsgcd7 = pZrnwtyuuimsgcd7;
    }

    private String zrnwitjbrptuuktype;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNWITJBRPTUUKTYPE)
    public String getZrnwitjbrptuuktype() {
        return zrnwitjbrptuuktype;
    }

    public void setZrnwitjbrptuuktype(String pZrnwitjbrptuuktype) {
        zrnwitjbrptuuktype = pZrnwitjbrptuuktype;
    }

    private String zrnwitjbrp;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNWITJBRP)
    public String getZrnwitjbrp() {
        return zrnwitjbrp;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnwitjbrp(String pZrnwitjbrp) {
        zrnwitjbrp = pZrnwitjbrp;
    }

    private String zrnwyenhrikmgktuuktype;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNWYENHRIKMGKTUUKTYPE)
    public String getZrnwyenhrikmgktuuktype() {
        return zrnwyenhrikmgktuuktype;
    }

    public void setZrnwyenhrikmgktuuktype(String pZrnwyenhrikmgktuuktype) {
        zrnwyenhrikmgktuuktype = pZrnwyenhrikmgktuuktype;
    }

    private String zrnwyenhrikmgk;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNWYENHRIKMGK)
    public String getZrnwyenhrikmgk() {
        return zrnwyenhrikmgk;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnwyenhrikmgk(String pZrnwyenhrikmgk) {
        zrnwyenhrikmgk = pZrnwyenhrikmgk;
    }

    private String zrnwyenitjbrptuuktype;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNWYENITJBRPTUUKTYPE)
    public String getZrnwyenitjbrptuuktype() {
        return zrnwyenitjbrptuuktype;
    }

    public void setZrnwyenitjbrptuuktype(String pZrnwyenitjbrptuuktype) {
        zrnwyenitjbrptuuktype = pZrnwyenitjbrptuuktype;
    }

    private String zrnwyenitjbrp;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNWYENITJBRP)
    public String getZrnwyenitjbrp() {
        return zrnwyenitjbrp;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnwyenitjbrp(String pZrnwyenitjbrp) {
        zrnwyenitjbrp = pZrnwyenitjbrp;
    }

    private String zrnwsjkkktyouseitkyuym;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNWSJKKKTYOUSEITKYUYM)
    public String getZrnwsjkkktyouseitkyuym() {
        return zrnwsjkkktyouseitkyuym;
    }

    @DataConvert("toMultiByte")
    public void setZrnwsjkkktyouseitkyuym(String pZrnwsjkkktyouseitkyuym) {
        zrnwsjkkktyouseitkyuym = pZrnwsjkkktyouseitkyuym;
    }

    private String zrnhrkkknmnryym;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNHRKKKNMNRYYM)
    public String getZrnhrkkknmnryym() {
        return zrnhrkkknmnryym;
    }

    @DataConvert("toMultiByte")
    public void setZrnhrkkknmnryym(String pZrnhrkkknmnryym) {
        zrnhrkkknmnryym = pZrnhrkkknmnryym;
    }

    private String zrnhrkkknmnrynen;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNHRKKKNMNRYNEN)
    public String getZrnhrkkknmnrynen() {
        return zrnhrkkknmnrynen;
    }

    public void setZrnhrkkknmnrynen(String pZrnhrkkknmnrynen) {
        zrnhrkkknmnrynen = pZrnhrkkknmnrynen;
    }

    private String zrnyobiv200;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNYOBIV200)
    public String getZrnyobiv200() {
        return zrnyobiv200;
    }

    public void setZrnyobiv200(String pZrnyobiv200) {
        zrnyobiv200 = pZrnyobiv200;
    }

    private String zrnyobiv49;

    @Column(name=GenZT_SaihakkouSyoukenSuiiRn.ZRNYOBIV49)
    public String getZrnyobiv49() {
        return zrnyobiv49;
    }

    public void setZrnyobiv49(String pZrnyobiv49) {
        zrnyobiv49 = pZrnyobiv49;
    }
}