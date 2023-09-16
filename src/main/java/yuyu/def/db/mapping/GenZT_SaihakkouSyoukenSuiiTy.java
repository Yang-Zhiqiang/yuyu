package yuyu.def.db.mapping;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import yuyu.def.db.entity.ZT_SaihakkouSyoukenSuiiTy;
import yuyu.def.db.id.PKZT_SaihakkouSyoukenSuiiTy;
import yuyu.def.db.meta.GenQZT_SaihakkouSyoukenSuiiTy;
import yuyu.def.db.meta.QZT_SaihakkouSyoukenSuiiTy;

/**
 * 再発行保険証券推移表Ｆテーブル（中） テーブルのマッピング情報クラスで、 {@link ZT_SaihakkouSyoukenSuiiTy} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_SaihakkouSyoukenSuiiTy}</td><td colspan="3">再発行保険証券推移表Ｆテーブル（中）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getZtysyono ztysyono}</td><td>（中継用）証券番号</td><td align="center">{@link PKZT_SaihakkouSyoukenSuiiTy ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytyouhyouymd ztytyouhyouymd}</td><td>（中継用）帳票作成日</td><td align="center">{@link PKZT_SaihakkouSyoukenSuiiTy ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysuiihyouptn ztysuiihyouptn}</td><td>（中継用）推移表パターン</td><td align="center">{@link PKZT_SaihakkouSyoukenSuiiTy ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysuiihyousykbn ztysuiihyousykbn}</td><td>（中継用）推移表種別区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysuiihyousyono ztysuiihyousyono}</td><td>（中継用）推移表証券番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysisuuupritu ztysisuuupritu}</td><td>（中継用）指数上昇率</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysaisyuunndym ztysaisyuunndym}</td><td>（中継用）最終年度（年月）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysjkkktusirrtup ztysjkkktusirrtup}</td><td>（中継用）市場価格調整用利率（上昇）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysjkkktusirrtsame ztysjkkktusirrtsame}</td><td>（中継用）市場価格調整用利率（同水準）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysjkkktusirrtdown ztysjkkktusirrtdown}</td><td>（中継用）市場価格調整用利率（低下）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysjkkktusirrthendouup ztysjkkktusirrthendouup}</td><td>（中継用）市場価格調整用利率変動幅（上）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysjkkktusirrthendoudown ztysjkkktusirrthendoudown}</td><td>（中継用）市場価格調整用利率変動幅（下）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtywkwsrateyendaka ztywkwsrateyendaka}</td><td>（中継用）解約返戻金為替レート（円高）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtywkwsrateyenkijyun ztywkwsrateyenkijyun}</td><td>（中継用）解約返戻金為替レート（中央値）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtywkwsrateyenyasu ztywkwsrateyenyasu}</td><td>（中継用）解約返戻金為替レート（円安）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysuiihyoumkhyouyenwra ztysuiihyoumkhyouyenwra}</td><td>（中継用）推移表目標到達時円建終身保険移行特約目標割合</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaarinenoutouym01 ztymvaarinenoutouym01}</td><td>（中継用）ＭＶＡ適用年単位応当年月０１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaarisisuuupritu01 ztymvaarisisuuupritu01}</td><td>（中継用）ＭＶＡ適用指数上昇率０１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaaritmttknzkritu01 ztymvaaritmttknzkritu01}</td><td>（中継用）ＭＶＡ適用積立金増加率０１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaariwtuktypeup01 ztymvaariwtuktypeup01}</td><td>（中継用）ＭＶＡ適用Ｗ通貨タイプ（上昇）０１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaaritmttknkykkjmup01 ztymvaaritmttknkykkjmup01}</td><td>（中継用）ＭＶＡ適用積立金（解約控除前）（上昇）０１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaariwup01 ztymvaariwup01}</td><td>（中継用）ＭＶＡ適用Ｗ（上昇）０１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaariwyentuktypeup01 ztymvaariwyentuktypeup01}</td><td>（中継用）ＭＶＡ適用Ｗ換算通貨タイプ（上昇）０１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaariwupyendaka01 ztymvaariwupyendaka01}</td><td>（中継用）ＭＶＡ適用Ｗ換算（上昇）円高０１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaariwupyenkijyun01 ztymvaariwupyenkijyun01}</td><td>（中継用）ＭＶＡ適用Ｗ換算（上昇）中央値０１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaariwupyenyasu01 ztymvaariwupyenyasu01}</td><td>（中継用）ＭＶＡ適用Ｗ換算（上昇）円安０１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaariwumupyendaka01 ztymvaariwumupyendaka01}</td><td>（中継用）ＭＶＡ適用Ｗ換算目標額到達有無（上昇）円高０１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaariumupyenkijyun01 ztymvaariumupyenkijyun01}</td><td>（中継用）ＭＶＡ適用Ｗ換算目標額到達有無（上昇）中央値０１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaariumupyenyasu01 ztymvaariumupyenyasu01}</td><td>（中継用）ＭＶＡ適用Ｗ換算目標額到達有無（上昇）円安０１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaariwtuktypesame01 ztymvaariwtuktypesame01}</td><td>（中継用）ＭＶＡ適用Ｗ通貨タイプ（同水準）０１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaaritmttknkykkjmsame01 ztymvaaritmttknkykkjmsame01}</td><td>（中継用）ＭＶＡ適用積立金（解約控除前）（同水準）０１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaariwsame01 ztymvaariwsame01}</td><td>（中継用）ＭＶＡ適用Ｗ（同水準）０１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaariwyentuktypesame01 ztymvaariwyentuktypesame01}</td><td>（中継用）ＭＶＡ適用Ｗ換算通貨タイプ（同水準）０１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaariwsameyendaka01 ztymvaariwsameyendaka01}</td><td>（中継用）ＭＶＡ適用Ｗ換算（同水準）円高０１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaariwsameyenkijyun01 ztymvaariwsameyenkijyun01}</td><td>（中継用）ＭＶＡ適用Ｗ換算（同水準）中央値０１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaariwsameyenyasu01 ztymvaariwsameyenyasu01}</td><td>（中継用）ＭＶＡ適用Ｗ換算（同水準）円安０１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaariumsameyendaka01 ztymvaariumsameyendaka01}</td><td>（中継用）ＭＶＡ適用Ｗ換算目標額到達有無（同水準）円高０１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaariumsameyenkijyun01 ztymvaariumsameyenkijyun01}</td><td>（中継用）ＭＶＡ適用Ｗ換算目標額到達有無（同水準）中央値０１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaariumsameyenyasu01 ztymvaariumsameyenyasu01}</td><td>（中継用）ＭＶＡ適用Ｗ換算目標額到達有無（同水準）円安０１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaariwtuktypedown01 ztymvaariwtuktypedown01}</td><td>（中継用）ＭＶＡ適用Ｗ通貨タイプ（低下）０１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaaritmttknkykkjmdown01 ztymvaaritmttknkykkjmdown01}</td><td>（中継用）ＭＶＡ適用積立金（解約控除前）（低下）０１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaariwdown01 ztymvaariwdown01}</td><td>（中継用）ＭＶＡ適用Ｗ（低下）０１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaariwyentuktypedown01 ztymvaariwyentuktypedown01}</td><td>（中継用）ＭＶＡ適用Ｗ換算通貨タイプ（低下）０１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaariwdownyendaka01 ztymvaariwdownyendaka01}</td><td>（中継用）ＭＶＡ適用Ｗ換算（低下）円高０１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaariwdownyenkijyun01 ztymvaariwdownyenkijyun01}</td><td>（中継用）ＭＶＡ適用Ｗ換算（低下）中央値０１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaariwdownyenyasu01 ztymvaariwdownyenyasu01}</td><td>（中継用）ＭＶＡ適用Ｗ換算（低下）円安０１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaariumdownyendaka01 ztymvaariumdownyendaka01}</td><td>（中継用）ＭＶＡ適用Ｗ換算目標額到達有無（低下）円高０１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaariumdownyenkijyun01 ztymvaariumdownyenkijyun01}</td><td>（中継用）ＭＶＡ適用Ｗ換算目標額到達有無（低下）中央値０１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaariumdownyenyasu01 ztymvaariumdownyenyasu01}</td><td>（中継用）ＭＶＡ適用Ｗ換算目標額到達有無（低下）円安０１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaarivtuktype01 ztymvaarivtuktype01}</td><td>（中継用）ＭＶＡ適用保険料積立金額通貨タイプ０１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaariv01 ztymvaariv01}</td><td>（中継用）ＭＶＡ適用保険料積立金額０１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyptmttkngkutiwake101 ztyptmttkngkutiwake101}</td><td>（中継用）保険料積立金額内訳（１）０１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyptmttkngkutiwake201 ztyptmttkngkutiwake201}</td><td>（中継用）保険料積立金額内訳（２）０１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaarinenoutouym02 ztymvaarinenoutouym02}</td><td>（中継用）ＭＶＡ適用年単位応当年月０２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaarisisuuupritu02 ztymvaarisisuuupritu02}</td><td>（中継用）ＭＶＡ適用指数上昇率０２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaaritmttknzkritu02 ztymvaaritmttknzkritu02}</td><td>（中継用）ＭＶＡ適用積立金増加率０２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaariwtuktypeup02 ztymvaariwtuktypeup02}</td><td>（中継用）ＭＶＡ適用Ｗ通貨タイプ（上昇）０２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaaritmttknkykkjmup02 ztymvaaritmttknkykkjmup02}</td><td>（中継用）ＭＶＡ適用積立金（解約控除前）（上昇）０２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaariwup02 ztymvaariwup02}</td><td>（中継用）ＭＶＡ適用Ｗ（上昇）０２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaariwyentuktypeup02 ztymvaariwyentuktypeup02}</td><td>（中継用）ＭＶＡ適用Ｗ換算通貨タイプ（上昇）０２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaariwupyendaka02 ztymvaariwupyendaka02}</td><td>（中継用）ＭＶＡ適用Ｗ換算（上昇）円高０２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaariwupyenkijyun02 ztymvaariwupyenkijyun02}</td><td>（中継用）ＭＶＡ適用Ｗ換算（上昇）中央値０２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaariwupyenyasu02 ztymvaariwupyenyasu02}</td><td>（中継用）ＭＶＡ適用Ｗ換算（上昇）円安０２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaariwumupyendaka02 ztymvaariwumupyendaka02}</td><td>（中継用）ＭＶＡ適用Ｗ換算目標額到達有無（上昇）円高０２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaariumupyenkijyun02 ztymvaariumupyenkijyun02}</td><td>（中継用）ＭＶＡ適用Ｗ換算目標額到達有無（上昇）中央値０２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaariumupyenyasu02 ztymvaariumupyenyasu02}</td><td>（中継用）ＭＶＡ適用Ｗ換算目標額到達有無（上昇）円安０２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaariwtuktypesame02 ztymvaariwtuktypesame02}</td><td>（中継用）ＭＶＡ適用Ｗ通貨タイプ（同水準）０２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaaritmttknkykkjmsame02 ztymvaaritmttknkykkjmsame02}</td><td>（中継用）ＭＶＡ適用積立金（解約控除前）（同水準）０２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaariwsame02 ztymvaariwsame02}</td><td>（中継用）ＭＶＡ適用Ｗ（同水準）０２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaariwyentuktypesame02 ztymvaariwyentuktypesame02}</td><td>（中継用）ＭＶＡ適用Ｗ換算通貨タイプ（同水準）０２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaariwsameyendaka02 ztymvaariwsameyendaka02}</td><td>（中継用）ＭＶＡ適用Ｗ換算（同水準）円高０２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaariwsameyenkijyun02 ztymvaariwsameyenkijyun02}</td><td>（中継用）ＭＶＡ適用Ｗ換算（同水準）中央値０２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaariwsameyenyasu02 ztymvaariwsameyenyasu02}</td><td>（中継用）ＭＶＡ適用Ｗ換算（同水準）円安０２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaariumsameyendaka02 ztymvaariumsameyendaka02}</td><td>（中継用）ＭＶＡ適用Ｗ換算目標額到達有無（同水準）円高０２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaariumsameyenkijyun02 ztymvaariumsameyenkijyun02}</td><td>（中継用）ＭＶＡ適用Ｗ換算目標額到達有無（同水準）中央値０２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaariumsameyenyasu02 ztymvaariumsameyenyasu02}</td><td>（中継用）ＭＶＡ適用Ｗ換算目標額到達有無（同水準）円安０２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaariwtuktypedown02 ztymvaariwtuktypedown02}</td><td>（中継用）ＭＶＡ適用Ｗ通貨タイプ（低下）０２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaaritmttknkykkjmdown02 ztymvaaritmttknkykkjmdown02}</td><td>（中継用）ＭＶＡ適用積立金（解約控除前）（低下）０２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaariwdown02 ztymvaariwdown02}</td><td>（中継用）ＭＶＡ適用Ｗ（低下）０２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaariwyentuktypedown02 ztymvaariwyentuktypedown02}</td><td>（中継用）ＭＶＡ適用Ｗ換算通貨タイプ（低下）０２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaariwdownyendaka02 ztymvaariwdownyendaka02}</td><td>（中継用）ＭＶＡ適用Ｗ換算（低下）円高０２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaariwdownyenkijyun02 ztymvaariwdownyenkijyun02}</td><td>（中継用）ＭＶＡ適用Ｗ換算（低下）中央値０２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaariwdownyenyasu02 ztymvaariwdownyenyasu02}</td><td>（中継用）ＭＶＡ適用Ｗ換算（低下）円安０２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaariumdownyendaka02 ztymvaariumdownyendaka02}</td><td>（中継用）ＭＶＡ適用Ｗ換算目標額到達有無（低下）円高０２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaariumdownyenkijyun02 ztymvaariumdownyenkijyun02}</td><td>（中継用）ＭＶＡ適用Ｗ換算目標額到達有無（低下）中央値０２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaariumdownyenyasu02 ztymvaariumdownyenyasu02}</td><td>（中継用）ＭＶＡ適用Ｗ換算目標額到達有無（低下）円安０２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaarivtuktype02 ztymvaarivtuktype02}</td><td>（中継用）ＭＶＡ適用保険料積立金額通貨タイプ０２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaariv02 ztymvaariv02}</td><td>（中継用）ＭＶＡ適用保険料積立金額０２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyptmttkngkutiwake102 ztyptmttkngkutiwake102}</td><td>（中継用）保険料積立金額内訳（１）０２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyptmttkngkutiwake202 ztyptmttkngkutiwake202}</td><td>（中継用）保険料積立金額内訳（２）０２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaarinenoutouym03 ztymvaarinenoutouym03}</td><td>（中継用）ＭＶＡ適用年単位応当年月０３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaarisisuuupritu03 ztymvaarisisuuupritu03}</td><td>（中継用）ＭＶＡ適用指数上昇率０３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaaritmttknzkritu03 ztymvaaritmttknzkritu03}</td><td>（中継用）ＭＶＡ適用積立金増加率０３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaariwtuktypeup03 ztymvaariwtuktypeup03}</td><td>（中継用）ＭＶＡ適用Ｗ通貨タイプ（上昇）０３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaaritmttknkykkjmup03 ztymvaaritmttknkykkjmup03}</td><td>（中継用）ＭＶＡ適用積立金（解約控除前）（上昇）０３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaariwup03 ztymvaariwup03}</td><td>（中継用）ＭＶＡ適用Ｗ（上昇）０３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaariwyentuktypeup03 ztymvaariwyentuktypeup03}</td><td>（中継用）ＭＶＡ適用Ｗ換算通貨タイプ（上昇）０３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaariwupyendaka03 ztymvaariwupyendaka03}</td><td>（中継用）ＭＶＡ適用Ｗ換算（上昇）円高０３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaariwupyenkijyun03 ztymvaariwupyenkijyun03}</td><td>（中継用）ＭＶＡ適用Ｗ換算（上昇）中央値０３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaariwupyenyasu03 ztymvaariwupyenyasu03}</td><td>（中継用）ＭＶＡ適用Ｗ換算（上昇）円安０３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaariwumupyendaka03 ztymvaariwumupyendaka03}</td><td>（中継用）ＭＶＡ適用Ｗ換算目標額到達有無（上昇）円高０３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaariumupyenkijyun03 ztymvaariumupyenkijyun03}</td><td>（中継用）ＭＶＡ適用Ｗ換算目標額到達有無（上昇）中央値０３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaariumupyenyasu03 ztymvaariumupyenyasu03}</td><td>（中継用）ＭＶＡ適用Ｗ換算目標額到達有無（上昇）円安０３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaariwtuktypesame03 ztymvaariwtuktypesame03}</td><td>（中継用）ＭＶＡ適用Ｗ通貨タイプ（同水準）０３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaaritmttknkykkjmsame03 ztymvaaritmttknkykkjmsame03}</td><td>（中継用）ＭＶＡ適用積立金（解約控除前）（同水準）０３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaariwsame03 ztymvaariwsame03}</td><td>（中継用）ＭＶＡ適用Ｗ（同水準）０３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaariwyentuktypesame03 ztymvaariwyentuktypesame03}</td><td>（中継用）ＭＶＡ適用Ｗ換算通貨タイプ（同水準）０３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaariwsameyendaka03 ztymvaariwsameyendaka03}</td><td>（中継用）ＭＶＡ適用Ｗ換算（同水準）円高０３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaariwsameyenkijyun03 ztymvaariwsameyenkijyun03}</td><td>（中継用）ＭＶＡ適用Ｗ換算（同水準）中央値０３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaariwsameyenyasu03 ztymvaariwsameyenyasu03}</td><td>（中継用）ＭＶＡ適用Ｗ換算（同水準）円安０３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaariumsameyendaka03 ztymvaariumsameyendaka03}</td><td>（中継用）ＭＶＡ適用Ｗ換算目標額到達有無（同水準）円高０３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaariumsameyenkijyun03 ztymvaariumsameyenkijyun03}</td><td>（中継用）ＭＶＡ適用Ｗ換算目標額到達有無（同水準）中央値０３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaariumsameyenyasu03 ztymvaariumsameyenyasu03}</td><td>（中継用）ＭＶＡ適用Ｗ換算目標額到達有無（同水準）円安０３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaariwtuktypedown03 ztymvaariwtuktypedown03}</td><td>（中継用）ＭＶＡ適用Ｗ通貨タイプ（低下）０３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaaritmttknkykkjmdown03 ztymvaaritmttknkykkjmdown03}</td><td>（中継用）ＭＶＡ適用積立金（解約控除前）（低下）０３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaariwdown03 ztymvaariwdown03}</td><td>（中継用）ＭＶＡ適用Ｗ（低下）０３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaariwyentuktypedown03 ztymvaariwyentuktypedown03}</td><td>（中継用）ＭＶＡ適用Ｗ換算通貨タイプ（低下）０３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaariwdownyendaka03 ztymvaariwdownyendaka03}</td><td>（中継用）ＭＶＡ適用Ｗ換算（低下）円高０３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaariwdownyenkijyun03 ztymvaariwdownyenkijyun03}</td><td>（中継用）ＭＶＡ適用Ｗ換算（低下）中央値０３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaariwdownyenyasu03 ztymvaariwdownyenyasu03}</td><td>（中継用）ＭＶＡ適用Ｗ換算（低下）円安０３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaariumdownyendaka03 ztymvaariumdownyendaka03}</td><td>（中継用）ＭＶＡ適用Ｗ換算目標額到達有無（低下）円高０３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaariumdownyenkijyun03 ztymvaariumdownyenkijyun03}</td><td>（中継用）ＭＶＡ適用Ｗ換算目標額到達有無（低下）中央値０３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaariumdownyenyasu03 ztymvaariumdownyenyasu03}</td><td>（中継用）ＭＶＡ適用Ｗ換算目標額到達有無（低下）円安０３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaarivtuktype03 ztymvaarivtuktype03}</td><td>（中継用）ＭＶＡ適用保険料積立金額通貨タイプ０３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaariv03 ztymvaariv03}</td><td>（中継用）ＭＶＡ適用保険料積立金額０３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyptmttkngkutiwake103 ztyptmttkngkutiwake103}</td><td>（中継用）保険料積立金額内訳（１）０３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyptmttkngkutiwake203 ztyptmttkngkutiwake203}</td><td>（中継用）保険料積立金額内訳（２）０３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaarinenoutouym04 ztymvaarinenoutouym04}</td><td>（中継用）ＭＶＡ適用年単位応当年月０４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaarisisuuupritu04 ztymvaarisisuuupritu04}</td><td>（中継用）ＭＶＡ適用指数上昇率０４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaaritmttknzkritu04 ztymvaaritmttknzkritu04}</td><td>（中継用）ＭＶＡ適用積立金増加率０４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaariwtuktypeup04 ztymvaariwtuktypeup04}</td><td>（中継用）ＭＶＡ適用Ｗ通貨タイプ（上昇）０４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaaritmttknkykkjmup04 ztymvaaritmttknkykkjmup04}</td><td>（中継用）ＭＶＡ適用積立金（解約控除前）（上昇）０４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaariwup04 ztymvaariwup04}</td><td>（中継用）ＭＶＡ適用Ｗ（上昇）０４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaariwyentuktypeup04 ztymvaariwyentuktypeup04}</td><td>（中継用）ＭＶＡ適用Ｗ換算通貨タイプ（上昇）０４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaariwupyendaka04 ztymvaariwupyendaka04}</td><td>（中継用）ＭＶＡ適用Ｗ換算（上昇）円高０４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaariwupyenkijyun04 ztymvaariwupyenkijyun04}</td><td>（中継用）ＭＶＡ適用Ｗ換算（上昇）中央値０４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaariwupyenyasu04 ztymvaariwupyenyasu04}</td><td>（中継用）ＭＶＡ適用Ｗ換算（上昇）円安０４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaariwumupyendaka04 ztymvaariwumupyendaka04}</td><td>（中継用）ＭＶＡ適用Ｗ換算目標額到達有無（上昇）円高０４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaariumupyenkijyun04 ztymvaariumupyenkijyun04}</td><td>（中継用）ＭＶＡ適用Ｗ換算目標額到達有無（上昇）中央値０４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaariumupyenyasu04 ztymvaariumupyenyasu04}</td><td>（中継用）ＭＶＡ適用Ｗ換算目標額到達有無（上昇）円安０４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaariwtuktypesame04 ztymvaariwtuktypesame04}</td><td>（中継用）ＭＶＡ適用Ｗ通貨タイプ（同水準）０４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaaritmttknkykkjmsame04 ztymvaaritmttknkykkjmsame04}</td><td>（中継用）ＭＶＡ適用積立金（解約控除前）（同水準）０４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaariwsame04 ztymvaariwsame04}</td><td>（中継用）ＭＶＡ適用Ｗ（同水準）０４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaariwyentuktypesame04 ztymvaariwyentuktypesame04}</td><td>（中継用）ＭＶＡ適用Ｗ換算通貨タイプ（同水準）０４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaariwsameyendaka04 ztymvaariwsameyendaka04}</td><td>（中継用）ＭＶＡ適用Ｗ換算（同水準）円高０４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaariwsameyenkijyun04 ztymvaariwsameyenkijyun04}</td><td>（中継用）ＭＶＡ適用Ｗ換算（同水準）中央値０４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaariwsameyenyasu04 ztymvaariwsameyenyasu04}</td><td>（中継用）ＭＶＡ適用Ｗ換算（同水準）円安０４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaariumsameyendaka04 ztymvaariumsameyendaka04}</td><td>（中継用）ＭＶＡ適用Ｗ換算目標額到達有無（同水準）円高０４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaariumsameyenkijyun04 ztymvaariumsameyenkijyun04}</td><td>（中継用）ＭＶＡ適用Ｗ換算目標額到達有無（同水準）中央値０４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaariumsameyenyasu04 ztymvaariumsameyenyasu04}</td><td>（中継用）ＭＶＡ適用Ｗ換算目標額到達有無（同水準）円安０４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaariwtuktypedown04 ztymvaariwtuktypedown04}</td><td>（中継用）ＭＶＡ適用Ｗ通貨タイプ（低下）０４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaaritmttknkykkjmdown04 ztymvaaritmttknkykkjmdown04}</td><td>（中継用）ＭＶＡ適用積立金（解約控除前）（低下）０４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaariwdown04 ztymvaariwdown04}</td><td>（中継用）ＭＶＡ適用Ｗ（低下）０４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaariwyentuktypedown04 ztymvaariwyentuktypedown04}</td><td>（中継用）ＭＶＡ適用Ｗ換算通貨タイプ（低下）０４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaariwdownyendaka04 ztymvaariwdownyendaka04}</td><td>（中継用）ＭＶＡ適用Ｗ換算（低下）円高０４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaariwdownyenkijyun04 ztymvaariwdownyenkijyun04}</td><td>（中継用）ＭＶＡ適用Ｗ換算（低下）中央値０４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaariwdownyenyasu04 ztymvaariwdownyenyasu04}</td><td>（中継用）ＭＶＡ適用Ｗ換算（低下）円安０４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaariumdownyendaka04 ztymvaariumdownyendaka04}</td><td>（中継用）ＭＶＡ適用Ｗ換算目標額到達有無（低下）円高０４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaariumdownyenkijyun04 ztymvaariumdownyenkijyun04}</td><td>（中継用）ＭＶＡ適用Ｗ換算目標額到達有無（低下）中央値０４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaariumdownyenyasu04 ztymvaariumdownyenyasu04}</td><td>（中継用）ＭＶＡ適用Ｗ換算目標額到達有無（低下）円安０４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaarivtuktype04 ztymvaarivtuktype04}</td><td>（中継用）ＭＶＡ適用保険料積立金額通貨タイプ０４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaariv04 ztymvaariv04}</td><td>（中継用）ＭＶＡ適用保険料積立金額０４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyptmttkngkutiwake104 ztyptmttkngkutiwake104}</td><td>（中継用）保険料積立金額内訳（１）０４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyptmttkngkutiwake204 ztyptmttkngkutiwake204}</td><td>（中継用）保険料積立金額内訳（２）０４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaarinenoutouym05 ztymvaarinenoutouym05}</td><td>（中継用）ＭＶＡ適用年単位応当年月０５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaarisisuuupritu05 ztymvaarisisuuupritu05}</td><td>（中継用）ＭＶＡ適用指数上昇率０５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaaritmttknzkritu05 ztymvaaritmttknzkritu05}</td><td>（中継用）ＭＶＡ適用積立金増加率０５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaariwtuktypeup05 ztymvaariwtuktypeup05}</td><td>（中継用）ＭＶＡ適用Ｗ通貨タイプ（上昇）０５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaaritmttknkykkjmup05 ztymvaaritmttknkykkjmup05}</td><td>（中継用）ＭＶＡ適用積立金（解約控除前）（上昇）０５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaariwup05 ztymvaariwup05}</td><td>（中継用）ＭＶＡ適用Ｗ（上昇）０５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaariwyentuktypeup05 ztymvaariwyentuktypeup05}</td><td>（中継用）ＭＶＡ適用Ｗ換算通貨タイプ（上昇）０５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaariwupyendaka05 ztymvaariwupyendaka05}</td><td>（中継用）ＭＶＡ適用Ｗ換算（上昇）円高０５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaariwupyenkijyun05 ztymvaariwupyenkijyun05}</td><td>（中継用）ＭＶＡ適用Ｗ換算（上昇）中央値０５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaariwupyenyasu05 ztymvaariwupyenyasu05}</td><td>（中継用）ＭＶＡ適用Ｗ換算（上昇）円安０５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaariwumupyendaka05 ztymvaariwumupyendaka05}</td><td>（中継用）ＭＶＡ適用Ｗ換算目標額到達有無（上昇）円高０５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaariumupyenkijyun05 ztymvaariumupyenkijyun05}</td><td>（中継用）ＭＶＡ適用Ｗ換算目標額到達有無（上昇）中央値０５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaariumupyenyasu05 ztymvaariumupyenyasu05}</td><td>（中継用）ＭＶＡ適用Ｗ換算目標額到達有無（上昇）円安０５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaariwtuktypesame05 ztymvaariwtuktypesame05}</td><td>（中継用）ＭＶＡ適用Ｗ通貨タイプ（同水準）０５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaaritmttknkykkjmsame05 ztymvaaritmttknkykkjmsame05}</td><td>（中継用）ＭＶＡ適用積立金（解約控除前）（同水準）０５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaariwsame05 ztymvaariwsame05}</td><td>（中継用）ＭＶＡ適用Ｗ（同水準）０５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaariwyentuktypesame05 ztymvaariwyentuktypesame05}</td><td>（中継用）ＭＶＡ適用Ｗ換算通貨タイプ（同水準）０５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaariwsameyendaka05 ztymvaariwsameyendaka05}</td><td>（中継用）ＭＶＡ適用Ｗ換算（同水準）円高０５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaariwsameyenkijyun05 ztymvaariwsameyenkijyun05}</td><td>（中継用）ＭＶＡ適用Ｗ換算（同水準）中央値０５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaariwsameyenyasu05 ztymvaariwsameyenyasu05}</td><td>（中継用）ＭＶＡ適用Ｗ換算（同水準）円安０５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaariumsameyendaka05 ztymvaariumsameyendaka05}</td><td>（中継用）ＭＶＡ適用Ｗ換算目標額到達有無（同水準）円高０５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaariumsameyenkijyun05 ztymvaariumsameyenkijyun05}</td><td>（中継用）ＭＶＡ適用Ｗ換算目標額到達有無（同水準）中央値０５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaariumsameyenyasu05 ztymvaariumsameyenyasu05}</td><td>（中継用）ＭＶＡ適用Ｗ換算目標額到達有無（同水準）円安０５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaariwtuktypedown05 ztymvaariwtuktypedown05}</td><td>（中継用）ＭＶＡ適用Ｗ通貨タイプ（低下）０５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaaritmttknkykkjmdown05 ztymvaaritmttknkykkjmdown05}</td><td>（中継用）ＭＶＡ適用積立金（解約控除前）（低下）０５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaariwdown05 ztymvaariwdown05}</td><td>（中継用）ＭＶＡ適用Ｗ（低下）０５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaariwyentuktypedown05 ztymvaariwyentuktypedown05}</td><td>（中継用）ＭＶＡ適用Ｗ換算通貨タイプ（低下）０５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaariwdownyendaka05 ztymvaariwdownyendaka05}</td><td>（中継用）ＭＶＡ適用Ｗ換算（低下）円高０５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaariwdownyenkijyun05 ztymvaariwdownyenkijyun05}</td><td>（中継用）ＭＶＡ適用Ｗ換算（低下）中央値０５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaariwdownyenyasu05 ztymvaariwdownyenyasu05}</td><td>（中継用）ＭＶＡ適用Ｗ換算（低下）円安０５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaariumdownyendaka05 ztymvaariumdownyendaka05}</td><td>（中継用）ＭＶＡ適用Ｗ換算目標額到達有無（低下）円高０５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaariumdownyenkijyun05 ztymvaariumdownyenkijyun05}</td><td>（中継用）ＭＶＡ適用Ｗ換算目標額到達有無（低下）中央値０５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaariumdownyenyasu05 ztymvaariumdownyenyasu05}</td><td>（中継用）ＭＶＡ適用Ｗ換算目標額到達有無（低下）円安０５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaarivtuktype05 ztymvaarivtuktype05}</td><td>（中継用）ＭＶＡ適用保険料積立金額通貨タイプ０５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaariv05 ztymvaariv05}</td><td>（中継用）ＭＶＡ適用保険料積立金額０５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyptmttkngkutiwake105 ztyptmttkngkutiwake105}</td><td>（中継用）保険料積立金額内訳（１）０５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyptmttkngkutiwake205 ztyptmttkngkutiwake205}</td><td>（中継用）保険料積立金額内訳（２）０５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaarinenoutouym06 ztymvaarinenoutouym06}</td><td>（中継用）ＭＶＡ適用年単位応当年月０６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaarisisuuupritu06 ztymvaarisisuuupritu06}</td><td>（中継用）ＭＶＡ適用指数上昇率０６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaaritmttknzkritu06 ztymvaaritmttknzkritu06}</td><td>（中継用）ＭＶＡ適用積立金増加率０６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaariwtuktypeup06 ztymvaariwtuktypeup06}</td><td>（中継用）ＭＶＡ適用Ｗ通貨タイプ（上昇）０６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaaritmttknkykkjmup06 ztymvaaritmttknkykkjmup06}</td><td>（中継用）ＭＶＡ適用積立金（解約控除前）（上昇）０６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaariwup06 ztymvaariwup06}</td><td>（中継用）ＭＶＡ適用Ｗ（上昇）０６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaariwyentuktypeup06 ztymvaariwyentuktypeup06}</td><td>（中継用）ＭＶＡ適用Ｗ換算通貨タイプ（上昇）０６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaariwupyendaka06 ztymvaariwupyendaka06}</td><td>（中継用）ＭＶＡ適用Ｗ換算（上昇）円高０６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaariwupyenkijyun06 ztymvaariwupyenkijyun06}</td><td>（中継用）ＭＶＡ適用Ｗ換算（上昇）中央値０６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaariwupyenyasu06 ztymvaariwupyenyasu06}</td><td>（中継用）ＭＶＡ適用Ｗ換算（上昇）円安０６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaariwumupyendaka06 ztymvaariwumupyendaka06}</td><td>（中継用）ＭＶＡ適用Ｗ換算目標額到達有無（上昇）円高０６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaariumupyenkijyun06 ztymvaariumupyenkijyun06}</td><td>（中継用）ＭＶＡ適用Ｗ換算目標額到達有無（上昇）中央値０６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaariumupyenyasu06 ztymvaariumupyenyasu06}</td><td>（中継用）ＭＶＡ適用Ｗ換算目標額到達有無（上昇）円安０６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaariwtuktypesame06 ztymvaariwtuktypesame06}</td><td>（中継用）ＭＶＡ適用Ｗ通貨タイプ（同水準）０６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaaritmttknkykkjmsame06 ztymvaaritmttknkykkjmsame06}</td><td>（中継用）ＭＶＡ適用積立金（解約控除前）（同水準）０６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaariwsame06 ztymvaariwsame06}</td><td>（中継用）ＭＶＡ適用Ｗ（同水準）０６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaariwyentuktypesame06 ztymvaariwyentuktypesame06}</td><td>（中継用）ＭＶＡ適用Ｗ換算通貨タイプ（同水準）０６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaariwsameyendaka06 ztymvaariwsameyendaka06}</td><td>（中継用）ＭＶＡ適用Ｗ換算（同水準）円高０６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaariwsameyenkijyun06 ztymvaariwsameyenkijyun06}</td><td>（中継用）ＭＶＡ適用Ｗ換算（同水準）中央値０６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaariwsameyenyasu06 ztymvaariwsameyenyasu06}</td><td>（中継用）ＭＶＡ適用Ｗ換算（同水準）円安０６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaariumsameyendaka06 ztymvaariumsameyendaka06}</td><td>（中継用）ＭＶＡ適用Ｗ換算目標額到達有無（同水準）円高０６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaariumsameyenkijyun06 ztymvaariumsameyenkijyun06}</td><td>（中継用）ＭＶＡ適用Ｗ換算目標額到達有無（同水準）中央値０６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaariumsameyenyasu06 ztymvaariumsameyenyasu06}</td><td>（中継用）ＭＶＡ適用Ｗ換算目標額到達有無（同水準）円安０６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaariwtuktypedown06 ztymvaariwtuktypedown06}</td><td>（中継用）ＭＶＡ適用Ｗ通貨タイプ（低下）０６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaaritmttknkykkjmdown06 ztymvaaritmttknkykkjmdown06}</td><td>（中継用）ＭＶＡ適用積立金（解約控除前）（低下）０６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaariwdown06 ztymvaariwdown06}</td><td>（中継用）ＭＶＡ適用Ｗ（低下）０６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaariwyentuktypedown06 ztymvaariwyentuktypedown06}</td><td>（中継用）ＭＶＡ適用Ｗ換算通貨タイプ（低下）０６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaariwdownyendaka06 ztymvaariwdownyendaka06}</td><td>（中継用）ＭＶＡ適用Ｗ換算（低下）円高０６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaariwdownyenkijyun06 ztymvaariwdownyenkijyun06}</td><td>（中継用）ＭＶＡ適用Ｗ換算（低下）中央値０６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaariwdownyenyasu06 ztymvaariwdownyenyasu06}</td><td>（中継用）ＭＶＡ適用Ｗ換算（低下）円安０６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaariumdownyendaka06 ztymvaariumdownyendaka06}</td><td>（中継用）ＭＶＡ適用Ｗ換算目標額到達有無（低下）円高０６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaariumdownyenkijyun06 ztymvaariumdownyenkijyun06}</td><td>（中継用）ＭＶＡ適用Ｗ換算目標額到達有無（低下）中央値０６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaariumdownyenyasu06 ztymvaariumdownyenyasu06}</td><td>（中継用）ＭＶＡ適用Ｗ換算目標額到達有無（低下）円安０６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaarivtuktype06 ztymvaarivtuktype06}</td><td>（中継用）ＭＶＡ適用保険料積立金額通貨タイプ０６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaariv06 ztymvaariv06}</td><td>（中継用）ＭＶＡ適用保険料積立金額０６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyptmttkngkutiwake106 ztyptmttkngkutiwake106}</td><td>（中継用）保険料積立金額内訳（１）０６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyptmttkngkutiwake206 ztyptmttkngkutiwake206}</td><td>（中継用）保険料積立金額内訳（２）０６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaarinenoutouym07 ztymvaarinenoutouym07}</td><td>（中継用）ＭＶＡ適用年単位応当年月０７</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaarisisuuupritu07 ztymvaarisisuuupritu07}</td><td>（中継用）ＭＶＡ適用指数上昇率０７</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaaritmttknzkritu07 ztymvaaritmttknzkritu07}</td><td>（中継用）ＭＶＡ適用積立金増加率０７</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaariwtuktypeup07 ztymvaariwtuktypeup07}</td><td>（中継用）ＭＶＡ適用Ｗ通貨タイプ（上昇）０７</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaaritmttknkykkjmup07 ztymvaaritmttknkykkjmup07}</td><td>（中継用）ＭＶＡ適用積立金（解約控除前）（上昇）０７</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaariwup07 ztymvaariwup07}</td><td>（中継用）ＭＶＡ適用Ｗ（上昇）０７</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaariwyentuktypeup07 ztymvaariwyentuktypeup07}</td><td>（中継用）ＭＶＡ適用Ｗ換算通貨タイプ（上昇）０７</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaariwupyendaka07 ztymvaariwupyendaka07}</td><td>（中継用）ＭＶＡ適用Ｗ換算（上昇）円高０７</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaariwupyenkijyun07 ztymvaariwupyenkijyun07}</td><td>（中継用）ＭＶＡ適用Ｗ換算（上昇）中央値０７</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaariwupyenyasu07 ztymvaariwupyenyasu07}</td><td>（中継用）ＭＶＡ適用Ｗ換算（上昇）円安０７</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaariwumupyendaka07 ztymvaariwumupyendaka07}</td><td>（中継用）ＭＶＡ適用Ｗ換算目標額到達有無（上昇）円高０７</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaariumupyenkijyun07 ztymvaariumupyenkijyun07}</td><td>（中継用）ＭＶＡ適用Ｗ換算目標額到達有無（上昇）中央値０７</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaariumupyenyasu07 ztymvaariumupyenyasu07}</td><td>（中継用）ＭＶＡ適用Ｗ換算目標額到達有無（上昇）円安０７</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaariwtuktypesame07 ztymvaariwtuktypesame07}</td><td>（中継用）ＭＶＡ適用Ｗ通貨タイプ（同水準）０７</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaaritmttknkykkjmsame07 ztymvaaritmttknkykkjmsame07}</td><td>（中継用）ＭＶＡ適用積立金（解約控除前）（同水準）０７</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaariwsame07 ztymvaariwsame07}</td><td>（中継用）ＭＶＡ適用Ｗ（同水準）０７</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaariwyentuktypesame07 ztymvaariwyentuktypesame07}</td><td>（中継用）ＭＶＡ適用Ｗ換算通貨タイプ（同水準）０７</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaariwsameyendaka07 ztymvaariwsameyendaka07}</td><td>（中継用）ＭＶＡ適用Ｗ換算（同水準）円高０７</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaariwsameyenkijyun07 ztymvaariwsameyenkijyun07}</td><td>（中継用）ＭＶＡ適用Ｗ換算（同水準）中央値０７</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaariwsameyenyasu07 ztymvaariwsameyenyasu07}</td><td>（中継用）ＭＶＡ適用Ｗ換算（同水準）円安０７</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaariumsameyendaka07 ztymvaariumsameyendaka07}</td><td>（中継用）ＭＶＡ適用Ｗ換算目標額到達有無（同水準）円高０７</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaariumsameyenkijyun07 ztymvaariumsameyenkijyun07}</td><td>（中継用）ＭＶＡ適用Ｗ換算目標額到達有無（同水準）中央値０７</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaariumsameyenyasu07 ztymvaariumsameyenyasu07}</td><td>（中継用）ＭＶＡ適用Ｗ換算目標額到達有無（同水準）円安０７</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaariwtuktypedown07 ztymvaariwtuktypedown07}</td><td>（中継用）ＭＶＡ適用Ｗ通貨タイプ（低下）０７</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaaritmttknkykkjmdown07 ztymvaaritmttknkykkjmdown07}</td><td>（中継用）ＭＶＡ適用積立金（解約控除前）（低下）０７</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaariwdown07 ztymvaariwdown07}</td><td>（中継用）ＭＶＡ適用Ｗ（低下）０７</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaariwyentuktypedown07 ztymvaariwyentuktypedown07}</td><td>（中継用）ＭＶＡ適用Ｗ換算通貨タイプ（低下）０７</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaariwdownyendaka07 ztymvaariwdownyendaka07}</td><td>（中継用）ＭＶＡ適用Ｗ換算（低下）円高０７</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaariwdownyenkijyun07 ztymvaariwdownyenkijyun07}</td><td>（中継用）ＭＶＡ適用Ｗ換算（低下）中央値０７</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaariwdownyenyasu07 ztymvaariwdownyenyasu07}</td><td>（中継用）ＭＶＡ適用Ｗ換算（低下）円安０７</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaariumdownyendaka07 ztymvaariumdownyendaka07}</td><td>（中継用）ＭＶＡ適用Ｗ換算目標額到達有無（低下）円高０７</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaariumdownyenkijyun07 ztymvaariumdownyenkijyun07}</td><td>（中継用）ＭＶＡ適用Ｗ換算目標額到達有無（低下）中央値０７</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaariumdownyenyasu07 ztymvaariumdownyenyasu07}</td><td>（中継用）ＭＶＡ適用Ｗ換算目標額到達有無（低下）円安０７</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaarivtuktype07 ztymvaarivtuktype07}</td><td>（中継用）ＭＶＡ適用保険料積立金額通貨タイプ０７</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaariv07 ztymvaariv07}</td><td>（中継用）ＭＶＡ適用保険料積立金額０７</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyptmttkngkutiwake107 ztyptmttkngkutiwake107}</td><td>（中継用）保険料積立金額内訳（１）０７</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyptmttkngkutiwake207 ztyptmttkngkutiwake207}</td><td>（中継用）保険料積立金額内訳（２）０７</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaarinenoutouym08 ztymvaarinenoutouym08}</td><td>（中継用）ＭＶＡ適用年単位応当年月０８</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaarisisuuupritu08 ztymvaarisisuuupritu08}</td><td>（中継用）ＭＶＡ適用指数上昇率０８</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaaritmttknzkritu08 ztymvaaritmttknzkritu08}</td><td>（中継用）ＭＶＡ適用積立金増加率０８</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaariwtuktypeup08 ztymvaariwtuktypeup08}</td><td>（中継用）ＭＶＡ適用Ｗ通貨タイプ（上昇）０８</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaaritmttknkykkjmup08 ztymvaaritmttknkykkjmup08}</td><td>（中継用）ＭＶＡ適用積立金（解約控除前）（上昇）０８</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaariwup08 ztymvaariwup08}</td><td>（中継用）ＭＶＡ適用Ｗ（上昇）０８</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaariwyentuktypeup08 ztymvaariwyentuktypeup08}</td><td>（中継用）ＭＶＡ適用Ｗ換算通貨タイプ（上昇）０８</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaariwupyendaka08 ztymvaariwupyendaka08}</td><td>（中継用）ＭＶＡ適用Ｗ換算（上昇）円高０８</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaariwupyenkijyun08 ztymvaariwupyenkijyun08}</td><td>（中継用）ＭＶＡ適用Ｗ換算（上昇）中央値０８</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaariwupyenyasu08 ztymvaariwupyenyasu08}</td><td>（中継用）ＭＶＡ適用Ｗ換算（上昇）円安０８</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaariwumupyendaka08 ztymvaariwumupyendaka08}</td><td>（中継用）ＭＶＡ適用Ｗ換算目標額到達有無（上昇）円高０８</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaariumupyenkijyun08 ztymvaariumupyenkijyun08}</td><td>（中継用）ＭＶＡ適用Ｗ換算目標額到達有無（上昇）中央値０８</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaariumupyenyasu08 ztymvaariumupyenyasu08}</td><td>（中継用）ＭＶＡ適用Ｗ換算目標額到達有無（上昇）円安０８</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaariwtuktypesame08 ztymvaariwtuktypesame08}</td><td>（中継用）ＭＶＡ適用Ｗ通貨タイプ（同水準）０８</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaaritmttknkykkjmsame08 ztymvaaritmttknkykkjmsame08}</td><td>（中継用）ＭＶＡ適用積立金（解約控除前）（同水準）０８</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaariwsame08 ztymvaariwsame08}</td><td>（中継用）ＭＶＡ適用Ｗ（同水準）０８</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaariwyentuktypesame08 ztymvaariwyentuktypesame08}</td><td>（中継用）ＭＶＡ適用Ｗ換算通貨タイプ（同水準）０８</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaariwsameyendaka08 ztymvaariwsameyendaka08}</td><td>（中継用）ＭＶＡ適用Ｗ換算（同水準）円高０８</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaariwsameyenkijyun08 ztymvaariwsameyenkijyun08}</td><td>（中継用）ＭＶＡ適用Ｗ換算（同水準）中央値０８</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaariwsameyenyasu08 ztymvaariwsameyenyasu08}</td><td>（中継用）ＭＶＡ適用Ｗ換算（同水準）円安０８</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaariumsameyendaka08 ztymvaariumsameyendaka08}</td><td>（中継用）ＭＶＡ適用Ｗ換算目標額到達有無（同水準）円高０８</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaariumsameyenkijyun08 ztymvaariumsameyenkijyun08}</td><td>（中継用）ＭＶＡ適用Ｗ換算目標額到達有無（同水準）中央値０８</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaariumsameyenyasu08 ztymvaariumsameyenyasu08}</td><td>（中継用）ＭＶＡ適用Ｗ換算目標額到達有無（同水準）円安０８</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaariwtuktypedown08 ztymvaariwtuktypedown08}</td><td>（中継用）ＭＶＡ適用Ｗ通貨タイプ（低下）０８</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaaritmttknkykkjmdown08 ztymvaaritmttknkykkjmdown08}</td><td>（中継用）ＭＶＡ適用積立金（解約控除前）（低下）０８</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaariwdown08 ztymvaariwdown08}</td><td>（中継用）ＭＶＡ適用Ｗ（低下）０８</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaariwyentuktypedown08 ztymvaariwyentuktypedown08}</td><td>（中継用）ＭＶＡ適用Ｗ換算通貨タイプ（低下）０８</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaariwdownyendaka08 ztymvaariwdownyendaka08}</td><td>（中継用）ＭＶＡ適用Ｗ換算（低下）円高０８</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaariwdownyenkijyun08 ztymvaariwdownyenkijyun08}</td><td>（中継用）ＭＶＡ適用Ｗ換算（低下）中央値０８</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaariwdownyenyasu08 ztymvaariwdownyenyasu08}</td><td>（中継用）ＭＶＡ適用Ｗ換算（低下）円安０８</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaariumdownyendaka08 ztymvaariumdownyendaka08}</td><td>（中継用）ＭＶＡ適用Ｗ換算目標額到達有無（低下）円高０８</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaariumdownyenkijyun08 ztymvaariumdownyenkijyun08}</td><td>（中継用）ＭＶＡ適用Ｗ換算目標額到達有無（低下）中央値０８</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaariumdownyenyasu08 ztymvaariumdownyenyasu08}</td><td>（中継用）ＭＶＡ適用Ｗ換算目標額到達有無（低下）円安０８</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaarivtuktype08 ztymvaarivtuktype08}</td><td>（中継用）ＭＶＡ適用保険料積立金額通貨タイプ０８</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaariv08 ztymvaariv08}</td><td>（中継用）ＭＶＡ適用保険料積立金額０８</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyptmttkngkutiwake108 ztyptmttkngkutiwake108}</td><td>（中継用）保険料積立金額内訳（１）０８</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyptmttkngkutiwake208 ztyptmttkngkutiwake208}</td><td>（中継用）保険料積立金額内訳（２）０８</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaarinenoutouym09 ztymvaarinenoutouym09}</td><td>（中継用）ＭＶＡ適用年単位応当年月０９</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaarisisuuupritu09 ztymvaarisisuuupritu09}</td><td>（中継用）ＭＶＡ適用指数上昇率０９</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaaritmttknzkritu09 ztymvaaritmttknzkritu09}</td><td>（中継用）ＭＶＡ適用積立金増加率０９</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaariwtuktypeup09 ztymvaariwtuktypeup09}</td><td>（中継用）ＭＶＡ適用Ｗ通貨タイプ（上昇）０９</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaaritmttknkykkjmup09 ztymvaaritmttknkykkjmup09}</td><td>（中継用）ＭＶＡ適用積立金（解約控除前）（上昇）０９</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaariwup09 ztymvaariwup09}</td><td>（中継用）ＭＶＡ適用Ｗ（上昇）０９</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaariwyentuktypeup09 ztymvaariwyentuktypeup09}</td><td>（中継用）ＭＶＡ適用Ｗ換算通貨タイプ（上昇）０９</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaariwupyendaka09 ztymvaariwupyendaka09}</td><td>（中継用）ＭＶＡ適用Ｗ換算（上昇）円高０９</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaariwupyenkijyun09 ztymvaariwupyenkijyun09}</td><td>（中継用）ＭＶＡ適用Ｗ換算（上昇）中央値０９</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaariwupyenyasu09 ztymvaariwupyenyasu09}</td><td>（中継用）ＭＶＡ適用Ｗ換算（上昇）円安０９</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaariwumupyendaka09 ztymvaariwumupyendaka09}</td><td>（中継用）ＭＶＡ適用Ｗ換算目標額到達有無（上昇）円高０９</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaariumupyenkijyun09 ztymvaariumupyenkijyun09}</td><td>（中継用）ＭＶＡ適用Ｗ換算目標額到達有無（上昇）中央値０９</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaariumupyenyasu09 ztymvaariumupyenyasu09}</td><td>（中継用）ＭＶＡ適用Ｗ換算目標額到達有無（上昇）円安０９</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaariwtuktypesame09 ztymvaariwtuktypesame09}</td><td>（中継用）ＭＶＡ適用Ｗ通貨タイプ（同水準）０９</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaaritmttknkykkjmsame09 ztymvaaritmttknkykkjmsame09}</td><td>（中継用）ＭＶＡ適用積立金（解約控除前）（同水準）０９</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaariwsame09 ztymvaariwsame09}</td><td>（中継用）ＭＶＡ適用Ｗ（同水準）０９</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaariwyentuktypesame09 ztymvaariwyentuktypesame09}</td><td>（中継用）ＭＶＡ適用Ｗ換算通貨タイプ（同水準）０９</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaariwsameyendaka09 ztymvaariwsameyendaka09}</td><td>（中継用）ＭＶＡ適用Ｗ換算（同水準）円高０９</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaariwsameyenkijyun09 ztymvaariwsameyenkijyun09}</td><td>（中継用）ＭＶＡ適用Ｗ換算（同水準）中央値０９</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaariwsameyenyasu09 ztymvaariwsameyenyasu09}</td><td>（中継用）ＭＶＡ適用Ｗ換算（同水準）円安０９</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaariumsameyendaka09 ztymvaariumsameyendaka09}</td><td>（中継用）ＭＶＡ適用Ｗ換算目標額到達有無（同水準）円高０９</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaariumsameyenkijyun09 ztymvaariumsameyenkijyun09}</td><td>（中継用）ＭＶＡ適用Ｗ換算目標額到達有無（同水準）中央値０９</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaariumsameyenyasu09 ztymvaariumsameyenyasu09}</td><td>（中継用）ＭＶＡ適用Ｗ換算目標額到達有無（同水準）円安０９</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaariwtuktypedown09 ztymvaariwtuktypedown09}</td><td>（中継用）ＭＶＡ適用Ｗ通貨タイプ（低下）０９</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaaritmttknkykkjmdown09 ztymvaaritmttknkykkjmdown09}</td><td>（中継用）ＭＶＡ適用積立金（解約控除前）（低下）０９</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaariwdown09 ztymvaariwdown09}</td><td>（中継用）ＭＶＡ適用Ｗ（低下）０９</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaariwyentuktypedown09 ztymvaariwyentuktypedown09}</td><td>（中継用）ＭＶＡ適用Ｗ換算通貨タイプ（低下）０９</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaariwdownyendaka09 ztymvaariwdownyendaka09}</td><td>（中継用）ＭＶＡ適用Ｗ換算（低下）円高０９</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaariwdownyenkijyun09 ztymvaariwdownyenkijyun09}</td><td>（中継用）ＭＶＡ適用Ｗ換算（低下）中央値０９</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaariwdownyenyasu09 ztymvaariwdownyenyasu09}</td><td>（中継用）ＭＶＡ適用Ｗ換算（低下）円安０９</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaariumdownyendaka09 ztymvaariumdownyendaka09}</td><td>（中継用）ＭＶＡ適用Ｗ換算目標額到達有無（低下）円高０９</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaariumdownyenkijyun09 ztymvaariumdownyenkijyun09}</td><td>（中継用）ＭＶＡ適用Ｗ換算目標額到達有無（低下）中央値０９</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaariumdownyenyasu09 ztymvaariumdownyenyasu09}</td><td>（中継用）ＭＶＡ適用Ｗ換算目標額到達有無（低下）円安０９</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaarivtuktype09 ztymvaarivtuktype09}</td><td>（中継用）ＭＶＡ適用保険料積立金額通貨タイプ０９</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaariv09 ztymvaariv09}</td><td>（中継用）ＭＶＡ適用保険料積立金額０９</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyptmttkngkutiwake109 ztyptmttkngkutiwake109}</td><td>（中継用）保険料積立金額内訳（１）０９</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyptmttkngkutiwake209 ztyptmttkngkutiwake209}</td><td>（中継用）保険料積立金額内訳（２）０９</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaarinenoutouym10 ztymvaarinenoutouym10}</td><td>（中継用）ＭＶＡ適用年単位応当年月１０</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaarisisuuupritu10 ztymvaarisisuuupritu10}</td><td>（中継用）ＭＶＡ適用指数上昇率１０</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaaritmttknzkritu10 ztymvaaritmttknzkritu10}</td><td>（中継用）ＭＶＡ適用積立金増加率１０</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaariwtuktypeup10 ztymvaariwtuktypeup10}</td><td>（中継用）ＭＶＡ適用Ｗ通貨タイプ（上昇）１０</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaaritmttknkykkjmup10 ztymvaaritmttknkykkjmup10}</td><td>（中継用）ＭＶＡ適用積立金（解約控除前）（上昇）１０</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaariwup10 ztymvaariwup10}</td><td>（中継用）ＭＶＡ適用Ｗ（上昇）１０</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaariwyentuktypeup10 ztymvaariwyentuktypeup10}</td><td>（中継用）ＭＶＡ適用Ｗ換算通貨タイプ（上昇）１０</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaariwupyendaka10 ztymvaariwupyendaka10}</td><td>（中継用）ＭＶＡ適用Ｗ換算（上昇）円高１０</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaariwupyenkijyun10 ztymvaariwupyenkijyun10}</td><td>（中継用）ＭＶＡ適用Ｗ換算（上昇）中央値１０</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaariwupyenyasu10 ztymvaariwupyenyasu10}</td><td>（中継用）ＭＶＡ適用Ｗ換算（上昇）円安１０</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaariwumupyendaka10 ztymvaariwumupyendaka10}</td><td>（中継用）ＭＶＡ適用Ｗ換算目標額到達有無（上昇）円高１０</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaariumupyenkijyun10 ztymvaariumupyenkijyun10}</td><td>（中継用）ＭＶＡ適用Ｗ換算目標額到達有無（上昇）中央値１０</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaariumupyenyasu10 ztymvaariumupyenyasu10}</td><td>（中継用）ＭＶＡ適用Ｗ換算目標額到達有無（上昇）円安１０</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaariwtuktypesame10 ztymvaariwtuktypesame10}</td><td>（中継用）ＭＶＡ適用Ｗ通貨タイプ（同水準）１０</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaaritmttknkykkjmsame10 ztymvaaritmttknkykkjmsame10}</td><td>（中継用）ＭＶＡ適用積立金（解約控除前）（同水準）１０</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaariwsame10 ztymvaariwsame10}</td><td>（中継用）ＭＶＡ適用Ｗ（同水準）１０</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaariwyentuktypesame10 ztymvaariwyentuktypesame10}</td><td>（中継用）ＭＶＡ適用Ｗ換算通貨タイプ（同水準）１０</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaariwsameyendaka10 ztymvaariwsameyendaka10}</td><td>（中継用）ＭＶＡ適用Ｗ換算（同水準）円高１０</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaariwsameyenkijyun10 ztymvaariwsameyenkijyun10}</td><td>（中継用）ＭＶＡ適用Ｗ換算（同水準）中央値１０</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaariwsameyenyasu10 ztymvaariwsameyenyasu10}</td><td>（中継用）ＭＶＡ適用Ｗ換算（同水準）円安１０</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaariumsameyendaka10 ztymvaariumsameyendaka10}</td><td>（中継用）ＭＶＡ適用Ｗ換算目標額到達有無（同水準）円高１０</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaariumsameyenkijyun10 ztymvaariumsameyenkijyun10}</td><td>（中継用）ＭＶＡ適用Ｗ換算目標額到達有無（同水準）中央値１０</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaariumsameyenyasu10 ztymvaariumsameyenyasu10}</td><td>（中継用）ＭＶＡ適用Ｗ換算目標額到達有無（同水準）円安１０</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaariwtuktypedown10 ztymvaariwtuktypedown10}</td><td>（中継用）ＭＶＡ適用Ｗ通貨タイプ（低下）１０</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaaritmttknkykkjmdown10 ztymvaaritmttknkykkjmdown10}</td><td>（中継用）ＭＶＡ適用積立金（解約控除前）（低下）１０</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaariwdown10 ztymvaariwdown10}</td><td>（中継用）ＭＶＡ適用Ｗ（低下）１０</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaariwyentuktypedown10 ztymvaariwyentuktypedown10}</td><td>（中継用）ＭＶＡ適用Ｗ換算通貨タイプ（低下）１０</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaariwdownyendaka10 ztymvaariwdownyendaka10}</td><td>（中継用）ＭＶＡ適用Ｗ換算（低下）円高１０</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaariwdownyenkijyun10 ztymvaariwdownyenkijyun10}</td><td>（中継用）ＭＶＡ適用Ｗ換算（低下）中央値１０</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaariwdownyenyasu10 ztymvaariwdownyenyasu10}</td><td>（中継用）ＭＶＡ適用Ｗ換算（低下）円安１０</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaariumdownyendaka10 ztymvaariumdownyendaka10}</td><td>（中継用）ＭＶＡ適用Ｗ換算目標額到達有無（低下）円高１０</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaariumdownyenkijyun10 ztymvaariumdownyenkijyun10}</td><td>（中継用）ＭＶＡ適用Ｗ換算目標額到達有無（低下）中央値１０</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaariumdownyenyasu10 ztymvaariumdownyenyasu10}</td><td>（中継用）ＭＶＡ適用Ｗ換算目標額到達有無（低下）円安１０</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaarivtuktype10 ztymvaarivtuktype10}</td><td>（中継用）ＭＶＡ適用保険料積立金額通貨タイプ１０</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaariv10 ztymvaariv10}</td><td>（中継用）ＭＶＡ適用保険料積立金額１０</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyptmttkngkutiwake110 ztyptmttkngkutiwake110}</td><td>（中継用）保険料積立金額内訳（１）１０</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyptmttkngkutiwake210 ztyptmttkngkutiwake210}</td><td>（中継用）保険料積立金額内訳（２）１０</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaarinenoutouym11 ztymvaarinenoutouym11}</td><td>（中継用）ＭＶＡ適用年単位応当年月１１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaariwtuktypeup11 ztymvaariwtuktypeup11}</td><td>（中継用）ＭＶＡ適用Ｗ通貨タイプ（上昇）１１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaariwup11 ztymvaariwup11}</td><td>（中継用）ＭＶＡ適用Ｗ（上昇）１１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaariwyentuktypeup11 ztymvaariwyentuktypeup11}</td><td>（中継用）ＭＶＡ適用Ｗ換算通貨タイプ（上昇）１１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaariwupyendaka11 ztymvaariwupyendaka11}</td><td>（中継用）ＭＶＡ適用Ｗ換算（上昇）円高１１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaariwupyenkijyun11 ztymvaariwupyenkijyun11}</td><td>（中継用）ＭＶＡ適用Ｗ換算（上昇）中央値１１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaariwupyenyasu11 ztymvaariwupyenyasu11}</td><td>（中継用）ＭＶＡ適用Ｗ換算（上昇）円安１１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaariwumupyendaka11 ztymvaariwumupyendaka11}</td><td>（中継用）ＭＶＡ適用Ｗ換算目標額到達有無（上昇）円高１１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaariumupyenkijyun11 ztymvaariumupyenkijyun11}</td><td>（中継用）ＭＶＡ適用Ｗ換算目標額到達有無（上昇）中央値１１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaariumupyenyasu11 ztymvaariumupyenyasu11}</td><td>（中継用）ＭＶＡ適用Ｗ換算目標額到達有無（上昇）円安１１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaariwtuktypesame11 ztymvaariwtuktypesame11}</td><td>（中継用）ＭＶＡ適用Ｗ通貨タイプ（同水準）１１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaariwsame11 ztymvaariwsame11}</td><td>（中継用）ＭＶＡ適用Ｗ（同水準）１１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaariwyentuktypesame11 ztymvaariwyentuktypesame11}</td><td>（中継用）ＭＶＡ適用Ｗ換算通貨タイプ（同水準）１１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaariwsameyendaka11 ztymvaariwsameyendaka11}</td><td>（中継用）ＭＶＡ適用Ｗ換算（同水準）円高１１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaariwsameyenkijyun11 ztymvaariwsameyenkijyun11}</td><td>（中継用）ＭＶＡ適用Ｗ換算（同水準）中央値１１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaariwsameyenyasu11 ztymvaariwsameyenyasu11}</td><td>（中継用）ＭＶＡ適用Ｗ換算（同水準）円安１１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaariumsameyendaka11 ztymvaariumsameyendaka11}</td><td>（中継用）ＭＶＡ適用Ｗ換算目標額到達有無（同水準）円高１１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaariumsameyenkijyun11 ztymvaariumsameyenkijyun11}</td><td>（中継用）ＭＶＡ適用Ｗ換算目標額到達有無（同水準）中央値１１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaariumsameyenyasu11 ztymvaariumsameyenyasu11}</td><td>（中継用）ＭＶＡ適用Ｗ換算目標額到達有無（同水準）円安１１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaariwtuktypedown11 ztymvaariwtuktypedown11}</td><td>（中継用）ＭＶＡ適用Ｗ通貨タイプ（低下）１１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaariwdown11 ztymvaariwdown11}</td><td>（中継用）ＭＶＡ適用Ｗ（低下）１１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaariwyentuktypedown11 ztymvaariwyentuktypedown11}</td><td>（中継用）ＭＶＡ適用Ｗ換算通貨タイプ（低下）１１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaariwdownyendaka11 ztymvaariwdownyendaka11}</td><td>（中継用）ＭＶＡ適用Ｗ換算（低下）円高１１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaariwdownyenkijyun11 ztymvaariwdownyenkijyun11}</td><td>（中継用）ＭＶＡ適用Ｗ換算（低下）中央値１１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaariwdownyenyasu11 ztymvaariwdownyenyasu11}</td><td>（中継用）ＭＶＡ適用Ｗ換算（低下）円安１１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaariumdownyendaka11 ztymvaariumdownyendaka11}</td><td>（中継用）ＭＶＡ適用Ｗ換算目標額到達有無（低下）円高１１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaariumdownyenkijyun11 ztymvaariumdownyenkijyun11}</td><td>（中継用）ＭＶＡ適用Ｗ換算目標額到達有無（低下）中央値１１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaariumdownyenyasu11 ztymvaariumdownyenyasu11}</td><td>（中継用）ＭＶＡ適用Ｗ換算目標額到達有無（低下）円安１１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaarivtuktype11 ztymvaarivtuktype11}</td><td>（中継用）ＭＶＡ適用保険料積立金額通貨タイプ１１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaariv11 ztymvaariv11}</td><td>（中継用）ＭＶＡ適用保険料積立金額１１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaarinenoutouym12 ztymvaarinenoutouym12}</td><td>（中継用）ＭＶＡ適用年単位応当年月１２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaariwtuktypeup12 ztymvaariwtuktypeup12}</td><td>（中継用）ＭＶＡ適用Ｗ通貨タイプ（上昇）１２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaariwup12 ztymvaariwup12}</td><td>（中継用）ＭＶＡ適用Ｗ（上昇）１２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaariwyentuktypeup12 ztymvaariwyentuktypeup12}</td><td>（中継用）ＭＶＡ適用Ｗ換算通貨タイプ（上昇）１２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaariwupyendaka12 ztymvaariwupyendaka12}</td><td>（中継用）ＭＶＡ適用Ｗ換算（上昇）円高１２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaariwupyenkijyun12 ztymvaariwupyenkijyun12}</td><td>（中継用）ＭＶＡ適用Ｗ換算（上昇）中央値１２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaariwupyenyasu12 ztymvaariwupyenyasu12}</td><td>（中継用）ＭＶＡ適用Ｗ換算（上昇）円安１２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaariwumupyendaka12 ztymvaariwumupyendaka12}</td><td>（中継用）ＭＶＡ適用Ｗ換算目標額到達有無（上昇）円高１２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaariumupyenkijyun12 ztymvaariumupyenkijyun12}</td><td>（中継用）ＭＶＡ適用Ｗ換算目標額到達有無（上昇）中央値１２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaariumupyenyasu12 ztymvaariumupyenyasu12}</td><td>（中継用）ＭＶＡ適用Ｗ換算目標額到達有無（上昇）円安１２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaariwtuktypesame12 ztymvaariwtuktypesame12}</td><td>（中継用）ＭＶＡ適用Ｗ通貨タイプ（同水準）１２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaariwsame12 ztymvaariwsame12}</td><td>（中継用）ＭＶＡ適用Ｗ（同水準）１２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaariwyentuktypesame12 ztymvaariwyentuktypesame12}</td><td>（中継用）ＭＶＡ適用Ｗ換算通貨タイプ（同水準）１２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaariwsameyendaka12 ztymvaariwsameyendaka12}</td><td>（中継用）ＭＶＡ適用Ｗ換算（同水準）円高１２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaariwsameyenkijyun12 ztymvaariwsameyenkijyun12}</td><td>（中継用）ＭＶＡ適用Ｗ換算（同水準）中央値１２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaariwsameyenyasu12 ztymvaariwsameyenyasu12}</td><td>（中継用）ＭＶＡ適用Ｗ換算（同水準）円安１２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaariumsameyendaka12 ztymvaariumsameyendaka12}</td><td>（中継用）ＭＶＡ適用Ｗ換算目標額到達有無（同水準）円高１２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaariumsameyenkijyun12 ztymvaariumsameyenkijyun12}</td><td>（中継用）ＭＶＡ適用Ｗ換算目標額到達有無（同水準）中央値１２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaariumsameyenyasu12 ztymvaariumsameyenyasu12}</td><td>（中継用）ＭＶＡ適用Ｗ換算目標額到達有無（同水準）円安１２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaariwtuktypedown12 ztymvaariwtuktypedown12}</td><td>（中継用）ＭＶＡ適用Ｗ通貨タイプ（低下）１２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaariwdown12 ztymvaariwdown12}</td><td>（中継用）ＭＶＡ適用Ｗ（低下）１２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaariwyentuktypedown12 ztymvaariwyentuktypedown12}</td><td>（中継用）ＭＶＡ適用Ｗ換算通貨タイプ（低下）１２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaariwdownyendaka12 ztymvaariwdownyendaka12}</td><td>（中継用）ＭＶＡ適用Ｗ換算（低下）円高１２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaariwdownyenkijyun12 ztymvaariwdownyenkijyun12}</td><td>（中継用）ＭＶＡ適用Ｗ換算（低下）中央値１２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaariwdownyenyasu12 ztymvaariwdownyenyasu12}</td><td>（中継用）ＭＶＡ適用Ｗ換算（低下）円安１２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaariumdownyendaka12 ztymvaariumdownyendaka12}</td><td>（中継用）ＭＶＡ適用Ｗ換算目標額到達有無（低下）円高１２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaariumdownyenkijyun12 ztymvaariumdownyenkijyun12}</td><td>（中継用）ＭＶＡ適用Ｗ換算目標額到達有無（低下）中央値１２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaariumdownyenyasu12 ztymvaariumdownyenyasu12}</td><td>（中継用）ＭＶＡ適用Ｗ換算目標額到達有無（低下）円安１２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaarivtuktype12 ztymvaarivtuktype12}</td><td>（中継用）ＭＶＡ適用保険料積立金額通貨タイプ１２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaariv12 ztymvaariv12}</td><td>（中継用）ＭＶＡ適用保険料積立金額１２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaarinenoutouym13 ztymvaarinenoutouym13}</td><td>（中継用）ＭＶＡ適用年単位応当年月１３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaariwtuktypeup13 ztymvaariwtuktypeup13}</td><td>（中継用）ＭＶＡ適用Ｗ通貨タイプ（上昇）１３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaariwup13 ztymvaariwup13}</td><td>（中継用）ＭＶＡ適用Ｗ（上昇）１３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaariwyentuktypeup13 ztymvaariwyentuktypeup13}</td><td>（中継用）ＭＶＡ適用Ｗ換算通貨タイプ（上昇）１３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaariwupyendaka13 ztymvaariwupyendaka13}</td><td>（中継用）ＭＶＡ適用Ｗ換算（上昇）円高１３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaariwupyenkijyun13 ztymvaariwupyenkijyun13}</td><td>（中継用）ＭＶＡ適用Ｗ換算（上昇）中央値１３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaariwupyenyasu13 ztymvaariwupyenyasu13}</td><td>（中継用）ＭＶＡ適用Ｗ換算（上昇）円安１３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaariwumupyendaka13 ztymvaariwumupyendaka13}</td><td>（中継用）ＭＶＡ適用Ｗ換算目標額到達有無（上昇）円高１３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaariumupyenkijyun13 ztymvaariumupyenkijyun13}</td><td>（中継用）ＭＶＡ適用Ｗ換算目標額到達有無（上昇）中央値１３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaariumupyenyasu13 ztymvaariumupyenyasu13}</td><td>（中継用）ＭＶＡ適用Ｗ換算目標額到達有無（上昇）円安１３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaariwtuktypesame13 ztymvaariwtuktypesame13}</td><td>（中継用）ＭＶＡ適用Ｗ通貨タイプ（同水準）１３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaariwsame13 ztymvaariwsame13}</td><td>（中継用）ＭＶＡ適用Ｗ（同水準）１３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaariwyentuktypesame13 ztymvaariwyentuktypesame13}</td><td>（中継用）ＭＶＡ適用Ｗ換算通貨タイプ（同水準）１３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaariwsameyendaka13 ztymvaariwsameyendaka13}</td><td>（中継用）ＭＶＡ適用Ｗ換算（同水準）円高１３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaariwsameyenkijyun13 ztymvaariwsameyenkijyun13}</td><td>（中継用）ＭＶＡ適用Ｗ換算（同水準）中央値１３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaariwsameyenyasu13 ztymvaariwsameyenyasu13}</td><td>（中継用）ＭＶＡ適用Ｗ換算（同水準）円安１３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaariumsameyendaka13 ztymvaariumsameyendaka13}</td><td>（中継用）ＭＶＡ適用Ｗ換算目標額到達有無（同水準）円高１３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaariumsameyenkijyun13 ztymvaariumsameyenkijyun13}</td><td>（中継用）ＭＶＡ適用Ｗ換算目標額到達有無（同水準）中央値１３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaariumsameyenyasu13 ztymvaariumsameyenyasu13}</td><td>（中継用）ＭＶＡ適用Ｗ換算目標額到達有無（同水準）円安１３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaariwtuktypedown13 ztymvaariwtuktypedown13}</td><td>（中継用）ＭＶＡ適用Ｗ通貨タイプ（低下）１３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaariwdown13 ztymvaariwdown13}</td><td>（中継用）ＭＶＡ適用Ｗ（低下）１３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaariwyentuktypedown13 ztymvaariwyentuktypedown13}</td><td>（中継用）ＭＶＡ適用Ｗ換算通貨タイプ（低下）１３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaariwdownyendaka13 ztymvaariwdownyendaka13}</td><td>（中継用）ＭＶＡ適用Ｗ換算（低下）円高１３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaariwdownyenkijyun13 ztymvaariwdownyenkijyun13}</td><td>（中継用）ＭＶＡ適用Ｗ換算（低下）中央値１３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaariwdownyenyasu13 ztymvaariwdownyenyasu13}</td><td>（中継用）ＭＶＡ適用Ｗ換算（低下）円安１３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaariumdownyendaka13 ztymvaariumdownyendaka13}</td><td>（中継用）ＭＶＡ適用Ｗ換算目標額到達有無（低下）円高１３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaariumdownyenkijyun13 ztymvaariumdownyenkijyun13}</td><td>（中継用）ＭＶＡ適用Ｗ換算目標額到達有無（低下）中央値１３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaariumdownyenyasu13 ztymvaariumdownyenyasu13}</td><td>（中継用）ＭＶＡ適用Ｗ換算目標額到達有無（低下）円安１３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaarivtuktype13 ztymvaarivtuktype13}</td><td>（中継用）ＭＶＡ適用保険料積立金額通貨タイプ１３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaariv13 ztymvaariv13}</td><td>（中継用）ＭＶＡ適用保険料積立金額１３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaarinenoutouym14 ztymvaarinenoutouym14}</td><td>（中継用）ＭＶＡ適用年単位応当年月１４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaariwtuktypeup14 ztymvaariwtuktypeup14}</td><td>（中継用）ＭＶＡ適用Ｗ通貨タイプ（上昇）１４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaariwup14 ztymvaariwup14}</td><td>（中継用）ＭＶＡ適用Ｗ（上昇）１４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaariwyentuktypeup14 ztymvaariwyentuktypeup14}</td><td>（中継用）ＭＶＡ適用Ｗ換算通貨タイプ（上昇）１４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaariwupyendaka14 ztymvaariwupyendaka14}</td><td>（中継用）ＭＶＡ適用Ｗ換算（上昇）円高１４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaariwupyenkijyun14 ztymvaariwupyenkijyun14}</td><td>（中継用）ＭＶＡ適用Ｗ換算（上昇）中央値１４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaariwupyenyasu14 ztymvaariwupyenyasu14}</td><td>（中継用）ＭＶＡ適用Ｗ換算（上昇）円安１４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaariwumupyendaka14 ztymvaariwumupyendaka14}</td><td>（中継用）ＭＶＡ適用Ｗ換算目標額到達有無（上昇）円高１４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaariumupyenkijyun14 ztymvaariumupyenkijyun14}</td><td>（中継用）ＭＶＡ適用Ｗ換算目標額到達有無（上昇）中央値１４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaariumupyenyasu14 ztymvaariumupyenyasu14}</td><td>（中継用）ＭＶＡ適用Ｗ換算目標額到達有無（上昇）円安１４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaariwtuktypesame14 ztymvaariwtuktypesame14}</td><td>（中継用）ＭＶＡ適用Ｗ通貨タイプ（同水準）１４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaariwsame14 ztymvaariwsame14}</td><td>（中継用）ＭＶＡ適用Ｗ（同水準）１４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaariwyentuktypesame14 ztymvaariwyentuktypesame14}</td><td>（中継用）ＭＶＡ適用Ｗ換算通貨タイプ（同水準）１４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaariwsameyendaka14 ztymvaariwsameyendaka14}</td><td>（中継用）ＭＶＡ適用Ｗ換算（同水準）円高１４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaariwsameyenkijyun14 ztymvaariwsameyenkijyun14}</td><td>（中継用）ＭＶＡ適用Ｗ換算（同水準）中央値１４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaariwsameyenyasu14 ztymvaariwsameyenyasu14}</td><td>（中継用）ＭＶＡ適用Ｗ換算（同水準）円安１４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaariumsameyendaka14 ztymvaariumsameyendaka14}</td><td>（中継用）ＭＶＡ適用Ｗ換算目標額到達有無（同水準）円高１４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaariumsameyenkijyun14 ztymvaariumsameyenkijyun14}</td><td>（中継用）ＭＶＡ適用Ｗ換算目標額到達有無（同水準）中央値１４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaariumsameyenyasu14 ztymvaariumsameyenyasu14}</td><td>（中継用）ＭＶＡ適用Ｗ換算目標額到達有無（同水準）円安１４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaariwtuktypedown14 ztymvaariwtuktypedown14}</td><td>（中継用）ＭＶＡ適用Ｗ通貨タイプ（低下）１４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaariwdown14 ztymvaariwdown14}</td><td>（中継用）ＭＶＡ適用Ｗ（低下）１４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaariwyentuktypedown14 ztymvaariwyentuktypedown14}</td><td>（中継用）ＭＶＡ適用Ｗ換算通貨タイプ（低下）１４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaariwdownyendaka14 ztymvaariwdownyendaka14}</td><td>（中継用）ＭＶＡ適用Ｗ換算（低下）円高１４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaariwdownyenkijyun14 ztymvaariwdownyenkijyun14}</td><td>（中継用）ＭＶＡ適用Ｗ換算（低下）中央値１４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaariwdownyenyasu14 ztymvaariwdownyenyasu14}</td><td>（中継用）ＭＶＡ適用Ｗ換算（低下）円安１４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaariumdownyendaka14 ztymvaariumdownyendaka14}</td><td>（中継用）ＭＶＡ適用Ｗ換算目標額到達有無（低下）円高１４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaariumdownyenkijyun14 ztymvaariumdownyenkijyun14}</td><td>（中継用）ＭＶＡ適用Ｗ換算目標額到達有無（低下）中央値１４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaariumdownyenyasu14 ztymvaariumdownyenyasu14}</td><td>（中継用）ＭＶＡ適用Ｗ換算目標額到達有無（低下）円安１４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaarivtuktype14 ztymvaarivtuktype14}</td><td>（中継用）ＭＶＡ適用保険料積立金額通貨タイプ１４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaariv14 ztymvaariv14}</td><td>（中継用）ＭＶＡ適用保険料積立金額１４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaarinenoutouym15 ztymvaarinenoutouym15}</td><td>（中継用）ＭＶＡ適用年単位応当年月１５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaariwtuktypeup15 ztymvaariwtuktypeup15}</td><td>（中継用）ＭＶＡ適用Ｗ通貨タイプ（上昇）１５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaariwup15 ztymvaariwup15}</td><td>（中継用）ＭＶＡ適用Ｗ（上昇）１５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaariwyentuktypeup15 ztymvaariwyentuktypeup15}</td><td>（中継用）ＭＶＡ適用Ｗ換算通貨タイプ（上昇）１５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaariwupyendaka15 ztymvaariwupyendaka15}</td><td>（中継用）ＭＶＡ適用Ｗ換算（上昇）円高１５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaariwupyenkijyun15 ztymvaariwupyenkijyun15}</td><td>（中継用）ＭＶＡ適用Ｗ換算（上昇）中央値１５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaariwupyenyasu15 ztymvaariwupyenyasu15}</td><td>（中継用）ＭＶＡ適用Ｗ換算（上昇）円安１５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaariwumupyendaka15 ztymvaariwumupyendaka15}</td><td>（中継用）ＭＶＡ適用Ｗ換算目標額到達有無（上昇）円高１５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaariumupyenkijyun15 ztymvaariumupyenkijyun15}</td><td>（中継用）ＭＶＡ適用Ｗ換算目標額到達有無（上昇）中央値１５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaariumupyenyasu15 ztymvaariumupyenyasu15}</td><td>（中継用）ＭＶＡ適用Ｗ換算目標額到達有無（上昇）円安１５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaariwtuktypesame15 ztymvaariwtuktypesame15}</td><td>（中継用）ＭＶＡ適用Ｗ通貨タイプ（同水準）１５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaariwsame15 ztymvaariwsame15}</td><td>（中継用）ＭＶＡ適用Ｗ（同水準）１５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaariwyentuktypesame15 ztymvaariwyentuktypesame15}</td><td>（中継用）ＭＶＡ適用Ｗ換算通貨タイプ（同水準）１５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaariwsameyendaka15 ztymvaariwsameyendaka15}</td><td>（中継用）ＭＶＡ適用Ｗ換算（同水準）円高１５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaariwsameyenkijyun15 ztymvaariwsameyenkijyun15}</td><td>（中継用）ＭＶＡ適用Ｗ換算（同水準）中央値１５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaariwsameyenyasu15 ztymvaariwsameyenyasu15}</td><td>（中継用）ＭＶＡ適用Ｗ換算（同水準）円安１５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaariumsameyendaka15 ztymvaariumsameyendaka15}</td><td>（中継用）ＭＶＡ適用Ｗ換算目標額到達有無（同水準）円高１５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaariumsameyenkijyun15 ztymvaariumsameyenkijyun15}</td><td>（中継用）ＭＶＡ適用Ｗ換算目標額到達有無（同水準）中央値１５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaariumsameyenyasu15 ztymvaariumsameyenyasu15}</td><td>（中継用）ＭＶＡ適用Ｗ換算目標額到達有無（同水準）円安１５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaariwtuktypedown15 ztymvaariwtuktypedown15}</td><td>（中継用）ＭＶＡ適用Ｗ通貨タイプ（低下）１５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaariwdown15 ztymvaariwdown15}</td><td>（中継用）ＭＶＡ適用Ｗ（低下）１５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaariwyentuktypedown15 ztymvaariwyentuktypedown15}</td><td>（中継用）ＭＶＡ適用Ｗ換算通貨タイプ（低下）１５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaariwdownyendaka15 ztymvaariwdownyendaka15}</td><td>（中継用）ＭＶＡ適用Ｗ換算（低下）円高１５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaariwdownyenkijyun15 ztymvaariwdownyenkijyun15}</td><td>（中継用）ＭＶＡ適用Ｗ換算（低下）中央値１５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaariwdownyenyasu15 ztymvaariwdownyenyasu15}</td><td>（中継用）ＭＶＡ適用Ｗ換算（低下）円安１５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaariumdownyendaka15 ztymvaariumdownyendaka15}</td><td>（中継用）ＭＶＡ適用Ｗ換算目標額到達有無（低下）円高１５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaariumdownyenkijyun15 ztymvaariumdownyenkijyun15}</td><td>（中継用）ＭＶＡ適用Ｗ換算目標額到達有無（低下）中央値１５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaariumdownyenyasu15 ztymvaariumdownyenyasu15}</td><td>（中継用）ＭＶＡ適用Ｗ換算目標額到達有無（低下）円安１５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaarivtuktype15 ztymvaarivtuktype15}</td><td>（中継用）ＭＶＡ適用保険料積立金額通貨タイプ１５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvaariv15 ztymvaariv15}</td><td>（中継用）ＭＶＡ適用保険料積立金額１５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvanonekaisiinnumukbn01 ztymvanonekaisiinnumukbn01}</td><td>（中継用）ＭＶＡ適用外開始印有無区分０１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvanonenenoutouym01 ztymvanonenenoutouym01}</td><td>（中継用）ＭＶＡ適用外年単位応当年月０１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvanonewtuktype01 ztymvanonewtuktype01}</td><td>（中継用）ＭＶＡ適用外Ｗ通貨タイプ０１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvanonew01 ztymvanonew01}</td><td>（中継用）ＭＶＡ適用外Ｗ０１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvanonewyentuktype01 ztymvanonewyentuktype01}</td><td>（中継用）ＭＶＡ適用外Ｗ換算通貨タイプ０１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvanonewyendaka01 ztymvanonewyendaka01}</td><td>（中継用）ＭＶＡ適用外Ｗ換算０１円高</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvanonewyenkijyun01 ztymvanonewyenkijyun01}</td><td>（中継用）ＭＶＡ適用外Ｗ換算０１中央値</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvanonewyenyasu01 ztymvanonewyenyasu01}</td><td>（中継用）ＭＶＡ適用外Ｗ換算０１円安</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvanoneumyendaka01 ztymvanoneumyendaka01}</td><td>（中継用）ＭＶＡ適用外Ｗ換算目標額到達有無円高０１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvanoneumyenkijyun01 ztymvanoneumyenkijyun01}</td><td>（中継用）ＭＶＡ適用外Ｗ換算目標額到達有無中央値０１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvanoneumyenyasu01 ztymvanoneumyenyasu01}</td><td>（中継用）ＭＶＡ適用外Ｗ換算目標額到達有無円安０１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvanonevtuktype01 ztymvanonevtuktype01}</td><td>（中継用）ＭＶＡ適用外保険料積立金額通貨タイプ０１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvanonev01 ztymvanonev01}</td><td>（中継用）ＭＶＡ適用外保険料積立金額０１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvanonekaisiinnumukbn02 ztymvanonekaisiinnumukbn02}</td><td>（中継用）ＭＶＡ適用外開始印有無区分０２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvanonenenoutouym02 ztymvanonenenoutouym02}</td><td>（中継用）ＭＶＡ適用外年単位応当年月０２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvanonewtuktype02 ztymvanonewtuktype02}</td><td>（中継用）ＭＶＡ適用外Ｗ通貨タイプ０２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvanonew02 ztymvanonew02}</td><td>（中継用）ＭＶＡ適用外Ｗ０２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvanonewyentuktype02 ztymvanonewyentuktype02}</td><td>（中継用）ＭＶＡ適用外Ｗ換算通貨タイプ０２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvanonewyendaka02 ztymvanonewyendaka02}</td><td>（中継用）ＭＶＡ適用外Ｗ換算０２円高</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvanonewyenkijyun02 ztymvanonewyenkijyun02}</td><td>（中継用）ＭＶＡ適用外Ｗ換算０２中央値</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvanonewyenyasu02 ztymvanonewyenyasu02}</td><td>（中継用）ＭＶＡ適用外Ｗ換算０２円安</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvanoneumyendaka02 ztymvanoneumyendaka02}</td><td>（中継用）ＭＶＡ適用外Ｗ換算目標額到達有無円高０２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvanoneumyenkijyun02 ztymvanoneumyenkijyun02}</td><td>（中継用）ＭＶＡ適用外Ｗ換算目標額到達有無中央値０２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvanoneumyenyasu02 ztymvanoneumyenyasu02}</td><td>（中継用）ＭＶＡ適用外Ｗ換算目標額到達有無円安０２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvanonevtuktype02 ztymvanonevtuktype02}</td><td>（中継用）ＭＶＡ適用外保険料積立金額通貨タイプ０２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvanonev02 ztymvanonev02}</td><td>（中継用）ＭＶＡ適用外保険料積立金額０２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvanonekaisiinnumukbn03 ztymvanonekaisiinnumukbn03}</td><td>（中継用）ＭＶＡ適用外開始印有無区分０３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvanonenenoutouym03 ztymvanonenenoutouym03}</td><td>（中継用）ＭＶＡ適用外年単位応当年月０３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvanonewtuktype03 ztymvanonewtuktype03}</td><td>（中継用）ＭＶＡ適用外Ｗ通貨タイプ０３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvanonew03 ztymvanonew03}</td><td>（中継用）ＭＶＡ適用外Ｗ０３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvanonewyentuktype03 ztymvanonewyentuktype03}</td><td>（中継用）ＭＶＡ適用外Ｗ換算通貨タイプ０３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvanonewyendaka03 ztymvanonewyendaka03}</td><td>（中継用）ＭＶＡ適用外Ｗ換算０３円高</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvanonewyenkijyun03 ztymvanonewyenkijyun03}</td><td>（中継用）ＭＶＡ適用外Ｗ換算０３中央値</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvanonewyenyasu03 ztymvanonewyenyasu03}</td><td>（中継用）ＭＶＡ適用外Ｗ換算０３円安</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvanoneumyendaka03 ztymvanoneumyendaka03}</td><td>（中継用）ＭＶＡ適用外Ｗ換算目標額到達有無円高０３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvanoneumyenkijyun03 ztymvanoneumyenkijyun03}</td><td>（中継用）ＭＶＡ適用外Ｗ換算目標額到達有無中央値０３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvanoneumyenyasu03 ztymvanoneumyenyasu03}</td><td>（中継用）ＭＶＡ適用外Ｗ換算目標額到達有無円安０３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvanonevtuktype03 ztymvanonevtuktype03}</td><td>（中継用）ＭＶＡ適用外保険料積立金額通貨タイプ０３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvanonev03 ztymvanonev03}</td><td>（中継用）ＭＶＡ適用外保険料積立金額０３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvanonekaisiinnumukbn04 ztymvanonekaisiinnumukbn04}</td><td>（中継用）ＭＶＡ適用外開始印有無区分０４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvanonenenoutouym04 ztymvanonenenoutouym04}</td><td>（中継用）ＭＶＡ適用外年単位応当年月０４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvanonewtuktype04 ztymvanonewtuktype04}</td><td>（中継用）ＭＶＡ適用外Ｗ通貨タイプ０４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvanonew04 ztymvanonew04}</td><td>（中継用）ＭＶＡ適用外Ｗ０４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvanonewyentuktype04 ztymvanonewyentuktype04}</td><td>（中継用）ＭＶＡ適用外Ｗ換算通貨タイプ０４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvanonewyendaka04 ztymvanonewyendaka04}</td><td>（中継用）ＭＶＡ適用外Ｗ換算０４円高</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvanonewyenkijyun04 ztymvanonewyenkijyun04}</td><td>（中継用）ＭＶＡ適用外Ｗ換算０４中央値</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvanonewyenyasu04 ztymvanonewyenyasu04}</td><td>（中継用）ＭＶＡ適用外Ｗ換算０４円安</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvanoneumyendaka04 ztymvanoneumyendaka04}</td><td>（中継用）ＭＶＡ適用外Ｗ換算目標額到達有無円高０４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvanoneumyenkijyun04 ztymvanoneumyenkijyun04}</td><td>（中継用）ＭＶＡ適用外Ｗ換算目標額到達有無中央値０４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvanoneumyenyasu04 ztymvanoneumyenyasu04}</td><td>（中継用）ＭＶＡ適用外Ｗ換算目標額到達有無円安０４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvanonevtuktype04 ztymvanonevtuktype04}</td><td>（中継用）ＭＶＡ適用外保険料積立金額通貨タイプ０４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvanonev04 ztymvanonev04}</td><td>（中継用）ＭＶＡ適用外保険料積立金額０４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvanonekaisiinnumukbn05 ztymvanonekaisiinnumukbn05}</td><td>（中継用）ＭＶＡ適用外開始印有無区分０５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvanonenenoutouym05 ztymvanonenenoutouym05}</td><td>（中継用）ＭＶＡ適用外年単位応当年月０５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvanonewtuktype05 ztymvanonewtuktype05}</td><td>（中継用）ＭＶＡ適用外Ｗ通貨タイプ０５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvanonew05 ztymvanonew05}</td><td>（中継用）ＭＶＡ適用外Ｗ０５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvanonewyentuktype05 ztymvanonewyentuktype05}</td><td>（中継用）ＭＶＡ適用外Ｗ換算通貨タイプ０５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvanonewyendaka05 ztymvanonewyendaka05}</td><td>（中継用）ＭＶＡ適用外Ｗ換算０５円高</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvanonewyenkijyun05 ztymvanonewyenkijyun05}</td><td>（中継用）ＭＶＡ適用外Ｗ換算０５中央値</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvanonewyenyasu05 ztymvanonewyenyasu05}</td><td>（中継用）ＭＶＡ適用外Ｗ換算０５円安</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvanoneumyendaka05 ztymvanoneumyendaka05}</td><td>（中継用）ＭＶＡ適用外Ｗ換算目標額到達有無円高０５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvanoneumyenkijyun05 ztymvanoneumyenkijyun05}</td><td>（中継用）ＭＶＡ適用外Ｗ換算目標額到達有無中央値０５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvanoneumyenyasu05 ztymvanoneumyenyasu05}</td><td>（中継用）ＭＶＡ適用外Ｗ換算目標額到達有無円安０５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvanonevtuktype05 ztymvanonevtuktype05}</td><td>（中継用）ＭＶＡ適用外保険料積立金額通貨タイプ０５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvanonev05 ztymvanonev05}</td><td>（中継用）ＭＶＡ適用外保険料積立金額０５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvanonekaisiinnumukbn06 ztymvanonekaisiinnumukbn06}</td><td>（中継用）ＭＶＡ適用外開始印有無区分０６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvanonenenoutouym06 ztymvanonenenoutouym06}</td><td>（中継用）ＭＶＡ適用外年単位応当年月０６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvanonewtuktype06 ztymvanonewtuktype06}</td><td>（中継用）ＭＶＡ適用外Ｗ通貨タイプ０６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvanonew06 ztymvanonew06}</td><td>（中継用）ＭＶＡ適用外Ｗ０６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvanonewyentuktype06 ztymvanonewyentuktype06}</td><td>（中継用）ＭＶＡ適用外Ｗ換算通貨タイプ０６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvanonewyendaka06 ztymvanonewyendaka06}</td><td>（中継用）ＭＶＡ適用外Ｗ換算０６円高</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvanonewyenkijyun06 ztymvanonewyenkijyun06}</td><td>（中継用）ＭＶＡ適用外Ｗ換算０６中央値</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvanonewyenyasu06 ztymvanonewyenyasu06}</td><td>（中継用）ＭＶＡ適用外Ｗ換算０６円安</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvanoneumyendaka06 ztymvanoneumyendaka06}</td><td>（中継用）ＭＶＡ適用外Ｗ換算目標額到達有無円高０６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvanoneumyenkijyun06 ztymvanoneumyenkijyun06}</td><td>（中継用）ＭＶＡ適用外Ｗ換算目標額到達有無中央値０６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvanoneumyenyasu06 ztymvanoneumyenyasu06}</td><td>（中継用）ＭＶＡ適用外Ｗ換算目標額到達有無円安０６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvanonevtuktype06 ztymvanonevtuktype06}</td><td>（中継用）ＭＶＡ適用外保険料積立金額通貨タイプ０６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvanonev06 ztymvanonev06}</td><td>（中継用）ＭＶＡ適用外保険料積立金額０６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvanonekaisiinnumukbn07 ztymvanonekaisiinnumukbn07}</td><td>（中継用）ＭＶＡ適用外開始印有無区分０７</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvanonenenoutouym07 ztymvanonenenoutouym07}</td><td>（中継用）ＭＶＡ適用外年単位応当年月０７</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvanonewtuktype07 ztymvanonewtuktype07}</td><td>（中継用）ＭＶＡ適用外Ｗ通貨タイプ０７</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvanonew07 ztymvanonew07}</td><td>（中継用）ＭＶＡ適用外Ｗ０７</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvanonewyentuktype07 ztymvanonewyentuktype07}</td><td>（中継用）ＭＶＡ適用外Ｗ換算通貨タイプ０７</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvanonewyendaka07 ztymvanonewyendaka07}</td><td>（中継用）ＭＶＡ適用外Ｗ換算０７円高</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvanonewyenkijyun07 ztymvanonewyenkijyun07}</td><td>（中継用）ＭＶＡ適用外Ｗ換算０７中央値</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvanonewyenyasu07 ztymvanonewyenyasu07}</td><td>（中継用）ＭＶＡ適用外Ｗ換算０７円安</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvanoneumyendaka07 ztymvanoneumyendaka07}</td><td>（中継用）ＭＶＡ適用外Ｗ換算目標額到達有無円高０７</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvanoneumyenkijyun07 ztymvanoneumyenkijyun07}</td><td>（中継用）ＭＶＡ適用外Ｗ換算目標額到達有無中央値０７</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvanoneumyenyasu07 ztymvanoneumyenyasu07}</td><td>（中継用）ＭＶＡ適用外Ｗ換算目標額到達有無円安０７</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvanonevtuktype07 ztymvanonevtuktype07}</td><td>（中継用）ＭＶＡ適用外保険料積立金額通貨タイプ０７</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvanonev07 ztymvanonev07}</td><td>（中継用）ＭＶＡ適用外保険料積立金額０７</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvanonekaisiinnumukbn08 ztymvanonekaisiinnumukbn08}</td><td>（中継用）ＭＶＡ適用外開始印有無区分０８</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvanonenenoutouym08 ztymvanonenenoutouym08}</td><td>（中継用）ＭＶＡ適用外年単位応当年月０８</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvanonewtuktype08 ztymvanonewtuktype08}</td><td>（中継用）ＭＶＡ適用外Ｗ通貨タイプ０８</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvanonew08 ztymvanonew08}</td><td>（中継用）ＭＶＡ適用外Ｗ０８</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvanonewyentuktype08 ztymvanonewyentuktype08}</td><td>（中継用）ＭＶＡ適用外Ｗ換算通貨タイプ０８</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvanonewyendaka08 ztymvanonewyendaka08}</td><td>（中継用）ＭＶＡ適用外Ｗ換算０８円高</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvanonewyenkijyun08 ztymvanonewyenkijyun08}</td><td>（中継用）ＭＶＡ適用外Ｗ換算０８中央値</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvanonewyenyasu08 ztymvanonewyenyasu08}</td><td>（中継用）ＭＶＡ適用外Ｗ換算０８円安</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvanoneumyendaka08 ztymvanoneumyendaka08}</td><td>（中継用）ＭＶＡ適用外Ｗ換算目標額到達有無円高０８</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvanoneumyenkijyun08 ztymvanoneumyenkijyun08}</td><td>（中継用）ＭＶＡ適用外Ｗ換算目標額到達有無中央値０８</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvanoneumyenyasu08 ztymvanoneumyenyasu08}</td><td>（中継用）ＭＶＡ適用外Ｗ換算目標額到達有無円安０８</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvanonevtuktype08 ztymvanonevtuktype08}</td><td>（中継用）ＭＶＡ適用外保険料積立金額通貨タイプ０８</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvanonev08 ztymvanonev08}</td><td>（中継用）ＭＶＡ適用外保険料積立金額０８</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvanonekaisiinnumukbn09 ztymvanonekaisiinnumukbn09}</td><td>（中継用）ＭＶＡ適用外開始印有無区分０９</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvanonenenoutouym09 ztymvanonenenoutouym09}</td><td>（中継用）ＭＶＡ適用外年単位応当年月０９</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvanonewtuktype09 ztymvanonewtuktype09}</td><td>（中継用）ＭＶＡ適用外Ｗ通貨タイプ０９</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvanonew09 ztymvanonew09}</td><td>（中継用）ＭＶＡ適用外Ｗ０９</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvanonewyentuktype09 ztymvanonewyentuktype09}</td><td>（中継用）ＭＶＡ適用外Ｗ換算通貨タイプ０９</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvanonewyendaka09 ztymvanonewyendaka09}</td><td>（中継用）ＭＶＡ適用外Ｗ換算０９円高</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvanonewyenkijyun09 ztymvanonewyenkijyun09}</td><td>（中継用）ＭＶＡ適用外Ｗ換算０９中央値</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvanonewyenyasu09 ztymvanonewyenyasu09}</td><td>（中継用）ＭＶＡ適用外Ｗ換算０９円安</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvanoneumyendaka09 ztymvanoneumyendaka09}</td><td>（中継用）ＭＶＡ適用外Ｗ換算目標額到達有無円高０９</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvanoneumyenkijyun09 ztymvanoneumyenkijyun09}</td><td>（中継用）ＭＶＡ適用外Ｗ換算目標額到達有無中央値０９</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvanoneumyenyasu09 ztymvanoneumyenyasu09}</td><td>（中継用）ＭＶＡ適用外Ｗ換算目標額到達有無円安０９</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvanonevtuktype09 ztymvanonevtuktype09}</td><td>（中継用）ＭＶＡ適用外保険料積立金額通貨タイプ０９</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvanonev09 ztymvanonev09}</td><td>（中継用）ＭＶＡ適用外保険料積立金額０９</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvanonekaisiinnumukbn10 ztymvanonekaisiinnumukbn10}</td><td>（中継用）ＭＶＡ適用外開始印有無区分１０</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvanonenenoutouym10 ztymvanonenenoutouym10}</td><td>（中継用）ＭＶＡ適用外年単位応当年月１０</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvanonewtuktype10 ztymvanonewtuktype10}</td><td>（中継用）ＭＶＡ適用外Ｗ通貨タイプ１０</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvanonew10 ztymvanonew10}</td><td>（中継用）ＭＶＡ適用外Ｗ１０</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvanonewyentuktype10 ztymvanonewyentuktype10}</td><td>（中継用）ＭＶＡ適用外Ｗ換算通貨タイプ１０</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvanonewyendaka10 ztymvanonewyendaka10}</td><td>（中継用）ＭＶＡ適用外Ｗ換算１０円高</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvanonewyenkijyun10 ztymvanonewyenkijyun10}</td><td>（中継用）ＭＶＡ適用外Ｗ換算１０中央値</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvanonewyenyasu10 ztymvanonewyenyasu10}</td><td>（中継用）ＭＶＡ適用外Ｗ換算１０円安</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvanoneumyendaka10 ztymvanoneumyendaka10}</td><td>（中継用）ＭＶＡ適用外Ｗ換算目標額到達有無円高１０</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvanoneumyenkijyun10 ztymvanoneumyenkijyun10}</td><td>（中継用）ＭＶＡ適用外Ｗ換算目標額到達有無中央値１０</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvanoneumyenyasu10 ztymvanoneumyenyasu10}</td><td>（中継用）ＭＶＡ適用外Ｗ換算目標額到達有無円安１０</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvanonevtuktype10 ztymvanonevtuktype10}</td><td>（中継用）ＭＶＡ適用外保険料積立金額通貨タイプ１０</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvanonev10 ztymvanonev10}</td><td>（中継用）ＭＶＡ適用外保険料積立金額１０</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvanonekaisiinnumukbn11 ztymvanonekaisiinnumukbn11}</td><td>（中継用）ＭＶＡ適用外開始印有無区分１１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvanonenenoutouym11 ztymvanonenenoutouym11}</td><td>（中継用）ＭＶＡ適用外年単位応当年月１１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvanonewtuktype11 ztymvanonewtuktype11}</td><td>（中継用）ＭＶＡ適用外Ｗ通貨タイプ１１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvanonew11 ztymvanonew11}</td><td>（中継用）ＭＶＡ適用外Ｗ１１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvanonewyentuktype11 ztymvanonewyentuktype11}</td><td>（中継用）ＭＶＡ適用外Ｗ換算通貨タイプ１１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvanonewyendaka11 ztymvanonewyendaka11}</td><td>（中継用）ＭＶＡ適用外Ｗ換算１１円高</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvanonewyenkijyun11 ztymvanonewyenkijyun11}</td><td>（中継用）ＭＶＡ適用外Ｗ換算１１中央値</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvanonewyenyasu11 ztymvanonewyenyasu11}</td><td>（中継用）ＭＶＡ適用外Ｗ換算１１円安</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvanoneumyendaka11 ztymvanoneumyendaka11}</td><td>（中継用）ＭＶＡ適用外Ｗ換算目標額到達有無円高１１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvanoneumyenkijyun11 ztymvanoneumyenkijyun11}</td><td>（中継用）ＭＶＡ適用外Ｗ換算目標額到達有無中央値１１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvanoneumyenyasu11 ztymvanoneumyenyasu11}</td><td>（中継用）ＭＶＡ適用外Ｗ換算目標額到達有無円安１１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvanonevtuktype11 ztymvanonevtuktype11}</td><td>（中継用）ＭＶＡ適用外保険料積立金額通貨タイプ１１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvanonev11 ztymvanonev11}</td><td>（中継用）ＭＶＡ適用外保険料積立金額１１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvanonekaisiinnumukbn12 ztymvanonekaisiinnumukbn12}</td><td>（中継用）ＭＶＡ適用外開始印有無区分１２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvanonenenoutouym12 ztymvanonenenoutouym12}</td><td>（中継用）ＭＶＡ適用外年単位応当年月１２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvanonewtuktype12 ztymvanonewtuktype12}</td><td>（中継用）ＭＶＡ適用外Ｗ通貨タイプ１２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvanonew12 ztymvanonew12}</td><td>（中継用）ＭＶＡ適用外Ｗ１２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvanonewyentuktype12 ztymvanonewyentuktype12}</td><td>（中継用）ＭＶＡ適用外Ｗ換算通貨タイプ１２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvanonewyendaka12 ztymvanonewyendaka12}</td><td>（中継用）ＭＶＡ適用外Ｗ換算１２円高</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvanonewyenkijyun12 ztymvanonewyenkijyun12}</td><td>（中継用）ＭＶＡ適用外Ｗ換算１２中央値</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvanonewyenyasu12 ztymvanonewyenyasu12}</td><td>（中継用）ＭＶＡ適用外Ｗ換算１２円安</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvanoneumyendaka12 ztymvanoneumyendaka12}</td><td>（中継用）ＭＶＡ適用外Ｗ換算目標額到達有無円高１２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvanoneumyenkijyun12 ztymvanoneumyenkijyun12}</td><td>（中継用）ＭＶＡ適用外Ｗ換算目標額到達有無中央値１２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvanoneumyenyasu12 ztymvanoneumyenyasu12}</td><td>（中継用）ＭＶＡ適用外Ｗ換算目標額到達有無円安１２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvanonevtuktype12 ztymvanonevtuktype12}</td><td>（中継用）ＭＶＡ適用外保険料積立金額通貨タイプ１２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvanonev12 ztymvanonev12}</td><td>（中継用）ＭＶＡ適用外保険料積立金額１２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvanonekaisiinnumukbn13 ztymvanonekaisiinnumukbn13}</td><td>（中継用）ＭＶＡ適用外開始印有無区分１３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvanonenenoutouym13 ztymvanonenenoutouym13}</td><td>（中継用）ＭＶＡ適用外年単位応当年月１３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvanonewtuktype13 ztymvanonewtuktype13}</td><td>（中継用）ＭＶＡ適用外Ｗ通貨タイプ１３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvanonew13 ztymvanonew13}</td><td>（中継用）ＭＶＡ適用外Ｗ１３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvanonewyentuktype13 ztymvanonewyentuktype13}</td><td>（中継用）ＭＶＡ適用外Ｗ換算通貨タイプ１３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvanonewyendaka13 ztymvanonewyendaka13}</td><td>（中継用）ＭＶＡ適用外Ｗ換算１３円高</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvanonewyenkijyun13 ztymvanonewyenkijyun13}</td><td>（中継用）ＭＶＡ適用外Ｗ換算１３中央値</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvanonewyenyasu13 ztymvanonewyenyasu13}</td><td>（中継用）ＭＶＡ適用外Ｗ換算１３円安</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvanoneumyendaka13 ztymvanoneumyendaka13}</td><td>（中継用）ＭＶＡ適用外Ｗ換算目標額到達有無円高１３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvanoneumyenkijyun13 ztymvanoneumyenkijyun13}</td><td>（中継用）ＭＶＡ適用外Ｗ換算目標額到達有無中央値１３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvanoneumyenyasu13 ztymvanoneumyenyasu13}</td><td>（中継用）ＭＶＡ適用外Ｗ換算目標額到達有無円安１３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvanonevtuktype13 ztymvanonevtuktype13}</td><td>（中継用）ＭＶＡ適用外保険料積立金額通貨タイプ１３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvanonev13 ztymvanonev13}</td><td>（中継用）ＭＶＡ適用外保険料積立金額１３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvanonekaisiinnumukbn14 ztymvanonekaisiinnumukbn14}</td><td>（中継用）ＭＶＡ適用外開始印有無区分１４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvanonenenoutouym14 ztymvanonenenoutouym14}</td><td>（中継用）ＭＶＡ適用外年単位応当年月１４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvanonewtuktype14 ztymvanonewtuktype14}</td><td>（中継用）ＭＶＡ適用外Ｗ通貨タイプ１４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvanonew14 ztymvanonew14}</td><td>（中継用）ＭＶＡ適用外Ｗ１４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvanonewyentuktype14 ztymvanonewyentuktype14}</td><td>（中継用）ＭＶＡ適用外Ｗ換算通貨タイプ１４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvanonewyendaka14 ztymvanonewyendaka14}</td><td>（中継用）ＭＶＡ適用外Ｗ換算１４円高</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvanonewyenkijyun14 ztymvanonewyenkijyun14}</td><td>（中継用）ＭＶＡ適用外Ｗ換算１４中央値</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvanonewyenyasu14 ztymvanonewyenyasu14}</td><td>（中継用）ＭＶＡ適用外Ｗ換算１４円安</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvanoneumyendaka14 ztymvanoneumyendaka14}</td><td>（中継用）ＭＶＡ適用外Ｗ換算目標額到達有無円高１４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvanoneumyenkijyun14 ztymvanoneumyenkijyun14}</td><td>（中継用）ＭＶＡ適用外Ｗ換算目標額到達有無中央値１４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvanoneumyenyasu14 ztymvanoneumyenyasu14}</td><td>（中継用）ＭＶＡ適用外Ｗ換算目標額到達有無円安１４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvanonevtuktype14 ztymvanonevtuktype14}</td><td>（中継用）ＭＶＡ適用外保険料積立金額通貨タイプ１４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvanonev14 ztymvanonev14}</td><td>（中継用）ＭＶＡ適用外保険料積立金額１４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtywmsgcd1 ztywmsgcd1}</td><td>（中継用）解約返戻金メッセージコード１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtywmsgcd2 ztywmsgcd2}</td><td>（中継用）解約返戻金メッセージコード２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtywmsgcd3 ztywmsgcd3}</td><td>（中継用）解約返戻金メッセージコード３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtywmsgcd21 ztywmsgcd21}</td><td>（中継用）解約返戻金メッセージコード２＿１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtywmsgcd22 ztywmsgcd22}</td><td>（中継用）解約返戻金メッセージコード２＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtywmsgcd23 ztywmsgcd23}</td><td>（中継用）解約返戻金メッセージコード２＿３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtywmsgcd31 ztywmsgcd31}</td><td>（中継用）解約返戻金メッセージコード３＿１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtywmsgcd32 ztywmsgcd32}</td><td>（中継用）解約返戻金メッセージコード３＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtywmsgcd33 ztywmsgcd33}</td><td>（中継用）解約返戻金メッセージコード３＿３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtywmsgcdst1 ztywmsgcdst1}</td><td>（中継用）解約返戻金メッセージコード表下１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtywtyuuimsgcd1 ztywtyuuimsgcd1}</td><td>（中継用）解約返戻金注意事項メッセージコード１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtywtyuuimsgcd2 ztywtyuuimsgcd2}</td><td>（中継用）解約返戻金注意事項メッセージコード２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtywtyuuimsgcd3 ztywtyuuimsgcd3}</td><td>（中継用）解約返戻金注意事項メッセージコード３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtywtyuuimsgcd4 ztywtyuuimsgcd4}</td><td>（中継用）解約返戻金注意事項メッセージコード４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtywtyuuimsgcd5 ztywtyuuimsgcd5}</td><td>（中継用）解約返戻金注意事項メッセージコード５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtywtyuuimsgcd6 ztywtyuuimsgcd6}</td><td>（中継用）解約返戻金注意事項メッセージコード６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtywtyuuimsgcd7 ztywtyuuimsgcd7}</td><td>（中継用）解約返戻金注意事項メッセージコード７</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtywitjbrptuuktype ztywitjbrptuuktype}</td><td>（中継用）解約返戻金一時払保険料通貨タイプ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtywitjbrp ztywitjbrp}</td><td>（中継用）解約返戻金一時払保険料</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtywyenhrikmgktuuktype ztywyenhrikmgktuuktype}</td><td>（中継用）解約返戻金円貨払込額通貨タイプ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtywyenhrikmgk ztywyenhrikmgk}</td><td>（中継用）解約返戻金円貨払込額</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtywyenitjbrptuuktype ztywyenitjbrptuuktype}</td><td>（中継用）解約返戻金円換算一時払保険料通貨タイプ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtywyenitjbrp ztywyenitjbrp}</td><td>（中継用）解約返戻金円換算一時払保険料</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtywsjkkktyouseitkyuym ztywsjkkktyouseitkyuym}</td><td>（中継用）解約返戻金市場価格調整適用年月</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhrkkknmnryym ztyhrkkknmnryym}</td><td>（中継用）払込期間満了年月</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhrkkknmnrynen ztyhrkkknmnrynen}</td><td>（中継用）払込期間満了年齢</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv200 ztyyobiv200}</td><td>（中継用）予備項目Ｖ２００</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv49 ztyyobiv49}</td><td>（中継用）予備項目Ｖ４９</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     ZT_SaihakkouSyoukenSuiiTy
 * @see     PKZT_SaihakkouSyoukenSuiiTy
 * @see     QZT_SaihakkouSyoukenSuiiTy
 * @see     GenQZT_SaihakkouSyoukenSuiiTy
 */
@MappedSuperclass
@Table(name=GenZT_SaihakkouSyoukenSuiiTy.TABLE_NAME)
@IdClass(value=PKZT_SaihakkouSyoukenSuiiTy.class)
public abstract class GenZT_SaihakkouSyoukenSuiiTy extends AbstractExDBEntity<ZT_SaihakkouSyoukenSuiiTy, PKZT_SaihakkouSyoukenSuiiTy> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "ZT_SaihakkouSyoukenSuiiTy";
    public static final String ZTYSYONO                 = "ztysyono";
    public static final String ZTYTYOUHYOUYMD           = "ztytyouhyouymd";
    public static final String ZTYSUIIHYOUPTN           = "ztysuiihyouptn";
    public static final String ZTYSUIIHYOUSYKBN         = "ztysuiihyousykbn";
    public static final String ZTYSUIIHYOUSYONO         = "ztysuiihyousyono";
    public static final String ZTYSISUUUPRITU           = "ztysisuuupritu";
    public static final String ZTYSAISYUUNNDYM          = "ztysaisyuunndym";
    public static final String ZTYSJKKKTUSIRRTUP        = "ztysjkkktusirrtup";
    public static final String ZTYSJKKKTUSIRRTSAME      = "ztysjkkktusirrtsame";
    public static final String ZTYSJKKKTUSIRRTDOWN      = "ztysjkkktusirrtdown";
    public static final String ZTYSJKKKTUSIRRTHENDOUUP  = "ztysjkkktusirrthendouup";
    public static final String ZTYSJKKKTUSIRRTHENDOUDOWN = "ztysjkkktusirrthendoudown";
    public static final String ZTYWKWSRATEYENDAKA       = "ztywkwsrateyendaka";
    public static final String ZTYWKWSRATEYENKIJYUN     = "ztywkwsrateyenkijyun";
    public static final String ZTYWKWSRATEYENYASU       = "ztywkwsrateyenyasu";
    public static final String ZTYSUIIHYOUMKHYOUYENWRA  = "ztysuiihyoumkhyouyenwra";
    public static final String ZTYMVAARINENOUTOUYM01    = "ztymvaarinenoutouym01";
    public static final String ZTYMVAARISISUUUPRITU01   = "ztymvaarisisuuupritu01";
    public static final String ZTYMVAARITMTTKNZKRITU01  = "ztymvaaritmttknzkritu01";
    public static final String ZTYMVAARIWTUKTYPEUP01    = "ztymvaariwtuktypeup01";
    public static final String ZTYMVAARITMTTKNKYKKJMUP01 = "ztymvaaritmttknkykkjmup01";
    public static final String ZTYMVAARIWUP01           = "ztymvaariwup01";
    public static final String ZTYMVAARIWYENTUKTYPEUP01 = "ztymvaariwyentuktypeup01";
    public static final String ZTYMVAARIWUPYENDAKA01    = "ztymvaariwupyendaka01";
    public static final String ZTYMVAARIWUPYENKIJYUN01  = "ztymvaariwupyenkijyun01";
    public static final String ZTYMVAARIWUPYENYASU01    = "ztymvaariwupyenyasu01";
    public static final String ZTYMVAARIWUMUPYENDAKA01  = "ztymvaariwumupyendaka01";
    public static final String ZTYMVAARIUMUPYENKIJYUN01 = "ztymvaariumupyenkijyun01";
    public static final String ZTYMVAARIUMUPYENYASU01   = "ztymvaariumupyenyasu01";
    public static final String ZTYMVAARIWTUKTYPESAME01  = "ztymvaariwtuktypesame01";
    public static final String ZTYMVAARITMTTKNKYKKJMSAME01 = "ztymvaaritmttknkykkjmsame01";
    public static final String ZTYMVAARIWSAME01         = "ztymvaariwsame01";
    public static final String ZTYMVAARIWYENTUKTYPESAME01 = "ztymvaariwyentuktypesame01";
    public static final String ZTYMVAARIWSAMEYENDAKA01  = "ztymvaariwsameyendaka01";
    public static final String ZTYMVAARIWSAMEYENKIJYUN01 = "ztymvaariwsameyenkijyun01";
    public static final String ZTYMVAARIWSAMEYENYASU01  = "ztymvaariwsameyenyasu01";
    public static final String ZTYMVAARIUMSAMEYENDAKA01 = "ztymvaariumsameyendaka01";
    public static final String ZTYMVAARIUMSAMEYENKIJYUN01 = "ztymvaariumsameyenkijyun01";
    public static final String ZTYMVAARIUMSAMEYENYASU01 = "ztymvaariumsameyenyasu01";
    public static final String ZTYMVAARIWTUKTYPEDOWN01  = "ztymvaariwtuktypedown01";
    public static final String ZTYMVAARITMTTKNKYKKJMDOWN01 = "ztymvaaritmttknkykkjmdown01";
    public static final String ZTYMVAARIWDOWN01         = "ztymvaariwdown01";
    public static final String ZTYMVAARIWYENTUKTYPEDOWN01 = "ztymvaariwyentuktypedown01";
    public static final String ZTYMVAARIWDOWNYENDAKA01  = "ztymvaariwdownyendaka01";
    public static final String ZTYMVAARIWDOWNYENKIJYUN01 = "ztymvaariwdownyenkijyun01";
    public static final String ZTYMVAARIWDOWNYENYASU01  = "ztymvaariwdownyenyasu01";
    public static final String ZTYMVAARIUMDOWNYENDAKA01 = "ztymvaariumdownyendaka01";
    public static final String ZTYMVAARIUMDOWNYENKIJYUN01 = "ztymvaariumdownyenkijyun01";
    public static final String ZTYMVAARIUMDOWNYENYASU01 = "ztymvaariumdownyenyasu01";
    public static final String ZTYMVAARIVTUKTYPE01      = "ztymvaarivtuktype01";
    public static final String ZTYMVAARIV01             = "ztymvaariv01";
    public static final String ZTYPTMTTKNGKUTIWAKE101   = "ztyptmttkngkutiwake101";
    public static final String ZTYPTMTTKNGKUTIWAKE201   = "ztyptmttkngkutiwake201";
    public static final String ZTYMVAARINENOUTOUYM02    = "ztymvaarinenoutouym02";
    public static final String ZTYMVAARISISUUUPRITU02   = "ztymvaarisisuuupritu02";
    public static final String ZTYMVAARITMTTKNZKRITU02  = "ztymvaaritmttknzkritu02";
    public static final String ZTYMVAARIWTUKTYPEUP02    = "ztymvaariwtuktypeup02";
    public static final String ZTYMVAARITMTTKNKYKKJMUP02 = "ztymvaaritmttknkykkjmup02";
    public static final String ZTYMVAARIWUP02           = "ztymvaariwup02";
    public static final String ZTYMVAARIWYENTUKTYPEUP02 = "ztymvaariwyentuktypeup02";
    public static final String ZTYMVAARIWUPYENDAKA02    = "ztymvaariwupyendaka02";
    public static final String ZTYMVAARIWUPYENKIJYUN02  = "ztymvaariwupyenkijyun02";
    public static final String ZTYMVAARIWUPYENYASU02    = "ztymvaariwupyenyasu02";
    public static final String ZTYMVAARIWUMUPYENDAKA02  = "ztymvaariwumupyendaka02";
    public static final String ZTYMVAARIUMUPYENKIJYUN02 = "ztymvaariumupyenkijyun02";
    public static final String ZTYMVAARIUMUPYENYASU02   = "ztymvaariumupyenyasu02";
    public static final String ZTYMVAARIWTUKTYPESAME02  = "ztymvaariwtuktypesame02";
    public static final String ZTYMVAARITMTTKNKYKKJMSAME02 = "ztymvaaritmttknkykkjmsame02";
    public static final String ZTYMVAARIWSAME02         = "ztymvaariwsame02";
    public static final String ZTYMVAARIWYENTUKTYPESAME02 = "ztymvaariwyentuktypesame02";
    public static final String ZTYMVAARIWSAMEYENDAKA02  = "ztymvaariwsameyendaka02";
    public static final String ZTYMVAARIWSAMEYENKIJYUN02 = "ztymvaariwsameyenkijyun02";
    public static final String ZTYMVAARIWSAMEYENYASU02  = "ztymvaariwsameyenyasu02";
    public static final String ZTYMVAARIUMSAMEYENDAKA02 = "ztymvaariumsameyendaka02";
    public static final String ZTYMVAARIUMSAMEYENKIJYUN02 = "ztymvaariumsameyenkijyun02";
    public static final String ZTYMVAARIUMSAMEYENYASU02 = "ztymvaariumsameyenyasu02";
    public static final String ZTYMVAARIWTUKTYPEDOWN02  = "ztymvaariwtuktypedown02";
    public static final String ZTYMVAARITMTTKNKYKKJMDOWN02 = "ztymvaaritmttknkykkjmdown02";
    public static final String ZTYMVAARIWDOWN02         = "ztymvaariwdown02";
    public static final String ZTYMVAARIWYENTUKTYPEDOWN02 = "ztymvaariwyentuktypedown02";
    public static final String ZTYMVAARIWDOWNYENDAKA02  = "ztymvaariwdownyendaka02";
    public static final String ZTYMVAARIWDOWNYENKIJYUN02 = "ztymvaariwdownyenkijyun02";
    public static final String ZTYMVAARIWDOWNYENYASU02  = "ztymvaariwdownyenyasu02";
    public static final String ZTYMVAARIUMDOWNYENDAKA02 = "ztymvaariumdownyendaka02";
    public static final String ZTYMVAARIUMDOWNYENKIJYUN02 = "ztymvaariumdownyenkijyun02";
    public static final String ZTYMVAARIUMDOWNYENYASU02 = "ztymvaariumdownyenyasu02";
    public static final String ZTYMVAARIVTUKTYPE02      = "ztymvaarivtuktype02";
    public static final String ZTYMVAARIV02             = "ztymvaariv02";
    public static final String ZTYPTMTTKNGKUTIWAKE102   = "ztyptmttkngkutiwake102";
    public static final String ZTYPTMTTKNGKUTIWAKE202   = "ztyptmttkngkutiwake202";
    public static final String ZTYMVAARINENOUTOUYM03    = "ztymvaarinenoutouym03";
    public static final String ZTYMVAARISISUUUPRITU03   = "ztymvaarisisuuupritu03";
    public static final String ZTYMVAARITMTTKNZKRITU03  = "ztymvaaritmttknzkritu03";
    public static final String ZTYMVAARIWTUKTYPEUP03    = "ztymvaariwtuktypeup03";
    public static final String ZTYMVAARITMTTKNKYKKJMUP03 = "ztymvaaritmttknkykkjmup03";
    public static final String ZTYMVAARIWUP03           = "ztymvaariwup03";
    public static final String ZTYMVAARIWYENTUKTYPEUP03 = "ztymvaariwyentuktypeup03";
    public static final String ZTYMVAARIWUPYENDAKA03    = "ztymvaariwupyendaka03";
    public static final String ZTYMVAARIWUPYENKIJYUN03  = "ztymvaariwupyenkijyun03";
    public static final String ZTYMVAARIWUPYENYASU03    = "ztymvaariwupyenyasu03";
    public static final String ZTYMVAARIWUMUPYENDAKA03  = "ztymvaariwumupyendaka03";
    public static final String ZTYMVAARIUMUPYENKIJYUN03 = "ztymvaariumupyenkijyun03";
    public static final String ZTYMVAARIUMUPYENYASU03   = "ztymvaariumupyenyasu03";
    public static final String ZTYMVAARIWTUKTYPESAME03  = "ztymvaariwtuktypesame03";
    public static final String ZTYMVAARITMTTKNKYKKJMSAME03 = "ztymvaaritmttknkykkjmsame03";
    public static final String ZTYMVAARIWSAME03         = "ztymvaariwsame03";
    public static final String ZTYMVAARIWYENTUKTYPESAME03 = "ztymvaariwyentuktypesame03";
    public static final String ZTYMVAARIWSAMEYENDAKA03  = "ztymvaariwsameyendaka03";
    public static final String ZTYMVAARIWSAMEYENKIJYUN03 = "ztymvaariwsameyenkijyun03";
    public static final String ZTYMVAARIWSAMEYENYASU03  = "ztymvaariwsameyenyasu03";
    public static final String ZTYMVAARIUMSAMEYENDAKA03 = "ztymvaariumsameyendaka03";
    public static final String ZTYMVAARIUMSAMEYENKIJYUN03 = "ztymvaariumsameyenkijyun03";
    public static final String ZTYMVAARIUMSAMEYENYASU03 = "ztymvaariumsameyenyasu03";
    public static final String ZTYMVAARIWTUKTYPEDOWN03  = "ztymvaariwtuktypedown03";
    public static final String ZTYMVAARITMTTKNKYKKJMDOWN03 = "ztymvaaritmttknkykkjmdown03";
    public static final String ZTYMVAARIWDOWN03         = "ztymvaariwdown03";
    public static final String ZTYMVAARIWYENTUKTYPEDOWN03 = "ztymvaariwyentuktypedown03";
    public static final String ZTYMVAARIWDOWNYENDAKA03  = "ztymvaariwdownyendaka03";
    public static final String ZTYMVAARIWDOWNYENKIJYUN03 = "ztymvaariwdownyenkijyun03";
    public static final String ZTYMVAARIWDOWNYENYASU03  = "ztymvaariwdownyenyasu03";
    public static final String ZTYMVAARIUMDOWNYENDAKA03 = "ztymvaariumdownyendaka03";
    public static final String ZTYMVAARIUMDOWNYENKIJYUN03 = "ztymvaariumdownyenkijyun03";
    public static final String ZTYMVAARIUMDOWNYENYASU03 = "ztymvaariumdownyenyasu03";
    public static final String ZTYMVAARIVTUKTYPE03      = "ztymvaarivtuktype03";
    public static final String ZTYMVAARIV03             = "ztymvaariv03";
    public static final String ZTYPTMTTKNGKUTIWAKE103   = "ztyptmttkngkutiwake103";
    public static final String ZTYPTMTTKNGKUTIWAKE203   = "ztyptmttkngkutiwake203";
    public static final String ZTYMVAARINENOUTOUYM04    = "ztymvaarinenoutouym04";
    public static final String ZTYMVAARISISUUUPRITU04   = "ztymvaarisisuuupritu04";
    public static final String ZTYMVAARITMTTKNZKRITU04  = "ztymvaaritmttknzkritu04";
    public static final String ZTYMVAARIWTUKTYPEUP04    = "ztymvaariwtuktypeup04";
    public static final String ZTYMVAARITMTTKNKYKKJMUP04 = "ztymvaaritmttknkykkjmup04";
    public static final String ZTYMVAARIWUP04           = "ztymvaariwup04";
    public static final String ZTYMVAARIWYENTUKTYPEUP04 = "ztymvaariwyentuktypeup04";
    public static final String ZTYMVAARIWUPYENDAKA04    = "ztymvaariwupyendaka04";
    public static final String ZTYMVAARIWUPYENKIJYUN04  = "ztymvaariwupyenkijyun04";
    public static final String ZTYMVAARIWUPYENYASU04    = "ztymvaariwupyenyasu04";
    public static final String ZTYMVAARIWUMUPYENDAKA04  = "ztymvaariwumupyendaka04";
    public static final String ZTYMVAARIUMUPYENKIJYUN04 = "ztymvaariumupyenkijyun04";
    public static final String ZTYMVAARIUMUPYENYASU04   = "ztymvaariumupyenyasu04";
    public static final String ZTYMVAARIWTUKTYPESAME04  = "ztymvaariwtuktypesame04";
    public static final String ZTYMVAARITMTTKNKYKKJMSAME04 = "ztymvaaritmttknkykkjmsame04";
    public static final String ZTYMVAARIWSAME04         = "ztymvaariwsame04";
    public static final String ZTYMVAARIWYENTUKTYPESAME04 = "ztymvaariwyentuktypesame04";
    public static final String ZTYMVAARIWSAMEYENDAKA04  = "ztymvaariwsameyendaka04";
    public static final String ZTYMVAARIWSAMEYENKIJYUN04 = "ztymvaariwsameyenkijyun04";
    public static final String ZTYMVAARIWSAMEYENYASU04  = "ztymvaariwsameyenyasu04";
    public static final String ZTYMVAARIUMSAMEYENDAKA04 = "ztymvaariumsameyendaka04";
    public static final String ZTYMVAARIUMSAMEYENKIJYUN04 = "ztymvaariumsameyenkijyun04";
    public static final String ZTYMVAARIUMSAMEYENYASU04 = "ztymvaariumsameyenyasu04";
    public static final String ZTYMVAARIWTUKTYPEDOWN04  = "ztymvaariwtuktypedown04";
    public static final String ZTYMVAARITMTTKNKYKKJMDOWN04 = "ztymvaaritmttknkykkjmdown04";
    public static final String ZTYMVAARIWDOWN04         = "ztymvaariwdown04";
    public static final String ZTYMVAARIWYENTUKTYPEDOWN04 = "ztymvaariwyentuktypedown04";
    public static final String ZTYMVAARIWDOWNYENDAKA04  = "ztymvaariwdownyendaka04";
    public static final String ZTYMVAARIWDOWNYENKIJYUN04 = "ztymvaariwdownyenkijyun04";
    public static final String ZTYMVAARIWDOWNYENYASU04  = "ztymvaariwdownyenyasu04";
    public static final String ZTYMVAARIUMDOWNYENDAKA04 = "ztymvaariumdownyendaka04";
    public static final String ZTYMVAARIUMDOWNYENKIJYUN04 = "ztymvaariumdownyenkijyun04";
    public static final String ZTYMVAARIUMDOWNYENYASU04 = "ztymvaariumdownyenyasu04";
    public static final String ZTYMVAARIVTUKTYPE04      = "ztymvaarivtuktype04";
    public static final String ZTYMVAARIV04             = "ztymvaariv04";
    public static final String ZTYPTMTTKNGKUTIWAKE104   = "ztyptmttkngkutiwake104";
    public static final String ZTYPTMTTKNGKUTIWAKE204   = "ztyptmttkngkutiwake204";
    public static final String ZTYMVAARINENOUTOUYM05    = "ztymvaarinenoutouym05";
    public static final String ZTYMVAARISISUUUPRITU05   = "ztymvaarisisuuupritu05";
    public static final String ZTYMVAARITMTTKNZKRITU05  = "ztymvaaritmttknzkritu05";
    public static final String ZTYMVAARIWTUKTYPEUP05    = "ztymvaariwtuktypeup05";
    public static final String ZTYMVAARITMTTKNKYKKJMUP05 = "ztymvaaritmttknkykkjmup05";
    public static final String ZTYMVAARIWUP05           = "ztymvaariwup05";
    public static final String ZTYMVAARIWYENTUKTYPEUP05 = "ztymvaariwyentuktypeup05";
    public static final String ZTYMVAARIWUPYENDAKA05    = "ztymvaariwupyendaka05";
    public static final String ZTYMVAARIWUPYENKIJYUN05  = "ztymvaariwupyenkijyun05";
    public static final String ZTYMVAARIWUPYENYASU05    = "ztymvaariwupyenyasu05";
    public static final String ZTYMVAARIWUMUPYENDAKA05  = "ztymvaariwumupyendaka05";
    public static final String ZTYMVAARIUMUPYENKIJYUN05 = "ztymvaariumupyenkijyun05";
    public static final String ZTYMVAARIUMUPYENYASU05   = "ztymvaariumupyenyasu05";
    public static final String ZTYMVAARIWTUKTYPESAME05  = "ztymvaariwtuktypesame05";
    public static final String ZTYMVAARITMTTKNKYKKJMSAME05 = "ztymvaaritmttknkykkjmsame05";
    public static final String ZTYMVAARIWSAME05         = "ztymvaariwsame05";
    public static final String ZTYMVAARIWYENTUKTYPESAME05 = "ztymvaariwyentuktypesame05";
    public static final String ZTYMVAARIWSAMEYENDAKA05  = "ztymvaariwsameyendaka05";
    public static final String ZTYMVAARIWSAMEYENKIJYUN05 = "ztymvaariwsameyenkijyun05";
    public static final String ZTYMVAARIWSAMEYENYASU05  = "ztymvaariwsameyenyasu05";
    public static final String ZTYMVAARIUMSAMEYENDAKA05 = "ztymvaariumsameyendaka05";
    public static final String ZTYMVAARIUMSAMEYENKIJYUN05 = "ztymvaariumsameyenkijyun05";
    public static final String ZTYMVAARIUMSAMEYENYASU05 = "ztymvaariumsameyenyasu05";
    public static final String ZTYMVAARIWTUKTYPEDOWN05  = "ztymvaariwtuktypedown05";
    public static final String ZTYMVAARITMTTKNKYKKJMDOWN05 = "ztymvaaritmttknkykkjmdown05";
    public static final String ZTYMVAARIWDOWN05         = "ztymvaariwdown05";
    public static final String ZTYMVAARIWYENTUKTYPEDOWN05 = "ztymvaariwyentuktypedown05";
    public static final String ZTYMVAARIWDOWNYENDAKA05  = "ztymvaariwdownyendaka05";
    public static final String ZTYMVAARIWDOWNYENKIJYUN05 = "ztymvaariwdownyenkijyun05";
    public static final String ZTYMVAARIWDOWNYENYASU05  = "ztymvaariwdownyenyasu05";
    public static final String ZTYMVAARIUMDOWNYENDAKA05 = "ztymvaariumdownyendaka05";
    public static final String ZTYMVAARIUMDOWNYENKIJYUN05 = "ztymvaariumdownyenkijyun05";
    public static final String ZTYMVAARIUMDOWNYENYASU05 = "ztymvaariumdownyenyasu05";
    public static final String ZTYMVAARIVTUKTYPE05      = "ztymvaarivtuktype05";
    public static final String ZTYMVAARIV05             = "ztymvaariv05";
    public static final String ZTYPTMTTKNGKUTIWAKE105   = "ztyptmttkngkutiwake105";
    public static final String ZTYPTMTTKNGKUTIWAKE205   = "ztyptmttkngkutiwake205";
    public static final String ZTYMVAARINENOUTOUYM06    = "ztymvaarinenoutouym06";
    public static final String ZTYMVAARISISUUUPRITU06   = "ztymvaarisisuuupritu06";
    public static final String ZTYMVAARITMTTKNZKRITU06  = "ztymvaaritmttknzkritu06";
    public static final String ZTYMVAARIWTUKTYPEUP06    = "ztymvaariwtuktypeup06";
    public static final String ZTYMVAARITMTTKNKYKKJMUP06 = "ztymvaaritmttknkykkjmup06";
    public static final String ZTYMVAARIWUP06           = "ztymvaariwup06";
    public static final String ZTYMVAARIWYENTUKTYPEUP06 = "ztymvaariwyentuktypeup06";
    public static final String ZTYMVAARIWUPYENDAKA06    = "ztymvaariwupyendaka06";
    public static final String ZTYMVAARIWUPYENKIJYUN06  = "ztymvaariwupyenkijyun06";
    public static final String ZTYMVAARIWUPYENYASU06    = "ztymvaariwupyenyasu06";
    public static final String ZTYMVAARIWUMUPYENDAKA06  = "ztymvaariwumupyendaka06";
    public static final String ZTYMVAARIUMUPYENKIJYUN06 = "ztymvaariumupyenkijyun06";
    public static final String ZTYMVAARIUMUPYENYASU06   = "ztymvaariumupyenyasu06";
    public static final String ZTYMVAARIWTUKTYPESAME06  = "ztymvaariwtuktypesame06";
    public static final String ZTYMVAARITMTTKNKYKKJMSAME06 = "ztymvaaritmttknkykkjmsame06";
    public static final String ZTYMVAARIWSAME06         = "ztymvaariwsame06";
    public static final String ZTYMVAARIWYENTUKTYPESAME06 = "ztymvaariwyentuktypesame06";
    public static final String ZTYMVAARIWSAMEYENDAKA06  = "ztymvaariwsameyendaka06";
    public static final String ZTYMVAARIWSAMEYENKIJYUN06 = "ztymvaariwsameyenkijyun06";
    public static final String ZTYMVAARIWSAMEYENYASU06  = "ztymvaariwsameyenyasu06";
    public static final String ZTYMVAARIUMSAMEYENDAKA06 = "ztymvaariumsameyendaka06";
    public static final String ZTYMVAARIUMSAMEYENKIJYUN06 = "ztymvaariumsameyenkijyun06";
    public static final String ZTYMVAARIUMSAMEYENYASU06 = "ztymvaariumsameyenyasu06";
    public static final String ZTYMVAARIWTUKTYPEDOWN06  = "ztymvaariwtuktypedown06";
    public static final String ZTYMVAARITMTTKNKYKKJMDOWN06 = "ztymvaaritmttknkykkjmdown06";
    public static final String ZTYMVAARIWDOWN06         = "ztymvaariwdown06";
    public static final String ZTYMVAARIWYENTUKTYPEDOWN06 = "ztymvaariwyentuktypedown06";
    public static final String ZTYMVAARIWDOWNYENDAKA06  = "ztymvaariwdownyendaka06";
    public static final String ZTYMVAARIWDOWNYENKIJYUN06 = "ztymvaariwdownyenkijyun06";
    public static final String ZTYMVAARIWDOWNYENYASU06  = "ztymvaariwdownyenyasu06";
    public static final String ZTYMVAARIUMDOWNYENDAKA06 = "ztymvaariumdownyendaka06";
    public static final String ZTYMVAARIUMDOWNYENKIJYUN06 = "ztymvaariumdownyenkijyun06";
    public static final String ZTYMVAARIUMDOWNYENYASU06 = "ztymvaariumdownyenyasu06";
    public static final String ZTYMVAARIVTUKTYPE06      = "ztymvaarivtuktype06";
    public static final String ZTYMVAARIV06             = "ztymvaariv06";
    public static final String ZTYPTMTTKNGKUTIWAKE106   = "ztyptmttkngkutiwake106";
    public static final String ZTYPTMTTKNGKUTIWAKE206   = "ztyptmttkngkutiwake206";
    public static final String ZTYMVAARINENOUTOUYM07    = "ztymvaarinenoutouym07";
    public static final String ZTYMVAARISISUUUPRITU07   = "ztymvaarisisuuupritu07";
    public static final String ZTYMVAARITMTTKNZKRITU07  = "ztymvaaritmttknzkritu07";
    public static final String ZTYMVAARIWTUKTYPEUP07    = "ztymvaariwtuktypeup07";
    public static final String ZTYMVAARITMTTKNKYKKJMUP07 = "ztymvaaritmttknkykkjmup07";
    public static final String ZTYMVAARIWUP07           = "ztymvaariwup07";
    public static final String ZTYMVAARIWYENTUKTYPEUP07 = "ztymvaariwyentuktypeup07";
    public static final String ZTYMVAARIWUPYENDAKA07    = "ztymvaariwupyendaka07";
    public static final String ZTYMVAARIWUPYENKIJYUN07  = "ztymvaariwupyenkijyun07";
    public static final String ZTYMVAARIWUPYENYASU07    = "ztymvaariwupyenyasu07";
    public static final String ZTYMVAARIWUMUPYENDAKA07  = "ztymvaariwumupyendaka07";
    public static final String ZTYMVAARIUMUPYENKIJYUN07 = "ztymvaariumupyenkijyun07";
    public static final String ZTYMVAARIUMUPYENYASU07   = "ztymvaariumupyenyasu07";
    public static final String ZTYMVAARIWTUKTYPESAME07  = "ztymvaariwtuktypesame07";
    public static final String ZTYMVAARITMTTKNKYKKJMSAME07 = "ztymvaaritmttknkykkjmsame07";
    public static final String ZTYMVAARIWSAME07         = "ztymvaariwsame07";
    public static final String ZTYMVAARIWYENTUKTYPESAME07 = "ztymvaariwyentuktypesame07";
    public static final String ZTYMVAARIWSAMEYENDAKA07  = "ztymvaariwsameyendaka07";
    public static final String ZTYMVAARIWSAMEYENKIJYUN07 = "ztymvaariwsameyenkijyun07";
    public static final String ZTYMVAARIWSAMEYENYASU07  = "ztymvaariwsameyenyasu07";
    public static final String ZTYMVAARIUMSAMEYENDAKA07 = "ztymvaariumsameyendaka07";
    public static final String ZTYMVAARIUMSAMEYENKIJYUN07 = "ztymvaariumsameyenkijyun07";
    public static final String ZTYMVAARIUMSAMEYENYASU07 = "ztymvaariumsameyenyasu07";
    public static final String ZTYMVAARIWTUKTYPEDOWN07  = "ztymvaariwtuktypedown07";
    public static final String ZTYMVAARITMTTKNKYKKJMDOWN07 = "ztymvaaritmttknkykkjmdown07";
    public static final String ZTYMVAARIWDOWN07         = "ztymvaariwdown07";
    public static final String ZTYMVAARIWYENTUKTYPEDOWN07 = "ztymvaariwyentuktypedown07";
    public static final String ZTYMVAARIWDOWNYENDAKA07  = "ztymvaariwdownyendaka07";
    public static final String ZTYMVAARIWDOWNYENKIJYUN07 = "ztymvaariwdownyenkijyun07";
    public static final String ZTYMVAARIWDOWNYENYASU07  = "ztymvaariwdownyenyasu07";
    public static final String ZTYMVAARIUMDOWNYENDAKA07 = "ztymvaariumdownyendaka07";
    public static final String ZTYMVAARIUMDOWNYENKIJYUN07 = "ztymvaariumdownyenkijyun07";
    public static final String ZTYMVAARIUMDOWNYENYASU07 = "ztymvaariumdownyenyasu07";
    public static final String ZTYMVAARIVTUKTYPE07      = "ztymvaarivtuktype07";
    public static final String ZTYMVAARIV07             = "ztymvaariv07";
    public static final String ZTYPTMTTKNGKUTIWAKE107   = "ztyptmttkngkutiwake107";
    public static final String ZTYPTMTTKNGKUTIWAKE207   = "ztyptmttkngkutiwake207";
    public static final String ZTYMVAARINENOUTOUYM08    = "ztymvaarinenoutouym08";
    public static final String ZTYMVAARISISUUUPRITU08   = "ztymvaarisisuuupritu08";
    public static final String ZTYMVAARITMTTKNZKRITU08  = "ztymvaaritmttknzkritu08";
    public static final String ZTYMVAARIWTUKTYPEUP08    = "ztymvaariwtuktypeup08";
    public static final String ZTYMVAARITMTTKNKYKKJMUP08 = "ztymvaaritmttknkykkjmup08";
    public static final String ZTYMVAARIWUP08           = "ztymvaariwup08";
    public static final String ZTYMVAARIWYENTUKTYPEUP08 = "ztymvaariwyentuktypeup08";
    public static final String ZTYMVAARIWUPYENDAKA08    = "ztymvaariwupyendaka08";
    public static final String ZTYMVAARIWUPYENKIJYUN08  = "ztymvaariwupyenkijyun08";
    public static final String ZTYMVAARIWUPYENYASU08    = "ztymvaariwupyenyasu08";
    public static final String ZTYMVAARIWUMUPYENDAKA08  = "ztymvaariwumupyendaka08";
    public static final String ZTYMVAARIUMUPYENKIJYUN08 = "ztymvaariumupyenkijyun08";
    public static final String ZTYMVAARIUMUPYENYASU08   = "ztymvaariumupyenyasu08";
    public static final String ZTYMVAARIWTUKTYPESAME08  = "ztymvaariwtuktypesame08";
    public static final String ZTYMVAARITMTTKNKYKKJMSAME08 = "ztymvaaritmttknkykkjmsame08";
    public static final String ZTYMVAARIWSAME08         = "ztymvaariwsame08";
    public static final String ZTYMVAARIWYENTUKTYPESAME08 = "ztymvaariwyentuktypesame08";
    public static final String ZTYMVAARIWSAMEYENDAKA08  = "ztymvaariwsameyendaka08";
    public static final String ZTYMVAARIWSAMEYENKIJYUN08 = "ztymvaariwsameyenkijyun08";
    public static final String ZTYMVAARIWSAMEYENYASU08  = "ztymvaariwsameyenyasu08";
    public static final String ZTYMVAARIUMSAMEYENDAKA08 = "ztymvaariumsameyendaka08";
    public static final String ZTYMVAARIUMSAMEYENKIJYUN08 = "ztymvaariumsameyenkijyun08";
    public static final String ZTYMVAARIUMSAMEYENYASU08 = "ztymvaariumsameyenyasu08";
    public static final String ZTYMVAARIWTUKTYPEDOWN08  = "ztymvaariwtuktypedown08";
    public static final String ZTYMVAARITMTTKNKYKKJMDOWN08 = "ztymvaaritmttknkykkjmdown08";
    public static final String ZTYMVAARIWDOWN08         = "ztymvaariwdown08";
    public static final String ZTYMVAARIWYENTUKTYPEDOWN08 = "ztymvaariwyentuktypedown08";
    public static final String ZTYMVAARIWDOWNYENDAKA08  = "ztymvaariwdownyendaka08";
    public static final String ZTYMVAARIWDOWNYENKIJYUN08 = "ztymvaariwdownyenkijyun08";
    public static final String ZTYMVAARIWDOWNYENYASU08  = "ztymvaariwdownyenyasu08";
    public static final String ZTYMVAARIUMDOWNYENDAKA08 = "ztymvaariumdownyendaka08";
    public static final String ZTYMVAARIUMDOWNYENKIJYUN08 = "ztymvaariumdownyenkijyun08";
    public static final String ZTYMVAARIUMDOWNYENYASU08 = "ztymvaariumdownyenyasu08";
    public static final String ZTYMVAARIVTUKTYPE08      = "ztymvaarivtuktype08";
    public static final String ZTYMVAARIV08             = "ztymvaariv08";
    public static final String ZTYPTMTTKNGKUTIWAKE108   = "ztyptmttkngkutiwake108";
    public static final String ZTYPTMTTKNGKUTIWAKE208   = "ztyptmttkngkutiwake208";
    public static final String ZTYMVAARINENOUTOUYM09    = "ztymvaarinenoutouym09";
    public static final String ZTYMVAARISISUUUPRITU09   = "ztymvaarisisuuupritu09";
    public static final String ZTYMVAARITMTTKNZKRITU09  = "ztymvaaritmttknzkritu09";
    public static final String ZTYMVAARIWTUKTYPEUP09    = "ztymvaariwtuktypeup09";
    public static final String ZTYMVAARITMTTKNKYKKJMUP09 = "ztymvaaritmttknkykkjmup09";
    public static final String ZTYMVAARIWUP09           = "ztymvaariwup09";
    public static final String ZTYMVAARIWYENTUKTYPEUP09 = "ztymvaariwyentuktypeup09";
    public static final String ZTYMVAARIWUPYENDAKA09    = "ztymvaariwupyendaka09";
    public static final String ZTYMVAARIWUPYENKIJYUN09  = "ztymvaariwupyenkijyun09";
    public static final String ZTYMVAARIWUPYENYASU09    = "ztymvaariwupyenyasu09";
    public static final String ZTYMVAARIWUMUPYENDAKA09  = "ztymvaariwumupyendaka09";
    public static final String ZTYMVAARIUMUPYENKIJYUN09 = "ztymvaariumupyenkijyun09";
    public static final String ZTYMVAARIUMUPYENYASU09   = "ztymvaariumupyenyasu09";
    public static final String ZTYMVAARIWTUKTYPESAME09  = "ztymvaariwtuktypesame09";
    public static final String ZTYMVAARITMTTKNKYKKJMSAME09 = "ztymvaaritmttknkykkjmsame09";
    public static final String ZTYMVAARIWSAME09         = "ztymvaariwsame09";
    public static final String ZTYMVAARIWYENTUKTYPESAME09 = "ztymvaariwyentuktypesame09";
    public static final String ZTYMVAARIWSAMEYENDAKA09  = "ztymvaariwsameyendaka09";
    public static final String ZTYMVAARIWSAMEYENKIJYUN09 = "ztymvaariwsameyenkijyun09";
    public static final String ZTYMVAARIWSAMEYENYASU09  = "ztymvaariwsameyenyasu09";
    public static final String ZTYMVAARIUMSAMEYENDAKA09 = "ztymvaariumsameyendaka09";
    public static final String ZTYMVAARIUMSAMEYENKIJYUN09 = "ztymvaariumsameyenkijyun09";
    public static final String ZTYMVAARIUMSAMEYENYASU09 = "ztymvaariumsameyenyasu09";
    public static final String ZTYMVAARIWTUKTYPEDOWN09  = "ztymvaariwtuktypedown09";
    public static final String ZTYMVAARITMTTKNKYKKJMDOWN09 = "ztymvaaritmttknkykkjmdown09";
    public static final String ZTYMVAARIWDOWN09         = "ztymvaariwdown09";
    public static final String ZTYMVAARIWYENTUKTYPEDOWN09 = "ztymvaariwyentuktypedown09";
    public static final String ZTYMVAARIWDOWNYENDAKA09  = "ztymvaariwdownyendaka09";
    public static final String ZTYMVAARIWDOWNYENKIJYUN09 = "ztymvaariwdownyenkijyun09";
    public static final String ZTYMVAARIWDOWNYENYASU09  = "ztymvaariwdownyenyasu09";
    public static final String ZTYMVAARIUMDOWNYENDAKA09 = "ztymvaariumdownyendaka09";
    public static final String ZTYMVAARIUMDOWNYENKIJYUN09 = "ztymvaariumdownyenkijyun09";
    public static final String ZTYMVAARIUMDOWNYENYASU09 = "ztymvaariumdownyenyasu09";
    public static final String ZTYMVAARIVTUKTYPE09      = "ztymvaarivtuktype09";
    public static final String ZTYMVAARIV09             = "ztymvaariv09";
    public static final String ZTYPTMTTKNGKUTIWAKE109   = "ztyptmttkngkutiwake109";
    public static final String ZTYPTMTTKNGKUTIWAKE209   = "ztyptmttkngkutiwake209";
    public static final String ZTYMVAARINENOUTOUYM10    = "ztymvaarinenoutouym10";
    public static final String ZTYMVAARISISUUUPRITU10   = "ztymvaarisisuuupritu10";
    public static final String ZTYMVAARITMTTKNZKRITU10  = "ztymvaaritmttknzkritu10";
    public static final String ZTYMVAARIWTUKTYPEUP10    = "ztymvaariwtuktypeup10";
    public static final String ZTYMVAARITMTTKNKYKKJMUP10 = "ztymvaaritmttknkykkjmup10";
    public static final String ZTYMVAARIWUP10           = "ztymvaariwup10";
    public static final String ZTYMVAARIWYENTUKTYPEUP10 = "ztymvaariwyentuktypeup10";
    public static final String ZTYMVAARIWUPYENDAKA10    = "ztymvaariwupyendaka10";
    public static final String ZTYMVAARIWUPYENKIJYUN10  = "ztymvaariwupyenkijyun10";
    public static final String ZTYMVAARIWUPYENYASU10    = "ztymvaariwupyenyasu10";
    public static final String ZTYMVAARIWUMUPYENDAKA10  = "ztymvaariwumupyendaka10";
    public static final String ZTYMVAARIUMUPYENKIJYUN10 = "ztymvaariumupyenkijyun10";
    public static final String ZTYMVAARIUMUPYENYASU10   = "ztymvaariumupyenyasu10";
    public static final String ZTYMVAARIWTUKTYPESAME10  = "ztymvaariwtuktypesame10";
    public static final String ZTYMVAARITMTTKNKYKKJMSAME10 = "ztymvaaritmttknkykkjmsame10";
    public static final String ZTYMVAARIWSAME10         = "ztymvaariwsame10";
    public static final String ZTYMVAARIWYENTUKTYPESAME10 = "ztymvaariwyentuktypesame10";
    public static final String ZTYMVAARIWSAMEYENDAKA10  = "ztymvaariwsameyendaka10";
    public static final String ZTYMVAARIWSAMEYENKIJYUN10 = "ztymvaariwsameyenkijyun10";
    public static final String ZTYMVAARIWSAMEYENYASU10  = "ztymvaariwsameyenyasu10";
    public static final String ZTYMVAARIUMSAMEYENDAKA10 = "ztymvaariumsameyendaka10";
    public static final String ZTYMVAARIUMSAMEYENKIJYUN10 = "ztymvaariumsameyenkijyun10";
    public static final String ZTYMVAARIUMSAMEYENYASU10 = "ztymvaariumsameyenyasu10";
    public static final String ZTYMVAARIWTUKTYPEDOWN10  = "ztymvaariwtuktypedown10";
    public static final String ZTYMVAARITMTTKNKYKKJMDOWN10 = "ztymvaaritmttknkykkjmdown10";
    public static final String ZTYMVAARIWDOWN10         = "ztymvaariwdown10";
    public static final String ZTYMVAARIWYENTUKTYPEDOWN10 = "ztymvaariwyentuktypedown10";
    public static final String ZTYMVAARIWDOWNYENDAKA10  = "ztymvaariwdownyendaka10";
    public static final String ZTYMVAARIWDOWNYENKIJYUN10 = "ztymvaariwdownyenkijyun10";
    public static final String ZTYMVAARIWDOWNYENYASU10  = "ztymvaariwdownyenyasu10";
    public static final String ZTYMVAARIUMDOWNYENDAKA10 = "ztymvaariumdownyendaka10";
    public static final String ZTYMVAARIUMDOWNYENKIJYUN10 = "ztymvaariumdownyenkijyun10";
    public static final String ZTYMVAARIUMDOWNYENYASU10 = "ztymvaariumdownyenyasu10";
    public static final String ZTYMVAARIVTUKTYPE10      = "ztymvaarivtuktype10";
    public static final String ZTYMVAARIV10             = "ztymvaariv10";
    public static final String ZTYPTMTTKNGKUTIWAKE110   = "ztyptmttkngkutiwake110";
    public static final String ZTYPTMTTKNGKUTIWAKE210   = "ztyptmttkngkutiwake210";
    public static final String ZTYMVAARINENOUTOUYM11    = "ztymvaarinenoutouym11";
    public static final String ZTYMVAARIWTUKTYPEUP11    = "ztymvaariwtuktypeup11";
    public static final String ZTYMVAARIWUP11           = "ztymvaariwup11";
    public static final String ZTYMVAARIWYENTUKTYPEUP11 = "ztymvaariwyentuktypeup11";
    public static final String ZTYMVAARIWUPYENDAKA11    = "ztymvaariwupyendaka11";
    public static final String ZTYMVAARIWUPYENKIJYUN11  = "ztymvaariwupyenkijyun11";
    public static final String ZTYMVAARIWUPYENYASU11    = "ztymvaariwupyenyasu11";
    public static final String ZTYMVAARIWUMUPYENDAKA11  = "ztymvaariwumupyendaka11";
    public static final String ZTYMVAARIUMUPYENKIJYUN11 = "ztymvaariumupyenkijyun11";
    public static final String ZTYMVAARIUMUPYENYASU11   = "ztymvaariumupyenyasu11";
    public static final String ZTYMVAARIWTUKTYPESAME11  = "ztymvaariwtuktypesame11";
    public static final String ZTYMVAARIWSAME11         = "ztymvaariwsame11";
    public static final String ZTYMVAARIWYENTUKTYPESAME11 = "ztymvaariwyentuktypesame11";
    public static final String ZTYMVAARIWSAMEYENDAKA11  = "ztymvaariwsameyendaka11";
    public static final String ZTYMVAARIWSAMEYENKIJYUN11 = "ztymvaariwsameyenkijyun11";
    public static final String ZTYMVAARIWSAMEYENYASU11  = "ztymvaariwsameyenyasu11";
    public static final String ZTYMVAARIUMSAMEYENDAKA11 = "ztymvaariumsameyendaka11";
    public static final String ZTYMVAARIUMSAMEYENKIJYUN11 = "ztymvaariumsameyenkijyun11";
    public static final String ZTYMVAARIUMSAMEYENYASU11 = "ztymvaariumsameyenyasu11";
    public static final String ZTYMVAARIWTUKTYPEDOWN11  = "ztymvaariwtuktypedown11";
    public static final String ZTYMVAARIWDOWN11         = "ztymvaariwdown11";
    public static final String ZTYMVAARIWYENTUKTYPEDOWN11 = "ztymvaariwyentuktypedown11";
    public static final String ZTYMVAARIWDOWNYENDAKA11  = "ztymvaariwdownyendaka11";
    public static final String ZTYMVAARIWDOWNYENKIJYUN11 = "ztymvaariwdownyenkijyun11";
    public static final String ZTYMVAARIWDOWNYENYASU11  = "ztymvaariwdownyenyasu11";
    public static final String ZTYMVAARIUMDOWNYENDAKA11 = "ztymvaariumdownyendaka11";
    public static final String ZTYMVAARIUMDOWNYENKIJYUN11 = "ztymvaariumdownyenkijyun11";
    public static final String ZTYMVAARIUMDOWNYENYASU11 = "ztymvaariumdownyenyasu11";
    public static final String ZTYMVAARIVTUKTYPE11      = "ztymvaarivtuktype11";
    public static final String ZTYMVAARIV11             = "ztymvaariv11";
    public static final String ZTYMVAARINENOUTOUYM12    = "ztymvaarinenoutouym12";
    public static final String ZTYMVAARIWTUKTYPEUP12    = "ztymvaariwtuktypeup12";
    public static final String ZTYMVAARIWUP12           = "ztymvaariwup12";
    public static final String ZTYMVAARIWYENTUKTYPEUP12 = "ztymvaariwyentuktypeup12";
    public static final String ZTYMVAARIWUPYENDAKA12    = "ztymvaariwupyendaka12";
    public static final String ZTYMVAARIWUPYENKIJYUN12  = "ztymvaariwupyenkijyun12";
    public static final String ZTYMVAARIWUPYENYASU12    = "ztymvaariwupyenyasu12";
    public static final String ZTYMVAARIWUMUPYENDAKA12  = "ztymvaariwumupyendaka12";
    public static final String ZTYMVAARIUMUPYENKIJYUN12 = "ztymvaariumupyenkijyun12";
    public static final String ZTYMVAARIUMUPYENYASU12   = "ztymvaariumupyenyasu12";
    public static final String ZTYMVAARIWTUKTYPESAME12  = "ztymvaariwtuktypesame12";
    public static final String ZTYMVAARIWSAME12         = "ztymvaariwsame12";
    public static final String ZTYMVAARIWYENTUKTYPESAME12 = "ztymvaariwyentuktypesame12";
    public static final String ZTYMVAARIWSAMEYENDAKA12  = "ztymvaariwsameyendaka12";
    public static final String ZTYMVAARIWSAMEYENKIJYUN12 = "ztymvaariwsameyenkijyun12";
    public static final String ZTYMVAARIWSAMEYENYASU12  = "ztymvaariwsameyenyasu12";
    public static final String ZTYMVAARIUMSAMEYENDAKA12 = "ztymvaariumsameyendaka12";
    public static final String ZTYMVAARIUMSAMEYENKIJYUN12 = "ztymvaariumsameyenkijyun12";
    public static final String ZTYMVAARIUMSAMEYENYASU12 = "ztymvaariumsameyenyasu12";
    public static final String ZTYMVAARIWTUKTYPEDOWN12  = "ztymvaariwtuktypedown12";
    public static final String ZTYMVAARIWDOWN12         = "ztymvaariwdown12";
    public static final String ZTYMVAARIWYENTUKTYPEDOWN12 = "ztymvaariwyentuktypedown12";
    public static final String ZTYMVAARIWDOWNYENDAKA12  = "ztymvaariwdownyendaka12";
    public static final String ZTYMVAARIWDOWNYENKIJYUN12 = "ztymvaariwdownyenkijyun12";
    public static final String ZTYMVAARIWDOWNYENYASU12  = "ztymvaariwdownyenyasu12";
    public static final String ZTYMVAARIUMDOWNYENDAKA12 = "ztymvaariumdownyendaka12";
    public static final String ZTYMVAARIUMDOWNYENKIJYUN12 = "ztymvaariumdownyenkijyun12";
    public static final String ZTYMVAARIUMDOWNYENYASU12 = "ztymvaariumdownyenyasu12";
    public static final String ZTYMVAARIVTUKTYPE12      = "ztymvaarivtuktype12";
    public static final String ZTYMVAARIV12             = "ztymvaariv12";
    public static final String ZTYMVAARINENOUTOUYM13    = "ztymvaarinenoutouym13";
    public static final String ZTYMVAARIWTUKTYPEUP13    = "ztymvaariwtuktypeup13";
    public static final String ZTYMVAARIWUP13           = "ztymvaariwup13";
    public static final String ZTYMVAARIWYENTUKTYPEUP13 = "ztymvaariwyentuktypeup13";
    public static final String ZTYMVAARIWUPYENDAKA13    = "ztymvaariwupyendaka13";
    public static final String ZTYMVAARIWUPYENKIJYUN13  = "ztymvaariwupyenkijyun13";
    public static final String ZTYMVAARIWUPYENYASU13    = "ztymvaariwupyenyasu13";
    public static final String ZTYMVAARIWUMUPYENDAKA13  = "ztymvaariwumupyendaka13";
    public static final String ZTYMVAARIUMUPYENKIJYUN13 = "ztymvaariumupyenkijyun13";
    public static final String ZTYMVAARIUMUPYENYASU13   = "ztymvaariumupyenyasu13";
    public static final String ZTYMVAARIWTUKTYPESAME13  = "ztymvaariwtuktypesame13";
    public static final String ZTYMVAARIWSAME13         = "ztymvaariwsame13";
    public static final String ZTYMVAARIWYENTUKTYPESAME13 = "ztymvaariwyentuktypesame13";
    public static final String ZTYMVAARIWSAMEYENDAKA13  = "ztymvaariwsameyendaka13";
    public static final String ZTYMVAARIWSAMEYENKIJYUN13 = "ztymvaariwsameyenkijyun13";
    public static final String ZTYMVAARIWSAMEYENYASU13  = "ztymvaariwsameyenyasu13";
    public static final String ZTYMVAARIUMSAMEYENDAKA13 = "ztymvaariumsameyendaka13";
    public static final String ZTYMVAARIUMSAMEYENKIJYUN13 = "ztymvaariumsameyenkijyun13";
    public static final String ZTYMVAARIUMSAMEYENYASU13 = "ztymvaariumsameyenyasu13";
    public static final String ZTYMVAARIWTUKTYPEDOWN13  = "ztymvaariwtuktypedown13";
    public static final String ZTYMVAARIWDOWN13         = "ztymvaariwdown13";
    public static final String ZTYMVAARIWYENTUKTYPEDOWN13 = "ztymvaariwyentuktypedown13";
    public static final String ZTYMVAARIWDOWNYENDAKA13  = "ztymvaariwdownyendaka13";
    public static final String ZTYMVAARIWDOWNYENKIJYUN13 = "ztymvaariwdownyenkijyun13";
    public static final String ZTYMVAARIWDOWNYENYASU13  = "ztymvaariwdownyenyasu13";
    public static final String ZTYMVAARIUMDOWNYENDAKA13 = "ztymvaariumdownyendaka13";
    public static final String ZTYMVAARIUMDOWNYENKIJYUN13 = "ztymvaariumdownyenkijyun13";
    public static final String ZTYMVAARIUMDOWNYENYASU13 = "ztymvaariumdownyenyasu13";
    public static final String ZTYMVAARIVTUKTYPE13      = "ztymvaarivtuktype13";
    public static final String ZTYMVAARIV13             = "ztymvaariv13";
    public static final String ZTYMVAARINENOUTOUYM14    = "ztymvaarinenoutouym14";
    public static final String ZTYMVAARIWTUKTYPEUP14    = "ztymvaariwtuktypeup14";
    public static final String ZTYMVAARIWUP14           = "ztymvaariwup14";
    public static final String ZTYMVAARIWYENTUKTYPEUP14 = "ztymvaariwyentuktypeup14";
    public static final String ZTYMVAARIWUPYENDAKA14    = "ztymvaariwupyendaka14";
    public static final String ZTYMVAARIWUPYENKIJYUN14  = "ztymvaariwupyenkijyun14";
    public static final String ZTYMVAARIWUPYENYASU14    = "ztymvaariwupyenyasu14";
    public static final String ZTYMVAARIWUMUPYENDAKA14  = "ztymvaariwumupyendaka14";
    public static final String ZTYMVAARIUMUPYENKIJYUN14 = "ztymvaariumupyenkijyun14";
    public static final String ZTYMVAARIUMUPYENYASU14   = "ztymvaariumupyenyasu14";
    public static final String ZTYMVAARIWTUKTYPESAME14  = "ztymvaariwtuktypesame14";
    public static final String ZTYMVAARIWSAME14         = "ztymvaariwsame14";
    public static final String ZTYMVAARIWYENTUKTYPESAME14 = "ztymvaariwyentuktypesame14";
    public static final String ZTYMVAARIWSAMEYENDAKA14  = "ztymvaariwsameyendaka14";
    public static final String ZTYMVAARIWSAMEYENKIJYUN14 = "ztymvaariwsameyenkijyun14";
    public static final String ZTYMVAARIWSAMEYENYASU14  = "ztymvaariwsameyenyasu14";
    public static final String ZTYMVAARIUMSAMEYENDAKA14 = "ztymvaariumsameyendaka14";
    public static final String ZTYMVAARIUMSAMEYENKIJYUN14 = "ztymvaariumsameyenkijyun14";
    public static final String ZTYMVAARIUMSAMEYENYASU14 = "ztymvaariumsameyenyasu14";
    public static final String ZTYMVAARIWTUKTYPEDOWN14  = "ztymvaariwtuktypedown14";
    public static final String ZTYMVAARIWDOWN14         = "ztymvaariwdown14";
    public static final String ZTYMVAARIWYENTUKTYPEDOWN14 = "ztymvaariwyentuktypedown14";
    public static final String ZTYMVAARIWDOWNYENDAKA14  = "ztymvaariwdownyendaka14";
    public static final String ZTYMVAARIWDOWNYENKIJYUN14 = "ztymvaariwdownyenkijyun14";
    public static final String ZTYMVAARIWDOWNYENYASU14  = "ztymvaariwdownyenyasu14";
    public static final String ZTYMVAARIUMDOWNYENDAKA14 = "ztymvaariumdownyendaka14";
    public static final String ZTYMVAARIUMDOWNYENKIJYUN14 = "ztymvaariumdownyenkijyun14";
    public static final String ZTYMVAARIUMDOWNYENYASU14 = "ztymvaariumdownyenyasu14";
    public static final String ZTYMVAARIVTUKTYPE14      = "ztymvaarivtuktype14";
    public static final String ZTYMVAARIV14             = "ztymvaariv14";
    public static final String ZTYMVAARINENOUTOUYM15    = "ztymvaarinenoutouym15";
    public static final String ZTYMVAARIWTUKTYPEUP15    = "ztymvaariwtuktypeup15";
    public static final String ZTYMVAARIWUP15           = "ztymvaariwup15";
    public static final String ZTYMVAARIWYENTUKTYPEUP15 = "ztymvaariwyentuktypeup15";
    public static final String ZTYMVAARIWUPYENDAKA15    = "ztymvaariwupyendaka15";
    public static final String ZTYMVAARIWUPYENKIJYUN15  = "ztymvaariwupyenkijyun15";
    public static final String ZTYMVAARIWUPYENYASU15    = "ztymvaariwupyenyasu15";
    public static final String ZTYMVAARIWUMUPYENDAKA15  = "ztymvaariwumupyendaka15";
    public static final String ZTYMVAARIUMUPYENKIJYUN15 = "ztymvaariumupyenkijyun15";
    public static final String ZTYMVAARIUMUPYENYASU15   = "ztymvaariumupyenyasu15";
    public static final String ZTYMVAARIWTUKTYPESAME15  = "ztymvaariwtuktypesame15";
    public static final String ZTYMVAARIWSAME15         = "ztymvaariwsame15";
    public static final String ZTYMVAARIWYENTUKTYPESAME15 = "ztymvaariwyentuktypesame15";
    public static final String ZTYMVAARIWSAMEYENDAKA15  = "ztymvaariwsameyendaka15";
    public static final String ZTYMVAARIWSAMEYENKIJYUN15 = "ztymvaariwsameyenkijyun15";
    public static final String ZTYMVAARIWSAMEYENYASU15  = "ztymvaariwsameyenyasu15";
    public static final String ZTYMVAARIUMSAMEYENDAKA15 = "ztymvaariumsameyendaka15";
    public static final String ZTYMVAARIUMSAMEYENKIJYUN15 = "ztymvaariumsameyenkijyun15";
    public static final String ZTYMVAARIUMSAMEYENYASU15 = "ztymvaariumsameyenyasu15";
    public static final String ZTYMVAARIWTUKTYPEDOWN15  = "ztymvaariwtuktypedown15";
    public static final String ZTYMVAARIWDOWN15         = "ztymvaariwdown15";
    public static final String ZTYMVAARIWYENTUKTYPEDOWN15 = "ztymvaariwyentuktypedown15";
    public static final String ZTYMVAARIWDOWNYENDAKA15  = "ztymvaariwdownyendaka15";
    public static final String ZTYMVAARIWDOWNYENKIJYUN15 = "ztymvaariwdownyenkijyun15";
    public static final String ZTYMVAARIWDOWNYENYASU15  = "ztymvaariwdownyenyasu15";
    public static final String ZTYMVAARIUMDOWNYENDAKA15 = "ztymvaariumdownyendaka15";
    public static final String ZTYMVAARIUMDOWNYENKIJYUN15 = "ztymvaariumdownyenkijyun15";
    public static final String ZTYMVAARIUMDOWNYENYASU15 = "ztymvaariumdownyenyasu15";
    public static final String ZTYMVAARIVTUKTYPE15      = "ztymvaarivtuktype15";
    public static final String ZTYMVAARIV15             = "ztymvaariv15";
    public static final String ZTYMVANONEKAISIINNUMUKBN01 = "ztymvanonekaisiinnumukbn01";
    public static final String ZTYMVANONENENOUTOUYM01   = "ztymvanonenenoutouym01";
    public static final String ZTYMVANONEWTUKTYPE01     = "ztymvanonewtuktype01";
    public static final String ZTYMVANONEW01            = "ztymvanonew01";
    public static final String ZTYMVANONEWYENTUKTYPE01  = "ztymvanonewyentuktype01";
    public static final String ZTYMVANONEWYENDAKA01     = "ztymvanonewyendaka01";
    public static final String ZTYMVANONEWYENKIJYUN01   = "ztymvanonewyenkijyun01";
    public static final String ZTYMVANONEWYENYASU01     = "ztymvanonewyenyasu01";
    public static final String ZTYMVANONEUMYENDAKA01    = "ztymvanoneumyendaka01";
    public static final String ZTYMVANONEUMYENKIJYUN01  = "ztymvanoneumyenkijyun01";
    public static final String ZTYMVANONEUMYENYASU01    = "ztymvanoneumyenyasu01";
    public static final String ZTYMVANONEVTUKTYPE01     = "ztymvanonevtuktype01";
    public static final String ZTYMVANONEV01            = "ztymvanonev01";
    public static final String ZTYMVANONEKAISIINNUMUKBN02 = "ztymvanonekaisiinnumukbn02";
    public static final String ZTYMVANONENENOUTOUYM02   = "ztymvanonenenoutouym02";
    public static final String ZTYMVANONEWTUKTYPE02     = "ztymvanonewtuktype02";
    public static final String ZTYMVANONEW02            = "ztymvanonew02";
    public static final String ZTYMVANONEWYENTUKTYPE02  = "ztymvanonewyentuktype02";
    public static final String ZTYMVANONEWYENDAKA02     = "ztymvanonewyendaka02";
    public static final String ZTYMVANONEWYENKIJYUN02   = "ztymvanonewyenkijyun02";
    public static final String ZTYMVANONEWYENYASU02     = "ztymvanonewyenyasu02";
    public static final String ZTYMVANONEUMYENDAKA02    = "ztymvanoneumyendaka02";
    public static final String ZTYMVANONEUMYENKIJYUN02  = "ztymvanoneumyenkijyun02";
    public static final String ZTYMVANONEUMYENYASU02    = "ztymvanoneumyenyasu02";
    public static final String ZTYMVANONEVTUKTYPE02     = "ztymvanonevtuktype02";
    public static final String ZTYMVANONEV02            = "ztymvanonev02";
    public static final String ZTYMVANONEKAISIINNUMUKBN03 = "ztymvanonekaisiinnumukbn03";
    public static final String ZTYMVANONENENOUTOUYM03   = "ztymvanonenenoutouym03";
    public static final String ZTYMVANONEWTUKTYPE03     = "ztymvanonewtuktype03";
    public static final String ZTYMVANONEW03            = "ztymvanonew03";
    public static final String ZTYMVANONEWYENTUKTYPE03  = "ztymvanonewyentuktype03";
    public static final String ZTYMVANONEWYENDAKA03     = "ztymvanonewyendaka03";
    public static final String ZTYMVANONEWYENKIJYUN03   = "ztymvanonewyenkijyun03";
    public static final String ZTYMVANONEWYENYASU03     = "ztymvanonewyenyasu03";
    public static final String ZTYMVANONEUMYENDAKA03    = "ztymvanoneumyendaka03";
    public static final String ZTYMVANONEUMYENKIJYUN03  = "ztymvanoneumyenkijyun03";
    public static final String ZTYMVANONEUMYENYASU03    = "ztymvanoneumyenyasu03";
    public static final String ZTYMVANONEVTUKTYPE03     = "ztymvanonevtuktype03";
    public static final String ZTYMVANONEV03            = "ztymvanonev03";
    public static final String ZTYMVANONEKAISIINNUMUKBN04 = "ztymvanonekaisiinnumukbn04";
    public static final String ZTYMVANONENENOUTOUYM04   = "ztymvanonenenoutouym04";
    public static final String ZTYMVANONEWTUKTYPE04     = "ztymvanonewtuktype04";
    public static final String ZTYMVANONEW04            = "ztymvanonew04";
    public static final String ZTYMVANONEWYENTUKTYPE04  = "ztymvanonewyentuktype04";
    public static final String ZTYMVANONEWYENDAKA04     = "ztymvanonewyendaka04";
    public static final String ZTYMVANONEWYENKIJYUN04   = "ztymvanonewyenkijyun04";
    public static final String ZTYMVANONEWYENYASU04     = "ztymvanonewyenyasu04";
    public static final String ZTYMVANONEUMYENDAKA04    = "ztymvanoneumyendaka04";
    public static final String ZTYMVANONEUMYENKIJYUN04  = "ztymvanoneumyenkijyun04";
    public static final String ZTYMVANONEUMYENYASU04    = "ztymvanoneumyenyasu04";
    public static final String ZTYMVANONEVTUKTYPE04     = "ztymvanonevtuktype04";
    public static final String ZTYMVANONEV04            = "ztymvanonev04";
    public static final String ZTYMVANONEKAISIINNUMUKBN05 = "ztymvanonekaisiinnumukbn05";
    public static final String ZTYMVANONENENOUTOUYM05   = "ztymvanonenenoutouym05";
    public static final String ZTYMVANONEWTUKTYPE05     = "ztymvanonewtuktype05";
    public static final String ZTYMVANONEW05            = "ztymvanonew05";
    public static final String ZTYMVANONEWYENTUKTYPE05  = "ztymvanonewyentuktype05";
    public static final String ZTYMVANONEWYENDAKA05     = "ztymvanonewyendaka05";
    public static final String ZTYMVANONEWYENKIJYUN05   = "ztymvanonewyenkijyun05";
    public static final String ZTYMVANONEWYENYASU05     = "ztymvanonewyenyasu05";
    public static final String ZTYMVANONEUMYENDAKA05    = "ztymvanoneumyendaka05";
    public static final String ZTYMVANONEUMYENKIJYUN05  = "ztymvanoneumyenkijyun05";
    public static final String ZTYMVANONEUMYENYASU05    = "ztymvanoneumyenyasu05";
    public static final String ZTYMVANONEVTUKTYPE05     = "ztymvanonevtuktype05";
    public static final String ZTYMVANONEV05            = "ztymvanonev05";
    public static final String ZTYMVANONEKAISIINNUMUKBN06 = "ztymvanonekaisiinnumukbn06";
    public static final String ZTYMVANONENENOUTOUYM06   = "ztymvanonenenoutouym06";
    public static final String ZTYMVANONEWTUKTYPE06     = "ztymvanonewtuktype06";
    public static final String ZTYMVANONEW06            = "ztymvanonew06";
    public static final String ZTYMVANONEWYENTUKTYPE06  = "ztymvanonewyentuktype06";
    public static final String ZTYMVANONEWYENDAKA06     = "ztymvanonewyendaka06";
    public static final String ZTYMVANONEWYENKIJYUN06   = "ztymvanonewyenkijyun06";
    public static final String ZTYMVANONEWYENYASU06     = "ztymvanonewyenyasu06";
    public static final String ZTYMVANONEUMYENDAKA06    = "ztymvanoneumyendaka06";
    public static final String ZTYMVANONEUMYENKIJYUN06  = "ztymvanoneumyenkijyun06";
    public static final String ZTYMVANONEUMYENYASU06    = "ztymvanoneumyenyasu06";
    public static final String ZTYMVANONEVTUKTYPE06     = "ztymvanonevtuktype06";
    public static final String ZTYMVANONEV06            = "ztymvanonev06";
    public static final String ZTYMVANONEKAISIINNUMUKBN07 = "ztymvanonekaisiinnumukbn07";
    public static final String ZTYMVANONENENOUTOUYM07   = "ztymvanonenenoutouym07";
    public static final String ZTYMVANONEWTUKTYPE07     = "ztymvanonewtuktype07";
    public static final String ZTYMVANONEW07            = "ztymvanonew07";
    public static final String ZTYMVANONEWYENTUKTYPE07  = "ztymvanonewyentuktype07";
    public static final String ZTYMVANONEWYENDAKA07     = "ztymvanonewyendaka07";
    public static final String ZTYMVANONEWYENKIJYUN07   = "ztymvanonewyenkijyun07";
    public static final String ZTYMVANONEWYENYASU07     = "ztymvanonewyenyasu07";
    public static final String ZTYMVANONEUMYENDAKA07    = "ztymvanoneumyendaka07";
    public static final String ZTYMVANONEUMYENKIJYUN07  = "ztymvanoneumyenkijyun07";
    public static final String ZTYMVANONEUMYENYASU07    = "ztymvanoneumyenyasu07";
    public static final String ZTYMVANONEVTUKTYPE07     = "ztymvanonevtuktype07";
    public static final String ZTYMVANONEV07            = "ztymvanonev07";
    public static final String ZTYMVANONEKAISIINNUMUKBN08 = "ztymvanonekaisiinnumukbn08";
    public static final String ZTYMVANONENENOUTOUYM08   = "ztymvanonenenoutouym08";
    public static final String ZTYMVANONEWTUKTYPE08     = "ztymvanonewtuktype08";
    public static final String ZTYMVANONEW08            = "ztymvanonew08";
    public static final String ZTYMVANONEWYENTUKTYPE08  = "ztymvanonewyentuktype08";
    public static final String ZTYMVANONEWYENDAKA08     = "ztymvanonewyendaka08";
    public static final String ZTYMVANONEWYENKIJYUN08   = "ztymvanonewyenkijyun08";
    public static final String ZTYMVANONEWYENYASU08     = "ztymvanonewyenyasu08";
    public static final String ZTYMVANONEUMYENDAKA08    = "ztymvanoneumyendaka08";
    public static final String ZTYMVANONEUMYENKIJYUN08  = "ztymvanoneumyenkijyun08";
    public static final String ZTYMVANONEUMYENYASU08    = "ztymvanoneumyenyasu08";
    public static final String ZTYMVANONEVTUKTYPE08     = "ztymvanonevtuktype08";
    public static final String ZTYMVANONEV08            = "ztymvanonev08";
    public static final String ZTYMVANONEKAISIINNUMUKBN09 = "ztymvanonekaisiinnumukbn09";
    public static final String ZTYMVANONENENOUTOUYM09   = "ztymvanonenenoutouym09";
    public static final String ZTYMVANONEWTUKTYPE09     = "ztymvanonewtuktype09";
    public static final String ZTYMVANONEW09            = "ztymvanonew09";
    public static final String ZTYMVANONEWYENTUKTYPE09  = "ztymvanonewyentuktype09";
    public static final String ZTYMVANONEWYENDAKA09     = "ztymvanonewyendaka09";
    public static final String ZTYMVANONEWYENKIJYUN09   = "ztymvanonewyenkijyun09";
    public static final String ZTYMVANONEWYENYASU09     = "ztymvanonewyenyasu09";
    public static final String ZTYMVANONEUMYENDAKA09    = "ztymvanoneumyendaka09";
    public static final String ZTYMVANONEUMYENKIJYUN09  = "ztymvanoneumyenkijyun09";
    public static final String ZTYMVANONEUMYENYASU09    = "ztymvanoneumyenyasu09";
    public static final String ZTYMVANONEVTUKTYPE09     = "ztymvanonevtuktype09";
    public static final String ZTYMVANONEV09            = "ztymvanonev09";
    public static final String ZTYMVANONEKAISIINNUMUKBN10 = "ztymvanonekaisiinnumukbn10";
    public static final String ZTYMVANONENENOUTOUYM10   = "ztymvanonenenoutouym10";
    public static final String ZTYMVANONEWTUKTYPE10     = "ztymvanonewtuktype10";
    public static final String ZTYMVANONEW10            = "ztymvanonew10";
    public static final String ZTYMVANONEWYENTUKTYPE10  = "ztymvanonewyentuktype10";
    public static final String ZTYMVANONEWYENDAKA10     = "ztymvanonewyendaka10";
    public static final String ZTYMVANONEWYENKIJYUN10   = "ztymvanonewyenkijyun10";
    public static final String ZTYMVANONEWYENYASU10     = "ztymvanonewyenyasu10";
    public static final String ZTYMVANONEUMYENDAKA10    = "ztymvanoneumyendaka10";
    public static final String ZTYMVANONEUMYENKIJYUN10  = "ztymvanoneumyenkijyun10";
    public static final String ZTYMVANONEUMYENYASU10    = "ztymvanoneumyenyasu10";
    public static final String ZTYMVANONEVTUKTYPE10     = "ztymvanonevtuktype10";
    public static final String ZTYMVANONEV10            = "ztymvanonev10";
    public static final String ZTYMVANONEKAISIINNUMUKBN11 = "ztymvanonekaisiinnumukbn11";
    public static final String ZTYMVANONENENOUTOUYM11   = "ztymvanonenenoutouym11";
    public static final String ZTYMVANONEWTUKTYPE11     = "ztymvanonewtuktype11";
    public static final String ZTYMVANONEW11            = "ztymvanonew11";
    public static final String ZTYMVANONEWYENTUKTYPE11  = "ztymvanonewyentuktype11";
    public static final String ZTYMVANONEWYENDAKA11     = "ztymvanonewyendaka11";
    public static final String ZTYMVANONEWYENKIJYUN11   = "ztymvanonewyenkijyun11";
    public static final String ZTYMVANONEWYENYASU11     = "ztymvanonewyenyasu11";
    public static final String ZTYMVANONEUMYENDAKA11    = "ztymvanoneumyendaka11";
    public static final String ZTYMVANONEUMYENKIJYUN11  = "ztymvanoneumyenkijyun11";
    public static final String ZTYMVANONEUMYENYASU11    = "ztymvanoneumyenyasu11";
    public static final String ZTYMVANONEVTUKTYPE11     = "ztymvanonevtuktype11";
    public static final String ZTYMVANONEV11            = "ztymvanonev11";
    public static final String ZTYMVANONEKAISIINNUMUKBN12 = "ztymvanonekaisiinnumukbn12";
    public static final String ZTYMVANONENENOUTOUYM12   = "ztymvanonenenoutouym12";
    public static final String ZTYMVANONEWTUKTYPE12     = "ztymvanonewtuktype12";
    public static final String ZTYMVANONEW12            = "ztymvanonew12";
    public static final String ZTYMVANONEWYENTUKTYPE12  = "ztymvanonewyentuktype12";
    public static final String ZTYMVANONEWYENDAKA12     = "ztymvanonewyendaka12";
    public static final String ZTYMVANONEWYENKIJYUN12   = "ztymvanonewyenkijyun12";
    public static final String ZTYMVANONEWYENYASU12     = "ztymvanonewyenyasu12";
    public static final String ZTYMVANONEUMYENDAKA12    = "ztymvanoneumyendaka12";
    public static final String ZTYMVANONEUMYENKIJYUN12  = "ztymvanoneumyenkijyun12";
    public static final String ZTYMVANONEUMYENYASU12    = "ztymvanoneumyenyasu12";
    public static final String ZTYMVANONEVTUKTYPE12     = "ztymvanonevtuktype12";
    public static final String ZTYMVANONEV12            = "ztymvanonev12";
    public static final String ZTYMVANONEKAISIINNUMUKBN13 = "ztymvanonekaisiinnumukbn13";
    public static final String ZTYMVANONENENOUTOUYM13   = "ztymvanonenenoutouym13";
    public static final String ZTYMVANONEWTUKTYPE13     = "ztymvanonewtuktype13";
    public static final String ZTYMVANONEW13            = "ztymvanonew13";
    public static final String ZTYMVANONEWYENTUKTYPE13  = "ztymvanonewyentuktype13";
    public static final String ZTYMVANONEWYENDAKA13     = "ztymvanonewyendaka13";
    public static final String ZTYMVANONEWYENKIJYUN13   = "ztymvanonewyenkijyun13";
    public static final String ZTYMVANONEWYENYASU13     = "ztymvanonewyenyasu13";
    public static final String ZTYMVANONEUMYENDAKA13    = "ztymvanoneumyendaka13";
    public static final String ZTYMVANONEUMYENKIJYUN13  = "ztymvanoneumyenkijyun13";
    public static final String ZTYMVANONEUMYENYASU13    = "ztymvanoneumyenyasu13";
    public static final String ZTYMVANONEVTUKTYPE13     = "ztymvanonevtuktype13";
    public static final String ZTYMVANONEV13            = "ztymvanonev13";
    public static final String ZTYMVANONEKAISIINNUMUKBN14 = "ztymvanonekaisiinnumukbn14";
    public static final String ZTYMVANONENENOUTOUYM14   = "ztymvanonenenoutouym14";
    public static final String ZTYMVANONEWTUKTYPE14     = "ztymvanonewtuktype14";
    public static final String ZTYMVANONEW14            = "ztymvanonew14";
    public static final String ZTYMVANONEWYENTUKTYPE14  = "ztymvanonewyentuktype14";
    public static final String ZTYMVANONEWYENDAKA14     = "ztymvanonewyendaka14";
    public static final String ZTYMVANONEWYENKIJYUN14   = "ztymvanonewyenkijyun14";
    public static final String ZTYMVANONEWYENYASU14     = "ztymvanonewyenyasu14";
    public static final String ZTYMVANONEUMYENDAKA14    = "ztymvanoneumyendaka14";
    public static final String ZTYMVANONEUMYENKIJYUN14  = "ztymvanoneumyenkijyun14";
    public static final String ZTYMVANONEUMYENYASU14    = "ztymvanoneumyenyasu14";
    public static final String ZTYMVANONEVTUKTYPE14     = "ztymvanonevtuktype14";
    public static final String ZTYMVANONEV14            = "ztymvanonev14";
    public static final String ZTYWMSGCD1               = "ztywmsgcd1";
    public static final String ZTYWMSGCD2               = "ztywmsgcd2";
    public static final String ZTYWMSGCD3               = "ztywmsgcd3";
    public static final String ZTYWMSGCD21              = "ztywmsgcd21";
    public static final String ZTYWMSGCD22              = "ztywmsgcd22";
    public static final String ZTYWMSGCD23              = "ztywmsgcd23";
    public static final String ZTYWMSGCD31              = "ztywmsgcd31";
    public static final String ZTYWMSGCD32              = "ztywmsgcd32";
    public static final String ZTYWMSGCD33              = "ztywmsgcd33";
    public static final String ZTYWMSGCDST1             = "ztywmsgcdst1";
    public static final String ZTYWTYUUIMSGCD1          = "ztywtyuuimsgcd1";
    public static final String ZTYWTYUUIMSGCD2          = "ztywtyuuimsgcd2";
    public static final String ZTYWTYUUIMSGCD3          = "ztywtyuuimsgcd3";
    public static final String ZTYWTYUUIMSGCD4          = "ztywtyuuimsgcd4";
    public static final String ZTYWTYUUIMSGCD5          = "ztywtyuuimsgcd5";
    public static final String ZTYWTYUUIMSGCD6          = "ztywtyuuimsgcd6";
    public static final String ZTYWTYUUIMSGCD7          = "ztywtyuuimsgcd7";
    public static final String ZTYWITJBRPTUUKTYPE       = "ztywitjbrptuuktype";
    public static final String ZTYWITJBRP               = "ztywitjbrp";
    public static final String ZTYWYENHRIKMGKTUUKTYPE   = "ztywyenhrikmgktuuktype";
    public static final String ZTYWYENHRIKMGK           = "ztywyenhrikmgk";
    public static final String ZTYWYENITJBRPTUUKTYPE    = "ztywyenitjbrptuuktype";
    public static final String ZTYWYENITJBRP            = "ztywyenitjbrp";
    public static final String ZTYWSJKKKTYOUSEITKYUYM   = "ztywsjkkktyouseitkyuym";
    public static final String ZTYHRKKKNMNRYYM          = "ztyhrkkknmnryym";
    public static final String ZTYHRKKKNMNRYNEN         = "ztyhrkkknmnrynen";
    public static final String ZTYYOBIV200              = "ztyyobiv200";
    public static final String ZTYYOBIV49               = "ztyyobiv49";

    private final PKZT_SaihakkouSyoukenSuiiTy primaryKey;

    public GenZT_SaihakkouSyoukenSuiiTy() {
        primaryKey = new PKZT_SaihakkouSyoukenSuiiTy();
    }

    public GenZT_SaihakkouSyoukenSuiiTy(
        String pZtysyono,
        String pZtytyouhyouymd,
        String pZtysuiihyouptn
    ) {
        primaryKey = new PKZT_SaihakkouSyoukenSuiiTy(
            pZtysyono,
            pZtytyouhyouymd,
            pZtysuiihyouptn
        );
    }

    @Transient
    @Override
    public PKZT_SaihakkouSyoukenSuiiTy getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QZT_SaihakkouSyoukenSuiiTy> getMetaClass() {
        return QZT_SaihakkouSyoukenSuiiTy.class;
    }

    @Id
    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYSYONO)
    public String getZtysyono() {
        return getPrimaryKey().getZtysyono();
    }

    public void setZtysyono(String pZtysyono) {
        getPrimaryKey().setZtysyono(pZtysyono);
    }

    @Id
    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYTYOUHYOUYMD)
    public String getZtytyouhyouymd() {
        return getPrimaryKey().getZtytyouhyouymd();
    }

    public void setZtytyouhyouymd(String pZtytyouhyouymd) {
        getPrimaryKey().setZtytyouhyouymd(pZtytyouhyouymd);
    }

    @Id
    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYSUIIHYOUPTN)
    public String getZtysuiihyouptn() {
        return getPrimaryKey().getZtysuiihyouptn();
    }

    public void setZtysuiihyouptn(String pZtysuiihyouptn) {
        getPrimaryKey().setZtysuiihyouptn(pZtysuiihyouptn);
    }

    private String ztysuiihyousykbn;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYSUIIHYOUSYKBN)
    public String getZtysuiihyousykbn() {
        return ztysuiihyousykbn;
    }

    public void setZtysuiihyousykbn(String pZtysuiihyousykbn) {
        ztysuiihyousykbn = pZtysuiihyousykbn;
    }

    private String ztysuiihyousyono;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYSUIIHYOUSYONO)
    public String getZtysuiihyousyono() {
        return ztysuiihyousyono;
    }

    public void setZtysuiihyousyono(String pZtysuiihyousyono) {
        ztysuiihyousyono = pZtysuiihyousyono;
    }

    private String ztysisuuupritu;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYSISUUUPRITU)
    public String getZtysisuuupritu() {
        return ztysisuuupritu;
    }

    @DataConvert("toMultiByte")
    public void setZtysisuuupritu(String pZtysisuuupritu) {
        ztysisuuupritu = pZtysisuuupritu;
    }

    private String ztysaisyuunndym;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYSAISYUUNNDYM)
    public String getZtysaisyuunndym() {
        return ztysaisyuunndym;
    }

    public void setZtysaisyuunndym(String pZtysaisyuunndym) {
        ztysaisyuunndym = pZtysaisyuunndym;
    }

    private String ztysjkkktusirrtup;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYSJKKKTUSIRRTUP)
    public String getZtysjkkktusirrtup() {
        return ztysjkkktusirrtup;
    }

    public void setZtysjkkktusirrtup(String pZtysjkkktusirrtup) {
        ztysjkkktusirrtup = pZtysjkkktusirrtup;
    }

    private String ztysjkkktusirrtsame;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYSJKKKTUSIRRTSAME)
    public String getZtysjkkktusirrtsame() {
        return ztysjkkktusirrtsame;
    }

    public void setZtysjkkktusirrtsame(String pZtysjkkktusirrtsame) {
        ztysjkkktusirrtsame = pZtysjkkktusirrtsame;
    }

    private String ztysjkkktusirrtdown;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYSJKKKTUSIRRTDOWN)
    public String getZtysjkkktusirrtdown() {
        return ztysjkkktusirrtdown;
    }

    public void setZtysjkkktusirrtdown(String pZtysjkkktusirrtdown) {
        ztysjkkktusirrtdown = pZtysjkkktusirrtdown;
    }

    private String ztysjkkktusirrthendouup;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYSJKKKTUSIRRTHENDOUUP)
    public String getZtysjkkktusirrthendouup() {
        return ztysjkkktusirrthendouup;
    }

    public void setZtysjkkktusirrthendouup(String pZtysjkkktusirrthendouup) {
        ztysjkkktusirrthendouup = pZtysjkkktusirrthendouup;
    }

    private String ztysjkkktusirrthendoudown;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYSJKKKTUSIRRTHENDOUDOWN)
    public String getZtysjkkktusirrthendoudown() {
        return ztysjkkktusirrthendoudown;
    }

    public void setZtysjkkktusirrthendoudown(String pZtysjkkktusirrthendoudown) {
        ztysjkkktusirrthendoudown = pZtysjkkktusirrthendoudown;
    }

    private String ztywkwsrateyendaka;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYWKWSRATEYENDAKA)
    public String getZtywkwsrateyendaka() {
        return ztywkwsrateyendaka;
    }

    public void setZtywkwsrateyendaka(String pZtywkwsrateyendaka) {
        ztywkwsrateyendaka = pZtywkwsrateyendaka;
    }

    private String ztywkwsrateyenkijyun;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYWKWSRATEYENKIJYUN)
    public String getZtywkwsrateyenkijyun() {
        return ztywkwsrateyenkijyun;
    }

    public void setZtywkwsrateyenkijyun(String pZtywkwsrateyenkijyun) {
        ztywkwsrateyenkijyun = pZtywkwsrateyenkijyun;
    }

    private String ztywkwsrateyenyasu;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYWKWSRATEYENYASU)
    public String getZtywkwsrateyenyasu() {
        return ztywkwsrateyenyasu;
    }

    public void setZtywkwsrateyenyasu(String pZtywkwsrateyenyasu) {
        ztywkwsrateyenyasu = pZtywkwsrateyenyasu;
    }

    private String ztysuiihyoumkhyouyenwra;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYSUIIHYOUMKHYOUYENWRA)
    public String getZtysuiihyoumkhyouyenwra() {
        return ztysuiihyoumkhyouyenwra;
    }

    public void setZtysuiihyoumkhyouyenwra(String pZtysuiihyoumkhyouyenwra) {
        ztysuiihyoumkhyouyenwra = pZtysuiihyoumkhyouyenwra;
    }

    private String ztymvaarinenoutouym01;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARINENOUTOUYM01)
    public String getZtymvaarinenoutouym01() {
        return ztymvaarinenoutouym01;
    }

    public void setZtymvaarinenoutouym01(String pZtymvaarinenoutouym01) {
        ztymvaarinenoutouym01 = pZtymvaarinenoutouym01;
    }

    private String ztymvaarisisuuupritu01;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARISISUUUPRITU01)
    public String getZtymvaarisisuuupritu01() {
        return ztymvaarisisuuupritu01;
    }

    @DataConvert("toMultiByte")
    public void setZtymvaarisisuuupritu01(String pZtymvaarisisuuupritu01) {
        ztymvaarisisuuupritu01 = pZtymvaarisisuuupritu01;
    }

    private String ztymvaaritmttknzkritu01;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARITMTTKNZKRITU01)
    public String getZtymvaaritmttknzkritu01() {
        return ztymvaaritmttknzkritu01;
    }

    @DataConvert("toMultiByte")
    public void setZtymvaaritmttknzkritu01(String pZtymvaaritmttknzkritu01) {
        ztymvaaritmttknzkritu01 = pZtymvaaritmttknzkritu01;
    }

    private String ztymvaariwtuktypeup01;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARIWTUKTYPEUP01)
    public String getZtymvaariwtuktypeup01() {
        return ztymvaariwtuktypeup01;
    }

    public void setZtymvaariwtuktypeup01(String pZtymvaariwtuktypeup01) {
        ztymvaariwtuktypeup01 = pZtymvaariwtuktypeup01;
    }

    private String ztymvaaritmttknkykkjmup01;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARITMTTKNKYKKJMUP01)
    public String getZtymvaaritmttknkykkjmup01() {
        return ztymvaaritmttknkykkjmup01;
    }

    public void setZtymvaaritmttknkykkjmup01(String pZtymvaaritmttknkykkjmup01) {
        ztymvaaritmttknkykkjmup01 = pZtymvaaritmttknkykkjmup01;
    }

    private String ztymvaariwup01;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARIWUP01)
    public String getZtymvaariwup01() {
        return ztymvaariwup01;
    }

    public void setZtymvaariwup01(String pZtymvaariwup01) {
        ztymvaariwup01 = pZtymvaariwup01;
    }

    private String ztymvaariwyentuktypeup01;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARIWYENTUKTYPEUP01)
    public String getZtymvaariwyentuktypeup01() {
        return ztymvaariwyentuktypeup01;
    }

    public void setZtymvaariwyentuktypeup01(String pZtymvaariwyentuktypeup01) {
        ztymvaariwyentuktypeup01 = pZtymvaariwyentuktypeup01;
    }

    private String ztymvaariwupyendaka01;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARIWUPYENDAKA01)
    public String getZtymvaariwupyendaka01() {
        return ztymvaariwupyendaka01;
    }

    public void setZtymvaariwupyendaka01(String pZtymvaariwupyendaka01) {
        ztymvaariwupyendaka01 = pZtymvaariwupyendaka01;
    }

    private String ztymvaariwupyenkijyun01;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARIWUPYENKIJYUN01)
    public String getZtymvaariwupyenkijyun01() {
        return ztymvaariwupyenkijyun01;
    }

    public void setZtymvaariwupyenkijyun01(String pZtymvaariwupyenkijyun01) {
        ztymvaariwupyenkijyun01 = pZtymvaariwupyenkijyun01;
    }

    private String ztymvaariwupyenyasu01;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARIWUPYENYASU01)
    public String getZtymvaariwupyenyasu01() {
        return ztymvaariwupyenyasu01;
    }

    public void setZtymvaariwupyenyasu01(String pZtymvaariwupyenyasu01) {
        ztymvaariwupyenyasu01 = pZtymvaariwupyenyasu01;
    }

    private String ztymvaariwumupyendaka01;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARIWUMUPYENDAKA01)
    public String getZtymvaariwumupyendaka01() {
        return ztymvaariwumupyendaka01;
    }

    public void setZtymvaariwumupyendaka01(String pZtymvaariwumupyendaka01) {
        ztymvaariwumupyendaka01 = pZtymvaariwumupyendaka01;
    }

    private String ztymvaariumupyenkijyun01;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARIUMUPYENKIJYUN01)
    public String getZtymvaariumupyenkijyun01() {
        return ztymvaariumupyenkijyun01;
    }

    public void setZtymvaariumupyenkijyun01(String pZtymvaariumupyenkijyun01) {
        ztymvaariumupyenkijyun01 = pZtymvaariumupyenkijyun01;
    }

    private String ztymvaariumupyenyasu01;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARIUMUPYENYASU01)
    public String getZtymvaariumupyenyasu01() {
        return ztymvaariumupyenyasu01;
    }

    public void setZtymvaariumupyenyasu01(String pZtymvaariumupyenyasu01) {
        ztymvaariumupyenyasu01 = pZtymvaariumupyenyasu01;
    }

    private String ztymvaariwtuktypesame01;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARIWTUKTYPESAME01)
    public String getZtymvaariwtuktypesame01() {
        return ztymvaariwtuktypesame01;
    }

    public void setZtymvaariwtuktypesame01(String pZtymvaariwtuktypesame01) {
        ztymvaariwtuktypesame01 = pZtymvaariwtuktypesame01;
    }

    private String ztymvaaritmttknkykkjmsame01;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARITMTTKNKYKKJMSAME01)
    public String getZtymvaaritmttknkykkjmsame01() {
        return ztymvaaritmttknkykkjmsame01;
    }

    public void setZtymvaaritmttknkykkjmsame01(String pZtymvaaritmttknkykkjmsame01) {
        ztymvaaritmttknkykkjmsame01 = pZtymvaaritmttknkykkjmsame01;
    }

    private String ztymvaariwsame01;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARIWSAME01)
    public String getZtymvaariwsame01() {
        return ztymvaariwsame01;
    }

    public void setZtymvaariwsame01(String pZtymvaariwsame01) {
        ztymvaariwsame01 = pZtymvaariwsame01;
    }

    private String ztymvaariwyentuktypesame01;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARIWYENTUKTYPESAME01)
    public String getZtymvaariwyentuktypesame01() {
        return ztymvaariwyentuktypesame01;
    }

    public void setZtymvaariwyentuktypesame01(String pZtymvaariwyentuktypesame01) {
        ztymvaariwyentuktypesame01 = pZtymvaariwyentuktypesame01;
    }

    private String ztymvaariwsameyendaka01;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARIWSAMEYENDAKA01)
    public String getZtymvaariwsameyendaka01() {
        return ztymvaariwsameyendaka01;
    }

    public void setZtymvaariwsameyendaka01(String pZtymvaariwsameyendaka01) {
        ztymvaariwsameyendaka01 = pZtymvaariwsameyendaka01;
    }

    private String ztymvaariwsameyenkijyun01;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARIWSAMEYENKIJYUN01)
    public String getZtymvaariwsameyenkijyun01() {
        return ztymvaariwsameyenkijyun01;
    }

    public void setZtymvaariwsameyenkijyun01(String pZtymvaariwsameyenkijyun01) {
        ztymvaariwsameyenkijyun01 = pZtymvaariwsameyenkijyun01;
    }

    private String ztymvaariwsameyenyasu01;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARIWSAMEYENYASU01)
    public String getZtymvaariwsameyenyasu01() {
        return ztymvaariwsameyenyasu01;
    }

    public void setZtymvaariwsameyenyasu01(String pZtymvaariwsameyenyasu01) {
        ztymvaariwsameyenyasu01 = pZtymvaariwsameyenyasu01;
    }

    private String ztymvaariumsameyendaka01;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARIUMSAMEYENDAKA01)
    public String getZtymvaariumsameyendaka01() {
        return ztymvaariumsameyendaka01;
    }

    public void setZtymvaariumsameyendaka01(String pZtymvaariumsameyendaka01) {
        ztymvaariumsameyendaka01 = pZtymvaariumsameyendaka01;
    }

    private String ztymvaariumsameyenkijyun01;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARIUMSAMEYENKIJYUN01)
    public String getZtymvaariumsameyenkijyun01() {
        return ztymvaariumsameyenkijyun01;
    }

    public void setZtymvaariumsameyenkijyun01(String pZtymvaariumsameyenkijyun01) {
        ztymvaariumsameyenkijyun01 = pZtymvaariumsameyenkijyun01;
    }

    private String ztymvaariumsameyenyasu01;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARIUMSAMEYENYASU01)
    public String getZtymvaariumsameyenyasu01() {
        return ztymvaariumsameyenyasu01;
    }

    public void setZtymvaariumsameyenyasu01(String pZtymvaariumsameyenyasu01) {
        ztymvaariumsameyenyasu01 = pZtymvaariumsameyenyasu01;
    }

    private String ztymvaariwtuktypedown01;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARIWTUKTYPEDOWN01)
    public String getZtymvaariwtuktypedown01() {
        return ztymvaariwtuktypedown01;
    }

    public void setZtymvaariwtuktypedown01(String pZtymvaariwtuktypedown01) {
        ztymvaariwtuktypedown01 = pZtymvaariwtuktypedown01;
    }

    private String ztymvaaritmttknkykkjmdown01;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARITMTTKNKYKKJMDOWN01)
    public String getZtymvaaritmttknkykkjmdown01() {
        return ztymvaaritmttknkykkjmdown01;
    }

    public void setZtymvaaritmttknkykkjmdown01(String pZtymvaaritmttknkykkjmdown01) {
        ztymvaaritmttknkykkjmdown01 = pZtymvaaritmttknkykkjmdown01;
    }

    private String ztymvaariwdown01;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARIWDOWN01)
    public String getZtymvaariwdown01() {
        return ztymvaariwdown01;
    }

    public void setZtymvaariwdown01(String pZtymvaariwdown01) {
        ztymvaariwdown01 = pZtymvaariwdown01;
    }

    private String ztymvaariwyentuktypedown01;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARIWYENTUKTYPEDOWN01)
    public String getZtymvaariwyentuktypedown01() {
        return ztymvaariwyentuktypedown01;
    }

    public void setZtymvaariwyentuktypedown01(String pZtymvaariwyentuktypedown01) {
        ztymvaariwyentuktypedown01 = pZtymvaariwyentuktypedown01;
    }

    private String ztymvaariwdownyendaka01;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARIWDOWNYENDAKA01)
    public String getZtymvaariwdownyendaka01() {
        return ztymvaariwdownyendaka01;
    }

    public void setZtymvaariwdownyendaka01(String pZtymvaariwdownyendaka01) {
        ztymvaariwdownyendaka01 = pZtymvaariwdownyendaka01;
    }

    private String ztymvaariwdownyenkijyun01;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARIWDOWNYENKIJYUN01)
    public String getZtymvaariwdownyenkijyun01() {
        return ztymvaariwdownyenkijyun01;
    }

    public void setZtymvaariwdownyenkijyun01(String pZtymvaariwdownyenkijyun01) {
        ztymvaariwdownyenkijyun01 = pZtymvaariwdownyenkijyun01;
    }

    private String ztymvaariwdownyenyasu01;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARIWDOWNYENYASU01)
    public String getZtymvaariwdownyenyasu01() {
        return ztymvaariwdownyenyasu01;
    }

    public void setZtymvaariwdownyenyasu01(String pZtymvaariwdownyenyasu01) {
        ztymvaariwdownyenyasu01 = pZtymvaariwdownyenyasu01;
    }

    private String ztymvaariumdownyendaka01;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARIUMDOWNYENDAKA01)
    public String getZtymvaariumdownyendaka01() {
        return ztymvaariumdownyendaka01;
    }

    public void setZtymvaariumdownyendaka01(String pZtymvaariumdownyendaka01) {
        ztymvaariumdownyendaka01 = pZtymvaariumdownyendaka01;
    }

    private String ztymvaariumdownyenkijyun01;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARIUMDOWNYENKIJYUN01)
    public String getZtymvaariumdownyenkijyun01() {
        return ztymvaariumdownyenkijyun01;
    }

    public void setZtymvaariumdownyenkijyun01(String pZtymvaariumdownyenkijyun01) {
        ztymvaariumdownyenkijyun01 = pZtymvaariumdownyenkijyun01;
    }

    private String ztymvaariumdownyenyasu01;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARIUMDOWNYENYASU01)
    public String getZtymvaariumdownyenyasu01() {
        return ztymvaariumdownyenyasu01;
    }

    public void setZtymvaariumdownyenyasu01(String pZtymvaariumdownyenyasu01) {
        ztymvaariumdownyenyasu01 = pZtymvaariumdownyenyasu01;
    }

    private String ztymvaarivtuktype01;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARIVTUKTYPE01)
    public String getZtymvaarivtuktype01() {
        return ztymvaarivtuktype01;
    }

    public void setZtymvaarivtuktype01(String pZtymvaarivtuktype01) {
        ztymvaarivtuktype01 = pZtymvaarivtuktype01;
    }

    private String ztymvaariv01;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARIV01)
    public String getZtymvaariv01() {
        return ztymvaariv01;
    }

    public void setZtymvaariv01(String pZtymvaariv01) {
        ztymvaariv01 = pZtymvaariv01;
    }

    private String ztyptmttkngkutiwake101;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYPTMTTKNGKUTIWAKE101)
    public String getZtyptmttkngkutiwake101() {
        return ztyptmttkngkutiwake101;
    }

    public void setZtyptmttkngkutiwake101(String pZtyptmttkngkutiwake101) {
        ztyptmttkngkutiwake101 = pZtyptmttkngkutiwake101;
    }

    private String ztyptmttkngkutiwake201;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYPTMTTKNGKUTIWAKE201)
    public String getZtyptmttkngkutiwake201() {
        return ztyptmttkngkutiwake201;
    }

    public void setZtyptmttkngkutiwake201(String pZtyptmttkngkutiwake201) {
        ztyptmttkngkutiwake201 = pZtyptmttkngkutiwake201;
    }

    private String ztymvaarinenoutouym02;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARINENOUTOUYM02)
    public String getZtymvaarinenoutouym02() {
        return ztymvaarinenoutouym02;
    }

    public void setZtymvaarinenoutouym02(String pZtymvaarinenoutouym02) {
        ztymvaarinenoutouym02 = pZtymvaarinenoutouym02;
    }

    private String ztymvaarisisuuupritu02;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARISISUUUPRITU02)
    public String getZtymvaarisisuuupritu02() {
        return ztymvaarisisuuupritu02;
    }

    @DataConvert("toMultiByte")
    public void setZtymvaarisisuuupritu02(String pZtymvaarisisuuupritu02) {
        ztymvaarisisuuupritu02 = pZtymvaarisisuuupritu02;
    }

    private String ztymvaaritmttknzkritu02;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARITMTTKNZKRITU02)
    public String getZtymvaaritmttknzkritu02() {
        return ztymvaaritmttknzkritu02;
    }

    @DataConvert("toMultiByte")
    public void setZtymvaaritmttknzkritu02(String pZtymvaaritmttknzkritu02) {
        ztymvaaritmttknzkritu02 = pZtymvaaritmttknzkritu02;
    }

    private String ztymvaariwtuktypeup02;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARIWTUKTYPEUP02)
    public String getZtymvaariwtuktypeup02() {
        return ztymvaariwtuktypeup02;
    }

    public void setZtymvaariwtuktypeup02(String pZtymvaariwtuktypeup02) {
        ztymvaariwtuktypeup02 = pZtymvaariwtuktypeup02;
    }

    private String ztymvaaritmttknkykkjmup02;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARITMTTKNKYKKJMUP02)
    public String getZtymvaaritmttknkykkjmup02() {
        return ztymvaaritmttknkykkjmup02;
    }

    public void setZtymvaaritmttknkykkjmup02(String pZtymvaaritmttknkykkjmup02) {
        ztymvaaritmttknkykkjmup02 = pZtymvaaritmttknkykkjmup02;
    }

    private String ztymvaariwup02;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARIWUP02)
    public String getZtymvaariwup02() {
        return ztymvaariwup02;
    }

    public void setZtymvaariwup02(String pZtymvaariwup02) {
        ztymvaariwup02 = pZtymvaariwup02;
    }

    private String ztymvaariwyentuktypeup02;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARIWYENTUKTYPEUP02)
    public String getZtymvaariwyentuktypeup02() {
        return ztymvaariwyentuktypeup02;
    }

    public void setZtymvaariwyentuktypeup02(String pZtymvaariwyentuktypeup02) {
        ztymvaariwyentuktypeup02 = pZtymvaariwyentuktypeup02;
    }

    private String ztymvaariwupyendaka02;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARIWUPYENDAKA02)
    public String getZtymvaariwupyendaka02() {
        return ztymvaariwupyendaka02;
    }

    public void setZtymvaariwupyendaka02(String pZtymvaariwupyendaka02) {
        ztymvaariwupyendaka02 = pZtymvaariwupyendaka02;
    }

    private String ztymvaariwupyenkijyun02;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARIWUPYENKIJYUN02)
    public String getZtymvaariwupyenkijyun02() {
        return ztymvaariwupyenkijyun02;
    }

    public void setZtymvaariwupyenkijyun02(String pZtymvaariwupyenkijyun02) {
        ztymvaariwupyenkijyun02 = pZtymvaariwupyenkijyun02;
    }

    private String ztymvaariwupyenyasu02;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARIWUPYENYASU02)
    public String getZtymvaariwupyenyasu02() {
        return ztymvaariwupyenyasu02;
    }

    public void setZtymvaariwupyenyasu02(String pZtymvaariwupyenyasu02) {
        ztymvaariwupyenyasu02 = pZtymvaariwupyenyasu02;
    }

    private String ztymvaariwumupyendaka02;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARIWUMUPYENDAKA02)
    public String getZtymvaariwumupyendaka02() {
        return ztymvaariwumupyendaka02;
    }

    public void setZtymvaariwumupyendaka02(String pZtymvaariwumupyendaka02) {
        ztymvaariwumupyendaka02 = pZtymvaariwumupyendaka02;
    }

    private String ztymvaariumupyenkijyun02;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARIUMUPYENKIJYUN02)
    public String getZtymvaariumupyenkijyun02() {
        return ztymvaariumupyenkijyun02;
    }

    public void setZtymvaariumupyenkijyun02(String pZtymvaariumupyenkijyun02) {
        ztymvaariumupyenkijyun02 = pZtymvaariumupyenkijyun02;
    }

    private String ztymvaariumupyenyasu02;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARIUMUPYENYASU02)
    public String getZtymvaariumupyenyasu02() {
        return ztymvaariumupyenyasu02;
    }

    public void setZtymvaariumupyenyasu02(String pZtymvaariumupyenyasu02) {
        ztymvaariumupyenyasu02 = pZtymvaariumupyenyasu02;
    }

    private String ztymvaariwtuktypesame02;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARIWTUKTYPESAME02)
    public String getZtymvaariwtuktypesame02() {
        return ztymvaariwtuktypesame02;
    }

    public void setZtymvaariwtuktypesame02(String pZtymvaariwtuktypesame02) {
        ztymvaariwtuktypesame02 = pZtymvaariwtuktypesame02;
    }

    private String ztymvaaritmttknkykkjmsame02;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARITMTTKNKYKKJMSAME02)
    public String getZtymvaaritmttknkykkjmsame02() {
        return ztymvaaritmttknkykkjmsame02;
    }

    public void setZtymvaaritmttknkykkjmsame02(String pZtymvaaritmttknkykkjmsame02) {
        ztymvaaritmttknkykkjmsame02 = pZtymvaaritmttknkykkjmsame02;
    }

    private String ztymvaariwsame02;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARIWSAME02)
    public String getZtymvaariwsame02() {
        return ztymvaariwsame02;
    }

    public void setZtymvaariwsame02(String pZtymvaariwsame02) {
        ztymvaariwsame02 = pZtymvaariwsame02;
    }

    private String ztymvaariwyentuktypesame02;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARIWYENTUKTYPESAME02)
    public String getZtymvaariwyentuktypesame02() {
        return ztymvaariwyentuktypesame02;
    }

    public void setZtymvaariwyentuktypesame02(String pZtymvaariwyentuktypesame02) {
        ztymvaariwyentuktypesame02 = pZtymvaariwyentuktypesame02;
    }

    private String ztymvaariwsameyendaka02;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARIWSAMEYENDAKA02)
    public String getZtymvaariwsameyendaka02() {
        return ztymvaariwsameyendaka02;
    }

    public void setZtymvaariwsameyendaka02(String pZtymvaariwsameyendaka02) {
        ztymvaariwsameyendaka02 = pZtymvaariwsameyendaka02;
    }

    private String ztymvaariwsameyenkijyun02;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARIWSAMEYENKIJYUN02)
    public String getZtymvaariwsameyenkijyun02() {
        return ztymvaariwsameyenkijyun02;
    }

    public void setZtymvaariwsameyenkijyun02(String pZtymvaariwsameyenkijyun02) {
        ztymvaariwsameyenkijyun02 = pZtymvaariwsameyenkijyun02;
    }

    private String ztymvaariwsameyenyasu02;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARIWSAMEYENYASU02)
    public String getZtymvaariwsameyenyasu02() {
        return ztymvaariwsameyenyasu02;
    }

    public void setZtymvaariwsameyenyasu02(String pZtymvaariwsameyenyasu02) {
        ztymvaariwsameyenyasu02 = pZtymvaariwsameyenyasu02;
    }

    private String ztymvaariumsameyendaka02;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARIUMSAMEYENDAKA02)
    public String getZtymvaariumsameyendaka02() {
        return ztymvaariumsameyendaka02;
    }

    public void setZtymvaariumsameyendaka02(String pZtymvaariumsameyendaka02) {
        ztymvaariumsameyendaka02 = pZtymvaariumsameyendaka02;
    }

    private String ztymvaariumsameyenkijyun02;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARIUMSAMEYENKIJYUN02)
    public String getZtymvaariumsameyenkijyun02() {
        return ztymvaariumsameyenkijyun02;
    }

    public void setZtymvaariumsameyenkijyun02(String pZtymvaariumsameyenkijyun02) {
        ztymvaariumsameyenkijyun02 = pZtymvaariumsameyenkijyun02;
    }

    private String ztymvaariumsameyenyasu02;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARIUMSAMEYENYASU02)
    public String getZtymvaariumsameyenyasu02() {
        return ztymvaariumsameyenyasu02;
    }

    public void setZtymvaariumsameyenyasu02(String pZtymvaariumsameyenyasu02) {
        ztymvaariumsameyenyasu02 = pZtymvaariumsameyenyasu02;
    }

    private String ztymvaariwtuktypedown02;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARIWTUKTYPEDOWN02)
    public String getZtymvaariwtuktypedown02() {
        return ztymvaariwtuktypedown02;
    }

    public void setZtymvaariwtuktypedown02(String pZtymvaariwtuktypedown02) {
        ztymvaariwtuktypedown02 = pZtymvaariwtuktypedown02;
    }

    private String ztymvaaritmttknkykkjmdown02;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARITMTTKNKYKKJMDOWN02)
    public String getZtymvaaritmttknkykkjmdown02() {
        return ztymvaaritmttknkykkjmdown02;
    }

    public void setZtymvaaritmttknkykkjmdown02(String pZtymvaaritmttknkykkjmdown02) {
        ztymvaaritmttknkykkjmdown02 = pZtymvaaritmttknkykkjmdown02;
    }

    private String ztymvaariwdown02;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARIWDOWN02)
    public String getZtymvaariwdown02() {
        return ztymvaariwdown02;
    }

    public void setZtymvaariwdown02(String pZtymvaariwdown02) {
        ztymvaariwdown02 = pZtymvaariwdown02;
    }

    private String ztymvaariwyentuktypedown02;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARIWYENTUKTYPEDOWN02)
    public String getZtymvaariwyentuktypedown02() {
        return ztymvaariwyentuktypedown02;
    }

    public void setZtymvaariwyentuktypedown02(String pZtymvaariwyentuktypedown02) {
        ztymvaariwyentuktypedown02 = pZtymvaariwyentuktypedown02;
    }

    private String ztymvaariwdownyendaka02;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARIWDOWNYENDAKA02)
    public String getZtymvaariwdownyendaka02() {
        return ztymvaariwdownyendaka02;
    }

    public void setZtymvaariwdownyendaka02(String pZtymvaariwdownyendaka02) {
        ztymvaariwdownyendaka02 = pZtymvaariwdownyendaka02;
    }

    private String ztymvaariwdownyenkijyun02;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARIWDOWNYENKIJYUN02)
    public String getZtymvaariwdownyenkijyun02() {
        return ztymvaariwdownyenkijyun02;
    }

    public void setZtymvaariwdownyenkijyun02(String pZtymvaariwdownyenkijyun02) {
        ztymvaariwdownyenkijyun02 = pZtymvaariwdownyenkijyun02;
    }

    private String ztymvaariwdownyenyasu02;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARIWDOWNYENYASU02)
    public String getZtymvaariwdownyenyasu02() {
        return ztymvaariwdownyenyasu02;
    }

    public void setZtymvaariwdownyenyasu02(String pZtymvaariwdownyenyasu02) {
        ztymvaariwdownyenyasu02 = pZtymvaariwdownyenyasu02;
    }

    private String ztymvaariumdownyendaka02;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARIUMDOWNYENDAKA02)
    public String getZtymvaariumdownyendaka02() {
        return ztymvaariumdownyendaka02;
    }

    public void setZtymvaariumdownyendaka02(String pZtymvaariumdownyendaka02) {
        ztymvaariumdownyendaka02 = pZtymvaariumdownyendaka02;
    }

    private String ztymvaariumdownyenkijyun02;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARIUMDOWNYENKIJYUN02)
    public String getZtymvaariumdownyenkijyun02() {
        return ztymvaariumdownyenkijyun02;
    }

    public void setZtymvaariumdownyenkijyun02(String pZtymvaariumdownyenkijyun02) {
        ztymvaariumdownyenkijyun02 = pZtymvaariumdownyenkijyun02;
    }

    private String ztymvaariumdownyenyasu02;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARIUMDOWNYENYASU02)
    public String getZtymvaariumdownyenyasu02() {
        return ztymvaariumdownyenyasu02;
    }

    public void setZtymvaariumdownyenyasu02(String pZtymvaariumdownyenyasu02) {
        ztymvaariumdownyenyasu02 = pZtymvaariumdownyenyasu02;
    }

    private String ztymvaarivtuktype02;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARIVTUKTYPE02)
    public String getZtymvaarivtuktype02() {
        return ztymvaarivtuktype02;
    }

    public void setZtymvaarivtuktype02(String pZtymvaarivtuktype02) {
        ztymvaarivtuktype02 = pZtymvaarivtuktype02;
    }

    private String ztymvaariv02;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARIV02)
    public String getZtymvaariv02() {
        return ztymvaariv02;
    }

    public void setZtymvaariv02(String pZtymvaariv02) {
        ztymvaariv02 = pZtymvaariv02;
    }

    private String ztyptmttkngkutiwake102;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYPTMTTKNGKUTIWAKE102)
    public String getZtyptmttkngkutiwake102() {
        return ztyptmttkngkutiwake102;
    }

    public void setZtyptmttkngkutiwake102(String pZtyptmttkngkutiwake102) {
        ztyptmttkngkutiwake102 = pZtyptmttkngkutiwake102;
    }

    private String ztyptmttkngkutiwake202;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYPTMTTKNGKUTIWAKE202)
    public String getZtyptmttkngkutiwake202() {
        return ztyptmttkngkutiwake202;
    }

    public void setZtyptmttkngkutiwake202(String pZtyptmttkngkutiwake202) {
        ztyptmttkngkutiwake202 = pZtyptmttkngkutiwake202;
    }

    private String ztymvaarinenoutouym03;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARINENOUTOUYM03)
    public String getZtymvaarinenoutouym03() {
        return ztymvaarinenoutouym03;
    }

    public void setZtymvaarinenoutouym03(String pZtymvaarinenoutouym03) {
        ztymvaarinenoutouym03 = pZtymvaarinenoutouym03;
    }

    private String ztymvaarisisuuupritu03;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARISISUUUPRITU03)
    public String getZtymvaarisisuuupritu03() {
        return ztymvaarisisuuupritu03;
    }

    @DataConvert("toMultiByte")
    public void setZtymvaarisisuuupritu03(String pZtymvaarisisuuupritu03) {
        ztymvaarisisuuupritu03 = pZtymvaarisisuuupritu03;
    }

    private String ztymvaaritmttknzkritu03;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARITMTTKNZKRITU03)
    public String getZtymvaaritmttknzkritu03() {
        return ztymvaaritmttknzkritu03;
    }

    @DataConvert("toMultiByte")
    public void setZtymvaaritmttknzkritu03(String pZtymvaaritmttknzkritu03) {
        ztymvaaritmttknzkritu03 = pZtymvaaritmttknzkritu03;
    }

    private String ztymvaariwtuktypeup03;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARIWTUKTYPEUP03)
    public String getZtymvaariwtuktypeup03() {
        return ztymvaariwtuktypeup03;
    }

    public void setZtymvaariwtuktypeup03(String pZtymvaariwtuktypeup03) {
        ztymvaariwtuktypeup03 = pZtymvaariwtuktypeup03;
    }

    private String ztymvaaritmttknkykkjmup03;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARITMTTKNKYKKJMUP03)
    public String getZtymvaaritmttknkykkjmup03() {
        return ztymvaaritmttknkykkjmup03;
    }

    public void setZtymvaaritmttknkykkjmup03(String pZtymvaaritmttknkykkjmup03) {
        ztymvaaritmttknkykkjmup03 = pZtymvaaritmttknkykkjmup03;
    }

    private String ztymvaariwup03;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARIWUP03)
    public String getZtymvaariwup03() {
        return ztymvaariwup03;
    }

    public void setZtymvaariwup03(String pZtymvaariwup03) {
        ztymvaariwup03 = pZtymvaariwup03;
    }

    private String ztymvaariwyentuktypeup03;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARIWYENTUKTYPEUP03)
    public String getZtymvaariwyentuktypeup03() {
        return ztymvaariwyentuktypeup03;
    }

    public void setZtymvaariwyentuktypeup03(String pZtymvaariwyentuktypeup03) {
        ztymvaariwyentuktypeup03 = pZtymvaariwyentuktypeup03;
    }

    private String ztymvaariwupyendaka03;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARIWUPYENDAKA03)
    public String getZtymvaariwupyendaka03() {
        return ztymvaariwupyendaka03;
    }

    public void setZtymvaariwupyendaka03(String pZtymvaariwupyendaka03) {
        ztymvaariwupyendaka03 = pZtymvaariwupyendaka03;
    }

    private String ztymvaariwupyenkijyun03;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARIWUPYENKIJYUN03)
    public String getZtymvaariwupyenkijyun03() {
        return ztymvaariwupyenkijyun03;
    }

    public void setZtymvaariwupyenkijyun03(String pZtymvaariwupyenkijyun03) {
        ztymvaariwupyenkijyun03 = pZtymvaariwupyenkijyun03;
    }

    private String ztymvaariwupyenyasu03;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARIWUPYENYASU03)
    public String getZtymvaariwupyenyasu03() {
        return ztymvaariwupyenyasu03;
    }

    public void setZtymvaariwupyenyasu03(String pZtymvaariwupyenyasu03) {
        ztymvaariwupyenyasu03 = pZtymvaariwupyenyasu03;
    }

    private String ztymvaariwumupyendaka03;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARIWUMUPYENDAKA03)
    public String getZtymvaariwumupyendaka03() {
        return ztymvaariwumupyendaka03;
    }

    public void setZtymvaariwumupyendaka03(String pZtymvaariwumupyendaka03) {
        ztymvaariwumupyendaka03 = pZtymvaariwumupyendaka03;
    }

    private String ztymvaariumupyenkijyun03;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARIUMUPYENKIJYUN03)
    public String getZtymvaariumupyenkijyun03() {
        return ztymvaariumupyenkijyun03;
    }

    public void setZtymvaariumupyenkijyun03(String pZtymvaariumupyenkijyun03) {
        ztymvaariumupyenkijyun03 = pZtymvaariumupyenkijyun03;
    }

    private String ztymvaariumupyenyasu03;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARIUMUPYENYASU03)
    public String getZtymvaariumupyenyasu03() {
        return ztymvaariumupyenyasu03;
    }

    public void setZtymvaariumupyenyasu03(String pZtymvaariumupyenyasu03) {
        ztymvaariumupyenyasu03 = pZtymvaariumupyenyasu03;
    }

    private String ztymvaariwtuktypesame03;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARIWTUKTYPESAME03)
    public String getZtymvaariwtuktypesame03() {
        return ztymvaariwtuktypesame03;
    }

    public void setZtymvaariwtuktypesame03(String pZtymvaariwtuktypesame03) {
        ztymvaariwtuktypesame03 = pZtymvaariwtuktypesame03;
    }

    private String ztymvaaritmttknkykkjmsame03;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARITMTTKNKYKKJMSAME03)
    public String getZtymvaaritmttknkykkjmsame03() {
        return ztymvaaritmttknkykkjmsame03;
    }

    public void setZtymvaaritmttknkykkjmsame03(String pZtymvaaritmttknkykkjmsame03) {
        ztymvaaritmttknkykkjmsame03 = pZtymvaaritmttknkykkjmsame03;
    }

    private String ztymvaariwsame03;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARIWSAME03)
    public String getZtymvaariwsame03() {
        return ztymvaariwsame03;
    }

    public void setZtymvaariwsame03(String pZtymvaariwsame03) {
        ztymvaariwsame03 = pZtymvaariwsame03;
    }

    private String ztymvaariwyentuktypesame03;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARIWYENTUKTYPESAME03)
    public String getZtymvaariwyentuktypesame03() {
        return ztymvaariwyentuktypesame03;
    }

    public void setZtymvaariwyentuktypesame03(String pZtymvaariwyentuktypesame03) {
        ztymvaariwyentuktypesame03 = pZtymvaariwyentuktypesame03;
    }

    private String ztymvaariwsameyendaka03;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARIWSAMEYENDAKA03)
    public String getZtymvaariwsameyendaka03() {
        return ztymvaariwsameyendaka03;
    }

    public void setZtymvaariwsameyendaka03(String pZtymvaariwsameyendaka03) {
        ztymvaariwsameyendaka03 = pZtymvaariwsameyendaka03;
    }

    private String ztymvaariwsameyenkijyun03;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARIWSAMEYENKIJYUN03)
    public String getZtymvaariwsameyenkijyun03() {
        return ztymvaariwsameyenkijyun03;
    }

    public void setZtymvaariwsameyenkijyun03(String pZtymvaariwsameyenkijyun03) {
        ztymvaariwsameyenkijyun03 = pZtymvaariwsameyenkijyun03;
    }

    private String ztymvaariwsameyenyasu03;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARIWSAMEYENYASU03)
    public String getZtymvaariwsameyenyasu03() {
        return ztymvaariwsameyenyasu03;
    }

    public void setZtymvaariwsameyenyasu03(String pZtymvaariwsameyenyasu03) {
        ztymvaariwsameyenyasu03 = pZtymvaariwsameyenyasu03;
    }

    private String ztymvaariumsameyendaka03;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARIUMSAMEYENDAKA03)
    public String getZtymvaariumsameyendaka03() {
        return ztymvaariumsameyendaka03;
    }

    public void setZtymvaariumsameyendaka03(String pZtymvaariumsameyendaka03) {
        ztymvaariumsameyendaka03 = pZtymvaariumsameyendaka03;
    }

    private String ztymvaariumsameyenkijyun03;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARIUMSAMEYENKIJYUN03)
    public String getZtymvaariumsameyenkijyun03() {
        return ztymvaariumsameyenkijyun03;
    }

    public void setZtymvaariumsameyenkijyun03(String pZtymvaariumsameyenkijyun03) {
        ztymvaariumsameyenkijyun03 = pZtymvaariumsameyenkijyun03;
    }

    private String ztymvaariumsameyenyasu03;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARIUMSAMEYENYASU03)
    public String getZtymvaariumsameyenyasu03() {
        return ztymvaariumsameyenyasu03;
    }

    public void setZtymvaariumsameyenyasu03(String pZtymvaariumsameyenyasu03) {
        ztymvaariumsameyenyasu03 = pZtymvaariumsameyenyasu03;
    }

    private String ztymvaariwtuktypedown03;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARIWTUKTYPEDOWN03)
    public String getZtymvaariwtuktypedown03() {
        return ztymvaariwtuktypedown03;
    }

    public void setZtymvaariwtuktypedown03(String pZtymvaariwtuktypedown03) {
        ztymvaariwtuktypedown03 = pZtymvaariwtuktypedown03;
    }

    private String ztymvaaritmttknkykkjmdown03;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARITMTTKNKYKKJMDOWN03)
    public String getZtymvaaritmttknkykkjmdown03() {
        return ztymvaaritmttknkykkjmdown03;
    }

    public void setZtymvaaritmttknkykkjmdown03(String pZtymvaaritmttknkykkjmdown03) {
        ztymvaaritmttknkykkjmdown03 = pZtymvaaritmttknkykkjmdown03;
    }

    private String ztymvaariwdown03;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARIWDOWN03)
    public String getZtymvaariwdown03() {
        return ztymvaariwdown03;
    }

    public void setZtymvaariwdown03(String pZtymvaariwdown03) {
        ztymvaariwdown03 = pZtymvaariwdown03;
    }

    private String ztymvaariwyentuktypedown03;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARIWYENTUKTYPEDOWN03)
    public String getZtymvaariwyentuktypedown03() {
        return ztymvaariwyentuktypedown03;
    }

    public void setZtymvaariwyentuktypedown03(String pZtymvaariwyentuktypedown03) {
        ztymvaariwyentuktypedown03 = pZtymvaariwyentuktypedown03;
    }

    private String ztymvaariwdownyendaka03;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARIWDOWNYENDAKA03)
    public String getZtymvaariwdownyendaka03() {
        return ztymvaariwdownyendaka03;
    }

    public void setZtymvaariwdownyendaka03(String pZtymvaariwdownyendaka03) {
        ztymvaariwdownyendaka03 = pZtymvaariwdownyendaka03;
    }

    private String ztymvaariwdownyenkijyun03;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARIWDOWNYENKIJYUN03)
    public String getZtymvaariwdownyenkijyun03() {
        return ztymvaariwdownyenkijyun03;
    }

    public void setZtymvaariwdownyenkijyun03(String pZtymvaariwdownyenkijyun03) {
        ztymvaariwdownyenkijyun03 = pZtymvaariwdownyenkijyun03;
    }

    private String ztymvaariwdownyenyasu03;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARIWDOWNYENYASU03)
    public String getZtymvaariwdownyenyasu03() {
        return ztymvaariwdownyenyasu03;
    }

    public void setZtymvaariwdownyenyasu03(String pZtymvaariwdownyenyasu03) {
        ztymvaariwdownyenyasu03 = pZtymvaariwdownyenyasu03;
    }

    private String ztymvaariumdownyendaka03;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARIUMDOWNYENDAKA03)
    public String getZtymvaariumdownyendaka03() {
        return ztymvaariumdownyendaka03;
    }

    public void setZtymvaariumdownyendaka03(String pZtymvaariumdownyendaka03) {
        ztymvaariumdownyendaka03 = pZtymvaariumdownyendaka03;
    }

    private String ztymvaariumdownyenkijyun03;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARIUMDOWNYENKIJYUN03)
    public String getZtymvaariumdownyenkijyun03() {
        return ztymvaariumdownyenkijyun03;
    }

    public void setZtymvaariumdownyenkijyun03(String pZtymvaariumdownyenkijyun03) {
        ztymvaariumdownyenkijyun03 = pZtymvaariumdownyenkijyun03;
    }

    private String ztymvaariumdownyenyasu03;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARIUMDOWNYENYASU03)
    public String getZtymvaariumdownyenyasu03() {
        return ztymvaariumdownyenyasu03;
    }

    public void setZtymvaariumdownyenyasu03(String pZtymvaariumdownyenyasu03) {
        ztymvaariumdownyenyasu03 = pZtymvaariumdownyenyasu03;
    }

    private String ztymvaarivtuktype03;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARIVTUKTYPE03)
    public String getZtymvaarivtuktype03() {
        return ztymvaarivtuktype03;
    }

    public void setZtymvaarivtuktype03(String pZtymvaarivtuktype03) {
        ztymvaarivtuktype03 = pZtymvaarivtuktype03;
    }

    private String ztymvaariv03;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARIV03)
    public String getZtymvaariv03() {
        return ztymvaariv03;
    }

    public void setZtymvaariv03(String pZtymvaariv03) {
        ztymvaariv03 = pZtymvaariv03;
    }

    private String ztyptmttkngkutiwake103;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYPTMTTKNGKUTIWAKE103)
    public String getZtyptmttkngkutiwake103() {
        return ztyptmttkngkutiwake103;
    }

    public void setZtyptmttkngkutiwake103(String pZtyptmttkngkutiwake103) {
        ztyptmttkngkutiwake103 = pZtyptmttkngkutiwake103;
    }

    private String ztyptmttkngkutiwake203;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYPTMTTKNGKUTIWAKE203)
    public String getZtyptmttkngkutiwake203() {
        return ztyptmttkngkutiwake203;
    }

    public void setZtyptmttkngkutiwake203(String pZtyptmttkngkutiwake203) {
        ztyptmttkngkutiwake203 = pZtyptmttkngkutiwake203;
    }

    private String ztymvaarinenoutouym04;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARINENOUTOUYM04)
    public String getZtymvaarinenoutouym04() {
        return ztymvaarinenoutouym04;
    }

    public void setZtymvaarinenoutouym04(String pZtymvaarinenoutouym04) {
        ztymvaarinenoutouym04 = pZtymvaarinenoutouym04;
    }

    private String ztymvaarisisuuupritu04;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARISISUUUPRITU04)
    public String getZtymvaarisisuuupritu04() {
        return ztymvaarisisuuupritu04;
    }

    @DataConvert("toMultiByte")
    public void setZtymvaarisisuuupritu04(String pZtymvaarisisuuupritu04) {
        ztymvaarisisuuupritu04 = pZtymvaarisisuuupritu04;
    }

    private String ztymvaaritmttknzkritu04;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARITMTTKNZKRITU04)
    public String getZtymvaaritmttknzkritu04() {
        return ztymvaaritmttknzkritu04;
    }

    @DataConvert("toMultiByte")
    public void setZtymvaaritmttknzkritu04(String pZtymvaaritmttknzkritu04) {
        ztymvaaritmttknzkritu04 = pZtymvaaritmttknzkritu04;
    }

    private String ztymvaariwtuktypeup04;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARIWTUKTYPEUP04)
    public String getZtymvaariwtuktypeup04() {
        return ztymvaariwtuktypeup04;
    }

    public void setZtymvaariwtuktypeup04(String pZtymvaariwtuktypeup04) {
        ztymvaariwtuktypeup04 = pZtymvaariwtuktypeup04;
    }

    private String ztymvaaritmttknkykkjmup04;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARITMTTKNKYKKJMUP04)
    public String getZtymvaaritmttknkykkjmup04() {
        return ztymvaaritmttknkykkjmup04;
    }

    public void setZtymvaaritmttknkykkjmup04(String pZtymvaaritmttknkykkjmup04) {
        ztymvaaritmttknkykkjmup04 = pZtymvaaritmttknkykkjmup04;
    }

    private String ztymvaariwup04;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARIWUP04)
    public String getZtymvaariwup04() {
        return ztymvaariwup04;
    }

    public void setZtymvaariwup04(String pZtymvaariwup04) {
        ztymvaariwup04 = pZtymvaariwup04;
    }

    private String ztymvaariwyentuktypeup04;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARIWYENTUKTYPEUP04)
    public String getZtymvaariwyentuktypeup04() {
        return ztymvaariwyentuktypeup04;
    }

    public void setZtymvaariwyentuktypeup04(String pZtymvaariwyentuktypeup04) {
        ztymvaariwyentuktypeup04 = pZtymvaariwyentuktypeup04;
    }

    private String ztymvaariwupyendaka04;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARIWUPYENDAKA04)
    public String getZtymvaariwupyendaka04() {
        return ztymvaariwupyendaka04;
    }

    public void setZtymvaariwupyendaka04(String pZtymvaariwupyendaka04) {
        ztymvaariwupyendaka04 = pZtymvaariwupyendaka04;
    }

    private String ztymvaariwupyenkijyun04;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARIWUPYENKIJYUN04)
    public String getZtymvaariwupyenkijyun04() {
        return ztymvaariwupyenkijyun04;
    }

    public void setZtymvaariwupyenkijyun04(String pZtymvaariwupyenkijyun04) {
        ztymvaariwupyenkijyun04 = pZtymvaariwupyenkijyun04;
    }

    private String ztymvaariwupyenyasu04;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARIWUPYENYASU04)
    public String getZtymvaariwupyenyasu04() {
        return ztymvaariwupyenyasu04;
    }

    public void setZtymvaariwupyenyasu04(String pZtymvaariwupyenyasu04) {
        ztymvaariwupyenyasu04 = pZtymvaariwupyenyasu04;
    }

    private String ztymvaariwumupyendaka04;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARIWUMUPYENDAKA04)
    public String getZtymvaariwumupyendaka04() {
        return ztymvaariwumupyendaka04;
    }

    public void setZtymvaariwumupyendaka04(String pZtymvaariwumupyendaka04) {
        ztymvaariwumupyendaka04 = pZtymvaariwumupyendaka04;
    }

    private String ztymvaariumupyenkijyun04;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARIUMUPYENKIJYUN04)
    public String getZtymvaariumupyenkijyun04() {
        return ztymvaariumupyenkijyun04;
    }

    public void setZtymvaariumupyenkijyun04(String pZtymvaariumupyenkijyun04) {
        ztymvaariumupyenkijyun04 = pZtymvaariumupyenkijyun04;
    }

    private String ztymvaariumupyenyasu04;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARIUMUPYENYASU04)
    public String getZtymvaariumupyenyasu04() {
        return ztymvaariumupyenyasu04;
    }

    public void setZtymvaariumupyenyasu04(String pZtymvaariumupyenyasu04) {
        ztymvaariumupyenyasu04 = pZtymvaariumupyenyasu04;
    }

    private String ztymvaariwtuktypesame04;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARIWTUKTYPESAME04)
    public String getZtymvaariwtuktypesame04() {
        return ztymvaariwtuktypesame04;
    }

    public void setZtymvaariwtuktypesame04(String pZtymvaariwtuktypesame04) {
        ztymvaariwtuktypesame04 = pZtymvaariwtuktypesame04;
    }

    private String ztymvaaritmttknkykkjmsame04;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARITMTTKNKYKKJMSAME04)
    public String getZtymvaaritmttknkykkjmsame04() {
        return ztymvaaritmttknkykkjmsame04;
    }

    public void setZtymvaaritmttknkykkjmsame04(String pZtymvaaritmttknkykkjmsame04) {
        ztymvaaritmttknkykkjmsame04 = pZtymvaaritmttknkykkjmsame04;
    }

    private String ztymvaariwsame04;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARIWSAME04)
    public String getZtymvaariwsame04() {
        return ztymvaariwsame04;
    }

    public void setZtymvaariwsame04(String pZtymvaariwsame04) {
        ztymvaariwsame04 = pZtymvaariwsame04;
    }

    private String ztymvaariwyentuktypesame04;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARIWYENTUKTYPESAME04)
    public String getZtymvaariwyentuktypesame04() {
        return ztymvaariwyentuktypesame04;
    }

    public void setZtymvaariwyentuktypesame04(String pZtymvaariwyentuktypesame04) {
        ztymvaariwyentuktypesame04 = pZtymvaariwyentuktypesame04;
    }

    private String ztymvaariwsameyendaka04;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARIWSAMEYENDAKA04)
    public String getZtymvaariwsameyendaka04() {
        return ztymvaariwsameyendaka04;
    }

    public void setZtymvaariwsameyendaka04(String pZtymvaariwsameyendaka04) {
        ztymvaariwsameyendaka04 = pZtymvaariwsameyendaka04;
    }

    private String ztymvaariwsameyenkijyun04;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARIWSAMEYENKIJYUN04)
    public String getZtymvaariwsameyenkijyun04() {
        return ztymvaariwsameyenkijyun04;
    }

    public void setZtymvaariwsameyenkijyun04(String pZtymvaariwsameyenkijyun04) {
        ztymvaariwsameyenkijyun04 = pZtymvaariwsameyenkijyun04;
    }

    private String ztymvaariwsameyenyasu04;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARIWSAMEYENYASU04)
    public String getZtymvaariwsameyenyasu04() {
        return ztymvaariwsameyenyasu04;
    }

    public void setZtymvaariwsameyenyasu04(String pZtymvaariwsameyenyasu04) {
        ztymvaariwsameyenyasu04 = pZtymvaariwsameyenyasu04;
    }

    private String ztymvaariumsameyendaka04;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARIUMSAMEYENDAKA04)
    public String getZtymvaariumsameyendaka04() {
        return ztymvaariumsameyendaka04;
    }

    public void setZtymvaariumsameyendaka04(String pZtymvaariumsameyendaka04) {
        ztymvaariumsameyendaka04 = pZtymvaariumsameyendaka04;
    }

    private String ztymvaariumsameyenkijyun04;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARIUMSAMEYENKIJYUN04)
    public String getZtymvaariumsameyenkijyun04() {
        return ztymvaariumsameyenkijyun04;
    }

    public void setZtymvaariumsameyenkijyun04(String pZtymvaariumsameyenkijyun04) {
        ztymvaariumsameyenkijyun04 = pZtymvaariumsameyenkijyun04;
    }

    private String ztymvaariumsameyenyasu04;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARIUMSAMEYENYASU04)
    public String getZtymvaariumsameyenyasu04() {
        return ztymvaariumsameyenyasu04;
    }

    public void setZtymvaariumsameyenyasu04(String pZtymvaariumsameyenyasu04) {
        ztymvaariumsameyenyasu04 = pZtymvaariumsameyenyasu04;
    }

    private String ztymvaariwtuktypedown04;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARIWTUKTYPEDOWN04)
    public String getZtymvaariwtuktypedown04() {
        return ztymvaariwtuktypedown04;
    }

    public void setZtymvaariwtuktypedown04(String pZtymvaariwtuktypedown04) {
        ztymvaariwtuktypedown04 = pZtymvaariwtuktypedown04;
    }

    private String ztymvaaritmttknkykkjmdown04;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARITMTTKNKYKKJMDOWN04)
    public String getZtymvaaritmttknkykkjmdown04() {
        return ztymvaaritmttknkykkjmdown04;
    }

    public void setZtymvaaritmttknkykkjmdown04(String pZtymvaaritmttknkykkjmdown04) {
        ztymvaaritmttknkykkjmdown04 = pZtymvaaritmttknkykkjmdown04;
    }

    private String ztymvaariwdown04;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARIWDOWN04)
    public String getZtymvaariwdown04() {
        return ztymvaariwdown04;
    }

    public void setZtymvaariwdown04(String pZtymvaariwdown04) {
        ztymvaariwdown04 = pZtymvaariwdown04;
    }

    private String ztymvaariwyentuktypedown04;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARIWYENTUKTYPEDOWN04)
    public String getZtymvaariwyentuktypedown04() {
        return ztymvaariwyentuktypedown04;
    }

    public void setZtymvaariwyentuktypedown04(String pZtymvaariwyentuktypedown04) {
        ztymvaariwyentuktypedown04 = pZtymvaariwyentuktypedown04;
    }

    private String ztymvaariwdownyendaka04;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARIWDOWNYENDAKA04)
    public String getZtymvaariwdownyendaka04() {
        return ztymvaariwdownyendaka04;
    }

    public void setZtymvaariwdownyendaka04(String pZtymvaariwdownyendaka04) {
        ztymvaariwdownyendaka04 = pZtymvaariwdownyendaka04;
    }

    private String ztymvaariwdownyenkijyun04;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARIWDOWNYENKIJYUN04)
    public String getZtymvaariwdownyenkijyun04() {
        return ztymvaariwdownyenkijyun04;
    }

    public void setZtymvaariwdownyenkijyun04(String pZtymvaariwdownyenkijyun04) {
        ztymvaariwdownyenkijyun04 = pZtymvaariwdownyenkijyun04;
    }

    private String ztymvaariwdownyenyasu04;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARIWDOWNYENYASU04)
    public String getZtymvaariwdownyenyasu04() {
        return ztymvaariwdownyenyasu04;
    }

    public void setZtymvaariwdownyenyasu04(String pZtymvaariwdownyenyasu04) {
        ztymvaariwdownyenyasu04 = pZtymvaariwdownyenyasu04;
    }

    private String ztymvaariumdownyendaka04;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARIUMDOWNYENDAKA04)
    public String getZtymvaariumdownyendaka04() {
        return ztymvaariumdownyendaka04;
    }

    public void setZtymvaariumdownyendaka04(String pZtymvaariumdownyendaka04) {
        ztymvaariumdownyendaka04 = pZtymvaariumdownyendaka04;
    }

    private String ztymvaariumdownyenkijyun04;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARIUMDOWNYENKIJYUN04)
    public String getZtymvaariumdownyenkijyun04() {
        return ztymvaariumdownyenkijyun04;
    }

    public void setZtymvaariumdownyenkijyun04(String pZtymvaariumdownyenkijyun04) {
        ztymvaariumdownyenkijyun04 = pZtymvaariumdownyenkijyun04;
    }

    private String ztymvaariumdownyenyasu04;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARIUMDOWNYENYASU04)
    public String getZtymvaariumdownyenyasu04() {
        return ztymvaariumdownyenyasu04;
    }

    public void setZtymvaariumdownyenyasu04(String pZtymvaariumdownyenyasu04) {
        ztymvaariumdownyenyasu04 = pZtymvaariumdownyenyasu04;
    }

    private String ztymvaarivtuktype04;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARIVTUKTYPE04)
    public String getZtymvaarivtuktype04() {
        return ztymvaarivtuktype04;
    }

    public void setZtymvaarivtuktype04(String pZtymvaarivtuktype04) {
        ztymvaarivtuktype04 = pZtymvaarivtuktype04;
    }

    private String ztymvaariv04;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARIV04)
    public String getZtymvaariv04() {
        return ztymvaariv04;
    }

    public void setZtymvaariv04(String pZtymvaariv04) {
        ztymvaariv04 = pZtymvaariv04;
    }

    private String ztyptmttkngkutiwake104;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYPTMTTKNGKUTIWAKE104)
    public String getZtyptmttkngkutiwake104() {
        return ztyptmttkngkutiwake104;
    }

    public void setZtyptmttkngkutiwake104(String pZtyptmttkngkutiwake104) {
        ztyptmttkngkutiwake104 = pZtyptmttkngkutiwake104;
    }

    private String ztyptmttkngkutiwake204;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYPTMTTKNGKUTIWAKE204)
    public String getZtyptmttkngkutiwake204() {
        return ztyptmttkngkutiwake204;
    }

    public void setZtyptmttkngkutiwake204(String pZtyptmttkngkutiwake204) {
        ztyptmttkngkutiwake204 = pZtyptmttkngkutiwake204;
    }

    private String ztymvaarinenoutouym05;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARINENOUTOUYM05)
    public String getZtymvaarinenoutouym05() {
        return ztymvaarinenoutouym05;
    }

    public void setZtymvaarinenoutouym05(String pZtymvaarinenoutouym05) {
        ztymvaarinenoutouym05 = pZtymvaarinenoutouym05;
    }

    private String ztymvaarisisuuupritu05;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARISISUUUPRITU05)
    public String getZtymvaarisisuuupritu05() {
        return ztymvaarisisuuupritu05;
    }

    @DataConvert("toMultiByte")
    public void setZtymvaarisisuuupritu05(String pZtymvaarisisuuupritu05) {
        ztymvaarisisuuupritu05 = pZtymvaarisisuuupritu05;
    }

    private String ztymvaaritmttknzkritu05;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARITMTTKNZKRITU05)
    public String getZtymvaaritmttknzkritu05() {
        return ztymvaaritmttknzkritu05;
    }

    @DataConvert("toMultiByte")
    public void setZtymvaaritmttknzkritu05(String pZtymvaaritmttknzkritu05) {
        ztymvaaritmttknzkritu05 = pZtymvaaritmttknzkritu05;
    }

    private String ztymvaariwtuktypeup05;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARIWTUKTYPEUP05)
    public String getZtymvaariwtuktypeup05() {
        return ztymvaariwtuktypeup05;
    }

    public void setZtymvaariwtuktypeup05(String pZtymvaariwtuktypeup05) {
        ztymvaariwtuktypeup05 = pZtymvaariwtuktypeup05;
    }

    private String ztymvaaritmttknkykkjmup05;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARITMTTKNKYKKJMUP05)
    public String getZtymvaaritmttknkykkjmup05() {
        return ztymvaaritmttknkykkjmup05;
    }

    public void setZtymvaaritmttknkykkjmup05(String pZtymvaaritmttknkykkjmup05) {
        ztymvaaritmttknkykkjmup05 = pZtymvaaritmttknkykkjmup05;
    }

    private String ztymvaariwup05;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARIWUP05)
    public String getZtymvaariwup05() {
        return ztymvaariwup05;
    }

    public void setZtymvaariwup05(String pZtymvaariwup05) {
        ztymvaariwup05 = pZtymvaariwup05;
    }

    private String ztymvaariwyentuktypeup05;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARIWYENTUKTYPEUP05)
    public String getZtymvaariwyentuktypeup05() {
        return ztymvaariwyentuktypeup05;
    }

    public void setZtymvaariwyentuktypeup05(String pZtymvaariwyentuktypeup05) {
        ztymvaariwyentuktypeup05 = pZtymvaariwyentuktypeup05;
    }

    private String ztymvaariwupyendaka05;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARIWUPYENDAKA05)
    public String getZtymvaariwupyendaka05() {
        return ztymvaariwupyendaka05;
    }

    public void setZtymvaariwupyendaka05(String pZtymvaariwupyendaka05) {
        ztymvaariwupyendaka05 = pZtymvaariwupyendaka05;
    }

    private String ztymvaariwupyenkijyun05;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARIWUPYENKIJYUN05)
    public String getZtymvaariwupyenkijyun05() {
        return ztymvaariwupyenkijyun05;
    }

    public void setZtymvaariwupyenkijyun05(String pZtymvaariwupyenkijyun05) {
        ztymvaariwupyenkijyun05 = pZtymvaariwupyenkijyun05;
    }

    private String ztymvaariwupyenyasu05;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARIWUPYENYASU05)
    public String getZtymvaariwupyenyasu05() {
        return ztymvaariwupyenyasu05;
    }

    public void setZtymvaariwupyenyasu05(String pZtymvaariwupyenyasu05) {
        ztymvaariwupyenyasu05 = pZtymvaariwupyenyasu05;
    }

    private String ztymvaariwumupyendaka05;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARIWUMUPYENDAKA05)
    public String getZtymvaariwumupyendaka05() {
        return ztymvaariwumupyendaka05;
    }

    public void setZtymvaariwumupyendaka05(String pZtymvaariwumupyendaka05) {
        ztymvaariwumupyendaka05 = pZtymvaariwumupyendaka05;
    }

    private String ztymvaariumupyenkijyun05;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARIUMUPYENKIJYUN05)
    public String getZtymvaariumupyenkijyun05() {
        return ztymvaariumupyenkijyun05;
    }

    public void setZtymvaariumupyenkijyun05(String pZtymvaariumupyenkijyun05) {
        ztymvaariumupyenkijyun05 = pZtymvaariumupyenkijyun05;
    }

    private String ztymvaariumupyenyasu05;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARIUMUPYENYASU05)
    public String getZtymvaariumupyenyasu05() {
        return ztymvaariumupyenyasu05;
    }

    public void setZtymvaariumupyenyasu05(String pZtymvaariumupyenyasu05) {
        ztymvaariumupyenyasu05 = pZtymvaariumupyenyasu05;
    }

    private String ztymvaariwtuktypesame05;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARIWTUKTYPESAME05)
    public String getZtymvaariwtuktypesame05() {
        return ztymvaariwtuktypesame05;
    }

    public void setZtymvaariwtuktypesame05(String pZtymvaariwtuktypesame05) {
        ztymvaariwtuktypesame05 = pZtymvaariwtuktypesame05;
    }

    private String ztymvaaritmttknkykkjmsame05;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARITMTTKNKYKKJMSAME05)
    public String getZtymvaaritmttknkykkjmsame05() {
        return ztymvaaritmttknkykkjmsame05;
    }

    public void setZtymvaaritmttknkykkjmsame05(String pZtymvaaritmttknkykkjmsame05) {
        ztymvaaritmttknkykkjmsame05 = pZtymvaaritmttknkykkjmsame05;
    }

    private String ztymvaariwsame05;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARIWSAME05)
    public String getZtymvaariwsame05() {
        return ztymvaariwsame05;
    }

    public void setZtymvaariwsame05(String pZtymvaariwsame05) {
        ztymvaariwsame05 = pZtymvaariwsame05;
    }

    private String ztymvaariwyentuktypesame05;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARIWYENTUKTYPESAME05)
    public String getZtymvaariwyentuktypesame05() {
        return ztymvaariwyentuktypesame05;
    }

    public void setZtymvaariwyentuktypesame05(String pZtymvaariwyentuktypesame05) {
        ztymvaariwyentuktypesame05 = pZtymvaariwyentuktypesame05;
    }

    private String ztymvaariwsameyendaka05;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARIWSAMEYENDAKA05)
    public String getZtymvaariwsameyendaka05() {
        return ztymvaariwsameyendaka05;
    }

    public void setZtymvaariwsameyendaka05(String pZtymvaariwsameyendaka05) {
        ztymvaariwsameyendaka05 = pZtymvaariwsameyendaka05;
    }

    private String ztymvaariwsameyenkijyun05;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARIWSAMEYENKIJYUN05)
    public String getZtymvaariwsameyenkijyun05() {
        return ztymvaariwsameyenkijyun05;
    }

    public void setZtymvaariwsameyenkijyun05(String pZtymvaariwsameyenkijyun05) {
        ztymvaariwsameyenkijyun05 = pZtymvaariwsameyenkijyun05;
    }

    private String ztymvaariwsameyenyasu05;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARIWSAMEYENYASU05)
    public String getZtymvaariwsameyenyasu05() {
        return ztymvaariwsameyenyasu05;
    }

    public void setZtymvaariwsameyenyasu05(String pZtymvaariwsameyenyasu05) {
        ztymvaariwsameyenyasu05 = pZtymvaariwsameyenyasu05;
    }

    private String ztymvaariumsameyendaka05;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARIUMSAMEYENDAKA05)
    public String getZtymvaariumsameyendaka05() {
        return ztymvaariumsameyendaka05;
    }

    public void setZtymvaariumsameyendaka05(String pZtymvaariumsameyendaka05) {
        ztymvaariumsameyendaka05 = pZtymvaariumsameyendaka05;
    }

    private String ztymvaariumsameyenkijyun05;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARIUMSAMEYENKIJYUN05)
    public String getZtymvaariumsameyenkijyun05() {
        return ztymvaariumsameyenkijyun05;
    }

    public void setZtymvaariumsameyenkijyun05(String pZtymvaariumsameyenkijyun05) {
        ztymvaariumsameyenkijyun05 = pZtymvaariumsameyenkijyun05;
    }

    private String ztymvaariumsameyenyasu05;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARIUMSAMEYENYASU05)
    public String getZtymvaariumsameyenyasu05() {
        return ztymvaariumsameyenyasu05;
    }

    public void setZtymvaariumsameyenyasu05(String pZtymvaariumsameyenyasu05) {
        ztymvaariumsameyenyasu05 = pZtymvaariumsameyenyasu05;
    }

    private String ztymvaariwtuktypedown05;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARIWTUKTYPEDOWN05)
    public String getZtymvaariwtuktypedown05() {
        return ztymvaariwtuktypedown05;
    }

    public void setZtymvaariwtuktypedown05(String pZtymvaariwtuktypedown05) {
        ztymvaariwtuktypedown05 = pZtymvaariwtuktypedown05;
    }

    private String ztymvaaritmttknkykkjmdown05;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARITMTTKNKYKKJMDOWN05)
    public String getZtymvaaritmttknkykkjmdown05() {
        return ztymvaaritmttknkykkjmdown05;
    }

    public void setZtymvaaritmttknkykkjmdown05(String pZtymvaaritmttknkykkjmdown05) {
        ztymvaaritmttknkykkjmdown05 = pZtymvaaritmttknkykkjmdown05;
    }

    private String ztymvaariwdown05;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARIWDOWN05)
    public String getZtymvaariwdown05() {
        return ztymvaariwdown05;
    }

    public void setZtymvaariwdown05(String pZtymvaariwdown05) {
        ztymvaariwdown05 = pZtymvaariwdown05;
    }

    private String ztymvaariwyentuktypedown05;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARIWYENTUKTYPEDOWN05)
    public String getZtymvaariwyentuktypedown05() {
        return ztymvaariwyentuktypedown05;
    }

    public void setZtymvaariwyentuktypedown05(String pZtymvaariwyentuktypedown05) {
        ztymvaariwyentuktypedown05 = pZtymvaariwyentuktypedown05;
    }

    private String ztymvaariwdownyendaka05;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARIWDOWNYENDAKA05)
    public String getZtymvaariwdownyendaka05() {
        return ztymvaariwdownyendaka05;
    }

    public void setZtymvaariwdownyendaka05(String pZtymvaariwdownyendaka05) {
        ztymvaariwdownyendaka05 = pZtymvaariwdownyendaka05;
    }

    private String ztymvaariwdownyenkijyun05;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARIWDOWNYENKIJYUN05)
    public String getZtymvaariwdownyenkijyun05() {
        return ztymvaariwdownyenkijyun05;
    }

    public void setZtymvaariwdownyenkijyun05(String pZtymvaariwdownyenkijyun05) {
        ztymvaariwdownyenkijyun05 = pZtymvaariwdownyenkijyun05;
    }

    private String ztymvaariwdownyenyasu05;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARIWDOWNYENYASU05)
    public String getZtymvaariwdownyenyasu05() {
        return ztymvaariwdownyenyasu05;
    }

    public void setZtymvaariwdownyenyasu05(String pZtymvaariwdownyenyasu05) {
        ztymvaariwdownyenyasu05 = pZtymvaariwdownyenyasu05;
    }

    private String ztymvaariumdownyendaka05;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARIUMDOWNYENDAKA05)
    public String getZtymvaariumdownyendaka05() {
        return ztymvaariumdownyendaka05;
    }

    public void setZtymvaariumdownyendaka05(String pZtymvaariumdownyendaka05) {
        ztymvaariumdownyendaka05 = pZtymvaariumdownyendaka05;
    }

    private String ztymvaariumdownyenkijyun05;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARIUMDOWNYENKIJYUN05)
    public String getZtymvaariumdownyenkijyun05() {
        return ztymvaariumdownyenkijyun05;
    }

    public void setZtymvaariumdownyenkijyun05(String pZtymvaariumdownyenkijyun05) {
        ztymvaariumdownyenkijyun05 = pZtymvaariumdownyenkijyun05;
    }

    private String ztymvaariumdownyenyasu05;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARIUMDOWNYENYASU05)
    public String getZtymvaariumdownyenyasu05() {
        return ztymvaariumdownyenyasu05;
    }

    public void setZtymvaariumdownyenyasu05(String pZtymvaariumdownyenyasu05) {
        ztymvaariumdownyenyasu05 = pZtymvaariumdownyenyasu05;
    }

    private String ztymvaarivtuktype05;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARIVTUKTYPE05)
    public String getZtymvaarivtuktype05() {
        return ztymvaarivtuktype05;
    }

    public void setZtymvaarivtuktype05(String pZtymvaarivtuktype05) {
        ztymvaarivtuktype05 = pZtymvaarivtuktype05;
    }

    private String ztymvaariv05;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARIV05)
    public String getZtymvaariv05() {
        return ztymvaariv05;
    }

    public void setZtymvaariv05(String pZtymvaariv05) {
        ztymvaariv05 = pZtymvaariv05;
    }

    private String ztyptmttkngkutiwake105;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYPTMTTKNGKUTIWAKE105)
    public String getZtyptmttkngkutiwake105() {
        return ztyptmttkngkutiwake105;
    }

    public void setZtyptmttkngkutiwake105(String pZtyptmttkngkutiwake105) {
        ztyptmttkngkutiwake105 = pZtyptmttkngkutiwake105;
    }

    private String ztyptmttkngkutiwake205;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYPTMTTKNGKUTIWAKE205)
    public String getZtyptmttkngkutiwake205() {
        return ztyptmttkngkutiwake205;
    }

    public void setZtyptmttkngkutiwake205(String pZtyptmttkngkutiwake205) {
        ztyptmttkngkutiwake205 = pZtyptmttkngkutiwake205;
    }

    private String ztymvaarinenoutouym06;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARINENOUTOUYM06)
    public String getZtymvaarinenoutouym06() {
        return ztymvaarinenoutouym06;
    }

    public void setZtymvaarinenoutouym06(String pZtymvaarinenoutouym06) {
        ztymvaarinenoutouym06 = pZtymvaarinenoutouym06;
    }

    private String ztymvaarisisuuupritu06;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARISISUUUPRITU06)
    public String getZtymvaarisisuuupritu06() {
        return ztymvaarisisuuupritu06;
    }

    @DataConvert("toMultiByte")
    public void setZtymvaarisisuuupritu06(String pZtymvaarisisuuupritu06) {
        ztymvaarisisuuupritu06 = pZtymvaarisisuuupritu06;
    }

    private String ztymvaaritmttknzkritu06;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARITMTTKNZKRITU06)
    public String getZtymvaaritmttknzkritu06() {
        return ztymvaaritmttknzkritu06;
    }

    @DataConvert("toMultiByte")
    public void setZtymvaaritmttknzkritu06(String pZtymvaaritmttknzkritu06) {
        ztymvaaritmttknzkritu06 = pZtymvaaritmttknzkritu06;
    }

    private String ztymvaariwtuktypeup06;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARIWTUKTYPEUP06)
    public String getZtymvaariwtuktypeup06() {
        return ztymvaariwtuktypeup06;
    }

    public void setZtymvaariwtuktypeup06(String pZtymvaariwtuktypeup06) {
        ztymvaariwtuktypeup06 = pZtymvaariwtuktypeup06;
    }

    private String ztymvaaritmttknkykkjmup06;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARITMTTKNKYKKJMUP06)
    public String getZtymvaaritmttknkykkjmup06() {
        return ztymvaaritmttknkykkjmup06;
    }

    public void setZtymvaaritmttknkykkjmup06(String pZtymvaaritmttknkykkjmup06) {
        ztymvaaritmttknkykkjmup06 = pZtymvaaritmttknkykkjmup06;
    }

    private String ztymvaariwup06;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARIWUP06)
    public String getZtymvaariwup06() {
        return ztymvaariwup06;
    }

    public void setZtymvaariwup06(String pZtymvaariwup06) {
        ztymvaariwup06 = pZtymvaariwup06;
    }

    private String ztymvaariwyentuktypeup06;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARIWYENTUKTYPEUP06)
    public String getZtymvaariwyentuktypeup06() {
        return ztymvaariwyentuktypeup06;
    }

    public void setZtymvaariwyentuktypeup06(String pZtymvaariwyentuktypeup06) {
        ztymvaariwyentuktypeup06 = pZtymvaariwyentuktypeup06;
    }

    private String ztymvaariwupyendaka06;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARIWUPYENDAKA06)
    public String getZtymvaariwupyendaka06() {
        return ztymvaariwupyendaka06;
    }

    public void setZtymvaariwupyendaka06(String pZtymvaariwupyendaka06) {
        ztymvaariwupyendaka06 = pZtymvaariwupyendaka06;
    }

    private String ztymvaariwupyenkijyun06;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARIWUPYENKIJYUN06)
    public String getZtymvaariwupyenkijyun06() {
        return ztymvaariwupyenkijyun06;
    }

    public void setZtymvaariwupyenkijyun06(String pZtymvaariwupyenkijyun06) {
        ztymvaariwupyenkijyun06 = pZtymvaariwupyenkijyun06;
    }

    private String ztymvaariwupyenyasu06;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARIWUPYENYASU06)
    public String getZtymvaariwupyenyasu06() {
        return ztymvaariwupyenyasu06;
    }

    public void setZtymvaariwupyenyasu06(String pZtymvaariwupyenyasu06) {
        ztymvaariwupyenyasu06 = pZtymvaariwupyenyasu06;
    }

    private String ztymvaariwumupyendaka06;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARIWUMUPYENDAKA06)
    public String getZtymvaariwumupyendaka06() {
        return ztymvaariwumupyendaka06;
    }

    public void setZtymvaariwumupyendaka06(String pZtymvaariwumupyendaka06) {
        ztymvaariwumupyendaka06 = pZtymvaariwumupyendaka06;
    }

    private String ztymvaariumupyenkijyun06;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARIUMUPYENKIJYUN06)
    public String getZtymvaariumupyenkijyun06() {
        return ztymvaariumupyenkijyun06;
    }

    public void setZtymvaariumupyenkijyun06(String pZtymvaariumupyenkijyun06) {
        ztymvaariumupyenkijyun06 = pZtymvaariumupyenkijyun06;
    }

    private String ztymvaariumupyenyasu06;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARIUMUPYENYASU06)
    public String getZtymvaariumupyenyasu06() {
        return ztymvaariumupyenyasu06;
    }

    public void setZtymvaariumupyenyasu06(String pZtymvaariumupyenyasu06) {
        ztymvaariumupyenyasu06 = pZtymvaariumupyenyasu06;
    }

    private String ztymvaariwtuktypesame06;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARIWTUKTYPESAME06)
    public String getZtymvaariwtuktypesame06() {
        return ztymvaariwtuktypesame06;
    }

    public void setZtymvaariwtuktypesame06(String pZtymvaariwtuktypesame06) {
        ztymvaariwtuktypesame06 = pZtymvaariwtuktypesame06;
    }

    private String ztymvaaritmttknkykkjmsame06;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARITMTTKNKYKKJMSAME06)
    public String getZtymvaaritmttknkykkjmsame06() {
        return ztymvaaritmttknkykkjmsame06;
    }

    public void setZtymvaaritmttknkykkjmsame06(String pZtymvaaritmttknkykkjmsame06) {
        ztymvaaritmttknkykkjmsame06 = pZtymvaaritmttknkykkjmsame06;
    }

    private String ztymvaariwsame06;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARIWSAME06)
    public String getZtymvaariwsame06() {
        return ztymvaariwsame06;
    }

    public void setZtymvaariwsame06(String pZtymvaariwsame06) {
        ztymvaariwsame06 = pZtymvaariwsame06;
    }

    private String ztymvaariwyentuktypesame06;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARIWYENTUKTYPESAME06)
    public String getZtymvaariwyentuktypesame06() {
        return ztymvaariwyentuktypesame06;
    }

    public void setZtymvaariwyentuktypesame06(String pZtymvaariwyentuktypesame06) {
        ztymvaariwyentuktypesame06 = pZtymvaariwyentuktypesame06;
    }

    private String ztymvaariwsameyendaka06;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARIWSAMEYENDAKA06)
    public String getZtymvaariwsameyendaka06() {
        return ztymvaariwsameyendaka06;
    }

    public void setZtymvaariwsameyendaka06(String pZtymvaariwsameyendaka06) {
        ztymvaariwsameyendaka06 = pZtymvaariwsameyendaka06;
    }

    private String ztymvaariwsameyenkijyun06;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARIWSAMEYENKIJYUN06)
    public String getZtymvaariwsameyenkijyun06() {
        return ztymvaariwsameyenkijyun06;
    }

    public void setZtymvaariwsameyenkijyun06(String pZtymvaariwsameyenkijyun06) {
        ztymvaariwsameyenkijyun06 = pZtymvaariwsameyenkijyun06;
    }

    private String ztymvaariwsameyenyasu06;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARIWSAMEYENYASU06)
    public String getZtymvaariwsameyenyasu06() {
        return ztymvaariwsameyenyasu06;
    }

    public void setZtymvaariwsameyenyasu06(String pZtymvaariwsameyenyasu06) {
        ztymvaariwsameyenyasu06 = pZtymvaariwsameyenyasu06;
    }

    private String ztymvaariumsameyendaka06;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARIUMSAMEYENDAKA06)
    public String getZtymvaariumsameyendaka06() {
        return ztymvaariumsameyendaka06;
    }

    public void setZtymvaariumsameyendaka06(String pZtymvaariumsameyendaka06) {
        ztymvaariumsameyendaka06 = pZtymvaariumsameyendaka06;
    }

    private String ztymvaariumsameyenkijyun06;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARIUMSAMEYENKIJYUN06)
    public String getZtymvaariumsameyenkijyun06() {
        return ztymvaariumsameyenkijyun06;
    }

    public void setZtymvaariumsameyenkijyun06(String pZtymvaariumsameyenkijyun06) {
        ztymvaariumsameyenkijyun06 = pZtymvaariumsameyenkijyun06;
    }

    private String ztymvaariumsameyenyasu06;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARIUMSAMEYENYASU06)
    public String getZtymvaariumsameyenyasu06() {
        return ztymvaariumsameyenyasu06;
    }

    public void setZtymvaariumsameyenyasu06(String pZtymvaariumsameyenyasu06) {
        ztymvaariumsameyenyasu06 = pZtymvaariumsameyenyasu06;
    }

    private String ztymvaariwtuktypedown06;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARIWTUKTYPEDOWN06)
    public String getZtymvaariwtuktypedown06() {
        return ztymvaariwtuktypedown06;
    }

    public void setZtymvaariwtuktypedown06(String pZtymvaariwtuktypedown06) {
        ztymvaariwtuktypedown06 = pZtymvaariwtuktypedown06;
    }

    private String ztymvaaritmttknkykkjmdown06;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARITMTTKNKYKKJMDOWN06)
    public String getZtymvaaritmttknkykkjmdown06() {
        return ztymvaaritmttknkykkjmdown06;
    }

    public void setZtymvaaritmttknkykkjmdown06(String pZtymvaaritmttknkykkjmdown06) {
        ztymvaaritmttknkykkjmdown06 = pZtymvaaritmttknkykkjmdown06;
    }

    private String ztymvaariwdown06;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARIWDOWN06)
    public String getZtymvaariwdown06() {
        return ztymvaariwdown06;
    }

    public void setZtymvaariwdown06(String pZtymvaariwdown06) {
        ztymvaariwdown06 = pZtymvaariwdown06;
    }

    private String ztymvaariwyentuktypedown06;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARIWYENTUKTYPEDOWN06)
    public String getZtymvaariwyentuktypedown06() {
        return ztymvaariwyentuktypedown06;
    }

    public void setZtymvaariwyentuktypedown06(String pZtymvaariwyentuktypedown06) {
        ztymvaariwyentuktypedown06 = pZtymvaariwyentuktypedown06;
    }

    private String ztymvaariwdownyendaka06;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARIWDOWNYENDAKA06)
    public String getZtymvaariwdownyendaka06() {
        return ztymvaariwdownyendaka06;
    }

    public void setZtymvaariwdownyendaka06(String pZtymvaariwdownyendaka06) {
        ztymvaariwdownyendaka06 = pZtymvaariwdownyendaka06;
    }

    private String ztymvaariwdownyenkijyun06;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARIWDOWNYENKIJYUN06)
    public String getZtymvaariwdownyenkijyun06() {
        return ztymvaariwdownyenkijyun06;
    }

    public void setZtymvaariwdownyenkijyun06(String pZtymvaariwdownyenkijyun06) {
        ztymvaariwdownyenkijyun06 = pZtymvaariwdownyenkijyun06;
    }

    private String ztymvaariwdownyenyasu06;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARIWDOWNYENYASU06)
    public String getZtymvaariwdownyenyasu06() {
        return ztymvaariwdownyenyasu06;
    }

    public void setZtymvaariwdownyenyasu06(String pZtymvaariwdownyenyasu06) {
        ztymvaariwdownyenyasu06 = pZtymvaariwdownyenyasu06;
    }

    private String ztymvaariumdownyendaka06;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARIUMDOWNYENDAKA06)
    public String getZtymvaariumdownyendaka06() {
        return ztymvaariumdownyendaka06;
    }

    public void setZtymvaariumdownyendaka06(String pZtymvaariumdownyendaka06) {
        ztymvaariumdownyendaka06 = pZtymvaariumdownyendaka06;
    }

    private String ztymvaariumdownyenkijyun06;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARIUMDOWNYENKIJYUN06)
    public String getZtymvaariumdownyenkijyun06() {
        return ztymvaariumdownyenkijyun06;
    }

    public void setZtymvaariumdownyenkijyun06(String pZtymvaariumdownyenkijyun06) {
        ztymvaariumdownyenkijyun06 = pZtymvaariumdownyenkijyun06;
    }

    private String ztymvaariumdownyenyasu06;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARIUMDOWNYENYASU06)
    public String getZtymvaariumdownyenyasu06() {
        return ztymvaariumdownyenyasu06;
    }

    public void setZtymvaariumdownyenyasu06(String pZtymvaariumdownyenyasu06) {
        ztymvaariumdownyenyasu06 = pZtymvaariumdownyenyasu06;
    }

    private String ztymvaarivtuktype06;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARIVTUKTYPE06)
    public String getZtymvaarivtuktype06() {
        return ztymvaarivtuktype06;
    }

    public void setZtymvaarivtuktype06(String pZtymvaarivtuktype06) {
        ztymvaarivtuktype06 = pZtymvaarivtuktype06;
    }

    private String ztymvaariv06;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARIV06)
    public String getZtymvaariv06() {
        return ztymvaariv06;
    }

    public void setZtymvaariv06(String pZtymvaariv06) {
        ztymvaariv06 = pZtymvaariv06;
    }

    private String ztyptmttkngkutiwake106;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYPTMTTKNGKUTIWAKE106)
    public String getZtyptmttkngkutiwake106() {
        return ztyptmttkngkutiwake106;
    }

    public void setZtyptmttkngkutiwake106(String pZtyptmttkngkutiwake106) {
        ztyptmttkngkutiwake106 = pZtyptmttkngkutiwake106;
    }

    private String ztyptmttkngkutiwake206;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYPTMTTKNGKUTIWAKE206)
    public String getZtyptmttkngkutiwake206() {
        return ztyptmttkngkutiwake206;
    }

    public void setZtyptmttkngkutiwake206(String pZtyptmttkngkutiwake206) {
        ztyptmttkngkutiwake206 = pZtyptmttkngkutiwake206;
    }

    private String ztymvaarinenoutouym07;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARINENOUTOUYM07)
    public String getZtymvaarinenoutouym07() {
        return ztymvaarinenoutouym07;
    }

    public void setZtymvaarinenoutouym07(String pZtymvaarinenoutouym07) {
        ztymvaarinenoutouym07 = pZtymvaarinenoutouym07;
    }

    private String ztymvaarisisuuupritu07;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARISISUUUPRITU07)
    public String getZtymvaarisisuuupritu07() {
        return ztymvaarisisuuupritu07;
    }

    @DataConvert("toMultiByte")
    public void setZtymvaarisisuuupritu07(String pZtymvaarisisuuupritu07) {
        ztymvaarisisuuupritu07 = pZtymvaarisisuuupritu07;
    }

    private String ztymvaaritmttknzkritu07;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARITMTTKNZKRITU07)
    public String getZtymvaaritmttknzkritu07() {
        return ztymvaaritmttknzkritu07;
    }

    @DataConvert("toMultiByte")
    public void setZtymvaaritmttknzkritu07(String pZtymvaaritmttknzkritu07) {
        ztymvaaritmttknzkritu07 = pZtymvaaritmttknzkritu07;
    }

    private String ztymvaariwtuktypeup07;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARIWTUKTYPEUP07)
    public String getZtymvaariwtuktypeup07() {
        return ztymvaariwtuktypeup07;
    }

    public void setZtymvaariwtuktypeup07(String pZtymvaariwtuktypeup07) {
        ztymvaariwtuktypeup07 = pZtymvaariwtuktypeup07;
    }

    private String ztymvaaritmttknkykkjmup07;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARITMTTKNKYKKJMUP07)
    public String getZtymvaaritmttknkykkjmup07() {
        return ztymvaaritmttknkykkjmup07;
    }

    public void setZtymvaaritmttknkykkjmup07(String pZtymvaaritmttknkykkjmup07) {
        ztymvaaritmttknkykkjmup07 = pZtymvaaritmttknkykkjmup07;
    }

    private String ztymvaariwup07;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARIWUP07)
    public String getZtymvaariwup07() {
        return ztymvaariwup07;
    }

    public void setZtymvaariwup07(String pZtymvaariwup07) {
        ztymvaariwup07 = pZtymvaariwup07;
    }

    private String ztymvaariwyentuktypeup07;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARIWYENTUKTYPEUP07)
    public String getZtymvaariwyentuktypeup07() {
        return ztymvaariwyentuktypeup07;
    }

    public void setZtymvaariwyentuktypeup07(String pZtymvaariwyentuktypeup07) {
        ztymvaariwyentuktypeup07 = pZtymvaariwyentuktypeup07;
    }

    private String ztymvaariwupyendaka07;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARIWUPYENDAKA07)
    public String getZtymvaariwupyendaka07() {
        return ztymvaariwupyendaka07;
    }

    public void setZtymvaariwupyendaka07(String pZtymvaariwupyendaka07) {
        ztymvaariwupyendaka07 = pZtymvaariwupyendaka07;
    }

    private String ztymvaariwupyenkijyun07;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARIWUPYENKIJYUN07)
    public String getZtymvaariwupyenkijyun07() {
        return ztymvaariwupyenkijyun07;
    }

    public void setZtymvaariwupyenkijyun07(String pZtymvaariwupyenkijyun07) {
        ztymvaariwupyenkijyun07 = pZtymvaariwupyenkijyun07;
    }

    private String ztymvaariwupyenyasu07;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARIWUPYENYASU07)
    public String getZtymvaariwupyenyasu07() {
        return ztymvaariwupyenyasu07;
    }

    public void setZtymvaariwupyenyasu07(String pZtymvaariwupyenyasu07) {
        ztymvaariwupyenyasu07 = pZtymvaariwupyenyasu07;
    }

    private String ztymvaariwumupyendaka07;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARIWUMUPYENDAKA07)
    public String getZtymvaariwumupyendaka07() {
        return ztymvaariwumupyendaka07;
    }

    public void setZtymvaariwumupyendaka07(String pZtymvaariwumupyendaka07) {
        ztymvaariwumupyendaka07 = pZtymvaariwumupyendaka07;
    }

    private String ztymvaariumupyenkijyun07;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARIUMUPYENKIJYUN07)
    public String getZtymvaariumupyenkijyun07() {
        return ztymvaariumupyenkijyun07;
    }

    public void setZtymvaariumupyenkijyun07(String pZtymvaariumupyenkijyun07) {
        ztymvaariumupyenkijyun07 = pZtymvaariumupyenkijyun07;
    }

    private String ztymvaariumupyenyasu07;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARIUMUPYENYASU07)
    public String getZtymvaariumupyenyasu07() {
        return ztymvaariumupyenyasu07;
    }

    public void setZtymvaariumupyenyasu07(String pZtymvaariumupyenyasu07) {
        ztymvaariumupyenyasu07 = pZtymvaariumupyenyasu07;
    }

    private String ztymvaariwtuktypesame07;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARIWTUKTYPESAME07)
    public String getZtymvaariwtuktypesame07() {
        return ztymvaariwtuktypesame07;
    }

    public void setZtymvaariwtuktypesame07(String pZtymvaariwtuktypesame07) {
        ztymvaariwtuktypesame07 = pZtymvaariwtuktypesame07;
    }

    private String ztymvaaritmttknkykkjmsame07;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARITMTTKNKYKKJMSAME07)
    public String getZtymvaaritmttknkykkjmsame07() {
        return ztymvaaritmttknkykkjmsame07;
    }

    public void setZtymvaaritmttknkykkjmsame07(String pZtymvaaritmttknkykkjmsame07) {
        ztymvaaritmttknkykkjmsame07 = pZtymvaaritmttknkykkjmsame07;
    }

    private String ztymvaariwsame07;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARIWSAME07)
    public String getZtymvaariwsame07() {
        return ztymvaariwsame07;
    }

    public void setZtymvaariwsame07(String pZtymvaariwsame07) {
        ztymvaariwsame07 = pZtymvaariwsame07;
    }

    private String ztymvaariwyentuktypesame07;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARIWYENTUKTYPESAME07)
    public String getZtymvaariwyentuktypesame07() {
        return ztymvaariwyentuktypesame07;
    }

    public void setZtymvaariwyentuktypesame07(String pZtymvaariwyentuktypesame07) {
        ztymvaariwyentuktypesame07 = pZtymvaariwyentuktypesame07;
    }

    private String ztymvaariwsameyendaka07;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARIWSAMEYENDAKA07)
    public String getZtymvaariwsameyendaka07() {
        return ztymvaariwsameyendaka07;
    }

    public void setZtymvaariwsameyendaka07(String pZtymvaariwsameyendaka07) {
        ztymvaariwsameyendaka07 = pZtymvaariwsameyendaka07;
    }

    private String ztymvaariwsameyenkijyun07;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARIWSAMEYENKIJYUN07)
    public String getZtymvaariwsameyenkijyun07() {
        return ztymvaariwsameyenkijyun07;
    }

    public void setZtymvaariwsameyenkijyun07(String pZtymvaariwsameyenkijyun07) {
        ztymvaariwsameyenkijyun07 = pZtymvaariwsameyenkijyun07;
    }

    private String ztymvaariwsameyenyasu07;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARIWSAMEYENYASU07)
    public String getZtymvaariwsameyenyasu07() {
        return ztymvaariwsameyenyasu07;
    }

    public void setZtymvaariwsameyenyasu07(String pZtymvaariwsameyenyasu07) {
        ztymvaariwsameyenyasu07 = pZtymvaariwsameyenyasu07;
    }

    private String ztymvaariumsameyendaka07;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARIUMSAMEYENDAKA07)
    public String getZtymvaariumsameyendaka07() {
        return ztymvaariumsameyendaka07;
    }

    public void setZtymvaariumsameyendaka07(String pZtymvaariumsameyendaka07) {
        ztymvaariumsameyendaka07 = pZtymvaariumsameyendaka07;
    }

    private String ztymvaariumsameyenkijyun07;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARIUMSAMEYENKIJYUN07)
    public String getZtymvaariumsameyenkijyun07() {
        return ztymvaariumsameyenkijyun07;
    }

    public void setZtymvaariumsameyenkijyun07(String pZtymvaariumsameyenkijyun07) {
        ztymvaariumsameyenkijyun07 = pZtymvaariumsameyenkijyun07;
    }

    private String ztymvaariumsameyenyasu07;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARIUMSAMEYENYASU07)
    public String getZtymvaariumsameyenyasu07() {
        return ztymvaariumsameyenyasu07;
    }

    public void setZtymvaariumsameyenyasu07(String pZtymvaariumsameyenyasu07) {
        ztymvaariumsameyenyasu07 = pZtymvaariumsameyenyasu07;
    }

    private String ztymvaariwtuktypedown07;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARIWTUKTYPEDOWN07)
    public String getZtymvaariwtuktypedown07() {
        return ztymvaariwtuktypedown07;
    }

    public void setZtymvaariwtuktypedown07(String pZtymvaariwtuktypedown07) {
        ztymvaariwtuktypedown07 = pZtymvaariwtuktypedown07;
    }

    private String ztymvaaritmttknkykkjmdown07;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARITMTTKNKYKKJMDOWN07)
    public String getZtymvaaritmttknkykkjmdown07() {
        return ztymvaaritmttknkykkjmdown07;
    }

    public void setZtymvaaritmttknkykkjmdown07(String pZtymvaaritmttknkykkjmdown07) {
        ztymvaaritmttknkykkjmdown07 = pZtymvaaritmttknkykkjmdown07;
    }

    private String ztymvaariwdown07;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARIWDOWN07)
    public String getZtymvaariwdown07() {
        return ztymvaariwdown07;
    }

    public void setZtymvaariwdown07(String pZtymvaariwdown07) {
        ztymvaariwdown07 = pZtymvaariwdown07;
    }

    private String ztymvaariwyentuktypedown07;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARIWYENTUKTYPEDOWN07)
    public String getZtymvaariwyentuktypedown07() {
        return ztymvaariwyentuktypedown07;
    }

    public void setZtymvaariwyentuktypedown07(String pZtymvaariwyentuktypedown07) {
        ztymvaariwyentuktypedown07 = pZtymvaariwyentuktypedown07;
    }

    private String ztymvaariwdownyendaka07;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARIWDOWNYENDAKA07)
    public String getZtymvaariwdownyendaka07() {
        return ztymvaariwdownyendaka07;
    }

    public void setZtymvaariwdownyendaka07(String pZtymvaariwdownyendaka07) {
        ztymvaariwdownyendaka07 = pZtymvaariwdownyendaka07;
    }

    private String ztymvaariwdownyenkijyun07;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARIWDOWNYENKIJYUN07)
    public String getZtymvaariwdownyenkijyun07() {
        return ztymvaariwdownyenkijyun07;
    }

    public void setZtymvaariwdownyenkijyun07(String pZtymvaariwdownyenkijyun07) {
        ztymvaariwdownyenkijyun07 = pZtymvaariwdownyenkijyun07;
    }

    private String ztymvaariwdownyenyasu07;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARIWDOWNYENYASU07)
    public String getZtymvaariwdownyenyasu07() {
        return ztymvaariwdownyenyasu07;
    }

    public void setZtymvaariwdownyenyasu07(String pZtymvaariwdownyenyasu07) {
        ztymvaariwdownyenyasu07 = pZtymvaariwdownyenyasu07;
    }

    private String ztymvaariumdownyendaka07;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARIUMDOWNYENDAKA07)
    public String getZtymvaariumdownyendaka07() {
        return ztymvaariumdownyendaka07;
    }

    public void setZtymvaariumdownyendaka07(String pZtymvaariumdownyendaka07) {
        ztymvaariumdownyendaka07 = pZtymvaariumdownyendaka07;
    }

    private String ztymvaariumdownyenkijyun07;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARIUMDOWNYENKIJYUN07)
    public String getZtymvaariumdownyenkijyun07() {
        return ztymvaariumdownyenkijyun07;
    }

    public void setZtymvaariumdownyenkijyun07(String pZtymvaariumdownyenkijyun07) {
        ztymvaariumdownyenkijyun07 = pZtymvaariumdownyenkijyun07;
    }

    private String ztymvaariumdownyenyasu07;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARIUMDOWNYENYASU07)
    public String getZtymvaariumdownyenyasu07() {
        return ztymvaariumdownyenyasu07;
    }

    public void setZtymvaariumdownyenyasu07(String pZtymvaariumdownyenyasu07) {
        ztymvaariumdownyenyasu07 = pZtymvaariumdownyenyasu07;
    }

    private String ztymvaarivtuktype07;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARIVTUKTYPE07)
    public String getZtymvaarivtuktype07() {
        return ztymvaarivtuktype07;
    }

    public void setZtymvaarivtuktype07(String pZtymvaarivtuktype07) {
        ztymvaarivtuktype07 = pZtymvaarivtuktype07;
    }

    private String ztymvaariv07;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARIV07)
    public String getZtymvaariv07() {
        return ztymvaariv07;
    }

    public void setZtymvaariv07(String pZtymvaariv07) {
        ztymvaariv07 = pZtymvaariv07;
    }

    private String ztyptmttkngkutiwake107;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYPTMTTKNGKUTIWAKE107)
    public String getZtyptmttkngkutiwake107() {
        return ztyptmttkngkutiwake107;
    }

    public void setZtyptmttkngkutiwake107(String pZtyptmttkngkutiwake107) {
        ztyptmttkngkutiwake107 = pZtyptmttkngkutiwake107;
    }

    private String ztyptmttkngkutiwake207;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYPTMTTKNGKUTIWAKE207)
    public String getZtyptmttkngkutiwake207() {
        return ztyptmttkngkutiwake207;
    }

    public void setZtyptmttkngkutiwake207(String pZtyptmttkngkutiwake207) {
        ztyptmttkngkutiwake207 = pZtyptmttkngkutiwake207;
    }

    private String ztymvaarinenoutouym08;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARINENOUTOUYM08)
    public String getZtymvaarinenoutouym08() {
        return ztymvaarinenoutouym08;
    }

    public void setZtymvaarinenoutouym08(String pZtymvaarinenoutouym08) {
        ztymvaarinenoutouym08 = pZtymvaarinenoutouym08;
    }

    private String ztymvaarisisuuupritu08;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARISISUUUPRITU08)
    public String getZtymvaarisisuuupritu08() {
        return ztymvaarisisuuupritu08;
    }

    @DataConvert("toMultiByte")
    public void setZtymvaarisisuuupritu08(String pZtymvaarisisuuupritu08) {
        ztymvaarisisuuupritu08 = pZtymvaarisisuuupritu08;
    }

    private String ztymvaaritmttknzkritu08;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARITMTTKNZKRITU08)
    public String getZtymvaaritmttknzkritu08() {
        return ztymvaaritmttknzkritu08;
    }

    @DataConvert("toMultiByte")
    public void setZtymvaaritmttknzkritu08(String pZtymvaaritmttknzkritu08) {
        ztymvaaritmttknzkritu08 = pZtymvaaritmttknzkritu08;
    }

    private String ztymvaariwtuktypeup08;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARIWTUKTYPEUP08)
    public String getZtymvaariwtuktypeup08() {
        return ztymvaariwtuktypeup08;
    }

    public void setZtymvaariwtuktypeup08(String pZtymvaariwtuktypeup08) {
        ztymvaariwtuktypeup08 = pZtymvaariwtuktypeup08;
    }

    private String ztymvaaritmttknkykkjmup08;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARITMTTKNKYKKJMUP08)
    public String getZtymvaaritmttknkykkjmup08() {
        return ztymvaaritmttknkykkjmup08;
    }

    public void setZtymvaaritmttknkykkjmup08(String pZtymvaaritmttknkykkjmup08) {
        ztymvaaritmttknkykkjmup08 = pZtymvaaritmttknkykkjmup08;
    }

    private String ztymvaariwup08;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARIWUP08)
    public String getZtymvaariwup08() {
        return ztymvaariwup08;
    }

    public void setZtymvaariwup08(String pZtymvaariwup08) {
        ztymvaariwup08 = pZtymvaariwup08;
    }

    private String ztymvaariwyentuktypeup08;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARIWYENTUKTYPEUP08)
    public String getZtymvaariwyentuktypeup08() {
        return ztymvaariwyentuktypeup08;
    }

    public void setZtymvaariwyentuktypeup08(String pZtymvaariwyentuktypeup08) {
        ztymvaariwyentuktypeup08 = pZtymvaariwyentuktypeup08;
    }

    private String ztymvaariwupyendaka08;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARIWUPYENDAKA08)
    public String getZtymvaariwupyendaka08() {
        return ztymvaariwupyendaka08;
    }

    public void setZtymvaariwupyendaka08(String pZtymvaariwupyendaka08) {
        ztymvaariwupyendaka08 = pZtymvaariwupyendaka08;
    }

    private String ztymvaariwupyenkijyun08;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARIWUPYENKIJYUN08)
    public String getZtymvaariwupyenkijyun08() {
        return ztymvaariwupyenkijyun08;
    }

    public void setZtymvaariwupyenkijyun08(String pZtymvaariwupyenkijyun08) {
        ztymvaariwupyenkijyun08 = pZtymvaariwupyenkijyun08;
    }

    private String ztymvaariwupyenyasu08;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARIWUPYENYASU08)
    public String getZtymvaariwupyenyasu08() {
        return ztymvaariwupyenyasu08;
    }

    public void setZtymvaariwupyenyasu08(String pZtymvaariwupyenyasu08) {
        ztymvaariwupyenyasu08 = pZtymvaariwupyenyasu08;
    }

    private String ztymvaariwumupyendaka08;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARIWUMUPYENDAKA08)
    public String getZtymvaariwumupyendaka08() {
        return ztymvaariwumupyendaka08;
    }

    public void setZtymvaariwumupyendaka08(String pZtymvaariwumupyendaka08) {
        ztymvaariwumupyendaka08 = pZtymvaariwumupyendaka08;
    }

    private String ztymvaariumupyenkijyun08;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARIUMUPYENKIJYUN08)
    public String getZtymvaariumupyenkijyun08() {
        return ztymvaariumupyenkijyun08;
    }

    public void setZtymvaariumupyenkijyun08(String pZtymvaariumupyenkijyun08) {
        ztymvaariumupyenkijyun08 = pZtymvaariumupyenkijyun08;
    }

    private String ztymvaariumupyenyasu08;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARIUMUPYENYASU08)
    public String getZtymvaariumupyenyasu08() {
        return ztymvaariumupyenyasu08;
    }

    public void setZtymvaariumupyenyasu08(String pZtymvaariumupyenyasu08) {
        ztymvaariumupyenyasu08 = pZtymvaariumupyenyasu08;
    }

    private String ztymvaariwtuktypesame08;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARIWTUKTYPESAME08)
    public String getZtymvaariwtuktypesame08() {
        return ztymvaariwtuktypesame08;
    }

    public void setZtymvaariwtuktypesame08(String pZtymvaariwtuktypesame08) {
        ztymvaariwtuktypesame08 = pZtymvaariwtuktypesame08;
    }

    private String ztymvaaritmttknkykkjmsame08;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARITMTTKNKYKKJMSAME08)
    public String getZtymvaaritmttknkykkjmsame08() {
        return ztymvaaritmttknkykkjmsame08;
    }

    public void setZtymvaaritmttknkykkjmsame08(String pZtymvaaritmttknkykkjmsame08) {
        ztymvaaritmttknkykkjmsame08 = pZtymvaaritmttknkykkjmsame08;
    }

    private String ztymvaariwsame08;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARIWSAME08)
    public String getZtymvaariwsame08() {
        return ztymvaariwsame08;
    }

    public void setZtymvaariwsame08(String pZtymvaariwsame08) {
        ztymvaariwsame08 = pZtymvaariwsame08;
    }

    private String ztymvaariwyentuktypesame08;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARIWYENTUKTYPESAME08)
    public String getZtymvaariwyentuktypesame08() {
        return ztymvaariwyentuktypesame08;
    }

    public void setZtymvaariwyentuktypesame08(String pZtymvaariwyentuktypesame08) {
        ztymvaariwyentuktypesame08 = pZtymvaariwyentuktypesame08;
    }

    private String ztymvaariwsameyendaka08;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARIWSAMEYENDAKA08)
    public String getZtymvaariwsameyendaka08() {
        return ztymvaariwsameyendaka08;
    }

    public void setZtymvaariwsameyendaka08(String pZtymvaariwsameyendaka08) {
        ztymvaariwsameyendaka08 = pZtymvaariwsameyendaka08;
    }

    private String ztymvaariwsameyenkijyun08;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARIWSAMEYENKIJYUN08)
    public String getZtymvaariwsameyenkijyun08() {
        return ztymvaariwsameyenkijyun08;
    }

    public void setZtymvaariwsameyenkijyun08(String pZtymvaariwsameyenkijyun08) {
        ztymvaariwsameyenkijyun08 = pZtymvaariwsameyenkijyun08;
    }

    private String ztymvaariwsameyenyasu08;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARIWSAMEYENYASU08)
    public String getZtymvaariwsameyenyasu08() {
        return ztymvaariwsameyenyasu08;
    }

    public void setZtymvaariwsameyenyasu08(String pZtymvaariwsameyenyasu08) {
        ztymvaariwsameyenyasu08 = pZtymvaariwsameyenyasu08;
    }

    private String ztymvaariumsameyendaka08;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARIUMSAMEYENDAKA08)
    public String getZtymvaariumsameyendaka08() {
        return ztymvaariumsameyendaka08;
    }

    public void setZtymvaariumsameyendaka08(String pZtymvaariumsameyendaka08) {
        ztymvaariumsameyendaka08 = pZtymvaariumsameyendaka08;
    }

    private String ztymvaariumsameyenkijyun08;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARIUMSAMEYENKIJYUN08)
    public String getZtymvaariumsameyenkijyun08() {
        return ztymvaariumsameyenkijyun08;
    }

    public void setZtymvaariumsameyenkijyun08(String pZtymvaariumsameyenkijyun08) {
        ztymvaariumsameyenkijyun08 = pZtymvaariumsameyenkijyun08;
    }

    private String ztymvaariumsameyenyasu08;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARIUMSAMEYENYASU08)
    public String getZtymvaariumsameyenyasu08() {
        return ztymvaariumsameyenyasu08;
    }

    public void setZtymvaariumsameyenyasu08(String pZtymvaariumsameyenyasu08) {
        ztymvaariumsameyenyasu08 = pZtymvaariumsameyenyasu08;
    }

    private String ztymvaariwtuktypedown08;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARIWTUKTYPEDOWN08)
    public String getZtymvaariwtuktypedown08() {
        return ztymvaariwtuktypedown08;
    }

    public void setZtymvaariwtuktypedown08(String pZtymvaariwtuktypedown08) {
        ztymvaariwtuktypedown08 = pZtymvaariwtuktypedown08;
    }

    private String ztymvaaritmttknkykkjmdown08;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARITMTTKNKYKKJMDOWN08)
    public String getZtymvaaritmttknkykkjmdown08() {
        return ztymvaaritmttknkykkjmdown08;
    }

    public void setZtymvaaritmttknkykkjmdown08(String pZtymvaaritmttknkykkjmdown08) {
        ztymvaaritmttknkykkjmdown08 = pZtymvaaritmttknkykkjmdown08;
    }

    private String ztymvaariwdown08;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARIWDOWN08)
    public String getZtymvaariwdown08() {
        return ztymvaariwdown08;
    }

    public void setZtymvaariwdown08(String pZtymvaariwdown08) {
        ztymvaariwdown08 = pZtymvaariwdown08;
    }

    private String ztymvaariwyentuktypedown08;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARIWYENTUKTYPEDOWN08)
    public String getZtymvaariwyentuktypedown08() {
        return ztymvaariwyentuktypedown08;
    }

    public void setZtymvaariwyentuktypedown08(String pZtymvaariwyentuktypedown08) {
        ztymvaariwyentuktypedown08 = pZtymvaariwyentuktypedown08;
    }

    private String ztymvaariwdownyendaka08;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARIWDOWNYENDAKA08)
    public String getZtymvaariwdownyendaka08() {
        return ztymvaariwdownyendaka08;
    }

    public void setZtymvaariwdownyendaka08(String pZtymvaariwdownyendaka08) {
        ztymvaariwdownyendaka08 = pZtymvaariwdownyendaka08;
    }

    private String ztymvaariwdownyenkijyun08;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARIWDOWNYENKIJYUN08)
    public String getZtymvaariwdownyenkijyun08() {
        return ztymvaariwdownyenkijyun08;
    }

    public void setZtymvaariwdownyenkijyun08(String pZtymvaariwdownyenkijyun08) {
        ztymvaariwdownyenkijyun08 = pZtymvaariwdownyenkijyun08;
    }

    private String ztymvaariwdownyenyasu08;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARIWDOWNYENYASU08)
    public String getZtymvaariwdownyenyasu08() {
        return ztymvaariwdownyenyasu08;
    }

    public void setZtymvaariwdownyenyasu08(String pZtymvaariwdownyenyasu08) {
        ztymvaariwdownyenyasu08 = pZtymvaariwdownyenyasu08;
    }

    private String ztymvaariumdownyendaka08;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARIUMDOWNYENDAKA08)
    public String getZtymvaariumdownyendaka08() {
        return ztymvaariumdownyendaka08;
    }

    public void setZtymvaariumdownyendaka08(String pZtymvaariumdownyendaka08) {
        ztymvaariumdownyendaka08 = pZtymvaariumdownyendaka08;
    }

    private String ztymvaariumdownyenkijyun08;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARIUMDOWNYENKIJYUN08)
    public String getZtymvaariumdownyenkijyun08() {
        return ztymvaariumdownyenkijyun08;
    }

    public void setZtymvaariumdownyenkijyun08(String pZtymvaariumdownyenkijyun08) {
        ztymvaariumdownyenkijyun08 = pZtymvaariumdownyenkijyun08;
    }

    private String ztymvaariumdownyenyasu08;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARIUMDOWNYENYASU08)
    public String getZtymvaariumdownyenyasu08() {
        return ztymvaariumdownyenyasu08;
    }

    public void setZtymvaariumdownyenyasu08(String pZtymvaariumdownyenyasu08) {
        ztymvaariumdownyenyasu08 = pZtymvaariumdownyenyasu08;
    }

    private String ztymvaarivtuktype08;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARIVTUKTYPE08)
    public String getZtymvaarivtuktype08() {
        return ztymvaarivtuktype08;
    }

    public void setZtymvaarivtuktype08(String pZtymvaarivtuktype08) {
        ztymvaarivtuktype08 = pZtymvaarivtuktype08;
    }

    private String ztymvaariv08;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARIV08)
    public String getZtymvaariv08() {
        return ztymvaariv08;
    }

    public void setZtymvaariv08(String pZtymvaariv08) {
        ztymvaariv08 = pZtymvaariv08;
    }

    private String ztyptmttkngkutiwake108;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYPTMTTKNGKUTIWAKE108)
    public String getZtyptmttkngkutiwake108() {
        return ztyptmttkngkutiwake108;
    }

    public void setZtyptmttkngkutiwake108(String pZtyptmttkngkutiwake108) {
        ztyptmttkngkutiwake108 = pZtyptmttkngkutiwake108;
    }

    private String ztyptmttkngkutiwake208;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYPTMTTKNGKUTIWAKE208)
    public String getZtyptmttkngkutiwake208() {
        return ztyptmttkngkutiwake208;
    }

    public void setZtyptmttkngkutiwake208(String pZtyptmttkngkutiwake208) {
        ztyptmttkngkutiwake208 = pZtyptmttkngkutiwake208;
    }

    private String ztymvaarinenoutouym09;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARINENOUTOUYM09)
    public String getZtymvaarinenoutouym09() {
        return ztymvaarinenoutouym09;
    }

    public void setZtymvaarinenoutouym09(String pZtymvaarinenoutouym09) {
        ztymvaarinenoutouym09 = pZtymvaarinenoutouym09;
    }

    private String ztymvaarisisuuupritu09;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARISISUUUPRITU09)
    public String getZtymvaarisisuuupritu09() {
        return ztymvaarisisuuupritu09;
    }

    @DataConvert("toMultiByte")
    public void setZtymvaarisisuuupritu09(String pZtymvaarisisuuupritu09) {
        ztymvaarisisuuupritu09 = pZtymvaarisisuuupritu09;
    }

    private String ztymvaaritmttknzkritu09;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARITMTTKNZKRITU09)
    public String getZtymvaaritmttknzkritu09() {
        return ztymvaaritmttknzkritu09;
    }

    @DataConvert("toMultiByte")
    public void setZtymvaaritmttknzkritu09(String pZtymvaaritmttknzkritu09) {
        ztymvaaritmttknzkritu09 = pZtymvaaritmttknzkritu09;
    }

    private String ztymvaariwtuktypeup09;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARIWTUKTYPEUP09)
    public String getZtymvaariwtuktypeup09() {
        return ztymvaariwtuktypeup09;
    }

    public void setZtymvaariwtuktypeup09(String pZtymvaariwtuktypeup09) {
        ztymvaariwtuktypeup09 = pZtymvaariwtuktypeup09;
    }

    private String ztymvaaritmttknkykkjmup09;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARITMTTKNKYKKJMUP09)
    public String getZtymvaaritmttknkykkjmup09() {
        return ztymvaaritmttknkykkjmup09;
    }

    public void setZtymvaaritmttknkykkjmup09(String pZtymvaaritmttknkykkjmup09) {
        ztymvaaritmttknkykkjmup09 = pZtymvaaritmttknkykkjmup09;
    }

    private String ztymvaariwup09;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARIWUP09)
    public String getZtymvaariwup09() {
        return ztymvaariwup09;
    }

    public void setZtymvaariwup09(String pZtymvaariwup09) {
        ztymvaariwup09 = pZtymvaariwup09;
    }

    private String ztymvaariwyentuktypeup09;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARIWYENTUKTYPEUP09)
    public String getZtymvaariwyentuktypeup09() {
        return ztymvaariwyentuktypeup09;
    }

    public void setZtymvaariwyentuktypeup09(String pZtymvaariwyentuktypeup09) {
        ztymvaariwyentuktypeup09 = pZtymvaariwyentuktypeup09;
    }

    private String ztymvaariwupyendaka09;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARIWUPYENDAKA09)
    public String getZtymvaariwupyendaka09() {
        return ztymvaariwupyendaka09;
    }

    public void setZtymvaariwupyendaka09(String pZtymvaariwupyendaka09) {
        ztymvaariwupyendaka09 = pZtymvaariwupyendaka09;
    }

    private String ztymvaariwupyenkijyun09;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARIWUPYENKIJYUN09)
    public String getZtymvaariwupyenkijyun09() {
        return ztymvaariwupyenkijyun09;
    }

    public void setZtymvaariwupyenkijyun09(String pZtymvaariwupyenkijyun09) {
        ztymvaariwupyenkijyun09 = pZtymvaariwupyenkijyun09;
    }

    private String ztymvaariwupyenyasu09;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARIWUPYENYASU09)
    public String getZtymvaariwupyenyasu09() {
        return ztymvaariwupyenyasu09;
    }

    public void setZtymvaariwupyenyasu09(String pZtymvaariwupyenyasu09) {
        ztymvaariwupyenyasu09 = pZtymvaariwupyenyasu09;
    }

    private String ztymvaariwumupyendaka09;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARIWUMUPYENDAKA09)
    public String getZtymvaariwumupyendaka09() {
        return ztymvaariwumupyendaka09;
    }

    public void setZtymvaariwumupyendaka09(String pZtymvaariwumupyendaka09) {
        ztymvaariwumupyendaka09 = pZtymvaariwumupyendaka09;
    }

    private String ztymvaariumupyenkijyun09;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARIUMUPYENKIJYUN09)
    public String getZtymvaariumupyenkijyun09() {
        return ztymvaariumupyenkijyun09;
    }

    public void setZtymvaariumupyenkijyun09(String pZtymvaariumupyenkijyun09) {
        ztymvaariumupyenkijyun09 = pZtymvaariumupyenkijyun09;
    }

    private String ztymvaariumupyenyasu09;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARIUMUPYENYASU09)
    public String getZtymvaariumupyenyasu09() {
        return ztymvaariumupyenyasu09;
    }

    public void setZtymvaariumupyenyasu09(String pZtymvaariumupyenyasu09) {
        ztymvaariumupyenyasu09 = pZtymvaariumupyenyasu09;
    }

    private String ztymvaariwtuktypesame09;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARIWTUKTYPESAME09)
    public String getZtymvaariwtuktypesame09() {
        return ztymvaariwtuktypesame09;
    }

    public void setZtymvaariwtuktypesame09(String pZtymvaariwtuktypesame09) {
        ztymvaariwtuktypesame09 = pZtymvaariwtuktypesame09;
    }

    private String ztymvaaritmttknkykkjmsame09;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARITMTTKNKYKKJMSAME09)
    public String getZtymvaaritmttknkykkjmsame09() {
        return ztymvaaritmttknkykkjmsame09;
    }

    public void setZtymvaaritmttknkykkjmsame09(String pZtymvaaritmttknkykkjmsame09) {
        ztymvaaritmttknkykkjmsame09 = pZtymvaaritmttknkykkjmsame09;
    }

    private String ztymvaariwsame09;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARIWSAME09)
    public String getZtymvaariwsame09() {
        return ztymvaariwsame09;
    }

    public void setZtymvaariwsame09(String pZtymvaariwsame09) {
        ztymvaariwsame09 = pZtymvaariwsame09;
    }

    private String ztymvaariwyentuktypesame09;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARIWYENTUKTYPESAME09)
    public String getZtymvaariwyentuktypesame09() {
        return ztymvaariwyentuktypesame09;
    }

    public void setZtymvaariwyentuktypesame09(String pZtymvaariwyentuktypesame09) {
        ztymvaariwyentuktypesame09 = pZtymvaariwyentuktypesame09;
    }

    private String ztymvaariwsameyendaka09;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARIWSAMEYENDAKA09)
    public String getZtymvaariwsameyendaka09() {
        return ztymvaariwsameyendaka09;
    }

    public void setZtymvaariwsameyendaka09(String pZtymvaariwsameyendaka09) {
        ztymvaariwsameyendaka09 = pZtymvaariwsameyendaka09;
    }

    private String ztymvaariwsameyenkijyun09;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARIWSAMEYENKIJYUN09)
    public String getZtymvaariwsameyenkijyun09() {
        return ztymvaariwsameyenkijyun09;
    }

    public void setZtymvaariwsameyenkijyun09(String pZtymvaariwsameyenkijyun09) {
        ztymvaariwsameyenkijyun09 = pZtymvaariwsameyenkijyun09;
    }

    private String ztymvaariwsameyenyasu09;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARIWSAMEYENYASU09)
    public String getZtymvaariwsameyenyasu09() {
        return ztymvaariwsameyenyasu09;
    }

    public void setZtymvaariwsameyenyasu09(String pZtymvaariwsameyenyasu09) {
        ztymvaariwsameyenyasu09 = pZtymvaariwsameyenyasu09;
    }

    private String ztymvaariumsameyendaka09;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARIUMSAMEYENDAKA09)
    public String getZtymvaariumsameyendaka09() {
        return ztymvaariumsameyendaka09;
    }

    public void setZtymvaariumsameyendaka09(String pZtymvaariumsameyendaka09) {
        ztymvaariumsameyendaka09 = pZtymvaariumsameyendaka09;
    }

    private String ztymvaariumsameyenkijyun09;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARIUMSAMEYENKIJYUN09)
    public String getZtymvaariumsameyenkijyun09() {
        return ztymvaariumsameyenkijyun09;
    }

    public void setZtymvaariumsameyenkijyun09(String pZtymvaariumsameyenkijyun09) {
        ztymvaariumsameyenkijyun09 = pZtymvaariumsameyenkijyun09;
    }

    private String ztymvaariumsameyenyasu09;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARIUMSAMEYENYASU09)
    public String getZtymvaariumsameyenyasu09() {
        return ztymvaariumsameyenyasu09;
    }

    public void setZtymvaariumsameyenyasu09(String pZtymvaariumsameyenyasu09) {
        ztymvaariumsameyenyasu09 = pZtymvaariumsameyenyasu09;
    }

    private String ztymvaariwtuktypedown09;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARIWTUKTYPEDOWN09)
    public String getZtymvaariwtuktypedown09() {
        return ztymvaariwtuktypedown09;
    }

    public void setZtymvaariwtuktypedown09(String pZtymvaariwtuktypedown09) {
        ztymvaariwtuktypedown09 = pZtymvaariwtuktypedown09;
    }

    private String ztymvaaritmttknkykkjmdown09;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARITMTTKNKYKKJMDOWN09)
    public String getZtymvaaritmttknkykkjmdown09() {
        return ztymvaaritmttknkykkjmdown09;
    }

    public void setZtymvaaritmttknkykkjmdown09(String pZtymvaaritmttknkykkjmdown09) {
        ztymvaaritmttknkykkjmdown09 = pZtymvaaritmttknkykkjmdown09;
    }

    private String ztymvaariwdown09;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARIWDOWN09)
    public String getZtymvaariwdown09() {
        return ztymvaariwdown09;
    }

    public void setZtymvaariwdown09(String pZtymvaariwdown09) {
        ztymvaariwdown09 = pZtymvaariwdown09;
    }

    private String ztymvaariwyentuktypedown09;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARIWYENTUKTYPEDOWN09)
    public String getZtymvaariwyentuktypedown09() {
        return ztymvaariwyentuktypedown09;
    }

    public void setZtymvaariwyentuktypedown09(String pZtymvaariwyentuktypedown09) {
        ztymvaariwyentuktypedown09 = pZtymvaariwyentuktypedown09;
    }

    private String ztymvaariwdownyendaka09;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARIWDOWNYENDAKA09)
    public String getZtymvaariwdownyendaka09() {
        return ztymvaariwdownyendaka09;
    }

    public void setZtymvaariwdownyendaka09(String pZtymvaariwdownyendaka09) {
        ztymvaariwdownyendaka09 = pZtymvaariwdownyendaka09;
    }

    private String ztymvaariwdownyenkijyun09;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARIWDOWNYENKIJYUN09)
    public String getZtymvaariwdownyenkijyun09() {
        return ztymvaariwdownyenkijyun09;
    }

    public void setZtymvaariwdownyenkijyun09(String pZtymvaariwdownyenkijyun09) {
        ztymvaariwdownyenkijyun09 = pZtymvaariwdownyenkijyun09;
    }

    private String ztymvaariwdownyenyasu09;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARIWDOWNYENYASU09)
    public String getZtymvaariwdownyenyasu09() {
        return ztymvaariwdownyenyasu09;
    }

    public void setZtymvaariwdownyenyasu09(String pZtymvaariwdownyenyasu09) {
        ztymvaariwdownyenyasu09 = pZtymvaariwdownyenyasu09;
    }

    private String ztymvaariumdownyendaka09;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARIUMDOWNYENDAKA09)
    public String getZtymvaariumdownyendaka09() {
        return ztymvaariumdownyendaka09;
    }

    public void setZtymvaariumdownyendaka09(String pZtymvaariumdownyendaka09) {
        ztymvaariumdownyendaka09 = pZtymvaariumdownyendaka09;
    }

    private String ztymvaariumdownyenkijyun09;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARIUMDOWNYENKIJYUN09)
    public String getZtymvaariumdownyenkijyun09() {
        return ztymvaariumdownyenkijyun09;
    }

    public void setZtymvaariumdownyenkijyun09(String pZtymvaariumdownyenkijyun09) {
        ztymvaariumdownyenkijyun09 = pZtymvaariumdownyenkijyun09;
    }

    private String ztymvaariumdownyenyasu09;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARIUMDOWNYENYASU09)
    public String getZtymvaariumdownyenyasu09() {
        return ztymvaariumdownyenyasu09;
    }

    public void setZtymvaariumdownyenyasu09(String pZtymvaariumdownyenyasu09) {
        ztymvaariumdownyenyasu09 = pZtymvaariumdownyenyasu09;
    }

    private String ztymvaarivtuktype09;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARIVTUKTYPE09)
    public String getZtymvaarivtuktype09() {
        return ztymvaarivtuktype09;
    }

    public void setZtymvaarivtuktype09(String pZtymvaarivtuktype09) {
        ztymvaarivtuktype09 = pZtymvaarivtuktype09;
    }

    private String ztymvaariv09;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARIV09)
    public String getZtymvaariv09() {
        return ztymvaariv09;
    }

    public void setZtymvaariv09(String pZtymvaariv09) {
        ztymvaariv09 = pZtymvaariv09;
    }

    private String ztyptmttkngkutiwake109;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYPTMTTKNGKUTIWAKE109)
    public String getZtyptmttkngkutiwake109() {
        return ztyptmttkngkutiwake109;
    }

    public void setZtyptmttkngkutiwake109(String pZtyptmttkngkutiwake109) {
        ztyptmttkngkutiwake109 = pZtyptmttkngkutiwake109;
    }

    private String ztyptmttkngkutiwake209;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYPTMTTKNGKUTIWAKE209)
    public String getZtyptmttkngkutiwake209() {
        return ztyptmttkngkutiwake209;
    }

    public void setZtyptmttkngkutiwake209(String pZtyptmttkngkutiwake209) {
        ztyptmttkngkutiwake209 = pZtyptmttkngkutiwake209;
    }

    private String ztymvaarinenoutouym10;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARINENOUTOUYM10)
    public String getZtymvaarinenoutouym10() {
        return ztymvaarinenoutouym10;
    }

    public void setZtymvaarinenoutouym10(String pZtymvaarinenoutouym10) {
        ztymvaarinenoutouym10 = pZtymvaarinenoutouym10;
    }

    private String ztymvaarisisuuupritu10;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARISISUUUPRITU10)
    public String getZtymvaarisisuuupritu10() {
        return ztymvaarisisuuupritu10;
    }

    @DataConvert("toMultiByte")
    public void setZtymvaarisisuuupritu10(String pZtymvaarisisuuupritu10) {
        ztymvaarisisuuupritu10 = pZtymvaarisisuuupritu10;
    }

    private String ztymvaaritmttknzkritu10;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARITMTTKNZKRITU10)
    public String getZtymvaaritmttknzkritu10() {
        return ztymvaaritmttknzkritu10;
    }

    @DataConvert("toMultiByte")
    public void setZtymvaaritmttknzkritu10(String pZtymvaaritmttknzkritu10) {
        ztymvaaritmttknzkritu10 = pZtymvaaritmttknzkritu10;
    }

    private String ztymvaariwtuktypeup10;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARIWTUKTYPEUP10)
    public String getZtymvaariwtuktypeup10() {
        return ztymvaariwtuktypeup10;
    }

    public void setZtymvaariwtuktypeup10(String pZtymvaariwtuktypeup10) {
        ztymvaariwtuktypeup10 = pZtymvaariwtuktypeup10;
    }

    private String ztymvaaritmttknkykkjmup10;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARITMTTKNKYKKJMUP10)
    public String getZtymvaaritmttknkykkjmup10() {
        return ztymvaaritmttknkykkjmup10;
    }

    public void setZtymvaaritmttknkykkjmup10(String pZtymvaaritmttknkykkjmup10) {
        ztymvaaritmttknkykkjmup10 = pZtymvaaritmttknkykkjmup10;
    }

    private String ztymvaariwup10;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARIWUP10)
    public String getZtymvaariwup10() {
        return ztymvaariwup10;
    }

    public void setZtymvaariwup10(String pZtymvaariwup10) {
        ztymvaariwup10 = pZtymvaariwup10;
    }

    private String ztymvaariwyentuktypeup10;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARIWYENTUKTYPEUP10)
    public String getZtymvaariwyentuktypeup10() {
        return ztymvaariwyentuktypeup10;
    }

    public void setZtymvaariwyentuktypeup10(String pZtymvaariwyentuktypeup10) {
        ztymvaariwyentuktypeup10 = pZtymvaariwyentuktypeup10;
    }

    private String ztymvaariwupyendaka10;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARIWUPYENDAKA10)
    public String getZtymvaariwupyendaka10() {
        return ztymvaariwupyendaka10;
    }

    public void setZtymvaariwupyendaka10(String pZtymvaariwupyendaka10) {
        ztymvaariwupyendaka10 = pZtymvaariwupyendaka10;
    }

    private String ztymvaariwupyenkijyun10;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARIWUPYENKIJYUN10)
    public String getZtymvaariwupyenkijyun10() {
        return ztymvaariwupyenkijyun10;
    }

    public void setZtymvaariwupyenkijyun10(String pZtymvaariwupyenkijyun10) {
        ztymvaariwupyenkijyun10 = pZtymvaariwupyenkijyun10;
    }

    private String ztymvaariwupyenyasu10;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARIWUPYENYASU10)
    public String getZtymvaariwupyenyasu10() {
        return ztymvaariwupyenyasu10;
    }

    public void setZtymvaariwupyenyasu10(String pZtymvaariwupyenyasu10) {
        ztymvaariwupyenyasu10 = pZtymvaariwupyenyasu10;
    }

    private String ztymvaariwumupyendaka10;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARIWUMUPYENDAKA10)
    public String getZtymvaariwumupyendaka10() {
        return ztymvaariwumupyendaka10;
    }

    public void setZtymvaariwumupyendaka10(String pZtymvaariwumupyendaka10) {
        ztymvaariwumupyendaka10 = pZtymvaariwumupyendaka10;
    }

    private String ztymvaariumupyenkijyun10;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARIUMUPYENKIJYUN10)
    public String getZtymvaariumupyenkijyun10() {
        return ztymvaariumupyenkijyun10;
    }

    public void setZtymvaariumupyenkijyun10(String pZtymvaariumupyenkijyun10) {
        ztymvaariumupyenkijyun10 = pZtymvaariumupyenkijyun10;
    }

    private String ztymvaariumupyenyasu10;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARIUMUPYENYASU10)
    public String getZtymvaariumupyenyasu10() {
        return ztymvaariumupyenyasu10;
    }

    public void setZtymvaariumupyenyasu10(String pZtymvaariumupyenyasu10) {
        ztymvaariumupyenyasu10 = pZtymvaariumupyenyasu10;
    }

    private String ztymvaariwtuktypesame10;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARIWTUKTYPESAME10)
    public String getZtymvaariwtuktypesame10() {
        return ztymvaariwtuktypesame10;
    }

    public void setZtymvaariwtuktypesame10(String pZtymvaariwtuktypesame10) {
        ztymvaariwtuktypesame10 = pZtymvaariwtuktypesame10;
    }

    private String ztymvaaritmttknkykkjmsame10;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARITMTTKNKYKKJMSAME10)
    public String getZtymvaaritmttknkykkjmsame10() {
        return ztymvaaritmttknkykkjmsame10;
    }

    public void setZtymvaaritmttknkykkjmsame10(String pZtymvaaritmttknkykkjmsame10) {
        ztymvaaritmttknkykkjmsame10 = pZtymvaaritmttknkykkjmsame10;
    }

    private String ztymvaariwsame10;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARIWSAME10)
    public String getZtymvaariwsame10() {
        return ztymvaariwsame10;
    }

    public void setZtymvaariwsame10(String pZtymvaariwsame10) {
        ztymvaariwsame10 = pZtymvaariwsame10;
    }

    private String ztymvaariwyentuktypesame10;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARIWYENTUKTYPESAME10)
    public String getZtymvaariwyentuktypesame10() {
        return ztymvaariwyentuktypesame10;
    }

    public void setZtymvaariwyentuktypesame10(String pZtymvaariwyentuktypesame10) {
        ztymvaariwyentuktypesame10 = pZtymvaariwyentuktypesame10;
    }

    private String ztymvaariwsameyendaka10;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARIWSAMEYENDAKA10)
    public String getZtymvaariwsameyendaka10() {
        return ztymvaariwsameyendaka10;
    }

    public void setZtymvaariwsameyendaka10(String pZtymvaariwsameyendaka10) {
        ztymvaariwsameyendaka10 = pZtymvaariwsameyendaka10;
    }

    private String ztymvaariwsameyenkijyun10;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARIWSAMEYENKIJYUN10)
    public String getZtymvaariwsameyenkijyun10() {
        return ztymvaariwsameyenkijyun10;
    }

    public void setZtymvaariwsameyenkijyun10(String pZtymvaariwsameyenkijyun10) {
        ztymvaariwsameyenkijyun10 = pZtymvaariwsameyenkijyun10;
    }

    private String ztymvaariwsameyenyasu10;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARIWSAMEYENYASU10)
    public String getZtymvaariwsameyenyasu10() {
        return ztymvaariwsameyenyasu10;
    }

    public void setZtymvaariwsameyenyasu10(String pZtymvaariwsameyenyasu10) {
        ztymvaariwsameyenyasu10 = pZtymvaariwsameyenyasu10;
    }

    private String ztymvaariumsameyendaka10;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARIUMSAMEYENDAKA10)
    public String getZtymvaariumsameyendaka10() {
        return ztymvaariumsameyendaka10;
    }

    public void setZtymvaariumsameyendaka10(String pZtymvaariumsameyendaka10) {
        ztymvaariumsameyendaka10 = pZtymvaariumsameyendaka10;
    }

    private String ztymvaariumsameyenkijyun10;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARIUMSAMEYENKIJYUN10)
    public String getZtymvaariumsameyenkijyun10() {
        return ztymvaariumsameyenkijyun10;
    }

    public void setZtymvaariumsameyenkijyun10(String pZtymvaariumsameyenkijyun10) {
        ztymvaariumsameyenkijyun10 = pZtymvaariumsameyenkijyun10;
    }

    private String ztymvaariumsameyenyasu10;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARIUMSAMEYENYASU10)
    public String getZtymvaariumsameyenyasu10() {
        return ztymvaariumsameyenyasu10;
    }

    public void setZtymvaariumsameyenyasu10(String pZtymvaariumsameyenyasu10) {
        ztymvaariumsameyenyasu10 = pZtymvaariumsameyenyasu10;
    }

    private String ztymvaariwtuktypedown10;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARIWTUKTYPEDOWN10)
    public String getZtymvaariwtuktypedown10() {
        return ztymvaariwtuktypedown10;
    }

    public void setZtymvaariwtuktypedown10(String pZtymvaariwtuktypedown10) {
        ztymvaariwtuktypedown10 = pZtymvaariwtuktypedown10;
    }

    private String ztymvaaritmttknkykkjmdown10;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARITMTTKNKYKKJMDOWN10)
    public String getZtymvaaritmttknkykkjmdown10() {
        return ztymvaaritmttknkykkjmdown10;
    }

    public void setZtymvaaritmttknkykkjmdown10(String pZtymvaaritmttknkykkjmdown10) {
        ztymvaaritmttknkykkjmdown10 = pZtymvaaritmttknkykkjmdown10;
    }

    private String ztymvaariwdown10;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARIWDOWN10)
    public String getZtymvaariwdown10() {
        return ztymvaariwdown10;
    }

    public void setZtymvaariwdown10(String pZtymvaariwdown10) {
        ztymvaariwdown10 = pZtymvaariwdown10;
    }

    private String ztymvaariwyentuktypedown10;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARIWYENTUKTYPEDOWN10)
    public String getZtymvaariwyentuktypedown10() {
        return ztymvaariwyentuktypedown10;
    }

    public void setZtymvaariwyentuktypedown10(String pZtymvaariwyentuktypedown10) {
        ztymvaariwyentuktypedown10 = pZtymvaariwyentuktypedown10;
    }

    private String ztymvaariwdownyendaka10;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARIWDOWNYENDAKA10)
    public String getZtymvaariwdownyendaka10() {
        return ztymvaariwdownyendaka10;
    }

    public void setZtymvaariwdownyendaka10(String pZtymvaariwdownyendaka10) {
        ztymvaariwdownyendaka10 = pZtymvaariwdownyendaka10;
    }

    private String ztymvaariwdownyenkijyun10;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARIWDOWNYENKIJYUN10)
    public String getZtymvaariwdownyenkijyun10() {
        return ztymvaariwdownyenkijyun10;
    }

    public void setZtymvaariwdownyenkijyun10(String pZtymvaariwdownyenkijyun10) {
        ztymvaariwdownyenkijyun10 = pZtymvaariwdownyenkijyun10;
    }

    private String ztymvaariwdownyenyasu10;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARIWDOWNYENYASU10)
    public String getZtymvaariwdownyenyasu10() {
        return ztymvaariwdownyenyasu10;
    }

    public void setZtymvaariwdownyenyasu10(String pZtymvaariwdownyenyasu10) {
        ztymvaariwdownyenyasu10 = pZtymvaariwdownyenyasu10;
    }

    private String ztymvaariumdownyendaka10;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARIUMDOWNYENDAKA10)
    public String getZtymvaariumdownyendaka10() {
        return ztymvaariumdownyendaka10;
    }

    public void setZtymvaariumdownyendaka10(String pZtymvaariumdownyendaka10) {
        ztymvaariumdownyendaka10 = pZtymvaariumdownyendaka10;
    }

    private String ztymvaariumdownyenkijyun10;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARIUMDOWNYENKIJYUN10)
    public String getZtymvaariumdownyenkijyun10() {
        return ztymvaariumdownyenkijyun10;
    }

    public void setZtymvaariumdownyenkijyun10(String pZtymvaariumdownyenkijyun10) {
        ztymvaariumdownyenkijyun10 = pZtymvaariumdownyenkijyun10;
    }

    private String ztymvaariumdownyenyasu10;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARIUMDOWNYENYASU10)
    public String getZtymvaariumdownyenyasu10() {
        return ztymvaariumdownyenyasu10;
    }

    public void setZtymvaariumdownyenyasu10(String pZtymvaariumdownyenyasu10) {
        ztymvaariumdownyenyasu10 = pZtymvaariumdownyenyasu10;
    }

    private String ztymvaarivtuktype10;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARIVTUKTYPE10)
    public String getZtymvaarivtuktype10() {
        return ztymvaarivtuktype10;
    }

    public void setZtymvaarivtuktype10(String pZtymvaarivtuktype10) {
        ztymvaarivtuktype10 = pZtymvaarivtuktype10;
    }

    private String ztymvaariv10;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARIV10)
    public String getZtymvaariv10() {
        return ztymvaariv10;
    }

    public void setZtymvaariv10(String pZtymvaariv10) {
        ztymvaariv10 = pZtymvaariv10;
    }

    private String ztyptmttkngkutiwake110;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYPTMTTKNGKUTIWAKE110)
    public String getZtyptmttkngkutiwake110() {
        return ztyptmttkngkutiwake110;
    }

    public void setZtyptmttkngkutiwake110(String pZtyptmttkngkutiwake110) {
        ztyptmttkngkutiwake110 = pZtyptmttkngkutiwake110;
    }

    private String ztyptmttkngkutiwake210;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYPTMTTKNGKUTIWAKE210)
    public String getZtyptmttkngkutiwake210() {
        return ztyptmttkngkutiwake210;
    }

    public void setZtyptmttkngkutiwake210(String pZtyptmttkngkutiwake210) {
        ztyptmttkngkutiwake210 = pZtyptmttkngkutiwake210;
    }

    private String ztymvaarinenoutouym11;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARINENOUTOUYM11)
    public String getZtymvaarinenoutouym11() {
        return ztymvaarinenoutouym11;
    }

    public void setZtymvaarinenoutouym11(String pZtymvaarinenoutouym11) {
        ztymvaarinenoutouym11 = pZtymvaarinenoutouym11;
    }

    private String ztymvaariwtuktypeup11;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARIWTUKTYPEUP11)
    public String getZtymvaariwtuktypeup11() {
        return ztymvaariwtuktypeup11;
    }

    public void setZtymvaariwtuktypeup11(String pZtymvaariwtuktypeup11) {
        ztymvaariwtuktypeup11 = pZtymvaariwtuktypeup11;
    }

    private String ztymvaariwup11;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARIWUP11)
    public String getZtymvaariwup11() {
        return ztymvaariwup11;
    }

    public void setZtymvaariwup11(String pZtymvaariwup11) {
        ztymvaariwup11 = pZtymvaariwup11;
    }

    private String ztymvaariwyentuktypeup11;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARIWYENTUKTYPEUP11)
    public String getZtymvaariwyentuktypeup11() {
        return ztymvaariwyentuktypeup11;
    }

    public void setZtymvaariwyentuktypeup11(String pZtymvaariwyentuktypeup11) {
        ztymvaariwyentuktypeup11 = pZtymvaariwyentuktypeup11;
    }

    private String ztymvaariwupyendaka11;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARIWUPYENDAKA11)
    public String getZtymvaariwupyendaka11() {
        return ztymvaariwupyendaka11;
    }

    public void setZtymvaariwupyendaka11(String pZtymvaariwupyendaka11) {
        ztymvaariwupyendaka11 = pZtymvaariwupyendaka11;
    }

    private String ztymvaariwupyenkijyun11;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARIWUPYENKIJYUN11)
    public String getZtymvaariwupyenkijyun11() {
        return ztymvaariwupyenkijyun11;
    }

    public void setZtymvaariwupyenkijyun11(String pZtymvaariwupyenkijyun11) {
        ztymvaariwupyenkijyun11 = pZtymvaariwupyenkijyun11;
    }

    private String ztymvaariwupyenyasu11;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARIWUPYENYASU11)
    public String getZtymvaariwupyenyasu11() {
        return ztymvaariwupyenyasu11;
    }

    public void setZtymvaariwupyenyasu11(String pZtymvaariwupyenyasu11) {
        ztymvaariwupyenyasu11 = pZtymvaariwupyenyasu11;
    }

    private String ztymvaariwumupyendaka11;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARIWUMUPYENDAKA11)
    public String getZtymvaariwumupyendaka11() {
        return ztymvaariwumupyendaka11;
    }

    public void setZtymvaariwumupyendaka11(String pZtymvaariwumupyendaka11) {
        ztymvaariwumupyendaka11 = pZtymvaariwumupyendaka11;
    }

    private String ztymvaariumupyenkijyun11;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARIUMUPYENKIJYUN11)
    public String getZtymvaariumupyenkijyun11() {
        return ztymvaariumupyenkijyun11;
    }

    public void setZtymvaariumupyenkijyun11(String pZtymvaariumupyenkijyun11) {
        ztymvaariumupyenkijyun11 = pZtymvaariumupyenkijyun11;
    }

    private String ztymvaariumupyenyasu11;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARIUMUPYENYASU11)
    public String getZtymvaariumupyenyasu11() {
        return ztymvaariumupyenyasu11;
    }

    public void setZtymvaariumupyenyasu11(String pZtymvaariumupyenyasu11) {
        ztymvaariumupyenyasu11 = pZtymvaariumupyenyasu11;
    }

    private String ztymvaariwtuktypesame11;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARIWTUKTYPESAME11)
    public String getZtymvaariwtuktypesame11() {
        return ztymvaariwtuktypesame11;
    }

    public void setZtymvaariwtuktypesame11(String pZtymvaariwtuktypesame11) {
        ztymvaariwtuktypesame11 = pZtymvaariwtuktypesame11;
    }

    private String ztymvaariwsame11;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARIWSAME11)
    public String getZtymvaariwsame11() {
        return ztymvaariwsame11;
    }

    public void setZtymvaariwsame11(String pZtymvaariwsame11) {
        ztymvaariwsame11 = pZtymvaariwsame11;
    }

    private String ztymvaariwyentuktypesame11;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARIWYENTUKTYPESAME11)
    public String getZtymvaariwyentuktypesame11() {
        return ztymvaariwyentuktypesame11;
    }

    public void setZtymvaariwyentuktypesame11(String pZtymvaariwyentuktypesame11) {
        ztymvaariwyentuktypesame11 = pZtymvaariwyentuktypesame11;
    }

    private String ztymvaariwsameyendaka11;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARIWSAMEYENDAKA11)
    public String getZtymvaariwsameyendaka11() {
        return ztymvaariwsameyendaka11;
    }

    public void setZtymvaariwsameyendaka11(String pZtymvaariwsameyendaka11) {
        ztymvaariwsameyendaka11 = pZtymvaariwsameyendaka11;
    }

    private String ztymvaariwsameyenkijyun11;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARIWSAMEYENKIJYUN11)
    public String getZtymvaariwsameyenkijyun11() {
        return ztymvaariwsameyenkijyun11;
    }

    public void setZtymvaariwsameyenkijyun11(String pZtymvaariwsameyenkijyun11) {
        ztymvaariwsameyenkijyun11 = pZtymvaariwsameyenkijyun11;
    }

    private String ztymvaariwsameyenyasu11;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARIWSAMEYENYASU11)
    public String getZtymvaariwsameyenyasu11() {
        return ztymvaariwsameyenyasu11;
    }

    public void setZtymvaariwsameyenyasu11(String pZtymvaariwsameyenyasu11) {
        ztymvaariwsameyenyasu11 = pZtymvaariwsameyenyasu11;
    }

    private String ztymvaariumsameyendaka11;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARIUMSAMEYENDAKA11)
    public String getZtymvaariumsameyendaka11() {
        return ztymvaariumsameyendaka11;
    }

    public void setZtymvaariumsameyendaka11(String pZtymvaariumsameyendaka11) {
        ztymvaariumsameyendaka11 = pZtymvaariumsameyendaka11;
    }

    private String ztymvaariumsameyenkijyun11;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARIUMSAMEYENKIJYUN11)
    public String getZtymvaariumsameyenkijyun11() {
        return ztymvaariumsameyenkijyun11;
    }

    public void setZtymvaariumsameyenkijyun11(String pZtymvaariumsameyenkijyun11) {
        ztymvaariumsameyenkijyun11 = pZtymvaariumsameyenkijyun11;
    }

    private String ztymvaariumsameyenyasu11;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARIUMSAMEYENYASU11)
    public String getZtymvaariumsameyenyasu11() {
        return ztymvaariumsameyenyasu11;
    }

    public void setZtymvaariumsameyenyasu11(String pZtymvaariumsameyenyasu11) {
        ztymvaariumsameyenyasu11 = pZtymvaariumsameyenyasu11;
    }

    private String ztymvaariwtuktypedown11;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARIWTUKTYPEDOWN11)
    public String getZtymvaariwtuktypedown11() {
        return ztymvaariwtuktypedown11;
    }

    public void setZtymvaariwtuktypedown11(String pZtymvaariwtuktypedown11) {
        ztymvaariwtuktypedown11 = pZtymvaariwtuktypedown11;
    }

    private String ztymvaariwdown11;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARIWDOWN11)
    public String getZtymvaariwdown11() {
        return ztymvaariwdown11;
    }

    public void setZtymvaariwdown11(String pZtymvaariwdown11) {
        ztymvaariwdown11 = pZtymvaariwdown11;
    }

    private String ztymvaariwyentuktypedown11;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARIWYENTUKTYPEDOWN11)
    public String getZtymvaariwyentuktypedown11() {
        return ztymvaariwyentuktypedown11;
    }

    public void setZtymvaariwyentuktypedown11(String pZtymvaariwyentuktypedown11) {
        ztymvaariwyentuktypedown11 = pZtymvaariwyentuktypedown11;
    }

    private String ztymvaariwdownyendaka11;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARIWDOWNYENDAKA11)
    public String getZtymvaariwdownyendaka11() {
        return ztymvaariwdownyendaka11;
    }

    public void setZtymvaariwdownyendaka11(String pZtymvaariwdownyendaka11) {
        ztymvaariwdownyendaka11 = pZtymvaariwdownyendaka11;
    }

    private String ztymvaariwdownyenkijyun11;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARIWDOWNYENKIJYUN11)
    public String getZtymvaariwdownyenkijyun11() {
        return ztymvaariwdownyenkijyun11;
    }

    public void setZtymvaariwdownyenkijyun11(String pZtymvaariwdownyenkijyun11) {
        ztymvaariwdownyenkijyun11 = pZtymvaariwdownyenkijyun11;
    }

    private String ztymvaariwdownyenyasu11;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARIWDOWNYENYASU11)
    public String getZtymvaariwdownyenyasu11() {
        return ztymvaariwdownyenyasu11;
    }

    public void setZtymvaariwdownyenyasu11(String pZtymvaariwdownyenyasu11) {
        ztymvaariwdownyenyasu11 = pZtymvaariwdownyenyasu11;
    }

    private String ztymvaariumdownyendaka11;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARIUMDOWNYENDAKA11)
    public String getZtymvaariumdownyendaka11() {
        return ztymvaariumdownyendaka11;
    }

    public void setZtymvaariumdownyendaka11(String pZtymvaariumdownyendaka11) {
        ztymvaariumdownyendaka11 = pZtymvaariumdownyendaka11;
    }

    private String ztymvaariumdownyenkijyun11;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARIUMDOWNYENKIJYUN11)
    public String getZtymvaariumdownyenkijyun11() {
        return ztymvaariumdownyenkijyun11;
    }

    public void setZtymvaariumdownyenkijyun11(String pZtymvaariumdownyenkijyun11) {
        ztymvaariumdownyenkijyun11 = pZtymvaariumdownyenkijyun11;
    }

    private String ztymvaariumdownyenyasu11;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARIUMDOWNYENYASU11)
    public String getZtymvaariumdownyenyasu11() {
        return ztymvaariumdownyenyasu11;
    }

    public void setZtymvaariumdownyenyasu11(String pZtymvaariumdownyenyasu11) {
        ztymvaariumdownyenyasu11 = pZtymvaariumdownyenyasu11;
    }

    private String ztymvaarivtuktype11;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARIVTUKTYPE11)
    public String getZtymvaarivtuktype11() {
        return ztymvaarivtuktype11;
    }

    public void setZtymvaarivtuktype11(String pZtymvaarivtuktype11) {
        ztymvaarivtuktype11 = pZtymvaarivtuktype11;
    }

    private String ztymvaariv11;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARIV11)
    public String getZtymvaariv11() {
        return ztymvaariv11;
    }

    public void setZtymvaariv11(String pZtymvaariv11) {
        ztymvaariv11 = pZtymvaariv11;
    }

    private String ztymvaarinenoutouym12;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARINENOUTOUYM12)
    public String getZtymvaarinenoutouym12() {
        return ztymvaarinenoutouym12;
    }

    public void setZtymvaarinenoutouym12(String pZtymvaarinenoutouym12) {
        ztymvaarinenoutouym12 = pZtymvaarinenoutouym12;
    }

    private String ztymvaariwtuktypeup12;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARIWTUKTYPEUP12)
    public String getZtymvaariwtuktypeup12() {
        return ztymvaariwtuktypeup12;
    }

    public void setZtymvaariwtuktypeup12(String pZtymvaariwtuktypeup12) {
        ztymvaariwtuktypeup12 = pZtymvaariwtuktypeup12;
    }

    private String ztymvaariwup12;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARIWUP12)
    public String getZtymvaariwup12() {
        return ztymvaariwup12;
    }

    public void setZtymvaariwup12(String pZtymvaariwup12) {
        ztymvaariwup12 = pZtymvaariwup12;
    }

    private String ztymvaariwyentuktypeup12;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARIWYENTUKTYPEUP12)
    public String getZtymvaariwyentuktypeup12() {
        return ztymvaariwyentuktypeup12;
    }

    public void setZtymvaariwyentuktypeup12(String pZtymvaariwyentuktypeup12) {
        ztymvaariwyentuktypeup12 = pZtymvaariwyentuktypeup12;
    }

    private String ztymvaariwupyendaka12;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARIWUPYENDAKA12)
    public String getZtymvaariwupyendaka12() {
        return ztymvaariwupyendaka12;
    }

    public void setZtymvaariwupyendaka12(String pZtymvaariwupyendaka12) {
        ztymvaariwupyendaka12 = pZtymvaariwupyendaka12;
    }

    private String ztymvaariwupyenkijyun12;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARIWUPYENKIJYUN12)
    public String getZtymvaariwupyenkijyun12() {
        return ztymvaariwupyenkijyun12;
    }

    public void setZtymvaariwupyenkijyun12(String pZtymvaariwupyenkijyun12) {
        ztymvaariwupyenkijyun12 = pZtymvaariwupyenkijyun12;
    }

    private String ztymvaariwupyenyasu12;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARIWUPYENYASU12)
    public String getZtymvaariwupyenyasu12() {
        return ztymvaariwupyenyasu12;
    }

    public void setZtymvaariwupyenyasu12(String pZtymvaariwupyenyasu12) {
        ztymvaariwupyenyasu12 = pZtymvaariwupyenyasu12;
    }

    private String ztymvaariwumupyendaka12;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARIWUMUPYENDAKA12)
    public String getZtymvaariwumupyendaka12() {
        return ztymvaariwumupyendaka12;
    }

    public void setZtymvaariwumupyendaka12(String pZtymvaariwumupyendaka12) {
        ztymvaariwumupyendaka12 = pZtymvaariwumupyendaka12;
    }

    private String ztymvaariumupyenkijyun12;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARIUMUPYENKIJYUN12)
    public String getZtymvaariumupyenkijyun12() {
        return ztymvaariumupyenkijyun12;
    }

    public void setZtymvaariumupyenkijyun12(String pZtymvaariumupyenkijyun12) {
        ztymvaariumupyenkijyun12 = pZtymvaariumupyenkijyun12;
    }

    private String ztymvaariumupyenyasu12;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARIUMUPYENYASU12)
    public String getZtymvaariumupyenyasu12() {
        return ztymvaariumupyenyasu12;
    }

    public void setZtymvaariumupyenyasu12(String pZtymvaariumupyenyasu12) {
        ztymvaariumupyenyasu12 = pZtymvaariumupyenyasu12;
    }

    private String ztymvaariwtuktypesame12;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARIWTUKTYPESAME12)
    public String getZtymvaariwtuktypesame12() {
        return ztymvaariwtuktypesame12;
    }

    public void setZtymvaariwtuktypesame12(String pZtymvaariwtuktypesame12) {
        ztymvaariwtuktypesame12 = pZtymvaariwtuktypesame12;
    }

    private String ztymvaariwsame12;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARIWSAME12)
    public String getZtymvaariwsame12() {
        return ztymvaariwsame12;
    }

    public void setZtymvaariwsame12(String pZtymvaariwsame12) {
        ztymvaariwsame12 = pZtymvaariwsame12;
    }

    private String ztymvaariwyentuktypesame12;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARIWYENTUKTYPESAME12)
    public String getZtymvaariwyentuktypesame12() {
        return ztymvaariwyentuktypesame12;
    }

    public void setZtymvaariwyentuktypesame12(String pZtymvaariwyentuktypesame12) {
        ztymvaariwyentuktypesame12 = pZtymvaariwyentuktypesame12;
    }

    private String ztymvaariwsameyendaka12;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARIWSAMEYENDAKA12)
    public String getZtymvaariwsameyendaka12() {
        return ztymvaariwsameyendaka12;
    }

    public void setZtymvaariwsameyendaka12(String pZtymvaariwsameyendaka12) {
        ztymvaariwsameyendaka12 = pZtymvaariwsameyendaka12;
    }

    private String ztymvaariwsameyenkijyun12;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARIWSAMEYENKIJYUN12)
    public String getZtymvaariwsameyenkijyun12() {
        return ztymvaariwsameyenkijyun12;
    }

    public void setZtymvaariwsameyenkijyun12(String pZtymvaariwsameyenkijyun12) {
        ztymvaariwsameyenkijyun12 = pZtymvaariwsameyenkijyun12;
    }

    private String ztymvaariwsameyenyasu12;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARIWSAMEYENYASU12)
    public String getZtymvaariwsameyenyasu12() {
        return ztymvaariwsameyenyasu12;
    }

    public void setZtymvaariwsameyenyasu12(String pZtymvaariwsameyenyasu12) {
        ztymvaariwsameyenyasu12 = pZtymvaariwsameyenyasu12;
    }

    private String ztymvaariumsameyendaka12;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARIUMSAMEYENDAKA12)
    public String getZtymvaariumsameyendaka12() {
        return ztymvaariumsameyendaka12;
    }

    public void setZtymvaariumsameyendaka12(String pZtymvaariumsameyendaka12) {
        ztymvaariumsameyendaka12 = pZtymvaariumsameyendaka12;
    }

    private String ztymvaariumsameyenkijyun12;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARIUMSAMEYENKIJYUN12)
    public String getZtymvaariumsameyenkijyun12() {
        return ztymvaariumsameyenkijyun12;
    }

    public void setZtymvaariumsameyenkijyun12(String pZtymvaariumsameyenkijyun12) {
        ztymvaariumsameyenkijyun12 = pZtymvaariumsameyenkijyun12;
    }

    private String ztymvaariumsameyenyasu12;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARIUMSAMEYENYASU12)
    public String getZtymvaariumsameyenyasu12() {
        return ztymvaariumsameyenyasu12;
    }

    public void setZtymvaariumsameyenyasu12(String pZtymvaariumsameyenyasu12) {
        ztymvaariumsameyenyasu12 = pZtymvaariumsameyenyasu12;
    }

    private String ztymvaariwtuktypedown12;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARIWTUKTYPEDOWN12)
    public String getZtymvaariwtuktypedown12() {
        return ztymvaariwtuktypedown12;
    }

    public void setZtymvaariwtuktypedown12(String pZtymvaariwtuktypedown12) {
        ztymvaariwtuktypedown12 = pZtymvaariwtuktypedown12;
    }

    private String ztymvaariwdown12;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARIWDOWN12)
    public String getZtymvaariwdown12() {
        return ztymvaariwdown12;
    }

    public void setZtymvaariwdown12(String pZtymvaariwdown12) {
        ztymvaariwdown12 = pZtymvaariwdown12;
    }

    private String ztymvaariwyentuktypedown12;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARIWYENTUKTYPEDOWN12)
    public String getZtymvaariwyentuktypedown12() {
        return ztymvaariwyentuktypedown12;
    }

    public void setZtymvaariwyentuktypedown12(String pZtymvaariwyentuktypedown12) {
        ztymvaariwyentuktypedown12 = pZtymvaariwyentuktypedown12;
    }

    private String ztymvaariwdownyendaka12;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARIWDOWNYENDAKA12)
    public String getZtymvaariwdownyendaka12() {
        return ztymvaariwdownyendaka12;
    }

    public void setZtymvaariwdownyendaka12(String pZtymvaariwdownyendaka12) {
        ztymvaariwdownyendaka12 = pZtymvaariwdownyendaka12;
    }

    private String ztymvaariwdownyenkijyun12;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARIWDOWNYENKIJYUN12)
    public String getZtymvaariwdownyenkijyun12() {
        return ztymvaariwdownyenkijyun12;
    }

    public void setZtymvaariwdownyenkijyun12(String pZtymvaariwdownyenkijyun12) {
        ztymvaariwdownyenkijyun12 = pZtymvaariwdownyenkijyun12;
    }

    private String ztymvaariwdownyenyasu12;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARIWDOWNYENYASU12)
    public String getZtymvaariwdownyenyasu12() {
        return ztymvaariwdownyenyasu12;
    }

    public void setZtymvaariwdownyenyasu12(String pZtymvaariwdownyenyasu12) {
        ztymvaariwdownyenyasu12 = pZtymvaariwdownyenyasu12;
    }

    private String ztymvaariumdownyendaka12;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARIUMDOWNYENDAKA12)
    public String getZtymvaariumdownyendaka12() {
        return ztymvaariumdownyendaka12;
    }

    public void setZtymvaariumdownyendaka12(String pZtymvaariumdownyendaka12) {
        ztymvaariumdownyendaka12 = pZtymvaariumdownyendaka12;
    }

    private String ztymvaariumdownyenkijyun12;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARIUMDOWNYENKIJYUN12)
    public String getZtymvaariumdownyenkijyun12() {
        return ztymvaariumdownyenkijyun12;
    }

    public void setZtymvaariumdownyenkijyun12(String pZtymvaariumdownyenkijyun12) {
        ztymvaariumdownyenkijyun12 = pZtymvaariumdownyenkijyun12;
    }

    private String ztymvaariumdownyenyasu12;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARIUMDOWNYENYASU12)
    public String getZtymvaariumdownyenyasu12() {
        return ztymvaariumdownyenyasu12;
    }

    public void setZtymvaariumdownyenyasu12(String pZtymvaariumdownyenyasu12) {
        ztymvaariumdownyenyasu12 = pZtymvaariumdownyenyasu12;
    }

    private String ztymvaarivtuktype12;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARIVTUKTYPE12)
    public String getZtymvaarivtuktype12() {
        return ztymvaarivtuktype12;
    }

    public void setZtymvaarivtuktype12(String pZtymvaarivtuktype12) {
        ztymvaarivtuktype12 = pZtymvaarivtuktype12;
    }

    private String ztymvaariv12;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARIV12)
    public String getZtymvaariv12() {
        return ztymvaariv12;
    }

    public void setZtymvaariv12(String pZtymvaariv12) {
        ztymvaariv12 = pZtymvaariv12;
    }

    private String ztymvaarinenoutouym13;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARINENOUTOUYM13)
    public String getZtymvaarinenoutouym13() {
        return ztymvaarinenoutouym13;
    }

    public void setZtymvaarinenoutouym13(String pZtymvaarinenoutouym13) {
        ztymvaarinenoutouym13 = pZtymvaarinenoutouym13;
    }

    private String ztymvaariwtuktypeup13;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARIWTUKTYPEUP13)
    public String getZtymvaariwtuktypeup13() {
        return ztymvaariwtuktypeup13;
    }

    public void setZtymvaariwtuktypeup13(String pZtymvaariwtuktypeup13) {
        ztymvaariwtuktypeup13 = pZtymvaariwtuktypeup13;
    }

    private String ztymvaariwup13;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARIWUP13)
    public String getZtymvaariwup13() {
        return ztymvaariwup13;
    }

    public void setZtymvaariwup13(String pZtymvaariwup13) {
        ztymvaariwup13 = pZtymvaariwup13;
    }

    private String ztymvaariwyentuktypeup13;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARIWYENTUKTYPEUP13)
    public String getZtymvaariwyentuktypeup13() {
        return ztymvaariwyentuktypeup13;
    }

    public void setZtymvaariwyentuktypeup13(String pZtymvaariwyentuktypeup13) {
        ztymvaariwyentuktypeup13 = pZtymvaariwyentuktypeup13;
    }

    private String ztymvaariwupyendaka13;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARIWUPYENDAKA13)
    public String getZtymvaariwupyendaka13() {
        return ztymvaariwupyendaka13;
    }

    public void setZtymvaariwupyendaka13(String pZtymvaariwupyendaka13) {
        ztymvaariwupyendaka13 = pZtymvaariwupyendaka13;
    }

    private String ztymvaariwupyenkijyun13;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARIWUPYENKIJYUN13)
    public String getZtymvaariwupyenkijyun13() {
        return ztymvaariwupyenkijyun13;
    }

    public void setZtymvaariwupyenkijyun13(String pZtymvaariwupyenkijyun13) {
        ztymvaariwupyenkijyun13 = pZtymvaariwupyenkijyun13;
    }

    private String ztymvaariwupyenyasu13;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARIWUPYENYASU13)
    public String getZtymvaariwupyenyasu13() {
        return ztymvaariwupyenyasu13;
    }

    public void setZtymvaariwupyenyasu13(String pZtymvaariwupyenyasu13) {
        ztymvaariwupyenyasu13 = pZtymvaariwupyenyasu13;
    }

    private String ztymvaariwumupyendaka13;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARIWUMUPYENDAKA13)
    public String getZtymvaariwumupyendaka13() {
        return ztymvaariwumupyendaka13;
    }

    public void setZtymvaariwumupyendaka13(String pZtymvaariwumupyendaka13) {
        ztymvaariwumupyendaka13 = pZtymvaariwumupyendaka13;
    }

    private String ztymvaariumupyenkijyun13;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARIUMUPYENKIJYUN13)
    public String getZtymvaariumupyenkijyun13() {
        return ztymvaariumupyenkijyun13;
    }

    public void setZtymvaariumupyenkijyun13(String pZtymvaariumupyenkijyun13) {
        ztymvaariumupyenkijyun13 = pZtymvaariumupyenkijyun13;
    }

    private String ztymvaariumupyenyasu13;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARIUMUPYENYASU13)
    public String getZtymvaariumupyenyasu13() {
        return ztymvaariumupyenyasu13;
    }

    public void setZtymvaariumupyenyasu13(String pZtymvaariumupyenyasu13) {
        ztymvaariumupyenyasu13 = pZtymvaariumupyenyasu13;
    }

    private String ztymvaariwtuktypesame13;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARIWTUKTYPESAME13)
    public String getZtymvaariwtuktypesame13() {
        return ztymvaariwtuktypesame13;
    }

    public void setZtymvaariwtuktypesame13(String pZtymvaariwtuktypesame13) {
        ztymvaariwtuktypesame13 = pZtymvaariwtuktypesame13;
    }

    private String ztymvaariwsame13;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARIWSAME13)
    public String getZtymvaariwsame13() {
        return ztymvaariwsame13;
    }

    public void setZtymvaariwsame13(String pZtymvaariwsame13) {
        ztymvaariwsame13 = pZtymvaariwsame13;
    }

    private String ztymvaariwyentuktypesame13;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARIWYENTUKTYPESAME13)
    public String getZtymvaariwyentuktypesame13() {
        return ztymvaariwyentuktypesame13;
    }

    public void setZtymvaariwyentuktypesame13(String pZtymvaariwyentuktypesame13) {
        ztymvaariwyentuktypesame13 = pZtymvaariwyentuktypesame13;
    }

    private String ztymvaariwsameyendaka13;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARIWSAMEYENDAKA13)
    public String getZtymvaariwsameyendaka13() {
        return ztymvaariwsameyendaka13;
    }

    public void setZtymvaariwsameyendaka13(String pZtymvaariwsameyendaka13) {
        ztymvaariwsameyendaka13 = pZtymvaariwsameyendaka13;
    }

    private String ztymvaariwsameyenkijyun13;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARIWSAMEYENKIJYUN13)
    public String getZtymvaariwsameyenkijyun13() {
        return ztymvaariwsameyenkijyun13;
    }

    public void setZtymvaariwsameyenkijyun13(String pZtymvaariwsameyenkijyun13) {
        ztymvaariwsameyenkijyun13 = pZtymvaariwsameyenkijyun13;
    }

    private String ztymvaariwsameyenyasu13;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARIWSAMEYENYASU13)
    public String getZtymvaariwsameyenyasu13() {
        return ztymvaariwsameyenyasu13;
    }

    public void setZtymvaariwsameyenyasu13(String pZtymvaariwsameyenyasu13) {
        ztymvaariwsameyenyasu13 = pZtymvaariwsameyenyasu13;
    }

    private String ztymvaariumsameyendaka13;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARIUMSAMEYENDAKA13)
    public String getZtymvaariumsameyendaka13() {
        return ztymvaariumsameyendaka13;
    }

    public void setZtymvaariumsameyendaka13(String pZtymvaariumsameyendaka13) {
        ztymvaariumsameyendaka13 = pZtymvaariumsameyendaka13;
    }

    private String ztymvaariumsameyenkijyun13;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARIUMSAMEYENKIJYUN13)
    public String getZtymvaariumsameyenkijyun13() {
        return ztymvaariumsameyenkijyun13;
    }

    public void setZtymvaariumsameyenkijyun13(String pZtymvaariumsameyenkijyun13) {
        ztymvaariumsameyenkijyun13 = pZtymvaariumsameyenkijyun13;
    }

    private String ztymvaariumsameyenyasu13;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARIUMSAMEYENYASU13)
    public String getZtymvaariumsameyenyasu13() {
        return ztymvaariumsameyenyasu13;
    }

    public void setZtymvaariumsameyenyasu13(String pZtymvaariumsameyenyasu13) {
        ztymvaariumsameyenyasu13 = pZtymvaariumsameyenyasu13;
    }

    private String ztymvaariwtuktypedown13;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARIWTUKTYPEDOWN13)
    public String getZtymvaariwtuktypedown13() {
        return ztymvaariwtuktypedown13;
    }

    public void setZtymvaariwtuktypedown13(String pZtymvaariwtuktypedown13) {
        ztymvaariwtuktypedown13 = pZtymvaariwtuktypedown13;
    }

    private String ztymvaariwdown13;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARIWDOWN13)
    public String getZtymvaariwdown13() {
        return ztymvaariwdown13;
    }

    public void setZtymvaariwdown13(String pZtymvaariwdown13) {
        ztymvaariwdown13 = pZtymvaariwdown13;
    }

    private String ztymvaariwyentuktypedown13;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARIWYENTUKTYPEDOWN13)
    public String getZtymvaariwyentuktypedown13() {
        return ztymvaariwyentuktypedown13;
    }

    public void setZtymvaariwyentuktypedown13(String pZtymvaariwyentuktypedown13) {
        ztymvaariwyentuktypedown13 = pZtymvaariwyentuktypedown13;
    }

    private String ztymvaariwdownyendaka13;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARIWDOWNYENDAKA13)
    public String getZtymvaariwdownyendaka13() {
        return ztymvaariwdownyendaka13;
    }

    public void setZtymvaariwdownyendaka13(String pZtymvaariwdownyendaka13) {
        ztymvaariwdownyendaka13 = pZtymvaariwdownyendaka13;
    }

    private String ztymvaariwdownyenkijyun13;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARIWDOWNYENKIJYUN13)
    public String getZtymvaariwdownyenkijyun13() {
        return ztymvaariwdownyenkijyun13;
    }

    public void setZtymvaariwdownyenkijyun13(String pZtymvaariwdownyenkijyun13) {
        ztymvaariwdownyenkijyun13 = pZtymvaariwdownyenkijyun13;
    }

    private String ztymvaariwdownyenyasu13;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARIWDOWNYENYASU13)
    public String getZtymvaariwdownyenyasu13() {
        return ztymvaariwdownyenyasu13;
    }

    public void setZtymvaariwdownyenyasu13(String pZtymvaariwdownyenyasu13) {
        ztymvaariwdownyenyasu13 = pZtymvaariwdownyenyasu13;
    }

    private String ztymvaariumdownyendaka13;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARIUMDOWNYENDAKA13)
    public String getZtymvaariumdownyendaka13() {
        return ztymvaariumdownyendaka13;
    }

    public void setZtymvaariumdownyendaka13(String pZtymvaariumdownyendaka13) {
        ztymvaariumdownyendaka13 = pZtymvaariumdownyendaka13;
    }

    private String ztymvaariumdownyenkijyun13;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARIUMDOWNYENKIJYUN13)
    public String getZtymvaariumdownyenkijyun13() {
        return ztymvaariumdownyenkijyun13;
    }

    public void setZtymvaariumdownyenkijyun13(String pZtymvaariumdownyenkijyun13) {
        ztymvaariumdownyenkijyun13 = pZtymvaariumdownyenkijyun13;
    }

    private String ztymvaariumdownyenyasu13;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARIUMDOWNYENYASU13)
    public String getZtymvaariumdownyenyasu13() {
        return ztymvaariumdownyenyasu13;
    }

    public void setZtymvaariumdownyenyasu13(String pZtymvaariumdownyenyasu13) {
        ztymvaariumdownyenyasu13 = pZtymvaariumdownyenyasu13;
    }

    private String ztymvaarivtuktype13;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARIVTUKTYPE13)
    public String getZtymvaarivtuktype13() {
        return ztymvaarivtuktype13;
    }

    public void setZtymvaarivtuktype13(String pZtymvaarivtuktype13) {
        ztymvaarivtuktype13 = pZtymvaarivtuktype13;
    }

    private String ztymvaariv13;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARIV13)
    public String getZtymvaariv13() {
        return ztymvaariv13;
    }

    public void setZtymvaariv13(String pZtymvaariv13) {
        ztymvaariv13 = pZtymvaariv13;
    }

    private String ztymvaarinenoutouym14;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARINENOUTOUYM14)
    public String getZtymvaarinenoutouym14() {
        return ztymvaarinenoutouym14;
    }

    public void setZtymvaarinenoutouym14(String pZtymvaarinenoutouym14) {
        ztymvaarinenoutouym14 = pZtymvaarinenoutouym14;
    }

    private String ztymvaariwtuktypeup14;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARIWTUKTYPEUP14)
    public String getZtymvaariwtuktypeup14() {
        return ztymvaariwtuktypeup14;
    }

    public void setZtymvaariwtuktypeup14(String pZtymvaariwtuktypeup14) {
        ztymvaariwtuktypeup14 = pZtymvaariwtuktypeup14;
    }

    private String ztymvaariwup14;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARIWUP14)
    public String getZtymvaariwup14() {
        return ztymvaariwup14;
    }

    public void setZtymvaariwup14(String pZtymvaariwup14) {
        ztymvaariwup14 = pZtymvaariwup14;
    }

    private String ztymvaariwyentuktypeup14;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARIWYENTUKTYPEUP14)
    public String getZtymvaariwyentuktypeup14() {
        return ztymvaariwyentuktypeup14;
    }

    public void setZtymvaariwyentuktypeup14(String pZtymvaariwyentuktypeup14) {
        ztymvaariwyentuktypeup14 = pZtymvaariwyentuktypeup14;
    }

    private String ztymvaariwupyendaka14;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARIWUPYENDAKA14)
    public String getZtymvaariwupyendaka14() {
        return ztymvaariwupyendaka14;
    }

    public void setZtymvaariwupyendaka14(String pZtymvaariwupyendaka14) {
        ztymvaariwupyendaka14 = pZtymvaariwupyendaka14;
    }

    private String ztymvaariwupyenkijyun14;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARIWUPYENKIJYUN14)
    public String getZtymvaariwupyenkijyun14() {
        return ztymvaariwupyenkijyun14;
    }

    public void setZtymvaariwupyenkijyun14(String pZtymvaariwupyenkijyun14) {
        ztymvaariwupyenkijyun14 = pZtymvaariwupyenkijyun14;
    }

    private String ztymvaariwupyenyasu14;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARIWUPYENYASU14)
    public String getZtymvaariwupyenyasu14() {
        return ztymvaariwupyenyasu14;
    }

    public void setZtymvaariwupyenyasu14(String pZtymvaariwupyenyasu14) {
        ztymvaariwupyenyasu14 = pZtymvaariwupyenyasu14;
    }

    private String ztymvaariwumupyendaka14;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARIWUMUPYENDAKA14)
    public String getZtymvaariwumupyendaka14() {
        return ztymvaariwumupyendaka14;
    }

    public void setZtymvaariwumupyendaka14(String pZtymvaariwumupyendaka14) {
        ztymvaariwumupyendaka14 = pZtymvaariwumupyendaka14;
    }

    private String ztymvaariumupyenkijyun14;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARIUMUPYENKIJYUN14)
    public String getZtymvaariumupyenkijyun14() {
        return ztymvaariumupyenkijyun14;
    }

    public void setZtymvaariumupyenkijyun14(String pZtymvaariumupyenkijyun14) {
        ztymvaariumupyenkijyun14 = pZtymvaariumupyenkijyun14;
    }

    private String ztymvaariumupyenyasu14;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARIUMUPYENYASU14)
    public String getZtymvaariumupyenyasu14() {
        return ztymvaariumupyenyasu14;
    }

    public void setZtymvaariumupyenyasu14(String pZtymvaariumupyenyasu14) {
        ztymvaariumupyenyasu14 = pZtymvaariumupyenyasu14;
    }

    private String ztymvaariwtuktypesame14;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARIWTUKTYPESAME14)
    public String getZtymvaariwtuktypesame14() {
        return ztymvaariwtuktypesame14;
    }

    public void setZtymvaariwtuktypesame14(String pZtymvaariwtuktypesame14) {
        ztymvaariwtuktypesame14 = pZtymvaariwtuktypesame14;
    }

    private String ztymvaariwsame14;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARIWSAME14)
    public String getZtymvaariwsame14() {
        return ztymvaariwsame14;
    }

    public void setZtymvaariwsame14(String pZtymvaariwsame14) {
        ztymvaariwsame14 = pZtymvaariwsame14;
    }

    private String ztymvaariwyentuktypesame14;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARIWYENTUKTYPESAME14)
    public String getZtymvaariwyentuktypesame14() {
        return ztymvaariwyentuktypesame14;
    }

    public void setZtymvaariwyentuktypesame14(String pZtymvaariwyentuktypesame14) {
        ztymvaariwyentuktypesame14 = pZtymvaariwyentuktypesame14;
    }

    private String ztymvaariwsameyendaka14;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARIWSAMEYENDAKA14)
    public String getZtymvaariwsameyendaka14() {
        return ztymvaariwsameyendaka14;
    }

    public void setZtymvaariwsameyendaka14(String pZtymvaariwsameyendaka14) {
        ztymvaariwsameyendaka14 = pZtymvaariwsameyendaka14;
    }

    private String ztymvaariwsameyenkijyun14;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARIWSAMEYENKIJYUN14)
    public String getZtymvaariwsameyenkijyun14() {
        return ztymvaariwsameyenkijyun14;
    }

    public void setZtymvaariwsameyenkijyun14(String pZtymvaariwsameyenkijyun14) {
        ztymvaariwsameyenkijyun14 = pZtymvaariwsameyenkijyun14;
    }

    private String ztymvaariwsameyenyasu14;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARIWSAMEYENYASU14)
    public String getZtymvaariwsameyenyasu14() {
        return ztymvaariwsameyenyasu14;
    }

    public void setZtymvaariwsameyenyasu14(String pZtymvaariwsameyenyasu14) {
        ztymvaariwsameyenyasu14 = pZtymvaariwsameyenyasu14;
    }

    private String ztymvaariumsameyendaka14;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARIUMSAMEYENDAKA14)
    public String getZtymvaariumsameyendaka14() {
        return ztymvaariumsameyendaka14;
    }

    public void setZtymvaariumsameyendaka14(String pZtymvaariumsameyendaka14) {
        ztymvaariumsameyendaka14 = pZtymvaariumsameyendaka14;
    }

    private String ztymvaariumsameyenkijyun14;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARIUMSAMEYENKIJYUN14)
    public String getZtymvaariumsameyenkijyun14() {
        return ztymvaariumsameyenkijyun14;
    }

    public void setZtymvaariumsameyenkijyun14(String pZtymvaariumsameyenkijyun14) {
        ztymvaariumsameyenkijyun14 = pZtymvaariumsameyenkijyun14;
    }

    private String ztymvaariumsameyenyasu14;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARIUMSAMEYENYASU14)
    public String getZtymvaariumsameyenyasu14() {
        return ztymvaariumsameyenyasu14;
    }

    public void setZtymvaariumsameyenyasu14(String pZtymvaariumsameyenyasu14) {
        ztymvaariumsameyenyasu14 = pZtymvaariumsameyenyasu14;
    }

    private String ztymvaariwtuktypedown14;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARIWTUKTYPEDOWN14)
    public String getZtymvaariwtuktypedown14() {
        return ztymvaariwtuktypedown14;
    }

    public void setZtymvaariwtuktypedown14(String pZtymvaariwtuktypedown14) {
        ztymvaariwtuktypedown14 = pZtymvaariwtuktypedown14;
    }

    private String ztymvaariwdown14;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARIWDOWN14)
    public String getZtymvaariwdown14() {
        return ztymvaariwdown14;
    }

    public void setZtymvaariwdown14(String pZtymvaariwdown14) {
        ztymvaariwdown14 = pZtymvaariwdown14;
    }

    private String ztymvaariwyentuktypedown14;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARIWYENTUKTYPEDOWN14)
    public String getZtymvaariwyentuktypedown14() {
        return ztymvaariwyentuktypedown14;
    }

    public void setZtymvaariwyentuktypedown14(String pZtymvaariwyentuktypedown14) {
        ztymvaariwyentuktypedown14 = pZtymvaariwyentuktypedown14;
    }

    private String ztymvaariwdownyendaka14;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARIWDOWNYENDAKA14)
    public String getZtymvaariwdownyendaka14() {
        return ztymvaariwdownyendaka14;
    }

    public void setZtymvaariwdownyendaka14(String pZtymvaariwdownyendaka14) {
        ztymvaariwdownyendaka14 = pZtymvaariwdownyendaka14;
    }

    private String ztymvaariwdownyenkijyun14;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARIWDOWNYENKIJYUN14)
    public String getZtymvaariwdownyenkijyun14() {
        return ztymvaariwdownyenkijyun14;
    }

    public void setZtymvaariwdownyenkijyun14(String pZtymvaariwdownyenkijyun14) {
        ztymvaariwdownyenkijyun14 = pZtymvaariwdownyenkijyun14;
    }

    private String ztymvaariwdownyenyasu14;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARIWDOWNYENYASU14)
    public String getZtymvaariwdownyenyasu14() {
        return ztymvaariwdownyenyasu14;
    }

    public void setZtymvaariwdownyenyasu14(String pZtymvaariwdownyenyasu14) {
        ztymvaariwdownyenyasu14 = pZtymvaariwdownyenyasu14;
    }

    private String ztymvaariumdownyendaka14;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARIUMDOWNYENDAKA14)
    public String getZtymvaariumdownyendaka14() {
        return ztymvaariumdownyendaka14;
    }

    public void setZtymvaariumdownyendaka14(String pZtymvaariumdownyendaka14) {
        ztymvaariumdownyendaka14 = pZtymvaariumdownyendaka14;
    }

    private String ztymvaariumdownyenkijyun14;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARIUMDOWNYENKIJYUN14)
    public String getZtymvaariumdownyenkijyun14() {
        return ztymvaariumdownyenkijyun14;
    }

    public void setZtymvaariumdownyenkijyun14(String pZtymvaariumdownyenkijyun14) {
        ztymvaariumdownyenkijyun14 = pZtymvaariumdownyenkijyun14;
    }

    private String ztymvaariumdownyenyasu14;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARIUMDOWNYENYASU14)
    public String getZtymvaariumdownyenyasu14() {
        return ztymvaariumdownyenyasu14;
    }

    public void setZtymvaariumdownyenyasu14(String pZtymvaariumdownyenyasu14) {
        ztymvaariumdownyenyasu14 = pZtymvaariumdownyenyasu14;
    }

    private String ztymvaarivtuktype14;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARIVTUKTYPE14)
    public String getZtymvaarivtuktype14() {
        return ztymvaarivtuktype14;
    }

    public void setZtymvaarivtuktype14(String pZtymvaarivtuktype14) {
        ztymvaarivtuktype14 = pZtymvaarivtuktype14;
    }

    private String ztymvaariv14;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARIV14)
    public String getZtymvaariv14() {
        return ztymvaariv14;
    }

    public void setZtymvaariv14(String pZtymvaariv14) {
        ztymvaariv14 = pZtymvaariv14;
    }

    private String ztymvaarinenoutouym15;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARINENOUTOUYM15)
    public String getZtymvaarinenoutouym15() {
        return ztymvaarinenoutouym15;
    }

    public void setZtymvaarinenoutouym15(String pZtymvaarinenoutouym15) {
        ztymvaarinenoutouym15 = pZtymvaarinenoutouym15;
    }

    private String ztymvaariwtuktypeup15;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARIWTUKTYPEUP15)
    public String getZtymvaariwtuktypeup15() {
        return ztymvaariwtuktypeup15;
    }

    public void setZtymvaariwtuktypeup15(String pZtymvaariwtuktypeup15) {
        ztymvaariwtuktypeup15 = pZtymvaariwtuktypeup15;
    }

    private String ztymvaariwup15;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARIWUP15)
    public String getZtymvaariwup15() {
        return ztymvaariwup15;
    }

    public void setZtymvaariwup15(String pZtymvaariwup15) {
        ztymvaariwup15 = pZtymvaariwup15;
    }

    private String ztymvaariwyentuktypeup15;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARIWYENTUKTYPEUP15)
    public String getZtymvaariwyentuktypeup15() {
        return ztymvaariwyentuktypeup15;
    }

    public void setZtymvaariwyentuktypeup15(String pZtymvaariwyentuktypeup15) {
        ztymvaariwyentuktypeup15 = pZtymvaariwyentuktypeup15;
    }

    private String ztymvaariwupyendaka15;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARIWUPYENDAKA15)
    public String getZtymvaariwupyendaka15() {
        return ztymvaariwupyendaka15;
    }

    public void setZtymvaariwupyendaka15(String pZtymvaariwupyendaka15) {
        ztymvaariwupyendaka15 = pZtymvaariwupyendaka15;
    }

    private String ztymvaariwupyenkijyun15;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARIWUPYENKIJYUN15)
    public String getZtymvaariwupyenkijyun15() {
        return ztymvaariwupyenkijyun15;
    }

    public void setZtymvaariwupyenkijyun15(String pZtymvaariwupyenkijyun15) {
        ztymvaariwupyenkijyun15 = pZtymvaariwupyenkijyun15;
    }

    private String ztymvaariwupyenyasu15;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARIWUPYENYASU15)
    public String getZtymvaariwupyenyasu15() {
        return ztymvaariwupyenyasu15;
    }

    public void setZtymvaariwupyenyasu15(String pZtymvaariwupyenyasu15) {
        ztymvaariwupyenyasu15 = pZtymvaariwupyenyasu15;
    }

    private String ztymvaariwumupyendaka15;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARIWUMUPYENDAKA15)
    public String getZtymvaariwumupyendaka15() {
        return ztymvaariwumupyendaka15;
    }

    public void setZtymvaariwumupyendaka15(String pZtymvaariwumupyendaka15) {
        ztymvaariwumupyendaka15 = pZtymvaariwumupyendaka15;
    }

    private String ztymvaariumupyenkijyun15;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARIUMUPYENKIJYUN15)
    public String getZtymvaariumupyenkijyun15() {
        return ztymvaariumupyenkijyun15;
    }

    public void setZtymvaariumupyenkijyun15(String pZtymvaariumupyenkijyun15) {
        ztymvaariumupyenkijyun15 = pZtymvaariumupyenkijyun15;
    }

    private String ztymvaariumupyenyasu15;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARIUMUPYENYASU15)
    public String getZtymvaariumupyenyasu15() {
        return ztymvaariumupyenyasu15;
    }

    public void setZtymvaariumupyenyasu15(String pZtymvaariumupyenyasu15) {
        ztymvaariumupyenyasu15 = pZtymvaariumupyenyasu15;
    }

    private String ztymvaariwtuktypesame15;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARIWTUKTYPESAME15)
    public String getZtymvaariwtuktypesame15() {
        return ztymvaariwtuktypesame15;
    }

    public void setZtymvaariwtuktypesame15(String pZtymvaariwtuktypesame15) {
        ztymvaariwtuktypesame15 = pZtymvaariwtuktypesame15;
    }

    private String ztymvaariwsame15;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARIWSAME15)
    public String getZtymvaariwsame15() {
        return ztymvaariwsame15;
    }

    public void setZtymvaariwsame15(String pZtymvaariwsame15) {
        ztymvaariwsame15 = pZtymvaariwsame15;
    }

    private String ztymvaariwyentuktypesame15;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARIWYENTUKTYPESAME15)
    public String getZtymvaariwyentuktypesame15() {
        return ztymvaariwyentuktypesame15;
    }

    public void setZtymvaariwyentuktypesame15(String pZtymvaariwyentuktypesame15) {
        ztymvaariwyentuktypesame15 = pZtymvaariwyentuktypesame15;
    }

    private String ztymvaariwsameyendaka15;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARIWSAMEYENDAKA15)
    public String getZtymvaariwsameyendaka15() {
        return ztymvaariwsameyendaka15;
    }

    public void setZtymvaariwsameyendaka15(String pZtymvaariwsameyendaka15) {
        ztymvaariwsameyendaka15 = pZtymvaariwsameyendaka15;
    }

    private String ztymvaariwsameyenkijyun15;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARIWSAMEYENKIJYUN15)
    public String getZtymvaariwsameyenkijyun15() {
        return ztymvaariwsameyenkijyun15;
    }

    public void setZtymvaariwsameyenkijyun15(String pZtymvaariwsameyenkijyun15) {
        ztymvaariwsameyenkijyun15 = pZtymvaariwsameyenkijyun15;
    }

    private String ztymvaariwsameyenyasu15;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARIWSAMEYENYASU15)
    public String getZtymvaariwsameyenyasu15() {
        return ztymvaariwsameyenyasu15;
    }

    public void setZtymvaariwsameyenyasu15(String pZtymvaariwsameyenyasu15) {
        ztymvaariwsameyenyasu15 = pZtymvaariwsameyenyasu15;
    }

    private String ztymvaariumsameyendaka15;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARIUMSAMEYENDAKA15)
    public String getZtymvaariumsameyendaka15() {
        return ztymvaariumsameyendaka15;
    }

    public void setZtymvaariumsameyendaka15(String pZtymvaariumsameyendaka15) {
        ztymvaariumsameyendaka15 = pZtymvaariumsameyendaka15;
    }

    private String ztymvaariumsameyenkijyun15;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARIUMSAMEYENKIJYUN15)
    public String getZtymvaariumsameyenkijyun15() {
        return ztymvaariumsameyenkijyun15;
    }

    public void setZtymvaariumsameyenkijyun15(String pZtymvaariumsameyenkijyun15) {
        ztymvaariumsameyenkijyun15 = pZtymvaariumsameyenkijyun15;
    }

    private String ztymvaariumsameyenyasu15;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARIUMSAMEYENYASU15)
    public String getZtymvaariumsameyenyasu15() {
        return ztymvaariumsameyenyasu15;
    }

    public void setZtymvaariumsameyenyasu15(String pZtymvaariumsameyenyasu15) {
        ztymvaariumsameyenyasu15 = pZtymvaariumsameyenyasu15;
    }

    private String ztymvaariwtuktypedown15;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARIWTUKTYPEDOWN15)
    public String getZtymvaariwtuktypedown15() {
        return ztymvaariwtuktypedown15;
    }

    public void setZtymvaariwtuktypedown15(String pZtymvaariwtuktypedown15) {
        ztymvaariwtuktypedown15 = pZtymvaariwtuktypedown15;
    }

    private String ztymvaariwdown15;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARIWDOWN15)
    public String getZtymvaariwdown15() {
        return ztymvaariwdown15;
    }

    public void setZtymvaariwdown15(String pZtymvaariwdown15) {
        ztymvaariwdown15 = pZtymvaariwdown15;
    }

    private String ztymvaariwyentuktypedown15;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARIWYENTUKTYPEDOWN15)
    public String getZtymvaariwyentuktypedown15() {
        return ztymvaariwyentuktypedown15;
    }

    public void setZtymvaariwyentuktypedown15(String pZtymvaariwyentuktypedown15) {
        ztymvaariwyentuktypedown15 = pZtymvaariwyentuktypedown15;
    }

    private String ztymvaariwdownyendaka15;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARIWDOWNYENDAKA15)
    public String getZtymvaariwdownyendaka15() {
        return ztymvaariwdownyendaka15;
    }

    public void setZtymvaariwdownyendaka15(String pZtymvaariwdownyendaka15) {
        ztymvaariwdownyendaka15 = pZtymvaariwdownyendaka15;
    }

    private String ztymvaariwdownyenkijyun15;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARIWDOWNYENKIJYUN15)
    public String getZtymvaariwdownyenkijyun15() {
        return ztymvaariwdownyenkijyun15;
    }

    public void setZtymvaariwdownyenkijyun15(String pZtymvaariwdownyenkijyun15) {
        ztymvaariwdownyenkijyun15 = pZtymvaariwdownyenkijyun15;
    }

    private String ztymvaariwdownyenyasu15;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARIWDOWNYENYASU15)
    public String getZtymvaariwdownyenyasu15() {
        return ztymvaariwdownyenyasu15;
    }

    public void setZtymvaariwdownyenyasu15(String pZtymvaariwdownyenyasu15) {
        ztymvaariwdownyenyasu15 = pZtymvaariwdownyenyasu15;
    }

    private String ztymvaariumdownyendaka15;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARIUMDOWNYENDAKA15)
    public String getZtymvaariumdownyendaka15() {
        return ztymvaariumdownyendaka15;
    }

    public void setZtymvaariumdownyendaka15(String pZtymvaariumdownyendaka15) {
        ztymvaariumdownyendaka15 = pZtymvaariumdownyendaka15;
    }

    private String ztymvaariumdownyenkijyun15;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARIUMDOWNYENKIJYUN15)
    public String getZtymvaariumdownyenkijyun15() {
        return ztymvaariumdownyenkijyun15;
    }

    public void setZtymvaariumdownyenkijyun15(String pZtymvaariumdownyenkijyun15) {
        ztymvaariumdownyenkijyun15 = pZtymvaariumdownyenkijyun15;
    }

    private String ztymvaariumdownyenyasu15;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARIUMDOWNYENYASU15)
    public String getZtymvaariumdownyenyasu15() {
        return ztymvaariumdownyenyasu15;
    }

    public void setZtymvaariumdownyenyasu15(String pZtymvaariumdownyenyasu15) {
        ztymvaariumdownyenyasu15 = pZtymvaariumdownyenyasu15;
    }

    private String ztymvaarivtuktype15;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARIVTUKTYPE15)
    public String getZtymvaarivtuktype15() {
        return ztymvaarivtuktype15;
    }

    public void setZtymvaarivtuktype15(String pZtymvaarivtuktype15) {
        ztymvaarivtuktype15 = pZtymvaarivtuktype15;
    }

    private String ztymvaariv15;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVAARIV15)
    public String getZtymvaariv15() {
        return ztymvaariv15;
    }

    public void setZtymvaariv15(String pZtymvaariv15) {
        ztymvaariv15 = pZtymvaariv15;
    }

    private String ztymvanonekaisiinnumukbn01;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVANONEKAISIINNUMUKBN01)
    public String getZtymvanonekaisiinnumukbn01() {
        return ztymvanonekaisiinnumukbn01;
    }

    public void setZtymvanonekaisiinnumukbn01(String pZtymvanonekaisiinnumukbn01) {
        ztymvanonekaisiinnumukbn01 = pZtymvanonekaisiinnumukbn01;
    }

    private String ztymvanonenenoutouym01;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVANONENENOUTOUYM01)
    public String getZtymvanonenenoutouym01() {
        return ztymvanonenenoutouym01;
    }

    public void setZtymvanonenenoutouym01(String pZtymvanonenenoutouym01) {
        ztymvanonenenoutouym01 = pZtymvanonenenoutouym01;
    }

    private String ztymvanonewtuktype01;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVANONEWTUKTYPE01)
    public String getZtymvanonewtuktype01() {
        return ztymvanonewtuktype01;
    }

    public void setZtymvanonewtuktype01(String pZtymvanonewtuktype01) {
        ztymvanonewtuktype01 = pZtymvanonewtuktype01;
    }

    private String ztymvanonew01;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVANONEW01)
    public String getZtymvanonew01() {
        return ztymvanonew01;
    }

    public void setZtymvanonew01(String pZtymvanonew01) {
        ztymvanonew01 = pZtymvanonew01;
    }

    private String ztymvanonewyentuktype01;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVANONEWYENTUKTYPE01)
    public String getZtymvanonewyentuktype01() {
        return ztymvanonewyentuktype01;
    }

    public void setZtymvanonewyentuktype01(String pZtymvanonewyentuktype01) {
        ztymvanonewyentuktype01 = pZtymvanonewyentuktype01;
    }

    private String ztymvanonewyendaka01;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVANONEWYENDAKA01)
    public String getZtymvanonewyendaka01() {
        return ztymvanonewyendaka01;
    }

    public void setZtymvanonewyendaka01(String pZtymvanonewyendaka01) {
        ztymvanonewyendaka01 = pZtymvanonewyendaka01;
    }

    private String ztymvanonewyenkijyun01;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVANONEWYENKIJYUN01)
    public String getZtymvanonewyenkijyun01() {
        return ztymvanonewyenkijyun01;
    }

    public void setZtymvanonewyenkijyun01(String pZtymvanonewyenkijyun01) {
        ztymvanonewyenkijyun01 = pZtymvanonewyenkijyun01;
    }

    private String ztymvanonewyenyasu01;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVANONEWYENYASU01)
    public String getZtymvanonewyenyasu01() {
        return ztymvanonewyenyasu01;
    }

    public void setZtymvanonewyenyasu01(String pZtymvanonewyenyasu01) {
        ztymvanonewyenyasu01 = pZtymvanonewyenyasu01;
    }

    private String ztymvanoneumyendaka01;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVANONEUMYENDAKA01)
    public String getZtymvanoneumyendaka01() {
        return ztymvanoneumyendaka01;
    }

    public void setZtymvanoneumyendaka01(String pZtymvanoneumyendaka01) {
        ztymvanoneumyendaka01 = pZtymvanoneumyendaka01;
    }

    private String ztymvanoneumyenkijyun01;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVANONEUMYENKIJYUN01)
    public String getZtymvanoneumyenkijyun01() {
        return ztymvanoneumyenkijyun01;
    }

    public void setZtymvanoneumyenkijyun01(String pZtymvanoneumyenkijyun01) {
        ztymvanoneumyenkijyun01 = pZtymvanoneumyenkijyun01;
    }

    private String ztymvanoneumyenyasu01;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVANONEUMYENYASU01)
    public String getZtymvanoneumyenyasu01() {
        return ztymvanoneumyenyasu01;
    }

    public void setZtymvanoneumyenyasu01(String pZtymvanoneumyenyasu01) {
        ztymvanoneumyenyasu01 = pZtymvanoneumyenyasu01;
    }

    private String ztymvanonevtuktype01;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVANONEVTUKTYPE01)
    public String getZtymvanonevtuktype01() {
        return ztymvanonevtuktype01;
    }

    public void setZtymvanonevtuktype01(String pZtymvanonevtuktype01) {
        ztymvanonevtuktype01 = pZtymvanonevtuktype01;
    }

    private String ztymvanonev01;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVANONEV01)
    public String getZtymvanonev01() {
        return ztymvanonev01;
    }

    public void setZtymvanonev01(String pZtymvanonev01) {
        ztymvanonev01 = pZtymvanonev01;
    }

    private String ztymvanonekaisiinnumukbn02;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVANONEKAISIINNUMUKBN02)
    public String getZtymvanonekaisiinnumukbn02() {
        return ztymvanonekaisiinnumukbn02;
    }

    public void setZtymvanonekaisiinnumukbn02(String pZtymvanonekaisiinnumukbn02) {
        ztymvanonekaisiinnumukbn02 = pZtymvanonekaisiinnumukbn02;
    }

    private String ztymvanonenenoutouym02;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVANONENENOUTOUYM02)
    public String getZtymvanonenenoutouym02() {
        return ztymvanonenenoutouym02;
    }

    public void setZtymvanonenenoutouym02(String pZtymvanonenenoutouym02) {
        ztymvanonenenoutouym02 = pZtymvanonenenoutouym02;
    }

    private String ztymvanonewtuktype02;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVANONEWTUKTYPE02)
    public String getZtymvanonewtuktype02() {
        return ztymvanonewtuktype02;
    }

    public void setZtymvanonewtuktype02(String pZtymvanonewtuktype02) {
        ztymvanonewtuktype02 = pZtymvanonewtuktype02;
    }

    private String ztymvanonew02;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVANONEW02)
    public String getZtymvanonew02() {
        return ztymvanonew02;
    }

    public void setZtymvanonew02(String pZtymvanonew02) {
        ztymvanonew02 = pZtymvanonew02;
    }

    private String ztymvanonewyentuktype02;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVANONEWYENTUKTYPE02)
    public String getZtymvanonewyentuktype02() {
        return ztymvanonewyentuktype02;
    }

    public void setZtymvanonewyentuktype02(String pZtymvanonewyentuktype02) {
        ztymvanonewyentuktype02 = pZtymvanonewyentuktype02;
    }

    private String ztymvanonewyendaka02;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVANONEWYENDAKA02)
    public String getZtymvanonewyendaka02() {
        return ztymvanonewyendaka02;
    }

    public void setZtymvanonewyendaka02(String pZtymvanonewyendaka02) {
        ztymvanonewyendaka02 = pZtymvanonewyendaka02;
    }

    private String ztymvanonewyenkijyun02;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVANONEWYENKIJYUN02)
    public String getZtymvanonewyenkijyun02() {
        return ztymvanonewyenkijyun02;
    }

    public void setZtymvanonewyenkijyun02(String pZtymvanonewyenkijyun02) {
        ztymvanonewyenkijyun02 = pZtymvanonewyenkijyun02;
    }

    private String ztymvanonewyenyasu02;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVANONEWYENYASU02)
    public String getZtymvanonewyenyasu02() {
        return ztymvanonewyenyasu02;
    }

    public void setZtymvanonewyenyasu02(String pZtymvanonewyenyasu02) {
        ztymvanonewyenyasu02 = pZtymvanonewyenyasu02;
    }

    private String ztymvanoneumyendaka02;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVANONEUMYENDAKA02)
    public String getZtymvanoneumyendaka02() {
        return ztymvanoneumyendaka02;
    }

    public void setZtymvanoneumyendaka02(String pZtymvanoneumyendaka02) {
        ztymvanoneumyendaka02 = pZtymvanoneumyendaka02;
    }

    private String ztymvanoneumyenkijyun02;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVANONEUMYENKIJYUN02)
    public String getZtymvanoneumyenkijyun02() {
        return ztymvanoneumyenkijyun02;
    }

    public void setZtymvanoneumyenkijyun02(String pZtymvanoneumyenkijyun02) {
        ztymvanoneumyenkijyun02 = pZtymvanoneumyenkijyun02;
    }

    private String ztymvanoneumyenyasu02;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVANONEUMYENYASU02)
    public String getZtymvanoneumyenyasu02() {
        return ztymvanoneumyenyasu02;
    }

    public void setZtymvanoneumyenyasu02(String pZtymvanoneumyenyasu02) {
        ztymvanoneumyenyasu02 = pZtymvanoneumyenyasu02;
    }

    private String ztymvanonevtuktype02;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVANONEVTUKTYPE02)
    public String getZtymvanonevtuktype02() {
        return ztymvanonevtuktype02;
    }

    public void setZtymvanonevtuktype02(String pZtymvanonevtuktype02) {
        ztymvanonevtuktype02 = pZtymvanonevtuktype02;
    }

    private String ztymvanonev02;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVANONEV02)
    public String getZtymvanonev02() {
        return ztymvanonev02;
    }

    public void setZtymvanonev02(String pZtymvanonev02) {
        ztymvanonev02 = pZtymvanonev02;
    }

    private String ztymvanonekaisiinnumukbn03;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVANONEKAISIINNUMUKBN03)
    public String getZtymvanonekaisiinnumukbn03() {
        return ztymvanonekaisiinnumukbn03;
    }

    public void setZtymvanonekaisiinnumukbn03(String pZtymvanonekaisiinnumukbn03) {
        ztymvanonekaisiinnumukbn03 = pZtymvanonekaisiinnumukbn03;
    }

    private String ztymvanonenenoutouym03;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVANONENENOUTOUYM03)
    public String getZtymvanonenenoutouym03() {
        return ztymvanonenenoutouym03;
    }

    public void setZtymvanonenenoutouym03(String pZtymvanonenenoutouym03) {
        ztymvanonenenoutouym03 = pZtymvanonenenoutouym03;
    }

    private String ztymvanonewtuktype03;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVANONEWTUKTYPE03)
    public String getZtymvanonewtuktype03() {
        return ztymvanonewtuktype03;
    }

    public void setZtymvanonewtuktype03(String pZtymvanonewtuktype03) {
        ztymvanonewtuktype03 = pZtymvanonewtuktype03;
    }

    private String ztymvanonew03;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVANONEW03)
    public String getZtymvanonew03() {
        return ztymvanonew03;
    }

    public void setZtymvanonew03(String pZtymvanonew03) {
        ztymvanonew03 = pZtymvanonew03;
    }

    private String ztymvanonewyentuktype03;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVANONEWYENTUKTYPE03)
    public String getZtymvanonewyentuktype03() {
        return ztymvanonewyentuktype03;
    }

    public void setZtymvanonewyentuktype03(String pZtymvanonewyentuktype03) {
        ztymvanonewyentuktype03 = pZtymvanonewyentuktype03;
    }

    private String ztymvanonewyendaka03;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVANONEWYENDAKA03)
    public String getZtymvanonewyendaka03() {
        return ztymvanonewyendaka03;
    }

    public void setZtymvanonewyendaka03(String pZtymvanonewyendaka03) {
        ztymvanonewyendaka03 = pZtymvanonewyendaka03;
    }

    private String ztymvanonewyenkijyun03;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVANONEWYENKIJYUN03)
    public String getZtymvanonewyenkijyun03() {
        return ztymvanonewyenkijyun03;
    }

    public void setZtymvanonewyenkijyun03(String pZtymvanonewyenkijyun03) {
        ztymvanonewyenkijyun03 = pZtymvanonewyenkijyun03;
    }

    private String ztymvanonewyenyasu03;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVANONEWYENYASU03)
    public String getZtymvanonewyenyasu03() {
        return ztymvanonewyenyasu03;
    }

    public void setZtymvanonewyenyasu03(String pZtymvanonewyenyasu03) {
        ztymvanonewyenyasu03 = pZtymvanonewyenyasu03;
    }

    private String ztymvanoneumyendaka03;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVANONEUMYENDAKA03)
    public String getZtymvanoneumyendaka03() {
        return ztymvanoneumyendaka03;
    }

    public void setZtymvanoneumyendaka03(String pZtymvanoneumyendaka03) {
        ztymvanoneumyendaka03 = pZtymvanoneumyendaka03;
    }

    private String ztymvanoneumyenkijyun03;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVANONEUMYENKIJYUN03)
    public String getZtymvanoneumyenkijyun03() {
        return ztymvanoneumyenkijyun03;
    }

    public void setZtymvanoneumyenkijyun03(String pZtymvanoneumyenkijyun03) {
        ztymvanoneumyenkijyun03 = pZtymvanoneumyenkijyun03;
    }

    private String ztymvanoneumyenyasu03;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVANONEUMYENYASU03)
    public String getZtymvanoneumyenyasu03() {
        return ztymvanoneumyenyasu03;
    }

    public void setZtymvanoneumyenyasu03(String pZtymvanoneumyenyasu03) {
        ztymvanoneumyenyasu03 = pZtymvanoneumyenyasu03;
    }

    private String ztymvanonevtuktype03;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVANONEVTUKTYPE03)
    public String getZtymvanonevtuktype03() {
        return ztymvanonevtuktype03;
    }

    public void setZtymvanonevtuktype03(String pZtymvanonevtuktype03) {
        ztymvanonevtuktype03 = pZtymvanonevtuktype03;
    }

    private String ztymvanonev03;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVANONEV03)
    public String getZtymvanonev03() {
        return ztymvanonev03;
    }

    public void setZtymvanonev03(String pZtymvanonev03) {
        ztymvanonev03 = pZtymvanonev03;
    }

    private String ztymvanonekaisiinnumukbn04;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVANONEKAISIINNUMUKBN04)
    public String getZtymvanonekaisiinnumukbn04() {
        return ztymvanonekaisiinnumukbn04;
    }

    public void setZtymvanonekaisiinnumukbn04(String pZtymvanonekaisiinnumukbn04) {
        ztymvanonekaisiinnumukbn04 = pZtymvanonekaisiinnumukbn04;
    }

    private String ztymvanonenenoutouym04;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVANONENENOUTOUYM04)
    public String getZtymvanonenenoutouym04() {
        return ztymvanonenenoutouym04;
    }

    public void setZtymvanonenenoutouym04(String pZtymvanonenenoutouym04) {
        ztymvanonenenoutouym04 = pZtymvanonenenoutouym04;
    }

    private String ztymvanonewtuktype04;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVANONEWTUKTYPE04)
    public String getZtymvanonewtuktype04() {
        return ztymvanonewtuktype04;
    }

    public void setZtymvanonewtuktype04(String pZtymvanonewtuktype04) {
        ztymvanonewtuktype04 = pZtymvanonewtuktype04;
    }

    private String ztymvanonew04;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVANONEW04)
    public String getZtymvanonew04() {
        return ztymvanonew04;
    }

    public void setZtymvanonew04(String pZtymvanonew04) {
        ztymvanonew04 = pZtymvanonew04;
    }

    private String ztymvanonewyentuktype04;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVANONEWYENTUKTYPE04)
    public String getZtymvanonewyentuktype04() {
        return ztymvanonewyentuktype04;
    }

    public void setZtymvanonewyentuktype04(String pZtymvanonewyentuktype04) {
        ztymvanonewyentuktype04 = pZtymvanonewyentuktype04;
    }

    private String ztymvanonewyendaka04;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVANONEWYENDAKA04)
    public String getZtymvanonewyendaka04() {
        return ztymvanonewyendaka04;
    }

    public void setZtymvanonewyendaka04(String pZtymvanonewyendaka04) {
        ztymvanonewyendaka04 = pZtymvanonewyendaka04;
    }

    private String ztymvanonewyenkijyun04;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVANONEWYENKIJYUN04)
    public String getZtymvanonewyenkijyun04() {
        return ztymvanonewyenkijyun04;
    }

    public void setZtymvanonewyenkijyun04(String pZtymvanonewyenkijyun04) {
        ztymvanonewyenkijyun04 = pZtymvanonewyenkijyun04;
    }

    private String ztymvanonewyenyasu04;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVANONEWYENYASU04)
    public String getZtymvanonewyenyasu04() {
        return ztymvanonewyenyasu04;
    }

    public void setZtymvanonewyenyasu04(String pZtymvanonewyenyasu04) {
        ztymvanonewyenyasu04 = pZtymvanonewyenyasu04;
    }

    private String ztymvanoneumyendaka04;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVANONEUMYENDAKA04)
    public String getZtymvanoneumyendaka04() {
        return ztymvanoneumyendaka04;
    }

    public void setZtymvanoneumyendaka04(String pZtymvanoneumyendaka04) {
        ztymvanoneumyendaka04 = pZtymvanoneumyendaka04;
    }

    private String ztymvanoneumyenkijyun04;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVANONEUMYENKIJYUN04)
    public String getZtymvanoneumyenkijyun04() {
        return ztymvanoneumyenkijyun04;
    }

    public void setZtymvanoneumyenkijyun04(String pZtymvanoneumyenkijyun04) {
        ztymvanoneumyenkijyun04 = pZtymvanoneumyenkijyun04;
    }

    private String ztymvanoneumyenyasu04;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVANONEUMYENYASU04)
    public String getZtymvanoneumyenyasu04() {
        return ztymvanoneumyenyasu04;
    }

    public void setZtymvanoneumyenyasu04(String pZtymvanoneumyenyasu04) {
        ztymvanoneumyenyasu04 = pZtymvanoneumyenyasu04;
    }

    private String ztymvanonevtuktype04;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVANONEVTUKTYPE04)
    public String getZtymvanonevtuktype04() {
        return ztymvanonevtuktype04;
    }

    public void setZtymvanonevtuktype04(String pZtymvanonevtuktype04) {
        ztymvanonevtuktype04 = pZtymvanonevtuktype04;
    }

    private String ztymvanonev04;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVANONEV04)
    public String getZtymvanonev04() {
        return ztymvanonev04;
    }

    public void setZtymvanonev04(String pZtymvanonev04) {
        ztymvanonev04 = pZtymvanonev04;
    }

    private String ztymvanonekaisiinnumukbn05;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVANONEKAISIINNUMUKBN05)
    public String getZtymvanonekaisiinnumukbn05() {
        return ztymvanonekaisiinnumukbn05;
    }

    public void setZtymvanonekaisiinnumukbn05(String pZtymvanonekaisiinnumukbn05) {
        ztymvanonekaisiinnumukbn05 = pZtymvanonekaisiinnumukbn05;
    }

    private String ztymvanonenenoutouym05;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVANONENENOUTOUYM05)
    public String getZtymvanonenenoutouym05() {
        return ztymvanonenenoutouym05;
    }

    public void setZtymvanonenenoutouym05(String pZtymvanonenenoutouym05) {
        ztymvanonenenoutouym05 = pZtymvanonenenoutouym05;
    }

    private String ztymvanonewtuktype05;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVANONEWTUKTYPE05)
    public String getZtymvanonewtuktype05() {
        return ztymvanonewtuktype05;
    }

    public void setZtymvanonewtuktype05(String pZtymvanonewtuktype05) {
        ztymvanonewtuktype05 = pZtymvanonewtuktype05;
    }

    private String ztymvanonew05;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVANONEW05)
    public String getZtymvanonew05() {
        return ztymvanonew05;
    }

    public void setZtymvanonew05(String pZtymvanonew05) {
        ztymvanonew05 = pZtymvanonew05;
    }

    private String ztymvanonewyentuktype05;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVANONEWYENTUKTYPE05)
    public String getZtymvanonewyentuktype05() {
        return ztymvanonewyentuktype05;
    }

    public void setZtymvanonewyentuktype05(String pZtymvanonewyentuktype05) {
        ztymvanonewyentuktype05 = pZtymvanonewyentuktype05;
    }

    private String ztymvanonewyendaka05;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVANONEWYENDAKA05)
    public String getZtymvanonewyendaka05() {
        return ztymvanonewyendaka05;
    }

    public void setZtymvanonewyendaka05(String pZtymvanonewyendaka05) {
        ztymvanonewyendaka05 = pZtymvanonewyendaka05;
    }

    private String ztymvanonewyenkijyun05;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVANONEWYENKIJYUN05)
    public String getZtymvanonewyenkijyun05() {
        return ztymvanonewyenkijyun05;
    }

    public void setZtymvanonewyenkijyun05(String pZtymvanonewyenkijyun05) {
        ztymvanonewyenkijyun05 = pZtymvanonewyenkijyun05;
    }

    private String ztymvanonewyenyasu05;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVANONEWYENYASU05)
    public String getZtymvanonewyenyasu05() {
        return ztymvanonewyenyasu05;
    }

    public void setZtymvanonewyenyasu05(String pZtymvanonewyenyasu05) {
        ztymvanonewyenyasu05 = pZtymvanonewyenyasu05;
    }

    private String ztymvanoneumyendaka05;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVANONEUMYENDAKA05)
    public String getZtymvanoneumyendaka05() {
        return ztymvanoneumyendaka05;
    }

    public void setZtymvanoneumyendaka05(String pZtymvanoneumyendaka05) {
        ztymvanoneumyendaka05 = pZtymvanoneumyendaka05;
    }

    private String ztymvanoneumyenkijyun05;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVANONEUMYENKIJYUN05)
    public String getZtymvanoneumyenkijyun05() {
        return ztymvanoneumyenkijyun05;
    }

    public void setZtymvanoneumyenkijyun05(String pZtymvanoneumyenkijyun05) {
        ztymvanoneumyenkijyun05 = pZtymvanoneumyenkijyun05;
    }

    private String ztymvanoneumyenyasu05;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVANONEUMYENYASU05)
    public String getZtymvanoneumyenyasu05() {
        return ztymvanoneumyenyasu05;
    }

    public void setZtymvanoneumyenyasu05(String pZtymvanoneumyenyasu05) {
        ztymvanoneumyenyasu05 = pZtymvanoneumyenyasu05;
    }

    private String ztymvanonevtuktype05;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVANONEVTUKTYPE05)
    public String getZtymvanonevtuktype05() {
        return ztymvanonevtuktype05;
    }

    public void setZtymvanonevtuktype05(String pZtymvanonevtuktype05) {
        ztymvanonevtuktype05 = pZtymvanonevtuktype05;
    }

    private String ztymvanonev05;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVANONEV05)
    public String getZtymvanonev05() {
        return ztymvanonev05;
    }

    public void setZtymvanonev05(String pZtymvanonev05) {
        ztymvanonev05 = pZtymvanonev05;
    }

    private String ztymvanonekaisiinnumukbn06;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVANONEKAISIINNUMUKBN06)
    public String getZtymvanonekaisiinnumukbn06() {
        return ztymvanonekaisiinnumukbn06;
    }

    public void setZtymvanonekaisiinnumukbn06(String pZtymvanonekaisiinnumukbn06) {
        ztymvanonekaisiinnumukbn06 = pZtymvanonekaisiinnumukbn06;
    }

    private String ztymvanonenenoutouym06;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVANONENENOUTOUYM06)
    public String getZtymvanonenenoutouym06() {
        return ztymvanonenenoutouym06;
    }

    public void setZtymvanonenenoutouym06(String pZtymvanonenenoutouym06) {
        ztymvanonenenoutouym06 = pZtymvanonenenoutouym06;
    }

    private String ztymvanonewtuktype06;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVANONEWTUKTYPE06)
    public String getZtymvanonewtuktype06() {
        return ztymvanonewtuktype06;
    }

    public void setZtymvanonewtuktype06(String pZtymvanonewtuktype06) {
        ztymvanonewtuktype06 = pZtymvanonewtuktype06;
    }

    private String ztymvanonew06;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVANONEW06)
    public String getZtymvanonew06() {
        return ztymvanonew06;
    }

    public void setZtymvanonew06(String pZtymvanonew06) {
        ztymvanonew06 = pZtymvanonew06;
    }

    private String ztymvanonewyentuktype06;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVANONEWYENTUKTYPE06)
    public String getZtymvanonewyentuktype06() {
        return ztymvanonewyentuktype06;
    }

    public void setZtymvanonewyentuktype06(String pZtymvanonewyentuktype06) {
        ztymvanonewyentuktype06 = pZtymvanonewyentuktype06;
    }

    private String ztymvanonewyendaka06;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVANONEWYENDAKA06)
    public String getZtymvanonewyendaka06() {
        return ztymvanonewyendaka06;
    }

    public void setZtymvanonewyendaka06(String pZtymvanonewyendaka06) {
        ztymvanonewyendaka06 = pZtymvanonewyendaka06;
    }

    private String ztymvanonewyenkijyun06;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVANONEWYENKIJYUN06)
    public String getZtymvanonewyenkijyun06() {
        return ztymvanonewyenkijyun06;
    }

    public void setZtymvanonewyenkijyun06(String pZtymvanonewyenkijyun06) {
        ztymvanonewyenkijyun06 = pZtymvanonewyenkijyun06;
    }

    private String ztymvanonewyenyasu06;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVANONEWYENYASU06)
    public String getZtymvanonewyenyasu06() {
        return ztymvanonewyenyasu06;
    }

    public void setZtymvanonewyenyasu06(String pZtymvanonewyenyasu06) {
        ztymvanonewyenyasu06 = pZtymvanonewyenyasu06;
    }

    private String ztymvanoneumyendaka06;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVANONEUMYENDAKA06)
    public String getZtymvanoneumyendaka06() {
        return ztymvanoneumyendaka06;
    }

    public void setZtymvanoneumyendaka06(String pZtymvanoneumyendaka06) {
        ztymvanoneumyendaka06 = pZtymvanoneumyendaka06;
    }

    private String ztymvanoneumyenkijyun06;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVANONEUMYENKIJYUN06)
    public String getZtymvanoneumyenkijyun06() {
        return ztymvanoneumyenkijyun06;
    }

    public void setZtymvanoneumyenkijyun06(String pZtymvanoneumyenkijyun06) {
        ztymvanoneumyenkijyun06 = pZtymvanoneumyenkijyun06;
    }

    private String ztymvanoneumyenyasu06;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVANONEUMYENYASU06)
    public String getZtymvanoneumyenyasu06() {
        return ztymvanoneumyenyasu06;
    }

    public void setZtymvanoneumyenyasu06(String pZtymvanoneumyenyasu06) {
        ztymvanoneumyenyasu06 = pZtymvanoneumyenyasu06;
    }

    private String ztymvanonevtuktype06;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVANONEVTUKTYPE06)
    public String getZtymvanonevtuktype06() {
        return ztymvanonevtuktype06;
    }

    public void setZtymvanonevtuktype06(String pZtymvanonevtuktype06) {
        ztymvanonevtuktype06 = pZtymvanonevtuktype06;
    }

    private String ztymvanonev06;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVANONEV06)
    public String getZtymvanonev06() {
        return ztymvanonev06;
    }

    public void setZtymvanonev06(String pZtymvanonev06) {
        ztymvanonev06 = pZtymvanonev06;
    }

    private String ztymvanonekaisiinnumukbn07;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVANONEKAISIINNUMUKBN07)
    public String getZtymvanonekaisiinnumukbn07() {
        return ztymvanonekaisiinnumukbn07;
    }

    public void setZtymvanonekaisiinnumukbn07(String pZtymvanonekaisiinnumukbn07) {
        ztymvanonekaisiinnumukbn07 = pZtymvanonekaisiinnumukbn07;
    }

    private String ztymvanonenenoutouym07;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVANONENENOUTOUYM07)
    public String getZtymvanonenenoutouym07() {
        return ztymvanonenenoutouym07;
    }

    public void setZtymvanonenenoutouym07(String pZtymvanonenenoutouym07) {
        ztymvanonenenoutouym07 = pZtymvanonenenoutouym07;
    }

    private String ztymvanonewtuktype07;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVANONEWTUKTYPE07)
    public String getZtymvanonewtuktype07() {
        return ztymvanonewtuktype07;
    }

    public void setZtymvanonewtuktype07(String pZtymvanonewtuktype07) {
        ztymvanonewtuktype07 = pZtymvanonewtuktype07;
    }

    private String ztymvanonew07;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVANONEW07)
    public String getZtymvanonew07() {
        return ztymvanonew07;
    }

    public void setZtymvanonew07(String pZtymvanonew07) {
        ztymvanonew07 = pZtymvanonew07;
    }

    private String ztymvanonewyentuktype07;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVANONEWYENTUKTYPE07)
    public String getZtymvanonewyentuktype07() {
        return ztymvanonewyentuktype07;
    }

    public void setZtymvanonewyentuktype07(String pZtymvanonewyentuktype07) {
        ztymvanonewyentuktype07 = pZtymvanonewyentuktype07;
    }

    private String ztymvanonewyendaka07;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVANONEWYENDAKA07)
    public String getZtymvanonewyendaka07() {
        return ztymvanonewyendaka07;
    }

    public void setZtymvanonewyendaka07(String pZtymvanonewyendaka07) {
        ztymvanonewyendaka07 = pZtymvanonewyendaka07;
    }

    private String ztymvanonewyenkijyun07;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVANONEWYENKIJYUN07)
    public String getZtymvanonewyenkijyun07() {
        return ztymvanonewyenkijyun07;
    }

    public void setZtymvanonewyenkijyun07(String pZtymvanonewyenkijyun07) {
        ztymvanonewyenkijyun07 = pZtymvanonewyenkijyun07;
    }

    private String ztymvanonewyenyasu07;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVANONEWYENYASU07)
    public String getZtymvanonewyenyasu07() {
        return ztymvanonewyenyasu07;
    }

    public void setZtymvanonewyenyasu07(String pZtymvanonewyenyasu07) {
        ztymvanonewyenyasu07 = pZtymvanonewyenyasu07;
    }

    private String ztymvanoneumyendaka07;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVANONEUMYENDAKA07)
    public String getZtymvanoneumyendaka07() {
        return ztymvanoneumyendaka07;
    }

    public void setZtymvanoneumyendaka07(String pZtymvanoneumyendaka07) {
        ztymvanoneumyendaka07 = pZtymvanoneumyendaka07;
    }

    private String ztymvanoneumyenkijyun07;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVANONEUMYENKIJYUN07)
    public String getZtymvanoneumyenkijyun07() {
        return ztymvanoneumyenkijyun07;
    }

    public void setZtymvanoneumyenkijyun07(String pZtymvanoneumyenkijyun07) {
        ztymvanoneumyenkijyun07 = pZtymvanoneumyenkijyun07;
    }

    private String ztymvanoneumyenyasu07;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVANONEUMYENYASU07)
    public String getZtymvanoneumyenyasu07() {
        return ztymvanoneumyenyasu07;
    }

    public void setZtymvanoneumyenyasu07(String pZtymvanoneumyenyasu07) {
        ztymvanoneumyenyasu07 = pZtymvanoneumyenyasu07;
    }

    private String ztymvanonevtuktype07;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVANONEVTUKTYPE07)
    public String getZtymvanonevtuktype07() {
        return ztymvanonevtuktype07;
    }

    public void setZtymvanonevtuktype07(String pZtymvanonevtuktype07) {
        ztymvanonevtuktype07 = pZtymvanonevtuktype07;
    }

    private String ztymvanonev07;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVANONEV07)
    public String getZtymvanonev07() {
        return ztymvanonev07;
    }

    public void setZtymvanonev07(String pZtymvanonev07) {
        ztymvanonev07 = pZtymvanonev07;
    }

    private String ztymvanonekaisiinnumukbn08;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVANONEKAISIINNUMUKBN08)
    public String getZtymvanonekaisiinnumukbn08() {
        return ztymvanonekaisiinnumukbn08;
    }

    public void setZtymvanonekaisiinnumukbn08(String pZtymvanonekaisiinnumukbn08) {
        ztymvanonekaisiinnumukbn08 = pZtymvanonekaisiinnumukbn08;
    }

    private String ztymvanonenenoutouym08;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVANONENENOUTOUYM08)
    public String getZtymvanonenenoutouym08() {
        return ztymvanonenenoutouym08;
    }

    public void setZtymvanonenenoutouym08(String pZtymvanonenenoutouym08) {
        ztymvanonenenoutouym08 = pZtymvanonenenoutouym08;
    }

    private String ztymvanonewtuktype08;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVANONEWTUKTYPE08)
    public String getZtymvanonewtuktype08() {
        return ztymvanonewtuktype08;
    }

    public void setZtymvanonewtuktype08(String pZtymvanonewtuktype08) {
        ztymvanonewtuktype08 = pZtymvanonewtuktype08;
    }

    private String ztymvanonew08;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVANONEW08)
    public String getZtymvanonew08() {
        return ztymvanonew08;
    }

    public void setZtymvanonew08(String pZtymvanonew08) {
        ztymvanonew08 = pZtymvanonew08;
    }

    private String ztymvanonewyentuktype08;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVANONEWYENTUKTYPE08)
    public String getZtymvanonewyentuktype08() {
        return ztymvanonewyentuktype08;
    }

    public void setZtymvanonewyentuktype08(String pZtymvanonewyentuktype08) {
        ztymvanonewyentuktype08 = pZtymvanonewyentuktype08;
    }

    private String ztymvanonewyendaka08;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVANONEWYENDAKA08)
    public String getZtymvanonewyendaka08() {
        return ztymvanonewyendaka08;
    }

    public void setZtymvanonewyendaka08(String pZtymvanonewyendaka08) {
        ztymvanonewyendaka08 = pZtymvanonewyendaka08;
    }

    private String ztymvanonewyenkijyun08;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVANONEWYENKIJYUN08)
    public String getZtymvanonewyenkijyun08() {
        return ztymvanonewyenkijyun08;
    }

    public void setZtymvanonewyenkijyun08(String pZtymvanonewyenkijyun08) {
        ztymvanonewyenkijyun08 = pZtymvanonewyenkijyun08;
    }

    private String ztymvanonewyenyasu08;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVANONEWYENYASU08)
    public String getZtymvanonewyenyasu08() {
        return ztymvanonewyenyasu08;
    }

    public void setZtymvanonewyenyasu08(String pZtymvanonewyenyasu08) {
        ztymvanonewyenyasu08 = pZtymvanonewyenyasu08;
    }

    private String ztymvanoneumyendaka08;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVANONEUMYENDAKA08)
    public String getZtymvanoneumyendaka08() {
        return ztymvanoneumyendaka08;
    }

    public void setZtymvanoneumyendaka08(String pZtymvanoneumyendaka08) {
        ztymvanoneumyendaka08 = pZtymvanoneumyendaka08;
    }

    private String ztymvanoneumyenkijyun08;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVANONEUMYENKIJYUN08)
    public String getZtymvanoneumyenkijyun08() {
        return ztymvanoneumyenkijyun08;
    }

    public void setZtymvanoneumyenkijyun08(String pZtymvanoneumyenkijyun08) {
        ztymvanoneumyenkijyun08 = pZtymvanoneumyenkijyun08;
    }

    private String ztymvanoneumyenyasu08;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVANONEUMYENYASU08)
    public String getZtymvanoneumyenyasu08() {
        return ztymvanoneumyenyasu08;
    }

    public void setZtymvanoneumyenyasu08(String pZtymvanoneumyenyasu08) {
        ztymvanoneumyenyasu08 = pZtymvanoneumyenyasu08;
    }

    private String ztymvanonevtuktype08;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVANONEVTUKTYPE08)
    public String getZtymvanonevtuktype08() {
        return ztymvanonevtuktype08;
    }

    public void setZtymvanonevtuktype08(String pZtymvanonevtuktype08) {
        ztymvanonevtuktype08 = pZtymvanonevtuktype08;
    }

    private String ztymvanonev08;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVANONEV08)
    public String getZtymvanonev08() {
        return ztymvanonev08;
    }

    public void setZtymvanonev08(String pZtymvanonev08) {
        ztymvanonev08 = pZtymvanonev08;
    }

    private String ztymvanonekaisiinnumukbn09;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVANONEKAISIINNUMUKBN09)
    public String getZtymvanonekaisiinnumukbn09() {
        return ztymvanonekaisiinnumukbn09;
    }

    public void setZtymvanonekaisiinnumukbn09(String pZtymvanonekaisiinnumukbn09) {
        ztymvanonekaisiinnumukbn09 = pZtymvanonekaisiinnumukbn09;
    }

    private String ztymvanonenenoutouym09;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVANONENENOUTOUYM09)
    public String getZtymvanonenenoutouym09() {
        return ztymvanonenenoutouym09;
    }

    public void setZtymvanonenenoutouym09(String pZtymvanonenenoutouym09) {
        ztymvanonenenoutouym09 = pZtymvanonenenoutouym09;
    }

    private String ztymvanonewtuktype09;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVANONEWTUKTYPE09)
    public String getZtymvanonewtuktype09() {
        return ztymvanonewtuktype09;
    }

    public void setZtymvanonewtuktype09(String pZtymvanonewtuktype09) {
        ztymvanonewtuktype09 = pZtymvanonewtuktype09;
    }

    private String ztymvanonew09;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVANONEW09)
    public String getZtymvanonew09() {
        return ztymvanonew09;
    }

    public void setZtymvanonew09(String pZtymvanonew09) {
        ztymvanonew09 = pZtymvanonew09;
    }

    private String ztymvanonewyentuktype09;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVANONEWYENTUKTYPE09)
    public String getZtymvanonewyentuktype09() {
        return ztymvanonewyentuktype09;
    }

    public void setZtymvanonewyentuktype09(String pZtymvanonewyentuktype09) {
        ztymvanonewyentuktype09 = pZtymvanonewyentuktype09;
    }

    private String ztymvanonewyendaka09;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVANONEWYENDAKA09)
    public String getZtymvanonewyendaka09() {
        return ztymvanonewyendaka09;
    }

    public void setZtymvanonewyendaka09(String pZtymvanonewyendaka09) {
        ztymvanonewyendaka09 = pZtymvanonewyendaka09;
    }

    private String ztymvanonewyenkijyun09;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVANONEWYENKIJYUN09)
    public String getZtymvanonewyenkijyun09() {
        return ztymvanonewyenkijyun09;
    }

    public void setZtymvanonewyenkijyun09(String pZtymvanonewyenkijyun09) {
        ztymvanonewyenkijyun09 = pZtymvanonewyenkijyun09;
    }

    private String ztymvanonewyenyasu09;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVANONEWYENYASU09)
    public String getZtymvanonewyenyasu09() {
        return ztymvanonewyenyasu09;
    }

    public void setZtymvanonewyenyasu09(String pZtymvanonewyenyasu09) {
        ztymvanonewyenyasu09 = pZtymvanonewyenyasu09;
    }

    private String ztymvanoneumyendaka09;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVANONEUMYENDAKA09)
    public String getZtymvanoneumyendaka09() {
        return ztymvanoneumyendaka09;
    }

    public void setZtymvanoneumyendaka09(String pZtymvanoneumyendaka09) {
        ztymvanoneumyendaka09 = pZtymvanoneumyendaka09;
    }

    private String ztymvanoneumyenkijyun09;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVANONEUMYENKIJYUN09)
    public String getZtymvanoneumyenkijyun09() {
        return ztymvanoneumyenkijyun09;
    }

    public void setZtymvanoneumyenkijyun09(String pZtymvanoneumyenkijyun09) {
        ztymvanoneumyenkijyun09 = pZtymvanoneumyenkijyun09;
    }

    private String ztymvanoneumyenyasu09;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVANONEUMYENYASU09)
    public String getZtymvanoneumyenyasu09() {
        return ztymvanoneumyenyasu09;
    }

    public void setZtymvanoneumyenyasu09(String pZtymvanoneumyenyasu09) {
        ztymvanoneumyenyasu09 = pZtymvanoneumyenyasu09;
    }

    private String ztymvanonevtuktype09;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVANONEVTUKTYPE09)
    public String getZtymvanonevtuktype09() {
        return ztymvanonevtuktype09;
    }

    public void setZtymvanonevtuktype09(String pZtymvanonevtuktype09) {
        ztymvanonevtuktype09 = pZtymvanonevtuktype09;
    }

    private String ztymvanonev09;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVANONEV09)
    public String getZtymvanonev09() {
        return ztymvanonev09;
    }

    public void setZtymvanonev09(String pZtymvanonev09) {
        ztymvanonev09 = pZtymvanonev09;
    }

    private String ztymvanonekaisiinnumukbn10;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVANONEKAISIINNUMUKBN10)
    public String getZtymvanonekaisiinnumukbn10() {
        return ztymvanonekaisiinnumukbn10;
    }

    public void setZtymvanonekaisiinnumukbn10(String pZtymvanonekaisiinnumukbn10) {
        ztymvanonekaisiinnumukbn10 = pZtymvanonekaisiinnumukbn10;
    }

    private String ztymvanonenenoutouym10;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVANONENENOUTOUYM10)
    public String getZtymvanonenenoutouym10() {
        return ztymvanonenenoutouym10;
    }

    public void setZtymvanonenenoutouym10(String pZtymvanonenenoutouym10) {
        ztymvanonenenoutouym10 = pZtymvanonenenoutouym10;
    }

    private String ztymvanonewtuktype10;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVANONEWTUKTYPE10)
    public String getZtymvanonewtuktype10() {
        return ztymvanonewtuktype10;
    }

    public void setZtymvanonewtuktype10(String pZtymvanonewtuktype10) {
        ztymvanonewtuktype10 = pZtymvanonewtuktype10;
    }

    private String ztymvanonew10;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVANONEW10)
    public String getZtymvanonew10() {
        return ztymvanonew10;
    }

    public void setZtymvanonew10(String pZtymvanonew10) {
        ztymvanonew10 = pZtymvanonew10;
    }

    private String ztymvanonewyentuktype10;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVANONEWYENTUKTYPE10)
    public String getZtymvanonewyentuktype10() {
        return ztymvanonewyentuktype10;
    }

    public void setZtymvanonewyentuktype10(String pZtymvanonewyentuktype10) {
        ztymvanonewyentuktype10 = pZtymvanonewyentuktype10;
    }

    private String ztymvanonewyendaka10;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVANONEWYENDAKA10)
    public String getZtymvanonewyendaka10() {
        return ztymvanonewyendaka10;
    }

    public void setZtymvanonewyendaka10(String pZtymvanonewyendaka10) {
        ztymvanonewyendaka10 = pZtymvanonewyendaka10;
    }

    private String ztymvanonewyenkijyun10;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVANONEWYENKIJYUN10)
    public String getZtymvanonewyenkijyun10() {
        return ztymvanonewyenkijyun10;
    }

    public void setZtymvanonewyenkijyun10(String pZtymvanonewyenkijyun10) {
        ztymvanonewyenkijyun10 = pZtymvanonewyenkijyun10;
    }

    private String ztymvanonewyenyasu10;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVANONEWYENYASU10)
    public String getZtymvanonewyenyasu10() {
        return ztymvanonewyenyasu10;
    }

    public void setZtymvanonewyenyasu10(String pZtymvanonewyenyasu10) {
        ztymvanonewyenyasu10 = pZtymvanonewyenyasu10;
    }

    private String ztymvanoneumyendaka10;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVANONEUMYENDAKA10)
    public String getZtymvanoneumyendaka10() {
        return ztymvanoneumyendaka10;
    }

    public void setZtymvanoneumyendaka10(String pZtymvanoneumyendaka10) {
        ztymvanoneumyendaka10 = pZtymvanoneumyendaka10;
    }

    private String ztymvanoneumyenkijyun10;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVANONEUMYENKIJYUN10)
    public String getZtymvanoneumyenkijyun10() {
        return ztymvanoneumyenkijyun10;
    }

    public void setZtymvanoneumyenkijyun10(String pZtymvanoneumyenkijyun10) {
        ztymvanoneumyenkijyun10 = pZtymvanoneumyenkijyun10;
    }

    private String ztymvanoneumyenyasu10;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVANONEUMYENYASU10)
    public String getZtymvanoneumyenyasu10() {
        return ztymvanoneumyenyasu10;
    }

    public void setZtymvanoneumyenyasu10(String pZtymvanoneumyenyasu10) {
        ztymvanoneumyenyasu10 = pZtymvanoneumyenyasu10;
    }

    private String ztymvanonevtuktype10;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVANONEVTUKTYPE10)
    public String getZtymvanonevtuktype10() {
        return ztymvanonevtuktype10;
    }

    public void setZtymvanonevtuktype10(String pZtymvanonevtuktype10) {
        ztymvanonevtuktype10 = pZtymvanonevtuktype10;
    }

    private String ztymvanonev10;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVANONEV10)
    public String getZtymvanonev10() {
        return ztymvanonev10;
    }

    public void setZtymvanonev10(String pZtymvanonev10) {
        ztymvanonev10 = pZtymvanonev10;
    }

    private String ztymvanonekaisiinnumukbn11;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVANONEKAISIINNUMUKBN11)
    public String getZtymvanonekaisiinnumukbn11() {
        return ztymvanonekaisiinnumukbn11;
    }

    public void setZtymvanonekaisiinnumukbn11(String pZtymvanonekaisiinnumukbn11) {
        ztymvanonekaisiinnumukbn11 = pZtymvanonekaisiinnumukbn11;
    }

    private String ztymvanonenenoutouym11;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVANONENENOUTOUYM11)
    public String getZtymvanonenenoutouym11() {
        return ztymvanonenenoutouym11;
    }

    public void setZtymvanonenenoutouym11(String pZtymvanonenenoutouym11) {
        ztymvanonenenoutouym11 = pZtymvanonenenoutouym11;
    }

    private String ztymvanonewtuktype11;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVANONEWTUKTYPE11)
    public String getZtymvanonewtuktype11() {
        return ztymvanonewtuktype11;
    }

    public void setZtymvanonewtuktype11(String pZtymvanonewtuktype11) {
        ztymvanonewtuktype11 = pZtymvanonewtuktype11;
    }

    private String ztymvanonew11;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVANONEW11)
    public String getZtymvanonew11() {
        return ztymvanonew11;
    }

    public void setZtymvanonew11(String pZtymvanonew11) {
        ztymvanonew11 = pZtymvanonew11;
    }

    private String ztymvanonewyentuktype11;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVANONEWYENTUKTYPE11)
    public String getZtymvanonewyentuktype11() {
        return ztymvanonewyentuktype11;
    }

    public void setZtymvanonewyentuktype11(String pZtymvanonewyentuktype11) {
        ztymvanonewyentuktype11 = pZtymvanonewyentuktype11;
    }

    private String ztymvanonewyendaka11;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVANONEWYENDAKA11)
    public String getZtymvanonewyendaka11() {
        return ztymvanonewyendaka11;
    }

    public void setZtymvanonewyendaka11(String pZtymvanonewyendaka11) {
        ztymvanonewyendaka11 = pZtymvanonewyendaka11;
    }

    private String ztymvanonewyenkijyun11;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVANONEWYENKIJYUN11)
    public String getZtymvanonewyenkijyun11() {
        return ztymvanonewyenkijyun11;
    }

    public void setZtymvanonewyenkijyun11(String pZtymvanonewyenkijyun11) {
        ztymvanonewyenkijyun11 = pZtymvanonewyenkijyun11;
    }

    private String ztymvanonewyenyasu11;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVANONEWYENYASU11)
    public String getZtymvanonewyenyasu11() {
        return ztymvanonewyenyasu11;
    }

    public void setZtymvanonewyenyasu11(String pZtymvanonewyenyasu11) {
        ztymvanonewyenyasu11 = pZtymvanonewyenyasu11;
    }

    private String ztymvanoneumyendaka11;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVANONEUMYENDAKA11)
    public String getZtymvanoneumyendaka11() {
        return ztymvanoneumyendaka11;
    }

    public void setZtymvanoneumyendaka11(String pZtymvanoneumyendaka11) {
        ztymvanoneumyendaka11 = pZtymvanoneumyendaka11;
    }

    private String ztymvanoneumyenkijyun11;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVANONEUMYENKIJYUN11)
    public String getZtymvanoneumyenkijyun11() {
        return ztymvanoneumyenkijyun11;
    }

    public void setZtymvanoneumyenkijyun11(String pZtymvanoneumyenkijyun11) {
        ztymvanoneumyenkijyun11 = pZtymvanoneumyenkijyun11;
    }

    private String ztymvanoneumyenyasu11;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVANONEUMYENYASU11)
    public String getZtymvanoneumyenyasu11() {
        return ztymvanoneumyenyasu11;
    }

    public void setZtymvanoneumyenyasu11(String pZtymvanoneumyenyasu11) {
        ztymvanoneumyenyasu11 = pZtymvanoneumyenyasu11;
    }

    private String ztymvanonevtuktype11;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVANONEVTUKTYPE11)
    public String getZtymvanonevtuktype11() {
        return ztymvanonevtuktype11;
    }

    public void setZtymvanonevtuktype11(String pZtymvanonevtuktype11) {
        ztymvanonevtuktype11 = pZtymvanonevtuktype11;
    }

    private String ztymvanonev11;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVANONEV11)
    public String getZtymvanonev11() {
        return ztymvanonev11;
    }

    public void setZtymvanonev11(String pZtymvanonev11) {
        ztymvanonev11 = pZtymvanonev11;
    }

    private String ztymvanonekaisiinnumukbn12;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVANONEKAISIINNUMUKBN12)
    public String getZtymvanonekaisiinnumukbn12() {
        return ztymvanonekaisiinnumukbn12;
    }

    public void setZtymvanonekaisiinnumukbn12(String pZtymvanonekaisiinnumukbn12) {
        ztymvanonekaisiinnumukbn12 = pZtymvanonekaisiinnumukbn12;
    }

    private String ztymvanonenenoutouym12;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVANONENENOUTOUYM12)
    public String getZtymvanonenenoutouym12() {
        return ztymvanonenenoutouym12;
    }

    public void setZtymvanonenenoutouym12(String pZtymvanonenenoutouym12) {
        ztymvanonenenoutouym12 = pZtymvanonenenoutouym12;
    }

    private String ztymvanonewtuktype12;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVANONEWTUKTYPE12)
    public String getZtymvanonewtuktype12() {
        return ztymvanonewtuktype12;
    }

    public void setZtymvanonewtuktype12(String pZtymvanonewtuktype12) {
        ztymvanonewtuktype12 = pZtymvanonewtuktype12;
    }

    private String ztymvanonew12;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVANONEW12)
    public String getZtymvanonew12() {
        return ztymvanonew12;
    }

    public void setZtymvanonew12(String pZtymvanonew12) {
        ztymvanonew12 = pZtymvanonew12;
    }

    private String ztymvanonewyentuktype12;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVANONEWYENTUKTYPE12)
    public String getZtymvanonewyentuktype12() {
        return ztymvanonewyentuktype12;
    }

    public void setZtymvanonewyentuktype12(String pZtymvanonewyentuktype12) {
        ztymvanonewyentuktype12 = pZtymvanonewyentuktype12;
    }

    private String ztymvanonewyendaka12;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVANONEWYENDAKA12)
    public String getZtymvanonewyendaka12() {
        return ztymvanonewyendaka12;
    }

    public void setZtymvanonewyendaka12(String pZtymvanonewyendaka12) {
        ztymvanonewyendaka12 = pZtymvanonewyendaka12;
    }

    private String ztymvanonewyenkijyun12;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVANONEWYENKIJYUN12)
    public String getZtymvanonewyenkijyun12() {
        return ztymvanonewyenkijyun12;
    }

    public void setZtymvanonewyenkijyun12(String pZtymvanonewyenkijyun12) {
        ztymvanonewyenkijyun12 = pZtymvanonewyenkijyun12;
    }

    private String ztymvanonewyenyasu12;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVANONEWYENYASU12)
    public String getZtymvanonewyenyasu12() {
        return ztymvanonewyenyasu12;
    }

    public void setZtymvanonewyenyasu12(String pZtymvanonewyenyasu12) {
        ztymvanonewyenyasu12 = pZtymvanonewyenyasu12;
    }

    private String ztymvanoneumyendaka12;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVANONEUMYENDAKA12)
    public String getZtymvanoneumyendaka12() {
        return ztymvanoneumyendaka12;
    }

    public void setZtymvanoneumyendaka12(String pZtymvanoneumyendaka12) {
        ztymvanoneumyendaka12 = pZtymvanoneumyendaka12;
    }

    private String ztymvanoneumyenkijyun12;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVANONEUMYENKIJYUN12)
    public String getZtymvanoneumyenkijyun12() {
        return ztymvanoneumyenkijyun12;
    }

    public void setZtymvanoneumyenkijyun12(String pZtymvanoneumyenkijyun12) {
        ztymvanoneumyenkijyun12 = pZtymvanoneumyenkijyun12;
    }

    private String ztymvanoneumyenyasu12;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVANONEUMYENYASU12)
    public String getZtymvanoneumyenyasu12() {
        return ztymvanoneumyenyasu12;
    }

    public void setZtymvanoneumyenyasu12(String pZtymvanoneumyenyasu12) {
        ztymvanoneumyenyasu12 = pZtymvanoneumyenyasu12;
    }

    private String ztymvanonevtuktype12;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVANONEVTUKTYPE12)
    public String getZtymvanonevtuktype12() {
        return ztymvanonevtuktype12;
    }

    public void setZtymvanonevtuktype12(String pZtymvanonevtuktype12) {
        ztymvanonevtuktype12 = pZtymvanonevtuktype12;
    }

    private String ztymvanonev12;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVANONEV12)
    public String getZtymvanonev12() {
        return ztymvanonev12;
    }

    public void setZtymvanonev12(String pZtymvanonev12) {
        ztymvanonev12 = pZtymvanonev12;
    }

    private String ztymvanonekaisiinnumukbn13;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVANONEKAISIINNUMUKBN13)
    public String getZtymvanonekaisiinnumukbn13() {
        return ztymvanonekaisiinnumukbn13;
    }

    public void setZtymvanonekaisiinnumukbn13(String pZtymvanonekaisiinnumukbn13) {
        ztymvanonekaisiinnumukbn13 = pZtymvanonekaisiinnumukbn13;
    }

    private String ztymvanonenenoutouym13;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVANONENENOUTOUYM13)
    public String getZtymvanonenenoutouym13() {
        return ztymvanonenenoutouym13;
    }

    public void setZtymvanonenenoutouym13(String pZtymvanonenenoutouym13) {
        ztymvanonenenoutouym13 = pZtymvanonenenoutouym13;
    }

    private String ztymvanonewtuktype13;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVANONEWTUKTYPE13)
    public String getZtymvanonewtuktype13() {
        return ztymvanonewtuktype13;
    }

    public void setZtymvanonewtuktype13(String pZtymvanonewtuktype13) {
        ztymvanonewtuktype13 = pZtymvanonewtuktype13;
    }

    private String ztymvanonew13;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVANONEW13)
    public String getZtymvanonew13() {
        return ztymvanonew13;
    }

    public void setZtymvanonew13(String pZtymvanonew13) {
        ztymvanonew13 = pZtymvanonew13;
    }

    private String ztymvanonewyentuktype13;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVANONEWYENTUKTYPE13)
    public String getZtymvanonewyentuktype13() {
        return ztymvanonewyentuktype13;
    }

    public void setZtymvanonewyentuktype13(String pZtymvanonewyentuktype13) {
        ztymvanonewyentuktype13 = pZtymvanonewyentuktype13;
    }

    private String ztymvanonewyendaka13;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVANONEWYENDAKA13)
    public String getZtymvanonewyendaka13() {
        return ztymvanonewyendaka13;
    }

    public void setZtymvanonewyendaka13(String pZtymvanonewyendaka13) {
        ztymvanonewyendaka13 = pZtymvanonewyendaka13;
    }

    private String ztymvanonewyenkijyun13;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVANONEWYENKIJYUN13)
    public String getZtymvanonewyenkijyun13() {
        return ztymvanonewyenkijyun13;
    }

    public void setZtymvanonewyenkijyun13(String pZtymvanonewyenkijyun13) {
        ztymvanonewyenkijyun13 = pZtymvanonewyenkijyun13;
    }

    private String ztymvanonewyenyasu13;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVANONEWYENYASU13)
    public String getZtymvanonewyenyasu13() {
        return ztymvanonewyenyasu13;
    }

    public void setZtymvanonewyenyasu13(String pZtymvanonewyenyasu13) {
        ztymvanonewyenyasu13 = pZtymvanonewyenyasu13;
    }

    private String ztymvanoneumyendaka13;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVANONEUMYENDAKA13)
    public String getZtymvanoneumyendaka13() {
        return ztymvanoneumyendaka13;
    }

    public void setZtymvanoneumyendaka13(String pZtymvanoneumyendaka13) {
        ztymvanoneumyendaka13 = pZtymvanoneumyendaka13;
    }

    private String ztymvanoneumyenkijyun13;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVANONEUMYENKIJYUN13)
    public String getZtymvanoneumyenkijyun13() {
        return ztymvanoneumyenkijyun13;
    }

    public void setZtymvanoneumyenkijyun13(String pZtymvanoneumyenkijyun13) {
        ztymvanoneumyenkijyun13 = pZtymvanoneumyenkijyun13;
    }

    private String ztymvanoneumyenyasu13;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVANONEUMYENYASU13)
    public String getZtymvanoneumyenyasu13() {
        return ztymvanoneumyenyasu13;
    }

    public void setZtymvanoneumyenyasu13(String pZtymvanoneumyenyasu13) {
        ztymvanoneumyenyasu13 = pZtymvanoneumyenyasu13;
    }

    private String ztymvanonevtuktype13;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVANONEVTUKTYPE13)
    public String getZtymvanonevtuktype13() {
        return ztymvanonevtuktype13;
    }

    public void setZtymvanonevtuktype13(String pZtymvanonevtuktype13) {
        ztymvanonevtuktype13 = pZtymvanonevtuktype13;
    }

    private String ztymvanonev13;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVANONEV13)
    public String getZtymvanonev13() {
        return ztymvanonev13;
    }

    public void setZtymvanonev13(String pZtymvanonev13) {
        ztymvanonev13 = pZtymvanonev13;
    }

    private String ztymvanonekaisiinnumukbn14;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVANONEKAISIINNUMUKBN14)
    public String getZtymvanonekaisiinnumukbn14() {
        return ztymvanonekaisiinnumukbn14;
    }

    public void setZtymvanonekaisiinnumukbn14(String pZtymvanonekaisiinnumukbn14) {
        ztymvanonekaisiinnumukbn14 = pZtymvanonekaisiinnumukbn14;
    }

    private String ztymvanonenenoutouym14;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVANONENENOUTOUYM14)
    public String getZtymvanonenenoutouym14() {
        return ztymvanonenenoutouym14;
    }

    public void setZtymvanonenenoutouym14(String pZtymvanonenenoutouym14) {
        ztymvanonenenoutouym14 = pZtymvanonenenoutouym14;
    }

    private String ztymvanonewtuktype14;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVANONEWTUKTYPE14)
    public String getZtymvanonewtuktype14() {
        return ztymvanonewtuktype14;
    }

    public void setZtymvanonewtuktype14(String pZtymvanonewtuktype14) {
        ztymvanonewtuktype14 = pZtymvanonewtuktype14;
    }

    private String ztymvanonew14;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVANONEW14)
    public String getZtymvanonew14() {
        return ztymvanonew14;
    }

    public void setZtymvanonew14(String pZtymvanonew14) {
        ztymvanonew14 = pZtymvanonew14;
    }

    private String ztymvanonewyentuktype14;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVANONEWYENTUKTYPE14)
    public String getZtymvanonewyentuktype14() {
        return ztymvanonewyentuktype14;
    }

    public void setZtymvanonewyentuktype14(String pZtymvanonewyentuktype14) {
        ztymvanonewyentuktype14 = pZtymvanonewyentuktype14;
    }

    private String ztymvanonewyendaka14;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVANONEWYENDAKA14)
    public String getZtymvanonewyendaka14() {
        return ztymvanonewyendaka14;
    }

    public void setZtymvanonewyendaka14(String pZtymvanonewyendaka14) {
        ztymvanonewyendaka14 = pZtymvanonewyendaka14;
    }

    private String ztymvanonewyenkijyun14;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVANONEWYENKIJYUN14)
    public String getZtymvanonewyenkijyun14() {
        return ztymvanonewyenkijyun14;
    }

    public void setZtymvanonewyenkijyun14(String pZtymvanonewyenkijyun14) {
        ztymvanonewyenkijyun14 = pZtymvanonewyenkijyun14;
    }

    private String ztymvanonewyenyasu14;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVANONEWYENYASU14)
    public String getZtymvanonewyenyasu14() {
        return ztymvanonewyenyasu14;
    }

    public void setZtymvanonewyenyasu14(String pZtymvanonewyenyasu14) {
        ztymvanonewyenyasu14 = pZtymvanonewyenyasu14;
    }

    private String ztymvanoneumyendaka14;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVANONEUMYENDAKA14)
    public String getZtymvanoneumyendaka14() {
        return ztymvanoneumyendaka14;
    }

    public void setZtymvanoneumyendaka14(String pZtymvanoneumyendaka14) {
        ztymvanoneumyendaka14 = pZtymvanoneumyendaka14;
    }

    private String ztymvanoneumyenkijyun14;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVANONEUMYENKIJYUN14)
    public String getZtymvanoneumyenkijyun14() {
        return ztymvanoneumyenkijyun14;
    }

    public void setZtymvanoneumyenkijyun14(String pZtymvanoneumyenkijyun14) {
        ztymvanoneumyenkijyun14 = pZtymvanoneumyenkijyun14;
    }

    private String ztymvanoneumyenyasu14;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVANONEUMYENYASU14)
    public String getZtymvanoneumyenyasu14() {
        return ztymvanoneumyenyasu14;
    }

    public void setZtymvanoneumyenyasu14(String pZtymvanoneumyenyasu14) {
        ztymvanoneumyenyasu14 = pZtymvanoneumyenyasu14;
    }

    private String ztymvanonevtuktype14;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVANONEVTUKTYPE14)
    public String getZtymvanonevtuktype14() {
        return ztymvanonevtuktype14;
    }

    public void setZtymvanonevtuktype14(String pZtymvanonevtuktype14) {
        ztymvanonevtuktype14 = pZtymvanonevtuktype14;
    }

    private String ztymvanonev14;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYMVANONEV14)
    public String getZtymvanonev14() {
        return ztymvanonev14;
    }

    public void setZtymvanonev14(String pZtymvanonev14) {
        ztymvanonev14 = pZtymvanonev14;
    }

    private String ztywmsgcd1;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYWMSGCD1)
    public String getZtywmsgcd1() {
        return ztywmsgcd1;
    }

    public void setZtywmsgcd1(String pZtywmsgcd1) {
        ztywmsgcd1 = pZtywmsgcd1;
    }

    private String ztywmsgcd2;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYWMSGCD2)
    public String getZtywmsgcd2() {
        return ztywmsgcd2;
    }

    public void setZtywmsgcd2(String pZtywmsgcd2) {
        ztywmsgcd2 = pZtywmsgcd2;
    }

    private String ztywmsgcd3;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYWMSGCD3)
    public String getZtywmsgcd3() {
        return ztywmsgcd3;
    }

    public void setZtywmsgcd3(String pZtywmsgcd3) {
        ztywmsgcd3 = pZtywmsgcd3;
    }

    private String ztywmsgcd21;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYWMSGCD21)
    public String getZtywmsgcd21() {
        return ztywmsgcd21;
    }

    public void setZtywmsgcd21(String pZtywmsgcd21) {
        ztywmsgcd21 = pZtywmsgcd21;
    }

    private String ztywmsgcd22;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYWMSGCD22)
    public String getZtywmsgcd22() {
        return ztywmsgcd22;
    }

    public void setZtywmsgcd22(String pZtywmsgcd22) {
        ztywmsgcd22 = pZtywmsgcd22;
    }

    private String ztywmsgcd23;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYWMSGCD23)
    public String getZtywmsgcd23() {
        return ztywmsgcd23;
    }

    public void setZtywmsgcd23(String pZtywmsgcd23) {
        ztywmsgcd23 = pZtywmsgcd23;
    }

    private String ztywmsgcd31;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYWMSGCD31)
    public String getZtywmsgcd31() {
        return ztywmsgcd31;
    }

    public void setZtywmsgcd31(String pZtywmsgcd31) {
        ztywmsgcd31 = pZtywmsgcd31;
    }

    private String ztywmsgcd32;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYWMSGCD32)
    public String getZtywmsgcd32() {
        return ztywmsgcd32;
    }

    public void setZtywmsgcd32(String pZtywmsgcd32) {
        ztywmsgcd32 = pZtywmsgcd32;
    }

    private String ztywmsgcd33;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYWMSGCD33)
    public String getZtywmsgcd33() {
        return ztywmsgcd33;
    }

    public void setZtywmsgcd33(String pZtywmsgcd33) {
        ztywmsgcd33 = pZtywmsgcd33;
    }

    private String ztywmsgcdst1;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYWMSGCDST1)
    public String getZtywmsgcdst1() {
        return ztywmsgcdst1;
    }

    public void setZtywmsgcdst1(String pZtywmsgcdst1) {
        ztywmsgcdst1 = pZtywmsgcdst1;
    }

    private String ztywtyuuimsgcd1;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYWTYUUIMSGCD1)
    public String getZtywtyuuimsgcd1() {
        return ztywtyuuimsgcd1;
    }

    public void setZtywtyuuimsgcd1(String pZtywtyuuimsgcd1) {
        ztywtyuuimsgcd1 = pZtywtyuuimsgcd1;
    }

    private String ztywtyuuimsgcd2;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYWTYUUIMSGCD2)
    public String getZtywtyuuimsgcd2() {
        return ztywtyuuimsgcd2;
    }

    public void setZtywtyuuimsgcd2(String pZtywtyuuimsgcd2) {
        ztywtyuuimsgcd2 = pZtywtyuuimsgcd2;
    }

    private String ztywtyuuimsgcd3;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYWTYUUIMSGCD3)
    public String getZtywtyuuimsgcd3() {
        return ztywtyuuimsgcd3;
    }

    public void setZtywtyuuimsgcd3(String pZtywtyuuimsgcd3) {
        ztywtyuuimsgcd3 = pZtywtyuuimsgcd3;
    }

    private String ztywtyuuimsgcd4;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYWTYUUIMSGCD4)
    public String getZtywtyuuimsgcd4() {
        return ztywtyuuimsgcd4;
    }

    public void setZtywtyuuimsgcd4(String pZtywtyuuimsgcd4) {
        ztywtyuuimsgcd4 = pZtywtyuuimsgcd4;
    }

    private String ztywtyuuimsgcd5;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYWTYUUIMSGCD5)
    public String getZtywtyuuimsgcd5() {
        return ztywtyuuimsgcd5;
    }

    public void setZtywtyuuimsgcd5(String pZtywtyuuimsgcd5) {
        ztywtyuuimsgcd5 = pZtywtyuuimsgcd5;
    }

    private String ztywtyuuimsgcd6;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYWTYUUIMSGCD6)
    public String getZtywtyuuimsgcd6() {
        return ztywtyuuimsgcd6;
    }

    public void setZtywtyuuimsgcd6(String pZtywtyuuimsgcd6) {
        ztywtyuuimsgcd6 = pZtywtyuuimsgcd6;
    }

    private String ztywtyuuimsgcd7;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYWTYUUIMSGCD7)
    public String getZtywtyuuimsgcd7() {
        return ztywtyuuimsgcd7;
    }

    public void setZtywtyuuimsgcd7(String pZtywtyuuimsgcd7) {
        ztywtyuuimsgcd7 = pZtywtyuuimsgcd7;
    }

    private String ztywitjbrptuuktype;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYWITJBRPTUUKTYPE)
    public String getZtywitjbrptuuktype() {
        return ztywitjbrptuuktype;
    }

    public void setZtywitjbrptuuktype(String pZtywitjbrptuuktype) {
        ztywitjbrptuuktype = pZtywitjbrptuuktype;
    }

    private String ztywitjbrp;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYWITJBRP)
    public String getZtywitjbrp() {
        return ztywitjbrp;
    }

    public void setZtywitjbrp(String pZtywitjbrp) {
        ztywitjbrp = pZtywitjbrp;
    }

    private String ztywyenhrikmgktuuktype;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYWYENHRIKMGKTUUKTYPE)
    public String getZtywyenhrikmgktuuktype() {
        return ztywyenhrikmgktuuktype;
    }

    public void setZtywyenhrikmgktuuktype(String pZtywyenhrikmgktuuktype) {
        ztywyenhrikmgktuuktype = pZtywyenhrikmgktuuktype;
    }

    private String ztywyenhrikmgk;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYWYENHRIKMGK)
    public String getZtywyenhrikmgk() {
        return ztywyenhrikmgk;
    }

    public void setZtywyenhrikmgk(String pZtywyenhrikmgk) {
        ztywyenhrikmgk = pZtywyenhrikmgk;
    }

    private String ztywyenitjbrptuuktype;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYWYENITJBRPTUUKTYPE)
    public String getZtywyenitjbrptuuktype() {
        return ztywyenitjbrptuuktype;
    }

    public void setZtywyenitjbrptuuktype(String pZtywyenitjbrptuuktype) {
        ztywyenitjbrptuuktype = pZtywyenitjbrptuuktype;
    }

    private String ztywyenitjbrp;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYWYENITJBRP)
    public String getZtywyenitjbrp() {
        return ztywyenitjbrp;
    }

    public void setZtywyenitjbrp(String pZtywyenitjbrp) {
        ztywyenitjbrp = pZtywyenitjbrp;
    }

    private String ztywsjkkktyouseitkyuym;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYWSJKKKTYOUSEITKYUYM)
    public String getZtywsjkkktyouseitkyuym() {
        return ztywsjkkktyouseitkyuym;
    }

    public void setZtywsjkkktyouseitkyuym(String pZtywsjkkktyouseitkyuym) {
        ztywsjkkktyouseitkyuym = pZtywsjkkktyouseitkyuym;
    }

    private String ztyhrkkknmnryym;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYHRKKKNMNRYYM)
    public String getZtyhrkkknmnryym() {
        return ztyhrkkknmnryym;
    }

    public void setZtyhrkkknmnryym(String pZtyhrkkknmnryym) {
        ztyhrkkknmnryym = pZtyhrkkknmnryym;
    }

    private String ztyhrkkknmnrynen;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYHRKKKNMNRYNEN)
    public String getZtyhrkkknmnrynen() {
        return ztyhrkkknmnrynen;
    }

    public void setZtyhrkkknmnrynen(String pZtyhrkkknmnrynen) {
        ztyhrkkknmnrynen = pZtyhrkkknmnrynen;
    }

    private String ztyyobiv200;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYYOBIV200)
    public String getZtyyobiv200() {
        return ztyyobiv200;
    }

    public void setZtyyobiv200(String pZtyyobiv200) {
        ztyyobiv200 = pZtyyobiv200;
    }

    private String ztyyobiv49;

    @Column(name=GenZT_SaihakkouSyoukenSuiiTy.ZTYYOBIV49)
    public String getZtyyobiv49() {
        return ztyyobiv49;
    }

    public void setZtyyobiv49(String pZtyyobiv49) {
        ztyyobiv49 = pZtyyobiv49;
    }
}