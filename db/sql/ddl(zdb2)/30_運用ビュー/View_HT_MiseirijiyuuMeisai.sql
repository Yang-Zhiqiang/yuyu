CREATE VIEW HT_MiseirijiyuuMeisai AS SELECT
     mosno ,         /* 申込番号 */
     syono ,         /* 証券番号 */
     kyknmkn ,         /* 契約者名（カナ） */
     sknnkaisiymd ,         /* 責任開始日 */
     kykymd ,         /* 契約日 */
     miseirijiyuukbn ,         /* 未整理事由区分 */
     miseirijiyuudetailkbn ,         /* 未整理事由詳細区分 */
     nyuukinjoutaikbn ,         /* 入金状態区分 */
     syoruikbn1 ,         /* 書類区分１ */
     syoruikbn2 ,         /* 書類区分２ */
     syoruikbn3 ,         /* 書類区分３ */
     syoruikbn4 ,         /* 書類区分４ */
     syoruikbn5 ,         /* 書類区分５ */
     syoruikbn6 ,         /* 書類区分６ */
     syoruikbn7 ,         /* 書類区分７ */
     syoruikbn8 ,         /* 書類区分８ */
     syoruikbn9 ,         /* 書類区分９ */
     syoruikbn10 ,         /* 書類区分１０ */
     syoruihubikensuu ,         /* 書類不備件数 */
     syokaidenymd ,         /* 初回伝票日付 */
     syokairsymd ,         /* 初回領収日 */
     rsgakuen ,         /* 領収金額（円） */
     rsgakuen$ ,         /* 領収金額（円）(通貨型) */
     rsgakugaika ,         /* 領収金額（外貨） */
     rsgakugaika$ ,         /* 領収金額（外貨）(通貨型) */
     rstuukasyu ,         /* 領収通貨種類 */
     krkhuho2syoukai ,         /* 仮受金（普保Ⅱ初回） */
     krkhuho2syoukai$ ,         /* 仮受金（普保Ⅱ初回）(通貨型) */
     krkhuho2kobetu ,         /* 仮受金（普保Ⅱ個別） */
     krkhuho2kobetu$ ,         /* 仮受金（普保Ⅱ個別）(通貨型) */
     gyoumuKousinsyaId ,         /* 業務用更新者ＩＤ */
     gyoumuKousinTime ,         /* 業務用更新時間 */
     kousinsyaId ,         /* 更新者ＩＤ */
     kousinTime ,         /* 更新時間 */
     kousinKinou ,         /* 更新機能 */
     version ,         /* バージョン */
     krkdai1kaikeijyougkyen ,         /* 仮受金（第１回）計上額（円） */
     krkdai1kaikeijyougkyen$ ,         /* 仮受金（第１回）計上額（円）(通貨型) */
     krkdai1kaikeijyougkgaika ,         /* 仮受金（第１回）計上額（外貨） */
     krkdai1kaikeijyougkgaika$ ,         /* 仮受金（第１回）計上額（外貨）(通貨型) */
     krkdai1kaituukasyu           /* 仮受金（第１回）通貨種類 */
FROM HT_MiseirijiyuuMeisai_Z;