
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 処理結果区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_SyorikekkaKbn</td><td colspan="3">処理結果区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="43">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TENSOU}</td><td>&quot;110&quot;</td><td>転送</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TENSOU_TENKEN_1}</td><td>&quot;121&quot;</td><td>転送（点検（１次））</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TENSOU_TENKEN_2}</td><td>&quot;122&quot;</td><td>転送（点検（２次））</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TENSOU_TENKEN_HUBI}</td><td>&quot;124&quot;</td><td>転送（点検（点検後不備））</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TENSOU_KANKYOU_1}</td><td>&quot;131&quot;</td><td>転送（環境（１次））</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TENSOU_KANKYOU_2A}</td><td>&quot;132&quot;</td><td>転送（環境（２次Ａ））</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TENSOU_KANKYOU_2B}</td><td>&quot;133&quot;</td><td>転送（環境（２次Ｂ））</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TENSOU_IMU_KANIUW}</td><td>&quot;141&quot;</td><td>転送（医務（簡易ＵＷ））</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TENSOU_IMU_KANIMD}</td><td>&quot;142&quot;</td><td>転送（医務（簡易ＭＤ））</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TENSOU_MOSTORIKESI}</td><td>&quot;170&quot;</td><td>転送（取消）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SASIMODOSI}</td><td>&quot;210&quot;</td><td>差戻し</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #IRAI_TENKEN_1}</td><td>&quot;321&quot;</td><td>依頼（点検（１次））</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #IRAI_TENKEN_2}</td><td>&quot;322&quot;</td><td>依頼（点検（２次））</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #IRAI_TENKEN_3}</td><td>&quot;323&quot;</td><td>依頼（点検（３次））</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #IRAI_TENKEN_HUBI}</td><td>&quot;324&quot;</td><td>依頼（点検（点検後不備））</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #IRAI_KANKYOU_1}</td><td>&quot;331&quot;</td><td>依頼（環境（１次））</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #IRAI_KANKYOU_2A}</td><td>&quot;332&quot;</td><td>依頼（環境（２次Ａ））</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #IRAI_KANKYOU_2B}</td><td>&quot;333&quot;</td><td>依頼（環境（２次Ｂ））</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #IRAI_IMU_KANIUW}</td><td>&quot;341&quot;</td><td>依頼（医務（簡易ＵＷ））</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #IRAI_IMU_KANIMD}</td><td>&quot;342&quot;</td><td>依頼（医務（簡易ＭＤ））</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HORYUU}</td><td>&quot;410&quot;</td><td>保留</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HUBI}</td><td>&quot;510&quot;</td><td>不備</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HUBITYUUSI}</td><td>&quot;520&quot;</td><td>不備処理中止</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KAITOUMATI}</td><td>&quot;530&quot;</td><td>回答待ち</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HUBIKAISYOU}</td><td>&quot;540&quot;</td><td>不備解消</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KAKUNIN}</td><td>&quot;610&quot;</td><td>確認登録</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TYUUKANKAKUNIN}</td><td>&quot;620&quot;</td><td>中間確認</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TUIKAKAKUNIN}</td><td>&quot;630&quot;</td><td>追加確認</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KAKUNINKAISYOU}</td><td>&quot;640&quot;</td><td>確認解消</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HUBIKANRI}</td><td>&quot;650&quot;</td><td>不備管理中</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SATEI_3}</td><td>&quot;660&quot;</td><td>査定３次</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SATEI_4}</td><td>&quot;670&quot;</td><td>査定４次</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SATEI_SIJI}</td><td>&quot;680&quot;</td><td>査定指示</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KOUZAKAKUNIN}</td><td>&quot;690&quot;</td><td>口座確認等</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KANRYOU}</td><td>&quot;910&quot;</td><td>完了</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SYOUNIN}</td><td>&quot;920&quot;</td><td>承認</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HUSYOUNIN}</td><td>&quot;930&quot;</td><td>不承認</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SIHARAI}</td><td>&quot;940&quot;</td><td>支払</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HUSIHARAI}</td><td>&quot;950&quot;</td><td>非該当</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TORIKESI}</td><td>&quot;960&quot;</td><td>受付取消</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SIBOUS_SAIGAIHIGAITOU}</td><td>&quot;970&quot;</td><td>死亡S支払・災害非該当</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KANRYOU_SYOUNINMATI}</td><td>&quot;980&quot;</td><td>完了（承認待ち）</td></tr>
 *  <tr><td rowspan="11">{@link #PATTERN_NENKIN NENKIN}<br />(年金)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KANRYOU}</td><td>&quot;910&quot;</td><td>完了</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SYOUNIN}</td><td>&quot;920&quot;</td><td>承認</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HUSYOUNIN}</td><td>&quot;930&quot;</td><td>不承認</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HUBI}</td><td>&quot;510&quot;</td><td>不備</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HORYUU}</td><td>&quot;410&quot;</td><td>保留</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SASIMODOSI}</td><td>&quot;210&quot;</td><td>差戻し</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TORIKESI}</td><td>&quot;960&quot;</td><td>受付取消</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TENSOU}</td><td>&quot;110&quot;</td><td>転送</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HUBITYUUSI}</td><td>&quot;520&quot;</td><td>不備処理中止</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KAITOUMATI}</td><td>&quot;530&quot;</td><td>回答待ち</td></tr>
 *  <tr><td rowspan="4">{@link #PATTERN_NKINPUTKEY NKINPUTKEY}<br />(年金キー入力)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KANRYOU}</td><td>&quot;910&quot;</td><td>完了</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HUBI}</td><td>&quot;510&quot;</td><td>不備</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HORYUU}</td><td>&quot;410&quot;</td><td>保留</td></tr>
 *  <tr><td rowspan="5">{@link #PATTERN_NKINPUT NKINPUT}<br />(年金入力（処理可）)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KANRYOU}</td><td>&quot;910&quot;</td><td>完了</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HUBI}</td><td>&quot;510&quot;</td><td>不備</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HORYUU}</td><td>&quot;410&quot;</td><td>保留</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TORIKESI}</td><td>&quot;960&quot;</td><td>受付取消</td></tr>
 *  <tr><td rowspan="4">{@link #PATTERN_NKINPUTNG NKINPUTNG}<br />(年金入力（処理不可）)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HUBI}</td><td>&quot;510&quot;</td><td>不備</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HORYUU}</td><td>&quot;410&quot;</td><td>保留</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TORIKESI}</td><td>&quot;960&quot;</td><td>受付取消</td></tr>
 *  <tr><td rowspan="6">{@link #PATTERN_NKTENKEN NKTENKEN}<br />(年金点検（処理可）)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KANRYOU}</td><td>&quot;910&quot;</td><td>完了</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HUBI}</td><td>&quot;510&quot;</td><td>不備</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HORYUU}</td><td>&quot;410&quot;</td><td>保留</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SASIMODOSI}</td><td>&quot;210&quot;</td><td>差戻し</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TORIKESI}</td><td>&quot;960&quot;</td><td>受付取消</td></tr>
 *  <tr><td rowspan="5">{@link #PATTERN_NKTENKENNG NKTENKENNG}<br />(年金点検（処理不可）)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HUBI}</td><td>&quot;510&quot;</td><td>不備</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HORYUU}</td><td>&quot;410&quot;</td><td>保留</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SASIMODOSI}</td><td>&quot;210&quot;</td><td>差戻し</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TORIKESI}</td><td>&quot;960&quot;</td><td>受付取消</td></tr>
 *  <tr><td rowspan="5">{@link #PATTERN_NKSYOUNIN NKSYOUNIN}<br />(年金承認)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SYOUNIN}</td><td>&quot;920&quot;</td><td>承認</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HUSYOUNIN}</td><td>&quot;930&quot;</td><td>不承認</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HUBI}</td><td>&quot;510&quot;</td><td>不備</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HORYUU}</td><td>&quot;410&quot;</td><td>保留</td></tr>
 *  <tr><td rowspan="5">{@link #PATTERN_NKHUBITOUROKU NKHUBITOUROKU}<br />(年金不備登録)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KANRYOU}</td><td>&quot;910&quot;</td><td>完了</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HORYUU}</td><td>&quot;410&quot;</td><td>保留</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TENSOU}</td><td>&quot;110&quot;</td><td>転送</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HUBITYUUSI}</td><td>&quot;520&quot;</td><td>不備処理中止</td></tr>
 *  <tr><td rowspan="6">{@link #PATTERN_NKHUBISYOUNIN NKHUBISYOUNIN}<br />(年金不備承認)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KANRYOU}</td><td>&quot;910&quot;</td><td>完了</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HORYUU}</td><td>&quot;410&quot;</td><td>保留</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TENSOU}</td><td>&quot;110&quot;</td><td>転送</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SASIMODOSI}</td><td>&quot;210&quot;</td><td>差戻し</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HUBITYUUSI}</td><td>&quot;520&quot;</td><td>不備処理中止</td></tr>
 *  <tr><td rowspan="5">{@link #PATTERN_NKHUBIKAISYOU NKHUBIKAISYOU}<br />(年金不備解消)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KANRYOU}</td><td>&quot;910&quot;</td><td>完了</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HORYUU}</td><td>&quot;410&quot;</td><td>保留</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KAITOUMATI}</td><td>&quot;530&quot;</td><td>回答待ち</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HUBI}</td><td>&quot;510&quot;</td><td>不備</td></tr>
 *  <tr><td rowspan="11">{@link #PATTERN_KHOZEN KHOZEN}<br />(契約保全)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KANRYOU}</td><td>&quot;910&quot;</td><td>完了</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SYOUNIN}</td><td>&quot;920&quot;</td><td>承認</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HUSYOUNIN}</td><td>&quot;930&quot;</td><td>不承認</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HUBI}</td><td>&quot;510&quot;</td><td>不備</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HORYUU}</td><td>&quot;410&quot;</td><td>保留</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SASIMODOSI}</td><td>&quot;210&quot;</td><td>差戻し</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TORIKESI}</td><td>&quot;960&quot;</td><td>受付取消</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TENSOU}</td><td>&quot;110&quot;</td><td>転送</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HUBITYUUSI}</td><td>&quot;520&quot;</td><td>不備処理中止</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KAITOUMATI}</td><td>&quot;530&quot;</td><td>回答待ち</td></tr>
 *  <tr><td rowspan="4">{@link #PATTERN_KHINPUTKEY KHINPUTKEY}<br />(契約保全キー入力)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KANRYOU}</td><td>&quot;910&quot;</td><td>完了</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HUBI}</td><td>&quot;510&quot;</td><td>不備</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HORYUU}</td><td>&quot;410&quot;</td><td>保留</td></tr>
 *  <tr><td rowspan="5">{@link #PATTERN_KHINPUT KHINPUT}<br />(契約保全入力)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KANRYOU}</td><td>&quot;910&quot;</td><td>完了</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HUBI}</td><td>&quot;510&quot;</td><td>不備</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HORYUU}</td><td>&quot;410&quot;</td><td>保留</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TORIKESI}</td><td>&quot;960&quot;</td><td>受付取消</td></tr>
 *  <tr><td rowspan="6">{@link #PATTERN_KHTENKEN KHTENKEN}<br />(契約保全点検)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KANRYOU}</td><td>&quot;910&quot;</td><td>完了</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HUBI}</td><td>&quot;510&quot;</td><td>不備</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HORYUU}</td><td>&quot;410&quot;</td><td>保留</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SASIMODOSI}</td><td>&quot;210&quot;</td><td>差戻し</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TORIKESI}</td><td>&quot;960&quot;</td><td>受付取消</td></tr>
 *  <tr><td rowspan="3">{@link #PATTERN_KHKYUUKZANNAIMATI KHKYUUKZANNAIMATI}<br />(契約保全旧口座案内待ち)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HUBI}</td><td>&quot;510&quot;</td><td>不備</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TORIKESI}</td><td>&quot;960&quot;</td><td>受付取消</td></tr>
 *  <tr><td rowspan="3">{@link #PATTERN_KHCARDTOUROKUMATI KHCARDTOUROKUMATI}<br />(契約保全カード情報登録待ち)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HUBI}</td><td>&quot;510&quot;</td><td>不備</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TORIKESI}</td><td>&quot;960&quot;</td><td>受付取消</td></tr>
 *  <tr><td rowspan="5">{@link #PATTERN_KHSYOUNIN KHSYOUNIN}<br />(契約保全承認)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SYOUNIN}</td><td>&quot;920&quot;</td><td>承認</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HUSYOUNIN}</td><td>&quot;930&quot;</td><td>不承認</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HUBI}</td><td>&quot;510&quot;</td><td>不備</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HORYUU}</td><td>&quot;410&quot;</td><td>保留</td></tr>
 *  <tr><td rowspan="5">{@link #PATTERN_KHHUBITOUROKU KHHUBITOUROKU}<br />(契約保全不備登録)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KANRYOU}</td><td>&quot;910&quot;</td><td>完了</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HORYUU}</td><td>&quot;410&quot;</td><td>保留</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TENSOU}</td><td>&quot;110&quot;</td><td>転送</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HUBITYUUSI}</td><td>&quot;520&quot;</td><td>不備処理中止</td></tr>
 *  <tr><td rowspan="6">{@link #PATTERN_KHHUBISYOUNIN KHHUBISYOUNIN}<br />(契約保全不備承認)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KANRYOU}</td><td>&quot;910&quot;</td><td>完了</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HORYUU}</td><td>&quot;410&quot;</td><td>保留</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TENSOU}</td><td>&quot;110&quot;</td><td>転送</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SASIMODOSI}</td><td>&quot;210&quot;</td><td>差戻し</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HUBITYUUSI}</td><td>&quot;520&quot;</td><td>不備処理中止</td></tr>
 *  <tr><td rowspan="5">{@link #PATTERN_KHHUBIKAISYOU KHHUBIKAISYOU}<br />(契約保全不備解消)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KANRYOU}</td><td>&quot;910&quot;</td><td>完了</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HORYUU}</td><td>&quot;410&quot;</td><td>保留</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KAITOUMATI}</td><td>&quot;530&quot;</td><td>回答待ち</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HUBI}</td><td>&quot;510&quot;</td><td>不備</td></tr>
 *  <tr><td rowspan="6">{@link #PATTERN_SKMOSTENKEN SKMOSTENKEN}<br />(新契約申込点検)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KANRYOU}</td><td>&quot;910&quot;</td><td>完了</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TENSOU_TENKEN_1}</td><td>&quot;121&quot;</td><td>転送（１次）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TENSOU_TENKEN_2}</td><td>&quot;122&quot;</td><td>転送（２次）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TENSOU_TENKEN_HUBI}</td><td>&quot;124&quot;</td><td>転送（点検後不備）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HORYUU}</td><td>&quot;410&quot;</td><td>保留</td></tr>
 *  <tr><td rowspan="6">{@link #PATTERN_SKKNKSATEI SKKNKSATEI}<br />(新契約環境査定)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KANRYOU}</td><td>&quot;910&quot;</td><td>完了</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TENSOU_KANKYOU_1}</td><td>&quot;131&quot;</td><td>転送（１次）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TENSOU_KANKYOU_2A}</td><td>&quot;132&quot;</td><td>転送（２次Ａ）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TENSOU_KANKYOU_2B}</td><td>&quot;133&quot;</td><td>転送（２次Ｂ）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HORYUU}</td><td>&quot;410&quot;</td><td>保留</td></tr>
 *  <tr><td rowspan="5">{@link #PATTERN_SKIMUSATEI SKIMUSATEI}<br />(新契約医務査定)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KANRYOU}</td><td>&quot;910&quot;</td><td>完了</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TENSOU_IMU_KANIUW}</td><td>&quot;141&quot;</td><td>転送（簡易（ＵＷ））</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TENSOU_IMU_KANIMD}</td><td>&quot;142&quot;</td><td>転送（簡易（ＭＤ））</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HORYUU}</td><td>&quot;410&quot;</td><td>保留</td></tr>
 *  <tr><td rowspan="4">{@link #PATTERN_SKMOSTENKENIRAI SKMOSTENKENIRAI}<br />(新契約申込点検依頼)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #IRAI_TENKEN_1}</td><td>&quot;321&quot;</td><td>依頼（１次）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #IRAI_TENKEN_2}</td><td>&quot;322&quot;</td><td>依頼（２次）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #IRAI_TENKEN_HUBI}</td><td>&quot;324&quot;</td><td>依頼（点検後不備）</td></tr>
 *  <tr><td rowspan="4">{@link #PATTERN_SKMOSTENKENTENSOU SKMOSTENKENTENSOU}<br />(新契約申込点検転送)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TENSOU_TENKEN_1}</td><td>&quot;121&quot;</td><td>転送（１次）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TENSOU_TENKEN_2}</td><td>&quot;122&quot;</td><td>転送（２次）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TENSOU_TENKEN_HUBI}</td><td>&quot;124&quot;</td><td>転送（点検後不備）</td></tr>
 *  <tr><td rowspan="4">{@link #PATTERN_SKKNKSATEIIRAI SKKNKSATEIIRAI}<br />(新契約環境査定依頼)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #IRAI_KANKYOU_1}</td><td>&quot;331&quot;</td><td>依頼（１次）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #IRAI_KANKYOU_2A}</td><td>&quot;332&quot;</td><td>依頼（２次Ａ）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #IRAI_KANKYOU_2B}</td><td>&quot;333&quot;</td><td>依頼（２次Ｂ）</td></tr>
 *  <tr><td rowspan="4">{@link #PATTERN_SKKNKSATEITENSOU SKKNKSATEITENSOU}<br />(新契約環境査定転送)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TENSOU_KANKYOU_1}</td><td>&quot;131&quot;</td><td>転送（１次）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TENSOU_KANKYOU_2A}</td><td>&quot;132&quot;</td><td>転送（２次Ａ）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TENSOU_KANKYOU_2B}</td><td>&quot;133&quot;</td><td>転送（２次Ｂ）</td></tr>
 *  <tr><td rowspan="3">{@link #PATTERN_SKIMUSATEIIRAI SKIMUSATEIIRAI}<br />(新契約医務査定依頼)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #IRAI_IMU_KANIUW}</td><td>&quot;341&quot;</td><td>依頼（簡易（ＵＷ））</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #IRAI_IMU_KANIMD}</td><td>&quot;342&quot;</td><td>依頼（簡易（ＭＤ））</td></tr>
 *  <tr><td rowspan="3">{@link #PATTERN_SKIMUSATEITENSOU SKIMUSATEITENSOU}<br />(新契約医務査定転送)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TENSOU_IMU_KANIUW}</td><td>&quot;141&quot;</td><td>転送（簡易（ＵＷ））</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TENSOU_IMU_KANIMD}</td><td>&quot;142&quot;</td><td>転送（簡易（ＭＤ））</td></tr>
 *  <tr><td rowspan="4">{@link #PATTERN_SKMOSTORIKESITENSOU SKMOSTORIKESITENSOU}<br />(新契約申込取消転送)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KANRYOU}</td><td>&quot;910&quot;</td><td>完了</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TENSOU_MOSTORIKESI}</td><td>&quot;170&quot;</td><td>転送（取消）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HORYUU}</td><td>&quot;410&quot;</td><td>保留</td></tr>
 *  <tr><td rowspan="8">{@link #PATTERN_SISATEI_1 SISATEI_1}<br />(保険金査定１次)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SIHARAI}</td><td>&quot;940&quot;</td><td>支払</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HUSIHARAI}</td><td>&quot;950&quot;</td><td>非該当</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SIBOUS_SAIGAIHIGAITOU}</td><td>&quot;970&quot;</td><td>死亡S支払・災害非該当</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KAKUNIN}</td><td>&quot;610&quot;</td><td>確認登録</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HUBIKANRI}</td><td>&quot;650&quot;</td><td>不備管理中</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TENSOU}</td><td>&quot;110&quot;</td><td>転送</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HORYUU}</td><td>&quot;410&quot;</td><td>保留</td></tr>
 *  <tr><td rowspan="9">{@link #PATTERN_SISATEI_1_KAKUNIN SISATEI_1_KAKUNIN}<br />(保険金査定１次（確認済）)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SIHARAI}</td><td>&quot;940&quot;</td><td>支払</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HUSIHARAI}</td><td>&quot;950&quot;</td><td>非該当</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SIBOUS_SAIGAIHIGAITOU}</td><td>&quot;970&quot;</td><td>死亡S支払・災害非該当</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TYUUKANKAKUNIN}</td><td>&quot;620&quot;</td><td>中間確認</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TUIKAKAKUNIN}</td><td>&quot;630&quot;</td><td>追加確認</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HUBIKANRI}</td><td>&quot;650&quot;</td><td>不備管理中</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TENSOU}</td><td>&quot;110&quot;</td><td>転送</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HORYUU}</td><td>&quot;410&quot;</td><td>保留</td></tr>
 *  <tr><td rowspan="9">{@link #PATTERN_SISATEI_2 SISATEI_2}<br />(保険金査定２次)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SIHARAI}</td><td>&quot;940&quot;</td><td>支払</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HUSIHARAI}</td><td>&quot;950&quot;</td><td>非該当</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SIBOUS_SAIGAIHIGAITOU}</td><td>&quot;970&quot;</td><td>死亡S支払・災害非該当</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SATEI_3}</td><td>&quot;660&quot;</td><td>査定３次</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KAKUNIN}</td><td>&quot;610&quot;</td><td>確認登録</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SASIMODOSI}</td><td>&quot;210&quot;</td><td>差戻し</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TENSOU}</td><td>&quot;110&quot;</td><td>転送</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HORYUU}</td><td>&quot;410&quot;</td><td>保留</td></tr>
 *  <tr><td rowspan="10">{@link #PATTERN_SISATEI_2_KAKUNIN SISATEI_2_KAKUNIN}<br />(保険金査定２次（確認済）)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SIHARAI}</td><td>&quot;940&quot;</td><td>支払</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HUSIHARAI}</td><td>&quot;950&quot;</td><td>非該当</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SIBOUS_SAIGAIHIGAITOU}</td><td>&quot;970&quot;</td><td>死亡S支払・災害非該当</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SATEI_3}</td><td>&quot;660&quot;</td><td>査定３次</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TYUUKANKAKUNIN}</td><td>&quot;620&quot;</td><td>中間確認</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TUIKAKAKUNIN}</td><td>&quot;630&quot;</td><td>追加確認</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SASIMODOSI}</td><td>&quot;210&quot;</td><td>差戻し</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TENSOU}</td><td>&quot;110&quot;</td><td>転送</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HORYUU}</td><td>&quot;410&quot;</td><td>保留</td></tr>
 *  <tr><td rowspan="8">{@link #PATTERN_SISATEI_3 SISATEI_3}<br />(保険金査定３次)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SIHARAI}</td><td>&quot;940&quot;</td><td>支払</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HUSIHARAI}</td><td>&quot;950&quot;</td><td>非該当</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SIBOUS_SAIGAIHIGAITOU}</td><td>&quot;970&quot;</td><td>死亡S支払・災害非該当</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SATEI_4}</td><td>&quot;670&quot;</td><td>査定４次</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SASIMODOSI}</td><td>&quot;210&quot;</td><td>差戻し</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TENSOU}</td><td>&quot;110&quot;</td><td>転送</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HORYUU}</td><td>&quot;410&quot;</td><td>保留</td></tr>
 *  <tr><td rowspan="7">{@link #PATTERN_SISATEI_4 SISATEI_4}<br />(保険金査定４次)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SIHARAI}</td><td>&quot;940&quot;</td><td>支払</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HUSIHARAI}</td><td>&quot;950&quot;</td><td>非該当</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SIBOUS_SAIGAIHIGAITOU}</td><td>&quot;970&quot;</td><td>死亡S支払・災害非該当</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SASIMODOSI}</td><td>&quot;210&quot;</td><td>差戻し</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TENSOU}</td><td>&quot;110&quot;</td><td>転送</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HORYUU}</td><td>&quot;410&quot;</td><td>保留</td></tr>
 *  <tr><td rowspan="6">{@link #PATTERN_SITETUZUKI_SATEIHUYOU SITETUZUKI_SATEIHUYOU}<br />(保険金手続（査定不要）)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SIHARAI}</td><td>&quot;940&quot;</td><td>支払</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SATEI_SIJI}</td><td>&quot;680&quot;</td><td>査定指示</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HUBIKANRI}</td><td>&quot;650&quot;</td><td>不備管理中</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TENSOU}</td><td>&quot;110&quot;</td><td>転送</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HORYUU}</td><td>&quot;410&quot;</td><td>保留</td></tr>
 *  <tr><td rowspan="6">{@link #PATTERN_SITETUZUKI_SATEIYOU SITETUZUKI_SATEIYOU}<br />(保険金手続（査定要）)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SYOUNIN}</td><td>&quot;920&quot;</td><td>承認</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HUSYOUNIN}</td><td>&quot;930&quot;</td><td>不承認</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HUBIKANRI}</td><td>&quot;650&quot;</td><td>不備管理中</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TENSOU}</td><td>&quot;110&quot;</td><td>転送</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HORYUU}</td><td>&quot;410&quot;</td><td>保留</td></tr>
 *  <tr><td rowspan="5">{@link #PATTERN_SISYOUNIN SISYOUNIN}<br />(保険金承認)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SYOUNIN}</td><td>&quot;920&quot;</td><td>承認</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HUSYOUNIN}</td><td>&quot;930&quot;</td><td>不承認</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TENSOU}</td><td>&quot;110&quot;</td><td>転送</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HORYUU}</td><td>&quot;410&quot;</td><td>保留</td></tr>
 *  <tr><td rowspan="2">{@link #PATTERN_SIKAKUNINTYUU SIKAKUNINTYUU}<br />(保険金確認依頼中)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KAKUNINKAISYOU}</td><td>&quot;640&quot;</td><td>確認解消</td></tr>
 *  <tr><td rowspan="2">{@link #PATTERN_SIHUBITYUU SIHUBITYUU}<br />(保険金不備管理中)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HUBIKAISYOU}</td><td>&quot;540&quot;</td><td>不備解消</td></tr>
 *  <tr><td rowspan="4">{@link #PATTERN_SISESSYOU_1 SISESSYOU_1}<br />(保険金折衝1次)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KANRYOU}</td><td>&quot;910&quot;</td><td>完了</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TENSOU}</td><td>&quot;110&quot;</td><td>転送</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HORYUU}</td><td>&quot;410&quot;</td><td>保留</td></tr>
 *  <tr><td rowspan="5">{@link #PATTERN_SISESSYOU_2 SISESSYOU_2}<br />(保険金折衝２次)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KANRYOU}</td><td>&quot;910&quot;</td><td>完了</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SASIMODOSI}</td><td>&quot;210&quot;</td><td>差戻し</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TENSOU}</td><td>&quot;110&quot;</td><td>転送</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HORYUU}</td><td>&quot;410&quot;</td><td>保留</td></tr>
 *  <tr><td rowspan="3">{@link #PATTERN_SIKAIKETU SIKAIKETU}<br />(保険金解決入力)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KANRYOU}</td><td>&quot;910&quot;</td><td>完了</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HORYUU}</td><td>&quot;410&quot;</td><td>保留</td></tr>
 *  <tr><td rowspan="5">{@link #PATTERN_SISINDANSYOINPUT SISINDANSYOINPUT}<br />(保険金診断書料支払入力)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KANRYOU}</td><td>&quot;910&quot;</td><td>完了</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TENSOU}</td><td>&quot;110&quot;</td><td>転送</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HORYUU}</td><td>&quot;410&quot;</td><td>保留</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KOUZAKAKUNIN}</td><td>&quot;690&quot;</td><td>口座確認等</td></tr>
 *  <tr><td rowspan="5">{@link #PATTERN_SISINDANSYOTENKEN SISINDANSYOTENKEN}<br />(保険金診断書料支払点検)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SYOUNIN}</td><td>&quot;920&quot;</td><td>承認</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SASIMODOSI}</td><td>&quot;210&quot;</td><td>差戻し</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TENSOU}</td><td>&quot;110&quot;</td><td>転送</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HORYUU}</td><td>&quot;410&quot;</td><td>保留</td></tr>
 *  <tr><td rowspan="4">{@link #PATTERN_SIHUBITOUROKU SIHUBITOUROKU}<br />(保険金不備登録)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KANRYOU}</td><td>&quot;910&quot;</td><td>完了</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TENSOU}</td><td>&quot;110&quot;</td><td>転送</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HORYUU}</td><td>&quot;410&quot;</td><td>保留</td></tr>
 *  <tr><td rowspan="5">{@link #PATTERN_SIHUBISYOUNIN SIHUBISYOUNIN}<br />(保険金不備承認)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KANRYOU}</td><td>&quot;910&quot;</td><td>完了</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TENSOU}</td><td>&quot;110&quot;</td><td>転送</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HORYUU}</td><td>&quot;410&quot;</td><td>保留</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SASIMODOSI}</td><td>&quot;210&quot;</td><td>差戻し</td></tr>
 *  <tr><td rowspan="5">{@link #PATTERN_SIHUBIKAISYOU SIHUBIKAISYOU}<br />(保険金不備解消)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KANRYOU}</td><td>&quot;910&quot;</td><td>完了</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HUBI}</td><td>&quot;510&quot;</td><td>不備</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TENSOU}</td><td>&quot;110&quot;</td><td>転送</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HORYUU}</td><td>&quot;410&quot;</td><td>保留</td></tr>
 * </table>
 */
public class C_SyorikekkaKbn extends Classification<C_SyorikekkaKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_SyorikekkaKbn BLNK = new C_SyorikekkaKbn("0");

    public static final C_SyorikekkaKbn TENSOU = new C_SyorikekkaKbn("110");

    public static final C_SyorikekkaKbn TENSOU_TENKEN_1 = new C_SyorikekkaKbn("121");

    public static final C_SyorikekkaKbn TENSOU_TENKEN_2 = new C_SyorikekkaKbn("122");

    public static final C_SyorikekkaKbn TENSOU_TENKEN_HUBI = new C_SyorikekkaKbn("124");

    public static final C_SyorikekkaKbn TENSOU_KANKYOU_1 = new C_SyorikekkaKbn("131");

    public static final C_SyorikekkaKbn TENSOU_KANKYOU_2A = new C_SyorikekkaKbn("132");

    public static final C_SyorikekkaKbn TENSOU_KANKYOU_2B = new C_SyorikekkaKbn("133");

    public static final C_SyorikekkaKbn TENSOU_IMU_KANIUW = new C_SyorikekkaKbn("141");

    public static final C_SyorikekkaKbn TENSOU_IMU_KANIMD = new C_SyorikekkaKbn("142");

    public static final C_SyorikekkaKbn TENSOU_MOSTORIKESI = new C_SyorikekkaKbn("170");

    public static final C_SyorikekkaKbn SASIMODOSI = new C_SyorikekkaKbn("210");

    public static final C_SyorikekkaKbn IRAI_TENKEN_1 = new C_SyorikekkaKbn("321");

    public static final C_SyorikekkaKbn IRAI_TENKEN_2 = new C_SyorikekkaKbn("322");

    public static final C_SyorikekkaKbn IRAI_TENKEN_3 = new C_SyorikekkaKbn("323");

    public static final C_SyorikekkaKbn IRAI_TENKEN_HUBI = new C_SyorikekkaKbn("324");

    public static final C_SyorikekkaKbn IRAI_KANKYOU_1 = new C_SyorikekkaKbn("331");

    public static final C_SyorikekkaKbn IRAI_KANKYOU_2A = new C_SyorikekkaKbn("332");

    public static final C_SyorikekkaKbn IRAI_KANKYOU_2B = new C_SyorikekkaKbn("333");

    public static final C_SyorikekkaKbn IRAI_IMU_KANIUW = new C_SyorikekkaKbn("341");

    public static final C_SyorikekkaKbn IRAI_IMU_KANIMD = new C_SyorikekkaKbn("342");

    public static final C_SyorikekkaKbn HORYUU = new C_SyorikekkaKbn("410");

    public static final C_SyorikekkaKbn HUBI = new C_SyorikekkaKbn("510");

    public static final C_SyorikekkaKbn HUBITYUUSI = new C_SyorikekkaKbn("520");

    public static final C_SyorikekkaKbn KAITOUMATI = new C_SyorikekkaKbn("530");

    public static final C_SyorikekkaKbn HUBIKAISYOU = new C_SyorikekkaKbn("540");

    public static final C_SyorikekkaKbn KAKUNIN = new C_SyorikekkaKbn("610");

    public static final C_SyorikekkaKbn TYUUKANKAKUNIN = new C_SyorikekkaKbn("620");

    public static final C_SyorikekkaKbn TUIKAKAKUNIN = new C_SyorikekkaKbn("630");

    public static final C_SyorikekkaKbn KAKUNINKAISYOU = new C_SyorikekkaKbn("640");

    public static final C_SyorikekkaKbn HUBIKANRI = new C_SyorikekkaKbn("650");

    public static final C_SyorikekkaKbn SATEI_3 = new C_SyorikekkaKbn("660");

    public static final C_SyorikekkaKbn SATEI_4 = new C_SyorikekkaKbn("670");

    public static final C_SyorikekkaKbn SATEI_SIJI = new C_SyorikekkaKbn("680");

    public static final C_SyorikekkaKbn KOUZAKAKUNIN = new C_SyorikekkaKbn("690");

    public static final C_SyorikekkaKbn KANRYOU = new C_SyorikekkaKbn("910");

    public static final C_SyorikekkaKbn SYOUNIN = new C_SyorikekkaKbn("920");

    public static final C_SyorikekkaKbn HUSYOUNIN = new C_SyorikekkaKbn("930");

    public static final C_SyorikekkaKbn SIHARAI = new C_SyorikekkaKbn("940");

    public static final C_SyorikekkaKbn HUSIHARAI = new C_SyorikekkaKbn("950");

    public static final C_SyorikekkaKbn TORIKESI = new C_SyorikekkaKbn("960");

    public static final C_SyorikekkaKbn SIBOUS_SAIGAIHIGAITOU = new C_SyorikekkaKbn("970");

    public static final C_SyorikekkaKbn KANRYOU_SYOUNINMATI = new C_SyorikekkaKbn("980");


    public static final String PATTERN_DEFAULT = "1";

    public static final String PATTERN_NENKIN = "2";

    public static final String PATTERN_NKINPUTKEY = "3";

    public static final String PATTERN_NKINPUT = "4";

    public static final String PATTERN_NKINPUTNG = "5";

    public static final String PATTERN_NKTENKEN = "6";

    public static final String PATTERN_NKTENKENNG = "7";

    public static final String PATTERN_NKSYOUNIN = "8";

    public static final String PATTERN_NKHUBITOUROKU = "9";

    public static final String PATTERN_NKHUBISYOUNIN = "10";

    public static final String PATTERN_NKHUBIKAISYOU = "11";

    public static final String PATTERN_KHOZEN = "12";

    public static final String PATTERN_KHINPUTKEY = "13";

    public static final String PATTERN_KHINPUT = "14";

    public static final String PATTERN_KHTENKEN = "15";

    public static final String PATTERN_KHKYUUKZANNAIMATI = "16";

    public static final String PATTERN_KHCARDTOUROKUMATI = "17";

    public static final String PATTERN_KHSYOUNIN = "18";

    public static final String PATTERN_KHHUBITOUROKU = "19";

    public static final String PATTERN_KHHUBISYOUNIN = "20";

    public static final String PATTERN_KHHUBIKAISYOU = "21";

    public static final String PATTERN_SKMOSTENKEN = "22";

    public static final String PATTERN_SKKNKSATEI = "23";

    public static final String PATTERN_SKIMUSATEI = "24";

    public static final String PATTERN_SKMOSTENKENIRAI = "25";

    public static final String PATTERN_SKMOSTENKENTENSOU = "26";

    public static final String PATTERN_SKKNKSATEIIRAI = "27";

    public static final String PATTERN_SKKNKSATEITENSOU = "28";

    public static final String PATTERN_SKIMUSATEIIRAI = "29";

    public static final String PATTERN_SKIMUSATEITENSOU = "30";

    public static final String PATTERN_SKMOSTORIKESITENSOU = "31";

    public static final String PATTERN_SISATEI_1 = "32";

    public static final String PATTERN_SISATEI_1_KAKUNIN = "33";

    public static final String PATTERN_SISATEI_2 = "34";

    public static final String PATTERN_SISATEI_2_KAKUNIN = "35";

    public static final String PATTERN_SISATEI_3 = "36";

    public static final String PATTERN_SISATEI_4 = "37";

    public static final String PATTERN_SITETUZUKI_SATEIHUYOU = "38";

    public static final String PATTERN_SITETUZUKI_SATEIYOU = "39";

    public static final String PATTERN_SISYOUNIN = "40";

    public static final String PATTERN_SIKAKUNINTYUU = "41";

    public static final String PATTERN_SIHUBITYUU = "42";

    public static final String PATTERN_SISESSYOU_1 = "43";

    public static final String PATTERN_SISESSYOU_2 = "44";

    public static final String PATTERN_SIKAIKETU = "45";

    public static final String PATTERN_SISINDANSYOINPUT = "46";

    public static final String PATTERN_SISINDANSYOTENKEN = "47";

    public static final String PATTERN_SIHUBITOUROKU = "48";

    public static final String PATTERN_SIHUBISYOUNIN = "49";

    public static final String PATTERN_SIHUBIKAISYOU = "50";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, TENSOU, "TENSOU", false);
        addPattern(PATTERN_DEFAULT, TENSOU_TENKEN_1, "TENSOU_TENKEN_1", false);
        addPattern(PATTERN_DEFAULT, TENSOU_TENKEN_2, "TENSOU_TENKEN_2", false);
        addPattern(PATTERN_DEFAULT, TENSOU_TENKEN_HUBI, "TENSOU_TENKEN_HUBI", false);
        addPattern(PATTERN_DEFAULT, TENSOU_KANKYOU_1, "TENSOU_KANKYOU_1", false);
        addPattern(PATTERN_DEFAULT, TENSOU_KANKYOU_2A, "TENSOU_KANKYOU_2A", false);
        addPattern(PATTERN_DEFAULT, TENSOU_KANKYOU_2B, "TENSOU_KANKYOU_2B", false);
        addPattern(PATTERN_DEFAULT, TENSOU_IMU_KANIUW, "TENSOU_IMU_KANIUW", false);
        addPattern(PATTERN_DEFAULT, TENSOU_IMU_KANIMD, "TENSOU_IMU_KANIMD", false);
        addPattern(PATTERN_DEFAULT, TENSOU_MOSTORIKESI, "TENSOU_MOSTORIKESI", false);
        addPattern(PATTERN_DEFAULT, SASIMODOSI, "SASIMODOSI", false);
        addPattern(PATTERN_DEFAULT, IRAI_TENKEN_1, "IRAI_TENKEN_1", false);
        addPattern(PATTERN_DEFAULT, IRAI_TENKEN_2, "IRAI_TENKEN_2", false);
        addPattern(PATTERN_DEFAULT, IRAI_TENKEN_3, "IRAI_TENKEN_3", false);
        addPattern(PATTERN_DEFAULT, IRAI_TENKEN_HUBI, "IRAI_TENKEN_HUBI", false);
        addPattern(PATTERN_DEFAULT, IRAI_KANKYOU_1, "IRAI_KANKYOU_1", false);
        addPattern(PATTERN_DEFAULT, IRAI_KANKYOU_2A, "IRAI_KANKYOU_2A", false);
        addPattern(PATTERN_DEFAULT, IRAI_KANKYOU_2B, "IRAI_KANKYOU_2B", false);
        addPattern(PATTERN_DEFAULT, IRAI_IMU_KANIUW, "IRAI_IMU_KANIUW", false);
        addPattern(PATTERN_DEFAULT, IRAI_IMU_KANIMD, "IRAI_IMU_KANIMD", false);
        addPattern(PATTERN_DEFAULT, HORYUU, "HORYUU", false);
        addPattern(PATTERN_DEFAULT, HUBI, "HUBI", false);
        addPattern(PATTERN_DEFAULT, HUBITYUUSI, "HUBITYUUSI", false);
        addPattern(PATTERN_DEFAULT, KAITOUMATI, "KAITOUMATI", false);
        addPattern(PATTERN_DEFAULT, HUBIKAISYOU, "HUBIKAISYOU", false);
        addPattern(PATTERN_DEFAULT, KAKUNIN, "KAKUNIN", false);
        addPattern(PATTERN_DEFAULT, TYUUKANKAKUNIN, "TYUUKANKAKUNIN", false);
        addPattern(PATTERN_DEFAULT, TUIKAKAKUNIN, "TUIKAKAKUNIN", false);
        addPattern(PATTERN_DEFAULT, KAKUNINKAISYOU, "KAKUNINKAISYOU", false);
        addPattern(PATTERN_DEFAULT, HUBIKANRI, "HUBIKANRI", false);
        addPattern(PATTERN_DEFAULT, SATEI_3, "SATEI_3", false);
        addPattern(PATTERN_DEFAULT, SATEI_4, "SATEI_4", false);
        addPattern(PATTERN_DEFAULT, SATEI_SIJI, "SATEI_SIJI", false);
        addPattern(PATTERN_DEFAULT, KOUZAKAKUNIN, "KOUZAKAKUNIN", false);
        addPattern(PATTERN_DEFAULT, KANRYOU, "KANRYOU", false);
        addPattern(PATTERN_DEFAULT, SYOUNIN, "SYOUNIN", false);
        addPattern(PATTERN_DEFAULT, HUSYOUNIN, "HUSYOUNIN", false);
        addPattern(PATTERN_DEFAULT, SIHARAI, "SIHARAI", false);
        addPattern(PATTERN_DEFAULT, HUSIHARAI, "HUSIHARAI", false);
        addPattern(PATTERN_DEFAULT, TORIKESI, "TORIKESI", false);
        addPattern(PATTERN_DEFAULT, SIBOUS_SAIGAIHIGAITOU, "SIBOUS_SAIGAIHIGAITOU", false);
        addPattern(PATTERN_DEFAULT, KANRYOU_SYOUNINMATI, "KANRYOU_SYOUNINMATI", false);


        addPattern(PATTERN_NENKIN, BLNK, "BLNK", true);
        addPattern(PATTERN_NENKIN, KANRYOU, "KANRYOU", false);
        addPattern(PATTERN_NENKIN, SYOUNIN, "SYOUNIN", false);
        addPattern(PATTERN_NENKIN, HUSYOUNIN, "HUSYOUNIN", false);
        addPattern(PATTERN_NENKIN, HUBI, "HUBI", false);
        addPattern(PATTERN_NENKIN, HORYUU, "HORYUU", false);
        addPattern(PATTERN_NENKIN, SASIMODOSI, "SASIMODOSI", false);
        addPattern(PATTERN_NENKIN, TORIKESI, "TORIKESI", false);
        addPattern(PATTERN_NENKIN, TENSOU, "TENSOU", false);
        addPattern(PATTERN_NENKIN, HUBITYUUSI, "HUBITYUUSI", false);
        addPattern(PATTERN_NENKIN, KAITOUMATI, "KAITOUMATI", false);


        addPattern(PATTERN_NKINPUTKEY, BLNK, "BLNK", true);
        addPattern(PATTERN_NKINPUTKEY, KANRYOU, "KANRYOU", false);
        addPattern(PATTERN_NKINPUTKEY, HUBI, "HUBI", false);
        addPattern(PATTERN_NKINPUTKEY, HORYUU, "HORYUU", false);


        addPattern(PATTERN_NKINPUT, BLNK, "BLNK", true);
        addPattern(PATTERN_NKINPUT, KANRYOU, "KANRYOU", false);
        addPattern(PATTERN_NKINPUT, HUBI, "HUBI", false);
        addPattern(PATTERN_NKINPUT, HORYUU, "HORYUU", false);
        addPattern(PATTERN_NKINPUT, TORIKESI, "TORIKESI", false);


        addPattern(PATTERN_NKINPUTNG, BLNK, "BLNK", true);
        addPattern(PATTERN_NKINPUTNG, HUBI, "HUBI", false);
        addPattern(PATTERN_NKINPUTNG, HORYUU, "HORYUU", false);
        addPattern(PATTERN_NKINPUTNG, TORIKESI, "TORIKESI", false);


        addPattern(PATTERN_NKTENKEN, BLNK, "BLNK", true);
        addPattern(PATTERN_NKTENKEN, KANRYOU, "KANRYOU", false);
        addPattern(PATTERN_NKTENKEN, HUBI, "HUBI", false);
        addPattern(PATTERN_NKTENKEN, HORYUU, "HORYUU", false);
        addPattern(PATTERN_NKTENKEN, SASIMODOSI, "SASIMODOSI", false);
        addPattern(PATTERN_NKTENKEN, TORIKESI, "TORIKESI", false);


        addPattern(PATTERN_NKTENKENNG, BLNK, "BLNK", true);
        addPattern(PATTERN_NKTENKENNG, HUBI, "HUBI", false);
        addPattern(PATTERN_NKTENKENNG, HORYUU, "HORYUU", false);
        addPattern(PATTERN_NKTENKENNG, SASIMODOSI, "SASIMODOSI", false);
        addPattern(PATTERN_NKTENKENNG, TORIKESI, "TORIKESI", false);


        addPattern(PATTERN_NKSYOUNIN, BLNK, "BLNK", true);
        addPattern(PATTERN_NKSYOUNIN, SYOUNIN, "SYOUNIN", false);
        addPattern(PATTERN_NKSYOUNIN, HUSYOUNIN, "HUSYOUNIN", false);
        addPattern(PATTERN_NKSYOUNIN, HUBI, "HUBI", false);
        addPattern(PATTERN_NKSYOUNIN, HORYUU, "HORYUU", false);


        addPattern(PATTERN_NKHUBITOUROKU, BLNK, "BLNK", true);
        addPattern(PATTERN_NKHUBITOUROKU, KANRYOU, "KANRYOU", false);
        addPattern(PATTERN_NKHUBITOUROKU, HORYUU, "HORYUU", false);
        addPattern(PATTERN_NKHUBITOUROKU, TENSOU, "TENSOU", false);
        addPattern(PATTERN_NKHUBITOUROKU, HUBITYUUSI, "HUBITYUUSI", false);


        addPattern(PATTERN_NKHUBISYOUNIN, BLNK, "BLNK", true);
        addPattern(PATTERN_NKHUBISYOUNIN, KANRYOU, "KANRYOU", false);
        addPattern(PATTERN_NKHUBISYOUNIN, HORYUU, "HORYUU", false);
        addPattern(PATTERN_NKHUBISYOUNIN, TENSOU, "TENSOU", false);
        addPattern(PATTERN_NKHUBISYOUNIN, SASIMODOSI, "SASIMODOSI", false);
        addPattern(PATTERN_NKHUBISYOUNIN, HUBITYUUSI, "HUBITYUUSI", false);


        addPattern(PATTERN_NKHUBIKAISYOU, BLNK, "BLNK", true);
        addPattern(PATTERN_NKHUBIKAISYOU, KANRYOU, "KANRYOU", false);
        addPattern(PATTERN_NKHUBIKAISYOU, HORYUU, "HORYUU", false);
        addPattern(PATTERN_NKHUBIKAISYOU, KAITOUMATI, "KAITOUMATI", false);
        addPattern(PATTERN_NKHUBIKAISYOU, HUBI, "HUBI", false);


        addPattern(PATTERN_KHOZEN, BLNK, "BLNK", true);
        addPattern(PATTERN_KHOZEN, KANRYOU, "KANRYOU", false);
        addPattern(PATTERN_KHOZEN, SYOUNIN, "SYOUNIN", false);
        addPattern(PATTERN_KHOZEN, HUSYOUNIN, "HUSYOUNIN", false);
        addPattern(PATTERN_KHOZEN, HUBI, "HUBI", false);
        addPattern(PATTERN_KHOZEN, HORYUU, "HORYUU", false);
        addPattern(PATTERN_KHOZEN, SASIMODOSI, "SASIMODOSI", false);
        addPattern(PATTERN_KHOZEN, TORIKESI, "TORIKESI", false);
        addPattern(PATTERN_KHOZEN, TENSOU, "TENSOU", false);
        addPattern(PATTERN_KHOZEN, HUBITYUUSI, "HUBITYUUSI", false);
        addPattern(PATTERN_KHOZEN, KAITOUMATI, "KAITOUMATI", false);


        addPattern(PATTERN_KHINPUTKEY, BLNK, "BLNK", true);
        addPattern(PATTERN_KHINPUTKEY, KANRYOU, "KANRYOU", false);
        addPattern(PATTERN_KHINPUTKEY, HUBI, "HUBI", false);
        addPattern(PATTERN_KHINPUTKEY, HORYUU, "HORYUU", false);


        addPattern(PATTERN_KHINPUT, BLNK, "BLNK", true);
        addPattern(PATTERN_KHINPUT, KANRYOU, "KANRYOU", false);
        addPattern(PATTERN_KHINPUT, HUBI, "HUBI", false);
        addPattern(PATTERN_KHINPUT, HORYUU, "HORYUU", false);
        addPattern(PATTERN_KHINPUT, TORIKESI, "TORIKESI", false);


        addPattern(PATTERN_KHTENKEN, BLNK, "BLNK", true);
        addPattern(PATTERN_KHTENKEN, KANRYOU, "KANRYOU", false);
        addPattern(PATTERN_KHTENKEN, HUBI, "HUBI", false);
        addPattern(PATTERN_KHTENKEN, HORYUU, "HORYUU", false);
        addPattern(PATTERN_KHTENKEN, SASIMODOSI, "SASIMODOSI", false);
        addPattern(PATTERN_KHTENKEN, TORIKESI, "TORIKESI", false);


        addPattern(PATTERN_KHKYUUKZANNAIMATI, BLNK, "BLNK", true);
        addPattern(PATTERN_KHKYUUKZANNAIMATI, HUBI, "HUBI", false);
        addPattern(PATTERN_KHKYUUKZANNAIMATI, TORIKESI, "TORIKESI", false);


        addPattern(PATTERN_KHCARDTOUROKUMATI, BLNK, "BLNK", true);
        addPattern(PATTERN_KHCARDTOUROKUMATI, HUBI, "HUBI", false);
        addPattern(PATTERN_KHCARDTOUROKUMATI, TORIKESI, "TORIKESI", false);


        addPattern(PATTERN_KHSYOUNIN, BLNK, "BLNK", true);
        addPattern(PATTERN_KHSYOUNIN, SYOUNIN, "SYOUNIN", false);
        addPattern(PATTERN_KHSYOUNIN, HUSYOUNIN, "HUSYOUNIN", false);
        addPattern(PATTERN_KHSYOUNIN, HUBI, "HUBI", false);
        addPattern(PATTERN_KHSYOUNIN, HORYUU, "HORYUU", false);


        addPattern(PATTERN_KHHUBITOUROKU, BLNK, "BLNK", true);
        addPattern(PATTERN_KHHUBITOUROKU, KANRYOU, "KANRYOU", false);
        addPattern(PATTERN_KHHUBITOUROKU, HORYUU, "HORYUU", false);
        addPattern(PATTERN_KHHUBITOUROKU, TENSOU, "TENSOU", false);
        addPattern(PATTERN_KHHUBITOUROKU, HUBITYUUSI, "HUBITYUUSI", false);


        addPattern(PATTERN_KHHUBISYOUNIN, BLNK, "BLNK", true);
        addPattern(PATTERN_KHHUBISYOUNIN, KANRYOU, "KANRYOU", false);
        addPattern(PATTERN_KHHUBISYOUNIN, HORYUU, "HORYUU", false);
        addPattern(PATTERN_KHHUBISYOUNIN, TENSOU, "TENSOU", false);
        addPattern(PATTERN_KHHUBISYOUNIN, SASIMODOSI, "SASIMODOSI", false);
        addPattern(PATTERN_KHHUBISYOUNIN, HUBITYUUSI, "HUBITYUUSI", false);


        addPattern(PATTERN_KHHUBIKAISYOU, BLNK, "BLNK", true);
        addPattern(PATTERN_KHHUBIKAISYOU, KANRYOU, "KANRYOU", false);
        addPattern(PATTERN_KHHUBIKAISYOU, HORYUU, "HORYUU", false);
        addPattern(PATTERN_KHHUBIKAISYOU, KAITOUMATI, "KAITOUMATI", false);
        addPattern(PATTERN_KHHUBIKAISYOU, HUBI, "HUBI", false);


        addPattern(PATTERN_SKMOSTENKEN, BLNK, "BLNK", true);
        addPattern(PATTERN_SKMOSTENKEN, KANRYOU, "KANRYOU", false);
        addPattern(PATTERN_SKMOSTENKEN, TENSOU_TENKEN_1, "TENSOU_TENKEN_1", false);
        addPattern(PATTERN_SKMOSTENKEN, TENSOU_TENKEN_2, "TENSOU_TENKEN_2", false);
        addPattern(PATTERN_SKMOSTENKEN, TENSOU_TENKEN_HUBI, "TENSOU_TENKEN_HUBI", false);
        addPattern(PATTERN_SKMOSTENKEN, HORYUU, "HORYUU", false);


        addPattern(PATTERN_SKKNKSATEI, BLNK, "BLNK", true);
        addPattern(PATTERN_SKKNKSATEI, KANRYOU, "KANRYOU", false);
        addPattern(PATTERN_SKKNKSATEI, TENSOU_KANKYOU_1, "TENSOU_KANKYOU_1", false);
        addPattern(PATTERN_SKKNKSATEI, TENSOU_KANKYOU_2A, "TENSOU_KANKYOU_2A", false);
        addPattern(PATTERN_SKKNKSATEI, TENSOU_KANKYOU_2B, "TENSOU_KANKYOU_2B", false);
        addPattern(PATTERN_SKKNKSATEI, HORYUU, "HORYUU", false);


        addPattern(PATTERN_SKIMUSATEI, BLNK, "BLNK", true);
        addPattern(PATTERN_SKIMUSATEI, KANRYOU, "KANRYOU", false);
        addPattern(PATTERN_SKIMUSATEI, TENSOU_IMU_KANIUW, "TENSOU_IMU_KANIUW", false);
        addPattern(PATTERN_SKIMUSATEI, TENSOU_IMU_KANIMD, "TENSOU_IMU_KANIMD", false);
        addPattern(PATTERN_SKIMUSATEI, HORYUU, "HORYUU", false);


        addPattern(PATTERN_SKMOSTENKENIRAI, BLNK, "BLNK", true);
        addPattern(PATTERN_SKMOSTENKENIRAI, IRAI_TENKEN_1, "IRAI_TENKEN_1", false);
        addPattern(PATTERN_SKMOSTENKENIRAI, IRAI_TENKEN_2, "IRAI_TENKEN_2", false);
        addPattern(PATTERN_SKMOSTENKENIRAI, IRAI_TENKEN_HUBI, "IRAI_TENKEN_HUBI", false);


        addPattern(PATTERN_SKMOSTENKENTENSOU, BLNK, "BLNK", true);
        addPattern(PATTERN_SKMOSTENKENTENSOU, TENSOU_TENKEN_1, "TENSOU_TENKEN_1", false);
        addPattern(PATTERN_SKMOSTENKENTENSOU, TENSOU_TENKEN_2, "TENSOU_TENKEN_2", false);
        addPattern(PATTERN_SKMOSTENKENTENSOU, TENSOU_TENKEN_HUBI, "TENSOU_TENKEN_HUBI", false);


        addPattern(PATTERN_SKKNKSATEIIRAI, BLNK, "BLNK", true);
        addPattern(PATTERN_SKKNKSATEIIRAI, IRAI_KANKYOU_1, "IRAI_KANKYOU_1", false);
        addPattern(PATTERN_SKKNKSATEIIRAI, IRAI_KANKYOU_2A, "IRAI_KANKYOU_2A", false);
        addPattern(PATTERN_SKKNKSATEIIRAI, IRAI_KANKYOU_2B, "IRAI_KANKYOU_2B", false);


        addPattern(PATTERN_SKKNKSATEITENSOU, BLNK, "BLNK", true);
        addPattern(PATTERN_SKKNKSATEITENSOU, TENSOU_KANKYOU_1, "TENSOU_KANKYOU_1", false);
        addPattern(PATTERN_SKKNKSATEITENSOU, TENSOU_KANKYOU_2A, "TENSOU_KANKYOU_2A", false);
        addPattern(PATTERN_SKKNKSATEITENSOU, TENSOU_KANKYOU_2B, "TENSOU_KANKYOU_2B", false);


        addPattern(PATTERN_SKIMUSATEIIRAI, BLNK, "BLNK", true);
        addPattern(PATTERN_SKIMUSATEIIRAI, IRAI_IMU_KANIUW, "IRAI_IMU_KANIUW", false);
        addPattern(PATTERN_SKIMUSATEIIRAI, IRAI_IMU_KANIMD, "IRAI_IMU_KANIMD", false);


        addPattern(PATTERN_SKIMUSATEITENSOU, BLNK, "BLNK", true);
        addPattern(PATTERN_SKIMUSATEITENSOU, TENSOU_IMU_KANIUW, "TENSOU_IMU_KANIUW", false);
        addPattern(PATTERN_SKIMUSATEITENSOU, TENSOU_IMU_KANIMD, "TENSOU_IMU_KANIMD", false);


        addPattern(PATTERN_SKMOSTORIKESITENSOU, BLNK, "BLNK", true);
        addPattern(PATTERN_SKMOSTORIKESITENSOU, KANRYOU, "KANRYOU", false);
        addPattern(PATTERN_SKMOSTORIKESITENSOU, TENSOU_MOSTORIKESI, "TENSOU_MOSTORIKESI", false);
        addPattern(PATTERN_SKMOSTORIKESITENSOU, HORYUU, "HORYUU", false);


        addPattern(PATTERN_SISATEI_1, BLNK, "BLNK", true);
        addPattern(PATTERN_SISATEI_1, SIHARAI, "SIHARAI", false);
        addPattern(PATTERN_SISATEI_1, HUSIHARAI, "HUSIHARAI", false);
        addPattern(PATTERN_SISATEI_1, SIBOUS_SAIGAIHIGAITOU, "SIBOUS_SAIGAIHIGAITOU", false);
        addPattern(PATTERN_SISATEI_1, KAKUNIN, "KAKUNIN", false);
        addPattern(PATTERN_SISATEI_1, HUBIKANRI, "HUBIKANRI", false);
        addPattern(PATTERN_SISATEI_1, TENSOU, "TENSOU", false);
        addPattern(PATTERN_SISATEI_1, HORYUU, "HORYUU", false);


        addPattern(PATTERN_SISATEI_1_KAKUNIN, BLNK, "BLNK", true);
        addPattern(PATTERN_SISATEI_1_KAKUNIN, SIHARAI, "SIHARAI", false);
        addPattern(PATTERN_SISATEI_1_KAKUNIN, HUSIHARAI, "HUSIHARAI", false);
        addPattern(PATTERN_SISATEI_1_KAKUNIN, SIBOUS_SAIGAIHIGAITOU, "SIBOUS_SAIGAIHIGAITOU", false);
        addPattern(PATTERN_SISATEI_1_KAKUNIN, TYUUKANKAKUNIN, "TYUUKANKAKUNIN", false);
        addPattern(PATTERN_SISATEI_1_KAKUNIN, TUIKAKAKUNIN, "TUIKAKAKUNIN", false);
        addPattern(PATTERN_SISATEI_1_KAKUNIN, HUBIKANRI, "HUBIKANRI", false);
        addPattern(PATTERN_SISATEI_1_KAKUNIN, TENSOU, "TENSOU", false);
        addPattern(PATTERN_SISATEI_1_KAKUNIN, HORYUU, "HORYUU", false);


        addPattern(PATTERN_SISATEI_2, BLNK, "BLNK", true);
        addPattern(PATTERN_SISATEI_2, SIHARAI, "SIHARAI", false);
        addPattern(PATTERN_SISATEI_2, HUSIHARAI, "HUSIHARAI", false);
        addPattern(PATTERN_SISATEI_2, SIBOUS_SAIGAIHIGAITOU, "SIBOUS_SAIGAIHIGAITOU", false);
        addPattern(PATTERN_SISATEI_2, SATEI_3, "SATEI_3", false);
        addPattern(PATTERN_SISATEI_2, KAKUNIN, "KAKUNIN", false);
        addPattern(PATTERN_SISATEI_2, SASIMODOSI, "SASIMODOSI", false);
        addPattern(PATTERN_SISATEI_2, TENSOU, "TENSOU", false);
        addPattern(PATTERN_SISATEI_2, HORYUU, "HORYUU", false);


        addPattern(PATTERN_SISATEI_2_KAKUNIN, BLNK, "BLNK", true);
        addPattern(PATTERN_SISATEI_2_KAKUNIN, SIHARAI, "SIHARAI", false);
        addPattern(PATTERN_SISATEI_2_KAKUNIN, HUSIHARAI, "HUSIHARAI", false);
        addPattern(PATTERN_SISATEI_2_KAKUNIN, SIBOUS_SAIGAIHIGAITOU, "SIBOUS_SAIGAIHIGAITOU", false);
        addPattern(PATTERN_SISATEI_2_KAKUNIN, SATEI_3, "SATEI_3", false);
        addPattern(PATTERN_SISATEI_2_KAKUNIN, TYUUKANKAKUNIN, "TYUUKANKAKUNIN", false);
        addPattern(PATTERN_SISATEI_2_KAKUNIN, TUIKAKAKUNIN, "TUIKAKAKUNIN", false);
        addPattern(PATTERN_SISATEI_2_KAKUNIN, SASIMODOSI, "SASIMODOSI", false);
        addPattern(PATTERN_SISATEI_2_KAKUNIN, TENSOU, "TENSOU", false);
        addPattern(PATTERN_SISATEI_2_KAKUNIN, HORYUU, "HORYUU", false);


        addPattern(PATTERN_SISATEI_3, BLNK, "BLNK", true);
        addPattern(PATTERN_SISATEI_3, SIHARAI, "SIHARAI", false);
        addPattern(PATTERN_SISATEI_3, HUSIHARAI, "HUSIHARAI", false);
        addPattern(PATTERN_SISATEI_3, SIBOUS_SAIGAIHIGAITOU, "SIBOUS_SAIGAIHIGAITOU", false);
        addPattern(PATTERN_SISATEI_3, SATEI_4, "SATEI_4", false);
        addPattern(PATTERN_SISATEI_3, SASIMODOSI, "SASIMODOSI", false);
        addPattern(PATTERN_SISATEI_3, TENSOU, "TENSOU", false);
        addPattern(PATTERN_SISATEI_3, HORYUU, "HORYUU", false);


        addPattern(PATTERN_SISATEI_4, BLNK, "BLNK", true);
        addPattern(PATTERN_SISATEI_4, SIHARAI, "SIHARAI", false);
        addPattern(PATTERN_SISATEI_4, HUSIHARAI, "HUSIHARAI", false);
        addPattern(PATTERN_SISATEI_4, SIBOUS_SAIGAIHIGAITOU, "SIBOUS_SAIGAIHIGAITOU", false);
        addPattern(PATTERN_SISATEI_4, SASIMODOSI, "SASIMODOSI", false);
        addPattern(PATTERN_SISATEI_4, TENSOU, "TENSOU", false);
        addPattern(PATTERN_SISATEI_4, HORYUU, "HORYUU", false);


        addPattern(PATTERN_SITETUZUKI_SATEIHUYOU, BLNK, "BLNK", true);
        addPattern(PATTERN_SITETUZUKI_SATEIHUYOU, SIHARAI, "SIHARAI", false);
        addPattern(PATTERN_SITETUZUKI_SATEIHUYOU, SATEI_SIJI, "SATEI_SIJI", false);
        addPattern(PATTERN_SITETUZUKI_SATEIHUYOU, HUBIKANRI, "HUBIKANRI", false);
        addPattern(PATTERN_SITETUZUKI_SATEIHUYOU, TENSOU, "TENSOU", false);
        addPattern(PATTERN_SITETUZUKI_SATEIHUYOU, HORYUU, "HORYUU", false);


        addPattern(PATTERN_SITETUZUKI_SATEIYOU, BLNK, "BLNK", true);
        addPattern(PATTERN_SITETUZUKI_SATEIYOU, SYOUNIN, "SYOUNIN", false);
        addPattern(PATTERN_SITETUZUKI_SATEIYOU, HUSYOUNIN, "HUSYOUNIN", false);
        addPattern(PATTERN_SITETUZUKI_SATEIYOU, HUBIKANRI, "HUBIKANRI", false);
        addPattern(PATTERN_SITETUZUKI_SATEIYOU, TENSOU, "TENSOU", false);
        addPattern(PATTERN_SITETUZUKI_SATEIYOU, HORYUU, "HORYUU", false);


        addPattern(PATTERN_SISYOUNIN, BLNK, "BLNK", true);
        addPattern(PATTERN_SISYOUNIN, SYOUNIN, "SYOUNIN", false);
        addPattern(PATTERN_SISYOUNIN, HUSYOUNIN, "HUSYOUNIN", false);
        addPattern(PATTERN_SISYOUNIN, TENSOU, "TENSOU", false);
        addPattern(PATTERN_SISYOUNIN, HORYUU, "HORYUU", false);


        addPattern(PATTERN_SIKAKUNINTYUU, BLNK, "BLNK", true);
        addPattern(PATTERN_SIKAKUNINTYUU, KAKUNINKAISYOU, "KAKUNINKAISYOU", false);


        addPattern(PATTERN_SIHUBITYUU, BLNK, "BLNK", true);
        addPattern(PATTERN_SIHUBITYUU, HUBIKAISYOU, "HUBIKAISYOU", false);


        addPattern(PATTERN_SISESSYOU_1, BLNK, "BLNK", true);
        addPattern(PATTERN_SISESSYOU_1, KANRYOU, "KANRYOU", false);
        addPattern(PATTERN_SISESSYOU_1, TENSOU, "TENSOU", false);
        addPattern(PATTERN_SISESSYOU_1, HORYUU, "HORYUU", false);


        addPattern(PATTERN_SISESSYOU_2, BLNK, "BLNK", true);
        addPattern(PATTERN_SISESSYOU_2, KANRYOU, "KANRYOU", false);
        addPattern(PATTERN_SISESSYOU_2, SASIMODOSI, "SASIMODOSI", false);
        addPattern(PATTERN_SISESSYOU_2, TENSOU, "TENSOU", false);
        addPattern(PATTERN_SISESSYOU_2, HORYUU, "HORYUU", false);


        addPattern(PATTERN_SIKAIKETU, BLNK, "BLNK", true);
        addPattern(PATTERN_SIKAIKETU, KANRYOU, "KANRYOU", false);
        addPattern(PATTERN_SIKAIKETU, HORYUU, "HORYUU", false);


        addPattern(PATTERN_SISINDANSYOINPUT, BLNK, "BLNK", true);
        addPattern(PATTERN_SISINDANSYOINPUT, KANRYOU, "KANRYOU", false);
        addPattern(PATTERN_SISINDANSYOINPUT, TENSOU, "TENSOU", false);
        addPattern(PATTERN_SISINDANSYOINPUT, HORYUU, "HORYUU", false);
        addPattern(PATTERN_SISINDANSYOINPUT, KOUZAKAKUNIN, "KOUZAKAKUNIN", false);


        addPattern(PATTERN_SISINDANSYOTENKEN, BLNK, "BLNK", true);
        addPattern(PATTERN_SISINDANSYOTENKEN, SYOUNIN, "SYOUNIN", false);
        addPattern(PATTERN_SISINDANSYOTENKEN, SASIMODOSI, "SASIMODOSI", false);
        addPattern(PATTERN_SISINDANSYOTENKEN, TENSOU, "TENSOU", false);
        addPattern(PATTERN_SISINDANSYOTENKEN, HORYUU, "HORYUU", false);


        addPattern(PATTERN_SIHUBITOUROKU, BLNK, "BLNK", true);
        addPattern(PATTERN_SIHUBITOUROKU, KANRYOU, "KANRYOU", false);
        addPattern(PATTERN_SIHUBITOUROKU, TENSOU, "TENSOU", false);
        addPattern(PATTERN_SIHUBITOUROKU, HORYUU, "HORYUU", false);


        addPattern(PATTERN_SIHUBISYOUNIN, BLNK, "BLNK", true);
        addPattern(PATTERN_SIHUBISYOUNIN, KANRYOU, "KANRYOU", false);
        addPattern(PATTERN_SIHUBISYOUNIN, TENSOU, "TENSOU", false);
        addPattern(PATTERN_SIHUBISYOUNIN, HORYUU, "HORYUU", false);
        addPattern(PATTERN_SIHUBISYOUNIN, SASIMODOSI, "SASIMODOSI", false);


        addPattern(PATTERN_SIHUBIKAISYOU, BLNK, "BLNK", true);
        addPattern(PATTERN_SIHUBIKAISYOU, KANRYOU, "KANRYOU", false);
        addPattern(PATTERN_SIHUBIKAISYOU, HUBI, "HUBI", false);
        addPattern(PATTERN_SIHUBIKAISYOU, TENSOU, "TENSOU", false);
        addPattern(PATTERN_SIHUBIKAISYOU, HORYUU, "HORYUU", false);


        lock(C_SyorikekkaKbn.class);
    }

    private C_SyorikekkaKbn(String value) {
        super(value);
    }

    public static C_SyorikekkaKbn valueOf(String value) {
        return valueOf(C_SyorikekkaKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_SyorikekkaKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_SyorikekkaKbn.class, patternId, value);
    }
}
