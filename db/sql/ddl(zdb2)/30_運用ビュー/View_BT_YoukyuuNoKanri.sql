CREATE VIEW BT_YoukyuuNoKanri AS SELECT
     youkyuuno ,         /* 要求通番 */
     huho2kyknokbn ,         /* 普保Ⅱ契約番号区分 */
     huho2kykno ,         /* 普保Ⅱ契約番号 */
     mqkousinmqsyorikekkakbn ,         /* （ＭＱ更新用）ＭＱ処理結果区分 */
     mqkousinacserrcd ,         /* （ＭＱ更新用）ＡＣＳ基盤エラーコード */
     mqtrksiraimqsyorikekkakbn ,         /* （ＭＱ取消依頼用）ＭＱ処理結果区分 */
     mqtrksiraiacserrcd ,         /* （ＭＱ取消依頼用）ＡＣＳ基盤エラーコード */
     kyknaiyouhaneierrkbn ,         /* 契約内容反映エラー区分 */
     trkskekkakbn ,         /* 取消結果区分 */
     jdtrkspaltrkszankbn ,         /* 自動取消用ＰＡＬ取消残区分 */
     gyoumuKousinKinou ,         /* 業務用更新機能ＩＤ */
     gyoumuKousinsyaId ,         /* 業務用更新者ＩＤ */
     gyoumuKousinTime ,         /* 業務用更新時間 */
     kousinsyaId ,         /* 更新者ＩＤ */
     kousinTime ,         /* 更新時間 */
     kousinKinou ,         /* 更新機能 */
     version           /* バージョン */
FROM BT_YoukyuuNoKanri_Z;