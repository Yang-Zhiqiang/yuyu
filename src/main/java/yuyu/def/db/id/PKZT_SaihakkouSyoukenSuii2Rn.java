package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.Padding;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.ZT_SaihakkouSyoukenSuii2Rn;
import yuyu.def.db.mapping.GenZT_SaihakkouSyoukenSuii2Rn;
import yuyu.def.db.meta.GenQZT_SaihakkouSyoukenSuii2Rn;
import yuyu.def.db.meta.QZT_SaihakkouSyoukenSuii2Rn;

/**
 * 再発行保険証券推移表Ｆテーブル２（連） のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_SaihakkouSyoukenSuii2Rn}</td><td colspan="3">再発行保険証券推移表Ｆテーブル２（連）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getZrnsyono zrnsyono}</td><td>（連携用）証券番号</td><td align="center">○</td><td align="center">C</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZrntyouhyouymd zrntyouhyouymd}</td><td>（連携用）帳票作成日</td><td align="center">○</td><td align="center">C</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZrnsuiihyouptn zrnsuiihyouptn}</td><td>（連携用）推移表パターン</td><td align="center">○</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsuiihyousykbn</td><td>（連携用）推移表種別区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsuiihyousyono</td><td>（連携用）推移表証券番号</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnytirrtcalckijyunrrt</td><td>（連携用）予定利率計算基準利率</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnwkwsrateyendaka</td><td>（連携用）解約返戻金為替レート（円高）</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnwkwsrateyenkijyun</td><td>（連携用）解約返戻金為替レート（中央値）</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnwkwsrateyenyasu</td><td>（連携用）解約返戻金為替レート（円安）</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkyktuukatype</td><td>（連携用）契約通貨タイプ</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnenoutouym01</td><td>（連携用）年単位応当年月０１</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnhrkkknmnryumukbn01</td><td>（連携用）払込期間満了有無区分０１</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnzennouzndkyen01</td><td>（連携用）前納残高（円貨）０１</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnzennouzndkgaika01</td><td>（連携用）前納残高０１</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnyenhrkgkgoukei01</td><td>（連携用）円貨払込額の合計（円貨）０１</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkihrkmp01</td><td>（連携用）既払込保険料０１</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnw01</td><td>（連携用）解約返戻金０１</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnwyenyendaka01</td><td>（連携用）解約返戻金（円貨）円高０１</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnwyenkijun01</td><td>（連携用）解約返戻金（円貨）中央値０１</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnwyenyenyasu01</td><td>（連携用）解約返戻金（円貨）円安０１</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkaiykuktgk01</td><td>（連携用）解約時受取額０１</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkaiykuktgkyenyendaka01</td><td>（連携用）解約時受取額（円貨）円高０１</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkaiykuktgkyenkijun01</td><td>（連携用）解約時受取額（円貨）中央値０１</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkaiykuktgkyenyenyasu01</td><td>（連携用）解約時受取額（円貨）円安０１</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnenoutouym02</td><td>（連携用）年単位応当年月０２</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnhrkkknmnryumukbn02</td><td>（連携用）払込期間満了有無区分０２</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnzennouzndkyen02</td><td>（連携用）前納残高（円貨）０２</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnzennouzndkgaika02</td><td>（連携用）前納残高０２</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnyenhrkgkgoukei02</td><td>（連携用）円貨払込額の合計（円貨）０２</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkihrkmp02</td><td>（連携用）既払込保険料０２</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnw02</td><td>（連携用）解約返戻金０２</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnwyenyendaka02</td><td>（連携用）解約返戻金（円貨）円高０２</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnwyenkijun02</td><td>（連携用）解約返戻金（円貨）中央値０２</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnwyenyenyasu02</td><td>（連携用）解約返戻金（円貨）円安０２</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkaiykuktgk02</td><td>（連携用）解約時受取額０２</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkaiykuktgkyenyendaka02</td><td>（連携用）解約時受取額（円貨）円高０２</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkaiykuktgkyenkijun02</td><td>（連携用）解約時受取額（円貨）中央値０２</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkaiykuktgkyenyenyasu02</td><td>（連携用）解約時受取額（円貨）円安０２</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnenoutouym03</td><td>（連携用）年単位応当年月０３</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnhrkkknmnryumukbn03</td><td>（連携用）払込期間満了有無区分０３</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnzennouzndkyen03</td><td>（連携用）前納残高（円貨）０３</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnzennouzndkgaika03</td><td>（連携用）前納残高０３</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnyenhrkgkgoukei03</td><td>（連携用）円貨払込額の合計（円貨）０３</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkihrkmp03</td><td>（連携用）既払込保険料０３</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnw03</td><td>（連携用）解約返戻金０３</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnwyenyendaka03</td><td>（連携用）解約返戻金（円貨）円高０３</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnwyenkijun03</td><td>（連携用）解約返戻金（円貨）中央値０３</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnwyenyenyasu03</td><td>（連携用）解約返戻金（円貨）円安０３</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkaiykuktgk03</td><td>（連携用）解約時受取額０３</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkaiykuktgkyenyendaka03</td><td>（連携用）解約時受取額（円貨）円高０３</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkaiykuktgkyenkijun03</td><td>（連携用）解約時受取額（円貨）中央値０３</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkaiykuktgkyenyenyasu03</td><td>（連携用）解約時受取額（円貨）円安０３</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnenoutouym04</td><td>（連携用）年単位応当年月０４</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnhrkkknmnryumukbn04</td><td>（連携用）払込期間満了有無区分０４</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnzennouzndkyen04</td><td>（連携用）前納残高（円貨）０４</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnzennouzndkgaika04</td><td>（連携用）前納残高０４</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnyenhrkgkgoukei04</td><td>（連携用）円貨払込額の合計（円貨）０４</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkihrkmp04</td><td>（連携用）既払込保険料０４</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnw04</td><td>（連携用）解約返戻金０４</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnwyenyendaka04</td><td>（連携用）解約返戻金（円貨）円高０４</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnwyenkijun04</td><td>（連携用）解約返戻金（円貨）中央値０４</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnwyenyenyasu04</td><td>（連携用）解約返戻金（円貨）円安０４</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkaiykuktgk04</td><td>（連携用）解約時受取額０４</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkaiykuktgkyenyendaka04</td><td>（連携用）解約時受取額（円貨）円高０４</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkaiykuktgkyenkijun04</td><td>（連携用）解約時受取額（円貨）中央値０４</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkaiykuktgkyenyenyasu04</td><td>（連携用）解約時受取額（円貨）円安０４</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnenoutouym05</td><td>（連携用）年単位応当年月０５</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnhrkkknmnryumukbn05</td><td>（連携用）払込期間満了有無区分０５</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnzennouzndkyen05</td><td>（連携用）前納残高（円貨）０５</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnzennouzndkgaika05</td><td>（連携用）前納残高０５</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnyenhrkgkgoukei05</td><td>（連携用）円貨払込額の合計（円貨）０５</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkihrkmp05</td><td>（連携用）既払込保険料０５</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnw05</td><td>（連携用）解約返戻金０５</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnwyenyendaka05</td><td>（連携用）解約返戻金（円貨）円高０５</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnwyenkijun05</td><td>（連携用）解約返戻金（円貨）中央値０５</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnwyenyenyasu05</td><td>（連携用）解約返戻金（円貨）円安０５</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkaiykuktgk05</td><td>（連携用）解約時受取額０５</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkaiykuktgkyenyendaka05</td><td>（連携用）解約時受取額（円貨）円高０５</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkaiykuktgkyenkijun05</td><td>（連携用）解約時受取額（円貨）中央値０５</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkaiykuktgkyenyenyasu05</td><td>（連携用）解約時受取額（円貨）円安０５</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnenoutouym06</td><td>（連携用）年単位応当年月０６</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnhrkkknmnryumukbn06</td><td>（連携用）払込期間満了有無区分０６</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnzennouzndkyen06</td><td>（連携用）前納残高（円貨）０６</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnzennouzndkgaika06</td><td>（連携用）前納残高０６</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnyenhrkgkgoukei06</td><td>（連携用）円貨払込額の合計（円貨）０６</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkihrkmp06</td><td>（連携用）既払込保険料０６</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnw06</td><td>（連携用）解約返戻金０６</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnwyenyendaka06</td><td>（連携用）解約返戻金（円貨）円高０６</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnwyenkijun06</td><td>（連携用）解約返戻金（円貨）中央値０６</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnwyenyenyasu06</td><td>（連携用）解約返戻金（円貨）円安０６</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkaiykuktgk06</td><td>（連携用）解約時受取額０６</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkaiykuktgkyenyendaka06</td><td>（連携用）解約時受取額（円貨）円高０６</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkaiykuktgkyenkijun06</td><td>（連携用）解約時受取額（円貨）中央値０６</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkaiykuktgkyenyenyasu06</td><td>（連携用）解約時受取額（円貨）円安０６</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnenoutouym07</td><td>（連携用）年単位応当年月０７</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnhrkkknmnryumukbn07</td><td>（連携用）払込期間満了有無区分０７</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnzennouzndkyen07</td><td>（連携用）前納残高（円貨）０７</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnzennouzndkgaika07</td><td>（連携用）前納残高０７</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnyenhrkgkgoukei07</td><td>（連携用）円貨払込額の合計（円貨）０７</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkihrkmp07</td><td>（連携用）既払込保険料０７</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnw07</td><td>（連携用）解約返戻金０７</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnwyenyendaka07</td><td>（連携用）解約返戻金（円貨）円高０７</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnwyenkijun07</td><td>（連携用）解約返戻金（円貨）中央値０７</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnwyenyenyasu07</td><td>（連携用）解約返戻金（円貨）円安０７</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkaiykuktgk07</td><td>（連携用）解約時受取額０７</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkaiykuktgkyenyendaka07</td><td>（連携用）解約時受取額（円貨）円高０７</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkaiykuktgkyenkijun07</td><td>（連携用）解約時受取額（円貨）中央値０７</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkaiykuktgkyenyenyasu07</td><td>（連携用）解約時受取額（円貨）円安０７</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnenoutouym08</td><td>（連携用）年単位応当年月０８</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnhrkkknmnryumukbn08</td><td>（連携用）払込期間満了有無区分０８</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnzennouzndkyen08</td><td>（連携用）前納残高（円貨）０８</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnzennouzndkgaika08</td><td>（連携用）前納残高０８</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnyenhrkgkgoukei08</td><td>（連携用）円貨払込額の合計（円貨）０８</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkihrkmp08</td><td>（連携用）既払込保険料０８</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnw08</td><td>（連携用）解約返戻金０８</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnwyenyendaka08</td><td>（連携用）解約返戻金（円貨）円高０８</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnwyenkijun08</td><td>（連携用）解約返戻金（円貨）中央値０８</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnwyenyenyasu08</td><td>（連携用）解約返戻金（円貨）円安０８</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkaiykuktgk08</td><td>（連携用）解約時受取額０８</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkaiykuktgkyenyendaka08</td><td>（連携用）解約時受取額（円貨）円高０８</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkaiykuktgkyenkijun08</td><td>（連携用）解約時受取額（円貨）中央値０８</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkaiykuktgkyenyenyasu08</td><td>（連携用）解約時受取額（円貨）円安０８</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnenoutouym09</td><td>（連携用）年単位応当年月０９</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnhrkkknmnryumukbn09</td><td>（連携用）払込期間満了有無区分０９</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnzennouzndkyen09</td><td>（連携用）前納残高（円貨）０９</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnzennouzndkgaika09</td><td>（連携用）前納残高０９</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnyenhrkgkgoukei09</td><td>（連携用）円貨払込額の合計（円貨）０９</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkihrkmp09</td><td>（連携用）既払込保険料０９</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnw09</td><td>（連携用）解約返戻金０９</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnwyenyendaka09</td><td>（連携用）解約返戻金（円貨）円高０９</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnwyenkijun09</td><td>（連携用）解約返戻金（円貨）中央値０９</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnwyenyenyasu09</td><td>（連携用）解約返戻金（円貨）円安０９</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkaiykuktgk09</td><td>（連携用）解約時受取額０９</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkaiykuktgkyenyendaka09</td><td>（連携用）解約時受取額（円貨）円高０９</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkaiykuktgkyenkijun09</td><td>（連携用）解約時受取額（円貨）中央値０９</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkaiykuktgkyenyenyasu09</td><td>（連携用）解約時受取額（円貨）円安０９</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnenoutouym10</td><td>（連携用）年単位応当年月１０</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnhrkkknmnryumukbn10</td><td>（連携用）払込期間満了有無区分１０</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnzennouzndkyen10</td><td>（連携用）前納残高（円貨）１０</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnzennouzndkgaika10</td><td>（連携用）前納残高１０</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnyenhrkgkgoukei10</td><td>（連携用）円貨払込額の合計（円貨）１０</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkihrkmp10</td><td>（連携用）既払込保険料１０</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnw10</td><td>（連携用）解約返戻金１０</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnwyenyendaka10</td><td>（連携用）解約返戻金（円貨）円高１０</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnwyenkijun10</td><td>（連携用）解約返戻金（円貨）中央値１０</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnwyenyenyasu10</td><td>（連携用）解約返戻金（円貨）円安１０</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkaiykuktgk10</td><td>（連携用）解約時受取額１０</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkaiykuktgkyenyendaka10</td><td>（連携用）解約時受取額（円貨）円高１０</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkaiykuktgkyenkijun10</td><td>（連携用）解約時受取額（円貨）中央値１０</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkaiykuktgkyenyenyasu10</td><td>（連携用）解約時受取額（円貨）円安１０</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnenoutouym11</td><td>（連携用）年単位応当年月１１</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnhrkkknmnryumukbn11</td><td>（連携用）払込期間満了有無区分１１</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnzennouzndkyen11</td><td>（連携用）前納残高（円貨）１１</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnzennouzndkgaika11</td><td>（連携用）前納残高１１</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnyenhrkgkgoukei11</td><td>（連携用）円貨払込額の合計（円貨）１１</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkihrkmp11</td><td>（連携用）既払込保険料１１</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnw11</td><td>（連携用）解約返戻金１１</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnwyenyendaka11</td><td>（連携用）解約返戻金（円貨）円高１１</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnwyenkijun11</td><td>（連携用）解約返戻金（円貨）中央値１１</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnwyenyenyasu11</td><td>（連携用）解約返戻金（円貨）円安１１</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkaiykuktgk11</td><td>（連携用）解約時受取額１１</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkaiykuktgkyenyendaka11</td><td>（連携用）解約時受取額（円貨）円高１１</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkaiykuktgkyenkijun11</td><td>（連携用）解約時受取額（円貨）中央値１１</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkaiykuktgkyenyenyasu11</td><td>（連携用）解約時受取額（円貨）円安１１</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnenoutouym12</td><td>（連携用）年単位応当年月１２</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnhrkkknmnryumukbn12</td><td>（連携用）払込期間満了有無区分１２</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnzennouzndkyen12</td><td>（連携用）前納残高（円貨）１２</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnzennouzndkgaika12</td><td>（連携用）前納残高１２</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnyenhrkgkgoukei12</td><td>（連携用）円貨払込額の合計（円貨）１２</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkihrkmp12</td><td>（連携用）既払込保険料１２</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnw12</td><td>（連携用）解約返戻金１２</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnwyenyendaka12</td><td>（連携用）解約返戻金（円貨）円高１２</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnwyenkijun12</td><td>（連携用）解約返戻金（円貨）中央値１２</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnwyenyenyasu12</td><td>（連携用）解約返戻金（円貨）円安１２</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkaiykuktgk12</td><td>（連携用）解約時受取額１２</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkaiykuktgkyenyendaka12</td><td>（連携用）解約時受取額（円貨）円高１２</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkaiykuktgkyenkijun12</td><td>（連携用）解約時受取額（円貨）中央値１２</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkaiykuktgkyenyenyasu12</td><td>（連携用）解約時受取額（円貨）円安１２</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnenoutouym13</td><td>（連携用）年単位応当年月１３</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnhrkkknmnryumukbn13</td><td>（連携用）払込期間満了有無区分１３</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnzennouzndkyen13</td><td>（連携用）前納残高（円貨）１３</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnzennouzndkgaika13</td><td>（連携用）前納残高１３</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnyenhrkgkgoukei13</td><td>（連携用）円貨払込額の合計（円貨）１３</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkihrkmp13</td><td>（連携用）既払込保険料１３</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnw13</td><td>（連携用）解約返戻金１３</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnwyenyendaka13</td><td>（連携用）解約返戻金（円貨）円高１３</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnwyenkijun13</td><td>（連携用）解約返戻金（円貨）中央値１３</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnwyenyenyasu13</td><td>（連携用）解約返戻金（円貨）円安１３</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkaiykuktgk13</td><td>（連携用）解約時受取額１３</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkaiykuktgkyenyendaka13</td><td>（連携用）解約時受取額（円貨）円高１３</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkaiykuktgkyenkijun13</td><td>（連携用）解約時受取額（円貨）中央値１３</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkaiykuktgkyenyenyasu13</td><td>（連携用）解約時受取額（円貨）円安１３</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnenoutouym14</td><td>（連携用）年単位応当年月１４</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnhrkkknmnryumukbn14</td><td>（連携用）払込期間満了有無区分１４</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnzennouzndkyen14</td><td>（連携用）前納残高（円貨）１４</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnzennouzndkgaika14</td><td>（連携用）前納残高１４</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnyenhrkgkgoukei14</td><td>（連携用）円貨払込額の合計（円貨）１４</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkihrkmp14</td><td>（連携用）既払込保険料１４</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnw14</td><td>（連携用）解約返戻金１４</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnwyenyendaka14</td><td>（連携用）解約返戻金（円貨）円高１４</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnwyenkijun14</td><td>（連携用）解約返戻金（円貨）中央値１４</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnwyenyenyasu14</td><td>（連携用）解約返戻金（円貨）円安１４</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkaiykuktgk14</td><td>（連携用）解約時受取額１４</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkaiykuktgkyenyendaka14</td><td>（連携用）解約時受取額（円貨）円高１４</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkaiykuktgkyenkijun14</td><td>（連携用）解約時受取額（円貨）中央値１４</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkaiykuktgkyenyenyasu14</td><td>（連携用）解約時受取額（円貨）円安１４</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnenoutouym15</td><td>（連携用）年単位応当年月１５</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnhrkkknmnryumukbn15</td><td>（連携用）払込期間満了有無区分１５</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnzennouzndkyen15</td><td>（連携用）前納残高（円貨）１５</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnzennouzndkgaika15</td><td>（連携用）前納残高１５</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnyenhrkgkgoukei15</td><td>（連携用）円貨払込額の合計（円貨）１５</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkihrkmp15</td><td>（連携用）既払込保険料１５</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnw15</td><td>（連携用）解約返戻金１５</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnwyenyendaka15</td><td>（連携用）解約返戻金（円貨）円高１５</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnwyenkijun15</td><td>（連携用）解約返戻金（円貨）中央値１５</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnwyenyenyasu15</td><td>（連携用）解約返戻金（円貨）円安１５</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkaiykuktgk15</td><td>（連携用）解約時受取額１５</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkaiykuktgkyenyendaka15</td><td>（連携用）解約時受取額（円貨）円高１５</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkaiykuktgkyenkijun15</td><td>（連携用）解約時受取額（円貨）中央値１５</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkaiykuktgkyenyenyasu15</td><td>（連携用）解約時受取額（円貨）円安１５</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnenoutouym16</td><td>（連携用）年単位応当年月１６</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnhrkkknmnryumukbn16</td><td>（連携用）払込期間満了有無区分１６</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnzennouzndkyen16</td><td>（連携用）前納残高（円貨）１６</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnzennouzndkgaika16</td><td>（連携用）前納残高１６</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnyenhrkgkgoukei16</td><td>（連携用）円貨払込額の合計（円貨）１６</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkihrkmp16</td><td>（連携用）既払込保険料１６</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnw16</td><td>（連携用）解約返戻金１６</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnwyenyendaka16</td><td>（連携用）解約返戻金（円貨）円高１６</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnwyenkijun16</td><td>（連携用）解約返戻金（円貨）中央値１６</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnwyenyenyasu16</td><td>（連携用）解約返戻金（円貨）円安１６</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkaiykuktgk16</td><td>（連携用）解約時受取額１６</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkaiykuktgkyenyendaka16</td><td>（連携用）解約時受取額（円貨）円高１６</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkaiykuktgkyenkijun16</td><td>（連携用）解約時受取額（円貨）中央値１６</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkaiykuktgkyenyenyasu16</td><td>（連携用）解約時受取額（円貨）円安１６</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnenoutouym17</td><td>（連携用）年単位応当年月１７</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnhrkkknmnryumukbn17</td><td>（連携用）払込期間満了有無区分１７</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnzennouzndkyen17</td><td>（連携用）前納残高（円貨）１７</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnzennouzndkgaika17</td><td>（連携用）前納残高１７</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnyenhrkgkgoukei17</td><td>（連携用）円貨払込額の合計（円貨）１７</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkihrkmp17</td><td>（連携用）既払込保険料１７</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnw17</td><td>（連携用）解約返戻金１７</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnwyenyendaka17</td><td>（連携用）解約返戻金（円貨）円高１７</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnwyenkijun17</td><td>（連携用）解約返戻金（円貨）中央値１７</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnwyenyenyasu17</td><td>（連携用）解約返戻金（円貨）円安１７</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkaiykuktgk17</td><td>（連携用）解約時受取額１７</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkaiykuktgkyenyendaka17</td><td>（連携用）解約時受取額（円貨）円高１７</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkaiykuktgkyenkijun17</td><td>（連携用）解約時受取額（円貨）中央値１７</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkaiykuktgkyenyenyasu17</td><td>（連携用）解約時受取額（円貨）円安１７</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnenoutouym18</td><td>（連携用）年単位応当年月１８</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnhrkkknmnryumukbn18</td><td>（連携用）払込期間満了有無区分１８</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnzennouzndkyen18</td><td>（連携用）前納残高（円貨）１８</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnzennouzndkgaika18</td><td>（連携用）前納残高１８</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnyenhrkgkgoukei18</td><td>（連携用）円貨払込額の合計（円貨）１８</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkihrkmp18</td><td>（連携用）既払込保険料１８</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnw18</td><td>（連携用）解約返戻金１８</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnwyenyendaka18</td><td>（連携用）解約返戻金（円貨）円高１８</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnwyenkijun18</td><td>（連携用）解約返戻金（円貨）中央値１８</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnwyenyenyasu18</td><td>（連携用）解約返戻金（円貨）円安１８</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkaiykuktgk18</td><td>（連携用）解約時受取額１８</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkaiykuktgkyenyendaka18</td><td>（連携用）解約時受取額（円貨）円高１８</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkaiykuktgkyenkijun18</td><td>（連携用）解約時受取額（円貨）中央値１８</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkaiykuktgkyenyenyasu18</td><td>（連携用）解約時受取額（円貨）円安１８</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnenoutouym19</td><td>（連携用）年単位応当年月１９</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnhrkkknmnryumukbn19</td><td>（連携用）払込期間満了有無区分１９</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnzennouzndkyen19</td><td>（連携用）前納残高（円貨）１９</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnzennouzndkgaika19</td><td>（連携用）前納残高１９</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnyenhrkgkgoukei19</td><td>（連携用）円貨払込額の合計（円貨）１９</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkihrkmp19</td><td>（連携用）既払込保険料１９</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnw19</td><td>（連携用）解約返戻金１９</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnwyenyendaka19</td><td>（連携用）解約返戻金（円貨）円高１９</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnwyenkijun19</td><td>（連携用）解約返戻金（円貨）中央値１９</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnwyenyenyasu19</td><td>（連携用）解約返戻金（円貨）円安１９</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkaiykuktgk19</td><td>（連携用）解約時受取額１９</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkaiykuktgkyenyendaka19</td><td>（連携用）解約時受取額（円貨）円高１９</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkaiykuktgkyenkijun19</td><td>（連携用）解約時受取額（円貨）中央値１９</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkaiykuktgkyenyenyasu19</td><td>（連携用）解約時受取額（円貨）円安１９</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnenoutouym20</td><td>（連携用）年単位応当年月２０</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnhrkkknmnryumukbn20</td><td>（連携用）払込期間満了有無区分２０</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnzennouzndkyen20</td><td>（連携用）前納残高（円貨）２０</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnzennouzndkgaika20</td><td>（連携用）前納残高２０</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnyenhrkgkgoukei20</td><td>（連携用）円貨払込額の合計（円貨）２０</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkihrkmp20</td><td>（連携用）既払込保険料２０</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnw20</td><td>（連携用）解約返戻金２０</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnwyenyendaka20</td><td>（連携用）解約返戻金（円貨）円高２０</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnwyenkijun20</td><td>（連携用）解約返戻金（円貨）中央値２０</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnwyenyenyasu20</td><td>（連携用）解約返戻金（円貨）円安２０</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkaiykuktgk20</td><td>（連携用）解約時受取額２０</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkaiykuktgkyenyendaka20</td><td>（連携用）解約時受取額（円貨）円高２０</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkaiykuktgkyenkijun20</td><td>（連携用）解約時受取額（円貨）中央値２０</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkaiykuktgkyenyenyasu20</td><td>（連携用）解約時受取額（円貨）円安２０</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnenoutouym21</td><td>（連携用）年単位応当年月２１</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnhrkkknmnryumukbn21</td><td>（連携用）払込期間満了有無区分２１</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnzennouzndkyen21</td><td>（連携用）前納残高（円貨）２１</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnzennouzndkgaika21</td><td>（連携用）前納残高２１</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnyenhrkgkgoukei21</td><td>（連携用）円貨払込額の合計（円貨）２１</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkihrkmp21</td><td>（連携用）既払込保険料２１</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnw21</td><td>（連携用）解約返戻金２１</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnwyenyendaka21</td><td>（連携用）解約返戻金（円貨）円高２１</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnwyenkijun21</td><td>（連携用）解約返戻金（円貨）中央値２１</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnwyenyenyasu21</td><td>（連携用）解約返戻金（円貨）円安２１</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkaiykuktgk21</td><td>（連携用）解約時受取額２１</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkaiykuktgkyenyendaka21</td><td>（連携用）解約時受取額（円貨）円高２１</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkaiykuktgkyenkijun21</td><td>（連携用）解約時受取額（円貨）中央値２１</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkaiykuktgkyenyenyasu21</td><td>（連携用）解約時受取額（円貨）円安２１</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnenoutouym22</td><td>（連携用）年単位応当年月２２</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnhrkkknmnryumukbn22</td><td>（連携用）払込期間満了有無区分２２</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnzennouzndkyen22</td><td>（連携用）前納残高（円貨）２２</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnzennouzndkgaika22</td><td>（連携用）前納残高２２</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnyenhrkgkgoukei22</td><td>（連携用）円貨払込額の合計（円貨）２２</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkihrkmp22</td><td>（連携用）既払込保険料２２</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnw22</td><td>（連携用）解約返戻金２２</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnwyenyendaka22</td><td>（連携用）解約返戻金（円貨）円高２２</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnwyenkijun22</td><td>（連携用）解約返戻金（円貨）中央値２２</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnwyenyenyasu22</td><td>（連携用）解約返戻金（円貨）円安２２</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkaiykuktgk22</td><td>（連携用）解約時受取額２２</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkaiykuktgkyenyendaka22</td><td>（連携用）解約時受取額（円貨）円高２２</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkaiykuktgkyenkijun22</td><td>（連携用）解約時受取額（円貨）中央値２２</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkaiykuktgkyenyenyasu22</td><td>（連携用）解約時受取額（円貨）円安２２</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnyobiv210</td><td>（連携用）予備項目Ｖ２１０</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnyobiv98</td><td>（連携用）予備項目Ｖ９８</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnyobiv14</td><td>（連携用）予備項目Ｖ１４</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 * </table>
 * @see     ZT_SaihakkouSyoukenSuii2Rn
 * @see     GenZT_SaihakkouSyoukenSuii2Rn
 * @see     QZT_SaihakkouSyoukenSuii2Rn
 * @see     GenQZT_SaihakkouSyoukenSuii2Rn
 */
public class PKZT_SaihakkouSyoukenSuii2Rn extends AbstractExDBPrimaryKey<ZT_SaihakkouSyoukenSuii2Rn, PKZT_SaihakkouSyoukenSuii2Rn> {

    private static final long serialVersionUID = 1L;

    public PKZT_SaihakkouSyoukenSuii2Rn() {
    }

    public PKZT_SaihakkouSyoukenSuii2Rn(
        String pZrnsyono,
        String pZrntyouhyouymd,
        String pZrnsuiihyouptn
    ) {
        zrnsyono = pZrnsyono;
        zrntyouhyouymd = pZrntyouhyouymd;
        zrnsuiihyouptn = pZrnsuiihyouptn;
    }

    @Transient
    @Override
    public Class<ZT_SaihakkouSyoukenSuii2Rn> getEntityClass() {
        return ZT_SaihakkouSyoukenSuii2Rn.class;
    }

    private String zrnsyono;

    public String getZrnsyono() {
        return zrnsyono;
    }

    public void setZrnsyono(String pZrnsyono) {
        zrnsyono = pZrnsyono;
    }
    private String zrntyouhyouymd;

    public String getZrntyouhyouymd() {
        return zrntyouhyouymd;
    }

    public void setZrntyouhyouymd(String pZrntyouhyouymd) {
        zrntyouhyouymd = pZrntyouhyouymd;
    }
    private String zrnsuiihyouptn;

    public String getZrnsuiihyouptn() {
        return zrnsuiihyouptn;
    }

    public void setZrnsuiihyouptn(String pZrnsuiihyouptn) {
        zrnsuiihyouptn = pZrnsuiihyouptn;
    }

}