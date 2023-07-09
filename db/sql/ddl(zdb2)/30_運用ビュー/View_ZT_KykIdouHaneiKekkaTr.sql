CREATE VIEW ZT_KykIdouHaneiKekkaTr AS SELECT
     ztrhuho2kyknokbn ,         /* （取込用）普保Ⅱ契約番号区分 */
     ztrhuho2kykno ,         /* （取込用）普保Ⅱ契約番号 */
     ztrkyknaiyouhaneierrkbn ,         /* （取込用）契約内容反映エラー区分 */
     ztrtsnkijyuntyoukahyj ,         /* （取込用）通算基準超過表示 */
     ztrhhknnayosehumeihyj ,         /* （取込用）被保険者名寄せ不明表示 */
     ztrkyknayosehumeihyj ,         /* （取込用）契約者名寄せ不明表示 */
     ztrnkuktnayosehumeihyj ,         /* （取込用）年金受取人名寄せ不明表示 */
     ztrtjtidouhaneikekkayobi01 ,         /* （取込用）当日異動内容反映結果予備０１ */
     kousinsyaId ,         /* 更新者ＩＤ */
     kousinTime ,         /* 更新時間 */
     kousinKinou ,         /* 更新機能 */
     version           /* バージョン */
FROM ZT_KykIdouHaneiKekkaTr_Z;