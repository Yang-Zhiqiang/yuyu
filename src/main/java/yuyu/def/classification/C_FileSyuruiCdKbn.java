
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * ファイル種類コード区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_FileSyuruiCdKbn</td><td colspan="3">ファイル種類コード区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="110">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SK_TEISEIKOUMOKULST}</td><td>&quot;Sk001&quot;</td><td>訂正項目リスト</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SK_HUBIMIKAISYOLST}</td><td>&quot;Sk002&quot;</td><td>新契約不備未解消リスト</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SK_HUBIBUNSEKILST}</td><td>&quot;Sk003&quot;</td><td>新契約不備分析リスト</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SK_KOUSEIINKYKLST}</td><td>&quot;Sk004&quot;</td><td>構成員契約リスト</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SK_KOUKANKYKLST}</td><td>&quot;Sk005&quot;</td><td>交換契約リスト</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SK_ITJBRZOUTOKKYKPDAILY}</td><td>&quot;Sk006&quot;</td><td>一時払増額特約付契約Ｐ集計リスト</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SK_ITJBRZOUTOKKYKPMONTHLY}</td><td>&quot;Sk007&quot;</td><td>前月一時払増額特約付契約Ｐ集計リスト</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SK_SIBOUGENINMIHANEILIST}</td><td>&quot;Sk008&quot;</td><td>死亡原因未反映リスト</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SK_MOSMATICSV}</td><td>&quot;Sk009&quot;</td><td>申込書類未到着ＣＳＶ</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SK_TOUGETUHASINHUBIITIRAN}</td><td>&quot;Sk010&quot;</td><td>当月発信不備一覧</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SK_SHOPTEIKYOUHUBIITIRAN}</td><td>&quot;Sk011&quot;</td><td>ショップ提供用不備一覧</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SK_MONITORINGDATACSVFCOOLINGOFF}</td><td>&quot;Sk012&quot;</td><td>新契約モニタリングデータＣＳＶＦ（クーリングオフ）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SK_IKTNYUUKINKAWASESAEKI}</td><td>&quot;Sk013&quot;</td><td>一括入金為替差益リスト</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SK_IKTNYUUKINKAWASESAEKISIHANKI}</td><td>&quot;Sk014&quot;</td><td>一括入金為替差益リスト（四半期）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SK_NITPPLESSHUBICSV}</td><td>&quot;Sk015&quot;</td><td>ＮＩＴペーパーレス不備ＣＳＶ</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SK_MOSMATICSV_YENDT}</td><td>&quot;Sk016&quot;</td><td>申込書類未到着ＣＳＶ（円建）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SK_THANKSCALLKEIYAKUITIRAN}</td><td>&quot;Sk017&quot;</td><td>サンクスコール対象契約一覧</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SK_QRTIGINGLOBAL}</td><td>&quot;Sk101&quot;</td><td>外部用ＱＲデータ（地銀信金・５年ごと利差配当付指定通貨建終身保険（一時払い））</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SK_QRSMTBGLOBAL}</td><td>&quot;Sk102&quot;</td><td>外部用ＱＲデータ（ＳＭＴＢ・５年ごと利差配当付指定通貨建終身保険（一時払い））</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SK_QRSHOPGLOBAL}</td><td>&quot;Sk103&quot;</td><td>外部用ＱＲデータ（ショップ・５年ごと利差配当付指定通貨建終身保険（一時払い））</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SK_QRDATA}</td><td>&quot;Sk104&quot;</td><td>外部用ＱＲデータ</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KH_KAIYAKUMOUSIDEUKTKDATA}</td><td>&quot;Kh001&quot;</td><td>解約申出受付データ</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KH_SOUKIKAIYAKUDATA}</td><td>&quot;Kh002&quot;</td><td>早期解約データ（銀行）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KH_UKTKAIJOSHRTYSYSEITO}</td><td>&quot;Kh004&quot;</td><td>受取人別（解除）支払調書（正当分）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KH_UKTKAIJOSHRTYSYKAKU}</td><td>&quot;Kh005&quot;</td><td>受取人別（解除）支払調書（確認分）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KH_UKTMENSKSHRTYSYSEITO}</td><td>&quot;Kh006&quot;</td><td>受取人別（免責）支払調書（正当分）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KH_UKTMENSKSHRTYSYKAKU}</td><td>&quot;Kh007&quot;</td><td>受取人別（免責）支払調書（確認分）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KH_ITJKAIYKSHRTYSYSEITO}</td><td>&quot;Kh008&quot;</td><td>一時金（解約）支払調書（正当分）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KH_ITJKAIYKSHRTYSYKAKU}</td><td>&quot;Kh009&quot;</td><td>一時金（解約）支払調書（確認分）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KH_FATCAREKINENHKKDATA}</td><td>&quot;Kh010&quot;</td><td>ＦＡＴＣＡ暦年報告データ</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KH_FATCATEIKITYOUSADATA}</td><td>&quot;Kh011&quot;</td><td>ＦＡＴＣＡ定期調査要データ</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KH_FATCAMONITORKYKDATAKAK}</td><td>&quot;Kh012&quot;</td><td>ＦＡＴＣＡモニタリング確認中契約データ</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KH_FATCAMONITORKYKDATA}</td><td>&quot;Kh013&quot;</td><td>ＦＡＴＣＡモニタリング確認契約データ</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KH_BIKINSGYLSTCSVFKAIYAKU}</td><td>&quot;Kh014&quot;</td><td>解約備金作業リストＣＳＶＦ</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KH_BIKINSGYLSTCSVFGENGAKU}</td><td>&quot;Kh015&quot;</td><td>契約変更備金リストＣＳＶＦ</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KH_BIKINJIKOULSTCSVFKAIYAKU}</td><td>&quot;Kh016&quot;</td><td>解約備金時効リストＣＳＶＦ</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KH_AEOIMONITORKYKDATA}</td><td>&quot;Kh017&quot;</td><td>ＡＥＯＩモニタリング契約データ</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KH_AEOIREKINENHKKDATA}</td><td>&quot;Kh018&quot;</td><td>ＡＥＯＩ暦年報告データ</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KH_BIKINLSTCSVFYENDTHNKHR}</td><td>&quot;Kh019&quot;</td><td>円建変更時返戻金備金リストＣＳＶＦ</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KH_SEIRITUKYKDTLFILE}</td><td>&quot;Kh020&quot;</td><td>成立契約明細ファイル</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KH_SEISANDTUIHRTAISYOUDATA}</td><td>&quot;Kh021&quot;</td><td>精算Ｄ追払対象データ</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KH_KZKPYOKUJYUUTOUYOTEICSVF}</td><td>&quot;Kh022&quot;</td><td>継続Ｐ翌月充当予定ＣＳＶＦ</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KH_ITIJIBRHYUKYKINFOFILE}</td><td>&quot;Kh023&quot;</td><td>一時払保有契約情報ＣＳＶＦ</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KH_ZENNOUSEISANKINDTLLSTCSVFKAIYAKU}</td><td>&quot;Kh024&quot;</td><td>前納精算金明細リストＣＳＶＦ（解約）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KH_MIKEIKAPHENKINLSTCSVFKAIYAKU}</td><td>&quot;Kh025&quot;</td><td>未経過Ｐ返金リストＣＳＶＦ（解約）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KH_ZENNOUSEISANKINDTLLSTCSVFGENGAKU}</td><td>&quot;Kh026&quot;</td><td>前納精算金明細リストＣＳＶＦ（減額）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KH_MIKEIKAPHENKINLSTCSVFGENGAKU}</td><td>&quot;Kh027&quot;</td><td>未経過Ｐ返金リストＣＳＶＦ（減額）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KH_AZUKARIKINBIKINLSTCSVF}</td><td>&quot;Kh028&quot;</td><td>預り金備金リストＣＳＶＦ</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KH_AZUKARIKINLSTCSVF}</td><td>&quot;Kh029&quot;</td><td>預り金リストＣＳＶＦ</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KH_SOUKIKAIYAKUKENSUUDATACSVF}</td><td>&quot;Kh030&quot;</td><td>契約保全早期解約件数データＣＳＶＦ</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KH_UKTHENKOUKENSUUDATACSVF}</td><td>&quot;Kh031&quot;</td><td>契約保全受取人変更件数データＣＳＶＦ</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KH_KZMEIGISITEIKENSUUDATACSVF}</td><td>&quot;Kh032&quot;</td><td>契約保全保険料払込口座名義指定件数データＣＳＶＦ</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KH_MONITORINGDATACSVFSOUKIKAIYAKU}</td><td>&quot;Kh033&quot;</td><td>契約保全モニタリングデータＣＳＶＦ（早期解約）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KH_MONITORINGDATACSVFUKTHENKOU}</td><td>&quot;Kh034&quot;</td><td>契約保全モニタリングデータＣＳＶＦ（受取人変更）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KH_MONITORINGDATACSVFCOOLINGOFF}</td><td>&quot;Kh035&quot;</td><td>契約保全モニタリングデータＣＳＶＦ（クーリングオフ）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KH_MONITORINGDATACSVFPEPS}</td><td>&quot;Kh036&quot;</td><td>契約保全モニタリングデータＣＳＶＦ（ＰＥＰｓ）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KH_YENDTHNKKYKCSVF}</td><td>&quot;Kh037&quot;</td><td>円建変更契約ＣＳＶＦ</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KH_TMTTKINYSKCSVF}</td><td>&quot;Kh038&quot;</td><td>積立金予測ＣＳＶＦ</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SI_HIGAITOUITIRANTJT}</td><td>&quot;Si001&quot;</td><td>非該当一覧（当日分）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SI_HIGAITOUITIRAN2WEEK}</td><td>&quot;Si002&quot;</td><td>非該当一覧（２週間後）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SI_HIGAITOUITIRANTORIKOMI}</td><td>&quot;Si003&quot;</td><td>非該当一覧取込リスト</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SI_SBKARIUKEINFO}</td><td>&quot;Si004&quot;</td><td>死亡仮受付情報</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SI_KAKUNINLIST}</td><td>&quot;Si005&quot;</td><td>確認登録リスト</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SI_HUBILIST}</td><td>&quot;Si006&quot;</td><td>不備登録リスト</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SI_TUIKATRKMSYORUILST}</td><td>&quot;Si007&quot;</td><td>追加取込書類リスト</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SI_UKTHKNKNSHRTYSYSEITO}</td><td>&quot;Si008&quot;</td><td>受取人別（保険金）支払調書（正当分）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SI_UKTHKNKNSHRTYSYKAKU}</td><td>&quot;Si009&quot;</td><td>受取人別（保険金）支払調書（確認分）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SI_SHRSYOYOUNISSUUCSV}</td><td>&quot;Si010&quot;</td><td>支払所要日数用ＣＳＶ</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SI_SISYAHKNKN}</td><td>&quot;Si011&quot;</td><td>支社別保険金種類別集計Ｆ</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SI_KBNKEIRIKYKMEISAI}</td><td>&quot;Si012&quot;</td><td>区分経理用支払契約明細表</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SI_KBNKEIRIKYKSYUUKEI}</td><td>&quot;Si013&quot;</td><td>区分経理用支払契約集計表</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SI_BIKINSGYLSTCSVFHKN}</td><td>&quot;Si014&quot;</td><td>備金作業リストＣＳＶＦ（保険金）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SI_BIKINJIKOULSTCSVFHKN}</td><td>&quot;Si015&quot;</td><td>備金時効リストＣＳＶＦ（保険金）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SI_SHRBIKINSYKCSVFHKN}</td><td>&quot;Si016&quot;</td><td>支払備金集計ＣＳＶＦ（保険金）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SI_IBNRMEISAI}</td><td>&quot;Si017&quot;</td><td>ＩＢＮＲ備金明細表</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SI_ZEIMUHENREIMEISAI}</td><td>&quot;Si018&quot;</td><td>税務及び返戻金備金明細表</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SI_BIKINTYOUSA}</td><td>&quot;Si019&quot;</td><td>支払保険金備金調査Ｆ</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SI_SEIKYUUINFO}</td><td>&quot;Si020&quot;</td><td>請求情報Ｆ</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SI_ZENNOUSEISANKINMEISAIFILE}</td><td>&quot;Si021&quot;</td><td>前納精算金明細ファイル（保険金）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SI_BIKINMIKEIKAPHENKINFILE}</td><td>&quot;Si022&quot;</td><td>備金未経過Ｐ返金ファイル（保険金）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SI_BIKINMISYUPKEIJYOUFILE}</td><td>&quot;Si023&quot;</td><td>備金未収Ｐ計上ファイル（保険金）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SI_BUNKATUSIHARAIKEISAN}</td><td>&quot;Si024&quot;</td><td>分割支払計算ファイル</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SI_IBNRMEISAIF}</td><td>&quot;Si025&quot;</td><td>ＩＢＮＲ備金明細Ｆ</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SI_JIKOUTAISYOULIST}</td><td>&quot;Si026&quot;</td><td>時効対象リスト</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SI_JIKOUDENMEISAILISTCSVF}</td><td>&quot;Si027&quot;</td><td>時効伝票明細リストＣＳＶＦ</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NK_NNKNSHRTYSY}</td><td>&quot;Nk001&quot;</td><td>年金支払調書</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NK_ZATUSYTKNAYOSECSV}</td><td>&quot;Nk002&quot;</td><td>雑所得用名寄せＣＳＶ</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NK_NNKNSHRTYSYKAKU}</td><td>&quot;Nk003&quot;</td><td>年金支払調書（確認分）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NK_NNKNSHRTYSYGOUKEIF}</td><td>&quot;Nk004&quot;</td><td>年金支払調書合計ファイル</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NK_ITJNNKNSHRTYSYSEITO}</td><td>&quot;Nk005&quot;</td><td>一時金（年金）支払調書（正当分）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NK_ITJNNKNSHRTYSYKAKU}</td><td>&quot;Nk006&quot;</td><td>一時金（年金）支払調書（確認分）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NK_UKTNNKNSHRTYSYSEITO}</td><td>&quot;Nk007&quot;</td><td>受取人別（年金）支払調書（正当分）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NK_UKTNNKNSHRTYSYKAKU}</td><td>&quot;Nk008&quot;</td><td>受取人別（年金）支払調書（確認分）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SU_HNGKNNKNHYUKYKDATA}</td><td>&quot;Su001&quot;</td><td>変額年金保有契約データ</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SU_HNGKHKNDISCLOSEDATA}</td><td>&quot;Su002&quot;</td><td>変額保険ディスクローズデータ</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #BZ_ACCLOGGETUJIFILE}</td><td>&quot;Bz001&quot;</td><td>アクセスログ月次ファイル</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #BZ_KYKIDOUHANEIKEKKACSVF}</td><td>&quot;Bz002&quot;</td><td>普保Ⅱ契約異動反映結果ＣＳＶＦ</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #BZ_SNTKINFOHANEIKEKKACSVF}</td><td>&quot;Bz003&quot;</td><td>普保Ⅱ選択情報反映ＣＳＶＦ</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #BZ_SINKEIYAKUSYORIKENSUUSYOUKAICSVF}</td><td>&quot;Bz004&quot;</td><td>新契約処理件数照会ＣＳＶＦ</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #BZ_SIHARAISYORIKENSUUSYOUKAICSVF}</td><td>&quot;Bz005&quot;</td><td>保険金給付金支払処理件数照会ＣＳＶＦ</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #BZ_HOZENSYORIKENSUUSYOUKAICSVF}</td><td>&quot;Bz006&quot;</td><td>契約保全処理件数照会ＣＳＶＦ</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #BZ_GAIKAHOKENMEISAICSVF}</td><td>&quot;Bz007&quot;</td><td>外貨建保険明細ＣＳＶＦ</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #DS_NEUGOKIHANTEIKEKKAFILE}</td><td>&quot;Ds001&quot;</td><td>値動き判定結果ファイル</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #DS_TOUKEIFILE}</td><td>&quot;Ds002&quot;</td><td>ＤＳ統計ファイル</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #AS_SOUKISYOUMETUDATA}</td><td>&quot;As001&quot;</td><td>早期消滅データ</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #AS_PMINYUUSYOUMETUHRBKNLIST}</td><td>&quot;As002&quot;</td><td>Ｐ未入消滅時返戻金備金リストＣＳＶＦ</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #AS_PMINYUUSYOUMETUSK}</td><td>&quot;As003&quot;</td><td>Ｐ未入消滅請求勧奨用ＣＳＶＦ</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #AS_KAWASERATETUUTIDATA}</td><td>&quot;As004&quot;</td><td>為替レート通知用ＣＳＶＦ</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #BZ_SIKINIDOULISTSIKINIDOUBICSVF}</td><td>&quot;Bz008&quot;</td><td>資金移動リストＣＳＶＦ</td></tr>
 * </table>
 */
public class C_FileSyuruiCdKbn extends Classification<C_FileSyuruiCdKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_FileSyuruiCdKbn BLNK = new C_FileSyuruiCdKbn("0");

    public static final C_FileSyuruiCdKbn SK_TEISEIKOUMOKULST = new C_FileSyuruiCdKbn("Sk001");

    public static final C_FileSyuruiCdKbn SK_HUBIMIKAISYOLST = new C_FileSyuruiCdKbn("Sk002");

    public static final C_FileSyuruiCdKbn SK_HUBIBUNSEKILST = new C_FileSyuruiCdKbn("Sk003");

    public static final C_FileSyuruiCdKbn SK_KOUSEIINKYKLST = new C_FileSyuruiCdKbn("Sk004");

    public static final C_FileSyuruiCdKbn SK_KOUKANKYKLST = new C_FileSyuruiCdKbn("Sk005");

    public static final C_FileSyuruiCdKbn SK_ITJBRZOUTOKKYKPDAILY = new C_FileSyuruiCdKbn("Sk006");

    public static final C_FileSyuruiCdKbn SK_ITJBRZOUTOKKYKPMONTHLY = new C_FileSyuruiCdKbn("Sk007");

    public static final C_FileSyuruiCdKbn SK_SIBOUGENINMIHANEILIST = new C_FileSyuruiCdKbn("Sk008");

    public static final C_FileSyuruiCdKbn SK_MOSMATICSV = new C_FileSyuruiCdKbn("Sk009");

    public static final C_FileSyuruiCdKbn SK_TOUGETUHASINHUBIITIRAN = new C_FileSyuruiCdKbn("Sk010");

    public static final C_FileSyuruiCdKbn SK_SHOPTEIKYOUHUBIITIRAN = new C_FileSyuruiCdKbn("Sk011");

    public static final C_FileSyuruiCdKbn SK_MONITORINGDATACSVFCOOLINGOFF = new C_FileSyuruiCdKbn("Sk012");

    public static final C_FileSyuruiCdKbn SK_IKTNYUUKINKAWASESAEKI = new C_FileSyuruiCdKbn("Sk013");

    public static final C_FileSyuruiCdKbn SK_IKTNYUUKINKAWASESAEKISIHANKI = new C_FileSyuruiCdKbn("Sk014");

    public static final C_FileSyuruiCdKbn SK_NITPPLESSHUBICSV = new C_FileSyuruiCdKbn("Sk015");

    public static final C_FileSyuruiCdKbn SK_MOSMATICSV_YENDT = new C_FileSyuruiCdKbn("Sk016");

    public static final C_FileSyuruiCdKbn SK_THANKSCALLKEIYAKUITIRAN = new C_FileSyuruiCdKbn("Sk017");

    public static final C_FileSyuruiCdKbn SK_QRTIGINGLOBAL = new C_FileSyuruiCdKbn("Sk101");

    public static final C_FileSyuruiCdKbn SK_QRSMTBGLOBAL = new C_FileSyuruiCdKbn("Sk102");

    public static final C_FileSyuruiCdKbn SK_QRSHOPGLOBAL = new C_FileSyuruiCdKbn("Sk103");

    public static final C_FileSyuruiCdKbn SK_QRDATA = new C_FileSyuruiCdKbn("Sk104");

    public static final C_FileSyuruiCdKbn KH_KAIYAKUMOUSIDEUKTKDATA = new C_FileSyuruiCdKbn("Kh001");

    public static final C_FileSyuruiCdKbn KH_SOUKIKAIYAKUDATA = new C_FileSyuruiCdKbn("Kh002");

    public static final C_FileSyuruiCdKbn KH_UKTKAIJOSHRTYSYSEITO = new C_FileSyuruiCdKbn("Kh004");

    public static final C_FileSyuruiCdKbn KH_UKTKAIJOSHRTYSYKAKU = new C_FileSyuruiCdKbn("Kh005");

    public static final C_FileSyuruiCdKbn KH_UKTMENSKSHRTYSYSEITO = new C_FileSyuruiCdKbn("Kh006");

    public static final C_FileSyuruiCdKbn KH_UKTMENSKSHRTYSYKAKU = new C_FileSyuruiCdKbn("Kh007");

    public static final C_FileSyuruiCdKbn KH_ITJKAIYKSHRTYSYSEITO = new C_FileSyuruiCdKbn("Kh008");

    public static final C_FileSyuruiCdKbn KH_ITJKAIYKSHRTYSYKAKU = new C_FileSyuruiCdKbn("Kh009");

    public static final C_FileSyuruiCdKbn KH_FATCAREKINENHKKDATA = new C_FileSyuruiCdKbn("Kh010");

    public static final C_FileSyuruiCdKbn KH_FATCATEIKITYOUSADATA = new C_FileSyuruiCdKbn("Kh011");

    public static final C_FileSyuruiCdKbn KH_FATCAMONITORKYKDATAKAK = new C_FileSyuruiCdKbn("Kh012");

    public static final C_FileSyuruiCdKbn KH_FATCAMONITORKYKDATA = new C_FileSyuruiCdKbn("Kh013");

    public static final C_FileSyuruiCdKbn KH_BIKINSGYLSTCSVFKAIYAKU = new C_FileSyuruiCdKbn("Kh014");

    public static final C_FileSyuruiCdKbn KH_BIKINSGYLSTCSVFGENGAKU = new C_FileSyuruiCdKbn("Kh015");

    public static final C_FileSyuruiCdKbn KH_BIKINJIKOULSTCSVFKAIYAKU = new C_FileSyuruiCdKbn("Kh016");

    public static final C_FileSyuruiCdKbn KH_AEOIMONITORKYKDATA = new C_FileSyuruiCdKbn("Kh017");

    public static final C_FileSyuruiCdKbn KH_AEOIREKINENHKKDATA = new C_FileSyuruiCdKbn("Kh018");

    public static final C_FileSyuruiCdKbn KH_BIKINLSTCSVFYENDTHNKHR = new C_FileSyuruiCdKbn("Kh019");

    public static final C_FileSyuruiCdKbn KH_SEIRITUKYKDTLFILE = new C_FileSyuruiCdKbn("Kh020");

    public static final C_FileSyuruiCdKbn KH_SEISANDTUIHRTAISYOUDATA = new C_FileSyuruiCdKbn("Kh021");

    public static final C_FileSyuruiCdKbn KH_KZKPYOKUJYUUTOUYOTEICSVF = new C_FileSyuruiCdKbn("Kh022");

    public static final C_FileSyuruiCdKbn KH_ITIJIBRHYUKYKINFOFILE = new C_FileSyuruiCdKbn("Kh023");

    public static final C_FileSyuruiCdKbn KH_ZENNOUSEISANKINDTLLSTCSVFKAIYAKU = new C_FileSyuruiCdKbn("Kh024");

    public static final C_FileSyuruiCdKbn KH_MIKEIKAPHENKINLSTCSVFKAIYAKU = new C_FileSyuruiCdKbn("Kh025");

    public static final C_FileSyuruiCdKbn KH_ZENNOUSEISANKINDTLLSTCSVFGENGAKU = new C_FileSyuruiCdKbn("Kh026");

    public static final C_FileSyuruiCdKbn KH_MIKEIKAPHENKINLSTCSVFGENGAKU = new C_FileSyuruiCdKbn("Kh027");

    public static final C_FileSyuruiCdKbn KH_AZUKARIKINBIKINLSTCSVF = new C_FileSyuruiCdKbn("Kh028");

    public static final C_FileSyuruiCdKbn KH_AZUKARIKINLSTCSVF = new C_FileSyuruiCdKbn("Kh029");

    public static final C_FileSyuruiCdKbn KH_SOUKIKAIYAKUKENSUUDATACSVF = new C_FileSyuruiCdKbn("Kh030");

    public static final C_FileSyuruiCdKbn KH_UKTHENKOUKENSUUDATACSVF = new C_FileSyuruiCdKbn("Kh031");

    public static final C_FileSyuruiCdKbn KH_KZMEIGISITEIKENSUUDATACSVF = new C_FileSyuruiCdKbn("Kh032");

    public static final C_FileSyuruiCdKbn KH_MONITORINGDATACSVFSOUKIKAIYAKU = new C_FileSyuruiCdKbn("Kh033");

    public static final C_FileSyuruiCdKbn KH_MONITORINGDATACSVFUKTHENKOU = new C_FileSyuruiCdKbn("Kh034");

    public static final C_FileSyuruiCdKbn KH_MONITORINGDATACSVFCOOLINGOFF = new C_FileSyuruiCdKbn("Kh035");

    public static final C_FileSyuruiCdKbn KH_MONITORINGDATACSVFPEPS = new C_FileSyuruiCdKbn("Kh036");

    public static final C_FileSyuruiCdKbn KH_YENDTHNKKYKCSVF = new C_FileSyuruiCdKbn("Kh037");

    public static final C_FileSyuruiCdKbn KH_TMTTKINYSKCSVF = new C_FileSyuruiCdKbn("Kh038");

    public static final C_FileSyuruiCdKbn SI_HIGAITOUITIRANTJT = new C_FileSyuruiCdKbn("Si001");

    public static final C_FileSyuruiCdKbn SI_HIGAITOUITIRAN2WEEK = new C_FileSyuruiCdKbn("Si002");

    public static final C_FileSyuruiCdKbn SI_HIGAITOUITIRANTORIKOMI = new C_FileSyuruiCdKbn("Si003");

    public static final C_FileSyuruiCdKbn SI_SBKARIUKEINFO = new C_FileSyuruiCdKbn("Si004");

    public static final C_FileSyuruiCdKbn SI_KAKUNINLIST = new C_FileSyuruiCdKbn("Si005");

    public static final C_FileSyuruiCdKbn SI_HUBILIST = new C_FileSyuruiCdKbn("Si006");

    public static final C_FileSyuruiCdKbn SI_TUIKATRKMSYORUILST = new C_FileSyuruiCdKbn("Si007");

    public static final C_FileSyuruiCdKbn SI_UKTHKNKNSHRTYSYSEITO = new C_FileSyuruiCdKbn("Si008");

    public static final C_FileSyuruiCdKbn SI_UKTHKNKNSHRTYSYKAKU = new C_FileSyuruiCdKbn("Si009");

    public static final C_FileSyuruiCdKbn SI_SHRSYOYOUNISSUUCSV = new C_FileSyuruiCdKbn("Si010");

    public static final C_FileSyuruiCdKbn SI_SISYAHKNKN = new C_FileSyuruiCdKbn("Si011");

    public static final C_FileSyuruiCdKbn SI_KBNKEIRIKYKMEISAI = new C_FileSyuruiCdKbn("Si012");

    public static final C_FileSyuruiCdKbn SI_KBNKEIRIKYKSYUUKEI = new C_FileSyuruiCdKbn("Si013");

    public static final C_FileSyuruiCdKbn SI_BIKINSGYLSTCSVFHKN = new C_FileSyuruiCdKbn("Si014");

    public static final C_FileSyuruiCdKbn SI_BIKINJIKOULSTCSVFHKN = new C_FileSyuruiCdKbn("Si015");

    public static final C_FileSyuruiCdKbn SI_SHRBIKINSYKCSVFHKN = new C_FileSyuruiCdKbn("Si016");

    public static final C_FileSyuruiCdKbn SI_IBNRMEISAI = new C_FileSyuruiCdKbn("Si017");

    public static final C_FileSyuruiCdKbn SI_ZEIMUHENREIMEISAI = new C_FileSyuruiCdKbn("Si018");

    public static final C_FileSyuruiCdKbn SI_BIKINTYOUSA = new C_FileSyuruiCdKbn("Si019");

    public static final C_FileSyuruiCdKbn SI_SEIKYUUINFO = new C_FileSyuruiCdKbn("Si020");

    public static final C_FileSyuruiCdKbn SI_ZENNOUSEISANKINMEISAIFILE = new C_FileSyuruiCdKbn("Si021");

    public static final C_FileSyuruiCdKbn SI_BIKINMIKEIKAPHENKINFILE = new C_FileSyuruiCdKbn("Si022");

    public static final C_FileSyuruiCdKbn SI_BIKINMISYUPKEIJYOUFILE = new C_FileSyuruiCdKbn("Si023");

    public static final C_FileSyuruiCdKbn SI_BUNKATUSIHARAIKEISAN = new C_FileSyuruiCdKbn("Si024");

    public static final C_FileSyuruiCdKbn SI_IBNRMEISAIF = new C_FileSyuruiCdKbn("Si025");

    public static final C_FileSyuruiCdKbn SI_JIKOUTAISYOULIST = new C_FileSyuruiCdKbn("Si026");

    public static final C_FileSyuruiCdKbn SI_JIKOUDENMEISAILISTCSVF = new C_FileSyuruiCdKbn("Si027");

    public static final C_FileSyuruiCdKbn NK_NNKNSHRTYSY = new C_FileSyuruiCdKbn("Nk001");

    public static final C_FileSyuruiCdKbn NK_ZATUSYTKNAYOSECSV = new C_FileSyuruiCdKbn("Nk002");

    public static final C_FileSyuruiCdKbn NK_NNKNSHRTYSYKAKU = new C_FileSyuruiCdKbn("Nk003");

    public static final C_FileSyuruiCdKbn NK_NNKNSHRTYSYGOUKEIF = new C_FileSyuruiCdKbn("Nk004");

    public static final C_FileSyuruiCdKbn NK_ITJNNKNSHRTYSYSEITO = new C_FileSyuruiCdKbn("Nk005");

    public static final C_FileSyuruiCdKbn NK_ITJNNKNSHRTYSYKAKU = new C_FileSyuruiCdKbn("Nk006");

    public static final C_FileSyuruiCdKbn NK_UKTNNKNSHRTYSYSEITO = new C_FileSyuruiCdKbn("Nk007");

    public static final C_FileSyuruiCdKbn NK_UKTNNKNSHRTYSYKAKU = new C_FileSyuruiCdKbn("Nk008");

    public static final C_FileSyuruiCdKbn SU_HNGKNNKNHYUKYKDATA = new C_FileSyuruiCdKbn("Su001");

    public static final C_FileSyuruiCdKbn SU_HNGKHKNDISCLOSEDATA = new C_FileSyuruiCdKbn("Su002");

    public static final C_FileSyuruiCdKbn BZ_ACCLOGGETUJIFILE = new C_FileSyuruiCdKbn("Bz001");

    public static final C_FileSyuruiCdKbn BZ_KYKIDOUHANEIKEKKACSVF = new C_FileSyuruiCdKbn("Bz002");

    public static final C_FileSyuruiCdKbn BZ_SNTKINFOHANEIKEKKACSVF = new C_FileSyuruiCdKbn("Bz003");

    public static final C_FileSyuruiCdKbn BZ_SINKEIYAKUSYORIKENSUUSYOUKAICSVF = new C_FileSyuruiCdKbn("Bz004");

    public static final C_FileSyuruiCdKbn BZ_SIHARAISYORIKENSUUSYOUKAICSVF = new C_FileSyuruiCdKbn("Bz005");

    public static final C_FileSyuruiCdKbn BZ_HOZENSYORIKENSUUSYOUKAICSVF = new C_FileSyuruiCdKbn("Bz006");

    public static final C_FileSyuruiCdKbn BZ_GAIKAHOKENMEISAICSVF = new C_FileSyuruiCdKbn("Bz007");

    public static final C_FileSyuruiCdKbn DS_NEUGOKIHANTEIKEKKAFILE = new C_FileSyuruiCdKbn("Ds001");

    public static final C_FileSyuruiCdKbn DS_TOUKEIFILE = new C_FileSyuruiCdKbn("Ds002");

    public static final C_FileSyuruiCdKbn AS_SOUKISYOUMETUDATA = new C_FileSyuruiCdKbn("As001");

    public static final C_FileSyuruiCdKbn AS_PMINYUUSYOUMETUHRBKNLIST = new C_FileSyuruiCdKbn("As002");

    public static final C_FileSyuruiCdKbn AS_PMINYUUSYOUMETUSK = new C_FileSyuruiCdKbn("As003");

    public static final C_FileSyuruiCdKbn AS_KAWASERATETUUTIDATA = new C_FileSyuruiCdKbn("As004");

    public static final C_FileSyuruiCdKbn BZ_SIKINIDOULISTSIKINIDOUBICSVF = new C_FileSyuruiCdKbn("Bz008");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, SK_TEISEIKOUMOKULST, "SK_TEISEIKOUMOKULST", false);
        addPattern(PATTERN_DEFAULT, SK_HUBIMIKAISYOLST, "SK_HUBIMIKAISYOLST", false);
        addPattern(PATTERN_DEFAULT, SK_HUBIBUNSEKILST, "SK_HUBIBUNSEKILST", false);
        addPattern(PATTERN_DEFAULT, SK_KOUSEIINKYKLST, "SK_KOUSEIINKYKLST", false);
        addPattern(PATTERN_DEFAULT, SK_KOUKANKYKLST, "SK_KOUKANKYKLST", false);
        addPattern(PATTERN_DEFAULT, SK_ITJBRZOUTOKKYKPDAILY, "SK_ITJBRZOUTOKKYKPDAILY", false);
        addPattern(PATTERN_DEFAULT, SK_ITJBRZOUTOKKYKPMONTHLY, "SK_ITJBRZOUTOKKYKPMONTHLY", false);
        addPattern(PATTERN_DEFAULT, SK_SIBOUGENINMIHANEILIST, "SK_SIBOUGENINMIHANEILIST", false);
        addPattern(PATTERN_DEFAULT, SK_MOSMATICSV, "SK_MOSMATICSV", false);
        addPattern(PATTERN_DEFAULT, SK_TOUGETUHASINHUBIITIRAN, "SK_TOUGETUHASINHUBIITIRAN", false);
        addPattern(PATTERN_DEFAULT, SK_SHOPTEIKYOUHUBIITIRAN, "SK_SHOPTEIKYOUHUBIITIRAN", false);
        addPattern(PATTERN_DEFAULT, SK_MONITORINGDATACSVFCOOLINGOFF, "SK_MONITORINGDATACSVFCOOLINGOFF", false);
        addPattern(PATTERN_DEFAULT, SK_IKTNYUUKINKAWASESAEKI, "SK_IKTNYUUKINKAWASESAEKI", false);
        addPattern(PATTERN_DEFAULT, SK_IKTNYUUKINKAWASESAEKISIHANKI, "SK_IKTNYUUKINKAWASESAEKISIHANKI", false);
        addPattern(PATTERN_DEFAULT, SK_NITPPLESSHUBICSV, "SK_NITPPLESSHUBICSV", false);
        addPattern(PATTERN_DEFAULT, SK_MOSMATICSV_YENDT, "SK_MOSMATICSV_YENDT", false);
        addPattern(PATTERN_DEFAULT, SK_THANKSCALLKEIYAKUITIRAN, "SK_THANKSCALLKEIYAKUITIRAN", false);
        addPattern(PATTERN_DEFAULT, SK_QRTIGINGLOBAL, "SK_QRTIGINGLOBAL", false);
        addPattern(PATTERN_DEFAULT, SK_QRSMTBGLOBAL, "SK_QRSMTBGLOBAL", false);
        addPattern(PATTERN_DEFAULT, SK_QRSHOPGLOBAL, "SK_QRSHOPGLOBAL", false);
        addPattern(PATTERN_DEFAULT, SK_QRDATA, "SK_QRDATA", false);
        addPattern(PATTERN_DEFAULT, KH_KAIYAKUMOUSIDEUKTKDATA, "KH_KAIYAKUMOUSIDEUKTKDATA", false);
        addPattern(PATTERN_DEFAULT, KH_SOUKIKAIYAKUDATA, "KH_SOUKIKAIYAKUDATA", false);
        addPattern(PATTERN_DEFAULT, KH_UKTKAIJOSHRTYSYSEITO, "KH_UKTKAIJOSHRTYSYSEITO", false);
        addPattern(PATTERN_DEFAULT, KH_UKTKAIJOSHRTYSYKAKU, "KH_UKTKAIJOSHRTYSYKAKU", false);
        addPattern(PATTERN_DEFAULT, KH_UKTMENSKSHRTYSYSEITO, "KH_UKTMENSKSHRTYSYSEITO", false);
        addPattern(PATTERN_DEFAULT, KH_UKTMENSKSHRTYSYKAKU, "KH_UKTMENSKSHRTYSYKAKU", false);
        addPattern(PATTERN_DEFAULT, KH_ITJKAIYKSHRTYSYSEITO, "KH_ITJKAIYKSHRTYSYSEITO", false);
        addPattern(PATTERN_DEFAULT, KH_ITJKAIYKSHRTYSYKAKU, "KH_ITJKAIYKSHRTYSYKAKU", false);
        addPattern(PATTERN_DEFAULT, KH_FATCAREKINENHKKDATA, "KH_FATCAREKINENHKKDATA", false);
        addPattern(PATTERN_DEFAULT, KH_FATCATEIKITYOUSADATA, "KH_FATCATEIKITYOUSADATA", false);
        addPattern(PATTERN_DEFAULT, KH_FATCAMONITORKYKDATAKAK, "KH_FATCAMONITORKYKDATAKAK", false);
        addPattern(PATTERN_DEFAULT, KH_FATCAMONITORKYKDATA, "KH_FATCAMONITORKYKDATA", false);
        addPattern(PATTERN_DEFAULT, KH_BIKINSGYLSTCSVFKAIYAKU, "KH_BIKINSGYLSTCSVFKAIYAKU", false);
        addPattern(PATTERN_DEFAULT, KH_BIKINSGYLSTCSVFGENGAKU, "KH_BIKINSGYLSTCSVFGENGAKU", false);
        addPattern(PATTERN_DEFAULT, KH_BIKINJIKOULSTCSVFKAIYAKU, "KH_BIKINJIKOULSTCSVFKAIYAKU", false);
        addPattern(PATTERN_DEFAULT, KH_AEOIMONITORKYKDATA, "KH_AEOIMONITORKYKDATA", false);
        addPattern(PATTERN_DEFAULT, KH_AEOIREKINENHKKDATA, "KH_AEOIREKINENHKKDATA", false);
        addPattern(PATTERN_DEFAULT, KH_BIKINLSTCSVFYENDTHNKHR, "KH_BIKINLSTCSVFYENDTHNKHR", false);
        addPattern(PATTERN_DEFAULT, KH_SEIRITUKYKDTLFILE, "KH_SEIRITUKYKDTLFILE", false);
        addPattern(PATTERN_DEFAULT, KH_SEISANDTUIHRTAISYOUDATA, "KH_SEISANDTUIHRTAISYOUDATA", false);
        addPattern(PATTERN_DEFAULT, KH_KZKPYOKUJYUUTOUYOTEICSVF, "KH_KZKPYOKUJYUUTOUYOTEICSVF", false);
        addPattern(PATTERN_DEFAULT, KH_ITIJIBRHYUKYKINFOFILE, "KH_ITIJIBRHYUKYKINFOFILE", false);
        addPattern(PATTERN_DEFAULT, KH_ZENNOUSEISANKINDTLLSTCSVFKAIYAKU, "KH_ZENNOUSEISANKINDTLLSTCSVFKAIYAKU", false);
        addPattern(PATTERN_DEFAULT, KH_MIKEIKAPHENKINLSTCSVFKAIYAKU, "KH_MIKEIKAPHENKINLSTCSVFKAIYAKU", false);
        addPattern(PATTERN_DEFAULT, KH_ZENNOUSEISANKINDTLLSTCSVFGENGAKU, "KH_ZENNOUSEISANKINDTLLSTCSVFGENGAKU", false);
        addPattern(PATTERN_DEFAULT, KH_MIKEIKAPHENKINLSTCSVFGENGAKU, "KH_MIKEIKAPHENKINLSTCSVFGENGAKU", false);
        addPattern(PATTERN_DEFAULT, KH_AZUKARIKINBIKINLSTCSVF, "KH_AZUKARIKINBIKINLSTCSVF", false);
        addPattern(PATTERN_DEFAULT, KH_AZUKARIKINLSTCSVF, "KH_AZUKARIKINLSTCSVF", false);
        addPattern(PATTERN_DEFAULT, KH_SOUKIKAIYAKUKENSUUDATACSVF, "KH_SOUKIKAIYAKUKENSUUDATACSVF", false);
        addPattern(PATTERN_DEFAULT, KH_UKTHENKOUKENSUUDATACSVF, "KH_UKTHENKOUKENSUUDATACSVF", false);
        addPattern(PATTERN_DEFAULT, KH_KZMEIGISITEIKENSUUDATACSVF, "KH_KZMEIGISITEIKENSUUDATACSVF", false);
        addPattern(PATTERN_DEFAULT, KH_MONITORINGDATACSVFSOUKIKAIYAKU, "KH_MONITORINGDATACSVFSOUKIKAIYAKU", false);
        addPattern(PATTERN_DEFAULT, KH_MONITORINGDATACSVFUKTHENKOU, "KH_MONITORINGDATACSVFUKTHENKOU", false);
        addPattern(PATTERN_DEFAULT, KH_MONITORINGDATACSVFCOOLINGOFF, "KH_MONITORINGDATACSVFCOOLINGOFF", false);
        addPattern(PATTERN_DEFAULT, KH_MONITORINGDATACSVFPEPS, "KH_MONITORINGDATACSVFPEPS", false);
        addPattern(PATTERN_DEFAULT, KH_YENDTHNKKYKCSVF, "KH_YENDTHNKKYKCSVF", false);
        addPattern(PATTERN_DEFAULT, KH_TMTTKINYSKCSVF, "KH_TMTTKINYSKCSVF", false);
        addPattern(PATTERN_DEFAULT, SI_HIGAITOUITIRANTJT, "SI_HIGAITOUITIRANTJT", false);
        addPattern(PATTERN_DEFAULT, SI_HIGAITOUITIRAN2WEEK, "SI_HIGAITOUITIRAN2WEEK", false);
        addPattern(PATTERN_DEFAULT, SI_HIGAITOUITIRANTORIKOMI, "SI_HIGAITOUITIRANTORIKOMI", false);
        addPattern(PATTERN_DEFAULT, SI_SBKARIUKEINFO, "SI_SBKARIUKEINFO", false);
        addPattern(PATTERN_DEFAULT, SI_KAKUNINLIST, "SI_KAKUNINLIST", false);
        addPattern(PATTERN_DEFAULT, SI_HUBILIST, "SI_HUBILIST", false);
        addPattern(PATTERN_DEFAULT, SI_TUIKATRKMSYORUILST, "SI_TUIKATRKMSYORUILST", false);
        addPattern(PATTERN_DEFAULT, SI_UKTHKNKNSHRTYSYSEITO, "SI_UKTHKNKNSHRTYSYSEITO", false);
        addPattern(PATTERN_DEFAULT, SI_UKTHKNKNSHRTYSYKAKU, "SI_UKTHKNKNSHRTYSYKAKU", false);
        addPattern(PATTERN_DEFAULT, SI_SHRSYOYOUNISSUUCSV, "SI_SHRSYOYOUNISSUUCSV", false);
        addPattern(PATTERN_DEFAULT, SI_SISYAHKNKN, "SI_SISYAHKNKN", false);
        addPattern(PATTERN_DEFAULT, SI_KBNKEIRIKYKMEISAI, "SI_KBNKEIRIKYKMEISAI", false);
        addPattern(PATTERN_DEFAULT, SI_KBNKEIRIKYKSYUUKEI, "SI_KBNKEIRIKYKSYUUKEI", false);
        addPattern(PATTERN_DEFAULT, SI_BIKINSGYLSTCSVFHKN, "SI_BIKINSGYLSTCSVFHKN", false);
        addPattern(PATTERN_DEFAULT, SI_BIKINJIKOULSTCSVFHKN, "SI_BIKINJIKOULSTCSVFHKN", false);
        addPattern(PATTERN_DEFAULT, SI_SHRBIKINSYKCSVFHKN, "SI_SHRBIKINSYKCSVFHKN", false);
        addPattern(PATTERN_DEFAULT, SI_IBNRMEISAI, "SI_IBNRMEISAI", false);
        addPattern(PATTERN_DEFAULT, SI_ZEIMUHENREIMEISAI, "SI_ZEIMUHENREIMEISAI", false);
        addPattern(PATTERN_DEFAULT, SI_BIKINTYOUSA, "SI_BIKINTYOUSA", false);
        addPattern(PATTERN_DEFAULT, SI_SEIKYUUINFO, "SI_SEIKYUUINFO", false);
        addPattern(PATTERN_DEFAULT, SI_ZENNOUSEISANKINMEISAIFILE, "SI_ZENNOUSEISANKINMEISAIFILE", false);
        addPattern(PATTERN_DEFAULT, SI_BIKINMIKEIKAPHENKINFILE, "SI_BIKINMIKEIKAPHENKINFILE", false);
        addPattern(PATTERN_DEFAULT, SI_BIKINMISYUPKEIJYOUFILE, "SI_BIKINMISYUPKEIJYOUFILE", false);
        addPattern(PATTERN_DEFAULT, SI_BUNKATUSIHARAIKEISAN, "SI_BUNKATUSIHARAIKEISAN", false);
        addPattern(PATTERN_DEFAULT, SI_IBNRMEISAIF, "SI_IBNRMEISAIF", false);
        addPattern(PATTERN_DEFAULT, SI_JIKOUTAISYOULIST, "SI_JIKOUTAISYOULIST", false);
        addPattern(PATTERN_DEFAULT, SI_JIKOUDENMEISAILISTCSVF, "SI_JIKOUDENMEISAILISTCSVF", false);
        addPattern(PATTERN_DEFAULT, NK_NNKNSHRTYSY, "NK_NNKNSHRTYSY", false);
        addPattern(PATTERN_DEFAULT, NK_ZATUSYTKNAYOSECSV, "NK_ZATUSYTKNAYOSECSV", false);
        addPattern(PATTERN_DEFAULT, NK_NNKNSHRTYSYKAKU, "NK_NNKNSHRTYSYKAKU", false);
        addPattern(PATTERN_DEFAULT, NK_NNKNSHRTYSYGOUKEIF, "NK_NNKNSHRTYSYGOUKEIF", false);
        addPattern(PATTERN_DEFAULT, NK_ITJNNKNSHRTYSYSEITO, "NK_ITJNNKNSHRTYSYSEITO", false);
        addPattern(PATTERN_DEFAULT, NK_ITJNNKNSHRTYSYKAKU, "NK_ITJNNKNSHRTYSYKAKU", false);
        addPattern(PATTERN_DEFAULT, NK_UKTNNKNSHRTYSYSEITO, "NK_UKTNNKNSHRTYSYSEITO", false);
        addPattern(PATTERN_DEFAULT, NK_UKTNNKNSHRTYSYKAKU, "NK_UKTNNKNSHRTYSYKAKU", false);
        addPattern(PATTERN_DEFAULT, SU_HNGKNNKNHYUKYKDATA, "SU_HNGKNNKNHYUKYKDATA", false);
        addPattern(PATTERN_DEFAULT, SU_HNGKHKNDISCLOSEDATA, "SU_HNGKHKNDISCLOSEDATA", false);
        addPattern(PATTERN_DEFAULT, BZ_ACCLOGGETUJIFILE, "BZ_ACCLOGGETUJIFILE", false);
        addPattern(PATTERN_DEFAULT, BZ_KYKIDOUHANEIKEKKACSVF, "BZ_KYKIDOUHANEIKEKKACSVF", false);
        addPattern(PATTERN_DEFAULT, BZ_SNTKINFOHANEIKEKKACSVF, "BZ_SNTKINFOHANEIKEKKACSVF", false);
        addPattern(PATTERN_DEFAULT, BZ_SINKEIYAKUSYORIKENSUUSYOUKAICSVF, "BZ_SINKEIYAKUSYORIKENSUUSYOUKAICSVF", false);
        addPattern(PATTERN_DEFAULT, BZ_SIHARAISYORIKENSUUSYOUKAICSVF, "BZ_SIHARAISYORIKENSUUSYOUKAICSVF", false);
        addPattern(PATTERN_DEFAULT, BZ_HOZENSYORIKENSUUSYOUKAICSVF, "BZ_HOZENSYORIKENSUUSYOUKAICSVF", false);
        addPattern(PATTERN_DEFAULT, BZ_GAIKAHOKENMEISAICSVF, "BZ_GAIKAHOKENMEISAICSVF", false);
        addPattern(PATTERN_DEFAULT, DS_NEUGOKIHANTEIKEKKAFILE, "DS_NEUGOKIHANTEIKEKKAFILE", false);
        addPattern(PATTERN_DEFAULT, DS_TOUKEIFILE, "DS_TOUKEIFILE", false);
        addPattern(PATTERN_DEFAULT, AS_SOUKISYOUMETUDATA, "AS_SOUKISYOUMETUDATA", false);
        addPattern(PATTERN_DEFAULT, AS_PMINYUUSYOUMETUHRBKNLIST, "AS_PMINYUUSYOUMETUHRBKNLIST", false);
        addPattern(PATTERN_DEFAULT, AS_PMINYUUSYOUMETUSK, "AS_PMINYUUSYOUMETUSK", false);
        addPattern(PATTERN_DEFAULT, AS_KAWASERATETUUTIDATA, "AS_KAWASERATETUUTIDATA", false);
        addPattern(PATTERN_DEFAULT, BZ_SIKINIDOULISTSIKINIDOUBICSVF, "BZ_SIKINIDOULISTSIKINIDOUBICSVF", false);


        lock(C_FileSyuruiCdKbn.class);
    }

    private C_FileSyuruiCdKbn(String value) {
        super(value);
    }

    public static C_FileSyuruiCdKbn valueOf(String value) {
        return valueOf(C_FileSyuruiCdKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_FileSyuruiCdKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_FileSyuruiCdKbn.class, patternId, value);
    }
}
