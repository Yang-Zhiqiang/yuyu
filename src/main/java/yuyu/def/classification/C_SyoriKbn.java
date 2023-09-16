
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 処理区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_SyoriKbn</td><td colspan="3">処理区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="76">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KYKTORIKESI}</td><td>&quot;10&quot;</td><td>契約取消</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #CLGOFF}</td><td>&quot;11&quot;</td><td>クーリングオフ</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KAIJO}</td><td>&quot;12&quot;</td><td>解除</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MENSEKI}</td><td>&quot;13&quot;</td><td>免責</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MUKOU}</td><td>&quot;14&quot;</td><td>無効</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SBMUKOU_KIHRKPSHR}</td><td>&quot;15&quot;</td><td>死亡無効（既払Ｐ支払）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SBMUKOU_SHRNASI}</td><td>&quot;16&quot;</td><td>死亡無効（支払なし）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SBMUKOU}</td><td>&quot;17&quot;</td><td>死亡無効</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SBKAIJO}</td><td>&quot;18&quot;</td><td>死亡解除</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SBMENSEKI}</td><td>&quot;19&quot;</td><td>死亡免責</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SBMENSEKI_SHRNASI}</td><td>&quot;20&quot;</td><td>死亡免責（支払なし）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SIBOU}</td><td>&quot;21&quot;</td><td>死亡</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SBKYUUHUSHR}</td><td>&quot;22&quot;</td><td>死亡給付金支払</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KAIJO_SYOUMETU}</td><td>&quot;23&quot;</td><td>解除（消滅後）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MENSEKI_SYOUMETU}</td><td>&quot;24&quot;</td><td>免責（消滅後）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SBKAIJO_SYOUMETU}</td><td>&quot;25&quot;</td><td>死亡解除（消滅後）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KOUDOSYOUGAI}</td><td>&quot;26&quot;</td><td>高度障害</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #GANSINDAN}</td><td>&quot;27&quot;</td><td>がん診断</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KAIYAKU_KEIYAKUSYASIBOU}</td><td>&quot;28&quot;</td><td>契約者死亡による解約</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KAIYAKU_SAIKENSYA}</td><td>&quot;29&quot;</td><td>債権者による解約</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SKSYOUKENSAIHAKKOU}</td><td>&quot;30&quot;</td><td>新契約証券再作成</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MOKUHYOUGKWARIHENKOU}</td><td>&quot;31&quot;</td><td>目標額割合変更</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MEIHEN_BETUHEN}</td><td>&quot;32&quot;</td><td>別人への契約者変更</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MEIHEN_KAISEIKAIMEI}</td><td>&quot;33&quot;</td><td>改姓・改名・字体訂正</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MEIHEN_KYKSIBOU}</td><td>&quot;34&quot;</td><td>契約者死亡による契約者変更</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MEIHEN_HHKKAISEIUKEHENKOU}</td><td>&quot;35&quot;</td><td>被保険者改姓・受取人変更</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KAIYAKU_DIRECTSERVICE}</td><td>&quot;36&quot;</td><td>ダイレクトサービスによる解約</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #ITEN}</td><td>&quot;37&quot;</td><td>移転</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #ITENTORIKESI}</td><td>&quot;38&quot;</td><td>移転取消</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #YENDTHNKHRSHR_KEIYAKUSYASIBOU}</td><td>&quot;39&quot;</td><td>契約者死亡による支払</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MKHGKTTTYENDTHNKTORIKESI}</td><td>&quot;40&quot;</td><td>目標額到達時円建変更取消</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SEIBETUHENKOU}</td><td>&quot;41&quot;</td><td>性別変更</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KAIYAKU_TEL}</td><td>&quot;42&quot;</td><td>電話による解約</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #ITIBUHIKIDASI}</td><td>&quot;43&quot;</td><td>一部引出</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #ZENGAKUHIKIDASI}</td><td>&quot;44&quot;</td><td>全額引出</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #ZEISEITEKIKAKUHUKA}</td><td>&quot;45&quot;</td><td>個人年金保険料税制適格特約付加</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #ZEISEITEKIKAKUSYOUMETU}</td><td>&quot;46&quot;</td><td>個人年金保険料税制適格特約消滅</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HRIHENNONE}</td><td>&quot;47&quot;</td><td>払方変更無し</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #YYKIDOUUKE}</td><td>&quot;48&quot;</td><td>予約異動受付</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #YYKIDOUTORIKESI}</td><td>&quot;49&quot;</td><td>予約異動取消</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #DATTAIUKE}</td><td>&quot;50&quot;</td><td>脱退受付</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #DATTAIKAISYOU}</td><td>&quot;51&quot;</td><td>脱退解消</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NYUURYOKU}</td><td>&quot;52&quot;</td><td>入力</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TORIKESI}</td><td>&quot;53&quot;</td><td>取消</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #FBHENKIN}</td><td>&quot;54&quot;</td><td>ＦＢ返金</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HNDKRKKEIJYOU}</td><td>&quot;55&quot;</td><td>ハンド仮受計上</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NYUUKIN_KRK}</td><td>&quot;56&quot;</td><td>仮受金からの入金</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KRKKEIJYOU}</td><td>&quot;57&quot;</td><td>仮受金計上</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #JIDOUHNKN}</td><td>&quot;58&quot;</td><td>自動返金</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #JYUUTOU}</td><td>&quot;59&quot;</td><td>充当</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MANRYOU}</td><td>&quot;60&quot;</td><td>満了</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KEIROHENKOUYYKIDOUUKE}</td><td>&quot;61&quot;</td><td>口座変更・予約異動受付</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SOKUJIHENKOU}</td><td>&quot;62&quot;</td><td>即時変更</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TMTTKNHANEI_TORIKESI}</td><td>&quot;63&quot;</td><td>積立金反映取消</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TMTTKNHANEI_ITEN_TORIKESI}</td><td>&quot;64&quot;</td><td>積立金反映・移転取消</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #YENDTHNK_MKHGKTTT}</td><td>&quot;65&quot;</td><td>目標額到達時</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #YENDTHNK_NINISEIKYUU}</td><td>&quot;66&quot;</td><td>任意請求</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TMTTKNHANEI}</td><td>&quot;67&quot;</td><td>積立金反映</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TMTTKNHANEI_ITEN}</td><td>&quot;68&quot;</td><td>積立金反映・移転</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #JIDOUSOUKINSEISANZUMI}</td><td>&quot;69&quot;</td><td>自動送金精算済</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MISEISAN}</td><td>&quot;70&quot;</td><td>未精算</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KAISUUHENKOU}</td><td>&quot;71&quot;</td><td>回数変更</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KAISUUHENKOU_KOUZAHENKOU}</td><td>&quot;72&quot;</td><td>回数変更・口座変更</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KAISUUHENKOU_CRECAHENNYUU}</td><td>&quot;73&quot;</td><td>回数変更・クレカ編入</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KAISUUHENKOU_YOHURIHENNYUU}</td><td>&quot;74&quot;</td><td>回数変更・預振編入</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KOUZAHENKOU}</td><td>&quot;75&quot;</td><td>口座変更</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #CRECAHENNYUU}</td><td>&quot;76&quot;</td><td>クレカ編入</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #YOHURIHENNYUU}</td><td>&quot;77&quot;</td><td>預振編入</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #CRECAHENKOU}</td><td>&quot;78&quot;</td><td>クレカ変更</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #CRECAHENKIN}</td><td>&quot;79&quot;</td><td>クレカ返金</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TIKIKTSYURUIHENKOU}</td><td>&quot;80&quot;</td><td>定期一括払種類変更</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TIKIKTSYURUIHENKOU_KOUZAHENKOU}</td><td>&quot;81&quot;</td><td>定期一括払種類変更・口座変更</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TIKIKTSYURUIHENKOU_CRECAHENNYUU}</td><td>&quot;82&quot;</td><td>定期一括払種類変更・クレカ編入</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TIKIKTSYURUIHENKOU_YOHURIHENNYUU}</td><td>&quot;83&quot;</td><td>定期一括払種類変更・預振編入</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #JIKOU}</td><td>&quot;84&quot;</td><td>時効</td></tr>
 *  <tr><td rowspan="76">{@link #PATTERN_SYOUKAI SYOUKAI}<br />(照会画面用)</td><td align="center">&nbsp;</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KYKTORIKESI}</td><td>&quot;10&quot;</td><td>契約取消</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #CLGOFF}</td><td>&quot;11&quot;</td><td>クーリングオフ</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KAIJO}</td><td>&quot;12&quot;</td><td>解除</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MENSEKI}</td><td>&quot;13&quot;</td><td>免責</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MUKOU}</td><td>&quot;14&quot;</td><td>無効</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SBMUKOU_KIHRKPSHR}</td><td>&quot;15&quot;</td><td>死亡無効（既払Ｐ支払）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SBMUKOU_SHRNASI}</td><td>&quot;16&quot;</td><td>死亡無効（支払なし）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SBMUKOU}</td><td>&quot;17&quot;</td><td>死亡無効</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SBKAIJO}</td><td>&quot;18&quot;</td><td>死亡解除</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SBMENSEKI}</td><td>&quot;19&quot;</td><td>死亡免責</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SBMENSEKI_SHRNASI}</td><td>&quot;20&quot;</td><td>死亡免責（支払なし）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SIBOU}</td><td>&quot;21&quot;</td><td>死亡</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SBKYUUHUSHR}</td><td>&quot;22&quot;</td><td>死亡給付金支払</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KAIJO_SYOUMETU}</td><td>&quot;23&quot;</td><td>解除（消滅反映後）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MENSEKI_SYOUMETU}</td><td>&quot;24&quot;</td><td>免責（消滅反映後）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SBKAIJO_SYOUMETU}</td><td>&quot;25&quot;</td><td>死亡解除（消滅反映後）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KOUDOSYOUGAI}</td><td>&quot;26&quot;</td><td>高度障害</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #GANSINDAN}</td><td>&quot;27&quot;</td><td>がん診断</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KAIYAKU_KEIYAKUSYASIBOU}</td><td>&quot;28&quot;</td><td>契約者死亡による解約</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KAIYAKU_SAIKENSYA}</td><td>&quot;29&quot;</td><td>債権者による解約</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SKSYOUKENSAIHAKKOU}</td><td>&quot;30&quot;</td><td>新契約証券再作成</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MOKUHYOUGKWARIHENKOU}</td><td>&quot;31&quot;</td><td>目標額割合変更</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MEIHEN_BETUHEN}</td><td>&quot;32&quot;</td><td>別人への契約者変更</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MEIHEN_KAISEIKAIMEI}</td><td>&quot;33&quot;</td><td>改姓・改名・字体訂正</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MEIHEN_KYKSIBOU}</td><td>&quot;34&quot;</td><td>契約者死亡による契約者変更</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MEIHEN_HHKKAISEIUKEHENKOU}</td><td>&quot;35&quot;</td><td>被保険者改姓・受取人変更</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KAIYAKU_DIRECTSERVICE}</td><td>&quot;36&quot;</td><td>ダイレクトサービスによる解約</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #ITEN}</td><td>&quot;37&quot;</td><td>移転</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #ITENTORIKESI}</td><td>&quot;38&quot;</td><td>移転取消</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #YENDTHNKHRSHR_KEIYAKUSYASIBOU}</td><td>&quot;39&quot;</td><td>契約者死亡による支払</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MKHGKTTTYENDTHNKTORIKESI}</td><td>&quot;40&quot;</td><td>目標額到達時円建変更取消</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SEIBETUHENKOU}</td><td>&quot;41&quot;</td><td>性別変更</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KAIYAKU_TEL}</td><td>&quot;42&quot;</td><td>電話による解約</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #ITIBUHIKIDASI}</td><td>&quot;43&quot;</td><td>一部引出</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #ZENGAKUHIKIDASI}</td><td>&quot;44&quot;</td><td>全額引出</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #ZEISEITEKIKAKUHUKA}</td><td>&quot;45&quot;</td><td>個人年金保険料税制適格特約付加</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #ZEISEITEKIKAKUSYOUMETU}</td><td>&quot;46&quot;</td><td>個人年金保険料税制適格特約消滅</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HRIHENNONE}</td><td>&quot;47&quot;</td><td>払方変更無し</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #YYKIDOUUKE}</td><td>&quot;48&quot;</td><td>予約異動受付</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #YYKIDOUTORIKESI}</td><td>&quot;49&quot;</td><td>予約異動取消</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #DATTAIUKE}</td><td>&quot;50&quot;</td><td>脱退受付</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #DATTAIKAISYOU}</td><td>&quot;51&quot;</td><td>脱退解消</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NYUURYOKU}</td><td>&quot;52&quot;</td><td>入力</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TORIKESI}</td><td>&quot;53&quot;</td><td>取消</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #FBHENKIN}</td><td>&quot;54&quot;</td><td>ＦＢ返金</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HNDKRKKEIJYOU}</td><td>&quot;55&quot;</td><td>ハンド仮受計上</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NYUUKIN_KRK}</td><td>&quot;56&quot;</td><td>仮受金からの入金</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KRKKEIJYOU}</td><td>&quot;57&quot;</td><td>仮受金計上</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #JIDOUHNKN}</td><td>&quot;58&quot;</td><td>自動返金</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #JYUUTOU}</td><td>&quot;59&quot;</td><td>充当</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MANRYOU}</td><td>&quot;60&quot;</td><td>満了</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KEIROHENKOUYYKIDOUUKE}</td><td>&quot;61&quot;</td><td>口座変更・予約異動受付</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SOKUJIHENKOU}</td><td>&quot;62&quot;</td><td>即時変更</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TMTTKNHANEI_TORIKESI}</td><td>&quot;63&quot;</td><td>積立金反映取消</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TMTTKNHANEI_ITEN_TORIKESI}</td><td>&quot;64&quot;</td><td>積立金反映・移転取消</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #YENDTHNK_MKHGKTTT}</td><td>&quot;65&quot;</td><td>目標額到達時</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #YENDTHNK_NINISEIKYUU}</td><td>&quot;66&quot;</td><td>任意請求</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TMTTKNHANEI}</td><td>&quot;67&quot;</td><td>積立金反映</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TMTTKNHANEI_ITEN}</td><td>&quot;68&quot;</td><td>積立金反映・移転</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #JIDOUSOUKINSEISANZUMI}</td><td>&quot;69&quot;</td><td>自動送金精算済</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MISEISAN}</td><td>&quot;70&quot;</td><td>未精算</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KAISUUHENKOU}</td><td>&quot;71&quot;</td><td>回数変更</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KAISUUHENKOU_KOUZAHENKOU}</td><td>&quot;72&quot;</td><td>回数変更・口座変更</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KAISUUHENKOU_CRECAHENNYUU}</td><td>&quot;73&quot;</td><td>回数変更・クレカ編入</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KAISUUHENKOU_YOHURIHENNYUU}</td><td>&quot;74&quot;</td><td>回数変更・預振編入</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KOUZAHENKOU}</td><td>&quot;75&quot;</td><td>口座変更</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #CRECAHENNYUU}</td><td>&quot;76&quot;</td><td>クレカ編入</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #YOHURIHENNYUU}</td><td>&quot;77&quot;</td><td>預振編入</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #CRECAHENKOU}</td><td>&quot;78&quot;</td><td>クレカ変更</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #CRECAHENKIN}</td><td>&quot;79&quot;</td><td>クレカ返金</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TIKIKTSYURUIHENKOU}</td><td>&quot;80&quot;</td><td>定期一括払種類変更</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TIKIKTSYURUIHENKOU_KOUZAHENKOU}</td><td>&quot;81&quot;</td><td>定期一括払種類変更・口座変更</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TIKIKTSYURUIHENKOU_CRECAHENNYUU}</td><td>&quot;82&quot;</td><td>定期一括払種類変更・クレカ編入</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TIKIKTSYURUIHENKOU_YOHURIHENNYUU}</td><td>&quot;83&quot;</td><td>定期一括払種類変更・預振編入</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #JIKOU}</td><td>&quot;84&quot;</td><td>時効</td></tr>
 *  <tr><td rowspan="2">{@link #PATTERN_SEIBETUHENKOU SEIBETUHENKOU}<br />(被保険者生年月日・性訂正画面用)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SEIBETUHENKOU}</td><td>&quot;41&quot;</td><td>性別変更</td></tr>
 * </table>
 */
public class C_SyoriKbn extends Classification<C_SyoriKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_SyoriKbn BLNK = new C_SyoriKbn("0");

    public static final C_SyoriKbn KYKTORIKESI = new C_SyoriKbn("10");

    public static final C_SyoriKbn CLGOFF = new C_SyoriKbn("11");

    public static final C_SyoriKbn KAIJO = new C_SyoriKbn("12");

    public static final C_SyoriKbn MENSEKI = new C_SyoriKbn("13");

    public static final C_SyoriKbn MUKOU = new C_SyoriKbn("14");

    public static final C_SyoriKbn SBMUKOU_KIHRKPSHR = new C_SyoriKbn("15");

    public static final C_SyoriKbn SBMUKOU_SHRNASI = new C_SyoriKbn("16");

    public static final C_SyoriKbn SBMUKOU = new C_SyoriKbn("17");

    public static final C_SyoriKbn SBKAIJO = new C_SyoriKbn("18");

    public static final C_SyoriKbn SBMENSEKI = new C_SyoriKbn("19");

    public static final C_SyoriKbn SBMENSEKI_SHRNASI = new C_SyoriKbn("20");

    public static final C_SyoriKbn SIBOU = new C_SyoriKbn("21");

    public static final C_SyoriKbn SBKYUUHUSHR = new C_SyoriKbn("22");

    public static final C_SyoriKbn KAIJO_SYOUMETU = new C_SyoriKbn("23");

    public static final C_SyoriKbn MENSEKI_SYOUMETU = new C_SyoriKbn("24");

    public static final C_SyoriKbn SBKAIJO_SYOUMETU = new C_SyoriKbn("25");

    public static final C_SyoriKbn KOUDOSYOUGAI = new C_SyoriKbn("26");

    public static final C_SyoriKbn GANSINDAN = new C_SyoriKbn("27");

    public static final C_SyoriKbn KAIYAKU_KEIYAKUSYASIBOU = new C_SyoriKbn("28");

    public static final C_SyoriKbn KAIYAKU_SAIKENSYA = new C_SyoriKbn("29");

    public static final C_SyoriKbn SKSYOUKENSAIHAKKOU = new C_SyoriKbn("30");

    public static final C_SyoriKbn MOKUHYOUGKWARIHENKOU = new C_SyoriKbn("31");

    public static final C_SyoriKbn MEIHEN_BETUHEN = new C_SyoriKbn("32");

    public static final C_SyoriKbn MEIHEN_KAISEIKAIMEI = new C_SyoriKbn("33");

    public static final C_SyoriKbn MEIHEN_KYKSIBOU = new C_SyoriKbn("34");

    public static final C_SyoriKbn MEIHEN_HHKKAISEIUKEHENKOU = new C_SyoriKbn("35");

    public static final C_SyoriKbn KAIYAKU_DIRECTSERVICE = new C_SyoriKbn("36");

    public static final C_SyoriKbn ITEN = new C_SyoriKbn("37");

    public static final C_SyoriKbn ITENTORIKESI = new C_SyoriKbn("38");

    public static final C_SyoriKbn YENDTHNKHRSHR_KEIYAKUSYASIBOU = new C_SyoriKbn("39");

    public static final C_SyoriKbn MKHGKTTTYENDTHNKTORIKESI = new C_SyoriKbn("40");

    public static final C_SyoriKbn SEIBETUHENKOU = new C_SyoriKbn("41");

    public static final C_SyoriKbn KAIYAKU_TEL = new C_SyoriKbn("42");

    public static final C_SyoriKbn ITIBUHIKIDASI = new C_SyoriKbn("43");

    public static final C_SyoriKbn ZENGAKUHIKIDASI = new C_SyoriKbn("44");

    public static final C_SyoriKbn ZEISEITEKIKAKUHUKA = new C_SyoriKbn("45");

    public static final C_SyoriKbn ZEISEITEKIKAKUSYOUMETU = new C_SyoriKbn("46");

    public static final C_SyoriKbn HRIHENNONE = new C_SyoriKbn("47");

    public static final C_SyoriKbn YYKIDOUUKE = new C_SyoriKbn("48");

    public static final C_SyoriKbn YYKIDOUTORIKESI = new C_SyoriKbn("49");

    public static final C_SyoriKbn DATTAIUKE = new C_SyoriKbn("50");

    public static final C_SyoriKbn DATTAIKAISYOU = new C_SyoriKbn("51");

    public static final C_SyoriKbn NYUURYOKU = new C_SyoriKbn("52");

    public static final C_SyoriKbn TORIKESI = new C_SyoriKbn("53");

    public static final C_SyoriKbn FBHENKIN = new C_SyoriKbn("54");

    public static final C_SyoriKbn HNDKRKKEIJYOU = new C_SyoriKbn("55");

    public static final C_SyoriKbn NYUUKIN_KRK = new C_SyoriKbn("56");

    public static final C_SyoriKbn KRKKEIJYOU = new C_SyoriKbn("57");

    public static final C_SyoriKbn JIDOUHNKN = new C_SyoriKbn("58");

    public static final C_SyoriKbn JYUUTOU = new C_SyoriKbn("59");

    public static final C_SyoriKbn MANRYOU = new C_SyoriKbn("60");

    public static final C_SyoriKbn KEIROHENKOUYYKIDOUUKE = new C_SyoriKbn("61");

    public static final C_SyoriKbn SOKUJIHENKOU = new C_SyoriKbn("62");

    public static final C_SyoriKbn TMTTKNHANEI_TORIKESI = new C_SyoriKbn("63");

    public static final C_SyoriKbn TMTTKNHANEI_ITEN_TORIKESI = new C_SyoriKbn("64");

    public static final C_SyoriKbn YENDTHNK_MKHGKTTT = new C_SyoriKbn("65");

    public static final C_SyoriKbn YENDTHNK_NINISEIKYUU = new C_SyoriKbn("66");

    public static final C_SyoriKbn TMTTKNHANEI = new C_SyoriKbn("67");

    public static final C_SyoriKbn TMTTKNHANEI_ITEN = new C_SyoriKbn("68");

    public static final C_SyoriKbn JIDOUSOUKINSEISANZUMI = new C_SyoriKbn("69");

    public static final C_SyoriKbn MISEISAN = new C_SyoriKbn("70");

    public static final C_SyoriKbn KAISUUHENKOU = new C_SyoriKbn("71");

    public static final C_SyoriKbn KAISUUHENKOU_KOUZAHENKOU = new C_SyoriKbn("72");

    public static final C_SyoriKbn KAISUUHENKOU_CRECAHENNYUU = new C_SyoriKbn("73");

    public static final C_SyoriKbn KAISUUHENKOU_YOHURIHENNYUU = new C_SyoriKbn("74");

    public static final C_SyoriKbn KOUZAHENKOU = new C_SyoriKbn("75");

    public static final C_SyoriKbn CRECAHENNYUU = new C_SyoriKbn("76");

    public static final C_SyoriKbn YOHURIHENNYUU = new C_SyoriKbn("77");

    public static final C_SyoriKbn CRECAHENKOU = new C_SyoriKbn("78");

    public static final C_SyoriKbn CRECAHENKIN = new C_SyoriKbn("79");

    public static final C_SyoriKbn TIKIKTSYURUIHENKOU = new C_SyoriKbn("80");

    public static final C_SyoriKbn TIKIKTSYURUIHENKOU_KOUZAHENKOU = new C_SyoriKbn("81");

    public static final C_SyoriKbn TIKIKTSYURUIHENKOU_CRECAHENNYUU = new C_SyoriKbn("82");

    public static final C_SyoriKbn TIKIKTSYURUIHENKOU_YOHURIHENNYUU = new C_SyoriKbn("83");

    public static final C_SyoriKbn JIKOU = new C_SyoriKbn("84");


    public static final String PATTERN_DEFAULT = "1";

    public static final String PATTERN_SYOUKAI = "2";

    public static final String PATTERN_SEIBETUHENKOU = "3";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, KYKTORIKESI, "KYKTORIKESI", false);
        addPattern(PATTERN_DEFAULT, CLGOFF, "CLGOFF", false);
        addPattern(PATTERN_DEFAULT, KAIJO, "KAIJO", false);
        addPattern(PATTERN_DEFAULT, MENSEKI, "MENSEKI", false);
        addPattern(PATTERN_DEFAULT, MUKOU, "MUKOU", false);
        addPattern(PATTERN_DEFAULT, SBMUKOU_KIHRKPSHR, "SBMUKOU_KIHRKPSHR", false);
        addPattern(PATTERN_DEFAULT, SBMUKOU_SHRNASI, "SBMUKOU_SHRNASI", false);
        addPattern(PATTERN_DEFAULT, SBMUKOU, "SBMUKOU", false);
        addPattern(PATTERN_DEFAULT, SBKAIJO, "SBKAIJO", false);
        addPattern(PATTERN_DEFAULT, SBMENSEKI, "SBMENSEKI", false);
        addPattern(PATTERN_DEFAULT, SBMENSEKI_SHRNASI, "SBMENSEKI_SHRNASI", false);
        addPattern(PATTERN_DEFAULT, SIBOU, "SIBOU", false);
        addPattern(PATTERN_DEFAULT, SBKYUUHUSHR, "SBKYUUHUSHR", false);
        addPattern(PATTERN_DEFAULT, KAIJO_SYOUMETU, "KAIJO_SYOUMETU", false);
        addPattern(PATTERN_DEFAULT, MENSEKI_SYOUMETU, "MENSEKI_SYOUMETU", false);
        addPattern(PATTERN_DEFAULT, SBKAIJO_SYOUMETU, "SBKAIJO_SYOUMETU", false);
        addPattern(PATTERN_DEFAULT, KOUDOSYOUGAI, "KOUDOSYOUGAI", false);
        addPattern(PATTERN_DEFAULT, GANSINDAN, "GANSINDAN", false);
        addPattern(PATTERN_DEFAULT, KAIYAKU_KEIYAKUSYASIBOU, "KAIYAKU_KEIYAKUSYASIBOU", false);
        addPattern(PATTERN_DEFAULT, KAIYAKU_SAIKENSYA, "KAIYAKU_SAIKENSYA", false);
        addPattern(PATTERN_DEFAULT, SKSYOUKENSAIHAKKOU, "SKSYOUKENSAIHAKKOU", false);
        addPattern(PATTERN_DEFAULT, MOKUHYOUGKWARIHENKOU, "MOKUHYOUGKWARIHENKOU", false);
        addPattern(PATTERN_DEFAULT, MEIHEN_BETUHEN, "MEIHEN_BETUHEN", false);
        addPattern(PATTERN_DEFAULT, MEIHEN_KAISEIKAIMEI, "MEIHEN_KAISEIKAIMEI", false);
        addPattern(PATTERN_DEFAULT, MEIHEN_KYKSIBOU, "MEIHEN_KYKSIBOU", false);
        addPattern(PATTERN_DEFAULT, MEIHEN_HHKKAISEIUKEHENKOU, "MEIHEN_HHKKAISEIUKEHENKOU", false);
        addPattern(PATTERN_DEFAULT, KAIYAKU_DIRECTSERVICE, "KAIYAKU_DIRECTSERVICE", false);
        addPattern(PATTERN_DEFAULT, ITEN, "ITEN", false);
        addPattern(PATTERN_DEFAULT, ITENTORIKESI, "ITENTORIKESI", false);
        addPattern(PATTERN_DEFAULT, YENDTHNKHRSHR_KEIYAKUSYASIBOU, "YENDTHNKHRSHR_KEIYAKUSYASIBOU", false);
        addPattern(PATTERN_DEFAULT, MKHGKTTTYENDTHNKTORIKESI, "MKHGKTTTYENDTHNKTORIKESI", false);
        addPattern(PATTERN_DEFAULT, SEIBETUHENKOU, "SEIBETUHENKOU", false);
        addPattern(PATTERN_DEFAULT, KAIYAKU_TEL, "KAIYAKU_TEL", false);
        addPattern(PATTERN_DEFAULT, ITIBUHIKIDASI, "ITIBUHIKIDASI", false);
        addPattern(PATTERN_DEFAULT, ZENGAKUHIKIDASI, "ZENGAKUHIKIDASI", false);
        addPattern(PATTERN_DEFAULT, ZEISEITEKIKAKUHUKA, "ZEISEITEKIKAKUHUKA", false);
        addPattern(PATTERN_DEFAULT, ZEISEITEKIKAKUSYOUMETU, "ZEISEITEKIKAKUSYOUMETU", false);
        addPattern(PATTERN_DEFAULT, HRIHENNONE, "HRIHENNONE", false);
        addPattern(PATTERN_DEFAULT, YYKIDOUUKE, "YYKIDOUUKE", false);
        addPattern(PATTERN_DEFAULT, YYKIDOUTORIKESI, "YYKIDOUTORIKESI", false);
        addPattern(PATTERN_DEFAULT, DATTAIUKE, "DATTAIUKE", false);
        addPattern(PATTERN_DEFAULT, DATTAIKAISYOU, "DATTAIKAISYOU", false);
        addPattern(PATTERN_DEFAULT, NYUURYOKU, "NYUURYOKU", false);
        addPattern(PATTERN_DEFAULT, TORIKESI, "TORIKESI", false);
        addPattern(PATTERN_DEFAULT, FBHENKIN, "FBHENKIN", false);
        addPattern(PATTERN_DEFAULT, HNDKRKKEIJYOU, "HNDKRKKEIJYOU", false);
        addPattern(PATTERN_DEFAULT, NYUUKIN_KRK, "NYUUKIN_KRK", false);
        addPattern(PATTERN_DEFAULT, KRKKEIJYOU, "KRKKEIJYOU", false);
        addPattern(PATTERN_DEFAULT, JIDOUHNKN, "JIDOUHNKN", false);
        addPattern(PATTERN_DEFAULT, JYUUTOU, "JYUUTOU", false);
        addPattern(PATTERN_DEFAULT, MANRYOU, "MANRYOU", false);
        addPattern(PATTERN_DEFAULT, KEIROHENKOUYYKIDOUUKE, "KEIROHENKOUYYKIDOUUKE", false);
        addPattern(PATTERN_DEFAULT, SOKUJIHENKOU, "SOKUJIHENKOU", false);
        addPattern(PATTERN_DEFAULT, TMTTKNHANEI_TORIKESI, "TMTTKNHANEI_TORIKESI", false);
        addPattern(PATTERN_DEFAULT, TMTTKNHANEI_ITEN_TORIKESI, "TMTTKNHANEI_ITEN_TORIKESI", false);
        addPattern(PATTERN_DEFAULT, YENDTHNK_MKHGKTTT, "YENDTHNK_MKHGKTTT", false);
        addPattern(PATTERN_DEFAULT, YENDTHNK_NINISEIKYUU, "YENDTHNK_NINISEIKYUU", false);
        addPattern(PATTERN_DEFAULT, TMTTKNHANEI, "TMTTKNHANEI", false);
        addPattern(PATTERN_DEFAULT, TMTTKNHANEI_ITEN, "TMTTKNHANEI_ITEN", false);
        addPattern(PATTERN_DEFAULT, JIDOUSOUKINSEISANZUMI, "JIDOUSOUKINSEISANZUMI", false);
        addPattern(PATTERN_DEFAULT, MISEISAN, "MISEISAN", false);
        addPattern(PATTERN_DEFAULT, KAISUUHENKOU, "KAISUUHENKOU", false);
        addPattern(PATTERN_DEFAULT, KAISUUHENKOU_KOUZAHENKOU, "KAISUUHENKOU_KOUZAHENKOU", false);
        addPattern(PATTERN_DEFAULT, KAISUUHENKOU_CRECAHENNYUU, "KAISUUHENKOU_CRECAHENNYUU", false);
        addPattern(PATTERN_DEFAULT, KAISUUHENKOU_YOHURIHENNYUU, "KAISUUHENKOU_YOHURIHENNYUU", false);
        addPattern(PATTERN_DEFAULT, KOUZAHENKOU, "KOUZAHENKOU", false);
        addPattern(PATTERN_DEFAULT, CRECAHENNYUU, "CRECAHENNYUU", false);
        addPattern(PATTERN_DEFAULT, YOHURIHENNYUU, "YOHURIHENNYUU", false);
        addPattern(PATTERN_DEFAULT, CRECAHENKOU, "CRECAHENKOU", false);
        addPattern(PATTERN_DEFAULT, CRECAHENKIN, "CRECAHENKIN", false);
        addPattern(PATTERN_DEFAULT, TIKIKTSYURUIHENKOU, "TIKIKTSYURUIHENKOU", false);
        addPattern(PATTERN_DEFAULT, TIKIKTSYURUIHENKOU_KOUZAHENKOU, "TIKIKTSYURUIHENKOU_KOUZAHENKOU", false);
        addPattern(PATTERN_DEFAULT, TIKIKTSYURUIHENKOU_CRECAHENNYUU, "TIKIKTSYURUIHENKOU_CRECAHENNYUU", false);
        addPattern(PATTERN_DEFAULT, TIKIKTSYURUIHENKOU_YOHURIHENNYUU, "TIKIKTSYURUIHENKOU_YOHURIHENNYUU", false);
        addPattern(PATTERN_DEFAULT, JIKOU, "JIKOU", false);


        addPattern(PATTERN_SYOUKAI, BLNK, "BLNK", false);
        addPattern(PATTERN_SYOUKAI, KYKTORIKESI, "KYKTORIKESI", false);
        addPattern(PATTERN_SYOUKAI, CLGOFF, "CLGOFF", false);
        addPattern(PATTERN_SYOUKAI, KAIJO, "KAIJO", false);
        addPattern(PATTERN_SYOUKAI, MENSEKI, "MENSEKI", false);
        addPattern(PATTERN_SYOUKAI, MUKOU, "MUKOU", false);
        addPattern(PATTERN_SYOUKAI, SBMUKOU_KIHRKPSHR, "SBMUKOU_KIHRKPSHR", false);
        addPattern(PATTERN_SYOUKAI, SBMUKOU_SHRNASI, "SBMUKOU_SHRNASI", false);
        addPattern(PATTERN_SYOUKAI, SBMUKOU, "SBMUKOU", false);
        addPattern(PATTERN_SYOUKAI, SBKAIJO, "SBKAIJO", false);
        addPattern(PATTERN_SYOUKAI, SBMENSEKI, "SBMENSEKI", false);
        addPattern(PATTERN_SYOUKAI, SBMENSEKI_SHRNASI, "SBMENSEKI_SHRNASI", false);
        addPattern(PATTERN_SYOUKAI, SIBOU, "SIBOU", false);
        addPattern(PATTERN_SYOUKAI, SBKYUUHUSHR, "SBKYUUHUSHR", false);
        addPattern(PATTERN_SYOUKAI, KAIJO_SYOUMETU, "KAIJO_SYOUMETU", false);
        addPattern(PATTERN_SYOUKAI, MENSEKI_SYOUMETU, "MENSEKI_SYOUMETU", false);
        addPattern(PATTERN_SYOUKAI, SBKAIJO_SYOUMETU, "SBKAIJO_SYOUMETU", false);
        addPattern(PATTERN_SYOUKAI, KOUDOSYOUGAI, "KOUDOSYOUGAI", false);
        addPattern(PATTERN_SYOUKAI, GANSINDAN, "GANSINDAN", false);
        addPattern(PATTERN_SYOUKAI, KAIYAKU_KEIYAKUSYASIBOU, "KAIYAKU_KEIYAKUSYASIBOU", false);
        addPattern(PATTERN_SYOUKAI, KAIYAKU_SAIKENSYA, "KAIYAKU_SAIKENSYA", false);
        addPattern(PATTERN_SYOUKAI, SKSYOUKENSAIHAKKOU, "SKSYOUKENSAIHAKKOU", false);
        addPattern(PATTERN_SYOUKAI, MOKUHYOUGKWARIHENKOU, "MOKUHYOUGKWARIHENKOU", false);
        addPattern(PATTERN_SYOUKAI, MEIHEN_BETUHEN, "MEIHEN_BETUHEN", false);
        addPattern(PATTERN_SYOUKAI, MEIHEN_KAISEIKAIMEI, "MEIHEN_KAISEIKAIMEI", false);
        addPattern(PATTERN_SYOUKAI, MEIHEN_KYKSIBOU, "MEIHEN_KYKSIBOU", false);
        addPattern(PATTERN_SYOUKAI, MEIHEN_HHKKAISEIUKEHENKOU, "MEIHEN_HHKKAISEIUKEHENKOU", false);
        addPattern(PATTERN_SYOUKAI, KAIYAKU_DIRECTSERVICE, "KAIYAKU_DIRECTSERVICE", false);
        addPattern(PATTERN_SYOUKAI, ITEN, "ITEN", false);
        addPattern(PATTERN_SYOUKAI, ITENTORIKESI, "ITENTORIKESI", false);
        addPattern(PATTERN_SYOUKAI, YENDTHNKHRSHR_KEIYAKUSYASIBOU, "YENDTHNKHRSHR_KEIYAKUSYASIBOU", false);
        addPattern(PATTERN_SYOUKAI, MKHGKTTTYENDTHNKTORIKESI, "MKHGKTTTYENDTHNKTORIKESI", false);
        addPattern(PATTERN_SYOUKAI, SEIBETUHENKOU, "SEIBETUHENKOU", false);
        addPattern(PATTERN_SYOUKAI, KAIYAKU_TEL, "KAIYAKU_TEL", false);
        addPattern(PATTERN_SYOUKAI, ITIBUHIKIDASI, "ITIBUHIKIDASI", false);
        addPattern(PATTERN_SYOUKAI, ZENGAKUHIKIDASI, "ZENGAKUHIKIDASI", false);
        addPattern(PATTERN_SYOUKAI, ZEISEITEKIKAKUHUKA, "ZEISEITEKIKAKUHUKA", false);
        addPattern(PATTERN_SYOUKAI, ZEISEITEKIKAKUSYOUMETU, "ZEISEITEKIKAKUSYOUMETU", false);
        addPattern(PATTERN_SYOUKAI, HRIHENNONE, "HRIHENNONE", false);
        addPattern(PATTERN_SYOUKAI, YYKIDOUUKE, "YYKIDOUUKE", false);
        addPattern(PATTERN_SYOUKAI, YYKIDOUTORIKESI, "YYKIDOUTORIKESI", false);
        addPattern(PATTERN_SYOUKAI, DATTAIUKE, "DATTAIUKE", false);
        addPattern(PATTERN_SYOUKAI, DATTAIKAISYOU, "DATTAIKAISYOU", false);
        addPattern(PATTERN_SYOUKAI, NYUURYOKU, "NYUURYOKU", false);
        addPattern(PATTERN_SYOUKAI, TORIKESI, "TORIKESI", false);
        addPattern(PATTERN_SYOUKAI, FBHENKIN, "FBHENKIN", false);
        addPattern(PATTERN_SYOUKAI, HNDKRKKEIJYOU, "HNDKRKKEIJYOU", false);
        addPattern(PATTERN_SYOUKAI, NYUUKIN_KRK, "NYUUKIN_KRK", false);
        addPattern(PATTERN_SYOUKAI, KRKKEIJYOU, "KRKKEIJYOU", false);
        addPattern(PATTERN_SYOUKAI, JIDOUHNKN, "JIDOUHNKN", false);
        addPattern(PATTERN_SYOUKAI, JYUUTOU, "JYUUTOU", false);
        addPattern(PATTERN_SYOUKAI, MANRYOU, "MANRYOU", false);
        addPattern(PATTERN_SYOUKAI, KEIROHENKOUYYKIDOUUKE, "KEIROHENKOUYYKIDOUUKE", false);
        addPattern(PATTERN_SYOUKAI, SOKUJIHENKOU, "SOKUJIHENKOU", false);
        addPattern(PATTERN_SYOUKAI, TMTTKNHANEI_TORIKESI, "TMTTKNHANEI_TORIKESI", false);
        addPattern(PATTERN_SYOUKAI, TMTTKNHANEI_ITEN_TORIKESI, "TMTTKNHANEI_ITEN_TORIKESI", false);
        addPattern(PATTERN_SYOUKAI, YENDTHNK_MKHGKTTT, "YENDTHNK_MKHGKTTT", false);
        addPattern(PATTERN_SYOUKAI, YENDTHNK_NINISEIKYUU, "YENDTHNK_NINISEIKYUU", false);
        addPattern(PATTERN_SYOUKAI, TMTTKNHANEI, "TMTTKNHANEI", false);
        addPattern(PATTERN_SYOUKAI, TMTTKNHANEI_ITEN, "TMTTKNHANEI_ITEN", false);
        addPattern(PATTERN_SYOUKAI, JIDOUSOUKINSEISANZUMI, "JIDOUSOUKINSEISANZUMI", false);
        addPattern(PATTERN_SYOUKAI, MISEISAN, "MISEISAN", false);
        addPattern(PATTERN_SYOUKAI, KAISUUHENKOU, "KAISUUHENKOU", false);
        addPattern(PATTERN_SYOUKAI, KAISUUHENKOU_KOUZAHENKOU, "KAISUUHENKOU_KOUZAHENKOU", false);
        addPattern(PATTERN_SYOUKAI, KAISUUHENKOU_CRECAHENNYUU, "KAISUUHENKOU_CRECAHENNYUU", false);
        addPattern(PATTERN_SYOUKAI, KAISUUHENKOU_YOHURIHENNYUU, "KAISUUHENKOU_YOHURIHENNYUU", false);
        addPattern(PATTERN_SYOUKAI, KOUZAHENKOU, "KOUZAHENKOU", false);
        addPattern(PATTERN_SYOUKAI, CRECAHENNYUU, "CRECAHENNYUU", false);
        addPattern(PATTERN_SYOUKAI, YOHURIHENNYUU, "YOHURIHENNYUU", false);
        addPattern(PATTERN_SYOUKAI, CRECAHENKOU, "CRECAHENKOU", false);
        addPattern(PATTERN_SYOUKAI, CRECAHENKIN, "CRECAHENKIN", false);
        addPattern(PATTERN_SYOUKAI, TIKIKTSYURUIHENKOU, "TIKIKTSYURUIHENKOU", false);
        addPattern(PATTERN_SYOUKAI, TIKIKTSYURUIHENKOU_KOUZAHENKOU, "TIKIKTSYURUIHENKOU_KOUZAHENKOU", false);
        addPattern(PATTERN_SYOUKAI, TIKIKTSYURUIHENKOU_CRECAHENNYUU, "TIKIKTSYURUIHENKOU_CRECAHENNYUU", false);
        addPattern(PATTERN_SYOUKAI, TIKIKTSYURUIHENKOU_YOHURIHENNYUU, "TIKIKTSYURUIHENKOU_YOHURIHENNYUU", false);
        addPattern(PATTERN_SYOUKAI, JIKOU, "JIKOU", false);


        addPattern(PATTERN_SEIBETUHENKOU, BLNK, "BLNK", true);
        addPattern(PATTERN_SEIBETUHENKOU, SEIBETUHENKOU, "SEIBETUHENKOU", false);


        lock(C_SyoriKbn.class);
    }

    private C_SyoriKbn(String value) {
        super(value);
    }

    public static C_SyoriKbn valueOf(String value) {
        return valueOf(C_SyoriKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_SyoriKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_SyoriKbn.class, patternId, value);
    }
}
