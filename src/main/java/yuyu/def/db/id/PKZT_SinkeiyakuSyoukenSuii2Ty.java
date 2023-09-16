package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.ZT_SinkeiyakuSyoukenSuii2Ty;
import yuyu.def.db.mapping.GenZT_SinkeiyakuSyoukenSuii2Ty;
import yuyu.def.db.meta.GenQZT_SinkeiyakuSyoukenSuii2Ty;
import yuyu.def.db.meta.QZT_SinkeiyakuSyoukenSuii2Ty;

/**
 * 新契約保険証券推移表Ｆテーブル２（中） のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_SinkeiyakuSyoukenSuii2Ty}</td><td colspan="3">新契約保険証券推移表Ｆテーブル２（中）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getZtysyono ztysyono}</td><td>（中継用）証券番号</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZtytyouhyouymd ztytyouhyouymd}</td><td>（中継用）帳票作成日</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZtysuiihyouptn ztysuiihyouptn}</td><td>（中継用）推移表パターン</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysuiihyousykbn</td><td>（中継用）推移表種別区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysuiihyousyono</td><td>（中継用）推移表証券番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyytirrtcalckijyunrrt</td><td>（中継用）予定利率計算基準利率</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztywkwsrateyendaka</td><td>（中継用）解約返戻金為替レート（円高）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztywkwsrateyenkijyun</td><td>（中継用）解約返戻金為替レート（中央値）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztywkwsrateyenyasu</td><td>（中継用）解約返戻金為替レート（円安）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykyktuukatype</td><td>（中継用）契約通貨タイプ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykeikanensuu01</td><td>（中継用）経過年数０１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhrkkknmnryumukbn01</td><td>（中継用）払込期間満了有無区分０１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyzennouzndkyen01</td><td>（中継用）前納残高（円貨）０１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyzennouzndkgaika01</td><td>（中継用）前納残高０１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyyenhrkgkgoukei01</td><td>（中継用）円貨払込額の合計（円貨）０１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykihrkmp01</td><td>（中継用）既払込保険料０１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyw01</td><td>（中継用）解約返戻金０１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztywyenyendaka01</td><td>（中継用）解約返戻金（円貨）円高０１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztywyenkijun01</td><td>（中継用）解約返戻金（円貨）中央値０１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztywyenyenyasu01</td><td>（中継用）解約返戻金（円貨）円安０１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykaiykuktgk01</td><td>（中継用）解約時受取額０１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykaiykuktgkyenyendaka01</td><td>（中継用）解約時受取額（円貨）円高０１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykaiykuktgkyenkijun01</td><td>（中継用）解約時受取額（円貨）中央値０１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykaiykuktgkyenyenyasu01</td><td>（中継用）解約時受取額（円貨）円安０１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykeikanensuu02</td><td>（中継用）経過年数０２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhrkkknmnryumukbn02</td><td>（中継用）払込期間満了有無区分０２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyzennouzndkyen02</td><td>（中継用）前納残高（円貨）０２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyzennouzndkgaika02</td><td>（中継用）前納残高０２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyyenhrkgkgoukei02</td><td>（中継用）円貨払込額の合計（円貨）０２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykihrkmp02</td><td>（中継用）既払込保険料０２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyw02</td><td>（中継用）解約返戻金０２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztywyenyendaka02</td><td>（中継用）解約返戻金（円貨）円高０２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztywyenkijun02</td><td>（中継用）解約返戻金（円貨）中央値０２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztywyenyenyasu02</td><td>（中継用）解約返戻金（円貨）円安０２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykaiykuktgk02</td><td>（中継用）解約時受取額０２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykaiykuktgkyenyendaka02</td><td>（中継用）解約時受取額（円貨）円高０２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykaiykuktgkyenkijun02</td><td>（中継用）解約時受取額（円貨）中央値０２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykaiykuktgkyenyenyasu02</td><td>（中継用）解約時受取額（円貨）円安０２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykeikanensuu03</td><td>（中継用）経過年数０３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhrkkknmnryumukbn03</td><td>（中継用）払込期間満了有無区分０３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyzennouzndkyen03</td><td>（中継用）前納残高（円貨）０３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyzennouzndkgaika03</td><td>（中継用）前納残高０３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyyenhrkgkgoukei03</td><td>（中継用）円貨払込額の合計（円貨）０３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykihrkmp03</td><td>（中継用）既払込保険料０３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyw03</td><td>（中継用）解約返戻金０３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztywyenyendaka03</td><td>（中継用）解約返戻金（円貨）円高０３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztywyenkijun03</td><td>（中継用）解約返戻金（円貨）中央値０３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztywyenyenyasu03</td><td>（中継用）解約返戻金（円貨）円安０３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykaiykuktgk03</td><td>（中継用）解約時受取額０３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykaiykuktgkyenyendaka03</td><td>（中継用）解約時受取額（円貨）円高０３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykaiykuktgkyenkijun03</td><td>（中継用）解約時受取額（円貨）中央値０３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykaiykuktgkyenyenyasu03</td><td>（中継用）解約時受取額（円貨）円安０３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykeikanensuu04</td><td>（中継用）経過年数０４</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhrkkknmnryumukbn04</td><td>（中継用）払込期間満了有無区分０４</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyzennouzndkyen04</td><td>（中継用）前納残高（円貨）０４</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyzennouzndkgaika04</td><td>（中継用）前納残高０４</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyyenhrkgkgoukei04</td><td>（中継用）円貨払込額の合計（円貨）０４</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykihrkmp04</td><td>（中継用）既払込保険料０４</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyw04</td><td>（中継用）解約返戻金０４</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztywyenyendaka04</td><td>（中継用）解約返戻金（円貨）円高０４</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztywyenkijun04</td><td>（中継用）解約返戻金（円貨）中央値０４</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztywyenyenyasu04</td><td>（中継用）解約返戻金（円貨）円安０４</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykaiykuktgk04</td><td>（中継用）解約時受取額０４</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykaiykuktgkyenyendaka04</td><td>（中継用）解約時受取額（円貨）円高０４</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykaiykuktgkyenkijun04</td><td>（中継用）解約時受取額（円貨）中央値０４</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykaiykuktgkyenyenyasu04</td><td>（中継用）解約時受取額（円貨）円安０４</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykeikanensuu05</td><td>（中継用）経過年数０５</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhrkkknmnryumukbn05</td><td>（中継用）払込期間満了有無区分０５</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyzennouzndkyen05</td><td>（中継用）前納残高（円貨）０５</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyzennouzndkgaika05</td><td>（中継用）前納残高０５</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyyenhrkgkgoukei05</td><td>（中継用）円貨払込額の合計（円貨）０５</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykihrkmp05</td><td>（中継用）既払込保険料０５</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyw05</td><td>（中継用）解約返戻金０５</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztywyenyendaka05</td><td>（中継用）解約返戻金（円貨）円高０５</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztywyenkijun05</td><td>（中継用）解約返戻金（円貨）中央値０５</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztywyenyenyasu05</td><td>（中継用）解約返戻金（円貨）円安０５</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykaiykuktgk05</td><td>（中継用）解約時受取額０５</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykaiykuktgkyenyendaka05</td><td>（中継用）解約時受取額（円貨）円高０５</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykaiykuktgkyenkijun05</td><td>（中継用）解約時受取額（円貨）中央値０５</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykaiykuktgkyenyenyasu05</td><td>（中継用）解約時受取額（円貨）円安０５</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykeikanensuu06</td><td>（中継用）経過年数０６</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhrkkknmnryumukbn06</td><td>（中継用）払込期間満了有無区分０６</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyzennouzndkyen06</td><td>（中継用）前納残高（円貨）０６</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyzennouzndkgaika06</td><td>（中継用）前納残高０６</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyyenhrkgkgoukei06</td><td>（中継用）円貨払込額の合計（円貨）０６</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykihrkmp06</td><td>（中継用）既払込保険料０６</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyw06</td><td>（中継用）解約返戻金０６</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztywyenyendaka06</td><td>（中継用）解約返戻金（円貨）円高０６</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztywyenkijun06</td><td>（中継用）解約返戻金（円貨）中央値０６</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztywyenyenyasu06</td><td>（中継用）解約返戻金（円貨）円安０６</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykaiykuktgk06</td><td>（中継用）解約時受取額０６</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykaiykuktgkyenyendaka06</td><td>（中継用）解約時受取額（円貨）円高０６</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykaiykuktgkyenkijun06</td><td>（中継用）解約時受取額（円貨）中央値０６</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykaiykuktgkyenyenyasu06</td><td>（中継用）解約時受取額（円貨）円安０６</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykeikanensuu07</td><td>（中継用）経過年数０７</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhrkkknmnryumukbn07</td><td>（中継用）払込期間満了有無区分０７</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyzennouzndkyen07</td><td>（中継用）前納残高（円貨）０７</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyzennouzndkgaika07</td><td>（中継用）前納残高０７</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyyenhrkgkgoukei07</td><td>（中継用）円貨払込額の合計（円貨）０７</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykihrkmp07</td><td>（中継用）既払込保険料０７</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyw07</td><td>（中継用）解約返戻金０７</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztywyenyendaka07</td><td>（中継用）解約返戻金（円貨）円高０７</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztywyenkijun07</td><td>（中継用）解約返戻金（円貨）中央値０７</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztywyenyenyasu07</td><td>（中継用）解約返戻金（円貨）円安０７</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykaiykuktgk07</td><td>（中継用）解約時受取額０７</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykaiykuktgkyenyendaka07</td><td>（中継用）解約時受取額（円貨）円高０７</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykaiykuktgkyenkijun07</td><td>（中継用）解約時受取額（円貨）中央値０７</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykaiykuktgkyenyenyasu07</td><td>（中継用）解約時受取額（円貨）円安０７</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykeikanensuu08</td><td>（中継用）経過年数０８</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhrkkknmnryumukbn08</td><td>（中継用）払込期間満了有無区分０８</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyzennouzndkyen08</td><td>（中継用）前納残高（円貨）０８</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyzennouzndkgaika08</td><td>（中継用）前納残高０８</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyyenhrkgkgoukei08</td><td>（中継用）円貨払込額の合計（円貨）０８</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykihrkmp08</td><td>（中継用）既払込保険料０８</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyw08</td><td>（中継用）解約返戻金０８</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztywyenyendaka08</td><td>（中継用）解約返戻金（円貨）円高０８</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztywyenkijun08</td><td>（中継用）解約返戻金（円貨）中央値０８</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztywyenyenyasu08</td><td>（中継用）解約返戻金（円貨）円安０８</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykaiykuktgk08</td><td>（中継用）解約時受取額０８</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykaiykuktgkyenyendaka08</td><td>（中継用）解約時受取額（円貨）円高０８</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykaiykuktgkyenkijun08</td><td>（中継用）解約時受取額（円貨）中央値０８</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykaiykuktgkyenyenyasu08</td><td>（中継用）解約時受取額（円貨）円安０８</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykeikanensuu09</td><td>（中継用）経過年数０９</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhrkkknmnryumukbn09</td><td>（中継用）払込期間満了有無区分０９</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyzennouzndkyen09</td><td>（中継用）前納残高（円貨）０９</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyzennouzndkgaika09</td><td>（中継用）前納残高０９</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyyenhrkgkgoukei09</td><td>（中継用）円貨払込額の合計（円貨）０９</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykihrkmp09</td><td>（中継用）既払込保険料０９</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyw09</td><td>（中継用）解約返戻金０９</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztywyenyendaka09</td><td>（中継用）解約返戻金（円貨）円高０９</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztywyenkijun09</td><td>（中継用）解約返戻金（円貨）中央値０９</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztywyenyenyasu09</td><td>（中継用）解約返戻金（円貨）円安０９</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykaiykuktgk09</td><td>（中継用）解約時受取額０９</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykaiykuktgkyenyendaka09</td><td>（中継用）解約時受取額（円貨）円高０９</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykaiykuktgkyenkijun09</td><td>（中継用）解約時受取額（円貨）中央値０９</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykaiykuktgkyenyenyasu09</td><td>（中継用）解約時受取額（円貨）円安０９</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykeikanensuu10</td><td>（中継用）経過年数１０</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhrkkknmnryumukbn10</td><td>（中継用）払込期間満了有無区分１０</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyzennouzndkyen10</td><td>（中継用）前納残高（円貨）１０</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyzennouzndkgaika10</td><td>（中継用）前納残高１０</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyyenhrkgkgoukei10</td><td>（中継用）円貨払込額の合計（円貨）１０</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykihrkmp10</td><td>（中継用）既払込保険料１０</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyw10</td><td>（中継用）解約返戻金１０</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztywyenyendaka10</td><td>（中継用）解約返戻金（円貨）円高１０</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztywyenkijun10</td><td>（中継用）解約返戻金（円貨）中央値１０</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztywyenyenyasu10</td><td>（中継用）解約返戻金（円貨）円安１０</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykaiykuktgk10</td><td>（中継用）解約時受取額１０</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykaiykuktgkyenyendaka10</td><td>（中継用）解約時受取額（円貨）円高１０</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykaiykuktgkyenkijun10</td><td>（中継用）解約時受取額（円貨）中央値１０</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykaiykuktgkyenyenyasu10</td><td>（中継用）解約時受取額（円貨）円安１０</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykeikanensuu11</td><td>（中継用）経過年数１１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhrkkknmnryumukbn11</td><td>（中継用）払込期間満了有無区分１１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyzennouzndkyen11</td><td>（中継用）前納残高（円貨）１１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyzennouzndkgaika11</td><td>（中継用）前納残高１１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyyenhrkgkgoukei11</td><td>（中継用）円貨払込額の合計（円貨）１１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykihrkmp11</td><td>（中継用）既払込保険料１１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyw11</td><td>（中継用）解約返戻金１１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztywyenyendaka11</td><td>（中継用）解約返戻金（円貨）円高１１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztywyenkijun11</td><td>（中継用）解約返戻金（円貨）中央値１１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztywyenyenyasu11</td><td>（中継用）解約返戻金（円貨）円安１１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykaiykuktgk11</td><td>（中継用）解約時受取額１１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykaiykuktgkyenyendaka11</td><td>（中継用）解約時受取額（円貨）円高１１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykaiykuktgkyenkijun11</td><td>（中継用）解約時受取額（円貨）中央値１１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykaiykuktgkyenyenyasu11</td><td>（中継用）解約時受取額（円貨）円安１１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykeikanensuu12</td><td>（中継用）経過年数１２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhrkkknmnryumukbn12</td><td>（中継用）払込期間満了有無区分１２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyzennouzndkyen12</td><td>（中継用）前納残高（円貨）１２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyzennouzndkgaika12</td><td>（中継用）前納残高１２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyyenhrkgkgoukei12</td><td>（中継用）円貨払込額の合計（円貨）１２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykihrkmp12</td><td>（中継用）既払込保険料１２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyw12</td><td>（中継用）解約返戻金１２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztywyenyendaka12</td><td>（中継用）解約返戻金（円貨）円高１２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztywyenkijun12</td><td>（中継用）解約返戻金（円貨）中央値１２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztywyenyenyasu12</td><td>（中継用）解約返戻金（円貨）円安１２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykaiykuktgk12</td><td>（中継用）解約時受取額１２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykaiykuktgkyenyendaka12</td><td>（中継用）解約時受取額（円貨）円高１２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykaiykuktgkyenkijun12</td><td>（中継用）解約時受取額（円貨）中央値１２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykaiykuktgkyenyenyasu12</td><td>（中継用）解約時受取額（円貨）円安１２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykeikanensuu13</td><td>（中継用）経過年数１３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhrkkknmnryumukbn13</td><td>（中継用）払込期間満了有無区分１３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyzennouzndkyen13</td><td>（中継用）前納残高（円貨）１３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyzennouzndkgaika13</td><td>（中継用）前納残高１３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyyenhrkgkgoukei13</td><td>（中継用）円貨払込額の合計（円貨）１３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykihrkmp13</td><td>（中継用）既払込保険料１３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyw13</td><td>（中継用）解約返戻金１３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztywyenyendaka13</td><td>（中継用）解約返戻金（円貨）円高１３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztywyenkijun13</td><td>（中継用）解約返戻金（円貨）中央値１３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztywyenyenyasu13</td><td>（中継用）解約返戻金（円貨）円安１３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykaiykuktgk13</td><td>（中継用）解約時受取額１３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykaiykuktgkyenyendaka13</td><td>（中継用）解約時受取額（円貨）円高１３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykaiykuktgkyenkijun13</td><td>（中継用）解約時受取額（円貨）中央値１３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykaiykuktgkyenyenyasu13</td><td>（中継用）解約時受取額（円貨）円安１３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykeikanensuu14</td><td>（中継用）経過年数１４</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhrkkknmnryumukbn14</td><td>（中継用）払込期間満了有無区分１４</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyzennouzndkyen14</td><td>（中継用）前納残高（円貨）１４</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyzennouzndkgaika14</td><td>（中継用）前納残高１４</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyyenhrkgkgoukei14</td><td>（中継用）円貨払込額の合計（円貨）１４</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykihrkmp14</td><td>（中継用）既払込保険料１４</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyw14</td><td>（中継用）解約返戻金１４</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztywyenyendaka14</td><td>（中継用）解約返戻金（円貨）円高１４</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztywyenkijun14</td><td>（中継用）解約返戻金（円貨）中央値１４</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztywyenyenyasu14</td><td>（中継用）解約返戻金（円貨）円安１４</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykaiykuktgk14</td><td>（中継用）解約時受取額１４</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykaiykuktgkyenyendaka14</td><td>（中継用）解約時受取額（円貨）円高１４</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykaiykuktgkyenkijun14</td><td>（中継用）解約時受取額（円貨）中央値１４</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykaiykuktgkyenyenyasu14</td><td>（中継用）解約時受取額（円貨）円安１４</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykeikanensuu15</td><td>（中継用）経過年数１５</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhrkkknmnryumukbn15</td><td>（中継用）払込期間満了有無区分１５</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyzennouzndkyen15</td><td>（中継用）前納残高（円貨）１５</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyzennouzndkgaika15</td><td>（中継用）前納残高１５</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyyenhrkgkgoukei15</td><td>（中継用）円貨払込額の合計（円貨）１５</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykihrkmp15</td><td>（中継用）既払込保険料１５</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyw15</td><td>（中継用）解約返戻金１５</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztywyenyendaka15</td><td>（中継用）解約返戻金（円貨）円高１５</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztywyenkijun15</td><td>（中継用）解約返戻金（円貨）中央値１５</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztywyenyenyasu15</td><td>（中継用）解約返戻金（円貨）円安１５</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykaiykuktgk15</td><td>（中継用）解約時受取額１５</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykaiykuktgkyenyendaka15</td><td>（中継用）解約時受取額（円貨）円高１５</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykaiykuktgkyenkijun15</td><td>（中継用）解約時受取額（円貨）中央値１５</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykaiykuktgkyenyenyasu15</td><td>（中継用）解約時受取額（円貨）円安１５</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykeikanensuu16</td><td>（中継用）経過年数１６</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhrkkknmnryumukbn16</td><td>（中継用）払込期間満了有無区分１６</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyzennouzndkyen16</td><td>（中継用）前納残高（円貨）１６</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyzennouzndkgaika16</td><td>（中継用）前納残高１６</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyyenhrkgkgoukei16</td><td>（中継用）円貨払込額の合計（円貨）１６</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykihrkmp16</td><td>（中継用）既払込保険料１６</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyw16</td><td>（中継用）解約返戻金１６</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztywyenyendaka16</td><td>（中継用）解約返戻金（円貨）円高１６</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztywyenkijun16</td><td>（中継用）解約返戻金（円貨）中央値１６</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztywyenyenyasu16</td><td>（中継用）解約返戻金（円貨）円安１６</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykaiykuktgk16</td><td>（中継用）解約時受取額１６</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykaiykuktgkyenyendaka16</td><td>（中継用）解約時受取額（円貨）円高１６</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykaiykuktgkyenkijun16</td><td>（中継用）解約時受取額（円貨）中央値１６</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykaiykuktgkyenyenyasu16</td><td>（中継用）解約時受取額（円貨）円安１６</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykeikanensuu17</td><td>（中継用）経過年数１７</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhrkkknmnryumukbn17</td><td>（中継用）払込期間満了有無区分１７</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyzennouzndkyen17</td><td>（中継用）前納残高（円貨）１７</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyzennouzndkgaika17</td><td>（中継用）前納残高１７</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyyenhrkgkgoukei17</td><td>（中継用）円貨払込額の合計（円貨）１７</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykihrkmp17</td><td>（中継用）既払込保険料１７</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyw17</td><td>（中継用）解約返戻金１７</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztywyenyendaka17</td><td>（中継用）解約返戻金（円貨）円高１７</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztywyenkijun17</td><td>（中継用）解約返戻金（円貨）中央値１７</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztywyenyenyasu17</td><td>（中継用）解約返戻金（円貨）円安１７</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykaiykuktgk17</td><td>（中継用）解約時受取額１７</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykaiykuktgkyenyendaka17</td><td>（中継用）解約時受取額（円貨）円高１７</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykaiykuktgkyenkijun17</td><td>（中継用）解約時受取額（円貨）中央値１７</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykaiykuktgkyenyenyasu17</td><td>（中継用）解約時受取額（円貨）円安１７</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykeikanensuu18</td><td>（中継用）経過年数１８</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhrkkknmnryumukbn18</td><td>（中継用）払込期間満了有無区分１８</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyzennouzndkyen18</td><td>（中継用）前納残高（円貨）１８</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyzennouzndkgaika18</td><td>（中継用）前納残高１８</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyyenhrkgkgoukei18</td><td>（中継用）円貨払込額の合計（円貨）１８</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykihrkmp18</td><td>（中継用）既払込保険料１８</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyw18</td><td>（中継用）解約返戻金１８</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztywyenyendaka18</td><td>（中継用）解約返戻金（円貨）円高１８</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztywyenkijun18</td><td>（中継用）解約返戻金（円貨）中央値１８</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztywyenyenyasu18</td><td>（中継用）解約返戻金（円貨）円安１８</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykaiykuktgk18</td><td>（中継用）解約時受取額１８</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykaiykuktgkyenyendaka18</td><td>（中継用）解約時受取額（円貨）円高１８</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykaiykuktgkyenkijun18</td><td>（中継用）解約時受取額（円貨）中央値１８</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykaiykuktgkyenyenyasu18</td><td>（中継用）解約時受取額（円貨）円安１８</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykeikanensuu19</td><td>（中継用）経過年数１９</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhrkkknmnryumukbn19</td><td>（中継用）払込期間満了有無区分１９</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyzennouzndkyen19</td><td>（中継用）前納残高（円貨）１９</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyzennouzndkgaika19</td><td>（中継用）前納残高１９</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyyenhrkgkgoukei19</td><td>（中継用）円貨払込額の合計（円貨）１９</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykihrkmp19</td><td>（中継用）既払込保険料１９</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyw19</td><td>（中継用）解約返戻金１９</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztywyenyendaka19</td><td>（中継用）解約返戻金（円貨）円高１９</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztywyenkijun19</td><td>（中継用）解約返戻金（円貨）中央値１９</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztywyenyenyasu19</td><td>（中継用）解約返戻金（円貨）円安１９</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykaiykuktgk19</td><td>（中継用）解約時受取額１９</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykaiykuktgkyenyendaka19</td><td>（中継用）解約時受取額（円貨）円高１９</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykaiykuktgkyenkijun19</td><td>（中継用）解約時受取額（円貨）中央値１９</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykaiykuktgkyenyenyasu19</td><td>（中継用）解約時受取額（円貨）円安１９</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykeikanensuu20</td><td>（中継用）経過年数２０</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhrkkknmnryumukbn20</td><td>（中継用）払込期間満了有無区分２０</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyzennouzndkyen20</td><td>（中継用）前納残高（円貨）２０</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyzennouzndkgaika20</td><td>（中継用）前納残高２０</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyyenhrkgkgoukei20</td><td>（中継用）円貨払込額の合計（円貨）２０</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykihrkmp20</td><td>（中継用）既払込保険料２０</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyw20</td><td>（中継用）解約返戻金２０</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztywyenyendaka20</td><td>（中継用）解約返戻金（円貨）円高２０</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztywyenkijun20</td><td>（中継用）解約返戻金（円貨）中央値２０</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztywyenyenyasu20</td><td>（中継用）解約返戻金（円貨）円安２０</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykaiykuktgk20</td><td>（中継用）解約時受取額２０</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykaiykuktgkyenyendaka20</td><td>（中継用）解約時受取額（円貨）円高２０</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykaiykuktgkyenkijun20</td><td>（中継用）解約時受取額（円貨）中央値２０</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykaiykuktgkyenyenyasu20</td><td>（中継用）解約時受取額（円貨）円安２０</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykeikanensuu21</td><td>（中継用）経過年数２１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhrkkknmnryumukbn21</td><td>（中継用）払込期間満了有無区分２１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyzennouzndkyen21</td><td>（中継用）前納残高（円貨）２１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyzennouzndkgaika21</td><td>（中継用）前納残高２１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyyenhrkgkgoukei21</td><td>（中継用）円貨払込額の合計（円貨）２１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykihrkmp21</td><td>（中継用）既払込保険料２１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyw21</td><td>（中継用）解約返戻金２１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztywyenyendaka21</td><td>（中継用）解約返戻金（円貨）円高２１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztywyenkijun21</td><td>（中継用）解約返戻金（円貨）中央値２１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztywyenyenyasu21</td><td>（中継用）解約返戻金（円貨）円安２１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykaiykuktgk21</td><td>（中継用）解約時受取額２１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykaiykuktgkyenyendaka21</td><td>（中継用）解約時受取額（円貨）円高２１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykaiykuktgkyenkijun21</td><td>（中継用）解約時受取額（円貨）中央値２１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykaiykuktgkyenyenyasu21</td><td>（中継用）解約時受取額（円貨）円安２１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykeikanensuu22</td><td>（中継用）経過年数２２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhrkkknmnryumukbn22</td><td>（中継用）払込期間満了有無区分２２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyzennouzndkyen22</td><td>（中継用）前納残高（円貨）２２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyzennouzndkgaika22</td><td>（中継用）前納残高２２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyyenhrkgkgoukei22</td><td>（中継用）円貨払込額の合計（円貨）２２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykihrkmp22</td><td>（中継用）既払込保険料２２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyw22</td><td>（中継用）解約返戻金２２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztywyenyendaka22</td><td>（中継用）解約返戻金（円貨）円高２２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztywyenkijun22</td><td>（中継用）解約返戻金（円貨）中央値２２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztywyenyenyasu22</td><td>（中継用）解約返戻金（円貨）円安２２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykaiykuktgk22</td><td>（中継用）解約時受取額２２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykaiykuktgkyenyendaka22</td><td>（中継用）解約時受取額（円貨）円高２２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykaiykuktgkyenkijun22</td><td>（中継用）解約時受取額（円貨）中央値２２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykaiykuktgkyenyenyasu22</td><td>（中継用）解約時受取額（円貨）円安２２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyyobiv196</td><td>（中継用）予備項目Ｖ１９６</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyyobiv4</td><td>（中継用）予備項目Ｖ４</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     ZT_SinkeiyakuSyoukenSuii2Ty
 * @see     GenZT_SinkeiyakuSyoukenSuii2Ty
 * @see     QZT_SinkeiyakuSyoukenSuii2Ty
 * @see     GenQZT_SinkeiyakuSyoukenSuii2Ty
 */
public class PKZT_SinkeiyakuSyoukenSuii2Ty extends AbstractExDBPrimaryKey<ZT_SinkeiyakuSyoukenSuii2Ty, PKZT_SinkeiyakuSyoukenSuii2Ty> {

    private static final long serialVersionUID = 1L;

    public PKZT_SinkeiyakuSyoukenSuii2Ty() {
    }

    public PKZT_SinkeiyakuSyoukenSuii2Ty(
        String pZtysyono,
        String pZtytyouhyouymd,
        String pZtysuiihyouptn
    ) {
        ztysyono = pZtysyono;
        ztytyouhyouymd = pZtytyouhyouymd;
        ztysuiihyouptn = pZtysuiihyouptn;
    }

    @Transient
    @Override
    public Class<ZT_SinkeiyakuSyoukenSuii2Ty> getEntityClass() {
        return ZT_SinkeiyakuSyoukenSuii2Ty.class;
    }

    private String ztysyono;

    public String getZtysyono() {
        return ztysyono;
    }

    public void setZtysyono(String pZtysyono) {
        ztysyono = pZtysyono;
    }
    private String ztytyouhyouymd;

    public String getZtytyouhyouymd() {
        return ztytyouhyouymd;
    }

    public void setZtytyouhyouymd(String pZtytyouhyouymd) {
        ztytyouhyouymd = pZtytyouhyouymd;
    }
    private String ztysuiihyouptn;

    public String getZtysuiihyouptn() {
        return ztysuiihyouptn;
    }

    public void setZtysuiihyouptn(String pZtysuiihyouptn) {
        ztysuiihyouptn = pZtysuiihyouptn;
    }

}