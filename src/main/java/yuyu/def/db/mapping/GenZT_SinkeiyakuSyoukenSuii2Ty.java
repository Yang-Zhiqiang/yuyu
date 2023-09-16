package yuyu.def.db.mapping;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Transient;
import yuyu.def.db.entity.ZT_SinkeiyakuSyoukenSuii2Ty;
import yuyu.def.db.id.PKZT_SinkeiyakuSyoukenSuii2Ty;
import yuyu.def.db.meta.GenQZT_SinkeiyakuSyoukenSuii2Ty;
import yuyu.def.db.meta.QZT_SinkeiyakuSyoukenSuii2Ty;

/**
 * 新契約保険証券推移表Ｆテーブル２（中） テーブルのマッピング情報クラスで、 {@link ZT_SinkeiyakuSyoukenSuii2Ty} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_SinkeiyakuSyoukenSuii2Ty}</td><td colspan="3">新契約保険証券推移表Ｆテーブル２（中）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getZtysyono ztysyono}</td><td>（中継用）証券番号</td><td align="center">{@link PKZT_SinkeiyakuSyoukenSuii2Ty ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytyouhyouymd ztytyouhyouymd}</td><td>（中継用）帳票作成日</td><td align="center">{@link PKZT_SinkeiyakuSyoukenSuii2Ty ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysuiihyouptn ztysuiihyouptn}</td><td>（中継用）推移表パターン</td><td align="center">{@link PKZT_SinkeiyakuSyoukenSuii2Ty ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysuiihyousykbn ztysuiihyousykbn}</td><td>（中継用）推移表種別区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysuiihyousyono ztysuiihyousyono}</td><td>（中継用）推移表証券番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyytirrtcalckijyunrrt ztyytirrtcalckijyunrrt}</td><td>（中継用）予定利率計算基準利率</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtywkwsrateyendaka ztywkwsrateyendaka}</td><td>（中継用）解約返戻金為替レート（円高）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtywkwsrateyenkijyun ztywkwsrateyenkijyun}</td><td>（中継用）解約返戻金為替レート（中央値）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtywkwsrateyenyasu ztywkwsrateyenyasu}</td><td>（中継用）解約返戻金為替レート（円安）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykyktuukatype ztykyktuukatype}</td><td>（中継用）契約通貨タイプ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykeikanensuu01 ztykeikanensuu01}</td><td>（中継用）経過年数０１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhrkkknmnryumukbn01 ztyhrkkknmnryumukbn01}</td><td>（中継用）払込期間満了有無区分０１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyzennouzndkyen01 ztyzennouzndkyen01}</td><td>（中継用）前納残高（円貨）０１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyzennouzndkgaika01 ztyzennouzndkgaika01}</td><td>（中継用）前納残高０１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyenhrkgkgoukei01 ztyyenhrkgkgoukei01}</td><td>（中継用）円貨払込額の合計（円貨）０１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykihrkmp01 ztykihrkmp01}</td><td>（中継用）既払込保険料０１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyw01 ztyw01}</td><td>（中継用）解約返戻金０１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtywyenyendaka01 ztywyenyendaka01}</td><td>（中継用）解約返戻金（円貨）円高０１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtywyenkijun01 ztywyenkijun01}</td><td>（中継用）解約返戻金（円貨）中央値０１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtywyenyenyasu01 ztywyenyenyasu01}</td><td>（中継用）解約返戻金（円貨）円安０１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykaiykuktgk01 ztykaiykuktgk01}</td><td>（中継用）解約時受取額０１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykaiykuktgkyenyendaka01 ztykaiykuktgkyenyendaka01}</td><td>（中継用）解約時受取額（円貨）円高０１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykaiykuktgkyenkijun01 ztykaiykuktgkyenkijun01}</td><td>（中継用）解約時受取額（円貨）中央値０１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykaiykuktgkyenyenyasu01 ztykaiykuktgkyenyenyasu01}</td><td>（中継用）解約時受取額（円貨）円安０１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykeikanensuu02 ztykeikanensuu02}</td><td>（中継用）経過年数０２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhrkkknmnryumukbn02 ztyhrkkknmnryumukbn02}</td><td>（中継用）払込期間満了有無区分０２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyzennouzndkyen02 ztyzennouzndkyen02}</td><td>（中継用）前納残高（円貨）０２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyzennouzndkgaika02 ztyzennouzndkgaika02}</td><td>（中継用）前納残高０２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyenhrkgkgoukei02 ztyyenhrkgkgoukei02}</td><td>（中継用）円貨払込額の合計（円貨）０２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykihrkmp02 ztykihrkmp02}</td><td>（中継用）既払込保険料０２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyw02 ztyw02}</td><td>（中継用）解約返戻金０２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtywyenyendaka02 ztywyenyendaka02}</td><td>（中継用）解約返戻金（円貨）円高０２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtywyenkijun02 ztywyenkijun02}</td><td>（中継用）解約返戻金（円貨）中央値０２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtywyenyenyasu02 ztywyenyenyasu02}</td><td>（中継用）解約返戻金（円貨）円安０２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykaiykuktgk02 ztykaiykuktgk02}</td><td>（中継用）解約時受取額０２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykaiykuktgkyenyendaka02 ztykaiykuktgkyenyendaka02}</td><td>（中継用）解約時受取額（円貨）円高０２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykaiykuktgkyenkijun02 ztykaiykuktgkyenkijun02}</td><td>（中継用）解約時受取額（円貨）中央値０２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykaiykuktgkyenyenyasu02 ztykaiykuktgkyenyenyasu02}</td><td>（中継用）解約時受取額（円貨）円安０２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykeikanensuu03 ztykeikanensuu03}</td><td>（中継用）経過年数０３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhrkkknmnryumukbn03 ztyhrkkknmnryumukbn03}</td><td>（中継用）払込期間満了有無区分０３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyzennouzndkyen03 ztyzennouzndkyen03}</td><td>（中継用）前納残高（円貨）０３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyzennouzndkgaika03 ztyzennouzndkgaika03}</td><td>（中継用）前納残高０３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyenhrkgkgoukei03 ztyyenhrkgkgoukei03}</td><td>（中継用）円貨払込額の合計（円貨）０３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykihrkmp03 ztykihrkmp03}</td><td>（中継用）既払込保険料０３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyw03 ztyw03}</td><td>（中継用）解約返戻金０３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtywyenyendaka03 ztywyenyendaka03}</td><td>（中継用）解約返戻金（円貨）円高０３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtywyenkijun03 ztywyenkijun03}</td><td>（中継用）解約返戻金（円貨）中央値０３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtywyenyenyasu03 ztywyenyenyasu03}</td><td>（中継用）解約返戻金（円貨）円安０３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykaiykuktgk03 ztykaiykuktgk03}</td><td>（中継用）解約時受取額０３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykaiykuktgkyenyendaka03 ztykaiykuktgkyenyendaka03}</td><td>（中継用）解約時受取額（円貨）円高０３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykaiykuktgkyenkijun03 ztykaiykuktgkyenkijun03}</td><td>（中継用）解約時受取額（円貨）中央値０３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykaiykuktgkyenyenyasu03 ztykaiykuktgkyenyenyasu03}</td><td>（中継用）解約時受取額（円貨）円安０３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykeikanensuu04 ztykeikanensuu04}</td><td>（中継用）経過年数０４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhrkkknmnryumukbn04 ztyhrkkknmnryumukbn04}</td><td>（中継用）払込期間満了有無区分０４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyzennouzndkyen04 ztyzennouzndkyen04}</td><td>（中継用）前納残高（円貨）０４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyzennouzndkgaika04 ztyzennouzndkgaika04}</td><td>（中継用）前納残高０４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyenhrkgkgoukei04 ztyyenhrkgkgoukei04}</td><td>（中継用）円貨払込額の合計（円貨）０４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykihrkmp04 ztykihrkmp04}</td><td>（中継用）既払込保険料０４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyw04 ztyw04}</td><td>（中継用）解約返戻金０４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtywyenyendaka04 ztywyenyendaka04}</td><td>（中継用）解約返戻金（円貨）円高０４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtywyenkijun04 ztywyenkijun04}</td><td>（中継用）解約返戻金（円貨）中央値０４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtywyenyenyasu04 ztywyenyenyasu04}</td><td>（中継用）解約返戻金（円貨）円安０４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykaiykuktgk04 ztykaiykuktgk04}</td><td>（中継用）解約時受取額０４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykaiykuktgkyenyendaka04 ztykaiykuktgkyenyendaka04}</td><td>（中継用）解約時受取額（円貨）円高０４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykaiykuktgkyenkijun04 ztykaiykuktgkyenkijun04}</td><td>（中継用）解約時受取額（円貨）中央値０４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykaiykuktgkyenyenyasu04 ztykaiykuktgkyenyenyasu04}</td><td>（中継用）解約時受取額（円貨）円安０４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykeikanensuu05 ztykeikanensuu05}</td><td>（中継用）経過年数０５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhrkkknmnryumukbn05 ztyhrkkknmnryumukbn05}</td><td>（中継用）払込期間満了有無区分０５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyzennouzndkyen05 ztyzennouzndkyen05}</td><td>（中継用）前納残高（円貨）０５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyzennouzndkgaika05 ztyzennouzndkgaika05}</td><td>（中継用）前納残高０５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyenhrkgkgoukei05 ztyyenhrkgkgoukei05}</td><td>（中継用）円貨払込額の合計（円貨）０５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykihrkmp05 ztykihrkmp05}</td><td>（中継用）既払込保険料０５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyw05 ztyw05}</td><td>（中継用）解約返戻金０５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtywyenyendaka05 ztywyenyendaka05}</td><td>（中継用）解約返戻金（円貨）円高０５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtywyenkijun05 ztywyenkijun05}</td><td>（中継用）解約返戻金（円貨）中央値０５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtywyenyenyasu05 ztywyenyenyasu05}</td><td>（中継用）解約返戻金（円貨）円安０５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykaiykuktgk05 ztykaiykuktgk05}</td><td>（中継用）解約時受取額０５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykaiykuktgkyenyendaka05 ztykaiykuktgkyenyendaka05}</td><td>（中継用）解約時受取額（円貨）円高０５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykaiykuktgkyenkijun05 ztykaiykuktgkyenkijun05}</td><td>（中継用）解約時受取額（円貨）中央値０５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykaiykuktgkyenyenyasu05 ztykaiykuktgkyenyenyasu05}</td><td>（中継用）解約時受取額（円貨）円安０５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykeikanensuu06 ztykeikanensuu06}</td><td>（中継用）経過年数０６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhrkkknmnryumukbn06 ztyhrkkknmnryumukbn06}</td><td>（中継用）払込期間満了有無区分０６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyzennouzndkyen06 ztyzennouzndkyen06}</td><td>（中継用）前納残高（円貨）０６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyzennouzndkgaika06 ztyzennouzndkgaika06}</td><td>（中継用）前納残高０６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyenhrkgkgoukei06 ztyyenhrkgkgoukei06}</td><td>（中継用）円貨払込額の合計（円貨）０６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykihrkmp06 ztykihrkmp06}</td><td>（中継用）既払込保険料０６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyw06 ztyw06}</td><td>（中継用）解約返戻金０６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtywyenyendaka06 ztywyenyendaka06}</td><td>（中継用）解約返戻金（円貨）円高０６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtywyenkijun06 ztywyenkijun06}</td><td>（中継用）解約返戻金（円貨）中央値０６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtywyenyenyasu06 ztywyenyenyasu06}</td><td>（中継用）解約返戻金（円貨）円安０６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykaiykuktgk06 ztykaiykuktgk06}</td><td>（中継用）解約時受取額０６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykaiykuktgkyenyendaka06 ztykaiykuktgkyenyendaka06}</td><td>（中継用）解約時受取額（円貨）円高０６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykaiykuktgkyenkijun06 ztykaiykuktgkyenkijun06}</td><td>（中継用）解約時受取額（円貨）中央値０６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykaiykuktgkyenyenyasu06 ztykaiykuktgkyenyenyasu06}</td><td>（中継用）解約時受取額（円貨）円安０６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykeikanensuu07 ztykeikanensuu07}</td><td>（中継用）経過年数０７</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhrkkknmnryumukbn07 ztyhrkkknmnryumukbn07}</td><td>（中継用）払込期間満了有無区分０７</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyzennouzndkyen07 ztyzennouzndkyen07}</td><td>（中継用）前納残高（円貨）０７</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyzennouzndkgaika07 ztyzennouzndkgaika07}</td><td>（中継用）前納残高０７</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyenhrkgkgoukei07 ztyyenhrkgkgoukei07}</td><td>（中継用）円貨払込額の合計（円貨）０７</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykihrkmp07 ztykihrkmp07}</td><td>（中継用）既払込保険料０７</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyw07 ztyw07}</td><td>（中継用）解約返戻金０７</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtywyenyendaka07 ztywyenyendaka07}</td><td>（中継用）解約返戻金（円貨）円高０７</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtywyenkijun07 ztywyenkijun07}</td><td>（中継用）解約返戻金（円貨）中央値０７</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtywyenyenyasu07 ztywyenyenyasu07}</td><td>（中継用）解約返戻金（円貨）円安０７</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykaiykuktgk07 ztykaiykuktgk07}</td><td>（中継用）解約時受取額０７</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykaiykuktgkyenyendaka07 ztykaiykuktgkyenyendaka07}</td><td>（中継用）解約時受取額（円貨）円高０７</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykaiykuktgkyenkijun07 ztykaiykuktgkyenkijun07}</td><td>（中継用）解約時受取額（円貨）中央値０７</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykaiykuktgkyenyenyasu07 ztykaiykuktgkyenyenyasu07}</td><td>（中継用）解約時受取額（円貨）円安０７</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykeikanensuu08 ztykeikanensuu08}</td><td>（中継用）経過年数０８</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhrkkknmnryumukbn08 ztyhrkkknmnryumukbn08}</td><td>（中継用）払込期間満了有無区分０８</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyzennouzndkyen08 ztyzennouzndkyen08}</td><td>（中継用）前納残高（円貨）０８</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyzennouzndkgaika08 ztyzennouzndkgaika08}</td><td>（中継用）前納残高０８</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyenhrkgkgoukei08 ztyyenhrkgkgoukei08}</td><td>（中継用）円貨払込額の合計（円貨）０８</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykihrkmp08 ztykihrkmp08}</td><td>（中継用）既払込保険料０８</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyw08 ztyw08}</td><td>（中継用）解約返戻金０８</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtywyenyendaka08 ztywyenyendaka08}</td><td>（中継用）解約返戻金（円貨）円高０８</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtywyenkijun08 ztywyenkijun08}</td><td>（中継用）解約返戻金（円貨）中央値０８</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtywyenyenyasu08 ztywyenyenyasu08}</td><td>（中継用）解約返戻金（円貨）円安０８</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykaiykuktgk08 ztykaiykuktgk08}</td><td>（中継用）解約時受取額０８</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykaiykuktgkyenyendaka08 ztykaiykuktgkyenyendaka08}</td><td>（中継用）解約時受取額（円貨）円高０８</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykaiykuktgkyenkijun08 ztykaiykuktgkyenkijun08}</td><td>（中継用）解約時受取額（円貨）中央値０８</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykaiykuktgkyenyenyasu08 ztykaiykuktgkyenyenyasu08}</td><td>（中継用）解約時受取額（円貨）円安０８</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykeikanensuu09 ztykeikanensuu09}</td><td>（中継用）経過年数０９</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhrkkknmnryumukbn09 ztyhrkkknmnryumukbn09}</td><td>（中継用）払込期間満了有無区分０９</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyzennouzndkyen09 ztyzennouzndkyen09}</td><td>（中継用）前納残高（円貨）０９</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyzennouzndkgaika09 ztyzennouzndkgaika09}</td><td>（中継用）前納残高０９</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyenhrkgkgoukei09 ztyyenhrkgkgoukei09}</td><td>（中継用）円貨払込額の合計（円貨）０９</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykihrkmp09 ztykihrkmp09}</td><td>（中継用）既払込保険料０９</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyw09 ztyw09}</td><td>（中継用）解約返戻金０９</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtywyenyendaka09 ztywyenyendaka09}</td><td>（中継用）解約返戻金（円貨）円高０９</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtywyenkijun09 ztywyenkijun09}</td><td>（中継用）解約返戻金（円貨）中央値０９</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtywyenyenyasu09 ztywyenyenyasu09}</td><td>（中継用）解約返戻金（円貨）円安０９</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykaiykuktgk09 ztykaiykuktgk09}</td><td>（中継用）解約時受取額０９</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykaiykuktgkyenyendaka09 ztykaiykuktgkyenyendaka09}</td><td>（中継用）解約時受取額（円貨）円高０９</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykaiykuktgkyenkijun09 ztykaiykuktgkyenkijun09}</td><td>（中継用）解約時受取額（円貨）中央値０９</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykaiykuktgkyenyenyasu09 ztykaiykuktgkyenyenyasu09}</td><td>（中継用）解約時受取額（円貨）円安０９</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykeikanensuu10 ztykeikanensuu10}</td><td>（中継用）経過年数１０</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhrkkknmnryumukbn10 ztyhrkkknmnryumukbn10}</td><td>（中継用）払込期間満了有無区分１０</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyzennouzndkyen10 ztyzennouzndkyen10}</td><td>（中継用）前納残高（円貨）１０</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyzennouzndkgaika10 ztyzennouzndkgaika10}</td><td>（中継用）前納残高１０</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyenhrkgkgoukei10 ztyyenhrkgkgoukei10}</td><td>（中継用）円貨払込額の合計（円貨）１０</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykihrkmp10 ztykihrkmp10}</td><td>（中継用）既払込保険料１０</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyw10 ztyw10}</td><td>（中継用）解約返戻金１０</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtywyenyendaka10 ztywyenyendaka10}</td><td>（中継用）解約返戻金（円貨）円高１０</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtywyenkijun10 ztywyenkijun10}</td><td>（中継用）解約返戻金（円貨）中央値１０</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtywyenyenyasu10 ztywyenyenyasu10}</td><td>（中継用）解約返戻金（円貨）円安１０</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykaiykuktgk10 ztykaiykuktgk10}</td><td>（中継用）解約時受取額１０</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykaiykuktgkyenyendaka10 ztykaiykuktgkyenyendaka10}</td><td>（中継用）解約時受取額（円貨）円高１０</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykaiykuktgkyenkijun10 ztykaiykuktgkyenkijun10}</td><td>（中継用）解約時受取額（円貨）中央値１０</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykaiykuktgkyenyenyasu10 ztykaiykuktgkyenyenyasu10}</td><td>（中継用）解約時受取額（円貨）円安１０</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykeikanensuu11 ztykeikanensuu11}</td><td>（中継用）経過年数１１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhrkkknmnryumukbn11 ztyhrkkknmnryumukbn11}</td><td>（中継用）払込期間満了有無区分１１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyzennouzndkyen11 ztyzennouzndkyen11}</td><td>（中継用）前納残高（円貨）１１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyzennouzndkgaika11 ztyzennouzndkgaika11}</td><td>（中継用）前納残高１１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyenhrkgkgoukei11 ztyyenhrkgkgoukei11}</td><td>（中継用）円貨払込額の合計（円貨）１１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykihrkmp11 ztykihrkmp11}</td><td>（中継用）既払込保険料１１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyw11 ztyw11}</td><td>（中継用）解約返戻金１１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtywyenyendaka11 ztywyenyendaka11}</td><td>（中継用）解約返戻金（円貨）円高１１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtywyenkijun11 ztywyenkijun11}</td><td>（中継用）解約返戻金（円貨）中央値１１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtywyenyenyasu11 ztywyenyenyasu11}</td><td>（中継用）解約返戻金（円貨）円安１１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykaiykuktgk11 ztykaiykuktgk11}</td><td>（中継用）解約時受取額１１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykaiykuktgkyenyendaka11 ztykaiykuktgkyenyendaka11}</td><td>（中継用）解約時受取額（円貨）円高１１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykaiykuktgkyenkijun11 ztykaiykuktgkyenkijun11}</td><td>（中継用）解約時受取額（円貨）中央値１１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykaiykuktgkyenyenyasu11 ztykaiykuktgkyenyenyasu11}</td><td>（中継用）解約時受取額（円貨）円安１１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykeikanensuu12 ztykeikanensuu12}</td><td>（中継用）経過年数１２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhrkkknmnryumukbn12 ztyhrkkknmnryumukbn12}</td><td>（中継用）払込期間満了有無区分１２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyzennouzndkyen12 ztyzennouzndkyen12}</td><td>（中継用）前納残高（円貨）１２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyzennouzndkgaika12 ztyzennouzndkgaika12}</td><td>（中継用）前納残高１２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyenhrkgkgoukei12 ztyyenhrkgkgoukei12}</td><td>（中継用）円貨払込額の合計（円貨）１２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykihrkmp12 ztykihrkmp12}</td><td>（中継用）既払込保険料１２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyw12 ztyw12}</td><td>（中継用）解約返戻金１２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtywyenyendaka12 ztywyenyendaka12}</td><td>（中継用）解約返戻金（円貨）円高１２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtywyenkijun12 ztywyenkijun12}</td><td>（中継用）解約返戻金（円貨）中央値１２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtywyenyenyasu12 ztywyenyenyasu12}</td><td>（中継用）解約返戻金（円貨）円安１２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykaiykuktgk12 ztykaiykuktgk12}</td><td>（中継用）解約時受取額１２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykaiykuktgkyenyendaka12 ztykaiykuktgkyenyendaka12}</td><td>（中継用）解約時受取額（円貨）円高１２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykaiykuktgkyenkijun12 ztykaiykuktgkyenkijun12}</td><td>（中継用）解約時受取額（円貨）中央値１２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykaiykuktgkyenyenyasu12 ztykaiykuktgkyenyenyasu12}</td><td>（中継用）解約時受取額（円貨）円安１２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykeikanensuu13 ztykeikanensuu13}</td><td>（中継用）経過年数１３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhrkkknmnryumukbn13 ztyhrkkknmnryumukbn13}</td><td>（中継用）払込期間満了有無区分１３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyzennouzndkyen13 ztyzennouzndkyen13}</td><td>（中継用）前納残高（円貨）１３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyzennouzndkgaika13 ztyzennouzndkgaika13}</td><td>（中継用）前納残高１３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyenhrkgkgoukei13 ztyyenhrkgkgoukei13}</td><td>（中継用）円貨払込額の合計（円貨）１３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykihrkmp13 ztykihrkmp13}</td><td>（中継用）既払込保険料１３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyw13 ztyw13}</td><td>（中継用）解約返戻金１３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtywyenyendaka13 ztywyenyendaka13}</td><td>（中継用）解約返戻金（円貨）円高１３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtywyenkijun13 ztywyenkijun13}</td><td>（中継用）解約返戻金（円貨）中央値１３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtywyenyenyasu13 ztywyenyenyasu13}</td><td>（中継用）解約返戻金（円貨）円安１３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykaiykuktgk13 ztykaiykuktgk13}</td><td>（中継用）解約時受取額１３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykaiykuktgkyenyendaka13 ztykaiykuktgkyenyendaka13}</td><td>（中継用）解約時受取額（円貨）円高１３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykaiykuktgkyenkijun13 ztykaiykuktgkyenkijun13}</td><td>（中継用）解約時受取額（円貨）中央値１３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykaiykuktgkyenyenyasu13 ztykaiykuktgkyenyenyasu13}</td><td>（中継用）解約時受取額（円貨）円安１３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykeikanensuu14 ztykeikanensuu14}</td><td>（中継用）経過年数１４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhrkkknmnryumukbn14 ztyhrkkknmnryumukbn14}</td><td>（中継用）払込期間満了有無区分１４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyzennouzndkyen14 ztyzennouzndkyen14}</td><td>（中継用）前納残高（円貨）１４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyzennouzndkgaika14 ztyzennouzndkgaika14}</td><td>（中継用）前納残高１４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyenhrkgkgoukei14 ztyyenhrkgkgoukei14}</td><td>（中継用）円貨払込額の合計（円貨）１４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykihrkmp14 ztykihrkmp14}</td><td>（中継用）既払込保険料１４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyw14 ztyw14}</td><td>（中継用）解約返戻金１４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtywyenyendaka14 ztywyenyendaka14}</td><td>（中継用）解約返戻金（円貨）円高１４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtywyenkijun14 ztywyenkijun14}</td><td>（中継用）解約返戻金（円貨）中央値１４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtywyenyenyasu14 ztywyenyenyasu14}</td><td>（中継用）解約返戻金（円貨）円安１４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykaiykuktgk14 ztykaiykuktgk14}</td><td>（中継用）解約時受取額１４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykaiykuktgkyenyendaka14 ztykaiykuktgkyenyendaka14}</td><td>（中継用）解約時受取額（円貨）円高１４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykaiykuktgkyenkijun14 ztykaiykuktgkyenkijun14}</td><td>（中継用）解約時受取額（円貨）中央値１４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykaiykuktgkyenyenyasu14 ztykaiykuktgkyenyenyasu14}</td><td>（中継用）解約時受取額（円貨）円安１４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykeikanensuu15 ztykeikanensuu15}</td><td>（中継用）経過年数１５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhrkkknmnryumukbn15 ztyhrkkknmnryumukbn15}</td><td>（中継用）払込期間満了有無区分１５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyzennouzndkyen15 ztyzennouzndkyen15}</td><td>（中継用）前納残高（円貨）１５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyzennouzndkgaika15 ztyzennouzndkgaika15}</td><td>（中継用）前納残高１５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyenhrkgkgoukei15 ztyyenhrkgkgoukei15}</td><td>（中継用）円貨払込額の合計（円貨）１５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykihrkmp15 ztykihrkmp15}</td><td>（中継用）既払込保険料１５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyw15 ztyw15}</td><td>（中継用）解約返戻金１５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtywyenyendaka15 ztywyenyendaka15}</td><td>（中継用）解約返戻金（円貨）円高１５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtywyenkijun15 ztywyenkijun15}</td><td>（中継用）解約返戻金（円貨）中央値１５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtywyenyenyasu15 ztywyenyenyasu15}</td><td>（中継用）解約返戻金（円貨）円安１５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykaiykuktgk15 ztykaiykuktgk15}</td><td>（中継用）解約時受取額１５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykaiykuktgkyenyendaka15 ztykaiykuktgkyenyendaka15}</td><td>（中継用）解約時受取額（円貨）円高１５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykaiykuktgkyenkijun15 ztykaiykuktgkyenkijun15}</td><td>（中継用）解約時受取額（円貨）中央値１５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykaiykuktgkyenyenyasu15 ztykaiykuktgkyenyenyasu15}</td><td>（中継用）解約時受取額（円貨）円安１５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykeikanensuu16 ztykeikanensuu16}</td><td>（中継用）経過年数１６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhrkkknmnryumukbn16 ztyhrkkknmnryumukbn16}</td><td>（中継用）払込期間満了有無区分１６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyzennouzndkyen16 ztyzennouzndkyen16}</td><td>（中継用）前納残高（円貨）１６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyzennouzndkgaika16 ztyzennouzndkgaika16}</td><td>（中継用）前納残高１６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyenhrkgkgoukei16 ztyyenhrkgkgoukei16}</td><td>（中継用）円貨払込額の合計（円貨）１６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykihrkmp16 ztykihrkmp16}</td><td>（中継用）既払込保険料１６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyw16 ztyw16}</td><td>（中継用）解約返戻金１６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtywyenyendaka16 ztywyenyendaka16}</td><td>（中継用）解約返戻金（円貨）円高１６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtywyenkijun16 ztywyenkijun16}</td><td>（中継用）解約返戻金（円貨）中央値１６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtywyenyenyasu16 ztywyenyenyasu16}</td><td>（中継用）解約返戻金（円貨）円安１６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykaiykuktgk16 ztykaiykuktgk16}</td><td>（中継用）解約時受取額１６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykaiykuktgkyenyendaka16 ztykaiykuktgkyenyendaka16}</td><td>（中継用）解約時受取額（円貨）円高１６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykaiykuktgkyenkijun16 ztykaiykuktgkyenkijun16}</td><td>（中継用）解約時受取額（円貨）中央値１６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykaiykuktgkyenyenyasu16 ztykaiykuktgkyenyenyasu16}</td><td>（中継用）解約時受取額（円貨）円安１６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykeikanensuu17 ztykeikanensuu17}</td><td>（中継用）経過年数１７</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhrkkknmnryumukbn17 ztyhrkkknmnryumukbn17}</td><td>（中継用）払込期間満了有無区分１７</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyzennouzndkyen17 ztyzennouzndkyen17}</td><td>（中継用）前納残高（円貨）１７</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyzennouzndkgaika17 ztyzennouzndkgaika17}</td><td>（中継用）前納残高１７</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyenhrkgkgoukei17 ztyyenhrkgkgoukei17}</td><td>（中継用）円貨払込額の合計（円貨）１７</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykihrkmp17 ztykihrkmp17}</td><td>（中継用）既払込保険料１７</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyw17 ztyw17}</td><td>（中継用）解約返戻金１７</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtywyenyendaka17 ztywyenyendaka17}</td><td>（中継用）解約返戻金（円貨）円高１７</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtywyenkijun17 ztywyenkijun17}</td><td>（中継用）解約返戻金（円貨）中央値１７</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtywyenyenyasu17 ztywyenyenyasu17}</td><td>（中継用）解約返戻金（円貨）円安１７</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykaiykuktgk17 ztykaiykuktgk17}</td><td>（中継用）解約時受取額１７</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykaiykuktgkyenyendaka17 ztykaiykuktgkyenyendaka17}</td><td>（中継用）解約時受取額（円貨）円高１７</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykaiykuktgkyenkijun17 ztykaiykuktgkyenkijun17}</td><td>（中継用）解約時受取額（円貨）中央値１７</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykaiykuktgkyenyenyasu17 ztykaiykuktgkyenyenyasu17}</td><td>（中継用）解約時受取額（円貨）円安１７</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykeikanensuu18 ztykeikanensuu18}</td><td>（中継用）経過年数１８</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhrkkknmnryumukbn18 ztyhrkkknmnryumukbn18}</td><td>（中継用）払込期間満了有無区分１８</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyzennouzndkyen18 ztyzennouzndkyen18}</td><td>（中継用）前納残高（円貨）１８</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyzennouzndkgaika18 ztyzennouzndkgaika18}</td><td>（中継用）前納残高１８</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyenhrkgkgoukei18 ztyyenhrkgkgoukei18}</td><td>（中継用）円貨払込額の合計（円貨）１８</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykihrkmp18 ztykihrkmp18}</td><td>（中継用）既払込保険料１８</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyw18 ztyw18}</td><td>（中継用）解約返戻金１８</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtywyenyendaka18 ztywyenyendaka18}</td><td>（中継用）解約返戻金（円貨）円高１８</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtywyenkijun18 ztywyenkijun18}</td><td>（中継用）解約返戻金（円貨）中央値１８</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtywyenyenyasu18 ztywyenyenyasu18}</td><td>（中継用）解約返戻金（円貨）円安１８</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykaiykuktgk18 ztykaiykuktgk18}</td><td>（中継用）解約時受取額１８</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykaiykuktgkyenyendaka18 ztykaiykuktgkyenyendaka18}</td><td>（中継用）解約時受取額（円貨）円高１８</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykaiykuktgkyenkijun18 ztykaiykuktgkyenkijun18}</td><td>（中継用）解約時受取額（円貨）中央値１８</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykaiykuktgkyenyenyasu18 ztykaiykuktgkyenyenyasu18}</td><td>（中継用）解約時受取額（円貨）円安１８</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykeikanensuu19 ztykeikanensuu19}</td><td>（中継用）経過年数１９</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhrkkknmnryumukbn19 ztyhrkkknmnryumukbn19}</td><td>（中継用）払込期間満了有無区分１９</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyzennouzndkyen19 ztyzennouzndkyen19}</td><td>（中継用）前納残高（円貨）１９</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyzennouzndkgaika19 ztyzennouzndkgaika19}</td><td>（中継用）前納残高１９</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyenhrkgkgoukei19 ztyyenhrkgkgoukei19}</td><td>（中継用）円貨払込額の合計（円貨）１９</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykihrkmp19 ztykihrkmp19}</td><td>（中継用）既払込保険料１９</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyw19 ztyw19}</td><td>（中継用）解約返戻金１９</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtywyenyendaka19 ztywyenyendaka19}</td><td>（中継用）解約返戻金（円貨）円高１９</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtywyenkijun19 ztywyenkijun19}</td><td>（中継用）解約返戻金（円貨）中央値１９</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtywyenyenyasu19 ztywyenyenyasu19}</td><td>（中継用）解約返戻金（円貨）円安１９</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykaiykuktgk19 ztykaiykuktgk19}</td><td>（中継用）解約時受取額１９</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykaiykuktgkyenyendaka19 ztykaiykuktgkyenyendaka19}</td><td>（中継用）解約時受取額（円貨）円高１９</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykaiykuktgkyenkijun19 ztykaiykuktgkyenkijun19}</td><td>（中継用）解約時受取額（円貨）中央値１９</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykaiykuktgkyenyenyasu19 ztykaiykuktgkyenyenyasu19}</td><td>（中継用）解約時受取額（円貨）円安１９</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykeikanensuu20 ztykeikanensuu20}</td><td>（中継用）経過年数２０</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhrkkknmnryumukbn20 ztyhrkkknmnryumukbn20}</td><td>（中継用）払込期間満了有無区分２０</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyzennouzndkyen20 ztyzennouzndkyen20}</td><td>（中継用）前納残高（円貨）２０</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyzennouzndkgaika20 ztyzennouzndkgaika20}</td><td>（中継用）前納残高２０</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyenhrkgkgoukei20 ztyyenhrkgkgoukei20}</td><td>（中継用）円貨払込額の合計（円貨）２０</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykihrkmp20 ztykihrkmp20}</td><td>（中継用）既払込保険料２０</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyw20 ztyw20}</td><td>（中継用）解約返戻金２０</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtywyenyendaka20 ztywyenyendaka20}</td><td>（中継用）解約返戻金（円貨）円高２０</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtywyenkijun20 ztywyenkijun20}</td><td>（中継用）解約返戻金（円貨）中央値２０</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtywyenyenyasu20 ztywyenyenyasu20}</td><td>（中継用）解約返戻金（円貨）円安２０</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykaiykuktgk20 ztykaiykuktgk20}</td><td>（中継用）解約時受取額２０</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykaiykuktgkyenyendaka20 ztykaiykuktgkyenyendaka20}</td><td>（中継用）解約時受取額（円貨）円高２０</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykaiykuktgkyenkijun20 ztykaiykuktgkyenkijun20}</td><td>（中継用）解約時受取額（円貨）中央値２０</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykaiykuktgkyenyenyasu20 ztykaiykuktgkyenyenyasu20}</td><td>（中継用）解約時受取額（円貨）円安２０</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykeikanensuu21 ztykeikanensuu21}</td><td>（中継用）経過年数２１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhrkkknmnryumukbn21 ztyhrkkknmnryumukbn21}</td><td>（中継用）払込期間満了有無区分２１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyzennouzndkyen21 ztyzennouzndkyen21}</td><td>（中継用）前納残高（円貨）２１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyzennouzndkgaika21 ztyzennouzndkgaika21}</td><td>（中継用）前納残高２１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyenhrkgkgoukei21 ztyyenhrkgkgoukei21}</td><td>（中継用）円貨払込額の合計（円貨）２１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykihrkmp21 ztykihrkmp21}</td><td>（中継用）既払込保険料２１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyw21 ztyw21}</td><td>（中継用）解約返戻金２１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtywyenyendaka21 ztywyenyendaka21}</td><td>（中継用）解約返戻金（円貨）円高２１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtywyenkijun21 ztywyenkijun21}</td><td>（中継用）解約返戻金（円貨）中央値２１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtywyenyenyasu21 ztywyenyenyasu21}</td><td>（中継用）解約返戻金（円貨）円安２１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykaiykuktgk21 ztykaiykuktgk21}</td><td>（中継用）解約時受取額２１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykaiykuktgkyenyendaka21 ztykaiykuktgkyenyendaka21}</td><td>（中継用）解約時受取額（円貨）円高２１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykaiykuktgkyenkijun21 ztykaiykuktgkyenkijun21}</td><td>（中継用）解約時受取額（円貨）中央値２１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykaiykuktgkyenyenyasu21 ztykaiykuktgkyenyenyasu21}</td><td>（中継用）解約時受取額（円貨）円安２１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykeikanensuu22 ztykeikanensuu22}</td><td>（中継用）経過年数２２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhrkkknmnryumukbn22 ztyhrkkknmnryumukbn22}</td><td>（中継用）払込期間満了有無区分２２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyzennouzndkyen22 ztyzennouzndkyen22}</td><td>（中継用）前納残高（円貨）２２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyzennouzndkgaika22 ztyzennouzndkgaika22}</td><td>（中継用）前納残高２２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyenhrkgkgoukei22 ztyyenhrkgkgoukei22}</td><td>（中継用）円貨払込額の合計（円貨）２２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykihrkmp22 ztykihrkmp22}</td><td>（中継用）既払込保険料２２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyw22 ztyw22}</td><td>（中継用）解約返戻金２２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtywyenyendaka22 ztywyenyendaka22}</td><td>（中継用）解約返戻金（円貨）円高２２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtywyenkijun22 ztywyenkijun22}</td><td>（中継用）解約返戻金（円貨）中央値２２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtywyenyenyasu22 ztywyenyenyasu22}</td><td>（中継用）解約返戻金（円貨）円安２２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykaiykuktgk22 ztykaiykuktgk22}</td><td>（中継用）解約時受取額２２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykaiykuktgkyenyendaka22 ztykaiykuktgkyenyendaka22}</td><td>（中継用）解約時受取額（円貨）円高２２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykaiykuktgkyenkijun22 ztykaiykuktgkyenkijun22}</td><td>（中継用）解約時受取額（円貨）中央値２２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykaiykuktgkyenyenyasu22 ztykaiykuktgkyenyenyasu22}</td><td>（中継用）解約時受取額（円貨）円安２２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv196 ztyyobiv196}</td><td>（中継用）予備項目Ｖ１９６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv4 ztyyobiv4}</td><td>（中継用）予備項目Ｖ４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     ZT_SinkeiyakuSyoukenSuii2Ty
 * @see     PKZT_SinkeiyakuSyoukenSuii2Ty
 * @see     QZT_SinkeiyakuSyoukenSuii2Ty
 * @see     GenQZT_SinkeiyakuSyoukenSuii2Ty
 */
@MappedSuperclass
@Table(name=GenZT_SinkeiyakuSyoukenSuii2Ty.TABLE_NAME)
@IdClass(value=PKZT_SinkeiyakuSyoukenSuii2Ty.class)
public abstract class GenZT_SinkeiyakuSyoukenSuii2Ty extends AbstractExDBEntity<ZT_SinkeiyakuSyoukenSuii2Ty, PKZT_SinkeiyakuSyoukenSuii2Ty> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "ZT_SinkeiyakuSyoukenSuii2Ty";
    public static final String ZTYSYONO                 = "ztysyono";
    public static final String ZTYTYOUHYOUYMD           = "ztytyouhyouymd";
    public static final String ZTYSUIIHYOUPTN           = "ztysuiihyouptn";
    public static final String ZTYSUIIHYOUSYKBN         = "ztysuiihyousykbn";
    public static final String ZTYSUIIHYOUSYONO         = "ztysuiihyousyono";
    public static final String ZTYYTIRRTCALCKIJYUNRRT   = "ztyytirrtcalckijyunrrt";
    public static final String ZTYWKWSRATEYENDAKA       = "ztywkwsrateyendaka";
    public static final String ZTYWKWSRATEYENKIJYUN     = "ztywkwsrateyenkijyun";
    public static final String ZTYWKWSRATEYENYASU       = "ztywkwsrateyenyasu";
    public static final String ZTYKYKTUUKATYPE          = "ztykyktuukatype";
    public static final String ZTYKEIKANENSUU01         = "ztykeikanensuu01";
    public static final String ZTYHRKKKNMNRYUMUKBN01    = "ztyhrkkknmnryumukbn01";
    public static final String ZTYZENNOUZNDKYEN01       = "ztyzennouzndkyen01";
    public static final String ZTYZENNOUZNDKGAIKA01     = "ztyzennouzndkgaika01";
    public static final String ZTYYENHRKGKGOUKEI01      = "ztyyenhrkgkgoukei01";
    public static final String ZTYKIHRKMP01             = "ztykihrkmp01";
    public static final String ZTYW01                   = "ztyw01";
    public static final String ZTYWYENYENDAKA01         = "ztywyenyendaka01";
    public static final String ZTYWYENKIJUN01           = "ztywyenkijun01";
    public static final String ZTYWYENYENYASU01         = "ztywyenyenyasu01";
    public static final String ZTYKAIYKUKTGK01          = "ztykaiykuktgk01";
    public static final String ZTYKAIYKUKTGKYENYENDAKA01 = "ztykaiykuktgkyenyendaka01";
    public static final String ZTYKAIYKUKTGKYENKIJUN01  = "ztykaiykuktgkyenkijun01";
    public static final String ZTYKAIYKUKTGKYENYENYASU01 = "ztykaiykuktgkyenyenyasu01";
    public static final String ZTYKEIKANENSUU02         = "ztykeikanensuu02";
    public static final String ZTYHRKKKNMNRYUMUKBN02    = "ztyhrkkknmnryumukbn02";
    public static final String ZTYZENNOUZNDKYEN02       = "ztyzennouzndkyen02";
    public static final String ZTYZENNOUZNDKGAIKA02     = "ztyzennouzndkgaika02";
    public static final String ZTYYENHRKGKGOUKEI02      = "ztyyenhrkgkgoukei02";
    public static final String ZTYKIHRKMP02             = "ztykihrkmp02";
    public static final String ZTYW02                   = "ztyw02";
    public static final String ZTYWYENYENDAKA02         = "ztywyenyendaka02";
    public static final String ZTYWYENKIJUN02           = "ztywyenkijun02";
    public static final String ZTYWYENYENYASU02         = "ztywyenyenyasu02";
    public static final String ZTYKAIYKUKTGK02          = "ztykaiykuktgk02";
    public static final String ZTYKAIYKUKTGKYENYENDAKA02 = "ztykaiykuktgkyenyendaka02";
    public static final String ZTYKAIYKUKTGKYENKIJUN02  = "ztykaiykuktgkyenkijun02";
    public static final String ZTYKAIYKUKTGKYENYENYASU02 = "ztykaiykuktgkyenyenyasu02";
    public static final String ZTYKEIKANENSUU03         = "ztykeikanensuu03";
    public static final String ZTYHRKKKNMNRYUMUKBN03    = "ztyhrkkknmnryumukbn03";
    public static final String ZTYZENNOUZNDKYEN03       = "ztyzennouzndkyen03";
    public static final String ZTYZENNOUZNDKGAIKA03     = "ztyzennouzndkgaika03";
    public static final String ZTYYENHRKGKGOUKEI03      = "ztyyenhrkgkgoukei03";
    public static final String ZTYKIHRKMP03             = "ztykihrkmp03";
    public static final String ZTYW03                   = "ztyw03";
    public static final String ZTYWYENYENDAKA03         = "ztywyenyendaka03";
    public static final String ZTYWYENKIJUN03           = "ztywyenkijun03";
    public static final String ZTYWYENYENYASU03         = "ztywyenyenyasu03";
    public static final String ZTYKAIYKUKTGK03          = "ztykaiykuktgk03";
    public static final String ZTYKAIYKUKTGKYENYENDAKA03 = "ztykaiykuktgkyenyendaka03";
    public static final String ZTYKAIYKUKTGKYENKIJUN03  = "ztykaiykuktgkyenkijun03";
    public static final String ZTYKAIYKUKTGKYENYENYASU03 = "ztykaiykuktgkyenyenyasu03";
    public static final String ZTYKEIKANENSUU04         = "ztykeikanensuu04";
    public static final String ZTYHRKKKNMNRYUMUKBN04    = "ztyhrkkknmnryumukbn04";
    public static final String ZTYZENNOUZNDKYEN04       = "ztyzennouzndkyen04";
    public static final String ZTYZENNOUZNDKGAIKA04     = "ztyzennouzndkgaika04";
    public static final String ZTYYENHRKGKGOUKEI04      = "ztyyenhrkgkgoukei04";
    public static final String ZTYKIHRKMP04             = "ztykihrkmp04";
    public static final String ZTYW04                   = "ztyw04";
    public static final String ZTYWYENYENDAKA04         = "ztywyenyendaka04";
    public static final String ZTYWYENKIJUN04           = "ztywyenkijun04";
    public static final String ZTYWYENYENYASU04         = "ztywyenyenyasu04";
    public static final String ZTYKAIYKUKTGK04          = "ztykaiykuktgk04";
    public static final String ZTYKAIYKUKTGKYENYENDAKA04 = "ztykaiykuktgkyenyendaka04";
    public static final String ZTYKAIYKUKTGKYENKIJUN04  = "ztykaiykuktgkyenkijun04";
    public static final String ZTYKAIYKUKTGKYENYENYASU04 = "ztykaiykuktgkyenyenyasu04";
    public static final String ZTYKEIKANENSUU05         = "ztykeikanensuu05";
    public static final String ZTYHRKKKNMNRYUMUKBN05    = "ztyhrkkknmnryumukbn05";
    public static final String ZTYZENNOUZNDKYEN05       = "ztyzennouzndkyen05";
    public static final String ZTYZENNOUZNDKGAIKA05     = "ztyzennouzndkgaika05";
    public static final String ZTYYENHRKGKGOUKEI05      = "ztyyenhrkgkgoukei05";
    public static final String ZTYKIHRKMP05             = "ztykihrkmp05";
    public static final String ZTYW05                   = "ztyw05";
    public static final String ZTYWYENYENDAKA05         = "ztywyenyendaka05";
    public static final String ZTYWYENKIJUN05           = "ztywyenkijun05";
    public static final String ZTYWYENYENYASU05         = "ztywyenyenyasu05";
    public static final String ZTYKAIYKUKTGK05          = "ztykaiykuktgk05";
    public static final String ZTYKAIYKUKTGKYENYENDAKA05 = "ztykaiykuktgkyenyendaka05";
    public static final String ZTYKAIYKUKTGKYENKIJUN05  = "ztykaiykuktgkyenkijun05";
    public static final String ZTYKAIYKUKTGKYENYENYASU05 = "ztykaiykuktgkyenyenyasu05";
    public static final String ZTYKEIKANENSUU06         = "ztykeikanensuu06";
    public static final String ZTYHRKKKNMNRYUMUKBN06    = "ztyhrkkknmnryumukbn06";
    public static final String ZTYZENNOUZNDKYEN06       = "ztyzennouzndkyen06";
    public static final String ZTYZENNOUZNDKGAIKA06     = "ztyzennouzndkgaika06";
    public static final String ZTYYENHRKGKGOUKEI06      = "ztyyenhrkgkgoukei06";
    public static final String ZTYKIHRKMP06             = "ztykihrkmp06";
    public static final String ZTYW06                   = "ztyw06";
    public static final String ZTYWYENYENDAKA06         = "ztywyenyendaka06";
    public static final String ZTYWYENKIJUN06           = "ztywyenkijun06";
    public static final String ZTYWYENYENYASU06         = "ztywyenyenyasu06";
    public static final String ZTYKAIYKUKTGK06          = "ztykaiykuktgk06";
    public static final String ZTYKAIYKUKTGKYENYENDAKA06 = "ztykaiykuktgkyenyendaka06";
    public static final String ZTYKAIYKUKTGKYENKIJUN06  = "ztykaiykuktgkyenkijun06";
    public static final String ZTYKAIYKUKTGKYENYENYASU06 = "ztykaiykuktgkyenyenyasu06";
    public static final String ZTYKEIKANENSUU07         = "ztykeikanensuu07";
    public static final String ZTYHRKKKNMNRYUMUKBN07    = "ztyhrkkknmnryumukbn07";
    public static final String ZTYZENNOUZNDKYEN07       = "ztyzennouzndkyen07";
    public static final String ZTYZENNOUZNDKGAIKA07     = "ztyzennouzndkgaika07";
    public static final String ZTYYENHRKGKGOUKEI07      = "ztyyenhrkgkgoukei07";
    public static final String ZTYKIHRKMP07             = "ztykihrkmp07";
    public static final String ZTYW07                   = "ztyw07";
    public static final String ZTYWYENYENDAKA07         = "ztywyenyendaka07";
    public static final String ZTYWYENKIJUN07           = "ztywyenkijun07";
    public static final String ZTYWYENYENYASU07         = "ztywyenyenyasu07";
    public static final String ZTYKAIYKUKTGK07          = "ztykaiykuktgk07";
    public static final String ZTYKAIYKUKTGKYENYENDAKA07 = "ztykaiykuktgkyenyendaka07";
    public static final String ZTYKAIYKUKTGKYENKIJUN07  = "ztykaiykuktgkyenkijun07";
    public static final String ZTYKAIYKUKTGKYENYENYASU07 = "ztykaiykuktgkyenyenyasu07";
    public static final String ZTYKEIKANENSUU08         = "ztykeikanensuu08";
    public static final String ZTYHRKKKNMNRYUMUKBN08    = "ztyhrkkknmnryumukbn08";
    public static final String ZTYZENNOUZNDKYEN08       = "ztyzennouzndkyen08";
    public static final String ZTYZENNOUZNDKGAIKA08     = "ztyzennouzndkgaika08";
    public static final String ZTYYENHRKGKGOUKEI08      = "ztyyenhrkgkgoukei08";
    public static final String ZTYKIHRKMP08             = "ztykihrkmp08";
    public static final String ZTYW08                   = "ztyw08";
    public static final String ZTYWYENYENDAKA08         = "ztywyenyendaka08";
    public static final String ZTYWYENKIJUN08           = "ztywyenkijun08";
    public static final String ZTYWYENYENYASU08         = "ztywyenyenyasu08";
    public static final String ZTYKAIYKUKTGK08          = "ztykaiykuktgk08";
    public static final String ZTYKAIYKUKTGKYENYENDAKA08 = "ztykaiykuktgkyenyendaka08";
    public static final String ZTYKAIYKUKTGKYENKIJUN08  = "ztykaiykuktgkyenkijun08";
    public static final String ZTYKAIYKUKTGKYENYENYASU08 = "ztykaiykuktgkyenyenyasu08";
    public static final String ZTYKEIKANENSUU09         = "ztykeikanensuu09";
    public static final String ZTYHRKKKNMNRYUMUKBN09    = "ztyhrkkknmnryumukbn09";
    public static final String ZTYZENNOUZNDKYEN09       = "ztyzennouzndkyen09";
    public static final String ZTYZENNOUZNDKGAIKA09     = "ztyzennouzndkgaika09";
    public static final String ZTYYENHRKGKGOUKEI09      = "ztyyenhrkgkgoukei09";
    public static final String ZTYKIHRKMP09             = "ztykihrkmp09";
    public static final String ZTYW09                   = "ztyw09";
    public static final String ZTYWYENYENDAKA09         = "ztywyenyendaka09";
    public static final String ZTYWYENKIJUN09           = "ztywyenkijun09";
    public static final String ZTYWYENYENYASU09         = "ztywyenyenyasu09";
    public static final String ZTYKAIYKUKTGK09          = "ztykaiykuktgk09";
    public static final String ZTYKAIYKUKTGKYENYENDAKA09 = "ztykaiykuktgkyenyendaka09";
    public static final String ZTYKAIYKUKTGKYENKIJUN09  = "ztykaiykuktgkyenkijun09";
    public static final String ZTYKAIYKUKTGKYENYENYASU09 = "ztykaiykuktgkyenyenyasu09";
    public static final String ZTYKEIKANENSUU10         = "ztykeikanensuu10";
    public static final String ZTYHRKKKNMNRYUMUKBN10    = "ztyhrkkknmnryumukbn10";
    public static final String ZTYZENNOUZNDKYEN10       = "ztyzennouzndkyen10";
    public static final String ZTYZENNOUZNDKGAIKA10     = "ztyzennouzndkgaika10";
    public static final String ZTYYENHRKGKGOUKEI10      = "ztyyenhrkgkgoukei10";
    public static final String ZTYKIHRKMP10             = "ztykihrkmp10";
    public static final String ZTYW10                   = "ztyw10";
    public static final String ZTYWYENYENDAKA10         = "ztywyenyendaka10";
    public static final String ZTYWYENKIJUN10           = "ztywyenkijun10";
    public static final String ZTYWYENYENYASU10         = "ztywyenyenyasu10";
    public static final String ZTYKAIYKUKTGK10          = "ztykaiykuktgk10";
    public static final String ZTYKAIYKUKTGKYENYENDAKA10 = "ztykaiykuktgkyenyendaka10";
    public static final String ZTYKAIYKUKTGKYENKIJUN10  = "ztykaiykuktgkyenkijun10";
    public static final String ZTYKAIYKUKTGKYENYENYASU10 = "ztykaiykuktgkyenyenyasu10";
    public static final String ZTYKEIKANENSUU11         = "ztykeikanensuu11";
    public static final String ZTYHRKKKNMNRYUMUKBN11    = "ztyhrkkknmnryumukbn11";
    public static final String ZTYZENNOUZNDKYEN11       = "ztyzennouzndkyen11";
    public static final String ZTYZENNOUZNDKGAIKA11     = "ztyzennouzndkgaika11";
    public static final String ZTYYENHRKGKGOUKEI11      = "ztyyenhrkgkgoukei11";
    public static final String ZTYKIHRKMP11             = "ztykihrkmp11";
    public static final String ZTYW11                   = "ztyw11";
    public static final String ZTYWYENYENDAKA11         = "ztywyenyendaka11";
    public static final String ZTYWYENKIJUN11           = "ztywyenkijun11";
    public static final String ZTYWYENYENYASU11         = "ztywyenyenyasu11";
    public static final String ZTYKAIYKUKTGK11          = "ztykaiykuktgk11";
    public static final String ZTYKAIYKUKTGKYENYENDAKA11 = "ztykaiykuktgkyenyendaka11";
    public static final String ZTYKAIYKUKTGKYENKIJUN11  = "ztykaiykuktgkyenkijun11";
    public static final String ZTYKAIYKUKTGKYENYENYASU11 = "ztykaiykuktgkyenyenyasu11";
    public static final String ZTYKEIKANENSUU12         = "ztykeikanensuu12";
    public static final String ZTYHRKKKNMNRYUMUKBN12    = "ztyhrkkknmnryumukbn12";
    public static final String ZTYZENNOUZNDKYEN12       = "ztyzennouzndkyen12";
    public static final String ZTYZENNOUZNDKGAIKA12     = "ztyzennouzndkgaika12";
    public static final String ZTYYENHRKGKGOUKEI12      = "ztyyenhrkgkgoukei12";
    public static final String ZTYKIHRKMP12             = "ztykihrkmp12";
    public static final String ZTYW12                   = "ztyw12";
    public static final String ZTYWYENYENDAKA12         = "ztywyenyendaka12";
    public static final String ZTYWYENKIJUN12           = "ztywyenkijun12";
    public static final String ZTYWYENYENYASU12         = "ztywyenyenyasu12";
    public static final String ZTYKAIYKUKTGK12          = "ztykaiykuktgk12";
    public static final String ZTYKAIYKUKTGKYENYENDAKA12 = "ztykaiykuktgkyenyendaka12";
    public static final String ZTYKAIYKUKTGKYENKIJUN12  = "ztykaiykuktgkyenkijun12";
    public static final String ZTYKAIYKUKTGKYENYENYASU12 = "ztykaiykuktgkyenyenyasu12";
    public static final String ZTYKEIKANENSUU13         = "ztykeikanensuu13";
    public static final String ZTYHRKKKNMNRYUMUKBN13    = "ztyhrkkknmnryumukbn13";
    public static final String ZTYZENNOUZNDKYEN13       = "ztyzennouzndkyen13";
    public static final String ZTYZENNOUZNDKGAIKA13     = "ztyzennouzndkgaika13";
    public static final String ZTYYENHRKGKGOUKEI13      = "ztyyenhrkgkgoukei13";
    public static final String ZTYKIHRKMP13             = "ztykihrkmp13";
    public static final String ZTYW13                   = "ztyw13";
    public static final String ZTYWYENYENDAKA13         = "ztywyenyendaka13";
    public static final String ZTYWYENKIJUN13           = "ztywyenkijun13";
    public static final String ZTYWYENYENYASU13         = "ztywyenyenyasu13";
    public static final String ZTYKAIYKUKTGK13          = "ztykaiykuktgk13";
    public static final String ZTYKAIYKUKTGKYENYENDAKA13 = "ztykaiykuktgkyenyendaka13";
    public static final String ZTYKAIYKUKTGKYENKIJUN13  = "ztykaiykuktgkyenkijun13";
    public static final String ZTYKAIYKUKTGKYENYENYASU13 = "ztykaiykuktgkyenyenyasu13";
    public static final String ZTYKEIKANENSUU14         = "ztykeikanensuu14";
    public static final String ZTYHRKKKNMNRYUMUKBN14    = "ztyhrkkknmnryumukbn14";
    public static final String ZTYZENNOUZNDKYEN14       = "ztyzennouzndkyen14";
    public static final String ZTYZENNOUZNDKGAIKA14     = "ztyzennouzndkgaika14";
    public static final String ZTYYENHRKGKGOUKEI14      = "ztyyenhrkgkgoukei14";
    public static final String ZTYKIHRKMP14             = "ztykihrkmp14";
    public static final String ZTYW14                   = "ztyw14";
    public static final String ZTYWYENYENDAKA14         = "ztywyenyendaka14";
    public static final String ZTYWYENKIJUN14           = "ztywyenkijun14";
    public static final String ZTYWYENYENYASU14         = "ztywyenyenyasu14";
    public static final String ZTYKAIYKUKTGK14          = "ztykaiykuktgk14";
    public static final String ZTYKAIYKUKTGKYENYENDAKA14 = "ztykaiykuktgkyenyendaka14";
    public static final String ZTYKAIYKUKTGKYENKIJUN14  = "ztykaiykuktgkyenkijun14";
    public static final String ZTYKAIYKUKTGKYENYENYASU14 = "ztykaiykuktgkyenyenyasu14";
    public static final String ZTYKEIKANENSUU15         = "ztykeikanensuu15";
    public static final String ZTYHRKKKNMNRYUMUKBN15    = "ztyhrkkknmnryumukbn15";
    public static final String ZTYZENNOUZNDKYEN15       = "ztyzennouzndkyen15";
    public static final String ZTYZENNOUZNDKGAIKA15     = "ztyzennouzndkgaika15";
    public static final String ZTYYENHRKGKGOUKEI15      = "ztyyenhrkgkgoukei15";
    public static final String ZTYKIHRKMP15             = "ztykihrkmp15";
    public static final String ZTYW15                   = "ztyw15";
    public static final String ZTYWYENYENDAKA15         = "ztywyenyendaka15";
    public static final String ZTYWYENKIJUN15           = "ztywyenkijun15";
    public static final String ZTYWYENYENYASU15         = "ztywyenyenyasu15";
    public static final String ZTYKAIYKUKTGK15          = "ztykaiykuktgk15";
    public static final String ZTYKAIYKUKTGKYENYENDAKA15 = "ztykaiykuktgkyenyendaka15";
    public static final String ZTYKAIYKUKTGKYENKIJUN15  = "ztykaiykuktgkyenkijun15";
    public static final String ZTYKAIYKUKTGKYENYENYASU15 = "ztykaiykuktgkyenyenyasu15";
    public static final String ZTYKEIKANENSUU16         = "ztykeikanensuu16";
    public static final String ZTYHRKKKNMNRYUMUKBN16    = "ztyhrkkknmnryumukbn16";
    public static final String ZTYZENNOUZNDKYEN16       = "ztyzennouzndkyen16";
    public static final String ZTYZENNOUZNDKGAIKA16     = "ztyzennouzndkgaika16";
    public static final String ZTYYENHRKGKGOUKEI16      = "ztyyenhrkgkgoukei16";
    public static final String ZTYKIHRKMP16             = "ztykihrkmp16";
    public static final String ZTYW16                   = "ztyw16";
    public static final String ZTYWYENYENDAKA16         = "ztywyenyendaka16";
    public static final String ZTYWYENKIJUN16           = "ztywyenkijun16";
    public static final String ZTYWYENYENYASU16         = "ztywyenyenyasu16";
    public static final String ZTYKAIYKUKTGK16          = "ztykaiykuktgk16";
    public static final String ZTYKAIYKUKTGKYENYENDAKA16 = "ztykaiykuktgkyenyendaka16";
    public static final String ZTYKAIYKUKTGKYENKIJUN16  = "ztykaiykuktgkyenkijun16";
    public static final String ZTYKAIYKUKTGKYENYENYASU16 = "ztykaiykuktgkyenyenyasu16";
    public static final String ZTYKEIKANENSUU17         = "ztykeikanensuu17";
    public static final String ZTYHRKKKNMNRYUMUKBN17    = "ztyhrkkknmnryumukbn17";
    public static final String ZTYZENNOUZNDKYEN17       = "ztyzennouzndkyen17";
    public static final String ZTYZENNOUZNDKGAIKA17     = "ztyzennouzndkgaika17";
    public static final String ZTYYENHRKGKGOUKEI17      = "ztyyenhrkgkgoukei17";
    public static final String ZTYKIHRKMP17             = "ztykihrkmp17";
    public static final String ZTYW17                   = "ztyw17";
    public static final String ZTYWYENYENDAKA17         = "ztywyenyendaka17";
    public static final String ZTYWYENKIJUN17           = "ztywyenkijun17";
    public static final String ZTYWYENYENYASU17         = "ztywyenyenyasu17";
    public static final String ZTYKAIYKUKTGK17          = "ztykaiykuktgk17";
    public static final String ZTYKAIYKUKTGKYENYENDAKA17 = "ztykaiykuktgkyenyendaka17";
    public static final String ZTYKAIYKUKTGKYENKIJUN17  = "ztykaiykuktgkyenkijun17";
    public static final String ZTYKAIYKUKTGKYENYENYASU17 = "ztykaiykuktgkyenyenyasu17";
    public static final String ZTYKEIKANENSUU18         = "ztykeikanensuu18";
    public static final String ZTYHRKKKNMNRYUMUKBN18    = "ztyhrkkknmnryumukbn18";
    public static final String ZTYZENNOUZNDKYEN18       = "ztyzennouzndkyen18";
    public static final String ZTYZENNOUZNDKGAIKA18     = "ztyzennouzndkgaika18";
    public static final String ZTYYENHRKGKGOUKEI18      = "ztyyenhrkgkgoukei18";
    public static final String ZTYKIHRKMP18             = "ztykihrkmp18";
    public static final String ZTYW18                   = "ztyw18";
    public static final String ZTYWYENYENDAKA18         = "ztywyenyendaka18";
    public static final String ZTYWYENKIJUN18           = "ztywyenkijun18";
    public static final String ZTYWYENYENYASU18         = "ztywyenyenyasu18";
    public static final String ZTYKAIYKUKTGK18          = "ztykaiykuktgk18";
    public static final String ZTYKAIYKUKTGKYENYENDAKA18 = "ztykaiykuktgkyenyendaka18";
    public static final String ZTYKAIYKUKTGKYENKIJUN18  = "ztykaiykuktgkyenkijun18";
    public static final String ZTYKAIYKUKTGKYENYENYASU18 = "ztykaiykuktgkyenyenyasu18";
    public static final String ZTYKEIKANENSUU19         = "ztykeikanensuu19";
    public static final String ZTYHRKKKNMNRYUMUKBN19    = "ztyhrkkknmnryumukbn19";
    public static final String ZTYZENNOUZNDKYEN19       = "ztyzennouzndkyen19";
    public static final String ZTYZENNOUZNDKGAIKA19     = "ztyzennouzndkgaika19";
    public static final String ZTYYENHRKGKGOUKEI19      = "ztyyenhrkgkgoukei19";
    public static final String ZTYKIHRKMP19             = "ztykihrkmp19";
    public static final String ZTYW19                   = "ztyw19";
    public static final String ZTYWYENYENDAKA19         = "ztywyenyendaka19";
    public static final String ZTYWYENKIJUN19           = "ztywyenkijun19";
    public static final String ZTYWYENYENYASU19         = "ztywyenyenyasu19";
    public static final String ZTYKAIYKUKTGK19          = "ztykaiykuktgk19";
    public static final String ZTYKAIYKUKTGKYENYENDAKA19 = "ztykaiykuktgkyenyendaka19";
    public static final String ZTYKAIYKUKTGKYENKIJUN19  = "ztykaiykuktgkyenkijun19";
    public static final String ZTYKAIYKUKTGKYENYENYASU19 = "ztykaiykuktgkyenyenyasu19";
    public static final String ZTYKEIKANENSUU20         = "ztykeikanensuu20";
    public static final String ZTYHRKKKNMNRYUMUKBN20    = "ztyhrkkknmnryumukbn20";
    public static final String ZTYZENNOUZNDKYEN20       = "ztyzennouzndkyen20";
    public static final String ZTYZENNOUZNDKGAIKA20     = "ztyzennouzndkgaika20";
    public static final String ZTYYENHRKGKGOUKEI20      = "ztyyenhrkgkgoukei20";
    public static final String ZTYKIHRKMP20             = "ztykihrkmp20";
    public static final String ZTYW20                   = "ztyw20";
    public static final String ZTYWYENYENDAKA20         = "ztywyenyendaka20";
    public static final String ZTYWYENKIJUN20           = "ztywyenkijun20";
    public static final String ZTYWYENYENYASU20         = "ztywyenyenyasu20";
    public static final String ZTYKAIYKUKTGK20          = "ztykaiykuktgk20";
    public static final String ZTYKAIYKUKTGKYENYENDAKA20 = "ztykaiykuktgkyenyendaka20";
    public static final String ZTYKAIYKUKTGKYENKIJUN20  = "ztykaiykuktgkyenkijun20";
    public static final String ZTYKAIYKUKTGKYENYENYASU20 = "ztykaiykuktgkyenyenyasu20";
    public static final String ZTYKEIKANENSUU21         = "ztykeikanensuu21";
    public static final String ZTYHRKKKNMNRYUMUKBN21    = "ztyhrkkknmnryumukbn21";
    public static final String ZTYZENNOUZNDKYEN21       = "ztyzennouzndkyen21";
    public static final String ZTYZENNOUZNDKGAIKA21     = "ztyzennouzndkgaika21";
    public static final String ZTYYENHRKGKGOUKEI21      = "ztyyenhrkgkgoukei21";
    public static final String ZTYKIHRKMP21             = "ztykihrkmp21";
    public static final String ZTYW21                   = "ztyw21";
    public static final String ZTYWYENYENDAKA21         = "ztywyenyendaka21";
    public static final String ZTYWYENKIJUN21           = "ztywyenkijun21";
    public static final String ZTYWYENYENYASU21         = "ztywyenyenyasu21";
    public static final String ZTYKAIYKUKTGK21          = "ztykaiykuktgk21";
    public static final String ZTYKAIYKUKTGKYENYENDAKA21 = "ztykaiykuktgkyenyendaka21";
    public static final String ZTYKAIYKUKTGKYENKIJUN21  = "ztykaiykuktgkyenkijun21";
    public static final String ZTYKAIYKUKTGKYENYENYASU21 = "ztykaiykuktgkyenyenyasu21";
    public static final String ZTYKEIKANENSUU22         = "ztykeikanensuu22";
    public static final String ZTYHRKKKNMNRYUMUKBN22    = "ztyhrkkknmnryumukbn22";
    public static final String ZTYZENNOUZNDKYEN22       = "ztyzennouzndkyen22";
    public static final String ZTYZENNOUZNDKGAIKA22     = "ztyzennouzndkgaika22";
    public static final String ZTYYENHRKGKGOUKEI22      = "ztyyenhrkgkgoukei22";
    public static final String ZTYKIHRKMP22             = "ztykihrkmp22";
    public static final String ZTYW22                   = "ztyw22";
    public static final String ZTYWYENYENDAKA22         = "ztywyenyendaka22";
    public static final String ZTYWYENKIJUN22           = "ztywyenkijun22";
    public static final String ZTYWYENYENYASU22         = "ztywyenyenyasu22";
    public static final String ZTYKAIYKUKTGK22          = "ztykaiykuktgk22";
    public static final String ZTYKAIYKUKTGKYENYENDAKA22 = "ztykaiykuktgkyenyendaka22";
    public static final String ZTYKAIYKUKTGKYENKIJUN22  = "ztykaiykuktgkyenkijun22";
    public static final String ZTYKAIYKUKTGKYENYENYASU22 = "ztykaiykuktgkyenyenyasu22";
    public static final String ZTYYOBIV196              = "ztyyobiv196";
    public static final String ZTYYOBIV4                = "ztyyobiv4";

    private final PKZT_SinkeiyakuSyoukenSuii2Ty primaryKey;

    public GenZT_SinkeiyakuSyoukenSuii2Ty() {
        primaryKey = new PKZT_SinkeiyakuSyoukenSuii2Ty();
    }

    public GenZT_SinkeiyakuSyoukenSuii2Ty(
        String pZtysyono,
        String pZtytyouhyouymd,
        String pZtysuiihyouptn
    ) {
        primaryKey = new PKZT_SinkeiyakuSyoukenSuii2Ty(
            pZtysyono,
            pZtytyouhyouymd,
            pZtysuiihyouptn
        );
    }

    @Transient
    @Override
    public PKZT_SinkeiyakuSyoukenSuii2Ty getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QZT_SinkeiyakuSyoukenSuii2Ty> getMetaClass() {
        return QZT_SinkeiyakuSyoukenSuii2Ty.class;
    }

    @Id
    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Ty.ZTYSYONO)
    public String getZtysyono() {
        return getPrimaryKey().getZtysyono();
    }

    public void setZtysyono(String pZtysyono) {
        getPrimaryKey().setZtysyono(pZtysyono);
    }

    @Id
    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Ty.ZTYTYOUHYOUYMD)
    public String getZtytyouhyouymd() {
        return getPrimaryKey().getZtytyouhyouymd();
    }

    public void setZtytyouhyouymd(String pZtytyouhyouymd) {
        getPrimaryKey().setZtytyouhyouymd(pZtytyouhyouymd);
    }

    @Id
    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Ty.ZTYSUIIHYOUPTN)
    public String getZtysuiihyouptn() {
        return getPrimaryKey().getZtysuiihyouptn();
    }

    public void setZtysuiihyouptn(String pZtysuiihyouptn) {
        getPrimaryKey().setZtysuiihyouptn(pZtysuiihyouptn);
    }

    private String ztysuiihyousykbn;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Ty.ZTYSUIIHYOUSYKBN)
    public String getZtysuiihyousykbn() {
        return ztysuiihyousykbn;
    }

    public void setZtysuiihyousykbn(String pZtysuiihyousykbn) {
        ztysuiihyousykbn = pZtysuiihyousykbn;
    }

    private String ztysuiihyousyono;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Ty.ZTYSUIIHYOUSYONO)
    public String getZtysuiihyousyono() {
        return ztysuiihyousyono;
    }

    public void setZtysuiihyousyono(String pZtysuiihyousyono) {
        ztysuiihyousyono = pZtysuiihyousyono;
    }

    private String ztyytirrtcalckijyunrrt;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Ty.ZTYYTIRRTCALCKIJYUNRRT)
    public String getZtyytirrtcalckijyunrrt() {
        return ztyytirrtcalckijyunrrt;
    }

    public void setZtyytirrtcalckijyunrrt(String pZtyytirrtcalckijyunrrt) {
        ztyytirrtcalckijyunrrt = pZtyytirrtcalckijyunrrt;
    }

    private String ztywkwsrateyendaka;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Ty.ZTYWKWSRATEYENDAKA)
    public String getZtywkwsrateyendaka() {
        return ztywkwsrateyendaka;
    }

    public void setZtywkwsrateyendaka(String pZtywkwsrateyendaka) {
        ztywkwsrateyendaka = pZtywkwsrateyendaka;
    }

    private String ztywkwsrateyenkijyun;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Ty.ZTYWKWSRATEYENKIJYUN)
    public String getZtywkwsrateyenkijyun() {
        return ztywkwsrateyenkijyun;
    }

    public void setZtywkwsrateyenkijyun(String pZtywkwsrateyenkijyun) {
        ztywkwsrateyenkijyun = pZtywkwsrateyenkijyun;
    }

    private String ztywkwsrateyenyasu;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Ty.ZTYWKWSRATEYENYASU)
    public String getZtywkwsrateyenyasu() {
        return ztywkwsrateyenyasu;
    }

    public void setZtywkwsrateyenyasu(String pZtywkwsrateyenyasu) {
        ztywkwsrateyenyasu = pZtywkwsrateyenyasu;
    }

    private String ztykyktuukatype;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Ty.ZTYKYKTUUKATYPE)
    public String getZtykyktuukatype() {
        return ztykyktuukatype;
    }

    public void setZtykyktuukatype(String pZtykyktuukatype) {
        ztykyktuukatype = pZtykyktuukatype;
    }

    private String ztykeikanensuu01;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Ty.ZTYKEIKANENSUU01)
    public String getZtykeikanensuu01() {
        return ztykeikanensuu01;
    }

    public void setZtykeikanensuu01(String pZtykeikanensuu01) {
        ztykeikanensuu01 = pZtykeikanensuu01;
    }

    private String ztyhrkkknmnryumukbn01;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Ty.ZTYHRKKKNMNRYUMUKBN01)
    public String getZtyhrkkknmnryumukbn01() {
        return ztyhrkkknmnryumukbn01;
    }

    public void setZtyhrkkknmnryumukbn01(String pZtyhrkkknmnryumukbn01) {
        ztyhrkkknmnryumukbn01 = pZtyhrkkknmnryumukbn01;
    }

    private String ztyzennouzndkyen01;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Ty.ZTYZENNOUZNDKYEN01)
    public String getZtyzennouzndkyen01() {
        return ztyzennouzndkyen01;
    }

    public void setZtyzennouzndkyen01(String pZtyzennouzndkyen01) {
        ztyzennouzndkyen01 = pZtyzennouzndkyen01;
    }

    private String ztyzennouzndkgaika01;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Ty.ZTYZENNOUZNDKGAIKA01)
    public String getZtyzennouzndkgaika01() {
        return ztyzennouzndkgaika01;
    }

    public void setZtyzennouzndkgaika01(String pZtyzennouzndkgaika01) {
        ztyzennouzndkgaika01 = pZtyzennouzndkgaika01;
    }

    private String ztyyenhrkgkgoukei01;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Ty.ZTYYENHRKGKGOUKEI01)
    public String getZtyyenhrkgkgoukei01() {
        return ztyyenhrkgkgoukei01;
    }

    public void setZtyyenhrkgkgoukei01(String pZtyyenhrkgkgoukei01) {
        ztyyenhrkgkgoukei01 = pZtyyenhrkgkgoukei01;
    }

    private String ztykihrkmp01;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Ty.ZTYKIHRKMP01)
    public String getZtykihrkmp01() {
        return ztykihrkmp01;
    }

    public void setZtykihrkmp01(String pZtykihrkmp01) {
        ztykihrkmp01 = pZtykihrkmp01;
    }

    private String ztyw01;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Ty.ZTYW01)
    public String getZtyw01() {
        return ztyw01;
    }

    public void setZtyw01(String pZtyw01) {
        ztyw01 = pZtyw01;
    }

    private String ztywyenyendaka01;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Ty.ZTYWYENYENDAKA01)
    public String getZtywyenyendaka01() {
        return ztywyenyendaka01;
    }

    public void setZtywyenyendaka01(String pZtywyenyendaka01) {
        ztywyenyendaka01 = pZtywyenyendaka01;
    }

    private String ztywyenkijun01;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Ty.ZTYWYENKIJUN01)
    public String getZtywyenkijun01() {
        return ztywyenkijun01;
    }

    public void setZtywyenkijun01(String pZtywyenkijun01) {
        ztywyenkijun01 = pZtywyenkijun01;
    }

    private String ztywyenyenyasu01;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Ty.ZTYWYENYENYASU01)
    public String getZtywyenyenyasu01() {
        return ztywyenyenyasu01;
    }

    public void setZtywyenyenyasu01(String pZtywyenyenyasu01) {
        ztywyenyenyasu01 = pZtywyenyenyasu01;
    }

    private String ztykaiykuktgk01;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Ty.ZTYKAIYKUKTGK01)
    public String getZtykaiykuktgk01() {
        return ztykaiykuktgk01;
    }

    public void setZtykaiykuktgk01(String pZtykaiykuktgk01) {
        ztykaiykuktgk01 = pZtykaiykuktgk01;
    }

    private String ztykaiykuktgkyenyendaka01;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Ty.ZTYKAIYKUKTGKYENYENDAKA01)
    public String getZtykaiykuktgkyenyendaka01() {
        return ztykaiykuktgkyenyendaka01;
    }

    public void setZtykaiykuktgkyenyendaka01(String pZtykaiykuktgkyenyendaka01) {
        ztykaiykuktgkyenyendaka01 = pZtykaiykuktgkyenyendaka01;
    }

    private String ztykaiykuktgkyenkijun01;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Ty.ZTYKAIYKUKTGKYENKIJUN01)
    public String getZtykaiykuktgkyenkijun01() {
        return ztykaiykuktgkyenkijun01;
    }

    public void setZtykaiykuktgkyenkijun01(String pZtykaiykuktgkyenkijun01) {
        ztykaiykuktgkyenkijun01 = pZtykaiykuktgkyenkijun01;
    }

    private String ztykaiykuktgkyenyenyasu01;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Ty.ZTYKAIYKUKTGKYENYENYASU01)
    public String getZtykaiykuktgkyenyenyasu01() {
        return ztykaiykuktgkyenyenyasu01;
    }

    public void setZtykaiykuktgkyenyenyasu01(String pZtykaiykuktgkyenyenyasu01) {
        ztykaiykuktgkyenyenyasu01 = pZtykaiykuktgkyenyenyasu01;
    }

    private String ztykeikanensuu02;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Ty.ZTYKEIKANENSUU02)
    public String getZtykeikanensuu02() {
        return ztykeikanensuu02;
    }

    public void setZtykeikanensuu02(String pZtykeikanensuu02) {
        ztykeikanensuu02 = pZtykeikanensuu02;
    }

    private String ztyhrkkknmnryumukbn02;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Ty.ZTYHRKKKNMNRYUMUKBN02)
    public String getZtyhrkkknmnryumukbn02() {
        return ztyhrkkknmnryumukbn02;
    }

    public void setZtyhrkkknmnryumukbn02(String pZtyhrkkknmnryumukbn02) {
        ztyhrkkknmnryumukbn02 = pZtyhrkkknmnryumukbn02;
    }

    private String ztyzennouzndkyen02;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Ty.ZTYZENNOUZNDKYEN02)
    public String getZtyzennouzndkyen02() {
        return ztyzennouzndkyen02;
    }

    public void setZtyzennouzndkyen02(String pZtyzennouzndkyen02) {
        ztyzennouzndkyen02 = pZtyzennouzndkyen02;
    }

    private String ztyzennouzndkgaika02;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Ty.ZTYZENNOUZNDKGAIKA02)
    public String getZtyzennouzndkgaika02() {
        return ztyzennouzndkgaika02;
    }

    public void setZtyzennouzndkgaika02(String pZtyzennouzndkgaika02) {
        ztyzennouzndkgaika02 = pZtyzennouzndkgaika02;
    }

    private String ztyyenhrkgkgoukei02;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Ty.ZTYYENHRKGKGOUKEI02)
    public String getZtyyenhrkgkgoukei02() {
        return ztyyenhrkgkgoukei02;
    }

    public void setZtyyenhrkgkgoukei02(String pZtyyenhrkgkgoukei02) {
        ztyyenhrkgkgoukei02 = pZtyyenhrkgkgoukei02;
    }

    private String ztykihrkmp02;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Ty.ZTYKIHRKMP02)
    public String getZtykihrkmp02() {
        return ztykihrkmp02;
    }

    public void setZtykihrkmp02(String pZtykihrkmp02) {
        ztykihrkmp02 = pZtykihrkmp02;
    }

    private String ztyw02;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Ty.ZTYW02)
    public String getZtyw02() {
        return ztyw02;
    }

    public void setZtyw02(String pZtyw02) {
        ztyw02 = pZtyw02;
    }

    private String ztywyenyendaka02;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Ty.ZTYWYENYENDAKA02)
    public String getZtywyenyendaka02() {
        return ztywyenyendaka02;
    }

    public void setZtywyenyendaka02(String pZtywyenyendaka02) {
        ztywyenyendaka02 = pZtywyenyendaka02;
    }

    private String ztywyenkijun02;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Ty.ZTYWYENKIJUN02)
    public String getZtywyenkijun02() {
        return ztywyenkijun02;
    }

    public void setZtywyenkijun02(String pZtywyenkijun02) {
        ztywyenkijun02 = pZtywyenkijun02;
    }

    private String ztywyenyenyasu02;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Ty.ZTYWYENYENYASU02)
    public String getZtywyenyenyasu02() {
        return ztywyenyenyasu02;
    }

    public void setZtywyenyenyasu02(String pZtywyenyenyasu02) {
        ztywyenyenyasu02 = pZtywyenyenyasu02;
    }

    private String ztykaiykuktgk02;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Ty.ZTYKAIYKUKTGK02)
    public String getZtykaiykuktgk02() {
        return ztykaiykuktgk02;
    }

    public void setZtykaiykuktgk02(String pZtykaiykuktgk02) {
        ztykaiykuktgk02 = pZtykaiykuktgk02;
    }

    private String ztykaiykuktgkyenyendaka02;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Ty.ZTYKAIYKUKTGKYENYENDAKA02)
    public String getZtykaiykuktgkyenyendaka02() {
        return ztykaiykuktgkyenyendaka02;
    }

    public void setZtykaiykuktgkyenyendaka02(String pZtykaiykuktgkyenyendaka02) {
        ztykaiykuktgkyenyendaka02 = pZtykaiykuktgkyenyendaka02;
    }

    private String ztykaiykuktgkyenkijun02;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Ty.ZTYKAIYKUKTGKYENKIJUN02)
    public String getZtykaiykuktgkyenkijun02() {
        return ztykaiykuktgkyenkijun02;
    }

    public void setZtykaiykuktgkyenkijun02(String pZtykaiykuktgkyenkijun02) {
        ztykaiykuktgkyenkijun02 = pZtykaiykuktgkyenkijun02;
    }

    private String ztykaiykuktgkyenyenyasu02;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Ty.ZTYKAIYKUKTGKYENYENYASU02)
    public String getZtykaiykuktgkyenyenyasu02() {
        return ztykaiykuktgkyenyenyasu02;
    }

    public void setZtykaiykuktgkyenyenyasu02(String pZtykaiykuktgkyenyenyasu02) {
        ztykaiykuktgkyenyenyasu02 = pZtykaiykuktgkyenyenyasu02;
    }

    private String ztykeikanensuu03;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Ty.ZTYKEIKANENSUU03)
    public String getZtykeikanensuu03() {
        return ztykeikanensuu03;
    }

    public void setZtykeikanensuu03(String pZtykeikanensuu03) {
        ztykeikanensuu03 = pZtykeikanensuu03;
    }

    private String ztyhrkkknmnryumukbn03;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Ty.ZTYHRKKKNMNRYUMUKBN03)
    public String getZtyhrkkknmnryumukbn03() {
        return ztyhrkkknmnryumukbn03;
    }

    public void setZtyhrkkknmnryumukbn03(String pZtyhrkkknmnryumukbn03) {
        ztyhrkkknmnryumukbn03 = pZtyhrkkknmnryumukbn03;
    }

    private String ztyzennouzndkyen03;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Ty.ZTYZENNOUZNDKYEN03)
    public String getZtyzennouzndkyen03() {
        return ztyzennouzndkyen03;
    }

    public void setZtyzennouzndkyen03(String pZtyzennouzndkyen03) {
        ztyzennouzndkyen03 = pZtyzennouzndkyen03;
    }

    private String ztyzennouzndkgaika03;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Ty.ZTYZENNOUZNDKGAIKA03)
    public String getZtyzennouzndkgaika03() {
        return ztyzennouzndkgaika03;
    }

    public void setZtyzennouzndkgaika03(String pZtyzennouzndkgaika03) {
        ztyzennouzndkgaika03 = pZtyzennouzndkgaika03;
    }

    private String ztyyenhrkgkgoukei03;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Ty.ZTYYENHRKGKGOUKEI03)
    public String getZtyyenhrkgkgoukei03() {
        return ztyyenhrkgkgoukei03;
    }

    public void setZtyyenhrkgkgoukei03(String pZtyyenhrkgkgoukei03) {
        ztyyenhrkgkgoukei03 = pZtyyenhrkgkgoukei03;
    }

    private String ztykihrkmp03;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Ty.ZTYKIHRKMP03)
    public String getZtykihrkmp03() {
        return ztykihrkmp03;
    }

    public void setZtykihrkmp03(String pZtykihrkmp03) {
        ztykihrkmp03 = pZtykihrkmp03;
    }

    private String ztyw03;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Ty.ZTYW03)
    public String getZtyw03() {
        return ztyw03;
    }

    public void setZtyw03(String pZtyw03) {
        ztyw03 = pZtyw03;
    }

    private String ztywyenyendaka03;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Ty.ZTYWYENYENDAKA03)
    public String getZtywyenyendaka03() {
        return ztywyenyendaka03;
    }

    public void setZtywyenyendaka03(String pZtywyenyendaka03) {
        ztywyenyendaka03 = pZtywyenyendaka03;
    }

    private String ztywyenkijun03;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Ty.ZTYWYENKIJUN03)
    public String getZtywyenkijun03() {
        return ztywyenkijun03;
    }

    public void setZtywyenkijun03(String pZtywyenkijun03) {
        ztywyenkijun03 = pZtywyenkijun03;
    }

    private String ztywyenyenyasu03;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Ty.ZTYWYENYENYASU03)
    public String getZtywyenyenyasu03() {
        return ztywyenyenyasu03;
    }

    public void setZtywyenyenyasu03(String pZtywyenyenyasu03) {
        ztywyenyenyasu03 = pZtywyenyenyasu03;
    }

    private String ztykaiykuktgk03;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Ty.ZTYKAIYKUKTGK03)
    public String getZtykaiykuktgk03() {
        return ztykaiykuktgk03;
    }

    public void setZtykaiykuktgk03(String pZtykaiykuktgk03) {
        ztykaiykuktgk03 = pZtykaiykuktgk03;
    }

    private String ztykaiykuktgkyenyendaka03;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Ty.ZTYKAIYKUKTGKYENYENDAKA03)
    public String getZtykaiykuktgkyenyendaka03() {
        return ztykaiykuktgkyenyendaka03;
    }

    public void setZtykaiykuktgkyenyendaka03(String pZtykaiykuktgkyenyendaka03) {
        ztykaiykuktgkyenyendaka03 = pZtykaiykuktgkyenyendaka03;
    }

    private String ztykaiykuktgkyenkijun03;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Ty.ZTYKAIYKUKTGKYENKIJUN03)
    public String getZtykaiykuktgkyenkijun03() {
        return ztykaiykuktgkyenkijun03;
    }

    public void setZtykaiykuktgkyenkijun03(String pZtykaiykuktgkyenkijun03) {
        ztykaiykuktgkyenkijun03 = pZtykaiykuktgkyenkijun03;
    }

    private String ztykaiykuktgkyenyenyasu03;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Ty.ZTYKAIYKUKTGKYENYENYASU03)
    public String getZtykaiykuktgkyenyenyasu03() {
        return ztykaiykuktgkyenyenyasu03;
    }

    public void setZtykaiykuktgkyenyenyasu03(String pZtykaiykuktgkyenyenyasu03) {
        ztykaiykuktgkyenyenyasu03 = pZtykaiykuktgkyenyenyasu03;
    }

    private String ztykeikanensuu04;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Ty.ZTYKEIKANENSUU04)
    public String getZtykeikanensuu04() {
        return ztykeikanensuu04;
    }

    public void setZtykeikanensuu04(String pZtykeikanensuu04) {
        ztykeikanensuu04 = pZtykeikanensuu04;
    }

    private String ztyhrkkknmnryumukbn04;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Ty.ZTYHRKKKNMNRYUMUKBN04)
    public String getZtyhrkkknmnryumukbn04() {
        return ztyhrkkknmnryumukbn04;
    }

    public void setZtyhrkkknmnryumukbn04(String pZtyhrkkknmnryumukbn04) {
        ztyhrkkknmnryumukbn04 = pZtyhrkkknmnryumukbn04;
    }

    private String ztyzennouzndkyen04;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Ty.ZTYZENNOUZNDKYEN04)
    public String getZtyzennouzndkyen04() {
        return ztyzennouzndkyen04;
    }

    public void setZtyzennouzndkyen04(String pZtyzennouzndkyen04) {
        ztyzennouzndkyen04 = pZtyzennouzndkyen04;
    }

    private String ztyzennouzndkgaika04;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Ty.ZTYZENNOUZNDKGAIKA04)
    public String getZtyzennouzndkgaika04() {
        return ztyzennouzndkgaika04;
    }

    public void setZtyzennouzndkgaika04(String pZtyzennouzndkgaika04) {
        ztyzennouzndkgaika04 = pZtyzennouzndkgaika04;
    }

    private String ztyyenhrkgkgoukei04;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Ty.ZTYYENHRKGKGOUKEI04)
    public String getZtyyenhrkgkgoukei04() {
        return ztyyenhrkgkgoukei04;
    }

    public void setZtyyenhrkgkgoukei04(String pZtyyenhrkgkgoukei04) {
        ztyyenhrkgkgoukei04 = pZtyyenhrkgkgoukei04;
    }

    private String ztykihrkmp04;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Ty.ZTYKIHRKMP04)
    public String getZtykihrkmp04() {
        return ztykihrkmp04;
    }

    public void setZtykihrkmp04(String pZtykihrkmp04) {
        ztykihrkmp04 = pZtykihrkmp04;
    }

    private String ztyw04;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Ty.ZTYW04)
    public String getZtyw04() {
        return ztyw04;
    }

    public void setZtyw04(String pZtyw04) {
        ztyw04 = pZtyw04;
    }

    private String ztywyenyendaka04;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Ty.ZTYWYENYENDAKA04)
    public String getZtywyenyendaka04() {
        return ztywyenyendaka04;
    }

    public void setZtywyenyendaka04(String pZtywyenyendaka04) {
        ztywyenyendaka04 = pZtywyenyendaka04;
    }

    private String ztywyenkijun04;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Ty.ZTYWYENKIJUN04)
    public String getZtywyenkijun04() {
        return ztywyenkijun04;
    }

    public void setZtywyenkijun04(String pZtywyenkijun04) {
        ztywyenkijun04 = pZtywyenkijun04;
    }

    private String ztywyenyenyasu04;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Ty.ZTYWYENYENYASU04)
    public String getZtywyenyenyasu04() {
        return ztywyenyenyasu04;
    }

    public void setZtywyenyenyasu04(String pZtywyenyenyasu04) {
        ztywyenyenyasu04 = pZtywyenyenyasu04;
    }

    private String ztykaiykuktgk04;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Ty.ZTYKAIYKUKTGK04)
    public String getZtykaiykuktgk04() {
        return ztykaiykuktgk04;
    }

    public void setZtykaiykuktgk04(String pZtykaiykuktgk04) {
        ztykaiykuktgk04 = pZtykaiykuktgk04;
    }

    private String ztykaiykuktgkyenyendaka04;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Ty.ZTYKAIYKUKTGKYENYENDAKA04)
    public String getZtykaiykuktgkyenyendaka04() {
        return ztykaiykuktgkyenyendaka04;
    }

    public void setZtykaiykuktgkyenyendaka04(String pZtykaiykuktgkyenyendaka04) {
        ztykaiykuktgkyenyendaka04 = pZtykaiykuktgkyenyendaka04;
    }

    private String ztykaiykuktgkyenkijun04;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Ty.ZTYKAIYKUKTGKYENKIJUN04)
    public String getZtykaiykuktgkyenkijun04() {
        return ztykaiykuktgkyenkijun04;
    }

    public void setZtykaiykuktgkyenkijun04(String pZtykaiykuktgkyenkijun04) {
        ztykaiykuktgkyenkijun04 = pZtykaiykuktgkyenkijun04;
    }

    private String ztykaiykuktgkyenyenyasu04;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Ty.ZTYKAIYKUKTGKYENYENYASU04)
    public String getZtykaiykuktgkyenyenyasu04() {
        return ztykaiykuktgkyenyenyasu04;
    }

    public void setZtykaiykuktgkyenyenyasu04(String pZtykaiykuktgkyenyenyasu04) {
        ztykaiykuktgkyenyenyasu04 = pZtykaiykuktgkyenyenyasu04;
    }

    private String ztykeikanensuu05;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Ty.ZTYKEIKANENSUU05)
    public String getZtykeikanensuu05() {
        return ztykeikanensuu05;
    }

    public void setZtykeikanensuu05(String pZtykeikanensuu05) {
        ztykeikanensuu05 = pZtykeikanensuu05;
    }

    private String ztyhrkkknmnryumukbn05;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Ty.ZTYHRKKKNMNRYUMUKBN05)
    public String getZtyhrkkknmnryumukbn05() {
        return ztyhrkkknmnryumukbn05;
    }

    public void setZtyhrkkknmnryumukbn05(String pZtyhrkkknmnryumukbn05) {
        ztyhrkkknmnryumukbn05 = pZtyhrkkknmnryumukbn05;
    }

    private String ztyzennouzndkyen05;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Ty.ZTYZENNOUZNDKYEN05)
    public String getZtyzennouzndkyen05() {
        return ztyzennouzndkyen05;
    }

    public void setZtyzennouzndkyen05(String pZtyzennouzndkyen05) {
        ztyzennouzndkyen05 = pZtyzennouzndkyen05;
    }

    private String ztyzennouzndkgaika05;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Ty.ZTYZENNOUZNDKGAIKA05)
    public String getZtyzennouzndkgaika05() {
        return ztyzennouzndkgaika05;
    }

    public void setZtyzennouzndkgaika05(String pZtyzennouzndkgaika05) {
        ztyzennouzndkgaika05 = pZtyzennouzndkgaika05;
    }

    private String ztyyenhrkgkgoukei05;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Ty.ZTYYENHRKGKGOUKEI05)
    public String getZtyyenhrkgkgoukei05() {
        return ztyyenhrkgkgoukei05;
    }

    public void setZtyyenhrkgkgoukei05(String pZtyyenhrkgkgoukei05) {
        ztyyenhrkgkgoukei05 = pZtyyenhrkgkgoukei05;
    }

    private String ztykihrkmp05;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Ty.ZTYKIHRKMP05)
    public String getZtykihrkmp05() {
        return ztykihrkmp05;
    }

    public void setZtykihrkmp05(String pZtykihrkmp05) {
        ztykihrkmp05 = pZtykihrkmp05;
    }

    private String ztyw05;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Ty.ZTYW05)
    public String getZtyw05() {
        return ztyw05;
    }

    public void setZtyw05(String pZtyw05) {
        ztyw05 = pZtyw05;
    }

    private String ztywyenyendaka05;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Ty.ZTYWYENYENDAKA05)
    public String getZtywyenyendaka05() {
        return ztywyenyendaka05;
    }

    public void setZtywyenyendaka05(String pZtywyenyendaka05) {
        ztywyenyendaka05 = pZtywyenyendaka05;
    }

    private String ztywyenkijun05;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Ty.ZTYWYENKIJUN05)
    public String getZtywyenkijun05() {
        return ztywyenkijun05;
    }

    public void setZtywyenkijun05(String pZtywyenkijun05) {
        ztywyenkijun05 = pZtywyenkijun05;
    }

    private String ztywyenyenyasu05;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Ty.ZTYWYENYENYASU05)
    public String getZtywyenyenyasu05() {
        return ztywyenyenyasu05;
    }

    public void setZtywyenyenyasu05(String pZtywyenyenyasu05) {
        ztywyenyenyasu05 = pZtywyenyenyasu05;
    }

    private String ztykaiykuktgk05;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Ty.ZTYKAIYKUKTGK05)
    public String getZtykaiykuktgk05() {
        return ztykaiykuktgk05;
    }

    public void setZtykaiykuktgk05(String pZtykaiykuktgk05) {
        ztykaiykuktgk05 = pZtykaiykuktgk05;
    }

    private String ztykaiykuktgkyenyendaka05;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Ty.ZTYKAIYKUKTGKYENYENDAKA05)
    public String getZtykaiykuktgkyenyendaka05() {
        return ztykaiykuktgkyenyendaka05;
    }

    public void setZtykaiykuktgkyenyendaka05(String pZtykaiykuktgkyenyendaka05) {
        ztykaiykuktgkyenyendaka05 = pZtykaiykuktgkyenyendaka05;
    }

    private String ztykaiykuktgkyenkijun05;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Ty.ZTYKAIYKUKTGKYENKIJUN05)
    public String getZtykaiykuktgkyenkijun05() {
        return ztykaiykuktgkyenkijun05;
    }

    public void setZtykaiykuktgkyenkijun05(String pZtykaiykuktgkyenkijun05) {
        ztykaiykuktgkyenkijun05 = pZtykaiykuktgkyenkijun05;
    }

    private String ztykaiykuktgkyenyenyasu05;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Ty.ZTYKAIYKUKTGKYENYENYASU05)
    public String getZtykaiykuktgkyenyenyasu05() {
        return ztykaiykuktgkyenyenyasu05;
    }

    public void setZtykaiykuktgkyenyenyasu05(String pZtykaiykuktgkyenyenyasu05) {
        ztykaiykuktgkyenyenyasu05 = pZtykaiykuktgkyenyenyasu05;
    }

    private String ztykeikanensuu06;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Ty.ZTYKEIKANENSUU06)
    public String getZtykeikanensuu06() {
        return ztykeikanensuu06;
    }

    public void setZtykeikanensuu06(String pZtykeikanensuu06) {
        ztykeikanensuu06 = pZtykeikanensuu06;
    }

    private String ztyhrkkknmnryumukbn06;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Ty.ZTYHRKKKNMNRYUMUKBN06)
    public String getZtyhrkkknmnryumukbn06() {
        return ztyhrkkknmnryumukbn06;
    }

    public void setZtyhrkkknmnryumukbn06(String pZtyhrkkknmnryumukbn06) {
        ztyhrkkknmnryumukbn06 = pZtyhrkkknmnryumukbn06;
    }

    private String ztyzennouzndkyen06;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Ty.ZTYZENNOUZNDKYEN06)
    public String getZtyzennouzndkyen06() {
        return ztyzennouzndkyen06;
    }

    public void setZtyzennouzndkyen06(String pZtyzennouzndkyen06) {
        ztyzennouzndkyen06 = pZtyzennouzndkyen06;
    }

    private String ztyzennouzndkgaika06;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Ty.ZTYZENNOUZNDKGAIKA06)
    public String getZtyzennouzndkgaika06() {
        return ztyzennouzndkgaika06;
    }

    public void setZtyzennouzndkgaika06(String pZtyzennouzndkgaika06) {
        ztyzennouzndkgaika06 = pZtyzennouzndkgaika06;
    }

    private String ztyyenhrkgkgoukei06;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Ty.ZTYYENHRKGKGOUKEI06)
    public String getZtyyenhrkgkgoukei06() {
        return ztyyenhrkgkgoukei06;
    }

    public void setZtyyenhrkgkgoukei06(String pZtyyenhrkgkgoukei06) {
        ztyyenhrkgkgoukei06 = pZtyyenhrkgkgoukei06;
    }

    private String ztykihrkmp06;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Ty.ZTYKIHRKMP06)
    public String getZtykihrkmp06() {
        return ztykihrkmp06;
    }

    public void setZtykihrkmp06(String pZtykihrkmp06) {
        ztykihrkmp06 = pZtykihrkmp06;
    }

    private String ztyw06;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Ty.ZTYW06)
    public String getZtyw06() {
        return ztyw06;
    }

    public void setZtyw06(String pZtyw06) {
        ztyw06 = pZtyw06;
    }

    private String ztywyenyendaka06;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Ty.ZTYWYENYENDAKA06)
    public String getZtywyenyendaka06() {
        return ztywyenyendaka06;
    }

    public void setZtywyenyendaka06(String pZtywyenyendaka06) {
        ztywyenyendaka06 = pZtywyenyendaka06;
    }

    private String ztywyenkijun06;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Ty.ZTYWYENKIJUN06)
    public String getZtywyenkijun06() {
        return ztywyenkijun06;
    }

    public void setZtywyenkijun06(String pZtywyenkijun06) {
        ztywyenkijun06 = pZtywyenkijun06;
    }

    private String ztywyenyenyasu06;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Ty.ZTYWYENYENYASU06)
    public String getZtywyenyenyasu06() {
        return ztywyenyenyasu06;
    }

    public void setZtywyenyenyasu06(String pZtywyenyenyasu06) {
        ztywyenyenyasu06 = pZtywyenyenyasu06;
    }

    private String ztykaiykuktgk06;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Ty.ZTYKAIYKUKTGK06)
    public String getZtykaiykuktgk06() {
        return ztykaiykuktgk06;
    }

    public void setZtykaiykuktgk06(String pZtykaiykuktgk06) {
        ztykaiykuktgk06 = pZtykaiykuktgk06;
    }

    private String ztykaiykuktgkyenyendaka06;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Ty.ZTYKAIYKUKTGKYENYENDAKA06)
    public String getZtykaiykuktgkyenyendaka06() {
        return ztykaiykuktgkyenyendaka06;
    }

    public void setZtykaiykuktgkyenyendaka06(String pZtykaiykuktgkyenyendaka06) {
        ztykaiykuktgkyenyendaka06 = pZtykaiykuktgkyenyendaka06;
    }

    private String ztykaiykuktgkyenkijun06;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Ty.ZTYKAIYKUKTGKYENKIJUN06)
    public String getZtykaiykuktgkyenkijun06() {
        return ztykaiykuktgkyenkijun06;
    }

    public void setZtykaiykuktgkyenkijun06(String pZtykaiykuktgkyenkijun06) {
        ztykaiykuktgkyenkijun06 = pZtykaiykuktgkyenkijun06;
    }

    private String ztykaiykuktgkyenyenyasu06;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Ty.ZTYKAIYKUKTGKYENYENYASU06)
    public String getZtykaiykuktgkyenyenyasu06() {
        return ztykaiykuktgkyenyenyasu06;
    }

    public void setZtykaiykuktgkyenyenyasu06(String pZtykaiykuktgkyenyenyasu06) {
        ztykaiykuktgkyenyenyasu06 = pZtykaiykuktgkyenyenyasu06;
    }

    private String ztykeikanensuu07;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Ty.ZTYKEIKANENSUU07)
    public String getZtykeikanensuu07() {
        return ztykeikanensuu07;
    }

    public void setZtykeikanensuu07(String pZtykeikanensuu07) {
        ztykeikanensuu07 = pZtykeikanensuu07;
    }

    private String ztyhrkkknmnryumukbn07;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Ty.ZTYHRKKKNMNRYUMUKBN07)
    public String getZtyhrkkknmnryumukbn07() {
        return ztyhrkkknmnryumukbn07;
    }

    public void setZtyhrkkknmnryumukbn07(String pZtyhrkkknmnryumukbn07) {
        ztyhrkkknmnryumukbn07 = pZtyhrkkknmnryumukbn07;
    }

    private String ztyzennouzndkyen07;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Ty.ZTYZENNOUZNDKYEN07)
    public String getZtyzennouzndkyen07() {
        return ztyzennouzndkyen07;
    }

    public void setZtyzennouzndkyen07(String pZtyzennouzndkyen07) {
        ztyzennouzndkyen07 = pZtyzennouzndkyen07;
    }

    private String ztyzennouzndkgaika07;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Ty.ZTYZENNOUZNDKGAIKA07)
    public String getZtyzennouzndkgaika07() {
        return ztyzennouzndkgaika07;
    }

    public void setZtyzennouzndkgaika07(String pZtyzennouzndkgaika07) {
        ztyzennouzndkgaika07 = pZtyzennouzndkgaika07;
    }

    private String ztyyenhrkgkgoukei07;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Ty.ZTYYENHRKGKGOUKEI07)
    public String getZtyyenhrkgkgoukei07() {
        return ztyyenhrkgkgoukei07;
    }

    public void setZtyyenhrkgkgoukei07(String pZtyyenhrkgkgoukei07) {
        ztyyenhrkgkgoukei07 = pZtyyenhrkgkgoukei07;
    }

    private String ztykihrkmp07;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Ty.ZTYKIHRKMP07)
    public String getZtykihrkmp07() {
        return ztykihrkmp07;
    }

    public void setZtykihrkmp07(String pZtykihrkmp07) {
        ztykihrkmp07 = pZtykihrkmp07;
    }

    private String ztyw07;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Ty.ZTYW07)
    public String getZtyw07() {
        return ztyw07;
    }

    public void setZtyw07(String pZtyw07) {
        ztyw07 = pZtyw07;
    }

    private String ztywyenyendaka07;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Ty.ZTYWYENYENDAKA07)
    public String getZtywyenyendaka07() {
        return ztywyenyendaka07;
    }

    public void setZtywyenyendaka07(String pZtywyenyendaka07) {
        ztywyenyendaka07 = pZtywyenyendaka07;
    }

    private String ztywyenkijun07;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Ty.ZTYWYENKIJUN07)
    public String getZtywyenkijun07() {
        return ztywyenkijun07;
    }

    public void setZtywyenkijun07(String pZtywyenkijun07) {
        ztywyenkijun07 = pZtywyenkijun07;
    }

    private String ztywyenyenyasu07;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Ty.ZTYWYENYENYASU07)
    public String getZtywyenyenyasu07() {
        return ztywyenyenyasu07;
    }

    public void setZtywyenyenyasu07(String pZtywyenyenyasu07) {
        ztywyenyenyasu07 = pZtywyenyenyasu07;
    }

    private String ztykaiykuktgk07;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Ty.ZTYKAIYKUKTGK07)
    public String getZtykaiykuktgk07() {
        return ztykaiykuktgk07;
    }

    public void setZtykaiykuktgk07(String pZtykaiykuktgk07) {
        ztykaiykuktgk07 = pZtykaiykuktgk07;
    }

    private String ztykaiykuktgkyenyendaka07;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Ty.ZTYKAIYKUKTGKYENYENDAKA07)
    public String getZtykaiykuktgkyenyendaka07() {
        return ztykaiykuktgkyenyendaka07;
    }

    public void setZtykaiykuktgkyenyendaka07(String pZtykaiykuktgkyenyendaka07) {
        ztykaiykuktgkyenyendaka07 = pZtykaiykuktgkyenyendaka07;
    }

    private String ztykaiykuktgkyenkijun07;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Ty.ZTYKAIYKUKTGKYENKIJUN07)
    public String getZtykaiykuktgkyenkijun07() {
        return ztykaiykuktgkyenkijun07;
    }

    public void setZtykaiykuktgkyenkijun07(String pZtykaiykuktgkyenkijun07) {
        ztykaiykuktgkyenkijun07 = pZtykaiykuktgkyenkijun07;
    }

    private String ztykaiykuktgkyenyenyasu07;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Ty.ZTYKAIYKUKTGKYENYENYASU07)
    public String getZtykaiykuktgkyenyenyasu07() {
        return ztykaiykuktgkyenyenyasu07;
    }

    public void setZtykaiykuktgkyenyenyasu07(String pZtykaiykuktgkyenyenyasu07) {
        ztykaiykuktgkyenyenyasu07 = pZtykaiykuktgkyenyenyasu07;
    }

    private String ztykeikanensuu08;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Ty.ZTYKEIKANENSUU08)
    public String getZtykeikanensuu08() {
        return ztykeikanensuu08;
    }

    public void setZtykeikanensuu08(String pZtykeikanensuu08) {
        ztykeikanensuu08 = pZtykeikanensuu08;
    }

    private String ztyhrkkknmnryumukbn08;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Ty.ZTYHRKKKNMNRYUMUKBN08)
    public String getZtyhrkkknmnryumukbn08() {
        return ztyhrkkknmnryumukbn08;
    }

    public void setZtyhrkkknmnryumukbn08(String pZtyhrkkknmnryumukbn08) {
        ztyhrkkknmnryumukbn08 = pZtyhrkkknmnryumukbn08;
    }

    private String ztyzennouzndkyen08;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Ty.ZTYZENNOUZNDKYEN08)
    public String getZtyzennouzndkyen08() {
        return ztyzennouzndkyen08;
    }

    public void setZtyzennouzndkyen08(String pZtyzennouzndkyen08) {
        ztyzennouzndkyen08 = pZtyzennouzndkyen08;
    }

    private String ztyzennouzndkgaika08;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Ty.ZTYZENNOUZNDKGAIKA08)
    public String getZtyzennouzndkgaika08() {
        return ztyzennouzndkgaika08;
    }

    public void setZtyzennouzndkgaika08(String pZtyzennouzndkgaika08) {
        ztyzennouzndkgaika08 = pZtyzennouzndkgaika08;
    }

    private String ztyyenhrkgkgoukei08;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Ty.ZTYYENHRKGKGOUKEI08)
    public String getZtyyenhrkgkgoukei08() {
        return ztyyenhrkgkgoukei08;
    }

    public void setZtyyenhrkgkgoukei08(String pZtyyenhrkgkgoukei08) {
        ztyyenhrkgkgoukei08 = pZtyyenhrkgkgoukei08;
    }

    private String ztykihrkmp08;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Ty.ZTYKIHRKMP08)
    public String getZtykihrkmp08() {
        return ztykihrkmp08;
    }

    public void setZtykihrkmp08(String pZtykihrkmp08) {
        ztykihrkmp08 = pZtykihrkmp08;
    }

    private String ztyw08;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Ty.ZTYW08)
    public String getZtyw08() {
        return ztyw08;
    }

    public void setZtyw08(String pZtyw08) {
        ztyw08 = pZtyw08;
    }

    private String ztywyenyendaka08;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Ty.ZTYWYENYENDAKA08)
    public String getZtywyenyendaka08() {
        return ztywyenyendaka08;
    }

    public void setZtywyenyendaka08(String pZtywyenyendaka08) {
        ztywyenyendaka08 = pZtywyenyendaka08;
    }

    private String ztywyenkijun08;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Ty.ZTYWYENKIJUN08)
    public String getZtywyenkijun08() {
        return ztywyenkijun08;
    }

    public void setZtywyenkijun08(String pZtywyenkijun08) {
        ztywyenkijun08 = pZtywyenkijun08;
    }

    private String ztywyenyenyasu08;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Ty.ZTYWYENYENYASU08)
    public String getZtywyenyenyasu08() {
        return ztywyenyenyasu08;
    }

    public void setZtywyenyenyasu08(String pZtywyenyenyasu08) {
        ztywyenyenyasu08 = pZtywyenyenyasu08;
    }

    private String ztykaiykuktgk08;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Ty.ZTYKAIYKUKTGK08)
    public String getZtykaiykuktgk08() {
        return ztykaiykuktgk08;
    }

    public void setZtykaiykuktgk08(String pZtykaiykuktgk08) {
        ztykaiykuktgk08 = pZtykaiykuktgk08;
    }

    private String ztykaiykuktgkyenyendaka08;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Ty.ZTYKAIYKUKTGKYENYENDAKA08)
    public String getZtykaiykuktgkyenyendaka08() {
        return ztykaiykuktgkyenyendaka08;
    }

    public void setZtykaiykuktgkyenyendaka08(String pZtykaiykuktgkyenyendaka08) {
        ztykaiykuktgkyenyendaka08 = pZtykaiykuktgkyenyendaka08;
    }

    private String ztykaiykuktgkyenkijun08;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Ty.ZTYKAIYKUKTGKYENKIJUN08)
    public String getZtykaiykuktgkyenkijun08() {
        return ztykaiykuktgkyenkijun08;
    }

    public void setZtykaiykuktgkyenkijun08(String pZtykaiykuktgkyenkijun08) {
        ztykaiykuktgkyenkijun08 = pZtykaiykuktgkyenkijun08;
    }

    private String ztykaiykuktgkyenyenyasu08;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Ty.ZTYKAIYKUKTGKYENYENYASU08)
    public String getZtykaiykuktgkyenyenyasu08() {
        return ztykaiykuktgkyenyenyasu08;
    }

    public void setZtykaiykuktgkyenyenyasu08(String pZtykaiykuktgkyenyenyasu08) {
        ztykaiykuktgkyenyenyasu08 = pZtykaiykuktgkyenyenyasu08;
    }

    private String ztykeikanensuu09;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Ty.ZTYKEIKANENSUU09)
    public String getZtykeikanensuu09() {
        return ztykeikanensuu09;
    }

    public void setZtykeikanensuu09(String pZtykeikanensuu09) {
        ztykeikanensuu09 = pZtykeikanensuu09;
    }

    private String ztyhrkkknmnryumukbn09;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Ty.ZTYHRKKKNMNRYUMUKBN09)
    public String getZtyhrkkknmnryumukbn09() {
        return ztyhrkkknmnryumukbn09;
    }

    public void setZtyhrkkknmnryumukbn09(String pZtyhrkkknmnryumukbn09) {
        ztyhrkkknmnryumukbn09 = pZtyhrkkknmnryumukbn09;
    }

    private String ztyzennouzndkyen09;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Ty.ZTYZENNOUZNDKYEN09)
    public String getZtyzennouzndkyen09() {
        return ztyzennouzndkyen09;
    }

    public void setZtyzennouzndkyen09(String pZtyzennouzndkyen09) {
        ztyzennouzndkyen09 = pZtyzennouzndkyen09;
    }

    private String ztyzennouzndkgaika09;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Ty.ZTYZENNOUZNDKGAIKA09)
    public String getZtyzennouzndkgaika09() {
        return ztyzennouzndkgaika09;
    }

    public void setZtyzennouzndkgaika09(String pZtyzennouzndkgaika09) {
        ztyzennouzndkgaika09 = pZtyzennouzndkgaika09;
    }

    private String ztyyenhrkgkgoukei09;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Ty.ZTYYENHRKGKGOUKEI09)
    public String getZtyyenhrkgkgoukei09() {
        return ztyyenhrkgkgoukei09;
    }

    public void setZtyyenhrkgkgoukei09(String pZtyyenhrkgkgoukei09) {
        ztyyenhrkgkgoukei09 = pZtyyenhrkgkgoukei09;
    }

    private String ztykihrkmp09;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Ty.ZTYKIHRKMP09)
    public String getZtykihrkmp09() {
        return ztykihrkmp09;
    }

    public void setZtykihrkmp09(String pZtykihrkmp09) {
        ztykihrkmp09 = pZtykihrkmp09;
    }

    private String ztyw09;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Ty.ZTYW09)
    public String getZtyw09() {
        return ztyw09;
    }

    public void setZtyw09(String pZtyw09) {
        ztyw09 = pZtyw09;
    }

    private String ztywyenyendaka09;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Ty.ZTYWYENYENDAKA09)
    public String getZtywyenyendaka09() {
        return ztywyenyendaka09;
    }

    public void setZtywyenyendaka09(String pZtywyenyendaka09) {
        ztywyenyendaka09 = pZtywyenyendaka09;
    }

    private String ztywyenkijun09;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Ty.ZTYWYENKIJUN09)
    public String getZtywyenkijun09() {
        return ztywyenkijun09;
    }

    public void setZtywyenkijun09(String pZtywyenkijun09) {
        ztywyenkijun09 = pZtywyenkijun09;
    }

    private String ztywyenyenyasu09;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Ty.ZTYWYENYENYASU09)
    public String getZtywyenyenyasu09() {
        return ztywyenyenyasu09;
    }

    public void setZtywyenyenyasu09(String pZtywyenyenyasu09) {
        ztywyenyenyasu09 = pZtywyenyenyasu09;
    }

    private String ztykaiykuktgk09;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Ty.ZTYKAIYKUKTGK09)
    public String getZtykaiykuktgk09() {
        return ztykaiykuktgk09;
    }

    public void setZtykaiykuktgk09(String pZtykaiykuktgk09) {
        ztykaiykuktgk09 = pZtykaiykuktgk09;
    }

    private String ztykaiykuktgkyenyendaka09;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Ty.ZTYKAIYKUKTGKYENYENDAKA09)
    public String getZtykaiykuktgkyenyendaka09() {
        return ztykaiykuktgkyenyendaka09;
    }

    public void setZtykaiykuktgkyenyendaka09(String pZtykaiykuktgkyenyendaka09) {
        ztykaiykuktgkyenyendaka09 = pZtykaiykuktgkyenyendaka09;
    }

    private String ztykaiykuktgkyenkijun09;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Ty.ZTYKAIYKUKTGKYENKIJUN09)
    public String getZtykaiykuktgkyenkijun09() {
        return ztykaiykuktgkyenkijun09;
    }

    public void setZtykaiykuktgkyenkijun09(String pZtykaiykuktgkyenkijun09) {
        ztykaiykuktgkyenkijun09 = pZtykaiykuktgkyenkijun09;
    }

    private String ztykaiykuktgkyenyenyasu09;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Ty.ZTYKAIYKUKTGKYENYENYASU09)
    public String getZtykaiykuktgkyenyenyasu09() {
        return ztykaiykuktgkyenyenyasu09;
    }

    public void setZtykaiykuktgkyenyenyasu09(String pZtykaiykuktgkyenyenyasu09) {
        ztykaiykuktgkyenyenyasu09 = pZtykaiykuktgkyenyenyasu09;
    }

    private String ztykeikanensuu10;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Ty.ZTYKEIKANENSUU10)
    public String getZtykeikanensuu10() {
        return ztykeikanensuu10;
    }

    public void setZtykeikanensuu10(String pZtykeikanensuu10) {
        ztykeikanensuu10 = pZtykeikanensuu10;
    }

    private String ztyhrkkknmnryumukbn10;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Ty.ZTYHRKKKNMNRYUMUKBN10)
    public String getZtyhrkkknmnryumukbn10() {
        return ztyhrkkknmnryumukbn10;
    }

    public void setZtyhrkkknmnryumukbn10(String pZtyhrkkknmnryumukbn10) {
        ztyhrkkknmnryumukbn10 = pZtyhrkkknmnryumukbn10;
    }

    private String ztyzennouzndkyen10;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Ty.ZTYZENNOUZNDKYEN10)
    public String getZtyzennouzndkyen10() {
        return ztyzennouzndkyen10;
    }

    public void setZtyzennouzndkyen10(String pZtyzennouzndkyen10) {
        ztyzennouzndkyen10 = pZtyzennouzndkyen10;
    }

    private String ztyzennouzndkgaika10;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Ty.ZTYZENNOUZNDKGAIKA10)
    public String getZtyzennouzndkgaika10() {
        return ztyzennouzndkgaika10;
    }

    public void setZtyzennouzndkgaika10(String pZtyzennouzndkgaika10) {
        ztyzennouzndkgaika10 = pZtyzennouzndkgaika10;
    }

    private String ztyyenhrkgkgoukei10;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Ty.ZTYYENHRKGKGOUKEI10)
    public String getZtyyenhrkgkgoukei10() {
        return ztyyenhrkgkgoukei10;
    }

    public void setZtyyenhrkgkgoukei10(String pZtyyenhrkgkgoukei10) {
        ztyyenhrkgkgoukei10 = pZtyyenhrkgkgoukei10;
    }

    private String ztykihrkmp10;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Ty.ZTYKIHRKMP10)
    public String getZtykihrkmp10() {
        return ztykihrkmp10;
    }

    public void setZtykihrkmp10(String pZtykihrkmp10) {
        ztykihrkmp10 = pZtykihrkmp10;
    }

    private String ztyw10;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Ty.ZTYW10)
    public String getZtyw10() {
        return ztyw10;
    }

    public void setZtyw10(String pZtyw10) {
        ztyw10 = pZtyw10;
    }

    private String ztywyenyendaka10;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Ty.ZTYWYENYENDAKA10)
    public String getZtywyenyendaka10() {
        return ztywyenyendaka10;
    }

    public void setZtywyenyendaka10(String pZtywyenyendaka10) {
        ztywyenyendaka10 = pZtywyenyendaka10;
    }

    private String ztywyenkijun10;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Ty.ZTYWYENKIJUN10)
    public String getZtywyenkijun10() {
        return ztywyenkijun10;
    }

    public void setZtywyenkijun10(String pZtywyenkijun10) {
        ztywyenkijun10 = pZtywyenkijun10;
    }

    private String ztywyenyenyasu10;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Ty.ZTYWYENYENYASU10)
    public String getZtywyenyenyasu10() {
        return ztywyenyenyasu10;
    }

    public void setZtywyenyenyasu10(String pZtywyenyenyasu10) {
        ztywyenyenyasu10 = pZtywyenyenyasu10;
    }

    private String ztykaiykuktgk10;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Ty.ZTYKAIYKUKTGK10)
    public String getZtykaiykuktgk10() {
        return ztykaiykuktgk10;
    }

    public void setZtykaiykuktgk10(String pZtykaiykuktgk10) {
        ztykaiykuktgk10 = pZtykaiykuktgk10;
    }

    private String ztykaiykuktgkyenyendaka10;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Ty.ZTYKAIYKUKTGKYENYENDAKA10)
    public String getZtykaiykuktgkyenyendaka10() {
        return ztykaiykuktgkyenyendaka10;
    }

    public void setZtykaiykuktgkyenyendaka10(String pZtykaiykuktgkyenyendaka10) {
        ztykaiykuktgkyenyendaka10 = pZtykaiykuktgkyenyendaka10;
    }

    private String ztykaiykuktgkyenkijun10;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Ty.ZTYKAIYKUKTGKYENKIJUN10)
    public String getZtykaiykuktgkyenkijun10() {
        return ztykaiykuktgkyenkijun10;
    }

    public void setZtykaiykuktgkyenkijun10(String pZtykaiykuktgkyenkijun10) {
        ztykaiykuktgkyenkijun10 = pZtykaiykuktgkyenkijun10;
    }

    private String ztykaiykuktgkyenyenyasu10;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Ty.ZTYKAIYKUKTGKYENYENYASU10)
    public String getZtykaiykuktgkyenyenyasu10() {
        return ztykaiykuktgkyenyenyasu10;
    }

    public void setZtykaiykuktgkyenyenyasu10(String pZtykaiykuktgkyenyenyasu10) {
        ztykaiykuktgkyenyenyasu10 = pZtykaiykuktgkyenyenyasu10;
    }

    private String ztykeikanensuu11;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Ty.ZTYKEIKANENSUU11)
    public String getZtykeikanensuu11() {
        return ztykeikanensuu11;
    }

    public void setZtykeikanensuu11(String pZtykeikanensuu11) {
        ztykeikanensuu11 = pZtykeikanensuu11;
    }

    private String ztyhrkkknmnryumukbn11;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Ty.ZTYHRKKKNMNRYUMUKBN11)
    public String getZtyhrkkknmnryumukbn11() {
        return ztyhrkkknmnryumukbn11;
    }

    public void setZtyhrkkknmnryumukbn11(String pZtyhrkkknmnryumukbn11) {
        ztyhrkkknmnryumukbn11 = pZtyhrkkknmnryumukbn11;
    }

    private String ztyzennouzndkyen11;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Ty.ZTYZENNOUZNDKYEN11)
    public String getZtyzennouzndkyen11() {
        return ztyzennouzndkyen11;
    }

    public void setZtyzennouzndkyen11(String pZtyzennouzndkyen11) {
        ztyzennouzndkyen11 = pZtyzennouzndkyen11;
    }

    private String ztyzennouzndkgaika11;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Ty.ZTYZENNOUZNDKGAIKA11)
    public String getZtyzennouzndkgaika11() {
        return ztyzennouzndkgaika11;
    }

    public void setZtyzennouzndkgaika11(String pZtyzennouzndkgaika11) {
        ztyzennouzndkgaika11 = pZtyzennouzndkgaika11;
    }

    private String ztyyenhrkgkgoukei11;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Ty.ZTYYENHRKGKGOUKEI11)
    public String getZtyyenhrkgkgoukei11() {
        return ztyyenhrkgkgoukei11;
    }

    public void setZtyyenhrkgkgoukei11(String pZtyyenhrkgkgoukei11) {
        ztyyenhrkgkgoukei11 = pZtyyenhrkgkgoukei11;
    }

    private String ztykihrkmp11;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Ty.ZTYKIHRKMP11)
    public String getZtykihrkmp11() {
        return ztykihrkmp11;
    }

    public void setZtykihrkmp11(String pZtykihrkmp11) {
        ztykihrkmp11 = pZtykihrkmp11;
    }

    private String ztyw11;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Ty.ZTYW11)
    public String getZtyw11() {
        return ztyw11;
    }

    public void setZtyw11(String pZtyw11) {
        ztyw11 = pZtyw11;
    }

    private String ztywyenyendaka11;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Ty.ZTYWYENYENDAKA11)
    public String getZtywyenyendaka11() {
        return ztywyenyendaka11;
    }

    public void setZtywyenyendaka11(String pZtywyenyendaka11) {
        ztywyenyendaka11 = pZtywyenyendaka11;
    }

    private String ztywyenkijun11;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Ty.ZTYWYENKIJUN11)
    public String getZtywyenkijun11() {
        return ztywyenkijun11;
    }

    public void setZtywyenkijun11(String pZtywyenkijun11) {
        ztywyenkijun11 = pZtywyenkijun11;
    }

    private String ztywyenyenyasu11;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Ty.ZTYWYENYENYASU11)
    public String getZtywyenyenyasu11() {
        return ztywyenyenyasu11;
    }

    public void setZtywyenyenyasu11(String pZtywyenyenyasu11) {
        ztywyenyenyasu11 = pZtywyenyenyasu11;
    }

    private String ztykaiykuktgk11;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Ty.ZTYKAIYKUKTGK11)
    public String getZtykaiykuktgk11() {
        return ztykaiykuktgk11;
    }

    public void setZtykaiykuktgk11(String pZtykaiykuktgk11) {
        ztykaiykuktgk11 = pZtykaiykuktgk11;
    }

    private String ztykaiykuktgkyenyendaka11;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Ty.ZTYKAIYKUKTGKYENYENDAKA11)
    public String getZtykaiykuktgkyenyendaka11() {
        return ztykaiykuktgkyenyendaka11;
    }

    public void setZtykaiykuktgkyenyendaka11(String pZtykaiykuktgkyenyendaka11) {
        ztykaiykuktgkyenyendaka11 = pZtykaiykuktgkyenyendaka11;
    }

    private String ztykaiykuktgkyenkijun11;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Ty.ZTYKAIYKUKTGKYENKIJUN11)
    public String getZtykaiykuktgkyenkijun11() {
        return ztykaiykuktgkyenkijun11;
    }

    public void setZtykaiykuktgkyenkijun11(String pZtykaiykuktgkyenkijun11) {
        ztykaiykuktgkyenkijun11 = pZtykaiykuktgkyenkijun11;
    }

    private String ztykaiykuktgkyenyenyasu11;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Ty.ZTYKAIYKUKTGKYENYENYASU11)
    public String getZtykaiykuktgkyenyenyasu11() {
        return ztykaiykuktgkyenyenyasu11;
    }

    public void setZtykaiykuktgkyenyenyasu11(String pZtykaiykuktgkyenyenyasu11) {
        ztykaiykuktgkyenyenyasu11 = pZtykaiykuktgkyenyenyasu11;
    }

    private String ztykeikanensuu12;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Ty.ZTYKEIKANENSUU12)
    public String getZtykeikanensuu12() {
        return ztykeikanensuu12;
    }

    public void setZtykeikanensuu12(String pZtykeikanensuu12) {
        ztykeikanensuu12 = pZtykeikanensuu12;
    }

    private String ztyhrkkknmnryumukbn12;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Ty.ZTYHRKKKNMNRYUMUKBN12)
    public String getZtyhrkkknmnryumukbn12() {
        return ztyhrkkknmnryumukbn12;
    }

    public void setZtyhrkkknmnryumukbn12(String pZtyhrkkknmnryumukbn12) {
        ztyhrkkknmnryumukbn12 = pZtyhrkkknmnryumukbn12;
    }

    private String ztyzennouzndkyen12;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Ty.ZTYZENNOUZNDKYEN12)
    public String getZtyzennouzndkyen12() {
        return ztyzennouzndkyen12;
    }

    public void setZtyzennouzndkyen12(String pZtyzennouzndkyen12) {
        ztyzennouzndkyen12 = pZtyzennouzndkyen12;
    }

    private String ztyzennouzndkgaika12;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Ty.ZTYZENNOUZNDKGAIKA12)
    public String getZtyzennouzndkgaika12() {
        return ztyzennouzndkgaika12;
    }

    public void setZtyzennouzndkgaika12(String pZtyzennouzndkgaika12) {
        ztyzennouzndkgaika12 = pZtyzennouzndkgaika12;
    }

    private String ztyyenhrkgkgoukei12;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Ty.ZTYYENHRKGKGOUKEI12)
    public String getZtyyenhrkgkgoukei12() {
        return ztyyenhrkgkgoukei12;
    }

    public void setZtyyenhrkgkgoukei12(String pZtyyenhrkgkgoukei12) {
        ztyyenhrkgkgoukei12 = pZtyyenhrkgkgoukei12;
    }

    private String ztykihrkmp12;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Ty.ZTYKIHRKMP12)
    public String getZtykihrkmp12() {
        return ztykihrkmp12;
    }

    public void setZtykihrkmp12(String pZtykihrkmp12) {
        ztykihrkmp12 = pZtykihrkmp12;
    }

    private String ztyw12;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Ty.ZTYW12)
    public String getZtyw12() {
        return ztyw12;
    }

    public void setZtyw12(String pZtyw12) {
        ztyw12 = pZtyw12;
    }

    private String ztywyenyendaka12;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Ty.ZTYWYENYENDAKA12)
    public String getZtywyenyendaka12() {
        return ztywyenyendaka12;
    }

    public void setZtywyenyendaka12(String pZtywyenyendaka12) {
        ztywyenyendaka12 = pZtywyenyendaka12;
    }

    private String ztywyenkijun12;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Ty.ZTYWYENKIJUN12)
    public String getZtywyenkijun12() {
        return ztywyenkijun12;
    }

    public void setZtywyenkijun12(String pZtywyenkijun12) {
        ztywyenkijun12 = pZtywyenkijun12;
    }

    private String ztywyenyenyasu12;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Ty.ZTYWYENYENYASU12)
    public String getZtywyenyenyasu12() {
        return ztywyenyenyasu12;
    }

    public void setZtywyenyenyasu12(String pZtywyenyenyasu12) {
        ztywyenyenyasu12 = pZtywyenyenyasu12;
    }

    private String ztykaiykuktgk12;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Ty.ZTYKAIYKUKTGK12)
    public String getZtykaiykuktgk12() {
        return ztykaiykuktgk12;
    }

    public void setZtykaiykuktgk12(String pZtykaiykuktgk12) {
        ztykaiykuktgk12 = pZtykaiykuktgk12;
    }

    private String ztykaiykuktgkyenyendaka12;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Ty.ZTYKAIYKUKTGKYENYENDAKA12)
    public String getZtykaiykuktgkyenyendaka12() {
        return ztykaiykuktgkyenyendaka12;
    }

    public void setZtykaiykuktgkyenyendaka12(String pZtykaiykuktgkyenyendaka12) {
        ztykaiykuktgkyenyendaka12 = pZtykaiykuktgkyenyendaka12;
    }

    private String ztykaiykuktgkyenkijun12;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Ty.ZTYKAIYKUKTGKYENKIJUN12)
    public String getZtykaiykuktgkyenkijun12() {
        return ztykaiykuktgkyenkijun12;
    }

    public void setZtykaiykuktgkyenkijun12(String pZtykaiykuktgkyenkijun12) {
        ztykaiykuktgkyenkijun12 = pZtykaiykuktgkyenkijun12;
    }

    private String ztykaiykuktgkyenyenyasu12;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Ty.ZTYKAIYKUKTGKYENYENYASU12)
    public String getZtykaiykuktgkyenyenyasu12() {
        return ztykaiykuktgkyenyenyasu12;
    }

    public void setZtykaiykuktgkyenyenyasu12(String pZtykaiykuktgkyenyenyasu12) {
        ztykaiykuktgkyenyenyasu12 = pZtykaiykuktgkyenyenyasu12;
    }

    private String ztykeikanensuu13;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Ty.ZTYKEIKANENSUU13)
    public String getZtykeikanensuu13() {
        return ztykeikanensuu13;
    }

    public void setZtykeikanensuu13(String pZtykeikanensuu13) {
        ztykeikanensuu13 = pZtykeikanensuu13;
    }

    private String ztyhrkkknmnryumukbn13;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Ty.ZTYHRKKKNMNRYUMUKBN13)
    public String getZtyhrkkknmnryumukbn13() {
        return ztyhrkkknmnryumukbn13;
    }

    public void setZtyhrkkknmnryumukbn13(String pZtyhrkkknmnryumukbn13) {
        ztyhrkkknmnryumukbn13 = pZtyhrkkknmnryumukbn13;
    }

    private String ztyzennouzndkyen13;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Ty.ZTYZENNOUZNDKYEN13)
    public String getZtyzennouzndkyen13() {
        return ztyzennouzndkyen13;
    }

    public void setZtyzennouzndkyen13(String pZtyzennouzndkyen13) {
        ztyzennouzndkyen13 = pZtyzennouzndkyen13;
    }

    private String ztyzennouzndkgaika13;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Ty.ZTYZENNOUZNDKGAIKA13)
    public String getZtyzennouzndkgaika13() {
        return ztyzennouzndkgaika13;
    }

    public void setZtyzennouzndkgaika13(String pZtyzennouzndkgaika13) {
        ztyzennouzndkgaika13 = pZtyzennouzndkgaika13;
    }

    private String ztyyenhrkgkgoukei13;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Ty.ZTYYENHRKGKGOUKEI13)
    public String getZtyyenhrkgkgoukei13() {
        return ztyyenhrkgkgoukei13;
    }

    public void setZtyyenhrkgkgoukei13(String pZtyyenhrkgkgoukei13) {
        ztyyenhrkgkgoukei13 = pZtyyenhrkgkgoukei13;
    }

    private String ztykihrkmp13;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Ty.ZTYKIHRKMP13)
    public String getZtykihrkmp13() {
        return ztykihrkmp13;
    }

    public void setZtykihrkmp13(String pZtykihrkmp13) {
        ztykihrkmp13 = pZtykihrkmp13;
    }

    private String ztyw13;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Ty.ZTYW13)
    public String getZtyw13() {
        return ztyw13;
    }

    public void setZtyw13(String pZtyw13) {
        ztyw13 = pZtyw13;
    }

    private String ztywyenyendaka13;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Ty.ZTYWYENYENDAKA13)
    public String getZtywyenyendaka13() {
        return ztywyenyendaka13;
    }

    public void setZtywyenyendaka13(String pZtywyenyendaka13) {
        ztywyenyendaka13 = pZtywyenyendaka13;
    }

    private String ztywyenkijun13;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Ty.ZTYWYENKIJUN13)
    public String getZtywyenkijun13() {
        return ztywyenkijun13;
    }

    public void setZtywyenkijun13(String pZtywyenkijun13) {
        ztywyenkijun13 = pZtywyenkijun13;
    }

    private String ztywyenyenyasu13;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Ty.ZTYWYENYENYASU13)
    public String getZtywyenyenyasu13() {
        return ztywyenyenyasu13;
    }

    public void setZtywyenyenyasu13(String pZtywyenyenyasu13) {
        ztywyenyenyasu13 = pZtywyenyenyasu13;
    }

    private String ztykaiykuktgk13;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Ty.ZTYKAIYKUKTGK13)
    public String getZtykaiykuktgk13() {
        return ztykaiykuktgk13;
    }

    public void setZtykaiykuktgk13(String pZtykaiykuktgk13) {
        ztykaiykuktgk13 = pZtykaiykuktgk13;
    }

    private String ztykaiykuktgkyenyendaka13;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Ty.ZTYKAIYKUKTGKYENYENDAKA13)
    public String getZtykaiykuktgkyenyendaka13() {
        return ztykaiykuktgkyenyendaka13;
    }

    public void setZtykaiykuktgkyenyendaka13(String pZtykaiykuktgkyenyendaka13) {
        ztykaiykuktgkyenyendaka13 = pZtykaiykuktgkyenyendaka13;
    }

    private String ztykaiykuktgkyenkijun13;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Ty.ZTYKAIYKUKTGKYENKIJUN13)
    public String getZtykaiykuktgkyenkijun13() {
        return ztykaiykuktgkyenkijun13;
    }

    public void setZtykaiykuktgkyenkijun13(String pZtykaiykuktgkyenkijun13) {
        ztykaiykuktgkyenkijun13 = pZtykaiykuktgkyenkijun13;
    }

    private String ztykaiykuktgkyenyenyasu13;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Ty.ZTYKAIYKUKTGKYENYENYASU13)
    public String getZtykaiykuktgkyenyenyasu13() {
        return ztykaiykuktgkyenyenyasu13;
    }

    public void setZtykaiykuktgkyenyenyasu13(String pZtykaiykuktgkyenyenyasu13) {
        ztykaiykuktgkyenyenyasu13 = pZtykaiykuktgkyenyenyasu13;
    }

    private String ztykeikanensuu14;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Ty.ZTYKEIKANENSUU14)
    public String getZtykeikanensuu14() {
        return ztykeikanensuu14;
    }

    public void setZtykeikanensuu14(String pZtykeikanensuu14) {
        ztykeikanensuu14 = pZtykeikanensuu14;
    }

    private String ztyhrkkknmnryumukbn14;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Ty.ZTYHRKKKNMNRYUMUKBN14)
    public String getZtyhrkkknmnryumukbn14() {
        return ztyhrkkknmnryumukbn14;
    }

    public void setZtyhrkkknmnryumukbn14(String pZtyhrkkknmnryumukbn14) {
        ztyhrkkknmnryumukbn14 = pZtyhrkkknmnryumukbn14;
    }

    private String ztyzennouzndkyen14;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Ty.ZTYZENNOUZNDKYEN14)
    public String getZtyzennouzndkyen14() {
        return ztyzennouzndkyen14;
    }

    public void setZtyzennouzndkyen14(String pZtyzennouzndkyen14) {
        ztyzennouzndkyen14 = pZtyzennouzndkyen14;
    }

    private String ztyzennouzndkgaika14;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Ty.ZTYZENNOUZNDKGAIKA14)
    public String getZtyzennouzndkgaika14() {
        return ztyzennouzndkgaika14;
    }

    public void setZtyzennouzndkgaika14(String pZtyzennouzndkgaika14) {
        ztyzennouzndkgaika14 = pZtyzennouzndkgaika14;
    }

    private String ztyyenhrkgkgoukei14;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Ty.ZTYYENHRKGKGOUKEI14)
    public String getZtyyenhrkgkgoukei14() {
        return ztyyenhrkgkgoukei14;
    }

    public void setZtyyenhrkgkgoukei14(String pZtyyenhrkgkgoukei14) {
        ztyyenhrkgkgoukei14 = pZtyyenhrkgkgoukei14;
    }

    private String ztykihrkmp14;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Ty.ZTYKIHRKMP14)
    public String getZtykihrkmp14() {
        return ztykihrkmp14;
    }

    public void setZtykihrkmp14(String pZtykihrkmp14) {
        ztykihrkmp14 = pZtykihrkmp14;
    }

    private String ztyw14;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Ty.ZTYW14)
    public String getZtyw14() {
        return ztyw14;
    }

    public void setZtyw14(String pZtyw14) {
        ztyw14 = pZtyw14;
    }

    private String ztywyenyendaka14;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Ty.ZTYWYENYENDAKA14)
    public String getZtywyenyendaka14() {
        return ztywyenyendaka14;
    }

    public void setZtywyenyendaka14(String pZtywyenyendaka14) {
        ztywyenyendaka14 = pZtywyenyendaka14;
    }

    private String ztywyenkijun14;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Ty.ZTYWYENKIJUN14)
    public String getZtywyenkijun14() {
        return ztywyenkijun14;
    }

    public void setZtywyenkijun14(String pZtywyenkijun14) {
        ztywyenkijun14 = pZtywyenkijun14;
    }

    private String ztywyenyenyasu14;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Ty.ZTYWYENYENYASU14)
    public String getZtywyenyenyasu14() {
        return ztywyenyenyasu14;
    }

    public void setZtywyenyenyasu14(String pZtywyenyenyasu14) {
        ztywyenyenyasu14 = pZtywyenyenyasu14;
    }

    private String ztykaiykuktgk14;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Ty.ZTYKAIYKUKTGK14)
    public String getZtykaiykuktgk14() {
        return ztykaiykuktgk14;
    }

    public void setZtykaiykuktgk14(String pZtykaiykuktgk14) {
        ztykaiykuktgk14 = pZtykaiykuktgk14;
    }

    private String ztykaiykuktgkyenyendaka14;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Ty.ZTYKAIYKUKTGKYENYENDAKA14)
    public String getZtykaiykuktgkyenyendaka14() {
        return ztykaiykuktgkyenyendaka14;
    }

    public void setZtykaiykuktgkyenyendaka14(String pZtykaiykuktgkyenyendaka14) {
        ztykaiykuktgkyenyendaka14 = pZtykaiykuktgkyenyendaka14;
    }

    private String ztykaiykuktgkyenkijun14;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Ty.ZTYKAIYKUKTGKYENKIJUN14)
    public String getZtykaiykuktgkyenkijun14() {
        return ztykaiykuktgkyenkijun14;
    }

    public void setZtykaiykuktgkyenkijun14(String pZtykaiykuktgkyenkijun14) {
        ztykaiykuktgkyenkijun14 = pZtykaiykuktgkyenkijun14;
    }

    private String ztykaiykuktgkyenyenyasu14;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Ty.ZTYKAIYKUKTGKYENYENYASU14)
    public String getZtykaiykuktgkyenyenyasu14() {
        return ztykaiykuktgkyenyenyasu14;
    }

    public void setZtykaiykuktgkyenyenyasu14(String pZtykaiykuktgkyenyenyasu14) {
        ztykaiykuktgkyenyenyasu14 = pZtykaiykuktgkyenyenyasu14;
    }

    private String ztykeikanensuu15;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Ty.ZTYKEIKANENSUU15)
    public String getZtykeikanensuu15() {
        return ztykeikanensuu15;
    }

    public void setZtykeikanensuu15(String pZtykeikanensuu15) {
        ztykeikanensuu15 = pZtykeikanensuu15;
    }

    private String ztyhrkkknmnryumukbn15;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Ty.ZTYHRKKKNMNRYUMUKBN15)
    public String getZtyhrkkknmnryumukbn15() {
        return ztyhrkkknmnryumukbn15;
    }

    public void setZtyhrkkknmnryumukbn15(String pZtyhrkkknmnryumukbn15) {
        ztyhrkkknmnryumukbn15 = pZtyhrkkknmnryumukbn15;
    }

    private String ztyzennouzndkyen15;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Ty.ZTYZENNOUZNDKYEN15)
    public String getZtyzennouzndkyen15() {
        return ztyzennouzndkyen15;
    }

    public void setZtyzennouzndkyen15(String pZtyzennouzndkyen15) {
        ztyzennouzndkyen15 = pZtyzennouzndkyen15;
    }

    private String ztyzennouzndkgaika15;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Ty.ZTYZENNOUZNDKGAIKA15)
    public String getZtyzennouzndkgaika15() {
        return ztyzennouzndkgaika15;
    }

    public void setZtyzennouzndkgaika15(String pZtyzennouzndkgaika15) {
        ztyzennouzndkgaika15 = pZtyzennouzndkgaika15;
    }

    private String ztyyenhrkgkgoukei15;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Ty.ZTYYENHRKGKGOUKEI15)
    public String getZtyyenhrkgkgoukei15() {
        return ztyyenhrkgkgoukei15;
    }

    public void setZtyyenhrkgkgoukei15(String pZtyyenhrkgkgoukei15) {
        ztyyenhrkgkgoukei15 = pZtyyenhrkgkgoukei15;
    }

    private String ztykihrkmp15;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Ty.ZTYKIHRKMP15)
    public String getZtykihrkmp15() {
        return ztykihrkmp15;
    }

    public void setZtykihrkmp15(String pZtykihrkmp15) {
        ztykihrkmp15 = pZtykihrkmp15;
    }

    private String ztyw15;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Ty.ZTYW15)
    public String getZtyw15() {
        return ztyw15;
    }

    public void setZtyw15(String pZtyw15) {
        ztyw15 = pZtyw15;
    }

    private String ztywyenyendaka15;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Ty.ZTYWYENYENDAKA15)
    public String getZtywyenyendaka15() {
        return ztywyenyendaka15;
    }

    public void setZtywyenyendaka15(String pZtywyenyendaka15) {
        ztywyenyendaka15 = pZtywyenyendaka15;
    }

    private String ztywyenkijun15;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Ty.ZTYWYENKIJUN15)
    public String getZtywyenkijun15() {
        return ztywyenkijun15;
    }

    public void setZtywyenkijun15(String pZtywyenkijun15) {
        ztywyenkijun15 = pZtywyenkijun15;
    }

    private String ztywyenyenyasu15;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Ty.ZTYWYENYENYASU15)
    public String getZtywyenyenyasu15() {
        return ztywyenyenyasu15;
    }

    public void setZtywyenyenyasu15(String pZtywyenyenyasu15) {
        ztywyenyenyasu15 = pZtywyenyenyasu15;
    }

    private String ztykaiykuktgk15;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Ty.ZTYKAIYKUKTGK15)
    public String getZtykaiykuktgk15() {
        return ztykaiykuktgk15;
    }

    public void setZtykaiykuktgk15(String pZtykaiykuktgk15) {
        ztykaiykuktgk15 = pZtykaiykuktgk15;
    }

    private String ztykaiykuktgkyenyendaka15;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Ty.ZTYKAIYKUKTGKYENYENDAKA15)
    public String getZtykaiykuktgkyenyendaka15() {
        return ztykaiykuktgkyenyendaka15;
    }

    public void setZtykaiykuktgkyenyendaka15(String pZtykaiykuktgkyenyendaka15) {
        ztykaiykuktgkyenyendaka15 = pZtykaiykuktgkyenyendaka15;
    }

    private String ztykaiykuktgkyenkijun15;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Ty.ZTYKAIYKUKTGKYENKIJUN15)
    public String getZtykaiykuktgkyenkijun15() {
        return ztykaiykuktgkyenkijun15;
    }

    public void setZtykaiykuktgkyenkijun15(String pZtykaiykuktgkyenkijun15) {
        ztykaiykuktgkyenkijun15 = pZtykaiykuktgkyenkijun15;
    }

    private String ztykaiykuktgkyenyenyasu15;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Ty.ZTYKAIYKUKTGKYENYENYASU15)
    public String getZtykaiykuktgkyenyenyasu15() {
        return ztykaiykuktgkyenyenyasu15;
    }

    public void setZtykaiykuktgkyenyenyasu15(String pZtykaiykuktgkyenyenyasu15) {
        ztykaiykuktgkyenyenyasu15 = pZtykaiykuktgkyenyenyasu15;
    }

    private String ztykeikanensuu16;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Ty.ZTYKEIKANENSUU16)
    public String getZtykeikanensuu16() {
        return ztykeikanensuu16;
    }

    public void setZtykeikanensuu16(String pZtykeikanensuu16) {
        ztykeikanensuu16 = pZtykeikanensuu16;
    }

    private String ztyhrkkknmnryumukbn16;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Ty.ZTYHRKKKNMNRYUMUKBN16)
    public String getZtyhrkkknmnryumukbn16() {
        return ztyhrkkknmnryumukbn16;
    }

    public void setZtyhrkkknmnryumukbn16(String pZtyhrkkknmnryumukbn16) {
        ztyhrkkknmnryumukbn16 = pZtyhrkkknmnryumukbn16;
    }

    private String ztyzennouzndkyen16;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Ty.ZTYZENNOUZNDKYEN16)
    public String getZtyzennouzndkyen16() {
        return ztyzennouzndkyen16;
    }

    public void setZtyzennouzndkyen16(String pZtyzennouzndkyen16) {
        ztyzennouzndkyen16 = pZtyzennouzndkyen16;
    }

    private String ztyzennouzndkgaika16;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Ty.ZTYZENNOUZNDKGAIKA16)
    public String getZtyzennouzndkgaika16() {
        return ztyzennouzndkgaika16;
    }

    public void setZtyzennouzndkgaika16(String pZtyzennouzndkgaika16) {
        ztyzennouzndkgaika16 = pZtyzennouzndkgaika16;
    }

    private String ztyyenhrkgkgoukei16;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Ty.ZTYYENHRKGKGOUKEI16)
    public String getZtyyenhrkgkgoukei16() {
        return ztyyenhrkgkgoukei16;
    }

    public void setZtyyenhrkgkgoukei16(String pZtyyenhrkgkgoukei16) {
        ztyyenhrkgkgoukei16 = pZtyyenhrkgkgoukei16;
    }

    private String ztykihrkmp16;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Ty.ZTYKIHRKMP16)
    public String getZtykihrkmp16() {
        return ztykihrkmp16;
    }

    public void setZtykihrkmp16(String pZtykihrkmp16) {
        ztykihrkmp16 = pZtykihrkmp16;
    }

    private String ztyw16;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Ty.ZTYW16)
    public String getZtyw16() {
        return ztyw16;
    }

    public void setZtyw16(String pZtyw16) {
        ztyw16 = pZtyw16;
    }

    private String ztywyenyendaka16;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Ty.ZTYWYENYENDAKA16)
    public String getZtywyenyendaka16() {
        return ztywyenyendaka16;
    }

    public void setZtywyenyendaka16(String pZtywyenyendaka16) {
        ztywyenyendaka16 = pZtywyenyendaka16;
    }

    private String ztywyenkijun16;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Ty.ZTYWYENKIJUN16)
    public String getZtywyenkijun16() {
        return ztywyenkijun16;
    }

    public void setZtywyenkijun16(String pZtywyenkijun16) {
        ztywyenkijun16 = pZtywyenkijun16;
    }

    private String ztywyenyenyasu16;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Ty.ZTYWYENYENYASU16)
    public String getZtywyenyenyasu16() {
        return ztywyenyenyasu16;
    }

    public void setZtywyenyenyasu16(String pZtywyenyenyasu16) {
        ztywyenyenyasu16 = pZtywyenyenyasu16;
    }

    private String ztykaiykuktgk16;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Ty.ZTYKAIYKUKTGK16)
    public String getZtykaiykuktgk16() {
        return ztykaiykuktgk16;
    }

    public void setZtykaiykuktgk16(String pZtykaiykuktgk16) {
        ztykaiykuktgk16 = pZtykaiykuktgk16;
    }

    private String ztykaiykuktgkyenyendaka16;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Ty.ZTYKAIYKUKTGKYENYENDAKA16)
    public String getZtykaiykuktgkyenyendaka16() {
        return ztykaiykuktgkyenyendaka16;
    }

    public void setZtykaiykuktgkyenyendaka16(String pZtykaiykuktgkyenyendaka16) {
        ztykaiykuktgkyenyendaka16 = pZtykaiykuktgkyenyendaka16;
    }

    private String ztykaiykuktgkyenkijun16;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Ty.ZTYKAIYKUKTGKYENKIJUN16)
    public String getZtykaiykuktgkyenkijun16() {
        return ztykaiykuktgkyenkijun16;
    }

    public void setZtykaiykuktgkyenkijun16(String pZtykaiykuktgkyenkijun16) {
        ztykaiykuktgkyenkijun16 = pZtykaiykuktgkyenkijun16;
    }

    private String ztykaiykuktgkyenyenyasu16;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Ty.ZTYKAIYKUKTGKYENYENYASU16)
    public String getZtykaiykuktgkyenyenyasu16() {
        return ztykaiykuktgkyenyenyasu16;
    }

    public void setZtykaiykuktgkyenyenyasu16(String pZtykaiykuktgkyenyenyasu16) {
        ztykaiykuktgkyenyenyasu16 = pZtykaiykuktgkyenyenyasu16;
    }

    private String ztykeikanensuu17;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Ty.ZTYKEIKANENSUU17)
    public String getZtykeikanensuu17() {
        return ztykeikanensuu17;
    }

    public void setZtykeikanensuu17(String pZtykeikanensuu17) {
        ztykeikanensuu17 = pZtykeikanensuu17;
    }

    private String ztyhrkkknmnryumukbn17;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Ty.ZTYHRKKKNMNRYUMUKBN17)
    public String getZtyhrkkknmnryumukbn17() {
        return ztyhrkkknmnryumukbn17;
    }

    public void setZtyhrkkknmnryumukbn17(String pZtyhrkkknmnryumukbn17) {
        ztyhrkkknmnryumukbn17 = pZtyhrkkknmnryumukbn17;
    }

    private String ztyzennouzndkyen17;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Ty.ZTYZENNOUZNDKYEN17)
    public String getZtyzennouzndkyen17() {
        return ztyzennouzndkyen17;
    }

    public void setZtyzennouzndkyen17(String pZtyzennouzndkyen17) {
        ztyzennouzndkyen17 = pZtyzennouzndkyen17;
    }

    private String ztyzennouzndkgaika17;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Ty.ZTYZENNOUZNDKGAIKA17)
    public String getZtyzennouzndkgaika17() {
        return ztyzennouzndkgaika17;
    }

    public void setZtyzennouzndkgaika17(String pZtyzennouzndkgaika17) {
        ztyzennouzndkgaika17 = pZtyzennouzndkgaika17;
    }

    private String ztyyenhrkgkgoukei17;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Ty.ZTYYENHRKGKGOUKEI17)
    public String getZtyyenhrkgkgoukei17() {
        return ztyyenhrkgkgoukei17;
    }

    public void setZtyyenhrkgkgoukei17(String pZtyyenhrkgkgoukei17) {
        ztyyenhrkgkgoukei17 = pZtyyenhrkgkgoukei17;
    }

    private String ztykihrkmp17;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Ty.ZTYKIHRKMP17)
    public String getZtykihrkmp17() {
        return ztykihrkmp17;
    }

    public void setZtykihrkmp17(String pZtykihrkmp17) {
        ztykihrkmp17 = pZtykihrkmp17;
    }

    private String ztyw17;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Ty.ZTYW17)
    public String getZtyw17() {
        return ztyw17;
    }

    public void setZtyw17(String pZtyw17) {
        ztyw17 = pZtyw17;
    }

    private String ztywyenyendaka17;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Ty.ZTYWYENYENDAKA17)
    public String getZtywyenyendaka17() {
        return ztywyenyendaka17;
    }

    public void setZtywyenyendaka17(String pZtywyenyendaka17) {
        ztywyenyendaka17 = pZtywyenyendaka17;
    }

    private String ztywyenkijun17;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Ty.ZTYWYENKIJUN17)
    public String getZtywyenkijun17() {
        return ztywyenkijun17;
    }

    public void setZtywyenkijun17(String pZtywyenkijun17) {
        ztywyenkijun17 = pZtywyenkijun17;
    }

    private String ztywyenyenyasu17;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Ty.ZTYWYENYENYASU17)
    public String getZtywyenyenyasu17() {
        return ztywyenyenyasu17;
    }

    public void setZtywyenyenyasu17(String pZtywyenyenyasu17) {
        ztywyenyenyasu17 = pZtywyenyenyasu17;
    }

    private String ztykaiykuktgk17;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Ty.ZTYKAIYKUKTGK17)
    public String getZtykaiykuktgk17() {
        return ztykaiykuktgk17;
    }

    public void setZtykaiykuktgk17(String pZtykaiykuktgk17) {
        ztykaiykuktgk17 = pZtykaiykuktgk17;
    }

    private String ztykaiykuktgkyenyendaka17;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Ty.ZTYKAIYKUKTGKYENYENDAKA17)
    public String getZtykaiykuktgkyenyendaka17() {
        return ztykaiykuktgkyenyendaka17;
    }

    public void setZtykaiykuktgkyenyendaka17(String pZtykaiykuktgkyenyendaka17) {
        ztykaiykuktgkyenyendaka17 = pZtykaiykuktgkyenyendaka17;
    }

    private String ztykaiykuktgkyenkijun17;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Ty.ZTYKAIYKUKTGKYENKIJUN17)
    public String getZtykaiykuktgkyenkijun17() {
        return ztykaiykuktgkyenkijun17;
    }

    public void setZtykaiykuktgkyenkijun17(String pZtykaiykuktgkyenkijun17) {
        ztykaiykuktgkyenkijun17 = pZtykaiykuktgkyenkijun17;
    }

    private String ztykaiykuktgkyenyenyasu17;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Ty.ZTYKAIYKUKTGKYENYENYASU17)
    public String getZtykaiykuktgkyenyenyasu17() {
        return ztykaiykuktgkyenyenyasu17;
    }

    public void setZtykaiykuktgkyenyenyasu17(String pZtykaiykuktgkyenyenyasu17) {
        ztykaiykuktgkyenyenyasu17 = pZtykaiykuktgkyenyenyasu17;
    }

    private String ztykeikanensuu18;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Ty.ZTYKEIKANENSUU18)
    public String getZtykeikanensuu18() {
        return ztykeikanensuu18;
    }

    public void setZtykeikanensuu18(String pZtykeikanensuu18) {
        ztykeikanensuu18 = pZtykeikanensuu18;
    }

    private String ztyhrkkknmnryumukbn18;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Ty.ZTYHRKKKNMNRYUMUKBN18)
    public String getZtyhrkkknmnryumukbn18() {
        return ztyhrkkknmnryumukbn18;
    }

    public void setZtyhrkkknmnryumukbn18(String pZtyhrkkknmnryumukbn18) {
        ztyhrkkknmnryumukbn18 = pZtyhrkkknmnryumukbn18;
    }

    private String ztyzennouzndkyen18;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Ty.ZTYZENNOUZNDKYEN18)
    public String getZtyzennouzndkyen18() {
        return ztyzennouzndkyen18;
    }

    public void setZtyzennouzndkyen18(String pZtyzennouzndkyen18) {
        ztyzennouzndkyen18 = pZtyzennouzndkyen18;
    }

    private String ztyzennouzndkgaika18;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Ty.ZTYZENNOUZNDKGAIKA18)
    public String getZtyzennouzndkgaika18() {
        return ztyzennouzndkgaika18;
    }

    public void setZtyzennouzndkgaika18(String pZtyzennouzndkgaika18) {
        ztyzennouzndkgaika18 = pZtyzennouzndkgaika18;
    }

    private String ztyyenhrkgkgoukei18;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Ty.ZTYYENHRKGKGOUKEI18)
    public String getZtyyenhrkgkgoukei18() {
        return ztyyenhrkgkgoukei18;
    }

    public void setZtyyenhrkgkgoukei18(String pZtyyenhrkgkgoukei18) {
        ztyyenhrkgkgoukei18 = pZtyyenhrkgkgoukei18;
    }

    private String ztykihrkmp18;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Ty.ZTYKIHRKMP18)
    public String getZtykihrkmp18() {
        return ztykihrkmp18;
    }

    public void setZtykihrkmp18(String pZtykihrkmp18) {
        ztykihrkmp18 = pZtykihrkmp18;
    }

    private String ztyw18;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Ty.ZTYW18)
    public String getZtyw18() {
        return ztyw18;
    }

    public void setZtyw18(String pZtyw18) {
        ztyw18 = pZtyw18;
    }

    private String ztywyenyendaka18;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Ty.ZTYWYENYENDAKA18)
    public String getZtywyenyendaka18() {
        return ztywyenyendaka18;
    }

    public void setZtywyenyendaka18(String pZtywyenyendaka18) {
        ztywyenyendaka18 = pZtywyenyendaka18;
    }

    private String ztywyenkijun18;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Ty.ZTYWYENKIJUN18)
    public String getZtywyenkijun18() {
        return ztywyenkijun18;
    }

    public void setZtywyenkijun18(String pZtywyenkijun18) {
        ztywyenkijun18 = pZtywyenkijun18;
    }

    private String ztywyenyenyasu18;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Ty.ZTYWYENYENYASU18)
    public String getZtywyenyenyasu18() {
        return ztywyenyenyasu18;
    }

    public void setZtywyenyenyasu18(String pZtywyenyenyasu18) {
        ztywyenyenyasu18 = pZtywyenyenyasu18;
    }

    private String ztykaiykuktgk18;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Ty.ZTYKAIYKUKTGK18)
    public String getZtykaiykuktgk18() {
        return ztykaiykuktgk18;
    }

    public void setZtykaiykuktgk18(String pZtykaiykuktgk18) {
        ztykaiykuktgk18 = pZtykaiykuktgk18;
    }

    private String ztykaiykuktgkyenyendaka18;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Ty.ZTYKAIYKUKTGKYENYENDAKA18)
    public String getZtykaiykuktgkyenyendaka18() {
        return ztykaiykuktgkyenyendaka18;
    }

    public void setZtykaiykuktgkyenyendaka18(String pZtykaiykuktgkyenyendaka18) {
        ztykaiykuktgkyenyendaka18 = pZtykaiykuktgkyenyendaka18;
    }

    private String ztykaiykuktgkyenkijun18;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Ty.ZTYKAIYKUKTGKYENKIJUN18)
    public String getZtykaiykuktgkyenkijun18() {
        return ztykaiykuktgkyenkijun18;
    }

    public void setZtykaiykuktgkyenkijun18(String pZtykaiykuktgkyenkijun18) {
        ztykaiykuktgkyenkijun18 = pZtykaiykuktgkyenkijun18;
    }

    private String ztykaiykuktgkyenyenyasu18;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Ty.ZTYKAIYKUKTGKYENYENYASU18)
    public String getZtykaiykuktgkyenyenyasu18() {
        return ztykaiykuktgkyenyenyasu18;
    }

    public void setZtykaiykuktgkyenyenyasu18(String pZtykaiykuktgkyenyenyasu18) {
        ztykaiykuktgkyenyenyasu18 = pZtykaiykuktgkyenyenyasu18;
    }

    private String ztykeikanensuu19;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Ty.ZTYKEIKANENSUU19)
    public String getZtykeikanensuu19() {
        return ztykeikanensuu19;
    }

    public void setZtykeikanensuu19(String pZtykeikanensuu19) {
        ztykeikanensuu19 = pZtykeikanensuu19;
    }

    private String ztyhrkkknmnryumukbn19;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Ty.ZTYHRKKKNMNRYUMUKBN19)
    public String getZtyhrkkknmnryumukbn19() {
        return ztyhrkkknmnryumukbn19;
    }

    public void setZtyhrkkknmnryumukbn19(String pZtyhrkkknmnryumukbn19) {
        ztyhrkkknmnryumukbn19 = pZtyhrkkknmnryumukbn19;
    }

    private String ztyzennouzndkyen19;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Ty.ZTYZENNOUZNDKYEN19)
    public String getZtyzennouzndkyen19() {
        return ztyzennouzndkyen19;
    }

    public void setZtyzennouzndkyen19(String pZtyzennouzndkyen19) {
        ztyzennouzndkyen19 = pZtyzennouzndkyen19;
    }

    private String ztyzennouzndkgaika19;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Ty.ZTYZENNOUZNDKGAIKA19)
    public String getZtyzennouzndkgaika19() {
        return ztyzennouzndkgaika19;
    }

    public void setZtyzennouzndkgaika19(String pZtyzennouzndkgaika19) {
        ztyzennouzndkgaika19 = pZtyzennouzndkgaika19;
    }

    private String ztyyenhrkgkgoukei19;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Ty.ZTYYENHRKGKGOUKEI19)
    public String getZtyyenhrkgkgoukei19() {
        return ztyyenhrkgkgoukei19;
    }

    public void setZtyyenhrkgkgoukei19(String pZtyyenhrkgkgoukei19) {
        ztyyenhrkgkgoukei19 = pZtyyenhrkgkgoukei19;
    }

    private String ztykihrkmp19;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Ty.ZTYKIHRKMP19)
    public String getZtykihrkmp19() {
        return ztykihrkmp19;
    }

    public void setZtykihrkmp19(String pZtykihrkmp19) {
        ztykihrkmp19 = pZtykihrkmp19;
    }

    private String ztyw19;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Ty.ZTYW19)
    public String getZtyw19() {
        return ztyw19;
    }

    public void setZtyw19(String pZtyw19) {
        ztyw19 = pZtyw19;
    }

    private String ztywyenyendaka19;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Ty.ZTYWYENYENDAKA19)
    public String getZtywyenyendaka19() {
        return ztywyenyendaka19;
    }

    public void setZtywyenyendaka19(String pZtywyenyendaka19) {
        ztywyenyendaka19 = pZtywyenyendaka19;
    }

    private String ztywyenkijun19;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Ty.ZTYWYENKIJUN19)
    public String getZtywyenkijun19() {
        return ztywyenkijun19;
    }

    public void setZtywyenkijun19(String pZtywyenkijun19) {
        ztywyenkijun19 = pZtywyenkijun19;
    }

    private String ztywyenyenyasu19;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Ty.ZTYWYENYENYASU19)
    public String getZtywyenyenyasu19() {
        return ztywyenyenyasu19;
    }

    public void setZtywyenyenyasu19(String pZtywyenyenyasu19) {
        ztywyenyenyasu19 = pZtywyenyenyasu19;
    }

    private String ztykaiykuktgk19;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Ty.ZTYKAIYKUKTGK19)
    public String getZtykaiykuktgk19() {
        return ztykaiykuktgk19;
    }

    public void setZtykaiykuktgk19(String pZtykaiykuktgk19) {
        ztykaiykuktgk19 = pZtykaiykuktgk19;
    }

    private String ztykaiykuktgkyenyendaka19;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Ty.ZTYKAIYKUKTGKYENYENDAKA19)
    public String getZtykaiykuktgkyenyendaka19() {
        return ztykaiykuktgkyenyendaka19;
    }

    public void setZtykaiykuktgkyenyendaka19(String pZtykaiykuktgkyenyendaka19) {
        ztykaiykuktgkyenyendaka19 = pZtykaiykuktgkyenyendaka19;
    }

    private String ztykaiykuktgkyenkijun19;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Ty.ZTYKAIYKUKTGKYENKIJUN19)
    public String getZtykaiykuktgkyenkijun19() {
        return ztykaiykuktgkyenkijun19;
    }

    public void setZtykaiykuktgkyenkijun19(String pZtykaiykuktgkyenkijun19) {
        ztykaiykuktgkyenkijun19 = pZtykaiykuktgkyenkijun19;
    }

    private String ztykaiykuktgkyenyenyasu19;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Ty.ZTYKAIYKUKTGKYENYENYASU19)
    public String getZtykaiykuktgkyenyenyasu19() {
        return ztykaiykuktgkyenyenyasu19;
    }

    public void setZtykaiykuktgkyenyenyasu19(String pZtykaiykuktgkyenyenyasu19) {
        ztykaiykuktgkyenyenyasu19 = pZtykaiykuktgkyenyenyasu19;
    }

    private String ztykeikanensuu20;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Ty.ZTYKEIKANENSUU20)
    public String getZtykeikanensuu20() {
        return ztykeikanensuu20;
    }

    public void setZtykeikanensuu20(String pZtykeikanensuu20) {
        ztykeikanensuu20 = pZtykeikanensuu20;
    }

    private String ztyhrkkknmnryumukbn20;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Ty.ZTYHRKKKNMNRYUMUKBN20)
    public String getZtyhrkkknmnryumukbn20() {
        return ztyhrkkknmnryumukbn20;
    }

    public void setZtyhrkkknmnryumukbn20(String pZtyhrkkknmnryumukbn20) {
        ztyhrkkknmnryumukbn20 = pZtyhrkkknmnryumukbn20;
    }

    private String ztyzennouzndkyen20;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Ty.ZTYZENNOUZNDKYEN20)
    public String getZtyzennouzndkyen20() {
        return ztyzennouzndkyen20;
    }

    public void setZtyzennouzndkyen20(String pZtyzennouzndkyen20) {
        ztyzennouzndkyen20 = pZtyzennouzndkyen20;
    }

    private String ztyzennouzndkgaika20;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Ty.ZTYZENNOUZNDKGAIKA20)
    public String getZtyzennouzndkgaika20() {
        return ztyzennouzndkgaika20;
    }

    public void setZtyzennouzndkgaika20(String pZtyzennouzndkgaika20) {
        ztyzennouzndkgaika20 = pZtyzennouzndkgaika20;
    }

    private String ztyyenhrkgkgoukei20;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Ty.ZTYYENHRKGKGOUKEI20)
    public String getZtyyenhrkgkgoukei20() {
        return ztyyenhrkgkgoukei20;
    }

    public void setZtyyenhrkgkgoukei20(String pZtyyenhrkgkgoukei20) {
        ztyyenhrkgkgoukei20 = pZtyyenhrkgkgoukei20;
    }

    private String ztykihrkmp20;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Ty.ZTYKIHRKMP20)
    public String getZtykihrkmp20() {
        return ztykihrkmp20;
    }

    public void setZtykihrkmp20(String pZtykihrkmp20) {
        ztykihrkmp20 = pZtykihrkmp20;
    }

    private String ztyw20;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Ty.ZTYW20)
    public String getZtyw20() {
        return ztyw20;
    }

    public void setZtyw20(String pZtyw20) {
        ztyw20 = pZtyw20;
    }

    private String ztywyenyendaka20;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Ty.ZTYWYENYENDAKA20)
    public String getZtywyenyendaka20() {
        return ztywyenyendaka20;
    }

    public void setZtywyenyendaka20(String pZtywyenyendaka20) {
        ztywyenyendaka20 = pZtywyenyendaka20;
    }

    private String ztywyenkijun20;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Ty.ZTYWYENKIJUN20)
    public String getZtywyenkijun20() {
        return ztywyenkijun20;
    }

    public void setZtywyenkijun20(String pZtywyenkijun20) {
        ztywyenkijun20 = pZtywyenkijun20;
    }

    private String ztywyenyenyasu20;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Ty.ZTYWYENYENYASU20)
    public String getZtywyenyenyasu20() {
        return ztywyenyenyasu20;
    }

    public void setZtywyenyenyasu20(String pZtywyenyenyasu20) {
        ztywyenyenyasu20 = pZtywyenyenyasu20;
    }

    private String ztykaiykuktgk20;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Ty.ZTYKAIYKUKTGK20)
    public String getZtykaiykuktgk20() {
        return ztykaiykuktgk20;
    }

    public void setZtykaiykuktgk20(String pZtykaiykuktgk20) {
        ztykaiykuktgk20 = pZtykaiykuktgk20;
    }

    private String ztykaiykuktgkyenyendaka20;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Ty.ZTYKAIYKUKTGKYENYENDAKA20)
    public String getZtykaiykuktgkyenyendaka20() {
        return ztykaiykuktgkyenyendaka20;
    }

    public void setZtykaiykuktgkyenyendaka20(String pZtykaiykuktgkyenyendaka20) {
        ztykaiykuktgkyenyendaka20 = pZtykaiykuktgkyenyendaka20;
    }

    private String ztykaiykuktgkyenkijun20;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Ty.ZTYKAIYKUKTGKYENKIJUN20)
    public String getZtykaiykuktgkyenkijun20() {
        return ztykaiykuktgkyenkijun20;
    }

    public void setZtykaiykuktgkyenkijun20(String pZtykaiykuktgkyenkijun20) {
        ztykaiykuktgkyenkijun20 = pZtykaiykuktgkyenkijun20;
    }

    private String ztykaiykuktgkyenyenyasu20;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Ty.ZTYKAIYKUKTGKYENYENYASU20)
    public String getZtykaiykuktgkyenyenyasu20() {
        return ztykaiykuktgkyenyenyasu20;
    }

    public void setZtykaiykuktgkyenyenyasu20(String pZtykaiykuktgkyenyenyasu20) {
        ztykaiykuktgkyenyenyasu20 = pZtykaiykuktgkyenyenyasu20;
    }

    private String ztykeikanensuu21;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Ty.ZTYKEIKANENSUU21)
    public String getZtykeikanensuu21() {
        return ztykeikanensuu21;
    }

    public void setZtykeikanensuu21(String pZtykeikanensuu21) {
        ztykeikanensuu21 = pZtykeikanensuu21;
    }

    private String ztyhrkkknmnryumukbn21;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Ty.ZTYHRKKKNMNRYUMUKBN21)
    public String getZtyhrkkknmnryumukbn21() {
        return ztyhrkkknmnryumukbn21;
    }

    public void setZtyhrkkknmnryumukbn21(String pZtyhrkkknmnryumukbn21) {
        ztyhrkkknmnryumukbn21 = pZtyhrkkknmnryumukbn21;
    }

    private String ztyzennouzndkyen21;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Ty.ZTYZENNOUZNDKYEN21)
    public String getZtyzennouzndkyen21() {
        return ztyzennouzndkyen21;
    }

    public void setZtyzennouzndkyen21(String pZtyzennouzndkyen21) {
        ztyzennouzndkyen21 = pZtyzennouzndkyen21;
    }

    private String ztyzennouzndkgaika21;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Ty.ZTYZENNOUZNDKGAIKA21)
    public String getZtyzennouzndkgaika21() {
        return ztyzennouzndkgaika21;
    }

    public void setZtyzennouzndkgaika21(String pZtyzennouzndkgaika21) {
        ztyzennouzndkgaika21 = pZtyzennouzndkgaika21;
    }

    private String ztyyenhrkgkgoukei21;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Ty.ZTYYENHRKGKGOUKEI21)
    public String getZtyyenhrkgkgoukei21() {
        return ztyyenhrkgkgoukei21;
    }

    public void setZtyyenhrkgkgoukei21(String pZtyyenhrkgkgoukei21) {
        ztyyenhrkgkgoukei21 = pZtyyenhrkgkgoukei21;
    }

    private String ztykihrkmp21;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Ty.ZTYKIHRKMP21)
    public String getZtykihrkmp21() {
        return ztykihrkmp21;
    }

    public void setZtykihrkmp21(String pZtykihrkmp21) {
        ztykihrkmp21 = pZtykihrkmp21;
    }

    private String ztyw21;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Ty.ZTYW21)
    public String getZtyw21() {
        return ztyw21;
    }

    public void setZtyw21(String pZtyw21) {
        ztyw21 = pZtyw21;
    }

    private String ztywyenyendaka21;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Ty.ZTYWYENYENDAKA21)
    public String getZtywyenyendaka21() {
        return ztywyenyendaka21;
    }

    public void setZtywyenyendaka21(String pZtywyenyendaka21) {
        ztywyenyendaka21 = pZtywyenyendaka21;
    }

    private String ztywyenkijun21;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Ty.ZTYWYENKIJUN21)
    public String getZtywyenkijun21() {
        return ztywyenkijun21;
    }

    public void setZtywyenkijun21(String pZtywyenkijun21) {
        ztywyenkijun21 = pZtywyenkijun21;
    }

    private String ztywyenyenyasu21;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Ty.ZTYWYENYENYASU21)
    public String getZtywyenyenyasu21() {
        return ztywyenyenyasu21;
    }

    public void setZtywyenyenyasu21(String pZtywyenyenyasu21) {
        ztywyenyenyasu21 = pZtywyenyenyasu21;
    }

    private String ztykaiykuktgk21;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Ty.ZTYKAIYKUKTGK21)
    public String getZtykaiykuktgk21() {
        return ztykaiykuktgk21;
    }

    public void setZtykaiykuktgk21(String pZtykaiykuktgk21) {
        ztykaiykuktgk21 = pZtykaiykuktgk21;
    }

    private String ztykaiykuktgkyenyendaka21;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Ty.ZTYKAIYKUKTGKYENYENDAKA21)
    public String getZtykaiykuktgkyenyendaka21() {
        return ztykaiykuktgkyenyendaka21;
    }

    public void setZtykaiykuktgkyenyendaka21(String pZtykaiykuktgkyenyendaka21) {
        ztykaiykuktgkyenyendaka21 = pZtykaiykuktgkyenyendaka21;
    }

    private String ztykaiykuktgkyenkijun21;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Ty.ZTYKAIYKUKTGKYENKIJUN21)
    public String getZtykaiykuktgkyenkijun21() {
        return ztykaiykuktgkyenkijun21;
    }

    public void setZtykaiykuktgkyenkijun21(String pZtykaiykuktgkyenkijun21) {
        ztykaiykuktgkyenkijun21 = pZtykaiykuktgkyenkijun21;
    }

    private String ztykaiykuktgkyenyenyasu21;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Ty.ZTYKAIYKUKTGKYENYENYASU21)
    public String getZtykaiykuktgkyenyenyasu21() {
        return ztykaiykuktgkyenyenyasu21;
    }

    public void setZtykaiykuktgkyenyenyasu21(String pZtykaiykuktgkyenyenyasu21) {
        ztykaiykuktgkyenyenyasu21 = pZtykaiykuktgkyenyenyasu21;
    }

    private String ztykeikanensuu22;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Ty.ZTYKEIKANENSUU22)
    public String getZtykeikanensuu22() {
        return ztykeikanensuu22;
    }

    public void setZtykeikanensuu22(String pZtykeikanensuu22) {
        ztykeikanensuu22 = pZtykeikanensuu22;
    }

    private String ztyhrkkknmnryumukbn22;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Ty.ZTYHRKKKNMNRYUMUKBN22)
    public String getZtyhrkkknmnryumukbn22() {
        return ztyhrkkknmnryumukbn22;
    }

    public void setZtyhrkkknmnryumukbn22(String pZtyhrkkknmnryumukbn22) {
        ztyhrkkknmnryumukbn22 = pZtyhrkkknmnryumukbn22;
    }

    private String ztyzennouzndkyen22;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Ty.ZTYZENNOUZNDKYEN22)
    public String getZtyzennouzndkyen22() {
        return ztyzennouzndkyen22;
    }

    public void setZtyzennouzndkyen22(String pZtyzennouzndkyen22) {
        ztyzennouzndkyen22 = pZtyzennouzndkyen22;
    }

    private String ztyzennouzndkgaika22;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Ty.ZTYZENNOUZNDKGAIKA22)
    public String getZtyzennouzndkgaika22() {
        return ztyzennouzndkgaika22;
    }

    public void setZtyzennouzndkgaika22(String pZtyzennouzndkgaika22) {
        ztyzennouzndkgaika22 = pZtyzennouzndkgaika22;
    }

    private String ztyyenhrkgkgoukei22;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Ty.ZTYYENHRKGKGOUKEI22)
    public String getZtyyenhrkgkgoukei22() {
        return ztyyenhrkgkgoukei22;
    }

    public void setZtyyenhrkgkgoukei22(String pZtyyenhrkgkgoukei22) {
        ztyyenhrkgkgoukei22 = pZtyyenhrkgkgoukei22;
    }

    private String ztykihrkmp22;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Ty.ZTYKIHRKMP22)
    public String getZtykihrkmp22() {
        return ztykihrkmp22;
    }

    public void setZtykihrkmp22(String pZtykihrkmp22) {
        ztykihrkmp22 = pZtykihrkmp22;
    }

    private String ztyw22;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Ty.ZTYW22)
    public String getZtyw22() {
        return ztyw22;
    }

    public void setZtyw22(String pZtyw22) {
        ztyw22 = pZtyw22;
    }

    private String ztywyenyendaka22;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Ty.ZTYWYENYENDAKA22)
    public String getZtywyenyendaka22() {
        return ztywyenyendaka22;
    }

    public void setZtywyenyendaka22(String pZtywyenyendaka22) {
        ztywyenyendaka22 = pZtywyenyendaka22;
    }

    private String ztywyenkijun22;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Ty.ZTYWYENKIJUN22)
    public String getZtywyenkijun22() {
        return ztywyenkijun22;
    }

    public void setZtywyenkijun22(String pZtywyenkijun22) {
        ztywyenkijun22 = pZtywyenkijun22;
    }

    private String ztywyenyenyasu22;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Ty.ZTYWYENYENYASU22)
    public String getZtywyenyenyasu22() {
        return ztywyenyenyasu22;
    }

    public void setZtywyenyenyasu22(String pZtywyenyenyasu22) {
        ztywyenyenyasu22 = pZtywyenyenyasu22;
    }

    private String ztykaiykuktgk22;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Ty.ZTYKAIYKUKTGK22)
    public String getZtykaiykuktgk22() {
        return ztykaiykuktgk22;
    }

    public void setZtykaiykuktgk22(String pZtykaiykuktgk22) {
        ztykaiykuktgk22 = pZtykaiykuktgk22;
    }

    private String ztykaiykuktgkyenyendaka22;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Ty.ZTYKAIYKUKTGKYENYENDAKA22)
    public String getZtykaiykuktgkyenyendaka22() {
        return ztykaiykuktgkyenyendaka22;
    }

    public void setZtykaiykuktgkyenyendaka22(String pZtykaiykuktgkyenyendaka22) {
        ztykaiykuktgkyenyendaka22 = pZtykaiykuktgkyenyendaka22;
    }

    private String ztykaiykuktgkyenkijun22;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Ty.ZTYKAIYKUKTGKYENKIJUN22)
    public String getZtykaiykuktgkyenkijun22() {
        return ztykaiykuktgkyenkijun22;
    }

    public void setZtykaiykuktgkyenkijun22(String pZtykaiykuktgkyenkijun22) {
        ztykaiykuktgkyenkijun22 = pZtykaiykuktgkyenkijun22;
    }

    private String ztykaiykuktgkyenyenyasu22;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Ty.ZTYKAIYKUKTGKYENYENYASU22)
    public String getZtykaiykuktgkyenyenyasu22() {
        return ztykaiykuktgkyenyenyasu22;
    }

    public void setZtykaiykuktgkyenyenyasu22(String pZtykaiykuktgkyenyenyasu22) {
        ztykaiykuktgkyenyenyasu22 = pZtykaiykuktgkyenyenyasu22;
    }

    private String ztyyobiv196;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Ty.ZTYYOBIV196)
    public String getZtyyobiv196() {
        return ztyyobiv196;
    }

    public void setZtyyobiv196(String pZtyyobiv196) {
        ztyyobiv196 = pZtyyobiv196;
    }

    private String ztyyobiv4;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Ty.ZTYYOBIV4)
    public String getZtyyobiv4() {
        return ztyyobiv4;
    }

    public void setZtyyobiv4(String pZtyyobiv4) {
        ztyyobiv4 = pZtyyobiv4;
    }
}