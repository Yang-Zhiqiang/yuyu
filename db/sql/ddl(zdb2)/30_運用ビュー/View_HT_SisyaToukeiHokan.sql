CREATE VIEW HT_SisyaToukeiHokan AS SELECT
     sstmosno ,         /* 支社統計用申込番号 */
     renno ,         /* 連番 */
     syrctrltblkostime ,         /* 処理コントロールTBL更新時間 */
     sstsyono ,         /* 支社統計用証券番号 */
     sstmosym ,         /* 支社統計用申込月度 */
     sstmoskbn ,         /* 支社統計用申込区分 */
     sstbosyuudrtenatkikeitaikbn ,         /* 支社統計用募集代理店扱形態区分 */
     sstkydatkikbn ,         /* 支社統計用共同扱区分 */
     sstatukaisyadrtenhyouji ,         /* 支社統計用扱者代理店表示 */
     tratkiagcd ,         /* 取扱代理店コード */
     ssteigyouhonbusisyacd ,         /* 支社統計用営業本部支社コード */
     sstsosikicd ,         /* 支社統計用組織コード */
     sstatkisyagyskkjsosikicd ,         /* 支社統計用扱者業績計上先組織コード */
     sstcifcd ,         /* 支社統計用ＣＩＦコード */
     sstatkisyadrtenatkiwari ,         /* 支社統計用扱者代理店扱割合 */
     ssttsrybnwari ,         /* 支社統計用手数料分割割合 */
     sstsinhsys ,         /* 支社統計用新保障Ｓ */
     sstsoukensuu ,         /* 支社統計用総件数 */
     sstkydatkidairitencd ,         /* 支社統計用共同扱代理店コード */
     sstbosyuudrtenkobetuinfo1 ,         /* 支社統計用募集代理店個別情報１ */
     sstbosyuudrtenkobetuinfo2 ,         /* 支社統計用募集代理店個別情報２ */
     sstbosyuudrtenkobetuinfo3 ,         /* 支社統計用募集代理店個別情報３ */
     sstbosyuudrtenkobetuinfo4 ,         /* 支社統計用募集代理店個別情報４ */
     sstbosyuudrtenkobetuinfo5 ,         /* 支社統計用募集代理店個別情報５ */
     sstbankkouincd ,         /* 支社統計用銀行行員コード */
     sstdaihyoubosyuunincd ,         /* 支社統計用代表募集人コード */
     sstatukaikojincd ,         /* 支社統計用扱者個人コード */
     sstkanjihihokensyanm ,         /* 支社統計用漢字被保険者名 */
     ssttansyukukjhhknnm ,         /* 支社統計用短縮漢字被保険者名 */
     ssthhknsyokugyoucd ,         /* 支社統計用被保険者職業コード */
     ssthhknnen2keta ,         /* 支社統計用被保険者年令（２桁） */
     ssthhknseikbn ,         /* 支社統計用被保険者性別区分 */
     ssthhknseiymd ,         /* 支社統計用被保険者生年月日 */
     sstkjkyknm ,         /* 支社統計用漢字契約者名 */
     sstkjkyknm10 ,         /* 支社統計用漢字契約者名（１０文字） */
     sstknkyknm15 ,         /* 支社統計用カナ契約者名（１５文字） */
     sstknkyknm18 ,         /* 支社統計用カナ契約者名（１８文字） */
     sstkyksyanen ,         /* 支社統計用契約者年令 */
     sstkyksyaseikbn ,         /* 支社統計用契約者性別区分 */
     ssthjnkykhyj ,         /* 支社統計用法人契約表示 */
     sstkjhjnnm ,         /* 支社統計用漢字法人名 */
     sstseirituyoukihontikucd ,         /* 支社統計用成立率用基本地区コード */
     sstmossyoumetukbn ,         /* 支社統計用申込消滅区分 */
     sstkurikosiriyuukbn ,         /* 支社統計用繰越理由区分 */
     sstnyknzumihyouji ,         /* 支社統計用入金済表示 */
     sstnyknjkkbn ,         /* 支社統計用入金状況区分 */
     ssthoujyoukokutikbn ,         /* 支社統計用報状告知区分 */
     sstkykkeitaikbn ,         /* 支社統計用契約形態区分 */
     sstketteijkkbn ,         /* 支社統計用決定状況区分 */
     sstdakuhiketteijyoutaikbn ,         /* 支社統計用諾否決定状態区分 */
     sstdakuhiketteikekkacd ,         /* 支社統計用諾否決定結果コード */
     sstdakuhiketteiymd ,         /* 支社統計用諾否決定年月日 */
     ssttokusyujimutoriatukaikbn ,         /* 支社統計用特殊事務取扱区分 */
     ssttoukeiyousinsakbn ,         /* 支社統計用統計用診査区分 */
     ssthonninkakuninkbn ,         /* 支社統計用本人確認区分 */
     sstdrtentsryhushrkykhyouji ,         /* 支社統計用代理店手数料不支払契約表示 */
     sstnyknkanskanouhyouji ,         /* 支社統計用入金勧奨可能表示 */
     sstdshukahyouji ,         /* 支社統計用ＤＳ付加表示 */
     sstsiteidairisktkykarihyouj ,         /* 支社統計用指定代理請求特約有表示 */
     ssttokuteikanikokutikbn ,         /* 支社統計用特定簡易告知区分 */
     sstkykkakuninsyuruikbn ,         /* 支社統計用契約確認種類区分 */
     sstkykkakuninjkkbn1 ,         /* 支社統計用契約確認状況区分（1文字） */
     sstmosketteikekkakbn ,         /* 支社統計用申込決定結果区分 */
     sstsinsazumihyouji ,         /* 支社統計用診査済表示 */
     sstannaisakicd ,         /* 支社統計用案内先コード */
     sstmosjkkbn ,         /* 支社統計用申込状況区分 */
     sstkihonhubi ,         /* 支社統計用基本不備 */
     sstsphubi ,         /* 支社統計用ＳＰ不備 */
     sstsseigenhubi ,         /* 支社統計用Ｓ制限不備 */
     sstnayosehumei ,         /* 支社統計用名寄不明 */
     ssttuusangendoover ,         /* 支社統計用通算限度オーバー */
     sstmosketteihoryuu ,         /* 支社統計用申込決定保留 */
     sstkykkakuninjissityuu ,         /* 支社統計用契約確認実施中 */
     sstkokutiketteihoryuu ,         /* 支社統計用告知決定保留 */
     ssthonsyaketteihoryuu ,         /* 支社統計用本社決定保留 */
     sstseiymdhubi ,         /* 支社統計用生年月日不備 */
     sstphusoku ,         /* 支社統計用Ｐ不足 */
     sstseirituhoryuuuketuketyuu ,         /* 支社統計用成立保留受付中 */
     sstpkakin ,         /* 支社統計用Ｐ過金 */
     sstketteihoryuuhubihyouji ,         /* 支社統計用決定保留不備表示 */
     sstseirituhoryuuhubihyouji ,         /* 支社統計用成立保留不備表示 */
     sstyohurimiryou ,         /* 支社統計用預振未了 */
     ssttoukeiyouhknsyuruikbn ,         /* 支社統計用統計用保険種類区分 */
     ssthknsyuruinm ,         /* 支社統計用保険種類名称 */
     ssthknkkn ,         /* 支社統計用保険期間 */
     sstphrkkikn ,         /* 支社統計用Ｐ払込期間 */
     ssthrkkaisuukbn ,         /* 支社統計用払込回数区分 */
     ssthrkkeirokbn ,         /* 支社統計用払込経路区分 */
     sstnkshrtkykarihyouji ,         /* 支社統計用年金支払特約有表示 */
     sstnkshrtkyknkkkn ,         /* 支社統計用年金支払特約年金期間 */
     sstjyunhsys ,         /* 支社統計用純保障Ｓ */
     ssthsys ,         /* 支社統計用保障Ｓ */
     sstkyktuuka ,         /* 支社統計用契約通貨 */
     ssthrktuuka ,         /* 支社統計用払込通貨 */
     ssttuukatanikbn ,         /* 支社統計用通貨単位区分 */
     sstfstphrkgkyen ,         /* 支社統計用初回Ｐ払込必要額（円貨） */
     sstfstphrkgkhrktuukamoji ,         /* 支社統計用初回Ｐ払込必要額（払込通貨）（文字列） */
     sstfstphrkgkgaika ,         /* 支社統計用初回Ｐ払込必要額（外貨） */
     sstfstpsshkhrkgkyen ,         /* 支社統計用初回Ｐ差引払込額（円貨） */
     sstyennykntkykarihyouji ,         /* 支社統計用円入金特約有表示 */
     sstgaikanykntkykarihyouji ,         /* 支社統計用外貨入金特約有表示 */
     ssyenshrtkykarihyouji ,         /* 支社統計用円支払特約有表示 */
     sstkihonsgaika ,         /* 支社統計用基本Ｓ（外貨） */
     ssttekiyoukawaserate ,         /* 支社統計用適用為替レート */
     sstkawaseratetekiyouymd ,         /* 支社統計用為替レート適用年月日 */
     sstsakuseiymd ,         /* 支社統計用作成日 */
     sstmosymd ,         /* 支社統計用申込年月日 */
     sstkokutiymd ,         /* 支社統計用告知年月日 */
     sstmosnyuuryokuymd ,         /* 支社統計用申込入力年月日 */
     sstkouzanyuuryokuymd ,         /* 支社統計用口座入力年月日 */
     sstkykymd ,         /* 支社統計用契約年月日 */
     sstsekininkaisiymd ,         /* 支社統計用責任開始年月日 */
     sstsisyaketteisyoriymd ,         /* 支社統計用支社決定処理年月日 */
     sstsyoukensakuseiymd ,         /* 支社統計用証券作成年月日 */
     sstseisekikijyym ,         /* 支社統計用成績計上年月 */
     sstmossyoumetukakuteiymd ,         /* 支社統計用申込消滅確定年月日 */
     sstdrtenkeijyouym ,         /* 支社統計用代理店計上年月 */
     sstmostoutyakuymd ,         /* 支社統計用申込書到着年月日 */
     sstkkttoutyakuymd ,         /* 支社統計用告知書到着年月日 */
     sstmossakuseiymd ,         /* 支社統計用申込書作成年月日 */
     sstmosksnym ,         /* 支社統計用申込起算年月 */
     sstkariseirituymd ,         /* 支社統計用仮成立年月日 */
     sstsinsayoteiymd ,         /* 支社統計用診査予定年月日 */
     sstkousinymd ,         /* 支社統計用更新年月日 */
     sstryousyuuymd ,         /* 支社統計用領収年月日 */
     sstfstpryousyuuymd ,         /* 支社統計用初回Ｐ領収年月日 */
     sstfstpnyknsyoriymd ,         /* 支社統計用初回Ｐ入金処理年月日 */
     sstfstpnyknnaiyoukbn ,         /* 支社統計用初回Ｐ入金内容区分 */
     sstfstpnyknhouhoukbn2 ,         /* 支社統計用初回Ｐ入金方法区分（２文字） */
     sstdrtenpaperlessmoshyj ,         /* 支社統計用代理店ペーパーレス申込表示 */
     sstdrtenmostousyaukeymd ,         /* 支社統計用代理店申込書当社受付年月日 */
     sstmkhyoutiyensysnikoukbn ,         /* 支社統計用目標到達時円建終身保障移行区分 */
     sstsyksbyensitihsyutkykhyj ,         /* 支社統計用初期死亡時円換算最低保証特約有表示 */
     sstjyudkaigomehrtkarihyj ,         /* 支社統計用重度介護前払特約有表示 */
     sstfstphrkgksiteituuka ,         /* 支社統計用初回Ｐ払込必要額（指定通貨） */
     sstteirituhaibunwari ,         /* 支社統計用定率部分配分割合 */
     sstsueokikknkbn ,         /* 支社統計用据置期間区分 */
     sstnksyuruikbn1 ,         /* 支社統計用年金種類（１文字） */
     sstsetaitemosno ,         /* 支社統計用セット相手申込番号 */
     sstyakkanjyuryouhoukbn ,         /* 支社統計用約款受領方法区分 */
     sstyakkanbunsyono ,         /* 支社統計用約款文書番号 */
     sstkzhuritourokuhoukbn ,         /* 支社統計用口座振替登録方法区分 */
     sstdai1hknkkn ,         /* 支社統計用第１保険期間 */
     sstcreditnyuuryokuymd ,         /* 支社統計用クレジット入力年月日 */
     sstcreditmiryou ,         /* 支社統計用クレカ未了 */
     sstcredittrkhoukbn ,         /* 支社統計用クレジット登録方法区分 */
     sstcardbrandkbn ,         /* 支社統計用カードブランド */
     sstcarddatasousinymd ,         /* 支社統計用カードデータ送信日 */
     sstkzktrkservicekbn ,         /* 支社統計用ご家族登録サービス区分 */
     sstkykdrtkykarihyj ,         /* 支社統計用契約者代理特約有表示 */
     sstteikishrtkykarihyouji ,         /* 支社統計用定期支払特約有表示 */
     sstteikishrkinshrtuukakbn ,         /* 支社統計用定期支払金支払通貨区分 */
     sstteikisiharaikin ,         /* 支社統計用定期支払金 */
     sstkoureikzksetumeihoukbn ,         /* 支社統計用高齢者ご家族等説明方法区分 */
     sstkoureimndnhukusuukaikbn ,         /* 支社統計用高齢者面談複数回実施区分 */
     sstkoureitratkisyaigidskkbn ,         /* 支社統計用高齢者取扱者以外同席区分 */
     gyoumuKousinKinou ,         /* 業務用更新機能ＩＤ */
     gyoumuKousinsyaId ,         /* 業務用更新者ＩＤ */
     gyoumuKousinTime ,         /* 業務用更新時間 */
     kousinsyaId ,         /* 更新者ＩＤ */
     kousinTime ,         /* 更新時間 */
     kousinKinou ,         /* 更新機能 */
     version           /* バージョン */
FROM HT_SisyaToukeiHokan_Z;