package yuyu.def.db.mapping;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Padding;
import yuyu.def.db.entity.ZT_SinkeiyakuSyoukenSuii2Rn;
import yuyu.def.db.id.PKZT_SinkeiyakuSyoukenSuii2Rn;
import yuyu.def.db.meta.GenQZT_SinkeiyakuSyoukenSuii2Rn;
import yuyu.def.db.meta.QZT_SinkeiyakuSyoukenSuii2Rn;

/**
 * 新契約保険証券推移表Ｆテーブル２（連） テーブルのマッピング情報クラスで、 {@link ZT_SinkeiyakuSyoukenSuii2Rn} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_SinkeiyakuSyoukenSuii2Rn}</td><td colspan="3">新契約保険証券推移表Ｆテーブル２（連）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getZrnsyono zrnsyono}</td><td>（連携用）証券番号</td><td align="center">{@link PKZT_SinkeiyakuSyoukenSuii2Rn ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntyouhyouymd zrntyouhyouymd}</td><td>（連携用）帳票作成日</td><td align="center">{@link PKZT_SinkeiyakuSyoukenSuii2Rn ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsuiihyouptn zrnsuiihyouptn}</td><td>（連携用）推移表パターン</td><td align="center">{@link PKZT_SinkeiyakuSyoukenSuii2Rn ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsuiihyousykbn zrnsuiihyousykbn}</td><td>（連携用）推移表種別区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsuiihyousyono zrnsuiihyousyono}</td><td>（連携用）推移表証券番号</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnytirrtcalckijyunrrt zrnytirrtcalckijyunrrt}</td><td>（連携用）予定利率計算基準利率</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnwkwsrateyendaka zrnwkwsrateyendaka}</td><td>（連携用）解約返戻金為替レート（円高）</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnwkwsrateyenkijyun zrnwkwsrateyenkijyun}</td><td>（連携用）解約返戻金為替レート（中央値）</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnwkwsrateyenyasu zrnwkwsrateyenyasu}</td><td>（連携用）解約返戻金為替レート（円安）</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkyktuukatype zrnkyktuukatype}</td><td>（連携用）契約通貨タイプ</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkeikanensuu01 zrnkeikanensuu01}</td><td>（連携用）経過年数０１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhrkkknmnryumukbn01 zrnhrkkknmnryumukbn01}</td><td>（連携用）払込期間満了有無区分０１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnzennouzndkyen01 zrnzennouzndkyen01}</td><td>（連携用）前納残高（円貨）０１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnzennouzndkgaika01 zrnzennouzndkgaika01}</td><td>（連携用）前納残高０１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyenhrkgkgoukei01 zrnyenhrkgkgoukei01}</td><td>（連携用）円貨払込額の合計（円貨）０１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkihrkmp01 zrnkihrkmp01}</td><td>（連携用）既払込保険料０１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnw01 zrnw01}</td><td>（連携用）解約返戻金０１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnwyenyendaka01 zrnwyenyendaka01}</td><td>（連携用）解約返戻金（円貨）円高０１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnwyenkijun01 zrnwyenkijun01}</td><td>（連携用）解約返戻金（円貨）中央値０１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnwyenyenyasu01 zrnwyenyenyasu01}</td><td>（連携用）解約返戻金（円貨）円安０１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkaiykuktgk01 zrnkaiykuktgk01}</td><td>（連携用）解約時受取額０１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkaiykuktgkyenyendaka01 zrnkaiykuktgkyenyendaka01}</td><td>（連携用）解約時受取額（円貨）円高０１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkaiykuktgkyenkijun01 zrnkaiykuktgkyenkijun01}</td><td>（連携用）解約時受取額（円貨）中央値０１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkaiykuktgkyenyenyasu01 zrnkaiykuktgkyenyenyasu01}</td><td>（連携用）解約時受取額（円貨）円安０１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkeikanensuu02 zrnkeikanensuu02}</td><td>（連携用）経過年数０２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhrkkknmnryumukbn02 zrnhrkkknmnryumukbn02}</td><td>（連携用）払込期間満了有無区分０２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnzennouzndkyen02 zrnzennouzndkyen02}</td><td>（連携用）前納残高（円貨）０２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnzennouzndkgaika02 zrnzennouzndkgaika02}</td><td>（連携用）前納残高０２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyenhrkgkgoukei02 zrnyenhrkgkgoukei02}</td><td>（連携用）円貨払込額の合計（円貨）０２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkihrkmp02 zrnkihrkmp02}</td><td>（連携用）既払込保険料０２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnw02 zrnw02}</td><td>（連携用）解約返戻金０２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnwyenyendaka02 zrnwyenyendaka02}</td><td>（連携用）解約返戻金（円貨）円高０２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnwyenkijun02 zrnwyenkijun02}</td><td>（連携用）解約返戻金（円貨）中央値０２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnwyenyenyasu02 zrnwyenyenyasu02}</td><td>（連携用）解約返戻金（円貨）円安０２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkaiykuktgk02 zrnkaiykuktgk02}</td><td>（連携用）解約時受取額０２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkaiykuktgkyenyendaka02 zrnkaiykuktgkyenyendaka02}</td><td>（連携用）解約時受取額（円貨）円高０２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkaiykuktgkyenkijun02 zrnkaiykuktgkyenkijun02}</td><td>（連携用）解約時受取額（円貨）中央値０２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkaiykuktgkyenyenyasu02 zrnkaiykuktgkyenyenyasu02}</td><td>（連携用）解約時受取額（円貨）円安０２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkeikanensuu03 zrnkeikanensuu03}</td><td>（連携用）経過年数０３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhrkkknmnryumukbn03 zrnhrkkknmnryumukbn03}</td><td>（連携用）払込期間満了有無区分０３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnzennouzndkyen03 zrnzennouzndkyen03}</td><td>（連携用）前納残高（円貨）０３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnzennouzndkgaika03 zrnzennouzndkgaika03}</td><td>（連携用）前納残高０３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyenhrkgkgoukei03 zrnyenhrkgkgoukei03}</td><td>（連携用）円貨払込額の合計（円貨）０３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkihrkmp03 zrnkihrkmp03}</td><td>（連携用）既払込保険料０３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnw03 zrnw03}</td><td>（連携用）解約返戻金０３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnwyenyendaka03 zrnwyenyendaka03}</td><td>（連携用）解約返戻金（円貨）円高０３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnwyenkijun03 zrnwyenkijun03}</td><td>（連携用）解約返戻金（円貨）中央値０３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnwyenyenyasu03 zrnwyenyenyasu03}</td><td>（連携用）解約返戻金（円貨）円安０３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkaiykuktgk03 zrnkaiykuktgk03}</td><td>（連携用）解約時受取額０３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkaiykuktgkyenyendaka03 zrnkaiykuktgkyenyendaka03}</td><td>（連携用）解約時受取額（円貨）円高０３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkaiykuktgkyenkijun03 zrnkaiykuktgkyenkijun03}</td><td>（連携用）解約時受取額（円貨）中央値０３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkaiykuktgkyenyenyasu03 zrnkaiykuktgkyenyenyasu03}</td><td>（連携用）解約時受取額（円貨）円安０３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkeikanensuu04 zrnkeikanensuu04}</td><td>（連携用）経過年数０４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhrkkknmnryumukbn04 zrnhrkkknmnryumukbn04}</td><td>（連携用）払込期間満了有無区分０４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnzennouzndkyen04 zrnzennouzndkyen04}</td><td>（連携用）前納残高（円貨）０４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnzennouzndkgaika04 zrnzennouzndkgaika04}</td><td>（連携用）前納残高０４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyenhrkgkgoukei04 zrnyenhrkgkgoukei04}</td><td>（連携用）円貨払込額の合計（円貨）０４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkihrkmp04 zrnkihrkmp04}</td><td>（連携用）既払込保険料０４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnw04 zrnw04}</td><td>（連携用）解約返戻金０４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnwyenyendaka04 zrnwyenyendaka04}</td><td>（連携用）解約返戻金（円貨）円高０４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnwyenkijun04 zrnwyenkijun04}</td><td>（連携用）解約返戻金（円貨）中央値０４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnwyenyenyasu04 zrnwyenyenyasu04}</td><td>（連携用）解約返戻金（円貨）円安０４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkaiykuktgk04 zrnkaiykuktgk04}</td><td>（連携用）解約時受取額０４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkaiykuktgkyenyendaka04 zrnkaiykuktgkyenyendaka04}</td><td>（連携用）解約時受取額（円貨）円高０４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkaiykuktgkyenkijun04 zrnkaiykuktgkyenkijun04}</td><td>（連携用）解約時受取額（円貨）中央値０４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkaiykuktgkyenyenyasu04 zrnkaiykuktgkyenyenyasu04}</td><td>（連携用）解約時受取額（円貨）円安０４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkeikanensuu05 zrnkeikanensuu05}</td><td>（連携用）経過年数０５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhrkkknmnryumukbn05 zrnhrkkknmnryumukbn05}</td><td>（連携用）払込期間満了有無区分０５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnzennouzndkyen05 zrnzennouzndkyen05}</td><td>（連携用）前納残高（円貨）０５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnzennouzndkgaika05 zrnzennouzndkgaika05}</td><td>（連携用）前納残高０５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyenhrkgkgoukei05 zrnyenhrkgkgoukei05}</td><td>（連携用）円貨払込額の合計（円貨）０５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkihrkmp05 zrnkihrkmp05}</td><td>（連携用）既払込保険料０５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnw05 zrnw05}</td><td>（連携用）解約返戻金０５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnwyenyendaka05 zrnwyenyendaka05}</td><td>（連携用）解約返戻金（円貨）円高０５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnwyenkijun05 zrnwyenkijun05}</td><td>（連携用）解約返戻金（円貨）中央値０５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnwyenyenyasu05 zrnwyenyenyasu05}</td><td>（連携用）解約返戻金（円貨）円安０５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkaiykuktgk05 zrnkaiykuktgk05}</td><td>（連携用）解約時受取額０５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkaiykuktgkyenyendaka05 zrnkaiykuktgkyenyendaka05}</td><td>（連携用）解約時受取額（円貨）円高０５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkaiykuktgkyenkijun05 zrnkaiykuktgkyenkijun05}</td><td>（連携用）解約時受取額（円貨）中央値０５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkaiykuktgkyenyenyasu05 zrnkaiykuktgkyenyenyasu05}</td><td>（連携用）解約時受取額（円貨）円安０５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkeikanensuu06 zrnkeikanensuu06}</td><td>（連携用）経過年数０６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhrkkknmnryumukbn06 zrnhrkkknmnryumukbn06}</td><td>（連携用）払込期間満了有無区分０６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnzennouzndkyen06 zrnzennouzndkyen06}</td><td>（連携用）前納残高（円貨）０６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnzennouzndkgaika06 zrnzennouzndkgaika06}</td><td>（連携用）前納残高０６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyenhrkgkgoukei06 zrnyenhrkgkgoukei06}</td><td>（連携用）円貨払込額の合計（円貨）０６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkihrkmp06 zrnkihrkmp06}</td><td>（連携用）既払込保険料０６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnw06 zrnw06}</td><td>（連携用）解約返戻金０６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnwyenyendaka06 zrnwyenyendaka06}</td><td>（連携用）解約返戻金（円貨）円高０６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnwyenkijun06 zrnwyenkijun06}</td><td>（連携用）解約返戻金（円貨）中央値０６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnwyenyenyasu06 zrnwyenyenyasu06}</td><td>（連携用）解約返戻金（円貨）円安０６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkaiykuktgk06 zrnkaiykuktgk06}</td><td>（連携用）解約時受取額０６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkaiykuktgkyenyendaka06 zrnkaiykuktgkyenyendaka06}</td><td>（連携用）解約時受取額（円貨）円高０６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkaiykuktgkyenkijun06 zrnkaiykuktgkyenkijun06}</td><td>（連携用）解約時受取額（円貨）中央値０６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkaiykuktgkyenyenyasu06 zrnkaiykuktgkyenyenyasu06}</td><td>（連携用）解約時受取額（円貨）円安０６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkeikanensuu07 zrnkeikanensuu07}</td><td>（連携用）経過年数０７</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhrkkknmnryumukbn07 zrnhrkkknmnryumukbn07}</td><td>（連携用）払込期間満了有無区分０７</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnzennouzndkyen07 zrnzennouzndkyen07}</td><td>（連携用）前納残高（円貨）０７</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnzennouzndkgaika07 zrnzennouzndkgaika07}</td><td>（連携用）前納残高０７</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyenhrkgkgoukei07 zrnyenhrkgkgoukei07}</td><td>（連携用）円貨払込額の合計（円貨）０７</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkihrkmp07 zrnkihrkmp07}</td><td>（連携用）既払込保険料０７</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnw07 zrnw07}</td><td>（連携用）解約返戻金０７</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnwyenyendaka07 zrnwyenyendaka07}</td><td>（連携用）解約返戻金（円貨）円高０７</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnwyenkijun07 zrnwyenkijun07}</td><td>（連携用）解約返戻金（円貨）中央値０７</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnwyenyenyasu07 zrnwyenyenyasu07}</td><td>（連携用）解約返戻金（円貨）円安０７</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkaiykuktgk07 zrnkaiykuktgk07}</td><td>（連携用）解約時受取額０７</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkaiykuktgkyenyendaka07 zrnkaiykuktgkyenyendaka07}</td><td>（連携用）解約時受取額（円貨）円高０７</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkaiykuktgkyenkijun07 zrnkaiykuktgkyenkijun07}</td><td>（連携用）解約時受取額（円貨）中央値０７</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkaiykuktgkyenyenyasu07 zrnkaiykuktgkyenyenyasu07}</td><td>（連携用）解約時受取額（円貨）円安０７</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkeikanensuu08 zrnkeikanensuu08}</td><td>（連携用）経過年数０８</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhrkkknmnryumukbn08 zrnhrkkknmnryumukbn08}</td><td>（連携用）払込期間満了有無区分０８</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnzennouzndkyen08 zrnzennouzndkyen08}</td><td>（連携用）前納残高（円貨）０８</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnzennouzndkgaika08 zrnzennouzndkgaika08}</td><td>（連携用）前納残高０８</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyenhrkgkgoukei08 zrnyenhrkgkgoukei08}</td><td>（連携用）円貨払込額の合計（円貨）０８</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkihrkmp08 zrnkihrkmp08}</td><td>（連携用）既払込保険料０８</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnw08 zrnw08}</td><td>（連携用）解約返戻金０８</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnwyenyendaka08 zrnwyenyendaka08}</td><td>（連携用）解約返戻金（円貨）円高０８</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnwyenkijun08 zrnwyenkijun08}</td><td>（連携用）解約返戻金（円貨）中央値０８</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnwyenyenyasu08 zrnwyenyenyasu08}</td><td>（連携用）解約返戻金（円貨）円安０８</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkaiykuktgk08 zrnkaiykuktgk08}</td><td>（連携用）解約時受取額０８</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkaiykuktgkyenyendaka08 zrnkaiykuktgkyenyendaka08}</td><td>（連携用）解約時受取額（円貨）円高０８</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkaiykuktgkyenkijun08 zrnkaiykuktgkyenkijun08}</td><td>（連携用）解約時受取額（円貨）中央値０８</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkaiykuktgkyenyenyasu08 zrnkaiykuktgkyenyenyasu08}</td><td>（連携用）解約時受取額（円貨）円安０８</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkeikanensuu09 zrnkeikanensuu09}</td><td>（連携用）経過年数０９</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhrkkknmnryumukbn09 zrnhrkkknmnryumukbn09}</td><td>（連携用）払込期間満了有無区分０９</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnzennouzndkyen09 zrnzennouzndkyen09}</td><td>（連携用）前納残高（円貨）０９</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnzennouzndkgaika09 zrnzennouzndkgaika09}</td><td>（連携用）前納残高０９</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyenhrkgkgoukei09 zrnyenhrkgkgoukei09}</td><td>（連携用）円貨払込額の合計（円貨）０９</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkihrkmp09 zrnkihrkmp09}</td><td>（連携用）既払込保険料０９</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnw09 zrnw09}</td><td>（連携用）解約返戻金０９</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnwyenyendaka09 zrnwyenyendaka09}</td><td>（連携用）解約返戻金（円貨）円高０９</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnwyenkijun09 zrnwyenkijun09}</td><td>（連携用）解約返戻金（円貨）中央値０９</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnwyenyenyasu09 zrnwyenyenyasu09}</td><td>（連携用）解約返戻金（円貨）円安０９</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkaiykuktgk09 zrnkaiykuktgk09}</td><td>（連携用）解約時受取額０９</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkaiykuktgkyenyendaka09 zrnkaiykuktgkyenyendaka09}</td><td>（連携用）解約時受取額（円貨）円高０９</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkaiykuktgkyenkijun09 zrnkaiykuktgkyenkijun09}</td><td>（連携用）解約時受取額（円貨）中央値０９</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkaiykuktgkyenyenyasu09 zrnkaiykuktgkyenyenyasu09}</td><td>（連携用）解約時受取額（円貨）円安０９</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkeikanensuu10 zrnkeikanensuu10}</td><td>（連携用）経過年数１０</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhrkkknmnryumukbn10 zrnhrkkknmnryumukbn10}</td><td>（連携用）払込期間満了有無区分１０</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnzennouzndkyen10 zrnzennouzndkyen10}</td><td>（連携用）前納残高（円貨）１０</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnzennouzndkgaika10 zrnzennouzndkgaika10}</td><td>（連携用）前納残高１０</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyenhrkgkgoukei10 zrnyenhrkgkgoukei10}</td><td>（連携用）円貨払込額の合計（円貨）１０</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkihrkmp10 zrnkihrkmp10}</td><td>（連携用）既払込保険料１０</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnw10 zrnw10}</td><td>（連携用）解約返戻金１０</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnwyenyendaka10 zrnwyenyendaka10}</td><td>（連携用）解約返戻金（円貨）円高１０</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnwyenkijun10 zrnwyenkijun10}</td><td>（連携用）解約返戻金（円貨）中央値１０</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnwyenyenyasu10 zrnwyenyenyasu10}</td><td>（連携用）解約返戻金（円貨）円安１０</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkaiykuktgk10 zrnkaiykuktgk10}</td><td>（連携用）解約時受取額１０</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkaiykuktgkyenyendaka10 zrnkaiykuktgkyenyendaka10}</td><td>（連携用）解約時受取額（円貨）円高１０</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkaiykuktgkyenkijun10 zrnkaiykuktgkyenkijun10}</td><td>（連携用）解約時受取額（円貨）中央値１０</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkaiykuktgkyenyenyasu10 zrnkaiykuktgkyenyenyasu10}</td><td>（連携用）解約時受取額（円貨）円安１０</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkeikanensuu11 zrnkeikanensuu11}</td><td>（連携用）経過年数１１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhrkkknmnryumukbn11 zrnhrkkknmnryumukbn11}</td><td>（連携用）払込期間満了有無区分１１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnzennouzndkyen11 zrnzennouzndkyen11}</td><td>（連携用）前納残高（円貨）１１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnzennouzndkgaika11 zrnzennouzndkgaika11}</td><td>（連携用）前納残高１１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyenhrkgkgoukei11 zrnyenhrkgkgoukei11}</td><td>（連携用）円貨払込額の合計（円貨）１１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkihrkmp11 zrnkihrkmp11}</td><td>（連携用）既払込保険料１１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnw11 zrnw11}</td><td>（連携用）解約返戻金１１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnwyenyendaka11 zrnwyenyendaka11}</td><td>（連携用）解約返戻金（円貨）円高１１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnwyenkijun11 zrnwyenkijun11}</td><td>（連携用）解約返戻金（円貨）中央値１１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnwyenyenyasu11 zrnwyenyenyasu11}</td><td>（連携用）解約返戻金（円貨）円安１１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkaiykuktgk11 zrnkaiykuktgk11}</td><td>（連携用）解約時受取額１１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkaiykuktgkyenyendaka11 zrnkaiykuktgkyenyendaka11}</td><td>（連携用）解約時受取額（円貨）円高１１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkaiykuktgkyenkijun11 zrnkaiykuktgkyenkijun11}</td><td>（連携用）解約時受取額（円貨）中央値１１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkaiykuktgkyenyenyasu11 zrnkaiykuktgkyenyenyasu11}</td><td>（連携用）解約時受取額（円貨）円安１１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkeikanensuu12 zrnkeikanensuu12}</td><td>（連携用）経過年数１２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhrkkknmnryumukbn12 zrnhrkkknmnryumukbn12}</td><td>（連携用）払込期間満了有無区分１２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnzennouzndkyen12 zrnzennouzndkyen12}</td><td>（連携用）前納残高（円貨）１２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnzennouzndkgaika12 zrnzennouzndkgaika12}</td><td>（連携用）前納残高１２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyenhrkgkgoukei12 zrnyenhrkgkgoukei12}</td><td>（連携用）円貨払込額の合計（円貨）１２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkihrkmp12 zrnkihrkmp12}</td><td>（連携用）既払込保険料１２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnw12 zrnw12}</td><td>（連携用）解約返戻金１２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnwyenyendaka12 zrnwyenyendaka12}</td><td>（連携用）解約返戻金（円貨）円高１２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnwyenkijun12 zrnwyenkijun12}</td><td>（連携用）解約返戻金（円貨）中央値１２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnwyenyenyasu12 zrnwyenyenyasu12}</td><td>（連携用）解約返戻金（円貨）円安１２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkaiykuktgk12 zrnkaiykuktgk12}</td><td>（連携用）解約時受取額１２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkaiykuktgkyenyendaka12 zrnkaiykuktgkyenyendaka12}</td><td>（連携用）解約時受取額（円貨）円高１２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkaiykuktgkyenkijun12 zrnkaiykuktgkyenkijun12}</td><td>（連携用）解約時受取額（円貨）中央値１２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkaiykuktgkyenyenyasu12 zrnkaiykuktgkyenyenyasu12}</td><td>（連携用）解約時受取額（円貨）円安１２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkeikanensuu13 zrnkeikanensuu13}</td><td>（連携用）経過年数１３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhrkkknmnryumukbn13 zrnhrkkknmnryumukbn13}</td><td>（連携用）払込期間満了有無区分１３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnzennouzndkyen13 zrnzennouzndkyen13}</td><td>（連携用）前納残高（円貨）１３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnzennouzndkgaika13 zrnzennouzndkgaika13}</td><td>（連携用）前納残高１３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyenhrkgkgoukei13 zrnyenhrkgkgoukei13}</td><td>（連携用）円貨払込額の合計（円貨）１３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkihrkmp13 zrnkihrkmp13}</td><td>（連携用）既払込保険料１３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnw13 zrnw13}</td><td>（連携用）解約返戻金１３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnwyenyendaka13 zrnwyenyendaka13}</td><td>（連携用）解約返戻金（円貨）円高１３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnwyenkijun13 zrnwyenkijun13}</td><td>（連携用）解約返戻金（円貨）中央値１３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnwyenyenyasu13 zrnwyenyenyasu13}</td><td>（連携用）解約返戻金（円貨）円安１３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkaiykuktgk13 zrnkaiykuktgk13}</td><td>（連携用）解約時受取額１３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkaiykuktgkyenyendaka13 zrnkaiykuktgkyenyendaka13}</td><td>（連携用）解約時受取額（円貨）円高１３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkaiykuktgkyenkijun13 zrnkaiykuktgkyenkijun13}</td><td>（連携用）解約時受取額（円貨）中央値１３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkaiykuktgkyenyenyasu13 zrnkaiykuktgkyenyenyasu13}</td><td>（連携用）解約時受取額（円貨）円安１３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkeikanensuu14 zrnkeikanensuu14}</td><td>（連携用）経過年数１４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhrkkknmnryumukbn14 zrnhrkkknmnryumukbn14}</td><td>（連携用）払込期間満了有無区分１４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnzennouzndkyen14 zrnzennouzndkyen14}</td><td>（連携用）前納残高（円貨）１４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnzennouzndkgaika14 zrnzennouzndkgaika14}</td><td>（連携用）前納残高１４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyenhrkgkgoukei14 zrnyenhrkgkgoukei14}</td><td>（連携用）円貨払込額の合計（円貨）１４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkihrkmp14 zrnkihrkmp14}</td><td>（連携用）既払込保険料１４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnw14 zrnw14}</td><td>（連携用）解約返戻金１４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnwyenyendaka14 zrnwyenyendaka14}</td><td>（連携用）解約返戻金（円貨）円高１４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnwyenkijun14 zrnwyenkijun14}</td><td>（連携用）解約返戻金（円貨）中央値１４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnwyenyenyasu14 zrnwyenyenyasu14}</td><td>（連携用）解約返戻金（円貨）円安１４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkaiykuktgk14 zrnkaiykuktgk14}</td><td>（連携用）解約時受取額１４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkaiykuktgkyenyendaka14 zrnkaiykuktgkyenyendaka14}</td><td>（連携用）解約時受取額（円貨）円高１４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkaiykuktgkyenkijun14 zrnkaiykuktgkyenkijun14}</td><td>（連携用）解約時受取額（円貨）中央値１４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkaiykuktgkyenyenyasu14 zrnkaiykuktgkyenyenyasu14}</td><td>（連携用）解約時受取額（円貨）円安１４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkeikanensuu15 zrnkeikanensuu15}</td><td>（連携用）経過年数１５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhrkkknmnryumukbn15 zrnhrkkknmnryumukbn15}</td><td>（連携用）払込期間満了有無区分１５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnzennouzndkyen15 zrnzennouzndkyen15}</td><td>（連携用）前納残高（円貨）１５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnzennouzndkgaika15 zrnzennouzndkgaika15}</td><td>（連携用）前納残高１５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyenhrkgkgoukei15 zrnyenhrkgkgoukei15}</td><td>（連携用）円貨払込額の合計（円貨）１５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkihrkmp15 zrnkihrkmp15}</td><td>（連携用）既払込保険料１５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnw15 zrnw15}</td><td>（連携用）解約返戻金１５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnwyenyendaka15 zrnwyenyendaka15}</td><td>（連携用）解約返戻金（円貨）円高１５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnwyenkijun15 zrnwyenkijun15}</td><td>（連携用）解約返戻金（円貨）中央値１５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnwyenyenyasu15 zrnwyenyenyasu15}</td><td>（連携用）解約返戻金（円貨）円安１５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkaiykuktgk15 zrnkaiykuktgk15}</td><td>（連携用）解約時受取額１５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkaiykuktgkyenyendaka15 zrnkaiykuktgkyenyendaka15}</td><td>（連携用）解約時受取額（円貨）円高１５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkaiykuktgkyenkijun15 zrnkaiykuktgkyenkijun15}</td><td>（連携用）解約時受取額（円貨）中央値１５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkaiykuktgkyenyenyasu15 zrnkaiykuktgkyenyenyasu15}</td><td>（連携用）解約時受取額（円貨）円安１５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkeikanensuu16 zrnkeikanensuu16}</td><td>（連携用）経過年数１６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhrkkknmnryumukbn16 zrnhrkkknmnryumukbn16}</td><td>（連携用）払込期間満了有無区分１６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnzennouzndkyen16 zrnzennouzndkyen16}</td><td>（連携用）前納残高（円貨）１６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnzennouzndkgaika16 zrnzennouzndkgaika16}</td><td>（連携用）前納残高１６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyenhrkgkgoukei16 zrnyenhrkgkgoukei16}</td><td>（連携用）円貨払込額の合計（円貨）１６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkihrkmp16 zrnkihrkmp16}</td><td>（連携用）既払込保険料１６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnw16 zrnw16}</td><td>（連携用）解約返戻金１６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnwyenyendaka16 zrnwyenyendaka16}</td><td>（連携用）解約返戻金（円貨）円高１６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnwyenkijun16 zrnwyenkijun16}</td><td>（連携用）解約返戻金（円貨）中央値１６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnwyenyenyasu16 zrnwyenyenyasu16}</td><td>（連携用）解約返戻金（円貨）円安１６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkaiykuktgk16 zrnkaiykuktgk16}</td><td>（連携用）解約時受取額１６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkaiykuktgkyenyendaka16 zrnkaiykuktgkyenyendaka16}</td><td>（連携用）解約時受取額（円貨）円高１６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkaiykuktgkyenkijun16 zrnkaiykuktgkyenkijun16}</td><td>（連携用）解約時受取額（円貨）中央値１６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkaiykuktgkyenyenyasu16 zrnkaiykuktgkyenyenyasu16}</td><td>（連携用）解約時受取額（円貨）円安１６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkeikanensuu17 zrnkeikanensuu17}</td><td>（連携用）経過年数１７</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhrkkknmnryumukbn17 zrnhrkkknmnryumukbn17}</td><td>（連携用）払込期間満了有無区分１７</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnzennouzndkyen17 zrnzennouzndkyen17}</td><td>（連携用）前納残高（円貨）１７</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnzennouzndkgaika17 zrnzennouzndkgaika17}</td><td>（連携用）前納残高１７</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyenhrkgkgoukei17 zrnyenhrkgkgoukei17}</td><td>（連携用）円貨払込額の合計（円貨）１７</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkihrkmp17 zrnkihrkmp17}</td><td>（連携用）既払込保険料１７</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnw17 zrnw17}</td><td>（連携用）解約返戻金１７</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnwyenyendaka17 zrnwyenyendaka17}</td><td>（連携用）解約返戻金（円貨）円高１７</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnwyenkijun17 zrnwyenkijun17}</td><td>（連携用）解約返戻金（円貨）中央値１７</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnwyenyenyasu17 zrnwyenyenyasu17}</td><td>（連携用）解約返戻金（円貨）円安１７</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkaiykuktgk17 zrnkaiykuktgk17}</td><td>（連携用）解約時受取額１７</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkaiykuktgkyenyendaka17 zrnkaiykuktgkyenyendaka17}</td><td>（連携用）解約時受取額（円貨）円高１７</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkaiykuktgkyenkijun17 zrnkaiykuktgkyenkijun17}</td><td>（連携用）解約時受取額（円貨）中央値１７</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkaiykuktgkyenyenyasu17 zrnkaiykuktgkyenyenyasu17}</td><td>（連携用）解約時受取額（円貨）円安１７</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkeikanensuu18 zrnkeikanensuu18}</td><td>（連携用）経過年数１８</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhrkkknmnryumukbn18 zrnhrkkknmnryumukbn18}</td><td>（連携用）払込期間満了有無区分１８</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnzennouzndkyen18 zrnzennouzndkyen18}</td><td>（連携用）前納残高（円貨）１８</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnzennouzndkgaika18 zrnzennouzndkgaika18}</td><td>（連携用）前納残高１８</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyenhrkgkgoukei18 zrnyenhrkgkgoukei18}</td><td>（連携用）円貨払込額の合計（円貨）１８</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkihrkmp18 zrnkihrkmp18}</td><td>（連携用）既払込保険料１８</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnw18 zrnw18}</td><td>（連携用）解約返戻金１８</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnwyenyendaka18 zrnwyenyendaka18}</td><td>（連携用）解約返戻金（円貨）円高１８</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnwyenkijun18 zrnwyenkijun18}</td><td>（連携用）解約返戻金（円貨）中央値１８</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnwyenyenyasu18 zrnwyenyenyasu18}</td><td>（連携用）解約返戻金（円貨）円安１８</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkaiykuktgk18 zrnkaiykuktgk18}</td><td>（連携用）解約時受取額１８</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkaiykuktgkyenyendaka18 zrnkaiykuktgkyenyendaka18}</td><td>（連携用）解約時受取額（円貨）円高１８</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkaiykuktgkyenkijun18 zrnkaiykuktgkyenkijun18}</td><td>（連携用）解約時受取額（円貨）中央値１８</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkaiykuktgkyenyenyasu18 zrnkaiykuktgkyenyenyasu18}</td><td>（連携用）解約時受取額（円貨）円安１８</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkeikanensuu19 zrnkeikanensuu19}</td><td>（連携用）経過年数１９</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhrkkknmnryumukbn19 zrnhrkkknmnryumukbn19}</td><td>（連携用）払込期間満了有無区分１９</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnzennouzndkyen19 zrnzennouzndkyen19}</td><td>（連携用）前納残高（円貨）１９</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnzennouzndkgaika19 zrnzennouzndkgaika19}</td><td>（連携用）前納残高１９</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyenhrkgkgoukei19 zrnyenhrkgkgoukei19}</td><td>（連携用）円貨払込額の合計（円貨）１９</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkihrkmp19 zrnkihrkmp19}</td><td>（連携用）既払込保険料１９</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnw19 zrnw19}</td><td>（連携用）解約返戻金１９</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnwyenyendaka19 zrnwyenyendaka19}</td><td>（連携用）解約返戻金（円貨）円高１９</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnwyenkijun19 zrnwyenkijun19}</td><td>（連携用）解約返戻金（円貨）中央値１９</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnwyenyenyasu19 zrnwyenyenyasu19}</td><td>（連携用）解約返戻金（円貨）円安１９</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkaiykuktgk19 zrnkaiykuktgk19}</td><td>（連携用）解約時受取額１９</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkaiykuktgkyenyendaka19 zrnkaiykuktgkyenyendaka19}</td><td>（連携用）解約時受取額（円貨）円高１９</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkaiykuktgkyenkijun19 zrnkaiykuktgkyenkijun19}</td><td>（連携用）解約時受取額（円貨）中央値１９</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkaiykuktgkyenyenyasu19 zrnkaiykuktgkyenyenyasu19}</td><td>（連携用）解約時受取額（円貨）円安１９</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkeikanensuu20 zrnkeikanensuu20}</td><td>（連携用）経過年数２０</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhrkkknmnryumukbn20 zrnhrkkknmnryumukbn20}</td><td>（連携用）払込期間満了有無区分２０</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnzennouzndkyen20 zrnzennouzndkyen20}</td><td>（連携用）前納残高（円貨）２０</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnzennouzndkgaika20 zrnzennouzndkgaika20}</td><td>（連携用）前納残高２０</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyenhrkgkgoukei20 zrnyenhrkgkgoukei20}</td><td>（連携用）円貨払込額の合計（円貨）２０</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkihrkmp20 zrnkihrkmp20}</td><td>（連携用）既払込保険料２０</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnw20 zrnw20}</td><td>（連携用）解約返戻金２０</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnwyenyendaka20 zrnwyenyendaka20}</td><td>（連携用）解約返戻金（円貨）円高２０</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnwyenkijun20 zrnwyenkijun20}</td><td>（連携用）解約返戻金（円貨）中央値２０</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnwyenyenyasu20 zrnwyenyenyasu20}</td><td>（連携用）解約返戻金（円貨）円安２０</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkaiykuktgk20 zrnkaiykuktgk20}</td><td>（連携用）解約時受取額２０</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkaiykuktgkyenyendaka20 zrnkaiykuktgkyenyendaka20}</td><td>（連携用）解約時受取額（円貨）円高２０</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkaiykuktgkyenkijun20 zrnkaiykuktgkyenkijun20}</td><td>（連携用）解約時受取額（円貨）中央値２０</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkaiykuktgkyenyenyasu20 zrnkaiykuktgkyenyenyasu20}</td><td>（連携用）解約時受取額（円貨）円安２０</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkeikanensuu21 zrnkeikanensuu21}</td><td>（連携用）経過年数２１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhrkkknmnryumukbn21 zrnhrkkknmnryumukbn21}</td><td>（連携用）払込期間満了有無区分２１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnzennouzndkyen21 zrnzennouzndkyen21}</td><td>（連携用）前納残高（円貨）２１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnzennouzndkgaika21 zrnzennouzndkgaika21}</td><td>（連携用）前納残高２１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyenhrkgkgoukei21 zrnyenhrkgkgoukei21}</td><td>（連携用）円貨払込額の合計（円貨）２１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkihrkmp21 zrnkihrkmp21}</td><td>（連携用）既払込保険料２１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnw21 zrnw21}</td><td>（連携用）解約返戻金２１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnwyenyendaka21 zrnwyenyendaka21}</td><td>（連携用）解約返戻金（円貨）円高２１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnwyenkijun21 zrnwyenkijun21}</td><td>（連携用）解約返戻金（円貨）中央値２１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnwyenyenyasu21 zrnwyenyenyasu21}</td><td>（連携用）解約返戻金（円貨）円安２１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkaiykuktgk21 zrnkaiykuktgk21}</td><td>（連携用）解約時受取額２１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkaiykuktgkyenyendaka21 zrnkaiykuktgkyenyendaka21}</td><td>（連携用）解約時受取額（円貨）円高２１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkaiykuktgkyenkijun21 zrnkaiykuktgkyenkijun21}</td><td>（連携用）解約時受取額（円貨）中央値２１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkaiykuktgkyenyenyasu21 zrnkaiykuktgkyenyenyasu21}</td><td>（連携用）解約時受取額（円貨）円安２１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkeikanensuu22 zrnkeikanensuu22}</td><td>（連携用）経過年数２２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhrkkknmnryumukbn22 zrnhrkkknmnryumukbn22}</td><td>（連携用）払込期間満了有無区分２２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnzennouzndkyen22 zrnzennouzndkyen22}</td><td>（連携用）前納残高（円貨）２２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnzennouzndkgaika22 zrnzennouzndkgaika22}</td><td>（連携用）前納残高２２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyenhrkgkgoukei22 zrnyenhrkgkgoukei22}</td><td>（連携用）円貨払込額の合計（円貨）２２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkihrkmp22 zrnkihrkmp22}</td><td>（連携用）既払込保険料２２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnw22 zrnw22}</td><td>（連携用）解約返戻金２２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnwyenyendaka22 zrnwyenyendaka22}</td><td>（連携用）解約返戻金（円貨）円高２２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnwyenkijun22 zrnwyenkijun22}</td><td>（連携用）解約返戻金（円貨）中央値２２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnwyenyenyasu22 zrnwyenyenyasu22}</td><td>（連携用）解約返戻金（円貨）円安２２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkaiykuktgk22 zrnkaiykuktgk22}</td><td>（連携用）解約時受取額２２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkaiykuktgkyenyendaka22 zrnkaiykuktgkyenyendaka22}</td><td>（連携用）解約時受取額（円貨）円高２２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkaiykuktgkyenkijun22 zrnkaiykuktgkyenkijun22}</td><td>（連携用）解約時受取額（円貨）中央値２２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkaiykuktgkyenyenyasu22 zrnkaiykuktgkyenyenyasu22}</td><td>（連携用）解約時受取額（円貨）円安２２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv196 zrnyobiv196}</td><td>（連携用）予備項目Ｖ１９６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv4 zrnyobiv4}</td><td>（連携用）予備項目Ｖ４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 * </table>
 * @see     ZT_SinkeiyakuSyoukenSuii2Rn
 * @see     PKZT_SinkeiyakuSyoukenSuii2Rn
 * @see     QZT_SinkeiyakuSyoukenSuii2Rn
 * @see     GenQZT_SinkeiyakuSyoukenSuii2Rn
 */
@MappedSuperclass
@Table(name=GenZT_SinkeiyakuSyoukenSuii2Rn.TABLE_NAME)
@IdClass(value=PKZT_SinkeiyakuSyoukenSuii2Rn.class)
public abstract class GenZT_SinkeiyakuSyoukenSuii2Rn extends AbstractExDBEntityForZDB<ZT_SinkeiyakuSyoukenSuii2Rn, PKZT_SinkeiyakuSyoukenSuii2Rn> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "ZT_SinkeiyakuSyoukenSuii2Rn";
    public static final String ZRNSYONO                 = "zrnsyono";
    public static final String ZRNTYOUHYOUYMD           = "zrntyouhyouymd";
    public static final String ZRNSUIIHYOUPTN           = "zrnsuiihyouptn";
    public static final String ZRNSUIIHYOUSYKBN         = "zrnsuiihyousykbn";
    public static final String ZRNSUIIHYOUSYONO         = "zrnsuiihyousyono";
    public static final String ZRNYTIRRTCALCKIJYUNRRT   = "zrnytirrtcalckijyunrrt";
    public static final String ZRNWKWSRATEYENDAKA       = "zrnwkwsrateyendaka";
    public static final String ZRNWKWSRATEYENKIJYUN     = "zrnwkwsrateyenkijyun";
    public static final String ZRNWKWSRATEYENYASU       = "zrnwkwsrateyenyasu";
    public static final String ZRNKYKTUUKATYPE          = "zrnkyktuukatype";
    public static final String ZRNKEIKANENSUU01         = "zrnkeikanensuu01";
    public static final String ZRNHRKKKNMNRYUMUKBN01    = "zrnhrkkknmnryumukbn01";
    public static final String ZRNZENNOUZNDKYEN01       = "zrnzennouzndkyen01";
    public static final String ZRNZENNOUZNDKGAIKA01     = "zrnzennouzndkgaika01";
    public static final String ZRNYENHRKGKGOUKEI01      = "zrnyenhrkgkgoukei01";
    public static final String ZRNKIHRKMP01             = "zrnkihrkmp01";
    public static final String ZRNW01                   = "zrnw01";
    public static final String ZRNWYENYENDAKA01         = "zrnwyenyendaka01";
    public static final String ZRNWYENKIJUN01           = "zrnwyenkijun01";
    public static final String ZRNWYENYENYASU01         = "zrnwyenyenyasu01";
    public static final String ZRNKAIYKUKTGK01          = "zrnkaiykuktgk01";
    public static final String ZRNKAIYKUKTGKYENYENDAKA01 = "zrnkaiykuktgkyenyendaka01";
    public static final String ZRNKAIYKUKTGKYENKIJUN01  = "zrnkaiykuktgkyenkijun01";
    public static final String ZRNKAIYKUKTGKYENYENYASU01 = "zrnkaiykuktgkyenyenyasu01";
    public static final String ZRNKEIKANENSUU02         = "zrnkeikanensuu02";
    public static final String ZRNHRKKKNMNRYUMUKBN02    = "zrnhrkkknmnryumukbn02";
    public static final String ZRNZENNOUZNDKYEN02       = "zrnzennouzndkyen02";
    public static final String ZRNZENNOUZNDKGAIKA02     = "zrnzennouzndkgaika02";
    public static final String ZRNYENHRKGKGOUKEI02      = "zrnyenhrkgkgoukei02";
    public static final String ZRNKIHRKMP02             = "zrnkihrkmp02";
    public static final String ZRNW02                   = "zrnw02";
    public static final String ZRNWYENYENDAKA02         = "zrnwyenyendaka02";
    public static final String ZRNWYENKIJUN02           = "zrnwyenkijun02";
    public static final String ZRNWYENYENYASU02         = "zrnwyenyenyasu02";
    public static final String ZRNKAIYKUKTGK02          = "zrnkaiykuktgk02";
    public static final String ZRNKAIYKUKTGKYENYENDAKA02 = "zrnkaiykuktgkyenyendaka02";
    public static final String ZRNKAIYKUKTGKYENKIJUN02  = "zrnkaiykuktgkyenkijun02";
    public static final String ZRNKAIYKUKTGKYENYENYASU02 = "zrnkaiykuktgkyenyenyasu02";
    public static final String ZRNKEIKANENSUU03         = "zrnkeikanensuu03";
    public static final String ZRNHRKKKNMNRYUMUKBN03    = "zrnhrkkknmnryumukbn03";
    public static final String ZRNZENNOUZNDKYEN03       = "zrnzennouzndkyen03";
    public static final String ZRNZENNOUZNDKGAIKA03     = "zrnzennouzndkgaika03";
    public static final String ZRNYENHRKGKGOUKEI03      = "zrnyenhrkgkgoukei03";
    public static final String ZRNKIHRKMP03             = "zrnkihrkmp03";
    public static final String ZRNW03                   = "zrnw03";
    public static final String ZRNWYENYENDAKA03         = "zrnwyenyendaka03";
    public static final String ZRNWYENKIJUN03           = "zrnwyenkijun03";
    public static final String ZRNWYENYENYASU03         = "zrnwyenyenyasu03";
    public static final String ZRNKAIYKUKTGK03          = "zrnkaiykuktgk03";
    public static final String ZRNKAIYKUKTGKYENYENDAKA03 = "zrnkaiykuktgkyenyendaka03";
    public static final String ZRNKAIYKUKTGKYENKIJUN03  = "zrnkaiykuktgkyenkijun03";
    public static final String ZRNKAIYKUKTGKYENYENYASU03 = "zrnkaiykuktgkyenyenyasu03";
    public static final String ZRNKEIKANENSUU04         = "zrnkeikanensuu04";
    public static final String ZRNHRKKKNMNRYUMUKBN04    = "zrnhrkkknmnryumukbn04";
    public static final String ZRNZENNOUZNDKYEN04       = "zrnzennouzndkyen04";
    public static final String ZRNZENNOUZNDKGAIKA04     = "zrnzennouzndkgaika04";
    public static final String ZRNYENHRKGKGOUKEI04      = "zrnyenhrkgkgoukei04";
    public static final String ZRNKIHRKMP04             = "zrnkihrkmp04";
    public static final String ZRNW04                   = "zrnw04";
    public static final String ZRNWYENYENDAKA04         = "zrnwyenyendaka04";
    public static final String ZRNWYENKIJUN04           = "zrnwyenkijun04";
    public static final String ZRNWYENYENYASU04         = "zrnwyenyenyasu04";
    public static final String ZRNKAIYKUKTGK04          = "zrnkaiykuktgk04";
    public static final String ZRNKAIYKUKTGKYENYENDAKA04 = "zrnkaiykuktgkyenyendaka04";
    public static final String ZRNKAIYKUKTGKYENKIJUN04  = "zrnkaiykuktgkyenkijun04";
    public static final String ZRNKAIYKUKTGKYENYENYASU04 = "zrnkaiykuktgkyenyenyasu04";
    public static final String ZRNKEIKANENSUU05         = "zrnkeikanensuu05";
    public static final String ZRNHRKKKNMNRYUMUKBN05    = "zrnhrkkknmnryumukbn05";
    public static final String ZRNZENNOUZNDKYEN05       = "zrnzennouzndkyen05";
    public static final String ZRNZENNOUZNDKGAIKA05     = "zrnzennouzndkgaika05";
    public static final String ZRNYENHRKGKGOUKEI05      = "zrnyenhrkgkgoukei05";
    public static final String ZRNKIHRKMP05             = "zrnkihrkmp05";
    public static final String ZRNW05                   = "zrnw05";
    public static final String ZRNWYENYENDAKA05         = "zrnwyenyendaka05";
    public static final String ZRNWYENKIJUN05           = "zrnwyenkijun05";
    public static final String ZRNWYENYENYASU05         = "zrnwyenyenyasu05";
    public static final String ZRNKAIYKUKTGK05          = "zrnkaiykuktgk05";
    public static final String ZRNKAIYKUKTGKYENYENDAKA05 = "zrnkaiykuktgkyenyendaka05";
    public static final String ZRNKAIYKUKTGKYENKIJUN05  = "zrnkaiykuktgkyenkijun05";
    public static final String ZRNKAIYKUKTGKYENYENYASU05 = "zrnkaiykuktgkyenyenyasu05";
    public static final String ZRNKEIKANENSUU06         = "zrnkeikanensuu06";
    public static final String ZRNHRKKKNMNRYUMUKBN06    = "zrnhrkkknmnryumukbn06";
    public static final String ZRNZENNOUZNDKYEN06       = "zrnzennouzndkyen06";
    public static final String ZRNZENNOUZNDKGAIKA06     = "zrnzennouzndkgaika06";
    public static final String ZRNYENHRKGKGOUKEI06      = "zrnyenhrkgkgoukei06";
    public static final String ZRNKIHRKMP06             = "zrnkihrkmp06";
    public static final String ZRNW06                   = "zrnw06";
    public static final String ZRNWYENYENDAKA06         = "zrnwyenyendaka06";
    public static final String ZRNWYENKIJUN06           = "zrnwyenkijun06";
    public static final String ZRNWYENYENYASU06         = "zrnwyenyenyasu06";
    public static final String ZRNKAIYKUKTGK06          = "zrnkaiykuktgk06";
    public static final String ZRNKAIYKUKTGKYENYENDAKA06 = "zrnkaiykuktgkyenyendaka06";
    public static final String ZRNKAIYKUKTGKYENKIJUN06  = "zrnkaiykuktgkyenkijun06";
    public static final String ZRNKAIYKUKTGKYENYENYASU06 = "zrnkaiykuktgkyenyenyasu06";
    public static final String ZRNKEIKANENSUU07         = "zrnkeikanensuu07";
    public static final String ZRNHRKKKNMNRYUMUKBN07    = "zrnhrkkknmnryumukbn07";
    public static final String ZRNZENNOUZNDKYEN07       = "zrnzennouzndkyen07";
    public static final String ZRNZENNOUZNDKGAIKA07     = "zrnzennouzndkgaika07";
    public static final String ZRNYENHRKGKGOUKEI07      = "zrnyenhrkgkgoukei07";
    public static final String ZRNKIHRKMP07             = "zrnkihrkmp07";
    public static final String ZRNW07                   = "zrnw07";
    public static final String ZRNWYENYENDAKA07         = "zrnwyenyendaka07";
    public static final String ZRNWYENKIJUN07           = "zrnwyenkijun07";
    public static final String ZRNWYENYENYASU07         = "zrnwyenyenyasu07";
    public static final String ZRNKAIYKUKTGK07          = "zrnkaiykuktgk07";
    public static final String ZRNKAIYKUKTGKYENYENDAKA07 = "zrnkaiykuktgkyenyendaka07";
    public static final String ZRNKAIYKUKTGKYENKIJUN07  = "zrnkaiykuktgkyenkijun07";
    public static final String ZRNKAIYKUKTGKYENYENYASU07 = "zrnkaiykuktgkyenyenyasu07";
    public static final String ZRNKEIKANENSUU08         = "zrnkeikanensuu08";
    public static final String ZRNHRKKKNMNRYUMUKBN08    = "zrnhrkkknmnryumukbn08";
    public static final String ZRNZENNOUZNDKYEN08       = "zrnzennouzndkyen08";
    public static final String ZRNZENNOUZNDKGAIKA08     = "zrnzennouzndkgaika08";
    public static final String ZRNYENHRKGKGOUKEI08      = "zrnyenhrkgkgoukei08";
    public static final String ZRNKIHRKMP08             = "zrnkihrkmp08";
    public static final String ZRNW08                   = "zrnw08";
    public static final String ZRNWYENYENDAKA08         = "zrnwyenyendaka08";
    public static final String ZRNWYENKIJUN08           = "zrnwyenkijun08";
    public static final String ZRNWYENYENYASU08         = "zrnwyenyenyasu08";
    public static final String ZRNKAIYKUKTGK08          = "zrnkaiykuktgk08";
    public static final String ZRNKAIYKUKTGKYENYENDAKA08 = "zrnkaiykuktgkyenyendaka08";
    public static final String ZRNKAIYKUKTGKYENKIJUN08  = "zrnkaiykuktgkyenkijun08";
    public static final String ZRNKAIYKUKTGKYENYENYASU08 = "zrnkaiykuktgkyenyenyasu08";
    public static final String ZRNKEIKANENSUU09         = "zrnkeikanensuu09";
    public static final String ZRNHRKKKNMNRYUMUKBN09    = "zrnhrkkknmnryumukbn09";
    public static final String ZRNZENNOUZNDKYEN09       = "zrnzennouzndkyen09";
    public static final String ZRNZENNOUZNDKGAIKA09     = "zrnzennouzndkgaika09";
    public static final String ZRNYENHRKGKGOUKEI09      = "zrnyenhrkgkgoukei09";
    public static final String ZRNKIHRKMP09             = "zrnkihrkmp09";
    public static final String ZRNW09                   = "zrnw09";
    public static final String ZRNWYENYENDAKA09         = "zrnwyenyendaka09";
    public static final String ZRNWYENKIJUN09           = "zrnwyenkijun09";
    public static final String ZRNWYENYENYASU09         = "zrnwyenyenyasu09";
    public static final String ZRNKAIYKUKTGK09          = "zrnkaiykuktgk09";
    public static final String ZRNKAIYKUKTGKYENYENDAKA09 = "zrnkaiykuktgkyenyendaka09";
    public static final String ZRNKAIYKUKTGKYENKIJUN09  = "zrnkaiykuktgkyenkijun09";
    public static final String ZRNKAIYKUKTGKYENYENYASU09 = "zrnkaiykuktgkyenyenyasu09";
    public static final String ZRNKEIKANENSUU10         = "zrnkeikanensuu10";
    public static final String ZRNHRKKKNMNRYUMUKBN10    = "zrnhrkkknmnryumukbn10";
    public static final String ZRNZENNOUZNDKYEN10       = "zrnzennouzndkyen10";
    public static final String ZRNZENNOUZNDKGAIKA10     = "zrnzennouzndkgaika10";
    public static final String ZRNYENHRKGKGOUKEI10      = "zrnyenhrkgkgoukei10";
    public static final String ZRNKIHRKMP10             = "zrnkihrkmp10";
    public static final String ZRNW10                   = "zrnw10";
    public static final String ZRNWYENYENDAKA10         = "zrnwyenyendaka10";
    public static final String ZRNWYENKIJUN10           = "zrnwyenkijun10";
    public static final String ZRNWYENYENYASU10         = "zrnwyenyenyasu10";
    public static final String ZRNKAIYKUKTGK10          = "zrnkaiykuktgk10";
    public static final String ZRNKAIYKUKTGKYENYENDAKA10 = "zrnkaiykuktgkyenyendaka10";
    public static final String ZRNKAIYKUKTGKYENKIJUN10  = "zrnkaiykuktgkyenkijun10";
    public static final String ZRNKAIYKUKTGKYENYENYASU10 = "zrnkaiykuktgkyenyenyasu10";
    public static final String ZRNKEIKANENSUU11         = "zrnkeikanensuu11";
    public static final String ZRNHRKKKNMNRYUMUKBN11    = "zrnhrkkknmnryumukbn11";
    public static final String ZRNZENNOUZNDKYEN11       = "zrnzennouzndkyen11";
    public static final String ZRNZENNOUZNDKGAIKA11     = "zrnzennouzndkgaika11";
    public static final String ZRNYENHRKGKGOUKEI11      = "zrnyenhrkgkgoukei11";
    public static final String ZRNKIHRKMP11             = "zrnkihrkmp11";
    public static final String ZRNW11                   = "zrnw11";
    public static final String ZRNWYENYENDAKA11         = "zrnwyenyendaka11";
    public static final String ZRNWYENKIJUN11           = "zrnwyenkijun11";
    public static final String ZRNWYENYENYASU11         = "zrnwyenyenyasu11";
    public static final String ZRNKAIYKUKTGK11          = "zrnkaiykuktgk11";
    public static final String ZRNKAIYKUKTGKYENYENDAKA11 = "zrnkaiykuktgkyenyendaka11";
    public static final String ZRNKAIYKUKTGKYENKIJUN11  = "zrnkaiykuktgkyenkijun11";
    public static final String ZRNKAIYKUKTGKYENYENYASU11 = "zrnkaiykuktgkyenyenyasu11";
    public static final String ZRNKEIKANENSUU12         = "zrnkeikanensuu12";
    public static final String ZRNHRKKKNMNRYUMUKBN12    = "zrnhrkkknmnryumukbn12";
    public static final String ZRNZENNOUZNDKYEN12       = "zrnzennouzndkyen12";
    public static final String ZRNZENNOUZNDKGAIKA12     = "zrnzennouzndkgaika12";
    public static final String ZRNYENHRKGKGOUKEI12      = "zrnyenhrkgkgoukei12";
    public static final String ZRNKIHRKMP12             = "zrnkihrkmp12";
    public static final String ZRNW12                   = "zrnw12";
    public static final String ZRNWYENYENDAKA12         = "zrnwyenyendaka12";
    public static final String ZRNWYENKIJUN12           = "zrnwyenkijun12";
    public static final String ZRNWYENYENYASU12         = "zrnwyenyenyasu12";
    public static final String ZRNKAIYKUKTGK12          = "zrnkaiykuktgk12";
    public static final String ZRNKAIYKUKTGKYENYENDAKA12 = "zrnkaiykuktgkyenyendaka12";
    public static final String ZRNKAIYKUKTGKYENKIJUN12  = "zrnkaiykuktgkyenkijun12";
    public static final String ZRNKAIYKUKTGKYENYENYASU12 = "zrnkaiykuktgkyenyenyasu12";
    public static final String ZRNKEIKANENSUU13         = "zrnkeikanensuu13";
    public static final String ZRNHRKKKNMNRYUMUKBN13    = "zrnhrkkknmnryumukbn13";
    public static final String ZRNZENNOUZNDKYEN13       = "zrnzennouzndkyen13";
    public static final String ZRNZENNOUZNDKGAIKA13     = "zrnzennouzndkgaika13";
    public static final String ZRNYENHRKGKGOUKEI13      = "zrnyenhrkgkgoukei13";
    public static final String ZRNKIHRKMP13             = "zrnkihrkmp13";
    public static final String ZRNW13                   = "zrnw13";
    public static final String ZRNWYENYENDAKA13         = "zrnwyenyendaka13";
    public static final String ZRNWYENKIJUN13           = "zrnwyenkijun13";
    public static final String ZRNWYENYENYASU13         = "zrnwyenyenyasu13";
    public static final String ZRNKAIYKUKTGK13          = "zrnkaiykuktgk13";
    public static final String ZRNKAIYKUKTGKYENYENDAKA13 = "zrnkaiykuktgkyenyendaka13";
    public static final String ZRNKAIYKUKTGKYENKIJUN13  = "zrnkaiykuktgkyenkijun13";
    public static final String ZRNKAIYKUKTGKYENYENYASU13 = "zrnkaiykuktgkyenyenyasu13";
    public static final String ZRNKEIKANENSUU14         = "zrnkeikanensuu14";
    public static final String ZRNHRKKKNMNRYUMUKBN14    = "zrnhrkkknmnryumukbn14";
    public static final String ZRNZENNOUZNDKYEN14       = "zrnzennouzndkyen14";
    public static final String ZRNZENNOUZNDKGAIKA14     = "zrnzennouzndkgaika14";
    public static final String ZRNYENHRKGKGOUKEI14      = "zrnyenhrkgkgoukei14";
    public static final String ZRNKIHRKMP14             = "zrnkihrkmp14";
    public static final String ZRNW14                   = "zrnw14";
    public static final String ZRNWYENYENDAKA14         = "zrnwyenyendaka14";
    public static final String ZRNWYENKIJUN14           = "zrnwyenkijun14";
    public static final String ZRNWYENYENYASU14         = "zrnwyenyenyasu14";
    public static final String ZRNKAIYKUKTGK14          = "zrnkaiykuktgk14";
    public static final String ZRNKAIYKUKTGKYENYENDAKA14 = "zrnkaiykuktgkyenyendaka14";
    public static final String ZRNKAIYKUKTGKYENKIJUN14  = "zrnkaiykuktgkyenkijun14";
    public static final String ZRNKAIYKUKTGKYENYENYASU14 = "zrnkaiykuktgkyenyenyasu14";
    public static final String ZRNKEIKANENSUU15         = "zrnkeikanensuu15";
    public static final String ZRNHRKKKNMNRYUMUKBN15    = "zrnhrkkknmnryumukbn15";
    public static final String ZRNZENNOUZNDKYEN15       = "zrnzennouzndkyen15";
    public static final String ZRNZENNOUZNDKGAIKA15     = "zrnzennouzndkgaika15";
    public static final String ZRNYENHRKGKGOUKEI15      = "zrnyenhrkgkgoukei15";
    public static final String ZRNKIHRKMP15             = "zrnkihrkmp15";
    public static final String ZRNW15                   = "zrnw15";
    public static final String ZRNWYENYENDAKA15         = "zrnwyenyendaka15";
    public static final String ZRNWYENKIJUN15           = "zrnwyenkijun15";
    public static final String ZRNWYENYENYASU15         = "zrnwyenyenyasu15";
    public static final String ZRNKAIYKUKTGK15          = "zrnkaiykuktgk15";
    public static final String ZRNKAIYKUKTGKYENYENDAKA15 = "zrnkaiykuktgkyenyendaka15";
    public static final String ZRNKAIYKUKTGKYENKIJUN15  = "zrnkaiykuktgkyenkijun15";
    public static final String ZRNKAIYKUKTGKYENYENYASU15 = "zrnkaiykuktgkyenyenyasu15";
    public static final String ZRNKEIKANENSUU16         = "zrnkeikanensuu16";
    public static final String ZRNHRKKKNMNRYUMUKBN16    = "zrnhrkkknmnryumukbn16";
    public static final String ZRNZENNOUZNDKYEN16       = "zrnzennouzndkyen16";
    public static final String ZRNZENNOUZNDKGAIKA16     = "zrnzennouzndkgaika16";
    public static final String ZRNYENHRKGKGOUKEI16      = "zrnyenhrkgkgoukei16";
    public static final String ZRNKIHRKMP16             = "zrnkihrkmp16";
    public static final String ZRNW16                   = "zrnw16";
    public static final String ZRNWYENYENDAKA16         = "zrnwyenyendaka16";
    public static final String ZRNWYENKIJUN16           = "zrnwyenkijun16";
    public static final String ZRNWYENYENYASU16         = "zrnwyenyenyasu16";
    public static final String ZRNKAIYKUKTGK16          = "zrnkaiykuktgk16";
    public static final String ZRNKAIYKUKTGKYENYENDAKA16 = "zrnkaiykuktgkyenyendaka16";
    public static final String ZRNKAIYKUKTGKYENKIJUN16  = "zrnkaiykuktgkyenkijun16";
    public static final String ZRNKAIYKUKTGKYENYENYASU16 = "zrnkaiykuktgkyenyenyasu16";
    public static final String ZRNKEIKANENSUU17         = "zrnkeikanensuu17";
    public static final String ZRNHRKKKNMNRYUMUKBN17    = "zrnhrkkknmnryumukbn17";
    public static final String ZRNZENNOUZNDKYEN17       = "zrnzennouzndkyen17";
    public static final String ZRNZENNOUZNDKGAIKA17     = "zrnzennouzndkgaika17";
    public static final String ZRNYENHRKGKGOUKEI17      = "zrnyenhrkgkgoukei17";
    public static final String ZRNKIHRKMP17             = "zrnkihrkmp17";
    public static final String ZRNW17                   = "zrnw17";
    public static final String ZRNWYENYENDAKA17         = "zrnwyenyendaka17";
    public static final String ZRNWYENKIJUN17           = "zrnwyenkijun17";
    public static final String ZRNWYENYENYASU17         = "zrnwyenyenyasu17";
    public static final String ZRNKAIYKUKTGK17          = "zrnkaiykuktgk17";
    public static final String ZRNKAIYKUKTGKYENYENDAKA17 = "zrnkaiykuktgkyenyendaka17";
    public static final String ZRNKAIYKUKTGKYENKIJUN17  = "zrnkaiykuktgkyenkijun17";
    public static final String ZRNKAIYKUKTGKYENYENYASU17 = "zrnkaiykuktgkyenyenyasu17";
    public static final String ZRNKEIKANENSUU18         = "zrnkeikanensuu18";
    public static final String ZRNHRKKKNMNRYUMUKBN18    = "zrnhrkkknmnryumukbn18";
    public static final String ZRNZENNOUZNDKYEN18       = "zrnzennouzndkyen18";
    public static final String ZRNZENNOUZNDKGAIKA18     = "zrnzennouzndkgaika18";
    public static final String ZRNYENHRKGKGOUKEI18      = "zrnyenhrkgkgoukei18";
    public static final String ZRNKIHRKMP18             = "zrnkihrkmp18";
    public static final String ZRNW18                   = "zrnw18";
    public static final String ZRNWYENYENDAKA18         = "zrnwyenyendaka18";
    public static final String ZRNWYENKIJUN18           = "zrnwyenkijun18";
    public static final String ZRNWYENYENYASU18         = "zrnwyenyenyasu18";
    public static final String ZRNKAIYKUKTGK18          = "zrnkaiykuktgk18";
    public static final String ZRNKAIYKUKTGKYENYENDAKA18 = "zrnkaiykuktgkyenyendaka18";
    public static final String ZRNKAIYKUKTGKYENKIJUN18  = "zrnkaiykuktgkyenkijun18";
    public static final String ZRNKAIYKUKTGKYENYENYASU18 = "zrnkaiykuktgkyenyenyasu18";
    public static final String ZRNKEIKANENSUU19         = "zrnkeikanensuu19";
    public static final String ZRNHRKKKNMNRYUMUKBN19    = "zrnhrkkknmnryumukbn19";
    public static final String ZRNZENNOUZNDKYEN19       = "zrnzennouzndkyen19";
    public static final String ZRNZENNOUZNDKGAIKA19     = "zrnzennouzndkgaika19";
    public static final String ZRNYENHRKGKGOUKEI19      = "zrnyenhrkgkgoukei19";
    public static final String ZRNKIHRKMP19             = "zrnkihrkmp19";
    public static final String ZRNW19                   = "zrnw19";
    public static final String ZRNWYENYENDAKA19         = "zrnwyenyendaka19";
    public static final String ZRNWYENKIJUN19           = "zrnwyenkijun19";
    public static final String ZRNWYENYENYASU19         = "zrnwyenyenyasu19";
    public static final String ZRNKAIYKUKTGK19          = "zrnkaiykuktgk19";
    public static final String ZRNKAIYKUKTGKYENYENDAKA19 = "zrnkaiykuktgkyenyendaka19";
    public static final String ZRNKAIYKUKTGKYENKIJUN19  = "zrnkaiykuktgkyenkijun19";
    public static final String ZRNKAIYKUKTGKYENYENYASU19 = "zrnkaiykuktgkyenyenyasu19";
    public static final String ZRNKEIKANENSUU20         = "zrnkeikanensuu20";
    public static final String ZRNHRKKKNMNRYUMUKBN20    = "zrnhrkkknmnryumukbn20";
    public static final String ZRNZENNOUZNDKYEN20       = "zrnzennouzndkyen20";
    public static final String ZRNZENNOUZNDKGAIKA20     = "zrnzennouzndkgaika20";
    public static final String ZRNYENHRKGKGOUKEI20      = "zrnyenhrkgkgoukei20";
    public static final String ZRNKIHRKMP20             = "zrnkihrkmp20";
    public static final String ZRNW20                   = "zrnw20";
    public static final String ZRNWYENYENDAKA20         = "zrnwyenyendaka20";
    public static final String ZRNWYENKIJUN20           = "zrnwyenkijun20";
    public static final String ZRNWYENYENYASU20         = "zrnwyenyenyasu20";
    public static final String ZRNKAIYKUKTGK20          = "zrnkaiykuktgk20";
    public static final String ZRNKAIYKUKTGKYENYENDAKA20 = "zrnkaiykuktgkyenyendaka20";
    public static final String ZRNKAIYKUKTGKYENKIJUN20  = "zrnkaiykuktgkyenkijun20";
    public static final String ZRNKAIYKUKTGKYENYENYASU20 = "zrnkaiykuktgkyenyenyasu20";
    public static final String ZRNKEIKANENSUU21         = "zrnkeikanensuu21";
    public static final String ZRNHRKKKNMNRYUMUKBN21    = "zrnhrkkknmnryumukbn21";
    public static final String ZRNZENNOUZNDKYEN21       = "zrnzennouzndkyen21";
    public static final String ZRNZENNOUZNDKGAIKA21     = "zrnzennouzndkgaika21";
    public static final String ZRNYENHRKGKGOUKEI21      = "zrnyenhrkgkgoukei21";
    public static final String ZRNKIHRKMP21             = "zrnkihrkmp21";
    public static final String ZRNW21                   = "zrnw21";
    public static final String ZRNWYENYENDAKA21         = "zrnwyenyendaka21";
    public static final String ZRNWYENKIJUN21           = "zrnwyenkijun21";
    public static final String ZRNWYENYENYASU21         = "zrnwyenyenyasu21";
    public static final String ZRNKAIYKUKTGK21          = "zrnkaiykuktgk21";
    public static final String ZRNKAIYKUKTGKYENYENDAKA21 = "zrnkaiykuktgkyenyendaka21";
    public static final String ZRNKAIYKUKTGKYENKIJUN21  = "zrnkaiykuktgkyenkijun21";
    public static final String ZRNKAIYKUKTGKYENYENYASU21 = "zrnkaiykuktgkyenyenyasu21";
    public static final String ZRNKEIKANENSUU22         = "zrnkeikanensuu22";
    public static final String ZRNHRKKKNMNRYUMUKBN22    = "zrnhrkkknmnryumukbn22";
    public static final String ZRNZENNOUZNDKYEN22       = "zrnzennouzndkyen22";
    public static final String ZRNZENNOUZNDKGAIKA22     = "zrnzennouzndkgaika22";
    public static final String ZRNYENHRKGKGOUKEI22      = "zrnyenhrkgkgoukei22";
    public static final String ZRNKIHRKMP22             = "zrnkihrkmp22";
    public static final String ZRNW22                   = "zrnw22";
    public static final String ZRNWYENYENDAKA22         = "zrnwyenyendaka22";
    public static final String ZRNWYENKIJUN22           = "zrnwyenkijun22";
    public static final String ZRNWYENYENYASU22         = "zrnwyenyenyasu22";
    public static final String ZRNKAIYKUKTGK22          = "zrnkaiykuktgk22";
    public static final String ZRNKAIYKUKTGKYENYENDAKA22 = "zrnkaiykuktgkyenyendaka22";
    public static final String ZRNKAIYKUKTGKYENKIJUN22  = "zrnkaiykuktgkyenkijun22";
    public static final String ZRNKAIYKUKTGKYENYENYASU22 = "zrnkaiykuktgkyenyenyasu22";
    public static final String ZRNYOBIV196              = "zrnyobiv196";
    public static final String ZRNYOBIV4                = "zrnyobiv4";

    private final PKZT_SinkeiyakuSyoukenSuii2Rn primaryKey;

    public GenZT_SinkeiyakuSyoukenSuii2Rn() {
        primaryKey = new PKZT_SinkeiyakuSyoukenSuii2Rn();
    }

    public GenZT_SinkeiyakuSyoukenSuii2Rn(
        String pZrnsyono,
        String pZrntyouhyouymd,
        String pZrnsuiihyouptn
    ) {
        primaryKey = new PKZT_SinkeiyakuSyoukenSuii2Rn(
            pZrnsyono,
            pZrntyouhyouymd,
            pZrnsuiihyouptn
        );
    }

    @Transient
    @Override
    public PKZT_SinkeiyakuSyoukenSuii2Rn getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QZT_SinkeiyakuSyoukenSuii2Rn> getMetaClass() {
        return QZT_SinkeiyakuSyoukenSuii2Rn.class;
    }

    @Id
    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Rn.ZRNSYONO)
    public String getZrnsyono() {
        return getPrimaryKey().getZrnsyono();
    }

    public void setZrnsyono(String pZrnsyono) {
        getPrimaryKey().setZrnsyono(pZrnsyono);
    }

    @Id
    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Rn.ZRNTYOUHYOUYMD)
    public String getZrntyouhyouymd() {
        return getPrimaryKey().getZrntyouhyouymd();
    }

    public void setZrntyouhyouymd(String pZrntyouhyouymd) {
        getPrimaryKey().setZrntyouhyouymd(pZrntyouhyouymd);
    }

    @Id
    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Rn.ZRNSUIIHYOUPTN)
    public String getZrnsuiihyouptn() {
        return getPrimaryKey().getZrnsuiihyouptn();
    }

    @Padding(mode = "left", padChar ='0', length =2)
    public void setZrnsuiihyouptn(String pZrnsuiihyouptn) {
        getPrimaryKey().setZrnsuiihyouptn(pZrnsuiihyouptn);
    }

    private String zrnsuiihyousykbn;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Rn.ZRNSUIIHYOUSYKBN)
    public String getZrnsuiihyousykbn() {
        return zrnsuiihyousykbn;
    }

    @Padding(mode = "left", padChar ='0', length =2)
    public void setZrnsuiihyousykbn(String pZrnsuiihyousykbn) {
        zrnsuiihyousykbn = pZrnsuiihyousykbn;
    }

    private String zrnsuiihyousyono;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Rn.ZRNSUIIHYOUSYONO)
    public String getZrnsuiihyousyono() {
        return zrnsuiihyousyono;
    }

    public void setZrnsuiihyousyono(String pZrnsuiihyousyono) {
        zrnsuiihyousyono = pZrnsuiihyousyono;
    }

    private String zrnytirrtcalckijyunrrt;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Rn.ZRNYTIRRTCALCKIJYUNRRT)
    public String getZrnytirrtcalckijyunrrt() {
        return zrnytirrtcalckijyunrrt;
    }

    @DataConvert("toMultiByte")
    public void setZrnytirrtcalckijyunrrt(String pZrnytirrtcalckijyunrrt) {
        zrnytirrtcalckijyunrrt = pZrnytirrtcalckijyunrrt;
    }

    private String zrnwkwsrateyendaka;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Rn.ZRNWKWSRATEYENDAKA)
    public String getZrnwkwsrateyendaka() {
        return zrnwkwsrateyendaka;
    }

    @Padding(mode = "left", padChar ='0', length =5)
    public void setZrnwkwsrateyendaka(String pZrnwkwsrateyendaka) {
        zrnwkwsrateyendaka = pZrnwkwsrateyendaka;
    }

    private String zrnwkwsrateyenkijyun;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Rn.ZRNWKWSRATEYENKIJYUN)
    public String getZrnwkwsrateyenkijyun() {
        return zrnwkwsrateyenkijyun;
    }

    @Padding(mode = "left", padChar ='0', length =5)
    public void setZrnwkwsrateyenkijyun(String pZrnwkwsrateyenkijyun) {
        zrnwkwsrateyenkijyun = pZrnwkwsrateyenkijyun;
    }

    private String zrnwkwsrateyenyasu;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Rn.ZRNWKWSRATEYENYASU)
    public String getZrnwkwsrateyenyasu() {
        return zrnwkwsrateyenyasu;
    }

    @Padding(mode = "left", padChar ='0', length =5)
    public void setZrnwkwsrateyenyasu(String pZrnwkwsrateyenyasu) {
        zrnwkwsrateyenyasu = pZrnwkwsrateyenyasu;
    }

    private String zrnkyktuukatype;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Rn.ZRNKYKTUUKATYPE)
    public String getZrnkyktuukatype() {
        return zrnkyktuukatype;
    }

    public void setZrnkyktuukatype(String pZrnkyktuukatype) {
        zrnkyktuukatype = pZrnkyktuukatype;
    }

    private String zrnkeikanensuu01;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Rn.ZRNKEIKANENSUU01)
    public String getZrnkeikanensuu01() {
        return zrnkeikanensuu01;
    }

    @Padding(mode = "left", padChar ='0', length =2)
    public void setZrnkeikanensuu01(String pZrnkeikanensuu01) {
        zrnkeikanensuu01 = pZrnkeikanensuu01;
    }

    private String zrnhrkkknmnryumukbn01;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Rn.ZRNHRKKKNMNRYUMUKBN01)
    public String getZrnhrkkknmnryumukbn01() {
        return zrnhrkkknmnryumukbn01;
    }

    public void setZrnhrkkknmnryumukbn01(String pZrnhrkkknmnryumukbn01) {
        zrnhrkkknmnryumukbn01 = pZrnhrkkknmnryumukbn01;
    }

    private String zrnzennouzndkyen01;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Rn.ZRNZENNOUZNDKYEN01)
    public String getZrnzennouzndkyen01() {
        return zrnzennouzndkyen01;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnzennouzndkyen01(String pZrnzennouzndkyen01) {
        zrnzennouzndkyen01 = pZrnzennouzndkyen01;
    }

    private String zrnzennouzndkgaika01;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Rn.ZRNZENNOUZNDKGAIKA01)
    public String getZrnzennouzndkgaika01() {
        return zrnzennouzndkgaika01;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnzennouzndkgaika01(String pZrnzennouzndkgaika01) {
        zrnzennouzndkgaika01 = pZrnzennouzndkgaika01;
    }

    private String zrnyenhrkgkgoukei01;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Rn.ZRNYENHRKGKGOUKEI01)
    public String getZrnyenhrkgkgoukei01() {
        return zrnyenhrkgkgoukei01;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnyenhrkgkgoukei01(String pZrnyenhrkgkgoukei01) {
        zrnyenhrkgkgoukei01 = pZrnyenhrkgkgoukei01;
    }

    private String zrnkihrkmp01;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Rn.ZRNKIHRKMP01)
    public String getZrnkihrkmp01() {
        return zrnkihrkmp01;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnkihrkmp01(String pZrnkihrkmp01) {
        zrnkihrkmp01 = pZrnkihrkmp01;
    }

    private String zrnw01;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Rn.ZRNW01)
    public String getZrnw01() {
        return zrnw01;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnw01(String pZrnw01) {
        zrnw01 = pZrnw01;
    }

    private String zrnwyenyendaka01;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Rn.ZRNWYENYENDAKA01)
    public String getZrnwyenyendaka01() {
        return zrnwyenyendaka01;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnwyenyendaka01(String pZrnwyenyendaka01) {
        zrnwyenyendaka01 = pZrnwyenyendaka01;
    }

    private String zrnwyenkijun01;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Rn.ZRNWYENKIJUN01)
    public String getZrnwyenkijun01() {
        return zrnwyenkijun01;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnwyenkijun01(String pZrnwyenkijun01) {
        zrnwyenkijun01 = pZrnwyenkijun01;
    }

    private String zrnwyenyenyasu01;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Rn.ZRNWYENYENYASU01)
    public String getZrnwyenyenyasu01() {
        return zrnwyenyenyasu01;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnwyenyenyasu01(String pZrnwyenyenyasu01) {
        zrnwyenyenyasu01 = pZrnwyenyenyasu01;
    }

    private String zrnkaiykuktgk01;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Rn.ZRNKAIYKUKTGK01)
    public String getZrnkaiykuktgk01() {
        return zrnkaiykuktgk01;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnkaiykuktgk01(String pZrnkaiykuktgk01) {
        zrnkaiykuktgk01 = pZrnkaiykuktgk01;
    }

    private String zrnkaiykuktgkyenyendaka01;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Rn.ZRNKAIYKUKTGKYENYENDAKA01)
    public String getZrnkaiykuktgkyenyendaka01() {
        return zrnkaiykuktgkyenyendaka01;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnkaiykuktgkyenyendaka01(String pZrnkaiykuktgkyenyendaka01) {
        zrnkaiykuktgkyenyendaka01 = pZrnkaiykuktgkyenyendaka01;
    }

    private String zrnkaiykuktgkyenkijun01;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Rn.ZRNKAIYKUKTGKYENKIJUN01)
    public String getZrnkaiykuktgkyenkijun01() {
        return zrnkaiykuktgkyenkijun01;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnkaiykuktgkyenkijun01(String pZrnkaiykuktgkyenkijun01) {
        zrnkaiykuktgkyenkijun01 = pZrnkaiykuktgkyenkijun01;
    }

    private String zrnkaiykuktgkyenyenyasu01;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Rn.ZRNKAIYKUKTGKYENYENYASU01)
    public String getZrnkaiykuktgkyenyenyasu01() {
        return zrnkaiykuktgkyenyenyasu01;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnkaiykuktgkyenyenyasu01(String pZrnkaiykuktgkyenyenyasu01) {
        zrnkaiykuktgkyenyenyasu01 = pZrnkaiykuktgkyenyenyasu01;
    }

    private String zrnkeikanensuu02;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Rn.ZRNKEIKANENSUU02)
    public String getZrnkeikanensuu02() {
        return zrnkeikanensuu02;
    }

    @Padding(mode = "left", padChar ='0', length =2)
    public void setZrnkeikanensuu02(String pZrnkeikanensuu02) {
        zrnkeikanensuu02 = pZrnkeikanensuu02;
    }

    private String zrnhrkkknmnryumukbn02;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Rn.ZRNHRKKKNMNRYUMUKBN02)
    public String getZrnhrkkknmnryumukbn02() {
        return zrnhrkkknmnryumukbn02;
    }

    public void setZrnhrkkknmnryumukbn02(String pZrnhrkkknmnryumukbn02) {
        zrnhrkkknmnryumukbn02 = pZrnhrkkknmnryumukbn02;
    }

    private String zrnzennouzndkyen02;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Rn.ZRNZENNOUZNDKYEN02)
    public String getZrnzennouzndkyen02() {
        return zrnzennouzndkyen02;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnzennouzndkyen02(String pZrnzennouzndkyen02) {
        zrnzennouzndkyen02 = pZrnzennouzndkyen02;
    }

    private String zrnzennouzndkgaika02;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Rn.ZRNZENNOUZNDKGAIKA02)
    public String getZrnzennouzndkgaika02() {
        return zrnzennouzndkgaika02;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnzennouzndkgaika02(String pZrnzennouzndkgaika02) {
        zrnzennouzndkgaika02 = pZrnzennouzndkgaika02;
    }

    private String zrnyenhrkgkgoukei02;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Rn.ZRNYENHRKGKGOUKEI02)
    public String getZrnyenhrkgkgoukei02() {
        return zrnyenhrkgkgoukei02;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnyenhrkgkgoukei02(String pZrnyenhrkgkgoukei02) {
        zrnyenhrkgkgoukei02 = pZrnyenhrkgkgoukei02;
    }

    private String zrnkihrkmp02;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Rn.ZRNKIHRKMP02)
    public String getZrnkihrkmp02() {
        return zrnkihrkmp02;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnkihrkmp02(String pZrnkihrkmp02) {
        zrnkihrkmp02 = pZrnkihrkmp02;
    }

    private String zrnw02;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Rn.ZRNW02)
    public String getZrnw02() {
        return zrnw02;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnw02(String pZrnw02) {
        zrnw02 = pZrnw02;
    }

    private String zrnwyenyendaka02;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Rn.ZRNWYENYENDAKA02)
    public String getZrnwyenyendaka02() {
        return zrnwyenyendaka02;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnwyenyendaka02(String pZrnwyenyendaka02) {
        zrnwyenyendaka02 = pZrnwyenyendaka02;
    }

    private String zrnwyenkijun02;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Rn.ZRNWYENKIJUN02)
    public String getZrnwyenkijun02() {
        return zrnwyenkijun02;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnwyenkijun02(String pZrnwyenkijun02) {
        zrnwyenkijun02 = pZrnwyenkijun02;
    }

    private String zrnwyenyenyasu02;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Rn.ZRNWYENYENYASU02)
    public String getZrnwyenyenyasu02() {
        return zrnwyenyenyasu02;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnwyenyenyasu02(String pZrnwyenyenyasu02) {
        zrnwyenyenyasu02 = pZrnwyenyenyasu02;
    }

    private String zrnkaiykuktgk02;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Rn.ZRNKAIYKUKTGK02)
    public String getZrnkaiykuktgk02() {
        return zrnkaiykuktgk02;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnkaiykuktgk02(String pZrnkaiykuktgk02) {
        zrnkaiykuktgk02 = pZrnkaiykuktgk02;
    }

    private String zrnkaiykuktgkyenyendaka02;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Rn.ZRNKAIYKUKTGKYENYENDAKA02)
    public String getZrnkaiykuktgkyenyendaka02() {
        return zrnkaiykuktgkyenyendaka02;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnkaiykuktgkyenyendaka02(String pZrnkaiykuktgkyenyendaka02) {
        zrnkaiykuktgkyenyendaka02 = pZrnkaiykuktgkyenyendaka02;
    }

    private String zrnkaiykuktgkyenkijun02;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Rn.ZRNKAIYKUKTGKYENKIJUN02)
    public String getZrnkaiykuktgkyenkijun02() {
        return zrnkaiykuktgkyenkijun02;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnkaiykuktgkyenkijun02(String pZrnkaiykuktgkyenkijun02) {
        zrnkaiykuktgkyenkijun02 = pZrnkaiykuktgkyenkijun02;
    }

    private String zrnkaiykuktgkyenyenyasu02;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Rn.ZRNKAIYKUKTGKYENYENYASU02)
    public String getZrnkaiykuktgkyenyenyasu02() {
        return zrnkaiykuktgkyenyenyasu02;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnkaiykuktgkyenyenyasu02(String pZrnkaiykuktgkyenyenyasu02) {
        zrnkaiykuktgkyenyenyasu02 = pZrnkaiykuktgkyenyenyasu02;
    }

    private String zrnkeikanensuu03;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Rn.ZRNKEIKANENSUU03)
    public String getZrnkeikanensuu03() {
        return zrnkeikanensuu03;
    }

    @Padding(mode = "left", padChar ='0', length =2)
    public void setZrnkeikanensuu03(String pZrnkeikanensuu03) {
        zrnkeikanensuu03 = pZrnkeikanensuu03;
    }

    private String zrnhrkkknmnryumukbn03;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Rn.ZRNHRKKKNMNRYUMUKBN03)
    public String getZrnhrkkknmnryumukbn03() {
        return zrnhrkkknmnryumukbn03;
    }

    public void setZrnhrkkknmnryumukbn03(String pZrnhrkkknmnryumukbn03) {
        zrnhrkkknmnryumukbn03 = pZrnhrkkknmnryumukbn03;
    }

    private String zrnzennouzndkyen03;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Rn.ZRNZENNOUZNDKYEN03)
    public String getZrnzennouzndkyen03() {
        return zrnzennouzndkyen03;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnzennouzndkyen03(String pZrnzennouzndkyen03) {
        zrnzennouzndkyen03 = pZrnzennouzndkyen03;
    }

    private String zrnzennouzndkgaika03;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Rn.ZRNZENNOUZNDKGAIKA03)
    public String getZrnzennouzndkgaika03() {
        return zrnzennouzndkgaika03;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnzennouzndkgaika03(String pZrnzennouzndkgaika03) {
        zrnzennouzndkgaika03 = pZrnzennouzndkgaika03;
    }

    private String zrnyenhrkgkgoukei03;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Rn.ZRNYENHRKGKGOUKEI03)
    public String getZrnyenhrkgkgoukei03() {
        return zrnyenhrkgkgoukei03;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnyenhrkgkgoukei03(String pZrnyenhrkgkgoukei03) {
        zrnyenhrkgkgoukei03 = pZrnyenhrkgkgoukei03;
    }

    private String zrnkihrkmp03;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Rn.ZRNKIHRKMP03)
    public String getZrnkihrkmp03() {
        return zrnkihrkmp03;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnkihrkmp03(String pZrnkihrkmp03) {
        zrnkihrkmp03 = pZrnkihrkmp03;
    }

    private String zrnw03;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Rn.ZRNW03)
    public String getZrnw03() {
        return zrnw03;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnw03(String pZrnw03) {
        zrnw03 = pZrnw03;
    }

    private String zrnwyenyendaka03;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Rn.ZRNWYENYENDAKA03)
    public String getZrnwyenyendaka03() {
        return zrnwyenyendaka03;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnwyenyendaka03(String pZrnwyenyendaka03) {
        zrnwyenyendaka03 = pZrnwyenyendaka03;
    }

    private String zrnwyenkijun03;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Rn.ZRNWYENKIJUN03)
    public String getZrnwyenkijun03() {
        return zrnwyenkijun03;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnwyenkijun03(String pZrnwyenkijun03) {
        zrnwyenkijun03 = pZrnwyenkijun03;
    }

    private String zrnwyenyenyasu03;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Rn.ZRNWYENYENYASU03)
    public String getZrnwyenyenyasu03() {
        return zrnwyenyenyasu03;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnwyenyenyasu03(String pZrnwyenyenyasu03) {
        zrnwyenyenyasu03 = pZrnwyenyenyasu03;
    }

    private String zrnkaiykuktgk03;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Rn.ZRNKAIYKUKTGK03)
    public String getZrnkaiykuktgk03() {
        return zrnkaiykuktgk03;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnkaiykuktgk03(String pZrnkaiykuktgk03) {
        zrnkaiykuktgk03 = pZrnkaiykuktgk03;
    }

    private String zrnkaiykuktgkyenyendaka03;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Rn.ZRNKAIYKUKTGKYENYENDAKA03)
    public String getZrnkaiykuktgkyenyendaka03() {
        return zrnkaiykuktgkyenyendaka03;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnkaiykuktgkyenyendaka03(String pZrnkaiykuktgkyenyendaka03) {
        zrnkaiykuktgkyenyendaka03 = pZrnkaiykuktgkyenyendaka03;
    }

    private String zrnkaiykuktgkyenkijun03;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Rn.ZRNKAIYKUKTGKYENKIJUN03)
    public String getZrnkaiykuktgkyenkijun03() {
        return zrnkaiykuktgkyenkijun03;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnkaiykuktgkyenkijun03(String pZrnkaiykuktgkyenkijun03) {
        zrnkaiykuktgkyenkijun03 = pZrnkaiykuktgkyenkijun03;
    }

    private String zrnkaiykuktgkyenyenyasu03;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Rn.ZRNKAIYKUKTGKYENYENYASU03)
    public String getZrnkaiykuktgkyenyenyasu03() {
        return zrnkaiykuktgkyenyenyasu03;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnkaiykuktgkyenyenyasu03(String pZrnkaiykuktgkyenyenyasu03) {
        zrnkaiykuktgkyenyenyasu03 = pZrnkaiykuktgkyenyenyasu03;
    }

    private String zrnkeikanensuu04;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Rn.ZRNKEIKANENSUU04)
    public String getZrnkeikanensuu04() {
        return zrnkeikanensuu04;
    }

    @Padding(mode = "left", padChar ='0', length =2)
    public void setZrnkeikanensuu04(String pZrnkeikanensuu04) {
        zrnkeikanensuu04 = pZrnkeikanensuu04;
    }

    private String zrnhrkkknmnryumukbn04;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Rn.ZRNHRKKKNMNRYUMUKBN04)
    public String getZrnhrkkknmnryumukbn04() {
        return zrnhrkkknmnryumukbn04;
    }

    public void setZrnhrkkknmnryumukbn04(String pZrnhrkkknmnryumukbn04) {
        zrnhrkkknmnryumukbn04 = pZrnhrkkknmnryumukbn04;
    }

    private String zrnzennouzndkyen04;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Rn.ZRNZENNOUZNDKYEN04)
    public String getZrnzennouzndkyen04() {
        return zrnzennouzndkyen04;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnzennouzndkyen04(String pZrnzennouzndkyen04) {
        zrnzennouzndkyen04 = pZrnzennouzndkyen04;
    }

    private String zrnzennouzndkgaika04;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Rn.ZRNZENNOUZNDKGAIKA04)
    public String getZrnzennouzndkgaika04() {
        return zrnzennouzndkgaika04;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnzennouzndkgaika04(String pZrnzennouzndkgaika04) {
        zrnzennouzndkgaika04 = pZrnzennouzndkgaika04;
    }

    private String zrnyenhrkgkgoukei04;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Rn.ZRNYENHRKGKGOUKEI04)
    public String getZrnyenhrkgkgoukei04() {
        return zrnyenhrkgkgoukei04;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnyenhrkgkgoukei04(String pZrnyenhrkgkgoukei04) {
        zrnyenhrkgkgoukei04 = pZrnyenhrkgkgoukei04;
    }

    private String zrnkihrkmp04;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Rn.ZRNKIHRKMP04)
    public String getZrnkihrkmp04() {
        return zrnkihrkmp04;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnkihrkmp04(String pZrnkihrkmp04) {
        zrnkihrkmp04 = pZrnkihrkmp04;
    }

    private String zrnw04;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Rn.ZRNW04)
    public String getZrnw04() {
        return zrnw04;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnw04(String pZrnw04) {
        zrnw04 = pZrnw04;
    }

    private String zrnwyenyendaka04;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Rn.ZRNWYENYENDAKA04)
    public String getZrnwyenyendaka04() {
        return zrnwyenyendaka04;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnwyenyendaka04(String pZrnwyenyendaka04) {
        zrnwyenyendaka04 = pZrnwyenyendaka04;
    }

    private String zrnwyenkijun04;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Rn.ZRNWYENKIJUN04)
    public String getZrnwyenkijun04() {
        return zrnwyenkijun04;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnwyenkijun04(String pZrnwyenkijun04) {
        zrnwyenkijun04 = pZrnwyenkijun04;
    }

    private String zrnwyenyenyasu04;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Rn.ZRNWYENYENYASU04)
    public String getZrnwyenyenyasu04() {
        return zrnwyenyenyasu04;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnwyenyenyasu04(String pZrnwyenyenyasu04) {
        zrnwyenyenyasu04 = pZrnwyenyenyasu04;
    }

    private String zrnkaiykuktgk04;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Rn.ZRNKAIYKUKTGK04)
    public String getZrnkaiykuktgk04() {
        return zrnkaiykuktgk04;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnkaiykuktgk04(String pZrnkaiykuktgk04) {
        zrnkaiykuktgk04 = pZrnkaiykuktgk04;
    }

    private String zrnkaiykuktgkyenyendaka04;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Rn.ZRNKAIYKUKTGKYENYENDAKA04)
    public String getZrnkaiykuktgkyenyendaka04() {
        return zrnkaiykuktgkyenyendaka04;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnkaiykuktgkyenyendaka04(String pZrnkaiykuktgkyenyendaka04) {
        zrnkaiykuktgkyenyendaka04 = pZrnkaiykuktgkyenyendaka04;
    }

    private String zrnkaiykuktgkyenkijun04;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Rn.ZRNKAIYKUKTGKYENKIJUN04)
    public String getZrnkaiykuktgkyenkijun04() {
        return zrnkaiykuktgkyenkijun04;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnkaiykuktgkyenkijun04(String pZrnkaiykuktgkyenkijun04) {
        zrnkaiykuktgkyenkijun04 = pZrnkaiykuktgkyenkijun04;
    }

    private String zrnkaiykuktgkyenyenyasu04;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Rn.ZRNKAIYKUKTGKYENYENYASU04)
    public String getZrnkaiykuktgkyenyenyasu04() {
        return zrnkaiykuktgkyenyenyasu04;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnkaiykuktgkyenyenyasu04(String pZrnkaiykuktgkyenyenyasu04) {
        zrnkaiykuktgkyenyenyasu04 = pZrnkaiykuktgkyenyenyasu04;
    }

    private String zrnkeikanensuu05;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Rn.ZRNKEIKANENSUU05)
    public String getZrnkeikanensuu05() {
        return zrnkeikanensuu05;
    }

    @Padding(mode = "left", padChar ='0', length =2)
    public void setZrnkeikanensuu05(String pZrnkeikanensuu05) {
        zrnkeikanensuu05 = pZrnkeikanensuu05;
    }

    private String zrnhrkkknmnryumukbn05;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Rn.ZRNHRKKKNMNRYUMUKBN05)
    public String getZrnhrkkknmnryumukbn05() {
        return zrnhrkkknmnryumukbn05;
    }

    public void setZrnhrkkknmnryumukbn05(String pZrnhrkkknmnryumukbn05) {
        zrnhrkkknmnryumukbn05 = pZrnhrkkknmnryumukbn05;
    }

    private String zrnzennouzndkyen05;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Rn.ZRNZENNOUZNDKYEN05)
    public String getZrnzennouzndkyen05() {
        return zrnzennouzndkyen05;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnzennouzndkyen05(String pZrnzennouzndkyen05) {
        zrnzennouzndkyen05 = pZrnzennouzndkyen05;
    }

    private String zrnzennouzndkgaika05;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Rn.ZRNZENNOUZNDKGAIKA05)
    public String getZrnzennouzndkgaika05() {
        return zrnzennouzndkgaika05;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnzennouzndkgaika05(String pZrnzennouzndkgaika05) {
        zrnzennouzndkgaika05 = pZrnzennouzndkgaika05;
    }

    private String zrnyenhrkgkgoukei05;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Rn.ZRNYENHRKGKGOUKEI05)
    public String getZrnyenhrkgkgoukei05() {
        return zrnyenhrkgkgoukei05;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnyenhrkgkgoukei05(String pZrnyenhrkgkgoukei05) {
        zrnyenhrkgkgoukei05 = pZrnyenhrkgkgoukei05;
    }

    private String zrnkihrkmp05;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Rn.ZRNKIHRKMP05)
    public String getZrnkihrkmp05() {
        return zrnkihrkmp05;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnkihrkmp05(String pZrnkihrkmp05) {
        zrnkihrkmp05 = pZrnkihrkmp05;
    }

    private String zrnw05;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Rn.ZRNW05)
    public String getZrnw05() {
        return zrnw05;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnw05(String pZrnw05) {
        zrnw05 = pZrnw05;
    }

    private String zrnwyenyendaka05;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Rn.ZRNWYENYENDAKA05)
    public String getZrnwyenyendaka05() {
        return zrnwyenyendaka05;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnwyenyendaka05(String pZrnwyenyendaka05) {
        zrnwyenyendaka05 = pZrnwyenyendaka05;
    }

    private String zrnwyenkijun05;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Rn.ZRNWYENKIJUN05)
    public String getZrnwyenkijun05() {
        return zrnwyenkijun05;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnwyenkijun05(String pZrnwyenkijun05) {
        zrnwyenkijun05 = pZrnwyenkijun05;
    }

    private String zrnwyenyenyasu05;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Rn.ZRNWYENYENYASU05)
    public String getZrnwyenyenyasu05() {
        return zrnwyenyenyasu05;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnwyenyenyasu05(String pZrnwyenyenyasu05) {
        zrnwyenyenyasu05 = pZrnwyenyenyasu05;
    }

    private String zrnkaiykuktgk05;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Rn.ZRNKAIYKUKTGK05)
    public String getZrnkaiykuktgk05() {
        return zrnkaiykuktgk05;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnkaiykuktgk05(String pZrnkaiykuktgk05) {
        zrnkaiykuktgk05 = pZrnkaiykuktgk05;
    }

    private String zrnkaiykuktgkyenyendaka05;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Rn.ZRNKAIYKUKTGKYENYENDAKA05)
    public String getZrnkaiykuktgkyenyendaka05() {
        return zrnkaiykuktgkyenyendaka05;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnkaiykuktgkyenyendaka05(String pZrnkaiykuktgkyenyendaka05) {
        zrnkaiykuktgkyenyendaka05 = pZrnkaiykuktgkyenyendaka05;
    }

    private String zrnkaiykuktgkyenkijun05;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Rn.ZRNKAIYKUKTGKYENKIJUN05)
    public String getZrnkaiykuktgkyenkijun05() {
        return zrnkaiykuktgkyenkijun05;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnkaiykuktgkyenkijun05(String pZrnkaiykuktgkyenkijun05) {
        zrnkaiykuktgkyenkijun05 = pZrnkaiykuktgkyenkijun05;
    }

    private String zrnkaiykuktgkyenyenyasu05;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Rn.ZRNKAIYKUKTGKYENYENYASU05)
    public String getZrnkaiykuktgkyenyenyasu05() {
        return zrnkaiykuktgkyenyenyasu05;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnkaiykuktgkyenyenyasu05(String pZrnkaiykuktgkyenyenyasu05) {
        zrnkaiykuktgkyenyenyasu05 = pZrnkaiykuktgkyenyenyasu05;
    }

    private String zrnkeikanensuu06;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Rn.ZRNKEIKANENSUU06)
    public String getZrnkeikanensuu06() {
        return zrnkeikanensuu06;
    }

    @Padding(mode = "left", padChar ='0', length =2)
    public void setZrnkeikanensuu06(String pZrnkeikanensuu06) {
        zrnkeikanensuu06 = pZrnkeikanensuu06;
    }

    private String zrnhrkkknmnryumukbn06;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Rn.ZRNHRKKKNMNRYUMUKBN06)
    public String getZrnhrkkknmnryumukbn06() {
        return zrnhrkkknmnryumukbn06;
    }

    public void setZrnhrkkknmnryumukbn06(String pZrnhrkkknmnryumukbn06) {
        zrnhrkkknmnryumukbn06 = pZrnhrkkknmnryumukbn06;
    }

    private String zrnzennouzndkyen06;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Rn.ZRNZENNOUZNDKYEN06)
    public String getZrnzennouzndkyen06() {
        return zrnzennouzndkyen06;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnzennouzndkyen06(String pZrnzennouzndkyen06) {
        zrnzennouzndkyen06 = pZrnzennouzndkyen06;
    }

    private String zrnzennouzndkgaika06;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Rn.ZRNZENNOUZNDKGAIKA06)
    public String getZrnzennouzndkgaika06() {
        return zrnzennouzndkgaika06;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnzennouzndkgaika06(String pZrnzennouzndkgaika06) {
        zrnzennouzndkgaika06 = pZrnzennouzndkgaika06;
    }

    private String zrnyenhrkgkgoukei06;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Rn.ZRNYENHRKGKGOUKEI06)
    public String getZrnyenhrkgkgoukei06() {
        return zrnyenhrkgkgoukei06;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnyenhrkgkgoukei06(String pZrnyenhrkgkgoukei06) {
        zrnyenhrkgkgoukei06 = pZrnyenhrkgkgoukei06;
    }

    private String zrnkihrkmp06;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Rn.ZRNKIHRKMP06)
    public String getZrnkihrkmp06() {
        return zrnkihrkmp06;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnkihrkmp06(String pZrnkihrkmp06) {
        zrnkihrkmp06 = pZrnkihrkmp06;
    }

    private String zrnw06;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Rn.ZRNW06)
    public String getZrnw06() {
        return zrnw06;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnw06(String pZrnw06) {
        zrnw06 = pZrnw06;
    }

    private String zrnwyenyendaka06;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Rn.ZRNWYENYENDAKA06)
    public String getZrnwyenyendaka06() {
        return zrnwyenyendaka06;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnwyenyendaka06(String pZrnwyenyendaka06) {
        zrnwyenyendaka06 = pZrnwyenyendaka06;
    }

    private String zrnwyenkijun06;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Rn.ZRNWYENKIJUN06)
    public String getZrnwyenkijun06() {
        return zrnwyenkijun06;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnwyenkijun06(String pZrnwyenkijun06) {
        zrnwyenkijun06 = pZrnwyenkijun06;
    }

    private String zrnwyenyenyasu06;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Rn.ZRNWYENYENYASU06)
    public String getZrnwyenyenyasu06() {
        return zrnwyenyenyasu06;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnwyenyenyasu06(String pZrnwyenyenyasu06) {
        zrnwyenyenyasu06 = pZrnwyenyenyasu06;
    }

    private String zrnkaiykuktgk06;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Rn.ZRNKAIYKUKTGK06)
    public String getZrnkaiykuktgk06() {
        return zrnkaiykuktgk06;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnkaiykuktgk06(String pZrnkaiykuktgk06) {
        zrnkaiykuktgk06 = pZrnkaiykuktgk06;
    }

    private String zrnkaiykuktgkyenyendaka06;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Rn.ZRNKAIYKUKTGKYENYENDAKA06)
    public String getZrnkaiykuktgkyenyendaka06() {
        return zrnkaiykuktgkyenyendaka06;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnkaiykuktgkyenyendaka06(String pZrnkaiykuktgkyenyendaka06) {
        zrnkaiykuktgkyenyendaka06 = pZrnkaiykuktgkyenyendaka06;
    }

    private String zrnkaiykuktgkyenkijun06;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Rn.ZRNKAIYKUKTGKYENKIJUN06)
    public String getZrnkaiykuktgkyenkijun06() {
        return zrnkaiykuktgkyenkijun06;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnkaiykuktgkyenkijun06(String pZrnkaiykuktgkyenkijun06) {
        zrnkaiykuktgkyenkijun06 = pZrnkaiykuktgkyenkijun06;
    }

    private String zrnkaiykuktgkyenyenyasu06;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Rn.ZRNKAIYKUKTGKYENYENYASU06)
    public String getZrnkaiykuktgkyenyenyasu06() {
        return zrnkaiykuktgkyenyenyasu06;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnkaiykuktgkyenyenyasu06(String pZrnkaiykuktgkyenyenyasu06) {
        zrnkaiykuktgkyenyenyasu06 = pZrnkaiykuktgkyenyenyasu06;
    }

    private String zrnkeikanensuu07;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Rn.ZRNKEIKANENSUU07)
    public String getZrnkeikanensuu07() {
        return zrnkeikanensuu07;
    }

    @Padding(mode = "left", padChar ='0', length =2)
    public void setZrnkeikanensuu07(String pZrnkeikanensuu07) {
        zrnkeikanensuu07 = pZrnkeikanensuu07;
    }

    private String zrnhrkkknmnryumukbn07;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Rn.ZRNHRKKKNMNRYUMUKBN07)
    public String getZrnhrkkknmnryumukbn07() {
        return zrnhrkkknmnryumukbn07;
    }

    public void setZrnhrkkknmnryumukbn07(String pZrnhrkkknmnryumukbn07) {
        zrnhrkkknmnryumukbn07 = pZrnhrkkknmnryumukbn07;
    }

    private String zrnzennouzndkyen07;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Rn.ZRNZENNOUZNDKYEN07)
    public String getZrnzennouzndkyen07() {
        return zrnzennouzndkyen07;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnzennouzndkyen07(String pZrnzennouzndkyen07) {
        zrnzennouzndkyen07 = pZrnzennouzndkyen07;
    }

    private String zrnzennouzndkgaika07;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Rn.ZRNZENNOUZNDKGAIKA07)
    public String getZrnzennouzndkgaika07() {
        return zrnzennouzndkgaika07;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnzennouzndkgaika07(String pZrnzennouzndkgaika07) {
        zrnzennouzndkgaika07 = pZrnzennouzndkgaika07;
    }

    private String zrnyenhrkgkgoukei07;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Rn.ZRNYENHRKGKGOUKEI07)
    public String getZrnyenhrkgkgoukei07() {
        return zrnyenhrkgkgoukei07;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnyenhrkgkgoukei07(String pZrnyenhrkgkgoukei07) {
        zrnyenhrkgkgoukei07 = pZrnyenhrkgkgoukei07;
    }

    private String zrnkihrkmp07;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Rn.ZRNKIHRKMP07)
    public String getZrnkihrkmp07() {
        return zrnkihrkmp07;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnkihrkmp07(String pZrnkihrkmp07) {
        zrnkihrkmp07 = pZrnkihrkmp07;
    }

    private String zrnw07;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Rn.ZRNW07)
    public String getZrnw07() {
        return zrnw07;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnw07(String pZrnw07) {
        zrnw07 = pZrnw07;
    }

    private String zrnwyenyendaka07;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Rn.ZRNWYENYENDAKA07)
    public String getZrnwyenyendaka07() {
        return zrnwyenyendaka07;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnwyenyendaka07(String pZrnwyenyendaka07) {
        zrnwyenyendaka07 = pZrnwyenyendaka07;
    }

    private String zrnwyenkijun07;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Rn.ZRNWYENKIJUN07)
    public String getZrnwyenkijun07() {
        return zrnwyenkijun07;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnwyenkijun07(String pZrnwyenkijun07) {
        zrnwyenkijun07 = pZrnwyenkijun07;
    }

    private String zrnwyenyenyasu07;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Rn.ZRNWYENYENYASU07)
    public String getZrnwyenyenyasu07() {
        return zrnwyenyenyasu07;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnwyenyenyasu07(String pZrnwyenyenyasu07) {
        zrnwyenyenyasu07 = pZrnwyenyenyasu07;
    }

    private String zrnkaiykuktgk07;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Rn.ZRNKAIYKUKTGK07)
    public String getZrnkaiykuktgk07() {
        return zrnkaiykuktgk07;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnkaiykuktgk07(String pZrnkaiykuktgk07) {
        zrnkaiykuktgk07 = pZrnkaiykuktgk07;
    }

    private String zrnkaiykuktgkyenyendaka07;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Rn.ZRNKAIYKUKTGKYENYENDAKA07)
    public String getZrnkaiykuktgkyenyendaka07() {
        return zrnkaiykuktgkyenyendaka07;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnkaiykuktgkyenyendaka07(String pZrnkaiykuktgkyenyendaka07) {
        zrnkaiykuktgkyenyendaka07 = pZrnkaiykuktgkyenyendaka07;
    }

    private String zrnkaiykuktgkyenkijun07;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Rn.ZRNKAIYKUKTGKYENKIJUN07)
    public String getZrnkaiykuktgkyenkijun07() {
        return zrnkaiykuktgkyenkijun07;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnkaiykuktgkyenkijun07(String pZrnkaiykuktgkyenkijun07) {
        zrnkaiykuktgkyenkijun07 = pZrnkaiykuktgkyenkijun07;
    }

    private String zrnkaiykuktgkyenyenyasu07;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Rn.ZRNKAIYKUKTGKYENYENYASU07)
    public String getZrnkaiykuktgkyenyenyasu07() {
        return zrnkaiykuktgkyenyenyasu07;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnkaiykuktgkyenyenyasu07(String pZrnkaiykuktgkyenyenyasu07) {
        zrnkaiykuktgkyenyenyasu07 = pZrnkaiykuktgkyenyenyasu07;
    }

    private String zrnkeikanensuu08;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Rn.ZRNKEIKANENSUU08)
    public String getZrnkeikanensuu08() {
        return zrnkeikanensuu08;
    }

    @Padding(mode = "left", padChar ='0', length =2)
    public void setZrnkeikanensuu08(String pZrnkeikanensuu08) {
        zrnkeikanensuu08 = pZrnkeikanensuu08;
    }

    private String zrnhrkkknmnryumukbn08;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Rn.ZRNHRKKKNMNRYUMUKBN08)
    public String getZrnhrkkknmnryumukbn08() {
        return zrnhrkkknmnryumukbn08;
    }

    public void setZrnhrkkknmnryumukbn08(String pZrnhrkkknmnryumukbn08) {
        zrnhrkkknmnryumukbn08 = pZrnhrkkknmnryumukbn08;
    }

    private String zrnzennouzndkyen08;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Rn.ZRNZENNOUZNDKYEN08)
    public String getZrnzennouzndkyen08() {
        return zrnzennouzndkyen08;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnzennouzndkyen08(String pZrnzennouzndkyen08) {
        zrnzennouzndkyen08 = pZrnzennouzndkyen08;
    }

    private String zrnzennouzndkgaika08;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Rn.ZRNZENNOUZNDKGAIKA08)
    public String getZrnzennouzndkgaika08() {
        return zrnzennouzndkgaika08;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnzennouzndkgaika08(String pZrnzennouzndkgaika08) {
        zrnzennouzndkgaika08 = pZrnzennouzndkgaika08;
    }

    private String zrnyenhrkgkgoukei08;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Rn.ZRNYENHRKGKGOUKEI08)
    public String getZrnyenhrkgkgoukei08() {
        return zrnyenhrkgkgoukei08;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnyenhrkgkgoukei08(String pZrnyenhrkgkgoukei08) {
        zrnyenhrkgkgoukei08 = pZrnyenhrkgkgoukei08;
    }

    private String zrnkihrkmp08;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Rn.ZRNKIHRKMP08)
    public String getZrnkihrkmp08() {
        return zrnkihrkmp08;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnkihrkmp08(String pZrnkihrkmp08) {
        zrnkihrkmp08 = pZrnkihrkmp08;
    }

    private String zrnw08;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Rn.ZRNW08)
    public String getZrnw08() {
        return zrnw08;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnw08(String pZrnw08) {
        zrnw08 = pZrnw08;
    }

    private String zrnwyenyendaka08;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Rn.ZRNWYENYENDAKA08)
    public String getZrnwyenyendaka08() {
        return zrnwyenyendaka08;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnwyenyendaka08(String pZrnwyenyendaka08) {
        zrnwyenyendaka08 = pZrnwyenyendaka08;
    }

    private String zrnwyenkijun08;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Rn.ZRNWYENKIJUN08)
    public String getZrnwyenkijun08() {
        return zrnwyenkijun08;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnwyenkijun08(String pZrnwyenkijun08) {
        zrnwyenkijun08 = pZrnwyenkijun08;
    }

    private String zrnwyenyenyasu08;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Rn.ZRNWYENYENYASU08)
    public String getZrnwyenyenyasu08() {
        return zrnwyenyenyasu08;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnwyenyenyasu08(String pZrnwyenyenyasu08) {
        zrnwyenyenyasu08 = pZrnwyenyenyasu08;
    }

    private String zrnkaiykuktgk08;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Rn.ZRNKAIYKUKTGK08)
    public String getZrnkaiykuktgk08() {
        return zrnkaiykuktgk08;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnkaiykuktgk08(String pZrnkaiykuktgk08) {
        zrnkaiykuktgk08 = pZrnkaiykuktgk08;
    }

    private String zrnkaiykuktgkyenyendaka08;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Rn.ZRNKAIYKUKTGKYENYENDAKA08)
    public String getZrnkaiykuktgkyenyendaka08() {
        return zrnkaiykuktgkyenyendaka08;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnkaiykuktgkyenyendaka08(String pZrnkaiykuktgkyenyendaka08) {
        zrnkaiykuktgkyenyendaka08 = pZrnkaiykuktgkyenyendaka08;
    }

    private String zrnkaiykuktgkyenkijun08;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Rn.ZRNKAIYKUKTGKYENKIJUN08)
    public String getZrnkaiykuktgkyenkijun08() {
        return zrnkaiykuktgkyenkijun08;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnkaiykuktgkyenkijun08(String pZrnkaiykuktgkyenkijun08) {
        zrnkaiykuktgkyenkijun08 = pZrnkaiykuktgkyenkijun08;
    }

    private String zrnkaiykuktgkyenyenyasu08;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Rn.ZRNKAIYKUKTGKYENYENYASU08)
    public String getZrnkaiykuktgkyenyenyasu08() {
        return zrnkaiykuktgkyenyenyasu08;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnkaiykuktgkyenyenyasu08(String pZrnkaiykuktgkyenyenyasu08) {
        zrnkaiykuktgkyenyenyasu08 = pZrnkaiykuktgkyenyenyasu08;
    }

    private String zrnkeikanensuu09;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Rn.ZRNKEIKANENSUU09)
    public String getZrnkeikanensuu09() {
        return zrnkeikanensuu09;
    }

    @Padding(mode = "left", padChar ='0', length =2)
    public void setZrnkeikanensuu09(String pZrnkeikanensuu09) {
        zrnkeikanensuu09 = pZrnkeikanensuu09;
    }

    private String zrnhrkkknmnryumukbn09;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Rn.ZRNHRKKKNMNRYUMUKBN09)
    public String getZrnhrkkknmnryumukbn09() {
        return zrnhrkkknmnryumukbn09;
    }

    public void setZrnhrkkknmnryumukbn09(String pZrnhrkkknmnryumukbn09) {
        zrnhrkkknmnryumukbn09 = pZrnhrkkknmnryumukbn09;
    }

    private String zrnzennouzndkyen09;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Rn.ZRNZENNOUZNDKYEN09)
    public String getZrnzennouzndkyen09() {
        return zrnzennouzndkyen09;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnzennouzndkyen09(String pZrnzennouzndkyen09) {
        zrnzennouzndkyen09 = pZrnzennouzndkyen09;
    }

    private String zrnzennouzndkgaika09;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Rn.ZRNZENNOUZNDKGAIKA09)
    public String getZrnzennouzndkgaika09() {
        return zrnzennouzndkgaika09;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnzennouzndkgaika09(String pZrnzennouzndkgaika09) {
        zrnzennouzndkgaika09 = pZrnzennouzndkgaika09;
    }

    private String zrnyenhrkgkgoukei09;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Rn.ZRNYENHRKGKGOUKEI09)
    public String getZrnyenhrkgkgoukei09() {
        return zrnyenhrkgkgoukei09;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnyenhrkgkgoukei09(String pZrnyenhrkgkgoukei09) {
        zrnyenhrkgkgoukei09 = pZrnyenhrkgkgoukei09;
    }

    private String zrnkihrkmp09;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Rn.ZRNKIHRKMP09)
    public String getZrnkihrkmp09() {
        return zrnkihrkmp09;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnkihrkmp09(String pZrnkihrkmp09) {
        zrnkihrkmp09 = pZrnkihrkmp09;
    }

    private String zrnw09;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Rn.ZRNW09)
    public String getZrnw09() {
        return zrnw09;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnw09(String pZrnw09) {
        zrnw09 = pZrnw09;
    }

    private String zrnwyenyendaka09;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Rn.ZRNWYENYENDAKA09)
    public String getZrnwyenyendaka09() {
        return zrnwyenyendaka09;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnwyenyendaka09(String pZrnwyenyendaka09) {
        zrnwyenyendaka09 = pZrnwyenyendaka09;
    }

    private String zrnwyenkijun09;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Rn.ZRNWYENKIJUN09)
    public String getZrnwyenkijun09() {
        return zrnwyenkijun09;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnwyenkijun09(String pZrnwyenkijun09) {
        zrnwyenkijun09 = pZrnwyenkijun09;
    }

    private String zrnwyenyenyasu09;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Rn.ZRNWYENYENYASU09)
    public String getZrnwyenyenyasu09() {
        return zrnwyenyenyasu09;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnwyenyenyasu09(String pZrnwyenyenyasu09) {
        zrnwyenyenyasu09 = pZrnwyenyenyasu09;
    }

    private String zrnkaiykuktgk09;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Rn.ZRNKAIYKUKTGK09)
    public String getZrnkaiykuktgk09() {
        return zrnkaiykuktgk09;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnkaiykuktgk09(String pZrnkaiykuktgk09) {
        zrnkaiykuktgk09 = pZrnkaiykuktgk09;
    }

    private String zrnkaiykuktgkyenyendaka09;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Rn.ZRNKAIYKUKTGKYENYENDAKA09)
    public String getZrnkaiykuktgkyenyendaka09() {
        return zrnkaiykuktgkyenyendaka09;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnkaiykuktgkyenyendaka09(String pZrnkaiykuktgkyenyendaka09) {
        zrnkaiykuktgkyenyendaka09 = pZrnkaiykuktgkyenyendaka09;
    }

    private String zrnkaiykuktgkyenkijun09;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Rn.ZRNKAIYKUKTGKYENKIJUN09)
    public String getZrnkaiykuktgkyenkijun09() {
        return zrnkaiykuktgkyenkijun09;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnkaiykuktgkyenkijun09(String pZrnkaiykuktgkyenkijun09) {
        zrnkaiykuktgkyenkijun09 = pZrnkaiykuktgkyenkijun09;
    }

    private String zrnkaiykuktgkyenyenyasu09;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Rn.ZRNKAIYKUKTGKYENYENYASU09)
    public String getZrnkaiykuktgkyenyenyasu09() {
        return zrnkaiykuktgkyenyenyasu09;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnkaiykuktgkyenyenyasu09(String pZrnkaiykuktgkyenyenyasu09) {
        zrnkaiykuktgkyenyenyasu09 = pZrnkaiykuktgkyenyenyasu09;
    }

    private String zrnkeikanensuu10;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Rn.ZRNKEIKANENSUU10)
    public String getZrnkeikanensuu10() {
        return zrnkeikanensuu10;
    }

    @Padding(mode = "left", padChar ='0', length =2)
    public void setZrnkeikanensuu10(String pZrnkeikanensuu10) {
        zrnkeikanensuu10 = pZrnkeikanensuu10;
    }

    private String zrnhrkkknmnryumukbn10;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Rn.ZRNHRKKKNMNRYUMUKBN10)
    public String getZrnhrkkknmnryumukbn10() {
        return zrnhrkkknmnryumukbn10;
    }

    public void setZrnhrkkknmnryumukbn10(String pZrnhrkkknmnryumukbn10) {
        zrnhrkkknmnryumukbn10 = pZrnhrkkknmnryumukbn10;
    }

    private String zrnzennouzndkyen10;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Rn.ZRNZENNOUZNDKYEN10)
    public String getZrnzennouzndkyen10() {
        return zrnzennouzndkyen10;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnzennouzndkyen10(String pZrnzennouzndkyen10) {
        zrnzennouzndkyen10 = pZrnzennouzndkyen10;
    }

    private String zrnzennouzndkgaika10;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Rn.ZRNZENNOUZNDKGAIKA10)
    public String getZrnzennouzndkgaika10() {
        return zrnzennouzndkgaika10;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnzennouzndkgaika10(String pZrnzennouzndkgaika10) {
        zrnzennouzndkgaika10 = pZrnzennouzndkgaika10;
    }

    private String zrnyenhrkgkgoukei10;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Rn.ZRNYENHRKGKGOUKEI10)
    public String getZrnyenhrkgkgoukei10() {
        return zrnyenhrkgkgoukei10;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnyenhrkgkgoukei10(String pZrnyenhrkgkgoukei10) {
        zrnyenhrkgkgoukei10 = pZrnyenhrkgkgoukei10;
    }

    private String zrnkihrkmp10;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Rn.ZRNKIHRKMP10)
    public String getZrnkihrkmp10() {
        return zrnkihrkmp10;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnkihrkmp10(String pZrnkihrkmp10) {
        zrnkihrkmp10 = pZrnkihrkmp10;
    }

    private String zrnw10;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Rn.ZRNW10)
    public String getZrnw10() {
        return zrnw10;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnw10(String pZrnw10) {
        zrnw10 = pZrnw10;
    }

    private String zrnwyenyendaka10;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Rn.ZRNWYENYENDAKA10)
    public String getZrnwyenyendaka10() {
        return zrnwyenyendaka10;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnwyenyendaka10(String pZrnwyenyendaka10) {
        zrnwyenyendaka10 = pZrnwyenyendaka10;
    }

    private String zrnwyenkijun10;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Rn.ZRNWYENKIJUN10)
    public String getZrnwyenkijun10() {
        return zrnwyenkijun10;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnwyenkijun10(String pZrnwyenkijun10) {
        zrnwyenkijun10 = pZrnwyenkijun10;
    }

    private String zrnwyenyenyasu10;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Rn.ZRNWYENYENYASU10)
    public String getZrnwyenyenyasu10() {
        return zrnwyenyenyasu10;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnwyenyenyasu10(String pZrnwyenyenyasu10) {
        zrnwyenyenyasu10 = pZrnwyenyenyasu10;
    }

    private String zrnkaiykuktgk10;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Rn.ZRNKAIYKUKTGK10)
    public String getZrnkaiykuktgk10() {
        return zrnkaiykuktgk10;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnkaiykuktgk10(String pZrnkaiykuktgk10) {
        zrnkaiykuktgk10 = pZrnkaiykuktgk10;
    }

    private String zrnkaiykuktgkyenyendaka10;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Rn.ZRNKAIYKUKTGKYENYENDAKA10)
    public String getZrnkaiykuktgkyenyendaka10() {
        return zrnkaiykuktgkyenyendaka10;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnkaiykuktgkyenyendaka10(String pZrnkaiykuktgkyenyendaka10) {
        zrnkaiykuktgkyenyendaka10 = pZrnkaiykuktgkyenyendaka10;
    }

    private String zrnkaiykuktgkyenkijun10;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Rn.ZRNKAIYKUKTGKYENKIJUN10)
    public String getZrnkaiykuktgkyenkijun10() {
        return zrnkaiykuktgkyenkijun10;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnkaiykuktgkyenkijun10(String pZrnkaiykuktgkyenkijun10) {
        zrnkaiykuktgkyenkijun10 = pZrnkaiykuktgkyenkijun10;
    }

    private String zrnkaiykuktgkyenyenyasu10;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Rn.ZRNKAIYKUKTGKYENYENYASU10)
    public String getZrnkaiykuktgkyenyenyasu10() {
        return zrnkaiykuktgkyenyenyasu10;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnkaiykuktgkyenyenyasu10(String pZrnkaiykuktgkyenyenyasu10) {
        zrnkaiykuktgkyenyenyasu10 = pZrnkaiykuktgkyenyenyasu10;
    }

    private String zrnkeikanensuu11;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Rn.ZRNKEIKANENSUU11)
    public String getZrnkeikanensuu11() {
        return zrnkeikanensuu11;
    }

    @Padding(mode = "left", padChar ='0', length =2)
    public void setZrnkeikanensuu11(String pZrnkeikanensuu11) {
        zrnkeikanensuu11 = pZrnkeikanensuu11;
    }

    private String zrnhrkkknmnryumukbn11;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Rn.ZRNHRKKKNMNRYUMUKBN11)
    public String getZrnhrkkknmnryumukbn11() {
        return zrnhrkkknmnryumukbn11;
    }

    public void setZrnhrkkknmnryumukbn11(String pZrnhrkkknmnryumukbn11) {
        zrnhrkkknmnryumukbn11 = pZrnhrkkknmnryumukbn11;
    }

    private String zrnzennouzndkyen11;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Rn.ZRNZENNOUZNDKYEN11)
    public String getZrnzennouzndkyen11() {
        return zrnzennouzndkyen11;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnzennouzndkyen11(String pZrnzennouzndkyen11) {
        zrnzennouzndkyen11 = pZrnzennouzndkyen11;
    }

    private String zrnzennouzndkgaika11;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Rn.ZRNZENNOUZNDKGAIKA11)
    public String getZrnzennouzndkgaika11() {
        return zrnzennouzndkgaika11;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnzennouzndkgaika11(String pZrnzennouzndkgaika11) {
        zrnzennouzndkgaika11 = pZrnzennouzndkgaika11;
    }

    private String zrnyenhrkgkgoukei11;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Rn.ZRNYENHRKGKGOUKEI11)
    public String getZrnyenhrkgkgoukei11() {
        return zrnyenhrkgkgoukei11;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnyenhrkgkgoukei11(String pZrnyenhrkgkgoukei11) {
        zrnyenhrkgkgoukei11 = pZrnyenhrkgkgoukei11;
    }

    private String zrnkihrkmp11;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Rn.ZRNKIHRKMP11)
    public String getZrnkihrkmp11() {
        return zrnkihrkmp11;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnkihrkmp11(String pZrnkihrkmp11) {
        zrnkihrkmp11 = pZrnkihrkmp11;
    }

    private String zrnw11;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Rn.ZRNW11)
    public String getZrnw11() {
        return zrnw11;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnw11(String pZrnw11) {
        zrnw11 = pZrnw11;
    }

    private String zrnwyenyendaka11;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Rn.ZRNWYENYENDAKA11)
    public String getZrnwyenyendaka11() {
        return zrnwyenyendaka11;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnwyenyendaka11(String pZrnwyenyendaka11) {
        zrnwyenyendaka11 = pZrnwyenyendaka11;
    }

    private String zrnwyenkijun11;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Rn.ZRNWYENKIJUN11)
    public String getZrnwyenkijun11() {
        return zrnwyenkijun11;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnwyenkijun11(String pZrnwyenkijun11) {
        zrnwyenkijun11 = pZrnwyenkijun11;
    }

    private String zrnwyenyenyasu11;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Rn.ZRNWYENYENYASU11)
    public String getZrnwyenyenyasu11() {
        return zrnwyenyenyasu11;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnwyenyenyasu11(String pZrnwyenyenyasu11) {
        zrnwyenyenyasu11 = pZrnwyenyenyasu11;
    }

    private String zrnkaiykuktgk11;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Rn.ZRNKAIYKUKTGK11)
    public String getZrnkaiykuktgk11() {
        return zrnkaiykuktgk11;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnkaiykuktgk11(String pZrnkaiykuktgk11) {
        zrnkaiykuktgk11 = pZrnkaiykuktgk11;
    }

    private String zrnkaiykuktgkyenyendaka11;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Rn.ZRNKAIYKUKTGKYENYENDAKA11)
    public String getZrnkaiykuktgkyenyendaka11() {
        return zrnkaiykuktgkyenyendaka11;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnkaiykuktgkyenyendaka11(String pZrnkaiykuktgkyenyendaka11) {
        zrnkaiykuktgkyenyendaka11 = pZrnkaiykuktgkyenyendaka11;
    }

    private String zrnkaiykuktgkyenkijun11;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Rn.ZRNKAIYKUKTGKYENKIJUN11)
    public String getZrnkaiykuktgkyenkijun11() {
        return zrnkaiykuktgkyenkijun11;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnkaiykuktgkyenkijun11(String pZrnkaiykuktgkyenkijun11) {
        zrnkaiykuktgkyenkijun11 = pZrnkaiykuktgkyenkijun11;
    }

    private String zrnkaiykuktgkyenyenyasu11;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Rn.ZRNKAIYKUKTGKYENYENYASU11)
    public String getZrnkaiykuktgkyenyenyasu11() {
        return zrnkaiykuktgkyenyenyasu11;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnkaiykuktgkyenyenyasu11(String pZrnkaiykuktgkyenyenyasu11) {
        zrnkaiykuktgkyenyenyasu11 = pZrnkaiykuktgkyenyenyasu11;
    }

    private String zrnkeikanensuu12;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Rn.ZRNKEIKANENSUU12)
    public String getZrnkeikanensuu12() {
        return zrnkeikanensuu12;
    }

    @Padding(mode = "left", padChar ='0', length =2)
    public void setZrnkeikanensuu12(String pZrnkeikanensuu12) {
        zrnkeikanensuu12 = pZrnkeikanensuu12;
    }

    private String zrnhrkkknmnryumukbn12;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Rn.ZRNHRKKKNMNRYUMUKBN12)
    public String getZrnhrkkknmnryumukbn12() {
        return zrnhrkkknmnryumukbn12;
    }

    public void setZrnhrkkknmnryumukbn12(String pZrnhrkkknmnryumukbn12) {
        zrnhrkkknmnryumukbn12 = pZrnhrkkknmnryumukbn12;
    }

    private String zrnzennouzndkyen12;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Rn.ZRNZENNOUZNDKYEN12)
    public String getZrnzennouzndkyen12() {
        return zrnzennouzndkyen12;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnzennouzndkyen12(String pZrnzennouzndkyen12) {
        zrnzennouzndkyen12 = pZrnzennouzndkyen12;
    }

    private String zrnzennouzndkgaika12;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Rn.ZRNZENNOUZNDKGAIKA12)
    public String getZrnzennouzndkgaika12() {
        return zrnzennouzndkgaika12;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnzennouzndkgaika12(String pZrnzennouzndkgaika12) {
        zrnzennouzndkgaika12 = pZrnzennouzndkgaika12;
    }

    private String zrnyenhrkgkgoukei12;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Rn.ZRNYENHRKGKGOUKEI12)
    public String getZrnyenhrkgkgoukei12() {
        return zrnyenhrkgkgoukei12;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnyenhrkgkgoukei12(String pZrnyenhrkgkgoukei12) {
        zrnyenhrkgkgoukei12 = pZrnyenhrkgkgoukei12;
    }

    private String zrnkihrkmp12;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Rn.ZRNKIHRKMP12)
    public String getZrnkihrkmp12() {
        return zrnkihrkmp12;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnkihrkmp12(String pZrnkihrkmp12) {
        zrnkihrkmp12 = pZrnkihrkmp12;
    }

    private String zrnw12;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Rn.ZRNW12)
    public String getZrnw12() {
        return zrnw12;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnw12(String pZrnw12) {
        zrnw12 = pZrnw12;
    }

    private String zrnwyenyendaka12;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Rn.ZRNWYENYENDAKA12)
    public String getZrnwyenyendaka12() {
        return zrnwyenyendaka12;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnwyenyendaka12(String pZrnwyenyendaka12) {
        zrnwyenyendaka12 = pZrnwyenyendaka12;
    }

    private String zrnwyenkijun12;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Rn.ZRNWYENKIJUN12)
    public String getZrnwyenkijun12() {
        return zrnwyenkijun12;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnwyenkijun12(String pZrnwyenkijun12) {
        zrnwyenkijun12 = pZrnwyenkijun12;
    }

    private String zrnwyenyenyasu12;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Rn.ZRNWYENYENYASU12)
    public String getZrnwyenyenyasu12() {
        return zrnwyenyenyasu12;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnwyenyenyasu12(String pZrnwyenyenyasu12) {
        zrnwyenyenyasu12 = pZrnwyenyenyasu12;
    }

    private String zrnkaiykuktgk12;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Rn.ZRNKAIYKUKTGK12)
    public String getZrnkaiykuktgk12() {
        return zrnkaiykuktgk12;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnkaiykuktgk12(String pZrnkaiykuktgk12) {
        zrnkaiykuktgk12 = pZrnkaiykuktgk12;
    }

    private String zrnkaiykuktgkyenyendaka12;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Rn.ZRNKAIYKUKTGKYENYENDAKA12)
    public String getZrnkaiykuktgkyenyendaka12() {
        return zrnkaiykuktgkyenyendaka12;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnkaiykuktgkyenyendaka12(String pZrnkaiykuktgkyenyendaka12) {
        zrnkaiykuktgkyenyendaka12 = pZrnkaiykuktgkyenyendaka12;
    }

    private String zrnkaiykuktgkyenkijun12;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Rn.ZRNKAIYKUKTGKYENKIJUN12)
    public String getZrnkaiykuktgkyenkijun12() {
        return zrnkaiykuktgkyenkijun12;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnkaiykuktgkyenkijun12(String pZrnkaiykuktgkyenkijun12) {
        zrnkaiykuktgkyenkijun12 = pZrnkaiykuktgkyenkijun12;
    }

    private String zrnkaiykuktgkyenyenyasu12;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Rn.ZRNKAIYKUKTGKYENYENYASU12)
    public String getZrnkaiykuktgkyenyenyasu12() {
        return zrnkaiykuktgkyenyenyasu12;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnkaiykuktgkyenyenyasu12(String pZrnkaiykuktgkyenyenyasu12) {
        zrnkaiykuktgkyenyenyasu12 = pZrnkaiykuktgkyenyenyasu12;
    }

    private String zrnkeikanensuu13;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Rn.ZRNKEIKANENSUU13)
    public String getZrnkeikanensuu13() {
        return zrnkeikanensuu13;
    }

    @Padding(mode = "left", padChar ='0', length =2)
    public void setZrnkeikanensuu13(String pZrnkeikanensuu13) {
        zrnkeikanensuu13 = pZrnkeikanensuu13;
    }

    private String zrnhrkkknmnryumukbn13;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Rn.ZRNHRKKKNMNRYUMUKBN13)
    public String getZrnhrkkknmnryumukbn13() {
        return zrnhrkkknmnryumukbn13;
    }

    public void setZrnhrkkknmnryumukbn13(String pZrnhrkkknmnryumukbn13) {
        zrnhrkkknmnryumukbn13 = pZrnhrkkknmnryumukbn13;
    }

    private String zrnzennouzndkyen13;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Rn.ZRNZENNOUZNDKYEN13)
    public String getZrnzennouzndkyen13() {
        return zrnzennouzndkyen13;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnzennouzndkyen13(String pZrnzennouzndkyen13) {
        zrnzennouzndkyen13 = pZrnzennouzndkyen13;
    }

    private String zrnzennouzndkgaika13;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Rn.ZRNZENNOUZNDKGAIKA13)
    public String getZrnzennouzndkgaika13() {
        return zrnzennouzndkgaika13;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnzennouzndkgaika13(String pZrnzennouzndkgaika13) {
        zrnzennouzndkgaika13 = pZrnzennouzndkgaika13;
    }

    private String zrnyenhrkgkgoukei13;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Rn.ZRNYENHRKGKGOUKEI13)
    public String getZrnyenhrkgkgoukei13() {
        return zrnyenhrkgkgoukei13;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnyenhrkgkgoukei13(String pZrnyenhrkgkgoukei13) {
        zrnyenhrkgkgoukei13 = pZrnyenhrkgkgoukei13;
    }

    private String zrnkihrkmp13;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Rn.ZRNKIHRKMP13)
    public String getZrnkihrkmp13() {
        return zrnkihrkmp13;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnkihrkmp13(String pZrnkihrkmp13) {
        zrnkihrkmp13 = pZrnkihrkmp13;
    }

    private String zrnw13;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Rn.ZRNW13)
    public String getZrnw13() {
        return zrnw13;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnw13(String pZrnw13) {
        zrnw13 = pZrnw13;
    }

    private String zrnwyenyendaka13;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Rn.ZRNWYENYENDAKA13)
    public String getZrnwyenyendaka13() {
        return zrnwyenyendaka13;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnwyenyendaka13(String pZrnwyenyendaka13) {
        zrnwyenyendaka13 = pZrnwyenyendaka13;
    }

    private String zrnwyenkijun13;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Rn.ZRNWYENKIJUN13)
    public String getZrnwyenkijun13() {
        return zrnwyenkijun13;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnwyenkijun13(String pZrnwyenkijun13) {
        zrnwyenkijun13 = pZrnwyenkijun13;
    }

    private String zrnwyenyenyasu13;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Rn.ZRNWYENYENYASU13)
    public String getZrnwyenyenyasu13() {
        return zrnwyenyenyasu13;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnwyenyenyasu13(String pZrnwyenyenyasu13) {
        zrnwyenyenyasu13 = pZrnwyenyenyasu13;
    }

    private String zrnkaiykuktgk13;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Rn.ZRNKAIYKUKTGK13)
    public String getZrnkaiykuktgk13() {
        return zrnkaiykuktgk13;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnkaiykuktgk13(String pZrnkaiykuktgk13) {
        zrnkaiykuktgk13 = pZrnkaiykuktgk13;
    }

    private String zrnkaiykuktgkyenyendaka13;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Rn.ZRNKAIYKUKTGKYENYENDAKA13)
    public String getZrnkaiykuktgkyenyendaka13() {
        return zrnkaiykuktgkyenyendaka13;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnkaiykuktgkyenyendaka13(String pZrnkaiykuktgkyenyendaka13) {
        zrnkaiykuktgkyenyendaka13 = pZrnkaiykuktgkyenyendaka13;
    }

    private String zrnkaiykuktgkyenkijun13;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Rn.ZRNKAIYKUKTGKYENKIJUN13)
    public String getZrnkaiykuktgkyenkijun13() {
        return zrnkaiykuktgkyenkijun13;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnkaiykuktgkyenkijun13(String pZrnkaiykuktgkyenkijun13) {
        zrnkaiykuktgkyenkijun13 = pZrnkaiykuktgkyenkijun13;
    }

    private String zrnkaiykuktgkyenyenyasu13;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Rn.ZRNKAIYKUKTGKYENYENYASU13)
    public String getZrnkaiykuktgkyenyenyasu13() {
        return zrnkaiykuktgkyenyenyasu13;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnkaiykuktgkyenyenyasu13(String pZrnkaiykuktgkyenyenyasu13) {
        zrnkaiykuktgkyenyenyasu13 = pZrnkaiykuktgkyenyenyasu13;
    }

    private String zrnkeikanensuu14;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Rn.ZRNKEIKANENSUU14)
    public String getZrnkeikanensuu14() {
        return zrnkeikanensuu14;
    }

    @Padding(mode = "left", padChar ='0', length =2)
    public void setZrnkeikanensuu14(String pZrnkeikanensuu14) {
        zrnkeikanensuu14 = pZrnkeikanensuu14;
    }

    private String zrnhrkkknmnryumukbn14;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Rn.ZRNHRKKKNMNRYUMUKBN14)
    public String getZrnhrkkknmnryumukbn14() {
        return zrnhrkkknmnryumukbn14;
    }

    public void setZrnhrkkknmnryumukbn14(String pZrnhrkkknmnryumukbn14) {
        zrnhrkkknmnryumukbn14 = pZrnhrkkknmnryumukbn14;
    }

    private String zrnzennouzndkyen14;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Rn.ZRNZENNOUZNDKYEN14)
    public String getZrnzennouzndkyen14() {
        return zrnzennouzndkyen14;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnzennouzndkyen14(String pZrnzennouzndkyen14) {
        zrnzennouzndkyen14 = pZrnzennouzndkyen14;
    }

    private String zrnzennouzndkgaika14;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Rn.ZRNZENNOUZNDKGAIKA14)
    public String getZrnzennouzndkgaika14() {
        return zrnzennouzndkgaika14;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnzennouzndkgaika14(String pZrnzennouzndkgaika14) {
        zrnzennouzndkgaika14 = pZrnzennouzndkgaika14;
    }

    private String zrnyenhrkgkgoukei14;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Rn.ZRNYENHRKGKGOUKEI14)
    public String getZrnyenhrkgkgoukei14() {
        return zrnyenhrkgkgoukei14;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnyenhrkgkgoukei14(String pZrnyenhrkgkgoukei14) {
        zrnyenhrkgkgoukei14 = pZrnyenhrkgkgoukei14;
    }

    private String zrnkihrkmp14;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Rn.ZRNKIHRKMP14)
    public String getZrnkihrkmp14() {
        return zrnkihrkmp14;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnkihrkmp14(String pZrnkihrkmp14) {
        zrnkihrkmp14 = pZrnkihrkmp14;
    }

    private String zrnw14;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Rn.ZRNW14)
    public String getZrnw14() {
        return zrnw14;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnw14(String pZrnw14) {
        zrnw14 = pZrnw14;
    }

    private String zrnwyenyendaka14;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Rn.ZRNWYENYENDAKA14)
    public String getZrnwyenyendaka14() {
        return zrnwyenyendaka14;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnwyenyendaka14(String pZrnwyenyendaka14) {
        zrnwyenyendaka14 = pZrnwyenyendaka14;
    }

    private String zrnwyenkijun14;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Rn.ZRNWYENKIJUN14)
    public String getZrnwyenkijun14() {
        return zrnwyenkijun14;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnwyenkijun14(String pZrnwyenkijun14) {
        zrnwyenkijun14 = pZrnwyenkijun14;
    }

    private String zrnwyenyenyasu14;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Rn.ZRNWYENYENYASU14)
    public String getZrnwyenyenyasu14() {
        return zrnwyenyenyasu14;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnwyenyenyasu14(String pZrnwyenyenyasu14) {
        zrnwyenyenyasu14 = pZrnwyenyenyasu14;
    }

    private String zrnkaiykuktgk14;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Rn.ZRNKAIYKUKTGK14)
    public String getZrnkaiykuktgk14() {
        return zrnkaiykuktgk14;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnkaiykuktgk14(String pZrnkaiykuktgk14) {
        zrnkaiykuktgk14 = pZrnkaiykuktgk14;
    }

    private String zrnkaiykuktgkyenyendaka14;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Rn.ZRNKAIYKUKTGKYENYENDAKA14)
    public String getZrnkaiykuktgkyenyendaka14() {
        return zrnkaiykuktgkyenyendaka14;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnkaiykuktgkyenyendaka14(String pZrnkaiykuktgkyenyendaka14) {
        zrnkaiykuktgkyenyendaka14 = pZrnkaiykuktgkyenyendaka14;
    }

    private String zrnkaiykuktgkyenkijun14;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Rn.ZRNKAIYKUKTGKYENKIJUN14)
    public String getZrnkaiykuktgkyenkijun14() {
        return zrnkaiykuktgkyenkijun14;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnkaiykuktgkyenkijun14(String pZrnkaiykuktgkyenkijun14) {
        zrnkaiykuktgkyenkijun14 = pZrnkaiykuktgkyenkijun14;
    }

    private String zrnkaiykuktgkyenyenyasu14;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Rn.ZRNKAIYKUKTGKYENYENYASU14)
    public String getZrnkaiykuktgkyenyenyasu14() {
        return zrnkaiykuktgkyenyenyasu14;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnkaiykuktgkyenyenyasu14(String pZrnkaiykuktgkyenyenyasu14) {
        zrnkaiykuktgkyenyenyasu14 = pZrnkaiykuktgkyenyenyasu14;
    }

    private String zrnkeikanensuu15;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Rn.ZRNKEIKANENSUU15)
    public String getZrnkeikanensuu15() {
        return zrnkeikanensuu15;
    }

    @Padding(mode = "left", padChar ='0', length =2)
    public void setZrnkeikanensuu15(String pZrnkeikanensuu15) {
        zrnkeikanensuu15 = pZrnkeikanensuu15;
    }

    private String zrnhrkkknmnryumukbn15;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Rn.ZRNHRKKKNMNRYUMUKBN15)
    public String getZrnhrkkknmnryumukbn15() {
        return zrnhrkkknmnryumukbn15;
    }

    public void setZrnhrkkknmnryumukbn15(String pZrnhrkkknmnryumukbn15) {
        zrnhrkkknmnryumukbn15 = pZrnhrkkknmnryumukbn15;
    }

    private String zrnzennouzndkyen15;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Rn.ZRNZENNOUZNDKYEN15)
    public String getZrnzennouzndkyen15() {
        return zrnzennouzndkyen15;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnzennouzndkyen15(String pZrnzennouzndkyen15) {
        zrnzennouzndkyen15 = pZrnzennouzndkyen15;
    }

    private String zrnzennouzndkgaika15;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Rn.ZRNZENNOUZNDKGAIKA15)
    public String getZrnzennouzndkgaika15() {
        return zrnzennouzndkgaika15;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnzennouzndkgaika15(String pZrnzennouzndkgaika15) {
        zrnzennouzndkgaika15 = pZrnzennouzndkgaika15;
    }

    private String zrnyenhrkgkgoukei15;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Rn.ZRNYENHRKGKGOUKEI15)
    public String getZrnyenhrkgkgoukei15() {
        return zrnyenhrkgkgoukei15;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnyenhrkgkgoukei15(String pZrnyenhrkgkgoukei15) {
        zrnyenhrkgkgoukei15 = pZrnyenhrkgkgoukei15;
    }

    private String zrnkihrkmp15;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Rn.ZRNKIHRKMP15)
    public String getZrnkihrkmp15() {
        return zrnkihrkmp15;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnkihrkmp15(String pZrnkihrkmp15) {
        zrnkihrkmp15 = pZrnkihrkmp15;
    }

    private String zrnw15;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Rn.ZRNW15)
    public String getZrnw15() {
        return zrnw15;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnw15(String pZrnw15) {
        zrnw15 = pZrnw15;
    }

    private String zrnwyenyendaka15;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Rn.ZRNWYENYENDAKA15)
    public String getZrnwyenyendaka15() {
        return zrnwyenyendaka15;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnwyenyendaka15(String pZrnwyenyendaka15) {
        zrnwyenyendaka15 = pZrnwyenyendaka15;
    }

    private String zrnwyenkijun15;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Rn.ZRNWYENKIJUN15)
    public String getZrnwyenkijun15() {
        return zrnwyenkijun15;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnwyenkijun15(String pZrnwyenkijun15) {
        zrnwyenkijun15 = pZrnwyenkijun15;
    }

    private String zrnwyenyenyasu15;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Rn.ZRNWYENYENYASU15)
    public String getZrnwyenyenyasu15() {
        return zrnwyenyenyasu15;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnwyenyenyasu15(String pZrnwyenyenyasu15) {
        zrnwyenyenyasu15 = pZrnwyenyenyasu15;
    }

    private String zrnkaiykuktgk15;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Rn.ZRNKAIYKUKTGK15)
    public String getZrnkaiykuktgk15() {
        return zrnkaiykuktgk15;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnkaiykuktgk15(String pZrnkaiykuktgk15) {
        zrnkaiykuktgk15 = pZrnkaiykuktgk15;
    }

    private String zrnkaiykuktgkyenyendaka15;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Rn.ZRNKAIYKUKTGKYENYENDAKA15)
    public String getZrnkaiykuktgkyenyendaka15() {
        return zrnkaiykuktgkyenyendaka15;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnkaiykuktgkyenyendaka15(String pZrnkaiykuktgkyenyendaka15) {
        zrnkaiykuktgkyenyendaka15 = pZrnkaiykuktgkyenyendaka15;
    }

    private String zrnkaiykuktgkyenkijun15;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Rn.ZRNKAIYKUKTGKYENKIJUN15)
    public String getZrnkaiykuktgkyenkijun15() {
        return zrnkaiykuktgkyenkijun15;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnkaiykuktgkyenkijun15(String pZrnkaiykuktgkyenkijun15) {
        zrnkaiykuktgkyenkijun15 = pZrnkaiykuktgkyenkijun15;
    }

    private String zrnkaiykuktgkyenyenyasu15;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Rn.ZRNKAIYKUKTGKYENYENYASU15)
    public String getZrnkaiykuktgkyenyenyasu15() {
        return zrnkaiykuktgkyenyenyasu15;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnkaiykuktgkyenyenyasu15(String pZrnkaiykuktgkyenyenyasu15) {
        zrnkaiykuktgkyenyenyasu15 = pZrnkaiykuktgkyenyenyasu15;
    }

    private String zrnkeikanensuu16;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Rn.ZRNKEIKANENSUU16)
    public String getZrnkeikanensuu16() {
        return zrnkeikanensuu16;
    }

    @Padding(mode = "left", padChar ='0', length =2)
    public void setZrnkeikanensuu16(String pZrnkeikanensuu16) {
        zrnkeikanensuu16 = pZrnkeikanensuu16;
    }

    private String zrnhrkkknmnryumukbn16;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Rn.ZRNHRKKKNMNRYUMUKBN16)
    public String getZrnhrkkknmnryumukbn16() {
        return zrnhrkkknmnryumukbn16;
    }

    public void setZrnhrkkknmnryumukbn16(String pZrnhrkkknmnryumukbn16) {
        zrnhrkkknmnryumukbn16 = pZrnhrkkknmnryumukbn16;
    }

    private String zrnzennouzndkyen16;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Rn.ZRNZENNOUZNDKYEN16)
    public String getZrnzennouzndkyen16() {
        return zrnzennouzndkyen16;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnzennouzndkyen16(String pZrnzennouzndkyen16) {
        zrnzennouzndkyen16 = pZrnzennouzndkyen16;
    }

    private String zrnzennouzndkgaika16;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Rn.ZRNZENNOUZNDKGAIKA16)
    public String getZrnzennouzndkgaika16() {
        return zrnzennouzndkgaika16;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnzennouzndkgaika16(String pZrnzennouzndkgaika16) {
        zrnzennouzndkgaika16 = pZrnzennouzndkgaika16;
    }

    private String zrnyenhrkgkgoukei16;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Rn.ZRNYENHRKGKGOUKEI16)
    public String getZrnyenhrkgkgoukei16() {
        return zrnyenhrkgkgoukei16;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnyenhrkgkgoukei16(String pZrnyenhrkgkgoukei16) {
        zrnyenhrkgkgoukei16 = pZrnyenhrkgkgoukei16;
    }

    private String zrnkihrkmp16;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Rn.ZRNKIHRKMP16)
    public String getZrnkihrkmp16() {
        return zrnkihrkmp16;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnkihrkmp16(String pZrnkihrkmp16) {
        zrnkihrkmp16 = pZrnkihrkmp16;
    }

    private String zrnw16;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Rn.ZRNW16)
    public String getZrnw16() {
        return zrnw16;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnw16(String pZrnw16) {
        zrnw16 = pZrnw16;
    }

    private String zrnwyenyendaka16;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Rn.ZRNWYENYENDAKA16)
    public String getZrnwyenyendaka16() {
        return zrnwyenyendaka16;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnwyenyendaka16(String pZrnwyenyendaka16) {
        zrnwyenyendaka16 = pZrnwyenyendaka16;
    }

    private String zrnwyenkijun16;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Rn.ZRNWYENKIJUN16)
    public String getZrnwyenkijun16() {
        return zrnwyenkijun16;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnwyenkijun16(String pZrnwyenkijun16) {
        zrnwyenkijun16 = pZrnwyenkijun16;
    }

    private String zrnwyenyenyasu16;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Rn.ZRNWYENYENYASU16)
    public String getZrnwyenyenyasu16() {
        return zrnwyenyenyasu16;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnwyenyenyasu16(String pZrnwyenyenyasu16) {
        zrnwyenyenyasu16 = pZrnwyenyenyasu16;
    }

    private String zrnkaiykuktgk16;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Rn.ZRNKAIYKUKTGK16)
    public String getZrnkaiykuktgk16() {
        return zrnkaiykuktgk16;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnkaiykuktgk16(String pZrnkaiykuktgk16) {
        zrnkaiykuktgk16 = pZrnkaiykuktgk16;
    }

    private String zrnkaiykuktgkyenyendaka16;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Rn.ZRNKAIYKUKTGKYENYENDAKA16)
    public String getZrnkaiykuktgkyenyendaka16() {
        return zrnkaiykuktgkyenyendaka16;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnkaiykuktgkyenyendaka16(String pZrnkaiykuktgkyenyendaka16) {
        zrnkaiykuktgkyenyendaka16 = pZrnkaiykuktgkyenyendaka16;
    }

    private String zrnkaiykuktgkyenkijun16;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Rn.ZRNKAIYKUKTGKYENKIJUN16)
    public String getZrnkaiykuktgkyenkijun16() {
        return zrnkaiykuktgkyenkijun16;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnkaiykuktgkyenkijun16(String pZrnkaiykuktgkyenkijun16) {
        zrnkaiykuktgkyenkijun16 = pZrnkaiykuktgkyenkijun16;
    }

    private String zrnkaiykuktgkyenyenyasu16;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Rn.ZRNKAIYKUKTGKYENYENYASU16)
    public String getZrnkaiykuktgkyenyenyasu16() {
        return zrnkaiykuktgkyenyenyasu16;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnkaiykuktgkyenyenyasu16(String pZrnkaiykuktgkyenyenyasu16) {
        zrnkaiykuktgkyenyenyasu16 = pZrnkaiykuktgkyenyenyasu16;
    }

    private String zrnkeikanensuu17;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Rn.ZRNKEIKANENSUU17)
    public String getZrnkeikanensuu17() {
        return zrnkeikanensuu17;
    }

    @Padding(mode = "left", padChar ='0', length =2)
    public void setZrnkeikanensuu17(String pZrnkeikanensuu17) {
        zrnkeikanensuu17 = pZrnkeikanensuu17;
    }

    private String zrnhrkkknmnryumukbn17;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Rn.ZRNHRKKKNMNRYUMUKBN17)
    public String getZrnhrkkknmnryumukbn17() {
        return zrnhrkkknmnryumukbn17;
    }

    public void setZrnhrkkknmnryumukbn17(String pZrnhrkkknmnryumukbn17) {
        zrnhrkkknmnryumukbn17 = pZrnhrkkknmnryumukbn17;
    }

    private String zrnzennouzndkyen17;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Rn.ZRNZENNOUZNDKYEN17)
    public String getZrnzennouzndkyen17() {
        return zrnzennouzndkyen17;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnzennouzndkyen17(String pZrnzennouzndkyen17) {
        zrnzennouzndkyen17 = pZrnzennouzndkyen17;
    }

    private String zrnzennouzndkgaika17;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Rn.ZRNZENNOUZNDKGAIKA17)
    public String getZrnzennouzndkgaika17() {
        return zrnzennouzndkgaika17;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnzennouzndkgaika17(String pZrnzennouzndkgaika17) {
        zrnzennouzndkgaika17 = pZrnzennouzndkgaika17;
    }

    private String zrnyenhrkgkgoukei17;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Rn.ZRNYENHRKGKGOUKEI17)
    public String getZrnyenhrkgkgoukei17() {
        return zrnyenhrkgkgoukei17;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnyenhrkgkgoukei17(String pZrnyenhrkgkgoukei17) {
        zrnyenhrkgkgoukei17 = pZrnyenhrkgkgoukei17;
    }

    private String zrnkihrkmp17;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Rn.ZRNKIHRKMP17)
    public String getZrnkihrkmp17() {
        return zrnkihrkmp17;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnkihrkmp17(String pZrnkihrkmp17) {
        zrnkihrkmp17 = pZrnkihrkmp17;
    }

    private String zrnw17;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Rn.ZRNW17)
    public String getZrnw17() {
        return zrnw17;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnw17(String pZrnw17) {
        zrnw17 = pZrnw17;
    }

    private String zrnwyenyendaka17;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Rn.ZRNWYENYENDAKA17)
    public String getZrnwyenyendaka17() {
        return zrnwyenyendaka17;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnwyenyendaka17(String pZrnwyenyendaka17) {
        zrnwyenyendaka17 = pZrnwyenyendaka17;
    }

    private String zrnwyenkijun17;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Rn.ZRNWYENKIJUN17)
    public String getZrnwyenkijun17() {
        return zrnwyenkijun17;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnwyenkijun17(String pZrnwyenkijun17) {
        zrnwyenkijun17 = pZrnwyenkijun17;
    }

    private String zrnwyenyenyasu17;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Rn.ZRNWYENYENYASU17)
    public String getZrnwyenyenyasu17() {
        return zrnwyenyenyasu17;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnwyenyenyasu17(String pZrnwyenyenyasu17) {
        zrnwyenyenyasu17 = pZrnwyenyenyasu17;
    }

    private String zrnkaiykuktgk17;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Rn.ZRNKAIYKUKTGK17)
    public String getZrnkaiykuktgk17() {
        return zrnkaiykuktgk17;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnkaiykuktgk17(String pZrnkaiykuktgk17) {
        zrnkaiykuktgk17 = pZrnkaiykuktgk17;
    }

    private String zrnkaiykuktgkyenyendaka17;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Rn.ZRNKAIYKUKTGKYENYENDAKA17)
    public String getZrnkaiykuktgkyenyendaka17() {
        return zrnkaiykuktgkyenyendaka17;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnkaiykuktgkyenyendaka17(String pZrnkaiykuktgkyenyendaka17) {
        zrnkaiykuktgkyenyendaka17 = pZrnkaiykuktgkyenyendaka17;
    }

    private String zrnkaiykuktgkyenkijun17;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Rn.ZRNKAIYKUKTGKYENKIJUN17)
    public String getZrnkaiykuktgkyenkijun17() {
        return zrnkaiykuktgkyenkijun17;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnkaiykuktgkyenkijun17(String pZrnkaiykuktgkyenkijun17) {
        zrnkaiykuktgkyenkijun17 = pZrnkaiykuktgkyenkijun17;
    }

    private String zrnkaiykuktgkyenyenyasu17;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Rn.ZRNKAIYKUKTGKYENYENYASU17)
    public String getZrnkaiykuktgkyenyenyasu17() {
        return zrnkaiykuktgkyenyenyasu17;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnkaiykuktgkyenyenyasu17(String pZrnkaiykuktgkyenyenyasu17) {
        zrnkaiykuktgkyenyenyasu17 = pZrnkaiykuktgkyenyenyasu17;
    }

    private String zrnkeikanensuu18;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Rn.ZRNKEIKANENSUU18)
    public String getZrnkeikanensuu18() {
        return zrnkeikanensuu18;
    }

    @Padding(mode = "left", padChar ='0', length =2)
    public void setZrnkeikanensuu18(String pZrnkeikanensuu18) {
        zrnkeikanensuu18 = pZrnkeikanensuu18;
    }

    private String zrnhrkkknmnryumukbn18;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Rn.ZRNHRKKKNMNRYUMUKBN18)
    public String getZrnhrkkknmnryumukbn18() {
        return zrnhrkkknmnryumukbn18;
    }

    public void setZrnhrkkknmnryumukbn18(String pZrnhrkkknmnryumukbn18) {
        zrnhrkkknmnryumukbn18 = pZrnhrkkknmnryumukbn18;
    }

    private String zrnzennouzndkyen18;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Rn.ZRNZENNOUZNDKYEN18)
    public String getZrnzennouzndkyen18() {
        return zrnzennouzndkyen18;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnzennouzndkyen18(String pZrnzennouzndkyen18) {
        zrnzennouzndkyen18 = pZrnzennouzndkyen18;
    }

    private String zrnzennouzndkgaika18;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Rn.ZRNZENNOUZNDKGAIKA18)
    public String getZrnzennouzndkgaika18() {
        return zrnzennouzndkgaika18;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnzennouzndkgaika18(String pZrnzennouzndkgaika18) {
        zrnzennouzndkgaika18 = pZrnzennouzndkgaika18;
    }

    private String zrnyenhrkgkgoukei18;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Rn.ZRNYENHRKGKGOUKEI18)
    public String getZrnyenhrkgkgoukei18() {
        return zrnyenhrkgkgoukei18;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnyenhrkgkgoukei18(String pZrnyenhrkgkgoukei18) {
        zrnyenhrkgkgoukei18 = pZrnyenhrkgkgoukei18;
    }

    private String zrnkihrkmp18;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Rn.ZRNKIHRKMP18)
    public String getZrnkihrkmp18() {
        return zrnkihrkmp18;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnkihrkmp18(String pZrnkihrkmp18) {
        zrnkihrkmp18 = pZrnkihrkmp18;
    }

    private String zrnw18;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Rn.ZRNW18)
    public String getZrnw18() {
        return zrnw18;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnw18(String pZrnw18) {
        zrnw18 = pZrnw18;
    }

    private String zrnwyenyendaka18;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Rn.ZRNWYENYENDAKA18)
    public String getZrnwyenyendaka18() {
        return zrnwyenyendaka18;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnwyenyendaka18(String pZrnwyenyendaka18) {
        zrnwyenyendaka18 = pZrnwyenyendaka18;
    }

    private String zrnwyenkijun18;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Rn.ZRNWYENKIJUN18)
    public String getZrnwyenkijun18() {
        return zrnwyenkijun18;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnwyenkijun18(String pZrnwyenkijun18) {
        zrnwyenkijun18 = pZrnwyenkijun18;
    }

    private String zrnwyenyenyasu18;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Rn.ZRNWYENYENYASU18)
    public String getZrnwyenyenyasu18() {
        return zrnwyenyenyasu18;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnwyenyenyasu18(String pZrnwyenyenyasu18) {
        zrnwyenyenyasu18 = pZrnwyenyenyasu18;
    }

    private String zrnkaiykuktgk18;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Rn.ZRNKAIYKUKTGK18)
    public String getZrnkaiykuktgk18() {
        return zrnkaiykuktgk18;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnkaiykuktgk18(String pZrnkaiykuktgk18) {
        zrnkaiykuktgk18 = pZrnkaiykuktgk18;
    }

    private String zrnkaiykuktgkyenyendaka18;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Rn.ZRNKAIYKUKTGKYENYENDAKA18)
    public String getZrnkaiykuktgkyenyendaka18() {
        return zrnkaiykuktgkyenyendaka18;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnkaiykuktgkyenyendaka18(String pZrnkaiykuktgkyenyendaka18) {
        zrnkaiykuktgkyenyendaka18 = pZrnkaiykuktgkyenyendaka18;
    }

    private String zrnkaiykuktgkyenkijun18;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Rn.ZRNKAIYKUKTGKYENKIJUN18)
    public String getZrnkaiykuktgkyenkijun18() {
        return zrnkaiykuktgkyenkijun18;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnkaiykuktgkyenkijun18(String pZrnkaiykuktgkyenkijun18) {
        zrnkaiykuktgkyenkijun18 = pZrnkaiykuktgkyenkijun18;
    }

    private String zrnkaiykuktgkyenyenyasu18;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Rn.ZRNKAIYKUKTGKYENYENYASU18)
    public String getZrnkaiykuktgkyenyenyasu18() {
        return zrnkaiykuktgkyenyenyasu18;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnkaiykuktgkyenyenyasu18(String pZrnkaiykuktgkyenyenyasu18) {
        zrnkaiykuktgkyenyenyasu18 = pZrnkaiykuktgkyenyenyasu18;
    }

    private String zrnkeikanensuu19;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Rn.ZRNKEIKANENSUU19)
    public String getZrnkeikanensuu19() {
        return zrnkeikanensuu19;
    }

    @Padding(mode = "left", padChar ='0', length =2)
    public void setZrnkeikanensuu19(String pZrnkeikanensuu19) {
        zrnkeikanensuu19 = pZrnkeikanensuu19;
    }

    private String zrnhrkkknmnryumukbn19;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Rn.ZRNHRKKKNMNRYUMUKBN19)
    public String getZrnhrkkknmnryumukbn19() {
        return zrnhrkkknmnryumukbn19;
    }

    public void setZrnhrkkknmnryumukbn19(String pZrnhrkkknmnryumukbn19) {
        zrnhrkkknmnryumukbn19 = pZrnhrkkknmnryumukbn19;
    }

    private String zrnzennouzndkyen19;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Rn.ZRNZENNOUZNDKYEN19)
    public String getZrnzennouzndkyen19() {
        return zrnzennouzndkyen19;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnzennouzndkyen19(String pZrnzennouzndkyen19) {
        zrnzennouzndkyen19 = pZrnzennouzndkyen19;
    }

    private String zrnzennouzndkgaika19;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Rn.ZRNZENNOUZNDKGAIKA19)
    public String getZrnzennouzndkgaika19() {
        return zrnzennouzndkgaika19;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnzennouzndkgaika19(String pZrnzennouzndkgaika19) {
        zrnzennouzndkgaika19 = pZrnzennouzndkgaika19;
    }

    private String zrnyenhrkgkgoukei19;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Rn.ZRNYENHRKGKGOUKEI19)
    public String getZrnyenhrkgkgoukei19() {
        return zrnyenhrkgkgoukei19;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnyenhrkgkgoukei19(String pZrnyenhrkgkgoukei19) {
        zrnyenhrkgkgoukei19 = pZrnyenhrkgkgoukei19;
    }

    private String zrnkihrkmp19;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Rn.ZRNKIHRKMP19)
    public String getZrnkihrkmp19() {
        return zrnkihrkmp19;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnkihrkmp19(String pZrnkihrkmp19) {
        zrnkihrkmp19 = pZrnkihrkmp19;
    }

    private String zrnw19;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Rn.ZRNW19)
    public String getZrnw19() {
        return zrnw19;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnw19(String pZrnw19) {
        zrnw19 = pZrnw19;
    }

    private String zrnwyenyendaka19;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Rn.ZRNWYENYENDAKA19)
    public String getZrnwyenyendaka19() {
        return zrnwyenyendaka19;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnwyenyendaka19(String pZrnwyenyendaka19) {
        zrnwyenyendaka19 = pZrnwyenyendaka19;
    }

    private String zrnwyenkijun19;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Rn.ZRNWYENKIJUN19)
    public String getZrnwyenkijun19() {
        return zrnwyenkijun19;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnwyenkijun19(String pZrnwyenkijun19) {
        zrnwyenkijun19 = pZrnwyenkijun19;
    }

    private String zrnwyenyenyasu19;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Rn.ZRNWYENYENYASU19)
    public String getZrnwyenyenyasu19() {
        return zrnwyenyenyasu19;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnwyenyenyasu19(String pZrnwyenyenyasu19) {
        zrnwyenyenyasu19 = pZrnwyenyenyasu19;
    }

    private String zrnkaiykuktgk19;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Rn.ZRNKAIYKUKTGK19)
    public String getZrnkaiykuktgk19() {
        return zrnkaiykuktgk19;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnkaiykuktgk19(String pZrnkaiykuktgk19) {
        zrnkaiykuktgk19 = pZrnkaiykuktgk19;
    }

    private String zrnkaiykuktgkyenyendaka19;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Rn.ZRNKAIYKUKTGKYENYENDAKA19)
    public String getZrnkaiykuktgkyenyendaka19() {
        return zrnkaiykuktgkyenyendaka19;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnkaiykuktgkyenyendaka19(String pZrnkaiykuktgkyenyendaka19) {
        zrnkaiykuktgkyenyendaka19 = pZrnkaiykuktgkyenyendaka19;
    }

    private String zrnkaiykuktgkyenkijun19;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Rn.ZRNKAIYKUKTGKYENKIJUN19)
    public String getZrnkaiykuktgkyenkijun19() {
        return zrnkaiykuktgkyenkijun19;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnkaiykuktgkyenkijun19(String pZrnkaiykuktgkyenkijun19) {
        zrnkaiykuktgkyenkijun19 = pZrnkaiykuktgkyenkijun19;
    }

    private String zrnkaiykuktgkyenyenyasu19;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Rn.ZRNKAIYKUKTGKYENYENYASU19)
    public String getZrnkaiykuktgkyenyenyasu19() {
        return zrnkaiykuktgkyenyenyasu19;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnkaiykuktgkyenyenyasu19(String pZrnkaiykuktgkyenyenyasu19) {
        zrnkaiykuktgkyenyenyasu19 = pZrnkaiykuktgkyenyenyasu19;
    }

    private String zrnkeikanensuu20;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Rn.ZRNKEIKANENSUU20)
    public String getZrnkeikanensuu20() {
        return zrnkeikanensuu20;
    }

    @Padding(mode = "left", padChar ='0', length =2)
    public void setZrnkeikanensuu20(String pZrnkeikanensuu20) {
        zrnkeikanensuu20 = pZrnkeikanensuu20;
    }

    private String zrnhrkkknmnryumukbn20;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Rn.ZRNHRKKKNMNRYUMUKBN20)
    public String getZrnhrkkknmnryumukbn20() {
        return zrnhrkkknmnryumukbn20;
    }

    public void setZrnhrkkknmnryumukbn20(String pZrnhrkkknmnryumukbn20) {
        zrnhrkkknmnryumukbn20 = pZrnhrkkknmnryumukbn20;
    }

    private String zrnzennouzndkyen20;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Rn.ZRNZENNOUZNDKYEN20)
    public String getZrnzennouzndkyen20() {
        return zrnzennouzndkyen20;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnzennouzndkyen20(String pZrnzennouzndkyen20) {
        zrnzennouzndkyen20 = pZrnzennouzndkyen20;
    }

    private String zrnzennouzndkgaika20;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Rn.ZRNZENNOUZNDKGAIKA20)
    public String getZrnzennouzndkgaika20() {
        return zrnzennouzndkgaika20;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnzennouzndkgaika20(String pZrnzennouzndkgaika20) {
        zrnzennouzndkgaika20 = pZrnzennouzndkgaika20;
    }

    private String zrnyenhrkgkgoukei20;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Rn.ZRNYENHRKGKGOUKEI20)
    public String getZrnyenhrkgkgoukei20() {
        return zrnyenhrkgkgoukei20;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnyenhrkgkgoukei20(String pZrnyenhrkgkgoukei20) {
        zrnyenhrkgkgoukei20 = pZrnyenhrkgkgoukei20;
    }

    private String zrnkihrkmp20;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Rn.ZRNKIHRKMP20)
    public String getZrnkihrkmp20() {
        return zrnkihrkmp20;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnkihrkmp20(String pZrnkihrkmp20) {
        zrnkihrkmp20 = pZrnkihrkmp20;
    }

    private String zrnw20;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Rn.ZRNW20)
    public String getZrnw20() {
        return zrnw20;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnw20(String pZrnw20) {
        zrnw20 = pZrnw20;
    }

    private String zrnwyenyendaka20;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Rn.ZRNWYENYENDAKA20)
    public String getZrnwyenyendaka20() {
        return zrnwyenyendaka20;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnwyenyendaka20(String pZrnwyenyendaka20) {
        zrnwyenyendaka20 = pZrnwyenyendaka20;
    }

    private String zrnwyenkijun20;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Rn.ZRNWYENKIJUN20)
    public String getZrnwyenkijun20() {
        return zrnwyenkijun20;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnwyenkijun20(String pZrnwyenkijun20) {
        zrnwyenkijun20 = pZrnwyenkijun20;
    }

    private String zrnwyenyenyasu20;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Rn.ZRNWYENYENYASU20)
    public String getZrnwyenyenyasu20() {
        return zrnwyenyenyasu20;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnwyenyenyasu20(String pZrnwyenyenyasu20) {
        zrnwyenyenyasu20 = pZrnwyenyenyasu20;
    }

    private String zrnkaiykuktgk20;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Rn.ZRNKAIYKUKTGK20)
    public String getZrnkaiykuktgk20() {
        return zrnkaiykuktgk20;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnkaiykuktgk20(String pZrnkaiykuktgk20) {
        zrnkaiykuktgk20 = pZrnkaiykuktgk20;
    }

    private String zrnkaiykuktgkyenyendaka20;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Rn.ZRNKAIYKUKTGKYENYENDAKA20)
    public String getZrnkaiykuktgkyenyendaka20() {
        return zrnkaiykuktgkyenyendaka20;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnkaiykuktgkyenyendaka20(String pZrnkaiykuktgkyenyendaka20) {
        zrnkaiykuktgkyenyendaka20 = pZrnkaiykuktgkyenyendaka20;
    }

    private String zrnkaiykuktgkyenkijun20;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Rn.ZRNKAIYKUKTGKYENKIJUN20)
    public String getZrnkaiykuktgkyenkijun20() {
        return zrnkaiykuktgkyenkijun20;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnkaiykuktgkyenkijun20(String pZrnkaiykuktgkyenkijun20) {
        zrnkaiykuktgkyenkijun20 = pZrnkaiykuktgkyenkijun20;
    }

    private String zrnkaiykuktgkyenyenyasu20;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Rn.ZRNKAIYKUKTGKYENYENYASU20)
    public String getZrnkaiykuktgkyenyenyasu20() {
        return zrnkaiykuktgkyenyenyasu20;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnkaiykuktgkyenyenyasu20(String pZrnkaiykuktgkyenyenyasu20) {
        zrnkaiykuktgkyenyenyasu20 = pZrnkaiykuktgkyenyenyasu20;
    }

    private String zrnkeikanensuu21;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Rn.ZRNKEIKANENSUU21)
    public String getZrnkeikanensuu21() {
        return zrnkeikanensuu21;
    }

    @Padding(mode = "left", padChar ='0', length =2)
    public void setZrnkeikanensuu21(String pZrnkeikanensuu21) {
        zrnkeikanensuu21 = pZrnkeikanensuu21;
    }

    private String zrnhrkkknmnryumukbn21;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Rn.ZRNHRKKKNMNRYUMUKBN21)
    public String getZrnhrkkknmnryumukbn21() {
        return zrnhrkkknmnryumukbn21;
    }

    public void setZrnhrkkknmnryumukbn21(String pZrnhrkkknmnryumukbn21) {
        zrnhrkkknmnryumukbn21 = pZrnhrkkknmnryumukbn21;
    }

    private String zrnzennouzndkyen21;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Rn.ZRNZENNOUZNDKYEN21)
    public String getZrnzennouzndkyen21() {
        return zrnzennouzndkyen21;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnzennouzndkyen21(String pZrnzennouzndkyen21) {
        zrnzennouzndkyen21 = pZrnzennouzndkyen21;
    }

    private String zrnzennouzndkgaika21;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Rn.ZRNZENNOUZNDKGAIKA21)
    public String getZrnzennouzndkgaika21() {
        return zrnzennouzndkgaika21;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnzennouzndkgaika21(String pZrnzennouzndkgaika21) {
        zrnzennouzndkgaika21 = pZrnzennouzndkgaika21;
    }

    private String zrnyenhrkgkgoukei21;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Rn.ZRNYENHRKGKGOUKEI21)
    public String getZrnyenhrkgkgoukei21() {
        return zrnyenhrkgkgoukei21;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnyenhrkgkgoukei21(String pZrnyenhrkgkgoukei21) {
        zrnyenhrkgkgoukei21 = pZrnyenhrkgkgoukei21;
    }

    private String zrnkihrkmp21;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Rn.ZRNKIHRKMP21)
    public String getZrnkihrkmp21() {
        return zrnkihrkmp21;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnkihrkmp21(String pZrnkihrkmp21) {
        zrnkihrkmp21 = pZrnkihrkmp21;
    }

    private String zrnw21;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Rn.ZRNW21)
    public String getZrnw21() {
        return zrnw21;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnw21(String pZrnw21) {
        zrnw21 = pZrnw21;
    }

    private String zrnwyenyendaka21;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Rn.ZRNWYENYENDAKA21)
    public String getZrnwyenyendaka21() {
        return zrnwyenyendaka21;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnwyenyendaka21(String pZrnwyenyendaka21) {
        zrnwyenyendaka21 = pZrnwyenyendaka21;
    }

    private String zrnwyenkijun21;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Rn.ZRNWYENKIJUN21)
    public String getZrnwyenkijun21() {
        return zrnwyenkijun21;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnwyenkijun21(String pZrnwyenkijun21) {
        zrnwyenkijun21 = pZrnwyenkijun21;
    }

    private String zrnwyenyenyasu21;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Rn.ZRNWYENYENYASU21)
    public String getZrnwyenyenyasu21() {
        return zrnwyenyenyasu21;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnwyenyenyasu21(String pZrnwyenyenyasu21) {
        zrnwyenyenyasu21 = pZrnwyenyenyasu21;
    }

    private String zrnkaiykuktgk21;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Rn.ZRNKAIYKUKTGK21)
    public String getZrnkaiykuktgk21() {
        return zrnkaiykuktgk21;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnkaiykuktgk21(String pZrnkaiykuktgk21) {
        zrnkaiykuktgk21 = pZrnkaiykuktgk21;
    }

    private String zrnkaiykuktgkyenyendaka21;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Rn.ZRNKAIYKUKTGKYENYENDAKA21)
    public String getZrnkaiykuktgkyenyendaka21() {
        return zrnkaiykuktgkyenyendaka21;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnkaiykuktgkyenyendaka21(String pZrnkaiykuktgkyenyendaka21) {
        zrnkaiykuktgkyenyendaka21 = pZrnkaiykuktgkyenyendaka21;
    }

    private String zrnkaiykuktgkyenkijun21;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Rn.ZRNKAIYKUKTGKYENKIJUN21)
    public String getZrnkaiykuktgkyenkijun21() {
        return zrnkaiykuktgkyenkijun21;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnkaiykuktgkyenkijun21(String pZrnkaiykuktgkyenkijun21) {
        zrnkaiykuktgkyenkijun21 = pZrnkaiykuktgkyenkijun21;
    }

    private String zrnkaiykuktgkyenyenyasu21;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Rn.ZRNKAIYKUKTGKYENYENYASU21)
    public String getZrnkaiykuktgkyenyenyasu21() {
        return zrnkaiykuktgkyenyenyasu21;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnkaiykuktgkyenyenyasu21(String pZrnkaiykuktgkyenyenyasu21) {
        zrnkaiykuktgkyenyenyasu21 = pZrnkaiykuktgkyenyenyasu21;
    }

    private String zrnkeikanensuu22;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Rn.ZRNKEIKANENSUU22)
    public String getZrnkeikanensuu22() {
        return zrnkeikanensuu22;
    }

    @Padding(mode = "left", padChar ='0', length =2)
    public void setZrnkeikanensuu22(String pZrnkeikanensuu22) {
        zrnkeikanensuu22 = pZrnkeikanensuu22;
    }

    private String zrnhrkkknmnryumukbn22;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Rn.ZRNHRKKKNMNRYUMUKBN22)
    public String getZrnhrkkknmnryumukbn22() {
        return zrnhrkkknmnryumukbn22;
    }

    public void setZrnhrkkknmnryumukbn22(String pZrnhrkkknmnryumukbn22) {
        zrnhrkkknmnryumukbn22 = pZrnhrkkknmnryumukbn22;
    }

    private String zrnzennouzndkyen22;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Rn.ZRNZENNOUZNDKYEN22)
    public String getZrnzennouzndkyen22() {
        return zrnzennouzndkyen22;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnzennouzndkyen22(String pZrnzennouzndkyen22) {
        zrnzennouzndkyen22 = pZrnzennouzndkyen22;
    }

    private String zrnzennouzndkgaika22;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Rn.ZRNZENNOUZNDKGAIKA22)
    public String getZrnzennouzndkgaika22() {
        return zrnzennouzndkgaika22;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnzennouzndkgaika22(String pZrnzennouzndkgaika22) {
        zrnzennouzndkgaika22 = pZrnzennouzndkgaika22;
    }

    private String zrnyenhrkgkgoukei22;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Rn.ZRNYENHRKGKGOUKEI22)
    public String getZrnyenhrkgkgoukei22() {
        return zrnyenhrkgkgoukei22;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnyenhrkgkgoukei22(String pZrnyenhrkgkgoukei22) {
        zrnyenhrkgkgoukei22 = pZrnyenhrkgkgoukei22;
    }

    private String zrnkihrkmp22;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Rn.ZRNKIHRKMP22)
    public String getZrnkihrkmp22() {
        return zrnkihrkmp22;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnkihrkmp22(String pZrnkihrkmp22) {
        zrnkihrkmp22 = pZrnkihrkmp22;
    }

    private String zrnw22;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Rn.ZRNW22)
    public String getZrnw22() {
        return zrnw22;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnw22(String pZrnw22) {
        zrnw22 = pZrnw22;
    }

    private String zrnwyenyendaka22;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Rn.ZRNWYENYENDAKA22)
    public String getZrnwyenyendaka22() {
        return zrnwyenyendaka22;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnwyenyendaka22(String pZrnwyenyendaka22) {
        zrnwyenyendaka22 = pZrnwyenyendaka22;
    }

    private String zrnwyenkijun22;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Rn.ZRNWYENKIJUN22)
    public String getZrnwyenkijun22() {
        return zrnwyenkijun22;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnwyenkijun22(String pZrnwyenkijun22) {
        zrnwyenkijun22 = pZrnwyenkijun22;
    }

    private String zrnwyenyenyasu22;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Rn.ZRNWYENYENYASU22)
    public String getZrnwyenyenyasu22() {
        return zrnwyenyenyasu22;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnwyenyenyasu22(String pZrnwyenyenyasu22) {
        zrnwyenyenyasu22 = pZrnwyenyenyasu22;
    }

    private String zrnkaiykuktgk22;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Rn.ZRNKAIYKUKTGK22)
    public String getZrnkaiykuktgk22() {
        return zrnkaiykuktgk22;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnkaiykuktgk22(String pZrnkaiykuktgk22) {
        zrnkaiykuktgk22 = pZrnkaiykuktgk22;
    }

    private String zrnkaiykuktgkyenyendaka22;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Rn.ZRNKAIYKUKTGKYENYENDAKA22)
    public String getZrnkaiykuktgkyenyendaka22() {
        return zrnkaiykuktgkyenyendaka22;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnkaiykuktgkyenyendaka22(String pZrnkaiykuktgkyenyendaka22) {
        zrnkaiykuktgkyenyendaka22 = pZrnkaiykuktgkyenyendaka22;
    }

    private String zrnkaiykuktgkyenkijun22;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Rn.ZRNKAIYKUKTGKYENKIJUN22)
    public String getZrnkaiykuktgkyenkijun22() {
        return zrnkaiykuktgkyenkijun22;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnkaiykuktgkyenkijun22(String pZrnkaiykuktgkyenkijun22) {
        zrnkaiykuktgkyenkijun22 = pZrnkaiykuktgkyenkijun22;
    }

    private String zrnkaiykuktgkyenyenyasu22;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Rn.ZRNKAIYKUKTGKYENYENYASU22)
    public String getZrnkaiykuktgkyenyenyasu22() {
        return zrnkaiykuktgkyenyenyasu22;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnkaiykuktgkyenyenyasu22(String pZrnkaiykuktgkyenyenyasu22) {
        zrnkaiykuktgkyenyenyasu22 = pZrnkaiykuktgkyenyenyasu22;
    }

    private String zrnyobiv196;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Rn.ZRNYOBIV196)
    public String getZrnyobiv196() {
        return zrnyobiv196;
    }

    public void setZrnyobiv196(String pZrnyobiv196) {
        zrnyobiv196 = pZrnyobiv196;
    }

    private String zrnyobiv4;

    @Column(name=GenZT_SinkeiyakuSyoukenSuii2Rn.ZRNYOBIV4)
    public String getZrnyobiv4() {
        return zrnyobiv4;
    }

    public void setZrnyobiv4(String pZrnyobiv4) {
        zrnyobiv4 = pZrnyobiv4;
    }
}