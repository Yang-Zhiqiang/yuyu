CREATE VIEW HM_HurikomiKouza AS SELECT
     bankcd ,         /* 銀行コード */
     sitencd ,         /* 支店コード */
     kouzano ,         /* 口座番号 */
     tuukasyu ,         /* 通貨種類 */
     hrkmirnincd ,         /* 振込依頼人コード */
     yokinkbn ,         /* 預金種目区分 */
     oyadrtencd ,         /* 親代理店コード */
     nyuukinoyadrtennm ,         /* 入金用親代理店名 */
     oyadrtensyoritarget ,         /* 親代理店処理対象 */
     jidonykntargethyouji ,         /* 自動入金対象表示 */
     hrkmirnineditptnkbn ,         /* 振込依頼人編集パターン区分 */
     kousinsyaId ,         /* 更新者ＩＤ */
     kousinTime ,         /* 更新時間 */
     kousinKinou ,         /* 更新機能 */
     version ,         /* バージョン */
     siteituuka ,         /* 指定通貨 */
     honkouzacd           /* 本口座コード */
FROM HM_HurikomiKouza_Z;