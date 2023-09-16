
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 請求内容チェック区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_SKNaiyouChkKbn</td><td colspan="3">請求内容チェック区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="165">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #SKSYAKBN_MINYUCHK}</td><td>&quot;10101&quot;</td><td>請求者区分未入力チェック</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SKSYANMKN_MINYUCHK}</td><td>&quot;10102&quot;</td><td>請求者（カナ）未入力チェック</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SKSYANMKNMEIGI_CHK}</td><td>&quot;10103&quot;</td><td>請求者カナ名義人チェック</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SKSYANMKJ_MINYUCHK}</td><td>&quot;10104&quot;</td><td>請求者（漢字）未入力チェック</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SEIYMD_MINYUCHK}</td><td>&quot;10105&quot;</td><td>生年月日未入力チェック</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SEIBETU_MINYUCHK}</td><td>&quot;10106&quot;</td><td>性別未入力チェック</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SKSYAINFO_UMUCHK}</td><td>&quot;10107&quot;</td><td>請求者情報（受取人本人、指定代理人）有無チェック</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SKSYAKANA_UMUCHK_HONNIN}</td><td>&quot;10108&quot;</td><td>請求者情報（受取人本人）受取人名（カナ）有無チェック</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SKSYASEIBETU_MINYUCHK}</td><td>&quot;10109&quot;</td><td>請求者情報（受取人本人、指定代理人）性別未入力チェック</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SKSYA_HUKUSUUCHK}</td><td>&quot;10110&quot;</td><td>請求者情報（受取人本人）複数存在チェック</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SKSYAKANA_UMUCHK_SITEIDR}</td><td>&quot;10111&quot;</td><td>請求者情報（指定代理人）受取人名（カナ）有無チェック</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SEIYMD_SAKICHK}</td><td>&quot;10112&quot;</td><td>生年月日先日付チェック</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SKSYASEIBETU_KYKCHK}</td><td>&quot;10113&quot;</td><td>請求者情報（受取人本人）契約者性別チェック</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KYKDRTKYKHUKA_CHK}</td><td>&quot;10114&quot;</td><td>契約者代理特約付加チェック</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KEIUKEDOU_CHK}</td><td>&quot;10115&quot;</td><td>契受同一判定チェック</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SKSKINFO_CHK}</td><td>&quot;10201&quot;</td><td>親権者情報チェック</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SKSKKNNMKNMEIGI_CHK}</td><td>&quot;10202&quot;</td><td>親権者カナ名義人チェック</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TDKDADR_UMUCHK}</td><td>&quot;10301&quot;</td><td>契約情報（届出住所）有無チェック</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #POSTALCD_MINYUCHK}</td><td>&quot;10302&quot;</td><td>郵便番号未入力チェック</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #ADRKJ_MINYUCHK}</td><td>&quot;10303&quot;</td><td>住所（漢字）未入力チェック</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TELNO_MINYUCHK}</td><td>&quot;10304&quot;</td><td>電話番号未入力チェック</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #ADRKJ_KETACHK}</td><td>&quot;10305&quot;</td><td>住所（漢字）合計桁数チェック</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TELNO_YUUKOUCHK}</td><td>&quot;10306&quot;</td><td>電話番号有効チェック</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KRKKEIJYO_CHK}</td><td>&quot;10401&quot;</td><td>仮受計上選択時チェック</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #BANKCD_MINYUCHK}</td><td>&quot;10402&quot;</td><td>銀行コード未入力チェック</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SITENCD_MINYUCHK}</td><td>&quot;10403&quot;</td><td>支店コード未入力チェック</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #YOKINSYUMOKU_MINYUCHK}</td><td>&quot;10404&quot;</td><td>預金種目未入力チェック</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KOUZANO_MINYUCHK}</td><td>&quot;10405&quot;</td><td>口座番号未入力チェック</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KZDOUKBN_MINYUCHK}</td><td>&quot;10406&quot;</td><td>口座名義人同一区分未入力チェック</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KZMEIGINM_MINYUCHK}</td><td>&quot;10407&quot;</td><td>口座名義人未入力チェック</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KZMEIGINM_INPUTCHK}</td><td>&quot;10408&quot;</td><td>口座名義人入力チェック</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #GINKOUMST_UMUCHK}</td><td>&quot;10409&quot;</td><td>銀行マスタ存在チェック</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KINYUKKN_YKCHK_SEYMD}</td><td>&quot;10410&quot;</td><td>金融機関有効性判定（新設廃止年月日）チェック</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KINYUKKN_YKCHK_NAIKOKU}</td><td>&quot;10411&quot;</td><td>金融機関有効性判定（内国為替制度未加盟）チェック</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KINYUKKN_YKCHK_GSENM}</td><td>&quot;10412&quot;</td><td>金融機関有効性判定（銀行支店名英字）チェック</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KOUZANO_KYOKAMOJICHK}</td><td>&quot;10413&quot;</td><td>口座番号許可文字チェック</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KOUZANO_KETACHK}</td><td>&quot;10414&quot;</td><td>口座番号入力桁数チェック</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KZMEIGINM_KYOKAMOJICHK}</td><td>&quot;10415&quot;</td><td>口座名義人許可文字チェック</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KZMEIGINM_KETACHK}</td><td>&quot;10416&quot;</td><td>口座名義人桁数チェック</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #YOKINSYUMOKU_YUUTYOCHK}</td><td>&quot;10417&quot;</td><td>預金種目チェック（ゆうちょ銀行）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #YOKINSYUMOKU_INPUTCHK}</td><td>&quot;10418&quot;</td><td>預金種目入力チェック</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SKSYAKANA_MEIGINMKNCHK}</td><td>&quot;10419&quot;</td><td>請求情報請求者カナ名義人チェック</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SKSYAKANA_KETACHK}</td><td>&quot;10420&quot;</td><td>請求情報請求者カナ桁数チェック</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #ISHRHOUSITEIKBN_MINYUCHK}</td><td>&quot;10421&quot;</td><td>入力用支払方法指定区分未入力チェック</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KZDOUKBN_SKSYAKBN_SKCHK}</td><td>&quot;10422&quot;</td><td>口座名義人同一区分－請求者区分相関チェック</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KZMEIGINM_MINYUCHK_GAIKA}</td><td>&quot;10423&quot;</td><td>口座名義人未入力チェック（外貨）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KYKDRKZDOUKBN_CHK}</td><td>&quot;10424&quot;</td><td>契約者代理人口座名義人同一区分チェック</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SIUKTHOU_MINYUCHK}</td><td>&quot;10501&quot;</td><td>受取方法未入力チェック</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NKSYU_CHK}</td><td>&quot;10502&quot;</td><td>年金種類入力チェック</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SHRKKN_CHK}</td><td>&quot;10503&quot;</td><td>支払期間・保証期間入力チェック</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #BNSHRKAISUU_CHK}</td><td>&quot;10504&quot;</td><td>分割支払回数入力チェック</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NKKKN_CHK}</td><td>&quot;10505&quot;</td><td>年金基金充当金額入力チェック</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HAITOUUKTR_CHK}</td><td>&quot;10506&quot;</td><td>配当金受取方法入力チェック</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NKSYU_MINYUCHK}</td><td>&quot;10507&quot;</td><td>年金種類未入力チェック</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SHRKKN_MINYUCHK}</td><td>&quot;10508&quot;</td><td>支払期間・保証期間未入力チェック</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #BNSHRKAISUU_MINYUCHK}</td><td>&quot;10509&quot;</td><td>分割支払回数未入力チェック</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NKKKN_CHK_MINYUCHK}</td><td>&quot;10510&quot;</td><td>年金基金充当金額未入力チェック</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HAITOUUKTR_MINYUCHK}</td><td>&quot;10511&quot;</td><td>配当金受取方法未入力チェック</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NSTK_NASICHK_ZNITIIGAI}</td><td>&quot;10512&quot;</td><td>年金支払特約付加なしチェック（全額一時金以外選択時）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NSTK_CHK_ZNITII}</td><td>&quot;10513&quot;</td><td>年金支払特約付加チェック（全額一時金選択時）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NSTK_CHK_NKSYS}</td><td>&quot;10514&quot;</td><td>年金支払特約付加チェック（年金支払システムによる支払）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NSTK_CHK_UKTHUKUSUU}</td><td>&quot;10515&quot;</td><td>年金支払特約付加チェック（受取人複数あり）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NKSHR_KAISIGO_CHK_ITINK}</td><td>&quot;10516&quot;</td><td>年金支払開始後チェック（一部年金選択時）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NKSHR_KAISIGO_CHK_HENKOU}</td><td>&quot;10517&quot;</td><td>年金支払開始後チェック（年金支払内容変更時）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SAKUSEIKBN_MINYUCHK}</td><td>&quot;10601&quot;</td><td>作成区分未入力チェック</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SAKUSEI_HASSOU_SKCHK}</td><td>&quot;10602&quot;</td><td>作成区分－発送区分相関チェック</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NSTK_HASSOU_SKCHK}</td><td>&quot;10603&quot;</td><td>年金支払特約－作成区分相関チェック</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SAIKEN_SAKUSEIKBN_CHK}</td><td>&quot;10604&quot;</td><td>債権者情報－作成区分相関チェック</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KRKKEIJYOU_SAKUSEIKBN_CHK}</td><td>&quot;10605&quot;</td><td>仮受計上－作成区分相関チェック</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HONNINKAKNIN_CHK}</td><td>&quot;10701&quot;</td><td>本人確認チェック</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KIJYUNYMD_MINYUCHK}</td><td>&quot;10801&quot;</td><td>基準日未入力チェック</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KIJYUN_SYORUIUKE_SKCHK}</td><td>&quot;10802&quot;</td><td>基準日相関チェック（書類受付日）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KIJYUN_KHENKOU_SKCHK}</td><td>&quot;10803&quot;</td><td>基準日相関チェック（契約変更）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KIJYUN_HHENKOU_SKCHK}</td><td>&quot;10804&quot;</td><td>基準日相関チェック（払方変更）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SYORUIUKEYMD_SAKICHK}</td><td>&quot;10805&quot;</td><td>書類受付日先日付チェック</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HUBIKANRYOUYMD_SAKICHK}</td><td>&quot;10806&quot;</td><td>不備完了日先日付チェック</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HUBI_SYORUIUKE_SKCHK}</td><td>&quot;10807&quot;</td><td>不備完了日相関チェック（書類受付日）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HUBIKANRYOUYMD_MINYUCHK}</td><td>&quot;10808&quot;</td><td>不備完了日未入力チェック</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #GENINKBN_CHK}</td><td>&quot;10901&quot;</td><td>原因区分チェック</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SYUHIYOU_CHK}</td><td>&quot;11001&quot;</td><td>守秘要チェック</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SAIGAI_GAITOU_CHK}</td><td>&quot;11101&quot;</td><td>災害該当可能性チェック</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SAIKEN_ITIBU_MINYUCHK}</td><td>&quot;11201&quot;</td><td>債権者情報チェック（一部項目入力）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SAIKEN_ZENBU_MINYUCHK}</td><td>&quot;11202&quot;</td><td>債権者情報チェック（全項目未入力）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SAIKEN_ADRKJ_KETACHK}</td><td>&quot;11203&quot;</td><td>債権者住所（漢字）合計桁数チェック</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SAISATEI_CHK1}</td><td>&quot;11301&quot;</td><td>再査定チェック１</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SAISATEI_CHK2}</td><td>&quot;11302&quot;</td><td>再査定チェック２</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SUKETORIHOUHOU_MINYUCHK}</td><td>&quot;11401&quot;</td><td>受取方法未入力チェック</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SYOUMETU_CHK}</td><td>&quot;20101&quot;</td><td>消滅チェック</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #DOUJISKSYORITYUU_CHK}</td><td>&quot;20201&quot;</td><td>同時請求処理中チェック　</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KHSYORITYUU_KAIYK}</td><td>&quot;20301&quot;</td><td>契約保全処理中チェック（解約）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KHSYORITYUU_GENGAKU}</td><td>&quot;20302&quot;</td><td>契約保全処理中チェック（減額）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KHSYORITYUU_OTHER}</td><td>&quot;20303&quot;</td><td>契約保全処理中チェック（その他）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KHSYORITYUU_STDRSKTKYTTHK}</td><td>&quot;20304&quot;</td><td>契約保全処理中チェック（指定代理請求特約中途付加）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KHSYORITYUU_JDKIGMBRTKYKHNK}</td><td>&quot;20305&quot;</td><td>契約保全処理中チェック（重度介護前払特約変更）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KHSYORITYUU_MKHGKHNK}</td><td>&quot;20306&quot;</td><td>契約保全処理中チェック（目標額変更）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KHSYORITYUU_SYOUKENSAIHAKKOU}</td><td>&quot;20307&quot;</td><td>契約保全処理中チェック（証券再発行）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KHSYORITYUU_TMTTKINITEN}</td><td>&quot;20308&quot;</td><td>契約保全処理中チェック（積立金移転）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KHSYORITYUU_DSHR}</td><td>&quot;20309&quot;</td><td>契約保全処理中チェック（配当金支払）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KHSYORITYUU_HARAIKATAHENKOU}</td><td>&quot;20310&quot;</td><td>契約保全処理中チェック（払方変更）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KHSYORITYUU_YENDTHNKUKTKNINI}</td><td>&quot;20311&quot;</td><td>契約保全処理中チェック（円建変更受付（任意請求））</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SKNNKAISIYMD_CHK}</td><td>&quot;20401&quot;</td><td>責任開始日チェック</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HKNKKN_CHK}</td><td>&quot;20501&quot;</td><td>保険期間チェック</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #PHRKYUYOKKN_CHK}</td><td>&quot;20601&quot;</td><td>保険料払込猶予期間チェック</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #FSTPHRKYUYOKKNTYO_CHK}</td><td>&quot;20701&quot;</td><td>初回保険料払込猶予期間超過チェック</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TOKKOUDOSGHTNP_CHK}</td><td>&quot;20801&quot;</td><td>特定高度障害不担保チェック</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SISHRSAKUGENKKN_CHK}</td><td>&quot;20901&quot;</td><td>保険金支払削減期間チェック</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NENKINKKN_CHK}</td><td>&quot;21001&quot;</td><td>年金期間チェック</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NKNENGK_CHK}</td><td>&quot;21002&quot;</td><td>年金年額チェック</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SAITEIBNTNKGK_CHK}</td><td>&quot;21003&quot;</td><td>最低分割年金額チェック</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TTDKTYUUI_CHK}</td><td>&quot;21101&quot;</td><td>手続注意チェック</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #UKT_CHK}</td><td>&quot;21201&quot;</td><td>受取人チェック</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #FSTPNYKN_MINYUCHK}</td><td>&quot;21301&quot;</td><td>初回保険料未入チェック</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SINSATYUUI_CHK}</td><td>&quot;21401&quot;</td><td>審査注意チェック</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MRFKOUZATRATKI_CHK}</td><td>&quot;21501&quot;</td><td>ＭＲＦ口座取扱チェック</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KEIYAKUSYAHNK_CHK}</td><td>&quot;21601&quot;</td><td>契約者変更チェック</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #DSKAIYAKUSYORI_CHK}</td><td>&quot;21701&quot;</td><td>ＤＳ解約処理中チェック</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KYKYMDCHECK_CHK}</td><td>&quot;21801&quot;</td><td>契約日チェック</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #ENDTHNKYMDCHECK_CHK}</td><td>&quot;21901&quot;</td><td>円建変更日チェック</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HRMBRCHECK_KEIUKEDOU_CHK}</td><td>&quot;22001&quot;</td><td>返戻金未払いチェック（契受同一）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HRMBRCHECK_KEIUKEBETU_CHK}</td><td>&quot;22002&quot;</td><td>返戻金未払いチェック（契受別）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #D_SEIGOUSEI_CHK}</td><td>&quot;23001&quot;</td><td>配当金チェック（配当整合性）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #D_MIHANEI_CHK}</td><td>&quot;23002&quot;</td><td>配当金チェック（未反映配当金有無）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #D_SHRYMDUMU_CHK}</td><td>&quot;23003&quot;</td><td>配当金チェック（配当金支払日存在有無）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TMTTKIN_MIHANEI_CHK}</td><td>&quot;23101&quot;</td><td>積立金状態チェック（積立金未反映）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TMTTKIN_ITENBI_CHK}</td><td>&quot;23102&quot;</td><td>積立金状態チェック（積立金移転日）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SATEICHK_JISATUMENSEKI}</td><td>&quot;30101&quot;</td><td>査定項目＿自殺免責チェック</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SATEICHK_SKNNKAISIYMD}</td><td>&quot;30201&quot;</td><td>査定項目＿責任開始日チェック</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SATEICHK_GENGK}</td><td>&quot;30301&quot;</td><td>査定項目＿減額チェック</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SATEICHK_MEIGIHN_AMONTH}</td><td>&quot;30401&quot;</td><td>査定項目＿名義変更１ヶ月以内チェック</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SATEICHK_MEIGIHN_KSYOUHI}</td><td>&quot;30402&quot;</td><td>査定項目＿名義変更査定要否チェック（査定回送要否）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SATEICHK_MEIGIHN_SIBOUGO}</td><td>&quot;30403&quot;</td><td>査定項目＿名義変更査定要否チェック（死亡後の変更）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SATEICHK_MEIGIHN_KD}</td><td>&quot;30404&quot;</td><td>査定項目＿名義変更チェック（高度障害）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SATEICHK_STKNSET_UMU}</td><td>&quot;30501&quot;</td><td>査定項目＿質権設定有無チェック</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SATEICHK_STKNSET_KAIYAKU}</td><td>&quot;30502&quot;</td><td>査定項目＿質権設定契約解約チェック</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SATEICHK_HASANTOUSAN}</td><td>&quot;30601&quot;</td><td>査定項目＿破産および倒産チェック</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SATEICHK_SASIOSAE}</td><td>&quot;30701&quot;</td><td>査定項目＿差押チェック</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SATEICHK_SOUSASYOUKAI}</td><td>&quot;30801&quot;</td><td>査定項目＿捜査照会チェック</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SATEICHK_HUSYOU_BYOUMEI}</td><td>&quot;30901&quot;</td><td>査定項目＿不詳の死チェック（病名）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SATEICHK_HUSYOU_GENINKBN}</td><td>&quot;30902&quot;</td><td>査定項目＿不詳の死チェック（原因区分）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SATEICHK_HUSYOU_KSYOUHI}</td><td>&quot;30903&quot;</td><td>査定項目＿不詳の死チェック（査定回送要否）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SATEICHK_KAIGAISIBOU}</td><td>&quot;31001&quot;</td><td>査定項目＿海外死亡チェック</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SATEICHK_HANSYA}</td><td>&quot;31101&quot;</td><td>査定項目＿反社チェック</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SATEICHK_SKSYORUI}</td><td>&quot;31201&quot;</td><td>査定項目＿請求書類チェック</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SATEICHK_KAIGAI}</td><td>&quot;31301&quot;</td><td>査定項目＿海外チェック</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SATEICHK_MRINFO}</td><td>&quot;31401&quot;</td><td>査定項目＿ＭＲ情報チェック</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SATEICHK_HIGAITOU}</td><td>&quot;31501&quot;</td><td>査定項目＿非該当チェック</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SATEICHK_SAIGAI_GENINKBN}</td><td>&quot;31601&quot;</td><td>査定項目＿災害該当可能性チェック（原因区分）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SATEICHK_SAIGAI_BYOUMEI}</td><td>&quot;31602&quot;</td><td>査定項目＿災害該当可能性チェック（病名）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SATEICHK_SAIGAI_KSYOUHI}</td><td>&quot;31603&quot;</td><td>査定項目＿災害該当可能性チェック（査定回送要否）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SATEICHK_SAIGAI_SKSYORUI}</td><td>&quot;31604&quot;</td><td>査定項目＿災害該当可能性チェック（請求書類）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SATEICHK_SAISATEI}</td><td>&quot;31701&quot;</td><td>査定項目＿再査定チェック</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SATEICHK_SAIKENKAIYAKU}</td><td>&quot;31801&quot;</td><td>査定項目＿債権者解約申出チェック</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SATEICHK_SGSBJISATUMENSEKI_GENINKBN}</td><td>&quot;31901&quot;</td><td>査定項目＿災害死亡自殺免責チェック（原因区分）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SATEICHK_SGSBJISATUMENSEKI_BYOUMEI}</td><td>&quot;31902&quot;</td><td>査定項目＿災害死亡自殺免責チェック（病名）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SATEICHK_SGSBJISATUMENSEKI_KSYOUHI}</td><td>&quot;31903&quot;</td><td>査定項目＿災害死亡自殺免責チェック（査定回送要否）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SATEICHK_SGSBJISATUMENSEKI_SKSYORUI}</td><td>&quot;31904&quot;</td><td>査定項目＿災害死亡自殺免責チェック（請求書類）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SYORUIUKEYMD_TIENRSKCHK}</td><td>&quot;40101&quot;</td><td>書類受付日チェック（遅延利息）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HONNINKAKNIN_HKNGK_CHK}</td><td>&quot;40201&quot;</td><td>本人確認チェック（保険金額）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MNNO_KYK_HUYOUCHK}</td><td>&quot;40301&quot;</td><td>ＭＮ名義番号チェック（ＭＮ取得対象・契約者ＭＮ入力不要）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MNNO_KYK_MINYUCHK}</td><td>&quot;40302&quot;</td><td>ＭＮ名義番号チェック（ＭＮ取得対象・契約者ＭＮ未入力）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MNNO_UKT_MINYUCHK}</td><td>&quot;40303&quot;</td><td>ＭＮ名義番号チェック（ＭＮ取得対象・受取人ＭＮ未入力）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MNNO_GAI_KYK_HUYOUCHK}</td><td>&quot;40304&quot;</td><td>ＭＮ名義番号チェック（ＭＮ取得対象外・契約者ＭＮ入力不要）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MNNO_GAI_UKT_HUYOUCHK}</td><td>&quot;40305&quot;</td><td>ＭＮ名義番号チェック（ＭＮ取得対象外・受取人ＭＮ入力不要）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SYKSBYENSITIHSYUTKTEKI_CHK}</td><td>&quot;40401&quot;</td><td>初期死亡時円換算最低保証特約適用チェック</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SAISBYENSITIHSYUTKTEKI_CHK}</td><td>&quot;40402&quot;</td><td>再査定時初期死亡時円換算最低保証特約適用チェック</td></tr>
 * </table>
 */
public class C_SKNaiyouChkKbn extends Classification<C_SKNaiyouChkKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_SKNaiyouChkKbn SKSYAKBN_MINYUCHK = new C_SKNaiyouChkKbn("10101");

    public static final C_SKNaiyouChkKbn SKSYANMKN_MINYUCHK = new C_SKNaiyouChkKbn("10102");

    public static final C_SKNaiyouChkKbn SKSYANMKNMEIGI_CHK = new C_SKNaiyouChkKbn("10103");

    public static final C_SKNaiyouChkKbn SKSYANMKJ_MINYUCHK = new C_SKNaiyouChkKbn("10104");

    public static final C_SKNaiyouChkKbn SEIYMD_MINYUCHK = new C_SKNaiyouChkKbn("10105");

    public static final C_SKNaiyouChkKbn SEIBETU_MINYUCHK = new C_SKNaiyouChkKbn("10106");

    public static final C_SKNaiyouChkKbn SKSYAINFO_UMUCHK = new C_SKNaiyouChkKbn("10107");

    public static final C_SKNaiyouChkKbn SKSYAKANA_UMUCHK_HONNIN = new C_SKNaiyouChkKbn("10108");

    public static final C_SKNaiyouChkKbn SKSYASEIBETU_MINYUCHK = new C_SKNaiyouChkKbn("10109");

    public static final C_SKNaiyouChkKbn SKSYA_HUKUSUUCHK = new C_SKNaiyouChkKbn("10110");

    public static final C_SKNaiyouChkKbn SKSYAKANA_UMUCHK_SITEIDR = new C_SKNaiyouChkKbn("10111");

    public static final C_SKNaiyouChkKbn SEIYMD_SAKICHK = new C_SKNaiyouChkKbn("10112");

    public static final C_SKNaiyouChkKbn SKSYASEIBETU_KYKCHK = new C_SKNaiyouChkKbn("10113");

    public static final C_SKNaiyouChkKbn KYKDRTKYKHUKA_CHK = new C_SKNaiyouChkKbn("10114");

    public static final C_SKNaiyouChkKbn KEIUKEDOU_CHK = new C_SKNaiyouChkKbn("10115");

    public static final C_SKNaiyouChkKbn SKSKINFO_CHK = new C_SKNaiyouChkKbn("10201");

    public static final C_SKNaiyouChkKbn SKSKKNNMKNMEIGI_CHK = new C_SKNaiyouChkKbn("10202");

    public static final C_SKNaiyouChkKbn TDKDADR_UMUCHK = new C_SKNaiyouChkKbn("10301");

    public static final C_SKNaiyouChkKbn POSTALCD_MINYUCHK = new C_SKNaiyouChkKbn("10302");

    public static final C_SKNaiyouChkKbn ADRKJ_MINYUCHK = new C_SKNaiyouChkKbn("10303");

    public static final C_SKNaiyouChkKbn TELNO_MINYUCHK = new C_SKNaiyouChkKbn("10304");

    public static final C_SKNaiyouChkKbn ADRKJ_KETACHK = new C_SKNaiyouChkKbn("10305");

    public static final C_SKNaiyouChkKbn TELNO_YUUKOUCHK = new C_SKNaiyouChkKbn("10306");

    public static final C_SKNaiyouChkKbn KRKKEIJYO_CHK = new C_SKNaiyouChkKbn("10401");

    public static final C_SKNaiyouChkKbn BANKCD_MINYUCHK = new C_SKNaiyouChkKbn("10402");

    public static final C_SKNaiyouChkKbn SITENCD_MINYUCHK = new C_SKNaiyouChkKbn("10403");

    public static final C_SKNaiyouChkKbn YOKINSYUMOKU_MINYUCHK = new C_SKNaiyouChkKbn("10404");

    public static final C_SKNaiyouChkKbn KOUZANO_MINYUCHK = new C_SKNaiyouChkKbn("10405");

    public static final C_SKNaiyouChkKbn KZDOUKBN_MINYUCHK = new C_SKNaiyouChkKbn("10406");

    public static final C_SKNaiyouChkKbn KZMEIGINM_MINYUCHK = new C_SKNaiyouChkKbn("10407");

    public static final C_SKNaiyouChkKbn KZMEIGINM_INPUTCHK = new C_SKNaiyouChkKbn("10408");

    public static final C_SKNaiyouChkKbn GINKOUMST_UMUCHK = new C_SKNaiyouChkKbn("10409");

    public static final C_SKNaiyouChkKbn KINYUKKN_YKCHK_SEYMD = new C_SKNaiyouChkKbn("10410");

    public static final C_SKNaiyouChkKbn KINYUKKN_YKCHK_NAIKOKU = new C_SKNaiyouChkKbn("10411");

    public static final C_SKNaiyouChkKbn KINYUKKN_YKCHK_GSENM = new C_SKNaiyouChkKbn("10412");

    public static final C_SKNaiyouChkKbn KOUZANO_KYOKAMOJICHK = new C_SKNaiyouChkKbn("10413");

    public static final C_SKNaiyouChkKbn KOUZANO_KETACHK = new C_SKNaiyouChkKbn("10414");

    public static final C_SKNaiyouChkKbn KZMEIGINM_KYOKAMOJICHK = new C_SKNaiyouChkKbn("10415");

    public static final C_SKNaiyouChkKbn KZMEIGINM_KETACHK = new C_SKNaiyouChkKbn("10416");

    public static final C_SKNaiyouChkKbn YOKINSYUMOKU_YUUTYOCHK = new C_SKNaiyouChkKbn("10417");

    public static final C_SKNaiyouChkKbn YOKINSYUMOKU_INPUTCHK = new C_SKNaiyouChkKbn("10418");

    public static final C_SKNaiyouChkKbn SKSYAKANA_MEIGINMKNCHK = new C_SKNaiyouChkKbn("10419");

    public static final C_SKNaiyouChkKbn SKSYAKANA_KETACHK = new C_SKNaiyouChkKbn("10420");

    public static final C_SKNaiyouChkKbn ISHRHOUSITEIKBN_MINYUCHK = new C_SKNaiyouChkKbn("10421");

    public static final C_SKNaiyouChkKbn KZDOUKBN_SKSYAKBN_SKCHK = new C_SKNaiyouChkKbn("10422");

    public static final C_SKNaiyouChkKbn KZMEIGINM_MINYUCHK_GAIKA = new C_SKNaiyouChkKbn("10423");

    public static final C_SKNaiyouChkKbn KYKDRKZDOUKBN_CHK = new C_SKNaiyouChkKbn("10424");

    public static final C_SKNaiyouChkKbn SIUKTHOU_MINYUCHK = new C_SKNaiyouChkKbn("10501");

    public static final C_SKNaiyouChkKbn NKSYU_CHK = new C_SKNaiyouChkKbn("10502");

    public static final C_SKNaiyouChkKbn SHRKKN_CHK = new C_SKNaiyouChkKbn("10503");

    public static final C_SKNaiyouChkKbn BNSHRKAISUU_CHK = new C_SKNaiyouChkKbn("10504");

    public static final C_SKNaiyouChkKbn NKKKN_CHK = new C_SKNaiyouChkKbn("10505");

    public static final C_SKNaiyouChkKbn HAITOUUKTR_CHK = new C_SKNaiyouChkKbn("10506");

    public static final C_SKNaiyouChkKbn NKSYU_MINYUCHK = new C_SKNaiyouChkKbn("10507");

    public static final C_SKNaiyouChkKbn SHRKKN_MINYUCHK = new C_SKNaiyouChkKbn("10508");

    public static final C_SKNaiyouChkKbn BNSHRKAISUU_MINYUCHK = new C_SKNaiyouChkKbn("10509");

    public static final C_SKNaiyouChkKbn NKKKN_CHK_MINYUCHK = new C_SKNaiyouChkKbn("10510");

    public static final C_SKNaiyouChkKbn HAITOUUKTR_MINYUCHK = new C_SKNaiyouChkKbn("10511");

    public static final C_SKNaiyouChkKbn NSTK_NASICHK_ZNITIIGAI = new C_SKNaiyouChkKbn("10512");

    public static final C_SKNaiyouChkKbn NSTK_CHK_ZNITII = new C_SKNaiyouChkKbn("10513");

    public static final C_SKNaiyouChkKbn NSTK_CHK_NKSYS = new C_SKNaiyouChkKbn("10514");

    public static final C_SKNaiyouChkKbn NSTK_CHK_UKTHUKUSUU = new C_SKNaiyouChkKbn("10515");

    public static final C_SKNaiyouChkKbn NKSHR_KAISIGO_CHK_ITINK = new C_SKNaiyouChkKbn("10516");

    public static final C_SKNaiyouChkKbn NKSHR_KAISIGO_CHK_HENKOU = new C_SKNaiyouChkKbn("10517");

    public static final C_SKNaiyouChkKbn SAKUSEIKBN_MINYUCHK = new C_SKNaiyouChkKbn("10601");

    public static final C_SKNaiyouChkKbn SAKUSEI_HASSOU_SKCHK = new C_SKNaiyouChkKbn("10602");

    public static final C_SKNaiyouChkKbn NSTK_HASSOU_SKCHK = new C_SKNaiyouChkKbn("10603");

    public static final C_SKNaiyouChkKbn SAIKEN_SAKUSEIKBN_CHK = new C_SKNaiyouChkKbn("10604");

    public static final C_SKNaiyouChkKbn KRKKEIJYOU_SAKUSEIKBN_CHK = new C_SKNaiyouChkKbn("10605");

    public static final C_SKNaiyouChkKbn HONNINKAKNIN_CHK = new C_SKNaiyouChkKbn("10701");

    public static final C_SKNaiyouChkKbn KIJYUNYMD_MINYUCHK = new C_SKNaiyouChkKbn("10801");

    public static final C_SKNaiyouChkKbn KIJYUN_SYORUIUKE_SKCHK = new C_SKNaiyouChkKbn("10802");

    public static final C_SKNaiyouChkKbn KIJYUN_KHENKOU_SKCHK = new C_SKNaiyouChkKbn("10803");

    public static final C_SKNaiyouChkKbn KIJYUN_HHENKOU_SKCHK = new C_SKNaiyouChkKbn("10804");

    public static final C_SKNaiyouChkKbn SYORUIUKEYMD_SAKICHK = new C_SKNaiyouChkKbn("10805");

    public static final C_SKNaiyouChkKbn HUBIKANRYOUYMD_SAKICHK = new C_SKNaiyouChkKbn("10806");

    public static final C_SKNaiyouChkKbn HUBI_SYORUIUKE_SKCHK = new C_SKNaiyouChkKbn("10807");

    public static final C_SKNaiyouChkKbn HUBIKANRYOUYMD_MINYUCHK = new C_SKNaiyouChkKbn("10808");

    public static final C_SKNaiyouChkKbn GENINKBN_CHK = new C_SKNaiyouChkKbn("10901");

    public static final C_SKNaiyouChkKbn SYUHIYOU_CHK = new C_SKNaiyouChkKbn("11001");

    public static final C_SKNaiyouChkKbn SAIGAI_GAITOU_CHK = new C_SKNaiyouChkKbn("11101");

    public static final C_SKNaiyouChkKbn SAIKEN_ITIBU_MINYUCHK = new C_SKNaiyouChkKbn("11201");

    public static final C_SKNaiyouChkKbn SAIKEN_ZENBU_MINYUCHK = new C_SKNaiyouChkKbn("11202");

    public static final C_SKNaiyouChkKbn SAIKEN_ADRKJ_KETACHK = new C_SKNaiyouChkKbn("11203");

    public static final C_SKNaiyouChkKbn SAISATEI_CHK1 = new C_SKNaiyouChkKbn("11301");

    public static final C_SKNaiyouChkKbn SAISATEI_CHK2 = new C_SKNaiyouChkKbn("11302");

    public static final C_SKNaiyouChkKbn SUKETORIHOUHOU_MINYUCHK = new C_SKNaiyouChkKbn("11401");

    public static final C_SKNaiyouChkKbn SYOUMETU_CHK = new C_SKNaiyouChkKbn("20101");

    public static final C_SKNaiyouChkKbn DOUJISKSYORITYUU_CHK = new C_SKNaiyouChkKbn("20201");

    public static final C_SKNaiyouChkKbn KHSYORITYUU_KAIYK = new C_SKNaiyouChkKbn("20301");

    public static final C_SKNaiyouChkKbn KHSYORITYUU_GENGAKU = new C_SKNaiyouChkKbn("20302");

    public static final C_SKNaiyouChkKbn KHSYORITYUU_OTHER = new C_SKNaiyouChkKbn("20303");

    public static final C_SKNaiyouChkKbn KHSYORITYUU_STDRSKTKYTTHK = new C_SKNaiyouChkKbn("20304");

    public static final C_SKNaiyouChkKbn KHSYORITYUU_JDKIGMBRTKYKHNK = new C_SKNaiyouChkKbn("20305");

    public static final C_SKNaiyouChkKbn KHSYORITYUU_MKHGKHNK = new C_SKNaiyouChkKbn("20306");

    public static final C_SKNaiyouChkKbn KHSYORITYUU_SYOUKENSAIHAKKOU = new C_SKNaiyouChkKbn("20307");

    public static final C_SKNaiyouChkKbn KHSYORITYUU_TMTTKINITEN = new C_SKNaiyouChkKbn("20308");

    public static final C_SKNaiyouChkKbn KHSYORITYUU_DSHR = new C_SKNaiyouChkKbn("20309");

    public static final C_SKNaiyouChkKbn KHSYORITYUU_HARAIKATAHENKOU = new C_SKNaiyouChkKbn("20310");

    public static final C_SKNaiyouChkKbn KHSYORITYUU_YENDTHNKUKTKNINI = new C_SKNaiyouChkKbn("20311");

    public static final C_SKNaiyouChkKbn SKNNKAISIYMD_CHK = new C_SKNaiyouChkKbn("20401");

    public static final C_SKNaiyouChkKbn HKNKKN_CHK = new C_SKNaiyouChkKbn("20501");

    public static final C_SKNaiyouChkKbn PHRKYUYOKKN_CHK = new C_SKNaiyouChkKbn("20601");

    public static final C_SKNaiyouChkKbn FSTPHRKYUYOKKNTYO_CHK = new C_SKNaiyouChkKbn("20701");

    public static final C_SKNaiyouChkKbn TOKKOUDOSGHTNP_CHK = new C_SKNaiyouChkKbn("20801");

    public static final C_SKNaiyouChkKbn SISHRSAKUGENKKN_CHK = new C_SKNaiyouChkKbn("20901");

    public static final C_SKNaiyouChkKbn NENKINKKN_CHK = new C_SKNaiyouChkKbn("21001");

    public static final C_SKNaiyouChkKbn NKNENGK_CHK = new C_SKNaiyouChkKbn("21002");

    public static final C_SKNaiyouChkKbn SAITEIBNTNKGK_CHK = new C_SKNaiyouChkKbn("21003");

    public static final C_SKNaiyouChkKbn TTDKTYUUI_CHK = new C_SKNaiyouChkKbn("21101");

    public static final C_SKNaiyouChkKbn UKT_CHK = new C_SKNaiyouChkKbn("21201");

    public static final C_SKNaiyouChkKbn FSTPNYKN_MINYUCHK = new C_SKNaiyouChkKbn("21301");

    public static final C_SKNaiyouChkKbn SINSATYUUI_CHK = new C_SKNaiyouChkKbn("21401");

    public static final C_SKNaiyouChkKbn MRFKOUZATRATKI_CHK = new C_SKNaiyouChkKbn("21501");

    public static final C_SKNaiyouChkKbn KEIYAKUSYAHNK_CHK = new C_SKNaiyouChkKbn("21601");

    public static final C_SKNaiyouChkKbn DSKAIYAKUSYORI_CHK = new C_SKNaiyouChkKbn("21701");

    public static final C_SKNaiyouChkKbn KYKYMDCHECK_CHK = new C_SKNaiyouChkKbn("21801");

    public static final C_SKNaiyouChkKbn ENDTHNKYMDCHECK_CHK = new C_SKNaiyouChkKbn("21901");

    public static final C_SKNaiyouChkKbn HRMBRCHECK_KEIUKEDOU_CHK = new C_SKNaiyouChkKbn("22001");

    public static final C_SKNaiyouChkKbn HRMBRCHECK_KEIUKEBETU_CHK = new C_SKNaiyouChkKbn("22002");

    public static final C_SKNaiyouChkKbn D_SEIGOUSEI_CHK = new C_SKNaiyouChkKbn("23001");

    public static final C_SKNaiyouChkKbn D_MIHANEI_CHK = new C_SKNaiyouChkKbn("23002");

    public static final C_SKNaiyouChkKbn D_SHRYMDUMU_CHK = new C_SKNaiyouChkKbn("23003");

    public static final C_SKNaiyouChkKbn TMTTKIN_MIHANEI_CHK = new C_SKNaiyouChkKbn("23101");

    public static final C_SKNaiyouChkKbn TMTTKIN_ITENBI_CHK = new C_SKNaiyouChkKbn("23102");

    public static final C_SKNaiyouChkKbn SATEICHK_JISATUMENSEKI = new C_SKNaiyouChkKbn("30101");

    public static final C_SKNaiyouChkKbn SATEICHK_SKNNKAISIYMD = new C_SKNaiyouChkKbn("30201");

    public static final C_SKNaiyouChkKbn SATEICHK_GENGK = new C_SKNaiyouChkKbn("30301");

    public static final C_SKNaiyouChkKbn SATEICHK_MEIGIHN_AMONTH = new C_SKNaiyouChkKbn("30401");

    public static final C_SKNaiyouChkKbn SATEICHK_MEIGIHN_KSYOUHI = new C_SKNaiyouChkKbn("30402");

    public static final C_SKNaiyouChkKbn SATEICHK_MEIGIHN_SIBOUGO = new C_SKNaiyouChkKbn("30403");

    public static final C_SKNaiyouChkKbn SATEICHK_MEIGIHN_KD = new C_SKNaiyouChkKbn("30404");

    public static final C_SKNaiyouChkKbn SATEICHK_STKNSET_UMU = new C_SKNaiyouChkKbn("30501");

    public static final C_SKNaiyouChkKbn SATEICHK_STKNSET_KAIYAKU = new C_SKNaiyouChkKbn("30502");

    public static final C_SKNaiyouChkKbn SATEICHK_HASANTOUSAN = new C_SKNaiyouChkKbn("30601");

    public static final C_SKNaiyouChkKbn SATEICHK_SASIOSAE = new C_SKNaiyouChkKbn("30701");

    public static final C_SKNaiyouChkKbn SATEICHK_SOUSASYOUKAI = new C_SKNaiyouChkKbn("30801");

    public static final C_SKNaiyouChkKbn SATEICHK_HUSYOU_BYOUMEI = new C_SKNaiyouChkKbn("30901");

    public static final C_SKNaiyouChkKbn SATEICHK_HUSYOU_GENINKBN = new C_SKNaiyouChkKbn("30902");

    public static final C_SKNaiyouChkKbn SATEICHK_HUSYOU_KSYOUHI = new C_SKNaiyouChkKbn("30903");

    public static final C_SKNaiyouChkKbn SATEICHK_KAIGAISIBOU = new C_SKNaiyouChkKbn("31001");

    public static final C_SKNaiyouChkKbn SATEICHK_HANSYA = new C_SKNaiyouChkKbn("31101");

    public static final C_SKNaiyouChkKbn SATEICHK_SKSYORUI = new C_SKNaiyouChkKbn("31201");

    public static final C_SKNaiyouChkKbn SATEICHK_KAIGAI = new C_SKNaiyouChkKbn("31301");

    public static final C_SKNaiyouChkKbn SATEICHK_MRINFO = new C_SKNaiyouChkKbn("31401");

    public static final C_SKNaiyouChkKbn SATEICHK_HIGAITOU = new C_SKNaiyouChkKbn("31501");

    public static final C_SKNaiyouChkKbn SATEICHK_SAIGAI_GENINKBN = new C_SKNaiyouChkKbn("31601");

    public static final C_SKNaiyouChkKbn SATEICHK_SAIGAI_BYOUMEI = new C_SKNaiyouChkKbn("31602");

    public static final C_SKNaiyouChkKbn SATEICHK_SAIGAI_KSYOUHI = new C_SKNaiyouChkKbn("31603");

    public static final C_SKNaiyouChkKbn SATEICHK_SAIGAI_SKSYORUI = new C_SKNaiyouChkKbn("31604");

    public static final C_SKNaiyouChkKbn SATEICHK_SAISATEI = new C_SKNaiyouChkKbn("31701");

    public static final C_SKNaiyouChkKbn SATEICHK_SAIKENKAIYAKU = new C_SKNaiyouChkKbn("31801");

    public static final C_SKNaiyouChkKbn SATEICHK_SGSBJISATUMENSEKI_GENINKBN = new C_SKNaiyouChkKbn("31901");

    public static final C_SKNaiyouChkKbn SATEICHK_SGSBJISATUMENSEKI_BYOUMEI = new C_SKNaiyouChkKbn("31902");

    public static final C_SKNaiyouChkKbn SATEICHK_SGSBJISATUMENSEKI_KSYOUHI = new C_SKNaiyouChkKbn("31903");

    public static final C_SKNaiyouChkKbn SATEICHK_SGSBJISATUMENSEKI_SKSYORUI = new C_SKNaiyouChkKbn("31904");

    public static final C_SKNaiyouChkKbn SYORUIUKEYMD_TIENRSKCHK = new C_SKNaiyouChkKbn("40101");

    public static final C_SKNaiyouChkKbn HONNINKAKNIN_HKNGK_CHK = new C_SKNaiyouChkKbn("40201");

    public static final C_SKNaiyouChkKbn MNNO_KYK_HUYOUCHK = new C_SKNaiyouChkKbn("40301");

    public static final C_SKNaiyouChkKbn MNNO_KYK_MINYUCHK = new C_SKNaiyouChkKbn("40302");

    public static final C_SKNaiyouChkKbn MNNO_UKT_MINYUCHK = new C_SKNaiyouChkKbn("40303");

    public static final C_SKNaiyouChkKbn MNNO_GAI_KYK_HUYOUCHK = new C_SKNaiyouChkKbn("40304");

    public static final C_SKNaiyouChkKbn MNNO_GAI_UKT_HUYOUCHK = new C_SKNaiyouChkKbn("40305");

    public static final C_SKNaiyouChkKbn SYKSBYENSITIHSYUTKTEKI_CHK = new C_SKNaiyouChkKbn("40401");

    public static final C_SKNaiyouChkKbn SAISBYENSITIHSYUTKTEKI_CHK = new C_SKNaiyouChkKbn("40402");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, SKSYAKBN_MINYUCHK, "SKSYAKBN_MINYUCHK", true);
        addPattern(PATTERN_DEFAULT, SKSYANMKN_MINYUCHK, "SKSYANMKN_MINYUCHK", false);
        addPattern(PATTERN_DEFAULT, SKSYANMKNMEIGI_CHK, "SKSYANMKNMEIGI_CHK", false);
        addPattern(PATTERN_DEFAULT, SKSYANMKJ_MINYUCHK, "SKSYANMKJ_MINYUCHK", false);
        addPattern(PATTERN_DEFAULT, SEIYMD_MINYUCHK, "SEIYMD_MINYUCHK", false);
        addPattern(PATTERN_DEFAULT, SEIBETU_MINYUCHK, "SEIBETU_MINYUCHK", false);
        addPattern(PATTERN_DEFAULT, SKSYAINFO_UMUCHK, "SKSYAINFO_UMUCHK", false);
        addPattern(PATTERN_DEFAULT, SKSYAKANA_UMUCHK_HONNIN, "SKSYAKANA_UMUCHK_HONNIN", false);
        addPattern(PATTERN_DEFAULT, SKSYASEIBETU_MINYUCHK, "SKSYASEIBETU_MINYUCHK", false);
        addPattern(PATTERN_DEFAULT, SKSYA_HUKUSUUCHK, "SKSYA_HUKUSUUCHK", false);
        addPattern(PATTERN_DEFAULT, SKSYAKANA_UMUCHK_SITEIDR, "SKSYAKANA_UMUCHK_SITEIDR", false);
        addPattern(PATTERN_DEFAULT, SEIYMD_SAKICHK, "SEIYMD_SAKICHK", false);
        addPattern(PATTERN_DEFAULT, SKSYASEIBETU_KYKCHK, "SKSYASEIBETU_KYKCHK", false);
        addPattern(PATTERN_DEFAULT, KYKDRTKYKHUKA_CHK, "KYKDRTKYKHUKA_CHK", false);
        addPattern(PATTERN_DEFAULT, KEIUKEDOU_CHK, "KEIUKEDOU_CHK", false);
        addPattern(PATTERN_DEFAULT, SKSKINFO_CHK, "SKSKINFO_CHK", false);
        addPattern(PATTERN_DEFAULT, SKSKKNNMKNMEIGI_CHK, "SKSKKNNMKNMEIGI_CHK", false);
        addPattern(PATTERN_DEFAULT, TDKDADR_UMUCHK, "TDKDADR_UMUCHK", false);
        addPattern(PATTERN_DEFAULT, POSTALCD_MINYUCHK, "POSTALCD_MINYUCHK", false);
        addPattern(PATTERN_DEFAULT, ADRKJ_MINYUCHK, "ADRKJ_MINYUCHK", false);
        addPattern(PATTERN_DEFAULT, TELNO_MINYUCHK, "TELNO_MINYUCHK", false);
        addPattern(PATTERN_DEFAULT, ADRKJ_KETACHK, "ADRKJ_KETACHK", false);
        addPattern(PATTERN_DEFAULT, TELNO_YUUKOUCHK, "TELNO_YUUKOUCHK", false);
        addPattern(PATTERN_DEFAULT, KRKKEIJYO_CHK, "KRKKEIJYO_CHK", false);
        addPattern(PATTERN_DEFAULT, BANKCD_MINYUCHK, "BANKCD_MINYUCHK", false);
        addPattern(PATTERN_DEFAULT, SITENCD_MINYUCHK, "SITENCD_MINYUCHK", false);
        addPattern(PATTERN_DEFAULT, YOKINSYUMOKU_MINYUCHK, "YOKINSYUMOKU_MINYUCHK", false);
        addPattern(PATTERN_DEFAULT, KOUZANO_MINYUCHK, "KOUZANO_MINYUCHK", false);
        addPattern(PATTERN_DEFAULT, KZDOUKBN_MINYUCHK, "KZDOUKBN_MINYUCHK", false);
        addPattern(PATTERN_DEFAULT, KZMEIGINM_MINYUCHK, "KZMEIGINM_MINYUCHK", false);
        addPattern(PATTERN_DEFAULT, KZMEIGINM_INPUTCHK, "KZMEIGINM_INPUTCHK", false);
        addPattern(PATTERN_DEFAULT, GINKOUMST_UMUCHK, "GINKOUMST_UMUCHK", false);
        addPattern(PATTERN_DEFAULT, KINYUKKN_YKCHK_SEYMD, "KINYUKKN_YKCHK_SEYMD", false);
        addPattern(PATTERN_DEFAULT, KINYUKKN_YKCHK_NAIKOKU, "KINYUKKN_YKCHK_NAIKOKU", false);
        addPattern(PATTERN_DEFAULT, KINYUKKN_YKCHK_GSENM, "KINYUKKN_YKCHK_GSENM", false);
        addPattern(PATTERN_DEFAULT, KOUZANO_KYOKAMOJICHK, "KOUZANO_KYOKAMOJICHK", false);
        addPattern(PATTERN_DEFAULT, KOUZANO_KETACHK, "KOUZANO_KETACHK", false);
        addPattern(PATTERN_DEFAULT, KZMEIGINM_KYOKAMOJICHK, "KZMEIGINM_KYOKAMOJICHK", false);
        addPattern(PATTERN_DEFAULT, KZMEIGINM_KETACHK, "KZMEIGINM_KETACHK", false);
        addPattern(PATTERN_DEFAULT, YOKINSYUMOKU_YUUTYOCHK, "YOKINSYUMOKU_YUUTYOCHK", false);
        addPattern(PATTERN_DEFAULT, YOKINSYUMOKU_INPUTCHK, "YOKINSYUMOKU_INPUTCHK", false);
        addPattern(PATTERN_DEFAULT, SKSYAKANA_MEIGINMKNCHK, "SKSYAKANA_MEIGINMKNCHK", false);
        addPattern(PATTERN_DEFAULT, SKSYAKANA_KETACHK, "SKSYAKANA_KETACHK", false);
        addPattern(PATTERN_DEFAULT, ISHRHOUSITEIKBN_MINYUCHK, "ISHRHOUSITEIKBN_MINYUCHK", false);
        addPattern(PATTERN_DEFAULT, KZDOUKBN_SKSYAKBN_SKCHK, "KZDOUKBN_SKSYAKBN_SKCHK", false);
        addPattern(PATTERN_DEFAULT, KZMEIGINM_MINYUCHK_GAIKA, "KZMEIGINM_MINYUCHK_GAIKA", false);
        addPattern(PATTERN_DEFAULT, KYKDRKZDOUKBN_CHK, "KYKDRKZDOUKBN_CHK", false);
        addPattern(PATTERN_DEFAULT, SIUKTHOU_MINYUCHK, "SIUKTHOU_MINYUCHK", false);
        addPattern(PATTERN_DEFAULT, NKSYU_CHK, "NKSYU_CHK", false);
        addPattern(PATTERN_DEFAULT, SHRKKN_CHK, "SHRKKN_CHK", false);
        addPattern(PATTERN_DEFAULT, BNSHRKAISUU_CHK, "BNSHRKAISUU_CHK", false);
        addPattern(PATTERN_DEFAULT, NKKKN_CHK, "NKKKN_CHK", false);
        addPattern(PATTERN_DEFAULT, HAITOUUKTR_CHK, "HAITOUUKTR_CHK", false);
        addPattern(PATTERN_DEFAULT, NKSYU_MINYUCHK, "NKSYU_MINYUCHK", false);
        addPattern(PATTERN_DEFAULT, SHRKKN_MINYUCHK, "SHRKKN_MINYUCHK", false);
        addPattern(PATTERN_DEFAULT, BNSHRKAISUU_MINYUCHK, "BNSHRKAISUU_MINYUCHK", false);
        addPattern(PATTERN_DEFAULT, NKKKN_CHK_MINYUCHK, "NKKKN_CHK_MINYUCHK", false);
        addPattern(PATTERN_DEFAULT, HAITOUUKTR_MINYUCHK, "HAITOUUKTR_MINYUCHK", false);
        addPattern(PATTERN_DEFAULT, NSTK_NASICHK_ZNITIIGAI, "NSTK_NASICHK_ZNITIIGAI", false);
        addPattern(PATTERN_DEFAULT, NSTK_CHK_ZNITII, "NSTK_CHK_ZNITII", false);
        addPattern(PATTERN_DEFAULT, NSTK_CHK_NKSYS, "NSTK_CHK_NKSYS", false);
        addPattern(PATTERN_DEFAULT, NSTK_CHK_UKTHUKUSUU, "NSTK_CHK_UKTHUKUSUU", false);
        addPattern(PATTERN_DEFAULT, NKSHR_KAISIGO_CHK_ITINK, "NKSHR_KAISIGO_CHK_ITINK", false);
        addPattern(PATTERN_DEFAULT, NKSHR_KAISIGO_CHK_HENKOU, "NKSHR_KAISIGO_CHK_HENKOU", false);
        addPattern(PATTERN_DEFAULT, SAKUSEIKBN_MINYUCHK, "SAKUSEIKBN_MINYUCHK", false);
        addPattern(PATTERN_DEFAULT, SAKUSEI_HASSOU_SKCHK, "SAKUSEI_HASSOU_SKCHK", false);
        addPattern(PATTERN_DEFAULT, NSTK_HASSOU_SKCHK, "NSTK_HASSOU_SKCHK", false);
        addPattern(PATTERN_DEFAULT, SAIKEN_SAKUSEIKBN_CHK, "SAIKEN_SAKUSEIKBN_CHK", false);
        addPattern(PATTERN_DEFAULT, KRKKEIJYOU_SAKUSEIKBN_CHK, "KRKKEIJYOU_SAKUSEIKBN_CHK", false);
        addPattern(PATTERN_DEFAULT, HONNINKAKNIN_CHK, "HONNINKAKNIN_CHK", false);
        addPattern(PATTERN_DEFAULT, KIJYUNYMD_MINYUCHK, "KIJYUNYMD_MINYUCHK", false);
        addPattern(PATTERN_DEFAULT, KIJYUN_SYORUIUKE_SKCHK, "KIJYUN_SYORUIUKE_SKCHK", false);
        addPattern(PATTERN_DEFAULT, KIJYUN_KHENKOU_SKCHK, "KIJYUN_KHENKOU_SKCHK", false);
        addPattern(PATTERN_DEFAULT, KIJYUN_HHENKOU_SKCHK, "KIJYUN_HHENKOU_SKCHK", false);
        addPattern(PATTERN_DEFAULT, SYORUIUKEYMD_SAKICHK, "SYORUIUKEYMD_SAKICHK", false);
        addPattern(PATTERN_DEFAULT, HUBIKANRYOUYMD_SAKICHK, "HUBIKANRYOUYMD_SAKICHK", false);
        addPattern(PATTERN_DEFAULT, HUBI_SYORUIUKE_SKCHK, "HUBI_SYORUIUKE_SKCHK", false);
        addPattern(PATTERN_DEFAULT, HUBIKANRYOUYMD_MINYUCHK, "HUBIKANRYOUYMD_MINYUCHK", false);
        addPattern(PATTERN_DEFAULT, GENINKBN_CHK, "GENINKBN_CHK", false);
        addPattern(PATTERN_DEFAULT, SYUHIYOU_CHK, "SYUHIYOU_CHK", false);
        addPattern(PATTERN_DEFAULT, SAIGAI_GAITOU_CHK, "SAIGAI_GAITOU_CHK", false);
        addPattern(PATTERN_DEFAULT, SAIKEN_ITIBU_MINYUCHK, "SAIKEN_ITIBU_MINYUCHK", false);
        addPattern(PATTERN_DEFAULT, SAIKEN_ZENBU_MINYUCHK, "SAIKEN_ZENBU_MINYUCHK", false);
        addPattern(PATTERN_DEFAULT, SAIKEN_ADRKJ_KETACHK, "SAIKEN_ADRKJ_KETACHK", false);
        addPattern(PATTERN_DEFAULT, SAISATEI_CHK1, "SAISATEI_CHK1", false);
        addPattern(PATTERN_DEFAULT, SAISATEI_CHK2, "SAISATEI_CHK2", false);
        addPattern(PATTERN_DEFAULT, SUKETORIHOUHOU_MINYUCHK, "SUKETORIHOUHOU_MINYUCHK", false);
        addPattern(PATTERN_DEFAULT, SYOUMETU_CHK, "SYOUMETU_CHK", false);
        addPattern(PATTERN_DEFAULT, DOUJISKSYORITYUU_CHK, "DOUJISKSYORITYUU_CHK", false);
        addPattern(PATTERN_DEFAULT, KHSYORITYUU_KAIYK, "KHSYORITYUU_KAIYK", false);
        addPattern(PATTERN_DEFAULT, KHSYORITYUU_GENGAKU, "KHSYORITYUU_GENGAKU", false);
        addPattern(PATTERN_DEFAULT, KHSYORITYUU_OTHER, "KHSYORITYUU_OTHER", false);
        addPattern(PATTERN_DEFAULT, KHSYORITYUU_STDRSKTKYTTHK, "KHSYORITYUU_STDRSKTKYTTHK", false);
        addPattern(PATTERN_DEFAULT, KHSYORITYUU_JDKIGMBRTKYKHNK, "KHSYORITYUU_JDKIGMBRTKYKHNK", false);
        addPattern(PATTERN_DEFAULT, KHSYORITYUU_MKHGKHNK, "KHSYORITYUU_MKHGKHNK", false);
        addPattern(PATTERN_DEFAULT, KHSYORITYUU_SYOUKENSAIHAKKOU, "KHSYORITYUU_SYOUKENSAIHAKKOU", false);
        addPattern(PATTERN_DEFAULT, KHSYORITYUU_TMTTKINITEN, "KHSYORITYUU_TMTTKINITEN", false);
        addPattern(PATTERN_DEFAULT, KHSYORITYUU_DSHR, "KHSYORITYUU_DSHR", false);
        addPattern(PATTERN_DEFAULT, KHSYORITYUU_HARAIKATAHENKOU, "KHSYORITYUU_HARAIKATAHENKOU", false);
        addPattern(PATTERN_DEFAULT, KHSYORITYUU_YENDTHNKUKTKNINI, "KHSYORITYUU_YENDTHNKUKTKNINI", false);
        addPattern(PATTERN_DEFAULT, SKNNKAISIYMD_CHK, "SKNNKAISIYMD_CHK", false);
        addPattern(PATTERN_DEFAULT, HKNKKN_CHK, "HKNKKN_CHK", false);
        addPattern(PATTERN_DEFAULT, PHRKYUYOKKN_CHK, "PHRKYUYOKKN_CHK", false);
        addPattern(PATTERN_DEFAULT, FSTPHRKYUYOKKNTYO_CHK, "FSTPHRKYUYOKKNTYO_CHK", false);
        addPattern(PATTERN_DEFAULT, TOKKOUDOSGHTNP_CHK, "TOKKOUDOSGHTNP_CHK", false);
        addPattern(PATTERN_DEFAULT, SISHRSAKUGENKKN_CHK, "SISHRSAKUGENKKN_CHK", false);
        addPattern(PATTERN_DEFAULT, NENKINKKN_CHK, "NENKINKKN_CHK", false);
        addPattern(PATTERN_DEFAULT, NKNENGK_CHK, "NKNENGK_CHK", false);
        addPattern(PATTERN_DEFAULT, SAITEIBNTNKGK_CHK, "SAITEIBNTNKGK_CHK", false);
        addPattern(PATTERN_DEFAULT, TTDKTYUUI_CHK, "TTDKTYUUI_CHK", false);
        addPattern(PATTERN_DEFAULT, UKT_CHK, "UKT_CHK", false);
        addPattern(PATTERN_DEFAULT, FSTPNYKN_MINYUCHK, "FSTPNYKN_MINYUCHK", false);
        addPattern(PATTERN_DEFAULT, SINSATYUUI_CHK, "SINSATYUUI_CHK", false);
        addPattern(PATTERN_DEFAULT, MRFKOUZATRATKI_CHK, "MRFKOUZATRATKI_CHK", false);
        addPattern(PATTERN_DEFAULT, KEIYAKUSYAHNK_CHK, "KEIYAKUSYAHNK_CHK", false);
        addPattern(PATTERN_DEFAULT, DSKAIYAKUSYORI_CHK, "DSKAIYAKUSYORI_CHK", false);
        addPattern(PATTERN_DEFAULT, KYKYMDCHECK_CHK, "KYKYMDCHECK_CHK", false);
        addPattern(PATTERN_DEFAULT, ENDTHNKYMDCHECK_CHK, "ENDTHNKYMDCHECK_CHK", false);
        addPattern(PATTERN_DEFAULT, HRMBRCHECK_KEIUKEDOU_CHK, "HRMBRCHECK_KEIUKEDOU_CHK", false);
        addPattern(PATTERN_DEFAULT, HRMBRCHECK_KEIUKEBETU_CHK, "HRMBRCHECK_KEIUKEBETU_CHK", false);
        addPattern(PATTERN_DEFAULT, D_SEIGOUSEI_CHK, "D_SEIGOUSEI_CHK", false);
        addPattern(PATTERN_DEFAULT, D_MIHANEI_CHK, "D_MIHANEI_CHK", false);
        addPattern(PATTERN_DEFAULT, D_SHRYMDUMU_CHK, "D_SHRYMDUMU_CHK", false);
        addPattern(PATTERN_DEFAULT, TMTTKIN_MIHANEI_CHK, "TMTTKIN_MIHANEI_CHK", false);
        addPattern(PATTERN_DEFAULT, TMTTKIN_ITENBI_CHK, "TMTTKIN_ITENBI_CHK", false);
        addPattern(PATTERN_DEFAULT, SATEICHK_JISATUMENSEKI, "SATEICHK_JISATUMENSEKI", false);
        addPattern(PATTERN_DEFAULT, SATEICHK_SKNNKAISIYMD, "SATEICHK_SKNNKAISIYMD", false);
        addPattern(PATTERN_DEFAULT, SATEICHK_GENGK, "SATEICHK_GENGK", false);
        addPattern(PATTERN_DEFAULT, SATEICHK_MEIGIHN_AMONTH, "SATEICHK_MEIGIHN_AMONTH", false);
        addPattern(PATTERN_DEFAULT, SATEICHK_MEIGIHN_KSYOUHI, "SATEICHK_MEIGIHN_KSYOUHI", false);
        addPattern(PATTERN_DEFAULT, SATEICHK_MEIGIHN_SIBOUGO, "SATEICHK_MEIGIHN_SIBOUGO", false);
        addPattern(PATTERN_DEFAULT, SATEICHK_MEIGIHN_KD, "SATEICHK_MEIGIHN_KD", false);
        addPattern(PATTERN_DEFAULT, SATEICHK_STKNSET_UMU, "SATEICHK_STKNSET_UMU", false);
        addPattern(PATTERN_DEFAULT, SATEICHK_STKNSET_KAIYAKU, "SATEICHK_STKNSET_KAIYAKU", false);
        addPattern(PATTERN_DEFAULT, SATEICHK_HASANTOUSAN, "SATEICHK_HASANTOUSAN", false);
        addPattern(PATTERN_DEFAULT, SATEICHK_SASIOSAE, "SATEICHK_SASIOSAE", false);
        addPattern(PATTERN_DEFAULT, SATEICHK_SOUSASYOUKAI, "SATEICHK_SOUSASYOUKAI", false);
        addPattern(PATTERN_DEFAULT, SATEICHK_HUSYOU_BYOUMEI, "SATEICHK_HUSYOU_BYOUMEI", false);
        addPattern(PATTERN_DEFAULT, SATEICHK_HUSYOU_GENINKBN, "SATEICHK_HUSYOU_GENINKBN", false);
        addPattern(PATTERN_DEFAULT, SATEICHK_HUSYOU_KSYOUHI, "SATEICHK_HUSYOU_KSYOUHI", false);
        addPattern(PATTERN_DEFAULT, SATEICHK_KAIGAISIBOU, "SATEICHK_KAIGAISIBOU", false);
        addPattern(PATTERN_DEFAULT, SATEICHK_HANSYA, "SATEICHK_HANSYA", false);
        addPattern(PATTERN_DEFAULT, SATEICHK_SKSYORUI, "SATEICHK_SKSYORUI", false);
        addPattern(PATTERN_DEFAULT, SATEICHK_KAIGAI, "SATEICHK_KAIGAI", false);
        addPattern(PATTERN_DEFAULT, SATEICHK_MRINFO, "SATEICHK_MRINFO", false);
        addPattern(PATTERN_DEFAULT, SATEICHK_HIGAITOU, "SATEICHK_HIGAITOU", false);
        addPattern(PATTERN_DEFAULT, SATEICHK_SAIGAI_GENINKBN, "SATEICHK_SAIGAI_GENINKBN", false);
        addPattern(PATTERN_DEFAULT, SATEICHK_SAIGAI_BYOUMEI, "SATEICHK_SAIGAI_BYOUMEI", false);
        addPattern(PATTERN_DEFAULT, SATEICHK_SAIGAI_KSYOUHI, "SATEICHK_SAIGAI_KSYOUHI", false);
        addPattern(PATTERN_DEFAULT, SATEICHK_SAIGAI_SKSYORUI, "SATEICHK_SAIGAI_SKSYORUI", false);
        addPattern(PATTERN_DEFAULT, SATEICHK_SAISATEI, "SATEICHK_SAISATEI", false);
        addPattern(PATTERN_DEFAULT, SATEICHK_SAIKENKAIYAKU, "SATEICHK_SAIKENKAIYAKU", false);
        addPattern(PATTERN_DEFAULT, SATEICHK_SGSBJISATUMENSEKI_GENINKBN, "SATEICHK_SGSBJISATUMENSEKI_GENINKBN", false);
        addPattern(PATTERN_DEFAULT, SATEICHK_SGSBJISATUMENSEKI_BYOUMEI, "SATEICHK_SGSBJISATUMENSEKI_BYOUMEI", false);
        addPattern(PATTERN_DEFAULT, SATEICHK_SGSBJISATUMENSEKI_KSYOUHI, "SATEICHK_SGSBJISATUMENSEKI_KSYOUHI", false);
        addPattern(PATTERN_DEFAULT, SATEICHK_SGSBJISATUMENSEKI_SKSYORUI, "SATEICHK_SGSBJISATUMENSEKI_SKSYORUI", false);
        addPattern(PATTERN_DEFAULT, SYORUIUKEYMD_TIENRSKCHK, "SYORUIUKEYMD_TIENRSKCHK", false);
        addPattern(PATTERN_DEFAULT, HONNINKAKNIN_HKNGK_CHK, "HONNINKAKNIN_HKNGK_CHK", false);
        addPattern(PATTERN_DEFAULT, MNNO_KYK_HUYOUCHK, "MNNO_KYK_HUYOUCHK", false);
        addPattern(PATTERN_DEFAULT, MNNO_KYK_MINYUCHK, "MNNO_KYK_MINYUCHK", false);
        addPattern(PATTERN_DEFAULT, MNNO_UKT_MINYUCHK, "MNNO_UKT_MINYUCHK", false);
        addPattern(PATTERN_DEFAULT, MNNO_GAI_KYK_HUYOUCHK, "MNNO_GAI_KYK_HUYOUCHK", false);
        addPattern(PATTERN_DEFAULT, MNNO_GAI_UKT_HUYOUCHK, "MNNO_GAI_UKT_HUYOUCHK", false);
        addPattern(PATTERN_DEFAULT, SYKSBYENSITIHSYUTKTEKI_CHK, "SYKSBYENSITIHSYUTKTEKI_CHK", false);
        addPattern(PATTERN_DEFAULT, SAISBYENSITIHSYUTKTEKI_CHK, "SAISBYENSITIHSYUTKTEKI_CHK", false);


        lock(C_SKNaiyouChkKbn.class);
    }

    private C_SKNaiyouChkKbn(String value) {
        super(value);
    }

    public static C_SKNaiyouChkKbn valueOf(String value) {
        return valueOf(C_SKNaiyouChkKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_SKNaiyouChkKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_SKNaiyouChkKbn.class, patternId, value);
    }
}
