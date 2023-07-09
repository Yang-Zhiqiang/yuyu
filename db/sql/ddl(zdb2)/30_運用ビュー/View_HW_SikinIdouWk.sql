CREATE VIEW HW_SikinIdouWk AS SELECT
     nyksyoriymd ,         /* 入金処理日 */
     itirenno ,         /* 一連番号 */
     syoriYmd ,         /* 処理年月日 */
     sikinidoumotohonkouzacd ,         /* 資金移動元本口座コード */
     sikinidousakihonkouzacd ,         /* 資金移動先本口座コード */
     sikinidougaku ,         /* 資金移動額 */
     sikinidougaku$ ,         /* 資金移動額(通貨型) */
     nykmosno ,         /* 入金用申込番号 */
     gyoumuKousinsyaId ,         /* 業務用更新者ＩＤ */
     gyoumuKousinTime ,         /* 業務用更新時間 */
     kousinsyaId ,         /* 更新者ＩＤ */
     kousinTime ,         /* 更新時間 */
     kousinKinou ,         /* 更新機能 */
     version           /* バージョン */
FROM HW_SikinIdouWk_Z;