
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 書類コード区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_SyoruiCdKbn</td><td colspan="3">書類コード区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="579">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #WF_HYOUSI}</td><td>&quot;wf001&quot;</td><td>取込用表紙</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #WF_QRSEAL}</td><td>&quot;wf002&quot;</td><td>QRシール</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #USERITIRANHYOU}</td><td>&quot;Ba001&quot;</td><td>ユーザー一覧表</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #CM_JIMURENRAKUHYOU}</td><td>&quot;cm001&quot;</td><td>事務連絡票</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #CM_LINC_MISSLIST}</td><td>&quot;cm002&quot;</td><td>契約管理ＬＩＮＣ受信ミスリスト</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #CM_ONLINE_FBFURIKOMIKEI_1}</td><td>&quot;cm003&quot;</td><td>オンラインＦＢ振込合計リスト１</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #CM_ONLINE_FBFURIKOMIKEI_2}</td><td>&quot;cm004&quot;</td><td>オンラインＦＢ振込合計リスト２</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #CM_ONLINE_GKFBFURIKOMIKEI_1}</td><td>&quot;cm005&quot;</td><td>オンライン外貨ＦＢ振込合計リスト１</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #CM_ONLINE_GKFBFURIKOMIKEI_2}</td><td>&quot;cm006&quot;</td><td>オンライン外貨ＦＢ振込合計リスト２</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #CM_ONLINE_FBSOUKINMEISAI_1}</td><td>&quot;cm007&quot;</td><td>オンラインＦＢ送金明細リスト１</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #CM_ONLINE_FBSOUKINMEISAI_2}</td><td>&quot;cm008&quot;</td><td>オンラインＦＢ送金明細リスト２</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #CM_ONLINE_FBSOUKINMEISAI_3}</td><td>&quot;cm009&quot;</td><td>オンラインＦＢ送金明細リスト３</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #CM_ONLINE_FBSOUKINMEISAI_4}</td><td>&quot;cm010&quot;</td><td>オンラインＦＢ送金明細リスト４</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #CM_ONLINE_FBSOUKINMEISAI_5}</td><td>&quot;cm011&quot;</td><td>オンラインＦＢ送金明細リスト５</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #CM_ONLINE_GKFBSOUKINMEISAI_1}</td><td>&quot;cm012&quot;</td><td>オンライン外貨ＦＢ送金明細リスト１</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #CM_ONLINE_GKFBSOUKINMEISAI_2}</td><td>&quot;cm013&quot;</td><td>オンライン外貨ＦＢ送金明細リスト２</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #CM_ONLINE_GKFBSOUKINMEISAI_3}</td><td>&quot;cm014&quot;</td><td>オンライン外貨ＦＢ送金明細リスト３</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #CM_ONLINE_GKFBSOUKINMEISAI_4}</td><td>&quot;cm015&quot;</td><td>オンライン外貨ＦＢ送金明細リスト４</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #CM_ONLINE_GKFBSOUKINMEISAI_5}</td><td>&quot;cm016&quot;</td><td>オンライン外貨ＦＢ送金明細リスト５</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #CM_BATCH_FBFURIKOMIKEI_4}</td><td>&quot;cm017&quot;</td><td>バッチＦＢ振込合計リスト４</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #CM_BATCH_GKFBFURIKOMIKEI}</td><td>&quot;cm018&quot;</td><td>バッチ外貨ＦＢ振込合計リスト</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #CM_BATCH_FBSOUKINMEISAI_4}</td><td>&quot;cm019&quot;</td><td>バッチＦＢ送金明細リスト４</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #CM_BATCH_GKFBSOUKINMEISAI}</td><td>&quot;cm020&quot;</td><td>バッチ外貨ＦＢ送金明細リスト</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #CM_TIENRSKUTIWAKELIST}</td><td>&quot;cm021&quot;</td><td>支払遅延利息内訳リスト</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #CM_SKHONSYADENPYOULIST}</td><td>&quot;cm022&quot;</td><td>新契約本社用伝票リスト</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #CM_KARIUKEMEISAI_1}</td><td>&quot;cm023&quot;</td><td>仮受計上明細リスト１</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #CM_KARIUKEMEISAI_2}</td><td>&quot;cm024&quot;</td><td>仮受計上明細リスト２</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #CM_KARIUKEMEISAI_3}</td><td>&quot;cm025&quot;</td><td>仮受計上明細リスト３</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #CM_KARIUKEMEISAI_4}</td><td>&quot;cm026&quot;</td><td>仮受計上明細リスト４</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #CM_SIKINIDOULIST_SOKUJI}</td><td>&quot;cm027&quot;</td><td>資金移動リスト（即時分）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #CM_SIKINIDOULIST_TYAKKINBI}</td><td>&quot;cm028&quot;</td><td>資金移動リスト（着金日分）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #CM_HURIKOMIERRINFOLIST}</td><td>&quot;cm029&quot;</td><td>振込入金Ｆエラー情報リスト</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #CM_GKHURIKOMIERRINFOLIST}</td><td>&quot;cm030&quot;</td><td>外貨振込入金Ｆエラー情報リスト</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #CM_HOJYOBOLIST_1}</td><td>&quot;cm031&quot;</td><td>補助簿リスト１</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #CM_HOJYOBOLIST_2}</td><td>&quot;cm032&quot;</td><td>補助簿リスト２</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #CM_HOJYOBOLIST_3}</td><td>&quot;cm033&quot;</td><td>補助簿リスト３</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #CM_HOJYOBOLIST_4}</td><td>&quot;cm034&quot;</td><td>補助簿リスト４</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #CM_HOJYOBOLIST_5}</td><td>&quot;cm035&quot;</td><td>補助簿リスト５</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #CM_HURIDEN}</td><td>&quot;cm036&quot;</td><td>振替伝票</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #CM_HURIDEN_HIKAE}</td><td>&quot;cm037&quot;</td><td>振替伝票（控）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #CM_SK_HURIDEN}</td><td>&quot;cm038&quot;</td><td>新契約振替伝票</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #CM_SK_HURIDEN_HIKAE}</td><td>&quot;cm039&quot;</td><td>新契約振替伝票（控）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #CM_RATEDBSYOUKAIKEKKA}</td><td>&quot;cm040&quot;</td><td>検証用レートＤＢ照会結果</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #BZ_JIGYOUHIKANJYOUKAKUSYOULIST_1}</td><td>&quot;cm041&quot;</td><td>事業費勘定確証リスト1</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #BZ_JIGYOUHIKANJYOUKAKUSYOULIST_2}</td><td>&quot;cm042&quot;</td><td>事業費勘定確証リスト2</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #CM_TUUSANKAWASERATEKAKUNIN}</td><td>&quot;cm043&quot;</td><td>通算判定用為替レート確認書</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #CM_HOJYOBOLIST_6}</td><td>&quot;cm044&quot;</td><td>補助簿リスト６</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #CM_KARIUKEMEISAI_5}</td><td>&quot;cm045&quot;</td><td>仮受計上明細リスト５</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #CM_ONLINE_FBSOUKINMEISAI_6}</td><td>&quot;cm046&quot;</td><td>オンラインＦＢ送金明細リスト６</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #CM_SIKINIDOULIST_YENDTHNK}</td><td>&quot;cm047&quot;</td><td>資金移動リスト（円建変更分）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #CM_BATCH_FBSOUKINMEISAI_7}</td><td>&quot;cm048&quot;</td><td>バッチＦＢ送金明細リスト７</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #CM_ONLINE_FBSOUKINMEISAI_7}</td><td>&quot;cm049&quot;</td><td>オンラインＦＢ送金明細リスト７</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #CM_MYNUMBERTYUUSYUTULIST}</td><td>&quot;cm050&quot;</td><td>マイナンバー帳票抽出リスト</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #CM_HOJYOBOLIST_7}</td><td>&quot;cm051&quot;</td><td>補助簿リスト７</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #CM_KBTKARIKANJYOUZNDKSYUKILIST}</td><td>&quot;cm052&quot;</td><td>個別仮勘定残高集計リスト</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #CM_SIKINIDOULIST_HIJYNNYK}</td><td>&quot;cm053&quot;</td><td>資金移動リスト（平準払入金分）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #CM_BATCH_FBFURIKOMIKEI_2}</td><td>&quot;cm054&quot;</td><td>バッチＦＢ振込合計リスト２</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #CM_BATCH_FBSOUKINMEISAI_2}</td><td>&quot;cm055&quot;</td><td>バッチＦＢ送金明細リスト２</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #CM_SIKINIDOULIST_HTKIN}</td><td>&quot;cm056&quot;</td><td>資金移動リスト（配当金分）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #CM_KARIUKEMEISAI_6}</td><td>&quot;cm057&quot;</td><td>仮受計上明細リスト６</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #CM_BATCH_FBFURIKOMIKEI_3}</td><td>&quot;cm058&quot;</td><td>バッチＦＢ振込合計リスト３</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #CM_BATCH_FBSOUKINMEISAI_3}</td><td>&quot;cm059&quot;</td><td>バッチＦＢ送金明細リスト３</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #CM_HOJYOBOLIST}</td><td>&quot;cm099&quot;</td><td>補助簿リスト</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #DS_KARIPWTUUTITYUUDANLIST}</td><td>&quot;ds001&quot;</td><td>仮パスワード通知作成中断リスト</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #DS_KOUZOKUJIMUKAKUNINLIST}</td><td>&quot;ds011&quot;</td><td>ＤＳ後続事務確認リスト</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HK_SHRMESS}</td><td>&quot;hk001&quot;</td><td>支払明細書</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HK_SHMEISAI_SDS}</td><td>&quot;hk003&quot;</td><td>支払明細書（診断書料）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HK_SB_HOKEN_SKS}</td><td>&quot;hk011&quot;</td><td>死亡保険金請求書</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HK_SEISANKINHRKM_IRAIS}</td><td>&quot;hk015&quot;</td><td>精算金振込依頼書</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HK_SB_DAIHYOU}</td><td>&quot;hk031&quot;</td><td>代表選任届</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HK_KD_JIKOJKS}</td><td>&quot;hk041&quot;</td><td>事故状況報告書</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HK_JIJYOUTODOKEKENSEIYAKUSYO}</td><td>&quot;hk051&quot;</td><td>事情届兼誓約書</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HK_TEISYUTUSYORUI}</td><td>&quot;hk061&quot;</td><td>ご提出書類について</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HK_MYNUMBER_CHYOU}</td><td>&quot;hk082&quot;</td><td>マイナンバーＣ票</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HK_SOUHU}</td><td>&quot;hk090&quot;</td><td>送付案内</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HK_STI_KAS}</td><td>&quot;hk101&quot;</td><td>死亡診断書（死体検案書）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HK_SB_SONOTA_SDS}</td><td>&quot;hk102&quot;</td><td>その他診断書類</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HK_SB_KTJKSMS}</td><td>&quot;hk104&quot;</td><td>交通事故証明書</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HK_SB_HKNSYKN}</td><td>&quot;hk106&quot;</td><td>保険証券</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HK_SB_KOSEKI}</td><td>&quot;hk108&quot;</td><td>戸籍謄（抄）本</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HK_SB_HONNINSR}</td><td>&quot;hk110&quot;</td><td>本人確認書類</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HK_SB_JYUUMIN}</td><td>&quot;hk112&quot;</td><td>住民票</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HK_SB_INKAN}</td><td>&quot;hk114&quot;</td><td>印鑑証明書</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HK_SB_KAKUNINDOUISYO}</td><td>&quot;hk116&quot;</td><td>確認書兼同意書</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HK_SB_SKKANSYOUKNK}</td><td>&quot;hk117&quot;</td><td>請求勧奨関係書類</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HK_MYNUMBER_SYORUI}</td><td>&quot;hk118&quot;</td><td>マイナンバー書類</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HK_SB_SONOTA_SKS}</td><td>&quot;hk131&quot;</td><td>その他請求書類</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HK_ENKASIHARAIRYUUIJIKOU}</td><td>&quot;hk201&quot;</td><td>円貨支払留意事項説明文書</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HK_SB_HUBITEISEI}</td><td>&quot;hk301&quot;</td><td>不備訂正書</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HK_SB_HUBITEISEI2}</td><td>&quot;hk303&quot;</td><td>不備訂正書（仮作成）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HK_HUBITEISEI_SOUHU}</td><td>&quot;hk311&quot;</td><td>不備訂正書の送付案内</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HK_SB_HUBIKNK}</td><td>&quot;hk321&quot;</td><td>不備関係書類</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HK_SB_KAKUNINIRAIS}</td><td>&quot;hk401&quot;</td><td>確認依頼書</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HK_SB_KAKUNINHKS}</td><td>&quot;hk411&quot;</td><td>確認報告書</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HK_BIKINSAGYOULIST}</td><td>&quot;hk501&quot;</td><td>保険金給付金備金作業リスト</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HK_BIKINJIKOUKIST}</td><td>&quot;hk502&quot;</td><td>保険金給付金備金時効リスト</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HK_BIKINJIKOUKIST_GOUKEI}</td><td>&quot;hk503&quot;</td><td>保険金給付金備金時効リスト合計表</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HK_ZENNOUSEISANKINMEISAILIST}</td><td>&quot;hk504&quot;</td><td>前納精算金明細リスト</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HK_JIKOUDENMEISAILIST}</td><td>&quot;hk505&quot;</td><td>時効伝票明細リスト</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HK_SB_SONOTA}</td><td>&quot;hk902&quot;</td><td>その他</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_ADRHNK_TTDKKR}</td><td>&quot;kk001&quot;</td><td>お手続き完了のお知らせ　住所変更</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_ADRHNK_GAIBU_TTDKKR}</td><td>&quot;kk002&quot;</td><td>お手続き完了のお知らせ　住所変更≪外部印刷≫</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_MEIGIHNK_TTDKKR}</td><td>&quot;kk003&quot;</td><td>お手続き完了のお知らせ　名義変更</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_STDRHNK_TTDKKR}</td><td>&quot;kk004&quot;</td><td>お手続き完了のお知らせ　被保険者代理特約中途付加</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_SEINENGAPPISEI_TTDKKR}</td><td>&quot;kk005&quot;</td><td>お手続き完了のお知らせ　生年月日・性訂正</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_GENGAKU_TTDKKR}</td><td>&quot;kk006&quot;</td><td>お手続き完了のお知らせ　減額</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_NKTKYKHNK_TTDKKR}</td><td>&quot;kk007&quot;</td><td>お手続き完了のお知らせ　年金支払特約変更</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_TARGETHNK_TTDKKR}</td><td>&quot;kk008&quot;</td><td>お手続き完了のお知らせ　ターゲット特約変更</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_TARGETHNK_GAIBU_TTDKKR}</td><td>&quot;kk009&quot;</td><td>お手続き完了のお知らせ　ターゲット特約変更≪外部印刷≫</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_KAIYAKU_TTDKKR}</td><td>&quot;kk010&quot;</td><td>お手続き完了のお知らせ　解約</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_KAIYAKU_GAIBU_TTDKKR}</td><td>&quot;kk011&quot;</td><td>お手続き完了のお知らせ　解約≪外部印刷≫</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_KAIYAKU_SAIKENSYA_TTDKKR}</td><td>&quot;kk012&quot;</td><td>お手続き完了のお知らせ　解約（債権者用）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_SHRKZHNK_TTDKKR}</td><td>&quot;kk013&quot;</td><td>お手続き完了のお知らせ　支払口座変更</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_SYOSAIHK_TTDKKR}</td><td>&quot;kk014&quot;</td><td>お手続き完了のお知らせ　証券再発行</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_KYKTRKS_KYKTRKSTTDKKR}</td><td>&quot;kk015&quot;</td><td>お手続き完了のお知らせ　契約取消（契約取消）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_CLGOFF_KYKTRKSTTDKKR}</td><td>&quot;kk016&quot;</td><td>お手続き完了のお知らせ　契約取消（クーリングオフ）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_KAIJYO_KYKTRKSTTDKKR}</td><td>&quot;kk017&quot;</td><td>お手続き完了のお知らせ　契約取消（解除）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_SBKAIJYO_KYKTRKSTTDKKR}</td><td>&quot;kk018&quot;</td><td>お手続き完了のお知らせ　契約取消（死亡解除）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_SBMENSEKI_KYKTRKSTTDKKR}</td><td>&quot;kk019&quot;</td><td>お手続き完了のお知らせ　契約取消（死亡免責）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_KAIGOMAETKHNK_TTDKKR}</td><td>&quot;kk020&quot;</td><td>お手続き完了のお知らせ　重度介護前払特約変更</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_SBMUKOU_KYKTRKSTTDKKR}</td><td>&quot;kk021&quot;</td><td>お手続き完了のお知らせ　契約取消（契約無効）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_MOUSIDEMUKOU_KYKTRKSTTDKKR}</td><td>&quot;kk022&quot;</td><td>お手続き完了のお知らせ　契約取消（申出無効）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_HRIHEN_TTDKKR}</td><td>&quot;kk023&quot;</td><td>お手続き完了のお知らせ　払方変更</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_HUKKATU_TTDKKR}</td><td>&quot;kk024&quot;</td><td>お手続き完了のお知らせ　復活</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_HUKKATU_OKOTOWARI}</td><td>&quot;kk025&quot;</td><td>お断り状　（謝絶通知）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_MKHGKHNK_TTDKKR}</td><td>&quot;kk026&quot;</td><td>お手続き完了のお知らせ　目標額変更</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_YENDTHNKHNRKN_TTDKKR}</td><td>&quot;kk027&quot;</td><td>お手続き完了のお知らせ　円建変更時返戻金</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_TUMITATEKINITEN_TTDKKR}</td><td>&quot;kk028&quot;</td><td>お手続き完了のお知らせ　積立金移転</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_YENDTHNK_HNRKNSKS_TTDKKR}</td><td>&quot;kk029&quot;</td><td>契約変更完了のお知らせ　円建終身変更（請求書同封）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_YENDTHNK_TTDKKR}</td><td>&quot;kk030&quot;</td><td>契約変更完了のお知らせ　円建終身変更</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_DSHR_TTDKKR}</td><td>&quot;kk031&quot;</td><td>お手続き完了のお知らせ　配当金支払</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_GENGAKU_ZEITEKI_TTDKKR}</td><td>&quot;kk032&quot;</td><td>お手続き完了のお知らせ　減額（税適付加）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_YENDTHNK_NINI_TTDKKR}</td><td>&quot;kk033&quot;</td><td>契約変更完了のお知らせ　円建年金変更（任意請求）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_SYOUMETU_GAIBU_TTDKKR}</td><td>&quot;kk034&quot;</td><td>お手続き完了のお知らせ　消滅</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_YENDTHNK_TTDKKR_2}</td><td>&quot;kk035&quot;</td><td>契約変更完了のお知らせ　円建年金変更</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_DTUIBARAI_TTDKKR}</td><td>&quot;kk036&quot;</td><td>お手続き完了のお知らせ　配当金追払</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_DTUIBARAI_TTDKKR_ZEIMUNASI}</td><td>&quot;kk037&quot;</td><td>お手続き完了のお知らせ　配当金追払（税務情報なし）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_KZKTRKKYKDRHNK_TTDKKR}</td><td>&quot;kk038&quot;</td><td>お手続き完了のお知らせ　家族登録・契約者代理特約変更</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_KZKTRKTYOKUSOU_TTDKKR}</td><td>&quot;kk039&quot;</td><td>お手続き完了のお知らせ　家族登録（直送）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_KZKTRKSKEI_TTDKKR}</td><td>&quot;kk040&quot;</td><td>お手続き完了のお知らせ　家族登録（新契約時）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_YENDTHNK_NINI_TTDKKR_2}</td><td>&quot;kk041&quot;</td><td>契約変更完了のお知らせ　円建終身変更（任意請求）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_YENDTHNK_TTDKKR_3}</td><td>&quot;kk042&quot;</td><td>契約変更完了のお知らせ　円建終身変更２</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_SEINENGAPPISEI_TTDKKR_SHRARI}</td><td>&quot;kk043&quot;</td><td>お手続き完了のお知らせ　生年月日・性訂正（支払あり）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_ADRHNK_SKS}</td><td>&quot;kk051&quot;</td><td>住所（電話番号）変更届出書</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_MEIGIHNK_SKS}</td><td>&quot;kk052&quot;</td><td>名義変更請求書</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_STDRHNK_SKS}</td><td>&quot;kk053&quot;</td><td>被保険者代理特約中途付加請求書</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_SEINENGAPPISEI_SKS}</td><td>&quot;kk054&quot;</td><td>生年月日・性訂正請求書</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_GENGAKU_SKS}</td><td>&quot;kk055&quot;</td><td>減額請求書</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_NKTKYKHNK_SKS}</td><td>&quot;kk056&quot;</td><td>年金支払特約変更請求書</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_TARGETHNK_SKS}</td><td>&quot;kk057&quot;</td><td>ターゲット特約変更請求書</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_KAIYAKU_SKS}</td><td>&quot;kk058&quot;</td><td>解約請求書</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_SHRKZHNK_SKS}</td><td>&quot;kk059&quot;</td><td>支払口座変更請求書</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_SYOSAIHK_SKS}</td><td>&quot;kk060&quot;</td><td>証券再発行請求書</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_KAIGOMAETKHNK_SKS}</td><td>&quot;kk061&quot;</td><td>重度介護前払特約変更請求書</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_KAIJYO_SKS}</td><td>&quot;kk062&quot;</td><td>精算金請求書（解除）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_SBKAIJYO_SKS}</td><td>&quot;kk063&quot;</td><td>精算金請求書（死亡解除）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_SBMENSEKI_SKS}</td><td>&quot;kk064&quot;</td><td>精算金請求書（免責）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_HRIHEN_SKS}</td><td>&quot;kk065&quot;</td><td>払込経路変更請求書</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_HRIKAIHEN_SKS}</td><td>&quot;kk066&quot;</td><td>払込回数変更請求書</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_HUKKATU_SKS}</td><td>&quot;kk067&quot;</td><td>復活請求書</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_MOUSIDEMUKOU_SKS}</td><td>&quot;kk068&quot;</td><td>申出無効請求書</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_GANMUKOU_SKS}</td><td>&quot;kk069&quot;</td><td>精算金請求書（がん無効）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_MKHGKHNK_SKS}</td><td>&quot;kk070&quot;</td><td>目標額変更請求書</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_YENDTHNKHNRKN_SKS}</td><td>&quot;kk071&quot;</td><td>円建変更時返戻金請求書</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_TUMITATEKINITEN_SKS}</td><td>&quot;kk072&quot;</td><td>積立金移転請求書</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_DSHR_SKS}</td><td>&quot;kk073&quot;</td><td>配当金支払請求書</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_YENDTHNK_SKS}</td><td>&quot;kk074&quot;</td><td>円建変更請求書</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_KZKTRKKYKDRTKYKHNK_SKS}</td><td>&quot;kk075&quot;</td><td>家族登録・契約者代理特約変更請求書</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_ADRHNK_SOUHU}</td><td>&quot;kk101&quot;</td><td>住所（電話番号）変更届出書の送付案内</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_MEIGIHNK_SOUHU}</td><td>&quot;kk102&quot;</td><td>名義変更請求書の送付案内</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_STDRHNK_SOUHU}</td><td>&quot;kk103&quot;</td><td>被保険者代理特約中途付加請求書の送付案内</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_SEINENGAPPISEI_SOUHU}</td><td>&quot;kk104&quot;</td><td>生年月日・性訂正請求書の送付案内</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_GENGAKU_SOUHU}</td><td>&quot;kk105&quot;</td><td>減額請求書の送付案内</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_NKTKYKHNK_SOUHU}</td><td>&quot;kk106&quot;</td><td>年金支払特約変更請求書の送付案内</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_TARGETHNK_SOUHU}</td><td>&quot;kk107&quot;</td><td>ターゲット特約変更請求書の送付案内</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_KAIYAKU_SKSSOUHU}</td><td>&quot;kk108&quot;</td><td>解約請求書の送付案内</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_SHRKZHNK_SOUHU}</td><td>&quot;kk109&quot;</td><td>支払口座変更請求書の送付案内</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_SYOSAIHK_SOUHU}</td><td>&quot;kk110&quot;</td><td>証券再発行請求書の送付案内</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_KAIGOMAETKHNK_SOUHU}</td><td>&quot;kk111&quot;</td><td>重度介護前払特約変更請求書の送付案内</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_SBMENSEKI_SOUHU}</td><td>&quot;kk112&quot;</td><td>精算金請求書（免責）の送付案内</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_HRIHEN_SOUHU}</td><td>&quot;kk113&quot;</td><td>払込経路変更請求書の送付案内</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_HUKKATU_SOUHU}</td><td>&quot;kk114&quot;</td><td>復活請求書の送付案内</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_MOUSIDEMUKOU_SOUHU}</td><td>&quot;kk115&quot;</td><td>申出無効請求書の送付案内</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_GANMUKOU_SOUHU}</td><td>&quot;kk116&quot;</td><td>精算金請求書（がん無効）の送付案内</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_MKHGKHNK_SOUHU}</td><td>&quot;kk117&quot;</td><td>目標額変更請求書の送付案内</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_YENDTHNKHNRKN_SOUHU}</td><td>&quot;kk118&quot;</td><td>円建変更時返戻金請求書の送付案内</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_TUMITATEKINITEN_SOUHU}</td><td>&quot;kk119&quot;</td><td>積立金移転請求書の送付案内</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_DSHR_SOUHU}</td><td>&quot;kk120&quot;</td><td>配当金支払請求書の送付案内</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_YENDTHNK_SOUHU}</td><td>&quot;kk121&quot;</td><td>円建変更請求書の送付案内</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_KZKTRKKYKDRTKYKHNK_SOUHU}</td><td>&quot;kk122&quot;</td><td>家族登録・契約者代理特約変更請求書の送付案内</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_HUBITEISEISYO_SOUHU}</td><td>&quot;kk150&quot;</td><td>不備訂正書の送付案内</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_ADRHNK_HB}</td><td>&quot;kk151&quot;</td><td>不備訂正書（住所変更）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_MEIGIHNK_HB}</td><td>&quot;kk152&quot;</td><td>不備訂正書（名義変更）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_STDRHNK_HB}</td><td>&quot;kk153&quot;</td><td>不備訂正書（被保険者代理特約中途付加）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_SEINENGAPPISEI_HB}</td><td>&quot;kk154&quot;</td><td>不備訂正書（生年月日・性訂正）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_GENGAKU_HB}</td><td>&quot;kk155&quot;</td><td>不備訂正書（減額）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_NKTKYKHNK_HB}</td><td>&quot;kk156&quot;</td><td>不備訂正書（年金支払特約変更）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_TARGETHNK_HB}</td><td>&quot;kk157&quot;</td><td>不備訂正書（ターゲット特約変更）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_KAIYAKU_HB}</td><td>&quot;kk158&quot;</td><td>不備訂正書（解約）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_SHRKZHNK_HB}</td><td>&quot;kk159&quot;</td><td>不備訂正書（支払口座変更）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_SYOSAIHK_HB}</td><td>&quot;kk160&quot;</td><td>不備訂正書（証券再発行）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_KYKTORIKESI_HB}</td><td>&quot;kk161&quot;</td><td>不備訂正書（契約取消）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_CLGOFF_HB}</td><td>&quot;kk162&quot;</td><td>不備訂正書（クーリングオフ）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_KAIJYO_HB}</td><td>&quot;kk163&quot;</td><td>不備訂正書（解除）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_MUKOU_HB}</td><td>&quot;kk164&quot;</td><td>不備訂正書（無効）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_SBKAIJYO_HB}</td><td>&quot;kk165&quot;</td><td>不備訂正書（死亡解除）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_SBMENSEKI_HB}</td><td>&quot;kk166&quot;</td><td>不備訂正書（死亡免責）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_KAIGOMAETKHNK_HB}</td><td>&quot;kk167&quot;</td><td>不備訂正書（重度介護前払特約変更）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_SBMUKOU_HB}</td><td>&quot;kk168&quot;</td><td>不備訂正書（死亡無効（既払Ｐ支払））</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_SBMUKOUNOSHR_HB}</td><td>&quot;kk169&quot;</td><td>不備訂正書（死亡無効（支払なし））</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_SBMENSEKINOSHR_HB}</td><td>&quot;kk170&quot;</td><td>不備訂正書（死亡免責（支払なし））</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_HUBI_KARISAKUSEI}</td><td>&quot;kk171&quot;</td><td>不備訂正書（仮作成）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_MKHGKHNK_HB}</td><td>&quot;kk172&quot;</td><td>不備訂正書（目標額変更）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_YENDTHNKHNRKN_HB}</td><td>&quot;kk173&quot;</td><td>不備訂正書（円建変更時返戻金）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_TUMITATEKINITEN_HB}</td><td>&quot;kk174&quot;</td><td>不備訂正書（積立金移転）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_DSHR_HB}</td><td>&quot;kk175&quot;</td><td>不備訂正書（配当金支払）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_YENDTHNK_NINI_HB}</td><td>&quot;kk176&quot;</td><td>不備訂正書（円建変更受付（任意請求））</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_KZKTRK_KYKDRTKYKHNK_HB}</td><td>&quot;kk177&quot;</td><td>不備訂正書（家族登録／契約者代理特約変更）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_ADRHNK_HBLIST}</td><td>&quot;kk201&quot;</td><td>不備未解消リスト（住所変更）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_MEIGIHNK_HBLIST}</td><td>&quot;kk202&quot;</td><td>不備未解消リスト（名義変更）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_STDRHNK_HBLIST}</td><td>&quot;kk203&quot;</td><td>不備未解消リスト（被保険者代理特約中途付加）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_SEINENGAPPISEI_HBLIST}</td><td>&quot;kk204&quot;</td><td>不備未解消リスト（生年月日・性訂正）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_GENGAKU_HBLIST}</td><td>&quot;kk205&quot;</td><td>不備未解消リスト（減額）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_NKTKYKHNK_HBLIST}</td><td>&quot;kk206&quot;</td><td>不備未解消リスト（年金支払特約変更）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_TARGETHNK_HBLIST}</td><td>&quot;kk207&quot;</td><td>不備未解消リスト（ターゲット特約変更）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_KAIYAKU_HBLIST}</td><td>&quot;kk208&quot;</td><td>不備未解消リスト（解約）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_SHRKZHNK_HBLIST}</td><td>&quot;kk209&quot;</td><td>不備未解消リスト（支払口座変更）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_SYOSAIHK_HBLIST}</td><td>&quot;kk210&quot;</td><td>不備未解消リスト（証券再発行）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_KYKTORIKESI_HBLIST}</td><td>&quot;kk211&quot;</td><td>不備未解消リスト（契約取消）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_CLGOFF_HBLIST}</td><td>&quot;kk212&quot;</td><td>不備未解消リスト（クーリングオフ）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_KAIJYO_HBLIST}</td><td>&quot;kk213&quot;</td><td>不備未解消リスト（解除）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_MUKOU_HBLIST}</td><td>&quot;kk214&quot;</td><td>不備未解消リスト（無効）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_SBKAIJYO_HBLIST}</td><td>&quot;kk215&quot;</td><td>不備未解消リスト（死亡解除）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_SBMENSEKI_HBLIST}</td><td>&quot;kk216&quot;</td><td>不備未解消リスト（死亡免責）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_KAIGOMAETKHNK_HBLIST}</td><td>&quot;kk217&quot;</td><td>不備未解消リスト（重度介護前払特約変更）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_SBMUKOU_HBLIST}</td><td>&quot;kk218&quot;</td><td>不備未解消リスト（死亡無効（既払Ｐ支払））</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_SBMUKOUNOSHR_HBLIST}</td><td>&quot;kk219&quot;</td><td>不備未解消リスト（死亡無効（支払なし））</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_SBMENSEKINOSHR_HBLIST}</td><td>&quot;kk220&quot;</td><td>不備未解消リスト（死亡免責（支払なし））</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_MKHGKHNK_HBLIST}</td><td>&quot;kk221&quot;</td><td>不備未解消リスト（目標額変更）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_YENDTHNKHNRKN_HBLIST}</td><td>&quot;kk222&quot;</td><td>不備未解消リスト（円建変更時返戻金）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_TUMITATEKINITEN_HBLIST}</td><td>&quot;kk223&quot;</td><td>不備未解消リスト（積立金移転）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_DSHR_HBLIST}</td><td>&quot;kk224&quot;</td><td>不備未解消リスト（配当金支払）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_YENDTHNK_NINI_HBLIST}</td><td>&quot;kk225&quot;</td><td>不備未解消リスト（円建変更受付（任意請求））</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_KZKTRK_KYKDRTKYKHNK_HBLIST}</td><td>&quot;kk226&quot;</td><td>不備未解消リスト（家族登録／契約者代理特約変更）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_NKTKYKHNK_GAIYOU}</td><td>&quot;kk251&quot;</td><td>年金支払特約　契約概要・注意喚起情報</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_KAIGOMAETK_KYKGAIYOU}</td><td>&quot;kk252&quot;</td><td>重度介護前払特約　契約概要</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_KAIGOMAETK_TYUUIKANKI}</td><td>&quot;kk253&quot;</td><td>重度介護前払特約　注意喚起情報</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_MYNUMBER_SYORUI_GENGAKU}</td><td>&quot;kk256&quot;</td><td>マイナンバー書類（減額）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_MYNUMBER_SYORUI_KAIYAKU}</td><td>&quot;kk257&quot;</td><td>マイナンバー書類（解約）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_MYNUMBER_SYORUI_YENDTHNKHNRKN}</td><td>&quot;kk258&quot;</td><td>マイナンバー書類（円建変更時返戻金）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_MEIGIHNK_DAIHYOUSN}</td><td>&quot;kk260&quot;</td><td>代表選任届（名義変更）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_KAIYAKU_DAIHYOUSN}</td><td>&quot;kk261&quot;</td><td>代表選任届（解約）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_YENDTHNKHNRKN_DAIHYOUSN}</td><td>&quot;kk262&quot;</td><td>代表選任届（円建変更時返戻金）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_MEIGIHNK_TORIHIKIKAK}</td><td>&quot;kk266&quot;</td><td>取引時確認記録書（名義変更）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_KAIYAKU_TORIHIKIKAK}</td><td>&quot;kk267&quot;</td><td>取引時確認記録書（解約）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_SOUHUANNAI}</td><td>&quot;kk270&quot;</td><td>送付案内（汎用）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_SHIHARAI_SOUHU}</td><td>&quot;kk271&quot;</td><td>支払請求書の送付案内</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_KYKNAIYOUOSIRASE1}</td><td>&quot;kk280&quot;</td><td>ご契約内容のお知らせ１</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_KYKNAIYOUOSIRASE2}</td><td>&quot;kk281&quot;</td><td>ご契約内容のお知らせ２</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_KYKNAIYOUOSIRASE3}</td><td>&quot;kk282&quot;</td><td>ご契約内容のお知らせ３</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_KYKNAIYOUOSIRASE4}</td><td>&quot;kk283&quot;</td><td>ご契約内容のお知らせ４</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_KYKNAIYOUOSIRASE5}</td><td>&quot;kk284&quot;</td><td>ご契約内容のお知らせ５</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_KYKNAIYOUOSIRASE6}</td><td>&quot;kk285&quot;</td><td>ご契約内容のお知らせ６</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_KYKNAIYOUOSIRASE7}</td><td>&quot;kk286&quot;</td><td>ご契約内容のお知らせ７</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_HKNSYKN}</td><td>&quot;kk301&quot;</td><td>保険証券</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_HKNSYKNITIJI}</td><td>&quot;kk302&quot;</td><td>保険証券（一時払）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_SKSYOUKEN}</td><td>&quot;kk303&quot;</td><td>新契約証券</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_SAISYOUKEN}</td><td>&quot;kk304&quot;</td><td>再発行証券</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_SUIIHYOU}</td><td>&quot;kk305&quot;</td><td>推移表</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_GAIKA_KOKYAKUTUUTI}</td><td>&quot;kk306&quot;</td><td>外貨建顧客通知</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_SEISANDHANEITUUTI}</td><td>&quot;kk307&quot;</td><td>精算Ｄ反映通知</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_KOUJYOSYOUMEIS}</td><td>&quot;kk311&quot;</td><td>控除証明書</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_KOUJYOSYOUMEIS_GAIBU}</td><td>&quot;kk312&quot;</td><td>控除証明書≪外部印刷≫</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_KOUJYOSYOUMEIS_SG}</td><td>&quot;kk313&quot;</td><td>控除証明書（総合通知用）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_SINNINTOUHYOU}</td><td>&quot;kk320&quot;</td><td>信任投票はがき</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_SYAINMEIBO}</td><td>&quot;kk322&quot;</td><td>社員名簿</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_GENKYOUTUUTI}</td><td>&quot;kk323&quot;</td><td>現況通知</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_JIGYOUNENDOMATU}</td><td>&quot;kk324&quot;</td><td>事業年度末通知</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_SOUGOUTUUTI}</td><td>&quot;kk341&quot;</td><td>総合通知</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_ANSINDAYORI}</td><td>&quot;kk342&quot;</td><td>安心だより</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_KOUHURIMINYUUTUUTI}</td><td>&quot;kk402&quot;</td><td>口座振替未入通知</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_1PNYKNKANSYOUTUUTI}</td><td>&quot;kk405&quot;</td><td>第１回保険料入金勧奨通知（振込）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_MUKOUTUUTI}</td><td>&quot;kk406&quot;</td><td>無効通知</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_SIKKOUTUUTI}</td><td>&quot;kk407&quot;</td><td>失効通知</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_JIMURENRAKU}</td><td>&quot;kk801&quot;</td><td>事務連絡票</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_JIMURENRAKU_GENGAKU}</td><td>&quot;kk802&quot;</td><td>事務連絡票（減額）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_JIMURENRAKU_SEINENGAPPISEITEISEI}</td><td>&quot;kk803&quot;</td><td>事務連絡票（被保険者生年月日・性訂正）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_JIMURENRAKU_KYKTORIKESI}</td><td>&quot;kk804&quot;</td><td>事務連絡票（契約取消）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_JIMURENRAKU_MEIGIHNK}</td><td>&quot;kk805&quot;</td><td>事務連絡票（名義変更）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_JIMURENRAKU_TETUDUKITYUUI}</td><td>&quot;kk806&quot;</td><td>事務連絡票（手続注意設定）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_SYOUKENMS_SKEI}</td><td>&quot;kk811&quot;</td><td>証券作成契約明細リスト（新契約）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_SYOUKENMS_SAI}</td><td>&quot;kk812&quot;</td><td>証券作成契約明細リスト（再発行）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_SYOUKENTOKUSYU_SKEI}</td><td>&quot;kk813&quot;</td><td>証券特殊処理明細リスト（新契約）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_SYOUKENTOKUSYU_SAI}</td><td>&quot;kk814&quot;</td><td>証券特殊処理明細リスト（再発行）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_INSIZEILIST_SKEI}</td><td>&quot;kk815&quot;</td><td>印紙税申告納付用リスト（新契約）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_INSIZEILIST_SAI}</td><td>&quot;kk816&quot;</td><td>印紙税申告納付用リスト（再発行）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_TRKKZKKNRTUUTISAGYOULIST}</td><td>&quot;kk817&quot;</td><td>登録ご家族あて完了通知　事後作業リスト（通知対象者用）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_GENSENLIST}</td><td>&quot;kk821&quot;</td><td>源泉徴収リスト</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_TYOUSYOLIST_UK_KAIJYO}</td><td>&quot;kk822&quot;</td><td>受取人別（解除）確認要リスト</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_TYOUSYOLIST_UK_MENSEKI}</td><td>&quot;kk823&quot;</td><td>受取人別（免責）確認要リスト</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_TYOUSYOLIST_ITJ_KAIYAKU}</td><td>&quot;kk826&quot;</td><td>一時金（解約）確認要リスト</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_KAIYAKU_BIKINSAGYOULIST}</td><td>&quot;kk828&quot;</td><td>解約備金作業リスト</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_KAIYAKU_BIKINJIKOUKIST}</td><td>&quot;kk829&quot;</td><td>解約備金時効リスト</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_KH_BIKINLIST}</td><td>&quot;kk830&quot;</td><td>契約変更備金リスト</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_YENDTHNK_BIKINLIST}</td><td>&quot;kk831&quot;</td><td>円建変更時返戻金備金リスト</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_ZENNOUSEISANKINMEISAILIST_GENGAKU}</td><td>&quot;kk832&quot;</td><td>前納精算金明細リスト（減額）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_ZENNOUSEISANKINMEISAILIST_KAIYAKU}</td><td>&quot;kk833&quot;</td><td>前納精算金明細リスト（解約）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_MKKPHENKINLIST_GENGAKU}</td><td>&quot;kk834&quot;</td><td>未経過Ｐ返金リスト（減額）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_MKKPHENKINLIST_KAIYAKU}</td><td>&quot;kk835&quot;</td><td>未経過Ｐ返金リスト（解約）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_AZUKARIKINLIST}</td><td>&quot;kk836&quot;</td><td>預り金リスト</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_AZUKARIKIN_BIKINLIST}</td><td>&quot;kk837&quot;</td><td>預り金備金リスト</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_SYOURAIW_SISANHYOU}</td><td>&quot;kk851&quot;</td><td>将来解約返戻金試算表</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_HNGKUNEIHIKAKLIST}</td><td>&quot;kk852&quot;</td><td>変額特別勘定運営費確認リスト</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_KACHECK_YOHURI_MISSLIST}</td><td>&quot;kk861&quot;</td><td>口座情報マスタチェックミスリスト（預振口座用）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_KACHECK_SHRKZ_MISSLIST}</td><td>&quot;kk862&quot;</td><td>口座情報マスタチェックミスリスト（定期金支払口座用）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_KYKINFOTORIKOMI_MISSLIST}</td><td>&quot;kk863&quot;</td><td>契約情報取込ミスリスト</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_SHRKEKKATORIKOMI_MISSLIST}</td><td>&quot;kk864&quot;</td><td>支払結果情報取込ミスリスト</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_KZHURIANNAISEL_MISSLIST}</td><td>&quot;kk865&quot;</td><td>口振案内データ抽出ミスリスト</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_YUUKOUKEKKAHANEI_MISSLIST}</td><td>&quot;kk866&quot;</td><td>有効性確認結果反映ミスリスト</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_AUTHORIKEKKAHANEI_MISSLIST}</td><td>&quot;kk867&quot;</td><td>オーソリ結果反映ミスリスト</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_URIAGEKEKKATRSKS_MISSLIST}</td><td>&quot;kk868&quot;</td><td>売上結果ＴＲ作成ミスリスト</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_NYUUKIN_MISSLIST}</td><td>&quot;kk869&quot;</td><td>入金処理ミスリスト</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_LINC_MISSLIST}</td><td>&quot;kk870&quot;</td><td>契約管理ＬＩＮＣ受信ミスリスト</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_MINYUUITIRAN}</td><td>&quot;kk871&quot;</td><td>未入一覧表</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_SIKKOUITIRAN}</td><td>&quot;kk872&quot;</td><td>失効一覧表</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_HANDKARIKANJYOU}</td><td>&quot;kk873&quot;</td><td>ハンド仮勘定票</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_DHANEI_MISSLIST}</td><td>&quot;kk874&quot;</td><td>配当金反映ミスリスト</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_BATCHKAIYAKU_MISSLIST}</td><td>&quot;kk875&quot;</td><td>バッチ解約ミスリスト</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_YENDTHNK_MISSLIST}</td><td>&quot;kk876&quot;</td><td>円建変更ミスリスト</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_YENDTHNKSEL_MISSLIST}</td><td>&quot;kk877&quot;</td><td>円建変更対象抽出ミスリスト</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_SEISANDHANEI_MISSLIST}</td><td>&quot;kk878&quot;</td><td>精算Ｄ反映ミスリスト</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_DSEISAN_MISSLIST}</td><td>&quot;kk879&quot;</td><td>Ｄ精算ミスリスト</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_SISUURENDOTMTTKNHANEI_MISSLIST}</td><td>&quot;kk880&quot;</td><td>指数連動積増型年金積立金反映ミスリスト</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_GAIKAKOKYAKUTUUTISKS_MISSLIST}</td><td>&quot;kk881&quot;</td><td>外貨建顧客通知作成ミスリスト</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_BATCHMKHGKHENKOU_MISSLIST}</td><td>&quot;kk882&quot;</td><td>バッチ目標額変更ミスリスト</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_SEIKYUKNK_SYOSAIHK}</td><td>&quot;kk901&quot;</td><td>請求関係書類（証券再発行）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_HUBIKNK_SYOSAIHK}</td><td>&quot;kk902&quot;</td><td>不備関係書類（証券再発行）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_SEIKYUKNK_MEIGIHNK}</td><td>&quot;kk903&quot;</td><td>請求関係書類（名義変更）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_HUBIKNK_MEIGIHNK}</td><td>&quot;kk904&quot;</td><td>不備関係書類（名義変更）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_SEIKYUKNK_SEINENGAPPISEI}</td><td>&quot;kk905&quot;</td><td>請求関係書類（生年月日・性訂正）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_HUBIKNK_SEINENGAPPISEI}</td><td>&quot;kk906&quot;</td><td>不備関係書類（生年月日・性訂正）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_SEIKYUKNK_GENGAKU}</td><td>&quot;kk907&quot;</td><td>請求関係書類（減額）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_HUBIKNK_GENGAKU}</td><td>&quot;kk908&quot;</td><td>不備関係書類（減額）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_SEIKYUKNK_KAIYAKU}</td><td>&quot;kk909&quot;</td><td>請求関係書類（解約）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_HUBIKNK_KAIYAKU}</td><td>&quot;kk910&quot;</td><td>不備関係書類（解約）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_TODOKEDEKNK_ADRHNK}</td><td>&quot;kk911&quot;</td><td>届出関係書類（住所変更）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_HUBIKNK_ADRHNK}</td><td>&quot;kk912&quot;</td><td>不備関係書類（住所変更）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_SEIKYUKNK_STDRSKYTKYK}</td><td>&quot;kk913&quot;</td><td>請求関係書類（被保険者代理特約中途付加）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_HUBIKNK_STDRSKYTKYK}</td><td>&quot;kk914&quot;</td><td>不備関係書類（被保険者代理特約中途付加）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_SEIKYUKNK_KAIGOMAETKHNK}</td><td>&quot;kk915&quot;</td><td>請求関係書類（重度介護前払特約変更）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_HUBIKNK_KAIGOMAETKHNK}</td><td>&quot;kk916&quot;</td><td>不備関係書類（重度介護前払特約変更）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_SEIKYUKNK_MKHGKHNK}</td><td>&quot;kk917&quot;</td><td>請求関係書類（目標額変更）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_HUBIKNK_MKHGKHNK}</td><td>&quot;kk918&quot;</td><td>不備関係書類（目標額変更）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_SEIKYUKNK_YENDTHNKHNRKN}</td><td>&quot;kk919&quot;</td><td>請求関係書類（円建変更時返戻金）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_HUBIKNK_YENDTHNKHNRKN}</td><td>&quot;kk920&quot;</td><td>不備関係書類（円建変更時返戻金）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_SEIKYUKNK_TUMITATEKINITEN}</td><td>&quot;kk921&quot;</td><td>請求関係書類（積立金移転）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_HUBIKNK_TUMITATEKINITEN}</td><td>&quot;kk922&quot;</td><td>不備関係書類（積立金移転）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_SEIKYUKNK_DSHR}</td><td>&quot;kk923&quot;</td><td>請求関係書類（配当金支払）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_HUBIKNK_DSHR}</td><td>&quot;kk924&quot;</td><td>不備関係書類（配当金支払）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_SEIKYUKNK_YENDTHNK_NINI}</td><td>&quot;kk925&quot;</td><td>請求関係書類（円建変更受付（任意請求））</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_HUBIKNK_YENDTHNK_NINI}</td><td>&quot;kk926&quot;</td><td>不備関係書類（円建変更受付（任意請求））</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_HUBIKNK_KYKTORIKESI}</td><td>&quot;kk927&quot;</td><td>不備関係書類（契約取消）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_HUBIKNK_CLGOFF}</td><td>&quot;kk928&quot;</td><td>不備関係書類（クーリングオフ）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_HUBIKNK_KAIJYO}</td><td>&quot;kk929&quot;</td><td>不備関係書類（解除）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_HUBIKNK_MUKOU}</td><td>&quot;kk930&quot;</td><td>不備関係書類（無効）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_HUBIKNK_SBKAIJYO}</td><td>&quot;kk931&quot;</td><td>不備関係書類（死亡解除）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_HUBIKNK_SBMENSEKI}</td><td>&quot;kk932&quot;</td><td>不備関係書類（死亡免責）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_HUBIKNK_SBMUKOU}</td><td>&quot;kk933&quot;</td><td>不備関係書類（死亡無効（既払Ｐ支払））</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_HUBIKNK_SBMUKOUNOSHR}</td><td>&quot;kk934&quot;</td><td>不備関係書類（死亡無効（支払なし））</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_HUBIKNK_SBMENSEKINOSHR}</td><td>&quot;kk935&quot;</td><td>不備関係書類（死亡免責（支払なし））</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_SEIKYUKNK_KZKTRKKYKDRHNK}</td><td>&quot;kk936&quot;</td><td>請求関係書類（家族登録／契約者代理特約変更）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_HUBIKNK_KZKTRKKYKDRHNK}</td><td>&quot;kk937&quot;</td><td>不備関係書類（家族登録／契約者代理特約変更）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #AS_KOUHURIKAISIANNAI}</td><td>&quot;as001&quot;</td><td>口座振替開始案内</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #AS_KIJITUTOURAIANNAI}</td><td>&quot;as002&quot;</td><td>期日到来案内</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #AS_KZHENKINTUUTI}</td><td>&quot;as051&quot;</td><td>口座返金通知</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #AS_KZHURIKOMITUUTI}</td><td>&quot;as052&quot;</td><td>口座振込通知</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #AS_KRKKN_SEIBITOKUSOKULIST_1}</td><td>&quot;as053&quot;</td><td>仮受金整備督促リスト（個別収納サービス室）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #AS_CREDITHENKINTUUTI}</td><td>&quot;as054&quot;</td><td>クレカ返金通知</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #AS_KRKKN_SEIBITOKUSOKULIST_2}</td><td>&quot;as055&quot;</td><td>仮受金整備督促リスト（保全変更サービス室）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #AS_KOUHURIMINYUUTUUTI}</td><td>&quot;as101&quot;</td><td>未入通知（口座振替）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #AS_CREDITMINYUUTUUTI}</td><td>&quot;as102&quot;</td><td>未入通知（クレジット）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #AS_DATTAITUUTI_KOUHURI}</td><td>&quot;as151&quot;</td><td>脱退通知（口座振替）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #AS_DATTAI_MIKAISYOULIST}</td><td>&quot;as152&quot;</td><td>脱退未解消リスト</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #AS_YUUKOUSEINGTUUTI}</td><td>&quot;as153&quot;</td><td>有効性確認ＮＧ通知</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #AS_HRHNTTDKANNAI}</td><td>&quot;as301&quot;</td><td>払変手続案内</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #AS_PKZHRIKEIRAI}</td><td>&quot;as302&quot;</td><td>生命保険料口座振替依頼書</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #AS_PHRKKAISUUHENKOUMOS}</td><td>&quot;as303&quot;</td><td>生命保険料払込回数変更申込書</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #AS_HRHNKANRYOTUUTI}</td><td>&quot;as304&quot;</td><td>払変完了通知（ＰＤＦ）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #AS_HRHNKANRYOTUUTI_DNP}</td><td>&quot;as305&quot;</td><td>払変完了通知（ＤＮＰ）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #AS_HRHN_HB}</td><td>&quot;as306&quot;</td><td>不備訂正書（払方変更）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #AS_HRHN_HBLIST}</td><td>&quot;as307&quot;</td><td>不備未解消リスト（払方変更）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #AS_CREDITCARDMOS}</td><td>&quot;as308&quot;</td><td>クレジットカード扱い申込書</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #AS_SINKOKUYOKOKUTUUTI}</td><td>&quot;as351&quot;</td><td>申告予告通知</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #AS_SAIGAITOKUSINKEIYAKUHOYUULIST}</td><td>&quot;as401&quot;</td><td>災害特伸契約保有リスト</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #AS_ZENNOUTOUKEILIST}</td><td>&quot;as403&quot;</td><td>前納統計リスト</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #AS_ZENNOUMKKPKSSAMPLELIST}</td><td>&quot;as404&quot;</td><td>前納未経過Ｐ検証サンプルリスト</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #AS_PMINYUUSYOUMETUHRBKNLIST}</td><td>&quot;as407&quot;</td><td>Ｐ未入消滅時返戻金備金リスト</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #AS_SYOUMETUTUUTI}</td><td>&quot;as501&quot;</td><td>消滅通知</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #AS_SYOUMETUTUUTI_SHRSKS}</td><td>&quot;as502&quot;</td><td>消滅通知（請求書同封）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #AS_SYOUMETUKEIYAKULIST}</td><td>&quot;as503&quot;</td><td>消滅契約リスト</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #AS_JIMURENRAKU_SYUUNOU}</td><td>&quot;as901&quot;</td><td>事務連絡票（収納）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #AS_MISSLIST_SYUUNOU}</td><td>&quot;as902&quot;</td><td>ミスリスト（収納）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #AS_PMINYUUSYOUMETU_MISSLIST}</td><td>&quot;as903&quot;</td><td>Ｐ未入消滅ミスリスト</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #AS_URIAGESEIKYUUKEKKA_ERRORLIST}</td><td>&quot;as904&quot;</td><td>売上請求結果エラーリスト</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #AS_CREDITTOUROKUKENSUULIST}</td><td>&quot;as905&quot;</td><td>クレカ登録件数リスト</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #AS_MOSKNK_HRHN}</td><td>&quot;as910&quot;</td><td>申込関係書類（払方変更）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #AS_HUBIKNK_HRHN}</td><td>&quot;as911&quot;</td><td>不備関係書類（払方変更）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #AS_YUUKOUKAKUNIN_ERRORLIST}</td><td>&quot;as906&quot;</td><td>有効確認エラーリスト</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #AS_MINUSURIAGEKYKDTLLIST}</td><td>&quot;as907&quot;</td><td>マイナス売上契約明細リスト</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NK_SKS}</td><td>&quot;nk005&quot;</td><td>年金請求書</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NK_SKS_ITJ}</td><td>&quot;nk010&quot;</td><td>年金変更請求書（年金一時金支払）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NK_SKS_SIBOU}</td><td>&quot;nk015&quot;</td><td>年金変更請求書（死亡）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NK_SKS_MGHNK}</td><td>&quot;nk020&quot;</td><td>年金変更請求書（名義住所変更）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NK_SKS_KZHNK}</td><td>&quot;nk025&quot;</td><td>年金変更請求書（自動支払口座変更）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NK_SKS_KAISUHNK}</td><td>&quot;nk030&quot;</td><td>年金変更請求書（分割支払回数変更）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NK_SKS_SAIHAKKOU}</td><td>&quot;nk035&quot;</td><td>年金変更請求書（証書再発行）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NK_SKS_TK_STDRSKTKY}</td><td>&quot;nk040&quot;</td><td>年金変更請求書（被保険者代理特約変更）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NK_SKS_TK_KKNKUKT}</td><td>&quot;nk045&quot;</td><td>年金変更請求書（後継年金受取人指定特約変更）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NK_SKS_D_UKTRHOU_HK}</td><td>&quot;nk050&quot;</td><td>年金変更請求書（配当金受取方法変更）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NK_SOUHU_ITJ}</td><td>&quot;nk110&quot;</td><td>送付案内（年金一時金支払請求書）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NK_SOUHU_SIBOU}</td><td>&quot;nk115&quot;</td><td>送付案内（死亡）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NK_SOUHU_MGHNK}</td><td>&quot;nk120&quot;</td><td>送付案内（名義住所変更請求書）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NK_SOUHU_KZHNK}</td><td>&quot;nk125&quot;</td><td>送付案内（自動支払口座変更請求書）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NK_SOUHU_KAISUHNK}</td><td>&quot;nk130&quot;</td><td>送付案内（分割支払回数変更請求書）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NK_SOUHU_SAIHAKKOU}</td><td>&quot;nk135&quot;</td><td>送付案内（証書再発行請求書）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NK_SOUHU_TK_STDRSKTKY}</td><td>&quot;nk140&quot;</td><td>送付案内（被保険者代理特約変更請求書）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NK_SOUHU_TK_KKNKUKT}</td><td>&quot;nk145&quot;</td><td>送付案内（後継年金受取人指定特約変更請求書）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NK_SOUHU_D_UKTRHOU_HK}</td><td>&quot;nk150&quot;</td><td>送付案内（配当金受取方法変更請求書）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NK_SISAN_ITJ}</td><td>&quot;nk210&quot;</td><td>試算書（年金一時金支払）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NK_SISAN_SIBOU}</td><td>&quot;nk215&quot;</td><td>試算書（死亡一時金）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NK_HUBI_ITJ}</td><td>&quot;nk310&quot;</td><td>不備訂正書（年金一時金支払）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NK_HUBI_SIBOU}</td><td>&quot;nk315&quot;</td><td>不備訂正書（死亡）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NK_HUBI_MGHNK}</td><td>&quot;nk320&quot;</td><td>不備訂正書（名義住所変更）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NK_HUBI_KZHNK}</td><td>&quot;nk325&quot;</td><td>不備訂正書（自動支払口座変更）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NK_HUBI_KAISUHNK}</td><td>&quot;nk330&quot;</td><td>不備訂正書（分割支払回数変更）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NK_HUBI_SAIHAKKOU}</td><td>&quot;nk335&quot;</td><td>不備訂正書（証書再発行）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NK_HUBI_TK_STDRSKTKY}</td><td>&quot;nk340&quot;</td><td>不備訂正書（被保険者代理特約変更）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NK_HUBI_TK_KKNKUKT}</td><td>&quot;nk345&quot;</td><td>不備訂正書（後継年金受取人指定特約変更）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NK_SOUHU_HUBI_ITJ}</td><td>&quot;nk410&quot;</td><td>不備訂正書の送付案内（年金一時金支払）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NK_SOUHU_HUBI_SIBOU}</td><td>&quot;nk415&quot;</td><td>不備訂正書の送付案内（死亡）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NK_SOUHU_HUBI_MGHNK}</td><td>&quot;nk420&quot;</td><td>不備訂正書の送付案内（名義住所変更）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NK_SOUHU_HUBI_KZHNK}</td><td>&quot;nk425&quot;</td><td>不備訂正書の送付案内（自動支払口座変更）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NK_SOUHU_HUBI_KAISUHNK}</td><td>&quot;nk430&quot;</td><td>不備訂正書の送付案内（分割支払回数変更）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NK_SOUHU_HUBI_SAIHAKKOU}</td><td>&quot;nk435&quot;</td><td>不備訂正書の送付案内（証書再発行）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NK_SOUHU_HUBI_TK_STDRSKTKY}</td><td>&quot;nk440&quot;</td><td>不備訂正書の送付案内（被保険者代理特約変更）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NK_SOUHU_HUBI_TK_KKNKUKT}</td><td>&quot;nk445&quot;</td><td>不備訂正書の送付案内（後継年金受取人指定特約変更）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NK_NKSYOUSYO}</td><td>&quot;nk500&quot;</td><td>年金証書</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NK_TTDKKNR_NKIKOU}</td><td>&quot;nk505&quot;</td><td>手続完了通知（年金移行）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NK_SHRMEISAISYO}</td><td>&quot;nk510&quot;</td><td>年金支払明細書（はがき）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NK_TTDKKNR_ITJ}</td><td>&quot;nk515&quot;</td><td>手続完了通知（年金一時金支払）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NK_TTDKKNR_TJSHR}</td><td>&quot;nk520&quot;</td><td>手続完了通知（年金通常支払）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NK_TTDKKNR_SIBOU}</td><td>&quot;nk525&quot;</td><td>手続完了通知（死亡一時金支払）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NK_TTDKKNR_UKTHNK}</td><td>&quot;nk530&quot;</td><td>手続完了通知（年金受取人変更）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NK_TTDKKNR_MGHNK}</td><td>&quot;nk535&quot;</td><td>手続完了通知（名義住所変更）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NK_TTDKKNR_KZHNK}</td><td>&quot;nk540&quot;</td><td>手続完了通知（口座変更）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NK_TTDKKNR_KAISUHNK}</td><td>&quot;nk545&quot;</td><td>手続完了通知（分割支払回数変更）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NK_TTDKKNR_SAIHAKKOU}</td><td>&quot;nk550&quot;</td><td>手続完了通知（証書再発行）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NK_TTDKKNR_TK_STDRSKTKY}</td><td>&quot;nk555&quot;</td><td>手続完了通知（被保険者代理特約変更）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NK_TTDKKNR_TK_KKNKUKT}</td><td>&quot;nk560&quot;</td><td>手続完了通知（後継年金受取人指定特約変更）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NK_DAIHYOUSENNINTDK}</td><td>&quot;nk600&quot;</td><td>代表選任届</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NK_KOSEKITOUHON}</td><td>&quot;nk605&quot;</td><td>戸籍謄本</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NK_KOSEKITOUHON_KAISEI}</td><td>&quot;nk606&quot;</td><td>戸籍謄（抄）本（改姓同時改名または親権者変更の場合）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NK_JYUUMIN}</td><td>&quot;nk607&quot;</td><td>住民票</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NK_HONNINKAKUNIN}</td><td>&quot;nk610&quot;</td><td>本人確認書類</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NK_HONNINKAKUNIN_SHR}</td><td>&quot;nk611&quot;</td><td>本人確認書類（証書未提出かつ支払額が300万超の場合）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NK_SIBOUSINDAN}</td><td>&quot;nk615&quot;</td><td>死亡診断書</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NK_TORIHIKIJIKAKUNIN}</td><td>&quot;nk620&quot;</td><td>取引時確認に関するお願い</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NK_NKTRKM_MISSLIST}</td><td>&quot;nk700&quot;</td><td>年金情報取込ミスリスト</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NK_JDSHR_MISSLIST}</td><td>&quot;nk710&quot;</td><td>自動支払ミスリスト</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NK_KSCHK_MISSLIST}</td><td>&quot;nk720&quot;</td><td>口座情報マスタチェックミスリスト</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NK_GNSNLIST}</td><td>&quot;nk730&quot;</td><td>源泉徴収リスト</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NK_HUBIMIKAISYOULIST}</td><td>&quot;nk740&quot;</td><td>不備未解消リスト</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NK_TYOUSYOLIST_NK}</td><td>&quot;nk751&quot;</td><td>支払調書（年金）確認要リスト</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NK_TYOUSYOLIST_ITJ_NK}</td><td>&quot;nk752&quot;</td><td>支払調書（一時金）年金確認要リスト</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NK_TYOUSYOLIST_UK_NK}</td><td>&quot;nk753&quot;</td><td>支払調書（受取人別）年金確認要リスト</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SK_MOSSYO}</td><td>&quot;sk001&quot;</td><td>申込書</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SK_PPLESSMOSIKOUKAKSYO}</td><td>&quot;sk002&quot;</td><td>ペーパーレス申込書兼意向確認書</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SK_KOKUSYO}</td><td>&quot;sk003&quot;</td><td>告知書</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SK_PPLESSKOKUSYO}</td><td>&quot;sk004&quot;</td><td>ペーパーレス告知書</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SK_IKOUKAKSYO}</td><td>&quot;sk005&quot;</td><td>意向確認書</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SK_IKOUKAKSYO_TEISEI}</td><td>&quot;sk006&quot;</td><td>意向確認書（訂正用）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SK_UKTHUKUSUUSITEI}</td><td>&quot;sk007&quot;</td><td>受取人複数指定書</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SK_UKTJIZENSYOUKAI}</td><td>&quot;sk008&quot;</td><td>受取人事前照会票</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SK_DAISANSYAUKTHOUSYO}</td><td>&quot;sk009&quot;</td><td>第三者受取報告書</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SK_FATCAKAKUNINSYO}</td><td>&quot;sk010&quot;</td><td>ＦＡＴＣＡ確認書</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SK_TORIHOUSYO}</td><td>&quot;sk011&quot;</td><td>取扱報告書</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SK_PPLESSTORIHOUSYO}</td><td>&quot;sk012&quot;</td><td>ペーパーレス取扱報告書</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SK_SONOTAHUZOKU}</td><td>&quot;sk013&quot;</td><td>その他付属資料</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SK_HENKOUTEISEI}</td><td>&quot;sk014&quot;</td><td>変更訂正書</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SK_AEOISINKITODOKEDESYO}</td><td>&quot;sk015&quot;</td><td>（居住地国確認）新規届出書</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SK_SEIMEIPKZHURIKAEMOSSYO}</td><td>&quot;sk016&quot;</td><td>生命保険料支払申込書</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SK_DAIHITUHOUKOKUSYO}</td><td>&quot;sk017&quot;</td><td>代筆報告書</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SK_HITAIMENCHKSHEET}</td><td>&quot;sk018&quot;</td><td>非対面チェックシート</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SK_JIMURENRAKU}</td><td>&quot;sk031&quot;</td><td>新契約事務連絡票</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SK_HUBITUUTI}</td><td>&quot;sk032&quot;</td><td>不備通知書</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SK_KYKKAKUNINIRAISYO}</td><td>&quot;sk033&quot;</td><td>契約確認依頼書</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SK_KYKKAKUNINKAITOUSYO}</td><td>&quot;sk034&quot;</td><td>契約確認回答書</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SK_YUUKOUKKNYOKOKULIST}</td><td>&quot;sk035&quot;</td><td>有効期間経過予告リスト</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SK_YUUKOUKKNTYOUKALIST}</td><td>&quot;sk036&quot;</td><td>有効期間経過超過リスト</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SK_KYKHUSEIRITU}</td><td>&quot;sk037&quot;</td><td>契約不成立通知書</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SK_TRKSSEIKYU}</td><td>&quot;sk038&quot;</td><td>取消請求書</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SK_TRKSSEIKYU_SOUHU}</td><td>&quot;sk039&quot;</td><td>取消請求書（送付案内）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SK_TTDKKR_DAIRITEN}</td><td>&quot;sk040&quot;</td><td>手続完了通知（代理店宛）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SK_TTDKKR}</td><td>&quot;sk041&quot;</td><td>手続完了通知（顧客宛）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SK_SMBCSINTYOKUMISSLIST}</td><td>&quot;sk042&quot;</td><td>ＳＭＢＣ進捗管理ミスリスト</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SK_SENTAKINFOMISSLIST}</td><td>&quot;sk043&quot;</td><td>新契約選択情報作成ミスリスト</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SK_YOTEIRIRITUHENKOURENRAKUHYOU}</td><td>&quot;sk044&quot;</td><td>予定利率等変更連絡票</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SK_HUBITUUTI_KARISAKUSEI}</td><td>&quot;sk045&quot;</td><td>不備通知書（仮作成）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SK_KEIYAKUNAIYOTOROKUSEIDOSYOKAIHYO}</td><td>&quot;sk046&quot;</td><td>契約内容登録制度照会票</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SK_HURIKOMINYKNSAKUJOMISSLIST}</td><td>&quot;sk051&quot;</td><td>振込入金削除ミスリスト</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SK_HURIKOMINYKNTEISEILIST_ENKA}</td><td>&quot;sk052&quot;</td><td>振込入金訂正データリスト（円貨）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SK_SAKUJOKYKMEISAILIST}</td><td>&quot;sk053&quot;</td><td>削除契約明細リスト</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SK_JIDOUNYKNMEISAILIST}</td><td>&quot;sk054&quot;</td><td>自動入金明細リスト</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SK_1PNYKNITTILIST}</td><td>&quot;sk055&quot;</td><td>第１回保険料一致リスト</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SK_NYKJYOUHOUHUITTIKAKSYO}</td><td>&quot;sk056&quot;</td><td>入金情報不一致確認書</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SK_MOSSOUHUJYOUKYOULIST}</td><td>&quot;sk057&quot;</td><td>申込書類送付状況リスト</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SK_MOSMITOUTYAKUKKNLIST}</td><td>&quot;sk058&quot;</td><td>申込書類未到着期間経過リスト</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SK_MOSSOUHUJYOUKYOULIST_SOUHU}</td><td>&quot;sk059&quot;</td><td>申込書類送付状況リスト（送付案内）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SK_HURIKOMINYKNTEISEILIST_GAIKA}</td><td>&quot;sk060&quot;</td><td>振込入金訂正データリスト（外貨）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SK_SIKINIDOULIST_HRKMKZHUITTI}</td><td>&quot;sk061&quot;</td><td>資金移動リスト（振込口座不一致分）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SK_HURIKOMINYKNTEISEILIST_ENKA_YENDT}</td><td>&quot;sk062&quot;</td><td>振込入金訂正データリスト（円貨）（円建）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SK_SAKUJOKYKMEISAILIST_YENDT}</td><td>&quot;sk063&quot;</td><td>削除契約明細リスト（円建）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SK_JIDOUNYKNMEISAILIST_YENDT}</td><td>&quot;sk064&quot;</td><td>自動入金明細リスト（円建）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SK_1PNYKNITTILIST_YENDT}</td><td>&quot;sk065&quot;</td><td>第１回保険料一致リスト（円建）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SK_NYKJYOUHOUHUITTIKAKSYO_YENDT}</td><td>&quot;sk066&quot;</td><td>入金情報不一致確認書（円建）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SK_MOSMITOUTYAKUKKNLIST_YENDT}</td><td>&quot;sk067&quot;</td><td>申込書類未到着期間経過リスト（円建）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SK_HENKINIRAISYO}</td><td>&quot;sk071&quot;</td><td>返金依頼書</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SK_HENKINTUUTILIST}</td><td>&quot;sk072&quot;</td><td>返金通知</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SK_HANDKARIKANJYOU}</td><td>&quot;sk073&quot;</td><td>新契約ハンド仮勘定票</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SK_HENKINMISYORILIST}</td><td>&quot;sk074&quot;</td><td>返金未処理リスト</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SK_HENKINIRAISYO_SOUHU}</td><td>&quot;sk075&quot;</td><td>返金依頼書（送付案内）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SK_HENKINIRAISYO_MIHON}</td><td>&quot;sk076&quot;</td><td>返金依頼書（ご記入見本）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SK_HANDKARIKANJYOU_YENDT}</td><td>&quot;sk077&quot;</td><td>新契約ハンド仮勘定票（円建）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SK_HENKINMISYORILIST_YENDT}</td><td>&quot;sk078&quot;</td><td>返金未処理リスト（円建）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SK_KARIUKEHUHOPKAKIN1MKEIKA}</td><td>&quot;sk081&quot;</td><td>仮受普保Ｐ過金１ヵ月超経過</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SK_GETUMATUZANDAKACHKLIST}</td><td>&quot;sk082&quot;</td><td>月末残高チェックリスト</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SK_MSRKARIUKEKINMEISAI}</td><td>&quot;sk083&quot;</td><td>未整理仮受金明細</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SK_MSRJIYUUMEISAI_NYKNHUBI}</td><td>&quot;sk084&quot;</td><td>未整理事由明細（入金内容不備）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SK_MSRJIYUUMEISAI_SYORUIHUBI_TAN}</td><td>&quot;sk085&quot;</td><td>未整理事由明細（書類不備）単独</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SK_MSRJIYUUMEISAI_SYORUIHUBI_HUKU}</td><td>&quot;sk086&quot;</td><td>未整理事由明細（書類不備）複数</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SK_MSRJIYUUMEISAI_SEIRITUHRYUUUKTKTYUU}</td><td>&quot;sk087&quot;</td><td>未整理事由明細（成立保留受付中）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SK_MSRJIYUUBETUKARIUKEKINSYUUKEI}</td><td>&quot;sk088&quot;</td><td>未整理事由別仮受金集計表</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SK_MSRJIYUUBETUKARIUKEKINMEISAILIST}</td><td>&quot;sk089&quot;</td><td>未整理事由別仮受金明細リスト</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SK_JIDSYUUNOUSYOUGOUMEISAI_KESSAN}</td><td>&quot;sk090&quot;</td><td>自動収納照合一致・不一致明細書（決算用）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SK_KARIUKEKINPKAKINMEISAI}</td><td>&quot;sk091&quot;</td><td>仮受金（Ｐ過金）明細</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SK_KARIUKEKINPKAKINZANDAKAMEISAILIST}</td><td>&quot;sk092&quot;</td><td>仮受金（Ｐ過金）残高明細リスト</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SK_HUKUSUUKAINYUUKINKAWASESASONEKI}</td><td>&quot;sk093&quot;</td><td>複数回入金為替差損益リスト</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SK_CREDITQRTOUROKUMIHANEILIST}</td><td>&quot;sk101&quot;</td><td>クレカＱＲ登録未反映リスト（申込入力未了分）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SK_CREDITCARDKAIINTOUROKUNGLIST}</td><td>&quot;sk102&quot;</td><td>クレジットカード会員登録ＮＧリスト</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SK_CREDITCARDTOUROKUHANEIERRORLIST}</td><td>&quot;sk103&quot;</td><td>クレジットカード登録反映エラーリスト</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SK_YUUKOUHANEIKAKUNINKEKKALIST}</td><td>&quot;sk104&quot;</td><td>新契約有効性反映確認結果リスト</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SK_FSTPURIAGESEIKYUUERRORLIST}</td><td>&quot;sk105&quot;</td><td>初回保険料売上請求エラーリスト</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SK_FSTPURIAGESEIKYUUMEISAI_JCB}</td><td>&quot;sk106&quot;</td><td>初回保険料クレジットカード扱売上請求明細票（ＪＣＢ）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SK_FSTPURIAGESEIKYUUMEISAI_VISA}</td><td>&quot;sk107&quot;</td><td>初回保険料クレジットカード扱売上請求明細票（ＶＩＳＡ）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SK_KOUFURITOUROKUMIHANEILIST}</td><td>&quot;sk108&quot;</td><td>口座振替登録未反映リスト（申込入力未了分）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SK_KOUFURITOUROKUHANEIERRORLIST}</td><td>&quot;sk109&quot;</td><td>口座振替登録反映エラーリスト</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SK_KARIUKEHUHOPKAKIN1MKEIKA_YENDT}</td><td>&quot;sk121&quot;</td><td>仮受普保Ｐ過金１ヵ月超経過（円建）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SK_GETUMATUZANDAKACHKLIST_YENDT}</td><td>&quot;sk122&quot;</td><td>月末残高チェックリスト（円建）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SK_MSRKARIUKEKINMEISAI_YENDT}</td><td>&quot;sk123&quot;</td><td>未整理仮受金明細（円建）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SK_MSRJIYUUMEISAI_NYKNHUBI_YENDT}</td><td>&quot;sk124&quot;</td><td>未整理事由明細（入金内容不備）（円建）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SK_MSRJIYUUMEISAI_SYORUIHUBI_TAN_YENDT}</td><td>&quot;sk125&quot;</td><td>未整理事由明細（書類不備）単独（円建）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SK_MSRJIYUUMEISAI_SYORUIHUBI_HUKU_YENDT}</td><td>&quot;sk126&quot;</td><td>未整理事由明細（書類不備）複数（円建）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SK_MSRJIYUUMEISAI_SEIRITUHRYUUUKTKTYUU_YENDT}</td><td>&quot;sk127&quot;</td><td>未整理事由明細（成立保留受付中）（円建）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SK_MSRJIYUUBETUKARIUKEKINSYUUKEI_YENDT}</td><td>&quot;sk128&quot;</td><td>未整理事由別仮受金集計表（円建）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SK_MSRJIYUUBETUKARIUKEKINMEISAILIST_YENDT}</td><td>&quot;sk129&quot;</td><td>未整理事由別仮受金明細リスト（円建）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SK_JIDSYUUNOUSYOUGOUMEISAI_KESSAN_YENDT}</td><td>&quot;sk130&quot;</td><td>自動収納照合一致・不一致明細書（決算用）（円建）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SK_KARIUKEKINPKAKINMEISAI_YENDT}</td><td>&quot;sk131&quot;</td><td>仮受金（Ｐ過金）明細（円建）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SK_KARIUKEKINPKAKINZANDAKAMEISAILIST_YENDT}</td><td>&quot;sk132&quot;</td><td>仮受金（Ｐ過金）残高明細リスト（円建）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SR_OIKOMISYUUKEIHYOUTYOUSEI}</td><td>&quot;sr001&quot;</td><td>追込契約集計表（調整伝票）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SR_OIKOMISYUUKEIPDENPYOU}</td><td>&quot;sr002&quot;</td><td>追込契約集計表（保険料伝票リスト）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SR_SK_KESSANHURIDEN}</td><td>&quot;sr003&quot;</td><td>新契約決算用振替伝票</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SR_SK_KESSANHURIDEN_HIKAE}</td><td>&quot;sr004&quot;</td><td>新契約決算用振替伝票（控）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SR_TMTTDMEISAILIST}</td><td>&quot;sr100&quot;</td><td>積立配当金明細表</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SR_KBNKEIRIYOUTMTTDMEISAILIST}</td><td>&quot;sr101&quot;</td><td>区分経理用積立配当金明細表</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SR_KARIWARIATEDMEISAILIS}</td><td>&quot;sr102&quot;</td><td>仮割当配当金明細表</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SR_BIKINKYKSEISANDLIST}</td><td>&quot;sr103&quot;</td><td>備金契約精算Ｄ集計表</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SR_KBNKEIRIYOUBIKINKYKSEISANDLIST}</td><td>&quot;sr104&quot;</td><td>区分経理用備金契約精算Ｄ集計表</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SR_BIKINKYKKARIWARIATEDLIST}</td><td>&quot;sr105&quot;</td><td>備金契約仮割当Ｄ集計表</td></tr>
 *  <tr><td rowspan="503">{@link #PATTERN_TYOHYOIKATUSYUTURYOKU TYOHYOIKATUSYUTURYOKU}<br />(帳票一括出力)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>0</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #USERITIRANHYOU}</td><td>&quot;Ba001&quot;</td><td>ユーザー一覧表</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #CM_JIMURENRAKUHYOU}</td><td>&quot;cm001&quot;</td><td>事務連絡票</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #CM_LINC_MISSLIST}</td><td>&quot;cm002&quot;</td><td>契約管理ＬＩＮＣ受信ミスリスト</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #CM_ONLINE_FBFURIKOMIKEI_1}</td><td>&quot;cm003&quot;</td><td>オンラインＦＢ振込合計リスト１</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #CM_ONLINE_FBFURIKOMIKEI_2}</td><td>&quot;cm004&quot;</td><td>オンラインＦＢ振込合計リスト２</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #CM_ONLINE_GKFBFURIKOMIKEI_1}</td><td>&quot;cm005&quot;</td><td>オンライン外貨ＦＢ振込合計リスト１</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #CM_ONLINE_GKFBFURIKOMIKEI_2}</td><td>&quot;cm006&quot;</td><td>オンライン外貨ＦＢ振込合計リスト２</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #CM_ONLINE_FBSOUKINMEISAI_1}</td><td>&quot;cm007&quot;</td><td>オンラインＦＢ送金明細リスト１</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #CM_ONLINE_FBSOUKINMEISAI_2}</td><td>&quot;cm008&quot;</td><td>オンラインＦＢ送金明細リスト２</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #CM_ONLINE_FBSOUKINMEISAI_3}</td><td>&quot;cm009&quot;</td><td>オンラインＦＢ送金明細リスト３</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #CM_ONLINE_FBSOUKINMEISAI_4}</td><td>&quot;cm010&quot;</td><td>オンラインＦＢ送金明細リスト４</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #CM_ONLINE_FBSOUKINMEISAI_5}</td><td>&quot;cm011&quot;</td><td>オンラインＦＢ送金明細リスト５</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #CM_ONLINE_GKFBSOUKINMEISAI_1}</td><td>&quot;cm012&quot;</td><td>オンライン外貨ＦＢ送金明細リスト１</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #CM_ONLINE_GKFBSOUKINMEISAI_2}</td><td>&quot;cm013&quot;</td><td>オンライン外貨ＦＢ送金明細リスト２</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #CM_ONLINE_GKFBSOUKINMEISAI_3}</td><td>&quot;cm014&quot;</td><td>オンライン外貨ＦＢ送金明細リスト３</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #CM_ONLINE_GKFBSOUKINMEISAI_4}</td><td>&quot;cm015&quot;</td><td>オンライン外貨ＦＢ送金明細リスト４</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #CM_ONLINE_GKFBSOUKINMEISAI_5}</td><td>&quot;cm016&quot;</td><td>オンライン外貨ＦＢ送金明細リスト５</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #CM_BATCH_FBFURIKOMIKEI_4}</td><td>&quot;cm017&quot;</td><td>バッチＦＢ振込合計リスト４</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #CM_BATCH_GKFBFURIKOMIKEI}</td><td>&quot;cm018&quot;</td><td>バッチ外貨ＦＢ振込合計リスト</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #CM_BATCH_FBSOUKINMEISAI_4}</td><td>&quot;cm019&quot;</td><td>バッチＦＢ送金明細リスト４</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #CM_BATCH_GKFBSOUKINMEISAI}</td><td>&quot;cm020&quot;</td><td>バッチ外貨ＦＢ送金明細リスト</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #CM_TIENRSKUTIWAKELIST}</td><td>&quot;cm021&quot;</td><td>支払遅延利息内訳リスト</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #CM_SKHONSYADENPYOULIST}</td><td>&quot;cm022&quot;</td><td>新契約本社用伝票リスト</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #CM_KARIUKEMEISAI_1}</td><td>&quot;cm023&quot;</td><td>仮受計上明細リスト１</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #CM_KARIUKEMEISAI_2}</td><td>&quot;cm024&quot;</td><td>仮受計上明細リスト２</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #CM_KARIUKEMEISAI_3}</td><td>&quot;cm025&quot;</td><td>仮受計上明細リスト３</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #CM_KARIUKEMEISAI_4}</td><td>&quot;cm026&quot;</td><td>仮受計上明細リスト４</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #CM_SIKINIDOULIST_SOKUJI}</td><td>&quot;cm027&quot;</td><td>資金移動リスト（即時分）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #CM_SIKINIDOULIST_TYAKKINBI}</td><td>&quot;cm028&quot;</td><td>資金移動リスト（着金日分）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #CM_HURIKOMIERRINFOLIST}</td><td>&quot;cm029&quot;</td><td>振込入金Ｆエラー情報リスト</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #CM_GKHURIKOMIERRINFOLIST}</td><td>&quot;cm030&quot;</td><td>外貨振込入金Ｆエラー情報リスト</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #CM_HOJYOBOLIST_1}</td><td>&quot;cm031&quot;</td><td>補助簿リスト１</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #CM_HOJYOBOLIST_2}</td><td>&quot;cm032&quot;</td><td>補助簿リスト２</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #CM_HOJYOBOLIST_3}</td><td>&quot;cm033&quot;</td><td>補助簿リスト３</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #CM_HOJYOBOLIST_4}</td><td>&quot;cm034&quot;</td><td>補助簿リスト４</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #CM_HOJYOBOLIST_5}</td><td>&quot;cm035&quot;</td><td>補助簿リスト５</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #BZ_JIGYOUHIKANJYOUKAKUSYOULIST_1}</td><td>&quot;cm041&quot;</td><td>事業費勘定確証リスト1</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #BZ_JIGYOUHIKANJYOUKAKUSYOULIST_2}</td><td>&quot;cm042&quot;</td><td>事業費勘定確証リスト2</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #CM_TUUSANKAWASERATEKAKUNIN}</td><td>&quot;cm043&quot;</td><td>通算判定用為替レート確認書</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #CM_HOJYOBOLIST_6}</td><td>&quot;cm044&quot;</td><td>補助簿リスト６</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #CM_KARIUKEMEISAI_5}</td><td>&quot;cm045&quot;</td><td>仮受計上明細リスト５</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #CM_ONLINE_FBSOUKINMEISAI_6}</td><td>&quot;cm046&quot;</td><td>オンラインＦＢ送金明細リスト６</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #CM_SIKINIDOULIST_YENDTHNK}</td><td>&quot;cm047&quot;</td><td>資金移動リスト（円建変更分）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #CM_BATCH_FBSOUKINMEISAI_7}</td><td>&quot;cm048&quot;</td><td>バッチＦＢ送金明細リスト７</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #CM_ONLINE_FBSOUKINMEISAI_7}</td><td>&quot;cm049&quot;</td><td>オンラインＦＢ送金明細リスト７</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #CM_MYNUMBERTYUUSYUTULIST}</td><td>&quot;cm050&quot;</td><td>マイナンバー帳票抽出リスト</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #CM_HOJYOBOLIST_7}</td><td>&quot;cm051&quot;</td><td>補助簿リスト７</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #CM_KBTKARIKANJYOUZNDKSYUKILIST}</td><td>&quot;cm052&quot;</td><td>個別仮勘定残高集計リスト</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #CM_SIKINIDOULIST_HIJYNNYK}</td><td>&quot;cm053&quot;</td><td>資金移動リスト（平準払入金分）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #CM_BATCH_FBFURIKOMIKEI_2}</td><td>&quot;cm054&quot;</td><td>バッチＦＢ振込合計リスト２</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #CM_BATCH_FBSOUKINMEISAI_2}</td><td>&quot;cm055&quot;</td><td>バッチＦＢ送金明細リスト２</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #CM_SIKINIDOULIST_HTKIN}</td><td>&quot;cm056&quot;</td><td>資金移動リスト（配当金分）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #CM_KARIUKEMEISAI_6}</td><td>&quot;cm057&quot;</td><td>仮受計上明細リスト６</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #CM_BATCH_FBFURIKOMIKEI_3}</td><td>&quot;cm058&quot;</td><td>バッチＦＢ振込合計リスト３</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #CM_BATCH_FBSOUKINMEISAI_3}</td><td>&quot;cm059&quot;</td><td>バッチＦＢ送金明細リスト３</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #DS_KARIPWTUUTITYUUDANLIST}</td><td>&quot;ds001&quot;</td><td>仮パスワード通知作成中断リスト</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #DS_KOUZOKUJIMUKAKUNINLIST}</td><td>&quot;ds011&quot;</td><td>ＤＳ後続事務確認リスト</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HK_SHRMESS}</td><td>&quot;hk001&quot;</td><td>支払明細書</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HK_SHMEISAI_SDS}</td><td>&quot;hk003&quot;</td><td>支払明細書（診断書料）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HK_SB_HOKEN_SKS}</td><td>&quot;hk011&quot;</td><td>死亡保険金請求書</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HK_SEISANKINHRKM_IRAIS}</td><td>&quot;hk015&quot;</td><td>精算金振込依頼書</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HK_SB_DAIHYOU}</td><td>&quot;hk031&quot;</td><td>代表選任届（死亡）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HK_KD_JIKOJKS}</td><td>&quot;hk041&quot;</td><td>事故状況報告書（高度障害）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HK_JIJYOUTODOKEKENSEIYAKUSYO}</td><td>&quot;hk051&quot;</td><td>事情届兼誓約書</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HK_TEISYUTUSYORUI}</td><td>&quot;hk061&quot;</td><td>ご提出書類について</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HK_MYNUMBER_CHYOU}</td><td>&quot;hk082&quot;</td><td>マイナンバーＣ票</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HK_SOUHU}</td><td>&quot;hk090&quot;</td><td>送付案内</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HK_STI_KAS}</td><td>&quot;hk101&quot;</td><td>死亡診断書（死体検案書）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HK_SB_SONOTA_SDS}</td><td>&quot;hk102&quot;</td><td>その他診断書類</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HK_SB_KTJKSMS}</td><td>&quot;hk104&quot;</td><td>交通事故証明書</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HK_SB_HKNSYKN}</td><td>&quot;hk106&quot;</td><td>保険証券</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HK_SB_KOSEKI}</td><td>&quot;hk108&quot;</td><td>戸籍謄（抄）本</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HK_SB_HONNINSR}</td><td>&quot;hk110&quot;</td><td>本人確認書類</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HK_SB_JYUUMIN}</td><td>&quot;hk112&quot;</td><td>住民票</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HK_SB_INKAN}</td><td>&quot;hk114&quot;</td><td>印鑑証明書</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HK_SB_KAKUNINDOUISYO}</td><td>&quot;hk116&quot;</td><td>確認書兼同意書</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HK_SB_SKKANSYOUKNK}</td><td>&quot;hk117&quot;</td><td>請求勧奨関係書類</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HK_MYNUMBER_SYORUI}</td><td>&quot;hk118&quot;</td><td>マイナンバー書類</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HK_SB_SONOTA_SKS}</td><td>&quot;hk131&quot;</td><td>その他請求書類</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HK_ENKASIHARAIRYUUIJIKOU}</td><td>&quot;hk201&quot;</td><td>円貨支払留意事項説明文書</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HK_SB_HUBITEISEI}</td><td>&quot;hk301&quot;</td><td>不備訂正書</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HK_SB_HUBITEISEI2}</td><td>&quot;hk303&quot;</td><td>不備訂正書（仮作成）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HK_HUBITEISEI_SOUHU}</td><td>&quot;hk311&quot;</td><td>不備訂正書の送付案内</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HK_SB_HUBIKNK}</td><td>&quot;hk321&quot;</td><td>不備関係書類</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HK_SB_KAKUNINIRAIS}</td><td>&quot;hk401&quot;</td><td>確認依頼書</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HK_SB_KAKUNINHKS}</td><td>&quot;hk411&quot;</td><td>確認報告書</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HK_BIKINSAGYOULIST}</td><td>&quot;hk501&quot;</td><td>保険金給付金備金作業リスト</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HK_BIKINJIKOUKIST}</td><td>&quot;hk502&quot;</td><td>保険金給付金備金時効リスト</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HK_BIKINJIKOUKIST_GOUKEI}</td><td>&quot;hk503&quot;</td><td>保険金給付金備金時効リスト合計表</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HK_ZENNOUSEISANKINMEISAILIST}</td><td>&quot;hk504&quot;</td><td>前納精算金明細リスト</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HK_JIKOUDENMEISAILIST}</td><td>&quot;hk505&quot;</td><td>時効伝票明細リスト</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HK_SB_SONOTA}</td><td>&quot;hk902&quot;</td><td>その他</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_ADRHNK_TTDKKR}</td><td>&quot;kk001&quot;</td><td>お手続き完了のお知らせ　住所変更</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_ADRHNK_GAIBU_TTDKKR}</td><td>&quot;kk002&quot;</td><td>お手続き完了のお知らせ　住所変更≪外部印刷≫</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_MEIGIHNK_TTDKKR}</td><td>&quot;kk003&quot;</td><td>お手続き完了のお知らせ　名義変更</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_STDRHNK_TTDKKR}</td><td>&quot;kk004&quot;</td><td>お手続き完了のお知らせ　被保険者代理特約中途付加</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_SEINENGAPPISEI_TTDKKR}</td><td>&quot;kk005&quot;</td><td>お手続き完了のお知らせ　生年月日・性訂正</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_SEINENGAPPISEI_TTDKKR_SHRARI}</td><td>&quot;kk043&quot;</td><td>お手続き完了のお知らせ　生年月日・性訂正（支払あり）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_GENGAKU_TTDKKR}</td><td>&quot;kk006&quot;</td><td>お手続き完了のお知らせ　減額</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_NKTKYKHNK_TTDKKR}</td><td>&quot;kk007&quot;</td><td>お手続き完了のお知らせ　年金支払特約変更</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_TARGETHNK_TTDKKR}</td><td>&quot;kk008&quot;</td><td>お手続き完了のお知らせ　ターゲット特約変更</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_TARGETHNK_GAIBU_TTDKKR}</td><td>&quot;kk009&quot;</td><td>お手続き完了のお知らせ　ターゲット特約変更≪外部印刷≫</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_KAIYAKU_TTDKKR}</td><td>&quot;kk010&quot;</td><td>お手続き完了のお知らせ　解約</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_KAIYAKU_GAIBU_TTDKKR}</td><td>&quot;kk011&quot;</td><td>お手続き完了のお知らせ　解約≪外部印刷≫</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_KAIYAKU_SAIKENSYA_TTDKKR}</td><td>&quot;kk012&quot;</td><td>お手続き完了のお知らせ　解約（債権者用）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_SHRKZHNK_TTDKKR}</td><td>&quot;kk013&quot;</td><td>お手続き完了のお知らせ　支払口座変更</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_SYOSAIHK_TTDKKR}</td><td>&quot;kk014&quot;</td><td>お手続き完了のお知らせ　証券再発行</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_KYKTRKS_KYKTRKSTTDKKR}</td><td>&quot;kk015&quot;</td><td>お手続き完了のお知らせ　契約取消（契約取消）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_CLGOFF_KYKTRKSTTDKKR}</td><td>&quot;kk016&quot;</td><td>お手続き完了のお知らせ　契約取消（クーリングオフ）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_KAIJYO_KYKTRKSTTDKKR}</td><td>&quot;kk017&quot;</td><td>お手続き完了のお知らせ　契約取消（解除）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_SBKAIJYO_KYKTRKSTTDKKR}</td><td>&quot;kk018&quot;</td><td>お手続き完了のお知らせ　契約取消（死亡解除）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_SBMENSEKI_KYKTRKSTTDKKR}</td><td>&quot;kk019&quot;</td><td>お手続き完了のお知らせ　契約取消（死亡免責）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_KAIGOMAETKHNK_TTDKKR}</td><td>&quot;kk020&quot;</td><td>お手続き完了のお知らせ　重度介護前払特約変更</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_SBMUKOU_KYKTRKSTTDKKR}</td><td>&quot;kk021&quot;</td><td>お手続き完了のお知らせ　契約取消（契約無効）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_MOUSIDEMUKOU_KYKTRKSTTDKKR}</td><td>&quot;kk022&quot;</td><td>お手続き完了のお知らせ　契約取消（申出無効）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_HRIHEN_TTDKKR}</td><td>&quot;kk023&quot;</td><td>お手続き完了のお知らせ　払方変更</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_HUKKATU_TTDKKR}</td><td>&quot;kk024&quot;</td><td>お手続き完了のお知らせ　復活</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_HUKKATU_OKOTOWARI}</td><td>&quot;kk025&quot;</td><td>お断り状　（謝絶通知）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_MKHGKHNK_TTDKKR}</td><td>&quot;kk026&quot;</td><td>お手続き完了のお知らせ　目標額変更</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_YENDTHNKHNRKN_TTDKKR}</td><td>&quot;kk027&quot;</td><td>お手続き完了のお知らせ　円建変更時返戻金</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_TUMITATEKINITEN_TTDKKR}</td><td>&quot;kk028&quot;</td><td>お手続き完了のお知らせ　積立金移転</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_YENDTHNK_HNRKNSKS_TTDKKR}</td><td>&quot;kk029&quot;</td><td>契約変更完了のお知らせ　円建終身変更（請求書同封）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_YENDTHNK_TTDKKR}</td><td>&quot;kk030&quot;</td><td>契約変更完了のお知らせ　円建終身変更</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_YENDTHNK_TTDKKR_3}</td><td>&quot;kk042&quot;</td><td>契約変更完了のお知らせ　円建終身変更２</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_DSHR_TTDKKR}</td><td>&quot;kk031&quot;</td><td>お手続き完了のお知らせ　配当金支払</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_GENGAKU_ZEITEKI_TTDKKR}</td><td>&quot;kk032&quot;</td><td>お手続き完了のお知らせ　減額（税適付加）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_YENDTHNK_NINI_TTDKKR}</td><td>&quot;kk033&quot;</td><td>契約変更完了のお知らせ　円建年金変更（任意請求）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_YENDTHNK_NINI_TTDKKR_2}</td><td>&quot;kk041&quot;</td><td>契約変更完了のお知らせ　円建終身変更（任意請求）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_SYOUMETU_GAIBU_TTDKKR}</td><td>&quot;kk034&quot;</td><td>お手続き完了のお知らせ　消滅</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_YENDTHNK_TTDKKR_2}</td><td>&quot;kk035&quot;</td><td>契約変更完了のお知らせ　円建年金変更</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_DTUIBARAI_TTDKKR}</td><td>&quot;kk036&quot;</td><td>お手続き完了のお知らせ　配当金追払</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_DTUIBARAI_TTDKKR_ZEIMUNASI}</td><td>&quot;kk037&quot;</td><td>お手続き完了のお知らせ　配当金追払（税務情報なし）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_KZKTRKKYKDRHNK_TTDKKR}</td><td>&quot;kk038&quot;</td><td>お手続き完了のお知らせ　家族登録・契約者代理特約変更</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_KZKTRKTYOKUSOU_TTDKKR}</td><td>&quot;kk039&quot;</td><td>お手続き完了のお知らせ　家族登録（直送）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_KZKTRKSKEI_TTDKKR}</td><td>&quot;kk040&quot;</td><td>お手続き完了のお知らせ　家族登録（新契約時）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_ADRHNK_SKS}</td><td>&quot;kk051&quot;</td><td>住所（電話番号）変更届出書</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_MEIGIHNK_SKS}</td><td>&quot;kk052&quot;</td><td>名義変更請求書</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_STDRHNK_SKS}</td><td>&quot;kk053&quot;</td><td>被保険者代理特約中途付加請求書</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_SEINENGAPPISEI_SKS}</td><td>&quot;kk054&quot;</td><td>生年月日・性訂正請求書</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_GENGAKU_SKS}</td><td>&quot;kk055&quot;</td><td>減額請求書</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_NKTKYKHNK_SKS}</td><td>&quot;kk056&quot;</td><td>年金支払特約変更請求書</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_TARGETHNK_SKS}</td><td>&quot;kk057&quot;</td><td>ターゲット特約変更請求書</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_KAIYAKU_SKS}</td><td>&quot;kk058&quot;</td><td>解約請求書</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_SHRKZHNK_SKS}</td><td>&quot;kk059&quot;</td><td>支払口座変更請求書</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_SYOSAIHK_SKS}</td><td>&quot;kk060&quot;</td><td>証券再発行請求書</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_KAIGOMAETKHNK_SKS}</td><td>&quot;kk061&quot;</td><td>重度介護前払特約変更請求書</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_KAIJYO_SKS}</td><td>&quot;kk062&quot;</td><td>精算金請求書（解除）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_SBKAIJYO_SKS}</td><td>&quot;kk063&quot;</td><td>精算金請求書（死亡解除）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_SBMENSEKI_SKS}</td><td>&quot;kk064&quot;</td><td>精算金請求書（免責）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_HRIHEN_SKS}</td><td>&quot;kk065&quot;</td><td>払込経路変更請求書</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_HRIKAIHEN_SKS}</td><td>&quot;kk066&quot;</td><td>払込回数変更請求書</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_HUKKATU_SKS}</td><td>&quot;kk067&quot;</td><td>復活請求書</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_MOUSIDEMUKOU_SKS}</td><td>&quot;kk068&quot;</td><td>申出無効請求書</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_GANMUKOU_SKS}</td><td>&quot;kk069&quot;</td><td>精算金請求書（がん無効）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_MKHGKHNK_SKS}</td><td>&quot;kk070&quot;</td><td>目標額変更請求書</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_YENDTHNKHNRKN_SKS}</td><td>&quot;kk071&quot;</td><td>円建変更時返戻金請求書</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_TUMITATEKINITEN_SKS}</td><td>&quot;kk072&quot;</td><td>積立金移転請求書</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_DSHR_SKS}</td><td>&quot;kk073&quot;</td><td>配当金支払請求書</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_YENDTHNK_SKS}</td><td>&quot;kk074&quot;</td><td>円建変更請求書</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_KZKTRKKYKDRTKYKHNK_SKS}</td><td>&quot;kk075&quot;</td><td>家族登録・契約者代理特約変更請求書</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_ADRHNK_SOUHU}</td><td>&quot;kk101&quot;</td><td>住所（電話番号）変更届出書の送付案内</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_MEIGIHNK_SOUHU}</td><td>&quot;kk102&quot;</td><td>名義変更請求書の送付案内</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_STDRHNK_SOUHU}</td><td>&quot;kk103&quot;</td><td>被保険者代理特約中途付加請求書の送付案内</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_SEINENGAPPISEI_SOUHU}</td><td>&quot;kk104&quot;</td><td>生年月日・性訂正請求書の送付案内</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_GENGAKU_SOUHU}</td><td>&quot;kk105&quot;</td><td>減額請求書の送付案内</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_NKTKYKHNK_SOUHU}</td><td>&quot;kk106&quot;</td><td>年金支払特約変更請求書の送付案内</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_TARGETHNK_SOUHU}</td><td>&quot;kk107&quot;</td><td>ターゲット特約変更請求書の送付案内</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_KAIYAKU_SKSSOUHU}</td><td>&quot;kk108&quot;</td><td>解約請求書の送付案内</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_SHRKZHNK_SOUHU}</td><td>&quot;kk109&quot;</td><td>支払口座変更請求書の送付案内</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_SYOSAIHK_SOUHU}</td><td>&quot;kk110&quot;</td><td>証券再発行請求書の送付案内</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_KAIGOMAETKHNK_SOUHU}</td><td>&quot;kk111&quot;</td><td>重度介護前払特約変更請求書の送付案内</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_SBMENSEKI_SOUHU}</td><td>&quot;kk112&quot;</td><td>精算金請求書（免責）の送付案内</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_HRIHEN_SOUHU}</td><td>&quot;kk113&quot;</td><td>払込経路変更請求書の送付案内</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_HUKKATU_SOUHU}</td><td>&quot;kk114&quot;</td><td>復活請求書の送付案内</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_MOUSIDEMUKOU_SOUHU}</td><td>&quot;kk115&quot;</td><td>申出無効請求書の送付案内</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_GANMUKOU_SOUHU}</td><td>&quot;kk116&quot;</td><td>精算金請求書（がん無効）の送付案内</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_MKHGKHNK_SOUHU}</td><td>&quot;kk117&quot;</td><td>目標額変更請求書の送付案内</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_YENDTHNKHNRKN_SOUHU}</td><td>&quot;kk118&quot;</td><td>円建変更時返戻金請求書の送付案内</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_TUMITATEKINITEN_SOUHU}</td><td>&quot;kk119&quot;</td><td>積立金移転請求書の送付案内</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_DSHR_SOUHU}</td><td>&quot;kk120&quot;</td><td>配当金支払請求書の送付案内</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_YENDTHNK_SOUHU}</td><td>&quot;kk121&quot;</td><td>円建変更請求書の送付案内</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_KZKTRKKYKDRTKYKHNK_SOUHU}</td><td>&quot;kk122&quot;</td><td>家族登録・契約者代理特約変更請求書の送付案内</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_HUBITEISEISYO_SOUHU}</td><td>&quot;kk150&quot;</td><td>不備訂正書の送付案内</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_ADRHNK_HB}</td><td>&quot;kk151&quot;</td><td>不備訂正書（住所変更）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_MEIGIHNK_HB}</td><td>&quot;kk152&quot;</td><td>不備訂正書（名義変更）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_STDRHNK_HB}</td><td>&quot;kk153&quot;</td><td>不備訂正書（被保険者代理特約中途付加）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_SEINENGAPPISEI_HB}</td><td>&quot;kk154&quot;</td><td>不備訂正書（生年月日・性訂正）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_GENGAKU_HB}</td><td>&quot;kk155&quot;</td><td>不備訂正書（減額）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_NKTKYKHNK_HB}</td><td>&quot;kk156&quot;</td><td>不備訂正書（年金支払特約変更）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_TARGETHNK_HB}</td><td>&quot;kk157&quot;</td><td>不備訂正書（ターゲット特約変更）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_KAIYAKU_HB}</td><td>&quot;kk158&quot;</td><td>不備訂正書（解約）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_SHRKZHNK_HB}</td><td>&quot;kk159&quot;</td><td>不備訂正書（支払口座変更）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_SYOSAIHK_HB}</td><td>&quot;kk160&quot;</td><td>不備訂正書（証券再発行）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_KYKTORIKESI_HB}</td><td>&quot;kk161&quot;</td><td>不備訂正書（契約取消）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_CLGOFF_HB}</td><td>&quot;kk162&quot;</td><td>不備訂正書（クーリングオフ）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_KAIJYO_HB}</td><td>&quot;kk163&quot;</td><td>不備訂正書（解除）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_MUKOU_HB}</td><td>&quot;kk164&quot;</td><td>不備訂正書（無効）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_SBKAIJYO_HB}</td><td>&quot;kk165&quot;</td><td>不備訂正書（死亡解除）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_SBMENSEKI_HB}</td><td>&quot;kk166&quot;</td><td>不備訂正書（死亡免責）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_KAIGOMAETKHNK_HB}</td><td>&quot;kk167&quot;</td><td>不備訂正書（重度介護前払特約変更）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_SBMUKOU_HB}</td><td>&quot;kk168&quot;</td><td>不備訂正書（死亡無効（既払Ｐ支払））</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_SBMUKOUNOSHR_HB}</td><td>&quot;kk169&quot;</td><td>不備訂正書（死亡無効（支払なし））</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_SBMENSEKINOSHR_HB}</td><td>&quot;kk170&quot;</td><td>不備訂正書（死亡免責（支払なし））</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_HUBI_KARISAKUSEI}</td><td>&quot;kk171&quot;</td><td>不備訂正書（仮作成）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_MKHGKHNK_HB}</td><td>&quot;kk172&quot;</td><td>不備訂正書（目標額変更）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_YENDTHNKHNRKN_HB}</td><td>&quot;kk173&quot;</td><td>不備訂正書（円建変更時返戻金）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_TUMITATEKINITEN_HB}</td><td>&quot;kk174&quot;</td><td>不備訂正書（積立金移転）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_DSHR_HB}</td><td>&quot;kk175&quot;</td><td>不備訂正書（配当金支払）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_YENDTHNK_NINI_HB}</td><td>&quot;kk176&quot;</td><td>不備訂正書（円建変更受付（任意請求））</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_KZKTRK_KYKDRTKYKHNK_HB}</td><td>&quot;kk177&quot;</td><td>不備訂正書（家族登録／契約者代理特約変更）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_ADRHNK_HBLIST}</td><td>&quot;kk201&quot;</td><td>不備未解消リスト（住所変更）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_MEIGIHNK_HBLIST}</td><td>&quot;kk202&quot;</td><td>不備未解消リスト（名義変更）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_STDRHNK_HBLIST}</td><td>&quot;kk203&quot;</td><td>不備未解消リスト（被保険者代理特約中途付加）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_SEINENGAPPISEI_HBLIST}</td><td>&quot;kk204&quot;</td><td>不備未解消リスト（生年月日・性訂正）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_GENGAKU_HBLIST}</td><td>&quot;kk205&quot;</td><td>不備未解消リスト（減額）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_NKTKYKHNK_HBLIST}</td><td>&quot;kk206&quot;</td><td>不備未解消リスト（年金支払特約変更）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_TARGETHNK_HBLIST}</td><td>&quot;kk207&quot;</td><td>不備未解消リスト（ターゲット特約変更）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_KAIYAKU_HBLIST}</td><td>&quot;kk208&quot;</td><td>不備未解消リスト（解約）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_SHRKZHNK_HBLIST}</td><td>&quot;kk209&quot;</td><td>不備未解消リスト（支払口座変更）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_SYOSAIHK_HBLIST}</td><td>&quot;kk210&quot;</td><td>不備未解消リスト（証券再発行）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_KYKTORIKESI_HBLIST}</td><td>&quot;kk211&quot;</td><td>不備未解消リスト（契約取消）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_CLGOFF_HBLIST}</td><td>&quot;kk212&quot;</td><td>不備未解消リスト（クーリングオフ）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_KAIJYO_HBLIST}</td><td>&quot;kk213&quot;</td><td>不備未解消リスト（解除）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_MUKOU_HBLIST}</td><td>&quot;kk214&quot;</td><td>不備未解消リスト（無効）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_SBKAIJYO_HBLIST}</td><td>&quot;kk215&quot;</td><td>不備未解消リスト（死亡解除）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_SBMENSEKI_HBLIST}</td><td>&quot;kk216&quot;</td><td>不備未解消リスト（死亡免責）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_KAIGOMAETKHNK_HBLIST}</td><td>&quot;kk217&quot;</td><td>不備未解消リスト（重度介護前払特約変更）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_SBMUKOU_HBLIST}</td><td>&quot;kk218&quot;</td><td>不備未解消リスト（死亡無効（既払Ｐ支払））</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_SBMUKOUNOSHR_HBLIST}</td><td>&quot;kk219&quot;</td><td>不備未解消リスト（死亡無効（支払なし））</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_SBMENSEKINOSHR_HBLIST}</td><td>&quot;kk220&quot;</td><td>不備未解消リスト（死亡免責（支払なし））</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_MKHGKHNK_HBLIST}</td><td>&quot;kk221&quot;</td><td>不備未解消リスト（目標額変更）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_YENDTHNKHNRKN_HBLIST}</td><td>&quot;kk222&quot;</td><td>不備未解消リスト（円建変更時返戻金）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_TUMITATEKINITEN_HBLIST}</td><td>&quot;kk223&quot;</td><td>不備未解消リスト（積立金移転）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_DSHR_HBLIST}</td><td>&quot;kk224&quot;</td><td>不備未解消リスト（配当金支払）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_YENDTHNK_NINI_HBLIST}</td><td>&quot;kk225&quot;</td><td>不備未解消リスト（円建変更受付（任意請求））</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_KZKTRK_KYKDRTKYKHNK_HBLIST}</td><td>&quot;kk226&quot;</td><td>不備未解消リスト（家族登録／契約者代理特約変更）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_NKTKYKHNK_GAIYOU}</td><td>&quot;kk251&quot;</td><td>年金支払特約　契約概要・注意喚起情報</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_KAIGOMAETK_KYKGAIYOU}</td><td>&quot;kk252&quot;</td><td>重度介護前払特約　契約概要</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_KAIGOMAETK_TYUUIKANKI}</td><td>&quot;kk253&quot;</td><td>重度介護前払特約　注意喚起情報</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_MYNUMBER_SYORUI_GENGAKU}</td><td>&quot;kk256&quot;</td><td>マイナンバー書類（減額）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_MYNUMBER_SYORUI_KAIYAKU}</td><td>&quot;kk257&quot;</td><td>マイナンバー書類（解約）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_MYNUMBER_SYORUI_YENDTHNKHNRKN}</td><td>&quot;kk258&quot;</td><td>マイナンバー書類（円建変更時返戻金）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_MEIGIHNK_DAIHYOUSN}</td><td>&quot;kk260&quot;</td><td>代表選任届（名義変更）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_KAIYAKU_DAIHYOUSN}</td><td>&quot;kk261&quot;</td><td>代表選任届（解約）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_YENDTHNKHNRKN_DAIHYOUSN}</td><td>&quot;kk262&quot;</td><td>代表選任届（円建変更時返戻金）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_MEIGIHNK_TORIHIKIKAK}</td><td>&quot;kk266&quot;</td><td>取引時確認記録書（名義変更）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_KAIYAKU_TORIHIKIKAK}</td><td>&quot;kk267&quot;</td><td>取引時確認記録書（解約）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_SOUHUANNAI}</td><td>&quot;kk270&quot;</td><td>送付案内（汎用）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_SHIHARAI_SOUHU}</td><td>&quot;kk271&quot;</td><td>支払請求書の送付案内</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_HKNSYKN}</td><td>&quot;kk301&quot;</td><td>保険証券</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_HKNSYKNITIJI}</td><td>&quot;kk302&quot;</td><td>保険証券（一時払）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_SKSYOUKEN}</td><td>&quot;kk303&quot;</td><td>新契約証券</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_SAISYOUKEN}</td><td>&quot;kk304&quot;</td><td>再発行証券</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_SUIIHYOU}</td><td>&quot;kk305&quot;</td><td>推移表</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_GAIKA_KOKYAKUTUUTI}</td><td>&quot;kk306&quot;</td><td>外貨建顧客通知</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_SEISANDHANEITUUTI}</td><td>&quot;kk307&quot;</td><td>精算Ｄ反映通知</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_KOUJYOSYOUMEIS}</td><td>&quot;kk311&quot;</td><td>控除証明書</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_KOUJYOSYOUMEIS_GAIBU}</td><td>&quot;kk312&quot;</td><td>控除証明書≪外部印刷≫</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_KOUJYOSYOUMEIS_SG}</td><td>&quot;kk313&quot;</td><td>控除証明書（総合通知用）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_SINNINTOUHYOU}</td><td>&quot;kk320&quot;</td><td>信任投票はがき</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_SYAINMEIBO}</td><td>&quot;kk322&quot;</td><td>社員名簿</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_GENKYOUTUUTI}</td><td>&quot;kk323&quot;</td><td>現況通知</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_JIGYOUNENDOMATU}</td><td>&quot;kk324&quot;</td><td>事業年度末通知</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_SOUGOUTUUTI}</td><td>&quot;kk341&quot;</td><td>総合通知</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_ANSINDAYORI}</td><td>&quot;kk342&quot;</td><td>安心だより</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_KOUHURIMINYUUTUUTI}</td><td>&quot;kk402&quot;</td><td>口座振替未入通知</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_1PNYKNKANSYOUTUUTI}</td><td>&quot;kk405&quot;</td><td>第１回保険料入金勧奨通知（振込）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_MUKOUTUUTI}</td><td>&quot;kk406&quot;</td><td>無効通知</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_SIKKOUTUUTI}</td><td>&quot;kk407&quot;</td><td>失効通知</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_JIMURENRAKU}</td><td>&quot;kk801&quot;</td><td>事務連絡票</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_JIMURENRAKU_GENGAKU}</td><td>&quot;kk802&quot;</td><td>事務連絡票（減額）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_JIMURENRAKU_SEINENGAPPISEITEISEI}</td><td>&quot;kk803&quot;</td><td>事務連絡票（被保険者生年月日・性訂正）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_JIMURENRAKU_KYKTORIKESI}</td><td>&quot;kk804&quot;</td><td>事務連絡票（契約取消）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_JIMURENRAKU_MEIGIHNK}</td><td>&quot;kk805&quot;</td><td>事務連絡票（名義変更）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_JIMURENRAKU_TETUDUKITYUUI}</td><td>&quot;kk806&quot;</td><td>事務連絡票（手続注意設定）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_SYOUKENMS_SKEI}</td><td>&quot;kk811&quot;</td><td>証券作成契約明細リスト（新契約）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_SYOUKENMS_SAI}</td><td>&quot;kk812&quot;</td><td>証券作成契約明細リスト（再発行）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_SYOUKENTOKUSYU_SKEI}</td><td>&quot;kk813&quot;</td><td>証券特殊処理明細リスト（新契約）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_SYOUKENTOKUSYU_SAI}</td><td>&quot;kk814&quot;</td><td>証券特殊処理明細リスト（再発行）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_INSIZEILIST_SKEI}</td><td>&quot;kk815&quot;</td><td>印紙税申告納付用リスト（新契約）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_INSIZEILIST_SAI}</td><td>&quot;kk816&quot;</td><td>印紙税申告納付用リスト（再発行）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_TRKKZKKNRTUUTISAGYOULIST}</td><td>&quot;kk817&quot;</td><td>登録ご家族あて完了通知　事後作業リスト（通知対象者用）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_GENSENLIST}</td><td>&quot;kk821&quot;</td><td>源泉徴収リスト</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_TYOUSYOLIST_UK_KAIJYO}</td><td>&quot;kk822&quot;</td><td>受取人別（解除）確認要リスト</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_TYOUSYOLIST_UK_MENSEKI}</td><td>&quot;kk823&quot;</td><td>受取人別（免責）確認要リスト</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_TYOUSYOLIST_ITJ_KAIYAKU}</td><td>&quot;kk826&quot;</td><td>一時金（解約）確認要リスト</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_KAIYAKU_BIKINSAGYOULIST}</td><td>&quot;kk828&quot;</td><td>解約備金作業リスト</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_KAIYAKU_BIKINJIKOUKIST}</td><td>&quot;kk829&quot;</td><td>解約備金時効リスト</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_KH_BIKINLIST}</td><td>&quot;kk830&quot;</td><td>契約変更備金リスト</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_YENDTHNK_BIKINLIST}</td><td>&quot;kk831&quot;</td><td>円建変更時返戻金備金リスト</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_ZENNOUSEISANKINMEISAILIST_GENGAKU}</td><td>&quot;kk832&quot;</td><td>前納精算金明細リスト（減額）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_ZENNOUSEISANKINMEISAILIST_KAIYAKU}</td><td>&quot;kk833&quot;</td><td>前納精算金明細リスト（解約）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_MKKPHENKINLIST_GENGAKU}</td><td>&quot;kk834&quot;</td><td>未経過Ｐ返金リスト（減額）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_MKKPHENKINLIST_KAIYAKU}</td><td>&quot;kk835&quot;</td><td>未経過Ｐ返金リスト（解約）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_AZUKARIKINLIST}</td><td>&quot;kk836&quot;</td><td>預り金リスト</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_AZUKARIKIN_BIKINLIST}</td><td>&quot;kk837&quot;</td><td>預り金備金リスト</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_SYOURAIW_SISANHYOU}</td><td>&quot;kk851&quot;</td><td>将来解約返戻金試算表</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_HNGKUNEIHIKAKLIST}</td><td>&quot;kk852&quot;</td><td>変額特別勘定運営費確認リスト</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_KACHECK_YOHURI_MISSLIST}</td><td>&quot;kk861&quot;</td><td>口座情報マスタチェックミスリスト（預振口座用）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_KACHECK_SHRKZ_MISSLIST}</td><td>&quot;kk862&quot;</td><td>口座情報マスタチェックミスリスト（定期金支払口座用）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_KYKINFOTORIKOMI_MISSLIST}</td><td>&quot;kk863&quot;</td><td>契約情報取込ミスリスト</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_SHRKEKKATORIKOMI_MISSLIST}</td><td>&quot;kk864&quot;</td><td>支払結果情報取込ミスリスト</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_KZHURIANNAISEL_MISSLIST}</td><td>&quot;kk865&quot;</td><td>口振案内データ抽出ミスリスト</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_YUUKOUKEKKAHANEI_MISSLIST}</td><td>&quot;kk866&quot;</td><td>有効性確認結果反映ミスリスト</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_AUTHORIKEKKAHANEI_MISSLIST}</td><td>&quot;kk867&quot;</td><td>オーソリ結果反映ミスリスト</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_URIAGEKEKKATRSKS_MISSLIST}</td><td>&quot;kk868&quot;</td><td>売上結果ＴＲ作成ミスリスト</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_NYUUKIN_MISSLIST}</td><td>&quot;kk869&quot;</td><td>入金処理ミスリスト</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_LINC_MISSLIST}</td><td>&quot;kk870&quot;</td><td>契約管理ＬＩＮＣ受信ミスリスト</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_MINYUUITIRAN}</td><td>&quot;kk871&quot;</td><td>未入一覧表</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_SIKKOUITIRAN}</td><td>&quot;kk872&quot;</td><td>失効一覧表</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_HANDKARIKANJYOU}</td><td>&quot;kk873&quot;</td><td>ハンド仮勘定票</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_DHANEI_MISSLIST}</td><td>&quot;kk874&quot;</td><td>配当金反映ミスリスト</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_BATCHKAIYAKU_MISSLIST}</td><td>&quot;kk875&quot;</td><td>バッチ解約ミスリスト</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_YENDTHNK_MISSLIST}</td><td>&quot;kk876&quot;</td><td>円建変更ミスリスト</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_YENDTHNKSEL_MISSLIST}</td><td>&quot;kk877&quot;</td><td>円建変更対象抽出ミスリスト</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_SEISANDHANEI_MISSLIST}</td><td>&quot;kk878&quot;</td><td>精算Ｄ反映ミスリスト</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_DSEISAN_MISSLIST}</td><td>&quot;kk879&quot;</td><td>Ｄ精算ミスリスト</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_SISUURENDOTMTTKNHANEI_MISSLIST}</td><td>&quot;kk880&quot;</td><td>指数連動積増型年金積立金反映ミスリスト</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_GAIKAKOKYAKUTUUTISKS_MISSLIST}</td><td>&quot;kk881&quot;</td><td>外貨建顧客通知作成ミスリスト</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_BATCHMKHGKHENKOU_MISSLIST}</td><td>&quot;kk882&quot;</td><td>バッチ目標額変更ミスリスト</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_SEIKYUKNK_SYOSAIHK}</td><td>&quot;kk901&quot;</td><td>請求関係書類（証券再発行）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_HUBIKNK_SYOSAIHK}</td><td>&quot;kk902&quot;</td><td>不備関係書類（証券再発行）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_SEIKYUKNK_MEIGIHNK}</td><td>&quot;kk903&quot;</td><td>請求関係書類（名義変更）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_HUBIKNK_MEIGIHNK}</td><td>&quot;kk904&quot;</td><td>不備関係書類（名義変更）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_SEIKYUKNK_SEINENGAPPISEI}</td><td>&quot;kk905&quot;</td><td>請求関係書類（生年月日・性訂正）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_HUBIKNK_SEINENGAPPISEI}</td><td>&quot;kk906&quot;</td><td>不備関係書類（生年月日・性訂正）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_SEIKYUKNK_GENGAKU}</td><td>&quot;kk907&quot;</td><td>請求関係書類（減額）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_HUBIKNK_GENGAKU}</td><td>&quot;kk908&quot;</td><td>不備関係書類（減額）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_SEIKYUKNK_KAIYAKU}</td><td>&quot;kk909&quot;</td><td>請求関係書類（解約）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_HUBIKNK_KAIYAKU}</td><td>&quot;kk910&quot;</td><td>不備関係書類（解約）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_TODOKEDEKNK_ADRHNK}</td><td>&quot;kk911&quot;</td><td>届出関係書類（住所変更）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_HUBIKNK_ADRHNK}</td><td>&quot;kk912&quot;</td><td>不備関係書類（住所変更）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_SEIKYUKNK_STDRSKYTKYK}</td><td>&quot;kk913&quot;</td><td>請求関係書類（被保険者代理特約中途付加）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_HUBIKNK_STDRSKYTKYK}</td><td>&quot;kk914&quot;</td><td>不備関係書類（被保険者代理特約中途付加）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_SEIKYUKNK_KAIGOMAETKHNK}</td><td>&quot;kk915&quot;</td><td>請求関係書類（重度介護前払特約変更）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_HUBIKNK_KAIGOMAETKHNK}</td><td>&quot;kk916&quot;</td><td>不備関係書類（重度介護前払特約変更）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_SEIKYUKNK_MKHGKHNK}</td><td>&quot;kk917&quot;</td><td>請求関係書類（目標額変更）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_HUBIKNK_MKHGKHNK}</td><td>&quot;kk918&quot;</td><td>不備関係書類（目標額変更）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_SEIKYUKNK_YENDTHNKHNRKN}</td><td>&quot;kk919&quot;</td><td>請求関係書類（円建変更時返戻金）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_HUBIKNK_YENDTHNKHNRKN}</td><td>&quot;kk920&quot;</td><td>不備関係書類（円建変更時返戻金）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_SEIKYUKNK_TUMITATEKINITEN}</td><td>&quot;kk921&quot;</td><td>請求関係書類（積立金移転）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_HUBIKNK_TUMITATEKINITEN}</td><td>&quot;kk922&quot;</td><td>不備関係書類（積立金移転）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_SEIKYUKNK_DSHR}</td><td>&quot;kk923&quot;</td><td>請求関係書類（配当金支払）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_HUBIKNK_DSHR}</td><td>&quot;kk924&quot;</td><td>不備関係書類（配当金支払）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_SEIKYUKNK_YENDTHNK_NINI}</td><td>&quot;kk925&quot;</td><td>請求関係書類（円建変更受付（任意請求））</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_HUBIKNK_YENDTHNK_NINI}</td><td>&quot;kk926&quot;</td><td>不備関係書類（円建変更受付（任意請求））</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_HUBIKNK_KYKTORIKESI}</td><td>&quot;kk927&quot;</td><td>不備関係書類（契約取消）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_HUBIKNK_CLGOFF}</td><td>&quot;kk928&quot;</td><td>不備関係書類（クーリングオフ）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_HUBIKNK_KAIJYO}</td><td>&quot;kk929&quot;</td><td>不備関係書類（解除）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_HUBIKNK_MUKOU}</td><td>&quot;kk930&quot;</td><td>不備関係書類（無効）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_HUBIKNK_SBKAIJYO}</td><td>&quot;kk931&quot;</td><td>不備関係書類（死亡解除）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_HUBIKNK_SBMENSEKI}</td><td>&quot;kk932&quot;</td><td>不備関係書類（死亡免責）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_HUBIKNK_SBMUKOU}</td><td>&quot;kk933&quot;</td><td>不備関係書類（死亡無効（既払Ｐ支払））</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_HUBIKNK_SBMUKOUNOSHR}</td><td>&quot;kk934&quot;</td><td>不備関係書類（死亡無効（支払なし））</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_HUBIKNK_SBMENSEKINOSHR}</td><td>&quot;kk935&quot;</td><td>不備関係書類（死亡免責（支払なし））</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_SEIKYUKNK_KZKTRKKYKDRHNK}</td><td>&quot;kk936&quot;</td><td>請求関係書類（家族登録／契約者代理特約変更）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_HUBIKNK_KZKTRKKYKDRHNK}</td><td>&quot;kk937&quot;</td><td>不備関係書類（家族登録／契約者代理特約変更）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #AS_KRKKN_SEIBITOKUSOKULIST_1}</td><td>&quot;as053&quot;</td><td>仮受金整備督促リスト（個別収納サービス室）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #AS_KRKKN_SEIBITOKUSOKULIST_2}</td><td>&quot;as055&quot;</td><td>仮受金整備督促リスト（保全変更サービス室）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #AS_DATTAI_MIKAISYOULIST}</td><td>&quot;as152&quot;</td><td>脱退未解消リスト</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #AS_HRHNTTDKANNAI}</td><td>&quot;as301&quot;</td><td>払変手続案内</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #AS_PKZHRIKEIRAI}</td><td>&quot;as302&quot;</td><td>生命保険料口座振替依頼書</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #AS_PHRKKAISUUHENKOUMOS}</td><td>&quot;as303&quot;</td><td>生命保険料払込回数変更申込書</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #AS_CREDITCARDMOS}</td><td>&quot;as308&quot;</td><td>クレジットカード扱い申込書</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #AS_HRHNKANRYOTUUTI}</td><td>&quot;as304&quot;</td><td>払変完了通知（ＰＤＦ）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #AS_HRHN_HB}</td><td>&quot;as306&quot;</td><td>不備訂正書（払方変更）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #AS_HRHN_HBLIST}</td><td>&quot;as307&quot;</td><td>不備未解消リスト（払方変更）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #AS_SAIGAITOKUSINKEIYAKUHOYUULIST}</td><td>&quot;as401&quot;</td><td>災害特伸契約保有リスト</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #AS_ZENNOUTOUKEILIST}</td><td>&quot;as403&quot;</td><td>前納統計リスト</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #AS_ZENNOUMKKPKSSAMPLELIST}</td><td>&quot;as404&quot;</td><td>前納未経過Ｐ検証サンプルリスト</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #AS_PMINYUUSYOUMETUHRBKNLIST}</td><td>&quot;as407&quot;</td><td>Ｐ未入消滅時返戻金備金リスト</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #AS_SYOUMETUTUUTI}</td><td>&quot;as501&quot;</td><td>消滅通知</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #AS_SYOUMETUTUUTI_SHRSKS}</td><td>&quot;as502&quot;</td><td>消滅通知（請求書同封）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #AS_SYOUMETUKEIYAKULIST}</td><td>&quot;as503&quot;</td><td>消滅契約リスト</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #AS_JIMURENRAKU_SYUUNOU}</td><td>&quot;as901&quot;</td><td>事務連絡票（収納）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #AS_MISSLIST_SYUUNOU}</td><td>&quot;as902&quot;</td><td>ミスリスト（収納）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #AS_PMINYUUSYOUMETU_MISSLIST}</td><td>&quot;as903&quot;</td><td>Ｐ未入消滅ミスリスト</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #AS_URIAGESEIKYUUKEKKA_ERRORLIST}</td><td>&quot;as904&quot;</td><td>売上請求結果エラーリスト</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #AS_CREDITTOUROKUKENSUULIST}</td><td>&quot;as905&quot;</td><td>クレカ登録件数リスト</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #AS_YUUKOUKAKUNIN_ERRORLIST}</td><td>&quot;as906&quot;</td><td>有効確認エラーリスト</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #AS_MINUSURIAGEKYKDTLLIST}</td><td>&quot;as907&quot;</td><td>マイナス売上契約明細リスト</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #AS_MOSKNK_HRHN}</td><td>&quot;as910&quot;</td><td>申込関係書類（払方変更）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #AS_HUBIKNK_HRHN}</td><td>&quot;as911&quot;</td><td>不備関係書類（払方変更）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NK_SKS_ITJ}</td><td>&quot;nk010&quot;</td><td>年金変更請求書（年金一時金支払）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NK_SKS_SIBOU}</td><td>&quot;nk015&quot;</td><td>年金変更請求書（死亡）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NK_SKS_MGHNK}</td><td>&quot;nk020&quot;</td><td>年金変更請求書（名義住所変更）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NK_SKS_KZHNK}</td><td>&quot;nk025&quot;</td><td>年金変更請求書（自動支払口座変更）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NK_SKS_KAISUHNK}</td><td>&quot;nk030&quot;</td><td>年金変更請求書（分割支払回数変更）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NK_SKS_SAIHAKKOU}</td><td>&quot;nk035&quot;</td><td>年金変更請求書（証書再発行）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NK_SKS_TK_STDRSKTKY}</td><td>&quot;nk040&quot;</td><td>年金変更請求書（被保険者代理特約変更）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NK_SKS_TK_KKNKUKT}</td><td>&quot;nk045&quot;</td><td>年金変更請求書（後継年金受取人指定特約変更）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NK_SKS_D_UKTRHOU_HK}</td><td>&quot;nk050&quot;</td><td>年金変更請求書（配当金受取方法変更）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NK_SOUHU_ITJ}</td><td>&quot;nk110&quot;</td><td>送付案内（年金一時金支払請求書）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NK_SOUHU_SIBOU}</td><td>&quot;nk115&quot;</td><td>送付案内（死亡）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NK_SOUHU_MGHNK}</td><td>&quot;nk120&quot;</td><td>送付案内（名義住所変更請求書）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NK_SOUHU_KZHNK}</td><td>&quot;nk125&quot;</td><td>送付案内（自動支払口座変更請求書）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NK_SOUHU_KAISUHNK}</td><td>&quot;nk130&quot;</td><td>送付案内（分割支払回数変更請求書）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NK_SOUHU_SAIHAKKOU}</td><td>&quot;nk135&quot;</td><td>送付案内（証書再発行請求書）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NK_SOUHU_TK_STDRSKTKY}</td><td>&quot;nk140&quot;</td><td>送付案内（被保険者代理特約変更請求書）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NK_SOUHU_TK_KKNKUKT}</td><td>&quot;nk145&quot;</td><td>送付案内（後継年金受取人指定特約変更請求書）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NK_SOUHU_D_UKTRHOU_HK}</td><td>&quot;nk150&quot;</td><td>送付案内（配当金受取方法変更請求書）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NK_HUBI_ITJ}</td><td>&quot;nk310&quot;</td><td>不備訂正書（年金一時金支払）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NK_HUBI_SIBOU}</td><td>&quot;nk315&quot;</td><td>不備訂正書（死亡）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NK_HUBI_MGHNK}</td><td>&quot;nk320&quot;</td><td>不備訂正書（名義住所変更）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NK_HUBI_KZHNK}</td><td>&quot;nk325&quot;</td><td>不備訂正書（自動支払口座変更）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NK_HUBI_KAISUHNK}</td><td>&quot;nk330&quot;</td><td>不備訂正書（分割支払回数変更）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NK_HUBI_SAIHAKKOU}</td><td>&quot;nk335&quot;</td><td>不備訂正書（証書再発行）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NK_HUBI_TK_STDRSKTKY}</td><td>&quot;nk340&quot;</td><td>不備訂正書（被保険者代理特約変更）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NK_HUBI_TK_KKNKUKT}</td><td>&quot;nk345&quot;</td><td>不備訂正書（後継年金受取人指定特約変更）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NK_SOUHU_HUBI_ITJ}</td><td>&quot;nk410&quot;</td><td>不備訂正書の送付案内（年金一時金支払）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NK_SOUHU_HUBI_SIBOU}</td><td>&quot;nk415&quot;</td><td>不備訂正書の送付案内（死亡）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NK_SOUHU_HUBI_MGHNK}</td><td>&quot;nk420&quot;</td><td>不備訂正書の送付案内（名義住所変更）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NK_SOUHU_HUBI_KZHNK}</td><td>&quot;nk425&quot;</td><td>不備訂正書の送付案内（自動支払口座変更）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NK_SOUHU_HUBI_KAISUHNK}</td><td>&quot;nk430&quot;</td><td>不備訂正書の送付案内（分割支払回数変更）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NK_SOUHU_HUBI_SAIHAKKOU}</td><td>&quot;nk435&quot;</td><td>不備訂正書の送付案内（証書再発行）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NK_SOUHU_HUBI_TK_STDRSKTKY}</td><td>&quot;nk440&quot;</td><td>不備訂正書の送付案内（被保険者代理特約変更）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NK_SOUHU_HUBI_TK_KKNKUKT}</td><td>&quot;nk445&quot;</td><td>不備訂正書の送付案内（後継年金受取人指定特約変更）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NK_DAIHYOUSENNINTDK}</td><td>&quot;nk600&quot;</td><td>代表選任届</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NK_NKTRKM_MISSLIST}</td><td>&quot;nk700&quot;</td><td>年金情報取込ミスリスト</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NK_JDSHR_MISSLIST}</td><td>&quot;nk710&quot;</td><td>自動支払ミスリスト</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NK_KSCHK_MISSLIST}</td><td>&quot;nk720&quot;</td><td>口座情報マスタチェックミスリスト</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NK_GNSNLIST}</td><td>&quot;nk730&quot;</td><td>源泉徴収リスト</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NK_HUBIMIKAISYOULIST}</td><td>&quot;nk740&quot;</td><td>不備未解消リスト</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NK_TYOUSYOLIST_NK}</td><td>&quot;nk751&quot;</td><td>支払調書（年金）確認要リスト</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NK_TYOUSYOLIST_ITJ_NK}</td><td>&quot;nk752&quot;</td><td>支払調書（一時金）年金確認要リスト</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NK_TYOUSYOLIST_UK_NK}</td><td>&quot;nk753&quot;</td><td>支払調書（受取人別）年金確認要リスト</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SK_JIMURENRAKU}</td><td>&quot;sk031&quot;</td><td>新契約事務連絡票</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SK_HUBITUUTI}</td><td>&quot;sk032&quot;</td><td>不備通知書</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SK_KYKKAKUNINIRAISYO}</td><td>&quot;sk033&quot;</td><td>契約確認依頼書</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SK_KYKKAKUNINKAITOUSYO}</td><td>&quot;sk034&quot;</td><td>契約確認回答書</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SK_YUUKOUKKNYOKOKULIST}</td><td>&quot;sk035&quot;</td><td>有効期間経過予告リスト</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SK_YUUKOUKKNTYOUKALIST}</td><td>&quot;sk036&quot;</td><td>有効期間経過超過リスト</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SK_KYKHUSEIRITU}</td><td>&quot;sk037&quot;</td><td>契約不成立通知書</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SK_TRKSSEIKYU}</td><td>&quot;sk038&quot;</td><td>取消請求書</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SK_TTDKKR}</td><td>&quot;sk041&quot;</td><td>手続完了通知</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SK_SMBCSINTYOKUMISSLIST}</td><td>&quot;sk042&quot;</td><td>ＳＭＢＣ進捗管理ミスリスト</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SK_SENTAKINFOMISSLIST}</td><td>&quot;sk043&quot;</td><td>新契約選択情報作成ミスリスト</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SK_KEIYAKUNAIYOTOROKUSEIDOSYOKAIHYO}</td><td>&quot;sk046&quot;</td><td>契約内容登録制度照会票</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SK_HURIKOMINYKNSAKUJOMISSLIST}</td><td>&quot;sk051&quot;</td><td>振込入金削除ミスリスト</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SK_HURIKOMINYKNTEISEILIST_ENKA}</td><td>&quot;sk052&quot;</td><td>振込入金訂正データリスト（円貨）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SK_SAKUJOKYKMEISAILIST}</td><td>&quot;sk053&quot;</td><td>削除契約明細リスト</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SK_JIDOUNYKNMEISAILIST}</td><td>&quot;sk054&quot;</td><td>自動入金明細リスト</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SK_1PNYKNITTILIST}</td><td>&quot;sk055&quot;</td><td>第１回保険料一致リスト</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SK_NYKJYOUHOUHUITTIKAKSYO}</td><td>&quot;sk056&quot;</td><td>入金情報不一致確認書</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SK_MOSSOUHUJYOUKYOULIST}</td><td>&quot;sk057&quot;</td><td>申込書類送付状況リスト</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SK_MOSMITOUTYAKUKKNLIST}</td><td>&quot;sk058&quot;</td><td>申込書類未到着期間経過リスト</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SK_HURIKOMINYKNTEISEILIST_GAIKA}</td><td>&quot;sk060&quot;</td><td>振込入金訂正データリスト（外貨）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SK_SIKINIDOULIST_HRKMKZHUITTI}</td><td>&quot;sk061&quot;</td><td>資金移動リスト（振込口座不一致分）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SK_HURIKOMINYKNTEISEILIST_ENKA_YENDT}</td><td>&quot;sk062&quot;</td><td>振込入金訂正データリスト（円貨）（円建）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SK_SAKUJOKYKMEISAILIST_YENDT}</td><td>&quot;sk063&quot;</td><td>削除契約明細リスト（円建）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SK_JIDOUNYKNMEISAILIST_YENDT}</td><td>&quot;sk064&quot;</td><td>自動入金明細リスト（円建）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SK_1PNYKNITTILIST_YENDT}</td><td>&quot;sk065&quot;</td><td>第１回保険料一致リスト（円建）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SK_NYKJYOUHOUHUITTIKAKSYO_YENDT}</td><td>&quot;sk066&quot;</td><td>入金情報不一致確認書（円建）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SK_MOSMITOUTYAKUKKNLIST_YENDT}</td><td>&quot;sk067&quot;</td><td>申込書類未到着期間経過リスト（円建）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SK_HENKINIRAISYO}</td><td>&quot;sk071&quot;</td><td>返金依頼書</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SK_HENKINTUUTILIST}</td><td>&quot;sk072&quot;</td><td>返金通知</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SK_HANDKARIKANJYOU}</td><td>&quot;sk073&quot;</td><td>新契約ハンド仮勘定票</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SK_HENKINMISYORILIST}</td><td>&quot;sk074&quot;</td><td>返金未処理リスト</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SK_HANDKARIKANJYOU_YENDT}</td><td>&quot;sk077&quot;</td><td>新契約ハンド仮勘定票（円建）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SK_HENKINMISYORILIST_YENDT}</td><td>&quot;sk078&quot;</td><td>返金未処理リスト（円建）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SK_CREDITQRTOUROKUMIHANEILIST}</td><td>&quot;sk101&quot;</td><td>クレカＱＲ登録未反映リスト（申込入力未了分）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SK_CREDITCARDKAIINTOUROKUNGLIST}</td><td>&quot;sk102&quot;</td><td>クレジットカード会員登録ＮＧリスト</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SK_CREDITCARDTOUROKUHANEIERRORLIST}</td><td>&quot;sk103&quot;</td><td>クレジットカード登録反映エラーリスト</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SK_YUUKOUHANEIKAKUNINKEKKALIST}</td><td>&quot;sk104&quot;</td><td>新契約有効性反映確認結果リスト</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SK_FSTPURIAGESEIKYUUERRORLIST}</td><td>&quot;sk105&quot;</td><td>初回保険料売上請求エラーリスト</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SK_FSTPURIAGESEIKYUUMEISAI_JCB}</td><td>&quot;sk106&quot;</td><td>初回保険料クレジットカード扱売上請求明細票（ＪＣＢ）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SK_FSTPURIAGESEIKYUUMEISAI_VISA}</td><td>&quot;sk107&quot;</td><td>初回保険料クレジットカード扱売上請求明細票（ＶＩＳＡ）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SK_KOUFURITOUROKUMIHANEILIST}</td><td>&quot;sk108&quot;</td><td>口座振替登録未反映リスト（申込入力未了分）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SK_KOUFURITOUROKUHANEIERRORLIST}</td><td>&quot;sk109&quot;</td><td>口座振替登録反映エラーリスト</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SK_KARIUKEHUHOPKAKIN1MKEIKA}</td><td>&quot;sk081&quot;</td><td>仮受普保Ｐ過金１ヵ月超経過</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SK_GETUMATUZANDAKACHKLIST}</td><td>&quot;sk082&quot;</td><td>月末残高チェックリスト</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SK_MSRKARIUKEKINMEISAI}</td><td>&quot;sk083&quot;</td><td>未整理仮受金明細</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SK_MSRJIYUUMEISAI_NYKNHUBI}</td><td>&quot;sk084&quot;</td><td>未整理事由明細（入金内容不備）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SK_MSRJIYUUMEISAI_SYORUIHUBI_TAN}</td><td>&quot;sk085&quot;</td><td>未整理事由明細（書類不備）単独</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SK_MSRJIYUUMEISAI_SYORUIHUBI_HUKU}</td><td>&quot;sk086&quot;</td><td>未整理事由明細（書類不備）複数</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SK_MSRJIYUUMEISAI_SEIRITUHRYUUUKTKTYUU}</td><td>&quot;sk087&quot;</td><td>未整理事由明細（成立保留受付中）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SK_MSRJIYUUBETUKARIUKEKINSYUUKEI}</td><td>&quot;sk088&quot;</td><td>未整理事由別仮受金集計表</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SK_MSRJIYUUBETUKARIUKEKINMEISAILIST}</td><td>&quot;sk089&quot;</td><td>未整理事由別仮受金明細リスト</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SK_JIDSYUUNOUSYOUGOUMEISAI_KESSAN}</td><td>&quot;sk090&quot;</td><td>自動収納照合一致・不一致明細書（決算用）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SK_KARIUKEKINPKAKINMEISAI}</td><td>&quot;sk091&quot;</td><td>仮受金（Ｐ過金）明細</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SK_KARIUKEKINPKAKINZANDAKAMEISAILIST}</td><td>&quot;sk092&quot;</td><td>仮受金（Ｐ過金）残高明細リスト</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SK_HUKUSUUKAINYUUKINKAWASESASONEKI}</td><td>&quot;sk093&quot;</td><td>複数回入金為替差損益リスト</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SK_KARIUKEHUHOPKAKIN1MKEIKA_YENDT}</td><td>&quot;sk121&quot;</td><td>仮受普保Ｐ過金１ヵ月超経過（円建）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SK_GETUMATUZANDAKACHKLIST_YENDT}</td><td>&quot;sk122&quot;</td><td>月末残高チェックリスト（円建）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SK_MSRKARIUKEKINMEISAI_YENDT}</td><td>&quot;sk123&quot;</td><td>未整理仮受金明細（円建）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SK_MSRJIYUUMEISAI_NYKNHUBI_YENDT}</td><td>&quot;sk124&quot;</td><td>未整理事由明細（入金内容不備）（円建）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SK_MSRJIYUUMEISAI_SYORUIHUBI_TAN_YENDT}</td><td>&quot;sk125&quot;</td><td>未整理事由明細（書類不備）単独（円建）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SK_MSRJIYUUMEISAI_SYORUIHUBI_HUKU_YENDT}</td><td>&quot;sk126&quot;</td><td>未整理事由明細（書類不備）複数（円建）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SK_MSRJIYUUMEISAI_SEIRITUHRYUUUKTKTYUU_YENDT}</td><td>&quot;sk127&quot;</td><td>未整理事由明細（成立保留受付中）（円建）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SK_MSRJIYUUBETUKARIUKEKINSYUUKEI_YENDT}</td><td>&quot;sk128&quot;</td><td>未整理事由別仮受金集計表（円建）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SK_MSRJIYUUBETUKARIUKEKINMEISAILIST_YENDT}</td><td>&quot;sk129&quot;</td><td>未整理事由別仮受金明細リスト（円建）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SK_JIDSYUUNOUSYOUGOUMEISAI_KESSAN_YENDT}</td><td>&quot;sk130&quot;</td><td>自動収納照合一致・不一致明細書（決算用）（円建）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SK_KARIUKEKINPKAKINMEISAI_YENDT}</td><td>&quot;sk131&quot;</td><td>仮受金（Ｐ過金）明細（円建）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SK_KARIUKEKINPKAKINZANDAKAMEISAILIST_YENDT}</td><td>&quot;sk132&quot;</td><td>仮受金（Ｐ過金）残高明細リスト（円建）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SR_OIKOMISYUUKEIHYOUTYOUSEI}</td><td>&quot;sr001&quot;</td><td>追込契約集計表（調整伝票）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SR_OIKOMISYUUKEIPDENPYOU}</td><td>&quot;sr002&quot;</td><td>追込契約集計表（保険料伝票リスト）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SR_TMTTDMEISAILIST}</td><td>&quot;sr100&quot;</td><td>積立配当金明細表</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SR_KBNKEIRIYOUTMTTDMEISAILIST}</td><td>&quot;sr101&quot;</td><td>区分経理用積立配当金明細表</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SR_KARIWARIATEDMEISAILIS}</td><td>&quot;sr102&quot;</td><td>仮割当配当金明細表</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SR_BIKINKYKSEISANDLIST}</td><td>&quot;sr103&quot;</td><td>備金契約精算Ｄ集計表</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SR_KBNKEIRIYOUBIKINKYKSEISANDLIST}</td><td>&quot;sr104&quot;</td><td>区分経理用備金契約精算Ｄ集計表</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SR_BIKINKYKKARIWARIATEDLIST}</td><td>&quot;sr105&quot;</td><td>備金契約仮割当Ｄ集計表</td></tr>
 *  <tr><td rowspan="9">{@link #PATTERN_KESSANYOUHUBISYORUIHYJ KESSANYOUHUBISYORUIHYJ}<br />(決算用不備書類表示)</td><td align="center">&nbsp;</td><td>{@link #SK_MOSSYO}</td><td>&quot;sk001&quot;</td><td>01</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SK_KOKUSYO}</td><td>&quot;sk003&quot;</td><td>48</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SK_IKOUKAKSYO}</td><td>&quot;sk005&quot;</td><td>14</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SK_UKTHUKUSUUSITEI}</td><td>&quot;sk007&quot;</td><td>34</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SK_UKTJIZENSYOUKAI}</td><td>&quot;sk008&quot;</td><td>36</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SK_DAISANSYAUKTHOUSYO}</td><td>&quot;sk009&quot;</td><td>35</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SK_TORIHOUSYO}</td><td>&quot;sk011&quot;</td><td>23</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SK_SEIMEIPKZHURIKAEMOSSYO}</td><td>&quot;sk016&quot;</td><td>52</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SK_SONOTAHUZOKU}</td><td>&quot;sk013&quot;</td><td>91</td></tr>
 *  <tr><td rowspan="9">{@link #PATTERN_SKHUBITOUROKU SKHUBITOUROKU}<br />(新契約不備登録)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SK_MOSSYO}</td><td>&quot;sk001&quot;</td><td>01：申込書</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SK_IKOUKAKSYO}</td><td>&quot;sk005&quot;</td><td>14：意向確認書</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SK_UKTHUKUSUUSITEI}</td><td>&quot;sk007&quot;</td><td>34：受取人複数指定書</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SK_UKTJIZENSYOUKAI}</td><td>&quot;sk008&quot;</td><td>36：受取人事前照会票</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SK_DAISANSYAUKTHOUSYO}</td><td>&quot;sk009&quot;</td><td>35：第三者受取報告書</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SK_TORIHOUSYO}</td><td>&quot;sk011&quot;</td><td>23：取扱報告書</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SK_SEIMEIPKZHURIKAEMOSSYO}</td><td>&quot;sk016&quot;</td><td>52：生命保険料支払申込書</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SK_SONOTAHUZOKU}</td><td>&quot;sk013&quot;</td><td>91：その他付属資料</td></tr>
 * </table>
 */
public class C_SyoruiCdKbn extends Classification<C_SyoruiCdKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_SyoruiCdKbn BLNK = new C_SyoruiCdKbn("0");

    public static final C_SyoruiCdKbn WF_HYOUSI = new C_SyoruiCdKbn("wf001");

    public static final C_SyoruiCdKbn WF_QRSEAL = new C_SyoruiCdKbn("wf002");

    public static final C_SyoruiCdKbn USERITIRANHYOU = new C_SyoruiCdKbn("Ba001");

    public static final C_SyoruiCdKbn CM_JIMURENRAKUHYOU = new C_SyoruiCdKbn("cm001");

    public static final C_SyoruiCdKbn CM_LINC_MISSLIST = new C_SyoruiCdKbn("cm002");

    public static final C_SyoruiCdKbn CM_ONLINE_FBFURIKOMIKEI_1 = new C_SyoruiCdKbn("cm003");

    public static final C_SyoruiCdKbn CM_ONLINE_FBFURIKOMIKEI_2 = new C_SyoruiCdKbn("cm004");

    public static final C_SyoruiCdKbn CM_ONLINE_GKFBFURIKOMIKEI_1 = new C_SyoruiCdKbn("cm005");

    public static final C_SyoruiCdKbn CM_ONLINE_GKFBFURIKOMIKEI_2 = new C_SyoruiCdKbn("cm006");

    public static final C_SyoruiCdKbn CM_ONLINE_FBSOUKINMEISAI_1 = new C_SyoruiCdKbn("cm007");

    public static final C_SyoruiCdKbn CM_ONLINE_FBSOUKINMEISAI_2 = new C_SyoruiCdKbn("cm008");

    public static final C_SyoruiCdKbn CM_ONLINE_FBSOUKINMEISAI_3 = new C_SyoruiCdKbn("cm009");

    public static final C_SyoruiCdKbn CM_ONLINE_FBSOUKINMEISAI_4 = new C_SyoruiCdKbn("cm010");

    public static final C_SyoruiCdKbn CM_ONLINE_FBSOUKINMEISAI_5 = new C_SyoruiCdKbn("cm011");

    public static final C_SyoruiCdKbn CM_ONLINE_GKFBSOUKINMEISAI_1 = new C_SyoruiCdKbn("cm012");

    public static final C_SyoruiCdKbn CM_ONLINE_GKFBSOUKINMEISAI_2 = new C_SyoruiCdKbn("cm013");

    public static final C_SyoruiCdKbn CM_ONLINE_GKFBSOUKINMEISAI_3 = new C_SyoruiCdKbn("cm014");

    public static final C_SyoruiCdKbn CM_ONLINE_GKFBSOUKINMEISAI_4 = new C_SyoruiCdKbn("cm015");

    public static final C_SyoruiCdKbn CM_ONLINE_GKFBSOUKINMEISAI_5 = new C_SyoruiCdKbn("cm016");

    public static final C_SyoruiCdKbn CM_BATCH_FBFURIKOMIKEI_4 = new C_SyoruiCdKbn("cm017");

    public static final C_SyoruiCdKbn CM_BATCH_GKFBFURIKOMIKEI = new C_SyoruiCdKbn("cm018");

    public static final C_SyoruiCdKbn CM_BATCH_FBSOUKINMEISAI_4 = new C_SyoruiCdKbn("cm019");

    public static final C_SyoruiCdKbn CM_BATCH_GKFBSOUKINMEISAI = new C_SyoruiCdKbn("cm020");

    public static final C_SyoruiCdKbn CM_TIENRSKUTIWAKELIST = new C_SyoruiCdKbn("cm021");

    public static final C_SyoruiCdKbn CM_SKHONSYADENPYOULIST = new C_SyoruiCdKbn("cm022");

    public static final C_SyoruiCdKbn CM_KARIUKEMEISAI_1 = new C_SyoruiCdKbn("cm023");

    public static final C_SyoruiCdKbn CM_KARIUKEMEISAI_2 = new C_SyoruiCdKbn("cm024");

    public static final C_SyoruiCdKbn CM_KARIUKEMEISAI_3 = new C_SyoruiCdKbn("cm025");

    public static final C_SyoruiCdKbn CM_KARIUKEMEISAI_4 = new C_SyoruiCdKbn("cm026");

    public static final C_SyoruiCdKbn CM_SIKINIDOULIST_SOKUJI = new C_SyoruiCdKbn("cm027");

    public static final C_SyoruiCdKbn CM_SIKINIDOULIST_TYAKKINBI = new C_SyoruiCdKbn("cm028");

    public static final C_SyoruiCdKbn CM_HURIKOMIERRINFOLIST = new C_SyoruiCdKbn("cm029");

    public static final C_SyoruiCdKbn CM_GKHURIKOMIERRINFOLIST = new C_SyoruiCdKbn("cm030");

    public static final C_SyoruiCdKbn CM_HOJYOBOLIST_1 = new C_SyoruiCdKbn("cm031");

    public static final C_SyoruiCdKbn CM_HOJYOBOLIST_2 = new C_SyoruiCdKbn("cm032");

    public static final C_SyoruiCdKbn CM_HOJYOBOLIST_3 = new C_SyoruiCdKbn("cm033");

    public static final C_SyoruiCdKbn CM_HOJYOBOLIST_4 = new C_SyoruiCdKbn("cm034");

    public static final C_SyoruiCdKbn CM_HOJYOBOLIST_5 = new C_SyoruiCdKbn("cm035");

    public static final C_SyoruiCdKbn CM_HURIDEN = new C_SyoruiCdKbn("cm036");

    public static final C_SyoruiCdKbn CM_HURIDEN_HIKAE = new C_SyoruiCdKbn("cm037");

    public static final C_SyoruiCdKbn CM_SK_HURIDEN = new C_SyoruiCdKbn("cm038");

    public static final C_SyoruiCdKbn CM_SK_HURIDEN_HIKAE = new C_SyoruiCdKbn("cm039");

    public static final C_SyoruiCdKbn CM_RATEDBSYOUKAIKEKKA = new C_SyoruiCdKbn("cm040");

    public static final C_SyoruiCdKbn BZ_JIGYOUHIKANJYOUKAKUSYOULIST_1 = new C_SyoruiCdKbn("cm041");

    public static final C_SyoruiCdKbn BZ_JIGYOUHIKANJYOUKAKUSYOULIST_2 = new C_SyoruiCdKbn("cm042");

    public static final C_SyoruiCdKbn CM_TUUSANKAWASERATEKAKUNIN = new C_SyoruiCdKbn("cm043");

    public static final C_SyoruiCdKbn CM_HOJYOBOLIST_6 = new C_SyoruiCdKbn("cm044");

    public static final C_SyoruiCdKbn CM_KARIUKEMEISAI_5 = new C_SyoruiCdKbn("cm045");

    public static final C_SyoruiCdKbn CM_ONLINE_FBSOUKINMEISAI_6 = new C_SyoruiCdKbn("cm046");

    public static final C_SyoruiCdKbn CM_SIKINIDOULIST_YENDTHNK = new C_SyoruiCdKbn("cm047");

    public static final C_SyoruiCdKbn CM_BATCH_FBSOUKINMEISAI_7 = new C_SyoruiCdKbn("cm048");

    public static final C_SyoruiCdKbn CM_ONLINE_FBSOUKINMEISAI_7 = new C_SyoruiCdKbn("cm049");

    public static final C_SyoruiCdKbn CM_MYNUMBERTYUUSYUTULIST = new C_SyoruiCdKbn("cm050");

    public static final C_SyoruiCdKbn CM_HOJYOBOLIST_7 = new C_SyoruiCdKbn("cm051");

    public static final C_SyoruiCdKbn CM_KBTKARIKANJYOUZNDKSYUKILIST = new C_SyoruiCdKbn("cm052");

    public static final C_SyoruiCdKbn CM_SIKINIDOULIST_HIJYNNYK = new C_SyoruiCdKbn("cm053");

    public static final C_SyoruiCdKbn CM_BATCH_FBFURIKOMIKEI_2 = new C_SyoruiCdKbn("cm054");

    public static final C_SyoruiCdKbn CM_BATCH_FBSOUKINMEISAI_2 = new C_SyoruiCdKbn("cm055");

    public static final C_SyoruiCdKbn CM_SIKINIDOULIST_HTKIN = new C_SyoruiCdKbn("cm056");

    public static final C_SyoruiCdKbn CM_KARIUKEMEISAI_6 = new C_SyoruiCdKbn("cm057");

    public static final C_SyoruiCdKbn CM_BATCH_FBFURIKOMIKEI_3 = new C_SyoruiCdKbn("cm058");

    public static final C_SyoruiCdKbn CM_BATCH_FBSOUKINMEISAI_3 = new C_SyoruiCdKbn("cm059");

    public static final C_SyoruiCdKbn CM_HOJYOBOLIST = new C_SyoruiCdKbn("cm099");

    public static final C_SyoruiCdKbn DS_KARIPWTUUTITYUUDANLIST = new C_SyoruiCdKbn("ds001");

    public static final C_SyoruiCdKbn DS_KOUZOKUJIMUKAKUNINLIST = new C_SyoruiCdKbn("ds011");

    public static final C_SyoruiCdKbn HK_SHRMESS = new C_SyoruiCdKbn("hk001");

    public static final C_SyoruiCdKbn HK_SHMEISAI_SDS = new C_SyoruiCdKbn("hk003");

    public static final C_SyoruiCdKbn HK_SB_HOKEN_SKS = new C_SyoruiCdKbn("hk011");

    public static final C_SyoruiCdKbn HK_SEISANKINHRKM_IRAIS = new C_SyoruiCdKbn("hk015");

    public static final C_SyoruiCdKbn HK_SB_DAIHYOU = new C_SyoruiCdKbn("hk031");

    public static final C_SyoruiCdKbn HK_KD_JIKOJKS = new C_SyoruiCdKbn("hk041");

    public static final C_SyoruiCdKbn HK_JIJYOUTODOKEKENSEIYAKUSYO = new C_SyoruiCdKbn("hk051");

    public static final C_SyoruiCdKbn HK_TEISYUTUSYORUI = new C_SyoruiCdKbn("hk061");

    public static final C_SyoruiCdKbn HK_MYNUMBER_CHYOU = new C_SyoruiCdKbn("hk082");

    public static final C_SyoruiCdKbn HK_SOUHU = new C_SyoruiCdKbn("hk090");

    public static final C_SyoruiCdKbn HK_STI_KAS = new C_SyoruiCdKbn("hk101");

    public static final C_SyoruiCdKbn HK_SB_SONOTA_SDS = new C_SyoruiCdKbn("hk102");

    public static final C_SyoruiCdKbn HK_SB_KTJKSMS = new C_SyoruiCdKbn("hk104");

    public static final C_SyoruiCdKbn HK_SB_HKNSYKN = new C_SyoruiCdKbn("hk106");

    public static final C_SyoruiCdKbn HK_SB_KOSEKI = new C_SyoruiCdKbn("hk108");

    public static final C_SyoruiCdKbn HK_SB_HONNINSR = new C_SyoruiCdKbn("hk110");

    public static final C_SyoruiCdKbn HK_SB_JYUUMIN = new C_SyoruiCdKbn("hk112");

    public static final C_SyoruiCdKbn HK_SB_INKAN = new C_SyoruiCdKbn("hk114");

    public static final C_SyoruiCdKbn HK_SB_KAKUNINDOUISYO = new C_SyoruiCdKbn("hk116");

    public static final C_SyoruiCdKbn HK_SB_SKKANSYOUKNK = new C_SyoruiCdKbn("hk117");

    public static final C_SyoruiCdKbn HK_MYNUMBER_SYORUI = new C_SyoruiCdKbn("hk118");

    public static final C_SyoruiCdKbn HK_SB_SONOTA_SKS = new C_SyoruiCdKbn("hk131");

    public static final C_SyoruiCdKbn HK_ENKASIHARAIRYUUIJIKOU = new C_SyoruiCdKbn("hk201");

    public static final C_SyoruiCdKbn HK_SB_HUBITEISEI = new C_SyoruiCdKbn("hk301");

    public static final C_SyoruiCdKbn HK_SB_HUBITEISEI2 = new C_SyoruiCdKbn("hk303");

    public static final C_SyoruiCdKbn HK_HUBITEISEI_SOUHU = new C_SyoruiCdKbn("hk311");

    public static final C_SyoruiCdKbn HK_SB_HUBIKNK = new C_SyoruiCdKbn("hk321");

    public static final C_SyoruiCdKbn HK_SB_KAKUNINIRAIS = new C_SyoruiCdKbn("hk401");

    public static final C_SyoruiCdKbn HK_SB_KAKUNINHKS = new C_SyoruiCdKbn("hk411");

    public static final C_SyoruiCdKbn HK_BIKINSAGYOULIST = new C_SyoruiCdKbn("hk501");

    public static final C_SyoruiCdKbn HK_BIKINJIKOUKIST = new C_SyoruiCdKbn("hk502");

    public static final C_SyoruiCdKbn HK_BIKINJIKOUKIST_GOUKEI = new C_SyoruiCdKbn("hk503");

    public static final C_SyoruiCdKbn HK_ZENNOUSEISANKINMEISAILIST = new C_SyoruiCdKbn("hk504");

    public static final C_SyoruiCdKbn HK_JIKOUDENMEISAILIST = new C_SyoruiCdKbn("hk505");

    public static final C_SyoruiCdKbn HK_SB_SONOTA = new C_SyoruiCdKbn("hk902");

    public static final C_SyoruiCdKbn KK_ADRHNK_TTDKKR = new C_SyoruiCdKbn("kk001");

    public static final C_SyoruiCdKbn KK_ADRHNK_GAIBU_TTDKKR = new C_SyoruiCdKbn("kk002");

    public static final C_SyoruiCdKbn KK_MEIGIHNK_TTDKKR = new C_SyoruiCdKbn("kk003");

    public static final C_SyoruiCdKbn KK_STDRHNK_TTDKKR = new C_SyoruiCdKbn("kk004");

    public static final C_SyoruiCdKbn KK_SEINENGAPPISEI_TTDKKR = new C_SyoruiCdKbn("kk005");

    public static final C_SyoruiCdKbn KK_GENGAKU_TTDKKR = new C_SyoruiCdKbn("kk006");

    public static final C_SyoruiCdKbn KK_NKTKYKHNK_TTDKKR = new C_SyoruiCdKbn("kk007");

    public static final C_SyoruiCdKbn KK_TARGETHNK_TTDKKR = new C_SyoruiCdKbn("kk008");

    public static final C_SyoruiCdKbn KK_TARGETHNK_GAIBU_TTDKKR = new C_SyoruiCdKbn("kk009");

    public static final C_SyoruiCdKbn KK_KAIYAKU_TTDKKR = new C_SyoruiCdKbn("kk010");

    public static final C_SyoruiCdKbn KK_KAIYAKU_GAIBU_TTDKKR = new C_SyoruiCdKbn("kk011");

    public static final C_SyoruiCdKbn KK_KAIYAKU_SAIKENSYA_TTDKKR = new C_SyoruiCdKbn("kk012");

    public static final C_SyoruiCdKbn KK_SHRKZHNK_TTDKKR = new C_SyoruiCdKbn("kk013");

    public static final C_SyoruiCdKbn KK_SYOSAIHK_TTDKKR = new C_SyoruiCdKbn("kk014");

    public static final C_SyoruiCdKbn KK_KYKTRKS_KYKTRKSTTDKKR = new C_SyoruiCdKbn("kk015");

    public static final C_SyoruiCdKbn KK_CLGOFF_KYKTRKSTTDKKR = new C_SyoruiCdKbn("kk016");

    public static final C_SyoruiCdKbn KK_KAIJYO_KYKTRKSTTDKKR = new C_SyoruiCdKbn("kk017");

    public static final C_SyoruiCdKbn KK_SBKAIJYO_KYKTRKSTTDKKR = new C_SyoruiCdKbn("kk018");

    public static final C_SyoruiCdKbn KK_SBMENSEKI_KYKTRKSTTDKKR = new C_SyoruiCdKbn("kk019");

    public static final C_SyoruiCdKbn KK_KAIGOMAETKHNK_TTDKKR = new C_SyoruiCdKbn("kk020");

    public static final C_SyoruiCdKbn KK_SBMUKOU_KYKTRKSTTDKKR = new C_SyoruiCdKbn("kk021");

    public static final C_SyoruiCdKbn KK_MOUSIDEMUKOU_KYKTRKSTTDKKR = new C_SyoruiCdKbn("kk022");

    public static final C_SyoruiCdKbn KK_HRIHEN_TTDKKR = new C_SyoruiCdKbn("kk023");

    public static final C_SyoruiCdKbn KK_HUKKATU_TTDKKR = new C_SyoruiCdKbn("kk024");

    public static final C_SyoruiCdKbn KK_HUKKATU_OKOTOWARI = new C_SyoruiCdKbn("kk025");

    public static final C_SyoruiCdKbn KK_MKHGKHNK_TTDKKR = new C_SyoruiCdKbn("kk026");

    public static final C_SyoruiCdKbn KK_YENDTHNKHNRKN_TTDKKR = new C_SyoruiCdKbn("kk027");

    public static final C_SyoruiCdKbn KK_TUMITATEKINITEN_TTDKKR = new C_SyoruiCdKbn("kk028");

    public static final C_SyoruiCdKbn KK_YENDTHNK_HNRKNSKS_TTDKKR = new C_SyoruiCdKbn("kk029");

    public static final C_SyoruiCdKbn KK_YENDTHNK_TTDKKR = new C_SyoruiCdKbn("kk030");

    public static final C_SyoruiCdKbn KK_DSHR_TTDKKR = new C_SyoruiCdKbn("kk031");

    public static final C_SyoruiCdKbn KK_GENGAKU_ZEITEKI_TTDKKR = new C_SyoruiCdKbn("kk032");

    public static final C_SyoruiCdKbn KK_YENDTHNK_NINI_TTDKKR = new C_SyoruiCdKbn("kk033");

    public static final C_SyoruiCdKbn KK_SYOUMETU_GAIBU_TTDKKR = new C_SyoruiCdKbn("kk034");

    public static final C_SyoruiCdKbn KK_YENDTHNK_TTDKKR_2 = new C_SyoruiCdKbn("kk035");

    public static final C_SyoruiCdKbn KK_DTUIBARAI_TTDKKR = new C_SyoruiCdKbn("kk036");

    public static final C_SyoruiCdKbn KK_DTUIBARAI_TTDKKR_ZEIMUNASI = new C_SyoruiCdKbn("kk037");

    public static final C_SyoruiCdKbn KK_KZKTRKKYKDRHNK_TTDKKR = new C_SyoruiCdKbn("kk038");

    public static final C_SyoruiCdKbn KK_KZKTRKTYOKUSOU_TTDKKR = new C_SyoruiCdKbn("kk039");

    public static final C_SyoruiCdKbn KK_KZKTRKSKEI_TTDKKR = new C_SyoruiCdKbn("kk040");

    public static final C_SyoruiCdKbn KK_YENDTHNK_NINI_TTDKKR_2 = new C_SyoruiCdKbn("kk041");

    public static final C_SyoruiCdKbn KK_YENDTHNK_TTDKKR_3 = new C_SyoruiCdKbn("kk042");

    public static final C_SyoruiCdKbn KK_SEINENGAPPISEI_TTDKKR_SHRARI = new C_SyoruiCdKbn("kk043");

    public static final C_SyoruiCdKbn KK_ADRHNK_SKS = new C_SyoruiCdKbn("kk051");

    public static final C_SyoruiCdKbn KK_MEIGIHNK_SKS = new C_SyoruiCdKbn("kk052");

    public static final C_SyoruiCdKbn KK_STDRHNK_SKS = new C_SyoruiCdKbn("kk053");

    public static final C_SyoruiCdKbn KK_SEINENGAPPISEI_SKS = new C_SyoruiCdKbn("kk054");

    public static final C_SyoruiCdKbn KK_GENGAKU_SKS = new C_SyoruiCdKbn("kk055");

    public static final C_SyoruiCdKbn KK_NKTKYKHNK_SKS = new C_SyoruiCdKbn("kk056");

    public static final C_SyoruiCdKbn KK_TARGETHNK_SKS = new C_SyoruiCdKbn("kk057");

    public static final C_SyoruiCdKbn KK_KAIYAKU_SKS = new C_SyoruiCdKbn("kk058");

    public static final C_SyoruiCdKbn KK_SHRKZHNK_SKS = new C_SyoruiCdKbn("kk059");

    public static final C_SyoruiCdKbn KK_SYOSAIHK_SKS = new C_SyoruiCdKbn("kk060");

    public static final C_SyoruiCdKbn KK_KAIGOMAETKHNK_SKS = new C_SyoruiCdKbn("kk061");

    public static final C_SyoruiCdKbn KK_KAIJYO_SKS = new C_SyoruiCdKbn("kk062");

    public static final C_SyoruiCdKbn KK_SBKAIJYO_SKS = new C_SyoruiCdKbn("kk063");

    public static final C_SyoruiCdKbn KK_SBMENSEKI_SKS = new C_SyoruiCdKbn("kk064");

    public static final C_SyoruiCdKbn KK_HRIHEN_SKS = new C_SyoruiCdKbn("kk065");

    public static final C_SyoruiCdKbn KK_HRIKAIHEN_SKS = new C_SyoruiCdKbn("kk066");

    public static final C_SyoruiCdKbn KK_HUKKATU_SKS = new C_SyoruiCdKbn("kk067");

    public static final C_SyoruiCdKbn KK_MOUSIDEMUKOU_SKS = new C_SyoruiCdKbn("kk068");

    public static final C_SyoruiCdKbn KK_GANMUKOU_SKS = new C_SyoruiCdKbn("kk069");

    public static final C_SyoruiCdKbn KK_MKHGKHNK_SKS = new C_SyoruiCdKbn("kk070");

    public static final C_SyoruiCdKbn KK_YENDTHNKHNRKN_SKS = new C_SyoruiCdKbn("kk071");

    public static final C_SyoruiCdKbn KK_TUMITATEKINITEN_SKS = new C_SyoruiCdKbn("kk072");

    public static final C_SyoruiCdKbn KK_DSHR_SKS = new C_SyoruiCdKbn("kk073");

    public static final C_SyoruiCdKbn KK_YENDTHNK_SKS = new C_SyoruiCdKbn("kk074");

    public static final C_SyoruiCdKbn KK_KZKTRKKYKDRTKYKHNK_SKS = new C_SyoruiCdKbn("kk075");

    public static final C_SyoruiCdKbn KK_ADRHNK_SOUHU = new C_SyoruiCdKbn("kk101");

    public static final C_SyoruiCdKbn KK_MEIGIHNK_SOUHU = new C_SyoruiCdKbn("kk102");

    public static final C_SyoruiCdKbn KK_STDRHNK_SOUHU = new C_SyoruiCdKbn("kk103");

    public static final C_SyoruiCdKbn KK_SEINENGAPPISEI_SOUHU = new C_SyoruiCdKbn("kk104");

    public static final C_SyoruiCdKbn KK_GENGAKU_SOUHU = new C_SyoruiCdKbn("kk105");

    public static final C_SyoruiCdKbn KK_NKTKYKHNK_SOUHU = new C_SyoruiCdKbn("kk106");

    public static final C_SyoruiCdKbn KK_TARGETHNK_SOUHU = new C_SyoruiCdKbn("kk107");

    public static final C_SyoruiCdKbn KK_KAIYAKU_SKSSOUHU = new C_SyoruiCdKbn("kk108");

    public static final C_SyoruiCdKbn KK_SHRKZHNK_SOUHU = new C_SyoruiCdKbn("kk109");

    public static final C_SyoruiCdKbn KK_SYOSAIHK_SOUHU = new C_SyoruiCdKbn("kk110");

    public static final C_SyoruiCdKbn KK_KAIGOMAETKHNK_SOUHU = new C_SyoruiCdKbn("kk111");

    public static final C_SyoruiCdKbn KK_SBMENSEKI_SOUHU = new C_SyoruiCdKbn("kk112");

    public static final C_SyoruiCdKbn KK_HRIHEN_SOUHU = new C_SyoruiCdKbn("kk113");

    public static final C_SyoruiCdKbn KK_HUKKATU_SOUHU = new C_SyoruiCdKbn("kk114");

    public static final C_SyoruiCdKbn KK_MOUSIDEMUKOU_SOUHU = new C_SyoruiCdKbn("kk115");

    public static final C_SyoruiCdKbn KK_GANMUKOU_SOUHU = new C_SyoruiCdKbn("kk116");

    public static final C_SyoruiCdKbn KK_MKHGKHNK_SOUHU = new C_SyoruiCdKbn("kk117");

    public static final C_SyoruiCdKbn KK_YENDTHNKHNRKN_SOUHU = new C_SyoruiCdKbn("kk118");

    public static final C_SyoruiCdKbn KK_TUMITATEKINITEN_SOUHU = new C_SyoruiCdKbn("kk119");

    public static final C_SyoruiCdKbn KK_DSHR_SOUHU = new C_SyoruiCdKbn("kk120");

    public static final C_SyoruiCdKbn KK_YENDTHNK_SOUHU = new C_SyoruiCdKbn("kk121");

    public static final C_SyoruiCdKbn KK_KZKTRKKYKDRTKYKHNK_SOUHU = new C_SyoruiCdKbn("kk122");

    public static final C_SyoruiCdKbn KK_HUBITEISEISYO_SOUHU = new C_SyoruiCdKbn("kk150");

    public static final C_SyoruiCdKbn KK_ADRHNK_HB = new C_SyoruiCdKbn("kk151");

    public static final C_SyoruiCdKbn KK_MEIGIHNK_HB = new C_SyoruiCdKbn("kk152");

    public static final C_SyoruiCdKbn KK_STDRHNK_HB = new C_SyoruiCdKbn("kk153");

    public static final C_SyoruiCdKbn KK_SEINENGAPPISEI_HB = new C_SyoruiCdKbn("kk154");

    public static final C_SyoruiCdKbn KK_GENGAKU_HB = new C_SyoruiCdKbn("kk155");

    public static final C_SyoruiCdKbn KK_NKTKYKHNK_HB = new C_SyoruiCdKbn("kk156");

    public static final C_SyoruiCdKbn KK_TARGETHNK_HB = new C_SyoruiCdKbn("kk157");

    public static final C_SyoruiCdKbn KK_KAIYAKU_HB = new C_SyoruiCdKbn("kk158");

    public static final C_SyoruiCdKbn KK_SHRKZHNK_HB = new C_SyoruiCdKbn("kk159");

    public static final C_SyoruiCdKbn KK_SYOSAIHK_HB = new C_SyoruiCdKbn("kk160");

    public static final C_SyoruiCdKbn KK_KYKTORIKESI_HB = new C_SyoruiCdKbn("kk161");

    public static final C_SyoruiCdKbn KK_CLGOFF_HB = new C_SyoruiCdKbn("kk162");

    public static final C_SyoruiCdKbn KK_KAIJYO_HB = new C_SyoruiCdKbn("kk163");

    public static final C_SyoruiCdKbn KK_MUKOU_HB = new C_SyoruiCdKbn("kk164");

    public static final C_SyoruiCdKbn KK_SBKAIJYO_HB = new C_SyoruiCdKbn("kk165");

    public static final C_SyoruiCdKbn KK_SBMENSEKI_HB = new C_SyoruiCdKbn("kk166");

    public static final C_SyoruiCdKbn KK_KAIGOMAETKHNK_HB = new C_SyoruiCdKbn("kk167");

    public static final C_SyoruiCdKbn KK_SBMUKOU_HB = new C_SyoruiCdKbn("kk168");

    public static final C_SyoruiCdKbn KK_SBMUKOUNOSHR_HB = new C_SyoruiCdKbn("kk169");

    public static final C_SyoruiCdKbn KK_SBMENSEKINOSHR_HB = new C_SyoruiCdKbn("kk170");

    public static final C_SyoruiCdKbn KK_HUBI_KARISAKUSEI = new C_SyoruiCdKbn("kk171");

    public static final C_SyoruiCdKbn KK_MKHGKHNK_HB = new C_SyoruiCdKbn("kk172");

    public static final C_SyoruiCdKbn KK_YENDTHNKHNRKN_HB = new C_SyoruiCdKbn("kk173");

    public static final C_SyoruiCdKbn KK_TUMITATEKINITEN_HB = new C_SyoruiCdKbn("kk174");

    public static final C_SyoruiCdKbn KK_DSHR_HB = new C_SyoruiCdKbn("kk175");

    public static final C_SyoruiCdKbn KK_YENDTHNK_NINI_HB = new C_SyoruiCdKbn("kk176");

    public static final C_SyoruiCdKbn KK_KZKTRK_KYKDRTKYKHNK_HB = new C_SyoruiCdKbn("kk177");

    public static final C_SyoruiCdKbn KK_ADRHNK_HBLIST = new C_SyoruiCdKbn("kk201");

    public static final C_SyoruiCdKbn KK_MEIGIHNK_HBLIST = new C_SyoruiCdKbn("kk202");

    public static final C_SyoruiCdKbn KK_STDRHNK_HBLIST = new C_SyoruiCdKbn("kk203");

    public static final C_SyoruiCdKbn KK_SEINENGAPPISEI_HBLIST = new C_SyoruiCdKbn("kk204");

    public static final C_SyoruiCdKbn KK_GENGAKU_HBLIST = new C_SyoruiCdKbn("kk205");

    public static final C_SyoruiCdKbn KK_NKTKYKHNK_HBLIST = new C_SyoruiCdKbn("kk206");

    public static final C_SyoruiCdKbn KK_TARGETHNK_HBLIST = new C_SyoruiCdKbn("kk207");

    public static final C_SyoruiCdKbn KK_KAIYAKU_HBLIST = new C_SyoruiCdKbn("kk208");

    public static final C_SyoruiCdKbn KK_SHRKZHNK_HBLIST = new C_SyoruiCdKbn("kk209");

    public static final C_SyoruiCdKbn KK_SYOSAIHK_HBLIST = new C_SyoruiCdKbn("kk210");

    public static final C_SyoruiCdKbn KK_KYKTORIKESI_HBLIST = new C_SyoruiCdKbn("kk211");

    public static final C_SyoruiCdKbn KK_CLGOFF_HBLIST = new C_SyoruiCdKbn("kk212");

    public static final C_SyoruiCdKbn KK_KAIJYO_HBLIST = new C_SyoruiCdKbn("kk213");

    public static final C_SyoruiCdKbn KK_MUKOU_HBLIST = new C_SyoruiCdKbn("kk214");

    public static final C_SyoruiCdKbn KK_SBKAIJYO_HBLIST = new C_SyoruiCdKbn("kk215");

    public static final C_SyoruiCdKbn KK_SBMENSEKI_HBLIST = new C_SyoruiCdKbn("kk216");

    public static final C_SyoruiCdKbn KK_KAIGOMAETKHNK_HBLIST = new C_SyoruiCdKbn("kk217");

    public static final C_SyoruiCdKbn KK_SBMUKOU_HBLIST = new C_SyoruiCdKbn("kk218");

    public static final C_SyoruiCdKbn KK_SBMUKOUNOSHR_HBLIST = new C_SyoruiCdKbn("kk219");

    public static final C_SyoruiCdKbn KK_SBMENSEKINOSHR_HBLIST = new C_SyoruiCdKbn("kk220");

    public static final C_SyoruiCdKbn KK_MKHGKHNK_HBLIST = new C_SyoruiCdKbn("kk221");

    public static final C_SyoruiCdKbn KK_YENDTHNKHNRKN_HBLIST = new C_SyoruiCdKbn("kk222");

    public static final C_SyoruiCdKbn KK_TUMITATEKINITEN_HBLIST = new C_SyoruiCdKbn("kk223");

    public static final C_SyoruiCdKbn KK_DSHR_HBLIST = new C_SyoruiCdKbn("kk224");

    public static final C_SyoruiCdKbn KK_YENDTHNK_NINI_HBLIST = new C_SyoruiCdKbn("kk225");

    public static final C_SyoruiCdKbn KK_KZKTRK_KYKDRTKYKHNK_HBLIST = new C_SyoruiCdKbn("kk226");

    public static final C_SyoruiCdKbn KK_NKTKYKHNK_GAIYOU = new C_SyoruiCdKbn("kk251");

    public static final C_SyoruiCdKbn KK_KAIGOMAETK_KYKGAIYOU = new C_SyoruiCdKbn("kk252");

    public static final C_SyoruiCdKbn KK_KAIGOMAETK_TYUUIKANKI = new C_SyoruiCdKbn("kk253");

    public static final C_SyoruiCdKbn KK_MYNUMBER_SYORUI_GENGAKU = new C_SyoruiCdKbn("kk256");

    public static final C_SyoruiCdKbn KK_MYNUMBER_SYORUI_KAIYAKU = new C_SyoruiCdKbn("kk257");

    public static final C_SyoruiCdKbn KK_MYNUMBER_SYORUI_YENDTHNKHNRKN = new C_SyoruiCdKbn("kk258");

    public static final C_SyoruiCdKbn KK_MEIGIHNK_DAIHYOUSN = new C_SyoruiCdKbn("kk260");

    public static final C_SyoruiCdKbn KK_KAIYAKU_DAIHYOUSN = new C_SyoruiCdKbn("kk261");

    public static final C_SyoruiCdKbn KK_YENDTHNKHNRKN_DAIHYOUSN = new C_SyoruiCdKbn("kk262");

    public static final C_SyoruiCdKbn KK_MEIGIHNK_TORIHIKIKAK = new C_SyoruiCdKbn("kk266");

    public static final C_SyoruiCdKbn KK_KAIYAKU_TORIHIKIKAK = new C_SyoruiCdKbn("kk267");

    public static final C_SyoruiCdKbn KK_SOUHUANNAI = new C_SyoruiCdKbn("kk270");

    public static final C_SyoruiCdKbn KK_SHIHARAI_SOUHU = new C_SyoruiCdKbn("kk271");

    public static final C_SyoruiCdKbn KK_KYKNAIYOUOSIRASE1 = new C_SyoruiCdKbn("kk280");

    public static final C_SyoruiCdKbn KK_KYKNAIYOUOSIRASE2 = new C_SyoruiCdKbn("kk281");

    public static final C_SyoruiCdKbn KK_KYKNAIYOUOSIRASE3 = new C_SyoruiCdKbn("kk282");

    public static final C_SyoruiCdKbn KK_KYKNAIYOUOSIRASE4 = new C_SyoruiCdKbn("kk283");

    public static final C_SyoruiCdKbn KK_KYKNAIYOUOSIRASE5 = new C_SyoruiCdKbn("kk284");

    public static final C_SyoruiCdKbn KK_KYKNAIYOUOSIRASE6 = new C_SyoruiCdKbn("kk285");

    public static final C_SyoruiCdKbn KK_KYKNAIYOUOSIRASE7 = new C_SyoruiCdKbn("kk286");

    public static final C_SyoruiCdKbn KK_HKNSYKN = new C_SyoruiCdKbn("kk301");

    public static final C_SyoruiCdKbn KK_HKNSYKNITIJI = new C_SyoruiCdKbn("kk302");

    public static final C_SyoruiCdKbn KK_SKSYOUKEN = new C_SyoruiCdKbn("kk303");

    public static final C_SyoruiCdKbn KK_SAISYOUKEN = new C_SyoruiCdKbn("kk304");

    public static final C_SyoruiCdKbn KK_SUIIHYOU = new C_SyoruiCdKbn("kk305");

    public static final C_SyoruiCdKbn KK_GAIKA_KOKYAKUTUUTI = new C_SyoruiCdKbn("kk306");

    public static final C_SyoruiCdKbn KK_SEISANDHANEITUUTI = new C_SyoruiCdKbn("kk307");

    public static final C_SyoruiCdKbn KK_KOUJYOSYOUMEIS = new C_SyoruiCdKbn("kk311");

    public static final C_SyoruiCdKbn KK_KOUJYOSYOUMEIS_GAIBU = new C_SyoruiCdKbn("kk312");

    public static final C_SyoruiCdKbn KK_KOUJYOSYOUMEIS_SG = new C_SyoruiCdKbn("kk313");

    public static final C_SyoruiCdKbn KK_SINNINTOUHYOU = new C_SyoruiCdKbn("kk320");

    public static final C_SyoruiCdKbn KK_SYAINMEIBO = new C_SyoruiCdKbn("kk322");

    public static final C_SyoruiCdKbn KK_GENKYOUTUUTI = new C_SyoruiCdKbn("kk323");

    public static final C_SyoruiCdKbn KK_JIGYOUNENDOMATU = new C_SyoruiCdKbn("kk324");

    public static final C_SyoruiCdKbn KK_SOUGOUTUUTI = new C_SyoruiCdKbn("kk341");

    public static final C_SyoruiCdKbn KK_ANSINDAYORI = new C_SyoruiCdKbn("kk342");

    public static final C_SyoruiCdKbn KK_KOUHURIMINYUUTUUTI = new C_SyoruiCdKbn("kk402");

    public static final C_SyoruiCdKbn KK_1PNYKNKANSYOUTUUTI = new C_SyoruiCdKbn("kk405");

    public static final C_SyoruiCdKbn KK_MUKOUTUUTI = new C_SyoruiCdKbn("kk406");

    public static final C_SyoruiCdKbn KK_SIKKOUTUUTI = new C_SyoruiCdKbn("kk407");

    public static final C_SyoruiCdKbn KK_JIMURENRAKU = new C_SyoruiCdKbn("kk801");

    public static final C_SyoruiCdKbn KK_JIMURENRAKU_GENGAKU = new C_SyoruiCdKbn("kk802");

    public static final C_SyoruiCdKbn KK_JIMURENRAKU_SEINENGAPPISEITEISEI = new C_SyoruiCdKbn("kk803");

    public static final C_SyoruiCdKbn KK_JIMURENRAKU_KYKTORIKESI = new C_SyoruiCdKbn("kk804");

    public static final C_SyoruiCdKbn KK_JIMURENRAKU_MEIGIHNK = new C_SyoruiCdKbn("kk805");

    public static final C_SyoruiCdKbn KK_JIMURENRAKU_TETUDUKITYUUI = new C_SyoruiCdKbn("kk806");

    public static final C_SyoruiCdKbn KK_SYOUKENMS_SKEI = new C_SyoruiCdKbn("kk811");

    public static final C_SyoruiCdKbn KK_SYOUKENMS_SAI = new C_SyoruiCdKbn("kk812");

    public static final C_SyoruiCdKbn KK_SYOUKENTOKUSYU_SKEI = new C_SyoruiCdKbn("kk813");

    public static final C_SyoruiCdKbn KK_SYOUKENTOKUSYU_SAI = new C_SyoruiCdKbn("kk814");

    public static final C_SyoruiCdKbn KK_INSIZEILIST_SKEI = new C_SyoruiCdKbn("kk815");

    public static final C_SyoruiCdKbn KK_INSIZEILIST_SAI = new C_SyoruiCdKbn("kk816");

    public static final C_SyoruiCdKbn KK_TRKKZKKNRTUUTISAGYOULIST = new C_SyoruiCdKbn("kk817");

    public static final C_SyoruiCdKbn KK_GENSENLIST = new C_SyoruiCdKbn("kk821");

    public static final C_SyoruiCdKbn KK_TYOUSYOLIST_UK_KAIJYO = new C_SyoruiCdKbn("kk822");

    public static final C_SyoruiCdKbn KK_TYOUSYOLIST_UK_MENSEKI = new C_SyoruiCdKbn("kk823");

    public static final C_SyoruiCdKbn KK_TYOUSYOLIST_ITJ_KAIYAKU = new C_SyoruiCdKbn("kk826");

    public static final C_SyoruiCdKbn KK_KAIYAKU_BIKINSAGYOULIST = new C_SyoruiCdKbn("kk828");

    public static final C_SyoruiCdKbn KK_KAIYAKU_BIKINJIKOUKIST = new C_SyoruiCdKbn("kk829");

    public static final C_SyoruiCdKbn KK_KH_BIKINLIST = new C_SyoruiCdKbn("kk830");

    public static final C_SyoruiCdKbn KK_YENDTHNK_BIKINLIST = new C_SyoruiCdKbn("kk831");

    public static final C_SyoruiCdKbn KK_ZENNOUSEISANKINMEISAILIST_GENGAKU = new C_SyoruiCdKbn("kk832");

    public static final C_SyoruiCdKbn KK_ZENNOUSEISANKINMEISAILIST_KAIYAKU = new C_SyoruiCdKbn("kk833");

    public static final C_SyoruiCdKbn KK_MKKPHENKINLIST_GENGAKU = new C_SyoruiCdKbn("kk834");

    public static final C_SyoruiCdKbn KK_MKKPHENKINLIST_KAIYAKU = new C_SyoruiCdKbn("kk835");

    public static final C_SyoruiCdKbn KK_AZUKARIKINLIST = new C_SyoruiCdKbn("kk836");

    public static final C_SyoruiCdKbn KK_AZUKARIKIN_BIKINLIST = new C_SyoruiCdKbn("kk837");

    public static final C_SyoruiCdKbn KK_SYOURAIW_SISANHYOU = new C_SyoruiCdKbn("kk851");

    public static final C_SyoruiCdKbn KK_HNGKUNEIHIKAKLIST = new C_SyoruiCdKbn("kk852");

    public static final C_SyoruiCdKbn KK_KACHECK_YOHURI_MISSLIST = new C_SyoruiCdKbn("kk861");

    public static final C_SyoruiCdKbn KK_KACHECK_SHRKZ_MISSLIST = new C_SyoruiCdKbn("kk862");

    public static final C_SyoruiCdKbn KK_KYKINFOTORIKOMI_MISSLIST = new C_SyoruiCdKbn("kk863");

    public static final C_SyoruiCdKbn KK_SHRKEKKATORIKOMI_MISSLIST = new C_SyoruiCdKbn("kk864");

    public static final C_SyoruiCdKbn KK_KZHURIANNAISEL_MISSLIST = new C_SyoruiCdKbn("kk865");

    public static final C_SyoruiCdKbn KK_YUUKOUKEKKAHANEI_MISSLIST = new C_SyoruiCdKbn("kk866");

    public static final C_SyoruiCdKbn KK_AUTHORIKEKKAHANEI_MISSLIST = new C_SyoruiCdKbn("kk867");

    public static final C_SyoruiCdKbn KK_URIAGEKEKKATRSKS_MISSLIST = new C_SyoruiCdKbn("kk868");

    public static final C_SyoruiCdKbn KK_NYUUKIN_MISSLIST = new C_SyoruiCdKbn("kk869");

    public static final C_SyoruiCdKbn KK_LINC_MISSLIST = new C_SyoruiCdKbn("kk870");

    public static final C_SyoruiCdKbn KK_MINYUUITIRAN = new C_SyoruiCdKbn("kk871");

    public static final C_SyoruiCdKbn KK_SIKKOUITIRAN = new C_SyoruiCdKbn("kk872");

    public static final C_SyoruiCdKbn KK_HANDKARIKANJYOU = new C_SyoruiCdKbn("kk873");

    public static final C_SyoruiCdKbn KK_DHANEI_MISSLIST = new C_SyoruiCdKbn("kk874");

    public static final C_SyoruiCdKbn KK_BATCHKAIYAKU_MISSLIST = new C_SyoruiCdKbn("kk875");

    public static final C_SyoruiCdKbn KK_YENDTHNK_MISSLIST = new C_SyoruiCdKbn("kk876");

    public static final C_SyoruiCdKbn KK_YENDTHNKSEL_MISSLIST = new C_SyoruiCdKbn("kk877");

    public static final C_SyoruiCdKbn KK_SEISANDHANEI_MISSLIST = new C_SyoruiCdKbn("kk878");

    public static final C_SyoruiCdKbn KK_DSEISAN_MISSLIST = new C_SyoruiCdKbn("kk879");

    public static final C_SyoruiCdKbn KK_SISUURENDOTMTTKNHANEI_MISSLIST = new C_SyoruiCdKbn("kk880");

    public static final C_SyoruiCdKbn KK_GAIKAKOKYAKUTUUTISKS_MISSLIST = new C_SyoruiCdKbn("kk881");

    public static final C_SyoruiCdKbn KK_BATCHMKHGKHENKOU_MISSLIST = new C_SyoruiCdKbn("kk882");

    public static final C_SyoruiCdKbn KK_SEIKYUKNK_SYOSAIHK = new C_SyoruiCdKbn("kk901");

    public static final C_SyoruiCdKbn KK_HUBIKNK_SYOSAIHK = new C_SyoruiCdKbn("kk902");

    public static final C_SyoruiCdKbn KK_SEIKYUKNK_MEIGIHNK = new C_SyoruiCdKbn("kk903");

    public static final C_SyoruiCdKbn KK_HUBIKNK_MEIGIHNK = new C_SyoruiCdKbn("kk904");

    public static final C_SyoruiCdKbn KK_SEIKYUKNK_SEINENGAPPISEI = new C_SyoruiCdKbn("kk905");

    public static final C_SyoruiCdKbn KK_HUBIKNK_SEINENGAPPISEI = new C_SyoruiCdKbn("kk906");

    public static final C_SyoruiCdKbn KK_SEIKYUKNK_GENGAKU = new C_SyoruiCdKbn("kk907");

    public static final C_SyoruiCdKbn KK_HUBIKNK_GENGAKU = new C_SyoruiCdKbn("kk908");

    public static final C_SyoruiCdKbn KK_SEIKYUKNK_KAIYAKU = new C_SyoruiCdKbn("kk909");

    public static final C_SyoruiCdKbn KK_HUBIKNK_KAIYAKU = new C_SyoruiCdKbn("kk910");

    public static final C_SyoruiCdKbn KK_TODOKEDEKNK_ADRHNK = new C_SyoruiCdKbn("kk911");

    public static final C_SyoruiCdKbn KK_HUBIKNK_ADRHNK = new C_SyoruiCdKbn("kk912");

    public static final C_SyoruiCdKbn KK_SEIKYUKNK_STDRSKYTKYK = new C_SyoruiCdKbn("kk913");

    public static final C_SyoruiCdKbn KK_HUBIKNK_STDRSKYTKYK = new C_SyoruiCdKbn("kk914");

    public static final C_SyoruiCdKbn KK_SEIKYUKNK_KAIGOMAETKHNK = new C_SyoruiCdKbn("kk915");

    public static final C_SyoruiCdKbn KK_HUBIKNK_KAIGOMAETKHNK = new C_SyoruiCdKbn("kk916");

    public static final C_SyoruiCdKbn KK_SEIKYUKNK_MKHGKHNK = new C_SyoruiCdKbn("kk917");

    public static final C_SyoruiCdKbn KK_HUBIKNK_MKHGKHNK = new C_SyoruiCdKbn("kk918");

    public static final C_SyoruiCdKbn KK_SEIKYUKNK_YENDTHNKHNRKN = new C_SyoruiCdKbn("kk919");

    public static final C_SyoruiCdKbn KK_HUBIKNK_YENDTHNKHNRKN = new C_SyoruiCdKbn("kk920");

    public static final C_SyoruiCdKbn KK_SEIKYUKNK_TUMITATEKINITEN = new C_SyoruiCdKbn("kk921");

    public static final C_SyoruiCdKbn KK_HUBIKNK_TUMITATEKINITEN = new C_SyoruiCdKbn("kk922");

    public static final C_SyoruiCdKbn KK_SEIKYUKNK_DSHR = new C_SyoruiCdKbn("kk923");

    public static final C_SyoruiCdKbn KK_HUBIKNK_DSHR = new C_SyoruiCdKbn("kk924");

    public static final C_SyoruiCdKbn KK_SEIKYUKNK_YENDTHNK_NINI = new C_SyoruiCdKbn("kk925");

    public static final C_SyoruiCdKbn KK_HUBIKNK_YENDTHNK_NINI = new C_SyoruiCdKbn("kk926");

    public static final C_SyoruiCdKbn KK_HUBIKNK_KYKTORIKESI = new C_SyoruiCdKbn("kk927");

    public static final C_SyoruiCdKbn KK_HUBIKNK_CLGOFF = new C_SyoruiCdKbn("kk928");

    public static final C_SyoruiCdKbn KK_HUBIKNK_KAIJYO = new C_SyoruiCdKbn("kk929");

    public static final C_SyoruiCdKbn KK_HUBIKNK_MUKOU = new C_SyoruiCdKbn("kk930");

    public static final C_SyoruiCdKbn KK_HUBIKNK_SBKAIJYO = new C_SyoruiCdKbn("kk931");

    public static final C_SyoruiCdKbn KK_HUBIKNK_SBMENSEKI = new C_SyoruiCdKbn("kk932");

    public static final C_SyoruiCdKbn KK_HUBIKNK_SBMUKOU = new C_SyoruiCdKbn("kk933");

    public static final C_SyoruiCdKbn KK_HUBIKNK_SBMUKOUNOSHR = new C_SyoruiCdKbn("kk934");

    public static final C_SyoruiCdKbn KK_HUBIKNK_SBMENSEKINOSHR = new C_SyoruiCdKbn("kk935");

    public static final C_SyoruiCdKbn KK_SEIKYUKNK_KZKTRKKYKDRHNK = new C_SyoruiCdKbn("kk936");

    public static final C_SyoruiCdKbn KK_HUBIKNK_KZKTRKKYKDRHNK = new C_SyoruiCdKbn("kk937");

    public static final C_SyoruiCdKbn AS_KOUHURIKAISIANNAI = new C_SyoruiCdKbn("as001");

    public static final C_SyoruiCdKbn AS_KIJITUTOURAIANNAI = new C_SyoruiCdKbn("as002");

    public static final C_SyoruiCdKbn AS_KZHENKINTUUTI = new C_SyoruiCdKbn("as051");

    public static final C_SyoruiCdKbn AS_KZHURIKOMITUUTI = new C_SyoruiCdKbn("as052");

    public static final C_SyoruiCdKbn AS_KRKKN_SEIBITOKUSOKULIST_1 = new C_SyoruiCdKbn("as053");

    public static final C_SyoruiCdKbn AS_CREDITHENKINTUUTI = new C_SyoruiCdKbn("as054");

    public static final C_SyoruiCdKbn AS_KRKKN_SEIBITOKUSOKULIST_2 = new C_SyoruiCdKbn("as055");

    public static final C_SyoruiCdKbn AS_KOUHURIMINYUUTUUTI = new C_SyoruiCdKbn("as101");

    public static final C_SyoruiCdKbn AS_CREDITMINYUUTUUTI = new C_SyoruiCdKbn("as102");

    public static final C_SyoruiCdKbn AS_DATTAITUUTI_KOUHURI = new C_SyoruiCdKbn("as151");

    public static final C_SyoruiCdKbn AS_DATTAI_MIKAISYOULIST = new C_SyoruiCdKbn("as152");

    public static final C_SyoruiCdKbn AS_YUUKOUSEINGTUUTI = new C_SyoruiCdKbn("as153");

    public static final C_SyoruiCdKbn AS_HRHNTTDKANNAI = new C_SyoruiCdKbn("as301");

    public static final C_SyoruiCdKbn AS_PKZHRIKEIRAI = new C_SyoruiCdKbn("as302");

    public static final C_SyoruiCdKbn AS_PHRKKAISUUHENKOUMOS = new C_SyoruiCdKbn("as303");

    public static final C_SyoruiCdKbn AS_HRHNKANRYOTUUTI = new C_SyoruiCdKbn("as304");

    public static final C_SyoruiCdKbn AS_HRHNKANRYOTUUTI_DNP = new C_SyoruiCdKbn("as305");

    public static final C_SyoruiCdKbn AS_HRHN_HB = new C_SyoruiCdKbn("as306");

    public static final C_SyoruiCdKbn AS_HRHN_HBLIST = new C_SyoruiCdKbn("as307");

    public static final C_SyoruiCdKbn AS_CREDITCARDMOS = new C_SyoruiCdKbn("as308");

    public static final C_SyoruiCdKbn AS_SINKOKUYOKOKUTUUTI = new C_SyoruiCdKbn("as351");

    public static final C_SyoruiCdKbn AS_SAIGAITOKUSINKEIYAKUHOYUULIST = new C_SyoruiCdKbn("as401");

    public static final C_SyoruiCdKbn AS_ZENNOUTOUKEILIST = new C_SyoruiCdKbn("as403");

    public static final C_SyoruiCdKbn AS_ZENNOUMKKPKSSAMPLELIST = new C_SyoruiCdKbn("as404");

    public static final C_SyoruiCdKbn AS_PMINYUUSYOUMETUHRBKNLIST = new C_SyoruiCdKbn("as407");

    public static final C_SyoruiCdKbn AS_SYOUMETUTUUTI = new C_SyoruiCdKbn("as501");

    public static final C_SyoruiCdKbn AS_SYOUMETUTUUTI_SHRSKS = new C_SyoruiCdKbn("as502");

    public static final C_SyoruiCdKbn AS_SYOUMETUKEIYAKULIST = new C_SyoruiCdKbn("as503");

    public static final C_SyoruiCdKbn AS_JIMURENRAKU_SYUUNOU = new C_SyoruiCdKbn("as901");

    public static final C_SyoruiCdKbn AS_MISSLIST_SYUUNOU = new C_SyoruiCdKbn("as902");

    public static final C_SyoruiCdKbn AS_PMINYUUSYOUMETU_MISSLIST = new C_SyoruiCdKbn("as903");

    public static final C_SyoruiCdKbn AS_URIAGESEIKYUUKEKKA_ERRORLIST = new C_SyoruiCdKbn("as904");

    public static final C_SyoruiCdKbn AS_CREDITTOUROKUKENSUULIST = new C_SyoruiCdKbn("as905");

    public static final C_SyoruiCdKbn AS_MOSKNK_HRHN = new C_SyoruiCdKbn("as910");

    public static final C_SyoruiCdKbn AS_HUBIKNK_HRHN = new C_SyoruiCdKbn("as911");

    public static final C_SyoruiCdKbn AS_YUUKOUKAKUNIN_ERRORLIST = new C_SyoruiCdKbn("as906");

    public static final C_SyoruiCdKbn AS_MINUSURIAGEKYKDTLLIST = new C_SyoruiCdKbn("as907");

    public static final C_SyoruiCdKbn NK_SKS = new C_SyoruiCdKbn("nk005");

    public static final C_SyoruiCdKbn NK_SKS_ITJ = new C_SyoruiCdKbn("nk010");

    public static final C_SyoruiCdKbn NK_SKS_SIBOU = new C_SyoruiCdKbn("nk015");

    public static final C_SyoruiCdKbn NK_SKS_MGHNK = new C_SyoruiCdKbn("nk020");

    public static final C_SyoruiCdKbn NK_SKS_KZHNK = new C_SyoruiCdKbn("nk025");

    public static final C_SyoruiCdKbn NK_SKS_KAISUHNK = new C_SyoruiCdKbn("nk030");

    public static final C_SyoruiCdKbn NK_SKS_SAIHAKKOU = new C_SyoruiCdKbn("nk035");

    public static final C_SyoruiCdKbn NK_SKS_TK_STDRSKTKY = new C_SyoruiCdKbn("nk040");

    public static final C_SyoruiCdKbn NK_SKS_TK_KKNKUKT = new C_SyoruiCdKbn("nk045");

    public static final C_SyoruiCdKbn NK_SKS_D_UKTRHOU_HK = new C_SyoruiCdKbn("nk050");

    public static final C_SyoruiCdKbn NK_SOUHU_ITJ = new C_SyoruiCdKbn("nk110");

    public static final C_SyoruiCdKbn NK_SOUHU_SIBOU = new C_SyoruiCdKbn("nk115");

    public static final C_SyoruiCdKbn NK_SOUHU_MGHNK = new C_SyoruiCdKbn("nk120");

    public static final C_SyoruiCdKbn NK_SOUHU_KZHNK = new C_SyoruiCdKbn("nk125");

    public static final C_SyoruiCdKbn NK_SOUHU_KAISUHNK = new C_SyoruiCdKbn("nk130");

    public static final C_SyoruiCdKbn NK_SOUHU_SAIHAKKOU = new C_SyoruiCdKbn("nk135");

    public static final C_SyoruiCdKbn NK_SOUHU_TK_STDRSKTKY = new C_SyoruiCdKbn("nk140");

    public static final C_SyoruiCdKbn NK_SOUHU_TK_KKNKUKT = new C_SyoruiCdKbn("nk145");

    public static final C_SyoruiCdKbn NK_SOUHU_D_UKTRHOU_HK = new C_SyoruiCdKbn("nk150");

    public static final C_SyoruiCdKbn NK_SISAN_ITJ = new C_SyoruiCdKbn("nk210");

    public static final C_SyoruiCdKbn NK_SISAN_SIBOU = new C_SyoruiCdKbn("nk215");

    public static final C_SyoruiCdKbn NK_HUBI_ITJ = new C_SyoruiCdKbn("nk310");

    public static final C_SyoruiCdKbn NK_HUBI_SIBOU = new C_SyoruiCdKbn("nk315");

    public static final C_SyoruiCdKbn NK_HUBI_MGHNK = new C_SyoruiCdKbn("nk320");

    public static final C_SyoruiCdKbn NK_HUBI_KZHNK = new C_SyoruiCdKbn("nk325");

    public static final C_SyoruiCdKbn NK_HUBI_KAISUHNK = new C_SyoruiCdKbn("nk330");

    public static final C_SyoruiCdKbn NK_HUBI_SAIHAKKOU = new C_SyoruiCdKbn("nk335");

    public static final C_SyoruiCdKbn NK_HUBI_TK_STDRSKTKY = new C_SyoruiCdKbn("nk340");

    public static final C_SyoruiCdKbn NK_HUBI_TK_KKNKUKT = new C_SyoruiCdKbn("nk345");

    public static final C_SyoruiCdKbn NK_SOUHU_HUBI_ITJ = new C_SyoruiCdKbn("nk410");

    public static final C_SyoruiCdKbn NK_SOUHU_HUBI_SIBOU = new C_SyoruiCdKbn("nk415");

    public static final C_SyoruiCdKbn NK_SOUHU_HUBI_MGHNK = new C_SyoruiCdKbn("nk420");

    public static final C_SyoruiCdKbn NK_SOUHU_HUBI_KZHNK = new C_SyoruiCdKbn("nk425");

    public static final C_SyoruiCdKbn NK_SOUHU_HUBI_KAISUHNK = new C_SyoruiCdKbn("nk430");

    public static final C_SyoruiCdKbn NK_SOUHU_HUBI_SAIHAKKOU = new C_SyoruiCdKbn("nk435");

    public static final C_SyoruiCdKbn NK_SOUHU_HUBI_TK_STDRSKTKY = new C_SyoruiCdKbn("nk440");

    public static final C_SyoruiCdKbn NK_SOUHU_HUBI_TK_KKNKUKT = new C_SyoruiCdKbn("nk445");

    public static final C_SyoruiCdKbn NK_NKSYOUSYO = new C_SyoruiCdKbn("nk500");

    public static final C_SyoruiCdKbn NK_TTDKKNR_NKIKOU = new C_SyoruiCdKbn("nk505");

    public static final C_SyoruiCdKbn NK_SHRMEISAISYO = new C_SyoruiCdKbn("nk510");

    public static final C_SyoruiCdKbn NK_TTDKKNR_ITJ = new C_SyoruiCdKbn("nk515");

    public static final C_SyoruiCdKbn NK_TTDKKNR_TJSHR = new C_SyoruiCdKbn("nk520");

    public static final C_SyoruiCdKbn NK_TTDKKNR_SIBOU = new C_SyoruiCdKbn("nk525");

    public static final C_SyoruiCdKbn NK_TTDKKNR_UKTHNK = new C_SyoruiCdKbn("nk530");

    public static final C_SyoruiCdKbn NK_TTDKKNR_MGHNK = new C_SyoruiCdKbn("nk535");

    public static final C_SyoruiCdKbn NK_TTDKKNR_KZHNK = new C_SyoruiCdKbn("nk540");

    public static final C_SyoruiCdKbn NK_TTDKKNR_KAISUHNK = new C_SyoruiCdKbn("nk545");

    public static final C_SyoruiCdKbn NK_TTDKKNR_SAIHAKKOU = new C_SyoruiCdKbn("nk550");

    public static final C_SyoruiCdKbn NK_TTDKKNR_TK_STDRSKTKY = new C_SyoruiCdKbn("nk555");

    public static final C_SyoruiCdKbn NK_TTDKKNR_TK_KKNKUKT = new C_SyoruiCdKbn("nk560");

    public static final C_SyoruiCdKbn NK_DAIHYOUSENNINTDK = new C_SyoruiCdKbn("nk600");

    public static final C_SyoruiCdKbn NK_KOSEKITOUHON = new C_SyoruiCdKbn("nk605");

    public static final C_SyoruiCdKbn NK_KOSEKITOUHON_KAISEI = new C_SyoruiCdKbn("nk606");

    public static final C_SyoruiCdKbn NK_JYUUMIN = new C_SyoruiCdKbn("nk607");

    public static final C_SyoruiCdKbn NK_HONNINKAKUNIN = new C_SyoruiCdKbn("nk610");

    public static final C_SyoruiCdKbn NK_HONNINKAKUNIN_SHR = new C_SyoruiCdKbn("nk611");

    public static final C_SyoruiCdKbn NK_SIBOUSINDAN = new C_SyoruiCdKbn("nk615");

    public static final C_SyoruiCdKbn NK_TORIHIKIJIKAKUNIN = new C_SyoruiCdKbn("nk620");

    public static final C_SyoruiCdKbn NK_NKTRKM_MISSLIST = new C_SyoruiCdKbn("nk700");

    public static final C_SyoruiCdKbn NK_JDSHR_MISSLIST = new C_SyoruiCdKbn("nk710");

    public static final C_SyoruiCdKbn NK_KSCHK_MISSLIST = new C_SyoruiCdKbn("nk720");

    public static final C_SyoruiCdKbn NK_GNSNLIST = new C_SyoruiCdKbn("nk730");

    public static final C_SyoruiCdKbn NK_HUBIMIKAISYOULIST = new C_SyoruiCdKbn("nk740");

    public static final C_SyoruiCdKbn NK_TYOUSYOLIST_NK = new C_SyoruiCdKbn("nk751");

    public static final C_SyoruiCdKbn NK_TYOUSYOLIST_ITJ_NK = new C_SyoruiCdKbn("nk752");

    public static final C_SyoruiCdKbn NK_TYOUSYOLIST_UK_NK = new C_SyoruiCdKbn("nk753");

    public static final C_SyoruiCdKbn SK_MOSSYO = new C_SyoruiCdKbn("sk001");

    public static final C_SyoruiCdKbn SK_PPLESSMOSIKOUKAKSYO = new C_SyoruiCdKbn("sk002");

    public static final C_SyoruiCdKbn SK_KOKUSYO = new C_SyoruiCdKbn("sk003");

    public static final C_SyoruiCdKbn SK_PPLESSKOKUSYO = new C_SyoruiCdKbn("sk004");

    public static final C_SyoruiCdKbn SK_IKOUKAKSYO = new C_SyoruiCdKbn("sk005");

    public static final C_SyoruiCdKbn SK_IKOUKAKSYO_TEISEI = new C_SyoruiCdKbn("sk006");

    public static final C_SyoruiCdKbn SK_UKTHUKUSUUSITEI = new C_SyoruiCdKbn("sk007");

    public static final C_SyoruiCdKbn SK_UKTJIZENSYOUKAI = new C_SyoruiCdKbn("sk008");

    public static final C_SyoruiCdKbn SK_DAISANSYAUKTHOUSYO = new C_SyoruiCdKbn("sk009");

    public static final C_SyoruiCdKbn SK_FATCAKAKUNINSYO = new C_SyoruiCdKbn("sk010");

    public static final C_SyoruiCdKbn SK_TORIHOUSYO = new C_SyoruiCdKbn("sk011");

    public static final C_SyoruiCdKbn SK_PPLESSTORIHOUSYO = new C_SyoruiCdKbn("sk012");

    public static final C_SyoruiCdKbn SK_SONOTAHUZOKU = new C_SyoruiCdKbn("sk013");

    public static final C_SyoruiCdKbn SK_HENKOUTEISEI = new C_SyoruiCdKbn("sk014");

    public static final C_SyoruiCdKbn SK_AEOISINKITODOKEDESYO = new C_SyoruiCdKbn("sk015");

    public static final C_SyoruiCdKbn SK_SEIMEIPKZHURIKAEMOSSYO = new C_SyoruiCdKbn("sk016");

    public static final C_SyoruiCdKbn SK_DAIHITUHOUKOKUSYO = new C_SyoruiCdKbn("sk017");

    public static final C_SyoruiCdKbn SK_HITAIMENCHKSHEET = new C_SyoruiCdKbn("sk018");

    public static final C_SyoruiCdKbn SK_JIMURENRAKU = new C_SyoruiCdKbn("sk031");

    public static final C_SyoruiCdKbn SK_HUBITUUTI = new C_SyoruiCdKbn("sk032");

    public static final C_SyoruiCdKbn SK_KYKKAKUNINIRAISYO = new C_SyoruiCdKbn("sk033");

    public static final C_SyoruiCdKbn SK_KYKKAKUNINKAITOUSYO = new C_SyoruiCdKbn("sk034");

    public static final C_SyoruiCdKbn SK_YUUKOUKKNYOKOKULIST = new C_SyoruiCdKbn("sk035");

    public static final C_SyoruiCdKbn SK_YUUKOUKKNTYOUKALIST = new C_SyoruiCdKbn("sk036");

    public static final C_SyoruiCdKbn SK_KYKHUSEIRITU = new C_SyoruiCdKbn("sk037");

    public static final C_SyoruiCdKbn SK_TRKSSEIKYU = new C_SyoruiCdKbn("sk038");

    public static final C_SyoruiCdKbn SK_TRKSSEIKYU_SOUHU = new C_SyoruiCdKbn("sk039");

    public static final C_SyoruiCdKbn SK_TTDKKR_DAIRITEN = new C_SyoruiCdKbn("sk040");

    public static final C_SyoruiCdKbn SK_TTDKKR = new C_SyoruiCdKbn("sk041");

    public static final C_SyoruiCdKbn SK_SMBCSINTYOKUMISSLIST = new C_SyoruiCdKbn("sk042");

    public static final C_SyoruiCdKbn SK_SENTAKINFOMISSLIST = new C_SyoruiCdKbn("sk043");

    public static final C_SyoruiCdKbn SK_YOTEIRIRITUHENKOURENRAKUHYOU = new C_SyoruiCdKbn("sk044");

    public static final C_SyoruiCdKbn SK_HUBITUUTI_KARISAKUSEI = new C_SyoruiCdKbn("sk045");

    public static final C_SyoruiCdKbn SK_KEIYAKUNAIYOTOROKUSEIDOSYOKAIHYO = new C_SyoruiCdKbn("sk046");

    public static final C_SyoruiCdKbn SK_HURIKOMINYKNSAKUJOMISSLIST = new C_SyoruiCdKbn("sk051");

    public static final C_SyoruiCdKbn SK_HURIKOMINYKNTEISEILIST_ENKA = new C_SyoruiCdKbn("sk052");

    public static final C_SyoruiCdKbn SK_SAKUJOKYKMEISAILIST = new C_SyoruiCdKbn("sk053");

    public static final C_SyoruiCdKbn SK_JIDOUNYKNMEISAILIST = new C_SyoruiCdKbn("sk054");

    public static final C_SyoruiCdKbn SK_1PNYKNITTILIST = new C_SyoruiCdKbn("sk055");

    public static final C_SyoruiCdKbn SK_NYKJYOUHOUHUITTIKAKSYO = new C_SyoruiCdKbn("sk056");

    public static final C_SyoruiCdKbn SK_MOSSOUHUJYOUKYOULIST = new C_SyoruiCdKbn("sk057");

    public static final C_SyoruiCdKbn SK_MOSMITOUTYAKUKKNLIST = new C_SyoruiCdKbn("sk058");

    public static final C_SyoruiCdKbn SK_MOSSOUHUJYOUKYOULIST_SOUHU = new C_SyoruiCdKbn("sk059");

    public static final C_SyoruiCdKbn SK_HURIKOMINYKNTEISEILIST_GAIKA = new C_SyoruiCdKbn("sk060");

    public static final C_SyoruiCdKbn SK_SIKINIDOULIST_HRKMKZHUITTI = new C_SyoruiCdKbn("sk061");

    public static final C_SyoruiCdKbn SK_HURIKOMINYKNTEISEILIST_ENKA_YENDT = new C_SyoruiCdKbn("sk062");

    public static final C_SyoruiCdKbn SK_SAKUJOKYKMEISAILIST_YENDT = new C_SyoruiCdKbn("sk063");

    public static final C_SyoruiCdKbn SK_JIDOUNYKNMEISAILIST_YENDT = new C_SyoruiCdKbn("sk064");

    public static final C_SyoruiCdKbn SK_1PNYKNITTILIST_YENDT = new C_SyoruiCdKbn("sk065");

    public static final C_SyoruiCdKbn SK_NYKJYOUHOUHUITTIKAKSYO_YENDT = new C_SyoruiCdKbn("sk066");

    public static final C_SyoruiCdKbn SK_MOSMITOUTYAKUKKNLIST_YENDT = new C_SyoruiCdKbn("sk067");

    public static final C_SyoruiCdKbn SK_HENKINIRAISYO = new C_SyoruiCdKbn("sk071");

    public static final C_SyoruiCdKbn SK_HENKINTUUTILIST = new C_SyoruiCdKbn("sk072");

    public static final C_SyoruiCdKbn SK_HANDKARIKANJYOU = new C_SyoruiCdKbn("sk073");

    public static final C_SyoruiCdKbn SK_HENKINMISYORILIST = new C_SyoruiCdKbn("sk074");

    public static final C_SyoruiCdKbn SK_HENKINIRAISYO_SOUHU = new C_SyoruiCdKbn("sk075");

    public static final C_SyoruiCdKbn SK_HENKINIRAISYO_MIHON = new C_SyoruiCdKbn("sk076");

    public static final C_SyoruiCdKbn SK_HANDKARIKANJYOU_YENDT = new C_SyoruiCdKbn("sk077");

    public static final C_SyoruiCdKbn SK_HENKINMISYORILIST_YENDT = new C_SyoruiCdKbn("sk078");

    public static final C_SyoruiCdKbn SK_KARIUKEHUHOPKAKIN1MKEIKA = new C_SyoruiCdKbn("sk081");

    public static final C_SyoruiCdKbn SK_GETUMATUZANDAKACHKLIST = new C_SyoruiCdKbn("sk082");

    public static final C_SyoruiCdKbn SK_MSRKARIUKEKINMEISAI = new C_SyoruiCdKbn("sk083");

    public static final C_SyoruiCdKbn SK_MSRJIYUUMEISAI_NYKNHUBI = new C_SyoruiCdKbn("sk084");

    public static final C_SyoruiCdKbn SK_MSRJIYUUMEISAI_SYORUIHUBI_TAN = new C_SyoruiCdKbn("sk085");

    public static final C_SyoruiCdKbn SK_MSRJIYUUMEISAI_SYORUIHUBI_HUKU = new C_SyoruiCdKbn("sk086");

    public static final C_SyoruiCdKbn SK_MSRJIYUUMEISAI_SEIRITUHRYUUUKTKTYUU = new C_SyoruiCdKbn("sk087");

    public static final C_SyoruiCdKbn SK_MSRJIYUUBETUKARIUKEKINSYUUKEI = new C_SyoruiCdKbn("sk088");

    public static final C_SyoruiCdKbn SK_MSRJIYUUBETUKARIUKEKINMEISAILIST = new C_SyoruiCdKbn("sk089");

    public static final C_SyoruiCdKbn SK_JIDSYUUNOUSYOUGOUMEISAI_KESSAN = new C_SyoruiCdKbn("sk090");

    public static final C_SyoruiCdKbn SK_KARIUKEKINPKAKINMEISAI = new C_SyoruiCdKbn("sk091");

    public static final C_SyoruiCdKbn SK_KARIUKEKINPKAKINZANDAKAMEISAILIST = new C_SyoruiCdKbn("sk092");

    public static final C_SyoruiCdKbn SK_HUKUSUUKAINYUUKINKAWASESASONEKI = new C_SyoruiCdKbn("sk093");

    public static final C_SyoruiCdKbn SK_CREDITQRTOUROKUMIHANEILIST = new C_SyoruiCdKbn("sk101");

    public static final C_SyoruiCdKbn SK_CREDITCARDKAIINTOUROKUNGLIST = new C_SyoruiCdKbn("sk102");

    public static final C_SyoruiCdKbn SK_CREDITCARDTOUROKUHANEIERRORLIST = new C_SyoruiCdKbn("sk103");

    public static final C_SyoruiCdKbn SK_YUUKOUHANEIKAKUNINKEKKALIST = new C_SyoruiCdKbn("sk104");

    public static final C_SyoruiCdKbn SK_FSTPURIAGESEIKYUUERRORLIST = new C_SyoruiCdKbn("sk105");

    public static final C_SyoruiCdKbn SK_FSTPURIAGESEIKYUUMEISAI_JCB = new C_SyoruiCdKbn("sk106");

    public static final C_SyoruiCdKbn SK_FSTPURIAGESEIKYUUMEISAI_VISA = new C_SyoruiCdKbn("sk107");

    public static final C_SyoruiCdKbn SK_KOUFURITOUROKUMIHANEILIST = new C_SyoruiCdKbn("sk108");

    public static final C_SyoruiCdKbn SK_KOUFURITOUROKUHANEIERRORLIST = new C_SyoruiCdKbn("sk109");

    public static final C_SyoruiCdKbn SK_KARIUKEHUHOPKAKIN1MKEIKA_YENDT = new C_SyoruiCdKbn("sk121");

    public static final C_SyoruiCdKbn SK_GETUMATUZANDAKACHKLIST_YENDT = new C_SyoruiCdKbn("sk122");

    public static final C_SyoruiCdKbn SK_MSRKARIUKEKINMEISAI_YENDT = new C_SyoruiCdKbn("sk123");

    public static final C_SyoruiCdKbn SK_MSRJIYUUMEISAI_NYKNHUBI_YENDT = new C_SyoruiCdKbn("sk124");

    public static final C_SyoruiCdKbn SK_MSRJIYUUMEISAI_SYORUIHUBI_TAN_YENDT = new C_SyoruiCdKbn("sk125");

    public static final C_SyoruiCdKbn SK_MSRJIYUUMEISAI_SYORUIHUBI_HUKU_YENDT = new C_SyoruiCdKbn("sk126");

    public static final C_SyoruiCdKbn SK_MSRJIYUUMEISAI_SEIRITUHRYUUUKTKTYUU_YENDT = new C_SyoruiCdKbn("sk127");

    public static final C_SyoruiCdKbn SK_MSRJIYUUBETUKARIUKEKINSYUUKEI_YENDT = new C_SyoruiCdKbn("sk128");

    public static final C_SyoruiCdKbn SK_MSRJIYUUBETUKARIUKEKINMEISAILIST_YENDT = new C_SyoruiCdKbn("sk129");

    public static final C_SyoruiCdKbn SK_JIDSYUUNOUSYOUGOUMEISAI_KESSAN_YENDT = new C_SyoruiCdKbn("sk130");

    public static final C_SyoruiCdKbn SK_KARIUKEKINPKAKINMEISAI_YENDT = new C_SyoruiCdKbn("sk131");

    public static final C_SyoruiCdKbn SK_KARIUKEKINPKAKINZANDAKAMEISAILIST_YENDT = new C_SyoruiCdKbn("sk132");

    public static final C_SyoruiCdKbn SR_OIKOMISYUUKEIHYOUTYOUSEI = new C_SyoruiCdKbn("sr001");

    public static final C_SyoruiCdKbn SR_OIKOMISYUUKEIPDENPYOU = new C_SyoruiCdKbn("sr002");

    public static final C_SyoruiCdKbn SR_SK_KESSANHURIDEN = new C_SyoruiCdKbn("sr003");

    public static final C_SyoruiCdKbn SR_SK_KESSANHURIDEN_HIKAE = new C_SyoruiCdKbn("sr004");

    public static final C_SyoruiCdKbn SR_TMTTDMEISAILIST = new C_SyoruiCdKbn("sr100");

    public static final C_SyoruiCdKbn SR_KBNKEIRIYOUTMTTDMEISAILIST = new C_SyoruiCdKbn("sr101");

    public static final C_SyoruiCdKbn SR_KARIWARIATEDMEISAILIS = new C_SyoruiCdKbn("sr102");

    public static final C_SyoruiCdKbn SR_BIKINKYKSEISANDLIST = new C_SyoruiCdKbn("sr103");

    public static final C_SyoruiCdKbn SR_KBNKEIRIYOUBIKINKYKSEISANDLIST = new C_SyoruiCdKbn("sr104");

    public static final C_SyoruiCdKbn SR_BIKINKYKKARIWARIATEDLIST = new C_SyoruiCdKbn("sr105");


    public static final String PATTERN_DEFAULT = "1";

    public static final String PATTERN_TYOHYOIKATUSYUTURYOKU = "2";

    public static final String PATTERN_KESSANYOUHUBISYORUIHYJ = "3";

    public static final String PATTERN_SKHUBITOUROKU = "4";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, WF_HYOUSI, "WF_HYOUSI", false);
        addPattern(PATTERN_DEFAULT, WF_QRSEAL, "WF_QRSEAL", false);
        addPattern(PATTERN_DEFAULT, USERITIRANHYOU, "USERITIRANHYOU", false);
        addPattern(PATTERN_DEFAULT, CM_JIMURENRAKUHYOU, "CM_JIMURENRAKUHYOU", false);
        addPattern(PATTERN_DEFAULT, CM_LINC_MISSLIST, "CM_LINC_MISSLIST", false);
        addPattern(PATTERN_DEFAULT, CM_ONLINE_FBFURIKOMIKEI_1, "CM_ONLINE_FBFURIKOMIKEI_1", false);
        addPattern(PATTERN_DEFAULT, CM_ONLINE_FBFURIKOMIKEI_2, "CM_ONLINE_FBFURIKOMIKEI_2", false);
        addPattern(PATTERN_DEFAULT, CM_ONLINE_GKFBFURIKOMIKEI_1, "CM_ONLINE_GKFBFURIKOMIKEI_1", false);
        addPattern(PATTERN_DEFAULT, CM_ONLINE_GKFBFURIKOMIKEI_2, "CM_ONLINE_GKFBFURIKOMIKEI_2", false);
        addPattern(PATTERN_DEFAULT, CM_ONLINE_FBSOUKINMEISAI_1, "CM_ONLINE_FBSOUKINMEISAI_1", false);
        addPattern(PATTERN_DEFAULT, CM_ONLINE_FBSOUKINMEISAI_2, "CM_ONLINE_FBSOUKINMEISAI_2", false);
        addPattern(PATTERN_DEFAULT, CM_ONLINE_FBSOUKINMEISAI_3, "CM_ONLINE_FBSOUKINMEISAI_3", false);
        addPattern(PATTERN_DEFAULT, CM_ONLINE_FBSOUKINMEISAI_4, "CM_ONLINE_FBSOUKINMEISAI_4", false);
        addPattern(PATTERN_DEFAULT, CM_ONLINE_FBSOUKINMEISAI_5, "CM_ONLINE_FBSOUKINMEISAI_5", false);
        addPattern(PATTERN_DEFAULT, CM_ONLINE_GKFBSOUKINMEISAI_1, "CM_ONLINE_GKFBSOUKINMEISAI_1", false);
        addPattern(PATTERN_DEFAULT, CM_ONLINE_GKFBSOUKINMEISAI_2, "CM_ONLINE_GKFBSOUKINMEISAI_2", false);
        addPattern(PATTERN_DEFAULT, CM_ONLINE_GKFBSOUKINMEISAI_3, "CM_ONLINE_GKFBSOUKINMEISAI_3", false);
        addPattern(PATTERN_DEFAULT, CM_ONLINE_GKFBSOUKINMEISAI_4, "CM_ONLINE_GKFBSOUKINMEISAI_4", false);
        addPattern(PATTERN_DEFAULT, CM_ONLINE_GKFBSOUKINMEISAI_5, "CM_ONLINE_GKFBSOUKINMEISAI_5", false);
        addPattern(PATTERN_DEFAULT, CM_BATCH_FBFURIKOMIKEI_4, "CM_BATCH_FBFURIKOMIKEI_4", false);
        addPattern(PATTERN_DEFAULT, CM_BATCH_GKFBFURIKOMIKEI, "CM_BATCH_GKFBFURIKOMIKEI", false);
        addPattern(PATTERN_DEFAULT, CM_BATCH_FBSOUKINMEISAI_4, "CM_BATCH_FBSOUKINMEISAI_4", false);
        addPattern(PATTERN_DEFAULT, CM_BATCH_GKFBSOUKINMEISAI, "CM_BATCH_GKFBSOUKINMEISAI", false);
        addPattern(PATTERN_DEFAULT, CM_TIENRSKUTIWAKELIST, "CM_TIENRSKUTIWAKELIST", false);
        addPattern(PATTERN_DEFAULT, CM_SKHONSYADENPYOULIST, "CM_SKHONSYADENPYOULIST", false);
        addPattern(PATTERN_DEFAULT, CM_KARIUKEMEISAI_1, "CM_KARIUKEMEISAI_1", false);
        addPattern(PATTERN_DEFAULT, CM_KARIUKEMEISAI_2, "CM_KARIUKEMEISAI_2", false);
        addPattern(PATTERN_DEFAULT, CM_KARIUKEMEISAI_3, "CM_KARIUKEMEISAI_3", false);
        addPattern(PATTERN_DEFAULT, CM_KARIUKEMEISAI_4, "CM_KARIUKEMEISAI_4", false);
        addPattern(PATTERN_DEFAULT, CM_SIKINIDOULIST_SOKUJI, "CM_SIKINIDOULIST_SOKUJI", false);
        addPattern(PATTERN_DEFAULT, CM_SIKINIDOULIST_TYAKKINBI, "CM_SIKINIDOULIST_TYAKKINBI", false);
        addPattern(PATTERN_DEFAULT, CM_HURIKOMIERRINFOLIST, "CM_HURIKOMIERRINFOLIST", false);
        addPattern(PATTERN_DEFAULT, CM_GKHURIKOMIERRINFOLIST, "CM_GKHURIKOMIERRINFOLIST", false);
        addPattern(PATTERN_DEFAULT, CM_HOJYOBOLIST_1, "CM_HOJYOBOLIST_1", false);
        addPattern(PATTERN_DEFAULT, CM_HOJYOBOLIST_2, "CM_HOJYOBOLIST_2", false);
        addPattern(PATTERN_DEFAULT, CM_HOJYOBOLIST_3, "CM_HOJYOBOLIST_3", false);
        addPattern(PATTERN_DEFAULT, CM_HOJYOBOLIST_4, "CM_HOJYOBOLIST_4", false);
        addPattern(PATTERN_DEFAULT, CM_HOJYOBOLIST_5, "CM_HOJYOBOLIST_5", false);
        addPattern(PATTERN_DEFAULT, CM_HURIDEN, "CM_HURIDEN", false);
        addPattern(PATTERN_DEFAULT, CM_HURIDEN_HIKAE, "CM_HURIDEN_HIKAE", false);
        addPattern(PATTERN_DEFAULT, CM_SK_HURIDEN, "CM_SK_HURIDEN", false);
        addPattern(PATTERN_DEFAULT, CM_SK_HURIDEN_HIKAE, "CM_SK_HURIDEN_HIKAE", false);
        addPattern(PATTERN_DEFAULT, CM_RATEDBSYOUKAIKEKKA, "CM_RATEDBSYOUKAIKEKKA", false);
        addPattern(PATTERN_DEFAULT, BZ_JIGYOUHIKANJYOUKAKUSYOULIST_1, "BZ_JIGYOUHIKANJYOUKAKUSYOULIST_1", false);
        addPattern(PATTERN_DEFAULT, BZ_JIGYOUHIKANJYOUKAKUSYOULIST_2, "BZ_JIGYOUHIKANJYOUKAKUSYOULIST_2", false);
        addPattern(PATTERN_DEFAULT, CM_TUUSANKAWASERATEKAKUNIN, "CM_TUUSANKAWASERATEKAKUNIN", false);
        addPattern(PATTERN_DEFAULT, CM_HOJYOBOLIST_6, "CM_HOJYOBOLIST_6", false);
        addPattern(PATTERN_DEFAULT, CM_KARIUKEMEISAI_5, "CM_KARIUKEMEISAI_5", false);
        addPattern(PATTERN_DEFAULT, CM_ONLINE_FBSOUKINMEISAI_6, "CM_ONLINE_FBSOUKINMEISAI_6", false);
        addPattern(PATTERN_DEFAULT, CM_SIKINIDOULIST_YENDTHNK, "CM_SIKINIDOULIST_YENDTHNK", false);
        addPattern(PATTERN_DEFAULT, CM_BATCH_FBSOUKINMEISAI_7, "CM_BATCH_FBSOUKINMEISAI_7", false);
        addPattern(PATTERN_DEFAULT, CM_ONLINE_FBSOUKINMEISAI_7, "CM_ONLINE_FBSOUKINMEISAI_7", false);
        addPattern(PATTERN_DEFAULT, CM_MYNUMBERTYUUSYUTULIST, "CM_MYNUMBERTYUUSYUTULIST", false);
        addPattern(PATTERN_DEFAULT, CM_HOJYOBOLIST_7, "CM_HOJYOBOLIST_7", false);
        addPattern(PATTERN_DEFAULT, CM_KBTKARIKANJYOUZNDKSYUKILIST, "CM_KBTKARIKANJYOUZNDKSYUKILIST", false);
        addPattern(PATTERN_DEFAULT, CM_SIKINIDOULIST_HIJYNNYK, "CM_SIKINIDOULIST_HIJYNNYK", false);
        addPattern(PATTERN_DEFAULT, CM_BATCH_FBFURIKOMIKEI_2, "CM_BATCH_FBFURIKOMIKEI_2", false);
        addPattern(PATTERN_DEFAULT, CM_BATCH_FBSOUKINMEISAI_2, "CM_BATCH_FBSOUKINMEISAI_2", false);
        addPattern(PATTERN_DEFAULT, CM_SIKINIDOULIST_HTKIN, "CM_SIKINIDOULIST_HTKIN", false);
        addPattern(PATTERN_DEFAULT, CM_KARIUKEMEISAI_6, "CM_KARIUKEMEISAI_6", false);
        addPattern(PATTERN_DEFAULT, CM_BATCH_FBFURIKOMIKEI_3, "CM_BATCH_FBFURIKOMIKEI_3", false);
        addPattern(PATTERN_DEFAULT, CM_BATCH_FBSOUKINMEISAI_3, "CM_BATCH_FBSOUKINMEISAI_3", false);
        addPattern(PATTERN_DEFAULT, CM_HOJYOBOLIST, "CM_HOJYOBOLIST", false);
        addPattern(PATTERN_DEFAULT, DS_KARIPWTUUTITYUUDANLIST, "DS_KARIPWTUUTITYUUDANLIST", false);
        addPattern(PATTERN_DEFAULT, DS_KOUZOKUJIMUKAKUNINLIST, "DS_KOUZOKUJIMUKAKUNINLIST", false);
        addPattern(PATTERN_DEFAULT, HK_SHRMESS, "HK_SHRMESS", false);
        addPattern(PATTERN_DEFAULT, HK_SHMEISAI_SDS, "HK_SHMEISAI_SDS", false);
        addPattern(PATTERN_DEFAULT, HK_SB_HOKEN_SKS, "HK_SB_HOKEN_SKS", false);
        addPattern(PATTERN_DEFAULT, HK_SEISANKINHRKM_IRAIS, "HK_SEISANKINHRKM_IRAIS", false);
        addPattern(PATTERN_DEFAULT, HK_SB_DAIHYOU, "HK_SB_DAIHYOU", false);
        addPattern(PATTERN_DEFAULT, HK_KD_JIKOJKS, "HK_KD_JIKOJKS", false);
        addPattern(PATTERN_DEFAULT, HK_JIJYOUTODOKEKENSEIYAKUSYO, "HK_JIJYOUTODOKEKENSEIYAKUSYO", false);
        addPattern(PATTERN_DEFAULT, HK_TEISYUTUSYORUI, "HK_TEISYUTUSYORUI", false);
        addPattern(PATTERN_DEFAULT, HK_MYNUMBER_CHYOU, "HK_MYNUMBER_CHYOU", false);
        addPattern(PATTERN_DEFAULT, HK_SOUHU, "HK_SOUHU", false);
        addPattern(PATTERN_DEFAULT, HK_STI_KAS, "HK_STI_KAS", false);
        addPattern(PATTERN_DEFAULT, HK_SB_SONOTA_SDS, "HK_SB_SONOTA_SDS", false);
        addPattern(PATTERN_DEFAULT, HK_SB_KTJKSMS, "HK_SB_KTJKSMS", false);
        addPattern(PATTERN_DEFAULT, HK_SB_HKNSYKN, "HK_SB_HKNSYKN", false);
        addPattern(PATTERN_DEFAULT, HK_SB_KOSEKI, "HK_SB_KOSEKI", false);
        addPattern(PATTERN_DEFAULT, HK_SB_HONNINSR, "HK_SB_HONNINSR", false);
        addPattern(PATTERN_DEFAULT, HK_SB_JYUUMIN, "HK_SB_JYUUMIN", false);
        addPattern(PATTERN_DEFAULT, HK_SB_INKAN, "HK_SB_INKAN", false);
        addPattern(PATTERN_DEFAULT, HK_SB_KAKUNINDOUISYO, "HK_SB_KAKUNINDOUISYO", false);
        addPattern(PATTERN_DEFAULT, HK_SB_SKKANSYOUKNK, "HK_SB_SKKANSYOUKNK", false);
        addPattern(PATTERN_DEFAULT, HK_MYNUMBER_SYORUI, "HK_MYNUMBER_SYORUI", false);
        addPattern(PATTERN_DEFAULT, HK_SB_SONOTA_SKS, "HK_SB_SONOTA_SKS", false);
        addPattern(PATTERN_DEFAULT, HK_ENKASIHARAIRYUUIJIKOU, "HK_ENKASIHARAIRYUUIJIKOU", false);
        addPattern(PATTERN_DEFAULT, HK_SB_HUBITEISEI, "HK_SB_HUBITEISEI", false);
        addPattern(PATTERN_DEFAULT, HK_SB_HUBITEISEI2, "HK_SB_HUBITEISEI2", false);
        addPattern(PATTERN_DEFAULT, HK_HUBITEISEI_SOUHU, "HK_HUBITEISEI_SOUHU", false);
        addPattern(PATTERN_DEFAULT, HK_SB_HUBIKNK, "HK_SB_HUBIKNK", false);
        addPattern(PATTERN_DEFAULT, HK_SB_KAKUNINIRAIS, "HK_SB_KAKUNINIRAIS", false);
        addPattern(PATTERN_DEFAULT, HK_SB_KAKUNINHKS, "HK_SB_KAKUNINHKS", false);
        addPattern(PATTERN_DEFAULT, HK_BIKINSAGYOULIST, "HK_BIKINSAGYOULIST", false);
        addPattern(PATTERN_DEFAULT, HK_BIKINJIKOUKIST, "HK_BIKINJIKOUKIST", false);
        addPattern(PATTERN_DEFAULT, HK_BIKINJIKOUKIST_GOUKEI, "HK_BIKINJIKOUKIST_GOUKEI", false);
        addPattern(PATTERN_DEFAULT, HK_ZENNOUSEISANKINMEISAILIST, "HK_ZENNOUSEISANKINMEISAILIST", false);
        addPattern(PATTERN_DEFAULT, HK_JIKOUDENMEISAILIST, "HK_JIKOUDENMEISAILIST", false);
        addPattern(PATTERN_DEFAULT, HK_SB_SONOTA, "HK_SB_SONOTA", false);
        addPattern(PATTERN_DEFAULT, KK_ADRHNK_TTDKKR, "KK_ADRHNK_TTDKKR", false);
        addPattern(PATTERN_DEFAULT, KK_ADRHNK_GAIBU_TTDKKR, "KK_ADRHNK_GAIBU_TTDKKR", false);
        addPattern(PATTERN_DEFAULT, KK_MEIGIHNK_TTDKKR, "KK_MEIGIHNK_TTDKKR", false);
        addPattern(PATTERN_DEFAULT, KK_STDRHNK_TTDKKR, "KK_STDRHNK_TTDKKR", false);
        addPattern(PATTERN_DEFAULT, KK_SEINENGAPPISEI_TTDKKR, "KK_SEINENGAPPISEI_TTDKKR", false);
        addPattern(PATTERN_DEFAULT, KK_GENGAKU_TTDKKR, "KK_GENGAKU_TTDKKR", false);
        addPattern(PATTERN_DEFAULT, KK_NKTKYKHNK_TTDKKR, "KK_NKTKYKHNK_TTDKKR", false);
        addPattern(PATTERN_DEFAULT, KK_TARGETHNK_TTDKKR, "KK_TARGETHNK_TTDKKR", false);
        addPattern(PATTERN_DEFAULT, KK_TARGETHNK_GAIBU_TTDKKR, "KK_TARGETHNK_GAIBU_TTDKKR", false);
        addPattern(PATTERN_DEFAULT, KK_KAIYAKU_TTDKKR, "KK_KAIYAKU_TTDKKR", false);
        addPattern(PATTERN_DEFAULT, KK_KAIYAKU_GAIBU_TTDKKR, "KK_KAIYAKU_GAIBU_TTDKKR", false);
        addPattern(PATTERN_DEFAULT, KK_KAIYAKU_SAIKENSYA_TTDKKR, "KK_KAIYAKU_SAIKENSYA_TTDKKR", false);
        addPattern(PATTERN_DEFAULT, KK_SHRKZHNK_TTDKKR, "KK_SHRKZHNK_TTDKKR", false);
        addPattern(PATTERN_DEFAULT, KK_SYOSAIHK_TTDKKR, "KK_SYOSAIHK_TTDKKR", false);
        addPattern(PATTERN_DEFAULT, KK_KYKTRKS_KYKTRKSTTDKKR, "KK_KYKTRKS_KYKTRKSTTDKKR", false);
        addPattern(PATTERN_DEFAULT, KK_CLGOFF_KYKTRKSTTDKKR, "KK_CLGOFF_KYKTRKSTTDKKR", false);
        addPattern(PATTERN_DEFAULT, KK_KAIJYO_KYKTRKSTTDKKR, "KK_KAIJYO_KYKTRKSTTDKKR", false);
        addPattern(PATTERN_DEFAULT, KK_SBKAIJYO_KYKTRKSTTDKKR, "KK_SBKAIJYO_KYKTRKSTTDKKR", false);
        addPattern(PATTERN_DEFAULT, KK_SBMENSEKI_KYKTRKSTTDKKR, "KK_SBMENSEKI_KYKTRKSTTDKKR", false);
        addPattern(PATTERN_DEFAULT, KK_KAIGOMAETKHNK_TTDKKR, "KK_KAIGOMAETKHNK_TTDKKR", false);
        addPattern(PATTERN_DEFAULT, KK_SBMUKOU_KYKTRKSTTDKKR, "KK_SBMUKOU_KYKTRKSTTDKKR", false);
        addPattern(PATTERN_DEFAULT, KK_MOUSIDEMUKOU_KYKTRKSTTDKKR, "KK_MOUSIDEMUKOU_KYKTRKSTTDKKR", false);
        addPattern(PATTERN_DEFAULT, KK_HRIHEN_TTDKKR, "KK_HRIHEN_TTDKKR", false);
        addPattern(PATTERN_DEFAULT, KK_HUKKATU_TTDKKR, "KK_HUKKATU_TTDKKR", false);
        addPattern(PATTERN_DEFAULT, KK_HUKKATU_OKOTOWARI, "KK_HUKKATU_OKOTOWARI", false);
        addPattern(PATTERN_DEFAULT, KK_MKHGKHNK_TTDKKR, "KK_MKHGKHNK_TTDKKR", false);
        addPattern(PATTERN_DEFAULT, KK_YENDTHNKHNRKN_TTDKKR, "KK_YENDTHNKHNRKN_TTDKKR", false);
        addPattern(PATTERN_DEFAULT, KK_TUMITATEKINITEN_TTDKKR, "KK_TUMITATEKINITEN_TTDKKR", false);
        addPattern(PATTERN_DEFAULT, KK_YENDTHNK_HNRKNSKS_TTDKKR, "KK_YENDTHNK_HNRKNSKS_TTDKKR", false);
        addPattern(PATTERN_DEFAULT, KK_YENDTHNK_TTDKKR, "KK_YENDTHNK_TTDKKR", false);
        addPattern(PATTERN_DEFAULT, KK_DSHR_TTDKKR, "KK_DSHR_TTDKKR", false);
        addPattern(PATTERN_DEFAULT, KK_GENGAKU_ZEITEKI_TTDKKR, "KK_GENGAKU_ZEITEKI_TTDKKR", false);
        addPattern(PATTERN_DEFAULT, KK_YENDTHNK_NINI_TTDKKR, "KK_YENDTHNK_NINI_TTDKKR", false);
        addPattern(PATTERN_DEFAULT, KK_SYOUMETU_GAIBU_TTDKKR, "KK_SYOUMETU_GAIBU_TTDKKR", false);
        addPattern(PATTERN_DEFAULT, KK_YENDTHNK_TTDKKR_2, "KK_YENDTHNK_TTDKKR_2", false);
        addPattern(PATTERN_DEFAULT, KK_DTUIBARAI_TTDKKR, "KK_DTUIBARAI_TTDKKR", false);
        addPattern(PATTERN_DEFAULT, KK_DTUIBARAI_TTDKKR_ZEIMUNASI, "KK_DTUIBARAI_TTDKKR_ZEIMUNASI", false);
        addPattern(PATTERN_DEFAULT, KK_KZKTRKKYKDRHNK_TTDKKR, "KK_KZKTRKKYKDRHNK_TTDKKR", false);
        addPattern(PATTERN_DEFAULT, KK_KZKTRKTYOKUSOU_TTDKKR, "KK_KZKTRKTYOKUSOU_TTDKKR", false);
        addPattern(PATTERN_DEFAULT, KK_KZKTRKSKEI_TTDKKR, "KK_KZKTRKSKEI_TTDKKR", false);
        addPattern(PATTERN_DEFAULT, KK_YENDTHNK_NINI_TTDKKR_2, "KK_YENDTHNK_NINI_TTDKKR_2", false);
        addPattern(PATTERN_DEFAULT, KK_YENDTHNK_TTDKKR_3, "KK_YENDTHNK_TTDKKR_3", false);
        addPattern(PATTERN_DEFAULT, KK_SEINENGAPPISEI_TTDKKR_SHRARI, "KK_SEINENGAPPISEI_TTDKKR_SHRARI", false);
        addPattern(PATTERN_DEFAULT, KK_ADRHNK_SKS, "KK_ADRHNK_SKS", false);
        addPattern(PATTERN_DEFAULT, KK_MEIGIHNK_SKS, "KK_MEIGIHNK_SKS", false);
        addPattern(PATTERN_DEFAULT, KK_STDRHNK_SKS, "KK_STDRHNK_SKS", false);
        addPattern(PATTERN_DEFAULT, KK_SEINENGAPPISEI_SKS, "KK_SEINENGAPPISEI_SKS", false);
        addPattern(PATTERN_DEFAULT, KK_GENGAKU_SKS, "KK_GENGAKU_SKS", false);
        addPattern(PATTERN_DEFAULT, KK_NKTKYKHNK_SKS, "KK_NKTKYKHNK_SKS", false);
        addPattern(PATTERN_DEFAULT, KK_TARGETHNK_SKS, "KK_TARGETHNK_SKS", false);
        addPattern(PATTERN_DEFAULT, KK_KAIYAKU_SKS, "KK_KAIYAKU_SKS", false);
        addPattern(PATTERN_DEFAULT, KK_SHRKZHNK_SKS, "KK_SHRKZHNK_SKS", false);
        addPattern(PATTERN_DEFAULT, KK_SYOSAIHK_SKS, "KK_SYOSAIHK_SKS", false);
        addPattern(PATTERN_DEFAULT, KK_KAIGOMAETKHNK_SKS, "KK_KAIGOMAETKHNK_SKS", false);
        addPattern(PATTERN_DEFAULT, KK_KAIJYO_SKS, "KK_KAIJYO_SKS", false);
        addPattern(PATTERN_DEFAULT, KK_SBKAIJYO_SKS, "KK_SBKAIJYO_SKS", false);
        addPattern(PATTERN_DEFAULT, KK_SBMENSEKI_SKS, "KK_SBMENSEKI_SKS", false);
        addPattern(PATTERN_DEFAULT, KK_HRIHEN_SKS, "KK_HRIHEN_SKS", false);
        addPattern(PATTERN_DEFAULT, KK_HRIKAIHEN_SKS, "KK_HRIKAIHEN_SKS", false);
        addPattern(PATTERN_DEFAULT, KK_HUKKATU_SKS, "KK_HUKKATU_SKS", false);
        addPattern(PATTERN_DEFAULT, KK_MOUSIDEMUKOU_SKS, "KK_MOUSIDEMUKOU_SKS", false);
        addPattern(PATTERN_DEFAULT, KK_GANMUKOU_SKS, "KK_GANMUKOU_SKS", false);
        addPattern(PATTERN_DEFAULT, KK_MKHGKHNK_SKS, "KK_MKHGKHNK_SKS", false);
        addPattern(PATTERN_DEFAULT, KK_YENDTHNKHNRKN_SKS, "KK_YENDTHNKHNRKN_SKS", false);
        addPattern(PATTERN_DEFAULT, KK_TUMITATEKINITEN_SKS, "KK_TUMITATEKINITEN_SKS", false);
        addPattern(PATTERN_DEFAULT, KK_DSHR_SKS, "KK_DSHR_SKS", false);
        addPattern(PATTERN_DEFAULT, KK_YENDTHNK_SKS, "KK_YENDTHNK_SKS", false);
        addPattern(PATTERN_DEFAULT, KK_KZKTRKKYKDRTKYKHNK_SKS, "KK_KZKTRKKYKDRTKYKHNK_SKS", false);
        addPattern(PATTERN_DEFAULT, KK_ADRHNK_SOUHU, "KK_ADRHNK_SOUHU", false);
        addPattern(PATTERN_DEFAULT, KK_MEIGIHNK_SOUHU, "KK_MEIGIHNK_SOUHU", false);
        addPattern(PATTERN_DEFAULT, KK_STDRHNK_SOUHU, "KK_STDRHNK_SOUHU", false);
        addPattern(PATTERN_DEFAULT, KK_SEINENGAPPISEI_SOUHU, "KK_SEINENGAPPISEI_SOUHU", false);
        addPattern(PATTERN_DEFAULT, KK_GENGAKU_SOUHU, "KK_GENGAKU_SOUHU", false);
        addPattern(PATTERN_DEFAULT, KK_NKTKYKHNK_SOUHU, "KK_NKTKYKHNK_SOUHU", false);
        addPattern(PATTERN_DEFAULT, KK_TARGETHNK_SOUHU, "KK_TARGETHNK_SOUHU", false);
        addPattern(PATTERN_DEFAULT, KK_KAIYAKU_SKSSOUHU, "KK_KAIYAKU_SKSSOUHU", false);
        addPattern(PATTERN_DEFAULT, KK_SHRKZHNK_SOUHU, "KK_SHRKZHNK_SOUHU", false);
        addPattern(PATTERN_DEFAULT, KK_SYOSAIHK_SOUHU, "KK_SYOSAIHK_SOUHU", false);
        addPattern(PATTERN_DEFAULT, KK_KAIGOMAETKHNK_SOUHU, "KK_KAIGOMAETKHNK_SOUHU", false);
        addPattern(PATTERN_DEFAULT, KK_SBMENSEKI_SOUHU, "KK_SBMENSEKI_SOUHU", false);
        addPattern(PATTERN_DEFAULT, KK_HRIHEN_SOUHU, "KK_HRIHEN_SOUHU", false);
        addPattern(PATTERN_DEFAULT, KK_HUKKATU_SOUHU, "KK_HUKKATU_SOUHU", false);
        addPattern(PATTERN_DEFAULT, KK_MOUSIDEMUKOU_SOUHU, "KK_MOUSIDEMUKOU_SOUHU", false);
        addPattern(PATTERN_DEFAULT, KK_GANMUKOU_SOUHU, "KK_GANMUKOU_SOUHU", false);
        addPattern(PATTERN_DEFAULT, KK_MKHGKHNK_SOUHU, "KK_MKHGKHNK_SOUHU", false);
        addPattern(PATTERN_DEFAULT, KK_YENDTHNKHNRKN_SOUHU, "KK_YENDTHNKHNRKN_SOUHU", false);
        addPattern(PATTERN_DEFAULT, KK_TUMITATEKINITEN_SOUHU, "KK_TUMITATEKINITEN_SOUHU", false);
        addPattern(PATTERN_DEFAULT, KK_DSHR_SOUHU, "KK_DSHR_SOUHU", false);
        addPattern(PATTERN_DEFAULT, KK_YENDTHNK_SOUHU, "KK_YENDTHNK_SOUHU", false);
        addPattern(PATTERN_DEFAULT, KK_KZKTRKKYKDRTKYKHNK_SOUHU, "KK_KZKTRKKYKDRTKYKHNK_SOUHU", false);
        addPattern(PATTERN_DEFAULT, KK_HUBITEISEISYO_SOUHU, "KK_HUBITEISEISYO_SOUHU", false);
        addPattern(PATTERN_DEFAULT, KK_ADRHNK_HB, "KK_ADRHNK_HB", false);
        addPattern(PATTERN_DEFAULT, KK_MEIGIHNK_HB, "KK_MEIGIHNK_HB", false);
        addPattern(PATTERN_DEFAULT, KK_STDRHNK_HB, "KK_STDRHNK_HB", false);
        addPattern(PATTERN_DEFAULT, KK_SEINENGAPPISEI_HB, "KK_SEINENGAPPISEI_HB", false);
        addPattern(PATTERN_DEFAULT, KK_GENGAKU_HB, "KK_GENGAKU_HB", false);
        addPattern(PATTERN_DEFAULT, KK_NKTKYKHNK_HB, "KK_NKTKYKHNK_HB", false);
        addPattern(PATTERN_DEFAULT, KK_TARGETHNK_HB, "KK_TARGETHNK_HB", false);
        addPattern(PATTERN_DEFAULT, KK_KAIYAKU_HB, "KK_KAIYAKU_HB", false);
        addPattern(PATTERN_DEFAULT, KK_SHRKZHNK_HB, "KK_SHRKZHNK_HB", false);
        addPattern(PATTERN_DEFAULT, KK_SYOSAIHK_HB, "KK_SYOSAIHK_HB", false);
        addPattern(PATTERN_DEFAULT, KK_KYKTORIKESI_HB, "KK_KYKTORIKESI_HB", false);
        addPattern(PATTERN_DEFAULT, KK_CLGOFF_HB, "KK_CLGOFF_HB", false);
        addPattern(PATTERN_DEFAULT, KK_KAIJYO_HB, "KK_KAIJYO_HB", false);
        addPattern(PATTERN_DEFAULT, KK_MUKOU_HB, "KK_MUKOU_HB", false);
        addPattern(PATTERN_DEFAULT, KK_SBKAIJYO_HB, "KK_SBKAIJYO_HB", false);
        addPattern(PATTERN_DEFAULT, KK_SBMENSEKI_HB, "KK_SBMENSEKI_HB", false);
        addPattern(PATTERN_DEFAULT, KK_KAIGOMAETKHNK_HB, "KK_KAIGOMAETKHNK_HB", false);
        addPattern(PATTERN_DEFAULT, KK_SBMUKOU_HB, "KK_SBMUKOU_HB", false);
        addPattern(PATTERN_DEFAULT, KK_SBMUKOUNOSHR_HB, "KK_SBMUKOUNOSHR_HB", false);
        addPattern(PATTERN_DEFAULT, KK_SBMENSEKINOSHR_HB, "KK_SBMENSEKINOSHR_HB", false);
        addPattern(PATTERN_DEFAULT, KK_HUBI_KARISAKUSEI, "KK_HUBI_KARISAKUSEI", false);
        addPattern(PATTERN_DEFAULT, KK_MKHGKHNK_HB, "KK_MKHGKHNK_HB", false);
        addPattern(PATTERN_DEFAULT, KK_YENDTHNKHNRKN_HB, "KK_YENDTHNKHNRKN_HB", false);
        addPattern(PATTERN_DEFAULT, KK_TUMITATEKINITEN_HB, "KK_TUMITATEKINITEN_HB", false);
        addPattern(PATTERN_DEFAULT, KK_DSHR_HB, "KK_DSHR_HB", false);
        addPattern(PATTERN_DEFAULT, KK_YENDTHNK_NINI_HB, "KK_YENDTHNK_NINI_HB", false);
        addPattern(PATTERN_DEFAULT, KK_KZKTRK_KYKDRTKYKHNK_HB, "KK_KZKTRK_KYKDRTKYKHNK_HB", false);
        addPattern(PATTERN_DEFAULT, KK_ADRHNK_HBLIST, "KK_ADRHNK_HBLIST", false);
        addPattern(PATTERN_DEFAULT, KK_MEIGIHNK_HBLIST, "KK_MEIGIHNK_HBLIST", false);
        addPattern(PATTERN_DEFAULT, KK_STDRHNK_HBLIST, "KK_STDRHNK_HBLIST", false);
        addPattern(PATTERN_DEFAULT, KK_SEINENGAPPISEI_HBLIST, "KK_SEINENGAPPISEI_HBLIST", false);
        addPattern(PATTERN_DEFAULT, KK_GENGAKU_HBLIST, "KK_GENGAKU_HBLIST", false);
        addPattern(PATTERN_DEFAULT, KK_NKTKYKHNK_HBLIST, "KK_NKTKYKHNK_HBLIST", false);
        addPattern(PATTERN_DEFAULT, KK_TARGETHNK_HBLIST, "KK_TARGETHNK_HBLIST", false);
        addPattern(PATTERN_DEFAULT, KK_KAIYAKU_HBLIST, "KK_KAIYAKU_HBLIST", false);
        addPattern(PATTERN_DEFAULT, KK_SHRKZHNK_HBLIST, "KK_SHRKZHNK_HBLIST", false);
        addPattern(PATTERN_DEFAULT, KK_SYOSAIHK_HBLIST, "KK_SYOSAIHK_HBLIST", false);
        addPattern(PATTERN_DEFAULT, KK_KYKTORIKESI_HBLIST, "KK_KYKTORIKESI_HBLIST", false);
        addPattern(PATTERN_DEFAULT, KK_CLGOFF_HBLIST, "KK_CLGOFF_HBLIST", false);
        addPattern(PATTERN_DEFAULT, KK_KAIJYO_HBLIST, "KK_KAIJYO_HBLIST", false);
        addPattern(PATTERN_DEFAULT, KK_MUKOU_HBLIST, "KK_MUKOU_HBLIST", false);
        addPattern(PATTERN_DEFAULT, KK_SBKAIJYO_HBLIST, "KK_SBKAIJYO_HBLIST", false);
        addPattern(PATTERN_DEFAULT, KK_SBMENSEKI_HBLIST, "KK_SBMENSEKI_HBLIST", false);
        addPattern(PATTERN_DEFAULT, KK_KAIGOMAETKHNK_HBLIST, "KK_KAIGOMAETKHNK_HBLIST", false);
        addPattern(PATTERN_DEFAULT, KK_SBMUKOU_HBLIST, "KK_SBMUKOU_HBLIST", false);
        addPattern(PATTERN_DEFAULT, KK_SBMUKOUNOSHR_HBLIST, "KK_SBMUKOUNOSHR_HBLIST", false);
        addPattern(PATTERN_DEFAULT, KK_SBMENSEKINOSHR_HBLIST, "KK_SBMENSEKINOSHR_HBLIST", false);
        addPattern(PATTERN_DEFAULT, KK_MKHGKHNK_HBLIST, "KK_MKHGKHNK_HBLIST", false);
        addPattern(PATTERN_DEFAULT, KK_YENDTHNKHNRKN_HBLIST, "KK_YENDTHNKHNRKN_HBLIST", false);
        addPattern(PATTERN_DEFAULT, KK_TUMITATEKINITEN_HBLIST, "KK_TUMITATEKINITEN_HBLIST", false);
        addPattern(PATTERN_DEFAULT, KK_DSHR_HBLIST, "KK_DSHR_HBLIST", false);
        addPattern(PATTERN_DEFAULT, KK_YENDTHNK_NINI_HBLIST, "KK_YENDTHNK_NINI_HBLIST", false);
        addPattern(PATTERN_DEFAULT, KK_KZKTRK_KYKDRTKYKHNK_HBLIST, "KK_KZKTRK_KYKDRTKYKHNK_HBLIST", false);
        addPattern(PATTERN_DEFAULT, KK_NKTKYKHNK_GAIYOU, "KK_NKTKYKHNK_GAIYOU", false);
        addPattern(PATTERN_DEFAULT, KK_KAIGOMAETK_KYKGAIYOU, "KK_KAIGOMAETK_KYKGAIYOU", false);
        addPattern(PATTERN_DEFAULT, KK_KAIGOMAETK_TYUUIKANKI, "KK_KAIGOMAETK_TYUUIKANKI", false);
        addPattern(PATTERN_DEFAULT, KK_MYNUMBER_SYORUI_GENGAKU, "KK_MYNUMBER_SYORUI_GENGAKU", false);
        addPattern(PATTERN_DEFAULT, KK_MYNUMBER_SYORUI_KAIYAKU, "KK_MYNUMBER_SYORUI_KAIYAKU", false);
        addPattern(PATTERN_DEFAULT, KK_MYNUMBER_SYORUI_YENDTHNKHNRKN, "KK_MYNUMBER_SYORUI_YENDTHNKHNRKN", false);
        addPattern(PATTERN_DEFAULT, KK_MEIGIHNK_DAIHYOUSN, "KK_MEIGIHNK_DAIHYOUSN", false);
        addPattern(PATTERN_DEFAULT, KK_KAIYAKU_DAIHYOUSN, "KK_KAIYAKU_DAIHYOUSN", false);
        addPattern(PATTERN_DEFAULT, KK_YENDTHNKHNRKN_DAIHYOUSN, "KK_YENDTHNKHNRKN_DAIHYOUSN", false);
        addPattern(PATTERN_DEFAULT, KK_MEIGIHNK_TORIHIKIKAK, "KK_MEIGIHNK_TORIHIKIKAK", false);
        addPattern(PATTERN_DEFAULT, KK_KAIYAKU_TORIHIKIKAK, "KK_KAIYAKU_TORIHIKIKAK", false);
        addPattern(PATTERN_DEFAULT, KK_SOUHUANNAI, "KK_SOUHUANNAI", false);
        addPattern(PATTERN_DEFAULT, KK_SHIHARAI_SOUHU, "KK_SHIHARAI_SOUHU", false);
        addPattern(PATTERN_DEFAULT, KK_KYKNAIYOUOSIRASE1, "KK_KYKNAIYOUOSIRASE1", false);
        addPattern(PATTERN_DEFAULT, KK_KYKNAIYOUOSIRASE2, "KK_KYKNAIYOUOSIRASE2", false);
        addPattern(PATTERN_DEFAULT, KK_KYKNAIYOUOSIRASE3, "KK_KYKNAIYOUOSIRASE3", false);
        addPattern(PATTERN_DEFAULT, KK_KYKNAIYOUOSIRASE4, "KK_KYKNAIYOUOSIRASE4", false);
        addPattern(PATTERN_DEFAULT, KK_KYKNAIYOUOSIRASE5, "KK_KYKNAIYOUOSIRASE5", false);
        addPattern(PATTERN_DEFAULT, KK_KYKNAIYOUOSIRASE6, "KK_KYKNAIYOUOSIRASE6", false);
        addPattern(PATTERN_DEFAULT, KK_KYKNAIYOUOSIRASE7, "KK_KYKNAIYOUOSIRASE7", false);
        addPattern(PATTERN_DEFAULT, KK_HKNSYKN, "KK_HKNSYKN", false);
        addPattern(PATTERN_DEFAULT, KK_HKNSYKNITIJI, "KK_HKNSYKNITIJI", false);
        addPattern(PATTERN_DEFAULT, KK_SKSYOUKEN, "KK_SKSYOUKEN", false);
        addPattern(PATTERN_DEFAULT, KK_SAISYOUKEN, "KK_SAISYOUKEN", false);
        addPattern(PATTERN_DEFAULT, KK_SUIIHYOU, "KK_SUIIHYOU", false);
        addPattern(PATTERN_DEFAULT, KK_GAIKA_KOKYAKUTUUTI, "KK_GAIKA_KOKYAKUTUUTI", false);
        addPattern(PATTERN_DEFAULT, KK_SEISANDHANEITUUTI, "KK_SEISANDHANEITUUTI", false);
        addPattern(PATTERN_DEFAULT, KK_KOUJYOSYOUMEIS, "KK_KOUJYOSYOUMEIS", false);
        addPattern(PATTERN_DEFAULT, KK_KOUJYOSYOUMEIS_GAIBU, "KK_KOUJYOSYOUMEIS_GAIBU", false);
        addPattern(PATTERN_DEFAULT, KK_KOUJYOSYOUMEIS_SG, "KK_KOUJYOSYOUMEIS_SG", false);
        addPattern(PATTERN_DEFAULT, KK_SINNINTOUHYOU, "KK_SINNINTOUHYOU", false);
        addPattern(PATTERN_DEFAULT, KK_SYAINMEIBO, "KK_SYAINMEIBO", false);
        addPattern(PATTERN_DEFAULT, KK_GENKYOUTUUTI, "KK_GENKYOUTUUTI", false);
        addPattern(PATTERN_DEFAULT, KK_JIGYOUNENDOMATU, "KK_JIGYOUNENDOMATU", false);
        addPattern(PATTERN_DEFAULT, KK_SOUGOUTUUTI, "KK_SOUGOUTUUTI", false);
        addPattern(PATTERN_DEFAULT, KK_ANSINDAYORI, "KK_ANSINDAYORI", false);
        addPattern(PATTERN_DEFAULT, KK_KOUHURIMINYUUTUUTI, "KK_KOUHURIMINYUUTUUTI", false);
        addPattern(PATTERN_DEFAULT, KK_1PNYKNKANSYOUTUUTI, "KK_1PNYKNKANSYOUTUUTI", false);
        addPattern(PATTERN_DEFAULT, KK_MUKOUTUUTI, "KK_MUKOUTUUTI", false);
        addPattern(PATTERN_DEFAULT, KK_SIKKOUTUUTI, "KK_SIKKOUTUUTI", false);
        addPattern(PATTERN_DEFAULT, KK_JIMURENRAKU, "KK_JIMURENRAKU", false);
        addPattern(PATTERN_DEFAULT, KK_JIMURENRAKU_GENGAKU, "KK_JIMURENRAKU_GENGAKU", false);
        addPattern(PATTERN_DEFAULT, KK_JIMURENRAKU_SEINENGAPPISEITEISEI, "KK_JIMURENRAKU_SEINENGAPPISEITEISEI", false);
        addPattern(PATTERN_DEFAULT, KK_JIMURENRAKU_KYKTORIKESI, "KK_JIMURENRAKU_KYKTORIKESI", false);
        addPattern(PATTERN_DEFAULT, KK_JIMURENRAKU_MEIGIHNK, "KK_JIMURENRAKU_MEIGIHNK", false);
        addPattern(PATTERN_DEFAULT, KK_JIMURENRAKU_TETUDUKITYUUI, "KK_JIMURENRAKU_TETUDUKITYUUI", false);
        addPattern(PATTERN_DEFAULT, KK_SYOUKENMS_SKEI, "KK_SYOUKENMS_SKEI", false);
        addPattern(PATTERN_DEFAULT, KK_SYOUKENMS_SAI, "KK_SYOUKENMS_SAI", false);
        addPattern(PATTERN_DEFAULT, KK_SYOUKENTOKUSYU_SKEI, "KK_SYOUKENTOKUSYU_SKEI", false);
        addPattern(PATTERN_DEFAULT, KK_SYOUKENTOKUSYU_SAI, "KK_SYOUKENTOKUSYU_SAI", false);
        addPattern(PATTERN_DEFAULT, KK_INSIZEILIST_SKEI, "KK_INSIZEILIST_SKEI", false);
        addPattern(PATTERN_DEFAULT, KK_INSIZEILIST_SAI, "KK_INSIZEILIST_SAI", false);
        addPattern(PATTERN_DEFAULT, KK_TRKKZKKNRTUUTISAGYOULIST, "KK_TRKKZKKNRTUUTISAGYOULIST", false);
        addPattern(PATTERN_DEFAULT, KK_GENSENLIST, "KK_GENSENLIST", false);
        addPattern(PATTERN_DEFAULT, KK_TYOUSYOLIST_UK_KAIJYO, "KK_TYOUSYOLIST_UK_KAIJYO", false);
        addPattern(PATTERN_DEFAULT, KK_TYOUSYOLIST_UK_MENSEKI, "KK_TYOUSYOLIST_UK_MENSEKI", false);
        addPattern(PATTERN_DEFAULT, KK_TYOUSYOLIST_ITJ_KAIYAKU, "KK_TYOUSYOLIST_ITJ_KAIYAKU", false);
        addPattern(PATTERN_DEFAULT, KK_KAIYAKU_BIKINSAGYOULIST, "KK_KAIYAKU_BIKINSAGYOULIST", false);
        addPattern(PATTERN_DEFAULT, KK_KAIYAKU_BIKINJIKOUKIST, "KK_KAIYAKU_BIKINJIKOUKIST", false);
        addPattern(PATTERN_DEFAULT, KK_KH_BIKINLIST, "KK_KH_BIKINLIST", false);
        addPattern(PATTERN_DEFAULT, KK_YENDTHNK_BIKINLIST, "KK_YENDTHNK_BIKINLIST", false);
        addPattern(PATTERN_DEFAULT, KK_ZENNOUSEISANKINMEISAILIST_GENGAKU, "KK_ZENNOUSEISANKINMEISAILIST_GENGAKU", false);
        addPattern(PATTERN_DEFAULT, KK_ZENNOUSEISANKINMEISAILIST_KAIYAKU, "KK_ZENNOUSEISANKINMEISAILIST_KAIYAKU", false);
        addPattern(PATTERN_DEFAULT, KK_MKKPHENKINLIST_GENGAKU, "KK_MKKPHENKINLIST_GENGAKU", false);
        addPattern(PATTERN_DEFAULT, KK_MKKPHENKINLIST_KAIYAKU, "KK_MKKPHENKINLIST_KAIYAKU", false);
        addPattern(PATTERN_DEFAULT, KK_AZUKARIKINLIST, "KK_AZUKARIKINLIST", false);
        addPattern(PATTERN_DEFAULT, KK_AZUKARIKIN_BIKINLIST, "KK_AZUKARIKIN_BIKINLIST", false);
        addPattern(PATTERN_DEFAULT, KK_SYOURAIW_SISANHYOU, "KK_SYOURAIW_SISANHYOU", false);
        addPattern(PATTERN_DEFAULT, KK_HNGKUNEIHIKAKLIST, "KK_HNGKUNEIHIKAKLIST", false);
        addPattern(PATTERN_DEFAULT, KK_KACHECK_YOHURI_MISSLIST, "KK_KACHECK_YOHURI_MISSLIST", false);
        addPattern(PATTERN_DEFAULT, KK_KACHECK_SHRKZ_MISSLIST, "KK_KACHECK_SHRKZ_MISSLIST", false);
        addPattern(PATTERN_DEFAULT, KK_KYKINFOTORIKOMI_MISSLIST, "KK_KYKINFOTORIKOMI_MISSLIST", false);
        addPattern(PATTERN_DEFAULT, KK_SHRKEKKATORIKOMI_MISSLIST, "KK_SHRKEKKATORIKOMI_MISSLIST", false);
        addPattern(PATTERN_DEFAULT, KK_KZHURIANNAISEL_MISSLIST, "KK_KZHURIANNAISEL_MISSLIST", false);
        addPattern(PATTERN_DEFAULT, KK_YUUKOUKEKKAHANEI_MISSLIST, "KK_YUUKOUKEKKAHANEI_MISSLIST", false);
        addPattern(PATTERN_DEFAULT, KK_AUTHORIKEKKAHANEI_MISSLIST, "KK_AUTHORIKEKKAHANEI_MISSLIST", false);
        addPattern(PATTERN_DEFAULT, KK_URIAGEKEKKATRSKS_MISSLIST, "KK_URIAGEKEKKATRSKS_MISSLIST", false);
        addPattern(PATTERN_DEFAULT, KK_NYUUKIN_MISSLIST, "KK_NYUUKIN_MISSLIST", false);
        addPattern(PATTERN_DEFAULT, KK_LINC_MISSLIST, "KK_LINC_MISSLIST", false);
        addPattern(PATTERN_DEFAULT, KK_MINYUUITIRAN, "KK_MINYUUITIRAN", false);
        addPattern(PATTERN_DEFAULT, KK_SIKKOUITIRAN, "KK_SIKKOUITIRAN", false);
        addPattern(PATTERN_DEFAULT, KK_HANDKARIKANJYOU, "KK_HANDKARIKANJYOU", false);
        addPattern(PATTERN_DEFAULT, KK_DHANEI_MISSLIST, "KK_DHANEI_MISSLIST", false);
        addPattern(PATTERN_DEFAULT, KK_BATCHKAIYAKU_MISSLIST, "KK_BATCHKAIYAKU_MISSLIST", false);
        addPattern(PATTERN_DEFAULT, KK_YENDTHNK_MISSLIST, "KK_YENDTHNK_MISSLIST", false);
        addPattern(PATTERN_DEFAULT, KK_YENDTHNKSEL_MISSLIST, "KK_YENDTHNKSEL_MISSLIST", false);
        addPattern(PATTERN_DEFAULT, KK_SEISANDHANEI_MISSLIST, "KK_SEISANDHANEI_MISSLIST", false);
        addPattern(PATTERN_DEFAULT, KK_DSEISAN_MISSLIST, "KK_DSEISAN_MISSLIST", false);
        addPattern(PATTERN_DEFAULT, KK_SISUURENDOTMTTKNHANEI_MISSLIST, "KK_SISUURENDOTMTTKNHANEI_MISSLIST", false);
        addPattern(PATTERN_DEFAULT, KK_GAIKAKOKYAKUTUUTISKS_MISSLIST, "KK_GAIKAKOKYAKUTUUTISKS_MISSLIST", false);
        addPattern(PATTERN_DEFAULT, KK_BATCHMKHGKHENKOU_MISSLIST, "KK_BATCHMKHGKHENKOU_MISSLIST", false);
        addPattern(PATTERN_DEFAULT, KK_SEIKYUKNK_SYOSAIHK, "KK_SEIKYUKNK_SYOSAIHK", false);
        addPattern(PATTERN_DEFAULT, KK_HUBIKNK_SYOSAIHK, "KK_HUBIKNK_SYOSAIHK", false);
        addPattern(PATTERN_DEFAULT, KK_SEIKYUKNK_MEIGIHNK, "KK_SEIKYUKNK_MEIGIHNK", false);
        addPattern(PATTERN_DEFAULT, KK_HUBIKNK_MEIGIHNK, "KK_HUBIKNK_MEIGIHNK", false);
        addPattern(PATTERN_DEFAULT, KK_SEIKYUKNK_SEINENGAPPISEI, "KK_SEIKYUKNK_SEINENGAPPISEI", false);
        addPattern(PATTERN_DEFAULT, KK_HUBIKNK_SEINENGAPPISEI, "KK_HUBIKNK_SEINENGAPPISEI", false);
        addPattern(PATTERN_DEFAULT, KK_SEIKYUKNK_GENGAKU, "KK_SEIKYUKNK_GENGAKU", false);
        addPattern(PATTERN_DEFAULT, KK_HUBIKNK_GENGAKU, "KK_HUBIKNK_GENGAKU", false);
        addPattern(PATTERN_DEFAULT, KK_SEIKYUKNK_KAIYAKU, "KK_SEIKYUKNK_KAIYAKU", false);
        addPattern(PATTERN_DEFAULT, KK_HUBIKNK_KAIYAKU, "KK_HUBIKNK_KAIYAKU", false);
        addPattern(PATTERN_DEFAULT, KK_TODOKEDEKNK_ADRHNK, "KK_TODOKEDEKNK_ADRHNK", false);
        addPattern(PATTERN_DEFAULT, KK_HUBIKNK_ADRHNK, "KK_HUBIKNK_ADRHNK", false);
        addPattern(PATTERN_DEFAULT, KK_SEIKYUKNK_STDRSKYTKYK, "KK_SEIKYUKNK_STDRSKYTKYK", false);
        addPattern(PATTERN_DEFAULT, KK_HUBIKNK_STDRSKYTKYK, "KK_HUBIKNK_STDRSKYTKYK", false);
        addPattern(PATTERN_DEFAULT, KK_SEIKYUKNK_KAIGOMAETKHNK, "KK_SEIKYUKNK_KAIGOMAETKHNK", false);
        addPattern(PATTERN_DEFAULT, KK_HUBIKNK_KAIGOMAETKHNK, "KK_HUBIKNK_KAIGOMAETKHNK", false);
        addPattern(PATTERN_DEFAULT, KK_SEIKYUKNK_MKHGKHNK, "KK_SEIKYUKNK_MKHGKHNK", false);
        addPattern(PATTERN_DEFAULT, KK_HUBIKNK_MKHGKHNK, "KK_HUBIKNK_MKHGKHNK", false);
        addPattern(PATTERN_DEFAULT, KK_SEIKYUKNK_YENDTHNKHNRKN, "KK_SEIKYUKNK_YENDTHNKHNRKN", false);
        addPattern(PATTERN_DEFAULT, KK_HUBIKNK_YENDTHNKHNRKN, "KK_HUBIKNK_YENDTHNKHNRKN", false);
        addPattern(PATTERN_DEFAULT, KK_SEIKYUKNK_TUMITATEKINITEN, "KK_SEIKYUKNK_TUMITATEKINITEN", false);
        addPattern(PATTERN_DEFAULT, KK_HUBIKNK_TUMITATEKINITEN, "KK_HUBIKNK_TUMITATEKINITEN", false);
        addPattern(PATTERN_DEFAULT, KK_SEIKYUKNK_DSHR, "KK_SEIKYUKNK_DSHR", false);
        addPattern(PATTERN_DEFAULT, KK_HUBIKNK_DSHR, "KK_HUBIKNK_DSHR", false);
        addPattern(PATTERN_DEFAULT, KK_SEIKYUKNK_YENDTHNK_NINI, "KK_SEIKYUKNK_YENDTHNK_NINI", false);
        addPattern(PATTERN_DEFAULT, KK_HUBIKNK_YENDTHNK_NINI, "KK_HUBIKNK_YENDTHNK_NINI", false);
        addPattern(PATTERN_DEFAULT, KK_HUBIKNK_KYKTORIKESI, "KK_HUBIKNK_KYKTORIKESI", false);
        addPattern(PATTERN_DEFAULT, KK_HUBIKNK_CLGOFF, "KK_HUBIKNK_CLGOFF", false);
        addPattern(PATTERN_DEFAULT, KK_HUBIKNK_KAIJYO, "KK_HUBIKNK_KAIJYO", false);
        addPattern(PATTERN_DEFAULT, KK_HUBIKNK_MUKOU, "KK_HUBIKNK_MUKOU", false);
        addPattern(PATTERN_DEFAULT, KK_HUBIKNK_SBKAIJYO, "KK_HUBIKNK_SBKAIJYO", false);
        addPattern(PATTERN_DEFAULT, KK_HUBIKNK_SBMENSEKI, "KK_HUBIKNK_SBMENSEKI", false);
        addPattern(PATTERN_DEFAULT, KK_HUBIKNK_SBMUKOU, "KK_HUBIKNK_SBMUKOU", false);
        addPattern(PATTERN_DEFAULT, KK_HUBIKNK_SBMUKOUNOSHR, "KK_HUBIKNK_SBMUKOUNOSHR", false);
        addPattern(PATTERN_DEFAULT, KK_HUBIKNK_SBMENSEKINOSHR, "KK_HUBIKNK_SBMENSEKINOSHR", false);
        addPattern(PATTERN_DEFAULT, KK_SEIKYUKNK_KZKTRKKYKDRHNK, "KK_SEIKYUKNK_KZKTRKKYKDRHNK", false);
        addPattern(PATTERN_DEFAULT, KK_HUBIKNK_KZKTRKKYKDRHNK, "KK_HUBIKNK_KZKTRKKYKDRHNK", false);
        addPattern(PATTERN_DEFAULT, AS_KOUHURIKAISIANNAI, "AS_KOUHURIKAISIANNAI", false);
        addPattern(PATTERN_DEFAULT, AS_KIJITUTOURAIANNAI, "AS_KIJITUTOURAIANNAI", false);
        addPattern(PATTERN_DEFAULT, AS_KZHENKINTUUTI, "AS_KZHENKINTUUTI", false);
        addPattern(PATTERN_DEFAULT, AS_KZHURIKOMITUUTI, "AS_KZHURIKOMITUUTI", false);
        addPattern(PATTERN_DEFAULT, AS_KRKKN_SEIBITOKUSOKULIST_1, "AS_KRKKN_SEIBITOKUSOKULIST_1", false);
        addPattern(PATTERN_DEFAULT, AS_CREDITHENKINTUUTI, "AS_CREDITHENKINTUUTI", false);
        addPattern(PATTERN_DEFAULT, AS_KRKKN_SEIBITOKUSOKULIST_2, "AS_KRKKN_SEIBITOKUSOKULIST_2", false);
        addPattern(PATTERN_DEFAULT, AS_KOUHURIMINYUUTUUTI, "AS_KOUHURIMINYUUTUUTI", false);
        addPattern(PATTERN_DEFAULT, AS_CREDITMINYUUTUUTI, "AS_CREDITMINYUUTUUTI", false);
        addPattern(PATTERN_DEFAULT, AS_DATTAITUUTI_KOUHURI, "AS_DATTAITUUTI_KOUHURI", false);
        addPattern(PATTERN_DEFAULT, AS_DATTAI_MIKAISYOULIST, "AS_DATTAI_MIKAISYOULIST", false);
        addPattern(PATTERN_DEFAULT, AS_YUUKOUSEINGTUUTI, "AS_YUUKOUSEINGTUUTI", false);
        addPattern(PATTERN_DEFAULT, AS_HRHNTTDKANNAI, "AS_HRHNTTDKANNAI", false);
        addPattern(PATTERN_DEFAULT, AS_PKZHRIKEIRAI, "AS_PKZHRIKEIRAI", false);
        addPattern(PATTERN_DEFAULT, AS_PHRKKAISUUHENKOUMOS, "AS_PHRKKAISUUHENKOUMOS", false);
        addPattern(PATTERN_DEFAULT, AS_HRHNKANRYOTUUTI, "AS_HRHNKANRYOTUUTI", false);
        addPattern(PATTERN_DEFAULT, AS_HRHNKANRYOTUUTI_DNP, "AS_HRHNKANRYOTUUTI_DNP", false);
        addPattern(PATTERN_DEFAULT, AS_HRHN_HB, "AS_HRHN_HB", false);
        addPattern(PATTERN_DEFAULT, AS_HRHN_HBLIST, "AS_HRHN_HBLIST", false);
        addPattern(PATTERN_DEFAULT, AS_CREDITCARDMOS, "AS_CREDITCARDMOS", false);
        addPattern(PATTERN_DEFAULT, AS_SINKOKUYOKOKUTUUTI, "AS_SINKOKUYOKOKUTUUTI", false);
        addPattern(PATTERN_DEFAULT, AS_SAIGAITOKUSINKEIYAKUHOYUULIST, "AS_SAIGAITOKUSINKEIYAKUHOYUULIST", false);
        addPattern(PATTERN_DEFAULT, AS_ZENNOUTOUKEILIST, "AS_ZENNOUTOUKEILIST", false);
        addPattern(PATTERN_DEFAULT, AS_ZENNOUMKKPKSSAMPLELIST, "AS_ZENNOUMKKPKSSAMPLELIST", false);
        addPattern(PATTERN_DEFAULT, AS_PMINYUUSYOUMETUHRBKNLIST, "AS_PMINYUUSYOUMETUHRBKNLIST", false);
        addPattern(PATTERN_DEFAULT, AS_SYOUMETUTUUTI, "AS_SYOUMETUTUUTI", false);
        addPattern(PATTERN_DEFAULT, AS_SYOUMETUTUUTI_SHRSKS, "AS_SYOUMETUTUUTI_SHRSKS", false);
        addPattern(PATTERN_DEFAULT, AS_SYOUMETUKEIYAKULIST, "AS_SYOUMETUKEIYAKULIST", false);
        addPattern(PATTERN_DEFAULT, AS_JIMURENRAKU_SYUUNOU, "AS_JIMURENRAKU_SYUUNOU", false);
        addPattern(PATTERN_DEFAULT, AS_MISSLIST_SYUUNOU, "AS_MISSLIST_SYUUNOU", false);
        addPattern(PATTERN_DEFAULT, AS_PMINYUUSYOUMETU_MISSLIST, "AS_PMINYUUSYOUMETU_MISSLIST", false);
        addPattern(PATTERN_DEFAULT, AS_URIAGESEIKYUUKEKKA_ERRORLIST, "AS_URIAGESEIKYUUKEKKA_ERRORLIST", false);
        addPattern(PATTERN_DEFAULT, AS_CREDITTOUROKUKENSUULIST, "AS_CREDITTOUROKUKENSUULIST", false);
        addPattern(PATTERN_DEFAULT, AS_MOSKNK_HRHN, "AS_MOSKNK_HRHN", false);
        addPattern(PATTERN_DEFAULT, AS_HUBIKNK_HRHN, "AS_HUBIKNK_HRHN", false);
        addPattern(PATTERN_DEFAULT, AS_YUUKOUKAKUNIN_ERRORLIST, "AS_YUUKOUKAKUNIN_ERRORLIST", false);
        addPattern(PATTERN_DEFAULT, AS_MINUSURIAGEKYKDTLLIST, "AS_MINUSURIAGEKYKDTLLIST", false);
        addPattern(PATTERN_DEFAULT, NK_SKS, "NK_SKS", false);
        addPattern(PATTERN_DEFAULT, NK_SKS_ITJ, "NK_SKS_ITJ", false);
        addPattern(PATTERN_DEFAULT, NK_SKS_SIBOU, "NK_SKS_SIBOU", false);
        addPattern(PATTERN_DEFAULT, NK_SKS_MGHNK, "NK_SKS_MGHNK", false);
        addPattern(PATTERN_DEFAULT, NK_SKS_KZHNK, "NK_SKS_KZHNK", false);
        addPattern(PATTERN_DEFAULT, NK_SKS_KAISUHNK, "NK_SKS_KAISUHNK", false);
        addPattern(PATTERN_DEFAULT, NK_SKS_SAIHAKKOU, "NK_SKS_SAIHAKKOU", false);
        addPattern(PATTERN_DEFAULT, NK_SKS_TK_STDRSKTKY, "NK_SKS_TK_STDRSKTKY", false);
        addPattern(PATTERN_DEFAULT, NK_SKS_TK_KKNKUKT, "NK_SKS_TK_KKNKUKT", false);
        addPattern(PATTERN_DEFAULT, NK_SKS_D_UKTRHOU_HK, "NK_SKS_D_UKTRHOU_HK", false);
        addPattern(PATTERN_DEFAULT, NK_SOUHU_ITJ, "NK_SOUHU_ITJ", false);
        addPattern(PATTERN_DEFAULT, NK_SOUHU_SIBOU, "NK_SOUHU_SIBOU", false);
        addPattern(PATTERN_DEFAULT, NK_SOUHU_MGHNK, "NK_SOUHU_MGHNK", false);
        addPattern(PATTERN_DEFAULT, NK_SOUHU_KZHNK, "NK_SOUHU_KZHNK", false);
        addPattern(PATTERN_DEFAULT, NK_SOUHU_KAISUHNK, "NK_SOUHU_KAISUHNK", false);
        addPattern(PATTERN_DEFAULT, NK_SOUHU_SAIHAKKOU, "NK_SOUHU_SAIHAKKOU", false);
        addPattern(PATTERN_DEFAULT, NK_SOUHU_TK_STDRSKTKY, "NK_SOUHU_TK_STDRSKTKY", false);
        addPattern(PATTERN_DEFAULT, NK_SOUHU_TK_KKNKUKT, "NK_SOUHU_TK_KKNKUKT", false);
        addPattern(PATTERN_DEFAULT, NK_SOUHU_D_UKTRHOU_HK, "NK_SOUHU_D_UKTRHOU_HK", false);
        addPattern(PATTERN_DEFAULT, NK_SISAN_ITJ, "NK_SISAN_ITJ", false);
        addPattern(PATTERN_DEFAULT, NK_SISAN_SIBOU, "NK_SISAN_SIBOU", false);
        addPattern(PATTERN_DEFAULT, NK_HUBI_ITJ, "NK_HUBI_ITJ", false);
        addPattern(PATTERN_DEFAULT, NK_HUBI_SIBOU, "NK_HUBI_SIBOU", false);
        addPattern(PATTERN_DEFAULT, NK_HUBI_MGHNK, "NK_HUBI_MGHNK", false);
        addPattern(PATTERN_DEFAULT, NK_HUBI_KZHNK, "NK_HUBI_KZHNK", false);
        addPattern(PATTERN_DEFAULT, NK_HUBI_KAISUHNK, "NK_HUBI_KAISUHNK", false);
        addPattern(PATTERN_DEFAULT, NK_HUBI_SAIHAKKOU, "NK_HUBI_SAIHAKKOU", false);
        addPattern(PATTERN_DEFAULT, NK_HUBI_TK_STDRSKTKY, "NK_HUBI_TK_STDRSKTKY", false);
        addPattern(PATTERN_DEFAULT, NK_HUBI_TK_KKNKUKT, "NK_HUBI_TK_KKNKUKT", false);
        addPattern(PATTERN_DEFAULT, NK_SOUHU_HUBI_ITJ, "NK_SOUHU_HUBI_ITJ", false);
        addPattern(PATTERN_DEFAULT, NK_SOUHU_HUBI_SIBOU, "NK_SOUHU_HUBI_SIBOU", false);
        addPattern(PATTERN_DEFAULT, NK_SOUHU_HUBI_MGHNK, "NK_SOUHU_HUBI_MGHNK", false);
        addPattern(PATTERN_DEFAULT, NK_SOUHU_HUBI_KZHNK, "NK_SOUHU_HUBI_KZHNK", false);
        addPattern(PATTERN_DEFAULT, NK_SOUHU_HUBI_KAISUHNK, "NK_SOUHU_HUBI_KAISUHNK", false);
        addPattern(PATTERN_DEFAULT, NK_SOUHU_HUBI_SAIHAKKOU, "NK_SOUHU_HUBI_SAIHAKKOU", false);
        addPattern(PATTERN_DEFAULT, NK_SOUHU_HUBI_TK_STDRSKTKY, "NK_SOUHU_HUBI_TK_STDRSKTKY", false);
        addPattern(PATTERN_DEFAULT, NK_SOUHU_HUBI_TK_KKNKUKT, "NK_SOUHU_HUBI_TK_KKNKUKT", false);
        addPattern(PATTERN_DEFAULT, NK_NKSYOUSYO, "NK_NKSYOUSYO", false);
        addPattern(PATTERN_DEFAULT, NK_TTDKKNR_NKIKOU, "NK_TTDKKNR_NKIKOU", false);
        addPattern(PATTERN_DEFAULT, NK_SHRMEISAISYO, "NK_SHRMEISAISYO", false);
        addPattern(PATTERN_DEFAULT, NK_TTDKKNR_ITJ, "NK_TTDKKNR_ITJ", false);
        addPattern(PATTERN_DEFAULT, NK_TTDKKNR_TJSHR, "NK_TTDKKNR_TJSHR", false);
        addPattern(PATTERN_DEFAULT, NK_TTDKKNR_SIBOU, "NK_TTDKKNR_SIBOU", false);
        addPattern(PATTERN_DEFAULT, NK_TTDKKNR_UKTHNK, "NK_TTDKKNR_UKTHNK", false);
        addPattern(PATTERN_DEFAULT, NK_TTDKKNR_MGHNK, "NK_TTDKKNR_MGHNK", false);
        addPattern(PATTERN_DEFAULT, NK_TTDKKNR_KZHNK, "NK_TTDKKNR_KZHNK", false);
        addPattern(PATTERN_DEFAULT, NK_TTDKKNR_KAISUHNK, "NK_TTDKKNR_KAISUHNK", false);
        addPattern(PATTERN_DEFAULT, NK_TTDKKNR_SAIHAKKOU, "NK_TTDKKNR_SAIHAKKOU", false);
        addPattern(PATTERN_DEFAULT, NK_TTDKKNR_TK_STDRSKTKY, "NK_TTDKKNR_TK_STDRSKTKY", false);
        addPattern(PATTERN_DEFAULT, NK_TTDKKNR_TK_KKNKUKT, "NK_TTDKKNR_TK_KKNKUKT", false);
        addPattern(PATTERN_DEFAULT, NK_DAIHYOUSENNINTDK, "NK_DAIHYOUSENNINTDK", false);
        addPattern(PATTERN_DEFAULT, NK_KOSEKITOUHON, "NK_KOSEKITOUHON", false);
        addPattern(PATTERN_DEFAULT, NK_KOSEKITOUHON_KAISEI, "NK_KOSEKITOUHON_KAISEI", false);
        addPattern(PATTERN_DEFAULT, NK_JYUUMIN, "NK_JYUUMIN", false);
        addPattern(PATTERN_DEFAULT, NK_HONNINKAKUNIN, "NK_HONNINKAKUNIN", false);
        addPattern(PATTERN_DEFAULT, NK_HONNINKAKUNIN_SHR, "NK_HONNINKAKUNIN_SHR", false);
        addPattern(PATTERN_DEFAULT, NK_SIBOUSINDAN, "NK_SIBOUSINDAN", false);
        addPattern(PATTERN_DEFAULT, NK_TORIHIKIJIKAKUNIN, "NK_TORIHIKIJIKAKUNIN", false);
        addPattern(PATTERN_DEFAULT, NK_NKTRKM_MISSLIST, "NK_NKTRKM_MISSLIST", false);
        addPattern(PATTERN_DEFAULT, NK_JDSHR_MISSLIST, "NK_JDSHR_MISSLIST", false);
        addPattern(PATTERN_DEFAULT, NK_KSCHK_MISSLIST, "NK_KSCHK_MISSLIST", false);
        addPattern(PATTERN_DEFAULT, NK_GNSNLIST, "NK_GNSNLIST", false);
        addPattern(PATTERN_DEFAULT, NK_HUBIMIKAISYOULIST, "NK_HUBIMIKAISYOULIST", false);
        addPattern(PATTERN_DEFAULT, NK_TYOUSYOLIST_NK, "NK_TYOUSYOLIST_NK", false);
        addPattern(PATTERN_DEFAULT, NK_TYOUSYOLIST_ITJ_NK, "NK_TYOUSYOLIST_ITJ_NK", false);
        addPattern(PATTERN_DEFAULT, NK_TYOUSYOLIST_UK_NK, "NK_TYOUSYOLIST_UK_NK", false);
        addPattern(PATTERN_DEFAULT, SK_MOSSYO, "SK_MOSSYO", false);
        addPattern(PATTERN_DEFAULT, SK_PPLESSMOSIKOUKAKSYO, "SK_PPLESSMOSIKOUKAKSYO", false);
        addPattern(PATTERN_DEFAULT, SK_KOKUSYO, "SK_KOKUSYO", false);
        addPattern(PATTERN_DEFAULT, SK_PPLESSKOKUSYO, "SK_PPLESSKOKUSYO", false);
        addPattern(PATTERN_DEFAULT, SK_IKOUKAKSYO, "SK_IKOUKAKSYO", false);
        addPattern(PATTERN_DEFAULT, SK_IKOUKAKSYO_TEISEI, "SK_IKOUKAKSYO_TEISEI", false);
        addPattern(PATTERN_DEFAULT, SK_UKTHUKUSUUSITEI, "SK_UKTHUKUSUUSITEI", false);
        addPattern(PATTERN_DEFAULT, SK_UKTJIZENSYOUKAI, "SK_UKTJIZENSYOUKAI", false);
        addPattern(PATTERN_DEFAULT, SK_DAISANSYAUKTHOUSYO, "SK_DAISANSYAUKTHOUSYO", false);
        addPattern(PATTERN_DEFAULT, SK_FATCAKAKUNINSYO, "SK_FATCAKAKUNINSYO", false);
        addPattern(PATTERN_DEFAULT, SK_TORIHOUSYO, "SK_TORIHOUSYO", false);
        addPattern(PATTERN_DEFAULT, SK_PPLESSTORIHOUSYO, "SK_PPLESSTORIHOUSYO", false);
        addPattern(PATTERN_DEFAULT, SK_SONOTAHUZOKU, "SK_SONOTAHUZOKU", false);
        addPattern(PATTERN_DEFAULT, SK_HENKOUTEISEI, "SK_HENKOUTEISEI", false);
        addPattern(PATTERN_DEFAULT, SK_AEOISINKITODOKEDESYO, "SK_AEOISINKITODOKEDESYO", false);
        addPattern(PATTERN_DEFAULT, SK_SEIMEIPKZHURIKAEMOSSYO, "SK_SEIMEIPKZHURIKAEMOSSYO", false);
        addPattern(PATTERN_DEFAULT, SK_DAIHITUHOUKOKUSYO, "SK_DAIHITUHOUKOKUSYO", false);
        addPattern(PATTERN_DEFAULT, SK_HITAIMENCHKSHEET, "SK_HITAIMENCHKSHEET", false);
        addPattern(PATTERN_DEFAULT, SK_JIMURENRAKU, "SK_JIMURENRAKU", false);
        addPattern(PATTERN_DEFAULT, SK_HUBITUUTI, "SK_HUBITUUTI", false);
        addPattern(PATTERN_DEFAULT, SK_KYKKAKUNINIRAISYO, "SK_KYKKAKUNINIRAISYO", false);
        addPattern(PATTERN_DEFAULT, SK_KYKKAKUNINKAITOUSYO, "SK_KYKKAKUNINKAITOUSYO", false);
        addPattern(PATTERN_DEFAULT, SK_YUUKOUKKNYOKOKULIST, "SK_YUUKOUKKNYOKOKULIST", false);
        addPattern(PATTERN_DEFAULT, SK_YUUKOUKKNTYOUKALIST, "SK_YUUKOUKKNTYOUKALIST", false);
        addPattern(PATTERN_DEFAULT, SK_KYKHUSEIRITU, "SK_KYKHUSEIRITU", false);
        addPattern(PATTERN_DEFAULT, SK_TRKSSEIKYU, "SK_TRKSSEIKYU", false);
        addPattern(PATTERN_DEFAULT, SK_TRKSSEIKYU_SOUHU, "SK_TRKSSEIKYU_SOUHU", false);
        addPattern(PATTERN_DEFAULT, SK_TTDKKR_DAIRITEN, "SK_TTDKKR_DAIRITEN", false);
        addPattern(PATTERN_DEFAULT, SK_TTDKKR, "SK_TTDKKR", false);
        addPattern(PATTERN_DEFAULT, SK_SMBCSINTYOKUMISSLIST, "SK_SMBCSINTYOKUMISSLIST", false);
        addPattern(PATTERN_DEFAULT, SK_SENTAKINFOMISSLIST, "SK_SENTAKINFOMISSLIST", false);
        addPattern(PATTERN_DEFAULT, SK_YOTEIRIRITUHENKOURENRAKUHYOU, "SK_YOTEIRIRITUHENKOURENRAKUHYOU", false);
        addPattern(PATTERN_DEFAULT, SK_HUBITUUTI_KARISAKUSEI, "SK_HUBITUUTI_KARISAKUSEI", false);
        addPattern(PATTERN_DEFAULT, SK_KEIYAKUNAIYOTOROKUSEIDOSYOKAIHYO, "SK_KEIYAKUNAIYOTOROKUSEIDOSYOKAIHYO", false);
        addPattern(PATTERN_DEFAULT, SK_HURIKOMINYKNSAKUJOMISSLIST, "SK_HURIKOMINYKNSAKUJOMISSLIST", false);
        addPattern(PATTERN_DEFAULT, SK_HURIKOMINYKNTEISEILIST_ENKA, "SK_HURIKOMINYKNTEISEILIST_ENKA", false);
        addPattern(PATTERN_DEFAULT, SK_SAKUJOKYKMEISAILIST, "SK_SAKUJOKYKMEISAILIST", false);
        addPattern(PATTERN_DEFAULT, SK_JIDOUNYKNMEISAILIST, "SK_JIDOUNYKNMEISAILIST", false);
        addPattern(PATTERN_DEFAULT, SK_1PNYKNITTILIST, "SK_1PNYKNITTILIST", false);
        addPattern(PATTERN_DEFAULT, SK_NYKJYOUHOUHUITTIKAKSYO, "SK_NYKJYOUHOUHUITTIKAKSYO", false);
        addPattern(PATTERN_DEFAULT, SK_MOSSOUHUJYOUKYOULIST, "SK_MOSSOUHUJYOUKYOULIST", false);
        addPattern(PATTERN_DEFAULT, SK_MOSMITOUTYAKUKKNLIST, "SK_MOSMITOUTYAKUKKNLIST", false);
        addPattern(PATTERN_DEFAULT, SK_MOSSOUHUJYOUKYOULIST_SOUHU, "SK_MOSSOUHUJYOUKYOULIST_SOUHU", false);
        addPattern(PATTERN_DEFAULT, SK_HURIKOMINYKNTEISEILIST_GAIKA, "SK_HURIKOMINYKNTEISEILIST_GAIKA", false);
        addPattern(PATTERN_DEFAULT, SK_SIKINIDOULIST_HRKMKZHUITTI, "SK_SIKINIDOULIST_HRKMKZHUITTI", false);
        addPattern(PATTERN_DEFAULT, SK_HURIKOMINYKNTEISEILIST_ENKA_YENDT, "SK_HURIKOMINYKNTEISEILIST_ENKA_YENDT", false);
        addPattern(PATTERN_DEFAULT, SK_SAKUJOKYKMEISAILIST_YENDT, "SK_SAKUJOKYKMEISAILIST_YENDT", false);
        addPattern(PATTERN_DEFAULT, SK_JIDOUNYKNMEISAILIST_YENDT, "SK_JIDOUNYKNMEISAILIST_YENDT", false);
        addPattern(PATTERN_DEFAULT, SK_1PNYKNITTILIST_YENDT, "SK_1PNYKNITTILIST_YENDT", false);
        addPattern(PATTERN_DEFAULT, SK_NYKJYOUHOUHUITTIKAKSYO_YENDT, "SK_NYKJYOUHOUHUITTIKAKSYO_YENDT", false);
        addPattern(PATTERN_DEFAULT, SK_MOSMITOUTYAKUKKNLIST_YENDT, "SK_MOSMITOUTYAKUKKNLIST_YENDT", false);
        addPattern(PATTERN_DEFAULT, SK_HENKINIRAISYO, "SK_HENKINIRAISYO", false);
        addPattern(PATTERN_DEFAULT, SK_HENKINTUUTILIST, "SK_HENKINTUUTILIST", false);
        addPattern(PATTERN_DEFAULT, SK_HANDKARIKANJYOU, "SK_HANDKARIKANJYOU", false);
        addPattern(PATTERN_DEFAULT, SK_HENKINMISYORILIST, "SK_HENKINMISYORILIST", false);
        addPattern(PATTERN_DEFAULT, SK_HENKINIRAISYO_SOUHU, "SK_HENKINIRAISYO_SOUHU", false);
        addPattern(PATTERN_DEFAULT, SK_HENKINIRAISYO_MIHON, "SK_HENKINIRAISYO_MIHON", false);
        addPattern(PATTERN_DEFAULT, SK_HANDKARIKANJYOU_YENDT, "SK_HANDKARIKANJYOU_YENDT", false);
        addPattern(PATTERN_DEFAULT, SK_HENKINMISYORILIST_YENDT, "SK_HENKINMISYORILIST_YENDT", false);
        addPattern(PATTERN_DEFAULT, SK_KARIUKEHUHOPKAKIN1MKEIKA, "SK_KARIUKEHUHOPKAKIN1MKEIKA", false);
        addPattern(PATTERN_DEFAULT, SK_GETUMATUZANDAKACHKLIST, "SK_GETUMATUZANDAKACHKLIST", false);
        addPattern(PATTERN_DEFAULT, SK_MSRKARIUKEKINMEISAI, "SK_MSRKARIUKEKINMEISAI", false);
        addPattern(PATTERN_DEFAULT, SK_MSRJIYUUMEISAI_NYKNHUBI, "SK_MSRJIYUUMEISAI_NYKNHUBI", false);
        addPattern(PATTERN_DEFAULT, SK_MSRJIYUUMEISAI_SYORUIHUBI_TAN, "SK_MSRJIYUUMEISAI_SYORUIHUBI_TAN", false);
        addPattern(PATTERN_DEFAULT, SK_MSRJIYUUMEISAI_SYORUIHUBI_HUKU, "SK_MSRJIYUUMEISAI_SYORUIHUBI_HUKU", false);
        addPattern(PATTERN_DEFAULT, SK_MSRJIYUUMEISAI_SEIRITUHRYUUUKTKTYUU, "SK_MSRJIYUUMEISAI_SEIRITUHRYUUUKTKTYUU", false);
        addPattern(PATTERN_DEFAULT, SK_MSRJIYUUBETUKARIUKEKINSYUUKEI, "SK_MSRJIYUUBETUKARIUKEKINSYUUKEI", false);
        addPattern(PATTERN_DEFAULT, SK_MSRJIYUUBETUKARIUKEKINMEISAILIST, "SK_MSRJIYUUBETUKARIUKEKINMEISAILIST", false);
        addPattern(PATTERN_DEFAULT, SK_JIDSYUUNOUSYOUGOUMEISAI_KESSAN, "SK_JIDSYUUNOUSYOUGOUMEISAI_KESSAN", false);
        addPattern(PATTERN_DEFAULT, SK_KARIUKEKINPKAKINMEISAI, "SK_KARIUKEKINPKAKINMEISAI", false);
        addPattern(PATTERN_DEFAULT, SK_KARIUKEKINPKAKINZANDAKAMEISAILIST, "SK_KARIUKEKINPKAKINZANDAKAMEISAILIST", false);
        addPattern(PATTERN_DEFAULT, SK_HUKUSUUKAINYUUKINKAWASESASONEKI, "SK_HUKUSUUKAINYUUKINKAWASESASONEKI", false);
        addPattern(PATTERN_DEFAULT, SK_CREDITQRTOUROKUMIHANEILIST, "SK_CREDITQRTOUROKUMIHANEILIST", false);
        addPattern(PATTERN_DEFAULT, SK_CREDITCARDKAIINTOUROKUNGLIST, "SK_CREDITCARDKAIINTOUROKUNGLIST", false);
        addPattern(PATTERN_DEFAULT, SK_CREDITCARDTOUROKUHANEIERRORLIST, "SK_CREDITCARDTOUROKUHANEIERRORLIST", false);
        addPattern(PATTERN_DEFAULT, SK_YUUKOUHANEIKAKUNINKEKKALIST, "SK_YUUKOUHANEIKAKUNINKEKKALIST", false);
        addPattern(PATTERN_DEFAULT, SK_FSTPURIAGESEIKYUUERRORLIST, "SK_FSTPURIAGESEIKYUUERRORLIST", false);
        addPattern(PATTERN_DEFAULT, SK_FSTPURIAGESEIKYUUMEISAI_JCB, "SK_FSTPURIAGESEIKYUUMEISAI_JCB", false);
        addPattern(PATTERN_DEFAULT, SK_FSTPURIAGESEIKYUUMEISAI_VISA, "SK_FSTPURIAGESEIKYUUMEISAI_VISA", false);
        addPattern(PATTERN_DEFAULT, SK_KOUFURITOUROKUMIHANEILIST, "SK_KOUFURITOUROKUMIHANEILIST", false);
        addPattern(PATTERN_DEFAULT, SK_KOUFURITOUROKUHANEIERRORLIST, "SK_KOUFURITOUROKUHANEIERRORLIST", false);
        addPattern(PATTERN_DEFAULT, SK_KARIUKEHUHOPKAKIN1MKEIKA_YENDT, "SK_KARIUKEHUHOPKAKIN1MKEIKA_YENDT", false);
        addPattern(PATTERN_DEFAULT, SK_GETUMATUZANDAKACHKLIST_YENDT, "SK_GETUMATUZANDAKACHKLIST_YENDT", false);
        addPattern(PATTERN_DEFAULT, SK_MSRKARIUKEKINMEISAI_YENDT, "SK_MSRKARIUKEKINMEISAI_YENDT", false);
        addPattern(PATTERN_DEFAULT, SK_MSRJIYUUMEISAI_NYKNHUBI_YENDT, "SK_MSRJIYUUMEISAI_NYKNHUBI_YENDT", false);
        addPattern(PATTERN_DEFAULT, SK_MSRJIYUUMEISAI_SYORUIHUBI_TAN_YENDT, "SK_MSRJIYUUMEISAI_SYORUIHUBI_TAN_YENDT", false);
        addPattern(PATTERN_DEFAULT, SK_MSRJIYUUMEISAI_SYORUIHUBI_HUKU_YENDT, "SK_MSRJIYUUMEISAI_SYORUIHUBI_HUKU_YENDT", false);
        addPattern(PATTERN_DEFAULT, SK_MSRJIYUUMEISAI_SEIRITUHRYUUUKTKTYUU_YENDT, "SK_MSRJIYUUMEISAI_SEIRITUHRYUUUKTKTYUU_YENDT", false);
        addPattern(PATTERN_DEFAULT, SK_MSRJIYUUBETUKARIUKEKINSYUUKEI_YENDT, "SK_MSRJIYUUBETUKARIUKEKINSYUUKEI_YENDT", false);
        addPattern(PATTERN_DEFAULT, SK_MSRJIYUUBETUKARIUKEKINMEISAILIST_YENDT, "SK_MSRJIYUUBETUKARIUKEKINMEISAILIST_YENDT", false);
        addPattern(PATTERN_DEFAULT, SK_JIDSYUUNOUSYOUGOUMEISAI_KESSAN_YENDT, "SK_JIDSYUUNOUSYOUGOUMEISAI_KESSAN_YENDT", false);
        addPattern(PATTERN_DEFAULT, SK_KARIUKEKINPKAKINMEISAI_YENDT, "SK_KARIUKEKINPKAKINMEISAI_YENDT", false);
        addPattern(PATTERN_DEFAULT, SK_KARIUKEKINPKAKINZANDAKAMEISAILIST_YENDT, "SK_KARIUKEKINPKAKINZANDAKAMEISAILIST_YENDT", false);
        addPattern(PATTERN_DEFAULT, SR_OIKOMISYUUKEIHYOUTYOUSEI, "SR_OIKOMISYUUKEIHYOUTYOUSEI", false);
        addPattern(PATTERN_DEFAULT, SR_OIKOMISYUUKEIPDENPYOU, "SR_OIKOMISYUUKEIPDENPYOU", false);
        addPattern(PATTERN_DEFAULT, SR_SK_KESSANHURIDEN, "SR_SK_KESSANHURIDEN", false);
        addPattern(PATTERN_DEFAULT, SR_SK_KESSANHURIDEN_HIKAE, "SR_SK_KESSANHURIDEN_HIKAE", false);
        addPattern(PATTERN_DEFAULT, SR_TMTTDMEISAILIST, "SR_TMTTDMEISAILIST", false);
        addPattern(PATTERN_DEFAULT, SR_KBNKEIRIYOUTMTTDMEISAILIST, "SR_KBNKEIRIYOUTMTTDMEISAILIST", false);
        addPattern(PATTERN_DEFAULT, SR_KARIWARIATEDMEISAILIS, "SR_KARIWARIATEDMEISAILIS", false);
        addPattern(PATTERN_DEFAULT, SR_BIKINKYKSEISANDLIST, "SR_BIKINKYKSEISANDLIST", false);
        addPattern(PATTERN_DEFAULT, SR_KBNKEIRIYOUBIKINKYKSEISANDLIST, "SR_KBNKEIRIYOUBIKINKYKSEISANDLIST", false);
        addPattern(PATTERN_DEFAULT, SR_BIKINKYKKARIWARIATEDLIST, "SR_BIKINKYKKARIWARIATEDLIST", false);


        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, BLNK, "BLNK", true);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, USERITIRANHYOU, "USERITIRANHYOU", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, CM_JIMURENRAKUHYOU, "CM_JIMURENRAKUHYOU", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, CM_LINC_MISSLIST, "CM_LINC_MISSLIST", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, CM_ONLINE_FBFURIKOMIKEI_1, "CM_ONLINE_FBFURIKOMIKEI_1", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, CM_ONLINE_FBFURIKOMIKEI_2, "CM_ONLINE_FBFURIKOMIKEI_2", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, CM_ONLINE_GKFBFURIKOMIKEI_1, "CM_ONLINE_GKFBFURIKOMIKEI_1", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, CM_ONLINE_GKFBFURIKOMIKEI_2, "CM_ONLINE_GKFBFURIKOMIKEI_2", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, CM_ONLINE_FBSOUKINMEISAI_1, "CM_ONLINE_FBSOUKINMEISAI_1", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, CM_ONLINE_FBSOUKINMEISAI_2, "CM_ONLINE_FBSOUKINMEISAI_2", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, CM_ONLINE_FBSOUKINMEISAI_3, "CM_ONLINE_FBSOUKINMEISAI_3", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, CM_ONLINE_FBSOUKINMEISAI_4, "CM_ONLINE_FBSOUKINMEISAI_4", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, CM_ONLINE_FBSOUKINMEISAI_5, "CM_ONLINE_FBSOUKINMEISAI_5", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, CM_ONLINE_GKFBSOUKINMEISAI_1, "CM_ONLINE_GKFBSOUKINMEISAI_1", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, CM_ONLINE_GKFBSOUKINMEISAI_2, "CM_ONLINE_GKFBSOUKINMEISAI_2", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, CM_ONLINE_GKFBSOUKINMEISAI_3, "CM_ONLINE_GKFBSOUKINMEISAI_3", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, CM_ONLINE_GKFBSOUKINMEISAI_4, "CM_ONLINE_GKFBSOUKINMEISAI_4", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, CM_ONLINE_GKFBSOUKINMEISAI_5, "CM_ONLINE_GKFBSOUKINMEISAI_5", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, CM_BATCH_FBFURIKOMIKEI_4, "CM_BATCH_FBFURIKOMIKEI_4", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, CM_BATCH_GKFBFURIKOMIKEI, "CM_BATCH_GKFBFURIKOMIKEI", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, CM_BATCH_FBSOUKINMEISAI_4, "CM_BATCH_FBSOUKINMEISAI_4", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, CM_BATCH_GKFBSOUKINMEISAI, "CM_BATCH_GKFBSOUKINMEISAI", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, CM_TIENRSKUTIWAKELIST, "CM_TIENRSKUTIWAKELIST", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, CM_SKHONSYADENPYOULIST, "CM_SKHONSYADENPYOULIST", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, CM_KARIUKEMEISAI_1, "CM_KARIUKEMEISAI_1", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, CM_KARIUKEMEISAI_2, "CM_KARIUKEMEISAI_2", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, CM_KARIUKEMEISAI_3, "CM_KARIUKEMEISAI_3", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, CM_KARIUKEMEISAI_4, "CM_KARIUKEMEISAI_4", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, CM_SIKINIDOULIST_SOKUJI, "CM_SIKINIDOULIST_SOKUJI", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, CM_SIKINIDOULIST_TYAKKINBI, "CM_SIKINIDOULIST_TYAKKINBI", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, CM_HURIKOMIERRINFOLIST, "CM_HURIKOMIERRINFOLIST", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, CM_GKHURIKOMIERRINFOLIST, "CM_GKHURIKOMIERRINFOLIST", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, CM_HOJYOBOLIST_1, "CM_HOJYOBOLIST_1", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, CM_HOJYOBOLIST_2, "CM_HOJYOBOLIST_2", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, CM_HOJYOBOLIST_3, "CM_HOJYOBOLIST_3", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, CM_HOJYOBOLIST_4, "CM_HOJYOBOLIST_4", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, CM_HOJYOBOLIST_5, "CM_HOJYOBOLIST_5", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, BZ_JIGYOUHIKANJYOUKAKUSYOULIST_1, "BZ_JIGYOUHIKANJYOUKAKUSYOULIST_1", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, BZ_JIGYOUHIKANJYOUKAKUSYOULIST_2, "BZ_JIGYOUHIKANJYOUKAKUSYOULIST_2", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, CM_TUUSANKAWASERATEKAKUNIN, "CM_TUUSANKAWASERATEKAKUNIN", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, CM_HOJYOBOLIST_6, "CM_HOJYOBOLIST_6", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, CM_KARIUKEMEISAI_5, "CM_KARIUKEMEISAI_5", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, CM_ONLINE_FBSOUKINMEISAI_6, "CM_ONLINE_FBSOUKINMEISAI_6", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, CM_SIKINIDOULIST_YENDTHNK, "CM_SIKINIDOULIST_YENDTHNK", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, CM_BATCH_FBSOUKINMEISAI_7, "CM_BATCH_FBSOUKINMEISAI_7", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, CM_ONLINE_FBSOUKINMEISAI_7, "CM_ONLINE_FBSOUKINMEISAI_7", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, CM_MYNUMBERTYUUSYUTULIST, "CM_MYNUMBERTYUUSYUTULIST", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, CM_HOJYOBOLIST_7, "CM_HOJYOBOLIST_7", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, CM_KBTKARIKANJYOUZNDKSYUKILIST, "CM_KBTKARIKANJYOUZNDKSYUKILIST", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, CM_SIKINIDOULIST_HIJYNNYK, "CM_SIKINIDOULIST_HIJYNNYK", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, CM_BATCH_FBFURIKOMIKEI_2, "CM_BATCH_FBFURIKOMIKEI_2", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, CM_BATCH_FBSOUKINMEISAI_2, "CM_BATCH_FBSOUKINMEISAI_2", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, CM_SIKINIDOULIST_HTKIN, "CM_SIKINIDOULIST_HTKIN", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, CM_KARIUKEMEISAI_6, "CM_KARIUKEMEISAI_6", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, CM_BATCH_FBFURIKOMIKEI_3, "CM_BATCH_FBFURIKOMIKEI_3", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, CM_BATCH_FBSOUKINMEISAI_3, "CM_BATCH_FBSOUKINMEISAI_3", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, DS_KARIPWTUUTITYUUDANLIST, "DS_KARIPWTUUTITYUUDANLIST", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, DS_KOUZOKUJIMUKAKUNINLIST, "DS_KOUZOKUJIMUKAKUNINLIST", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, HK_SHRMESS, "HK_SHRMESS", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, HK_SHMEISAI_SDS, "HK_SHMEISAI_SDS", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, HK_SB_HOKEN_SKS, "HK_SB_HOKEN_SKS", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, HK_SEISANKINHRKM_IRAIS, "HK_SEISANKINHRKM_IRAIS", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, HK_SB_DAIHYOU, "HK_SB_DAIHYOU", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, HK_KD_JIKOJKS, "HK_KD_JIKOJKS", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, HK_JIJYOUTODOKEKENSEIYAKUSYO, "HK_JIJYOUTODOKEKENSEIYAKUSYO", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, HK_TEISYUTUSYORUI, "HK_TEISYUTUSYORUI", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, HK_MYNUMBER_CHYOU, "HK_MYNUMBER_CHYOU", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, HK_SOUHU, "HK_SOUHU", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, HK_STI_KAS, "HK_STI_KAS", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, HK_SB_SONOTA_SDS, "HK_SB_SONOTA_SDS", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, HK_SB_KTJKSMS, "HK_SB_KTJKSMS", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, HK_SB_HKNSYKN, "HK_SB_HKNSYKN", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, HK_SB_KOSEKI, "HK_SB_KOSEKI", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, HK_SB_HONNINSR, "HK_SB_HONNINSR", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, HK_SB_JYUUMIN, "HK_SB_JYUUMIN", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, HK_SB_INKAN, "HK_SB_INKAN", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, HK_SB_KAKUNINDOUISYO, "HK_SB_KAKUNINDOUISYO", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, HK_SB_SKKANSYOUKNK, "HK_SB_SKKANSYOUKNK", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, HK_MYNUMBER_SYORUI, "HK_MYNUMBER_SYORUI", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, HK_SB_SONOTA_SKS, "HK_SB_SONOTA_SKS", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, HK_ENKASIHARAIRYUUIJIKOU, "HK_ENKASIHARAIRYUUIJIKOU", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, HK_SB_HUBITEISEI, "HK_SB_HUBITEISEI", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, HK_SB_HUBITEISEI2, "HK_SB_HUBITEISEI2", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, HK_HUBITEISEI_SOUHU, "HK_HUBITEISEI_SOUHU", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, HK_SB_HUBIKNK, "HK_SB_HUBIKNK", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, HK_SB_KAKUNINIRAIS, "HK_SB_KAKUNINIRAIS", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, HK_SB_KAKUNINHKS, "HK_SB_KAKUNINHKS", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, HK_BIKINSAGYOULIST, "HK_BIKINSAGYOULIST", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, HK_BIKINJIKOUKIST, "HK_BIKINJIKOUKIST", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, HK_BIKINJIKOUKIST_GOUKEI, "HK_BIKINJIKOUKIST_GOUKEI", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, HK_ZENNOUSEISANKINMEISAILIST, "HK_ZENNOUSEISANKINMEISAILIST", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, HK_JIKOUDENMEISAILIST, "HK_JIKOUDENMEISAILIST", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, HK_SB_SONOTA, "HK_SB_SONOTA", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, KK_ADRHNK_TTDKKR, "KK_ADRHNK_TTDKKR", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, KK_ADRHNK_GAIBU_TTDKKR, "KK_ADRHNK_GAIBU_TTDKKR", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, KK_MEIGIHNK_TTDKKR, "KK_MEIGIHNK_TTDKKR", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, KK_STDRHNK_TTDKKR, "KK_STDRHNK_TTDKKR", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, KK_SEINENGAPPISEI_TTDKKR, "KK_SEINENGAPPISEI_TTDKKR", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, KK_SEINENGAPPISEI_TTDKKR_SHRARI, "KK_SEINENGAPPISEI_TTDKKR_SHRARI", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, KK_GENGAKU_TTDKKR, "KK_GENGAKU_TTDKKR", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, KK_NKTKYKHNK_TTDKKR, "KK_NKTKYKHNK_TTDKKR", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, KK_TARGETHNK_TTDKKR, "KK_TARGETHNK_TTDKKR", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, KK_TARGETHNK_GAIBU_TTDKKR, "KK_TARGETHNK_GAIBU_TTDKKR", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, KK_KAIYAKU_TTDKKR, "KK_KAIYAKU_TTDKKR", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, KK_KAIYAKU_GAIBU_TTDKKR, "KK_KAIYAKU_GAIBU_TTDKKR", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, KK_KAIYAKU_SAIKENSYA_TTDKKR, "KK_KAIYAKU_SAIKENSYA_TTDKKR", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, KK_SHRKZHNK_TTDKKR, "KK_SHRKZHNK_TTDKKR", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, KK_SYOSAIHK_TTDKKR, "KK_SYOSAIHK_TTDKKR", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, KK_KYKTRKS_KYKTRKSTTDKKR, "KK_KYKTRKS_KYKTRKSTTDKKR", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, KK_CLGOFF_KYKTRKSTTDKKR, "KK_CLGOFF_KYKTRKSTTDKKR", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, KK_KAIJYO_KYKTRKSTTDKKR, "KK_KAIJYO_KYKTRKSTTDKKR", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, KK_SBKAIJYO_KYKTRKSTTDKKR, "KK_SBKAIJYO_KYKTRKSTTDKKR", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, KK_SBMENSEKI_KYKTRKSTTDKKR, "KK_SBMENSEKI_KYKTRKSTTDKKR", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, KK_KAIGOMAETKHNK_TTDKKR, "KK_KAIGOMAETKHNK_TTDKKR", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, KK_SBMUKOU_KYKTRKSTTDKKR, "KK_SBMUKOU_KYKTRKSTTDKKR", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, KK_MOUSIDEMUKOU_KYKTRKSTTDKKR, "KK_MOUSIDEMUKOU_KYKTRKSTTDKKR", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, KK_HRIHEN_TTDKKR, "KK_HRIHEN_TTDKKR", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, KK_HUKKATU_TTDKKR, "KK_HUKKATU_TTDKKR", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, KK_HUKKATU_OKOTOWARI, "KK_HUKKATU_OKOTOWARI", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, KK_MKHGKHNK_TTDKKR, "KK_MKHGKHNK_TTDKKR", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, KK_YENDTHNKHNRKN_TTDKKR, "KK_YENDTHNKHNRKN_TTDKKR", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, KK_TUMITATEKINITEN_TTDKKR, "KK_TUMITATEKINITEN_TTDKKR", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, KK_YENDTHNK_HNRKNSKS_TTDKKR, "KK_YENDTHNK_HNRKNSKS_TTDKKR", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, KK_YENDTHNK_TTDKKR, "KK_YENDTHNK_TTDKKR", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, KK_YENDTHNK_TTDKKR_3, "KK_YENDTHNK_TTDKKR_3", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, KK_DSHR_TTDKKR, "KK_DSHR_TTDKKR", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, KK_GENGAKU_ZEITEKI_TTDKKR, "KK_GENGAKU_ZEITEKI_TTDKKR", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, KK_YENDTHNK_NINI_TTDKKR, "KK_YENDTHNK_NINI_TTDKKR", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, KK_YENDTHNK_NINI_TTDKKR_2, "KK_YENDTHNK_NINI_TTDKKR_2", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, KK_SYOUMETU_GAIBU_TTDKKR, "KK_SYOUMETU_GAIBU_TTDKKR", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, KK_YENDTHNK_TTDKKR_2, "KK_YENDTHNK_TTDKKR_2", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, KK_DTUIBARAI_TTDKKR, "KK_DTUIBARAI_TTDKKR", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, KK_DTUIBARAI_TTDKKR_ZEIMUNASI, "KK_DTUIBARAI_TTDKKR_ZEIMUNASI", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, KK_KZKTRKKYKDRHNK_TTDKKR, "KK_KZKTRKKYKDRHNK_TTDKKR", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, KK_KZKTRKTYOKUSOU_TTDKKR, "KK_KZKTRKTYOKUSOU_TTDKKR", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, KK_KZKTRKSKEI_TTDKKR, "KK_KZKTRKSKEI_TTDKKR", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, KK_ADRHNK_SKS, "KK_ADRHNK_SKS", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, KK_MEIGIHNK_SKS, "KK_MEIGIHNK_SKS", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, KK_STDRHNK_SKS, "KK_STDRHNK_SKS", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, KK_SEINENGAPPISEI_SKS, "KK_SEINENGAPPISEI_SKS", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, KK_GENGAKU_SKS, "KK_GENGAKU_SKS", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, KK_NKTKYKHNK_SKS, "KK_NKTKYKHNK_SKS", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, KK_TARGETHNK_SKS, "KK_TARGETHNK_SKS", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, KK_KAIYAKU_SKS, "KK_KAIYAKU_SKS", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, KK_SHRKZHNK_SKS, "KK_SHRKZHNK_SKS", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, KK_SYOSAIHK_SKS, "KK_SYOSAIHK_SKS", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, KK_KAIGOMAETKHNK_SKS, "KK_KAIGOMAETKHNK_SKS", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, KK_KAIJYO_SKS, "KK_KAIJYO_SKS", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, KK_SBKAIJYO_SKS, "KK_SBKAIJYO_SKS", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, KK_SBMENSEKI_SKS, "KK_SBMENSEKI_SKS", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, KK_HRIHEN_SKS, "KK_HRIHEN_SKS", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, KK_HRIKAIHEN_SKS, "KK_HRIKAIHEN_SKS", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, KK_HUKKATU_SKS, "KK_HUKKATU_SKS", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, KK_MOUSIDEMUKOU_SKS, "KK_MOUSIDEMUKOU_SKS", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, KK_GANMUKOU_SKS, "KK_GANMUKOU_SKS", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, KK_MKHGKHNK_SKS, "KK_MKHGKHNK_SKS", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, KK_YENDTHNKHNRKN_SKS, "KK_YENDTHNKHNRKN_SKS", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, KK_TUMITATEKINITEN_SKS, "KK_TUMITATEKINITEN_SKS", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, KK_DSHR_SKS, "KK_DSHR_SKS", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, KK_YENDTHNK_SKS, "KK_YENDTHNK_SKS", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, KK_KZKTRKKYKDRTKYKHNK_SKS, "KK_KZKTRKKYKDRTKYKHNK_SKS", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, KK_ADRHNK_SOUHU, "KK_ADRHNK_SOUHU", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, KK_MEIGIHNK_SOUHU, "KK_MEIGIHNK_SOUHU", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, KK_STDRHNK_SOUHU, "KK_STDRHNK_SOUHU", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, KK_SEINENGAPPISEI_SOUHU, "KK_SEINENGAPPISEI_SOUHU", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, KK_GENGAKU_SOUHU, "KK_GENGAKU_SOUHU", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, KK_NKTKYKHNK_SOUHU, "KK_NKTKYKHNK_SOUHU", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, KK_TARGETHNK_SOUHU, "KK_TARGETHNK_SOUHU", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, KK_KAIYAKU_SKSSOUHU, "KK_KAIYAKU_SKSSOUHU", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, KK_SHRKZHNK_SOUHU, "KK_SHRKZHNK_SOUHU", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, KK_SYOSAIHK_SOUHU, "KK_SYOSAIHK_SOUHU", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, KK_KAIGOMAETKHNK_SOUHU, "KK_KAIGOMAETKHNK_SOUHU", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, KK_SBMENSEKI_SOUHU, "KK_SBMENSEKI_SOUHU", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, KK_HRIHEN_SOUHU, "KK_HRIHEN_SOUHU", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, KK_HUKKATU_SOUHU, "KK_HUKKATU_SOUHU", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, KK_MOUSIDEMUKOU_SOUHU, "KK_MOUSIDEMUKOU_SOUHU", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, KK_GANMUKOU_SOUHU, "KK_GANMUKOU_SOUHU", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, KK_MKHGKHNK_SOUHU, "KK_MKHGKHNK_SOUHU", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, KK_YENDTHNKHNRKN_SOUHU, "KK_YENDTHNKHNRKN_SOUHU", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, KK_TUMITATEKINITEN_SOUHU, "KK_TUMITATEKINITEN_SOUHU", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, KK_DSHR_SOUHU, "KK_DSHR_SOUHU", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, KK_YENDTHNK_SOUHU, "KK_YENDTHNK_SOUHU", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, KK_KZKTRKKYKDRTKYKHNK_SOUHU, "KK_KZKTRKKYKDRTKYKHNK_SOUHU", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, KK_HUBITEISEISYO_SOUHU, "KK_HUBITEISEISYO_SOUHU", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, KK_ADRHNK_HB, "KK_ADRHNK_HB", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, KK_MEIGIHNK_HB, "KK_MEIGIHNK_HB", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, KK_STDRHNK_HB, "KK_STDRHNK_HB", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, KK_SEINENGAPPISEI_HB, "KK_SEINENGAPPISEI_HB", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, KK_GENGAKU_HB, "KK_GENGAKU_HB", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, KK_NKTKYKHNK_HB, "KK_NKTKYKHNK_HB", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, KK_TARGETHNK_HB, "KK_TARGETHNK_HB", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, KK_KAIYAKU_HB, "KK_KAIYAKU_HB", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, KK_SHRKZHNK_HB, "KK_SHRKZHNK_HB", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, KK_SYOSAIHK_HB, "KK_SYOSAIHK_HB", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, KK_KYKTORIKESI_HB, "KK_KYKTORIKESI_HB", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, KK_CLGOFF_HB, "KK_CLGOFF_HB", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, KK_KAIJYO_HB, "KK_KAIJYO_HB", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, KK_MUKOU_HB, "KK_MUKOU_HB", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, KK_SBKAIJYO_HB, "KK_SBKAIJYO_HB", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, KK_SBMENSEKI_HB, "KK_SBMENSEKI_HB", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, KK_KAIGOMAETKHNK_HB, "KK_KAIGOMAETKHNK_HB", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, KK_SBMUKOU_HB, "KK_SBMUKOU_HB", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, KK_SBMUKOUNOSHR_HB, "KK_SBMUKOUNOSHR_HB", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, KK_SBMENSEKINOSHR_HB, "KK_SBMENSEKINOSHR_HB", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, KK_HUBI_KARISAKUSEI, "KK_HUBI_KARISAKUSEI", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, KK_MKHGKHNK_HB, "KK_MKHGKHNK_HB", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, KK_YENDTHNKHNRKN_HB, "KK_YENDTHNKHNRKN_HB", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, KK_TUMITATEKINITEN_HB, "KK_TUMITATEKINITEN_HB", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, KK_DSHR_HB, "KK_DSHR_HB", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, KK_YENDTHNK_NINI_HB, "KK_YENDTHNK_NINI_HB", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, KK_KZKTRK_KYKDRTKYKHNK_HB, "KK_KZKTRK_KYKDRTKYKHNK_HB", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, KK_ADRHNK_HBLIST, "KK_ADRHNK_HBLIST", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, KK_MEIGIHNK_HBLIST, "KK_MEIGIHNK_HBLIST", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, KK_STDRHNK_HBLIST, "KK_STDRHNK_HBLIST", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, KK_SEINENGAPPISEI_HBLIST, "KK_SEINENGAPPISEI_HBLIST", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, KK_GENGAKU_HBLIST, "KK_GENGAKU_HBLIST", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, KK_NKTKYKHNK_HBLIST, "KK_NKTKYKHNK_HBLIST", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, KK_TARGETHNK_HBLIST, "KK_TARGETHNK_HBLIST", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, KK_KAIYAKU_HBLIST, "KK_KAIYAKU_HBLIST", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, KK_SHRKZHNK_HBLIST, "KK_SHRKZHNK_HBLIST", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, KK_SYOSAIHK_HBLIST, "KK_SYOSAIHK_HBLIST", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, KK_KYKTORIKESI_HBLIST, "KK_KYKTORIKESI_HBLIST", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, KK_CLGOFF_HBLIST, "KK_CLGOFF_HBLIST", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, KK_KAIJYO_HBLIST, "KK_KAIJYO_HBLIST", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, KK_MUKOU_HBLIST, "KK_MUKOU_HBLIST", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, KK_SBKAIJYO_HBLIST, "KK_SBKAIJYO_HBLIST", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, KK_SBMENSEKI_HBLIST, "KK_SBMENSEKI_HBLIST", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, KK_KAIGOMAETKHNK_HBLIST, "KK_KAIGOMAETKHNK_HBLIST", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, KK_SBMUKOU_HBLIST, "KK_SBMUKOU_HBLIST", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, KK_SBMUKOUNOSHR_HBLIST, "KK_SBMUKOUNOSHR_HBLIST", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, KK_SBMENSEKINOSHR_HBLIST, "KK_SBMENSEKINOSHR_HBLIST", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, KK_MKHGKHNK_HBLIST, "KK_MKHGKHNK_HBLIST", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, KK_YENDTHNKHNRKN_HBLIST, "KK_YENDTHNKHNRKN_HBLIST", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, KK_TUMITATEKINITEN_HBLIST, "KK_TUMITATEKINITEN_HBLIST", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, KK_DSHR_HBLIST, "KK_DSHR_HBLIST", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, KK_YENDTHNK_NINI_HBLIST, "KK_YENDTHNK_NINI_HBLIST", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, KK_KZKTRK_KYKDRTKYKHNK_HBLIST, "KK_KZKTRK_KYKDRTKYKHNK_HBLIST", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, KK_NKTKYKHNK_GAIYOU, "KK_NKTKYKHNK_GAIYOU", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, KK_KAIGOMAETK_KYKGAIYOU, "KK_KAIGOMAETK_KYKGAIYOU", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, KK_KAIGOMAETK_TYUUIKANKI, "KK_KAIGOMAETK_TYUUIKANKI", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, KK_MYNUMBER_SYORUI_GENGAKU, "KK_MYNUMBER_SYORUI_GENGAKU", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, KK_MYNUMBER_SYORUI_KAIYAKU, "KK_MYNUMBER_SYORUI_KAIYAKU", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, KK_MYNUMBER_SYORUI_YENDTHNKHNRKN, "KK_MYNUMBER_SYORUI_YENDTHNKHNRKN", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, KK_MEIGIHNK_DAIHYOUSN, "KK_MEIGIHNK_DAIHYOUSN", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, KK_KAIYAKU_DAIHYOUSN, "KK_KAIYAKU_DAIHYOUSN", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, KK_YENDTHNKHNRKN_DAIHYOUSN, "KK_YENDTHNKHNRKN_DAIHYOUSN", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, KK_MEIGIHNK_TORIHIKIKAK, "KK_MEIGIHNK_TORIHIKIKAK", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, KK_KAIYAKU_TORIHIKIKAK, "KK_KAIYAKU_TORIHIKIKAK", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, KK_SOUHUANNAI, "KK_SOUHUANNAI", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, KK_SHIHARAI_SOUHU, "KK_SHIHARAI_SOUHU", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, KK_HKNSYKN, "KK_HKNSYKN", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, KK_HKNSYKNITIJI, "KK_HKNSYKNITIJI", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, KK_SKSYOUKEN, "KK_SKSYOUKEN", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, KK_SAISYOUKEN, "KK_SAISYOUKEN", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, KK_SUIIHYOU, "KK_SUIIHYOU", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, KK_GAIKA_KOKYAKUTUUTI, "KK_GAIKA_KOKYAKUTUUTI", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, KK_SEISANDHANEITUUTI, "KK_SEISANDHANEITUUTI", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, KK_KOUJYOSYOUMEIS, "KK_KOUJYOSYOUMEIS", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, KK_KOUJYOSYOUMEIS_GAIBU, "KK_KOUJYOSYOUMEIS_GAIBU", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, KK_KOUJYOSYOUMEIS_SG, "KK_KOUJYOSYOUMEIS_SG", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, KK_SINNINTOUHYOU, "KK_SINNINTOUHYOU", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, KK_SYAINMEIBO, "KK_SYAINMEIBO", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, KK_GENKYOUTUUTI, "KK_GENKYOUTUUTI", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, KK_JIGYOUNENDOMATU, "KK_JIGYOUNENDOMATU", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, KK_SOUGOUTUUTI, "KK_SOUGOUTUUTI", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, KK_ANSINDAYORI, "KK_ANSINDAYORI", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, KK_KOUHURIMINYUUTUUTI, "KK_KOUHURIMINYUUTUUTI", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, KK_1PNYKNKANSYOUTUUTI, "KK_1PNYKNKANSYOUTUUTI", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, KK_MUKOUTUUTI, "KK_MUKOUTUUTI", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, KK_SIKKOUTUUTI, "KK_SIKKOUTUUTI", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, KK_JIMURENRAKU, "KK_JIMURENRAKU", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, KK_JIMURENRAKU_GENGAKU, "KK_JIMURENRAKU_GENGAKU", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, KK_JIMURENRAKU_SEINENGAPPISEITEISEI, "KK_JIMURENRAKU_SEINENGAPPISEITEISEI", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, KK_JIMURENRAKU_KYKTORIKESI, "KK_JIMURENRAKU_KYKTORIKESI", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, KK_JIMURENRAKU_MEIGIHNK, "KK_JIMURENRAKU_MEIGIHNK", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, KK_JIMURENRAKU_TETUDUKITYUUI, "KK_JIMURENRAKU_TETUDUKITYUUI", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, KK_SYOUKENMS_SKEI, "KK_SYOUKENMS_SKEI", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, KK_SYOUKENMS_SAI, "KK_SYOUKENMS_SAI", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, KK_SYOUKENTOKUSYU_SKEI, "KK_SYOUKENTOKUSYU_SKEI", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, KK_SYOUKENTOKUSYU_SAI, "KK_SYOUKENTOKUSYU_SAI", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, KK_INSIZEILIST_SKEI, "KK_INSIZEILIST_SKEI", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, KK_INSIZEILIST_SAI, "KK_INSIZEILIST_SAI", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, KK_TRKKZKKNRTUUTISAGYOULIST, "KK_TRKKZKKNRTUUTISAGYOULIST", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, KK_GENSENLIST, "KK_GENSENLIST", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, KK_TYOUSYOLIST_UK_KAIJYO, "KK_TYOUSYOLIST_UK_KAIJYO", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, KK_TYOUSYOLIST_UK_MENSEKI, "KK_TYOUSYOLIST_UK_MENSEKI", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, KK_TYOUSYOLIST_ITJ_KAIYAKU, "KK_TYOUSYOLIST_ITJ_KAIYAKU", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, KK_KAIYAKU_BIKINSAGYOULIST, "KK_KAIYAKU_BIKINSAGYOULIST", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, KK_KAIYAKU_BIKINJIKOUKIST, "KK_KAIYAKU_BIKINJIKOUKIST", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, KK_KH_BIKINLIST, "KK_KH_BIKINLIST", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, KK_YENDTHNK_BIKINLIST, "KK_YENDTHNK_BIKINLIST", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, KK_ZENNOUSEISANKINMEISAILIST_GENGAKU, "KK_ZENNOUSEISANKINMEISAILIST_GENGAKU", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, KK_ZENNOUSEISANKINMEISAILIST_KAIYAKU, "KK_ZENNOUSEISANKINMEISAILIST_KAIYAKU", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, KK_MKKPHENKINLIST_GENGAKU, "KK_MKKPHENKINLIST_GENGAKU", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, KK_MKKPHENKINLIST_KAIYAKU, "KK_MKKPHENKINLIST_KAIYAKU", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, KK_AZUKARIKINLIST, "KK_AZUKARIKINLIST", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, KK_AZUKARIKIN_BIKINLIST, "KK_AZUKARIKIN_BIKINLIST", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, KK_SYOURAIW_SISANHYOU, "KK_SYOURAIW_SISANHYOU", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, KK_HNGKUNEIHIKAKLIST, "KK_HNGKUNEIHIKAKLIST", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, KK_KACHECK_YOHURI_MISSLIST, "KK_KACHECK_YOHURI_MISSLIST", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, KK_KACHECK_SHRKZ_MISSLIST, "KK_KACHECK_SHRKZ_MISSLIST", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, KK_KYKINFOTORIKOMI_MISSLIST, "KK_KYKINFOTORIKOMI_MISSLIST", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, KK_SHRKEKKATORIKOMI_MISSLIST, "KK_SHRKEKKATORIKOMI_MISSLIST", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, KK_KZHURIANNAISEL_MISSLIST, "KK_KZHURIANNAISEL_MISSLIST", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, KK_YUUKOUKEKKAHANEI_MISSLIST, "KK_YUUKOUKEKKAHANEI_MISSLIST", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, KK_AUTHORIKEKKAHANEI_MISSLIST, "KK_AUTHORIKEKKAHANEI_MISSLIST", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, KK_URIAGEKEKKATRSKS_MISSLIST, "KK_URIAGEKEKKATRSKS_MISSLIST", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, KK_NYUUKIN_MISSLIST, "KK_NYUUKIN_MISSLIST", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, KK_LINC_MISSLIST, "KK_LINC_MISSLIST", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, KK_MINYUUITIRAN, "KK_MINYUUITIRAN", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, KK_SIKKOUITIRAN, "KK_SIKKOUITIRAN", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, KK_HANDKARIKANJYOU, "KK_HANDKARIKANJYOU", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, KK_DHANEI_MISSLIST, "KK_DHANEI_MISSLIST", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, KK_BATCHKAIYAKU_MISSLIST, "KK_BATCHKAIYAKU_MISSLIST", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, KK_YENDTHNK_MISSLIST, "KK_YENDTHNK_MISSLIST", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, KK_YENDTHNKSEL_MISSLIST, "KK_YENDTHNKSEL_MISSLIST", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, KK_SEISANDHANEI_MISSLIST, "KK_SEISANDHANEI_MISSLIST", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, KK_DSEISAN_MISSLIST, "KK_DSEISAN_MISSLIST", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, KK_SISUURENDOTMTTKNHANEI_MISSLIST, "KK_SISUURENDOTMTTKNHANEI_MISSLIST", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, KK_GAIKAKOKYAKUTUUTISKS_MISSLIST, "KK_GAIKAKOKYAKUTUUTISKS_MISSLIST", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, KK_BATCHMKHGKHENKOU_MISSLIST, "KK_BATCHMKHGKHENKOU_MISSLIST", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, KK_SEIKYUKNK_SYOSAIHK, "KK_SEIKYUKNK_SYOSAIHK", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, KK_HUBIKNK_SYOSAIHK, "KK_HUBIKNK_SYOSAIHK", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, KK_SEIKYUKNK_MEIGIHNK, "KK_SEIKYUKNK_MEIGIHNK", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, KK_HUBIKNK_MEIGIHNK, "KK_HUBIKNK_MEIGIHNK", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, KK_SEIKYUKNK_SEINENGAPPISEI, "KK_SEIKYUKNK_SEINENGAPPISEI", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, KK_HUBIKNK_SEINENGAPPISEI, "KK_HUBIKNK_SEINENGAPPISEI", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, KK_SEIKYUKNK_GENGAKU, "KK_SEIKYUKNK_GENGAKU", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, KK_HUBIKNK_GENGAKU, "KK_HUBIKNK_GENGAKU", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, KK_SEIKYUKNK_KAIYAKU, "KK_SEIKYUKNK_KAIYAKU", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, KK_HUBIKNK_KAIYAKU, "KK_HUBIKNK_KAIYAKU", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, KK_TODOKEDEKNK_ADRHNK, "KK_TODOKEDEKNK_ADRHNK", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, KK_HUBIKNK_ADRHNK, "KK_HUBIKNK_ADRHNK", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, KK_SEIKYUKNK_STDRSKYTKYK, "KK_SEIKYUKNK_STDRSKYTKYK", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, KK_HUBIKNK_STDRSKYTKYK, "KK_HUBIKNK_STDRSKYTKYK", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, KK_SEIKYUKNK_KAIGOMAETKHNK, "KK_SEIKYUKNK_KAIGOMAETKHNK", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, KK_HUBIKNK_KAIGOMAETKHNK, "KK_HUBIKNK_KAIGOMAETKHNK", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, KK_SEIKYUKNK_MKHGKHNK, "KK_SEIKYUKNK_MKHGKHNK", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, KK_HUBIKNK_MKHGKHNK, "KK_HUBIKNK_MKHGKHNK", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, KK_SEIKYUKNK_YENDTHNKHNRKN, "KK_SEIKYUKNK_YENDTHNKHNRKN", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, KK_HUBIKNK_YENDTHNKHNRKN, "KK_HUBIKNK_YENDTHNKHNRKN", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, KK_SEIKYUKNK_TUMITATEKINITEN, "KK_SEIKYUKNK_TUMITATEKINITEN", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, KK_HUBIKNK_TUMITATEKINITEN, "KK_HUBIKNK_TUMITATEKINITEN", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, KK_SEIKYUKNK_DSHR, "KK_SEIKYUKNK_DSHR", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, KK_HUBIKNK_DSHR, "KK_HUBIKNK_DSHR", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, KK_SEIKYUKNK_YENDTHNK_NINI, "KK_SEIKYUKNK_YENDTHNK_NINI", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, KK_HUBIKNK_YENDTHNK_NINI, "KK_HUBIKNK_YENDTHNK_NINI", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, KK_HUBIKNK_KYKTORIKESI, "KK_HUBIKNK_KYKTORIKESI", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, KK_HUBIKNK_CLGOFF, "KK_HUBIKNK_CLGOFF", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, KK_HUBIKNK_KAIJYO, "KK_HUBIKNK_KAIJYO", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, KK_HUBIKNK_MUKOU, "KK_HUBIKNK_MUKOU", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, KK_HUBIKNK_SBKAIJYO, "KK_HUBIKNK_SBKAIJYO", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, KK_HUBIKNK_SBMENSEKI, "KK_HUBIKNK_SBMENSEKI", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, KK_HUBIKNK_SBMUKOU, "KK_HUBIKNK_SBMUKOU", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, KK_HUBIKNK_SBMUKOUNOSHR, "KK_HUBIKNK_SBMUKOUNOSHR", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, KK_HUBIKNK_SBMENSEKINOSHR, "KK_HUBIKNK_SBMENSEKINOSHR", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, KK_SEIKYUKNK_KZKTRKKYKDRHNK, "KK_SEIKYUKNK_KZKTRKKYKDRHNK", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, KK_HUBIKNK_KZKTRKKYKDRHNK, "KK_HUBIKNK_KZKTRKKYKDRHNK", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, AS_KRKKN_SEIBITOKUSOKULIST_1, "AS_KRKKN_SEIBITOKUSOKULIST_1", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, AS_KRKKN_SEIBITOKUSOKULIST_2, "AS_KRKKN_SEIBITOKUSOKULIST_2", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, AS_DATTAI_MIKAISYOULIST, "AS_DATTAI_MIKAISYOULIST", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, AS_HRHNTTDKANNAI, "AS_HRHNTTDKANNAI", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, AS_PKZHRIKEIRAI, "AS_PKZHRIKEIRAI", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, AS_PHRKKAISUUHENKOUMOS, "AS_PHRKKAISUUHENKOUMOS", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, AS_CREDITCARDMOS, "AS_CREDITCARDMOS", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, AS_HRHNKANRYOTUUTI, "AS_HRHNKANRYOTUUTI", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, AS_HRHN_HB, "AS_HRHN_HB", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, AS_HRHN_HBLIST, "AS_HRHN_HBLIST", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, AS_SAIGAITOKUSINKEIYAKUHOYUULIST, "AS_SAIGAITOKUSINKEIYAKUHOYUULIST", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, AS_ZENNOUTOUKEILIST, "AS_ZENNOUTOUKEILIST", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, AS_ZENNOUMKKPKSSAMPLELIST, "AS_ZENNOUMKKPKSSAMPLELIST", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, AS_PMINYUUSYOUMETUHRBKNLIST, "AS_PMINYUUSYOUMETUHRBKNLIST", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, AS_SYOUMETUTUUTI, "AS_SYOUMETUTUUTI", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, AS_SYOUMETUTUUTI_SHRSKS, "AS_SYOUMETUTUUTI_SHRSKS", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, AS_SYOUMETUKEIYAKULIST, "AS_SYOUMETUKEIYAKULIST", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, AS_JIMURENRAKU_SYUUNOU, "AS_JIMURENRAKU_SYUUNOU", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, AS_MISSLIST_SYUUNOU, "AS_MISSLIST_SYUUNOU", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, AS_PMINYUUSYOUMETU_MISSLIST, "AS_PMINYUUSYOUMETU_MISSLIST", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, AS_URIAGESEIKYUUKEKKA_ERRORLIST, "AS_URIAGESEIKYUUKEKKA_ERRORLIST", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, AS_CREDITTOUROKUKENSUULIST, "AS_CREDITTOUROKUKENSUULIST", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, AS_YUUKOUKAKUNIN_ERRORLIST, "AS_YUUKOUKAKUNIN_ERRORLIST", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, AS_MINUSURIAGEKYKDTLLIST, "AS_MINUSURIAGEKYKDTLLIST", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, AS_MOSKNK_HRHN, "AS_MOSKNK_HRHN", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, AS_HUBIKNK_HRHN, "AS_HUBIKNK_HRHN", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, NK_SKS_ITJ, "NK_SKS_ITJ", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, NK_SKS_SIBOU, "NK_SKS_SIBOU", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, NK_SKS_MGHNK, "NK_SKS_MGHNK", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, NK_SKS_KZHNK, "NK_SKS_KZHNK", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, NK_SKS_KAISUHNK, "NK_SKS_KAISUHNK", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, NK_SKS_SAIHAKKOU, "NK_SKS_SAIHAKKOU", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, NK_SKS_TK_STDRSKTKY, "NK_SKS_TK_STDRSKTKY", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, NK_SKS_TK_KKNKUKT, "NK_SKS_TK_KKNKUKT", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, NK_SKS_D_UKTRHOU_HK, "NK_SKS_D_UKTRHOU_HK", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, NK_SOUHU_ITJ, "NK_SOUHU_ITJ", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, NK_SOUHU_SIBOU, "NK_SOUHU_SIBOU", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, NK_SOUHU_MGHNK, "NK_SOUHU_MGHNK", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, NK_SOUHU_KZHNK, "NK_SOUHU_KZHNK", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, NK_SOUHU_KAISUHNK, "NK_SOUHU_KAISUHNK", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, NK_SOUHU_SAIHAKKOU, "NK_SOUHU_SAIHAKKOU", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, NK_SOUHU_TK_STDRSKTKY, "NK_SOUHU_TK_STDRSKTKY", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, NK_SOUHU_TK_KKNKUKT, "NK_SOUHU_TK_KKNKUKT", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, NK_SOUHU_D_UKTRHOU_HK, "NK_SOUHU_D_UKTRHOU_HK", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, NK_HUBI_ITJ, "NK_HUBI_ITJ", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, NK_HUBI_SIBOU, "NK_HUBI_SIBOU", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, NK_HUBI_MGHNK, "NK_HUBI_MGHNK", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, NK_HUBI_KZHNK, "NK_HUBI_KZHNK", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, NK_HUBI_KAISUHNK, "NK_HUBI_KAISUHNK", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, NK_HUBI_SAIHAKKOU, "NK_HUBI_SAIHAKKOU", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, NK_HUBI_TK_STDRSKTKY, "NK_HUBI_TK_STDRSKTKY", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, NK_HUBI_TK_KKNKUKT, "NK_HUBI_TK_KKNKUKT", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, NK_SOUHU_HUBI_ITJ, "NK_SOUHU_HUBI_ITJ", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, NK_SOUHU_HUBI_SIBOU, "NK_SOUHU_HUBI_SIBOU", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, NK_SOUHU_HUBI_MGHNK, "NK_SOUHU_HUBI_MGHNK", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, NK_SOUHU_HUBI_KZHNK, "NK_SOUHU_HUBI_KZHNK", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, NK_SOUHU_HUBI_KAISUHNK, "NK_SOUHU_HUBI_KAISUHNK", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, NK_SOUHU_HUBI_SAIHAKKOU, "NK_SOUHU_HUBI_SAIHAKKOU", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, NK_SOUHU_HUBI_TK_STDRSKTKY, "NK_SOUHU_HUBI_TK_STDRSKTKY", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, NK_SOUHU_HUBI_TK_KKNKUKT, "NK_SOUHU_HUBI_TK_KKNKUKT", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, NK_DAIHYOUSENNINTDK, "NK_DAIHYOUSENNINTDK", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, NK_NKTRKM_MISSLIST, "NK_NKTRKM_MISSLIST", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, NK_JDSHR_MISSLIST, "NK_JDSHR_MISSLIST", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, NK_KSCHK_MISSLIST, "NK_KSCHK_MISSLIST", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, NK_GNSNLIST, "NK_GNSNLIST", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, NK_HUBIMIKAISYOULIST, "NK_HUBIMIKAISYOULIST", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, NK_TYOUSYOLIST_NK, "NK_TYOUSYOLIST_NK", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, NK_TYOUSYOLIST_ITJ_NK, "NK_TYOUSYOLIST_ITJ_NK", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, NK_TYOUSYOLIST_UK_NK, "NK_TYOUSYOLIST_UK_NK", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, SK_JIMURENRAKU, "SK_JIMURENRAKU", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, SK_HUBITUUTI, "SK_HUBITUUTI", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, SK_KYKKAKUNINIRAISYO, "SK_KYKKAKUNINIRAISYO", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, SK_KYKKAKUNINKAITOUSYO, "SK_KYKKAKUNINKAITOUSYO", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, SK_YUUKOUKKNYOKOKULIST, "SK_YUUKOUKKNYOKOKULIST", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, SK_YUUKOUKKNTYOUKALIST, "SK_YUUKOUKKNTYOUKALIST", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, SK_KYKHUSEIRITU, "SK_KYKHUSEIRITU", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, SK_TRKSSEIKYU, "SK_TRKSSEIKYU", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, SK_TTDKKR, "SK_TTDKKR", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, SK_SMBCSINTYOKUMISSLIST, "SK_SMBCSINTYOKUMISSLIST", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, SK_SENTAKINFOMISSLIST, "SK_SENTAKINFOMISSLIST", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, SK_KEIYAKUNAIYOTOROKUSEIDOSYOKAIHYO, "SK_KEIYAKUNAIYOTOROKUSEIDOSYOKAIHYO", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, SK_HURIKOMINYKNSAKUJOMISSLIST, "SK_HURIKOMINYKNSAKUJOMISSLIST", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, SK_HURIKOMINYKNTEISEILIST_ENKA, "SK_HURIKOMINYKNTEISEILIST_ENKA", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, SK_SAKUJOKYKMEISAILIST, "SK_SAKUJOKYKMEISAILIST", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, SK_JIDOUNYKNMEISAILIST, "SK_JIDOUNYKNMEISAILIST", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, SK_1PNYKNITTILIST, "SK_1PNYKNITTILIST", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, SK_NYKJYOUHOUHUITTIKAKSYO, "SK_NYKJYOUHOUHUITTIKAKSYO", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, SK_MOSSOUHUJYOUKYOULIST, "SK_MOSSOUHUJYOUKYOULIST", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, SK_MOSMITOUTYAKUKKNLIST, "SK_MOSMITOUTYAKUKKNLIST", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, SK_HURIKOMINYKNTEISEILIST_GAIKA, "SK_HURIKOMINYKNTEISEILIST_GAIKA", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, SK_SIKINIDOULIST_HRKMKZHUITTI, "SK_SIKINIDOULIST_HRKMKZHUITTI", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, SK_HURIKOMINYKNTEISEILIST_ENKA_YENDT, "SK_HURIKOMINYKNTEISEILIST_ENKA_YENDT", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, SK_SAKUJOKYKMEISAILIST_YENDT, "SK_SAKUJOKYKMEISAILIST_YENDT", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, SK_JIDOUNYKNMEISAILIST_YENDT, "SK_JIDOUNYKNMEISAILIST_YENDT", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, SK_1PNYKNITTILIST_YENDT, "SK_1PNYKNITTILIST_YENDT", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, SK_NYKJYOUHOUHUITTIKAKSYO_YENDT, "SK_NYKJYOUHOUHUITTIKAKSYO_YENDT", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, SK_MOSMITOUTYAKUKKNLIST_YENDT, "SK_MOSMITOUTYAKUKKNLIST_YENDT", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, SK_HENKINIRAISYO, "SK_HENKINIRAISYO", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, SK_HENKINTUUTILIST, "SK_HENKINTUUTILIST", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, SK_HANDKARIKANJYOU, "SK_HANDKARIKANJYOU", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, SK_HENKINMISYORILIST, "SK_HENKINMISYORILIST", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, SK_HANDKARIKANJYOU_YENDT, "SK_HANDKARIKANJYOU_YENDT", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, SK_HENKINMISYORILIST_YENDT, "SK_HENKINMISYORILIST_YENDT", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, SK_CREDITQRTOUROKUMIHANEILIST, "SK_CREDITQRTOUROKUMIHANEILIST", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, SK_CREDITCARDKAIINTOUROKUNGLIST, "SK_CREDITCARDKAIINTOUROKUNGLIST", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, SK_CREDITCARDTOUROKUHANEIERRORLIST, "SK_CREDITCARDTOUROKUHANEIERRORLIST", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, SK_YUUKOUHANEIKAKUNINKEKKALIST, "SK_YUUKOUHANEIKAKUNINKEKKALIST", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, SK_FSTPURIAGESEIKYUUERRORLIST, "SK_FSTPURIAGESEIKYUUERRORLIST", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, SK_FSTPURIAGESEIKYUUMEISAI_JCB, "SK_FSTPURIAGESEIKYUUMEISAI_JCB", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, SK_FSTPURIAGESEIKYUUMEISAI_VISA, "SK_FSTPURIAGESEIKYUUMEISAI_VISA", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, SK_KOUFURITOUROKUMIHANEILIST, "SK_KOUFURITOUROKUMIHANEILIST", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, SK_KOUFURITOUROKUHANEIERRORLIST, "SK_KOUFURITOUROKUHANEIERRORLIST", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, SK_KARIUKEHUHOPKAKIN1MKEIKA, "SK_KARIUKEHUHOPKAKIN1MKEIKA", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, SK_GETUMATUZANDAKACHKLIST, "SK_GETUMATUZANDAKACHKLIST", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, SK_MSRKARIUKEKINMEISAI, "SK_MSRKARIUKEKINMEISAI", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, SK_MSRJIYUUMEISAI_NYKNHUBI, "SK_MSRJIYUUMEISAI_NYKNHUBI", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, SK_MSRJIYUUMEISAI_SYORUIHUBI_TAN, "SK_MSRJIYUUMEISAI_SYORUIHUBI_TAN", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, SK_MSRJIYUUMEISAI_SYORUIHUBI_HUKU, "SK_MSRJIYUUMEISAI_SYORUIHUBI_HUKU", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, SK_MSRJIYUUMEISAI_SEIRITUHRYUUUKTKTYUU, "SK_MSRJIYUUMEISAI_SEIRITUHRYUUUKTKTYUU", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, SK_MSRJIYUUBETUKARIUKEKINSYUUKEI, "SK_MSRJIYUUBETUKARIUKEKINSYUUKEI", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, SK_MSRJIYUUBETUKARIUKEKINMEISAILIST, "SK_MSRJIYUUBETUKARIUKEKINMEISAILIST", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, SK_JIDSYUUNOUSYOUGOUMEISAI_KESSAN, "SK_JIDSYUUNOUSYOUGOUMEISAI_KESSAN", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, SK_KARIUKEKINPKAKINMEISAI, "SK_KARIUKEKINPKAKINMEISAI", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, SK_KARIUKEKINPKAKINZANDAKAMEISAILIST, "SK_KARIUKEKINPKAKINZANDAKAMEISAILIST", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, SK_HUKUSUUKAINYUUKINKAWASESASONEKI, "SK_HUKUSUUKAINYUUKINKAWASESASONEKI", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, SK_KARIUKEHUHOPKAKIN1MKEIKA_YENDT, "SK_KARIUKEHUHOPKAKIN1MKEIKA_YENDT", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, SK_GETUMATUZANDAKACHKLIST_YENDT, "SK_GETUMATUZANDAKACHKLIST_YENDT", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, SK_MSRKARIUKEKINMEISAI_YENDT, "SK_MSRKARIUKEKINMEISAI_YENDT", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, SK_MSRJIYUUMEISAI_NYKNHUBI_YENDT, "SK_MSRJIYUUMEISAI_NYKNHUBI_YENDT", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, SK_MSRJIYUUMEISAI_SYORUIHUBI_TAN_YENDT, "SK_MSRJIYUUMEISAI_SYORUIHUBI_TAN_YENDT", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, SK_MSRJIYUUMEISAI_SYORUIHUBI_HUKU_YENDT, "SK_MSRJIYUUMEISAI_SYORUIHUBI_HUKU_YENDT", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, SK_MSRJIYUUMEISAI_SEIRITUHRYUUUKTKTYUU_YENDT, "SK_MSRJIYUUMEISAI_SEIRITUHRYUUUKTKTYUU_YENDT", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, SK_MSRJIYUUBETUKARIUKEKINSYUUKEI_YENDT, "SK_MSRJIYUUBETUKARIUKEKINSYUUKEI_YENDT", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, SK_MSRJIYUUBETUKARIUKEKINMEISAILIST_YENDT, "SK_MSRJIYUUBETUKARIUKEKINMEISAILIST_YENDT", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, SK_JIDSYUUNOUSYOUGOUMEISAI_KESSAN_YENDT, "SK_JIDSYUUNOUSYOUGOUMEISAI_KESSAN_YENDT", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, SK_KARIUKEKINPKAKINMEISAI_YENDT, "SK_KARIUKEKINPKAKINMEISAI_YENDT", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, SK_KARIUKEKINPKAKINZANDAKAMEISAILIST_YENDT, "SK_KARIUKEKINPKAKINZANDAKAMEISAILIST_YENDT", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, SR_OIKOMISYUUKEIHYOUTYOUSEI, "SR_OIKOMISYUUKEIHYOUTYOUSEI", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, SR_OIKOMISYUUKEIPDENPYOU, "SR_OIKOMISYUUKEIPDENPYOU", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, SR_TMTTDMEISAILIST, "SR_TMTTDMEISAILIST", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, SR_KBNKEIRIYOUTMTTDMEISAILIST, "SR_KBNKEIRIYOUTMTTDMEISAILIST", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, SR_KARIWARIATEDMEISAILIS, "SR_KARIWARIATEDMEISAILIS", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, SR_BIKINKYKSEISANDLIST, "SR_BIKINKYKSEISANDLIST", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, SR_KBNKEIRIYOUBIKINKYKSEISANDLIST, "SR_KBNKEIRIYOUBIKINKYKSEISANDLIST", false);
        addPattern(PATTERN_TYOHYOIKATUSYUTURYOKU, SR_BIKINKYKKARIWARIATEDLIST, "SR_BIKINKYKKARIWARIATEDLIST", false);


        addPattern(PATTERN_KESSANYOUHUBISYORUIHYJ, SK_MOSSYO, "SK_MOSSYO", false);
        addPattern(PATTERN_KESSANYOUHUBISYORUIHYJ, SK_KOKUSYO, "SK_KOKUSYO", false);
        addPattern(PATTERN_KESSANYOUHUBISYORUIHYJ, SK_IKOUKAKSYO, "SK_IKOUKAKSYO", false);
        addPattern(PATTERN_KESSANYOUHUBISYORUIHYJ, SK_UKTHUKUSUUSITEI, "SK_UKTHUKUSUUSITEI", false);
        addPattern(PATTERN_KESSANYOUHUBISYORUIHYJ, SK_UKTJIZENSYOUKAI, "SK_UKTJIZENSYOUKAI", false);
        addPattern(PATTERN_KESSANYOUHUBISYORUIHYJ, SK_DAISANSYAUKTHOUSYO, "SK_DAISANSYAUKTHOUSYO", false);
        addPattern(PATTERN_KESSANYOUHUBISYORUIHYJ, SK_TORIHOUSYO, "SK_TORIHOUSYO", false);
        addPattern(PATTERN_KESSANYOUHUBISYORUIHYJ, SK_SEIMEIPKZHURIKAEMOSSYO, "SK_SEIMEIPKZHURIKAEMOSSYO", false);
        addPattern(PATTERN_KESSANYOUHUBISYORUIHYJ, SK_SONOTAHUZOKU, "SK_SONOTAHUZOKU", false);


        addPattern(PATTERN_SKHUBITOUROKU, BLNK, "BLNK", true);
        addPattern(PATTERN_SKHUBITOUROKU, SK_MOSSYO, "SK_MOSSYO", false);
        addPattern(PATTERN_SKHUBITOUROKU, SK_IKOUKAKSYO, "SK_IKOUKAKSYO", false);
        addPattern(PATTERN_SKHUBITOUROKU, SK_UKTHUKUSUUSITEI, "SK_UKTHUKUSUUSITEI", false);
        addPattern(PATTERN_SKHUBITOUROKU, SK_UKTJIZENSYOUKAI, "SK_UKTJIZENSYOUKAI", false);
        addPattern(PATTERN_SKHUBITOUROKU, SK_DAISANSYAUKTHOUSYO, "SK_DAISANSYAUKTHOUSYO", false);
        addPattern(PATTERN_SKHUBITOUROKU, SK_TORIHOUSYO, "SK_TORIHOUSYO", false);
        addPattern(PATTERN_SKHUBITOUROKU, SK_SEIMEIPKZHURIKAEMOSSYO, "SK_SEIMEIPKZHURIKAEMOSSYO", false);
        addPattern(PATTERN_SKHUBITOUROKU, SK_SONOTAHUZOKU, "SK_SONOTAHUZOKU", false);


        lock(C_SyoruiCdKbn.class);
    }

    private C_SyoruiCdKbn(String value) {
        super(value);
    }

    public static C_SyoruiCdKbn valueOf(String value) {
        return valueOf(C_SyoruiCdKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_SyoruiCdKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_SyoruiCdKbn.class, patternId, value);
    }
}
