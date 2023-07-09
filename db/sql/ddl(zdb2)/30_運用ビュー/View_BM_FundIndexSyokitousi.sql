CREATE VIEW BM_FundIndexSyokitousi AS SELECT
     unitfundkbn ,         /* ユニットファンド区分 */
     fundhyoukaymd ,         /* ファンド評価年月日　　　　 */
     segkey ,         /* ＳＥＧＫＥＹ　　　　　　　　 */
     syokisegsakuseijiyuu ,         /* 初期投資ＳＥＧ作成事由 */
     syokitousisetteigaku ,         /* 初期投資設定額 */
     syokitousisetteigaku$ ,         /* 初期投資設定額(通貨型) */
     syokigoukeihensaigaku ,         /* 初期投資合計返済額 */
     syokigoukeihensaigaku$ ,         /* 初期投資合計返済額(通貨型) */
     syokirisokuhensaigaku ,         /* 初期投資利息返済額 */
     syokirisokuhensaigaku$ ,         /* 初期投資利息返済額(通貨型) */
     syokigankinhensaigaku ,         /* 初期投資元金返済額 */
     syokigankinhensaigaku$ ,         /* 初期投資元金返済額(通貨型) */
     syokitousirisoku ,         /* 初期投資利息 */
     syokitousirisoku$ ,         /* 初期投資利息(通貨型) */
     syokigankinkuriiregaku ,         /* 初期投資元金繰入金額 */
     syokigankinkuriiregaku$ ,         /* 初期投資元金繰入金額(通貨型) */
     gksyokitousisetteigaku ,         /* （外貨）初期投資設定額 */
     gksyokitousisetteigaku$ ,         /* （外貨）初期投資設定額(通貨型) */
     gksyokigoukeihensaigaku ,         /* （外貨）初期投資合計返済額 */
     gksyokigoukeihensaigaku$ ,         /* （外貨）初期投資合計返済額(通貨型) */
     gksyokirisokuhensaigaku ,         /* （外貨）初期投資利息返済額 */
     gksyokirisokuhensaigaku$ ,         /* （外貨）初期投資利息返済額(通貨型) */
     gksyokigankinhensaigaku ,         /* （外貨）初期投資元金返済額 */
     gksyokigankinhensaigaku$ ,         /* （外貨）初期投資元金返済額(通貨型) */
     gksyokitousirisoku ,         /* （外貨）初期投資利息 */
     gksyokitousirisoku$ ,         /* （外貨）初期投資利息(通貨型) */
     gksyokigankinkuriiregaku ,         /* （外貨）初期投資元金繰入金額 */
     gksyokigankinkuriiregaku$ ,         /* （外貨）初期投資元金繰入金額(通貨型) */
     syokitousigankinkrirkbn ,         /* 初期投資元金繰入区分 */
     zenkaistsegsakuseiymd ,         /* 前回初期投資ＳＥＧ作成年月日 */
     kousinsyaId ,         /* 更新者ＩＤ */
     kousinTime ,         /* 更新時間 */
     kousinKinou ,         /* 更新機能 */
     version           /* バージョン */
FROM BM_FundIndexSyokitousi_Z;