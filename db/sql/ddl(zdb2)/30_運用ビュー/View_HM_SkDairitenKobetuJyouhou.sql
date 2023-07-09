CREATE VIEW HM_SkDairitenKobetuJyouhou AS SELECT
     oyadrtencd ,         /* 親代理店コード */
     utdskknnm1kj ,         /* 打出機関名１（漢字） */
     utdskknnm2kj ,         /* 打出機関名２（漢字） */
     nykntratkikbn ,         /* 入金取扱区分 */
     trksskssouhukbn ,         /* 取消請求書送付区分 */
     tkhjnkinyuucd ,         /* 特定関係法人金融機関コード */
     drtentrkno ,         /* 代理店登録番号 */
     cifcdcheckyouhi ,         /* ＣＩＦコードチェック要否 */
     cifcdsiteiketasuu ,         /* ＣＩＦコード指定桁数 */
     cifcdmaezeroumeyouhi ,         /* ＣＩＦコード前ゼロ埋め要否 */
     kosymd ,         /* 更新日 */
     gyoumuKousinsyaId ,         /* 業務用更新者ＩＤ */
     gyoumuKousinTime ,         /* 業務用更新時間 */
     kousinsyaId ,         /* 更新者ＩＤ */
     kousinTime ,         /* 更新時間 */
     kousinKinou ,         /* 更新機能 */
     version           /* バージョン */
FROM HM_SkDairitenKobetuJyouhou_Z;