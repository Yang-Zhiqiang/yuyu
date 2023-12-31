CREATE VIEW HT_BosKihon AS SELECT
     mosno ,         /* 申込番号 */
     aitemosno ,         /* 相手申込番号 */
     doujikaiyakusyono ,         /* 同時解約証券番号 */
     sekno ,         /* 設計書番号 */
     mosuketukekbn ,         /* 申込受付区分 */
     mosymd ,         /* 申込日 */
     mossakuseiymd ,         /* 申込書作成日 */
     pplessmosukeymd ,         /* ペーパーレス申込書受付日 */
     pykkigenymd ,         /* 保険料有効期限年月日 */
     kktymd ,         /* 告知日 */
     moscalckijyunymd ,         /* 申込書計算基準日 */
     kykymdtkrumu ,         /* 契約日特例有無 */
     skykymd ,         /* 指定契約日 */
     kykkbn ,         /* 契約者区分 */
     hhknnmkn ,         /* 被保険者名（カナ） */
     hhknnmkj ,         /* 被保険者名（漢字） */
     hhknnmkjkhukakbn ,         /* 被保険者名漢字化不可区分 */
     hhknseiymd ,         /* 被保険者生年月日 */
     hhknnen ,         /* 被保険者年齢 */
     hhknsei ,         /* 被保険者性別 */
     hhknsykgycd ,         /* 被保険者職業コード */
     hhknnensyuukbn ,         /* 被保険者年収区分 */
     tsindousiteikbn ,         /* 通信先同一指定区分 */
     hhknyno ,         /* 被保険者郵便番号 */
     hhknadr1kj ,         /* 被保険者住所１（漢字） */
     hhknadr2kj ,         /* 被保険者住所２（漢字） */
     hhknadr3kj ,         /* 被保険者住所３（漢字） */
     hhkntelno ,         /* 被保険者電話番号 */
     hhknkinmusakinm ,         /* 被保険者勤務先名 */
     kyknmkn ,         /* 契約者名（カナ） */
     kyknmkj ,         /* 契約者名（漢字） */
     kyknmkjkhukakbn ,         /* 契約者名漢字化不可区分 */
     kykseiymd ,         /* 契約者生年月日 */
     kyknen ,         /* 契約者年齢 */
     kyksei ,         /* 契約者性別 */
     kyktdk ,         /* 契約者続柄 */
     kyknensyuukbn ,         /* 契約者年収区分 */
     kykkinmusakinm ,         /* 契約者勤務先名 */
     hjndaiykkbn ,         /* 法人代表者役職区分 */
     hjndainmkn ,         /* 法人代表者名（カナ） */
     hjndainmkj ,         /* 法人代表者名（漢字） */
     tsinyno ,         /* 通信先郵便番号 */
     tsinadr1kj ,         /* 通信先住所１（漢字） */
     tsinadr2kj ,         /* 通信先住所２（漢字） */
     tsinadr3kj ,         /* 通信先住所３（漢字） */
     tsintelno ,         /* 通信先電話番号 */
     dai2tsintelno ,         /* 第２通信先電話番号 */
     yakkanjyuryouhoukbn ,         /* 約款受領方法区分 */
     yakkanbunsyono ,         /* 約款文書番号 */
     fatcasnsikbn ,         /* ＦＡＴＣＡ宣誓区分 */
     bikkjnssinfokbn ,         /* 米国人示唆情報区分 */
     aeoisnsikbn ,         /* ＡＥＯＩ宣誓区分 */
     hknsyuruino ,         /* 保険種類番号 */
     hknsyuruinosd ,         /* 保険種類番号世代 */
     nkgnshosyouritukbn ,         /* 年金原資最低保証率区分 */
     livhukaumu ,         /* リビングニーズ付加有無 */
     pmnjtkhukakbn ,         /* 保険料免除特約付加区分 */
     pmnjtkkbn ,         /* 保険料免除特約区分 */
     kzktourokuservicetourokukbn ,         /* ご家族登録サービス登録区分 */
     kykdrtkykhukakbn ,         /* 契約者代理特約付加区分 */
     stdrsktkyhkkbn ,         /* 被保険者代理特約付加区分 */
     sdpdkbn ,         /* Ｓ建Ｐ建区分 */
     sntkhoukbn ,         /* 選択方法区分 */
     haitoukbn ,         /* 配当区分 */
     haitoukinuketorihoukbn ,         /* 配当金受取方法区分 */
     kyktuukasyu ,         /* 契約通貨種類 */
     hrktuukasyu ,         /* 払込通貨種類 */
     yennykntkhkkbn ,         /* 円入金特約付加区分 */
     gaikanykntkhkkbn ,         /* 外貨入金特約付加区分 */
     yenshrtkhkkbn ,         /* 円支払特約付加区分 */
     mosheijyunp ,         /* 申込平準払Ｐ */
     mosheijyunp$ ,         /* 申込平準払Ｐ(通貨型) */
     ikkatubaraikbn ,         /* 一括払区分 */
     ikkatubaraikaisuu ,         /* 一括払回数 */
     mosikkatup ,         /* 申込一括払Ｐ */
     mosikkatup$ ,         /* 申込一括払Ｐ(通貨型) */
     syutkpkei ,         /* 主契約・特約Ｐ合計金額 */
     syutkpkei$ ,         /* 主契約・特約Ｐ合計金額(通貨型) */
     fsthrkpkei ,         /* 初回払込Ｐ合計金額 */
     fsthrkpkei$ ,         /* 初回払込Ｐ合計金額(通貨型) */
     hrkkaisuu ,         /* 払込回数 */
     hrkkeiro ,         /* 払込経路 */
     fstphrkkeirokbn ,         /* 初回保険料払込経路区分 */
     zennoumousideumu ,         /* 前納申出有無 */
     zenkizennouumu ,         /* 全期前納有無 */
     znnkai ,         /* 前納回数 */
     moszennoupsyokaiari ,         /* 申込前納Ｐ（初回含） */
     moszennoupsyokaiari$ ,         /* 申込前納Ｐ（初回含）(通貨型) */
     targettkhkkbn ,         /* ターゲット特約付加区分 */
     targettkkbn ,         /* ターゲット特約区分 */
     targettkmkhtkbn ,         /* ターゲット特約目標値区分 */
     nstkhkkbn ,         /* 年金支払特約付加区分 */
     nstkmnknsyu ,         /* 年金支払特約満期年金種類 */
     nstkmnknkkn ,         /* 年金支払特約満期年金期間 */
     nstksbnsyu ,         /* 年金支払特約死亡年金種類 */
     nstksbnkkn ,         /* 年金支払特約死亡年金期間 */
     syksbyensitihsyutkhkkbn ,         /* 初期死亡時円換算最低保証特約付加区分 */
     jyudkaigomehrtkhkkbn ,         /* 重度介護前払特約付加区分 */
     kjnnkpzeitekitkhukakbn ,         /* 個人年金保険料税制適格特約付加区分 */
     teikisiharaitkykhkkbn ,         /* 定期支払特約付加区分 */
     sbuktnin ,         /* 死亡受取人人数 */
     kykhonninkakninsyoruikbn ,         /* 契約者本人確認書類区分 */
     skskknhonninkakninsyoruikbn ,         /* 親権者後見人本人確認書類区分 */
     koureikzksetumeihoukbn ,         /* 高齢者ご家族等説明方法区分 */
     koureimndnhukusuukaikbn ,         /* 高齢者面談複数回実施区分 */
     koureitratkisyaigidskkbn ,         /* 高齢者取扱者以外同席区分 */
     daihituumukbn ,         /* 代筆有無区分 */
     uktkid ,         /* 受付管理ＩＤ */
     drctservicemoskbn ,         /* ダイレクトサービス申込区分 */
     dsmailaddress ,         /* ＤＳメールアドレス */
     tokuteitrhkansyono ,         /* 特定取引用暗証番号 */
     pplessrenjidssymenttdkhyj ,         /* ペーパーレス連動時ＤＳ書面手続表示 */
     pplsrendoukouhurikousoukbn ,         /* ペーパーレス連動時口振申込書後送区分 */
     pplessrendoucreditkousoukbn ,         /* ペーパーレス連動時クレカ申込書後送区分 */
     hnsstjmmouumukbn ,         /* 本社集中事務申込有無区分 */
     kjmeigihkhunouumukbn ,         /* 漢字名義変換不能有無区分 */
     tsryhshrkykumukbn ,         /* 手数料不支払契約有無区分 */
     syosisyatodokeumukbn ,         /* 証券支社届有無区分 */
     kakukisyouryakukbumukbn ,         /* カク基省略希望有無区分 */
     seiymdmosseitouumukbn ,         /* 生年月日申込書正当有無区分 */
     ikokakninsyotokkijkumu ,         /* 意向確認書特記事項有無 */
     trtkhoukokusyotokkijkumu ,         /* 取扱報告書特記事項有無 */
     hnnkakninhskjikouumukbn ,         /* 本人確認補足事項有無 */
     hnnkakninhsktkjikouumukbn ,         /* 本人確認補足特定事項有無 */
     skskakninhsktkjikouumukbn ,         /* 親権者確認補足特定事項有無 */
     khnchkcmnt ,         /* 基本チェックコメント */
     mostourokujyoukyoukbn ,         /* 申込情報登録状況区分 */
     pplessdatasousinumukbn ,         /* ペーパーレスデータ送信有無区分 */
     mobilebosyuukbn ,         /* モバイル募集区分 */
     teirituhaibunwarikbn ,         /* 定率部分配分割合区分 */
     sisuukbn ,         /* 指数区分 */
     sisuuhaibunwarikbn ,         /* 指数部分配分割合区分 */
     trhkjikakkbn ,         /* 取引時確認区分 */
     koureitaioukbn ,         /* 高齢者対応区分 */
     gyoumuKousinsyaId ,         /* 業務用更新者ＩＤ */
     gyoumuKousinTime ,         /* 業務用更新時間 */
     kousinsyaId ,         /* 更新者ＩＤ */
     kousinTime ,         /* 更新時間 */
     kousinKinou ,         /* 更新機能 */
     version           /* バージョン */
FROM HT_BosKihon_Z;