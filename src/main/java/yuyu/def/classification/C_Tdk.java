
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 続柄 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_Tdk</td><td colspan="3">続柄</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="14">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HONNIN}</td><td>&quot;1&quot;</td><td>本人</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HGU}</td><td>&quot;2&quot;</td><td>配偶者</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #OYA}</td><td>&quot;3&quot;</td><td>親</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KO}</td><td>&quot;4&quot;</td><td>子</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SHB}</td><td>&quot;5&quot;</td><td>祖父母</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KYDSM}</td><td>&quot;6&quot;</td><td>兄弟姉妹</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MAGO}</td><td>&quot;7&quot;</td><td>孫</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KYN}</td><td>&quot;8&quot;</td><td>雇用主</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HTSZN}</td><td>&quot;9&quot;</td><td>法定相続人</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SINTOU3}</td><td>&quot;10&quot;</td><td>３親等の親族</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #OIMEI}</td><td>&quot;11&quot;</td><td>甥姪</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #GIRIKO}</td><td>&quot;12&quot;</td><td>義理の子</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SONOTA}</td><td>&quot;99&quot;</td><td>その他</td></tr>
 *  <tr><td rowspan="8">{@link #PATTERN_KZNKUKT KZNKUKT}<br />(継続年金受取人)</td><td align="center">&nbsp;</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HGU}</td><td>&quot;2&quot;</td><td>配偶者</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #OYA}</td><td>&quot;3&quot;</td><td>親</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KO}</td><td>&quot;4&quot;</td><td>子</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SHB}</td><td>&quot;5&quot;</td><td>祖父母</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KYDSM}</td><td>&quot;6&quot;</td><td>兄弟姉妹</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MAGO}</td><td>&quot;7&quot;</td><td>孫</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SONOTA}</td><td>&quot;99&quot;</td><td>その他</td></tr>
 *  <tr><td rowspan="10">{@link #PATTERN_MOSUKE MOSUKE}<br />(申出受付)</td><td align="center">&nbsp;</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HGU}</td><td>&quot;2&quot;</td><td>配偶者</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #OYA}</td><td>&quot;3&quot;</td><td>親</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KO}</td><td>&quot;4&quot;</td><td>子</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SHB}</td><td>&quot;5&quot;</td><td>祖父母</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KYDSM}</td><td>&quot;6&quot;</td><td>兄弟姉妹</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MAGO}</td><td>&quot;7&quot;</td><td>孫</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KYN}</td><td>&quot;8&quot;</td><td>雇用主</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HTSZN}</td><td>&quot;9&quot;</td><td>法定相続人</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SONOTA}</td><td>&quot;99&quot;</td><td>その他</td></tr>
 *  <tr><td rowspan="11">{@link #PATTERN_NKUKT NKUKT}<br />(年金受取人)</td><td align="center">&nbsp;</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HONNIN}</td><td>&quot;1&quot;</td><td>本人</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HGU}</td><td>&quot;2&quot;</td><td>配偶者</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #OYA}</td><td>&quot;3&quot;</td><td>親</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KO}</td><td>&quot;4&quot;</td><td>子</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SHB}</td><td>&quot;5&quot;</td><td>祖父母</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KYDSM}</td><td>&quot;6&quot;</td><td>兄弟姉妹</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MAGO}</td><td>&quot;7&quot;</td><td>孫</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KYN}</td><td>&quot;8&quot;</td><td>雇用主</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HTSZN}</td><td>&quot;9&quot;</td><td>法定相続人</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SONOTA}</td><td>&quot;99&quot;</td><td>その他</td></tr>
 *  <tr><td rowspan="10">{@link #PATTERN_NKUKT_SELECT NKUKT_SELECT}<br />(年金受取人（選択）)</td><td align="center">○</td><td>{@link #HONNIN}</td><td>&quot;1&quot;</td><td>本人</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HGU}</td><td>&quot;2&quot;</td><td>配偶者</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #OYA}</td><td>&quot;3&quot;</td><td>親</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KO}</td><td>&quot;4&quot;</td><td>子</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SHB}</td><td>&quot;5&quot;</td><td>祖父母</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KYDSM}</td><td>&quot;6&quot;</td><td>兄弟姉妹</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MAGO}</td><td>&quot;7&quot;</td><td>孫</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KYN}</td><td>&quot;8&quot;</td><td>雇用主</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HTSZN}</td><td>&quot;9&quot;</td><td>法定相続人</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SONOTA}</td><td>&quot;99&quot;</td><td>その他</td></tr>
 *  <tr><td rowspan="9">{@link #PATTERN_NKUKT_SELNOHON NKUKT_SELNOHON}<br />(年金受取人（選択・本人なし）)</td><td align="center">○</td><td>{@link #HGU}</td><td>&quot;2&quot;</td><td>配偶者</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #OYA}</td><td>&quot;3&quot;</td><td>親</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KO}</td><td>&quot;4&quot;</td><td>子</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SHB}</td><td>&quot;5&quot;</td><td>祖父母</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KYDSM}</td><td>&quot;6&quot;</td><td>兄弟姉妹</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MAGO}</td><td>&quot;7&quot;</td><td>孫</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KYN}</td><td>&quot;8&quot;</td><td>雇用主</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HTSZN}</td><td>&quot;9&quot;</td><td>法定相続人</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SONOTA}</td><td>&quot;99&quot;</td><td>その他</td></tr>
 *  <tr><td rowspan="8">{@link #PATTERN_SBUKT SBUKT}<br />(死亡受取人)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HGU}</td><td>&quot;2&quot;</td><td>配偶者</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KO}</td><td>&quot;4&quot;</td><td>子</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #OYA}</td><td>&quot;3&quot;</td><td>親</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MAGO}</td><td>&quot;7&quot;</td><td>孫</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SHB}</td><td>&quot;5&quot;</td><td>祖父母</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KYDSM}</td><td>&quot;6&quot;</td><td>兄弟姉妹</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SONOTA}</td><td>&quot;99&quot;</td><td>その他</td></tr>
 *  <tr><td rowspan="10">{@link #PATTERN_SKSBHNKN SKSBHNKN}<br />(新契約　死亡返還金受取人)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HGU}</td><td>&quot;2&quot;</td><td>配偶者</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #OYA}</td><td>&quot;3&quot;</td><td>親</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KO}</td><td>&quot;4&quot;</td><td>子</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SHB}</td><td>&quot;5&quot;</td><td>祖父母</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KYDSM}</td><td>&quot;6&quot;</td><td>兄弟姉妹</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MAGO}</td><td>&quot;7&quot;</td><td>孫</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KYN}</td><td>&quot;8&quot;</td><td>雇用主</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HTSZN}</td><td>&quot;9&quot;</td><td>法定相続人</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SONOTA}</td><td>&quot;99&quot;</td><td>その他</td></tr>
 *  <tr><td rowspan="11">{@link #PATTERN_KYKSYA KYKSYA}<br />(契約者続柄)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HONNIN}</td><td>&quot;1&quot;</td><td>本人</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HGU}</td><td>&quot;2&quot;</td><td>配偶者</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KO}</td><td>&quot;4&quot;</td><td>子</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #OYA}</td><td>&quot;3&quot;</td><td>親</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MAGO}</td><td>&quot;7&quot;</td><td>孫</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SHB}</td><td>&quot;5&quot;</td><td>祖父母</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KYDSM}</td><td>&quot;6&quot;</td><td>兄弟姉妹</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KYN}</td><td>&quot;8&quot;</td><td>雇用主</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HTSZN}</td><td>&quot;9&quot;</td><td>法定相続人</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SONOTA}</td><td>&quot;99&quot;</td><td>その他</td></tr>
 *  <tr><td rowspan="9">{@link #PATTERN_STDR STDR}<br />(指定代理請求人続柄)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HGU}</td><td>&quot;2&quot;</td><td>配偶者</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KO}</td><td>&quot;4&quot;</td><td>子</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #OYA}</td><td>&quot;3&quot;</td><td>親</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MAGO}</td><td>&quot;7&quot;</td><td>孫</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SHB}</td><td>&quot;5&quot;</td><td>祖父母</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KYDSM}</td><td>&quot;6&quot;</td><td>兄弟姉妹</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SINTOU3}</td><td>&quot;10&quot;</td><td>３親等の親族</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SONOTA}</td><td>&quot;99&quot;</td><td>その他</td></tr>
 *  <tr><td rowspan="7">{@link #PATTERN_SBHNKN SBHNKN}<br />(死亡返還金受取人続柄)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HGU}</td><td>&quot;2&quot;</td><td>配偶者</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #OYA}</td><td>&quot;3&quot;</td><td>親</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KO}</td><td>&quot;4&quot;</td><td>子</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SHB}</td><td>&quot;5&quot;</td><td>祖父母</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KYDSM}</td><td>&quot;6&quot;</td><td>兄弟姉妹</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MAGO}</td><td>&quot;7&quot;</td><td>孫</td></tr>
 *  <tr><td rowspan="11">{@link #PATTERN_MKUKT MKUKT}<br />(満期受取人)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HONNIN}</td><td>&quot;1&quot;</td><td>本人</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HGU}</td><td>&quot;2&quot;</td><td>配偶者</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #OYA}</td><td>&quot;3&quot;</td><td>親</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KO}</td><td>&quot;4&quot;</td><td>子</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SHB}</td><td>&quot;5&quot;</td><td>祖父母</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KYDSM}</td><td>&quot;6&quot;</td><td>兄弟姉妹</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MAGO}</td><td>&quot;7&quot;</td><td>孫</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KYN}</td><td>&quot;8&quot;</td><td>雇用主</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HTSZN}</td><td>&quot;9&quot;</td><td>法定相続人</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SONOTA}</td><td>&quot;99&quot;</td><td>その他</td></tr>
 *  <tr><td rowspan="8">{@link #PATTERN_KYK_NOHON KYK_NOHON}<br />(契約者続柄（本人・法人なし）)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HGU}</td><td>&quot;2&quot;</td><td>配偶者</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KO}</td><td>&quot;4&quot;</td><td>子</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #OYA}</td><td>&quot;3&quot;</td><td>親</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MAGO}</td><td>&quot;7&quot;</td><td>孫</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SHB}</td><td>&quot;5&quot;</td><td>祖父母</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KYDSM}</td><td>&quot;6&quot;</td><td>兄弟姉妹</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SONOTA}</td><td>&quot;99&quot;</td><td>その他</td></tr>
 *  <tr><td rowspan="9">{@link #PATTERN_KYK_NOHJ KYK_NOHJ}<br />(契約者続柄（法人なし）)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HONNIN}</td><td>&quot;1&quot;</td><td>本人</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HGU}</td><td>&quot;2&quot;</td><td>配偶者</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KO}</td><td>&quot;4&quot;</td><td>子</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #OYA}</td><td>&quot;3&quot;</td><td>親</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MAGO}</td><td>&quot;7&quot;</td><td>孫</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SHB}</td><td>&quot;5&quot;</td><td>祖父母</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KYDSM}</td><td>&quot;6&quot;</td><td>兄弟姉妹</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SONOTA}</td><td>&quot;99&quot;</td><td>その他</td></tr>
 *  <tr><td rowspan="12">{@link #PATTERN_SYOUKAI SYOUKAI}<br />(照会画面用)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HONNIN}</td><td>&quot;1&quot;</td><td>本人</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HGU}</td><td>&quot;2&quot;</td><td>配偶者</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KO}</td><td>&quot;4&quot;</td><td>子</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #OYA}</td><td>&quot;3&quot;</td><td>親</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MAGO}</td><td>&quot;7&quot;</td><td>孫</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SHB}</td><td>&quot;5&quot;</td><td>祖父母</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KYDSM}</td><td>&quot;6&quot;</td><td>兄弟姉妹</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KYN}</td><td>&quot;8&quot;</td><td>雇用主</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HTSZN}</td><td>&quot;9&quot;</td><td>法定相続人</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SINTOU3}</td><td>&quot;10&quot;</td><td>３親等の親族</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SONOTA}</td><td>&quot;99&quot;</td><td>その他</td></tr>
 *  <tr><td rowspan="9">{@link #PATTERN_TRKKZK TRKKZK}<br />(登録家族続柄)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HGU}</td><td>&quot;2&quot;</td><td>配偶者</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KO}</td><td>&quot;4&quot;</td><td>子</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MAGO}</td><td>&quot;7&quot;</td><td>孫</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KYDSM}</td><td>&quot;6&quot;</td><td>兄弟姉妹</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #OYA}</td><td>&quot;3&quot;</td><td>親</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SINTOU3}</td><td>&quot;10&quot;</td><td>３親等の親族</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SHB}</td><td>&quot;5&quot;</td><td>祖父母</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SONOTA}</td><td>&quot;99&quot;</td><td>その他</td></tr>
 *  <tr><td rowspan="9">{@link #PATTERN_KYKSYADR KYKSYADR}<br />(契約者代理続柄)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HGU}</td><td>&quot;2&quot;</td><td>配偶者</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KO}</td><td>&quot;4&quot;</td><td>子</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MAGO}</td><td>&quot;7&quot;</td><td>孫</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KYDSM}</td><td>&quot;6&quot;</td><td>兄弟姉妹</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #OIMEI}</td><td>&quot;11&quot;</td><td>甥姪</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #GIRIKO}</td><td>&quot;12&quot;</td><td>義理の子</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #OYA}</td><td>&quot;3&quot;</td><td>親</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SONOTA}</td><td>&quot;99&quot;</td><td>その他</td></tr>
 * </table>
 */
public class C_Tdk extends Classification<C_Tdk> {

    private static final long serialVersionUID = 1L;


    public static final C_Tdk BLNK = new C_Tdk("0");

    public static final C_Tdk HONNIN = new C_Tdk("1");

    public static final C_Tdk HGU = new C_Tdk("2");

    public static final C_Tdk OYA = new C_Tdk("3");

    public static final C_Tdk KO = new C_Tdk("4");

    public static final C_Tdk SHB = new C_Tdk("5");

    public static final C_Tdk KYDSM = new C_Tdk("6");

    public static final C_Tdk MAGO = new C_Tdk("7");

    public static final C_Tdk KYN = new C_Tdk("8");

    public static final C_Tdk HTSZN = new C_Tdk("9");

    public static final C_Tdk SINTOU3 = new C_Tdk("10");

    public static final C_Tdk OIMEI = new C_Tdk("11");

    public static final C_Tdk GIRIKO = new C_Tdk("12");

    public static final C_Tdk SONOTA = new C_Tdk("99");


    public static final String PATTERN_DEFAULT = "1";

    public static final String PATTERN_KZNKUKT = "2";

    public static final String PATTERN_MOSUKE = "3";

    public static final String PATTERN_NKUKT = "4";

    public static final String PATTERN_NKUKT_SELECT = "5";

    public static final String PATTERN_NKUKT_SELNOHON = "6";

    public static final String PATTERN_SBUKT = "7";

    public static final String PATTERN_SKSBHNKN = "8";

    public static final String PATTERN_KYKSYA = "9";

    public static final String PATTERN_STDR = "10";

    public static final String PATTERN_SBHNKN = "11";

    public static final String PATTERN_MKUKT = "12";

    public static final String PATTERN_KYK_NOHON = "13";

    public static final String PATTERN_KYK_NOHJ = "14";

    public static final String PATTERN_SYOUKAI = "15";

    public static final String PATTERN_TRKKZK = "16";

    public static final String PATTERN_KYKSYADR = "17";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, HONNIN, "HONNIN", false);
        addPattern(PATTERN_DEFAULT, HGU, "HGU", false);
        addPattern(PATTERN_DEFAULT, OYA, "OYA", false);
        addPattern(PATTERN_DEFAULT, KO, "KO", false);
        addPattern(PATTERN_DEFAULT, SHB, "SHB", false);
        addPattern(PATTERN_DEFAULT, KYDSM, "KYDSM", false);
        addPattern(PATTERN_DEFAULT, MAGO, "MAGO", false);
        addPattern(PATTERN_DEFAULT, KYN, "KYN", false);
        addPattern(PATTERN_DEFAULT, HTSZN, "HTSZN", false);
        addPattern(PATTERN_DEFAULT, SINTOU3, "SINTOU3", false);
        addPattern(PATTERN_DEFAULT, OIMEI, "OIMEI", false);
        addPattern(PATTERN_DEFAULT, GIRIKO, "GIRIKO", false);
        addPattern(PATTERN_DEFAULT, SONOTA, "SONOTA", false);


        addPattern(PATTERN_KZNKUKT, BLNK, "BLNK", false);
        addPattern(PATTERN_KZNKUKT, HGU, "HGU", false);
        addPattern(PATTERN_KZNKUKT, OYA, "OYA", false);
        addPattern(PATTERN_KZNKUKT, KO, "KO", false);
        addPattern(PATTERN_KZNKUKT, SHB, "SHB", false);
        addPattern(PATTERN_KZNKUKT, KYDSM, "KYDSM", false);
        addPattern(PATTERN_KZNKUKT, MAGO, "MAGO", false);
        addPattern(PATTERN_KZNKUKT, SONOTA, "SONOTA", false);


        addPattern(PATTERN_MOSUKE, BLNK, "BLNK", false);
        addPattern(PATTERN_MOSUKE, HGU, "HGU", false);
        addPattern(PATTERN_MOSUKE, OYA, "OYA", false);
        addPattern(PATTERN_MOSUKE, KO, "KO", false);
        addPattern(PATTERN_MOSUKE, SHB, "SHB", false);
        addPattern(PATTERN_MOSUKE, KYDSM, "KYDSM", false);
        addPattern(PATTERN_MOSUKE, MAGO, "MAGO", false);
        addPattern(PATTERN_MOSUKE, KYN, "KYN", false);
        addPattern(PATTERN_MOSUKE, HTSZN, "HTSZN", false);
        addPattern(PATTERN_MOSUKE, SONOTA, "SONOTA", false);


        addPattern(PATTERN_NKUKT, BLNK, "BLNK", false);
        addPattern(PATTERN_NKUKT, HONNIN, "HONNIN", false);
        addPattern(PATTERN_NKUKT, HGU, "HGU", false);
        addPattern(PATTERN_NKUKT, OYA, "OYA", false);
        addPattern(PATTERN_NKUKT, KO, "KO", false);
        addPattern(PATTERN_NKUKT, SHB, "SHB", false);
        addPattern(PATTERN_NKUKT, KYDSM, "KYDSM", false);
        addPattern(PATTERN_NKUKT, MAGO, "MAGO", false);
        addPattern(PATTERN_NKUKT, KYN, "KYN", false);
        addPattern(PATTERN_NKUKT, HTSZN, "HTSZN", false);
        addPattern(PATTERN_NKUKT, SONOTA, "SONOTA", false);


        addPattern(PATTERN_NKUKT_SELECT, HONNIN, "HONNIN", true);
        addPattern(PATTERN_NKUKT_SELECT, HGU, "HGU", false);
        addPattern(PATTERN_NKUKT_SELECT, OYA, "OYA", false);
        addPattern(PATTERN_NKUKT_SELECT, KO, "KO", false);
        addPattern(PATTERN_NKUKT_SELECT, SHB, "SHB", false);
        addPattern(PATTERN_NKUKT_SELECT, KYDSM, "KYDSM", false);
        addPattern(PATTERN_NKUKT_SELECT, MAGO, "MAGO", false);
        addPattern(PATTERN_NKUKT_SELECT, KYN, "KYN", false);
        addPattern(PATTERN_NKUKT_SELECT, HTSZN, "HTSZN", false);
        addPattern(PATTERN_NKUKT_SELECT, SONOTA, "SONOTA", false);


        addPattern(PATTERN_NKUKT_SELNOHON, HGU, "HGU", true);
        addPattern(PATTERN_NKUKT_SELNOHON, OYA, "OYA", false);
        addPattern(PATTERN_NKUKT_SELNOHON, KO, "KO", false);
        addPattern(PATTERN_NKUKT_SELNOHON, SHB, "SHB", false);
        addPattern(PATTERN_NKUKT_SELNOHON, KYDSM, "KYDSM", false);
        addPattern(PATTERN_NKUKT_SELNOHON, MAGO, "MAGO", false);
        addPattern(PATTERN_NKUKT_SELNOHON, KYN, "KYN", false);
        addPattern(PATTERN_NKUKT_SELNOHON, HTSZN, "HTSZN", false);
        addPattern(PATTERN_NKUKT_SELNOHON, SONOTA, "SONOTA", false);


        addPattern(PATTERN_SBUKT, BLNK, "BLNK", true);
        addPattern(PATTERN_SBUKT, HGU, "HGU", false);
        addPattern(PATTERN_SBUKT, KO, "KO", false);
        addPattern(PATTERN_SBUKT, OYA, "OYA", false);
        addPattern(PATTERN_SBUKT, MAGO, "MAGO", false);
        addPattern(PATTERN_SBUKT, SHB, "SHB", false);
        addPattern(PATTERN_SBUKT, KYDSM, "KYDSM", false);
        addPattern(PATTERN_SBUKT, SONOTA, "SONOTA", false);


        addPattern(PATTERN_SKSBHNKN, BLNK, "BLNK", true);
        addPattern(PATTERN_SKSBHNKN, HGU, "HGU", false);
        addPattern(PATTERN_SKSBHNKN, OYA, "OYA", false);
        addPattern(PATTERN_SKSBHNKN, KO, "KO", false);
        addPattern(PATTERN_SKSBHNKN, SHB, "SHB", false);
        addPattern(PATTERN_SKSBHNKN, KYDSM, "KYDSM", false);
        addPattern(PATTERN_SKSBHNKN, MAGO, "MAGO", false);
        addPattern(PATTERN_SKSBHNKN, KYN, "KYN", false);
        addPattern(PATTERN_SKSBHNKN, HTSZN, "HTSZN", false);
        addPattern(PATTERN_SKSBHNKN, SONOTA, "SONOTA", false);


        addPattern(PATTERN_KYKSYA, BLNK, "BLNK", true);
        addPattern(PATTERN_KYKSYA, HONNIN, "HONNIN", false);
        addPattern(PATTERN_KYKSYA, HGU, "HGU", false);
        addPattern(PATTERN_KYKSYA, KO, "KO", false);
        addPattern(PATTERN_KYKSYA, OYA, "OYA", false);
        addPattern(PATTERN_KYKSYA, MAGO, "MAGO", false);
        addPattern(PATTERN_KYKSYA, SHB, "SHB", false);
        addPattern(PATTERN_KYKSYA, KYDSM, "KYDSM", false);
        addPattern(PATTERN_KYKSYA, KYN, "KYN", false);
        addPattern(PATTERN_KYKSYA, HTSZN, "HTSZN", false);
        addPattern(PATTERN_KYKSYA, SONOTA, "SONOTA", false);


        addPattern(PATTERN_STDR, BLNK, "BLNK", true);
        addPattern(PATTERN_STDR, HGU, "HGU", false);
        addPattern(PATTERN_STDR, KO, "KO", false);
        addPattern(PATTERN_STDR, OYA, "OYA", false);
        addPattern(PATTERN_STDR, MAGO, "MAGO", false);
        addPattern(PATTERN_STDR, SHB, "SHB", false);
        addPattern(PATTERN_STDR, KYDSM, "KYDSM", false);
        addPattern(PATTERN_STDR, SINTOU3, "SINTOU3", false);
        addPattern(PATTERN_STDR, SONOTA, "SONOTA", false);


        addPattern(PATTERN_SBHNKN, BLNK, "BLNK", true);
        addPattern(PATTERN_SBHNKN, HGU, "HGU", false);
        addPattern(PATTERN_SBHNKN, OYA, "OYA", false);
        addPattern(PATTERN_SBHNKN, KO, "KO", false);
        addPattern(PATTERN_SBHNKN, SHB, "SHB", false);
        addPattern(PATTERN_SBHNKN, KYDSM, "KYDSM", false);
        addPattern(PATTERN_SBHNKN, MAGO, "MAGO", false);


        addPattern(PATTERN_MKUKT, BLNK, "BLNK", true);
        addPattern(PATTERN_MKUKT, HONNIN, "HONNIN", false);
        addPattern(PATTERN_MKUKT, HGU, "HGU", false);
        addPattern(PATTERN_MKUKT, OYA, "OYA", false);
        addPattern(PATTERN_MKUKT, KO, "KO", false);
        addPattern(PATTERN_MKUKT, SHB, "SHB", false);
        addPattern(PATTERN_MKUKT, KYDSM, "KYDSM", false);
        addPattern(PATTERN_MKUKT, MAGO, "MAGO", false);
        addPattern(PATTERN_MKUKT, KYN, "KYN", false);
        addPattern(PATTERN_MKUKT, HTSZN, "HTSZN", false);
        addPattern(PATTERN_MKUKT, SONOTA, "SONOTA", false);


        addPattern(PATTERN_KYK_NOHON, BLNK, "BLNK", true);
        addPattern(PATTERN_KYK_NOHON, HGU, "HGU", false);
        addPattern(PATTERN_KYK_NOHON, KO, "KO", false);
        addPattern(PATTERN_KYK_NOHON, OYA, "OYA", false);
        addPattern(PATTERN_KYK_NOHON, MAGO, "MAGO", false);
        addPattern(PATTERN_KYK_NOHON, SHB, "SHB", false);
        addPattern(PATTERN_KYK_NOHON, KYDSM, "KYDSM", false);
        addPattern(PATTERN_KYK_NOHON, SONOTA, "SONOTA", false);


        addPattern(PATTERN_KYK_NOHJ, BLNK, "BLNK", true);
        addPattern(PATTERN_KYK_NOHJ, HONNIN, "HONNIN", false);
        addPattern(PATTERN_KYK_NOHJ, HGU, "HGU", false);
        addPattern(PATTERN_KYK_NOHJ, KO, "KO", false);
        addPattern(PATTERN_KYK_NOHJ, OYA, "OYA", false);
        addPattern(PATTERN_KYK_NOHJ, MAGO, "MAGO", false);
        addPattern(PATTERN_KYK_NOHJ, SHB, "SHB", false);
        addPattern(PATTERN_KYK_NOHJ, KYDSM, "KYDSM", false);
        addPattern(PATTERN_KYK_NOHJ, SONOTA, "SONOTA", false);


        addPattern(PATTERN_SYOUKAI, BLNK, "BLNK", true);
        addPattern(PATTERN_SYOUKAI, HONNIN, "HONNIN", false);
        addPattern(PATTERN_SYOUKAI, HGU, "HGU", false);
        addPattern(PATTERN_SYOUKAI, KO, "KO", false);
        addPattern(PATTERN_SYOUKAI, OYA, "OYA", false);
        addPattern(PATTERN_SYOUKAI, MAGO, "MAGO", false);
        addPattern(PATTERN_SYOUKAI, SHB, "SHB", false);
        addPattern(PATTERN_SYOUKAI, KYDSM, "KYDSM", false);
        addPattern(PATTERN_SYOUKAI, KYN, "KYN", false);
        addPattern(PATTERN_SYOUKAI, HTSZN, "HTSZN", false);
        addPattern(PATTERN_SYOUKAI, SINTOU3, "SINTOU3", false);
        addPattern(PATTERN_SYOUKAI, SONOTA, "SONOTA", false);


        addPattern(PATTERN_TRKKZK, BLNK, "BLNK", true);
        addPattern(PATTERN_TRKKZK, HGU, "HGU", false);
        addPattern(PATTERN_TRKKZK, KO, "KO", false);
        addPattern(PATTERN_TRKKZK, MAGO, "MAGO", false);
        addPattern(PATTERN_TRKKZK, KYDSM, "KYDSM", false);
        addPattern(PATTERN_TRKKZK, OYA, "OYA", false);
        addPattern(PATTERN_TRKKZK, SINTOU3, "SINTOU3", false);
        addPattern(PATTERN_TRKKZK, SHB, "SHB", false);
        addPattern(PATTERN_TRKKZK, SONOTA, "SONOTA", false);


        addPattern(PATTERN_KYKSYADR, BLNK, "BLNK", true);
        addPattern(PATTERN_KYKSYADR, HGU, "HGU", false);
        addPattern(PATTERN_KYKSYADR, KO, "KO", false);
        addPattern(PATTERN_KYKSYADR, MAGO, "MAGO", false);
        addPattern(PATTERN_KYKSYADR, KYDSM, "KYDSM", false);
        addPattern(PATTERN_KYKSYADR, OIMEI, "OIMEI", false);
        addPattern(PATTERN_KYKSYADR, GIRIKO, "GIRIKO", false);
        addPattern(PATTERN_KYKSYADR, OYA, "OYA", false);
        addPattern(PATTERN_KYKSYADR, SONOTA, "SONOTA", false);


        lock(C_Tdk.class);
    }

    private C_Tdk(String value) {
        super(value);
    }

    public static C_Tdk valueOf(String value) {
        return valueOf(C_Tdk.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_Tdk.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_Tdk.class, patternId, value);
    }
}
